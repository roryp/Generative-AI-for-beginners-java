<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "efd82efe50711d7e257eb943151d682c",
  "translation_date": "2025-07-27T13:48:57+00:00",
  "source_file": "02-SetupDevEnvironment/examples/basic-chat-azure/README.md",
  "language_code": "my"
}
-->
# Azure OpenAI နှင့် Basic Chat - အဆုံးမှအဆုံးအထိ နမူနာ

ဒီနမူနာက Azure OpenAI နဲ့ ချိတ်ဆက်ပြီး သင့် setup ကို စမ်းသပ်နိုင်တဲ့ ရိုးရှင်းတဲ့ Spring Boot အက်ပ်လီကေးရှင်း တစ်ခုကို ဘယ်လို ဖန်တီးရမလဲ ပြသပေးမှာ ဖြစ်ပါတယ်။

## အကြောင်းအရာများ

- [လိုအပ်ချက်များ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [အမြန်စတင်ရန်](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ဖွဲ့စည်းမှု ရွေးချယ်စရာများ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ရွေးချယ်မှု ၁: Environment Variables (.env ဖိုင်) - အကြံပြုသည်](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ရွေးချယ်မှု ၂: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [အက်ပ်လီကေးရှင်းကို အလုပ်လုပ်စေခြင်း](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Maven အသုံးပြုခြင်း](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [VS Code အသုံးပြုခြင်း](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [မျှော်မှန်းထားသော အထွက်](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ဖွဲ့စည်းမှု ကိုးကားချက်](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Environment Variables](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring ဖွဲ့စည်းမှု](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ပြဿနာရှာဖွေခြင်း](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [အထွေထွေ ပြဿနာများ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Debug Mode](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [နောက်တစ်ဆင့်များ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [အရင်းအမြစ်များ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## လိုအပ်ချက်များ

ဒီနမူနာကို အလုပ်လုပ်စေမည်မတိုင်မီ သင့်တွင် အောက်ပါအရာများ ရှိရမည် -

- [Azure OpenAI setup လမ်းညွှန်](../../getting-started-azure-openai.md) ကို ပြီးစီးထားခြင်း  
- Azure AI Foundry ပေါ်မှ Azure OpenAI resource တစ်ခုကို တင်ထားပြီးဖြစ်ခြင်း  
- gpt-4o-mini မော်ဒယ် (သို့မဟုတ် အခြားရွေးချယ်စရာ) ကို တင်ထားပြီးဖြစ်ခြင်း  
- Azure မှ API key နှင့် endpoint URL  

## အမြန်စတင်ရန်

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## ဖွဲ့စည်းမှု ရွေးချယ်စရာများ

### ရွေးချယ်မှု ၁: Environment Variables (.env ဖိုင်) - အကြံပြုသည်

**အဆင့် ၁: သင့်ဖွဲ့စည်းမှုဖိုင်ကို ဖန်တီးပါ**
```bash
cp .env.example .env
```

**အဆင့် ၂: သင့် Azure OpenAI အချက်အလက်များ ထည့်သွင်းပါ**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **လုံခြုံရေး မှတ်ချက်**: 
> - သင့် `.env` ဖိုင်ကို version control တွင် မထည့်ပါနှင့်  
> - `.env` ဖိုင်ကို `.gitignore` တွင် ထည့်ပြီးဖြစ်သည်  
> - သင့် API key များကို လုံခြုံစွာ ထိန်းသိမ်းပြီး အချိန်ကာလတိုင်း ပြောင်းလဲပါ  

### ရွေးချယ်မှု ၂: GitHub Codespace Secrets

GitHub Codespaces အတွက်၊ သင့် repository တွင် အောက်ပါ secrets များကို သတ်မှတ်ပါ:
- `AZURE_AI_KEY` - သင့် Azure OpenAI API key
- `AZURE_AI_ENDPOINT` - သင့် Azure OpenAI endpoint URL

အက်ပ်လီကေးရှင်းသည် အလိုအလျောက် ဒီ secrets များကို ရှာဖွေပြီး အသုံးပြုပါမည်။

### အခြားရွေးချယ်စရာ: Direct Environment Variables

<details>
<summary>Platform-specific command များကို ကြည့်ရန် နှိပ်ပါ</summary>

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

## အက်ပ်လီကေးရှင်းကို အလုပ်လုပ်စေခြင်း

### Maven အသုံးပြုခြင်း

```bash
mvn spring-boot:run
```

### VS Code အသုံးပြုခြင်း

1. Project ကို VS Code တွင် ဖွင့်ပါ  
2. `F5` ကို နှိပ်ပါ သို့မဟုတ် "Run and Debug" panel ကို အသုံးပြုပါ  
3. "Spring Boot-BasicChatApplication" ဖွဲ့စည်းမှုကို ရွေးချယ်ပါ  

> **မှတ်ချက်**: VS Code ဖွဲ့စည်းမှုသည် သင့် `.env` ဖိုင်ကို အလိုအလျောက် load လုပ်ပါမည်  

### မျှော်မှန်းထားသော အထွက်

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

## ဖွဲ့စည်းမှု ကိုးကားချက်

### Environment Variables

| Variable | ဖော်ပြချက် | လိုအပ်ချက် | ဥပမာ |
|----------|-------------|----------|---------|
| `AZURE_AI_KEY` | Azure OpenAI API key | ဟုတ်သည် | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI endpoint URL | ဟုတ်သည် | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | မော်ဒယ် deployment အမည် | မလိုအပ်ပါ | `gpt-4o-mini` (default) |

### Spring ဖွဲ့စည်းမှု

`application.yml` ဖိုင်တွင် ဖွဲ့စည်းထားသည် -
- **API Key**: `${AZURE_AI_KEY}` - Environment variable မှ  
- **Endpoint**: `${AZURE_AI_ENDPOINT}` - Environment variable မှ  
- **Model**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Environment variable မှ fallback ဖြင့်  
- **Temperature**: `0.7` - ဖန်တီးမှုကို ထိန်းချုပ်သည် (0.0 = အတိအကျ, 1.0 = ဖန်တီးမှု)  
- **Max Tokens**: `500` - အများဆုံး တုံ့ပြန်မှု အရှည်  

## ပြဿနာရှာဖွေခြင်း

### အထွေထွေ ပြဿနာများ

<details>
<summary><strong>အမှား: "The API key is not valid"</strong></summary>

- သင့် `.env` ဖိုင်တွင် `AZURE_AI_KEY` ကို မှန်ကန်စွာ သတ်မှတ်ထားကြောင်း စစ်ဆေးပါ  
- Azure AI Foundry portal မှ API key ကို တိတိကျကျ ကူးယူထားကြောင်း သေချာပါ  
- Key ၏ အနားတွင် အပိုနေရာများ သို့မဟုတ် သင်္ကေတများ မရှိကြောင်း စစ်ဆေးပါ  
</details>

<details>
<summary><strong>အမှား: "The endpoint is not valid"</strong></summary>

- သင့် `AZURE_AI_ENDPOINT` တွင် အပြည့်အစုံ URL ပါဝင်ကြောင်း သေချာပါ (ဥပမာ - `https://your-hub-name.openai.azure.com/`)  
- Slash အဆုံးတွင် မျှတမှုရှိကြောင်း စစ်ဆေးပါ  
- Endpoint သည် သင့် Azure deployment region နှင့် ကိုက်ညီကြောင်း သေချာပါ  
</details>

<details>
<summary><strong>အမှား: "The deployment was not found"</strong></summary>

- သင့် မော်ဒယ် deployment အမည်သည် Azure တွင် တင်ထားသောအမည်နှင့် တိတိကျကျ ကိုက်ညီကြောင်း စစ်ဆေးပါ  
- မော်ဒယ်သည် အောင်မြင်စွာ တင်ထားပြီး အလုပ်လုပ်နေကြောင်း သေချာပါ  
- Default deployment အမည် `gpt-4o-mini` ကို အသုံးပြုကြည့်ပါ  
</details>

<details>
<summary><strong>VS Code: Environment variables မတင်နိုင်ခြင်း</strong></summary>

- သင့် `.env` ဖိုင်သည် project root directory (ဥပမာ - `pom.xml` နှင့် တူညီသော အဆင့်) တွင် ရှိကြောင်း သေချာပါ  
- VS Code ၏ integrated terminal တွင် `mvn spring-boot:run` ကို ပြေးကြည့်ပါ  
- VS Code Java extension သည် မှန်ကန်စွာ တပ်ဆင်ထားကြောင်း စစ်ဆေးပါ  
- Launch configuration တွင် `"envFile": "${workspaceFolder}/.env"` ပါဝင်ကြောင်း သေချာပါ  
</details>

### Debug Mode

အသေးစိတ် log များကို ဖွင့်ရန်၊ `application.yml` တွင် အောက်ပါလိုင်းများကို uncomment လုပ်ပါ:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## နောက်တစ်ဆင့်များ

**Setup ပြီးစီးပါပြီ!** သင်၏ သင်ကြားမှု ခရီးကို ဆက်လက်လုပ်ဆောင်ပါ:

[အခန်း ၃: Core Generative AI နည်းလမ်းများ](../../../03-CoreGenerativeAITechniques/README.md)

## အရင်းအမြစ်များ

- [Spring AI Azure OpenAI Documentation](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [Azure OpenAI Service Documentation](https://learn.microsoft.com/azure/ai-services/openai/)  
- [Azure AI Foundry Portal](https://ai.azure.com/)  
- [Azure AI Foundry Documentation](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်ခြင်းတွင် အမှားများ သို့မဟုတ် မတိကျမှုများ ပါဝင်နိုင်သည်ကို သတိပြုပါ။ မူရင်းစာရွက်စာတမ်းကို ၎င်း၏ မူရင်းဘာသာစကားဖြင့် အာဏာတရားရှိသော အရင်းအမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များမှ ပရော်ဖက်ရှင်နယ် ဘာသာပြန်ခြင်းကို အကြံပြုပါသည်။ ဤဘာသာပြန်ကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအမှားများ သို့မဟုတ် အနားယူမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။