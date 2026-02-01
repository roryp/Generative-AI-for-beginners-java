# AGENTS.md

## نمای کلی پروژه

این یک مخزن آموزشی برای یادگیری توسعه هوش مصنوعی مولد با جاوا است. این دوره عملی جامع شامل مدل‌های زبانی بزرگ (LLMs)، مهندسی پرامپت، جاسازی‌ها، RAG (تولید تقویت‌شده با بازیابی) و پروتکل زمینه مدل (MCP) را ارائه می‌دهد.

**فناوری‌های کلیدی:**
- جاوا 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- مدل‌های GitHub، Azure OpenAI و SDKهای OpenAI

**معماری:**
- چندین برنامه مستقل Spring Boot که بر اساس فصل‌ها سازماندهی شده‌اند
- پروژه‌های نمونه برای نمایش الگوهای مختلف هوش مصنوعی
- آماده برای GitHub Codespaces با کانتینرهای توسعه از پیش پیکربندی شده

## دستورات راه‌اندازی

### پیش‌نیازها
- جاوا 21 یا بالاتر
- Maven 3.x
- توکن دسترسی شخصی GitHub (برای مدل‌های GitHub)
- اختیاری: اعتبارنامه‌های Azure OpenAI

### تنظیم محیط

**گزینه 1: GitHub Codespaces (توصیه‌شده)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**گزینه 2: کانتینر توسعه محلی**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**گزینه 3: تنظیم محلی**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### پیکربندی

**تنظیم توکن GitHub:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**تنظیم Azure OpenAI (اختیاری):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## جریان کاری توسعه

### ساختار پروژه
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

### اجرای برنامه‌ها

**اجرای یک برنامه Spring Boot:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**ساخت یک پروژه:**
```bash
cd [project-directory]
mvn clean install
```

**راه‌اندازی سرور MCP Calculator:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**اجرای مثال‌های کلاینت:**
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

### بارگذاری مجدد سریع
Spring Boot DevTools در پروژه‌هایی که از بارگذاری مجدد سریع پشتیبانی می‌کنند، گنجانده شده است:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## دستورالعمل‌های تست

### اجرای تست‌ها

**اجرای تمام تست‌ها در یک پروژه:**
```bash
cd [project-directory]
mvn test
```

**اجرای تست‌ها با خروجی مفصل:**
```bash
mvn test -X
```

**اجرای کلاس تست خاص:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### ساختار تست
- فایل‌های تست از JUnit 5 (Jupiter) استفاده می‌کنند
- کلاس‌های تست در `src/test/java/` قرار دارند
- مثال‌های کلاینت در پروژه ماشین‌حساب در `src/test/java/com/microsoft/mcp/sample/client/` قرار دارند

### تست دستی
بسیاری از مثال‌ها برنامه‌های تعاملی هستند که نیاز به تست دستی دارند:

1. برنامه را با `mvn spring-boot:run` اجرا کنید
2. نقاط پایانی را تست کنید یا با CLI تعامل داشته باشید
3. مطمئن شوید که رفتار مورد انتظار با مستندات در README.md هر پروژه مطابقت دارد

### تست با مدل‌های GitHub
- محدودیت‌های سطح رایگان: 15 درخواست در دقیقه، 150 درخواست در روز
- حداکثر 5 درخواست همزمان
- فیلتر کردن محتوا را با مثال‌های هوش مصنوعی مسئولانه تست کنید

## دستورالعمل‌های سبک کدنویسی

### قراردادهای جاوا
- **نسخه جاوا:** جاوا 21 با ویژگی‌های مدرن
- **سبک:** پیروی از قراردادهای استاندارد جاوا
- **نام‌گذاری:** 
  - کلاس‌ها: PascalCase
  - متدها/متغیرها: camelCase
  - ثابت‌ها: UPPER_SNAKE_CASE
  - نام بسته‌ها: حروف کوچک

### الگوهای Spring Boot
- از `@Service` برای منطق کسب‌وکار استفاده کنید
- از `@RestController` برای نقاط پایانی REST استفاده کنید
- پیکربندی از طریق `application.yml` یا `application.properties`
- متغیرهای محیطی به جای مقادیر ثابت ترجیح داده می‌شوند
- از حاشیه‌نویسی `@Tool` برای متدهای در معرض MCP استفاده کنید

### سازماندهی فایل‌ها
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

### وابستگی‌ها
- مدیریت شده از طریق `pom.xml` Maven
- Spring AI BOM برای مدیریت نسخه‌ها
- LangChain4j برای یکپارچه‌سازی‌های هوش مصنوعی
- Spring Boot starter parent برای وابستگی‌های Spring

### توضیحات کد
- برای APIهای عمومی JavaDoc اضافه کنید
- توضیحات توضیحی برای تعاملات پیچیده هوش مصنوعی درج کنید
- توضیحات ابزار MCP را به وضوح مستند کنید

## ساخت و استقرار

### ساخت پروژه‌ها

**ساخت بدون تست‌ها:**
```bash
mvn clean install -DskipTests
```

**ساخت با تمام بررسی‌ها:**
```bash
mvn clean install
```

**بسته‌بندی برنامه:**
```bash
mvn package
# Creates JAR in target/ directory
```

### دایرکتوری‌های خروجی
- کلاس‌های کامپایل شده: `target/classes/`
- کلاس‌های تست: `target/test-classes/`
- فایل‌های JAR: `target/*.jar`
- مصنوعات Maven: `target/`

### پیکربندی خاص محیط

**توسعه:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**تولید:**
- از مدل‌های Azure AI Foundry به جای مدل‌های GitHub استفاده کنید
- آدرس پایه را به نقطه پایانی Azure OpenAI به‌روزرسانی کنید
- مدیریت اسرار از طریق Azure Key Vault یا متغیرهای محیطی

### ملاحظات استقرار
- این یک مخزن آموزشی با برنامه‌های نمونه است
- برای استقرار تولید به همین شکل طراحی نشده است
- نمونه‌ها الگوهایی را نشان می‌دهند که برای استفاده تولیدی قابل تطبیق هستند
- برای یادداشت‌های خاص استقرار به READMEهای پروژه‌های فردی مراجعه کنید

## یادداشت‌های اضافی

### مدل‌های GitHub در مقابل Azure OpenAI
- **مدل‌های GitHub:** سطح رایگان برای یادگیری، بدون نیاز به کارت اعتباری
- **Azure OpenAI:** آماده تولید، نیازمند اشتراک Azure
- کد بین هر دو سازگار است - فقط نقطه پایانی و کلید API را تغییر دهید

### کار با پروژه‌های متعدد
هر پروژه نمونه مستقل است:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### مشکلات رایج

**عدم تطابق نسخه جاوا:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**مشکلات دانلود وابستگی‌ها:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**توکن GitHub یافت نشد:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**پورت قبلاً استفاده شده:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### پشتیبانی چندزبانه
- مستندات در بیش از 45 زبان از طریق ترجمه خودکار موجود است
- ترجمه‌ها در دایرکتوری `translations/` قرار دارند
- ترجمه توسط جریان کاری GitHub Actions مدیریت می‌شود

### مسیر یادگیری
1. با [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md) شروع کنید
2. فصل‌ها را به ترتیب دنبال کنید (01 → 05)
3. مثال‌های عملی در هر فصل را کامل کنید
4. پروژه‌های نمونه در فصل 4 را بررسی کنید
5. شیوه‌های هوش مصنوعی مسئولانه را در فصل 5 یاد بگیرید

### کانتینر توسعه
پیکربندی `.devcontainer/devcontainer.json` شامل موارد زیر است:
- محیط توسعه جاوا 21
- Maven از پیش نصب شده
- افزونه‌های جاوا برای VS Code
- ابزارهای Spring Boot
- یکپارچه‌سازی GitHub Copilot
- پشتیبانی از Docker-in-Docker
- Azure CLI

### ملاحظات عملکرد
- سطح رایگان مدل‌های GitHub دارای محدودیت نرخ است
- از اندازه‌های مناسب دسته برای جاسازی‌ها استفاده کنید
- کش کردن را برای تماس‌های API تکراری در نظر بگیرید
- استفاده از توکن را برای بهینه‌سازی هزینه نظارت کنید

### یادداشت‌های امنیتی
- هرگز فایل‌های `.env` را کامیت نکنید (قبلاً در `.gitignore` قرار گرفته‌اند)
- از متغیرهای محیطی برای کلیدهای API استفاده کنید
- توکن‌های GitHub باید حداقل محدوده‌های مورد نیاز را داشته باشند
- دستورالعمل‌های هوش مصنوعی مسئولانه در فصل 5 را دنبال کنید

---

**سلب مسئولیت**:  
این سند با استفاده از سرویس ترجمه هوش مصنوعی [Co-op Translator](https://github.com/Azure/co-op-translator) ترجمه شده است. در حالی که ما تلاش می‌کنیم دقت را حفظ کنیم، لطفاً توجه داشته باشید که ترجمه‌های خودکار ممکن است شامل خطاها یا نادرستی‌ها باشند. سند اصلی به زبان اصلی آن باید به عنوان منبع معتبر در نظر گرفته شود. برای اطلاعات حساس، ترجمه حرفه‌ای انسانی توصیه می‌شود. ما مسئولیتی در قبال سوء تفاهم‌ها یا تفسیرهای نادرست ناشی از استفاده از این ترجمه نداریم.