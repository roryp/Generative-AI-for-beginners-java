<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "6710490579e4bb2e3ec9409a3c1b1ec0",
  "translation_date": "2025-12-17T12:02:41+00:00",
  "source_file": "README.md",
  "language_code": "hi"
}
-->
# शुरुआती लोगों के लिए जनरेटिव AI - जावा संस्करण
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.hi.png)

**समय प्रतिबद्धता**: पूरा कार्यशाला ऑनलाइन बिना स्थानीय सेटअप के पूरा किया जा सकता है। पर्यावरण सेटअप में 2 मिनट लगते हैं, और नमूनों का अन्वेषण करने में 1-3 घंटे लग सकते हैं, अन्वेषण की गहराई पर निर्भर करता है।

> **त्वरित शुरुआत**

1. इस रिपॉजिटरी को अपने GitHub खाते में फोर्क करें
2. क्लिक करें **Code** → **Codespaces** टैब → **...** → **New with options...**
3. डिफ़ॉल्ट का उपयोग करें – यह इस कोर्स के लिए बनाए गए डेवलपमेंट कंटेनर का चयन करेगा
4. क्लिक करें **Create codespace**
5. पर्यावरण तैयार होने के लिए लगभग 2 मिनट प्रतीक्षा करें
6. सीधे [पहले उदाहरण](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) पर जाएं

## बहुभाषी समर्थन

### GitHub Action के माध्यम से समर्थित (स्वचालित और हमेशा अद्यतित)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](../my/README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](./README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Kannada](../kn/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Malayalam](../ml/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Nigerian Pidgin](../pcm/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../br/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Telugu](../te/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## कोर्स संरचना और सीखने का मार्ग

### **अध्याय 1: जनरेटिव AI का परिचय**
- **मूल अवधारणाएँ**: बड़े भाषा मॉडल, टोकन, एम्बेडिंग्स, और AI क्षमताओं को समझना
- **जावा AI इकोसिस्टम**: Spring AI और OpenAI SDKs का अवलोकन
- **मॉडल कॉन्टेक्स्ट प्रोटोकॉल**: MCP का परिचय और AI एजेंट संचार में इसकी भूमिका
- **व्यावहारिक अनुप्रयोग**: चैटबॉट्स और सामग्री निर्माण सहित वास्तविक दुनिया के परिदृश्य
- **[→ अध्याय 1 शुरू करें](./01-IntroToGenAI/README.md)**

### **अध्याय 2: विकास पर्यावरण सेटअप**
- **मल्टी-प्रोवाइडर कॉन्फ़िगरेशन**: GitHub मॉडल, Azure OpenAI, और OpenAI जावा SDK इंटीग्रेशन सेटअप करें
- **Spring Boot + Spring AI**: एंटरप्राइज AI एप्लिकेशन विकास के लिए सर्वोत्तम प्रथाएँ
- **GitHub मॉडल**: प्रोटोटाइपिंग और सीखने के लिए मुफ्त AI मॉडल एक्सेस (कोई क्रेडिट कार्ड आवश्यक नहीं)
- **डेवलपमेंट टूल्स**: Docker कंटेनर, VS कोड, और GitHub Codespaces कॉन्फ़िगरेशन
- **[→ अध्याय 2 शुरू करें](./02-SetupDevEnvironment/README.md)**

### **अध्याय 3: कोर जनरेटिव AI तकनीकें**
- **प्रॉम्प्ट इंजीनियरिंग**: AI मॉडल प्रतिक्रियाओं के लिए तकनीकें
- **एम्बेडिंग्स और वेक्टर ऑपरेशंस**: सेमांटिक खोज और समानता मिलान लागू करें
- **रिट्रीवल-ऑगमेंटेड जनरेशन (RAG)**: AI को अपने डेटा स्रोतों के साथ संयोजित करें
- **फंक्शन कॉलिंग**: कस्टम टूल्स और प्लगइन्स के साथ AI क्षमताओं का विस्तार करें
- **[→ अध्याय 3 शुरू करें](./03-CoreGenerativeAITechniques/README.md)**

### **अध्याय 4: व्यावहारिक अनुप्रयोग और परियोजनाएं**
- **पेट स्टोरी जनरेटर** (`petstory/`): GitHub मॉडल के साथ रचनात्मक सामग्री निर्माण
- **Foundry Local Demo** (`foundrylocal/`): OpenAI जावा SDK के साथ स्थानीय AI मॉडल इंटीग्रेशन
- **MCP कैलकुलेटर सेवा** (`calculator/`): Spring AI के साथ बेसिक मॉडल कॉन्टेक्स्ट प्रोटोकॉल कार्यान्वयन
- **[→ अध्याय 4 शुरू करें](./04-PracticalSamples/README.md)**

### **अध्याय 5: जिम्मेदार AI विकास**
- **GitHub मॉडल सुरक्षा**: अंतर्निहित सामग्री फ़िल्टरिंग और सुरक्षा तंत्र (हार्ड ब्लॉक्स और सॉफ्ट अस्वीकृतियाँ) का परीक्षण करें
- **जिम्मेदार AI डेमो**: आधुनिक AI सुरक्षा प्रणालियों के व्यावहारिक उदाहरण
- **सर्वोत्तम प्रथाएँ**: नैतिक AI विकास और तैनाती के लिए आवश्यक दिशानिर्देश
- **[→ अध्याय 5 शुरू करें](./05-ResponsibleGenAI/README.md)**

## अतिरिक्त संसाधन

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
[![शुरुआती लोगों के लिए XR विकास](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### कोपिलट श्रृंखला
[![AI युग्मित प्रोग्रामिंग के लिए कोपिलट](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![C#/.NET के लिए कोपिलट](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![कोपिलट साहसिक](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## सहायता प्राप्त करना

यदि आप फंस जाते हैं या AI ऐप्स बनाने के बारे में कोई प्रश्न है। MCP के बारे में चर्चा में साथी शिक्षार्थियों और अनुभवी डेवलपर्स के साथ जुड़ें। यह एक सहायक समुदाय है जहाँ प्रश्न स्वागत योग्य हैं और ज्ञान स्वतंत्र रूप से साझा किया जाता है।

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

यदि आपके पास उत्पाद प्रतिक्रिया या निर्माण के दौरान त्रुटियाँ हैं तो यहाँ जाएँ:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**अस्वीकरण**:  
यह दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) का उपयोग करके अनुवादित किया गया है। जबकि हम सटीकता के लिए प्रयासरत हैं, कृपया ध्यान दें कि स्वचालित अनुवादों में त्रुटियाँ या अशुद्धियाँ हो सकती हैं। मूल दस्तावेज़ अपनी मूल भाषा में प्रामाणिक स्रोत माना जाना चाहिए। महत्वपूर्ण जानकारी के लिए, पेशेवर मानव अनुवाद की सलाह दी जाती है। इस अनुवाद के उपयोग से उत्पन्न किसी भी गलतफहमी या गलत व्याख्या के लिए हम जिम्मेदार नहीं हैं।
<!-- CO-OP TRANSLATOR DISCLAIMER END -->