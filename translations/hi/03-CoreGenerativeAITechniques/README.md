<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T09:08:00+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "hi"
}
-->
# कोर जनरेटिव एआई तकनीकें

>**नोट**: इस अध्याय में एक विस्तृत [**ट्यूटोरियल**](./TUTORIAL.md) शामिल है, जो आपको उदाहरणों के माध्यम से मार्गदर्शन करता है।

## आप क्या सीखेंगे
इस अध्याय में, हम 4 मुख्य जनरेटिव एआई तकनीकों को व्यावहारिक उदाहरणों के माध्यम से देखेंगे:
- LLM कंप्लीशन और चैट फ्लो
- फंक्शन कॉलिंग
- रिट्रीवल-ऑगमेंटेड जेनरेशन (RAG)
- जिम्मेदार एआई सुरक्षा उपाय

## विषय सूची

- [आप क्या सीखेंगे](../../../03-CoreGenerativeAITechniques)
- [पूर्वापेक्षाएँ](../../../03-CoreGenerativeAITechniques)
- [शुरुआत करें](../../../03-CoreGenerativeAITechniques)
- [उदाहरणों का अवलोकन](../../../03-CoreGenerativeAITechniques)
  - [1. LLM कंप्लीशन और चैट फ्लो](../../../03-CoreGenerativeAITechniques)
  - [2. LLMs के साथ फंक्शन और प्लगइन्स](../../../03-CoreGenerativeAITechniques)
  - [3. रिट्रीवल-ऑगमेंटेड जेनरेशन (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. जिम्मेदार एआई सुरक्षा प्रदर्शन](../../../03-CoreGenerativeAITechniques)
- [सारांश](../../../03-CoreGenerativeAITechniques)
- [अगले कदम](../../../03-CoreGenerativeAITechniques)

## पूर्वापेक्षाएँ

- [अध्याय 2](../../../02-SetupDevEnvironment) से सेटअप पूरा किया हो।

## शुरुआत करें

1. **उदाहरणों पर जाएं**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **पर्यावरण सेट करें**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **उदाहरणों को संकलित और चलाएं**:  
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

## उदाहरणों का अवलोकन

उदाहरण `examples/` फोल्डर में निम्नलिखित संरचना के साथ व्यवस्थित हैं:

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

### 1. LLM कंप्लीशन और चैट फ्लो
**फ़ाइल**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

स्ट्रीमिंग प्रतिक्रियाओं और चैट इतिहास प्रबंधन के साथ संवादात्मक एआई बनाना सीखें।

इस उदाहरण में शामिल है:
- सिस्टम प्रॉम्प्ट के साथ सरल टेक्स्ट कंप्लीशन
- इतिहास प्रबंधन के साथ मल्टी-टर्न वार्तालाप
- इंटरएक्टिव चैट सत्र
- पैरामीटर कॉन्फ़िगरेशन (टेम्परेचर, मैक्स टोकन्स)

### 2. LLMs के साथ फंक्शन और प्लगइन्स
**फ़ाइल**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

मॉडलों को कस्टम फंक्शन और बाहरी APIs तक पहुंच देकर एआई क्षमताओं को बढ़ाएं।

इस उदाहरण में शामिल है:
- वेदर फंक्शन इंटीग्रेशन
- कैलकुलेटर फंक्शन का कार्यान्वयन  
- एक वार्तालाप में कई फंक्शन कॉल
- JSON स्कीमाओं के साथ फंक्शन परिभाषा

### 3. रिट्रीवल-ऑगमेंटेड जेनरेशन (RAG)
**फ़ाइल**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

सटीक, संदर्भ-सचेत प्रतिक्रियाओं के लिए एआई को अपने दस्तावेज़ों और डेटा स्रोतों के साथ जोड़ना सीखें।

इस उदाहरण में शामिल है:
- Azure OpenAI SDK के साथ दस्तावेज़-आधारित प्रश्नोत्तर
- GitHub मॉडल्स के साथ RAG पैटर्न का कार्यान्वयन

**उपयोग**: `document.txt` की सामग्री के बारे में प्रश्न पूछें और केवल उस संदर्भ के आधार पर एआई प्रतिक्रियाएँ प्राप्त करें।

### 4. जिम्मेदार एआई सुरक्षा प्रदर्शन
**फ़ाइल**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

GitHub मॉडल्स की सामग्री फ़िल्टरिंग क्षमताओं का परीक्षण करके एआई सुरक्षा उपायों का पूर्वावलोकन प्राप्त करें।

इस उदाहरण में शामिल है:
- संभावित हानिकारक प्रॉम्प्ट के लिए सामग्री फ़िल्टरिंग
- अनुप्रयोगों में सुरक्षा प्रतिक्रिया प्रबंधन
- अवरुद्ध सामग्री की विभिन्न श्रेणियाँ (हिंसा, घृणास्पद भाषण, गलत जानकारी)
- सुरक्षा उल्लंघनों के लिए उचित त्रुटि प्रबंधन

> **अधिक जानें**: यह जिम्मेदार एआई अवधारणाओं का केवल एक परिचय है। नैतिकता, पूर्वाग्रह शमन, गोपनीयता विचार, और जिम्मेदार एआई फ्रेमवर्क पर अधिक जानकारी के लिए, [अध्याय 5: जिम्मेदार जनरेटिव एआई](../05-ResponsibleGenAI/README.md) देखें।

## सारांश

इस अध्याय में, हमने LLM कंप्लीशन और चैट फ्लो का अन्वेषण किया, एआई क्षमताओं को बढ़ाने के लिए फंक्शन कॉलिंग को लागू किया, एक रिट्रीवल-ऑगमेंटेड जेनरेशन (RAG) सिस्टम बनाया, और जिम्मेदार एआई सुरक्षा उपायों का प्रदर्शन किया।

> **नोट**: प्रदान किए गए [**ट्यूटोरियल**](./TUTORIAL.md) के साथ गहराई से जानें।

## अगले कदम

[अध्याय 4: व्यावहारिक अनुप्रयोग और प्रोजेक्ट्स](../04-PracticalSamples/README.md)

**अस्वीकरण**:  
यह दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) का उपयोग करके अनुवादित किया गया है। जबकि हम सटीकता सुनिश्चित करने का प्रयास करते हैं, कृपया ध्यान दें कि स्वचालित अनुवाद में त्रुटियां या अशुद्धियां हो सकती हैं। मूल भाषा में उपलब्ध मूल दस्तावेज़ को आधिकारिक स्रोत माना जाना चाहिए। महत्वपूर्ण जानकारी के लिए, पेशेवर मानव अनुवाद की सिफारिश की जाती है। इस अनुवाद के उपयोग से उत्पन्न किसी भी गलतफहमी या गलत व्याख्या के लिए हम जिम्मेदार नहीं हैं।