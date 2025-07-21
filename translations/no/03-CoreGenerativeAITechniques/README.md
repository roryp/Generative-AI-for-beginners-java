<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T19:11:47+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "no"
}
-->
# Kjerneprinsipper for Generativ AI

>**Merk**: Dette kapittelet inkluderer en detaljert [**Veiledning**](./TUTORIAL.md) som gir deg trinnvis instruksjon for å kjøre de ferdige eksemplene.

## Hva Du Vil Lære
I dette kapittelet ser vi på 4 sentrale teknikker innen generativ AI gjennom praktiske eksempler:
- LLM-fullføringer og samtaleflyter
- Funksjonskall
- Retrieval-Augmented Generation (RAG)
- Ansvarlige AI-sikkerhetstiltak

## Innholdsfortegnelse

- [Hva Du Vil Lære](../../../03-CoreGenerativeAITechniques)
- [Forutsetninger](../../../03-CoreGenerativeAITechniques)
- [Kom i Gang](../../../03-CoreGenerativeAITechniques)
- [Oversikt over Eksempler](../../../03-CoreGenerativeAITechniques)
  - [1. LLM-fullføringer og Samtaleflyter](../../../03-CoreGenerativeAITechniques)
  - [2. Funksjoner og Plugins med LLM-er](../../../03-CoreGenerativeAITechniques)
  - [3. Retrieval-Augmented Generation (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Demonstrasjon av Ansvarlige AI-sikkerhetstiltak](../../../03-CoreGenerativeAITechniques)
- [Oppsummering](../../../03-CoreGenerativeAITechniques)
- [Neste Steg](../../../03-CoreGenerativeAITechniques)

## Forutsetninger

- Fullført oppsett fra [Kapittel 2](../../../02-SetupDevEnvironment)

## Kom i Gang

1. **Naviger til eksempler**: 
```bash
cd 03-CoreGenerativeAITechniques/examples/
```
2. **Sett opp miljøet**: 
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

## Oversikt over Eksempler

Eksemplene er organisert i mappen `examples/` med følgende struktur:

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

### 1. LLM-fullføringer og Samtaleflyter
**Fil**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Lær å bygge samtale-AI med strømmende svar og håndtering av samtalehistorikk.

Dette eksemplet viser:
- Enkel tekstfullføring med systemprompter
- Flersidige samtaler med historikkhåndtering
- Interaktive samtalesesjoner
- Konfigurasjon av parametere (temperatur, maks antall tokens)

### 2. Funksjoner og Plugins med LLM-er
**Fil**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Utvid AI-funksjonalitet ved å gi modeller tilgang til egendefinerte funksjoner og eksterne API-er.

Dette eksemplet viser:
- Integrasjon av værfunksjon
- Implementering av kalkulatorfunksjon  
- Flere funksjonskall i én samtale
- Funksjonsdefinisjon med JSON-skjemaer

### 3. Retrieval-Augmented Generation (RAG)
**Fil**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Lær hvordan du kombinerer AI med dine egne dokumenter og datakilder for nøyaktige, kontekstbevisste svar.

Dette eksemplet viser:
- Spørsmål-svar basert på dokumenter med Azure OpenAI SDK
- Implementering av RAG-mønster med GitHub-modeller

**Bruk**: Still spørsmål om innholdet i `document.txt` og få AI-svar basert kun på den konteksten.

### 4. Demonstrasjon av Ansvarlige AI-sikkerhetstiltak
**Fil**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Få en forhåndsvisning av hvordan AI-sikkerhetstiltak fungerer ved å teste GitHub-modellers innholdsfiltreringskapabiliteter.

Dette eksemplet viser:
- Innholdsfiltrering for potensielt skadelige forespørsler
- Håndtering av sikkerhetssvar i applikasjoner
- Ulike kategorier av blokkert innhold (vold, hatprat, feilinformasjon)
- Riktig feilhåndtering ved sikkerhetsbrudd

> **Lær Mer**: Dette er bare en introduksjon til ansvarlige AI-konsepter. For mer informasjon om etikk, reduksjon av skjevheter, personvern og rammeverk for ansvarlig AI, se [Kapittel 5: Ansvarlig Generativ AI](../05-ResponsibleGenAI/README.md).

## Oppsummering

I dette kapittelet utforsket vi LLM-fullføringer og samtaleflyter, implementerte funksjonskall for å utvide AI-funksjonalitet, opprettet et Retrieval-Augmented Generation (RAG)-system, og demonstrerte ansvarlige AI-sikkerhetstiltak. 

> **MERK**: Gå dypere med den medfølgende [**Veiledningen**](./TUTORIAL.md)

## Neste Steg

[Kapittel 4: Praktiske Applikasjoner og Prosjekter](../04-PracticalSamples/README.md)

**Ansvarsfraskrivelse**:  
Dette dokumentet er oversatt ved hjelp av AI-oversettelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selv om vi streber etter nøyaktighet, vær oppmerksom på at automatiserte oversettelser kan inneholde feil eller unøyaktigheter. Det originale dokumentet på sitt opprinnelige språk bør anses som den autoritative kilden. For kritisk informasjon anbefales profesjonell menneskelig oversettelse. Vi er ikke ansvarlige for eventuelle misforståelser eller feiltolkninger som oppstår ved bruk av denne oversettelsen.