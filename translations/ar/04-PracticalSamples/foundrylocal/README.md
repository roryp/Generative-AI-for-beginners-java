# Foundry Local Spring Boot Tutorial

## Table of Contents

- [المتطلبات المسبقة](#المتطلبات-المسبقة)
- [نظرة عامة على المشروع](#نظرة-عامة-على-المشروع)
- [فهم الكود](#فهم-الكود)
  - [1. تكوين التطبيق (application.properties)](#1-تكوين-التطبيق-applicationproperties)
  - [2. الفصل الرئيسي للتطبيق (Application.java)](#2-الفصل-الرئيسي-للتطبيق-applicationjava)
  - [3. طبقة خدمة الذكاء الاصطناعي (FoundryLocalService.java)](#3-طبقة-خدمة-الذكاء-الاصطناعي-foundrylocalservicejava)
  - [4. اعتماديات المشروع (pom.xml)](#4-اعتماديات-المشروع-pomxml)
- [كيف يعمل كل هذا معًا](#كيف-يعمل-كل-هذا-معًا)
- [إعداد Foundry Local](#إعداد-foundry-local)
- [تشغيل التطبيق](#تشغيل-التطبيق)
- [الناتج المتوقع](#الناتج-المتوقع)
- [الخطوات التالية](#الخطوات-التالية)
- [استكشاف الأخطاء وإصلاحها](#استكشاف-الأخطاء-وإصلاحها)


## المتطلبات المسبقة

قبل بدء هذا الدرس، تأكد من أنك تمتلك:

- **Java 21 أو أعلى** مثبتة على نظامك
- **Maven 3.6+** لبناء المشروع
- **Foundry Local** مثبتة وتعمل

### **تثبيت Foundry Local:**

> **ملاحظة:** CLI الخاص بـ Foundry Local متوفر فقط على **ويندوز** و **macOS**. يتم دعم Linux عبر [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (بايثون، جافا سكريبت، C#، روست).

```bash
# ويندوز
winget install Microsoft.FoundryLocal

# ماك أو إس
brew tap microsoft/foundrylocal
brew install foundrylocal
```

تحقق من التثبيت:
```bash
foundry --version
```

## نظرة عامة على المشروع

يتكون هذا المشروع من أربعة مكونات رئيسية:

1. **Application.java** - نقطة الدخول الرئيسية لتطبيق Spring Boot
2. **FoundryLocalService.java** - طبقة الخدمة التي تتعامل مع التواصل مع الذكاء الاصطناعي
3. **application.properties** - تكوين اتصال Foundry Local
4. **pom.xml** - اعتماديات Maven وتكوين المشروع

## فهم الكود

### 1. تكوين التطبيق (application.properties)

**ملف:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**ما يفعله هذا:**
- **base-url**: يحدد مكان تشغيل Foundry Local، بما في ذلك مسار `/v1` للتوافق مع OpenAI API. المنفذ الافتراضي هو `5273`. إذا كان المنفذ مختلفًا، تحقق منه باستخدام `foundry service status`.
- **model** (اختياري): يحدد اسم نموذج الذكاء الاصطناعي المستخدم لتوليد النص. **بشكل افتراضي، يقوم التطبيق بالكشف التلقائي عن النموذج** بسؤال نقطة النهاية `/v1/models` في Foundry Local عند بدء التشغيل، لذا لا تحتاج لضبطه. يمكنك تعيينه صراحة لتجاوز الكشف التلقائي إذا لزم الأمر.

**المفهوم الأساسي:** يقوم Spring Boot بتحميل هذه الخصائص تلقائيًا ويجعلها متاحة لتطبيقك باستخدام التعليمة `@Value`.

### 2. الفصل الرئيسي للتطبيق (Application.java)

**ملف:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // لا حاجة لخادم ويب
        app.run(args);
    }
```

**ما يفعله هذا:**
- `@SpringBootApplication` يفعّل التكوين التلقائي لـ Spring Boot
- `WebApplicationType.NONE` يخبر Spring أن هذا تطبيق سطر أوامر وليس خادم ويب
- تبدأ الطريقة الرئيسية تطبيق Spring

**قيد التشغيل التجريبي:**
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

**ما يفعله هذا:**
- `@Bean` ينشئ مكونًا تديره Spring
- `CommandLineRunner` يشغل الكود بعد بدء تشغيل Spring Boot
- يتم حقن `foundryLocalService` تلقائيًا بواسطة Spring (حقن التبعية)
- يرسل رسالة اختبار إلى الذكاء الاصطناعي ويعرض الاستجابة

### 3. طبقة خدمة الذكاء الاصطناعي (FoundryLocalService.java)

**ملف:** `src/main/java/com/example/FoundryLocalService.java`

#### حقن التكوين:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // تم الكشف تلقائيًا إذا كان فارغًا
```

**ما يفعله هذا:**
- `@Service` يخبر Spring أن هذه الفئة تقدم منطق الأعمال
- `@Value` يحقن قيم التكوين من application.properties
- النموذج افتراضيًا فارغ، مما يحفز **الكشف التلقائي** من Foundry Local عند بدء التشغيل. هذا يعني أن التطبيق يعمل مع أي نموذج محمّل في Foundry Local بدون تكوين يدوي.

#### تهيئة العميل:
```java
@PostConstruct
public void init() {
    // الكشف التلقائي عن النموذج من Foundry Local إذا لم يتم تكوينه صراحةً
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // عنوان URL الأساسي يتضمن بالفعل /v1 من التكوين
            .apiKey("not-needed")            // الخادم المحلي لا يحتاج إلى مفتاح API حقيقي
            .build();
}
```

**ما يفعله هذا:**
- `@PostConstruct` يشغّل هذه الطريقة بعد إنشاء الخدمة بواسطة Spring
- إذا لم يتم تكوين نموذج، فسوف يسأل نقطة نهاية `/v1/models` في Foundry Local ويختار أول نموذج محمّل
- ينشئ عميل OpenAI يشير إلى مثيل Foundry Local المحلي الخاص بك
- عنوان URL الأساسي من `application.properties` يتضمن بالفعل `/v1` لتوافق OpenAI API
- مفتاح API مضبوط على "not-needed" لأن التطوير المحلي لا يتطلب مصادقة

#### طريقة الدردشة:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // أي نموذج ذكاء صناعي يجب استخدامه
                .addUserMessage(message)         // سؤالك/الإيعاز الخاص بك
                .maxCompletionTokens(150)        // حد طول الرد
                .temperature(0.7)                // التحكم في الإبداع (٠.٠-١.٠)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // استخراج رد الذكاء الصناعي من نتيجة واجهة برمجة التطبيقات
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**ما يفعله هذا:**
- **ChatCompletionCreateParams**: يقوم بتكوين طلب الذكاء الاصطناعي
  - `model`: يحدد نموذج الذكاء الاصطناعي المستخدم (يجب أن يطابق المعرف الدقيق من `foundry model list`)
  - `addUserMessage`: يضيف رسالتك إلى المحادثة
  - `maxCompletionTokens`: يحدد الحد الأقصى لطول الاستجابة (يوفر الموارد)
  - `temperature`: يتحكم في العشوائية (0.0 = حتمي، 1.0 = إبداعي)
- **نداء API**: يرسل الطلب إلى Foundry Local
- **معالجة الاستجابة**: يستخرج نص الاستجابة من الذكاء الاصطناعي بأمان
- **معالجة الأخطاء**: يغلف الاستثناءات برسائل خطأ مفيدة

### 4. اعتماديات المشروع (pom.xml)

**الاعتماديات الرئيسية:**

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

**ما تفعله هذه:**
- **spring-boot-starter**: يوفر الوظائف الأساسية لـ Spring Boot
- **openai-java**: SDK الرسمي لجافا للتواصل مع OpenAI API
- **jackson-databind**: يدير تسلسل/فك تسلسل JSON لاستدعاءات API

## كيف يعمل كل هذا معًا

إليك التدفق الكامل عند تشغيل التطبيق:

1. **بدء التشغيل**: يبدأ Spring Boot ويقرأ `application.properties`
2. **إنشاء الخدمة**: تنشئ Spring الخدمة `FoundryLocalService` وتحقن قيم التكوين
3. **الكشف عن النموذج**: إذا لم يتم تكوين نموذج، تستعلم الخدمة نقطة نهاية `/v1/models` في Foundry Local وتستخدم أول نموذج متاح تلقائيًا
4. **إعداد العميل**: يقوم `@PostConstruct` بتهيئة عميل OpenAI للاتصال بـ Foundry Local
5. **تنفيذ العرض التوضيحي**: ينفذ `CommandLineRunner` بعد بدء التشغيل
6. **نداء AI**: يقوم العرض التوضيحي بنداء `foundryLocalService.chat()` مع رسالة اختبار
7. **طلب API**: تبني الخدمة وترسل طلب متوافق مع OpenAI إلى Foundry Local
8. **معالجة الاستجابة**: تستخرج الخدمة الرد وترجعه
9. **العرض**: يطبع التطبيق الرد ثم يخرج

## إعداد Foundry Local

1. **قم بتثبيت Foundry Local** باستخدام التعليمات في قسم [المتطلبات المسبقة](#المتطلبات-المسبقة).

2. **ابدأ الخدمة** (إذا لم تكن تعمل بالفعل):
   ```bash
   foundry service start
   ```

3. **تحقق من حالة الخدمة** لتأكيد أنها تعمل وتدوين المنفذ:
   ```bash
   foundry service status
   ```

4. **قم بتنزيل وتشغيل نموذج** (يتم التنزيل في التشغيل الأول، ويُخزن مؤقتًا للتشغيلات اللاحقة):
   ```bash
   foundry model run phi-4-mini
   ```
   يفتح هذا جلسة دردشة تفاعلية. يمكنك الخروج باستخدام `Ctrl+C`. يبقى النموذج محمّلًا في الخدمة.

   > **نصيحة:** شغل `foundry model list` لرؤية جميع النماذج المتاحة. استبدل `phi-4-mini` بأي اسم مستعار من الكتالوج (مثلًا، `qwen2.5-0.5b` لنموذج أصغر/أسرع).

5. **تحقق من تحميل النموذج:**
   ```bash
   foundry service ps
   ```

6. **حدث `application.properties`** إذا لزم الأمر:
   - عنوان الـ `base-url` الافتراضي (`http://localhost:5273/v1`) يتطابق مع منفذ CLI الافتراضي. حدّثه فقط إذا أظهر `foundry service status` منفذًا مختلفًا.
   - يتم **الكشف التلقائي عن النموذج** عند بدء التشغيل — لا حاجة للتكوين.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## تشغيل التطبيق

### الخطوة 1: تأكد من تحميل نموذج في Foundry Local
```bash
foundry service ps
```
إذا لم تُدرج نماذج، قم بتحميل واحد:
```bash
foundry model run phi-4-mini
```

### الخطوة 2: بناء التطبيق وتشغيله
في نافذة طرفية منفصلة:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

أو ابنِ وشغّل كملف JAR:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## الناتج المتوقع

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

## الخطوات التالية

لمزيد من الأمثلة، راجع [الفصل 04: عينات عملية](../README.md)

## استكشاف الأخطاء وإصلاحها

### المشاكل الشائعة

**"الاتصال مرفوض" أو "الخدمة غير متوفرة"**
- تحقق من الخدمة: `foundry service status`
- أعد التشغيل إذا لزم الأمر: `foundry service restart`
- تحقق أن المنفذ في `application.properties` يطابق مخرج `foundry service status`
- تأكد من أن URL ينتهي بـ `/v1`: `http://localhost:5273/v1`

**"لم يتم العثور على نموذج" عند بدء التشغيل**
- التطبيق يكتشف النموذج تلقائيًا. تأكد من تحميل نموذج واحد على الأقل: `foundry service ps`
- إذا لم يتم تحميل أي نماذج: `foundry model run phi-4-mini`
- إذا قمت بتعديل اسم النموذج في `application.properties`، تحقق من مطابقته للـ `foundry model list`

**أخطاء "400 طلب سيئ"**
- تحقق أن عنوان URL الأساسي يتضمن `/v1`: `http://localhost:5273/v1`
- تأكد من استخدام `maxCompletionTokens()` بدلاً من `maxTokens()` (الطريقة المهجورة)

**أخطاء تجميع Maven**
- تأكد من وجود Java 21 أو أعلى: `java -version`
- نظف وأعد البناء: `mvn clean compile`
- تأكد من اتصال الإنترنت لتحميل الاعتماديات

**مشاكل اتصال الخدمة**
- إذا ظهرت رسالة `Request to local service failed`، شغّل: `foundry service restart`
- تحقق من النماذج المحملة: `foundry service ps`
- عرض سجلات الخدمة: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**إخلاء المسؤولية**:  
تمت ترجمة هذا المستند باستخدام خدمة الترجمة بالذكاء الاصطناعي [Co-op Translator](https://github.com/Azure/co-op-translator). بينما نسعى للدقة، يرجى العلم أن الترجمات الآلية قد تحتوي على أخطاء أو عدم دقة. يجب اعتبار المستند الأصلي بلغته الأصلية المصدر المعتمد. لأغراض المعلومات الحيوية، يُنصح بالترجمة الاحترافية البشرية. نحن غير مسؤولين عن أي سوء فهم أو تفسيرات خاطئة ناتجة عن استخدام هذه الترجمة.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->