# AGENTS.md

## ಯೋಜನೆಯ ಅವಲೋಕನ

ಈ ಶೈಕ್ಷಣಿಕ ರೆಪೊಸಿಟರಿ Java ಬಳಸಿ Generative AI ಅಭಿವೃದ್ಧಿಯನ್ನು ಕಲಿಯಲು ಸಹಾಯ ಮಾಡುತ್ತದೆ. ಇದು Large Language Models (LLMs), prompt engineering, embeddings, RAG (Retrieval-Augmented Generation), ಮತ್ತು Model Context Protocol (MCP) ಅನ್ನು ಒಳಗೊಂಡು ಸಮಗ್ರ ಹಸ್ತಚಾಲಿತ ಕೋರ್ಸ್ ಅನ್ನು ಒದಗಿಸುತ್ತದೆ.

**ಮುಖ್ಯ ತಂತ್ರಜ್ಞಾನಗಳು:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI, ಮತ್ತು OpenAI SDKs

**ಆರ್ಕಿಟೆಕ್ಚರ್:**
- ಅಧ್ಯಾಯಗಳ ಮೂಲಕ ಆಯೋಜಿಸಲಾದ ಅನೇಕ ಸ್ವತಂತ್ರ Spring Boot ಅಪ್ಲಿಕೇಶನ್‌ಗಳು
- ವಿಭಿನ್ನ AI ಮಾದರಿಗಳನ್ನು ತೋರಿಸುವ ಮಾದರಿ ಯೋಜನೆಗಳು
- GitHub Codespaces-ಗೆ ತಯಾರಾದ ಪೂರ್ವ-ಕಾನ್ಫಿಗರ್ ಮಾಡಿದ ಡೆವ್ ಕಂಟೈನರ್‌ಗಳು

## ಸೆಟಪ್ ಆಜ್ಞೆಗಳು

### ಪೂರ್ವಶರತ್ತುಗಳು
- Java 21 ಅಥವಾ ಹೆಚ್ಚಿನದು
- Maven 3.x
- GitHub ವೈಯಕ್ತಿಕ ಪ್ರವೇಶ ಟೋಕನ್ (GitHub Models ಗಾಗಿ)
- ಐಚ್ಛಿಕ: Azure OpenAI ಕ್ರೆಡೆನ್ಷಿಯಲ್‌ಗಳು

### ಪರಿಸರ ಸೆಟಪ್

**ಆಯ್ಕೆ 1: GitHub Codespaces (ಶಿಫಾರಸು)**
```bash
# ರೆಪೊಸಿಟರಿಯನ್ನು ಫೋರ್ಕ್ ಮಾಡಿ ಮತ್ತು GitHub UI ನಿಂದ ಕೋಡ್ಸ್ಪೇಸ್ ಅನ್ನು ರಚಿಸಿ
# ಡೆವ್ ಕಂಟೈನರ್ ಸ್ವಯಂಚಾಲಿತವಾಗಿ ಎಲ್ಲಾ ಅವಶ್ಯಕತೆಗಳನ್ನು ಸ್ಥಾಪಿಸುತ್ತದೆ
# ಪರಿಸರ ಸೆಟಪ್‌ಗೆ ~2 ನಿಮಿಷಗಳ ಕಾಲ ಕಾಯಿರಿ
```

**ಆಯ್ಕೆ 2: ಸ್ಥಳೀಯ ಡೆವ್ ಕಂಟೈನರ್**
```bash
# ರೆಪೊಸಿಟರಿ ಕ್ಲೋನ್ ಮಾಡಿ
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# ಡೆವ್ ಕಂಟೈನರ್ ವಿಸ್ತರಣೆ ಬಳಸಿ VS ಕೋಡ್‌ನಲ್ಲಿ ತೆರೆಯಿರಿ
# ಕೇಳಿದಾಗ ಕಂಟೈನರ್‌ನಲ್ಲಿ ಮರುತೆರೆಯಿರಿ
```

**ಆಯ್ಕೆ 3: ಸ್ಥಳೀಯ ಸೆಟಪ್**
```bash
# ಅವಶ್ಯಕತೆಗಳನ್ನು ಸ್ಥಾಪಿಸಿ
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# ಸ್ಥಾಪನೆಯನ್ನು ಪರಿಶೀಲಿಸಿ
java -version
mvn -version
```

### ಕಾನ್ಫಿಗರೇಶನ್

**GitHub ಟೋಕನ್ ಸೆಟಪ್:**
```bash
# GitHub ವೈಯಕ್ತಿಕ ಪ್ರವೇಶ ಟೋಕನ್ ರಚಿಸಿ
# ಪರಿಸರ ವ್ಯತ್ಯಯವನ್ನು ಹೊಂದಿಸಿ
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI ಸೆಟಪ್ (ಐಚ್ಛಿಕ):**
```bash
# ಆಜೂರ್ ಓಪನ್‌ಎಐ ಬಳಸುವ ಉದಾಹರಣೆಗಳಿಗಾಗಿ
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# ನಿಮ್ಮ ಆಜೂರ್ ಓಪನ್‌ಎಐ ಪ್ರಮಾಣಪತ್ರಗಳೊಂದಿಗೆ .env ಸಂಪಾದಿಸಿ
```

## ಅಭಿವೃದ್ಧಿ ಕಾರ್ಯಪ್ರವಾಹ

### ಯೋಜನೆ ರಚನೆ
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

### ಅಪ್ಲಿಕೇಶನ್‌ಗಳನ್ನು ಚಲಿಸುವುದು

**Spring Boot ಅಪ್ಲಿಕೇಶನ್‌ ಅನ್ನು ಚಲಿಸುವುದು:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**ಯೋಜನೆ ನಿರ್ಮಾಣ:**
```bash
cd [project-directory]
mvn clean install
```

**MCP Calculator Server ಪ್ರಾರಂಭಿಸುವುದು:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# ಸರ್ವರ್ http://localhost:8080 ನಲ್ಲಿ ಕಾರ್ಯನಿರ್ವಹಿಸುತ್ತದೆ
```

**ಕ್ಲೈಂಟ್ ಉದಾಹರಣೆಗಳನ್ನು ಚಲಿಸುವುದು:**
```bash
# ಮತ್ತೊಂದು ಟರ್ಮಿನಲ್‌ನಲ್ಲಿ ಸರ್ವರ್ ಪ್ರಾರಂಭಿಸಿದ ನಂತರ
cd 04-PracticalSamples/calculator

# ನೇರ MCP ಕ್ಲೈಂಟ್
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"

# AI-ಚಾಲಿತ ಕ್ಲೈಂಟ್ (GITHUB_TOKEN ಅಗತ್ಯವಿದೆ)
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"

# ಪರಸ್ಪರ ಬಾಟ್
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.Bot"
```

### ಹಾಟ್ ರಿಲೋಡ್
Spring Boot DevTools ಅನ್ನು ಹಾಟ್ ರಿಲೋಡ್ ಅನ್ನು ಬೆಂಬಲಿಸುವ ಯೋಜನೆಗಳಲ್ಲಿ ಸೇರಿಸಲಾಗಿದೆ:
```bash
# ಜಾವಾ ಫೈಲ್‌ಗಳಿಗೆ ಬದಲಾವಣೆಗಳನ್ನು ಉಳಿಸಿದಾಗ ಸ್ವಯಂಚಾಲಿತವಾಗಿ ಮರುಲೋಡ್ ಆಗುತ್ತದೆ
mvn spring-boot:run
```

## ಪರೀಕ್ಷಾ ಸೂಚನೆಗಳು

### ಪರೀಕ್ಷೆಗಳನ್ನು ಚಲಿಸುವುದು

**ಯೋಜನೆಯಲ್ಲಿನ ಎಲ್ಲಾ ಪರೀಕ್ಷೆಗಳನ್ನು ಚಲಿಸುವುದು:**
```bash
cd [project-directory]
mvn test
```

**ವಿಸ್ತೃತ ಔಟ್‌ಪುಟ್‌ನೊಂದಿಗೆ ಪರೀಕ್ಷೆಗಳನ್ನು ಚಲಿಸುವುದು:**
```bash
mvn test -X
```

**ನಿರ್ದಿಷ್ಟ ಪರೀಕ್ಷಾ ವರ್ಗವನ್ನು ಚಲಿಸುವುದು:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### ಪರೀಕ್ಷಾ ರಚನೆ
- ಪರೀಕ್ಷಾ ಫೈಲ್‌ಗಳು JUnit 5 (Jupiter) ಅನ್ನು ಬಳಸುತ್ತವೆ
- ಪರೀಕ್ಷಾ ವರ್ಗಗಳು `src/test/java/` ನಲ್ಲಿ ಇರುತ್ತವೆ
- ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಯೋಜನೆಯಲ್ಲಿನ ಕ್ಲೈಂಟ್ ಉದಾಹರಣೆಗಳು `src/test/java/com/microsoft/mcp/sample/client/` ನಲ್ಲಿ ಇರುತ್ತವೆ

### ಕೈಯಿಂದ ಪರೀಕ್ಷೆ
ಅನೇಕ ಉದಾಹರಣೆಗಳು ಪರಸ್ಪರ ಅಪ್ಲಿಕೇಶನ್‌ಗಳಾಗಿದ್ದು ಕೈಯಿಂದ ಪರೀಕ್ಷೆ ಅಗತ್ಯವಿರುತ್ತದೆ:

1. `mvn spring-boot:run` ಬಳಸಿ ಅಪ್ಲಿಕೇಶನ್ ಪ್ರಾರಂಭಿಸಿ
2. ಎಂಡ್‌ಪಾಯಿಂಟ್‌ಗಳನ್ನು ಪರೀಕ್ಷಿಸಿ ಅಥವಾ CLI ಜೊತೆ ಪರಸ್ಪರ ಕ್ರಿಯೆ ಮಾಡಿ
3. ಪ್ರತಿ ಯೋಜನೆಯ README.md ನಲ್ಲಿ ನೀಡಿರುವ ಡಾಕ್ಯುಮೆಂಟ್‌ಗಳಿಗೆ ಹೊಂದುವ ನಿರೀಕ್ಷಿತ ವರ್ತನೆ ಪರಿಶೀಲಿಸಿ

### GitHub Models ಜೊತೆ ಪರೀಕ್ಷೆ
- ಉಚಿತ ಟಿಯರ್ ಮಿತಿಗಳು: 15 ವಿನಂತಿಗಳು/ನಿಮಿಷ, 150/ದಿನ
- 5 ಸಮಕಾಲೀನ ವಿನಂತಿಗಳ ಗರಿಷ್ಠ
- ಜವಾಬ್ದಾರಿಯುತ AI ಉದಾಹರಣೆಗಳೊಂದಿಗೆ ವಿಷಯ ಫಿಲ್ಟರಿಂಗ್ ಪರೀಕ್ಷಿಸಿ

## ಕೋಡ್ ಶೈಲಿ ಮಾರ್ಗಸೂಚಿಗಳು

### Java ಸಂಪ್ರದಾಯಗಳು
- **Java ಆವೃತ್ತಿ:** Java 21 ಆಧುನಿಕ ವೈಶಿಷ್ಟ್ಯಗಳೊಂದಿಗೆ
- **ಶೈಲಿ:** ಮಾನದಂಡ Java ಸಂಪ್ರದಾಯಗಳನ್ನು ಅನುಸರಿಸಿ
- **ಹೆಸರೀಕರಣ:** 
  - ವರ್ಗಗಳು: PascalCase
  - ವಿಧಾನಗಳು/ಚರಗಳು: camelCase
  - ಸ್ಥಿರಾಂಶಗಳು: UPPER_SNAKE_CASE
  - ಪ್ಯಾಕೇಜ್ ಹೆಸರುಗಳು: lowercase

### Spring Boot ಮಾದರಿಗಳು
- ವ್ಯವಹಾರ ಲಾಜಿಕ್‌ಗಾಗಿ `@Service` ಬಳಸಿ
- REST ಎಂಡ್‌ಪಾಯಿಂಟ್‌ಗಳಿಗಾಗಿ `@RestController` ಬಳಸಿ
- `application.yml` ಅಥವಾ `application.properties` ಮೂಲಕ ಕಾನ್ಫಿಗರೇಶನ್
- ಹಾರ್ಡ್-ಕೋಡ್ ಮಾಡಿದ ಮೌಲ್ಯಗಳ ಬದಲು ಪರಿಸರ ಚರಗಳನ್ನು ಬಳಸುವುದು
- MCP-ಎಕ್ಸ್‌ಪೋಸ್ ಮಾಡಿದ ವಿಧಾನಗಳಿಗಾಗಿ `@Tool` ಅನೋಟೇಶನ್ ಬಳಸಿ

### ಫೈಲ್ ಆಯೋಜನೆ
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

### ಅವಲಂಬನೆಗಳು
- Maven `pom.xml` ಮೂಲಕ ನಿರ್ವಹಿಸಲಾಗಿದೆ
- Spring AI BOM ಆವೃತ್ತಿ ನಿರ್ವಹಣೆಗೆ
- LangChain4j AI ಇಂಟಿಗ್ರೇಶನ್‌ಗಳಿಗೆ
- Spring ಅವಲಂಬನೆಗಳಿಗಾಗಿ Spring Boot ಸ್ಟಾರ್ಟರ್ ಪ್ಯಾರೆಂಟ್

### ಕೋಡ್ ಕಾಮೆಂಟ್‌ಗಳು
- ಸಾರ್ವಜನಿಕ APIಗಳಿಗೆ JavaDoc ಸೇರಿಸಿ
- ಸಂಕೀರ್ಣ AI ಪರಸ್ಪರ ಕ್ರಿಯೆಗಳಿಗೆ ವಿವರಣಾತ್ಮಕ ಕಾಮೆಂಟ್‌ಗಳನ್ನು ಸೇರಿಸಿ
- MCP ಟೂಲ್ ವಿವರಣೆಗಳನ್ನು ಸ್ಪಷ್ಟವಾಗಿ ಡಾಕ್ಯುಮೆಂಟ್ ಮಾಡಿ

## ನಿರ್ಮಾಣ ಮತ್ತು ನಿಯೋಜನೆ

### ಯೋಜನೆಗಳನ್ನು ನಿರ್ಮಿಸುವುದು

**ಪರೀಕ್ಷೆಗಳಿಲ್ಲದೆ ನಿರ್ಮಾಣ:**
```bash
mvn clean install -DskipTests
```

**ಎಲ್ಲಾ ತಪಾಸಣೆಗಳೊಂದಿಗೆ ನಿರ್ಮಾಣ:**
```bash
mvn clean install
```

**ಅಪ್ಲಿಕೇಶನ್ ಪ್ಯಾಕೇಜ್ ಮಾಡುವುದು:**
```bash
mvn package
# ಗುರಿ/ ಡೈರೆಕ್ಟರಿಯಲ್ಲಿ JAR ಅನ್ನು ರಚಿಸುತ್ತದೆ
```

### ಔಟ್‌ಪುಟ್ ಡೈರೆಕ್ಟರಿಗಳು
- ಸಂಗ್ರಹಿತ ವರ್ಗಗಳು: `target/classes/`
- ಪರೀಕ್ಷಾ ವರ್ಗಗಳು: `target/test-classes/`
- JAR ಫೈಲ್‌ಗಳು: `target/*.jar`
- Maven ಆರ್ಕ್ಟಿಫ್ಯಾಕ್ಟ್‌ಗಳು: `target/`

### ಪರಿಸರ-ನಿರ್ದಿಷ್ಟ ಕಾನ್ಫಿಗರೇಶನ್

**ಅಭಿವೃದ್ಧಿ:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**ಉತ್ಪಾದನೆ:**
- GitHub Models ಬದಲು Azure AI Foundry Models ಬಳಸಿ
- ಮೂಲ URL ಅನ್ನು Azure OpenAI ಎಂಡ್‌ಪಾಯಿಂಟ್‌ಗೆ ನವೀಕರಿಸಿ
- ರಹಸ್ಯಗಳನ್ನು Azure Key Vault ಅಥವಾ ಪರಿಸರ ಚರಗಳ ಮೂಲಕ ನಿರ್ವಹಿಸಿ

### ನಿಯೋಜನೆ ಪರಿಗಣನೆಗಳು
- ಇದು ಮಾದರಿ ಅಪ್ಲಿಕೇಶನ್‌ಗಳೊಂದಿಗೆ ಶೈಕ್ಷಣಿಕ ರೆಪೊಸಿಟರಿ
- ಪ್ರಸ್ತುತ ಸ್ಥಿತಿಯಲ್ಲಿ ಉತ್ಪಾದನೆ ನಿಯೋಜನೆಗೆ ವಿನ್ಯಾಸಗೊಳಿಸಲಾಗಿಲ್ಲ
- ಮಾದರಿಗಳು ಉತ್ಪಾದನೆ ಬಳಕೆಗೆ ಹೊಂದಿಸಲು ಮಾದರಿಗಳನ್ನು ತೋರಿಸುತ್ತವೆ
- ಪ್ರತಿ ಯೋಜನೆಯ READMEಗಳಲ್ಲಿ ನಿರ್ದಿಷ್ಟ ನಿಯೋಜನೆ ಟಿಪ್ಪಣಿಗಳನ್ನು ನೋಡಿ

## ಹೆಚ್ಚುವರಿ ಟಿಪ್ಪಣಿಗಳು

### GitHub Models vs Azure OpenAI
- **GitHub Models:** ಕಲಿಕೆಯ ಉಚಿತ ಟಿಯರ್, ಕ್ರೆಡಿಟ್ ಕಾರ್ಡ್ ಅಗತ್ಯವಿಲ್ಲ
- **Azure OpenAI:** ಉತ್ಪಾದನೆ-ತಯಾರಾದ, Azure ಚಂದಾದಾರಿಕೆ ಅಗತ್ಯವಿದೆ
- ಕೋಡ್ ಎರಡರೊಂದಿಗೆ ಹೊಂದಿಕೊಳ್ಳುತ್ತದೆ - ಎಂಡ್‌ಪಾಯಿಂಟ್ ಮತ್ತು API ಕೀ ಬದಲಾಯಿಸಿ

### ಅನೇಕ ಯೋಜನೆಗಳೊಂದಿಗೆ ಕೆಲಸ ಮಾಡುವುದು
ಪ್ರತಿ ಮಾದರಿ ಯೋಜನೆ ಸ್ವತಂತ್ರವಾಗಿದೆ:
```bash
# ನಿರ್ದಿಷ್ಟ ಯೋಜನೆಗೆ ನಾವಿಗೇಟ್ ಮಾಡಿ
cd 04-PracticalSamples/[project-name]

# ಪ್ರತಿ ಒಂದಕ್ಕು ತನ್ನದೇ ಆದ pom.xml ಇದೆ ಮತ್ತು ಸ್ವತಂತ್ರವಾಗಿ ನಿರ್ಮಿಸಬಹುದು
mvn clean install
```

### ಸಾಮಾನ್ಯ ಸಮಸ್ಯೆಗಳು

**Java ಆವೃತ್ತಿ ಮಿಸ್ಮ್ಯಾಚ್:**
```bash
# ಜಾವಾ 21 ಪರಿಶೀಲಿಸಿ
java -version
# ಅಗತ್ಯವಿದ್ದರೆ JAVA_HOME ನವೀಕರಿಸಿ
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**ಅವಲಂಬನೆ ಡೌನ್‌ಲೋಡ್ ಸಮಸ್ಯೆಗಳು:**
```bash
# ಮೇವನ್ ಕ್ಯಾಶ್ ಅನ್ನು ತೆರವುಗೊಳಿಸಿ ಮತ್ತು ಪುನಃ ಪ್ರಯತ್ನಿಸಿ
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub ಟೋಕನ್ ಕಂಡುಬಂದಿಲ್ಲ:**
```bash
# ಪ್ರಸ್ತುತ ಸೆಷನ್‌ನಲ್ಲಿ ಸೆಟ್ ಮಾಡಿ
export GITHUB_TOKEN="your-token-here"

# ಅಥವಾ ಪ್ರಾಜೆಕ್ಟ್ ಡೈರೆಕ್ಟರಿಯಲ್ಲಿ .env ಫೈಲ್ ಬಳಸಿ
echo "GITHUB_TOKEN=your-token-here" > .env
```

**ಪೋರ್ಟ್ ಈಗಾಗಲೇ ಬಳಸಲಾಗುತ್ತಿದೆ:**
```bash
# ಸ್ಪ್ರಿಂಗ್ ಬೂಟ್ ಡೀಫಾಲ್ಟ್ ಆಗಿ ಪೋರ್ಟ್ 8080 ಅನ್ನು ಬಳಸುತ್ತದೆ
# application.properties ನಲ್ಲಿ ಬದಲಾವಣೆ:
server.port=8081
```

### ಬಹುಭಾಷಾ ಬೆಂಬಲ
- 45+ ಭಾಷೆಗಳಲ್ಲಿ ಡಾಕ್ಯುಮೆಂಟ್ ಲಭ್ಯವಿದೆ ಸ್ವಯಂಚಾಲಿತ ಅನುವಾದದ ಮೂಲಕ
- `translations/` ಡೈರೆಕ್ಟರಿಯಲ್ಲಿ ಅನುವಾದಗಳು
- GitHub Actions ವರ್ಕ್‌ಫ್ಲೋ ಮೂಲಕ ಅನುವಾದ ನಿರ್ವಹಣೆ

### ಕಲಿಕೆಯ ಪಥ
1. [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md) ನಿಂದ ಪ್ರಾರಂಭಿಸಿ
2. ಅಧ್ಯಾಯಗಳನ್ನು ಕ್ರಮವಾಗಿ ಅನುಸರಿಸಿ (01 → 05)
3. ಪ್ರತಿ ಅಧ್ಯಾಯದಲ್ಲಿ ಹಸ್ತಚಾಲಿತ ಉದಾಹರಣೆಗಳನ್ನು ಪೂರ್ಣಗೊಳಿಸಿ
4. ಅಧ್ಯಾಯ 4 ರಲ್ಲಿ ಮಾದರಿ ಯೋಜನೆಗಳನ್ನು ಅನ್ವೇಷಿಸಿ
5. ಅಧ್ಯಾಯ 5 ರಲ್ಲಿ ಜವಾಬ್ದಾರಿಯುತ AI ಅಭ್ಯಾಸಗಳನ್ನು ಕಲಿಯಿರಿ

### ಅಭಿವೃದ್ಧಿ ಕಂಟೈನರ್
`.devcontainer/devcontainer.json` ಅನ್ನು ಕಾನ್ಫಿಗರ್ ಮಾಡುತ್ತದೆ:
- Java 21 ಅಭಿವೃದ್ಧಿ ಪರಿಸರ
- Maven ಪೂರ್ವ-ಸ್ಥಾಪಿತ
- VS Code Java ವಿಸ್ತರಣೆಗಳು
- Spring Boot ಟೂಲ್ಸ್
- GitHub Copilot ಇಂಟಿಗ್ರೇಶನ್
- Docker-in-Docker ಬೆಂಬಲ
- Azure CLI

### ಕಾರ್ಯಕ್ಷಮತೆ ಪರಿಗಣನೆಗಳು
- GitHub Models ಉಚಿತ ಟಿಯರ್ ದರ ಮಿತಿಗಳು
- embeddings ಗಾಗಿ ಸೂಕ್ತ ಬ್ಯಾಚ್ ಗಾತ್ರಗಳನ್ನು ಬಳಸಿ
- ಪುನರಾವೃತ್ತ API ಕರೆಗಳಿಗೆ ಕ್ಯಾಶಿಂಗ್ ಪರಿಗಣಿಸಿ
- ವೆಚ್ಚದ ಆಪ್ಟಿಮೈಸೇಶನ್‌ಗಾಗಿ ಟೋಕನ್ ಬಳಕೆಯನ್ನು ನಿಗಾ ಮಾಡಿ

### ಭದ್ರತಾ ಟಿಪ್ಪಣಿಗಳು
- `.env` ಫೈಲ್‌ಗಳನ್ನು ಎಂದಿಗೂ ಕಮಿಟ್ ಮಾಡಬೇಡಿ (`.gitignore` ನಲ್ಲಿ ಈಗಾಗಲೇ ಸೇರಿಸಲಾಗಿದೆ)
- API ಕೀಗಳಿಗೆ ಪರಿಸರ ಚರಗಳನ್ನು ಬಳಸಿ
- GitHub ಟೋಕನ್‌ಗಳಿಗೆ ಕನಿಷ್ಠ ಅಗತ್ಯವಿರುವ ವ್ಯಾಪ್ತಿಗಳನ್ನು ಹೊಂದಿರಲಿ
- ಅಧ್ಯಾಯ 5 ರಲ್ಲಿ ಜವಾಬ್ದಾರಿಯುತ AI ಮಾರ್ಗಸೂಚಿಗಳನ್ನು ಅನುಸರಿಸಿ

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ಅಸಮಾಕ್ಷ್ಯತೆ**:  
ಈ ದಸ್ತಾವೇಜನ್ನು AI ಅನುವಾದ ಸೇವೆ [Co-op Translator](https://github.com/Azure/co-op-translator) ಬಳಸಿ ಅನುವಾದಿಸಲಾಗಿದೆ. ನಾವು ನಿಖರತೆಯನ್ನು ಸಾಧಿಸಲು ಪ್ರಯತ್ನಿಸುತ್ತಿದ್ದರೂ, ದಯವಿಟ್ಟು ಗಮನಿಸಿ, ಸ್ವಯಂಚಾಲಿತ ಅನುವಾದಗಳಲ್ಲಿ ದೋಷಗಳು ಅಥವಾ ಅಸಮಾಕ್ಷ್ಯತೆಗಳು ಇರಬಹುದು. ಮೂಲ ಭಾಷೆಯಲ್ಲಿರುವ ಮೂಲ ದಸ್ತಾವೇಜು ಪ್ರಾಮಾಣಿಕ ಮೂಲವೆಂದು ಪರಿಗಣಿಸಬೇಕು. ಮಹತ್ವದ ಮಾಹಿತಿಗಾಗಿ, ವೃತ್ತಿಪರ ಮಾನವ ಅನುವಾದವನ್ನು ಶಿಫಾರಸು ಮಾಡಲಾಗುತ್ತದೆ. ಈ ಅನುವಾದವನ್ನು ಬಳಸುವ ಮೂಲಕ ಉಂಟಾಗುವ ಯಾವುದೇ ತಪ್ಪು ಅರ್ಥಗಳ ಅಥವಾ ತಪ್ಪು ವ್ಯಾಖ್ಯಾನಗಳ ಬಗ್ಗೆ ನಾವು ಹೊಣೆಗಾರರಲ್ಲ.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->