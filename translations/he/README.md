<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "4d04ae8088f6a3c3fcbab18cbdfe4002",
  "translation_date": "2025-10-03T08:15:21+00:00",
  "source_file": "README.md",
  "language_code": "he"
}
-->
# בינה מלאכותית יוצרת למתחילים - מהדורת Java
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![בינה מלאכותית יוצרת למתחילים - מהדורת Java](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.he.png)

**זמן נדרש**: ניתן להשלים את הסדנה כולה באופן מקוון ללא צורך בהתקנה מקומית. הגדרת הסביבה אורכת 2 דקות, וההתנסות בדוגמאות דורשת 1-3 שעות, תלוי בעומק החקירה.

> **התחלה מהירה**

1. בצעו Fork למאגר זה לחשבון GitHub שלכם
2. לחצו על **Code** → לשונית **Codespaces** → **...** → **New with options...**
3. השתמשו בהגדרות ברירת המחדל – זה יבחר את מיכל הפיתוח שנוצר עבור הקורס הזה
4. לחצו על **Create codespace**
5. המתינו כ-2 דקות עד שהסביבה תהיה מוכנה
6. עברו ישירות ל[הדוגמה הראשונה](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## תמיכה רב-שפתית

### נתמך באמצעות GitHub Action (אוטומטי ותמיד מעודכן)

[צרפתית](../fr/README.md) | [ספרדית](../es/README.md) | [גרמנית](../de/README.md) | [רוסית](../ru/README.md) | [ערבית](../ar/README.md) | [פרסית (פארסי)](../fa/README.md) | [אורדו](../ur/README.md) | [סינית (פשוטה)](../zh/README.md) | [סינית (מסורתית, מקאו)](../mo/README.md) | [סינית (מסורתית, הונג קונג)](../hk/README.md) | [סינית (מסורתית, טייוואן)](../tw/README.md) | [יפנית](../ja/README.md) | [קוריאנית](../ko/README.md) | [הינדי](../hi/README.md) | [בנגלית](../bn/README.md) | [מראטהי](../mr/README.md) | [נפאלית](../ne/README.md) | [פונג'אבית (גורמוקי)](../pa/README.md) | [פורטוגזית (פורטוגל)](../pt/README.md) | [פורטוגזית (ברזיל)](../br/README.md) | [איטלקית](../it/README.md) | [פולנית](../pl/README.md) | [טורקית](../tr/README.md) | [יוונית](../el/README.md) | [תאית](../th/README.md) | [שוודית](../sv/README.md) | [דנית](../da/README.md) | [נורווגית](../no/README.md) | [פינית](../fi/README.md) | [הולנדית](../nl/README.md) | [עברית](./README.md) | [וייטנאמית](../vi/README.md) | [אינדונזית](../id/README.md) | [מלאית](../ms/README.md) | [טאגאלוג (פיליפינית)](../tl/README.md) | [סוואהילית](../sw/README.md) | [הונגרית](../hu/README.md) | [צ'כית](../cs/README.md) | [סלובקית](../sk/README.md) | [רומנית](../ro/README.md) | [בולגרית](../bg/README.md) | [סרבית (קירילית)](../sr/README.md) | [קרואטית](../hr/README.md) | [סלובנית](../sl/README.md) | [אוקראינית](../uk/README.md) | [בורמזית (מיאנמר)](../my/README.md)

## מבנה הקורס ונתיב הלמידה

### **פרק 1: מבוא לבינה מלאכותית יוצרת**
- **מושגים מרכזיים**: הבנת מודלים שפתיים גדולים, טוקנים, הטמעות ויכולות AI
- **מערכת AI ב-Java**: סקירה של Spring AI ו-SDKs של OpenAI
- **פרוטוקול הקשר של מודל**: מבוא ל-MCP ותפקידו בתקשורת סוכני AI
- **יישומים מעשיים**: תרחישים בעולם האמיתי כולל צ'אטבוטים ויצירת תוכן
- **[→ התחילו את פרק 1](./01-IntroToGenAI/README.md)**

### **פרק 2: הגדרת סביבת פיתוח**
- **תצורה רב-ספקית**: הגדרת מודלים של GitHub, Azure OpenAI ואינטגרציות SDK של OpenAI Java
- **Spring Boot + Spring AI**: שיטות עבודה מומלצות לפיתוח יישומי AI ארגוניים
- **מודלים של GitHub**: גישה חינמית למודלי AI לצורך יצירת אב-טיפוס ולמידה (ללא צורך בכרטיס אשראי)
- **כלי פיתוח**: מיכלי Docker, VS Code ותצורת GitHub Codespaces
- **[→ התחילו את פרק 2](./02-SetupDevEnvironment/README.md)**

### **פרק 3: טכניקות ליבה של בינה מלאכותית יוצרת**
- **הנדסת הנחיות**: טכניקות לתגובות מיטביות ממודלי AI
- **הטמעות ופעולות וקטוריות**: יישום חיפוש סמנטי והתאמת דמיון
- **יצירה מוגברת על ידי אחזור (RAG)**: שילוב AI עם מקורות נתונים משלכם
- **קריאת פונקציות**: הרחבת יכולות AI עם כלים ותוספים מותאמים אישית
- **[→ התחילו את פרק 3](./03-CoreGenerativeAITechniques/README.md)**

### **פרק 4: יישומים מעשיים ופרויקטים**
- **מחולל סיפורי חיות מחמד** (`petstory/`): יצירת תוכן יצירתי עם מודלים של GitHub
- **דמו מקומי של Foundry** (`foundrylocal/`): אינטגרציה של מודל AI מקומי עם OpenAI Java SDK
- **שירות מחשבון MCP** (`calculator/`): יישום בסיסי של פרוטוקול הקשר של מודל עם Spring AI
- **[→ התחילו את פרק 4](./04-PracticalSamples/README.md)**

### **פרק 5: פיתוח AI אחראי**
- **בטיחות מודלים של GitHub**: בדיקת סינון תוכן מובנה ומנגנוני בטיחות (חסימות קשות וסירובים רכים)
- **דמו AI אחראי**: דוגמה מעשית שמראה כיצד מערכות בטיחות AI מודרניות פועלות בפועל
- **שיטות עבודה מומלצות**: הנחיות חיוניות לפיתוח והטמעה אתית של AI
- **[→ התחילו את פרק 5](./05-ResponsibleGenAI/README.md)**

## משאבים נוספים

- [Edge AI למתחילים](https://github.com/microsoft/edgeai-for-beginners)
- [MCP למתחילים](https://github.com/microsoft/mcp-for-beginners)
- [סוכני AI למתחילים](https://github.com/microsoft/ai-agents-for-beginners)
- [בינה מלאכותית יוצרת למתחילים באמצעות .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [בינה מלאכותית יוצרת למתחילים באמצעות JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [בינה מלאכותית יוצרת למתחילים](https://github.com/microsoft/generative-ai-for-beginners)
- [למידת מכונה למתחילים](https://aka.ms/ml-beginners)
- [מדעי הנתונים למתחילים](https://aka.ms/datascience-beginners)
- [AI למתחילים](https://aka.ms/ai-beginners)
- [סייבר למתחילים](https://github.com/microsoft/Security-101)
- [פיתוח אתרים למתחילים](https://aka.ms/webdev-beginners)
- [IoT למתחילים](https://aka.ms/iot-beginners)
- [פיתוח XR למתחילים](https://github.com/microsoft/xr-development-for-beginners)
- [שליטה ב-GitHub Copilot לתכנות זוגי עם AI](https://aka.ms/GitHubCopilotAI)
- [שליטה ב-GitHub Copilot למפתחי C#/.NET](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [בחרו את הרפתקת Copilot שלכם](https://github.com/microsoft/CopilotAdventures)
- [אפליקציית צ'אט RAG עם שירותי Azure AI](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## קבלת עזרה

אם אתם נתקעים או יש לכם שאלות על בניית אפליקציות AI, הצטרפו:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

אם יש לכם משוב על מוצרים או שגיאות במהלך הבנייה, בקרו:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**כתב ויתור**:  
מסמך זה תורגם באמצעות שירות תרגום מבוסס בינה מלאכותית [Co-op Translator](https://github.com/Azure/co-op-translator). למרות שאנו שואפים לדיוק, יש לקחת בחשבון שתרגומים אוטומטיים עשויים להכיל שגיאות או אי דיוקים. המסמך המקורי בשפתו המקורית צריך להיחשב כמקור סמכותי. עבור מידע קריטי, מומלץ להשתמש בתרגום מקצועי על ידי אדם. איננו נושאים באחריות לאי הבנות או לפרשנויות שגויות הנובעות משימוש בתרגום זה.