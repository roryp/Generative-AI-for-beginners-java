<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "efd82efe50711d7e257eb943151d682c",
  "translation_date": "2025-07-27T13:34:46+00:00",
  "source_file": "02-SetupDevEnvironment/examples/basic-chat-azure/README.md",
  "language_code": "ur"
}
-->
# Azure OpenAI کے ساتھ بنیادی چیٹ - مکمل مثال

یہ مثال دکھاتی ہے کہ کس طرح ایک سادہ اسپرنگ بوٹ ایپلیکیشن بنائی جائے جو Azure OpenAI سے جڑتی ہے اور آپ کی سیٹ اپ کو ٹیسٹ کرتی ہے۔

## فہرست

- [ضروریات](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [تیز آغاز](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [کنفیگریشن کے اختیارات](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [اختیار 1: ماحول کے متغیرات (.env فائل) - تجویز کردہ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [اختیار 2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ایپلیکیشن چلانا](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Maven استعمال کرتے ہوئے](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [VS Code استعمال کرتے ہوئے](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [متوقع نتیجہ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [کنفیگریشن حوالہ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ماحول کے متغیرات](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [اسپرنگ کنفیگریشن](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [مسائل کا حل](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [عام مسائل](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ڈیبگ موڈ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [اگلے مراحل](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [وسائل](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## ضروریات

اس مثال کو چلانے سے پہلے، یقینی بنائیں کہ آپ نے:

- [Azure OpenAI سیٹ اپ گائیڈ](../../getting-started-azure-openai.md) مکمل کر لیا ہے  
- Azure AI Foundry پورٹل کے ذریعے Azure OpenAI ریسورس تعینات کر لیا ہے  
- gpt-4o-mini ماڈل (یا متبادل) تعینات کر لیا ہے  
- Azure سے API کلید اور اینڈ پوائنٹ URL حاصل کر لیا ہے  

## تیز آغاز

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## کنفیگریشن کے اختیارات

### اختیار 1: ماحول کے متغیرات (.env فائل) - تجویز کردہ

**مرحلہ 1: اپنی کنفیگریشن فائل بنائیں**
```bash
cp .env.example .env
```

**مرحلہ 2: اپنی Azure OpenAI اسناد شامل کریں**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **سیکیورٹی نوٹ**: 
> - اپنی `.env` فائل کو ورژن کنٹرول میں کبھی شامل نہ کریں
> - `.env` فائل پہلے ہی `.gitignore` میں شامل ہے
> - اپنی API کلیدوں کو محفوظ رکھیں اور انہیں باقاعدگی سے تبدیل کریں

### اختیار 2: GitHub Codespace Secrets

GitHub Codespaces کے لیے، اپنے ریپوزیٹری میں یہ راز سیٹ کریں:
- `AZURE_AI_KEY` - آپ کی Azure OpenAI API کلید
- `AZURE_AI_ENDPOINT` - آپ کا Azure OpenAI اینڈ پوائنٹ URL

ایپلیکیشن خود بخود ان رازوں کا پتہ لگاتی ہے اور استعمال کرتی ہے۔

### متبادل: براہ راست ماحول کے متغیرات

<details>
<summary>پلیٹ فارم کے مخصوص کمانڈز دیکھنے کے لیے کلک کریں</summary>

**Linux/macOS (bash/zsh):**
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Command Prompt):**
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## ایپلیکیشن چلانا

### Maven استعمال کرتے ہوئے

```bash
mvn spring-boot:run
```

### VS Code استعمال کرتے ہوئے

1. پروجیکٹ کو VS Code میں کھولیں
2. `F5` دبائیں یا "Run and Debug" پینل استعمال کریں
3. "Spring Boot-BasicChatApplication" کنفیگریشن منتخب کریں

> **نوٹ**: VS Code کنفیگریشن خود بخود آپ کی .env فائل لوڈ کرتی ہے

### متوقع نتیجہ

```
Starting Basic Chat with Azure OpenAI...
Environment variables loaded successfully
Connecting to Azure OpenAI...
Sending prompt: What is AI in a short sentence? Max 100 words.

AI Response:
================
AI, or Artificial Intelligence, is the simulation of human intelligence in machines programmed to think and learn like humans.
================

Success! Azure OpenAI connection is working correctly.
```

## کنفیگریشن حوالہ

### ماحول کے متغیرات

| متغیر | وضاحت | ضروری | مثال |
|-------|-------|-------|-------|
| `AZURE_AI_KEY` | Azure OpenAI API کلید | ہاں | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI اینڈ پوائنٹ URL | ہاں | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | ماڈل تعیناتی کا نام | نہیں | `gpt-4o-mini` (ڈیفالٹ) |

### اسپرنگ کنفیگریشن

`application.yml` فائل کنفیگریشن کرتی ہے:
- **API کلید**: `${AZURE_AI_KEY}` - ماحول کے متغیر سے
- **اینڈ پوائنٹ**: `${AZURE_AI_ENDPOINT}` - ماحول کے متغیر سے  
- **ماڈل**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - ماحول کے متغیر سے ڈیفالٹ کے ساتھ
- **درجہ حرارت**: `0.7` - تخلیقی صلاحیت کو کنٹرول کرتا ہے (0.0 = متعین، 1.0 = تخلیقی)
- **زیادہ سے زیادہ ٹوکنز**: `500` - جواب کی زیادہ سے زیادہ لمبائی

## مسائل کا حل

### عام مسائل

<details>
<summary><strong>غلطی: "API کلید درست نہیں ہے"</strong></summary>

- چیک کریں کہ آپ کی `AZURE_AI_KEY` صحیح طور پر `.env` فائل میں سیٹ کی گئی ہے
- تصدیق کریں کہ API کلید Azure AI Foundry پورٹل سے بالکل کاپی کی گئی ہے
- کلید کے ارد گرد اضافی اسپیس یا کوٹس نہ ہوں
</details>

<details>
<summary><strong>غلطی: "اینڈ پوائنٹ درست نہیں ہے"</strong></summary>

- یقینی بنائیں کہ آپ کا `AZURE_AI_ENDPOINT` مکمل URL شامل کرتا ہے (مثال: `https://your-hub-name.openai.azure.com/`)
- ٹریلنگ سلیش کی مطابقت چیک کریں
- تصدیق کریں کہ اینڈ پوائنٹ آپ کے Azure تعیناتی کے علاقے سے میل کھاتا ہے
</details>

<details>
<summary><strong>غلطی: "تعیناتی نہیں ملی"</strong></summary>

- تصدیق کریں کہ آپ کا ماڈل تعیناتی کا نام بالکل Azure میں تعینات کردہ نام سے میل کھاتا ہے
- چیک کریں کہ ماڈل کامیابی سے تعینات اور فعال ہے
- ڈیفالٹ تعیناتی نام استعمال کرنے کی کوشش کریں: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: ماحول کے متغیرات لوڈ نہیں ہو رہے</strong></summary>

- یقینی بنائیں کہ آپ کی `.env` فائل پروجیکٹ روٹ ڈائریکٹری میں ہے (اسی سطح پر جیسے `pom.xml`)
- VS Code کے انٹیگریٹڈ ٹرمینل میں `mvn spring-boot:run` چلانے کی کوشش کریں
- چیک کریں کہ VS Code جاوا ایکسٹینشن صحیح طور پر انسٹال ہے
- تصدیق کریں کہ لانچ کنفیگریشن میں `"envFile": "${workspaceFolder}/.env"` شامل ہے
</details>

### ڈیبگ موڈ

تفصیلی لاگنگ کو فعال کرنے کے لیے، `application.yml` میں ان لائنز کو ان کومنٹ کریں:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## اگلے مراحل

**سیٹ اپ مکمل!** اپنی سیکھنے کے سفر کو جاری رکھیں:

[باب 3: بنیادی تخلیقی AI تکنیکیں](../../../03-CoreGenerativeAITechniques/README.md)

## وسائل

- [اسپرنگ AI Azure OpenAI دستاویزات](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI سروس دستاویزات](https://learn.microsoft.com/azure/ai-services/openai/)
- [Azure AI Foundry پورٹل](https://ai.azure.com/)
- [Azure AI Foundry دستاویزات](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**ڈسکلیمر**:  
یہ دستاویز AI ترجمہ سروس [Co-op Translator](https://github.com/Azure/co-op-translator) کا استعمال کرتے ہوئے ترجمہ کی گئی ہے۔ ہم درستگی کے لیے کوشش کرتے ہیں، لیکن براہ کرم آگاہ رہیں کہ خودکار ترجمے میں غلطیاں یا غیر درستیاں ہو سکتی ہیں۔ اصل دستاویز کو اس کی اصل زبان میں مستند ذریعہ سمجھا جانا چاہیے۔ اہم معلومات کے لیے، پیشہ ور انسانی ترجمہ کی سفارش کی جاتی ہے۔ ہم اس ترجمے کے استعمال سے پیدا ہونے والی کسی بھی غلط فہمی یا غلط تشریح کے ذمہ دار نہیں ہیں۔