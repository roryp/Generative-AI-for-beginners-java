<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "fe08a184d8a753a0f497673921f77759",
  "translation_date": "2025-11-04T06:58:45+00:00",
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
- [မျှော်မှန်းရလဒ်](../../../../04-PracticalSamples/foundrylocal)
- [နောက်တစ်ဆင့်များ](../../../../04-PracticalSamples/foundrylocal)
- [ပြဿနာဖြေရှင်းခြင်း](../../../../04-PracticalSamples/foundrylocal)

## လိုအပ်ချက်များ

ဒီသင်ခန်းစာကိုစတင်မလုပ်ခင်မှာ သင်မှာအောက်ပါအရာများရှိရမည်-

- **Java 21 သို့မဟုတ်အထက်** ကိုစနစ်မှာတပ်ဆင်ထား
- **Maven 3.6+** ကိုပရောဂျက်ကို build လုပ်ရန်
- **Foundry Local** ကိုတပ်ဆင်ပြီးအလုပ်လုပ်နေ

### **Foundry Local ကိုတပ်ဆင်ရန်**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```


## ပရောဂျက်အကျဉ်း

ဒီပရောဂျက်မှာ အဓိကအစိတ်အပိုင်း ၄ ခုပါဝင်သည်-

1. **Application.java** - အဓိက Spring Boot အက်ပလီကေးရှင်းစတင်မှုအချက်
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


**ဒီအရာကဘာလုပ်သလဲ:**
- **base-url**: Foundry Local ရှိနေရာကိုသတ်မှတ်ပြီး `/v1` path ကို OpenAI API နှင့်လိုက်ဖက်စေသည်။ **မှတ်ချက်**: Foundry Local သည် port ကို dynamic အနေနဲ့ပေးထားသောကြောင့် `foundry service status` ကိုအသုံးပြုပြီး port ကိုစစ်ဆေးပါ။
- **model**: text generation အတွက်အသုံးပြုမည့် AI model ကို version နံပါတ်နှင့်အတူသတ်မှတ်သည် (ဥပမာ `:1`)။ `foundry model list` ကိုအသုံးပြုပြီး model များနှင့် ID များကိုကြည့်ပါ။

**အဓိကအကြောင်းအရာ:** Spring Boot သည်ဤ properties များကိုအလိုအလျောက် load လုပ်ပြီး `@Value` annotation ကိုအသုံးပြုပြီး application မှာအသုံးပြုနိုင်စေသည်။

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


**ဒီအရာကဘာလုပ်သလဲ:**
- `@SpringBootApplication` သည် Spring Boot auto-configuration ကို enabled လုပ်သည်။
- `WebApplicationType.NONE` သည် Spring ကို command-line app ဖြစ်ပြီး web server မဟုတ်ကြောင်းပြောသည်။
- အဓိက method သည် Spring application ကိုစတင်သည်။

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


**ဒီအရာကဘာလုပ်သလဲ:**
- `@Bean` သည် Spring မှစီမံခန့်ခွဲသော component ကိုဖန်တီးသည်။
- `CommandLineRunner` သည် Spring Boot စတင်ပြီးနောက် code ကို run လုပ်သည်။
- `foundryLocalService` ကို Spring မှအလိုအလျောက် inject လုပ်သည် (dependency injection)။
- AI ကို test message ပို့ပြီး response ကိုပြသည်။

### 3. AI ဝန်ဆောင်မှုအလွှာ (FoundryLocalService.java)

**ဖိုင်:** `src/main/java/com/example/FoundryLocalService.java`

#### ဖွဲ့စည်းမှု Injection:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**ဒီအရာကဘာလုပ်သလဲ:**
- `@Service` သည် Spring ကိုဤ class သည် business logic ကိုပေးသည်ဟုပြောသည်။
- `@Value` သည် application.properties မှဖွဲ့စည်းမှုတန်ဖိုးများကို inject လုပ်သည်။
- `:default-value` syntax သည် properties မရှိပါက fallback တန်ဖိုးများပေးသည်။

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


**ဒီအရာကဘာလုပ်သလဲ:**
- `@PostConstruct` သည် Spring service ကိုဖန်တီးပြီးနောက်ဤ method ကို run လုပ်သည်။
- OpenAI client ကို Foundry Local instance သို့ချိတ်ဆက်ရန်ဖန်တီးသည်။
- `application.properties` မှ base URL သည် OpenAI API နှင့်လိုက်ဖက်ရန် `/v1` ပါဝင်သည်။
- API key ကို "not-needed" အဖြစ်သတ်မှတ်သည်။

#### Chat Method:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Which AI model to use
                .addUserMessage(message)         // Your question/prompt
                .maxCompletionTokens(150)        // Limit response length
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


**ဒီအရာကဘာလုပ်သလဲ:**
- **ChatCompletionCreateParams**: AI request ကို configure လုပ်သည်။
  - `model`: အသုံးပြုမည့် AI model ကိုသတ်မှတ်သည် (ID သည် `foundry model list` မှတိကျဖွယ်ဖြစ်ရမည်)။
  - `addUserMessage`: သင့် message ကို conversation ထဲသို့ထည့်သည်။
  - `maxCompletionTokens`: response ရှည်လျားမှုကိုကန့်သတ်သည် (resource ကိုသက်သာစေသည်)။
  - `temperature`: randomness ကိုထိန်းချုပ်သည် (0.0 = အတိအကျ, 1.0 = ဖန်တီးမှု)။
- **API Call**: Foundry Local သို့ request ကိုပို့သည်။
- **Response Handling**: AI response ကိုလုံခြုံစွာထုတ်ယူသည်။
- **Error Handling**: အမှားများကိုအသုံးဝင်သော error message များဖြင့် wrap လုပ်သည်။

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


**ဒီအရာကဘာလုပ်သလဲ:**
- **spring-boot-starter**: Spring Boot အခြေခံလုပ်ဆောင်ချက်များပေးသည်။
- **openai-java**: OpenAI Java SDK ကို API ဆက်သွယ်မှုအတွက်အသုံးပြုသည်။
- **jackson-databind**: API calls အတွက် JSON serialization/deserialization ကိုကိုင်တွယ်သည်။

## အရာအားလုံးပေါင်းစပ်လုပ်ဆောင်ပုံ

Application ကို run လုပ်သောအခါ အလုပ်လုပ်ပုံစဉ်မှာ-

1. **စတင်မှု**: Spring Boot သည် `application.properties` ကိုဖတ်သည်။
2. **Service ဖန်တီးမှု**: Spring သည် `FoundryLocalService` ကိုဖန်တီးပြီး configuration values ကို inject လုပ်သည်။
3. **Client Setup**: `@PostConstruct` သည် OpenAI client ကို Foundry Local သို့ချိတ်ဆက်ရန် initialize လုပ်သည်။
4. **Demo Execution**: `CommandLineRunner` သည် startup ပြီးနောက် run လုပ်သည်။
5. **AI Call**: demo သည် `foundryLocalService.chat()` ကို test message ဖြင့်ခေါ်သည်။
6. **API Request**: Service သည် OpenAI-compatible request ကို Foundry Local သို့ပို့သည်။
7. **Response Processing**: Service သည် AI response ကိုထုတ်ယူပြီးပြန်ပေးသည်။
8. **Display**: Application သည် response ကို print လုပ်ပြီးထွက်သည်။

## Foundry Local ကိုတပ်ဆင်ခြင်း

Foundry Local ကိုတပ်ဆင်ရန် အောက်ပါအဆင့်များကိုလိုက်နာပါ-

1. **Foundry Local ကိုတပ်ဆင်ပါ** [Prerequisites](../../../../04-PracticalSamples/foundrylocal) အပိုင်းရှိညွှန်ကြားချက်များကိုလိုက်နာပါ။

2. **Dynamic port ကိုစစ်ဆေးပါ**။ Foundry Local သည် port ကိုအလိုအလျောက်ပေးထားသည်။ Port ကိုရှာရန်:
   ```bash
   foundry service status
   ```
   
   **Optional**: သတ်မှတ်ထားသော port (ဥပမာ 5273) ကိုအသုံးပြုလိုပါက manual configuration ပြုလုပ်နိုင်သည်:
   ```bash
   foundry service set --port 5273
   ```


3. **အသုံးပြုမည့် AI model ကို download လုပ်ပါ** (ဥပမာ `phi-3.5-mini`)၊ အောက်ပါ command ဖြင့်:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **application.properties ဖိုင်ကို Foundry Local settings နှင့်လိုက်ဖက်အောင် configure လုပ်ပါ**:
   - `base-url` မှာ port ကို update လုပ်ပါ (အဆင့် 2 မှ)၊ `/v1` ပါဝင်ရမည်။
   - model နာမည်ကို version နံပါတ်နှင့် update လုပ်ပါ (`foundry model list` ဖြင့်စစ်ဆေးပါ)။

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


### အဆင့် 2: Application ကို build လုပ်ပြီး run လုပ်ပါ
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```


## မျှော်မှန်းရလဒ်

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

နောက်ထပ်ဥပမာများအတွက် [Chapter 04: Practical samples](../README.md) ကိုကြည့်ပါ။

## ပြဿနာဖြေရှင်းခြင်း

### အများဆုံးဖြစ်နိုင်သောပြဿနာများ

**"Connection refused" သို့မဟုတ် "Service unavailable"**
- Foundry Local အလုပ်လုပ်နေကြောင်းသေချာပါ: `foundry model list`
- Foundry Local အသုံးပြုနေသော port ကိုစစ်ဆေးပါ: `foundry service status`
- `application.properties` ကိုမှန်ကန်သော port ဖြင့် update လုပ်ပါ၊ URL သည် `/v1` ဖြင့်ဆုံးရမည်။
- သတ်မှတ်ထားသော port ကိုအသုံးပြုလိုပါက: `foundry service set --port 5273`
- Foundry Local ကိုပြန်စတင်ပါ: `foundry model run phi-3.5-mini`

**"Model not found" သို့မဟုတ် "404 Not Found" errors**
- Model များနှင့် ID များကိုစစ်ဆေးပါ: `foundry model list`
- `application.properties` မှာ model နာမည်ကိုတိကျစွာ update လုပ်ပါ (ဥပမာ `Phi-3.5-mini-instruct-cuda-gpu:1`)။
- `base-url` မှာ `/v1` ပါဝင်ကြောင်းသေချာပါ: `http://localhost:5273/v1`
- Model ကို download လုပ်ပါ: `foundry model run phi-3.5-mini`

**"400 Bad Request" errors**
- Base URL မှာ `/v1` ပါဝင်ကြောင်းသေချာပါ: `http://localhost:5273/v1`
- Model ID သည် `foundry model list` မှတိကျစွာကိုက်ညီကြောင်းစစ်ဆေးပါ။
- `maxCompletionTokens()` ကို code မှာအသုံးပြုကြောင်းသေချာပါ (မဟုတ်ရင် `maxTokens()` ကိုအသုံးမပြုပါနှင့်)။

**Maven compilation errors**
- Java 21 သို့မဟုတ်အထက်ရှိကြောင်းသေချာပါ: `java -version`
- Clean လုပ်ပြီးပြန် build လုပ်ပါ: `mvn clean compile`
- Dependency download အတွက်အင်တာနက်ချိတ်ဆက်မှုကိုစစ်ဆေးပါ။

**Application စတင်ပြီး output မရှိပါက**
- Foundry Local အလုပ်လုပ်နေကြောင်းစစ်ဆေးပါ: `http://localhost:5273` ကို browser ဖြင့်ဖွင့်ပါ။
- Application logs မှာ error message များကိုစစ်ဆေးပါ။
- Model သည်အပြည့်အဝ load လုပ်ပြီးအသုံးပြုနိုင်ကြောင်းသေချာပါ။

---

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေသော်လည်း အလိုအလျောက် ဘာသာပြန်မှုများတွင် အမှားများ သို့မဟုတ် မမှန်ကန်မှုများ ပါဝင်နိုင်သည်ကို သတိပြုပါ။ မူရင်းဘာသာစကားဖြင့် ရေးသားထားသော စာရွက်စာတမ်းကို အာဏာတရားရှိသော အရင်းအမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များကို အသုံးပြုရန် အကြံပြုပါသည်။ ဤဘာသာပြန်မှုကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအမှားများ သို့မဟုတ် အနားယူမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။