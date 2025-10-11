<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:23:01+00:00",
  "source_file": "README.md",
  "language_code": "hi"
}
-->
# शुरुआती लोगों के लिए जनरेटिव एआई - जावा संस्करण
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![शुरुआती लोगों के लिए जनरेटिव एआई - जावा संस्करण](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.hi.png)

**समय की आवश्यकता**: पूरा वर्कशॉप ऑनलाइन बिना किसी लोकल सेटअप के पूरा किया जा सकता है। पर्यावरण सेटअप में 2 मिनट लगते हैं, और नमूनों का अन्वेषण करने में 1-3 घंटे लग सकते हैं, यह इस बात पर निर्भर करता है कि आप कितनी गहराई से अन्वेषण करते हैं।

> **त्वरित शुरुआत** 

1. इस रिपॉजिटरी को अपने GitHub अकाउंट में फोर्क करें
2. **Code** → **Codespaces** टैब → **...** → **New with options...** पर क्लिक करें
3. डिफ़ॉल्ट विकल्पों का उपयोग करें – यह इस कोर्स के लिए बनाए गए डेवलपमेंट कंटेनर का चयन करेगा
4. **Create codespace** पर क्लिक करें
5. पर्यावरण तैयार होने के लिए ~2 मिनट प्रतीक्षा करें
6. सीधे [पहले उदाहरण](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) पर जाएं

## बहुभाषी समर्थन

### GitHub Action के माध्यम से समर्थित (स्वचालित और हमेशा अद्यतन)

[अरबी](../ar/README.md) | [बंगाली](../bn/README.md) | [बुल्गारियाई](../bg/README.md) | [बर्मी (म्यांमार)](../my/README.md) | [चीनी (सरलीकृत)](../zh/README.md) | [चीनी (पारंपरिक, हांगकांग)](../hk/README.md) | [चीनी (पारंपरिक, मकाऊ)](../mo/README.md) | [चीनी (पारंपरिक, ताइवान)](../tw/README.md) | [क्रोएशियाई](../hr/README.md) | [चेक](../cs/README.md) | [डेनिश](../da/README.md) | [डच](../nl/README.md) | [एस्टोनियाई](../et/README.md) | [फिनिश](../fi/README.md) | [फ्रेंच](../fr/README.md) | [जर्मन](../de/README.md) | [ग्रीक](../el/README.md) | [हिब्रू](../he/README.md) | [हिंदी](./README.md) | [हंगेरियन](../hu/README.md) | [इंडोनेशियाई](../id/README.md) | [इतालवी](../it/README.md) | [जापानी](../ja/README.md) | [कोरियाई](../ko/README.md) | [लिथुआनियाई](../lt/README.md) | [मलय](../ms/README.md) | [मराठी](../mr/README.md) | [नेपाली](../ne/README.md) | [नॉर्वेजियन](../no/README.md) | [फारसी (फारसी)](../fa/README.md) | [पोलिश](../pl/README.md) | [पुर्तगाली (ब्राजील)](../br/README.md) | [पुर्तगाली (पुर्तगाल)](../pt/README.md) | [पंजाबी (गुरमुखी)](../pa/README.md) | [रोमानियाई](../ro/README.md) | [रूसी](../ru/README.md) | [सर्बियाई (सिरिलिक)](../sr/README.md) | [स्लोवाक](../sk/README.md) | [स्लोवेनियाई](../sl/README.md) | [स्पेनिश](../es/README.md) | [स्वाहिली](../sw/README.md) | [स्वीडिश](../sv/README.md) | [टैगालोग (फिलिपिनो)](../tl/README.md) | [तमिल](../ta/README.md) | [थाई](../th/README.md) | [तुर्की](../tr/README.md) | [यूक्रेनी](../uk/README.md) | [उर्दू](../ur/README.md) | [वियतनामी](../vi/README.md)

## कोर्स संरचना और सीखने का मार्ग

### **अध्याय 1: जनरेटिव एआई का परिचय**
- **मुख्य अवधारणाएं**: बड़े भाषा मॉडल, टोकन, एम्बेडिंग और एआई क्षमताओं को समझना
- **जावा एआई इकोसिस्टम**: Spring AI और OpenAI SDKs का अवलोकन
- **मॉडल संदर्भ प्रोटोकॉल**: MCP और एआई एजेंट संचार में इसकी भूमिका का परिचय
- **व्यावहारिक अनुप्रयोग**: चैटबॉट्स और सामग्री निर्माण सहित वास्तविक दुनिया के परिदृश्य
- **[→ अध्याय 1 शुरू करें](./01-IntroToGenAI/README.md)**

### **अध्याय 2: विकास पर्यावरण सेटअप**
- **मल्टी-प्रोवाइडर कॉन्फ़िगरेशन**: GitHub Models, Azure OpenAI, और OpenAI Java SDK एकीकरण सेटअप करें
- **Spring Boot + Spring AI**: एंटरप्राइज एआई एप्लिकेशन विकास के लिए सर्वोत्तम प्रथाएं
- **GitHub Models**: प्रोटोटाइप और सीखने के लिए मुफ्त एआई मॉडल एक्सेस (क्रेडिट कार्ड की आवश्यकता नहीं)
- **विकास उपकरण**: Docker कंटेनर, VS Code, और GitHub Codespaces कॉन्फ़िगरेशन
- **[→ अध्याय 2 शुरू करें](./02-SetupDevEnvironment/README.md)**

### **अध्याय 3: मुख्य जनरेटिव एआई तकनीकें**
- **प्रॉम्प्ट इंजीनियरिंग**: एआई मॉडल के इष्टतम उत्तरों के लिए तकनीकें
- **एम्बेडिंग और वेक्टर ऑपरेशन्स**: सिमेंटिक सर्च और समानता मिलान को लागू करना
- **रिट्रीवल-ऑगमेंटेड जनरेशन (RAG)**: एआई को अपने डेटा स्रोतों के साथ संयोजित करना
- **फंक्शन कॉलिंग**: कस्टम टूल्स और प्लगइन्स के साथ एआई क्षमताओं का विस्तार करना
- **[→ अध्याय 3 शुरू करें](./03-CoreGenerativeAITechniques/README.md)**

### **अध्याय 4: व्यावहारिक अनुप्रयोग और प्रोजेक्ट्स**
- **पेट स्टोरी जेनरेटर** (`petstory/`): GitHub Models के साथ रचनात्मक सामग्री निर्माण
- **फाउंड्री लोकल डेमो** (`foundrylocal/`): OpenAI Java SDK के साथ लोकल एआई मॉडल एकीकरण
- **MCP कैलकुलेटर सेवा** (`calculator/`): Spring AI के साथ बुनियादी मॉडल संदर्भ प्रोटोकॉल कार्यान्वयन
- **[→ अध्याय 4 शुरू करें](./04-PracticalSamples/README.md)**

### **अध्याय 5: जिम्मेदार एआई विकास**
- **GitHub Models सुरक्षा**: अंतर्निहित सामग्री फ़िल्टरिंग और सुरक्षा तंत्र (हार्ड ब्लॉक्स और सॉफ्ट रिफ्यूजल्स) का परीक्षण करें
- **जिम्मेदार एआई डेमो**: यह दिखाने के लिए व्यावहारिक उदाहरण कि आधुनिक एआई सुरक्षा प्रणाली कैसे काम करती है
- **सर्वोत्तम प्रथाएं**: नैतिक एआई विकास और तैनाती के लिए आवश्यक दिशानिर्देश
- **[→ अध्याय 5 शुरू करें](./05-ResponsibleGenAI/README.md)**

## अतिरिक्त संसाधन 

- [शुरुआती लोगों के लिए एज एआई](https://github.com/microsoft/edgeai-for-beginners)
- [शुरुआती लोगों के लिए MCP](https://github.com/microsoft/mcp-for-beginners)
- [शुरुआती लोगों के लिए एआई एजेंट्स](https://github.com/microsoft/ai-agents-for-beginners)
- [शुरुआती लोगों के लिए जनरेटिव एआई (.NET का उपयोग करके)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [शुरुआती लोगों के लिए जनरेटिव एआई (जावा स्क्रिप्ट का उपयोग करके)](https://github.com/microsoft/generative-ai-with-javascript)
- [शुरुआती लोगों के लिए जनरेटिव एआई](https://github.com/microsoft/generative-ai-for-beginners)
- [शुरुआती लोगों के लिए मशीन लर्निंग](https://aka.ms/ml-beginners)
- [शुरुआती लोगों के लिए डेटा साइंस](https://aka.ms/datascience-beginners)
- [शुरुआती लोगों के लिए एआई](https://aka.ms/ai-beginners)
- [शुरुआती लोगों के लिए साइबर सुरक्षा](https://github.com/microsoft/Security-101)
- [शुरुआती लोगों के लिए वेब विकास](https://aka.ms/webdev-beginners)
- [शुरुआती लोगों के लिए IoT](https://aka.ms/iot-beginners)
- [शुरुआती लोगों के लिए XR विकास](https://github.com/microsoft/xr-development-for-beginners)
- [एआई पेयर प्रोग्रामिंग के लिए GitHub Copilot में महारत हासिल करें](https://aka.ms/GitHubCopilotAI)
- [C#/.NET डेवलपर्स के लिए GitHub Copilot में महारत हासिल करें](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [अपना खुद का Copilot एडवेंचर चुनें](https://github.com/microsoft/CopilotAdventures)
- [Azure AI सेवाओं के साथ RAG चैट ऐप](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## सहायता प्राप्त करना

यदि आप कहीं अटक जाते हैं या एआई ऐप्स बनाने के बारे में कोई प्रश्न है, तो जुड़ें:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

यदि आपको उत्पाद प्रतिक्रिया देनी है या निर्माण के दौरान कोई त्रुटि आती है, तो यहां जाएं:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**अस्वीकरण**:  
यह दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) का उपयोग करके अनुवादित किया गया है। जबकि हम सटीकता के लिए प्रयास करते हैं, कृपया ध्यान दें कि स्वचालित अनुवाद में त्रुटियां या अशुद्धियां हो सकती हैं। मूल दस्तावेज़ को उसकी मूल भाषा में आधिकारिक स्रोत माना जाना चाहिए। महत्वपूर्ण जानकारी के लिए, पेशेवर मानव अनुवाद की सिफारिश की जाती है। इस अनुवाद के उपयोग से उत्पन्न किसी भी गलतफहमी या गलत व्याख्या के लिए हम उत्तरदायी नहीं हैं।