# Grundläggande chatt med Azure OpenAI - Komplett exempel

Det här exemplet visar hur du skapar en enkel Spring Boot-applikation som ansluter till Azure OpenAI och testar din installation.

## Innehållsförteckning

- [Förutsättningar](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Snabbstart](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Konfigurationsalternativ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Alternativ 1: Miljövariabler (.env-fil) - Rekommenderas](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Alternativ 2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Köra applikationen](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Med Maven](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Med VS Code](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Förväntad output](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Konfigurationsreferens](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Miljövariabler](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring-konfiguration](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Felsökning](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Vanliga problem](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Felsökningsläge](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Nästa steg](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Resurser](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Förutsättningar

Innan du kör detta exempel, se till att du har:

- Slutfört [Azure OpenAI installationsguide](../../getting-started-azure-openai.md)  
- Distribuerat Azure OpenAI-resursen (via Azure AI Foundry-portalen)  
- Distribuerat gpt-4o-mini-modellen (eller alternativ)  
- API-nyckel och slutpunkts-URL från Azure  

## Snabbstart

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Konfigurationsalternativ

### Alternativ 1: Miljövariabler (.env-fil) - Rekommenderas

**Steg 1: Skapa din konfigurationsfil**
```bash
cp .env.example .env
```

**Steg 2: Lägg till dina Azure OpenAI-uppgifter**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Säkerhetsnotering**: 
> - Lämna aldrig in din `.env`-fil till versionskontroll
> - `.env`-filen är redan inkluderad i `.gitignore`
> - Håll dina API-nycklar säkra och rotera dem regelbundet

### Alternativ 2: GitHub Codespace Secrets

För GitHub Codespaces, ställ in dessa hemligheter i ditt repository:
- `AZURE_AI_KEY` - Din Azure OpenAI API-nyckel
- `AZURE_AI_ENDPOINT` - Din Azure OpenAI slutpunkts-URL

Applikationen upptäcker och använder dessa hemligheter automatiskt.

### Alternativ: Direkt miljövariabler

<details>
<summary>Klicka för att se plattformspecifika kommandon</summary>

**Linux/macOS (bash/zsh):**
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Kommandotolken):**
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

## Köra applikationen

### Med Maven

```bash
mvn spring-boot:run
```

### Med VS Code

1. Öppna projektet i VS Code
2. Tryck på `F5` eller använd panelen "Run and Debug"
3. Välj konfigurationen "Spring Boot-BasicChatApplication"

> **Note**: VS Code-konfigurationen laddar automatiskt din .env-fil

### Förväntad output

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

## Konfigurationsreferens

### Miljövariabler

| Variabel | Beskrivning | Obligatorisk | Exempel |
|----------|-------------|--------------|---------|
| `AZURE_AI_KEY` | Azure OpenAI API-nyckel | Ja | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI slutpunkts-URL | Ja | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Modellens distributionsnamn | Nej | `gpt-4o-mini` (standard) |

### Spring-konfiguration

Filen `application.yml` konfigurerar:
- **API-nyckel**: `${AZURE_AI_KEY}` - Från miljövariabel
- **Slutpunkt**: `${AZURE_AI_ENDPOINT}` - Från miljövariabel  
- **Modell**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Från miljövariabel med reservvärde
- **Temperatur**: `0.7` - Styr kreativitet (0.0 = deterministisk, 1.0 = kreativ)
- **Maximalt antal tokens**: `500` - Maximal svarslängd

## Felsökning

### Vanliga problem

<details>
<summary><strong>Fel: "API-nyckeln är inte giltig"</strong></summary>

- Kontrollera att din `AZURE_AI_KEY` är korrekt inställd i din `.env`-fil
- Verifiera att API-nyckeln är exakt kopierad från Azure AI Foundry-portalen
- Se till att det inte finns några extra mellanslag eller citattecken runt nyckeln
</details>

<details>
<summary><strong>Fel: "Slutpunkten är inte giltig"</strong></summary>

- Se till att din `AZURE_AI_ENDPOINT` innehåller hela URL:en (t.ex. `https://your-hub-name.openai.azure.com/`)
- Kontrollera konsistensen för avslutande snedstreck
- Verifiera att slutpunkten matchar din Azure-distributionsregion
</details>

<details>
<summary><strong>Fel: "Distributionsnamnet hittades inte"</strong></summary>

- Verifiera att modellens distributionsnamn exakt matchar det som är distribuerat i Azure
- Kontrollera att modellen är framgångsrikt distribuerad och aktiv
- Försök använda standarddistributionsnamnet: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Miljövariabler laddas inte</strong></summary>

- Kontrollera att din `.env`-fil finns i projektets rotkatalog (samma nivå som `pom.xml`)
- Försök köra `mvn spring-boot:run` i VS Codes integrerade terminal
- Kontrollera att VS Code Java-tillägget är korrekt installerat
- Verifiera att startkonfigurationen har `"envFile": "${workspaceFolder}/.env"`
</details>

### Felsökningsläge

För att aktivera detaljerad loggning, avkommentera dessa rader i `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Nästa steg

**Installationen är klar!** Fortsätt din läranderesa:

[Kapitel 3: Grundläggande tekniker för generativ AI](../../../03-CoreGenerativeAITechniques/README.md)

## Resurser

- [Spring AI Azure OpenAI-dokumentation](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI Service-dokumentation](https://learn.microsoft.com/azure/ai-services/openai/)
- [Azure AI Foundry Portal](https://ai.azure.com/)
- [Azure AI Foundry-dokumentation](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Ansvarsfriskrivning**:  
Detta dokument har översatts med hjälp av AI-översättningstjänsten [Co-op Translator](https://github.com/Azure/co-op-translator). Även om vi strävar efter noggrannhet, bör du vara medveten om att automatiserade översättningar kan innehålla fel eller inexaktheter. Det ursprungliga dokumentet på dess originalspråk bör betraktas som den auktoritativa källan. För kritisk information rekommenderas professionell mänsklig översättning. Vi ansvarar inte för eventuella missförstånd eller feltolkningar som uppstår vid användning av denna översättning.