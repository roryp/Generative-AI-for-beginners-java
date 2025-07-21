<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0cbf68d605615a1e602c832a24616859",
  "translation_date": "2025-07-21T21:42:37+00:00",
  "source_file": "04-PracticalSamples/petstory/TUTORIAL.md",
  "language_code": "my"
}
-->
# သင်တန်းစတင်သူများအတွက် အိမ်မွေးတိရစ္ဆာန်ပုံပြင် ဖန်တီးရေးမှူးလမ်းညွှန်

## အကြောင်းအရာများ

- [လိုအပ်ချက်များ](../../../../04-PracticalSamples/petstory)
- [ပရောဂျက်ဖွဲ့စည်းမှုကို နားလည်ခြင်း](../../../../04-PracticalSamples/petstory)
- [အဓိကအစိတ်အပိုင်းများ ရှင်းပြချက်](../../../../04-PracticalSamples/petstory)
  - [၁။ အဓိကအက်ပလီကေးရှင်း](../../../../04-PracticalSamples/petstory)
  - [၂။ ဝက်ဘ်ကွန်ထရိုလာ](../../../../04-PracticalSamples/petstory)
  - [၃။ ပုံပြင်ဝန်ဆောင်မှု](../../../../04-PracticalSamples/petstory)
  - [၄။ ဝက်ဘ်အချုပ်ပုံစံများ](../../../../04-PracticalSamples/petstory)
  - [၅။ ဖွဲ့စည်းမှု](../../../../04-PracticalSamples/petstory)
- [အက်ပလီကေးရှင်းကို အလုပ်လုပ်စေခြင်း](../../../../04-PracticalSamples/petstory)
- [အားလုံးပေါင်းစည်းပြီး ဘယ်လိုအလုပ်လုပ်သလဲ](../../../../04-PracticalSamples/petstory)
- [AI ပေါင်းစည်းမှုကို နားလည်ခြင်း](../../../../04-PracticalSamples/petstory)
- [နောက်တစ်ဆင့်များ](../../../../04-PracticalSamples/petstory)

## လိုအပ်ချက်များ

စတင်မည်မီ သင်မှာ အောက်ပါအရာများရှိရမည်-
- Java 21 သို့မဟုတ် အထက်ရှိထားရမည်
- Maven ကို အခြေခံလိုအပ်ချက်များ စီမံရန်
- `models:read` scope ပါဝင်သော GitHub အကောင့်နှင့် Personal Access Token (PAT)
- Java, Spring Boot နှင့် ဝက်ဘ်ဖွံ့ဖြိုးရေးအခြေခံကို နားလည်ထားရမည်

## ပရောဂျက်ဖွဲ့စည်းမှုကို နားလည်ခြင်း

အိမ်မွေးတိရစ္ဆာန်ပုံပြင်ပရောဂျက်တွင် အရေးကြီးသောဖိုင်များအများအပြားပါဝင်သည်-

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

## အဓိကအစိတ်အပိုင်းများ ရှင်းပြချက်

### ၁။ အဓိကအက်ပလီကေးရှင်း

**ဖိုင်:** `PetStoryApplication.java`

ဤသည်မှာ Spring Boot အက်ပလီကေးရှင်း၏ စတင်ဝင်ပေါက်ဖြစ်သည်-

```java
@SpringBootApplication
public class PetStoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetStoryApplication.class, args);
    }
}
```

**ဤအရာက ဘာလုပ်သလဲ:**
- `@SpringBootApplication` annotation သည် auto-configuration နှင့် component scanning ကို ဖွင့်ပေးသည်
- Port 8080 တွင် embedded web server (Tomcat) ကို စတင်သည်
- လိုအပ်သော Spring beans နှင့် services အားလုံးကို အလိုအလျောက် ဖန်တီးပေးသည်

### ၂။ ဝက်ဘ်ကွန်ထရိုလာ

**ဖိုင်:** `PetController.java`

ဤသည်သည် ဝက်ဘ်တောင်းဆိုမှုများနှင့် အသုံးပြုသူအပြန်အလှန်များကို ကိုင်တွယ်သည်-

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

**အဓိကအင်္ဂါရပ်များ:**

1. **Route Handling**: `@GetMapping("/")` သည် upload form ကို ပြသပြီး၊ `@PostMapping("/generate-story")` သည် တင်သွင်းမှုများကို ကိုင်တွယ်သည်
2. **Input Validation**: ဖော်ပြချက်များအတွက် အလျော့အတင်းနှင့် အရှည်ကန့်သတ်များကို စစ်ဆေးသည်
3. **Security**: အသုံးပြုသူ၏ input ကို sanitize လုပ်ပြီး XSS တိုက်ခိုက်မှုများကို ကာကွယ်သည်
4. **Error Handling**: AI ဝန်ဆောင်မှု မအောင်မြင်ပါက fallback ပုံပြင်များကို ပေးသည်
5. **Model Binding**: Spring ၏ `Model` ကို အသုံးပြု၍ HTML templates သို့ ဒေတာများ ပေးပို့သည်

**Fallback System:**
AI ဝန်ဆောင်မှု မရရှိနိုင်ပါက controller တွင် ရေးသားပြီးသား ပုံပြင်ပုံစံများကို အသုံးပြုသည်-

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

### ၃။ ပုံပြင်ဝန်ဆောင်မှု

**ဖိုင်:** `StoryService.java`

ဤဝန်ဆောင်မှုသည် GitHub Models နှင့် ဆက်သွယ်ပြီး ပုံပြင်များ ဖန်တီးသည်-

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

**အဓိကအစိတ်အပိုင်းများ:**

1. **OpenAI Client**: GitHub Models အတွက် အတည်ပြုထားသော OpenAI Java SDK ကို အသုံးပြုသည်
2. **System Prompt**: AI ၏ အပြုအမူကို မိသားစုနှင့်သင့်တော်သော အိမ်မွေးတိရစ္ဆာန်ပုံပြင်များ ရေးရန် သတ်မှတ်သည်
3. **User Prompt**: ဖော်ပြချက်အပေါ်မူတည်၍ AI ကို ရေးရန် အတိအကျ ပြောသည်
4. **Parameters**: ပုံပြင်အရှည်နှင့် ဖန်တီးမှုအဆင့်ကို ထိန်းချုပ်သည်
5. **Error Handling**: Controller မှ ဖမ်းဆီးပြီး ကိုင်တွယ်နိုင်သော အထူးကိစ္စများကို ပစ်ပေါက်သည်

### ၄။ ဝက်ဘ်အချုပ်ပုံစံများ

**ဖိုင်:** `index.html` (Upload Form)

အသုံးပြုသူများ အိမ်မွေးတိရစ္ဆာန်ကို ဖော်ပြရန် အဓိကစာမျက်နှာ-

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

**ဖိုင်:** `result.html` (Story Display)

ဖန်တီးထားသော ပုံပြင်ကို ပြသသည်-

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

**Template အင်္ဂါရပ်များ:**

1. **Thymeleaf Integration**: `th:` attributes ကို အသုံးပြု၍ ဒိုင်နမစ်အကြောင်းအရာများ ထည့်သွင်းသည်
2. **Responsive Design**: CSS ဖြင့် မိုဘိုင်းနှင့် ဒက်စ်တော့ပ်အတွက် အဆင်ပြေစေရန်
3. **Error Handling**: အသုံးပြုသူများအား အတည်ပြုမှုအမှားများ ပြသသည်
4. **Client-side Processing**: Transformers.js ကို အသုံးပြု၍ ပုံရိပ်ခွဲခြမ်းစိတ်ဖြာမှု

### ၅။ ဖွဲ့စည်းမှု

**ဖိုင်:** `application.properties`

အက်ပလီကေးရှင်းအတွက် ဖွဲ့စည်းမှုဆိုင်ရာ အပြင်အဆင်များ-

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

**ဖွဲ့စည်းမှု ရှင်းပြချက်:**

1. **File Upload**: 10MB အထိ ပုံရိပ်များကို ခွင့်ပြုသည်
2. **Logging**: အလုပ်လုပ်စဉ်အတွင်း မှတ်တမ်းများကို ထိန်းချုပ်သည်
3. **GitHub Models**: အသုံးပြုမည့် AI မော်ဒယ်နှင့် endpoint ကို သတ်မှတ်သည်
4. **Security**: အရေးကြီးသော အချက်အလက်များ မဖော်ပြစေရန် အမှားကိုင်တွယ်မှုကို ဖွဲ့စည်းသည်

## အက်ပလီကေးရှင်းကို အလုပ်လုပ်စေခြင်း

### အဆင့် ၁: GitHub Token ကို သတ်မှတ်ပါ

ပထမဦးစွာ GitHub token ကို ပတ်ဝန်းကျင်အပြောင်းအလဲအဖြစ် သတ်မှတ်ရမည်-

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

**ဤအရာလိုအပ်ရသည့်အကြောင်း:**
- GitHub Models သည် AI မော်ဒယ်များကို အသုံးပြုရန် authentication လိုအပ်သည်
- ပတ်ဝန်းကျင်အပြောင်းအလဲများကို အသုံးပြုခြင်းဖြင့် အရေးကြီးသော token များကို source code တွင် မထည့်ရ
- `models:read` scope သည် AI inference ကို အသုံးပြုခွင့်ပေးသည်

### အဆင့် ၂: Build နှင့် Run

ပရောဂျက် directory သို့ သွားပါ:
```bash
cd 04-PracticalSamples/petstory
```

အက်ပလီကေးရှင်းကို Build လုပ်ပါ:
```bash
mvn clean compile
```

Server ကို စတင်ပါ:
```bash
mvn spring-boot:run
```

အက်ပလီကေးရှင်းသည် `http://localhost:8080` တွင် စတင်မည်။

### အဆင့် ၃: အက်ပလီကေးရှင်းကို စမ်းသပ်ပါ

1. **ဖွင့်ပါ** `http://localhost:8080` ကို သင့် browser တွင်
2. **ဖော်ပြပါ** သင့်အိမ်မွေးတိရစ္ဆာန်ကို (ဥပမာ- "ပစ်ယူရတာကို ကြိုက်တဲ့ ရွှေရောင် retriever")
3. **နှိပ်ပါ** "Generate Story" AI-generated ပုံပြင်ရရန်
4. **အခြားနည်းလမ်းအနေနဲ့**, အိမ်မွေးတိရစ္ဆာန်ပုံရိပ်တစ်ပုံကို upload လုပ်ပါ
5. **ကြည့်ပါ** သင့်အိမ်မွေးတိရစ္ဆာန်ဖော်ပြချက်အပေါ်မူတည်သော ဖန်တီးမှုပုံပြင်

## အားလုံးပေါင်းစည်းပြီး ဘယ်လိုအလုပ်လုပ်သလဲ

အိမ်မွေးတိရစ္ဆာန်ပုံပြင်ကို ဖန်တီးစဉ် လုပ်ငန်းစဉ်မှာ-

1. **အသုံးပြုသူ input**: သင့်အိမ်မွေးတိရစ္ဆာန်ကို ဝက်ဘ်ဖောင်တွင် ဖော်ပြသည်
2. **Form Submission**: Browser မှ POST request ကို `/generate-story` သို့ ပေးပို့သည်
3. **Controller Processing**: `PetController` သည် input ကို အတည်ပြုပြီး sanitize လုပ်သည်
4. **AI Service Call**: `StoryService` သည် GitHub Models API သို့ တောင်းဆိုမှု ပေးပို့သည်
5. **Story Generation**: AI သည် ဖော်ပြချက်အပေါ်မူတည်၍ ဖန်တီးမှုပုံပြင်ကို ဖန်တီးသည်
6. **Response Handling**: Controller သည် ပုံပြင်ကို လက်ခံပြီး model သို့ ထည့်သည်
7. **Template Rendering**: Thymeleaf သည် `result.html` ကို render လုပ်သည်
8. **Display**: အသုံးပြုသူသည် ဖန်တီးထားသော ပုံပြင်ကို browser တွင် ကြည့်ရှုသည်

**Error Handling Flow:**
AI ဝန်ဆောင်မှု မအောင်မြင်ပါက-
1. Controller သည် အထူးကိစ္စကို ဖမ်းဆီးသည်
2. ရေးသားပြီးသား fallback ပုံပြင်ကို ဖန်တီးသည်
3. AI မရရှိနိုင်ကြောင်း သတိပေးချက်နှင့်အတူ fallback ပုံပြင်ကို ပြသသည်
4. အသုံးပြုသူသည် ပုံပြင်တစ်ပုဒ်ကို ရရှိသဖြင့် အသုံးပြုသူအတွေ့အကြုံကောင်းမွန်စေသည်

## AI ပေါင်းစည်းမှုကို နားလည်ခြင်း

### GitHub Models API
အက်ပလီကေးရှင်းသည် GitHub Models ကို အသုံးပြုပြီး အမျိုးမျိုးသော AI မော်ဒယ်များကို အခမဲ့အသုံးပြုခွင့်ပေးသည်-

```java
// Authentication with GitHub token
this.openAIClient = OpenAIOkHttpClient.builder()
    .baseUrl("https://models.github.ai/inference")
    .apiKey(githubToken)
    .build();
```

### Prompt Engineering
ဝန်ဆောင်မှုသည် ရလဒ်ကောင်းများရရန် သေချာစွာ ပြင်ဆင်ထားသော prompts များကို အသုံးပြုသည်-

```java
String systemPrompt = "You are a creative storyteller who writes fun, " +
                     "family-friendly short stories about pets. " +
                     "Keep stories under 500 words and appropriate for all ages.";
```

### Response Processing
AI response ကို ထုတ်ယူပြီး အတည်ပြုသည်-

```java
ChatCompletion response = openAIClient.chat().completions().create(params);
String story = response.choices().get(0).message().content().orElse("");
```

## နောက်တစ်ဆင့်များ

နောက်ထပ်ဥပမာများအတွက် [Chapter 04: Practical samples](../README.md) ကို ကြည့်ပါ

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်ခြင်းတွင် အမှားများ သို့မဟုတ် မတိကျမှုများ ပါဝင်နိုင်သည်ကို သတိပြုပါ။ မူရင်းစာရွက်စာတမ်းကို ၎င်း၏ မူလဘာသာစကားဖြင့် အာဏာတရားရှိသော အရင်းအမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များမှ ပရော်ဖက်ရှင်နယ် ဘာသာပြန်ခြင်းကို အကြံပြုပါသည်။ ဤဘာသာပြန်ကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအမှားများ သို့မဟုတ် အနားလွဲမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။