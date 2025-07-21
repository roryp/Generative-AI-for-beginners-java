<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2289320a74aeca1eb844cd7d3a7a9e12",
  "translation_date": "2025-07-21T19:42:40+00:00",
  "source_file": "02-SetupDevEnvironment/src/basic-chat-azure/README.md",
  "language_code": "tl"
}
-->
# Pangunahing Chat gamit ang Azure OpenAI - Halimbawa mula Simula hanggang Wakas

Ang halimbawang ito ay nagpapakita kung paano gumawa ng simpleng Spring Boot application na kumokonekta sa Azure OpenAI at sinusubukan ang iyong setup.

## Talaan ng Nilalaman

- [Mga Kinakailangan](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Mabilisang Simula](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Mga Opsyon sa Konpigurasyon](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Opsyon 1: Mga Environment Variable (.env file) - Inirerekomenda](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Opsyon 2: Mga Lihim ng GitHub Codespace](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Pagpapatakbo ng Aplikasyon](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Gamit ang Maven](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Gamit ang VS Code](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Inaasahang Output](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Sanggunian sa Konpigurasyon](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Mga Environment Variable](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Konpigurasyon ng Spring](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Pag-aayos ng Problema](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Karaniwang Isyu](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Debug Mode](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Mga Susunod na Hakbang](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Mga Mapagkukunan](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)

## Mga Kinakailangan

Bago patakbuhin ang halimbawang ito, tiyaking mayroon ka ng mga sumusunod:

- Natapos ang [gabay sa setup ng Azure OpenAI](../../getting-started-azure-openai.md)  
- Na-deploy ang Azure OpenAI resource (sa pamamagitan ng Azure AI Foundry portal)  
- Na-deploy ang gpt-4o-mini model (o alternatibo)  
- API key at endpoint URL mula sa Azure  

## Mabilisang Simula

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/src/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Mga Opsyon sa Konpigurasyon

### Opsyon 1: Mga Environment Variable (.env file) - Inirerekomenda

**Hakbang 1: Gumawa ng iyong configuration file**  
```bash
cp .env.example .env
```

**Hakbang 2: Idagdag ang iyong Azure OpenAI credentials**  
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Tandaan sa Seguridad**: 
> - Huwag kailanman i-commit ang iyong `.env` file sa version control
> - Ang `.env` file ay naka-lista na sa `.gitignore`
> - Panatilihing ligtas ang iyong mga API key at i-rotate ang mga ito nang regular

### Opsyon 2: Mga Lihim ng GitHub Codespace

Para sa GitHub Codespaces, itakda ang mga sumusunod na lihim sa iyong repositoryo:
- `AZURE_AI_KEY` - Ang iyong Azure OpenAI API key
- `AZURE_AI_ENDPOINT` - Ang iyong Azure OpenAI endpoint URL

Awtomatikong nade-detect at nagagamit ng application ang mga lihim na ito.

### Alternatibo: Direktang Environment Variable

<details>
<summary>I-click para makita ang mga command na partikular sa platform</summary>

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

## Pagpapatakbo ng Aplikasyon

### Gamit ang Maven

```bash
mvn spring-boot:run
```

### Gamit ang VS Code

1. Buksan ang proyekto sa VS Code  
2. Pindutin ang `F5` o gamitin ang "Run and Debug" panel  
3. Piliin ang "Spring Boot-BasicChatApplication" configuration  

> **Tandaan**: Awtomatikong niloload ng VS Code configuration ang iyong `.env` file

### Inaasahang Output

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

## Sanggunian sa Konpigurasyon

### Mga Environment Variable

| Variable | Deskripsyon | Kinakailangan | Halimbawa |
|----------|-------------|--------------|-----------|
| `AZURE_AI_KEY` | Azure OpenAI API key | Oo | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI endpoint URL | Oo | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Pangalan ng model deployment | Hindi | `gpt-4o-mini` (default) |

### Konpigurasyon ng Spring

Ang `application.yml` file ay nagko-configure ng:  
- **API Key**: `${AZURE_AI_KEY}` - Mula sa environment variable  
- **Endpoint**: `${AZURE_AI_ENDPOINT}` - Mula sa environment variable  
- **Model**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Mula sa environment variable na may fallback  
- **Temperature**: `0.7` - Kinokontrol ang creativity (0.0 = deterministic, 1.0 = creative)  
- **Max Tokens**: `500` - Maximum na haba ng sagot  

## Pag-aayos ng Problema

### Karaniwang Isyu

<details>
<summary><strong>Error: "The API key is not valid"</strong></summary>

- Tiyaking ang iyong `AZURE_AI_KEY` ay tama ang pagkaka-set sa iyong `.env` file  
- Siguraduhing eksaktong kinopya ang API key mula sa Azure AI Foundry portal  
- Tiyaking walang sobrang espasyo o mga quote sa paligid ng key  
</details>

<details>
<summary><strong>Error: "The endpoint is not valid"</strong></summary>

- Siguraduhing ang iyong `AZURE_AI_ENDPOINT` ay kumpleto ang URL (hal., `https://your-hub-name.openai.azure.com/`)  
- Suriin ang consistency ng trailing slash  
- Tiyaking ang endpoint ay tumutugma sa iyong Azure deployment region  
</details>

<details>
<summary><strong>Error: "The deployment was not found"</strong></summary>

- Tiyaking ang pangalan ng iyong model deployment ay eksaktong tumutugma sa naka-deploy sa Azure  
- Suriin kung ang model ay matagumpay na na-deploy at aktibo  
- Subukang gamitin ang default na deployment name: `gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code: Environment variables not loading</strong></summary>

- Siguraduhing ang iyong `.env` file ay nasa root directory ng proyekto (parehong level ng `pom.xml`)  
- Subukang patakbuhin ang `mvn spring-boot:run` sa integrated terminal ng VS Code  
- Suriin kung maayos na naka-install ang VS Code Java extension  
- Tiyaking ang launch configuration ay may `"envFile": "${workspaceFolder}/.env"`  
</details>

### Debug Mode

Upang paganahin ang detalyadong logging, i-uncomment ang mga linyang ito sa `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Mga Susunod na Hakbang

**Tapos na ang Setup!** Ipagpatuloy ang iyong pag-aaral:

[Chapter 3: Core Generative AI Techniques](../../../03-CoreGenerativeAITechniques/README.md)

## Mga Mapagkukunan

- [Spring AI Azure OpenAI Documentation](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [Azure OpenAI Service Documentation](https://learn.microsoft.com/azure/ai-services/openai/)  
- [Azure AI Foundry Portal](https://ai.azure.com/)  
- [Azure AI Foundry Documentation](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**Paunawa**:  
Ang dokumentong ito ay isinalin gamit ang AI translation service na [Co-op Translator](https://github.com/Azure/co-op-translator). Bagama't sinisikap naming maging tumpak, pakitandaan na ang mga awtomatikong pagsasalin ay maaaring maglaman ng mga pagkakamali o hindi pagkakatugma. Ang orihinal na dokumento sa kanyang katutubong wika ang dapat ituring na opisyal na pinagmulan. Para sa mahalagang impormasyon, inirerekomenda ang propesyonal na pagsasalin ng tao. Hindi kami mananagot sa anumang hindi pagkakaunawaan o maling interpretasyon na maaaring magmula sa paggamit ng pagsasaling ito.