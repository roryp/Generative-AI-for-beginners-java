<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0cbf68d605615a1e602c832a24616859",
  "translation_date": "2025-12-01T09:25:23+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "te"
}
-->
# పెట్ స్టోరీ జనరేటర్ ట్యుటోరియల్ ప్రారంభికుల కోసం

## విషయ సూచిక

- [ముందస్తు అవసరాలు](../../../../04-PracticalSamples/petstory)
- [ప్రాజెక్ట్ నిర్మాణం అర్థం చేసుకోవడం](../../../../04-PracticalSamples/petstory)
- [ముఖ్యమైన భాగాలు వివరించబడినవి](../../../../04-PracticalSamples/petstory)
  - [1. ప్రధాన అప్లికేషన్](../../../../04-PracticalSamples/petstory)
  - [2. వెబ్ కంట్రోలర్](../../../../04-PracticalSamples/petstory)
  - [3. స్టోరీ సర్వీస్](../../../../04-PracticalSamples/petstory)
  - [4. వెబ్ టెంప్లేట్స్](../../../../04-PracticalSamples/petstory)
  - [5. కాన్ఫిగరేషన్](../../../../04-PracticalSamples/petstory)
- [అప్లికేషన్ నడపడం](../../../../04-PracticalSamples/petstory)
- [అన్ని కలిసి ఎలా పనిచేస్తాయి](../../../../04-PracticalSamples/petstory)
- [AI ఇంటిగ్రేషన్ అర్థం చేసుకోవడం](../../../../04-PracticalSamples/petstory)
- [తదుపరి దశలు](../../../../04-PracticalSamples/petstory)

## ముందస్తు అవసరాలు

ప్రారంభించడానికి ముందు, మీ వద్ద ఉండాలి:
- Java 21 లేదా అంతకంటే ఎక్కువ వెర్షన్ ఇన్‌స్టాల్ చేయబడింది
- Maven డిపెండెన్సీ మేనేజ్‌మెంట్ కోసం
- `models:read` స్కోప్‌తో GitHub ఖాతా మరియు వ్యక్తిగత యాక్సెస్ టోకెన్ (PAT)
- Java, Spring Boot, మరియు వెబ్ డెవలప్‌మెంట్ యొక్క ప్రాథమిక అవగాహన

## ప్రాజెక్ట్ నిర్మాణం అర్థం చేసుకోవడం

పెట్ స్టోరీ ప్రాజెక్ట్‌లో కొన్ని ముఖ్యమైన ఫైళ్లు ఉన్నాయి:

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

## ముఖ్యమైన భాగాలు వివరించబడినవి

### 1. ప్రధాన అప్లికేషన్

**ఫైల్:** `PetStoryApplication.java`

ఇది మా Spring Boot అప్లికేషన్‌కు ఎంట్రీ పాయింట్:

```java
@SpringBootApplication
public class PetStoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetStoryApplication.class, args);
    }
}
```

**ఇది ఏమి చేస్తుంది:**
- `@SpringBootApplication` అనోటేషన్ ఆటో-కాన్ఫిగరేషన్ మరియు కాంపోనెంట్ స్కానింగ్‌ను ప్రారంభిస్తుంది
- 8080 పోర్ట్‌లో ఎంబెడెడ్ వెబ్ సర్వర్ (Tomcat) ప్రారంభిస్తుంది
- అవసరమైన అన్ని Spring బీన్స్ మరియు సర్వీసులను ఆటోమేటిక్‌గా సృష్టిస్తుంది

### 2. వెబ్ కంట్రోలర్

**ఫైల్:** `PetController.java`

ఇది అన్ని వెబ్ రిక్వెస్టులు మరియు యూజర్ ఇంటరాక్షన్లను నిర్వహిస్తుంది:

```java
@Controller
public class PetController {
    
    private final StoryService storyService;
    
    public PetController(StoryService storyService) {
        this.storyService = storyService;
    }
    
    @GetMapping("/")
    public String index() {
        return "index";  // ఇండెక్స్.html టెంప్లేట్‌ను తిరిగి ఇస్తుంది
    }
    
    @PostMapping("/generate-story")
    public String generateStory(@RequestParam("description") String description, 
                               Model model, 
                               RedirectAttributes redirectAttributes) {
        
        // ఇన్‌పుట్ ధృవీకరణ
        if (description.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Please provide a description.");
            return "redirect:/";
        }
        
        // భద్రత కోసం ఇన్‌పుట్‌ను శుభ్రపరచండి
        String sanitizedDescription = sanitizeInput(description);
        
        // లోపాల నిర్వహణతో కథను రూపొందించండి
        try {
            String story = storyService.generateStory(sanitizedDescription);
            model.addAttribute("caption", sanitizedDescription);
            model.addAttribute("story", story);
            return "result";  // రిజల్ట్.html టెంప్లేట్‌ను తిరిగి ఇస్తుంది
            
        } catch (Exception e) {
            // AI విఫలమైతే ఫాల్బ్యాక్ కథను ఉపయోగించండి
            String fallbackStory = generateFallbackStory(sanitizedDescription);
            model.addAttribute("story", fallbackStory);
            return "result";
        }
    }
    
    private String sanitizeInput(String input) {
        return input.replaceAll("[<>\"'&]", "")  // Remove dangerous characters
                   .trim()
                   .substring(0, Math.min(input.length(), 500));  // పొడవును పరిమితం చేయండి
    }
}
```

**ముఖ్యమైన ఫీచర్లు:**

1. **రూట్ హ్యాండ్లింగ్**: `@GetMapping("/")` అప్‌లోడ్ ఫారమ్‌ను చూపిస్తుంది, `@PostMapping("/generate-story")` సమర్పణలను ప్రాసెస్ చేస్తుంది
2. **ఇన్‌పుట్ వెరిఫికేషన్**: ఖాళీ వివరణలు మరియు పొడవు పరిమితులను తనిఖీ చేస్తుంది
3. **సెక్యూరిటీ**: యూజర్ ఇన్‌పుట్‌ను శుభ్రం చేసి XSS దాడులను నివారిస్తుంది
4. **ఎర్రర్ హ్యాండ్లింగ్**: AI సర్వీస్ విఫలమైనప్పుడు ఫాల్‌బ్యాక్ స్టోరీలను అందిస్తుంది
5. **మోడల్ బైండింగ్**: Spring యొక్క `Model` ఉపయోగించి HTML టెంప్లేట్లకు డేటాను పంపుతుంది

**ఫాల్‌బ్యాక్ సిస్టమ్:**
కంట్రోలర్‌లో AI సర్వీస్ అందుబాటులో లేకపోతే ఉపయోగించే ముందుగా రాసిన స్టోరీ టెంప్లేట్లు ఉన్నాయి:

```java
private String generateFallbackStory(String description) {
    String[] storyTemplates = {
        "Meet the most wonderful pet in the world – a furry ball of energy...",
        "Once upon a time, there lived a remarkable pet whose heart was as big...",
        "In a cozy home filled with love, there lived an extraordinary pet..."
    };
    
    // స్థిరమైన ప్రతిస్పందనల కోసం వివరణ హాష్‌ను ఉపయోగించండి
    int index = Math.abs(description.hashCode() % storyTemplates.length);
    return storyTemplates[index];
}
```

### 3. స్టోరీ సర్వీస్

**ఫైల్:** `StoryService.java`

ఈ సర్వీస్ GitHub Modelsతో కమ్యూనికేట్ చేసి స్టోరీలను జనరేట్ చేస్తుంది:

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
        
        // GitHub మోడల్స్ కోసం OpenAI క్లయింట్‌ను కాన్ఫిగర్ చేయండి
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
        
        // AI అభ్యర్థనను కాన్ఫిగర్ చేయండి
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(modelName)
                .addSystemMessage(systemPrompt)
                .addUserMessage(userPrompt)
                .maxCompletionTokens(500)  // ప్రతిస్పందన పొడవును పరిమితం చేయండి
                .temperature(0.8)          // సృజనాత్మకతను నియంత్రించండి (0.0-1.0)
                .build();
        
        // అభ్యర్థనను పంపించి ప్రతిస్పందనను పొందండి
        ChatCompletion response = openAIClient.chat().completions().create(params);
        
        return response.choices().get(0).message().content().orElse("");
    }
}
```

**ముఖ్యమైన భాగాలు:**

1. **OpenAI క్లయింట్**: GitHub Models కోసం కాన్ఫిగర్ చేయబడిన అధికారిక OpenAI Java SDKని ఉపయోగిస్తుంది
2. **సిస్టమ్ ప్రాంప్ట్**: AIని కుటుంబానికి అనుకూలమైన పెట్ స్టోరీలను రాయడానికి ప్రేరేపిస్తుంది
3. **యూజర్ ప్రాంప్ట్**: వివరణ ఆధారంగా AIకి ఏ స్టోరీ రాయాలో చెప్పుతుంది
4. **పారామీటర్లు**: స్టోరీ పొడవు మరియు క్రియేటివిటీ స్థాయిని నియంత్రిస్తుంది
5. **ఎర్రర్ హ్యాండ్లింగ్**: కంట్రోలర్ క్యాచ్ చేసి హ్యాండిల్ చేసే ఎక్సెప్షన్లను త్రో చేస్తుంది

### 4. వెబ్ టెంప్లేట్స్

**ఫైల్:** `index.html` (అప్‌లోడ్ ఫారమ్)

యూజర్లు తమ పెట్స్‌ను వివరిస్తున్న ప్రధాన పేజీ:

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

**ఫైల్:** `result.html` (స్టోరీ ప్రదర్శన)

జనరేట్ చేసిన స్టోరీని చూపిస్తుంది:

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

**టెంప్లేట్ ఫీచర్లు:**

1. **Thymeleaf ఇంటిగ్రేషన్**: డైనమిక్ కంటెంట్ కోసం `th:` యాట్రిబ్యూట్లను ఉపయోగిస్తుంది
2. **రెస్పాన్సివ్ డిజైన్**: మొబైల్ మరియు డెస్క్‌టాప్ కోసం CSS స్టైలింగ్
3. **ఎర్రర్ హ్యాండ్లింగ్**: యూజర్లకు వెరిఫికేషన్ ఎర్రర్లను చూపిస్తుంది
4. **క్లయింట్-సైడ్ ప్రాసెసింగ్**: ఇమేజ్ విశ్లేషణ కోసం JavaScript (Transformers.js ఉపయోగించి)

### 5. కాన్ఫిగరేషన్

**ఫైల్:** `application.properties`

అప్లికేషన్ కోసం కాన్ఫిగరేషన్ సెట్టింగ్స్:

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

**కాన్ఫిగరేషన్ వివరాలు:**

1. **ఫైల్ అప్‌లోడ్**: 10MB వరకు ఇమేజ్‌లను అనుమతిస్తుంది
2. **లాగింగ్**: ఎగ్జిక్యూషన్ సమయంలో ఏ సమాచారం లాగ్ చేయబడుతుందో నియంత్రిస్తుంది
3. **GitHub Models**: ఏ AI మోడల్ మరియు ఎండ్‌పాయింట్ ఉపయోగించాలో స్పెసిఫై చేస్తుంది
4. **సెక్యూరిటీ**: సెన్సిటివ్ సమాచారం బయటపడకుండా ఎర్రర్ హ్యాండ్లింగ్ కాన్ఫిగరేషన్

## అప్లికేషన్ నడపడం

### దశ 1: మీ GitHub టోకెన్ సెట్ చేయండి

ముందుగా, మీ GitHub టోకెన్‌ను ఎన్విరాన్‌మెంట్ వేరియబుల్‌గా సెట్ చేయాలి:

**Windows (కమాండ్ ప్రాంప్ట్):**
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

**ఇది ఎందుకు అవసరం:**
- GitHub Models AI మోడల్స్‌కి యాక్సెస్ పొందడానికి ఆథెంటికేషన్ అవసరం
- ఎన్విరాన్‌మెంట్ వేరియబుల్స్ ఉపయోగించడం ద్వారా సెన్సిటివ్ టోకెన్లు సోర్స్ కోడ్‌లో ఉండకుండా చేస్తుంది
- `models:read` స్కోప్ AI ఇన్‌ఫరెన్స్‌కి యాక్సెస్ అందిస్తుంది

### దశ 2: బిల్డ్ చేసి నడపండి

ప్రాజెక్ట్ డైరెక్టరీకి వెళ్లండి:
```bash
cd 04-PracticalSamples/petstory
```

అప్లికేషన్‌ను బిల్డ్ చేయండి:
```bash
mvn clean compile
```

సర్వర్‌ను ప్రారంభించండి:
```bash
mvn spring-boot:run
```

అప్లికేషన్ `http://localhost:8080`లో ప్రారంభమవుతుంది.

### దశ 3: అప్లికేషన్‌ను పరీక్షించండి

1. **ఓపెన్ చేయండి** `http://localhost:8080` మీ బ్రౌజర్‌లో
2. **వివరించండి** మీ పెట్‌ను టెక్స్ట్ ఏరియాలో (ఉదా: "ఫెచ్ చేయడం ఇష్టపడే చురుకైన గోల్డెన్ రిట్రీవర్")
3. **క్లిక్ చేయండి** "Generate Story" AI-జనరేట్ చేసిన స్టోరీ పొందడానికి
4. **మరొక విధంగా**, పెట్ ఇమేజ్‌ను అప్‌లోడ్ చేసి వివరణను ఆటోమేటిక్‌గా జనరేట్ చేయండి
5. **చూడండి** మీ పెట్ వివరణ ఆధారంగా క్రియేటివ్ స్టోరీ

## అన్ని కలిసి ఎలా పనిచేస్తాయి

మీరు పెట్ స్టోరీని జనరేట్ చేసినప్పుడు పూర్తి ఫ్లో ఇది:

1. **యూజర్ ఇన్‌పుట్**: మీరు వెబ్ ఫారమ్‌లో మీ పెట్‌ను వివరిస్తారు
2. **ఫారమ్ సమర్పణ**: బ్రౌజర్ `/generate-story`కి POST రిక్వెస్ట్ పంపుతుంది
3. **కంట్రోలర్ ప్రాసెసింగ్**: `PetController` ఇన్‌పుట్‌ను వెరిఫై చేసి శుభ్రం చేస్తుంది
4. **AI సర్వీస్ కాల్**: `StoryService` GitHub Models APIకి రిక్వెస్ట్ పంపుతుంది
5. **స్టోరీ జనరేషన్**: AI వివరణ ఆధారంగా క్రియేటివ్ స్టోరీని జనరేట్ చేస్తుంది
6. **రెస్పాన్స్ హ్యాండ్లింగ్**: కంట్రోలర్ స్టోరీని స్వీకరించి మోడల్‌కు జోడిస్తుంది
7. **టెంప్లేట్ రెండరింగ్**: Thymeleaf `result.html`ను స్టోరీతో రెండర్ చేస్తుంది
8. **ప్రదర్శన**: యూజర్ బ్రౌజర్‌లో జనరేట్ చేసిన స్టోరీని చూస్తారు

**ఎర్రర్ హ్యాండ్లింగ్ ఫ్లో:**
AI సర్వీస్ విఫలమైతే:
1. కంట్రోలర్ ఎక్సెప్షన్‌ను క్యాచ్ చేస్తుంది
2. ముందుగా రాసిన టెంప్లేట్లను ఉపయోగించి ఫాల్‌బ్యాక్ స్టోరీని జనరేట్ చేస్తుంది
3. AI అందుబాటులో లేదని నోటుతో ఫాల్‌బ్యాక్ స్టోరీని చూపిస్తుంది
4. యూజర్‌కు మంచి అనుభవం అందించడానికి స్టోరీని అందిస్తుంది

## AI ఇంటిగ్రేషన్ అర్థం చేసుకోవడం

### GitHub Models API
అప్లికేషన్ GitHub Modelsను ఉపయోగిస్తుంది, ఇది వివిధ AI మోడల్స్‌కి ఉచిత యాక్సెస్ అందిస్తుంది:

```java
// GitHub టోకెన్‌తో ప్రామాణీకరణ
this.openAIClient = OpenAIOkHttpClient.builder()
    .baseUrl("https://models.github.ai/inference")
    .apiKey(githubToken)
    .build();
```

### ప్రాంప్ట్ ఇంజినీరింగ్
సర్వీస్ మంచి ఫలితాలను పొందడానికి జాగ్రత్తగా రూపొందించిన ప్రాంప్ట్‌లను ఉపయోగిస్తుంది:

```java
String systemPrompt = "You are a creative storyteller who writes fun, " +
                     "family-friendly short stories about pets. " +
                     "Keep stories under 500 words and appropriate for all ages.";
```

### రెస్పాన్స్ ప్రాసెసింగ్
AI రెస్పాన్స్‌ను ఎక్స్‌ట్రాక్ట్ చేసి వెరిఫై చేస్తుంది:

```java
ChatCompletion response = openAIClient.chat().completions().create(params);
String story = response.choices().get(0).message().content().orElse("");
```

## తదుపరి దశలు

మరిన్ని ఉదాహరణల కోసం, [Chapter 04: Practical samples](../README.md) చూడండి

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**అస్వీకరణ**:  
ఈ పత్రం AI అనువాద సేవ [Co-op Translator](https://github.com/Azure/co-op-translator) ఉపయోగించి అనువదించబడింది. మేము ఖచ్చితత్వానికి ప్రయత్నిస్తున్నప్పటికీ, ఆటోమేటెడ్ అనువాదాలు తప్పులు లేదా అసమగ్రతలను కలిగి ఉండవచ్చు. దయచేసి దాని స్వస్థ భాషలో ఉన్న అసలు పత్రాన్ని అధికారం కలిగిన మూలంగా పరిగణించండి. కీలకమైన సమాచారం కోసం, ప్రొఫెషనల్ మానవ అనువాదాన్ని సిఫారసు చేస్తాము. ఈ అనువాదం ఉపయోగం వల్ల కలిగే ఏవైనా అపార్థాలు లేదా తప్పుదారులు కోసం మేము బాధ్యత వహించము.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->