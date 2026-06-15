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

Bifo you start dis tutorial, make sure say you get:

- **Java 21 or higher** wey you don install for your system
- **Maven 3.6+** wey you go take build di project
- **Foundry Local** wey you don install and e dey run

### **Install Foundry Local:**

> **Note:** Foundry Local CLI dey available for **Windows** and **macOS** only. Linux dey supported via di [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Verify di installation:
```bash
foundry --version
```

## Project Overview

Dis project get four main parts:

1. **Application.java** - Di main Spring Boot application entry point
2. **FoundryLocalService.java** - Service layer wey dey handle AI communication
3. **application.properties** - Configuration for Foundry Local connection
4. **pom.xml** - Maven dependencies and project configuration

## Understanding the Code

### 1. Application Configuration (application.properties)

**File:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Wetin dis one dey do:**
- **base-url**: E dey specify where Foundry Local dey run, including di `/v1` path for OpenAI API compatibility. Di default port na `5273`. If di port different, check am with `foundry service status`.
- **model** (optional): Na di name of di AI model wey you go use for text generation. **By default, di application dey auto-detect di model** by querying Foundry Local `/v1/models` endpoint when e start up, so no need to set am. You fit still set am explicit if you want override di auto-detection.

**Main idea:** Spring Boot dey automatically load these properties and e go make dem available to your application with di use of `@Value` annotation.

### 2. Main Application Class (Application.java)

**File:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server need am
        app.run(args);
    }
```

**Wetin dis one dey do:**
- `@SpringBootApplication` dey enable Spring Boot auto-configuration
- `WebApplicationType.NONE` dey tell Spring say na command-line app dis be, no be web server
- Di main method dey start di Spring application

**Di Demo Runner:**
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

**Wetin dis one dey do:**
- `@Bean` dey create component wey Spring go manage
- `CommandLineRunner` dey run code after Spring Boot don start
- `foundryLocalService` dey automatically injected by Spring (dependency injection)
- E dey send test message to di AI and e go show di response

### 3. AI Service Layer (FoundryLocalService.java)

**File:** `src/main/java/com/example/FoundryLocalService.java`

#### Configuration Injection:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // E go detect by itself if e empty
```

**Wetin dis one dey do:**
- `@Service` dey tell Spring say dis class dey provide business logic
- `@Value` dey inject configuration values from application.properties
- Di model default na empty, wey go make am do **auto-detection** from Foundry Local once e start. Dis mean say di app fit work with any model wey dey for Foundry Local without you configure manually.

#### Client Initialization:
```java
@PostConstruct
public void init() {
    // Auto sabi di model from Foundry Local if e no clear say make e configure
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL don already get /v1 from configuration
            .apiKey("not-needed")            // Local server no need correct API key
            .build();
}
```

**Wetin dis one dey do:**
- `@PostConstruct` dey run dis method after Spring don create di service
- If no model dey configure, e go query Foundry Local `/v1/models` endpoint and e go pick di first loaded model
- E dey create OpenAI client wey dey point to your local Foundry Local instance
- Di base URL from `application.properties` don already include `/v1` for OpenAI API compatibility
- API key na "not-needed" because for local development no need authentication

#### Chat Method:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Which AI model we go use
                .addUserMessage(message)         // Your question/prompt
                .maxCompletionTokens(150)        // Make response no too long
                .temperature(0.7)                // Control how creative e go be (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Comot di AI response from di API result
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Wetin dis one dey do:**
- **ChatCompletionCreateParams**: E dey configure di AI request
  - `model`: E dey specify which AI model to use (e gats match di exact ID from `foundry model list`)
  - `addUserMessage`: E dey add your message to di conversation
  - `maxCompletionTokens`: E dey limit how long di response fit be (dis one dey save resources)
  - `temperature`: E dey control randomness (0.0 = certain, 1.0 = creative)
- **API Call**: E dey send di request go Foundry Local
- **Response Handling**: E dey collect di AI text response safely
- **Error Handling**: E dey wrap exceptions with beta error messages

### 4. Project Dependencies (pom.xml)

**Key Dependencies:**

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

**Wetin these ones dey do:**
- **spring-boot-starter**: E dey provide core Spring Boot functionality
- **openai-java**: Official OpenAI Java SDK wey dey do API communication
- **jackson-databind**: E dey handle JSON serialization/deserialization for API calls

## How It All Works Together

Dis na di full flow when you run di application:

1. **Startup**: Spring Boot start and e read `application.properties`
2. **Service Creation**: Spring create `FoundryLocalService` and e inject configuration values
3. **Model Detection**: If no model dey configure, di service go query Foundry Local `/v1/models` endpoint and e dey use di first available model automatically
4. **Client Setup**: `@PostConstruct` go initialize di OpenAI client to connect to Foundry Local
5. **Demo Execution**: `CommandLineRunner` go run after startup
6. **AI Call**: Di demo go call `foundryLocalService.chat()` with test message
7. **API Request**: Di service go build and send OpenAI-compatible request to Foundry Local
8. **Response Processing**: Di service go collect and return di AI response
9. **Display**: Di application go print di response then e go exit

## Setting Up Foundry Local

1. **Install Foundry Local** using di instructions for di [Prerequisites](#prerequisites) section.

2. **Start di service** (if e never dey run):
   ```bash
   foundry service start
   ```

3. **Check di service status** to make sure say e dey run and note di port:
   ```bash
   foundry service status
   ```

4. **Download and run model** (e go download for first time, dem dey cache for subsequent runs):
   ```bash
   foundry model run phi-4-mini
   ```
   Dis one go open interactive chat session. You fit exit wit `Ctrl+C`. Di model go still dey loaded for di service.

   > **Tip:** Run `foundry model list` to see all di available models. Replace `phi-4-mini` wit any alias from di catalog (e.g., `qwen2.5-0.5b` for small/faster model).

5. **Verify say di model don load:**
   ```bash
   foundry service ps
   ```

6. **Update `application.properties`** if e necessary:
   - Di default `base-url` (`http://localhost:5273/v1`) match di default CLI port. Update am only if `foundry service status` show different port.
   - Di model dey **auto-detect** at startup — no configuration needed.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Running the Application

### Step 1: Make sure say model dey loaded for Foundry Local
```bash
foundry service ps
```
If models no dey listed, load one:
```bash
foundry model run phi-4-mini
```

### Step 2: Build and Run di Application
For separate terminal:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Or build and run as JAR:
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

For beta examples, see [Chapter 04: Practical samples](../README.md)

## Troubleshooting

### Common Issues

**"Connection refused" or "Service unavailable"**
- Check di service: `foundry service status`
- Restart if e necessary: `foundry service restart`
- Make sure say di port for `application.properties` match `foundry service status` output
- Make sure say di URL end wit `/v1`: `http://localhost:5273/v1`

**"No model found" at startup**
- Di application dey auto-detect di model. Make sure say at least one model dey loaded: `foundry service ps`
- If no models loaded: `foundry model run phi-4-mini`
- If you override di model name inside `application.properties`, check say e match `foundry model list`

**"400 Bad Request" errors**
- Confirm di base URL contain `/v1`: `http://localhost:5273/v1`
- Make sure say you dey use `maxCompletionTokens()` for your code (no use di deprecated `maxTokens()`)

**Maven compilation errors**
- Make sure say Java 21 or higher dey installed: `java -version`
- Clean and rebuild: `mvn clean compile`
- Check di internet connection for dependency downloads

**Service connection problems**
- If you see `Request to local service failed`, run: `foundry service restart`
- Check loaded models: `foundry service ps`
- View service logs: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Disclaimer**:  
Dis dokument don translate wit AI translation service [Co-op Translator](https://github.com/Azure/co-op-translator). Even though we dey try make am correct, abeg sabi say automated translations fit get some mistakes or wrong tin. Di original dokument for im own language na di correct source. For important tin dem, make una use professional human translation. We no go responsible for any misunderstanding or wrong meaning wey fit show because of dis translation.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->