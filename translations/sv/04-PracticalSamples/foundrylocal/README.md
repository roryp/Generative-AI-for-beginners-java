# Foundry Local Spring Boot-handledning

## Innehållsförteckning

- [Förutsättningar](#förutsättningar)
- [Projektöversikt](#projektöversikt)
- [Förstå koden](#förstå-koden)
  - [1. Applikationskonfiguration (application.properties)](#1-applikationskonfiguration-applicationproperties)
  - [2. Huvudapplikationsklass (Application.java)](#2-huvudapplikationsklass-applicationjava)
  - [3. AI-tjänstelager (FoundryLocalService.java)](#3-ai-tjänstelager-foundrylocalservicejava)
  - [4. Projektberoenden (pom.xml)](#4-projektberoenden-pomxml)
- [Hur allt fungerar tillsammans](#hur-allt-fungerar-tillsammans)
- [Ställa in Foundry Local](#ställa-in-foundry-local)
- [Köra applikationen](#köra-applikationen)
- [Förväntad utdata](#förväntad-utdata)
- [Nästa steg](#nästa-steg)
- [Felsökning](#felsökning)


## Förutsättningar

Innan du börjar den här handledningen, se till att du har:

- **Java 21 eller högre** installerat på ditt system
- **Maven 3.6+** för att bygga projektet
- **Foundry Local** installerat och igång

### **Installera Foundry Local:**

> **Notera:** Foundry Local CLI finns endast tillgängligt för **Windows** och **macOS**. Linux stöds via [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Verifiera installationen:
```bash
foundry --version
```

## Projektöversikt

Det här projektet består av fyra huvudkomponenter:

1. **Application.java** - Huvudentrén för Spring Boot-applikationen
2. **FoundryLocalService.java** - Tjänstelager som hanterar AI-kommunikation
3. **application.properties** - Konfiguration för Foundry Local-anslutningen
4. **pom.xml** - Maven beroenden och projektkonfiguration

## Förstå koden

### 1. Applikationskonfiguration (application.properties)

**Fil:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Vad detta gör:**
- **base-url**: Anger var Foundry Local körs, inklusive `/v1`-sökvägen för OpenAI API-kompatibilitet. Standardport är `5273`. Om porten skiljer sig, kontrollera den med `foundry service status`.
- **model** (valfritt): Namnger AI-modellen som ska användas för textgenerering. **Som standard upptäcker applikationen modellen automatiskt** genom att fråga Foundry Local's `/v1/models`-endpoint vid uppstart, så du behöver inte ange den. Du kan fortfarande ange den explicit för att åsidosätta automatisk upptäckt vid behov.

**Nyckelkoncept:** Spring Boot laddar automatiskt dessa egenskaper och gör dem tillgängliga för din applikation via `@Value`-annoteringen.

### 2. Huvudapplikationsklass (Application.java)

**Fil:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Ingen webbserver behövs
        app.run(args);
    }
```

**Vad detta gör:**
- `@SpringBootApplication` möjliggör Spring Boot auto-konfiguration
- `WebApplicationType.NONE` talar om för Spring att detta är en kommandoradsapp, inte en webbserver
- Huvudmetoden startar Spring-applikationen

**Demoköraren:**
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
- `@Bean` skapar en komponent som Spring hanterar
- `CommandLineRunner` kör kod efter att Spring Boot har startat
- `foundryLocalService` injiceras automatiskt av Spring (beroendeinjektion)
- Skickar ett testmeddelande till AI:n och visar svaret

### 3. AI-tjänstelager (FoundryLocalService.java)

**Fil:** `src/main/java/com/example/FoundryLocalService.java`

#### Konfigurationsinjektion:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Auto-upptäckt om tom
```

**Vad detta gör:**
- `@Service` talar om för Spring att denna klass tillhandahåller affärslogik
- `@Value` injicerar konfigurationsvärden från application.properties
- Modellen sätts som tom som standard, vilket triggar **automatisk upptäckt** från Foundry Local vid uppstart. Det innebär att appen fungerar med vilken modell som helst som är inläst i Foundry Local utan manuell konfiguration.

#### Klientinitiering:
```java
@PostConstruct
public void init() {
    // Auto-upptäck modellen från Foundry Local om den inte uttryckligen är konfigurerad
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Bas-URL innehåller redan /v1 från konfigurationen
            .apiKey("not-needed")            // Lokal server behöver inte riktig API-nyckel
            .build();
}
```

**Vad detta gör:**
- `@PostConstruct` kör denna metod efter att Spring skapat tjänsten
- Om ingen modell är konfigurerad frågar den Foundry Local’s `/v1/models`-endpoint och väljer den första inlästa modellen
- Skapar en OpenAI-klient som pekar på din lokala Foundry Local-instans
- Bas-URL:en från `application.properties` inkluderar redan `/v1` för OpenAI API-kompatibilitet
- API-nyckeln sätts till "not-needed" eftersom lokal utveckling inte kräver autentisering

#### Chattmetod:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Vilken AI-modell som ska användas
                .addUserMessage(message)         // Din fråga/prompt
                .maxCompletionTokens(150)        // Begränsa svarslängd
                .temperature(0.7)                // Kontrollera kreativitet (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extrahera AI:s svar från API-resultatet
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
  - `model`: Specificerar vilken AI-modell som ska användas (måste matcha exakt ID från `foundry model list`)
  - `addUserMessage`: Lägger till ditt meddelande i konversationen
  - `maxCompletionTokens`: Begränsar hur långt svaret kan vara (sparar resurser)
  - `temperature`: Kontrollerar slumpmässighet (0.0 = deterministisk, 1.0 = kreativ)
- **API-anrop**: Skickar förfrågan till Foundry Local
- **Svarshantering**: Hämtar säkert AI:s textsvar
- **Felhantering**: Paketerar undantag med hjälpsamma felmeddelanden

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
- **spring-boot-starter**: Tillhandahåller kärnfunktioner för Spring Boot
- **openai-java**: Officiellt OpenAI Java SDK för API-kommunikation
- **jackson-databind**: Hanterar JSON-serialisering/deserialisering för API-anrop

## Hur allt fungerar tillsammans

Här är hela flödet när du kör applikationen:

1. **Uppstart**: Spring Boot startar och läser `application.properties`
2. **Tjänsteskapande**: Spring skapar `FoundryLocalService` och injicerar konfigurationsvärden
3. **Modelldetektering**: Om ingen modell är konfigurerad, frågar tjänsten Foundry Local’s `/v1/models`-endpoint och använder automatiskt den första tillgängliga modellen
4. **Klientuppsättning**: `@PostConstruct` initierar OpenAI-klienten för att ansluta till Foundry Local
5. **Demoexekvering**: `CommandLineRunner` körs efter uppstart
6. **AI-anrop**: Demon anropar `foundryLocalService.chat()` med ett testmeddelande
7. **API-förfrågan**: Tjänsten bygger och skickar en OpenAI-kompatibel förfrågan till Foundry Local
8. **Svarshantering**: Tjänsten extraherar och returnerar AI:s svar
9. **Visning**: Applikationen skriver ut svaret och avslutas

## Ställa in Foundry Local

1. **Installera Foundry Local** med instruktionerna i [Förutsättningar](#förutsättningar) sektionen.

2. **Starta tjänsten** (om den inte redan körs):  
   ```bash
   foundry service start
   ```
  
3. **Kontrollera tjänstens status** för att bekräfta att den körs och notera porten:  
   ```bash
   foundry service status
   ```
  
4. **Ladda ner och kör en modell** (laddas ner vid första körning, cachas för efterföljande körningar):  
   ```bash
   foundry model run phi-4-mini
   ```
   Detta öppnar en interaktiv chatt-session. Du kan avsluta med `Ctrl+C`. Modellen förblir inläst i tjänsten.

   > **Tips:** Kör `foundry model list` för att se alla tillgängliga modeller. Ersätt `phi-4-mini` med någon alias från katalogen (t.ex. `qwen2.5-0.5b` för en mindre/snabbare modell).

5. **Verifiera att modellen är inläst:**  
   ```bash
   foundry service ps
   ```
  
6. **Uppdatera `application.properties` vid behov:**  
   - Standard `base-url` (`http://localhost:5273/v1`) matchar standardporten för CLI. Uppdatera enbart om `foundry service status` visar en annan port.  
   - Modellen **upptäcks automatiskt** vid uppstart — ingen konfiguration behövs.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Köra applikationen

### Steg 1: Säkerställ att en modell är inläst i Foundry Local  
```bash
foundry service ps
```
  
Om inga modeller listas, ladda in en:  
```bash
foundry model run phi-4-mini
```
  
### Steg 2: Bygg och kör applikationen  
I ett separat terminalfönster:  
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```
  
Eller bygg och kör som en JAR:  
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```
  
## Förväntad utdata

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

## Nästa steg

För fler exempel, se [Kapitel 04: Praktiska exempel](../README.md)

## Felsökning

### Vanliga problem

**"Connection refused" eller "Service unavailable"**  
- Kontrollera tjänsten: `foundry service status`  
- Starta om vid behov: `foundry service restart`  
- Verifiera att porten i `application.properties` matchar `foundry service status` output  
- Kontrollera att URL slutar med `/v1`: `http://localhost:5273/v1`

**"No model found" vid uppstart**  
- Applikationen upptäcker modellen automatiskt. Säkerställ att minst en modell är inläst: `foundry service ps`  
- Om inga modeller är inlästa: `foundry model run phi-4-mini`  
- Om du har överstyrt modellnamnet i `application.properties`, verifiera att det matchar `foundry model list`

**"400 Bad Request"-fel**  
- Kontrollera att base URL inkluderar `/v1`: `http://localhost:5273/v1`  
- Säkerställ att du använder `maxCompletionTokens()` i din kod (inte den föråldrade `maxTokens()`)

**Maven kompilationsfel**  
- Säkerställ Java 21 eller högre: `java -version`  
- Rengör och bygg om: `mvn clean compile`  
- Kontrollera internetanslutning för nedladdning av beroenden

**Problem med tjänstanslutning**  
- Om du ser `Request to local service failed`, kör: `foundry service restart`  
- Kontrollera inlästa modeller: `foundry service ps`  
- Visa tjänstens loggar: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Ansvarsfriskrivning**:
Detta dokument har översatts med hjälp av AI-översättningstjänsten [Co-op Translator](https://github.com/Azure/co-op-translator). Även om vi strävar efter noggrannhet, vänligen var medveten om att automatiska översättningar kan innehålla fel eller brister. Det ursprungliga dokumentet på dess originalspråk bör betraktas som den auktoritativa källan. För kritisk information rekommenderas professionell mänsklig översättning. Vi ansvarar inte för några missförstånd eller feltolkningar som uppstår till följd av användningen av denna översättning.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->