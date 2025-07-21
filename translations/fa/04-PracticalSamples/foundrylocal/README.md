<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T16:36:26+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "fa"
}
-->
# برنامه خط فرمان Foundry Local

> **توجه**: این فصل شامل یک [**آموزش**](./TUTORIAL.md) است که شما را در اجرای نمونه‌های تکمیل‌شده راهنمایی می‌کند.

یک برنامه ساده Spring Boot خط فرمان که نشان می‌دهد چگونه می‌توان با استفاده از OpenAI Java SDK به Foundry Local متصل شد.

## آنچه یاد خواهید گرفت

- نحوه ادغام Foundry Local با برنامه‌های Spring Boot با استفاده از OpenAI Java SDK
- بهترین روش‌ها برای توسعه و آزمایش هوش مصنوعی به صورت محلی

## فهرست مطالب

- [آنچه یاد خواهید گرفت](../../../../04-PracticalSamples/foundrylocal)
- [پیش‌نیازها](../../../../04-PracticalSamples/foundrylocal)
  - [نصب Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [تأیید](../../../../04-PracticalSamples/foundrylocal)
- [پیکربندی](../../../../04-PracticalSamples/foundrylocal)
- [شروع سریع](../../../../04-PracticalSamples/foundrylocal)
- [برنامه چه کاری انجام می‌دهد](../../../../04-PracticalSamples/foundrylocal)
- [خروجی نمونه](../../../../04-PracticalSamples/foundrylocal)
- [معماری](../../../../04-PracticalSamples/foundrylocal)
- [نکات برجسته کد](../../../../04-PracticalSamples/foundrylocal)
  - [ادغام OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [API تکمیل چت](../../../../04-PracticalSamples/foundrylocal)
- [عیب‌یابی](../../../../04-PracticalSamples/foundrylocal)

## پیش‌نیازها

> **⚠️ توجه**: این برنامه **در devcontainer ارائه‌شده اجرا نمی‌شود** زیرا نیاز به نصب و اجرای Foundry Local روی سیستم میزبان دارد.

### نصب Foundry Local

قبل از اجرای این برنامه، باید Foundry Local را نصب و راه‌اندازی کنید. مراحل زیر را دنبال کنید:

1. **اطمینان حاصل کنید که سیستم شما الزامات را برآورده می‌کند**:
   - **سیستم‌عامل**: ویندوز 10 (x64)، ویندوز 11 (x64/ARM)، ویندوز سرور 2025، یا macOS
   - **سخت‌افزار**: 
     - حداقل: 8 گیگابایت رم، 3 گیگابایت فضای دیسک آزاد
     - پیشنهادی: 16 گیگابایت رم، 15 گیگابایت فضای دیسک آزاد
   - **شبکه**: اتصال به اینترنت برای دانلود اولیه مدل (اختیاری برای استفاده آفلاین)
   - **شتاب‌دهنده (اختیاری)**: کارت گرافیک NVIDIA (سری 2000 یا جدیدتر)، کارت گرافیک AMD (سری 6000 یا جدیدتر)، Qualcomm Snapdragon X Elite (با حداقل 8 گیگابایت حافظه)، یا Apple silicon
   - **مجوزها**: دسترسی مدیریتی برای نصب نرم‌افزار روی دستگاه شما

2. **Foundry Local را نصب کنید**:
   
   **برای ویندوز:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **برای macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   همچنین می‌توانید نصب‌کننده را از [مخزن GitHub Foundry Local](https://github.com/microsoft/Foundry-Local) دانلود کنید.

3. **اولین مدل خود را اجرا کنید**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   مدل دانلود می‌شود (که بسته به سرعت اینترنت شما ممکن است چند دقیقه طول بکشد) و سپس اجرا می‌شود. Foundry Local به طور خودکار بهترین نسخه مدل را برای سیستم شما انتخاب می‌کند (CUDA برای کارت‌های گرافیک NVIDIA، نسخه CPU در غیر این صورت).

4. **مدل را آزمایش کنید** با پرسیدن یک سؤال در همان ترمینال:

   ```bash
   Why is the sky blue?
   ```

   باید پاسخی از مدل Phi دریافت کنید که توضیح می‌دهد چرا آسمان آبی به نظر می‌رسد.

### تأیید

می‌توانید با این دستورات تأیید کنید که همه چیز به درستی کار می‌کند:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

همچنین می‌توانید به `http://localhost:5273` در مرورگر خود مراجعه کنید تا رابط وب Foundry Local را مشاهده کنید.

## پیکربندی

برنامه می‌تواند از طریق فایل `application.properties` پیکربندی شود:

- `foundry.local.base-url` - آدرس پایه برای Foundry Local (پیش‌فرض: http://localhost:5273)
- `foundry.local.model` - مدل هوش مصنوعی مورد استفاده (پیش‌فرض: Phi-3.5-mini-instruct-cuda-gpu)

> **توجه**: نام مدل در پیکربندی باید با نسخه خاصی که Foundry Local برای سیستم شما دانلود کرده است مطابقت داشته باشد. وقتی `foundry model run phi-3.5-mini` را اجرا می‌کنید، Foundry Local به طور خودکار بهترین نسخه را انتخاب و دانلود می‌کند (CUDA برای کارت‌های گرافیک NVIDIA، نسخه CPU در غیر این صورت). از `foundry model list` استفاده کنید تا نام دقیق مدل موجود در نمونه محلی خود را ببینید.

## شروع سریع

### 1. به دایرکتوری برنامه Foundry Local بروید
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. برنامه را اجرا کنید

```bash
mvn spring-boot:run
```

یا فایل JAR را بسازید و اجرا کنید:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### وابستگی‌ها

این برنامه از OpenAI Java SDK برای ارتباط با Foundry Local استفاده می‌کند. وابستگی کلیدی عبارت است از:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

برنامه به طور پیش‌فرض برای اتصال به Foundry Local که روی پورت پیش‌فرض اجرا می‌شود، پیکربندی شده است.

## برنامه چه کاری انجام می‌دهد

وقتی برنامه را اجرا می‌کنید:

1. **به عنوان یک برنامه خط فرمان** راه‌اندازی می‌شود (بدون سرور وب)
2. **به طور خودکار یک پیام آزمایشی ارسال می‌کند**: "سلام! می‌توانید بگویید که چه هستید و چه مدلی را اجرا می‌کنید؟"
3. **پاسخ را از Foundry Local** در کنسول نمایش می‌دهد
4. **پس از نمایش دمو به طور تمیز خارج می‌شود**

## خروجی نمونه

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## معماری

- **Application.java** - برنامه اصلی Spring Boot با CommandLineRunner
- **FoundryLocalService.java** - سرویسی که از OpenAI Java SDK برای ارتباط با Foundry Local استفاده می‌کند
- استفاده از **OpenAI Java SDK** برای فراخوانی‌های API نوع-ایمن
- سریال‌سازی/دی‌سریال‌سازی خودکار JSON که توسط SDK مدیریت می‌شود
- پیکربندی تمیز با استفاده از انوتیشن‌های `@Value` و `@PostConstruct` در Spring

## نکات برجسته کد

### ادغام OpenAI Java SDK

برنامه از OpenAI Java SDK برای ایجاد یک کلاینت پیکربندی‌شده برای Foundry Local استفاده می‌کند:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### API تکمیل چت

ارسال درخواست‌های تکمیل چت ساده و نوع-ایمن است:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## عیب‌یابی

اگر با خطاهای اتصال مواجه شدید:
1. اطمینان حاصل کنید که Foundry Local روی `http://localhost:5273` اجرا می‌شود
2. بررسی کنید که یک نسخه از مدل Phi-3.5-mini با `foundry model list` در دسترس باشد
3. مطمئن شوید که نام مدل در `application.properties` با نام دقیق مدل موجود در لیست مطابقت دارد
4. اطمینان حاصل کنید که هیچ فایروالی اتصال را مسدود نمی‌کند

مشکلات رایج:
- **مدل یافت نشد**: دستور `foundry model run phi-3.5-mini` را اجرا کنید تا مدل دانلود و اجرا شود
- **سرویس اجرا نمی‌شود**: ممکن است سرویس Foundry Local متوقف شده باشد؛ آن را با دستور اجرای مدل مجدداً راه‌اندازی کنید
- **نام مدل اشتباه است**: از `foundry model list` استفاده کنید تا مدل‌های موجود را ببینید و پیکربندی خود را به‌روزرسانی کنید

**سلب مسئولیت**:  
این سند با استفاده از سرویس ترجمه هوش مصنوعی [Co-op Translator](https://github.com/Azure/co-op-translator) ترجمه شده است. در حالی که ما برای دقت تلاش می‌کنیم، لطفاً توجه داشته باشید که ترجمه‌های خودکار ممکن است شامل خطاها یا نادرستی‌هایی باشند. سند اصلی به زبان اصلی آن باید به عنوان منبع معتبر در نظر گرفته شود. برای اطلاعات حساس، ترجمه انسانی حرفه‌ای توصیه می‌شود. ما هیچ مسئولیتی در قبال سوءتفاهم‌ها یا تفسیرهای نادرست ناشی از استفاده از این ترجمه نداریم.