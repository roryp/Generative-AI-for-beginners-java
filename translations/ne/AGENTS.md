<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:33:18+00:00",
  "source_file": "AGENTS.md",
  "language_code": "ne"
}
-->
# AGENTS.md

## परियोजना अवलोकन

यो Java प्रयोग गरेर Generative AI विकास सिक्नको लागि शैक्षिक रिपोजिटरी हो। यसले Large Language Models (LLMs), प्रम्प्ट इन्जिनियरिङ, embeddings, RAG (Retrieval-Augmented Generation), र Model Context Protocol (MCP) समेट्ने व्यापक व्यावहारिक पाठ्यक्रम प्रदान गर्दछ।

**मुख्य प्रविधिहरू:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI, र OpenAI SDKs

**आर्किटेक्चर:**
- अध्यायहरूद्वारा व्यवस्थित धेरै स्वतन्त्र Spring Boot एप्लिकेसनहरू
- विभिन्न AI ढाँचाहरू प्रदर्शन गर्ने नमूना परियोजनाहरू
- GitHub Codespaces-को लागि तयार, पूर्व-कन्फिगर गरिएको विकास कन्टेनरहरूसहित

## सेटअप कमाण्डहरू

### आवश्यकताहरू
- Java 21 वा उच्च संस्करण
- Maven 3.x
- GitHub व्यक्तिगत पहुँच टोकन (GitHub Models को लागि)
- वैकल्पिक: Azure OpenAI प्रमाणहरू

### वातावरण सेटअप

**विकल्प 1: GitHub Codespaces (सिफारिस गरिएको)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**विकल्प 2: स्थानीय विकास कन्टेनर**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**विकल्प 3: स्थानीय सेटअप**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### कन्फिगरेसन

**GitHub टोकन सेटअप:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI सेटअप (वैकल्पिक):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## विकास कार्यप्रवाह

### परियोजना संरचना
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

### एप्लिकेसनहरू चलाउने

**Spring Boot एप्लिकेसन चलाउने:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**परियोजना निर्माण गर्ने:**
```bash
cd [project-directory]
mvn clean install
```

**MCP Calculator Server सुरु गर्ने:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Client उदाहरणहरू चलाउने:**
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

### हॉट रीलोड
Spring Boot DevTools परियोजनाहरूमा समावेश गरिएको छ जसले हॉट रीलोडलाई समर्थन गर्दछ:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## परीक्षण निर्देशनहरू

### परीक्षण चलाउने

**परियोजनामा सबै परीक्षणहरू चलाउनुहोस्:**
```bash
cd [project-directory]
mvn test
```

**विस्तृत आउटपुटसहित परीक्षण चलाउनुहोस्:**
```bash
mvn test -X
```

**विशिष्ट परीक्षण कक्षा चलाउनुहोस्:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### परीक्षण संरचना
- परीक्षण फाइलहरू JUnit 5 (Jupiter) प्रयोग गर्छन्
- परीक्षण कक्षाहरू `src/test/java/` मा अवस्थित छन्
- Calculator परियोजनामा Client उदाहरणहरू `src/test/java/com/microsoft/mcp/sample/client/` मा छन्

### म्यानुअल परीक्षण
धेरै उदाहरणहरू अन्तरक्रियात्मक एप्लिकेसनहरू हुन् जसले म्यानुअल परीक्षणको आवश्यकता पर्दछ:

1. `mvn spring-boot:run` प्रयोग गरेर एप्लिकेसन सुरु गर्नुहोस्
2. Endpoints परीक्षण गर्नुहोस् वा CLI सँग अन्तरक्रिया गर्नुहोस्
3. प्रत्येक परियोजनाको README.md मा रहेको दस्तावेजसँग अपेक्षित व्यवहार मिलेको छ कि छैन जाँच गर्नुहोस्

### GitHub Models सँग परीक्षण
- निःशुल्क स्तर सीमा: 15 अनुरोध/मिनेट, 150/दिन
- अधिकतम 5 समवर्ती अनुरोधहरू
- जिम्मेवार AI उदाहरणहरूसँग सामग्री फिल्टरिङ परीक्षण गर्नुहोस्

## कोड शैली दिशानिर्देशहरू

### Java परम्पराहरू
- **Java संस्करण:** आधुनिक सुविधाहरू सहित Java 21
- **शैली:** मानक Java परम्पराहरू अनुसरण गर्नुहोस्
- **नामकरण:** 
  - कक्षाहरू: PascalCase
  - विधिहरू/चरहरू: camelCase
  - Constants: UPPER_SNAKE_CASE
  - प्याकेज नामहरू: सानो अक्षर

### Spring Boot ढाँचाहरू
- व्यवसायिक तर्कको लागि `@Service` प्रयोग गर्नुहोस्
- REST endpoints को लागि `@RestController` प्रयोग गर्नुहोस्
- `application.yml` वा `application.properties` मार्फत कन्फिगरेसन
- हार्ड-कोड गरिएको मानहरू भन्दा वातावरण चरहरू प्राथमिकता दिनुहोस्
- MCP-प्रदर्शित विधिहरूको लागि `@Tool` एनोटेसन प्रयोग गर्नुहोस्

### फाइल संगठन
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

### निर्भरताहरू
- Maven `pom.xml` मार्फत व्यवस्थापन गरिएको
- संस्करण व्यवस्थापनको लागि Spring AI BOM
- AI एकीकरणहरूको लागि LangChain4j
- Spring निर्भरताहरूको लागि Spring Boot starter parent

### कोड टिप्पणीहरू
- सार्वजनिक APIs को लागि JavaDoc थप्नुहोस्
- जटिल AI अन्तरक्रियाहरूको लागि व्याख्यात्मक टिप्पणीहरू समावेश गर्नुहोस्
- MCP उपकरण विवरणहरू स्पष्ट रूपमा दस्तावेज गर्नुहोस्

## निर्माण र परिनियोजन

### परियोजनाहरू निर्माण गर्ने

**परीक्षण बिना निर्माण गर्नुहोस्:**
```bash
mvn clean install -DskipTests
```

**सबै जाँचसहित निर्माण गर्नुहोस्:**
```bash
mvn clean install
```

**एप्लिकेसन प्याकेज गर्नुहोस्:**
```bash
mvn package
# Creates JAR in target/ directory
```

### आउटपुट निर्देशिकाहरू
- संकलित कक्षाहरू: `target/classes/`
- परीक्षण कक्षाहरू: `target/test-classes/`
- JAR फाइलहरू: `target/*.jar`
- Maven कलाकृतिहरू: `target/`

### वातावरण-विशिष्ट कन्फिगरेसन

**विकास:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**उत्पादन:**
- GitHub Models को सट्टा Azure AI Foundry Models प्रयोग गर्नुहोस्
- आधार-url Azure OpenAI endpoint मा अद्यावधिक गर्नुहोस्
- Azure Key Vault वा वातावरण चरहरू मार्फत गोप्य व्यवस्थापन गर्नुहोस्

### परिनियोजन विचारहरू
- यो नमूना एप्लिकेसनहरूसहित शैक्षिक रिपोजिटरी हो
- उत्पादन परिनियोजनको लागि डिजाइन गरिएको छैन
- नमूनाहरू उत्पादन प्रयोगको लागि अनुकूलन गर्न ढाँचाहरू प्रदर्शन गर्छन्
- विशिष्ट परिनियोजन नोटहरूको लागि व्यक्तिगत परियोजना README हरू हेर्नुहोस्

## थप नोटहरू

### GitHub Models बनाम Azure OpenAI
- **GitHub Models:** सिक्नको लागि निःशुल्क स्तर, क्रेडिट कार्ड आवश्यक छैन
- **Azure OpenAI:** उत्पादन-तयार, Azure सदस्यता आवश्यक
- कोड दुवैसँग उपयुक्त छ - केवल endpoint र API key परिवर्तन गर्नुहोस्

### धेरै परियोजनाहरूको साथ काम गर्ने
प्रत्येक नमूना परियोजना स्वतन्त्र छ:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### सामान्य समस्याहरू

**Java संस्करण मेल खाएन:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**निर्भरता डाउनलोड समस्याहरू:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub टोकन फेला परेन:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**पोर्ट पहिले नै प्रयोगमा छ:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### बहु-भाषा समर्थन
- स्वचालित अनुवाद मार्फत 45+ भाषाहरूमा उपलब्ध दस्तावेज
- अनुवादहरू `translations/` निर्देशिकामा
- अनुवाद GitHub Actions कार्यप्रवाहद्वारा व्यवस्थापन गरिएको

### सिक्ने मार्ग
1. [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md) बाट सुरु गर्नुहोस्
2. अध्यायहरू क्रम अनुसार अनुसरण गर्नुहोस् (01 → 05)
3. प्रत्येक अध्यायमा व्यावहारिक उदाहरणहरू पूरा गर्नुहोस्
4. अध्याय 4 मा नमूना परियोजनाहरू अन्वेषण गर्नुहोस्
5. अध्याय 5 मा जिम्मेवार AI अभ्यासहरू सिक्नुहोस्

### विकास कन्टेनर
`.devcontainer/devcontainer.json` ले कन्फिगर गर्दछ:
- Java 21 विकास वातावरण
- Maven पूर्व-स्थापित
- VS Code Java विस्तारहरू
- Spring Boot उपकरणहरू
- GitHub Copilot एकीकरण
- Docker-in-Docker समर्थन
- Azure CLI

### प्रदर्शन विचारहरू
- GitHub Models निःशुल्क स्तरमा दर सीमा छ
- embeddings को लागि उपयुक्त ब्याच आकारहरू प्रयोग गर्नुहोस्
- दोहोरिएका API कलहरूको लागि क्यासिङ विचार गर्नुहोस्
- लागत अनुकूलनको लागि टोकन प्रयोगको निगरानी गर्नुहोस्

### सुरक्षा नोटहरू
- `.env` फाइलहरू कहिल्यै कमिट नगर्नुहोस् (`.gitignore` मा पहिले नै समावेश गरिएको)
- API key को लागि वातावरण चरहरू प्रयोग गर्नुहोस्
- GitHub टोकनहरूमा न्यूनतम आवश्यक स्कोपहरू हुनु पर्छ
- अध्याय 5 मा जिम्मेवार AI दिशानिर्देशहरू अनुसरण गर्नुहोस्

---

**अस्वीकरण**:  
यो दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) प्रयोग गरेर अनुवाद गरिएको हो। हामी यथासम्भव शुद्धता सुनिश्चित गर्न प्रयास गर्छौं, तर कृपया ध्यान दिनुहोस् कि स्वचालित अनुवादमा त्रुटिहरू वा अशुद्धताहरू हुन सक्छ। मूल दस्तावेज़ यसको मातृभाषामा आधिकारिक स्रोत मानिनुपर्छ। महत्वपूर्ण जानकारीको लागि, व्यावसायिक मानव अनुवाद सिफारिस गरिन्छ। यस अनुवादको प्रयोगबाट उत्पन्न हुने कुनै पनि गलतफहमी वा गलत व्याख्याको लागि हामी जिम्मेवार हुनेछैनौं।