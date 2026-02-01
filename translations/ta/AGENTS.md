# AGENTS.md

## திட்டத்தின் மேற்பார்வை

Java-யுடன் Generative AI வளர்ச்சியை கற்றுக்கொள்வதற்கான கல்வி கையேடு இது. இது Large Language Models (LLMs), prompt engineering, embeddings, RAG (Retrieval-Augmented Generation), மற்றும் Model Context Protocol (MCP) ஆகியவற்றை உள்ளடக்கிய விரிவான கையேடு வழங்குகிறது.

**முக்கிய தொழில்நுட்பங்கள்:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI, மற்றும் OpenAI SDKs

**கட்டமைப்பு:**
- அத்தியாயங்களின் அடிப்படையில் ஒவ்வொரு தனித்துவமான Spring Boot பயன்பாடுகளும்
- AI வடிவமைப்புகளை விளக்கும் மாதிரித் திட்டங்கள்
- GitHub Codespaces-க்கு தயாராக உள்ள முன்பதிவிடப்பட்ட dev containers

## அமைப்புக்கான கட்டளைகள்

### முன்பதிவுகள்
- Java 21 அல்லது அதற்கு மேல்
- Maven 3.x
- GitHub தனிப்பட்ட அணுகல் டோக்கன் (GitHub Models-க்கு)
- விருப்பம்: Azure OpenAI சான்றுகள்

### சூழல் அமைப்பு

**விருப்பம் 1: GitHub Codespaces (பரிந்துரைக்கப்படுகிறது)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**விருப்பம் 2: உள்ளூர் Dev Container**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**விருப்பம் 3: உள்ளூர் அமைப்பு**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### கட்டமைப்பு

**GitHub Token அமைப்பு:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI அமைப்பு (விருப்பம்):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## வளர்ச்சி பணிமுறை

### திட்ட அமைப்பு
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

### பயன்பாடுகளை இயக்குதல்

**Spring Boot பயன்பாட்டை இயக்குதல்:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**திட்டத்தை கட்டமைத்தல்:**
```bash
cd [project-directory]
mvn clean install
```

**MCP Calculator Server-ஐ தொடங்குதல்:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Client உதாரணங்களை இயக்குதல்:**
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
Spring Boot DevTools, hot reload-ஐ ஆதரிக்கும் திட்டங்களில் சேர்க்கப்பட்டுள்ளது:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## சோதனை வழிமுறைகள்

### சோதனைகளை இயக்குதல்

**திட்டத்தில் உள்ள அனைத்து சோதனைகளையும் இயக்குதல்:**
```bash
cd [project-directory]
mvn test
```

**விரிவான வெளியீட்டுடன் சோதனைகளை இயக்குதல்:**
```bash
mvn test -X
```

**குறிப்பிட்ட சோதனை வகுப்பை இயக்குதல்:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### சோதனை அமைப்பு
- சோதனை கோப்புகள் JUnit 5 (Jupiter)-ஐ பயன்படுத்துகின்றன
- சோதனை வகுப்புகள் `src/test/java/`-ல் அமைக்கப்பட்டுள்ளன
- Calculator திட்டத்தில் உள்ள Client உதாரணங்கள் `src/test/java/com/microsoft/mcp/sample/client/`-ல் உள்ளன

### கைமுறையாக சோதனை செய்தல்
பல உதாரணங்கள் தொடர்புடைய பயன்பாடுகள், கைமுறையாக சோதனை செய்ய வேண்டும்:

1. `mvn spring-boot:run` மூலம் பயன்பாட்டை தொடங்கவும்
2. Endpoints-ஐ சோதிக்கவும் அல்லது CLI-யுடன் தொடர்பு கொள்ளவும்
3. ஒவ்வொரு திட்டத்தின் README.md-ல் உள்ள ஆவணத்துடன் எதிர்பார்க்கப்படும் செயல்பாட்டை ஒப்பிடவும்

### GitHub Models-ஐப் பயன்படுத்தி சோதனை செய்தல்
- இலவச நிலை வரம்புகள்: 15 கோரிக்கைகள்/நிமிடம், 150/நாள்
- அதிகபட்சம் 5 ஒரே நேர கோரிக்கைகள்
- பொறுப்பான AI உதாரணங்களுடன் உள்ளடக்க வடிகட்டலை சோதிக்கவும்

## குறியீட்டு பாணி வழிகாட்டுதல்கள்

### Java மரபுகள்
- **Java பதிப்பு:** Java 21, நவீன அம்சங்களுடன்
- **பாணி:** நிலையான Java மரபுகளை பின்பற்றவும்
- **பெயரிடல்:** 
  - வகுப்புகள்: PascalCase
  - முறைகள்/மாறிகள்: camelCase
  - நிலையானவை: UPPER_SNAKE_CASE
  - தொகுப்பு பெயர்கள்: lowercase

### Spring Boot வடிவங்கள்
- வணிக தரவுகளுக்கு `@Service`-ஐ பயன்படுத்தவும்
- REST முடுக்குகளுக்கு `@RestController`-ஐ பயன்படுத்தவும்
- `application.yml` அல்லது `application.properties` மூலம் கட்டமைப்பு
- கடினமாக குறியிடப்பட்ட மதிப்புகளுக்கு பதிலாக சூழல் மாறிகளை பயன்படுத்தவும்
- MCP-யால் வெளிப்படுத்தப்பட்ட முறைகளுக்கு `@Tool` குறியீட்டை பயன்படுத்தவும்

### கோப்பு அமைப்பு
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

### சார்புகள்
- Maven `pom.xml` மூலம் நிர்வகிக்கப்படுகிறது
- Spring AI BOM பதிப்பு மேலாண்மைக்கு
- AI ஒருங்கிணைப்புகளுக்கு LangChain4j
- Spring சார்புகளுக்கு Spring Boot starter parent

### குறியீட்டு கருத்துகள்
- பொது APIs-க்கு JavaDoc சேர்க்கவும்
- சிக்கலான AI தொடர்புகளுக்கு விளக்கமான கருத்துகளை சேர்க்கவும்
- MCP கருவி விளக்கங்களை தெளிவாக ஆவணப்படுத்தவும்

## கட்டமைப்பு மற்றும் பரவல்

### திட்டங்களை கட்டமைத்தல்

**சோதனைகள் இல்லாமல் கட்டமைத்தல்:**
```bash
mvn clean install -DskipTests
```

**அனைத்து சரிபார்ப்புகளுடன் கட்டமைத்தல்:**
```bash
mvn clean install
```

**பயன்பாட்டை தொகுப்பாக்குதல்:**
```bash
mvn package
# Creates JAR in target/ directory
```

### வெளியீட்டு அடைவுகள்
- தொகுக்கப்பட்ட வகுப்புகள்: `target/classes/`
- சோதனை வகுப்புகள்: `target/test-classes/`
- JAR கோப்புகள்: `target/*.jar`
- Maven பொருட்கள்: `target/`

### சூழல்-குறிப்பிட்ட கட்டமைப்பு

**வளர்ச்சி:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**உற்பத்தி:**
- GitHub Models-க்கு பதிலாக Azure AI Foundry Models-ஐ பயன்படுத்தவும்
- Azure OpenAI முடுக்குக்கு base-url-ஐ புதுப்பிக்கவும்
- Azure Key Vault அல்லது சூழல் மாறிகள் மூலம் ரகசியங்களை நிர்வகிக்கவும்

### பரவல் கருத்துகள்
- இது மாதிரித் பயன்பாடுகளுடன் கல்வி கையேடு
- நேரடியாக உற்பத்தி பரவலுக்கு வடிவமைக்கப்படவில்லை
- மாதிரிகள் உற்பத்தி பயன்பாட்டுக்கு மாற்றுவதற்கான வடிவங்களை விளக்குகின்றன
- குறிப்பிட்ட திட்டத்தின் README-களில் குறிப்பிட்ட பரவல் குறிப்புகளை பார்க்கவும்

## கூடுதல் குறிப்புகள்

### GitHub Models vs Azure OpenAI
- **GitHub Models:** கற்றலுக்கான இலவச நிலை, கிரெடிட் கார்டு தேவையில்லை
- **Azure OpenAI:** உற்பத்திக்கு தயாராக, Azure சந்தா தேவை
- குறியீடு இரண்டிற்கும் இணக்கமானது - முடுக்கம் மற்றும் API விசையை மாற்றவும்

### பல திட்டங்களுடன் வேலை செய்வது
ஒவ்வொரு மாதிரித் திட்டமும் தனித்துவமானது:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### பொதுவான சிக்கல்கள்

**Java பதிப்பு பொருந்தாதது:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**சார்பு பதிவிறக்க சிக்கல்கள்:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub Token காணப்படவில்லை:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Port ஏற்கனவே பயன்படுத்தப்படுகிறது:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### பல மொழி ஆதரவு
- ஆவணங்கள் 45+ மொழிகளில் கிடைக்கின்றன, தானியங்கி மொழிபெயர்ப்பு மூலம்
- மொழிபெயர்ப்புகள் `translations/` அடைவில் உள்ளன
- GitHub Actions பணிமுறையால் மொழிபெயர்ப்பு நிர்வகிக்கப்படுகிறது

### கற்றல் பாதை
1. [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)-இல் தொடங்கவும்
2. அத்தியாயங்களை வரிசையாக பின்பற்றவும் (01 → 05)
3. ஒவ்வொரு அத்தியாயத்திலும் உள்ள தொடர்பு உதாரணங்களை முடிக்கவும்
4. அத்தியாயம் 4-இல் மாதிரித் திட்டங்களை ஆராயவும்
5. அத்தியாயம் 5-இல் பொறுப்பான AI நடைமுறைகளை கற்றுக்கொள்ளவும்

### வளர்ச்சி Container
`.devcontainer/devcontainer.json` அமைக்கிறது:
- Java 21 வளர்ச்சி சூழல்
- Maven முன்பதிவிடப்பட்டது
- VS Code Java நீட்டிப்புகள்
- Spring Boot கருவிகள்
- GitHub Copilot ஒருங்கிணைப்பு
- Docker-in-Docker ஆதரவு
- Azure CLI

### செயல்திறன் கருத்துகள்
- GitHub Models இலவச நிலைக்கு விகித வரம்புகள் உள்ளன
- embeddings-க்கு பொருத்தமான தொகுதிகளை பயன்படுத்தவும்
- மீண்டும் API அழைப்புகளுக்கு caching-ஐ பரிசீலிக்கவும்
- செலவுகளை மேம்படுத்த token பயன்பாட்டை கண்காணிக்கவும்

### பாதுகாப்பு குறிப்புகள்
- `.env` கோப்புகளை ஒருபோதும் commit செய்ய வேண்டாம் (`.gitignore`-ல் ஏற்கனவே உள்ளது)
- API விசைகளுக்கு சூழல் மாறிகளை பயன்படுத்தவும்
- GitHub டோக்கன்கள் குறைந்த தேவைப்படும் அளவுகளை கொண்டிருக்க வேண்டும்
- அத்தியாயம் 5-இல் பொறுப்பான AI வழிகாட்டுதல்களை பின்பற்றவும்

---

**குறிப்பு**:  
இந்த ஆவணம் [Co-op Translator](https://github.com/Azure/co-op-translator) என்ற AI மொழிபெயர்ப்பு சேவையை பயன்படுத்தி மொழிபெயர்க்கப்பட்டுள்ளது. எங்கள் தரச்செயல்முறையை உறுதிப்படுத்த முயற்சிக்கிறோம், ஆனால் தானியக்க மொழிபெயர்ப்புகளில் பிழைகள் அல்லது தவறான தகவல்கள் இருக்கக்கூடும் என்பதை கவனத்தில் கொள்ளவும். அதன் தாய்மொழியில் உள்ள மூல ஆவணம் அதிகாரப்பூர்வ ஆதாரமாக கருதப்பட வேண்டும். முக்கியமான தகவல்களுக்கு, தொழில்முறை மனித மொழிபெயர்ப்பு பரிந்துரைக்கப்படுகிறது. இந்த மொழிபெயர்ப்பைப் பயன்படுத்துவதால் ஏற்படும் எந்த தவறான புரிதல்கள் அல்லது தவறான விளக்கங்களுக்கு நாங்கள் பொறுப்பல்ல.