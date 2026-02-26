# AGENTS.md

## ਪ੍ਰੋਜੈਕਟ ਝਲਕ

ਇਹ ਜਾਵਾ ਨਾਲ ਜਨਰੇਟਿਵ AI ਵਿਕਾਸ ਸਿੱਖਣ ਲਈ ਇੱਕ ਸਿੱਖਿਆ ਪ੍ਰੋਜੈਕਟ ਹੈ। ਇਹ ਵੱਡੇ ਭਾਸ਼ਾ ਮਾਡਲ (LLMs), ਪ੍ਰੋਮਪਟ ਇੰਜੀਨੀਅਰਿੰਗ, ਐਮਬੈਡਿੰਗ, RAG (ਰੀਟਰੀਵਲ-ਅਗਮੈਂਟਡ ਜਨਰੇਸ਼ਨ), ਅਤੇ ਮਾਡਲ ਕਾਂਟੈਕਸਟ ਪ੍ਰੋਟੋਕੋਲ (MCP) ਨੂੰ ਕਵਰ ਕਰਦੇ ਹੋਏ ਇੱਕ ਵਿਸਤ੍ਰਿਤ ਹੱਥ-ਅਨੁਭਵ ਕੋਰਸ ਪ੍ਰਦਾਨ ਕਰਦਾ ਹੈ।

**ਮੁੱਖ ਤਕਨਾਲੋਜੀਆਂ:**
- ਜਾਵਾ 21
- ਸਪ੍ਰਿੰਗ ਬੂਟ 3.5.x
- ਸਪ੍ਰਿੰਗ AI 1.1.x
- Maven
- LangChain4j
- GitHub ਮਾਡਲ, Azure OpenAI, ਅਤੇ OpenAI SDKs

**ਆਰਕੀਟੈਕਚਰ:**
- ਅਧਿਆਇ ਅਨੁਸਾਰ ਵਿਵਸਥਿਤ ਕਈ ਸਵਤੰਤਰ ਸਪ੍ਰਿੰਗ ਬੂਟ ਐਪਲੀਕੇਸ਼ਨ
- ਵੱਖ-ਵੱਖ AI ਪੈਟਰਨ ਦਿਖਾਉਣ ਵਾਲੇ ਨਮੂਨਾ ਪ੍ਰੋਜੈਕਟ
- GitHub Codespaces-ਤਿਆਰ, ਪੂਰਵ-ਸੰਰਚਿਤ ਡਿਵ ਕੰਟੇਨਰਾਂ ਨਾਲ

## ਸੈਟਅੱਪ ਕਮਾਂਡ

### ਪੂਰਵ ਸ਼ਰਤਾਂ
- ਜਾਵਾ 21 ਜਾਂ ਇਸ ਤੋਂ ਉੱਚਾ
- Maven 3.x
- GitHub ਪर्सਨਲ ਐਕਸੈਸ ਟੋਕਨ (GitHub ਮਾਡਲ ਲਈ)
- ਵਿਕਲਪਿਕ: Azure OpenAI ਪ੍ਰਮਾਣ ਪੱਤਰ

### ਵਾਤਾਵਰਣ ਸੈਟਅੱਪ

**ਵਿਕਲਪ 1: GitHub Codespaces (ਸਿਫਾਰਸ਼ੀ)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**ਵਿਕਲਪ 2: ਸਥਾਨਕ ਡਿਵ ਕੰਟੇਨਰ**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**ਵਿਕਲਪ 3: ਸਥਾਨਕ ਸੈਟਅੱਪ**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### ਸੰਰਚਨਾ

**GitHub ਟੋਕਨ ਸੈਟਅੱਪ:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI ਸੈਟਅੱਪ (ਵਿਕਲਪਿਕ):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## ਵਿਕਾਸ ਵਰਕਫਲੋ

### ਪ੍ਰੋਜੈਕਟ ਸਟ੍ਰਕਚਰ
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

### ਐਪਲੀਕੇਸ਼ਨ ਚਲਾਉਣਾ

**ਸਪ੍ਰਿੰਗ ਬੂਟ ਐਪਲੀਕੇਸ਼ਨ ਚਲਾਉਣਾ:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**ਪ੍ਰੋਜੈਕਟ ਬਣਾਉਣਾ:**
```bash
cd [project-directory]
mvn clean install
```

**MCP ਕੈਲਕੂਲੇਟਰ ਸਰਵਰ ਸ਼ੁਰੂ ਕਰਨਾ:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**ਕਲਾਇੰਟ ਉਦਾਹਰਨ ਚਲਾਉਣਾ:**
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

### ਹਾਟ ਰੀਲੋਡ
ਸਪ੍ਰਿੰਗ ਬੂਟ DevTools ਉਹ ਪ੍ਰੋਜੈਕਟਾਂ ਵਿੱਚ ਸ਼ਾਮਲ ਹੈ ਜੋ ਹਾਟ ਰੀਲੋਡ ਦਾ ਸਮਰਥਨ ਕਰਦੇ ਹਨ:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## ਟੈਸਟਿੰਗ ਨਿਰਦੇਸ਼

### ਟੈਸਟ ਚਲਾਉਣਾ

**ਪ੍ਰੋਜੈਕਟ ਵਿੱਚ ਸਾਰੇ ਟੈਸਟ ਚਲਾਓ:**
```bash
cd [project-directory]
mvn test
```

**ਵਿਸਤ੍ਰਿਤ ਆਉਟਪੁੱਟ ਨਾਲ ਟੈਸਟ ਚਲਾਓ:**
```bash
mvn test -X
```

**ਖਾਸ ਟੈਸਟ ਕਲਾਸ ਚਲਾਓ:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### ਟੈਸਟ ਸਟ੍ਰਕਚਰ
- ਟੈਸਟ ਫਾਈਲਾਂ JUnit 5 (Jupiter) ਵਰਤਦੀਆਂ ਹਨ
- ਟੈਸਟ ਕਲਾਸਾਂ `src/test/java/` ਵਿੱਚ ਸਥਿਤ ਹਨ
- ਕਲਾਇੰਟ ਉਦਾਹਰਨ ਕੈਲਕੂਲੇਟਰ ਪ੍ਰੋਜੈਕਟ ਵਿੱਚ `src/test/java/com/microsoft/mcp/sample/client/` ਵਿੱਚ ਹਨ

### ਮੈਨੂਅਲ ਟੈਸਟਿੰਗ
ਕਈ ਉਦਾਹਰਨ ਇੰਟਰਐਕਟਿਵ ਐਪਲੀਕੇਸ਼ਨ ਹਨ ਜੋ ਮੈਨੂਅਲ ਟੈਸਟਿੰਗ ਦੀ ਲੋੜ ਰੱਖਦੇ ਹਨ:

1. ਐਪਲੀਕੇਸ਼ਨ ਨੂੰ `mvn spring-boot:run` ਨਾਲ ਸ਼ੁਰੂ ਕਰੋ
2. ਐਂਡਪੋਇੰਟ ਜਾਂ CLI ਨਾਲ ਇੰਟਰਐਕਟ ਕਰੋ
3. ਪ੍ਰਤੀਕਸ਼ਿਤ ਵਿਵਹਾਰ ਨੂੰ ਹਰ ਪ੍ਰੋਜੈਕਟ ਦੇ README.md ਵਿੱਚ ਦਸਤਾਵੇਜ਼ ਨਾਲ ਮਿਲਾਓ

### GitHub ਮਾਡਲ ਨਾਲ ਟੈਸਟਿੰਗ
- ਮੁਫ਼ਤ ਟੀਅਰ ਸੀਮਾਵਾਂ: 15 ਬੇਨਤੀਆਂ/ਮਿੰਟ, 150/ਦਿਨ
- 5 ਸਮਕਾਲੀ ਬੇਨਤੀਆਂ ਦੀ ਵੱਧ ਤੋਂ ਵੱਧ ਸੀਮਾ
- ਜ਼ਿੰਮੇਵਾਰ AI ਉਦਾਹਰਨਾਂ ਨਾਲ ਸਮੱਗਰੀ ਫਿਲਟਰਿੰਗ ਟੈਸਟ ਕਰੋ

## ਕੋਡ ਸਟਾਈਲ ਗਾਈਡਲਾਈਨ

### ਜਾਵਾ ਰਿਵਾਜ
- **ਜਾਵਾ ਵਰਜਨ:** ਜਾਵਾ 21 ਨਾਲ ਆਧੁਨਿਕ ਵਿਸ਼ੇਸ਼ਤਾਵਾਂ
- **ਸਟਾਈਲ:** ਮਿਆਰੀ ਜਾਵਾ ਰਿਵਾਜਾਂ ਦੀ ਪਾਲਣਾ ਕਰੋ
- **ਨਾਮਕਰਨ:** 
  - ਕਲਾਸ: PascalCase
  - ਵਿਧੀਆਂ/ਵੈਰੀਏਬਲ: camelCase
  - ਕਾਂਸਟੈਂਟ: UPPER_SNAKE_CASE
  - ਪੈਕੇਜ ਨਾਮ: ਛੋਟੇ ਅੱਖਰ

### ਸਪ੍ਰਿੰਗ ਬੂਟ ਪੈਟਰਨ
- ਕਾਰੋਬਾਰੀ ਤਰਕ ਲਈ `@Service` ਵਰਤੋ
- REST ਐਂਡਪੋਇੰਟ ਲਈ `@RestController` ਵਰਤੋ
- `application.yml` ਜਾਂ `application.properties` ਰਾਹੀਂ ਸੰਰਚਨਾ
- ਹਾਰਡ-ਕੋਡ ਕੀਤੀਆਂ ਮੁੱਲਾਂ ਦੇ ਬਦਲੇ ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲਾਂ ਦੀ ਪਸੰਦ
- MCP-ਉਜਾਗਰ ਵਿਧੀਆਂ ਲਈ `@Tool` ਐਨੋਟੇਸ਼ਨ ਵਰਤੋ

### ਫਾਈਲ ਵਿਵਸਥਾ
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

### ਡਿਪੈਂਡੈਂਸੀਜ਼
- Maven `pom.xml` ਰਾਹੀਂ ਪ੍ਰਬੰਧਿਤ
- ਸਪ੍ਰਿੰਗ AI BOM ਵਰਜਨ ਪ੍ਰਬੰਧਨ ਲਈ
- LangChain4j AI ਇੰਟੀਗ੍ਰੇਸ਼ਨ ਲਈ
- ਸਪ੍ਰਿੰਗ ਡਿਪੈਂਡੈਂਸੀਜ਼ ਲਈ ਸਪ੍ਰਿੰਗ ਬੂਟ ਸਟਾਰਟਰ ਪੈਰੈਂਟ

### ਕੋਡ ਟਿੱਪਣੀਆਂ
- ਜਨਤਕ APIs ਲਈ JavaDoc ਸ਼ਾਮਲ ਕਰੋ
- ਜਟਿਲ AI ਇੰਟਰੈਕਸ਼ਨ ਲਈ ਵਿਆਖਿਆਤਮਕ ਟਿੱਪਣੀਆਂ ਸ਼ਾਮਲ ਕਰੋ
- MCP ਟੂਲ ਵੇਰਵੇ ਸਪਸ਼ਟ ਤੌਰ 'ਤੇ ਦਸਤਾਵੇਜ਼ ਕਰੋ

## ਬਿਲਡ ਅਤੇ ਡਿਪਲੌਇਮੈਂਟ

### ਪ੍ਰੋਜੈਕਟ ਬਣਾਉਣਾ

**ਟੈਸਟਾਂ ਤੋਂ ਬਿਨਾਂ ਬਿਲਡ ਕਰੋ:**
```bash
mvn clean install -DskipTests
```

**ਸਾਰੇ ਚੈੱਕ ਨਾਲ ਬਿਲਡ ਕਰੋ:**
```bash
mvn clean install
```

**ਐਪਲੀਕੇਸ਼ਨ ਪੈਕੇਜ ਕਰੋ:**
```bash
mvn package
# Creates JAR in target/ directory
```

### ਆਉਟਪੁੱਟ ਡਾਇਰੈਕਟਰੀਜ਼
- ਕੰਪਾਇਲ ਕੀਤੀਆਂ ਕਲਾਸਾਂ: `target/classes/`
- ਟੈਸਟ ਕਲਾਸਾਂ: `target/test-classes/`
- JAR ਫਾਈਲਾਂ: `target/*.jar`
- Maven ਆਰਟੀਫੈਕਟ: `target/`

### ਵਾਤਾਵਰਣ-ਵਿਸ਼ੇਸ਼ ਸੰਰਚਨਾ

**ਵਿਕਾਸ:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**ਉਤਪਾਦਨ:**
- GitHub ਮਾਡਲ ਦੇ ਬਦਲੇ Azure AI Foundry ਮਾਡਲ ਵਰਤੋ
- ਬੇਸ-URL ਨੂੰ Azure OpenAI ਐਂਡਪੋਇੰਟ ਵਿੱਚ ਅਪਡੇਟ ਕਰੋ
- Azure Key Vault ਜਾਂ ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲਾਂ ਰਾਹੀਂ ਰਾਜ਼ ਪ੍ਰਬੰਧਿਤ ਕਰੋ

### ਡਿਪਲੌਇਮੈਂਟ ਵਿਚਾਰ
- ਇਹ ਸਿੱਖਿਆ ਪ੍ਰੋਜੈਕਟ ਹੈ ਜਿਸ ਵਿੱਚ ਨਮੂਨਾ ਐਪਲੀਕੇਸ਼ਨ ਹਨ
- ਜਿਵੇਂ ਹੈ, ਉਤਪਾਦਨ ਡਿਪਲੌਇਮੈਂਟ ਲਈ ਡਿਜ਼ਾਈਨ ਨਹੀਂ ਕੀਤਾ ਗਿਆ
- ਨਮੂਨੇ ਉਤਪਾਦਨ ਵਰਤੋਂ ਲਈ ਅਨੁਕੂਲਿਤ ਕਰਨ ਲਈ ਪੈਟਰਨ ਦਿਖਾਉਂਦੇ ਹਨ
- ਖਾਸ ਡਿਪਲੌਇਮੈਂਟ ਨੋਟਾਂ ਲਈ ਵਿਅਕਤੀਗਤ ਪ੍ਰੋਜੈਕਟ READMEਜ਼ ਵੇਖੋ

## ਵਾਧੂ ਟਿੱਪਣੀਆਂ

### GitHub ਮਾਡਲ ਵਿਰੁੱਧ Azure OpenAI
- **GitHub ਮਾਡਲ:** ਸਿੱਖਣ ਲਈ ਮੁਫ਼ਤ ਟੀਅਰ, ਕੋਈ ਕਰੈਡਿਟ ਕਾਰਡ ਦੀ ਲੋੜ ਨਹੀਂ
- **Azure OpenAI:** ਉਤਪਾਦਨ-ਤਿਆਰ, Azure ਸਬਸਕ੍ਰਿਪਸ਼ਨ ਦੀ ਲੋੜ
- ਕੋਡ ਦੋਵਾਂ ਵਿੱਚ ਅਨੁਕੂਲ ਹੈ - ਸਿਰਫ ਐਂਡਪੋਇੰਟ ਅਤੇ API ਕੁੰਜੀ ਬਦਲੋ

### ਕਈ ਪ੍ਰੋਜੈਕਟਾਂ ਨਾਲ ਕੰਮ ਕਰਨਾ
ਹਰ ਨਮੂਨਾ ਪ੍ਰੋਜੈਕਟ ਸਵਤੰਤਰ ਹੈ:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### ਆਮ ਸਮੱਸਿਆਵਾਂ

**ਜਾਵਾ ਵਰਜਨ ਮਿਸਮੈਚ:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**ਡਿਪੈਂਡੈਂਸੀ ਡਾਊਨਲੋਡ ਸਮੱਸਿਆਵਾਂ:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub ਟੋਕਨ ਨਹੀਂ ਮਿਲਿਆ:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**ਪੋਰਟ ਪਹਿਲਾਂ ਹੀ ਵਰਤ ਵਿੱਚ ਹੈ:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### ਬਹੁ-ਭਾਸ਼ਾ ਸਮਰਥਨ
- ਦਸਤਾਵੇਜ਼ 45+ ਭਾਸ਼ਾਵਾਂ ਵਿੱਚ ਉਪਲਬਧ ਹੈ ਆਟੋਮੈਟਿਕ ਅਨੁਵਾਦ ਰਾਹੀਂ
- ਅਨੁਵਾਦ `translations/` ਡਾਇਰੈਕਟਰੀ ਵਿੱਚ
- ਅਨੁਵਾਦ GitHub Actions ਵਰਕਫਲੋ ਦੁਆਰਾ ਪ੍ਰਬੰਧਿਤ

### ਸਿੱਖਣ ਦਾ ਪਾਥ
1. [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md) ਨਾਲ ਸ਼ੁਰੂ ਕਰੋ
2. ਅਧਿਆਇ ਕ੍ਰਮ ਵਿੱਚ ਪਾਲਣਾ ਕਰੋ (01 → 05)
3. ਹਰ ਅਧਿਆਇ ਵਿੱਚ ਹੱਥ-ਅਨੁਭਵ ਉਦਾਹਰਨ ਪੂਰੇ ਕਰੋ
4. ਅਧਿਆਇ 4 ਵਿੱਚ ਨਮੂਨਾ ਪ੍ਰੋਜੈਕਟਾਂ ਦੀ ਖੋਜ ਕਰੋ
5. ਅਧਿਆਇ 5 ਵਿੱਚ ਜ਼ਿੰਮੇਵਾਰ AI ਅਭਿਆਸ ਸਿੱਖੋ

### ਵਿਕਾਸ ਕੰਟੇਨਰ
`.devcontainer/devcontainer.json` ਸੰਰਚਿਤ ਕਰਦਾ ਹੈ:
- ਜਾਵਾ 21 ਵਿਕਾਸ ਵਾਤਾਵਰਣ
- Maven ਪੂਰਵ-ਸਥਾਪਿਤ
- VS Code ਜਾਵਾ ਐਕਸਟੈਂਸ਼ਨ
- ਸਪ੍ਰਿੰਗ ਬੂਟ ਟੂਲ
- GitHub Copilot ਇੰਟੀਗ੍ਰੇਸ਼ਨ
- Docker-in-Docker ਸਮਰਥਨ
- Azure CLI

### ਪ੍ਰਦਰਸ਼ਨ ਵਿਚਾਰ
- GitHub ਮਾਡਲ ਮੁਫ਼ਤ ਟੀਅਰ ਵਿੱਚ ਦਰ ਸੀਮਾਵਾਂ ਹਨ
- ਐਮਬੈਡਿੰਗ ਲਈ ਉਚਿਤ ਬੈਚ ਆਕਾਰ ਵਰਤੋ
- ਦੁਹਰਾਈ ਗਈ API ਕਾਲਾਂ ਲਈ ਕੈਸ਼ਿੰਗ ਬਾਰੇ ਸੋਚੋ
- ਲਾਗਤ ਅਨੁਕੂਲਤਾ ਲਈ ਟੋਕਨ ਵਰਤੋਂ ਦੀ ਨਿਗਰਾਨੀ ਕਰੋ

### ਸੁਰੱਖਿਆ ਟਿੱਪਣੀਆਂ
- `.env` ਫਾਈਲਾਂ ਕਦੇ ਵੀ ਕਮਿਟ ਨਾ ਕਰੋ (`.gitignore` ਵਿੱਚ ਪਹਿਲਾਂ ਹੀ ਸ਼ਾਮਲ)
- API ਕੁੰਜੀਆਂ ਲਈ ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ ਵਰਤੋ
- GitHub ਟੋਕਨ ਘੱਟੋ-ਘੱਟ ਲੋੜੀਂਦੇ ਸਕੋਪਾਂ ਦੇ ਨਾਲ ਹੋਣੇ ਚਾਹੀਦੇ ਹਨ
- ਅਧਿਆਇ 5 ਵਿੱਚ ਜ਼ਿੰਮੇਵਾਰ AI ਦਿਸ਼ਾ-ਨਿਰਦੇਸ਼ਾਂ ਦੀ ਪਾਲਣਾ ਕਰੋ

---

**ਅਸਵੀਕਰਤੀ**:  
ਇਹ ਦਸਤਾਵੇਜ਼ AI ਅਨੁਵਾਦ ਸੇਵਾ [Co-op Translator](https://github.com/Azure/co-op-translator) ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਅਨੁਵਾਦ ਕੀਤਾ ਗਿਆ ਹੈ। ਹਾਲਾਂਕਿ ਅਸੀਂ ਸਹੀਤਾ ਲਈ ਯਤਨਸ਼ੀਲ ਹਾਂ, ਕਿਰਪਾ ਕਰਕੇ ਧਿਆਨ ਦਿਓ ਕਿ ਸਵੈਚਾਲਿਤ ਅਨੁਵਾਦਾਂ ਵਿੱਚ ਗਲਤੀਆਂ ਜਾਂ ਅਸੁਚਨਾਵਾਂ ਹੋ ਸਕਦੀਆਂ ਹਨ। ਇਸ ਦੀ ਮੂਲ ਭਾਸ਼ਾ ਵਿੱਚ ਮੌਜੂਦ ਦਸਤਾਵੇਜ਼ ਨੂੰ ਅਧਿਕਾਰਤ ਸਰੋਤ ਮੰਨਿਆ ਜਾਣਾ ਚਾਹੀਦਾ ਹੈ। ਮਹੱਤਵਪੂਰਨ ਜਾਣਕਾਰੀ ਲਈ, ਪੇਸ਼ੇਵਰ ਮਨੁੱਖੀ ਅਨੁਵਾਦ ਦੀ ਸਿਫਾਰਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ। ਇਸ ਅਨੁਵਾਦ ਦੀ ਵਰਤੋਂ ਤੋਂ ਪੈਦਾ ਹੋਣ ਵਾਲੇ ਕਿਸੇ ਵੀ ਗਲਤਫਹਿਮੀ ਜਾਂ ਗਲਤ ਵਿਆਖਿਆ ਲਈ ਅਸੀਂ ਜ਼ਿੰਮੇਵਾਰ ਨਹੀਂ ਹਾਂ।