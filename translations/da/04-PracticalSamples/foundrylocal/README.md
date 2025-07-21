<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T19:47:47+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "da"
}
-->
# Foundry Local Kommandolinjeapplikation

>**Bemærk**: Dette kapitel inkluderer en [**Tutorial**](./TUTORIAL.md), der guider dig gennem at køre de færdige eksempler.

En simpel Spring Boot-kommandolinjeapplikation, der demonstrerer, hvordan man forbinder til Foundry Local ved hjælp af OpenAI Java SDK.

## Hvad Du Vil Lære

- Hvordan man integrerer Foundry Local med Spring Boot-applikationer ved hjælp af OpenAI Java SDK
- Bedste praksis for lokal AI-udvikling og test

## Indholdsfortegnelse

- [Hvad Du Vil Lære](../../../../04-PracticalSamples/foundrylocal)
- [Forudsætninger](../../../../04-PracticalSamples/foundrylocal)
  - [Installation af Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Verifikation](../../../../04-PracticalSamples/foundrylocal)
- [Konfiguration](../../../../04-PracticalSamples/foundrylocal)
- [Hurtig Start](../../../../04-PracticalSamples/foundrylocal)
- [Hvad Applikationen Gør](../../../../04-PracticalSamples/foundrylocal)
- [Eksempeloutput](../../../../04-PracticalSamples/foundrylocal)
- [Arkitektur](../../../../04-PracticalSamples/foundrylocal)
- [Kodehøjdepunkter](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI Java SDK Integration](../../../../04-PracticalSamples/foundrylocal)
  - [Chat Completion API](../../../../04-PracticalSamples/foundrylocal)
- [Fejlfinding](../../../../04-PracticalSamples/foundrylocal)

## Forudsætninger

> **⚠️ Bemærk**: Denne applikation **kører ikke i den medfølgende devcontainer**, da den kræver, at Foundry Local er installeret og kører på værtsystemet.

### Installation af Foundry Local

Før du kører denne applikation, skal du installere og starte Foundry Local. Følg disse trin:

1. **Sørg for, at dit system opfylder kravene**:
   - **Operativsystem**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 eller macOS
   - **Hardware**: 
     - Minimum: 8GB RAM, 3GB ledig diskplads
     - Anbefalet: 16GB RAM, 15GB ledig diskplads
   - **Netværk**: Internetforbindelse til første model-download (valgfrit til offline brug)
   - **Acceleration (valgfrit)**: NVIDIA GPU (2.000-serien eller nyere), AMD GPU (6.000-serien eller nyere), Qualcomm Snapdragon X Elite (8GB eller mere hukommelse) eller Apple silicon
   - **Tilladelser**: Administrative rettigheder til at installere software på din enhed

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
   
   Alternativt kan du downloade installationsprogrammet fra [Foundry Local GitHub-repositoriet](https://github.com/microsoft/Foundry-Local).

3. **Start din første model**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Modellen downloades (hvilket kan tage et par minutter afhængigt af din internetforbindelse) og kører derefter. Foundry Local vælger automatisk den bedste modelvariant til dit system (CUDA til NVIDIA GPU'er, CPU-version ellers).

4. **Test modellen** ved at stille et spørgsmål i samme terminal:

   ```bash
   Why is the sky blue?
   ```

   Du bør se et svar fra Phi-modellen, der forklarer, hvorfor himlen ser blå ud.

### Verifikation

Du kan verificere, at alt fungerer korrekt med disse kommandoer:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Du kan også besøge `http://localhost:5273` i din browser for at se Foundry Locals webgrænseflade.

## Konfiguration

Applikationen kan konfigureres via `application.properties`:

- `foundry.local.base-url` - Base-URL for Foundry Local (standard: http://localhost:5273)
- `foundry.local.model` - AI-model, der skal bruges (standard: Phi-3.5-mini-instruct-cuda-gpu)

> **Bemærk**: Modelnavnet i konfigurationen skal matche den specifikke variant, som Foundry Local downloadede til dit system. Når du kører `foundry model run phi-3.5-mini`, vælger Foundry Local automatisk og downloader den bedste variant (CUDA til NVIDIA GPU'er, CPU-version ellers). Brug `foundry model list` for at se det præcise modelnavn, der er tilgængeligt i din lokale instans.

## Hurtig Start

### 1. Naviger til Foundry Local-applikationsmappen
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Kør Applikationen

```bash
mvn spring-boot:run
```

Eller byg og kør JAR-filen:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Afhængigheder

Denne applikation bruger OpenAI Java SDK til at kommunikere med Foundry Local. Den vigtigste afhængighed er:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Applikationen er forudkonfigureret til at forbinde til Foundry Local, der kører på standardporten.

## Hvad Applikationen Gør

Når du kører applikationen:

1. **Starter op** som en kommandolinjeapplikation (ingen webserver)
2. **Sender automatisk** en testbesked: "Hello! Can you tell me what you are and what model you're running?"
3. **Viser svaret** fra Foundry Local i konsollen
4. **Afslutter pænt** efter demoen

## Eksempeloutput

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Arkitektur

- **Application.java** - Hoved-Spring Boot-applikation med CommandLineRunner
- **FoundryLocalService.java** - Service, der bruger OpenAI Java SDK til at kommunikere med Foundry Local
- Bruger **OpenAI Java SDK** til type-sikre API-kald
- Automatisk JSON-serialisering/deserialisering håndteres af SDK'en
- Ren konfiguration ved hjælp af Springs `@Value` og `@PostConstruct`-annoteringer

## Kodehøjdepunkter

### OpenAI Java SDK Integration

Applikationen bruger OpenAI Java SDK til at oprette en klient konfigureret til Foundry Local:

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

At lave chat completion-forespørgsler er enkelt og type-sikkert:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Fejlfinding

Hvis du oplever forbindelsesfejl:
1. Verificer, at Foundry Local kører på `http://localhost:5273`
2. Tjek, at en Phi-3.5-mini-modelvariant er tilgængelig med `foundry model list`
3. Sørg for, at modelnavnet i `application.properties` matcher det præcise modelnavn, der vises på listen
4. Sørg for, at ingen firewall blokerer forbindelsen

Almindelige problemer:
- **Model ikke fundet**: Kør `foundry model run phi-3.5-mini` for at downloade og starte modellen
- **Service kører ikke**: Foundry Local-tjenesten kan være stoppet; genstart den med model run-kommandoen
- **Forkert modelnavn**: Brug `foundry model list` for at se tilgængelige modeller og opdatere din konfiguration tilsvarende

**Ansvarsfraskrivelse**:  
Dette dokument er blevet oversat ved hjælp af AI-oversættelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selvom vi bestræber os på at sikre nøjagtighed, skal det bemærkes, at automatiserede oversættelser kan indeholde fejl eller unøjagtigheder. Det originale dokument på dets oprindelige sprog bør betragtes som den autoritative kilde. For kritisk information anbefales professionel menneskelig oversættelse. Vi påtager os ikke ansvar for eventuelle misforståelser eller fejltolkninger, der måtte opstå som følge af brugen af denne oversættelse.