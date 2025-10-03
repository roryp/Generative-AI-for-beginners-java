<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:37:11+00:00",
  "source_file": "AGENTS.md",
  "language_code": "sv"
}
-->
# AGENTS.md

## Projektöversikt

Detta är ett utbildningsarkiv för att lära sig utveckling av Generativ AI med Java. Det erbjuder en omfattande praktisk kurs som täcker Stora Språkmodeller (LLMs), promptteknik, embeddings, RAG (Retrieval-Augmented Generation) och Model Context Protocol (MCP).

**Nyckelteknologier:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI och OpenAI SDKs

**Arkitektur:**
- Flera fristående Spring Boot-applikationer organiserade efter kapitel
- Exempelprojekt som demonstrerar olika AI-mönster
- GitHub Codespaces-redo med förkonfigurerade utvecklingscontainrar

## Installationskommandon

### Förutsättningar
- Java 21 eller högre
- Maven 3.x
- GitHub personligt åtkomsttoken (för GitHub Models)
- Valfritt: Azure OpenAI-uppgifter

### Miljöinställning

**Alternativ 1: GitHub Codespaces (Rekommenderas)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Alternativ 2: Lokal utvecklingscontainer**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Alternativ 3: Lokal installation**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Konfiguration

**GitHub Token-inställning:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI-inställning (valfritt):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Utvecklingsarbetsflöde

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

### Köra applikationer

**Köra en Spring Boot-applikation:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Bygga ett projekt:**
```bash
cd [project-directory]
mvn clean install
```

**Starta MCP Calculator Server:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Köra klientexempel:**
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
Spring Boot DevTools ingår i projekt som stödjer hot reload:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Testinstruktioner

### Köra tester

**Kör alla tester i ett projekt:**
```bash
cd [project-directory]
mvn test
```

**Kör tester med detaljerad output:**
```bash
mvn test -X
```

**Kör specifik testklass:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Teststruktur
- Testfiler använder JUnit 5 (Jupiter)
- Testklasser finns i `src/test/java/`
- Klientexempel i kalkylatorprojektet finns i `src/test/java/com/microsoft/mcp/sample/client/`

### Manuell testning
Många exempel är interaktiva applikationer som kräver manuell testning:

1. Starta applikationen med `mvn spring-boot:run`
2. Testa endpoints eller interagera med CLI
3. Verifiera att förväntat beteende matchar dokumentationen i varje projekts README.md

### Testning med GitHub Models
- Begränsningar för gratisnivå: 15 förfrågningar/minut, 150/dag
- Max 5 samtidiga förfrågningar
- Testa innehållsfiltrering med ansvarsfulla AI-exempel

## Kodstilsguider

### Java-konventioner
- **Java-version:** Java 21 med moderna funktioner
- **Stil:** Följ standard Java-konventioner
- **Namnstandard:** 
  - Klasser: PascalCase
  - Metoder/variabler: camelCase
  - Konstanter: UPPER_SNAKE_CASE
  - Paketnamn: små bokstäver

### Spring Boot-mönster
- Använd `@Service` för affärslogik
- Använd `@RestController` för REST-endpoints
- Konfiguration via `application.yml` eller `application.properties`
- Miljövariabler föredras framför hårdkodade värden
- Använd `@Tool`-annotering för MCP-exponerade metoder

### Filorganisation
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

### Beroenden
- Hanteras via Maven `pom.xml`
- Spring AI BOM för versionshantering
- LangChain4j för AI-integrationer
- Spring Boot starter parent för Spring-beroenden

### Kodkommentarer
- Lägg till JavaDoc för publika API:er
- Inkludera förklarande kommentarer för komplexa AI-interaktioner
- Dokumentera MCP-verktygsbeskrivningar tydligt

## Bygg och distribution

### Bygga projekt

**Bygg utan tester:**
```bash
mvn clean install -DskipTests
```

**Bygg med alla kontroller:**
```bash
mvn clean install
```

**Paketera applikation:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Output-kataloger
- Kompilerade klasser: `target/classes/`
- Testklasser: `target/test-classes/`
- JAR-filer: `target/*.jar`
- Maven-artiklar: `target/`

### Miljöspecifik konfiguration

**Utveckling:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Produktion:**
- Använd Azure AI Foundry Models istället för GitHub Models
- Uppdatera base-url till Azure OpenAI endpoint
- Hantera hemligheter via Azure Key Vault eller miljövariabler

### Distributionsöverväganden
- Detta är ett utbildningsarkiv med exempelapplikationer
- Inte designat för produktionsdistribution som det är
- Exempel demonstrerar mönster att anpassa för produktionsbruk
- Se individuella projekt-README:s för specifika distributionsanteckningar

## Ytterligare anteckningar

### GitHub Models vs Azure OpenAI
- **GitHub Models:** Gratisnivå för lärande, inget kreditkort krävs
- **Azure OpenAI:** Produktionsklar, kräver Azure-abonnemang
- Koden är kompatibel mellan båda - ändra bara endpoint och API-nyckel

### Arbeta med flera projekt
Varje exempelprojekt är fristående:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Vanliga problem

**Java-version mismatch:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Problem med nedladdning av beroenden:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub-token saknas:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Port redan i användning:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Flerspråkigt stöd
- Dokumentation tillgänglig på 45+ språk via automatisk översättning
- Översättningar i katalogen `translations/`
- Översättning hanteras av GitHub Actions-arbetsflöde

### Lärandebana
1. Börja med [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Följ kapitlen i ordning (01 → 05)
3. Slutför praktiska exempel i varje kapitel
4. Utforska exempelprojekt i kapitel 4
5. Lär dig ansvarsfulla AI-principer i kapitel 5

### Utvecklingscontainer
Konfigurationen `.devcontainer/devcontainer.json` innehåller:
- Java 21 utvecklingsmiljö
- Maven förinstallerat
- VS Code Java-tillägg
- Spring Boot-verktyg
- GitHub Copilot-integration
- Docker-in-Docker-stöd
- Azure CLI

### Prestandaöverväganden
- GitHub Models gratisnivå har hastighetsbegränsningar
- Använd lämpliga batchstorlekar för embeddings
- Överväg caching för upprepade API-anrop
- Övervaka tokenanvändning för kostnadsoptimering

### Säkerhetsanteckningar
- Commita aldrig `.env`-filer (redan i `.gitignore`)
- Använd miljövariabler för API-nycklar
- GitHub-token bör ha minimalt nödvändiga behörigheter
- Följ ansvarsfulla AI-riktlinjer i kapitel 5

---

**Ansvarsfriskrivning**:  
Detta dokument har översatts med hjälp av AI-översättningstjänsten [Co-op Translator](https://github.com/Azure/co-op-translator). Även om vi strävar efter noggrannhet, bör det noteras att automatiska översättningar kan innehålla fel eller felaktigheter. Det ursprungliga dokumentet på dess originalspråk bör betraktas som den auktoritativa källan. För kritisk information rekommenderas professionell mänsklig översättning. Vi ansvarar inte för eventuella missförstånd eller feltolkningar som uppstår vid användning av denna översättning.