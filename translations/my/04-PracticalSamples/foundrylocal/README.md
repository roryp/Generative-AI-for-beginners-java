<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "713d81fd7d28a865068df047e26c8f12",
  "translation_date": "2025-11-03T20:17:38+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "my"
}
-->
# Foundry Local Spring Boot Tutorial

## အကြောင်းအရာများ

- [လိုအပ်ချက်များ](../../../../04-PracticalSamples/foundrylocal)
- [ပရောဂျက်အကျဉ်း](../../../../04-PracticalSamples/foundrylocal)
- [ကုဒ်ကိုနားလည်ခြင်း](../../../../04-PracticalSamples/foundrylocal)
  - [1. အက်ပလီကေးရှင်းဖွဲ့စည်းမှု (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. အဓိကအက်ပလီကေးရှင်းကလပ် (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI ဝန်ဆောင်မှုအလွှာ (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. ပရောဂျက်အခြေခံလိုအပ်ချက်များ (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [အရာအားလုံးပေါင်းစပ်လုပ်ဆောင်ပုံ](../../../../04-PracticalSamples/foundrylocal)
- [Foundry Local ကိုတပ်ဆင်ခြင်း](../../../../04-PracticalSamples/foundrylocal)
- [အက်ပလီကေးရှင်းကိုအလုပ်လုပ်စေခြင်း](../../../../04-PracticalSamples/foundrylocal)
- [မျှော်မှန်းထားသောရလဒ်](../../../../04-PracticalSamples/foundrylocal)
- [နောက်တစ်ဆင့်များ](../../../../04-PracticalSamples/foundrylocal)
- [ပြဿနာဖြေရှင်းခြင်း](../../../../04-PracticalSamples/foundrylocal)

## လိုအပ်ချက်များ

ဤလမ်းညွှန်ကိုစတင်မည်ဆိုပါက အောက်ပါအရာများရှိရန်သေချာပါစေ-

- **Java 21 သို့မဟုတ်အထက်** ကိုသင်၏စနစ်တွင်တပ်ဆင်ထား
- **Maven 3.6+** ကိုပရောဂျက်ကိုတည်ဆောက်ရန်အသုံးပြု
- **Foundry Local** ကိုတပ်ဆင်ပြီးအလုပ်လုပ်နေ

### **Foundry Local ကိုတပ်ဆင်ရန်:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```


## ပရောဂျက်အကျဉ်း

ဤပရောဂျက်တွင်အဓိကအစိတ်အပိုင်း ၄ ခုပါဝင်သည်-

1. **Application.java** - Spring Boot အက်ပလီကေးရှင်း၏အဓိကစတင်ပွင့်ပေါက်
2. **FoundryLocalService.java** - AI ဆက်သွယ်မှုကိုကိုင်တွယ်သောဝန်ဆောင်မှုအလွှာ
3. **application.properties** - Foundry Local ဆက်သွယ်မှုအတွက်ဖွဲ့စည်းမှု
4. **pom.xml** - Maven အခြေခံလိုအပ်ချက်များနှင့်ပရောဂျက်ဖွဲ့စည်းမှု

## ကုဒ်ကိုနားလည်ခြင်း

### 1. အက်ပလီကေးရှင်းဖွဲ့စည်းမှု (application.properties)

**ဖိုင်:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**ဤအရာကဘာလုပ်သလဲ:**
- **base-url**: Foundry Local အလုပ်လုပ်နေသောနေရာကိုသတ်မှတ်ပြီး `/v1` လမ်းကြောင်းကို OpenAI API နှင့်လိုက်ဖက်စေရန်ထည့်သွင်းထားသည်။ **မှတ်ချက်**: Foundry Local သည် port ကို dynamic အနေနှင့်ပေးထားသောကြောင့် `foundry service status` ကိုအသုံးပြု၍ port ကိုစစ်ဆေးပါ။
- **model**: စာသားထုတ်လုပ်မှုအတွက်အသုံးပြုမည့် AI မော်ဒယ်အမည်နှင့်ဗားရှင်းနံပါတ် (ဥပမာ `:1`) ကိုသတ်မှတ်ပါ။ `foundry model list` ကိုအသုံးပြု၍ ရရှိနိုင်သောမော်ဒယ်များနှင့်၎င်းတို့၏ ID များကိုကြည့်ပါ။

**အဓိကအယူအဆ:** Spring Boot သည်ဤ property များကိုအလိုအလျောက် load လုပ်ပြီး `@Value` annotation ကိုအသုံးပြု၍ သင့်အက်ပလီကေးရှင်းတွင်ရရှိစေသည်။

### 2. အဓိကအက်ပလီကေးရှင်းကလပ် (Application.java)

**ဖိုင်:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```


**ဤအရာကဘာလုပ်သလဲ:**
- `@SpringBootApplication` သည် Spring Boot auto-configuration ကိုဖွင့်သည်
- `WebApplicationType.NONE` သည် Spring ကိုဤအက်ပလီကေးရှင်းသည် command-line app ဖြစ်ပြီး web server မဟုတ်ကြောင်းပြောသည်
- အဓိက method သည် Spring အက်ပလီကေးရှင်းကိုစတင်သည်

**Demo Runner:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
    };
}
```


**ဤအရာကဘာလုပ်သလဲ:**
- `@Bean` သည် Spring မှစီမံခန့်ခွဲသော component တစ်ခုကိုဖန်တီးသည်
- `CommandLineRunner` သည် Spring Boot စတင်ပြီးနောက်ကုဒ်ကိုအလုပ်လုပ်စေသည်
- `foundryLocalService` ကို Spring မှအလိုအလျောက် inject လုပ်သည် (dependency injection)
- AI သို့စမ်းသပ်မက်ဆေ့ခ်ျတစ်ခုပို့ပြီးအဖြေကိုပြသသည်

### 3. AI ဝန်ဆောင်မှုအလွှာ (FoundryLocalService.java)

**ဖိုင်:** `src/main/java/com/example/FoundryLocalService.java`

#### ဖွဲ့စည်းမှုကို inject လုပ်ခြင်း:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**ဤအရာကဘာလုပ်သလဲ:**
- `@Service` သည် Spring ကိုဤကလပ်သည်လုပ်ငန်းဆိုင်ရာ logic ကိုပေးသည်ဟုပြောသည်
- `@Value` သည် application.properties မှဖွဲ့စည်းမှုတန်ဖိုးများကို inject လုပ်သည်
- `:default-value` syntax သည် property မရှိပါက fallback တန်ဖိုးများကိုပေးသည်

#### Client Initialization:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```


**ဤအရာကဘာလုပ်သလဲ:**
- `@PostConstruct` သည် Spring မှ service ကိုဖန်တီးပြီးနောက်ဤ method ကိုအလုပ်လုပ်စေသည်
- OpenAI client ကို Foundry Local instance သို့ချိတ်ဆက်ရန်ဖန်တီးသည်
- `application.properties` မှ base URL သည် OpenAI API နှင့်လိုက်ဖက်ရန် `/v1` ကိုထည့်သွင်းထားပြီးဖြစ်သည်
- API key ကို "not-needed" အဖြစ်သတ်မှတ်ထားသည် (local development အတွက် authentication မလိုအပ်ပါ)

#### Chat Method:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Which AI model to use
                .addUserMessage(message)         // Your question/prompt
                .maxTokens(150)                  // Limit response length
                .temperature(0.7)                // Control creativity (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extract the AI's response from the API result
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```


**ဤအရာကဘာလုပ်သလဲ:**
- **ChatCompletionCreateParams**: AI request ကိုဖွဲ့စည်းသည်
  - `model`: အသုံးပြုမည့် AI မော်ဒယ်ကိုသတ်မှတ်သည် (foundry model list မှတိကျသော ID ကိုလိုအပ်သည်)
  - `addUserMessage`: မက်ဆေ့ခ်ျကိုစကားပြောမှုတွင်ထည့်သွင်းသည်
  - `maxTokens`: အဖြေ၏အရှည်ကိုကန့်သတ်သည် (အရင်းအမြစ်များကိုသက်သာစေသည်)
  - `temperature`: အလွတ်တက်မှုကိုထိန်းချုပ်သည် (0.0 = အတိအကျ, 1.0 = ဖန်တီးမှု)
- **API Call**: Foundry Local သို့ request ကိုပို့သည်
- **Response Handling**: AI ၏စာသားအဖြေကိုလုံခြုံစွာထုတ်ယူသည်
- **Error Handling**: အမှားများကိုအသုံးဝင်သော error message များဖြင့် wrap လုပ်သည်

### 4. ပရောဂျက်အခြေခံလိုအပ်ချက်များ (pom.xml)

**အဓိကလိုအပ်ချက်များ:**

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


**ဤအရာများကဘာလုပ်သလဲ:**
- **spring-boot-starter**: Spring Boot ၏အဓိကလုပ်ဆောင်ချက်များကိုပေးသည်
- **openai-java**: OpenAI Java SDK ကို API ဆက်သွယ်မှုအတွက်ပေးသည်
- **jackson-databind**: API call များအတွက် JSON serialization/deserialization ကိုကိုင်တွယ်သည်

## အရာအားလုံးပေါင်းစပ်လုပ်ဆောင်ပုံ

အက်ပလီကေးရှင်းကိုအလုပ်လုပ်စေသောအခါဖြစ်ပုံကိုအောက်ပါအတိုင်းဖြစ်သည်-

1. **စတင်ခြင်း**: Spring Boot သည် `application.properties` ကိုဖတ်သည်
2. **ဝန်ဆောင်မှုဖန်တီးခြင်း**: Spring သည် `FoundryLocalService` ကိုဖန်တီးပြီးဖွဲ့စည်းမှုတန်ဖိုးများကို inject လုပ်သည်
3. **Client Setup**: `@PostConstruct` သည် OpenAI client ကို Foundry Local သို့ချိတ်ဆက်ရန် initialize လုပ်သည်
4. **Demo Execution**: Spring Boot စတင်ပြီးနောက် `CommandLineRunner` ကိုအလုပ်လုပ်စေသည်
5. **AI Call**: Demo သည် `foundryLocalService.chat()` ကိုစမ်းသပ်မက်ဆေ့ခ်ျဖြင့်ခေါ်ဆိုသည်
6. **API Request**: Service သည် OpenAI-compatible request ကို Foundry Local သို့ပို့သည်
7. **Response Processing**: Service သည် AI ၏အဖြေကိုထုတ်ယူပြီးပြန်ပေးသည်
8. **ပြသခြင်း**: အက်ပလီကေးရှင်းသည်အဖြေကိုပုံနှိပ်ပြီးထွက်သည်

## Foundry Local ကိုတပ်ဆင်ခြင်း

Foundry Local ကိုတပ်ဆင်ရန်အောက်ပါအဆင့်များကိုလိုက်နာပါ-

1. **Foundry Local ကိုတပ်ဆင်ပါ** [လိုအပ်ချက်များ](../../../../04-PracticalSamples/foundrylocal) အပိုင်းတွင်ပါရှိသောညွှန်ကြားချက်များကိုလိုက်နာပါ။

2. **Dynamic port ကိုစစ်ဆေးပါ**။ Foundry Local သည်စတင်သောအခါ port ကိုအလိုအလျောက်ပေးထားသည်။ သင့် port ကိုအောက်ပါအတိုင်းရှာပါ:
   ```bash
   foundry service status
   ```
   
   **Optional**: သင့်အကြိုက် port (ဥပမာ 5273) ကိုသတ်မှတ်လိုပါက အောက်ပါအတိုင်းဖွဲ့စည်းပါ:
   ```bash
   foundry service set --port 5273
   ```


3. **သင်အသုံးပြုလိုသော AI မော်ဒယ်ကိုဒေါင်းလုပ်လုပ်ပါ** (ဥပမာ `phi-3.5-mini`) အောက်ပါ command ဖြင့်:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **application.properties** ဖိုင်ကို Foundry Local ဖွဲ့စည်းမှုနှင့်လိုက်ဖက်အောင်ပြင်ဆင်ပါ:
   - `base-url` တွင် port ကို (အဆင့် 2 မှ) update လုပ်ပြီး `/v1` ကိုအဆုံးတွင်ထည့်ပါ
   - မော်ဒယ်အမည်ကိုဗားရှင်းနံပါတ်နှင့်အတူ update လုပ်ပါ (`foundry model list` ဖြင့်စစ်ဆေးပါ)

   ဥပမာ:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## အက်ပလီကေးရှင်းကိုအလုပ်လုပ်စေခြင်း

### အဆင့် 1: Foundry Local ကိုစတင်ပါ
```bash
foundry model run phi-3.5-mini
```


### အဆင့် 2: အက်ပလီကေးရှင်းကိုတည်ဆောက်ပြီးအလုပ်လုပ်စေပါ
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```


## မျှော်မှန်းထားသောရလဒ်

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```


## နောက်တစ်ဆင့်များ

နောက်ထပ်ဥပမာများအတွက် [Chapter 04: Practical samples](../README.md) ကိုကြည့်ပါ

## ပြဿနာဖြေရှင်းခြင်း

### အများဆုံးတွေ့ရသောပြဿနာများ

**"Connection refused" သို့မဟုတ် "Service unavailable"**
- Foundry Local အလုပ်လုပ်နေကြောင်းသေချာပါ: `foundry model list`
- Foundry Local အသုံးပြုနေသော port ကိုစစ်ဆေးပါ: `foundry service status`
- `application.properties` တွင် URL အဆုံးတွင် `/v1` ပါရှိသော port ကို update လုပ်ပါ
- သို့မဟုတ် သတ်မှတ်ထားသော port ကိုအသုံးပြုပါ: `foundry service set --port 5273`
- Foundry Local ကိုပြန်စတင်ပါ: `foundry model run phi-3.5-mini`

**"Model not found" သို့မဟုတ် "404 Not Found" errors**
- `foundry model list` ဖြင့်ရရှိနိုင်သောမော်ဒယ်များနှင့်၎င်းတို့၏ ID များကိုစစ်ဆေးပါ
- application.properties တွင်မော်ဒယ်အမည်ကိုတိကျစွာ update လုပ်ပါ (ဥပမာ `Phi-3.5-mini-instruct-cuda-gpu:1`)
- `base-url` တွင် `/v1` ပါရှိကြောင်းသေချာပါ: `http://localhost:5273/v1`
- မော်ဒယ်ကိုလိုအပ်ပါကဒေါင်းလုပ်လုပ်ပါ: `foundry model run phi-3.5-mini`

**"400 Bad Request" errors**
- base URL တွင် `/v1` ပါရှိကြောင်းစစ်ဆေးပါ: `http://localhost:5273/v1`
- မော်ဒယ် ID သည် `foundry model list` တွင်ပြထားသောအတိုင်းတိကျကြောင်းစစ်ဆေးပါ
- `maxTokens()` ကိုအသုံးပြုပါ၊ `maxCompletionTokens()` မဟုတ်ပါ

**Maven compilation errors**
- Java 21 သို့မဟုတ်အထက်ရှိကြောင်းသေချာပါ: `java -version`
- Clean နှင့် rebuild လုပ်ပါ: `mvn clean compile`
- Dependency download များအတွက်အင်တာနက်ချိတ်ဆက်မှုကိုစစ်ဆေးပါ

**အက်ပလီကေးရှင်းစတင်ပြီး output မရှိပါ**
- Foundry Local အဖြေပြန်ပေးနေကြောင်းသေချာပါ: `http://localhost:5273` ကို browser ဖြင့်ဖွင့်ပါ
- အက်ပလီကေးရှင်း log တွင် error message များကိုစစ်ဆေးပါ
- မော်ဒယ်သည်အပြည့်အဝ load လုပ်ပြီးအသုံးပြုရန်အဆင်သင့်ဖြစ်ကြောင်းသေချာပါ

---

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှန်ကန်မှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်မှုများတွင် အမှားများ သို့မဟုတ် မမှန်ကန်မှုများ ပါဝင်နိုင်သည်ကို သတိပြုပါ။ မူရင်းဘာသာစကားဖြင့် ရေးသားထားသော စာရွက်စာတမ်းကို အာဏာတရားရှိသော အရင်းအမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူက ဘာသာပြန်မှုကို အကြံပြုပါသည်။ ဤဘာသာပြန်မှုကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအမှားများ သို့မဟုတ် အနားလွဲမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။