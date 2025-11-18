<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "ff595bec5b6294cb68860d540eae6302",
  "translation_date": "2025-11-18T16:56:12+00:00",
  "source_file": "README.md",
  "language_code": "ur"
}
-->
# جنریٹو اے آئی برائے ابتدائی - جاوا ایڈیشن
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![جنریٹو اے آئی برائے ابتدائی - جاوا ایڈیشن](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.ur.png)

**وقت کی ضرورت**: یہ ورکشاپ مکمل طور پر آن لائن مکمل کی جا سکتی ہے، بغیر کسی مقامی سیٹ اپ کے۔ ماحول کی ترتیب میں 2 منٹ لگتے ہیں، جبکہ نمونوں کو دریافت کرنے میں 1-3 گھنٹے لگ سکتے ہیں، یہ آپ کی گہرائی پر منحصر ہے۔

> **فوری آغاز**

1. اس ریپوزٹری کو اپنے GitHub اکاؤنٹ پر فورک کریں
2. **Code** پر کلک کریں → **Codespaces** ٹیب → **...** → **New with options...**
3. ڈیفالٹس استعمال کریں – یہ اس کورس کے لیے بنایا گیا ڈیولپمنٹ کنٹینر منتخب کرے گا
4. **Create codespace** پر کلک کریں
5. ماحول کے تیار ہونے کے لیے تقریباً 2 منٹ انتظار کریں
6. سیدھے [پہلے مثال](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) پر جائیں

## کثیر زبان کی حمایت

### GitHub Action کے ذریعے سپورٹ (خودکار اور ہمیشہ تازہ ترین)

[عربی](../ar/README.md) | [بنگالی](../bn/README.md) | [بلغاریائی](../bg/README.md) | [برمی (میانمار)](../my/README.md) | [چینی (سادہ)](../zh/README.md) | [چینی (روایتی، ہانگ کانگ)](../hk/README.md) | [چینی (روایتی، مکاؤ)](../mo/README.md) | [چینی (روایتی، تائیوان)](../tw/README.md) | [کروشین](../hr/README.md) | [چیک](../cs/README.md) | [ڈینش](../da/README.md) | [ڈچ](../nl/README.md) | [ایسٹونین](../et/README.md) | [فنش](../fi/README.md) | [فرانسیسی](../fr/README.md) | [جرمن](../de/README.md) | [یونانی](../el/README.md) | [عبرانی](../he/README.md) | [ہندی](../hi/README.md) | [ہنگریائی](../hu/README.md) | [انڈونیشیائی](../id/README.md) | [اطالوی](../it/README.md) | [جاپانی](../ja/README.md) | [کوریائی](../ko/README.md) | [لتھوانیائی](../lt/README.md) | [ملائی](../ms/README.md) | [مراٹھی](../mr/README.md) | [نیپالی](../ne/README.md) | [نائجیرین پیجن](../pcm/README.md) | [نارویجین](../no/README.md) | [فارسی](../fa/README.md) | [پولش](../pl/README.md) | [پرتگالی (برازیل)](../br/README.md) | [پرتگالی (پرتگال)](../pt/README.md) | [پنجابی (گرمکھی)](../pa/README.md) | [رومانیائی](../ro/README.md) | [روسی](../ru/README.md) | [سربیائی (سیریلیک)](../sr/README.md) | [سلوواک](../sk/README.md) | [سلووینیائی](../sl/README.md) | [ہسپانوی](../es/README.md) | [سواحلی](../sw/README.md) | [سویڈش](../sv/README.md) | [ٹیگالوگ (فلپائنی)](../tl/README.md) | [تمل](../ta/README.md) | [تھائی](../th/README.md) | [ترکی](../tr/README.md) | [یوکرینی](../uk/README.md) | [اردو](./README.md) | [ویتنامی](../vi/README.md)

## کورس کا ڈھانچہ اور سیکھنے کا راستہ

### **باب 1: جنریٹو اے آئی کا تعارف**
- **بنیادی تصورات**: بڑے زبان ماڈلز، ٹوکنز، ایمبیڈنگز، اور اے آئی کی صلاحیتوں کو سمجھنا
- **جاوا اے آئی ایکو سسٹم**: Spring AI اور OpenAI SDKs کا جائزہ
- **ماڈل کانٹیکسٹ پروٹوکول**: MCP اور اے آئی ایجنٹ کمیونیکیشن میں اس کا کردار
- **عملی اطلاقات**: حقیقی دنیا کے منظرنامے جیسے چیٹ بوٹس اور مواد کی تخلیق
- **[→ باب 1 شروع کریں](./01-IntroToGenAI/README.md)**

### **باب 2: ڈیولپمنٹ ماحول کی ترتیب**
- **ملٹی پرووائیڈر کنفیگریشن**: GitHub Models، Azure OpenAI، اور OpenAI Java SDK انٹیگریشنز کی ترتیب
- **Spring Boot + Spring AI**: انٹرپرائز اے آئی ایپلیکیشن ڈیولپمنٹ کے بہترین طریقے
- **GitHub Models**: پروٹوٹائپنگ اور سیکھنے کے لیے مفت اے آئی ماڈل تک رسائی (کریڈٹ کارڈ کی ضرورت نہیں)
- **ڈیولپمنٹ ٹولز**: Docker کنٹینرز، VS Code، اور GitHub Codespaces کی ترتیب
- **[→ باب 2 شروع کریں](./02-SetupDevEnvironment/README.md)**

### **باب 3: بنیادی جنریٹو اے آئی تکنیکیں**
- **پرومپٹ انجینئرنگ**: اے آئی ماڈل کے بہترین جوابات کے لیے تکنیکیں
- **ایمبیڈنگز اور ویکٹر آپریشنز**: سیمینٹک سرچ اور مشابہت میچنگ کو نافذ کریں
- **ریٹریول-اگمینٹڈ جنریشن (RAG)**: اے آئی کو اپنے ڈیٹا ذرائع کے ساتھ جوڑیں
- **فنکشن کالنگ**: کسٹم ٹولز اور پلگ انز کے ساتھ اے آئی کی صلاحیتوں کو بڑھائیں
- **[→ باب 3 شروع کریں](./03-CoreGenerativeAITechniques/README.md)**

### **باب 4: عملی اطلاقات اور پروجیکٹس**
- **پالتو کہانی جنریٹر** (`petstory/`): GitHub Models کے ساتھ تخلیقی مواد کی تخلیق
- **Foundry لوکل ڈیمو** (`foundrylocal/`): OpenAI Java SDK کے ساتھ مقامی اے آئی ماڈل انٹیگریشن
- **MCP کیلکولیٹر سروس** (`calculator/`): Spring AI کے ساتھ بنیادی ماڈل کانٹیکسٹ پروٹوکول کا نفاذ
- **[→ باب 4 شروع کریں](./04-PracticalSamples/README.md)**

### **باب 5: ذمہ دار اے آئی ڈیولپمنٹ**
- **GitHub Models سیفٹی**: بلٹ ان مواد فلٹرنگ اور سیفٹی میکانزمز (ہارڈ بلاکس اور سافٹ ریفیوزلز) کی جانچ کریں
- **ذمہ دار اے آئی ڈیمو**: ایک عملی مثال جو جدید اے آئی سیفٹی سسٹمز کو عملی طور پر دکھاتی ہے
- **بہترین طریقے**: اخلاقی اے آئی ڈیولپمنٹ اور تعیناتی کے لیے ضروری رہنما اصول
- **[→ باب 5 شروع کریں](./05-ResponsibleGenAI/README.md)**

## اضافی وسائل

### Azure / Edge / MCP / ایجنٹس
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### جنریٹو اے آئی سیریز
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)  
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)  
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---

### بنیادی سیکھنا
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)  
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)  
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)  
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)  
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)  
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)  
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### کوپائلٹ سیریز
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)  
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)  
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## مدد حاصل کریں

اگر آپ کسی مسئلے میں پھنس جائیں یا AI ایپس بنانے کے بارے میں سوالات ہوں، تو MCP کے بارے میں گفتگو میں شامل ہوں۔ یہ ایک معاون کمیونٹی ہے جہاں سوالات کا خیر مقدم کیا جاتا ہے اور علم آزادانہ طور پر شیئر کیا جاتا ہے۔

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

اگر آپ کو پروڈکٹ کے بارے میں رائے دینی ہو یا ایپس بنانے کے دوران کوئی خرابی ہو تو یہاں جائیں:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**اعلانِ لاتعلقی**:  
یہ دستاویز AI ترجمہ سروس [Co-op Translator](https://github.com/Azure/co-op-translator) کا استعمال کرتے ہوئے ترجمہ کی گئی ہے۔ ہم درستگی کے لیے کوشش کرتے ہیں، لیکن براہ کرم آگاہ رہیں کہ خودکار ترجمے میں غلطیاں یا خامیاں ہو سکتی ہیں۔ اصل دستاویز کو اس کی اصل زبان میں مستند ذریعہ سمجھا جانا چاہیے۔ اہم معلومات کے لیے، پیشہ ور انسانی ترجمہ کی سفارش کی جاتی ہے۔ اس ترجمے کے استعمال سے پیدا ہونے والی کسی بھی غلط فہمی یا غلط تشریح کے لیے ہم ذمہ دار نہیں ہیں۔
<!-- CO-OP TRANSLATOR DISCLAIMER END -->