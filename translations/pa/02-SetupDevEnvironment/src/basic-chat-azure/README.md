<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2289320a74aeca1eb844cd7d3a7a9e12",
  "translation_date": "2025-07-21T18:07:36+00:00",
  "source_file": "02-SetupDevEnvironment/src/basic-chat-azure/README.md",
  "language_code": "pa"
}
-->
# ਐਜ਼ਰ ਓਪਨਏਆਈ ਨਾਲ ਬੇਸਿਕ ਚੈਟ - ਐਂਡ-ਟੂ-ਐਂਡ ਉਦਾਹਰਨ

ਇਹ ਉਦਾਹਰਨ ਦਿਖਾਉਂਦੀ ਹੈ ਕਿ ਕਿਵੇਂ ਇੱਕ ਸਧਾਰਨ ਸਪ੍ਰਿੰਗ ਬੂਟ ਐਪਲੀਕੇਸ਼ਨ ਬਣਾਈ ਜਾ ਸਕਦੀ ਹੈ ਜੋ ਐਜ਼ਰ ਓਪਨਏਆਈ ਨਾਲ ਜੁੜਦੀ ਹੈ ਅਤੇ ਤੁਹਾਡੇ ਸੈਟਅੱਪ ਦੀ ਜਾਂਚ ਕਰਦੀ ਹੈ।

## ਸੂਚੀ

- [ਪੂਰਵ ਸ਼ਰਤਾਂ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [ਤੁਰੰਤ ਸ਼ੁਰੂਆਤ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [ਕੰਫਿਗਰੇਸ਼ਨ ਵਿਕਲਪ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [ਵਿਕਲਪ 1: ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ (.env ਫਾਈਲ) - ਸਿਫਾਰਸ਼ੀ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [ਵਿਕਲਪ 2: GitHub ਕੋਡਸਪੇਸ ਸੀਕ੍ਰੇਟਸ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [ਐਪਲੀਕੇਸ਼ਨ ਚਲਾਉਣਾ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Maven ਦੀ ਵਰਤੋਂ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [VS ਕੋਡ ਦੀ ਵਰਤੋਂ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [ਉਮੀਦਵਾਰ ਨਤੀਜਾ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [ਕੰਫਿਗਰੇਸ਼ਨ ਰੈਫਰੈਂਸ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [ਸਪ੍ਰਿੰਗ ਕੰਫਿਗਰੇਸ਼ਨ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [ਟ੍ਰਬਲਸ਼ੂਟਿੰਗ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [ਆਮ ਸਮੱਸਿਆਵਾਂ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [ਡਿਬੱਗ ਮੋਡ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [ਅਗਲੇ ਕਦਮ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [ਸਰੋਤ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)

## ਪੂਰਵ ਸ਼ਰਤਾਂ

ਇਸ ਉਦਾਹਰਨ ਨੂੰ ਚਲਾਉਣ ਤੋਂ ਪਹਿਲਾਂ, ਇਹ ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਤੁਹਾਡੇ ਕੋਲ ਇਹ ਹਨ:

- [ਐਜ਼ਰ ਓਪਨਏਆਈ ਸੈਟਅੱਪ ਗਾਈਡ](../../getting-started-azure-openai.md) ਪੂਰੀ ਕੀਤੀ ਹੋਈ ਹੈ  
- ਐਜ਼ਰ ਓਪਨਏਆਈ ਸਰੋਤ ਤੈਨਾਤ ਕੀਤਾ ਹੋਇਆ (ਐਜ਼ਰ ਏਆਈ ਫਾਊਂਡਰੀ ਪੋਰਟਲ ਰਾਹੀਂ)  
- gpt-4o-mini ਮਾਡਲ (ਜਾਂ ਵਿਕਲਪਕ) ਤੈਨਾਤ ਕੀਤਾ ਹੋਇਆ  
- ਐਜ਼ਰ ਤੋਂ API ਕੁੰਜੀ ਅਤੇ ਐਂਡਪੌਇੰਟ URL  

## ਤੁਰੰਤ ਸ਼ੁਰੂਆਤ

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/src/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## ਕੰਫਿਗਰੇਸ਼ਨ ਵਿਕਲਪ

### ਵਿਕਲਪ 1: ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ (.env ਫਾਈਲ) - ਸਿਫਾਰਸ਼ੀ

**ਕਦਮ 1: ਆਪਣੀ ਕੰਫਿਗਰੇਸ਼ਨ ਫਾਈਲ ਬਣਾਓ**  
```bash
cp .env.example .env
```

**ਕਦਮ 2: ਆਪਣੀ ਐਜ਼ਰ ਓਪਨਏਆਈ ਪ੍ਰਮਾਣਿਕਤਾ ਸ਼ਾਮਲ ਕਰੋ**  
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

### ਵਿਕਲਪ 2: GitHub ਕੋਡਸਪੇਸ ਸੀਕ੍ਰੇਟਸ

GitHub ਕੋਡਸਪੇਸ ਲਈ, ਆਪਣੇ ਰਿਪੋਜ਼ਟਰੀ ਵਿੱਚ ਇਹ ਸੀਕ੍ਰੇਟਸ ਸੈਟ ਕਰੋ:  
- `AZURE_AI_KEY` - ਤੁਹਾਡੀ ਐਜ਼ਰ ਓਪਨਏਆਈ API ਕੁੰਜੀ  
- `AZURE_AI_ENDPOINT` - ਤੁਹਾਡਾ ਐਜ਼ਰ ਓਪਨਏਆਈ ਐਂਡਪੌਇੰਟ URL  

ਐਪਲੀਕੇਸ਼ਨ ਆਪਣੇ ਆਪ ਇਹ ਸੀਕ੍ਰੇਟਸ ਪਛਾਣਦੀ ਹੈ ਅਤੇ ਵਰਤਦੀ ਹੈ।

### ਵਿਕਲਪਕ: ਸਿੱਧੇ ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ

<details>
<summary>ਪਲੇਟਫਾਰਮ-ਵਿਸ਼ੇਸ਼ ਕਮਾਂਡਾਂ ਦੇਖਣ ਲਈ ਕਲਿੱਕ ਕਰੋ</summary>

**Linux/macOS (bash/zsh):**  
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (ਕਮਾਂਡ ਪ੍ਰਾਂਪਟ):**  
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (ਪਾਵਰਸ਼ੈਲ):**  
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

### VS ਕੋਡ ਦੀ ਵਰਤੋਂ

1. ਪ੍ਰੋਜੈਕਟ ਨੂੰ VS ਕੋਡ ਵਿੱਚ ਖੋਲ੍ਹੋ  
2. `F5` ਦਬਾਓ ਜਾਂ "ਰਨ ਅਤੇ ਡਿਬੱਗ" ਪੈਨਲ ਦੀ ਵਰਤੋਂ ਕਰੋ  
3. "Spring Boot-BasicChatApplication" ਕੰਫਿਗਰੇਸ਼ਨ ਚੁਣੋ  

> **ਨੋਟ**: VS ਕੋਡ ਕੰਫਿਗਰੇਸ਼ਨ ਆਪਣੇ ਆਪ ਤੁਹਾਡੀ `.env` ਫਾਈਲ ਲੋਡ ਕਰਦਾ ਹੈ  

### ਉਮੀਦਵਾਰ ਨਤੀਜਾ

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

## ਕੰਫਿਗਰੇਸ਼ਨ ਰੈਫਰੈਂਸ

### ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ

| ਵੈਰੀਏਬਲ | ਵੇਰਵਾ | ਲਾਜ਼ਮੀ | ਉਦਾਹਰਨ |
|----------|-------------|----------|---------|
| `AZURE_AI_KEY` | ਐਜ਼ਰ ਓਪਨਏਆਈ API ਕੁੰਜੀ | ਹਾਂ | `abc123...` |
| `AZURE_AI_ENDPOINT` | ਐਜ਼ਰ ਓਪਨਏਆਈ ਐਂਡਪੌਇੰਟ URL | ਹਾਂ | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | ਮਾਡਲ ਤੈਨਾਤ ਕਰਨ ਦਾ ਨਾਮ | ਨਹੀਂ | `gpt-4o-mini` (ਡਿਫਾਲਟ) |

### ਸਪ੍ਰਿੰਗ ਕੰਫਿਗਰੇਸ਼ਨ

`application.yml` ਫਾਈਲ ਵਿੱਚ ਇਹ ਕੰਫਿਗਰ ਕੀਤਾ ਗਿਆ ਹੈ:  
- **API ਕੁੰਜੀ**: `${AZURE_AI_KEY}` - ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ ਤੋਂ  
- **ਐਂਡਪੌਇੰਟ**: `${AZURE_AI_ENDPOINT}` - ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ ਤੋਂ  
- **ਮਾਡਲ**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ ਨਾਲ ਫਾਲਬੈਕ  
- **ਟੈਂਪਰੇਚਰ**: `0.7` - ਰਚਨਾਤਮਕਤਾ ਨੂੰ ਨਿਯੰਤਰਿਤ ਕਰਦਾ ਹੈ (0.0 = ਨਿਰਧਾਰਿਤ, 1.0 = ਰਚਨਾਤਮਕ)  
- **ਅਧਿਕਤਮ ਟੋਕਨ**: `500` - ਜਵਾਬ ਦੀ ਵੱਧ ਤੋਂ ਵੱਧ ਲੰਬਾਈ  

## ਟ੍ਰਬਲਸ਼ੂਟਿੰਗ

### ਆਮ ਸਮੱਸਿਆਵਾਂ

<details>
<summary><strong>ਗਲਤੀ: "API ਕੁੰਜੀ ਵੈਧ ਨਹੀਂ ਹੈ"</strong></summary>

- ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਤੁਹਾਡੀ `AZURE_AI_KEY` ਤੁਹਾਡੀ `.env` ਫਾਈਲ ਵਿੱਚ ਸਹੀ ਸੈਟ ਕੀਤੀ ਗਈ ਹੈ  
- API ਕੁੰਜੀ ਨੂੰ ਐਜ਼ਰ ਏਆਈ ਫਾਊਂਡਰੀ ਪੋਰਟਲ ਤੋਂ ਬਿਲਕੁਲ ਸਹੀ ਕਾਪੀ ਕਰੋ  
- ਕੁੰਜੀ ਦੇ ਆਲੇ-ਦੁਆਲੇ ਕੋਈ ਵਾਧੂ ਖਾਲੀ ਜਗ੍ਹਾ ਜਾਂ ਕੋਟਸ ਨਾ ਹੋਣ  
</details>

<details>
<summary><strong>ਗਲਤੀ: "ਐਂਡਪੌਇੰਟ ਵੈਧ ਨਹੀਂ ਹੈ"</strong></summary>

- ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਤੁਹਾਡਾ `AZURE_AI_ENDPOINT` ਪੂਰਾ URL ਸ਼ਾਮਲ ਕਰਦਾ ਹੈ (ਜਿਵੇਂ, `https://your-hub-name.openai.azure.com/`)  
- ਟ੍ਰੇਲਿੰਗ ਸਲੈਸ਼ ਦੀ ਸਥਿਰਤਾ ਦੀ ਜਾਂਚ ਕਰੋ  
- ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਐਂਡਪੌਇੰਟ ਤੁਹਾਡੇ ਐਜ਼ਰ ਤੈਨਾਤੀ ਖੇਤਰ ਨਾਲ ਮੇਲ ਖਾਂਦਾ ਹੈ  
</details>

<details>
<summary><strong>ਗਲਤੀ: "ਤੈਨਾਤੀ ਨਹੀਂ ਮਿਲੀ"</strong></summary>

- ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਤੁਹਾਡਾ ਮਾਡਲ ਤੈਨਾਤੀ ਨਾਮ ਬਿਲਕੁਲ ਉਹੀ ਹੈ ਜੋ ਐਜ਼ਰ ਵਿੱਚ ਤੈਨਾਤ ਕੀਤਾ ਗਿਆ ਹੈ  
- ਜਾਂਚੋ ਕਿ ਮਾਡਲ ਸਫਲਤਾਪੂਰਵਕ ਤੈਨਾਤ ਅਤੇ ਸਰਗਰਮ ਹੈ  
- ਡਿਫਾਲਟ ਤੈਨਾਤੀ ਨਾਮ ਦੀ ਕੋਸ਼ਿਸ਼ ਕਰੋ: `gpt-4o-mini`  
</details>

<details>
<summary><strong>VS ਕੋਡ: ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ ਲੋਡ ਨਹੀਂ ਹੋ ਰਹੇ</strong></summary>

- ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਤੁਹਾਡੀ `.env` ਫਾਈਲ ਪ੍ਰੋਜੈਕਟ ਰੂਟ ਡਾਇਰੈਕਟਰੀ ਵਿੱਚ ਹੈ (ਉਸੇ ਪੱਧਰ 'ਤੇ ਜਿੱਥੇ `pom.xml` ਹੈ)  
- VS ਕੋਡ ਦੇ ਇੰਟੀਗ੍ਰੇਟਡ ਟਰਮੀਨਲ ਵਿੱਚ `mvn spring-boot:run` ਚਲਾਉਣ ਦੀ ਕੋਸ਼ਿਸ਼ ਕਰੋ  
- ਜਾਂਚੋ ਕਿ VS ਕੋਡ ਜਾਵਾ ਐਕਸਟੈਂਸ਼ਨ ਠੀਕ ਤਰ੍ਹਾਂ ਇੰਸਟਾਲ ਹੈ  
- ਲਾਂਚ ਕੰਫਿਗਰੇਸ਼ਨ ਵਿੱਚ `"envFile": "${workspaceFolder}/.env"` ਦੀ ਪੁਸ਼ਟੀ ਕਰੋ  
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

[ਅਧਿਆਇ 3: ਕੋਰ ਜਨਰੇਟਿਵ ਏਆਈ ਤਕਨੀਕਾਂ](../../../03-CoreGenerativeAITechniques/README.md)

## ਸਰੋਤ

- [ਸਪ੍ਰਿੰਗ ਏਆਈ ਐਜ਼ਰ ਓਪਨਏਆਈ ਡੌਕਯੂਮੈਂਟੇਸ਼ਨ](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [ਐਜ਼ਰ ਓਪਨਏਆਈ ਸਰਵਿਸ ਡੌਕਯੂਮੈਂਟੇਸ਼ਨ](https://learn.microsoft.com/azure/ai-services/openai/)  
- [ਐਜ਼ਰ ਏਆਈ ਫਾਊਂਡਰੀ ਪੋਰਟਲ](https://ai.azure.com/)  
- [ਐਜ਼ਰ ਏਆਈ ਫਾਊਂਡਰੀ ਡੌਕਯੂਮੈਂਟੇਸ਼ਨ](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**ਅਸਵੀਕਾਰਨਾ**:  
ਇਹ ਦਸਤਾਵੇਜ਼ AI ਅਨੁਵਾਦ ਸੇਵਾ [Co-op Translator](https://github.com/Azure/co-op-translator) ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਅਨੁਵਾਦ ਕੀਤਾ ਗਿਆ ਹੈ। ਜਦੋਂ ਕਿ ਅਸੀਂ ਸਹੀਤਾ ਲਈ ਯਤਨਸ਼ੀਲ ਹਾਂ, ਕਿਰਪਾ ਕਰਕੇ ਧਿਆਨ ਦਿਓ ਕਿ ਸਵੈਚਾਲਿਤ ਅਨੁਵਾਦਾਂ ਵਿੱਚ ਗਲਤੀਆਂ ਜਾਂ ਅਸੁਚਤਤਾਵਾਂ ਹੋ ਸਕਦੀਆਂ ਹਨ। ਮੂਲ ਦਸਤਾਵੇਜ਼ ਨੂੰ ਇਸਦੀ ਮੂਲ ਭਾਸ਼ਾ ਵਿੱਚ ਅਧਿਕਾਰਤ ਸਰੋਤ ਮੰਨਿਆ ਜਾਣਾ ਚਾਹੀਦਾ ਹੈ। ਮਹੱਤਵਪੂਰਨ ਜਾਣਕਾਰੀ ਲਈ, ਪੇਸ਼ੇਵਰ ਮਨੁੱਖੀ ਅਨੁਵਾਦ ਦੀ ਸਿਫਾਰਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ। ਇਸ ਅਨੁਵਾਦ ਦੀ ਵਰਤੋਂ ਤੋਂ ਪੈਦਾ ਹੋਣ ਵਾਲੇ ਕਿਸੇ ਵੀ ਗਲਤਫਹਿਮੀ ਜਾਂ ਗਲਤ ਵਿਆਖਿਆ ਲਈ ਅਸੀਂ ਜ਼ਿੰਮੇਵਾਰ ਨਹੀਂ ਹਾਂ।