<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:41:19+00:00",
  "source_file": "AGENTS.md",
  "language_code": "sw"
}
-->
# AGENTS.md

## Muhtasari wa Mradi

Hii ni hifadhi ya kielimu kwa ajili ya kujifunza maendeleo ya Generative AI kwa kutumia Java. Inatoa kozi ya vitendo inayoshughulikia Large Language Models (LLMs), uhandisi wa maelekezo, embeddings, RAG (Retrieval-Augmented Generation), na Model Context Protocol (MCP).

**Teknolojia Muhimu:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI, na OpenAI SDKs

**Muundo wa Kijarida:**
- Programu nyingi za Spring Boot zinazojitegemea zimepangwa kwa sura
- Miradi ya mfano inayoonyesha mifumo tofauti ya AI
- Tayari kwa GitHub Codespaces na kontena za maendeleo zilizosanidiwa awali

## Amri za Usanidi

### Mahitaji ya Awali
- Java 21 au zaidi
- Maven 3.x
- Token ya ufikiaji wa kibinafsi ya GitHub (kwa GitHub Models)
- Hiari: Hati za Azure OpenAI

### Usanidi wa Mazingira

**Chaguo 1: GitHub Codespaces (Inapendekezwa)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Chaguo 2: Kontena ya Maendeleo ya Kwenye Kompyuta**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Chaguo 3: Usanidi wa Kwenye Kompyuta**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Usanidi

**Usanidi wa Token ya GitHub:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Usanidi wa Azure OpenAI (Hiari):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Mtiririko wa Maendeleo

### Muundo wa Mradi
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

### Kuendesha Programu

**Kuendesha programu ya Spring Boot:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Kujenga mradi:**
```bash
cd [project-directory]
mvn clean install
```

**Kuanza MCP Calculator Server:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Kuendesha Mifano ya Wateja:**
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

### Upakiaji wa Haraka
Spring Boot DevTools imejumuishwa katika miradi inayounga mkono upakiaji wa haraka:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Maelekezo ya Kupima

### Kuendesha Majaribio

**Endesha majaribio yote katika mradi:**
```bash
cd [project-directory]
mvn test
```

**Endesha majaribio na matokeo ya kina:**
```bash
mvn test -X
```

**Endesha darasa maalum la majaribio:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Muundo wa Majaribio
- Faili za majaribio zinatumia JUnit 5 (Jupiter)
- Madarasa ya majaribio yapo katika `src/test/java/`
- Mifano ya wateja katika mradi wa calculator ipo katika `src/test/java/com/microsoft/mcp/sample/client/`

### Kupima kwa Mkono
Mifano mingi ni programu za maingiliano zinazohitaji kupimwa kwa mkono:

1. Anzisha programu kwa `mvn spring-boot:run`
2. Pima sehemu za mwisho au fanya maingiliano na CLI
3. Hakikisha tabia inayotarajiwa inalingana na nyaraka katika README.md ya kila mradi

### Kupima na GitHub Models
- Kiwango cha bure: maombi 15 kwa dakika, 150 kwa siku
- Maombi 5 yanayofanyika kwa wakati mmoja
- Pima uchujaji wa maudhui kwa mifano ya AI inayowajibika

## Miongozo ya Mtindo wa Nambari

### Mikataba ya Java
- **Toleo la Java:** Java 21 na vipengele vya kisasa
- **Mtindo:** Fuata mikataba ya kawaida ya Java
- **Majina:** 
  - Madarasa: PascalCase
  - Mbinu/variables: camelCase
  - Constants: UPPER_SNAKE_CASE
  - Majina ya pakiti: herufi ndogo

### Mifumo ya Spring Boot
- Tumia `@Service` kwa mantiki ya biashara
- Tumia `@RestController` kwa sehemu za mwisho za REST
- Usanidi kupitia `application.yml` au `application.properties`
- Vigezo vya mazingira vinapendekezwa badala ya maadili yaliyowekwa moja kwa moja
- Tumia `@Tool` kwa mbinu zinazofichuliwa na MCP

### Mpangilio wa Faili
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

### Utegemezi
- Inasimamiwa kupitia Maven `pom.xml`
- Spring AI BOM kwa usimamizi wa toleo
- LangChain4j kwa ujumuishaji wa AI
- Spring Boot starter parent kwa utegemezi wa Spring

### Maoni ya Nambari
- Ongeza JavaDoc kwa API za umma
- Jumuisha maoni ya kuelezea kwa mwingiliano mgumu wa AI
- Andika maelezo ya zana za MCP kwa uwazi

## Ujenzi na Uwekaji

### Kujenga Miradi

**Jenga bila majaribio:**
```bash
mvn clean install -DskipTests
```

**Jenga na ukaguzi wote:**
```bash
mvn clean install
```

**Funga programu:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Saraka za Matokeo
- Madarasa yaliyosanikwa: `target/classes/`
- Madarasa ya majaribio: `target/test-classes/`
- Faili za JAR: `target/*.jar`
- Vifaa vya Maven: `target/`

### Usanidi Maalum wa Mazingira

**Maendeleo:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Uzalishaji:**
- Tumia Azure AI Foundry Models badala ya GitHub Models
- Sasisha base-url kwa sehemu ya mwisho ya Azure OpenAI
- Simamia siri kupitia Azure Key Vault au vigezo vya mazingira

### Mazingatio ya Uwekaji
- Hii ni hifadhi ya kielimu yenye programu za mfano
- Haijasanidiwa kwa uwekaji wa uzalishaji kama ilivyo
- Mifano inaonyesha mifumo ya kubadilishwa kwa matumizi ya uzalishaji
- Tazama README za miradi binafsi kwa maelezo maalum ya uwekaji

## Vidokezo vya Ziada

### GitHub Models vs Azure OpenAI
- **GitHub Models:** Kiwango cha bure kwa kujifunza, hakuna kadi ya mkopo inayohitajika
- **Azure OpenAI:** Tayari kwa uzalishaji, inahitaji usajili wa Azure
- Nambari inaoana kati ya zote - badilisha tu sehemu ya mwisho na API key

### Kufanya Kazi na Miradi Mingi
Kila mradi wa mfano unajitegemea:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Masuala ya Kawaida

**Kutofautiana kwa Toleo la Java:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Masuala ya Upakuaji wa Utegemezi:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**Token ya GitHub Haikupatikana:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Bandari Tayari Inatumika:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Usaidizi wa Lugha Nyingi
- Nyaraka zinapatikana kwa lugha zaidi ya 45 kupitia tafsiri ya kiotomatiki
- Tafsiri zipo katika saraka ya `translations/`
- Tafsiri inasimamiwa na mtiririko wa kazi wa GitHub Actions

### Njia ya Kujifunza
1. Anza na [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Fuata sura kwa mpangilio (01 → 05)
3. Kamilisha mifano ya vitendo katika kila sura
4. Chunguza miradi ya mfano katika Sura ya 4
5. Jifunze mazoea ya AI inayowajibika katika Sura ya 5

### Kontena ya Maendeleo
`.devcontainer/devcontainer.json` inasanidi:
- Mazingira ya maendeleo ya Java 21
- Maven imewekwa awali
- Viendelezi vya Java vya VS Code
- Zana za Spring Boot
- Ujumuishaji wa GitHub Copilot
- Docker-in-Docker
- Azure CLI

### Mazingatio ya Utendaji
- Kiwango cha bure cha GitHub Models kina mipaka ya kiwango
- Tumia saizi sahihi za kundi kwa embeddings
- Fikiria kuhifadhi kwa maombi ya API yanayojirudia
- Fuatilia matumizi ya token kwa uboreshaji wa gharama

### Vidokezo vya Usalama
- Usikubali faili za `.env` (tayari zipo kwenye `.gitignore`)
- Tumia vigezo vya mazingira kwa API keys
- Token za GitHub zinapaswa kuwa na ruhusa ndogo zinazohitajika
- Fuata miongozo ya AI inayowajibika katika Sura ya 5

---

**Kanusho**:  
Hati hii imetafsiriwa kwa kutumia huduma ya tafsiri ya AI [Co-op Translator](https://github.com/Azure/co-op-translator). Ingawa tunajitahidi kuhakikisha usahihi, tafadhali fahamu kuwa tafsiri za kiotomatiki zinaweza kuwa na makosa au kutokuwa sahihi. Hati ya asili katika lugha yake ya awali inapaswa kuzingatiwa kama chanzo cha mamlaka. Kwa taarifa muhimu, tafsiri ya kitaalamu ya binadamu inapendekezwa. Hatutawajibika kwa kutoelewana au tafsiri zisizo sahihi zinazotokana na matumizi ya tafsiri hii.