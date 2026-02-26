# דוגמה בסיסית לשיחה עם Azure OpenAI - מא' ועד ת'

דוגמה זו מדגימה כיצד ליצור אפליקציית Spring Boot פשוטה שמתחברת ל-Azure OpenAI ובודקת את ההגדרות שלך.

## תוכן עניינים

- [דרישות מקדימות](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [התחלה מהירה](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [אפשרויות תצורה](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [אפשרות 1: משתני סביבה (קובץ .env) - מומלץ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [אפשרות 2: סודות GitHub Codespace](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [הרצת האפליקציה](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [שימוש ב-Maven](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [שימוש ב-VS Code](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [פלט צפוי](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [הפניה לתצורה](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [משתני סביבה](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [תצורת Spring](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [פתרון בעיות](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [בעיות נפוצות](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [מצב דיבוג](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [השלבים הבאים](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [משאבים](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## דרישות מקדימות

לפני הרצת הדוגמה, ודא שיש לך:

- השלמת [מדריך ההגדרה של Azure OpenAI](../../getting-started-azure-openai.md)  
- משאב Azure OpenAI שהופעל (דרך פורטל Azure AI Foundry)  
- מודל gpt-4o-mini שהופעל (או חלופה)  
- מפתח API וכתובת URL של נקודת קצה מ-Azure  

## התחלה מהירה

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## אפשרויות תצורה

### אפשרות 1: משתני סביבה (קובץ .env) - מומלץ

**שלב 1: צור את קובץ התצורה שלך**
```bash
cp .env.example .env
```

**שלב 2: הוסף את פרטי ההתחברות שלך ל-Azure OpenAI**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **הערת אבטחה**: 
> - לעולם אל תעלה את קובץ `.env` למערכת בקרת גרסאות
> - קובץ `.env` כבר נמצא בקובץ `.gitignore`
> - שמור על אבטחת מפתחות ה-API שלך וחדש אותם באופן קבוע

### אפשרות 2: סודות GitHub Codespace

עבור GitHub Codespaces, הגדר את הסודות הבאים במאגר שלך:
- `AZURE_AI_KEY` - מפתח ה-API שלך ל-Azure OpenAI
- `AZURE_AI_ENDPOINT` - כתובת URL של נקודת הקצה שלך ל-Azure OpenAI

האפליקציה מזהה ומשתמשת בסודות אלו באופן אוטומטי.

### חלופה: משתני סביבה ישירים

<details>
<summary>לחץ כדי לראות פקודות ספציפיות לפלטפורמה</summary>

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
2. לחץ על `F5` או השתמש בלוח "Run and Debug"  
3. בחר את תצורת "Spring Boot-BasicChatApplication"  

> **הערה**: תצורת VS Code טוענת באופן אוטומטי את קובץ `.env` שלך

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

## הפניה לתצורה

### משתני סביבה

| משתנה | תיאור | חובה | דוגמה |
|-------|-------|------|-------|
| `AZURE_AI_KEY` | מפתח ה-API של Azure OpenAI | כן | `abc123...` |
| `AZURE_AI_ENDPOINT` | כתובת URL של נקודת הקצה של Azure OpenAI | כן | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | שם פריסת המודל | לא | `gpt-4o-mini` (ברירת מחדל) |

### תצורת Spring

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

- בדוק שהמפתח `AZURE_AI_KEY` מוגדר נכון בקובץ `.env` שלך  
- ודא שהמפתח מועתק בדיוק מפורטל Azure AI Foundry  
- בדוק שאין רווחים או מרכאות מיותרים סביב המפתח  
</details>

<details>
<summary><strong>שגיאה: "The endpoint is not valid"</strong></summary>

- ודא שכתובת `AZURE_AI_ENDPOINT` כוללת את ה-URL המלא (לדוגמה, `https://your-hub-name.openai.azure.com/`)  
- בדוק עקביות של הסלאש בסוף הכתובת  
- ודא שהנקודת קצה תואמת לאזור הפריסה שלך ב-Azure  
</details>

<details>
<summary><strong>שגיאה: "The deployment was not found"</strong></summary>

- בדוק ששם פריסת המודל תואם בדיוק למה שהופעל ב-Azure  
- ודא שהמודל הופעל בהצלחה והוא פעיל  
- נסה להשתמש בשם פריסה ברירת מחדל: `gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code: משתני סביבה לא נטענים</strong></summary>

- ודא שקובץ `.env` נמצא בתיקיית השורש של הפרויקט (באותו רמה כמו `pom.xml`)  
- נסה להריץ `mvn spring-boot:run` בטרמינל המשולב של VS Code  
- בדוק שהרחבת Java של VS Code מותקנת כראוי  
- ודא שתצורת ההפעלה כוללת `"envFile": "${workspaceFolder}/.env"`  
</details>

### מצב דיבוג

כדי להפעיל לוגים מפורטים, בטל את ההערה על שורות אלו בקובץ `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## השלבים הבאים

**ההגדרה הושלמה!** המשך במסע הלמידה שלך:

[פרק 3: טכניקות ליבה של AI גנרטיבי](../../../03-CoreGenerativeAITechniques/README.md)

## משאבים

- [תיעוד Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [תיעוד שירות Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)  
- [פורטל Azure AI Foundry](https://ai.azure.com/)  
- [תיעוד Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**כתב ויתור**:  
מסמך זה תורגם באמצעות שירות תרגום מבוסס בינה מלאכותית [Co-op Translator](https://github.com/Azure/co-op-translator). למרות שאנו שואפים לדיוק, יש להיות מודעים לכך שתרגומים אוטומטיים עשויים להכיל שגיאות או אי-דיוקים. המסמך המקורי בשפתו המקורית צריך להיחשב כמקור הסמכותי. למידע קריטי, מומלץ להשתמש בתרגום מקצועי על ידי בני אדם. איננו נושאים באחריות לאי-הבנות או לפרשנויות שגויות הנובעות משימוש בתרגום זה.