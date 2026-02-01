# AGENTS.md

## Projektübersicht

Dies ist ein Bildungs-Repository zum Erlernen der Entwicklung von Generativer KI mit Java. Es bietet einen umfassenden praktischen Kurs, der Large Language Models (LLMs), Prompt Engineering, Embeddings, RAG (Retrieval-Augmented Generation) und das Model Context Protocol (MCP) abdeckt.

**Wichtige Technologien:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI und OpenAI SDKs

**Architektur:**
- Mehrere eigenständige Spring Boot-Anwendungen, organisiert nach Kapiteln
- Beispielprojekte, die verschiedene KI-Muster demonstrieren
- GitHub Codespaces-fähig mit vorkonfigurierten Entwicklungscontainern

## Setup-Befehle

### Voraussetzungen
- Java 21 oder höher
- Maven 3.x
- GitHub-Personalzugriffstoken (für GitHub Models)
- Optional: Azure OpenAI-Zugangsdaten

### Umgebungseinrichtung

**Option 1: GitHub Codespaces (Empfohlen)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Option 2: Lokaler Entwicklungscontainer**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Option 3: Lokale Einrichtung**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Konfiguration

**GitHub-Token-Einrichtung:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI-Einrichtung (Optional):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Entwicklungsworkflow

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

### Anwendungen ausführen

**Eine Spring Boot-Anwendung ausführen:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Ein Projekt bauen:**
```bash
cd [project-directory]
mvn clean install
```

**MCP Calculator Server starten:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Client-Beispiele ausführen:**
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
Spring Boot DevTools ist in Projekten enthalten, die Hot Reload unterstützen:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Testanweisungen

### Tests ausführen

**Alle Tests in einem Projekt ausführen:**
```bash
cd [project-directory]
mvn test
```

**Tests mit ausführlicher Ausgabe ausführen:**
```bash
mvn test -X
```

**Spezifische Testklasse ausführen:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Teststruktur
- Testdateien verwenden JUnit 5 (Jupiter)
- Testklassen befinden sich in `src/test/java/`
- Client-Beispiele im Calculator-Projekt befinden sich in `src/test/java/com/microsoft/mcp/sample/client/`

### Manuelles Testen
Viele Beispiele sind interaktive Anwendungen, die manuelles Testen erfordern:

1. Anwendung mit `mvn spring-boot:run` starten
2. Endpunkte testen oder mit der CLI interagieren
3. Überprüfen, ob das erwartete Verhalten der Dokumentation in der README.md jedes Projekts entspricht

### Testen mit GitHub Models
- Einschränkungen des kostenlosen Tarifs: 15 Anfragen/Minute, 150/Tag
- Maximal 5 gleichzeitige Anfragen
- Testen der Inhaltsfilterung mit verantwortungsvollen KI-Beispielen

## Richtlinien für Code-Stil

### Java-Konventionen
- **Java-Version:** Java 21 mit modernen Features
- **Stil:** Standard-Java-Konventionen folgen
- **Benennung:** 
  - Klassen: PascalCase
  - Methoden/Variablen: camelCase
  - Konstanten: UPPER_SNAKE_CASE
  - Paketnamen: kleingeschrieben

### Spring Boot-Muster
- Verwenden Sie `@Service` für Geschäftslogik
- Verwenden Sie `@RestController` für REST-Endpunkte
- Konfiguration über `application.yml` oder `application.properties`
- Umgebungsvariablen bevorzugt gegenüber fest codierten Werten
- Verwenden Sie `@Tool`-Annotation für MCP-exponierte Methoden

### Dateiorganisation
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

### Abhängigkeiten
- Verwaltet über Maven `pom.xml`
- Spring AI BOM für Versionsverwaltung
- LangChain4j für KI-Integrationen
- Spring Boot Starter Parent für Spring-Abhängigkeiten

### Code-Kommentare
- JavaDoc für öffentliche APIs hinzufügen
- Erklärende Kommentare für komplexe KI-Interaktionen einfügen
- MCP-Tool-Beschreibungen klar dokumentieren

## Build und Deployment

### Projekte bauen

**Build ohne Tests:**
```bash
mvn clean install -DskipTests
```

**Build mit allen Checks:**
```bash
mvn clean install
```

**Anwendung paketieren:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Ausgabeverzeichnisse
- Kompilierte Klassen: `target/classes/`
- Testklassen: `target/test-classes/`
- JAR-Dateien: `target/*.jar`
- Maven-Artefakte: `target/`

### Umgebungsspezifische Konfiguration

**Entwicklung:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Produktion:**
- Verwenden Sie Azure AI Foundry Models anstelle von GitHub Models
- Basis-URL auf Azure OpenAI-Endpunkt aktualisieren
- Geheimnisse über Azure Key Vault oder Umgebungsvariablen verwalten

### Deployment-Überlegungen
- Dies ist ein Bildungs-Repository mit Beispielanwendungen
- Nicht für den Produktionseinsatz in der aktuellen Form konzipiert
- Beispiele demonstrieren Muster, die für den Produktionseinsatz angepasst werden können
- Siehe die README-Dateien der einzelnen Projekte für spezifische Deployment-Hinweise

## Zusätzliche Hinweise

### GitHub Models vs Azure OpenAI
- **GitHub Models:** Kostenloser Tarif für Lernzwecke, keine Kreditkarte erforderlich
- **Azure OpenAI:** Produktionsbereit, erfordert Azure-Abonnement
- Code ist zwischen beiden kompatibel - einfach Endpunkt und API-Schlüssel ändern

### Arbeiten mit mehreren Projekten
Jedes Beispielprojekt ist eigenständig:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Häufige Probleme

**Java-Version stimmt nicht überein:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Probleme beim Herunterladen von Abhängigkeiten:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub-Token nicht gefunden:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Port bereits in Verwendung:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Mehrsprachige Unterstützung
- Dokumentation in über 45 Sprachen verfügbar durch automatische Übersetzung
- Übersetzungen im Verzeichnis `translations/`
- Übersetzung wird durch GitHub Actions Workflow verwaltet

### Lernpfad
1. Beginnen Sie mit [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Folgen Sie den Kapiteln in der Reihenfolge (01 → 05)
3. Schließen Sie die praktischen Beispiele in jedem Kapitel ab
4. Erkunden Sie die Beispielprojekte in Kapitel 4
5. Lernen Sie verantwortungsvolle KI-Praktiken in Kapitel 5

### Entwicklungscontainer
Die `.devcontainer/devcontainer.json` konfiguriert:
- Java 21 Entwicklungsumgebung
- Maven vorinstalliert
- VS Code Java-Erweiterungen
- Spring Boot-Tools
- GitHub Copilot-Integration
- Docker-in-Docker-Unterstützung
- Azure CLI

### Leistungsüberlegungen
- GitHub Models kostenloser Tarif hat Ratenbegrenzungen
- Verwenden Sie geeignete Batch-Größen für Embeddings
- Ziehen Sie Caching für wiederholte API-Aufrufe in Betracht
- Überwachen Sie die Token-Nutzung zur Kostenoptimierung

### Sicherheitshinweise
- `.env`-Dateien niemals committen (bereits in `.gitignore`)
- Umgebungsvariablen für API-Schlüssel verwenden
- GitHub-Tokens sollten minimale erforderliche Berechtigungen haben
- Verantwortungsvolle KI-Richtlinien in Kapitel 5 befolgen

---

**Haftungsausschluss**:  
Dieses Dokument wurde mit dem KI-Übersetzungsdienst [Co-op Translator](https://github.com/Azure/co-op-translator) übersetzt. Obwohl wir uns um Genauigkeit bemühen, beachten Sie bitte, dass automatisierte Übersetzungen Fehler oder Ungenauigkeiten enthalten können. Das Originaldokument in seiner ursprünglichen Sprache sollte als maßgebliche Quelle betrachtet werden. Für kritische Informationen wird eine professionelle menschliche Übersetzung empfohlen. Wir übernehmen keine Haftung für Missverständnisse oder Fehlinterpretationen, die sich aus der Nutzung dieser Übersetzung ergeben.