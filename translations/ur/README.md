<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0f080f1f2a635610b5f6eff5a58a9590",
  "translation_date": "2025-07-25T07:37:04+00:00",
  "source_file": "README.md",
  "language_code": "ur"
}
-->
# جنریٹو اے آئی برائے ابتدائی - جاوا ایڈیشن  
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)  

![جنریٹو اے آئی برائے ابتدائی - جاوا ایڈیشن](../../translated_images/beg-genai-series.61edc4a6b2cc54284fa2d70eda26dc0ca2669e26e49655b842ea799cd6e16d2a.ur.png)  

> **نوٹ: فوری آغاز**: پورا کورس آن لائن مکمل کیا جا سکتا ہے - کسی مقامی سیٹ اپ کی ضرورت نہیں!  
1. اس ریپوزٹری کو اپنے GitHub اکاؤنٹ میں فورک کریں  
2. **Code** → **Codespaces** ٹیب → **...** → **New with options...** پر کلک کریں  
3. ڈیفالٹس استعمال کریں – یہ اس کورس کے لیے بنائے گئے ڈیولپمنٹ کنٹینر کو منتخب کرے گا  
4. **Create codespace** پر کلک کریں  
5. ماحول کے تیار ہونے کے لیے تقریباً 2 منٹ انتظار کریں  
6. سیدھے [اپنا GitHub Models Token بنائیں](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) پر جائیں  

## کثیر لسانی سپورٹ  

### GitHub Action کے ذریعے سپورٹ (خودکار اور ہمیشہ اپ ڈیٹ شدہ)  

[فرانسیسی](../fr/README.md) | [ہسپانوی](../es/README.md) | [جرمن](../de/README.md) | [روسی](../ru/README.md) | [عربی](../ar/README.md) | [فارسی](../fa/README.md) | [اردو](./README.md) | [چینی (سادہ)](../zh/README.md) | [چینی (روایتی، مکاؤ)](../mo/README.md) | [چینی (روایتی، ہانگ کانگ)](../hk/README.md) | [چینی (روایتی، تائیوان)](../tw/README.md) | [جاپانی](../ja/README.md) | [کوریائی](../ko/README.md) | [ہندی](../hi/README.md) | [بنگالی](../bn/README.md) | [مراٹھی](../mr/README.md) | [نیپالی](../ne/README.md) | [پنجابی (گرمکھی)](../pa/README.md) | [پرتگالی (پرتگال)](../pt/README.md) | [پرتگالی (برازیل)](../br/README.md) | [اطالوی](../it/README.md) | [پولش](../pl/README.md) | [ترکی](../tr/README.md) | [یونانی](../el/README.md) | [تھائی](../th/README.md) | [سویڈش](../sv/README.md) | [ڈینش](../da/README.md) | [نارویجن](../no/README.md) | [فنش](../fi/README.md) | [ڈچ](../nl/README.md) | [عبرانی](../he/README.md) | [ویتنامی](../vi/README.md) | [انڈونیشیائی](../id/README.md) | [ملائی](../ms/README.md) | [ٹیگالوگ (فلپائنی)](../tl/README.md) | [سواحلی](../sw/README.md) | [ہنگری](../hu/README.md) | [چیک](../cs/README.md) | [سلوواک](../sk/README.md) | [رومانیائی](../ro/README.md) | [بلغاریائی](../bg/README.md) | [سربیائی (سیریلیک)](../sr/README.md) | [کروشین](../hr/README.md) | [سلووینیائی](../sl/README.md) | [یوکرینیائی](../uk/README.md) | [برمی (میانمار)](../my/README.md)  

## کورس کا ڈھانچہ اور سیکھنے کا راستہ  

**وقت کی ضرورت**: ماحول کی سیٹ اپ میں 2 منٹ لگتے ہیں، جبکہ نمونے 1-3 گھنٹے لیتے ہیں، یہ آپ کی گہرائی پر منحصر ہے۔ پورا ورکشاپ آن لائن مکمل کیا جا سکتا ہے، مقامی سیٹ اپ کی ضرورت نہیں۔  

### **باب 1: جنریٹو اے آئی کا تعارف**  
- **بنیادی تصورات**: بڑے زبان ماڈلز، ٹوکنز، ایمبیڈنگز، اور اے آئی کی صلاحیتوں کو سمجھنا  
- **جاوا اے آئی ایکو سسٹم**: Spring AI اور OpenAI SDKs کا جائزہ  
- **ماڈل کانٹیکسٹ پروٹوکول**: MCP اور اے آئی ایجنٹ کمیونیکیشن میں اس کا کردار  
- **عملی اطلاقات**: حقیقی دنیا کے منظرنامے جیسے چیٹ بوٹس اور مواد کی تخلیق  
- **[→ باب 1 شروع کریں](./01-IntroToGenAI/README.md)**  

### **باب 2: ڈیولپمنٹ ماحول کی سیٹ اپ**  
- **ملٹی پرووائیڈر کنفیگریشن**: GitHub Models، Azure OpenAI، اور OpenAI Java SDK انٹیگریشنز کی سیٹ اپ  
- **Spring Boot + Spring AI**: انٹرپرائز اے آئی ایپلیکیشن ڈیولپمنٹ کے بہترین طریقے  
- **GitHub Models**: پروٹوٹائپنگ اور سیکھنے کے لیے مفت اے آئی ماڈل تک رسائی (کریڈٹ کارڈ کی ضرورت نہیں)  
- **ڈیولپمنٹ ٹولز**: Docker کنٹینرز، VS Code، اور GitHub Codespaces کی کنفیگریشن  
- **[→ باب 2 شروع کریں](./02-SetupDevEnvironment/README.md)**  

### **باب 3: بنیادی جنریٹو اے آئی تکنیکیں**  
- **پرومپٹ انجینئرنگ**: اے آئی ماڈل کے بہترین جوابات کے لیے تکنیکیں  
- **ایمبیڈنگز اور ویکٹر آپریشنز**: سیمینٹک سرچ اور مماثلت کی تلاش کو نافذ کریں  
- **ریٹریول-اگمینٹڈ جنریشن (RAG)**: اپنے ڈیٹا سورسز کے ساتھ اے آئی کو یکجا کریں  
- **فنکشن کالنگ**: کسٹم ٹولز اور پلگ انز کے ساتھ اے آئی کی صلاحیتوں کو بڑھائیں  
- **[→ باب 3 شروع کریں](./03-CoreGenerativeAITechniques/README.md)**  

### **باب 4: عملی اطلاقات اور پروجیکٹس**  
- **پالتو کہانی جنریٹر** (`petstory/`): GitHub Models کے ساتھ تخلیقی مواد کی تخلیق  
- **فاؤنڈری لوکل ڈیمو** (`foundrylocal/`): OpenAI Java SDK کے ساتھ مقامی اے آئی ماڈل انٹیگریشن  
- **MCP کیلکولیٹر سروس** (`mcp/calculator/`): Spring AI کے ساتھ بنیادی ماڈل کانٹیکسٹ پروٹوکول کا نفاذ  
- **[→ باب 4 شروع کریں](./04-PracticalSamples/README.md)**  

### **باب 5: ذمہ دار اے آئی ڈیولپمنٹ**  
- **GitHub Models سیفٹی**: بلٹ ان مواد فلٹرنگ اور سیفٹی میکانزمز کی جانچ  
- **ذمہ دار اے آئی ڈیمو**: عملی مثال جو دکھاتی ہے کہ اے آئی سیفٹی فلٹرز کیسے کام کرتے ہیں  
- **بہترین طریقے**: اخلاقی اے آئی ڈیولپمنٹ اور تعیناتی کے لیے ضروری رہنما اصول  
- **[→ باب 5 شروع کریں](./05-ResponsibleGenAI/README.md)**  

## اضافی وسائل  

- [ابتدائیوں کے لیے اے آئی ایجنٹس](https://github.com/microsoft/ai-agents-for-beginners)  
- [ابتدائیوں کے لیے جنریٹو اے آئی (.NET استعمال کرتے ہوئے)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)  
- [ابتدائیوں کے لیے جنریٹو اے آئی (جاوا اسکرپٹ استعمال کرتے ہوئے)](https://github.com/microsoft/generative-ai-with-javascript)  
- [ابتدائیوں کے لیے جنریٹو اے آئی](https://github.com/microsoft/generative-ai-for-beginners)  
- [ابتدائیوں کے لیے مشین لرننگ](https://aka.ms/ml-beginners)  
- [ابتدائیوں کے لیے ڈیٹا سائنس](https://aka.ms/datascience-beginners)  
- [ابتدائیوں کے لیے اے آئی](https://aka.ms/ai-beginners)  
- [ابتدائیوں کے لیے سائبر سیکیورٹی](https://github.com/microsoft/Security-101)  
- [ابتدائیوں کے لیے ویب ڈیولپمنٹ](https://aka.ms/webdev-beginners)  
- [ابتدائیوں کے لیے آئی او ٹی](https://aka.ms/iot-beginners)  
- [ابتدائیوں کے لیے ایکس آر ڈیولپمنٹ](https://github.com/microsoft/xr-development-for-beginners)  
- [GitHub Copilot کے ساتھ اے آئی پیئرڈ پروگرامنگ میں مہارت حاصل کریں](https://aka.ms/GitHubCopilotAI)  
- [C#/.NET ڈیولپرز کے لیے GitHub Copilot میں مہارت حاصل کریں](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)  
- [اپنی Copilot ایڈونچر کا انتخاب کریں](https://github.com/microsoft/CopilotAdventures)  
- [Azure AI Services کے ساتھ RAG چیٹ ایپ](https://github.com/Azure-Samples/azure-search-openai-demo-java)  

**ڈسکلیمر**:  
یہ دستاویز AI ترجمہ سروس [Co-op Translator](https://github.com/Azure/co-op-translator) کا استعمال کرتے ہوئے ترجمہ کی گئی ہے۔ ہم درستگی کے لیے کوشش کرتے ہیں، لیکن براہ کرم آگاہ رہیں کہ خودکار ترجمے میں غلطیاں یا غیر درستیاں ہو سکتی ہیں۔ اصل دستاویز کو اس کی اصل زبان میں مستند ذریعہ سمجھا جانا چاہیے۔ اہم معلومات کے لیے، پیشہ ور انسانی ترجمہ کی سفارش کی جاتی ہے۔ ہم اس ترجمے کے استعمال سے پیدا ہونے والی کسی بھی غلط فہمی یا غلط تشریح کے ذمہ دار نہیں ہیں۔