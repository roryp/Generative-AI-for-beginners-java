# Foundry Local Spring Boot Tutorial

## Table of Contents

- [Prerequisites](#prerequisites)
- [Project Overview](#project-overview)
- [Understanding the Code](#understanding-the-code)
  - [1. Application Configuration (application.properties)](#1-application-configuration-applicationproperties)
  - [2. Main Application Class (Application.java)](#2-main-application-class-applicationjava)
  - [3. AI Service Layer (FoundryLocalService.java)](#3-ai-service-layer-foundrylocalservicejava)
  - [4. Project Dependencies (pom.xml)](#4-project-dependencies-pomxml)
- [How It All Works Together](#how-it-all-works-together)
- [Setting Up Foundry Local](#setting-up-foundry-local)
- [Running the Application](#running-the-application)
- [Expected Output](#expected-output)
- [Next Steps](#next-steps)
- [Troubleshooting](#troubleshooting)


## Prerequisites

ਇਸ ਟਿਊਟੋਰਿਯਲ ਨੂੰ ਸ਼ੁਰੂ ਕਰਨ ਤੋਂ ਪਹਿਲਾਂ, ਯਕੀਨ ਕਰੋ ਕਿ ਤੁਹਾਡੇ ਕੋਲ:

- **Java 21 ਜਾਂ ਇਸ ਤੋਂ ਉਪਰ** ਤੁਹਾਡੇ ਸਿਸਟਮ 'ਤੇ ਇੰਸਟਾਲ ਹੈ
- ਪ੍ਰੋਜੈਕਟ ਬਣਾਉਣ ਲਈ **Maven 3.6+**
- **Foundry Local** ਇੰਸਟਾਲ ਅਤੇ ਚੱਲ ਰਿਹਾ ਹੈ

### **Foundry Local ਇੰਸਟਾਲ ਕਰੋ:**

> **ਨੋਟ:** Foundry Local CLI ਸਿਰਫ **Windows** ਅਤੇ **macOS** ਲਈ ਉਪਲਬਧ ਹੈ। Linux ਨੂੰ [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust) ਰਾਹੀਂ ਸਹਾਇਤਾ ਮਿਲਦੀ ਹੈ।

```bash
# ਵਿੰਡੋਜ਼
winget install Microsoft.FoundryLocal

# ਮੈਕਓਐਸ
brew tap microsoft/foundrylocal
brew install foundrylocal
```

ਇੰਸਟਾਲੇਸ਼ਨ ਨੂੰ ਚੈਕ ਕਰੋ:
```bash
foundry --version
```

## Project Overview

ਇਹ ਪ੍ਰੋਜੈਕਟ ਚਾਰ ਮੁੱਖ ਹਿੱਸਿਆਂ ਦਾ ਸਮੁੱਚਾ ਹੈ:

1. **Application.java** - ਮੁੱਖ Spring Boot ਐਪਲੀਕੇਸ਼ਨ ਇਨਟ੍ਰੀ ਪੌਇੰਟ
2. **FoundryLocalService.java** - ਸੇਵਾ ਪਰਤ ਜੋ AI ਸੰਚਾਰ ਨੂੰ ਸੰਭਾਲਦਾ ਹੈ
3. **application.properties** - Foundry Local ਸੰਪਰਕ ਲਈ ਵਿਵਸਥਾ
4. **pom.xml** - Maven ਨਿਰਭਰਤਾਵਾਂ ਅਤੇ ਪ੍ਰੋਜੈਕਟ ਕਾਂਫਿਗਰੇਸ਼ਨ

## Understanding the Code

### 1. Application Configuration (application.properties)

**ਫਾਇਲ:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**ਇਹ ਕੀ ਕਰਦਾ ਹੈ:**
- **base-url**: ਦਰਸਾਉਂਦਾ ਹੈ ਕਿ Foundry Local ਕਿੱਥੇ ਚੱਲ ਰਿਹਾ ਹੈ, ਜਿੱਥੇ `/v1` ਪਾਥ OpenAI API ਕੁੰਮਪੈਟਬਿਲਟੀ ਲਈ ਸ਼ਾਮਲ ਹੈ। ਡਿਫ਼ੌਲਟ ਪੋਰਟ `5273` ਹੈ। ਜੇ ਪੋਰਟ ਵੱਖਰਾ ਹੈ, ਤਾਂ `foundry service status` ਨਾਲ ਜਾਂਚ ਕਰੋ।
- **model** (ਵਿਕਲਪਿਕ): AI ਮਾਡਲ ਦਾ ਨਾਮ ਜਿਸਨੂੰ ਟੈਕਸਟ ਜਨਰੇਸ਼ਨ ਲਈ ਵਰਤਿਆ ਜਾਵੇ। **ਡੀਫੌਲਟ ਵਜੋਂ, ਐਪਲੀਕੇਸ਼ਨ Foundry Local ਦੇ `/v1/models` ਐਂਡਪੌਇੰਟ ਨੂੰ ਸਟਾਰਟਅੱਪ ’ਤੇ ਪੁੱਛ ਕੇ ਆਟੋ-ਡਿਟੈਕਟ ਕਰਦਾ ਹੈ, ਇਸ ਲਈ ਤੁਹਾਨੂੰ ਇਹ ਸੈੱਟ ਕਰਨ ਦੀ ਜ਼ਰੂਰਤ ਨਹੀਂ। ਤੁਸੀਂ ਚਾਹੋ ਤਾਂ ਅਪਨੀ ਮਰਜ਼ੀ ਨਾਲ ਸੈੱਟ ਕਰ ਸਕਦੇ ਹੋ।**

**ਮੁੱਖ ਧਾਰਨਾ:** Spring Boot ਇਹਨਾਂ ਪ੍ਰਾਪਰਟੀਜ਼ ਨੂੰ ਆਪਣੇ ਆਪ ਲੋਡ ਕਰਦਾ ਹੈ ਅਤੇ `@Value` ਐਨੋਟੇਸ਼ਨ ਰਾਹੀਂ ਤੁਹਾਡੇ ਐਪ ਵਿੱਚ ਉਪਲੱਬਧ ਕਰਵਾਉਂਦਾ ਹੈ।

### 2. Main Application Class (Application.java)

**ਫਾਇਲ:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // ਕੋਈ ਵੈੱਬ ਸਰਵਰ ਲੋੜੀਂਦਾ ਨਹੀਂ
        app.run(args);
    }
```

**ਇਹ ਕੀ ਕਰਦਾ ਹੈ:**
- `@SpringBootApplication` Spring Boot ਆਟੋਕਾਨਫਿਗਰੇਸ਼ਨ ਚਾਲੂ ਕਰਦਾ ਹੈ
- `WebApplicationType.NONE` ਦੱਸਦਾ ਹੈ ਕਿ ਇਹ ਕਮਾਂਡ-ਲਾਈਨ ਐਪ ਹੈ, ਵੈੱਬ ਸਰਵਰ ਨਹੀਂ
- ਮੇਨ ਮੈਥਡ Spring ਐਪ ਸ਼ੁਰੂ ਕਰਦਾ ਹੈ

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
- `@Bean` ਇਕ ਕੰਪੋਨੈਂਟ ਬਣਾਉਂਦਾ ਹੈ ਜਿਸਨੂੰ Spring ਮੈਨੇਜ ਕਰਦਾ ਹੈ
- `CommandLineRunner` Spring Boot ਦੇ ਸਟਾਰਟ ਹੋਣ ਤੋਂ ਬਾਅਦ ਕੋਡ ਚਲਾਉਂਦਾ ਹੈ
- `foundryLocalService` Spring ਵੱਲੋਂ ਆਟੋਮੈਟਿਕ ਇੰਜੈਕਟ ਕੀਤਾ ਜਾਂਦਾ ਹੈ (ਡਿਪੈਂਡਸੀ ਇੰਜੈਕਸ਼ਨ)
- AI ਨੂੰ ਟੈਸਟ ਸੁਨੇਹਾ ਭੇਜਦਾ ਹੈ ਅਤੇ ਉੱਤਰ ਦਿਖਾਉਂਦਾ ਹੈ

### 3. AI Service Layer (FoundryLocalService.java)

**ਫਾਇਲ:** `src/main/java/com/example/FoundryLocalService.java`

#### ਕਾਂਫ਼ਿਗਰੇਸ਼ਨ ਇੰਜੈਕਸ਼ਨ:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // ਖਾਲੀ ਹੋਣ ਦੀ ਆਟੋ-ਪਹਚਾਨ ਕੀਤੀ
```

**ਇਹ ਕੀ ਕਰਦਾ ਹੈ:**
- `@Service` ਦੱਸਦਾ ਹੈ ਕਿ ਇਹ ਕਲਾਸ ਬਿਜ਼ਨੇਸ ਲੋਜਿਕ ਪ੍ਰਦਾਨ ਕਰਦੀ ਹੈ
- `@Value` application.properties ਤੋਂ ਕਾਂਫਿਗਰੇਸ਼ਨ ਵੈਲਯੂਜ਼ ਇੰਜੈਕਟ ਕਰਦਾ ਹੈ
- ਮਾਡਲ ਖਾਲੀ ਰਹਿੰਦਾ ਹੈ, ਜਿਸ ਨਾਲ Foundry Local ਤੋਂ ਆਟੋ-ਡਿਟੈਕਸ਼ਨ ਸਟਾਰਟਅੱਪ ’ਤੇ ਹੁੰਦੀ ਹੈ। ਇਸਦਾ ਮਤਲਬ ਹੈ ਕਿ ਐਪ ਕਿਸੇ ਵੀ ਮਾਡਲ ਨਾਲ ਕੰਮ ਕਰਦਾ ਹੈ ਜੋ Foundry Local ਵਿੱਚ ਲੋਡ ਹੈ ਬਿਨਾਂ ਹੱਥੋਂ ਕਾਂਫਿਗਰੇਸ਼ਨ ਕੀਤੇ।

#### ਕਲਾਇਂਟ ਇਨਿਸ਼ੀਅਲਾਈਜ਼ੇਸ਼ਨ:
```java
@PostConstruct
public void init() {
    // ਜੇ ਸਪਸ਼ਟ ਤੌਰ 'ਤੇ ਸੰਰਚਿਤ ਨਾ ਕੀਤਾ ਗਿਆ ਹੋਵੇ ਤਾਂ Foundry Local ਤੋਂ ਮਾਡਲ ਨੂੰ ਆਪਣੇ ਆਪ ਪਛਾਣੋ
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // ਬੇਸ URL ਵਿੱਚ ਪਹਿਲਾਂ ਹੀ ਸੰਰਚਨਾ ਤੋਂ /v1 ਸ਼ਾਮਲ ਹੈ
            .apiKey("not-needed")            // ਲੋਕਲ ਸਰਵਰ ਨੂੰ ਅਸਲੀ API ਕੁੰਜੀ ਦੀ ਲੋੜ ਨਹੀਂ ਹੈ
            .build();
}
```

**ਇਹ ਕੀ ਕਰਦਾ ਹੈ:**
- `@PostConstruct` ਇਹ ਮੈਥਡ Spring ਸੇਵਾ ਬਣਾਉਣ ਤੋਂ ਬਾਅਦ ਚਲਾਉਂਦਾ ਹੈ
- ਜੇ ਕੋਈ ਮਾਡਲ ਕੰਫਿਗਰ ਨਹੀਂ ਹੈ, ਤਾਂ ਇਹ Foundry Local ਦੇ `/v1/models` ਐਂਡਪੌਇੰਟ ਨੂੰ ਪੁੱਛਦਾ ਹੈ ਅਤੇ ਪਹਿਲਾ ਲੋਡ ਮਾਡਲ ਚੁਣਦਾ ਹੈ
- OpenAI ਕਲਾਇਂਟ ਬਣਾਉਂਦਾ ਹੈ ਜੋ ਤੁਹਾਡੇ ਲੋਕਲ Foundry Local ਇੰਸਟੰਸ ਨੂੰ ਪੌਇੰਟ ਕਰਦਾ ਹੈ
- application.properties ਤੋਂ ਮਿਲੇ base URL ਵਿੱਚ ਪਹਿਲਾਂ ਹੀ OpenAI API ਲਈ `/v1` ਸ਼ਾਮਲ ਹੈ
- API ਕੁੰਜੀ "not-needed" ਹੈ ਕਿਉਂਕਿ ਲੋਕਲ ਵਿਕਾਸ ਲਈ ਪ੍ਰਮਾਣਿਕਰਨ ਦੀ ਜ਼ਰੂਰਤ ਨਹੀਂ

#### ਚੈਟ ਮੈਥਡ:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // ਕਿਹੜਾ AI ਮਾਡਲ ਵਰਤਣਾ ਹੈ
                .addUserMessage(message)         // ਤੁਹਾਡਾ ਪ੍ਰਸ਼ਨ/ਪ੍ਰਾਂਪਟ
                .maxCompletionTokens(150)        // ਜਵਾਬ ਦੀ ਲੰਬਾਈ ਸੀਮਤ ਕਰੋ
                .temperature(0.7)                // ਰਚਨਾਤਮਕਤਾ ਨੂੰ ਕੰਟਰੋਲ ਕਰੋ (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // API ਨਤੀਜੇ ਤੋਂ AI ਦਾ ਜਵਾਬ ਕੱਢੋ
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
- **ChatCompletionCreateParams**: AI ਬੇਨਤੀ ਦੀ ਵਿਵਸਥਾ ਕਰਦਾ ਹੈ
  - `model`: ਕਿਹੜਾ AI ਮਾਡਲ ਵਰਤਣਾ (ਇਹ Foundry ਮਾਡਲ ਸੂਚੀ ਦੇ ਆਈ.ਡੀ. ਨਾਲ਼ ਮਿਲਣਾ ਚਾਹੀਦਾ ਹੈ)
  - `addUserMessage`: ਗੱਲਬਾਤ ਵਿੱਚ ਤੁਹਾਡਾ ਸੁਨੇਹਾ ਸ਼ਾਮਲ ਕਰਦਾ ਹੈ
  - `maxCompletionTokens`: ਜਵਾਬ ਦੀ ਲੰਬਾਈ ਸੀਮਿਤ ਕਰਦਾ ਹੈ (ਸੰਸਾਧਨਾਂ ਦੀ ਬਚਤ ਲਈ)
  - `temperature`: ਅਣਿਸ਼ਚਿਤਤਾ ਨੂੰ ਨਿਯੰਤਰਿਤ ਕਰਦਾ ਹੈ (0.0 = ਨਿਯਮਤ, 1.0 = ਰਚਨਾਤਮਕ)
- **API ਕਾਲ**: Foundry Local ਨੂੰ ਬੇਨਤੀ ਭੇਜਦਾ ਹੈ
- **ਜਵਾਬ ਸੰਭਾਲਣਾ**: AI ਦਾ ਪਾਠ ਸੁਰੱਖਿਅਤ ਤਰੀਕੇ ਨਾਲ ਕੱਢਦਾ ਹੈ
- **ਗਲਤੀ ਸੱਚਾਲਣਾ**: Exceptions ਨੂੰ ਮਦਦਗਾਰ ਚੁੱਕ ਤੋਂ ਬੱਝਦਾ ਹੈ

### 4. Project Dependencies (pom.xml)

**ਮੁੱਖ ਨਿਰਭਰਤਾਵਾਂ:**

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
- **spring-boot-starter**: ਕੋਰ Spring Boot ਕਾਰਜਿਕਤਾ ਦਿੰਦਾ ਹੈ
- **openai-java**: API ਸੰਚਾਰ ਲਈ ਅਧਿਕਾਰਿਕ OpenAI Java SDK
- **jackson-databind**: API ਕਾਲਾਂ ਲਈ JSON ਸੀਰੀਅਲਾਈਜ਼ੇਸ਼ਨ/ਡੀਸੀਰੀਅਲਾਈਜ਼ੇਸ਼ਨ ਸੰਭਾਲਦਾ ਹੈ

## How It All Works Together

ਐਪ ਚਲਾਉਂਦੇ ਸਮੇਂ ਪੂਰਾ ਫਲੋ ਇਸ ਤਰ੍ਹਾਂ ਹੈ:

1. **ਸ਼ੁਰੂਆਤ**: Spring Boot ਚੱਲਦਾ ਹੈ ਅਤੇ `application.properties` ਨੂੰ ਪੜ੍ਹਦਾ ਹੈ
2. **ਸੇਵਾ ਤਿਆਰ ਕਰਨੀ**: Spring `FoundryLocalService` ਬਣਾਉਂਦਾ ਹੈ ਅਤੇ ਕਾਂਫਿਗਰੇਸ਼ਨ ਵੈਲਯੂਜ਼ ਇੰਜੈਕਟ ਕਰਦਾ ਹੈ
3. **ਮਾਡਲ ਪਤਾ ਲਗਾਉਣਾ**: ਜੇ ਮਾਡਲ ਨਹੀਂ ਦਿੱਤਾ, ਤਾਂ ਸੇਵਾ Foundry Local ਦੇ `/v1/models` ਨੂੰ ਪੁੱਛਦਾ ਹੈ ਅਤੇ ਪਹਿਲਾ ਉਪਲੱਬਧ ਮਾਡਲ ਵਰਤਦਾ ਹੈ
4. **ਕਲਾਇੰਟ ਸੈਟਅੱਪ**: `@PostConstruct` OpenAI ਕਲਾਇੰਟ Foundry Local ਨਾਲ ਕਨੈਕਸ਼ਨ ਲਈ ਸ਼ੁਰੂ ਕਰਦਾ ਹੈ
5. **ਡੈਮੋ ਚਲਾਉਣਾ**: `CommandLineRunner` ਸਟਾਰਟਅੱਪ ਬਾਅਦ ਚਲਾਇਆ ਜਾਂਦਾ ਹੈ
6. **AI ਕਾਲ**: ਡੈਮੋ ਟੈਸਟ ਸੁਨੇਹਾ ਲਈ `foundryLocalService.chat()` ਕਾਲ ਕਰਦਾ ਹੈ
7. **API ਬੇਨਤੀ**: ਸੇਵਾ OpenAI-ਕੰਪੈਟਿਬਲ ਬੇਨਤੀ ਬਣਾਉਂਦਾ ਅਤੇ Foundry Local ਨੂੰ ਭੇਜਦਾ ਹੈ
8. **ਜਵਾਬ ਪ੍ਰੋਸੈਸਿੰਗ**: ਸੇਵਾ AI ਦੀ ਪਾਠ ਸੁਰੱਖਿਅਤ ਤਰੀਕੇ ਨਾਲ ਕੱਢਦਾ ਅਤੇ ਵਾਪਸ ਕਰਦਾ ਹੈ
9. **ਦਿਖਾਵਾ**: ਐਪਲੀਕੇਸ਼ਨ ਜਵਾਬ ਪ੍ਰਿੰਟ ਕਰਦਾ ਹੈ ਅਤੇ ਬੰਦ ਹੋ ਜਾਂਦਾ ਹੈ

## Setting Up Foundry Local

1. [Prerequisites](#prerequisites) ਦੇ ਹਦਾਇਤਾਂ ਮੁਤਾਬਕ **Foundry Local ਇੰਸਟਾਲ ਕਰੋ।**

2. **ਸੇਵਾ ਚਾਲੂ ਕਰੋ** (ਜੇ ਪਹਿਲਾਂ ਨਹੀਂ ਚੱਲ ਰਹੀ):
   ```bash
   foundry service start
   ```

3. ਸੇਵਾ ਦੀ ਸਥਿਤੀ ਜਾਂਚ ਕਰੋ ਕਿ ਇਹ ਚੱਲ ਰਹੀ ਹੈ ਤੇ ਪੋਰਟ ਨੋਟ ਕਰੋ:
   ```bash
   foundry service status
   ```

4. **ਮਾਡਲ ਡਾਊਨਲੋਡ ਅਤੇ ਚਲਾਓ** (ਪਹਿਲੀ ਵਾਰ ਡਾਊਨਲੋਡ ਹੁੰਦਾ ਹੈ, ਬਾਅਦ ਵਿੱਚ ਕੈਸ਼ ਕੀਤਾ ਜਾਂਦਾ ਹੈ):
   ```bash
   foundry model run phi-4-mini
   ```
   ਇਹ ਇੰਟਰਐਕਟਿਵ ਚੈਟ ਸੈਸ਼ਨ ਖੋਲਦਾ ਹੈ। ਤੁਸੀਂ `Ctrl+C` ਨਾਲ ਬਾਹਰ ਨਿਕਲ ਸਕਦੇ ਹੋ। ਮਾਡਲ ਸੇਵਾ ਵਿੱਚ ਲੋਡ ਰਹਿੰਦਾ ਹੈ।

   > **ਟਿਪ:** `foundry model list` ਚਲਾਓ ਤਾਂ ਜੋ ਸਾਰੇ ਉਪਲਬਧ ਮਾਡਲ ਵੇਖ ਸਕੋ। `phi-4-mini` ਦੇ ਥਾਂ ਕੈਟਾਲੌਗ ਤੋਂ ਕਿਸੇ ਵੀ ਤਖ਼ਲੀਫ ਨਾਮ ਨੂੰ ਬਦਲੋ (ਜਿਵੇਂ ਕਿ ਛੋਟਾ/ਤੇਜ਼ ਮਾਡਲ ਲਈ `qwen2.5-0.5b`)।

5. **ਕੰਫਰਮ ਕਰੋ ਕਿ ਮਾਡਲ ਲੋਡ ਹੈ:**
   ```bash
   foundry service ps
   ```

6. ਜੇ ਜ਼ਰੂਰਤ ਹੋਵੇ ਤਾਂ `application.properties` ਅਪਡੇਟ ਕਰੋ:
   - ਡਿਫੌਲਟ `base-url` (`http://localhost:5273/v1`) CLI ਪੋਰਟ ਨਾਲ ਮੇਲ ਖਾਂਦਾ ਹੈ। ਸਿਰਫ ਜੇ `foundry service status` ਵਿੱਚ ਅਲੱਗ ਪੋਰਟ ਹੈ ਤਾਂ ਬਦਲੋ।
   - ਮਾਡਲ ਸਟਾਰਟਅੱਪ ’ਤੇ **ਆਟੋ ਡਿਟੈਕਟ** ਹੁੰਦਾ ਹੈ — ਕੋਈ ਵਿਸ਼ੇਸ਼ ਵਿਵਸਥਾ ਲੋੜੀਂਦੀ ਨਹੀਂ।

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Running the Application

### ਕਦਮ 1: ਯਕੀਨ ਕਰੋ ਕਿ ਸੇਵਾ ਵਿੱਚ ਕੋਈ ਮਾਡਲ ਲੋਡ ਹੈ
```bash
foundry service ps
```
ਜੇ ਕੋਈ ਮਾਡਲ ਨਹੀਂ, ਤਾਂ ਲੋਡ ਕਰੋ:
```bash
foundry model run phi-4-mini
```

### ਕਦਮ 2: ਐਪਲੀਕੇਸ਼ਨ ਬਣਾਓ ਅਤੇ ਚਲਾਓ
ਕਿਸੇ ਹੋਰ ਟਰਮੀਨਲ ਵਿੱਚ:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

ਜਾਂ JAR ਵਜੋਂ ਬਣਾਓ ਅਤੇ ਚਲਾਓ:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Expected Output

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

## Next Steps

ਹੋਰ ਉਦਾਹਰਨਾਂ ਲਈ ਵੇਖੋ [Chapter 04: Practical samples](../README.md)

## Troubleshooting

### ਆਮ ਸਮੱਸਿਆਵਾਂ

**"Connection refused" ਜਾਂ "Service unavailable"**
- ਸੇਵਾ ਨੂੰ ਜਾਂਚੋ: `foundry service status`
- ਜ਼ਰੂਰਤ ਹੋਵੇ ਤਾਂ ਮੁੜ ਚਾਲੂ ਕਰੋ: `foundry service restart`
- ਯਕੀਨ ਕਰੋ ਕਿ `application.properties` ਵਿੱਚ ਪੋਰਟ `foundry service status` ਨਾਲ ਮੇਲ ਖਾਂਦਾ ਹੈ
- URL `/v1` 'ਤੇ ਖਤਮ ਹੋਣਾ ਚਾਹੀਦਾ ਹੈ: `http://localhost:5273/v1`

**"No model found" ਸਟਾਰਟਅੱਪ ’ਤੇ**
- ਐਪ ਆਟੋਮੈਟਿਕ ਮਾਡਲ ਡਿਟੈਕਟ ਕਰਦਾ ਹੈ। ਯਕੀਨ ਕਰੋ ਘੱਟੋ-ਘੱਟ ਇੱਕ ਮਾਡਲ ਲੋਡ ਹੈ: `foundry service ps`
- ਜੇ ਮਾਡਲ ਨਹੀਂ ਹੈ: `foundry model run phi-4-mini`
- ਜੇ ਤੁਸੀਂ `application.properties` ਵਿੱਚ ਮਾਡਲ ਦਾ ਨਾਮ ਦਿੱਤਾ ਹੈ, ਤਾਂ ਉਹ `foundry model list` ਨਾਲ ਮੇਲ ਖਾਂਦਾ ਹੈ ਜਾਂ ਨਹੀਂ ਦੇਖੋ

**"400 Bad Request" errors**
- ਯਕੀਨ ਕਰੋ base URL ਵਿੱਚ `/v1` ਸ਼ਾਮਲ ਹੈ: `http://localhost:5273/v1`
- ਆਪਣੇ ਕੋਡ ਵਿੱਚ `maxCompletionTokens()` ਵਰਤੋ (ਪੁਰਾਣਾ `maxTokens()` ਨਾਮੁਮਕੀਨ ਹੈ)

**Maven ਕੰਪਾਈਲੇਸ਼ਨ ਵਿੱਚ ਗਲਤੀਆਂ**
- ਯਕੀਨ ਕਰੋ Java 21 ਜਾਂ ਉਸ ਤੋਂ ਉਪਰ ਹੈ: `java -version`
- ਕਲੀਨ ਅਤੇ ਦੁਬਾਰਾ ਬਣਾਓ: `mvn clean compile`
- ਨਿਰਭਰਤਾਵਾਂ ਡਾਊਨਲੋਡ ਕਰਨ ਲਈ ਇੰਟਰਨੈੱਟ ਕਨੈਕਸ਼ਨ ਜਾਂਚੋ

**ਸੇਵਾ ਕਨੈਕਸ਼ਨ ਸਮੱਸਿਆਵਾਂ**
- ਜੇ ਤੁਹਾਨੂੰ ਦਿਖਾਈ ਦੇ ਰਿਹਾ ਹੈ `Request to local service failed`, ਤਾਂ ਚਲਾਓ: `foundry service restart`
- ਲੋਡ ਕੀਤੇ ਮਾਡਲ ਜਾਂਚੋ: `foundry service ps`
- ਸੇਵਾ ਲੌਗ ਦੇਖੋ: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ਅਸਵੀਕਾਰੋक्ति**:  
ਇਹ ਦਸਤਾਵੇਜ਼ AI ਅਨੁਵਾਦ ਸੇਵਾ [Co-op Translator](https://github.com/Azure/co-op-translator) ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਅਨੁਵਾਦਿਤ ਕੀਤਾ ਗਿਆ ਹੈ। ਜਦੋਂ ਕਿ ਅਸੀਂ ਸਹੀਤਾ ਲਈ ਕੋਸ਼ਿਸ਼ ਕਰਦੇ ਹਾਂ, ਕਿਰਪਾ ਕਰਕੇ ਧਿਆਨ ਰੱਖੋ ਕਿ ਆਟੋਮੈਟਿਕ ਅਨੁਵਾਦਾਂ ਵਿੱਚ ਗਲਤੀਆਂ ਜਾਂ ਅਸੁਚਿਤਤਾ ਹੋ ਸਕਦੀ ਹੈ। ਮੂਲ ਦਸਤਾਵੇਜ਼ ਆਪਣੀ ਮੂਲ ਭਾਸ਼ਾ ਵਿੱਚ ਪ੍ਰਮਾਣਿਕ ਸਰੋਤ ਮੰਨਿਆ ਜਾਣਾ ਚਾਹੀਦਾ ਹੈ। ਜਰੂਰੀ ਜਾਣਕਾਰੀ ਲਈ, ਪੇਸ਼ੇਵਰ ਮਨੁੱਖੀ ਅਨੁਵਾਦ ਦੀ ਸਿਫਾਰਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ। ਅਸੀਂ ਇਸ ਅਨੁਵਾਦ ਦੀ ਵਰਤੋਂ ਨਾਲ ਹੋਈ ਕਿਸੇ ਵੀ ਗਲਤ ਫਹਿਮੀ ਜਾਂ ਗਲਤ ਅਰਥ ਲੱਗਣ ਲਈ ਜ਼ਿੰਮੇਵਾਰ ਨਹੀਂ ਹਾਂ।
<!-- CO-OP TRANSLATOR DISCLAIMER END -->