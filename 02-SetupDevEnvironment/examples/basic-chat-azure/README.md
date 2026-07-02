# Basic Chat with Azure AI Foundry - End-to-End Example

This example is a simple Spring Boot application that connects to an **Azure AI Foundry** model using **keyless authentication** (Microsoft Entra ID) and tests your setup. It uses Spring AI's `ChatClient`.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Quick Start](#quick-start)
- [How Authentication Works](#how-authentication-works)
- [Running the Application](#running-the-application)
  - [Using Maven](#using-maven)
  - [Using VS Code](#using-vs-code)
  - [Expected Output](#expected-output)
- [Configuration Reference](#configuration-reference)
  - [Environment Variables](#environment-variables)
  - [Spring Configuration](#spring-configuration)
- [Troubleshooting](#troubleshooting)
  - [Common Issues](#common-issues)
  - [Debug Mode](#debug-mode)
- [Next Steps](#next-steps)
- [Resources](#resources)

## Prerequisites

Before running this example, ensure you have:

- An Azure AI Foundry resource with a `gpt-4o-mini` deployment — provision it with `azd up` or manually via the [Azure AI Foundry setup guide](../../getting-started-azure-openai.md)
- The **Cognitive Services OpenAI User** role on that resource (the Bicep templates assign this for you)
- The [Azure CLI (`az`)](https://learn.microsoft.com/cli/azure/install-azure-cli), signed in with `az login`
- Java 21+ and Maven 3.9+

> **No API key required** — authentication is keyless via Microsoft Entra ID.

## Quick Start

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Sign in so keyless auth can get a token
az login

# 3. Configure the endpoint
#    - If you ran `azd up`, .env was written for you (skip this).
#    - Otherwise copy the template and set AZURE_OPENAI_ENDPOINT:
cp .env.example .env

# 4. Run the application
mvn spring-boot:run
```

## How Authentication Works

This example authenticates with **Microsoft Entra ID** — there is no API key.

When only `spring.ai.azure.openai.endpoint` is set (and no api-key), Spring AI builds the Azure OpenAI client with [`DefaultAzureCredential`](https://learn.microsoft.com/java/api/com.azure.identity.defaultazurecredential). That credential automatically finds a token from your `az login` session locally, or from a managed identity when running in Azure — so the same code works in both places with no changes.

## Running the Application

### Using Maven

```bash
mvn spring-boot:run
```

### Using VS Code

1. Open the project in VS Code
2. Press `F5` or use the "Run and Debug" panel
3. Select "Spring Boot-BasicChatApplication" configuration

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
| `AZURE_OPENAI_ENDPOINT` | Foundry (Azure OpenAI) endpoint URL | Yes | `https://my-resource.openai.azure.com/` |
| `AZURE_OPENAI_DEPLOYMENT` | Chat model deployment name | No | `gpt-4o-mini` (default) |

> There is **no** API key variable — authentication is keyless (Microsoft Entra ID via `az login`).

### Spring Configuration

The `application.yml` file configures:
- **Endpoint**: `${AZURE_OPENAI_ENDPOINT}` - From environment variable
- **Deployment**: `${AZURE_OPENAI_DEPLOYMENT:gpt-4o-mini}` - From environment variable with fallback
- **Auth**: keyless — no `api-key` is set, so Spring AI uses `DefaultAzureCredential`
- **Temperature**: `0.7` - Controls creativity (0.0 = deterministic, 1.0 = creative)
- **Max Tokens**: `500` - Maximum response length

## Troubleshooting

### Common Issues

<details>
<summary><strong>Error: 401 / "PermissionDenied" / token errors</strong></summary>

- Run `az login` — keyless auth needs an active sign-in to get a token
- Verify your account has the **Cognitive Services OpenAI User** role on the resource
- If you just assigned the role, wait a minute for it to propagate
- Confirm you're in the right tenant/subscription (`az account show`)
</details>

<details>
<summary><strong>Error: "The endpoint is not valid" / connection errors</strong></summary>

- Ensure `AZURE_OPENAI_ENDPOINT` is the full base URL (e.g., `https://your-resource.openai.azure.com/`)
- Check for trailing slash consistency
- Verify the endpoint matches your provisioned resource (`azd env get-values`)
</details>

<details>
<summary><strong>Error: "The deployment was not found"</strong></summary>

- Verify `AZURE_OPENAI_DEPLOYMENT` matches a deployment name in Azure
- Check that the model is successfully deployed and active
- The default deployment name is `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Environment variables not loading</strong></summary>

- Ensure your `.env` file is in the project root directory (same level as `pom.xml`)
- Try running `mvn spring-boot:run` in VS Code's integrated terminal
- Check that the VS Code Java extension is properly installed
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

- [Spring AI Azure OpenAI Documentation](https://docs.spring.io/spring-ai/reference/api/chat/azure-openai-chat.html)
- [Keyless authentication with Microsoft Entra ID](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/configure-entra-id)
- [Azure AI Foundry Portal](https://ai.azure.com/)
- [Azure AI Foundry Documentation](https://learn.microsoft.com/azure/ai-foundry/)
