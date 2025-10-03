<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:42:44+00:00",
  "source_file": "AGENTS.md",
  "language_code": "sk"
}
-->
# AGENTS.md

## Prehľad projektu

Toto je vzdelávacie úložisko na učenie sa vývoja Generatívnej AI pomocou Javy. Poskytuje komplexný praktický kurz, ktorý pokrýva veľké jazykové modely (LLMs), návrh promptov, embeddings, RAG (Retrieval-Augmented Generation) a Model Context Protocol (MCP).

**Kľúčové technológie:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI a OpenAI SDKs

**Architektúra:**
- Viacero samostatných Spring Boot aplikácií organizovaných podľa kapitol
- Ukážkové projekty demonštrujúce rôzne AI vzory
- Pripravené na GitHub Codespaces s predkonfigurovanými vývojovými kontajnermi

## Príkazy na nastavenie

### Predpoklady
- Java 21 alebo vyššia
- Maven 3.x
- Osobný prístupový token GitHub (pre GitHub Models)
- Voliteľné: Azure OpenAI prihlasovacie údaje

### Nastavenie prostredia

**Možnosť 1: GitHub Codespaces (Odporúčané)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Možnosť 2: Lokálny vývojový kontajner**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Možnosť 3: Lokálne nastavenie**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Konfigurácia

**Nastavenie GitHub tokenu:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Nastavenie Azure OpenAI (voliteľné):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Pracovný postup vývoja

### Štruktúra projektu
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

### Spúšťanie aplikácií

**Spustenie Spring Boot aplikácie:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Zostavenie projektu:**
```bash
cd [project-directory]
mvn clean install
```

**Spustenie MCP kalkulačného servera:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Spustenie klientských príkladov:**
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
Spring Boot DevTools je zahrnutý v projektoch, ktoré podporujú hot reload:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Pokyny na testovanie

### Spúšťanie testov

**Spustenie všetkých testov v projekte:**
```bash
cd [project-directory]
mvn test
```

**Spustenie testov s podrobným výstupom:**
```bash
mvn test -X
```

**Spustenie konkrétnej testovacej triedy:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Štruktúra testov
- Testovacie súbory používajú JUnit 5 (Jupiter)
- Testovacie triedy sa nachádzajú v `src/test/java/`
- Klientské príklady v kalkulačnom projekte sú v `src/test/java/com/microsoft/mcp/sample/client/`

### Manuálne testovanie
Mnohé príklady sú interaktívne aplikácie, ktoré vyžadujú manuálne testovanie:

1. Spustite aplikáciu pomocou `mvn spring-boot:run`
2. Testujte endpointy alebo interagujte s CLI
3. Overte, či očakávané správanie zodpovedá dokumentácii v README.md každého projektu

### Testovanie s GitHub Models
- Obmedzenia bezplatného plánu: 15 požiadaviek/minúta, 150/deň
- Maximálne 5 súbežných požiadaviek
- Testujte filtrovanie obsahu s príkladmi zodpovednej AI

## Pokyny k štýlu kódu

### Konvencie pre Javu
- **Verzia Javy:** Java 21 s modernými funkciami
- **Štýl:** Dodržiavajte štandardné konvencie Javy
- **Názvoslovie:** 
  - Triedy: PascalCase
  - Metódy/premenné: camelCase
  - Konštanty: UPPER_SNAKE_CASE
  - Názvy balíkov: malé písmená

### Vzory Spring Boot
- Používajte `@Service` pre obchodnú logiku
- Používajte `@RestController` pre REST endpointy
- Konfigurácia cez `application.yml` alebo `application.properties`
- Preferujte environmentálne premenné pred pevne zakódovanými hodnotami
- Používajte anotáciu `@Tool` pre metódy vystavené MCP

### Organizácia súborov
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

### Závislosti
- Spravované cez Maven `pom.xml`
- Spring AI BOM na správu verzií
- LangChain4j pre AI integrácie
- Spring Boot starter parent pre Spring závislosti

### Komentáre kódu
- Pridajte JavaDoc pre verejné API
- Zahrňte vysvetľujúce komentáre pre komplexné AI interakcie
- Jasne dokumentujte popisy nástrojov MCP

## Zostavenie a nasadenie

### Zostavenie projektov

**Zostavenie bez testov:**
```bash
mvn clean install -DskipTests
```

**Zostavenie so všetkými kontrolami:**
```bash
mvn clean install
```

**Vytvorenie balíka aplikácie:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Výstupné adresáre
- Kompilované triedy: `target/classes/`
- Testovacie triedy: `target/test-classes/`
- JAR súbory: `target/*.jar`
- Maven artefakty: `target/`

### Konfigurácia špecifická pre prostredie

**Vývoj:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Produkcia:**
- Používajte Azure AI Foundry Models namiesto GitHub Models
- Aktualizujte base-url na Azure OpenAI endpoint
- Spravujte tajomstvá cez Azure Key Vault alebo environmentálne premenné

### Úvahy o nasadení
- Toto je vzdelávacie úložisko s ukážkovými aplikáciami
- Nie je navrhnuté na produkčné nasadenie ako také
- Ukážky demonštrujú vzory na prispôsobenie pre produkčné použitie
- Pozrite si README.md jednotlivých projektov pre konkrétne poznámky k nasadeniu

## Ďalšie poznámky

### GitHub Models vs Azure OpenAI
- **GitHub Models:** Bezplatný plán na učenie, nie je potrebná kreditná karta
- **Azure OpenAI:** Pripravené na produkciu, vyžaduje Azure predplatné
- Kód je kompatibilný medzi oboma - stačí zmeniť endpoint a API kľúč

### Práca s viacerými projektmi
Každý ukážkový projekt je samostatný:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Bežné problémy

**Nesúlad verzie Javy:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Problémy so sťahovaním závislostí:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub token nebol nájdený:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Port už používaný:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Podpora viacerých jazykov
- Dokumentácia dostupná vo viac ako 45 jazykoch cez automatizovaný preklad
- Preklady v adresári `translations/`
- Preklad spravovaný GitHub Actions workflow

### Učebná cesta
1. Začnite s [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Postupujte podľa kapitol v poradí (01 → 05)
3. Dokončite praktické príklady v každej kapitole
4. Preskúmajte ukážkové projekty v kapitole 4
5. Naučte sa praktiky zodpovednej AI v kapitole 5

### Vývojový kontajner
Konfigurácia `.devcontainer/devcontainer.json` obsahuje:
- Vývojové prostredie Java 21
- Predinštalovaný Maven
- Rozšírenia Java pre VS Code
- Nástroje Spring Boot
- Integráciu GitHub Copilot
- Podporu Docker-in-Docker
- Azure CLI

### Úvahy o výkone
- Bezplatný plán GitHub Models má obmedzenia rýchlosti
- Používajte vhodné veľkosti dávok pre embeddings
- Zvážte caching pre opakované API volania
- Monitorujte používanie tokenov na optimalizáciu nákladov

### Poznámky k bezpečnosti
- Nikdy nekomitujte súbory `.env` (už sú v `.gitignore`)
- Používajte environmentálne premenné pre API kľúče
- GitHub tokeny by mali mať minimálne požadované oprávnenia
- Dodržiavajte pokyny zodpovednej AI v kapitole 5

---

**Upozornenie**:  
Tento dokument bol preložený pomocou služby AI prekladu [Co-op Translator](https://github.com/Azure/co-op-translator). Hoci sa snažíme o presnosť, upozorňujeme, že automatizované preklady môžu obsahovať chyby alebo nepresnosti. Pôvodný dokument v jeho rodnom jazyku by mal byť považovaný za autoritatívny zdroj. Pre kritické informácie sa odporúča profesionálny ľudský preklad. Nenesieme zodpovednosť za akékoľvek nedorozumenia alebo nesprávne interpretácie vyplývajúce z použitia tohto prekladu.