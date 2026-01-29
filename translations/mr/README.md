# जनरेटिव AI सुरुवातीसाठी - जावा आवृत्ती
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![जनरेटिव AI सुरुवातीसाठी - जावा आवृत्ती](../../translated_images/mr/beg-genai-series.8b48be9951cc574c.webp)

**वेळ प्रतिबद्धता**: संपूर्ण कार्यशाळा ऑनलाईन पूर्ण केली जाऊ शकते, स्थानिक सेटअपशिवाय. पर्यावरण सेटअपसाठी २ मिनिटे लागतात, आणि नमुन्यांचे अन्वेषण करण्यासाठी १-३ तास लागू शकतात, अन्वेषणाच्या खोलीनुसार.

> **त्वरित प्रारंभ**

1. हा रेपॉझिटरी आपल्या GitHub खात्यावर Fork करा
2. क्लिक करा **Code** → **Codespaces** टॅब → **...** → **New with options...**
3. डीफॉल्ट वापरा – हे या कोर्ससाठी तयार केलेल्या विकास कंटेनरची निवड करेल
4. क्लिक करा **Create codespace**
5. सुमारे २ मिनिटे प्रतीक्षा करा पर्यावरण तयार होईपर्यंत
6. थेट जाऊन बघा [पहिले उदाहरण](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **स्थानिक क्लोन करायला प्राधान्य देता का?**
>
> या रेपॉझिटरीमध्ये ५०+ भाषा अनुवादांचा समावेश आहे ज्यामुळे डाउनलोड आकार मोठा होतो. अनुवादांशिवाय क्लोन करण्यासाठी, sparse checkout वापरा:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> हे आपल्याला कोर्स पूर्ण करण्यासाठी आवश्यक सर्व काही अधिक वेगवान डाउनलोडसह देते.

## बहुभाषी समर्थन

### GitHub Action मधून समर्थित (स्वयंचलित व नेहमी अद्ययावत)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[अरबी](../ar/README.md) | [बंगाली](../bn/README.md) | [बुलगेरियन](../bg/README.md) | [बर्मी (म्यानमार)](../my/README.md) | [चिनी (सरळ)](../zh-CN/README.md) | [चिनी (परंपरागत, हॉन्ग कॉंग)](../zh-HK/README.md) | [चिनी (परंपरागत, मकाव)](../zh-MO/README.md) | [चिनी (परंपरागत, तैवान)](../zh-TW/README.md) | [क्रोएशियन](../hr/README.md) | [झेक](../cs/README.md) | [डेनेशियन](../da/README.md) | [डच](../nl/README.md) | [एस्तोनीयन](../et/README.md) | [फिनिश](../fi/README.md) | [फ्रेंच](../fr/README.md) | [जर्मन](../de/README.md) | [ग्रीक](../el/README.md) | [हिब्रू](../he/README.md) | [हिंदी](../hi/README.md) | [हंगेरीयन](../hu/README.md) | [इंडोनेशियन](../id/README.md) | [इटालियन](../it/README.md) | [जपानी](../ja/README.md) | [कन्नड](../kn/README.md) | [कोरियन](../ko/README.md) | [लिथुआनियन](../lt/README.md) | [मलय](../ms/README.md) | [मलयाळम](../ml/README.md) | [मराठी](./README.md) | [नेपाली](../ne/README.md) | [नायजेरियन पिजिन](../pcm/README.md) | [नॉर्वेजियन](../no/README.md) | [फारसी (पर्शियन)](../fa/README.md) | [पोलिश](../pl/README.md) | [पॉर्तुगाली (ब्राझील)](../pt-BR/README.md) | [पॉर्तुगाली (पोर्तुगाल)](../pt-PT/README.md) | [पंजाबी (गुरमुखी)](../pa/README.md) | [रोमानीयन](../ro/README.md) | [रशियन](../ru/README.md) | [सर्बियन (सिरिलिक)](../sr/README.md) | [स्लोव्हाक](../sk/README.md) | [स्लोव्हेनियन](../sl/README.md) | [स्पॅनिश](../es/README.md) | [स्वाहिली](../sw/README.md) | [स्वीडिश](../sv/README.md) | [टागालॉग (फिलिपिनो)](../tl/README.md) | [तमिळ](../ta/README.md) | [तेलुगू](../te/README.md) | [थाई](../th/README.md) | [टर्किश](../tr/README.md) | [युक्रेनियन](../uk/README.md) | [उर्दू](../ur/README.md) | [व्हिएतनामी](../vi/README.md)

> **स्थानिक क्लोन करायला प्राधान्य देता का?**

> या रेपॉझिटरीमध्ये ५०+ भाषा अनुवादांचा समावेश आहे ज्यामुळे डाउनलोड आकार मोठा होतो. अनुवादांशिवाय क्लोन करण्यासाठी, sparse checkout वापरा:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> हे आपल्याला कोर्स पूर्ण करण्यासाठी आवश्यक सर्व काही अधिक वेगवान डाउनलोडसह देते.
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## अभ्यासक्रम रचना व शिकण्याचा मार्ग

### **अध्याय १: जनरेटिव AI परिचय**
- **मूळ संकल्पना**: मोठ्या भाषा मॉडेल्स, टोकन्स, एम्बेडिंग्ज आणि AI क्षमतांचा समज
- **जावा AI पर्यावरण**: स्प्रिंग AI आणि OpenAI SDK ची ओळख
- **मॉडेल कॉन्टेक्स्ट प्रोटोकॉल**: MCP ची ओळख आणि AI एजंट संप्रेषणातील भूमिका
- **प्रायोगिक अनुप्रयोग**: चाटबॉट्स आणि कंटेंट निर्मिती यांसारख्या वास्तव जगातील अवस्था
- **[→ सुरुवात करा अध्याय १](./01-IntroToGenAI/README.md)**

### **अध्याय २: विकास पर्यावरण सेटअप**
- **बहु-प्रदाता कॉन्फिगरेशन**: GitHub मॉडेल्स, Azure OpenAI आणि OpenAI जावा SDK इंटिग्रेशन
- **स्प्रिंग बूट + स्प्रिंग AI**: एंटरप्राईज AI अॅप्लिकेशन विकासासाठी उत्तम प्रथांचा वापर
- **GitHub मॉडेल्स**: झीजासाठी व शिकण्यासाठी मोफत AI मॉडेल प्रवेश (क्रेडिट कार्ड नको)
- **विकास साधने**: डॉकर कंटेनर्स, VS कोड, आणि GitHub Codespaces सेटअप
- **[→ सुरुवात करा अध्याय २](./02-SetupDevEnvironment/README.md)**

### **अध्याय ३: मुख्य जनरेटिव AI तंत्रे**
- **प्रॉम्प्ट इंजिनिअरिंग**: AI मॉडेल प्रतिक्रियेसाठी तंत्रे
- **एम्बेडिंग्ज व व्हेक्टर ऑपरेशन्स**: सेमॅंटिक शोध व सादृश्यता जुळवणीची अंमलबजावणी
- **रिट्रीव्हल-अगमेंटेड जनरेशन (RAG)**: AI चे आपल्या डेटा स्रोतांसह संयोजन
- **फंक्शन कॉलिंग**: कस्टम साधने आणि प्लगइन्ससह AI क्षमता वाढवा
- **[→ सुरुवात करा अध्याय ३](./03-CoreGenerativeAITechniques/README.md)**

### **अध्याय ४: व्यावहारिक अनुप्रयोग व प्रकल्प**
- **पाळीव कथा जनरेटर** (`petstory/`): GitHub मॉडेल्ससह सर्जनशील कंटेंट निर्मिती
- **Foundry स्थानिक डेमो** (`foundrylocal/`): OpenAI जावा SDK सह स्थानिक AI मॉडेल इंटिग्रेशन
- **MCP कॅल्क्युलेटर सेवा** (`calculator/`): स्प्रिंग AI सह बेसिक मॉडेल कॉन्टेक्स्ट प्रोटोकॉलची अंमलबजावणी
- **[→ सुरुवात करा अध्याय ४](./04-PracticalSamples/README.md)**

### **अध्याय ५: जबाबदार AI विकास**
- **GitHub मॉडेल्स सुरक्षा**: अंगभूत कंटेंट फिल्टरेशन आणि सुरक्षा यंत्रणा (कठोर रोखणे आणि सौम्य नकार)
- **जबाबदार AI डेमो**: आधुनिक AI सुरक्षा प्रणाली कशी कार्य करते हे दाखवणारे प्रत्यक्ष उदाहरण
- **अत्यावश्यक मार्गदर्शक तत्त्वे**: नैतिक AI विकास व तैनातीसाठी आवश्यक मार्गदर्शन
- **[→ सुरुवात करा अध्याय ५](./05-ResponsibleGenAI/README.md)**

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
 
### जनरेटिव AI सिरीज
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
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Copilot मालिका
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## मदत मिळवा

जर आपण अडकले असाल किंवा AI अ‍ॅप्स तयार करताना काही प्रश्न असतील तर MCP विषयी चर्चा करण्यासाठी सहकार्य शिकणारे आणि अनुभवी विकासकांमध्ये सामील व्हा. ही एक सहकार्यशील समुदाय आहे जिथे प्रश्न विचारले जातात आणि ज्ञान मोकळेपणाने शेअर केले जाते.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

आपल्याकडे उत्पादनाबाबत अभिप्राय किंवा तयार करताना त्रुटी असतील तर भेट द्या:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**विज्ञप्ती**:  
हा दस्तऐवज AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) चा वापर करून अनुवादित केला आहे. आम्ही अचूकतेसाठी प्रयत्न करत असलो तरी, कृपया लक्षात घ्या की स्वयंचलित अनुवादांमध्ये चुका किंवा अचूकतेची कमतरता असू शकते. मूळ दस्तऐवज त्याच्या स्थानिक भाषेत अधिकृत स्रोत मानला जावा. महत्त्वाच्या माहितीसाठी व्यावसायिक मानवी अनुवाद शिफारसीय आहे. या अनुवादाच्या वापरामुळे उद्भवणाऱ्या कोणत्याही गैरसमजुती किंवा चुकीच्या अर्थसाधनेच्या जबाबदारी आम्ही स्वीकारत नाही.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->