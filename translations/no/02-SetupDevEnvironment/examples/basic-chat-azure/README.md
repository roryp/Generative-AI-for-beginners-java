<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "efd82efe50711d7e257eb943151d682c",
  "translation_date": "2025-07-27T13:42:39+00:00",
  "source_file": "02-SetupDevEnvironment/examples/basic-chat-azure/README.md",
  "language_code": "no"
}
-->
# Grunnleggende Chat med Azure OpenAI - Eksempel fra Start til Slutt

Dette eksemplet viser hvordan du kan lage en enkel Spring Boot-applikasjon som kobler til Azure OpenAI og tester oppsettet ditt.

## Innholdsfortegnelse

- [Forutsetninger](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Kom i Gang](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Konfigurasjonsalternativer](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Alternativ 1: Miljøvariabler (.env-fil) - Anbefalt](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Alternativ 2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Kjøre Applikasjonen](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Ved bruk av Maven](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Ved bruk av VS Code](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Forventet Utdata](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Konfigurasjonsreferanse](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Miljøvariabler](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring-konfigurasjon](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Feilsøking](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Vanlige Problemer](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Feilsøkingsmodus](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Neste Steg](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Ressurser](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Forutsetninger

Før du kjører dette eksemplet, sørg for at du har:

- Fullført [Azure OpenAI-oppsettguiden](../../getting-started-azure-openai.md)  
- Distribuert en Azure OpenAI-ressurs (via Azure AI Foundry-portalen)  
- Distribuert gpt-4o-mini-modellen (eller et alternativ)  
- API-nøkkel og endepunkt-URL fra Azure  

## Kom i Gang

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Konfigurasjonsalternativer

### Alternativ 1: Miljøvariabler (.env-fil) - Anbefalt

**Trinn 1: Opprett konfigurasjonsfilen**
```bash
cp .env.example .env
```

**Trinn 2: Legg til dine Azure OpenAI-legitimasjoner**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Sikkerhetsmerknad**: 
> - Aldri legg `.env`-filen til versjonskontroll
> - `.env`-filen er allerede lagt til i `.gitignore`
> - Hold API-nøklene dine sikre og roter dem regelmessig

### Alternativ 2: GitHub Codespace Secrets

For GitHub Codespaces, sett opp følgende secrets i ditt repository:
- `AZURE_AI_KEY` - Din Azure OpenAI API-nøkkel
- `AZURE_AI_ENDPOINT` - Din Azure OpenAI endepunkt-URL

Applikasjonen oppdager og bruker disse secrets automatisk.

### Alternativ: Direkte Miljøvariabler

<details>
<summary>Klikk for å se plattformspesifikke kommandoer</summary>

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

## Kjøre Applikasjonen

### Ved bruk av Maven

```bash
mvn spring-boot:run
```

### Ved bruk av VS Code

1. Åpne prosjektet i VS Code
2. Trykk `F5` eller bruk "Run and Debug"-panelet
3. Velg "Spring Boot-BasicChatApplication"-konfigurasjonen

> **Merk**: VS Code-konfigurasjonen laster automatisk inn `.env`-filen din

### Forventet Utdata

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

## Konfigurasjonsreferanse

### Miljøvariabler

| Variabel | Beskrivelse | Påkrevd | Eksempel |
|----------|-------------|----------|---------|
| `AZURE_AI_KEY` | Azure OpenAI API-nøkkel | Ja | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI endepunkt-URL | Ja | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Modellens distribusjonsnavn | Nei | `gpt-4o-mini` (standard) |

### Spring-konfigurasjon

`application.yml`-filen konfigurerer:
- **API-nøkkel**: `${AZURE_AI_KEY}` - Fra miljøvariabel
- **Endepunkt**: `${AZURE_AI_ENDPOINT}` - Fra miljøvariabel  
- **Modell**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Fra miljøvariabel med fallback
- **Temperatur**: `0.7` - Kontrollerer kreativitet (0.0 = deterministisk, 1.0 = kreativ)
- **Maks Tokens**: `500` - Maksimal responslengde

## Feilsøking

### Vanlige Problemer

<details>
<summary><strong>Feil: "API-nøkkelen er ikke gyldig"</strong></summary>

- Sjekk at `AZURE_AI_KEY` er riktig satt i `.env`-filen din
- Verifiser at API-nøkkelen er kopiert nøyaktig fra Azure AI Foundry-portalen
- Sørg for at det ikke er ekstra mellomrom eller anførselstegn rundt nøkkelen
</details>

<details>
<summary><strong>Feil: "Endepunktet er ikke gyldig"</strong></summary>

- Sørg for at `AZURE_AI_ENDPOINT` inkluderer hele URL-en (f.eks. `https://your-hub-name.openai.azure.com/`)
- Sjekk for konsistens med skråstrek på slutten
- Verifiser at endepunktet samsvarer med distribusjonsregionen din i Azure
</details>

<details>
<summary><strong>Feil: "Distribusjonen ble ikke funnet"</strong></summary>

- Verifiser at modellens distribusjonsnavn samsvarer nøyaktig med det som er distribuert i Azure
- Sjekk at modellen er vellykket distribuert og aktiv
- Prøv å bruke standard distribusjonsnavn: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Miljøvariabler lastes ikke inn</strong></summary>

- Sørg for at `.env`-filen ligger i prosjektets rotkatalog (samme nivå som `pom.xml`)
- Prøv å kjøre `mvn spring-boot:run` i VS Codes integrerte terminal
- Sjekk at VS Code Java-utvidelsen er riktig installert
- Verifiser at oppstartskonfigurasjonen har `"envFile": "${workspaceFolder}/.env"`
</details>

### Feilsøkingsmodus

For å aktivere detaljert logging, fjern kommentartegnene fra disse linjene i `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Neste Steg

**Oppsett Fullført!** Fortsett læringsreisen din:

[Kapittel 3: Kjerne Generativ AI-teknikker](../../../03-CoreGenerativeAITechniques/README.md)

## Ressurser

- [Spring AI Azure OpenAI Dokumentasjon](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI Service Dokumentasjon](https://learn.microsoft.com/azure/ai-services/openai/)
- [Azure AI Foundry Portal](https://ai.azure.com/)
- [Azure AI Foundry Dokumentasjon](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Ansvarsfraskrivelse**:  
Dette dokumentet er oversatt ved hjelp av AI-oversettelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selv om vi streber etter nøyaktighet, vær oppmerksom på at automatiserte oversettelser kan inneholde feil eller unøyaktigheter. Det originale dokumentet på sitt opprinnelige språk bør anses som den autoritative kilden. For kritisk informasjon anbefales profesjonell menneskelig oversettelse. Vi er ikke ansvarlige for misforståelser eller feiltolkninger som oppstår ved bruk av denne oversettelsen.