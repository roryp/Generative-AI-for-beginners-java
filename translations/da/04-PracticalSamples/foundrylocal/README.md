# Foundry Local Spring Boot Tutorial

## Indholdsfortegnelse

- [Forudsætninger](../../../../04-PracticalSamples/foundrylocal)
- [Projektoversigt](../../../../04-PracticalSamples/foundrylocal)
- [Forstå koden](../../../../04-PracticalSamples/foundrylocal)
  - [1. Applikationskonfiguration (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Hovedapplikationsklasse (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI Service-lag (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Projektafhængigheder (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Hvordan det hele fungerer sammen](../../../../04-PracticalSamples/foundrylocal)
- [Opsætning af Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [Kørsel af applikationen](../../../../04-PracticalSamples/foundrylocal)
- [Forventet output](../../../../04-PracticalSamples/foundrylocal)
- [Næste skridt](../../../../04-PracticalSamples/foundrylocal)
- [Fejlfinding](../../../../04-PracticalSamples/foundrylocal)

## Forudsætninger

Før du starter denne tutorial, skal du sikre dig, at du har:

- **Java 21 eller nyere** installeret på dit system
- **Maven 3.6+** til at bygge projektet
- **Foundry Local** installeret og kørende

### **Installer Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```


## Projektoversigt

Dette projekt består af fire hovedkomponenter:

1. **Application.java** - Hovedindgangspunktet for Spring Boot-applikationen
2. **FoundryLocalService.java** - Service-lag, der håndterer AI-kommunikation
3. **application.properties** - Konfiguration for Foundry Local-forbindelse
4. **pom.xml** - Maven-afhængigheder og projektkonfiguration

## Forstå koden

### 1. Applikationskonfiguration (application.properties)

**Fil:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**Hvad dette gør:**
- **base-url**: Angiver, hvor Foundry Local kører, inklusive `/v1`-stien for OpenAI API-kompatibilitet. **Bemærk**: Foundry Local tildeler dynamisk en port, så tjek din faktiske port med `foundry service status`
- **model**: Navngiver AI-modellen, der skal bruges til tekstgenerering, inklusive versionsnummeret (f.eks. `:1`). Brug `foundry model list` for at se tilgængelige modeller med deres præcise ID'er

**Nøglekoncept:** Spring Boot indlæser automatisk disse egenskaber og gør dem tilgængelige for din applikation ved hjælp af `@Value`-annotationen.

### 2. Hovedapplikationsklasse (Application.java)

**Fil:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```


**Hvad dette gør:**
- `@SpringBootApplication` aktiverer Spring Boot auto-konfiguration
- `WebApplicationType.NONE` fortæller Spring, at dette er en kommandolinjeapplikation, ikke en webserver
- Hovedmetoden starter Spring-applikationen

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
- `@Bean` opretter en komponent, som Spring administrerer
- `CommandLineRunner` kører kode efter Spring Boot er startet
- `foundryLocalService` injiceres automatisk af Spring (afhængighedsinjektion)
- Sender en testbesked til AI og viser svaret

### 3. AI Service-lag (FoundryLocalService.java)

**Fil:** `src/main/java/com/example/FoundryLocalService.java`

#### Konfigurationsinjektion:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**Hvad dette gør:**
- `@Service` fortæller Spring, at denne klasse leverer forretningslogik
- `@Value` injicerer konfigurationsværdier fra application.properties
- `:default-value`-syntaksen giver standardværdier, hvis egenskaber ikke er angivet

#### Klientinitialisering:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```


**Hvad dette gør:**
- `@PostConstruct` kører denne metode, efter Spring har oprettet servicen
- Opretter en OpenAI-klient, der peger på din lokale Foundry Local-instans
- Base-URL'en fra `application.properties` inkluderer allerede `/v1` for OpenAI API-kompatibilitet
- API-nøglen er sat til "not-needed", da lokal udvikling ikke kræver autentifikation

#### Chat-metode:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Which AI model to use
                .addUserMessage(message)         // Your question/prompt
                .maxCompletionTokens(150)        // Limit response length
                .temperature(0.7)                // Control creativity (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extract the AI's response from the API result
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
- **ChatCompletionCreateParams**: Konfigurerer AI-anmodningen
  - `model`: Angiver, hvilken AI-model der skal bruges (skal matche det præcise ID fra `foundry model list`)
  - `addUserMessage`: Tilføjer din besked til samtalen
  - `maxCompletionTokens`: Begrænser, hvor langt svaret kan være (spar ressourcer)
  - `temperature`: Styrer tilfældighed (0.0 = deterministisk, 1.0 = kreativ)
- **API-anrop**: Sender anmodningen til Foundry Local
- **Svarhåndtering**: Udtrækker AI's tekstsvar sikkert
- **Fejlhåndtering**: Pakker undtagelser med nyttige fejlmeddelelser

### 4. Projektafhængigheder (pom.xml)

**Vigtige afhængigheder:**

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
- **openai-java**: Officiel OpenAI Java SDK til API-kommunikation
- **jackson-databind**: Håndterer JSON-serialisering/deserialisering til API-anmodninger

## Hvordan det hele fungerer sammen

Her er den komplette proces, når du kører applikationen:

1. **Opstart**: Spring Boot starter og læser `application.properties`
2. **Serviceoprettelse**: Spring opretter `FoundryLocalService` og injicerer konfigurationsværdier
3. **Klientopsætning**: `@PostConstruct` initialiserer OpenAI-klienten til at forbinde til Foundry Local
4. **Demo-udførelse**: `CommandLineRunner` kører efter opstart
5. **AI-anrop**: Demoen kalder `foundryLocalService.chat()` med en testbesked
6. **API-anmodning**: Servicen bygger og sender en OpenAI-kompatibel anmodning til Foundry Local
7. **Svarbehandling**: Servicen udtrækker og returnerer AI's svar
8. **Visning**: Applikationen udskriver svaret og afslutter

## Opsætning af Foundry Local

For at opsætte Foundry Local skal du følge disse trin:

1. **Installer Foundry Local** ved hjælp af instruktionerne i [Forudsætninger](../../../../04-PracticalSamples/foundrylocal)-sektionen.

2. **Tjek den dynamisk tildelte port**. Foundry Local tildeler automatisk en port, når det starter. Find din port med:
   ```bash
   foundry service status
   ```
   
   **Valgfrit**: Hvis du foretrækker at bruge en specifik port (f.eks. 5273), kan du konfigurere den manuelt:
   ```bash
   foundry service set --port 5273
   ```


3. **Download AI-modellen**, du vil bruge, f.eks. `phi-3.5-mini`, med følgende kommando:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **Konfigurer application.properties**-filen, så den matcher dine Foundry Local-indstillinger:
   - Opdater porten i `base-url` (fra trin 2), og sørg for, at den inkluderer `/v1` til sidst
   - Opdater modelnavnet, så det inkluderer versionsnummeret (tjek med `foundry model list`)
   
   Eksempel:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## Kørsel af applikationen

### Trin 1: Start Foundry Local
```bash
foundry model run phi-3.5-mini
```


### Trin 2: Byg og kør applikationen
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
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```


## Næste skridt

For flere eksempler, se [Kapitel 04: Praktiske eksempler](../README.md)

## Fejlfinding

### Almindelige problemer

**"Connection refused" eller "Service unavailable"**
- Sørg for, at Foundry Local kører: `foundry model list`
- Tjek den faktiske port, Foundry Local bruger: `foundry service status`
- Opdater din `application.properties` med den korrekte port, og sørg for, at URL'en slutter med `/v1`
- Alternativt kan du indstille en specifik port, hvis det ønskes: `foundry service set --port 5273`
- Prøv at genstarte Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" eller "404 Not Found"-fejl**
- Tjek tilgængelige modeller med deres præcise ID'er: `foundry model list`
- Opdater modelnavnet i `application.properties`, så det matcher præcist, inklusive versionsnummeret (f.eks. `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Sørg for, at `base-url` inkluderer `/v1` til sidst: `http://localhost:5273/v1`
- Download modellen, hvis nødvendigt: `foundry model run phi-3.5-mini`

**"400 Bad Request"-fejl**
- Bekræft, at base-URL'en inkluderer `/v1`: `http://localhost:5273/v1`
- Tjek, at model-ID'et matcher præcist, hvad der vises i `foundry model list`
- Sørg for, at du bruger `maxCompletionTokens()` i din kode (ikke den forældede `maxTokens()`)

**Maven-kompilationsfejl**
- Sørg for Java 21 eller nyere: `java -version`
- Rens og genopbyg: `mvn clean compile`
- Tjek internetforbindelsen for afhængighedsdownloads

**Applikationen starter, men der er ingen output**
- Bekræft, at Foundry Local svarer: Tjek `http://localhost:5273/v1/models` eller kør `foundry service status`
- Tjek applikationslogfiler for specifikke fejlmeddelelser
- Sørg for, at modellen er fuldt indlæst og klar

---

**Ansvarsfraskrivelse**:  
Dette dokument er blevet oversat ved hjælp af AI-oversættelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selvom vi bestræber os på nøjagtighed, skal det bemærkes, at automatiserede oversættelser kan indeholde fejl eller unøjagtigheder. Det originale dokument på dets oprindelige sprog bør betragtes som den autoritative kilde. For kritisk information anbefales professionel menneskelig oversættelse. Vi er ikke ansvarlige for eventuelle misforståelser eller fejltolkninger, der opstår som følge af brugen af denne oversættelse.