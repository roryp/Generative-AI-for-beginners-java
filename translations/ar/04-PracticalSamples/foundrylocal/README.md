<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d064108b2142d32246ccbd8a42e76b4d",
  "translation_date": "2025-07-25T08:48:53+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "ar"
}
-->
# تطبيق Foundry Local لسطر الأوامر

> **ملاحظة**: يتضمن هذا الفصل [**دليلًا تعليميًا**](./TUTORIAL.md) يوجهك خلال الأمثلة.

تطبيق بسيط يعتمد على Spring Boot ويعمل عبر سطر الأوامر، يوضح كيفية الاتصال بـ Foundry Local باستخدام OpenAI Java SDK.

## ما ستتعلمه

- كيفية دمج Foundry Local مع تطبيقات Spring Boot باستخدام OpenAI Java SDK
- أفضل الممارسات لتطوير واختبار الذكاء الاصطناعي محليًا

## جدول المحتويات

- [ما ستتعلمه](../../../../04-PracticalSamples/foundrylocal)
- [المتطلبات الأساسية](../../../../04-PracticalSamples/foundrylocal)
  - [تثبيت Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [التحقق](../../../../04-PracticalSamples/foundrylocal)
- [الإعداد](../../../../04-PracticalSamples/foundrylocal)
- [البدء السريع](../../../../04-PracticalSamples/foundrylocal)
- [ما يقوم به التطبيق](../../../../04-PracticalSamples/foundrylocal)
- [المخرجات النموذجية](../../../../04-PracticalSamples/foundrylocal)
- [الهيكلية](../../../../04-PracticalSamples/foundrylocal)
- [أبرز النقاط في الكود](../../../../04-PracticalSamples/foundrylocal)
  - [دمج OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [واجهة برمجة تطبيقات إكمال المحادثة](../../../../04-PracticalSamples/foundrylocal)
- [استكشاف الأخطاء وإصلاحها](../../../../04-PracticalSamples/foundrylocal)

## المتطلبات الأساسية

> **⚠️ ملاحظة**: هذا التطبيق **لا يعمل في devcontainer المرفق** لأنه يتطلب تثبيت وتشغيل Foundry Local على النظام المضيف.

### تثبيت Foundry Local

قبل تشغيل هذا التطبيق، تحتاج إلى تثبيت وتشغيل Foundry Local. اتبع الخطوات التالية:

1. **تأكد من أن نظامك يلبي المتطلبات**:
   - **نظام التشغيل**: Windows 10 (x64)، Windows 11 (x64/ARM)، Windows Server 2025، أو macOS
   - **المواصفات**: 
     - الحد الأدنى: 8 جيجابايت من ذاكرة الوصول العشوائي، 3 جيجابايت مساحة خالية على القرص
     - الموصى به: 16 جيجابايت من ذاكرة الوصول العشوائي، 15 جيجابايت مساحة خالية على القرص
   - **الشبكة**: اتصال بالإنترنت لتنزيل النموذج الأولي (اختياري للاستخدام دون اتصال)
   - **التسريع (اختياري)**: بطاقة رسومات NVIDIA (سلسلة 2000 أو أحدث)، بطاقة رسومات AMD (سلسلة 6000 أو أحدث)، Qualcomm Snapdragon X Elite (8 جيجابايت أو أكثر من الذاكرة)، أو Apple silicon
   - **الأذونات**: امتيازات إدارية لتثبيت البرامج على جهازك

2. **قم بتثبيت Foundry Local**:
   
   **لنظام Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **لنظام macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   بدلاً من ذلك، يمكنك تنزيل المثبت من [مستودع Foundry Local على GitHub](https://github.com/microsoft/Foundry-Local).

3. **ابدأ تشغيل النموذج الأول**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   يتم تنزيل النموذج (قد يستغرق ذلك بضع دقائق حسب سرعة الإنترنت لديك) ثم يبدأ التشغيل. يقوم Foundry Local تلقائيًا باختيار أفضل إصدار للنموذج لجهازك (CUDA لبطاقات NVIDIA، أو إصدار CPU بخلاف ذلك).

4. **اختبر النموذج** بطرح سؤال في نفس نافذة الطرفية:

   ```bash
   Why is the sky blue?
   ```

   يجب أن ترى استجابة من نموذج Phi تشرح سبب ظهور السماء باللون الأزرق.

### التحقق

يمكنك التحقق من أن كل شيء يعمل بشكل صحيح باستخدام هذه الأوامر:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

يمكنك أيضًا زيارة `http://localhost:5273` في متصفحك لرؤية واجهة الويب الخاصة بـ Foundry Local.

## الإعداد

يمكن تكوين التطبيق من خلال ملف `application.properties`:

- `foundry.local.base-url` - عنوان URL الأساسي لـ Foundry Local (الافتراضي: http://localhost:5273)
- `foundry.local.model` - نموذج الذكاء الاصطناعي المستخدم (الافتراضي: Phi-3.5-mini-instruct-cuda-gpu)

> **ملاحظة**: يجب أن يتطابق اسم النموذج في الإعدادات مع الإصدار المحدد الذي قام Foundry Local بتنزيله لجهازك. عند تشغيل `foundry model run phi-3.5-mini`، يقوم Foundry Local تلقائيًا باختيار وتنزيل أفضل إصدار (CUDA لبطاقات NVIDIA، أو إصدار CPU بخلاف ذلك). استخدم `foundry model list` لرؤية اسم النموذج المتاح في نسختك المحلية.

## البدء السريع

### 1. انتقل إلى دليل تطبيق Foundry Local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. قم بتشغيل التطبيق

```bash
mvn spring-boot:run
```

أو قم ببناء وتشغيل ملف JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### التبعيات

يستخدم هذا التطبيق OpenAI Java SDK للتواصل مع Foundry Local. التبعية الرئيسية هي:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

التطبيق مُعد مسبقًا للاتصال بـ Foundry Local الذي يعمل على المنفذ الافتراضي.

## ما يقوم به التطبيق

عند تشغيل التطبيق:

1. **يبدأ التشغيل** كتطبيق سطر أوامر (بدون خادم ويب)
2. **يرسل تلقائيًا** رسالة اختبار: "مرحبًا! هل يمكنك أن تخبرني ما أنت وما النموذج الذي تعمل عليه؟"
3. **يعرض الاستجابة** من Foundry Local في وحدة التحكم
4. **ينهي التشغيل** بشكل نظيف بعد العرض التوضيحي

## المخرجات النموذجية

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## الهيكلية

- **Application.java** - التطبيق الرئيسي لـ Spring Boot مع CommandLineRunner
- **FoundryLocalService.java** - خدمة تستخدم OpenAI Java SDK للتواصل مع Foundry Local
- يستخدم **OpenAI Java SDK** لإجراء استدعاءات API آمنة من النوع
- يتم التعامل مع التسلسل/إلغاء التسلسل JSON تلقائيًا بواسطة SDK
- إعداد نظيف باستخدام تعليقات Spring مثل `@Value` و `@PostConstruct`

## أبرز النقاط في الكود

### دمج OpenAI Java SDK

يستخدم التطبيق OpenAI Java SDK لإنشاء عميل مهيأ لـ Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### واجهة برمجة تطبيقات إكمال المحادثة

إجراء طلبات إكمال المحادثة بسيط وآمن من النوع:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## استكشاف الأخطاء وإصلاحها

إذا واجهت أخطاء اتصال:
1. تحقق من أن Foundry Local يعمل على `http://localhost:5273`
2. تأكد من أن إصدار نموذج Phi-3.5-mini متاح باستخدام `foundry model list`
3. تأكد من أن اسم النموذج في `application.properties` يتطابق مع الاسم الدقيق للنموذج المعروض في القائمة
4. تأكد من عدم وجود جدار ناري يمنع الاتصال

المشاكل الشائعة:
- **النموذج غير موجود**: قم بتشغيل `foundry model run phi-3.5-mini` لتنزيل وتشغيل النموذج
- **الخدمة غير قيد التشغيل**: قد تكون خدمة Foundry Local قد توقفت؛ أعد تشغيلها باستخدام أمر تشغيل النموذج
- **اسم النموذج غير صحيح**: استخدم `foundry model list` لرؤية النماذج المتاحة وقم بتحديث الإعدادات وفقًا لذلك

**إخلاء المسؤولية**:  
تم ترجمة هذا المستند باستخدام خدمة الترجمة بالذكاء الاصطناعي [Co-op Translator](https://github.com/Azure/co-op-translator). بينما نسعى لتحقيق الدقة، يرجى العلم أن الترجمات الآلية قد تحتوي على أخطاء أو معلومات غير دقيقة. يجب اعتبار المستند الأصلي بلغته الأصلية المصدر الرسمي. للحصول على معلومات حاسمة، يُوصى بالاستعانة بترجمة بشرية احترافية. نحن غير مسؤولين عن أي سوء فهم أو تفسيرات خاطئة تنشأ عن استخدام هذه الترجمة.