<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d064108b2142d32246ccbd8a42e76b4d",
  "translation_date": "2025-07-25T10:16:53+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "my"
}
-->
# Foundry Local Command-Line Application

>**မှတ်ချက်**: ဒီအခန်းမှာ သင်ကိုနမူနာများဖြင့် လမ်းညွှန်ပေးမည့် [**လက်တွေ့လေ့ကျင့်မှု**](./TUTORIAL.md) ပါဝင်ပါတယ်။

Spring Boot ကိုအခြေခံထားသော ရိုးရှင်းတဲ့ command-line application တစ်ခုဖြစ်ပြီး OpenAI Java SDK ကို အသုံးပြု၍ Foundry Local နှင့် ချိတ်ဆက်ပုံကို ပြသထားပါတယ်။

## သင်လေ့လာနိုင်မည့်အရာများ

- OpenAI Java SDK ကို အသုံးပြု၍ Foundry Local ကို Spring Boot application များနှင့် ပေါင်းစည်းပုံ
- ဒေသတွင်း AI ဖွံ့ဖြိုးမှုနှင့် စမ်းသပ်မှုအတွက် အကောင်းဆုံး လုပ်ထုံးလုပ်နည်းများ

## အကြောင်းအရာများ

- [သင်လေ့လာနိုင်မည့်အရာများ](../../../../04-PracticalSamples/foundrylocal)
- [လိုအပ်ချက်များ](../../../../04-PracticalSamples/foundrylocal)
  - [Foundry Local ကို ထည့်သွင်းခြင်း](../../../../04-PracticalSamples/foundrylocal)
  - [အတည်ပြုခြင်း](../../../../04-PracticalSamples/foundrylocal)
- [ဖွဲ့စည်းမှု](../../../../04-PracticalSamples/foundrylocal)
- [အမြန်စတင်ရန်](../../../../04-PracticalSamples/foundrylocal)
- [Application ၏ လုပ်ဆောင်မှု](../../../../04-PracticalSamples/foundrylocal)
- [နမူနာ အထွက်](../../../../04-PracticalSamples/foundrylocal)
- [Architecture](../../../../04-PracticalSamples/foundrylocal)
- [Code အထူးအချက်များ](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI Java SDK ပေါင်းစည်းမှု](../../../../04-PracticalSamples/foundrylocal)
  - [Chat Completion API](../../../../04-PracticalSamples/foundrylocal)
- [ပြဿနာရှာဖွေမှု](../../../../04-PracticalSamples/foundrylocal)

## လိုအပ်ချက်များ

> **⚠️ မှတ်ချက်**: ဒီ application သည် **ပေးထားသော devcontainer တွင် မရောနှောနိုင်ပါ**၊ Foundry Local ကို host system တွင် ထည့်သွင်းပြီး လည်ပတ်နေဖို့ လိုအပ်ပါတယ်။

### Foundry Local ကို ထည့်သွင်းခြင်း

ဒီ application ကို လည်ပတ်မည်မပြုမီ Foundry Local ကို ထည့်သွင်းပြီး စတင်ရန် လိုအပ်ပါတယ်။ အောက်ပါအဆင့်များကို လိုက်နာပါ-

1. **သင့်စနစ်သည် လိုအပ်ချက်များနှင့် ကိုက်ညီကြောင်း သေချာပါ**:
   - **Operating System**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, သို့မဟုတ် macOS
   - **Hardware**: 
     - အနည်းဆုံး: 8GB RAM, 3GB အခမဲ့ disk အာကာသ
     - အကြံပြု: 16GB RAM, 15GB အခမဲ့ disk အာကာသ
   - **Network**: မော်ဒယ်ကို ပထမဆုံးဒေါင်းလုပ်ဆွဲရန် အင်တာနက် ချိတ်ဆက်မှု (အော့ဖ်လိုင်းအသုံးပြုမှုအတွက် မလိုအပ်ပါ)
   - **Acceleration (ရွေးချယ်နိုင်သည်)**: NVIDIA GPU (2,000 စီးရီး သို့မဟုတ် အသစ်များ), AMD GPU (6,000 စီးရီး သို့မဟုတ် အသစ်များ), Qualcomm Snapdragon X Elite (8GB သို့မဟုတ် ပိုမိုသော memory), သို့မဟုတ် Apple silicon
   - **Permissions**: သင့်စက်တွင် software ထည့်သွင်းရန် အုပ်ချုပ်ရေးအခွင့်အရေး

2. **Foundry Local ကို ထည့်သွင်းပါ**:
   
   **Windows အတွက်:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **macOS အတွက်:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   အခြားနည်းလမ်းအဖြစ် [Foundry Local GitHub repository](https://github.com/microsoft/Foundry-Local) မှ installer ကို ဒေါင်းလုပ်ဆွဲနိုင်ပါသည်။

3. **ပထမဆုံး မော်ဒယ်ကို စတင်ပါ**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   မော်ဒယ်ကို ဒေါင်းလုပ်ဆွဲရန် (သင့်အင်တာနက်အမြန်နှုန်းပေါ်မူတည်၍ မိနစ်အနည်းငယ်ကြာနိုင်သည်) ပြီးနောက် လည်ပတ်ပါမည်။ Foundry Local သည် သင့်စနစ်အတွက် အကောင်းဆုံး မော်ဒယ်ကို အလိုအလျောက် ရွေးချယ်ပေးပါသည် (NVIDIA GPU များအတွက် CUDA, CPU ဗားရှင်း များအတွက် အခြား).

4. **Terminal တွင် မေးခွန်းတစ်ခု မေးပြီး မော်ဒယ်ကို စမ်းသပ်ပါ**:

   ```bash
   Why is the sky blue?
   ```

   မိုးကောင်းကင်အပြာရောင်ဖြစ်ရခြင်းအကြောင်း ရှင်းပြသည့် Phi မော်ဒယ်၏ တုံ့ပြန်မှုကို တွေ့ရမည်။

### အတည်ပြုခြင်း

အောက်ပါ command များဖြင့် အားလုံးမှန်ကန်ကြောင်း အတည်ပြုနိုင်ပါသည်:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

သို့မဟုတ် `http://localhost:5273` ကို browser တွင် ဝင်ရောက်ကြည့်ရှုနိုင်ပါသည်။

## ဖွဲ့စည်းမှု

ဒီ application ကို `application.properties` မှတစ်ဆင့် ဖွဲ့စည်းနိုင်ပါသည်-

- `foundry.local.base-url` - Foundry Local ၏ Base URL (ပုံမှန်: http://localhost:5273)
- `foundry.local.model` - အသုံးပြုမည့် AI မော်ဒယ် (ပုံမှန်: Phi-3.5-mini-instruct-cuda-gpu)

> **မှတ်ချက်**: ဖွဲ့စည်းမှုအတွင်း မော်ဒယ်အမည်သည် Foundry Local မှ ဒေါင်းလုပ်ဆွဲထားသော မော်ဒယ်၏ အတိအကျဗားရှင်းနှင့် ကိုက်ညီရမည်။ `foundry model run phi-3.5-mini` ကို လည်ပတ်စဉ် Foundry Local သည် သင့်စနစ်အတွက် အကောင်းဆုံးဗားရှင်းကို အလိုအလျောက် ရွေးချယ်ပြီး ဒေါင်းလုပ်ဆွဲပါသည်။ `foundry model list` ကို အသုံးပြု၍ သင့်ဒေသတွင်း instance တွင် ရရှိနိုင်သော မော်ဒယ်အမည်ကို ကြည့်ရှုနိုင်ပါသည်။

## အမြန်စတင်ရန်

### 1. Foundry Local application directory သို့ သွားပါ
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Application ကို လည်ပတ်ပါ

```bash
mvn spring-boot:run
```

သို့မဟုတ် JAR ကို build လုပ်ပြီး လည်ပတ်ပါ:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Dependencies

ဒီ application သည် Foundry Local နှင့် ဆက်သွယ်ရန် OpenAI Java SDK ကို အသုံးပြုပါသည်။ အဓိကလိုအပ်ချက်မှာ-

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

application သည် ပုံမှန် port တွင် လည်ပတ်နေသော Foundry Local နှင့် ချိတ်ဆက်ရန် ကြိုတင်ဖွဲ့စည်းထားပါသည်။

## Application ၏ လုပ်ဆောင်မှု

Application ကို လည်ပတ်စဉ်-

1. **Command-line application** အနေဖြင့် စတင်ပါသည် (web server မပါဝင်ပါ)
2. **စမ်းသပ်မက်ဆေ့ချ်တစ်ခု** ကို အလိုအလျောက် ပို့ပါသည်- "Hello! Can you tell me what you are and what model you're running?"
3. **Foundry Local ၏ တုံ့ပြန်မှု** ကို console တွင် ပြသပါသည်
4. **Demo ပြီးဆုံးပြီးနောက်** သန့်ရှင်းစွာ ပိတ်ပါသည်

## နမူနာ အထွက်

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Architecture

- **Application.java** - CommandLineRunner ဖြင့် Main Spring Boot application
- **FoundryLocalService.java** - OpenAI Java SDK ကို အသုံးပြု၍ Foundry Local နှင့် ဆက်သွယ်သည့် Service
- **OpenAI Java SDK** ကို အသုံးပြု၍ type-safe API ခေါ်ဆိုမှုများ
- JSON serialization/deserialization ကို SDK မှ အလိုအလျောက် စီမံဆောင်ရွက်
- Spring ၏ `@Value` နှင့် `@PostConstruct` annotation များကို အသုံးပြု၍ သန့်ရှင်းသော ဖွဲ့စည်းမှု

## Code အထူးအချက်များ

### OpenAI Java SDK ပေါင်းစည်းမှု

ဒီ application သည် Foundry Local အတွက် ဖွဲ့စည်းထားသော client တစ်ခုကို OpenAI Java SDK ဖြင့် ဖန်တီးသည်-

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

Chat completion request များကို ရိုးရှင်းပြီး type-safe ဖြစ်စေသည်-

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## ပြဿနာရှာဖွေမှု

Connection error များကို တွေ့ပါက:
1. Foundry Local သည် `http://localhost:5273` တွင် လည်ပတ်နေကြောင်း အတည်ပြုပါ
2. `foundry model list` ဖြင့် Phi-3.5-mini မော်ဒယ်ဗားရှင်း ရရှိနိုင်ကြောင်း စစ်ဆေးပါ
3. `application.properties` တွင် မော်ဒယ်အမည်သည် မော်ဒယ်စာရင်းတွင် ပြသထားသော အတိအကျအမည်နှင့် ကိုက်ညီကြောင်း သေချာပါ
4. Firewall တစ်ခုခုက ချိတ်ဆက်မှုကို တားဆီးထားခြင်း မရှိကြောင်း စစ်ဆေးပါ

အများဆုံးတွေ့ရသော ပြဿနာများ:
- **မော်ဒယ်မတွေ့ရှိခြင်း**: `foundry model run phi-3.5-mini` ကို လည်ပတ်၍ မော်ဒယ်ကို ဒေါင်းလုပ်ဆွဲပြီး စတင်ပါ
- **ဝန်ဆောင်မှုမလည်ပတ်ခြင်း**: Foundry Local ဝန်ဆောင်မှု ရပ်နားထားနိုင်သည်; မော်ဒယ် run command ဖြင့် ပြန်လည်စတင်ပါ
- **မော်ဒယ်အမည်မှားခြင်း**: `foundry model list` ကို အသုံးပြု၍ ရရှိနိုင်သော မော်ဒယ်များကို ကြည့်ရှုပြီး သင့်ဖွဲ့စည်းမှုကို အပ်ဒိတ်လုပ်ပါ

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်မှုများတွင် အမှားများ သို့မဟုတ် မမှန်ကန်မှုများ ပါဝင်နိုင်သည်ကို သတိပြုပါ။ မူရင်းစာရွက်စာတမ်းကို ၎င်း၏ မူရင်းဘာသာစကားဖြင့် အာဏာတရားရှိသော အရင်းအမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူက ဘာသာပြန်မှုကို အသုံးပြုရန် အကြံပြုပါသည်။ ဤဘာသာပြန်မှုကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအလွဲအချော်များ သို့မဟုတ် အနားယူမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။