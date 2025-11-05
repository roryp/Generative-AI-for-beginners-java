<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "f787307400de59adc25a1404466a35f3",
  "translation_date": "2025-11-04T07:21:52+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "pa"
}
-->
# Foundry Local Spring Boot ਟਿਊਟੋਰਿਅਲ

## ਸੂਚੀ

- [ਪੂਰਵ ਸ਼ਰਤਾਂ](../../../../04-PracticalSamples/foundrylocal)
- [ਪ੍ਰੋਜੈਕਟ ਝਲਕ](../../../../04-PracticalSamples/foundrylocal)
- [ਕੋਡ ਦੀ ਸਮਝ](../../../../04-PracticalSamples/foundrylocal)
  - [1. ਐਪਲੀਕੇਸ਼ਨ ਕਨਫਿਗਰੇਸ਼ਨ (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. ਮੁੱਖ ਐਪਲੀਕੇਸ਼ਨ ਕਲਾਸ (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI ਸੇਵਾ ਲੇਅਰ (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. ਪ੍ਰੋਜੈਕਟ ਡਿਪੈਂਡੈਂਸੀਜ਼ (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [ਇਹ ਸਭ ਕਿਵੇਂ ਕੰਮ ਕਰਦਾ ਹੈ](../../../../04-PracticalSamples/foundrylocal)
- [Foundry Local ਸੈਟਅਪ ਕਰਨਾ](../../../../04-PracticalSamples/foundrylocal)
- [ਐਪਲੀਕੇਸ਼ਨ ਚਲਾਉਣਾ](../../../../04-PracticalSamples/foundrylocal)
- [ਉਮੀਦਵਾਰ ਨਤੀਜਾ](../../../../04-PracticalSamples/foundrylocal)
- [ਅਗਲੇ ਕਦਮ](../../../../04-PracticalSamples/foundrylocal)
- [ਮੁਸ਼ਕਲਾਂ ਦਾ ਹੱਲ](../../../../04-PracticalSamples/foundrylocal)

## ਪੂਰਵ ਸ਼ਰਤਾਂ

ਇਸ ਟਿਊਟੋਰਿਅਲ ਨੂੰ ਸ਼ੁਰੂ ਕਰਨ ਤੋਂ ਪਹਿਲਾਂ, ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਤੁਹਾਡੇ ਕੋਲ:

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

1. **Application.java** - ਮੁੱਖ Spring Boot ਐਪਲੀਕੇਸ਼ਨ ਐਂਟਰੀ ਪੌਇੰਟ
2. **FoundryLocalService.java** - ਸੇਵਾ ਲੇਅਰ ਜੋ AI ਕਮਿਊਨਿਕੇਸ਼ਨ ਨੂੰ ਸੰਭਾਲਦਾ ਹੈ
3. **application.properties** - Foundry Local ਕਨੈਕਸ਼ਨ ਲਈ ਕਨਫਿਗਰੇਸ਼ਨ
4. **pom.xml** - Maven ਡਿਪੈਂਡੈਂਸੀਜ਼ ਅਤੇ ਪ੍ਰੋਜੈਕਟ ਕਨਫਿਗਰੇਸ਼ਨ

## ਕੋਡ ਦੀ ਸਮਝ

### 1. ਐਪਲੀਕੇਸ਼ਨ ਕਨਫਿਗਰੇਸ਼ਨ (application.properties)

**ਫਾਈਲ:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**ਇਹ ਕੀ ਕਰਦਾ ਹੈ:**
- **base-url**: ਦੱਸਦਾ ਹੈ ਕਿ Foundry Local ਕਿੱਥੇ ਚੱਲ ਰਿਹਾ ਹੈ, `/v1` ਪਾਥ ਸਮੇਤ ਜੋ OpenAI API ਨਾਲ ਅਨੁਕੂਲਤਾ ਲਈ ਹੈ। **ਨੋਟ**: Foundry Local ਡਾਇਨੈਮਿਕ ਤਰੀਕੇ ਨਾਲ ਪੋਰਟ ਅਸਾਈਨ ਕਰਦਾ ਹੈ, ਇਸ ਲਈ `foundry service status` ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਆਪਣੀ ਅਸਲ ਪੋਰਟ ਦੀ ਜਾਂਚ ਕਰੋ।
- **model**: ਟੈਕਸਟ ਜਨਰੇਸ਼ਨ ਲਈ ਵਰਤਣ ਵਾਲੇ AI ਮਾਡਲ ਦਾ ਨਾਮ ਦਿੰਦਾ ਹੈ, ਵਰਜਨ ਨੰਬਰ ਸਮੇਤ (ਜਿਵੇਂ, `:1`)। ਉਪਲਬਧ ਮਾਡਲਾਂ ਦੇ ਸਹੀ IDs ਦੇਖਣ ਲਈ `foundry model list` ਦੀ ਵਰਤੋਂ ਕਰੋ।

**ਮੁੱਖ ਧਾਰਨਾ:** Spring Boot ਆਪਣੇ ਆਪ ਇਹ ਗੁਣ ਲੋਡ ਕਰਦਾ ਹੈ ਅਤੇ `@Value` ਐਨੋਟੇਸ਼ਨ ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਤੁਹਾਡੇ ਐਪਲੀਕੇਸ਼ਨ ਲਈ ਉਪਲਬਧ ਕਰਦਾ ਹੈ।

### 2. ਮੁੱਖ ਐਪਲੀਕੇਸ਼ਨ ਕਲਾਸ (Application.java)

**ਫਾਈਲ:** `src/main/java/com/example/Application.java`

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
- `@SpringBootApplication` Spring Boot ਆਟੋ-ਕਨਫਿਗਰੇਸ਼ਨ ਨੂੰ ਯੋਗ ਬਣਾਉਂਦਾ ਹੈ
- `WebApplicationType.NONE` Spring ਨੂੰ ਦੱਸਦਾ ਹੈ ਕਿ ਇਹ ਇੱਕ ਕਮਾਂਡ-ਲਾਈਨ ਐਪ ਹੈ, ਨਾ ਕਿ ਵੈੱਬ ਸਰਵਰ
- ਮੁੱਖ ਮੈਥਡ Spring ਐਪਲੀਕੇਸ਼ਨ ਨੂੰ ਸ਼ੁਰੂ ਕਰਦਾ ਹੈ

**ਡੈਮੋ ਰਨਰ:**
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


**ਇਹ ਕੀ ਕਰਦਾ ਹੈ:**
- `@Bean` ਇੱਕ ਕੰਪੋਨੈਂਟ ਬਣਾਉਂਦਾ ਹੈ ਜਿਸਨੂੰ Spring ਮੈਨੇਜ ਕਰਦਾ ਹੈ
- `CommandLineRunner` Spring Boot ਸ਼ੁਰੂ ਹੋਣ ਤੋਂ ਬਾਅਦ ਕੋਡ ਚਲਾਉਂਦਾ ਹੈ
- `foundryLocalService` Spring ਦੁਆਰਾ ਆਟੋਮੈਟਿਕ ਤਰੀਕੇ ਨਾਲ Inject ਕੀਤਾ ਜਾਂਦਾ ਹੈ (ਡਿਪੈਂਡੈਂਸੀ ਇੰਜੈਕਸ਼ਨ)
- AI ਨੂੰ ਇੱਕ ਟੈਸਟ ਸੁਨੇਹਾ ਭੇਜਦਾ ਹੈ ਅਤੇ ਜਵਾਬ ਦਿਖਾਉਂਦਾ ਹੈ

### 3. AI ਸੇਵਾ ਲੇਅਰ (FoundryLocalService.java)

**ਫਾਈਲ:** `src/main/java/com/example/FoundryLocalService.java`

#### ਕਨਫਿਗਰੇਸ਼ਨ ਇੰਜੈਕਸ਼ਨ:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**ਇਹ ਕੀ ਕਰਦਾ ਹੈ:**
- `@Service` Spring ਨੂੰ ਦੱਸਦਾ ਹੈ ਕਿ ਇਹ ਕਲਾਸ ਬਿਜ਼ਨਸ ਲਾਜਿਕ ਪ੍ਰਦਾਨ ਕਰਦੀ ਹੈ
- `@Value` `application.properties` ਤੋਂ ਕਨਫਿਗਰੇਸ਼ਨ ਮੁੱਲ Inject ਕਰਦਾ ਹੈ
- `:default-value` ਸਿੰਟੈਕਸ ਫਾਲਬੈਕ ਮੁੱਲ ਪ੍ਰਦਾਨ ਕਰਦਾ ਹੈ ਜੇ ਗੁਣ ਸੈਟ ਨਹੀਂ ਹਨ

#### ਕਲਾਇੰਟ ਇਨੀਸ਼ੀਅਲਾਈਜ਼ੇਸ਼ਨ:
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
- `@PostConstruct` Spring ਦੁਆਰਾ ਸੇਵਾ ਬਣਾਉਣ ਤੋਂ ਬਾਅਦ ਇਹ ਮੈਥਡ ਚਲਾਉਂਦਾ ਹੈ
- ਇੱਕ OpenAI ਕਲਾਇੰਟ ਬਣਾਉਂਦਾ ਹੈ ਜੋ ਤੁਹਾਡੇ ਸਥਾਨਕ Foundry Local ਇੰਸਟੈਂਸ ਨੂੰ ਪੋਇੰਟ ਕਰਦਾ ਹੈ
- `application.properties` ਤੋਂ ਬੇਸ URL ਪਹਿਲਾਂ ਹੀ `/v1` ਸ਼ਾਮਲ ਕਰਦਾ ਹੈ OpenAI API ਅਨੁਕੂਲਤਾ ਲਈ
- API ਕੁੰਜੀ "not-needed" 'ਤੇ ਸੈਟ ਕੀਤੀ ਜਾਂਦੀ ਹੈ ਕਿਉਂਕਿ ਸਥਾਨਕ ਵਿਕਾਸ ਪ੍ਰਮਾਣਿਕਤਾ ਦੀ ਲੋੜ ਨਹੀਂ ਰੱਖਦਾ

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
- **ChatCompletionCreateParams**: AI ਬੇਨਤੀ ਨੂੰ ਕਨਫਿਗਰ ਕਰਦਾ ਹੈ
  - `model`: ਦੱਸਦਾ ਹੈ ਕਿ ਕਿਹੜਾ AI ਮਾਡਲ ਵਰਤਣਾ ਹੈ (Foundry ਮਾਡਲ ਲਿਸਟ ਤੋਂ ਸਹੀ ID ਨਾਲ ਮੈਚ ਕਰਨਾ ਚਾਹੀਦਾ ਹੈ)
  - `addUserMessage`: ਤੁਹਾਡੇ ਸੁਨੇਹੇ ਨੂੰ ਗੱਲਬਾਤ ਵਿੱਚ ਸ਼ਾਮਲ ਕਰਦਾ ਹੈ
  - `maxCompletionTokens`: ਜਵਾਬ ਦੀ ਲੰਬਾਈ ਸੀਮਿਤ ਕਰਦਾ ਹੈ (ਸੰਸਾਧਨਾਂ ਨੂੰ ਬਚਾਉਂਦਾ ਹੈ)
  - `temperature`: randomness ਨੂੰ ਕੰਟਰੋਲ ਕਰਦਾ ਹੈ (0.0 = ਨਿਰਧਾਰਿਤ, 1.0 = ਰਚਨਾਤਮਕ)
- **API ਕਾਲ**: Foundry Local ਨੂੰ ਬੇਨਤੀ ਭੇਜਦਾ ਹੈ
- **ਜਵਾਬ ਸੰਭਾਲਣਾ**: AI ਦੇ ਟੈਕਸਟ ਜਵਾਬ ਨੂੰ ਸੁਰੱਖਿਅਤ ਤਰੀਕੇ ਨਾਲ ਕੱਢਦਾ ਹੈ
- **ਗਲਤੀ ਸੰਭਾਲਣਾ**: ਮਦਦਗਾਰ ਗਲਤੀ ਸੁਨੇਹਿਆਂ ਨਾਲ ਅਪਵਾਦਾਂ ਨੂੰ ਲਪੇਟਦਾ ਹੈ

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
- **spring-boot-starter**: ਮੁੱਖ Spring Boot ਫੰਕਸ਼ਨਲਿਟੀ ਪ੍ਰਦਾਨ ਕਰਦਾ ਹੈ
- **openai-java**: API ਕਮਿਊਨਿਕੇਸ਼ਨ ਲਈ OpenAI Java SDK
- **jackson-databind**: API ਕਾਲਾਂ ਲਈ JSON ਸੀਰੀਅਲਾਈਜ਼ੇਸ਼ਨ/ਡਿਸੀਰੀਅਲਾਈਜ਼ੇਸ਼ਨ ਨੂੰ ਸੰਭਾਲਦਾ ਹੈ

## ਇਹ ਸਭ ਕਿਵੇਂ ਕੰਮ ਕਰਦਾ ਹੈ

ਜਦੋਂ ਤੁਸੀਂ ਐਪਲੀਕੇਸ਼ਨ ਚਲਾਉਂਦੇ ਹੋ ਤਾਂ ਪੂਰਾ ਪ੍ਰਕਿਰਿਆ ਇਹ ਹੈ:

1. **ਸ਼ੁਰੂਆਤ**: Spring Boot ਸ਼ੁਰੂ ਹੁੰਦਾ ਹੈ ਅਤੇ `application.properties` ਨੂੰ ਪੜ੍ਹਦਾ ਹੈ
2. **ਸੇਵਾ ਬਣਾਉਣਾ**: Spring `FoundryLocalService` ਬਣਾਉਂਦਾ ਹੈ ਅਤੇ ਕਨਫਿਗਰੇਸ਼ਨ ਮੁੱਲ Inject ਕਰਦਾ ਹੈ
3. **ਕਲਾਇੰਟ ਸੈਟਅਪ**: `@PostConstruct` OpenAI ਕਲਾਇੰਟ ਨੂੰ Foundry Local ਨਾਲ ਕਨੈਕਟ ਕਰਨ ਲਈ ਇਨੀਸ਼ੀਅਲਾਈਜ਼ ਕਰਦਾ ਹੈ
4. **ਡੈਮੋ ਐਗਜ਼ਿਕਿਊਸ਼ਨ**: `CommandLineRunner` ਸ਼ੁਰੂਆਤ ਤੋਂ ਬਾਅਦ ਚਲਦਾ ਹੈ
5. **AI ਕਾਲ**: ਡੈਮੋ `foundryLocalService.chat()` ਨੂੰ ਇੱਕ ਟੈਸਟ ਸੁਨੇਹੇ ਨਾਲ ਕਾਲ ਕਰਦਾ ਹੈ
6. **API ਬੇਨਤੀ**: ਸੇਵਾ OpenAI-ਅਨੁਕੂਲ ਬੇਨਤੀ ਬਣਾਉਂਦੀ ਹੈ ਅਤੇ Foundry Local ਨੂੰ ਭੇਜਦੀ ਹੈ
7. **ਜਵਾਬ ਪ੍ਰੋਸੈਸਿੰਗ**: ਸੇਵਾ AI ਦੇ ਜਵਾਬ ਨੂੰ ਕੱਢਦੀ ਹੈ ਅਤੇ ਵਾਪਸ ਕਰਦੀ ਹੈ
8. **ਡਿਸਪਲੇ**: ਐਪਲੀਕੇਸ਼ਨ ਜਵਾਬ ਦਿਖਾਉਂਦਾ ਹੈ ਅਤੇ ਬੰਦ ਹੁੰਦਾ ਹੈ

## Foundry Local ਸੈਟਅਪ ਕਰਨਾ

Foundry Local ਸੈਟਅਪ ਕਰਨ ਲਈ, ਹੇਠਾਂ ਦਿੱਤੇ ਕਦਮਾਂ ਦੀ ਪਾਲਣਾ ਕਰੋ:

1. **Foundry Local ਇੰਸਟਾਲ ਕਰੋ** [Prerequisites](../../../../04-PracticalSamples/foundrylocal) ਸੈਕਸ਼ਨ ਵਿੱਚ ਦਿੱਤੀਆਂ ਹਦਾਇਤਾਂ ਦੀ ਵਰਤੋਂ ਕਰਕੇ।

2. **ਡਾਇਨੈਮਿਕ ਤਰੀਕੇ ਨਾਲ ਅਸਾਈਨ ਕੀਤੀ ਪੋਰਟ ਦੀ ਜਾਂਚ ਕਰੋ**। Foundry Local ਸ਼ੁਰੂ ਹੋਣ 'ਤੇ ਆਟੋਮੈਟਿਕ ਤਰੀਕੇ ਨਾਲ ਪੋਰਟ ਅਸਾਈਨ ਕਰਦਾ ਹੈ। ਆਪਣੀ ਪੋਰਟ ਪਤਾ ਕਰਨ ਲਈ:
   ```bash
   foundry service status
   ```
   
   **ਵਿਕਲਪਿਕ**: ਜੇ ਤੁਸੀਂ ਕਿਸੇ ਵਿਸ਼ੇਸ਼ ਪੋਰਟ (ਜਿਵੇਂ, 5273) ਦੀ ਵਰਤੋਂ ਕਰਨਾ ਪਸੰਦ ਕਰਦੇ ਹੋ, ਤਾਂ ਤੁਸੀਂ ਇਸਨੂੰ ਮੈਨੂਅਲੀ ਤਰੀਕੇ ਨਾਲ ਕਨਫਿਗਰ ਕਰ ਸਕਦੇ ਹੋ:
   ```bash
   foundry service set --port 5273
   ```


3. **AI ਮਾਡਲ ਡਾਊਨਲੋਡ ਕਰੋ** ਜੋ ਤੁਸੀਂ ਵਰਤਣਾ ਚਾਹੁੰਦੇ ਹੋ, ਉਦਾਹਰਣ ਲਈ, `phi-3.5-mini`, ਹੇਠਾਂ ਦਿੱਤੇ ਕਮਾਂਡ ਨਾਲ:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **application.properties ਫਾਈਲ ਕਨਫਿਗਰ ਕਰੋ** Foundry Local ਸੈਟਿੰਗਾਂ ਨਾਲ ਮੈਚ ਕਰਨ ਲਈ:
   - `base-url` ਵਿੱਚ ਪੋਰਟ ਨੂੰ ਅਪਡੇਟ ਕਰੋ (ਕਦਮ 2 ਤੋਂ), ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਇਸਦੇ ਅੰਤ ਵਿੱਚ `/v1` ਸ਼ਾਮਲ ਹੈ
   - ਮਾਡਲ ਨਾਮ ਨੂੰ ਵਰਜਨ ਨੰਬਰ ਸਮੇਤ ਅਪਡੇਟ ਕਰੋ (`foundry model list` ਨਾਲ ਜਾਂਚ ਕਰੋ)

   ਉਦਾਹਰਣ:
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

ਹੋਰ ਉਦਾਹਰਣਾਂ ਲਈ, [Chapter 04: Practical samples](../README.md) ਵੇਖੋ

## ਮੁਸ਼ਕਲਾਂ ਦਾ ਹੱਲ

### ਆਮ ਸਮੱਸਿਆਵਾਂ

**"Connection refused" ਜਾਂ "Service unavailable"**
- ਯਕੀਨੀ ਬਣਾਓ ਕਿ Foundry Local ਚੱਲ ਰਿਹਾ ਹੈ: `foundry model list`
- Foundry Local ਦੁਆਰਾ ਵਰਤਣ ਵਾਲੀ ਅਸਲ ਪੋਰਟ ਦੀ ਜਾਂਚ ਕਰੋ: `foundry service status`
- `application.properties` ਨੂੰ ਸਹੀ ਪੋਰਟ ਨਾਲ ਅਪਡੇਟ ਕਰੋ, ਯਕੀਨੀ ਬਣਾਓ ਕਿ URL `/v1` ਨਾਲ ਖਤਮ ਹੁੰਦਾ ਹੈ
- ਵਿਕਲਪਿਕ ਤੌਰ 'ਤੇ, ਜੇ ਚਾਹੁੰਦੇ ਹੋ, ਤਾਂ ਵਿਸ਼ੇਸ਼ ਪੋਰਟ ਸੈਟ ਕਰੋ: `foundry service set --port 5273`
- Foundry Local ਨੂੰ ਦੁਬਾਰਾ ਸ਼ੁਰੂ ਕਰਨ ਦੀ ਕੋਸ਼ਿਸ਼ ਕਰੋ: `foundry model run phi-3.5-mini`

**"Model not found" ਜਾਂ "404 Not Found" errors**
- ਉਪਲਬਧ ਮਾਡਲਾਂ ਦੇ ਸਹੀ IDs ਦੀ ਜਾਂਚ ਕਰੋ: `foundry model list`
- `application.properties` ਵਿੱਚ ਮਾਡਲ ਨਾਮ ਨੂੰ ਸਹੀ ਤਰੀਕੇ ਨਾਲ ਅਪਡੇਟ ਕਰੋ, ਵਰਜਨ ਨੰਬਰ ਸਮੇਤ (ਜਿਵੇਂ, `Phi-3.5-mini-instruct-cuda-gpu:1`)
- ਯਕੀਨੀ ਬਣਾਓ ਕਿ `base-url` `/v1` ਨਾਲ ਖਤਮ ਹੁੰਦਾ ਹੈ: `http://localhost:5273/v1`
- ਜੇ ਲੋੜ ਹੋਵੇ, ਤਾਂ ਮਾਡਲ ਡਾਊਨਲੋਡ ਕਰੋ: `foundry model run phi-3.5-mini`

**"400 Bad Request" errors**
- ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਬੇਸ URL `/v1` ਸ਼ਾਮਲ ਕਰਦਾ ਹੈ: `http://localhost:5273/v1`
- ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਮਾਡਲ ID ਸਹੀ ਤਰੀਕੇ ਨਾਲ `foundry model list` ਵਿੱਚ ਦਿੱਤੇ ID ਨਾਲ ਮੈਚ ਕਰਦਾ ਹੈ
- ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਤੁਸੀਂ ਆਪਣੇ ਕੋਡ ਵਿੱਚ `maxCompletionTokens()` ਦੀ ਵਰਤੋਂ ਕਰ ਰਹੇ ਹੋ (ਪੁਰਾਣੇ `maxTokens()` ਦੀ ਨਹੀਂ)

**Maven ਕੰਪਾਇਲੇਸ਼ਨ errors**
- ਯਕੀਨੀ ਬਣਾਓ Java 21 ਜਾਂ ਇਸ ਤੋਂ ਉੱਚਾ: `java -version`
- ਸਾਫ ਅਤੇ ਦੁਬਾਰਾ ਬਣਾਓ: `mvn clean compile`
- ਡਿਪੈਂਡੈਂਸੀ ਡਾਊਨਲੋਡ ਲਈ ਇੰਟਰਨੈਟ ਕਨੈਕਸ਼ਨ ਦੀ ਜਾਂਚ ਕਰੋ

**ਐਪਲੀਕੇਸ਼ਨ ਸ਼ੁਰੂ ਹੁੰਦੀ ਹੈ ਪਰ ਕੋਈ ਨਤੀਜਾ ਨਹੀਂ**
- ਯਕੀਨੀ ਬਣਾਓ ਕਿ Foundry Local ਜਵਾਬ ਦੇ ਰਿਹਾ ਹੈ: `http://localhost:5273/v1/models` ਜਾਂ `foundry service status` ਚਲਾਓ
- ਵਿਸ਼ੇਸ਼ ਗਲਤੀ ਸੁਨੇਹਿਆਂ ਲਈ ਐਪਲੀਕੇਸ਼ਨ ਲੌਗ ਦੀ ਜਾਂਚ ਕਰੋ
- ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਮਾਡਲ ਪੂਰੀ ਤਰ੍ਹਾਂ ਲੋਡ ਹੋਇਆ ਹੈ ਅਤੇ ਤਿਆਰ ਹੈ

---

**ਅਸਵੀਕਰਤੀ**:  
ਇਹ ਦਸਤਾਵੇਜ਼ AI ਅਨੁਵਾਦ ਸੇਵਾ [Co-op Translator](https://github.com/Azure/co-op-translator) ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਅਨੁਵਾਦ ਕੀਤਾ ਗਿਆ ਹੈ। ਜਦੋਂ ਕਿ ਅਸੀਂ ਸਹੀ ਹੋਣ ਦੀ ਕੋਸ਼ਿਸ਼ ਕਰਦੇ ਹਾਂ, ਕਿਰਪਾ ਕਰਕੇ ਧਿਆਨ ਦਿਓ ਕਿ ਸਵੈਚਾਲਿਤ ਅਨੁਵਾਦਾਂ ਵਿੱਚ ਗਲਤੀਆਂ ਜਾਂ ਅਸੁਚੀਤਤਾਵਾਂ ਹੋ ਸਕਦੀਆਂ ਹਨ। ਮੂਲ ਦਸਤਾਵੇਜ਼ ਨੂੰ ਇਸਦੀ ਮੂਲ ਭਾਸ਼ਾ ਵਿੱਚ ਅਧਿਕਾਰਤ ਸਰੋਤ ਮੰਨਿਆ ਜਾਣਾ ਚਾਹੀਦਾ ਹੈ। ਮਹੱਤਵਪੂਰਨ ਜਾਣਕਾਰੀ ਲਈ, ਪੇਸ਼ੇਵਰ ਮਨੁੱਖੀ ਅਨੁਵਾਦ ਦੀ ਸਿਫਾਰਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ। ਅਸੀਂ ਇਸ ਅਨੁਵਾਦ ਦੀ ਵਰਤੋਂ ਤੋਂ ਪੈਦਾ ਹੋਣ ਵਾਲੇ ਕਿਸੇ ਵੀ ਗਲਤਫਹਿਮੀ ਜਾਂ ਗਲਤ ਵਿਆਖਿਆ ਲਈ ਜ਼ਿੰਮੇਵਾਰ ਨਹੀਂ ਹਾਂ।