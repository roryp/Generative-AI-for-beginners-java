<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:38:50+00:00",
  "source_file": "AGENTS.md",
  "language_code": "nl"
}
-->
# AGENTS.md

## Projectoverzicht

Dit is een educatieve repository voor het leren ontwikkelen van Generatieve AI met Java. Het biedt een uitgebreide praktische cursus die Large Language Models (LLMs), prompt engineering, embeddings, RAG (Retrieval-Augmented Generation) en het Model Context Protocol (MCP) behandelt.

**Belangrijke technologieën:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI en OpenAI SDKs

**Architectuur:**
- Meerdere zelfstandige Spring Boot-applicaties georganiseerd per hoofdstuk
- Voorbeeldprojecten die verschillende AI-patronen demonstreren
- Klaar voor GitHub Codespaces met vooraf geconfigureerde ontwikkelcontainers

## Setup-commando's

### Vereisten
- Java 21 of hoger
- Maven 3.x
- GitHub persoonlijke toegangstoken (voor GitHub Models)
- Optioneel: Azure OpenAI-credentials

### Omgevingsinstellingen

**Optie 1: GitHub Codespaces (Aanbevolen)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Optie 2: Lokale ontwikkelcontainer**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Optie 3: Lokale setup**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Configuratie

**GitHub-token instellen:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI instellen (optioneel):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Ontwikkelworkflow

### Projectstructuur
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

### Applicaties uitvoeren

**Een Spring Boot-applicatie uitvoeren:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Een project bouwen:**
```bash
cd [project-directory]
mvn clean install
```

**De MCP Calculator Server starten:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Voorbeelden van clients uitvoeren:**
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
Spring Boot DevTools is inbegrepen in projecten die hot reload ondersteunen:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Testinstructies

### Tests uitvoeren

**Alle tests in een project uitvoeren:**
```bash
cd [project-directory]
mvn test
```

**Tests uitvoeren met uitgebreide output:**
```bash
mvn test -X
```

**Specifieke testklasse uitvoeren:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Teststructuur
- Testbestanden gebruiken JUnit 5 (Jupiter)
- Testklassen bevinden zich in `src/test/java/`
- Clientvoorbeelden in het calculatorproject bevinden zich in `src/test/java/com/microsoft/mcp/sample/client/`

### Handmatige tests
Veel voorbeelden zijn interactieve applicaties die handmatige tests vereisen:

1. Start de applicatie met `mvn spring-boot:run`
2. Test endpoints of werk met de CLI
3. Controleer of het verwachte gedrag overeenkomt met de documentatie in de README.md van elk project

### Testen met GitHub Models
- Gratis limieten: 15 verzoeken/minuut, 150/dag
- Maximaal 5 gelijktijdige verzoeken
- Test inhoudsfiltering met voorbeelden van verantwoord gebruik van AI

## Richtlijnen voor codestijl

### Java-conventies
- **Java-versie:** Java 21 met moderne functies
- **Stijl:** Volg standaard Java-conventies
- **Naamgeving:** 
  - Klassen: PascalCase
  - Methoden/variabelen: camelCase
  - Constanten: UPPER_SNAKE_CASE
  - Pakketnamen: kleine letters

### Spring Boot-patronen
- Gebruik `@Service` voor bedrijfslogica
- Gebruik `@RestController` voor REST-endpoints
- Configuratie via `application.yml` of `application.properties`
- Omgevingsvariabelen hebben de voorkeur boven hard-coded waarden
- Gebruik `@Tool`-annotatie voor MCP-methoden

### Bestandsorganisatie
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

### Afhankelijkheden
- Beheerd via Maven `pom.xml`
- Spring AI BOM voor versiebeheer
- LangChain4j voor AI-integraties
- Spring Boot starter parent voor Spring-afhankelijkheden

### Codecommentaar
- Voeg JavaDoc toe voor publieke API's
- Voeg verklarende opmerkingen toe voor complexe AI-interacties
- Documenteer MCP-toolbeschrijvingen duidelijk

## Build en implementatie

### Projecten bouwen

**Bouwen zonder tests:**
```bash
mvn clean install -DskipTests
```

**Bouwen met alle controles:**
```bash
mvn clean install
```

**Applicatie verpakken:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Outputmappen
- Gecompileerde klassen: `target/classes/`
- Testklassen: `target/test-classes/`
- JAR-bestanden: `target/*.jar`
- Maven-artifacten: `target/`

### Configuratie specifiek voor omgeving

**Ontwikkeling:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Productie:**
- Gebruik Azure AI Foundry Models in plaats van GitHub Models
- Update base-url naar Azure OpenAI endpoint
- Beheer geheimen via Azure Key Vault of omgevingsvariabelen

### Overwegingen bij implementatie
- Dit is een educatieve repository met voorbeeldapplicaties
- Niet ontworpen voor productie-implementatie zoals het is
- Voorbeelden demonstreren patronen om aan te passen voor productiegebruik
- Zie de README's van individuele projecten voor specifieke implementatienotities

## Aanvullende opmerkingen

### GitHub Models vs Azure OpenAI
- **GitHub Models:** Gratis niveau voor leren, geen creditcard nodig
- **Azure OpenAI:** Productieklaar, vereist Azure-abonnement
- Code is compatibel tussen beide - alleen endpoint en API-sleutel wijzigen

### Werken met meerdere projecten
Elk voorbeeldproject is zelfstandig:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Veelvoorkomende problemen

**Java-versiemismatch:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Problemen met afhankelijkheidsdownloads:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub-token niet gevonden:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Poort al in gebruik:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Meertalige ondersteuning
- Documentatie beschikbaar in meer dan 45 talen via automatische vertaling
- Vertalingen in de map `translations/`
- Vertaling beheerd door GitHub Actions workflow

### Leerpad
1. Begin met [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Volg de hoofdstukken in volgorde (01 → 05)
3. Voltooi praktische voorbeelden in elk hoofdstuk
4. Verken voorbeeldprojecten in hoofdstuk 4
5. Leer verantwoord gebruik van AI in hoofdstuk 5

### Ontwikkelcontainer
De `.devcontainer/devcontainer.json` configureert:
- Java 21 ontwikkelomgeving
- Maven vooraf geïnstalleerd
- VS Code Java-extensies
- Spring Boot-tools
- GitHub Copilot-integratie
- Docker-in-Docker ondersteuning
- Azure CLI

### Prestatieoverwegingen
- Gratis niveau van GitHub Models heeft limieten
- Gebruik geschikte batchgroottes voor embeddings
- Overweeg caching voor herhaalde API-aanroepen
- Monitor tokengebruik voor kostenoptimalisatie

### Beveiligingsnotities
- Commit nooit `.env`-bestanden (al opgenomen in `.gitignore`)
- Gebruik omgevingsvariabelen voor API-sleutels
- GitHub-tokens moeten minimale vereiste scopes hebben
- Volg richtlijnen voor verantwoord gebruik van AI in hoofdstuk 5

---

**Disclaimer**:  
Dit document is vertaald met behulp van de AI-vertalingsservice [Co-op Translator](https://github.com/Azure/co-op-translator). Hoewel we streven naar nauwkeurigheid, dient u zich ervan bewust te zijn dat geautomatiseerde vertalingen fouten of onnauwkeurigheden kunnen bevatten. Het originele document in de oorspronkelijke taal moet worden beschouwd als de gezaghebbende bron. Voor cruciale informatie wordt professionele menselijke vertaling aanbevolen. Wij zijn niet aansprakelijk voor misverstanden of verkeerde interpretaties die voortvloeien uit het gebruik van deze vertaling.