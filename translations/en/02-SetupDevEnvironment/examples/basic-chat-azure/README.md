# Basic Chat with Azure OpenAI - End-to-End Example

This example demonstrates how to create a simple Spring Boot application that connects to Azure OpenAI and tests your setup.

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

Before running this example, make sure you have:

- Completed the [Azure OpenAI setup guide](../../getting-started-azure-openai.md)  
- Deployed an Azure OpenAI resource (via the Azure AI Foundry portal)  
- Deployed the gpt-4o-mini model (or an alternative)  
- An API key and endpoint URL from Azure  

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
> - Never commit your `.env` file to version control
> - The `.env` file is already in `.gitignore`
> - Keep your API keys secure and rotate them regularly

### Option 2: GitHub Codespace Secrets

For GitHub Codespaces, set these secrets in your repository:
- `AZURE_AI_KEY` - Your Azure OpenAI API key
- `AZURE_AI_ENDPOINT` - Your Azure OpenAI endpoint URL

The application automatically detects and uses these secrets.

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

1. Open the project in VS Code
2. Press `F5` or use the "Run and Debug" panel
3. Select the "Spring Boot-BasicChatApplication" configuration

> **Note**: The VS Code configuration automatically loads your .env file

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

The `application.yml` file configures:
- **API Key**: `${AZURE_AI_KEY}` - From environment variable
- **Endpoint**: `${AZURE_AI_ENDPOINT}` - From environment variable  
- **Model**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - From environment variable with fallback
- **Temperature**: `0.7` - Controls creativity (0.0 = deterministic, 1.0 = creative)
- **Max Tokens**: `500` - Maximum response length

## Troubleshooting

### Common Issues

<details>
<summary><strong>Error: "The API key is not valid"</strong></summary>

- Check that your `AZURE_AI_KEY` is correctly set in your `.env` file
- Verify the API key is copied exactly from the Azure AI Foundry portal
- Ensure no extra spaces or quotes around the key
</details>

<details>
<summary><strong>Error: "The endpoint is not valid"</strong></summary>

- Ensure your `AZURE_AI_ENDPOINT` includes the full URL (e.g., `https://your-hub-name.openai.azure.com/`)
- Check for trailing slash consistency
- Verify the endpoint matches your Azure deployment region
</details>

<details>
<summary><strong>Error: "The deployment was not found"</strong></summary>

- Verify your model deployment name matches exactly what's deployed in Azure
- Check that the model is successfully deployed and active
- Try using the default deployment name: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Environment variables not loading</strong></summary>

- Ensure your `.env` file is in the project root directory (same level as `pom.xml`)
- Try running `mvn spring-boot:run` in VS Code's integrated terminal
- Check that the VS Code Java extension is properly installed
- Verify the launch configuration has `"envFile": "${workspaceFolder}/.env"`
</details>

### Debug Mode

To enable detailed logging, uncomment these lines in `application.yml`:

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

**Disclaimer**:  
This document has been translated using the AI translation service [Co-op Translator](https://github.com/Azure/co-op-translator). While we strive for accuracy, please note that automated translations may contain errors or inaccuracies. The original document in its native language should be regarded as the authoritative source. For critical information, professional human translation is recommended. We are not responsible for any misunderstandings or misinterpretations resulting from the use of this translation.