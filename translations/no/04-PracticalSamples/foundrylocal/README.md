<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d064108b2142d32246ccbd8a42e76b4d",
  "translation_date": "2025-07-25T09:39:30+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "no"
}
-->
# Foundry Local Kommandolinjeapplikasjon

>**Merk**: Dette kapittelet inkluderer en [**Veiledning**](./TUTORIAL.md) som guider deg gjennom eksemplene.

En enkel Spring Boot-kommandolinjeapplikasjon som demonstrerer hvordan man kobler til Foundry Local ved hjelp av OpenAI Java SDK.

## Hva Du Vil Lære

- Hvordan integrere Foundry Local med Spring Boot-applikasjoner ved hjelp av OpenAI Java SDK
- Beste praksis for lokal AI-utvikling og testing

## Innholdsfortegnelse

- [Hva Du Vil Lære](../../../../04-PracticalSamples/foundrylocal)
- [Forutsetninger](../../../../04-PracticalSamples/foundrylocal)
  - [Installere Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Verifisering](../../../../04-PracticalSamples/foundrylocal)
- [Konfigurasjon](../../../../04-PracticalSamples/foundrylocal)
- [Kom i Gang](../../../../04-PracticalSamples/foundrylocal)
- [Hva Applikasjonen Gjør](../../../../04-PracticalSamples/foundrylocal)
- [Eksempelutdata](../../../../04-PracticalSamples/foundrylocal)
- [Arkitektur](../../../../04-PracticalSamples/foundrylocal)
- [Kodehøydepunkter](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI Java SDK-integrasjon](../../../../04-PracticalSamples/foundrylocal)
  - [Chat Completion API](../../../../04-PracticalSamples/foundrylocal)
- [Feilsøking](../../../../04-PracticalSamples/foundrylocal)

## Forutsetninger

> **⚠️ Merk**: Denne applikasjonen **kjører ikke i den medfølgende devcontaineren** siden den krever at Foundry Local er installert og kjører på vertsdatamaskinen.

### Installere Foundry Local

Før du kjører denne applikasjonen, må du installere og starte Foundry Local. Følg disse trinnene:

1. **Sørg for at systemet ditt oppfyller kravene**:
   - **Operativsystem**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, eller macOS
   - **Maskinvare**: 
     - Minimum: 8GB RAM, 3GB ledig diskplass
     - Anbefalt: 16GB RAM, 15GB ledig diskplass
   - **Nettverk**: Internettforbindelse for første nedlasting av modell (valgfritt for offline bruk)
   - **Akselerasjon (valgfritt)**: NVIDIA GPU (2000-serien eller nyere), AMD GPU (6000-serien eller nyere), Qualcomm Snapdragon X Elite (8GB eller mer minne), eller Apple silicon
   - **Tillatelser**: Administrative rettigheter for å installere programvare på enheten din

2. **Installer Foundry Local**:
   
   **For Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **For macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Alternativt kan du laste ned installasjonsprogrammet fra [Foundry Local GitHub-repositoriet](https://github.com/microsoft/Foundry-Local).

3. **Start din første modell**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Modellen lastes ned (dette kan ta noen minutter, avhengig av internettforbindelsen din) og deretter kjøres. Foundry Local velger automatisk den beste modellvarianten for systemet ditt (CUDA for NVIDIA GPU-er, CPU-versjon ellers).

4. **Test modellen** ved å stille et spørsmål i samme terminal:

   ```bash
   Why is the sky blue?
   ```

   Du bør se et svar fra Phi-modellen som forklarer hvorfor himmelen ser blå ut.

### Verifisering

Du kan verifisere at alt fungerer som det skal med disse kommandoene:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Du kan også besøke `http://localhost:5273` i nettleseren din for å se Foundry Local sitt webgrensesnitt.

## Konfigurasjon

Applikasjonen kan konfigureres gjennom `application.properties`:

- `foundry.local.base-url` - Base-URL for Foundry Local (standard: http://localhost:5273)
- `foundry.local.model` - AI-modellen som skal brukes (standard: Phi-3.5-mini-instruct-cuda-gpu)

> **Merk**: Modellnavnet i konfigurasjonen må samsvare med den spesifikke varianten som Foundry Local lastet ned for systemet ditt. Når du kjører `foundry model run phi-3.5-mini`, velger og laster Foundry Local automatisk ned den beste varianten (CUDA for NVIDIA GPU-er, CPU-versjon ellers). Bruk `foundry model list` for å se det eksakte modellnavnet som er tilgjengelig i din lokale instans.

## Kom i Gang

### 1. Naviger til Foundry Local-applikasjonskatalogen
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Kjør Applikasjonen

```bash
mvn spring-boot:run
```

Eller bygg og kjør JAR-filen:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Avhengigheter

Denne applikasjonen bruker OpenAI Java SDK for å kommunisere med Foundry Local. Nøkkelavhengigheten er:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Applikasjonen er forhåndskonfigurert for å koble til Foundry Local som kjører på standardporten.

## Hva Applikasjonen Gjør

Når du kjører applikasjonen:

1. **Starter opp** som en kommandolinjeapplikasjon (ingen webserver)
2. **Sender automatisk** en testmelding: "Hello! Can you tell me what you are and what model you're running?"
3. **Viser svaret** fra Foundry Local i konsollen
4. **Avslutter ryddig** etter demonstrasjonen

## Eksempelutdata

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Arkitektur

- **Application.java** - Hoved-Spring Boot-applikasjon med CommandLineRunner
- **FoundryLocalService.java** - Tjeneste som bruker OpenAI Java SDK for å kommunisere med Foundry Local
- Bruker **OpenAI Java SDK** for typesikre API-kall
- Automatisk JSON-serialisering/deserialisering håndtert av SDK
- Ryddig konfigurasjon ved bruk av Spring sine `@Value`- og `@PostConstruct`-annotasjoner

## Kodehøydepunkter

### OpenAI Java SDK-integrasjon

Applikasjonen bruker OpenAI Java SDK for å opprette en klient konfigurert for Foundry Local:

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

Å lage forespørsler for chat fullføring er enkelt og typesikkert:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Feilsøking

Hvis du ser tilkoblingsfeil:
1. Verifiser at Foundry Local kjører på `http://localhost:5273`
2. Sjekk at en Phi-3.5-mini-modellvariant er tilgjengelig med `foundry model list`
3. Sørg for at modellnavnet i `application.properties` samsvarer med det eksakte modellnavnet som vises i listen
4. Sørg for at ingen brannmur blokkerer tilkoblingen

Vanlige problemer:
- **Modell ikke funnet**: Kjør `foundry model run phi-3.5-mini` for å laste ned og starte modellen
- **Tjeneste ikke kjører**: Foundry Local-tjenesten kan ha stoppet; start den på nytt med kommandoen for å kjøre modellen
- **Feil modellnavn**: Bruk `foundry model list` for å se tilgjengelige modeller og oppdater konfigurasjonen din deretter

**Ansvarsfraskrivelse**:  
Dette dokumentet er oversatt ved hjelp av AI-oversettelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selv om vi tilstreber nøyaktighet, vær oppmerksom på at automatiserte oversettelser kan inneholde feil eller unøyaktigheter. Det originale dokumentet på sitt opprinnelige språk bør anses som den autoritative kilden. For kritisk informasjon anbefales profesjonell menneskelig oversettelse. Vi er ikke ansvarlige for eventuelle misforståelser eller feiltolkninger som oppstår ved bruk av denne oversettelsen.