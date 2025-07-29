<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "63b6426b88f6f56398ca3f1fbfc30889",
  "translation_date": "2025-07-29T08:52:17+00:00",
  "source_file": "README.md",
  "language_code": "pa"
}
-->
# ਜਨਰੇਟਿਵ AI ਸ਼ੁਰੂਆਤੀਆਂ ਲਈ - ਜਾਵਾ ਐਡੀਸ਼ਨ
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generative AI for Beginners - Java Edition](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.pa.png)

**ਸਮਾਂ ਦੀ ਲੋੜ**: ਪੂਰਾ ਵਰਕਸ਼ਾਪ ਆਨਲਾਈਨ ਬਿਨਾਂ ਕਿਸੇ ਲੋਕਲ ਸੈਟਅੱਪ ਦੇ ਪੂਰਾ ਕੀਤਾ ਜਾ ਸਕਦਾ ਹੈ। ਵਾਤਾਵਰਣ ਸੈਟਅੱਪ ਲਈ 2 ਮਿੰਟ ਲਗਦੇ ਹਨ, ਜਦਕਿ ਨਮੂਨਿਆਂ ਦੀ ਪੜਚੋਲ ਕਰਨ ਲਈ 1-3 ਘੰਟੇ ਲੱਗ ਸਕਦੇ ਹਨ, ਇਹ ਪੜਚੋਲ ਦੀ ਗਹਿਰਾਈ 'ਤੇ ਨਿਰਭਰ ਕਰਦਾ ਹੈ।

> **ਤੁਰੰਤ ਸ਼ੁਰੂਆਤ**

1. ਇਸ ਰਿਪੋਜ਼ਟਰੀ ਨੂੰ ਆਪਣੇ GitHub ਖਾਤੇ ਵਿੱਚ ਫੋਰਕ ਕਰੋ
2. **Code** → **Codespaces** ਟੈਬ → **...** → **New with options...** 'ਤੇ ਕਲਿਕ ਕਰੋ
3. ਡਿਫਾਲਟ ਸੈਟਿੰਗਾਂ ਵਰਤੋ – ਇਹ ਇਸ ਕੋਰਸ ਲਈ ਬਣਾਏ ਗਏ ਡਿਵੈਲਪਮੈਂਟ ਕੰਟੇਨਰ ਨੂੰ ਚੁਣੇਗਾ
4. **Create codespace** 'ਤੇ ਕਲਿਕ ਕਰੋ
5. ਵਾਤਾਵਰਣ ਤਿਆਰ ਹੋਣ ਲਈ ~2 ਮਿੰਟ ਇੰਤਜ਼ਾਰ ਕਰੋ
6. ਸਿੱਧੇ [ਪਹਿਲੇ ਉਦਾਹਰਨ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) 'ਤੇ ਜਾਓ

## ਬਹੁ-ਭਾਸ਼ਾਈ ਸਹਾਇਤਾ

### GitHub Action ਰਾਹੀਂ ਸਹਾਇਕ (ਆਟੋਮੈਟਿਕ ਅਤੇ ਹਮੇਸ਼ਾ ਅਪ-ਟੂ-ਡੇਟ)

[French](../fr/README.md) | [Spanish](../es/README.md) | [German](../de/README.md) | [Russian](../ru/README.md) | [Arabic](../ar/README.md) | [Persian (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Hindi](../hi/README.md) | [Bengali](../bn/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Punjabi (Gurmukhi)](./README.md) | [Portuguese (Portugal)](../pt/README.md) | [Portuguese (Brazil)](../br/README.md) | [Italian](../it/README.md) | [Polish](../pl/README.md) | [Turkish](../tr/README.md) | [Greek](../el/README.md) | [Thai](../th/README.md) | [Swedish](../sv/README.md) | [Danish](../da/README.md) | [Norwegian](../no/README.md) | [Finnish](../fi/README.md) | [Dutch](../nl/README.md) | [Hebrew](../he/README.md) | [Vietnamese](../vi/README.md) | [Indonesian](../id/README.md) | [Malay](../ms/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Swahili](../sw/README.md) | [Hungarian](../hu/README.md) | [Czech](../cs/README.md) | [Slovak](../sk/README.md) | [Romanian](../ro/README.md) | [Bulgarian](../bg/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Croatian](../hr/README.md) | [Slovenian](../sl/README.md) | [Ukrainian](../uk/README.md) | [Burmese (Myanmar)](../my/README.md)

## ਕੋਰਸ ਦੀ ਬਣਾਵਟ ਅਤੇ ਸਿੱਖਣ ਦਾ ਰਸਤਾ

### **ਅਧਿਆਇ 1: ਜਨਰੇਟਿਵ AI ਦਾ ਪਰਿਚਯ**
- **ਮੁੱਖ ਧਾਰਨਾਵਾਂ**: ਵੱਡੇ ਭਾਸ਼ਾ ਮਾਡਲਾਂ, ਟੋਕਨ, ਐਮਬੈਡਿੰਗ ਅਤੇ AI ਸਮਰੱਥਾਵਾਂ ਨੂੰ ਸਮਝਣਾ
- **ਜਾਵਾ AI ਪਰਿਸਰ**: Spring AI ਅਤੇ OpenAI SDKs ਦਾ ਜਾਇਜ਼ਾ
- **ਮਾਡਲ ਕੌਂਟੈਕਸਟ ਪ੍ਰੋਟੋਕੋਲ**: MCP ਅਤੇ ਇਸ ਦੀ AI ਏਜੰਟ ਸੰਚਾਰ ਵਿੱਚ ਭੂਮਿਕਾ
- **ਵਿਵਹਾਰਕ ਐਪਲੀਕੇਸ਼ਨ**: ਚੈਟਬੋਟ ਅਤੇ ਸਮੱਗਰੀ ਜਨਰੇਸ਼ਨ ਵਰਗੇ ਹਕੀਕਤੀ ਸਥਿਤੀਆਂ
- **[→ ਅਧਿਆਇ 1 ਸ਼ੁਰੂ ਕਰੋ](./01-IntroToGenAI/README.md)**

### **ਅਧਿਆਇ 2: ਡਿਵੈਲਪਮੈਂਟ ਵਾਤਾਵਰਣ ਸੈਟਅੱਪ**
- **ਮਲਟੀ-ਪ੍ਰੋਵਾਈਡਰ ਕਨਫਿਗਰੇਸ਼ਨ**: GitHub ਮਾਡਲਾਂ, Azure OpenAI, ਅਤੇ OpenAI ਜਾਵਾ SDK ਇੰਟੀਗ੍ਰੇਸ਼ਨ ਸੈਟਅੱਪ ਕਰੋ
- **Spring Boot + Spring AI**: ਕਾਰੋਬਾਰੀ AI ਐਪਲੀਕੇਸ਼ਨ ਵਿਕਾਸ ਲਈ ਸਭ ਤੋਂ ਵਧੀਆ ਤਰੀਕੇ
- **GitHub ਮਾਡਲਾਂ**: ਪ੍ਰੋਟੋਟਾਈਪਿੰਗ ਅਤੇ ਸਿੱਖਣ ਲਈ ਮੁਫ਼ਤ AI ਮਾਡਲ ਪਹੁੰਚ (ਕੋਈ ਕ੍ਰੈਡਿਟ ਕਾਰਡ ਲੋੜੀਂਦਾ ਨਹੀਂ)
- **ਡਿਵੈਲਪਮੈਂਟ ਟੂਲਜ਼**: Docker ਕੰਟੇਨਰ, VS Code, ਅਤੇ GitHub Codespaces ਕਨਫਿਗਰੇਸ਼ਨ
- **[→ ਅਧਿਆਇ 2 ਸ਼ੁਰੂ ਕਰੋ](./02-SetupDevEnvironment/README.md)**

### **ਅਧਿਆਇ 3: ਮੁੱਖ ਜਨਰੇਟਿਵ AI ਤਕਨੀਕਾਂ**
- **ਪ੍ਰਾਂਪਟ ਇੰਜੀਨੀਅਰਿੰਗ**: AI ਮਾਡਲ ਦੇ ਉੱਤਮ ਜਵਾਬਾਂ ਲਈ ਤਕਨੀਕਾਂ
- **ਐਮਬੈਡਿੰਗ ਅਤੇ ਵੈਕਟਰ ਓਪਰੇਸ਼ਨ**: ਸੈਮਾਂਟਿਕ ਖੋਜ ਅਤੇ ਸਮਾਨਤਾ ਮੈਚਿੰਗ ਨੂੰ ਲਾਗੂ ਕਰੋ
- **ਰਿਟਰੀਵਲ-ਅਗਮੈਂਟਡ ਜਨਰੇਸ਼ਨ (RAG)**: ਆਪਣੇ ਡਾਟਾ ਸਰੋਤਾਂ ਨਾਲ AI ਨੂੰ ਜੋੜੋ
- **ਫੰਕਸ਼ਨ ਕਾਲਿੰਗ**: ਕਸਟਮ ਟੂਲਜ਼ ਅਤੇ ਪਲੱਗਇਨ ਨਾਲ AI ਸਮਰੱਥਾਵਾਂ ਨੂੰ ਵਧਾਓ
- **[→ ਅਧਿਆਇ 3 ਸ਼ੁਰੂ ਕਰੋ](./03-CoreGenerativeAITechniques/README.md)**

### **ਅਧਿਆਇ 4: ਵਿਵਹਾਰਕ ਐਪਲੀਕੇਸ਼ਨ ਅਤੇ ਪ੍ਰੋਜੈਕਟ**
- **ਪੈਟ ਸਟੋਰੀ ਜਨਰੇਟਰ** (`petstory/`): GitHub ਮਾਡਲਾਂ ਨਾਲ ਰਚਨਾਤਮਕ ਸਮੱਗਰੀ ਜਨਰੇਸ਼ਨ
- **Foundry Local Demo** (`foundrylocal/`): OpenAI ਜਾਵਾ SDK ਨਾਲ ਸਥਾਨਕ AI ਮਾਡਲ ਇੰਟੀਗ੍ਰੇਸ਼ਨ
- **MCP ਕੈਲਕੁਲੇਟਰ ਸੇਵਾ** (`calculator/`): Spring AI ਨਾਲ ਬੁਨਿਆਦੀ ਮਾਡਲ ਕੌਂਟੈਕਸਟ ਪ੍ਰੋਟੋਕੋਲ ਲਾਗੂ ਕਰਨਾ
- **[→ ਅਧਿਆਇ 4 ਸ਼ੁਰੂ ਕਰੋ](./04-PracticalSamples/README.md)**

### **ਅਧਿਆਇ 5: ਜ਼ਿੰਮੇਵਾਰ AI ਵਿਕਾਸ**
- **GitHub ਮਾਡਲਾਂ ਦੀ ਸੁਰੱਖਿਆ**: ਸਮੱਗਰੀ ਫਿਲਟਰੀਂਗ ਅਤੇ ਸੁਰੱਖਿਆ ਮਕੈਨਿਜ਼ਮ (ਹਾਰਡ ਬਲੌਕ ਅਤੇ ਸੌਫਟ ਰਿਫ਼ਿਊਜ਼ਲ) ਦੀ ਜਾਂਚ ਕਰੋ
- **ਜ਼ਿੰਮੇਵਾਰ AI ਡੈਮੋ**: ਵਿਵਹਾਰਕ ਉਦਾਹਰਨ ਜੋ ਦਿਖਾਉਂਦਾ ਹੈ ਕਿ ਆਧੁਨਿਕ AI ਸੁਰੱਖਿਆ ਪ੍ਰਣਾਲੀਆਂ ਕਿਵੇਂ ਕੰਮ ਕਰਦੀਆਂ ਹਨ
- **ਸਭ ਤੋਂ ਵਧੀਆ ਤਰੀਕੇ**: ਨੈਤਿਕ AI ਵਿਕਾਸ ਅਤੇ ਤੈਨਾਤੀ ਲਈ ਜ਼ਰੂਰੀ ਦਿਸ਼ਾ-ਨਿਰਦੇਸ਼
- **[→ ਅਧਿਆਇ 5 ਸ਼ੁਰੂ ਕਰੋ](./05-ResponsibleGenAI/README.md)**

## ਵਾਧੂ ਸਰੋਤ

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

**ਅਸਵੀਕਰਤੀ**:  
ਇਹ ਦਸਤਾਵੇਜ਼ AI ਅਨੁਵਾਦ ਸੇਵਾ [Co-op Translator](https://github.com/Azure/co-op-translator) ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਅਨੁਵਾਦ ਕੀਤਾ ਗਿਆ ਹੈ। ਜਦੋਂ ਕਿ ਅਸੀਂ ਸਹੀ ਹੋਣ ਦਾ ਯਤਨ ਕਰਦੇ ਹਾਂ, ਕਿਰਪਾ ਕਰਕੇ ਧਿਆਨ ਦਿਓ ਕਿ ਸਵੈਚਾਲਿਤ ਅਨੁਵਾਦਾਂ ਵਿੱਚ ਗਲਤੀਆਂ ਜਾਂ ਅਸੁਣਤਾਈਆਂ ਹੋ ਸਕਦੀਆਂ ਹਨ। ਇਸ ਦੀ ਮੂਲ ਭਾਸ਼ਾ ਵਿੱਚ ਮੌਜੂਦ ਮੂਲ ਦਸਤਾਵੇਜ਼ ਨੂੰ ਪ੍ਰਮਾਣਿਕ ਸਰੋਤ ਮੰਨਿਆ ਜਾਣਾ ਚਾਹੀਦਾ ਹੈ। ਮਹੱਤਵਪੂਰਨ ਜਾਣਕਾਰੀ ਲਈ, ਪੇਸ਼ੇਵਰ ਮਨੁੱਖੀ ਅਨੁਵਾਦ ਦੀ ਸਿਫਾਰਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ। ਇਸ ਅਨੁਵਾਦ ਦੇ ਪ੍ਰਯੋਗ ਤੋਂ ਪੈਦਾ ਹੋਣ ਵਾਲੇ ਕਿਸੇ ਵੀ ਗਲਤਫਹਿਮੀ ਜਾਂ ਗਲਤ ਵਿਆਖਿਆ ਲਈ ਅਸੀਂ ਜ਼ਿੰਮੇਵਾਰ ਨਹੀਂ ਹਾਂ।