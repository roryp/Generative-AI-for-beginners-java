<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:40:53+00:00",
  "source_file": "AGENTS.md",
  "language_code": "tl"
}
-->
# AGENTS.md

## Pangkalahatang-ideya ng Proyekto

Ito ay isang pang-edukasyong repository para sa pag-aaral ng pagbuo ng Generative AI gamit ang Java. Nagbibigay ito ng komprehensibong hands-on na kurso na sumasaklaw sa Large Language Models (LLMs), prompt engineering, embeddings, RAG (Retrieval-Augmented Generation), at Model Context Protocol (MCP).

**Pangunahing Teknolohiya:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI, at OpenAI SDKs

**Arkitektura:**
- Maramihang standalone Spring Boot applications na nakaayos ayon sa mga kabanata
- Mga sample na proyekto na nagpapakita ng iba't ibang AI patterns
- Handa sa GitHub Codespaces na may pre-configured na dev containers

## Mga Utos sa Setup

### Mga Kinakailangan
- Java 21 o mas mataas
- Maven 3.x
- GitHub personal access token (para sa GitHub Models)
- Opsyonal: Azure OpenAI credentials

### Pag-set up ng Kapaligiran

**Opsyon 1: GitHub Codespaces (Inirerekomenda)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Opsyon 2: Lokal na Dev Container**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Opsyon 3: Lokal na Setup**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Konpigurasyon

**Pag-set up ng GitHub Token:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Pag-set up ng Azure OpenAI (Opsyonal):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Workflow ng Pag-develop

### Estruktura ng Proyekto
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

### Pagpapatakbo ng Mga Aplikasyon

**Pagpapatakbo ng Spring Boot application:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Pagbuo ng proyekto:**
```bash
cd [project-directory]
mvn clean install
```

**Pagpapatakbo ng MCP Calculator Server:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Pagpapatakbo ng Mga Halimbawa ng Kliyente:**
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
Kasama ang Spring Boot DevTools sa mga proyekto na sumusuporta sa hot reload:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Mga Tagubilin sa Pagsubok

### Pagpapatakbo ng Mga Pagsubok

**Patakbuhin ang lahat ng pagsubok sa isang proyekto:**
```bash
cd [project-directory]
mvn test
```

**Patakbuhin ang mga pagsubok na may detalyadong output:**
```bash
mvn test -X
```

**Patakbuhin ang partikular na test class:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Estruktura ng Pagsubok
- Ang mga test file ay gumagamit ng JUnit 5 (Jupiter)
- Ang mga test class ay matatagpuan sa `src/test/java/`
- Ang mga halimbawa ng kliyente sa calculator project ay nasa `src/test/java/com/microsoft/mcp/sample/client/`

### Manu-manong Pagsubok
Maraming mga halimbawa ang interactive na mga aplikasyon na nangangailangan ng manu-manong pagsubok:

1. Patakbuhin ang application gamit ang `mvn spring-boot:run`
2. Subukan ang mga endpoint o makipag-ugnayan sa CLI
3. Siguraduhing ang inaasahang pag-uugali ay tumutugma sa dokumentasyon sa README.md ng bawat proyekto

### Pagsubok gamit ang GitHub Models
- Mga limitasyon sa libreng tier: 15 kahilingan/minuto, 150/araw
- Maximum na 5 sabay-sabay na kahilingan
- Subukan ang content filtering gamit ang mga halimbawa ng responsible AI

## Mga Alituntunin sa Estilo ng Code

### Mga Konbensyon sa Java
- **Bersyon ng Java:** Java 21 na may modernong mga tampok
- **Estilo:** Sundin ang karaniwang mga konbensyon sa Java
- **Pagpapangalan:** 
  - Mga Klase: PascalCase
  - Mga Pamamaraan/variable: camelCase
  - Mga Constants: UPPER_SNAKE_CASE
  - Mga Pangalan ng Package: lowercase

### Mga Pattern ng Spring Boot
- Gumamit ng `@Service` para sa business logic
- Gumamit ng `@RestController` para sa REST endpoints
- Konpigurasyon sa pamamagitan ng `application.yml` o `application.properties`
- Mas gusto ang mga environment variable kaysa sa mga hard-coded na halaga
- Gumamit ng `@Tool` annotation para sa mga pamamaraan na nakalantad sa MCP

### Organisasyon ng File
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

### Mga Dependency
- Pinamamahalaan sa pamamagitan ng Maven `pom.xml`
- Spring AI BOM para sa pamamahala ng bersyon
- LangChain4j para sa AI integrations
- Spring Boot starter parent para sa mga dependency ng Spring

### Mga Komento sa Code
- Magdagdag ng JavaDoc para sa mga pampublikong API
- Isama ang mga paliwanag na komento para sa mga kumplikadong AI interactions
- I-dokumenta nang malinaw ang mga paglalarawan ng MCP tool

## Pagbuo at Pag-deploy

### Pagbuo ng Mga Proyekto

**Pagbuo nang walang mga pagsubok:**
```bash
mvn clean install -DskipTests
```

**Pagbuo na may lahat ng mga tseke:**
```bash
mvn clean install
```

**Pag-package ng application:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Mga Output Directory
- Mga compiled na klase: `target/classes/`
- Mga test class: `target/test-classes/`
- Mga JAR file: `target/*.jar`
- Mga Maven artifact: `target/`

### Konpigurasyon na Tukoy sa Kapaligiran

**Pag-develop:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Produksyon:**
- Gumamit ng Azure AI Foundry Models sa halip na GitHub Models
- I-update ang base-url sa Azure OpenAI endpoint
- Pamahalaan ang mga lihim sa pamamagitan ng Azure Key Vault o mga environment variable

### Mga Pagsasaalang-alang sa Pag-deploy
- Ito ay isang pang-edukasyong repository na may mga sample na aplikasyon
- Hindi idinisenyo para sa produksyon na pag-deploy sa kasalukuyang anyo
- Ang mga halimbawa ay nagpapakita ng mga pattern na maaaring iakma para sa produksyon
- Tingnan ang README.md ng bawat proyekto para sa mga partikular na tala sa pag-deploy

## Karagdagang Tala

### GitHub Models vs Azure OpenAI
- **GitHub Models:** Libreng tier para sa pag-aaral, walang kinakailangang credit card
- **Azure OpenAI:** Handa para sa produksyon, nangangailangan ng Azure subscription
- Ang code ay compatible sa pagitan ng dalawa - baguhin lamang ang endpoint at API key

### Paggawa gamit ang Maramihang Proyekto
Ang bawat sample na proyekto ay standalone:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Karaniwang Mga Isyu

**Hindi Tugma ang Bersyon ng Java:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Mga Isyu sa Pag-download ng Dependency:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**Hindi Natagpuan ang GitHub Token:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Port na Ginagamit na:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Suporta sa Multi-Language
- Ang dokumentasyon ay magagamit sa mahigit 45 na wika sa pamamagitan ng automated na pagsasalin
- Ang mga pagsasalin ay nasa `translations/` directory
- Ang pagsasalin ay pinamamahalaan ng GitHub Actions workflow

### Landas ng Pag-aaral
1. Simulan sa [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Sundin ang mga kabanata sa pagkakasunod-sunod (01 → 05)
3. Kumpletuhin ang mga hands-on na halimbawa sa bawat kabanata
4. Galugarin ang mga sample na proyekto sa Kabanata 4
5. Matutunan ang mga responsible AI practices sa Kabanata 5

### Development Container
Ang `.devcontainer/devcontainer.json` ay nagko-configure ng:
- Java 21 development environment
- Maven na naka-pre-install
- VS Code Java extensions
- Mga tool ng Spring Boot
- Integrasyon ng GitHub Copilot
- Docker-in-Docker support
- Azure CLI

### Mga Pagsasaalang-alang sa Performance
- Ang libreng tier ng GitHub Models ay may mga limitasyon sa rate
- Gumamit ng naaangkop na batch sizes para sa embeddings
- Isaalang-alang ang caching para sa mga paulit-ulit na API calls
- Subaybayan ang paggamit ng token para sa cost optimization

### Mga Tala sa Seguridad
- Huwag kailanman i-commit ang `.env` files (nasa `.gitignore` na)
- Gumamit ng mga environment variable para sa mga API key
- Ang mga GitHub token ay dapat may minimal na kinakailangang scopes
- Sundin ang mga responsible AI guidelines sa Kabanata 5

---

**Paunawa**:  
Ang dokumentong ito ay isinalin gamit ang AI translation service na [Co-op Translator](https://github.com/Azure/co-op-translator). Bagama't sinisikap naming maging tumpak, pakitandaan na ang mga awtomatikong pagsasalin ay maaaring maglaman ng mga pagkakamali o hindi pagkakatugma. Ang orihinal na dokumento sa kanyang katutubong wika ang dapat ituring na opisyal na pinagmulan. Para sa mahalagang impormasyon, inirerekomenda ang propesyonal na pagsasalin ng tao. Hindi kami mananagot sa anumang hindi pagkakaunawaan o maling interpretasyon na dulot ng paggamit ng pagsasaling ito.