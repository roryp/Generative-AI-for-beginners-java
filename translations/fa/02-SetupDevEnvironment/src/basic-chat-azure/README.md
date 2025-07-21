<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2289320a74aeca1eb844cd7d3a7a9e12",
  "translation_date": "2025-07-21T16:29:03+00:00",
  "source_file": "02-SetupDevEnvironment/src/basic-chat-azure/README.md",
  "language_code": "fa"
}
-->
# چت ساده با Azure OpenAI - مثال کامل

این مثال نشان می‌دهد که چگونه یک برنامه ساده Spring Boot ایجاد کنید که به Azure OpenAI متصل شده و تنظیمات شما را آزمایش کند.

## فهرست مطالب

- [پیش‌نیازها](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [شروع سریع](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [گزینه‌های پیکربندی](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [گزینه ۱: متغیرهای محیطی (فایل .env) - توصیه‌شده](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [گزینه ۲: اسرار GitHub Codespace](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [اجرای برنامه](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [با استفاده از Maven](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [با استفاده از VS Code](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [خروجی مورد انتظار](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [مرجع پیکربندی](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [متغیرهای محیطی](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [پیکربندی Spring](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [رفع اشکال](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [مشکلات رایج](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [حالت اشکال‌زدایی](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [گام‌های بعدی](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [منابع](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)

## پیش‌نیازها

قبل از اجرای این مثال، اطمینان حاصل کنید که:

- [راهنمای تنظیم Azure OpenAI](../../getting-started-azure-openai.md) را تکمیل کرده‌اید  
- منبع Azure OpenAI را مستقر کرده‌اید (از طریق پورتال Azure AI Foundry)  
- مدل gpt-4o-mini (یا جایگزین) را مستقر کرده‌اید  
- کلید API و URL نقطه پایانی از Azure را دارید  

## شروع سریع

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/src/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## گزینه‌های پیکربندی

### گزینه ۱: متغیرهای محیطی (فایل .env) - توصیه‌شده

**مرحله ۱: فایل پیکربندی خود را ایجاد کنید**  
```bash
cp .env.example .env
```

**مرحله ۲: اطلاعات Azure OpenAI خود را اضافه کنید**  
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **نکته امنیتی**:  
> - هرگز فایل `.env` خود را به کنترل نسخه متعهد نکنید  
> - فایل `.env` از قبل در `.gitignore` قرار دارد  
> - کلیدهای API خود را ایمن نگه دارید و به طور منظم آن‌ها را تغییر دهید  

### گزینه ۲: اسرار GitHub Codespace

برای GitHub Codespaces، این اسرار را در مخزن خود تنظیم کنید:  
- `AZURE_AI_KEY` - کلید API Azure OpenAI شما  
- `AZURE_AI_ENDPOINT` - URL نقطه پایانی Azure OpenAI شما  

برنامه به طور خودکار این اسرار را شناسایی و استفاده می‌کند.

### جایگزین: متغیرهای محیطی مستقیم

<details>
<summary>برای مشاهده دستورات خاص پلتفرم کلیک کنید</summary>

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

## اجرای برنامه

### با استفاده از Maven

```bash
mvn spring-boot:run
```

### با استفاده از VS Code

1. پروژه را در VS Code باز کنید  
2. کلید `F5` را فشار دهید یا از پنل "Run and Debug" استفاده کنید  
3. پیکربندی "Spring Boot-BasicChatApplication" را انتخاب کنید  

> **توجه**: پیکربندی VS Code به طور خودکار فایل `.env` شما را بارگذاری می‌کند  

### خروجی مورد انتظار

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

## مرجع پیکربندی

### متغیرهای محیطی

| متغیر | توضیحات | ضروری | مثال |
|-------|---------|-------|-------|
| `AZURE_AI_KEY` | کلید API Azure OpenAI | بله | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL نقطه پایانی Azure OpenAI | بله | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | نام استقرار مدل | خیر | `gpt-4o-mini` (پیش‌فرض) |

### پیکربندی Spring

فایل `application.yml` پیکربندی می‌کند:  
- **کلید API**: `${AZURE_AI_KEY}` - از متغیر محیطی  
- **نقطه پایانی**: `${AZURE_AI_ENDPOINT}` - از متغیر محیطی  
- **مدل**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - از متغیر محیطی با مقدار پیش‌فرض  
- **دمای پاسخ**: `0.7` - کنترل خلاقیت (0.0 = قطعی، 1.0 = خلاق)  
- **حداکثر تعداد توکن‌ها**: `500` - حداکثر طول پاسخ  

## رفع اشکال

### مشکلات رایج

<details>
<summary><strong>خطا: "کلید API معتبر نیست"</strong></summary>

- بررسی کنید که `AZURE_AI_KEY` به درستی در فایل `.env` تنظیم شده باشد  
- اطمینان حاصل کنید که کلید API دقیقاً از پورتال Azure AI Foundry کپی شده باشد  
- مطمئن شوید که هیچ فضای اضافی یا علامت نقل قول اطراف کلید وجود ندارد  
</details>

<details>
<summary><strong>خطا: "نقطه پایانی معتبر نیست"</strong></summary>

- اطمینان حاصل کنید که `AZURE_AI_ENDPOINT` شامل URL کامل باشد (مثلاً `https://your-hub-name.openai.azure.com/`)  
- سازگاری اسلش انتهایی را بررسی کنید  
- مطمئن شوید که نقطه پایانی با منطقه استقرار Azure شما مطابقت دارد  
</details>

<details>
<summary><strong>خطا: "استقرار یافت نشد"</strong></summary>

- بررسی کنید که نام استقرار مدل دقیقاً با آنچه در Azure مستقر شده مطابقت داشته باشد  
- اطمینان حاصل کنید که مدل با موفقیت مستقر و فعال است  
- تلاش کنید از نام استقرار پیش‌فرض استفاده کنید: `gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code: متغیرهای محیطی بارگذاری نمی‌شوند</strong></summary>

- اطمینان حاصل کنید که فایل `.env` در دایرکتوری ریشه پروژه (هم‌سطح با `pom.xml`) قرار دارد  
- تلاش کنید `mvn spring-boot:run` را در ترمینال یکپارچه VS Code اجرا کنید  
- بررسی کنید که افزونه Java در VS Code به درستی نصب شده باشد  
- اطمینان حاصل کنید که پیکربندی اجرا شامل `"envFile": "${workspaceFolder}/.env"` باشد  
</details>

### حالت اشکال‌زدایی

برای فعال کردن گزارش‌گیری دقیق، این خطوط را در `application.yml` از حالت کامنت خارج کنید:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## گام‌های بعدی

**تنظیمات کامل شد!** سفر یادگیری خود را ادامه دهید:

[فصل ۳: تکنیک‌های اصلی هوش مصنوعی مولد](../../../03-CoreGenerativeAITechniques/README.md)

## منابع

- [مستندات Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [مستندات سرویس Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)  
- [پورتال Azure AI Foundry](https://ai.azure.com/)  
- [مستندات Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**سلب مسئولیت**:  
این سند با استفاده از سرویس ترجمه هوش مصنوعی [Co-op Translator](https://github.com/Azure/co-op-translator) ترجمه شده است. در حالی که ما تلاش می‌کنیم دقت را حفظ کنیم، لطفاً توجه داشته باشید که ترجمه‌های خودکار ممکن است شامل خطاها یا نادقتی‌ها باشند. سند اصلی به زبان اصلی آن باید به عنوان منبع معتبر در نظر گرفته شود. برای اطلاعات حساس، ترجمه حرفه‌ای انسانی توصیه می‌شود. ما هیچ مسئولیتی در قبال سوءتفاهم‌ها یا تفسیرهای نادرست ناشی از استفاده از این ترجمه نداریم.