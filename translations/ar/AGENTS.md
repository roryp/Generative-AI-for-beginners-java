# AGENTS.md

## نظرة عامة على المشروع

هذا مستودع تعليمي لتعلم تطوير الذكاء الاصطناعي التوليدي باستخدام Java. يقدم دورة عملية شاملة تغطي نماذج اللغة الكبيرة (LLMs)، هندسة التوجيه، التضمينات، RAG (توليد معزز بالاسترجاع)، وبروتوكول سياق النموذج (MCP).

**التقنيات الرئيسية:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- نماذج GitHub، Azure OpenAI، و OpenAI SDKs

**الهندسة المعمارية:**
- تطبيقات Spring Boot مستقلة متعددة منظمة حسب الفصول
- مشاريع نموذجية توضح أنماط الذكاء الاصطناعي المختلفة
- جاهزة للعمل مع GitHub Codespaces مع حاويات تطوير مُعدة مسبقًا

## أوامر الإعداد

### المتطلبات الأساسية
- Java 21 أو أعلى
- Maven 3.x
- رمز وصول شخصي لـ GitHub (لنماذج GitHub)
- اختياري: بيانات اعتماد Azure OpenAI

### إعداد البيئة

**الخيار 1: GitHub Codespaces (موصى به)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**الخيار 2: حاوية تطوير محلية**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**الخيار 3: إعداد محلي**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```


### التكوين

**إعداد رمز GitHub:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**إعداد Azure OpenAI (اختياري):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```


## سير العمل التطويري

### هيكل المشروع
```
/
├── 01-IntroToGenAI/              # Chapter 1: Introduction
├── 02-SetupDevEnvironment/       # Chapter 2: Environment setup
│   └── examples/                 # Working examples
├── 03-CoreGenerativeAITechniques/ # Chapter 3: Core techniques
├── 04-PracticalSamples/          # Chapter 4: Sample projects
│   ├── calculator/               # MCP service example
│   ├── foundrylocal/            # Local model integration
│   └── petstory/                # Multi-modal app
├── 05-ResponsibleGenAI/         # Chapter 5: Responsible AI
└── translations/                # Multi-language support
```


### تشغيل التطبيقات

**تشغيل تطبيق Spring Boot:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**بناء المشروع:**
```bash
cd [project-directory]
mvn clean install
```

**تشغيل خادم MCP Calculator:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**تشغيل أمثلة العميل:**
```bash
# After starting the server in another terminal
cd 04-PracticalSamples/calculator

# Direct MCP client
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"

# AI-powered client (requires GITHUB_TOKEN)
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"

# Interactive bot
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.Bot"
```


### إعادة التحميل السريع
تم تضمين Spring Boot DevTools في المشاريع التي تدعم إعادة التحميل السريع:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```


## تعليمات الاختبار

### تشغيل الاختبارات

**تشغيل جميع الاختبارات في المشروع:**
```bash
cd [project-directory]
mvn test
```

**تشغيل الاختبارات مع إخراج مفصل:**
```bash
mvn test -X
```

**تشغيل فئة اختبار محددة:**
```bash
mvn test -Dtest=CalculatorServiceTest
```


### هيكل الاختبار
- ملفات الاختبار تستخدم JUnit 5 (Jupiter)
- فئات الاختبار موجودة في `src/test/java/`
- أمثلة العميل في مشروع الحاسبة موجودة في `src/test/java/com/microsoft/mcp/sample/client/`

### الاختبار اليدوي
العديد من الأمثلة هي تطبيقات تفاعلية تتطلب اختبارًا يدويًا:

1. قم بتشغيل التطبيق باستخدام `mvn spring-boot:run`
2. اختبر نقاط النهاية أو تفاعل مع CLI
3. تحقق من أن السلوك المتوقع يتطابق مع الوثائق في README.md لكل مشروع

### الاختبار باستخدام نماذج GitHub
- حدود الطبقة المجانية: 15 طلبًا/دقيقة، 150/يوم
- 5 طلبات متزامنة كحد أقصى
- اختبار تصفية المحتوى باستخدام أمثلة الذكاء الاصطناعي المسؤول

## إرشادات نمط الكود

### اتفاقيات Java
- **إصدار Java:** Java 21 مع الميزات الحديثة
- **النمط:** اتباع اتفاقيات Java القياسية
- **التسمية:**
  - الفئات: PascalCase
  - الطرق/المتغيرات: camelCase
  - الثوابت: UPPER_SNAKE_CASE
  - أسماء الحزم: أحرف صغيرة

### أنماط Spring Boot
- استخدام `@Service` للمنطق التجاري
- استخدام `@RestController` لنقاط النهاية REST
- التكوين عبر `application.yml` أو `application.properties`
- تفضيل متغيرات البيئة على القيم الثابتة
- استخدام التعليمة `@Tool` للطرق المكشوفة عبر MCP

### تنظيم الملفات
```
src/
├── main/
│   ├── java/
│   │   └── com/microsoft/[component]/
│   │       ├── [Component]Application.java
│   │       ├── config/
│   │       ├── controller/
│   │       ├── service/
│   │       └── exception/
│   └── resources/
│       ├── application.yml
│       └── static/
└── test/
    └── java/
        └── com/microsoft/[component]/
```


### التبعيات
- تُدار عبر Maven `pom.xml`
- Spring AI BOM لإدارة الإصدارات
- LangChain4j للتكاملات الذكاء الاصطناعي
- Spring Boot starter parent لتبعيات Spring

### تعليقات الكود
- إضافة JavaDoc لواجهات برمجة التطبيقات العامة
- تضمين تعليقات تفسيرية للتفاعلات المعقدة مع الذكاء الاصطناعي
- توثيق أوصاف أدوات MCP بوضوح

## البناء والنشر

### بناء المشاريع

**البناء بدون اختبارات:**
```bash
mvn clean install -DskipTests
```

**البناء مع جميع الفحوصات:**
```bash
mvn clean install
```

**تغليف التطبيق:**
```bash
mvn package
# Creates JAR in target/ directory
```


### أدلة الإخراج
- الفئات المترجمة: `target/classes/`
- فئات الاختبار: `target/test-classes/`
- ملفات JAR: `target/*.jar`
- قطع Maven: `target/`

### تكوين خاص بالبيئة

**التطوير:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**الإنتاج:**
- استخدام نماذج Azure AI Foundry بدلاً من نماذج GitHub
- تحديث عنوان URL الأساسي إلى نقطة نهاية Azure OpenAI
- إدارة الأسرار عبر Azure Key Vault أو متغيرات البيئة

### اعتبارات النشر
- هذا مستودع تعليمي مع تطبيقات نموذجية
- غير مصمم للنشر الإنتاجي كما هو
- الأمثلة توضح أنماطًا يمكن تكييفها للاستخدام الإنتاجي
- راجع ملفات README لكل مشروع للحصول على ملاحظات النشر المحددة

## ملاحظات إضافية

### نماذج GitHub مقابل Azure OpenAI
- **نماذج GitHub:** طبقة مجانية للتعلم، لا حاجة لبطاقة ائتمان
- **Azure OpenAI:** جاهزة للإنتاج، تتطلب اشتراك Azure
- الكود متوافق بين الاثنين - فقط قم بتغيير نقطة النهاية ومفتاح API

### العمل مع مشاريع متعددة
كل مشروع نموذجي مستقل:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```


### المشكلات الشائعة

**عدم توافق إصدار Java:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**مشكلات تنزيل التبعيات:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**رمز GitHub غير موجود:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**المنفذ قيد الاستخدام بالفعل:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```


### دعم متعدد اللغات
- الوثائق متوفرة بأكثر من 45 لغة عبر الترجمة الآلية
- الترجمات موجودة في دليل `translations/`
- تُدار الترجمة بواسطة سير عمل GitHub Actions

### مسار التعلم
1. ابدأ بـ [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. اتبع الفصول بالترتيب (01 → 05)
3. أكمل الأمثلة العملية في كل فصل
4. استكشف المشاريع النموذجية في الفصل 4
5. تعلم ممارسات الذكاء الاصطناعي المسؤول في الفصل 5

### حاوية التطوير
تقوم `.devcontainer/devcontainer.json` بتكوين:
- بيئة تطوير Java 21
- Maven مثبت مسبقًا
- ملحقات Java لـ VS Code
- أدوات Spring Boot
- تكامل GitHub Copilot
- دعم Docker-in-Docker
- Azure CLI

### اعتبارات الأداء
- طبقة نماذج GitHub المجانية لديها حدود معدل
- استخدم أحجام دفعات مناسبة للتضمينات
- ضع في اعتبارك التخزين المؤقت لطلبات API المتكررة
- راقب استخدام الرموز لتحسين التكلفة

### ملاحظات الأمان
- لا تقم أبدًا بارتكاب ملفات `.env` (موجودة بالفعل في `.gitignore`)
- استخدم متغيرات البيئة لمفاتيح API
- يجب أن تحتوي رموز GitHub على أقل النطاقات المطلوبة
- اتبع إرشادات الذكاء الاصطناعي المسؤول في الفصل 5

---

**إخلاء المسؤولية**:  
تم ترجمة هذا المستند باستخدام خدمة الترجمة بالذكاء الاصطناعي [Co-op Translator](https://github.com/Azure/co-op-translator). بينما نسعى لتحقيق الدقة، يرجى العلم أن الترجمات الآلية قد تحتوي على أخطاء أو معلومات غير دقيقة. يجب اعتبار المستند الأصلي بلغته الأصلية المصدر الموثوق. للحصول على معلومات حاسمة، يُوصى بالاستعانة بترجمة بشرية احترافية. نحن غير مسؤولين عن أي سوء فهم أو تفسيرات خاطئة ناتجة عن استخدام هذه الترجمة.