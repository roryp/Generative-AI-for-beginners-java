<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:36:16+00:00",
  "source_file": "AGENTS.md",
  "language_code": "el"
}
-->
# AGENTS.md

## Επισκόπηση Έργου

Αυτό είναι ένα εκπαιδευτικό αποθετήριο για την εκμάθηση ανάπτυξης Γενετικής Τεχνητής Νοημοσύνης με Java. Παρέχει ένα ολοκληρωμένο πρακτικό μάθημα που καλύπτει Μεγάλα Γλωσσικά Μοντέλα (LLMs), σχεδιασμό προτροπών, ενσωματώσεις, RAG (Ανάκτηση-Ενισχυμένη Γενετική) και το Πρωτόκολλο Πλαισίου Μοντέλου (MCP).

**Βασικές Τεχνολογίες:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- Μοντέλα GitHub, Azure OpenAI και OpenAI SDKs

**Αρχιτεκτονική:**
- Πολλαπλές ανεξάρτητες εφαρμογές Spring Boot οργανωμένες ανά κεφάλαιο
- Δείγματα έργων που παρουσιάζουν διαφορετικά μοτίβα AI
- Έτοιμο για GitHub Codespaces με προρυθμισμένα δοχεία ανάπτυξης

## Εντολές Ρύθμισης

### Προαπαιτούμενα
- Java 21 ή νεότερη έκδοση
- Maven 3.x
- Προσωπικό διακριτικό πρόσβασης GitHub (για Μοντέλα GitHub)
- Προαιρετικά: Διαπιστευτήρια Azure OpenAI

### Ρύθμιση Περιβάλλοντος

**Επιλογή 1: GitHub Codespaces (Συνιστάται)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Επιλογή 2: Τοπικό Δοχείο Ανάπτυξης**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Επιλογή 3: Τοπική Ρύθμιση**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Διαμόρφωση

**Ρύθμιση Διακριτικού GitHub:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Ρύθμιση Azure OpenAI (Προαιρετικά):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Ροή Εργασίας Ανάπτυξης

### Δομή Έργου
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

### Εκτέλεση Εφαρμογών

**Εκτέλεση εφαρμογής Spring Boot:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Δημιουργία έργου:**
```bash
cd [project-directory]
mvn clean install
```

**Εκκίνηση του MCP Calculator Server:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Εκτέλεση Παραδειγμάτων Πελάτη:**
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
Το Spring Boot DevTools περιλαμβάνεται σε έργα που υποστηρίζουν hot reload:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Οδηγίες Δοκιμών

### Εκτέλεση Δοκιμών

**Εκτέλεση όλων των δοκιμών σε ένα έργο:**
```bash
cd [project-directory]
mvn test
```

**Εκτέλεση δοκιμών με λεπτομερή έξοδο:**
```bash
mvn test -X
```

**Εκτέλεση συγκεκριμένης κλάσης δοκιμής:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Δομή Δοκιμών
- Τα αρχεία δοκιμών χρησιμοποιούν JUnit 5 (Jupiter)
- Οι κλάσεις δοκιμών βρίσκονται στο `src/test/java/`
- Τα παραδείγματα πελάτη στο έργο υπολογιστή βρίσκονται στο `src/test/java/com/microsoft/mcp/sample/client/`

### Χειροκίνητη Δοκιμή
Πολλά παραδείγματα είναι διαδραστικές εφαρμογές που απαιτούν χειροκίνητη δοκιμή:

1. Ξεκινήστε την εφαρμογή με `mvn spring-boot:run`
2. Δοκιμάστε τα endpoints ή αλληλεπιδράστε με το CLI
3. Επαληθεύστε ότι η αναμενόμενη συμπεριφορά ταιριάζει με την τεκμηρίωση στο README.md κάθε έργου

### Δοκιμή με Μοντέλα GitHub
- Όρια δωρεάν χρήσης: 15 αιτήματα/λεπτό, 150/ημέρα
- Μέγιστο 5 ταυτόχρονα αιτήματα
- Δοκιμάστε φιλτράρισμα περιεχομένου με παραδείγματα υπεύθυνης AI

## Οδηγίες Στυλ Κώδικα

### Συμβάσεις Java
- **Έκδοση Java:** Java 21 με σύγχρονα χαρακτηριστικά
- **Στυλ:** Ακολουθήστε τις τυπικές συμβάσεις Java
- **Ονομασία:** 
  - Κλάσεις: PascalCase
  - Μέθοδοι/μεταβλητές: camelCase
  - Σταθερές: UPPER_SNAKE_CASE
  - Ονόματα πακέτων: πεζά

### Μοτίβα Spring Boot
- Χρησιμοποιήστε `@Service` για επιχειρησιακή λογική
- Χρησιμοποιήστε `@RestController` για REST endpoints
- Διαμόρφωση μέσω `application.yml` ή `application.properties`
- Προτιμώνται οι μεταβλητές περιβάλλοντος αντί για σκληροκωδικοποιημένες τιμές
- Χρησιμοποιήστε τον σχολιασμό `@Tool` για μεθόδους που εκτίθενται από MCP

### Οργάνωση Αρχείων
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

### Εξαρτήσεις
- Διαχειρίζονται μέσω Maven `pom.xml`
- Spring AI BOM για διαχείριση εκδόσεων
- LangChain4j για ενσωματώσεις AI
- Spring Boot starter parent για εξαρτήσεις Spring

### Σχόλια Κώδικα
- Προσθέστε JavaDoc για δημόσια APIs
- Συμπεριλάβετε επεξηγηματικά σχόλια για πολύπλοκες αλληλεπιδράσεις AI
- Τεκμηριώστε τις περιγραφές εργαλείων MCP με σαφήνεια

## Δημιουργία και Ανάπτυξη

### Δημιουργία Έργων

**Δημιουργία χωρίς δοκιμές:**
```bash
mvn clean install -DskipTests
```

**Δημιουργία με όλους τους ελέγχους:**
```bash
mvn clean install
```

**Πακετάρισμα εφαρμογής:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Κατάλογοι Εξόδου
- Συμπιεσμένες κλάσεις: `target/classes/`
- Κλάσεις δοκιμών: `target/test-classes/`
- Αρχεία JAR: `target/*.jar`
- Τεχνουργήματα Maven: `target/`

### Διαμόρφωση Ειδική για Περιβάλλον

**Ανάπτυξη:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Παραγωγή:**
- Χρησιμοποιήστε Μοντέλα Azure AI Foundry αντί για Μοντέλα GitHub
- Ενημερώστε το base-url στο endpoint Azure OpenAI
- Διαχειριστείτε μυστικά μέσω Azure Key Vault ή μεταβλητών περιβάλλοντος

### Σκέψεις Ανάπτυξης
- Αυτό είναι ένα εκπαιδευτικό αποθετήριο με δείγματα εφαρμογών
- Δεν έχει σχεδιαστεί για παραγωγική ανάπτυξη ως έχει
- Τα δείγματα παρουσιάζουν μοτίβα για προσαρμογή σε παραγωγική χρήση
- Δείτε τα README κάθε έργου για συγκεκριμένες σημειώσεις ανάπτυξης

## Πρόσθετες Σημειώσεις

### Μοντέλα GitHub vs Azure OpenAI
- **Μοντέλα GitHub:** Δωρεάν επίπεδο για εκμάθηση, χωρίς απαίτηση πιστωτικής κάρτας
- **Azure OpenAI:** Έτοιμο για παραγωγή, απαιτεί συνδρομή Azure
- Ο κώδικας είναι συμβατός και με τα δύο - απλώς αλλάξτε το endpoint και το API key

### Εργασία με Πολλαπλά Έργα
Κάθε δείγμα έργου είναι ανεξάρτητο:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Συνηθισμένα Προβλήματα

**Ασυμβατότητα Έκδοσης Java:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Προβλήματα Λήψης Εξαρτήσεων:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**Δεν Βρέθηκε Διακριτικό GitHub:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Θύρα Ήδη Χρησιμοποιείται:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Υποστήριξη Πολλαπλών Γλωσσών
- Τεκμηρίωση διαθέσιμη σε 45+ γλώσσες μέσω αυτοματοποιημένης μετάφρασης
- Μεταφράσεις στον κατάλογο `translations/`
- Η μετάφραση διαχειρίζεται από τη ροή εργασίας GitHub Actions

### Διαδρομή Εκμάθησης
1. Ξεκινήστε με [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Ακολουθήστε τα κεφάλαια με τη σειρά (01 → 05)
3. Ολοκληρώστε πρακτικά παραδείγματα σε κάθε κεφάλαιο
4. Εξερευνήστε δείγματα έργων στο Κεφάλαιο 4
5. Μάθετε πρακτικές υπεύθυνης AI στο Κεφάλαιο 5

### Δοχείο Ανάπτυξης
Το `.devcontainer/devcontainer.json` διαμορφώνει:
- Περιβάλλον ανάπτυξης Java 21
- Προεγκατεστημένο Maven
- Επεκτάσεις Java για VS Code
- Εργαλεία Spring Boot
- Ενσωμάτωση GitHub Copilot
- Υποστήριξη Docker-in-Docker
- Azure CLI

### Σκέψεις Απόδοσης
- Το δωρεάν επίπεδο των Μοντέλων GitHub έχει όρια ρυθμού
- Χρησιμοποιήστε κατάλληλα μεγέθη παρτίδας για ενσωματώσεις
- Εξετάστε την προσωρινή αποθήκευση για επαναλαμβανόμενες κλήσεις API
- Παρακολουθήστε τη χρήση token για βελτιστοποίηση κόστους

### Σημειώσεις Ασφαλείας
- Μην δεσμεύετε ποτέ αρχεία `.env` (ήδη στο `.gitignore`)
- Χρησιμοποιήστε μεταβλητές περιβάλλοντος για API keys
- Τα διακριτικά GitHub πρέπει να έχουν ελάχιστα απαιτούμενα πεδία
- Ακολουθήστε τις οδηγίες υπεύθυνης AI στο Κεφάλαιο 5

---

**Αποποίηση ευθύνης**:  
Αυτό το έγγραφο έχει μεταφραστεί χρησιμοποιώντας την υπηρεσία αυτόματης μετάφρασης [Co-op Translator](https://github.com/Azure/co-op-translator). Παρόλο που καταβάλλουμε προσπάθειες για ακρίβεια, παρακαλούμε να έχετε υπόψη ότι οι αυτόματες μεταφράσεις ενδέχεται να περιέχουν σφάλματα ή ανακρίβειες. Το πρωτότυπο έγγραφο στη μητρική του γλώσσα θα πρέπει να θεωρείται η αυθεντική πηγή. Για κρίσιμες πληροφορίες, συνιστάται επαγγελματική ανθρώπινη μετάφραση. Δεν φέρουμε ευθύνη για τυχόν παρεξηγήσεις ή εσφαλμένες ερμηνείες που προκύπτουν από τη χρήση αυτής της μετάφρασης.