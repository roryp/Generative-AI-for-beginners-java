<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T21:20:03+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "my"
}
-->
# Foundry Local Command-Line Application

>**Note**: ဒီအခန်းမှာ [**Tutorial**](./TUTORIAL.md) ပါဝင်ပြီး အဆင့်မြင့်နမူနာများကို အကောင်အထည်ဖော်ရန် လမ်းညွှန်ပေးထားသည်။

Spring Boot command-line application တစ်ခုဖြစ်ပြီး OpenAI Java SDK ကို အသုံးပြု၍ Foundry Local ကို ချိတ်ဆက်ပုံကို ပြသထားသည်။

## သင်လေ့လာနိုင်မည့်အရာများ

- OpenAI Java SDK ကို အသုံးပြု၍ Foundry Local ကို Spring Boot application များနှင့် ပေါင်းစည်းပုံ
- ဒေသခံ AI ဖွံ့ဖြိုးရေးနှင့် စမ်းသပ်မှုအတွက် အကောင်းဆုံး လုပ်ဆောင်မှုများ

## အကြောင်းအရာများ

- [သင်လေ့လာနိုင်မည့်အရာများ](../../../../04-PracticalSamples/foundrylocal)
- [လိုအပ်ချက်များ](../../../../04-PracticalSamples/foundrylocal)
  - [Foundry Local ကို ထည့်သွင်းခြင်း](../../../../04-PracticalSamples/foundrylocal)
  - [အတည်ပြုခြင်း](../../../../04-PracticalSamples/foundrylocal)
- [ဖွဲ့စည်းမှု](../../../../04-PracticalSamples/foundrylocal)
- [အမြန်စတင်ခြင်း](../../../../04-PracticalSamples/foundrylocal)
- [Application ရဲ့ လုပ်ဆောင်မှု](../../../../04-PracticalSamples/foundrylocal)
- [နမူနာ Output](../../../../04-PracticalSamples/foundrylocal)
- [Architecture](../../../../04-PracticalSamples/foundrylocal)
- [Code အထူးအချက်များ](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI Java SDK Integration](../../../../04-PracticalSamples/foundrylocal)
  - [Chat Completion API](../../../../04-PracticalSamples/foundrylocal)
- [ပြဿနာဖြေရှင်းခြင်း](../../../../04-PracticalSamples/foundrylocal)

## လိုအပ်ချက်များ

> **⚠️ Note**: ဒီ application ဟာ **devcontainer ထဲမှာ မရနိုင်ပါ**၊ Foundry Local ကို host system မှာ ထည့်သွင်းပြီး run လိုအပ်ပါသည်။

### Foundry Local ကို ထည့်သွင်းခြင်း

ဒီ application ကို run မလုပ်မီ Foundry Local ကို ထည့်သွင်းပြီး စတင်ရန် လိုအပ်ပါသည်။ အောက်ပါအဆင့်များကို လိုက်နာပါ။

1. **သင့်စနစ်သည် လိုအပ်ချက်များကို ဖြည့်ဆည်းထားကြောင်း သေချာပါ**:
   - **Operating System**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, သို့မဟုတ် macOS
   - **Hardware**: 
     - အနည်းဆုံး: 8GB RAM, 3GB အခမဲ့ disk အာကာသ
     - အကြံပြုချက်: 16GB RAM, 15GB အခမဲ့ disk အာကာသ
   - **Network**: မော်ဒယ်ကို ပထမဆုံး download လုပ်ရန် အင်တာနက်ချိတ်ဆက်မှု (offline အသုံးပြုမှုအတွက် optional)
   - **Acceleration (optional)**: NVIDIA GPU (2,000 series သို့မဟုတ် အဆင့်မြင့်), AMD GPU (6,000 series သို့မဟုတ် အဆင့်မြင့်), Qualcomm Snapdragon X Elite (8GB သို့မဟုတ် အများကြီး memory), သို့မဟုတ် Apple silicon
   - **Permissions**: သင့် device မှာ software ထည့်သွင်းရန် အုပ်ချုပ်ရေးအခွင့်အရေး

2. **Foundry Local ကို ထည့်သွင်းပါ**:
   
   **Windows အတွက်**:
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **macOS အတွက်**:
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   အခြားနည်းလမ်းအဖြစ် [Foundry Local GitHub repository](https://github.com/microsoft/Foundry-Local) မှ installer ကို download လုပ်နိုင်ပါသည်။

3. **ပထမဆုံး မော်ဒယ်ကို စတင်ပါ**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   မော်ဒယ်ကို download လုပ်ရန် (သင့်အင်တာနက်အမြန်နှုန်းပေါ်မူတည်၍ မိနစ်အနည်းငယ်ကြာနိုင်သည်) ပြီးနောက် run လုပ်ပါမည်။ Foundry Local သည် သင့်စနစ်အတွက် အကောင်းဆုံး မော်ဒယ် variant ကို အလိုအလျောက် ရွေးချယ်ပေးပါသည် (NVIDIA GPU များအတွက် CUDA, CPU version အခြား).

4. **မော်ဒယ်ကို စမ်းသပ်ပါ**၊ terminal ထဲမှာ မေးခွန်းတစ်ခုမေးပါ:

   ```bash
   Why is the sky blue?
   ```

   မိုးကောင်းကင်အပြာရောင်ဖြစ်ရခြင်းအကြောင်းကို Phi မော်ဒယ်မှ ရှင်းပြထားသော အဖြေကို တွေ့ရပါမည်။

### အတည်ပြုခြင်း

အောက်ပါ command များဖြင့် အားလုံးအလုပ်လုပ်နေကြောင်း အတည်ပြုနိုင်ပါသည်:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

သို့မဟုတ် `http://localhost:5273` ကို browser မှာ သွားရောက်ကြည့်ရှုနိုင်ပါသည်။

## ဖွဲ့စည်းမှု

application ကို `application.properties` မှာ ဖွဲ့စည်းနိုင်ပါသည်:

- `foundry.local.base-url` - Foundry Local အတွက် Base URL (default: http://localhost:5273)
- `foundry.local.model` - အသုံးပြုမည့် AI မော်ဒယ် (default: Phi-3.5-mini-instruct-cuda-gpu)

> **Note**: configuration ထဲမှာ မော်ဒယ်နာမည်သည် Foundry Local သင့်စနစ်အတွက် download လုပ်ထားသော မော်ဒယ် variant နှင့် ကိုက်ညီရမည်။ `foundry model run phi-3.5-mini` ကို run လုပ်သောအခါ Foundry Local သည် အကောင်းဆုံး variant ကို အလိုအလျောက် ရွေးချယ်ပြီး download လုပ်ပါသည် (NVIDIA GPU များအတွက် CUDA, CPU version အခြား). `foundry model list` ကို run လုပ်၍ သင့် local instance မှာ ရရှိနိုင်သော မော်ဒယ်နာမည်ကို ကြည့်ရှုနိုင်ပါသည်။

## အမြန်စတင်ခြင်း

### 1. Foundry Local application directory သို့ သွားပါ
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Application ကို run လုပ်ပါ

```bash
mvn spring-boot:run
```

သို့မဟုတ် JAR ကို build လုပ်ပြီး run လုပ်ပါ:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Dependencies

ဒီ application သည် Foundry Local နှင့် ဆက်သွယ်ရန် OpenAI Java SDK ကို အသုံးပြုပါသည်။ အဓိက dependency သည်:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

application သည် default port မှာ run လုပ်နေသော Foundry Local ကို ချိတ်ဆက်ရန် ကြိုတင်ဖွဲ့စည်းထားပါသည်။

## Application ရဲ့ လုပ်ဆောင်မှု

application ကို run လုပ်သောအခါ:

1. **Command-line application အနေဖြင့် စတင်သည်** (web server မပါ)
2. **Test message တစ်ခုကို အလိုအလျောက် ပို့သည်**: "Hello! Can you tell me what you are and what model you're running?"
3. **Foundry Local မှ response ကို console မှာ ပြသည်**
4. **Demo ပြီးဆုံးပြီးနောက် သန့်ရှင်းစွာ ပိတ်သည်**

## နမူနာ Output

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Architecture

- **Application.java** - CommandLineRunner ပါဝင်သော Main Spring Boot application
- **FoundryLocalService.java** - OpenAI Java SDK ကို အသုံးပြု၍ Foundry Local နှင့် ဆက်သွယ်သော Service
- **OpenAI Java SDK** ကို အသုံးပြု၍ type-safe API call များ
- JSON serialization/deserialization ကို SDK မှ အလိုအလျောက် စီမံသည်
- Spring ရဲ့ `@Value` နှင့် `@PostConstruct` annotation များကို အသုံးပြု၍ သန့်ရှင်းသော configuration

## Code အထူးအချက်များ

### OpenAI Java SDK Integration

application သည် Foundry Local အတွက် client တစ်ခုကို ဖန်တီးရန် OpenAI Java SDK ကို အသုံးပြုသည်:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### Chat Completion API

Chat completion request များကို လွယ်ကူပြီး type-safe ဖြစ်စေသည်:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## ပြဿနာဖြေရှင်းခြင်း

Connection error တွေ့ရပါက:
1. Foundry Local သည် `http://localhost:5273` မှာ run လုပ်နေကြောင်း အတည်ပြုပါ
2. `foundry model list` ကို run လုပ်၍ Phi-3.5-mini မော်ဒယ် variant ရရှိနိုင်ကြောင်း စစ်ဆေးပါ
3. `application.properties` ထဲမှာ မော်ဒယ်နာမည်သည် list မှာ ပြထားသော မော်ဒယ်နာမည်နှင့် ကိုက်ညီကြောင်း သေချာပါ
4. Firewall သည် connection ကို ပိတ်ထားခြင်းမရှိကြောင်း စစ်ဆေးပါ

အများဆုံးတွေ့ရသော ပြဿနာများ:
- **မော်ဒယ်မတွေ့ရှိ**: `foundry model run phi-3.5-mini` ကို run လုပ်၍ မော်ဒယ်ကို download လုပ်ပြီး စတင်ပါ
- **Service မ run လုပ်နေ**: Foundry Local service သည် ရပ်ထားနိုင်သည်; မော်ဒယ် run command ဖြင့် ပြန်စတင်ပါ
- **မော်ဒယ်နာမည်မှား**: `foundry model list` ကို run လုပ်၍ ရရှိနိုင်သော မော်ဒယ်များကို ကြည့်ရှုပြီး configuration ကို update လုပ်ပါ

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်မှုများတွင် အမှားများ သို့မဟုတ် မတိကျမှုများ ပါဝင်နိုင်သည်ကို သတိပြုပါ။ မူရင်းစာရွက်စာတမ်းကို ၎င်း၏ မူရင်းဘာသာစကားဖြင့် အာဏာတရ အရင်းအမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များမှ ပရော်ဖက်ရှင်နယ် ဘာသာပြန်မှုကို အကြံပြုပါသည်။ ဤဘာသာပြန်မှုကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအလွတ်များ သို့မဟုတ် အနားလွဲမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။