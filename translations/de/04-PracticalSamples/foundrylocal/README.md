# Foundry Local Spring Boot Tutorial

## Inhaltsverzeichnis

- [Voraussetzungen](../../../../04-PracticalSamples/foundrylocal)
- [Projektübersicht](../../../../04-PracticalSamples/foundrylocal)
- [Code verstehen](../../../../04-PracticalSamples/foundrylocal)
  - [1. Anwendungskonfiguration (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Hauptanwendungsklasse (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI-Service-Schicht (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Projektabhängigkeiten (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Wie alles zusammen funktioniert](../../../../04-PracticalSamples/foundrylocal)
- [Foundry Local einrichten](../../../../04-PracticalSamples/foundrylocal)
- [Anwendung ausführen](../../../../04-PracticalSamples/foundrylocal)
- [Erwartete Ausgabe](../../../../04-PracticalSamples/foundrylocal)
- [Nächste Schritte](../../../../04-PracticalSamples/foundrylocal)
- [Fehlerbehebung](../../../../04-PracticalSamples/foundrylocal)

## Voraussetzungen

Bevor Sie mit diesem Tutorial beginnen, stellen Sie sicher, dass Sie Folgendes haben:

- **Java 21 oder höher** auf Ihrem System installiert
- **Maven 3.6+** zum Bauen des Projekts
- **Foundry Local** installiert und ausgeführt

### **Foundry Local installieren:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```


## Projektübersicht

Dieses Projekt besteht aus vier Hauptkomponenten:

1. **Application.java** - Der Einstiegspunkt der Spring Boot-Anwendung
2. **FoundryLocalService.java** - Service-Schicht, die die Kommunikation mit der KI übernimmt
3. **application.properties** - Konfiguration für die Verbindung zu Foundry Local
4. **pom.xml** - Maven-Abhängigkeiten und Projektkonfiguration

## Code verstehen

### 1. Anwendungskonfiguration (application.properties)

**Datei:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**Was das macht:**
- **base-url**: Gibt an, wo Foundry Local läuft, einschließlich des `/v1`-Pfads für die Kompatibilität mit der OpenAI-API. **Hinweis**: Foundry Local weist dynamisch einen Port zu, überprüfen Sie Ihren tatsächlichen Port mit `foundry service status`.
- **model**: Gibt den Namen des KI-Modells für die Textgenerierung an, einschließlich der Versionsnummer (z. B. `:1`). Verwenden Sie `foundry model list`, um verfügbare Modelle mit ihren genauen IDs zu sehen.

**Wichtiges Konzept:** Spring Boot lädt diese Eigenschaften automatisch und macht sie Ihrer Anwendung mit der `@Value`-Annotation zugänglich.

### 2. Hauptanwendungsklasse (Application.java)

**Datei:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```


**Was das macht:**
- `@SpringBootApplication` aktiviert die automatische Konfiguration von Spring Boot.
- `WebApplicationType.NONE` weist Spring an, dass es sich um eine Kommandozeilenanwendung und nicht um einen Webserver handelt.
- Die main-Methode startet die Spring-Anwendung.

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


**Was das macht:**
- `@Bean` erstellt eine Komponente, die von Spring verwaltet wird.
- `CommandLineRunner` führt Code aus, nachdem Spring Boot gestartet wurde.
- `foundryLocalService` wird von Spring automatisch injiziert (Dependency Injection).
- Sendet eine Testnachricht an die KI und zeigt die Antwort an.

### 3. AI-Service-Schicht (FoundryLocalService.java)

**Datei:** `src/main/java/com/example/FoundryLocalService.java`

#### Konfigurationsinjektion:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**Was das macht:**
- `@Service` zeigt an, dass diese Klasse Geschäftslogik bereitstellt.
- `@Value` injiziert Konfigurationswerte aus application.properties.
- Die Syntax `:default-value` bietet Standardwerte, falls Eigenschaften nicht gesetzt sind.

#### Client-Initialisierung:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```


**Was das macht:**
- `@PostConstruct` führt diese Methode aus, nachdem Spring den Service erstellt hat.
- Erstellt einen OpenAI-Client, der auf Ihre lokale Foundry Local-Instanz verweist.
- Die Basis-URL aus `application.properties` enthält bereits `/v1` für die Kompatibilität mit der OpenAI-API.
- Der API-Schlüssel wird auf "not-needed" gesetzt, da für die lokale Entwicklung keine Authentifizierung erforderlich ist.

#### Chat-Methode:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Which AI model to use
                .addUserMessage(message)         // Your question/prompt
                .maxCompletionTokens(150)        // Limit response length
                .temperature(0.7)                // Control creativity (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extract the AI's response from the API result
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```


**Was das macht:**
- **ChatCompletionCreateParams**: Konfiguriert die KI-Anfrage
  - `model`: Gibt an, welches KI-Modell verwendet werden soll (muss mit der genauen ID aus `foundry model list` übereinstimmen).
  - `addUserMessage`: Fügt Ihre Nachricht zur Konversation hinzu.
  - `maxCompletionTokens`: Begrenzt die Länge der Antwort (spart Ressourcen).
  - `temperature`: Steuert die Zufälligkeit (0.0 = deterministisch, 1.0 = kreativ).
- **API-Aufruf**: Sendet die Anfrage an Foundry Local.
- **Antwortverarbeitung**: Extrahiert sicher den Text der KI-Antwort.
- **Fehlerbehandlung**: Verpackt Ausnahmen mit hilfreichen Fehlermeldungen.

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


**Was diese machen:**
- **spring-boot-starter**: Bietet grundlegende Spring Boot-Funktionalität.
- **openai-java**: Offizielles OpenAI Java SDK für die API-Kommunikation.
- **jackson-databind**: Handhabt JSON-Serialisierung/Deserialisierung für API-Aufrufe.

## Wie alles zusammen funktioniert

Hier ist der vollständige Ablauf, wenn Sie die Anwendung ausführen:

1. **Start**: Spring Boot startet und liest `application.properties`.
2. **Service-Erstellung**: Spring erstellt `FoundryLocalService` und injiziert Konfigurationswerte.
3. **Client-Einrichtung**: `@PostConstruct` initialisiert den OpenAI-Client zur Verbindung mit Foundry Local.
4. **Demo-Ausführung**: `CommandLineRunner` wird nach dem Start ausgeführt.
5. **KI-Aufruf**: Die Demo ruft `foundryLocalService.chat()` mit einer Testnachricht auf.
6. **API-Anfrage**: Der Service erstellt und sendet eine OpenAI-kompatible Anfrage an Foundry Local.
7. **Antwortverarbeitung**: Der Service extrahiert und gibt die Antwort der KI zurück.
8. **Anzeige**: Die Anwendung druckt die Antwort und beendet sich.

## Foundry Local einrichten

Um Foundry Local einzurichten, folgen Sie diesen Schritten:

1. **Foundry Local installieren** gemäß den Anweisungen im Abschnitt [Voraussetzungen](../../../../04-PracticalSamples/foundrylocal).

2. **Den dynamisch zugewiesenen Port überprüfen**. Foundry Local weist beim Start automatisch einen Port zu. Finden Sie Ihren Port mit:
   ```bash
   foundry service status
   ```
   
   **Optional**: Wenn Sie einen bestimmten Port verwenden möchten (z. B. 5273), können Sie ihn manuell konfigurieren:
   ```bash
   foundry service set --port 5273
   ```


3. **Das gewünschte KI-Modell herunterladen**, z. B. `phi-3.5-mini`, mit folgendem Befehl:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **Die Datei application.properties konfigurieren**, um Ihre Foundry Local-Einstellungen anzupassen:
   - Aktualisieren Sie den Port in `base-url` (aus Schritt 2), und stellen Sie sicher, dass `/v1` am Ende enthalten ist.
   - Aktualisieren Sie den Modellnamen, um die Versionsnummer einzuschließen (überprüfen Sie mit `foundry model list`).

   Beispiel:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## Anwendung ausführen

### Schritt 1: Foundry Local starten
```bash
foundry model run phi-3.5-mini
```


### Schritt 2: Anwendung bauen und ausführen
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
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```


## Nächste Schritte

Für weitere Beispiele siehe [Kapitel 04: Praktische Beispiele](../README.md).

## Fehlerbehebung

### Häufige Probleme

**"Connection refused" oder "Service unavailable"**
- Stellen Sie sicher, dass Foundry Local läuft: `foundry model list`.
- Überprüfen Sie den tatsächlichen Port, den Foundry Local verwendet: `foundry service status`.
- Aktualisieren Sie Ihre `application.properties` mit dem richtigen Port, und stellen Sie sicher, dass die URL mit `/v1` endet.
- Alternativ können Sie einen bestimmten Port festlegen: `foundry service set --port 5273`.
- Versuchen Sie, Foundry Local neu zu starten: `foundry model run phi-3.5-mini`.

**"Model not found" oder "404 Not Found"-Fehler**
- Überprüfen Sie verfügbare Modelle mit ihren genauen IDs: `foundry model list`.
- Aktualisieren Sie den Modellnamen in `application.properties`, sodass er genau übereinstimmt, einschließlich der Versionsnummer (z. B. `Phi-3.5-mini-instruct-cuda-gpu:1`).
- Stellen Sie sicher, dass die `base-url` mit `/v1` endet: `http://localhost:5273/v1`.
- Laden Sie das Modell herunter, falls erforderlich: `foundry model run phi-3.5-mini`.

**"400 Bad Request"-Fehler**
- Überprüfen Sie, ob die Basis-URL `/v1` enthält: `http://localhost:5273/v1`.
- Stellen Sie sicher, dass die Modell-ID genau mit der aus `foundry model list` übereinstimmt.
- Vergewissern Sie sich, dass Sie `maxCompletionTokens()` in Ihrem Code verwenden (nicht das veraltete `maxTokens()`).

**Maven-Kompilierungsfehler**
- Stellen Sie sicher, dass Java 21 oder höher installiert ist: `java -version`.
- Bereinigen und neu bauen: `mvn clean compile`.
- Überprüfen Sie die Internetverbindung für den Download von Abhängigkeiten.

**Anwendung startet, aber keine Ausgabe**
- Überprüfen Sie, ob Foundry Local antwortet: Prüfen Sie `http://localhost:5273/v1/models` oder führen Sie `foundry service status` aus.
- Überprüfen Sie die Anwendungsprotokolle auf spezifische Fehlermeldungen.
- Stellen Sie sicher, dass das Modell vollständig geladen und einsatzbereit ist.

---

**Haftungsausschluss**:  
Dieses Dokument wurde mit dem KI-Übersetzungsdienst [Co-op Translator](https://github.com/Azure/co-op-translator) übersetzt. Obwohl wir uns um Genauigkeit bemühen, beachten Sie bitte, dass automatisierte Übersetzungen Fehler oder Ungenauigkeiten enthalten können. Das Originaldokument in seiner ursprünglichen Sprache sollte als maßgebliche Quelle betrachtet werden. Für kritische Informationen wird eine professionelle menschliche Übersetzung empfohlen. Wir übernehmen keine Haftung für Missverständnisse oder Fehlinterpretationen, die sich aus der Nutzung dieser Übersetzung ergeben.