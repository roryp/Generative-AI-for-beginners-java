<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T19:11:31+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "da"
}
-->
# Kerne Generative AI-teknikker

>**Note**: Dette kapitel inkluderer en detaljeret [**Tutorial**](./TUTORIAL.md), der guider dig gennem eksekvering af de færdige eksempler.

## Hvad Du Vil Lære
I dette kapitel ser vi på 4 kerne generative AI-teknikker gennem praktiske eksempler:
- LLM-fuldførelser og chatflows
- Funktionskald
- Retrieval-Augmented Generation (RAG)
- Ansvarlige AI-sikkerhedsforanstaltninger

## Indholdsfortegnelse

- [Hvad Du Vil Lære](../../../03-CoreGenerativeAITechniques)
- [Forudsætninger](../../../03-CoreGenerativeAITechniques)
- [Kom Godt I Gang](../../../03-CoreGenerativeAITechniques)
- [Oversigt Over Eksempler](../../../03-CoreGenerativeAITechniques)
  - [1. LLM-fuldførelser og Chatflows](../../../03-CoreGenerativeAITechniques)
  - [2. Funktioner & Plugins med LLM'er](../../../03-CoreGenerativeAITechniques)
  - [3. Retrieval-Augmented Generation (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Demonstration af Ansvarlig AI-sikkerhed](../../../03-CoreGenerativeAITechniques)
- [Opsummering](../../../03-CoreGenerativeAITechniques)
- [Næste Skridt](../../../03-CoreGenerativeAITechniques)

## Forudsætninger

- Fuldført opsætning fra [Kapitel 2](../../../02-SetupDevEnvironment)

## Kom Godt I Gang

1. **Naviger til eksempler**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Sæt miljøet op**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Kompilér og kør eksempler**:  
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

## Oversigt Over Eksempler

Eksemplerne er organiseret i mappen `examples/` med følgende struktur:

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

### 1. LLM-fuldførelser og Chatflows
**Fil**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Lær at bygge samtale-AI med streaming-svar og chat-historikstyring.

Dette eksempel demonstrerer:
- Simpel tekstfuldførelse med systemprompter
- Flerdrejede samtaler med historikstyring
- Interaktive chatsessioner
- Parameterkonfiguration (temperatur, maks. tokens)

### 2. Funktioner & Plugins med LLM'er
**Fil**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Udvid AI's kapaciteter ved at give modeller adgang til brugerdefinerede funktioner og eksterne API'er.

Dette eksempel demonstrerer:
- Integration af vejr-funktion
- Implementering af lommeregner-funktion  
- Flere funktionskald i én samtale
- Funktionsdefinition med JSON-skemaer

### 3. Retrieval-Augmented Generation (RAG)
**Fil**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Lær at kombinere AI med dine egne dokumenter og datakilder for præcise, kontekstbevidste svar.

Dette eksempel demonstrerer:
- Dokumentbaseret spørgsmål-svar med Azure OpenAI SDK
- Implementering af RAG-mønster med GitHub-modeller

**Anvendelse**: Stil spørgsmål om indholdet i `document.txt` og få AI-svar baseret udelukkende på den kontekst.

### 4. Demonstration af Ansvarlig AI-sikkerhed
**Fil**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Få en forsmag på, hvordan AI-sikkerhedsforanstaltninger fungerer ved at teste GitHub-modellers indholdsfiltreringsfunktioner.

Dette eksempel demonstrerer:
- Indholdsfiltrering for potentielt skadelige prompter
- Håndtering af sikkerhedsrelaterede svar i applikationer
- Forskellige kategorier af blokeret indhold (vold, hadefuld tale, misinformation)
- Korrekt fejlhåndtering ved sikkerhedsbrud

> **Lær Mere**: Dette er kun en introduktion til ansvarlige AI-koncepter. For mere information om etik, bias-reduktion, privatlivsovervejelser og ansvarlige AI-rammer, se [Kapitel 5: Ansvarlig Generativ AI](../05-ResponsibleGenAI/README.md).

## Opsummering

I dette kapitel udforskede vi LLM-fuldførelser og chatflows, implementerede funktionskald for at udvide AI's kapaciteter, skabte et Retrieval-Augmented Generation (RAG)-system og demonstrerede ansvarlige AI-sikkerhedsforanstaltninger.

> **NOTE**: Gå i dybden med den medfølgende [**Tutorial**](./TUTORIAL.md)

## Næste Skridt

[Kapitel 4: Praktiske Anvendelser & Projekter](../04-PracticalSamples/README.md)

**Ansvarsfraskrivelse**:  
Dette dokument er blevet oversat ved hjælp af AI-oversættelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selvom vi bestræber os på at sikre nøjagtighed, skal det bemærkes, at automatiserede oversættelser kan indeholde fejl eller unøjagtigheder. Det originale dokument på dets oprindelige sprog bør betragtes som den autoritative kilde. For kritisk information anbefales professionel menneskelig oversættelse. Vi påtager os ikke ansvar for eventuelle misforståelser eller fejltolkninger, der måtte opstå som følge af brugen af denne oversættelse.