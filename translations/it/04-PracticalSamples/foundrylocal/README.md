<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T18:15:57+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "it"
}
-->
# Applicazione a Riga di Comando di Foundry Local

>**Nota**: Questo capitolo include un [**Tutorial**](./TUTORIAL.md) che ti guida nell'esecuzione degli esempi completati.

Una semplice applicazione a riga di comando Spring Boot che dimostra come connettersi a Foundry Local utilizzando l'SDK Java di OpenAI.

## Cosa Imparerai

- Come integrare Foundry Local con applicazioni Spring Boot utilizzando l'SDK Java di OpenAI
- Best practice per lo sviluppo e il testing di AI in locale

## Indice

- [Cosa Imparerai](../../../../04-PracticalSamples/foundrylocal)
- [Prerequisiti](../../../../04-PracticalSamples/foundrylocal)
  - [Installazione di Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Verifica](../../../../04-PracticalSamples/foundrylocal)
- [Configurazione](../../../../04-PracticalSamples/foundrylocal)
- [Avvio Rapido](../../../../04-PracticalSamples/foundrylocal)
- [Cosa Fa l'Applicazione](../../../../04-PracticalSamples/foundrylocal)
- [Esempio di Output](../../../../04-PracticalSamples/foundrylocal)
- [Architettura](../../../../04-PracticalSamples/foundrylocal)
- [Punti Salienti del Codice](../../../../04-PracticalSamples/foundrylocal)
  - [Integrazione con l'SDK Java di OpenAI](../../../../04-PracticalSamples/foundrylocal)
  - [API di Completamento Chat](../../../../04-PracticalSamples/foundrylocal)
- [Risoluzione dei Problemi](../../../../04-PracticalSamples/foundrylocal)

## Prerequisiti

> **⚠️ Nota**: Questa applicazione **non funziona nel devcontainer fornito** poiché richiede che Foundry Local sia installato e in esecuzione sul sistema host.

### Installazione di Foundry Local

Prima di eseguire questa applicazione, è necessario installare e avviare Foundry Local. Segui questi passaggi:

1. **Assicurati che il tuo sistema soddisfi i requisiti**:
   - **Sistema Operativo**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 o macOS
   - **Hardware**: 
     - Minimo: 8GB di RAM, 3GB di spazio libero su disco
     - Consigliato: 16GB di RAM, 15GB di spazio libero su disco
   - **Rete**: Connessione Internet per il download iniziale del modello (opzionale per l'uso offline)
   - **Accelerazione (opzionale)**: GPU NVIDIA (serie 2000 o più recente), GPU AMD (serie 6000 o più recente), Qualcomm Snapdragon X Elite (8GB o più di memoria) o Apple silicon
   - **Permessi**: Privilegi amministrativi per installare software sul dispositivo

2. **Installa Foundry Local**:
   
   **Per Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **Per macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   In alternativa, puoi scaricare l'installer dal [repository GitHub di Foundry Local](https://github.com/microsoft/Foundry-Local).

3. **Avvia il tuo primo modello**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Il modello verrà scaricato (operazione che potrebbe richiedere alcuni minuti, a seconda della velocità della tua connessione) e quindi eseguito. Foundry Local seleziona automaticamente la variante del modello migliore per il tuo sistema (CUDA per GPU NVIDIA, versione CPU altrimenti).

4. **Testa il modello** ponendo una domanda nello stesso terminale:

   ```bash
   Why is the sky blue?
   ```

   Dovresti vedere una risposta dal modello Phi che spiega perché il cielo appare blu.

### Verifica

Puoi verificare che tutto funzioni correttamente con questi comandi:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Puoi anche visitare `http://localhost:5273` nel tuo browser per vedere l'interfaccia web di Foundry Local.

## Configurazione

L'applicazione può essere configurata tramite `application.properties`:

- `foundry.local.base-url` - URL base per Foundry Local (predefinito: http://localhost:5273)
- `foundry.local.model` - Modello AI da utilizzare (predefinito: Phi-3.5-mini-instruct-cuda-gpu)

> **Nota**: Il nome del modello nella configurazione deve corrispondere alla variante specifica che Foundry Local ha scaricato per il tuo sistema. Quando esegui `foundry model run phi-3.5-mini`, Foundry Local seleziona e scarica automaticamente la variante migliore (CUDA per GPU NVIDIA, versione CPU altrimenti). Usa `foundry model list` per vedere il nome esatto del modello disponibile nella tua istanza locale.

## Avvio Rapido

### 1. Vai alla directory dell'applicazione Foundry Local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Esegui l'Applicazione

```bash
mvn spring-boot:run
```

Oppure costruisci ed esegui il JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Dipendenze

Questa applicazione utilizza l'SDK Java di OpenAI per comunicare con Foundry Local. La dipendenza principale è:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

L'applicazione è preconfigurata per connettersi a Foundry Local in esecuzione sulla porta predefinita.

## Cosa Fa l'Applicazione

Quando esegui l'applicazione:

1. **Si avvia** come applicazione a riga di comando (senza server web)
2. **Invia automaticamente** un messaggio di test: "Ciao! Puoi dirmi cosa sei e quale modello stai eseguendo?"
3. **Mostra la risposta** di Foundry Local nella console
4. **Termina correttamente** dopo la demo

## Esempio di Output

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Architettura

- **Application.java** - Applicazione principale Spring Boot con CommandLineRunner
- **FoundryLocalService.java** - Servizio che utilizza l'SDK Java di OpenAI per comunicare con Foundry Local
- Utilizza **l'SDK Java di OpenAI** per chiamate API tipizzate
- Serializzazione/deserializzazione JSON automatica gestita dall'SDK
- Configurazione pulita utilizzando le annotazioni `@Value` e `@PostConstruct` di Spring

## Punti Salienti del Codice

### Integrazione con l'SDK Java di OpenAI

L'applicazione utilizza l'SDK Java di OpenAI per creare un client configurato per Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### API di Completamento Chat

Effettuare richieste di completamento chat è semplice e tipizzato:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Risoluzione dei Problemi

Se riscontri errori di connessione:
1. Verifica che Foundry Local sia in esecuzione su `http://localhost:5273`
2. Controlla che una variante del modello Phi-3.5-mini sia disponibile con `foundry model list`
3. Assicurati che il nome del modello in `application.properties` corrisponda esattamente al nome del modello mostrato nell'elenco
4. Verifica che nessun firewall stia bloccando la connessione

Problemi comuni:
- **Modello non trovato**: Esegui `foundry model run phi-3.5-mini` per scaricare e avviare il modello
- **Servizio non in esecuzione**: Il servizio Foundry Local potrebbe essersi arrestato; riavvialo con il comando di esecuzione del modello
- **Nome modello errato**: Usa `foundry model list` per vedere i modelli disponibili e aggiorna la configurazione di conseguenza

**Disclaimer (Avvertenza)**:  
Questo documento è stato tradotto utilizzando il servizio di traduzione automatica [Co-op Translator](https://github.com/Azure/co-op-translator). Sebbene ci impegniamo per garantire l'accuratezza, si prega di notare che le traduzioni automatiche potrebbero contenere errori o imprecisioni. Il documento originale nella sua lingua nativa dovrebbe essere considerato la fonte autorevole. Per informazioni critiche, si raccomanda una traduzione professionale effettuata da un traduttore umano. Non siamo responsabili per eventuali incomprensioni o interpretazioni errate derivanti dall'uso di questa traduzione.