<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:45:50+00:00",
  "source_file": "AGENTS.md",
  "language_code": "my"
}
-->
# AGENTS.md

## ပရောဂျက်အကြောင်းအရာ

ဒီဟာက Java နဲ့ Generative AI ဖွံ့ဖြိုးတိုးတက်မှုကို သင်ယူဖို့အတွက် ပညာရေးဆိုင်ရာ repository တစ်ခုဖြစ်ပါတယ်။ ဒါဟာ Large Language Models (LLMs), prompt engineering, embeddings, RAG (Retrieval-Augmented Generation), နဲ့ Model Context Protocol (MCP) တို့ကို အပြည့်အစုံ လက်တွေ့လုပ်ဆောင်နိုင်တဲ့ သင်တန်းတစ်ခုကို ပံ့ပိုးပေးပါတယ်။

**အဓိက နည်းပညာများ:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI, နဲ့ OpenAI SDKs

**Architecture:**
- အခန်းအလိုက် စီစဉ်ထားတဲ့ standalone Spring Boot အက်ပလီကေးရှင်းများ
- အမျိုးမျိုးသော AI ပုံစံများကို ပြသတဲ့ နမူနာပရောဂျက်များ
- GitHub Codespaces-ready နဲ့ ကြိုတင်ပြင်ဆင်ထားတဲ့ dev containers

## Setup Commands

### လိုအပ်ချက်များ
- Java 21 သို့မဟုတ် အထက်
- Maven 3.x
- GitHub personal access token (GitHub Models အတွက်)
- အလိုအလျောက်: Azure OpenAI အချက်အလက်များ

### ပတ်ဝန်းကျင် ပြင်ဆင်မှု

**နည်းလမ်း ၁: GitHub Codespaces (အကြံပြုသည်)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**နည်းလမ်း ၂: Local Dev Container**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**နည်းလမ်း ၃: Local Setup**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Configuration

**GitHub Token Setup:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI Setup (အလိုအလျောက်):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## ဖွံ့ဖြိုးတိုးတက်မှု လုပ်ငန်းစဉ်

### ပရောဂျက်ဖွဲ့စည်းမှု
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

### အက်ပလီကေးရှင်းများကို အလုပ်လုပ်စေခြင်း

**Spring Boot အက်ပလီကေးရှင်းတစ်ခုကို အလုပ်လုပ်စေခြင်း:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**ပရောဂျက်တစ်ခုကို Build လုပ်ခြင်း:**
```bash
cd [project-directory]
mvn clean install
```

**MCP Calculator Server ကို စတင်ခြင်း:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Client နမူနာများကို အလုပ်လုပ်စေခြင်း:**
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

### Hot Reload
Spring Boot DevTools ကို hot reload ကို ပံ့ပိုးတဲ့ ပရောဂျက်များတွင် ထည့်သွင်းထားသည်:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## စမ်းသပ်မှု လမ်းညွှန်ချက်များ

### စမ်းသပ်မှုများကို အလုပ်လုပ်စေခြင်း

**ပရောဂျက်တစ်ခုအတွင်းရှိ စမ်းသပ်မှုအားလုံးကို အလုပ်လုပ်စေခြင်း:**
```bash
cd [project-directory]
mvn test
```

**အသေးစိတ် output ဖြင့် စမ်းသပ်မှုများကို အလုပ်လုပ်စေခြင်း:**
```bash
mvn test -X
```

**သတ်မှတ်ထားသော စမ်းသပ်မှုအတန်းတစ်ခုကို အလုပ်လုပ်စေခြင်း:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### စမ်းသပ်မှုဖွဲ့စည်းမှု
- စမ်းသပ်မှုဖိုင်များသည် JUnit 5 (Jupiter) ကို အသုံးပြုသည်
- စမ်းသပ်မှုအတန်းများကို `src/test/java/` တွင် တွေ့နိုင်သည်
- calculator ပရောဂျက်အတွင်းရှိ client နမူနာများကို `src/test/java/com/microsoft/mcp/sample/client/` တွင် တွေ့နိုင်သည်

### လက်ဖြင့် စမ်းသပ်ခြင်း
နမူနာများအများစုသည် လက်တွေ့အက်ပလီကေးရှင်းများဖြစ်ပြီး လက်ဖြင့် စမ်းသပ်ရန် လိုအပ်သည်:

1. `mvn spring-boot:run` ဖြင့် အက်ပလီကေးရှင်းကို စတင်ပါ
2. Endpoints ကို စမ်းသပ်ပါ သို့မဟုတ် CLI နှင့် အပြန်အလှန်လုပ်ဆောင်ပါ
3. မျှော်မှန်းထားသော အပြုအမူသည် တစ်ခုချင်း README.md တွင် ဖော်ပြထားသော အချက်အလက်နှင့် ကိုက်ညီမှုရှိကြောင်း အတည်ပြုပါ

### GitHub Models ဖြင့် စမ်းသပ်ခြင်း
- အခမဲ့အဆင့်ကန့်သတ်ချက်များ: ၁၅ တောင်းဆိုမှု/မိနစ်, ၁၅၀/နေ့
- တစ်ချိန်တည်းတွင် ၅ တောင်းဆိုမှုအများဆုံး
- တာဝန်ရှိသော AI နမူနာများဖြင့် အကြောင်းအရာစစ်ထုတ်မှုကို စမ်းသပ်ပါ

## ကုဒ်စတိုင် လမ်းညွှန်ချက်များ

### Java စံသတ်မှတ်များ
- **Java ဗားရှင်း:** Java 21 နှင့် ခေတ်မီအင်္ဂါရပ်များ
- **စတိုင်:** စံ Java စံသတ်မှတ်များကို လိုက်နာပါ
- **အမည်ပေးခြင်း:**
  - Classes: PascalCase
  - Methods/variables: camelCase
  - Constants: UPPER_SNAKE_CASE
  - Package names: lowercase

### Spring Boot ပုံစံများ
- `@Service` ကို စီးပွားရေးလောကအတွက် အသုံးပြုပါ
- `@RestController` ကို REST endpoints အတွက် အသုံးပြုပါ
- `application.yml` သို့မဟုတ် `application.properties` မှတစ်ဆင့် configuration ပြုလုပ်ပါ
- hard-coded တန်ဖိုးများထက် ပတ်ဝန်းကျင်အပြောင်းအလဲများကို အသုံးပြုပါ
- MCP ဖြင့် ဖော်ပြထားသော နည်းလမ်းများအတွက် `@Tool` annotation ကို အသုံးပြုပါ

### ဖိုင်စီစဉ်မှု
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

### အခြားလိုအပ်ချက်များ
- Maven `pom.xml` မှတစ်ဆင့် စီမံပါ
- Spring AI BOM ကို ဗားရှင်းစီမံခန့်ခွဲမှုအတွက် အသုံးပြုပါ
- LangChain4j ကို AI ပေါင်းစည်းမှုများအတွက် အသုံးပြုပါ
- Spring Boot starter parent ကို Spring အခြေခံလိုအပ်ချက်များအတွက် အသုံးပြုပါ

### ကုဒ်မှတ်ချက်များ
- Public APIs အတွက် JavaDoc ထည့်ပါ
- AI အပြုအမူများအတွက် ရှင်းလင်းချက်မှတ်ချက်များ ထည့်ပါ
- MCP tool ဖော်ပြချက်များကို ရှင်းလင်းစွာ မှတ်သားပါ

## Build နှင့် Deployment

### ပရောဂျက်များကို Build လုပ်ခြင်း

**စမ်းသပ်မှုမပါဘဲ Build လုပ်ခြင်း:**
```bash
mvn clean install -DskipTests
```

**အားလုံးစစ်ဆေးမှုများနှင့်အတူ Build လုပ်ခြင်း:**
```bash
mvn clean install
```

**အက်ပလီကေးရှင်းကို Package လုပ်ခြင်း:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Output Directories
- Compile လုပ်ထားသော classes: `target/classes/`
- စမ်းသပ်မှု classes: `target/test-classes/`
- JAR ဖိုင်များ: `target/*.jar`
- Maven artifacts: `target/`

### ပတ်ဝန်းကျင်အလိုက် Configuration

**ဖွံ့ဖြိုးတိုးတက်မှု:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**ထုတ်လုပ်မှု:**
- GitHub Models အစား Azure AI Foundry Models ကို အသုံးပြုပါ
- base-url ကို Azure OpenAI endpoint သို့ ပြောင်းပါ
- အချက်အလက်များကို Azure Key Vault သို့မဟုတ် ပတ်ဝန်းကျင်အပြောင်းအလဲများမှတစ်ဆင့် စီမံပါ

### Deployment အတွေးအခေါ်များ
- ဒီဟာက ပညာရေးဆိုင်ရာ repository ဖြစ်ပြီး နမူနာအက်ပလီကေးရှင်းများပါဝင်သည်
- အစီအစဉ်အတိုင်း ထုတ်လုပ်မှုအတွက် မထုတ်လုပ်ထားပါ
- နမူနာများသည် ထုတ်လုပ်မှုအတွက် ပြောင်းလဲအသုံးပြုနိုင်သော ပုံစံများကို ပြသသည်
- တစ်ခုချင်း README.md တွင် သီးခြား Deployment မှတ်ချက်များကို ကြည့်ပါ

## အပိုဆောင်း မှတ်ချက်များ

### GitHub Models နှင့် Azure OpenAI
- **GitHub Models:** သင်ယူရန် အခမဲ့အဆင့်၊ ကတ်မလိုအပ်
- **Azure OpenAI:** ထုတ်လုပ်မှုအဆင့်၊ Azure subscription လိုအပ်
- Code သည် နှစ်ခုလုံးနှင့် ကိုက်ညီသည် - endpoint နဲ့ API key ကိုသာ ပြောင်းပါ

### ပရောဂျက်များစွာနှင့် အလုပ်လုပ်ခြင်း
နမူနာပရောဂျက်တစ်ခုချင်းစီသည် standalone ဖြစ်သည်:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### ရှိနိုင်သော ပြဿနာများ

**Java ဗားရှင်း မကိုက်ညီမှု:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**အခြေခံလိုအပ်ချက်များ ဒေါင်းလုဒ်မရ:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub Token မတွေ့ရှိ:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Port သုံးပြီးသား:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### ဘာသာစကားများစွာကို ပံ့ပိုးမှု
- စာရွက်စာတမ်းများကို အလိုအလျောက် ဘာသာပြန်ခြင်းဖြင့် ၄၅+ ဘာသာစကားများတွင် ရရှိနိုင်သည်
- `translations/` ဖိုဒါတွင် ဘာသာပြန်ထားသော ဖိုင်များ
- Translation ကို GitHub Actions workflow ဖြင့် စီမံသည်

### သင်ကြားမှု လမ်းကြောင်း
1. [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md) ဖြင့် စတင်ပါ
2. အခန်းအလိုက် အစဉ်လိုက်လိုက်ပါ (01 → 05)
3. အခန်းတစ်ခုချင်းစီတွင် လက်တွေ့နမူနာများကို ပြီးမြောက်ပါ
4. အခန်း ၄ တွင် နမူနာပရောဂျက်များကို စူးစမ်းပါ
5. အခန်း ၅ တွင် တာဝန်ရှိသော AI လုပ်ငန်းစဉ်များကို သင်ယူပါ

### Development Container
`.devcontainer/devcontainer.json` သည် အောက်ပါအရာများကို ပြင်ဆင်ထားသည်:
- Java 21 ဖွံ့ဖြိုးတိုးတက်မှု ပတ်ဝန်းကျင်
- Maven ကြိုတင်တပ်ဆင်ထားသည်
- VS Code Java extensions
- Spring Boot tools
- GitHub Copilot ပေါင်းစည်းမှု
- Docker-in-Docker ပံ့ပိုးမှု
- Azure CLI

### စွမ်းဆောင်ရည် အတွေးအခေါ်များ
- GitHub Models အခမဲ့အဆင့်တွင် ကန့်သတ်ချက်များရှိသည်
- Embeddings အတွက် သင့်တော်သော batch အရွယ်အစားများကို အသုံးပြုပါ
- API တောင်းဆိုမှုများကို ထပ်ခါတလဲလဲ မလုပ်ရန် caching ကို စဉ်းစားပါ
- ကုန်ကျစရိတ် အထိရောက်မှုအတွက် token အသုံးပြုမှုကို စောင့်ကြည့်ပါ

### လုံခြုံရေး မှတ်ချက်များ
- `.env` ဖိုင်များကို ဘယ်တော့မှ commit မလုပ်ပါ (ပြီးသား `.gitignore` တွင် ပါဝင်သည်)
- API key များအတွက် ပတ်ဝန်းကျင်အပြောင်းအလဲများကို အသုံးပြုပါ
- GitHub tokens တွင် လိုအပ်သော scope များသာ ပါဝင်စေရန် သေချာပါ
- အခန်း ၅ တွင် တာဝန်ရှိသော AI လမ်းညွှန်ချက်များကို လိုက်နာပါ

---

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်မှုများတွင် အမှားများ သို့မဟုတ် မမှန်ကန်မှုများ ပါဝင်နိုင်သည်ကို သတိပြုပါ။ မူရင်းဘာသာစကားဖြင့် ရေးသားထားသော စာရွက်စာတမ်းကို အာဏာတရ အရင်းအမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူက ဘာသာပြန်မှုကို အသုံးပြုရန် အကြံပြုပါသည်။ ဤဘာသာပြန်မှုကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအလွတ်များ သို့မဟုတ် အနားယူမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။