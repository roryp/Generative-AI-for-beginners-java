<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:37:55+00:00",
  "source_file": "AGENTS.md",
  "language_code": "no"
}
-->
# AGENTS.md

## Prosjektoversikt

Dette er et utdanningslager for å lære utvikling av Generativ AI med Java. Det tilbyr et omfattende praktisk kurs som dekker Store Språkmodeller (LLMs), prompt engineering, embeddings, RAG (Retrieval-Augmented Generation) og Model Context Protocol (MCP).

**Nøkkelteknologier:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI og OpenAI SDKs

**Arkitektur:**
- Flere frittstående Spring Boot-applikasjoner organisert etter kapitler
- Eksempelprosjekter som demonstrerer ulike AI-mønstre
- Klar for GitHub Codespaces med forhåndskonfigurerte utviklingscontainere

## Oppsettskommandoer

### Forutsetninger
- Java 21 eller nyere
- Maven 3.x
- GitHub personlig tilgangstoken (for GitHub Models)
- Valgfritt: Azure OpenAI-legitimasjon

### Miljøoppsett

**Alternativ 1: GitHub Codespaces (Anbefalt)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Alternativ 2: Lokal utviklingscontainer**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Alternativ 3: Lokalt oppsett**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Konfigurasjon

**GitHub Token-oppsett:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI-oppsett (Valgfritt):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Utviklingsarbeidsflyt

### Prosjektstruktur
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

### Kjøre applikasjoner

**Kjøre en Spring Boot-applikasjon:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Bygge et prosjekt:**
```bash
cd [project-directory]
mvn clean install
```

**Starte MCP Calculator Server:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Kjøre klienteksempler:**
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
Spring Boot DevTools er inkludert i prosjekter som støtter hot reload:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Testinstruksjoner

### Kjøre tester

**Kjør alle tester i et prosjekt:**
```bash
cd [project-directory]
mvn test
```

**Kjør tester med detaljert output:**
```bash
mvn test -X
```

**Kjør spesifikk testklasse:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Teststruktur
- Testfiler bruker JUnit 5 (Jupiter)
- Testklasser ligger i `src/test/java/`
- Klienteksempler i kalkulatorprosjektet ligger i `src/test/java/com/microsoft/mcp/sample/client/`

### Manuell testing
Mange eksempler er interaktive applikasjoner som krever manuell testing:

1. Start applikasjonen med `mvn spring-boot:run`
2. Test endepunkter eller interager med CLI
3. Verifiser at forventet oppførsel samsvarer med dokumentasjonen i hver prosjekts README.md

### Testing med GitHub Models
- Gratisnivåbegrensninger: 15 forespørsler/minutt, 150/dag
- Maksimalt 5 samtidige forespørsler
- Test innholdsfiltrering med eksempler på ansvarlig AI

## Retningslinjer for kodestil

### Java-konvensjoner
- **Java-versjon:** Java 21 med moderne funksjoner
- **Stil:** Følg standard Java-konvensjoner
- **Navngivning:** 
  - Klasser: PascalCase
  - Metoder/variabler: camelCase
  - Konstanter: UPPER_SNAKE_CASE
  - Pakkenavn: små bokstaver

### Spring Boot-mønstre
- Bruk `@Service` for forretningslogikk
- Bruk `@RestController` for REST-endepunkter
- Konfigurasjon via `application.yml` eller `application.properties`
- Miljøvariabler foretrukket fremfor hardkodede verdier
- Bruk `@Tool`-annotasjon for MCP-eksponerte metoder

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

### Avhengigheter
- Administrert via Maven `pom.xml`
- Spring AI BOM for versjonsstyring
- LangChain4j for AI-integrasjoner
- Spring Boot starter parent for Spring-avhengigheter

### Kodekommentarer
- Legg til JavaDoc for offentlige API-er
- Inkluder forklarende kommentarer for komplekse AI-interaksjoner
- Dokumenter MCP-verktøybeskrivelser tydelig

## Bygging og distribusjon

### Bygge prosjekter

**Bygg uten tester:**
```bash
mvn clean install -DskipTests
```

**Bygg med alle kontroller:**
```bash
mvn clean install
```

**Pakk applikasjon:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Output-kataloger
- Kompilerte klasser: `target/classes/`
- Testklasser: `target/test-classes/`
- JAR-filer: `target/*.jar`
- Maven-artikler: `target/`

### Miljøspesifikk konfigurasjon

**Utvikling:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Produksjon:**
- Bruk Azure AI Foundry Models i stedet for GitHub Models
- Oppdater base-url til Azure OpenAI-endepunkt
- Administrer hemmeligheter via Azure Key Vault eller miljøvariabler

### Distribusjonshensyn
- Dette er et utdanningslager med eksempelapplikasjoner
- Ikke designet for produksjonsdistribusjon som det er
- Eksempler demonstrerer mønstre som kan tilpasses for produksjonsbruk
- Se individuelle prosjekt-README-er for spesifikke distribusjonsnotater

## Tilleggsnotater

### GitHub Models vs Azure OpenAI
- **GitHub Models:** Gratisnivå for læring, ingen kredittkort kreves
- **Azure OpenAI:** Klar for produksjon, krever Azure-abonnement
- Koden er kompatibel mellom begge - bare endre endepunkt og API-nøkkel

### Arbeide med flere prosjekter
Hvert eksempelprosjekt er frittstående:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Vanlige problemer

**Java-versjonsmisforhold:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Problemer med nedlasting av avhengigheter:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub-token ikke funnet:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Port allerede i bruk:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Flerspråklig støtte
- Dokumentasjon tilgjengelig på 45+ språk via automatisk oversettelse
- Oversettelser i `translations/`-katalogen
- Oversettelse administrert av GitHub Actions-arbeidsflyt

### Læringssti
1. Start med [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Følg kapitlene i rekkefølge (01 → 05)
3. Fullfør praktiske eksempler i hvert kapittel
4. Utforsk eksempelprosjekter i kapittel 4
5. Lær ansvarlige AI-praksiser i kapittel 5

### Utviklingscontainer
`.devcontainer/devcontainer.json` konfigurerer:
- Java 21 utviklingsmiljø
- Maven forhåndsinstallert
- VS Code Java-utvidelser
- Spring Boot-verktøy
- GitHub Copilot-integrasjon
- Docker-in-Docker-støtte
- Azure CLI

### Ytelseshensyn
- GitHub Models gratisnivå har hastighetsbegrensninger
- Bruk passende batch-størrelser for embeddings
- Vurder caching for gjentatte API-kall
- Overvåk tokenbruk for kostnadsoptimalisering

### Sikkerhetsnotater
- Aldri begå `.env`-filer (allerede i `.gitignore`)
- Bruk miljøvariabler for API-nøkler
- GitHub-tokens bør ha minimale nødvendige tillatelser
- Følg retningslinjer for ansvarlig AI i kapittel 5

---

**Ansvarsfraskrivelse**:  
Dette dokumentet er oversatt ved hjelp av AI-oversettelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selv om vi tilstreber nøyaktighet, vær oppmerksom på at automatiserte oversettelser kan inneholde feil eller unøyaktigheter. Det originale dokumentet på sitt opprinnelige språk bør anses som den autoritative kilden. For kritisk informasjon anbefales profesjonell menneskelig oversettelse. Vi er ikke ansvarlige for eventuelle misforståelser eller feiltolkninger som oppstår ved bruk av denne oversettelsen.