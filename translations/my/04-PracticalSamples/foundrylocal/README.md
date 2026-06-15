# Foundry Local Spring Boot သင်ခန်းစာ

## အကြောင်းအရာအရင်းအမြစ်များ

- [လိုအပ်ချက်များ](#လိုအပ်ချက်များ)
- [ပရောဂျက်အနှစ်ချုပ်](#ပရောဂျက်-အနှစ်ချုပ်)
- [ကုဒ်ကိုနားလည်ခြင်း](#ကုဒ်ကို-နားလည်ခြင်း)
  - [1. အက်ပလီကေးရှင်း ဖန်တီးခြင်း (application.properties)](#1-အက်ပလီကေးရှင်း-ဖန်တီးခြင်း-applicationproperties)
  - [2. အဓိက အက်ပလီကေးရှင်း ကလပ် (Application.java)](#2-အဓိက-အက်ပလီကေးရှင်း-ကလပ်-applicationjava)
  - [3. AI ဝန်ဆောင်မှု အလွှာ (FoundryLocalService.java)](#3-ai-ဝန်ဆောင်မှု-အလွှာ-foundrylocalservicejava)
  - [4. ပရောဂျက် တံဆိပ်များ (pom.xml)](#4-ပရောဂျက်-တံဆိပ်များ-pomxml)
- [ဘာတွေကို ဘယ်လိုပေါင်းစပ်လုပ်ဆောင်ရလဲ](#ဘာတွေကို-ဘယ်လိုပေါင်းစပ်လုပ်ဆောင်ရလဲ)
- [Foundry Local ကို စတင်တပ်ဆင်ခြင်း](#foundry-local-ကို-စတင်တပ်ဆင်ခြင်း)
- [အက်ပလီကေးရှင်း ကို ဖွင့်ခြင်း](#အက်ပလီကေးရှင်း-ကို-ဖွင့်ခြင်း)
- [မျှော်လင့်ထားသော ထွက်ရှိမှု](#မျှော်လင့်ထားသော-ထွက်ရှိမှု)
- [နောက်တစ်ဆင့်များ](#နောက်တစ်ဆင့်များ)
- [ပြဿနာဖြေရှင်းခြင်း](#ပြဿနာဖြေရှင်းခြင်း)


## လိုအပ်ချက်များ

ဤသင်ခန်းစာကို စတင်ခွင့်မပြုမီ သေချာပိုင်ဆိုင်ထားရမည့်ကိစ္စများမှာ-

- **Java 21 သို့မဟုတ် အထက်** ကို စနစ်တွင် ထည့်သွင်းထားခြင်း
- **Maven 3.6+** ကို ပရောဂျက် ဖန်တီးရန် အသုံးပြုခြင်း
- **Foundry Local** ကို ထည့်သွင်းပြီး အလုပ်လုပ်နေခြင်း

### **Foundry Local ထည့်သွင်းခြင်း:**

> **မှတ်ချက်:** Foundry Local CLI ကို **Windows** နှင့် **macOS** တွင်သာ အသုံးပြုနိုင်သည်။ Linux သည် [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust) မှတဆင့် ထောက်ပံ့သည်။

```bash
# Windows (ဝင်းဒိုး)
winget install Microsoft.FoundryLocal

# macOS (မက်အိုအက်စ်)
brew tap microsoft/foundrylocal
brew install foundrylocal
```

ထည့်သွင်းမှုကို စစ်ဆေးပါ-
```bash
foundry --version
```

## ပရောဂျက် အနှစ်ချုပ်

ဤပရောဂျက်တွင် အဓိက အစိတ်အပိုင်းလေးခု ပါဝင်သည်-

1. **Application.java** - အဓိက Spring Boot အက်ပလီကေးရှင်း ဝင်ကြေး
2. **FoundryLocalService.java** - AI ဆက်သွယ်မှု ကို ကိုင်တွယ်သည့် ဝန်ဆောင်မှုအလွှာ
3. **application.properties** - Foundry Local ဆက်သွယ်မှု ဖန်တီးရန် ကွန်ဖစ်ဂျာရေးရှင်း
4. **pom.xml** - Maven တံဆိပ်များနှင့် ပရောဂျက် ဖန်တီးမှု

## ကုဒ်ကို နားလည်ခြင်း

### 1. အက်ပလီကေးရှင်း ဖန်တီးခြင်း (application.properties)

**ဖိုင်:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**ဤသည်က ဆောင်ရွက်သည့်အရာ-**
- **base-url**: Foundry Local အလုပ်လုပ်နေရာကို ဖော်ပြသည်၊ OpenAI API ကို လိုက်လံစပ်ဆက်နိုင်ရန် `/v1` လမ်းကြောင်းပါရှိသည်။ပုံမှန်ပေါ့(Port) သည် `5273` ဖြစ်သည်။ ပေါ့အခြားမဆိုရင် `foundry service status` ဖြင့် စစ်ဆေးပါ။
- **model** (စိတ်ကြိုက်): စာသားထုတ်လုပ်ရန် အသုံးပြုမည့် AI မော်ဒယ် အမည် ဖြစ်သည်။ **ပုံမှန်အားဖြင့် အက်ပလီကေးရှင်း သည် Foundry Local မှ `/v1/models` endpoint ကို စတင်သုံးစွဲချိန်မှာ မော်ဒယ်ကို အလိုအလျောက် ရှာဖွေရန်ကြိုးစားသည်၊ ထို့ကြောင့် သင့်အနေဖြင့် သတ်မှတ်ရန် မလိုအပ်ပါ။ အသုံးပြုလိုပါက သတ်မှတ်တိုင်းထည့်နိုင်ပါသည်။**

**အဓိက အတွင်းရေးအယူအဆ:** Spring Boot သည် ဤ properties များကို အလိုအလျောက်ထည့်သွင်းပြီး `@Value` annotation အားဖြင့် အသုံးပြုနိုင်ရန် ပြင်ဆင်ပေးသည်။

### 2. အဓိက အက်ပလီကေးရှင်း ကလပ် (Application.java)

**ဖိုင်:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // ဝဘ်ဆာဗာမလိုအပ်ပါ။
        app.run(args);
    }
```

**ဤသို့ ဆောင်ရွက်သည်-**
- `@SpringBootApplication` သည် Spring Boot အလိုအလျောက် ဆက်တင်ဖွင့်ခြင်းကို ခွင့်ပြုသည်
- `WebApplicationType.NONE` သည် ဤအက်ပလီကေးရှင်းသည် command-line အမျိုးအစားဖြစ်ပြီး ဝဘ်ဆိုက် အမျိုးအစားမဟုတ်ကြောင်း ဖော်ပြသည်
- main method သည် Spring အက်ပလီကေးရှင်းကို စတင်ပြေးဆွဲသည်

**Demo Runner အကြောင်း:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        System.out.println("Calling Foundry Local service...");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
        System.out.println("=========================");
    };
}
```

**ဤသည်သည်-**
- `@Bean` သည် Spring အင်အားဖြင့် စီမံခန့်ခွဲမည့် အစိတ်အပိုင်းတခု ဖန်တီးသည်
- `CommandLineRunner` သည် Spring Boot စပြီးချိန်တွင် ကုဒ်အချို့ကို အသုံးပြုရန် လည်ပတ်ခြင်း
- `foundryLocalService` ကို Spring မှ အလိုအလျှောက် ထည့်သွင်းပေးသည် (dependency injection)
- AI သို့ စမ်းသပ်စာတမ်းပို့ပြီး တုံ့ပြန်ချက်ကို ပြသည်

### 3. AI ဝန်ဆောင်မှု အလွှာ (FoundryLocalService.java)

**ဖိုင်:** `src/main/java/com/example/FoundryLocalService.java`

#### ဖန်တီးမှု ထည့်သွင်းခြင်း:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // ဖန်တီးထားသော အလုပ်မရှိပါက အလိုအလျောက် သိရှိသည်
```

**ဤသည်သည်-**
- `@Service` သည် ဤကလပ်ကို Spring တွင် စီးပွားရေး လုပ်ဆောင်ချက် ထုတ်ပေးသူအဖြစ် ဖော်ပြသည်
- `@Value` သည် application.properties မှ ကွန်ဖစ်ဂျာချက် တန်ဖိုးများ ထည့်သွင်းပေးသည်
- မော်ဒယ်ကို ဧရိယာအဖြစ် '' (ထောင့်စွန်း) ချထားခြင်းဖြင့် Foundry Local မှ အသင့်မရိုက်သည့် မော်ဒယ်ကို စတင်အသုံးပြုချိန်တွင် အလိုအလျောက် တွေ့ရှိပေးရန် ဖွင့်ထားသည်။ ထို့ကြောင့် မည်သည့် မော်ဒယ်မဆို Foundry Local တွင် တင်ထားပါက လက်လျှော်နဲ့ အလုပ်လုပ်နိုင်သည်။

#### Client စတင်ဖန်တီးခြင်း:
```java
@PostConstruct
public void init() {
    // ပုံသေမျဉ်းကို သတ်မှတ်ထားသောကိရိယာမရှိလျှင် Foundry Local မှ အလိုအလျောက် တွေ့ရှိပါသည်
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // အခြေခံ URL တွင် ဦးစွာ /v1 ကို ဖြည့်သွင်းထားပြီးဖြစ်သည်
            .apiKey("not-needed")            // ဒေသခံဆာဗာတွင် အမှန်တကယ် API key မလိုအပ်ပါ။
            .build();
}
```

**အကျိုးသက်ရောက်မှု:**
- `@PostConstruct` သည် Spring သည် ဝန်ဆောင်မှုကို ဖန်တီးပြီးနောက် ဒီ method ကို ခေါ်သုံးသည်
- မော်ဒယ် မသတ်မှတ်ထားပါက Foundry Local ၏ `/v1/models` endpoint သို့ မေးမြန်းပြီး ပထမဆုံး အမှတ်တံဆိပ်ရှိ မော်ဒယ်ကို ရွေးချယ်သည်
- OpenAI client ကို သင့် Foundry Local အင်စတန်စ်အား ဦးတည် ဖန်တီးသည်
- application.properties ၏ base URL တွင် ကြုံတွေ့ရသော `/v1` ပါရှိခြင်းကြောင့် OpenAI API နှင့် ကိုက်ညီမှု ရှိနေသည်
- လုပ်ငန်းတိုးတက်မှုအတွက် API key ကို "not-needed" ဟု သတ်မှတ်ထားသည်၊ ဒါကတော့ ဒေသတွင်း ဖွံ့ဖြိုးမှုအတွက် မှတ်ပုံတင်မလိုအပ်ခြင်း ဖြစ်သည်

#### စကားဝိုင်းနည်းလမ်း:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // အသုံးပြုမည့် AI မော်ဒယ်
                .addUserMessage(message)         // သင်၏မေးခွန်း/တုံ့ပြန်ချက်
                .maxCompletionTokens(150)        // တုံ့ပြန်ချက်အရှည်ကို ကန့်သတ်ပါ
                .temperature(0.7)                // ဖန်တီးမှုလွယ်ကူမှုကို ထိန်းချုပ်ပါ (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // API များ၏ရလဒ်မှ AI ၏တုံ့ပြန်ချက်ကို ထုတ်ယူပါ
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**ဤဆောင်ရွက်ချက်များ-**
- **ChatCompletionCreateParams**: AI တောင်းဆိုမှု အတွက် ကွန်ဖစ်ဂျာရေးရှင်း
  - `model`: ဘယ် AI မော်ဒယ်ကို အသုံးပြုမည်ကို သတ်မှတ်သည် (foundry model list မှ တိတိကျကျ မော်ဒယ် ID နှင့်ကိုက်ညီရမည်)
  - `addUserMessage`: သင့် စကားကို စကားဝိုင်းထဲ ထည့်သွင်းသည်
  - `maxCompletionTokens`: တုံ့ပြန်ချက်မှာ အသုံးပြုနိုင်သည့် အတွေ့အကြုံ ကန့်သတ်ချက် (အရင်းအမြစ် စွမ်းဆောင်ချက် ထိန်းသိမ်းခြင်း)
  - `temperature`: ကိစ္စများမှ တုံ့ပြန်မှု ခြားနားမှု ကို ထိန်းချုပ်သည် (0.0 = တိကျသေချာ, 1.0 = ဖန်တီးမှု)
- **API ခေါ်ယူမှု**: Foundry Local သို့ တောင်းဆိုမှု ပေးပို့သည်
- **တုံ့ပြန်မှု ကိုင်တွယ်မှု**: AI ၏ စာသား တုံ့ပြန်ချက်ကို လုံခြုံစိတ်ချစွာ ရယူသည်
- **အမှား ကိုင်တွယ်မှု**: အမှားများ ဖြစ်ပေါ်ပါက ရှင်းလင်းသော အမှားစာတမ်းဖြင့် ချုပ်ဆိုသည်

### 4. ပရောဂျက် တံဆိပ်များ (pom.xml)

**အဓိက တံဆိပ်များ:**

```xml
<!-- Spring Boot - Application framework -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>${spring-boot.version}</version>
</dependency>

<!-- OpenAI Java SDK - For AI API calls -->
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>

<!-- Jackson - JSON processing -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.0</version>
</dependency>
```

**ဤတံဆိပ်များ၏ လုပ်ဆောင်ချက်-**
- **spring-boot-starter**: Spring Boot ၏ အခြေခံ လုပ်ဆောင်ချက်ပေးခြင်း
- **openai-java**: API ဆက်သွယ်မှုအတွက် ပုံမှန် OpenAI Java SDK
- **jackson-databind**: API ကနေ JSON သိုလှောင်မှုနှင့် ဖြန့်ဝေမှု ကိုင်တွယ်ပေးခြင်း

## ဘာတွေကို ဘယ်လိုပေါင်းစပ်လုပ်ဆောင်ရလဲ

အက်ပလီကေးရှင်းကို အလုပ်ဖြစ်စဉ်လုံးဝ သေချာ လိုက်နာမှု-

1. **စတင်ခြင်း**: Spring Boot သည် application.properties ကို ဖတ်ရှုသည်
2. **ဝန်ဆောင်မှု ဖန်တီးမှု**: Spring သည် FoundryLocalService ကို ဖန်တီးပြီး ကွန်ဖစ်ဂျာတို့ ထည့်သွင်းသည်
3. **မော်ဒယ် ရှာဖွေရေး**: မော်ဒယ် သတ်မှတ်မထားပါက Foundry Local ၏ `/v1/models` endpoint မှ ပထမဆုံး မော်ဒယ်ကို အလိုအလျောက် ရွေးချယ်သည်
4. **Client စတင်ခြင်း**: `@PostConstruct` သည် OpenAI client ကို Foundry Local နေရာသို့ ချိတ်ဆက်ရန် စတင်သည်
5. **Demo လုပ်ဆောင်ချက်**: `CommandLineRunner` သည် စတင်ပြီးနောက် ပြေးဆွဲသည်
6. **AI ခေါ်ဆိုခြင်း**: သင့် demo တွင် foundryLocalService.chat() ဖြင့် စမ်းသပ်စာတမ်း ပို့သည်
7. **API တောင်းဆိုခြင်း**: ဝန်ဆောင်မှုသည် OpenAI အတိုင်းစာမျက်နှာဖြင့် Foundry Local သို့ တောင်းဆိုသည်
8. **တုံ့ပြန်မှု ကိုင်တွယ်ခြင်း**: ဝန်ဆောင်မှုသည် AI တုံ့ပြန်မှုကို ကောက်ယူသည်
9. **ပြသခြင်း**: အက်ပလီကေးရှရှင်း သည် တုံ့ပြန်ချက်ကို မျက်နှာပြင်တွင် ပုံနှိပ် ပြီး ထွက်ခွာသည်

## Foundry Local ကို စတင်တပ်ဆင်ခြင်း

1. [လိုအပ်ချက်များ](#လိုအပ်ချက်များ) အပိုင်းအတိုင်း Foundry Local ကို ထည့်သွင်းပါ။

2. ဝန်ဆောင်မှုကို စတင်ပါ (အလုပ်မဖြစ်မှု ရှိပါက):
   ```bash
   foundry service start
   ```

3. ဝန်ဆောင်မှု အခြေအနေကို စစ်ဆေးပြီး ပေါ့ကို မှတ်သားပါ:
   ```bash
   foundry service status
   ```

4. မော်ဒယ်ကို ဒေါင်းလုပ်လုပ်ပြီး အလုပ်လုပ်ချိန် (ပထမဆုံး အလုပ်ခွင့်မှာ ဒေါင်းလုပ်ကျရောက်မည်၊ နောက်တစ်ကြိမ်များအတွက် cache ထားမည်):
   ```bash
   foundry model run phi-4-mini
   ```
   ဤသည်သည် အပြန် အလှန် စကားဝိုင်း အစည်းအဝေး ပြုလုပ်ပါမည်။ ထွက်ရန် `Ctrl+C` နည်းဖြင့် ထွက်နိုင်သည်။ မော်ဒယ်သည် ဝန်ဆောင်မှုတွင် တင်ထားနေပါသည်။

   > **အကြံပြုချက်:** `foundry model list` ကို ချိတ်ဆက်ရင် မော်ဒယ်အားလုံးကို ကြည့်ရှုနိုင်သည်။ `phi-4-mini` ကို မလိုအပ်သော အစားထိုးအသုံးပြုနိုင်သည် (ဥပမာ၊ အသေး/အမြန်မော်ဒယ်များအတွက် `qwen2.5-0.5b`)

5. မော်ဒယ်တင်ထားမှု စစ်ဆေးရန်:
   ```bash
   foundry service ps
   ```

6. လိုအပ်ပါက `application.properties` ကို အပ်ဒိတ်လုပ်ပါ-
   - ပုံမှန် `base-url` (`http://localhost:5273/v1`) သည် ပုံမှန် CLI ပေါ့နှင့် ကိုက်ညီသည်။ `foundry service status` မှာ အခြားပေါ့နိုင်လျှင် သာလွန်လုပ်ရန်သာ။
   - မော်ဒယ်သည် စတင်ခြင်းအတွက် **အလိုအလျောက် ရှာဖွေရေးဖြစ်သည်** — ကိုယ်တိုင် သတ်မှတ်စရာ မလိုပါ။

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## အက်ပလီကေးရှင်း ကို ဖွင့်ခြင်း

### အဆင့် 1: Foundry Local တွင် မော်ဒယ် တင်ထားပြီးကြောင်း သေချာပါစေ
```bash
foundry service ps
```
မော်ဒယ် မတွေ့ရင် တင်ပါ-
```bash
foundry model run phi-4-mini
```

### အဆင့် 2: အက်ပလီကေးရှင်း ကို တည်ဆောက်ပြီး ပြေးဆွဲခြင်း
အခြား terminal တစ်ခုမှ-
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

သို့မဟုတ် JAR အဖြစ် တည်ဆောက်ပြီး ပြေးပါ-
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## မျှော်လင့်ထားသော ထွက်ရှိမှု

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## နောက်တစ်ဆင့်များ

ပိုပြီး ဥပမာများအတွက် [အခန်း 04: လက်တွေ့နမူနာများ](../README.md) ကို ကြည့်ပါ။

## ပြဿနာဖြေရှင်းခြင်း

### ရိုးရိုးရှင်းရှင်း ပြဿနာများ

**"Connection refused" သို့မဟုတ် "Service unavailable"**
- ဝန်ဆောင်မှုကို စစ်ဆေးပါ: `foundry service status`
- လိုအပ်သည့်အခါ ပြန်စတင်ပါ: `foundry service restart`
- `application.properties` တွင်ရှိသည့် ပေါ့နှင့် `foundry service status` အထွက်ကို ကိုက်ညီမှု စစ်ဆေးပါ
- URL သည် `/v1` ဖြင့် ကျဆုံးရမည်: `http://localhost:5273/v1`

**စတင်ချိန် "No model found"**
- အက်ပလီကေးရှင်းသည် မော်ဒယ်ကို အလိုအလျောက် ရှာဖွေသည်။ မော်ဒယ်တစ်ခုခု တင်ထားနေရပါစေ။ `foundry service ps`
- မော်ဒယ်မရှိပါက `foundry model run phi-4-mini` ကို အသုံးပြု၍ တင်ပါ
- `application.properties` တွင် မော်ဒယ်နာမည် သတ်မှတ်ထားပါက `foundry model list` နဲ့ ကိုက်ညီမှုရှိစေပါ

**"400 Bad Request" အမှားများ**
- Base URL တွင် `/v1` ပါဝင်ခြင်းကို အတည်ပြုပါ: `http://localhost:5273/v1`
- ကိုးကားခြင်း၌ `maxCompletionTokens()` ကို အသုံးပြုပါ (ရိုးရာ `maxTokens()` မဟုတ်ပါ)

**Maven သတင်းအချက်အလက် ချွတ်ယွင်းမှု**
- Java 21 သို့မဟုတ် အထက်ကို သေချာစွာ ထည့်သွင်းထားပါ: `java -version`
- စင်ကြယ်ပြီး ပြန်တည်ဆောက်ပါ: `mvn clean compile`
- အင်တာနက် ချိတ်ဆက်မှုကို စစ်ဆေးပါ

**ဝန်ဆောင်မှု ဆက်သွယ်မှု ပြဿနာများ**
- "Request to local service failed" ဆိုရင် `foundry service restart` ကို ပြေးပါ
- တင်ထားသော မော်ဒယ်များကို ကြည့်ပါ: `foundry service ps`
- ဝန်ဆောင်မှု လော့ဂ်များကို ကြည့်ပါ: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**အနားလွှတ်ချက်**  
ဤစာတမ်းကို AI ဘာသာပြန်မှုဝန်ဆောင်မှုဖြစ်သော [Co-op Translator](https://github.com/Azure/co-op-translator) ဖြင့် ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားပါသော်လည်း အလိုအလျောက် ဘာသာပြန်မှုများတွင် အမှားများ သို့မဟုတ် အနည်းငယ် မမှန်ကန်မှုများ ပါဝင်နိုင်ကြောင်း သတိပြုပါ။ မူရင်းစာတမ်းကို သဘာဝဘာသာဖြင့်သာ အတည်ပြုနိုင်သော အရာအဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသတင်းအချက်အလက်များအတွက် မူညီ၍ လူကြီးမင်းတို့ ဘာသာပြန်ပညာရှင်မှ ဘာသာပြန်မှုကို အသုံးပြုရန် အကြံပြုပါသည်။ ဤဘာသာပြန်မှုကို အသုံးပြုခြင်းကြောင့် ဖြစ်ပေါ်လာနိုင်သည့် နားလည်မှားခြင်းသို့မဟုတ် မှားယွင်းဖော်ပြချက်များအတွက် ကျွန်ုပ်တို့သည် တာဝန်မရှိပါ။
<!-- CO-OP TRANSLATOR DISCLAIMER END -->