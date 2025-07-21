<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0b563ac59362fb83f0f49dcfc442dd97",
  "translation_date": "2025-07-21T21:01:27+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "my"
}
-->
# Java အတွက် Generative AI ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်ကို သတ်မှတ်ခြင်း

> **အမြန်စတင်ရန်**: Cloud မှာ ၂ မိနစ်အတွင်း Code ရေးပါ - [GitHub Codespaces Setup](../../../02-SetupDevEnvironment) ကိုသွားပါ - ဒါကိုယ်တိုင် local installation မလိုအပ်ဘဲ GitHub models ကိုအသုံးပြုပါတယ်!

> **Azure OpenAI ကိုစိတ်ဝင်စားပါသလား?** [Azure OpenAI Setup Guide](getting-started-azure-openai.md) ကိုကြည့်ပါ၊ Azure OpenAI resource အသစ်တစ်ခုဖန်တီးရန်အဆင့်များပါဝင်ပါတယ်။

## သင်လေ့လာနိုင်မည့်အရာများ

- AI အက်ပလီကေးရှင်းများအတွက် Java ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်ကို သတ်မှတ်ခြင်း
- သင့်နှစ်သက်ရာဖွံ့ဖြိုးရေးပတ်ဝန်းကျင် (Codespaces ဖြင့် cloud-first, local dev container, သို့မဟုတ် full local setup) ကိုရွေးချယ်ပြီး configure ပြုလုပ်ခြင်း
- GitHub Models နှင့်ချိတ်ဆက်ပြီး သင့် setup ကိုစမ်းသပ်ခြင်း

## အကြောင်းအရာများ

- [သင်လေ့လာနိုင်မည့်အရာများ](../../../02-SetupDevEnvironment)
- [နိဒါန်း](../../../02-SetupDevEnvironment)
- [အဆင့် ၁: သင့်ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်ကို သတ်မှတ်ပါ](../../../02-SetupDevEnvironment)
  - [ရွေးချယ်မှု A: GitHub Codespaces (အကြံပြုသည်)](../../../02-SetupDevEnvironment)
  - [ရွေးချယ်မှု B: Local Dev Container](../../../02-SetupDevEnvironment)
  - [ရွေးချယ်မှု C: သင့်ရဲ့ ရှိပြီးသား Local Installation ကိုအသုံးပြုပါ](../../../02-SetupDevEnvironment)
- [အဆင့် ၂: GitHub Personal Access Token ဖန်တီးပါ](../../../02-SetupDevEnvironment)
- [အဆင့် ၃: သင့် Setup ကိုစမ်းသပ်ပါ](../../../02-SetupDevEnvironment)
- [ပြဿနာများကိုဖြေရှင်းခြင်း](../../../02-SetupDevEnvironment)
- [အကျဉ်းချုပ်](../../../02-SetupDevEnvironment)
- [နောက်ထပ်အဆင့်များ](../../../02-SetupDevEnvironment)

## နိဒါန်း

ဤအခန်းတွင် ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်ကို သတ်မှတ်ရန် လမ်းညွှန်ပေးပါမည်။ **GitHub Models** ကို ကျွန်ုပ်တို့၏ အဓိကဥပမာအဖြစ် အသုံးပြုမည်ဖြစ်ပြီး၊ ဒါဟာ အခမဲ့ဖြစ်ပြီး GitHub အကောင့်တစ်ခုသာလိုအပ်ပြီး၊ credit card မလိုအပ်ဘဲ စမ်းသပ်ရန်အတွက် မော်ဒယ်များစွာကိုရရှိနိုင်ပါသည်။

**Local setup မလိုအပ်ပါ!** GitHub Codespaces ကိုအသုံးပြု၍ သင့် browser မှတစ်ဆင့် အပြည့်အစုံသော ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်ကို ချက်ချင်းစတင်နိုင်ပါသည်။

<img src="./images/models.webp" alt="Screenshot: GitHub Models" width="50%">

ကျွန်ုပ်တို့ဤသင်တန်းအတွက် [**GitHub Models**](https://github.com/marketplace?type=models) ကို အသုံးပြုရန် အကြံပြုပါသည်၊ အကြောင်းမှာ:
- စတင်ရန် **အခမဲ့**
- GitHub အကောင့်တစ်ခုသာလိုအပ်ပြီး **လွယ်ကူ**
- **Credit card မလိုအပ်**
- စမ်းသပ်ရန် **မော်ဒယ်များစွာ** ရရှိနိုင်

> **မှတ်ချက်**: ဤသင်တန်းတွင် အသုံးပြုသော GitHub Models တွင် အခမဲ့ကန့်သတ်ချက်များရှိပါသည်:
> - မိနစ် ၁၅ မျှောလင့်ချက် (တစ်နေ့လျှင် ၁၅၀)
> - တစ်တောင်းဆိုမှုလျှင် ~၈,၀၀၀ စကားလုံးထည့်, ~၄,၀၀၀ စကားလုံးထွက်
> - တစ်ချိန်တည်းတွင် ၅ တောင်းဆိုမှု
> 
> ထုတ်လုပ်မှုအတွက် Azure AI Foundry Models သို့ အဆင့်မြှင့်တင်ပါ။ သင့် code ကိုမပြောင်းလဲရပါ။ [Azure AI Foundry documentation](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models) ကိုကြည့်ပါ။

## အဆင့် ၁: သင့်ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်ကို သတ်မှတ်ပါ

<a name="quick-start-cloud"></a>

Java အတွက် Generative AI သင်တန်းအတွက် လိုအပ်သော tools များအားလုံးပါဝင်သည့် preconfigured development container ကို ကျွန်ုပ်တို့ဖန်တီးထားပါသည်။ သင့်နှစ်သက်ရာ ဖွံ့ဖြိုးရေးနည်းလမ်းကို ရွေးချယ်ပါ:

### ပတ်ဝန်းကျင်သတ်မှတ်ခြင်းရွေးချယ်မှုများ:

#### ရွေးချယ်မှု A: GitHub Codespaces (အကြံပြုသည်)

**၂ မိနစ်အတွင်း coding စတင်ပါ - local setup မလိုအပ်ပါ!**

1. ဤ repository ကို သင့် GitHub အကောင့်သို့ fork လုပ်ပါ  
   > **မှတ်ချက်**: Basic config ကိုပြင်ဆင်လိုပါက [Dev Container Configuration](../../../.devcontainer/devcontainer.json) ကိုကြည့်ပါ။
2. **Code** → **Codespaces** tab → **...** → **New with options...** ကိုနှိပ်ပါ။
3. Defaults ကိုအသုံးပြုပါ – ဤသည် **Generative AI Java Development Environment** custom devcontainer ကိုရွေးချယ်ပါမည်။
4. **Create codespace** ကိုနှိပ်ပါ။
5. ပတ်ဝန်းကျင်အဆင်သင့်ဖြစ်ရန် ~၂ မိနစ်စောင့်ပါ။
6. [အဆင့် ၂: GitHub Token ဖန်တီးပါ](../../../02-SetupDevEnvironment) သို့ဆက်လက်လုပ်ဆောင်ပါ။

<img src="./images/codespaces.png" alt="Screenshot: Codespaces submenu" width="50%">

<img src="./images/image.png" alt="Screenshot: New with options" width="50%">

<img src="./images/codespaces-create.png" alt="Screenshot: Create codespace options" width="50%">

> **Codespaces ၏ အကျိုးကျေးဇူးများ**:
> - Local installation မလိုအပ်ပါ
> - Browser ပါသည့် device မည်သည့်အရာတွင်မဆို အလုပ်လုပ်နိုင်သည်
> - Tools နှင့် dependencies အားလုံးကို ကြိုတင် configure ပြုလုပ်ထားသည်
> - Personal accounts အတွက် တစ်လလျှင် အခမဲ့ ၆၀ နာရီ
> - သင်တန်းသားအားလုံးအတွက် တူညီသောပတ်ဝန်းကျင်

#### ရွေးချယ်မှု B: Local Dev Container

**Docker ဖြင့် local development ကိုနှစ်သက်သော developer များအတွက်**

1. ဤ repository ကို သင့် local machine သို့ fork နှင့် clone လုပ်ပါ  
   > **မှတ်ချက်**: Basic config ကိုပြင်ဆင်လိုပါက [Dev Container Configuration](../../../.devcontainer/devcontainer.json) ကိုကြည့်ပါ။
2. [Docker Desktop](https://www.docker.com/products/docker-desktop/) နှင့် [VS Code](https://code.visualstudio.com/) ကို install လုပ်ပါ။
3. VS Code တွင် [Dev Containers extension](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) ကို install လုပ်ပါ။
4. Repository folder ကို VS Code တွင်ဖွင့်ပါ။
5. Prompt ပြသပါက **Reopen in Container** ကိုနှိပ်ပါ (သို့မဟုတ် `Ctrl+Shift+P` → "Dev Containers: Reopen in Container" ကိုအသုံးပြုပါ)။
6. Container build နှင့် start ပြုလုပ်ရန်စောင့်ပါ။
7. [အဆင့် ၂: GitHub Token ဖန်တီးပါ](../../../02-SetupDevEnvironment) သို့ဆက်လက်လုပ်ဆောင်ပါ။

<img src="./images/devcontainer.png" alt="Screenshot: Dev container setup" width="50%">

<img src="./images/image-3.png" alt="Screenshot: Dev container build complete" width="50%">

#### ရွေးချယ်မှု C: သင့်ရဲ့ ရှိပြီးသား Local Installation ကိုအသုံးပြုပါ

**Java environment ရှိပြီးသား developer များအတွက်**

လိုအပ်ချက်များ:
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) သို့မဟုတ် သင့်နှစ်သက်ရာ IDE

အဆင့်များ:
1. ဤ repository ကို သင့် local machine သို့ clone လုပ်ပါ။
2. Project ကို သင့် IDE တွင်ဖွင့်ပါ။
3. [အဆင့် ၂: GitHub Token ဖန်တီးပါ](../../../02-SetupDevEnvironment) သို့ဆက်လက်လုပ်ဆောင်ပါ။

> **Pro Tip**: သင့်စက် specs နည်းပါးပြီး local VS Code ကိုအသုံးပြုလိုပါက GitHub Codespaces ကိုအသုံးပြုပါ! Cloud-hosted Codespace ကို သင့် local VS Code နှင့်ချိတ်ဆက်နိုင်သည်။

<img src="./images/image-2.png" alt="Screenshot: created local devcontainer instance" width="50%">

## အဆင့် ၂: GitHub Personal Access Token ဖန်တီးပါ

1. [GitHub Settings](https://github.com/settings/profile) သို့သွားပြီး သင့် profile menu မှ **Settings** ကိုရွေးချယ်ပါ။
2. ဘယ်ဘက် sidebar တွင် **Developer settings** ကိုနှိပ်ပါ (အောက်ဆုံးတွင်ရှိသည်)။
3. **Personal access tokens** အောက်တွင် **Fine-grained tokens** ကိုနှိပ်ပါ (သို့မဟုတ် ဤ [link](https://github.com/settings/personal-access-tokens) ကိုလိုက်ပါ)။
4. **Generate new token** ကိုနှိပ်ပါ။
5. "Token name" အောက်တွင် ဖော်ပြချက်အမည် (ဥပမာ `GenAI-Java-Course-Token`) ထည့်ပါ။
6. Expiration date ကိုသတ်မှတ်ပါ (လုံခြုံရေးအတွက် အကြံပြုချက်: ၇ ရက်)။
7. "Resource owner" အောက်တွင် သင့် user account ကိုရွေးချယ်ပါ။
8. "Repository access" အောက်တွင် သင့်အသုံးပြုလိုသော repositories (သို့မဟုတ် "All repositories") ကိုရွေးချယ်ပါ။
9. "Repository permissions" အောက်တွင် **Models** ကိုရှာပြီး **Read and write** သို့ပြောင်းပါ။
10. **Generate token** ကိုနှိပ်ပါ။
11. **ယခုသင့် token ကို copy နှင့် save လုပ်ပါ** – နောက်တစ်ကြိမ်မမြင်ရတော့ပါ။

> **လုံခြုံရေးအကြံပြုချက်**: သင့် access tokens အတွက် လိုအပ်သောအနည်းဆုံး scope နှင့် အတိုဆုံး practical expiration time ကိုအသုံးပြုပါ။

## အဆင့် ၃: GitHub Models Example ဖြင့် သင့် Setup ကိုစမ်းသပ်ပါ

သင့်ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်အဆင်သင့်ဖြစ်ပြီးနောက် GitHub Models integration ကို ဤဥပမာအက်ပလီကေးရှင်းဖြင့်စမ်းသပ်ပါ: [`02-SetupDevEnvironment/src/github-models`](../../../02-SetupDevEnvironment/src/github-models)။

1. သင့်ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်တွင် terminal ကိုဖွင့်ပါ။
2. GitHub Models ဥပမာ folder သို့သွားပါ:
   ```bash
   cd 02-SetupDevEnvironment/src/github-models
   ```
3. သင့် GitHub token ကို environment variable အဖြစ်သတ်မှတ်ပါ:
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. အက်ပလီကေးရှင်းကို run လုပ်ပါ:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

သင့် output သည် အောက်ပါအတိုင်းဖြစ်ရမည်:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### ဤဥပမာ Code ကိုနားလည်ခြင်း

ပထမဦးစွာ သင် run လုပ်မည့်အရာကိုနားလည်ပါ။ ဤဥပမာသည် OpenAI Java SDK ကိုအသုံးပြု၍ GitHub Models နှင့်ချိတ်ဆက်သည်:

**ဤ code ၏လုပ်ဆောင်မှုများ:**
- **GitHub Models** နှင့် သင့် personal access token ဖြင့်ချိတ်ဆက်သည်
- AI မော်ဒယ်သို့ "Say Hello World!" စာကို **ပို့သည်**
- AI ၏တုံ့ပြန်မှုကို **လက်ခံပြီး ပြသသည်**
- သင့် setup သည်မှန်ကန်စွာအလုပ်လုပ်နေကြောင်း **အတည်ပြုသည်**

**Key Dependency** (in `pom.xml`):
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

**ဂုဏ်ယူပါတယ်!** သင်အောင်မြင်စွာ:
- **GitHub Personal Access Token** ကို AI model access အတွက် လိုအပ်သောခွင့်ပြုချက်များဖြင့်ဖန်တီးပြီး
- **Java ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်** ကို Codespaces, dev containers, သို့မဟုတ် local installation ဖြင့်သတ်မှတ်ပြီး
- **GitHub Models** နှင့် OpenAI Java SDK ကိုအသုံးပြု၍ AI ဖွံ့ဖြိုးရေးအတွက် အခမဲ့ချိတ်ဆက်ပြီး
- **Integration ကိုစမ်းသပ်ပြီး** AI မော်ဒယ်များနှင့်ဆက်သွယ်သည့် အက်ပလီကေးရှင်းကိုအောင်မြင်စွာ run လုပ်နိုင်ခဲ့ပါသည်

## နောက်ထပ်အဆင့်များ

[Chapter 3: Core Generative AI Techniques](../03-CoreGenerativeAITechniques/README.md)

## ပြဿနာများကိုဖြေရှင်းခြင်း

ပြဿနာများရှိပါသလား? အောက်ပါအကြောင်းအရာများနှင့်ဖြေရှင်းနည်းများကိုကြည့်ပါ:

- **Token အလုပ်မလုပ်ပါသလား?**  
  - Token အားလုံးကို space မပါဘဲ copy လုပ်ထားကြောင်းသေချာပါ
  - Token ကို environment variable အဖြစ်မှန်ကန်စွာသတ်မှတ်ထားကြောင်းစစ်ဆေးပါ
  - Token ၏ခွင့်ပြုချက်များ (Models: Read and write) မှန်ကန်ကြောင်းစစ်ဆေးပါ

- **Maven မတွေ့ပါသလား?**  
  - Dev containers/Codespaces အသုံးပြုပါက Maven သည် ကြိုတင် install လုပ်ထားသည်
  - Local setup အတွက် Java 21+ နှင့် Maven 3.9+ install လုပ်ထားကြောင်းသေချာပါ
  - `mvn --version` ဖြင့် installation ကိုစစ်ဆေးပါ

- **Connection ပြဿနာများ?**  
  - သင့်အင်တာနက်ချိတ်ဆက်မှုကိုစစ်ဆေးပါ
  - GitHub သည် သင့် network မှရရှိနိုင်ကြောင်းစစ်ဆေးပါ
  - GitHub Models endpoint ကို block လုပ်ထားသော firewall မရှိကြောင်းသေချာပါ

- **Dev container မစတင်နိုင်ပါသလား?**  
  - Docker Desktop ကို run လုပ်ထားကြောင်းသေချာပါ (local development အတွက်)
  - Container ကိုပြန်လည် build လုပ်ပါ: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container"

- **Application compilation errors?**  
  - သင့် directory မှန်ကန်ကြောင်းသေချာပါ: `02-SetupDevEnvironment/src/github-models`
  - Clean နှင့် rebuild လုပ်ပါ: `mvn clean compile`

> **အကူအညီလိုပါသလား?**: ပြဿနာများရှိနေသေးပါက repository တွင် issue တစ်ခုဖွင့်ပြီး ကျွန်ုပ်တို့ထောက်ပံ့ပေးပါမည်။

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှန်ကန်မှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်ခြင်းတွင် အမှားများ သို့မဟုတ် မမှန်ကန်မှုများ ပါရှိနိုင်သည်ကို သတိပြုပါ။ မူရင်းစာရွက်စာတမ်းကို ၎င်း၏ မူလဘာသာစကားဖြင့် အာဏာတရားရှိသော အရင်းအမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များမှ ပရော်ဖက်ရှင်နယ် ဘာသာပြန်ခြင်းကို အကြံပြုပါသည်။ ဤဘာသာပြန်ကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအလွတ်များ သို့မဟုတ် အနားလွဲမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။