<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c2a244c959e00da1ae1613d2ebfdac65",
  "translation_date": "2025-07-29T10:27:06+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "my"
}
-->
# Java အတွက် Generative AI ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်ကို စတင်တပ်ဆင်ခြင်း

> **Quick Start**: Cloud မှာ 2 မိနစ်အတွင်း ကုဒ်ရေးရန် - [GitHub Codespaces Setup](../../../02-SetupDevEnvironment) ကို သွားပါ - ဒေသတွင်းမှာ တပ်ဆင်ရန် မလိုအပ်ပါ၊ GitHub Models ကို အသုံးပြုပါ!

> **Azure OpenAI ကို စိတ်ဝင်စားပါသလား?** [Azure OpenAI Setup Guide](getting-started-azure-openai.md) ကို ကြည့်ပါ၊ Azure OpenAI resource အသစ်တစ်ခု ဖန်တီးရန် လိုအပ်သော အဆင့်များပါဝင်သည်။

## သင်လေ့လာနိုင်မည့်အရာများ

- AI အက်ပလီကေးရှင်းများအတွက် Java ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်ကို တပ်ဆင်ခြင်း
- သင့်အကြိုက်ဆုံး ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်ကို ရွေးချယ်ပြီး ဖွဲ့စည်းခြင်း (Codespaces ဖြင့် cloud-first, ဒေသတွင်း dev container, ဒေသတွင်း setup အပြည့်အစုံ)
- GitHub Models ကို ချိတ်ဆက်ပြီး သင့် setup ကို စမ်းသပ်ခြင်း

## အကြောင်းအရာများ

- [သင်လေ့လာနိုင်မည့်အရာများ](../../../02-SetupDevEnvironment)
- [နိဒါန်း](../../../02-SetupDevEnvironment)
- [အဆင့် 1: သင့်ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်ကို တပ်ဆင်ပါ](../../../02-SetupDevEnvironment)
  - [Option A: GitHub Codespaces (အကြံပြုသည်)](../../../02-SetupDevEnvironment)
  - [Option B: Local Dev Container](../../../02-SetupDevEnvironment)
  - [Option C: သင့်ရှိပြီးသား ဒေသတွင်းတပ်ဆင်မှုကို အသုံးပြုပါ](../../../02-SetupDevEnvironment)
- [အဆင့် 2: GitHub Personal Access Token ဖန်တီးပါ](../../../02-SetupDevEnvironment)
- [အဆင့် 3: သင့် Setup ကို စမ်းသပ်ပါ](../../../02-SetupDevEnvironment)
- [ပြဿနာများကို ဖြေရှင်းခြင်း](../../../02-SetupDevEnvironment)
- [အကျဉ်းချုပ်](../../../02-SetupDevEnvironment)
- [နောက်ထပ်အဆင့်များ](../../../02-SetupDevEnvironment)

## နိဒါန်း

ဤအခန်းတွင် ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်ကို စတင်တပ်ဆင်ရန် လမ်းညွှန်ပေးပါမည်။ **GitHub Models** ကို အဓိက ဥပမာအဖြစ် အသုံးပြုမည်ဖြစ်ပြီး၊ GitHub အကောင့်တစ်ခုသာ လိုအပ်ပြီး၊ အခမဲ့၊ အလွယ်တကူ စတင်နိုင်ပြီး၊ ခရက်ဒစ်ကတ်မလိုအပ်ပါ။ ထို့အပြင် စမ်းသပ်ရန် မော်ဒယ်များစွာကို ရရှိနိုင်ပါသည်။

**ဒေသတွင်း setup မလိုအပ်ပါ!** GitHub Codespaces ကို အသုံးပြု၍ သင့် browser မှတစ်ဆင့် အပြည့်အစုံ ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်ကို ချက်ချင်း စတင်ကုဒ်ရေးနိုင်ပါသည်။

<img src="./images/models.webp" alt="Screenshot: GitHub Models" width="50%">

ဤသင်တန်းအတွက် [**GitHub Models**](https://github.com/marketplace?type=models) ကို အသုံးပြုရန် အကြံပြုပါသည်၊ အကြောင်းမှာ:
- စတင်ရန် **အခမဲ့**
- GitHub အကောင့်တစ်ခုသာ လိုအပ်ပြီး **အလွယ်**
- **ခရက်ဒစ်ကတ်မလိုအပ်ပါ**
- စမ်းသပ်ရန် **မော်ဒယ်များစွာ** ရရှိနိုင်ပါသည်

> **Note**: ဤသင်တန်းတွင် အသုံးပြုသော GitHub Models တွင် အခမဲ့ အကန့်အသတ်များရှိသည်:
> - မိနစ် 15 တစ်ကြိမ် (နေ့စဉ် 150 ကြိမ်)
> - ~8,000 စကားလုံး input, ~4,000 စကားလုံး output တစ်ကြိမ်
> - တစ်ချိန်တည်းမှာ 5 ကြိမ်တိုင်

> ထုတ်လုပ်မှုအတွက် Azure AI Foundry Models ကို သင့် Azure အကောင့်ဖြင့် upgrade လုပ်ပါ။ သင့်ကုဒ်ကို ပြောင်းလဲရန် မလိုအပ်ပါ။ [Azure AI Foundry documentation](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models) ကို ကြည့်ပါ။

## အဆင့် 1: သင့်ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်ကို တပ်ဆင်ပါ

<a name="quick-start-cloud"></a>

Generative AI for Java သင်တန်းအတွက် လိုအပ်သော tools များနှင့် dependencies များကို အနည်းဆုံး setup အချိန်ဖြင့် ရရှိစေရန် preconfigured development container တစ်ခုကို ဖန်တီးထားပါသည်။ သင့်အကြိုက်ဆုံး ဖွံ့ဖြိုးရေးနည်းလမ်းကို ရွေးချယ်ပါ:

### ပတ်ဝန်းကျင် Setup ရွေးချယ်မှုများ:

#### Option A: GitHub Codespaces (အကြံပြုသည်)

**ဒေသတွင်း setup မလိုအပ်ပါ - 2 မိနစ်အတွင်း စတင်ကုဒ်ရေးနိုင်ပါ!**

1. ဤ repository ကို သင့် GitHub အကောင့်သို့ fork လုပ်ပါ
   > **Note**: basic config ကို ပြင်ဆင်လိုပါက [Dev Container Configuration](../../../.devcontainer/devcontainer.json) ကို ကြည့်ပါ
2. **Code** → **Codespaces** tab → **...** → **New with options...** ကို နှိပ်ပါ
3. Defaults ကို အသုံးပြုပါ – ဤသည်သည် သင်တန်းအတွက် ဖန်တီးထားသော **Generative AI Java Development Environment** custom devcontainer ကို ရွေးချယ်ပါမည်
4. **Create codespace** ကို နှိပ်ပါ
5. ပတ်ဝန်းကျင်အဆင်သင့်ဖြစ်ရန် ~2 မိနစ်စောင့်ပါ
6. [အဆင့် 2: GitHub Token ဖန်တီးပါ](../../../02-SetupDevEnvironment) သို့ ဆက်လက်လုပ်ဆောင်ပါ

<img src="./images/codespaces.png" alt="Screenshot: Codespaces submenu" width="50%">

<img src="./images/image.png" alt="Screenshot: New with options" width="50%">

<img src="./images/codespaces-create.png" alt="Screenshot: Create codespace options" width="50%">

> **Codespaces ၏ အကျိုးကျေးဇူးများ**:
> - ဒေသတွင်းတပ်ဆင်မှု မလိုအပ်ပါ
> - browser ပါရှိသော device မည်သည့်အမျိုးအစားမဆို အလုပ်လုပ်နိုင်သည်
> - tools နှင့် dependencies အားလုံးကို pre-configured
> - ပုဂ္ဂိုလ်ရေးအကောင့်များအတွက် အခမဲ့ 60 နာရီ/လ
> - သင်တန်းသားများအတွက် ပတ်ဝန်းကျင်တူညီမှု

#### Option B: Local Dev Container

**Docker ဖြင့် ဒေသတွင်းဖွံ့ဖြိုးရေးကို နှစ်သက်သော developer များအတွက်**

1. ဤ repository ကို သင့်ဒေသတွင်းစက်သို့ fork နှင့် clone လုပ်ပါ
   > **Note**: basic config ကို ပြင်ဆင်လိုပါက [Dev Container Configuration](../../../.devcontainer/devcontainer.json) ကို ကြည့်ပါ
2. [Docker Desktop](https://www.docker.com/products/docker-desktop/) နှင့် [VS Code](https://code.visualstudio.com/) ကို တပ်ဆင်ပါ
3. VS Code တွင် [Dev Containers extension](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) ကို တပ်ဆင်ပါ
4. Repository folder ကို VS Code တွင် ဖွင့်ပါ
5. Prompt ဖြစ်လာသောအခါ **Reopen in Container** ကို နှိပ်ပါ (သို့မဟုတ် `Ctrl+Shift+P` → "Dev Containers: Reopen in Container" ကို အသုံးပြုပါ)
6. Container ကို build လုပ်ပြီး စတင်ရန် စောင့်ပါ
7. [အဆင့် 2: GitHub Token ဖန်တီးပါ](../../../02-SetupDevEnvironment) သို့ ဆက်လက်လုပ်ဆောင်ပါ

<img src="./images/devcontainer.png" alt="Screenshot: Dev container setup" width="50%">

<img src="./images/image-3.png" alt="Screenshot: Dev container build complete" width="50%">

#### Option C: သင့်ရှိပြီးသား ဒေသတွင်းတပ်ဆင်မှုကို အသုံးပြုပါ

**Java ပတ်ဝန်းကျင်များရှိပြီးသား developer များအတွက်**

လိုအပ်ချက်များ:
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) သို့မဟုတ် သင့်နှစ်သက်သော IDE

အဆင့်များ:
1. ဤ repository ကို သင့်ဒေသတွင်းစက်သို့ clone လုပ်ပါ
2. Project ကို သင့် IDE တွင် ဖွင့်ပါ
3. [အဆင့် 2: GitHub Token ဖန်တီးပါ](../../../02-SetupDevEnvironment) သို့ ဆက်လက်လုပ်ဆောင်ပါ

> **Pro Tip**: သင့်စက် specs များနည်းပါက ဒေသတွင်း VS Code ကို အသုံးပြုလိုပါက GitHub Codespaces ကို အသုံးပြုပါ! Cloud-hosted Codespace ကို သင့်ဒေသတွင်း VS Code နှင့် ချိတ်ဆက်နိုင်ပါသည်။

<img src="./images/image-2.png" alt="Screenshot: created local devcontainer instance" width="50%">

## အဆင့် 2: GitHub Personal Access Token ဖန်တီးပါ

1. [GitHub Settings](https://github.com/settings/profile) သို့ သွားပြီး သင့် profile menu မှ **Settings** ကို ရွေးပါ။
2. ဘယ်ဘက် sidebar တွင် **Developer settings** ကို နှိပ်ပါ (အောက်ဆုံးတွင်ရှိသည်)။
3. **Personal access tokens** အောက်တွင် **Fine-grained tokens** ကို နှိပ်ပါ (သို့မဟုတ် ဤ [link](https://github.com/settings/personal-access-tokens) ကို တိုက်ရိုက်လိုက်ပါ)။
4. **Generate new token** ကို နှိပ်ပါ။
5. "Token name" အောက်တွင် ဖော်ပြချက်အမည် (ဥပမာ `GenAI-Java-Course-Token`) ထည့်ပါ။
6. Expiration date ကို သတ်မှတ်ပါ (လုံခြုံရေးအတွက် အကြံပြုချက်: 7 ရက်)။
7. "Resource owner" အောက်တွင် သင့် user account ကို ရွေးပါ။
8. "Repository access" အောက်တွင် GitHub Models ကို အသုံးပြုလိုသော repositories (သို့မဟုတ် "All repositories") ကို ရွေးပါ။
9. "Repository permissions" အောက်တွင် **Models** ကို ရှာပြီး **Read and write** သို့ ပြောင်းပါ။
10. **Generate token** ကို နှိပ်ပါ။
11. **သင့် token ကို ယခုကူးပြီး သိမ်းဆည်းပါ** – နောက်တစ်ကြိမ် မမြင်နိုင်တော့ပါ။

> **Security Tip**: Access tokens အတွက် လိုအပ်သော scope အနည်းဆုံးနှင့် အကန့်အသတ်အချိန်အတိုဆုံးကို အသုံးပြုပါ။

## အဆင့် 3: GitHub Models Example ဖြင့် သင့် Setup ကို စမ်းသပ်ပါ

သင့်ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်အဆင်သင့်ဖြစ်ပြီးနောက် GitHub Models integration ကို [`02-SetupDevEnvironment/examples/github-models`](../../../02-SetupDevEnvironment/examples/github-models) တွင်ရှိသော ဥပမာ application ဖြင့် စမ်းသပ်ပါ။

1. သင့်ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်တွင် terminal ကို ဖွင့်ပါ။
2. GitHub Models ဥပမာသို့ သွားပါ:
   ```bash
   cd 02-SetupDevEnvironment/examples/github-models
   ```
3. သင့် GitHub token ကို environment variable အဖြစ် သတ်မှတ်ပါ:
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

သင့် output တွင် အောက်ပါအတိုင်း ဖြစ်ရမည်:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### ဤဥပမာကုဒ်ကို နားလည်ခြင်း

ပထမဦးဆုံး သင်ရပ်တည်ပြီး run လုပ်ခဲ့သောအရာကို နားလည်ပါ။ `examples/github-models` အောက်ရှိ ဤဥပမာသည် OpenAI Java SDK ကို အသုံးပြု၍ GitHub Models ကို ချိတ်ဆက်သည်:

**ဤကုဒ်၏လုပ်ဆောင်မှုများ:**
- **GitHub Models** ကို သင့် personal access token ဖြင့် ချိတ်ဆက်သည်
- AI မော်ဒယ်ထံ "Say Hello World!" စာတစ်စောင်ကို **ပို့သည်**
- AI ၏ အဖြေကို **လက်ခံပြီး ပြသသည်**
- သင့် setup မှန်ကန်စွာ အလုပ်လုပ်နေသည်ကို **အတည်ပြုသည်**

**Key Dependency** (`pom.xml` တွင်):
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

## အကျဉ်းချုပ်

အိုကေ! သင်အခုအချိန်တွင် အားလုံးကို တပ်ဆင်ပြီးဖြစ်ပါပြီ:

- AI မော်ဒယ်များကို ချိတ်ဆက်ရန် လိုအပ်သော permissions ဖြင့် GitHub Personal Access Token တစ်ခု ဖန်တီးခဲ့သည်
- Java ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်ကို စတင်ခဲ့သည် (Codespaces, dev containers, ဒေသတွင်း setup မည်သည့်နည်းလမ်းဖြင့်မဆို)
- OpenAI Java SDK ကို အသုံးပြု၍ GitHub Models ကို ချိတ်ဆက်ခဲ့သည်
- AI မော်ဒယ်များနှင့် ဆက်သွယ်သော ဥပမာတစ်ခုကို run လုပ်ပြီး အားလုံးအလုပ်လုပ်နေသည်ကို စမ်းသပ်ခဲ့သည်

## နောက်ထပ်အဆင့်များ

[Chapter 3: Core Generative AI Techniques](../03-CoreGenerativeAITechniques/README.md)

## ပြဿနာများကို ဖြေရှင်းခြင်း

ပြဿနာရှိပါသလား? အောက်ပါ ပြဿနာများနှင့် ဖြေရှင်းနည်းများကို ကြည့်ပါ:

- **Token အလုပ်မလုပ်ပါသလား?** 
  - Token အပြည့်အစုံကို အပိုနေရာများမပါဘဲ ကူးထားကြောင်း သေချာပါ
  - Token ကို environment variable အဖြစ် မှန်ကန်စွာ သတ်မှတ်ထားကြောင်း စစ်ဆေးပါ
  - Token ၏ permissions မှန်ကန်ကြောင်း (Models: Read and write) စစ်ဆေးပါ

- **Maven မတွေ့ပါသလား?** 
  - Dev containers/Codespaces ကို အသုံးပြုပါက Maven ကို pre-installed ဖြစ်ရမည်
  - ဒေသတွင်း setup အတွက် Java 21+ နှင့် Maven 3.9+ တပ်ဆင်ထားကြောင်း သေချာပါ
  - `mvn --version` ကို run လုပ်၍ installation ကို စစ်ဆေးပါ

- **ချိတ်ဆက်မှုပြဿနာများ?** 
  - သင့်အင်တာနက်ချိတ်ဆက်မှုကို စစ်ဆေးပါ
  - GitHub ကို သင့် network မှတစ်ဆင့် ဝင်ရောက်နိုင်ကြောင်း အတည်ပြုပါ
  - GitHub Models endpoint ကို ပိတ်ဆို့ထားသော firewall မရှိကြောင်း သေချာပါ

- **Dev container မစတင်နိုင်ပါသလား?** 
  - Docker Desktop ကို run လုပ်ထားကြောင်း (ဒေသတွင်းဖွံ့ဖြိုးရေးအတွက်) သေချာပါ
  - Container ကို ပြန်လည် build လုပ်ပါ: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container"

- **Application compilation error များ?**
  - သင့် directory မှန်ကန်ကြောင်း (`02-SetupDevEnvironment/examples/github-models`) သေချာပါ
  - Clean နှင့် rebuild လုပ်ပါ: `mvn clean compile`

> **အကူအညီလိုပါသလား?**: ပြဿနာများရှိနေပါသလား? Repository တွင် issue တစ်ခုဖွင့်ပြီး ကျွန်ုပ်တို့ကူညီပေးပါမည်။

**ဝက်ဘ်ဆိုက်မှတ်ချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှန်ကန်မှုအတွက် ကြိုးစားနေပါသော်လည်း၊ အလိုအလျောက်ဘာသာပြန်မှုများတွင် အမှားများ သို့မဟုတ် မမှန်ကန်မှုများ ပါဝင်နိုင်သည်ကို ကျေးဇူးပြု၍ သတိပြုပါ။ မူရင်းစာရွက်စာတမ်းကို ၎င်း၏ မူလဘာသာစကားဖြင့် အာဏာတည်သောရင်းမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များမှ အတည်ပြုထားသော ဘာသာပြန်မှုကို အသုံးပြုရန် အကြံပြုပါသည်။ ဤဘာသာပြန်မှုကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော နားလည်မှုမှားမှုများ သို့မဟုတ် အဓိပ္ပာယ်မှားမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မရှိပါ။