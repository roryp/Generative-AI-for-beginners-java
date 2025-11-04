<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "fe08a184d8a753a0f497673921f77759",
  "translation_date": "2025-11-04T06:34:16+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "en"
}
-->
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

Before starting this tutorial, ensure you have:

- **Java 21 or higher** installed on your system
- **Maven 3.6+** for building the project
- **Foundry Local** installed and running

### **Install Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## Project Overview

This project consists of four main components:

1. **Application.java** - The main Spring Boot application entry point
2. **FoundryLocalService.java** - Service layer that handles AI communication
3. **application.properties** - Configuration for Foundry Local connection
4. **pom.xml** - Maven dependencies and project configuration

## Understanding the Code

### 1. Application Configuration (application.properties)

**File:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**What this does:**
- **base-url**: Specifies where Foundry Local is running, including the `/v1` path for OpenAI API compatibility. **Note**: Foundry Local dynamically assigns a port, so check your actual port using `foundry service status`
- **model**: Names the AI model to use for text generation, including the version number (e.g., `:1`). Use `foundry model list` to see available models with their exact IDs

**Key concept:** Spring Boot automatically loads these properties and makes them available to your application using the `@Value` annotation.

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

**What this does:**
- `@SpringBootApplication` enables Spring Boot auto-configuration
- `WebApplicationType.NONE` tells Spring this is a command-line app, not a web server
- The main method starts the Spring application

**The Demo Runner:**
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

**What this does:**
- `@Bean` creates a component that Spring manages
- `CommandLineRunner` runs code after Spring Boot starts up
- `foundryLocalService` is automatically injected by Spring (dependency injection)
- Sends a test message to the AI and displays the response

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

**What this does:**
- `@Service` tells Spring this class provides business logic
- `@Value` injects configuration values from application.properties
- The `:default-value` syntax provides fallback values if properties aren't set

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

**What this does:**
- `@PostConstruct` runs this method after Spring creates the service
- Creates an OpenAI client that points to your local Foundry Local instance
- The base URL from `application.properties` already includes `/v1` for OpenAI API compatibility
- API key is set to "not-needed" because local development doesn't require authentication

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

**What this does:**
- **ChatCompletionCreateParams**: Configures the AI request
  - `model`: Specifies which AI model to use (must match the exact ID from `foundry model list`)
  - `addUserMessage`: Adds your message to the conversation
  - `maxCompletionTokens`: Limits how long the response can be (saves resources)
  - `temperature`: Controls randomness (0.0 = deterministic, 1.0 = creative)
- **API Call**: Sends the request to Foundry Local
- **Response Handling**: Extracts the AI's text response safely
- **Error Handling**: Wraps exceptions with helpful error messages

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

**What these do:**
- **spring-boot-starter**: Provides core Spring Boot functionality
- **openai-java**: Official OpenAI Java SDK for API communication
- **jackson-databind**: Handles JSON serialization/deserialization for API calls

## How It All Works Together

Here's the complete flow when you run the application:

1. **Startup**: Spring Boot starts and reads `application.properties`
2. **Service Creation**: Spring creates `FoundryLocalService` and injects configuration values
3. **Client Setup**: `@PostConstruct` initializes the OpenAI client to connect to Foundry Local
4. **Demo Execution**: `CommandLineRunner` executes after startup
5. **AI Call**: The demo calls `foundryLocalService.chat()` with a test message
6. **API Request**: Service builds and sends OpenAI-compatible request to Foundry Local
7. **Response Processing**: Service extracts and returns the AI's response
8. **Display**: Application prints the response and exits

## Setting Up Foundry Local

To set up Foundry Local, follow these steps:

1. **Install Foundry Local** using the instructions in the [Prerequisites](../../../../04-PracticalSamples/foundrylocal) section.

2. **Check the dynamically assigned port**. Foundry Local automatically assigns a port when it starts. Find your port with:
   ```bash
   foundry service status
   ```
   
   **Optional**: If you prefer to use a specific port (e.g., 5273), you can configure it manually:
   ```bash
   foundry service set --port 5273
   ```

3. **Download the AI model** you want to use, for example, `phi-3.5-mini`, with the following command:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **Configure the application.properties** file to match your Foundry Local settings:
   - Update the port in `base-url` (from step 2), ensuring it includes `/v1` at the end
   - Update the model name to include the version number (check with `foundry model list`)
   
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

### Step 2: Build and Run the Application
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

For more examples, see [Chapter 04: Practical samples](../README.md)

## Troubleshooting

### Common Issues

**"Connection refused" or "Service unavailable"**
- Make sure Foundry Local is running: `foundry model list`
- Check the actual port Foundry Local is using: `foundry service status`
- Update your `application.properties` with the correct port, ensuring the URL ends with `/v1`
- Alternatively, set a specific port if desired: `foundry service set --port 5273`
- Try restarting Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" or "404 Not Found" errors**
- Check available models with their exact IDs: `foundry model list`
- Update the model name in `application.properties` to match exactly, including the version number (e.g., `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Ensure the `base-url` includes `/v1` at the end: `http://localhost:5273/v1`
- Download the model if needed: `foundry model run phi-3.5-mini`

**"400 Bad Request" errors**
- Verify the base URL includes `/v1`: `http://localhost:5273/v1`
- Check that the model ID matches exactly what's shown in `foundry model list`
- Ensure you're using `maxCompletionTokens()` in your code (not the deprecated `maxTokens()`)

**Maven compilation errors**
- Ensure Java 21 or higher: `java -version`
- Clean and rebuild: `mvn clean compile`
- Check internet connection for dependency downloads

**Application starts but no output**
- Verify Foundry Local is responding: Open browser to `http://localhost:5273`
- Check application logs for specific error messages
- Ensure the model is fully loaded and ready

---

**Disclaimer**:  
This document has been translated using the AI translation service [Co-op Translator](https://github.com/Azure/co-op-translator). While we aim for accuracy, please note that automated translations may include errors or inaccuracies. The original document in its native language should be regarded as the authoritative source. For critical information, professional human translation is advised. We are not responsible for any misunderstandings or misinterpretations resulting from the use of this translation.