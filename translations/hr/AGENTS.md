# AGENTS.md

## Pregled projekta

Ovo je edukativni repozitorij za učenje razvoja Generativne AI tehnologije s Javom. Pruža sveobuhvatan praktični tečaj koji pokriva Velike Jezične Modele (LLMs), inženjering upita, ugrađivanja, RAG (Generacija uz podršku pretraživanja) i Protokol konteksta modela (MCP).

**Ključne tehnologije:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub modeli, Azure OpenAI i OpenAI SDK-ovi

**Arhitektura:**
- Više samostalnih Spring Boot aplikacija organiziranih po poglavljima
- Primjeri projekata koji demonstriraju različite AI obrasce
- Spremno za GitHub Codespaces s unaprijed konfiguriranim razvojnim kontejnerima

## Postavljanje okruženja

### Preduvjeti
- Java 21 ili novija
- Maven 3.x
- GitHub osobni pristupni token (za GitHub modele)
- Opcionalno: Azure OpenAI vjerodajnice

### Postavljanje okruženja

**Opcija 1: GitHub Codespaces (Preporučeno)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Opcija 2: Lokalni razvojni kontejner**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Opcija 3: Lokalno postavljanje**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Konfiguracija

**Postavljanje GitHub tokena:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Postavljanje Azure OpenAI (Opcionalno):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Radni tijek razvoja

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

### Pokretanje aplikacija

**Pokretanje Spring Boot aplikacije:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Izgradnja projekta:**
```bash
cd [project-directory]
mvn clean install
```

**Pokretanje MCP kalkulator servera:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Pokretanje primjera klijenta:**
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
Spring Boot DevTools uključen je u projekte koji podržavaju automatsko ponovno učitavanje:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Upute za testiranje

### Pokretanje testova

**Pokreni sve testove u projektu:**
```bash
cd [project-directory]
mvn test
```

**Pokreni testove s detaljnim izlazom:**
```bash
mvn test -X
```

**Pokreni određenu testnu klasu:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Struktura testova
- Testne datoteke koriste JUnit 5 (Jupiter)
- Testne klase nalaze se u `src/test/java/`
- Primjeri klijenata u projektu kalkulatora nalaze se u `src/test/java/com/microsoft/mcp/sample/client/`

### Ručno testiranje
Mnogi primjeri su interaktivne aplikacije koje zahtijevaju ručno testiranje:

1. Pokrenite aplikaciju s `mvn spring-boot:run`
2. Testirajte krajnje točke ili interaktivno koristite CLI
3. Provjerite odgovara li očekivano ponašanje dokumentaciji u README.md svakog projekta

### Testiranje s GitHub modelima
- Ograničenja besplatnog plana: 15 zahtjeva/minuti, 150/dan
- Maksimalno 5 istovremenih zahtjeva
- Testirajte filtriranje sadržaja s primjerima odgovorne AI

## Smjernice za stil koda

### Java konvencije
- **Java verzija:** Java 21 s modernim značajkama
- **Stil:** Slijedite standardne Java konvencije
- **Imenovanje:** 
  - Klase: PascalCase
  - Metode/varijable: camelCase
  - Konstante: UPPER_SNAKE_CASE
  - Nazivi paketa: mala slova

### Spring Boot obrasci
- Koristite `@Service` za poslovnu logiku
- Koristite `@RestController` za REST krajnje točke
- Konfiguracija putem `application.yml` ili `application.properties`
- Preferirajte varijable okruženja umjesto tvrdokodiranih vrijednosti
- Koristite `@Tool` anotaciju za metode izložene MCP-u

### Organizacija datoteka
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

### Ovisnosti
- Upravljanje putem Maven `pom.xml`
- Spring AI BOM za upravljanje verzijama
- LangChain4j za AI integracije
- Spring Boot starter parent za Spring ovisnosti

### Komentari u kodu
- Dodajte JavaDoc za javne API-je
- Uključite objašnjavajuće komentare za složene AI interakcije
- Jasno dokumentirajte opise MCP alata

## Izgradnja i implementacija

### Izgradnja projekata

**Izgradnja bez testova:**
```bash
mvn clean install -DskipTests
```

**Izgradnja sa svim provjerama:**
```bash
mvn clean install
```

**Pakiranje aplikacije:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Izlazni direktoriji
- Kompajlirane klase: `target/classes/`
- Testne klase: `target/test-classes/`
- JAR datoteke: `target/*.jar`
- Maven artefakti: `target/`

### Konfiguracija specifična za okruženje

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
- Koristite Azure AI Foundry modele umjesto GitHub modela
- Ažurirajte osnovni URL na Azure OpenAI krajnju točku
- Upravljajte tajnama putem Azure Key Vault ili varijabli okruženja

### Razmatranja za implementaciju
- Ovo je edukativni repozitorij s primjerima aplikacija
- Nije dizajniran za produkcijsku implementaciju u trenutnom obliku
- Primjeri demonstriraju obrasce za prilagodbu produkciji
- Pogledajte README.md pojedinih projekata za specifične bilješke o implementaciji

## Dodatne napomene

### GitHub modeli vs Azure OpenAI
- **GitHub modeli:** Besplatni plan za učenje, nije potrebna kreditna kartica
- **Azure OpenAI:** Spremno za produkciju, zahtijeva Azure pretplatu
- Kod je kompatibilan između oba - samo promijenite krajnju točku i API ključ

### Rad s više projekata
Svaki primjer projekta je samostalan:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Uobičajeni problemi

**Neusklađenost verzije Jave:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Problemi s preuzimanjem ovisnosti:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub token nije pronađen:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Port već u upotrebi:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Podrška za više jezika
- Dokumentacija dostupna na više od 45 jezika putem automatiziranog prijevoda
- Prijevodi u direktoriju `translations/`
- Prijevod upravljan GitHub Actions radnim tijekom

### Put učenja
1. Započnite s [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Slijedite poglavlja redoslijedom (01 → 05)
3. Dovršite praktične primjere u svakom poglavlju
4. Istražite primjere projekata u Poglavlju 4
5. Naučite prakse odgovorne AI u Poglavlju 5

### Razvojni kontejner
Konfiguracija `.devcontainer/devcontainer.json` uključuje:
- Razvojno okruženje za Java 21
- Unaprijed instaliran Maven
- VS Code Java ekstenzije
- Alati za Spring Boot
- Integracija GitHub Copilot
- Docker-in-Docker podrška
- Azure CLI

### Razmatranja performansi
- Besplatni plan GitHub modela ima ograničenja brzine
- Koristite odgovarajuće veličine serija za ugrađivanja
- Razmotrite predmemoriranje za ponovljene API pozive
- Pratite korištenje tokena za optimizaciju troškova

### Sigurnosne napomene
- Nikada ne komitirajte `.env` datoteke (već su u `.gitignore`)
- Koristite varijable okruženja za API ključeve
- GitHub tokeni trebaju imati minimalne potrebne dozvole
- Slijedite smjernice odgovorne AI u Poglavlju 5

---

**Odricanje od odgovornosti**:  
Ovaj dokument je preveden pomoću AI usluge za prevođenje [Co-op Translator](https://github.com/Azure/co-op-translator). Iako nastojimo osigurati točnost, imajte na umu da automatski prijevodi mogu sadržavati pogreške ili netočnosti. Izvorni dokument na izvornom jeziku treba smatrati autoritativnim izvorom. Za ključne informacije preporučuje se profesionalni prijevod od strane čovjeka. Ne preuzimamo odgovornost za nesporazume ili pogrešne interpretacije koje proizlaze iz korištenja ovog prijevoda.