<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "4d04ae8088f6a3c3fcbab18cbdfe4002",
  "translation_date": "2025-10-03T08:03:24+00:00",
  "source_file": "README.md",
  "language_code": "ur"
}
-->
# جنریٹو اے آئی برائے ابتدائی - جاوا ایڈیشن
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![جنریٹو اے آئی برائے ابتدائی - جاوا ایڈیشن](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.ur.png)

**وقت کی ضرورت**: یہ ورکشاپ مکمل طور پر آن لائن مکمل کی جا سکتی ہے، بغیر کسی مقامی سیٹ اپ کے۔ ماحول کی ترتیب میں 2 منٹ لگتے ہیں، جبکہ نمونوں کو دریافت کرنے میں 1-3 گھنٹے لگ سکتے ہیں، یہ آپ کی گہرائی پر منحصر ہے۔

> **فوری آغاز**

1. اس ریپوزٹری کو اپنے GitHub اکاؤنٹ پر فورک کریں
2. **Code** پر کلک کریں → **Codespaces** ٹیب → **...** → **New with options...**
3. ڈیفالٹس استعمال کریں – یہ اس کورس کے لیے تیار کردہ ڈیولپمنٹ کنٹینر کو منتخب کرے گا
4. **Create codespace** پر کلک کریں
5. ماحول تیار ہونے کے لیے تقریباً 2 منٹ انتظار کریں
6. سیدھے [پہلے مثال](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) پر جائیں

## کثیر زبان کی حمایت

### GitHub Action کے ذریعے سپورٹ (خودکار اور ہمیشہ تازہ ترین)

[فرانسیسی](../fr/README.md) | [ہسپانوی](../es/README.md) | [جرمن](../de/README.md) | [روسی](../ru/README.md) | [عربی](../ar/README.md) | [فارسی](../fa/README.md) | [اردو](./README.md) | [چینی (سادہ)](../zh/README.md) | [چینی (روایتی، مکاؤ)](../mo/README.md) | [چینی (روایتی، ہانگ کانگ)](../hk/README.md) | [چینی (روایتی، تائیوان)](../tw/README.md) | [جاپانی](../ja/README.md) | [کوریائی](../ko/README.md) | [ہندی](../hi/README.md) | [بنگالی](../bn/README.md) | [مراٹھی](../mr/README.md) | [نیپالی](../ne/README.md) | [پنجابی (گرمکھی)](../pa/README.md) | [پرتگالی (پرتگال)](../pt/README.md) | [پرتگالی (برازیل)](../br/README.md) | [اطالوی](../it/README.md) | [پولش](../pl/README.md) | [ترکی](../tr/README.md) | [یونانی](../el/README.md) | [تھائی](../th/README.md) | [سویڈش](../sv/README.md) | [ڈینش](../da/README.md) | [نارویجین](../no/README.md) | [فنش](../fi/README.md) | [ڈچ](../nl/README.md) | [عبرانی](../he/README.md) | [ویتنامی](../vi/README.md) | [انڈونیشیائی](../id/README.md) | [ملائی](../ms/README.md) | [ٹیگالوگ (فلپائنی)](../tl/README.md) | [سواحلی](../sw/README.md) | [ہنگری](../hu/README.md) | [چیک](../cs/README.md) | [سلوواک](../sk/README.md) | [رومانیائی](../ro/README.md) | [بلغاریائی](../bg/README.md) | [سربیائی (سیریلک)](../sr/README.md) | [کروشین](../hr/README.md) | [سلووینیائی](../sl/README.md) | [یوکرینیائی](../uk/README.md) | [برمی (میانمار)](../my/README.md)

## کورس کا ڈھانچہ اور سیکھنے کا راستہ

### **باب 1: جنریٹو اے آئی کا تعارف**
- **بنیادی تصورات**: بڑے زبان ماڈلز، ٹوکنز، ایمبیڈنگز، اور اے آئی کی صلاحیتوں کو سمجھنا
- **جاوا اے آئی ایکو سسٹم**: Spring AI اور OpenAI SDKs کا جائزہ
- **ماڈل کانٹیکسٹ پروٹوکول**: MCP اور اے آئی ایجنٹ کمیونیکیشن میں اس کا کردار
- **عملی اطلاقات**: حقیقی دنیا کے منظرنامے جیسے چیٹ بوٹس اور مواد کی تخلیق
- **[→ باب 1 شروع کریں](./01-IntroToGenAI/README.md)**

### **باب 2: ڈیولپمنٹ ماحول کی ترتیب**
- **ملٹی پرووائیڈر کنفیگریشن**: GitHub Models، Azure OpenAI، اور OpenAI Java SDK انٹیگریشنز ترتیب دیں
- **Spring Boot + Spring AI**: انٹرپرائز اے آئی ایپلیکیشن ڈیولپمنٹ کے بہترین طریقے
- **GitHub Models**: پروٹوٹائپنگ اور سیکھنے کے لیے مفت اے آئی ماڈل تک رسائی (کریڈٹ کارڈ کی ضرورت نہیں)
- **ڈیولپمنٹ ٹولز**: Docker کنٹینرز، VS Code، اور GitHub Codespaces کنفیگریشن
- **[→ باب 2 شروع کریں](./02-SetupDevEnvironment/README.md)**

### **باب 3: جنریٹو اے آئی کی بنیادی تکنیکیں**
- **پرومپٹ انجینئرنگ**: اے آئی ماڈل کے بہترین جوابات کے لیے تکنیکیں
- **ایمبیڈنگز اور ویکٹر آپریشنز**: سیمینٹک سرچ اور مماثلت کی مطابقت کو نافذ کریں
- **ریٹریول-اگمینٹڈ جنریشن (RAG)**: اے آئی کو اپنے ڈیٹا ذرائع کے ساتھ جوڑیں
- **فنکشن کالنگ**: کسٹم ٹولز اور پلگ انز کے ساتھ اے آئی کی صلاحیتوں کو بڑھائیں
- **[→ باب 3 شروع کریں](./03-CoreGenerativeAITechniques/README.md)**

### **باب 4: عملی اطلاقات اور پروجیکٹس**
- **پالتو کہانی جنریٹر** (`petstory/`): GitHub Models کے ساتھ تخلیقی مواد کی تخلیق
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK کے ساتھ مقامی اے آئی ماڈل انٹیگریشن
- **MCP Calculator Service** (`calculator/`): Spring AI کے ساتھ بنیادی ماڈل کانٹیکسٹ پروٹوکول کا نفاذ
- **[→ باب 4 شروع کریں](./04-PracticalSamples/README.md)**

### **باب 5: ذمہ دار اے آئی ڈیولپمنٹ**
- **GitHub Models سیفٹی**: بلٹ ان مواد فلٹرنگ اور سیفٹی میکانزمز (ہارڈ بلاکس اور سافٹ ریفیوزلز) کو ٹیسٹ کریں
- **ذمہ دار اے آئی ڈیمو**: عملی مثال دکھاتی ہے کہ جدید اے آئی سیفٹی سسٹمز کیسے کام کرتے ہیں
- **بہترین طریقے**: اخلاقی اے آئی ڈیولپمنٹ اور ڈیپلائمنٹ کے لیے ضروری رہنما اصول
- **[→ باب 5 شروع کریں](./05-ResponsibleGenAI/README.md)**

## اضافی وسائل

- [Edge AI for Beginners](https://github.com/microsoft/edgeai-for-beginners)
- [MCP For Beginners](https://github.com/microsoft/mcp-for-beginners)
- [AI Agents For Beginners](https://github.com/microsoft/ai-agents-for-beginners)
- [Generative AI for Beginners using .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generative AI for Beginners using JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generative AI for Beginners](https://github.com/microsoft/generative-ai-for-beginners)
- [ML for Beginners](https://aka.ms/ml-beginners)
- [Data Science for Beginners](https://aka.ms/datascience-beginners)
- [AI for Beginners](https://aka.ms/ai-beginners)
- [Cybersecurity for Beginners](https://github.com/microsoft/Security-101)
- [Web Dev for Beginners](https://aka.ms/webdev-beginners)
- [IoT for Beginners](https://aka.ms/iot-beginners)
- [XR Development for Beginners](https://github.com/microsoft/xr-development-for-beginners)
- [Mastering GitHub Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI)
- [Mastering GitHub Copilot for C#/.NET Developers](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Choose Your Own Copilot Adventure](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App with Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## مدد حاصل کریں

اگر آپ پھنس جائیں یا اے آئی ایپس بنانے کے بارے میں کوئی سوال ہو تو شامل ہوں:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

اگر آپ کو پروڈکٹ فیڈبیک یا بلڈنگ کے دوران کوئی غلطی ہو تو وزٹ کریں:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**ڈسکلیمر**:  
یہ دستاویز AI ترجمہ سروس [Co-op Translator](https://github.com/Azure/co-op-translator) کا استعمال کرتے ہوئے ترجمہ کی گئی ہے۔ ہم درستگی کے لیے کوشش کرتے ہیں، لیکن براہ کرم آگاہ رہیں کہ خودکار ترجمے میں غلطیاں یا غیر درستیاں ہو سکتی ہیں۔ اصل دستاویز کو اس کی اصل زبان میں مستند ذریعہ سمجھا جانا چاہیے۔ اہم معلومات کے لیے، پیشہ ور انسانی ترجمہ کی سفارش کی جاتی ہے۔ ہم اس ترجمے کے استعمال سے پیدا ہونے والی کسی بھی غلط فہمی یا غلط تشریح کے ذمہ دار نہیں ہیں۔