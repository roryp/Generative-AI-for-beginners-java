<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T17:39:56+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "mr"
}
-->
# जनरेटिव्ह AI तंत्रज्ञानाचे मुख्य तत्त्व

>**Note**: या प्रकरणात [**Tutorial**](./TUTORIAL.md) समाविष्ट आहे, ज्यामध्ये तयार नमुन्ये चालवण्याचे मार्गदर्शन दिले आहे.

## तुम्ही काय शिकाल
या प्रकरणात, आम्ही ४ मुख्य जनरेटिव्ह AI तंत्रज्ञानाचे व्यावहारिक उदाहरणांद्वारे परीक्षण करू:
- LLM पूर्णता आणि चॅट फ्लो
- फंक्शन कॉलिंग
- Retrieval-Augmented Generation (RAG)
- जबाबदार AI सुरक्षा उपाय

## विषय सूची

- [तुम्ही काय शिकाल](../../../03-CoreGenerativeAITechniques)
- [पूर्वअट](../../../03-CoreGenerativeAITechniques)
- [सुरुवात कशी करावी](../../../03-CoreGenerativeAITechniques)
- [उदाहरणांचे विहंगावलोकन](../../../03-CoreGenerativeAITechniques)
  - [1. LLM पूर्णता आणि चॅट फ्लो](../../../03-CoreGenerativeAITechniques)
  - [2. LLM सह फंक्शन्स आणि प्लगिन्स](../../../03-CoreGenerativeAITechniques)
  - [3. Retrieval-Augmented Generation (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. जबाबदार AI सुरक्षा प्रदर्शन](../../../03-CoreGenerativeAITechniques)
- [सारांश](../../../03-CoreGenerativeAITechniques)
- [पुढील पाऊल](../../../03-CoreGenerativeAITechniques)

## पूर्वअट

- [Chapter 2](../../../02-SetupDevEnvironment) मधील सेटअप पूर्ण केलेले असावे.

## सुरुवात कशी करावी

1. **उदाहरणांपर्यंत पोहोचा**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **पर्यावरण सेट करा**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **उदाहरणे संकलित करा आणि चालवा**:  
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

## उदाहरणांचे विहंगावलोकन

उदाहरणे `examples/` फोल्डरमध्ये खालील रचनेनुसार आयोजित केली आहेत:

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

### 1. LLM पूर्णता आणि चॅट फ्लो
**फाईल**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

स्ट्रीमिंग प्रतिसाद आणि चॅट इतिहास व्यवस्थापनासह संभाषणात्मक AI तयार करणे शिकून घ्या.

या उदाहरणात दाखवले आहे:
- सिस्टम प्रॉम्प्टसह साधी टेक्स्ट पूर्णता
- इतिहास व्यवस्थापनासह मल्टी-टर्न संभाषणे
- परस्परसंवादी चॅट सत्रे
- पॅरामीटर कॉन्फिगरेशन (temperature, max tokens)

### 2. LLM सह फंक्शन्स आणि प्लगिन्स
**फाईल**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

कस्टम फंक्शन्स आणि बाह्य API साठी मॉडेल्सना प्रवेश देऊन AI क्षमता वाढवा.

या उदाहरणात दाखवले आहे:
- हवामान फंक्शन एकत्रीकरण
- कॅल्क्युलेटर फंक्शन अंमलबजावणी  
- एका संभाषणात एकाधिक फंक्शन कॉल्स
- JSON स्कीमासह फंक्शन परिभाषा

### 3. Retrieval-Augmented Generation (RAG)
**फाईल**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

तुमच्या स्वतःच्या दस्तऐवज आणि डेटास्रोतांसह AI कसे एकत्र करावे आणि अचूक, संदर्भ-सजग प्रतिसाद मिळवावे हे शिकून घ्या.

या उदाहरणात दाखवले आहे:
- Azure OpenAI SDK सह दस्तऐवज-आधारित प्रश्नोत्तरे
- GitHub Models सह RAG पॅटर्न अंमलबजावणी

**वापर**: `document.txt` मधील सामग्रीबद्दल प्रश्न विचारा आणि त्या संदर्भावर आधारित AI प्रतिसाद मिळवा.

### 4. जबाबदार AI सुरक्षा प्रदर्शन
**फाईल**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

GitHub Models च्या सामग्री फिल्टरिंग क्षमतांची चाचणी घेऊन AI सुरक्षा उपाय कसे कार्य करतात याचा आढावा घ्या.

या उदाहरणात दाखवले आहे:
- संभाव्य हानिकारक प्रॉम्प्टसाठी सामग्री फिल्टरिंग
- अनुप्रयोगांमध्ये सुरक्षा प्रतिसाद हाताळणी
- अवरोधित सामग्रीच्या विविध श्रेणी (हिंसा, द्वेषपूर्ण भाषण, चुकीची माहिती)
- सुरक्षा उल्लंघनांसाठी योग्य त्रुटी हाताळणी

> **अधिक जाणून घ्या**: हे जबाबदार AI संकल्पनांचे फक्त एक परिचय आहे. नैतिकता, पूर्वग्रह कमी करणे, गोपनीयता विचार, आणि जबाबदार AI फ्रेमवर्क्स याबद्दल अधिक माहितीसाठी [Chapter 5: Responsible Generative AI](../05-ResponsibleGenAI/README.md) पहा.

## सारांश

या प्रकरणात, आम्ही LLM पूर्णता आणि चॅट फ्लो शोधले, AI क्षमता वाढवण्यासाठी फंक्शन कॉलिंग अंमलात आणले, Retrieval-Augmented Generation (RAG) प्रणाली तयार केली, आणि जबाबदार AI सुरक्षा उपायांचे प्रदर्शन केले.

> **NOTE**: दिलेल्या [**Tutorial**](./TUTORIAL.md) सह अधिक सखोल अभ्यास करा.

## पुढील पाऊल

[Chapter 4: Practical Applications & Projects](../04-PracticalSamples/README.md)

**अस्वीकरण**:  
हा दस्तऐवज AI भाषांतर सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) वापरून भाषांतरित करण्यात आला आहे. आम्ही अचूकतेसाठी प्रयत्नशील असलो तरी कृपया लक्षात ठेवा की स्वयंचलित भाषांतरांमध्ये त्रुटी किंवा अचूकतेचा अभाव असू शकतो. मूळ भाषेतील दस्तऐवज हा अधिकृत स्रोत मानला जावा. महत्त्वाच्या माहितीसाठी व्यावसायिक मानवी भाषांतराची शिफारस केली जाते. या भाषांतराचा वापर करून उद्भवलेल्या कोणत्याही गैरसमज किंवा चुकीच्या अर्थासाठी आम्ही जबाबदार राहणार नाही.