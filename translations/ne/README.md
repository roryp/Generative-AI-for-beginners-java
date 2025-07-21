<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2ee0f50497c11d1941347ac61fb017a9",
  "translation_date": "2025-07-21T17:31:33+00:00",
  "source_file": "README.md",
  "language_code": "ne"
}
-->
# जेनरेटिभ एआईको लागि सुरुवात - जाभा संस्करण
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![जेनरेटिभ एआईको लागि सुरुवात - जाभा संस्करण](../../translated_images/beg-genai-series.61edc4a6b2cc54284fa2d70eda26dc0ca2669e26e49655b842ea799cd6e16d2a.ne.png)

> **NOTE: छिटो सुरु**: सम्पूर्ण कोर्स अनलाइन गर्न सकिन्छ - कुनै पनि स्थानीय सेटअप आवश्यक छैन!
1. यो रिपोजिटरीलाई आफ्नो GitHub खातामा फोर्क गर्नुहोस्
2. **Code** → **Codespaces** ट्याब → **...** → **New with options...** मा क्लिक गर्नुहोस्
3. डिफल्ट सेटिङहरू प्रयोग गर्नुहोस् – यसले यस कोर्सको लागि बनाइएको Development container चयन गर्नेछ
4. **Create codespace** मा क्लिक गर्नुहोस्
5. वातावरण तयार हुन ~२ मिनेट पर्खनुहोस्
6. [Creating your GitHub Models Token](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) मा सिधै जानुहोस्

## बहुभाषिक समर्थन

### GitHub Action मार्फत समर्थित (स्वचालित र सधैं अद्यावधिक)

[French](../fr/README.md) | [Spanish](../es/README.md) | [German](../de/README.md) | [Russian](../ru/README.md) | [Arabic](../ar/README.md) | [Persian (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Hindi](../hi/README.md) | [Bengali](../bn/README.md) | [Marathi](../mr/README.md) | [Nepali](./README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Portuguese (Brazil)](../br/README.md) | [Italian](../it/README.md) | [Polish](../pl/README.md) | [Turkish](../tr/README.md) | [Greek](../el/README.md) | [Thai](../th/README.md) | [Swedish](../sv/README.md) | [Danish](../da/README.md) | [Norwegian](../no/README.md) | [Finnish](../fi/README.md) | [Dutch](../nl/README.md) | [Hebrew](../he/README.md) | [Vietnamese](../vi/README.md) | [Indonesian](../id/README.md) | [Malay](../ms/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Swahili](../sw/README.md) | [Hungarian](../hu/README.md) | [Czech](../cs/README.md) | [Slovak](../sk/README.md) | [Romanian](../ro/README.md) | [Bulgarian](../bg/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Croatian](../hr/README.md) | [Slovenian](../sl/README.md) | [Ukrainian](../uk/README.md) | [Burmese (Myanmar)](../my/README.md)

## कोर्स संरचना र सिकाइ मार्ग

**समय प्रतिबद्धता**: वातावरण सेटअप गर्न २ मिनेट लाग्छ, र ह्यान्ड्स-अन ट्युटोरियलहरू १-३ घण्टा लाग्छ, अन्वेषणको गहिराइमा निर्भर गर्दै।

### **अध्याय १: जेनरेटिभ एआईको परिचय**
- **मुख्य अवधारणाहरू**: Large Language Models, टोकनहरू, embeddings, र एआई क्षमताहरू बुझ्ने
- **जाभा एआई इकोसिस्टम**: Spring AI र OpenAI SDKs को अवलोकन
- **Model Context Protocol**: MCP र यसको एआई एजेन्ट संचारमा भूमिका
- **व्यावहारिक अनुप्रयोगहरू**: वास्तविक संसारका परिदृश्यहरू जस्तै च्याटबट्स र सामग्री निर्माण
- **[→ अध्याय १ सुरु गर्नुहोस्](./01-IntroToGenAI/README.md)**

### **अध्याय २: विकास वातावरण सेटअप**
- **बहु-प्रदायक कन्फिगरेसन**: GitHub Models, Azure OpenAI, र OpenAI Java SDK एकीकरण सेटअप गर्नुहोस्
- **Spring Boot + Spring AI**: उद्यम एआई अनुप्रयोग विकासका लागि उत्कृष्ट अभ्यासहरू
- **GitHub Models**: प्रोटोटाइप र सिकाइका लागि निःशुल्क एआई मोडेल पहुँच (क्रेडिट कार्ड आवश्यक छैन)
- **विकास उपकरणहरू**: Docker containers, VS Code, र GitHub Codespaces कन्फिगरेसन
- **[→ अध्याय २ सुरु गर्नुहोस्](./02-SetupDevEnvironment/README.md)**

### **अध्याय ३: मुख्य जेनरेटिभ एआई प्रविधिहरू**
- **Prompt Engineering**: एआई मोडेलको उत्कृष्ट प्रतिक्रिया प्राप्त गर्नका लागि प्रविधिहरू
- **Embeddings & Vector Operations**: Semantic search र similarity matching कार्यान्वयन गर्नुहोस्
- **Retrieval-Augmented Generation (RAG)**: एआईलाई आफ्नै डाटा स्रोतहरूसँग संयोजन गर्नुहोस्
- **Function Calling**: कस्टम उपकरण र प्लगइनहरूसँग एआई क्षमताहरू विस्तार गर्नुहोस्
- **[→ अध्याय ३ सुरु गर्नुहोस्](./03-CoreGenerativeAITechniques/README.md)**

### **अध्याय ४: व्यावहारिक अनुप्रयोगहरू र परियोजनाहरू**
- **Pet Story Generator** (`petstory/`): GitHub Models को साथ सिर्जनात्मक सामग्री निर्माण
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK को साथ स्थानीय एआई मोडेल एकीकरण
- **MCP Calculator Service** (`mcp/calculator/`): Spring AI को साथ Model Context Protocol को आधारभूत कार्यान्वयन
- **[→ अध्याय ४ सुरु गर्नुहोस्](./04-PracticalSamples/README.md)**

### **अध्याय ५: जिम्मेवार एआई विकास**
- **GitHub Models सुरक्षा**: बिल्ट-इन सामग्री फिल्टरिङ र सुरक्षा संयन्त्रहरूको परीक्षण गर्नुहोस्
- **जिम्मेवार एआई डेमो**: एआई सुरक्षा फिल्टरहरू कसरी व्यवहारमा काम गर्छन् भन्ने देखाउने ह्यान्ड्स-अन उदाहरण
- **सर्वोत्तम अभ्यासहरू**: नैतिक एआई विकास र परिनियोजनका लागि आवश्यक दिशानिर्देशहरू
- **[→ अध्याय ५ सुरु गर्नुहोस्](./05-ResponsibleGenAI/README.md)**

## थप स्रोतहरू

- [AI Agents For Beginners](https://github.com/microsoft/ai-agents-for-beginners)
- [Generative AI for Beginners using .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generative AI for Beginners using JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generative AI for Beginners](https://github.com/microsoft/generative-ai-for-beginners)
- [ML for Beginners](https://aka.ms/ml-beginners)
- [Data Science for Beginners](https://aka.ms/datascience-beginners)
- [AI for Beginners](https://aka.ms/ai-beginners)
- [Cybersecurity for Beginners](https://github.com/microsoft/Security-101)
- [Web Dev for Beginners](https://aka.ms/webdev-beginners)
- [IoT for Beginners](https://aka.ms/iot-beginners)
- [XR Development for Beginners](https://github.com/microsoft/xr-development-for-beginners)
- [Mastering GitHub Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI)
- [Mastering GitHub Copilot for C#/.NET Developers](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Choose Your Own Copilot Adventure](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App with Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)

**अस्वीकरण**:  
यो दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) प्रयोग गरेर अनुवाद गरिएको छ। हामी शुद्धताको लागि प्रयास गर्छौं, तर कृपया ध्यान दिनुहोस् कि स्वचालित अनुवादमा त्रुटिहरू वा अशुद्धताहरू हुन सक्छ। यसको मूल भाषा मा रहेको मूल दस्तावेज़लाई आधिकारिक स्रोत मानिनुपर्छ। महत्वपूर्ण जानकारीको लागि, व्यावसायिक मानव अनुवाद सिफारिस गरिन्छ। यस अनुवादको प्रयोगबाट उत्पन्न हुने कुनै पनि गलतफहमी वा गलत व्याख्याको लागि हामी जिम्मेवार हुने छैनौं।