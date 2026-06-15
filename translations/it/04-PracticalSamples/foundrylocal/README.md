# Tutorial Foundry Local Spring Boot

## Indice

- [Prerequisiti](#prerequisiti)
- [Panoramica del Progetto](#panoramica-del-progetto)
- [Comprendere il Codice](#comprendere-il-codice)
  - [1. Configurazione dell'Applicazione (application.properties)](#1-configurazione-dellapplicazione-applicationproperties)
  - [2. Classe Principale dell'Applicazione (Application.java)](#2-classe-principale-dellapplicazione-applicationjava)
  - [3. Livello di Servizio AI (FoundryLocalService.java)](#3-livello-di-servizio-ai-foundrylocalservicejava)
  - [4. Dipendenze del Progetto (pom.xml)](#4-dipendenze-del-progetto-pomxml)
- [Come Funziona Tutto Insieme](#come-funziona-tutto-insieme)
- [Configurare Foundry Local](#configurare-foundry-local)
- [Esecuzione dell'Applicazione](#esecuzione-dellapplicazione)
- [Output Previsto](#output-previsto)
- [Passi Successivi](#passi-successivi)
- [Risoluzione dei Problemi](#risoluzione-dei-problemi)


## Prerequisiti

Prima di iniziare questo tutorial, assicurati di avere:

- **Java 21 o superiore** installato sul tuo sistema
- **Maven 3.6+** per compilare il progetto
- **Foundry Local** installato e in esecuzione

### **Installare Foundry Local:**

> **Nota:** La CLI di Foundry Local è disponibile solo per **Windows** e **macOS**. Linux è supportato tramite i [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Verifica l’installazione:
```bash
foundry --version
```

## Panoramica del Progetto

Questo progetto è composto da quattro componenti principali:

1. **Application.java** - Punto di ingresso principale dell'applicazione Spring Boot
2. **FoundryLocalService.java** - Livello di servizio che gestisce la comunicazione con l'AI
3. **application.properties** - Configurazione per la connessione a Foundry Local
4. **pom.xml** - Dipendenze Maven e configurazione del progetto

## Comprendere il Codice

### 1. Configurazione dell'Applicazione (application.properties)

**File:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Cosa fa:**
- **base-url**: Specifica dove sta girando Foundry Local, inclusa la path `/v1` per la compatibilità con OpenAI API. La porta di default è `5273`. Se la porta è diversa, verificala con `foundry service status`.
- **model** (opzionale): Nome del modello AI da usare per la generazione di testo. **Di default, l’applicazione rileva automaticamente il modello** interrogando l’endpoint `/v1/models` di Foundry Local all’avvio, quindi non è necessario impostarlo. Puoi comunque configurarlo esplicitamente per sovrascrivere l’auto-rilevamento se necessario.

**Concetto chiave:** Spring Boot carica automaticamente queste proprietà e le rende disponibili all'applicazione usando l’annotazione `@Value`.

### 2. Classe Principale dell'Applicazione (Application.java)

**File:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Nessun server web necessario
        app.run(args);
    }
```

**Cosa fa:**
- `@SpringBootApplication` abilita l’auto-configurazione di Spring Boot
- `WebApplicationType.NONE` indica a Spring che questa è un’applicazione da riga di comando, non un server web
- Il metodo main avvia l’applicazione Spring

**Il Demo Runner:**
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

**Cosa fa:**
- `@Bean` crea un componente gestito da Spring
- `CommandLineRunner` esegue codice dopo l’avvio di Spring Boot
- `foundryLocalService` viene iniettato automaticamente da Spring (dependency injection)
- Invia un messaggio di prova all’AI e mostra la risposta

### 3. Livello di Servizio AI (FoundryLocalService.java)

**File:** `src/main/java/com/example/FoundryLocalService.java`

#### Iniezione della Configurazione:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Rilevato automaticamente se vuoto
```

**Cosa fa:**
- `@Service` indica a Spring che questa classe fornisce logica di business
- `@Value` inietta i valori di configurazione da application.properties
- Il modello di default è vuoto, il che innesca l’**auto-rilevamento** del modello da Foundry Local all’avvio. Questo significa che l’app funziona con qualsiasi modello caricato in Foundry Local senza configurazione manuale.

#### Inizializzazione del Client:
```java
@PostConstruct
public void init() {
    // Rileva automaticamente il modello da Foundry Local se non configurato esplicitamente
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // L'URL base include già /v1 dalla configurazione
            .apiKey("not-needed")            // Il server locale non necessita di una chiave API reale
            .build();
}
```

**Cosa fa:**
- `@PostConstruct` esegue questo metodo dopo che Spring ha creato il servizio
- Se non è configurato nessun modello, interroga l’endpoint `/v1/models` di Foundry Local e ne sceglie il primo disponibile
- Crea un client OpenAI che punta alla tua istanza locale di Foundry Local
- L’URL base da `application.properties` include già `/v1` per la compatibilità con l’API OpenAI
- La chiave API è impostata su "not-needed" perché lo sviluppo locale non richiede autenticazione

#### Metodo Chat:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Quale modello di intelligenza artificiale utilizzare
                .addUserMessage(message)         // La tua domanda/richiesta
                .maxCompletionTokens(150)        // Limita la lunghezza della risposta
                .temperature(0.7)                // Controlla la creatività (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Estrai la risposta dell'IA dal risultato dell'API
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Cosa fa:**
- **ChatCompletionCreateParams**: Configura la richiesta AI
  - `model`: Specifica quale modello AI usare (deve corrispondere esattamente all’ID mostrato da `foundry model list`)
  - `addUserMessage`: Aggiunge il tuo messaggio alla conversazione
  - `maxCompletionTokens`: Limita la lunghezza della risposta (risparmia risorse)
  - `temperature`: Controlla la casualità (0.0 = deterministico, 1.0 = creativo)
- **Chiamata API**: Invia la richiesta a Foundry Local
- **Gestione della Risposta**: Estrae in sicurezza il testo della risposta AI
- **Gestione degli Errori**: Avvolge le eccezioni con messaggi utili

### 4. Dipendenze del Progetto (pom.xml)

**Dipendenze Chiave:**

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

**Cosa fanno:**
- **spring-boot-starter**: Fornisce la funzionalità base di Spring Boot
- **openai-java**: SDK ufficiale Java OpenAI per la comunicazione con l’API
- **jackson-databind**: Gestisce la serializzazione/deserializzazione JSON per le chiamate API

## Come Funziona Tutto Insieme

Ecco il flusso completo quando esegui l’applicazione:

1. **Avvio**: Spring Boot parte e legge `application.properties`
2. **Creazione del Servizio**: Spring crea il `FoundryLocalService` e inietta i valori di configurazione
3. **Rilevamento del Modello**: Se nessun modello è configurato, il servizio interroga l’endpoint `/v1/models` di Foundry Local e usa il primo modello disponibile automaticamente
4. **Setup Client**: `@PostConstruct` inizializza il client OpenAI per connettersi a Foundry Local
5. **Esecuzione Demo**: `CommandLineRunner` viene eseguito dopo l’avvio
6. **Chiamata AI**: La demo chiama `foundryLocalService.chat()` con un messaggio di prova
7. **Richiesta API**: Il servizio costruisce e invia una richiesta compatibile OpenAI a Foundry Local
8. **Elaborazione Risposta**: Il servizio estrae e restituisce la risposta AI
9. **Visualizzazione**: L’app stampa la risposta e termina

## Configurare Foundry Local

1. **Installa Foundry Local** usando le istruzioni nella sezione [Prerequisiti](#prerequisiti).

2. **Avvia il servizio** (se non è già in esecuzione):
   ```bash
   foundry service start
   ```

3. **Controlla lo stato del servizio** per confermare che sia in esecuzione e annota la porta:
   ```bash
   foundry service status
   ```

4. **Scarica ed esegui un modello** (scarica al primo avvio, in cache per utilizzi successivi):
   ```bash
   foundry model run phi-4-mini
   ```
   Questo apre una sessione di chat interattiva. Puoi uscire con `Ctrl+C`. Il modello resta caricato nel servizio.

   > **Suggerimento:** Esegui `foundry model list` per vedere tutti i modelli disponibili. Sostituisci `phi-4-mini` con qualsiasi alias dal catalogo (es. `qwen2.5-0.5b` per un modello più piccolo/veloce).

5. **Verifica che il modello sia caricato:**
   ```bash
   foundry service ps
   ```

6. **Aggiorna `application.properties`** se necessario:
   - L’`base-url` di default (`http://localhost:5273/v1`) corrisponde alla porta CLI predefinita. Modificala solo se `foundry service status` mostra una porta diversa.
   - Il modello è **rilevato automaticamente** all’avvio — non serve configurarlo.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Esecuzione dell'Applicazione

### Passo 1: Assicurati che un modello sia caricato in Foundry Local
```bash
foundry service ps
```
Se non sono elencati modelli, caricane uno:
```bash
foundry model run phi-4-mini
```

### Passo 2: Compila ed Esegui l’Applicazione
In un terminale separato:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Oppure compila ed esegui come JAR:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Output Previsto

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

## Passi Successivi

Per altri esempi, consulta [Capitolo 04: Esempi pratici](../README.md)

## Risoluzione dei Problemi

### Problemi Comuni

**"Connection refused" o "Service unavailable"**
- Controlla lo stato del servizio: `foundry service status`
- Riavvia se necessario: `foundry service restart`
- Verifica che la porta in `application.properties` corrisponda all’output di `foundry service status`
- Assicurati che l’URL finisca con `/v1`: `http://localhost:5273/v1`

**"Nessun modello trovato" all’avvio**
- L’applicazione rileva automaticamente il modello. Assicurati che almeno un modello sia caricato: `foundry service ps`
- Se non ci sono modelli caricati: `foundry model run phi-4-mini`
- Se hai sovrascritto il nome modello in `application.properties`, verifica che corrisponda a `foundry model list`

**Errori "400 Bad Request"**
- Verifica che l’URL base includa `/v1`: `http://localhost:5273/v1`
- Assicurati di usare `maxCompletionTokens()` nel codice (non il deprecato `maxTokens()`)

**Errori di compilazione Maven**
- Assicurati di avere Java 21 o superiore: `java -version`
- Pulisci e ricostruisci: `mvn clean compile`
- Controlla la connessione internet per scaricare le dipendenze

**Problemi di connessione al servizio**
- Se vedi `Request to local service failed`, esegui: `foundry service restart`
- Controlla i modelli caricati: `foundry service ps`
- Visualizza i log del servizio: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Disclaimer**:
Questo documento è stato tradotto utilizzando il servizio di traduzione AI [Co-op Translator](https://github.com/Azure/co-op-translator). Pur impegnandoci per l’accuratezza, si prega di notare che le traduzioni automatiche possono contenere errori o imprecisioni. Il documento originale nella sua lingua nativa deve essere considerato la fonte autorevole. Per informazioni critiche, si raccomanda la traduzione professionale umana. Non ci assumiamo alcuna responsabilità per eventuali fraintendimenti o interpretazioni errate derivanti dall’uso di questa traduzione.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->