<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "40abf4889418bff189039ac30ff44281",
  "translation_date": "2025-07-23T12:42:18+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "my"
}
-->
# Java အတွက် Generative AI Development Environment ကို Set Up လုပ်ခြင်း

> **Quick Start**: Cloud မှာ 2 မိနစ်အတွင်း Code ရေးရန် - [GitHub Codespaces Setup](../../../02-SetupDevEnvironment) ကိုသွားပါ - local installation မလိုအပ်ပါဘူး၊ GitHub models ကိုအသုံးပြုပါ!

> **Azure OpenAI ကိုစိတ်ဝင်စားပါသလား?** [Azure OpenAI Setup Guide](getting-started-azure-openai.md) ကိုကြည့်ပါ၊ Azure OpenAI resource အသစ်တစ်ခုကိုဖန်တီးရန်အဆင့်များပါဝင်သည်။

## သင်လေ့လာနိုင်မည့်အရာများ

- AI application များအတွက် Java development environment ကို set up လုပ်ခြင်း
- သင့်အကြိုက်ဆုံး development environment ကိုရွေးချယ်ပြီး configure လုပ်ခြင်း (Codespaces ဖြင့် cloud-first, local dev container, သို့မဟုတ် full local setup)
- GitHub Models ကိုချိတ်ဆက်ပြီး setup ကိုစမ်းသပ်ခြင်း

## အကြောင်းအရာများ

- [သင်လေ့လာနိုင်မည့်အရာများ](../../../02-SetupDevEnvironment)
- [Introduction](../../../02-SetupDevEnvironment)
- [အဆင့် ၁: Development Environment ကို Set Up လုပ်ပါ](../../../02-SetupDevEnvironment)
  - [Option A: GitHub Codespaces (အကြံပြုထားသည်)](../../../02-SetupDevEnvironment)
  - [Option B: Local Dev Container](../../../02-SetupDevEnvironment)
  - [Option C: သင့်ရဲ့ Local Installation ကိုအသုံးပြုပါ](../../../02-SetupDevEnvironment)
- [အဆင့် ၂: GitHub Personal Access Token ဖန်တီးပါ](../../../02-SetupDevEnvironment)
- [အဆင့် ၃: Setup ကို GitHub Models Example ဖြင့်စမ်းသပ်ပါ](../../../02-SetupDevEnvironment)
- [Troubleshooting](../../../02-SetupDevEnvironment)
- [Summary](../../../02-SetupDevEnvironment)
- [Next Steps](../../../02-SetupDevEnvironment)

## Introduction

ဤအခန်းတွင် development environment ကို set up လုပ်ရန်လမ်းညွှန်ပေးပါမည်။ **GitHub Models** ကိုအဓိကဥပမာအဖြစ်အသုံးပြုမည်ဖြစ်ပြီး၊ GitHub account တစ်ခုသာလိုအပ်ပြီး၊ credit card မလိုအပ်ဘဲ၊ အလွယ်တကူ setup လုပ်နိုင်ပြီး၊ မျိုးစုံသော models များကိုစမ်းသပ်နိုင်ရန် access ပေးပါသည်။

**Local setup မလိုအပ်ပါ!** GitHub Codespaces ကိုအသုံးပြု၍ browser မှာတင်အပြည့်အစုံ development environment ကိုစတင်နိုင်ပါသည်။

<img src="./images/models.webp" alt="Screenshot: GitHub Models" width="50%">

ဤသင်တန်းအတွက် [**GitHub Models**](https://github.com/marketplace?type=models) ကိုအသုံးပြုရန်အကြံပြုပါသည်၊ အကြောင်းကတော့:
- **အခမဲ့** စတင်နိုင်သည်
- **အလွယ်တကူ** GitHub account တစ်ခုသာလိုအပ်သည်
- **Credit card မလိုအပ်ပါ** 
- **မျိုးစုံသော models** စမ်းသပ်နိုင်သည်

> **Note**: ဤသင်တန်းတွင်အသုံးပြုသော GitHub Models တွင်အခမဲ့အကန့်အသတ်များရှိသည်:
> - မိနစ် ၁၅ request (နေ့စဉ် ၁၅၀)
> - ~8,000 စကားလုံး input, ~4,000 စကားလုံး output per request
> - 5 concurrent requests
> 
> Production အတွက် Azure AI Foundry Models ကို upgrade လုပ်ပါ။ သင့် code ကိုမပြောင်းလဲရပါ။ [Azure AI Foundry documentation](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models) ကိုကြည့်ပါ။

## အဆင့် ၁: Development Environment ကို Set Up လုပ်ပါ

<a name="quick-start-cloud"></a>

Generative AI for Java သင်တန်းအတွက်လိုအပ်သော tools များကိုအနည်းဆုံး setup အချိန်ဖြင့်ရရှိစေရန် preconfigured development container တစ်ခုကိုဖန်တီးထားပါသည်။ သင့်အကြိုက်ဆုံး development approach ကိုရွေးချယ်ပါ:

### Environment Setup Options:

#### Option A: GitHub Codespaces (အကြံပြုထားသည်)

**2 မိနစ်အတွင်း coding စတင်ပါ - local setup မလိုအပ်ပါ!**

1. ဤ repository ကို GitHub account သို့ fork လုပ်ပါ
   > **Note**: Basic config ကိုပြင်လိုပါက [Dev Container Configuration](../../../.devcontainer/devcontainer.json) ကိုကြည့်ပါ
2. **Code** → **Codespaces** tab → **...** → **New with options...** ကိုနှိပ်ပါ
3. Defaults ကိုအသုံးပြုပါ – ဤသည် **Dev container configuration** ကိုရွေးချယ်ပါမည်: **Generative AI Java Development Environment** သင်တန်းအတွက်ဖန်တီးထားသော custom devcontainer
4. **Create codespace** ကိုနှိပ်ပါ
5. Environment ပြင်ဆင်ရန် ~2 မိနစ်စောင့်ပါ
6. [အဆင့် ၂: GitHub Token ဖန်တီးပါ](../../../02-SetupDevEnvironment) သို့ဆက်လက်လုပ်ဆောင်ပါ

<img src="./images/codespaces.png" alt="Screenshot: Codespaces submenu" width="50%">

<img src="./images/image.png" alt="Screenshot: New with options" width="50%">

<img src="./images/codespaces-create.png" alt="Screenshot: Create codespace options" width="50%">

> **Codespaces ၏ အကျိုးကျေးဇူးများ**:
> - Local installation မလိုအပ်ပါ
> - Browser ရှိ device များအားလုံးတွင်အလုပ်လုပ်သည်
> - Tools နှင့် dependencies အားလုံးကို pre-configured
> - Personal accounts အတွက် 60 နာရီအခမဲ့
> - သင်တန်းသားအားလုံးအတွက် consistent environment

#### Option B: Local Dev Container

**Docker ဖြင့် local development ကိုနှစ်သက်သော developer များအတွက်**

1. ဤ repository ကို local machine သို့ fork နှင့် clone လုပ်ပါ
   > **Note**: Basic config ကိုပြင်လိုပါက [Dev Container Configuration](../../../.devcontainer/devcontainer.json) ကိုကြည့်ပါ
2. [Docker Desktop](https://www.docker.com/products/docker-desktop/) နှင့် [VS Code](https://code.visualstudio.com/) ကို install လုပ်ပါ
3. VS Code တွင် [Dev Containers extension](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) ကို install လုပ်ပါ
4. Repository folder ကို VS Code တွင်ဖွင့်ပါ
5. Prompt ဖြစ်လာသောအခါ **Reopen in Container** ကိုနှိပ်ပါ (သို့မဟုတ် `Ctrl+Shift+P` → "Dev Containers: Reopen in Container" ကိုအသုံးပြုပါ)
6. Container ကို build နှင့် start လုပ်ရန်စောင့်ပါ
7. [အဆင့် ၂: GitHub Token ဖန်တီးပါ](../../../02-SetupDevEnvironment) သို့ဆက်လက်လုပ်ဆောင်ပါ

<img src="./images/devcontainer.png" alt="Screenshot: Dev container setup" width="50%">

<img src="./images/image-3.png" alt="Screenshot: Dev container build complete" width="50%">

#### Option C: သင့်ရဲ့ Local Installation ကိုအသုံးပြုပါ

**Java environment ရှိပြီးသား developer များအတွက်**

လိုအပ်ချက်များ:
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) သို့မဟုတ် သင့်အကြိုက်ဆုံး IDE

အဆင့်များ:
1. Repository ကို local machine သို့ clone လုပ်ပါ
2. Project ကို IDE တွင်ဖွင့်ပါ
3. [အဆင့် ၂: GitHub Token ဖန်တီးပါ](../../../02-SetupDevEnvironment) သို့ဆက်လက်လုပ်ဆောင်ပါ

> **Pro Tip**: Low-spec machine ရှိပြီး local VS Code ကိုအသုံးပြုလိုပါက GitHub Codespaces ကိုအသုံးပြုပါ! Cloud-hosted Codespace ကို local VS Code နှင့်ချိတ်ဆက်နိုင်သည်။

<img src="./images/image-2.png" alt="Screenshot: created local devcontainer instance" width="50%">

## အဆင့် ၂: GitHub Personal Access Token ဖန်တီးပါ

1. [GitHub Settings](https://github.com/settings/profile) သို့သွားပြီး profile menu မှ **Settings** ကိုရွေးချယ်ပါ။
2. ဘယ်ဘက် sidebar တွင် **Developer settings** ကိုနှိပ်ပါ (အောက်ဆုံးတွင်ရှိသည်)။
3. **Personal access tokens** အောက်တွင် **Fine-grained tokens** ကိုနှိပ်ပါ (သို့မဟုတ်ဤ [link](https://github.com/settings/personal-access-tokens) ကိုလိုက်ပါ)။
4. **Generate new token** ကိုနှိပ်ပါ။
5. "Token name" အောက်တွင်ဖော်ပြချက်အမည် (ဥပမာ `GenAI-Java-Course-Token`) ထည့်ပါ။
6. Expiration date ကိုသတ်မှတ်ပါ (လုံခြုံရေးအတွက် 7 ရက်အကြံပြုသည်)။
7. "Resource owner" အောက်တွင် သင့် user account ကိုရွေးချယ်ပါ။
8. "Repository access" အောက်တွင် GitHub Models အသုံးပြုလိုသော repositories ကိုရွေးချယ်ပါ (သို့မဟုတ် "All repositories" လိုအပ်ပါက)။
9. "Repository permissions" အောက်တွင် **Models** ကိုရှာပြီး **Read and write** သို့ပြောင်းပါ။
10. **Generate token** ကိုနှိပ်ပါ။
11. **Token ကိုယခုကူးပြီး save လုပ်ပါ** – နောက်တစ်ကြိမ်မမြင်နိုင်ပါ။

> **Security Tip**: Access tokens အတွက်လိုအပ်သော scope အနည်းဆုံးနှင့် practical expiration time အတိုဆုံးကိုအသုံးပြုပါ။

## အဆင့် ၃: Setup ကို GitHub Models Example ဖြင့်စမ်းသပ်ပါ

Development environment ပြင်ဆင်ပြီးပါက GitHub Models integration ကို `02-SetupDevEnvironment/src/github-models` တွင်ရှိသောဥပမာ application ဖြင့်စမ်းသပ်ပါ။

1. Development environment တွင် terminal ကိုဖွင့်ပါ။
2. GitHub Models example သို့သွားပါ:
   ```bash
   cd 02-SetupDevEnvironment/src/github-models
   ```
3. GitHub token ကို environment variable အဖြစ် set လုပ်ပါ:
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. Application ကို run လုပ်ပါ:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

Output အနေနှင့်:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### ဥပမာ Code ကိုနားလည်ခြင်း

ပထမဦးဆုံး၊ သင်ရောစမ်းသပ်ပြီးသောအရာကိုနားလည်ပါ။ `src/github-models` အောက်ရှိဥပမာသည် OpenAI Java SDK ကိုအသုံးပြု၍ GitHub Models နှင့်ချိတ်ဆက်သည်။

**ဤ code ၏လုပ်ဆောင်မှုများ:**
- **GitHub Models** နှင့် personal access token ကိုအသုံးပြု၍ချိတ်ဆက်သည်
- AI model သို့ "Say Hello World!" message တစ်ခုကို **ပို့သည်**
- AI ၏ response ကို **လက်ခံပြီးပြသသည်**
- Setup မှန်ကန်မှုကို **အတည်ပြုသည်**

**Key Dependency** (`pom.xml`):
```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

**Main Code** (`App.java`):
```java
// Connect to GitHub Models using OpenAI Java SDK
OpenAIClient client = OpenAIOkHttpClient.builder()
    .apiKey(pat)
    .baseUrl("https://models.inference.ai.azure.com")
    .build();

// Create chat completion request
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .model(modelId)
    .addSystemMessage("You are a concise assistant.")
    .addUserMessage("Say Hello World!")
    .build();

// Get AI response
ChatCompletion response = client.chat().completions().create(params);
System.out.println("Response: " + response.choices().get(0).message().content().orElse("No response content"));
```

## Summary

**ဂုဏ်ယူပါတယ်!** သင်အောင်မြင်စွာ:

- **GitHub Personal Access Token** ကို AI model access အတွက်လိုအပ်သော permissions ဖြင့်ဖန်တီးပြီး
- **Java development environment** ကို Codespaces, dev containers, သို့မဟုတ် local installation ဖြင့် set up လုပ်ပြီး
- **GitHub Models** ကို OpenAI Java SDK ဖြင့်ချိတ်ဆက်ပြီး free AI development access ရရှိပြီး
- **Integration ကိုစမ်းသပ်ပြီး** AI models နှင့်ဆက်သွယ်သော working example application ရရှိခဲ့သည်

## Next Steps

[Chapter 3: Core Generative AI Techniques](../03-CoreGenerativeAITechniques/README.md)

## Troubleshooting

ပြဿနာရှိပါသလား? အများဆုံးဖြစ်နိုင်သောပြဿနာများနှင့်ဖြေရှင်းနည်းများ:

- **Token အလုပ်မလုပ်ပါသလား?** 
  - Token အပြည့်အစုံကို extra spaces မပါဘဲ copy လုပ်ထားပါ
  - Token ကို environment variable အဖြစ်မှန်ကန်စွာ set လုပ်ထားပါ
  - Token ၏ permissions မှန်ကန်မှု (Models: Read and write) ကိုစစ်ဆေးပါ

- **Maven မတွေ့ပါသလား?** 
  - Dev containers/Codespaces အသုံးပြုပါက Maven pre-installed ဖြစ်သင့်သည်
  - Local setup အတွက် Java 21+ နှင့် Maven 3.9+ install လုပ်ထားပါ
  - `mvn --version` ဖြင့် installation ကိုစစ်ဆေးပါ

- **Connection ပြဿနာများ?** 
  - သင့် internet connection ကိုစစ်ဆေးပါ
  - GitHub သို့ network မှ access ရှိမှုကိုစစ်ဆေးပါ
  - GitHub Models endpoint ကို block လုပ်သော firewall မရှိကြောင်းသေချာပါ

- **Dev container မစတင်နိုင်ပါသလား?** 
  - Docker Desktop ကို run လုပ်ထားပါ (local development အတွက်)
  - Container ကိုပြန်လည် build လုပ်ပါ: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container"

- **Application compilation errors?**
  - မှန်ကန် directory (`02-SetupDevEnvironment/src/github-models`) တွင်ရှိကြောင်းသေချာပါ
  - Clean နှင့် rebuild လုပ်ပါ: `mvn clean compile`

> **အကူအညီလိုပါသလား?**: ပြဿနာရှိနေသေးပါက repository တွင် issue တစ်ခုဖွင့်ပြီးအကူအညီတောင်းပါ။

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်မှုများတွင် အမှားများ သို့မဟုတ် မတိကျမှုများ ပါဝင်နိုင်သည်ကို သတိပြုပါ။ မူရင်းစာရွက်စာတမ်းကို ၎င်း၏ မူရင်းဘာသာစကားဖြင့် အာဏာတရ အရင်းအမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များမှ ပရော်ဖက်ရှင်နယ် ဘာသာပြန်မှုကို အကြံပြုပါသည်။ ဤဘာသာပြန်မှုကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအမှားများ သို့မဟုတ် အနားလွဲမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။