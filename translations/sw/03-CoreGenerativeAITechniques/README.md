<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T09:56:11+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "sw"
}
-->
# Mbinu Muhimu za AI ya Kizazi

>**Note**: Sura hii inajumuisha [**Mafunzo**](./TUTORIAL.md) ya kina yanayokuongoza kupitia mifano.

## Utakachojifunza
Katika sura hii, tunachunguza mbinu 4 muhimu za AI ya kizazi kupitia mifano ya vitendo:
- Kukamilisha LLM na mtiririko wa mazungumzo
- Kuita kazi
- Uzalishaji unaosaidiwa na Urejeshaji (RAG)
- Hatua za usalama za AI inayowajibika

## Jedwali la Maudhui

- [Utakachojifunza](../../../03-CoreGenerativeAITechniques)
- [Mahitaji ya Awali](../../../03-CoreGenerativeAITechniques)
- [Kuanza](../../../03-CoreGenerativeAITechniques)
- [Muhtasari wa Mifano](../../../03-CoreGenerativeAITechniques)
  - [1. Kukamilisha LLM na Mtiririko wa Mazungumzo](../../../03-CoreGenerativeAITechniques)
  - [2. Kazi & Viongezeo na LLMs](../../../03-CoreGenerativeAITechniques)
  - [3. Uzalishaji Unaosaidiwa na Urejeshaji (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Maonyesho ya Usalama wa AI Inayowajibika](../../../03-CoreGenerativeAITechniques)
- [Muhtasari](../../../03-CoreGenerativeAITechniques)
- [Hatua Zifuatazo](../../../03-CoreGenerativeAITechniques)

## Mahitaji ya Awali

- Umekamilisha usanidi kutoka [Sura ya 2](../../../02-SetupDevEnvironment)

## Kuanza

1. **Elekea kwenye mifano**:  
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

Mifano imepangwa katika folda ya `examples/` na muundo ufuatao:

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

### 1. Kukamilisha LLM na Mtiririko wa Mazungumzo
**Faili**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Jifunze kujenga AI ya mazungumzo na majibu ya mtiririko na usimamizi wa historia ya mazungumzo.

Mfano huu unaonyesha:
- Kukamilisha maandishi rahisi kwa kutumia maelekezo ya mfumo
- Mazungumzo ya mizunguko mingi na usimamizi wa historia
- Vipindi vya mazungumzo vya mwingiliano
- Usanidi wa vigezo (joto, idadi ya juu ya tokeni)

### 2. Kazi & Viongezeo na LLMs
**Faili**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Panua uwezo wa AI kwa kuipa mifano ufikiaji wa kazi maalum na API za nje.

Mfano huu unaonyesha:
- Muunganisho wa kazi ya hali ya hewa
- Utekelezaji wa kazi ya kikokotoo  
- Miito mingi ya kazi katika mazungumzo moja
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
- Kuchuja maudhui kwa maelekezo yanayoweza kuwa hatarishi
- Kushughulikia majibu ya usalama katika programu
- Makundi tofauti ya maudhui yaliyofungiwa (vurugu, hotuba ya chuki, taarifa potofu)
- Kushughulikia makosa ipasavyo kwa ukiukaji wa usalama

> **Jifunze Zaidi**: Hii ni utangulizi tu wa dhana za AI inayowajibika. Kwa maelezo zaidi kuhusu maadili, kupunguza upendeleo, masuala ya faragha, na mifumo ya AI inayowajibika, angalia [Sura ya 5: AI ya Kizazi Inayowajibika](../05-ResponsibleGenAI/README.md).

## Muhtasari

Katika sura hii, tulichunguza kukamilisha LLM na mtiririko wa mazungumzo, kutekeleza miito ya kazi ili kuongeza uwezo wa AI, kuunda mfumo wa Uzalishaji Unaosaidiwa na Urejeshaji (RAG), na kuonyesha hatua za usalama wa AI inayowajibika.

> **NOTE**: Chunguza zaidi kwa kutumia [**Mafunzo**](./TUTORIAL.md)

## Hatua Zifuatazo

[Sura ya 4: Matumizi ya Vitendo & Miradi](../04-PracticalSamples/README.md)

**Kanusho**:  
Hati hii imetafsiriwa kwa kutumia huduma ya kutafsiri ya AI [Co-op Translator](https://github.com/Azure/co-op-translator). Ingawa tunajitahidi kuhakikisha usahihi, tafadhali fahamu kuwa tafsiri za kiotomatiki zinaweza kuwa na makosa au kutokuwa sahihi. Hati ya asili katika lugha yake ya awali inapaswa kuzingatiwa kama chanzo cha mamlaka. Kwa taarifa muhimu, tafsiri ya kitaalamu ya binadamu inapendekezwa. Hatutawajibika kwa kutoelewana au tafsiri zisizo sahihi zinazotokana na matumizi ya tafsiri hii.