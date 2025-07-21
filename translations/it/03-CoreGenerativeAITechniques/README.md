<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T17:41:12+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "it"
}
-->
# Tecniche Fondamentali di Generative AI

>**Nota**: Questo capitolo include un [**Tutorial**](./TUTORIAL.md) dettagliato che ti guida nell'esecuzione degli esempi finali.

## Cosa Imparerai
In questo capitolo, esploreremo 4 tecniche fondamentali di generative AI attraverso esempi pratici:
- Completamenti LLM e flussi di chat
- Chiamate a funzioni
- Generazione con Recupero Aumentato (RAG)
- Misure di sicurezza per un'AI responsabile

## Indice

- [Cosa Imparerai](../../../03-CoreGenerativeAITechniques)
- [Prerequisiti](../../../03-CoreGenerativeAITechniques)
- [Introduzione](../../../03-CoreGenerativeAITechniques)
- [Panoramica degli Esempi](../../../03-CoreGenerativeAITechniques)
  - [1. Completamenti LLM e Flussi di Chat](../../../03-CoreGenerativeAITechniques)
  - [2. Funzioni e Plugin con LLM](../../../03-CoreGenerativeAITechniques)
  - [3. Generazione con Recupero Aumentato (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Dimostrazione di Sicurezza per un'AI Responsabile](../../../03-CoreGenerativeAITechniques)
- [Riepilogo](../../../03-CoreGenerativeAITechniques)
- [Prossimi Passi](../../../03-CoreGenerativeAITechniques)

## Prerequisiti

- Configurazione completata dal [Capitolo 2](../../../02-SetupDevEnvironment)

## Introduzione

1. **Vai agli esempi**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Imposta l'ambiente**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Compila ed esegui gli esempi**:  
```bash
   # Run completions example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
   
   # Run functions example  
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
   
   # Run RAG example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
   
   # Run responsible AI demo
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```  

## Panoramica degli Esempi

Gli esempi sono organizzati nella cartella `examples/` con la seguente struttura:

```
examples/
├── src/main/java/com/example/genai/techniques/
│   ├── completions/
│   │   └── LLMCompletionsApp.java        # Basic completions 
│   ├── functions/
│   │   └── FunctionsApp.java             # Function calling examples
│   ├── rag/
│   │   └── SimpleReaderDemo.java         # Retrieval-Augmented Generation
│   └── responsibleai/
│       └── ResponsibleGithubModels.java  # Responsible AI safety demonstration
├── document.txt                          # Sample document for RAG example
└── pom.xml                               # Maven configuration
```

### 1. Completamenti LLM e Flussi di Chat
**File**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Impara a costruire AI conversazionali con risposte in streaming e gestione della cronologia delle chat.

Questo esempio dimostra:
- Completamento di testo semplice con prompt di sistema
- Conversazioni multi-turno con gestione della cronologia
- Sessioni di chat interattive
- Configurazione dei parametri (temperature, max tokens)

### 2. Funzioni e Plugin con LLM
**File**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Estendi le capacità dell'AI fornendo ai modelli accesso a funzioni personalizzate e API esterne.

Questo esempio dimostra:
- Integrazione di una funzione meteo
- Implementazione di una funzione calcolatrice  
- Chiamate multiple a funzioni in una singola conversazione
- Definizione di funzioni con schemi JSON

### 3. Generazione con Recupero Aumentato (RAG)
**File**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Scopri come combinare l'AI con i tuoi documenti e fonti di dati per risposte accurate e contestualizzate.

Questo esempio dimostra:
- Risposte a domande basate su documenti con Azure OpenAI SDK
- Implementazione del pattern RAG con i modelli di GitHub

**Utilizzo**: Fai domande sul contenuto di `document.txt` e ottieni risposte AI basate esclusivamente su quel contesto.

### 4. Dimostrazione di Sicurezza per un'AI Responsabile
**File**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Ottieni un'anteprima di come funzionano le misure di sicurezza dell'AI testando le capacità di filtraggio dei contenuti dei modelli di GitHub.

Questo esempio dimostra:
- Filtraggio dei contenuti per prompt potenzialmente dannosi
- Gestione delle risposte di sicurezza nelle applicazioni
- Diverse categorie di contenuti bloccati (violenza, discorsi d'odio, disinformazione)
- Gestione corretta degli errori per violazioni di sicurezza

> **Per Saperne di Più**: Questa è solo un'introduzione ai concetti di AI responsabile. Per maggiori informazioni su etica, mitigazione dei bias, considerazioni sulla privacy e framework per un'AI responsabile, consulta [Capitolo 5: Generative AI Responsabile](../05-ResponsibleGenAI/README.md).

## Riepilogo

In questo capitolo, abbiamo esplorato i completamenti LLM e i flussi di chat, implementato chiamate a funzioni per migliorare le capacità dell'AI, creato un sistema di Generazione con Recupero Aumentato (RAG) e dimostrato misure di sicurezza per un'AI responsabile.

> **NOTA**: Approfondisci con il [**Tutorial**](./TUTORIAL.md)

## Prossimi Passi

[Capitolo 4: Applicazioni Pratiche e Progetti](../04-PracticalSamples/README.md)

**Disclaimer**:  
Questo documento è stato tradotto utilizzando il servizio di traduzione automatica [Co-op Translator](https://github.com/Azure/co-op-translator). Sebbene ci impegniamo per garantire l'accuratezza, si prega di notare che le traduzioni automatiche potrebbero contenere errori o imprecisioni. Il documento originale nella sua lingua nativa dovrebbe essere considerato la fonte autorevole. Per informazioni critiche, si raccomanda una traduzione professionale effettuata da un traduttore umano. Non siamo responsabili per eventuali incomprensioni o interpretazioni errate derivanti dall'uso di questa traduzione.