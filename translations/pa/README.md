<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:24:36+00:00",
  "source_file": "README.md",
  "language_code": "pa"
}
-->
# ਜਨਰੇਟਿਵ AI ਸ਼ੁਰੂਆਤੀ ਲਈ - ਜਾਵਾ ਐਡੀਸ਼ਨ
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![ਜਨਰੇਟਿਵ AI ਸ਼ੁਰੂਆਤੀ ਲਈ - ਜਾਵਾ ਐਡੀਸ਼ਨ](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.pa.png)

**ਸਮਾਂ ਦੀ ਲੋੜ**: ਪੂਰਾ ਵਰਕਸ਼ਾਪ ਆਨਲਾਈਨ ਪੂਰਾ ਕੀਤਾ ਜਾ ਸਕਦਾ ਹੈ ਬਿਨਾਂ ਕਿਸੇ ਲੋਕਲ ਸੈਟਅਪ ਦੇ। ਵਾਤਾਵਰਣ ਸੈਟਅਪ ਵਿੱਚ 2 ਮਿੰਟ ਲੱਗਦੇ ਹਨ, ਜਦਕਿ ਨਮੂਨਿਆਂ ਦੀ ਖੋਜ ਵਿੱਚ 1-3 ਘੰਟੇ ਲੱਗ ਸਕਦੇ ਹਨ, ਖੋਜ ਦੀ ਗਹਿਰਾਈ 'ਤੇ ਨਿਰਭਰ ਕਰਦਾ ਹੈ।

> **ਤੁਰੰਤ ਸ਼ੁਰੂਆਤ**

1. ਇਸ ਰਿਪੋਜ਼ਟਰੀ ਨੂੰ ਆਪਣੇ GitHub ਅਕਾਊਂਟ ਵਿੱਚ ਫੋਰਕ ਕਰੋ
2. **Code** → **Codespaces** ਟੈਬ → **...** → **New with options...** 'ਤੇ ਕਲਿਕ ਕਰੋ
3. ਡਿਫਾਲਟ ਚੋਣ ਕਰੋ – ਇਹ ਇਸ ਕੋਰਸ ਲਈ ਬਣਾਇਆ ਗਿਆ ਡਿਵੈਲਪਮੈਂਟ ਕੰਟੇਨਰ ਚੁਣੇਗਾ
4. **Create codespace** 'ਤੇ ਕਲਿਕ ਕਰੋ
5. ਵਾਤਾਵਰਣ ਤਿਆਰ ਹੋਣ ਲਈ ~2 ਮਿੰਟ ਦੀ ਉਡੀਕ ਕਰੋ
6. ਸਿੱਧੇ [ਪਹਿਲੇ ਉਦਾਹਰਨ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) 'ਤੇ ਜਾਓ

## ਬਹੁ-ਭਾਸ਼ਾ ਸਹਾਇਤਾ

### GitHub Action ਰਾਹੀਂ ਸਹਾਇਤ (ਆਟੋਮੈਟਿਕ ਅਤੇ ਹਮੇਸ਼ਾ ਅਪ-ਟੂ-ਡੇਟ)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](../my/README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../br/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Punjabi (Gurmukhi)](./README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## ਕੋਰਸ ਦੀ ਬਣਤਰ ਅਤੇ ਸਿੱਖਣ ਦਾ ਰਾਹ

### **ਅਧਿਆਇ 1: ਜਨਰੇਟਿਵ AI ਦਾ ਪਹਿਚਾਣ**
- **ਮੁੱਖ ਧਾਰਨਾਵਾਂ**: ਵੱਡੇ ਭਾਸ਼ਾ ਮਾਡਲ, ਟੋਕਨ, ਐਮਬੈਡਿੰਗ, ਅਤੇ AI ਸਮਰੱਥਾਵਾਂ ਨੂੰ ਸਮਝਣਾ
- **Java AI ਇਕੋਸਿਸਟਮ**: Spring AI ਅਤੇ OpenAI SDKs ਦਾ ਜਾਇਜ਼ਾ
- **ਮਾਡਲ ਕਾਂਟੈਕਸਟ ਪ੍ਰੋਟੋਕੋਲ**: MCP ਅਤੇ AI ਏਜੰਟ ਸੰਚਾਰ ਵਿੱਚ ਇਸ ਦੀ ਭੂਮਿਕਾ ਦਾ ਪਹਿਚਾਣ
- **ਵਿਹਾਰਕ ਐਪਲੀਕੇਸ਼ਨ**: ਚੈਟਬੋਟ ਅਤੇ ਸਮੱਗਰੀ ਜਨਰੇਸ਼ਨ ਵਰਗੇ ਹਕੀਕਤੀ ਸਥਿਤੀਆਂ
- **[→ ਅਧਿਆਇ 1 ਸ਼ੁਰੂ ਕਰੋ](./01-IntroToGenAI/README.md)**

### **ਅਧਿਆਇ 2: ਵਿਕਾਸ ਵਾਤਾਵਰਣ ਸੈਟਅਪ**
- **ਮਲਟੀ-ਪ੍ਰੋਵਾਈਡਰ ਕਨਫਿਗਰੇਸ਼ਨ**: GitHub ਮਾਡਲ, Azure OpenAI, ਅਤੇ OpenAI Java SDK ਇੰਟੀਗ੍ਰੇਸ਼ਨ ਸੈਟਅਪ ਕਰੋ
- **Spring Boot + Spring AI**: ਉਦਯੋਗਿਕ AI ਐਪਲੀਕੇਸ਼ਨ ਵਿਕਾਸ ਲਈ ਸ੍ਰੇਸ਼ਠ ਤਰੀਕੇ
- **GitHub ਮਾਡਲ**: ਪ੍ਰੋਟੋਟਾਈਪਿੰਗ ਅਤੇ ਸਿੱਖਣ ਲਈ ਮੁਫ਼ਤ AI ਮਾਡਲ ਪਹੁੰਚ (ਕੋਈ ਕਰੈਡਿਟ ਕਾਰਡ ਦੀ ਲੋੜ ਨਹੀਂ)
- **ਵਿਕਾਸ ਟੂਲ**: Docker ਕੰਟੇਨਰ, VS Code, ਅਤੇ GitHub Codespaces ਕਨਫਿਗਰੇਸ਼ਨ
- **[→ ਅਧਿਆਇ 2 ਸ਼ੁਰੂ ਕਰੋ](./02-SetupDevEnvironment/README.md)**

### **ਅਧਿਆਇ 3: ਜਨਰੇਟਿਵ AI ਤਕਨੀਕਾਂ**
- **ਪ੍ਰੋਮਪਟ ਇੰਜੀਨੀਅਰਿੰਗ**: AI ਮਾਡਲ ਦੇ ਉੱਤਮ ਜਵਾਬਾਂ ਲਈ ਤਕਨੀਕਾਂ
- **ਐਮਬੈਡਿੰਗ ਅਤੇ ਵੈਕਟਰ ਓਪਰੇਸ਼ਨ**: ਸੈਮਾਂਟਿਕ ਖੋਜ ਅਤੇ ਸਮਾਨਤਾ ਮੈਚਿੰਗ ਨੂੰ ਲਾਗੂ ਕਰੋ
- **ਰਿਟਰੀਵਲ-ਅਗਮੈਂਟਡ ਜਨਰੇਸ਼ਨ (RAG)**: AI ਨੂੰ ਆਪਣੇ ਡਾਟਾ ਸਰੋਤਾਂ ਨਾਲ ਜੋੜੋ
- **ਫੰਕਸ਼ਨ ਕਾਲਿੰਗ**: ਕਸਟਮ ਟੂਲ ਅਤੇ ਪਲੱਗਇਨ ਨਾਲ AI ਸਮਰੱਥਾਵਾਂ ਨੂੰ ਵਧਾਓ
- **[→ ਅਧਿਆਇ 3 ਸ਼ੁਰੂ ਕਰੋ](./03-CoreGenerativeAITechniques/README.md)**

### **ਅਧਿਆਇ 4: ਵਿਹਾਰਕ ਐਪਲੀਕੇਸ਼ਨ ਅਤੇ ਪ੍ਰੋਜੈਕਟ**
- **ਪੈਟ ਸਟੋਰੀ ਜਨਰੇਟਰ** (`petstory/`): GitHub ਮਾਡਲ ਨਾਲ ਰਚਨਾਤਮਕ ਸਮੱਗਰੀ ਜਨਰੇਸ਼ਨ
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK ਨਾਲ ਲੋਕਲ AI ਮਾਡਲ ਇੰਟੀਗ੍ਰੇਸ਼ਨ
- **MCP ਕੈਲਕੁਲੇਟਰ ਸੇਵਾ** (`calculator/`): Spring AI ਨਾਲ ਮਾਡਲ ਕਾਂਟੈਕਸਟ ਪ੍ਰੋਟੋਕੋਲ ਦੀ ਬੁਨਿਆਦੀ ਲਾਗੂ
- **[→ ਅਧਿਆਇ 4 ਸ਼ੁਰੂ ਕਰੋ](./04-PracticalSamples/README.md)**

### **ਅਧਿਆਇ 5: ਜਿੰਮੇਵਾਰ AI ਵਿਕਾਸ**
- **GitHub ਮਾਡਲ ਸੁਰੱਖਿਆ**: ਸਮੱਗਰੀ ਫਿਲਟਰੀਂਗ ਅਤੇ ਸੁਰੱਖਿਆ ਮਕੈਨਿਜ਼ਮ (ਹਾਰਡ ਬਲਾਕ ਅਤੇ ਸੌਫਟ ਰਿਫ਼ਿਊਜ਼ਲ) ਦੀ ਜਾਂਚ ਕਰੋ
- **ਜਿੰਮੇਵਾਰ AI ਡੈਮੋ**: ਵਿਹਾਰਕ ਉਦਾਹਰਨ ਜੋ ਦਿਖਾਉਂਦਾ ਹੈ ਕਿ ਆਧੁਨਿਕ AI ਸੁਰੱਖਿਆ ਪ੍ਰਣਾਲੀਆਂ ਕਿਵੇਂ ਕੰਮ ਕਰਦੀਆਂ ਹਨ
- **ਸ੍ਰੇਸ਼ਠ ਤਰੀਕੇ**: ਨੈਤਿਕ AI ਵਿਕਾਸ ਅਤੇ ਡਿਪਲੋਇਮੈਂਟ ਲਈ ਜ਼ਰੂਰੀ ਦਿਸ਼ਾ-ਨਿਰਦੇਸ਼
- **[→ ਅਧਿਆਇ 5 ਸ਼ੁਰੂ ਕਰੋ](./05-ResponsibleGenAI/README.md)**

## ਵਾਧੂ ਸਰੋਤ

- [Edge AI ਸ਼ੁਰੂਆਤੀ ਲਈ](https://github.com/microsoft/edgeai-for-beginners)
- [MCP ਸ਼ੁਰੂਆਤੀ ਲਈ](https://github.com/microsoft/mcp-for-beginners)
- [AI ਏਜੰਟ ਸ਼ੁਰੂਆਤੀ ਲਈ](https://github.com/microsoft/ai-agents-for-beginners)
- [ਜਨਰੇਟਿਵ AI ਸ਼ੁਰੂਆਤੀ ਲਈ .NET ਵਰਤੋਂ](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [ਜਨਰੇਟਿਵ AI ਸ਼ੁਰੂਆਤੀ ਲਈ JavaScript ਵਰਤੋਂ](https://github.com/microsoft/generative-ai-with-javascript)
- [ਜਨਰੇਟਿਵ AI ਸ਼ੁਰੂਆਤੀ ਲਈ](https://github.com/microsoft/generative-ai-for-beginners)
- [ML ਸ਼ੁਰੂਆਤੀ ਲਈ](https://aka.ms/ml-beginners)
- [ਡਾਟਾ ਸਾਇੰਸ ਸ਼ੁਰੂਆਤੀ ਲਈ](https://aka.ms/datascience-beginners)
- [AI ਸ਼ੁਰੂਆਤੀ ਲਈ](https://aka.ms/ai-beginners)
- [ਸਾਇਬਰਸੁਰੱਖਿਆ ਸ਼ੁਰੂਆਤੀ ਲਈ](https://github.com/microsoft/Security-101)
- [ਵੈੱਬ ਡਿਵ ਸ਼ੁਰੂਆਤੀ ਲਈ](https://aka.ms/webdev-beginners)
- [IoT ਸ਼ੁਰੂਆਤੀ ਲਈ](https://aka.ms/iot-beginners)
- [XR ਵਿਕਾਸ ਸ਼ੁਰੂਆਤੀ ਲਈ](https://github.com/microsoft/xr-development-for-beginners)
- [GitHub Copilot ਲਈ AI ਜੋੜੇ ਪ੍ਰੋਗਰਾਮਿੰਗ ਵਿੱਚ ਮਾਹਰ ਬਣੋ](https://aka.ms/GitHubCopilotAI)
- [GitHub Copilot ਲਈ C#/.NET ਡਿਵੈਲਪਰਜ਼ ਵਿੱਚ ਮਾਹਰ ਬਣੋ](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Copilot ਦੇ ਨਾਲ ਆਪਣਾ ਸਫਰ ਚੁਣੋ](https://github.com/microsoft/CopilotAdventures)
- [RAG ਚੈਟ ਐਪ Azure AI ਸੇਵਾਵਾਂ ਨਾਲ](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## ਮਦਦ ਪ੍ਰਾਪਤ ਕਰਨਾ

ਜੇ ਤੁਸੀਂ ਫਸ ਜਾਓ ਜਾਂ AI ਐਪ ਬਣਾਉਣ ਬਾਰੇ ਕੋਈ ਸਵਾਲ ਹੋਵੇ, ਤਾਂ ਸ਼ਾਮਲ ਹੋਵੋ:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

ਜੇ ਤੁਹਾਨੂੰ ਉਤਪਾਦ ਫੀਡਬੈਕ ਜਾਂ ਬਣਾਉਣ ਦੌਰਾਨ ਗਲਤੀਆਂ ਮਿਲਦੀਆਂ ਹਨ, ਤਾਂ ਜਾਓ:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**ਅਸਵੀਕਰਤੀ**:  
ਇਹ ਦਸਤਾਵੇਜ਼ AI ਅਨੁਵਾਦ ਸੇਵਾ [Co-op Translator](https://github.com/Azure/co-op-translator) ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਅਨੁਵਾਦ ਕੀਤਾ ਗਿਆ ਹੈ। ਜਦੋਂ ਕਿ ਅਸੀਂ ਸਹੀ ਹੋਣ ਦਾ ਯਤਨ ਕਰਦੇ ਹਾਂ, ਕਿਰਪਾ ਕਰਕੇ ਧਿਆਨ ਦਿਓ ਕਿ ਸਵੈਚਾਲਿਤ ਅਨੁਵਾਦਾਂ ਵਿੱਚ ਗਲਤੀਆਂ ਜਾਂ ਅਸੁਚੱਜੇਪਣ ਹੋ ਸਕਦੇ ਹਨ। ਇਸ ਦੀ ਮੂਲ ਭਾਸ਼ਾ ਵਿੱਚ ਮੌਜੂਦ ਮੂਲ ਦਸਤਾਵੇਜ਼ ਨੂੰ ਅਧਿਕਾਰਤ ਸਰੋਤ ਮੰਨਿਆ ਜਾਣਾ ਚਾਹੀਦਾ ਹੈ। ਮਹੱਤਵਪੂਰਨ ਜਾਣਕਾਰੀ ਲਈ, ਪੇਸ਼ੇਵਰ ਮਨੁੱਖੀ ਅਨੁਵਾਦ ਦੀ ਸਿਫਾਰਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ। ਅਸੀਂ ਇਸ ਅਨੁਵਾਦ ਦੀ ਵਰਤੋਂ ਤੋਂ ਪੈਦਾ ਹੋਣ ਵਾਲੇ ਕਿਸੇ ਵੀ ਗਲਤਫਹਿਮੀ ਜਾਂ ਗਲਤ ਵਿਆਖਿਆ ਲਈ ਜ਼ਿੰਮੇਵਾਰ ਨਹੀਂ ਹਾਂ।