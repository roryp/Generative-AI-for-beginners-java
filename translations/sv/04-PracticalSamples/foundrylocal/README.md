<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T19:47:27+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "sv"
}
-->
# Foundry Lokal Kommandoradsapplikation

>**Note**: Detta kapitel inkluderar en [**Tutorial**](./TUTORIAL.md) som guidar dig genom att köra de färdiga exemplen.

En enkel Spring Boot-kommandoradsapplikation som demonstrerar hur man ansluter till Foundry Lokal med hjälp av OpenAI Java SDK.

## Vad Du Kommer Lära Dig

- Hur man integrerar Foundry Lokal med Spring Boot-applikationer med OpenAI Java SDK
- Bästa praxis för lokal AI-utveckling och testning

## Innehållsförteckning

- [Vad Du Kommer Lära Dig](../../../../04-PracticalSamples/foundrylocal)
- [Förutsättningar](../../../../04-PracticalSamples/foundrylocal)
  - [Installera Foundry Lokal](../../../../04-PracticalSamples/foundrylocal)
  - [Verifiering](../../../../04-PracticalSamples/foundrylocal)
- [Konfiguration](../../../../04-PracticalSamples/foundrylocal)
- [Snabbstart](../../../../04-PracticalSamples/foundrylocal)
- [Vad Applikationen Gör](../../../../04-PracticalSamples/foundrylocal)
- [Exempelutdata](../../../../04-PracticalSamples/foundrylocal)
- [Arkitektur](../../../../04-PracticalSamples/foundrylocal)
- [Kodhöjdpunkter](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI Java SDK Integration](../../../../04-PracticalSamples/foundrylocal)
  - [Chat Completion API](../../../../04-PracticalSamples/foundrylocal)
- [Felsökning](../../../../04-PracticalSamples/foundrylocal)

## Förutsättningar

> **⚠️ Note**: Denna applikation **körs inte i den medföljande devcontainern** eftersom den kräver att Foundry Lokal är installerad och körs på värdsystemet.

### Installera Foundry Lokal

Innan du kör denna applikation måste du installera och starta Foundry Lokal. Följ dessa steg:

1. **Säkerställ att ditt system uppfyller kraven**:
   - **Operativsystem**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 eller macOS
   - **Hårdvara**: 
     - Minimum: 8GB RAM, 3GB ledigt diskutrymme
     - Rekommenderat: 16GB RAM, 15GB ledigt diskutrymme
   - **Nätverk**: Internetanslutning för initial nedladdning av modell (valfritt för offline-användning)
   - **Acceleration (valfritt)**: NVIDIA GPU (2,000-serien eller nyare), AMD GPU (6,000-serien eller nyare), Qualcomm Snapdragon X Elite (8GB eller mer minne) eller Apple silicon
   - **Behörigheter**: Administratörsrättigheter för att installera programvara på din enhet

2. **Installera Foundry Lokal**:
   
   **För Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **För macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Alternativt kan du ladda ner installationsprogrammet från [Foundry Lokals GitHub-repository](https://github.com/microsoft/Foundry-Local).

3. **Starta din första modell**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Modellen laddas ner (vilket kan ta några minuter beroende på din internetanslutning) och körs sedan. Foundry Lokal väljer automatiskt den bästa modellvarianten för ditt system (CUDA för NVIDIA GPU:er, CPU-version annars).

4. **Testa modellen** genom att ställa en fråga i samma terminal:

   ```bash
   Why is the sky blue?
   ```

   Du bör se ett svar från Phi-modellen som förklarar varför himlen ser blå ut.

### Verifiering

Du kan verifiera att allt fungerar korrekt med dessa kommandon:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Du kan också besöka `http://localhost:5273` i din webbläsare för att se Foundry Lokals webbgränssnitt.

## Konfiguration

Applikationen kan konfigureras via `application.properties`:

- `foundry.local.base-url` - Bas-URL för Foundry Lokal (standard: http://localhost:5273)
- `foundry.local.model` - AI-modell att använda (standard: Phi-3.5-mini-instruct-cuda-gpu)

> **Note**: Modellnamnet i konfigurationen bör matcha den specifika variant som Foundry Lokal laddade ner för ditt system. När du kör `foundry model run phi-3.5-mini` väljer och laddar Foundry Lokal automatiskt den bästa varianten (CUDA för NVIDIA GPU:er, CPU-version annars). Använd `foundry model list` för att se det exakta modellnamnet som är tillgängligt i din lokala instans.

## Snabbstart

### 1. Navigera till Foundry Lokals applikationskatalog
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Kör Applikationen

```bash
mvn spring-boot:run
```

Eller bygg och kör JAR-filen:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Beroenden

Denna applikation använder OpenAI Java SDK för att kommunicera med Foundry Lokal. Den viktigaste beroenden är:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Applikationen är förkonfigurerad för att ansluta till Foundry Lokal som körs på standardporten.

## Vad Applikationen Gör

När du kör applikationen:

1. **Startar upp** som en kommandoradsapplikation (ingen webbserver)
2. **Skickar automatiskt** ett testmeddelande: "Hej! Kan du berätta vad du är och vilken modell du kör?"
3. **Visar svaret** från Foundry Lokal i konsolen
4. **Avslutar rent** efter demonstrationen

## Exempelutdata

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Arkitektur

- **Application.java** - Huvudapplikation för Spring Boot med CommandLineRunner
- **FoundryLocalService.java** - Tjänst som använder OpenAI Java SDK för att kommunicera med Foundry Lokal
- Använder **OpenAI Java SDK** för typ-säkra API-anrop
- Automatisk JSON-serialisering/deserialisering hanteras av SDK
- Ren konfiguration med hjälp av Springs `@Value` och `@PostConstruct`-annoteringar

## Kodhöjdpunkter

### OpenAI Java SDK Integration

Applikationen använder OpenAI Java SDK för att skapa en klient konfigurerad för Foundry Lokal:

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

Att göra förfrågningar om chattkomplettering är enkelt och typ-säkert:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Felsökning

Om du ser anslutningsfel:
1. Verifiera att Foundry Lokal körs på `http://localhost:5273`
2. Kontrollera att en Phi-3.5-mini-modellvariant är tillgänglig med `foundry model list`
3. Säkerställ att modellnamnet i `application.properties` matchar det exakta modellnamnet som visas i listan
4. Kontrollera att ingen brandvägg blockerar anslutningen

Vanliga problem:
- **Modell hittades inte**: Kör `foundry model run phi-3.5-mini` för att ladda ner och starta modellen
- **Tjänsten körs inte**: Foundry Lokals tjänst kan ha stoppats; starta om den med kommandot för att köra modellen
- **Fel modellnamn**: Använd `foundry model list` för att se tillgängliga modeller och uppdatera din konfiguration därefter

**Ansvarsfriskrivning**:  
Detta dokument har översatts med hjälp av AI-översättningstjänsten [Co-op Translator](https://github.com/Azure/co-op-translator). Även om vi strävar efter noggrannhet, bör det noteras att automatiserade översättningar kan innehålla fel eller felaktigheter. Det ursprungliga dokumentet på dess originalspråk bör betraktas som den auktoritativa källan. För kritisk information rekommenderas professionell mänsklig översättning. Vi ansvarar inte för eventuella missförstånd eller feltolkningar som uppstår vid användning av denna översättning.