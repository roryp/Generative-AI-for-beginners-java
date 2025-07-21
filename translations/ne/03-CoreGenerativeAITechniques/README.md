<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T17:40:15+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "ne"
}
-->
# कोर जेनेरेटिभ एआई प्रविधिहरू

>**Note**: यो अध्यायमा तयार गरिएका नमूनाहरू चलाउन मार्गदर्शन गर्ने विस्तृत [**Tutorial**](./TUTORIAL.md) समावेश छ।

## तपाईंले के सिक्नुहुनेछ
यस अध्यायमा, हामी ४ वटा कोर जेनेरेटिभ एआई प्रविधिहरूलाई व्यावहारिक उदाहरणहरू मार्फत हेर्नेछौं:
- LLM कम्प्लिसन र च्याट फ्लोहरू
- फङ्सन कलिङ
- रिट्रिभल-अग्मेन्टेड जेनेरेसन (RAG)
- जिम्मेवार एआई सुरक्षा उपायहरू

## सामग्री सूची

- [तपाईंले के सिक्नुहुनेछ](../../../03-CoreGenerativeAITechniques)
- [पूर्वआवश्यकताहरू](../../../03-CoreGenerativeAITechniques)
- [सुरु गरौं](../../../03-CoreGenerativeAITechniques)
- [उदाहरणहरूको अवलोकन](../../../03-CoreGenerativeAITechniques)
  - [१. LLM कम्प्लिसन र च्याट फ्लोहरू](../../../03-CoreGenerativeAITechniques)
  - [२. LLM हरूसँग फङ्सन र प्लगइनहरू](../../../03-CoreGenerativeAITechniques)
  - [३. रिट्रिभल-अग्मेन्टेड जेनेरेसन (RAG)](../../../03-CoreGenerativeAITechniques)
  - [४. जिम्मेवार एआई सुरक्षा प्रदर्शन](../../../03-CoreGenerativeAITechniques)
- [सारांश](../../../03-CoreGenerativeAITechniques)
- [अर्को कदम](../../../03-CoreGenerativeAITechniques)

## पूर्वआवश्यकताहरू

- [अध्याय २](../../../02-SetupDevEnvironment) बाट सेटअप पूरा गर्नुहोस्।

## सुरु गरौं

1. **उदाहरणहरूमा जानुहोस्**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **पर्यावरण सेट गर्नुहोस्**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **उदाहरणहरू कम्पाइल र चलाउनुहोस्**:  
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

## उदाहरणहरूको अवलोकन

उदाहरणहरू `examples/` फोल्डरमा निम्न संरचनासहित व्यवस्थित छन्:

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

### १. LLM कम्प्लिसन र च्याट फ्लोहरू
**फाइल**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

स्ट्रीमिङ प्रतिक्रियाहरू र च्याट इतिहास व्यवस्थापनको साथ संवादात्मक एआई निर्माण गर्न सिक्नुहोस्।

यस उदाहरणले प्रदर्शन गर्दछ:
- सिस्टम प्रम्प्टहरूसँग साधारण टेक्स्ट कम्प्लिसन
- इतिहास व्यवस्थापनसहितको बहु-वार्ता
- अन्तरक्रियात्मक च्याट सत्रहरू
- प्यारामिटर कन्फिगरेसन (temperature, max tokens)

### २. LLM हरूसँग फङ्सन र प्लगइनहरू
**फाइल**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

कस्टम फङ्सन र बाह्य API हरूसम्म पहुँच दिएर एआई क्षमताहरू विस्तार गर्नुहोस्।

यस उदाहरणले प्रदर्शन गर्दछ:
- मौसम फङ्सन एकीकरण
- क्याल्कुलेटर फङ्सन कार्यान्वयन  
- एउटै वार्तामा धेरै फङ्सन कलहरू
- JSON स्किमाहरूको साथ फङ्सन परिभाषा

### ३. रिट्रिभल-अग्मेन्टेड जेनेरेसन (RAG)
**फाइल**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

सटीक, सन्दर्भ-सचेत प्रतिक्रियाहरूको लागि एआईलाई आफ्नै कागजात र डाटा स्रोतहरूसँग संयोजन गर्न सिक्नुहोस्।

यस उदाहरणले प्रदर्शन गर्दछ:
- Azure OpenAI SDK को साथ कागजात-आधारित प्रश्न उत्तर
- GitHub Models को साथ RAG ढाँचा कार्यान्वयन

**प्रयोग**: `document.txt` को सामग्रीबारे प्रश्न सोध्नुहोस् र त्यस सन्दर्भमा आधारित एआई प्रतिक्रियाहरू प्राप्त गर्नुहोस्।

### ४. जिम्मेवार एआई सुरक्षा प्रदर्शन
**फाइल**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

GitHub Models को सामग्री फिल्टरिङ क्षमताहरू परीक्षण गरेर एआई सुरक्षा उपायहरूको पूर्वावलोकन प्राप्त गर्नुहोस्।

यस उदाहरणले प्रदर्शन गर्दछ:
- सम्भावित हानिकारक प्रम्प्टहरूको लागि सामग्री फिल्टरिङ
- अनुप्रयोगहरूमा सुरक्षा प्रतिक्रिया व्यवस्थापन
- अवरोधित सामग्रीका विभिन्न कोटीहरू (हिंसा, घृणा भाषण, गलत सूचना)
- सुरक्षा उल्लङ्घनहरूको लागि उचित त्रुटि व्यवस्थापन

> **थप जान्नुहोस्**: यो जिम्मेवार एआई अवधारणाहरूको मात्र परिचय हो। नैतिकता, पूर्वाग्रह न्यूनीकरण, गोपनीयता विचारहरू, र जिम्मेवार एआई फ्रेमवर्कहरूको बारेमा थप जानकारीको लागि [अध्याय ५: जिम्मेवार जेनेरेटिभ एआई](../05-ResponsibleGenAI/README.md) हेर्नुहोस्।

## सारांश

यस अध्यायमा, हामीले LLM कम्प्लिसन र च्याट फ्लोहरू अन्वेषण गर्यौं, एआई क्षमताहरू बढाउन फङ्सन कलिङ कार्यान्वयन गर्यौं, रिट्रिभल-अग्मेन्टेड जेनेरेसन (RAG) प्रणाली सिर्जना गर्यौं, र जिम्मेवार एआई सुरक्षा उपायहरूको प्रदर्शन गर्यौं।

> **NOTE**: प्रदान गरिएको [**Tutorial**](./TUTORIAL.md) को साथ अझ गहिराइमा जानुहोस्।

## अर्को कदम

[अध्याय ४: व्यावहारिक अनुप्रयोगहरू र परियोजनाहरू](../04-PracticalSamples/README.md)

**अस्वीकरण**:  
यो दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) प्रयोग गरेर अनुवाद गरिएको छ। हामी शुद्धताको लागि प्रयास गर्छौं, तर कृपया ध्यान दिनुहोस् कि स्वचालित अनुवादमा त्रुटिहरू वा अशुद्धताहरू हुन सक्छ। यसको मूल भाषा मा रहेको मूल दस्तावेज़लाई आधिकारिक स्रोत मानिनुपर्छ। महत्वपूर्ण जानकारीको लागि, व्यावसायिक मानव अनुवाद सिफारिस गरिन्छ। यस अनुवादको प्रयोगबाट उत्पन्न हुने कुनै पनि गलतफहमी वा गलत व्याख्याको लागि हामी जिम्मेवार हुने छैनौं।