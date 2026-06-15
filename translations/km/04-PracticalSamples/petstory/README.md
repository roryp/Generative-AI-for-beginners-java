# មេរៀនបង្កើតរឿងសត្វសម្រាប់អ្នកចាប់ផ្តើម

## តារាងមាតិកា

- [បទពិពណ៌នាមុន](#បទពិពណ៌នាមុន)
- [ការយល់ដឹងអំពីរចនាសម្ព័ន្ធគម្រោង](#ការយល់ដឹងអំពីរចនាសម្ព័ន្ធគម្រោង)
- [ការពន្យល់អំពីផ្នែកសំខាន់ៗ](#ការពន្យល់អំពីផ្នែកសំខាន់ៗ)
  - [1. អ្នកប្រើកម្មវិធីសំខាន់](#1-អ្នកប្រើកម្មវិធីសំខាន់)
  - [2. រក្សាការគ្រប់គ្រងវែប](#2-រក្សាការគ្រប់គ្រងវែប)
  - [3. សេវាកម្មរឿង](#3-សេវាកម្មរឿង)
  - [4. គំរូវែប](#4-គំរូវែប)
  - [5. ការកំណត់រចនាសម្ព័ន្ធ](#5-ការកំណត់រចនាសម្ព័ន្ធ)
- [ការរត់កម្មវិធី](#ការរត់កម្មវិធី)
- [របៀបដំណើរការទាំងអស់](#របៀបដំណើរការទាំងអស់)
- [ការយល់ដឹងអំពីការភ្ជាប់ AI](#ការយល់ដឹងអំពីការភ្ជាប់-ai)
- [ជំហានបន្ទាប់](#ជំហានបន្ទាប់)

## បទពិពណ៌នាមុន

មុនចាប់ផ្តើម សូមប្រាកដថាអ្នកមាន៖
- Java 21 ឬ ឡើងលើបានដំឡើង
- Maven សម្រាប់គ្រប់គ្រងអាស្រ័យភាព
- គណនី GitHub មានសិទ្ធិចូលប្រើផ្ទាល់ខ្លួន (PAT) ជាមួយ `models:read` scope
- ការយល់ដឹងមូលដ្ឋានអំពី Java, Spring Boot និងការអភិវឌ្ឍន៍វែប

## ការយល់ដឹងអំពីរចនាសម្ព័ន្ធគម្រោង

គម្រោងរឿងសត្វមានឯកសារសំខាន់ៗជាច្រើន៖

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

## ការពន្យល់អំពីផ្នែកសំខាន់ៗ

### 1. អ្នកប្រើកម្មវិធីសំខាន់

**ឯកសារ៖** `PetStoryApplication.java`

នេះជាចំណុចចូលសម្រាប់កម្មវិធី Spring Boot របស់យើង៖

```java
@SpringBootApplication
public class PetStoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetStoryApplication.class, args);
    }
}
```

**អ្វីដែលវាធ្វើ៖**
- ស្លាក `@SpringBootApplication` អនុញ្ញាតឲ្យធ្វើការកំណត់ស្វ័យប្រវត្តិ និងស្កេនផ្នែកផ្សំ
- ចាប់ផ្តើមម៉ាស៊ីនមេវែបចម្លង Tomcat នៅផត 8080
- បង្កើត Beans និងសេវាកម្ម Spring ទាំងអស់ដោយស្វ័យប្រវត្តិ

### 2. រក្សាការគ្រប់គ្រងវែប

**ឯកសារ៖** `PetController.java`

នេះគ្រប់គ្រងការស្នើសុំវែប និងអន្តរកម្មអ្នកប្រើ៖

```java
@Controller
public class PetController {
    
    private final StoryService storyService;
    
    public PetController(StoryService storyService) {
        this.storyService = storyService;
    }
    
    @GetMapping("/")
    public String index() {
        return "index";  // បញ្ចូនទម្រង់index.html
    }
    
    @PostMapping("/generate-story")
    public String generateStory(@RequestParam("description") String description, 
                               Model model, 
                               RedirectAttributes redirectAttributes) {
        
        // ផ្ទៀងផ្ទាត់ការបញ្ចូលទិន្នន័យ
        if (description.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Please provide a description.");
            return "redirect:/";
        }
        
        // សម្អាតការបញ្ចូលសម្រាប់សុវត្ថិភាព
        String sanitizedDescription = sanitizeInput(description);
        
        // បង្កើតរឿងជាមួយការដោះស្រាយបញ្ហា
        try {
            String story = storyService.generateStory(sanitizedDescription);
            model.addAttribute("caption", sanitizedDescription);
            model.addAttribute("story", story);
            return "result";  // បញ្ចូនទម្រង់result.html
            
        } catch (Exception e) {
            // ប្រើរឿងជំនួយបើ AI បរាជ័យ
            String fallbackStory = generateFallbackStory(sanitizedDescription);
            model.addAttribute("story", fallbackStory);
            return "result";
        }
    }
    
    private String sanitizeInput(String input) {
        return input.replaceAll("[<>\"'&]", "")  // Remove dangerous characters
                   .trim()
                   .substring(0, Math.min(input.length(), 500));  // កំណត់ប្រវែង
    }
}
```

**លក្ខណៈពិសេសសំខាន់៖**

1. **ការគ្រប់គ្រងផ្លូវការ**: `@GetMapping("/")` បង្ហាញទំរង់បញ្ចូល, `@PostMapping("/generate-story")` ដំណើរការការដាក់ស្នើ
2. **ការត្រួតពិនិត្យបញ្ចូល**: ตรวจสอบការពិពណ៌នាវាលទទេ និងកំណត់ដោយប្រវែង
3. **សុវត្ថិភាព**: សំអាតបញ្ចូលអ្នកប្រើដើម្បីការពារការវាយប្រហារដោយ XSS
4. **ការដោះស្រាយកំហុស**: ផ្តល់រឿងជំនួសពេលសេវាកម្ម AI បរាជ័យ
5. **Model Binding**: ផ្តល់ទិន្នន័យទៅពុម្ព HTML ដោយប្រើ Spring's `Model`

**ប្រព័ន្ធជំនួស:**
Controller រួមបញ្ចូលរឿងដែលបានសរសេររៀងខ្លួនដែលប្រើបានពេលសេវាកម្ម AI មិនមានដំណើរការ៖

```java
private String generateFallbackStory(String description) {
    String[] storyTemplates = {
        "Meet the most wonderful pet in the world – a furry ball of energy...",
        "Once upon a time, there lived a remarkable pet whose heart was as big...",
        "In a cozy home filled with love, there lived an extraordinary pet..."
    };
    
    // ប្រើហាសវចនាធិប្បាយសម្រាប់ការឆ្លើយតបទៀងទាត់
    int index = Math.abs(description.hashCode() % storyTemplates.length);
    return storyTemplates[index];
}
```

### 3. សេវាកម្មរឿង

**ឯកសារ៖** `StoryService.java`

សេវាកម្មនេះធ្វើការទំនាក់ទំនងជាមួយ GitHub Models ដើម្បីបង្កើតរឿង៖

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
        
        // បង្កើតអតិថិជន OpenAI ដែលបានកំណត់រចនាសម្ព័ន្ធសម្រាប់ម៉ូឌែល GitHub
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
        
        // កំណត់គម្រោងសំណើ AI
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(modelName)
                .addSystemMessage(systemPrompt)
                .addUserMessage(userPrompt)
                .maxCompletionTokens(500)  // កំណត់កម្ពស់ចម្លើយ
                .temperature(0.8)          // គ្រប់គ្រងការច្នៃប្រឌិត (0.0-1.0)
                .build();
        
        // ផ្ញើសំណើ និងទទួលបានចម្លើយ
        ChatCompletion response = openAIClient.chat().completions().create(params);
        
        return response.choices().get(0).message().content().orElse("");
    }
}
```

**ផ្នែកសំខាន់ៗ៖**

1. **OpenAI Client**: ប្រើ OpenAI Java SDK ផ្លូវការដែលបានកំណត់សម្រាប់ GitHub Models
2. **System Prompt**: កំណត់អាកប្បកិរិយារបស់ AI ក្នុងការសរសេររឿងសត្វសម្រាប់កុមារ
3. **User Prompt**: ប្រាប់ AI ថាតើត្រូវសរសេររឿងអ្វីផ្អែកលើការពិពណ៌នា
4. **Parameters**: គ្រប់គ្រងប្រវែងរឿង និងកម្រិតការច្នៃប្រឌិត
5. **ការដោះស្រាយកំហុស**: បោះបង់ករណីកំហុសដែល Controller ទទួលនិងដោះស្រាយ

### 4. គំរូវែប

**ឯកសារ៖** `index.html` (ទំរង់បញ្ចូល)

ទំព័រដើមដែលអ្នកប្រើពិពណ៌នាពីសត្វរបស់ពួកគេ៖

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

**ឯកសារ៖** `result.html` (បង្ហាញរឿង)

បង្ហាញរឿងដែលបានបង្កើត៖

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

**លក្ខណៈពិសេសគំរូ៖**

1. **ការរួមបញ្ចូល Thymeleaf**: ប្រើអាគុយម៉ង់ `th:` សម្រាប់មាតិកាដែរផ្លាស់ប្តូរបាន
2. **រចនាបទតបត់រាង**: ការតុបតែង CSS សម្រាប់ទូរស័ព្ទ និងកុំព្យូទ័រឡើងតុ
3. **ការដោះស្រាយកំហុស**: បង្ហាញកំហុសបញ្ចូលទៅអ្នកប្រើ
4. **ការប្រព្រឹត្តនៅផ្នែកអតិថិជន**: JavaScript សម្រាប់វិភាគរូបភាព (ប្រើ Transformers.js)

### 5. ការកំណត់រចនាសម្ព័ន្ធ

**ឯកសារ៖** `application.properties`

ការកំណត់សម្រាប់កម្មវិធី៖

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

**ការពន្យល់ការកំណត់៖**

1. **ការផ្ទុកឯកសារ**: អនុញ្ញាតរូបភាពមានទំហំរហូតដល់ 10MB
2. **ការចុះបញ្ជី**: គ្រប់គ្រងព័ត៌មានដែលបានចុះបញ្ជីពេលដំណើរការ
3. **GitHub Models**: កំណត់ម៉ូដែល AI និងចំណុចបញ្ចូលដែលត្រូវប្រើ
4. **សុវត្ថិភាព**: ការកំណត់សម្រាប់ការដោះស្រាយកំហុសដើម្បីជៀសវាងបង្ហាញព័ត៌មានលំអិត

## ការរត់កម្មវិធី

### ជំហាន 1៖ កំណត់ Token GitHub របស់អ្នក

ជាដំបូង អ្នកត្រូវកំណត់ token GitHub ជាផលបរិយាកាស៖

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

**ហេតុផលក្នុងការធ្វើនេះ៖**
- GitHub Models ត្រូវការសម្ងាត់សម្រាប់ចូលប្រើម៉ូដែល AI
- ការប្រើប្រាស់ផលបរិយាកាសរក្សាទុក token ដែលមានព័ត៌មានលំអិត
- `models:read` scope ផ្តល់សិទ្ធិចូលប្រើការបញ្ជូល AI

### ជំហាន 2៖ បង្កើត និងរត់កម្មវិធី

ចូលទៅកាន់ថតគម្រោង៖
```bash
cd 04-PracticalSamples/petstory
```

បង្កើតកម្មវិធី៖
```bash
mvn clean compile
```

ចាប់ផ្តើមម៉ាស៊ីនមេ៖
```bash
mvn spring-boot:run
```

កម្មវិធីនឹងរត់នៅលើ `http://localhost:8080`។

### ជំហាន 3៖ សាកល្បងកម្មវិធី

1. **បើក** `http://localhost:8080` តាមកម្មវិធីរុករក
2. **ពិពណ៌នា** សត្វរបស់អ្នកក្នុងតំបន់អត្ថបទ (ឧ. "សត្វទឹកខ្លាវលេងល្បែង ដែលចូលចិត្តយកឧបករណ៍មកយក")
3. **ចុច** "Generate Story" ដើម្បីទទួលរឿងដែលបានបង្កើតដោយ AI
4. **ជម្រើសផ្សេងទៀត** ផ្ទុករូបភាពសត្វដើម្បីបង្កើតការពិពណ៌នាស្វ័យប្រវត្តិ
5. **មើល** រឿងដែលបានបង្កើតដោយច្នៃប្រឌិតផ្អែកលើការពិពណ៌នាសត្វរបស់អ្នក

## របៀបដំណើរការទាំងអស់

នេះជាជំហានពេញលេញពេលអ្នកបង្កើតរឿងសត្វ៖

1. **បញ្ចូលអ្នកប្រើ**: អ្នកពិពណ៌នាសត្វក្នុងទំរង់វែប
2. **ដាក់ស្នើទំរង់**: ប្រភពរុករកផ្ញើសំណើ POST ទៅ `/generate-story`
3. **ដំណើរការរក្សាការគ្រប់គ្រង**: `PetController` ផ្ទៀងផ្ទាត់ និងសំអាតបញ្ចូល
4. **ហៅសេវាកម្ម AI**: `StoryService` ផ្ញើសំណើទៅ GitHub Models API
5. **បង្កើតរឿង**: AI បង្កើតរឿងដោយផ្អែកលើការពិពណ៌នា
6. **ដោះស្រាយចម្លើយ**: Controller ទទួលរឿងនិងបន្ថែមវាទៅ Model
7. **បង្ហាញពុម្ព**: Thymeleaf បង្ហាញ `result.html` ជាមួយរឿង
8. **បង្ហាញលើអេក្រង់**: អ្នកប្រើឃើញរឿងដែលបានបង្កើតក្នុងកម្មវិធីរុករក

**ដំណើរការដោះស្រាយកំហុស:**
បើសេវាកម្ម AI បរាជ័យ:
1. Controller ចាប់ករណីកំហុស
2. បង្កើតរឿងជំនួសដោយប្រើគំរូដែលបានសរសេរមុន
3. បង្ហាញរឿងជំនួសជាមួយសេចក្ដីតាំងពីអំពីមិនអាចប្រើបាន AI
4. អ្នកប្រើនៅតែទទួលបានរឿង ដើម្បីធានាបទពិសោធន៍ល្អ

## ការយល់ដឹងអំពីការភ្ជាប់ AI

### GitHub Models API
កម្មវិធីប្រើ GitHub Models ដែលផ្តល់ការចូលប្រើដោយឥតគិតថ្លៃទៅម៉ូដែល AI ចម្រុះ៖

```java
// ការផ្ទៀងផ្ទាត់អត្តសញ្ញាណជាមួយកូដសម្ងាត់ GitHub
this.openAIClient = OpenAIOkHttpClient.builder()
    .baseUrl("https://models.github.ai/inference")
    .apiKey(githubToken)
    .build();
```

### ការបង្កើត Prompt
សេវាកម្មប្រើ prompt ដែលបានរៀបចំយ៉ាងម៉ត់ចត់ដើម្បីទទួលបានលទ្ធផលល្អ៖

```java
String systemPrompt = "You are a creative storyteller who writes fun, " +
                     "family-friendly short stories about pets. " +
                     "Keep stories under 500 words and appropriate for all ages.";
```

### ដំណើរការឆ្លើយតប
ចម្លើយ AI ត្រូវបានដកយក និងផ្ទៀងផ្ទាត់៖

```java
ChatCompletion response = openAIClient.chat().completions().create(params);
String story = response.choices().get(0).message().content().orElse("");
```

## ជំហានបន្ទាប់

សម្រាប់ឧទាហរណ៍បន្ថែម សូមមើល [ជំពូក 04: ឧទាហរណ៍អនុវត្ត](../README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ការបដិសេធ**៖
ឯកសារនេះត្រូវបានបកប្រែដោយប្រើសេវាកម្មបកប្រែ AI [Co-op Translator](https://github.com/Azure/co-op-translator)។ ខណៈពេលយើងខំប្រឹងដើម្បីភាពត្រឹមត្រូវ សូមស្គាល់ថាការបកប្រែដោយស្វ័យប្រវត្តិអាចមានកំហុស ឬការខុសគ្នា។ ឯកសារដើមជាភាសាដើមគួរត្រូវបានគិតថាជា ប្រភពផ្លូវការដោយសុពលភាព។ សម្រាប់ព័ត៌មានសំខាន់ណាស់ អ្នកគួរតែប្រើការបកប្រែដោយអ្នកជំនាញមនុស្ស។ យើងមិនទទួលខុសត្រូវចំពោះការយល់ច្រឡំនៃ អត្ថន័យ ឬការបកប្រែខុសណាមួយដែលកើតមានពីការប្រើប្រាស់ការបកប្រែនេះឡើយ។
<!-- CO-OP TRANSLATOR DISCLAIMER END -->