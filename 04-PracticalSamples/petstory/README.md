# Pet Story Generator Tutorial for Beginners

## Table of Contents

- [Prerequisites](#prerequisites)
- [Understanding the Project Structure](#understanding-the-project-structure)
- [Core Components Explained](#core-components-explained)
  - [1. Main Application](#1-main-application)
  - [2. Web Controller](#2-web-controller)
  - [3. Story Service](#3-story-service)
  - [4. Web Templates](#4-web-templates)
  - [5. Configuration](#5-configuration)
- [Running the Application](#running-the-application)
- [How It All Works Together](#how-it-all-works-together)
- [Understanding the AI Integration](#understanding-the-ai-integration)
- [Next Steps](#next-steps)

## Prerequisites

Before starting, make sure you have:
- Java 21 or higher installed
- Maven for dependency management
- An Azure AI Foundry model deployment (provision it with `azd up` — see [Chapter 2](../../02-SetupDevEnvironment/getting-started-azure-openai.md)), signed in with `az login` (keyless auth)
- Basic understanding of Java, Spring Boot, and web development

## Understanding the Project Structure

The pet story project has several important files:

```
petstory/
├── src/main/java/com/example/petstory/
│   ├── PetStoryApplication.java       # Main Spring Boot application
│   ├── PetController.java             # Web request handler
│   ├── StoryService.java              # AI story generation service
│   └── SecurityConfig.java            # Security configuration
├── src/main/resources/
│   ├── application.properties         # App configuration
│   └── templates/
│       ├── index.html                 # Upload form page
│       └── result.html               # Story display page
└── pom.xml                           # Maven dependencies
```

## Core Components Explained

### 1. Main Application

**File:** `PetStoryApplication.java`

This is the entry point for our Spring Boot application:

```java
@SpringBootApplication
public class PetStoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetStoryApplication.class, args);
    }
}
```

**What this does:**
- `@SpringBootApplication` annotation enables auto-configuration and component scanning
- Starts an embedded web server (Tomcat) on port 8080
- Creates all necessary Spring beans and services automatically

### 2. Web Controller

**File:** `PetController.java`

This handles all web requests and user interactions:

```java
@Controller
public class PetController {
    
    private final StoryService storyService;
    
    public PetController(StoryService storyService) {
        this.storyService = storyService;
    }
    
    @GetMapping("/")
    public String index() {
        return "index";  // Returns index.html template
    }
    
    @PostMapping("/generate-story")
    public String generateStory(@RequestParam("description") String description, 
                               Model model, 
                               RedirectAttributes redirectAttributes) {
        
        // Input validation
        if (description.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Please provide a description.");
            return "redirect:/";
        }
        
        // Sanitize input for security
        String sanitizedDescription = sanitizeInput(description);
        
        // Generate story with error handling
        try {
            String story = storyService.generateStory(sanitizedDescription);
            model.addAttribute("caption", sanitizedDescription);
            model.addAttribute("story", story);
            return "result";  // Returns result.html template
            
        } catch (Exception e) {
            // Use fallback story if AI fails
            String fallbackStory = generateFallbackStory(sanitizedDescription);
            model.addAttribute("story", fallbackStory);
            return "result";
        }
    }
    
    private String sanitizeInput(String input) {
        return input.replaceAll("[<>\"'&]", "")  // Remove dangerous characters
                   .trim()
                   .substring(0, Math.min(input.length(), 500));  // Limit length
    }
}
```

**Key features:**

1. **Route Handling**: `@GetMapping("/")` shows the upload form, `@PostMapping("/generate-story")` processes submissions
2. **Input Validation**: Checks for empty descriptions and length limits
3. **Security**: Sanitizes user input to prevent XSS attacks
4. **Error Handling**: Provides fallback stories when AI service fails
5. **Model Binding**: Passes data to HTML templates using Spring's `Model`

**Fallback System:**
The controller includes pre-written story templates that are used when the AI service is unavailable:

```java
private String generateFallbackStory(String description) {
    String[] storyTemplates = {
        "Meet the most wonderful pet in the world – a furry ball of energy...",
        "Once upon a time, there lived a remarkable pet whose heart was as big...",
        "In a cozy home filled with love, there lived an extraordinary pet..."
    };
    
    // Use description hash for consistent responses
    int index = Math.abs(description.hashCode() % storyTemplates.length);
    return storyTemplates[index];
}
```

### 3. Story Service

**File:** `StoryService.java`

This service communicates with Azure AI Foundry to generate stories using keyless authentication:

```java
@Service
public class StoryService {
    
    private final OpenAIClient openAIClient;
    private final String modelName;
    
    public StoryService(@Value("${azure.openai.endpoint:}") String endpoint,
                       @Value("${azure.openai.deployment:gpt-4o-mini}") String modelName) {
        this.modelName = modelName;
        if (endpoint == null || endpoint.isBlank()) {
            endpoint = System.getenv("AZURE_OPENAI_ENDPOINT");
        }
        
        // Foundry's OpenAI-compatible endpoint lives under /openai/v1/
        String baseUrl = (endpoint.endsWith("/") ? endpoint : endpoint + "/") + "openai/v1/";
        
        // Keyless authentication with Microsoft Entra ID (no API key)
        DefaultAzureCredential credential = new DefaultAzureCredentialBuilder().build();
        this.openAIClient = OpenAIOkHttpClient.builder()
                .baseUrl(baseUrl)
                .credential(BearerTokenCredential.create(
                        AuthenticationUtil.getBearerTokenSupplier(credential, "https://ai.azure.com/.default")))
                .build();
    }
    
    public String generateStory(String description) {
        String systemPrompt = "You are a creative storyteller who writes fun, " +
                             "family-friendly short stories about pets. " +
                             "Keep stories under 500 words and appropriate for all ages.";
        
        String userPrompt = "Write a fun short story about a pet described as: " + description;
        
        // Configure the AI request
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(modelName)
                .addSystemMessage(systemPrompt)
                .addUserMessage(userPrompt)
                .maxCompletionTokens(500)  // Limit response length
                .temperature(0.8)          // Control creativity (0.0-1.0)
                .build();
        
        // Send request and get response
        ChatCompletion response = openAIClient.chat().completions().create(params);
        
        return response.choices().get(0).message().content().orElse("");
    }
}
```

**Key components:**

1. **OpenAI Client**: Uses the official OpenAI Java SDK configured for Azure AI Foundry (keyless)
2. **System Prompt**: Sets the AI's behavior to write family-friendly pet stories
3. **User Prompt**: Tells the AI exactly what story to write based on the description
4. **Parameters**: Controls story length and creativity level
5. **Error Handling**: Throws exceptions that the controller catches and handles

### 4. Web Templates

**File:** `index.html` (Upload Form)

The main page where users describe their pets:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Pet Story Generator</title>
    <!-- CSS styling -->
</head>
<body>
    <div class="container">
        <h1>Pet Story Generator</h1>
        <p>Describe your pet and we'll create a fun story about them!</p>
        
        <!-- Error message display -->
        <div th:if="${error}" class="error" th:text="${error}"></div>
        
        <!-- Story generation form -->
        <form action="/generate-story" method="post">
            <div class="form-group">
                <label for="description">Describe your pet:</label>
                <textarea id="description" name="description" 
                         placeholder="Tell us about your pet - what they look like, their personality, favorite activities..."
                         maxlength="1000" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Generate Story</button>
        </form>
        
        <!-- Image upload section with client-side processing -->
        <div class="upload-section">
            <h2>Or Upload a Photo</h2>
            <input type="file" id="imageInput" accept="image/*" />
            <button onclick="analyzeImage()" class="upload-btn">Analyze Image</button>
        </div>
        
        <script>
            // Client-side image analysis using Transformers.js
            async function analyzeImage() {
                // Image processing code here
                // Generates description automatically from uploaded image
            }
        </script>
    </div>
</body>
</html>
```

**File:** `result.html` (Story Display)

Shows the generated story:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Pet Story Result</title>
</head>
<body>
    <div class="container">
        <h1>Your Pet's Story</h1>
        
        <div class="result-section">
            <div class="result-label">Pet Description:</div>
            <div class="result-content" th:text="${caption}"></div>
        </div>
        
        <div class="result-section">
            <div class="result-label">Generated Story:</div>
            <div class="result-content" th:text="${story}"></div>
        </div>
        
        <div class="result-section" th:if="${analysisType}">
            <div class="result-label">Analysis Type:</div>
            <div class="result-content" th:text="${analysisType}"></div>
        </div>
        
        <a href="/" class="back-link">Generate Another Story</a>
    </div>
</body>
</html>
```

**Template features:**

1. **Thymeleaf Integration**: Uses `th:` attributes for dynamic content
2. **Responsive Design**: CSS styling for mobile and desktop
3. **Error Handling**: Displays validation errors to users
4. **Client-side Processing**: JavaScript for image analysis (using Transformers.js)

### 5. Configuration

**File:** `application.properties`

Configuration settings for the application:

```properties
spring.application.name=pet-story-app

# File upload limits
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB

# Logging configuration
logging.level.com.example.petstory=INFO

# Azure AI Foundry (keyless) configuration
azure.openai.endpoint=${AZURE_OPENAI_ENDPOINT:}
azure.openai.deployment=${AZURE_OPENAI_DEPLOYMENT:gpt-4o-mini}
```

**Configuration explained:**

1. **File Upload**: Allows images up to 10MB
2. **Logging**: Controls what information is logged during execution
3. **Azure AI Foundry**: Specifies the endpoint and model deployment to use (keyless auth)
4. **Security**: Error handling configuration to avoid exposing sensitive information

## Running the Application

### Step 1: Sign In and Set Your Endpoint

Authentication is keyless (Microsoft Entra ID), so there's no API key. Sign in and set your Foundry endpoint:

**Windows (Command Prompt):**
```cmd
az login
set AZURE_OPENAI_ENDPOINT=https://your-resource.openai.azure.com/
```

**Windows (PowerShell):**
```powershell
az login
$env:AZURE_OPENAI_ENDPOINT="https://your-resource.openai.azure.com/"
```

**Linux/macOS:**
```bash
az login
export AZURE_OPENAI_ENDPOINT=https://your-resource.openai.azure.com/
```

**Why this is needed:**
- Azure AI Foundry uses Microsoft Entra ID to authenticate inference requests
- Keyless auth means no secrets in your source code or environment
- Your account needs the **Cognitive Services OpenAI User** role on the resource

### Step 2: Build and Run

Navigate to the project directory:
```bash
cd 04-PracticalSamples/petstory
```

Build the application:
```bash
mvn clean compile
```

Start the server:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

### Step 3: Test the Application

1. **Open** `http://localhost:8080` in your browser
2. **Describe** your pet in the text area (e.g., "A playful golden retriever who loves to fetch")
3. **Click** "Generate Story" to get an AI-generated story
4. **Alternatively**, upload a pet image to automatically generate a description
5. **View** the creative story based on your pet's description

## How It All Works Together

Here's the complete flow when you generate a pet story:

1. **User Input**: You describe your pet on the web form
2. **Form Submission**: Browser sends POST request to `/generate-story`
3. **Controller Processing**: `PetController` validates and sanitizes the input
4. **AI Service Call**: `StoryService` sends request to the Azure AI Foundry model
5. **Story Generation**: AI generates a creative story based on the description
6. **Response Handling**: Controller receives the story and adds it to the model
7. **Template Rendering**: Thymeleaf renders `result.html` with the story
8. **Display**: User sees the generated story in their browser

**Error Handling Flow:**
If the AI service fails:
1. Controller catches the exception
2. Generates a fallback story using pre-written templates
3. Displays the fallback story with a note about AI unavailability
4. User still gets a story, ensuring good user experience

## Understanding the AI Integration

### Azure AI Foundry (keyless)
The application uses Azure AI Foundry with keyless authentication (Microsoft Entra ID):

```java
// Keyless authentication - no API key
DefaultAzureCredential credential = new DefaultAzureCredentialBuilder().build();
this.openAIClient = OpenAIOkHttpClient.builder()
    .baseUrl(endpoint + "openai/v1/")
    .credential(BearerTokenCredential.create(
        AuthenticationUtil.getBearerTokenSupplier(credential, "https://ai.azure.com/.default")))
    .build();
```

### Prompt Engineering
The service uses carefully crafted prompts to get good results:

```java
String systemPrompt = "You are a creative storyteller who writes fun, " +
                     "family-friendly short stories about pets. " +
                     "Keep stories under 500 words and appropriate for all ages.";
```

### Response Processing
The AI response is extracted and validated:

```java
ChatCompletion response = openAIClient.chat().completions().create(params);
String story = response.choices().get(0).message().content().orElse("");
```

## Next Steps

For more examples, see [Chapter 04: Practical samples](../README.md)
