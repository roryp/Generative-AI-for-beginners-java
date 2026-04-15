# Foundry Local Spring Boot Tutorial

## Inhoudsopgave

- [Vereisten](#vereisten)
- [Projectoverzicht](#projectoverzicht)
- [De code begrijpen](#de-code-begrijpen)
  - [1. Applicatieconfiguratie (application.properties)](#1-applicatieconfiguratie-applicationproperties)
  - [2. Hoofdapplicatieklasse (Application.java)](#2-hoofdapplicatieklasse-applicationjava)
  - [3. AI-servicelaag (FoundryLocalService.java)](#3-ai-servicelaag-foundrylocalservicejava)
  - [4. Projectafhankelijkheden (pom.xml)](#4-projectafhankelijkheden-pomxml)
- [Hoe het allemaal samenwerkt](#hoe-het-allemaal-samenwerkt)
- [Foundry Local instellen](#foundry-local-instellen)
- [De applicatie uitvoeren](#de-applicatie-uitvoeren)
- [Verwachte output](#verwachte-output)
- [Volgende stappen](#volgende-stappen)
- [Probleemoplossing](#probleemoplossing)


## Vereisten

Voordat je aan deze tutorial begint, zorg dat je:

- **Java 21 of hoger** geïnstalleerd hebt op je systeem
- **Maven 3.6+** voor het bouwen van het project
- **Foundry Local** geïnstalleerd en draaiend hebt

### **Foundry Local installeren:**

> **Opmerking:** Foundry Local CLI is alleen beschikbaar op **Windows** en **macOS**. Linux wordt ondersteund via de [Foundry Local SDK's](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Controleer de installatie:
```bash
foundry --version
```

## Projectoverzicht

Dit project bestaat uit vier hoofdcomponenten:

1. **Application.java** - De hoofdentrypoint van de Spring Boot-applicatie
2. **FoundryLocalService.java** - Servicelaag die AI-communicatie afhandelt
3. **application.properties** - Configuratie voor de verbinding met Foundry Local
4. **pom.xml** - Maven-afhankelijkheden en projectconfiguratie

## De code begrijpen

### 1. Applicatieconfiguratie (application.properties)

**Bestand:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Wat dit doet:**
- **base-url**: Specificeert waar Foundry Local draait, inclusief het `/v1` pad voor OpenAI API-compatibiliteit. De standaardpoort is `5273`. Als de poort anders is, controleer deze met `foundry service status`.
- **model** (optioneel): Geeft de naam van het AI-model op voor tekstgeneratie. **Standaard detecteert de applicatie het model automatisch** door bij opstarten de Foundry Local `/v1/models` endpoint te bevragen, dus handmatig instellen is niet nodig. Je kunt het nog steeds expliciet instellen om de autodetectie te overschrijven indien gewenst.

**Belangrijk concept:** Spring Boot laadt deze eigenschappen automatisch en maakt ze beschikbaar voor je applicatie met de `@Value` annotatie.

### 2. Hoofdapplicatieklasse (Application.java)

**Bestand:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Geen webserver nodig
        app.run(args);
    }
```

**Wat dit doet:**
- `@SpringBootApplication` zet Spring Boot auto-configuratie aan
- `WebApplicationType.NONE` geeft aan dat dit een commandline-app is, geen webserver
- De main-methode start de Spring applicatie

**De Demo Runner:**
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

**Wat dit doet:**
- `@Bean` maakt een component die door Spring wordt beheerd
- `CommandLineRunner` voert code uit nadat Spring Boot is opgestart
- `foundryLocalService` wordt automatisch geïnjecteerd door Spring (dependency injection)
- Stuurt een testbericht naar de AI en toont de respons

### 3. AI-servicelaag (FoundryLocalService.java)

**Bestand:** `src/main/java/com/example/FoundryLocalService.java`

#### Configuratie-injectie:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Automatisch gedetecteerd als leeg
```

**Wat dit doet:**
- `@Service` zegt tegen Spring dat deze klasse bedrijfslogica levert
- `@Value` injecteert configuratiewaardes uit application.properties
- Het model staat standaard leeg, wat **autodetectie** vanuit Foundry Local bij opstart triggert. Dit betekent dat de app werkt met elk model dat in Foundry Local geladen is zonder handmatige configuratie.

#### Client-initialisatie:
```java
@PostConstruct
public void init() {
    // Detecteer het model automatisch vanuit Foundry Local als het niet expliciet is geconfigureerd
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Basis-URL bevat al /v1 vanuit de configuratie
            .apiKey("not-needed")            // Lokale server heeft geen echte API-sleutel nodig
            .build();
}
```

**Wat dit doet:**
- `@PostConstruct` voert deze methode uit nadat Spring de service heeft gemaakt
- Als er geen model is geconfigureerd, vraagt het Foundry Local’s `/v1/models` endpoint en kiest het eerste geladen model
- Maakt een OpenAI-client aan die verwijst naar je lokale Foundry Local instantie
- De base URL vanuit `application.properties` bevat al `/v1` voor OpenAI API-compatibiliteit
- API sleutel staat op "not-needed" omdat lokale ontwikkeling geen authenticatie vereist

#### Chat-methode:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Welk AI-model te gebruiken
                .addUserMessage(message)         // Je vraag/aanwijzing
                .maxCompletionTokens(150)        // Beperk de lengte van het antwoord
                .temperature(0.7)                // Beheers creativiteit (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Haal het antwoord van de AI uit het API-resultaat
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Wat dit doet:**
- **ChatCompletionCreateParams**: Configureert het AI-verzoek
  - `model`: Specificeert welk AI-model gebruikt wordt (moet precies overeenkomen met het ID uit `foundry model list`)
  - `addUserMessage`: Voegt jouw bericht toe aan het gesprek
  - `maxCompletionTokens`: Beperkt hoe lang het antwoord mag zijn (bespaart resources)
  - `temperature`: Bepaalt de willekeurigheid (0.0 = deterministisch, 1.0 = creatief)
- **API-aanroep**: Verzendt het verzoek naar Foundry Local
- **Response-afhandeling**: Haalt veilig de tekstrespons van de AI op
- **Foutafhandeling**: Pakt uitzonderingen af met duidelijke foutmeldingen

### 4. Projectafhankelijkheden (pom.xml)

**Belangrijke afhankelijkheden:**

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

**Wat deze doen:**
- **spring-boot-starter**: Biedt kernfunctionaliteit van Spring Boot
- **openai-java**: Officiële OpenAI Java SDK voor API-communicatie
- **jackson-databind**: Handelt JSON-serialisatie/deserialisatie voor API-aanroepen

## Hoe het allemaal samenwerkt

Hier is de volledige flow wanneer je de applicatie draait:

1. **Opstarten:** Spring Boot start en leest `application.properties`
2. **Service aanmaken:** Spring maakt `FoundryLocalService` en injecteert configuratiewaardes
3. **Modeldetectie:** Als er geen model is geconfigureerd, vraagt de service Foundry Local's `/v1/models` endpoint en gebruikt het eerste beschikbare model automatisch
4. **Client setup:** `@PostConstruct` initialiseert de OpenAI-client om verbinding te maken met Foundry Local
5. **Demo uitvoeren:** `CommandLineRunner` voert uit na opstart
6. **AI-aanroep:** De demo roept `foundryLocalService.chat()` aan met een testbericht
7. **API-verzoek:** Service bouwt en verstuurt OpenAI-compatibel verzoek naar Foundry Local
8. **Respons verwerken:** Service haalt het antwoord van de AI op en geeft dit terug
9. **Weergave:** Applicatie print het antwoord en sluit af

## Foundry Local instellen

1. **Installeer Foundry Local** volgens de instructies in de sectie [Vereisten](#vereisten).

2. **Start de service** (indien nog niet draaiend):
   ```bash
   foundry service start
   ```

3. **Controleer de servicestatus** om te bevestigen dat hij draait en noteer de poort:
   ```bash
   foundry service status
   ```

4. **Download en start een model** (wordt bij de eerste run gedownload, gecachet voor volgende keren):
   ```bash
   foundry model run phi-4-mini
   ```
   Dit opent een interactieve chatsessie. Je kunt afsluiten met `Ctrl+C`. Het model blijft geladen in de service.

   > **Tip:** Voer `foundry model list` uit om alle beschikbare modellen te zien. Vervang `phi-4-mini` door een alias uit de catalogus (bijv. `qwen2.5-0.5b` voor een kleiner/sneller model).

5. **Controleer dat het model geladen is:**
   ```bash
   foundry service ps
   ```

6. **Update `application.properties` indien nodig:**
   - De standaard `base-url` (`http://localhost:5273/v1`) komt overeen met de standaardpoort van de CLI. Pas aan alleen als `foundry service status` een andere poort laat zien.
   - Het model wordt **automatisch gedetecteerd** bij opstart — geen configuratie vereist.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## De applicatie uitvoeren

### Stap 1: Zorg dat er een model geladen is in Foundry Local
```bash
foundry service ps
```
Als er geen modellen worden getoond, laad er dan één:
```bash
foundry model run phi-4-mini
```

### Stap 2: Bouw en start de applicatie
In een aparte terminal:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Of bouw en voer uit als JAR:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Verwachte output

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

## Volgende stappen

Voor meer voorbeelden, zie [Hoofdstuk 04: Praktische voorbeelden](../README.md)

## Probleemoplossing

### Veelvoorkomende problemen

**"Connection refused" of "Service unavailable"**
- Controleer de service: `foundry service status`
- Herstart indien nodig: `foundry service restart`
- Controleer dat de poort in `application.properties` overeenkomt met de output van `foundry service status`
- Zorg dat de URL eindigt op `/v1`: `http://localhost:5273/v1`

**"No model found" bij opstart**
- De applicatie detecteert het model automatisch. Zorg dat er minstens één model is geladen: `foundry service ps`
- Als er geen modellen geladen zijn: `foundry model run phi-4-mini`
- Als je de modelnaam hebt aangepast in `application.properties`, controleer dat die overeenkomt met `foundry model list`

**"400 Bad Request" fouten**
- Controleer dat de base URL `/v1` bevat: `http://localhost:5273/v1`
- Zorg dat je `maxCompletionTokens()` gebruikt in je code (gebruik niet de verouderde `maxTokens()`)

**Maven compilatie fouten**
- Zorg dat je Java 21 of hoger hebt: `java -version`
- Schoon en bouw opnieuw: `mvn clean compile`
- Controleer je internetverbinding voor het downloaden van afhankelijkheden

**Problemen met serviceverbinding**
- Als je `Request to local service failed` ziet, voer uit: `foundry service restart`
- Controleer geladen modellen: `foundry service ps`
- Bekijk servicelogs: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Disclaimer**:  
Dit document is vertaald met behulp van de AI vertaaldienst [Co-op Translator](https://github.com/Azure/co-op-translator). Hoewel we streven naar nauwkeurigheid, dient u er rekening mee te houden dat automatische vertalingen fouten of onnauwkeurigheden kunnen bevatten. Het oorspronkelijke document in de oorspronkelijke taal dient als de gezaghebbende bron te worden beschouwd. Voor belangrijke informatie wordt professionele menselijke vertaling aanbevolen. Wij zijn niet aansprakelijk voor eventuele misverstanden of verkeerde interpretaties die voortvloeien uit het gebruik van deze vertaling.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->