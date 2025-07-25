<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T08:49:45+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "ar"
}
-->
# تطبيق قصة الحيوانات الأليفة

>**ملاحظة**: يتضمن هذا الفصل [**دليلًا**](./TUTORIAL.md) يوجهك خلال الأمثلة.

تطبيق ويب يعتمد على Spring Boot يقوم بإنشاء أوصاف وقصص مدعومة بالذكاء الاصطناعي للصور المرفوعة للحيوانات الأليفة باستخدام نماذج GitHub.

## جدول المحتويات

- [تقنيات المستخدمة](../../../../04-PracticalSamples/petstory)
- [المتطلبات الأساسية](../../../../04-PracticalSamples/petstory)
- [الإعداد والتثبيت](../../../../04-PracticalSamples/petstory)
- [الاستخدام](../../../../04-PracticalSamples/petstory)

## تقنيات المستخدمة

- **الخلفية**: Spring Boot 3.5.3، Java 21
- **تكامل الذكاء الاصطناعي**: OpenAI Java SDK مع نماذج GitHub
- **الأمان**: Spring Security
- **الواجهة الأمامية**: قوالب Thymeleaf مع تصميم Bootstrap
- **أداة البناء**: Maven
- **نماذج الذكاء الاصطناعي**: نماذج GitHub

## المتطلبات الأساسية

- Java 21 أو أعلى
- Maven 3.9+
- رمز وصول شخصي من GitHub مع نطاق `models:read`

## الإعداد والتثبيت

### 1. الانتقال إلى دليل تطبيق قصة الحيوانات الأليفة
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. إعداد متغير البيئة
```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. بناء التطبيق
```bash
mvn clean compile
```

### 4. تشغيل التطبيق
```bash
mvn spring-boot:run
```

## الاستخدام

1. **الوصول إلى التطبيق**: انتقل إلى `http://localhost:8080`
2. **رفع الصورة**: اضغط على "اختيار ملف" واختر صورة للحيوان الأليف
3. **تحليل الصورة**: اضغط على "تحليل الصورة" للحصول على وصف مدعوم بالذكاء الاصطناعي
4. **إنشاء القصة**: اضغط على "إنشاء القصة" لإنشاء القصة

**إخلاء المسؤولية**:  
تم ترجمة هذا المستند باستخدام خدمة الترجمة بالذكاء الاصطناعي [Co-op Translator](https://github.com/Azure/co-op-translator). بينما نسعى لتحقيق الدقة، يرجى العلم أن الترجمات الآلية قد تحتوي على أخطاء أو معلومات غير دقيقة. يجب اعتبار المستند الأصلي بلغته الأصلية المصدر الموثوق. للحصول على معلومات حاسمة، يُوصى بالاستعانة بترجمة بشرية احترافية. نحن غير مسؤولين عن أي سوء فهم أو تفسيرات خاطئة تنشأ عن استخدام هذه الترجمة.