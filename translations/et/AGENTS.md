<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-11T10:37:42+00:00",
  "source_file": "AGENTS.md",
  "language_code": "et"
}
-->
# AGENTS.md

## Projekti Ülevaade

See on hariduslik repositoorium Generatiivse AI arendamise õppimiseks Java keeles. See pakub põhjalikku praktilist kursust, mis hõlmab suuri keelemudeleid (LLMs), promptide loomist, sisseehitatud vektorite kasutamist, RAG-i (Retrieval-Augmented Generation) ja mudeli konteksti protokolli (MCP).

**Peamised tehnoloogiad:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI ja OpenAI SDK-d

**Arhitektuur:**
- Mitmed iseseisvad Spring Boot rakendused, mis on organiseeritud peatükkide kaupa
- Näidisprojektid, mis demonstreerivad erinevaid AI mustreid
- Valmis GitHub Codespaces'i jaoks koos eelkonfigureeritud arenduskonteineritega

## Seadistamise Käsklused

### Eeltingimused
- Java 21 või uuem
- Maven 3.x
- GitHubi isiklik juurdepääsutoken (GitHub Models jaoks)
- Valikuline: Azure OpenAI mandaadid

### Keskkonna Seadistamine

**Valik 1: GitHub Codespaces (Soovitatav)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Valik 2: Kohalik arenduskonteiner**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Valik 3: Kohalik seadistus**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Konfiguratsioon

**GitHub Tokeni Seadistamine:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI Seadistamine (Valikuline):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Arenduse Töövoog

### Projekti Struktuur
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

### Rakenduste Käivitamine

**Spring Boot rakenduse käivitamine:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Projekti ehitamine:**
```bash
cd [project-directory]
mvn clean install
```

**MCP Kalkulaatori Serveri käivitamine:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Kliendi näidete käivitamine:**
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

### Kuum Laadimine
Spring Boot DevTools on lisatud projektidesse, mis toetavad kuuma laadimist:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Testimise Juhised

### Testide Käivitamine

**Kõigi testide käivitamine projektis:**
```bash
cd [project-directory]
mvn test
```

**Testide käivitamine üksikasjaliku väljundiga:**
```bash
mvn test -X
```

**Konkreetse testklassi käivitamine:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Testide Struktuur
- Testfailid kasutavad JUnit 5 (Jupiter)
- Testklassid asuvad `src/test/java/` kaustas
- Kliendi näited kalkulaatori projektis asuvad `src/test/java/com/microsoft/mcp/sample/client/`

### Käsitsi Testimine
Paljud näited on interaktiivsed rakendused, mis nõuavad käsitsi testimist:

1. Käivitage rakendus käsuga `mvn spring-boot:run`
2. Testige lõpp-punkte või suhelge CLI-ga
3. Kontrollige, kas oodatav käitumine vastab dokumentatsioonile iga projekti README.md failis

### Testimine GitHub Models'iga
- Tasuta taseme piirangud: 15 päringut minutis, 150 päevas
- Maksimaalselt 5 samaaegset päringut
- Testige sisufiltreerimist vastutustundliku AI näidetega

## Koodistiili Juhised

### Java Konventsioonid
- **Java Versioon:** Java 21 kaasaegsete funktsioonidega
- **Stiil:** Järgige standardseid Java konventsioone
- **Nimetamine:** 
  - Klassid: PascalCase
  - Meetodid/muutujad: camelCase
  - Konstandid: UPPER_SNAKE_CASE
  - Pakettide nimed: väiketähed

### Spring Boot Mustrid
- Kasutage `@Service` äriloogika jaoks
- Kasutage `@RestController` REST lõpp-punktide jaoks
- Konfiguratsioon `application.yml` või `application.properties` kaudu
- Keskkonnamuutujad eelistatud kõvaks kodeeritud väärtuste asemel
- Kasutage `@Tool` annotatsiooni MCP-ga seotud meetodite jaoks

### Failide Organisatsioon
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

### Sõltuvused
- Hallatud Maven `pom.xml` kaudu
- Spring AI BOM versioonihalduseks
- LangChain4j AI integratsioonide jaoks
- Spring Boot starter parent Spring sõltuvuste jaoks

### Koodi Kommentaarid
- Lisage JavaDoc avalike API-de jaoks
- Lisage selgitavad kommentaarid keerukate AI interaktsioonide jaoks
- Dokumenteerige MCP tööriistade kirjeldused selgelt

## Ehitamine ja Juhtimine

### Projektide Ehitamine

**Ehita ilma testideta:**
```bash
mvn clean install -DskipTests
```

**Ehita kõigi kontrollidega:**
```bash
mvn clean install
```

**Pakenda rakendus:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Väljundkaustad
- Kompileeritud klassid: `target/classes/`
- Testklassid: `target/test-classes/`
- JAR-failid: `target/*.jar`
- Maven artefaktid: `target/`

### Keskkonnaspetsiifiline Konfiguratsioon

**Arendus:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Tootmine:**
- Kasutage Azure AI Foundry Models GitHub Models asemel
- Uuendage base-url Azure OpenAI lõpp-punktiks
- Halda saladusi Azure Key Vaulti või keskkonnamuutujate kaudu

### Juhtimise Arvestused
- See on hariduslik repositoorium näidisrakendustega
- Ei ole mõeldud tootmisse juurutamiseks sellisena
- Näited demonstreerivad mustreid, mida saab kohandada tootmiskasutuseks
- Vaadake individuaalsete projektide README-sid konkreetsete juurutusmärkuste jaoks

## Täiendavad Märkused

### GitHub Models vs Azure OpenAI
- **GitHub Models:** Tasuta tase õppimiseks, krediitkaarti pole vaja
- **Azure OpenAI:** Tootmiskõlblik, nõuab Azure'i tellimust
- Kood on ühilduv mõlemaga - lihtsalt muutke lõpp-punkti ja API võtit

### Töötamine Mitme Projektiga
Iga näidisprojekt on iseseisev:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Levinud Probleemid

**Java Versiooni Mittevastavus:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Sõltuvuste Allalaadimise Probleemid:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub Token Puudub:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Port Juba Kasutuses:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Mitmekeelne Tugi
- Dokumentatsioon saadaval enam kui 45 keeles automaatse tõlke kaudu
- Tõlked asuvad `translations/` kataloogis
- Tõlkeid haldab GitHub Actions töövoog

### Õppimise Tee
1. Alustage [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Järgige peatükke järjekorras (01 → 05)
3. Täitke praktilised näited igas peatükis
4. Uurige näidisprojekte peatükis 4
5. Õppige vastutustundliku AI praktikaid peatükis 5

### Arenduskonteiner
`.devcontainer/devcontainer.json` konfigureerib:
- Java 21 arenduskeskkond
- Maven eelinstallitud
- VS Code Java laiendused
- Spring Boot tööriistad
- GitHub Copilot integratsioon
- Docker-in-Docker tugi
- Azure CLI

### Jõudluse Arvestused
- GitHub Models tasuta tasemel on määrapiirangud
- Kasutage sobivaid partiisuurusi vektorite jaoks
- Kaaluge vahemällu salvestamist korduvate API-kõnede jaoks
- Jälgige tokenite kasutust kulude optimeerimiseks

### Turvanõuanded
- Ärge kunagi pühendage `.env` faile (juba `.gitignore`-is)
- Kasutage API võtmete jaoks keskkonnamuutujaid
- GitHubi tokenitel peaksid olema minimaalsed vajalikud õigused
- Järgige vastutustundliku AI juhiseid peatükis 5

---

**Lahtiütlus**:  
See dokument on tõlgitud AI tõlketeenuse [Co-op Translator](https://github.com/Azure/co-op-translator) abil. Kuigi püüame tagada täpsust, palume arvestada, et automaatsed tõlked võivad sisaldada vigu või ebatäpsusi. Algne dokument selle algses keeles tuleks pidada autoriteetseks allikaks. Olulise teabe puhul soovitame kasutada professionaalset inimtõlget. Me ei vastuta selle tõlke kasutamisest tulenevate arusaamatuste või valesti tõlgenduste eest.