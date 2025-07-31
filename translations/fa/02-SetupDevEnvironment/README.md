<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c2a244c959e00da1ae1613d2ebfdac65",
  "translation_date": "2025-07-29T08:11:46+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "fa"
}
-->
# راه‌اندازی محیط توسعه برای هوش مصنوعی مولد با جاوا

> **شروع سریع**: کدنویسی در فضای ابری در ۲ دقیقه - به بخش [راه‌اندازی GitHub Codespaces](../../../02-SetupDevEnvironment) بروید - بدون نیاز به نصب محلی و با استفاده از مدل‌های GitHub!

> **علاقه‌مند به Azure OpenAI هستید؟** راهنمای [راه‌اندازی Azure OpenAI](getting-started-azure-openai.md) را ببینید که مراحل ایجاد یک منبع جدید Azure OpenAI را توضیح می‌دهد.

## آنچه خواهید آموخت

- راه‌اندازی یک محیط توسعه جاوا برای برنامه‌های هوش مصنوعی
- انتخاب و پیکربندی محیط توسعه مورد علاقه خود (اولویت با Codespaces ابری، کانتینر توسعه محلی، یا تنظیمات کامل محلی)
- آزمایش تنظیمات خود با اتصال به مدل‌های GitHub

## فهرست مطالب

- [آنچه خواهید آموخت](../../../02-SetupDevEnvironment)
- [مقدمه](../../../02-SetupDevEnvironment)
- [مرحله ۱: راه‌اندازی محیط توسعه](../../../02-SetupDevEnvironment)
  - [گزینه A: GitHub Codespaces (توصیه‌شده)](../../../02-SetupDevEnvironment)
  - [گزینه B: کانتینر توسعه محلی](../../../02-SetupDevEnvironment)
  - [گزینه C: استفاده از نصب محلی موجود](../../../02-SetupDevEnvironment)
- [مرحله ۲: ایجاد توکن دسترسی شخصی GitHub](../../../02-SetupDevEnvironment)
- [مرحله ۳: آزمایش تنظیمات](../../../02-SetupDevEnvironment)
- [رفع اشکال](../../../02-SetupDevEnvironment)
- [خلاصه](../../../02-SetupDevEnvironment)
- [مراحل بعدی](../../../02-SetupDevEnvironment)

## مقدمه

این فصل شما را در راه‌اندازی یک محیط توسعه راهنمایی می‌کند. ما از **مدل‌های GitHub** به عنوان مثال اصلی استفاده خواهیم کرد زیرا رایگان است، با یک حساب GitHub به راحتی راه‌اندازی می‌شود، نیازی به کارت اعتباری ندارد و دسترسی به مدل‌های مختلف برای آزمایش را فراهم می‌کند.

**نیازی به تنظیمات محلی نیست!** می‌توانید بلافاصله با استفاده از GitHub Codespaces که یک محیط توسعه کامل در مرورگر شما فراهم می‌کند، کدنویسی را شروع کنید.

<img src="./images/models.webp" alt="تصویر: مدل‌های GitHub" width="50%">

ما استفاده از [**مدل‌های GitHub**](https://github.com/marketplace?type=models) را برای این دوره توصیه می‌کنیم زیرا:
- **رایگان** برای شروع
- **آسان** برای راه‌اندازی با یک حساب GitHub
- **بدون نیاز به کارت اعتباری**
- **مدل‌های متعدد** برای آزمایش

> **توجه**: مدل‌های GitHub استفاده‌شده در این آموزش دارای محدودیت‌های رایگان زیر هستند:
> - ۱۵ درخواست در دقیقه (۱۵۰ درخواست در روز)
> - ~۸۰۰۰ کلمه ورودی، ~۴۰۰۰ کلمه خروجی در هر درخواست
> - ۵ درخواست همزمان
> 
> برای استفاده در تولید، به Azure AI Foundry Models با حساب Azure خود ارتقا دهید. کد شما نیازی به تغییر ندارد. مستندات [Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models) را ببینید.

## مرحله ۱: راه‌اندازی محیط توسعه

<a name="quick-start-cloud"></a>

ما یک کانتینر توسعه از پیش پیکربندی‌شده ایجاد کرده‌ایم تا زمان راه‌اندازی را به حداقل برسانیم و اطمینان حاصل کنیم که تمام ابزارهای لازم برای این دوره هوش مصنوعی مولد با جاوا را در اختیار دارید. روش توسعه مورد علاقه خود را انتخاب کنید:

### گزینه‌های راه‌اندازی محیط:

#### گزینه A: GitHub Codespaces (توصیه‌شده)

**شروع کدنویسی در ۲ دقیقه - بدون نیاز به تنظیمات محلی!**

1. این مخزن را به حساب GitHub خود فورک کنید.
   > **توجه**: اگر می‌خواهید تنظیمات پایه را ویرایش کنید، به [پیکربندی کانتینر توسعه](../../../.devcontainer/devcontainer.json) نگاهی بیندازید.
2. روی **Code** → تب **Codespaces** → **...** → **New with options...** کلیک کنید.
3. از تنظیمات پیش‌فرض استفاده کنید – این گزینه پیکربندی کانتینر توسعه را انتخاب می‌کند: **Generative AI Java Development Environment** که برای این دوره ایجاد شده است.
4. روی **Create codespace** کلیک کنید.
5. حدود ۲ دقیقه صبر کنید تا محیط آماده شود.
6. به [مرحله ۲: ایجاد توکن GitHub](../../../02-SetupDevEnvironment) بروید.

<img src="./images/codespaces.png" alt="تصویر: زیرمنوی Codespaces" width="50%">

<img src="./images/image.png" alt="تصویر: گزینه‌های جدید" width="50%">

<img src="./images/codespaces-create.png" alt="تصویر: گزینه‌های ایجاد Codespace" width="50%">

> **مزایای Codespaces**:
> - نیازی به نصب محلی نیست
> - روی هر دستگاهی با مرورگر کار می‌کند
> - از پیش پیکربندی‌شده با تمام ابزارها و وابستگی‌ها
> - ۶۰ ساعت رایگان در ماه برای حساب‌های شخصی
> - محیطی یکسان برای همه یادگیرندگان

#### گزینه B: کانتینر توسعه محلی

**برای توسعه‌دهندگانی که توسعه محلی با Docker را ترجیح می‌دهند**

1. این مخزن را به دستگاه محلی خود فورک و کلون کنید.
   > **توجه**: اگر می‌خواهید تنظیمات پایه را ویرایش کنید، به [پیکربندی کانتینر توسعه](../../../.devcontainer/devcontainer.json) نگاهی بیندازید.
2. [Docker Desktop](https://www.docker.com/products/docker-desktop/) و [VS Code](https://code.visualstudio.com/) را نصب کنید.
3. افزونه [Dev Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) را در VS Code نصب کنید.
4. پوشه مخزن را در VS Code باز کنید.
5. وقتی از شما خواسته شد، روی **Reopen in Container** کلیک کنید (یا از `Ctrl+Shift+P` → "Dev Containers: Reopen in Container" استفاده کنید).
6. منتظر بمانید تا کانتینر ساخته و راه‌اندازی شود.
7. به [مرحله ۲: ایجاد توکن GitHub](../../../02-SetupDevEnvironment) بروید.

<img src="./images/devcontainer.png" alt="تصویر: راه‌اندازی کانتینر توسعه" width="50%">

<img src="./images/image-3.png" alt="تصویر: ساخت کانتینر توسعه کامل شد" width="50%">

#### گزینه C: استفاده از نصب محلی موجود

**برای توسعه‌دهندگانی که محیط جاوای موجود دارند**

پیش‌نیازها:
- [جاوا ۲۱+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) یا IDE مورد علاقه شما

مراحل:
1. این مخزن را به دستگاه محلی خود کلون کنید.
2. پروژه را در IDE خود باز کنید.
3. به [مرحله ۲: ایجاد توکن GitHub](../../../02-SetupDevEnvironment) بروید.

> **نکته حرفه‌ای**: اگر دستگاه شما مشخصات پایینی دارد اما می‌خواهید از VS Code به صورت محلی استفاده کنید، از GitHub Codespaces استفاده کنید! می‌توانید VS Code محلی خود را به یک Codespace ابری متصل کنید و از بهترین امکانات هر دو بهره‌مند شوید.

<img src="./images/image-2.png" alt="تصویر: نمونه کانتینر توسعه محلی ایجاد شده" width="50%">

## مرحله ۲: ایجاد توکن دسترسی شخصی GitHub

1. به [تنظیمات GitHub](https://github.com/settings/profile) بروید و از منوی پروفایل خود **Settings** را انتخاب کنید.
2. در نوار کناری سمت چپ، روی **Developer settings** کلیک کنید (معمولاً در پایین قرار دارد).
3. زیر **Personal access tokens**، روی **Fine-grained tokens** کلیک کنید (یا از این [لینک مستقیم](https://github.com/settings/personal-access-tokens) استفاده کنید).
4. روی **Generate new token** کلیک کنید.
5. در قسمت "Token name"، یک نام توصیفی وارد کنید (مثلاً `GenAI-Java-Course-Token`).
6. یک تاریخ انقضا تنظیم کنید (توصیه‌شده: ۷ روز برای بهترین شیوه‌های امنیتی).
7. در قسمت "Resource owner"، حساب کاربری خود را انتخاب کنید.
8. در قسمت "Repository access"، مخازنی را که می‌خواهید با مدل‌های GitHub استفاده کنید انتخاب کنید (یا "All repositories" در صورت نیاز).
9. در قسمت "Repository permissions"، **Models** را پیدا کرده و روی **Read and write** تنظیم کنید.
10. روی **Generate token** کلیک کنید.
11. **توکن خود را اکنون کپی و ذخیره کنید** – دیگر نمی‌توانید آن را ببینید!

> **نکته امنیتی**: از کمترین محدوده مورد نیاز و کوتاه‌ترین زمان انقضای ممکن برای توکن‌های دسترسی خود استفاده کنید.

## مرحله ۳: آزمایش تنظیمات با مثال مدل‌های GitHub

وقتی محیط توسعه شما آماده شد، بیایید یکپارچگی مدل‌های GitHub را با برنامه نمونه ما در [`02-SetupDevEnvironment/examples/github-models`](../../../02-SetupDevEnvironment/examples/github-models) آزمایش کنیم.

1. ترمینال را در محیط توسعه خود باز کنید.
2. به مثال مدل‌های GitHub بروید:
   ```bash
   cd 02-SetupDevEnvironment/examples/github-models
   ```
3. توکن GitHub خود را به عنوان یک متغیر محیطی تنظیم کنید:
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. برنامه را اجرا کنید:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

باید خروجی مشابه زیر را ببینید:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### درک کد نمونه

ابتدا بیایید بفهمیم چه چیزی اجرا کردیم. مثال زیر `examples/github-models` از OpenAI Java SDK برای اتصال به مدل‌های GitHub استفاده می‌کند:

**این کد چه می‌کند:**
- **اتصال** به مدل‌های GitHub با استفاده از توکن دسترسی شخصی شما
- **ارسال** یک پیام ساده "Say Hello World!" به مدل هوش مصنوعی
- **دریافت** و نمایش پاسخ هوش مصنوعی
- **اعتبارسنجی** تنظیمات شما برای اطمینان از عملکرد صحیح

**وابستگی کلیدی** (در `pom.xml`):
```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

**کد اصلی** (`App.java`):
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

## خلاصه

عالی! اکنون همه چیز آماده است:

- یک توکن دسترسی شخصی GitHub با مجوزهای مناسب برای دسترسی به مدل‌های هوش مصنوعی ایجاد کردید.
- محیط توسعه جاوای خود را راه‌اندازی کردید (چه Codespaces، کانتینرهای توسعه یا محلی).
- با استفاده از OpenAI Java SDK به مدل‌های GitHub متصل شدید.
- همه چیز را با یک مثال ساده که با مدل‌های هوش مصنوعی صحبت می‌کند آزمایش کردید.

## مراحل بعدی

[فصل ۳: تکنیک‌های اصلی هوش مصنوعی مولد](../03-CoreGenerativeAITechniques/README.md)

## رفع اشکال

مشکلی دارید؟ در اینجا مشکلات رایج و راه‌حل‌ها آورده شده است:

- **توکن کار نمی‌کند؟** 
  - مطمئن شوید که کل توکن را بدون فاصله اضافی کپی کرده‌اید.
  - بررسی کنید که توکن به درستی به عنوان یک متغیر محیطی تنظیم شده است.
  - اطمینان حاصل کنید که توکن شما مجوزهای صحیح دارد (Models: Read and write).

- **Maven پیدا نشد؟** 
  - اگر از کانتینرهای توسعه/Codespaces استفاده می‌کنید، Maven باید از پیش نصب شده باشد.
  - برای تنظیمات محلی، مطمئن شوید که Java 21+ و Maven 3.9+ نصب شده‌اند.
  - با `mvn --version` نصب را بررسی کنید.

- **مشکلات اتصال؟** 
  - اتصال اینترنت خود را بررسی کنید.
  - اطمینان حاصل کنید که GitHub از شبکه شما قابل دسترسی است.
  - مطمئن شوید که پشت فایروالی نیستید که نقطه پایانی مدل‌های GitHub را مسدود می‌کند.

- **کانتینر توسعه راه‌اندازی نمی‌شود؟** 
  - مطمئن شوید که Docker Desktop در حال اجرا است (برای توسعه محلی).
  - کانتینر را دوباره بسازید: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container".

- **خطاهای کامپایل برنامه؟**
  - مطمئن شوید که در دایرکتوری صحیح هستید: `02-SetupDevEnvironment/examples/github-models`
  - سعی کنید پاکسازی و بازسازی کنید: `mvn clean compile`

> **نیاز به کمک دارید؟**: هنوز مشکلی دارید؟ یک issue در مخزن باز کنید و ما به شما کمک خواهیم کرد.

**سلب مسئولیت**:  
این سند با استفاده از سرویس ترجمه هوش مصنوعی [Co-op Translator](https://github.com/Azure/co-op-translator) ترجمه شده است. در حالی که ما برای دقت تلاش می‌کنیم، لطفاً توجه داشته باشید که ترجمه‌های خودکار ممکن است شامل خطاها یا نادرستی‌هایی باشند. سند اصلی به زبان اصلی آن باید به عنوان منبع معتبر در نظر گرفته شود. برای اطلاعات حساس، ترجمه حرفه‌ای انسانی توصیه می‌شود. ما هیچ مسئولیتی در قبال سوءتفاهم‌ها یا تفسیرهای نادرست ناشی از استفاده از این ترجمه نداریم.