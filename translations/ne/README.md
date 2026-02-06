# शुरुवातीहरूका लागि जेनेरेटिभ एआई - जाभा संस्करण
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/ne/beg-genai-series.8b48be9951cc574c.webp)

**समय प्रतिबद्धता**: सम्पूर्ण कार्यशाला अनलाइन बिना स्थानीय सेटअप पूरा गर्न सकिन्छ। वातावरण सेटअपमा २ मिनेट लाग्छ, नमूनाहरू अन्वेषण गर्न १-३ घन्टा लाग्न सक्छ अन्वेषण गहिराई अनुसार।

> **छिटो शुरुवात** 

१. यस रिपोजिटोरीलाई तपाईँको GitHub खातामा Fork गर्नुहोस्  
२. क्लिक गर्नुहोस् **Code** → **Codespaces** ट्याब → **...** → **New with options...**  
३. पूर्वनिर्धारितहरू प्रयोग गर्नुहोस् – यसले यस कोर्सका लागि बनाइएको Development container चयन गर्नेछ  
४. क्लिक गर्नुहोस् **Create codespace**  
५. करिब २ मिनेट पर्खनुहोस् वातावरण तयार हुनका लागि  
६. सिधै जानुहोस् [पहिलो उदाहरणमा](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **स्थानीय क्लोन गर्न मन छ?**
>
> यस रिपोजिटोरीमा ५०+ भाषा अनुवादहरू समावेश छन् जसले डाउनलोड साइज ठूलो बनाउँछ। अनुवाद बिना क्लोन गर्न, sparse checkout प्रयोग गर्नुहोस्:  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> यसले तपाईँलाई कोर्स पूरा गर्न आवश्यक सबै कुरा धेरै छिटो डाउनलोडको साथ दिन्छ।

## बहुभाषी समर्थन

### GitHub Action मार्फत समर्थित (स्वचालित र सधैं नवीनतम)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[अरबी](../ar/README.md) | [बंगाली](../bn/README.md) | [बुल्गेरियन](../bg/README.md) | [बर्मी (म्यानमार)](../my/README.md) | [चिनी (सरलीकृत)](../zh-CN/README.md) | [चिनी (परम्परागत, हङकङ)](../zh-HK/README.md) | [चिनी (परम्परागत, माकाउ)](../zh-MO/README.md) | [चिनी (परम्परागत, ताइवान)](../zh-TW/README.md) | [क्रोएशियन](../hr/README.md) | [चेक](../cs/README.md) | [डेनिश](../da/README.md) | [डच](../nl/README.md) | [इस्टोनियन](../et/README.md) | [फिन्निश](../fi/README.md) | [फ्रेन्च](../fr/README.md) | [जर्मन](../de/README.md) | [ग्रीक](../el/README.md) | [हेब्रू](../he/README.md) | [हिन्दी](../hi/README.md) | [हंगेरियन](../hu/README.md) | [इण्डोनेशियाली](../id/README.md) | [इटालियन](../it/README.md) | [जापानी](../ja/README.md) | [कन्नड](../kn/README.md) | [कोरियन](../ko/README.md) | [लिथुआनियन](../lt/README.md) | [मलय](../ms/README.md) | [मलयालम](../ml/README.md) | [मराठी](../mr/README.md) | [नेपाली](./README.md) | [नाइजीरियन पिड्जिन](../pcm/README.md) | [नर्वेजियन](../no/README.md) | [फारसी (पर्सियन)](../fa/README.md) | [पोलिश](../pl/README.md) | [पोर्चुगिज (ब्राजिल)](../pt-BR/README.md) | [पोर्चुगिज (पोर्चुगल)](../pt-PT/README.md) | [पञ्जाबी (गुरुमुखी)](../pa/README.md) | [रोमानियन](../ro/README.md) | [रुसियन](../ru/README.md) | [सर्बियन (सिरिलिक)](../sr/README.md) | [स्लोभाक](../sk/README.md) | [स्लोभेनियन](../sl/README.md) | [स्प्यानिश](../es/README.md) | [स्वाहिली](../sw/README.md) | [स्विडिश](../sv/README.md) | [टागालग (फिलिपिनो)](../tl/README.md) | [तमिल](../ta/README.md) | [तेलुगु](../te/README.md) | [थाई](../th/README.md) | [टर्किश](../tr/README.md) | [युक्रेनीयन](../uk/README.md) | [उर्दू](../ur/README.md) | [भियतनामी](../vi/README.md)

## कोर्स संरचना र सिकाई मार्ग

### **अध्याय १: जेनेरेटिभ एआई परिचय**
- **प्रमुख अवधारणाहरू**: ठूलो भाषा मोडेलहरू, टोकनहरू, एम्बेडिङहरू, र एआई क्षमताहरू बुझ्ने  
- **जाभा एआई इकोसिस्टम**: Spring AI र OpenAI SDK हरूको अवलोकन  
- **मोडेल संदर्भ प्रोटोकल**: MCP परिचय र यसको एआई एजेन्ट संचारमा भूमिका  
- **व्यावहारिक प्रयोगहरू**: वास्तविक संसारका परिस्थितिहरू जस्तै च्याटबोट र सामग्री निर्माण  
- **[→ अध्याय १ सुरु गर्नुहोस्](./01-IntroToGenAI/README.md)**

### **अध्याय २: विकास वातावरण सेटअप**
- **बहु-प्रदाता कन्फिगरेसन**: GitHub मोडेलहरू, Azure OpenAI, र OpenAI जाभा SDK इन्टिग्रेसन सेटअप  
- **स्प्रिंग बूट + स्प्रिंग एआई**: एआई एन्त्रप्राइज एप्लिकेशन विकासका उत्तम अभ्यासहरू  
- **GitHub मोडेलहरू**: प्रोटोटाइप र सिकाइका लागि निःशुल्क एआई मोडेल पहुँच (क्रेडिट कार्ड आवश्यक छैन)  
- **विकास उपकरणहरू**: Docker कन्टेनरहरू, VS Code, र GitHub Codespaces कन्फिगरेसन  
- **[→ अध्याय २ सुरु गर्नुहोस्](./02-SetupDevEnvironment/README.md)**

### **अध्याय ३: मुख्य जेनेरेटिभ एआई प्रविधिहरू**
- **प्रम्प्ट इन्जिनियरिङ**: सफल एआई मोडेल प्रतिक्रियाका प्रविधिहरू  
- **एम्बेडिङ र भेक्टर अपरेसन**: सेमेन्टिक खोज र समानता मिलान कार्यान्वयन  
- **रिट्रिभल-अग्मेन्टेड जेनेरेसन (RAG)**: एआईलाई आफ्नै डेटा स्रोतहरूसँग संयोजन गर्नुहोस्  
- **फङ्क्शन कलिङ**: कस्टम उपकरण र प्लगइनहरूसँग एआई क्षमताहरू विस्तार गर्नुहोस्  
- **[→ अध्याय ३ सुरु गर्नुहोस्](./03-CoreGenerativeAITechniques/README.md)**

### **अध्याय ४: व्यावहारिक प्रयोगहरू र परियोजनाहरू**
- **पाल्तु कथा जनरेटर** (`petstory/`): GitHub मोडेलहरूसँग रचनात्मक सामग्री निर्माण  
- **Foundry Local डेमो** (`foundrylocal/`): स्थानीय एआई मोडेल अन्तर्ग्रहण OpenAI जाभा SDK सँग  
- **MCP क्यालकुलेटर सेवा** (`calculator/`): स्प्रिंग एआईसहित आधारभूत मोडेल संदर्भ प्रोटोकल कार्यान्वयन  
- **[→ अध्याय ४ सुरु गर्नुहोस्](./04-PracticalSamples/README.md)**

### **अध्याय ५: जिम्मेवार एआई विकास**
- **GitHub मोडेलहरू सुरक्षा**: बिल्ट-इन कन्टेन्ट फिल्टरिङ र सुरक्षा यन्त्रहरू (कठोर ब्लक र नरम अस्वीकृति) परीक्षण गर्नुहोस्  
- **जिम्मेवार एआई डेमो**: आधुनिक एआई सुरक्षा प्रणालीहरू कसरी काम गर्छन् भन्ने व्यवहारिक उदाहरण  
- **उत्तम अभ्यासहरू**: नैतिक एआई विकास र परिनियोजनका लागि आवश्यक दिशा-निर्देशहरू  
- **[→ अध्याय ५ सुरु गर्नुहोस्](./05-ResponsibleGenAI/README.md)**

## थप स्रोतहरू

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain for Beginners](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / Edge / MCP / Agents
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Generative AI Series
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### मुख्य सिकाइ
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![शुरुआतीहरूका लागि वेब डेभलपमेन्ट](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![शुरुआतीहरूका लागि IoT](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![शुरुआतीहरूका लागि XR विकास](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### कोपाइलट सिरिज
[![AI जोडी प्रोग्रामिङका लागि कोपाइलट](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![C#/.NET का लागि कोपाइलट](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![कोपाइलट एडभेन्चर](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## मद्दत कसरी प्राप्त गर्ने

यदि तपाईं अड्किनु भयो वा AI अनुप्रयोगहरू बनाउने बारे कुनै प्रश्नहरू छन् भने। MCP मा साथी सिक्नेहरू र अनुभवी विकासकर्ताहरूको छलफलमा सहभागी हुनुहोस्। यो एउटा सहयोगी समुदाय हो जहाँ प्रश्नहरू स्वागतयोग्य छन् र ज्ञान स्वतन्त्र रूपमा साझा गरिन्छ।

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

यदि तपाईंलाई उत्पादन प्रतिक्रिया वा त्रुटिहरू देखापर्यो भने भ्रमण गर्नुहोस्:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**अस्वीकरण**:
यस दस्तावेजलाई AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) प्रयोग गरी अनुवाद गरिएको हो। हामी शुद्धताको लागि प्रयासरत छौं भने पनि, कृपया बुझ्नुहोस् कि स्वचालित अनुवादमा त्रुटि वा अशुद्धता हुन सक्दछ। मूल भाषाको दस्तावेजलाई आधिकारिक स्रोतको रूपमा विचार गर्नुपर्छ। महत्वपूर्ण जानकारीको लागि व्यावसायिक मानव अनुवाद सिफारिस गरिन्छ। यस अनुवादको प्रयोगबाट उत्पन्न कुनै भ्रम वा गलत व्याख्यामा हामी जिम्मेवार हुँदैनौं।
<!-- CO-OP TRANSLATOR DISCLAIMER END -->