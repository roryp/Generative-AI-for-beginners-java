# Basis Chat met Azure OpenAI - End-to-End Voorbeeld

Dit voorbeeld laat zien hoe je een eenvoudige Spring Boot-applicatie maakt die verbinding maakt met Azure OpenAI en je setup test.

## Inhoudsopgave

- [Vereisten](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Snelle Start](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Configuratieopties](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Optie 1: Omgevingsvariabelen (.env-bestand) - Aanbevolen](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Optie 2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [De Applicatie Uitvoeren](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Met Maven](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Met VS Code](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Verwachte Output](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Configuratiereferentie](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Omgevingsvariabelen](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring Configuratie](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Problemen Oplossen](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Veelvoorkomende Problemen](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Debugmodus](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Volgende Stappen](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Bronnen](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Vereisten

Voordat je dit voorbeeld uitvoert, zorg ervoor dat je:

- De [Azure OpenAI setup-gids](../../getting-started-azure-openai.md) hebt voltooid  
- Een Azure OpenAI-resource hebt gedeployed (via het Azure AI Foundry-portaal)  
- Het gpt-4o-mini model (of alternatief) hebt gedeployed  
- Een API-sleutel en endpoint-URL van Azure hebt  

## Snelle Start

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Configuratieopties

### Optie 1: Omgevingsvariabelen (.env-bestand) - Aanbevolen

**Stap 1: Maak je configuratiebestand**
```bash
cp .env.example .env
```

**Stap 2: Voeg je Azure OpenAI-credentials toe**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Beveiligingsnotitie**: 
> - Commit je `.env`-bestand nooit naar versiebeheer
> - Het `.env`-bestand staat al in `.gitignore`
> - Houd je API-sleutels veilig en roteer ze regelmatig

### Optie 2: GitHub Codespace Secrets

Voor GitHub Codespaces, stel deze secrets in je repository in:
- `AZURE_AI_KEY` - Je Azure OpenAI API-sleutel
- `AZURE_AI_ENDPOINT` - Je Azure OpenAI endpoint-URL

De applicatie detecteert en gebruikt deze secrets automatisch.

### Alternatief: Directe Omgevingsvariabelen

<details>
<summary>Klik om platform-specifieke commando's te zien</summary>

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

## De Applicatie Uitvoeren

### Met Maven

```bash
mvn spring-boot:run
```

### Met VS Code

1. Open het project in VS Code
2. Druk op `F5` of gebruik het "Run and Debug"-paneel
3. Selecteer de configuratie "Spring Boot-BasicChatApplication"

> **Notitie**: De VS Code-configuratie laadt automatisch je .env-bestand

### Verwachte Output

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

## Configuratiereferentie

### Omgevingsvariabelen

| Variabele | Beschrijving | Vereist | Voorbeeld |
|-----------|--------------|---------|-----------|
| `AZURE_AI_KEY` | Azure OpenAI API-sleutel | Ja | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI endpoint-URL | Ja | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Model deployment naam | Nee | `gpt-4o-mini` (standaard) |

### Spring Configuratie

Het `application.yml`-bestand configureert:
- **API-sleutel**: `${AZURE_AI_KEY}` - Uit omgevingsvariabele
- **Endpoint**: `${AZURE_AI_ENDPOINT}` - Uit omgevingsvariabele  
- **Model**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Uit omgevingsvariabele met fallback
- **Temperatuur**: `0.7` - Bepaalt creativiteit (0.0 = deterministisch, 1.0 = creatief)
- **Max Tokens**: `500` - Maximale lengte van de respons

## Problemen Oplossen

### Veelvoorkomende Problemen

<details>
<summary><strong>Fout: "De API-sleutel is niet geldig"</strong></summary>

- Controleer of je `AZURE_AI_KEY` correct is ingesteld in je `.env`-bestand
- Verifieer dat de API-sleutel exact is gekopieerd van het Azure AI Foundry-portaal
- Zorg ervoor dat er geen extra spaties of aanhalingstekens rond de sleutel staan
</details>

<details>
<summary><strong>Fout: "Het endpoint is niet geldig"</strong></summary>

- Zorg ervoor dat je `AZURE_AI_ENDPOINT` de volledige URL bevat (bijv. `https://your-hub-name.openai.azure.com/`)
- Controleer de consistentie van de trailing slash
- Verifieer dat het endpoint overeenkomt met je Azure deployment-regio
</details>

<details>
<summary><strong>Fout: "De deployment is niet gevonden"</strong></summary>

- Verifieer dat de naam van je model deployment exact overeenkomt met wat is gedeployed in Azure
- Controleer of het model succesvol is gedeployed en actief is
- Probeer de standaard deployment naam: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Omgevingsvariabelen worden niet geladen</strong></summary>

- Zorg ervoor dat je `.env`-bestand in de projectrootdirectory staat (op hetzelfde niveau als `pom.xml`)
- Probeer `mvn spring-boot:run` uit te voeren in de geïntegreerde terminal van VS Code
- Controleer of de VS Code Java-extensie correct is geïnstalleerd
- Verifieer dat de launch-configuratie `"envFile": "${workspaceFolder}/.env"` bevat
</details>

### Debugmodus

Om gedetailleerde logging in te schakelen, uncomment deze regels in `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Volgende Stappen

**Setup Voltooid!** Ga verder met je leertraject:

[Hoofdstuk 3: Kerntechnieken voor Generatieve AI](../../../03-CoreGenerativeAITechniques/README.md)

## Bronnen

- [Spring AI Azure OpenAI Documentatie](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI Service Documentatie](https://learn.microsoft.com/azure/ai-services/openai/)
- [Azure AI Foundry Portaal](https://ai.azure.com/)
- [Azure AI Foundry Documentatie](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Disclaimer**:  
Dit document is vertaald met behulp van de AI-vertalingsservice [Co-op Translator](https://github.com/Azure/co-op-translator). Hoewel we streven naar nauwkeurigheid, dient u zich ervan bewust te zijn dat geautomatiseerde vertalingen fouten of onnauwkeurigheden kunnen bevatten. Het originele document in de oorspronkelijke taal moet worden beschouwd als de gezaghebbende bron. Voor cruciale informatie wordt professionele menselijke vertaling aanbevolen. Wij zijn niet aansprakelijk voor misverstanden of verkeerde interpretaties die voortvloeien uit het gebruik van deze vertaling.