<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2284c54d2a98090a37df0dbef1633ebf",
  "translation_date": "2025-07-21T21:25:15+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/TUTORIAL.md",
  "language_code": "my"
}
-->
# Foundry Local Spring Boot သင်ခန်းစာ

## အကြောင်းအရာများ

- [လိုအပ်ချက်များ](../../../../04-PracticalSamples/foundrylocal)
- [ပရောဂျက်အကျဉ်း](../../../../04-PracticalSamples/foundrylocal)
- [ကုဒ်ကိုနားလည်ခြင်း](../../../../04-PracticalSamples/foundrylocal)
  - [1. အပလီကေးရှင်းဖိုင် (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. အဓိကအပလီကေးရှင်းကလပ် (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI ဝန်ဆောင်မှုအလွှာ (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. ပရောဂျက်အခြေခံလိုအပ်ချက်များ (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [ဘယ်လိုအလုပ်လုပ်တယ်ဆိုတာ](../../../../04-PracticalSamples/foundrylocal)
- [Foundry Local ကိုစတင်တပ်ဆင်ခြင်း](../../../../04-PracticalSamples/foundrylocal)
- [အပလီကေးရှင်းကိုအလုပ်လုပ်စေခြင်း](../../../../04-PracticalSamples/foundrylocal)
- [မျှော်မှန်းထားသောရလဒ်](../../../../04-PracticalSamples/foundrylocal)
- [နောက်ထပ်အဆင့်များ](../../../../04-PracticalSamples/foundrylocal)
- [ပြဿနာရှာဖွေဖြေရှင်းခြင်း](../../../../04-PracticalSamples/foundrylocal)

## လိုအပ်ချက်များ

ဒီသင်ခန်းစာကိုစတင်မတိုင်မီ သင့်မှာအောက်ပါအရာတွေရှိရမယ်-

- **Java 21 သို့မဟုတ် အထက်** ကို သင့်စနစ်မှာတပ်ဆင်ထားရမယ်
- **Maven 3.6+** ကို ပရောဂျက်ကို build လုပ်ဖို့လိုအပ်တယ်
- **Foundry Local** ကိုတပ်ဆင်ပြီး အလုပ်လုပ်နေဖို့လိုတယ်

### **Foundry Local ကိုတပ်ဆင်ပါ:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## ပရောဂျက်အကျဉ်း

ဒီပရောဂျက်မှာ အဓိကအစိတ်အပိုင်း ၄ ခုပါဝင်ပါတယ်-

1. **Application.java** - Spring Boot အပလီကေးရှင်းရဲ့ အဓိက entry point
2. **FoundryLocalService.java** - AI ဆက်သွယ်မှုကို စီမံခန့်ခွဲတဲ့ ဝန်ဆောင်မှုအလွှာ
3. **application.properties** - Foundry Local ဆက်သွယ်မှုအတွက် configuration
4. **pom.xml** - Maven အခြေခံလိုအပ်ချက်များနှင့် ပရောဂျက် configuration

## ကုဒ်ကိုနားလည်ခြင်း

### 1. အပလီကေးရှင်းဖိုင် (application.properties)

**ဖိုင်:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu
```

**ဒါဘာလုပ်သလဲ:**
- **base-url**: Foundry Local အလုပ်လုပ်နေတဲ့နေရာ (ပုံမှန် port 5273)
- **model**: စာသားထုတ်လုပ်မှုအတွက် အသုံးပြုမယ့် AI မော်ဒယ်နာမည်

**အဓိကအကြောင်းအရာ:** Spring Boot က ဒီ property တွေကို အလိုအလျောက် load လုပ်ပြီး `@Value` annotation နဲ့ သင့်အပလီကေးရှင်းမှာ အသုံးပြုနိုင်အောင်လုပ်ပေးတယ်။

### 2. အဓိကအပလီကေးရှင်းကလပ် (Application.java)

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

**ဒါဘာလုပ်သလဲ:**
- `@SpringBootApplication` က Spring Boot ရဲ့ auto-configuration ကို enable လုပ်တယ်
- `WebApplicationType.NONE` က command-line app ဖြစ်ပြီး web server မဟုတ်တာကို ပြောပြတယ်
- main method က Spring application ကိုစတင်တယ်

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

**ဒါဘာလုပ်သလဲ:**
- `@Bean` က Spring ကစီမံခန့်ခွဲမယ့် component တစ်ခုကိုဖန်တီးတယ်
- `CommandLineRunner` က Spring Boot စတင်ပြီးတာနောက် code ကို run လုပ်တယ်
- `foundryLocalService` ကို Spring ကအလိုအလျောက် inject လုပ်တယ် (dependency injection)
- AI ကို စမ်းသပ်မက်ဆေ့ချ်တစ်ခုပို့ပြီး ပြန်လာတဲ့အဖြေကိုပြတယ်

### 3. AI ဝန်ဆောင်မှုအလွှာ (FoundryLocalService.java)

**ဖိုင်:** `src/main/java/com/example/FoundryLocalService.java`

#### Configuration Injection:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu}")
    private String model;
```

**ဒါဘာလုပ်သလဲ:**
- `@Service` က ဒီ class က business logic ပေးတာကို Spring ကိုပြောတယ်
- `@Value` က application.properties ထဲက configuration value တွေကို inject လုပ်တယ်
- `:default-value` syntax က property မရှိရင် fallback value ပေးတယ်

#### Client Initialization:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")        // Foundry Local uses OpenAI-compatible API
            .apiKey("unused")                 // Local server doesn't need real API key
            .build();
}
```

**ဒါဘာလုပ်သလဲ:**
- `@PostConstruct` က Spring က service ဖန်တီးပြီးတာနောက် ဒီ method ကို run လုပ်တယ်
- Foundry Local instance ကိုပြသတဲ့ OpenAI client တစ်ခုဖန်တီးတယ်
- `/v1` path က OpenAI API နဲ့သဟဇာတဖြစ်ဖို့လိုတယ်
- API key က "unused" ဖြစ်တယ်၊ ဒါကြောင့် authentication မလိုအပ်ဘူး

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

**ဒါဘာလုပ်သလဲ:**
- **ChatCompletionCreateParams**: AI request ကို configure လုပ်တယ်
  - `model`: အသုံးပြုမယ့် AI မော်ဒယ်ကိုသတ်မှတ်တယ်
  - `addUserMessage`: သင့်မက်ဆေ့ချ်ကို စကားဝိုင်းထဲထည့်တယ်
  - `maxCompletionTokens`: ပြန်လာမယ့်အဖြေကို အရှည်ကန့်သတ်တယ် (resource များသုံးစွဲမှုလျှော့ချတယ်)
  - `temperature`: ရှေးခယျြမှုကိုထိန်းချုပ်တယ် (0.0 = အတိအကျ, 1.0 = ဖန်တီးမှု)
- **API Call**: Foundry Local ကို request ပို့တယ်
- **Response Handling**: AI ရဲ့စာသားအဖြေကို လုံခြုံစွာထုတ်ယူတယ်
- **Error Handling**: အမှားတွေကို အသုံးဝင်တဲ့ error message နဲ့ wrap လုပ်တယ်

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

**ဒါဘာလုပ်သလဲ:**
- **spring-boot-starter**: Spring Boot ရဲ့ အဓိကလုပ်ဆောင်ချက်တွေကိုပေးတယ်
- **openai-java**: OpenAI Java SDK ကို API ဆက်သွယ်မှုအတွက်အသုံးပြုတယ်
- **jackson-databind**: API call တွေအတွက် JSON serialization/deserialization ကိုစီမံတယ်

## ဘယ်လိုအလုပ်လုပ်တယ်ဆိုတာ

အပလီကေးရှင်းကို run လုပ်တဲ့အခါ အလုပ်လုပ်ပုံစဉ်ကဒီလိုဖြစ်တယ်-

1. **စတင်ခြင်း**: Spring Boot က `application.properties` ကိုဖတ်တယ်
2. **ဝန်ဆောင်မှုဖန်တီးခြင်း**: Spring က `FoundryLocalService` ကိုဖန်တီးပြီး configuration value တွေကို inject လုပ်တယ်
3. **Client Setup**: `@PostConstruct` က OpenAI client ကို Foundry Local နဲ့ဆက်သွယ်ဖို့ initialize လုပ်တယ်
4. **Demo အလုပ်လုပ်စေခြင်း**: `CommandLineRunner` က startup ပြီးတာနောက် run လုပ်တယ်
5. **AI Call**: Demo က `foundryLocalService.chat()` ကို စမ်းသပ်မက်ဆေ့ချ်နဲ့ခေါ်တယ်
6. **API Request**: Service က OpenAI-compatible request တစ်ခုကို Foundry Local ကိုပို့တယ်
7. **Response Processing**: Service က AI ရဲ့အဖြေကိုထုတ်ယူပြီးပြန်ပေးတယ်
8. **ပြသခြင်း**: အပလီကေးရှင်းက အဖြေကိုပြပြီးထွက်သွားတယ်

## Foundry Local ကိုစတင်တပ်ဆင်ခြင်း

Foundry Local ကိုတပ်ဆင်ဖို့ အောက်ပါအဆင့်တွေကိုလိုက်နာပါ-

1. **Foundry Local ကိုတပ်ဆင်ပါ** [လိုအပ်ချက်များ](../../../../04-PracticalSamples/foundrylocal) အပိုင်းမှာပေးထားတဲ့ညွှန်ကြားချက်တွေကိုလိုက်နာပါ။
2. **သင်အသုံးပြုချင်တဲ့ AI မော်ဒယ်ကိုဒေါင်းလုပ်ဆွဲပါ**၊ ဥပမာ `phi-3.5-mini` ကို အောက်ပါ command နဲ့:
   ```bash
   foundry model run phi-3.5-mini
   ```
3. **application.properties ဖိုင်ကို configure လုပ်ပါ** Foundry Local setting တွေနဲ့ကိုက်ညီအောင်၊ အထူးသဖြင့် port သို့မဟုတ် မော်ဒယ်ကွဲလွဲမှုရှိရင်။

## အပလီကေးရှင်းကိုအလုပ်လုပ်စေခြင်း

### အဆင့် 1: Foundry Local ကိုစတင်ပါ
```bash
foundry model run phi-3.5-mini
```

### အဆင့် 2: အပလီကေးရှင်းကို Build လုပ်ပြီး Run လုပ်ပါ
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

## နောက်ထပ်အဆင့်များ

နောက်ထပ်ဥပမာတွေကို [Chapter 04: Practical samples](../README.md) မှာကြည့်ပါ

## ပြဿနာရှာဖွေဖြေရှင်းခြင်း

### ပုံမှန်ပြဿနာများ

**"Connection refused" သို့မဟုတ် "Service unavailable"**
- Foundry Local အလုပ်လုပ်နေမနေစစ်ဆေးပါ: `foundry model list`
- Service က port 5273 မှာရှိမရှိစစ်ဆေးပါ: `application.properties` ကိုကြည့်ပါ
- Foundry Local ကိုပြန်စတင်ပါ: `foundry model run phi-3.5-mini`

**"Model not found" error**
- ရနိုင်တဲ့မော်ဒယ်တွေကိုစစ်ဆေးပါ: `foundry model list`
- application.properties ထဲမှာ မော်ဒယ်နာမည်ကိုတိတိကျကျ update လုပ်ပါ
- မော်ဒယ်ကိုဒေါင်းလုပ်ဆွဲပါ: `foundry model run phi-3.5-mini`

**Maven compilation error**
- Java 21 သို့မဟုတ် အထက်ရှိမရှိစစ်ဆေးပါ: `java -version`
- Clean လုပ်ပြီးပြန် build လုပ်ပါ: `mvn clean compile`
- Dependency တွေဒေါင်းလုပ်ဆွဲဖို့အတွက် အင်တာနက်ချိတ်ဆက်မှုစစ်ဆေးပါ

**အပလီကေးရှင်းစတင်ပြီး output မရှိ**
- Foundry Local ကတုံ့ပြန်နေမနေစစ်ဆေးပါ: Browser မှာ `http://localhost:5273` ကိုဖွင့်ကြည့်ပါ
- အပလီကေးရှင်း log တွေကိုကြည့်ပြီး error message တွေရှာပါ
- မော်ဒယ်ကအပြည့်အဝ load လုပ်ပြီး အသင့်ဖြစ်နေမနေစစ်ဆေးပါ

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေပါသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်ခြင်းတွင် အမှားများ သို့မဟုတ် မမှန်ကန်မှုများ ပါရှိနိုင်သည်ကို သတိပြုပါ။ မူရင်းစာရွက်စာတမ်းကို ၎င်း၏ မူရင်းဘာသာစကားဖြင့် အာဏာတရ အရင်းအမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များမှ ပရော်ဖက်ရှင်နယ် ဘာသာပြန်ခြင်းကို အကြံပြုပါသည်။ ဤဘာသာပြန်ကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအလွတ်များ သို့မဟုတ် အနားလွဲမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။