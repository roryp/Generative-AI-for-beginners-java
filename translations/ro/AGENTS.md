# AGENTS.md

## Prezentare Generală a Proiectului

Acesta este un depozit educațional pentru învățarea dezvoltării AI Generative cu Java. Oferă un curs practic cuprinzător care acoperă Modele de Limbaj Extins (LLMs), ingineria prompturilor, embeddings, RAG (Generare Augmentată prin Recuperare) și Protocolul de Context al Modelului (MCP).

**Tehnologii Cheie:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- Modele GitHub, Azure OpenAI și SDK-uri OpenAI

**Arhitectură:**
- Mai multe aplicații Spring Boot independente organizate pe capitole
- Proiecte exemplu care demonstrează diferite modele AI
- Pregătit pentru GitHub Codespaces cu containere de dezvoltare preconfigurate

## Comenzi de Configurare

### Cerințe Prealabile
- Java 21 sau mai recent
- Maven 3.x
- Token de acces personal GitHub (pentru Modele GitHub)
- Opțional: Credențiale Azure OpenAI

### Configurarea Mediului

**Opțiunea 1: GitHub Codespaces (Recomandat)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Opțiunea 2: Container Local de Dezvoltare**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Opțiunea 3: Configurare Locală**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Configurare

**Configurarea Tokenului GitHub:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Configurarea Azure OpenAI (Opțional):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Flux de Lucru în Dezvoltare

### Structura Proiectului
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

### Rularea Aplicațiilor

**Rularea unei aplicații Spring Boot:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Construirea unui proiect:**
```bash
cd [project-directory]
mvn clean install
```

**Pornirea Serverului MCP Calculator:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Rularea Exemplelor Client:**
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

### Reîncărcare Automată
Spring Boot DevTools este inclus în proiectele care suportă reîncărcarea automată:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Instrucțiuni de Testare

### Rularea Testelor

**Rularea tuturor testelor dintr-un proiect:**
```bash
cd [project-directory]
mvn test
```

**Rularea testelor cu ieșire detaliată:**
```bash
mvn test -X
```

**Rularea unei clase de test specifică:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Structura Testelor
- Fișierele de test utilizează JUnit 5 (Jupiter)
- Clasele de test se află în `src/test/java/`
- Exemplele client din proiectul calculatorului sunt în `src/test/java/com/microsoft/mcp/sample/client/`

### Testare Manuală
Multe exemple sunt aplicații interactive care necesită testare manuală:

1. Porniți aplicația cu `mvn spring-boot:run`
2. Testați punctele de acces sau interacționați cu CLI
3. Verificați dacă comportamentul așteptat corespunde documentației din README.md-ul fiecărui proiect

### Testare cu Modele GitHub
- Limite ale nivelului gratuit: 15 cereri/minut, 150/zi
- Maximum 5 cereri simultane
- Testați filtrarea conținutului cu exemple de AI responsabil

## Ghiduri de Stil pentru Cod

### Convenții Java
- **Versiune Java:** Java 21 cu funcționalități moderne
- **Stil:** Urmați convențiile standard Java
- **Denumire:** 
  - Clase: PascalCase
  - Metode/variabile: camelCase
  - Constante: UPPER_SNAKE_CASE
  - Nume pachete: litere mici

### Modele Spring Boot
- Utilizați `@Service` pentru logica de afaceri
- Utilizați `@RestController` pentru punctele de acces REST
- Configurare prin `application.yml` sau `application.properties`
- Variabilele de mediu sunt preferate în locul valorilor hard-coded
- Utilizați adnotarea `@Tool` pentru metodele expuse MCP

### Organizarea Fișierelor
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

### Dependențe
- Gestionate prin Maven `pom.xml`
- BOM Spring AI pentru gestionarea versiunilor
- LangChain4j pentru integrarea AI
- Starter parent Spring Boot pentru dependențele Spring

### Comentarii în Cod
- Adăugați JavaDoc pentru API-urile publice
- Includeți comentarii explicative pentru interacțiunile complexe AI
- Documentați clar descrierile instrumentelor MCP

## Construire și Implementare

### Construirea Proiectelor

**Construire fără teste:**
```bash
mvn clean install -DskipTests
```

**Construire cu toate verificările:**
```bash
mvn clean install
```

**Ambalarea aplicației:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Directoare de Ieșire
- Clase compilate: `target/classes/`
- Clase de test: `target/test-classes/`
- Fișiere JAR: `target/*.jar`
- Artefacte Maven: `target/`

### Configurare Specifică Mediului

**Dezvoltare:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Producție:**
- Utilizați Modele Azure AI Foundry în loc de Modele GitHub
- Actualizați baza-url la punctul de acces Azure OpenAI
- Gestionați secretele prin Azure Key Vault sau variabile de mediu

### Considerații de Implementare
- Acesta este un depozit educațional cu aplicații exemplu
- Nu este proiectat pentru implementare în producție așa cum este
- Exemplele demonstrează modele care pot fi adaptate pentru utilizare în producție
- Consultați README.md-urile proiectelor individuale pentru note specifice de implementare

## Note Suplimentare

### Modele GitHub vs Azure OpenAI
- **Modele GitHub:** Nivel gratuit pentru învățare, fără necesitatea unui card de credit
- **Azure OpenAI:** Pregătit pentru producție, necesită abonament Azure
- Codul este compatibil între ambele - doar schimbați punctul de acces și cheia API

### Lucrul cu Mai Multe Proiecte
Fiecare proiect exemplu este independent:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Probleme Comune

**Nepotrivire Versiune Java:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Probleme la Descărcarea Dependențelor:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**Token GitHub Nefondat:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Port Deja Utilizat:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Suport Multi-Limbă
- Documentație disponibilă în peste 45 de limbi prin traducere automată
- Traduceri în directorul `translations/`
- Traducerea gestionată prin fluxul de lucru GitHub Actions

### Parcurs de Învățare
1. Începeți cu [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Urmați capitolele în ordine (01 → 05)
3. Completați exemplele practice din fiecare capitol
4. Explorați proiectele exemplu din Capitolul 4
5. Învățați practici de AI responsabil în Capitolul 5

### Container de Dezvoltare
Fișierul `.devcontainer/devcontainer.json` configurează:
- Mediu de dezvoltare Java 21
- Maven preinstalat
- Extensii Java pentru VS Code
- Instrumente Spring Boot
- Integrare GitHub Copilot
- Suport Docker-in-Docker
- CLI Azure

### Considerații de Performanță
- Nivelul gratuit al Modelelor GitHub are limite de rată
- Utilizați dimensiuni adecvate pentru loturi la embeddings
- Luați în considerare caching-ul pentru apeluri API repetate
- Monitorizați utilizarea tokenurilor pentru optimizarea costurilor

### Note de Securitate
- Nu comiteți niciodată fișiere `.env` (deja în `.gitignore`)
- Utilizați variabile de mediu pentru cheile API
- Tokenurile GitHub ar trebui să aibă permisiuni minime necesare
- Urmați ghidurile de AI responsabil din Capitolul 5

---

**Declinare de responsabilitate**:  
Acest document a fost tradus folosind serviciul de traducere AI [Co-op Translator](https://github.com/Azure/co-op-translator). Deși ne străduim să asigurăm acuratețea, vă rugăm să fiți conștienți că traducerile automate pot conține erori sau inexactități. Documentul original în limba sa maternă ar trebui considerat sursa autoritară. Pentru informații critice, se recomandă traducerea profesională realizată de un specialist uman. Nu ne asumăm responsabilitatea pentru eventualele neînțelegeri sau interpretări greșite care pot apărea din utilizarea acestei traduceri.