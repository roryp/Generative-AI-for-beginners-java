# آموزش محلی Foundry Spring Boot

## فهرست مطالب

- [پیش‌نیازها](#پیش‌نیازها)
- [بررسی پروژه](#بررسی-پروژه)
- [درک کد](#درک-کد)
  - [1. پیکربندی برنامه (application.properties)](#1-پیکربندی-برنامه-applicationproperties)
  - [2. کلاس اصلی برنامه (Application.java)](#2-کلاس-اصلی-برنامه-applicationjava)
  - [3. لایه سرویس هوش مصنوعی (FoundryLocalService.java)](#3-لایه-سرویس-هوش-مصنوعی-foundrylocalservicejava)
  - [4. وابستگی‌های پروژه (pom.xml)](#4-وابستگی‌های-پروژه-pomxml)
- [نحوه کارکرد کلی](#نحوه-کارکرد-کلی)
- [راه‌اندازی Foundry Local](#راه‌اندازی-foundry-local)
- [اجرای برنامه](#اجرای-برنامه)
- [خروجی مورد انتظار](#خروجی-مورد-انتظار)
- [گام‌های بعدی](#گام‌های-بعدی)
- [عیب‌یابی](#عیب‌یابی)


## پیش‌نیازها

قبل از شروع این آموزش، مطمئن شوید که:

- **جاوا نسخه 21 یا بالاتر** روی سیستم شما نصب شده باشد
- **مِیون نسخه 3.6+** برای ساخت پروژه موجود باشد
- **Foundry Local** نصب و در حال اجرا باشد

### **نصب Foundry Local:**

> **توجه:** رابط خط فرمان Foundry Local فقط روی **ویندوز** و **macOS** در دسترس است. لینوکس از طریق [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (پایتون، جاوااسکریپت، C#، راست) پشتیبانی می‌شود.

```bash
# ویندوز
winget install Microsoft.FoundryLocal

# مک او اس
brew tap microsoft/foundrylocal
brew install foundrylocal
```

نصب را بررسی کنید:
```bash
foundry --version
```

## بررسی پروژه

این پروژه از چهار جزء اصلی تشکیل شده است:

1. **Application.java** - نقطه ورود اصلی برنامه Spring Boot
2. **FoundryLocalService.java** - لایه سرویس که ارتباط با هوش مصنوعی را مدیریت می‌کند
3. **application.properties** - پیکربندی اتصال Foundry Local
4. **pom.xml** - وابستگی‌ها و پیکربندی پروژه برای مِیون

## درک کد

### 1. پیکربندی برنامه (application.properties)

**فایل:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**این بخش چه کاری انجام می‌دهد:**
- **base-url**: مشخص می‌کند Foundry Local کجا در حال اجراست، شامل مسیر `/v1` برای سازگاری با API OpenAI. پورت پیش‌فرض `5273` است. اگر پورت فرق دارد، با `foundry service status` آن را بررسی کنید.
- **model** (اختیاری): نام مدل هوش مصنوعی که برای تولید متن استفاده می‌شود. **به طور پیش‌فرض، برنامه مدل را به صورت خودکار با پرس‌وجو از نقطه انتهایی `/v1/models` در Foundry Local هنگام شروع تشخیص می‌دهد، بنابراین نیازی به تنظیم دستی نیست. با این حال، می‌توانید در صورت نیاز آن را به صورت صریح تنظیم کنید تا تشخیص خودکار را نادیده بگیرد.**

**مفهوم کلیدی:** Spring Boot به طور خودکار این پراپرتی‌ها را بارگذاری می‌کند و با استفاده از انوتیشن `@Value` در دسترس برنامه شما قرار می‌دهد.

### 2. کلاس اصلی برنامه (Application.java)

**فایل:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // نیازی به سرور وب نیست
        app.run(args);
    }
```

**این بخش چه کاری انجام می‌دهد:**
- `@SpringBootApplication` فعال‌سازی پیکربندی خودکار Spring Boot
- `WebApplicationType.NONE` به Spring می‌گوید این یک برنامه خط فرمان است، نه یک وب سرور
- متد main برنامه Spring را راه‌اندازی می‌کند

**اجرای نمونه دمو:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        System.out.println("Calling Foundry Local service...");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
        System.out.println("=========================");
    };
}
```

**این بخش چه کاری انجام می‌دهد:**
- `@Bean` یک کامپوننت ایجاد می‌کند که توسط Spring مدیریت می‌شود
- `CommandLineRunner` کد را پس از شروع Spring Boot اجرا می‌کند
- `foundryLocalService` به طور خودکار توسط Spring تزریق می‌شود (تزریق وابستگی)
- یک پیام تست به هوش مصنوعی ارسال می‌کند و پاسخ آن را نمایش می‌دهد

### 3. لایه سرویس هوش مصنوعی (FoundryLocalService.java)

**فایل:** `src/main/java/com/example/FoundryLocalService.java`

#### تزریق پیکربندی:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // اگر خالی باشد، به‌طور خودکار تشخیص داده شد
```

**این بخش چه کاری انجام می‌دهد:**
- `@Service` به Spring می‌گوید این کلاس منطق کسب‌وکار را ارائه می‌دهد
- `@Value` مقادیر پیکربندی از `application.properties` را تزریق می‌کند
- مقدار مدل به صورت پیش‌فرض خالی است که باعث **تشخیص خودکار** از Foundry Local هنگام راه‌اندازی می‌شود. یعنی برنامه با هر مدل بارگذاری شده در Foundry Local بدون پیکربندی دستی کار می‌کند.

#### مقداردهی اولیه کلاینت:
```java
@PostConstruct
public void init() {
    // اگر صراحتاً پیکربندی نشده بود، مدل را به‌صورت خودکار از Foundry Local شناسایی کنید
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // آدرس پایه از قبل شامل /v1 از پیکربندی است
            .apiKey("not-needed")            // سرور محلی به کلید API واقعی نیاز ندارد
            .build();
}
```

**این بخش چه کاری انجام می‌دهد:**
- `@PostConstruct` این متد را بعد از ایجاد سرویس توسط Spring اجرا می‌کند
- اگر مدلی تنظیم نشده باشد، از نقطه انتهایی `/v1/models` در Foundry Local پرس‌وجو می‌کند و اولین مدل موجود را انتخاب می‌کند
- یک کلاینت OpenAI ایجاد می‌کند که به نمونه محلی Foundry Local شما اشاره دارد
- URL پایه از `application.properties` شامل `/v1` برای سازگاری با API OpenAI است
- کلید API به "not-needed" تنظیم شده چون توسعه محلی نیازی به احراز هویت ندارد

#### متد چت:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // کدام مدل هوش مصنوعی استفاده شود
                .addUserMessage(message)         // سوال/درخواست شما
                .maxCompletionTokens(150)        // محدودیت در طول پاسخ
                .temperature(0.7)                // کنترل خلاقیت (۰.۰ تا ۱.۰)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // استخراج پاسخ هوش مصنوعی از نتیجه API
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**این بخش چه کاری انجام می‌دهد:**
- **ChatCompletionCreateParams**: درخواست هوش مصنوعی را پیکربندی می‌کند
  - `model`: مشخص می‌کند از کدام مدل هوش مصنوعی استفاده شود (باید دقیقاً شناسه مدل از `foundry model list` باشد)
  - `addUserMessage`: پیام شما را به مکالمه اضافه می‌کند
  - `maxCompletionTokens`: محدودیت طول پاسخ (صرفه‌جویی در منابع)
  - `temperature`: کنترل میزان تصادفی بودن (۰.۰=قطعی، ۱.۰=خلاق)
- **فرخوان API**: درخواست را به Foundry Local می‌فرستد
- **پردازش پاسخ**: پاسخ متنی هوش مصنوعی را به صورت ایمن استخراج می‌کند
- **مدیریت خطا**: استثناها را با پیام‌های خطای مفید می‌پوشاند

### 4. وابستگی‌های پروژه (pom.xml)

**وابستگی‌های کلیدی:**

```xml
<!-- Spring Boot - Application framework -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>${spring-boot.version}</version>
</dependency>

<!-- OpenAI Java SDK - For AI API calls -->
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>

<!-- Jackson - JSON processing -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.0</version>
</dependency>
```

**این‌ها چه کار می‌کنند:**
- **spring-boot-starter**: عملکردهای اصلی Spring Boot را فراهم می‌آورد
- **openai-java**: SDK رسمی OpenAI برای جاوا برای ارتباط با API
- **jackson-databind**: مدیریت سریال‌سازی و سریال‌زدایی JSON برای فراخوانی API

## نحوه کارکرد کلی

جریان کامل هنگام اجرای برنامه به این صورت است:

1. **راه‌اندازی:** Spring Boot شروع می‌شود و `application.properties` را می‌خواند
2. **ایجاد سرویس:** Spring سرویس `FoundryLocalService` را می‌سازد و مقادیر پیکربندی را تزریق می‌کند
3. **تشخیص مدل:** اگر مدلی تنظیم نشده باشد، سرویس از نقطه انتهایی `/v1/models` در Foundry Local پرس‌وجو می‌کند و اولین مدل موجود را به صورت خودکار استفاده می‌کند
4. **تنظیم کلاینت:** `@PostConstruct` کلاینت OpenAI را برای اتصال به Foundry Local مقداردهی اولیه می‌کند
5. **اجرای دمو:** `CommandLineRunner` پس از شروع اجرا می‌شود
6. **فراخوانی هوش مصنوعی:** دمو متد `foundryLocalService.chat()` را با یک پیام تستی فراخوانی می‌کند
7. **درخواست API:** سرویس درخواست سازگار با OpenAI را به Foundry Local ارسال می‌کند
8. **پردازش پاسخ:** سرویس پاسخ هوش مصنوعی را استخراج و برمی‌گرداند
9. **نمایش:** برنامه پاسخ را چاپ کرده و خارج می‌شود

## راه‌اندازی Foundry Local

1. **Foundry Local را نصب کنید** با دستورالعمل‌های بخش [پیش‌نیازها](#پیش‌نیازها).

2. **خدمات را راه‌اندازی کنید** (اگر در حال حاضر اجرا نیست):
   ```bash
   foundry service start
   ```

3. **وضعیت سرویس را بررسی کنید** تا مطمئن شوید که در حال اجرا است و پورت آن را یادداشت کنید:
   ```bash
   foundry service status
   ```

4. **یک مدل را دانلود و اجرا کنید** (مدل در اولین اجرا دانلود می‌شود و برای اجراهای بعدی کش می‌شود):
   ```bash
   foundry model run phi-4-mini
   ```
   این یک جلسه چت تعاملی باز می‌کند. می‌توانید با `Ctrl+C` خارج شوید. مدل همچنان در سرویس بارگذاری می‌ماند.

   > **نکته:** دستور `foundry model list` را اجرا کنید تا همه مدل‌های موجود را ببینید. به جای `phi-4-mini` می‌توانید هر نام مستعار دیگری از کاتالوگ استفاده کنید (مثلاً `qwen2.5-0.5b` برای مدل کوچکتر و سریع‌تر).

5. **بررسی کنید که مدل بارگذاری شده است:**
   ```bash
   foundry service ps
   ```

6. **اگر لازم است، `application.properties` را به‌روزرسانی کنید:**
   - `base-url` پیش‌فرض (`http://localhost:5273/v1`) با پورت پیش‌فرض CLI مطابقت دارد. فقط اگر `foundry service status` پورت متفاوتی نشان داد، بروزرسانی کنید.
   - مدل به صورت خودکار در زمان راه‌اندازی شناسایی می‌شود — نیازی به پیکربندی دستی نیست.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## اجرای برنامه

### گام 1: مطمئن شوید مدلی در Foundry Local بارگذاری شده است
```bash
foundry service ps
```
اگر مدلی فهرست نشده بود، یک مدل بارگذاری کنید:
```bash
foundry model run phi-4-mini
```

### گام 2: ساخت و اجرای برنامه
در ترمینال جدید:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

یا به صورت فایل JAR بسازید و اجرا کنید:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## خروجی مورد انتظار

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## گام‌های بعدی

برای مثال‌های بیشتر، بخش [فصل 04: نمونه‌های عملی](../README.md) را ببینید

## عیب‌یابی

### مشکلات رایج

**"Connection refused" یا "Service unavailable"**
- سرویس را بررسی کنید: `foundry service status`
- در صورت نیاز راه‌اندازی مجدد: `foundry service restart`
- پورت در `application.properties` باید با خروجی `foundry service status` مطابقت داشته باشد
- مطمئن شوید URL به `/v1` ختم می‌شود: `http://localhost:5273/v1`

**"No model found" هنگام راه‌اندازی**
- برنامه مدل را خودکار تشخیص می‌دهد. مطمئن شوید حداقل یک مدل بارگذاری شده است: `foundry service ps`
- اگر مدلی بارگذاری نشده: `foundry model run phi-4-mini`
- اگر نام مدل را در `application.properties` تغییر داده‌اید، مطمئن شوید با خروجی `foundry model list` مطابقت دارد

**خطاهای "400 Bad Request"**
- مطمئن شوید URL پایه شامل `/v1` است: `http://localhost:5273/v1`
- اطمینان حاصل کنید از متد `maxCompletionTokens()` در کد استفاده می‌کنید (نه متد منسوخ `maxTokens()`)

**خطاهای کامپایل مِیون**
- مطمئن شوید جاوا 21 یا بالاتر است: `java -version`
- پاکسازی و بازسازی: `mvn clean compile`
- اتصال اینترنت برای دانلود وابستگی‌ها را بررسی کنید

**مشکلات اتصال به سرویس**
- اگر پیام `Request to local service failed` را دیدید، سرویس را راه‌اندازی مجدد کنید: `foundry service restart`
- مدل‌های بارگذاری شده را بررسی کنید: `foundry service ps`
- لاگ‌های سرویس را مشاهده کنید: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**سلب مسئولیت**:  
این سند با استفاده از سرویس ترجمه هوش مصنوعی [Co-op Translator](https://github.com/Azure/co-op-translator) ترجمه شده است. در حالی که ما برای دقت تلاش می‌کنیم، لطفاً توجه داشته باشید که ترجمه‌های خودکار ممکن است حاوی خطاها یا نادرستی‌هایی باشند. سند اصلی به زبان مادری خود باید به عنوان منبع معتبر در نظر گرفته شود. برای اطلاعات حیاتی، ترجمه حرفه‌ای انسانی توصیه می‌شود. ما در قبال هرگونه سوءتفاهم یا تفسیر نادرست ناشی از استفاده از این ترجمه مسئولیتی نداریم.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->