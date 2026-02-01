# ਜਨੇਰੇਟਿਵ ਏਆਈ ਫਾਰ ਬਿਗਿਨਰਜ਼ - ਜਾਵਾ ਐਡੀਸ਼ਨ
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/pa/beg-genai-series.8b48be9951cc574c.webp)

**ਸਮਾਂ ਬੱਝਤ**: ਪੂਰਾ ਵਰਕਸ਼ਾਪ ਔਨਲਾਈਨ ਬਿਨਾਂ ਲੋਕਲ ਸੈਟਅਪ ਦੇ ਮੁਕੰਮਲ ਕੀਤਾ ਜਾ ਸਕਦਾ ਹੈ। ਪਰਿਵੇਸ਼ ਸੈਟਅਪ ਕਰਨ ਵਿੱਚ 2 ਮਿੰਟ ਲੱਗਦੇ ਹਨ, ਅਤੇ ਸੈਂਪਲ ਦੀ ਖੋਜ ਕਰਨ ਲਈ ਅਨੁਸੰਧਾਨ ਦੀ ਗਹਿਰਾਈ ਦੇ ਅਧਾਰ 'ਤੇ 1-3 ਘੰਟੇ ਲੱਗ ਸਕਦੇ ਹਨ।

> **ਤੁਰੰਤ ਸ਼ੁਰੂਆਤ** 

1. ਇਸ ਰਿਪੋਜ਼ਟਰੀ ਨੂੰ ਆਪਣੇ GitHub ਅਕਾਉਂਟ 'ਤੇ ਫੋਰਕ ਕਰੋ
2. **Code** → **Codespaces** ਟੈਬ → **...** → **New with options...** 'ਤੇ ਕਲਿੱਕ ਕਰੋ
3. ਡੀਫੌਲਟ ਵਰਤੋਂ – ਇਹ ਕੋਰਸ ਲਈ ਬਣਾਈ ਗਈ ਵਿਕਾਸ ਕਂਟੇਨਰ ਸਿਲੈਕਟ ਕਰੇਗਾ
4. **Create codespace** 'ਤੇ ਕਲਿੱਕ ਕਰੋ
5. ਪਰਿਵੇਸ਼ ਤਿਆਰ ਹੋਣ ਲਈ ਲਗਭਗ 2 ਮਿੰਟ ਰੁਕੋ
6. ਸਿੱਧਾ [ਪਹਿਲਾ ਉਦਾਹਰਨ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) 'ਤੇ ਜਾਓ

> **ਲੋਕਲ ਕਲੋਨ ਕਰਨਾ ਪਸੰਦ ਹੈ?**
>
> ਇਸ ਰਿਪੋਜ਼ਟਰੀ ਵਿੱਚ 50+ ਭਾਸ਼ਾਈ ਅਨੁਵਾਦ ਸ਼ਾਮਲ ਹਨ ਜੋ ਡਾਊਨਲੋਡ ਸਾਈਜ਼ ਨੂੰ ਬਹੁਤ ਵਧਾ ਦਿੰਦੇ ਹਨ। ਅਨੁਵਾਦ ਬਿਨਾਂ ਕਲੋਨ ਕਰਨ ਲਈ sparse checkout ਵਰਤੋ:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ਇਹ ਤੁਹਾਨੂੰ ਕੋਰਸ ਨੂੰ ਪੂਰਾ ਕਰਨ ਲਈ ਸਾਰਾ ਕੁਝ ਬਹੁਤ ਤੇਜ਼ ਡਾਊਨਲੋਡ ਦੇ ਨਾਲ ਦਿੰਦਾ ਹੈ।


## ਬਹੁ-ਭਾਸ਼ੀ ਸਮਰਥਨ

### GitHub ਐਕਸ਼ਨ ਰਾਹੀਂ ਸਮਰਥਿਤ (ਆਟੋਮੈਟਿਕ ਅਤੇ ਹਮੇਸ਼ਾਂ ਨਵੀਨਤਮ)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](../my/README.md) | [Chinese (Simplified)](../zh-CN/README.md) | [Chinese (Traditional, Hong Kong)](../zh-HK/README.md) | [Chinese (Traditional, Macau)](../zh-MO/README.md) | [Chinese (Traditional, Taiwan)](../zh-TW/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Kannada](../kn/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Malayalam](../ml/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Nigerian Pidgin](../pcm/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../pt-BR/README.md) | [Portuguese (Portugal)](../pt-PT/README.md) | [Punjabi (Gurmukhi)](./README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Telugu](../te/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)

> **ਲੋਕਲ ਕਲੋਨ ਕਰਨਾ ਪਸੰਦ ਹੈ?**

> ਇਸ ਰਿਪੋਜ਼ਟਰੀ ਵਿੱਚ 50+ ਭਾਸ਼ਾਈ ਅਨੁਵਾਦ ਸ਼ਾਮਲ ਹਨ ਜੋ ਡਾਊਨਲੋਡ ਸਾਈਜ਼ ਨੂੰ ਬਹੁਤ ਵਧਾ ਦਿੰਦੇ ਹਨ। ਅਨੁਵਾਦ ਬਿਨਾਂ ਕਲੋਨ ਕਰਨ ਲਈ sparse checkout ਵਰਤੋ:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ਇਹ ਤੁਹਾਨੂੰ ਕੋਰਸ ਨੂੰ ਪੂਰਾ ਕਰਨ ਲਈ ਸਾਰਾ ਕੁਝ ਬਹੁਤ ਤੇਜ਼ ਡਾਊਨਲੋਡ ਦੇ ਨਾਲ ਦਿੰਦਾ ਹੈ।
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## ਕੋਰਸ ਢਾਂਚਾ ਅਤੇ ਸਿੱਖਣ ਦਾ ਰਸਤਾ

### **ਅਧਿਆਇ 1: ਜਨੇਰੇਟਿਵ ਏਆਈ ਨਾਲ ਜਾਣ-ਪਛਾਣ**
- **ਮੁੱਖ ਧਾਰਨਾਵਾਂ**: ਵੱਡੇ ਭਾਸ਼ਾਈ ਮਾਡਲਜ਼, ਟੋਕਨ, ਐਮਬੈੱਡਿੰਗਜ਼ ਅਤੇ ਏਆਈ ਯੋਗਤਾਵਾਂ ਦੀ ਸਮਝ
- **ਜਾਵਾ ਏਆਈ ਪ੍ਰਣਾਲੀ**: Spring AI ਅਤੇ OpenAI SDKs ਦਾ ਜਾਇਜ਼ਾ
- **ਮਾਡਲ ਕਾਂਟੈਕਸਟ ਪ੍ਰੋਟੋਕੋਲ**: MCP ਦਾ ਪਰਿਚਯ ਅਤੇ ਏਆਈ ਏਜੰਟ ਸੰਚਾਰ ਵਿੱਚ ਇਸ ਦੀ ਭੂਮਿਕਾ
- **ਵਿਆਵਹਾਰਕ ਪ੍ਰਭਾਵ**: ਰੀਅਲ-ਵਰਲਡ ਸਥਿਤੀਆਂ ਜਿਵੇਂ ਚੈਟਬੋਟ ਅਤੇ ਸਮੱਗਰੀ ਸਿਰਜਣਾ
- **[→ ਅਧਿਆਇ 1 ਸ਼ੁਰੂ ਕਰੋ](./01-IntroToGenAI/README.md)**

### **ਅਧਿਆਇ 2: ਵਿਕਾਸ ਪਰਿਵੇਸ਼ ਸੈਟਅਪ**
- **ਮਲਟੀ-ਪ੍ਰੋਵਾਈਡਰ ਕੰਫਿਗੁਰੇਸ਼ਨ**: GitHub ਮਾਡਲਜ਼, Azure OpenAI ਅਤੇ OpenAI ਜਾਵਾ SDK ਇੰਟੇਗ੍ਰੇਸ਼ਨ ਸੈਟਅਪ ਕਰੋ
- **Spring Boot + Spring AI**: ਐਂਟਰਪ੍ਰਾਈਜ਼ ਏਆਈ ਐਪਲੀਕੇਸ਼ਨ ਵਿਕਾਸ ਲਈ ਵਧੀਆ ਅਭਿਆਸ
- **GitHub ਮਾਡਲਜ਼**: ਪ੍ਰੋਟੋਟਾਈਪਿੰਗ ਅਤੇ ਸਿੱਖਣ ਲਈ ਮੁਫ਼ਤ ਏਆਈ ਮਾਡਲ ਐਕਸੈਸ (ਕੋਈ ਕਰੈਡਿਟ ਕਾਰਡ ਜ਼ਰੂਰੀ ਨਹੀਂ)
- **ਵਿਕਾਸ ਸਾਧਨ**: ਡਾਕਰ ਕੰਟੇਨਰ, VS ਕੋਡ ਅਤੇ GitHub ਕੋਡਸਪੇਸ ਕੰਫਿਗੁਰੇਸ਼ਨ
- **[→ ਅਧਿਆਇ 2 ਸ਼ੁਰੂ ਕਰੋ](./02-SetupDevEnvironment/README.md)**

### **ਅਧਿਆਇ 3: ਮੁੱਖ ਜਨੇਰੇਟਿਵ ਏਆਈ ਤਕਨੀਕਾਂ**
- **ਪ੍ਰਾਂਪਟ ਇੰਜੀਨੀਅਰਿੰਗ**: ਵਧੀਆ ਏਆਈ ਮਾਡਲ ਜਵਾਬ ਲਈ ਤਕਨੀਕਾਂ
- **ਐਮਬੈੱਡਿੰਗਜ਼ ਅਤੇ ਵੈਕਟਰ ਕਾਰਜ**: ਸੈਮਾਂਟਿਕ ਖੋਜ ਅਤੇ ਮਿਲਾਪ ਅਮਲ ਕਰੋ
- **ਰੀਟਰੀਵਲ-ਆਗਮੈਂਟਿਡ ਜਨੇਰੇਸ਼ਨ (RAG)**: ਆਪਣੇ ਡਾਟਾ ਸੋਰਸ ਨਾਲ ਏਆਈ ਨੂੰ ਜੋੜੋ
- **ਫੰਕਸ਼ਨ ਕਾਲਿੰਗ**: ਕਸਟਮ ਸਾਧਨਾਂ ਅਤੇ ਪਲੱਗਇਨਜ਼ ਨਾਲ ਏਆਈ ਯੋਗਤਾਵਾਂ ਵਧਾਓ
- **[→ ਅਧਿਆਇ 3 ਸ਼ੁਰੂ ਕਰੋ](./03-CoreGenerativeAITechniques/README.md)**

### **ਅਧਿਆਇ 4: ਵਿਆਵਹਾਰਕ ਅਰਜ਼ੀਆਂ ਅਤੇ ਪ੍ਰੋਜੈਕਟ**
- **ਪੈਟ ਸਟੋਰੀ ਜਨੇਰੇਟਰ** (`petstory/`): GitHub ਮਾਡਲਜ਼ ਨਾਲ ਰਚਨਾਤਮਕ ਸਮੱਗਰੀ ਜਨੇਰੇਸ਼ਨ
- **ਫਾਊਂਡਰੀ ਲੋਕਲ ਡੈਮੋ** (`foundrylocal/`): OpenAI ਜਾਵਾ SDK ਨਾਲ ਲੋਕਲ ਏਆਈ ਮਾਡਲ ਇੰਟੇਗਰੇਸ਼ਨ
- **MCP ਕੈלקੂਲੇਟਰ ਸਰਵਿਸ** (`calculator/`): Spring AI ਨਾਲ ਮਾਡਲ ਕਾਂਟੈਕਸਟ ਪ੍ਰੋਟੋਕੋਲ ਦੀ ਬੁਨਿਆਦੀ ਲਾਗੂਆਇੀ
- **[→ ਅਧਿਆਇ 4 ਸ਼ੁਰੂ ਕਰੋ](./04-PracticalSamples/README.md)**

### **ਅਧਿਆਇ 5: ਜਵਾਬਦੇਹ ਏਆਈ ਵਿਕਾਸ**
- **GitHub ਮਾਡਲਜ਼ ਸੁਰੱਖਿਆ**: ਬਿਲਟ-ਇਨ ਸਮੱਗਰੀ ਫਿਲਟਰੀਂਗ ਅਤੇ ਸੁਰੱਖਿਆ ਪ੍ਰਣਾਲੀਆਂ ਦਾ ਟੈਸਟ (ਹਾਰਡ ਬਲਾਕ ਅਤੇ ਨਰਮ ਇਨਕਾਰ)
- **ਜਵਾਬਦੇਹ ਏਆਈ ਡੈਮੋ**: ਹੱਥੋਂ-ਹੱਥ ਉਦਾਹਰਨ ਜਿਹੜੀ ਦਿਖਾਉਂਦੀ ਹੈ ਕਿ ਕਿਵੇਂ ਆਧੁਨਿਕ ਏਆਈ ਸੁਰੱਖਿਆ ਪ੍ਰਣਾਲੀਆਂ ਕੰਮ ਕਰਦੀਆਂ ਹਨ
- **ਵਧੀਆ ਅਭਿਆਸ**: ਨੈਤਿਕ ਏਆਈ ਵਿਕਾਸ ਅਤੇ ਤਿਆਰ ਕਰਨ ਲਈ ਮੂਲ ਨਿਯਮ
- **[→ ਅਧਿਆਇ 5 ਸ਼ੁਰੂ ਕਰੋ](./05-ResponsibleGenAI/README.md)**

## ਹੋਰ ਸਰੋਤ

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### Azure / Edge / MCP / Agents
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### ਜਨੇਰੇਟਿਵ ਏਆਈ ਸੀਰੀਜ਼
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### ਕੋਰ ਸਿੱਖਿਆ
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

## ਸਹਾਇਤਾ ਪ੍ਰਾਪਤ ਕਰਨਾ

ਜੇ ਤੁਸੀਂ ਫਸ ਜਾਂਦੇ ਹੋ ਜਾਂ AI ਐਪਸ ਬਣਾਉਣ ਬਾਰੇ ਕਿਸੇ ਵੀ ਪ੍ਰਸ਼ਨ ਹਨ। ਸਾਥੀ ਸਿੱਖਿਆਰਥੀਆਂ ਅਤੇ ਅਨੁਭਵੀ ਡਿਵੈਲਪਰਾਂ ਨਾਲ MCP ਬਾਰੇ ਗੱਲਬਾਤ ਵਿੱਚ ਸ਼ਾਮਿਲ ਹੋਵੋ। ਇਹ ਇੱਕ ਮੇਹਰਬਾਨ ਕਮਿਊਨਿਟੀ ਹੈ ਜਿੱਥੇ ਪ੍ਰਸ਼ਨਾਂ ਦਾ ਸਵਾਗਤ ਕੀਤਾ ਜਾਂਦਾ ਹੈ ਅਤੇ ਗਿਆਨ ਖੁੱਲ੍ਹੇ ਤੌਰ ਤੇ ਸਾਂਝਾ ਕੀਤਾ ਜਾਂਦਾ ਹੈ।

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

ਜੇ ਤੁਹਾਡੇ ਕੋਲ ਪ੍ਰੋਡਕਟ ਫੀਡਬੈਕ ਹੈ ਜਾਂ ਬਣਾਉਂਦੇ ਸਮੇਂ ਕੋਈ ਗਲਤੀਆਂ ਹਨ ਤਾਂ ਦਰਜ ਕਰੋ:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ਅਸਵੀਕਾਰੋਪਤਰ**:  
ਇਹ ਦਸਤਾਵੇਜ਼ AI ਅਨੁਵਾਦ ਸੇਵਾ [Co-op Translator](https://github.com/Azure/co-op-translator) ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਅਨੁਵਾਦ ਕੀਤਾ ਗਿਆ ਹੈ। ਜਦੋਂ ਕਿ ਅਸੀਂ ਸ਼ੁੱਧਤਾ ਲਈ ਕੋਸ਼ਿਸ਼ ਕਰਦੇ ਹਾਂ, ਕਿਰਪਾ ਕਰਕੇ ਧਿਆਨ ਵਿੱਚ ਰੱਖੋ ਕਿ ਸਵੈਚਾਲਿਤ ਅਨੁਵਾਦਾਂ ਵਿੱਚ ਗਲਤੀਆਂ ਜਾਂ ਭੁੱਲਾਂ ਹੋ ਸਕਦੀਆਂ ਹਨ। ਮੂਲ ਦਸਤਾਵੇਜ਼ ਜਿਸ ਭਾਸ਼ਾ ਵਿੱਚ ਹੈ, ਉਸਨੂੰ ਪ੍ਰਮਾਣਿਕ ਸਰੋਤ ਮੰਨਿਆ ਜਾਣਾ ਚਾਹੀਦਾ ਹੈ। ਜਰੂਰੀ ਜਾਣਕਾਰੀ ਲਈ, ਪ੍ਰੋਫੈਸ਼ਨਲ ਮਨੁੱਖੀ ਅਨੁਵਾਦ ਦੀ ਸਿਫਾਰਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ। ਇਸ ਅਨੁਵਾਦ ਦੇ ਇਸਤੇਮਾਲ ਨਾਲ ਹੋਣ ਵਾਲੀਆਂ ਕਿਸੇ ਵੀ ਗਲਤਫਹਮੀਆਂ ਜਾਂ ਭੂਲਾਂ ਲਈ ਅਸੀਂ ਜਵਾਬਦੇਹ ਨਹੀਂ ਹਾਂ।
<!-- CO-OP TRANSLATOR DISCLAIMER END -->