<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T19:13:51+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "tl"
}
-->
# Mga Pangunahing Teknik sa Generative AI

>**Note**: Kasama sa kabanatang ito ang detalyadong [**Tutorial**](./TUTORIAL.md) na gagabay sa iyo sa pagpapatakbo ng mga natapos na halimbawa.

## Ano ang Matututuhan Mo
Sa kabanatang ito, tatalakayin natin ang 4 na pangunahing teknik sa generative AI gamit ang mga praktikal na halimbawa:
- LLM completions at chat flows
- Function calling
- Retrieval-Augmented Generation (RAG)
- Mga hakbang para sa ligtas at responsableng AI

## Talaan ng Nilalaman

- [Ano ang Matututuhan Mo](../../../03-CoreGenerativeAITechniques)
- [Mga Kinakailangan](../../../03-CoreGenerativeAITechniques)
- [Pagsisimula](../../../03-CoreGenerativeAITechniques)
- [Pangkalahatang-ideya ng mga Halimbawa](../../../03-CoreGenerativeAITechniques)
  - [1. LLM Completions at Chat Flows](../../../03-CoreGenerativeAITechniques)
  - [2. Mga Function at Plugin gamit ang LLMs](../../../03-CoreGenerativeAITechniques)
  - [3. Retrieval-Augmented Generation (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Demonstrasyon ng Ligtas at Responsableng AI](../../../03-CoreGenerativeAITechniques)
- [Buod](../../../03-CoreGenerativeAITechniques)
- [Mga Susunod na Hakbang](../../../03-CoreGenerativeAITechniques)

## Mga Kinakailangan

- Natapos na ang setup mula sa [Kabanata 2](../../../02-SetupDevEnvironment)

## Pagsisimula

1. **Pumunta sa mga halimbawa**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```
2. **I-set ang environment**:  
```bash
export GITHUB_TOKEN=your_token_here
```
3. **I-compile at patakbuhin ang mga halimbawa**:  
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

## Pangkalahatang-ideya ng mga Halimbawa

Ang mga halimbawa ay nakaayos sa folder na `examples/` na may ganitong istruktura:

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

### 1. LLM Completions at Chat Flows
**File**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Matutong bumuo ng conversational AI na may streaming responses at chat history management.

Ipinapakita ng halimbawang ito:
- Simpleng text completion gamit ang system prompts
- Multi-turn na pag-uusap na may history management
- Interactive na chat sessions
- Pag-configure ng mga parameter (temperature, max tokens)

### 2. Mga Function at Plugin gamit ang LLMs
**File**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Palawakin ang kakayahan ng AI sa pamamagitan ng pagbibigay ng access sa mga custom function at external APIs.

Ipinapakita ng halimbawang ito:
- Integrasyon ng weather function
- Implementasyon ng calculator function  
- Maramihang function calls sa isang pag-uusap
- Pagde-define ng function gamit ang JSON schemas

### 3. Retrieval-Augmented Generation (RAG)
**File**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Matutong pagsamahin ang AI sa sarili mong mga dokumento at data sources para sa mas tumpak at may kontekstong mga sagot.

Ipinapakita ng halimbawang ito:
- Pagsagot ng mga tanong batay sa dokumento gamit ang Azure OpenAI SDK
- Implementasyon ng RAG pattern gamit ang GitHub Models

**Paggamit**: Magtanong tungkol sa nilalaman ng `document.txt` at makakuha ng mga sagot mula sa AI na nakabatay lamang sa kontekstong iyon.

### 4. Demonstrasyon ng Ligtas at Responsableng AI
**File**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Makakuha ng preview kung paano gumagana ang mga hakbang sa kaligtasan ng AI sa pamamagitan ng pagsubok sa content filtering capabilities ng GitHub Models.

Ipinapakita ng halimbawang ito:
- Pag-filter ng nilalaman para sa mga posibleng mapanganib na prompts
- Paghawak ng mga safety response sa mga aplikasyon
- Iba't ibang kategorya ng mga na-block na nilalaman (karahasan, hate speech, maling impormasyon)
- Wastong error handling para sa mga paglabag sa kaligtasan

> **Matuto Pa**: Panimula lamang ito sa mga konsepto ng responsableng AI. Para sa karagdagang impormasyon tungkol sa etika, bias mitigation, privacy considerations, at mga framework ng responsableng AI, tingnan ang [Kabanata 5: Responsableng Generative AI](../05-ResponsibleGenAI/README.md).

## Buod

Sa kabanatang ito, tinalakay natin ang LLM completions at chat flows, ipinatupad ang function calling para mapahusay ang kakayahan ng AI, lumikha ng Retrieval-Augmented Generation (RAG) system, at nagpakita ng mga hakbang para sa ligtas at responsableng AI.

> **NOTE**: Mas malalim na talakayin gamit ang ibinigay na [**Tutorial**](./TUTORIAL.md)

## Mga Susunod na Hakbang

[Kabanata 4: Mga Praktikal na Aplikasyon at Proyekto](../04-PracticalSamples/README.md)

**Paunawa**:  
Ang dokumentong ito ay isinalin gamit ang AI translation service na [Co-op Translator](https://github.com/Azure/co-op-translator). Bagama't sinisikap naming maging tumpak, pakitandaan na ang mga awtomatikong pagsasalin ay maaaring maglaman ng mga pagkakamali o hindi pagkakatugma. Ang orihinal na dokumento sa kanyang katutubong wika ang dapat ituring na opisyal na pinagmulan. Para sa mahalagang impormasyon, inirerekomenda ang propesyonal na pagsasalin ng tao. Hindi kami mananagot sa anumang hindi pagkakaunawaan o maling interpretasyon na dulot ng paggamit ng pagsasaling ito.