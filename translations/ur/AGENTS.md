# AGENTS.md

## پروجیکٹ کا جائزہ

یہ جاوا کے ساتھ جنریٹو AI ڈیولپمنٹ سیکھنے کے لیے ایک تعلیمی ریپوزیٹری ہے۔ یہ ایک جامع عملی کورس فراہم کرتا ہے جو بڑے لینگویج ماڈلز (LLMs)، پرامپٹ انجینئرنگ، ایمبیڈنگز، RAG (ریٹریول-اگمینٹڈ جنریشن)، اور ماڈل کانٹیکسٹ پروٹوکول (MCP) کا احاطہ کرتا ہے۔

**اہم ٹیکنالوجیز:**
- جاوا 21
- اسپرنگ بوٹ 3.5.x
- اسپرنگ AI 1.1.x
- میون
- LangChain4j
- GitHub ماڈلز، Azure OpenAI، اور OpenAI SDKs

**آرکیٹیکچر:**
- متعدد اسٹینڈ الون اسپرنگ بوٹ ایپلیکیشنز، چیپٹرز کے لحاظ سے منظم
- مختلف AI پیٹرنز کو ظاہر کرنے والے نمونہ پروجیکٹس
- GitHub Codespaces کے لیے تیار، پہلے سے کنفیگرڈ ڈیولپمنٹ کنٹینرز کے ساتھ

## سیٹ اپ کمانڈز

### ضروریات
- جاوا 21 یا اس سے زیادہ
- میون 3.x
- GitHub پرسنل ایکسیس ٹوکن (GitHub ماڈلز کے لیے)
- اختیاری: Azure OpenAI کی اسناد

### ماحول کی ترتیب

**آپشن 1: GitHub Codespaces (تجویز کردہ)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**آپشن 2: لوکل ڈیولپمنٹ کنٹینر**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**آپشن 3: لوکل سیٹ اپ**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### کنفیگریشن

**GitHub ٹوکن سیٹ اپ:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI سیٹ اپ (اختیاری):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## ڈیولپمنٹ ورک فلو

### پروجیکٹ کی ساخت
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

### ایپلیکیشنز چلانا

**اسپرنگ بوٹ ایپلیکیشن چلانا:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**پروجیکٹ بنانا:**
```bash
cd [project-directory]
mvn clean install
```

**MCP کیلکولیٹر سرور شروع کرنا:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**کلائنٹ مثالیں چلانا:**
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

### ہاٹ ری لوڈ
اسپرنگ بوٹ ڈیولپمنٹ ٹولز ان پروجیکٹس میں شامل ہیں جو ہاٹ ری لوڈ کو سپورٹ کرتے ہیں:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## ٹیسٹنگ ہدایات

### ٹیسٹ چلانا

**پروجیکٹ میں تمام ٹیسٹ چلائیں:**
```bash
cd [project-directory]
mvn test
```

**تفصیلی آؤٹ پٹ کے ساتھ ٹیسٹ چلائیں:**
```bash
mvn test -X
```

**مخصوص ٹیسٹ کلاس چلائیں:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### ٹیسٹ کی ساخت
- ٹیسٹ فائلز JUnit 5 (Jupiter) استعمال کرتی ہیں
- ٹیسٹ کلاسز `src/test/java/` میں واقع ہیں
- کیلکولیٹر پروجیکٹ میں کلائنٹ مثالیں `src/test/java/com/microsoft/mcp/sample/client/` میں ہیں

### دستی ٹیسٹنگ
بہت سی مثالیں انٹرایکٹو ایپلیکیشنز ہیں جنہیں دستی ٹیسٹنگ کی ضرورت ہوتی ہے:

1. ایپلیکیشن کو `mvn spring-boot:run` کے ساتھ شروع کریں
2. اینڈپوائنٹس کو ٹیسٹ کریں یا CLI کے ساتھ انٹرایکٹ کریں
3. تصدیق کریں کہ متوقع رویہ ہر پروجیکٹ کی README.md میں دی گئی دستاویزات سے میل کھاتا ہے

### GitHub ماڈلز کے ساتھ ٹیسٹنگ
- مفت درجے کی حدود: 15 درخواستیں/منٹ، 150/دن
- زیادہ سے زیادہ 5 متوازی درخواستیں
- ذمہ دار AI مثالوں کے ساتھ مواد فلٹرنگ ٹیسٹ کریں

## کوڈ اسٹائل گائیڈ لائنز

### جاوا کنونشنز
- **جاوا ورژن:** جاوا 21 جدید خصوصیات کے ساتھ
- **اسٹائل:** معیاری جاوا کنونشنز پر عمل کریں
- **نام دینے کا طریقہ:** 
  - کلاسز: PascalCase
  - میتھڈز/ویریبلز: camelCase
  - کانسٹینٹس: UPPER_SNAKE_CASE
  - پیکیج کے نام: چھوٹے حروف

### اسپرنگ بوٹ پیٹرنز
- بزنس لاجک کے لیے `@Service` استعمال کریں
- REST اینڈپوائنٹس کے لیے `@RestController` استعمال کریں
- کنفیگریشن `application.yml` یا `application.properties` کے ذریعے کریں
- ہارڈ کوڈڈ ویلیوز کے بجائے ماحول کے متغیرات کو ترجیح دیں
- MCP کے ذریعے ظاہر کردہ میتھڈز کے لیے `@Tool` اینوٹیشن استعمال کریں

### فائل آرگنائزیشن
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

### ڈیپینڈنسیز
- میون `pom.xml` کے ذریعے منظم
- اسپرنگ AI BOM ورژن مینجمنٹ کے لیے
- LangChain4j AI انٹیگریشنز کے لیے
- اسپرنگ بوٹ اسٹارٹر پیرنٹ اسپرنگ ڈیپینڈنسیز کے لیے

### کوڈ کمنٹس
- پبلک APIs کے لیے JavaDoc شامل کریں
- پیچیدہ AI انٹرایکشنز کے لیے وضاحتی کمنٹس شامل کریں
- MCP ٹول کی وضاحتیں واضح طور پر دستاویز کریں

## بلڈ اور ڈیپلائمنٹ

### پروجیکٹس بنانا

**ٹیسٹ کے بغیر بلڈ کریں:**
```bash
mvn clean install -DskipTests
```

**تمام چیکس کے ساتھ بلڈ کریں:**
```bash
mvn clean install
```

**ایپلیکیشن پیکج کریں:**
```bash
mvn package
# Creates JAR in target/ directory
```

### آؤٹ پٹ ڈائریکٹریز
- کمپائل شدہ کلاسز: `target/classes/`
- ٹیسٹ کلاسز: `target/test-classes/`
- JAR فائلز: `target/*.jar`
- میون آرٹیفیکٹس: `target/`

### ماحول کے لحاظ سے کنفیگریشن

**ڈیولپمنٹ:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**پروڈکشن:**
- GitHub ماڈلز کے بجائے Azure AI Foundry ماڈلز استعمال کریں
- بیس URL کو Azure OpenAI اینڈپوائنٹ پر اپ ڈیٹ کریں
- رازوں کا انتظام Azure Key Vault یا ماحول کے متغیرات کے ذریعے کریں

### ڈیپلائمنٹ کے خیالات
- یہ ایک تعلیمی ریپوزیٹری ہے جس میں نمونہ ایپلیکیشنز ہیں
- موجودہ حالت میں پروڈکشن ڈیپلائمنٹ کے لیے ڈیزائن نہیں کیا گیا
- نمونے پروڈکشن استعمال کے لیے پیٹرنز کو اپنانے کا مظاہرہ کرتے ہیں
- مخصوص ڈیپلائمنٹ نوٹس کے لیے ہر پروجیکٹ کی README دیکھیں

## اضافی نوٹس

### GitHub ماڈلز بمقابلہ Azure OpenAI
- **GitHub ماڈلز:** سیکھنے کے لیے مفت درجے، کریڈٹ کارڈ کی ضرورت نہیں
- **Azure OpenAI:** پروڈکشن کے لیے تیار، Azure سبسکرپشن کی ضرورت
- کوڈ دونوں کے ساتھ مطابقت رکھتا ہے - صرف اینڈپوائنٹ اور API کلید تبدیل کریں

### متعدد پروجیکٹس کے ساتھ کام کرنا
ہر نمونہ پروجیکٹ اسٹینڈ الون ہے:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### عام مسائل

**جاوا ورژن کا عدم مطابقت:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**ڈیپینڈنسی ڈاؤنلوڈ کے مسائل:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub ٹوکن نہیں ملا:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**پورٹ پہلے سے استعمال میں ہے:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### کثیر زبان کی حمایت
- دستاویزات 45+ زبانوں میں دستیاب ہیں، خودکار ترجمے کے ذریعے
- ترجمے `translations/` ڈائریکٹری میں موجود ہیں
- ترجمہ GitHub Actions ورک فلو کے ذریعے منظم کیا جاتا ہے

### سیکھنے کا راستہ
1. [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md) سے شروع کریں
2. چیپٹرز کو ترتیب وار فالو کریں (01 → 05)
3. ہر چیپٹر میں عملی مثالیں مکمل کریں
4. چیپٹر 4 میں نمونہ پروجیکٹس کو دریافت کریں
5. چیپٹر 5 میں ذمہ دار AI کے طریقے سیکھیں

### ڈیولپمنٹ کنٹینر
`.devcontainer/devcontainer.json` کنفیگر کرتا ہے:
- جاوا 21 ڈیولپمنٹ ماحول
- پہلے سے انسٹال شدہ میون
- VS کوڈ جاوا ایکسٹینشنز
- اسپرنگ بوٹ ٹولز
- GitHub Copilot انٹیگریشن
- Docker-in-Docker سپورٹ
- Azure CLI

### کارکردگی کے خیالات
- GitHub ماڈلز مفت درجے کی شرح کی حدود ہیں
- ایمبیڈنگز کے لیے مناسب بیچ سائز استعمال کریں
- بار بار API کالز کے لیے کیشنگ پر غور کریں
- لاگت کی اصلاح کے لیے ٹوکن استعمال کی نگرانی کریں

### سیکیورٹی نوٹس
- `.env` فائلز کو کبھی بھی کمیٹ نہ کریں (پہلے سے `.gitignore` میں شامل ہیں)
- API کلیدوں کے لیے ماحول کے متغیرات استعمال کریں
- GitHub ٹوکنز کو کم سے کم مطلوبہ اسکوپس دیں
- چیپٹر 5 میں ذمہ دار AI گائیڈ لائنز پر عمل کریں

---

**ڈسکلیمر**:  
یہ دستاویز AI ترجمہ سروس [Co-op Translator](https://github.com/Azure/co-op-translator) کا استعمال کرتے ہوئے ترجمہ کی گئی ہے۔ ہم درستگی کے لیے کوشش کرتے ہیں، لیکن براہ کرم آگاہ رہیں کہ خودکار ترجمے میں غلطیاں یا غیر درستیاں ہو سکتی ہیں۔ اصل دستاویز، جو اس کی اصل زبان میں ہے، کو مستند ذریعہ سمجھا جانا چاہیے۔ اہم معلومات کے لیے، پیشہ ور انسانی ترجمہ کی سفارش کی جاتی ہے۔ ہم اس ترجمے کے استعمال سے پیدا ہونے والی کسی بھی غلط فہمی یا غلط تشریح کے ذمہ دار نہیں ہیں۔