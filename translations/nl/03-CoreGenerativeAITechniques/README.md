<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T09:43:28+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "nl"
}
-->
# Kerntechnieken voor Generatieve AI

>**Opmerking**: Dit hoofdstuk bevat een gedetailleerde [**Tutorial**](./TUTORIAL.md) die je door de voorbeelden leidt.

## Wat Je Gaat Leren
In dit hoofdstuk bekijken we 4 kerntechnieken van generatieve AI aan de hand van praktische voorbeelden:
- LLM-voltooiingen en chatflows
- Functieaanroepen
- Retrieval-Augmented Generation (RAG)
- Veiligheidsmaatregelen voor verantwoorde AI

## Inhoudsopgave

- [Wat Je Gaat Leren](../../../03-CoreGenerativeAITechniques)
- [Vereisten](../../../03-CoreGenerativeAITechniques)
- [Aan de Slag](../../../03-CoreGenerativeAITechniques)
- [Overzicht van Voorbeelden](../../../03-CoreGenerativeAITechniques)
  - [1. LLM-voltooiingen en Chatflows](../../../03-CoreGenerativeAITechniques)
  - [2. Functies & Plugins met LLM's](../../../03-CoreGenerativeAITechniques)
  - [3. Retrieval-Augmented Generation (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Demonstratie van Verantwoorde AI Veiligheid](../../../03-CoreGenerativeAITechniques)
- [Samenvatting](../../../03-CoreGenerativeAITechniques)
- [Volgende Stappen](../../../03-CoreGenerativeAITechniques)

## Vereisten

- Voltooi de setup uit [Hoofdstuk 2](../../../02-SetupDevEnvironment)

## Aan de Slag

1. **Navigeer naar voorbeelden**: 
```bash
cd 03-CoreGenerativeAITechniques/examples/
```
2. **Stel de omgeving in**: 
```bash
export GITHUB_TOKEN=your_token_here
```
3. **Compileer en voer de voorbeelden uit**:
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

## Overzicht van Voorbeelden

De voorbeelden zijn georganiseerd in de map `examples/` met de volgende structuur:

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

### 1. LLM-voltooiingen en Chatflows
**Bestand**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Leer hoe je conversatie-AI kunt bouwen met streaming-antwoorden en chatgeschiedenisbeheer.

Dit voorbeeld laat zien:
- Eenvoudige tekstvoltooiing met systeemaanwijzingen
- Gesprekken met meerdere beurten en geschiedenisbeheer
- Interactieve chatsessies
- Configuratie van parameters (temperatuur, maximaal aantal tokens)

### 2. Functies & Plugins met LLM's
**Bestand**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Breid de mogelijkheden van AI uit door modellen toegang te geven tot aangepaste functies en externe API's.

Dit voorbeeld laat zien:
- Integratie van een weerfunctie
- Implementatie van een rekenmachinefunctie  
- Meerdere functieaanroepen in één gesprek
- Functiedefinitie met JSON-schema's

### 3. Retrieval-Augmented Generation (RAG)
**Bestand**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Leer hoe je AI kunt combineren met je eigen documenten en gegevensbronnen voor nauwkeurige, contextbewuste antwoorden.

Dit voorbeeld laat zien:
- Vraag-en-antwoord op basis van documenten met de Azure OpenAI SDK
- Implementatie van het RAG-patroon met GitHub-modellen

**Gebruik**: Stel vragen over de inhoud van `document.txt` en ontvang AI-antwoorden die uitsluitend op die context zijn gebaseerd.

### 4. Demonstratie van Verantwoorde AI Veiligheid
**Bestand**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Krijg een voorproefje van hoe veiligheidsmaatregelen in AI werken door de contentfiltermogelijkheden van GitHub-modellen te testen.

Dit voorbeeld laat zien:
- Contentfiltering voor mogelijk schadelijke prompts
- Afhandeling van veiligheidsreacties in applicaties
- Verschillende categorieën van geblokkeerde inhoud (geweld, haatzaaiende uitlatingen, desinformatie)
- Correcte foutafhandeling bij veiligheidsinbreuken

> **Meer Weten**: Dit is slechts een introductie tot concepten van verantwoorde AI. Voor meer informatie over ethiek, het verminderen van vooroordelen, privacyoverwegingen en kaders voor verantwoorde AI, zie [Hoofdstuk 5: Verantwoorde Generatieve AI](../05-ResponsibleGenAI/README.md).

## Samenvatting

In dit hoofdstuk hebben we LLM-voltooiingen en chatflows verkend, functieaanroepen geïmplementeerd om AI-mogelijkheden uit te breiden, een Retrieval-Augmented Generation (RAG)-systeem gecreëerd en veiligheidsmaatregelen voor verantwoorde AI gedemonstreerd. 

> **Opmerking**: Verdiep je verder met de meegeleverde [**Tutorial**](./TUTORIAL.md)

## Volgende Stappen

[Hoofdstuk 4: Praktische Toepassingen & Projecten](../04-PracticalSamples/README.md)

**Disclaimer**:  
Dit document is vertaald met behulp van de AI-vertalingsservice [Co-op Translator](https://github.com/Azure/co-op-translator). Hoewel we streven naar nauwkeurigheid, dient u zich ervan bewust te zijn dat geautomatiseerde vertalingen fouten of onnauwkeurigheden kunnen bevatten. Het originele document in de oorspronkelijke taal moet worden beschouwd als de gezaghebbende bron. Voor cruciale informatie wordt professionele menselijke vertaling aanbevolen. Wij zijn niet aansprakelijk voor eventuele misverstanden of verkeerde interpretaties die voortvloeien uit het gebruik van deze vertaling.