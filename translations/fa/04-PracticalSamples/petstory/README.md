<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T08:52:10+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "fa"
}
-->
# اپلیکیشن داستان حیوان خانگی

>**توجه**: این فصل شامل یک [**آموزش**](./TUTORIAL.md) است که شما را در نمونه‌ها راهنمایی می‌کند.

یک اپلیکیشن وب Spring Boot که با استفاده از مدل‌های GitHub، توضیحات و داستان‌های مبتنی بر هوش مصنوعی برای تصاویر حیوانات خانگی آپلود شده تولید می‌کند.

## فهرست مطالب

- [پشته فناوری](../../../../04-PracticalSamples/petstory)
- [پیش‌نیازها](../../../../04-PracticalSamples/petstory)
- [راه‌اندازی و نصب](../../../../04-PracticalSamples/petstory)
- [نحوه استفاده](../../../../04-PracticalSamples/petstory)

## پشته فناوری

- **بک‌اند**: Spring Boot 3.5.3، Java 21
- **ادغام هوش مصنوعی**: OpenAI Java SDK با مدل‌های GitHub
- **امنیت**: Spring Security
- **فرانت‌اند**: قالب‌های Thymeleaf با استایل‌دهی Bootstrap
- **ابزار ساخت**: Maven
- **مدل‌های هوش مصنوعی**: مدل‌های GitHub

## پیش‌نیازها

- Java 21 یا بالاتر
- Maven 3.9+
- توکن دسترسی شخصی GitHub با دسترسی `models:read`

## راه‌اندازی و نصب

### 1. به دایرکتوری اپلیکیشن petstory بروید
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. تنظیم متغیر محیطی
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. ساخت اپلیکیشن
```bash
mvn clean compile
```

### 4. اجرای اپلیکیشن
```bash
mvn spring-boot:run
```

## نحوه استفاده

1. **دسترسی به اپلیکیشن**: به آدرس `http://localhost:8080` بروید
2. **آپلود تصویر**: روی "Choose File" کلیک کنید و یک تصویر حیوان خانگی انتخاب کنید
3. **تحلیل تصویر**: روی "Analyze Image" کلیک کنید تا توضیحات هوش مصنوعی دریافت شود
4. **ایجاد داستان**: روی "Generate Story" کلیک کنید تا داستان ساخته شود

**سلب مسئولیت**:  
این سند با استفاده از سرویس ترجمه هوش مصنوعی [Co-op Translator](https://github.com/Azure/co-op-translator) ترجمه شده است. در حالی که ما تلاش می‌کنیم دقت را حفظ کنیم، لطفاً توجه داشته باشید که ترجمه‌های خودکار ممکن است شامل خطاها یا نادرستی‌ها باشند. سند اصلی به زبان اصلی آن باید به عنوان منبع معتبر در نظر گرفته شود. برای اطلاعات حساس، توصیه می‌شود از ترجمه حرفه‌ای انسانی استفاده کنید. ما مسئولیتی در قبال سوء تفاهم‌ها یا تفسیرهای نادرست ناشی از استفاده از این ترجمه نداریم.