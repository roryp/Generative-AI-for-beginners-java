<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "efd82efe50711d7e257eb943151d682c",
  "translation_date": "2025-11-18T17:59:50+00:00",
  "source_file": "02-SetupDevEnvironment/examples/basic-chat-azure/README.md",
  "language_code": "pcm"
}
-->
# Basic Chat wit Azure OpenAI - End-to-End Example

Dis example go show how you fit take create simple Spring Boot app wey go connect to Azure OpenAI and test your setup.

## Table of Contents

- [Prerequisites](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Quick Start](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Configuration Options](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Option 1: Environment Variables (.env file) - Recommended](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Option 2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Running the Application](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Using Maven](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Using VS Code](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Expected Output](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Configuration Reference](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Environment Variables](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring Configuration](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Troubleshooting](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Common Issues](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Debug Mode](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Next Steps](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Resources](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Prerequisites

Before you run dis example, make sure say you don:

- Finish di [Azure OpenAI setup guide](../../getting-started-azure-openai.md)  
- Deploy Azure OpenAI resource (through Azure AI Foundry portal)  
- Deploy gpt-4o-mini model (or another one wey you wan use)  
- Get API key and endpoint URL from Azure  

## Quick Start

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Configuration Options

### Option 1: Environment Variables (.env file) - Recommended

**Step 1: Create your configuration file**
```bash
cp .env.example .env
```

**Step 2: Add your Azure OpenAI credentials**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Security Note**: 
> - No ever commit your `.env` file for version control
> - Di `.env` file don already dey inside `.gitignore`
> - Keep your API keys safe and dey rotate dem regularly

### Option 2: GitHub Codespace Secrets

For GitHub Codespaces, set dis secrets for your repository:
- `AZURE_AI_KEY` - Your Azure OpenAI API key
- `AZURE_AI_ENDPOINT` - Your Azure OpenAI endpoint URL

Di app go detect and use dis secrets automatically.

### Alternative: Direct Environment Variables

<details>
<summary>Click to see platform-specific commands</summary>

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

## Running the Application

### Using Maven

```bash
mvn spring-boot:run
```

### Using VS Code

1. Open di project for VS Code
2. Press `F5` or use di "Run and Debug" panel
3. Select "Spring Boot-BasicChatApplication" configuration

> **Note**: Di VS Code configuration go automatically load your .env file

### Expected Output

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

## Configuration Reference

### Environment Variables

| Variable | Description | Required | Example |
|----------|-------------|----------|---------|
| `AZURE_AI_KEY` | Azure OpenAI API key | Yes | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI endpoint URL | Yes | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Model deployment name | No | `gpt-4o-mini` (default) |

### Spring Configuration

Di `application.yml` file dey configure:
- **API Key**: `${AZURE_AI_KEY}` - From environment variable
- **Endpoint**: `${AZURE_AI_ENDPOINT}` - From environment variable  
- **Model**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - From environment variable wit fallback
- **Temperature**: `0.7` - E dey control creativity (0.0 = deterministic, 1.0 = creative)
- **Max Tokens**: `500` - Maximum response length

## Troubleshooting

### Common Issues

<details>
<summary><strong>Error: "The API key is not valid"</strong></summary>

- Check say your `AZURE_AI_KEY` dey set correct for your `.env` file
- Confirm say di API key dey copy exactly from di Azure AI Foundry portal
- Make sure say no extra space or quotes dey around di key
</details>

<details>
<summary><strong>Error: "The endpoint is not valid"</strong></summary>

- Make sure say your `AZURE_AI_ENDPOINT` get di full URL (e.g., `https://your-hub-name.openai.azure.com/`)
- Check say di trailing slash dey consistent
- Confirm say di endpoint match di Azure deployment region wey you dey use
</details>

<details>
<summary><strong>Error: "The deployment was not found"</strong></summary>

- Confirm say your model deployment name match exactly wetin dey deployed for Azure
- Check say di model dey successfully deployed and active
- Try use di default deployment name: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Environment variables not loading</strong></summary>

- Make sure say your `.env` file dey for di project root directory (di same level wit `pom.xml`)
- Try run `mvn spring-boot:run` for VS Code integrated terminal
- Check say di VS Code Java extension dey properly installed
- Confirm say di launch configuration get `"envFile": "${workspaceFolder}/.env"`
</details>

### Debug Mode

To enable detailed logging, uncomment dis lines for `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Next Steps

**Setup Complete!** Continue your learning journey:

[Chapter 3: Core Generative AI Techniques](../../../03-CoreGenerativeAITechniques/README.md)

## Resources

- [Spring AI Azure OpenAI Documentation](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI Service Documentation](https://learn.microsoft.com/azure/ai-services/openai/)
- [Azure AI Foundry Portal](https://ai.azure.com/)
- [Azure AI Foundry Documentation](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Disclaimer**:  
Dis docu don dey translate wit AI translation service [Co-op Translator](https://github.com/Azure/co-op-translator). Even though we dey try make am accurate, abeg sabi say automated translation fit get mistake or no correct well. Di original docu for im native language na di main correct source. For important information, e good make una use professional human translation. We no go fit take blame for any misunderstanding or wrong interpretation wey fit happen because of dis translation.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->