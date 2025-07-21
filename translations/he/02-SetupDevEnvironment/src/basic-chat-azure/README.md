<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2289320a74aeca1eb844cd7d3a7a9e12",
  "translation_date": "2025-07-21T19:40:53+00:00",
  "source_file": "02-SetupDevEnvironment/src/basic-chat-azure/README.md",
  "language_code": "he"
}
-->
# צ'אט בסיסי עם Azure OpenAI - דוגמה מקצה לקצה

דוגמה זו מדגימה כיצד ליצור אפליקציית Spring Boot פשוטה שמתחברת ל-Azure OpenAI ובודקת את ההגדרות שלך.

## תוכן עניינים

- [דרישות מקדימות](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [התחלה מהירה](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [אפשרויות קונפיגורציה](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [אפשרות 1: משתני סביבה (קובץ .env) - מומלץ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [אפשרות 2: סודות ב-GitHub Codespace](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [הרצת האפליקציה](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [שימוש ב-Maven](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [שימוש ב-VS Code](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [פלט צפוי](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [הפניה לקונפיגורציה](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [משתני סביבה](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [קונפיגורציית Spring](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [פתרון בעיות](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [בעיות נפוצות](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [מצב ניפוי שגיאות](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [השלבים הבאים](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [משאבים](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)

## דרישות מקדימות

לפני הרצת הדוגמה, ודא שיש לך:

- השלמת את [מדריך ההגדרה של Azure OpenAI](../../getting-started-azure-openai.md)  
- פרסת משאב Azure OpenAI (באמצעות פורטל Azure AI Foundry)  
- פרסת מודל gpt-4o-mini (או חלופה אחרת)  
- מפתח API וכתובת URL של נקודת קצה מ-Azure  

## התחלה מהירה

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/src/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## אפשרויות קונפיגורציה

### אפשרות 1: משתני סביבה (קובץ .env) - מומלץ

**שלב 1: צור את קובץ הקונפיגורציה שלך**  
```bash
cp .env.example .env
```

**שלב 2: הוסף את פרטי Azure OpenAI שלך**  
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **הערת אבטחה**:  
> - לעולם אל תעלה את קובץ ה-`.env` למערכת בקרת גרסאות  
> - קובץ ה-`.env` כבר נמצא ב-`.gitignore`  
> - שמור על מפתחות ה-API שלך מאובטחים ותחליף אותם באופן קבוע  

### אפשרות 2: סודות ב-GitHub Codespace

עבור GitHub Codespaces, הגדר את הסודות הבאים במאגר שלך:  
- `AZURE_AI_KEY` - מפתח ה-API של Azure OpenAI  
- `AZURE_AI_ENDPOINT` - כתובת URL של נקודת הקצה של Azure OpenAI  

האפליקציה מזהה ומשתמשת בסודות אלו באופן אוטומטי.

### חלופה: משתני סביבה ישירים

<details>
<summary>לחץ כדי לראות פקודות לפי פלטפורמה</summary>

**Linux/macOS (bash/zsh):**  
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Command Prompt):**  
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**  
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## הרצת האפליקציה

### שימוש ב-Maven

```bash
mvn spring-boot:run
```

### שימוש ב-VS Code

1. פתח את הפרויקט ב-VS Code  
2. לחץ על `F5` או השתמש בלשונית "Run and Debug"  
3. בחר את הקונפיגורציה "Spring Boot-BasicChatApplication"  

> **הערה**: הקונפיגורציה של VS Code טוענת אוטומטית את קובץ ה-`.env` שלך  

### פלט צפוי

```
Starting Basic Chat with Azure OpenAI...
Environment variables loaded successfully
Connecting to Azure OpenAI...
Sending prompt: What is AI in a short sentence? Max 100 words.

AI Response:
================
AI, or Artificial Intelligence, is the simulation of human intelligence in machines programmed to think and learn like humans.
================

Success! Azure OpenAI connection is working correctly.
```

## הפניה לקונפיגורציה

### משתני סביבה

| משתנה | תיאור | חובה | דוגמה |
|-------|-------|------|-------|
| `AZURE_AI_KEY` | מפתח ה-API של Azure OpenAI | כן | `abc123...` |
| `AZURE_AI_ENDPOINT` | כתובת URL של נקודת הקצה של Azure OpenAI | כן | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | שם פריסת המודל | לא | `gpt-4o-mini` (ברירת מחדל) |

### קונפיגורציית Spring

קובץ `application.yml` מגדיר:  
- **מפתח API**: `${AZURE_AI_KEY}` - מתוך משתנה סביבה  
- **נקודת קצה**: `${AZURE_AI_ENDPOINT}` - מתוך משתנה סביבה  
- **מודל**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - מתוך משתנה סביבה עם ערך ברירת מחדל  
- **טמפרטורה**: `0.7` - שולטת ביצירתיות (0.0 = דטרמיניסטי, 1.0 = יצירתי)  
- **מקסימום טוקנים**: `500` - אורך תגובה מקסימלי  

## פתרון בעיות

### בעיות נפוצות

<details>
<summary><strong>שגיאה: "The API key is not valid"</strong></summary>

- בדוק שה-`AZURE_AI_KEY` שלך מוגדר נכון בקובץ ה-`.env`  
- ודא שמפתח ה-API הועתק בדיוק כפי שהוא מפורטל Azure AI Foundry  
- ודא שאין רווחים או גרשיים מיותרים סביב המפתח  
</details>

<details>
<summary><strong>שגיאה: "The endpoint is not valid"</strong></summary>

- ודא ש-`AZURE_AI_ENDPOINT` שלך כולל את כתובת ה-URL המלאה (לדוגמה, `https://your-hub-name.openai.azure.com/`)  
- בדוק עקביות של קו נטוי בסוף הכתובת  
- ודא שנקודת הקצה תואמת לאזור הפריסה של Azure שלך  
</details>

<details>
<summary><strong>שגיאה: "The deployment was not found"</strong></summary>

- ודא ששם פריסת המודל שלך תואם בדיוק למה שפורסם ב-Azure  
- בדוק שהמודל פורס בהצלחה והוא פעיל  
- נסה להשתמש בשם פריסת ברירת המחדל: `gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code: משתני סביבה לא נטענים</strong></summary>

- ודא שקובץ ה-`.env` שלך נמצא בתיקיית השורש של הפרויקט (באותו מיקום כמו `pom.xml`)  
- נסה להריץ `mvn spring-boot:run` בטרמינל המשולב של VS Code  
- בדוק שההרחבה של Java ב-VS Code מותקנת כראוי  
- ודא שהקונפיגורציה של ההפעלה כוללת `"envFile": "${workspaceFolder}/.env"`  
</details>

### מצב ניפוי שגיאות

כדי להפעיל לוגים מפורטים, בטל את ההערה על השורות האלו ב-`application.yml`:  

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## השלבים הבאים

**ההגדרה הושלמה!** המשך את מסע הלמידה שלך:  

[פרק 3: טכניקות ליבה ב-AI גנרטיבי](../../../03-CoreGenerativeAITechniques/README.md)

## משאבים

- [תיעוד Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [תיעוד שירות Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)  
- [פורטל Azure AI Foundry](https://ai.azure.com/)  
- [תיעוד Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**כתב ויתור**:  
מסמך זה תורגם באמצעות שירות תרגום מבוסס בינה מלאכותית [Co-op Translator](https://github.com/Azure/co-op-translator). בעוד שאנו שואפים לדיוק, יש להיות מודעים לכך שתרגומים אוטומטיים עשויים להכיל שגיאות או אי דיוקים. המסמך המקורי בשפתו המקורית צריך להיחשב כמקור סמכותי. עבור מידע קריטי, מומלץ להשתמש בתרגום מקצועי על ידי אדם. איננו נושאים באחריות לאי הבנות או לפרשנויות שגויות הנובעות משימוש בתרגום זה.