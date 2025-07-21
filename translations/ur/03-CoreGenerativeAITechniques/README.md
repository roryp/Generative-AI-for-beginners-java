<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T17:39:04+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "ur"
}
-->
# بنیادی جنریٹو AI تکنیکیں

>**نوٹ**: اس باب میں ایک تفصیلی [**ٹیوٹوریل**](./TUTORIAL.md) شامل ہے جو آپ کو مکمل شدہ نمونوں کو چلانے کے طریقے سے رہنمائی فراہم کرتا ہے۔

## آپ کیا سیکھیں گے
اس باب میں، ہم عملی مثالوں کے ذریعے 4 بنیادی جنریٹو AI تکنیکوں کا جائزہ لیں گے:
- LLM کمپلیشنز اور چیٹ فلو
- فنکشن کالنگ
- ریٹریول-آگمینٹڈ جنریشن (RAG)
- ذمہ دار AI کے حفاظتی اقدامات

## فہرست مضامین

- [آپ کیا سیکھیں گے](../../../03-CoreGenerativeAITechniques)
- [پیشگی شرائط](../../../03-CoreGenerativeAITechniques)
- [شروع کریں](../../../03-CoreGenerativeAITechniques)
- [مثالوں کا جائزہ](../../../03-CoreGenerativeAITechniques)
  - [1. LLM کمپلیشنز اور چیٹ فلو](../../../03-CoreGenerativeAITechniques)
  - [2. LLMs کے ساتھ فنکشنز اور پلگ اِنز](../../../03-CoreGenerativeAITechniques)
  - [3. ریٹریول-آگمینٹڈ جنریشن (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. ذمہ دار AI حفاظتی مظاہرہ](../../../03-CoreGenerativeAITechniques)
- [خلاصہ](../../../03-CoreGenerativeAITechniques)
- [اگلے اقدامات](../../../03-CoreGenerativeAITechniques)

## پیشگی شرائط

- [باب 2](../../../02-SetupDevEnvironment) سے سیٹ اپ مکمل کریں۔

## شروع کریں

1. **مثالوں پر جائیں**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **ماحول سیٹ کریں**:  
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

مثالیں `examples/` فولڈر میں درج ذیل ساخت کے ساتھ ترتیب دی گئی ہیں:

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

### 1. LLM کمپلیشنز اور چیٹ فلو
**فائل**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

اسٹریم شدہ جوابات اور چیٹ ہسٹری مینجمنٹ کے ساتھ گفتگو پر مبنی AI بنانا سیکھیں۔

یہ مثال درج ذیل چیزوں کا مظاہرہ کرتی ہے:
- سسٹم پرامپٹس کے ساتھ سادہ ٹیکسٹ کمپلیشن
- ہسٹری مینجمنٹ کے ساتھ ملٹی ٹرن گفتگو
- انٹرایکٹو چیٹ سیشنز
- پیرامیٹر کنفیگریشن (ٹمپریچر، زیادہ سے زیادہ ٹوکنز)

### 2. LLMs کے ساتھ فنکشنز اور پلگ اِنز
**فائل**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

ماڈلز کو کسٹم فنکشنز اور ایکسٹرنل APIs تک رسائی دے کر AI کی صلاحیتوں کو بڑھائیں۔

یہ مثال درج ذیل چیزوں کا مظاہرہ کرتی ہے:
- موسم کی معلومات کے لیے فنکشن انٹیگریشن
- کیلکولیٹر فنکشن کی عمل کاری  
- ایک گفتگو میں متعدد فنکشن کالز
- JSON اسکیموں کے ساتھ فنکشن کی تعریف

### 3. ریٹریول-آگمینٹڈ جنریشن (RAG)
**فائل**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

اپنے دستاویزات اور ڈیٹا ذرائع کے ساتھ AI کو جوڑ کر درست اور سیاق و سباق سے آگاہ جوابات حاصل کرنا سیکھیں۔

یہ مثال درج ذیل چیزوں کا مظاہرہ کرتی ہے:
- Azure OpenAI SDK کے ساتھ دستاویز پر مبنی سوال و جواب
- GitHub ماڈلز کے ساتھ RAG پیٹرن کا نفاذ

**استعمال**: `document.txt` میں موجود مواد کے بارے میں سوالات کریں اور صرف اسی سیاق و سباق پر مبنی AI جوابات حاصل کریں۔

### 4. ذمہ دار AI حفاظتی مظاہرہ
**فائل**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

GitHub ماڈلز کی مواد فلٹرنگ صلاحیتوں کو جانچ کر AI حفاظتی اقدامات کا پیش منظر حاصل کریں۔

یہ مثال درج ذیل چیزوں کا مظاہرہ کرتی ہے:
- ممکنہ طور پر نقصان دہ پرامپٹس کے لیے مواد فلٹرنگ
- ایپلیکیشنز میں حفاظتی جوابات کو ہینڈل کرنا
- بلاک شدہ مواد کی مختلف اقسام (تشدد، نفرت انگیز تقریر، غلط معلومات)
- حفاظتی خلاف ورزیوں کے لیے مناسب ایرر ہینڈلنگ

> **مزید جانیں**: یہ ذمہ دار AI کے تصورات کا صرف ایک تعارف ہے۔ اخلاقیات، تعصب کی تخفیف، پرائیویسی کے تحفظات، اور ذمہ دار AI فریم ورکس کے بارے میں مزید معلومات کے لیے [باب 5: ذمہ دار جنریٹو AI](../05-ResponsibleGenAI/README.md) دیکھیں۔

## خلاصہ

اس باب میں، ہم نے LLM کمپلیشنز اور چیٹ فلو کا جائزہ لیا، AI کی صلاحیتوں کو بڑھانے کے لیے فنکشن کالنگ کو نافذ کیا، ریٹریول-آگمینٹڈ جنریشن (RAG) سسٹم بنایا، اور ذمہ دار AI حفاظتی اقدامات کا مظاہرہ کیا۔

> **نوٹ**: فراہم کردہ [**ٹیوٹوریل**](./TUTORIAL.md) کے ساتھ مزید گہرائی میں جائیں۔

## اگلے اقدامات

[باب 4: عملی ایپلیکیشنز اور پروجیکٹس](../04-PracticalSamples/README.md)

**ڈسکلیمر**:  
یہ دستاویز AI ترجمہ سروس [Co-op Translator](https://github.com/Azure/co-op-translator) کا استعمال کرتے ہوئے ترجمہ کی گئی ہے۔ ہم درستگی کے لیے کوشش کرتے ہیں، لیکن براہ کرم آگاہ رہیں کہ خودکار ترجمے میں غلطیاں یا عدم درستگی ہو سکتی ہیں۔ اصل دستاویز، جو اس کی مقامی زبان میں ہے، کو مستند ذریعہ سمجھا جانا چاہیے۔ اہم معلومات کے لیے، پیشہ ور انسانی ترجمہ کی سفارش کی جاتی ہے۔ اس ترجمے کے استعمال سے پیدا ہونے والی کسی بھی غلط فہمی یا غلط تشریح کے لیے ہم ذمہ دار نہیں ہیں۔