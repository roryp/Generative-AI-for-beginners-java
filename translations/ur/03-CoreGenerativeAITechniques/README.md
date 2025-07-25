<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T08:52:48+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "ur"
}
-->
# بنیادی تخلیقی AI تکنیکیں

>**نوٹ**: اس باب میں ایک تفصیلی [**ٹیوٹوریل**](./TUTORIAL.md) شامل ہے جو آپ کو نمونوں کے ذریعے رہنمائی فراہم کرتا ہے۔

## آپ کیا سیکھیں گے
اس باب میں، ہم 4 بنیادی تخلیقی AI تکنیکوں کو عملی مثالوں کے ذریعے دیکھیں گے:
- LLM مکمل کرنے اور چیٹ کے بہاؤ
- فنکشن کالنگ
- ریٹریول-اگمینٹڈ جنریشن (RAG)
- ذمہ دار AI حفاظتی اقدامات

## مواد کی فہرست

- [آپ کیا سیکھیں گے](../../../03-CoreGenerativeAITechniques)
- [ضروریات](../../../03-CoreGenerativeAITechniques)
- [شروع کریں](../../../03-CoreGenerativeAITechniques)
- [مثالوں کا جائزہ](../../../03-CoreGenerativeAITechniques)
  - [1. LLM مکمل کرنے اور چیٹ کے بہاؤ](../../../03-CoreGenerativeAITechniques)
  - [2. LLMs کے ساتھ فنکشنز اور پلگ انز](../../../03-CoreGenerativeAITechniques)
  - [3. ریٹریول-اگمینٹڈ جنریشن (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. ذمہ دار AI حفاظتی مظاہرہ](../../../03-CoreGenerativeAITechniques)
- [خلاصہ](../../../03-CoreGenerativeAITechniques)
- [اگلے اقدامات](../../../03-CoreGenerativeAITechniques)

## ضروریات

- [باب 2](../../../02-SetupDevEnvironment) سے مکمل سیٹ اپ

## شروع کریں

1. **مثالوں پر جائیں**: 
```bash
cd 03-CoreGenerativeAITechniques/examples/
```
2. **ماحول ترتیب دیں**: 
```bash
export GITHUB_TOKEN=your_token_here
```
3. **مثالوں کو کمپائل اور چلائیں**:
```bash
   # Run completions example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
   
   # Run functions example  
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
   
   # Run RAG example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
   
   # Run responsible AI demo
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```

## مثالوں کا جائزہ

مثالیں `examples/` فولڈر میں درج ذیل ساخت کے ساتھ منظم ہیں:

```
examples/
├── src/main/java/com/example/genai/techniques/
│   ├── completions/
│   │   └── LLMCompletionsApp.java        # Basic completions 
│   ├── functions/
│   │   └── FunctionsApp.java             # Function calling examples
│   ├── rag/
│   │   └── SimpleReaderDemo.java         # Retrieval-Augmented Generation
│   └── responsibleai/
│       └── ResponsibleGithubModels.java  # Responsible AI safety demonstration
├── document.txt                          # Sample document for RAG example
└── pom.xml                               # Maven configuration
```

### 1. LLM مکمل کرنے اور چیٹ کے بہاؤ
**فائل**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

اسٹریمنگ جوابات اور چیٹ ہسٹری مینجمنٹ کے ساتھ گفتگو AI بنانا سیکھیں۔

یہ مثال ظاہر کرتی ہے:
- سادہ ٹیکسٹ مکمل کرنا سسٹم پرامپٹس کے ساتھ
- ہسٹری مینجمنٹ کے ساتھ ملٹی ٹرن گفتگو
- انٹرایکٹو چیٹ سیشنز
- پیرامیٹر کنفیگریشن (ٹمپریچر، زیادہ سے زیادہ ٹوکنز)

### 2. LLMs کے ساتھ فنکشنز اور پلگ انز
**فائل**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

ماڈلز کو کسٹم فنکشنز اور بیرونی APIs تک رسائی دے کر AI کی صلاحیتوں کو بڑھائیں۔

یہ مثال ظاہر کرتی ہے:
- موسم کی فنکشن انٹیگریشن
- کیلکولیٹر فنکشن کی عمل درآمد  
- ایک گفتگو میں متعدد فنکشن کالز
- JSON اسکیموں کے ساتھ فنکشن کی تعریف

### 3. ریٹریول-اگمینٹڈ جنریشن (RAG)
**فائل**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

AI کو اپنے دستاویزات اور ڈیٹا ذرائع کے ساتھ جوڑ کر درست، سیاق و سباق سے آگاہ جوابات حاصل کرنا سیکھیں۔

یہ مثال ظاہر کرتی ہے:
- Azure OpenAI SDK کے ساتھ دستاویز پر مبنی سوال جواب
- GitHub ماڈلز کے ساتھ RAG پیٹرن کی عمل درآمد

**استعمال**: `document.txt` کے مواد کے بارے میں سوالات پوچھیں اور صرف اس سیاق و سباق پر مبنی AI جوابات حاصل کریں۔

### 4. ذمہ دار AI حفاظتی مظاہرہ
**فائل**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

GitHub ماڈلز کی مواد فلٹرنگ صلاحیتوں کی جانچ کرکے AI حفاظتی اقدامات کا پیش نظارہ حاصل کریں۔

یہ مثال ظاہر کرتی ہے:
- ممکنہ طور پر نقصان دہ پرامپٹس کے لیے مواد فلٹرنگ
- ایپلیکیشنز میں حفاظتی ردعمل کی ہینڈلنگ
- بلاک شدہ مواد کی مختلف اقسام (تشدد، نفرت انگیز تقریر، غلط معلومات)
- حفاظتی خلاف ورزیوں کے لیے مناسب ایرر ہینڈلنگ

> **مزید جانیں**: یہ ذمہ دار AI تصورات کا صرف ایک تعارف ہے۔ اخلاقیات، تعصب کی تخفیف، پرائیویسی کے تحفظات، اور ذمہ دار AI فریم ورک کے بارے میں مزید معلومات کے لیے دیکھیں [باب 5: ذمہ دار تخلیقی AI](../05-ResponsibleGenAI/README.md)۔

## خلاصہ

اس باب میں، ہم نے LLM مکمل کرنے اور چیٹ کے بہاؤ کو دریافت کیا، AI کی صلاحیتوں کو بڑھانے کے لیے فنکشن کالنگ کو نافذ کیا، ریٹریول-اگمینٹڈ جنریشن (RAG) سسٹم بنایا، اور ذمہ دار AI حفاظتی اقدامات کا مظاہرہ کیا۔

> **نوٹ**: فراہم کردہ [**ٹیوٹوریل**](./TUTORIAL.md) کے ساتھ مزید گہرائی میں جائیں۔

## اگلے اقدامات

[باب 4: عملی ایپلیکیشنز اور پروجیکٹس](../04-PracticalSamples/README.md)

**ڈسکلیمر**:  
یہ دستاویز AI ترجمہ سروس [Co-op Translator](https://github.com/Azure/co-op-translator) کا استعمال کرتے ہوئے ترجمہ کی گئی ہے۔ ہم درستگی کے لیے کوشش کرتے ہیں، لیکن براہ کرم آگاہ رہیں کہ خودکار ترجمے میں غلطیاں یا غیر درستیاں ہو سکتی ہیں۔ اصل دستاویز کو اس کی اصل زبان میں مستند ذریعہ سمجھا جانا چاہیے۔ اہم معلومات کے لیے، پیشہ ور انسانی ترجمہ کی سفارش کی جاتی ہے۔ ہم اس ترجمے کے استعمال سے پیدا ہونے والی کسی بھی غلط فہمی یا غلط تشریح کے ذمہ دار نہیں ہیں۔