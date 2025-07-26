<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "ff95bb9d60ecd46e1a2215e341062967",
  "translation_date": "2025-07-26T17:26:42+00:00",
  "source_file": "README.md",
  "language_code": "ur"
}
-->
# جنریٹو اے آئی برائے ابتدائی افراد - جاوا ایڈیشن

[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generative AI for Beginners - Java Edition](../../translated_images/beg-genai-series.61edc4a6b2cc54284fa2d70eda26dc0ca2669e26e49655b842ea799cd6e16d2a.ur.png)

**وقت کی ضرورت**: یہ ورکشاپ مکمل طور پر آن لائن مکمل کی جا سکتی ہے، بغیر کسی مقامی سیٹ اپ کے۔ اگر آپ نمونے چلانا چاہتے ہیں تو ماحول کی ترتیب میں 2 منٹ لگتے ہیں، اور نمونوں کو دریافت کرنے میں 1-3 گھنٹے لگ سکتے ہیں، یہ آپ کی گہرائی پر منحصر ہے۔

> **فوری آغاز**

1. اس ریپوزٹری کو اپنے GitHub اکاؤنٹ پر فورک کریں  
2. **Code** پر کلک کریں → **Codespaces** ٹیب → **...** → **New with options...**  
3. ڈیفالٹس استعمال کریں – یہ اس کورس کے لیے بنائے گئے ڈیولپمنٹ کنٹینر کو منتخب کرے گا  
4. **Create codespace** پر کلک کریں  
5. ماحول کے تیار ہونے کے لیے تقریباً 2 منٹ انتظار کریں  
6. سیدھا [اپنا GitHub Models Token بنائیں](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) پر جائیں  

## کثیر لسانی سپورٹ

### GitHub Action کے ذریعے سپورٹ (خودکار اور ہمیشہ اپ ڈیٹ شدہ)

[French](../fr/README.md) | [Spanish](../es/README.md) | [German](../de/README.md) | [Russian](../ru/README.md) | [Arabic](../ar/README.md) | [Persian (Farsi)](../fa/README.md) | [Urdu](./README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Hindi](../hi/README.md) | [Bengali](../bn/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Portuguese (Brazil)](../br/README.md) | [Italian](../it/README.md) | [Polish](../pl/README.md) | [Turkish](../tr/README.md) | [Greek](../el/README.md) | [Thai](../th/README.md) | [Swedish](../sv/README.md) | [Danish](../da/README.md) | [Norwegian](../no/README.md) | [Finnish](../fi/README.md) | [Dutch](../nl/README.md) | [Hebrew](../he/README.md) | [Vietnamese](../vi/README.md) | [Indonesian](../id/README.md) | [Malay](../ms/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Swahili](../sw/README.md) | [Hungarian](../hu/README.md) | [Czech](../cs/README.md) | [Slovak](../sk/README.md) | [Romanian](../ro/README.md) | [Bulgarian](../bg/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Croatian](../hr/README.md) | [Slovenian](../sl/README.md) | [Ukrainian](../uk/README.md) | [Burmese (Myanmar)](../my/README.md)

## کورس کا ڈھانچہ اور سیکھنے کا راستہ

### **باب 1: جنریٹو اے آئی کا تعارف**
- **بنیادی تصورات**: بڑے لینگویج ماڈلز، ٹوکنز، ایمبیڈنگز، اور اے آئی کی صلاحیتوں کو سمجھنا  
- **جاوا اے آئی ایکو سسٹم**: Spring AI اور OpenAI SDKs کا جائزہ  
- **ماڈل کانٹیکسٹ پروٹوکول**: MCP اور اے آئی ایجنٹ کمیونیکیشن میں اس کا کردار  
- **عملی اطلاقات**: حقیقی دنیا کے منظرنامے جیسے چیٹ بوٹس اور مواد کی تخلیق  
- **[→ باب 1 شروع کریں](./01-IntroToGenAI/README.md)**  

### **باب 2: ڈیولپمنٹ ماحول کی ترتیب**
- **ملٹی پرووائیڈر کنفیگریشن**: GitHub Models، Azure OpenAI، اور OpenAI Java SDK انٹیگریشنز ترتیب دیں  
- **Spring Boot + Spring AI**: انٹرپرائز اے آئی ایپلیکیشن ڈیولپمنٹ کے بہترین طریقے  
- **GitHub Models**: پروٹوٹائپنگ اور سیکھنے کے لیے مفت اے آئی ماڈل تک رسائی (کریڈٹ کارڈ کی ضرورت نہیں)  
- **ڈیولپمنٹ ٹولز**: Docker کنٹینرز، VS Code، اور GitHub Codespaces کی ترتیب  
- **[→ باب 2 شروع کریں](./02-SetupDevEnvironment/README.md)**  

### **باب 3: بنیادی جنریٹو اے آئی تکنیکیں**
- **پرومپٹ انجینئرنگ**: اے آئی ماڈل کے بہترین جوابات کے لیے تکنیکیں  
- **ایمبیڈنگز اور ویکٹر آپریشنز**: سیمینٹک سرچ اور مماثلت کی تلاش کو نافذ کریں  
- **ریٹریول-اگمینٹڈ جنریشن (RAG)**: اے آئی کو اپنے ڈیٹا ذرائع کے ساتھ جوڑیں  
- **فنکشن کالنگ**: کسٹم ٹولز اور پلگ انز کے ساتھ اے آئی کی صلاحیتوں کو بڑھائیں  
- **[→ باب 3 شروع کریں](./03-CoreGenerativeAITechniques/README.md)**  

### **باب 4: عملی اطلاقات اور پروجیکٹس**
- **پالتو کہانی جنریٹر** (`petstory/`): GitHub Models کے ساتھ تخلیقی مواد کی تخلیق  
- **Foundry لوکل ڈیمو** (`foundrylocal/`): OpenAI Java SDK کے ساتھ مقامی اے آئی ماڈل انٹیگریشن  
- **MCP کیلکولیٹر سروس** (`mcp/calculator/`): Spring AI کے ساتھ بنیادی ماڈل کانٹیکسٹ پروٹوکول کا نفاذ  
- **[→ باب 4 شروع کریں](./04-PracticalSamples/README.md)**  

### **باب 5: ذمہ دار اے آئی ڈیولپمنٹ**
- **GitHub Models سیفٹی**: بلٹ ان مواد فلٹرنگ اور سیفٹی میکانزمز کی جانچ کریں  
- **ذمہ دار اے آئی ڈیمو**: ایک عملی مثال جو دکھاتی ہے کہ اے آئی سیفٹی فلٹرز کیسے کام کرتے ہیں  
- **بہترین طریقے**: اخلاقی اے آئی ڈیولپمنٹ اور تعیناتی کے لیے ضروری رہنما اصول  
- **[→ باب 5 شروع کریں](./05-ResponsibleGenAI/README.md)**  

## اضافی وسائل

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

**ڈسکلیمر**:  
یہ دستاویز AI ترجمہ سروس [Co-op Translator](https://github.com/Azure/co-op-translator) کا استعمال کرتے ہوئے ترجمہ کی گئی ہے۔ ہم درستگی کے لیے کوشش کرتے ہیں، لیکن براہ کرم آگاہ رہیں کہ خودکار ترجمے میں غلطیاں یا غیر درستیاں ہو سکتی ہیں۔ اصل دستاویز کو اس کی اصل زبان میں مستند ذریعہ سمجھا جانا چاہیے۔ اہم معلومات کے لیے، پیشہ ور انسانی ترجمہ کی سفارش کی جاتی ہے۔ ہم اس ترجمے کے استعمال سے پیدا ہونے والی کسی بھی غلط فہمی یا غلط تشریح کے ذمہ دار نہیں ہیں۔