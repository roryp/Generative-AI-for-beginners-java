<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "40abf4889418bff189039ac30ff44281",
  "translation_date": "2025-07-23T11:56:25+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "ar"
}
-->
# إعداد بيئة التطوير للذكاء الاصطناعي التوليدي باستخدام Java

> **بدء سريع**: البرمجة في السحابة خلال دقيقتين - انتقل إلى [إعداد GitHub Codespaces](../../../02-SetupDevEnvironment) - لا حاجة للتثبيت المحلي ويستخدم نماذج GitHub!

> **مهتم بـ Azure OpenAI؟**، راجع [دليل إعداد Azure OpenAI](getting-started-azure-openai.md) مع خطوات لإنشاء مورد جديد لـ Azure OpenAI.

## ما ستتعلمه

- إعداد بيئة تطوير Java لتطبيقات الذكاء الاصطناعي
- اختيار وتكوين بيئة التطوير المفضلة لديك (السحابة أولاً باستخدام Codespaces، حاوية التطوير المحلية، أو الإعداد المحلي الكامل)
- اختبار الإعداد الخاص بك عن طريق الاتصال بنماذج GitHub

## جدول المحتويات

- [ما ستتعلمه](../../../02-SetupDevEnvironment)
- [المقدمة](../../../02-SetupDevEnvironment)
- [الخطوة 1: إعداد بيئة التطوير](../../../02-SetupDevEnvironment)
  - [الخيار أ: GitHub Codespaces (موصى به)](../../../02-SetupDevEnvironment)
  - [الخيار ب: حاوية التطوير المحلية](../../../02-SetupDevEnvironment)
  - [الخيار ج: استخدام التثبيت المحلي الحالي](../../../02-SetupDevEnvironment)
- [الخطوة 2: إنشاء رمز وصول شخصي لـ GitHub](../../../02-SetupDevEnvironment)
- [الخطوة 3: اختبار الإعداد الخاص بك](../../../02-SetupDevEnvironment)
- [استكشاف الأخطاء وإصلاحها](../../../02-SetupDevEnvironment)
- [الملخص](../../../02-SetupDevEnvironment)
- [الخطوات التالية](../../../02-SetupDevEnvironment)

## المقدمة

هذا الفصل سيرشدك خلال إعداد بيئة التطوير. سنستخدم **نماذج GitHub** كمثال رئيسي لأنها مجانية، وسهلة الإعداد باستخدام حساب GitHub فقط، ولا تتطلب بطاقة ائتمان، وتوفر الوصول إلى نماذج متعددة للتجربة.

**لا حاجة للإعداد المحلي!** يمكنك البدء في البرمجة فورًا باستخدام GitHub Codespaces، الذي يوفر بيئة تطوير كاملة في متصفحك.

<img src="./images/models.webp" alt="لقطة شاشة: نماذج GitHub" width="50%">

نوصي باستخدام [**نماذج GitHub**](https://github.com/marketplace?type=models) لهذه الدورة لأنها:
- **مجانية** للبدء
- **سهلة** الإعداد باستخدام حساب GitHub فقط
- **لا تتطلب بطاقة ائتمان**
- **نماذج متعددة** متاحة للتجربة

> **ملاحظة**: النماذج المستخدمة في هذا التدريب لديها الحدود المجانية التالية:
> - 15 طلبًا في الدقيقة (150 يوميًا)
> - ~8,000 كلمة إدخال، ~4,000 كلمة إخراج لكل طلب
> - 5 طلبات متزامنة
> 
> للاستخدام الإنتاجي، قم بالترقية إلى نماذج Azure AI Foundry باستخدام حساب Azure الخاص بك. لا تحتاج إلى تغيير الكود الخاص بك. راجع [وثائق Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models).

## الخطوة 1: إعداد بيئة التطوير

<a name="quick-start-cloud"></a>

لقد أنشأنا حاوية تطوير مهيأة مسبقًا لتقليل وقت الإعداد وضمان حصولك على جميع الأدوات اللازمة لهذه الدورة الخاصة بالذكاء الاصطناعي التوليدي باستخدام Java. اختر نهج التطوير المفضل لديك:

### خيارات إعداد البيئة:

#### الخيار أ: GitHub Codespaces (موصى به)

**ابدأ البرمجة خلال دقيقتين - لا حاجة للإعداد المحلي!**

1. قم بعمل Fork لهذا المستودع إلى حساب GitHub الخاص بك
   > **ملاحظة**: إذا كنت ترغب في تعديل التكوين الأساسي، يرجى الاطلاع على [تكوين حاوية التطوير](../../../.devcontainer/devcontainer.json)
2. انقر على **Code** → علامة تبويب **Codespaces** → **...** → **New with options...**
3. استخدم الإعدادات الافتراضية – سيختار هذا **تكوين حاوية التطوير**: **بيئة تطوير الذكاء الاصطناعي التوليدي باستخدام Java** التي تم إنشاؤها خصيصًا لهذه الدورة
4. انقر على **Create codespace**
5. انتظر حوالي دقيقتين حتى تكون البيئة جاهزة
6. انتقل إلى [الخطوة 2: إنشاء رمز GitHub](../../../02-SetupDevEnvironment)

<img src="./images/codespaces.png" alt="لقطة شاشة: قائمة فرعية لـ Codespaces" width="50%">

<img src="./images/image.png" alt="لقطة شاشة: جديد مع الخيارات" width="50%">

<img src="./images/codespaces-create.png" alt="لقطة شاشة: خيارات إنشاء Codespace" width="50%">

> **فوائد Codespaces**:
> - لا حاجة للتثبيت المحلي
> - يعمل على أي جهاز يحتوي على متصفح
> - مهيأ مسبقًا بجميع الأدوات والاعتمادات
> - 60 ساعة مجانية شهريًا للحسابات الشخصية
> - بيئة متسقة لجميع المتعلمين

#### الخيار ب: حاوية التطوير المحلية

**للمطورين الذين يفضلون التطوير المحلي باستخدام Docker**

1. قم بعمل Fork واستنساخ هذا المستودع إلى جهازك المحلي
   > **ملاحظة**: إذا كنت ترغب في تعديل التكوين الأساسي، يرجى الاطلاع على [تكوين حاوية التطوير](../../../.devcontainer/devcontainer.json)
2. قم بتثبيت [Docker Desktop](https://www.docker.com/products/docker-desktop/) و [VS Code](https://code.visualstudio.com/)
3. قم بتثبيت [إضافة حاويات التطوير](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) في VS Code
4. افتح مجلد المستودع في VS Code
5. عند المطالبة، انقر على **Reopen in Container** (أو استخدم `Ctrl+Shift+P` → "Dev Containers: Reopen in Container")
6. انتظر حتى يتم بناء الحاوية وبدء تشغيلها
7. انتقل إلى [الخطوة 2: إنشاء رمز GitHub](../../../02-SetupDevEnvironment)

<img src="./images/devcontainer.png" alt="لقطة شاشة: إعداد حاوية التطوير" width="50%">

<img src="./images/image-3.png" alt="لقطة شاشة: اكتمال بناء حاوية التطوير" width="50%">

#### الخيار ج: استخدام التثبيت المحلي الحالي

**للمطورين الذين لديهم بيئات Java موجودة**

المتطلبات:
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) أو IDE المفضل لديك

الخطوات:
1. قم باستنساخ هذا المستودع إلى جهازك المحلي
2. افتح المشروع في IDE الخاص بك
3. انتقل إلى [الخطوة 2: إنشاء رمز GitHub](../../../02-SetupDevEnvironment)

> **نصيحة احترافية**: إذا كان لديك جهاز ذو مواصفات منخفضة ولكنك تريد VS Code محليًا، استخدم GitHub Codespaces! يمكنك ربط VS Code المحلي الخاص بك بـ Codespace مستضاف في السحابة للحصول على أفضل ما في العالمين.

<img src="./images/image-2.png" alt="لقطة شاشة: إنشاء مثيل حاوية التطوير المحلية" width="50%">

## الخطوة 2: إنشاء رمز وصول شخصي لـ GitHub

1. انتقل إلى [إعدادات GitHub](https://github.com/settings/profile) واختر **Settings** من قائمة ملفك الشخصي.
2. في الشريط الجانبي الأيسر، انقر على **Developer settings** (عادةً في الأسفل).
3. ضمن **Personal access tokens**، انقر على **Fine-grained tokens** (أو اتبع هذا [الرابط المباشر](https://github.com/settings/personal-access-tokens)).
4. انقر على **Generate new token**.
5. ضمن "Token name"، قدم اسمًا وصفيًا (مثل `GenAI-Java-Course-Token`).
6. قم بتعيين تاريخ انتهاء الصلاحية (موصى به: 7 أيام لأفضل ممارسات الأمان).
7. ضمن "Resource owner"، اختر حساب المستخدم الخاص بك.
8. ضمن "Repository access"، اختر المستودعات التي تريد استخدامها مع نماذج GitHub (أو "All repositories" إذا لزم الأمر).
9. ضمن "Repository permissions"، ابحث عن **Models** وقم بتعيينها إلى **Read and write**.
10. انقر على **Generate token**.
11. **انسخ واحفظ الرمز الآن** – لن تتمكن من رؤيته مرة أخرى!

> **نصيحة أمان**: استخدم أقل نطاق مطلوب وأقصر وقت انتهاء عملي لرموز الوصول الخاصة بك.

## الخطوة 3: اختبار الإعداد الخاص بك باستخدام مثال نماذج GitHub

بمجرد أن تكون بيئة التطوير جاهزة، دعنا نختبر تكامل نماذج GitHub مع تطبيق المثال الخاص بنا في [`02-SetupDevEnvironment/src/github-models`](../../../02-SetupDevEnvironment/src/github-models).

1. افتح الطرفية في بيئة التطوير الخاصة بك.
2. انتقل إلى مثال نماذج GitHub:
   ```bash
   cd 02-SetupDevEnvironment/src/github-models
   ```
3. قم بتعيين رمز GitHub الخاص بك كمتغير بيئة:
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. قم بتشغيل التطبيق:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

يجب أن ترى إخراجًا مشابهًا لـ:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### فهم كود المثال

أولاً، دعنا نفهم ما قمنا بتشغيله للتو. المثال تحت `src/github-models` يستخدم OpenAI Java SDK للاتصال بنماذج GitHub:

**ما يفعله هذا الكود:**
- **يتصل** بنماذج GitHub باستخدام رمز الوصول الشخصي الخاص بك
- **يرسل** رسالة بسيطة "Say Hello World!" إلى نموذج الذكاء الاصطناعي
- **يتلقى** ويعرض استجابة الذكاء الاصطناعي
- **يتحقق** من أن الإعداد الخاص بك يعمل بشكل صحيح

**الاعتماد الرئيسي** (في `pom.xml`):
```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

**الكود الرئيسي** (`App.java`):
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

## الملخص

**تهانينا!** لقد نجحت في:

- **إنشاء رمز وصول شخصي لـ GitHub** مع الأذونات المناسبة للوصول إلى نماذج الذكاء الاصطناعي
- **إعداد بيئة تطوير Java الخاصة بك** باستخدام Codespaces، حاويات التطوير، أو التثبيت المحلي
- **الاتصال بنماذج GitHub** باستخدام OpenAI Java SDK للوصول المجاني لتطوير الذكاء الاصطناعي
- **اختبار التكامل** مع تطبيق مثال يعمل يتواصل مع نماذج الذكاء الاصطناعي

## الخطوات التالية

[الفصل 3: تقنيات الذكاء الاصطناعي التوليدي الأساسية](../03-CoreGenerativeAITechniques/README.md)

## استكشاف الأخطاء وإصلاحها

هل تواجه مشاكل؟ إليك المشاكل الشائعة وحلولها:

- **الرمز لا يعمل؟** 
  - تأكد من أنك نسخت الرمز بالكامل دون أي مسافات إضافية
  - تحقق من تعيين الرمز بشكل صحيح كمتغير بيئة
  - تأكد من أن الرمز لديه الأذونات الصحيحة (Models: Read and write)

- **Maven غير موجود؟** 
  - إذا كنت تستخدم حاويات التطوير/Codespaces، يجب أن يكون Maven مثبتًا مسبقًا
  - للإعداد المحلي، تأكد من تثبيت Java 21+ و Maven 3.9+
  - جرب `mvn --version` للتحقق من التثبيت

- **مشاكل الاتصال؟** 
  - تحقق من اتصالك بالإنترنت
  - تأكد من أن GitHub يمكن الوصول إليه من شبكتك
  - تأكد من أنك لست خلف جدار ناري يمنع نقطة نهاية نماذج GitHub

- **حاوية التطوير لا تبدأ؟** 
  - تأكد من تشغيل Docker Desktop (للتطوير المحلي)
  - جرب إعادة بناء الحاوية: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container"

- **أخطاء تجميع التطبيق؟**
  - تأكد من أنك في الدليل الصحيح: `02-SetupDevEnvironment/src/github-models`
  - جرب التنظيف وإعادة البناء: `mvn clean compile`

> **تحتاج إلى مساعدة؟**: لا تزال تواجه مشاكل؟ افتح مشكلة في المستودع وسنساعدك.

**إخلاء المسؤولية**:  
تم ترجمة هذا المستند باستخدام خدمة الترجمة بالذكاء الاصطناعي [Co-op Translator](https://github.com/Azure/co-op-translator). بينما نسعى لتحقيق الدقة، يرجى العلم أن الترجمات الآلية قد تحتوي على أخطاء أو معلومات غير دقيقة. يجب اعتبار المستند الأصلي بلغته الأصلية المصدر الموثوق. للحصول على معلومات حاسمة، يُوصى بالاستعانة بترجمة بشرية احترافية. نحن غير مسؤولين عن أي سوء فهم أو تفسيرات خاطئة تنشأ عن استخدام هذه الترجمة.