<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T19:11:10+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "sv"
}
-->
# Kärntekniker för Generativ AI

>**Note**: Detta kapitel inkluderar en detaljerad [**handledning**](./TUTORIAL.md) som guidar dig genom att köra de färdiga exemplen.

## Vad du kommer att lära dig
I detta kapitel tittar vi på fyra kärntekniker för generativ AI genom praktiska exempel:
- LLM-kompletteringar och chattflöden
- Funktionsanrop
- Retrieval-Augmented Generation (RAG)
- Ansvarsfulla AI-säkerhetsåtgärder

## Innehållsförteckning

- [Vad du kommer att lära dig](../../../03-CoreGenerativeAITechniques)
- [Förkunskaper](../../../03-CoreGenerativeAITechniques)
- [Komma igång](../../../03-CoreGenerativeAITechniques)
- [Översikt över exempel](../../../03-CoreGenerativeAITechniques)
  - [1. LLM-kompletteringar och chattflöden](../../../03-CoreGenerativeAITechniques)
  - [2. Funktioner och plugins med LLMs](../../../03-CoreGenerativeAITechniques)
  - [3. Retrieval-Augmented Generation (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Demonstration av ansvarsfull AI-säkerhet](../../../03-CoreGenerativeAITechniques)
- [Sammanfattning](../../../03-CoreGenerativeAITechniques)
- [Nästa steg](../../../03-CoreGenerativeAITechniques)

## Förkunskaper

- Slutförd installation från [Kapitel 2](../../../02-SetupDevEnvironment)

## Komma igång

1. **Navigera till exempel**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Ställ in miljö**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Kompilera och kör exempel**:  
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

## Översikt över exempel

Exemplen är organiserade i mappen `examples/` med följande struktur:

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

### 1. LLM-kompletteringar och chattflöden
**Fil**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Lär dig att bygga konversations-AI med strömmande svar och hantering av chattloggar.

Detta exempel visar:
- Enkel textkomplettering med systemprompter
- Fleromgångskonversationer med logghantering
- Interaktiva chattsessioner
- Parameterkonfiguration (temperatur, max tokens)

### 2. Funktioner och plugins med LLMs
**Fil**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Utöka AI-funktioner genom att ge modeller tillgång till anpassade funktioner och externa API:er.

Detta exempel visar:
- Integration av väderfunktion
- Implementering av kalkylatorfunktion  
- Flera funktionsanrop i en konversation
- Funktionsdefinition med JSON-scheman

### 3. Retrieval-Augmented Generation (RAG)
**Fil**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Lär dig att kombinera AI med dina egna dokument och datakällor för exakta, kontextmedvetna svar.

Detta exempel visar:
- Dokumentbaserad frågehantering med Azure OpenAI SDK
- Implementering av RAG-mönster med GitHub-modeller

**Användning**: Ställ frågor om innehållet i `document.txt` och få AI-svar baserade enbart på det sammanhanget.

### 4. Demonstration av ansvarsfull AI-säkerhet
**Fil**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Få en förhandsvisning av hur AI-säkerhetsåtgärder fungerar genom att testa GitHub-modellers innehållsfiltreringsfunktioner.

Detta exempel visar:
- Innehållsfiltrering för potentiellt skadliga prompter
- Hantering av säkerhetssvar i applikationer
- Olika kategorier av blockerade innehåll (våld, hatpropaganda, desinformation)
- Korrekt felhantering vid säkerhetsöverträdelser

> **Läs mer**: Detta är bara en introduktion till koncepten för ansvarsfull AI. För mer information om etik, hantering av partiskhet, integritetsöverväganden och ramverk för ansvarsfull AI, se [Kapitel 5: Ansvarsfull Generativ AI](../05-ResponsibleGenAI/README.md).

## Sammanfattning

I detta kapitel utforskade vi LLM-kompletteringar och chattflöden, implementerade funktionsanrop för att förbättra AI-funktioner, skapade ett Retrieval-Augmented Generation (RAG)-system och demonstrerade ansvarsfulla AI-säkerhetsåtgärder.

> **NOTE**: Fördjupa dig med den medföljande [**handledningen**](./TUTORIAL.md)

## Nästa steg

[Kapitel 4: Praktiska tillämpningar och projekt](../04-PracticalSamples/README.md)

**Ansvarsfriskrivning**:  
Detta dokument har översatts med hjälp av AI-översättningstjänsten [Co-op Translator](https://github.com/Azure/co-op-translator). Även om vi strävar efter noggrannhet, bör det noteras att automatiserade översättningar kan innehålla fel eller felaktigheter. Det ursprungliga dokumentet på dess originalspråk bör betraktas som den auktoritativa källan. För kritisk information rekommenderas professionell mänsklig översättning. Vi ansvarar inte för eventuella missförstånd eller feltolkningar som uppstår vid användning av denna översättning.