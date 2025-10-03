<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "4d04ae8088f6a3c3fcbab18cbdfe4002",
  "translation_date": "2025-10-03T08:08:38+00:00",
  "source_file": "README.md",
  "language_code": "pa"
}
-->
# ਜਨਰੇਟਿਵ AI ਸ਼ੁਰੂਆਤੀ ਲਈ - ਜਾਵਾ ਐਡੀਸ਼ਨ  
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![ਜਨਰੇਟਿਵ AI ਸ਼ੁਰੂਆਤੀ ਲਈ - ਜਾਵਾ ਐਡੀਸ਼ਨ](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.pa.png)

**ਸਮਾਂ ਦੀ ਲੋੜ**: ਪੂਰਾ ਵਰਕਸ਼ਾਪ ਆਨਲਾਈਨ ਪੂਰਾ ਕੀਤਾ ਜਾ ਸਕਦਾ ਹੈ ਬਿਨਾਂ ਕਿਸੇ ਲੋਕਲ ਸੈਟਅਪ ਦੇ। ਸੈਟਅਪ ਵਿੱਚ 2 ਮਿੰਟ ਲੱਗਦੇ ਹਨ, ਜਦਕਿ ਸੈਂਪਲਜ਼ ਦੀ ਖੋਜ 1-3 ਘੰਟੇ ਲੈ ਸਕਦੀ ਹੈ, ਖੋਜ ਦੀ ਗਹਿਰਾਈ 'ਤੇ ਨਿਰਭਰ ਕਰਦਾ ਹੈ।  

> **ਤੁਰੰਤ ਸ਼ੁਰੂਆਤ**  

1. ਇਸ ਰਿਪੋਜ਼ਟਰੀ ਨੂੰ ਆਪਣੇ GitHub ਅਕਾਊਂਟ ਵਿੱਚ ਫੋਰਕ ਕਰੋ  
2. **Code** → **Codespaces** ਟੈਬ → **...** → **New with options...** 'ਤੇ ਕਲਿਕ ਕਰੋ  
3. ਡਿਫਾਲਟ ਚੋਣ ਕਰੋ – ਇਹ ਇਸ ਕੋਰਸ ਲਈ ਬਣਾਈ ਗਈ ਡਿਵੈਲਪਮੈਂਟ ਕੰਟੇਨਰ ਨੂੰ ਚੁਣੇਗਾ  
4. **Create codespace** 'ਤੇ ਕਲਿਕ ਕਰੋ  
5. ~2 ਮਿੰਟ ਲਈ ਇਨਵਾਇਰਨਮੈਂਟ ਤਿਆਰ ਹੋਣ ਦੀ ਉਡੀਕ ਕਰੋ  
6. ਸਿੱਧੇ [ਪਹਿਲੇ ਉਦਾਹਰਨ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) 'ਤੇ ਜਾਓ  

## ਬਹੁ-ਭਾਸ਼ਾ ਸਹਾਇਤਾ  

### GitHub Action ਰਾਹੀਂ ਸਹਾਇਤ (ਆਟੋਮੈਟਿਕ ਅਤੇ ਹਮੇਸ਼ਾ ਅਪ-ਟੂ-ਡੇਟ)  

[French](../fr/README.md) | [Spanish](../es/README.md) | [German](../de/README.md) | [Russian](../ru/README.md) | [Arabic](../ar/README.md) | [Persian (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Hindi](../hi/README.md) | [Bengali](../bn/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Punjabi (Gurmukhi)](./README.md) | [Portuguese (Portugal)](../pt/README.md) | [Portuguese (Brazil)](../br/README.md) | [Italian](../it/README.md) | [Polish](../pl/README.md) | [Turkish](../tr/README.md) | [Greek](../el/README.md) | [Thai](../th/README.md) | [Swedish](../sv/README.md) | [Danish](../da/README.md) | [Norwegian](../no/README.md) | [Finnish](../fi/README.md) | [Dutch](../nl/README.md) | [Hebrew](../he/README.md) | [Vietnamese](../vi/README.md) | [Indonesian](../id/README.md) | [Malay](../ms/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Swahili](../sw/README.md) | [Hungarian](../hu/README.md) | [Czech](../cs/README.md) | [Slovak](../sk/README.md) | [Romanian](../ro/README.md) | [Bulgarian](../bg/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Croatian](../hr/README.md) | [Slovenian](../sl/README.md) | [Ukrainian](../uk/README.md) | [Burmese (Myanmar)](../my/README.md)  

## ਕੋਰਸ ਦੀ ਬਣਤਰ ਅਤੇ ਸਿੱਖਣ ਦਾ ਰਾਹ  

### **ਅਧਿਆਇ 1: ਜਨਰੇਟਿਵ AI ਦਾ ਪਰਿਚਯ**  
- **ਮੁੱਖ ਧਾਰਨਾਵਾਂ**: ਵੱਡੇ ਭਾਸ਼ਾ ਮਾਡਲ, ਟੋਕਨ, ਐਮਬੈਡਿੰਗ ਅਤੇ AI ਸਮਰੱਥਾਵਾਂ ਨੂੰ ਸਮਝਣਾ  
- **Java AI ਇਕੋਸਿਸਟਮ**: Spring AI ਅਤੇ OpenAI SDKs ਦਾ ਜਾਇਜ਼ਾ  
- **Model Context Protocol**: MCP ਅਤੇ AI ਏਜੰਟ ਸੰਚਾਰ ਵਿੱਚ ਇਸ ਦੀ ਭੂਮਿਕਾ ਦਾ ਪਰਿਚਯ  
- **ਵਿਹਾਰਕ ਐਪਲੀਕੇਸ਼ਨ**: ਚੈਟਬੋਟ ਅਤੇ ਸਮੱਗਰੀ ਜਨਰੇਸ਼ਨ ਸਮੇਤ ਅਸਲ-ਦੁਨੀਆ ਦੇ ਸਨਰਿਓ  
- **[→ ਅਧਿਆਇ 1 ਸ਼ੁਰੂ ਕਰੋ](./01-IntroToGenAI/README.md)**  

### **ਅਧਿਆਇ 2: ਡਿਵੈਲਪਮੈਂਟ ਇਨਵਾਇਰਨਮੈਂਟ ਸੈਟਅਪ**  
- **ਮਲਟੀ-ਪ੍ਰੋਵਾਈਡਰ ਕਨਫਿਗਰੇਸ਼ਨ**: GitHub Models, Azure OpenAI, ਅਤੇ OpenAI Java SDK ਇੰਟੀਗ੍ਰੇਸ਼ਨ ਸੈਟਅਪ  
- **Spring Boot + Spring AI**: ਐਨਟਰਪ੍ਰਾਈਜ਼ AI ਐਪਲੀਕੇਸ਼ਨ ਵਿਕਾਸ ਲਈ ਬਿਹਤਰ ਤਰੀਕੇ  
- **GitHub Models**: ਪ੍ਰੋਟੋਟਾਈਪਿੰਗ ਅਤੇ ਸਿੱਖਣ ਲਈ ਮੁਫ਼ਤ AI ਮਾਡਲ ਪਹੁੰਚ (ਕੋਈ ਕਰੈਡਿਟ ਕਾਰਡ ਦੀ ਲੋੜ ਨਹੀਂ)  
- **ਡਿਵੈਲਪਮੈਂਟ ਟੂਲਜ਼**: Docker ਕੰਟੇਨਰ, VS Code, ਅਤੇ GitHub Codespaces ਕਨਫਿਗਰੇਸ਼ਨ  
- **[→ ਅਧਿਆਇ 2 ਸ਼ੁਰੂ ਕਰੋ](./02-SetupDevEnvironment/README.md)**  

### **ਅਧਿਆਇ 3: ਜਨਰੇਟਿਵ AI ਦੀਆਂ ਮੁੱਖ ਤਕਨੀਕਾਂ**  
- **Prompt Engineering**: AI ਮਾਡਲ ਦੇ ਉੱਤਮ ਜਵਾਬਾਂ ਲਈ ਤਕਨੀਕਾਂ  
- **Embeddings & Vector Operations**: ਸੈਮੈਂਟਿਕ ਖੋਜ ਅਤੇ ਸਮਾਨਤਾ ਮੈਚਿੰਗ ਨੂੰ ਲਾਗੂ ਕਰਨਾ  
- **Retrieval-Augmented Generation (RAG)**: AI ਨੂੰ ਆਪਣੇ ਡਾਟਾ ਸਰੋਤਾਂ ਨਾਲ ਜੋੜਨਾ  
- **Function Calling**: ਕਸਟਮ ਟੂਲ ਅਤੇ ਪਲੱਗਇਨ ਨਾਲ AI ਸਮਰੱਥਾਵਾਂ ਨੂੰ ਵਧਾਉਣਾ  
- **[→ ਅਧਿਆਇ 3 ਸ਼ੁਰੂ ਕਰੋ](./03-CoreGenerativeAITechniques/README.md)**  

### **ਅਧਿਆਇ 4: ਵਿਹਾਰਕ ਐਪਲੀਕੇਸ਼ਨ ਅਤੇ ਪ੍ਰੋਜੈਕਟ**  
- **Pet Story Generator** (`petstory/`): GitHub Models ਨਾਲ ਰਚਨਾਤਮਕ ਸਮੱਗਰੀ ਜਨਰੇਸ਼ਨ  
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK ਨਾਲ ਲੋਕਲ AI ਮਾਡਲ ਇੰਟੀਗ੍ਰੇਸ਼ਨ  
- **MCP Calculator Service** (`calculator/`): Spring AI ਨਾਲ ਬੁਨਿਆਦੀ Model Context Protocol ਲਾਗੂ ਕਰਨਾ  
- **[→ ਅਧਿਆਇ 4 ਸ਼ੁਰੂ ਕਰੋ](./04-PracticalSamples/README.md)**  

### **ਅਧਿਆਇ 5: ਜਿੰਮੇਵਾਰ AI ਵਿਕਾਸ**  
- **GitHub Models Safety**: ਸਮੱਗਰੀ ਫਿਲਟਰੀਂਗ ਅਤੇ ਸੁਰੱਖਿਆ ਮਕੈਨਿਜ਼ਮ (ਹਾਰਡ ਬਲਾਕ ਅਤੇ ਸੌਫਟ ਰਿਫ਼ਿਊਜ਼ਲ) ਦੀ ਜਾਂਚ  
- **Responsible AI Demo**: ਵਿਹਾਰਕ ਉਦਾਹਰਨ ਜੋ ਦਿਖਾਉਂਦਾ ਹੈ ਕਿ ਆਧੁਨਿਕ AI ਸੁਰੱਖਿਆ ਪ੍ਰਣਾਲੀਆਂ ਕਿਵੇਂ ਕੰਮ ਕਰਦੀਆਂ ਹਨ  
- **ਸਰਵੋਤਮ ਤਰੀਕੇ**: ਨੈਤਿਕ AI ਵਿਕਾਸ ਅਤੇ ਤੈਨਾਤੀ ਲਈ ਜ਼ਰੂਰੀ ਦਿਸ਼ਾ-ਨਿਰਦੇਸ਼  
- **[→ ਅਧਿਆਇ 5 ਸ਼ੁਰੂ ਕਰੋ](./05-ResponsibleGenAI/README.md)**  

## ਵਾਧੂ ਸਰੋਤ  

- [Edge AI for Beginners](https://github.com/microsoft/edgeai-for-beginners)  
- [MCP For Beginners](https://github.com/microsoft/mcp-for-beginners)  
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

## ਮਦਦ ਪ੍ਰਾਪਤ ਕਰਨਾ  

ਜੇ ਤੁਸੀਂ ਫਸ ਜਾਓ ਜਾਂ AI ਐਪਲੀਕੇਸ਼ਨ ਬਣਾਉਣ ਬਾਰੇ ਕੋਈ ਸਵਾਲ ਹੋਵੇ, ਤਾਂ ਸ਼ਾਮਲ ਹੋਵੋ:  

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)  

ਜੇ ਤੁਹਾਨੂੰ ਉਤਪਾਦ ਫੀਡਬੈਕ ਜਾਂ ਬਣਾਉਣ ਦੌਰਾਨ ਗਲਤੀਆਂ ਮਿਲਦੀਆਂ ਹਨ, ਤਾਂ ਜਾਓ:  

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)  

---

**ਅਸਵੀਕਰਤਾ**:  
ਇਹ ਦਸਤਾਵੇਜ਼ AI ਅਨੁਵਾਦ ਸੇਵਾ [Co-op Translator](https://github.com/Azure/co-op-translator) ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਅਨੁਵਾਦ ਕੀਤਾ ਗਿਆ ਹੈ। ਹਾਲਾਂਕਿ ਅਸੀਂ ਸਹੀ ਹੋਣ ਦੀ ਪੂਰੀ ਕੋਸ਼ਿਸ਼ ਕਰਦੇ ਹਾਂ, ਕਿਰਪਾ ਕਰਕੇ ਧਿਆਨ ਦਿਓ ਕਿ ਸਵੈਚਾਲਿਤ ਅਨੁਵਾਦਾਂ ਵਿੱਚ ਗਲਤੀਆਂ ਜਾਂ ਅਸੁਚੱਜੇ ਪਾਸੇ ਹੋਣ ਦੀ ਸੰਭਾਵਨਾ ਹੋ ਸਕਦੀ ਹੈ। ਮੂਲ ਦਸਤਾਵੇਜ਼, ਜੋ ਇਸਦੀ ਮੂਲ ਭਾਸ਼ਾ ਵਿੱਚ ਹੈ, ਨੂੰ ਅਧਿਕਾਰਤ ਸਰੋਤ ਮੰਨਿਆ ਜਾਣਾ ਚਾਹੀਦਾ ਹੈ। ਮਹੱਤਵਪੂਰਨ ਜਾਣਕਾਰੀ ਲਈ, ਪੇਸ਼ੇਵਰ ਮਨੁੱਖੀ ਅਨੁਵਾਦ ਦੀ ਸਿਫਾਰਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ। ਇਸ ਅਨੁਵਾਦ ਦੀ ਵਰਤੋਂ ਤੋਂ ਪੈਦਾ ਹੋਣ ਵਾਲੇ ਕਿਸੇ ਵੀ ਗਲਤਫਹਿਮੀ ਜਾਂ ਗਲਤ ਵਿਆਖਿਆ ਲਈ ਅਸੀਂ ਜ਼ਿੰਮੇਵਾਰ ਨਹੀਂ ਹਾਂ।