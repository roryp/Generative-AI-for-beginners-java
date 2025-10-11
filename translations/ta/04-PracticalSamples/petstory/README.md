<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0cbf68d605615a1e602c832a24616859",
  "translation_date": "2025-10-11T10:42:17+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "ta"
}
-->
# தொடக்கத்திற்கான செல்லப்பிராணி கதை உருவாக்கி பயிற்சி

## உள்ளடக்க அட்டவணை

- [முன்னேற்பாடுகள்](../../../../04-PracticalSamples/petstory)
- [திட்டத்தின் அமைப்பை புரிந்துகொள்வது](../../../../04-PracticalSamples/petstory)
- [முக்கிய கூறுகள் விளக்கம்](../../../../04-PracticalSamples/petstory)
  - [1. முக்கிய பயன்பாடு](../../../../04-PracticalSamples/petstory)
  - [2. வலை கட்டுப்படுத்தி](../../../../04-PracticalSamples/petstory)
  - [3. கதை சேவை](../../../../04-PracticalSamples/petstory)
  - [4. வலை வார்ப்புருக்கள்](../../../../04-PracticalSamples/petstory)
  - [5. கட்டமைப்பு](../../../../04-PracticalSamples/petstory)
- [பயன்பாட்டை இயக்குவது](../../../../04-PracticalSamples/petstory)
- [அனைத்தும் ஒன்றாக எப்படி வேலை செய்கிறது](../../../../04-PracticalSamples/petstory)
- [AI ஒருங்கிணைப்பை புரிந்துகொள்வது](../../../../04-PracticalSamples/petstory)
- [அடுத்த படிகள்](../../../../04-PracticalSamples/petstory)

## முன்னேற்பாடுகள்

தொடங்குவதற்கு முன், உங்களிடம் பின்வருவன இருக்க வேண்டும்:
- Java 21 அல்லது அதற்கு மேல் நிறுவப்பட்டிருக்க வேண்டும்
- Maven சார்பு மேலாண்மைக்காக
- `models:read` அளவுகோலுடன் GitHub கணக்கு மற்றும் தனிப்பட்ட அணுகல் டோக்கன் (PAT)
- Java, Spring Boot மற்றும் வலை மேம்பாட்டத்தின் அடிப்படை புரிதல்

## திட்டத்தின் அமைப்பை புரிந்துகொள்வது

செல்லப்பிராணி கதை திட்டத்தில் சில முக்கிய கோப்புகள் உள்ளன:

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

## முக்கிய கூறுகள் விளக்கம்

### 1. முக்கிய பயன்பாடு

**கோப்பு:** `PetStoryApplication.java`

இது எங்கள் Spring Boot பயன்பாட்டின் தொடக்க புள்ளியாகும்:

```java
@SpringBootApplication
public class PetStoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetStoryApplication.class, args);
    }
}
```

**இதன் செயல்பாடு:**
- `@SpringBootApplication` குறிப்பு தானியக்க-கட்டமைப்பு மற்றும் கூறு ஸ்கேனிங்கை இயக்குகிறது
- 8080 போர்டில் ஒரு உட்பொதிக்கப்பட்ட வலை சேவையகத்தை (Tomcat) தொடங்குகிறது
- தேவையான அனைத்து Spring பீன்கள் மற்றும் சேவைகளை தானாக உருவாக்குகிறது

### 2. வலை கட்டுப்படுத்தி

**கோப்பு:** `PetController.java`

இது அனைத்து வலை கோரிக்கைகள் மற்றும் பயனர் தொடர்புகளை கையாளுகிறது:

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

**முக்கிய அம்சங்கள்:**

1. **மார்க்கம் கையாளுதல்**: `@GetMapping("/")` பதிவேற்ற படிவத்தை காட்டுகிறது, `@PostMapping("/generate-story")` சமர்ப்பிப்புகளை செயல்படுத்துகிறது
2. **உள்ளீடு சரிபார்ப்பு**: காலியான விளக்கங்கள் மற்றும் நீள வரம்புகளை சரிபார்க்கிறது
3. **பாதுகாப்பு**: பயனர் உள்ளீட்டை சுத்திகரித்து XSS தாக்குதல்களைத் தடுக்கிறது
4. **பிழை கையாளுதல்**: AI சேவை தோல்வியடைந்தால் மாற்று கதைகளை வழங்குகிறது
5. **மாதிரி பிணைப்பு**: Spring இன் `Model` ஐப் பயன்படுத்தி HTML வார்ப்புருக்களுக்கு தரவை அனுப்புகிறது

**மாற்று அமைப்பு:**
AI சேவை கிடைக்காதபோது பயன்படுத்தப்படும் முன் எழுதப்பட்ட கதை வார்ப்புருக்கள் கட்டுப்படுத்தியில் உள்ளன:

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

### 3. கதை சேவை

**கோப்பு:** `StoryService.java`

இந்த சேவை GitHub Models உடன் தொடர்பு கொண்டு கதைகளை உருவாக்குகிறது:

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

**முக்கிய கூறுகள்:**

1. **OpenAI கிளையண்ட்**: GitHub Models க்கான OpenAI Java SDK ஐ பயன்படுத்துகிறது
2. **System Prompt**: குடும்பத்துடன் தொடர்புடைய செல்லப்பிராணி கதைகளை எழுத AI இன் நடத்தை அமைக்கிறது
3. **User Prompt**: விளக்கத்தின் அடிப்படையில் AI கதை எழுத சொல்லுகிறது
4. **அளவுகள்**: கதை நீளம் மற்றும் படைப்பாற்றல் நிலையை கட்டுப்படுத்துகிறது
5. **பிழை கையாளுதல்**: கட்டுப்படுத்தி பிடிக்கும் மற்றும் கையாளும் விதத்தில் εξαίρεσεις throw செய்கிறது

### 4. வலை வார்ப்புருக்கள்

**கோப்பு:** `index.html` (பதிவேற்ற படிவம்)

பயனர்கள் தங்கள் செல்லப்பிராணிகளை விவரிக்கும் முக்கிய பக்கம்:

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

**கோப்பு:** `result.html` (கதை காட்சி)

உருவாக்கப்பட்ட கதையை காட்டுகிறது:

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

**வார்ப்புரு அம்சங்கள்:**

1. **Thymeleaf ஒருங்கிணைப்பு**: `th:` பண்புகளை டைனமிக் உள்ளடக்கத்திற்காக பயன்படுத்துகிறது
2. **பதிலளிக்கக்கூடிய வடிவமைப்பு**: மொபைல் மற்றும் டெஸ்க்டாப் CSS ஸ்டைலிங்
3. **பிழை கையாளுதல்**: பயனர்களுக்கு சரிபார்ப்பு பிழைகளை காட்டுகிறது
4. **வாடிக்கையாளர் பக்கம் செயலாக்கம்**: Transformers.js ஐப் பயன்படுத்தி படத்தை பகுப்பாய்வு செய்ய JavaScript

### 5. கட்டமைப்பு

**கோப்பு:** `application.properties`

பயன்பாட்டிற்கான கட்டமைப்பு அமைப்புகள்:

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

**கட்டமைப்பு விளக்கம்:**

1. **கோப்பு பதிவேற்றம்**: 10MB வரை படங்களை அனுமதிக்கிறது
2. **பதிவேற்றம்**: செயல்படுத்தும் போது எந்த தகவல் பதிவேற்றம் செய்யப்பட வேண்டும் என்பதை கட்டுப்படுத்துகிறது
3. **GitHub Models**: எந்த AI மாடல் மற்றும் இறுதிப்புள்ளியை பயன்படுத்த வேண்டும் என்பதை குறிப்பிடுகிறது
4. **பாதுகாப்பு**: உணர்வான தகவல்களை வெளிப்படுத்தாமல் பிழை கையாளுதல் அமைப்பு

## பயன்பாட்டை இயக்குவது

### படி 1: உங்கள் GitHub டோக்கனை அமைக்கவும்

முதலில், உங்கள் GitHub டோக்கனை ஒரு சூழல் மாறியாக அமைக்க வேண்டும்:

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

**ஏன் இது தேவை:**
- GitHub Models AI மாடல்களை அணுக அங்கீகாரம் தேவை
- சூழல் மாறிகளைப் பயன்படுத்துவது உணர்வான டோக்கன்களை மூலக் கோப்பில் இருந்து விலக்குகிறது
- `models:read` அளவுகோல் AI முடிவுகளை அணுக அனுமதி வழங்குகிறது

### படி 2: கட்டமைக்கவும் மற்றும் இயக்கவும்

திட்ட அடைவு நோக்கி செல்லவும்:
```bash
cd 04-PracticalSamples/petstory
```

பயன்பாட்டை கட்டமைக்கவும்:
```bash
mvn clean compile
```

சேவையகத்தை தொடங்கவும்:
```bash
mvn spring-boot:run
```

பயன்பாடு `http://localhost:8080` இல் தொடங்கும்.

### படி 3: பயன்பாட்டை சோதிக்கவும்

1. **திறக்கவும்** `http://localhost:8080` உங்கள் உலாவியில்
2. **விவரிக்கவும்** உங்கள் செல்லப்பிராணியை உரை பகுதியில் (எ.கா., "ஒரு விளையாட்டுத்தனமான கோல்டன் ரெட்ரீவர் fetch செய்ய விரும்புகிறது")
3. **கிளிக் செய்யவும்** "Generate Story" AI உருவாக்கிய கதையைப் பெற
4. **மாற்றாக**, ஒரு செல்லப்பிராணி படத்தை பதிவேற்றி தானாக ஒரு விளக்கத்தை உருவாக்கவும்
5. **காண்க** உங்கள் செல்லப்பிராணியின் விளக்கத்தின் அடிப்படையில் உருவாக்கப்பட்ட படைப்பாற்றல் கதை

## அனைத்தும் ஒன்றாக எப்படி வேலை செய்கிறது

செல்லப்பிராணி கதையை உருவாக்கும்போது முழு செயல்பாடு இதோ:

1. **பயனர் உள்ளீடு**: நீங்கள் வலைப் படிவத்தில் உங்கள் செல்லப்பிராணியை விவரிக்கிறீர்கள்
2. **படிவ சமர்ப்பிப்பு**: உலாவி `/generate-story` க்கு POST கோரிக்கையை அனுப்புகிறது
3. **கட்டுப்படுத்தி செயலாக்கம்**: `PetController` உள்ளீட்டை சரிபார்த்து சுத்திகரிக்கிறது
4. **AI சேவை அழைப்பு**: `StoryService` GitHub Models API க்கு கோரிக்கையை அனுப்புகிறது
5. **கதை உருவாக்கம்**: AI விளக்கத்தின் அடிப்படையில் படைப்பாற்றல் கதையை உருவாக்குகிறது
6. **பதில் கையாளுதல்**: கட்டுப்படுத்தி கதையைப் பெறுகிறது மற்றும் மாதிரியில் சேர்க்கிறது
7. **வார்ப்புரு உருவாக்கம்**: Thymeleaf `result.html` ஐ கதை உடன் உருவாக்குகிறது
8. **காட்சி**: பயனர் தங்கள் உலாவியில் உருவாக்கப்பட்ட கதையைப் பார்க்கிறார்கள்

**பிழை கையாளுதல் செயல்பாடு:**
AI சேவை தோல்வியடைந்தால்:
1. கட்டுப்படுத்தி εξαίρεση பிடிக்கிறது
2. முன் எழுதப்பட்ட வார்ப்புருக்களைப் பயன்படுத்தி மாற்று கதையை உருவாக்குகிறது
3. AI கிடைக்காததற்கான குறிப்புடன் மாற்று கதையை காட்டுகிறது
4. பயனர் இன்னும் ஒரு கதையைப் பெறுகிறார், நல்ல பயனர் அனுபவத்தை உறுதிசெய்கிறது

## AI ஒருங்கிணைப்பை புரிந்துகொள்வது

### GitHub Models API
இந்த பயன்பாடு GitHub Models ஐ பயன்படுத்துகிறது, இது பல AI மாடல்களுக்கு இலவச அணுகலை வழங்குகிறது:

```java
// Authentication with GitHub token
this.openAIClient = OpenAIOkHttpClient.builder()
    .baseUrl("https://models.github.ai/inference")
    .apiKey(githubToken)
    .build();
```

### Prompt Engineering
சேவை நல்ல முடிவுகளைப் பெற கவனமாக வடிவமைக்கப்பட்ட prompts ஐ பயன்படுத்துகிறது:

```java
String systemPrompt = "You are a creative storyteller who writes fun, " +
                     "family-friendly short stories about pets. " +
                     "Keep stories under 500 words and appropriate for all ages.";
```

### Response Processing
AI பதில் எடுக்கப்பட்டு சரிபார்க்கப்படுகிறது:

```java
ChatCompletion response = openAIClient.chat().completions().create(params);
String story = response.choices().get(0).message().content().orElse("");
```

## அடுத்த படிகள்

மேலும் உதாரணங்களுக்கு, [அத்தியாயம் 04: நடைமுறை மாதிரிகள்](../README.md) ஐப் பார்க்கவும்

---

**குறிப்பு**:  
இந்த ஆவணம் [Co-op Translator](https://github.com/Azure/co-op-translator) என்ற AI மொழிபெயர்ப்பு சேவையைப் பயன்படுத்தி மொழிபெயர்க்கப்பட்டுள்ளது. நாங்கள் துல்லியத்திற்காக முயற்சிக்கின்றோம், ஆனால் தானியங்கி மொழிபெயர்ப்புகளில் பிழைகள் அல்லது தவறான தகவல்கள் இருக்கக்கூடும் என்பதை தயவுசெய்து கவனத்தில் கொள்ளுங்கள். அதன் தாய்மொழியில் உள்ள மூல ஆவணம் அதிகாரப்பூர்வ ஆதாரமாக கருதப்பட வேண்டும். முக்கியமான தகவல்களுக்கு, தொழில்முறை மனித மொழிபெயர்ப்பு பரிந்துரைக்கப்படுகிறது. இந்த மொழிபெயர்ப்பைப் பயன்படுத்துவதால் ஏற்படும் எந்த தவறான புரிதல்கள் அல்லது தவறான விளக்கங்களுக்கு நாங்கள் பொறுப்பல்ல.