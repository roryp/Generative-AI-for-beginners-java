<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T09:25:27+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "it"
}
-->
# App Storia degli Animali Domestici

>**Nota**: Questo capitolo include un [**Tutorial**](./TUTORIAL.md) che ti guida attraverso gli esempi.

Un'applicazione web Spring Boot che genera descrizioni e storie basate sull'intelligenza artificiale per immagini di animali domestici caricate, utilizzando GitHub Models.

## Indice

- [Stack Tecnologico](../../../../04-PracticalSamples/petstory)
- [Prerequisiti](../../../../04-PracticalSamples/petstory)
- [Configurazione e Installazione](../../../../04-PracticalSamples/petstory)
- [Utilizzo](../../../../04-PracticalSamples/petstory)

## Stack Tecnologico

- **Backend**: Spring Boot 3.5.3, Java 21
- **Integrazione AI**: OpenAI Java SDK con GitHub Models
- **Sicurezza**: Spring Security
- **Frontend**: Template Thymeleaf con stile Bootstrap
- **Strumento di Build**: Maven
- **Modelli AI**: GitHub Models

## Prerequisiti

- Java 21 o superiore
- Maven 3.9+
- Token di Accesso Personale GitHub con ambito `models:read`

## Configurazione e Installazione

### 1. Vai alla directory dell'applicazione petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Imposta la Variabile d'Ambiente
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Compila l'Applicazione
```bash
mvn clean compile
```

### 4. Avvia l'Applicazione
```bash
mvn spring-boot:run
```

## Utilizzo

1. **Accedi all'Applicazione**: Vai su `http://localhost:8080`
2. **Carica Immagine**: Clicca su "Scegli File" e seleziona un'immagine di un animale domestico
3. **Analizza Immagine**: Clicca su "Analizza Immagine" per ottenere una descrizione AI
4. **Genera Storia**: Clicca su "Genera Storia" per creare la storia

**Disclaimer**:  
Questo documento è stato tradotto utilizzando il servizio di traduzione automatica [Co-op Translator](https://github.com/Azure/co-op-translator). Sebbene ci impegniamo per garantire l'accuratezza, si prega di notare che le traduzioni automatiche possono contenere errori o imprecisioni. Il documento originale nella sua lingua nativa dovrebbe essere considerato la fonte autorevole. Per informazioni critiche, si raccomanda una traduzione professionale effettuata da un traduttore umano. Non siamo responsabili per eventuali incomprensioni o interpretazioni errate derivanti dall'uso di questa traduzione.