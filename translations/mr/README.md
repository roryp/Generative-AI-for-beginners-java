# जनरेटिव AI प्रारंभिकांसाठी - Java आवृत्ती
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![जनरेटिव AI प्रारंभिकांसाठी - Java आवृत्ती](../../translated_images/mr/beg-genai-series.8b48be9951cc574c.webp)

**वेळेची बांधिलकी**: संपूर्ण कार्यशाळा ऑनलाईन पूर्ण करता येते, स्थानिक सेटअपशिवाय. वातावरणाची सेटअप प्रक्रिया २ मिनिटांमध्ये होते, तर नमुन्यांची तपासणी गतीवर अवलंबून १-३ तास लागू शकतात.

> **झटपट प्रारंभ** 

1. हे रिपॉझिटरी आपला GitHub खात्यावर Fork करा
2. **Code** → **Codespaces** टॅब → **...** → **New with options...** क्लिक करा
3. डीफॉल्ट वापरा – यामुळे या कोर्ससाठी तयार केलेला Development कंटेनर निवडला जाईल
4. **Create codespace** क्लिक करा
5. वातावरण तयार होईपर्यंत सुमारे २ मिनिटे प्रतीक्षा करा
6. थेट [पहिल्या उदाहरणावर जा](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **स्थानिकपणे Clone करायचे आहे का?**
>
> या रिपॉझिटरीमध्ये ५०+ भाषा अनुवादांचा समावेश आहे ज्यामुळे डाउनलोडिंग साईज मोठा होतो. अनुवादांशिवाय Clone करण्यासाठी sparse checkout वापरा:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> यामुळे कोर्स पूर्ण करण्यासाठी आवश्यक सर्व काही मिळेल आणि डाउनलोड खूप जलद होईल.


## बहुभाषिक समर्थन

### GitHub Action द्वारे समर्थित (स्वयंचलित आणि सदैव अद्ययावत)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[अरबी](../ar/README.md) | [बंगाली](../bn/README.md) | [बल्गेरियन](../bg/README.md) | [बर्मीज (म्यानमार)](../my/README.md) | [चिनी (सोप्या)](../zh-CN/README.md) | [चिनी (परंपरागत, हाँगकाँग)](../zh-HK/README.md) | [चिनी (परंपरागत, मकाओ)](../zh-MO/README.md) | [चिनी (परंपरागत, तैवान)](../zh-TW/README.md) | [क्रोएशियन](../hr/README.md) | [चेक](../cs/README.md) | [डॅनिश](../da/README.md) | [डच](../nl/README.md) | [एस्टोनियन](../et/README.md) | [फिनिश](../fi/README.md) | [फ्रेंच](../fr/README.md) | [जर्मन](../de/README.md) | [ग्रीक](../el/README.md) | [हिब्रू](../he/README.md) | [हिंदी](../hi/README.md) | [हंगेरियन](../hu/README.md) | [इंडोनेशियन](../id/README.md) | [इटालियन](../it/README.md) | [जपानी](../ja/README.md) | [कन्नड](../kn/README.md) | [कोरियन](../ko/README.md) | [लिथुनियन](../lt/README.md) | [मलय](../ms/README.md) | [मलयाळम](../ml/README.md) | [मराठी](./README.md) | [नेपाली](../ne/README.md) | [नायजेरियन पिजिन](../pcm/README.md) | [नॉर्वेजियन](../no/README.md) | [फारसी (पर्शियन)](../fa/README.md) | [पोलिश](../pl/README.md) | [पोर्तुगीज (ब्राझील)](../pt-BR/README.md) | [पोर्तुगीज (पोर्तुगाल)](../pt-PT/README.md) | [पंजाबी (गुरमुखी)](../pa/README.md) | [रोमानियन](../ro/README.md) | [रशियन](../ru/README.md) | [सर्बियन (सिरिलिक)](../sr/README.md) | [स्लोव्हाक](../sk/README.md) | [स्लोव्हेनियन](../sl/README.md) | [स्पॅनिश](../es/README.md) | [स्वाहिली](../sw/README.md) | [स्वीडिश](../sv/README.md) | [टागालॉग (फिलिपिनो)](../tl/README.md) | [तमिळ](../ta/README.md) | [तेलुगू](../te/README.md) | [थाई](../th/README.md) | [तुर्किश](../tr/README.md) | [युक्रेनियन](../uk/README.md) | [उर्दू](../ur/README.md) | [व्हिएतनामी](../vi/README.md)

## कोर्स रचना आणि शिक्षणाचा मार्ग

### **अध्याय १: जनरेटिव AI परिचय**
- **मूलभूत संकल्पना**: मोठ्या भाषा मॉडेल्स, टोकन्स, ऍम्बेडिंग्ज आणि AI क्षमता समजून घेणे
- **Java AI पर्यावरण**: Spring AI आणि OpenAI SDKs चे आढावा
- **मॉडेल संदर्भ प्रोटोकॉल**: MCP चा परिचय व AI एजंट संवादातील भूमिका
- **प्रायोगिक अनुप्रयोग**: वास्तविक जीवनातील प्रकरणे, जसे की चॅटबॉट्स आणि सामग्री निर्मिती
- **[→ अध्याय १ सुरु करा](./01-IntroToGenAI/README.md)**

### **अध्याय २: विकास पर्यावरण सेटअप**
- **बहु-प्रदाता कॉन्फिगरेशन**: GitHub Models, Azure OpenAI, आणि OpenAI Java SDK चे एकत्रीकरण सेटअप करा
- **Spring Boot + Spring AI**: एंटरप्राइज AI अनुप्रयोग विकासासाठी सर्वोत्तम पद्धती
- **GitHub Models**: प्रोटोटायपिंग आणि शिक्षणासाठी मोफत AI मॉडेल प्रवेश (क्रेडिट कार्ड आवश्यक नाही)
- **विकास साधने**: Docker कंटेनर्स, VS कोड, आणि GitHub Codespaces कॉन्फिगरेशन
- **[→ अध्याय २ सुरु करा](./02-SetupDevEnvironment/README.md)**

### **अध्याय ३: कोअर जनरेटिव AI तंत्रे**
- **प्रॉम्प्ट इंजिनीअरिंग**: AI मॉडेल प्रतिसादासाठी सर्वोत्तम तंत्रे
- **ऍम्बेडिंग्ज आणि वेक्टर ऑपरेशन्स**: सिमॅंटिक शोध आणि समानता जुळणीची अंमलबजावणी
- **रिट्रीव्हल-अगमेंटेड जनरेशन (RAG)**: AI व आपल्या स्वतःच्या डेटा स्रोतांचे संयोजन
- **फंक्शन कॉलिंग**: कस्टम साधने आणि प्लगइनसह AI क्षमता वाढवा
- **[→ अध्याय ३ सुरु करा](./03-CoreGenerativeAITechniques/README.md)**

### **अध्याय ४: व्यावहारिक अनुप्रयोग आणि प्रोजेक्ट्स**
- **पेट स्टोरी जनरेटर** (`petstory/`): GitHub Models च्या माध्यमातून सर्जनशील सामग्री निर्मिती
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK सह स्थानिक AI मॉडेल एकत्रीकरण
- **MCP कॅल्क्युलेटर सेवा** (`calculator/`): Spring AI सह मूलभूत मॉडेल संदर्भ प्रोटोकॉल अंमलबजावणी
- **[→ अध्याय ४ सुरु करा](./04-PracticalSamples/README.md)**

### **अध्याय ५: जबाबदार AI विकास**
- **GitHub Models सुरक्षितता**: अंगभूत सामग्री फिल्टरेशन आणि सुरक्षितता यंत्रणा (कठोर ब्लॉक्स व सौम्य नकार) तपासा
- **जबाबदार AI Demo**: आधुनिक AI सुरक्षितता प्रणाली कशी कार्य करते याचे प्रत्यक्ष उदाहरण
- **सर्वोत्तम पद्धती**: नैतिक AI विकास व तैनातीसाठी आवश्यक मार्गदर्शक तत्त्वे
- **[→ अध्याय ५ सुरु करा](./05-ResponsibleGenAI/README.md)**

## अतिरिक्त स्रोत

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j प्रारंभिकांसाठी](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js प्रारंभिकांसाठी](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain प्रारंभिकांसाठी](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / Edge / MCP / एजंट्स
[![AZD प्रारंभिकांसाठी](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI प्रारंभिकांसाठी](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP प्रारंभिकांसाठी](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI एजंट्स प्रारंभिकांसाठी](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### जनरेटिव AI सिरीज
[![जनरेटिव AI प्रारंभिकांसाठी](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![जनरेटिव AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![जनरेटिव AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![जनरेटिव AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### कोअर शिक्षण
[![ML प्रारंभिकांसाठी](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![डेटा सायन्स प्रारंभिकांसाठी](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI प्रारंभिकांसाठी](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![साइबरसिक्युरिटी प्रारंभिकांसाठी](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Copilot मालिका
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## मदत मिळवा

जर तुम्ही अडकलात किंवा AI अॅप्स तयार करण्याबाबत कोणतेही प्रश्न असतील तर. MCP विषयी चर्चा करण्यासाठी सहपाठी शिका आणि अनुभवी विकसकांमध्ये सामील व्हा. हे एक सहकार्य करणारे समुदाय आहे जिथे प्रश्नांना स्वागत आहे आणि ज्ञान स्वच्छंदपणे शेअर केले जाते.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

जर तुम्हाला उत्पादनाबाबत अभिप्राय किंवा त्रुटी आढळल्यास भेट द्या:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**अस्वीकरण**:
हा दस्तऐवज AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) चा उपयोग करून अनुवादित केला आहे. जरी आम्ही अचूकतेसाठी प्रयत्नशील असत तरी, कृपया जाणून घ्या की स्वयंचलित अनुवादांमध्ये त्रुटी किंवा अचूकतेची गैरसोय असू शकते. मूळ दस्तऐवज त्याच्या स्थानिक भाषेत अधिकृत स्रोत मानला जावा. महत्त्वाच्या माहितीसाठी व्यावसायिक मानवी अनुवाद शिफारसीय आहे. या अनुवादाच्या वापरामुळे उद्भवणाऱ्या कोणत्याही गैरसमजुती किंवा चुकीच्या अर्थव्यवस्थेसाठी आम्ही जबाबदार नाही.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->