# Foundry Local Spring Boot Tutorial

## Table of Contents

- [Prerequisites](../../../../04-PracticalSamples/foundrylocal)
- [Project Overview](../../../../04-PracticalSamples/foundrylocal)
- [Understanding the Code](../../../../04-PracticalSamples/foundrylocal)
  - [1. Application Configuration (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Main Application Class (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI Service Layer (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Project Dependencies (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [How It All Works Together](../../../../04-PracticalSamples/foundrylocal)
- [Setting Up Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [Running the Application](../../../../04-PracticalSamples/foundrylocal)
- [Expected Output](../../../../04-PracticalSamples/foundrylocal)
- [Next Steps](../../../../04-PracticalSamples/foundrylocal)
- [Troubleshooting](../../../../04-PracticalSamples/foundrylocal)


## Prerequisites

Before you start dis tutorial, make sure say you get:

- **Java 21 or higher** wey don dey your system
- **Maven 3.6+** to build di project
- **Foundry Local** wey don dey installed and dey run

### **Install Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
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
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**Wetin dis one dey do:**
- **base-url**: E dey show where Foundry Local dey run, including di `/v1` path for OpenAI API compatibility. **Note**: Foundry Local dey assign port automatically, so check di actual port wey e dey use with `foundry service status`
- **model**: E dey show di AI model wey you go use for text generation, including di version number (e.g., `:1`). Use `foundry model list` to see di available models with their exact IDs

**Key concept:** Spring Boot go load dis properties automatically and make dem dey available to your application using di `@Value` annotation.

### 2. Main Application Class (Application.java)

**File:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```

**Wetin dis one dey do:**
- `@SpringBootApplication` dey enable Spring Boot auto-configuration
- `WebApplicationType.NONE` dey tell Spring say na command-line app, no be web server
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
- E dey send test message to di AI and show di response

### 3. AI Service Layer (FoundryLocalService.java)

**File:** `src/main/java/com/example/FoundryLocalService.java`

#### Configuration Injection:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```

**Wetin dis one dey do:**
- `@Service` dey tell Spring say dis class dey provide business logic
- `@Value` dey inject configuration values from application.properties
- Di `:default-value` syntax dey provide fallback values if properties no dey set

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

**Wetin dis one dey do:**
- `@PostConstruct` dey run dis method after Spring don create di service
- E dey create OpenAI client wey dey point to your local Foundry Local instance
- Di base URL from `application.properties` don already include `/v1` for OpenAI API compatibility
- API key dey set to "not-needed" because local development no need authentication

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

**Wetin dis one dey do:**
- **ChatCompletionCreateParams**: E dey configure di AI request
  - `model`: E dey specify di AI model wey you go use (e must match di exact ID from `foundry model list`)
  - `addUserMessage`: E dey add your message to di conversation
  - `maxCompletionTokens`: E dey limit how long di response fit be (e dey save resources)
  - `temperature`: E dey control randomness (0.0 = deterministic, 1.0 = creative)
- **API Call**: E dey send di request to Foundry Local
- **Response Handling**: E dey extract di AI text response safely
- **Error Handling**: E dey wrap exceptions with helpful error messages

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

**Wetin dem dey do:**
- **spring-boot-starter**: E dey provide core Spring Boot functionality
- **openai-java**: Official OpenAI Java SDK for API communication
- **jackson-databind**: E dey handle JSON serialization/deserialization for API calls

## How It All Works Together

Dis na di full flow when you run di application:

1. **Startup**: Spring Boot go start and read `application.properties`
2. **Service Creation**: Spring go create `FoundryLocalService` and inject configuration values
3. **Client Setup**: `@PostConstruct` go initialize di OpenAI client to connect to Foundry Local
4. **Demo Execution**: `CommandLineRunner` go execute after startup
5. **AI Call**: Di demo go call `foundryLocalService.chat()` with test message
6. **API Request**: Service go build and send OpenAI-compatible request to Foundry Local
7. **Response Processing**: Service go extract and return di AI response
8. **Display**: Application go print di response and exit

## Setting Up Foundry Local

To set up Foundry Local, follow dis steps:

1. **Install Foundry Local** using di instructions wey dey di [Prerequisites](../../../../04-PracticalSamples/foundrylocal) section.

2. **Check di dynamically assigned port**. Foundry Local dey assign port automatically when e start. Find di port with:
   ```bash
   foundry service status
   ```
   
   **Optional**: If you wan use specific port (e.g., 5273), you fit configure am manually:
   ```bash
   foundry service set --port 5273
   ```

3. **Download di AI model** wey you wan use, for example, `phi-3.5-mini`, with di following command:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **Configure di application.properties** file to match your Foundry Local settings:
   - Update di port for `base-url` (from step 2), make sure say e include `/v1` for di end
   - Update di model name to include di version number (check with `foundry model list`)
   
   Example:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```

## Running the Application

### Step 1: Start Foundry Local
```bash
foundry model run phi-3.5-mini
```

### Step 2: Build and Run di Application
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
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```

## Next Steps

For more examples, check [Chapter 04: Practical samples](../README.md)

## Troubleshooting

### Common Issues

**"Connection refused" or "Service unavailable"**
- Make sure say Foundry Local dey run: `foundry model list`
- Check di actual port wey Foundry Local dey use: `foundry service status`
- Update your `application.properties` with di correct port, make sure say di URL end with `/v1`
- Alternatively, set specific port if you wan: `foundry service set --port 5273`
- Try restart Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" or "404 Not Found" errors**
- Check available models with their exact IDs: `foundry model list`
- Update di model name for `application.properties` to match am exactly, including di version number (e.g., `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Make sure say di `base-url` include `/v1` for di end: `http://localhost:5273/v1`
- Download di model if e never dey: `foundry model run phi-3.5-mini`

**"400 Bad Request" errors**
- Confirm say di base URL include `/v1`: `http://localhost:5273/v1`
- Check say di model ID match exactly wetin dey for `foundry model list`
- Make sure say you dey use `maxCompletionTokens()` for your code (no use di deprecated `maxTokens()`)

**Maven compilation errors**
- Confirm say Java 21 or higher dey: `java -version`
- Clean and rebuild: `mvn clean compile`
- Check internet connection for dependency downloads

**Application start but no output**
- Confirm say Foundry Local dey respond: Check `http://localhost:5273/v1/models` or run `foundry service status`
- Check application logs for specific error messages
- Make sure say di model don fully load and dey ready

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Disclaimer**:  
Dis docu don use AI translation service [Co-op Translator](https://github.com/Azure/co-op-translator) take translate am. Even though we dey try make sure say e correct, abeg no forget say automatic translation fit get mistake or no dey accurate well. Di original docu for di language wey dem write am first na di main correct one. For important information, e good make professional human translator check am. We no go fit take blame for any misunderstanding or wrong interpretation wey fit happen because of dis translation.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->