<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:42:15+00:00",
  "source_file": "AGENTS.md",
  "language_code": "cs"
}
-->
# AGENTS.md

## Přehled projektu

Toto je vzdělávací repozitář určený k výuce vývoje Generativní AI pomocí Javy. Nabízí komplexní praktický kurz zahrnující velké jazykové modely (LLMs), návrh promptů, embeddings, RAG (Retrieval-Augmented Generation) a Model Context Protocol (MCP).

**Klíčové technologie:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI a OpenAI SDKs

**Architektura:**
- Více samostatných aplikací Spring Boot organizovaných podle kapitol
- Ukázkové projekty demonstrující různé AI vzory
- Připraveno pro GitHub Codespaces s předkonfigurovanými vývojovými kontejnery

## Příkazy pro nastavení

### Předpoklady
- Java 21 nebo vyšší
- Maven 3.x
- Osobní přístupový token GitHub (pro GitHub Models)
- Volitelné: Přihlašovací údaje Azure OpenAI

### Nastavení prostředí

**Možnost 1: GitHub Codespaces (doporučeno)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Možnost 2: Lokální vývojový kontejner**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Možnost 3: Lokální nastavení**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Konfigurace

**Nastavení tokenu GitHub:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Nastavení Azure OpenAI (volitelné):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Pracovní postup vývoje

### Struktura projektu
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

### Spouštění aplikací

**Spuštění aplikace Spring Boot:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Sestavení projektu:**
```bash
cd [project-directory]
mvn clean install
```

**Spuštění MCP Calculator Server:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Spuštění klientských příkladů:**
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
Spring Boot DevTools je zahrnut v projektech, které podporují hot reload:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Pokyny k testování

### Spouštění testů

**Spuštění všech testů v projektu:**
```bash
cd [project-directory]
mvn test
```

**Spuštění testů s podrobným výstupem:**
```bash
mvn test -X
```

**Spuštění konkrétní testovací třídy:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Struktura testů
- Testovací soubory používají JUnit 5 (Jupiter)
- Testovací třídy se nacházejí v `src/test/java/`
- Klientské příklady v projektu kalkulačky jsou v `src/test/java/com/microsoft/mcp/sample/client/`

### Manuální testování
Mnoho příkladů jsou interaktivní aplikace, které vyžadují manuální testování:

1. Spusťte aplikaci pomocí `mvn spring-boot:run`
2. Testujte endpointy nebo interagujte s CLI
3. Ověřte, zda očekávané chování odpovídá dokumentaci v README.md každého projektu

### Testování s GitHub Models
- Omezení bezplatné verze: 15 požadavků/minutu, 150/den
- Maximálně 5 současných požadavků
- Testujte filtrování obsahu pomocí příkladů odpovědné AI

## Pokyny ke stylu kódu

### Konvence v Javě
- **Verze Javy:** Java 21 s moderními funkcemi
- **Styl:** Dodržujte standardní konvence Javy
- **Pojmenování:** 
  - Třídy: PascalCase
  - Metody/proměnné: camelCase
  - Konstanty: UPPER_SNAKE_CASE
  - Názvy balíčků: malá písmena

### Vzory Spring Boot
- Používejte `@Service` pro obchodní logiku
- Používejte `@RestController` pro REST endpointy
- Konfigurace přes `application.yml` nebo `application.properties`
- Preferujte proměnné prostředí před pevně zakódovanými hodnotami
- Používejte anotaci `@Tool` pro metody vystavené MCP

### Organizace souborů
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
- Spravováno pomocí Maven `pom.xml`
- Spring AI BOM pro správu verzí
- LangChain4j pro AI integrace
- Spring Boot starter parent pro Spring závislosti

### Komentáře kódu
- Přidávejte JavaDoc pro veřejná API
- Zahrňte vysvětlující komentáře pro složité AI interakce
- Jasně dokumentujte popisy nástrojů MCP

## Sestavení a nasazení

### Sestavení projektů

**Sestavení bez testů:**
```bash
mvn clean install -DskipTests
```

**Sestavení se všemi kontrolami:**
```bash
mvn clean install
```

**Balíčkování aplikace:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Výstupní adresáře
- Kompilované třídy: `target/classes/`
- Testovací třídy: `target/test-classes/`
- JAR soubory: `target/*.jar`
- Maven artefakty: `target/`

### Konfigurace specifická pro prostředí

**Vývoj:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Produkce:**
- Používejte Azure AI Foundry Models místo GitHub Models
- Aktualizujte base-url na endpoint Azure OpenAI
- Spravujte tajné klíče pomocí Azure Key Vault nebo proměnných prostředí

### Úvahy o nasazení
- Toto je vzdělávací repozitář s ukázkovými aplikacemi
- Není navržen pro produkční nasazení v aktuální podobě
- Ukázky demonstrují vzory, které lze přizpůsobit pro produkční použití
- Viz README.md jednotlivých projektů pro konkrétní poznámky k nasazení

## Další poznámky

### GitHub Models vs Azure OpenAI
- **GitHub Models:** Bezplatná verze pro výuku, není vyžadována kreditní karta
- **Azure OpenAI:** Připraveno pro produkci, vyžaduje předplatné Azure
- Kód je kompatibilní s oběma - stačí změnit endpoint a API klíč

### Práce s více projekty
Každý ukázkový projekt je samostatný:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Běžné problémy

**Nesoulad verze Javy:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Problémy se stahováním závislostí:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**Token GitHub nebyl nalezen:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Port již používán:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Podpora více jazyků
- Dokumentace dostupná ve více než 45 jazycích prostřednictvím automatizovaného překladu
- Překlady v adresáři `translations/`
- Překlad spravován workflow GitHub Actions

### Vzdělávací cesta
1. Začněte s [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Postupujte podle kapitol v pořadí (01 → 05)
3. Dokončete praktické příklady v každé kapitole
4. Prozkoumejte ukázkové projekty ve 4. kapitole
5. Naučte se zásady odpovědné AI v 5. kapitole

### Vývojový kontejner
Konfigurace `.devcontainer/devcontainer.json` zahrnuje:
- Vývojové prostředí Java 21
- Předinstalovaný Maven
- Rozšíření Java pro VS Code
- Nástroje Spring Boot
- Integrace GitHub Copilot
- Podpora Docker-in-Docker
- Azure CLI

### Úvahy o výkonu
- Bezplatná verze GitHub Models má omezení rychlosti
- Používejte vhodné velikosti batchů pro embeddings
- Zvažte caching pro opakované API volání
- Sledujte využití tokenů pro optimalizaci nákladů

### Bezpečnostní poznámky
- Nikdy nekomitujte `.env` soubory (již v `.gitignore`)
- Používejte proměnné prostředí pro API klíče
- Tokeny GitHub by měly mít minimální požadované oprávnění
- Dodržujte zásady odpovědné AI v 5. kapitole

---

**Prohlášení**:  
Tento dokument byl přeložen pomocí služby AI pro překlady [Co-op Translator](https://github.com/Azure/co-op-translator). I když se snažíme o přesnost, mějte prosím na paměti, že automatizované překlady mohou obsahovat chyby nebo nepřesnosti. Původní dokument v jeho původním jazyce by měl být považován za autoritativní zdroj. Pro důležité informace doporučujeme profesionální lidský překlad. Neodpovídáme za žádná nedorozumění nebo nesprávné interpretace vyplývající z použití tohoto překladu.