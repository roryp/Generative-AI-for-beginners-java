<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2284c54d2a98090a37df0dbef1633ebf",
  "translation_date": "2025-07-21T16:41:15+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/TUTORIAL.md",
  "language_code": "fa"
}
-->
# آموزش Foundry Local Spring Boot

## فهرست مطالب

- [پیش‌نیازها](../../../../04-PracticalSamples/foundrylocal)
- [نمای کلی پروژه](../../../../04-PracticalSamples/foundrylocal)
- [درک کد](../../../../04-PracticalSamples/foundrylocal)
  - [1. تنظیمات برنامه (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. کلاس اصلی برنامه (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. لایه سرویس هوش مصنوعی (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. وابستگی‌های پروژه (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [چگونگی عملکرد کلی](../../../../04-PracticalSamples/foundrylocal)
- [راه‌اندازی Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [اجرای برنامه](../../../../04-PracticalSamples/foundrylocal)
- [خروجی مورد انتظار](../../../../04-PracticalSamples/foundrylocal)
- [گام‌های بعدی](../../../../04-PracticalSamples/foundrylocal)
- [رفع اشکال](../../../../04-PracticalSamples/foundrylocal)

## پیش‌نیازها

قبل از شروع این آموزش، مطمئن شوید که موارد زیر را دارید:

- **Java 21 یا بالاتر** روی سیستم شما نصب شده باشد
- **Maven 3.6+** برای ساخت پروژه
- **Foundry Local** نصب و در حال اجرا باشد

### **نصب Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## نمای کلی پروژه

این پروژه شامل چهار بخش اصلی است:

1. **Application.java** - نقطه ورود اصلی برنامه Spring Boot
2. **FoundryLocalService.java** - لایه سرویس که ارتباط با هوش مصنوعی را مدیریت می‌کند
3. **application.properties** - تنظیمات اتصال به Foundry Local
4. **pom.xml** - وابستگی‌های Maven و تنظیمات پروژه

## درک کد

### 1. تنظیمات برنامه (application.properties)

**فایل:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu
```

**عملکرد این بخش:**
- **base-url**: مشخص می‌کند Foundry Local در کجا اجرا می‌شود (پورت پیش‌فرض 5273)
- **model**: نام مدل هوش مصنوعی برای تولید متن را تعیین می‌کند

**مفهوم کلیدی:** Spring Boot این تنظیمات را به صورت خودکار بارگذاری کرده و با استفاده از annotation `@Value` در دسترس برنامه قرار می‌دهد.

### 2. کلاس اصلی برنامه (Application.java)

**فایل:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```

**عملکرد این بخش:**
- `@SpringBootApplication` پیکربندی خودکار Spring Boot را فعال می‌کند
- `WebApplicationType.NONE` به Spring اعلام می‌کند که این یک برنامه خط فرمان است، نه یک سرور وب
- متد اصلی برنامه Spring را راه‌اندازی می‌کند

**اجرای دمو:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
    };
}
```

**عملکرد این بخش:**
- `@Bean` یک کامپوننت ایجاد می‌کند که توسط Spring مدیریت می‌شود
- `CommandLineRunner` کدی را پس از راه‌اندازی Spring Boot اجرا می‌کند
- `foundryLocalService` به صورت خودکار توسط Spring تزریق می‌شود (تزریق وابستگی)
- یک پیام آزمایشی به هوش مصنوعی ارسال کرده و پاسخ را نمایش می‌دهد

### 3. لایه سرویس هوش مصنوعی (FoundryLocalService.java)

**فایل:** `src/main/java/com/example/FoundryLocalService.java`

#### تزریق تنظیمات:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu}")
    private String model;
```

**عملکرد این بخش:**
- `@Service` به Spring اعلام می‌کند که این کلاس منطق تجاری ارائه می‌دهد
- `@Value` مقادیر تنظیمات را از application.properties تزریق می‌کند
- نحو `:default-value` مقادیر پیش‌فرض را در صورت عدم تنظیم فراهم می‌کند

#### راه‌اندازی کلاینت:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")        // Foundry Local uses OpenAI-compatible API
            .apiKey("unused")                 // Local server doesn't need real API key
            .build();
}
```

**عملکرد این بخش:**
- `@PostConstruct` این متد را پس از ایجاد سرویس توسط Spring اجرا می‌کند
- یک کلاینت OpenAI ایجاد می‌کند که به نمونه Foundry Local شما اشاره دارد
- مسیر `/v1` برای سازگاری با API OpenAI ضروری است
- کلید API "unused" است زیرا توسعه محلی نیازی به احراز هویت ندارد

#### متد چت:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Which AI model to use
                .addUserMessage(message)         // Your question/prompt
                .maxCompletionTokens(150)        // Limit response length
                .temperature(0.7)                // Control creativity (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extract the AI's response from the API result
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**عملکرد این بخش:**
- **ChatCompletionCreateParams**: درخواست هوش مصنوعی را پیکربندی می‌کند
  - `model`: مشخص می‌کند کدام مدل هوش مصنوعی استفاده شود
  - `addUserMessage`: پیام شما را به مکالمه اضافه می‌کند
  - `maxCompletionTokens`: طول پاسخ را محدود می‌کند (صرفه‌جویی در منابع)
  - `temperature`: میزان تصادفی بودن را کنترل می‌کند (0.0 = قطعی، 1.0 = خلاقانه)
- **API Call**: درخواست را به Foundry Local ارسال می‌کند
- **Response Handling**: پاسخ متنی هوش مصنوعی را به صورت ایمن استخراج می‌کند
- **Error Handling**: استثناها را با پیام‌های خطای مفید بسته‌بندی می‌کند

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

**عملکرد این بخش‌ها:**
- **spring-boot-starter**: قابلیت‌های اصلی Spring Boot را فراهم می‌کند
- **openai-java**: SDK رسمی OpenAI برای ارتباط با API
- **jackson-databind**: مدیریت سریال‌سازی/دی‌سریال‌سازی JSON برای درخواست‌های API

## چگونگی عملکرد کلی

جریان کامل زمانی که برنامه را اجرا می‌کنید به این صورت است:

1. **راه‌اندازی**: Spring Boot شروع به کار کرده و `application.properties` را می‌خواند
2. **ایجاد سرویس**: Spring سرویس `FoundryLocalService` را ایجاد کرده و مقادیر تنظیمات را تزریق می‌کند
3. **تنظیم کلاینت**: `@PostConstruct` کلاینت OpenAI را برای اتصال به Foundry Local راه‌اندازی می‌کند
4. **اجرای دمو**: `CommandLineRunner` پس از راه‌اندازی اجرا می‌شود
5. **تماس با هوش مصنوعی**: دمو متد `foundryLocalService.chat()` را با یک پیام آزمایشی فراخوانی می‌کند
6. **درخواست API**: سرویس درخواست سازگار با OpenAI را به Foundry Local ارسال می‌کند
7. **پردازش پاسخ**: سرویس پاسخ هوش مصنوعی را استخراج کرده و برمی‌گرداند
8. **نمایش**: برنامه پاسخ را چاپ کرده و خاتمه می‌یابد

## راه‌اندازی Foundry Local

برای راه‌اندازی Foundry Local، مراحل زیر را دنبال کنید:

1. **Foundry Local را نصب کنید** با استفاده از دستورالعمل‌های بخش [پیش‌نیازها](../../../../04-PracticalSamples/foundrylocal).
2. **مدل هوش مصنوعی مورد نظر** را دانلود کنید، به عنوان مثال، `phi-3.5-mini`، با دستور زیر:
   ```bash
   foundry model run phi-3.5-mini
   ```
3. **فایل application.properties** را مطابق تنظیمات Foundry Local خود پیکربندی کنید، به خصوص اگر از پورت یا مدل دیگری استفاده می‌کنید.

## اجرای برنامه

### مرحله 1: Foundry Local را راه‌اندازی کنید
```bash
foundry model run phi-3.5-mini
```

### مرحله 2: برنامه را بسازید و اجرا کنید
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
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```

## گام‌های بعدی

برای مثال‌های بیشتر، به [فصل 04: نمونه‌های عملی](../README.md) مراجعه کنید.

## رفع اشکال

### مشکلات رایج

**"اتصال رد شد" یا "سرویس در دسترس نیست"**
- مطمئن شوید Foundry Local در حال اجرا است: `foundry model list`
- بررسی کنید که سرویس روی پورت 5273 باشد: تنظیمات `application.properties` را چک کنید
- Foundry Local را مجدداً راه‌اندازی کنید: `foundry model run phi-3.5-mini`

**خطاهای "مدل یافت نشد"**
- مدل‌های موجود را بررسی کنید: `foundry model list`
- نام مدل را در `application.properties` دقیقاً به‌روزرسانی کنید
- در صورت نیاز مدل را دانلود کنید: `foundry model run phi-3.5-mini`

**خطاهای کامپایل Maven**
- مطمئن شوید Java 21 یا بالاتر نصب شده است: `java -version`
- پاکسازی و بازسازی کنید: `mvn clean compile`
- اتصال اینترنت را برای دانلود وابستگی‌ها بررسی کنید

**برنامه اجرا می‌شود اما خروجی ندارد**
- مطمئن شوید Foundry Local پاسخ می‌دهد: مرورگر را به `http://localhost:5273` باز کنید
- لاگ‌های برنامه را برای پیام‌های خطای خاص بررسی کنید
- مطمئن شوید مدل به طور کامل بارگذاری شده و آماده است

**سلب مسئولیت**:  
این سند با استفاده از سرویس ترجمه هوش مصنوعی [Co-op Translator](https://github.com/Azure/co-op-translator) ترجمه شده است. در حالی که ما تلاش می‌کنیم دقت را حفظ کنیم، لطفاً توجه داشته باشید که ترجمه‌های خودکار ممکن است شامل خطاها یا نادرستی‌ها باشند. سند اصلی به زبان اصلی آن باید به عنوان منبع معتبر در نظر گرفته شود. برای اطلاعات حساس، توصیه می‌شود از ترجمه حرفه‌ای انسانی استفاده کنید. ما مسئولیتی در قبال سوء تفاهم‌ها یا تفسیرهای نادرست ناشی از استفاده از این ترجمه نداریم.