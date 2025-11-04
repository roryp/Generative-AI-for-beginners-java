<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "fe08a184d8a753a0f497673921f77759",
  "translation_date": "2025-11-04T06:44:59+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "pa"
}
-->
# ਫਾਊਂਡਰੀ ਲੋਕਲ ਸਪ੍ਰਿੰਗ ਬੂਟ ਟਿਊਟੋਰਿਅਲ

## ਸੂਚੀ

- [ਪੂਰਵ ਸ਼ਰਤਾਂ](../../../../04-PracticalSamples/foundrylocal)
- [ਪ੍ਰੋਜੈਕਟ ਝਲਕ](../../../../04-PracticalSamples/foundrylocal)
- [ਕੋਡ ਦੀ ਸਮਝ](../../../../04-PracticalSamples/foundrylocal)
  - [1. ਐਪਲੀਕੇਸ਼ਨ ਸੰਰਚਨਾ (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. ਮੁੱਖ ਐਪਲੀਕੇਸ਼ਨ ਕਲਾਸ (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI ਸੇਵਾ ਪੱਧਰ (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. ਪ੍ਰੋਜੈਕਟ ਡਿਪੈਂਡੈਂਸੀਜ਼ (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [ਇਹ ਸਭ ਕਿਵੇਂ ਕੰਮ ਕਰਦਾ ਹੈ](../../../../04-PracticalSamples/foundrylocal)
- [ਫਾਊਂਡਰੀ ਲੋਕਲ ਸੈਟਅੱਪ ਕਰਨਾ](../../../../04-PracticalSamples/foundrylocal)
- [ਐਪਲੀਕੇਸ਼ਨ ਚਲਾਉਣਾ](../../../../04-PracticalSamples/foundrylocal)
- [ਉਮੀਦਵਾਰ ਨਤੀਜਾ](../../../../04-PracticalSamples/foundrylocal)
- [ਅਗਲੇ ਕਦਮ](../../../../04-PracticalSamples/foundrylocal)
- [ਮਸਲੇ ਹੱਲ](../../../../04-PracticalSamples/foundrylocal)

## ਪੂਰਵ ਸ਼ਰਤਾਂ

ਇਸ ਟਿਊਟੋਰਿਅਲ ਨੂੰ ਸ਼ੁਰੂ ਕਰਨ ਤੋਂ ਪਹਿਲਾਂ, ਇਹ ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਤੁਹਾਡੇ ਕੋਲ:

- **Java 21 ਜਾਂ ਇਸ ਤੋਂ ਉੱਚਾ** ਤੁਹਾਡੇ ਸਿਸਟਮ 'ਤੇ ਇੰਸਟਾਲ ਹੈ
- **Maven 3.6+** ਪ੍ਰੋਜੈਕਟ ਬਣਾਉਣ ਲਈ
- **Foundry Local** ਇੰਸਟਾਲ ਅਤੇ ਚਲ ਰਹੀ ਹੈ

### **Foundry Local ਇੰਸਟਾਲ ਕਰੋ:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```


## ਪ੍ਰੋਜੈਕਟ ਝਲਕ

ਇਸ ਪ੍ਰੋਜੈਕਟ ਵਿੱਚ ਚਾਰ ਮੁੱਖ ਹਿੱਸੇ ਹਨ:

1. **Application.java** - ਮੁੱਖ ਸਪ੍ਰਿੰਗ ਬੂਟ ਐਪਲੀਕੇਸ਼ਨ ਐਂਟਰੀ ਪੌਇੰਟ
2. **FoundryLocalService.java** - ਸੇਵਾ ਪੱਧਰ ਜੋ AI ਸੰਚਾਰ ਨੂੰ ਸੰਭਾਲਦਾ ਹੈ
3. **application.properties** - Foundry Local ਕਨੈਕਸ਼ਨ ਲਈ ਸੰਰਚਨਾ
4. **pom.xml** - Maven ਡਿਪੈਂਡੈਂਸੀਜ਼ ਅਤੇ ਪ੍ਰੋਜੈਕਟ ਸੰਰਚਨਾ

## ਕੋਡ ਦੀ ਸਮਝ

### 1. ਐਪਲੀਕੇਸ਼ਨ ਸੰਰਚਨਾ (application.properties)

**ਫਾਇਲ:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**ਇਹ ਕੀ ਕਰਦਾ ਹੈ:**
- **base-url**: ਦੱਸਦਾ ਹੈ ਕਿ Foundry Local ਕਿੱਥੇ ਚੱਲ ਰਿਹਾ ਹੈ, `/v1` ਪਾਥ ਸਮੇਤ OpenAI API ਅਨੁਕੂਲਤਾ ਲਈ। **ਨੋਟ**: Foundry Local ਗਤੀਸ਼ੀਲ ਤੌਰ 'ਤੇ ਪੋਰਟ ਅਸਾਈਨ ਕਰਦਾ ਹੈ, ਇਸ ਲਈ `foundry service status` ਨਾਲ ਆਪਣਾ ਅਸਲ ਪੋਰਟ ਚੈੱਕ ਕਰੋ।
- **model**: AI ਮਾਡਲ ਦਾ ਨਾਮ ਦਿੰਦਾ ਹੈ ਜੋ ਟੈਕਸਟ ਜਨਰੇਸ਼ਨ ਲਈ ਵਰਤਿਆ ਜਾਣਾ ਹੈ, ਵਰਜਨ ਨੰਬਰ ਸਮੇਤ (ਜਿਵੇਂ, `:1`)। ਉਪਲਬਧ ਮਾਡਲ ਦੇ ਸਹੀ IDs ਦੇਖਣ ਲਈ `foundry model list` ਵਰਤੋ।

**ਮੁੱਖ ਧਾਰਨਾ:** ਸਪ੍ਰਿੰਗ ਬੂਟ ਆਪਣੇ ਆਪ ਇਹ ਗੁਣ ਲੋਡ ਕਰਦਾ ਹੈ ਅਤੇ `@Value` ਐਨੋਟੇਸ਼ਨ ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਤੁਹਾਡੇ ਐਪਲੀਕੇਸ਼ਨ ਲਈ ਉਪਲਬਧ ਕਰਦਾ ਹੈ।

### 2. ਮੁੱਖ ਐਪਲੀਕੇਸ਼ਨ ਕਲਾਸ (Application.java)

**ਫਾਇਲ:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```


**ਇਹ ਕੀ ਕਰਦਾ ਹੈ:**
- `@SpringBootApplication` ਸਪ੍ਰਿੰਗ ਬੂਟ ਆਟੋ-ਕੰਫਿਗਰੇਸ਼ਨ ਨੂੰ ਯੋਗ ਬਣਾਉਂਦਾ ਹੈ
- `WebApplicationType.NONE` ਸਪ੍ਰਿੰਗ ਨੂੰ ਦੱਸਦਾ ਹੈ ਕਿ ਇਹ ਇੱਕ ਕਮਾਂਡ-ਲਾਈਨ ਐਪ ਹੈ, ਨਾ ਕਿ ਵੈੱਬ ਸਰਵਰ
- ਮੁੱਖ ਮੈਥਡ ਸਪ੍ਰਿੰਗ ਐਪਲੀਕੇਸ਼ਨ ਨੂੰ ਸ਼ੁਰੂ ਕਰਦਾ ਹੈ

**ਡੈਮੋ ਰਨਰ:**
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


**ਇਹ ਕੀ ਕਰਦਾ ਹੈ:**
- `@Bean` ਇੱਕ ਕੰਪੋਨੈਂਟ ਬਣਾਉਂਦਾ ਹੈ ਜਿਸਨੂੰ ਸਪ੍ਰਿੰਗ ਸੰਭਾਲਦਾ ਹੈ
- `CommandLineRunner` ਸਪ੍ਰਿੰਗ ਬੂਟ ਸ਼ੁਰੂ ਹੋਣ ਤੋਂ ਬਾਅਦ ਕੋਡ ਚਲਾਉਂਦਾ ਹੈ
- `foundryLocalService` ਸਪ੍ਰਿੰਗ ਦੁਆਰਾ ਆਪਣੇ ਆਪ Inject ਕੀਤਾ ਜਾਂਦਾ ਹੈ (ਡਿਪੈਂਡੈਂਸੀ ਇੰਜੈਕਸ਼ਨ)
- AI ਨੂੰ ਇੱਕ ਟੈਸਟ ਸੁਨੇਹਾ ਭੇਜਦਾ ਹੈ ਅਤੇ ਜਵਾਬ ਦਿਖਾਉਂਦਾ ਹੈ

### 3. AI ਸੇਵਾ ਪੱਧਰ (FoundryLocalService.java)

**ਫਾਇਲ:** `src/main/java/com/example/FoundryLocalService.java`

#### ਸੰਰਚਨਾ ਇੰਜੈਕਸ਼ਨ:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**ਇਹ ਕੀ ਕਰਦਾ ਹੈ:**
- `@Service` ਸਪ੍ਰਿੰਗ ਨੂੰ ਦੱਸਦਾ ਹੈ ਕਿ ਇਹ ਕਲਾਸ ਕਾਰੋਬਾਰੀ ਤਰਕ ਪ੍ਰਦਾਨ ਕਰਦੀ ਹੈ
- `@Value` `application.properties` ਤੋਂ ਸੰਰਚਨਾ ਮੁੱਲ Inject ਕਰਦਾ ਹੈ
- `:default-value` syntax fallback ਮੁੱਲ ਪ੍ਰਦਾਨ ਕਰਦਾ ਹੈ ਜੇ ਗੁਣ ਸੈਟ ਨਹੀਂ ਹਨ

#### ਕਲਾਇੰਟ ਸ਼ੁਰੂਆਤ:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```


**ਇਹ ਕੀ ਕਰਦਾ ਹੈ:**
- `@PostConstruct` ਸਪ੍ਰਿੰਗ ਦੁਆਰਾ ਸੇਵਾ ਬਣਾਉਣ ਤੋਂ ਬਾਅਦ ਇਹ ਮੈਥਡ ਚਲਾਉਂਦਾ ਹੈ
- ਇੱਕ OpenAI ਕਲਾਇੰਟ ਬਣਾਉਂਦਾ ਹੈ ਜੋ ਤੁਹਾਡੇ ਸਥਾਨਕ Foundry Local instance ਨੂੰ ਪੋਇੰਟ ਕਰਦਾ ਹੈ
- `application.properties` ਤੋਂ base URL ਪਹਿਲਾਂ ਹੀ `/v1` ਸ਼ਾਮਲ ਕਰਦਾ ਹੈ OpenAI API ਅਨੁਕੂਲਤਾ ਲਈ
- API key "not-needed" ਸੈਟ ਕੀਤੀ ਜਾਂਦੀ ਹੈ ਕਿਉਂਕਿ ਸਥਾਨਕ ਵਿਕਾਸ ਵਿੱਚ ਪ੍ਰਮਾਣਿਕਤਾ ਦੀ ਲੋੜ ਨਹੀਂ ਹੁੰਦੀ

#### ਚੈਟ ਮੈਥਡ:
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


**ਇਹ ਕੀ ਕਰਦਾ ਹੈ:**
- **ChatCompletionCreateParams**: AI ਬੇਨਤੀ ਦੀ ਸੰਰਚਨਾ ਕਰਦਾ ਹੈ
  - `model`: ਦੱਸਦਾ ਹੈ ਕਿ ਕਿਹੜਾ AI ਮਾਡਲ ਵਰਤਣਾ ਹੈ (Foundry ਮਾਡਲ ਲਿਸਟ ਤੋਂ ਸਹੀ ID ਨਾਲ ਮੈਚ ਕਰਨਾ ਚਾਹੀਦਾ ਹੈ)
  - `addUserMessage`: ਤੁਹਾਡੇ ਸੁਨੇਹੇ ਨੂੰ ਗੱਲਬਾਤ ਵਿੱਚ ਸ਼ਾਮਲ ਕਰਦਾ ਹੈ
  - `maxCompletionTokens`: ਜਵਾਬ ਦੀ ਲੰਬਾਈ ਸੀਮਿਤ ਕਰਦਾ ਹੈ (ਸੰਸਾਧਨਾਂ ਦੀ ਬਚਤ ਕਰਦਾ ਹੈ)
  - `temperature`: randomness ਨੂੰ ਕੰਟਰੋਲ ਕਰਦਾ ਹੈ (0.0 = deterministic, 1.0 = creative)
- **API Call**: Foundry Local ਨੂੰ ਬੇਨਤੀ ਭੇਜਦਾ ਹੈ
- **Response Handling**: ਸੁਰੱਖਿਅਤ ਤੌਰ 'ਤੇ AI ਦੇ ਟੈਕਸਟ ਜਵਾਬ ਨੂੰ ਕੱਢਦਾ ਹੈ
- **Error Handling**: ਮਦਦਗਾਰ ਗਲਤੀ ਸੁਨੇਹਿਆਂ ਨਾਲ exceptions ਨੂੰ ਲਪੇਟਦਾ ਹੈ

### 4. ਪ੍ਰੋਜੈਕਟ ਡਿਪੈਂਡੈਂਸੀਜ਼ (pom.xml)

**ਮੁੱਖ ਡਿਪੈਂਡੈਂਸੀਜ਼:**

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


**ਇਹ ਕੀ ਕਰਦੇ ਹਨ:**
- **spring-boot-starter**: ਮੁੱਖ ਸਪ੍ਰਿੰਗ ਬੂਟ ਫੰਕਸ਼ਨਲਿਟੀ ਪ੍ਰਦਾਨ ਕਰਦਾ ਹੈ
- **openai-java**: API ਸੰਚਾਰ ਲਈ OpenAI Java SDK
- **jackson-databind**: API ਕਾਲਾਂ ਲਈ JSON serialization/deserialization ਨੂੰ ਸੰਭਾਲਦਾ ਹੈ

## ਇਹ ਸਭ ਕਿਵੇਂ ਕੰਮ ਕਰਦਾ ਹੈ

ਜਦੋਂ ਤੁਸੀਂ ਐਪਲੀਕੇਸ਼ਨ ਚਲਾਉਂਦੇ ਹੋ ਤਾਂ ਪੂਰਾ ਪ੍ਰਕਿਰਿਆ ਇਹ ਹੈ:

1. **ਸ਼ੁਰੂਆਤ**: ਸਪ੍ਰਿੰਗ ਬੂਟ ਸ਼ੁਰੂ ਹੁੰਦਾ ਹੈ ਅਤੇ `application.properties` ਨੂੰ ਪੜ੍ਹਦਾ ਹੈ
2. **ਸੇਵਾ ਬਣਾਉਣ**: ਸਪ੍ਰਿੰਗ `FoundryLocalService` ਬਣਾਉਂਦਾ ਹੈ ਅਤੇ ਸੰਰਚਨਾ ਮੁੱਲ Inject ਕਰਦਾ ਹੈ
3. **ਕਲਾਇੰਟ ਸੈਟਅੱਪ**: `@PostConstruct` OpenAI ਕਲਾਇੰਟ ਨੂੰ Foundry Local ਨਾਲ ਕਨੈਕਟ ਕਰਨ ਲਈ ਸ਼ੁਰੂ ਕਰਦਾ ਹੈ
4. **ਡੈਮੋ ਐਗਜ਼ਿਕਿਊਸ਼ਨ**: `CommandLineRunner` ਸ਼ੁਰੂਆਤ ਤੋਂ ਬਾਅਦ ਚਲਦਾ ਹੈ
5. **AI ਕਾਲ**: ਡੈਮੋ `foundryLocalService.chat()` ਨੂੰ ਇੱਕ ਟੈਸਟ ਸੁਨੇਹੇ ਨਾਲ ਕਾਲ ਕਰਦਾ ਹੈ
6. **API ਬੇਨਤੀ**: ਸੇਵਾ OpenAI-ਅਨੁਕੂਲ ਬੇਨਤੀ ਬਣਾਉਂਦੀ ਹੈ ਅਤੇ Foundry Local ਨੂੰ ਭੇਜਦੀ ਹੈ
7. **ਜਵਾਬ ਪ੍ਰਕਿਰਿਆ**: ਸੇਵਾ AI ਦੇ ਜਵਾਬ ਨੂੰ ਕੱਢਦੀ ਹੈ ਅਤੇ ਵਾਪਸ ਕਰਦੀ ਹੈ
8. **ਡਿਸਪਲੇ**: ਐਪਲੀਕੇਸ਼ਨ ਜਵਾਬ ਪ੍ਰਿੰਟ ਕਰਦਾ ਹੈ ਅਤੇ ਬੰਦ ਹੁੰਦਾ ਹੈ

## Foundry Local ਸੈਟਅੱਪ ਕਰਨਾ

Foundry Local ਸੈਟਅੱਪ ਕਰਨ ਲਈ, ਇਹ ਕਦਮ ਅਨੁਸਰਣ ਕਰੋ:

1. **Foundry Local ਇੰਸਟਾਲ ਕਰੋ** [Prerequisites](../../../../04-PracticalSamples/foundrylocal) ਸੈਕਸ਼ਨ ਵਿੱਚ ਦਿੱਤੀਆਂ ਹਦਾਇਤਾਂ ਦੇ ਅਨੁਸਾਰ।

2. **ਗਤੀਸ਼ੀਲ ਤੌਰ 'ਤੇ ਅਸਾਈਨ ਕੀਤੇ ਪੋਰਟ ਨੂੰ ਚੈੱਕ ਕਰੋ**। Foundry Local ਸ਼ੁਰੂ ਹੋਣ 'ਤੇ ਆਪਣੇ ਆਪ ਪੋਰਟ ਅਸਾਈਨ ਕਰਦਾ ਹੈ। ਆਪਣਾ ਪੋਰਟ ਪਤਾ ਕਰਨ ਲਈ:
   ```bash
   foundry service status
   ```
   
   **ਵਿਕਲਪਿਕ**: ਜੇ ਤੁਸੀਂ ਇੱਕ ਖਾਸ ਪੋਰਟ ਵਰਤਣਾ ਪਸੰਦ ਕਰਦੇ ਹੋ (ਜਿਵੇਂ, 5273), ਤਾਂ ਤੁਸੀਂ ਇਸਨੂੰ ਮੈਨੁਅਲੀ ਤੌਰ 'ਤੇ ਕਨਫਿਗਰ ਕਰ ਸਕਦੇ ਹੋ:
   ```bash
   foundry service set --port 5273
   ```


3. **AI ਮਾਡਲ ਡਾਊਨਲੋਡ ਕਰੋ** ਜੋ ਤੁਸੀਂ ਵਰਤਣਾ ਚਾਹੁੰਦੇ ਹੋ, ਉਦਾਹਰਨ ਲਈ, `phi-3.5-mini`, ਇਸ ਕਮਾਂਡ ਨਾਲ:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **application.properties ਫਾਇਲ ਨੂੰ Foundry Local ਸੈਟਿੰਗਾਂ ਨਾਲ ਮੈਚ ਕਰਨ ਲਈ ਕਨਫਿਗਰ ਕਰੋ**:
   - `base-url` ਵਿੱਚ ਪੋਰਟ ਨੂੰ ਅਪਡੇਟ ਕਰੋ (ਕਦਮ 2 ਤੋਂ), ਇਹ ਯਕੀਨੀ ਬਣਾਉਂਦੇ ਹੋਏ ਕਿ `/v1` ਅੰਤ ਵਿੱਚ ਸ਼ਾਮਲ ਹੈ
   - ਮਾਡਲ ਨਾਮ ਨੂੰ ਵਰਜਨ ਨੰਬਰ ਸਮੇਤ ਅਪਡੇਟ ਕਰੋ (`foundry model list` ਨਾਲ ਚੈੱਕ ਕਰੋ)

   ਉਦਾਹਰਨ:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## ਐਪਲੀਕੇਸ਼ਨ ਚਲਾਉਣਾ

### ਕਦਮ 1: Foundry Local ਸ਼ੁਰੂ ਕਰੋ
```bash
foundry model run phi-3.5-mini
```


### ਕਦਮ 2: ਐਪਲੀਕੇਸ਼ਨ ਬਣਾਓ ਅਤੇ ਚਲਾਓ
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```


## ਉਮੀਦਵਾਰ ਨਤੀਜਾ

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


## ਅਗਲੇ ਕਦਮ

ਹੋਰ ਉਦਾਹਰਨਾਂ ਲਈ, [Chapter 04: Practical samples](../README.md) ਵੇਖੋ

## ਮਸਲੇ ਹੱਲ

### ਆਮ ਸਮੱਸਿਆਵਾਂ

**"Connection refused" ਜਾਂ "Service unavailable"**
- ਯਕੀਨੀ ਬਣਾਓ ਕਿ Foundry Local ਚੱਲ ਰਿਹਾ ਹੈ: `foundry model list`
- Foundry Local ਕਿਹੜਾ ਪੋਰਟ ਵਰਤ ਰਿਹਾ ਹੈ ਇਹ ਚੈੱਕ ਕਰੋ: `foundry service status`
- `application.properties` ਨੂੰ ਸਹੀ ਪੋਰਟ ਨਾਲ ਅਪਡੇਟ ਕਰੋ, ਇਹ ਯਕੀਨੀ ਬਣਾਉਂਦੇ ਹੋਏ ਕਿ URL `/v1` ਨਾਲ ਖਤਮ ਹੁੰਦਾ ਹੈ
- ਵਿਕਲਪਿਕ: ਜੇ ਚਾਹੁੰਦੇ ਹੋ ਤਾਂ ਖਾਸ ਪੋਰਟ ਸੈਟ ਕਰੋ: `foundry service set --port 5273`
- Foundry Local ਨੂੰ ਮੁੜ ਸ਼ੁਰੂ ਕਰਨ ਦੀ ਕੋਸ਼ਿਸ਼ ਕਰੋ: `foundry model run phi-3.5-mini`

**"Model not found" ਜਾਂ "404 Not Found" errors**
- ਉਪਲਬਧ ਮਾਡਲਾਂ ਨੂੰ ਸਹੀ IDs ਨਾਲ ਚੈੱਕ ਕਰੋ: `foundry model list`
- `application.properties` ਵਿੱਚ ਮਾਡਲ ਨਾਮ ਨੂੰ ਸਹੀ ਤੌਰ 'ਤੇ ਅਪਡੇਟ ਕਰੋ, ਵਰਜਨ ਨੰਬਰ ਸਮੇਤ (ਜਿਵੇਂ, `Phi-3.5-mini-instruct-cuda-gpu:1`)
- ਯਕੀਨੀ ਬਣਾਓ ਕਿ `base-url` `/v1` ਨਾਲ ਖਤਮ ਹੁੰਦਾ ਹੈ: `http://localhost:5273/v1`
- ਜੇ ਲੋੜ ਹੋਵੇ ਤਾਂ ਮਾਡਲ ਡਾਊਨਲੋਡ ਕਰੋ: `foundry model run phi-3.5-mini`

**"400 Bad Request" errors**
- ਯਕੀਨੀ ਬਣਾਓ ਕਿ base URL `/v1` ਸ਼ਾਮਲ ਕਰਦਾ ਹੈ: `http://localhost:5273/v1`
- Foundry ਮਾਡਲ ਲਿਸਟ ਵਿੱਚ ਦਿੱਤੇ ਸਹੀ ਮਾਡਲ ID ਨੂੰ ਚੈੱਕ ਕਰੋ
- ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਤੁਸੀਂ ਆਪਣੇ ਕੋਡ ਵਿੱਚ `maxCompletionTokens()` ਵਰਤ ਰਹੇ ਹੋ (deprecated `maxTokens()` ਨਹੀਂ)

**Maven ਸੰਪਿਲੇਸ਼ਨ errors**
- Java 21 ਜਾਂ ਇਸ ਤੋਂ ਉੱਚਾ ਯਕੀਨੀ ਬਣਾਓ: `java -version`
- ਸਾਫ਼ ਕਰੋ ਅਤੇ ਮੁੜ ਬਣਾਓ: `mvn clean compile`
- ਡਿਪੈਂਡੈਂਸੀ ਡਾਊਨਲੋਡ ਲਈ ਇੰਟਰਨੈਟ ਕਨੈਕਸ਼ਨ ਚੈੱਕ ਕਰੋ

**ਐਪਲੀਕੇਸ਼ਨ ਸ਼ੁਰੂ ਹੁੰਦੀ ਹੈ ਪਰ ਕੋਈ ਨਤੀਜਾ ਨਹੀਂ**
- ਯਕੀਨੀ ਬਣਾਓ ਕਿ Foundry Local ਜਵਾਬ ਦੇ ਰਿਹਾ ਹੈ: `http://localhost:5273` ਨੂੰ ਬ੍ਰਾਊਜ਼ਰ ਵਿੱਚ ਖੋਲ੍ਹੋ
- ਐਪਲੀਕੇਸ਼ਨ ਲੌਗਸ ਵਿੱਚ ਖਾਸ ਗਲਤੀ ਸੁਨੇਹੇ ਚੈੱਕ ਕਰੋ
- ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਮਾਡਲ ਪੂਰੀ ਤਰ੍ਹਾਂ ਲੋਡ ਹੋਇਆ ਹੈ ਅਤੇ ਤਿਆਰ ਹੈ

---

**ਅਸਵੀਕਰਤਾ**:  
ਇਹ ਦਸਤਾਵੇਜ਼ AI ਅਨੁਵਾਦ ਸੇਵਾ [Co-op Translator](https://github.com/Azure/co-op-translator) ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਅਨੁਵਾਦ ਕੀਤਾ ਗਿਆ ਹੈ। ਜਦੋਂ ਕਿ ਅਸੀਂ ਸਹੀ ਹੋਣ ਦੀ ਕੋਸ਼ਿਸ਼ ਕਰਦੇ ਹਾਂ, ਕਿਰਪਾ ਕਰਕੇ ਧਿਆਨ ਦਿਓ ਕਿ ਸਵੈਚਾਲਿਤ ਅਨੁਵਾਦਾਂ ਵਿੱਚ ਗਲਤੀਆਂ ਜਾਂ ਅਸੁੱਤੀਆਂ ਹੋ ਸਕਦੀਆਂ ਹਨ। ਇਸ ਦੀ ਮੂਲ ਭਾਸ਼ਾ ਵਿੱਚ ਮੂਲ ਦਸਤਾਵੇਜ਼ ਨੂੰ ਅਧਿਕਾਰਤ ਸਰੋਤ ਮੰਨਿਆ ਜਾਣਾ ਚਾਹੀਦਾ ਹੈ। ਮਹੱਤਵਪੂਰਨ ਜਾਣਕਾਰੀ ਲਈ, ਪੇਸ਼ੇਵਰ ਮਨੁੱਖੀ ਅਨੁਵਾਦ ਦੀ ਸਿਫਾਰਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ। ਇਸ ਅਨੁਵਾਦ ਦੀ ਵਰਤੋਂ ਤੋਂ ਪੈਦਾ ਹੋਣ ਵਾਲੇ ਕਿਸੇ ਵੀ ਗਲਤਫਹਿਮੀ ਜਾਂ ਗਲਤ ਵਿਆਖਿਆ ਲਈ ਅਸੀਂ ਜ਼ਿੰਮੇਵਾਰ ਨਹੀਂ ਹਾਂ।