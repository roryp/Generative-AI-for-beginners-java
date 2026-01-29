# Grundlæggende Chat med Azure OpenAI - End-to-End Eksempel

Dette eksempel viser, hvordan man opretter en simpel Spring Boot-applikation, der forbinder til Azure OpenAI og tester din opsætning.

## Indholdsfortegnelse

- [Forudsætninger](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Hurtig Start](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Konfigurationsmuligheder](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Mulighed 1: Miljøvariabler (.env-fil) - Anbefalet](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Mulighed 2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Kørsel af Applikationen](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Ved Brug af Maven](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Ved Brug af VS Code](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Forventet Output](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Konfigurationsreference](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Miljøvariabler](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring Konfiguration](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Fejlfinding](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Almindelige Problemer](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Debug-tilstand](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Næste Skridt](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Ressourcer](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Forudsætninger

Før du kører dette eksempel, skal du sikre dig, at du har:

- Fuldført [Azure OpenAI opsætningsguiden](../../getting-started-azure-openai.md)  
- Udrullet Azure OpenAI-ressource (via Azure AI Foundry-portalen)  
- Udrullet gpt-4o-mini model (eller alternativ)  
- API-nøgle og endpoint-URL fra Azure  

## Hurtig Start

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Konfigurationsmuligheder

### Mulighed 1: Miljøvariabler (.env-fil) - Anbefalet

**Trin 1: Opret din konfigurationsfil**
```bash
cp .env.example .env
```

**Trin 2: Tilføj dine Azure OpenAI-legitimationsoplysninger**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Sikkerhedsnotat**: 
> - Undlad at committe din `.env`-fil til versionskontrol
> - `.env`-filen er allerede inkluderet i `.gitignore`
> - Hold dine API-nøgler sikre og roter dem regelmæssigt

### Mulighed 2: GitHub Codespace Secrets

For GitHub Codespaces skal du indstille disse secrets i dit repository:
- `AZURE_AI_KEY` - Din Azure OpenAI API-nøgle
- `AZURE_AI_ENDPOINT` - Din Azure OpenAI endpoint-URL

Applikationen registrerer og bruger automatisk disse secrets.

### Alternativ: Direkte Miljøvariabler

<details>
<summary>Klik for at se platform-specifikke kommandoer</summary>

**Linux/macOS (bash/zsh):**
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Command Prompt):**
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## Kørsel af Applikationen

### Ved Brug af Maven

```bash
mvn spring-boot:run
```

### Ved Brug af VS Code

1. Åbn projektet i VS Code
2. Tryk på `F5` eller brug "Run and Debug"-panelet
3. Vælg "Spring Boot-BasicChatApplication"-konfigurationen

> **Note**: VS Code-konfigurationen indlæser automatisk din .env-fil

### Forventet Output

```
Starting Basic Chat with Azure OpenAI...
Environment variables loaded successfully
Connecting to Azure OpenAI...
Sending prompt: What is AI in a short sentence? Max 100 words.

AI Response:
================
AI, or Artificial Intelligence, is the simulation of human intelligence in machines programmed to think and learn like humans.
================

Success! Azure OpenAI connection is working correctly.
```

## Konfigurationsreference

### Miljøvariabler

| Variabel | Beskrivelse | Påkrævet | Eksempel |
|----------|-------------|----------|---------|
| `AZURE_AI_KEY` | Azure OpenAI API-nøgle | Ja | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI endpoint-URL | Ja | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Model-udrulningsnavn | Nej | `gpt-4o-mini` (standard) |

### Spring Konfiguration

`application.yml`-filen konfigurerer:
- **API-nøgle**: `${AZURE_AI_KEY}` - Fra miljøvariabel
- **Endpoint**: `${AZURE_AI_ENDPOINT}` - Fra miljøvariabel  
- **Model**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Fra miljøvariabel med fallback
- **Temperatur**: `0.7` - Styrer kreativitet (0.0 = deterministisk, 1.0 = kreativ)
- **Max Tokens**: `500` - Maksimal svarlængde

## Fejlfinding

### Almindelige Problemer

<details>
<summary><strong>Fejl: "API-nøglen er ikke gyldig"</strong></summary>

- Tjek, at din `AZURE_AI_KEY` er korrekt indstillet i din `.env`-fil
- Bekræft, at API-nøglen er kopieret præcist fra Azure AI Foundry-portalen
- Sørg for, at der ikke er ekstra mellemrum eller anførselstegn omkring nøglen
</details>

<details>
<summary><strong>Fejl: "Endpoint er ikke gyldigt"</strong></summary>

- Sørg for, at din `AZURE_AI_ENDPOINT` inkluderer den fulde URL (f.eks. `https://your-hub-name.openai.azure.com/`)
- Tjek for konsistens med afsluttende skråstreg
- Bekræft, at endpoint matcher din Azure-udrulningsregion
</details>

<details>
<summary><strong>Fejl: "Udrulningen blev ikke fundet"</strong></summary>

- Bekræft, at dit model-udrulningsnavn matcher præcist det, der er udrullet i Azure
- Tjek, at modellen er succesfuldt udrullet og aktiv
- Prøv at bruge standard-udrulningsnavnet: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Miljøvariabler indlæses ikke</strong></summary>

- Sørg for, at din `.env`-fil er i projektets rodmappe (samme niveau som `pom.xml`)
- Prøv at køre `mvn spring-boot:run` i VS Codes integrerede terminal
- Tjek, at VS Code Java-udvidelsen er korrekt installeret
- Bekræft, at launch-konfigurationen har `"envFile": "${workspaceFolder}/.env"`
</details>

### Debug-tilstand

For at aktivere detaljeret logning, fjern kommentaren fra disse linjer i `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Næste Skridt

**Opsætning Fuldført!** Fortsæt din læringsrejse:

[Kapitel 3: Kerne Generative AI Teknikker](../../../03-CoreGenerativeAITechniques/README.md)

## Ressourcer

- [Spring AI Azure OpenAI Dokumentation](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI Service Dokumentation](https://learn.microsoft.com/azure/ai-services/openai/)
- [Azure AI Foundry Portal](https://ai.azure.com/)
- [Azure AI Foundry Dokumentation](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Ansvarsfraskrivelse**:  
Dette dokument er blevet oversat ved hjælp af AI-oversættelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selvom vi bestræber os på nøjagtighed, skal du være opmærksom på, at automatiserede oversættelser kan indeholde fejl eller unøjagtigheder. Det originale dokument på dets oprindelige sprog bør betragtes som den autoritative kilde. For kritisk information anbefales professionel menneskelig oversættelse. Vi påtager os intet ansvar for misforståelser eller fejltolkninger, der måtte opstå som følge af brugen af denne oversættelse.