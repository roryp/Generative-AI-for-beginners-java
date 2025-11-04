<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "f787307400de59adc25a1404466a35f3",
  "translation_date": "2025-11-04T07:37:10+00:00",
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
- [ဘယ်လိုအရာအားလုံးပေါင်းစပ်လုပ်ဆောင်သလဲ](../../../../04-PracticalSamples/foundrylocal)
- [Foundry Local ကိုတပ်ဆင်ခြင်း](../../../../04-PracticalSamples/foundrylocal)
- [အက်ပလီကေးရှင်းကိုအလုပ်လုပ်စေခြင်း](../../../../04-PracticalSamples/foundrylocal)
- [မျှော်မှန်းထားသောရလဒ်](../../../../04-PracticalSamples/foundrylocal)
- [နောက်တစ်ဆင့်များ](../../../../04-PracticalSamples/foundrylocal)
- [ပြဿနာဖြေရှင်းခြင်း](../../../../04-PracticalSamples/foundrylocal)

## လိုအပ်ချက်များ

ဒီသင်ခန်းစာကိုစတင်မလုပ်ခင်မှာ သင်မှာအောက်ပါအရာတွေရှိဖို့လိုအပ်ပါတယ်-

- **Java 21 သို့မဟုတ်အထက်** ကိုသင့်စနစ်မှာတပ်ဆင်ထား
- **Maven 3.6+** ကိုပရောဂျက်ကိုတည်ဆောက်ဖို့
- **Foundry Local** ကိုတပ်ဆင်ပြီးအလုပ်လုပ်နေ

### **Foundry Local ကိုတပ်ဆင်ပါ:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```


## ပရောဂျက်အကျဉ်း

ဒီပရောဂျက်မှာအဓိကအစိတ်အပိုင်း ၄ ခုပါဝင်ပါတယ်-

1. **Application.java** - Spring Boot အက်ပလီကေးရှင်းရဲ့အဓိကစတင်မှုအချက်
2. **FoundryLocalService.java** - AI ဆက်သွယ်မှုကိုကိုင်တွယ်တဲ့ဝန်ဆောင်မှုအလွှာ
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
- **base-url**: Foundry Local ရဲ့လိပ်စာကိုသတ်မှတ်ပြီး `/v1` OpenAI API အတွက်လိုက်ဖက်မှုရှိစေပါတယ်။ **မှတ်ချက်**: Foundry Local က port ကို dynamic သတ်မှတ်လို့ `foundry service status` ကိုသုံးပြီး port ကိုစစ်ပါ။
- **model**: AI မော်ဒယ်နာမည်ကို version နဲ့အတူသတ်မှတ်ပါ (ဥပမာ `:1`)။ `foundry model list` ကိုသုံးပြီးရရှိနိုင်တဲ့မော်ဒယ်များနဲ့ ID တွေကိုကြည့်ပါ။

**အဓိကအချက်:** Spring Boot ကဒီ property တွေကိုအလိုအလျောက် load လုပ်ပြီး `@Value` annotation ကိုသုံးပြီး application မှာအသုံးပြုနိုင်စေပါတယ်။

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
- `@SpringBootApplication` က Spring Boot auto-configuration ကို enable လုပ်ပါတယ်။
- `WebApplicationType.NONE` က command-line app ဖြစ်ပြီး web server မဟုတ်တာကိုပြောပါတယ်။
- main method က Spring application ကိုစတင်ပါတယ်။

**Demo Runner:**
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


**ဒီအရာကဘာလုပ်သလဲ:**
- `@Bean` က Spring ကစီမံခန့်ခွဲတဲ့ component ကိုဖန်တီးပါတယ်။
- `CommandLineRunner` က Spring Boot စပြီးနောက် code ကို run လုပ်ပါတယ်။
- `foundryLocalService` ကို Spring ကအလိုအလျောက် inject လုပ်ပါတယ် (dependency injection)။
- AI ကို test message ပို့ပြီး response ကိုပြသပါတယ်။

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


**ဒီအရာကဘာလုပ်သလဲ:**
- `@Service` ကဒီ class က business logic ကိုပေးစွမ်းတယ်ဆိုတာပြောပါတယ်။
- `@Value` က application.properties ကနေဖွဲ့စည်းမှုတန်ဖိုးတွေကို inject လုပ်ပါတယ်။
- `:default-value` syntax က property မရှိရင် fallback value ကိုပေးပါတယ်။

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
- `@PostConstruct` က Spring service ကိုဖန်တီးပြီးနောက် method ကို run လုပ်ပါတယ်။
- Foundry Local instance ကိုချိတ်ဆက်တဲ့ OpenAI client ကိုဖန်တီးပါတယ်။
- `application.properties` ကနေ base URL ကိုသုံးပြီး `/v1` OpenAI API လိုက်ဖက်မှုရှိစေပါတယ်။
- API key ကို "not-needed" အဖြစ်သတ်မှတ်ထားပြီး local development အတွက် authentication မလိုအပ်ပါ။

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
- **ChatCompletionCreateParams**: AI request ကို configure လုပ်ပါတယ်။
  - `model`: သုံးမယ့် AI မော်ဒယ်ကိုသတ်မှတ်ပါတယ် (exact ID ကို `foundry model list` မှာကြည့်ပါ)။
  - `addUserMessage`: သင့် message ကို conversation ထဲထည့်ပါ။
  - `maxCompletionTokens`: response ရဲ့အရှည်ကိုကန့်သတ်ပါတယ် (resource ကိုသက်သာစေပါတယ်)။
  - `temperature`: randomness ကိုထိန်းချုပ်ပါတယ် (0.0 = deterministic, 1.0 = creative)။
- **API Call**: Foundry Local ကို request ပို့ပါတယ်။
- **Response Handling**: AI ရဲ့ text response ကိုလုံခြုံစွာ extract လုပ်ပါတယ်။
- **Error Handling**: error message တွေကို helpful message နဲ့ wrap လုပ်ပါတယ်။

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


**ဒီအရာတွေကဘာလုပ်သလဲ:**
- **spring-boot-starter**: Spring Boot ရဲ့အဓိက functionality ကိုပေးစွမ်းပါတယ်။
- **openai-java**: OpenAI Java SDK ကို API ဆက်သွယ်မှုအတွက်အသုံးပြုပါတယ်။
- **jackson-databind**: API call တွေအတွက် JSON serialization/deserialization ကိုကိုင်တွယ်ပါတယ်။

## ဘယ်လိုအရာအားလုံးပေါင်းစပ်လုပ်ဆောင်သလဲ

အက်ပလီကေးရှင်းကို run လုပ်တဲ့အခါမှာ အောက်ပါအဆင့်တွေဖြစ်ပေါ်ပါတယ်-

1. **စတင်မှု**: Spring Boot ကစပြီး `application.properties` ကိုဖတ်ပါတယ်။
2. **Service ဖန်တီးမှု**: Spring က `FoundryLocalService` ကိုဖန်တီးပြီး configuration value တွေကို inject လုပ်ပါတယ်။
3. **Client Setup**: `@PostConstruct` က OpenAI client ကို Foundry Local ကိုချိတ်ဆက်ဖို့ initialize လုပ်ပါတယ်။
4. **Demo Execution**: `CommandLineRunner` ကစပြီးနောက် run လုပ်ပါတယ်။
5. **AI Call**: demo က test message နဲ့ `foundryLocalService.chat()` ကိုခေါ်ပါတယ်။
6. **API Request**: Service က OpenAI-compatible request ကို Foundry Local ကိုပို့ပါတယ်။
7. **Response Processing**: Service က AI ရဲ့ response ကို extract လုပ်ပြီးပြန်ပေးပါတယ်။
8. **Display**: Application က response ကို print လုပ်ပြီးထွက်သွားပါတယ်။

## Foundry Local ကိုတပ်ဆင်ခြင်း

Foundry Local ကိုတပ်ဆင်ဖို့ အောက်ပါအဆင့်တွေကိုလိုက်နာပါ-

1. **Foundry Local ကိုတပ်ဆင်ပါ** [လိုအပ်ချက်များ](../../../../04-PracticalSamples/foundrylocal) အပိုင်းမှာရှိတဲ့ညွှန်ကြားချက်တွေကိုလိုက်နာပါ။

2. **Dynamic port ကိုစစ်ပါ**။ Foundry Local က port ကိုအလိုအလျောက်သတ်မှတ်ပါတယ်။ သင့် port ကိုအောက်ပါနည်းလမ်းနဲ့ရှာပါ:
   ```bash
   foundry service status
   ```
   
   **Optional**: သင့်ရဲ့ port ကို manual သတ်မှတ်ချင်ရင် အောက်ပါနည်းလမ်းကိုအသုံးပြုပါ:
   ```bash
   foundry service set --port 5273
   ```


3. **သင်သုံးချင်တဲ့ AI မော်ဒယ်ကိုဒေါင်းလုပ်လုပ်ပါ** (ဥပမာ `phi-3.5-mini`) အောက်ပါ command ကိုသုံးပါ:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **application.properties** ဖိုင်ကို Foundry Local setting နဲ့လိုက်ဖက်အောင် configure လုပ်ပါ:
   - `base-url` မှာ port ကို update လုပ်ပါ (အဆင့် ၂ မှာရရှိတဲ့ port)၊ `/v1` ကိုအဆုံးမှာထည့်ပါ။
   - မော်ဒယ်နာမည်ကို version နဲ့အတူ update လုပ်ပါ (`foundry model list` ကိုစစ်ပါ)။

   ဥပမာ:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## အက်ပလီကေးရှင်းကိုအလုပ်လုပ်စေခြင်း

### အဆင့် ၁: Foundry Local ကိုစတင်ပါ
```bash
foundry model run phi-3.5-mini
```


### အဆင့် ၂: အက်ပလီကေးရှင်းကိုတည်ဆောက်ပြီး run လုပ်ပါ
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

နောက်ထပ်နမူနာများအတွက် [Chapter 04: Practical samples](../README.md) ကိုကြည့်ပါ။

## ပြဿနာဖြေရှင်းခြင်း

### အများဆုံးဖြစ်နိုင်တဲ့ပြဿနာများ

**"Connection refused" သို့မဟုတ် "Service unavailable"**
- Foundry Local အလုပ်လုပ်နေသေချာစေပါ: `foundry model list`
- Foundry Local သုံးတဲ့ port ကိုစစ်ပါ: `foundry service status`
- `application.properties` ကိုမှန်ကန်တဲ့ port နဲ့ update လုပ်ပါ၊ URL ရဲ့အဆုံးမှာ `/v1` ပါရှိစေပါ။
- သတ်မှတ်ထားတဲ့ port ကိုသုံးချင်ရင်: `foundry service set --port 5273`
- Foundry Local ကိုပြန်စပါ: `foundry model run phi-3.5-mini`

**"Model not found" သို့မဟုတ် "404 Not Found" error**
- ရရှိနိုင်တဲ့မော်ဒယ်နဲ့ ID တွေကိုစစ်ပါ: `foundry model list`
- application.properties မှာမော်ဒယ်နာမည်ကို version နဲ့အတူမှန်ကန်စွာ update လုပ်ပါ (ဥပမာ `Phi-3.5-mini-instruct-cuda-gpu:1`)။
- `base-url` ရဲ့အဆုံးမှာ `/v1` ပါရှိစေပါ: `http://localhost:5273/v1`
- မော်ဒယ်ကိုဒေါင်းလုပ်လုပ်ပါ: `foundry model run phi-3.5-mini`

**"400 Bad Request" error**
- base URL ရဲ့အဆုံးမှာ `/v1` ပါရှိစေပါ: `http://localhost:5273/v1`
- မော်ဒယ် ID ကို `foundry model list` မှာပြထားတဲ့အတိုင်းမှန်ကန်စွာစစ်ပါ။
- `maxCompletionTokens()` ကိုသုံးထားတာသေချာစေပါ (deprecated ဖြစ်တဲ့ `maxTokens()` မသုံးပါနဲ့)။

**Maven compilation error**
- Java 21 သို့မဟုတ်အထက်ရှိတာသေချာစေပါ: `java -version`
- Clean လုပ်ပြီးပြန်တည်ဆောက်ပါ: `mvn clean compile`
- Dependency တွေကိုဒေါင်းလုပ်လုပ်ဖို့အတွက်အင်တာနက်ချိတ်ဆက်မှုကိုစစ်ပါ။

**Application စတင်ပြီး output မရှိပါ**
- Foundry Local ကတုံ့ပြန်နေသေချာစေပါ: `http://localhost:5273/v1/models` ကိုစစ်ပါသို့မဟုတ် `foundry service status` ကို run လုပ်ပါ။
- Application log တွေကိုစစ်ပြီး error message တွေကိုရှာပါ။
- မော်ဒယ်ကအပြည့်အစုံ load လုပ်ပြီးအသင့်ရှိနေသေချာစေပါ။

---

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေသော်လည်း အလိုအလျောက် ဘာသာပြန်မှုများတွင် အမှားများ သို့မဟုတ် မတိကျမှုများ ပါဝင်နိုင်သည်ကို သတိပြုပါ။ မူရင်းဘာသာစကားဖြင့် ရေးသားထားသော စာရွက်စာတမ်းကို အာဏာတရ အရင်းအမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များကို အသုံးပြုရန် အကြံပြုပါသည်။ ဤဘာသာပြန်မှုကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအမှားများ သို့မဟုတ် အနားယူမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။