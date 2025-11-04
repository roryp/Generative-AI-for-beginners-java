<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "fe08a184d8a753a0f497673921f77759",
  "translation_date": "2025-11-04T06:51:49+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "he"
}
-->
# מדריך Foundry Local עם Spring Boot

## תוכן עניינים

- [דרישות מקדימות](../../../../04-PracticalSamples/foundrylocal)
- [סקירת הפרויקט](../../../../04-PracticalSamples/foundrylocal)
- [הבנת הקוד](../../../../04-PracticalSamples/foundrylocal)
  - [1. הגדרות האפליקציה (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. מחלקת האפליקציה הראשית (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. שכבת שירות AI (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. תלות בפרויקט (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [איך הכל עובד יחד](../../../../04-PracticalSamples/foundrylocal)
- [הגדרת Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [הרצת האפליקציה](../../../../04-PracticalSamples/foundrylocal)
- [פלט צפוי](../../../../04-PracticalSamples/foundrylocal)
- [צעדים הבאים](../../../../04-PracticalSamples/foundrylocal)
- [פתרון תקלות](../../../../04-PracticalSamples/foundrylocal)

## דרישות מקדימות

לפני שמתחילים את המדריך, ודאו שיש לכם:

- **Java 21 או גרסה גבוהה יותר** מותקנת במערכת שלכם
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
2. **FoundryLocalService.java** - שכבת שירות שמטפלת בתקשורת עם AI
3. **application.properties** - הגדרות חיבור ל-Foundry Local
4. **pom.xml** - תלות Maven והגדרות הפרויקט

## הבנת הקוד

### 1. הגדרות האפליקציה (application.properties)

**קובץ:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**מה זה עושה:**
- **base-url**: מציין היכן Foundry Local פועל, כולל הנתיב `/v1` לצורך תאימות ל-OpenAI API. **הערה**: Foundry Local מקצה פורט באופן דינמי, לכן בדקו את הפורט בפועל באמצעות `foundry service status`
- **model**: שם מודל ה-AI לשימוש ביצירת טקסט, כולל מספר גרסה (לדוגמה, `:1`). השתמשו ב-`foundry model list` כדי לראות את המודלים הזמינים עם מזהי המודל המדויקים שלהם

**רעיון מרכזי:** Spring Boot טוען את ההגדרות הללו באופן אוטומטי ומאפשר גישה אליהן באפליקציה באמצעות האנטציה `@Value`.

### 2. מחלקת האפליקציה הראשית (Application.java)

**קובץ:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```


**מה זה עושה:**
- `@SpringBootApplication` מאפשרת קונפיגורציה אוטומטית של Spring Boot
- `WebApplicationType.NONE` מציין ל-Spring שמדובר באפליקציה מבוססת שורת פקודה ולא בשרת אינטרנט
- המתודה הראשית מפעילה את אפליקציית Spring

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
- `@Bean` יוצרת רכיב שמנוהל על ידי Spring
- `CommandLineRunner` מריץ קוד לאחר ש-Spring Boot מופעל
- `foundryLocalService` מוזרק באופן אוטומטי על ידי Spring (הזרקת תלות)
- שולח הודעת בדיקה ל-AI ומציג את התגובה

### 3. שכבת שירות AI (FoundryLocalService.java)

**קובץ:** `src/main/java/com/example/FoundryLocalService.java`

#### הזרקת קונפיגורציה:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**מה זה עושה:**
- `@Service` מציין ל-Spring שהמחלקה מספקת לוגיקה עסקית
- `@Value` מזריק ערכי קונפיגורציה מתוך application.properties
- התחביר `:default-value` מספק ערכי ברירת מחדל אם ההגדרות לא מוגדרות

#### אתחול לקוח:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```


**מה זה עושה:**
- `@PostConstruct` מריץ את המתודה הזו לאחר ש-Spring יוצר את השירות
- יוצר לקוח OpenAI שמצביע על מופע Foundry Local המקומי שלכם
- ה-URL הבסיסי מתוך `application.properties` כבר כולל `/v1` לצורך תאימות ל-OpenAI API
- מפתח API מוגדר כ-"not-needed" מכיוון שפיתוח מקומי לא דורש אימות

#### מתודת צ'אט:
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
  - `model`: מציין איזה מודל AI להשתמש (חייב להתאים למזהה המדויק מתוך `foundry model list`)
  - `addUserMessage`: מוסיף את ההודעה שלכם לשיחה
  - `maxCompletionTokens`: מגביל את אורך התגובה (חוסך משאבים)
  - `temperature`: שולט ברמת האקראיות (0.0 = דטרמיניסטי, 1.0 = יצירתי)
- **קריאת API**: שולח את הבקשה ל-Foundry Local
- **טיפול בתגובה**: שולף את תגובת הטקסט של ה-AI בצורה בטוחה
- **טיפול בשגיאות**: עוטף חריגים עם הודעות שגיאה מועילות

### 4. תלות בפרויקט (pom.xml)

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


**מה זה עושה:**
- **spring-boot-starter**: מספק פונקציונליות ליבה של Spring Boot
- **openai-java**: SDK Java רשמי של OpenAI לתקשורת עם API
- **jackson-databind**: מטפל בסריאליזציה/דסיריאליזציה של JSON עבור קריאות API

## איך הכל עובד יחד

כך מתבצע הזרימה המלאה כאשר אתם מריצים את האפליקציה:

1. **הפעלה**: Spring Boot מופעל וקורא את `application.properties`
2. **יצירת שירות**: Spring יוצר את `FoundryLocalService` ומזריק ערכי קונפיגורציה
3. **הגדרת לקוח**: `@PostConstruct` מאתחל את לקוח OpenAI להתחבר ל-Foundry Local
4. **הרצת דמו**: `CommandLineRunner` מופעל לאחר ההפעלה
5. **קריאת AI**: הדמו קורא ל-`foundryLocalService.chat()` עם הודעת בדיקה
6. **בקשת API**: השירות בונה ושולח בקשה תואמת OpenAI ל-Foundry Local
7. **עיבוד תגובה**: השירות שולף ומחזיר את תגובת ה-AI
8. **הצגה**: האפליקציה מציגה את התגובה ויוצאת

## הגדרת Foundry Local

כדי להגדיר את Foundry Local, בצעו את השלבים הבאים:

1. **התקינו את Foundry Local** לפי ההוראות בסעיף [דרישות מקדימות](../../../../04-PracticalSamples/foundrylocal).

2. **בדקו את הפורט שהוקצה באופן דינמי**. Foundry Local מקצה פורט באופן אוטומטי כאשר הוא מופעל. מצאו את הפורט שלכם באמצעות:
   ```bash
   foundry service status
   ```
   
   **אופציונלי**: אם אתם מעדיפים להשתמש בפורט ספציפי (לדוגמה, 5273), תוכלו להגדיר אותו ידנית:
   ```bash
   foundry service set --port 5273
   ```


3. **הורידו את מודל ה-AI** שברצונכם להשתמש בו, לדוגמה, `phi-3.5-mini`, באמצעות הפקודה הבאה:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **הגדירו את קובץ application.properties** כך שיתאים להגדרות Foundry Local שלכם:
   - עדכנו את הפורט ב-`base-url` (מהשלב 2), ודאו שהוא כולל `/v1` בסוף
   - עדכנו את שם המודל כך שיכלול את מספר הגרסה (בדקו עם `foundry model list`)
   
   דוגמה:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## הרצת האפליקציה

### שלב 1: הפעלת Foundry Local
```bash
foundry model run phi-3.5-mini
```


### שלב 2: בנייה והרצת האפליקציה
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


## צעדים הבאים

לעוד דוגמאות, ראו [פרק 04: דוגמאות מעשיות](../README.md)

## פתרון תקלות

### בעיות נפוצות

**"Connection refused" או "Service unavailable"**
- ודאו ש-Foundry Local פועל: `foundry model list`
- בדקו את הפורט בפועל ש-Foundry Local משתמש בו: `foundry service status`
- עדכנו את `application.properties` עם הפורט הנכון, ודאו שה-URL מסתיים ב-`/v1`
- לחלופין, הגדירו פורט ספציפי אם תרצו: `foundry service set --port 5273`
- נסו להפעיל מחדש את Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" או שגיאות "404 Not Found"**
- בדקו את המודלים הזמינים עם מזהי המודל המדויקים: `foundry model list`
- עדכנו את שם המודל ב-`application.properties` כך שיתאים בדיוק, כולל מספר הגרסה (לדוגמה, `Phi-3.5-mini-instruct-cuda-gpu:1`)
- ודאו שה-`base-url` כולל `/v1` בסוף: `http://localhost:5273/v1`
- הורידו את המודל אם צריך: `foundry model run phi-3.5-mini`

**שגיאות "400 Bad Request"**
- ודאו שה-URL הבסיסי כולל `/v1`: `http://localhost:5273/v1`
- בדקו שהמזהה של המודל תואם בדיוק למה שמוצג ב-`foundry model list`
- ודאו שאתם משתמשים ב-`maxCompletionTokens()` בקוד שלכם (ולא ב-`maxTokens()` המיושן)

**שגיאות קומפילציה ב-Maven**
- ודאו ש-Java 21 או גרסה גבוהה יותר מותקנת: `java -version`
- נקו ובנו מחדש: `mvn clean compile`
- בדקו חיבור לאינטרנט להורדת תלות

**האפליקציה מופעלת אך אין פלט**
- ודאו ש-Foundry Local מגיב: פתחו דפדפן ל-`http://localhost:5273`
- בדקו את לוגי האפליקציה להודעות שגיאה ספציפיות
- ודאו שהמודל נטען במלואו ומוכן

---

**הצהרת אחריות**:  
מסמך זה תורגם באמצעות שירות תרגום AI [Co-op Translator](https://github.com/Azure/co-op-translator). למרות שאנו שואפים לדיוק, יש לקחת בחשבון שתרגומים אוטומטיים עשויים להכיל שגיאות או אי דיוקים. המסמך המקורי בשפתו המקורית צריך להיחשב כמקור סמכותי. למידע קריטי, מומלץ להשתמש בתרגום מקצועי אנושי. אנו לא נושאים באחריות לאי הבנות או פירושים שגויים הנובעים משימוש בתרגום זה.