<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T19:12:38+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "he"
}
-->
# טכניקות ליבה ב-AI גנרטיבי

>**הערה**: פרק זה כולל [**מדריך מפורט**](./TUTORIAL.md) שמנחה אותך כיצד להריץ את הדוגמאות המוכנות.

## מה תלמדו
בפרק זה נסקור 4 טכניקות ליבה ב-AI גנרטיבי דרך דוגמאות מעשיות:
- השלמות LLM וזרימות שיחה
- קריאה לפונקציות
- יצירה מוגברת על ידי שליפה (RAG)
- אמצעי בטיחות ב-AI אחראי

## תוכן עניינים

- [מה תלמדו](../../../03-CoreGenerativeAITechniques)
- [דרישות מוקדמות](../../../03-CoreGenerativeAITechniques)
- [תחילת העבודה](../../../03-CoreGenerativeAITechniques)
- [סקירת דוגמאות](../../../03-CoreGenerativeAITechniques)
  - [1. השלמות LLM וזרימות שיחה](../../../03-CoreGenerativeAITechniques)
  - [2. פונקציות ותוספים עם LLMs](../../../03-CoreGenerativeAITechniques)
  - [3. יצירה מוגברת על ידי שליפה (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. הדגמת בטיחות ב-AI אחראי](../../../03-CoreGenerativeAITechniques)
- [סיכום](../../../03-CoreGenerativeAITechniques)
- [השלבים הבאים](../../../03-CoreGenerativeAITechniques)

## דרישות מוקדמות

- השלמת ההגדרות מ-[פרק 2](../../../02-SetupDevEnvironment)

## תחילת העבודה

1. **נווט לדוגמאות**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **הגדר סביבה**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **הדר והפעל דוגמאות**:  
```bash
   # Run completions example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
   
   # Run functions example  
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
   
   # Run RAG example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
   
   # Run responsible AI demo
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```  

## סקירת דוגמאות

הדוגמאות מאורגנות בתיקיית `examples/` עם המבנה הבא:

```
examples/
├── src/main/java/com/example/genai/techniques/
│   ├── completions/
│   │   └── LLMCompletionsApp.java        # Basic completions 
│   ├── functions/
│   │   └── FunctionsApp.java             # Function calling examples
│   ├── rag/
│   │   └── SimpleReaderDemo.java         # Retrieval-Augmented Generation
│   └── responsibleai/
│       └── ResponsibleGithubModels.java  # Responsible AI safety demonstration
├── document.txt                          # Sample document for RAG example
└── pom.xml                               # Maven configuration
```

### 1. השלמות LLM וזרימות שיחה
**קובץ**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

למדו כיצד לבנות AI שיחתי עם תגובות זורמות וניהול היסטוריית שיחות.

דוגמה זו מדגימה:
- השלמת טקסט פשוטה עם הנחיות מערכת
- שיחות מרובות שלבים עם ניהול היסטוריה
- סשנים אינטראקטיביים של שיחה
- הגדרת פרמטרים (טמפרטורה, מספר מקסימלי של טוקנים)

### 2. פונקציות ותוספים עם LLMs
**קובץ**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

הרחיבו את יכולות ה-AI על ידי מתן גישה למודלים לפונקציות מותאמות אישית ו-APIs חיצוניים.

דוגמה זו מדגימה:
- שילוב פונקציית מזג אוויר
- יישום פונקציית מחשבון  
- קריאות מרובות לפונקציות בשיחה אחת
- הגדרת פונקציות עם סכמות JSON

### 3. יצירה מוגברת על ידי שליפה (RAG)
**קובץ**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

למדו כיצד לשלב AI עם מסמכים ומקורות נתונים משלכם לתגובות מדויקות ומודעות להקשר.

דוגמה זו מדגימה:
- מענה על שאלות מבוססות מסמכים עם Azure OpenAI SDK
- יישום תבנית RAG עם מודלים של GitHub

**שימוש**: שאלו שאלות על התוכן שב-`document.txt` וקבלו תגובות AI המבוססות רק על ההקשר הזה.

### 4. הדגמת בטיחות ב-AI אחראי
**קובץ**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

קבלו הצצה לאופן שבו אמצעי בטיחות ב-AI פועלים על ידי בדיקת יכולות סינון התוכן של מודלים של GitHub.

דוגמה זו מדגימה:
- סינון תוכן עבור הנחיות פוטנציאליות מזיקות
- טיפול בתגובות בטיחות באפליקציות
- קטגוריות שונות של תוכן חסום (אלימות, דברי שנאה, מידע שגוי)
- טיפול נכון בשגיאות עבור הפרות בטיחות

> **למידע נוסף**: זו רק הקדמה למושגים של AI אחראי. למידע נוסף על אתיקה, הפחתת הטיות, שיקולי פרטיות ומסגרות AI אחראי, ראו [פרק 5: AI גנרטיבי אחראי](../05-ResponsibleGenAI/README.md).

## סיכום

בפרק זה חקרנו השלמות LLM וזרימות שיחה, יישמנו קריאה לפונקציות להרחבת יכולות ה-AI, יצרנו מערכת יצירה מוגברת על ידי שליפה (RAG), והדגמנו אמצעי בטיחות ב-AI אחראי.

> **הערה**: העמיקו עם [**המדריך**](./TUTORIAL.md) המצורף.

## השלבים הבאים

[פרק 4: יישומים מעשיים ופרויקטים](../04-PracticalSamples/README.md)

**כתב ויתור**:  
מסמך זה תורגם באמצעות שירות תרגום מבוסס בינה מלאכותית [Co-op Translator](https://github.com/Azure/co-op-translator). למרות שאנו שואפים לדיוק, יש לקחת בחשבון שתרגומים אוטומטיים עשויים להכיל שגיאות או אי דיוקים. המסמך המקורי בשפתו המקורית צריך להיחשב כמקור סמכותי. עבור מידע קריטי, מומלץ להשתמש בתרגום מקצועי על ידי אדם. איננו נושאים באחריות לאי הבנות או לפרשנויות שגויות הנובעות משימוש בתרגום זה.