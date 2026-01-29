# בינה מלאכותית גנרטיבית למתחילים - מהדורת Java
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![בינה מלאכותית גנרטיבית למתחילים - מהדורת Java](../../translated_images/he/beg-genai-series.8b48be9951cc574c.webp)

**משך זמן מחויבות**: כל הסדנה ניתנת להשלמה באופן מקוון ללא צורך בהתקנה מקומית. הגדרת הסביבה אורכת 2 דקות, וחקר הדוגמאות דורש 1-3 שעות בהתאם לעומק החקירה.

> **התחלה מהירה**

1. פצל את המאגר הזה לחשבון ה-GitHub שלך
2. לחץ על **Code** → לשונית **Codespaces** → **...** → **חדש עם אפשרויות...**
3. השתמש כברירות מחדל – זה יבחר במיכל הפיתוח שנוצר לקורס זה
4. לחץ על **Create codespace**
5. המתן כ-2 דקות עד שהסביבה תתכונן
6. קפוץ ישירות ל-[הדוגמה הראשונה](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **מעדיפים לשכפל מקומית?**
>
> מאגר זה מכיל מעל 50 תרגומי שפות שמגבירים משמעותית את נפח ההורדה. לשכפול ללא תרגומים, השתמש ב-sparse checkout:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> זה נותן לך את כל מה שצריך להשלמת הקורס במהירות הורדה גבוהה בהרבה.


## תמיכה בריבוי שפות

### נתמך באמצעות GitHub Action (אוטומטי ותמיד מעודכן)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[ערבית](../ar/README.md) | [בנגלית](../bn/README.md) | [בולגרית](../bg/README.md) | [בורמזית (מיאנמר)](../my/README.md) | [סינית (מפושטת)](../zh-CN/README.md) | [סינית (מסורתית, הונג קונג)](../zh-HK/README.md) | [סינית (מסורתית, מקאו)](../zh-MO/README.md) | [סינית (מסורתית, טייוואן)](../zh-TW/README.md) | [קרואטית](../hr/README.md) | [צ'כית](../cs/README.md) | [דנית](../da/README.md) | [הולנדית](../nl/README.md) | [אסטונית](../et/README.md) | [פינית](../fi/README.md) | [צרפתית](../fr/README.md) | [גרמנית](../de/README.md) | [יוונית](../el/README.md) | [עברית](./README.md) | [הינדי](../hi/README.md) | [הונגרית](../hu/README.md) | [אינדונזית](../id/README.md) | [איטלקית](../it/README.md) | [יפנית](../ja/README.md) | [קאנדה](../kn/README.md) | [קוריאנית](../ko/README.md) | [ליטאית](../lt/README.md) | [מלזית](../ms/README.md) | [מליאלאם](../ml/README.md) | [מרטהית](../mr/README.md) | [נפאלית](../ne/README.md) | [נגיריאנית פידג'ין](../pcm/README.md) | [נורווגית](../no/README.md) | [פרסית (פרסית)](../fa/README.md) | [פולנית](../pl/README.md) | [פורטוגזית (ברזיל)](../pt-BR/README.md) | [פורטוגזית (פורטוגל)](../pt-PT/README.md) | [פונג'בית (גורמוכי)](../pa/README.md) | [רומנית](../ro/README.md) | [רוסית](../ru/README.md) | [סרבית (קירילית)](../sr/README.md) | [סלובקית](../sk/README.md) | [סלובנית](../sl/README.md) | [ספרדית](../es/README.md) | [סוואהילי](../sw/README.md) | [שוודית](../sv/README.md) | [טגאלוג (פיליפינית)](../tl/README.md) | [טמילית](../ta/README.md) | [טלאגו](../te/README.md) | [תאית](../th/README.md) | [טורקית](../tr/README.md) | [אוקראינית](../uk/README.md) | [אורדו](../ur/README.md) | [ויאטנמית](../vi/README.md)

> **מעדיפים לשכפל מקומית?**

> מאגר זה מכיל מעל 50 תרגומי שפות שמגבירים משמעותית את נפח ההורדה. לשכפול ללא תרגומים, השתמש ב-sparse checkout:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> זה נותן לך את כל מה שצריך להשלמת הקורס במהירות הורדה גבוהה בהרבה.
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## מבנה הקורס ונתיב הלמידה

### **פרק 1: מבוא לבינה מלאכותית גנרטיבית**
- **מושגי יסוד**: הבנת מודלים לשוניים גדולים, טוקנים, אמבדינגים ויכולות AI
- **מערכת האקולוגית של Java AI**: סקירת Spring AI ו-SDKs של OpenAI
- **פרוטוקול הקשר מודלים**: מבוא ל-MCP ותפקידו בתקשורת סוכני AI
- **יישומים מעשיים**: תרחישים מהעולם האמיתי כולל צ'טבוטים ויצירת תוכן
- **[→ התחלת פרק 1](./01-IntroToGenAI/README.md)**

### **פרק 2: הגדרת סביבת פיתוח**
- **קונפיגורציית סביבה מרובת ספקים**: הגדרת מודלים של GitHub, Azure OpenAI, ו-OpenAI Java SDK
- **Spring Boot + Spring AI**: שיטות עבודה מומלצות לפיתוח אפליקציות AI ארגוניות
- **מודלים של GitHub**: גישה חינמית למודל AI לפרוטוטייפ ולמידה (ללא צורך בכרטיס אשראי)
- **כלי פיתוח**: מכולות Docker, VS Code, והגדרת GitHub Codespaces
- **[→ התחלת פרק 2](./02-SetupDevEnvironment/README.md)**

### **פרק 3: טכניקות מרכזיות של בינה מלאכותית גנרטיבית**
- **הנדסת פרומפטים**: טכניקות לתגובות מיטביות של מודל AI
- **אמבדינגים ופונקציות וקטור**: יישום חיפוש סמנטי והתאמת דמיון
- **הפקה מורשת בשילוב מידע (RAG)**: שילוב AI עם מקורות הנתונים האישיים שלך
- **קריאת פונקציות**: הרחבת יכולות AI עם כלים ותוספים מותאמים
- **[→ התחלת פרק 3](./03-CoreGenerativeAITechniques/README.md)**

### **פרק 4: יישומים מעשיים ופרויקטים**
- **מחולל סיפור לחיות מחמד** (`petstory/`): יצירת תוכן יצירתי עם מודלים של GitHub
- **הדגמת Foundry מקומית** (`foundrylocal/`): אינטגרציית מודל AI מקומי עם OpenAI Java SDK
- **שירות מחשבון MCP** (`calculator/`): מימוש בסיסי של פרוטוקול הקשר מודלים באמצעות Spring AI
- **[→ התחלת פרק 4](./04-PracticalSamples/README.md)**

### **פרק 5: פיתוח בינה מלאכותית אחראי**
- **בטיחות מודלים של GitHub**: בדוק סינון תוכן מובנה ומנגנוני בטיחות (חסימות קשות וסירובים רכים)
- **הדגמה של בינה מלאכותית אחראית**: דוגמה מעשית המראה כיצד מערכות בטיחות מודרניות פועלות בפועל
- **שיטות עבודה מומלצות**: קווים מנחים חיוניים לפיתוח והטמעה אתית של AI
- **[→ התחלת פרק 5](./05-ResponsibleGenAI/README.md)**

## משאבים נוספים

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j למתחילים](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js למתחילים](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### Azure / Edge / MCP / סוכנים
[![AZD למתחילים](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI למתחילים](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP למתחילים](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![סוכני AI למתחילים](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### סדרת בינה מלאכותית גנרטיבית
[![בינה מלאכותית גנרטיבית למתחילים](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![בינה מלאכותית גנרטיבית (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![בינה מלאכותית גנרטיבית (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![בינה מלאכותית גנרטיבית (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### למידה ליבתית
[![למידת מכונה למתחילים](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![מדעי הנתונים למתחילים](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![בינה מלאכותית למתחילים](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![סייבר למתחילים](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)

[![פיתוח ווב למתחילים](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![אינטרנט של הדברים למתחילים](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![פיתוח XR למתחילים](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### סדרת קופיילוט
[![קופיילוט לתכנות משותף בינה מלאכותית](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![קופיילוט ל-C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![הרפתקת קופיילוט](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## קבלת עזרה

אם נתקעת או יש לך שאלות על בניית אפליקציות בינה מלאכותית. הצטרף ללומדים אחרים ולמפתחים מנוסים בדיונים על MCP. זוהי קהילה תומכת שבה שאלות מתקבלות בברכה והידע משתף בחופשיות.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

אם יש לך משוב על מוצר או שגיאות בזמן הבנייה בקר ב:

[![פורום מפתחי Microsoft Foundry](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**כתב ויתור**:  
מסמך זה תורגם באמצעות שירות תרגום מבוסס בינה מלאכותית [Co-op Translator](https://github.com/Azure/co-op-translator). למרות שאנו שואפים לדיוק, יש לקחת בחשבון כי תרגומים אוטומטיים עלולים להכיל שגיאות או אי־דיוקים. המסמך המקורי בשפת המקור שלו הוא המקור הסמכותי. למידע קריטי מומלץ תרגום מקצועי על ידי אדם. אנו לא אחראים על אי-הבנות או פרשנויות שגויות הנובעות משימוש בתרגום זה.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->