# AGENTS.md

## סקירת הפרויקט

זהו מאגר חינוכי ללימוד פיתוח AI גנרטיבי עם Java. הוא מספק קורס מעשי מקיף המכסה מודלים של שפה גדולה (LLMs), הנדסת הנחיות, הטמעות, RAG (יצירה מוגברת על ידי אחזור) ופרוטוקול הקשר של מודל (MCP).

**טכנולוגיות מרכזיות:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- מודלים של GitHub, Azure OpenAI ו-SDKs של OpenAI

**ארכיטקטורה:**
- מספר אפליקציות עצמאיות של Spring Boot מאורגנות לפי פרקים
- פרויקטים לדוגמה המדגימים דפוסי AI שונים
- מוכן ל-GitHub Codespaces עם מכולות פיתוח מוגדרות מראש

## פקודות התקנה

### דרישות מוקדמות
- Java 21 או גרסה גבוהה יותר
- Maven 3.x
- אסימון גישה אישי ל-GitHub (עבור מודלים של GitHub)
- אופציונלי: אישורי Azure OpenAI

### הגדרת סביבה

**אפשרות 1: GitHub Codespaces (מומלץ)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**אפשרות 2: מכולת פיתוח מקומית**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**אפשרות 3: התקנה מקומית**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### תצורה

**הגדרת אסימון GitHub:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**הגדרת Azure OpenAI (אופציונלי):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## זרימת עבודה לפיתוח

### מבנה הפרויקט
```
/
├── 01-IntroToGenAI/              # Chapter 1: Introduction
├── 02-SetupDevEnvironment/       # Chapter 2: Environment setup
│   └── examples/                 # Working examples
├── 03-CoreGenerativeAITechniques/ # Chapter 3: Core techniques
├── 04-PracticalSamples/          # Chapter 4: Sample projects
│   ├── calculator/               # MCP service example
│   ├── foundrylocal/            # Local model integration
│   └── petstory/                # Multi-modal app
├── 05-ResponsibleGenAI/         # Chapter 5: Responsible AI
└── translations/                # Multi-language support
```

### הפעלת אפליקציות

**הפעלת אפליקציית Spring Boot:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**בנייה של פרויקט:**
```bash
cd [project-directory]
mvn clean install
```

**הפעלת שרת MCP Calculator:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**הפעלת דוגמאות לקוח:**
```bash
# After starting the server in another terminal
cd 04-PracticalSamples/calculator

# Direct MCP client
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"

# AI-powered client (requires GITHUB_TOKEN)
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"

# Interactive bot
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.Bot"
```

### טעינה מחדש
Spring Boot DevTools כלול בפרויקטים שתומכים בטעינה מחדש:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## הוראות בדיקה

### הפעלת בדיקות

**הפעלת כל הבדיקות בפרויקט:**
```bash
cd [project-directory]
mvn test
```

**הפעלת בדיקות עם פלט מפורט:**
```bash
mvn test -X
```

**הפעלת מחלקת בדיקה ספציפית:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### מבנה הבדיקות
- קבצי בדיקה משתמשים ב-JUnit 5 (Jupiter)
- מחלקות בדיקה ממוקמות ב-`src/test/java/`
- דוגמאות לקוח בפרויקט המחשבון נמצאות ב-`src/test/java/com/microsoft/mcp/sample/client/`

### בדיקה ידנית
דוגמאות רבות הן אפליקציות אינטראקטיביות הדורשות בדיקה ידנית:

1. הפעל את האפליקציה עם `mvn spring-boot:run`
2. בדוק נקודות קצה או אינטראקציה עם CLI
3. ודא שההתנהגות הצפויה תואמת את התיעוד ב-README.md של כל פרויקט

### בדיקה עם מודלים של GitHub
- מגבלות של התוכנית החינמית: 15 בקשות לדקה, 150 ביום
- מקסימום 5 בקשות בו-זמנית
- בדוק סינון תוכן עם דוגמאות AI אחראי

## הנחיות לסגנון קוד

### מוסכמות Java
- **גרסת Java:** Java 21 עם תכונות מודרניות
- **סגנון:** עקוב אחר מוסכמות Java סטנדרטיות
- **שמות:**
  - מחלקות: PascalCase
  - שיטות/משתנים: camelCase
  - קבועים: UPPER_SNAKE_CASE
  - שמות חבילות: אותיות קטנות בלבד

### דפוסי Spring Boot
- השתמש ב-`@Service` ללוגיקה עסקית
- השתמש ב-`@RestController` לנקודות קצה של REST
- תצורה דרך `application.yml` או `application.properties`
- משתני סביבה מועדפים על פני ערכים קשיחים
- השתמש ב-`@Tool` עבור שיטות שנחשפות על ידי MCP

### ארגון קבצים
```
src/
├── main/
│   ├── java/
│   │   └── com/microsoft/[component]/
│   │       ├── [Component]Application.java
│   │       ├── config/
│   │       ├── controller/
│   │       ├── service/
│   │       └── exception/
│   └── resources/
│       ├── application.yml
│       └── static/
└── test/
    └── java/
        └── com/microsoft/[component]/
```

### תלות
- מנוהל דרך `pom.xml` של Maven
- Spring AI BOM לניהול גרסאות
- LangChain4j לאינטגרציות AI
- Spring Boot starter parent לתלות של Spring

### הערות קוד
- הוסף JavaDoc ל-APIs ציבוריים
- כלול הערות הסבר עבור אינטראקציות AI מורכבות
- תעד תיאורי כלים של MCP בצורה ברורה

## בנייה ופריסה

### בניית פרויקטים

**בנייה ללא בדיקות:**
```bash
mvn clean install -DskipTests
```

**בנייה עם כל הבדיקות:**
```bash
mvn clean install
```

**אריזת אפליקציה:**
```bash
mvn package
# Creates JAR in target/ directory
```

### תיקיות פלט
- קבצים מקומפלים: `target/classes/`
- קבצי בדיקה: `target/test-classes/`
- קבצי JAR: `target/*.jar`
- ארטיפקטים של Maven: `target/`

### תצורה ספציפית לסביבה

**פיתוח:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**ייצור:**
- השתמש במודלים של Azure AI Foundry במקום מודלים של GitHub
- עדכן את base-url לנקודת הקצה של Azure OpenAI
- נהל סודות דרך Azure Key Vault או משתני סביבה

### שיקולי פריסה
- זהו מאגר חינוכי עם אפליקציות לדוגמה
- לא מיועד לפריסה בייצור כפי שהוא
- הדוגמאות מדגימות דפוסים להתאמה לשימוש בייצור
- עיין ב-README של כל פרויקט להערות פריסה ספציפיות

## הערות נוספות

### מודלים של GitHub לעומת Azure OpenAI
- **מודלים של GitHub:** תוכנית חינמית ללמידה, אין צורך בכרטיס אשראי
- **Azure OpenAI:** מוכן לייצור, דורש מנוי Azure
- הקוד תואם בין שניהם - פשוט שנה את נקודת הקצה ואת מפתח ה-API

### עבודה עם מספר פרויקטים
כל פרויקט לדוגמה הוא עצמאי:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### בעיות נפוצות

**אי התאמה בגרסת Java:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**בעיות בהורדת תלות:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**אסימון GitHub לא נמצא:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**הפורט כבר בשימוש:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### תמיכה בריבוי שפות
- תיעוד זמין ביותר מ-45 שפות דרך תרגום אוטומטי
- תרגומים בתיקיית `translations/`
- תרגום מנוהל על ידי GitHub Actions workflow

### מסלול למידה
1. התחל עם [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. עקוב אחר הפרקים לפי הסדר (01 → 05)
3. השלם דוגמאות מעשיות בכל פרק
4. חקור פרויקטים לדוגמה בפרק 4
5. למד שיטות AI אחראי בפרק 5

### מכולת פיתוח
הקובץ `.devcontainer/devcontainer.json` מגדיר:
- סביבת פיתוח Java 21
- Maven מותקן מראש
- הרחבות Java ל-VS Code
- כלים ל-Spring Boot
- אינטגרציה עם GitHub Copilot
- תמיכה ב-Docker-in-Docker
- Azure CLI

### שיקולי ביצועים
- לתוכנית החינמית של מודלים של GitHub יש מגבלות קצב
- השתמש בגודל אצווה מתאים להטמעות
- שקול שימוש במטמון עבור קריאות API חוזרות
- עקוב אחר שימוש בטוקנים לאופטימיזציה של עלויות

### הערות אבטחה
- לעולם אל תתחייב קבצי `.env` (כבר ב-`.gitignore`)
- השתמש במשתני סביבה עבור מפתחות API
- אסימוני GitHub צריכים לכלול רק הרשאות מינימליות נדרשות
- עקוב אחר הנחיות AI אחראי בפרק 5

---

**כתב ויתור**:  
מסמך זה תורגם באמצעות שירות תרגום מבוסס בינה מלאכותית [Co-op Translator](https://github.com/Azure/co-op-translator). למרות שאנו שואפים לדיוק, יש לקחת בחשבון שתרגומים אוטומטיים עשויים להכיל שגיאות או אי דיוקים. המסמך המקורי בשפתו המקורית צריך להיחשב כמקור הסמכותי. עבור מידע קריטי, מומלץ להשתמש בתרגום מקצועי על ידי אדם. איננו נושאים באחריות לאי הבנות או לפרשנויות שגויות הנובעות משימוש בתרגום זה.