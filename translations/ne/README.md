# नवप्रवर्तनशील एआई सुरूवातकर्ताहरूका लागि - जाभा संस्करण
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![नवप्रवर्तनशील एआई सुरूवातकर्ताहरूका लागि - जाभा संस्करण](../../translated_images/ne/beg-genai-series.8b48be9951cc574c.webp)

**समयको प्रतिबद्धता**: सम्पूर्ण कार्यशाला अनलाइन पूरा गर्न सकिन्छ कुनै लोकल सेटअप बिना। वातावरण सेटअप गर्न २ मिनेट लाग्छ, र नमूनाहरू अन्वेषण गर्न १-३ घण्टा लाग्न सक्छ अन्वेषणको गहिराइमा निर्भर गर्दै।

> **छिटो प्रारम्भ**

१. यो रिपोजिटोरी आफ्नो GitHub खातामा फोर्क गर्नुहोस्  
२. **Code** → **Codespaces** ट्याब → **...** → **New with options...** क्लिक गर्नुहोस्  
३. पूर्वनिर्धारित विकल्पहरू प्रयोग गर्नुहोस् – यसले यस कोर्सका लागि सिर्जना गरिएको विकास कन्टेनर चयन गर्नेछ  
४. **Create codespace** क्लिक गर्नुहोस्  
५. वातावरण तयार हुन करिब २ मिनेट प्रतीक्षा गर्नुहोस्  
६. सिधै [पहिलो उदाहरण](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) मा जानुहोस्  

> **स्थानीय रूपमा क्लोन गर्न चाहनुहुन्छ?**  
>  
> यो रिपोजिटोरीमा ५०+ भाषा अनुवादहरू छन् जुन डाउनलोड साइज धेरै बढाउँछ। अनुवादहरू बिना क्लोन गर्न sparse checkout प्रयोग गर्नुहोस्:  
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
> यसले तपाईंलाई कोर्स पूरा गर्न आवश्यक सबै कुरा छिटो डाउनलोड सहित दिन्छ।

## बहुभाषी समर्थन

### GitHub Action मार्फत समर्थित (स्वचालित र सधैं अद्यावधिक)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[अरबी](../ar/README.md) | [बङ्गाली](../bn/README.md) | [बल्गेरियन](../bg/README.md) | [बर्मेली (म्यानमार)](../my/README.md) | [चीनी (साधारण)](../zh-CN/README.md) | [चीनी (परम्परागत, हङकङ)](../zh-HK/README.md) | [चीनी (परम्परागत, मकाउ)](../zh-MO/README.md) | [चीनी (परम्परागत, ताइवान)](../zh-TW/README.md) | [क्रोएसियन](../hr/README.md) | [चेक](../cs/README.md) | [डेनिश](../da/README.md) | [डच](../nl/README.md) | [एस्टोनियन](../et/README.md) | [फिनिश](../fi/README.md) | [फ्रेन्च](../fr/README.md) | [जर्मन](../de/README.md) | [ग्रीक](../el/README.md) | [हिब्रू](../he/README.md) | [हिन्दी](../hi/README.md) | [हंगेरियन](../hu/README.md) | [इन्डोनेसियन](../id/README.md) | [इटालियन](../it/README.md) | [जापानी](../ja/README.md) | [कन्नड](../kn/README.md) | [कोरियन](../ko/README.md) | [लिथुआनियाली](../lt/README.md) | [मलय](../ms/README.md) | [मलयालम](../ml/README.md) | [मराठी](../mr/README.md) | [नेपाली](./README.md) | [नाइजेरियन पिडगिन](../pcm/README.md) | [नर्वेजियन](../no/README.md) | [फारसी (पर्शियन)](../fa/README.md) | [पोलेन्डी](../pl/README.md) | [पोर्चुगिज (ब्राजिल)](../pt-BR/README.md) | [पोर्चुगिज (पुर्तगाल)](../pt-PT/README.md) | [पञ्जाबी (गुर्णमुखी)](../pa/README.md) | [रोमानियाली](../ro/README.md) | [रूसी](../ru/README.md) | [सर्बियाली (सिरिलिक)](../sr/README.md) | [स्लोभाक](../sk/README.md) | [स्लोभेनियाली](../sl/README.md) | [स्पेनिश](../es/README.md) | [स्वाहिली](../sw/README.md) | [स्विडिश](../sv/README.md) | [टगालग (फिलिपिनो)](../tl/README.md) | [तमिल](../ta/README.md) | [तेलुगु](../te/README.md) | [थाई](../th/README.md) | [टर्की](../tr/README.md) | [यूक्रेनी](../uk/README.md) | [उर्दु](../ur/README.md) | [भियतनामी](../vi/README.md)

## कोर्स संरचना र सिकाइ पथ

### **अध्याय १: नवप्रवर्तनशील एआई परिचय**  
- **मूल अवधारणाहरू**: ठूलो भाषा मोडलहरू, टोकनहरू, एम्बेडिङहरू र एआई क्षमताहरू बुझ्न  
- **जाभा एआई पारिस्थितिकी तंत्र**: Spring AI र OpenAI SDKहरूको अवलोकन  
- **मोडेल कन्टेक्स्ट प्रोटोकल**: MCP परिचय र यसले एआई एजेन्ट संचारमा खेल्ने भूमिका  
- **व्यावहारिक प्रयोगहरू**: वास्तविक-जीवन परिदृश्यहरू, जस्तै च्याटबोटहरू र सामग्री उत्पादन  
- **[→ अध्याय १ सुरु गर्नुहोस्](./01-IntroToGenAI/README.md)**

### **अध्याय २: विकास वातावरण सेटअप**  
- **बहु-प्रदायक कन्फिगरेसन**: GitHub मोडेलहरू, Azure OpenAI, र OpenAI Java SDK समाकलन सेटअप  
- **Spring Boot + Spring AI**: एंटरप्राइज एआई अनुप्रयोग विकासका लागि उत्कृष्ट अभ्यासहरू  
- **GitHub मोडेलहरू**: प्रोटोटाइप र सिकाइका लागि निःशुल्क एआई मोडेल पहुँच (क्रेडिट कार्ड आवश्यक छैन)  
- **विकास उपकरणहरू**: Docker कन्टेनरहरू, VS कोड, र GitHub Codespaces कन्फिगरेसन  
- **[→ अध्याय २ सुरु गर्नुहोस्](./02-SetupDevEnvironment/README.md)**

### **अध्याय ३: मूल नवप्रवर्तनशील एआई प्रविधिहरू**  
- **प्रॉम्प्ट इन्जिनियरिङ**: एआई मोडेल प्रतिक्रियाहरूका लागि उत्कृष्ट प्रविधिहरू  
- **एम्बेडिङहरू र भेक्टर अपरेसनहरू**: सेम्यान्टिक खोज र समानता मिलान कार्यान्वयन गर्नुहोस्  
- **रिट्रीवल-अग्मेन्टेड जेनेरेशन (RAG)**: आफ्नो डेटा स्रोतहरूसँग AI संयोजन गर्नुहोस्  
- **फंक्शन कलिङ**: अनुकूल उपकरण र प्लगइनहरूसँग AI क्षमताहरू विस्तार गर्नुहोस्  
- **[→ अध्याय ३ सुरु गर्नुहोस्](./03-CoreGenerativeAITechniques/README.md)**

### **अध्याय ४: व्यावहारिक प्रयोगहरू र प्रोजेक्टहरू**  
- **पाल्तु कथा निर्माता** (`petstory/`): GitHub मोडेलहरूसँग रचनात्मक सामग्री उत्पादन  
- **Foundry स्थानीय प्रदर्शन** (`foundrylocal/`): OpenAI Java SDK सँग स्थानीय AI मोडेल समाकलन  
- **MCP क्यालकुलेटर सेवा** (`calculator/`): Spring AI सँग आधारभूत मोडेल कन्टेक्स्ट प्रोटोकल कार्यान्वयन  
- **[→ अध्याय ४ सुरु गर्नुहोस्](./04-PracticalSamples/README.md)**

### **अध्याय ५: जिम्मेवार AI विकास**  
- **GitHub मोडेलहरूको सुरक्षा**: निर्मित सामग्री फिल्टरिङ र सुरक्षा संयन्त्रहरू परीक्षण गर्नुहोस् (कठोर ब्लक र अस्वीकृतिहरू)  
- **जिम्मेवार AI डेमो**: आधुनिक AI सुरक्षा प्रणाली कसरी कार्य गर्दछ भनी व्यावहारिक उदाहरण  
- **उत्तम अभ्यासहरू**: नैतिक AI विकास र स्थापनाका लागि आवश्यक मार्गनिर्देशन  
- **[→ अध्याय ५ सुरु गर्नुहोस्](./05-ResponsibleGenAI/README.md)**

## अतिरिक्त स्रोतहरू

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain  
[![LangChain4j सुरूवातकर्ताहरूका लागि](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)  
[![LangChain.js सुरूवातकर्ताहरूका लागि](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)  
[![LangChain सुरूवातकर्ताहरूका लागि](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)  
---

### Azure / Edge / MCP / एजेन्टहरू  
[![AZD सुरूवातकर्ताहरूका लागि](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![Edge AI सुरूवातकर्ताहरूका लागि](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![MCP सुरूवातकर्ताहरूका लागि](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![AI एजेन्टहरू सुरूवातकर्ताहरूका लागि](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### नवप्रवर्तनशील AI श्रृंखला  
[![नवप्रवर्तनशील AI सुरूवातकर्ताहरूका लागि](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![नवप्रवर्तनशील AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)  
[![नवप्रवर्तनशील AI (जाभा)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)  
[![नवप्रवर्तनशील AI (जाभास्क्रिप्ट)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---

### मुख्य सिकाइ  
[![सुरूवातकर्ताहरूका लागि ML](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)  
[![सुरूवातकर्ताहरूका लागि डेटा विज्ञान](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)  
[![सुरूवातकर्ताहरूका लागि AI](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)  
[![सुरूवातकर्ताहरूका लागि साइबरसुरक्षा](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![शुरुआतीहरूका लागि वेब डेभ](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![शुरुआतीहरूका लागि IoT](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![शुरुआतीहरूका लागि XR विकास](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Copilot सिरिज
[![एआई जोडी प्रोग्रामिङका लागि कोपाइलट](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![C#/.NET का लागि कोपाइलट](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![कोपाइलट एड्भेन्चर](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## सहयोग कसरी पाउने

यदि तपाईं AI एपहरू बनाउँदा अड्किनुभयो वा कुनै प्रश्न छ भने, MCP सम्बन्धि छलफलमा साथी विद्यार्थी र अनुभवी विकासकर्ताहरूसँग सामेल हुनुहोस्। यो एक सहयोगी समुदाय हो जहाँ प्रश्नहरू स्वागतयोग्य छन् र ज्ञान स्वतन्त्र रूपमा बाँडिन्छ।

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

यदि तपाईंले उत्पादन सम्बन्धी प्रतिक्रिया वा त्रुटिहरू पाउनुभयो भने तल भ्रमण गर्नुहोस्:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**अस्वीकरण**:  
यस कागजातलाई AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) को माध्यमबाट अनुवाद गरिएको हो। हामी यथासम्भव शुद्धताका लागि प्रयास गर्छौं तापनि, कृपया बुझ्नुहोस् कि स्वचालित अनुवादमा गल्ती वा अशुद्धता हुन सक्दछ। मूल कागजात यसको मौलिक भाषामा आधिकारीक स्रोत मानिनु पर्दछ। महत्वपूर्ण जानकारीहरूको लागि पेशेवर मानवीय अनुवाद सिफारिस गरिन्छ। यस अनुवादको प्रयोगबाट उत्पन्न कुनै भ्रम वा गलत व्याख्याका लागि हामी जिम्मेवार हुने छैनौं।
<!-- CO-OP TRANSLATOR DISCLAIMER END -->