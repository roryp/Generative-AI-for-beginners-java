# Foundry Local Spring Boot Tutorial

## Table of Contents

- [Forudsætninger](#forudsætninger)
- [Projektoversigt](#projektoversigt)
- [Forstå koden](#forstå-koden)
  - [1. Applikationskonfiguration (application.properties)](#1-applikationskonfiguration-applicationproperties)
  - [2. Hovedapplikationsklasse (Application.java)](#2-hovedapplikationsklasse-applicationjava)
  - [3. AI Service Lag (FoundryLocalService.java)](#3-ai-service-lag-foundrylocalservicejava)
  - [4. Projekt Afhængigheder (pom.xml)](#4-projekt-afhængigheder-pomxml)
- [Hvordan det hele fungerer sammen](#hvordan-det-hele-fungerer-sammen)
- [Opsætning af Foundry Local](#opsætning-af-foundry-local)
- [Kørsel af applikationen](#kørsel-af-applikationen)
- [Forventet output](#forventet-output)
- [Næste skridt](#næste-skridt)
- [Fejlfinding](#fejlfinding)


## Forudsætninger

Før du starter denne tutorial, skal du sikre dig, at du har:

- **Java 21 eller højere** installeret på dit system
- **Maven 3.6+** til at bygge projektet
- **Foundry Local** installeret og kørende

### **Installer Foundry Local:**

> **Note:** Foundry Local CLI er kun tilgængelig på **Windows** og **macOS**. Linux understøttes via [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Bekræft installationen:
```bash
foundry --version
```

## Projektoversigt

Dette projekt består af fire hovedkomponenter:

1. **Application.java** - Hovedindgangspunkt for Spring Boot applikationen
2. **FoundryLocalService.java** - Servicelag, der håndterer AI-kommunikation
3. **application.properties** - Konfiguration for Foundry Local forbindelse
4. **pom.xml** - Maven afhængigheder og projektkonfiguration

## Forstå koden

### 1. Applikationskonfiguration (application.properties)

**Fil:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Hvad dette gør:**
- **base-url**: Angiver hvor Foundry Local kører, inklusive `/v1` sti for OpenAI API kompatibilitet. Standardporten er `5273`. Hvis porten er anderledes, kontroller den med `foundry service status`.
- **model** (valgfri): Navngiver hvilken AI-model der skal bruges til tekstgenerering. **Som standard opdager applikationen automatisk modellen** ved at forespørge Foundry Local `/v1/models` endpoint ved opstart, så det er ikke nødvendigt at sætte denne. Du kan dog sætte den eksplicit for at tilsidesætte automatisk detektion hvis nødvendigt.

**Nøglekoncept:** Spring Boot loader automatisk disse properties og gør dem tilgængelige for din applikation via `@Value` annotationen.

### 2. Hovedapplikationsklasse (Application.java)

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

**Hvad dette gør:**
- `@SpringBootApplication` aktiverer Spring Boots auto-konfiguration
- `WebApplicationType.NONE` fortæller Spring, at dette er en kommandolinjeapp, ikke en webserver
- Main metoden starter Spring applikationen

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

**Hvad dette gør:**
- `@Bean` opretter en komponent som Spring styrer
- `CommandLineRunner` kører kode efter Spring Boot starter op
- `foundryLocalService` injiceres automatisk af Spring (dependency injection)
- Sender en testbesked til AI'en og viser svaret

### 3. AI Service Lag (FoundryLocalService.java)

**Fil:** `src/main/java/com/example/FoundryLocalService.java`

#### Konfigurationsinjektion:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Automatisk registreret, hvis tom
```

**Hvad dette gør:**
- `@Service` fortæller Spring, at denne klasse leverer forretningslogik
- `@Value` injicerer konfigurationsværdier fra application.properties
- Modellen defaultes til tom, hvilket udløser **auto-detektion** fra Foundry Local ved opstart. Det betyder, at appen fungerer med enhver model, der er loaded i Foundry Local uden manuel konfiguration.

#### Klientinitialisering:
```java
@PostConstruct
public void init() {
    // Automatisk detektering af modellen fra Foundry Local, hvis ikke eksplicit konfigureret
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Basis-URL inkluderer allerede /v1 fra konfigurationen
            .apiKey("not-needed")            // Lokal server behøver ikke reel API-nøgle
            .build();
}
```

**Hvad dette gør:**
- `@PostConstruct` kører denne metode efter Spring har oprettet servicen
- Hvis ingen model er konfigureret, forespørger den Foundry Local's `/v1/models` endpoint og vælger den første loaded model
- Opretter en OpenAI klient, der peger på din lokale Foundry Local instans
- Base URL fra `application.properties` inkluderer allerede `/v1` for OpenAI API kompatibilitet
- API nøglen sættes til "not-needed", fordi lokal udvikling ikke kræver autentificering

#### Chat metode:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Hvilken AI-model der skal bruges
                .addUserMessage(message)         // Dit spørgsmål/opfordring
                .maxCompletionTokens(150)        // Begræns svarlængde
                .temperature(0.7)                // Kontroller kreativitet (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Udtræk AI'ens svar fra API-resultatet
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Hvad dette gør:**
- **ChatCompletionCreateParams**: Konfigurerer AI forespørgslen
  - `model`: Angiver hvilken AI model der skal bruges (skal matche det præcise ID fra `foundry model list`)
  - `addUserMessage`: Tilføjer din besked til samtalen
  - `maxCompletionTokens`: Begrænser hvor langt svaret kan være (spar på ressourcer)
  - `temperature`: Styrer tilfældighed (0.0 = deterministisk, 1.0 = kreativ)
- **API Kald**: Sender forespørgslen til Foundry Local
- **Responsbehandling**: Ekstraherer AI'ens tekstsvar sikkert
- **Fejlhåndtering**: Pakker undtagelser med hjælpsomme fejlmeddelelser ind

### 4. Projekt Afhængigheder (pom.xml)

**Nøgleafhængigheder:**

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

**Hvad disse gør:**
- **spring-boot-starter**: Giver kernefunktionalitet til Spring Boot
- **openai-java**: Officiel OpenAI Java SDK til API kommunikation
- **jackson-databind**: Håndterer JSON serialisering/deserialisering til API kald

## Hvordan det hele fungerer sammen

Her er den komplette flow, når du kører applikationen:

1. **Opstart**: Spring Boot starter og læser `application.properties`
2. **Service Oprettelse**: Spring opretter `FoundryLocalService` og injicerer konfigurationsværdier
3. **Model Detektion**: Hvis ingen model er konfigureret, forespørger servicen Foundry Local's `/v1/models` endpoint og bruger automatisk den første tilgængelige model
4. **Klientopsætning**: `@PostConstruct` initialiserer OpenAI klienten for at forbinde til Foundry Local
5. **Demo Eksekvering**: `CommandLineRunner` kører efter opstart
6. **AI Kald**: Demoen kalder `foundryLocalService.chat()` med en testbesked
7. **API Forespørgsel**: Servicen bygger og sender OpenAI-kompatibel forespørgsel til Foundry Local
8. **Responsbehandling**: Servicen ekstraherer og returnerer AI'ens svar
9. **Visning**: Applikationen printer svaret og afslutter

## Opsætning af Foundry Local

1. **Installer Foundry Local** ved hjælp af instruktionerne i [Forudsætninger](#forudsætninger) sektionen.

2. **Start servicen** (hvis den ikke allerede kører):
   ```bash
   foundry service start
   ```

3. **Tjek service status** for at bekræfte, at den kører og noter porten:
   ```bash
   foundry service status
   ```

4. **Download og kør en model** (downloades ved første kørsel, cached til efterfølgende kørsel):
   ```bash
   foundry model run phi-4-mini
   ```
   Dette åbner en interaktiv chatsession. Du kan afslutte med `Ctrl+C`. Modellen forbliver loaded i servicen.

   > **Tip:** Kør `foundry model list` for at se alle tilgængelige modeller. Erstat `phi-4-mini` med en hvilken som helst alias fra kataloget (fx `qwen2.5-0.5b` for en mindre/hurtigere model).

5. **Bekræft at modellen er loaded:**
   ```bash
   foundry service ps
   ```

6. **Opdater `application.properties`** hvis nødvendigt:
   - Standard `base-url` (`http://localhost:5273/v1`) matcher standard CLI porten. Opdater kun, hvis `foundry service status` viser en anden port.
   - Modellen detekteres **automatisk** ved opstart — ingen konfiguration nødvendig.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Kørsel af applikationen

### Trin 1: Sørg for at en model er loaded i Foundry Local
```bash
foundry service ps
```
Hvis ingen modeller er listet, load en:
```bash
foundry model run phi-4-mini
```

### Trin 2: Byg og kør applikationen
I en separat terminal:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Eller byg og kør som en JAR:
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

## Næste skridt

For flere eksempler, se [Kapitel 04: Praktiske eksempler](../README.md)

## Fejlfinding

### Almindelige problemer

**"Connection refused" eller "Service unavailable"**
- Tjek servicen: `foundry service status`
- Genstart om nødvendigt: `foundry service restart`
- Bekræft at porten i `application.properties` matcher output fra `foundry service status`
- Sørg for at URL'en ender med `/v1`: `http://localhost:5273/v1`

**"No model found" ved opstart**
- Applikationen opdager modellen automatisk. Sørg for mindst én model er loaded: `foundry service ps`
- Hvis ingen modeller er loaded: `foundry model run phi-4-mini`
- Hvis du har tilsidesat modelnavnet i `application.properties`, skal du sikre dig, at det matcher `foundry model list`

**"400 Bad Request" fejl**
- Bekræft at base URL inkluderer `/v1`: `http://localhost:5273/v1`
- Sørg for at du bruger `maxCompletionTokens()` i din kode (ikke den forældede `maxTokens()`)

**Maven compilationsfejl**
- Sørg for Java 21 eller højere: `java -version`
- Clean og genbyg: `mvn clean compile`
- Tjek internetforbindelse for download af afhængigheder

**Serviceforbindelsesproblemer**
- Hvis du ser `Request to local service failed`, kør: `foundry service restart`
- Tjek loaded modeller: `foundry service ps`
- Se service logs: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Ansvarsfraskrivelse**:  
Dette dokument er blevet oversat ved hjælp af AI-oversættelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selvom vi stræber efter nøjagtighed, bedes du være opmærksom på, at automatiske oversættelser kan indeholde fejl eller unøjagtigheder. Det oprindelige dokument på dets modersmål bør betragtes som den autoritative kilde. For vigtig information anbefales professionel menneskelig oversættelse. Vi påtager os intet ansvar for misforståelser eller fejltolkninger, der måtte opstå som følge af brugen af denne oversættelse.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->