# ابتدائیوں کے لیے جنریٹو اے آئی - جاوا ایڈیشن
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![ابتدائیوں کے لیے جنریٹو اے آئی - جاوا ایڈیشن](../../translated_images/ur/beg-genai-series.8b48be9951cc574c.webp)

**وقت کی وابستگی**: پورا ورکشاپ آن لائن بغیر لوکل سیٹ اپ کے مکمل کیا جا سکتا ہے۔ ماحول کی تیاری میں 2 منٹ لگتے ہیں، اور نمونوں کی تحقیق میں 1-3 گھنٹے لگ سکتے ہیں جو تحقیق کی گہرائی پر منحصر ہے۔

> **فوری آغاز**

1. اس ذخیرہ کو اپنے GitHub اکاؤنٹ میں فورک کریں
2. **Code** پر کلک کریں → **Codespaces** ٹیب → **...** → **New with options...**
3. ڈیفالٹس کا استعمال کریں – یہ اس کورس کے لیے بنائی گئی ڈیولپمنٹ کنٹینر کا انتخاب کرے گا
4. **Create codespace** پر کلک کریں
5. تقریباً 2 منٹ انتظار کریں تاکہ ماحول تیار ہو جائے
6. سیدھے [پہلے مثال](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) پر پہنچیں

> **کیا آپ لوکل کلون کرنا پسند کریں گے؟**
>
> اس ذخیرہ میں 50+ زبانوں کے تراجم شامل ہیں جو ڈاؤن لوڈ کے سائز کو نمایاں طور پر بڑھاتے ہیں۔ بغیر تراجم کے کلون کرنے کے لیے sparse checkout استعمال کریں:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> یہ آپ کو کورس مکمل کرنے کے لیے ہر چیز فراہم کرتا ہے، اور ڈاؤن لوڈ بہت تیز ہوتا ہے۔

## کثیر زبانی سپورٹ

### GitHub Action کے ذریعے حمایت یافتہ (خودکار اور ہمیشہ تازہ ترین)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[عربی](../ar/README.md) | [بنگالی](../bn/README.md) | [بلغاریائی](../bg/README.md) | [برمی (میانمار)](../my/README.md) | [چینی (سادہ)](../zh-CN/README.md) | [چینی (روایتی، ہانگ کانگ)](../zh-HK/README.md) | [چینی (روایتی، مکاو)](../zh-MO/README.md) | [چینی (روایتی، تائیوان)](../zh-TW/README.md) | [کروشیائی](../hr/README.md) | [چےک](../cs/README.md) | [ڈینش](../da/README.md) | [ڈچ](../nl/README.md) | [ایسٹونین](../et/README.md) | [فنش](../fi/README.md) | [فرانسیسی](../fr/README.md) | [جرمن](../de/README.md) | [یونانی](../el/README.md) | [عبرانی](../he/README.md) | [ہندی](../hi/README.md) | [ہنگیری](../hu/README.md) | [انڈونیشیائی](../id/README.md) | [اطالوی](../it/README.md) | [جاپانی](../ja/README.md) | [کنڑ](../kn/README.md) | [کوریائی](../ko/README.md) | [لتھوانین](../lt/README.md) | [مالے](../ms/README.md) | [مالیالم](../ml/README.md) | [مراٹھی](../mr/README.md) | [نیپالی](../ne/README.md) | [نیجیریائی پڈگن](../pcm/README.md) | [ناروے](../no/README.md) | [فارسی (فارس)](../fa/README.md) | [پولش](../pl/README.md) | [پرتگالی (برازیل)](../pt-BR/README.md) | [پرتگالی (پرتگال)](../pt-PT/README.md) | [پنجابی (گورمکھی)](../pa/README.md) | [رومانیائی](../ro/README.md) | [روسی](../ru/README.md) | [سربیائی (سریلیک)](../sr/README.md) | [سلوواک](../sk/README.md) | [سلووینین](../sl/README.md) | [ہسپانوی](../es/README.md) | [سواحلی](../sw/README.md) | [سویڈش](../sv/README.md) | [ٹگالوگ (فلپائنی)](../tl/README.md) | [تامِل](../ta/README.md) | [تیلوگو](../te/README.md) | [تھائی](../th/README.md) | [ترکی](../tr/README.md) | [یوکرینی](../uk/README.md) | [اردو](./README.md) | [ویت نامی](../vi/README.md)

> **کیا آپ لوکل کلون کرنا پسند کریں گے؟**

> اس ذخیرہ میں 50+ زبانوں کے تراجم شامل ہیں جو ڈاؤن لوڈ کے سائز کو نمایاں طور پر بڑھاتے ہیں۔ بغیر تراجم کے کلون کرنے کے لیے sparse checkout استعمال کریں:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> یہ آپ کو کورس مکمل کرنے کے لیے ہر چیز فراہم کرتا ہے، اور ڈاؤن لوڈ بہت تیز ہوتا ہے۔
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## کورس کی ساخت اور سیکھنے کا راستہ

### **باب 1: جنریٹو اے آئی کا تعارف**
- **اہم تصورات**: بڑے زبان کے ماڈلز، ٹوکنز، ایمبیڈنگز، اور اے آئی کی صلاحیتوں کی سمجھ
- **جاوا اے آئی کا ماحولی نظام**: اسپرنگ اے آئی اور OpenAI SDKs کا جائزہ
- **ماڈل کانٹیکسٹ پروٹوکول**: MCP کا تعارف اور اے آئی ایجنٹ مواصلات میں اس کا کردار
- **عملی اطلاقات**: حقیقی دنیا کے منظرنامے جن میں چیٹ بوٹس اور مواد کی تخلیق شامل ہیں
- **[→ باب 1 شروع کریں](./01-IntroToGenAI/README.md)**

### **باب 2: ترقیاتی ماحول کی تیاری**
- **کثیر فراہم کنندہ ترتیب**: GitHub Models، Azure OpenAI، اور OpenAI Java SDK انضمامات کی تیاری
- **اسپرنگ بوٹ + اسپرنگ اے آئی**: انٹرپرائز اے آئی ایپلیکیشن کی ترقی کے لیے بہترین طریقے
- **GitHub Models**: نمونہ سازی اور سیکھنے کے لیے مفت اے آئی ماڈل تک رسائی (کریڈٹ کارڈ کی ضرورت نہیں)
- **ترقیاتی اوزار**: ڈاکر کنٹینرز، VS Code، اور GitHub Codespaces کی ترتیب
- **[→ باب 2 شروع کریں](./02-SetupDevEnvironment/README.md)**

### **باب 3: بنیادی جنریٹو اے آئی تکنیکیں**
- **پرومپٹ انجینئرنگ**: بہترین اے آئی ماڈل ردعمل کے طریقے
- **ایمبیڈنگز اور ویکٹر آپریشنز**: معنوی تلاش اور مماثلت میچنگ کا نفاذ
- **ریٹریول-آگمینٹڈ جنریشن (RAG)**: اے آئی کو اپنے ڈیٹا ذرائع کے ساتھ ملائیں
- **فنکشن کالنگ**: حسب ضرورت اوزار اور پلگ انز کے ساتھ اے آئی صلاحیتوں میں اضافہ کریں
- **[→ باب 3 شروع کریں](./03-CoreGenerativeAITechniques/README.md)**

### **باب 4: عملی اطلاقات اور پروجیکٹس**
- **پیٹ سٹوری جنریٹر** (`petstory/`): GitHub Models کے ساتھ تخلیقی مواد کی تخلیق
- **فاؤنڈری لوکل ڈیمو** (`foundrylocal/`): OpenAI Java SDK کے ساتھ لوکل اے آئی ماڈل انضمام
- **MCP کیلکولیٹر سروس** (`calculator/`): اسپرنگ اے آئی کے ساتھ بنیادی ماڈل کانٹیکسٹ پروٹوکول کا نفاذ
- **[→ باب 4 شروع کریں](./04-PracticalSamples/README.md)**

### **باب 5: ذمہ دار اے آئی ترقی**
- **GitHub Models کی حفاظت**: بلٹ ان مواد کی فلٹریشن اور حفاظتی میکانزمز کا ٹیسٹ کریں (سخت پابندیاں اور نرم انکار)
- **ذمہ دار اے آئی ڈیمو**: جدید اے آئی حفاظتی نظاموں کے عملی کام کا مظاہرہ
- **بہترین طریقے**: اخلاقی اے آئی ترقی اور تعیناتی کے بنیادی اصول
- **[→ باب 5 شروع کریں](./05-ResponsibleGenAI/README.md)**

## اضافی وسائل

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### لینگ چین
[![ابتدائیوں کے لیے LangChain4j](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![ابتدائیوں کے لیے LangChain.js](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### ایزور / ایج / MCP / ایجنٹس
[![ابتدائیوں کے لیے AZD](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![ابتدائیوں کے لیے ایج اے آئی](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![ابتدائیوں کے لیے MCP](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![ابتدائیوں کے لیے اے آئی ایجنٹس](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### جنریٹو اے آئی سیریز
[![ابتدائیوں کے لیے جنریٹو اے آئی](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![جنریٹو اے آئی (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![جنریٹو اے آئی (جاوا)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![جنریٹو اے آئی (جاوا اسکرپٹ)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### بنیادی تعلیم
[![ابتدائیوں کے لیے مشین لرننگ](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![ابتدائیوں کے لیے ڈیٹا سائنس](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![ابتدائیوں کے لیے اے آئی](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![ابتدائیوں کے لیے سائبر سیکیورٹی](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)

[![ابتدائیوں کے لیے ویب ڈویلپمنٹ](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![ابتدائیوں کے لیے IoT](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![ابتدائیوں کے لیے XR ڈویلپمنٹ](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### کوپائلٹ سیریز
[![AI جوڑی پروگرامنگ کے لیے کوپائلٹ](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![C#/.NET کے لیے کوپائلٹ](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![کوپائلٹ ایڈونچر](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## مدد حاصل کرنا

اگر آپ پھنس جائیں یا AI ایپس بنانے کے بارے میں کوئی سوال ہو تو MCP پر ساتھی سیکھنے والوں اور تجربہ کار ڈویلپرز کے ساتھ بات چیت میں شامل ہوں۔ یہ ایک مددگار کمیونٹی ہے جہاں سوالات کا خیرمقدم کیا جاتا ہے اور علم آزادانہ طور پر شیئر کیا جاتا ہے۔

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

اگر آپ کے پاس پراڈکٹ پر تاثرات یا تعمیر کے دوران غلطیاں ہوں تو یہاں جائیں:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**دستخطی اعلامیہ**:
یہ دستاویز AI ترجمہ سروس [Co-op Translator](https://github.com/Azure/co-op-translator) کے ذریعے ترجمہ کی گئی ہے۔ اگرچہ ہم درستگی کے لیے کوشاں ہیں، براہ کرم آگاہ رہیں کہ خودکار ترجمے میں غلطیاں یا عدم درستیاں ہو سکتی ہیں۔ اصل دستاویز اپنی مادری زبان میں معتبر ماخذ سمجھی جانی چاہیے۔ اہم معلومات کے لیے پیشہ ور انسانی ترجمہ کی سفارش کی جاتی ہے۔ اس ترجمے کے استعمال سے پیدا ہونے والی کسی بھی غلط فہمی یا غلط تعبیر کی ذمہ داری ہم پر عائد نہیں ہوتی۔
<!-- CO-OP TRANSLATOR DISCLAIMER END -->