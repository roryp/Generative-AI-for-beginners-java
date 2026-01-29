# מדריך למתחילים ליצירת סיפורים על חיות מחמד

## תוכן עניינים

- [דרישות מקדימות](../../../../04-PracticalSamples/petstory)
- [הבנת מבנה הפרויקט](../../../../04-PracticalSamples/petstory)
- [הסבר על רכיבים מרכזיים](../../../../04-PracticalSamples/petstory)
  - [1. יישום ראשי](../../../../04-PracticalSamples/petstory)
  - [2. בקר אינטרנט](../../../../04-PracticalSamples/petstory)
  - [3. שירות סיפורים](../../../../04-PracticalSamples/petstory)
  - [4. תבניות אינטרנט](../../../../04-PracticalSamples/petstory)
  - [5. קובץ הגדרות](../../../../04-PracticalSamples/petstory)
- [הרצת היישום](../../../../04-PracticalSamples/petstory)
- [איך הכל עובד יחד](../../../../04-PracticalSamples/petstory)
- [הבנת האינטגרציה עם AI](../../../../04-PracticalSamples/petstory)
- [השלבים הבאים](../../../../04-PracticalSamples/petstory)

## דרישות מקדימות

לפני שמתחילים, ודאו שיש לכם:
- Java 21 או גרסה חדשה יותר מותקנת
- Maven לניהול תלות
- חשבון GitHub עם אסימון גישה אישי (PAT) עם הרשאת `models:read`
- הבנה בסיסית של Java, Spring Boot ופיתוח אתרים

## הבנת מבנה הפרויקט

לפרויקט סיפורי חיות מחמד יש מספר קבצים חשובים:

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

## הסבר על רכיבים מרכזיים

### 1. יישום ראשי

**קובץ:** `PetStoryApplication.java`

זהו נקודת הכניסה ליישום Spring Boot שלנו:

```java
@SpringBootApplication
public class PetStoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetStoryApplication.class, args);
    }
}
```

**מה זה עושה:**
- האנטציה `@SpringBootApplication` מאפשרת קונפיגורציה אוטומטית וסריקת רכיבים
- מפעיל שרת אינטרנט מובנה (Tomcat) על פורט 8080
- יוצר את כל ה-Spring beans והשירותים הנדרשים באופן אוטומטי

### 2. בקר אינטרנט

**קובץ:** `PetController.java`

מטפל בכל הבקשות מהאינטרנט ובאינטראקציות עם המשתמש:

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

**תכונות עיקריות:**

1. **ניהול מסלולים**: `@GetMapping("/")` מציג את טופס ההעלאה, `@PostMapping("/generate-story")` מעבד את ההגשות
2. **אימות קלט**: בודק תיאורים ריקים ומגבלות אורך
3. **אבטחה**: מנקה קלט משתמשים כדי למנוע התקפות XSS
4. **ניהול שגיאות**: מספק סיפורים חלופיים כאשר שירות ה-AI נכשל
5. **קשירת מודל**: מעביר נתונים לתבניות HTML באמצעות `Model` של Spring

**מערכת חלופית:**
הבקר כולל תבניות סיפורים מוכנות מראש שמשמשות כאשר שירות ה-AI אינו זמין:

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

### 3. שירות סיפורים

**קובץ:** `StoryService.java`

שירות זה מתקשר עם GitHub Models ליצירת סיפורים:

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

**רכיבים עיקריים:**

1. **לקוח OpenAI**: משתמש ב-SDK הרשמי של OpenAI המוגדר עבור GitHub Models
2. **System Prompt**: מגדיר את התנהגות ה-AI לכתיבת סיפורים ידידותיים למשפחה
3. **User Prompt**: מורה ל-AI בדיוק איזה סיפור לכתוב בהתבסס על התיאור
4. **פרמטרים**: שולט באורך הסיפור וברמת היצירתיות
5. **ניהול שגיאות**: זורק חריגים שהבקר תופס ומטפל בהם

### 4. תבניות אינטרנט

**קובץ:** `index.html` (טופס העלאה)

העמוד הראשי שבו המשתמשים מתארים את חיות המחמד שלהם:

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

**קובץ:** `result.html` (תצוגת סיפור)

מציג את הסיפור שנוצר:

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

**תכונות התבנית:**

1. **אינטגרציה עם Thymeleaf**: משתמש בתכונות `th:` לתוכן דינמי
2. **עיצוב רספונסיבי**: עיצוב CSS למובייל ולמחשב שולחני
3. **ניהול שגיאות**: מציג שגיאות אימות למשתמשים
4. **עיבוד בצד הלקוח**: JavaScript לניתוח תמונות (באמצעות Transformers.js)

### 5. קובץ הגדרות

**קובץ:** `application.properties`

הגדרות קונפיגורציה ליישום:

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

**הסבר על ההגדרות:**

1. **העלאת קבצים**: מאפשר העלאת תמונות עד 10MB
2. **לוגים**: שולט במידע שנרשם במהלך ההרצה
3. **GitHub Models**: מציין איזה מודל AI ואיזה נקודת קצה להשתמש
4. **אבטחה**: הגדרות ניהול שגיאות כדי למנוע חשיפת מידע רגיש

## הרצת היישום

### שלב 1: הגדרת אסימון GitHub

ראשית, יש להגדיר את אסימון GitHub כמשתנה סביבה:

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

**למה זה נדרש:**
- GitHub Models דורש אימות כדי לגשת למודלים של AI
- שימוש במשתני סביבה שומר על אסימונים רגישים מחוץ לקוד המקור
- ההרשאה `models:read` מספקת גישה לאינפרנס AI

### שלב 2: בנייה והרצה

נווטו לתיקיית הפרויקט:
```bash
cd 04-PracticalSamples/petstory
```

בנו את היישום:
```bash
mvn clean compile
```

הפעילו את השרת:
```bash
mvn spring-boot:run
```

היישום יתחיל בכתובת `http://localhost:8080`.

### שלב 3: בדיקת היישום

1. **פתחו** את `http://localhost:8080` בדפדפן
2. **תארו** את חיית המחמד שלכם בתיבת הטקסט (לדוגמה, "כלב גולדן רטריבר שובב שאוהב להביא כדורים")
3. **לחצו** על "צור סיפור" כדי לקבל סיפור שנוצר על ידי AI
4. **לחלופין**, העלו תמונה של חיית המחמד ליצירת תיאור אוטומטי
5. **צפו** בסיפור היצירתי שנוצר על בסיס תיאור חיית המחמד שלכם

## איך הכל עובד יחד

כך נראה הזרם המלא כאשר אתם יוצרים סיפור על חיית מחמד:

1. **קלט משתמש**: אתם מתארים את חיית המחמד בטופס האינטרנט
2. **שליחת טופס**: הדפדפן שולח בקשת POST ל-`/generate-story`
3. **עיבוד בבקר**: `PetController` מאמת ומנקה את הקלט
4. **קריאה לשירות AI**: `StoryService` שולח בקשה ל-API של GitHub Models
5. **יצירת סיפור**: ה-AI יוצר סיפור יצירתי על בסיס התיאור
6. **טיפול בתגובה**: הבקר מקבל את הסיפור ומוסיף אותו למודל
7. **עיבוד תבנית**: Thymeleaf מעבד את `result.html` עם הסיפור
8. **תצוגה**: המשתמש רואה את הסיפור שנוצר בדפדפן

**זרם ניהול שגיאות:**
אם שירות ה-AI נכשל:
1. הבקר תופס את החריג
2. יוצר סיפור חלופי באמצעות תבניות מוכנות מראש
3. מציג את הסיפור החלופי עם הערה על אי זמינות ה-AI
4. המשתמש עדיין מקבל סיפור, מה שמבטיח חוויית משתמש טובה

## הבנת האינטגרציה עם AI

### API של GitHub Models
היישום משתמש ב-GitHub Models, שמספק גישה חינמית למודלים שונים של AI:

```java
// Authentication with GitHub token
this.openAIClient = OpenAIOkHttpClient.builder()
    .baseUrl("https://models.github.ai/inference")
    .apiKey(githubToken)
    .build();
```

### הנדסת פרומפטים
השירות משתמש בפרומפטים שנכתבו בקפידה כדי לקבל תוצאות טובות:

```java
String systemPrompt = "You are a creative storyteller who writes fun, " +
                     "family-friendly short stories about pets. " +
                     "Keep stories under 500 words and appropriate for all ages.";
```

### עיבוד תגובות
תגובת ה-AI נשלפת ומאומתת:

```java
ChatCompletion response = openAIClient.chat().completions().create(params);
String story = response.choices().get(0).message().content().orElse("");
```

## השלבים הבאים

לעוד דוגמאות, ראו [פרק 04: דוגמאות מעשיות](../README.md)

**כתב ויתור**:  
מסמך זה תורגם באמצעות שירות תרגום מבוסס בינה מלאכותית [Co-op Translator](https://github.com/Azure/co-op-translator). למרות שאנו שואפים לדיוק, יש לקחת בחשבון שתרגומים אוטומטיים עשויים להכיל שגיאות או אי דיוקים. המסמך המקורי בשפתו המקורית צריך להיחשב כמקור סמכותי. עבור מידע קריטי, מומלץ להשתמש בתרגום מקצועי על ידי אדם. איננו נושאים באחריות לאי הבנות או לפרשנויות שגויות הנובעות משימוש בתרגום זה.