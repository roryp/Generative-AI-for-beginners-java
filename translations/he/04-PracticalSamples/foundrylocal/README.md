<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d064108b2142d32246ccbd8a42e76b4d",
  "translation_date": "2025-07-25T09:46:14+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "he"
}
-->
# יישום שורת פקודה מקומי של Foundry

>**הערה**: פרק זה כולל [**מדריך**](./TUTORIAL.md) שמנחה אותך דרך הדוגמאות.

יישום פשוט של Spring Boot בשורת הפקודה שמדגים כיצד להתחבר ל-Foundry Local באמצעות OpenAI Java SDK.

## מה תלמדו

- כיצד לשלב את Foundry Local עם יישומי Spring Boot באמצעות OpenAI Java SDK
- שיטות עבודה מומלצות לפיתוח ובדיקות AI מקומיות

## תוכן העניינים

- [מה תלמדו](../../../../04-PracticalSamples/foundrylocal)
- [דרישות מוקדמות](../../../../04-PracticalSamples/foundrylocal)
  - [התקנת Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [אימות](../../../../04-PracticalSamples/foundrylocal)
- [תצורה](../../../../04-PracticalSamples/foundrylocal)
- [התחלה מהירה](../../../../04-PracticalSamples/foundrylocal)
- [מה היישום עושה](../../../../04-PracticalSamples/foundrylocal)
- [פלט לדוגמה](../../../../04-PracticalSamples/foundrylocal)
- [ארכיטקטורה](../../../../04-PracticalSamples/foundrylocal)
- [נקודות עיקריות בקוד](../../../../04-PracticalSamples/foundrylocal)
  - [שילוב OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [Chat Completion API](../../../../04-PracticalSamples/foundrylocal)
- [פתרון בעיות](../../../../04-PracticalSamples/foundrylocal)

## דרישות מוקדמות

> **⚠️ הערה**: יישום זה **אינו פועל בסביבת devcontainer המסופקת** מכיוון שהוא דורש התקנה והרצה של Foundry Local במערכת המארחת.

### התקנת Foundry Local

לפני הרצת יישום זה, יש להתקין ולהפעיל את Foundry Local. בצעו את השלבים הבאים:

1. **ודאו שהמערכת שלכם עומדת בדרישות**:
   - **מערכת הפעלה**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, או macOS
   - **חומרה**: 
     - מינימום: 8GB RAM, 3GB שטח דיסק פנוי
     - מומלץ: 16GB RAM, 15GB שטח דיסק פנוי
   - **רשת**: חיבור לאינטרנט להורדת המודל הראשונית (אופציונלי לשימוש לא מקוון)
   - **האצה (אופציונלי)**: כרטיס מסך NVIDIA (סדרה 2000 או חדשה יותר), AMD (סדרה 6000 או חדשה יותר), Qualcomm Snapdragon X Elite (עם 8GB זיכרון או יותר), או Apple silicon
   - **הרשאות**: הרשאות מנהל להתקנת תוכנה במכשיר

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
   
   לחלופין, ניתן להוריד את המתקין ממאגר [Foundry Local ב-GitHub](https://github.com/microsoft/Foundry-Local).

3. **הפעילו את המודל הראשון שלכם**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   המודל יורד (תהליך שיכול לקחת מספר דקות, בהתאם למהירות האינטרנט) ואז יופעל. Foundry Local בוחר אוטומטית את גרסת המודל הטובה ביותר עבור המערכת שלכם (CUDA עבור כרטיסי מסך של NVIDIA, גרסת CPU אחרת).

4. **בדקו את המודל** על ידי שאילת שאלה באותו מסוף:

   ```bash
   Why is the sky blue?
   ```

   אתם אמורים לראות תגובה ממודל Phi שמסבירה מדוע השמיים נראים כחולים.

### אימות

ניתן לאמת שהכול פועל כראוי באמצעות הפקודות הבאות:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

ניתן גם לבקר בכתובת `http://localhost:5273` בדפדפן כדי לראות את ממשק האינטרנט של Foundry Local.

## תצורה

ניתן להגדיר את היישום באמצעות `application.properties`:

- `foundry.local.base-url` - כתובת הבסיס של Foundry Local (ברירת מחדל: http://localhost:5273)
- `foundry.local.model` - מודל ה-AI לשימוש (ברירת מחדל: Phi-3.5-mini-instruct-cuda-gpu)

> **הערה**: שם המודל בתצורה צריך להתאים לגרסה הספציפית ש-Foundry Local הוריד עבור המערכת שלכם. כאשר מריצים `foundry model run phi-3.5-mini`, Foundry Local בוחר ומוריד אוטומטית את הגרסה הטובה ביותר (CUDA עבור כרטיסי מסך של NVIDIA, גרסת CPU אחרת). השתמשו ב-`foundry model list` כדי לראות את שם המודל המדויק הזמין במופע המקומי שלכם.

## התחלה מהירה

### 1. נווטו לתיקיית יישום Foundry Local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. הריצו את היישום

```bash
mvn spring-boot:run
```

או בנו והריצו את קובץ ה-JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### תלות

יישום זה משתמש ב-OpenAI Java SDK לתקשורת עם Foundry Local. התלות המרכזית היא:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

היישום מוגדר מראש להתחבר ל-Foundry Local שרץ על הפורט המוגדר כברירת מחדל.

## מה היישום עושה

כאשר מריצים את היישום:

1. **הוא מופעל** כיישום שורת פקודה (ללא שרת אינטרנט)
2. **שולח אוטומטית** הודעת בדיקה: "שלום! האם תוכל לספר לי מה אתה ואיזה מודל אתה מריץ?"
3. **מציג את התגובה** מ-Foundry Local במסוף
4. **יוצא בצורה מסודרת** לאחר ההדגמה

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
- **FoundryLocalService.java** - שירות שמשתמש ב-OpenAI Java SDK לתקשורת עם Foundry Local
- שימוש ב-**OpenAI Java SDK** לשיחות API בטוחות
- סריאליזציה/דסיריאליזציה אוטומטית של JSON מנוהלת על ידי ה-SDK
- תצורה נקייה באמצעות האנוטציות `@Value` ו-`@PostConstruct` של Spring

## נקודות עיקריות בקוד

### שילוב OpenAI Java SDK

היישום משתמש ב-OpenAI Java SDK ליצירת לקוח שמוגדר עבור Foundry Local:

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

ביצוע בקשות להשלמת שיחה הוא פשוט ובטוח:

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
3. ודאו ששם המודל ב-`application.properties` תואם לשם המודל המדויק שמוצג ברשימה
4. ודאו שאין חומת אש שחוסמת את החיבור

בעיות נפוצות:
- **מודל לא נמצא**: הריצו `foundry model run phi-3.5-mini` כדי להוריד ולהפעיל את המודל
- **השירות לא פועל**: ייתכן ששירות Foundry Local נעצר; הפעילו אותו מחדש עם פקודת הרצת המודל
- **שם מודל שגוי**: השתמשו ב-`foundry model list` כדי לראות את המודלים הזמינים ועדכנו את התצורה בהתאם

**כתב ויתור**:  
מסמך זה תורגם באמצעות שירות תרגום מבוסס בינה מלאכותית [Co-op Translator](https://github.com/Azure/co-op-translator). למרות שאנו שואפים לדיוק, יש להיות מודעים לכך שתרגומים אוטומטיים עשויים להכיל שגיאות או אי-דיוקים. המסמך המקורי בשפתו המקורית צריך להיחשב כמקור הסמכותי. למידע קריטי, מומלץ להשתמש בתרגום מקצועי על ידי בני אדם. איננו נושאים באחריות לאי-הבנות או לפרשנויות שגויות הנובעות משימוש בתרגום זה.