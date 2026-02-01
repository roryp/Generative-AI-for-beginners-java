# AGENTS.md

## परियोजना का अवलोकन

यह एक शैक्षिक रिपॉजिटरी है जो Java के साथ Generative AI विकास सीखने के लिए बनाई गई है। यह एक व्यापक व्यावहारिक पाठ्यक्रम प्रदान करती है, जिसमें Large Language Models (LLMs), प्रॉम्प्ट इंजीनियरिंग, एम्बेडिंग्स, RAG (Retrieval-Augmented Generation), और Model Context Protocol (MCP) शामिल हैं।

**मुख्य तकनीकें:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI, और OpenAI SDKs

**आर्किटेक्चर:**
- अध्यायों के अनुसार व्यवस्थित कई स्वतंत्र Spring Boot एप्लिकेशन
- विभिन्न AI पैटर्न प्रदर्शित करने वाले नमूना प्रोजेक्ट्स
- GitHub Codespaces के लिए तैयार, पूर्व-कॉन्फ़िगर किए गए डेवलपमेंट कंटेनर्स

## सेटअप कमांड्स

### आवश्यकताएँ
- Java 21 या उच्चतर
- Maven 3.x
- GitHub व्यक्तिगत एक्सेस टोकन (GitHub Models के लिए)
- वैकल्पिक: Azure OpenAI क्रेडेंशियल्स

### पर्यावरण सेटअप

**विकल्प 1: GitHub Codespaces (अनुशंसित)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**विकल्प 2: लोकल डेवलपमेंट कंटेनर**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**विकल्प 3: लोकल सेटअप**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### कॉन्फ़िगरेशन

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

### एप्लिकेशन चलाना

**Spring Boot एप्लिकेशन चलाना:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**प्रोजेक्ट बनाना:**
```bash
cd [project-directory]
mvn clean install
```

**MCP कैलकुलेटर सर्वर शुरू करना:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**क्लाइंट उदाहरण चलाना:**
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
Spring Boot DevTools उन प्रोजेक्ट्स में शामिल है जो हॉट रीलोड का समर्थन करते हैं:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## परीक्षण निर्देश

### परीक्षण चलाना

**प्रोजेक्ट में सभी परीक्षण चलाना:**
```bash
cd [project-directory]
mvn test
```

**विस्तृत आउटपुट के साथ परीक्षण चलाना:**
```bash
mvn test -X
```

**विशिष्ट टेस्ट क्लास चलाना:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### परीक्षण संरचना
- टेस्ट फाइलें JUnit 5 (Jupiter) का उपयोग करती हैं
- टेस्ट क्लास `src/test/java/` में स्थित हैं
- कैलकुलेटर प्रोजेक्ट में क्लाइंट उदाहरण `src/test/java/com/microsoft/mcp/sample/client/` में हैं

### मैनुअल परीक्षण
कई उदाहरण इंटरैक्टिव एप्लिकेशन हैं जिन्हें मैनुअल परीक्षण की आवश्यकता होती है:

1. एप्लिकेशन को `mvn spring-boot:run` के साथ शुरू करें
2. एंडपॉइंट्स का परीक्षण करें या CLI के साथ इंटरैक्ट करें
3. सुनिश्चित करें कि अपेक्षित व्यवहार प्रत्येक प्रोजेक्ट के README.md में दिए गए दस्तावेज़ से मेल खाता है

### GitHub Models के साथ परीक्षण
- मुफ्त टियर सीमाएँ: 15 अनुरोध/मिनट, 150/दिन
- अधिकतम 5 समवर्ती अनुरोध
- जिम्मेदार AI उदाहरणों के साथ सामग्री फ़िल्टरिंग का परीक्षण करें

## कोड शैली दिशानिर्देश

### Java कन्वेंशन्स
- **Java संस्करण:** Java 21 आधुनिक फीचर्स के साथ
- **शैली:** मानक Java कन्वेंशन्स का पालन करें
- **नामकरण:** 
  - क्लासेस: PascalCase
  - मेथड्स/वेरिएबल्स: camelCase
  - कॉन्स्टेंट्स: UPPER_SNAKE_CASE
  - पैकेज नाम: लोअरकेस

### Spring Boot पैटर्न
- बिजनेस लॉजिक के लिए `@Service` का उपयोग करें
- REST एंडपॉइंट्स के लिए `@RestController` का उपयोग करें
- कॉन्फ़िगरेशन `application.yml` या `application.properties` के माध्यम से करें
- हार्ड-कोडेड मानों के बजाय पर्यावरण वेरिएबल्स का उपयोग करें
- MCP-एक्सपोज़्ड मेथड्स के लिए `@Tool` एनोटेशन का उपयोग करें

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

### डिपेंडेंसीज़
- Maven `pom.xml` के माध्यम से प्रबंधित
- Spring AI BOM संस्करण प्रबंधन के लिए
- LangChain4j AI इंटीग्रेशन के लिए
- Spring डिपेंडेंसीज़ के लिए Spring Boot स्टार्टर पैरेंट

### कोड टिप्पणियाँ
- सार्वजनिक APIs के लिए JavaDoc जोड़ें
- जटिल AI इंटरैक्शन के लिए व्याख्यात्मक टिप्पणियाँ शामिल करें
- MCP टूल विवरण स्पष्ट रूप से दस्तावेज़ करें

## निर्माण और परिनियोजन

### प्रोजेक्ट्स बनाना

**टेस्ट के बिना निर्माण:**
```bash
mvn clean install -DskipTests
```

**सभी चेक के साथ निर्माण:**
```bash
mvn clean install
```

**एप्लिकेशन पैकेज करना:**
```bash
mvn package
# Creates JAR in target/ directory
```

### आउटपुट डायरेक्टरीज़
- संकलित क्लासेस: `target/classes/`
- टेस्ट क्लासेस: `target/test-classes/`
- JAR फाइलें: `target/*.jar`
- Maven आर्टिफैक्ट्स: `target/`

### पर्यावरण-विशिष्ट कॉन्फ़िगरेशन

**विकास:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**प्रोडक्शन:**
- GitHub Models के बजाय Azure AI Foundry Models का उपयोग करें
- बेस-URL को Azure OpenAI एंडपॉइंट में अपडेट करें
- Azure Key Vault या पर्यावरण वेरिएबल्स के माध्यम से सीक्रेट्स प्रबंधित करें

### परिनियोजन विचार
- यह एक शैक्षिक रिपॉजिटरी है जिसमें नमूना एप्लिकेशन हैं
- उत्पादन परिनियोजन के लिए डिज़ाइन नहीं किया गया है
- नमूने उत्पादन उपयोग के लिए पैटर्न प्रदर्शित करते हैं
- विशिष्ट परिनियोजन नोट्स के लिए व्यक्तिगत प्रोजेक्ट READMEs देखें

## अतिरिक्त नोट्स

### GitHub Models बनाम Azure OpenAI
- **GitHub Models:** सीखने के लिए मुफ्त टियर, क्रेडिट कार्ड की आवश्यकता नहीं
- **Azure OpenAI:** उत्पादन-तैयार, Azure सदस्यता की आवश्यकता
- कोड दोनों के साथ संगत है - केवल एंडपॉइंट और API कुंजी बदलें

### कई प्रोजेक्ट्स के साथ काम करना
प्रत्येक नमूना प्रोजेक्ट स्वतंत्र है:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### सामान्य समस्याएँ

**Java संस्करण का मेल न होना:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**डिपेंडेंसी डाउनलोड समस्याएँ:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub टोकन नहीं मिला:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**पोर्ट पहले से उपयोग में है:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### बहुभाषी समर्थन
- दस्तावेज़ 45+ भाषाओं में उपलब्ध है स्वचालित अनुवाद के माध्यम से
- अनुवाद `translations/` डायरेक्टरी में हैं
- अनुवाद GitHub Actions वर्कफ़्लो द्वारा प्रबंधित

### सीखने का मार्ग
1. [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md) से शुरू करें
2. अध्यायों को क्रम में पूरा करें (01 → 05)
3. प्रत्येक अध्याय में व्यावहारिक उदाहरण पूरे करें
4. अध्याय 4 में नमूना प्रोजेक्ट्स का अन्वेषण करें
5. अध्याय 5 में जिम्मेदार AI प्रथाओं को सीखें

### विकास कंटेनर
`.devcontainer/devcontainer.json` कॉन्फ़िगर करता है:
- Java 21 विकास पर्यावरण
- पूर्व-स्थापित Maven
- VS Code Java एक्सटेंशन्स
- Spring Boot टूल्स
- GitHub Copilot इंटीग्रेशन
- Docker-in-Docker समर्थन
- Azure CLI

### प्रदर्शन विचार
- GitHub Models मुफ्त टियर में दर सीमाएँ हैं
- एम्बेडिंग्स के लिए उपयुक्त बैच आकार का उपयोग करें
- बार-बार API कॉल्स के लिए कैशिंग पर विचार करें
- लागत अनुकूलन के लिए टोकन उपयोग की निगरानी करें

### सुरक्षा नोट्स
- `.env` फाइलें कभी भी कमिट न करें (पहले से `.gitignore` में शामिल)
- API कुंजियों के लिए पर्यावरण वेरिएबल्स का उपयोग करें
- GitHub टोकन में न्यूनतम आवश्यक स्कोप होने चाहिए
- अध्याय 5 में जिम्मेदार AI दिशानिर्देशों का पालन करें

---

**अस्वीकरण**:  
यह दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) का उपयोग करके अनुवादित किया गया है। जबकि हम सटीकता सुनिश्चित करने का प्रयास करते हैं, कृपया ध्यान दें कि स्वचालित अनुवाद में त्रुटियां या अशुद्धियां हो सकती हैं। मूल भाषा में उपलब्ध मूल दस्तावेज़ को प्रामाणिक स्रोत माना जाना चाहिए। महत्वपूर्ण जानकारी के लिए, पेशेवर मानव अनुवाद की सिफारिश की जाती है। इस अनुवाद के उपयोग से उत्पन्न किसी भी गलतफहमी या गलत व्याख्या के लिए हम उत्तरदायी नहीं हैं।