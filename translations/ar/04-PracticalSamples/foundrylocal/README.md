<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "f787307400de59adc25a1404466a35f3",
  "translation_date": "2025-11-04T07:13:50+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "ar"
}
-->
# دليل استخدام Foundry Local مع Spring Boot

## جدول المحتويات

- [المتطلبات الأساسية](../../../../04-PracticalSamples/foundrylocal)
- [نظرة عامة على المشروع](../../../../04-PracticalSamples/foundrylocal)
- [فهم الكود](../../../../04-PracticalSamples/foundrylocal)
  - [1. إعدادات التطبيق (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. الفئة الرئيسية للتطبيق (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. طبقة خدمة الذكاء الاصطناعي (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. تبعيات المشروع (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [كيف تعمل جميع الأجزاء معًا](../../../../04-PracticalSamples/foundrylocal)
- [إعداد Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [تشغيل التطبيق](../../../../04-PracticalSamples/foundrylocal)
- [المخرجات المتوقعة](../../../../04-PracticalSamples/foundrylocal)
- [الخطوات التالية](../../../../04-PracticalSamples/foundrylocal)
- [استكشاف الأخطاء وإصلاحها](../../../../04-PracticalSamples/foundrylocal)

## المتطلبات الأساسية

قبل البدء في هذا الدليل، تأكد من توفر ما يلي:

- **Java 21 أو أعلى** مثبتة على نظامك
- **Maven 3.6+** لبناء المشروع
- **Foundry Local** مثبتة وتعمل

### **تثبيت Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```


## نظرة عامة على المشروع

يتكون هذا المشروع من أربعة مكونات رئيسية:

1. **Application.java** - نقطة الدخول الرئيسية لتطبيق Spring Boot
2. **FoundryLocalService.java** - طبقة الخدمة التي تتعامل مع الاتصال بالذكاء الاصطناعي
3. **application.properties** - إعدادات الاتصال بـ Foundry Local
4. **pom.xml** - تبعيات Maven وإعدادات المشروع

## فهم الكود

### 1. إعدادات التطبيق (application.properties)

**الملف:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**ما الذي يفعله هذا:**
- **base-url**: يحدد مكان تشغيل Foundry Local، بما في ذلك المسار `/v1` للتوافق مع واجهة برمجة تطبيقات OpenAI. **ملاحظة**: يقوم Foundry Local بتعيين منفذ ديناميكي، لذا تحقق من المنفذ الفعلي باستخدام `foundry service status`
- **model**: يحدد اسم نموذج الذكاء الاصطناعي المستخدم لتوليد النصوص، بما في ذلك رقم الإصدار (مثل `:1`). استخدم `foundry model list` لرؤية النماذج المتاحة مع معرفاتها الدقيقة

**المفهوم الرئيسي:** يقوم Spring Boot بتحميل هذه الإعدادات تلقائيًا ويجعلها متاحة لتطبيقك باستخدام التعليمة `@Value`.

### 2. الفئة الرئيسية للتطبيق (Application.java)

**الملف:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```


**ما الذي يفعله هذا:**
- `@SpringBootApplication` يُمكّن التهيئة التلقائية لـ Spring Boot
- `WebApplicationType.NONE` يُخبر Spring أن هذا تطبيق سطر أوامر وليس خادم ويب
- الطريقة الرئيسية تبدأ تشغيل تطبيق Spring

**مشغل العرض التوضيحي:**
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


**ما الذي يفعله هذا:**
- `@Bean` ينشئ مكونًا يديره Spring
- `CommandLineRunner` يشغل الكود بعد بدء تشغيل Spring Boot
- يتم حقن `foundryLocalService` تلقائيًا بواسطة Spring (حقن التبعيات)
- يرسل رسالة اختبار إلى الذكاء الاصطناعي ويعرض الرد

### 3. طبقة خدمة الذكاء الاصطناعي (FoundryLocalService.java)

**الملف:** `src/main/java/com/example/FoundryLocalService.java`

#### حقن الإعدادات:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**ما الذي يفعله هذا:**
- `@Service` يُخبر Spring أن هذه الفئة تقدم منطق الأعمال
- `@Value` يحقن قيم الإعدادات من application.properties
- صيغة `:default-value` توفر قيمًا افتراضية إذا لم يتم تعيين الإعدادات

#### تهيئة العميل:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```


**ما الذي يفعله هذا:**
- `@PostConstruct` يشغل هذه الطريقة بعد إنشاء الخدمة بواسطة Spring
- ينشئ عميل OpenAI يشير إلى مثيل Foundry Local المحلي الخاص بك
- عنوان URL الأساسي من `application.properties` يتضمن بالفعل `/v1` للتوافق مع واجهة برمجة تطبيقات OpenAI
- يتم تعيين مفتاح API إلى "not-needed" لأن التطوير المحلي لا يتطلب مصادقة

#### طريقة الدردشة:
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


**ما الذي يفعله هذا:**
- **ChatCompletionCreateParams**: يهيئ طلب الذكاء الاصطناعي
  - `model`: يحدد نموذج الذكاء الاصطناعي المستخدم (يجب أن يتطابق مع المعرف الدقيق من `foundry model list`)
  - `addUserMessage`: يضيف رسالتك إلى المحادثة
  - `maxCompletionTokens`: يحد من طول الرد (لتوفير الموارد)
  - `temperature`: يتحكم في العشوائية (0.0 = حتمي، 1.0 = إبداعي)
- **استدعاء API**: يرسل الطلب إلى Foundry Local
- **معالجة الرد**: يستخرج نص الرد الخاص بالذكاء الاصطناعي بأمان
- **معالجة الأخطاء**: يلف الاستثناءات برسائل خطأ مفيدة

### 4. تبعيات المشروع (pom.xml)

**التبعيات الرئيسية:**

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


**ما الذي تفعله هذه:**
- **spring-boot-starter**: يوفر الوظائف الأساسية لـ Spring Boot
- **openai-java**: SDK الرسمي لـ OpenAI للتواصل مع واجهة برمجة التطبيقات
- **jackson-databind**: يتعامل مع تسلسل/إلغاء تسلسل JSON لاستدعاءات واجهة برمجة التطبيقات

## كيف تعمل جميع الأجزاء معًا

إليك التدفق الكامل عند تشغيل التطبيق:

1. **البدء**: يبدأ Spring Boot ويقرأ `application.properties`
2. **إنشاء الخدمة**: يقوم Spring بإنشاء `FoundryLocalService` ويحقن قيم الإعدادات
3. **إعداد العميل**: يقوم `@PostConstruct` بتهيئة عميل OpenAI للاتصال بـ Foundry Local
4. **تنفيذ العرض التوضيحي**: يتم تشغيل `CommandLineRunner` بعد بدء التشغيل
5. **استدعاء الذكاء الاصطناعي**: يقوم العرض التوضيحي باستدعاء `foundryLocalService.chat()` مع رسالة اختبار
6. **طلب API**: تقوم الخدمة ببناء وإرسال طلب متوافق مع OpenAI إلى Foundry Local
7. **معالجة الرد**: تستخرج الخدمة الرد الخاص بالذكاء الاصطناعي وتعيده
8. **العرض**: يطبع التطبيق الرد وينهي التشغيل

## إعداد Foundry Local

لإعداد Foundry Local، اتبع الخطوات التالية:

1. **قم بتثبيت Foundry Local** باستخدام التعليمات في قسم [المتطلبات الأساسية](../../../../04-PracticalSamples/foundrylocal).

2. **تحقق من المنفذ المعين ديناميكيًا**. يقوم Foundry Local بتعيين منفذ تلقائيًا عند بدء التشغيل. يمكنك العثور على المنفذ باستخدام:
   ```bash
   foundry service status
   ```
   
   **اختياري**: إذا كنت تفضل استخدام منفذ معين (مثل 5273)، يمكنك تكوينه يدويًا:
   ```bash
   foundry service set --port 5273
   ```


3. **قم بتنزيل نموذج الذكاء الاصطناعي** الذي تريد استخدامه، على سبيل المثال، `phi-3.5-mini`، باستخدام الأمر التالي:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **قم بتكوين ملف application.properties** ليتناسب مع إعدادات Foundry Local:
   - قم بتحديث المنفذ في `base-url` (من الخطوة 2)، مع التأكد من أنه يتضمن `/v1` في النهاية
   - قم بتحديث اسم النموذج ليشمل رقم الإصدار (تحقق باستخدام `foundry model list`)
   
   مثال:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## تشغيل التطبيق

### الخطوة 1: بدء تشغيل Foundry Local
```bash
foundry model run phi-3.5-mini
```


### الخطوة 2: بناء وتشغيل التطبيق
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```


## المخرجات المتوقعة

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


## الخطوات التالية

للحصول على أمثلة إضافية، راجع [الفصل 04: أمثلة عملية](../README.md)

## استكشاف الأخطاء وإصلاحها

### المشاكل الشائعة

**"Connection refused" أو "Service unavailable"**
- تأكد من تشغيل Foundry Local: `foundry model list`
- تحقق من المنفذ الفعلي الذي يستخدمه Foundry Local: `foundry service status`
- قم بتحديث `application.properties` بالمنفذ الصحيح، مع التأكد من أن عنوان URL ينتهي بـ `/v1`
- بدلاً من ذلك، قم بتعيين منفذ معين إذا كنت ترغب: `foundry service set --port 5273`
- حاول إعادة تشغيل Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" أو "404 Not Found"**
- تحقق من النماذج المتاحة مع معرفاتها الدقيقة: `foundry model list`
- قم بتحديث اسم النموذج في `application.properties` ليتطابق تمامًا، بما في ذلك رقم الإصدار (مثل `Phi-3.5-mini-instruct-cuda-gpu:1`)
- تأكد من أن `base-url` يتضمن `/v1` في النهاية: `http://localhost:5273/v1`
- قم بتنزيل النموذج إذا لزم الأمر: `foundry model run phi-3.5-mini`

**"400 Bad Request"**
- تحقق من أن عنوان URL الأساسي يتضمن `/v1`: `http://localhost:5273/v1`
- تأكد من أن معرف النموذج يتطابق تمامًا مع ما يظهر في `foundry model list`
- تأكد من استخدام `maxCompletionTokens()` في الكود الخاص بك (وليس `maxTokens()` الذي تم إيقافه)

**أخطاء تجميع Maven**
- تأكد من وجود Java 21 أو أعلى: `java -version`
- قم بتنظيف وإعادة البناء: `mvn clean compile`
- تحقق من اتصال الإنترنت لتنزيل التبعيات

**التطبيق يبدأ ولكن لا توجد مخرجات**
- تحقق من استجابة Foundry Local: تحقق من `http://localhost:5273/v1/models` أو قم بتشغيل `foundry service status`
- تحقق من سجلات التطبيق للحصول على رسائل خطأ محددة
- تأكد من أن النموذج قد تم تحميله بالكامل وجاهز

---

**إخلاء المسؤولية**:  
تم ترجمة هذا المستند باستخدام خدمة الترجمة بالذكاء الاصطناعي [Co-op Translator](https://github.com/Azure/co-op-translator). بينما نسعى لتحقيق الدقة، يرجى العلم أن الترجمات الآلية قد تحتوي على أخطاء أو عدم دقة. يجب اعتبار المستند الأصلي بلغته الأصلية المصدر الرسمي. للحصول على معلومات حاسمة، يُوصى بالترجمة البشرية الاحترافية. نحن غير مسؤولين عن أي سوء فهم أو تفسيرات خاطئة تنشأ عن استخدام هذه الترجمة.