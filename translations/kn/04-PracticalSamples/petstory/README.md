# ಪೆಟ್ ಸ್ಟೋರಿ ಜನರೇಟರ್ ಟ್ಯುಟೋರಿಯಲ್ ಪ್ರಾರಂಭಿಕರಿಗಾಗಿ

## ವಿಷಯಗಳ ಪಟ್ಟಿಯು

- [ಪೂರ್ವಶರತ್ತುಗಳು](../../../../04-PracticalSamples/petstory)
- [ಪ್ರಾಜೆಕ್ಟ್ ರಚನೆಗೆ ಅರ್ಥಮಾಡಿಕೊಳ್ಳುವುದು](../../../../04-PracticalSamples/petstory)
- [ಮುಖ್ಯ ಘಟಕಗಳ ವಿವರಣೆ](../../../../04-PracticalSamples/petstory)
  - [1. ಮುಖ್ಯ ಅಪ್ಲಿಕೇಶನ್](../../../../04-PracticalSamples/petstory)
  - [2. ವೆಬ್ ಕಂಟ್ರೋಲರ್](../../../../04-PracticalSamples/petstory)
  - [3. ಸ್ಟೋರಿ ಸರ್ವೀಸ್](../../../../04-PracticalSamples/petstory)
  - [4. ವೆಬ್ ಟೆಂಪ್ಲೇಟ್ಸ್](../../../../04-PracticalSamples/petstory)
  - [5. ಸಂರಚನೆ](../../../../04-PracticalSamples/petstory)
- [ಅಪ್ಲಿಕೇಶನ್ ರನ್ ಮಾಡುವುದು](../../../../04-PracticalSamples/petstory)
- [ಎಲ್ಲವೂ ಹೇಗೆ ಒಟ್ಟಿಗೆ ಕೆಲಸ ಮಾಡುತ್ತದೆ](../../../../04-PracticalSamples/petstory)
- [ಎಐ ಇಂಟಿಗ್ರೇಶನ್ ಅರ್ಥಮಾಡಿಕೊಳ್ಳುವುದು](../../../../04-PracticalSamples/petstory)
- [ಮುಂದಿನ ಹಂತಗಳು](../../../../04-PracticalSamples/petstory)

## ಪೂರ್ವಶರತ್ತುಗಳು

ಪ್ರಾರಂಭಿಸುವ ಮೊದಲು, ನೀವು ಹೊಂದಿರಬೇಕಾದವು:
- Java 21 ಅಥವಾ ಹೆಚ್ಚಿನ ಆವೃತ್ತಿ
- Maven ಡಿಪೆಂಡೆನ್ಸಿ ನಿರ್ವಹಣೆಗೆ
- `models:read` ವ್ಯಾಪ್ತಿಯೊಂದಿಗೆ GitHub ಖಾತೆ ಮತ್ತು ಪರ್ಸನಲ್ ಆಕ್ಸೆಸ್ ಟೋಕನ್ (PAT)
- Java, Spring Boot, ಮತ್ತು ವೆಬ್ ಡೆವಲಪ್ಮೆಂಟ್ ಬಗ್ಗೆ ಮೂಲಭೂತ ಅರಿವು

## ಪ್ರಾಜೆಕ್ಟ್ ರಚನೆಗೆ ಅರ್ಥಮಾಡಿಕೊಳ್ಳುವುದು

ಪೆಟ್ ಸ್ಟೋರಿ ಪ್ರಾಜೆಕ್ಟ್‌ನಲ್ಲಿ ಕೆಲವು ಮುಖ್ಯ ಫೈಲ್‌ಗಳಿವೆ:

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

## ಮುಖ್ಯ ಘಟಕಗಳ ವಿವರಣೆ

### 1. ಮುಖ್ಯ ಅಪ್ಲಿಕೇಶನ್

**ಫೈಲ್:** `PetStoryApplication.java`

ಇದು ನಮ್ಮ Spring Boot ಅಪ್ಲಿಕೇಶನ್‌ನ ಎಂಟ್ರಿ ಪಾಯಿಂಟ್:

```java
@SpringBootApplication
public class PetStoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetStoryApplication.class, args);
    }
}
```

**ಇದು ಏನು ಮಾಡುತ್ತದೆ:**
- `@SpringBootApplication` ಅನೋಟೇಶನ್ ಸ್ವಯಂ-ಕಾನ್ಫಿಗರೇಶನ್ ಮತ್ತು ಕಾಂಪೊನೆಂಟ್ ಸ್ಕ್ಯಾನಿಂಗ್ ಅನ್ನು ಸಕ್ರಿಯಗೊಳಿಸುತ್ತದೆ
- 8080 ಪೋರ್ಟ್‌ನಲ್ಲಿ ಎಂಬೆಡೆಡ್ ವೆಬ್ ಸರ್ವರ್ (Tomcat) ಅನ್ನು ಪ್ರಾರಂಭಿಸುತ್ತದೆ
- ಅಗತ್ಯವಿರುವ ಎಲ್ಲಾ Spring ಬೀನ್ಸ್ ಮತ್ತು ಸರ್ವೀಸ್‌ಗಳನ್ನು ಸ್ವಯಂಚಾಲಿತವಾಗಿ ರಚಿಸುತ್ತದೆ

### 2. ವೆಬ್ ಕಂಟ್ರೋಲರ್

**ಫೈಲ್:** `PetController.java`

ಇದು ಎಲ್ಲಾ ವೆಬ್ ವಿನಂತಿಗಳು ಮತ್ತು ಬಳಕೆದಾರರ ಸಂವಹನಗಳನ್ನು ನಿರ್ವಹಿಸುತ್ತದೆ:

```java
@Controller
public class PetController {
    
    private final StoryService storyService;
    
    public PetController(StoryService storyService) {
        this.storyService = storyService;
    }
    
    @GetMapping("/")
    public String index() {
        return "index";  // ಇಂಡೆಕ್ಸ್.html ಟೆಂಪ್ಲೇಟನ್ನು ಹಿಂತಿರುಗಿಸುತ್ತದೆ
    }
    
    @PostMapping("/generate-story")
    public String generateStory(@RequestParam("description") String description, 
                               Model model, 
                               RedirectAttributes redirectAttributes) {
        
        // ಇನ್‌ಪುಟ್ ಮಾನ್ಯತೆ
        if (description.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Please provide a description.");
            return "redirect:/";
        }
        
        // ಭದ್ರತೆಯಿಗಾಗಿ ಇನ್‌ಪುಟ್ ಅನ್ನು ಶುದ್ಧೀಕರಿಸಿ
        String sanitizedDescription = sanitizeInput(description);
        
        // ದೋಷ ನಿರ್ವಹಣೆಯೊಂದಿಗೆ ಕಥೆಯನ್ನು ರಚಿಸಿ
        try {
            String story = storyService.generateStory(sanitizedDescription);
            model.addAttribute("caption", sanitizedDescription);
            model.addAttribute("story", story);
            return "result";  // ರಿಸಲ್ಟ್.html ಟೆಂಪ್ಲೇಟನ್ನು ಹಿಂತಿರುಗಿಸುತ್ತದೆ
            
        } catch (Exception e) {
            // AI ವಿಫಲವಾದರೆ ಬ್ಯಾಕಪ್ ಕಥೆಯನ್ನು ಬಳಸಿ
            String fallbackStory = generateFallbackStory(sanitizedDescription);
            model.addAttribute("story", fallbackStory);
            return "result";
        }
    }
    
    private String sanitizeInput(String input) {
        return input.replaceAll("[<>\"'&]", "")  // Remove dangerous characters
                   .trim()
                   .substring(0, Math.min(input.length(), 500));  // ಉದ್ದವನ್ನು ಮಿತಿಗೊಳಿಸಿ
    }
}
```

**ಮುಖ್ಯ ವೈಶಿಷ್ಟ್ಯಗಳು:**

1. **ರೂಟ್ ಹ್ಯಾಂಡ್ಲಿಂಗ್**: `@GetMapping("/")` ಅಪ್ಲೋಡ್ ಫಾರ್ಮ್ ಅನ್ನು ತೋರಿಸುತ್ತದೆ, `@PostMapping("/generate-story")` ಸಲ್ಲಿಕೆಗಳನ್ನು ಪ್ರಕ್ರಿಯೆಗೊಳಿಸುತ್ತದೆ
2. **ಇನ್‌ಪುಟ್ ಮಾನ್ಯತೆ**: ಖಾಲಿ ವಿವರಣೆಗಳು ಮತ್ತು ಉದ್ದ ಮಿತಿಗಳನ್ನು ಪರಿಶೀಲಿಸುತ್ತದೆ
3. **ಸುರಕ್ಷತೆ**: ಬಳಕೆದಾರರ ಇನ್‌ಪುಟ್ ಅನ್ನು XSS ದಾಳಿಗಳನ್ನು ತಡೆಯಲು ಸ್ಯಾನಿಟೈಸ್ ಮಾಡುತ್ತದೆ
4. **ದೋಷ ನಿರ್ವಹಣೆ**: AI ಸರ್ವೀಸ್ ವಿಫಲವಾದಾಗ ಬ್ಯಾಕಪ್ ಸ್ಟೋರಿ ಒದಗಿಸುತ್ತದೆ
5. **ಮಾಡೆಲ್ ಬೈಂಡಿಂಗ್**: Spring ನ `Model` ಬಳಸಿ HTML ಟೆಂಪ್ಲೇಟ್ಗಳಿಗೆ ಡೇಟಾವನ್ನು ಪಾಸ್ ಮಾಡುತ್ತದೆ

**Fallback ಸಿಸ್ಟಮ್:**
ಕಂಟ್ರೋಲರ್‌ನಲ್ಲಿ AI ಸರ್ವೀಸ್ ಲಭ್ಯವಿಲ್ಲದಾಗ ಬಳಸುವ ಪೂರ್ವ-ಬರೆದ ಸ್ಟೋರಿ ಟೆಂಪ್ಲೇಟ್ಗಳನ್ನು ಒಳಗೊಂಡಿದೆ:

```java
private String generateFallbackStory(String description) {
    String[] storyTemplates = {
        "Meet the most wonderful pet in the world – a furry ball of energy...",
        "Once upon a time, there lived a remarkable pet whose heart was as big...",
        "In a cozy home filled with love, there lived an extraordinary pet..."
    };
    
    // ನಿರಂತರ ಪ್ರತಿಸ್ಪಂದನೆಗಳಿಗಾಗಿ ವಿವರಣೆ ಹ್ಯಾಶ್ ಅನ್ನು ಬಳಸಿ
    int index = Math.abs(description.hashCode() % storyTemplates.length);
    return storyTemplates[index];
}
```

### 3. ಸ್ಟೋರಿ ಸರ್ವೀಸ್

**ಫೈಲ್:** `StoryService.java`

ಈ ಸರ್ವೀಸ್ GitHub Models ಜೊತೆ ಸಂವಹನ ಮಾಡಿ ಸ್ಟೋರಿ ರಚಿಸುತ್ತದೆ:

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
        
        // GitHub ಮಾದರಿಗಳಿಗೆ OpenAI ಗ್ರಾಹಕವನ್ನು ರಚಿಸಿ
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
        
        // AI ವಿನಂತಿಯನ್ನು ಸಂರಚಿಸಿ
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(modelName)
                .addSystemMessage(systemPrompt)
                .addUserMessage(userPrompt)
                .maxCompletionTokens(500)  // ಪ್ರತಿಕ್ರಿಯೆಯ ಉದ್ದವನ್ನು ಮಿತಿಗೊಳಿಸಿ
                .temperature(0.8)          // ಸೃಜನಶೀಲತೆಯನ್ನು ನಿಯಂತ್ರಿಸಿ (0.0-1.0)
                .build();
        
        // ವಿನಂತಿಯನ್ನು ಕಳುಹಿಸಿ ಮತ್ತು ಪ್ರತಿಕ್ರಿಯೆಯನ್ನು ಪಡೆಯಿರಿ
        ChatCompletion response = openAIClient.chat().completions().create(params);
        
        return response.choices().get(0).message().content().orElse("");
    }
}
```

**ಮುಖ್ಯ ಅಂಶಗಳು:**

1. **OpenAI ಕ್ಲೈಂಟ್**: GitHub Models ಗೆ ಕಾನ್ಫಿಗರ್ ಮಾಡಲಾದ ಅಧಿಕೃತ OpenAI Java SDK ಅನ್ನು ಬಳಸುತ್ತದೆ
2. **ಸಿಸ್ಟಮ್ ಪ್ರಾಂಪ್ಟ್**: AI ನ ವರ್ತನೆಗೆ ಕುಟುಂಬ ಸ್ನೇಹಿ ಪೆಟ್ ಸ್ಟೋರಿ ಬರೆಯಲು ಸೂಚಿಸುತ್ತದೆ
3. **ಬಳಕೆದಾರರ ಪ್ರಾಂಪ್ಟ್**: ವಿವರಣೆಯ ಆಧಾರದ ಮೇಲೆ AI ಗೆ ಯಾವ ಸ್ಟೋರಿ ಬರೆಯಬೇಕೆಂದು ತಿಳಿಸುತ್ತದೆ
4. **ಪ್ಯಾರಾಮೀಟರ್‌ಗಳು**: ಸ್ಟೋರಿ ಉದ್ದ ಮತ್ತು ಸೃಜನಶೀಲತೆಯ ಮಟ್ಟವನ್ನು ನಿಯಂತ್ರಿಸುತ್ತದೆ
5. **ದೋಷ ನಿರ್ವಹಣೆ**: ಕಂಟ್ರೋಲರ್ ಹಿಡಿಯುವ ಮತ್ತು ನಿರ್ವಹಿಸುವ ಎಕ್ಸೆಪ್ಷನ್‌ಗಳನ್ನು ಎಸೆದುಬಿಡುತ್ತದೆ

### 4. ವೆಬ್ ಟೆಂಪ್ಲೇಟ್ಸ್

**ಫೈಲ್:** `index.html` (ಅಪ್ಲೋಡ್ ಫಾರ್ಮ್)

ಬಳಕೆದಾರರು ತಮ್ಮ ಪೆಟ್‌ಗಳನ್ನು ವಿವರಿಸುವ ಮುಖ್ಯ ಪುಟ:

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

**ಫೈಲ್:** `result.html` (ಸ್ಟೋರಿ ಪ್ರದರ್ಶನ)

ರಚಿಸಲಾದ ಸ್ಟೋರಿ ತೋರಿಸುತ್ತದೆ:

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

**ಟೆಂಪ್ಲೇಟ್ ವೈಶಿಷ್ಟ್ಯಗಳು:**

1. **Thymeleaf ಇಂಟಿಗ್ರೇಶನ್**: ಡೈನಾಮಿಕ್ ವಿಷಯಕ್ಕಾಗಿ `th:` ಗುಣಲಕ್ಷಣಗಳನ್ನು ಬಳಸುತ್ತದೆ
2. **ಪ್ರತಿಕ್ರಿಯಾಶೀಲ ವಿನ್ಯಾಸ**: ಮೊಬೈಲ್ ಮತ್ತು ಡೆಸ್ಕ್‌ಟಾಪ್‌ಗಾಗಿ CSS ಶೈಲೀಕರಣ
3. **ದೋಷ ನಿರ್ವಹಣೆ**: ಬಳಕೆದಾರರಿಗೆ ಮಾನ್ಯತೆ ದೋಷಗಳನ್ನು ತೋರಿಸುತ್ತದೆ
4. **ಕ್ಲೈಂಟ್-ಸೈಡ್ ಪ್ರೊಸೆಸಿಂಗ್**: ಚಿತ್ರ ವಿಶ್ಲೇಷಣೆಗೆ JavaScript (Transformers.js ಬಳಸಿ)

### 5. ಸಂರಚನೆ

**ಫೈಲ್:** `application.properties`

ಅಪ್ಲಿಕೇಶನ್‌ನ ಸಂರಚನಾ ಸೆಟ್ಟಿಂಗ್‌ಗಳು:

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

**ಸಂರಚನೆ ವಿವರಣೆ:**

1. **ಫೈಲ್ ಅಪ್ಲೋಡ್**: 10MB ವರೆಗೆ ಚಿತ್ರಗಳನ್ನು ಅನುಮತಿಸುತ್ತದೆ
2. **ಲಾಗಿಂಗ್**: ಕಾರ್ಯಾಚರಣೆಯ ಸಮಯದಲ್ಲಿ ಯಾವ ಮಾಹಿತಿಯನ್ನು ಲಾಗ್ ಮಾಡಬೇಕೆಂದು ನಿಯಂತ್ರಿಸುತ್ತದೆ
3. **GitHub Models**: ಯಾವ AI ಮಾದರಿ ಮತ್ತು ಎಂಡ್‌ಪಾಯಿಂಟ್ ಅನ್ನು ಬಳಸಬೇಕೆಂದು ನಿರ್ದಿಷ್ಟಪಡಿಸುತ್ತದೆ
4. **ಸುರಕ್ಷತೆ**: ಸಂವೇದನಶೀಲ ಮಾಹಿತಿಯನ್ನು ಬಹಿರಂಗಪಡಿಸದಂತೆ ದೋಷ ನಿರ್ವಹಣೆ ಕಾನ್ಫಿಗರ್ ಮಾಡುತ್ತದೆ

## ಅಪ್ಲಿಕೇಶನ್ ರನ್ ಮಾಡುವುದು

### ಹಂತ 1: ನಿಮ್ಮ GitHub ಟೋಕನ್ ಸೆಟ್ ಮಾಡಿ

ಮೊದಲು, ನಿಮ್ಮ GitHub ಟೋಕನ್ ಅನ್ನು ಪರಿಸರ ವ್ಯತ್ಯಾಸವಾಗಿ ಸೆಟ್ ಮಾಡಬೇಕು:

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

**ಇದು ಏಕೆ ಅಗತ್ಯವಿದೆ:**
- GitHub Models AI ಮಾದರಿಗಳಿಗೆ ಪ್ರವೇಶ ಪಡೆಯಲು ಪ್ರಾಮಾಣೀಕರಣವನ್ನು ಅಗತ್ಯವಿದೆ
- ಪರಿಸರ ವ್ಯತ್ಯಾಸಗಳನ್ನು ಬಳಸುವುದು ಸಂವೇದನಶೀಲ ಟೋಕನ್‌ಗಳನ್ನು ಮೂಲ ಕೋಡ್‌ನಿಂದ ದೂರ ಇಡುತ್ತದೆ
- `models:read` ವ್ಯಾಪ್ತಿ AI ಇನ್ಫರೆನ್ಸ್‌ಗೆ ಪ್ರವೇಶ ಒದಗಿಸುತ್ತದೆ

### ಹಂತ 2: ಬಿಲ್ಡ್ ಮತ್ತು ರನ್

ಪ್ರಾಜೆಕ್ಟ್ ಡೈರೆಕ್ಟರಿಯಲ್ಲಿಗೆ ಹೋಗಿ:
```bash
cd 04-PracticalSamples/petstory
```

ಅಪ್ಲಿಕೇಶನ್ ಬಿಲ್ಡ್ ಮಾಡಿ:
```bash
mvn clean compile
```

ಸರ್ವರ್ ಪ್ರಾರಂಭಿಸಿ:
```bash
mvn spring-boot:run
```

ಅಪ್ಲಿಕೇಶನ್ `http://localhost:8080` ನಲ್ಲಿ ಪ್ರಾರಂಭವಾಗುತ್ತದೆ.

### ಹಂತ 3: ಅಪ್ಲಿಕೇಶನ್ ಪರೀಕ್ಷಿಸಿ

1. **ತೆರೆಯಿರಿ** `http://localhost:8080` ನಿಮ್ಮ ಬ್ರೌಸರ್‌ನಲ್ಲಿ
2. **ವಿವರಿಸಿ** ನಿಮ್ಮ ಪೆಟ್ ಅನ್ನು ಟೆಕ್ಸ್ಟ್ ಪ್ರದೇಶದಲ್ಲಿ (ಉದಾ., "ಒಂದು ಆಟಪಟು ಗೋಲ್ಡನ್ ರಿಟ್ರೀವರ್, ಅದು ಫೆಚ್ ಆಟವನ್ನು ಪ್ರೀತಿಸುತ್ತದೆ")
3. **ಕ್ಲಿಕ್ ಮಾಡಿ** "Generate Story" AI ರಚಿಸಿದ ಸ್ಟೋರಿ ಪಡೆಯಲು
4. **ಅಥವಾ**, ಪೆಟ್ ಚಿತ್ರವನ್ನು ಅಪ್ಲೋಡ್ ಮಾಡಿ ಸ್ವಯಂಚಾಲಿತವಾಗಿ ವಿವರಣೆ ರಚಿಸಲು
5. **ನೋಡಿ** ನಿಮ್ಮ ಪೆಟ್‌ನ ವಿವರಣೆಯ ಆಧಾರದ ಮೇಲೆ ಸೃಜನಶೀಲ ಸ್ಟೋರಿ

## ಎಲ್ಲವೂ ಹೇಗೆ ಒಟ್ಟಿಗೆ ಕೆಲಸ ಮಾಡುತ್ತದೆ

ನೀವು ಪೆಟ್ ಸ್ಟೋರಿ ರಚಿಸಿದಾಗ ಸಂಪೂರ್ಣ ಪ್ರಕ್ರಿಯೆ ಹೀಗಿದೆ:

1. **ಬಳಕೆದಾರರ ಇನ್‌ಪುಟ್**: ನೀವು ವೆಬ್ ಫಾರ್ಮ್‌ನಲ್ಲಿ ನಿಮ್ಮ ಪೆಟ್ ಅನ್ನು ವಿವರಿಸುತ್ತೀರಿ
2. **ಫಾರ್ಮ್ ಸಲ್ಲಿಕೆ**: ಬ್ರೌಸರ್ `/generate-story` ಗೆ POST ವಿನಂತಿಯನ್ನು ಕಳುಹಿಸುತ್ತದೆ
3. **ಕಂಟ್ರೋಲರ್ ಪ್ರೊಸೆಸಿಂಗ್**: `PetController` ಇನ್‌ಪುಟ್ ಅನ್ನು ಮಾನ್ಯತೆಗೊಳಿಸಿ ಸ್ಯಾನಿಟೈಸ್ ಮಾಡುತ್ತದೆ
4. **AI ಸರ್ವೀಸ್ ಕರೆ**: `StoryService` GitHub Models API ಗೆ ವಿನಂತಿಯನ್ನು ಕಳುಹಿಸುತ್ತದೆ
5. **ಸ್ಟೋರಿ ರಚನೆ**: AI ವಿವರಣೆಯ ಆಧಾರದ ಮೇಲೆ ಸೃಜನಶೀಲ ಸ್ಟೋರಿ ರಚಿಸುತ್ತದೆ
6. **ಪ್ರತಿಕ್ರಿಯೆ ನಿರ್ವಹಣೆ**: ಕಂಟ್ರೋಲರ್ ಸ್ಟೋರಿ ಸ್ವೀಕರಿಸಿ ಮಾಡೆಲ್‌ಗೆ ಸೇರಿಸುತ್ತದೆ
7. **ಟೆಂಪ್ಲೇಟ್ ರೆಂಡರಿಂಗ್**: Thymeleaf `result.html` ಅನ್ನು ಸ್ಟೋರಿ ಜೊತೆಗೆ ರೆಂಡರ್ ಮಾಡುತ್ತದೆ
8. **ಪ್ರದರ್ಶನ**: ಬಳಕೆದಾರರು ತಮ್ಮ ಬ್ರೌಸರ್‌ನಲ್ಲಿ ರಚಿಸಲಾದ ಸ್ಟೋರಿ ನೋಡುತ್ತಾರೆ

**ದೋಷ ನಿರ್ವಹಣೆ ಪ್ರಕ್ರಿಯೆ:**
AI ಸರ್ವೀಸ್ ವಿಫಲವಾದರೆ:
1. ಕಂಟ್ರೋಲರ್ ಎಕ್ಸೆಪ್ಷನ್ ಅನ್ನು ಹಿಡಿಯುತ್ತದೆ
2. ಪೂರ್ವ-ಬರೆದ ಟೆಂಪ್ಲೇಟ್ಗಳನ್ನು ಬಳಸಿ ಬ್ಯಾಕಪ್ ಸ್ಟೋರಿ ರಚಿಸುತ್ತದೆ
3. AI ಲಭ್ಯವಿಲ್ಲದ ಬಗ್ಗೆ ಟಿಪ್ಪಣಿಯೊಂದಿಗೆ ಬ್ಯಾಕಪ್ ಸ್ಟೋರಿ ತೋರಿಸುತ್ತದೆ
4. ಬಳಕೆದಾರರು ಇನ್ನೂ ಒಂದು ಸ್ಟೋರಿ ಪಡೆಯುತ್ತಾರೆ, ಉತ್ತಮ ಬಳಕೆದಾರ ಅನುಭವವನ್ನು ಖಚಿತಪಡಿಸುತ್ತದೆ

## ಎಐ ಇಂಟಿಗ್ರೇಶನ್ ಅರ್ಥಮಾಡಿಕೊಳ್ಳುವುದು

### GitHub Models API
ಅಪ್ಲಿಕೇಶನ್ GitHub Models ಅನ್ನು ಬಳಸುತ್ತದೆ, ಇದು ವಿವಿಧ AI ಮಾದರಿಗಳಿಗೆ ಉಚಿತ ಪ್ರವೇಶವನ್ನು ಒದಗಿಸುತ್ತದೆ:

```java
// GitHub ಟೋಕನ್‌ನೊಂದಿಗೆ ದೃಢೀಕರಣ
this.openAIClient = OpenAIOkHttpClient.builder()
    .baseUrl("https://models.github.ai/inference")
    .apiKey(githubToken)
    .build();
```

### ಪ್ರಾಂಪ್ಟ್ ಎಂಜಿನಿಯರಿಂಗ್
ಸೇವೆಯು ಉತ್ತಮ ಫಲಿತಾಂಶಗಳನ್ನು ಪಡೆಯಲು ಎಚ್ಚರಿಕೆಯಿಂದ ರಚಿಸಲಾದ ಪ್ರಾಂಪ್ಟ್‌ಗಳನ್ನು ಬಳಸುತ್ತದೆ:

```java
String systemPrompt = "You are a creative storyteller who writes fun, " +
                     "family-friendly short stories about pets. " +
                     "Keep stories under 500 words and appropriate for all ages.";
```

### ಪ್ರತಿಕ್ರಿಯೆ ಪ್ರಕ್ರಿಯೆ
AI ಪ್ರತಿಕ್ರಿಯೆಯನ್ನು ಹೊರತೆಗೆಯಲಾಗುತ್ತದೆ ಮತ್ತು ಮಾನ್ಯತೆಗೊಳಿಸಲಾಗುತ್ತದೆ:

```java
ChatCompletion response = openAIClient.chat().completions().create(params);
String story = response.choices().get(0).message().content().orElse("");
```

## ಮುಂದಿನ ಹಂತಗಳು

ಹೆಚ್ಚಿನ ಉದಾಹರಣೆಗಳಿಗಾಗಿ, [Chapter 04: Practical samples](../README.md) ನೋಡಿ

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ಅಸ್ವೀಕಾರ**:  
ಈ ದಸ್ತಾವೇಜು AI ಅನುವಾದ ಸೇವೆ [Co-op Translator](https://github.com/Azure/co-op-translator) ಬಳಸಿ ಅನುವಾದಿಸಲಾಗಿದೆ. ನಾವು ನಿಖರತೆಯನ್ನು ಸಾಧಿಸಲು ಪ್ರಯತ್ನಿಸುತ್ತಿದ್ದರೂ, ದಯವಿಟ್ಟು ಗಮನಿಸಿ, ಸ್ವಯಂಚಾಲಿತ ಅನುವಾದಗಳಲ್ಲಿ ದೋಷಗಳು ಅಥವಾ ಅಸಡ್ಡೆಗಳು ಇರಬಹುದು. ಮೂಲ ಭಾಷೆಯಲ್ಲಿರುವ ಮೂಲ ದಸ್ತಾವೇಜು ಪ್ರಾಮಾಣಿಕ ಮೂಲವೆಂದು ಪರಿಗಣಿಸಬೇಕು. ಮಹತ್ವದ ಮಾಹಿತಿಗಾಗಿ, ವೃತ್ತಿಪರ ಮಾನವ ಅನುವಾದವನ್ನು ಶಿಫಾರಸು ಮಾಡಲಾಗುತ್ತದೆ. ಈ ಅನುವಾದವನ್ನು ಬಳಸುವ ಮೂಲಕ ಉಂಟಾಗುವ ಯಾವುದೇ ತಪ್ಪು ಅರ್ಥಗಳ ಅಥವಾ ತಪ್ಪು ವ್ಯಾಖ್ಯಾನಗಳ ಬಗ್ಗೆ ನಾವು ಹೊಣೆಗಾರರಲ್ಲ.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->