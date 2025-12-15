<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0efa90a880213da0aeb35e43ec717e98",
  "translation_date": "2025-12-01T08:27:14+00:00",
  "source_file": "README.md",
  "language_code": "mr"
}
-->
# नवशिक्यांसाठी जनरेटिव्ह AI - जावा एडिशन
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![नवशिक्यांसाठी जनरेटिव्ह AI - जावा एडिशन](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.mr.png)

**वेळेची गरज**: संपूर्ण कार्यशाळा स्थानिक सेटअपशिवाय ऑनलाइन पूर्ण केली जाऊ शकते. वातावरण सेटअपसाठी 2 मिनिटे लागतात, तर नमुन्यांचा अभ्यास करण्यासाठी 1-3 तास लागतात, अभ्यासाच्या खोलीवर अवलंबून.

> **जलद सुरुवात**

1. या रिपॉझिटरीला तुमच्या GitHub खात्यावर फोर्क करा
2. **Code** → **Codespaces** टॅब → **...** → **New with options...** वर क्लिक करा
3. डीफॉल्ट्स वापरा – हे या कोर्ससाठी तयार केलेल्या Development कंटेनरची निवड करेल
4. **Create codespace** वर क्लिक करा
5. वातावरण तयार होण्यासाठी सुमारे 2 मिनिटे थांबा
6. [पहिल्या उदाहरणाकडे](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) थेट जा

## बहुभाषिक समर्थन

### GitHub Action द्वारे समर्थित (स्वयंचलित आणि नेहमी अद्ययावत)

[अरबी](../ar/README.md) | [बंगाली](../bn/README.md) | [बल्गेरियन](../bg/README.md) | [बर्मी (म्यानमार)](../my/README.md) | [चिनी (सरलीकृत)](../zh/README.md) | [चिनी (पारंपरिक, हाँगकाँग)](../hk/README.md) | [चिनी (पारंपरिक, मकाऊ)](../mo/README.md) | [चिनी (पारंपरिक, तैवान)](../tw/README.md) | [क्रोएशियन](../hr/README.md) | [झेक](../cs/README.md) | [डॅनिश](../da/README.md) | [डच](../nl/README.md) | [एस्टोनियन](../et/README.md) | [फिनिश](../fi/README.md) | [फ्रेंच](../fr/README.md) | [जर्मन](../de/README.md) | [ग्रीक](../el/README.md) | [हिब्रू](../he/README.md) | [हिंदी](../hi/README.md) | [हंगेरियन](../hu/README.md) | [इंडोनेशियन](../id/README.md) | [इटालियन](../it/README.md) | [जपानी](../ja/README.md) | [कन्नड](../kn/README.md) | [कोरियन](../ko/README.md) | [लिथुआनियन](../lt/README.md) | [मलय](../ms/README.md) | [मल्याळम](../ml/README.md) | [मराठी](./README.md) | [नेपाळी](../ne/README.md) | [नायजेरियन पिडगिन](../pcm/README.md) | [नॉर्वेजियन](../no/README.md) | [पर्शियन (फारसी)](../fa/README.md) | [पोलिश](../pl/README.md) | [पोर्तुगीज (ब्राझील)](../br/README.md) | [पोर्तुगीज (पोर्तुगाल)](../pt/README.md) | [पंजाबी (गुरमुखी)](../pa/README.md) | [रोमानियन](../ro/README.md) | [रशियन](../ru/README.md) | [सर्बियन (सिरिलिक)](../sr/README.md) | [स्लोव्हाक](../sk/README.md) | [स्लोव्हेनियन](../sl/README.md) | [स्पॅनिश](../es/README.md) | [स्वाहिली](../sw/README.md) | [स्वीडिश](../sv/README.md) | [टागालोग (फिलिपिनो)](../tl/README.md) | [तमिळ](../ta/README.md) | [तेलुगू](../te/README.md) | [थाई](../th/README.md) | [तुर्की](../tr/README.md) | [युक्रेनियन](../uk/README.md) | [उर्दू](../ur/README.md) | [व्हिएतनामी](../vi/README.md)

## कोर्सची रचना आणि शिकण्याचा मार्ग

### **अध्याय 1: जनरेटिव्ह AI ची ओळख**
- **मूलभूत संकल्पना**: मोठ्या भाषा मॉडेल्स, टोकन्स, एम्बेडिंग्स आणि AI क्षमता समजून घेणे
- **जावा AI इकोसिस्टम**: Spring AI आणि OpenAI SDKs चा आढावा
- **मॉडेल कॉन्टेक्स्ट प्रोटोकॉल**: MCP आणि AI एजंट कम्युनिकेशनमधील त्याची भूमिका
- **व्यावहारिक उपयोग**: चॅटबॉट्स आणि सामग्री निर्मिती यासह वास्तविक जगातील उदाहरणे
- **[→ अध्याय 1 सुरू करा](./01-IntroToGenAI/README.md)**

### **अध्याय 2: विकास वातावरण सेटअप**
- **मल्टी-प्रोव्हायडर कॉन्फिगरेशन**: GitHub Models, Azure OpenAI, आणि OpenAI Java SDK एकत्रीकरण सेटअप करा
- **Spring Boot + Spring AI**: एंटरप्राइझ AI अनुप्रयोग विकासासाठी सर्वोत्तम पद्धती
- **GitHub Models**: प्रोटोटायपिंग आणि शिकण्यासाठी मोफत AI मॉडेल प्रवेश (क्रेडिट कार्ड आवश्यक नाही)
- **विकास साधने**: Docker कंटेनर्स, VS Code, आणि GitHub Codespaces कॉन्फिगरेशन
- **[→ अध्याय 2 सुरू करा](./02-SetupDevEnvironment/README.md)**

### **अध्याय 3: मुख्य जनरेटिव्ह AI तंत्र**
- **प्रॉम्प्ट इंजिनिअरिंग**: AI मॉडेल्सकडून उत्तम प्रतिसाद मिळवण्यासाठी तंत्र
- **एम्बेडिंग्स आणि व्हेक्टर ऑपरेशन्स**: सिमॅंटिक सर्च आणि साम्य जुळणी अंमलात आणणे
- **रिट्रीव्हल-अगमेंटेड जनरेशन (RAG)**: AI ला तुमच्या स्वतःच्या डेटा स्रोतांसह एकत्र करा
- **फंक्शन कॉलिंग**: कस्टम टूल्स आणि प्लगइन्ससह AI क्षमता वाढवा
- **[→ अध्याय 3 सुरू करा](./03-CoreGenerativeAITechniques/README.md)**

### **अध्याय 4: व्यावहारिक उपयोग आणि प्रकल्प**
- **पेट स्टोरी जनरेटर** (`petstory/`): GitHub Models सह सर्जनशील सामग्री निर्मिती
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK सह स्थानिक AI मॉडेल एकत्रीकरण
- **MCP कॅल्क्युलेटर सेवा** (`calculator/`): Spring AI सह मूलभूत मॉडेल कॉन्टेक्स्ट प्रोटोकॉल अंमलबजावणी
- **[→ अध्याय 4 सुरू करा](./04-PracticalSamples/README.md)**

### **अध्याय 5: जबाबदार AI विकास**
- **GitHub Models सुरक्षा**: अंगभूत सामग्री फिल्टरिंग आणि सुरक्षा यंत्रणा (हार्ड ब्लॉक्स आणि सॉफ्ट नकार) चाचणी करा
- **जबाबदार AI डेमो**: आधुनिक AI सुरक्षा प्रणाली प्रत्यक्षात कशा कार्य करतात याचे हाताळण्यायोग्य उदाहरण
- **सर्वोत्तम पद्धती**: नैतिक AI विकास आणि तैनातीसाठी आवश्यक मार्गदर्शक तत्त्वे
- **[→ अध्याय 5 सुरू करा](./05-ResponsibleGenAI/README.md)**

## अतिरिक्त संसाधने

### Azure / Edge / MCP / एजंट्स
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### जनरेटिव्ह AI मालिका
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
[![C#/.NET साठी Copilot](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)  
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)  
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## मदत मिळवा

जर तुम्ही अडकलात किंवा AI अॅप्स तयार करण्याबद्दल काही प्रश्न असतील, तर MCP वर चर्चा करण्यासाठी इतर शिकणाऱ्यांशी आणि अनुभवी विकसकांशी सामील व्हा. ही एक सहायक समुदाय आहे जिथे प्रश्न विचारले जातात आणि ज्ञान मुक्तपणे सामायिक केले जाते.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

जर तुम्हाला उत्पादनाबद्दल अभिप्राय द्यायचा असेल किंवा तयार करताना काही त्रुटी आढळल्या तर येथे भेट द्या:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**अस्वीकरण**:  
हा दस्तऐवज AI भाषांतर सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) वापरून भाषांतरित करण्यात आला आहे. आम्ही अचूकतेसाठी प्रयत्नशील असलो तरी, कृपयास लक्षात ठेवा की स्वयंचलित भाषांतरे त्रुटी किंवा अचूकतेच्या अभावाने युक्त असू शकतात. मूळ भाषेतील दस्तऐवज हा अधिकृत स्रोत मानला जावा. महत्त्वाच्या माहितीसाठी, व्यावसायिक मानवी भाषांतराची शिफारस केली जाते. या भाषांतराचा वापर करून उद्भवलेल्या कोणत्याही गैरसमज किंवा चुकीच्या अर्थासाठी आम्ही जबाबदार राहणार नाही.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->