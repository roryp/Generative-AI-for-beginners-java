# Foundry Local Spring Boot Tutorial

## Innehållsförteckning

- [Förutsättningar](../../../../04-PracticalSamples/foundrylocal)
- [Projektöversikt](../../../../04-PracticalSamples/foundrylocal)
- [Förstå koden](../../../../04-PracticalSamples/foundrylocal)
  - [1. Applikationskonfiguration (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Huvudapplikationsklass (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI-tjänstelager (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Projektberoenden (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Hur allt fungerar tillsammans](../../../../04-PracticalSamples/foundrylocal)
- [Ställa in Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [Köra applikationen](../../../../04-PracticalSamples/foundrylocal)
- [Förväntad output](../../../../04-PracticalSamples/foundrylocal)
- [Nästa steg](../../../../04-PracticalSamples/foundrylocal)
- [Felsökning](../../../../04-PracticalSamples/foundrylocal)

## Förutsättningar

Innan du börjar med denna handledning, se till att du har:

- **Java 21 eller högre** installerat på ditt system
- **Maven 3.6+** för att bygga projektet
- **Foundry Local** installerat och igång

### **Installera Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## Projektöversikt

Detta projekt består av fyra huvudkomponenter:

1. **Application.java** - Huvudstartpunkten för Spring Boot-applikationen
2. **FoundryLocalService.java** - Tjänstelager som hanterar AI-kommunikation
3. **application.properties** - Konfiguration för anslutning till Foundry Local
4. **pom.xml** - Maven-beroenden och projektkonfiguration

## Förstå koden

### 1. Applikationskonfiguration (application.properties)

**Fil:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**Vad detta gör:**
- **base-url**: Anger var Foundry Local körs, inklusive `/v1`-sökvägen för OpenAI API-kompatibilitet. **Obs:** Foundry Local tilldelar dynamiskt en port, så kontrollera din faktiska port med `foundry service status`
- **model**: Namnger AI-modellen som ska användas för textgenerering, inklusive versionsnummer (t.ex. `:1`). Använd `foundry model list` för att se tillgängliga modeller med deras exakta ID:n

**Nyckelkoncept:** Spring Boot laddar automatiskt dessa egenskaper och gör dem tillgängliga för din applikation med hjälp av `@Value`-annoteringen.

### 2. Huvudapplikationsklass (Application.java)

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

**Vad detta gör:**
- `@SpringBootApplication` aktiverar Spring Boot-autokonfiguration
- `WebApplicationType.NONE` anger att detta är en kommandoradsapplikation, inte en webbserver
- Huvudmetoden startar Spring-applikationen

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

**Vad detta gör:**
- `@Bean` skapar en komponent som hanteras av Spring
- `CommandLineRunner` kör kod efter att Spring Boot har startat
- `foundryLocalService` injiceras automatiskt av Spring (beroendeinjektion)
- Skickar ett testmeddelande till AI och visar svaret

### 3. AI-tjänstelager (FoundryLocalService.java)

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

**Vad detta gör:**
- `@Service` anger att denna klass tillhandahåller affärslogik
- `@Value` injicerar konfigurationsvärden från application.properties
- Syntaxen `:default-value` ger reservvärden om egenskaper inte är inställda

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

**Vad detta gör:**
- `@PostConstruct` kör denna metod efter att Spring har skapat tjänsten
- Skapar en OpenAI-klient som pekar på din lokala Foundry Local-instans
- Bas-URL från `application.properties` inkluderar redan `/v1` för OpenAI API-kompatibilitet
- API-nyckeln är inställd på "not-needed" eftersom lokal utveckling inte kräver autentisering

#### Chatmetod:
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

**Vad detta gör:**
- **ChatCompletionCreateParams**: Konfigurerar AI-förfrågan
  - `model`: Anger vilken AI-modell som ska användas (måste matcha det exakta ID:t från `foundry model list`)
  - `addUserMessage`: Lägger till ditt meddelande i konversationen
  - `maxCompletionTokens`: Begränsar hur långt svaret kan vara (sparar resurser)
  - `temperature`: Styr slumpmässighet (0.0 = deterministisk, 1.0 = kreativ)
- **API-anrop**: Skickar förfrågan till Foundry Local
- **Svarshantering**: Extraherar AI:s textrespons säkert
- **Felkodning**: Omger undantag med hjälpsamma felmeddelanden

### 4. Projektberoenden (pom.xml)

**Viktiga beroenden:**

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

**Vad dessa gör:**
- **spring-boot-starter**: Tillhandahåller grundläggande Spring Boot-funktionalitet
- **openai-java**: Officiellt OpenAI Java SDK för API-kommunikation
- **jackson-databind**: Hanterar JSON-serialisering/deserialisering för API-anrop

## Hur allt fungerar tillsammans

Här är det kompletta flödet när du kör applikationen:

1. **Start**: Spring Boot startar och läser `application.properties`
2. **Tjänstskapande**: Spring skapar `FoundryLocalService` och injicerar konfigurationsvärden
3. **Klientinställning**: `@PostConstruct` initierar OpenAI-klienten för att ansluta till Foundry Local
4. **Demoexekvering**: `CommandLineRunner` körs efter start
5. **AI-anrop**: Demon anropar `foundryLocalService.chat()` med ett testmeddelande
6. **API-förfrågan**: Tjänsten bygger och skickar OpenAI-kompatibel förfrågan till Foundry Local
7. **Svarshantering**: Tjänsten extraherar och returnerar AI:s svar
8. **Visning**: Applikationen skriver ut svaret och avslutas

## Ställa in Foundry Local

För att ställa in Foundry Local, följ dessa steg:

1. **Installera Foundry Local** med instruktionerna i avsnittet [Förutsättningar](../../../../04-PracticalSamples/foundrylocal).

2. **Kontrollera den dynamiskt tilldelade porten**. Foundry Local tilldelar automatiskt en port när den startar. Hitta din port med:
   ```bash
   foundry service status
   ```
   
   **Valfritt**: Om du föredrar att använda en specifik port (t.ex. 5273), kan du konfigurera den manuellt:
   ```bash
   foundry service set --port 5273
   ```

3. **Ladda ner AI-modellen** du vill använda, till exempel `phi-3.5-mini`, med följande kommando:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **Konfigurera application.properties**-filen för att matcha dina Foundry Local-inställningar:
   - Uppdatera porten i `base-url` (från steg 2), och se till att den inkluderar `/v1` i slutet
   - Uppdatera modellnamnet för att inkludera versionsnumret (kontrollera med `foundry model list`)
   
   Exempel:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```

## Köra applikationen

### Steg 1: Starta Foundry Local
```bash
foundry model run phi-3.5-mini
```

### Steg 2: Bygg och kör applikationen
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Förväntad output

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

## Nästa steg

För fler exempel, se [Kapitel 04: Praktiska exempel](../README.md)

## Felsökning

### Vanliga problem

**"Connection refused" eller "Service unavailable"**
- Se till att Foundry Local körs: `foundry model list`
- Kontrollera den faktiska porten som Foundry Local använder: `foundry service status`
- Uppdatera din `application.properties` med rätt port, och se till att URL:en slutar med `/v1`
- Alternativt, ställ in en specifik port om så önskas: `foundry service set --port 5273`
- Försök starta om Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" eller "404 Not Found"-fel**
- Kontrollera tillgängliga modeller med deras exakta ID:n: `foundry model list`
- Uppdatera modellnamnet i `application.properties` så att det matchar exakt, inklusive versionsnumret (t.ex. `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Se till att `base-url` inkluderar `/v1` i slutet: `http://localhost:5273/v1`
- Ladda ner modellen om det behövs: `foundry model run phi-3.5-mini`

**"400 Bad Request"-fel**
- Kontrollera att bas-URL:en inkluderar `/v1`: `http://localhost:5273/v1`
- Kontrollera att modell-ID:t matchar exakt vad som visas i `foundry model list`
- Se till att du använder `maxCompletionTokens()` i din kod (inte den föråldrade `maxTokens()`)

**Maven-kompilationsfel**
- Se till att Java 21 eller högre är installerat: `java -version`
- Rensa och bygg om: `mvn clean compile`
- Kontrollera internetanslutningen för att ladda ner beroenden

**Applikationen startar men ingen output**
- Kontrollera att Foundry Local svarar: Kontrollera `http://localhost:5273/v1/models` eller kör `foundry service status`
- Kontrollera applikationsloggar för specifika felmeddelanden
- Se till att modellen är fullt laddad och redo

---

**Ansvarsfriskrivning**:  
Detta dokument har översatts med hjälp av AI-översättningstjänsten [Co-op Translator](https://github.com/Azure/co-op-translator). Även om vi strävar efter noggrannhet, bör det noteras att automatiserade översättningar kan innehålla fel eller felaktigheter. Det ursprungliga dokumentet på dess ursprungliga språk bör betraktas som den auktoritativa källan. För kritisk information rekommenderas professionell mänsklig översättning. Vi ansvarar inte för eventuella missförstånd eller feltolkningar som uppstår vid användning av denna översättning.