<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T18:30:40+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "ar"
}
-->
# تطبيق قصة الحيوانات الأليفة

>**ملاحظة**: يتضمن هذا الفصل [**دليلًا تعليميًا**](./TUTORIAL.md) يوجهك خلال تشغيل النماذج النهائية.

تطبيق ويب يعتمد على Spring Boot يقوم بإنشاء أوصاف وقصص مدعومة بالذكاء الاصطناعي للصور المرفوعة للحيوانات الأليفة باستخدام نماذج GitHub.

## جدول المحتويات

- [التقنيات المستخدمة](../../../../04-PracticalSamples/petstory)
- [المتطلبات الأساسية](../../../../04-PracticalSamples/petstory)
- [الإعداد والتثبيت](../../../../04-PracticalSamples/petstory)
- [كيفية الاستخدام](../../../../04-PracticalSamples/petstory)

## التقنيات المستخدمة

- **الخلفية**: Spring Boot 3.5.3، Java 21
- **تكامل الذكاء الاصطناعي**: OpenAI Java SDK مع نماذج GitHub
- **الأمان**: Spring Security
- **الواجهة الأمامية**: قوالب Thymeleaf مع تنسيق Bootstrap
- **أداة البناء**: Maven
- **نماذج الذكاء الاصطناعي**: نماذج GitHub

## المتطلبات الأساسية

- Java 21 أو أعلى
- Maven 3.9+
- رمز وصول شخصي من GitHub مع نطاق `models:read`

## الإعداد والتثبيت

### 1. انتقل إلى دليل تطبيق petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. قم بتعيين متغير البيئة
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. قم ببناء التطبيق
```bash
mvn clean compile
```

### 4. قم بتشغيل التطبيق
```bash
mvn spring-boot:run
```

## كيفية الاستخدام

1. **الوصول إلى التطبيق**: انتقل إلى `http://localhost:8080`
2. **رفع الصورة**: اضغط على "اختيار ملف" واختر صورة لحيوان أليف
3. **تحليل الصورة**: اضغط على "تحليل الصورة" للحصول على وصف الذكاء الاصطناعي
4. **إنشاء القصة**: اضغط على "إنشاء القصة" لتوليد القصة

**إخلاء المسؤولية**:  
تم ترجمة هذا المستند باستخدام خدمة الترجمة بالذكاء الاصطناعي [Co-op Translator](https://github.com/Azure/co-op-translator). بينما نسعى لتحقيق الدقة، يرجى العلم أن الترجمات الآلية قد تحتوي على أخطاء أو معلومات غير دقيقة. يجب اعتبار المستند الأصلي بلغته الأصلية المصدر الموثوق. للحصول على معلومات حاسمة، يُوصى بالاستعانة بترجمة بشرية احترافية. نحن غير مسؤولين عن أي سوء فهم أو تفسيرات خاطئة ناتجة عن استخدام هذه الترجمة.