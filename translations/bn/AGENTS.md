# AGENTS.md

## প্রকল্পের সংক্ষিপ্ত বিবরণ

এটি একটি শিক্ষামূলক রিপোজিটরি যা জাভার মাধ্যমে জেনারেটিভ এআই ডেভেলপমেন্ট শেখার জন্য তৈরি। এটি একটি বিস্তৃত হাতে-কলমে কোর্স প্রদান করে যেখানে লার্জ ল্যাঙ্গুয়েজ মডেল (LLMs), প্রম্পট ইঞ্জিনিয়ারিং, এমবেডিংস, RAG (Retrieval-Augmented Generation), এবং মডেল কনটেক্সট প্রোটোকল (MCP) অন্তর্ভুক্ত রয়েছে।

**মূল প্রযুক্তি:**
- জাভা ২১
- স্প্রিং বুট ৩.৫.x
- স্প্রিং AI ১.১.x
- মেভেন
- LangChain4j
- GitHub Models, Azure OpenAI, এবং OpenAI SDKs

**আর্কিটেকচার:**
- অধ্যায় অনুযায়ী সংগঠিত একাধিক স্ট্যান্ডঅ্যালোন স্প্রিং বুট অ্যাপ্লিকেশন
- বিভিন্ন এআই প্যাটার্ন প্রদর্শনকারী নমুনা প্রকল্প
- GitHub Codespaces-র জন্য প্রস্তুত, প্রি-কনফিগারড ডেভ কন্টেইনার সহ

## সেটআপ কমান্ড

### প্রয়োজনীয়তা
- জাভা ২১ বা তার বেশি
- মেভেন ৩.x
- GitHub ব্যক্তিগত অ্যাক্সেস টোকেন (GitHub Models-এর জন্য)
- ঐচ্ছিক: Azure OpenAI ক্রেডেনশিয়াল

### পরিবেশ সেটআপ

**অপশন ১: GitHub Codespaces (প্রস্তাবিত)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**অপশন ২: লোকাল ডেভ কন্টেইনার**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**অপশন ৩: লোকাল সেটআপ**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### কনফিগারেশন

**GitHub টোকেন সেটআপ:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI সেটআপ (ঐচ্ছিক):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## ডেভেলপমেন্ট ওয়ার্কফ্লো

### প্রকল্পের কাঠামো
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

### অ্যাপ্লিকেশন চালানো

**স্প্রিং বুট অ্যাপ্লিকেশন চালানো:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**প্রকল্প তৈরি করা:**
```bash
cd [project-directory]
mvn clean install
```

**MCP ক্যালকুলেটর সার্ভার শুরু করা:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**ক্লায়েন্ট উদাহরণ চালানো:**
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

### হট রিলোড
স্প্রিং বুট ডেভটুলস প্রকল্পগুলিতে অন্তর্ভুক্ত রয়েছে যা হট রিলোড সমর্থন করে:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## টেস্টিং নির্দেশনা

### টেস্ট চালানো

**প্রকল্পে সব টেস্ট চালানো:**
```bash
cd [project-directory]
mvn test
```

**বিস্তারিত আউটপুট সহ টেস্ট চালানো:**
```bash
mvn test -X
```

**নির্দিষ্ট টেস্ট ক্লাস চালানো:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### টেস্টের কাঠামো
- টেস্ট ফাইল JUnit 5 (Jupiter) ব্যবহার করে
- টেস্ট ক্লাস `src/test/java/`-এ অবস্থিত
- ক্যালকুলেটর প্রকল্পে ক্লায়েন্ট উদাহরণ `src/test/java/com/microsoft/mcp/sample/client/`-এ রয়েছে

### ম্যানুয়াল টেস্টিং
অনেক উদাহরণ ইন্টারঅ্যাকটিভ অ্যাপ্লিকেশন যা ম্যানুয়াল টেস্টিং প্রয়োজন:

1. `mvn spring-boot:run` দিয়ে অ্যাপ্লিকেশন শুরু করুন
2. এন্ডপয়েন্ট পরীক্ষা করুন বা CLI-এর সাথে ইন্টারঅ্যাক্ট করুন
3. প্রত্যাশিত আচরণ প্রকল্পের README.md-তে ডকুমেন্টেশনের সাথে মিলে কিনা যাচাই করুন

### GitHub Models দিয়ে টেস্টিং
- ফ্রি টিয়ার সীমা: ১৫টি অনুরোধ/মিনিট, ১৫০টি/দিন
- সর্বাধিক ৫টি একযোগে অনুরোধ
- দায়িত্বশীল এআই উদাহরণ দিয়ে বিষয়বস্তু ফিল্টারিং পরীক্ষা করুন

## কোড স্টাইল নির্দেশিকা

### জাভা কনভেনশন
- **জাভা ভার্সন:** জাভা ২১ আধুনিক ফিচার সহ
- **স্টাইল:** স্ট্যান্ডার্ড জাভা কনভেনশন অনুসরণ করুন
- **নামকরণ:** 
  - ক্লাস: PascalCase
  - মেথড/ভেরিয়েবল: camelCase
  - কনস্ট্যান্ট: UPPER_SNAKE_CASE
  - প্যাকেজ নাম: ছোট হাতের অক্ষরে

### স্প্রিং বুট প্যাটার্ন
- বিজনেস লজিকের জন্য `@Service` ব্যবহার করুন
- REST এন্ডপয়েন্টের জন্য `@RestController` ব্যবহার করুন
- কনফিগারেশন `application.yml` বা `application.properties`-এর মাধ্যমে করুন
- হার্ড-কোডেড মানের পরিবর্তে পরিবেশ ভেরিয়েবল ব্যবহার করুন
- MCP-তে প্রকাশিত মেথডের জন্য `@Tool` অ্যানোটেশন ব্যবহার করুন

### ফাইল সংগঠন
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

### নির্ভরতা
- মেভেন `pom.xml`-এর মাধ্যমে পরিচালিত
- স্প্রিং AI BOM ভার্সন ম্যানেজমেন্টের জন্য
- LangChain4j এআই ইন্টিগ্রেশনের জন্য
- স্প্রিং নির্ভরতার জন্য স্প্রিং বুট স্টার্টার প্যারেন্ট

### কোড মন্তব্য
- পাবলিক API-এর জন্য JavaDoc যোগ করুন
- জটিল এআই ইন্টারঅ্যাকশনের জন্য ব্যাখ্যামূলক মন্তব্য অন্তর্ভুক্ত করুন
- MCP টুলের বর্ণনা স্পষ্টভাবে ডকুমেন্ট করুন

## বিল্ড এবং ডিপ্লয়মেন্ট

### প্রকল্প তৈরি

**টেস্ট ছাড়া বিল্ড:**
```bash
mvn clean install -DskipTests
```

**সব চেক সহ বিল্ড:**
```bash
mvn clean install
```

**অ্যাপ্লিকেশন প্যাকেজ করা:**
```bash
mvn package
# Creates JAR in target/ directory
```

### আউটপুট ডিরেক্টরি
- কম্পাইল করা ক্লাস: `target/classes/`
- টেস্ট ক্লাস: `target/test-classes/`
- JAR ফাইল: `target/*.jar`
- মেভেন আর্টিফ্যাক্ট: `target/`

### পরিবেশ-নির্দিষ্ট কনফিগারেশন

**ডেভেলপমেন্ট:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**প্রোডাকশন:**
- GitHub Models-এর পরিবর্তে Azure AI Foundry Models ব্যবহার করুন
- বেস-URL Azure OpenAI এন্ডপয়েন্টে আপডেট করুন
- সিক্রেট Azure Key Vault বা পরিবেশ ভেরিয়েবলের মাধ্যমে পরিচালনা করুন

### ডিপ্লয়মেন্ট বিবেচনা
- এটি একটি শিক্ষামূলক রিপোজিটরি, নমুনা অ্যাপ্লিকেশন সহ
- প্রোডাকশন ডিপ্লয়মেন্টের জন্য ডিজাইন করা হয়নি
- নমুনাগুলি প্রোডাকশনে ব্যবহারযোগ্য প্যাটার্ন প্রদর্শন করে
- নির্দিষ্ট ডিপ্লয়মেন্ট নোটের জন্য পৃথক প্রকল্পের README দেখুন

## অতিরিক্ত নোট

### GitHub Models বনাম Azure OpenAI
- **GitHub Models:** শেখার জন্য ফ্রি টিয়ার, ক্রেডিট কার্ড প্রয়োজন নেই
- **Azure OpenAI:** প্রোডাকশন-রেডি, Azure সাবস্ক্রিপশন প্রয়োজন
- কোড উভয়ের সাথে সামঞ্জস্যপূর্ণ - শুধু এন্ডপয়েন্ট এবং API কী পরিবর্তন করুন

### একাধিক প্রকল্প নিয়ে কাজ করা
প্রতিটি নমুনা প্রকল্প স্ট্যান্ডঅ্যালোন:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### সাধারণ সমস্যা

**জাভা ভার্সন মিসম্যাচ:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**নির্ভরতা ডাউনলোড সমস্যা:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub টোকেন পাওয়া যায়নি:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**পোর্ট ইতিমধ্যে ব্যবহৃত:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### বহু-ভাষার সমর্থন
- ৪৫+ ভাষায় ডকুমেন্টেশন উপলব্ধ, স্বয়ংক্রিয় অনুবাদের মাধ্যমে
- অনুবাদ `translations/` ডিরেক্টরিতে রয়েছে
- GitHub Actions ওয়ার্কফ্লো দ্বারা অনুবাদ পরিচালিত

### শেখার পথ
1. [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md) দিয়ে শুরু করুন
2. অধ্যায়গুলো ক্রমানুসারে অনুসরণ করুন (01 → 05)
3. প্রতিটি অধ্যায়ে হাতে-কলমে উদাহরণ সম্পন্ন করুন
4. অধ্যায় ৪-এ নমুনা প্রকল্পগুলি অন্বেষণ করুন
5. অধ্যায় ৫-এ দায়িত্বশীল এআই অনুশীলন শিখুন

### ডেভেলপমেন্ট কন্টেইনার
`.devcontainer/devcontainer.json` কনফিগার করে:
- জাভা ২১ ডেভেলপমেন্ট পরিবেশ
- প্রি-ইনস্টলড মেভেন
- VS Code জাভা এক্সটেনশন
- স্প্রিং বুট টুলস
- GitHub Copilot ইন্টিগ্রেশন
- Docker-in-Docker সমর্থন
- Azure CLI

### পারফরম্যান্স বিবেচনা
- GitHub Models ফ্রি টিয়ারে রেট সীমা রয়েছে
- এমবেডিংসের জন্য উপযুক্ত ব্যাচ সাইজ ব্যবহার করুন
- পুনরাবৃত্ত API কলের জন্য ক্যাশিং বিবেচনা করুন
- খরচ অপ্টিমাইজেশনের জন্য টোকেন ব্যবহার পর্যবেক্ষণ করুন

### নিরাপত্তা নোট
- `.env` ফাইল কখনোই কমিট করবেন না (`.gitignore`-এ ইতিমধ্যেই রয়েছে)
- API কী-এর জন্য পরিবেশ ভেরিয়েবল ব্যবহার করুন
- GitHub টোকেনের জন্য ন্যূনতম প্রয়োজনীয় স্কোপ রাখুন
- অধ্যায় ৫-এ দায়িত্বশীল এআই নির্দেশিকা অনুসরণ করুন

---

**অস্বীকৃতি**:  
এই নথিটি AI অনুবাদ পরিষেবা [Co-op Translator](https://github.com/Azure/co-op-translator) ব্যবহার করে অনুবাদ করা হয়েছে। আমরা যথাসাধ্য সঠিকতার জন্য চেষ্টা করি, তবে অনুগ্রহ করে মনে রাখবেন যে স্বয়ংক্রিয় অনুবাদে ত্রুটি বা অসঙ্গতি থাকতে পারে। মূল ভাষায় থাকা নথিটিকে প্রামাণিক উৎস হিসেবে বিবেচনা করা উচিত। গুরুত্বপূর্ণ তথ্যের জন্য, পেশাদার মানব অনুবাদ সুপারিশ করা হয়। এই অনুবাদ ব্যবহারের ফলে কোনো ভুল বোঝাবুঝি বা ভুল ব্যাখ্যা হলে আমরা দায়ী থাকব না।