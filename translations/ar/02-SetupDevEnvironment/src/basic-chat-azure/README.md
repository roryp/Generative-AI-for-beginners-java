<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2289320a74aeca1eb844cd7d3a7a9e12",
  "translation_date": "2025-07-21T18:04:49+00:00",
  "source_file": "02-SetupDevEnvironment/src/basic-chat-azure/README.md",
  "language_code": "ar"
}
-->
# مثال شامل للدردشة الأساسية مع Azure OpenAI

يوضح هذا المثال كيفية إنشاء تطبيق بسيط باستخدام Spring Boot يتصل بـ Azure OpenAI لاختبار الإعداد الخاص بك.

## جدول المحتويات

- [المتطلبات الأساسية](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [البدء السريع](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [خيارات التكوين](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [الخيار 1: متغيرات البيئة (ملف .env) - موصى به](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [الخيار 2: أسرار GitHub Codespace](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [تشغيل التطبيق](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [باستخدام Maven](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [باستخدام VS Code](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [المخرجات المتوقعة](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [مرجع التكوين](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [متغيرات البيئة](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [تكوين Spring](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [استكشاف الأخطاء وإصلاحها](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [المشاكل الشائعة](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [وضع التصحيح](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [الخطوات التالية](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [الموارد](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)

## المتطلبات الأساسية

قبل تشغيل هذا المثال، تأكد من أنك قد قمت بما يلي:

- إكمال [دليل إعداد Azure OpenAI](../../getting-started-azure-openai.md)  
- نشر مورد Azure OpenAI (عبر بوابة Azure AI Foundry)  
- نشر نموذج gpt-4o-mini (أو بديل)  
- الحصول على مفتاح API وعنوان URL للنقطة النهائية من Azure  

## البدء السريع

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/src/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## خيارات التكوين

### الخيار 1: متغيرات البيئة (ملف .env) - موصى به

**الخطوة 1: إنشاء ملف التكوين الخاص بك**  
```bash
cp .env.example .env
```

**الخطوة 2: إضافة بيانات اعتماد Azure OpenAI الخاصة بك**  
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **ملاحظة أمان**:  
> - لا تقم أبدًا بإضافة ملف `.env` إلى نظام التحكم في الإصدارات  
> - ملف `.env` مضاف بالفعل إلى `.gitignore`  
> - حافظ على أمان مفاتيح API وقم بتدويرها بانتظام  

### الخيار 2: أسرار GitHub Codespace

بالنسبة إلى GitHub Codespaces، قم بتعيين هذه الأسرار في مستودعك:
- `AZURE_AI_KEY` - مفتاح API الخاص بـ Azure OpenAI
- `AZURE_AI_ENDPOINT` - عنوان URL للنقطة النهائية لـ Azure OpenAI

يكتشف التطبيق هذه الأسرار تلقائيًا ويستخدمها.

### بديل: متغيرات البيئة المباشرة

<details>
<summary>انقر لرؤية الأوامر الخاصة بكل نظام</summary>

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

## تشغيل التطبيق

### باستخدام Maven

```bash
mvn spring-boot:run
```

### باستخدام VS Code

1. افتح المشروع في VS Code  
2. اضغط على `F5` أو استخدم لوحة "Run and Debug"  
3. اختر تكوين "Spring Boot-BasicChatApplication"  

> **ملاحظة**: يقوم تكوين VS Code بتحميل ملف `.env` تلقائيًا  

### المخرجات المتوقعة

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

## مرجع التكوين

### متغيرات البيئة

| المتغير | الوصف | مطلوب | مثال |
|---------|-------|-------|-------|
| `AZURE_AI_KEY` | مفتاح API الخاص بـ Azure OpenAI | نعم | `abc123...` |
| `AZURE_AI_ENDPOINT` | عنوان URL للنقطة النهائية لـ Azure OpenAI | نعم | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | اسم نشر النموذج | لا | `gpt-4o-mini` (افتراضي) |

### تكوين Spring

يتم تكوين ملف `application.yml` لـ:
- **مفتاح API**: `${AZURE_AI_KEY}` - من متغير البيئة  
- **النقطة النهائية**: `${AZURE_AI_ENDPOINT}` - من متغير البيئة  
- **النموذج**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - من متغير البيئة مع قيمة افتراضية  
- **درجة الحرارة**: `0.7` - تتحكم في الإبداع (0.0 = حتمي، 1.0 = إبداعي)  
- **الحد الأقصى للرموز**: `500` - الحد الأقصى لطول الاستجابة  

## استكشاف الأخطاء وإصلاحها

### المشاكل الشائعة

<details>
<summary><strong>خطأ: "The API key is not valid"</strong></summary>

- تحقق من أن `AZURE_AI_KEY` مضبوط بشكل صحيح في ملف `.env`  
- تأكد من نسخ مفتاح API بالضبط من بوابة Azure AI Foundry  
- تأكد من عدم وجود مسافات إضافية أو علامات اقتباس حول المفتاح  
</details>

<details>
<summary><strong>خطأ: "The endpoint is not valid"</strong></summary>

- تأكد من أن `AZURE_AI_ENDPOINT` يتضمن عنوان URL الكامل (مثل: `https://your-hub-name.openai.azure.com/`)  
- تحقق من تناسق الشرطة المائلة النهائية  
- تأكد من أن النقطة النهائية تتطابق مع منطقة نشر Azure الخاصة بك  
</details>

<details>
<summary><strong>خطأ: "The deployment was not found"</strong></summary>

- تحقق من أن اسم نشر النموذج يتطابق تمامًا مع ما تم نشره في Azure  
- تأكد من أن النموذج تم نشره بنجاح وهو نشط  
- جرب استخدام اسم النشر الافتراضي: `gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code: لم يتم تحميل متغيرات البيئة</strong></summary>

- تأكد من أن ملف `.env` موجود في دليل الجذر للمشروع (بنفس مستوى `pom.xml`)  
- جرب تشغيل `mvn spring-boot:run` في الطرفية المدمجة لـ VS Code  
- تحقق من أن إضافة Java لـ VS Code مثبتة بشكل صحيح  
- تأكد من أن تكوين التشغيل يحتوي على `"envFile": "${workspaceFolder}/.env"`  
</details>

### وضع التصحيح

لتمكين تسجيل الدخول التفصيلي، قم بإلغاء تعليق هذه الأسطر في `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## الخطوات التالية

**تم الإعداد بنجاح!** تابع رحلتك التعليمية:

[الفصل 3: تقنيات الذكاء الاصطناعي التوليدي الأساسية](../../../03-CoreGenerativeAITechniques/README.md)

## الموارد

- [وثائق Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [وثائق خدمة Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)  
- [بوابة Azure AI Foundry](https://ai.azure.com/)  
- [وثائق Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**إخلاء المسؤولية**:  
تم ترجمة هذا المستند باستخدام خدمة الترجمة بالذكاء الاصطناعي [Co-op Translator](https://github.com/Azure/co-op-translator). بينما نسعى لتحقيق الدقة، يرجى العلم أن الترجمات الآلية قد تحتوي على أخطاء أو معلومات غير دقيقة. يجب اعتبار المستند الأصلي بلغته الأصلية المصدر الموثوق. للحصول على معلومات حاسمة، يُوصى بالاستعانة بترجمة بشرية احترافية. نحن غير مسؤولين عن أي سوء فهم أو تفسيرات خاطئة تنشأ عن استخدام هذه الترجمة.