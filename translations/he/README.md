# AI גנרטיבי למתחילים - מהדורת Java
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![AI גנרטיבי למתחילים - מהדורת Java](../../translated_images/he/beg-genai-series.8b48be9951cc574c.webp)

**התחייבות לזמן**: ניתן להשלים את סדנת העבודה כולה אונליין ללא התקנה מקומית. הקמת הסביבה אורכת 2 דקות, וחקר דוגמאות דורש 1-3 שעות בהתאם לעומק החקירה.

> **התחלה מהירה**

1. יצורfork למאגר זה לחשבון GitHub שלך
2. לחץ על **קוד** → לשונית **Codespaces** → **...** → **חדש עם אפשרויות...**
3. השתמש בהגדרות ברירת המחדל – זה יבחר את מיכל הפיתוח שנוצר עבור קורס זה
4. לחץ על **צור codespace**
5. המתן כ~2 דקות עד שהסביבה תהיה מוכנה
6. עבור ישר אל [הדוגמה הראשונה](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **מעדיף לשכפל מקומית?**
>
> מאגר זה מכיל למעלה מ-50 תרגומי שפות שמגדילים משמעותית את גודל ההורדה. לשכפול ללא תרגומים, השתמש ב-sparse checkout:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> זה נותן לך את כל מה שאתה צריך כדי להשלים את הקורס עם הורדה מהירה בהרבה.


## תמיכה בריבוי שפות

### נתמך באמצעות GitHub Action (אוטומטי ותמיד מעודכן)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[ערבית](../ar/README.md) | [בנגלית](../bn/README.md) | [בולגרית](../bg/README.md) | [בורמזית (מיאנמר)](../my/README.md) | [סינית (מפושטת)](../zh-CN/README.md) | [סינית (מסורתית, הונג קונג)](../zh-HK/README.md) | [סינית (מסורתית, מקאו)](../zh-MO/README.md) | [סינית (מסורתית, טאיוואן)](../zh-TW/README.md) | [קרואטית](../hr/README.md) | [צ'כית](../cs/README.md) | [דנית](../da/README.md) | [הולנדית](../nl/README.md) | [אסטונית](../et/README.md) | [פינית](../fi/README.md) | [צרפתית](../fr/README.md) | [גרמנית](../de/README.md) | [יוונית](../el/README.md) | [עברית](./README.md) | [הינדי](../hi/README.md) | [הונגרית](../hu/README.md) | [אינדונזית](../id/README.md) | [איטלקית](../it/README.md) | [יפנית](../ja/README.md) | [קנדה](../kn/README.md) | [קוריאנית](../ko/README.md) | [ליטאית](../lt/README.md) | [מלאית](../ms/README.md) | [מליאלאם](../ml/README.md) | [מראטהי](../mr/README.md) | [נפאלית](../ne/README.md) | [פיג'ין ניגרי](../pcm/README.md) | [נורווגית](../no/README.md) | [פרסית (פרסי)](../fa/README.md) | [פולנית](../pl/README.md) | [פורטוגזית (ברזיל)](../pt-BR/README.md) | [פורטוגזית (פורטוגל)](../pt-PT/README.md) | [פנג'אבי (גורסמוקי)](../pa/README.md) | [רומנית](../ro/README.md) | [רוסית](../ru/README.md) | [סרבית (קירילית)](../sr/README.md) | [סלובקית](../sk/README.md) | [סלובנית](../sl/README.md) | [ספרדית](../es/README.md) | [סווהילי](../sw/README.md) | [שבדית](../sv/README.md) | [טגאלוג (פיליפינית)](../tl/README.md) | [טמילית](../ta/README.md) | [טלוגו](../te/README.md) | [תאית](../th/README.md) | [טורקית](../tr/README.md) | [אוקראינית](../uk/README.md) | [אורדו](../ur/README.md) | [וייטנאמית](../vi/README.md)

## מבנה הקורס ונתיב הלמידה

### **פרק 1: מבוא ל-AI גנרטיבי**
- **מושגים בסיסיים**: הבנת מודלי שפה גדולים, טוקנים, אמבדינג, ויכולות AI
- **אקוסיסטם Java AI**: סקירה של Spring AI ו-SDKs של OpenAI
- **פרוטוקול הקשר מודל**: היכרות עם MCP ותפקידו בתקשורת סוכני AI
- **יישומים מעשיים**: תרחישים בעולם האמיתי כולל צ'טבוטים ויצירת תוכן
- **[→ התחלת פרק 1](./01-IntroToGenAI/README.md)**

### **פרק 2: הקמת סביבת פיתוח**
- **הגדרת ספקים מרובים**: הכנת מודלים של GitHub, Azure OpenAI ו-OpenAI Java SDK אינטגרציות
- **Spring Boot + Spring AI**: שיטות עבודה מומלצות לפיתוח יישומי AI בארגונים
- **מודלים של GitHub**: גישה חינמית למודל AI לפרוטוטייפ ולמידה (ללא דרישת כרטיס אשראי)
- **כלי פיתוח**: מיכלי Docker, VS Code, והגדרות GitHub Codespaces
- **[→ התחלת פרק 2](./02-SetupDevEnvironment/README.md)**

### **פרק 3: טכניקות מרכזיות ב-AI גנרטיבי**
- **הנדסת פרומפטים**: טכניקות לתגובות מיטביות ממודל ה-AI
- **אמבדינג ופעולות וקטוריות**: יישום חיפוש סמנטי והתאמת דמיון
- **הפקה מוגברת בשליפה (RAG)**: שילוב AI עם מקורות הנתונים שלך
- **קריאת פונקציות**: הרחבת יכולות ה-AI עם כלים ותוספים מותאמים אישית
- **[→ התחלת פרק 3](./03-CoreGenerativeAITechniques/README.md)**

### **פרק 4: יישומים ומיזמים מעשיים**
- **מחולל סיפורי חיות מחמד** (`petstory/`): יצירת תוכן יצירתי עם מודלים של GitHub
- **הדגמת Foundry מקומית** (`foundrylocal/`): אינטגרציית מודל AI מקומי עם OpenAI Java SDK
- **שירות מחשבון MCP** (`calculator/`): יישום בסיסי של פרוטוקול הקשר מודל עם Spring AI
- **[→ התחלת פרק 4](./04-PracticalSamples/README.md)**

### **פרק 5: פיתוח AI אחראי**
- **בטיחות מודלים של GitHub**: בדיקה של פילטר תכנים ומנגוני בטיחות מובנים (חסימות נוקשות וסירובים רכים)
- **הדגמת AI אחראי**: דוגמה מעשית המראה כיצד מערכות בטיחות AI מודרניות פועלות
- **שיטות עבודה מומלצות**: הנחיות חיוניות לפיתוח והטמעת AI אתי
- **[→ התחלת פרק 5](./05-ResponsibleGenAI/README.md)**

## משאבים נוספים

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j למתחילים](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js למתחילים](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain למתחילים](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / Edge / MCP / סוכנים
[![AZD למתחילים](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI למתחילים](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP למתחילים](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![סוכני AI למתחילים](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### סדרת AI גנרטיבי
[![AI גנרטיבי למתחילים](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI גנרטיבי (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![AI גנרטיבי (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![AI גנרטיבי (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### למידה בסיסית
[![למידת מכונה למתחילים](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![מדעי הנתונים למתחילים](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI למתחילים](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![סייברסקיוריטי למתחילים](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### סדרת Copilot
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## קבלת עזרה

אם נתקעת או יש לך שאלות לגבי בניית אפליקציות בינה מלאכותית. הצטרף ללומדים אחרים ומפתחים מנוסים בדיונים על MCP. זוהי קהילה תומכת שבה שאלות מתקבלות בברכה והידע משותף בחופשיות.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

אם יש לך משוב על מוצר או שגיאות במהלך הבנייה ביקר ב:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**הצהרת ויתור**:  
מסמך זה תורגם באמצעות שירות התרגום המבוסס על בינה מלאכותית [Co-op Translator](https://github.com/Azure/co-op-translator). בעוד שאנו פועלים לשמירה על דיוק, יש לקחת בחשבון כי תרגומים אוטומטיים עלולים להכיל שגיאות או אי-דיוקים. על המסמך המקורי בשפת המקור להיחשב כמקור המוסמך והמהימן. למידע קריטי מומלץ לפנות לתרגום מקצועי על ידי מתרגם אנושי. אנו לא נושאים באחריות לכל אי-הבנה או פרשנות שגויה הנובעת משימוש בתרגום זה.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->