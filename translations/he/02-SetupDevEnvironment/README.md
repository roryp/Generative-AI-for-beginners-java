<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0b563ac59362fb83f0f49dcfc442dd97",
  "translation_date": "2025-07-21T19:30:37+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "he"
}
-->
# הגדרת סביבת פיתוח ל-AI גנרטיבי עבור Java

> **התחלה מהירה**: כתיבת קוד בענן תוך 2 דקות - דלגו ל-[הגדרת GitHub Codespaces](../../../02-SetupDevEnvironment) - ללא צורך בהתקנה מקומית ומשתמש במודלים של GitHub!

> **מעוניינים ב-Azure OpenAI?** עיינו במדריך [Azure OpenAI Setup Guide](getting-started-azure-openai.md) עם שלבים ליצירת משאב חדש ב-Azure OpenAI.

## מה תלמדו

- להגדיר סביבת פיתוח Java ליישומי AI
- לבחור ולהגדיר את סביבת הפיתוח המועדפת עליכם (ענן באמצעות Codespaces, מכולה מקומית, או התקנה מלאה מקומית)
- לבדוק את ההגדרה שלכם על ידי חיבור למודלים של GitHub

## תוכן העניינים

- [מה תלמדו](../../../02-SetupDevEnvironment)
- [מבוא](../../../02-SetupDevEnvironment)
- [שלב 1: הגדרת סביבת הפיתוח](../../../02-SetupDevEnvironment)
  - [אפשרות א': GitHub Codespaces (מומלץ)](../../../02-SetupDevEnvironment)
  - [אפשרות ב': מכולה מקומית](../../../02-SetupDevEnvironment)
  - [אפשרות ג': שימוש בהתקנה מקומית קיימת](../../../02-SetupDevEnvironment)
- [שלב 2: יצירת אסימון גישה אישי ל-GitHub](../../../02-SetupDevEnvironment)
- [שלב 3: בדיקת ההגדרה](../../../02-SetupDevEnvironment)
- [פתרון בעיות](../../../02-SetupDevEnvironment)
- [סיכום](../../../02-SetupDevEnvironment)
- [השלבים הבאים](../../../02-SetupDevEnvironment)

## מבוא

פרק זה ינחה אתכם בהגדרת סביבת פיתוח. נשתמש ב-**GitHub Models** כדוגמה ראשית מכיוון שזהו כלי חינמי, קל להגדרה עם חשבון GitHub בלבד, אינו דורש כרטיס אשראי, ומספק גישה למספר מודלים לניסויים.

**אין צורך בהתקנה מקומית!** ניתן להתחיל לכתוב קוד מיד באמצעות GitHub Codespaces, המספק סביבת פיתוח מלאה בדפדפן שלכם.

<img src="./images/models.webp" alt="צילום מסך: GitHub Models" width="50%">

אנו ממליצים להשתמש ב-[**GitHub Models**](https://github.com/marketplace?type=models) לקורס זה מכיוון ש:
- **חינמי** להתחלה
- **קל** להגדרה עם חשבון GitHub בלבד
- **ללא צורך בכרטיס אשראי**
- **מספר מודלים** זמינים לניסויים

> **הערה**: למודלים של GitHub המשמשים באימון זה יש מגבלות חינמיות:
> - 15 בקשות לדקה (150 ביום)
> - ~8,000 מילים נכנסות, ~4,000 מילים יוצאות לכל בקשה
> - 5 בקשות במקביל
> 
> לשימוש בייצור, שדרגו ל-Azure AI Foundry Models עם חשבון Azure שלכם. אין צורך לשנות את הקוד. עיינו בתיעוד [Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models).

## שלב 1: הגדרת סביבת הפיתוח

<a name="quick-start-cloud"></a>

יצרנו מכולת פיתוח מוגדרת מראש כדי למזער את זמן ההגדרה ולהבטיח שיש לכם את כל הכלים הדרושים לקורס Generative AI for Java. בחרו את גישת הפיתוח המועדפת עליכם:

### אפשרויות הגדרת הסביבה:

#### אפשרות א': GitHub Codespaces (מומלץ)

**התחילו לכתוב קוד תוך 2 דקות - ללא צורך בהתקנה מקומית!**

1. בצעו Fork למאגר זה לחשבון GitHub שלכם  
   > **הערה**: אם ברצונכם לערוך את ההגדרה הבסיסית, עיינו ב-[Dev Container Configuration](../../../.devcontainer/devcontainer.json)
2. לחצו על **Code** → לשונית **Codespaces** → **...** → **New with options...**
3. השתמשו בברירות המחדל – זה יבחר את **Dev container configuration**: **Generative AI Java Development Environment** מכולת פיתוח מותאמת אישית שנוצרה עבור קורס זה
4. לחצו על **Create codespace**
5. המתינו כ-2 דקות עד שהסביבה תהיה מוכנה
6. המשיכו ל-[שלב 2: יצירת אסימון GitHub](../../../02-SetupDevEnvironment)

<img src="./images/codespaces.png" alt="צילום מסך: תפריט Codespaces" width="50%">

<img src="./images/image.png" alt="צילום מסך: New with options" width="50%">

<img src="./images/codespaces-create.png" alt="צילום מסך: אפשרויות יצירת Codespace" width="50%">

> **יתרונות Codespaces**:
> - אין צורך בהתקנה מקומית
> - עובד על כל מכשיר עם דפדפן
> - מוגדר מראש עם כל הכלים והתלויות
> - 60 שעות חינם בחודש לחשבונות אישיים
> - סביבה עקבית לכל הלומדים

#### אפשרות ב': מכולה מקומית

**למפתחים המעדיפים פיתוח מקומי עם Docker**

1. בצעו Fork ו-clone למאגר זה למחשב המקומי שלכם  
   > **הערה**: אם ברצונכם לערוך את ההגדרה הבסיסית, עיינו ב-[Dev Container Configuration](../../../.devcontainer/devcontainer.json)
2. התקינו [Docker Desktop](https://www.docker.com/products/docker-desktop/) ו-[VS Code](https://code.visualstudio.com/)
3. התקינו את [Dev Containers extension](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) ב-VS Code
4. פתחו את תיקיית המאגר ב-VS Code
5. כאשר תתבקשו, לחצו על **Reopen in Container** (או השתמשו ב-`Ctrl+Shift+P` → "Dev Containers: Reopen in Container")
6. המתינו לבניית המכולה ולהפעלתה
7. המשיכו ל-[שלב 2: יצירת אסימון GitHub](../../../02-SetupDevEnvironment)

<img src="./images/devcontainer.png" alt="צילום מסך: הגדרת מכולת פיתוח" width="50%">

<img src="./images/image-3.png" alt="צילום מסך: בניית מכולת פיתוח הושלמה" width="50%">

#### אפשרות ג': שימוש בהתקנה מקומית קיימת

**למפתחים עם סביבות Java קיימות**

דרישות מוקדמות:
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) או IDE מועדף

שלבים:
1. בצעו Clone למאגר זה למחשב המקומי שלכם
2. פתחו את הפרויקט ב-IDE שלכם
3. המשיכו ל-[שלב 2: יצירת אסימון GitHub](../../../02-SetupDevEnvironment)

> **טיפ מקצועי**: אם יש לכם מחשב עם מפרט נמוך אך אתם רוצים להשתמש ב-VS Code מקומי, השתמשו ב-GitHub Codespaces! ניתן לחבר את VS Code המקומי שלכם ל-Codespace בענן כדי ליהנות משני העולמות.

<img src="./images/image-2.png" alt="צילום מסך: יצירת מכולת פיתוח מקומית" width="50%">

## שלב 2: יצירת אסימון גישה אישי ל-GitHub

1. נווטו ל-[הגדרות GitHub](https://github.com/settings/profile) ובחרו **Settings** מתפריט הפרופיל שלכם.
2. בסרגל הצד השמאלי, לחצו על **Developer settings** (בדרך כלל בתחתית).
3. תחת **Personal access tokens**, לחצו על **Fine-grained tokens** (או השתמשו בקישור הישיר [כאן](https://github.com/settings/personal-access-tokens)).
4. לחצו על **Generate new token**.
5. תחת "Token name", תנו שם תיאורי (לדוגמה, `GenAI-Java-Course-Token`).
6. הגדירו תאריך תפוגה (מומלץ: 7 ימים לשמירה על אבטחה).
7. תחת "Resource owner", בחרו את חשבון המשתמש שלכם.
8. תחת "Repository access", בחרו את המאגר(ים) שברצונכם להשתמש בהם עם GitHub Models (או "All repositories" אם נדרש).
9. תחת "Repository permissions", מצאו **Models** והגדירו ל-**Read and write**.
10. לחצו על **Generate token**.
11. **העתיקו ושמרו את האסימון כעת** – לא תוכלו לראות אותו שוב!

> **טיפ אבטחה**: השתמשו בהיקף המינימלי הנדרש ובזמן התפוגה הקצר ביותר האפשרי עבור אסימוני הגישה שלכם.

## שלב 3: בדיקת ההגדרה עם דוגמת GitHub Models

לאחר שסביבת הפיתוח שלכם מוכנה, בואו נבדוק את האינטגרציה של GitHub Models עם יישום הדוגמה שלנו ב-[`02-SetupDevEnvironment/src/github-models`](../../../02-SetupDevEnvironment/src/github-models).

1. פתחו את הטרמינל בסביבת הפיתוח שלכם.
2. נווטו לדוגמת GitHub Models:
   ```bash
   cd 02-SetupDevEnvironment/src/github-models
   ```
3. הגדירו את אסימון GitHub שלכם כמשתנה סביבה:
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. הריצו את היישום:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

אתם אמורים לראות פלט דומה ל:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### הבנת קוד הדוגמה

ראשית, בואו נבין מה אנחנו עומדים להריץ. הדוגמה משתמשת ב-SDK של OpenAI ל-Java כדי להתחבר ל-GitHub Models:

**מה הקוד עושה:**
- **מתחבר** ל-GitHub Models באמצעות אסימון הגישה האישי שלכם
- **שולח** הודעה פשוטה "Say Hello World!" למודל ה-AI
- **מקבל** ומציג את התגובה של ה-AI
- **מאמת** שההגדרה שלכם פועלת כראוי

**תלות מרכזית** (ב-`pom.xml`):
```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

**הקוד הראשי** (`App.java`):
```java
// Connect to GitHub Models using OpenAI Java SDK
OpenAIClient client = OpenAIOkHttpClient.builder()
    .apiKey(pat)
    .baseUrl("https://models.inference.ai.azure.com")
    .build();

// Create chat completion request
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .model(modelId)
    .addSystemMessage("You are a concise assistant.")
    .addUserMessage("Say Hello World!")
    .build();

// Get AI response
ChatCompletion response = client.chat().completions().create(params);
System.out.println("Response: " + response.choices().get(0).message().content().orElse("No response content"));
```

## סיכום

**מזל טוב!** הצלחתם:

- **ליצור אסימון גישה אישי ל-GitHub** עם הרשאות מתאימות לגישה למודלי AI
- **להגדיר את סביבת הפיתוח ל-Java** באמצעות Codespaces, מכולות פיתוח, או התקנה מקומית
- **להתחבר ל-GitHub Models** באמצעות SDK של OpenAI ל-Java לגישה חינמית לפיתוח AI
- **לבדוק את האינטגרציה** עם יישום דוגמה שעובד ומתקשר עם מודלי AI

## השלבים הבאים

[פרק 3: טכניקות ליבה ב-AI גנרטיבי](../03-CoreGenerativeAITechniques/README.md)

## פתרון בעיות

נתקלתם בבעיות? הנה בעיות נפוצות ופתרונות:

- **האסימון לא עובד?** 
  - ודאו שהעתקתם את כל האסימון ללא רווחים מיותרים
  - בדקו שהאסימון מוגדר כראוי כמשתנה סביבה
  - ודאו שלאסימון יש את ההרשאות הנכונות (Models: Read and write)

- **Maven לא נמצא?** 
  - אם אתם משתמשים במכולות פיתוח/Codespaces, Maven אמור להיות מותקן מראש
  - עבור התקנה מקומית, ודאו ש-Java 21+ ו-Maven 3.9+ מותקנים
  - נסו `mvn --version` כדי לוודא את ההתקנה

- **בעיות חיבור?** 
  - בדקו את חיבור האינטרנט שלכם
  - ודאו ש-GitHub נגיש מהרשת שלכם
  - ודאו שאינכם מאחורי חומת אש שחוסמת את נקודת הקצה של GitHub Models

- **המכולה לא מתחילה?** 
  - ודאו ש-Docker Desktop פועל (עבור פיתוח מקומי)
  - נסו לבנות מחדש את המכולה: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container"

- **שגיאות קומפילציה ביישום?**
  - ודאו שאתם בתיקייה הנכונה: `02-SetupDevEnvironment/src/github-models`
  - נסו לנקות ולבנות מחדש: `mvn clean compile`

> **זקוקים לעזרה?**: עדיין יש בעיות? פתחו בעיה במאגר ואנו נעזור לכם.

**כתב ויתור**:  
מסמך זה תורגם באמצעות שירות תרגום מבוסס בינה מלאכותית [Co-op Translator](https://github.com/Azure/co-op-translator). בעוד שאנו שואפים לדיוק, יש להיות מודעים לכך שתרגומים אוטומטיים עשויים להכיל שגיאות או אי דיוקים. המסמך המקורי בשפתו המקורית צריך להיחשב כמקור סמכותי. עבור מידע קריטי, מומלץ להשתמש בתרגום מקצועי על ידי אדם. איננו נושאים באחריות לאי הבנות או לפרשנויות שגויות הנובעות משימוש בתרגום זה.