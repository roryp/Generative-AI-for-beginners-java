# پالتو جانوروں کی کہانی بنانے کا ابتدائی ٹیوٹوریل

## مواد کی فہرست

- [ضروریات](../../../../04-PracticalSamples/petstory)
- [پروجیکٹ کی ساخت کو سمجھنا](../../../../04-PracticalSamples/petstory)
- [اہم اجزاء کی وضاحت](../../../../04-PracticalSamples/petstory)
  - [1. مرکزی ایپلیکیشن](../../../../04-PracticalSamples/petstory)
  - [2. ویب کنٹرولر](../../../../04-PracticalSamples/petstory)
  - [3. کہانی سروس](../../../../04-PracticalSamples/petstory)
  - [4. ویب ٹیمپلیٹس](../../../../04-PracticalSamples/petstory)
  - [5. کنفیگریشن](../../../../04-PracticalSamples/petstory)
- [ایپلیکیشن چلانا](../../../../04-PracticalSamples/petstory)
- [یہ سب کیسے مل کر کام کرتا ہے](../../../../04-PracticalSamples/petstory)
- [AI انضمام کو سمجھنا](../../../../04-PracticalSamples/petstory)
- [اگلے اقدامات](../../../../04-PracticalSamples/petstory)

## ضروریات

شروع کرنے سے پہلے، یقینی بنائیں کہ آپ کے پاس یہ چیزیں موجود ہیں:
- جاوا 21 یا اس سے زیادہ انسٹال ہو
- Maven ڈیپینڈنسی مینجمنٹ کے لیے
- GitHub اکاؤنٹ جس میں `models:read` اسکوپ کے ساتھ پرسنل ایکسس ٹوکن (PAT) ہو
- جاوا، اسپرنگ بوٹ، اور ویب ڈیولپمنٹ کی بنیادی سمجھ

## پروجیکٹ کی ساخت کو سمجھنا

پالتو جانوروں کی کہانی کے پروجیکٹ میں کئی اہم فائلیں شامل ہیں:

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

## اہم اجزاء کی وضاحت

### 1. مرکزی ایپلیکیشن

**فائل:** `PetStoryApplication.java`

یہ ہماری اسپرنگ بوٹ ایپلیکیشن کا انٹری پوائنٹ ہے:

```java
@SpringBootApplication
public class PetStoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetStoryApplication.class, args);
    }
}
```

**یہ کیا کرتا ہے:**
- `@SpringBootApplication` اینوٹیشن آٹو کنفیگریشن اور کمپوننٹ اسکیننگ کو فعال کرتا ہے
- پورٹ 8080 پر ایک ایمبیڈڈ ویب سرور (Tomcat) شروع کرتا ہے
- تمام ضروری اسپرنگ بینز اور سروسز خود بخود بناتا ہے

### 2. ویب کنٹرولر

**فائل:** `PetController.java`

یہ تمام ویب درخواستوں اور صارف کے تعاملات کو ہینڈل کرتا ہے:

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

**اہم خصوصیات:**

1. **روٹ ہینڈلنگ**: `@GetMapping("/")` اپلوڈ فارم دکھاتا ہے، `@PostMapping("/generate-story")` سبمیشنز کو پروسیس کرتا ہے
2. **ان پٹ ویلیڈیشن**: خالی تفصیلات اور لمبائی کی حد کو چیک کرتا ہے
3. **سیکیورٹی**: صارف کے ان پٹ کو صاف کرتا ہے تاکہ XSS حملوں کو روکا جا سکے
4. **ایرر ہینڈلنگ**: AI سروس کی ناکامی پر بیک اپ کہانیاں فراہم کرتا ہے
5. **ماڈل بائنڈنگ**: ڈیٹا کو HTML ٹیمپلیٹس میں پاس کرتا ہے اسپرنگ کے `Model` کا استعمال کرتے ہوئے

**بیک اپ سسٹم:**
کنٹرولر میں پہلے سے لکھی گئی کہانی کے ٹیمپلیٹس شامل ہیں جو AI سروس کی عدم دستیابی پر استعمال ہوتے ہیں:

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

### 3. کہانی سروس

**فائل:** `StoryService.java`

یہ سروس GitHub Models کے ساتھ بات چیت کرتی ہے کہانیاں بنانے کے لیے:

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

**اہم اجزاء:**

1. **OpenAI کلائنٹ**: GitHub Models کے لیے کنفیگر کردہ آفیشل OpenAI جاوا SDK استعمال کرتا ہے
2. **سسٹم پرامپٹ**: AI کے رویے کو فیملی فرینڈلی پالتو جانوروں کی کہانیاں لکھنے کے لیے سیٹ کرتا ہے
3. **صارف پرامپٹ**: AI کو بالکل بتاتا ہے کہ تفصیل کی بنیاد پر کون سی کہانی لکھنی ہے
4. **پیرامیٹرز**: کہانی کی لمبائی اور تخلیقی سطح کو کنٹرول کرتا ہے
5. **ایرر ہینڈلنگ**: ایسے ایکسیپشنز پھینکتا ہے جنہیں کنٹرولر پکڑ کر ہینڈل کرتا ہے

### 4. ویب ٹیمپلیٹس

**فائل:** `index.html` (اپلوڈ فارم)

مرکزی صفحہ جہاں صارفین اپنے پالتو جانوروں کی تفصیل دیتے ہیں:

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

**فائل:** `result.html` (کہانی کی نمائش)

بنائی گئی کہانی دکھاتا ہے:

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

**ٹیمپلیٹ کی خصوصیات:**

1. **Thymeleaf انضمام**: `th:` ایٹریبیوٹس کا استعمال کرتے ہوئے ڈائنامک مواد کے لیے
2. **ریسپانسیو ڈیزائن**: موبائل اور ڈیسک ٹاپ کے لیے CSS اسٹائلنگ
3. **ایرر ہینڈلنگ**: صارفین کو ویلیڈیشن ایررز دکھاتا ہے
4. **کلائنٹ سائیڈ پروسیسنگ**: امیج تجزیہ کے لیے جاوا اسکرپٹ (Transformers.js کا استعمال کرتے ہوئے)

### 5. کنفیگریشن

**فائل:** `application.properties`

ایپلیکیشن کے لیے کنفیگریشن سیٹنگز:

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

**کنفیگریشن کی وضاحت:**

1. **فائل اپلوڈ**: 10MB تک کی تصاویر کی اجازت دیتا ہے
2. **لاگنگ**: ایپلیکیشن کے دوران لاگ ہونے والی معلومات کو کنٹرول کرتا ہے
3. **GitHub Models**: AI ماڈل اور اینڈ پوائنٹ کی وضاحت کرتا ہے
4. **سیکیورٹی**: حساس معلومات کو ظاہر ہونے سے بچانے کے لیے ایرر ہینڈلنگ کنفیگریشن

## ایپلیکیشن چلانا

### مرحلہ 1: اپنا GitHub ٹوکن سیٹ کریں

پہلے، آپ کو اپنا GitHub ٹوکن ایک ماحول متغیر کے طور پر سیٹ کرنا ہوگا:

**ونڈوز (کمانڈ پرامپٹ):**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**ونڈوز (پاور شیل):**
```powershell
$env:GITHUB_TOKEN="your_github_token_here"
```

**لینکس/میک او ایس:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

**یہ کیوں ضروری ہے:**
- GitHub Models کو AI ماڈلز تک رسائی کے لیے تصدیق کی ضرورت ہوتی ہے
- ماحول متغیرات کا استعمال حساس ٹوکنز کو سورس کوڈ سے دور رکھتا ہے
- `models:read` اسکوپ AI انفرنس تک رسائی فراہم کرتا ہے

### مرحلہ 2: بلڈ اور رن کریں

پروجیکٹ ڈائریکٹری پر جائیں:
```bash
cd 04-PracticalSamples/petstory
```

ایپلیکیشن بلڈ کریں:
```bash
mvn clean compile
```

سرور شروع کریں:
```bash
mvn spring-boot:run
```

ایپلیکیشن `http://localhost:8080` پر شروع ہوگی۔

### مرحلہ 3: ایپلیکیشن ٹیسٹ کریں

1. **کھولیں** `http://localhost:8080` اپنے براؤزر میں
2. **تفصیل دیں** اپنے پالتو جانور کی ٹیکسٹ ایریا میں (مثلاً، "ایک کھیلنے والا گولڈن ریٹریور جو چیزیں لانے کا شوقین ہے")
3. **کلک کریں** "کہانی بنائیں" AI سے بنائی گئی کہانی حاصل کرنے کے لیے
4. **متبادل طور پر**, ایک پالتو جانور کی تصویر اپلوڈ کریں تاکہ خودکار طور پر تفصیل بنائی جا سکے
5. **دیکھیں** تخلیقی کہانی جو آپ کے پالتو جانور کی تفصیل پر مبنی ہے

## یہ سب کیسے مل کر کام کرتا ہے

جب آپ پالتو جانور کی کہانی بناتے ہیں تو مکمل عمل یہ ہے:

1. **صارف ان پٹ**: آپ ویب فارم پر اپنے پالتو جانور کی تفصیل دیتے ہیں
2. **فارم سبمیشن**: براؤزر POST درخواست `/generate-story` پر بھیجتا ہے
3. **کنٹرولر پروسیسنگ**: `PetController` ان پٹ کو ویلیڈیٹ اور صاف کرتا ہے
4. **AI سروس کال**: `StoryService` GitHub Models API کو درخواست بھیجتا ہے
5. **کہانی کی تخلیق**: AI تفصیل کی بنیاد پر تخلیقی کہانی بناتا ہے
6. **جواب ہینڈلنگ**: کنٹرولر کہانی وصول کرتا ہے اور ماڈل میں شامل کرتا ہے
7. **ٹیمپلیٹ رینڈرنگ**: Thymeleaf `result.html` کو کہانی کے ساتھ رینڈر کرتا ہے
8. **نمائش**: صارف اپنے براؤزر میں بنائی گئی کہانی دیکھتا ہے

**ایرر ہینڈلنگ کا عمل:**
اگر AI سروس ناکام ہو:
1. کنٹرولر ایکسیپشن پکڑتا ہے
2. پہلے سے لکھی گئی کہانی کے ٹیمپلیٹس کا استعمال کرتے ہوئے بیک اپ کہانی بناتا ہے
3. AI کی عدم دستیابی کے بارے میں نوٹ کے ساتھ بیک اپ کہانی دکھاتا ہے
4. صارف کو پھر بھی کہانی ملتی ہے، اچھے صارف تجربے کو یقینی بناتے ہوئے

## AI انضمام کو سمجھنا

### GitHub Models API
ایپلیکیشن GitHub Models استعمال کرتی ہے، جو مختلف AI ماڈلز تک مفت رسائی فراہم کرتا ہے:

```java
// Authentication with GitHub token
this.openAIClient = OpenAIOkHttpClient.builder()
    .baseUrl("https://models.github.ai/inference")
    .apiKey(githubToken)
    .build();
```

### پرامپٹ انجینئرنگ
سروس اچھے نتائج حاصل کرنے کے لیے احتیاط سے تیار کردہ پرامپٹس استعمال کرتی ہے:

```java
String systemPrompt = "You are a creative storyteller who writes fun, " +
                     "family-friendly short stories about pets. " +
                     "Keep stories under 500 words and appropriate for all ages.";
```

### جواب پروسیسنگ
AI کے جواب کو نکالا اور ویلیڈیٹ کیا جاتا ہے:

```java
ChatCompletion response = openAIClient.chat().completions().create(params);
String story = response.choices().get(0).message().content().orElse("");
```

## اگلے اقدامات

مزید مثالوں کے لیے، دیکھیں [باب 04: عملی نمونے](../README.md)

**ڈسکلیمر**:  
یہ دستاویز AI ترجمہ سروس [Co-op Translator](https://github.com/Azure/co-op-translator) کا استعمال کرتے ہوئے ترجمہ کی گئی ہے۔ ہم درستگی کے لیے کوشش کرتے ہیں، لیکن براہ کرم آگاہ رہیں کہ خودکار ترجمے میں غلطیاں یا غیر درستیاں ہو سکتی ہیں۔ اصل دستاویز کو اس کی اصل زبان میں مستند ذریعہ سمجھا جانا چاہیے۔ اہم معلومات کے لیے، پیشہ ور انسانی ترجمہ کی سفارش کی جاتی ہے۔ ہم اس ترجمے کے استعمال سے پیدا ہونے والی کسی بھی غلط فہمی یا غلط تشریح کے ذمہ دار نہیں ہیں۔