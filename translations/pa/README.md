# ਸ਼ੁਰੂਆਤੀ ਲਈ ਜਨਰੇਟਿਵ AI - ਜਾਵਾ ਸੰਸਕਰਨ
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/pa/beg-genai-series.8b48be9951cc574c.webp)

**ਸਮਾਂ ਸਮਰਪਣ**: ਸਾਰਾ ਵਰਕਸ਼ਾਪ ਆਨਲਾਈਨ ਬਿਨਾਂ ਸਥਾਨਕ ਸੈਟਅਪ ਦੇ ਪੂਰਾ ਕੀਤਾ ਜਾ ਸਕਦਾ ਹੈ। ਵਾਤਾਵਰਣ ਸੈਟਅਪ 2 ਮਿੰਟ ਲੈਂਦਾ ਹੈ, ਜਦਕਿ ਨਮੂਨਿਆਂ ਦੀ ਖੋਜ ਲਈ 1-3 ਘੰਟੇ ਲੱਗ ਸਕਦੇ ਹਨ ਖੋਜ ਦੀ ਡੂੰਘਾਈ ਨੂੰ ਧਿਆਨ ਵਿਚ ਰੱਖਦਿਆਂ।

> **ਤੇਜ਼ ਸ਼ੁਰੂਆਤ** 

1. ਇਸ ਰਿਪੋਜ਼ਿਟਰੀ ਨੂੰ ਆਪਣੇ GitHub ਖਾਤੇ ਵਿੱਚ Fork ਕਰੋ
2. ਬਟਨ **Code** → **Codespaces** ਟੈਬ → **...** → **New with options...** ਤੇ ਕਲਿੱਕ ਕਰੋ
3. ਮੂਲ ਸੈਟਿੰਗਾਂ ਵਰਤੋਂ – ਇਸ ਨਾਲ ਇਸ ਕੋਰਸ ਲਈ ਬਣਾਇਆ ਵਿਕਾਸ ਕੰਟੇਨਰ ਚੁਣਿਆ ਜਾਵੇਗਾ
4. **Create codespace** 'ਤੇ ਕਲਿੱਕ ਕਰੋ
5. ਵਾਤਾਵਰਣ ਤਿਆਰ ਹੋਣ ਲਈ ਲਗਭਗ 2 ਮਿੰਟ ਉਡੀਕ ਕਰੋ
6. ਸਿੱਧਾ [ਪਹਿਲਾ ਉਦਾਹਰਣ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) ਵੱਲ ਜਾਓ

> **ਥਾਂਨੀਕਲ ਕਲੋਨ ਕਰਨਾ ਪਸੰਦ ਹੈ?**
>
> ਇਸ ਰਿਪੋਜ਼ਿਟਰੀ ਵਿਚ 50+ ਭਾਸ਼ਾ ਅਨੁਵਾਦ ਸ਼ਾਮਲ ਹਨ ਜੋ ਡਾਊਨਲੋਡ ਸਾਈਜ਼ ਨੂੰ ਕਾਫੀ ਵਧਾਉਂਦੇ ਹਨ। ਬਿਨਾਂ ਅਨੁਵਾਦਾਂ ਵਾਲਾ ਕਲੋਨ ਕਰਨ ਲਈ sparse checkout ਵਰਤੋਂ:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ਇਸ ਨਾਲ ਤੁਹਾਨੂੰ ਇਹ ਕੋਰਸ ਪੂਰਾ ਕਰਨ ਲਈ ਸਾਰਾ ਕੁਝ ਤੇਜ਼ ਡਾਊਨਲੋਡ ਨਾਲ ਮਿਲ ਜਾਵੇਗਾ।


## ਬਹੁ-ਭਾਸ਼ਾਈ ਸਹਾਇਤਾ

### GitHub ਐਕਸ਼ਨ ਰਾਹੀਂ ਸਹਾਇਤਾਪ੍ਰਾਪਤ (ਆਟੋਮੈਟਿਕ ਅਤੇ ਹਮੇਸ਼ਾ ਅਪ-ਟੂ-ਡੇਟ)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](../my/README.md) | [Chinese (Simplified)](../zh-CN/README.md) | [Chinese (Traditional, Hong Kong)](../zh-HK/README.md) | [Chinese (Traditional, Macau)](../zh-MO/README.md) | [Chinese (Traditional, Taiwan)](../zh-TW/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Kannada](../kn/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Malayalam](../ml/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Nigerian Pidgin](../pcm/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../pt-BR/README.md) | [Portuguese (Portugal)](../pt-PT/README.md) | [Punjabi (Gurmukhi)](./README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Telugu](../te/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)

## ਕੋਰਸ ਸੰਰਚਨਾ ਅਤੇ ਸਿੱਖਣ ਦਾ ਰਾਹ

### **ਅਧਿਆਇ 1: ਜਨਰੇਟਿਵ AI ਦਾ ਜਾਣ-ਪਛਾਣ**
- **ਮੁੱਖ ਧਾਰਣਾਵਾਂ**: ਵੱਡੇ ਭਾਸ਼ਾ ਮਾਡਲਾਂ, ਟੋਕਨ, ਐਮਬੈਡਿੰਗਸ, ਅਤੇ AI ਸਮਰੱਥਾਵਾਂ ਦੀ ਸਮਝ
- **ਜਾਵਾ AI ਪਰਿਸਰ**: Spring AI ਅਤੇ OpenAI SDKs ਦਾ ਓਵਰਵਿਊ
- **ਮਾਡਲ ਸੰਦਰਭ ਪ੍ਰੋਟੋਕਾਲ**: MCP ਦਾ ਪਰਿਚਯ ਅਤੇ ਇਸਦਾ AI ਏਜੰਟ ਸੰਚਾਰ ‘ਚ ਭੂਮਿਕਾ
- **ਵਿਆਹਾਰੀਕ ਉਪਯੋਗ**: ਚੈਟਬੌਟਸ ਅਤੇ ਸਮੱਗਰੀ ਬਣਾਉਣ ਸਮੇਤ ਅਸਲ ਜ਼ਿੰਦਗੀ ਦੇ ਮਾਮਲੇ
- **[→ ਸ਼ੁਰੂ ਕਰੋ ਅਧਿਆਇ 1](./01-IntroToGenAI/README.md)**

### **ਅਧਿਆਇ 2: ਵਿਕਾਸ ਵਾਤਾਵਰਣ ਸੈਟਅਪ**
- **ਬਹੁ-ਪ੍ਰਦਾਤਾ ਕਨਫਿਗਰੇਸ਼ਨ**: GitHub Models, Azure OpenAI, ਅਤੇ OpenAI Java SDK ਇੰਟੀਗ੍ਰੇਸ਼ਨ ਸੈਟਅਪ ਕਰੋ
- **Spring Boot + Spring AI**: ਉਦਯੋਗਿਕ AI ਐਪਲੀਕੇਸ਼ਨ ਡਿਵੈਲਪਮੈਂਟ ਲਈ ਬਿਹਤਰ ਅਭਿਆਸ
- **GitHub Models**: ਪ੍ਰੋਟੋਟਾਈਪਿੰਗ ਅਤੇ ਸਿੱਖਣ ਲਈ ਮੁਫਤ AI ਮਾਡਲ ਐਕਸੇਸ (ਕੋਈ ਕਰੈਡਿਟ ਕਾਰਡ ਨਹੀਂ ਚਾਹੀਦਾ)
- **ਵਿਕਾਸ ਸੰਦ**: ਡੋਕਰ ਕੰਟੇਨਰ, VS ਕੋਡ, ਅਤੇ GitHub Codespaces ਸੰਰਚਨਾ
- **[→ ਸ਼ੁਰੂ ਕਰੋ ਅਧਿਆਇ 2](./02-SetupDevEnvironment/README.md)**

### **ਅਧਿਆਇ 3: ਮੁੱਖ ਜਨਰੇਟਿਵ AI ਤਕਨੀਕਾਂ**
- **ਪ੍ਰಾಂਪਟ ਇੰਜੀਨੀਅਰਿੰਗ**: ਮਾਡਲ ਤੋਂ ਸਰਵੋੱਤਮ ਜਵਾਬ ਪ੍ਰਾਪਤ ਕਰਨ ਦੀ ਤਕਨੀਕਾਂ
- **ਐਮਬੈਡਿੰਗਸ ਅਤੇ ਵੇਕਟਰ ਓਪਰੇਸ਼ਨਜ਼**: ਅਰਥਾਤਮਕ ਖੋਜ ਅਤੇ ਸਮਾਨਤਾ ਮੇਲ ਕਰਨਾ ਲਾਗੂ ਕਰੋ
- **ਰਿਟਰੀਵਲ-ਆਗਮੈਂਟਡ ਜਨਰੇਸ਼ਨ (RAG)**: AI ਨੂੰ ਆਪਣੇ ਖੁਦ ਦੇ ਡਾਟਾ ਸਰੋਤਾਂ ਨਾਲ ਮਿਲਾਓ
- **ਫੰਕਸ਼ਨ ਕਾਲਿੰਗ**: ਖ਼ਾਸ ਟੂਲ ਅਤੇ ਪਲੱਗਇਨਾਂ ਨਾਲ AI ਸਮਰੱਥਾਵਾਂ ਵਧਾਓ
- **[→ ਸ਼ੁਰੂ ਕਰੋ ਅਧਿਆਇ 3](./03-CoreGenerativeAITechniques/README.md)**

### **ਅਧਿਆਇ 4: ਵਿਆਹਾਰੀਕ ਉਪਯੋਗ ਅਤੇ ਪ੍ਰੋਜੈਕਟ**
- **ਪਿੱਟ ਕਹਾਣੀ ਜਨਰੇਟਰ** (`petstory/`): GitHub Models ਨਾਲ ਰਚਨਾਤਮਕ ਸਮੱਗਰੀ ਬਣਾਉਣਾ
- **Foundry लोकल ਡੈਮੋ** (`foundrylocal/`): OpenAI Java SDK ਨਾਲ ਸਥਾਨਕ AI ਮਾਡਲ ਇੰਟੀਗ੍ਰੇਸ਼ਨ
- **MCP ਕੈਲਕੁਲੇਟਰ ਸਰਵਿਸ** (`calculator/`): Spring AI ਨਾਲ ਮੁੱਢਲਾ ਮਾਡਲ ਸੰਦਰਭ ਪ੍ਰੋਟੋਕਾਲ ਲਾਗੂ ਕਰਨਾ
- **[→ ਸ਼ੁਰੂ ਕਰੋ ਅਧਿਆਇ 4](./04-PracticalSamples/README.md)**

### **ਅਧਿਆਇ 5: ਜਵਾਬਦੇਹ AI ਵਿਕਾਸ**
- **GitHub Models ਸੁਰੱਖਿਆ**: ਬਿਲਟ-ਇਨ ਸਮੱਗਰੀ ਛਾਂਟੀ ਅਤੇ ਸੁਰੱਖਿਆ ਮਕੈਨਿਜ਼ਮ (ਹਾਰਡ ਬਲਾਕ ਅਤੇ ਸਾਫਟ ਇਨਕਾਰ)
- **ਜਵਾਬਦੇਹ AI ਡੈਮੋ**: ਹਥਿਆਰਾਂ ਵਾਲਾ ਉਦਾਹਰਣ ਜੋ ਦਿਖਾਉਂਦਾ ਹੈ ਕਿ ਆਧੁਨਿਕ AI ਸੁਰੱਖਿਆ ਪ੍ਰਣਾਲੀਆਂ ਕਿਵੇਂ ਕੰਮ ਕਰਦੀਆਂ ਹਨ
- **ਸਰਵੋਤਮ ਅਭਿਆਸ**: ਨੈਤਿਕ AI ਵਿਕਾਸ ਅਤੇ ਤਾਇਨਾਤੀ ਲਈ ਜਰੂਰੀ ਹਦਾਇਤਾਂ
- **[→ ਸ਼ੁਰੂ ਕਰੋ ਅਧਿਆਇ 5](./05-ResponsibleGenAI/README.md)**

## ਵਾਧੂ ਸਰੋਤ

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### ਲੈਂਗਚੇਨ
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain for Beginners](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### ਏਜ਼ਯੂਰ / एज / MCP / ਏਜੰਟ
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### ਜਨਰੇਟਿਵ AI ਸਰੀਜ਼
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### ਮੁੱਖ ਸਿੱਖਿਆ
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### ਕੋਪਾਇਲਟ ਸੀਰੀਜ਼
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## ਸਹਾਇਤਾ ਪ੍ਰਾਪਤ ਕਰੋ

ਜੇਕਰ ਤੁਹਾਡੇ ਨੂੰ ਰੁਕਾਵਟ ਆਏ ਜਾਂ AI ਐਪ ਬਣਾਉਣ ਬਾਰੇ ਕੋਈ ਸਵਾਲ ਹੋਵੇ। MCP ਬਾਰੇ ਚਰਚਾਵਾਂ ਵਿੱਚ ਸਾਥੀ ਸਿੱਖਣ ਵਾਲਿਆਂ ਅਤੇ ਅਨੁਭਵੀ ਵਿਕਾਸਕਾਰਾਂ ਨਾਲ ਜੁੜੋ। ਇਹ ਇੱਕ ਸਹਾਇਕ ਭਾਈਚਾਰਾ ਹੈ ਜਿੱਥੇ ਸਵਾਲਾਂ ਦਾ ਸਵਾਗਤ ਹੈ ਅਤੇ ਗਿਆਨ ਆਜ਼ਾਦੀ ਨਾਲ ਸਾਂਝਾ ਕੀਤਾ ਜਾਂਦਾ ਹੈ।

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

ਜੇ ਤੁਹਾਡੇ ਕੋਲ ਉਤਪਾਦ ਫੀਡਬੈਕ ਜਾਂ ਬਣਾਉਂਦੇ ਸਮੇਂ ਗਲਤੀਆਂ ਹਨ ਤਾਂ ਜਾਓ:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ਅਸਵੀਕਾਰਤਾ**:  
ਇਸ ਦਸਤਾਵੇਜ਼ ਦਾ ਅਨੁਵਾਦ AI ਅਨੁਵਾਦ ਸੇਵਾ [Co-op Translator](https://github.com/Azure/co-op-translator) ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਕੀਤਾ ਗਿਆ ਹੈ। ਜਦੋਂ ਕਿ ਅਸੀਂ ਸਹੀਤਾ ਲਈ ਕੋਸ਼ਿਸ਼ ਕਰਦੇ ਹਾਂ, ਕਿਰਪਾ ਕਰਕੇ ਧਿਆਨ ਵਿੱਚ ਰੱਖੋ ਕਿ ਆਟੋਮੇਟਿਕ ਅਨੁਵਾਦਾਂ ਵਿੱਚ ਗਲਤੀਆਂ ਜਾਂ ਅਸਮਤੋਸ਼ਜਨਕ ਪੱਖ ਹੋ ਸਕਦੇ ਹਨ। ਮੂਲ ਦਸਤਾਵੇਜ਼ ਨੂੰ ਇਸਦੀ ਮੂਲ ਭਾਸ਼ਾ ਵਿੱਚ ਪ੍ਰਮੁੱਖ ਸਰੋਤ ਮੰਨਿਆ ਜਾਣਾ ਚਾਹੀਦਾ ਹੈ। ਮਹੱਤਵਪੂਰਨ ਜਾਣਕਾਰੀ ਲਈ, ਪ੍ਰੋਫੈਸ਼ਨਲ ਮਾਨਵ ਅਨੁਵਾਦ ਦੀ ਸਿਫਾਰਿਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ। ਇਸ ਅਨੁਵਾਦ ਦੀ ਵਰਤੋਂ ਕਾਰਨ ਕਿਸੇ ਵੀ ਗਲਤਫਹਮੀ ਜਾਂ ਗਲਤ ਵਿਆਖਿਆ ਲਈ ਅਸੀਂ ਜ਼ਿੰਮੇਵਾਰ ਨਹੀਂ ਹਾਂ।
<!-- CO-OP TRANSLATOR DISCLAIMER END -->