# जनरेटिव AI सुरू करणाऱ्यांसाठी - जावा आवृत्ती
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![जनरेटिव AI सुरू करणाऱ्यांसाठी - जावा आवृत्ती](../../translated_images/mr/beg-genai-series.8b48be9951cc574c.webp)

**वेळेची गरज**: संपूर्ण कार्यशाळा ऑनलाईन पूर्ण केली जाऊ शकते, स्थानिक सेटअपशिवाय. वातावरण सेटअप करण्यासाठी २ मिनिटे लागतात, तर नमुन्यांचा अभ्यास करण्यासाठी शोधण्याच्या खोलीवर अवलंबून १-३ तास लागू शकतात.

> **जलद प्रारंभ**

1. हा रेपोजिटरी आपल्या GitHub खात्यात Fork करा
2. क्लिक करा **Code** → **Codespaces** टॅब → **...** → **New with options...**
3. डीफॉल्ट्स वापरा – यामुळे या कोर्ससाठी तयार केलेला Development कंटेनर निवडला जाईल
4. क्लिक करा **Create codespace**
5. वातावरण तयार होण्यासाठी अंदाजे २ मिनिटे थांबा
6. थेट [पहिल्या उदाहरणावर जा](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **स्थानिक क्लोन करण्याचा पसंती आहे?**
>
> या रेपोजिटरीमध्ये ५०+ भाषा अनुवाद समाविष्ट आहेत जे डाउनलोड साईज मोठा करतात. भाषांतरांशिवाय क्लोन करण्यासाठी sparse checkout वापरा:
>
> **Linux / macOS (Bash)**
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
>
> **Windows (PowerShell)**
> ```powershell
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone "/*" "!translations" "!translated_images"
> ```
> हे आपल्याला कोर्स पूर्ण करण्यासाठी आवश्यक सर्व काही फार वेगाने डाउनलोड करुन देते.


## बहुभाषिक समर्थन

### GitHub Action द्वारे समर्थित (स्वयंचलित आणि नेहमी अद्ययावत)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[अरबी](../ar/README.md) | [बंगाली](../bn/README.md) | [बल्गेरियन](../bg/README.md) | [बर्मese (म्यानमार)](../my/README.md) | [चिनी (सरलीकृत)](../zh-CN/README.md) | [चिनी (परंपरागत, हॉंगकॉंग)](../zh-HK/README.md) | [चिनी (परंपरागत, मकाऊ)](../zh-MO/README.md) | [चिनी (परंपरागत, तैवान)](../zh-TW/README.md) | [ख्रोटियन](../hr/README.md) | [चेक](../cs/README.md) | [डॅनिश](../da/README.md) | [डच](../nl/README.md) | [एस्टोनियन](../et/README.md) | [फिनिश](../fi/README.md) | [फ्रेंच](../fr/README.md) | [जर्मन](../de/README.md) | [ग्रीक](../el/README.md) | [हिब्रू](../he/README.md) | [हिंदी](../hi/README.md) | [हंगेरीयन](../hu/README.md) | [इंडोनेशियन](../id/README.md) | [इटालियन](../it/README.md) | [जपानी](../ja/README.md) | [कन्नड](../kn/README.md) | [कोरियन](../ko/README.md) | [लिथुआनियन](../lt/README.md) | [मलय](../ms/README.md) | [मलयाळम](../ml/README.md) | [मराठी](./README.md) | [नेपाली](../ne/README.md) | [नायजेरियन पिजिन](../pcm/README.md) | [नॉर्वेजियन](../no/README.md) | [फारसी (पर्शियन)](../fa/README.md) | [पोलिश](../pl/README.md) | [पोर्तुगीज (ब्राझील)](../pt-BR/README.md) | [पोर्तुगीज (पोर्तुगाल)](../pt-PT/README.md) | [पंजाबी (गुरमुखी)](../pa/README.md) | [रोमेनियन](../ro/README.md) | [रशियन](../ru/README.md) | [सर्बियन (सिरिलिक)](../sr/README.md) | [स्लोवाक](../sk/README.md) | [स्लोव्हेनियन](../sl/README.md) | [स्पॅनिश](../es/README.md) | [स्वाहिली](../sw/README.md) | [स्विडिश](../sv/README.md) | [टॅगालॉग (फिलिपिनो)](../tl/README.md) | [तमिळ](../ta/README.md) | [तेलुगू](../te/README.md) | [थाई](../th/README.md) | [तुर्की](../tr/README.md) | [यूक्रेनियन](../uk/README.md) | [उर्दू](../ur/README.md) | [व्हिएतनामी](../vi/README.md)

## कोर्स रचना आणि शिकण्याचा मार्ग

### **अध्याय १: जनरेटिव AI परिचय**
- **मूलभूत समज**: मोठ्या भाषा मॉडेल्स, टोकन्स, एम्बेडिंग्ज आणि AI क्षमता समजून घेणे
- **जावा AI वातावरण**: स्प्रिंग AI आणि OpenAI SDKs चे आढावा
- **मॉडेल संदर्भ प्रोटोकॉल**: MCP चे परिचय आणि AI एजंट संवादातील त्याची भूमिका
- **व्यावहारिक अनुप्रयोग**: चॅटबॉट्स आणि सामग्री निर्मितीसह वास्तविक जगातील उदाहरणे
- **[→ अध्याय १ सुरू करा](./01-IntroToGenAI/README.md)**

### **अध्याय २: विकास वातावरण सेटअप**
- **बहु-प्रदाता संरचना**: GitHub मॉडेल्स, Azure OpenAI आणि OpenAI Java SDK एकत्रीकरण सेट करा
- **स्प्रिंग बूट + स्प्रिंग AI**: एंटरप्राइज AI अनुप्रयोग विकासासाठी सर्वोत्तम पद्धती
- **GitHub मॉडेल्स**: प्रोटोटायपिंग आणि शिकण्यासाठी मुक्त AI मॉडेल प्रवेश (कोणतेही क्रेडिट कार्ड आवश्यक नाही)
- **विकास साधने**: डॉकर कंटेनर्स, VS कोड, आणि GitHub Codespaces कॉन्फिगरेशन
- **[→ अध्याय २ सुरू करा](./02-SetupDevEnvironment/README.md)**

### **अध्याय ३: मुख्य जनरेटिव AI तंत्रे**
- **प्रॉम्प्ट इंजिनीअरिंग**: AI मॉडेलच्या उत्तम प्रतिसादांसाठी तंत्रे
- **एंबेडिंग्ज आणि व्हेक्टर ऑपरेशन्स**: सेमँटिक शोध आणि समानता जुळवणी अमलात आणा
- **रिट्रीव्हल-ऑगमेंटेड जनरेशन (RAG)**: AI आपल्या स्वतःच्या डेटासोर्सेससह एकत्र करा
- **फंक्शन कॉलिंग**: कस्टम टूल्स आणि प्लगइन्ससह AI क्षमता वाढवा
- **[→ अध्याय ३ सुरू करा](./03-CoreGenerativeAITechniques/README.md)**

### **अध्याय ४: व्यावहारिक अनुप्रयोग आणि प्रकल्प**
- **पाळीव प्राणी कथा जनरेटर** (`petstory/`): GitHub मॉडेल्स सह सर्जनशील सामग्री निर्मिती
- **Foundry Local Demo** (`foundrylocal/`): स्थानिक AI मॉडेल समाकलन OpenAI Java SDK सह
- **MCP कॅल्कुलेटर सेवा** (`calculator/`): स्प्रिंग AI सह बेसिक मॉडेल संदर्भ प्रोटोकॉल अंमलबजावणी
- **[→ अध्याय ४ सुरू करा](./04-PracticalSamples/README.md)**

### **अध्याय ५: जबाबदार AI विकास**
- **GitHub मॉडेल्स सुरक्षा**: अंगभूत सामग्री फिल्टरिंग आणि सुरक्षा यंत्रणा तपासा (कठोर अडथळे व सौम्य नाकारण्यांसह)
- **जबाबदार AI डेमो**: प्रॅक्टिकल उदाहरण जे आधुनिक AI सुरक्षा प्रणाली कशी काम करते ते दाखवते
- **सर्वोत्तम पद्धती**: नैतिक AI विकास आणि तैनातीकरिता आवश्यक मार्गदर्शक तत्त्वे
- **[→ अध्याय ५ सुरू करा](./05-ResponsibleGenAI/README.md)**

## अतिरिक्त संसाधने

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j सुरू करणाऱ्यांसाठी](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js सुरू करणाऱ्यांसाठी](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain सुरू करणाऱ्यांसाठी](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / Edge / MCP / Agents
[![AZD सुरू करणाऱ्यांसाठी](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI सुरू करणाऱ्यांसाठी](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP सुरू करणाऱ्यांसाठी](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agents सुरू करणाऱ्यांसाठी](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### जनरेटिव AI मालिकाः
[![जनरेटिव AI सुरू करणाऱ्यांसाठी](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![जनरेटिव AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![जनरेटिव AI (जावा)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![जनरेटिव AI (जावास्क्रिप्ट)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### मुख्य शिक्षण
[![ML सुरू करणाऱ्यांसाठी](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![डेटा सायन्स सुरू करणाऱ्यांसाठी](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI सुरू करणाऱ्यांसाठी](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![साइबरसुरक्षा सुरू करणाऱ्यांसाठी](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![वेब डेव्ह फॉर बिगिनर्स](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT फॉर बिगिनर्स](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR डेव्हलपमेंट फॉर बिगिनर्स](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### कोपायलट सिरीज
[![AI पेअर्ड प्रोग्रॅमिंगसाठी कोपायलट](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![C#/.NET साठी कोपायलट](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![कोपायलट अॅडव्हेंचर](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## मदत घेणे

जर आपण अडकले असाल किंवा AI अॅप्स तयार करताना कोणतेही प्रश्न असतील तर MCP विषयी चर्चा करण्यासाठी इतर शिकणारे आणि अनुभवसंपन्न डेव्हलपर्सशी सहभागी व्हा. हे एक मदतशील समुदाय आहे जिथे प्रश्न स्वागतार्ह आहेत आणि ज्ञान मोकळेपणाने सामायिक केले जाते.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

आपल्याकडे उत्पादन अभिप्राय किंवा चुका असल्यास भेट द्या:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**अस्वीकरण**:
हा दस्तऐवज AI भाषांतर सेव्हिस [Co-op Translator](https://github.com/Azure/co-op-translator) च्या मदतीने अनुवादित केला आहे. आम्ही अचूकतेसाठी प्रयत्नशील असलो तरी, कृपया लक्षात घ्या की स्वयंचलित भाषांतरांमध्ये चुका किंवा असमर्थता असू शकतात. मूळ दस्तऐवज त्याच्या मूळ भाषेतच अधिकृत स्रोत म्हणून मान्य केला पाहिजे. महत्वाची माहिती असल्यास व्यावसायिक मानवी भाषांतर करण्याचा सल्ला दिला जातो. या भाषांतराच्या वापरामुळे उद्भवणाऱ्या कोणत्याही गैरसमज किंवा चुकीच्या समजुतीबाबत आम्ही जबाबदार नाही.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->