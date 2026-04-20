# ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಸ್ಪ್ರಿಂಗ್ ಬೂಟ್ ಟ್ಯುಟೋರಿಯಲ್

## ವಿಷಯಗಳ ಟೇಬಲ್

- [ಆವಶ್ಯಕತೆಗಳು](#ಆವಶ್ಯಕತೆಗಳು)
- [ಪ್ರಾಜೆಕ್ಟ್ ಅವಲೋಕನ](#ಪ್ರಾಜೆಕ್ಟ್-ಅವಲೋಕನ)
- [ಕೋಡ್ ಅర్థಮಾಡಿಕೊಳ್ಳುವುದು](#ಕೋಡ್-ಅರ್ಥಮಾಡಿಕೊಳ್ಳುವುದು)
  - [1. ಅಪ್ಲಿಕೇಶನ್ ಕಾನ್ಫಿಗರೇಶನ್ (application.properties)](#1-ಅಪ್ಲಿಕೇಶನ್-ಕಾನ್ಫಿಗರೇಶನ್-applicationproperties)
  - [2. ಮುಖ್ಯ ಅಪ್ಲಿಕೇಶನ್ ಕ್ಲಾಸ್ (Application.java)](#2-ಮುಖ್ಯ-ಅಪ್ಲಿಕೇಶನ್-ಕ್ಲಾಸ್-applicationjava)
  - [3. AI ಸರ್ವಿಸ್ ಲೇಯರ್ (FoundryLocalService.java)](#3-ai-ಸರ್ವಿಸ್-ಲೇಯರ್-foundrylocalservicejava)
  - [4. ಪ್ರಾಜೆಕ್ಟ್ ಅವಲಂಬನೆಗಳು (pom.xml)](#4-ಪ್ರಾಜೆಕ್ಟ್-ಅವಲಂಬನೆಗಳು-pomxml)
- [ಎಲ್ಲವೂ ಹೇಗೆ ಒಂದಾಗಿ ಕಾರ್ಯನಿರ್ವಹಿಸುತ್ತದೆ](#ಎಲ್ಲವೂ-ಹೇಗೆ-ಒಂದಾಗಿ-ಕಾರ್ಯನಿರ್ವಹಿಸುತ್ತದೆ)
- [ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಸ್ಥಾಪಿಸುವುದು](#ಫೌಂಡ್ರಿ-ಲೋಕಲ್-ಸ್ಥಾಪಿಸುವುದು)
- [ಅಪ್ಲಿಕೇಶನ್ ಓಡಿಸುವುದು](#ಅಪ್ಲಿಕೇಶನ್-ಓಡಿಸುವುದು)
- [ನಿರೀಕ್ಷಿತ ಔಟ್ಪುಟ್](#ನಿರೀಕ್ಷಿತ-ಔಟ್ಪುಟ್)
- [ಮುಂದಿನ ಹಂತಗಳು](#ಮುಂದಿನ-ಹಂತಗಳು)
- [ಸಮಸ್ಯೆ ಪರಿಹಾರ](#ಸಮಸ್ಯೆ-ಪರಿಹಾರ)


## ಆವಶ್ಯಕತೆಗಳು

ಈ ಟ್ಯುಟೋರಿಯಲ್ ಪ್ರಾರಂಭಿಸುವ ಮೊದಲು, ಖಚಿತಪಡಿಸಿಕೊಳ್ಳಿ ನಿಮಗೆ:

- **ಜAVA 21 ಅಥವಾ ಅದಕ್ಕಿಂತ ಮೇಲಿನ** ಆಗಿರುವುದು
- **ಮೇವನ್ 3.6+** ಪ್ರಾಜೆಕ್ಟ್ ನಿರ್ಮಿಸಲು
- **ಫೌಂಡ್ರಿ ಲೋಕಲ್** ಸ್ಥಾಪಿಸಲಾಗಿದ್ದು, ಕಾರ್ಯನಿರ್ವಹಿಸುತ್ತಿದೆ

### **ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಸ್ಥಾಪನೆ:**

> **ಗಮನಿಸಿ:** ಫೌಂಡ್ರಿ ಲೋಕಲ್ CLI ಕೇವಲ **ವಿಂಡೋಸ್** ಮತ್ತು **ಮ್ಯಾಕ್‌ಓಎಸ್** ಗಾಗಿ ಲಭ್ಯವಿದೆ. ಲಿನಕ್ಸ್ನಲ್ಲಿ [ಫೌಂಡ್ರಿ ಲೋಕಲ್ SDKಗಳು](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust) ಮೂಲಕ ಬೆಂಬಲವಿದೆ.

```bash
# ವಿಂಡೋಸ್
winget install Microsoft.FoundryLocal

# ಮ್ಯಾಕ್‌ಒಎಸ್
brew tap microsoft/foundrylocal
brew install foundrylocal
```

ಸ್ಥಾಪನೆಯನ್ನು ಪರಿಶೀಲಿಸಿ:
```bash
foundry --version
```

## ಪ್ರಾಜೆಕ್ಟ್ ಅವಲೋಕನ

ಈ ಪ್ರಾಜೆಕ್ಟ್ ನಾಲ್ಕು ಮುಖ್ಯ ಘಟಕಗಳನ್ನು ಹೊಂದಿದೆ:

1. **Application.java** - ಮುಖ್ಯ ಸ್ಪ್ರಿಂಗ್ ಬೂಟ್ ಅಪ್ಲಿಕೇಶನ್ ಎಂಟ್ರಿ point
2. **FoundryLocalService.java** - AI ಸಂವಹನವನ್ನು ನಿಭಾಯಿಸುವ ಸರ್ವಿಸ್ ಲೇಯರ್
3. **application.properties** - ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಸಂಪರ್ಕಕ್ಕಾಗಿ ಕಾನ್ಫಿಗರೇಶನ್
4. **pom.xml** - ಮೇವನ ಅವಲಂಬನೆಗಳು ಮತ್ತು ಪ್ರಾಜೆಕ್ಟ್ ಕಾನ್ಫಿಗರೇಶನ್

## ಕೋಡ್ ಅರ್ಥಮಾಡಿಕೊಳ್ಳುವುದು

### 1. ಅಪ್ಲಿಕೇಶನ್ ಕಾನ್ಫಿಗರೇಶನ್ (application.properties)

**ಫೈಲ್:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**ಇದರಿಂದ ಏನು ಆಗುತ್ತದೆ:**
- **base-url**: ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಎಲ್ಲೆಡೆ ನಡೆಯುತ್ತಿದೆ ಎಂದು ಸೂಚಿಸುತ್ತದೆ, OpenAI API್ತು ಆಸ್ಥಾನಕ್ಕಾಗಿ `/v1` ಮಾರ್ಗವನ್ನು ಒಳಗೊಂಡಿದೆ. ಡೀಫಾಲ್ಟ್ ಪೋರ್ಟ್ `5273`. ಪೋರ್ಟ್ ಬದಲಾಗಿದೆ ಎಂದಾದ್ರೆ, `foundry service status` ಮೂಲಕ ಚೆಕ್ ಮಾಡಿ.
- **model** (ಐಚ್ಛಿಕ): ಪಠ್ಯ ರಚನೆಗಾಗಿ ಉಪಯೋಗಿಸುವ AI ಮಾದರಿಯ ಹೆಸರನ್ನು ಸೂಚಿಸುತ್ತದೆ. **ಮೂಲವಾಗಿ ಈ ಅಪ್ಲಿಕೇಶನ್ ಸ್ವಯಂಚಾಲಿತವಾಗಿ ಮಾದರಿಯನ್ನು ಕಂಡುಹಿಡಿಯುತ್ತದೆ** ಫೌಂಡ್ರಿ ಲೋಕಲ್ `/v1/models` ಎಂಡ್ಪಾಯಿಂಟ್ ನ್ನು ಪ್ರಾರಂಭದಲ್ಲಿ ಕ್ವೇರಿ ಮಾಡುವ ಮೂಲಕ, ಆದ್ದರಿಂದ ನೀವು ಇದನ್ನು ಹೊಂದಿಸಬೇಕಾಗೊ ಎಲ್ಲ. ಇಚ್ಛಿಸಿದರೆ ಸ್ಪಷ್ಟವಾಗಿ ಹೊಂದಿಸಬಹುದು ಆವಶ್ಯಕತೆ ಇದ್ದರೆ ಸ್ವಯಂಚಾಲಿತ ಪರಿಶೀಲನೆಯನ್ನು ಮೀರಿಸುವಿಕೆಗೆ.

**ಮುಖ್ಯ ಅರ್ಥ:** ಸ್ಪ್ರಿಂಗ್ ಬೂಟ್ ಈ ಗುಣಲಕ್ಷಣಗಳನ್ನು ಸ್ವಯಂ ಲೋಡ್ ಮಾಡಿ `@Value` ಟ್ಯಾಗ್ ಮೂಲಕ ನಿಮ್ಮ ಅಪ್ಲಿಕೇಷನ್‌ಗೆ ಲಭ್ಯವಾಗಿಸುವುದು.

### 2. ಮುಖ್ಯ ಅಪ್ಲಿಕೇಶನ್ ಕ್ಲಾಸ್ (Application.java)

**ಫೈಲ್:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // ಯಾವುದೇ ವೆಬ್ ಸರ್ವರ್ ಅಗತ್ಯವಿಲ್ಲ
        app.run(args);
    }
```

**ಇದರಿಂದ ಏನು ಆಗುತ್ತದೆ:**
- `@SpringBootApplication` ಸ್ಪ್ರಿಂಗ್ ಬೂಟ್ ಸ್ವಯಂ ಕಾನ್ಫಿಗರೇಶನ್ ಸಕ್ರಿಯಗೊಳಿಸುತ್ತದೆ
- `WebApplicationType.NONE` ಸ್ಪ್ರಿಂಗ್‌ಗೆ ಇದು ಕಮಾಂಡ್ ಲೈನ್ ಅಪ್ಲಿಕೇಶನ್ ಮತ್ತು ವೆಬ್ ಸರ್ವರ್ ಅಲ್ಲ ಎಂದು ಹೇಳುತ್ತದೆ
- ಮುಖ್ಯ ಮಥೋಡ್ ಸ್ಪ್ರಿಂಗ್ ಅಪ್ಲಿಕೇಶನ್ ಆರಂಭಿಸುತ್ತದೆ

**ಡೆಮೊ ರನ್ನರ್:**
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

**ಇದರಿಂದ ಏನು ಆಗುತ್ತದೆ:**
- `@Bean` ಸ್ಪ್ರಿಂಗ್ ನಿರ್ವಹಿಸುವ ಕಾಂಪೋನೆಂಟ್ ಸೃಷ್ಟಿಸುತ್ತದೆ
- `CommandLineRunner` ಸ್ರ್ಪಿಂಗ್ ಬೂಟ್ ಆರಂಭಿಸಿದ ನಂತರ ಕೋಡ್ ರನ್ ಮಾಡುತ್ತದೆ
- `foundryLocalService` ಸ್ವಯಂಚಾಲಿತವಾಗಿ ಸ್ಪ್ರಿಂಗ್ ಮೂಲಕ ಇಂಜೆಕ್ಟ್ ಆಗುತ್ತದೆ (ಡಿಪೆಂಡೆನ್ಸಿ ಬಳಕೆ)
- AIಗೆ ಟೆಸ್ಟ್ ಸಂದೇಶ ಕಳುಹಿಸಿ ಪ್ರತಿಕ್ರಿಯೆ ಪ್ರದರ್ಶಿಸುತ್ತದೆ

### 3. AI ಸರ್ವಿಸ್ ಲೇಯರ್ (FoundryLocalService.java)

**ಫೈಲ್:** `src/main/java/com/example/FoundryLocalService.java`

#### ಕಾನ್ಫಿಗರೇಶನ್ ಇಂಜೆಕ್ಷನ್:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // ಖಾಲಿ ಆಗಿದ್ದರೆ ಸ್ವಯಂ ಪತ್ತೆಮಾಡಿತು
```

**ಇದರಿಂದ ಏನು ಆಗುತ್ತದೆ:**
- `@Service` ಸ್ಪ್ರಿಂಗ್‌ಗೆ ಈ ಕ್ಲಾಸ್ ವ್ಯಾಪಾರ ಲಾಜಿಕ್ ನೀಡುತ್ತದೆ ಎಂದು ಹೇಳುತ್ತದೆ
- `@Value` application.properties ನಿಂದ ಕಾನ್ಫಿಗರೇಶನ್ ಮೌಲ್ಯಗಳನ್ನು ಇಂಜೆಕ್ಟ್ ಮಾಡುತ್ತದೆ
- ಮಾದರಿ ನಿರ್ಮಿತವಾಗದಿದ್ದಲ್ಲಿ, ಇದು ಡೀಫಾಲ್ಟ್ ಖಾಲಿ ಆಗಿದ್ದು, ಪ್ರಾರಂಭದಲ್ಲಿ ಫೌಂಡ್ರಿ ಲೋಕಲ್‌ನಿಂದ **ಸ್ವಯಂಚಾಲಿತವಾಗಿ** ಪತ್ತೆಹಚ್ಚುತ್ತದೆ. ಇದರರ್ಥ ಅಪ್ಲಿಕೇಶನ್ ಯಾವುದೇ ಫೌಂಡ್ರಿ ಲೋಕಲ್ ನಲ್ಲಿ ಲೋಡ್ ಆಗಿರುವ ಮಾದರಿಯಿಂದ ಯಾವುದೇ ಮ್ಯಾನುಯಲ್ ಅಳವಡಿಕೆ ಇಲ್ಲದೆ ಕೆಲಸ ಮಾಡುತ್ತದೆ.

#### ಕ್ಲೈಂಟ್ ಪ್ರಾರಂಭ:
```java
@PostConstruct
public void init() {
    // ಸ್ಪಷ್ಟವಾಗಿ ಹೊಂದಿಸಲಾಗದಿದ್ದರೆ Foundry Local ನಿಂದ ಮಾದರಿಯನ್ನು ಸ್ವಯಂ ಪತ್ತೆ ಮಾಡಿ
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // ಮೂಲ URL ಈಗಾಗಲೇ ಸಂರಚನೆಯಿಂದ /v1 ಅನ್ನು ಒಳಗೊಂಡಿದೆ
            .apiKey("not-needed")            // ಸ್ಥಳೀಯ ಸರ್ವರ್‌ಗೆ ನಿಜವಾದ API ಕೀ ಅಗತ್ಯವಿಲ್ಲ
            .build();
}
```

**ಇದರಿಂದ ಏನು ಆಗುತ್ತದೆ:**
- `@PostConstruct` ಸರ್ವಿಸ್ ಸೃಷ್ಟಿಯಾದ ನಂತರ ಈ ವಿಧಾನ ಚಲಿಸುತ್ತದೆ
- ಯಾವುದೇ ಮಾದರಿ ಹೊಂದಿಸಲಾಗದಿದ್ದರೆ, ಫೌಂಡ್ರಿ ಲೋಕಲ್ `/v1/models` ಎಂಡ್ಪಾಯಿಂಟ್ ಅನ್ನು ಕ್ವೇರಿ ಮಾಡಿ ಮೊದಲ ಲೋಡ್ ಆಗಿರುವ ಮಾದರಿಯನ್ನು ಆರಿಸಿಕೊಳ್ಳುತ್ತದೆ
- ನಿಮ್ಮ ಲೋಕಲ್ ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಘಟಕದೊಂದಿಗೆ ಸಂಪರ್ಕಿಸಲು OpenAI ಕ್ಲೈಂಟ್ ಸೃಷ್ಟಿಸುತ್ತದೆ
- `application.properties` ನ ಬೇಟೆ URL ಈಗಾಗಲೇ OpenAI API ಸಮ್ಮತಿಯಿಗಾಗಿ `/v1` ಅನ್ನು ಒಳಗೊಂಡಿದೆ
- API ಕೀ "not-needed" ಆಗಿದೆ ಏಕೆಂದರೆ ಲೋಕಲ್ ಡೆವಲಪ್ಮೆಂಟ್ ಅನ್ನು ಪ್ರಾಮಾಣೀಕರಣ ಅಗತ್ಯವಿಲ್ಲ

#### ಚಾಟ್ ವಿಧಾನ:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // ಯಾವ AI ಮಾದರಿಯನ್ನು ಬಳಸಬೇಕು
                .addUserMessage(message)         // ನಿಮ್ಮ ಪ್ರಶ್ನೆ/ಪ್ರಾಂಪ್ಟ್
                .maxCompletionTokens(150)        // ಪ್ರತಿಕ್ರಿಯೆಯ ಉದ್ದವನ್ನು ಮಿತಿಗೊಳಿಸಿ
                .temperature(0.7)                // ಸೃಜನಶೀಲತೆಯನ್ನು ನಿಯಂತ್ರಿಸಿ (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // API ಫಲಿತಾಂಶದಿಂದ AI ಪ್ರತಿಕ್ರಿಯೆಯನ್ನು ತೆಗೆಯಿರಿ
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**ಇದರಿಂದ ಏನು ಆಗುತ್ತದೆ:**
- **ChatCompletionCreateParams**: AI ವಿನಂತಿಯನ್ನು ಕಾನ್ಫಿಗರ್ ಮಾಡುತ್ತದೆ
  - `model`: ಯಾವ AI ಮಾದರಿಯನ್ನು ಉಪಯೋಗಿಸುವುದೆಂದು ಸೂಚಿಸುತ್ತದೆ (ನಿಖರ ID `foundry model list` ನಿಂದ ಹೊಂದಿರಬೇಕು)
  - `addUserMessage`: ನಿಮ್ಮ ಸಂದೇಶವನ್ನು ಸಂಭಾಷಣೆಗೆ ಸೇರಿಸುತ್ತದೆ
  - `maxCompletionTokens`: ಪ್ರತಿಕ್ರಿಯೆಯ ಗರಿಷ್ಠ ಉದ್ದವನ್ನು ನಿರ್ಧರಿಸುತ್ತದೆ (ಸಂಪನ್ಮೂಲ ಸಂರಕ್ಷಣೆ)
  - `temperature`: ಯಾದೃಚ್ಛಿಕತೆಯನ್ನು ನಿಯಂತ್ರಿಸುತ್ತದೆ (0.0 = ನಿರ್ಧಾರಾತ್ಮಕ, 1.0 = ಸೃಜನಾತ್ಮಕ)
- **API ಕರೆದಿದೆ**: ವಿನಂತಿಯನ್ನು ಫೌಂಡ್ರಿ ಲೋಕಲ್‌ಗೆ ಕಳುಹಿಸುತ್ತದೆ
- **ಪ್ರತಿಕ್ರಿಯೆ ನಿರ್ವಹಣೆ**: AI ತಯಾರಿಸಿದ ಪಠ್ಯವನ್ನು ಸುರಕ್ಷಿತವಾಗಿ ತೆಗೆದುಕೊಳ್ಳುತ್ತದೆ
- **ದೋಷ ನಿರ್ವಹಣೆ**: ಉಪಯುಕ್ತ ದೋಷ ಸಂದೇಶಗಳೊಂದಿಗೆ ಹೊರತಾಗುವ ಅನಂತರಗಳನ್ನು ಮುಚ್ಚುತ್ತದೆ

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
- **spring-boot-starter**: ಸೂಕ್ಷ್ಮ ಸ್ಪ್ರಿಂಗ್ ಬೂಟ್ ಕಾರ್ಯಾಚರಣೆಗಾಗಿಯುವ ಮೂಲ ವಿಭಾಗಗಳನ್ನು ಒದಗಿಸುತ್ತದೆ
- **openai-java**: ಅಧಿಕೃತ OpenAI ಜಾವಾ SDK API ಸಂವಹನಕ್ಕಾಗಿ
- **jackson-databind**: API ಕರೆಗಳಿಗೆ JSON ಸರಣೀಕರಣ/ಅನ್ಸರಣೆಯನ್ನು ನಿಭಾಯಿಸುತ್ತದೆ

## ಎಲ್ಲವೂ ಹೇಗೆ ಒಂದಾಗಿ ಕಾರ್ಯನಿರ್ವಹಿಸುತ್ತದೆ

ನೀವು ಅಪ್ಲಿಕೇಶನ್ ಓಡಿಸಿದಾಗ ಪೂರಕ ಪ್ರವಾಹ ಇಲ್ಲಿದೆ:

1. **ಪ್ರಾರಂಭ**: ಸ್ಪ್ರಿಂಗ್ ಬೂಟ್ ಚಾಲನೆ ಆಗಿ `application.properties` ಓದುತ್ತದೆ
2. **ಸರ್ವಿಸ್ ಸೃಷ್ಟಿ**: ಸ್ಪ್ರಿಂಗ್ `FoundryLocalService` ಸೃಷ್ಟಿಸಿ ಕಾನ್ಫಿಗರೇಶನ್ ಮೌಲ್ಯಗಳನ್ನು ಇಂಜೆಕ್ಟ್ ಮಾಡುತ್ತದೆ
3. **ಮಾದರಿ ಪತ್ತೆ**: ಯಾವುದೇ ಮಾದರಿ ಹೊಂದಿಸದಿದ್ದರೆ, ಸರ್ವಿಸ್ ಫೌಂಡ್ರಿ ಲೋಕಲ್ `/v1/models` ಎಂಡ್ಪಾಯಿಂಟ್ ಅನ್ನು ಪ್ರಶ್ನಿಸಿ ಮೊದಲ ಲಭ್ಯವಿರುವ ಮಾದರಿಯನ್ನು ಬಳಕೆ ಮಾಡುತ್ತದೆ
4. **ಕ್ಲೈಂಟ್ ಆಯೋಜನೆ**: `@PostConstruct` OpenAI ಕ್ಲೈಂಟ್ ಅನ್ನು ಫೌಂಡ್ರಿ ಲೋಕಲ್‌ಗೆ ಸಂಪರ್ಕಿಸಲು ಆರಂಭಿಸುತ್ತದೆ
5. **ಡೆಮೊ ಅನುಷ್ಠಾನ**: `CommandLineRunner` ಚಾಲನೆಯಾದ ಮೇಲೆ ಕಾರ್ಯಗತಗೊಳ್ಳುತ್ತದೆ
6. **AI ಕರೆ**: ಡೆಮೋ `foundryLocalService.chat()` ಕರೆ ಮಾಡಿ ಪರೀಕ್ಷಾ ಸಂದೇಶ ಕಳುಹಿಸುತ್ತದೆ
7. **API ವಿನಂತಿ**: ಸರ್ವಿಸ್ OpenAI-ಸಮ್ಮತ ವಿನಂತಿಯನ್ನು ಫೌಂಡ್ರಿ ಲೋಕಲ್‌ಗೆ ಕಳುಹಿಸುತ್ತದೆ
8. **ಪ್ರತಿಕ್ರಿಯೆ ಸಂಸ್ಕರಣೆ**: ಸರ್ವೀಸ್ AI ಪ್ರತಿಕ್ರಿಯೆಯನ್ನು ತೆಗೆದು ಹಿಂತಿರುಗಿಸುತ್ತದೆ
9. **ಪ್ರದರ್ಶನ**: ಅಪ್ಲಿಕೇಶನ್ ಪ್ರತಿಕ್ರಿಯೆಯನ್ನು ಮುದ್ರಣ ಮಾಡಿ ನಿರ್ಗಮಿಸುತ್ತದೆ

## ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಸ್ಥಾಪಿಸುವುದು

1. [ಆವಶ್ಯಕತೆಗಳು](#ಆವಶ್ಯಕತೆಗಳು) ವಿಭಾಗದಲ್ಲಿ ನೀಡಿದ ನಿರ್ದೇಶನಗಳ ಪ್ರಕಾರ ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಅನ್ನು ಸ್ಥಾಪಿಸಿ.

2. **ಸರ್ವಿಸ್ ಆರಂಭಿಸಿ** (ಇನ್ನೂ ಓಡಿಸುತ್ತಿರುವುದಿಲ್ಲವಾದರೆ):
   ```bash
   foundry service start
   ```

3. **ಸರ್ವಿಸ್ ಸ್ಥಿತಿಯನ್ನು ಪರಿಶೀಲಿಸಿ** ಮತ್ತು ಪೋರ್ಟ್ ಗಮನಿಸಿ:
   ```bash
   foundry service status
   ```

4. **ಮಾದರಿ ಡೌನ್ಲೋಡ್ ಮಾಡಿ ಓಡಿಸಿ** (ಮೊದಲ ಬಾರಿ ಡೌನ್ಲೋಡ್ ಆಗುತ್ತದೆ, ನಂತರದಗಾಗಿಯು ಇದೆ):
   ```bash
   foundry model run phi-4-mini
   ```
   ಇದು ಸಕ್ರಿಯ ಚಾಟ್ ಸೆಷನ್ ತೆರೆದಿಡುತ್ತದೆ. ನಿಮ್ಮ ಕೈಯಿಂದ `Ctrl+C` ಇಟ್ಟು ಬಿಡಬಹುದು. ಮಾದರಿ ಸರ್ವಿಸ್ನಲ್ಲಿ ಲೋಡ್ ಆಗಿರುತ್ತದೆ.

   > **ಸೂಚನೆ:** ಎಲ್ಲಾ ಲಭ್ಯವಿರುವ ಮಾದರಿಗಳನ್ನು ನೋಡಲು `foundry model list` ರನ್ ಮಾಡಿ. `phi-4-mini` ಬದಲಿಗೆ ಕ್ಯಾಟಲಾಗ್‌ನ ಯಾವುದೇ ಉಪನಾಮವನ್ನು ಬಳಸಿ (ಉದಾ: `qwen2.5-0.5b` ಚಿಕ್ಕ/ವೇಗದ ಮಾದರಿಗಾಗಿ).

5. **ಮಾದರಿ ಲೋಡ್ ಆಗಿದೆ ಎಂಬುದನ್ನು ಪರಿಶೀಲಿಸಿ:**
   ```bash
   foundry service ps
   ```

6. **`application.properties` ಅಪ್ಡೇಟ್ ಮಾಡಿ** ಅಗತ್ಯ ಇದ್ದರೆ:
   - ಡೀಫಾಲ್ಟ್ `base-url` (`http://localhost:5273/v1`) ಡೀಫಾಲ್ಟ್ CLI ಪೋರ್ಟ್‌ಗೆ ಹೊಂದಿಕೆ ಮಾಡಿದೆ. `foundry service status` ನಲ್ಲಿ ಹೊರಹೊಮ್ಮುವ ಪೋರ್ಟ್ ಬೇರೆ ಇದ್ದರೆ ಮಾತ್ರ ನವೀಕರಿಸಿ.
   - ಮಾದರಿಯನ್ನು ಪ್ರಾರಂಭದಲ್ಲಿ **ಸ್ವಯಂಚಾಲಿತವಾಗಿ ಪತ್ತೆಹಚ್ಚುತ್ತದೆ** — ಯಾವುದೇ ಕಾನ್ಫಿಗರೇಶನ್ ಅಗತ್ಯವಿಲ್ಲ.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## ಅಪ್ಲಿಕೇಶನ್ ಓಡಿಸುವುದು

### ಹಂತ 1: ಫೌಂಡ್ರಿ ಲೋಕಲ್‌ನಲ್ಲಿ ಮಾದರಿ ಲೋಡ್ ಆಗಿದೆಯೇ ನೋಡಿ
```bash
foundry service ps
```

ಯಾವುದೇ ಮಾದರಿಗಳು ಪಟ್ಟಿಯಲ್ಲಿ ಇಲ್ಲದಿದ್ದರೆ, ಒಂದು ಲೋಡ್ ಮಾಡಿ:
```bash
foundry model run phi-4-mini
```

### ಹಂತ 2: ಅಪ್ಲಿಕೇಶನ್ ನಿರ್ಮಿಸಿ ಓಡಿಸಿ
ಬೇರೆ ಟರ್ಮಿನಲ್‌ನಲ್ಲಿ:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

ಅಥವಾ JAR ಆಗಿ ನಿರ್ಮಿಸಿ ಓಡಿಸಿ:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## ನಿರೀಕ್ಷಿತ ಔಟ್ಪುಟ್

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

## ಮುಂದಿನ ಹಂತಗಳು

ಹೆಚ್ಚಿನ ಉದಾಹರಣೆಗಳಿಗೆ, ನೋಡಿ [ಅಧ್ಯಾಯ 04: ಪ್ರಾಯೋಗಿಕ ಮಾದರಿಗಳು](../README.md)

## ಸಮಸ್ಯೆ ಪರಿಹಾರ

### ಸಾಮಾನ್ಯ ಸಮಸ್ಯೆಗಳು

**"ធರ್‍ನವ ಸಂಪರ್ಕ ನಿರಾಕರಿಸಲಾಗಿದೆ" ಅಥವಾ "ಸರ್ವಿಸ್ ಲಭ್ಯವಿಲ್ಲ"**
- ಸರ್ವಿಸ್ ಪರಿಶೀಲಿಸಿ: `foundry service status`
- ಅಗತ್ಯವಿದ್ದರೆ ಮರುಪ್ರಾರಂಭಿಸಿ: `foundry service restart`
- `application.properties` ನ ಪೋರ್ಟ್ ಮತ್ತು `foundry service status` ಹೋಲಿಸಿ
- URL `/v1` ನೊಂದಿಗೆ ಮುಕ್ತಾಯವಾಗಿರುವುದನ್ನು ಖಚಿತಪಡಿಸಿ: `http://localhost:5273/v1`

**"ಪ್ರಾರಂಭದಲ್ಲಿ ಮಾದರಿ ಕಂಡುಬಂದಿಲ್ಲ"**
- ಅಪ್ಲಿಕೇಶನ್ ಸ್ವಯಂಚಾಲಿತವಾಗಿ ಮಾದರಿಯನ್ನು ಹುಡುಕುತ್ತದೆ. ಕನಿಷ್ಠ ಒಂದು ಮಾದರಿ ಲೋಡ್ ಆಗಿರುವುದನ್ನು ಖಚಿತಪಡಿಸಿ: `foundry service ps`
- ಯಾವ ಮಾದರಿಗಳು ಲೋಡ್ ಆಗಿಲ್ಲ ಎಂದಾದರೆ: `foundry model run phi-4-mini`
- ನೀವು `application.properties` ನಲ್ಲಿ ಮಾದರಿಯ ಹೆಸರನ್ನು ಹೊಂದಿಸಿದ್ರೆ, ಅದು `foundry model list` ಜೊತೆಗೆ ಹೊಂದಿಕೆಯಾಗಬಹುದೇ ಎಂದು ಖಚಿತಪಡಿಸಿ

**"400 ಕೆಟ್ಟ ವಿನಂತಿ" ದೋಷಗಳು**
- ಬೇಸ್ URL `/v1` ಒಳಗೊಂಡಿದೆಯೇ ಎಂದು ಪರಿಶೀಲಿಸಿ: `http://localhost:5273/v1`
- ನೀವು ನಿಮ್ಮ ಕೋಡ್‌ನಲ್ಲಿ `maxCompletionTokens()` ಬಳಸಿ ಇದ್ದೀರಿ (ಹಳೆಯ `maxTokens()` ಅಲ್ಲ)

**ಮೇವನ್ ಸಂಯೋಜನಾ ದೋಷಗಳು**
- ಜಾವಾ 21 ಅಥವಾ ಅದಕ್ಕಿಂತ ಮೇಲು ಬಳಸಿ: `java -version`
- ಕ್ಲೀನ್ ಮಾಡಿ ಮರುನirmaಣ ಮಾಡಿ: `mvn clean compile`
- ಡಿಪೆಂಡೆನ್ಸಿ ಡೌನ್ಲೋಡ್ ಗಾಗಿ ಇಂಟರ್ನೆಟ್ ಸಂಪರ್ಕ ಪರಿಶೀಲಿಸಿ

**ಸರ್ವಿಸ್ ಸಂಪರ್ಕ ಸಮಸ್ಯೆಗಳು**
- `Request to local service failed` ಕಾಣಿಸಿದಲ್ಲಿ, ರನ್ ಮಾಡಿ: `foundry service restart`
- ಲೋಡ್ ಅಗಿದ ಮಾದರಿಗಳನ್ನು ಪರಿಶೀಲಿಸಿ: `foundry service ps`
- ಸರ್ವಿಸ್ ಲಾಗ್ಗಳಿಗೆ ನೋಡಿ: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ನಿರాకರಣೆ**:
ಈ ಡಾಕ್ಯೂಮೆಂಟ್ ಅನ್ನು AI ಅನುವಾದ ಸೇವೆ [Co-op Translator](https://github.com/Azure/co-op-translator) ಬಳಸಿಕೊಂಡು ಅನುವಾದಿಸಲಾಗಿದೆ. ನಾವು ನಿಖರತೆಯಿಗಾಗಿ ಪ್ರಯತ್ನಿಸುತ್ತಿದ್ದರೂ, ಸ್ವಯಂಚಾಲಿತ ಅನುವಾದಗಳಲ್ಲಿ ತಪ್ಪುಗಳು ಅಥವಾ ಅಸತ್ಯತೆಗಳು ಇರಬಹುದೆಂದು ದಯವಿಟ್ಟು ಗಮನಿಸಿ. ಮೌಲಿಕ ಭಾಷೆಯ ಮೂಲ ಡಾಕ್ಯೂಮೆಂಟ್ ಅದೇ ಅಧಿಕೃತ ಮೂಲವಾಗಿರುತ್ತದೆ. ಪ್ರಮುಖ ಮಾಹಿತಿಗಾಗಿ, ವೃತ್ತಿಪರ ಮಾನವ ಅನುವಾದವನ್ನು ಶಿಫಾರಸು ಮಾಡಲಾಗುತ್ತದೆ. ಈ ಅನುವಾದ ಸೇವನೆಯ ಬಳಕೆಯಿಂದ ಉಂಟಾಗುವ ಯಾವುದೇ ತ misunderstandings ಅಥವಾ ತಪ್ಪು ಅರ್ಥಮಾಡಿಕೊಳ್ಳುವುದಕ್ಕಾಗಿ ನಾವು ಹೊಣೆಗಾರರಲ್ಲ.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->