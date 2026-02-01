# ਬੇਸਿਕ ਚੈਟ ਨਾਲ Azure OpenAI - ਐਂਡ-ਟੂ-ਐਂਡ ਉਦਾਹਰਨ

ਇਹ ਉਦਾਹਰਨ ਦਿਖਾਉਂਦੀ ਹੈ ਕਿ ਕਿਵੇਂ ਇੱਕ ਸਧਾਰਨ ਸਪ੍ਰਿੰਗ ਬੂਟ ਐਪਲੀਕੇਸ਼ਨ ਬਣਾਈ ਜਾ ਸਕਦੀ ਹੈ ਜੋ Azure OpenAI ਨਾਲ ਜੁੜਦੀ ਹੈ ਅਤੇ ਤੁਹਾਡੇ ਸੈਟਅੱਪ ਦੀ ਜਾਂਚ ਕਰਦੀ ਹੈ।

## ਸਮੱਗਰੀ ਦੀ ਸੂਚੀ

- [ਪੂਰਵ ਸ਼ਰਤਾਂ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ਤੁਰੰਤ ਸ਼ੁਰੂਆਤ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ਕੰਫਿਗਰੇਸ਼ਨ ਵਿਕਲਪ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ਵਿਕਲਪ 1: ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ (.env ਫਾਈਲ) - ਸਿਫਾਰਸ਼ੀ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ਵਿਕਲਪ 2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ਐਪਲੀਕੇਸ਼ਨ ਚਲਾਉਣਾ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Maven ਦੀ ਵਰਤੋਂ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [VS Code ਦੀ ਵਰਤੋਂ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ਉਮੀਦ ਕੀਤੀ ਆਉਟਪੁੱਟ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ਕੰਫਿਗਰੇਸ਼ਨ ਰਿਫਰੈਂਸ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ਸਪ੍ਰਿੰਗ ਕੰਫਿਗਰੇਸ਼ਨ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ਟ੍ਰਬਲਸ਼ੂਟਿੰਗ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ਆਮ ਸਮੱਸਿਆਵਾਂ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ਡਿਬੱਗ ਮੋਡ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ਅਗਲੇ ਕਦਮ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ਸੰਸਾਧਨ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## ਪੂਰਵ ਸ਼ਰਤਾਂ

ਇਹ ਉਦਾਹਰਨ ਚਲਾਉਣ ਤੋਂ ਪਹਿਲਾਂ, ਇਹ ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਤੁਹਾਡੇ ਕੋਲ:

- [Azure OpenAI ਸੈਟਅੱਪ ਗਾਈਡ](../../getting-started-azure-openai.md) ਪੂਰੀ ਕੀਤੀ ਹੋਈ ਹੈ  
- Azure OpenAI ਸਰੋਤ (Azure AI Foundry ਪੋਰਟਲ ਰਾਹੀਂ) ਡਿਪਲੌਇਡ ਕੀਤਾ ਹੋਇਆ ਹੈ  
- gpt-4o-mini ਮਾਡਲ (ਜਾਂ ਵਿਕਲਪਕ) ਡਿਪਲੌਇਡ ਕੀਤਾ ਹੋਇਆ ਹੈ  
- Azure ਤੋਂ API ਕੁੰਜੀ ਅਤੇ ਐਂਡਪੌਇੰਟ URL  

## ਤੁਰੰਤ ਸ਼ੁਰੂਆਤ

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## ਕੰਫਿਗਰੇਸ਼ਨ ਵਿਕਲਪ

### ਵਿਕਲਪ 1: ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ (.env ਫਾਈਲ) - ਸਿਫਾਰਸ਼ੀ

**ਪਦਾਅਵ 1: ਆਪਣੀ ਕੰਫਿਗਰੇਸ਼ਨ ਫਾਈਲ ਬਣਾਓ**
```bash
cp .env.example .env
```

**ਪਦਾਅਵ 2: ਆਪਣੀ Azure OpenAI ਸਨਦਾਂ ਸ਼ਾਮਲ ਕਰੋ**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **ਸੁਰੱਖਿਆ ਨੋਟ**: 
> - ਆਪਣੀ `.env` ਫਾਈਲ ਨੂੰ ਵਰਜਨ ਕੰਟਰੋਲ ਵਿੱਚ ਕਦੇ ਵੀ ਕਮਿਟ ਨਾ ਕਰੋ
> - `.env` ਫਾਈਲ ਪਹਿਲਾਂ ਹੀ `.gitignore` ਵਿੱਚ ਹੈ
> - ਆਪਣੀਆਂ API ਕੁੰਜੀਆਂ ਸੁਰੱਖਿਅਤ ਰੱਖੋ ਅਤੇ ਉਨ੍ਹਾਂ ਨੂੰ ਨਿਯਮਿਤ ਤੌਰ 'ਤੇ ਰੋਟੇਟ ਕਰੋ

### ਵਿਕਲਪ 2: GitHub Codespace Secrets

GitHub Codespaces ਲਈ, ਆਪਣੇ ਰਿਪੋਜ਼ਟਰੀ ਵਿੱਚ ਇਹ secrets ਸੈਟ ਕਰੋ:
- `AZURE_AI_KEY` - ਤੁਹਾਡੀ Azure OpenAI API ਕੁੰਜੀ
- `AZURE_AI_ENDPOINT` - ਤੁਹਾਡਾ Azure OpenAI ਐਂਡਪੌਇੰਟ URL

ਐਪਲੀਕੇਸ਼ਨ ਆਪਣੇ ਆਪ ਇਹ secrets ਪਛਾਣਦੀ ਹੈ ਅਤੇ ਵਰਤਦੀ ਹੈ।

### ਵਿਕਲਪਕ: ਸਿੱਧੇ ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ

<details>
<summary>ਪਲੇਟਫਾਰਮ-ਵਿਸ਼ੇਸ਼ ਕਮਾਂਡਾਂ ਦੇਖਣ ਲਈ ਕਲਿੱਕ ਕਰੋ</summary>

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

## ਐਪਲੀਕੇਸ਼ਨ ਚਲਾਉਣਾ

### Maven ਦੀ ਵਰਤੋਂ

```bash
mvn spring-boot:run
```

### VS Code ਦੀ ਵਰਤੋਂ

1. ਪ੍ਰੋਜੈਕਟ ਨੂੰ VS Code ਵਿੱਚ ਖੋਲ੍ਹੋ
2. `F5` ਦਬਾਓ ਜਾਂ "Run and Debug" ਪੈਨਲ ਦੀ ਵਰਤੋਂ ਕਰੋ
3. "Spring Boot-BasicChatApplication" ਕੰਫਿਗਰੇਸ਼ਨ ਚੁਣੋ

> **Note**: VS Code ਕੰਫਿਗਰੇਸ਼ਨ ਆਪਣੇ ਆਪ ਤੁਹਾਡੀ .env ਫਾਈਲ ਲੋਡ ਕਰਦੀ ਹੈ

### ਉਮੀਦ ਕੀਤੀ ਆਉਟਪੁੱਟ

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

## ਕੰਫਿਗਰੇਸ਼ਨ ਰਿਫਰੈਂਸ

### ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ

| ਵੈਰੀਏਬਲ | ਵੇਰਵਾ | ਲਾਜ਼ਮੀ | ਉਦਾਹਰਨ |
|----------|-------------|----------|---------|
| `AZURE_AI_KEY` | Azure OpenAI API ਕੁੰਜੀ | ਹਾਂ | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI ਐਂਡਪੌਇੰਟ URL | ਹਾਂ | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | ਮਾਡਲ ਡਿਪਲੌਇਮੈਂਟ ਨਾਮ | ਨਹੀਂ | `gpt-4o-mini` (ਡਿਫਾਲਟ) |

### ਸਪ੍ਰਿੰਗ ਕੰਫਿਗਰੇਸ਼ਨ

`application.yml` ਫਾਈਲ ਵਿੱਚ ਕੰਫਿਗਰ ਕੀਤਾ ਜਾਂਦਾ ਹੈ:
- **API ਕੁੰਜੀ**: `${AZURE_AI_KEY}` - ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ ਤੋਂ  
- **ਐਂਡਪੌਇੰਟ**: `${AZURE_AI_ENDPOINT}` - ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ ਤੋਂ  
- **ਮਾਡਲ**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ ਨਾਲ ਫਾਲਬੈਕ  
- **ਤਾਪਮਾਨ**: `0.7` - ਰਚਨਾਤਮਕਤਾ ਨੂੰ ਨਿਯੰਤਰਿਤ ਕਰਦਾ ਹੈ (0.0 = ਨਿਰਧਾਰਿਤ, 1.0 = ਰਚਨਾਤਮਕ)  
- **ਵੱਧ ਤੋਂ ਵੱਧ ਟੋਕਨ**: `500` - ਵੱਧ ਤੋਂ ਵੱਧ ਜਵਾਬ ਦੀ ਲੰਬਾਈ  

## ਟ੍ਰਬਲਸ਼ੂਟਿੰਗ

### ਆਮ ਸਮੱਸਿਆਵਾਂ

<details>
<summary><strong>ਗਲਤੀ: "API ਕੁੰਜੀ ਵੈਧ ਨਹੀਂ ਹੈ"</strong></summary>

- ਜਾਂਚ ਕਰੋ ਕਿ ਤੁਹਾਡਾ `AZURE_AI_KEY` ਤੁਹਾਡੇ `.env` ਫਾਈਲ ਵਿੱਚ ਸਹੀ ਤਰੀਕੇ ਨਾਲ ਸੈਟ ਕੀਤਾ ਗਿਆ ਹੈ  
- ਯਕੀਨੀ ਬਣਾਓ ਕਿ API ਕੁੰਜੀ ਨੂੰ Azure AI Foundry ਪੋਰਟਲ ਤੋਂ ਬਿਲਕੁਲ ਕਾਪੀ ਕੀਤਾ ਗਿਆ ਹੈ  
- ਕੁੰਜੀ ਦੇ ਆਲੇ-ਦੁਆਲੇ ਕੋਈ ਵਾਧੂ ਖਾਲੀ ਜਗ੍ਹਾ ਜਾਂ ਕੋਟਸ ਨਹੀਂ ਹਨ  
</details>

<details>
<summary><strong>ਗਲਤੀ: "ਐਂਡਪੌਇੰਟ ਵੈਧ ਨਹੀਂ ਹੈ"</strong></summary>

- ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਤੁਹਾਡਾ `AZURE_AI_ENDPOINT` ਪੂਰਾ URL ਸ਼ਾਮਲ ਕਰਦਾ ਹੈ (ਜਿਵੇਂ, `https://your-hub-name.openai.azure.com/`)  
- ਟ੍ਰੇਲਿੰਗ ਸਲੈਸ਼ ਦੀ ਸਥਿਰਤਾ ਦੀ ਜਾਂਚ ਕਰੋ  
- ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਐਂਡਪੌਇੰਟ ਤੁਹਾਡੇ Azure ਡਿਪਲੌਇਮੈਂਟ ਰੀਜਨ ਨਾਲ ਮੇਲ ਖਾਂਦਾ ਹੈ  
</details>

<details>
<summary><strong>ਗਲਤੀ: "ਡਿਪਲੌਇਮੈਂਟ ਨਹੀਂ ਮਿਲੀ"</strong></summary>

- ਜਾਂਚ ਕਰੋ ਕਿ ਤੁਹਾਡਾ ਮਾਡਲ ਡਿਪਲੌਇਮੈਂਟ ਨਾਮ ਬਿਲਕੁਲ ਉਸ ਨਾਲ ਮੇਲ ਖਾਂਦਾ ਹੈ ਜੋ Azure ਵਿੱਚ ਡਿਪਲੌਇਡ ਕੀਤਾ ਗਿਆ ਹੈ  
- ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਮਾਡਲ ਸਫਲਤਾਪੂਰਵਕ ਡਿਪਲੌਇਡ ਅਤੇ ਸਰਗਰਮ ਹੈ  
- ਡਿਫਾਲਟ ਡਿਪਲੌਇਮੈਂਟ ਨਾਮ ਦੀ ਵਰਤੋਂ ਕਰਨ ਦੀ ਕੋਸ਼ਿਸ਼ ਕਰੋ: `gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code: ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ ਲੋਡ ਨਹੀਂ ਹੋ ਰਹੇ</strong></summary>

- ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਤੁਹਾਡੀ `.env` ਫਾਈਲ ਪ੍ਰੋਜੈਕਟ ਰੂਟ ਡਾਇਰੈਕਟਰੀ ਵਿੱਚ ਹੈ (ਉਸੇ ਪੱਧਰ 'ਤੇ ਜਿੱਥੇ `pom.xml` ਹੈ)  
- VS Code ਦੇ ਇੰਟੀਗ੍ਰੇਟਡ ਟਰਮੀਨਲ ਵਿੱਚ `mvn spring-boot:run` ਚਲਾਉਣ ਦੀ ਕੋਸ਼ਿਸ਼ ਕਰੋ  
- ਜਾਂਚ ਕਰੋ ਕਿ VS Code Java ਐਕਸਟੈਂਸ਼ਨ ਸਹੀ ਤਰੀਕੇ ਨਾਲ ਇੰਸਟਾਲ ਕੀਤੀ ਗਈ ਹੈ  
- ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਲਾਂਚ ਕੰਫਿਗਰੇਸ਼ਨ ਵਿੱਚ `"envFile": "${workspaceFolder}/.env"` ਹੈ  
</details>

### ਡਿਬੱਗ ਮੋਡ

ਵਿਸਤ੍ਰਿਤ ਲੌਗਿੰਗ ਨੂੰ ਯਕੀਨੀ ਬਣਾਉਣ ਲਈ, `application.yml` ਵਿੱਚ ਇਹ ਲਾਈਨਾਂ ਅਨਕਮੈਂਟ ਕਰੋ:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## ਅਗਲੇ ਕਦਮ

**ਸੈਟਅੱਪ ਪੂਰਾ!** ਆਪਣੀ ਸਿੱਖਣ ਦੀ ਯਾਤਰਾ ਜਾਰੀ ਰੱਖੋ:

[ਅਧਿਆਇ 3: ਕੋਰ ਜਨਰੇਟਿਵ AI ਤਕਨੀਕਾਂ](../../../03-CoreGenerativeAITechniques/README.md)

## ਸੰਸਾਧਨ

- [Spring AI Azure OpenAI ਦਸਤਾਵੇਜ਼](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI ਸੇਵਾ ਦਸਤਾਵੇਜ਼](https://learn.microsoft.com/azure/ai-services/openai/)
- [Azure AI Foundry ਪੋਰਟਲ](https://ai.azure.com/)
- [Azure AI Foundry ਦਸਤਾਵੇਜ਼](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**ਅਸਵੀਕਾਰਨਾ**:  
ਇਹ ਦਸਤਾਵੇਜ਼ AI ਅਨੁਵਾਦ ਸੇਵਾ [Co-op Translator](https://github.com/Azure/co-op-translator) ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਅਨੁਵਾਦ ਕੀਤਾ ਗਿਆ ਹੈ। ਜਦੋਂ ਕਿ ਅਸੀਂ ਸਹੀਤਾ ਲਈ ਯਤਨਸ਼ੀਲ ਹਾਂ, ਕਿਰਪਾ ਕਰਕੇ ਧਿਆਨ ਦਿਓ ਕਿ ਸਵੈਚਾਲਿਤ ਅਨੁਵਾਦਾਂ ਵਿੱਚ ਗਲਤੀਆਂ ਜਾਂ ਅਸੁਚੀਤਤਾਵਾਂ ਹੋ ਸਕਦੀਆਂ ਹਨ। ਮੂਲ ਦਸਤਾਵੇਜ਼ ਨੂੰ ਇਸਦੀ ਮੂਲ ਭਾਸ਼ਾ ਵਿੱਚ ਅਧਿਕਾਰਤ ਸਰੋਤ ਮੰਨਿਆ ਜਾਣਾ ਚਾਹੀਦਾ ਹੈ। ਮਹੱਤਵਪੂਰਨ ਜਾਣਕਾਰੀ ਲਈ, ਪੇਸ਼ੇਵਰ ਮਨੁੱਖੀ ਅਨੁਵਾਦ ਦੀ ਸਿਫਾਰਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ। ਇਸ ਅਨੁਵਾਦ ਦੀ ਵਰਤੋਂ ਤੋਂ ਪੈਦਾ ਹੋਣ ਵਾਲੇ ਕਿਸੇ ਵੀ ਗਲਤਫਹਿਮੀ ਜਾਂ ਗਲਤ ਵਿਆਖਿਆ ਲਈ ਅਸੀਂ ਜ਼ਿੰਮੇਵਾਰ ਨਹੀਂ ਹਾਂ।