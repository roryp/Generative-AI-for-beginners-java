<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0cbf68d605615a1e602c832a24616859",
  "translation_date": "2025-11-18T17:56:46+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "pcm"
}
-->
# Pet Story Generator Tutorial for Beginners

## Table of Contents

- [Prerequisites](../../../../04-PracticalSamples/petstory)
- [Understanding the Project Structure](../../../../04-PracticalSamples/petstory)
- [Core Components Explained](../../../../04-PracticalSamples/petstory)
  - [1. Main Application](../../../../04-PracticalSamples/petstory)
  - [2. Web Controller](../../../../04-PracticalSamples/petstory)
  - [3. Story Service](../../../../04-PracticalSamples/petstory)
  - [4. Web Templates](../../../../04-PracticalSamples/petstory)
  - [5. Configuration](../../../../04-PracticalSamples/petstory)
- [Running the Application](../../../../04-PracticalSamples/petstory)
- [How It All Works Together](../../../../04-PracticalSamples/petstory)
- [Understanding the AI Integration](../../../../04-PracticalSamples/petstory)
- [Next Steps](../../../../04-PracticalSamples/petstory)

## Prerequisites

Before you start, make sure say you get:
- Java 21 or higher wey don dey your system
- Maven to manage dependencies
- GitHub account wey get personal access token (PAT) wey get `models:read` scope
- Small knowledge about Java, Spring Boot, and web development

## Understanding the Project Structure

Dis pet story project get some important files:

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

Na dis file be the entry point for our Spring Boot application:

```java
@SpringBootApplication
public class PetStoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetStoryApplication.class, args);
    }
}
```

**Wetin e dey do:**
- `@SpringBootApplication` annotation dey enable auto-configuration and component scanning
- E go start embedded web server (Tomcat) for port 8080
- E go create all the Spring beans and services wey you need automatically

### 2. Web Controller

**File:** `PetController.java`

Dis one dey handle all web requests and user interactions:

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

1. **Route Handling**: `@GetMapping("/")` dey show upload form, `@PostMapping("/generate-story")` dey process submissions
2. **Input Validation**: E dey check for empty descriptions and length limits
3. **Security**: E dey sanitize user input to stop XSS attacks
4. **Error Handling**: E dey provide fallback stories if AI service no work
5. **Model Binding**: E dey pass data go HTML templates using Spring `Model`

**Fallback System:**
Dis controller get pre-written story templates wey e go use if AI service no dey available:

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

Dis service dey communicate with GitHub Models to generate stories:

```java
@Service
public class StoryService {
    
    private final OpenAIClient openAIClient;
    private final String modelName;
    
    public StoryService(@Value("${github.models.endpoint}") String endpoint,
                       @Value("${github.models.model}") String modelName) {
        
        String githubToken = System.getenv("GITHUB_TOKEN");
        if (githubToken == null || githubToken.isBlank()) {
            throw new IllegalStateException("GITHUB_TOKEN environment variable must be set");
        }
        
        // Create OpenAI client configured for GitHub Models
        this.openAIClient = OpenAIOkHttpClient.builder()
                .baseUrl(endpoint)
                .apiKey(githubToken)
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

1. **OpenAI Client**: E dey use official OpenAI Java SDK wey don configure for GitHub Models
2. **System Prompt**: E dey set AI behavior to write family-friendly pet stories
3. **User Prompt**: E dey tell AI wetin story e go write based on description
4. **Parameters**: E dey control story length and creativity level
5. **Error Handling**: E dey throw exceptions wey controller go catch and handle

### 4. Web Templates

**File:** `index.html` (Upload Form)

Na dis page users dey describe their pets:

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

Dis one dey show the generated story:

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

1. **Thymeleaf Integration**: E dey use `th:` attributes for dynamic content
2. **Responsive Design**: CSS styling dey for mobile and desktop
3. **Error Handling**: E dey show validation errors to users
4. **Client-side Processing**: JavaScript dey for image analysis (using Transformers.js)

### 5. Configuration

**File:** `application.properties`

Dis one na configuration settings for the application:

```properties
spring.application.name=pet-story-app

# File upload limits
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB

# Logging configuration
logging.level.com.example.petstory=INFO

# GitHub Models configuration
github.models.endpoint=https://models.github.ai/inference
github.models.model=openai/gpt-4.1-nano
```

**Configuration explained:**

1. **File Upload**: E dey allow images wey big reach 10MB
2. **Logging**: E dey control wetin information go dey logged during execution
3. **GitHub Models**: E dey specify AI model and endpoint wey e go use
4. **Security**: E dey configure error handling to make sure sensitive information no go show

## Running the Application

### Step 1: Set Your GitHub Token

First, you go need set your GitHub token as environment variable:

**Windows (Command Prompt):**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Windows (PowerShell):**
```powershell
$env:GITHUB_TOKEN="your_github_token_here"
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

**Why dis one dey important:**
- GitHub Models dey require authentication to access AI models
- Using environment variables dey keep sensitive tokens comot from source code
- The `models:read` scope dey provide access to AI inference

### Step 2: Build and Run

Enter the project directory:
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

The application go start for `http://localhost:8080`.

### Step 3: Test the Application

1. **Open** `http://localhost:8080` for your browser
2. **Describe** your pet for the text area (e.g., "A playful golden retriever wey like to fetch")
3. **Click** "Generate Story" to get AI-generated story
4. **Alternatively**, upload pet image to automatically generate description
5. **View** the creative story wey base on your pet description

## How It All Works Together

Dis na the complete flow wey dey happen when you generate pet story:

1. **User Input**: You go describe your pet for the web form
2. **Form Submission**: Browser go send POST request to `/generate-story`
3. **Controller Processing**: `PetController` go validate and sanitize the input
4. **AI Service Call**: `StoryService` go send request to GitHub Models API
5. **Story Generation**: AI go generate creative story wey base on the description
6. **Response Handling**: Controller go receive the story and add am to the model
7. **Template Rendering**: Thymeleaf go render `result.html` with the story
8. **Display**: User go see the generated story for their browser

**Error Handling Flow:**
If AI service no work:
1. Controller go catch the exception
2. E go generate fallback story using pre-written templates
3. E go show the fallback story with note about AI unavailability
4. User go still get story, to make sure say e enjoy the experience

## Understanding the AI Integration

### GitHub Models API
The application dey use GitHub Models, wey dey provide free access to different AI models:

```java
// Authentication with GitHub token
this.openAIClient = OpenAIOkHttpClient.builder()
    .baseUrl("https://models.github.ai/inference")
    .apiKey(githubToken)
    .build();
```

### Prompt Engineering
The service dey use well-crafted prompts to get better results:

```java
String systemPrompt = "You are a creative storyteller who writes fun, " +
                     "family-friendly short stories about pets. " +
                     "Keep stories under 500 words and appropriate for all ages.";
```

### Response Processing
The AI response dey extracted and validated:

```java
ChatCompletion response = openAIClient.chat().completions().create(params);
String story = response.choices().get(0).message().content().orElse("");
```

## Next Steps

For more examples, check [Chapter 04: Practical samples](../README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Disclaimer**:  
Dis dokyument don use AI translet service [Co-op Translator](https://github.com/Azure/co-op-translator) do di translet. Even as we dey try make am correct, abeg make you sabi say AI translet fit get mistake or no dey accurate well. Di original dokyument wey dey for im native language na di one wey you go take as di correct source. For important mata, e good make you use professional human translet. We no go fit take blame for any misunderstanding or wrong interpretation wey fit happen because you use dis translet.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->