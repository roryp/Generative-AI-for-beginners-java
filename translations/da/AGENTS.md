<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:37:31+00:00",
  "source_file": "AGENTS.md",
  "language_code": "da"
}
-->
# AGENTS.md

## Projektoversigt

Dette er et uddannelsesrepository til at lære udvikling af Generativ AI med Java. Det tilbyder et omfattende praktisk kursus, der dækker Large Language Models (LLMs), prompt engineering, embeddings, RAG (Retrieval-Augmented Generation) og Model Context Protocol (MCP).

**Nøgleteknologier:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI og OpenAI SDKs

**Arkitektur:**
- Flere selvstændige Spring Boot-applikationer organiseret efter kapitler
- Eksempelprojekter, der demonstrerer forskellige AI-mønstre
- Klar til GitHub Codespaces med forudkonfigurerede udviklingscontainere

## Opsætningskommandoer

### Forudsætninger
- Java 21 eller nyere
- Maven 3.x
- GitHub personlig adgangstoken (til GitHub Models)
- Valgfrit: Azure OpenAI-legitimationsoplysninger

### Miljøopsætning

**Mulighed 1: GitHub Codespaces (Anbefalet)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Mulighed 2: Lokal udviklingscontainer**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Mulighed 3: Lokal opsætning**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Konfiguration

**Opsætning af GitHub-token:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Opsætning af Azure OpenAI (Valgfrit):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Udviklingsworkflow

### Projektstruktur
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

### Kørsel af applikationer

**Kørsel af en Spring Boot-applikation:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Bygning af et projekt:**
```bash
cd [project-directory]
mvn clean install
```

**Start af MCP Calculator Server:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Kørsel af klienteksempler:**
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
Spring Boot DevTools er inkluderet i projekter, der understøtter hot reload:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Testinstruktioner

### Kørsel af tests

**Kør alle tests i et projekt:**
```bash
cd [project-directory]
mvn test
```

**Kør tests med detaljeret output:**
```bash
mvn test -X
```

**Kør specifik testklasse:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Teststruktur
- Testfiler bruger JUnit 5 (Jupiter)
- Testklasser er placeret i `src/test/java/`
- Klienteksempler i calculator-projektet findes i `src/test/java/com/microsoft/mcp/sample/client/`

### Manuel testning
Mange eksempler er interaktive applikationer, der kræver manuel testning:

1. Start applikationen med `mvn spring-boot:run`
2. Test endpoints eller interager med CLI
3. Bekræft, at den forventede adfærd matcher dokumentationen i hver projekts README.md

### Testning med GitHub Models
- Begrænsninger for gratis niveau: 15 forespørgsler/minut, 150/dag
- Maksimalt 5 samtidige forespørgsler
- Test indholdsfiltrering med ansvarlige AI-eksempler

## Retningslinjer for kodestil

### Java-konventioner
- **Java-version:** Java 21 med moderne funktioner
- **Stil:** Følg standard Java-konventioner
- **Navngivning:** 
  - Klasser: PascalCase
  - Metoder/variabler: camelCase
  - Konstanter: UPPER_SNAKE_CASE
  - Pakkenavne: små bogstaver

### Spring Boot-mønstre
- Brug `@Service` til forretningslogik
- Brug `@RestController` til REST-endpoints
- Konfiguration via `application.yml` eller `application.properties`
- Miljøvariabler foretrækkes frem for hårdkodede værdier
- Brug `@Tool`-annotering til MCP-eksponerede metoder

### Filorganisering
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

### Afhængigheder
- Administreres via Maven `pom.xml`
- Spring AI BOM til versionsstyring
- LangChain4j til AI-integrationer
- Spring Boot starter parent til Spring-afhængigheder

### Kodekommentarer
- Tilføj JavaDoc til offentlige API'er
- Inkluder forklarende kommentarer til komplekse AI-interaktioner
- Dokumentér MCP-værktøjsbeskrivelser tydeligt

## Bygning og udrulning

### Bygning af projekter

**Byg uden tests:**
```bash
mvn clean install -DskipTests
```

**Byg med alle kontrolpunkter:**
```bash
mvn clean install
```

**Pak applikation:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Outputmapper
- Kompilerede klasser: `target/classes/`
- Testklasser: `target/test-classes/`
- JAR-filer: `target/*.jar`
- Maven-artikler: `target/`

### Miljøspecifik konfiguration

**Udvikling:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Produktion:**
- Brug Azure AI Foundry Models i stedet for GitHub Models
- Opdater base-url til Azure OpenAI-endpoint
- Administrer hemmeligheder via Azure Key Vault eller miljøvariabler

### Overvejelser ved udrulning
- Dette er et uddannelsesrepository med eksempelapplikationer
- Ikke designet til produktionsudrulning som det er
- Eksempler demonstrerer mønstre, der kan tilpasses til produktionsbrug
- Se individuelle projekt-README'er for specifikke udrulningsnoter

## Yderligere noter

### GitHub Models vs Azure OpenAI
- **GitHub Models:** Gratis niveau til læring, ingen kreditkort påkrævet
- **Azure OpenAI:** Produktionsklar, kræver Azure-abonnement
- Koden er kompatibel mellem begge - skift blot endpoint og API-nøgle

### Arbejde med flere projekter
Hvert eksempelprojekt er selvstændigt:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Almindelige problemer

**Java-version mismatch:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Problemer med afhængighedsdownload:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub-token ikke fundet:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Port allerede i brug:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Flersproget support
- Dokumentation tilgængelig på 45+ sprog via automatisk oversættelse
- Oversættelser i `translations/`-mappen
- Oversættelse administreret af GitHub Actions workflow

### Læringssti
1. Start med [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Følg kapitlerne i rækkefølge (01 → 05)
3. Fuldfør praktiske eksempler i hvert kapitel
4. Udforsk eksempelprojekter i kapitel 4
5. Lær ansvarlige AI-praksisser i kapitel 5

### Udviklingscontainer
`.devcontainer/devcontainer.json` konfigurerer:
- Java 21 udviklingsmiljø
- Maven forudinstalleret
- VS Code Java-udvidelser
- Spring Boot-værktøjer
- GitHub Copilot-integration
- Docker-in-Docker support
- Azure CLI

### Ydelsesmæssige overvejelser
- GitHub Models gratis niveau har hastighedsbegrænsninger
- Brug passende batchstørrelser til embeddings
- Overvej caching til gentagne API-kald
- Overvåg tokenforbrug for omkostningsoptimering

### Sikkerhedsnoter
- Commit aldrig `.env`-filer (allerede i `.gitignore`)
- Brug miljøvariabler til API-nøgler
- GitHub-tokens bør have minimale nødvendige tilladelser
- Følg ansvarlige AI-retningslinjer i kapitel 5

---

**Ansvarsfraskrivelse**:  
Dette dokument er blevet oversat ved hjælp af AI-oversættelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selvom vi bestræber os på nøjagtighed, skal det bemærkes, at automatiserede oversættelser kan indeholde fejl eller unøjagtigheder. Det originale dokument på dets oprindelige sprog bør betragtes som den autoritative kilde. For kritisk information anbefales professionel menneskelig oversættelse. Vi påtager os ikke ansvar for misforståelser eller fejltolkninger, der måtte opstå som følge af brugen af denne oversættelse.