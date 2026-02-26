# Foundry Local Spring Boot Tutorial

## Inhoudsopgave

- [Vereisten](../../../../04-PracticalSamples/foundrylocal)
- [Projectoverzicht](../../../../04-PracticalSamples/foundrylocal)
- [De code begrijpen](../../../../04-PracticalSamples/foundrylocal)
  - [1. Applicatieconfiguratie (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Hoofdapplicatieklasse (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI-servicelaag (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Projectafhankelijkheden (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Hoe alles samenwerkt](../../../../04-PracticalSamples/foundrylocal)
- [Foundry Local instellen](../../../../04-PracticalSamples/foundrylocal)
- [De applicatie uitvoeren](../../../../04-PracticalSamples/foundrylocal)
- [Verwachte output](../../../../04-PracticalSamples/foundrylocal)
- [Volgende stappen](../../../../04-PracticalSamples/foundrylocal)
- [Problemen oplossen](../../../../04-PracticalSamples/foundrylocal)

## Vereisten

Voordat je met deze tutorial begint, zorg ervoor dat je het volgende hebt:

- **Java 21 of hoger** geïnstalleerd op je systeem
- **Maven 3.6+** om het project te bouwen
- **Foundry Local** geïnstalleerd en actief

### **Foundry Local installeren:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```


## Projectoverzicht

Dit project bestaat uit vier hoofdcomponenten:

1. **Application.java** - Het belangrijkste startpunt van de Spring Boot-applicatie
2. **FoundryLocalService.java** - Servicelaag die de communicatie met AI afhandelt
3. **application.properties** - Configuratie voor de verbinding met Foundry Local
4. **pom.xml** - Maven-afhankelijkheden en projectconfiguratie

## De code begrijpen

### 1. Applicatieconfiguratie (application.properties)

**Bestand:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**Wat dit doet:**
- **base-url**: Geeft aan waar Foundry Local actief is, inclusief het pad `/v1` voor compatibiliteit met de OpenAI API. **Let op**: Foundry Local wijst dynamisch een poort toe, controleer je daadwerkelijke poort met `foundry service status`.
- **model**: Geeft de naam van het AI-model aan dat gebruikt wordt voor tekstgeneratie, inclusief het versienummer (bijv. `:1`). Gebruik `foundry model list` om beschikbare modellen met hun exacte ID's te bekijken.

**Belangrijk concept:** Spring Boot laadt deze eigenschappen automatisch en maakt ze beschikbaar voor je applicatie met behulp van de `@Value`-annotatie.

### 2. Hoofdapplicatieklasse (Application.java)

**Bestand:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```


**Wat dit doet:**
- `@SpringBootApplication` stelt Spring Boot in staat om automatisch te configureren.
- `WebApplicationType.NONE` geeft aan dat dit een command-line applicatie is en geen webserver.
- De main-methode start de Spring-applicatie.

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
- `@Bean` maakt een component dat door Spring wordt beheerd.
- `CommandLineRunner` voert code uit nadat Spring Boot is opgestart.
- `foundryLocalService` wordt automatisch geïnjecteerd door Spring (dependency injection).
- Stuurt een testbericht naar de AI en toont de reactie.

### 3. AI-servicelaag (FoundryLocalService.java)

**Bestand:** `src/main/java/com/example/FoundryLocalService.java`

#### Configuratie-injectie:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**Wat dit doet:**
- `@Service` geeft aan dat deze klasse bedrijfslogica biedt.
- `@Value` injecteert configuratiewaarden uit application.properties.
- De syntaxis `:default-value` biedt standaardwaarden als eigenschappen niet zijn ingesteld.

#### Initialisatie van de client:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```


**Wat dit doet:**
- `@PostConstruct` voert deze methode uit nadat Spring de service heeft gemaakt.
- Maakt een OpenAI-client die wijst naar je lokale Foundry Local-instantie.
- De basis-URL uit `application.properties` bevat al `/v1` voor compatibiliteit met de OpenAI API.
- API-sleutel is ingesteld op "not-needed" omdat authenticatie niet vereist is voor lokale ontwikkeling.

#### Chatmethode:
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


**Wat dit doet:**
- **ChatCompletionCreateParams**: Configureert het AI-verzoek.
  - `model`: Geeft aan welk AI-model moet worden gebruikt (moet exact overeenkomen met het ID uit `foundry model list`).
  - `addUserMessage`: Voegt je bericht toe aan het gesprek.
  - `maxCompletionTokens`: Beperkt hoe lang de reactie kan zijn (bespaart middelen).
  - `temperature`: Bepaalt willekeurigheid (0.0 = deterministisch, 1.0 = creatief).
- **API-aanroep**: Stuurt het verzoek naar Foundry Local.
- **Reactieafhandeling**: Haalt de tekstreactie van de AI veilig op.
- **Foutafhandeling**: Omvat uitzonderingen met nuttige foutmeldingen.

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
- **spring-boot-starter**: Biedt kernfunctionaliteit van Spring Boot.
- **openai-java**: Officiële OpenAI Java SDK voor API-communicatie.
- **jackson-databind**: Verzorgt JSON-serialisatie/deserialisatie voor API-aanroepen.

## Hoe alles samenwerkt

Hier is het volledige proces wanneer je de applicatie uitvoert:

1. **Opstarten**: Spring Boot start en leest `application.properties`.
2. **Servicecreatie**: Spring maakt `FoundryLocalService` en injecteert configuratiewaarden.
3. **Clientinstelling**: `@PostConstruct` initialiseert de OpenAI-client om verbinding te maken met Foundry Local.
4. **Demo-uitvoering**: `CommandLineRunner` wordt uitgevoerd na opstarten.
5. **AI-aanroep**: De demo roept `foundryLocalService.chat()` aan met een testbericht.
6. **API-verzoek**: Service bouwt en stuurt een OpenAI-compatibel verzoek naar Foundry Local.
7. **Reactieverwerking**: Service haalt de reactie van de AI op en retourneert deze.
8. **Weergave**: Applicatie toont de reactie en sluit af.

## Foundry Local instellen

Volg deze stappen om Foundry Local in te stellen:

1. **Installeer Foundry Local** met de instructies in de sectie [Vereisten](../../../../04-PracticalSamples/foundrylocal).

2. **Controleer de dynamisch toegewezen poort**. Foundry Local wijst automatisch een poort toe bij het starten. Vind je poort met:
   ```bash
   foundry service status
   ```
   
   **Optioneel**: Als je liever een specifieke poort gebruikt (bijv. 5273), kun je deze handmatig configureren:
   ```bash
   foundry service set --port 5273
   ```


3. **Download het AI-model** dat je wilt gebruiken, bijvoorbeeld `phi-3.5-mini`, met het volgende commando:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **Configureer het application.properties-bestand** om overeen te komen met je Foundry Local-instellingen:
   - Werk de poort bij in `base-url` (van stap 2), zorg ervoor dat deze eindigt met `/v1`.
   - Werk de modelnaam bij om het versienummer op te nemen (controleer met `foundry model list`).

   Voorbeeld:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## De applicatie uitvoeren

### Stap 1: Start Foundry Local
```bash
foundry model run phi-3.5-mini
```


### Stap 2: Bouw en voer de applicatie uit
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
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```


## Volgende stappen

Voor meer voorbeelden, zie [Hoofdstuk 04: Praktische voorbeelden](../README.md).

## Problemen oplossen

### Veelvoorkomende problemen

**"Connection refused" of "Service unavailable"**
- Zorg ervoor dat Foundry Local actief is: `foundry model list`.
- Controleer de daadwerkelijke poort die Foundry Local gebruikt: `foundry service status`.
- Werk je `application.properties` bij met de juiste poort, zorg ervoor dat de URL eindigt met `/v1`.
- Stel eventueel een specifieke poort in: `foundry service set --port 5273`.
- Probeer Foundry Local opnieuw te starten: `foundry model run phi-3.5-mini`.

**"Model not found" of "404 Not Found"-fouten**
- Controleer beschikbare modellen met hun exacte ID's: `foundry model list`.
- Werk de modelnaam in `application.properties` bij zodat deze exact overeenkomt, inclusief het versienummer (bijv. `Phi-3.5-mini-instruct-cuda-gpu:1`).
- Zorg ervoor dat de `base-url` eindigt met `/v1`: `http://localhost:5273/v1`.
- Download het model indien nodig: `foundry model run phi-3.5-mini`.

**"400 Bad Request"-fouten**
- Controleer of de basis-URL `/v1` bevat: `http://localhost:5273/v1`.
- Controleer of het model-ID exact overeenkomt met wat wordt weergegeven in `foundry model list`.
- Zorg ervoor dat je `maxCompletionTokens()` gebruikt in je code (niet de verouderde `maxTokens()`).

**Maven-compilatiefouten**
- Zorg ervoor dat Java 21 of hoger is geïnstalleerd: `java -version`.
- Maak schoon en bouw opnieuw: `mvn clean compile`.
- Controleer de internetverbinding voor het downloaden van afhankelijkheden.

**Applicatie start maar geeft geen output**
- Controleer of Foundry Local reageert: Controleer `http://localhost:5273/v1/models` of voer `foundry service status` uit.
- Controleer de applicatielogs op specifieke foutmeldingen.
- Zorg ervoor dat het model volledig is geladen en klaar.

---

**Disclaimer**:  
Dit document is vertaald met behulp van de AI-vertalingsservice [Co-op Translator](https://github.com/Azure/co-op-translator). Hoewel we streven naar nauwkeurigheid, dient u zich ervan bewust te zijn dat geautomatiseerde vertalingen fouten of onnauwkeurigheden kunnen bevatten. Het originele document in de oorspronkelijke taal moet worden beschouwd als de gezaghebbende bron. Voor kritieke informatie wordt professionele menselijke vertaling aanbevolen. Wij zijn niet aansprakelijk voor eventuele misverstanden of verkeerde interpretaties die voortvloeien uit het gebruik van deze vertaling.