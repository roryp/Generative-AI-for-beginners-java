<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d064108b2142d32246ccbd8a42e76b4d",
  "translation_date": "2025-07-25T08:53:31+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "ur"
}
-->
# فاؤنڈری لوکل کمانڈ لائن ایپلیکیشن

>**نوٹ**: اس باب میں ایک [**ٹیوٹوریل**](./TUTORIAL.md) شامل ہے جو آپ کو نمونوں کے ذریعے رہنمائی فراہم کرتا ہے۔

ایک سادہ اسپرنگ بوٹ کمانڈ لائن ایپلیکیشن جو دکھاتی ہے کہ OpenAI جاوا SDK کا استعمال کرتے ہوئے فاؤنڈری لوکل سے کیسے جڑا جائے۔

## آپ کیا سیکھیں گے

- OpenAI جاوا SDK کا استعمال کرتے ہوئے اسپرنگ بوٹ ایپلیکیشنز کے ساتھ فاؤنڈری لوکل کو کیسے ضم کریں
- مقامی AI ترقی اور ٹیسٹنگ کے بہترین طریقے

## مواد کی فہرست

- [آپ کیا سیکھیں گے](../../../../04-PracticalSamples/foundrylocal)
- [پیشگی شرائط](../../../../04-PracticalSamples/foundrylocal)
  - [فاؤنڈری لوکل کی تنصیب](../../../../04-PracticalSamples/foundrylocal)
  - [تصدیق](../../../../04-PracticalSamples/foundrylocal)
- [تشکیل](../../../../04-PracticalSamples/foundrylocal)
- [جلدی شروع کریں](../../../../04-PracticalSamples/foundrylocal)
- [ایپلیکیشن کیا کرتی ہے](../../../../04-PracticalSamples/foundrylocal)
- [نمونہ آؤٹ پٹ](../../../../04-PracticalSamples/foundrylocal)
- [معماری](../../../../04-PracticalSamples/foundrylocal)
- [کوڈ کی جھلکیاں](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI جاوا SDK انضمام](../../../../04-PracticalSamples/foundrylocal)
  - [چیٹ کمپلیشن API](../../../../04-PracticalSamples/foundrylocal)
- [مسائل کا حل](../../../../04-PracticalSamples/foundrylocal)

## پیشگی شرائط

> **⚠️ نوٹ**: یہ ایپلیکیشن **فراہم کردہ ڈیویلوپر کنٹینر میں نہیں چلتی** کیونکہ اس کے لیے ضروری ہے کہ فاؤنڈری لوکل میزبان نظام پر انسٹال اور چل رہا ہو۔

### فاؤنڈری لوکل کی تنصیب

اس ایپلیکیشن کو چلانے سے پہلے، آپ کو فاؤنڈری لوکل انسٹال اور شروع کرنا ہوگا۔ ان مراحل پر عمل کریں:

1. **یقینی بنائیں کہ آپ کا نظام ضروریات کو پورا کرتا ہے**:
   - **آپریٹنگ سسٹم**: ونڈوز 10 (x64)، ونڈوز 11 (x64/ARM)، ونڈوز سرور 2025، یا میک او ایس
   - **ہارڈویئر**: 
     - کم از کم: 8GB ریم، 3GB خالی ڈسک اسپیس
     - تجویز کردہ: 16GB ریم، 15GB خالی ڈسک اسپیس
   - **نیٹ ورک**: ابتدائی ماڈل ڈاؤن لوڈ کے لیے انٹرنیٹ کنکشن (آف لائن استعمال کے لیے اختیاری)
   - **ایکسلیریشن (اختیاری)**: NVIDIA GPU (2000 سیریز یا جدید)، AMD GPU (6000 سیریز یا جدید)، Qualcomm Snapdragon X Elite (8GB یا زیادہ میموری)، یا Apple silicon
   - **اجازتیں**: آپ کے آلے پر سافٹ ویئر انسٹال کرنے کے لیے ایڈمنسٹریٹو مراعات

2. **فاؤنڈری لوکل انسٹال کریں**:
   
   **ونڈوز کے لیے:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **میک او ایس کے لیے:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   متبادل طور پر، آپ انسٹالر کو [فاؤنڈری لوکل گٹ ہب ریپوزٹری](https://github.com/microsoft/Foundry-Local) سے ڈاؤن لوڈ کر سکتے ہیں۔

3. **اپنا پہلا ماڈل شروع کریں**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   ماڈل ڈاؤن لوڈ ہوتا ہے (جو آپ کے انٹرنیٹ کی رفتار پر منحصر ہے چند منٹ لے سکتا ہے) اور پھر چلتا ہے۔ فاؤنڈری لوکل خود بخود آپ کے نظام کے لیے بہترین ماڈل ویریئنٹ منتخب کرتا ہے (NVIDIA GPUs کے لیے CUDA، ورنہ CPU ورژن)۔

4. **ماڈل کو ٹیسٹ کریں** اسی ٹرمینل میں ایک سوال پوچھ کر:

   ```bash
   Why is the sky blue?
   ```

   آپ کو Phi ماڈل سے ایک جواب نظر آنا چاہیے جو وضاحت کرے کہ آسمان نیلا کیوں نظر آتا ہے۔

### تصدیق

آپ ان کمانڈز کے ذریعے تصدیق کر سکتے ہیں کہ سب کچھ صحیح طریقے سے کام کر رہا ہے:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

آپ اپنے براؤزر میں `http://localhost:5273` پر جا کر فاؤنڈری لوکل ویب انٹرفیس بھی دیکھ سکتے ہیں۔

## تشکیل

ایپلیکیشن کو `application.properties` کے ذریعے تشکیل دیا جا سکتا ہے:

- `foundry.local.base-url` - فاؤنڈری لوکل کے لیے بیس URL (ڈیفالٹ: http://localhost:5273)
- `foundry.local.model` - استعمال کرنے کے لیے AI ماڈل (ڈیفالٹ: Phi-3.5-mini-instruct-cuda-gpu)

> **نوٹ**: تشکیل میں ماڈل کا نام اس مخصوص ویریئنٹ سے میل کھانا چاہیے جو فاؤنڈری لوکل نے آپ کے نظام کے لیے ڈاؤن لوڈ کیا ہے۔ جب آپ `foundry model run phi-3.5-mini` چلاتے ہیں، تو فاؤنڈری لوکل خود بخود بہترین ویریئنٹ منتخب اور ڈاؤن لوڈ کرتا ہے (NVIDIA GPUs کے لیے CUDA، ورنہ CPU ورژن)۔ اپنے مقامی انسٹینس میں دستیاب ماڈل کا صحیح نام دیکھنے کے لیے `foundry model list` استعمال کریں۔

## جلدی شروع کریں

### 1. فاؤنڈری لوکل ایپلیکیشن ڈائریکٹری پر جائیں
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. ایپلیکیشن چلائیں

```bash
mvn spring-boot:run
```

یا JAR بنائیں اور چلائیں:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### انحصارات

یہ ایپلیکیشن فاؤنڈری لوکل کے ساتھ بات چیت کرنے کے لیے OpenAI جاوا SDK استعمال کرتی ہے۔ کلیدی انحصار یہ ہے:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

ایپلیکیشن پہلے سے ترتیب شدہ ہے تاکہ ڈیفالٹ پورٹ پر چلنے والے فاؤنڈری لوکل سے جڑ سکے۔

## ایپلیکیشن کیا کرتی ہے

جب آپ ایپلیکیشن چلاتے ہیں:

1. **کمانڈ لائن ایپلیکیشن کے طور پر شروع ہوتی ہے** (کوئی ویب سرور نہیں)
2. **خود بخود ایک ٹیسٹ پیغام بھیجتی ہے**: "ہیلو! کیا آپ مجھے بتا سکتے ہیں کہ آپ کیا ہیں اور کون سا ماڈل چلا رہے ہیں؟"
3. **فاؤنڈری لوکل سے جواب دکھاتی ہے** کنسول میں
4. **ڈیمو کے بعد صاف طور پر بند ہو جاتی ہے**

## نمونہ آؤٹ پٹ

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## معماری

- **Application.java** - مین اسپرنگ بوٹ ایپلیکیشن CommandLineRunner کے ساتھ
- **FoundryLocalService.java** - سروس جو OpenAI جاوا SDK کا استعمال کرتے ہوئے فاؤنڈری لوکل سے بات چیت کرتی ہے
- **OpenAI جاوا SDK** کا استعمال ٹائپ سیف API کالز کے لیے
- JSON سیریلائزیشن/ڈی سیریلائزیشن خودکار طور پر SDK کے ذریعے ہینڈل کی جاتی ہے
- اسپرنگ کے `@Value` اور `@PostConstruct` اینوٹیشنز کا استعمال کرتے ہوئے صاف تشکیل

## کوڈ کی جھلکیاں

### OpenAI جاوا SDK انضمام

ایپلیکیشن OpenAI جاوا SDK کا استعمال کرتی ہے تاکہ فاؤنڈری لوکل کے لیے ایک کلائنٹ تشکیل دے:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### چیٹ کمپلیشن API

چیٹ کمپلیشن درخواستیں بنانا آسان اور ٹائپ سیف ہے:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## مسائل کا حل

اگر آپ کو کنکشن کی غلطیاں نظر آئیں:
1. تصدیق کریں کہ فاؤنڈری لوکل `http://localhost:5273` پر چل رہا ہے
2. چیک کریں کہ `foundry model list` کے ساتھ Phi-3.5-mini ماڈل ویریئنٹ دستیاب ہے
3. یقینی بنائیں کہ `application.properties` میں ماڈل کا نام دستیاب ماڈل کے صحیح نام سے میل کھاتا ہے
4. یقینی بنائیں کہ کوئی فائر وال کنکشن کو بلاک نہیں کر رہا

عام مسائل:
- **ماڈل نہیں ملا**: `foundry model run phi-3.5-mini` چلائیں تاکہ ماڈل ڈاؤن لوڈ اور شروع کیا جا سکے
- **سروس نہیں چل رہی**: فاؤنڈری لوکل سروس بند ہو سکتی ہے؛ ماڈل رن کمانڈ کے ساتھ اسے دوبارہ شروع کریں
- **غلط ماڈل نام**: دستیاب ماڈلز دیکھنے کے لیے `foundry model list` استعمال کریں اور اپنی تشکیل کو accordingly اپ ڈیٹ کریں

**ڈسکلیمر**:  
یہ دستاویز AI ترجمہ سروس [Co-op Translator](https://github.com/Azure/co-op-translator) کا استعمال کرتے ہوئے ترجمہ کی گئی ہے۔ ہم درستگی کے لیے کوشش کرتے ہیں، لیکن براہ کرم آگاہ رہیں کہ خودکار ترجمے میں غلطیاں یا غیر درستیاں ہو سکتی ہیں۔ اصل دستاویز کو اس کی اصل زبان میں مستند ذریعہ سمجھا جانا چاہیے۔ اہم معلومات کے لیے، پیشہ ور انسانی ترجمہ کی سفارش کی جاتی ہے۔ ہم اس ترجمے کے استعمال سے پیدا ہونے والی کسی بھی غلط فہمی یا غلط تشریح کے ذمہ دار نہیں ہیں۔