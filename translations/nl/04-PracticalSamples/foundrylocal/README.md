<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d064108b2142d32246ccbd8a42e76b4d",
  "translation_date": "2025-07-25T09:44:04+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "nl"
}
-->
# Foundry Local Command-Line Applicatie

>**Opmerking**: Dit hoofdstuk bevat een [**Tutorial**](./TUTORIAL.md) die je door de voorbeelden begeleidt.

Een eenvoudige Spring Boot command-line applicatie die demonstreert hoe je verbinding maakt met Foundry Local met behulp van de OpenAI Java SDK.

## Wat Je Gaat Leren

- Hoe je Foundry Local integreert met Spring Boot applicaties via de OpenAI Java SDK
- Best practices voor lokale AI-ontwikkeling en testen

## Inhoudsopgave

- [Wat Je Gaat Leren](../../../../04-PracticalSamples/foundrylocal)
- [Vereisten](../../../../04-PracticalSamples/foundrylocal)
  - [Foundry Local Installeren](../../../../04-PracticalSamples/foundrylocal)
  - [Verificatie](../../../../04-PracticalSamples/foundrylocal)
- [Configuratie](../../../../04-PracticalSamples/foundrylocal)
- [Snelle Start](../../../../04-PracticalSamples/foundrylocal)
- [Wat de Applicatie Doet](../../../../04-PracticalSamples/foundrylocal)
- [Voorbeeldoutput](../../../../04-PracticalSamples/foundrylocal)
- [Architectuur](../../../../04-PracticalSamples/foundrylocal)
- [Code Hoogtepunten](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI Java SDK Integratie](../../../../04-PracticalSamples/foundrylocal)
  - [Chat Completion API](../../../../04-PracticalSamples/foundrylocal)
- [Probleemoplossing](../../../../04-PracticalSamples/foundrylocal)

## Vereisten

> **⚠️ Opmerking**: Deze applicatie **werkt niet in de meegeleverde devcontainer** omdat Foundry Local geïnstalleerd en actief moet zijn op het hostsysteem.

### Foundry Local Installeren

Voordat je deze applicatie uitvoert, moet je Foundry Local installeren en starten. Volg deze stappen:

1. **Zorg ervoor dat je systeem aan de vereisten voldoet**:
   - **Besturingssysteem**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, of macOS
   - **Hardware**: 
     - Minimum: 8GB RAM, 3GB vrije schijfruimte
     - Aanbevolen: 16GB RAM, 15GB vrije schijfruimte
   - **Netwerk**: Internetverbinding voor het downloaden van het model (optioneel voor offline gebruik)
   - **Versnelling (optioneel)**: NVIDIA GPU (2.000-serie of nieuwer), AMD GPU (6.000-serie of nieuwer), Qualcomm Snapdragon X Elite (8GB of meer geheugen), of Apple silicon
   - **Rechten**: Beheerdersrechten om software op je apparaat te installeren

2. **Installeer Foundry Local**:
   
   **Voor Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **Voor macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Je kunt ook de installer downloaden van de [Foundry Local GitHub repository](https://github.com/microsoft/Foundry-Local).

3. **Start je eerste model**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Het model wordt gedownload (dit kan enkele minuten duren, afhankelijk van je internetsnelheid) en vervolgens uitgevoerd. Foundry Local selecteert automatisch de beste modelvariant voor je systeem (CUDA voor NVIDIA GPU's, CPU-versie anders).

4. **Test het model** door een vraag te stellen in dezelfde terminal:

   ```bash
   Why is the sky blue?
   ```

   Je zou een antwoord moeten zien van het Phi-model dat uitlegt waarom de lucht blauw lijkt.

### Verificatie

Je kunt controleren of alles correct werkt met deze commando's:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Je kunt ook `http://localhost:5273` bezoeken in je browser om de Foundry Local webinterface te bekijken.

## Configuratie

De applicatie kan worden geconfigureerd via `application.properties`:

- `foundry.local.base-url` - Basis-URL voor Foundry Local (standaard: http://localhost:5273)
- `foundry.local.model` - AI-model dat gebruikt wordt (standaard: Phi-3.5-mini-instruct-cuda-gpu)

> **Opmerking**: De modelnaam in de configuratie moet overeenkomen met de specifieke variant die Foundry Local heeft gedownload voor je systeem. Wanneer je `foundry model run phi-3.5-mini` uitvoert, selecteert Foundry Local automatisch de beste variant (CUDA voor NVIDIA GPU's, CPU-versie anders). Gebruik `foundry model list` om de exacte modelnaam te zien die beschikbaar is in je lokale instantie.

## Snelle Start

### 1. Navigeer naar de Foundry Local applicatiemap
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Voer de Applicatie Uit

```bash
mvn spring-boot:run
```

Of bouw en voer de JAR uit:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Afhankelijkheden

Deze applicatie gebruikt de OpenAI Java SDK om te communiceren met Foundry Local. De belangrijkste afhankelijkheid is:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

De applicatie is vooraf geconfigureerd om verbinding te maken met Foundry Local die op de standaardpoort draait.

## Wat de Applicatie Doet

Wanneer je de applicatie uitvoert:

1. **Start** als een command-line applicatie (geen webserver)
2. **Stuurt automatisch** een testbericht: "Hallo! Kun je me vertellen wat je bent en welk model je gebruikt?"
3. **Toont het antwoord** van Foundry Local in de console
4. **Sluit netjes af** na de demo

## Voorbeeldoutput

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Architectuur

- **Application.java** - Hoofd Spring Boot applicatie met CommandLineRunner
- **FoundryLocalService.java** - Service die de OpenAI Java SDK gebruikt om te communiceren met Foundry Local
- Gebruikt **OpenAI Java SDK** voor type-veilige API-aanroepen
- Automatische JSON-serialisatie/deserialisatie afgehandeld door de SDK
- Schone configuratie met behulp van Spring's `@Value` en `@PostConstruct` annotaties

## Code Hoogtepunten

### OpenAI Java SDK Integratie

De applicatie gebruikt de OpenAI Java SDK om een client te maken die is geconfigureerd voor Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### Chat Completion API

Het maken van chat completion verzoeken is eenvoudig en type-veilig:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Probleemoplossing

Als je verbindingsfouten ziet:
1. Controleer of Foundry Local actief is op `http://localhost:5273`
2. Controleer of een Phi-3.5-mini modelvariant beschikbaar is met `foundry model list`
3. Zorg ervoor dat de modelnaam in `application.properties` overeenkomt met de exacte modelnaam die in de lijst wordt weergegeven
4. Controleer of er geen firewall is die de verbinding blokkeert

Veelvoorkomende problemen:
- **Model niet gevonden**: Voer `foundry model run phi-3.5-mini` uit om het model te downloaden en te starten
- **Service niet actief**: De Foundry Local service is mogelijk gestopt; start deze opnieuw met het model run commando
- **Verkeerde modelnaam**: Gebruik `foundry model list` om beschikbare modellen te zien en werk je configuratie dienovereenkomstig bij

**Disclaimer**:  
Dit document is vertaald met behulp van de AI-vertalingsservice [Co-op Translator](https://github.com/Azure/co-op-translator). Hoewel we ons best doen voor nauwkeurigheid, dient u zich ervan bewust te zijn dat geautomatiseerde vertalingen fouten of onnauwkeurigheden kunnen bevatten. Het originele document in de oorspronkelijke taal moet worden beschouwd als de gezaghebbende bron. Voor cruciale informatie wordt professionele menselijke vertaling aanbevolen. Wij zijn niet aansprakelijk voor misverstanden of verkeerde interpretaties die voortvloeien uit het gebruik van deze vertaling.