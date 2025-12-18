<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "8c5788d166402261b1133c3b3865eb79",
  "translation_date": "2025-12-17T14:02:58+00:00",
  "source_file": "README.md",
  "language_code": "mr"
}
-->
# जनरेटिव AI सुरुवातीसाठी - जावा आवृत्ती
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.mr.png)

**वेळेची बांधिलकी**: संपूर्ण कार्यशाळा स्थानिक सेटअपशिवाय ऑनलाइन पूर्ण केली जाऊ शकते. पर्यावरण सेटअपसाठी २ मिनिटे लागतात, तर नमुन्यांचा अभ्यास करण्यासाठी १-३ तास लागतात, जो अभ्यासाच्या खोलीवर अवलंबून असतो.

> **त्वरित प्रारंभ**

1. हा रेपॉझिटरी आपल्या GitHub खात्यावर Fork करा
2. क्लिक करा **Code** → **Codespaces** टॅब → **...** → **New with options...**
3. डीफॉल्ट वापरा – यामुळे या कोर्ससाठी तयार केलेला Development कंटेनर निवडला जाईल
4. क्लिक करा **Create codespace**
5. पर्यावरण तयार होण्यासाठी सुमारे २ मिनिटे थांबा
6. थेट जा [पहिल्या उदाहरणाकडे](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## बहुभाषिक समर्थन

### GitHub Action द्वारे समर्थित (स्वयंचलित आणि नेहमी अद्ययावत)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](../my/README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Kannada](../kn/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Malayalam](../ml/README.md) | [Marathi](./README.md) | [Nepali](../ne/README.md) | [Nigerian Pidgin](../pcm/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../br/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Telugu](../te/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## कोर्स रचना आणि शिकण्याचा मार्ग

### **अध्याय १: जनरेटिव AI परिचय**
- **मूलभूत संकल्पना**: मोठ्या भाषा मॉडेल्स, टोकन्स, एम्बेडिंग्ज आणि AI क्षमतांची समज
- **जावा AI परिसंस्था**: Spring AI आणि OpenAI SDKs चे आढावा
- **मॉडेल संदर्भ प्रोटोकॉल**: MCP परिचय आणि AI एजंट संवादातील त्याची भूमिका
- **व्यावहारिक अनुप्रयोग**: चॅटबॉट्स आणि सामग्री निर्मितीसह वास्तविक जगातील परिस्थिती
- **[→ अध्याय १ सुरू करा](./01-IntroToGenAI/README.md)**

### **अध्याय २: विकास पर्यावरण सेटअप**
- **बहु-प्रदाता कॉन्फिगरेशन**: GitHub मॉडेल्स, Azure OpenAI, आणि OpenAI Java SDK एकत्रीकरण सेट करा
- **Spring Boot + Spring AI**: एंटरप्राइझ AI अनुप्रयोग विकासासाठी सर्वोत्तम पद्धती
- **GitHub मॉडेल्स**: प्रोटोटायपिंग आणि शिकण्यासाठी मोफत AI मॉडेल प्रवेश (क्रेडिट कार्ड आवश्यक नाही)
- **विकास साधने**: Docker कंटेनर्स, VS Code, आणि GitHub Codespaces कॉन्फिगरेशन
- **[→ अध्याय २ सुरू करा](./02-SetupDevEnvironment/README.md)**

### **अध्याय ३: मुख्य जनरेटिव AI तंत्रे**
- **प्रॉम्प्ट इंजिनिअरिंग**: AI मॉडेल प्रतिसादांसाठी तंत्रे
- **एम्बेडिंग्ज आणि व्हेक्टर ऑपरेशन्स**: सेमॅंटिक शोध आणि सादृश्यता जुळणी अंमलात आणा
- **रिट्रीव्हल-ऑगमेंटेड जनरेशन (RAG)**: AI आपल्या स्वतःच्या डेटास्रोतांसह एकत्र करा
- **फंक्शन कॉलिंग**: कस्टम टूल्स आणि प्लगइन्ससह AI क्षमता वाढवा
- **[→ अध्याय ३ सुरू करा](./03-CoreGenerativeAITechniques/README.md)**

### **अध्याय ४: व्यावहारिक अनुप्रयोग आणि प्रकल्प**
- **पाळीव प्राणी कथा जनरेटर** (`petstory/`): GitHub मॉडेल्ससह सर्जनशील सामग्री निर्मिती
- **Foundry स्थानिक डेमो** (`foundrylocal/`): OpenAI Java SDK सह स्थानिक AI मॉडेल एकत्रीकरण
- **MCP कॅल्क्युलेटर सेवा** (`calculator/`): Spring AI सह मूलभूत मॉडेल संदर्भ प्रोटोकॉल अंमलबजावणी
- **[→ अध्याय ४ सुरू करा](./04-PracticalSamples/README.md)**

### **अध्याय ५: जबाबदार AI विकास**
- **GitHub मॉडेल्स सुरक्षा**: अंगभूत सामग्री फिल्टरिंग आणि सुरक्षा यंत्रणा (कठोर अडथळे आणि सौम्य नकार) तपासा
- **जबाबदार AI डेमो**: आधुनिक AI सुरक्षा प्रणाली कशी कार्य करते याचे प्रत्यक्ष उदाहरण
- **सर्वोत्तम पद्धती**: नैतिक AI विकास आणि तैनातीसाठी आवश्यक मार्गदर्शक तत्त्वे
- **[→ अध्याय ५ सुरू करा](./05-ResponsibleGenAI/README.md)**

## अतिरिक्त संसाधने

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### Azure / Edge / MCP / Agents
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### जनरेटिव AI मालिका
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### मुख्य शिक्षण
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![आरएक्स विकास सुरुवातीसाठी](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### कॉपायलट मालिका
[![एआय जोडलेल्या प्रोग्रामिंगसाठी कॉपायलट](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![C#/.NET साठी कॉपायलट](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![कॉपायलट साहस](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## मदत मिळवा

जर तुम्हाला अडचण येत असेल किंवा एआय अॅप्स तयार करण्याबाबत काही प्रश्न असतील तर. MCP बद्दल चर्चा करण्यासाठी सहकारी शिकणारे आणि अनुभवी विकसकांमध्ये सामील व्हा. ही एक सहायक समुदाय आहे जिथे प्रश्न विचारले जातात आणि ज्ञान मोकळेपणाने शेअर केले जाते.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

जर तुम्हाला उत्पादनाबाबत अभिप्राय किंवा त्रुटी असतील तर भेट द्या:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**अस्वीकरण**:
हा दस्तऐवज AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) वापरून अनुवादित केला आहे. आम्ही अचूकतेसाठी प्रयत्न करतो, तरी कृपया लक्षात घ्या की स्वयंचलित अनुवादांमध्ये चुका किंवा अचूकतेची कमतरता असू शकते. मूळ दस्तऐवज त्याच्या स्थानिक भाषेत अधिकृत स्रोत मानला जावा. महत्त्वाच्या माहितीसाठी व्यावसायिक मानवी अनुवाद शिफारसीय आहे. या अनुवादाच्या वापरामुळे उद्भवलेल्या कोणत्याही गैरसमजुती किंवा चुकीच्या अर्थलागी आम्ही जबाबदार नाही.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->