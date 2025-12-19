<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b1a467efb7f8e13a19f961a587226f71",
  "translation_date": "2025-12-18T09:37:57+00:00",
  "source_file": "README.md",
  "language_code": "ur"
}
-->
# ابتدائیوں کے لیے جنریٹو AI - جاوا ایڈیشن
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.ur.png)

**وقت کی پابندی**: پورا ورکشاپ آن لائن مکمل کیا جا سکتا ہے بغیر لوکل سیٹ اپ کے۔ ماحول کی ترتیب میں 2 منٹ لگتے ہیں، اور نمونوں کی تلاش میں 1-3 گھنٹے لگ سکتے ہیں، تلاش کی گہرائی پر منحصر ہے۔

> **جلدی شروع کریں**

1. اس ریپوزیٹری کو اپنے GitHub اکاؤنٹ میں فورک کریں
2. کلک کریں **Code** → **Codespaces** ٹیب → **...** → **New with options...**
3. ڈیفالٹس استعمال کریں – یہ اس کورس کے لیے بنائے گئے ڈیولپمنٹ کنٹینر کو منتخب کرے گا
4. کلک کریں **Create codespace**
5. تقریباً 2 منٹ انتظار کریں جب تک ماحول تیار نہ ہو جائے
6. سیدھے [پہلے مثال](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) پر جائیں

> **لوکل کلون کرنا پسند ہے؟**
>
> اس ریپوزیٹری میں 50+ زبانوں کے تراجم شامل ہیں جو ڈاؤن لوڈ سائز کو نمایاں طور پر بڑھاتے ہیں۔ بغیر تراجم کے کلون کرنے کے لیے sparse checkout استعمال کریں:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> یہ آپ کو کورس مکمل کرنے کے لیے ہر چیز فراہم کرتا ہے اور ڈاؤن لوڈ بہت تیز ہو جاتا ہے۔

## کثیراللسانی معاونت

### GitHub ایکشن کے ذریعے معاونت (خودکار اور ہمیشہ تازہ ترین)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[عربی](../ar/README.md) | [بنگالی](../bn/README.md) | [بلغاریائی](../bg/README.md) | [برمی (میانمار)](../my/README.md) | [چینی (سادہ)](../zh/README.md) | [چینی (روایتی، ہانگ کانگ)](../hk/README.md) | [چینی (روایتی، مکاو)](../mo/README.md) | [چینی (روایتی، تائیوان)](../tw/README.md) | [کروشین](../hr/README.md) | [چیک](../cs/README.md) | [ڈینش](../da/README.md) | [ڈچ](../nl/README.md) | [ایسٹونین](../et/README.md) | [فنش](../fi/README.md) | [فرانسیسی](../fr/README.md) | [جرمن](../de/README.md) | [یونانی](../el/README.md) | [عبرانی](../he/README.md) | [ہندی](../hi/README.md) | [ہنگریائی](../hu/README.md) | [انڈونیشیائی](../id/README.md) | [اطالوی](../it/README.md) | [جاپانی](../ja/README.md) | [کنڑ](../kn/README.md) | [کوریائی](../ko/README.md) | [لتھوانین](../lt/README.md) | [ملائی](../ms/README.md) | [ملایالم](../ml/README.md) | [مراٹھی](../mr/README.md) | [نیپالی](../ne/README.md) | [نائجیریائی پیجین](../pcm/README.md) | [ناروے](../no/README.md) | [فارسی (فارس)](../fa/README.md) | [پولش](../pl/README.md) | [پرتگالی (برازیل)](../br/README.md) | [پرتگالی (پرتگال)](../pt/README.md) | [پنجابی (گرمکھی)](../pa/README.md) | [رومانیائی](../ro/README.md) | [روسی](../ru/README.md) | [سربیائی (سریلیک)](../sr/README.md) | [سلوواک](../sk/README.md) | [سلووینیائی](../sl/README.md) | [ہسپانوی](../es/README.md) | [سواحلی](../sw/README.md) | [سویڈش](../sv/README.md) | [ٹاگالوگ (فلپائنی)](../tl/README.md) | [تمل](../ta/README.md) | [تیلگو](../te/README.md) | [تھائی](../th/README.md) | [ترکی](../tr/README.md) | [یوکرینیائی](../uk/README.md) | [اردو](./README.md) | [ویتنامی](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## کورس کا ڈھانچہ اور سیکھنے کا راستہ

### **باب 1: جنریٹو AI کا تعارف**
- **بنیادی تصورات**: بڑے زبان ماڈلز، ٹوکنز، ایمبیڈنگز، اور AI صلاحیتوں کی سمجھ
- **جاوا AI ماحولیاتی نظام**: Spring AI اور OpenAI SDKs کا جائزہ
- **ماڈل کانٹیکسٹ پروٹوکول**: MCP کا تعارف اور AI ایجنٹ کمیونیکیشن میں اس کا کردار
- **عملی اطلاقات**: حقیقی دنیا کے منظرنامے بشمول چیٹ بوٹس اور مواد کی تخلیق
- **[→ باب 1 شروع کریں](./01-IntroToGenAI/README.md)**

### **باب 2: ترقیاتی ماحول کی ترتیب**
- **کثیر فراہم کنندہ کنفیگریشن**: GitHub ماڈلز، Azure OpenAI، اور OpenAI جاوا SDK انٹیگریشنز کی ترتیب
- **Spring Boot + Spring AI**: انٹرپرائز AI ایپلیکیشن کی ترقی کے بہترین طریقے
- **GitHub ماڈلز**: پروٹوٹائپنگ اور سیکھنے کے لیے مفت AI ماڈل تک رسائی (کریڈٹ کارڈ کی ضرورت نہیں)
- **ترقیاتی اوزار**: ڈوکر کنٹینرز، VS کوڈ، اور GitHub Codespaces کی ترتیب
- **[→ باب 2 شروع کریں](./02-SetupDevEnvironment/README.md)**

### **باب 3: بنیادی جنریٹو AI تکنیکیں**
- **پرومپٹ انجینئرنگ**: AI ماڈل کے بہترین جوابات کے لیے تکنیکیں
- **ایمبیڈنگز اور ویکٹر آپریشنز**: معنوی تلاش اور مماثلت میچنگ کا نفاذ
- **ریٹریول-آگمینٹڈ جنریشن (RAG)**: AI کو اپنے ڈیٹا ذرائع کے ساتھ جوڑنا
- **فنکشن کالنگ**: اپنی مرضی کے اوزار اور پلگ انز کے ساتھ AI صلاحیتوں کو بڑھانا
- **[→ باب 3 شروع کریں](./03-CoreGenerativeAITechniques/README.md)**

### **باب 4: عملی اطلاقات اور پروجیکٹس**
- **پالتو کہانی جنریٹر** (`petstory/`): GitHub ماڈلز کے ساتھ تخلیقی مواد کی تخلیق
- **Foundry لوکل ڈیمو** (`foundrylocal/`): OpenAI جاوا SDK کے ساتھ لوکل AI ماڈل انٹیگریشن
- **MCP کیلکولیٹر سروس** (`calculator/`): Spring AI کے ساتھ بنیادی ماڈل کانٹیکسٹ پروٹوکول کا نفاذ
- **[→ باب 4 شروع کریں](./04-PracticalSamples/README.md)**

### **باب 5: ذمہ دار AI کی ترقی**
- **GitHub ماڈلز کی حفاظت**: بلٹ ان مواد فلٹرنگ اور حفاظتی میکانزم (ہارڈ بلاکس اور سافٹ انکار) کا تجربہ کریں
- **ذمہ دار AI ڈیمو**: عملی مثال جو دکھاتی ہے کہ جدید AI حفاظتی نظام کیسے کام کرتے ہیں
- **بہترین طریقے**: اخلاقی AI ترقی اور تعیناتی کے لیے ضروری رہنما اصول
- **[→ باب 5 شروع کریں](./05-ResponsibleGenAI/README.md)**

## اضافی وسائل

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### Azure / Edge / MCP / Agents
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### جنریٹو AI سیریز
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### بنیادی تعلیم
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

## مدد حاصل کرنا

اگر آپ پھنس جائیں یا AI ایپس بنانے کے بارے میں کوئی سوال ہو۔ MCP کے بارے میں بحث میں ساتھی سیکھنے والوں اور تجربہ کار ڈویلپرز میں شامل ہوں۔ یہ ایک معاون کمیونٹی ہے جہاں سوالات کا خیرمقدم کیا جاتا ہے اور علم آزادانہ طور پر شیئر کیا جاتا ہے۔

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

اگر آپ کے پاس پروڈکٹ فیڈبیک یا تعمیر کے دوران غلطیاں ہوں تو یہاں جائیں:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**دستخطی دستبرداری**:  
یہ دستاویز AI ترجمہ سروس [Co-op Translator](https://github.com/Azure/co-op-translator) کے ذریعے ترجمہ کی گئی ہے۔ اگرچہ ہم درستگی کے لیے کوشاں ہیں، براہ کرم آگاہ رہیں کہ خودکار ترجمے میں غلطیاں یا عدم درستیاں ہو سکتی ہیں۔ اصل دستاویز اپنی مادری زبان میں معتبر ماخذ سمجھی جانی چاہیے۔ اہم معلومات کے لیے پیشہ ور انسانی ترجمہ کی سفارش کی جاتی ہے۔ اس ترجمے کے استعمال سے پیدا ہونے والی کسی بھی غلط فہمی یا غلط تشریح کی ذمہ داری ہم پر عائد نہیں ہوتی۔
<!-- CO-OP TRANSLATOR DISCLAIMER END -->