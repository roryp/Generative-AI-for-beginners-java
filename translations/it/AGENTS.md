# AGENTS.md

## Panoramica del Progetto

Questo è un repository educativo per apprendere lo sviluppo di AI generativa con Java. Offre un corso pratico completo che copre i modelli di linguaggio di grandi dimensioni (LLMs), l'ingegneria dei prompt, gli embeddings, RAG (Retrieval-Augmented Generation) e il Model Context Protocol (MCP).

**Tecnologie Chiave:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- Modelli GitHub, Azure OpenAI e SDK OpenAI

**Architettura:**
- Applicazioni Spring Boot autonome organizzate per capitoli
- Progetti di esempio che dimostrano diversi pattern di AI
- Pronto per GitHub Codespaces con container di sviluppo preconfigurati

## Comandi di Configurazione

### Prerequisiti
- Java 21 o superiore
- Maven 3.x
- Token di accesso personale GitHub (per i modelli GitHub)
- Facoltativo: credenziali Azure OpenAI

### Configurazione dell'Ambiente

**Opzione 1: GitHub Codespaces (Consigliata)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Opzione 2: Container di Sviluppo Locale**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Opzione 3: Configurazione Locale**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Configurazione

**Configurazione del Token GitHub:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Configurazione Azure OpenAI (Facoltativa):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Flusso di Lavoro di Sviluppo

### Struttura del Progetto
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

### Esecuzione delle Applicazioni

**Esecuzione di un'applicazione Spring Boot:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Compilazione di un progetto:**
```bash
cd [project-directory]
mvn clean install
```

**Avvio del Server MCP Calculator:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Esecuzione di Esempi Client:**
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
Spring Boot DevTools è incluso nei progetti che supportano il ricaricamento automatico:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Istruzioni per il Testing

### Esecuzione dei Test

**Esegui tutti i test in un progetto:**
```bash
cd [project-directory]
mvn test
```

**Esegui i test con output dettagliato:**
```bash
mvn test -X
```

**Esegui una classe di test specifica:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Struttura dei Test
- I file di test utilizzano JUnit 5 (Jupiter)
- Le classi di test si trovano in `src/test/java/`
- Gli esempi client nel progetto del calcolatore si trovano in `src/test/java/com/microsoft/mcp/sample/client/`

### Testing Manuale
Molti esempi sono applicazioni interattive che richiedono test manuali:

1. Avvia l'applicazione con `mvn spring-boot:run`
2. Testa gli endpoint o interagisci con la CLI
3. Verifica che il comportamento previsto corrisponda alla documentazione nel README.md di ciascun progetto

### Testing con Modelli GitHub
- Limiti del piano gratuito: 15 richieste/minuto, 150/giorno
- Massimo 5 richieste simultanee
- Testa il filtraggio dei contenuti con esempi di AI responsabile

## Linee Guida per lo Stile del Codice

### Convenzioni Java
- **Versione Java:** Java 21 con funzionalità moderne
- **Stile:** Segui le convenzioni standard di Java
- **Nomenclatura:** 
  - Classi: PascalCase
  - Metodi/variabili: camelCase
  - Costanti: UPPER_SNAKE_CASE
  - Nomi dei pacchetti: minuscolo

### Pattern Spring Boot
- Usa `@Service` per la logica di business
- Usa `@RestController` per gli endpoint REST
- Configurazione tramite `application.yml` o `application.properties`
- Preferisci le variabili d'ambiente ai valori hard-coded
- Usa l'annotazione `@Tool` per i metodi esposti da MCP

### Organizzazione dei File
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

### Dipendenze
- Gestite tramite Maven `pom.xml`
- Spring AI BOM per la gestione delle versioni
- LangChain4j per le integrazioni AI
- Starter parent di Spring Boot per le dipendenze Spring

### Commenti nel Codice
- Aggiungi JavaDoc per le API pubbliche
- Includi commenti esplicativi per interazioni AI complesse
- Documenta chiaramente le descrizioni degli strumenti MCP

## Compilazione e Distribuzione

### Compilazione dei Progetti

**Compila senza test:**
```bash
mvn clean install -DskipTests
```

**Compila con tutti i controlli:**
```bash
mvn clean install
```

**Crea il pacchetto dell'applicazione:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Directory di Output
- Classi compilate: `target/classes/`
- Classi di test: `target/test-classes/`
- File JAR: `target/*.jar`
- Artifact Maven: `target/`

### Configurazione Specifica per l'Ambiente

**Sviluppo:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Produzione:**
- Usa i modelli Azure AI Foundry invece dei modelli GitHub
- Aggiorna la base-url all'endpoint Azure OpenAI
- Gestisci i segreti tramite Azure Key Vault o variabili d'ambiente

### Considerazioni sulla Distribuzione
- Questo è un repository educativo con applicazioni di esempio
- Non progettato per la distribuzione in produzione così com'è
- Gli esempi dimostrano pattern da adattare per l'uso in produzione
- Consulta i README dei singoli progetti per note specifiche sulla distribuzione

## Note Aggiuntive

### Modelli GitHub vs Azure OpenAI
- **Modelli GitHub:** Piano gratuito per l'apprendimento, non è richiesta la carta di credito
- **Azure OpenAI:** Pronto per la produzione, richiede un abbonamento Azure
- Il codice è compatibile con entrambi - basta cambiare endpoint e chiave API

### Lavorare con Progetti Multipli
Ogni progetto di esempio è autonomo:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Problemi Comuni

**Versione Java Non Corrispondente:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Problemi di Download delle Dipendenze:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**Token GitHub Non Trovato:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Porta Già in Uso:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Supporto Multilingue
- Documentazione disponibile in oltre 45 lingue tramite traduzione automatica
- Traduzioni nella directory `translations/`
- Traduzione gestita dal workflow GitHub Actions

### Percorso di Apprendimento
1. Inizia con [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Segui i capitoli in ordine (01 → 05)
3. Completa gli esempi pratici in ogni capitolo
4. Esplora i progetti di esempio nel Capitolo 4
5. Impara le pratiche di AI responsabile nel Capitolo 5

### Container di Sviluppo
Il file `.devcontainer/devcontainer.json` configura:
- Ambiente di sviluppo Java 21
- Maven preinstallato
- Estensioni Java per VS Code
- Strumenti Spring Boot
- Integrazione con GitHub Copilot
- Supporto Docker-in-Docker
- CLI Azure

### Considerazioni sulle Prestazioni
- Il piano gratuito dei modelli GitHub ha limiti di velocità
- Usa dimensioni di batch appropriate per gli embeddings
- Considera la cache per chiamate API ripetute
- Monitora l'uso dei token per ottimizzare i costi

### Note sulla Sicurezza
- Non commettere mai file `.env` (già in `.gitignore`)
- Usa variabili d'ambiente per le chiavi API
- I token GitHub dovrebbero avere ambiti minimi richiesti
- Segui le linee guida di AI responsabile nel Capitolo 5

---

**Disclaimer**:  
Questo documento è stato tradotto utilizzando il servizio di traduzione AI [Co-op Translator](https://github.com/Azure/co-op-translator). Sebbene ci impegniamo per garantire l'accuratezza, si prega di notare che le traduzioni automatiche possono contenere errori o imprecisioni. Il documento originale nella sua lingua nativa dovrebbe essere considerato la fonte autorevole. Per informazioni critiche, si raccomanda una traduzione professionale effettuata da un traduttore umano. Non siamo responsabili per eventuali incomprensioni o interpretazioni errate derivanti dall'uso di questa traduzione.