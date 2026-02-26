# Chat di Base con Azure OpenAI - Esempio Completo

Questo esempio dimostra come creare una semplice applicazione Spring Boot che si connette ad Azure OpenAI e testa la tua configurazione.

## Indice

- [Prerequisiti](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Avvio Rapido](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Opzioni di Configurazione](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Opzione 1: Variabili d'Ambiente (file .env) - Consigliata](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Opzione 2: Segreti di GitHub Codespace](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Esecuzione dell'Applicazione](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Utilizzando Maven](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Utilizzando VS Code](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Output Atteso](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Riferimento alla Configurazione](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Variabili d'Ambiente](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Configurazione di Spring](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Risoluzione dei Problemi](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Problemi Comuni](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Modalità Debug](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Prossimi Passi](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Risorse](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Prerequisiti

Prima di eseguire questo esempio, assicurati di avere:

- Completato la [guida alla configurazione di Azure OpenAI](../../getting-started-azure-openai.md)  
- Distribuito una risorsa Azure OpenAI (tramite il portale Azure AI Foundry)  
- Distribuito il modello gpt-4o-mini (o un'alternativa)  
- Una chiave API e l'URL dell'endpoint da Azure  

## Avvio Rapido

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Opzioni di Configurazione

### Opzione 1: Variabili d'Ambiente (file .env) - Consigliata

**Passo 1: Crea il tuo file di configurazione**  
```bash
cp .env.example .env
```

**Passo 2: Aggiungi le tue credenziali Azure OpenAI**  
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Nota sulla Sicurezza**:  
> - Non commettere mai il file `.env` nel controllo di versione  
> - Il file `.env` è già incluso in `.gitignore`  
> - Mantieni le tue chiavi API sicure e ruotale regolarmente  

### Opzione 2: Segreti di GitHub Codespace

Per GitHub Codespaces, imposta questi segreti nel tuo repository:  
- `AZURE_AI_KEY` - La tua chiave API di Azure OpenAI  
- `AZURE_AI_ENDPOINT` - L'URL dell'endpoint di Azure OpenAI  

L'applicazione rileva e utilizza automaticamente questi segreti.

### Alternativa: Variabili d'Ambiente Dirette

<details>
<summary>Fai clic per vedere i comandi specifici per la piattaforma</summary>

**Linux/macOS (bash/zsh):**  
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Prompt dei Comandi):**  
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**  
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## Esecuzione dell'Applicazione

### Utilizzando Maven

```bash
mvn spring-boot:run
```

### Utilizzando VS Code

1. Apri il progetto in VS Code  
2. Premi `F5` o utilizza il pannello "Run and Debug"  
3. Seleziona la configurazione "Spring Boot-BasicChatApplication"  

> **Nota**: La configurazione di VS Code carica automaticamente il file .env  

### Output Atteso

```
Starting Basic Chat with Azure OpenAI...
Environment variables loaded successfully
Connecting to Azure OpenAI...
Sending prompt: What is AI in a short sentence? Max 100 words.

AI Response:
================
AI, or Artificial Intelligence, is the simulation of human intelligence in machines programmed to think and learn like humans.
================

Success! Azure OpenAI connection is working correctly.
```

## Riferimento alla Configurazione

### Variabili d'Ambiente

| Variabile | Descrizione | Obbligatoria | Esempio |
|-----------|-------------|--------------|---------|
| `AZURE_AI_KEY` | Chiave API di Azure OpenAI | Sì | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL dell'endpoint di Azure OpenAI | Sì | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Nome della distribuzione del modello | No | `gpt-4o-mini` (predefinito) |

### Configurazione di Spring

Il file `application.yml` configura:  
- **Chiave API**: `${AZURE_AI_KEY}` - Dalla variabile d'ambiente  
- **Endpoint**: `${AZURE_AI_ENDPOINT}` - Dalla variabile d'ambiente  
- **Modello**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Dalla variabile d'ambiente con valore predefinito  
- **Temperatura**: `0.7` - Controlla la creatività (0.0 = deterministico, 1.0 = creativo)  
- **Max Tokens**: `500` - Lunghezza massima della risposta  

## Risoluzione dei Problemi

### Problemi Comuni

<details>
<summary><strong>Errore: "La chiave API non è valida"</strong></summary>

- Controlla che il tuo `AZURE_AI_KEY` sia impostato correttamente nel file `.env`  
- Verifica che la chiave API sia copiata esattamente dal portale Azure AI Foundry  
- Assicurati che non ci siano spazi o virgolette extra attorno alla chiave  
</details>

<details>
<summary><strong>Errore: "L'endpoint non è valido"</strong></summary>

- Assicurati che il tuo `AZURE_AI_ENDPOINT` includa l'URL completo (es. `https://your-hub-name.openai.azure.com/`)  
- Controlla la coerenza della barra finale  
- Verifica che l'endpoint corrisponda alla tua regione di distribuzione di Azure  
</details>

<details>
<summary><strong>Errore: "La distribuzione non è stata trovata"</strong></summary>

- Verifica che il nome della distribuzione del modello corrisponda esattamente a quello distribuito in Azure  
- Controlla che il modello sia stato distribuito con successo e sia attivo  
- Prova a utilizzare il nome della distribuzione predefinito: `gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code: Le variabili d'ambiente non vengono caricate</strong></summary>

- Assicurati che il file `.env` si trovi nella directory radice del progetto (allo stesso livello di `pom.xml`)  
- Prova a eseguire `mvn spring-boot:run` nel terminale integrato di VS Code  
- Controlla che l'estensione Java di VS Code sia installata correttamente  
- Verifica che la configurazione di avvio abbia `"envFile": "${workspaceFolder}/.env"`  
</details>

### Modalità Debug

Per abilitare il logging dettagliato, decommenta queste righe in `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Prossimi Passi

**Configurazione Completata!** Continua il tuo percorso di apprendimento:

[Capitolo 3: Tecniche Core di Generative AI](../../../03-CoreGenerativeAITechniques/README.md)

## Risorse

- [Documentazione Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [Documentazione del Servizio Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)  
- [Portale Azure AI Foundry](https://ai.azure.com/)  
- [Documentazione Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**Disclaimer (Avvertenza)**:  
Questo documento è stato tradotto utilizzando il servizio di traduzione automatica [Co-op Translator](https://github.com/Azure/co-op-translator). Sebbene ci impegniamo per garantire l'accuratezza, si prega di tenere presente che le traduzioni automatiche possono contenere errori o imprecisioni. Il documento originale nella sua lingua nativa dovrebbe essere considerato la fonte autorevole. Per informazioni critiche, si raccomanda una traduzione professionale effettuata da un traduttore umano. Non siamo responsabili per eventuali incomprensioni o interpretazioni errate derivanti dall'uso di questa traduzione.