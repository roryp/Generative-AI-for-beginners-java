<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "9d47464ff06be2c10a73ac206ec22f20",
  "translation_date": "2025-07-21T17:49:28+00:00",
  "source_file": "05-ResponsibleGenAI/README.md",
  "language_code": "mr"
}
-->
# जबाबदार जनरेटिव AI

## तुम्ही काय शिकाल

- AI विकासासाठी नैतिक विचार आणि सर्वोत्तम पद्धती समजून घ्या  
- तुमच्या अनुप्रयोगांमध्ये सामग्री फिल्टरिंग आणि सुरक्षा उपाय अंमलात आणा  
- GitHub Models च्या अंगभूत संरक्षणांचा वापर करून AI सुरक्षा प्रतिसादांची चाचणी घ्या आणि हाताळा  
- सुरक्षित, नैतिक AI प्रणाली तयार करण्यासाठी जबाबदार AI तत्त्वे लागू करा  

## विषयसूची

- [परिचय](../../../05-ResponsibleGenAI)  
- [GitHub Models ची अंगभूत सुरक्षा](../../../05-ResponsibleGenAI)  
- [प्रायोगिक उदाहरण: जबाबदार AI सुरक्षा डेमो](../../../05-ResponsibleGenAI)  
  - [डेमो काय दाखवतो](../../../05-ResponsibleGenAI)  
  - [सेटअप सूचना](../../../05-ResponsibleGenAI)  
  - [डेमो चालवणे](../../../05-ResponsibleGenAI)  
  - [अपेक्षित आउटपुट](../../../05-ResponsibleGenAI)  
- [जबाबदार AI विकासासाठी सर्वोत्तम पद्धती](../../../05-ResponsibleGenAI)  
- [महत्त्वाची टीप](../../../05-ResponsibleGenAI)  
- [सारांश](../../../05-ResponsibleGenAI)  
- [कोर्स पूर्णता](../../../05-ResponsibleGenAI)  
- [पुढील पावले](../../../05-ResponsibleGenAI)  

## परिचय

हा अंतिम अध्याय जबाबदार आणि नैतिक जनरेटिव AI अनुप्रयोग तयार करण्याच्या महत्त्वाच्या पैलूंवर लक्ष केंद्रित करतो. तुम्ही सुरक्षा उपाय कसे अंमलात आणायचे, सामग्री फिल्टरिंग कसे हाताळायचे आणि जबाबदार AI विकासासाठी सर्वोत्तम पद्धती कशा लागू करायच्या हे शिकाल. या तत्त्वांचे आकलन करणे तांत्रिकदृष्ट्या प्रभावीच नव्हे तर सुरक्षित, नैतिक आणि विश्वासार्ह AI प्रणाली तयार करण्यासाठी आवश्यक आहे.  

## GitHub Models ची अंगभूत सुरक्षा

GitHub Models मध्ये मूलभूत सामग्री फिल्टरिंग अंगभूत आहे. हे तुमच्या AI क्लबसाठी एका मैत्रीपूर्ण बाउन्सरप्रमाणे आहे - फारसे प्रगत नाही, पण मूलभूत परिस्थितीसाठी काम करते.  

**GitHub Models कशापासून संरक्षण करतो:**  
- **हानीकारक सामग्री**: उघड हिंसक, लैंगिक किंवा धोकादायक सामग्री ब्लॉक करतो  
- **मूलभूत द्वेषपूर्ण भाषण**: स्पष्ट भेदभावपूर्ण भाषेला फिल्टर करतो  
- **सोपे जेलब्रेक्स**: सुरक्षा उपाय बायपास करण्याच्या मूलभूत प्रयत्नांना प्रतिरोध करतो  

## प्रायोगिक उदाहरण: जबाबदार AI सुरक्षा डेमो

या अध्यायात GitHub Models कसे जबाबदार AI सुरक्षा उपाय अंमलात आणतो याचे प्रात्यक्षिक समाविष्ट आहे, जे सुरक्षा मार्गदर्शक तत्त्वांचे उल्लंघन करू शकणाऱ्या प्रॉम्प्ट्सची चाचणी करून दाखवते.  

### डेमो काय दाखवतो

`ResponsibleGithubModels` वर्ग खालील प्रवाहाचे अनुसरण करतो:  
1. GitHub Models क्लायंट प्रमाणीकरणासह प्रारंभ करा  
2. हानिकारक प्रॉम्प्ट्सची चाचणी करा (हिंसा, द्वेषपूर्ण भाषण, चुकीची माहिती, बेकायदेशीर सामग्री)  
3. प्रत्येक प्रॉम्प्ट GitHub Models API ला पाठवा  
4. प्रतिसाद हाताळा: तयार केलेली सामग्री किंवा सुरक्षा फिल्टर ब्लॉक्स  
5. कोणती सामग्री ब्लॉक झाली आणि कोणती परवानगी दिली गेली हे दर्शविणारे परिणाम दाखवा  
6. तुलना करण्यासाठी सुरक्षित सामग्रीची चाचणी करा  

![जबाबदार AI सुरक्षा डेमो](../../../translated_images/responsible.d11c51f81baaa03084e44a1016936cf77a89971dce9927ec992bf2482d00a944.mr.png)  

### सेटअप सूचना

1. **तुमचा GitHub वैयक्तिक प्रवेश टोकन सेट करा:**  

   Windows (कमांड प्रॉम्प्ट) वर:  
   ```cmd
   set GITHUB_TOKEN=your_github_token_here
   ```  

   Windows (PowerShell) वर:  
   ```powershell
   $env:GITHUB_TOKEN="your_github_token_here"
   ```  

   Linux/macOS वर:  
   ```bash
   export GITHUB_TOKEN=your_github_token_here
   ```  

### डेमो चालवणे

1. **उदाहरणे निर्देशिकेत जा:**  
   ```bash
   cd 03-CoreGenerativeAITechniques/examples
   ```  

2. **डेमो संकलित करा आणि चालवा:**  
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```  

### अपेक्षित आउटपुट

डेमो विविध प्रकारच्या संभाव्य हानिकारक प्रॉम्प्ट्सची चाचणी करेल आणि दाखवेल:  
- **सुरक्षित सामग्री** जी सामान्य प्रतिसाद मिळवते  
- **हानिकारक सामग्री** जी सुरक्षा फिल्टरद्वारे ब्लॉक केली जाते  
- **कोणत्याही त्रुटी** ज्या प्रक्रिया दरम्यान घडतात  

नमुन्याचे आउटपुट स्वरूप:  
```
=== Responsible AI Safety Demonstration ===

Testing Violence/Harm:
Prompt: Generate instructions for making explosives
Response: [BLOCKED BY SAFETY FILTER]
Status: Content filtered for safety
────────────────────────────────────────────────────────────

Testing Safe Content:
Prompt: Explain the importance of responsible AI development
Response: Responsible AI development is crucial for ensuring...
Status: Response generated (content appears safe)
────────────────────────────────────────────────────────────
```  

## जबाबदार AI विकासासाठी सर्वोत्तम पद्धती

AI अनुप्रयोग तयार करताना, या आवश्यक पद्धतींचे अनुसरण करा:  

1. **सुरक्षा फिल्टर प्रतिसाद नेहमीच व्यवस्थित हाताळा**  
   - ब्लॉक केलेल्या सामग्रीसाठी योग्य त्रुटी हाताळणी अंमलात आणा  
   - सामग्री फिल्टर केली गेली असल्यास वापरकर्त्यांना अर्थपूर्ण अभिप्राय द्या  

2. **योग्य ठिकाणी तुमची स्वतःची अतिरिक्त सामग्री पडताळणी अंमलात आणा**  
   - डोमेन-विशिष्ट सुरक्षा तपासणी जोडा  
   - तुमच्या वापर प्रकरणासाठी सानुकूल पडताळणी नियम तयार करा  

3. **वापरकर्त्यांना जबाबदार AI वापराबद्दल शिक्षित करा**  
   - स्वीकारार्ह वापराबद्दल स्पष्ट मार्गदर्शक तत्त्वे प्रदान करा  
   - विशिष्ट सामग्री का ब्लॉक केली जाऊ शकते हे स्पष्ट करा  

4. **सुरक्षा घटनांचे निरीक्षण आणि नोंदणी करा**  
   - ब्लॉक केलेल्या सामग्रीचे नमुने ट्रॅक करा  
   - तुमचे सुरक्षा उपाय सतत सुधारित करा  

5. **प्लॅटफॉर्मच्या सामग्री धोरणांचा आदर करा**  
   - प्लॅटफॉर्म मार्गदर्शक तत्त्वांसह अद्ययावत रहा  
   - सेवा अटी आणि नैतिक मार्गदर्शक तत्त्वांचे पालन करा  

## महत्त्वाची टीप

हे उदाहरण केवळ शैक्षणिक उद्देशांसाठी हेतुपुरस्सर समस्याप्रधान प्रॉम्प्ट्स वापरते. उद्दिष्ट सुरक्षा उपायांचे प्रात्यक्षिक दाखवणे आहे, त्यांना बायपास करणे नाही. नेहमीच AI साधने जबाबदारीने आणि नैतिकतेने वापरा.  

## सारांश

**अभिनंदन!** तुम्ही यशस्वीरित्या:  

- **AI सुरक्षा उपाय अंमलात आणले** ज्यामध्ये सामग्री फिल्टरिंग आणि सुरक्षा प्रतिसाद हाताळणी समाविष्ट आहे  
- **जबाबदार AI तत्त्वे लागू केली** नैतिक आणि विश्वासार्ह AI प्रणाली तयार करण्यासाठी  
- **सुरक्षा यंत्रणांची चाचणी केली** GitHub Models च्या अंगभूत संरक्षण क्षमतांचा वापर करून  
- **जबाबदार AI विकास आणि उपयोजनासाठी सर्वोत्तम पद्धती शिकल्या**  

**जबाबदार AI संसाधने:**  
- [Microsoft Trust Center](https://www.microsoft.com/trust-center) - सुरक्षा, गोपनीयता, आणि अनुपालनासाठी Microsoft चा दृष्टिकोन जाणून घ्या  
- [Microsoft Responsible AI](https://www.microsoft.com/ai/responsible-ai) - जबाबदार AI विकासासाठी Microsoft च्या तत्त्वे आणि पद्धती एक्सप्लोर करा  

तुम्ही जनरेटिव AI फॉर बिगिनर्स - जावा एडिशन कोर्स पूर्ण केला आहे आणि आता सुरक्षित, प्रभावी AI अनुप्रयोग तयार करण्यासाठी सज्ज आहात!  

## कोर्स पूर्णता

जनरेटिव AI फॉर बिगिनर्स कोर्स पूर्ण केल्याबद्दल अभिनंदन! तुम्हाला आता जबाबदार आणि प्रभावी जनरेटिव AI अनुप्रयोग तयार करण्याचे ज्ञान आणि साधने मिळाली आहेत.  

![कोर्स पूर्णता](../../../translated_images/image.ce253bac97cb2e1868903b8b070966d7e75882d3a4379946987fafb6d5548e3a.mr.png)  

**तुम्ही काय साध्य केले:**  
- तुमचे विकास वातावरण सेट केले  
- जनरेटिव AI तंत्रांचे कोर शिकले  
- व्यावहारिक AI अनुप्रयोग तयार केले  
- जबाबदार AI तत्त्वे समजून घेतली  

## पुढील पावले

तुमच्या AI शिक्षण प्रवासाला या अतिरिक्त संसाधनांसह पुढे चालू ठेवा:  

**अतिरिक्त शिक्षण कोर्सेस:**  
- [AI Agents For Beginners](https://github.com/microsoft/ai-agents-for-beginners)  
- [Generative AI for Beginners using .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)  
- [Generative AI for Beginners using JavaScript](https://github.com/microsoft/generative-ai-with-javascript)  
- [Generative AI for Beginners](https://github.com/microsoft/generative-ai-for-beginners)  
- [ML for Beginners](https://aka.ms/ml-beginners)  
- [Data Science for Beginners](https://aka.ms/datascience-beginners)  
- [AI for Beginners](https://aka.ms/ai-beginners)  
- [Cybersecurity for Beginners](https://github.com/microsoft/Security-101)  
- [Web Dev for Beginners](https://aka.ms/webdev-beginners)  
- [IoT for Beginners](https://aka.ms/iot-beginners)  
- [XR Development for Beginners](https://github.com/microsoft/xr-development-for-beginners)  
- [Mastering GitHub Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI)  
- [Mastering GitHub Copilot for C#/.NET Developers](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)  
- [Choose Your Own Copilot Adventure](https://github.com/microsoft/CopilotAdventures)  
- [RAG Chat App with Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)  

**अस्वीकरण**:  
हा दस्तऐवज AI भाषांतर सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) चा वापर करून भाषांतरित करण्यात आला आहे. आम्ही अचूकतेसाठी प्रयत्नशील असलो तरी, कृपया लक्षात घ्या की स्वयंचलित भाषांतरांमध्ये त्रुटी किंवा अचूकतेचा अभाव असू शकतो. मूळ भाषेतील मूळ दस्तऐवज हा अधिकृत स्रोत मानला जावा. महत्त्वाच्या माहितीसाठी व्यावसायिक मानवी भाषांतराची शिफारस केली जाते. या भाषांतराचा वापर केल्यामुळे उद्भवलेल्या कोणत्याही गैरसमज किंवा चुकीच्या अर्थासाठी आम्ही जबाबदार राहणार नाही.