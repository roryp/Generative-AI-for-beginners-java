<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:24:11+00:00",
  "source_file": "README.md",
  "language_code": "ne"
}
-->
# सुरुवातीका लागि जेनेरेटिभ एआई - जाभा संस्करण
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![सुरुवातीका लागि जेनेरेटिभ एआई - जाभा संस्करण](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.ne.png)

**समय प्रतिबद्धता**: सम्पूर्ण कार्यशाला अनलाइन पूरा गर्न सकिन्छ, स्थानीय सेटअप आवश्यक छैन। वातावरण सेटअप गर्न २ मिनेट लाग्छ, र नमूनाहरू अन्वेषण गर्न १-३ घण्टा लाग्न सक्छ, अन्वेषणको गहिराइमा निर्भर गर्दै।

> **छिटो सुरु गर्नुहोस्**

1. यो रिपोजिटरीलाई आफ्नो GitHub खातामा फोर्क गर्नुहोस्
2. **Code** → **Codespaces** ट्याब → **...** → **New with options...** मा क्लिक गर्नुहोस्
3. डिफल्ट सेटिङहरू प्रयोग गर्नुहोस् – यसले यस कोर्सका लागि बनाइएको Development container चयन गर्नेछ
4. **Create codespace** मा क्लिक गर्नुहोस्
5. वातावरण तयार हुन ~२ मिनेट पर्खनुहोस्
6. [पहिलो उदाहरण](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) मा सिधै जानुहोस्

## बहुभाषिक समर्थन

### GitHub Action मार्फत समर्थित (स्वचालित र सधैं अद्यावधिक)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[अरबी](../ar/README.md) | [बंगाली](../bn/README.md) | [बुल्गेरियन](../bg/README.md) | [बर्मेली (म्यानमार)](../my/README.md) | [चिनियाँ (सरलीकृत)](../zh/README.md) | [चिनियाँ (परम्परागत, हङकङ)](../hk/README.md) | [चिनियाँ (परम्परागत, मकाउ)](../mo/README.md) | [चिनियाँ (परम्परागत, ताइवान)](../tw/README.md) | [क्रोएसियन](../hr/README.md) | [चेक](../cs/README.md) | [डेनिश](../da/README.md) | [डच](../nl/README.md) | [एस्टोनियन](../et/README.md) | [फिनिश](../fi/README.md) | [फ्रान्सेली](../fr/README.md) | [जर्मन](../de/README.md) | [ग्रीक](../el/README.md) | [हिब्रू](../he/README.md) | [हिन्दी](../hi/README.md) | [हंगेरीयन](../hu/README.md) | [इन्डोनेसियन](../id/README.md) | [इटालियन](../it/README.md) | [जापानी](../ja/README.md) | [कोरियन](../ko/README.md) | [लिथुआनियन](../lt/README.md) | [मलय](../ms/README.md) | [मराठी](../mr/README.md) | [नेपाली](./README.md) | [नर्वेजियन](../no/README.md) | [फारसी (फारसी)](../fa/README.md) | [पोलिश](../pl/README.md) | [पोर्चुगिज (ब्राजिल)](../br/README.md) | [पोर्चुगिज (पोर्चुगल)](../pt/README.md) | [पंजाबी (गुरमुखी)](../pa/README.md) | [रोमानियन](../ro/README.md) | [रुसी](../ru/README.md) | [सर्बियन (सिरिलिक)](../sr/README.md) | [स्लोभाक](../sk/README.md) | [स्लोभेनियन](../sl/README.md) | [स्पेनिश](../es/README.md) | [स्वाहिली](../sw/README.md) | [स्विडिश](../sv/README.md) | [टागालोग (फिलिपिनो)](../tl/README.md) | [तमिल](../ta/README.md) | [थाई](../th/README.md) | [टर्किश](../tr/README.md) | [युक्रेनी](../uk/README.md) | [उर्दू](../ur/README.md) | [भियतनामी](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## कोर्स संरचना र सिकाइ मार्ग

### **अध्याय १: जेनेरेटिभ एआईको परिचय**
- **मुख्य अवधारणाहरू**: ठूलो भाषा मोडेलहरू, टोकनहरू, एम्बेडिङहरू, र एआई क्षमताहरूको समझ
- **जाभा एआई इकोसिस्टम**: Spring AI र OpenAI SDKs को अवलोकन
- **मोडेल कन्टेक्स्ट प्रोटोकल**: MCP र यसको एआई एजेन्ट संचारमा भूमिका
- **व्यावहारिक प्रयोगहरू**: च्याटबोटहरू र सामग्री निर्माण जस्ता वास्तविक संसारका परिदृश्यहरू
- **[→ अध्याय १ सुरु गर्नुहोस्](./01-IntroToGenAI/README.md)**

### **अध्याय २: विकास वातावरण सेटअप**
- **बहु-प्रदायक कन्फिगरेसन**: GitHub Models, Azure OpenAI, र OpenAI Java SDK एकीकरण सेटअप गर्नुहोस्
- **Spring Boot + Spring AI**: उद्यम एआई एप्लिकेसन विकासका लागि उत्कृष्ट अभ्यासहरू
- **GitHub Models**: प्रोटोटाइप र सिकाइका लागि निःशुल्क एआई मोडेल पहुँच (क्रेडिट कार्ड आवश्यक छैन)
- **विकास उपकरणहरू**: Docker कन्टेनरहरू, VS Code, र GitHub Codespaces कन्फिगरेसन
- **[→ अध्याय २ सुरु गर्नुहोस्](./02-SetupDevEnvironment/README.md)**

### **अध्याय ३: मुख्य जेनेरेटिभ एआई प्रविधिहरू**
- **प्रम्प्ट इन्जिनियरिङ**: एआई मोडेलको उत्कृष्ट प्रतिक्रिया प्राप्त गर्नका लागि प्रविधिहरू
- **एम्बेडिङहरू र भेक्टर अपरेसनहरू**: सेम्यान्टिक खोज र समानता मिलान कार्यान्वयन गर्नुहोस्
- **रिट्रिभल-अग्मेन्टेड जेनेरेशन (RAG)**: एआईलाई आफ्नै डेटा स्रोतहरूसँग संयोजन गर्नुहोस्
- **फङ्सन कलिङ**: कस्टम उपकरणहरू र प्लगइनहरूसँग एआई क्षमताहरू विस्तार गर्नुहोस्
- **[→ अध्याय ३ सुरु गर्नुहोस्](./03-CoreGenerativeAITechniques/README.md)**

### **अध्याय ४: व्यावहारिक प्रयोगहरू र परियोजनाहरू**
- **पाल्तु कथा जनरेटर** (`petstory/`): GitHub Models प्रयोग गरेर सिर्जनात्मक सामग्री निर्माण
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK सँग स्थानीय एआई मोडेल एकीकरण
- **MCP क्यालकुलेटर सेवा** (`calculator/`): Spring AI सँग आधारभूत मोडेल कन्टेक्स्ट प्रोटोकल कार्यान्वयन
- **[→ अध्याय ४ सुरु गर्नुहोस्](./04-PracticalSamples/README.md)**

### **अध्याय ५: जिम्मेवार एआई विकास**
- **GitHub Models सुरक्षा**: सामग्री फिल्टरिङ र सुरक्षा संयन्त्रहरूको परीक्षण गर्नुहोस् (कठोर ब्लकहरू र नरम अस्वीकृतिहरू)
- **जिम्मेवार एआई डेमो**: आधुनिक एआई सुरक्षा प्रणालीहरू कसरी व्यवहारमा काम गर्छन् भन्ने देखाउने व्यावहारिक उदाहरण
- **उत्तम अभ्यासहरू**: नैतिक एआई विकास र परिनियोजनका लागि आवश्यक दिशानिर्देशहरू
- **[→ अध्याय ५ सुरु गर्नुहोस्](./05-ResponsibleGenAI/README.md)**

## थप स्रोतहरू

- [सुरुवातीका लागि Edge AI](https://github.com/microsoft/edgeai-for-beginners)
- [सुरुवातीका लागि MCP](https://github.com/microsoft/mcp-for-beginners)
- [सुरुवातीका लागि एआई एजेन्टहरू](https://github.com/microsoft/ai-agents-for-beginners)
- [सुरुवातीका लागि जेनेरेटिभ एआई (.NET प्रयोग गर्दै)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [सुरुवातीका लागि जेनेरेटिभ एआई (JavaScript प्रयोग गर्दै)](https://github.com/microsoft/generative-ai-with-javascript)
- [सुरुवातीका लागि जेनेरेटिभ एआई](https://github.com/microsoft/generative-ai-for-beginners)
- [सुरुवातीका लागि ML](https://aka.ms/ml-beginners)
- [सुरुवातीका लागि डेटा विज्ञान](https://aka.ms/datascience-beginners)
- [सुरुवातीका लागि एआई](https://aka.ms/ai-beginners)
- [सुरुवातीका लागि साइबर सुरक्षा](https://github.com/microsoft/Security-101)
- [सुरुवातीका लागि वेब विकास](https://aka.ms/webdev-beginners)
- [सुरुवातीका लागि IoT](https://aka.ms/iot-beginners)
- [सुरुवातीका लागि XR विकास](https://github.com/microsoft/xr-development-for-beginners)
- [GitHub Copilot को मास्टरी (AI जोडी प्रोग्रामिङका लागि)](https://aka.ms/GitHubCopilotAI)
- [GitHub Copilot को मास्टरी (C#/.NET विकासकर्ताहरूका लागि)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Copilot एडभेन्चर रोज्नुहोस्](https://github.com/microsoft/CopilotAdventures)
- [Azure AI सेवाहरूको साथ RAG च्याट एप](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## सहयोग प्राप्त गर्नुहोस्

यदि तपाईं अड्किनुहुन्छ वा एआई एप्लिकेसन निर्माणको बारेमा कुनै प्रश्न छ भने, सामेल हुनुहोस्:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

यदि तपाईंलाई उत्पादन प्रतिक्रिया वा निर्माणको क्रममा त्रुटिहरू छन् भने, भ्रमण गर्नुहोस्:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**अस्वीकरण**:  
यो दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) प्रयोग गरेर अनुवाद गरिएको हो। हामी यथार्थताको लागि प्रयास गर्छौं, तर कृपया ध्यान दिनुहोस् कि स्वचालित अनुवादमा त्रुटिहरू वा अशुद्धताहरू हुन सक्छ। यसको मूल भाषा मा रहेको मूल दस्तावेज़लाई आधिकारिक स्रोत मानिनुपर्छ। महत्वपूर्ण जानकारीको लागि, व्यावसायिक मानव अनुवाद सिफारिस गरिन्छ। यस अनुवादको प्रयोगबाट उत्पन्न हुने कुनै पनि गलतफहमी वा गलत व्याख्याको लागि हामी जिम्मेवार हुने छैनौं।