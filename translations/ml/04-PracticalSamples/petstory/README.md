<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0cbf68d605615a1e602c832a24616859",
  "translation_date": "2025-12-01T09:26:40+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "ml"
}
-->
# പെട്ട് സ്റ്റോറി ജനറേറ്റർ ട്യൂട്ടോറിയൽ ആരംഭക്കാർക്കായി

## ഉള്ളടക്കം

- [ആവശ്യകതകൾ](../../../../04-PracticalSamples/petstory)
- [പ്രോജക്റ്റ് ഘടന മനസ്സിലാക്കുക](../../../../04-PracticalSamples/petstory)
- [പ്രധാന ഘടകങ്ങൾ വിശദീകരിക്കുന്നു](../../../../04-PracticalSamples/petstory)
  - [1. പ്രധാന ആപ്ലിക്കേഷൻ](../../../../04-PracticalSamples/petstory)
  - [2. വെബ് കൺട്രോളർ](../../../../04-PracticalSamples/petstory)
  - [3. സ്റ്റോറി സർവീസ്](../../../../04-PracticalSamples/petstory)
  - [4. വെബ് ടെംപ്ലേറ്റുകൾ](../../../../04-PracticalSamples/petstory)
  - [5. കോൺഫിഗറേഷൻ](../../../../04-PracticalSamples/petstory)
- [ആപ്ലിക്കേഷൻ പ്രവർത്തിപ്പിക്കൽ](../../../../04-PracticalSamples/petstory)
- [എല്ലാം ഒരുമിച്ച് എങ്ങനെ പ്രവർത്തിക്കുന്നു](../../../../04-PracticalSamples/petstory)
- [AI ഇന്റഗ്രേഷൻ മനസ്സിലാക്കുക](../../../../04-PracticalSamples/petstory)
- [അടുത്ത ഘട്ടങ്ങൾ](../../../../04-PracticalSamples/petstory)

## ആവശ്യകതകൾ

തുടങ്ങുന്നതിന് മുമ്പ്, നിങ്ങൾക്ക് താഴെ പറയുന്നവ ഉണ്ടെന്ന് ഉറപ്പാക്കുക:
- Java 21 അല്ലെങ്കിൽ അതിനുമുകളിൽ ഇൻസ്റ്റാൾ ചെയ്തിരിക്കണം
- Maven ഡിപെൻഡൻസി മാനേജ്മെന്റിനായി
- `models:read` സ്കോപ്പുള്ള GitHub അക്കൗണ്ട്, പേഴ്സണൽ ആക്സസ് ടോക്കൺ (PAT) ഉപയോഗിച്ച്
- Java, Spring Boot, വെബ് ഡെവലപ്മെന്റ് എന്നിവയുടെ അടിസ്ഥാന ധാരണ

## പ്രോജക്റ്റ് ഘടന മനസ്സിലാക്കുക

പെട്ട് സ്റ്റോറി പ്രോജക്റ്റിൽ ചില പ്രധാന ഫയലുകൾ ഉണ്ട്:

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

## പ്രധാന ഘടകങ്ങൾ വിശദീകരിക്കുന്നു

### 1. പ്രധാന ആപ്ലിക്കേഷൻ

**ഫയൽ:** `PetStoryApplication.java`

ഇത് നമ്മുടെ Spring Boot ആപ്ലിക്കേഷന്റെ എൻട്രി പോയിന്റാണ്:

```java
@SpringBootApplication
public class PetStoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetStoryApplication.class, args);
    }
}
```

**ഇത് എന്താണ് ചെയ്യുന്നത്:**
- `@SpringBootApplication` അനോട്ടേഷൻ ഓട്ടോ-കോൺഫിഗറേഷനും കംപോണന്റ് സ്കാനിംഗും സജ്ജമാക്കുന്നു
- 8080 പോർട്ടിൽ ഒരു എംബെഡഡ് വെബ് സർവർ (Tomcat) ആരംഭിക്കുന്നു
- ആവശ്യമായ എല്ലാ Spring ബീൻസും സർവീസുകളും സ്വയം സൃഷ്ടിക്കുന്നു

### 2. വെബ് കൺട്രോളർ

**ഫയൽ:** `PetController.java`

ഇത് എല്ലാ വെബ് അഭ്യർത്ഥനകളും ഉപയോക്തൃ ഇടപെടലുകളും കൈകാര്യം ചെയ്യുന്നു:

```java
@Controller
public class PetController {
    
    private final StoryService storyService;
    
    public PetController(StoryService storyService) {
        this.storyService = storyService;
    }
    
    @GetMapping("/")
    public String index() {
        return "index";  // ഇൻഡക്സ്.html ടെംപ്ലേറ്റ് തിരികെ നൽകുന്നു
    }
    
    @PostMapping("/generate-story")
    public String generateStory(@RequestParam("description") String description, 
                               Model model, 
                               RedirectAttributes redirectAttributes) {
        
        // ഇൻപുട്ട് പരിശോധന
        if (description.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Please provide a description.");
            return "redirect:/";
        }
        
        // സുരക്ഷയ്ക്കായി ഇൻപുട്ട് ശുചീകരിക്കുക
        String sanitizedDescription = sanitizeInput(description);
        
        // പിഴവുകൾ കൈകാര്യം ചെയ്ത് കഥ സൃഷ്ടിക്കുക
        try {
            String story = storyService.generateStory(sanitizedDescription);
            model.addAttribute("caption", sanitizedDescription);
            model.addAttribute("story", story);
            return "result";  // റിസൾട്ട്.html ടെംപ്ലേറ്റ് തിരികെ നൽകുന്നു
            
        } catch (Exception e) {
            // AI പരാജയപ്പെടുകയാണെങ്കിൽ ഫാൾബാക്ക് കഥ ഉപയോഗിക്കുക
            String fallbackStory = generateFallbackStory(sanitizedDescription);
            model.addAttribute("story", fallbackStory);
            return "result";
        }
    }
    
    private String sanitizeInput(String input) {
        return input.replaceAll("[<>\"'&]", "")  // Remove dangerous characters
                   .trim()
                   .substring(0, Math.min(input.length(), 500));  // നീളം പരിമിതപ്പെടുത്തുക
    }
}
```

**പ്രധാന സവിശേഷതകൾ:**

1. **റൂട്ട് ഹാൻഡ്ലിംഗ്**: `@GetMapping("/")` അപ്ലോഡ് ഫോമും, `@PostMapping("/generate-story")` സമർപ്പണങ്ങളും പ്രോസസ്സ് ചെയ്യുന്നു
2. **ഇൻപുട്ട് വാലിഡേഷൻ**: ശൂന്യമായ വിവരണങ്ങൾക്കും നീള പരിധികൾക്കും പരിശോധന നടത്തുന്നു
3. **സുരക്ഷ**: ഉപയോക്തൃ ഇൻപുട്ട് സാനിറ്റൈസ് ചെയ്ത് XSS ആക്രമണങ്ങൾ തടയുന്നു
4. **എറർ ഹാൻഡ്ലിംഗ്**: AI സർവീസ് പരാജയപ്പെടുമ്പോൾ ഫallback സ്റ്റോറിയുകൾ നൽകുന്നു
5. **മോഡൽ ബൈൻഡിംഗ്**: Spring-ന്റെ `Model` ഉപയോഗിച്ച് HTML ടെംപ്ലേറ്റുകളിലേക്ക് ഡാറ്റ പാസ്സ് ചെയ്യുന്നു

**Fallback സിസ്റ്റം:**
AI സർവീസ് ലഭ്യമല്ലാത്തപ്പോൾ ഉപയോഗിക്കുന്ന മുൻകൂട്ടി എഴുതിയ സ്റ്റോറി ടെംപ്ലേറ്റുകൾ കൺട്രോളറിൽ ഉൾപ്പെടുത്തിയിട്ടുണ്ട്:

```java
private String generateFallbackStory(String description) {
    String[] storyTemplates = {
        "Meet the most wonderful pet in the world – a furry ball of energy...",
        "Once upon a time, there lived a remarkable pet whose heart was as big...",
        "In a cozy home filled with love, there lived an extraordinary pet..."
    };
    
    // സ്ഥിരതയുള്ള പ്രതികരണങ്ങൾക്കായി വിവരണ ഹാഷ് ഉപയോഗിക്കുക
    int index = Math.abs(description.hashCode() % storyTemplates.length);
    return storyTemplates[index];
}
```

### 3. സ്റ്റോറി സർവീസ്

**ഫയൽ:** `StoryService.java`

GitHub Models-നുമായി ഈ സർവീസ് സ്റ്റോറിയുകൾ സൃഷ്ടിക്കുന്നു:

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
        
        // GitHub മോഡലുകൾക്കായി കോൺഫിഗർ ചെയ്ത OpenAI ക്ലയന്റ് സൃഷ്ടിക്കുക
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
        
        // AI അഭ്യർത്ഥന കോൺഫിഗർ ചെയ്യുക
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(modelName)
                .addSystemMessage(systemPrompt)
                .addUserMessage(userPrompt)
                .maxCompletionTokens(500)  // പ്രതികരണ ദൈർഘ്യം പരിമിതപ്പെടുത്തുക
                .temperature(0.8)          // സൃഷ്ടിപരത്വം നിയന്ത്രിക്കുക (0.0-1.0)
                .build();
        
        // അഭ്യർത്ഥന അയച്ച് പ്രതികരണം നേടുക
        ChatCompletion response = openAIClient.chat().completions().create(params);
        
        return response.choices().get(0).message().content().orElse("");
    }
}
```

**പ്രധാന ഘടകങ്ങൾ:**

1. **OpenAI ക്ലയന്റ്**: GitHub Models-നായി കോൺഫിഗർ ചെയ്ത ഔദ്യോഗിക OpenAI Java SDK ഉപയോഗിക്കുന്നു
2. **സിസ്റ്റം പ്രോംപ്റ്റ്**: കുടുംബസൗഹൃദമായ പെട്ട് സ്റ്റോറിയുകൾ എഴുതാൻ AI-ന്റെ പെരുമാറ്റം സജ്ജമാക്കുന്നു
3. **ഉപയോക്തൃ പ്രോംപ്റ്റ്**: AI-യോട് വിവരണത്തിന്റെ അടിസ്ഥാനത്തിൽ സ്റ്റോറി എഴുതാൻ നിർദ്ദേശിക്കുന്നു
4. **പാരാമീറ്ററുകൾ**: സ്റ്റോറി നീളവും സൃഷ്ടിപരമായ തലവും നിയന്ത്രിക്കുന്നു
5. **എറർ ഹാൻഡ്ലിംഗ്**: കൺട്രോളർ പിടികൂടി കൈകാര്യം ചെയ്യുന്ന എക്സെപ്ഷനുകൾ എററുകൾ സൃഷ്ടിക്കുന്നു

### 4. വെബ് ടെംപ്ലേറ്റുകൾ

**ഫയൽ:** `index.html` (അപ്ലോഡ് ഫോം)

ഉപയോക്താക്കൾ അവരുടെ പെട്ടുകളെ വിവരിക്കുന്ന പ്രധാന പേജ്:

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

**ഫയൽ:** `result.html` (സ്റ്റോറി പ്രദർശനം)

സൃഷ്ടിച്ച സ്റ്റോറി കാണിക്കുന്നു:

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

**ടെംപ്ലേറ്റ് സവിശേഷതകൾ:**

1. **Thymeleaf ഇന്റഗ്രേഷൻ**: ഡൈനാമിക് ഉള്ളടക്കത്തിനായി `th:` ആട്രിബ്യൂട്ടുകൾ ഉപയോഗിക്കുന്നു
2. **റെസ്പോൺസീവ് ഡിസൈൻ**: മൊബൈലിനും ഡെസ്ക്ടോപ്പിനും അനുയോജ്യമായ CSS സ്റ്റൈലിംഗ്
3. **എറർ ഹാൻഡ്ലിംഗ്**: ഉപയോക്താക്കൾക്ക് വാലിഡേഷൻ പിഴവുകൾ പ്രദർശിപ്പിക്കുന്നു
4. **ക്ലയന്റ്-സൈഡ് പ്രോസസിംഗ്**: Transformers.js ഉപയോഗിച്ച് ഇമേജ് വിശകലനം ചെയ്യാൻ JavaScript

### 5. കോൺഫിഗറേഷൻ

**ഫയൽ:** `application.properties`

ആപ്ലിക്കേഷനുള്ള കോൺഫിഗറേഷൻ ക്രമീകരണങ്ങൾ:

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

**കോൺഫിഗറേഷൻ വിശദീകരണം:**

1. **ഫയൽ അപ്ലോഡ്**: 10MB വരെ ചിത്രങ്ങൾ അനുവദിക്കുന്നു
2. **ലോഗിംഗ്**: പ്രവർത്തനത്തിനിടെ എന്ത് വിവരങ്ങൾ ലോഗ് ചെയ്യണമെന്ന് നിയന്ത്രിക്കുന്നു
3. **GitHub Models**: ഏത് AI മോഡലും എന്റ്പോയിന്റും ഉപയോഗിക്കണമെന്ന് വ്യക്തമാക്കുന്നു
4. **സുരക്ഷ**: സംവേദനാത്മക വിവരങ്ങൾ വെളിപ്പെടുത്താതിരിക്കാൻ എറർ ഹാൻഡ്ലിംഗ് കോൺഫിഗറേഷൻ

## ആപ്ലിക്കേഷൻ പ്രവർത്തിപ്പിക്കൽ

### ഘട്ടം 1: നിങ്ങളുടെ GitHub ടോക്കൺ സജ്ജമാക്കുക

ആദ്യം, നിങ്ങളുടെ GitHub ടോക്കൺ ഒരു എൻവയോൺമെന്റ് വേരിയബിളായി സജ്ജമാക്കണം:

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

**ഇത് എന്തിനാണ് ആവശ്യം:**
- GitHub Models AI മോഡലുകൾ ആക്സസ് ചെയ്യാൻ ഓതന്റിക്കേഷൻ ആവശ്യമാണ്
- എൻവയോൺമെന്റ് വേരിയബിളുകൾ ഉപയോഗിക്കുന്നത് സോഴ്സ് കോഡിൽ സംവേദനാത്മക ടോക്കണുകൾ ഒഴിവാക്കുന്നു
- `models:read` സ്കോപ്പ് AI ഇൻഫറൻസ് ആക്സസ് നൽകുന്നു

### ഘട്ടം 2: ബിൽഡ് ചെയ്യുക, പ്രവർത്തിപ്പിക്കുക

പ്രോജക്റ്റ് ഡയറക്ടറിയിലേക്ക് പോകുക:
```bash
cd 04-PracticalSamples/petstory
```

ആപ്ലിക്കേഷൻ ബിൽഡ് ചെയ്യുക:
```bash
mvn clean compile
```

സർവർ ആരംഭിക്കുക:
```bash
mvn spring-boot:run
```

ആപ്ലിക്കേഷൻ `http://localhost:8080`-ൽ ആരംഭിക്കും.

### ഘട്ടം 3: ആപ്ലിക്കേഷൻ ടെസ്റ്റ് ചെയ്യുക

1. **തുറക്കുക** `http://localhost:8080` നിങ്ങളുടെ ബ്രൗസറിൽ
2. **വിവരിക്കുക** നിങ്ങളുടെ പെട്ടിനെ ടെക്സ്റ്റ് ഏരിയയിൽ (ഉദാ: "ഒരു കളിപ്പുള്ള ഗോൾഡൻ റിട്രീവർ, ഫെച്ചിൽ പ്രിയമുള്ളവൻ")
3. **ക്ലിക്ക് ചെയ്യുക** "Generate Story" AI-ൽ നിന്നുള്ള സ്റ്റോറി ലഭിക്കാൻ
4. **മറ്റൊരു മാർഗം**, ഒരു പെട്ട് ചിത്രം അപ്ലോഡ് ചെയ്ത് സ്വയം വിവരണം സൃഷ്ടിക്കുക
5. **കാണുക** നിങ്ങളുടെ പെട്ടിന്റെ വിവരണത്തിന്റെ അടിസ്ഥാനത്തിൽ സൃഷ്ടിച്ച സൃഷ്ടിപരമായ സ്റ്റോറി

## എല്ലാം ഒരുമിച്ച് എങ്ങനെ പ്രവർത്തിക്കുന്നു

നിങ്ങൾ ഒരു പെട്ട് സ്റ്റോറി സൃഷ്ടിക്കുമ്പോൾ ഇതാണ് പൂർണ്ണ പ്രവാഹം:

1. **ഉപയോക്തൃ ഇൻപുട്ട്**: നിങ്ങൾ വെബ് ഫോമിൽ നിങ്ങളുടെ പെട്ടിനെ വിവരിക്കുന്നു
2. **ഫോം സമർപ്പണം**: ബ്രൗസർ `/generate-story`-ലേക്ക് POST അഭ്യർത്ഥന അയയ്ക്കുന്നു
3. **കൺട്രോളർ പ്രോസസിംഗ്**: `PetController` ഇൻപുട്ട് വാലിഡേറ്റ് ചെയ്യുകയും സാനിറ്റൈസ് ചെയ്യുകയും ചെയ്യുന്നു
4. **AI സർവീസ് കോൾ**: `StoryService` GitHub Models API-യിലേക്ക് അഭ്യർത്ഥന അയയ്ക്കുന്നു
5. **സ്റ്റോറി സൃഷ്ടി**: AI വിവരണത്തിന്റെ അടിസ്ഥാനത്തിൽ സൃഷ്ടിപരമായ സ്റ്റോറി സൃഷ്ടിക്കുന്നു
6. **റിസ്പോൺസ് ഹാൻഡ്ലിംഗ്**: കൺട്രോളർ സ്റ്റോറി സ്വീകരിച്ച് മോഡലിലേക്ക് ചേർക്കുന്നു
7. **ടെംപ്ലേറ്റ് റെൻഡറിംഗ്**: Thymeleaf `result.html` സ്റ്റോറിയോടെ റെൻഡർ ചെയ്യുന്നു
8. **പ്രദർശനം**: ഉപയോക്താവ് ബ്രൗസറിൽ സൃഷ്ടിച്ച സ്റ്റോറി കാണുന്നു

**എറർ ഹാൻഡ്ലിംഗ് പ്രവാഹം:**
AI സർവീസ് പരാജയപ്പെടുകയാണെങ്കിൽ:
1. കൺട്രോളർ എക്സെപ്ഷൻ പിടികൂടുന്നു
2. മുൻകൂട്ടി എഴുതിയ ടെംപ്ലേറ്റുകൾ ഉപയോഗിച്ച് fallback സ്റ്റോറി സൃഷ്ടിക്കുന്നു
3. AI ലഭ്യമല്ലെന്ന് കുറിപ്പോടെ fallback സ്റ്റോറി പ്രദർശിപ്പിക്കുന്നു
4. ഉപയോക്താവിന് ഒരു സ്റ്റോറി ലഭിക്കുന്നു, നല്ല ഉപയോക്തൃ അനുഭവം ഉറപ്പാക്കുന്നു

## AI ഇന്റഗ്രേഷൻ മനസ്സിലാക്കുക

### GitHub Models API
ആപ്ലിക്കേഷൻ GitHub Models ഉപയോഗിക്കുന്നു, വിവിധ AI മോഡലുകൾക്ക് സൗജന്യ ആക്സസ് നൽകുന്നു:

```java
// GitHub ടോക്കൺ ഉപയോഗിച്ച് പ്രാമാണീകരണം
this.openAIClient = OpenAIOkHttpClient.builder()
    .baseUrl("https://models.github.ai/inference")
    .apiKey(githubToken)
    .build();
```

### പ്രോംപ്റ്റ് എഞ്ചിനീയറിംഗ്
സേവനം നല്ല ഫലങ്ങൾ ലഭിക്കാൻ സൂക്ഷ്മമായി തയ്യാറാക്കിയ പ്രോംപ്റ്റുകൾ ഉപയോഗിക്കുന്നു:

```java
String systemPrompt = "You are a creative storyteller who writes fun, " +
                     "family-friendly short stories about pets. " +
                     "Keep stories under 500 words and appropriate for all ages.";
```

### റിസ്പോൺസ് പ്രോസസിംഗ്
AI റിസ്പോൺസ് എക്സ്ട്രാക്റ്റ് ചെയ്ത് വാലിഡേറ്റ് ചെയ്യുന്നു:

```java
ChatCompletion response = openAIClient.chat().completions().create(params);
String story = response.choices().get(0).message().content().orElse("");
```

## അടുത്ത ഘട്ടങ്ങൾ

കൂടുതൽ ഉദാഹരണങ്ങൾക്കായി, [Chapter 04: Practical samples](../README.md) കാണുക

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**അറിയിപ്പ്**:  
ഈ രേഖ AI വിവർത്തന സേവനം [Co-op Translator](https://github.com/Azure/co-op-translator) ഉപയോഗിച്ച് വിവർത്തനം ചെയ്തതാണ്. ഞങ്ങൾ കൃത്യതയ്ക്കായി ശ്രമിക്കുന്നുവെങ്കിലും, സ്വയം പ്രവർത്തിക്കുന്ന വിവർത്തനങ്ങളിൽ പിഴവുകൾ അല്ലെങ്കിൽ തെറ്റായ വിവരങ്ങൾ ഉണ്ടാകാൻ സാധ്യതയുണ്ട്. അതിന്റെ സ്വാഭാവിക ഭാഷയിലുള്ള മൗലിക രേഖയാണ് പ്രാമാണികമായ ഉറവിടമായി പരിഗണിക്കേണ്ടത്. നിർണായകമായ വിവരങ്ങൾക്ക്, പ്രൊഫഷണൽ മനുഷ്യ വിവർത്തനം ശുപാർശ ചെയ്യുന്നു. ഈ വിവർത്തനം ഉപയോഗിച്ച് ഉണ്ടാകുന്ന തെറ്റിദ്ധാരണകൾ അല്ലെങ്കിൽ തെറ്റായ വ്യാഖ്യാനങ്ങൾക്കായി ഞങ്ങൾ ഉത്തരവാദികളല്ല.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->