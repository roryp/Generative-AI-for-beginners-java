<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:45:20+00:00",
  "source_file": "AGENTS.md",
  "language_code": "sl"
}
-->
# AGENTS.md

## Pregled projekta

To je izobraževalno skladišče za učenje razvoja generativne umetne inteligence z uporabo Jave. Ponuja celovit praktični tečaj, ki zajema velike jezikovne modele (LLM), oblikovanje pozivov, vdelave, RAG (pridobivanje z obogateno generacijo) in protokol konteksta modela (MCP).

**Ključne tehnologije:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI in OpenAI SDK-ji

**Arhitektura:**
- Več samostojnih aplikacij Spring Boot, organiziranih po poglavjih
- Vzorčni projekti, ki prikazujejo različne vzorce umetne inteligence
- Pripravljeno za GitHub Codespaces z vnaprej konfiguriranimi razvojnimi vsebniki

## Ukazi za nastavitev

### Predpogoji
- Java 21 ali novejša
- Maven 3.x
- Osebni dostopni žeton za GitHub (za GitHub Models)
- Opcijsko: Poverilnice za Azure OpenAI

### Nastavitev okolja

**Možnost 1: GitHub Codespaces (priporočeno)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Možnost 2: Lokalni razvojni vsebnik**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Možnost 3: Lokalna nastavitev**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Konfiguracija

**Nastavitev GitHub žetona:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Nastavitev Azure OpenAI (opcijsko):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Potek razvoja

### Struktura projekta
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

### Zagon aplikacij

**Zagon aplikacije Spring Boot:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Gradnja projekta:**
```bash
cd [project-directory]
mvn clean install
```

**Zagon MCP strežnika za kalkulator:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Zagon primerov odjemalca:**
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

### Hitro ponovno nalaganje
Spring Boot DevTools je vključen v projekte, ki podpirajo hitro ponovno nalaganje:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Navodila za testiranje

### Zagon testov

**Zagon vseh testov v projektu:**
```bash
cd [project-directory]
mvn test
```

**Zagon testov z obširnim izpisom:**
```bash
mvn test -X
```

**Zagon specifičnega razreda testov:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Struktura testov
- Testne datoteke uporabljajo JUnit 5 (Jupiter)
- Testni razredi se nahajajo v `src/test/java/`
- Primeri odjemalcev v projektu kalkulatorja so v `src/test/java/com/microsoft/mcp/sample/client/`

### Ročno testiranje
Veliko primerov so interaktivne aplikacije, ki zahtevajo ročno testiranje:

1. Zaženite aplikacijo z `mvn spring-boot:run`
2. Testirajte končne točke ali interaktivno uporabljajte CLI
3. Preverite, ali pričakovano vedenje ustreza dokumentaciji v README.md posameznega projekta

### Testiranje z GitHub Models
- Omejitve brezplačnega nivoja: 15 zahtevkov/minuto, 150/dan
- Največ 5 sočasnih zahtevkov
- Testirajte filtriranje vsebine z odgovornimi primeri umetne inteligence

## Smernice za slog kode

### Konvencije za Javo
- **Različica Jave:** Java 21 z modernimi funkcijami
- **Slog:** Upoštevajte standardne konvencije za Javo
- **Poimenovanje:** 
  - Razredi: PascalCase
  - Metode/spremenljivke: camelCase
  - Konstantne vrednosti: UPPER_SNAKE_CASE
  - Imena paketov: male črke

### Vzorci Spring Boot
- Uporabite `@Service` za poslovno logiko
- Uporabite `@RestController` za REST končne točke
- Konfiguracija prek `application.yml` ali `application.properties`
- Prednostno uporabite okoljske spremenljivke namesto trdo kodiranih vrednosti
- Uporabite `@Tool` anotacijo za metode, izpostavljene prek MCP

### Organizacija datotek
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

### Odvisnosti
- Upravljanje prek Maven `pom.xml`
- Spring AI BOM za upravljanje različic
- LangChain4j za integracije umetne inteligence
- Spring Boot starter parent za odvisnosti Spring

### Komentarji kode
- Dodajte JavaDoc za javne API-je
- Vključite pojasnjevalne komentarje za kompleksne interakcije umetne inteligence
- Jasno dokumentirajte opise orodij MCP

## Gradnja in uvajanje

### Gradnja projektov

**Gradnja brez testov:**
```bash
mvn clean install -DskipTests
```

**Gradnja z vsemi preverjanji:**
```bash
mvn clean install
```

**Pakiranje aplikacije:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Izhodne mape
- Prevedeni razredi: `target/classes/`
- Testni razredi: `target/test-classes/`
- JAR datoteke: `target/*.jar`
- Maven artefakti: `target/`

### Konfiguracija, specifična za okolje

**Razvoj:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Produkcija:**
- Uporabite Azure AI Foundry Models namesto GitHub Models
- Posodobite osnovni URL na Azure OpenAI končno točko
- Upravljajte skrivnosti prek Azure Key Vault ali okoljskih spremenljivk

### Upoštevanje pri uvajanju
- To je izobraževalno skladišče z vzorčnimi aplikacijami
- Ni zasnovano za produkcijsko uvajanje v trenutni obliki
- Vzorci prikazujejo vzorce, ki jih je mogoče prilagoditi za produkcijsko uporabo
- Glejte README.md posameznega projekta za specifične opombe o uvajanju

## Dodatne opombe

### GitHub Models proti Azure OpenAI
- **GitHub Models:** Brezplačni nivo za učenje, ni potrebna kreditna kartica
- **Azure OpenAI:** Pripravljeno za produkcijo, zahteva naročnino na Azure
- Koda je združljiva med obema - samo spremenite končno točko in API ključ

### Delo z več projekti
Vsak vzorčni projekt je samostojen:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Pogoste težave

**Neskladje različice Jave:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Težave pri prenosu odvisnosti:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub žeton ni najden:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Vrata so že v uporabi:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Podpora za več jezikov
- Dokumentacija je na voljo v več kot 45 jezikih prek avtomatiziranega prevajanja
- Prevedene datoteke so v mapi `translations/`
- Prevajanje upravlja GitHub Actions delovni tok

### Učna pot
1. Začnite z [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Sledite poglavjem po vrsti (01 → 05)
3. Izvedite praktične primere v vsakem poglavju
4. Raziščite vzorčne projekte v poglavju 4
5. Naučite se praks odgovorne umetne inteligence v poglavju 5

### Razvojni vsebnik
Konfiguracija `.devcontainer/devcontainer.json` vključuje:
- Razvojno okolje za Java 21
- Prednameščen Maven
- Razširitve za Javo v VS Code
- Orodja za Spring Boot
- Integracija GitHub Copilot
- Podpora za Docker-in-Docker
- Azure CLI

### Upoštevanje zmogljivosti
- Brezplačni nivo GitHub Models ima omejitve hitrosti
- Uporabite ustrezne velikosti paketov za vdelave
- Razmislite o predpomnjenju za ponavljajoče se API klice
- Spremljajte uporabo žetonov za optimizacijo stroškov

### Varnostne opombe
- Nikoli ne vključujte `.env` datotek (že v `.gitignore`)
- Uporabite okoljske spremenljivke za API ključe
- GitHub žetoni naj imajo minimalne potrebne obsege
- Upoštevajte smernice odgovorne umetne inteligence v poglavju 5

---

**Omejitev odgovornosti**:  
Ta dokument je bil preveden z uporabo storitve AI za prevajanje [Co-op Translator](https://github.com/Azure/co-op-translator). Čeprav si prizadevamo za natančnost, vas prosimo, da upoštevate, da lahko avtomatizirani prevodi vsebujejo napake ali netočnosti. Izvirni dokument v njegovem maternem jeziku je treba obravnavati kot avtoritativni vir. Za ključne informacije priporočamo profesionalni človeški prevod. Ne prevzemamo odgovornosti za morebitne nesporazume ali napačne razlage, ki bi nastale zaradi uporabe tega prevoda.