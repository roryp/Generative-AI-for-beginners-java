# Foundry Local Command-Line Application

>**Note**: This chapter includes a [**Tutorial**](./TUTORIAL.md) that guides you through the samples.

A simple Spring Boot command-line application that demonstrates how to connect to Foundry Local using the OpenAI Java SDK.

## What You'll Learn

- How to integrate Foundry Local with Spring Boot applications using the OpenAI Java SDK
- Best practices for local AI development and testing

## Table of Contents

- [What You'll Learn](#what-youll-learn)
- [Prerequisites](#prerequisites)
  - [Installing Foundry Local](#installing-foundry-local)
  - [Verification](#verification)
- [Configuration](#configuration)
- [Quick Start](#quick-start)
- [What the Application Does](#what-the-application-does)
- [Sample Output](#sample-output)
- [Architecture](#architecture)
- [Code Highlights](#code-highlights)
  - [OpenAI Java SDK Integration](#openai-java-sdk-integration)
  - [Chat Completion API](#chat-completion-api)
- [Troubleshooting](#troubleshooting)

## Prerequisites

> **⚠️ Note**: This application **does not run in the supplied devcontainer** as it requires Foundry Local to be installed and running on the host system.

### Installing Foundry Local

Before running this application, you need to install and start Foundry Local. Follow these steps:

1. **Ensure your system meets the requirements**:
   - **Operating System**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, or macOS
   - **Hardware**: 
     - Minimum: 8GB RAM, 3GB free disk space
     - Recommended: 16GB RAM, 15GB free disk space
   - **Network**: Internet connection for initial model download (optional for offline use)
   - **Acceleration (optional)**: NVIDIA GPU (2,000 series or newer), AMD GPU (6,000 series or newer), Qualcomm Snapdragon X Elite (8GB or more of memory), or Apple silicon
   - **Permissions**: Administrative privileges to install software on your device

2. **Install Foundry Local**:
   
   **For Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **For macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Alternatively, you can download the installer from the [Foundry Local GitHub repository](https://github.com/microsoft/Foundry-Local).

3. **Start your first model**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   The model downloads (which can take a few minutes, depending on your internet speed) and then runs. Foundry Local automatically selects the best model variant for your system (CUDA for NVIDIA GPUs, CPU version otherwise).

4. **Test the model** by asking a question in the same terminal:

   ```bash
   Why is the sky blue?
   ```

   You should see a response from the Phi model explaining why the sky appears blue.

### Verification

You can verify everything is working properly with these commands:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

You can also visit `http://localhost:5273` in your browser to see the Foundry Local web interface.

## Configuration

The application can be configured through `application.properties`:

- `foundry.local.base-url` - Base URL for Foundry Local (default: http://localhost:5273)
- `foundry.local.model` - AI model to use (default: Phi-3.5-mini-instruct-cuda-gpu)

> **Note**: The model name in the configuration should match the specific variant that Foundry Local downloaded for your system. When you run `foundry model run phi-3.5-mini`, Foundry Local automatically selects and downloads the best variant (CUDA for NVIDIA GPUs, CPU version otherwise). Use `foundry model list` to see the exact model name available in your local instance.

## Quick Start

### 1. Navigate to the foundry local application directory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Run the Application

```bash
mvn spring-boot:run
```

Or build and run the JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Dependencies

This application uses the OpenAI Java SDK to communicate with Foundry Local. The key dependency is:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

The application is pre-configured to connect to Foundry Local running on the default port.

## What the Application Does

When you run the application:

1. **Starts up** as a command-line application (no web server)
2. **Automatically sends** a test message: "Hello! Can you tell me what you are and what model you're running?"
3. **Displays the response** from Foundry Local in the console
4. **Exits cleanly** after the demo

## Sample Output

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Architecture

- **Application.java** - Main Spring Boot application with CommandLineRunner
- **FoundryLocalService.java** - Service that uses OpenAI Java SDK to communicate with Foundry Local
- Uses **OpenAI Java SDK** for type-safe API calls
- Automatic JSON serialization/deserialization handled by the SDK
- Clean configuration using Spring's `@Value` and `@PostConstruct` annotations

## Code Highlights

### OpenAI Java SDK Integration

The application uses the OpenAI Java SDK to create a client configured for Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### Chat Completion API

Making chat completion requests is simple and type-safe:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Troubleshooting

If you see connection errors:
1. Verify Foundry Local is running on `http://localhost:5273`
2. Check that a Phi-3.5-mini model variant is available with `foundry model list`
3. Ensure the model name in `application.properties` matches the exact model name shown in the list
4. Ensure no firewall is blocking the connection

Common issues:
- **Model not found**: Run `foundry model run phi-3.5-mini` to download and start the model
- **Service not running**: The Foundry Local service may have stopped; restart it with the model run command
- **Wrong model name**: Use `foundry model list` to see available models and update your configuration accordingly
