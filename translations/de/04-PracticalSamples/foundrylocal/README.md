# Foundry Local Spring Boot Tutorial

## Inhaltsverzeichnis

- [Voraussetzungen](#voraussetzungen)
- [Projektübersicht](#projektübersicht)
- [Verstehen des Codes](#verstehen-des-codes)
  - [1. Anwendungskonfiguration (application.properties)](#1-anwendungskonfiguration-applicationproperties)
  - [2. Hauptanwendungsklasse (Application.java)](#2-hauptanwendungsklasse-applicationjava)
  - [3. KI-Service-Schicht (FoundryLocalService.java)](#3-ki-service-schicht-foundrylocalservicejava)
  - [4. Projektabhängigkeiten (pom.xml)](#4-projektabhängigkeiten-pomxml)
- [Wie alles zusammenarbeitet](#wie-alles-zusammenarbeitet)
- [Einrichtung von Foundry Local](#einrichtung-von-foundry-local)
- [Ausführen der Anwendung](#ausführen-der-anwendung)
- [Erwartete Ausgabe](#erwartete-ausgabe)
- [Nächste Schritte](#nächste-schritte)
- [Fehlerbehebung](#fehlerbehebung)


## Voraussetzungen

Bevor Sie dieses Tutorial starten, stellen Sie sicher, dass Sie Folgendes haben:

- **Java 21 oder höher** auf Ihrem System installiert
- **Maven 3.6+** zum Bauen des Projekts
- **Foundry Local** installiert und ausgeführt

### **Foundry Local installieren:**

> **Hinweis:** Foundry Local CLI ist nur auf **Windows** und **macOS** verfügbar. Linux wird über die [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust) unterstützt.

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Installation überprüfen:
```bash
foundry --version
```

## Projektübersicht

Dieses Projekt besteht aus vier Hauptkomponenten:

1. **Application.java** - Der Haupteinstiegspunkt der Spring Boot Anwendung
2. **FoundryLocalService.java** - Service-Schicht, die die KI-Kommunikation handhabt
3. **application.properties** - Konfiguration für die Foundry Local Verbindung
4. **pom.xml** - Maven-Abhängigkeiten und Projektkonfiguration

## Verstehen des Codes

### 1. Anwendungskonfiguration (application.properties)

**Datei:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Was das bewirkt:**
- **base-url**: Gibt an, wo Foundry Local läuft, inklusive des `/v1` Pfades zur Kompatibilität mit der OpenAI API. Der Standardport ist `5273`. Wenn der Port abweicht, prüfen Sie ihn mit `foundry service status`.
- **model** (optional): Gibt den Namen des KI-Modells an, das für die Textgenerierung verwendet wird. **Standardmäßig erkennt die Anwendung das Modell selbst**, indem sie beim Start den Foundry Local `/v1/models` Endpunkt abfragt, daher müssen Sie dies nicht setzen. Sie können es dennoch explizit setzen, um die automatische Erkennung zu überschreiben, falls nötig.

**Wichtig:** Spring Boot lädt diese Eigenschaften automatisch und stellt sie der Anwendung über die `@Value` Annotation zur Verfügung.

### 2. Hauptanwendungsklasse (Application.java)

**Datei:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Kein Webserver erforderlich
        app.run(args);
    }
```

**Was das bewirkt:**
- `@SpringBootApplication` aktiviert die automatische Spring Boot-Konfiguration
- `WebApplicationType.NONE` sagt Spring, dass dies eine Kommandozeilenanwendung und kein Webserver ist
- Die main-Methode startet die Spring-Anwendung

**Der Demo-Runner:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        System.out.println("Calling Foundry Local service...");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
        System.out.println("=========================");
    };
}
```

**Was das bewirkt:**
- `@Bean` erstellt eine Komponente, die Spring verwaltet
- `CommandLineRunner` führt Code aus, nachdem Spring Boot gestartet wurde
- `foundryLocalService` wird von Spring automatisch injiziert (Dependency Injection)
- Sendet eine Testnachricht an die KI und zeigt die Antwort an

### 3. KI-Service-Schicht (FoundryLocalService.java)

**Datei:** `src/main/java/com/example/FoundryLocalService.java`

#### Konfigurationsinjektion:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Automatisch erkannt, wenn leer
```

**Was das bewirkt:**
- `@Service` sagt Spring, dass diese Klasse Geschäftslogik bereitstellt
- `@Value` injiziert Konfigurationswerte aus application.properties
- Das Modell ist standardmäßig leer, wodurch die **auto-Erkennung** von Foundry Local beim Start ausgelöst wird. Das bedeutet, die App funktioniert mit jedem Modell, das im Foundry Local geladen ist, ohne manuelle Konfiguration.

#### Client-Initialisierung:
```java
@PostConstruct
public void init() {
    // Modell automatisch von Foundry Local erkennen, wenn nicht explizit konfiguriert
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Basis-URL enthält bereits /v1 aus der Konfiguration
            .apiKey("not-needed")            // Lokaler Server benötigt keinen echten API-Schlüssel
            .build();
}
```

**Was das bewirkt:**
- `@PostConstruct` führt diese Methode aus, nachdem Spring den Service erstellt hat
- Wenn kein Modell konfiguriert ist, fragt es den Foundry Local `/v1/models` Endpunkt ab und wählt das erste geladene Modell aus
- Erstellt einen OpenAI-Client, der auf Ihre lokale Foundry Local Instanz zeigt
- Die Basis-URL aus `application.properties` enthält bereits `/v1` für OpenAI API-Kompatibilität
- Der API-Schlüssel ist auf "not-needed" gesetzt, weil die lokale Entwicklung keine Authentifizierung erfordert

#### Chat-Methode:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Welches KI-Modell verwendet werden soll
                .addUserMessage(message)         // Ihre Frage/Aufforderung
                .maxCompletionTokens(150)        // Antwortlänge begrenzen
                .temperature(0.7)                // Kreativität steuern (0,0-1,0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Die Antwort der KI aus dem API-Ergebnis extrahieren
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Was das bewirkt:**
- **ChatCompletionCreateParams**: Konfiguriert die KI-Anfrage
  - `model`: Gibt das zu verwendende KI-Modell an (muss mit der genauen ID aus `foundry model list` übereinstimmen)
  - `addUserMessage`: Fügt Ihre Nachricht zur Unterhaltung hinzu
  - `maxCompletionTokens`: Begrenzung der Antwortlänge (spart Ressourcen)
  - `temperature`: Steuert die Zufälligkeit (0.0 = deterministisch, 1.0 = kreativ)
- **API Aufruf**: Sendet die Anfrage an Foundry Local
- **Antwortverarbeitung**: Extrahiert die Textantwort der KI sicher
- **Fehlerbehandlung**: Verpackt Ausnahmen mit hilfreichen Fehlermeldungen

### 4. Projektabhängigkeiten (pom.xml)

**Wichtige Abhängigkeiten:**

```xml
<!-- Spring Boot - Application framework -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>${spring-boot.version}</version>
</dependency>

<!-- OpenAI Java SDK - For AI API calls -->
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>

<!-- Jackson - JSON processing -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.0</version>
</dependency>
```

**Was diese bewirken:**
- **spring-boot-starter**: Liefert die Kernfunktionalität von Spring Boot
- **openai-java**: Offizielles OpenAI Java SDK für API-Kommunikation
- **jackson-databind**: Handhabt JSON-Serialisierung/-Deserialisierung für API-Aufrufe

## Wie alles zusammenarbeitet

Hier ist der komplette Ablauf beim Ausführen der Anwendung:

1. **Start**: Spring Boot startet und liest `application.properties`
2. **Service-Erstellung**: Spring erstellt `FoundryLocalService` und injiziert Konfigurationswerte
3. **Modellerkennung**: Wenn kein Modell konfiguriert ist, fragt der Service den Foundry Local `/v1/models` Endpunkt ab und verwendet automatisch das erste verfügbare Modell
4. **Client-Setup**: `@PostConstruct` initialisiert den OpenAI-Client zur Verbindung mit Foundry Local
5. **Demo-Ausführung**: `CommandLineRunner` wird nach dem Start ausgeführt
6. **KI-Aufruf**: Die Demo ruft `foundryLocalService.chat()` mit einer Testnachricht auf
7. **API-Anfrage**: Der Service baut eine OpenAI-kompatible Anfrage an Foundry Local
8. **Antwortverarbeitung**: Der Service extrahiert und gibt die Antwort der KI zurück
9. **Ausgabe**: Anwendung gibt die Antwort aus und beendet sich

## Einrichtung von Foundry Local

1. **Foundry Local installieren** mit den Anweisungen aus dem Abschnitt [Voraussetzungen](#voraussetzungen).

2. **Dienst starten** (falls nicht bereits ausgeführt):
   ```bash
   foundry service start
   ```

3. **Dienststatus prüfen**, um sicherzustellen, dass er läuft, und den Port notieren:
   ```bash
   foundry service status
   ```

4. **Modell herunterladen und ausführen** (wird beim ersten Lauf heruntergeladen, für nachfolgende Läufe im Cache gehalten):
   ```bash
   foundry model run phi-4-mini
   ```
   Dies öffnet eine interaktive Chat-Sitzung. Sie können diese mit `Ctrl+C` beenden. Das Modell bleibt im Dienst geladen.

   > **Tipp:** Führen Sie `foundry model list` aus, um alle verfügbaren Modelle zu sehen. Ersetzen Sie `phi-4-mini` durch einen beliebigen Alias aus dem Katalog (z.B. `qwen2.5-0.5b` für ein kleineres/schnelleres Modell).

5. **Überprüfen, ob das Modell geladen ist:**
   ```bash
   foundry service ps
   ```

6. **`application.properties` bei Bedarf aktualisieren:**
   - Der Standard-`base-url` (`http://localhost:5273/v1`) entspricht dem Standardport der CLI. Nur aktualisieren, wenn `foundry service status` einen anderen Port zeigt.
   - Das Modell wird **automatisch beim Start erkannt** — keine Konfiguration nötig.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Ausführen der Anwendung

### Schritt 1: Sicherstellen, dass ein Modell in Foundry Local geladen ist
```bash
foundry service ps
```
Wenn keine Modelle gelistet sind, laden Sie eins:
```bash
foundry model run phi-4-mini
```

### Schritt 2: Anwendung bauen und ausführen
In einem separaten Terminal:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Oder als JAR bauen und ausführen:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Erwartete Ausgabe

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## Nächste Schritte

Für weitere Beispiele siehe [Kapitel 04: Praktische Beispiele](../README.md)

## Fehlerbehebung

### Häufige Probleme

**"Connection refused" oder "Service unavailable"**
- Dienststatus prüfen: `foundry service status`
- Falls nötig neu starten: `foundry service restart`
- Prüfen, ob der Port in `application.properties` mit dem Ausgabeport von `foundry service status` übereinstimmt
- Sicherstellen, dass die URL mit `/v1` endet: `http://localhost:5273/v1`

**"Kein Modell gefunden" beim Start**
- Die Anwendung erkennt das Modell automatisch. Stellen Sie sicher, dass mindestens ein Modell geladen ist: `foundry service ps`
- Wenn keine Modelle geladen sind: `foundry model run phi-4-mini`
- Wenn Sie den Modellnamen in `application.properties` überschrieben haben, prüfen Sie, ob er mit `foundry model list` übereinstimmt

**"400 Bad Request" Fehler**
- Prüfen, ob die Basis-URL `/v1` enthält: `http://localhost:5273/v1`
- Stellen Sie sicher, dass Sie in Ihrem Code `maxCompletionTokens()` verwenden (nicht das veraltete `maxTokens()`)

**Maven-Kompilierungsfehler**
- Stellen Sie sicher, dass Java 21 oder höher installiert ist: `java -version`
- Bereinigen und neu kompilieren: `mvn clean compile`
- Prüfen Sie die Internetverbindung für das Herunterladen von Abhängigkeiten

**Probleme mit Dienstverbindung**
- Wenn Sie `Request to local service failed` sehen, führen Sie aus: `foundry service restart`
- Geladene Modelle prüfen: `foundry service ps`
- Dienstprotokolle anzeigen: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Haftungsausschluss**:  
Dieses Dokument wurde mit dem KI-Übersetzungsdienst [Co-op Translator](https://github.com/Azure/co-op-translator) übersetzt. Obwohl wir uns um Genauigkeit bemühen, beachten Sie bitte, dass automatisierte Übersetzungen Fehler oder Ungenauigkeiten enthalten können. Das Originaldokument in seiner ursprünglichen Sprache gilt als maßgebliche Quelle. Für wichtige Informationen wird eine professionelle menschliche Übersetzung empfohlen. Wir übernehmen keine Haftung für Missverständnisse oder Fehlinterpretationen, die aus der Nutzung dieser Übersetzung entstehen.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->