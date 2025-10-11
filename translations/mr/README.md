<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:23:48+00:00",
  "source_file": "README.md",
  "language_code": "mr"
}
-->
# जनरेटिव AI सुरुवातीसाठी - जावा आवृत्ती
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![जनरेटिव AI सुरुवातीसाठी - जावा आवृत्ती](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.mr.png)

**वेळेची गरज**: संपूर्ण कार्यशाळा स्थानिक सेटअपशिवाय ऑनलाइन पूर्ण केली जाऊ शकते. वातावरण सेटअपसाठी 2 मिनिटे लागतात, तर नमुने एक्सप्लोर करण्यासाठी 1-3 तास लागतात, एक्सप्लोरेशनच्या खोलीवर अवलंबून.

> **जलद सुरुवात**

1. या रिपॉझिटरीला तुमच्या GitHub खात्यावर फोर्क करा
2. **Code** → **Codespaces** टॅब → **...** → **New with options...** वर क्लिक करा
3. डीफॉल्ट्स वापरा – हे या कोर्ससाठी तयार केलेल्या डेव्हलपमेंट कंटेनरची निवड करेल
4. **Create codespace** वर क्लिक करा
5. वातावरण तयार होण्यासाठी ~2 मिनिटे प्रतीक्षा करा
6. [पहिल्या उदाहरणावर](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) थेट जा

## बहुभाषिक समर्थन

### GitHub Action द्वारे समर्थित (स्वयंचलित आणि नेहमी अद्ययावत)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](../my/README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Marathi](./README.md) | [Nepali](../ne/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../br/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## कोर्सची रचना आणि शिकण्याचा मार्ग

### **अध्याय 1: जनरेटिव AI ची ओळख**
- **मूलभूत संकल्पना**: मोठ्या भाषा मॉडेल्स, टोकन्स, एम्बेडिंग्स आणि AI क्षमता समजून घेणे
- **जावा AI इकोसिस्टम**: Spring AI आणि OpenAI SDKs चा आढावा
- **मॉडेल कॉन्टेक्स्ट प्रोटोकॉल**: MCP आणि AI एजंट कम्युनिकेशनमधील त्याची भूमिका
- **व्यावहारिक अनुप्रयोग**: चॅटबॉट्स आणि सामग्री निर्मिती यासह वास्तविक जगातील उदाहरणे
- **[→ अध्याय 1 सुरू करा](./01-IntroToGenAI/README.md)**

### **अध्याय 2: विकास वातावरण सेटअप**
- **मल्टी-प्रोव्हायडर कॉन्फिगरेशन**: GitHub Models, Azure OpenAI, आणि OpenAI Java SDK एकत्रीकरण सेटअप करा
- **Spring Boot + Spring AI**: एंटरप्राइझ AI अनुप्रयोग विकासासाठी सर्वोत्तम पद्धती
- **GitHub Models**: प्रोटोटायपिंग आणि शिकण्यासाठी मोफत AI मॉडेल प्रवेश (क्रेडिट कार्ड आवश्यक नाही)
- **विकास साधने**: Docker कंटेनर्स, VS Code, आणि GitHub Codespaces कॉन्फिगरेशन
- **[→ अध्याय 2 सुरू करा](./02-SetupDevEnvironment/README.md)**

### **अध्याय 3: मुख्य जनरेटिव AI तंत्र**
- **प्रॉम्प्ट इंजिनिअरिंग**: AI मॉडेल्सकडून उत्तम प्रतिसाद मिळवण्यासाठी तंत्र
- **एम्बेडिंग्स आणि व्हेक्टर ऑपरेशन्स**: सिमॅंटिक सर्च आणि साम्य जुळविणे अंमलात आणा
- **रिट्रीव्हल-अगमेंटेड जनरेशन (RAG)**: AI ला तुमच्या स्वतःच्या डेटा स्रोतांसह एकत्र करा
- **फंक्शन कॉलिंग**: कस्टम टूल्स आणि प्लगइन्ससह AI क्षमता वाढवा
- **[→ अध्याय 3 सुरू करा](./03-CoreGenerativeAITechniques/README.md)**

### **अध्याय 4: व्यावहारिक अनुप्रयोग आणि प्रकल्प**
- **पेट स्टोरी जनरेटर** (`petstory/`): GitHub Models सह सर्जनशील सामग्री निर्मिती
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK सह स्थानिक AI मॉडेल एकत्रीकरण
- **MCP कॅल्क्युलेटर सेवा** (`calculator/`): Spring AI सह मूलभूत मॉडेल कॉन्टेक्स्ट प्रोटोकॉल अंमलबजावणी
- **[→ अध्याय 4 सुरू करा](./04-PracticalSamples/README.md)**

### **अध्याय 5: जबाबदार AI विकास**
- **GitHub Models सुरक्षा**: अंगभूत सामग्री फिल्टरिंग आणि सुरक्षा यंत्रणा (हार्ड ब्लॉक्स आणि सॉफ्ट नकार) चाचणी करा
- **जबाबदार AI डेमो**: आधुनिक AI सुरक्षा प्रणाली प्रत्यक्षात कशा कार्य करतात याचे हाताळण्याचे उदाहरण
- **सर्वोत्तम पद्धती**: नैतिक AI विकास आणि तैनातीसाठी आवश्यक मार्गदर्शक तत्त्वे
- **[→ अध्याय 5 सुरू करा](./05-ResponsibleGenAI/README.md)**

## अतिरिक्त संसाधने

- [Edge AI for Beginners](https://github.com/microsoft/edgeai-for-beginners)
- [MCP For Beginners](https://github.com/microsoft/mcp-for-beginners)
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

## मदत मिळवणे

जर तुम्हाला अडचण आली किंवा AI अॅप्स तयार करण्याबद्दल काही प्रश्न असतील, तर सामील व्हा:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

जर तुम्हाला उत्पादन फीडबॅक द्यायचे असेल किंवा तयार करताना त्रुटी आढळल्यास भेट द्या:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**अस्वीकरण**:  
हा दस्तऐवज AI भाषांतर सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) वापरून भाषांतरित करण्यात आला आहे. आम्ही अचूकतेसाठी प्रयत्नशील असलो तरी, कृपया लक्षात ठेवा की स्वयंचलित भाषांतरांमध्ये त्रुटी किंवा अचूकतेचा अभाव असू शकतो. मूळ भाषेतील दस्तऐवज हा अधिकृत स्रोत मानला जावा. महत्त्वाच्या माहितीसाठी, व्यावसायिक मानवी भाषांतराची शिफारस केली जाते. या भाषांतराचा वापर करून उद्भवलेल्या कोणत्याही गैरसमज किंवा चुकीच्या अर्थासाठी आम्ही जबाबदार राहणार नाही.