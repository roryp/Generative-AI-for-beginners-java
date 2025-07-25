<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T09:38:59+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "no"
}
-->
# Kjerne Generative AI-teknikker

>**Note**: Dette kapittelet inkluderer en detaljert [**Tutorial**](./TUTORIAL.md) som veileder deg gjennom eksemplene.

## Hva du vil lære
I dette kapittelet ser vi på 4 kjerne generative AI-teknikker gjennom praktiske eksempler:
- LLM fullføringer og chatflyt
- Funksjonskall
- Retrieval-Augmented Generation (RAG)
- Ansvarlige AI-sikkerhetstiltak

## Innholdsfortegnelse

- [Hva du vil lære](../../../03-CoreGenerativeAITechniques)
- [Forutsetninger](../../../03-CoreGenerativeAITechniques)
- [Komme i gang](../../../03-CoreGenerativeAITechniques)
- [Oversikt over eksempler](../../../03-CoreGenerativeAITechniques)
  - [1. LLM Fullføringer og Chatflyt](../../../03-CoreGenerativeAITechniques)
  - [2. Funksjoner og Plugins med LLMs](../../../03-CoreGenerativeAITechniques)
  - [3. Retrieval-Augmented Generation (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Demonstrasjon av Ansvarlig AI-sikkerhet](../../../03-CoreGenerativeAITechniques)
- [Oppsummering](../../../03-CoreGenerativeAITechniques)
- [Neste steg](../../../03-CoreGenerativeAITechniques)

## Forutsetninger

- Fullført oppsett fra [Kapittel 2](../../../02-SetupDevEnvironment)

## Komme i gang

1. **Naviger til eksempler**: 
```bash
cd 03-CoreGenerativeAITechniques/examples/
```
2. **Sett opp miljø**: 
```bash
export GITHUB_TOKEN=your_token_here
```
3. **Kompiler og kjør eksempler**:
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

## Oversikt over eksempler

Eksemplene er organisert i `examples/`-mappen med følgende struktur:

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

### 1. LLM Fullføringer og Chatflyt
**Fil**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Lær å bygge samtale-AI med strømmende svar og håndtering av samtalehistorikk.

Dette eksemplet demonstrerer:
- Enkel tekstfullføring med systemprompter
- Flersamtaler med historikkhåndtering
- Interaktive chatsesjoner
- Parameterkonfigurasjon (temperatur, maks tokens)

### 2. Funksjoner og Plugins med LLMs
**Fil**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Utvid AI-funksjonalitet ved å gi modeller tilgang til egendefinerte funksjoner og eksterne API-er.

Dette eksemplet demonstrerer:
- Integrasjon av værfunksjon
- Implementering av kalkulatorfunksjon  
- Flere funksjonskall i én samtale
- Funksjonsdefinisjon med JSON-skjemaer

### 3. Retrieval-Augmented Generation (RAG)
**Fil**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Lær hvordan du kombinerer AI med dine egne dokumenter og datakilder for nøyaktige, kontekstbevisste svar.

Dette eksemplet demonstrerer:
- Dokumentbasert spørsmål og svar med Azure OpenAI SDK
- Implementering av RAG-mønster med GitHub-modeller

**Bruk**: Still spørsmål om innholdet i `document.txt` og få AI-svar basert kun på den konteksten.

### 4. Demonstrasjon av Ansvarlig AI-sikkerhet
**Fil**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Få en forhåndsvisning av hvordan AI-sikkerhetstiltak fungerer ved å teste GitHub-modellers innholdsfiltreringskapabiliteter.

Dette eksemplet demonstrerer:
- Innholdsfiltrering for potensielt skadelige forespørsler
- Håndtering av sikkerhetssvar i applikasjoner
- Ulike kategorier av blokkert innhold (vold, hatprat, feilinformasjon)
- Riktig feilhåndtering for sikkerhetsbrudd

> **Lær mer**: Dette er bare en introduksjon til ansvarlige AI-konsepter. For mer informasjon om etikk, reduksjon av skjevheter, personvern og rammeverk for ansvarlig AI, se [Kapittel 5: Ansvarlig Generativ AI](../05-ResponsibleGenAI/README.md).

## Oppsummering

I dette kapittelet utforsket vi LLM fullføringer og chatflyt, implementerte funksjonskall for å forbedre AI-funksjonalitet, opprettet et Retrieval-Augmented Generation (RAG)-system, og demonstrerte ansvarlige AI-sikkerhetstiltak. 

> **NOTE**: Utforsk videre med den medfølgende [**Tutorial**](./TUTORIAL.md)

## Neste steg

[Kapittel 4: Praktiske applikasjoner og prosjekter](../04-PracticalSamples/README.md)

**Ansvarsfraskrivelse**:  
Dette dokumentet er oversatt ved hjelp av AI-oversettelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selv om vi streber etter nøyaktighet, vær oppmerksom på at automatiserte oversettelser kan inneholde feil eller unøyaktigheter. Det originale dokumentet på sitt opprinnelige språk bør anses som den autoritative kilden. For kritisk informasjon anbefales profesjonell menneskelig oversettelse. Vi er ikke ansvarlige for eventuelle misforståelser eller feiltolkninger som oppstår ved bruk av denne oversettelsen.