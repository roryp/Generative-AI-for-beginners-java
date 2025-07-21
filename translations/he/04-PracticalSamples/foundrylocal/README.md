<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T19:49:21+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "he"
}
-->
# יישום שורת פקודה מקומי של Foundry

>**הערה**: פרק זה כולל [**מדריך**](./TUTORIAL.md) שמנחה אותך כיצד להפעיל את הדוגמאות המוכנות.

יישום פשוט של Spring Boot בשורת פקודה שמדגים כיצד להתחבר ל-Foundry Local באמצעות OpenAI Java SDK.

## מה תלמדו

- כיצד לשלב את Foundry Local עם יישומי Spring Boot באמצעות OpenAI Java SDK
- שיטות עבודה מומלצות לפיתוח ובדיקות AI מקומיות

## תוכן עניינים

- [מה תלמדו](../../../../04-PracticalSamples/foundrylocal)
- [דרישות מוקדמות](../../../../04-PracticalSamples/foundrylocal)
  - [התקנת Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [אימות](../../../../04-PracticalSamples/foundrylocal)
- [הגדרות](../../../../04-PracticalSamples/foundrylocal)
- [התחלה מהירה](../../../../04-PracticalSamples/foundrylocal)
- [מה היישום עושה](../../../../04-PracticalSamples/foundrylocal)
- [פלט לדוגמה](../../../../04-PracticalSamples/foundrylocal)
- [ארכיטקטורה](../../../../04-PracticalSamples/foundrylocal)
- [נקודות עיקריות בקוד](../../../../04-PracticalSamples/foundrylocal)
  - [שילוב OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [Chat Completion API](../../../../04-PracticalSamples/foundrylocal)
- [פתרון בעיות](../../../../04-PracticalSamples/foundrylocal)

## דרישות מוקדמות

> **⚠️ הערה**: יישום זה **לא פועל בסביבת devcontainer המסופקת** מכיוון שהוא דורש התקנה והפעלה של Foundry Local במערכת המארחת.

### התקנת Foundry Local

לפני הפעלת היישום, יש להתקין ולהפעיל את Foundry Local. בצעו את השלבים הבאים:

1. **ודאו שהמערכת שלכם עומדת בדרישות**:
   - **מערכת הפעלה**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, או macOS
   - **חומרה**: 
     - מינימום: 8GB RAM, 3GB שטח דיסק פנוי
     - מומלץ: 16GB RAM, 15GB שטח דיסק פנוי
   - **רשת**: חיבור לאינטרנט להורדת מודל ראשונית (אופציונלי לשימוש לא מקוון)
   - **האצה (אופציונלי)**: NVIDIA GPU (סדרה 2,000 או חדשה יותר), AMD GPU (סדרה 6,000 או חדשה יותר), Qualcomm Snapdragon X Elite (8GB או יותר זיכרון), או Apple silicon
   - **הרשאות**: הרשאות מנהל להתקנת תוכנה במכשיר שלכם

2. **התקינו את Foundry Local**:
   
   **עבור Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **עבור macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   לחלופין, ניתן להוריד את המתקין ממאגר [Foundry Local GitHub](https://github.com/microsoft/Foundry-Local).

3. **הפעילו את המודל הראשון שלכם**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   המודל יורד (תהליך שעשוי לקחת מספר דקות, תלוי במהירות האינטרנט שלכם) ולאחר מכן מופעל. Foundry Local בוחר אוטומטית את גרסת המודל הטובה ביותר עבור המערכת שלכם (CUDA עבור NVIDIA GPUs, גרסת CPU אחרת).

4. **בדקו את המודל** על ידי שאילת שאלה באותו מסוף:

   ```bash
   Why is the sky blue?
   ```

   אתם אמורים לראות תגובה ממודל Phi המסבירה מדוע השמיים נראים כחולים.

### אימות

ניתן לאמת שהכול פועל כראוי באמצעות הפקודות הבאות:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

ניתן גם לבקר בכתובת `http://localhost:5273` בדפדפן שלכם כדי לראות את ממשק האינטרנט של Foundry Local.

## הגדרות

ניתן להגדיר את היישום דרך `application.properties`:

- `foundry.local.base-url` - כתובת בסיס עבור Foundry Local (ברירת מחדל: http://localhost:5273)
- `foundry.local.model` - מודל AI לשימוש (ברירת מחדל: Phi-3.5-mini-instruct-cuda-gpu)

> **הערה**: שם המודל בהגדרות צריך להתאים לגרסה הספציפית ש-Foundry Local הוריד עבור המערכת שלכם. כאשר אתם מפעילים `foundry model run phi-3.5-mini`, Foundry Local בוחר ומוריד אוטומטית את הגרסה הטובה ביותר (CUDA עבור NVIDIA GPUs, גרסת CPU אחרת). השתמשו ב-`foundry model list` כדי לראות את שם המודל המדויק הזמין במופע המקומי שלכם.

## התחלה מהירה

### 1. נווטו לתיקיית היישום המקומי של Foundry
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. הפעילו את היישום

```bash
mvn spring-boot:run
```

או בנו והפעילו את קובץ ה-JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### תלות

היישום משתמש ב-OpenAI Java SDK כדי לתקשר עם Foundry Local. התלות המרכזית היא:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

היישום מוגדר מראש להתחבר ל-Foundry Local הפועל על הפורט ברירת המחדל.

## מה היישום עושה

כאשר אתם מפעילים את היישום:

1. **מופעל** כיישום שורת פקודה (ללא שרת אינטרנט)
2. **שולח אוטומטית** הודעת בדיקה: "שלום! האם תוכל לספר לי מה אתה ואיזה מודל אתה מפעיל?"
3. **מציג את התגובה** מ-Foundry Local בקונסולה
4. **יוצא בצורה נקייה** לאחר הדמו

## פלט לדוגמה

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## ארכיטקטורה

- **Application.java** - יישום Spring Boot ראשי עם CommandLineRunner
- **FoundryLocalService.java** - שירות שמשתמש ב-OpenAI Java SDK כדי לתקשר עם Foundry Local
- שימוש ב-**OpenAI Java SDK** לקריאות API בטוחות
- סידור/פירוק אוטומטי של JSON מנוהל על ידי ה-SDK
- הגדרה נקייה באמצעות אנוטציות `@Value` ו-`@PostConstruct` של Spring

## נקודות עיקריות בקוד

### שילוב OpenAI Java SDK

היישום משתמש ב-OpenAI Java SDK כדי ליצור לקוח המוגדר עבור Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### Chat Completion API

ביצוע בקשות השלמת שיחה הוא פשוט ובטוח:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## פתרון בעיות

אם אתם רואים שגיאות חיבור:
1. ודאו ש-Foundry Local פועל בכתובת `http://localhost:5273`
2. בדקו שמודל Phi-3.5-mini זמין באמצעות `foundry model list`
3. ודאו ששם המודל ב-`application.properties` תואם לשם המודל המדויק שמופיע ברשימה
4. ודאו שאין חומת אש שחוסמת את החיבור

בעיות נפוצות:
- **מודל לא נמצא**: הפעילו `foundry model run phi-3.5-mini` כדי להוריד ולהפעיל את המודל
- **שירות לא פועל**: ייתכן ששירות Foundry Local נעצר; הפעילו אותו מחדש באמצעות פקודת הפעלת המודל
- **שם מודל שגוי**: השתמשו ב-`foundry model list` כדי לראות את המודלים הזמינים ועדכנו את ההגדרות שלכם בהתאם

**כתב ויתור**:  
מסמך זה תורגם באמצעות שירות תרגום מבוסס בינה מלאכותית [Co-op Translator](https://github.com/Azure/co-op-translator). למרות שאנו שואפים לדיוק, יש להיות מודעים לכך שתרגומים אוטומטיים עשויים להכיל שגיאות או אי דיוקים. המסמך המקורי בשפתו המקורית צריך להיחשב כמקור סמכותי. עבור מידע קריטי, מומלץ להשתמש בתרגום מקצועי על ידי אדם. איננו נושאים באחריות לאי הבנות או לפרשנויות שגויות הנובעות משימוש בתרגום זה.