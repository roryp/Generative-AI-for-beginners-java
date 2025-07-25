<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T09:47:10+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "he"
}
-->
# אפליקציית Pet Story

>**Note**: פרק זה כולל [**מדריך**](./TUTORIAL.md) שמנחה אותך דרך הדוגמאות.

אפליקציית ווב מבוססת Spring Boot שמייצרת תיאורים וסיפורים מבוססי AI עבור תמונות של חיות מחמד שהועלו, באמצעות GitHub Models.

## תוכן עניינים

- [טכנולוגיות](../../../../04-PracticalSamples/petstory)
- [דרישות מקדימות](../../../../04-PracticalSamples/petstory)
- [הגדרה והתקנה](../../../../04-PracticalSamples/petstory)
- [שימוש](../../../../04-PracticalSamples/petstory)

## טכנולוגיות

- **Backend**: Spring Boot 3.5.3, Java 21  
- **אינטגרציית AI**: OpenAI Java SDK עם GitHub Models  
- **אבטחה**: Spring Security  
- **Frontend**: תבניות Thymeleaf עם עיצוב Bootstrap  
- **כלי בנייה**: Maven  
- **מודלים של AI**: GitHub Models  

## דרישות מקדימות

- Java 21 ומעלה  
- Maven 3.9+  
- GitHub Personal Access Token עם הרשאת `models:read`  

## הגדרה והתקנה

### 1. נווט לתיקיית אפליקציית petstory  
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```  

### 2. הגדר משתנה סביבה  
```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```  

### 3. בנה את האפליקציה  
```bash
mvn clean compile
```  

### 4. הרץ את האפליקציה  
```bash
mvn spring-boot:run
```  

## שימוש

1. **גישה לאפליקציה**: נווט ל-`http://localhost:8080`  
2. **העלאת תמונה**: לחץ על "Choose File" ובחר תמונה של חיית מחמד  
3. **ניתוח תמונה**: לחץ על "Analyze Image" לקבלת תיאור AI  
4. **יצירת סיפור**: לחץ על "Generate Story" ליצירת הסיפור  

**כתב ויתור**:  
מסמך זה תורגם באמצעות שירות תרגום מבוסס בינה מלאכותית [Co-op Translator](https://github.com/Azure/co-op-translator). למרות שאנו שואפים לדיוק, יש לקחת בחשבון שתרגומים אוטומטיים עשויים להכיל שגיאות או אי דיוקים. המסמך המקורי בשפתו המקורית צריך להיחשב כמקור סמכותי. עבור מידע קריטי, מומלץ להשתמש בתרגום מקצועי על ידי אדם. איננו נושאים באחריות לאי הבנות או לפרשנויות שגויות הנובעות משימוש בתרגום זה.