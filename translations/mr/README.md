# जनरेटिव AI सुरुवातीसाठी - जावा आवृत्ती
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![जनरेटिव AI सुरुवातीसाठी - जावा आवृत्ती](../../translated_images/mr/beg-genai-series.8b48be9951cc574c.webp)

**वेळेची जबाबदारी**: संपूर्ण कार्यशाळा स्थानिक सेटअपशिवाय ऑनलाइन पूर्ण केली जाऊ शकते. वातावरण सेटअपसाठी २ मिनिटे लागतात, तर नमुन्यांच्या अन्वेषणासाठी १-३ तास लागतील, अन्वेषणाच्या सखोलतेनुसार.

> **जलद प्रारंभ**

1. ह्या रिपॉझिटरीला आपल्या GitHub खात्यावर Fork करा
2. क्लिक करा **Code** → **Codespaces** टॅब → **...** → **New with options...**
3. पूर्वनिर्धारित वापरा – ह्यामुळे ह्या कोर्ससाठी तयार केलेली Development कंटेनर निवडली जाईल
4. क्लिक करा **Create codespace**
5. सुमारे ~2 मिनिटे प्रतीक्षा करा जेणेकरून वातावरण तयार होईल
6. थेट जा [पहिल्या उदाहरणाकडे](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **स्थानिक क्लोन करायचे प्राधान्य दिले तर?**
>
> ह्या रिपॉझिटरीमध्ये 50+ भाषा भाषांतर समाविष्ट आहेत ज्यामुळे डाउनलोड आकार लक्षणीय वाढतो. भाषांतरांशिवाय क्लोन करण्यासाठी sparse checkout वापरा:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> हे आपल्याला कोर्स पूर्ण करण्यासाठी आवश्यक सर्वकाही देईल, आणि डाउनलोड खूप जलद होईल.


## बहुभाषिक समर्थन

### GitHub Action द्वारे समर्थित (स्वयंचलित आणि नेहमी अद्ययावत)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[अरबी](../ar/README.md) | [बंगाली](../bn/README.md) | [बुल्गेरियन](../bg/README.md) | [बर्मीज (म्यानमार)](../my/README.md) | [चिनी (सोपे स्वरूप)](../zh-CN/README.md) | [चिनी (परंपरागत, हॉंगकाँग)](../zh-HK/README.md) | [चिनी (परंपरागत, मकाओ)](../zh-MO/README.md) | [चिनी (परंपरागत, तैवान)](../zh-TW/README.md) | [क्रोएशियन](../hr/README.md) | [चेक](../cs/README.md) | [डॅनिश](../da/README.md) | [डच](../nl/README.md) | [एस्टोनियन](../et/README.md) | [फिनिश](../fi/README.md) | [फ्रेंच](../fr/README.md) | [जर्मन](../de/README.md) | [ग्रीक](../el/README.md) | [हिब्रू](../he/README.md) | [हिंदी](../hi/README.md) | [हंगेरीयन](../hu/README.md) | [इंडोनेशियन](../id/README.md) | [इटालियन](../it/README.md) | [जपानी](../ja/README.md) | [कन्नड](../kn/README.md) | [कोरियन](../ko/README.md) | [लिथुआनियन](../lt/README.md) | [मलय](../ms/README.md) | [मलयाळम](../ml/README.md) | [मराठी](./README.md) | [नेपाळी](../ne/README.md) | [नायजेरियन पिजिन](../pcm/README.md) | [नॉर्वेजियन](../no/README.md) | [फारसी (पर्शियन)](../fa/README.md) | [पोलिश](../pl/README.md) | [पोर्तुगिज (ब्राझील)](../pt-BR/README.md) | [पोर्तुगिज (पोर्तुगाल)](../pt-PT/README.md) | [पंजाबी (गुरुमुखी)](../pa/README.md) | [रोमानियन](../ro/README.md) | [रशियन](../ru/README.md) | [सर्बियन (सिरिलिक)](../sr/README.md) | [स्लोव्हाक](../sk/README.md) | [स्लोव्हेनियन](../sl/README.md) | [स्पॅनिश](../es/README.md) | [स्वाहिली](../sw/README.md) | [स्वीडिश](../sv/README.md) | [टागालॉग (फिलीपिनो)](../tl/README.md) | [तमिळ](../ta/README.md) | [तेलुगू](../te/README.md) | [थाय](../th/README.md) | [तुर्की](../tr/README.md) | [युक्रेनियन](../uk/README.md) | [उर्दू](../ur/README.md) | [व्हिएतनामी](../vi/README.md)

## कोर्स संरचना आणि शिक्षण मार्ग

### **अध्याय १: जनरेटिव AI परिचय**
- **मुख्य संकल्पना**: मोठे भाषा मॉडेल्स, टोकन्स, एम्बेडिंग्ज, आणि AI क्षमता समजून घेणे
- **जावा AI प्रणाली**: Spring AI आणि OpenAI SDKs ची ओळख
- **मॉडेल संदर्भ प्रोटोकॉल**: MCP ची ओळख आणि AI एजंट संवादामध्ये त्याची भूमिका
- **व्यावहारिक अनुप्रयोग**: चॅटबॉट्स आणि सामग्री निर्मितीसह वास्तविक जगातील परिस्थिती
- **[→ अध्याय १ सुरू करा](./01-IntroToGenAI/README.md)**

### **अध्याय २: विकास पर्यावरण सेटअप**
- **अनेक प्रदाते संरचना**: GitHub मॉडेल्स, Azure OpenAI, आणि OpenAI जावा SDK एकत्रीकरण सेटअप करा
- **Spring Boot + Spring AI**: एंटरप्राइझ AI अनुप्रयोग विकासासाठी सर्वोत्तम प्रथांचा आढावा
- **GitHub मॉडेल्स**: प्रोटोटाइप आणि शिक्षणासाठी विनामूल्य AI मॉडेल प्रवेश (क्रेडिट कार्डची गरज नाही)
- **विकास साधने**: Docker कंटेनर्स, VS कोड, आणि GitHub Codespaces कॉन्फिगरेशन
- **[→ अध्याय २ सुरू करा](./02-SetupDevEnvironment/README.md)**

### **अध्याय ३: मुख्य जनरेटिव AI तंत्र**
- **प्रॉम्प्ट इंजिनिअरिंग**: AI मॉडेल प्रतिसादांसाठी सर्वोत्तम तंत्रे
- **एम्बेडिंग्ज आणि व्हेक्टर ऑपरेशन्स**: सँटिमेंटिक शोध आणि साम्य जुळणी अमलात आणा
- **रिट्रिव्हल-अग्युमेंटेड जनरेशन (RAG)**: आपल्या स्वतःच्या डेटास्रोतांसह AI चे संयोजन करा
- **फंक्शन कॉलिंग**: कस्टम साधने आणि प्लगिन्ससह AI क्षमता वाढवा
- **[→ अध्याय ३ सुरू करा](./03-CoreGenerativeAITechniques/README.md)**

### **अध्याय ४: व्यावहारिक अनुप्रयोग आणि प्रकल्प**
- **पाळीव प्राणी कथा जनरेटर** (`petstory/`): GitHub मॉडेल्ससह सर्जनशील सामग्री निर्मिती
- **Foundry स्थानिक डेमो** (`foundrylocal/`): OpenAI जावा SDK सह स्थानिक AI मॉडेल एकत्रीकरण
- **MCP कॅल्क्युलेटर सेवा** (`calculator/`): Spring AI सह मूलभूत मॉडेल संदर्भ प्रोटोकॉल अंमलबजावणी
- **[→ अध्याय ४ सुरू करा](./04-PracticalSamples/README.md)**

### **अध्याय ५: जबाबदार AI विकास**
- **GitHub मॉडेल्स सुरक्षितता**: अंगभूत सामग्री फिल्टरिंग आणि सुरक्षा यंत्रणा तपासा (हार्ड ब्लॉक्स आणि सॉफ्ट नाकारणे)
- **जबाबदार AI डेमो**: आधुनिक AI सुरक्षा प्रणालींचे प्रत्यक्ष अनुभव दाखवणारे उदाहरण
- **सर्वोत्तम प्रथा**: नैतिक AI विकास आणि तैनातीसाठी आवश्यक मार्गदर्शक तत्त्वे
- **[→ अध्याय ५ सुरू करा](./05-ResponsibleGenAI/README.md)**

## अतिरिक्त संसाधने

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j सुरुवातीसाठी](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js सुरुवातीसाठी](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### Azure / Edge / MCP / एजंट्स
[![AZD सुरुवातीसाठी](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI सुरुवातीसाठी](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP सुरुवातीसाठी](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI एजंट्स सुरुवातीसाठी](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### जनरेटिव AI मालिका
[![जनरेटिव AI सुरुवातीसाठी](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![जनरेटिव AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![जनरेटिव AI (जावा)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![जनरेटिव AI (जावास्क्रिप्ट)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---

### मुख्य शिक्षण
[![शिकण्याची यंत्रणा सुरुवातीसाठी](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![डेटा सायन्स सुरुवातीसाठी](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI सुरुवातीसाठी](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![सायबरसुरक्षा सुरुवातीसाठी](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![वेब विकास सुरुवातीसाठी](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![शिका IoT साठी](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![शिका XR विकासासाठी](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### कॉपायलट मालिका
[![AI जोडलेल्या प्रोग्रामिंगसाठी कॉपायलट](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![C#/.NET साठी कॉपायलट](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![कॉपायलट साहस](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## मदत मिळवा

जर तुम्ही अडकलात किंवा AI अॅप तयार करण्याबाबत प्रश्न आहेत, तर MCP वापरकर्त्यांच्या चर्चेत सामील व्हा. ही एक सहायक समुदाय आहे जिथे प्रश्न विचारणे स्वागतार्ह आहे आणि ज्ञान खुलेपणाने वाटले जाते.

[![मायक्रोसॉफ्ट फाउंड्री डिस्कॉर्ड](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

जर तुमच्याकडे उत्पादनाबाबत अभिप्राय किंवा चुका असतील तर येथे भेट द्या:

[![मायक्रोसॉफ्ट फाउंड्री डेव्हलपर फोरम](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**अस्वीकरण**:  
हा दस्तऐवज AI भाषांतर सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) चा वापर करून भाषांतरित केला आहे. आम्ही अचूकतेसाठी प्रयत्नशील आहोत, तरी कृपया लक्षात ठेवा की स्वयंचलित भाषांतरांमध्ये चुका किंवा अचूकतेची कमतरता असू शकते. मूळ दस्तऐवज त्याच्या स्थानिक भाषेत अधिकृत स्रोत म्हणून घ्यावा. महत्त्वाच्या माहितीसाठी व्यावसायिक मानवी भाषांतर घेणे शिफारसीय आहे. या भाषांतराच्या वापरामुळे उद्भवणाऱ्या कोणत्याही गैरसमजुती किंवा चुकीच्या अर्थसिद्धीसाठी आम्ही जबाबदार नाही.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->