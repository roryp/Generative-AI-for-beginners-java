# ಪ್ರಾರಂಭಿಕರಿಗೆ ಜನರೇಟಿವ್ AI - ಜಾವಾ ಆವೃತ್ತಿ
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/kn/beg-genai-series.8b48be9951cc574c.webp)

**ಸಮಯ ಬದ್ಧತೆ**: ಸಂಪೂರ್ಣ ಕಾರ್ಯಾಗಾರವನ್ನು ಸ್ಥಳೀಯ ಸೆಟ್‌ಅಪ್ ಇಲ್ಲದೆ ಆನ್‌ಲೈನ್‌ನಲ್ಲಿ ಪೂರ್ಣಗೊಳಿಸಬಹುದು. ಪರಿಸರ ಸೆಟ್‌ಅಪ್‌ಗೆ 2 ನಿಮಿಷಗಳು ಬೇಕಾಗುತ್ತದೆ, ಮತ್ತು ಮಾದರಿಗಳನ್ನು ಅನ್ವೇಷಿಸಲು 1-3 ಗಂಟೆಗಳ ತನಕ ಪೊಲೀಸರು ಅವಲಂಬಿಸಿ ಹೋದುತ್ತದೆ.

> **ವೇಗದ ಪ್ರಾರಂಭ**

1. ಈ ರೆಪೊಸಿಟೋರಿಯನ್ನು ನಿಮ್ಮ GitHub ಖಾತೆಗೆ ಫೋರ್ಕ್ ಮಾಡಿ
2. **Code** → **Codespaces** ಟ್ಯಾಬ್ → **...** → **New with options...** ಕ್ಲಿಕ್ ಮಾಡಿ
3. ಡೀಫಾಲ್ಟ್ ಆಯ್ಕೆಗಳನ್ನು ಬಳಸಿ – ಇದರಿಂದ ಈ ಕೋರ್ಸ್‌ಗಾಗಿ ರಚಿಸಲಾಗಿರುವ ಡೆವಲಪ್‌ಮೆಂಟ್ ಕಂಟೇನರ್ ಆಯ್ಕೆ ಆಗುತ್ತದೆ
4. **Create codespace** ಕ್ಲಿಕ್ ಮಾಡಿ
5. ಪರಿಸರ ತಯಾರಾಗಲು ಸುಮಾರು 2 ನಿಮಿಷ ಕಾಯಿರಿ
6. ನೇರವಾಗಿ [ಮೊದಲ ಉದಾಹರಣೆ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) ಗೆ ಹೋಗಿ

> **ಸ್ಥಳೀಯವಾಗಿ ಕ್ಲೋನ್ ಮಾಡಬೇಕೆ?**
>
> ಈ ರೆಪೊಸಿಟೋರಿಯಲ್ಲಿ 50+ ಭಾಷಾ ಅನುವಾದಗಳಿರುತ್ತವೆ, ಇದರಿಂದ ಡೌನ್‌ಲೋಡ್ ಗಾತ್ರ ಹೆಚ್ಚಾಗುತ್ತದೆ. ಅನುವಾದಗಳು ಇಲ್ಲದೆ ಕ್ಲೋನ್ ಮಾಡಲು sparse checkout ಬಳಸಿರಿ:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ಇದರಿಂದ ವೇಗವಾಗಿ ಡೌನ್‌ಲೋಡ್ ಆಗಿ ಕೋರ್ಸ್ ಪೂರ್ಣಗೊಳಿಸಲು ಬೇಕಾದ ಎಲ್ಲಾ ವಿಷಯಗಳು ಲಭ್ಯವೆಂದು ಖಚಿತವಾಗುತ್ತದೆ.

## ಬಹುಭಾಷಾ ಬೆಂಬಲ

### GitHub ಕಾರ್ಯಾಚರಣೆ (ಸ್ವಚಾಲಿತ ಮತ್ತು ಸದಾ ನವೀಕರಣವಾಗಿದೆ) ಮೂಲಕ ಬೆಂಬಲಿಸಲಾಗಿದೆ

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[ಅರಬಿಕ್](../ar/README.md) | [ಬೆಂಗಾಲಿ](../bn/README.md) | [ಬಲ್ಗೇರಿಯನ್](../bg/README.md) | [ಬರ್ಮೀಸ್ (ಮಯನ್ಮಾರ್)](../my/README.md) | [ಚೀನಿ (ಸರಳೀಕೃತ)](../zh-CN/README.md) | [ಚೀನಿ (ಸಾಂಪ್ರದಾಯಿಕ, ಹಾಂಗ್ ಕಾಂಗ್)](../zh-HK/README.md) | [ಚೀನಿ (ಸಾಂಪ್ರದಾಯಿಕ, ಮಕಾವು)](../zh-MO/README.md) | [ಚೀನಿ (ಸಾಂಪ್ರದಾಯಿಕ, ತೈವಾನ್)](../zh-TW/README.md) | [ಕ್ರೊಯೇಶಿಯನ್](../hr/README.md) | [ಸೆಕ್](../cs/README.md) | [ಡ್ಯಾನಿಷ್](../da/README.md) | [ಡಚ್](../nl/README.md) | [ಎಸ್ಟೋನಿಯನ್](../et/README.md) | [ಫಿನ್ನಿಷ್](../fi/README.md) | [ಫ್ರೆಂಚ್](../fr/README.md) | [ಜರ್ಮನ್](../de/README.md) | [ಗ್ರೀಕ್](../el/README.md) | [ಹೆಬ್ರೂ](../he/README.md) | [ಹಿಂದಿ](../hi/README.md) | [ಹಂಗೇರಿಯನ್](../hu/README.md) | [ಇಂಡೋನೀಷಿಯನ್](../id/README.md) | [ಇಟಾಲಿಯನ್](../it/README.md) | [ಜಪಾನೀಸ್](../ja/README.md) | [ಕನ್ನಡ](./README.md) | [ಕೊರಿಯನ್](../ko/README.md) | [ಲಿಥುವೇನಿಯನ್](../lt/README.md) | [ಮಲಯ್](../ms/README.md) | [ಮಲಯಾಳಂ](../ml/README.md) | [ಮರಾಠಿ](../mr/README.md) | [ನೇಪಾಳಿ](../ne/README.md) | [ನೈಜೀರೀಯನ್ ಪಿಡ್ಗಿನ್](../pcm/README.md) | [ನಾರ್ವೀಜಿಯನ್](../no/README.md) | [ಪರ್ಶನ್ಸ್ (ಫಾರ್ಸಿ)](../fa/README.md) | [ಪೋಲಿಷ್](../pl/README.md) | [ಪೋರ್ಟುಗೀಸ್ (ಬ್ರಾಜಿಲ್)](../pt-BR/README.md) | [ಪೋರ್ಟುಗೀಸ್ (ಪೋರ್ಟುಗಾಲ್)](../pt-PT/README.md) | [ಪಂಜಾಬಿ (ಗੁਰुमುಖಿ)](../pa/README.md) | [ರೊಮೇನಿಯನ್](../ro/README.md) | [ರಷ್ಯನ್](../ru/README.md) | [ಸರ್ಬಿಯನ್ (ಸಿರಿಲಿಕ್)](../sr/README.md) | [ಸ್ಲೋವಾಕ್](../sk/README.md) | [ಸ್ಲೋವೇನಿಯನ್](../sl/README.md) | [ಸ್ಪ್ಯಾನಿಷ್](../es/README.md) | [ಸ್ವಾಹಿಲಿ](../sw/README.md) | [ಸ್ವೀಡಿಶ್](../sv/README.md) | [ತಗಾಲೊಗ್ (ಫಿಲಿಪಿನೋ)](../tl/README.md) | [ತಮಿಳು](../ta/README.md) | [ತೆಲುಗು](../te/README.md) | [ಥಾಯಿ](../th/README.md) | [ತುರ್ಕಿಷ್](../tr/README.md) | [ಉಕ್ರೇನಿಯನ್](../uk/README.md) | [ಉರ್ದು](../ur/README.md) | [ವಿಯೆಟ್ನಾಮಿ](../vi/README.md)

> **ಸ್ಥಳೀಯವಾಗಿ ಕ್ಲೋನ್ ಮಾಡಬೇಕೆ?**

> ಈ ರೆಪೊಸಿಟೋರಿಯಲ್ಲಿ 50+ ಭಾಷಾ ಅನುವಾದಗಳಿರುತ್ತವೆ, ಇದರಿಂದ ಡೌನ್‌ಲೋಡ್ ಗಾತ್ರ ಹೆಚ್ಚಾಗುತ್ತದೆ. ಅನುವಾದಗಳು ಇಲ್ಲದೆ ಕ್ಲೋನ್ ಮಾಡಲು sparse checkout ಬಳಸಿರಿ:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ಇದರಿಂದ ವೇಗವಾಗಿ ಡೌನ್‌ಲೋಡ್ ಆಗಿ ಕೋರ್ಸ್ ಪೂರ್ಣಗೊಳಿಸಲು ಬೇಕಾದ ಎಲ್ಲಾ ವಿಷಯಗಳು ಲಭ್ಯವೆಂದು ಖಚಿತವಾಗುತ್ತದೆ.
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## ಕೋರ್ಸ್ ರಚನೆ ಮತ್ತು ಕಲಿಕೆ ಮಾರ್ಗ

### **ಅಧ್ಯಾಯ 1: ಜನರೇಟಿವ್ AI ಗೆ ಪರಿಚಯ**
- **ಮೂಲ ತತ್ವಗಳು**: ದೊಡ್ಡ ಭಾಷಾ ಮಾದರಿಗಳು, ಟೋಕನ್ಗಳು, ಎಂಬರ್‌ಡಿಂಗ್‌ಗಳು ಮತ್ತು AI ಸಾಮರ್ಥ್ಯಗಳನ್ನು ಅರ್ಥಮಾಡಿಕೊಳ್ಳುವುದು
- **ಜಾವಾ AI ಪರಿಸರ**: ಸ್ಪ್ರಿಂಗ್ AI ಮತ್ತು OpenAI SDK ಗಳ ಮಾದರಿಯ ಅವಲೋಕನ
- **ಮಾದರಿ ಸಂದರ್ಭ ಪ್ರೋಟೋಕಾಲ್**: MCP ಪರಿಚಯ ಮತ್ತು AI ಏಜೆಂಟ್ ಸಂವಹನದಲ್ಲಿ ಅದರ ಪಾತ್ರ
- **ವ್ಯವಹಾರಿಕ ಅನ್ವಯಗಳು**: ಚಾಟ್‌ಬಾಟ್‌ಗಳು ಮತ್ತು ವಿಷಯ ನಿರ್ಮಾಣ ಸೇರಿದಂತೆ ನೈಜ ಪ್ರಪಂಚದ ದೃಶ್ಯಗಳು
- **[→ ಅಧ್ಯಾಯ 1 ಪ್ರಾರಂಭಿಸಿ](./01-IntroToGenAI/README.md)**

### **ಅಧ್ಯಾಯ 2: ಅಭಿವೃದ್ಧಿ ಪರಿಸರ ಸೆಟ್‌ಅಪ್**
- **ಬಹು-ಪ್ರದಾನಗಾರ ಕಾನ್ಫಿಗರೇಶನ್**: GitHub Models, Azure OpenAI ಮತ್ತು OpenAI ಜಾವಾ SDK ಏಕರೂಪಗೊಳಿಸುವಿಕೆ
- **ಸ್ಪ್ರಿಂಗ್ ಬೂಟ್ + ಸ್ಪ್ರಿಂಗ್ AI**: ಉದ್ಯಮ AI ಆಪ್ ಅಭಿವೃದ್ಧಿಗಾಗಿ ಉತ್ತಮ ಅಭ್ಯಾಸಗಳು
- **GitHub Models**: ಪ್ರೋಟೋಟೈಪಿಂಗ್ ಮತ್ತು ಕಲಿಕೆಗೆ ಉಚಿತ AI ಮಾದರಿ ಪ್ರವೇಶ (ಕ್ರೆಡಿಟ್ ಕಾರ್ಡ್ ಅಗತ್ಯವಿಲ್ಲ)
- **ಅಭಿವೃದ್ಧಿ ಸಾಧನಗಳು**: ಡಾಕರ್ ಕಂಟೇನರ್‌ಗಳು, VS ಕೋಡ್ ಮತ್ತು GitHub Codespaces ಕಾನ್ಫಿಗರೇಶನ್
- **[→ ಅಧ್ಯಾಯ 2 ಪ್ರಾರಂಭಿಸಿ](./02-SetupDevEnvironment/README.md)**

### **ಅಧ್ಯಾಯ 3: ಮೂಲ ಜನರೇಟಿವ್ AI ತಂತ್ರಜ್ಞಾನಗಳು**
- **ಪ್ರಾಂಪ್ಟ್ ಎಂಜನಿಯರಿಂಗ್**: ಉತ್ತಮ AI ಮಾದರಿ ಪ್ರತಿಕ್ರಿಯೆಗಳ ತಂತ್ರಗಳು
- **ಎಂಬರ್‌ಡಿಂಗ್‌ಗಳು ಮತ್ತು ವೆಕ್ಟರ್ ಕಾರ್ಯಾಚರಣೆಗಳು**: ಅರ್ಥವಂತ ಹುಡುಕಾಟ ಮತ್ತು ಸಾದೃಶ್ಯ ಹೊಂದಾಣಿಕೆ
- **ರಿಟ್ರಿವಲ್-ಆಗ್ಮೆಂಟೆಡ್ ಜನರೇಶನ್ (RAG)**: ನಿಮ್ಮದೇ ಡೇಟಾ ಮೂಲಗಳೊಂದಿಗೆ AI ಸಂಯೋಜನೆ
- **ಫಂಕ್ಷನ್ ಕಾಲಿಂಗ್**: ಕಸ್ಟಮ್ ಸಾಧನಗಳು ಮತ್ತು ಪ್ಲಗಿನ್‌ಗಳೊಂದಿಗೆ AI ಸಾಮರ್ಥ್ಯ ವಿಸ್ತರಣೆ
- **[→ ಅಧ್ಯಾಯ 3 ಪ್ರಾರಂಭಿಸಿ](./03-CoreGenerativeAITechniques/README.md)**

### **ಅಧ್ಯಾಯ 4: ವ್ಯಾಪಾರಿಕ ಅನ್ವಯಗಳು ಮತ್ತು ಯೋಜನೆಗಳು**
- **ಪೆಟ್ ಸ್ಟೋರಿ ಜನರೇಟರ್** (`petstory/`): GitHub Models ಮೂಲಕ ಸೃಜನಾತ್ಮಕ ವಿಷಯ ನಿರ್ಮಾಣ
- **ಫೌಂಡ್ರಿ ಲೋಕಲ್ ಡೆಮೋ** (`foundrylocal/`): OpenAI ಜಾವಾ SDK ಜೊತೆಗೆ ಸ್ಥಳೀಯ AI ಮಾದರಿ ಏಕರೂಪಗೊಳಿಸುವಿಕೆ
- **MCP ಕ್ಯಾಲ್ಕ್ಯುಲೇಟರ್ ಸರ್ವಿಸ್** (`calculator/`): ಸ್ಪ್ರಿಂಗ್ AI ಜೊತೆಗೆ ಮೂಲ Model Context Protocol ಅನುಷ್ಠಾನ
- **[→ ಅಧ್ಯಾಯ 4 ಪ್ರಾರಂಭಿಸಿ](./04-PracticalSamples/README.md)**

### **ಅಧ್ಯಾಯ 5: ಹೊಣೆಗಾರ AI ಅಭಿವೃದ್ಧಿ**
- **GitHub Models ಸುರಕ್ಷತೆ**: ಒಳಗಿರುವ ವಿಷಯ ಶೋಧನೆ ಮತ್ತು ಸುರಕ್ಷತಾ ಯಂತ್ರಗಳನ್ನು ಪರೀಕ್ಷೆ (ಕಠಿಣ ತಡೆ ಮತ್ತು ಮೃದು ನಿರಾಕರಣೆಗಳು)
- **ಒತ್ತಾಯದ AI ಡೆಮೋ**: ಆಧುನಿಕ AI ಸುರಕ್ಷತಾ ವ್ಯವಸ್ಥೆಗಳು ಹೇಗೆ ಕೆಲಸ ಮಾಡುತ್ತವೆ ಎಂಬ ಲೈವ್ ಉದಾಹರಣೆ
- **ಅತ್ಯುತ್ತಮ ಅಭ್ಯಾಸಗಳು**: ನೈತಿಕ AI ಅಭಿವೃದ್ಧಿ ಮತ್ತು ನಿಯೋಜನೆಗಾಗಿ ಅಗತ್ಯ ಮಾರ್ಗದರ್ಶಕಗಳು
- **[→ ಅಧ್ಯಾಯ 5 ಪ್ರಾರಂಭಿಸಿ](./05-ResponsibleGenAI/README.md)**

## ಹೆಚ್ಚುವರಿ ಸಂಪನ್ಮೂಲಗಳು

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### ಲಾಂಗ್‌ಚೈನ್
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### ಅಜೂರ್ / ಎಡ್ಜ್ / MCP / ಏಜೆಂಟ್ಸ್
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### ಜನರೇಟಿವ್ AI ಸರಣಿ
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### ಮೂಲ ಕಲಿಕೆ
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)

[![ಸೂತ್ರಕಾರರಿಗೆ ವೆಬ್ ಡೆವ್](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![ಸೂತ್ರಕಾರರಿಗೆ ಇಂಟರ್ನೆಟ್ ಆಫ್ ಥಿಂಗ್ಸ್](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![ಸೂತ್ರಕಾರರಿಗೆ XR ಅಭಿವೃದ್ಧಿ](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### ಸಹ ಚಾಲಕರು ಸರಣಿ
[![ಕೃತ್ರಿಮ ಬುದ್ಧಿಮತ್ತೆ ಜೊತೆಯ ಪ್ರೋಗ್ರಾಮಿಂಗ್‌ಗಾಗಿ ಸಹ ಚಾಲಕ](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![C#/.NET ಗೆ ಸಹ ಚಾಲಕ](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![ಸಹ ಚಾಲಕರು ಸಾಹಸ](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## ಸಹಾಯ ಪಡೆಯುವುದು

ನೀವು ಅडकಿದಾಗ ಅಥವಾ AI ಅಪ್ಲಿಕೇಶನ್ಗಳು ನಿರ್ಮಿಸುವ ಬಗ್ಗೆ ಯಾವುದೇ ಪ್ರಶ್ನೆಗಳಿದ್ದರೆ. MCP ಕುರಿತು ಚರ್ಚೆಗಳಲ್ಲಿ ಸಹ ಕಲಿಯುವರು ಮತ್ತು ಅನುಭವ ಹೊಂದಿರುವ ಡೆವಲಪರ್‌ಗಳுடன் ಸೇರಿ. ಇದು ಬರವಣಿಗೆಯ ಒಪ್ಪಿಗೆಯ ಸಮುದಾಯವಾಗಿದ್ದು, ಪ್ರಶ್ನೆಗಳನ್ನು ಸ್ವಾಗತಿಸುತ್ತದೆ ಮತ್ತು ಜ್ಞಾನವನ್ನು ಮುಕ್ತವಾಗಿ ಹಂಚಿಕೊಳ್ಳಲಾಗುತ್ತದೆ.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

ನೀವು ಉತ್ಪನ್ನ ಪ್ರತಿಕ್ರಿಯೆ ಅಥವಾ ದೋಷಗಳನ್ನು ಹೊಂದಿದ್ದರೆ, ನಿರ್ಮಿಸುವಾಗ ಭೇಟಿ ನೀಡಿ:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ಹೆಚ್ಚಿನ ಮಾಹಿತಿ**:  
ಈ ಡಾಕ್ಯುಮೆಂಟ್ ಅನ್ನು AI ಭಾಷಾಂತರ ಸೇವೆ [Co-op Translator](https://github.com/Azure/co-op-translator) ಬಳಸಿಕೊಂಡು ಭಾಷಾಂತರಿಸಲಾಗಿದೆ. ನಾವು ಶುದ್ಧತೆಯನ್ನು ಉದ್ದೇಶಿಸುವುದಾದರೂ, ಸ್ವಯಂಕ್ರಿಯ ಭಾಷಾಂತರಗಳಲ್ಲಿ ದೋಷಗಳು ಅಥವಾ ಅಸತ್ಯತೆಗಳಿರಬಹುದು ಎಂದು ದಯವಿಟ್ಟು ಗಮನಿಸಿ. ಮೂಲ ಡಾಕ್ಯುಮೆಂಟ್ ಅದರ ಸ್ವದೇಶಿ ಭಾಷೆಯಲ್ಲಿ ಪ್ರಾಮಾಣಿಕ ಮೂಲವಾಗಿದ್ದು ಪರಿಗಣಿಸಬೇಕು. ಗಂಭೀರ ಮಾಹಿತಿಗಾಗಿ ವೃತ್ತಿಪರ ಮಾನವ ಭಾಷಾಂತರವನ್ನು ಶಿಫಾರಸು ಮಾಡಲಾಗುತ್ತದೆ. ಈ ಭಾಷಾಂತರ ಬಳಕೆಯಿಂದ ಉಂಟಾಗುವ ಯಾವುದೇ ತಪ್ಪುಅರ್ಥგಾರಿಕೆಗಳಿಗೆ ನಾವು ಜವಾಬ್ದಾರಿಯಾಗಿ ಇರಲ್ಲ.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->