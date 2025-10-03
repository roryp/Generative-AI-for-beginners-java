<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:32:49+00:00",
  "source_file": "AGENTS.md",
  "language_code": "mr"
}
-->
# AGENTS.md

## प्रकल्पाचा आढावा

हे जावा वापरून जनरेटिव्ह AI विकास शिकण्यासाठी एक शैक्षणिक रिपॉझिटरी आहे. यात मोठ्या भाषा मॉडेल्स (LLMs), प्रॉम्प्ट इंजिनिअरिंग, एम्बेडिंग्ज, RAG (Retrieval-Augmented Generation), आणि मॉडेल कॉन्टेक्स्ट प्रोटोकॉल (MCP) यांचा समावेश असलेला व्यापक हाताळणी अभ्यासक्रम आहे.

**मुख्य तंत्रज्ञान:**
- जावा 21
- स्प्रिंग बूट 3.5.x
- स्प्रिंग AI 1.1.x
- मावेन
- LangChain4j
- GitHub Models, Azure OpenAI, आणि OpenAI SDKs

**आर्किटेक्चर:**
- अध्यायांनुसार आयोजित केलेल्या अनेक स्वतंत्र स्प्रिंग बूट अनुप्रयोग
- विविध AI पॅटर्न्स दर्शविणारे नमुना प्रकल्प
- GitHub Codespaces साठी तयार, पूर्व-कॉन्फिगर केलेल्या डेव्ह कंटेनर्ससह

## सेटअप कमांड्स

### पूर्वतयारी
- जावा 21 किंवा त्याहून अधिक
- मावेन 3.x
- GitHub वैयक्तिक प्रवेश टोकन (GitHub Models साठी)
- पर्यायी: Azure OpenAI क्रेडेन्शियल्स

### पर्यावरण सेटअप

**पर्याय 1: GitHub Codespaces (शिफारस केलेले)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**पर्याय 2: स्थानिक डेव्ह कंटेनर**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**पर्याय 3: स्थानिक सेटअप**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### कॉन्फिगरेशन

**GitHub टोकन सेटअप:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI सेटअप (पर्यायी):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## विकास कार्यप्रवाह

### प्रकल्प संरचना
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

### अनुप्रयोग चालवणे

**स्प्रिंग बूट अनुप्रयोग चालवणे:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**प्रकल्प तयार करणे:**
```bash
cd [project-directory]
mvn clean install
```

**MCP कॅल्क्युलेटर सर्व्हर सुरू करणे:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**क्लायंट उदाहरणे चालवणे:**
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
स्प्रिंग बूट DevTools प्रकल्पांमध्ये समाविष्ट आहे जे हॉट रीलोडला समर्थन देतात:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## चाचणी सूचना

### चाचण्या चालवणे

**प्रकल्पातील सर्व चाचण्या चालवा:**
```bash
cd [project-directory]
mvn test
```

**सविस्तर आउटपुटसह चाचण्या चालवा:**
```bash
mvn test -X
```

**विशिष्ट चाचणी वर्ग चालवा:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### चाचणी संरचना
- चाचणी फाइल्स JUnit 5 (Jupiter) वापरतात
- चाचणी वर्ग `src/test/java/` मध्ये आहेत
- कॅल्क्युलेटर प्रकल्पातील क्लायंट उदाहरणे `src/test/java/com/microsoft/mcp/sample/client/` मध्ये आहेत

### मॅन्युअल चाचणी
अनेक उदाहरणे परस्पर अनुप्रयोग आहेत ज्यांना मॅन्युअल चाचणी आवश्यक आहे:

1. `mvn spring-boot:run` सह अनुप्रयोग सुरू करा
2. एंडपॉइंट्स चाचणी करा किंवा CLI सह संवाद साधा
3. अपेक्षित वर्तन प्रत्येक प्रकल्पाच्या README.md मध्ये दिलेल्या दस्तऐवजाशी जुळते का ते सत्यापित करा

### GitHub Models सह चाचणी
- फ्री टियर मर्यादा: 15 विनंत्या/मिनिट, 150/दिवस
- 5 एकत्रित विनंत्या जास्तीत जास्त
- जबाबदार AI उदाहरणांसह सामग्री फिल्टरिंग चाचणी करा

## कोड शैली मार्गदर्शक तत्त्वे

### जावा परंपरा
- **जावा आवृत्ती:** आधुनिक वैशिष्ट्यांसह जावा 21
- **शैली:** मानक जावा परंपरा पाळा
- **नावकरण:** 
  - वर्ग: PascalCase
  - पद्धती/चल: camelCase
  - स्थिरांक: UPPER_SNAKE_CASE
  - पॅकेज नावे: लोअरकेस

### स्प्रिंग बूट पॅटर्न्स
- व्यवसाय लॉजिकसाठी `@Service` वापरा
- REST एंडपॉइंट्ससाठी `@RestController` वापरा
- `application.yml` किंवा `application.properties` द्वारे कॉन्फिगरेशन
- हार्ड-कोडेड मूल्यांऐवजी पर्यावरणीय चलांचा वापर करा
- MCP-उघड केलेल्या पद्धतींसाठी `@Tool` अॅनोटेशन वापरा

### फाइल संघटन
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

### अवलंबित्व
- मावेन `pom.xml` द्वारे व्यवस्थापित
- स्प्रिंग AI BOM आवृत्ती व्यवस्थापनासाठी
- LangChain4j AI एकत्रीकरणासाठी
- स्प्रिंग अवलंबित्वांसाठी स्प्रिंग बूट स्टार्टर पॅरेंट

### कोड टिप्पण्या
- सार्वजनिक API साठी JavaDoc जोडा
- जटिल AI संवादांसाठी स्पष्टीकरणात्मक टिप्पण्या समाविष्ट करा
- MCP टूल वर्णन स्पष्टपणे दस्तऐवजीकरण करा

## बिल्ड आणि उपयोजन

### प्रकल्प तयार करणे

**चाचण्यांशिवाय बिल्ड करा:**
```bash
mvn clean install -DskipTests
```

**सर्व तपासणीसह बिल्ड करा:**
```bash
mvn clean install
```

**अनुप्रयोग पॅकेज करा:**
```bash
mvn package
# Creates JAR in target/ directory
```

### आउटपुट निर्देशिका
- संकलित वर्ग: `target/classes/`
- चाचणी वर्ग: `target/test-classes/`
- JAR फाइल्स: `target/*.jar`
- मावेन आर्टिफॅक्ट्स: `target/`

### पर्यावरण-विशिष्ट कॉन्फिगरेशन

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
- GitHub Models ऐवजी Azure AI Foundry Models वापरा
- बेस-url Azure OpenAI एंडपॉइंटवर अपडेट करा
- Azure Key Vault किंवा पर्यावरणीय चलांद्वारे गुपिते व्यवस्थापित करा

### उपयोजन विचार
- हे शैक्षणिक रिपॉझिटरी आहे ज्यामध्ये नमुना अनुप्रयोग आहेत
- उत्पादन उपयोजनासाठी डिझाइन केलेले नाही
- नमुने उत्पादन वापरासाठी अनुकूल करण्यासाठी पॅटर्न दर्शवतात
- विशिष्ट उपयोजन टिप्पण्या प्रत्येक प्रकल्पाच्या README मध्ये पहा

## अतिरिक्त टिप्पण्या

### GitHub Models विरुद्ध Azure OpenAI
- **GitHub Models:** शिकण्यासाठी फ्री टियर, क्रेडिट कार्ड आवश्यक नाही
- **Azure OpenAI:** उत्पादनासाठी तयार, Azure सदस्यता आवश्यक
- कोड दोन्हींसाठी सुसंगत आहे - फक्त एंडपॉइंट आणि API की बदला

### अनेक प्रकल्पांसह काम करणे
प्रत्येक नमुना प्रकल्प स्वतंत्र आहे:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### सामान्य समस्या

**जावा आवृत्ती विसंगती:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**अवलंबित्व डाउनलोड समस्या:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub टोकन सापडले नाही:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**पोर्ट आधीच वापरात आहे:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### बहुभाषिक समर्थन
- स्वयंचलित भाषांतराद्वारे 45+ भाषांमध्ये दस्तऐवजीकरण उपलब्ध
- भाषांतर `translations/` निर्देशिकेत
- GitHub Actions कार्यप्रवाहाद्वारे भाषांतर व्यवस्थापित

### शिकण्याचा मार्ग
1. [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md) पासून प्रारंभ करा
2. अध्याय क्रमाने अनुसरण करा (01 → 05)
3. प्रत्येक अध्यायातील हाताळणी उदाहरणे पूर्ण करा
4. अध्याय 4 मधील नमुना प्रकल्प एक्सप्लोर करा
5. अध्याय 5 मध्ये जबाबदार AI पद्धती शिका

### विकास कंटेनर
`.devcontainer/devcontainer.json` कॉन्फिगर करते:
- जावा 21 विकास पर्यावरण
- मावेन पूर्व-स्थापित
- VS कोड जावा विस्तार
- स्प्रिंग बूट साधने
- GitHub Copilot एकत्रीकरण
- Docker-in-Docker समर्थन
- Azure CLI

### कार्यक्षमता विचार
- GitHub Models फ्री टियरमध्ये दर मर्यादा आहेत
- एम्बेडिंग्जसाठी योग्य बॅच आकार वापरा
- पुनरावृत्त API कॉलसाठी कॅशिंग विचारात घ्या
- खर्च ऑप्टिमायझेशनसाठी टोकन वापराचे निरीक्षण करा

### सुरक्षा टिप्पण्या
- `.env` फाइल्स कधीही कमिट करू नका (`.gitignore` मध्ये आधीच आहे)
- API कीसाठी पर्यावरणीय चलांचा वापर करा
- GitHub टोकनमध्ये आवश्यक किमान स्कोप असावेत
- अध्याय 5 मध्ये जबाबदार AI मार्गदर्शक तत्त्वांचे अनुसरण करा

---

**अस्वीकरण**:  
हा दस्तऐवज AI भाषांतर सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) वापरून भाषांतरित करण्यात आला आहे. आम्ही अचूकतेसाठी प्रयत्नशील असलो तरी कृपया लक्षात ठेवा की स्वयंचलित भाषांतरे त्रुटी किंवा अचूकतेच्या अभावाने युक्त असू शकतात. मूळ भाषेतील दस्तऐवज हा अधिकृत स्रोत मानला जावा. महत्त्वाच्या माहितीसाठी व्यावसायिक मानवी भाषांतराची शिफारस केली जाते. या भाषांतराचा वापर करून उद्भवलेल्या कोणत्याही गैरसमज किंवा चुकीच्या अर्थासाठी आम्ही जबाबदार राहणार नाही.