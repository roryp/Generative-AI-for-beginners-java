# Setting Up the Development Environment for Azure AI Foundry

> This guide sets up **Azure AI Foundry** models for the Java AI apps in this course, using **keyless** authentication (Microsoft Entra ID) — no API keys to manage. New to the tooling? Start with the [development environment guide](./README.md).

This guide sets up **Azure AI Foundry** models for the Java AI apps in this course. You have two paths:

- **Option A — Provision with `azd` + Bicep (recommended):** one command deploys the Foundry account and models as code. No portal clicking.
- **Option B — Create resources manually** in the Azure AI Foundry portal.

Both paths use **keyless authentication** (Microsoft Entra ID) — there are no API keys to copy or leak.

## Table of Contents

- [What Gets Created](#what-gets-created)
- [Prerequisites](#prerequisites)
- [Option A: Provision with azd + Bicep (Recommended)](#option-a-provision-with-azd--bicep-recommended)
- [Option B: Create Resources Manually](#option-b-create-resources-manually)
- [Configure Your Environment](#configure-your-environment)
- [Test Your Setup](#test-your-setup)
- [What's Next?](#whats-next)
- [Resources](#resources)
- [Additional Resources](#additional-resources)

## What Gets Created

The Bicep templates in [`infra/`](./infra/) provision:

- An **Azure AI Foundry** account (`Microsoft.CognitiveServices/accounts`, kind `AIServices`) with a project
- A **chat** deployment — `gpt-4o-mini`
- An **embedding** deployment — `text-embedding-3-small` (used in later chapters)
- A **keyless role assignment** (`Cognitive Services OpenAI User`) so you sign in with `az login` instead of managing keys

## Prerequisites

- An [Azure subscription](https://azure.microsoft.com/free/)
- [Azure Developer CLI (`azd`)](https://aka.ms/azure-dev/install)
- [Azure CLI (`az`)](https://learn.microsoft.com/cli/azure/install-azure-cli)
- [Java 21+](https://learn.microsoft.com/java/openjdk/download) and [Maven 3.9+](https://maven.apache.org/download.cgi)

## Option A: Provision with azd + Bicep (Recommended)

From the `02-SetupDevEnvironment` folder:

```bash
cd 02-SetupDevEnvironment

# Sign in (both tools)
azd auth login
az login

# Provision the Foundry account + model deployments
azd up
```

`azd` prompts for an **environment name** (for example `genai-java`) and a **region**. Choose a region where `gpt-4o-mini` and `text-embedding-3-small` are available — for example `eastus2` or `swedencentral`.

When provisioning finishes, azd:

1. Deploys everything defined in [`infra/main.bicep`](./infra/main.bicep).
2. Runs a postprovision hook that writes [`examples/basic-chat-azure/.env`](./examples/basic-chat-azure/) with your endpoint and deployment names (no secrets).

> **Tip:** Re-run `azd up` any time to apply changes. Run `azd down` to delete everything and stop incurring cost.

To see the generated settings:

```bash
azd env get-values
```

Now skip to [Test Your Setup](#test-your-setup).

## Option B: Create Resources Manually

Prefer the portal? Create the resources by hand:

1. Go to the [Azure AI Foundry portal](https://ai.azure.com/) and sign in.
2. **Create a project** (this also creates an AI Foundry resource). Give it a name like `GenAIJava`.
3. In your project, open **Models + endpoints** → **Deploy model** → **Deploy base model**.
4. Deploy **gpt-4o-mini** (deployment name `gpt-4o-mini`). Repeat for **text-embedding-3-small** if you want the embedding examples.
5. From **Overview**, copy the **endpoint** (for example `https://<resource>.openai.azure.com/`).
6. Grant yourself keyless access: on the resource, open **Access control (IAM)** → **Add role assignment** → assign **Cognitive Services OpenAI User** to your account.

> **Still having trouble?** See the [Azure AI Foundry documentation](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects).

## Configure Your Environment

**If you used Option A (`azd up`)**, your settings file is already written — there's nothing to configure. Skip to [Test Your Setup](#test-your-setup).

**If you used Option B (manual)**, create the example's `.env` file yourself:

```bash
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
```

Edit `.env` with your endpoint (no key — auth is keyless):

```bash
AZURE_OPENAI_ENDPOINT=https://<your-resource>.openai.azure.com/
AZURE_OPENAI_DEPLOYMENT=gpt-4o-mini
```

> **Security note:** There is no API key to store. You authenticate with Microsoft Entra ID via `az login` (locally) or a managed identity (in Azure). The `.env` file holds only non-secret settings and is already covered by `.gitignore`.

## Test Your Setup

Make sure you're signed in so keyless auth can get a token, then run the example:

```bash
cd 02-SetupDevEnvironment/examples/basic-chat-azure

az login          # if you aren't already signed in
mvn clean spring-boot:run
```

You should see a response from the `gpt-4o-mini` model!

> **VS Code users:** Press `F5` to run. The app loads your `.env` automatically.

> **Full example:** See the [Basic Chat with Azure AI Foundry example](./examples/basic-chat-azure/README.md) for details and troubleshooting.

## What's Next?

**Setup complete!** You now have:
- Azure AI Foundry with `gpt-4o-mini` and `text-embedding-3-small` deployed
- Keyless authentication (Microsoft Entra ID) — no keys to manage
- A local `.env` with your endpoint and deployment names
- A Java development environment ready to go

**Continue to** [Chapter 3: Core Generative AI Techniques](../03-CoreGenerativeAITechniques/README.md) to start building AI applications!

## Resources

- [Azure Developer CLI (azd)](https://aka.ms/azure-dev/install)
- [Keyless authentication with Microsoft Entra ID](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/configure-entra-id)
- [Azure AI Foundry Documentation](https://learn.microsoft.com/azure/ai-foundry/)
- [Spring AI Azure OpenAI Documentation](https://docs.spring.io/spring-ai/reference/api/chat/azure-openai-chat.html)
- [Azure OpenAI Java SDK](https://learn.microsoft.com/java/api/overview/azure/ai-openai-readme)

## Additional Resources

- [Download VS Code](https://code.visualstudio.com/Download)
- [Get Docker Desktop](https://www.docker.com/products/docker-desktop)
- [Dev Container Configuration](../.devcontainer/devcontainer.json)
