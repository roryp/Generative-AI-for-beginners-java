# Foundry Lokal Spring Boot Veiledning

## Innholdsfortegnelse

- [Forutsetninger](#forutsetninger)
- [Prosjektoversikt](#prosjektoversikt)
- [Forstå koden](#forstå-koden)
  - [1. Applikasjonskonfigurasjon (application.properties)](#1-applikasjonskonfigurasjon-applicationproperties)
  - [2. Hovedapplikasjonsklasse (Application.java)](#2-hovedapplikasjonsklasse-applicationjava)
  - [3. AI Tjenestelag (FoundryLocalService.java)](#3-ai-tjenestelag-foundrylocalservicejava)
  - [4. Prosjektavhengigheter (pom.xml)](#4-prosjektavhengigheter-pomxml)
- [Hvordan alt fungerer sammen](#hvordan-alt-fungerer-sammen)
- [Oppsett av Foundry Local](#oppsett-av-foundry-local)
- [Kjøre applikasjonen](#kjøre-applikasjonen)
- [Forventet output](#forventet-output)
- [Neste steg](#neste-steg)
- [Feilsøking](#feilsøking)


## Forutsetninger

Før du starter denne veiledningen, sørg for at du har:

- **Java 21 eller høyere** installert på systemet ditt
- **Maven 3.6+** for å bygge prosjektet
- **Foundry Local** installert og kjørende

### **Installer Foundry Local:**

> **Merk:** Foundry Local CLI er tilgjengelig kun på **Windows** og **macOS**. Linux støttes via [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Verifiser installasjonen:
```bash
foundry --version
```

## Prosjektoversikt

Dette prosjektet består av fire hovedkomponenter:

1. **Application.java** - Hovedinngangspunktet for Spring Boot-applikasjonen
2. **FoundryLocalService.java** - Tjenestelaget som håndterer AI-kommunikasjon
3. **application.properties** - Konfigurasjon for Foundry Local-tilkobling
4. **pom.xml** - Maven-avhengigheter og prosjektkonfigurasjon

## Forstå koden

### 1. Applikasjonskonfigurasjon (application.properties)

**Fil:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Hva dette gjør:**
- **base-url**: Spesifiserer hvor Foundry Local kjører, inkludert `/v1`-banen for OpenAI API-kompatibilitet. Standard port er `5273`. Hvis porten er annerledes, sjekk den med `foundry service status`.
- **model** (valgfritt): Navngir AI-modellen som skal brukes til tekstgenerering. **Som standard oppdager applikasjonen modellen automatisk** ved å spørre Foundry Local `/v1/models`-endepunkt ved oppstart, så du trenger ikke å angi dette. Du kan likevel angi det eksplisitt for å overstyre automatisk deteksjon om nødvendig.

**Nøkkelkonsept:** Spring Boot laster automatisk inn disse egenskapene og gjør dem tilgjengelige for applikasjonen din ved bruk av `@Value`-annotasjonen.

### 2. Hovedapplikasjonsklasse (Application.java)

**Fil:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Ingen webserver nødvendig
        app.run(args);
    }
```

**Hva dette gjør:**
- `@SpringBootApplication` aktiverer Spring Boot auto-konfigurasjon
- `WebApplicationType.NONE` forteller Spring at dette er en kommandolinjeapplikasjon, ikke en webserver
- main-metoden starter Spring-applikasjonen

**Demo Runner:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        System.out.println("Calling Foundry Local service...");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
        System.out.println("=========================");
    };
}
```

**Hva dette gjør:**
- `@Bean` oppretter en komponent som Spring håndterer
- `CommandLineRunner` kjører kode etter at Spring Boot har startet opp
- `foundryLocalService` injiseres automatisk av Spring (dependency injection)
- Sender en testmelding til AI-en og viser svaret

### 3. AI Tjenestelag (FoundryLocalService.java)

**Fil:** `src/main/java/com/example/FoundryLocalService.java`

#### Konfigurasjonsinjeksjon:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Automatisk oppdaget hvis tom
```

**Hva dette gjør:**
- `@Service` forteller Spring at denne klassen leverer forretningslogikk
- `@Value` injiserer konfigurasjonsverdier fra application.properties
- Modellen er som standard tom, noe som utløser **automatisk deteksjon** fra Foundry Local ved oppstart. Dette gjør at appen fungerer med hvilken som helst modell lastet i Foundry Local uten manuell konfigurasjon.

#### Klientinitialisering:
```java
@PostConstruct
public void init() {
    // Automatisk oppdage modellen fra Foundry Local hvis ikke eksplisitt konfigurert
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Grunnleggende URL inkluderer allerede /v1 fra konfigurasjonen
            .apiKey("not-needed")            // Lokal server trenger ikke ekte API-nøkkel
            .build();
}
```

**Hva dette gjør:**
- `@PostConstruct` kjører denne metoden etter at Spring har opprettet servicen
- Hvis ingen modell er konfigurert, spør den Foundry Locals `/v1/models`-endepunkt og velger den første tilgjengelige modellen
- Oppretter en OpenAI-klient som peker til din lokale Foundry Local-instans
- Base-URL-en fra `application.properties` inkluderer allerede `/v1` for OpenAI API-kompatibilitet
- API-nøkkelen settes til "not-needed" fordi lokal utvikling ikke krever autentisering

#### Chat-metoden:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Hvilken AI-modell som skal brukes
                .addUserMessage(message)         // Ditt spørsmål/prompt
                .maxCompletionTokens(150)        // Begrens svarlengde
                .temperature(0.7)                // Kontroller kreativitet (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Hent ut AI-ens svar fra API-resultatet
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Hva dette gjør:**
- **ChatCompletionCreateParams**: Konfigurerer AI-forespørselen
  - `model`: Spesifiserer hvilken AI-modell som skal brukes (må samsvare med eksakt ID fra `foundry model list`)
  - `addUserMessage`: Legger til meldingen din i samtalen
  - `maxCompletionTokens`: Begrenser hvor lang responsen kan bli (spar på ressurser)
  - `temperature`: Styrer tilfeldighet (0.0 = deterministisk, 1.0 = kreativ)
- **API-kall**: Sender forespørselen til Foundry Local
- **Responsbehandling**: Henter AI-ens tekstsvar trygt
- **Feilhåndtering**: Pakker unntak med hjelpsomme feilmeldinger

### 4. Prosjektavhengigheter (pom.xml)

**Nøkkelavhengigheter:**

```xml
<!-- Spring Boot - Application framework -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>${spring-boot.version}</version>
</dependency>

<!-- OpenAI Java SDK - For AI API calls -->
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>

<!-- Jackson - JSON processing -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.0</version>
</dependency>
```

**Hva disse gjør:**
- **spring-boot-starter**: Tilbyr kjernefunksjonalitet for Spring Boot
- **openai-java**: Offisiell OpenAI Java SDK for API-kommunikasjon
- **jackson-databind**: Håndterer JSON-serialisering/deserialisering for API-kall

## Hvordan alt fungerer sammen

Her er den komplette flyten når du kjører applikasjonen:

1. **Oppstart**: Spring Boot starter og leser `application.properties`
2. **Service-opprettelse**: Spring oppretter `FoundryLocalService` og injiserer konfigurasjonsverdier
3. **Modell-detektering**: Hvis ingen modell er konfigurert, spør servicen Foundry Locals `/v1/models`-endepunkt og bruker automatisk den første tilgjengelige modellen
4. **Klientoppsett**: `@PostConstruct` initialiserer OpenAI-klienten for å koble til Foundry Local
5. **Demo-eksekvering**: `CommandLineRunner` kjører etter oppstart
6. **AI-kall**: Demoen kaller `foundryLocalService.chat()` med en testmelding
7. **API-forespørsel**: Servicen bygger og sender en OpenAI-kompatibel forespørsel til Foundry Local
8. **Responsbehandling**: Servicen henter ut og returnerer AI-ens respons
9. **Visning**: Applikasjonen skriver ut responsen og avslutter

## Oppsett av Foundry Local

1. **Installer Foundry Local** ved å følge instruksjonene under [Forutsetninger](#forutsetninger).

2. **Start tjenesten** (hvis den ikke allerede kjører):
   ```bash
   foundry service start
   ```

3. **Sjekk tjenestestatus** for å bekrefte at den kjører og noter porten:
   ```bash
   foundry service status
   ```

4. **Last ned og kjør en modell** (lastes ned første gang, hurtigbuffer for senere kjøringer):
   ```bash
   foundry model run phi-4-mini
   ```
   Dette åpner en interaktiv chat-økt. Du kan avslutte med `Ctrl+C`. Modellen forblir lastet i tjenesten.

   > **Tips:** Kjør `foundry model list` for å se alle tilgjengelige modeller. Erstatt `phi-4-mini` med et hvilket som helst alias fra katalogen (f.eks. `qwen2.5-0.5b` for en mindre/raskere modell).

5. **Verifiser at modellen er lastet:**
   ```bash
   foundry service ps
   ```

6. **Oppdater `application.properties`** hvis nødvendig:
   - Standard `base-url` (`http://localhost:5273/v1`) matcher standard CLI-port. Oppdater kun hvis `foundry service status` viser en annen port.
   - Modellen blir **automatisk oppdaget** ved oppstart — ingen konfigurasjon nødvendig.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Kjøre applikasjonen

### Steg 1: Sørg for at en modell er lastet i Foundry Local
```bash
foundry service ps
```
Hvis ingen modeller er oppført, last inn en:
```bash
foundry model run phi-4-mini
```

### Steg 2: Bygg og kjør applikasjonen
I et eget terminalvindu:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Eller bygg og kjør som JAR:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Forventet output

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## Neste steg

For flere eksempler, se [Kapittel 04: Praktiske eksempler](../README.md)

## Feilsøking

### Vanlige problemer

**"Connection refused" eller "Service unavailable"**
- Sjekk tjenesten: `foundry service status`
- Start på nytt om nødvendig: `foundry service restart`
- Verifiser at porten i `application.properties` stemmer med `foundry service status`-utskriften
- Sørg for at URL-en slutter med `/v1`: `http://localhost:5273/v1`

**"No model found" ved oppstart**
- Applikasjonen oppdager modellen automatisk. Sørg for at minst en modell er lastet: `foundry service ps`
- Hvis ingen modeller er lastet: `foundry model run phi-4-mini`
- Hvis du har overstyrt modellnavnet i `application.properties`, sjekk at det samsvarer med `foundry model list`

**"400 Bad Request" feil**
- Verifiser at basis-URL inneholder `/v1`: `http://localhost:5273/v1`
- Sørg for at du bruker `maxCompletionTokens()` i koden din (ikke den utdaterte `maxTokens()`)

**Maven kompilasjonsfeil**
- Sørg for at Java 21 eller høyere er installert: `java -version`
- Rens og bygg på nytt: `mvn clean compile`
- Sjekk internettforbindelsen for nedlasting av avhengigheter

**Problemer med tjenestetilkobling**
- Hvis du ser `Request to local service failed`, kjør: `foundry service restart`
- Sjekk lastede modeller: `foundry service ps`
- Se tjenesteloggene: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Ansvarsfraskrivelse**:
Dette dokumentet er oversatt ved hjelp av AI-oversettelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selv om vi streber etter nøyaktighet, vennligst vær oppmerksom på at automatiske oversettelser kan inneholde feil eller unøyaktigheter. Det opprinnelige dokumentet på dets morsmål skal anses som den autoritative kilden. For kritisk informasjon anbefales profesjonell menneskelig oversettelse. Vi er ikke ansvarlige for eventuelle misforståelser eller feiltolkninger som oppstår fra bruken av denne oversettelsen.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->