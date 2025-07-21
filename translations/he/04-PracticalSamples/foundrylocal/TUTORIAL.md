<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2284c54d2a98090a37df0dbef1633ebf",
  "translation_date": "2025-07-21T19:54:28+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/TUTORIAL.md",
  "language_code": "he"
}
-->
# מדריך Foundry Local עם Spring Boot

## תוכן עניינים

- [דרישות מקדימות](../../../../04-PracticalSamples/foundrylocal)
- [סקירת הפרויקט](../../../../04-PracticalSamples/foundrylocal)
- [הבנת הקוד](../../../../04-PracticalSamples/foundrylocal)
  - [1. קובץ הקונפיגורציה (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. מחלקת האפליקציה הראשית (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. שכבת השירות של AI (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. תלותים בפרויקט (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [איך הכל עובד יחד](../../../../04-PracticalSamples/foundrylocal)
- [הגדרת Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [הרצת האפליקציה](../../../../04-PracticalSamples/foundrylocal)
- [פלט צפוי](../../../../04-PracticalSamples/foundrylocal)
- [השלבים הבאים](../../../../04-PracticalSamples/foundrylocal)
- [פתרון תקלות](../../../../04-PracticalSamples/foundrylocal)

## דרישות מקדימות

לפני שתתחיל במדריך זה, ודא שיש לך:

- **Java 21 או גרסה מתקדמת יותר** מותקנת במערכת שלך
- **Maven 3.6+** לבניית הפרויקט
- **Foundry Local** מותקן ופועל

### **התקנת Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## סקירת הפרויקט

הפרויקט מורכב מארבעה רכיבים עיקריים:

1. **Application.java** - נקודת הכניסה הראשית של אפליקציית Spring Boot
2. **FoundryLocalService.java** - שכבת השירות שמטפלת בתקשורת עם ה-AI
3. **application.properties** - קובץ הקונפיגורציה לחיבור עם Foundry Local
4. **pom.xml** - תלותים והגדרות הפרויקט ב-Maven

## הבנת הקוד

### 1. קובץ הקונפיגורציה (application.properties)

**מיקום הקובץ:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu
```

**מה הקובץ עושה:**
- **base-url**: מגדיר היכן Foundry Local פועל (ברירת מחדל: פורט 5273)
- **model**: שם המודל של ה-AI שישמש ליצירת טקסט

**רעיון מרכזי:** Spring Boot טוען אוטומטית את ההגדרות הללו והופך אותן לזמינות באפליקציה באמצעות האנוטציה `@Value`.

### 2. מחלקת האפליקציה הראשית (Application.java)

**מיקום הקובץ:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```

**מה המחלקה עושה:**
- `@SpringBootApplication` מאפשרת קונפיגורציה אוטומטית של Spring Boot
- `WebApplicationType.NONE` מציין שזו אפליקציה מבוססת שורת פקודה ולא שרת אינטרנט
- המתודה הראשית מפעילה את האפליקציה של Spring

**הרצת הדמו:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
    };
}
```

**מה זה עושה:**
- `@Bean` יוצר רכיב שמנוהל על ידי Spring
- `CommandLineRunner` מריץ קוד לאחר ש-Spring Boot עולה
- `foundryLocalService` מוזרק אוטומטית על ידי Spring (הזרקת תלותים)
- שולח הודעת בדיקה ל-AI ומציג את התגובה

### 3. שכבת השירות של AI (FoundryLocalService.java)

**מיקום הקובץ:** `src/main/java/com/example/FoundryLocalService.java`

#### הזרקת קונפיגורציה:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu}")
    private String model;
```

**מה זה עושה:**
- `@Service` מציין שזו מחלקה שמספקת לוגיקה עסקית
- `@Value` מזריק ערכי קונפיגורציה מתוך application.properties
- התחביר `:default-value` מספק ערכי ברירת מחדל אם ההגדרות לא מוגדרות

#### אתחול הלקוח:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")        // Foundry Local uses OpenAI-compatible API
            .apiKey("unused")                 // Local server doesn't need real API key
            .build();
}
```

**מה זה עושה:**
- `@PostConstruct` מריץ את המתודה הזו לאחר ש-Spring יוצר את השירות
- יוצר לקוח OpenAI שמצביע על המופע המקומי של Foundry Local
- הנתיב `/v1` נדרש לתאימות עם API של OpenAI
- מפתח ה-API הוא "unused" כי פיתוח מקומי לא דורש אימות

#### מתודת הצ'אט:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Which AI model to use
                .addUserMessage(message)         // Your question/prompt
                .maxCompletionTokens(150)        // Limit response length
                .temperature(0.7)                // Control creativity (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extract the AI's response from the API result
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
  - `model`: מציין איזה מודל AI להשתמש
  - `addUserMessage`: מוסיף את ההודעה שלך לשיחה
  - `maxCompletionTokens`: מגביל את אורך התגובה (חוסך משאבים)
  - `temperature`: שולט ברנדומליות (0.0 = דטרמיניסטי, 1.0 = יצירתי)
- **קריאת API**: שולח את הבקשה ל-Foundry Local
- **טיפול בתגובה**: שולף את תגובת הטקסט של ה-AI בצורה בטוחה
- **טיפול בשגיאות**: עוטף חריגים עם הודעות שגיאה מועילות

### 4. תלותים בפרויקט (pom.xml)

**תלותים עיקריים:**

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

**מה הם עושים:**
- **spring-boot-starter**: מספק פונקציונליות ליבה של Spring Boot
- **openai-java**: SDK רשמי של OpenAI לתקשורת עם ה-API
- **jackson-databind**: מטפל בסריאליזציה/דסיריאליזציה של JSON עבור קריאות API

## איך הכל עובד יחד

כך נראה הזרם המלא כאשר מריצים את האפליקציה:

1. **אתחול**: Spring Boot עולה וקורא את `application.properties`
2. **יצירת שירות**: Spring יוצר את `FoundryLocalService` ומזריק ערכי קונפיגורציה
3. **הגדרת לקוח**: `@PostConstruct` מאתחל את לקוח OpenAI לחיבור ל-Foundry Local
4. **הרצת דמו**: `CommandLineRunner` רץ לאחר האתחול
5. **קריאת AI**: הדמו קורא ל-`foundryLocalService.chat()` עם הודעת בדיקה
6. **בקשת API**: השירות בונה ושולח בקשה תואמת OpenAI ל-Foundry Local
7. **עיבוד תגובה**: השירות שולף ומחזיר את תגובת ה-AI
8. **הצגה**: האפליקציה מציגה את התגובה ויוצאת

## הגדרת Foundry Local

כדי להגדיר את Foundry Local, בצע את השלבים הבאים:

1. **התקן את Foundry Local** לפי ההוראות בסעיף [דרישות מקדימות](../../../../04-PracticalSamples/foundrylocal).
2. **הורד את מודל ה-AI** שברצונך להשתמש בו, לדוגמה, `phi-3.5-mini`, באמצעות הפקודה הבאה:
   ```bash
   foundry model run phi-3.5-mini
   ```
3. **עדכן את קובץ application.properties** כך שיתאים להגדרות Foundry Local שלך, במיוחד אם אתה משתמש בפורט או מודל שונים.

## הרצת האפליקציה

### שלב 1: הפעל את Foundry Local
```bash
foundry model run phi-3.5-mini
```

### שלב 2: בנה והרץ את האפליקציה
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
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```

## השלבים הבאים

לעוד דוגמאות, ראה [פרק 04: דוגמאות מעשיות](../README.md)

## פתרון תקלות

### בעיות נפוצות

**"Connection refused" או "Service unavailable"**
- ודא ש-Foundry Local פועל: `foundry model list`
- בדוק שהשירות פועל על פורט 5273: בדוק את `application.properties`
- נסה להפעיל מחדש את Foundry Local: `foundry model run phi-3.5-mini`

**שגיאות "Model not found"**
- בדוק אילו מודלים זמינים: `foundry model list`
- עדכן את שם המודל ב-`application.properties` כך שיתאים בדיוק
- הורד את המודל אם נדרש: `foundry model run phi-3.5-mini`

**שגיאות קומפילציה ב-Maven**
- ודא ש-Java 21 או גרסה מתקדמת יותר מותקנת: `java -version`
- נקה ובנה מחדש: `mvn clean compile`
- בדוק חיבור לאינטרנט להורדת תלותים

**האפליקציה פועלת אך אין פלט**
- ודא ש-Foundry Local מגיב: פתח דפדפן לכתובת `http://localhost:5273`
- בדוק את לוגי האפליקציה להודעות שגיאה ספציפיות
- ודא שהמודל נטען במלואו ומוכן

**כתב ויתור**:  
מסמך זה תורגם באמצעות שירות תרגום מבוסס בינה מלאכותית [Co-op Translator](https://github.com/Azure/co-op-translator). למרות שאנו שואפים לדיוק, יש להיות מודעים לכך שתרגומים אוטומטיים עשויים להכיל שגיאות או אי דיוקים. המסמך המקורי בשפתו המקורית צריך להיחשב כמקור סמכותי. עבור מידע קריטי, מומלץ להשתמש בתרגום מקצועי על ידי אדם. איננו נושאים באחריות לאי הבנות או לפרשנויות שגויות הנובעות משימוש בתרגום זה.