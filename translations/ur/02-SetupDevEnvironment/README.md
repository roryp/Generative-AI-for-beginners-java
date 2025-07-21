<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0b563ac59362fb83f0f49dcfc442dd97",
  "translation_date": "2025-07-21T17:53:43+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "ur"
}
-->
# جاوا کے لیے جنریٹیو اے آئی کا ڈیولپمنٹ ماحول سیٹ اپ کرنا

> **فوری آغاز**: کلاؤڈ میں 2 منٹ میں کوڈنگ شروع کریں - [GitHub Codespaces Setup](../../../02-SetupDevEnvironment) پر جائیں - کسی مقامی انسٹالیشن کی ضرورت نہیں اور یہ GitHub ماڈلز استعمال کرتا ہے!

> **Azure OpenAI میں دلچسپی رکھتے ہیں؟** ہمارے [Azure OpenAI سیٹ اپ گائیڈ](getting-started-azure-openai.md) کو دیکھیں، جس میں ایک نیا Azure OpenAI ریسورس بنانے کے مراحل شامل ہیں۔

## آپ کیا سیکھیں گے

- اے آئی ایپلیکیشنز کے لیے جاوا ڈیولپمنٹ ماحول سیٹ اپ کریں
- اپنی پسندیدہ ڈیولپمنٹ ماحول (کلاؤڈ-فرسٹ Codespaces کے ساتھ، مقامی ڈیو کنٹینر، یا مکمل مقامی سیٹ اپ) کو منتخب اور ترتیب دیں
- GitHub ماڈلز سے جڑ کر اپنے سیٹ اپ کو ٹیسٹ کریں

## مواد کی فہرست

- [آپ کیا سیکھیں گے](../../../02-SetupDevEnvironment)
- [تعارف](../../../02-SetupDevEnvironment)
- [مرحلہ 1: اپنا ڈیولپمنٹ ماحول سیٹ اپ کریں](../../../02-SetupDevEnvironment)
  - [آپشن A: GitHub Codespaces (تجویز کردہ)](../../../02-SetupDevEnvironment)
  - [آپشن B: مقامی ڈیو کنٹینر](../../../02-SetupDevEnvironment)
  - [آپشن C: اپنی موجودہ مقامی انسٹالیشن استعمال کریں](../../../02-SetupDevEnvironment)
- [مرحلہ 2: GitHub پرسنل ایکسیس ٹوکن بنائیں](../../../02-SetupDevEnvironment)
- [مرحلہ 3: اپنے سیٹ اپ کو ٹیسٹ کریں](../../../02-SetupDevEnvironment)
- [مسائل کا حل](../../../02-SetupDevEnvironment)
- [خلاصہ](../../../02-SetupDevEnvironment)
- [اگلے مراحل](../../../02-SetupDevEnvironment)

## تعارف

یہ باب آپ کو ڈیولپمنٹ ماحول سیٹ اپ کرنے کے عمل سے گزرے گا۔ ہم **GitHub ماڈلز** کو اپنی بنیادی مثال کے طور پر استعمال کریں گے کیونکہ یہ مفت ہے، صرف ایک GitHub اکاؤنٹ کے ساتھ آسانی سے سیٹ اپ ہو جاتا ہے، کسی کریڈٹ کارڈ کی ضرورت نہیں، اور تجربات کے لیے متعدد ماڈلز تک رسائی فراہم کرتا ہے۔

**کسی مقامی سیٹ اپ کی ضرورت نہیں!** آپ فوراً کوڈنگ شروع کر سکتے ہیں GitHub Codespaces کا استعمال کرتے ہوئے، جو آپ کے براؤزر میں مکمل ڈیولپمنٹ ماحول فراہم کرتا ہے۔

<img src="./images/models.webp" alt="اسکرین شاٹ: GitHub ماڈلز" width="50%">

ہم اس کورس کے لیے [**GitHub ماڈلز**](https://github.com/marketplace?type=models) استعمال کرنے کی تجویز دیتے ہیں کیونکہ یہ:
- **مفت** ہے شروع کرنے کے لیے
- **آسان** ہے صرف ایک GitHub اکاؤنٹ کے ساتھ سیٹ اپ کرنے کے لیے
- **کریڈٹ کارڈ** کی ضرورت نہیں
- **متعدد ماڈلز** تجربات کے لیے دستیاب ہیں

> **نوٹ**: اس تربیت میں استعمال ہونے والے GitHub ماڈلز کے مفت حدود یہ ہیں:
> - 15 درخواستیں فی منٹ (150 فی دن)
> - ~8,000 الفاظ ان پٹ، ~4,000 الفاظ آؤٹ پٹ فی درخواست
> - 5 متوازی درخواستیں
> 
> پروڈکشن کے لیے، Azure AI Foundry ماڈلز پر اپ گریڈ کریں اپنے Azure اکاؤنٹ کے ساتھ۔ آپ کے کوڈ میں کوئی تبدیلی کی ضرورت نہیں۔ [Azure AI Foundry دستاویزات](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models) دیکھیں۔

## مرحلہ 1: اپنا ڈیولپمنٹ ماحول سیٹ اپ کریں

<a name="quick-start-cloud"></a>

ہم نے ایک پہلے سے ترتیب شدہ ڈیولپمنٹ کنٹینر بنایا ہے تاکہ سیٹ اپ کے وقت کو کم کیا جا سکے اور اس بات کو یقینی بنایا جا سکے کہ آپ کے پاس اس جنریٹیو اے آئی برائے جاوا کورس کے لیے تمام ضروری ٹولز موجود ہوں۔ اپنی پسندیدہ ڈیولپمنٹ اپروچ منتخب کریں:

### ماحول سیٹ اپ کے اختیارات:

#### آپشن A: GitHub Codespaces (تجویز کردہ)

**2 منٹ میں کوڈنگ شروع کریں - کسی مقامی سیٹ اپ کی ضرورت نہیں!**

1. اس ریپوزٹری کو اپنے GitHub اکاؤنٹ میں فورک کریں
   > **نوٹ**: اگر آپ بنیادی کنفیگریشن میں ترمیم کرنا چاہتے ہیں تو [Dev Container Configuration](../../../.devcontainer/devcontainer.json) دیکھیں
2. **Code** پر کلک کریں → **Codespaces** ٹیب → **...** → **New with options...**
3. ڈیفالٹس استعمال کریں – یہ **Dev container configuration** منتخب کرے گا: **Generative AI Java Development Environment** جو اس کورس کے لیے بنایا گیا ہے
4. **Create codespace** پر کلک کریں
5. ماحول کے تیار ہونے کے لیے ~2 منٹ انتظار کریں
6. [مرحلہ 2: GitHub ٹوکن بنائیں](../../../02-SetupDevEnvironment) پر جائیں

<img src="./images/codespaces.png" alt="اسکرین شاٹ: Codespaces سب مینو" width="50%">

<img src="./images/image.png" alt="اسکرین شاٹ: New with options" width="50%">

<img src="./images/codespaces-create.png" alt="اسکرین شاٹ: Create codespace options" width="50%">


> **Codespaces کے فوائد**:
> - کسی مقامی انسٹالیشن کی ضرورت نہیں
> - کسی بھی ڈیوائس پر براؤزر کے ساتھ کام کرتا ہے
> - تمام ٹولز اور ڈیپینڈنسیز کے ساتھ پہلے سے ترتیب شدہ
> - ذاتی اکاؤنٹس کے لیے ماہانہ 60 گھنٹے مفت
> - تمام سیکھنے والوں کے لیے مستقل ماحول

#### آپشن B: مقامی ڈیو کنٹینر

**ان ڈویلپرز کے لیے جو Docker کے ساتھ مقامی ڈیولپمنٹ کو ترجیح دیتے ہیں**

1. اس ریپوزٹری کو اپنے مقامی کمپیوٹر پر فورک اور کلون کریں
   > **نوٹ**: اگر آپ بنیادی کنفیگریشن میں ترمیم کرنا چاہتے ہیں تو [Dev Container Configuration](../../../.devcontainer/devcontainer.json) دیکھیں
2. [Docker Desktop](https://www.docker.com/products/docker-desktop/) اور [VS Code](https://code.visualstudio.com/) انسٹال کریں
3. VS Code میں [Dev Containers ایکسٹینشن](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) انسٹال کریں
4. ریپوزٹری فولڈر کو VS Code میں کھولیں
5. جب اشارہ کیا جائے، **Reopen in Container** پر کلک کریں (یا `Ctrl+Shift+P` → "Dev Containers: Reopen in Container" استعمال کریں)
6. کنٹینر کے بننے اور شروع ہونے کا انتظار کریں
7. [مرحلہ 2: GitHub ٹوکن بنائیں](../../../02-SetupDevEnvironment) پر جائیں

<img src="./images/devcontainer.png" alt="اسکرین شاٹ: ڈیو کنٹینر سیٹ اپ" width="50%">

<img src="./images/image-3.png" alt="اسکرین شاٹ: ڈیو کنٹینر بلڈ مکمل" width="50%">

#### آپشن C: اپنی موجودہ مقامی انسٹالیشن استعمال کریں

**ان ڈویلپرز کے لیے جو پہلے سے موجود جاوا ماحول استعمال کرنا چاہتے ہیں**

ضروریات:
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) یا آپ کا پسندیدہ IDE

مراحل:
1. اس ریپوزٹری کو اپنے مقامی کمپیوٹر پر کلون کریں
2. پروجیکٹ کو اپنے IDE میں کھولیں
3. [مرحلہ 2: GitHub ٹوکن بنائیں](../../../02-SetupDevEnvironment) پر جائیں

> **پرو ٹپ**: اگر آپ کے پاس کم اسپیکس والا کمپیوٹر ہے لیکن آپ مقامی طور پر VS Code استعمال کرنا چاہتے ہیں، تو GitHub Codespaces استعمال کریں! آپ اپنے مقامی VS Code کو کلاؤڈ ہوسٹڈ Codespace سے جوڑ سکتے ہیں تاکہ دونوں کا بہترین فائدہ اٹھا سکیں۔

<img src="./images/image-2.png" alt="اسکرین شاٹ: مقامی ڈیو کنٹینر انسٹینس بنایا گیا" width="50%">


## مرحلہ 2: GitHub پرسنل ایکسیس ٹوکن بنائیں

1. [GitHub سیٹنگز](https://github.com/settings/profile) پر جائیں اور اپنے پروفائل مینو سے **Settings** منتخب کریں۔
2. بائیں سائڈبار میں، **Developer settings** پر کلک کریں (عام طور پر نیچے ہوتا ہے)۔
3. **Personal access tokens** کے تحت، **Fine-grained tokens** پر کلک کریں (یا اس ڈائریکٹ [لنک](https://github.com/settings/personal-access-tokens) کو فالو کریں)۔
4. **Generate new token** پر کلک کریں۔
5. "Token name" کے تحت، ایک وضاحتی نام فراہم کریں (مثلاً، `GenAI-Java-Course-Token`)۔
6. ایکسپائریشن ڈیٹ سیٹ کریں (سیکیورٹی کے بہترین اصولوں کے لیے 7 دن تجویز کردہ)۔
7. "Resource owner" کے تحت، اپنا یوزر اکاؤنٹ منتخب کریں۔
8. "Repository access" کے تحت، وہ ریپوزٹریز منتخب کریں جنہیں آپ GitHub ماڈلز کے ساتھ استعمال کرنا چاہتے ہیں (یا "All repositories" اگر ضرورت ہو)۔
9. "Repository permissions" کے تحت، **Models** تلاش کریں اور اسے **Read and write** پر سیٹ کریں۔
10. **Generate token** پر کلک کریں۔
11. **اپنا ٹوکن ابھی کاپی اور محفوظ کریں** – آپ اسے دوبارہ نہیں دیکھ سکیں گے!

> **سیکیورٹی ٹپ**: اپنے ایکسیس ٹوکنز کے لیے کم سے کم مطلوبہ اسکوپ اور سب سے کم ممکنہ ایکسپائریشن وقت استعمال کریں۔

## مرحلہ 3: اپنے سیٹ اپ کو GitHub ماڈلز کی مثال کے ساتھ ٹیسٹ کریں

جب آپ کا ڈیولپمنٹ ماحول تیار ہو جائے، تو آئیے GitHub ماڈلز کے انضمام کو ہماری مثال ایپلیکیشن کے ساتھ ٹیسٹ کریں [`02-SetupDevEnvironment/src/github-models`](../../../02-SetupDevEnvironment/src/github-models)۔

1. اپنے ڈیولپمنٹ ماحول میں ٹرمینل کھولیں۔
2. GitHub ماڈلز کی مثال پر جائیں:
   ```bash
   cd 02-SetupDevEnvironment/src/github-models
   ```
3. اپنے GitHub ٹوکن کو ایک ماحول متغیر کے طور پر سیٹ کریں:
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. ایپلیکیشن چلائیں:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

آپ کو اس طرح کا آؤٹ پٹ نظر آنا چاہیے:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### مثال کوڈ کو سمجھنا

پہلے، آئیے سمجھتے ہیں کہ ہم کیا چلانے والے ہیں۔ یہ مثال OpenAI جاوا SDK کا استعمال کرتی ہے GitHub ماڈلز سے جڑنے کے لیے:

**یہ کوڈ کیا کرتا ہے:**
- **GitHub ماڈلز سے جڑتا ہے** آپ کے پرسنل ایکسیس ٹوکن کا استعمال کرتے ہوئے
- ایک سادہ "Say Hello World!" پیغام AI ماڈل کو بھیجتا ہے
- AI کا جواب وصول کرتا ہے اور دکھاتا ہے
- آپ کے سیٹ اپ کی درستگی کی تصدیق کرتا ہے

**اہم ڈیپینڈنسی** (`pom.xml` میں):
```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

**مین کوڈ** (`App.java`):
```java
// Connect to GitHub Models using OpenAI Java SDK
OpenAIClient client = OpenAIOkHttpClient.builder()
    .apiKey(pat)
    .baseUrl("https://models.inference.ai.azure.com")
    .build();

// Create chat completion request
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .model(modelId)
    .addSystemMessage("You are a concise assistant.")
    .addUserMessage("Say Hello World!")
    .build();

// Get AI response
ChatCompletion response = client.chat().completions().create(params);
System.out.println("Response: " + response.choices().get(0).message().content().orElse("No response content"));
```

## خلاصہ

**مبارک ہو!** آپ نے کامیابی سے:

- **GitHub پرسنل ایکسیس ٹوکن بنایا** AI ماڈل تک رسائی کے لیے مناسب اجازتوں کے ساتھ
- **اپنا جاوا ڈیولپمنٹ ماحول سیٹ اپ کیا** Codespaces، ڈیو کنٹینرز، یا مقامی انسٹالیشن کا استعمال کرتے ہوئے
- **GitHub ماڈلز سے جڑا** OpenAI جاوا SDK کا استعمال کرتے ہوئے مفت AI ڈیولپمنٹ تک رسائی کے لیے
- **انضمام کو ٹیسٹ کیا** ایک ورکنگ مثال ایپلیکیشن کے ساتھ جو AI ماڈلز کے ساتھ بات چیت کرتی ہے

## اگلے مراحل

[باب 3: بنیادی جنریٹیو اے آئی تکنیکیں](../03-CoreGenerativeAITechniques/README.md)

## مسائل کا حل

مسائل کا سامنا ہے؟ یہاں عام مسائل اور ان کے حل ہیں:

- **ٹوکن کام نہیں کر رہا؟** 
  - یقینی بنائیں کہ آپ نے پورا ٹوکن بغیر کسی اضافی اسپیس کے کاپی کیا ہے
  - تصدیق کریں کہ ٹوکن کو صحیح طور پر ماحول متغیر کے طور پر سیٹ کیا گیا ہے
  - چیک کریں کہ آپ کے ٹوکن کے پاس درست اجازتیں ہیں (Models: Read and write)

- **Maven نہیں ملا؟** 
  - اگر آپ ڈیو کنٹینرز/Codespaces استعمال کر رہے ہیں، تو Maven پہلے سے انسٹال ہونا چاہیے
  - مقامی سیٹ اپ کے لیے، یقینی بنائیں کہ Java 21+ اور Maven 3.9+ انسٹال ہیں
  - انسٹالیشن کی تصدیق کے لیے `mvn --version` آزمائیں

- **کنکشن کے مسائل؟** 
  - اپنا انٹرنیٹ کنکشن چیک کریں
  - تصدیق کریں کہ GitHub آپ کے نیٹ ورک سے قابل رسائی ہے
  - یقینی بنائیں کہ آپ کسی ایسے فائر وال کے پیچھے نہیں ہیں جو GitHub ماڈلز کے اینڈ پوائنٹ کو بلاک کر رہا ہو

- **ڈیو کنٹینر شروع نہیں ہو رہا؟** 
  - یقینی بنائیں کہ Docker Desktop چل رہا ہے (مقامی ڈیولپمنٹ کے لیے)
  - کنٹینر کو دوبارہ بنانے کی کوشش کریں: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container"

- **ایپلیکیشن کمپائلیشن کی غلطیاں؟**
  - یقینی بنائیں کہ آپ درست ڈائریکٹری میں ہیں: `02-SetupDevEnvironment/src/github-models`
  - صاف کرنے اور دوبارہ بنانے کی کوشش کریں: `mvn clean compile`

> **مدد چاہیے؟**: اب بھی مسائل کا سامنا ہے؟ ریپوزٹری میں ایک مسئلہ کھولیں اور ہم آپ کی مدد کریں گے۔

**ڈسکلیمر**:  
یہ دستاویز AI ترجمہ سروس [Co-op Translator](https://github.com/Azure/co-op-translator) کا استعمال کرتے ہوئے ترجمہ کی گئی ہے۔ ہم درستگی کے لیے کوشش کرتے ہیں، لیکن براہ کرم آگاہ رہیں کہ خودکار ترجمے میں غلطیاں یا غیر درستیاں ہو سکتی ہیں۔ اصل دستاویز کو اس کی اصل زبان میں مستند ذریعہ سمجھا جانا چاہیے۔ اہم معلومات کے لیے، پیشہ ور انسانی ترجمہ کی سفارش کی جاتی ہے۔ ہم اس ترجمے کے استعمال سے پیدا ہونے والی کسی بھی غلط فہمی یا غلط تشریح کے ذمہ دار نہیں ہیں۔