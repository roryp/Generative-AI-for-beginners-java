<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "f787307400de59adc25a1404466a35f3",
  "translation_date": "2025-12-01T09:24:01+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "kn"
}
-->
# ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಸ್ಪ್ರಿಂಗ್ ಬೂಟ್ ಟ್ಯುಟೋರಿಯಲ್

## ವಿಷಯಗಳ ಪಟ್ಟಿಯು

- [ಪೂರ್ವಶರತ್ತುಗಳು](../../../../04-PracticalSamples/foundrylocal)
- [ಪ್ರಾಜೆಕ್ಟ್ ಅವಲೋಕನ](../../../../04-PracticalSamples/foundrylocal)
- [ಕೋಡ್ ಅನ್ನು ಅರ್ಥಮಾಡಿಕೊಳ್ಳುವುದು](../../../../04-PracticalSamples/foundrylocal)
  - [1. ಅಪ್ಲಿಕೇಶನ್ ಕಾನ್ಫಿಗರೇಶನ್ (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. ಮುಖ್ಯ ಅಪ್ಲಿಕೇಶನ್ ಕ್ಲಾಸ್ (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. ಎಐ ಸರ್ವೀಸ್ ಲೇಯರ್ (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. ಪ್ರಾಜೆಕ್ಟ್ ಅವಲಂಬನೆಗಳು (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [ಎಲ್ಲವೂ ಹೇಗೆ ಕೆಲಸ ಮಾಡುತ್ತದೆ](../../../../04-PracticalSamples/foundrylocal)
- [ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಅನ್ನು ಸೆಟ್ ಅಪ್ ಮಾಡುವುದು](../../../../04-PracticalSamples/foundrylocal)
- [ಅಪ್ಲಿಕೇಶನ್ ಅನ್ನು ರನ್ ಮಾಡುವುದು](../../../../04-PracticalSamples/foundrylocal)
- [ನಿರೀಕ್ಷಿತ ಔಟ್‌ಪುಟ್](../../../../04-PracticalSamples/foundrylocal)
- [ಮುಂದಿನ ಹಂತಗಳು](../../../../04-PracticalSamples/foundrylocal)
- [ತೊಂದರೆ ಪರಿಹಾರ](../../../../04-PracticalSamples/foundrylocal)

## ಪೂರ್ವಶರತ್ತುಗಳು

ಈ ಟ್ಯುಟೋರಿಯಲ್ ಪ್ರಾರಂಭಿಸುವ ಮೊದಲು, ನೀವು ಈ ಕೆಳಗಿನವುಗಳನ್ನು ಹೊಂದಿರಬೇಕು:

- **ಜಾವಾ 21 ಅಥವಾ ಹೆಚ್ಚಿನ ಆವೃತ್ತಿ** ನಿಮ್ಮ ಸಿಸ್ಟಮ್‌ನಲ್ಲಿ ಇನ್‌ಸ್ಟಾಲ್ ಮಾಡಿರಬೇಕು
- **ಮೇವನ್ 3.6+** ಪ್ರಾಜೆಕ್ಟ್ ಅನ್ನು ಬಿಲ್ಡ್ ಮಾಡಲು
- **ಫೌಂಡ್ರಿ ಲೋಕಲ್** ಇನ್‌ಸ್ಟಾಲ್ ಮಾಡಿರುವುದು ಮತ್ತು ರನ್ ಮಾಡುತ್ತಿರುವುದು

### **ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಅನ್ನು ಇನ್‌ಸ್ಟಾಲ್ ಮಾಡುವುದು:**

```bash
# ವಿಂಡೋಸ್
winget install Microsoft.FoundryLocal

# ಮ್ಯಾಕ್‌ಒಎಸ್ (ಸ್ಥಾಪನೆಯ ನಂತರ)
foundry model run phi-3.5-mini
```


## ಪ್ರಾಜೆಕ್ಟ್ ಅವಲೋಕನ

ಈ ಪ್ರಾಜೆಕ್ಟ್ ನಾಲ್ಕು ಮುಖ್ಯ ಘಟಕಗಳನ್ನು ಹೊಂದಿದೆ:

1. **Application.java** - ಮುಖ್ಯ ಸ್ಪ್ರಿಂಗ್ ಬೂಟ್ ಅಪ್ಲಿಕೇಶನ್ ಎಂಟ್ರಿ ಪಾಯಿಂಟ್
2. **FoundryLocalService.java** - ಎಐ ಸಂವಹನವನ್ನು ನಿರ್ವಹಿಸುವ ಸರ್ವೀಸ್ ಲೇಯರ್
3. **application.properties** - ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಸಂಪರ್ಕಕ್ಕಾಗಿ ಕಾನ್ಫಿಗರೇಶನ್
4. **pom.xml** - ಮೇವನ್ ಅವಲಂಬನೆಗಳು ಮತ್ತು ಪ್ರಾಜೆಕ್ಟ್ ಕಾನ್ಫಿಗರೇಶನ್

## ಕೋಡ್ ಅನ್ನು ಅರ್ಥಮಾಡಿಕೊಳ್ಳುವುದು

### 1. ಅಪ್ಲಿಕೇಶನ್ ಕಾನ್ಫಿಗರೇಶನ್ (application.properties)

**ಫೈಲ್:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**ಇದು ಏನು ಮಾಡುತ್ತದೆ:**
- **base-url**: ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಎಲ್ಲಿ ರನ್ ಆಗುತ್ತಿದೆ ಎಂಬುದನ್ನು ಸೂಚಿಸುತ್ತದೆ, `/v1` ಪಾತ್ ಅನ್ನು ಒಳಗೊಂಡಂತೆ OpenAI API ಹೊಂದಾಣಿಕೆಗೆ. **ಗಮನಿಸಿ**: ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಡೈನಾಮಿಕ್ ಪೋರ್ಟ್ ಅನ್ನು ಅಸೈನ್ ಮಾಡುತ್ತದೆ, ಆದ್ದರಿಂದ ನಿಮ್ಮ ನಿಜವಾದ ಪೋರ್ಟ್ ಅನ್ನು `foundry service status` ಬಳಸಿ ಪರಿಶೀಲಿಸಿ
- **model**: ಪಠ್ಯ ತಲೆಹರಿವುಗಾಗಿ ಬಳಸುವ ಎಐ ಮಾದರಿಯ ಹೆಸರನ್ನು, ಆವೃತ್ತಿ ಸಂಖ್ಯೆಯನ್ನು (ಉದಾ., `:1`) ಒಳಗೊಂಡಂತೆ. ಲಭ್ಯವಿರುವ ಮಾದರಿಗಳನ್ನು ಮತ್ತು ಅವುಗಳ ನಿಖರವಾದ ಐಡಿಗಳನ್ನು ನೋಡಲು `foundry model list` ಅನ್ನು ಬಳಸಿ

**ಮುಖ್ಯ ತತ್ವ:** ಸ್ಪ್ರಿಂಗ್ ಬೂಟ್ ಈ ಗುಣಲಕ್ಷಣಗಳನ್ನು ಸ್ವಯಂಚಾಲಿತವಾಗಿ ಲೋಡ್ ಮಾಡುತ್ತದೆ ಮತ್ತು `@Value` ಅನೋಟೇಶನ್ ಬಳಸಿ ನಿಮ್ಮ ಅಪ್ಲಿಕೇಶನ್‌ಗೆ ಲಭ್ಯವಾಗಿಸುತ್ತದೆ.

### 2. ಮುಖ್ಯ ಅಪ್ಲಿಕೇಶನ್ ಕ್ಲಾಸ್ (Application.java)

**ಫೈಲ್:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // ವೆಬ್ ಸರ್ವರ್ ಅಗತ್ಯವಿಲ್ಲ
        app.run(args);
    }
```


**ಇದು ಏನು ಮಾಡುತ್ತದೆ:**
- `@SpringBootApplication` ಸ್ಪ್ರಿಂಗ್ ಬೂಟ್ ಸ್ವಯಂ-ಕಾನ್ಫಿಗರೇಶನ್ ಅನ್ನು ಸಕ್ರಿಯಗೊಳಿಸುತ್ತದೆ
- `WebApplicationType.NONE` ಸ್ಪ್ರಿಂಗ್‌ಗೆ ಇದು ಕಮಾಂಡ್-ಲೈನ್ ಅಪ್ಲಿಕೇಶನ್ ಎಂದು ತಿಳಿಸುತ್ತದೆ, ವೆಬ್ ಸರ್ವರ್ ಅಲ್ಲ
- ಮುಖ್ಯ ವಿಧಾನವು ಸ್ಪ್ರಿಂಗ್ ಅಪ್ಲಿಕೇಶನ್ ಅನ್ನು ಪ್ರಾರಂಭಿಸುತ್ತದೆ

**ಡೆಮೋ ರನ್ನರ್:**
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


**ಇದು ಏನು ಮಾಡುತ್ತದೆ:**
- `@Bean` ಸ್ಪ್ರಿಂಗ್ ನಿರ್ವಹಿಸುವ ಘಟಕವನ್ನು ರಚಿಸುತ್ತದೆ
- `CommandLineRunner` ಸ್ಪ್ರಿಂಗ್ ಬೂಟ್ ಪ್ರಾರಂಭವಾದ ನಂತರ ಕೋಡ್ ಅನ್ನು ರನ್ ಮಾಡುತ್ತದೆ
- `foundryLocalService` ಅನ್ನು ಸ್ಪ್ರಿಂಗ್ ಸ್ವಯಂಚಾಲಿತವಾಗಿ ಇಂಜೆಕ್ಟ್ ಮಾಡುತ್ತದೆ (ಡಿಪೆಂಡೆನ್ಸಿ ಇಂಜೆಕ್ಷನ್)
- ಎಐಗೆ ಪರೀಕ್ಷಾ ಸಂದೇಶವನ್ನು ಕಳುಹಿಸುತ್ತದೆ ಮತ್ತು ಪ್ರತಿಕ್ರಿಯೆಯನ್ನು ಪ್ರದರ್ಶಿಸುತ್ತದೆ

### 3. ಎಐ ಸರ್ವೀಸ್ ಲೇಯರ್ (FoundryLocalService.java)

**ಫೈಲ್:** `src/main/java/com/example/FoundryLocalService.java`

#### ಕಾನ್ಫಿಗರೇಶನ್ ಇಂಜೆಕ್ಷನ್:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**ಇದು ಏನು ಮಾಡುತ್ತದೆ:**
- `@Service` ಸ್ಪ್ರಿಂಗ್‌ಗೆ ಈ ಕ್ಲಾಸ್ ವ್ಯವಹಾರ ಲಾಜಿಕ್ ಅನ್ನು ಒದಗಿಸುತ್ತದೆ ಎಂದು ತಿಳಿಸುತ್ತದೆ
- `@Value` application.properties ನಿಂದ ಕಾನ್ಫಿಗರೇಶನ್ ಮೌಲ್ಯಗಳನ್ನು ಇಂಜೆಕ್ಟ್ ಮಾಡುತ್ತದೆ
- `:default-value` ಸಿಂಟ್ಯಾಕ್ಸ್ ಗುಣಲಕ್ಷಣಗಳನ್ನು ಹೊಂದಿಸದಿದ್ದರೆ ಬ್ಯಾಕಪ್ ಮೌಲ್ಯಗಳನ್ನು ಒದಗಿಸುತ್ತದೆ

#### ಕ್ಲೈಂಟ್ ಪ್ರಾರಂಭ:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // ಮೂಲ URL ಈಗಾಗಲೇ ಕಾನ್ಫಿಗರೇಶನ್‌ನಿಂದ /v1 ಅನ್ನು ಒಳಗೊಂಡಿದೆ
            .apiKey("not-needed")            // ಸ್ಥಳೀಯ ಸರ್ವರ್‌ಗೆ ನಿಜವಾದ API ಕೀ ಅಗತ್ಯವಿಲ್ಲ
            .build();
}
```


**ಇದು ಏನು ಮಾಡುತ್ತದೆ:**
- `@PostConstruct` ಈ ವಿಧಾನವನ್ನು ಸ್ಪ್ರಿಂಗ್ ಸರ್ವೀಸ್ ರಚಿಸಿದ ನಂತರ ರನ್ ಮಾಡುತ್ತದೆ
- ನಿಮ್ಮ ಸ್ಥಳೀಯ ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಇನ್‌ಸ್ಟಾನ್ಸ್‌ಗೆ ಪಾಯಿಂಟ್ ಮಾಡುವ OpenAI ಕ್ಲೈಂಟ್ ಅನ್ನು ರಚಿಸುತ್ತದೆ
- `application.properties` ನಿಂದ ಬೇಸ್ URL ಈಗಾಗಲೇ OpenAI API ಹೊಂದಾಣಿಕೆಗೆ `/v1` ಅನ್ನು ಒಳಗೊಂಡಿದೆ
- ಸ್ಥಳೀಯ ಅಭಿವೃದ್ಧಿಗೆ ಪ್ರಾಮಾಣೀಕರಣ ಅಗತ್ಯವಿಲ್ಲದ ಕಾರಣ API ಕೀ "not-needed" ಗೆ ಸೆಟ್ ಆಗಿದೆ

#### ಚಾಟ್ ವಿಧಾನ:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // ಯಾವ AI ಮಾದರಿಯನ್ನು ಬಳಸಬೇಕು
                .addUserMessage(message)         // ನಿಮ್ಮ ಪ್ರಶ್ನೆ/ಪ್ರಾಂಪ್ಟ್
                .maxCompletionTokens(150)        // ಪ್ರತಿಸ್ಪಂದನೆಯ ಉದ್ದವನ್ನು ಮಿತಿಗೊಳಿಸಿ
                .temperature(0.7)                // ಸೃಜನಶೀಲತೆಯನ್ನು ನಿಯಂತ್ರಿಸಿ (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // API ಫಲಿತಾಂಶದಿಂದ AI ಪ್ರತಿಸ್ಪಂದನೆಯನ್ನು ಹೊರತೆಗೆದುಕೊಳ್ಳಿ
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```


**ಇದು ಏನು ಮಾಡುತ್ತದೆ:**
- **ChatCompletionCreateParams**: ಎಐ ವಿನಂತಿಯನ್ನು ಕಾನ್ಫಿಗರ್ ಮಾಡುತ್ತದೆ
  - `model`: ಯಾವ ಎಐ ಮಾದರಿಯನ್ನು ಬಳಸಬೇಕೆಂದು ನಿರ್ಧರಿಸುತ್ತದೆ (ಅದು `foundry model list` ನಿಂದ ನಿಖರವಾದ ಐಡಿಯನ್ನು ಹೊಂದಿರಬೇಕು)
  - `addUserMessage`: ನಿಮ್ಮ ಸಂದೇಶವನ್ನು ಸಂಭಾಷಣೆಗೆ ಸೇರಿಸುತ್ತದೆ
  - `maxCompletionTokens`: ಪ್ರತಿಕ್ರಿಯೆಯ ಉದ್ದವನ್ನು ಮಿತಿಗೊಳಿಸುತ್ತದೆ (ಸಂಪತ್ತುಗಳನ್ನು ಉಳಿಸುತ್ತದೆ)
  - `temperature`: ಯಾದೃಚ್ಛಿಕತೆಯನ್ನು ನಿಯಂತ್ರಿಸುತ್ತದೆ (0.0 = ನಿರ್ಧಾರಾತ್ಮಕ, 1.0 = ಸೃಜನಶೀಲ)
- **API ಕರೆ**: ಫೌಂಡ್ರಿ ಲೋಕಲ್‌ಗೆ ವಿನಂತಿಯನ್ನು ಕಳುಹಿಸುತ್ತದೆ
- **ಪ್ರತಿಕ್ರಿಯೆ ಹ್ಯಾಂಡ್ಲಿಂಗ್**: ಎಐನ ಪಠ್ಯ ಪ್ರತಿಕ್ರಿಯೆಯನ್ನು ಸುರಕ್ಷಿತವಾಗಿ ಹೊರತೆಗೆದುಕೊಳ್ಳುತ್ತದೆ
- **ದೋಷ ನಿರ್ವಹಣೆ**: ಸಹಾಯಕ ದೋಷ ಸಂದೇಶಗಳೊಂದಿಗೆ ಅಪವಾದಗಳನ್ನು ಸುತ್ತುತ್ತದೆ

### 4. ಪ್ರಾಜೆಕ್ಟ್ ಅವಲಂಬನೆಗಳು (pom.xml)

**ಮುಖ್ಯ ಅವಲಂಬನೆಗಳು:**

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


**ಇವು ಏನು ಮಾಡುತ್ತವೆ:**
- **spring-boot-starter**: ಮೂಲ ಸ್ಪ್ರಿಂಗ್ ಬೂಟ್ ಕಾರ್ಯಕ್ಷಮತೆಯನ್ನು ಒದಗಿಸುತ್ತದೆ
- **openai-java**: API ಸಂವಹನಕ್ಕಾಗಿ ಅಧಿಕೃತ OpenAI ಜಾವಾ SDK
- **jackson-databind**: API ಕರೆಗಳಿಗೆ JSON ಸರಳೀಕರಣ/ಅಸರಳೀಕರಣವನ್ನು ನಿರ್ವಹಿಸುತ್ತದೆ

## ಎಲ್ಲವೂ ಹೇಗೆ ಕೆಲಸ ಮಾಡುತ್ತದೆ

ನೀವು ಅಪ್ಲಿಕೇಶನ್ ಅನ್ನು ರನ್ ಮಾಡಿದಾಗ ಸಂಪೂರ್ಣ ಪ್ರಕ್ರಿಯೆ ಹೀಗಿದೆ:

1. **ಪ್ರಾರಂಭ**: ಸ್ಪ್ರಿಂಗ್ ಬೂಟ್ ಪ್ರಾರಂಭವಾಗುತ್ತದೆ ಮತ್ತು `application.properties` ಅನ್ನು ಓದುತ್ತದೆ
2. **ಸರ್ವೀಸ್ ರಚನೆ**: ಸ್ಪ್ರಿಂಗ್ `FoundryLocalService` ಅನ್ನು ರಚಿಸುತ್ತದೆ ಮತ್ತು ಕಾನ್ಫಿಗರೇಶನ್ ಮೌಲ್ಯಗಳನ್ನು ಇಂಜೆಕ್ಟ್ ಮಾಡುತ್ತದೆ
3. **ಕ್ಲೈಂಟ್ ಸೆಟಪ್**: `@PostConstruct` OpenAI ಕ್ಲೈಂಟ್ ಅನ್ನು ಫೌಂಡ್ರಿ ಲೋಕಲ್‌ಗೆ ಸಂಪರ್ಕಿಸಲು ಪ್ರಾರಂಭಿಸುತ್ತದೆ
4. **ಡೆಮೋ ಕಾರ್ಯಗತಗೊಳನೆ**: `CommandLineRunner` ಪ್ರಾರಂಭದ ನಂತರ ಕಾರ್ಯಗತಗೊಳ್ಳುತ್ತದೆ
5. **ಎಐ ಕರೆ**: ಡೆಮೋ ಪರೀಕ್ಷಾ ಸಂದೇಶದೊಂದಿಗೆ `foundryLocalService.chat()` ಅನ್ನು ಕರೆ ಮಾಡುತ್ತದೆ
6. **API ವಿನಂತಿ**: ಸರ್ವೀಸ್ OpenAI ಹೊಂದಾಣಿಕೆಯಾಗಿರುವ ವಿನಂತಿಯನ್ನು ಫೌಂಡ್ರಿ ಲೋಕಲ್‌ಗೆ ಕಳುಹಿಸುತ್ತದೆ
7. **ಪ್ರತಿಕ್ರಿಯೆ ಪ್ರಕ್ರಿಯೆ**: ಸರ್ವೀಸ್ ಪ್ರತಿಕ್ರಿಯೆಯನ್ನು ಹೊರತೆಗೆದುಕೊಳ್ಳುತ್ತದೆ ಮತ್ತು ಹಿಂತಿರುಗಿಸುತ್ತದೆ
8. **ಪ್ರದರ್ಶನ**: ಅಪ್ಲಿಕೇಶನ್ ಪ್ರತಿಕ್ರಿಯೆಯನ್ನು ಮುದ್ರಿಸುತ್ತದೆ ಮತ್ತು ನಿರ್ಗಮಿಸುತ್ತದೆ

## ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಅನ್ನು ಸೆಟ್ ಅಪ್ ಮಾಡುವುದು

ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಅನ್ನು ಸೆಟ್ ಅಪ್ ಮಾಡಲು ಈ ಹಂತಗಳನ್ನು ಅನುಸರಿಸಿ:

1. **ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಅನ್ನು ಇನ್‌ಸ್ಟಾಲ್ ಮಾಡಿ** [ಪೂರ್ವಶರತ್ತುಗಳು](../../../../04-PracticalSamples/foundrylocal) ವಿಭಾಗದ ಸೂಚನೆಗಳನ್ನು ಅನುಸರಿಸಿ.

2. **ಡೈನಾಮಿಕ್ ಅಸೈನ್ ಮಾಡಿದ ಪೋರ್ಟ್ ಅನ್ನು ಪರಿಶೀಲಿಸಿ**. ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಪ್ರಾರಂಭವಾದಾಗ ಸ್ವಯಂಚಾಲಿತವಾಗಿ ಪೋರ್ಟ್ ಅನ್ನು ಅಸೈನ್ ಮಾಡುತ್ತದೆ. ನಿಮ್ಮ ಪೋರ್ಟ್ ಅನ್ನು ಕಂಡುಹಿಡಿಯಲು:
   ```bash
   foundry service status
   ```
   
   **ಐಚ್ಛಿಕ**: ನೀವು ನಿರ್ದಿಷ್ಟ ಪೋರ್ಟ್ ಅನ್ನು ಬಳಸಲು ಬಯಸಿದರೆ (ಉದಾ., 5273), ನೀವು ಅದನ್ನು ಕೈಯಾರೆ ಕಾನ್ಫಿಗರ್ ಮಾಡಬಹುದು:
   ```bash
   foundry service set --port 5273
   ```


3. **ನೀವು ಬಳಸಲು ಬಯಸುವ ಎಐ ಮಾದರಿಯನ್ನು ಡೌನ್‌ಲೋಡ್ ಮಾಡಿ**, ಉದಾಹರಣೆಗೆ, `phi-3.5-mini`, ಈ ಕೆಳಗಿನ ಕಮಾಂಡ್‌ನೊಂದಿಗೆ:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **application.properties ಫೈಲ್ ಅನ್ನು ನಿಮ್ಮ ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಸೆಟ್ಟಿಂಗ್‌ಗಳಿಗೆ ಹೊಂದಿಸಿ**:
   - `base-url` ನಲ್ಲಿ ಪೋರ್ಟ್ ಅನ್ನು (ಹಂತ 2 ರಿಂದ) ನವೀಕರಿಸಿ, ಇದು `/v1` ಅನ್ನು ಅಂತ್ಯದಲ್ಲಿ ಒಳಗೊಂಡಿರುತ್ತದೆ
   - `foundry model list` ಬಳಸಿ ಮಾದರಿಯ ಹೆಸರನ್ನು ಆವೃತ್ತಿ ಸಂಖ್ಯೆಯನ್ನು ಒಳಗೊಂಡಂತೆ ನವೀಕರಿಸಿ
   
   ಉದಾಹರಣೆ:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## ಅಪ್ಲಿಕೇಶನ್ ಅನ್ನು ರನ್ ಮಾಡುವುದು

### ಹಂತ 1: ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಪ್ರಾರಂಭಿಸಿ
```bash
foundry model run phi-3.5-mini
```


### ಹಂತ 2: ಅಪ್ಲಿಕೇಶನ್ ಅನ್ನು ಬಿಲ್ಡ್ ಮಾಡಿ ಮತ್ತು ರನ್ ಮಾಡಿ
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```


## ನಿರೀಕ್ಷಿತ ಔಟ್‌ಪುಟ್

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


## ಮುಂದಿನ ಹಂತಗಳು

ಹೆಚ್ಚಿನ ಉದಾಹರಣೆಗಳಿಗಾಗಿ, [ಅಧ್ಯಾಯ 04: ಪ್ರಾಯೋಗಿಕ ಮಾದರಿಗಳು](../README.md) ನೋಡಿ

## ತೊಂದರೆ ಪರಿಹಾರ

### ಸಾಮಾನ್ಯ ಸಮಸ್ಯೆಗಳು

**"ಕನೆಕ್ಷನ್ ರಿಫ್ಯೂಜ್ಡ್" ಅಥವಾ "ಸರ್ವೀಸ್ ಅನವೈಲಬಲ್"**
- ಫೌಂಡ್ರಿ ಲೋಕಲ್ ರನ್ ಆಗುತ್ತಿದೆ ಎಂದು ಖಚಿತಪಡಿಸಿಕೊಳ್ಳಿ: `foundry model list`
- ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಬಳಸುತ್ತಿರುವ ನಿಜವಾದ ಪೋರ್ಟ್ ಅನ್ನು ಪರಿಶೀಲಿಸಿ: `foundry service status`
- ನಿಮ್ಮ `application.properties` ಅನ್ನು ಸರಿಯಾದ ಪೋರ್ಟ್‌ನೊಂದಿಗೆ ನವೀಕರಿಸಿ, URL `/v1` ನಲ್ಲಿ ಅಂತ್ಯಗೊಳ್ಳುವಂತೆ ಖಚಿತಪಡಿಸಿಕೊಳ್ಳಿ
- ಐಚ್ಛಿಕವಾಗಿ, ನಿರ್ದಿಷ್ಟ ಪೋರ್ಟ್ ಅನ್ನು ಸೆಟ್ ಮಾಡಿ: `foundry service set --port 5273`
- ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಅನ್ನು ಮರುಪ್ರಾರಂಭಿಸಲು ಪ್ರಯತ್ನಿಸಿ: `foundry model run phi-3.5-mini`

**"ಮಾದರಿ ಕಂಡುಬಂದಿಲ್ಲ" ಅಥವಾ "404 ನಾಟ್ ಫೌಂಡ್" ದೋಷಗಳು**
- ನಿಖರವಾದ ಐಡಿಗಳೊಂದಿಗೆ ಲಭ್ಯವಿರುವ ಮಾದರಿಗಳನ್ನು ಪರಿಶೀಲಿಸಿ: `foundry model list`
- `application.properties` ನಲ್ಲಿ ಮಾದರಿಯ ಹೆಸರನ್ನು ನಿಖರವಾಗಿ ನವೀಕರಿಸಿ, ಆವೃತ್ತಿ ಸಂಖ್ಯೆಯನ್ನು ಒಳಗೊಂಡಂತೆ (ಉದಾ., `Phi-3.5-mini-instruct-cuda-gpu:1`)
- `base-url` `/v1` ನಲ್ಲಿ ಅಂತ್ಯಗೊಳ್ಳುವಂತೆ ಖಚಿತಪಡಿಸಿಕೊಳ್ಳಿ: `http://localhost:5273/v1`
- ಅಗತ್ಯವಿದ್ದರೆ ಮಾದರಿಯನ್ನು ಡೌನ್‌ಲೋಡ್ ಮಾಡಿ: `foundry model run phi-3.5-mini`

**"400 ಬ್ಯಾಡ್ ರಿಕ್ವೆಸ್ಟ್" ದೋಷಗಳು**
- ಬೇಸ್ URL `/v1` ಅನ್ನು ಒಳಗೊಂಡಿದೆ ಎಂದು ಖಚಿತಪಡಿಸಿಕೊಳ್ಳಿ: `http://localhost:5273/v1`
- ಮಾದರಿ ಐಡಿ `foundry model list` ನಲ್ಲಿ ತೋರಿಸಿದ ನಿಖರವಾದ ಐಡಿಯನ್ನು ಹೊಂದಿದೆ ಎಂದು ಪರಿಶೀಲಿಸಿ
- ನಿಮ್ಮ ಕೋಡ್‌ನಲ್ಲಿ `maxCompletionTokens()` ಅನ್ನು ಬಳಸುತ್ತಿರುವುದನ್ನು ಖಚಿತಪಡಿಸಿಕೊಳ್ಳಿ (ಹಳೆಯ `maxTokens()` ಅನ್ನು ಬಳಸಬೇಡಿ)

**ಮೇವನ್ ಸಂಗ್ರಹಣಾ ದೋಷಗಳು**
- ಜಾವಾ 21 ಅಥವಾ ಹೆಚ್ಚಿನ ಆವೃತ್ತಿ: `java -version`
- ಕ್ಲೀನ್ ಮಾಡಿ ಮತ್ತು ಮರುಬಿಲ್ಡ್ ಮಾಡಿ: `mvn clean compile`
- ಅವಲಂಬನೆ ಡೌನ್‌ಲೋಡ್‌ಗಳಿಗೆ ಇಂಟರ್ನೆಟ್ ಸಂಪರ್ಕವನ್ನು ಪರಿಶೀಲಿಸಿ

**ಅಪ್ಲಿಕೇಶನ್ ಪ್ರಾರಂಭವಾಗುತ್ತದೆ ಆದರೆ ಔಟ್‌ಪುಟ್ ಇಲ್ಲ**
- ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಪ್ರತಿಕ್ರಿಯಿಸುತ್ತಿದೆಯೇ ಎಂದು ಪರಿಶೀಲಿಸಿ: `http://localhost:5273/v1/models` ಅನ್ನು ಪರಿಶೀಲಿಸಿ ಅಥವಾ `foundry service status` ಅನ್ನು ರನ್ ಮಾಡಿ
- ನಿರ್ದಿಷ್ಟ ದೋಷ ಸಂದೇಶಗಳಿಗಾಗಿ ಅಪ್ಲಿಕೇಶನ್ ಲಾಗ್‌ಗಳನ್ನು ಪರಿಶೀಲಿಸಿ
- ಮಾದರಿ ಸಂಪೂರ್ಣವಾಗಿ ಲೋಡ್ ಆಗಿದೆ ಮತ್ತು ಸಿದ್ಧವಾಗಿದೆ ಎಂದು ಖಚಿತಪಡಿಸಿಕೊಳ್ಳಿ

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ಅಸಮಾಕ್ಷ್ಯತೆ**:  
ಈ ದಸ್ತಾವೇಜನ್ನು AI ಅನುವಾದ ಸೇವೆ [Co-op Translator](https://github.com/Azure/co-op-translator) ಬಳಸಿ ಅನುವಾದಿಸಲಾಗಿದೆ. ನಾವು ನಿಖರತೆಯನ್ನು ಸಾಧಿಸಲು ಪ್ರಯತ್ನಿಸುತ್ತಿದ್ದರೂ, ದಯವಿಟ್ಟು ಗಮನಿಸಿ, ಸ್ವಯಂಚಾಲಿತ ಅನುವಾದಗಳಲ್ಲಿ ತಪ್ಪುಗಳು ಅಥವಾ ಅಸಡ್ಡೆಗಳು ಇರಬಹುದು. ಮೂಲ ಭಾಷೆಯಲ್ಲಿರುವ ಮೂಲ ದಸ್ತಾವೇಜು ಪ್ರಾಮಾಣಿಕ ಮೂಲವೆಂದು ಪರಿಗಣಿಸಬೇಕು. ಮಹತ್ವದ ಮಾಹಿತಿಗಾಗಿ, ವೃತ್ತಿಪರ ಮಾನವ ಅನುವಾದವನ್ನು ಶಿಫಾರಸು ಮಾಡಲಾಗುತ್ತದೆ. ಈ ಅನುವಾದವನ್ನು ಬಳಸುವ ಮೂಲಕ ಉಂಟಾಗುವ ಯಾವುದೇ ತಪ್ಪು ಅರ್ಥಗಳು ಅಥವಾ ತಪ್ಪು ವ್ಯಾಖ್ಯಾನಗಳಿಗೆ ನಾವು ಹೊಣೆಗಾರರಲ್ಲ.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->