# Foundry Local Spring Boot הדרכה

## תוכן העניינים

- [דרישות מוקדמות](#דרישות-מוקדמות)
- [סקירת הפרויקט](#סקירת-הפרויקט)
- [הבנת הקוד](#הבנת-הקוד)
  - [1. הגדרות אפליקציה (application.properties)](#1-הגדרות-אפליקציה-applicationproperties)
  - [2. מחלקת האפליקציה הראשית (Application.java)](#2-מחלקת-האפליקציה-הראשית-applicationjava)
  - [3. שכבת שירות AI (FoundryLocalService.java)](#3-שכבת-שירות-ai-foundrylocalservicejava)
  - [4. התלויות בפרויקט (pom.xml)](#4-התלויות-בפרויקט-pomxml)
- [איך הכל עובד ביחד](#איך-הכל-עובד-ביחד)
- [הגדרת Foundry Local](#הגדרת-foundry-local)
- [הרצת האפליקציה](#הרצת-האפליקציה)
- [פלט צפוי](#פלט-צפוי)
- [שלבים הבאים](#שלבים-הבאים)
- [פתרון תקלות](#פתרון-תקלות)


## דרישות מוקדמות

לפני התחלת ההדרכה, ודא שיש לך:

- **Java 21 ומעלה** מותקן במערכת שלך
- **Maven 3.6+** לבניית הפרויקט
- **Foundry Local** מותקן ופועל

### **התקן את Foundry Local:**

> **הערה:** Foundry Local CLI זמין רק עבור **Windows** ו-**macOS**. לינוקס נתמכת דרך ה-[Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# חלונות
winget install Microsoft.FoundryLocal

# מק או אס
brew tap microsoft/foundrylocal
brew install foundrylocal
```

אמת את ההתקנה:
```bash
foundry --version
```

## סקירת הפרויקט

הפרויקט מורכב מארבעה מרכיבים עיקריים:

1. **Application.java** - נקודת הכניסה הראשית לאפליקציית Spring Boot
2. **FoundryLocalService.java** - שכבת שירות שמטפלת בתקשורת עם AI
3. **application.properties** - הגדרות לחיבור ל-Foundry Local
4. **pom.xml** - התלויות ובניית הפרויקט במייבן

## הבנת הקוד

### 1. הגדרות אפליקציה (application.properties)

**קובץ:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**מה זה עושה:**
- **base-url**: מציין היכן Foundry Local רץ, כולל הנתיב `/v1` לתאימות עם OpenAI API. הפורט המוגדר כברירת מחדל הוא `5273`. אם הפורט שונה, בדוק אותו עם `foundry service status`.
- **model** (אופציונלי): שם דגם ה-AI לשימוש בהפקת טקסט. **ברירת המחדל היא זיהוי אוטומטי של הדגם** על ידי שאילתת נקודת הקצה `/v1/models` של Foundry Local בעת ההפעלה, כך שלא צריך להגדיר אותו. בכל זאת, ניתן להגדיר אותו במפורש אם רוצים לעקוף את הזיהוי האוטומטי.

**עיקרון מרכזי:** Spring Boot טוען אוטומטית את ההגדרות האלו ומאפשר גישה אליהן דרך ההערה `@Value`.

### 2. מחלקת האפליקציה הראשית (Application.java)

**קובץ:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // אין צורך בשרת אינטרנט
        app.run(args);
    }
```

**מה זה עושה:**
- `@SpringBootApplication` מפעיל את האוטו-קונפיגורציה של Spring Boot
- `WebApplicationType.NONE` מודיע לספרינג שמדובר באפליקציית שורת פקודה, לא בשרת ווב
- המתודה הראשית מפעילה את אפליקציית Spring

**הרצת הדמו:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        System.out.println("Calling Foundry Local service...");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
        System.out.println("=========================");
    };
}
```

**מה זה עושה:**
- `@Bean` יוצר רכיב שנשלט על ידי Spring
- `CommandLineRunner` מריץ קוד אחרי ש-Spring Boot עולה
- `foundryLocalService` מוזרק אוטומטית על ידי Spring (הזרקת תלויות)
- שולח הודעת בדיקה ל-AI ומציג את התגובה

### 3. שכבת שירות AI (FoundryLocalService.java)

**קובץ:** `src/main/java/com/example/FoundryLocalService.java`

#### הזרקת הגדרות:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // זוהה אוטומטית אם ריק
```

**מה זה עושה:**
- `@Service` מודיע לספרינג שזו מחלקה שמספקת לוגיקה עסקית
- `@Value` מזריק ערכי הגדרות מתוך application.properties
- ברירת המחדל של הדגם היא ריקה, מה שמפעיל **זיהוי אוטומטי** דרך Foundry Local בתחילת הריצה. זאת אומרת שהאפליקציה פועלת עם כל דגם שנטען ב-Foundry Local בלי צורך בהגדרות ידניות.

#### אתחול הלקוח:
```java
@PostConstruct
public void init() {
    // זיהוי אוטומטי של הדגם מ-Foundry Local אם לא מוגדר במפורש
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // כתובת בסיס כבר כוללת /v1 מהקונפיגורציה
            .apiKey("not-needed")            // לשרת מקומי לא צריך מפתח API אמיתי
            .build();
}
```

**מה זה עושה:**
- `@PostConstruct` מריץ את השיטה הזו לאחר ש-Spring יוצר את השירות
- אם לא הוגדר דגם, הוא שואל את נקודת הקצה `/v1/models` ב-Foundry Local ומקבל את הדגם הראשון שנטען
- יוצר לקוח OpenAI שמצביע על השרת המקומי של Foundry Local שלך
- ה-URL מהגדרות כולל כבר את הנתיב `/v1` לתאימות עם OpenAI API
- מפתח ה-API מוגדר כ"not-needed" כי בפיתוח מקומי אין צורך באימות

#### שיטת שיחה:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // איזה דגם בינה מלאכותית להשתמש
                .addUserMessage(message)         // השאלה/הפנייה שלך
                .maxCompletionTokens(150)        // הגבל את אורך התגובה
                .temperature(0.7)                // שלוט ביצירתיות (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // הפק את תגובת הבינה המלאכותית מתוצאת ה-API
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**מה זה עושה:**
- **ChatCompletionCreateParams**: מגדיר את בקשת ה-AI
  - `model`: מגדיר את דגם ה-AI לשימוש (חייב להתאים במדויק ל-ID מרשימת הדגמים `foundry model list`)
  - `addUserMessage`: מוסיף את ההודעה שלך לשיחה
  - `maxCompletionTokens`: מגביל את אורך התגובה (חוסך במשאבים)
  - `temperature`: שולט על רמת האקראיות (0.0 = דטרמיניסטי, 1.0 = יצירתי)
- **קריאת API**: שולח את הבקשה ל-Foundry Local
- **טיפול בתגובה**: מפיק בצורה בטוחה את הטקסט מהתגובה של ה-AI
- **טיפול בשגיאות**: עוטף חריגות עם הודעות שגיאה מועילות

### 4. התלויות בפרויקט (pom.xml)

**תלויות עיקריות:**

```xml
<!-- Spring Boot - Application framework -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>${spring-boot.version}</version>
</dependency>

<!-- OpenAI Java SDK - For AI API calls -->
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>

<!-- Jackson - JSON processing -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.0</version>
</dependency>
```

**מה הן עושות:**
- **spring-boot-starter**: מספק את ליבת הפונקציונליות של Spring Boot
- **openai-java**: SDK רשמי של OpenAI עבור Java לתקשורת עם ה-API
- **jackson-databind**: מטפלת בסריאליזציה/דסריאליזציה של JSON עבור קריאות API

## איך הכל עובד ביחד

הנה הזרימה המלאה כשהאפליקציה רצה:

1. **הפעלה**: Spring Boot מתחיל וקורא את `application.properties`
2. **יצירת שירות**: Spring יוצר את `FoundryLocalService` ומזריק לו את ערכי ההגדרות
3. **זיהוי דגם**: אם לא הוגדר דגם, השירות שואל את נקודת הקצה `/v1/models` ומקבל אוטומטית את הדגם הזמין הראשון
4. **הגדרת הלקוח**: `@PostConstruct` מאתחל את הלקוח של OpenAI שמתחבר ל-Foundry Local
5. **הרצת הדמו**: `CommandLineRunner` רץ לאחר ההפעלה
6. **קריאת AI**: הדמו קורא ל-`foundryLocalService.chat()` עם הודעת בדיקה
7. **בקשת API**: השירות בונה ושולח בקשה תואמת OpenAI ל-Foundry Local
8. **עיבוד תגובה**: השירות מפיק ומחזיר את תשובת ה-AI
9. **הצגה**: האפליקציה מדפיסה את התגובה ופונה

## הגדרת Foundry Local

1. **התקן את Foundry Local** באמצעות ההוראות בקטע [דרישות מוקדמות](#דרישות-מוקדמות).

2. **הפעל את השירות** (אם אינו כבר רץ):
   ```bash
   foundry service start
   ```

3. **בדוק את סטטוס השירות** לאישור שהוא פועל וראה את הפורט:
   ```bash
   foundry service status
   ```

4. **הורד והרץ דגם** (ההורדה תתבצע בהרצה הראשונה, בקאש להרצות הבאות):
   ```bash
   foundry model run phi-4-mini
   ```
   זה פותח שיחה אינטראקטיבית. ניתן לצאת באמצעות `Ctrl+C`. הדגם נשאר טעון בשירות.

   > **עצה:** הרץ `foundry model list` כדי לראות את כל הדגמים הזמינים. החלף את `phi-4-mini` בכל כינוי מהרשימה (למשל: `qwen2.5-0.5b` לדגם קטן ומהיר יותר).

5. **אמת שהדגם נטען:**
   ```bash
   foundry service ps
   ```

6. **עדכן את `application.properties` במידת הצורך:**
   - ה-`base-url` המוגדר כברירת מחדל (`http://localhost:5273/v1`) תואם את פורט CLI ברירת המחדל. עדכן רק אם ב-`foundry service status` מופיע פורט שונה.
   - הדגם **מתגלה אוטומטית** בעת ההפעלה — אין צורך בהגדרה ידנית.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## הרצת האפליקציה

### שלב 1: וודא שדגם נטען ב-Foundry Local
```bash
foundry service ps
```
אם אין דגמים ברשימה, טען אחד:
```bash
foundry model run phi-4-mini
```

### שלב 2: בניית והרצת האפליקציה
בטרמינל נפרד:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

או בנה והרץ כקובץ JAR:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## פלט צפוי

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## שלבים הבאים

לדוגמאות נוספות ראו [פרק 04: דוגמאות מעשיות](../README.md)

## פתרון תקלות

### בעיות נפוצות

**"Connection refused" או "Service unavailable"**
- בדוק את השירות: `foundry service status`
- הפעל מחדש אם צריך: `foundry service restart`
- אמת שהפורט ב-`application.properties` תואם ליציאת `foundry service status`
- ודא שה-URL מסתיים ב-`/v1`: `http://localhost:5273/v1`

**"No model found" בהפעלה**
- האפליקציה מגלה את הדגם אוטומטית. ודא שיש לפחות דגם נטען: `foundry service ps`
- אם אין דגמים נטועים: `foundry model run phi-4-mini`
- אם הגדרת שם דגם ב-`application.properties`, ודא שהוא תואם ל`foundry model list`

**שגיאות "400 Bad Request"**
- ודא שה-URL כולל `/v1`: `http://localhost:5273/v1`
- השתמש ב-`maxCompletionTokens()` בקוד שלך (ולא ב-`maxTokens()` שהוסר)

**שגיאות קומפילציה במייבן**
- ודא שיש Java 21 ומעלה: `java -version`
- נקה ובנה מחדש: `mvn clean compile`
- בדוק חיבור לאינטרנט להורדת תלויות

**בעיות חיבור לשירות**
- אם מופיע `Request to local service failed`, הפעל: `foundry service restart`
- בדוק דגמים נטענים: `foundry service ps`
- צפה בלוגים של השירות: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**כתב ויתור**:  
מסמך זה תורגם באמצעות שירות התרגום הממוחשב [Co-op Translator](https://github.com/Azure/co-op-translator). בעוד שאנו שואפים לדיוק, יש לקחת בחשבון שתרגומים אוטומטיים עלולים להכיל שגיאות או אי דיוקים. המסמך המקורי בשפת המקור שלו הוא המקור הסמכותי. למידע קריטי מומלץ להשתמש בתרגום מקצועי על ידי מתרגם אנושי. אנו לא נושאים באחריות לכל אי הבנה או פירוש שגוי הנובע משימוש בתרגום זה.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->