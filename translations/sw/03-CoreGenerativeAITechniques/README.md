<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T20:39:49+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "sw"
}
-->
# Mbinu Muhimu za AI Inayozalisha

>**Note**: Sura hii inajumuisha [**Mafunzo**](./TUTORIAL.md) ya kina yanayokuongoza jinsi ya kuendesha mifano iliyokamilika.

## Utakachojifunza
Katika sura hii, tunachunguza mbinu 4 muhimu za AI inayozalisha kupitia mifano ya vitendo:
- Kukamilisha maandishi na mtiririko wa mazungumzo kwa kutumia LLM
- Kuita kazi (function calling)
- Uzalishaji unaosaidiwa na urejeshaji (RAG)
- Hatua za usalama za AI inayowajibika

## Jedwali la Maudhui

- [Utakachojifunza](../../../03-CoreGenerativeAITechniques)
- [Mahitaji ya Awali](../../../03-CoreGenerativeAITechniques)
- [Kuanza](../../../03-CoreGenerativeAITechniques)
- [Muhtasari wa Mifano](../../../03-CoreGenerativeAITechniques)
  - [1. Kukamilisha Maandishi na Mtiririko wa Mazungumzo](../../../03-CoreGenerativeAITechniques)
  - [2. Kazi na Viongezeo na LLMs](../../../03-CoreGenerativeAITechniques)
  - [3. Uzalishaji Unaosaidiwa na Urejeshaji (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Maonyesho ya Usalama wa AI Inayowajibika](../../../03-CoreGenerativeAITechniques)
- [Muhtasari](../../../03-CoreGenerativeAITechniques)
- [Hatua Zifuatazo](../../../03-CoreGenerativeAITechniques)

## Mahitaji ya Awali

- Kukamilisha usanidi kutoka [Sura ya 2](../../../02-SetupDevEnvironment)

## Kuanza

1. **Tembelea mifano**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Weka mazingira**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Tunga na endesha mifano**:  
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

## Muhtasari wa Mifano

Mifano imepangwa katika folda ya `examples/` yenye muundo ufuatao:

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

### 1. Kukamilisha Maandishi na Mtiririko wa Mazungumzo
**Faili**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Jifunze jinsi ya kujenga AI ya mazungumzo kwa majibu ya mtiririko na usimamizi wa historia ya mazungumzo.

Mfano huu unaonyesha:
- Kukamilisha maandishi kwa kutumia maelekezo ya mfumo
- Mazungumzo ya mizunguko mingi na usimamizi wa historia
- Vipindi vya mazungumzo vya kuingiliana
- Usanidi wa vigezo (joto, idadi ya tokeni za juu)

### 2. Kazi na Viongezeo na LLMs
**Faili**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Panua uwezo wa AI kwa kuipa mifano ufikiaji wa kazi maalum na API za nje.

Mfano huu unaonyesha:
- Ujumuishaji wa kazi ya hali ya hewa
- Utekelezaji wa kazi ya kikokotoo  
- Kuita kazi nyingi katika mazungumzo moja
- Ufafanuzi wa kazi kwa kutumia miundo ya JSON

### 3. Uzalishaji Unaosaidiwa na Urejeshaji (RAG)
**Faili**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Jifunze jinsi ya kuchanganya AI na nyaraka zako na vyanzo vya data kwa majibu sahihi na yenye muktadha.

Mfano huu unaonyesha:
- Kujibu maswali kwa msingi wa nyaraka kwa kutumia Azure OpenAI SDK
- Utekelezaji wa muundo wa RAG na GitHub Models

**Matumizi**: Uliza maswali kuhusu yaliyomo kwenye `document.txt` na upate majibu ya AI yanayotegemea muktadha huo pekee.

### 4. Maonyesho ya Usalama wa AI Inayowajibika
**Faili**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Pata muhtasari wa jinsi hatua za usalama wa AI zinavyofanya kazi kwa kujaribu uwezo wa kuchuja maudhui wa GitHub Models.

Mfano huu unaonyesha:
- Kuchuja maudhui kwa maelekezo yanayoweza kuwa hatari
- Kushughulikia majibu ya usalama katika programu
- Aina tofauti za maudhui yaliyopigwa marufuku (vurugu, hotuba ya chuki, taarifa potofu)
- Kushughulikia makosa ipasavyo kwa ukiukaji wa usalama

> **Jifunze Zaidi**: Hii ni utangulizi tu wa dhana za AI inayowajibika. Kwa maelezo zaidi kuhusu maadili, kupunguza upendeleo, masuala ya faragha, na mifumo ya AI inayowajibika, angalia [Sura ya 5: AI Inayozalisha kwa Uwajibikaji](../05-ResponsibleGenAI/README.md).

## Muhtasari

Katika sura hii, tulichunguza kukamilisha maandishi na mtiririko wa mazungumzo kwa kutumia LLM, kutekeleza kuita kazi ili kuongeza uwezo wa AI, kuunda mfumo wa Uzalishaji Unaosaidiwa na Urejeshaji (RAG), na kuonyesha hatua za usalama wa AI inayowajibika.

> **NOTE**: Chunguza zaidi kwa kutumia [**Mafunzo**](./TUTORIAL.md)

## Hatua Zifuatazo

[Sura ya 4: Matumizi ya Vitendo na Miradi](../04-PracticalSamples/README.md)

**Kanusho**:  
Hati hii imetafsiriwa kwa kutumia huduma ya tafsiri ya AI [Co-op Translator](https://github.com/Azure/co-op-translator). Ingawa tunajitahidi kuhakikisha usahihi, tafadhali fahamu kuwa tafsiri za kiotomatiki zinaweza kuwa na makosa au kutokuwa sahihi. Hati ya asili katika lugha yake ya awali inapaswa kuzingatiwa kama chanzo cha mamlaka. Kwa taarifa muhimu, tafsiri ya kitaalamu ya binadamu inapendekezwa. Hatutawajibika kwa kutoelewana au tafsiri zisizo sahihi zinazotokana na matumizi ya tafsiri hii.