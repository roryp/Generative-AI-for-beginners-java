# शुरुआती लोगों के लिए जनरेटिव एआई - जावा संस्करण
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/hi/beg-genai-series.8b48be9951cc574c.webp)

**समय प्रतिबद्धता**: पूरा कार्यशाला ऑनलाइन बिना स्थानीय सेटअप के पूरा किया जा सकता है। पर्यावरण सेटअप में 2 मिनट लगते हैं, नमूनों की खोज में खोज की गहराई के अनुसार 1-3 घंटे लग सकते हैं।

> **शीघ्र शुरुआत**

1. इस रिपॉजिटरी को अपने GitHub खाते में फोर्क करें
2. **Code** → **Codespaces** टैब → **...** → **New with options...** पर क्लिक करें
3. डिफ़ॉल्ट का उपयोग करें – यह इस कोर्स के लिए निर्मित विकास कंटेनर का चयन करेगा
4. **Create codespace** पर क्लिक करें
5. पर्यावरण तैयार होने के लिए लगभग 2 मिनट प्रतीक्षा करें
6. सीधे [पहले उदाहरण](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) पर जाएं

> **स्थानीय क्लोन करना पसंद है?**
>
> इस रिपॉजिटरी में 50+ भाषा अनुवाद शामिल हैं जो डाउनलोड आकार को काफी बढ़ाते हैं। बिना अनुवाद के क्लोन करने के लिए sparse checkout का उपयोग करें:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> यह आपको इस कोर्स को पूरा करने के लिए सब कुछ एक तेज़ डाउनलोड के साथ प्रदान करता है।

## बहुभाषी समर्थन

### GitHub Action के माध्यम से समर्थित (स्वचालित और हमेशा अद्यतन)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[अरबी](../ar/README.md) | [बंगाली](../bn/README.md) | [बल्गेरियाई](../bg/README.md) | [बर्मी (म्यांमार)](../my/README.md) | [चीनी (सरलीकृत)](../zh-CN/README.md) | [चीनी (पारंपरिक, हांगकांग)](../zh-HK/README.md) | [चीनी (पारंपरिक, मकाओ)](../zh-MO/README.md) | [चीनी (पारंपरिक, ताइवान)](../zh-TW/README.md) | [क्रोएशियन](../hr/README.md) | [चेक](../cs/README.md) | [डेनिश](../da/README.md) | [डच](../nl/README.md) | [एस्टोनियाई](../et/README.md) | [फिनिश](../fi/README.md) | [फ्रेंच](../fr/README.md) | [जर्मन](../de/README.md) | [ग्रीक](../el/README.md) | [हिब्रू](../he/README.md) | [हिंदी](./README.md) | [हंगेरियन](../hu/README.md) | [इंडोनेशियाई](../id/README.md) | [इतालवी](../it/README.md) | [जापानी](../ja/README.md) | [कन्नड़](../kn/README.md) | [कोरियाई](../ko/README.md) | [लिथुआनियाई](../lt/README.md) | [मलय](../ms/README.md) | [मलयालम](../ml/README.md) | [मराठी](../mr/README.md) | [नेपाली](../ne/README.md) | [नाइजीरियाई पिजिन](../pcm/README.md) | [नॉर्वेजियन](../no/README.md) | [फ़ारसी (फारसी)](../fa/README.md) | [पोलिश](../pl/README.md) | [पुर्तगाली (ब्राज़ील)](../pt-BR/README.md) | [पुर्तगाली (पुर्तगाल)](../pt-PT/README.md) | [पंजाबी (गुरमुखी)](../pa/README.md) | [रोमानियाई](../ro/README.md) | [रूसी](../ru/README.md) | [सर्बियाई (सिरिलिक)](../sr/README.md) | [स्लोवाक](../sk/README.md) | [स्लोवेनियाई](../sl/README.md) | [स्पेनिश](../es/README.md) | [स्वाहिली](../sw/README.md) | [स्वीडिश](../sv/README.md) | [टागालोग (फिलीपीनी)](../tl/README.md) | [तमिल](../ta/README.md) | [तेलुगु](../te/README.md) | [थाई](../th/README.md) | [तुर्की](../tr/README.md) | [यूक्रेनी](../uk/README.md) | [उर्दू](../ur/README.md) | [वियतनामी](../vi/README.md)

## पाठ्यक्रम संरचना और सीखने का मार्ग

### **अध्याय 1: जनरेटिव एआई का परिचय**
- **मूल अवधारणाएँ**: बड़े भाषा मॉडल्स, टोकन, एम्बेडिंग, और एआई क्षमताओं को समझना
- **जावा एआई इकोसिस्टम**: स्प्रिंग एआई और ओपनएआई SDKs का अवलोकन
- **मॉडल संदर्भ प्रोटोकॉल**: MCP का परिचय और AI एजेंट संचार में इसकी भूमिका
- **व्यावहारिक अनुप्रयोग**: चैटबॉट और सामग्री निर्माण सहित वास्तविक दुनिया के परिदृश्य
- **[→ अध्याय 1 शुरू करें](./01-IntroToGenAI/README.md)**

### **अध्याय 2: विकास पर्यावरण सेटअप**
- **मल्टी-प्रोवाइडर कॉन्फ़िगरेशन**: GitHub मॉडल, Azure OpenAI, और OpenAI जावा SDK इंटीग्रेशन सेट करें
- **स्प्रिंग बूट + स्प्रिंग एआई**: एंटरप्राइज AI एप्लिकेशन विकास के लिए सर्वोत्तम प्रथाएं
- **GitHub मॉडल**: प्रोटोटाइपिंग और सीखने के लिए मुफ्त AI मॉडल एक्सेस (कोई क्रेडिट कार्ड आवश्यक नहीं)
- **विकास उपकरण**: डॉकर कंटेनर, VS कोड, और GitHub Codespaces कॉन्फ़िगरेशन
- **[→ अध्याय 2 शुरू करें](./02-SetupDevEnvironment/README.md)**

### **अध्याय 3: कोर जनरेटिव एआई तकनीकें**
- **प्रॉम्प्ट इंजीनियरिंग**: AI मॉडल के सर्वोत्तम प्रतिक्रियाओं के लिए तकनीकें
- **एम्बेडिंग और वेक्टर ऑपरेशन**: सेमांटिक खोज और समानता मिलान लागू करें
- **रिकवरी-अगुमेंटेड जनरेशन (RAG)**: AI को अपने डेटा स्रोतों के साथ मिलाएं
- **फंक्शन कॉलिंग**: कस्टम टूल और प्लगइन्स के साथ AI क्षमताओं का विस्तार करें
- **[→ अध्याय 3 शुरू करें](./03-CoreGenerativeAITechniques/README.md)**

### **अध्याय 4: व्यावहारिक अनुप्रयोग और परियोजनाएं**
- **पेट स्टोरी जनरेटर** (`petstory/`): GitHub मॉडल के साथ रचनात्मक सामग्री निर्माण
- **फाउंड्री लोकल डेमो** (`foundrylocal/`): OpenAI जावा SDK के साथ स्थानीय AI मॉडल इंटीग्रेशन
- **MCP कैलकुलेटर सेवा** (`calculator/`): स्प्रिंग AI के साथ बेसिक मॉडल संदर्भ प्रोटोकॉल कार्यान्वयन
- **[→ अध्याय 4 शुरू करें](./04-PracticalSamples/README.md)**

### **अध्याय 5: ज़िम्मेदार AI विकास**
- **GitHub मॉडल सुरक्षा**: बिल्ट-इन कंटेंट फ़िल्टरिंग और सुरक्षा तंत्र का परीक्षण (कठोर ब्लॉक्स और सौम्य अस्वीकृतियाँ)
- **ज़िम्मेदार AI डेमो**: दिखाने वाला उदाहरण कि हाल के AI सुरक्षा सिस्टम व्यावहार में कैसे काम करते हैं
- **सर्वोत्तम प्रथाएं**: नैतिक AI विकास और परिनियोजन के लिए आवश्यक दिशानिर्देश
- **[→ अध्याय 5 शुरू करें](./05-ResponsibleGenAI/README.md)**

## अतिरिक्त संसाधन

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain for Beginners](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / एड्ज / MCP / एजेंट्स
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### जनरेटिव AI श्रृंखला
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---

### कोर लर्निंग
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Copilot श्रृंखला
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## सहायता प्राप्त करना

यदि आप फंस जाते हैं या एआई ऐप बनाने के बारे में कोई प्रश्न हैं। सहयोगी शिक्षार्थियों और अनुभवी डेवलपर्स के साथ MCP पर चर्चाओं में शामिल हों। यह एक सहायक समुदाय है जहां प्रश्नों का स्वागत है और ज्ञान मुक्त रूप से साझा किया जाता है।

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

यदि आपके पास उत्पाद प्रतिक्रिया है या निर्माण के दौरान त्रुटियां हैं तो यहां जाएं:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**अस्वीकरण**:  
इस दस्तावेज़ का अनुवाद एआई अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) का उपयोग करके किया गया है। जबकि हम सटीकता के लिए प्रयासरत हैं, कृपया ध्यान दें कि स्वचालित अनुवाद में त्रुटियाँ या अशुद्धियाँ हो सकती हैं। मूल दस्तावेज़ को उसकी मातृभाषा में ही अधिकारिक स्रोत माना जाना चाहिए। महत्वपूर्ण जानकारी के लिए पेशेवर मानव अनुवाद की सिफारिश की जाती है। इस अनुवाद के उपयोग से उत्पन्न किसी भी गलतफहमी या गलत व्याख्या के लिए हम उत्तरदायी नहीं हैं।
<!-- CO-OP TRANSLATOR DISCLAIMER END -->