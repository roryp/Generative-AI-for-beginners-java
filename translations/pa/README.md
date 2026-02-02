# ਜੇਨੇਰਟਿਵ ਏਆਈ ਫਾਰ ਬਿਗਿਨਰਜ਼ - ਜਾਵਾ ਸੰસ્કਰਨ
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/pa/beg-genai-series.8b48be9951cc574c.webp)

**ਸਮਾਂ ਬੱਸਤੀ**: ਸਾਥੀ ਵਰਕਸ਼ਾਪ ਨੂੰ ਸਥਾਨਕ ਸੈਟਅਪ ਤੋਂ ਬਿਨਾਂ ਆਨਲਾਈਨ ਪੂਰਾ ਕੀਤਾ ਜਾ ਸਕਦਾ ਹੈ। ਵਾਤਾਵਰਣ ਸੈਟਅਪ 2 ਮਿੰਟ ਲੈਂਦਾ ਹੈ, ਨਮੂਨੇ ਖੋਜਣ ਲਈ ਖੋਜ ਦੀ ਡੂੰਘਾਈ 'ਤੇ ਨਿਰਭਰ ਕਰਦੇ ਹੋਏ 1-3 ਘੰਟੇ ਲੱਗ ਸਕਦੇ ਹਨ।

> **ਤੁਰੰਤ ਸ਼ੁਰੂ ਕਰੋ**

1. ਆਪਣੇ GitHub ਖਾਤੇ ਲਈ ਇਸ ਰਿਪੋਜ਼ਟਰੀ ਨੂੰ ਫੋਰਕ ਕਰੋ
2. **Code** → **Codespaces** ਟੈਬ → **...** → **New with options...** 'ਤੇ ਕਲਿੱਕ ਕਰੋ
3. ਡੀਫਾਲਟ ਇਸਤੇਮਾਲ ਕਰੋ – ਇਹ ਇਸ ਕੋਰਸ ਲਈ ਬਣਾਇਆ ਗਿਆ ਵਿਕਾਸ ਕੰਟੇਨਰ ਚੁਣੇਗਾ
4. **Create codespace** ਤੇ ਕਲਿੱਕ ਕਰੋ
5. ਵਾਤਾਵਰਣ ਤਿਆਰ ਹੋਣ ਲਈ تقريباً 2 ਮਿੰਟ ਉਡੀਕ ਕਰੋ
6. ਸਿੱਧਾ [ਪਹਿਲਾ ਉਦਾਹਰਣ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) 'ਤੇ ਜਾਓ

> **ਸਥਾਨਕ ਕਲੋਨ ਕਰਨ ਦੀ ਇੱਛਾ ਹੈ?**
>
> ਇਸ ਰਿਪੋਜ਼ਟਰੀ ਵਿੱਚ 50+ ਭਾਸ਼ਾ ਅਨੁਵਾਦ ਸ਼ਾਮਲ ਹਨ ਜੋ ਡਾਊਨਲੋਡ ਸਾਈਜ਼ ਨੂੰ ਬਹੁਤ ਵਧਾ ਦਿੰਦੇ ਹਨ। ਬਿਨਾਂ ਅਨੁਵਾਦਾਂ ਦੇ ਕਲੋਨ ਕਰਨ ਲਈ, sparse checkout ਵਰਤੋਂ ਕਰੋ:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ਇਸ ਨਾਲ ਤੁਹਾਨੂੰ ਇੱਕ ਤੇਜ਼ ਡਾਊਨਲੋਡ ਨਾਲ ਕੋਰਸ ਪੂਰਾ ਕਰਨ ਲਈ ਸਾਰਾ ਕੁਝ ਮਿਲ ਜਾਵੇਗਾ।


## ਬਹੁ-ਭਾਸ਼ਾਈ ਸਹਾਇਤਾ

### GitHub ਐਕਸ਼ਨ ਰਾਹੀਂ ਸਹਾਇਤਾ (ਆਟੋਮੇਟਿਡ ਅਤੇ ਹਮੇਸ਼ਾ ਅਪ-ਟੂ-ਡੇਟ)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](../my/README.md) | [Chinese (Simplified)](../zh-CN/README.md) | [Chinese (Traditional, Hong Kong)](../zh-HK/README.md) | [Chinese (Traditional, Macau)](../zh-MO/README.md) | [Chinese (Traditional, Taiwan)](../zh-TW/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Kannada](../kn/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Malayalam](../ml/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Nigerian Pidgin](../pcm/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../pt-BR/README.md) | [Portuguese (Portugal)](../pt-PT/README.md) | [Punjabi (Gurmukhi)](./README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Telugu](../te/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)

## ਕੋਰਸ ਦੀ ਬਣਤਰ ਅਤੇ ਸਿੱਖਣ ਦਾ ਰਸਤਾ

### **ਧੜਾ 1: ਜੇਨੇਰਟਿਵ ਏਆਈ ਦਾ ਪਰਿਚਯ**
- **ਮੁੱਖ ਧਾਰਣਾਵਾਂ**: ਵੱਡੇ ਭਾਸ਼ਾ ਮਾਡਲਾਂ, ਟੋਕਨ, ਐਂਬੈਡਿੰਗਜ਼ ਅਤੇ ਏਆਈ ਦੀਆਂ ਸਮਰੱਥਾਵਾਂ ਨੂੰ ਸਮਝਣਾ
- **ਜਾਵਾ ਏਆਈ ਪਰਿਸਰ**: Spring AI ਅਤੇ OpenAI SDKs ਦਾ ਜਾਇਜ਼ਾ
- **ਮਾਡਲ ਸੰਦਰਭ ਪ੍ਰੋਟੋਕੋਲ**: MCP ਦਾ ਪਰਿਚਯ ਅਤੇ ਇਹ ਏਆਈ ਏਜੰਟ ਸੰਚਾਰ ਵਿੱਚ ਕਿਵੇਂ ਕੰਮ ਕਰਦਾ ਹੈ
- **ਵਿਆਵਹਾਰਿਕ ਲਾਗੂ ਕਰਨ**: ਚੈਟਬੋਟ ਅਤੇ ਸਮੱਗਰੀ ਪੈਦਾ ਕਰਨ ਸਮੇਤ ਹਕੀਕਤੀ ਜਗਤ ਦੇ ਦ੍ਰਿਸ਼
- **[→ ਧੜਾ 1 ਸ਼ੁਰੂ ਕਰੋ](./01-IntroToGenAI/README.md)**

### **ਧੜਾ 2: ਵਿਕਾਸ ਵਾਤਾਵਰਣ ਸੈਟਅਪ**
- **ਬਹੁ-ਪ੍ਰਦਾਤਾ ਸੰਰਚਨਾ**: GitHub ਮਾਡਲਾਂ, Azure OpenAI ਅਤੇ OpenAI ਜਾਵਾ SDK ਇਕੀਕਰਨ ਸੈਟਅਪ ਕਰੋ
- **Spring Boot + Spring AI**: ਏન્ટਰਪ੍ਰਾਈਜ਼ ਏਆਈ ਐਪਲੀਕੇਸ਼ਨ ਵਿਕਾਸ ਲਈ ਸ਼੍ਰੇਸ਼ਠ ਅਭਿਆਸ
- **GitHub ਮਾਡਲ**: ਪ੍ਰੋਟੋਟਾਈਪ ਅਤੇ ਸਿੱਖਣ ਲਈ ਮੁਫ਼ਤ ਏਆਈ ਮਾਡਲ ਪਹੁੰਚ (ਕੋਈ ਕਰੈਡਿਟ ਕਾਰਡ ਲੋੜੀਦਾ ਨਹੀਂ)
- **ਵਿਕਾਸ ਸੰਦ**: Docker ਕੰਟੇਨਰ, VS ਕੋਡ ਅਤੇ GitHub Codespaces ਕਨਫਿਗਰੇਸ਼ਨ
- **[→ ਧੜਾ 2 ਸ਼ੁਰੂ ਕਰੋ](./02-SetupDevEnvironment/README.md)**

### **ਧੜਾ 3: ਮੁੱਖ ਜੇਨੇਰਟਿਵ ਏਆਈ ਤਕਨੀਕਾਂ**
- **ਪ੍ਰੌਂਪਟ ਇੰਜੀਨੀਅਰਿੰਗ**: ਏਆਈ ਮਾਡਲ ਜਵਾਬਾਂ ਲਈ ਉੱਤਮ ਤਕਨੀਕਾਂ
- **ਐਂਬੈਡਿੰਗਜ਼ ਅਤੇ ਵੈਕਟਰ ਓਪਰੇਸ਼ਨ**: ਸੈਮਾਂਟਿਕ ਖੋਜ ਅਤੇ ਸਮਾਨਤਾ ਮੇਲ ਕਰਨਾ ਲਾਗੂ ਕਰੋ
- **ਰੀਟਰੀਵਲ-ਆਗਮੈਂਟਿਡ ਜੇਨੇਰੇਸ਼ਨ (RAG)**: ਆਪਣੀਆਂ ਡੇਟਾ ਸ્રੋਤਾਂ ਨਾਲ ਏਆਈ ਨੂੰ ਮਿਸ਼ਰਣ ਕਰੋ
- **ਫੰਕਸ਼ਨ ਕਾਲਿੰਗ**: ਕਸਟਮ ਸੰਦ ਅਤੇ ਪਲੱਗਇਨਾਂ ਨਾਲ ਏਆਈ ਸਮਾਰਥਿਆਂ ਨੂੰ ਵਧਾਓ
- **[→ ਧੜਾ 3 ਸ਼ੁਰੂ ਕਰੋ](./03-CoreGenerativeAITechniques/README.md)**

### **ਧੜਾ 4: ਵਿਆਵਹਾਰਿਕ ਲਾਗੂ ਕਰਨ ਅਤੇ ਪ੍ਰੋਜੈਕਟ**
- **ਪੈਟ ਸਟੋਰੀ ਜੇਨੇਰੇਟਰ** (`petstory/`): GitHub ਮਾਡਲ ਨਾਲ ਰਚਨਾਤਮਕ ਸਮੱਗਰੀ ਪੈਦਾ ਕਰਨ
- **ਫਾਉਂਡਰੀ ਲੋਕਲ ਡੈਮੋ** (`foundrylocal/`): OpenAI ਜਾਵਾ SDK ਨਾਲ ਸਥਾਨਕ ਏਆਈ ਮਾਡਲ ਇਕੀਕਰਨ
- **MCP ਕੈਲਕुलेਟਰ ਸੇਵਾ** (`calculator/`): Spring AI ਨਾਲ ਬੁਨਿਆਦੀ ਮਾਡਲ ਸੰਦਰਭ ਪ੍ਰੋਟੋਕੋਲ ਲਾਗੂ ਕਰਨਾ
- **[→ ਧੜਾ 4 ਸ਼ੁਰੂ ਕਰੋ](./04-PracticalSamples/README.md)**

### **ਧੜਾ 5: ਜ਼ਿੰਮੇਵਾਰ ਏਆਈ ਵਿਕਾਸ**
- **GitHub ਮਾਡਲਾਂ ਦੀ ਸੁਰੱਖਿਆ**: ਡਿਫਾਲਟ ਸਮੱਗਰੀ ਫਿਲਟਰਿੰਗ ਅਤੇ ਸੁਰੱਖਿਆ ਯੰਤਰ (ਹਾਰਡ ਬਲਾਕ ਅਤੇ ਸੌਫਟ ਇਨਕਾਰ) ਦੀ ਜਾਂਚ ਕਰੋ
- **ਜ਼ਿੰਮੇਵਾਰ ਏਆਈ ਡੈਮੋ**: ਹਥੀਂ-ਤਰ੍ਹਾਂ ਦਾ ਉਦਾਹਰਣ ਜੋ ਵੇਖਾਉਂਦਾ ਹੈ ਕਿ ਆਧੁਨਿਕ ਏਆਈ ਸੁਰੱਖਿਆ ਪਰਣਾਲੀਆਂ ਕਿਵੇਂ ਕੰਮ ਕਰਦੀਆਂ ਹਨ
- **ਸ਼੍ਰੇਸ਼ਠ ਅਭਿਆਸ**: ਨੈਤਿਕ ਏਆਈ ਵਿਕਾਸ ਅਤੇ ਤਾਇਨਾਤੀ ਲਈ ਜ਼ਰੂਰੀ ਦਿਸ਼ਾ-ਨਿਰਦੇਸ਼
- **[→ ਧੜਾ 5 ਸ਼ੁਰੂ ਕਰੋ](./05-ResponsibleGenAI/README.md)**

## ਵਾਧੂ ਸਰੋਤ

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### ਲੈਂਗਚੇਨ
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### Azure / Edge / MCP / ਏਜੰਟ
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### ਜੇਨੇਰਟਿਵ ਏਆਈ ਸੀਰੀਜ਼
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### ਮੂਲ ਸਿੱਖਿਆ
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![ਬਿਗਿਨਰਾਂ ਲਈ IoT](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![ਬਿਗਿਨਰਾਂ ਲਈ XR ਵਿਕਾਸ](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### ਕੋਪਾਇਲਟ ਸੀਰੀਜ਼
[![AI ਜੋੜੀ ਦਾਰ ਪ੍ਰੋਗ੍ਰਾਮਿੰਗ ਲਈ ਕੋਪਾਇਲਟ](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![C#/.NET ਲਈ ਕੋਪਾਇਲਟ](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![ਕਾਪਾਇਲਟ ਅਡਵੈਂਚਰ](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## ਸਹਾਇਤਾ ਪ੍ਰਾਪਤ ਕਰੋ

ਜੇ ਤੁਸੀਂ ਫਸ ਗਏ ਹੋ ਜਾਂ AI ਐਪ ਬਣਾਉਣ ਬਾਰੇ ਕੋਈ ਸਵਾਲ ਹਨ। ਐਮਸੀਪੀ ਬਾਰੇ ਚਰਚਾਵਾਂ ਵਿੱਚ ਸਾਥੀ ਸਿੱਖਣ ਵਾਲੇ ਅਤੇ ਅਨੁਭਵੀ ਡਿਵੈਲਪਰਾਂ ਨਾਲ ਜੁੜੋ। ਇਹ ਇੱਕ ਸਹਾਇਕ ਕਮਿਊਨਿਟੀ ਹੈ ਜਿੱਥੇ ਸਵਾਲਾਂ ਦਾ ਸੁਆਗਤ ਕੀਤਾ ਜਾਂਦਾ ਹੈ ਅਤੇ ਗਿਆਨ ਖੁੱਲ੍ਹੇ ਤੌਰ 'ਤੇ ਵੰਡਿਆ ਜਾਂਦਾ ਹੈ।

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

ਜੇ ਤੁਹਾਨੂੰ ਉਤਪਾਦ ਸਬੰਧੀ ਪ੍ਰਤੀਕਿਰਿਆ ਜਾਂ ਤਿਆਰ ਕਰਦਿਆਂ ਗਲਤੀਆਂ ਮਿਲਦੀਆਂ ਹਨ ਤਾਂ:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ਨਿਰਾਸ਼ਾ**:  
ਇਹ ਦਸਤਾਵੇਜ਼ ਏਆਈ ਅਨੁਵਾਦ ਸੇਵਾ [Co-op Translator](https://github.com/Azure/co-op-translator) ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਅਨੁਵਾਦਿਤ ਕੀਤਾ ਗਿਆ ਹੈ। ਜਦੋਂ ਕਿ ਅਸੀਂ ਸ਼ੁੱਧਤਾ ਲਈ ਕੋਸ਼ਿਸ਼ ਕਰਦੇ ਹਾਂ, ਕਿਰਪਾ ਕਰਕੇ ਧਿਆਨ ਦੇਵੋ ਕਿ ਸਵੈਚਲਿਤ ਅਨੁਵਾਦ ਵਿੱਚ ਗਲਤੀਆਂ ਜਾਂ ਅਸਮਰੱਥਾਵਾਂ ਹੋ ਸਕਦੀਆਂ ਹਨ। ਮੂਲ ਦਸਤਾਵੇਜ਼ ਆਪਣੀ ਮੂਲ ਭਾਸ਼ਾ ਵਿੱਚ ਹੀ ਅਧਿਕਾਰਤ ਸਰੋਤ ਮੰਨਿਆ ਜਾਣਾ ਚਾਹੀਦਾ ਹੈ। ਜਰੂਰੀ ਜਾਣਕਾਰੀ ਲਈ, ਪੇਸ਼ਾਵਰ ਮਨੁੱਖੀ ਅਨੁਵਾਦ ਦੀ ਸਿਫਾਰਿਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ। ਅਸੀਂ ਇਸ ਅਨੁਵਾਦ ਦੇ ਇਸਤੇਮਾਲ ਤੋਂ ਪੈਦਾ ਹੋਣ ਵਾਲੀਆਂ ਕਿਸੇ ਵੀ ਗਲਤਫਹਿਮੀਆਂ ਜਾਂ ਗਲਤ ਵਿਆਖਿਆਵਾਂ ਲਈ ਜ਼ਿੰਮੇਵਾਰ ਨਹੀਂ ਹਾਂ।
<!-- CO-OP TRANSLATOR DISCLAIMER END -->