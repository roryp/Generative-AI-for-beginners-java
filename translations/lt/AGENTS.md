# AGENTS.md

## Projekto apžvalga

Tai edukacinis saugyklos projektas, skirtas mokytis generatyvinio AI kūrimo su Java. Jame pateikiamas išsamus praktinis kursas, apimantis didelius kalbos modelius (LLMs), užklausų kūrimą, įterpimus, RAG (paieška praturtinta generacija) ir Modelio konteksto protokolą (MCP).

**Pagrindinės technologijos:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI ir OpenAI SDKs

**Architektūra:**
- Keli atskiri Spring Boot programos, suskirstytos pagal skyrius
- Pavyzdiniai projektai, demonstruojantys skirtingus AI modelius
- Paruošta GitHub Codespaces su iš anksto sukonfigūruotais kūrimo konteineriais

## Nustatymo komandos

### Reikalavimai
- Java 21 ar naujesnė
- Maven 3.x
- GitHub asmeninis prieigos raktas (GitHub Models)
- Pasirinktinai: Azure OpenAI prisijungimo duomenys

### Aplinkos nustatymas

**1 variantas: GitHub Codespaces (rekomenduojama)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**2 variantas: Vietinis kūrimo konteineris**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**3 variantas: Vietinis nustatymas**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Konfigūracija

**GitHub rakto nustatymas:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI nustatymas (pasirinktinai):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Kūrimo procesas

### Projekto struktūra
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

### Programų paleidimas

**Spring Boot programos paleidimas:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Projekto kūrimas:**
```bash
cd [project-directory]
mvn clean install
```

**MCP skaičiuoklės serverio paleidimas:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Kliento pavyzdžių paleidimas:**
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

### Karštasis perkrovimas
Spring Boot DevTools įtrauktas į projektus, kurie palaiko karštąjį perkrovimą:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Testavimo instrukcijos

### Testų paleidimas

**Paleisti visus projekto testus:**
```bash
cd [project-directory]
mvn test
```

**Paleisti testus su išsamia išvestimi:**
```bash
mvn test -X
```

**Paleisti konkrečią testų klasę:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Testų struktūra
- Testų failai naudoja JUnit 5 (Jupiter)
- Testų klasės yra `src/test/java/`
- Kliento pavyzdžiai skaičiuoklės projekte yra `src/test/java/com/microsoft/mcp/sample/client/`

### Rankinis testavimas
Daugelis pavyzdžių yra interaktyvios programos, reikalaujančios rankinio testavimo:

1. Paleiskite programą su `mvn spring-boot:run`
2. Testuokite galinius taškus arba sąveikaukite su CLI
3. Patikrinkite, ar tikėtinas elgesys atitinka dokumentaciją kiekvieno projekto README.md

### Testavimas su GitHub Models
- Nemokamo plano apribojimai: 15 užklausų/minutę, 150 per dieną
- Maksimaliai 5 lygiagrečios užklausos
- Testuokite turinio filtravimą su atsakingo AI pavyzdžiais

## Kodo stiliaus gairės

### Java konvencijos
- **Java versija:** Java 21 su moderniomis funkcijomis
- **Stilius:** Laikykitės standartinių Java konvencijų
- **Pavadinimai:** 
  - Klasės: PascalCase
  - Metodai/kintamieji: camelCase
  - Konstantos: UPPER_SNAKE_CASE
  - Paketų pavadinimai: mažosios raidės

### Spring Boot modeliai
- Naudokite `@Service` verslo logikai
- Naudokite `@RestController` REST galiniams taškams
- Konfigūracija per `application.yml` arba `application.properties`
- Aplinkos kintamieji yra geriau nei kietai užkoduotos reikšmės
- Naudokite `@Tool` anotaciją MCP eksponuojamiems metodams

### Failų organizavimas
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

### Priklausomybės
- Valdomos per Maven `pom.xml`
- Spring AI BOM versijų valdymui
- LangChain4j AI integracijoms
- Spring Boot starter parent Spring priklausomybėms

### Kodo komentarai
- Pridėkite JavaDoc viešiems API
- Įtraukite paaiškinamuosius komentarus sudėtingoms AI sąveikoms
- Aiškiai dokumentuokite MCP įrankių aprašymus

## Kūrimas ir diegimas

### Projektų kūrimas

**Kūrimas be testų:**
```bash
mvn clean install -DskipTests
```

**Kūrimas su visais patikrinimais:**
```bash
mvn clean install
```

**Programos paketavimas:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Išvesties katalogai
- Kompiliuoti klasės failai: `target/classes/`
- Testų klasės: `target/test-classes/`
- JAR failai: `target/*.jar`
- Maven artefaktai: `target/`

### Konfigūracija pagal aplinką

**Kūrimas:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Produkcija:**
- Naudokite Azure AI Foundry Models vietoj GitHub Models
- Atnaujinkite bazinį URL į Azure OpenAI galinį tašką
- Valdykite slaptažodžius per Azure Key Vault arba aplinkos kintamuosius

### Diegimo svarstymai
- Tai edukacinis saugyklos projektas su pavyzdinėmis programomis
- Nėra skirtas tiesioginiam diegimui kaip yra
- Pavyzdžiai demonstruoja modelius, kuriuos galima pritaikyti produkcijai
- Žr. atskirų projektų README failus dėl konkrečių diegimo pastabų

## Papildomos pastabos

### GitHub Models vs Azure OpenAI
- **GitHub Models:** Nemokamas planas mokymuisi, nereikia kredito kortelės
- **Azure OpenAI:** Paruoštas produkcijai, reikalinga Azure prenumerata
- Kodas suderinamas su abiem - tiesiog pakeiskite galinį tašką ir API raktą

### Darbas su keliais projektais
Kiekvienas pavyzdinis projektas yra atskiras:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Dažnos problemos

**Java versijos neatitikimas:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Priklausomybių atsisiuntimo problemos:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub rakto nerasta:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Portas jau naudojamas:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Daugiakalbė parama
- Dokumentacija prieinama daugiau nei 45 kalbomis per automatinį vertimą
- Vertimai saugomi `translations/` kataloge
- Vertimą valdo GitHub Actions darbo eiga

### Mokymosi kelias
1. Pradėkite nuo [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Sekite skyrius iš eilės (01 → 05)
3. Atlikite praktinius pavyzdžius kiekviename skyriuje
4. Tyrinėkite pavyzdinius projektus 4 skyriuje
5. Mokykitės atsakingo AI praktikų 5 skyriuje

### Kūrimo konteineris
`.devcontainer/devcontainer.json` konfigūruoja:
- Java 21 kūrimo aplinką
- Iš anksto įdiegtą Maven
- VS Code Java plėtinius
- Spring Boot įrankius
- GitHub Copilot integraciją
- Docker-in-Docker palaikymą
- Azure CLI

### Našumo svarstymai
- GitHub Models nemokamas planas turi apribojimus
- Naudokite tinkamus partijų dydžius įterpimams
- Apsvarstykite talpyklą pakartotiniams API skambučiams
- Stebėkite žetonų naudojimą, kad optimizuotumėte išlaidas

### Saugumo pastabos
- Niekada neįtraukite `.env` failų (jau yra `.gitignore`)
- Naudokite aplinkos kintamuosius API raktams
- GitHub raktai turėtų turėti minimaliai reikalingus leidimus
- Laikykitės atsakingo AI gairių 5 skyriuje

---

**Atsakomybės apribojimas**:  
Šis dokumentas buvo išverstas naudojant AI vertimo paslaugą [Co-op Translator](https://github.com/Azure/co-op-translator). Nors stengiamės užtikrinti tikslumą, prašome atkreipti dėmesį, kad automatiniai vertimai gali turėti klaidų ar netikslumų. Originalus dokumentas jo gimtąja kalba turėtų būti laikomas autoritetingu šaltiniu. Kritinei informacijai rekomenduojama naudoti profesionalų žmogaus vertimą. Mes neprisiimame atsakomybės už nesusipratimus ar neteisingus interpretavimus, atsiradusius dėl šio vertimo naudojimo.