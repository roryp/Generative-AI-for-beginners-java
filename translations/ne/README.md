# शुरुवातीहरूको लागि जेनेरेटिभ AI - जाभा संस्करण
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/ne/beg-genai-series.8b48be9951cc574c.webp)

**समय प्रतिबद्धता**: सम्पूर्ण कार्यशाला अनलाइन सम्पूर्ण रूपमा स्थानीय सेटअप बिना सम्पन्न गर्न सकिन्छ। वातावरण सेटअपमा २ मिनेट लाग्छ, नमूनाहरू अन्वेषण गर्न १-३ घण्टा लाग्न सक्छ जसले अन्वेषणको गहिराईमा निर्भर गर्दछ।

> **छिटो सुरु गर्ने तरिका** 

१. यो रिपोजिटरीलाई आफ्नो GitHub खातामा Fork गर्नुहोस्  
२. Click **Code** → **Codespaces** ट्याब → **...** → **New with options...**  
३. पूर्वनिर्धारित सेटिङहरू प्रयोग गर्नुहोस् – यसले यस कोर्सका लागि बनाइएको विकास कन्टेनर चयन गर्नेछ  
४. Click **Create codespace**  
५. ~२ मिनेट पर्खनुहोस्, वातावरण तयार हुनेछ  
६. सिधै [पहिलो उदाहरण](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) मा जानुहोस्

> **स्थानीय क्लोन गर्न चाहनुहुन्छ?**  
>  
> यो रिपोजिटरीमा ५०+ भाषा अनुवादहरू छन् जसले डाउनलोड आकार धेरै बढाउँछ। अनुवाद बिना क्लोन गर्न sparse checkout प्रयोग गर्नुहोस्:  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> यसले कोर्स पूरा गर्न आवश्यक सबै सामग्री छिटो डाउनलोड गर्न दिन्छ।


## बहु-भाषा समर्थन

### GitHub Action मार्फत समर्थन (स्वचालित र सधैं अद्यावधिक)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[अरबी](../ar/README.md) | [बङ्गाली](../bn/README.md) | [बल्गेरियन](../bg/README.md) | [बर्मी (म्यानमार)](../my/README.md) | [चीनियाँ (सरलीकृत)](../zh-CN/README.md) | [चीनियाँ (परम्परागत, होङकङ)](../zh-HK/README.md) | [चीनियाँ (परम्परागत, मकाउ)](../zh-MO/README.md) | [चीनियाँ (परम्परागत, ताइवान)](../zh-TW/README.md) | [क्रोएशियाली](../hr/README.md) | [चेख](../cs/README.md) | [डेनिश](../da/README.md) | [डच](../nl/README.md) | [एस्टोनियन](../et/README.md) | [फिनिश](../fi/README.md) | [फ्रेन्च](../fr/README.md) | [जर्मन](../de/README.md) | [ग्रिक](../el/README.md) | [हिब्रु](../he/README.md) | [हिन्दी](../hi/README.md) | [हंगेरीयन](../hu/README.md) | [इन्डोनेशियन](../id/README.md) | [इटालियन](../it/README.md) | [जापानी](../ja/README.md) | [कन्नड](../kn/README.md) | [कोरियन](../ko/README.md) | [लिथुआनियन](../lt/README.md) | [मालय](../ms/README.md) | [मलयालम](../ml/README.md) | [मराठी](../mr/README.md) | [नेपाली](./README.md) | [नाइजेरियन पिजिन](../pcm/README.md) | [नर्वेजियन](../no/README.md) | [फारसी (पर्सियन)](../fa/README.md) | [पोलिश](../pl/README.md) | [पोर्चुगिज (ब्राजिल)](../pt-BR/README.md) | [पोर्चुगिज (पोर्चुगल)](../pt-PT/README.md) | [पञ्जाबी (गुरमुखी)](../pa/README.md) | [रोमानियन](../ro/README.md) | [रूसी](../ru/README.md) | [सर्बियन (सिरिलिक)](../sr/README.md) | [स्लोभाक](../sk/README.md) | [स्लोभेनियन](../sl/README.md) | [स्पेनी](../es/README.md) | [स्वाहिली](../sw/README.md) | [स्विडिश](../sv/README.md) | [टागालोग (फिलिपिनो)](../tl/README.md) | [तमिल](../ta/README.md) | [तेलुगु](../te/README.md) | [थाई](../th/README.md) | [टर्किस](../tr/README.md) | [युक्रेनी](../uk/README.md) | [उर्दू](../ur/README.md) | [भियतनामी](../vi/README.md)

> **स्थानीय क्लोन गर्न चाहनुहुन्छ?**

> यो रिपोजिटरीमा ५०+ भाषा अनुवादहरू छन् जसले डाउनलोड आकार धेरै बढाउँछ। अनुवाद बिना क्लोन गर्न sparse checkout प्रयोग गर्नुहोस्:  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> यसले कोर्स पूरा गर्न आवश्यक सबै सामग्री छिटो डाउनलोड गर्न दिन्छ।  
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## कोर्सको संरचना र सिकाई मार्ग

### **अध्याय १: जेनेरेटिभ AI परिचय**
- **मूल अवधारणाहरू**: ठूलो भाषा मोडेल, टोकनहरू, एम्बेडिङहरू, र AI क्षमताहरू बुझ्नुहोस्  
- **जाभा AI इकोसिस्टम**: Spring AI र OpenAI SDKs को अवलोकन  
- **मोडेल कन्टेक्स्ट प्रोटोकल**: MCP परिचय र AI एजेन्ट संवादमा यसको भूमिका  
- **व्यावहारिक अनुप्रयोगहरू**: च्याटबोट्स र सामग्री उत्पादन लगायत वास्तविक संसारका परिदृश्यहरू  
- **[→ अध्याय १ सुरु गर्नुहोस्](./01-IntroToGenAI/README.md)**

### **अध्याय २: विकास वातावरण सेटअप**
- **बहु-प्रदायक कन्फिगरेसन**: GitHub मोडेलहरू, Azure OpenAI, र OpenAI Java SDK एकीकरणहरू सेटअप गर्नुहोस्  
- **Spring Boot + Spring AI**: उद्यम AI अनुप्रयोग विकासका लागि सर्वोत्तम अभ्यासहरू  
- **GitHub मोडेलहरू**: प्रोटोटाइप र सिक्नको लागि निःशुल्क AI मोडेल पहुँच (क्रेडिट कार्ड आवश्यक छैन)  
- **विकास उपकरणहरू**: Docker कन्टेनरहरू, VS Code, र GitHub Codespaces कन्फिगरेसन  
- **[→ अध्याय २ सुरु गर्नुहोस्](./02-SetupDevEnvironment/README.md)**

### **अध्याय ३: मुख्य जेनेरेटिभ AI प्रविधिहरू**
- **प्रम्प्ट इन्जिनियरिङ**: उत्तम AI मोडेल प्रतिक्रियाका लागि प्रविधिहरू  
- **एम्बेडिङ र भेक्टर अपरेसन**: सिमान्टिक खोज र समानता मिलान कार्यान्वयन गर्नुहोस्  
- **रिट्रीभल-अग्मेण्टेड जेनेरेसन (RAG)**: AI र आफ्नो डेटा स्रोतहरू संयोजन गर्नुहोस्  
- **फंक्शन कलिङ**: कस्टम उपकरणहरू र प्लगइन्समार्फत AI क्षमताहरू विस्तार गर्नुहोस्  
- **[→ अध्याय ३ सुरु गर्नुहोस्](./03-CoreGenerativeAITechniques/README.md)**

### **अध्याय ४: व्यावहारिक अनुप्रयोगहरू र परियोजनाहरू**
- **पाल्तु कथा जेनेरेटर** (`petstory/`): GitHub मोडेलहरूसँग सिर्जनात्मक सामग्री उत्पादन  
- **फाउन्ड्री लोकल डेमो** (`foundrylocal/`): OpenAI Java SDK सँग स्थानीय AI मोडेल एकीकरण  
- **MCP क्याल्कुलेटर सेवा** (`calculator/`): Spring AI सँग आधारभूत मोडेल कन्टेक्स्ट प्रोटोकल कार्यान्वयन  
- **[→ अध्याय ४ सुरु गर्नुहोस्](./04-PracticalSamples/README.md)**

### **अध्याय ५: जिम्मेवार AI विकास**
- **GitHub मोडेलहरूको सुरक्षा**: इनबिल्ट सामग्री फिल्टरिङ र सुरक्षा प्रणालीहरू (कडा अवरोध र मृदु अस्वीकृति) परीक्षण गर्नुहोस्  
- **जिम्मेवार AI डेमो**: आधुनिक AI सुरक्षा प्रणालीहरू कसरी काम गर्छन् भन्ने व्यावहारिक उदाहरण  
- **सर्वोत्तम अभ्यासहरू**: नैतिक AI विकास र परिनियोजनका लागि आवश्यक निर्देशहरू  
- **[→ अध्याय ५ सुरु गर्नुहोस्](./05-ResponsibleGenAI/README.md)**

## अतिरिक्त स्रोतहरू

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain  
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)  
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)  

---

### Azure / Edge / MCP / एजेन्टहरू  
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)  

---

### जेनेरेटिभ AI श्रृंखला  
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)  
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)  
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)  

---

### मुख्य सिकाई  
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)  
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)  
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)  
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)  

[![शुरुआतीहरूको लागि वेब विकास](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![शुरुआतीहरूको लागि IoT](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![शुरुआतीहरूको लागि XR विकास](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### कोपाइलट सिरिज
[![AI जोडी प्रोग्रामिङको लागि कोपाइलट](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![C#/.NET कोपाइलट](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![कोपाइलट साहसिक](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## सहायता प्राप्त गर्ने

यदि तपाईं अल्झनु भयो वा AI एपहरू बनाउने बारे कुनै प्रश्न छ भने। अन्य सिक्नेहरू र अनुभवी विकासकर्ताहरूसँग MCP सम्बन्धी छलफलमा सामेल हुनुहोस्। यो एक सहयोगी समुदाय हो जहाँ प्रश्नहरू स्वागतयोग्य छन् र ज्ञान स्वतन्त्र रूपमा साझा गरिन्छ।

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

यदि तपाईंलाई उत्पादन प्रतिक्रिया वा बनाउने क्रममा त्रुटिहरू भएमा भ्रमण गर्नुहोस्:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**अस्वीकरण**:
यो दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) प्रयोग गरी अनुवाद गरिएको हो। हामी शुद्धताको प्रयास गर्छौं, तर कृपया बुझ्नुहोस् कि स्वचालित अनुवादमा त्रुटि वा अशुद्धता हुन सक्दछ। मूल दस्तावेज़ यसको मूल भाषामा नै आधिकारिक स्रोत मानिनेछ। महत्वपूर्ण जानकारीको लागि व्यावसायिक मानव अनुवाद सिफारिस गरिन्छ। यस अनुवादको प्रयोगबाट हुने कुनै पनि गलतफहमी वा गलत व्याख्याका लागि हामी जिम्मेवार हुनेछैनौं।
<!-- CO-OP TRANSLATOR DISCLAIMER END -->