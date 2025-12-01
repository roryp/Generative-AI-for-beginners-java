<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "efd82efe50711d7e257eb943151d682c",
  "translation_date": "2025-12-01T09:38:47+00:00",
  "source_file": "02-SetupDevEnvironment/examples/basic-chat-azure/README.md",
  "language_code": "kn"
}
-->
# Azure OpenAI ಜೊತೆ ಮೂಲಭೂತ ಚಾಟ್ - ಸಂಪೂರ್ಣ ಉದಾಹರಣೆ

ಈ ಉದಾಹರಣೆ, Azure OpenAI ಗೆ ಸಂಪರ್ಕಿಸುವ ಮತ್ತು ನಿಮ್ಮ ಸೆಟಪ್ ಅನ್ನು ಪರೀಕ್ಷಿಸುವ ಸರಳ Spring Boot ಅಪ್ಲಿಕೇಶನ್ ಅನ್ನು ಹೇಗೆ ರಚಿಸಬೇಕೆಂದು ತೋರಿಸುತ್ತದೆ.

## ವಿಷಯಗಳ ಪಟ್ಟಿಯು

- [ಪೂರ್ವಶರತ್ತುಗಳು](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ತ್ವರಿತ ಪ್ರಾರಂಭ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ಕಾನ್ಫಿಗರೇಶನ್ ಆಯ್ಕೆಗಳು](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ಆಯ್ಕೆ 1: ಪರಿಸರ ಚರಗಳು (.env ಫೈಲ್) - ಶಿಫಾರಸು](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ಆಯ್ಕೆ 2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ಅಪ್ಲಿಕೇಶನ್ ಅನ್ನು ರನ್ ಮಾಡುವುದು](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Maven ಬಳಸಿ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [VS Code ಬಳಸಿ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ನಿರೀಕ್ಷಿತ ಔಟ್‌ಪುಟ್](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ಕಾನ್ಫಿಗರೇಶನ್ ರೆಫರೆನ್ಸ್](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ಪರಿಸರ ಚರಗಳು](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring ಕಾನ್ಫಿಗರೇಶನ್](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ತೊಂದರೆ ಪರಿಹಾರ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ಸಾಮಾನ್ಯ ಸಮಸ್ಯೆಗಳು](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ಡಿಬಗ್ ಮೋಡ್](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ಮುಂದಿನ ಹಂತಗಳು](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ಸಂಪತ್ತುಗಳು](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## ಪೂರ್ವಶರತ್ತುಗಳು

ಈ ಉದಾಹರಣೆಯನ್ನು ರನ್ ಮಾಡುವ ಮೊದಲು, ನೀವು ಈ ಕೆಳಗಿನವುಗಳನ್ನು ಪೂರ್ಣಗೊಳಿಸಿರಬೇಕು:

- [Azure OpenAI ಸೆಟಪ್ ಗೈಡ್](../../getting-started-azure-openai.md) ಅನ್ನು ಪೂರ್ಣಗೊಳಿಸಲಾಗಿದೆ  
- Azure AI Foundry ಪೋರ್ಟಲ್ ಮೂಲಕ Azure OpenAI ಸಂಪತ್ತು ಡಿಪ್ಲಾಯ್ ಮಾಡಲಾಗಿದೆ  
- gpt-4o-mini ಮಾದರಿ (ಅಥವಾ ಪರ್ಯಾಯ) ಡಿಪ್ಲಾಯ್ ಮಾಡಲಾಗಿದೆ  
- Azure ನಿಂದ API ಕೀ ಮತ್ತು ಎಂಡ್‌ಪಾಯಿಂಟ್ URL ಲಭ್ಯವಿದೆ  

## ತ್ವರಿತ ಪ್ರಾರಂಭ

```bash
# 1. ಪ್ರಾಜೆಕ್ಟ್‌ಗೆ ನಾವಿಗೇಟ್ ಮಾಡಿ
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. ಕ್ರೆಡೆನ್ಷಿಯಲ್ಸ್ ಅನ್ನು ಕಾನ್ಫಿಗರ್ ಮಾಡಿ
cp .env.example .env
# ನಿಮ್ಮ Azure OpenAI ಕ್ರೆಡೆನ್ಷಿಯಲ್ಸ್‌ನೊಂದಿಗೆ .env ಅನ್ನು ಸಂಪಾದಿಸಿ

# 3. ಅಪ್ಲಿಕೇಶನ್ ಅನ್ನು ರನ್ ಮಾಡಿ
mvn spring-boot:run
```

## ಕಾನ್ಫಿಗರೇಶನ್ ಆಯ್ಕೆಗಳು

### ಆಯ್ಕೆ 1: ಪರಿಸರ ಚರಗಳು (.env ಫೈಲ್) - ಶಿಫಾರಸು

**ಹಂತ 1: ನಿಮ್ಮ ಕಾನ್ಫಿಗರೇಶನ್ ಫೈಲ್ ರಚಿಸಿ**
```bash
cp .env.example .env
```

**ಹಂತ 2: ನಿಮ್ಮ Azure OpenAI ಕ್ರೆಡೆನ್ಷಿಯಲ್ಸ್ ಸೇರಿಸಿ**
```bash
# ನಿಮ್ಮ Azure OpenAI API ಕೀ (Azure AI Foundry ಪೋರ್ಟಲ್‌ನಿಂದ)
AZURE_AI_KEY=your-actual-api-key-here

# ನಿಮ್ಮ Azure OpenAI ಎಂಡ್ಪಾಯಿಂಟ್ URL (ಉದಾ., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **ಭದ್ರತಾ ಟಿಪ್ಪಣಿ**: 
> - ನಿಮ್ಮ `.env` ಫೈಲ್ ಅನ್ನು ಎಂದಿಗೂ ವರ್ಜನ್ ಕಂಟ್ರೋಲ್ ಗೆ ಕಮಿಟ್ ಮಾಡಬೇಡಿ
> - `.env` ಫೈಲ್ ಈಗಾಗಲೇ `.gitignore` ನಲ್ಲಿ ಸೇರಿಸಲಾಗಿದೆ
> - ನಿಮ್ಮ API ಕೀಗಳನ್ನು ಸುರಕ್ಷಿತವಾಗಿ ಇಟ್ಟುಕೊಳ್ಳಿ ಮತ್ತು ಅವುಗಳನ್ನು ನಿಯಮಿತವಾಗಿ ರೋಟೇಟ್ ಮಾಡಿ

### ಆಯ್ಕೆ 2: GitHub Codespace Secrets

GitHub Codespaces ಗೆ, ಈ ಸೀಕ್ರೆಟ್ಸ್ ಅನ್ನು ನಿಮ್ಮ ರೆಪೊಸಿಟರಿಯಲ್ಲಿ ಸೆಟ್ ಮಾಡಿ:
- `AZURE_AI_KEY` - ನಿಮ್ಮ Azure OpenAI API ಕೀ
- `AZURE_AI_ENDPOINT` - ನಿಮ್ಮ Azure OpenAI ಎಂಡ್‌ಪಾಯಿಂಟ್ URL

ಅಪ್ಲಿಕೇಶನ್ ಸ್ವಯಂಚಾಲಿತವಾಗಿ ಈ ಸೀಕ್ರೆಟ್ಸ್ ಅನ್ನು ಪತ್ತೆಹಚ್ಚಿ ಬಳಸುತ್ತದೆ.

### ಪರ್ಯಾಯ: ನೇರ ಪರಿಸರ ಚರಗಳು

<details>
<summary>ಪ್ಲಾಟ್‌ಫಾರ್ಮ್-ನಿರ್ದಿಷ್ಟ ಕಮಾಂಡ್‌ಗಳನ್ನು ನೋಡಲು ಕ್ಲಿಕ್ ಮಾಡಿ</summary>

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

## ಅಪ್ಲಿಕೇಶನ್ ಅನ್ನು ರನ್ ಮಾಡುವುದು

### Maven ಬಳಸಿ

```bash
mvn spring-boot:run
```

### VS Code ಬಳಸಿ

1. ಪ್ರಾಜೆಕ್ಟ್ ಅನ್ನು VS Code ನಲ್ಲಿ ತೆರೆಯಿರಿ
2. `F5` ಒತ್ತಿ ಅಥವಾ "Run and Debug" ಪ್ಯಾನೆಲ್ ಬಳಸಿ
3. "Spring Boot-BasicChatApplication" ಕಾನ್ಫಿಗರೇಶನ್ ಆಯ್ಕೆಮಾಡಿ

> **ಟಿಪ್ಪಣಿ**: VS Code ಕಾನ್ಫಿಗರೇಶನ್ ಸ್ವಯಂಚಾಲಿತವಾಗಿ ನಿಮ್ಮ .env ಫೈಲ್ ಅನ್ನು ಲೋಡ್ ಮಾಡುತ್ತದೆ

### ನಿರೀಕ್ಷಿತ ಔಟ್‌ಪುಟ್

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

## ಕಾನ್ಫಿಗರೇಶನ್ ರೆಫರೆನ್ಸ್

### ಪರಿಸರ ಚರಗಳು

| ಚರ | ವಿವರಣೆ | ಅಗತ್ಯವಿದೆ | ಉದಾಹರಣೆ |
|----------|-------------|----------|---------|
| `AZURE_AI_KEY` | Azure OpenAI API ಕೀ | ಹೌದು | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI ಎಂಡ್‌ಪಾಯಿಂಟ್ URL | ಹೌದು | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | ಮಾದರಿ ಡಿಪ್ಲಾಯ್‌ಮೆಂಟ್ ಹೆಸರು | ಇಲ್ಲ | `gpt-4o-mini` (ಡೀಫಾಲ್ಟ್) |

### Spring ಕಾನ್ಫಿಗರೇಶನ್

`application.yml` ಫೈಲ್ ಈ ಕೆಳಗಿನವುಗಳನ್ನು ಕಾನ್ಫಿಗರ್ ಮಾಡುತ್ತದೆ:
- **API ಕೀ**: `${AZURE_AI_KEY}` - ಪರಿಸರ ಚರದಿಂದ
- **ಎಂಡ್‌ಪಾಯಿಂಟ್**: `${AZURE_AI_ENDPOINT}` - ಪರಿಸರ ಚರದಿಂದ  
- **ಮಾದರಿ**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - ಪರಿಸರ ಚರದಿಂದ ಫಾಲ್ಬ್ಯಾಕ್ ಸಹಿತ
- **Temperature**: `0.7` - ಸೃಜನಶೀಲತೆಯನ್ನು ನಿಯಂತ್ರಿಸುತ್ತದೆ (0.0 = ನಿರ್ಧಿಷ್ಟ, 1.0 = ಸೃಜನಶೀಲ)
- **Max Tokens**: `500` - ಗರಿಷ್ಠ ಪ್ರತಿಕ್ರಿಯೆಯ ಉದ್ದ

## ತೊಂದರೆ ಪರಿಹಾರ

### ಸಾಮಾನ್ಯ ಸಮಸ್ಯೆಗಳು

<details>
<summary><strong>ದೋಷ: "API ಕೀ ಮಾನ್ಯವಿಲ್ಲ"</strong></summary>

- ನಿಮ್ಮ `AZURE_AI_KEY` ಅನ್ನು `.env` ಫೈಲ್‌ನಲ್ಲಿ ಸರಿಯಾಗಿ ಸೆಟ್ ಮಾಡಲಾಗಿದೆ ಎಂದು ಪರಿಶೀಲಿಸಿ
- API ಕೀ ಅನ್ನು Azure AI Foundry ಪೋರ್ಟಲ್‌ನಿಂದ ನಿಖರವಾಗಿ ನಕಲಿಸಲಾಗಿದೆ ಎಂದು ಖಚಿತಪಡಿಸಿಕೊಳ್ಳಿ
- ಕೀ ಸುತ್ತಲೂ ಯಾವುದೇ ಹೆಚ್ಚುವರಿ ಖಾಲಿ ಸ್ಥಳಗಳು ಅಥವಾ ಉಲ್ಲೇಖಗಳು ಇಲ್ಲ ಎಂದು ಖಚಿತಪಡಿಸಿಕೊಳ್ಳಿ
</details>

<details>
<summary><strong>ದೋಷ: "ಎಂಡ್‌ಪಾಯಿಂಟ್ ಮಾನ್ಯವಿಲ್ಲ"</strong></summary>

- ನಿಮ್ಮ `AZURE_AI_ENDPOINT` ಪೂರ್ಣ URL ಅನ್ನು ಒಳಗೊಂಡಿದೆ ಎಂದು ಖಚಿತಪಡಿಸಿಕೊಳ್ಳಿ (ಉದಾ., `https://your-hub-name.openai.azure.com/`)
- ಟ್ರೈಲಿಂಗ್ ಸ್ಲ್ಯಾಶ್ ಸಮ್ಮತತೆಯನ್ನು ಪರಿಶೀಲಿಸಿ
- ಎಂಡ್‌ಪಾಯಿಂಟ್ ನಿಮ್ಮ Azure ಡಿಪ್ಲಾಯ್‌ಮೆಂಟ್ ಪ್ರದೇಶಕ್ಕೆ ಹೊಂದಿಕೆಯಾಗುತ್ತದೆ ಎಂದು ಖಚಿತಪಡಿಸಿಕೊಳ್ಳಿ
</details>

<details>
<summary><strong>ದೋಷ: "ಡಿಪ್ಲಾಯ್‌ಮೆಂಟ್ ಕಂಡುಬಂದಿಲ್ಲ"</strong></summary>

- ನಿಮ್ಮ ಮಾದರಿ ಡಿಪ್ಲಾಯ್‌ಮೆಂಟ್ ಹೆಸರು Azure ನಲ್ಲಿ ಡಿಪ್ಲಾಯ್ ಮಾಡಿರುವುದಕ್ಕೆ ನಿಖರವಾಗಿ ಹೊಂದಿಕೆಯಾಗುತ್ತದೆ ಎಂದು ಪರಿಶೀಲಿಸಿ
- ಮಾದರಿ ಯಶಸ್ವಿಯಾಗಿ ಡಿಪ್ಲಾಯ್ ಆಗಿದೆ ಮತ್ತು ಸಕ್ರಿಯವಾಗಿದೆ ಎಂದು ಪರಿಶೀಲಿಸಿ
- ಡೀಫಾಲ್ಟ್ ಡಿಪ್ಲಾಯ್‌ಮೆಂಟ್ ಹೆಸರು ಬಳಸಲು ಪ್ರಯತ್ನಿಸಿ: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: ಪರಿಸರ ಚರಗಳು ಲೋಡ್ ಆಗುತ್ತಿಲ್ಲ</strong></summary>

- ನಿಮ್ಮ `.env` ಫೈಲ್ ಪ್ರಾಜೆಕ್ಟ್ ರೂಟ್ ಡೈರೆಕ್ಟರಿಯಲ್ಲಿ (ಅದೇ ಮಟ್ಟದಲ್ಲಿ `pom.xml`) ಇದೆ ಎಂದು ಖಚಿತಪಡಿಸಿಕೊಳ್ಳಿ
- VS Code ನ ಇಂಟಿಗ್ರೇಟೆಡ್ ಟರ್ಮಿನಲ್‌ನಲ್ಲಿ `mvn spring-boot:run` ರನ್ ಮಾಡಿ
- VS Code Java ಎಕ್ಸ್ಟೆನ್ಷನ್ ಸರಿಯಾಗಿ ಇನ್‌ಸ್ಟಾಲ್ ಆಗಿದೆ ಎಂದು ಪರಿಶೀಲಿಸಿ
- ಲಾಂಚ್ ಕಾನ್ಫಿಗರೇಶನ್ ನಲ್ಲಿ `"envFile": "${workspaceFolder}/.env"` ಇದೆ ಎಂದು ಖಚಿತಪಡಿಸಿಕೊಳ್ಳಿ
</details>

### ಡಿಬಗ್ ಮೋಡ್

ವಿವರವಾದ ಲಾಗಿಂಗ್ ಅನ್ನು ಸಕ್ರಿಯಗೊಳಿಸಲು, `application.yml` ನಲ್ಲಿ ಈ ಸಾಲುಗಳನ್ನು ಅನ್‌ಕಾಮೆಂಟ್ ಮಾಡಿ:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## ಮುಂದಿನ ಹಂತಗಳು

**ಸೆಟಪ್ ಪೂರ್ಣಗೊಂಡಿದೆ!** ನಿಮ್ಮ ಕಲಿಕೆಯ ಪ್ರಯಾಣವನ್ನು ಮುಂದುವರಿಸಿ:

[ಅಧ್ಯಾಯ 3: ಕೋರ್ ಜನರೇಟಿವ್ AI ತಂತ್ರಗಳು](../../../03-CoreGenerativeAITechniques/README.md)

## ಸಂಪತ್ತುಗಳು

- [Spring AI Azure OpenAI ಡಾಕ್ಯುಮೆಂಟೇಶನ್](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI ಸೇವಾ ಡಾಕ್ಯುಮೆಂಟೇಶನ್](https://learn.microsoft.com/azure/ai-services/openai/)
- [Azure AI Foundry ಪೋರ್ಟಲ್](https://ai.azure.com/)
- [Azure AI Foundry ಡಾಕ್ಯುಮೆಂಟೇಶನ್](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ಅಸಮಾಕ್ಷ್ಯತೆ**:  
ಈ ದಸ್ತಾವೇಜು AI ಅನುವಾದ ಸೇವೆ [Co-op Translator](https://github.com/Azure/co-op-translator) ಬಳಸಿ ಅನುವಾದಿಸಲಾಗಿದೆ. ನಾವು ನಿಖರತೆಯನ್ನು ಸಾಧಿಸಲು ಪ್ರಯತ್ನಿಸುತ್ತಿದ್ದರೂ, ದಯವಿಟ್ಟು ಗಮನಿಸಿ, ಸ್ವಯಂಚಾಲಿತ ಅನುವಾದಗಳಲ್ಲಿ ದೋಷಗಳು ಅಥವಾ ಅಸಮಾಕ್ಷ್ಯತೆಗಳು ಇರಬಹುದು. ಮೂಲ ಭಾಷೆಯಲ್ಲಿರುವ ಮೂಲ ದಸ್ತಾವೇಜು ಪ್ರಾಮಾಣಿಕ ಮೂಲವೆಂದು ಪರಿಗಣಿಸಬೇಕು. ಮಹತ್ವದ ಮಾಹಿತಿಗಾಗಿ, ವೃತ್ತಿಪರ ಮಾನವ ಅನುವಾದವನ್ನು ಶಿಫಾರಸು ಮಾಡಲಾಗುತ್ತದೆ. ಈ ಅನುವಾದವನ್ನು ಬಳಸುವ ಮೂಲಕ ಉಂಟಾಗುವ ಯಾವುದೇ ತಪ್ಪು ಅರ್ಥಗಳ ಅಥವಾ ತಪ್ಪು ವ್ಯಾಖ್ಯಾನಗಳ ಬಗ್ಗೆ ನಾವು ಹೊಣೆಗಾರರಲ್ಲ.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->