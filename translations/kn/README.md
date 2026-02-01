# ಅಧೀನಾದಾಯಕ AI ಆರಂಭಿಕರಿಗಾಗಿ - ಜಾವಾ ಆವೃತ್ತಿ
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/kn/beg-genai-series.8b48be9951cc574c.webp)

**ಸಮಯ ಬದ್ಧತೆ**: ಪೂರ್ಣ ಕಾರ್ಯಾಗಾರವನ್ನು ಸ್ಥಳೀಯ ಸಿದ್ಧತೆಯಿಲ್ಲದೆ ಆನ್‌ಲೈನ್‌ನಲ್ಲಿ ಪೂರ್ಣಗೊಳಿಸಬಹುದು. ಪರಿಸರ ಸ್ಥಾಪನೆ 2 ನಿಮಿಷ ತೆಗೆದುಕೊಳ್ಳುತ್ತದೆ, ಉದಾಹರಣೆಗಳನ್ನು ಅನ್ವೇಷಿಸುವುದಕ್ಕೆ 1-3 ಗಂಟೆಗಳವರೆಗೆ ಅನ್ವೇಷಣೆಯ ಆಳಿಕೆಗಾಗಿ ಅವಶ್ಯಕತೆ ಇದೆ.

> **ತ್ವರಿತ ಪ್ರಾರಂಭ**

1. ಈ ಸಂಗ್ರಹಾಲಯವನ್ನು ನಿಮ್ಮ GitHub ಖಾತೆಗೆ Fork ಮಾಡಿ
2. **Code** → **Codespaces** ಟ್ಯಾಬ್ → **...** → **ಹೊಸ ಆಯ್ಕೆಗಳು...** ಕ್ಲಿಕ್ ಮಾಡಿ
3. ಡಿಫಾಲ್ಟ್​ಗಳನ್ನು ಬಳಸಿ – ಇದು ಈ ಕೋರ್ಸ್‌ಗಾಗಿ ರಚಿಸಲಾದ ಡೆವಲಪ್‌ಮೆಂಟ್ ಕಂಟೈನರ್ ಆಯ್ಕೆಮಾಡುತ್ತದೆ
4. **Create codespace** ಕ್ಲಿಕ್ ಮಾಡಿ
5. ಪರಿಸರ ಸಿದ್ಧವಾಗುವಂತೆ ~2 ನಿಮಿಷ ಕಾಯಿರಿ
6. ನೇರವಾಗಿ [ಮೂದಲ ಉದಾಹರಣೆ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) ಗೆ ಹಾರಿರಿ

> **ಸ್ಥಳೀಯವಾಗಿ ಕ್ಲೋನ್ ಮಾಡಲು ಇಚ್ಛಿಸುವಿರಾ?**  
> ಈ ಸಂಗ್ರಹಾಲಯದಲ್ಲಿ 50+ ಭಾಷಾ ಅನುವಾದಗಳು ಸೇರಿವೆ, ಇದು ಡೌನ್ಲೋಡ್ ಗಾತ್ರವನ್ನು ಬಹಳ ಹೆಚ್ಚಿಸುತ್ತದೆ. ಅನುವಾದಗಳಿಲ್ಲದೆ ಕ್ಲೋನ್ ಮಾಡಲು sparse checkout ಅನ್ನು ಬಳಸಿ:  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ಇದರಿಂದ ನೀವು ಕೋರ್ಸ್ ಪೂರ್ಣಗೊಳಿಸಲು ಅಗತ್ಯವಿರುವ ಎಲ್ಲವುಗಳನ್ನು ವೇಗವಾಗಿ ಡೌನ್ಲೋಡ್ ಮಾಡಬಹುದು.

## ಬಹುಭಾಷಾ ಬೆಂಬಲ

### GitHub ಆಕ್ಷನ್ ಮೂಲಕ ಬೆಂಬಲಿತ (ಸ್ವಯಂಚಾಲಿತ ಮತ್ತು ಯಾವಾಗಲೂ ನವೀಕೃತ)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[ಅರೆಬಿಕ್](../ar/README.md) | [ಬಂಗಾಳಿ](../bn/README.md) | [ಬಲ್ಗೇರಿಯನ್](../bg/README.md) | [ಬಹ್ಮೀಸ್ (ಮಿಯಾನ್ಮಾರ್)](../my/README.md) | [ಚೈನೀಸ್ (ಸರಳೀಕೃತ)](../zh-CN/README.md) | [ಚೈನೀಸ್ (ಪಾರಂಪರಿಕ, ಹಾಂಗ್ ಕಾಂಗ್)](../zh-HK/README.md) | [ಚೈನೀಸ್ (ಪಾರಂಪರಿಕ, ಮಾಕಾವ್)](../zh-MO/README.md) | [ಚೈನೀಸ್ (ಪಾರಂಪರಿಕ, ತೈವಾನ್)](../zh-TW/README.md) | [ಕ್ರೋಯೇಷಿಯನ್](../hr/README.md) | [ಚೆಕ್](../cs/README.md) | [ಡೆನಿಶ್](../da/README.md) | [ಡಚ್](../nl/README.md) | [ಎಸ್ಟೋನಿಯನ್](../et/README.md) | [ಫಿನ್ನಿಷ್](../fi/README.md) | [ಫ್ರೆಂಚ್](../fr/README.md) | [ಜರ್ಮನ್](../de/README.md) | [ಗ್ರೀಕ್](../el/README.md) | [ಹಿಬ್ರೂ](../he/README.md) | [ಹಿಂದಿ](../hi/README.md) | [ಹಂಗೇರಿಯನ್](../hu/README.md) | [ಇಂಡೋನೇಷಿಯನ್](../id/README.md) | [ಇಟಾಲಿಯನ್](../it/README.md) | [ಜಪಾನೀಸ್](../ja/README.md) | [ಕನ್ನಡ](./README.md) | [ಕೋರಿಯನ್](../ko/README.md) | [ಲಿಥುವೇನಿಯನ್](../lt/README.md) | [ಮಲಯ್](../ms/README.md) | [ಮಲಯಾಳಂ](../ml/README.md) | [ಮರಾಠಿ](../mr/README.md) | [ನೆಪಾಳಿ](../ne/README.md) | [ನೈಜೀರಿಯನ್ ಪಿಡ್ಜಿನ್](../pcm/README.md) | [ನಾರ್ವೇಶಿಯನ್](../no/README.md) | [ಪರ್ಸಿಯನ್ (ಫಾರ್ಸಿ)](../fa/README.md) | [ಪೋಲಿಷ್](../pl/README.md) | [ಪೋರ್ಚುಗೀಸ್ (ಬ್ರೆಜಿಲ್)](../pt-BR/README.md) | [ಪೋರ್ಚುಗೀಸ್ (ಪೋರ್ಚುಗಲ್)](../pt-PT/README.md) | [ಪಂಜಾಬಿ (ಗುರ್ಮುಖ್ಯಿ)](../pa/README.md) | [ರೊಮೇನಿಯನ್](../ro/README.md) | [ರಶಿಯನ್](../ru/README.md) | [ಸರ್ಬಿಯನ್ (ಸirillic)](../sr/README.md) | [ಸ್ಲೋವಾಕ್](../sk/README.md) | [ಸ್ಲೋವೇನಿಯನ್](../sl/README.md) | [ಸ್ಪ್ಯಾನಿಷ್](../es/README.md) | [ಸ್ವಾಹಿಲಿ](../sw/README.md) | [ಸ್ವೀಡಿಷ್](../sv/README.md) | [ತಗಾಲೋಗ್ (ಫಿಲಿಪಿನೋ)](../tl/README.md) | [ತಮಿಳು](../ta/README.md) | [ತೆಲುಗು](../te/README.md) | [ಥಾಯ್](../th/README.md) | [ಟರ್ಕಿಶ್](../tr/README.md) | [ಉಕ್ರೇನಿಯನ್](../uk/README.md) | [ಉರ್ದು](../ur/README.md) | [ವಿಯೆಟ್ನಾಮೀಸ್](../vi/README.md)

## ಕೋರ್ಸ್ ರಚನೆ ಮತ್ತು ಅಧ್ಯಯನ ಮಾರ್ಗ

### **ಅಧ್ಯಾಯ 1: ಜನರೇಟಿವ್ AI ಗೆ ಪರಿಚಯ**
- **ಪ್ರধান ಸಂಪ್ರದಾಯಗಳು**: ದೊಡ್ಡ ಭಾಷಾ ಮಾದರಿಗಳನ್ನು, ಟೋಕನ್ಗಳು, ಉರೀಚೆಗಳು, ಮತ್ತು AI ಸಾಮರ್ಥ್ಯಗಳನ್ನು ಅರ್ಥಮಾಡಿಕೊಳ್ಳುವುದು
- **ಜಾವಾ AI ಪರಿಸರ**: ಸ್ಪ್ರಿಂಗ್ AI ಮತ್ತು OpenAI SDKಗಳ ಅವಲೋಕನ
- **ಮಾದರಿ సందర్భ ಪ್ರೋಟೋಕಾಲ್**: MCPಗೆ ಪರಿಚಯ ಮತ್ತು AI ಏಜೆಂಟ್ ಸಂವಹನದಲ್ಲಿ ಅದರ ಪಾತ್ರ
- **ಪ್ರಾಯೋಗಿಕ ಅನ್ವಯಿಕೆಗಳು**: ಚಾಟ್‌ಬೋಟ್ಗಳು ಮತ್ತು ವಿಷಯ ರಚನೆಯಂತಹ ನೈಜ-ಲೋಕದ ದೃಶ್ಯಗಳನ್ನು ಒಳಗೊಂಡಂತೆ
- **[→ ಅಧ್ಯಾಯ 1 ಪ್ರಾರಂಭಿಸಿ](./01-IntroToGenAI/README.md)**

### **ಅಧ್ಯಾಯ 2: ಅಭಿವೃದ್ಧಿ ಪರಿಸರ ಸ್ಥಾಪನೆ**
- **ಬಹು-ಪ್ರದಾತ ಕಾಂಫಿಗರೇಶನ್**: GitHub ಮಾದರಿಗಳು, Azure OpenAI, ಮತ್ತು OpenAI ಜಾವಾ SDK ಸಂಯೋಜನೆಗಳನ್ನು ಸ್ಥಾಪಿಸು
- **ಸ್ಪ್ರಿಂಗ್ ಬುಟ್ + ಸ್ಪ್ರಿಂಗ್ AI**: ಉದ್ಯಮ AI ಅಪ್ಲಿಕೇಶನ್ ಅಭಿವೃದ್ಧಿಗೆ ಉತ್ತಮ ಅಭ್ಯಾಸಗಳು
- **GitHub ಮಾದರಿಗಳು**: ಪ್ರೋಟೋಟೈಪಿಂಗ್ ಮತ್ತು ಅಧ್ಯಯನಕ್ಕೆ ಉಚಿತ AI ಮಾದರಿ ಪ್ರವೇಶ (ವಿಶ್ವಾಸಪತ್ರ ಕಾರ್ಡ್ ಅಗತ್ಯವಿಲ್ಲ)
- **ಅಭಿವೃದ್ಧಿ ಉಪಕರಣಗಳು**: ಡಾಕರ್ ಕಂಟೈನರ್ಗಳು, VS ಕೋಡ್, ಮತ್ತು GitHub ಕೋಡ್‌ಸ್ಪೇಸ್‌ಗಳ ಸಂರಚನೆ
- **[→ ಅಧ್ಯಾಯ 2 ಪ್ರಾರಂಭಿಸಿ](./02-SetupDevEnvironment/README.md)**

### **ಅಧ್ಯಾಯ 3: ಪ್ರಮುಖ ಜನರೇಟಿವ್ AI ತಂತ್ರಗಳು**
- **ಪ್ರಾಂಪ್ಟ್ ಎಂಜಿನಿಯರಿಂಗ್**: AI ಮಾದರಿ ಪ್ರತಿಕ್ರಿಯೆಗಳ ಗರಿಷ್ಠ ಪರಿಣಾಮಕಾರಿತ್ವಕ್ಕಾಗಿ ತಂತ್ರಗಳು
- **ಉರೀಚೆಗಳು ಮತ್ತು ವೆಕ್ಟರ್ ಕ್ರಿಯೆಗಳು**: ಅರ್ಥಾತ್ಮಕ ಹುಡುಕಾಟ ಮತ್ತು ಸಾದೃಶ್ಯ ಹೊಂದಾಣಿಕೆ ಅನುಷ್ಠಾನಗೊಳಿಸುವಿಕೆ
- **ರಿಟ್ರೀವಲ್-ಆಗ್ಮೆಂಟೆಡ್ ಜನರೇಷನ್ (RAG)**: ನಿಮ್ಮ ಸ್ವಂತ ಡೇಟಾ ಮೂಲಗಳೊಂದಿಗೆ AI ಅನ್ನು ಸಂಯೋಜಿಸಿ
- **ಫಂಕ್ಷನ್ ಕಾಲಿಂಗ್**: ಕಸ್ಟಮ್ ಟೂಲ್ಸ್ ಮತ್ತು ಪ್ಲಗಿನ್‌ಗಳೊಂದಿಗೆ AI ಸಾಮರ್ಥ್ಯ ವಿಸ್ತರಣೆ
- **[→ ಅಧ್ಯಾಯ 3 ಪ್ರಾರಂಭಿಸಿ](./03-CoreGenerativeAITechniques/README.md)**

### **ಅಧ್ಯಾಯ 4: ಪ್ರಾಯೋಗಿಕ ಅನ್ವಯಿಕೆಗಳು ಮತ್ತು ಯೋಜನೆಗಳು**
- **ಪೇಟ್ ಸ್ಟೋರಿ ಜನರೇಟರ್** (`petstory/`): GitHub ಮಾದರಿಗಳೊಂದಿಗೆ ಸೃಜನಶೀಲ ವಿಷಯ ನಿರ್ಮಾಣ
- **ಫೌಂಡ್ರಿ ಸ್ಥಳೀಯ ಡೆಮೋ** (`foundrylocal/`): OpenAI ಜಾವಾ SDK ಸಹಿತ ಸ್ಥಳೀಯ AI ಮಾದರಿ ಸಂಯೋಜನೆ
- **MCP ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಸರ್ವಿಸ್** (`calculator/`): ಸ್ಪ್ರಿಂಗ್ AI ಸಹಿತ ಮೂಲ Model Context Protocol ಅನುಷ್ಠಾನ
- **[→ ಅಧ್ಯಾಯ 4 ಪ್ರಾರಂಭಿಸಿ](./04-PracticalSamples/README.md)**

### **ಅಧ್ಯಾಯ 5: ಜವಾಬ್ದಾರಿ AI ಅಭಿವೃದ್ಧಿ**
- **GitHub ಮಾದರಿಗಳ ಸುರಕ್ಷತೆ**: ಕಟ್ಟಳೆ ಬ್ಲಾಕ್ ಮತ್ತು ಹಗುರ ನಿರಾಕರಣೆಗಳನ್ನು ಒಳಗೊಂಡ ಗುಣಮಟ್ಟದ ಒಳಗಿನ ವಿಷಯದ ಫಿಲ್ಟರಿಂಗ್ ಮತ್ತು ಸುರಕ್ಷತಾ ವ್ಯವಸ್ಥೆಗಳ ಪರೀಕ್ಷೆ
- **ಜವಾಬ್ದಾರಿ AI ಡೆಮೋ**: ಆಧುನಿಕ AI ಸುರಕ್ಷತಾ ವ್ಯವಸ್ಥೆಗಳು ಪ್ರಾಯೋಗಿಕವಾಗಿ ಹೇಗೆ ಕಾರ್ಯನಿರ್ವಹಿಸುತ್ತವೆ ಎಂಬುದರ ಕೈಗೆಟ್ ಉದಾಹರಣೆ
- **ಉತ್ತಮ ಅಭ್ಯಾಸಗಳು**: ನೈತಿಕ AI ಅಭಿವೃದ್ಧಿ ಮತ್ತು ನಿಯೋಜನೆಗೆ ಪ್ರಮುಖ ಮಾರ್ಗಸೂಚಿಗಳು
- **[→ ಅಧ್ಯಾಯ 5 ಪ್ರಾರಂಭಿಸಿ](./05-ResponsibleGenAI/README.md)**

## ಹೆಚ್ಚುವರಿ ಸಂಪನ್ಮೂಲಗಳು

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### ಲಾಂಗ್‌ಚೇನ್  
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)  
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### ಅಜೂರ್ / ಎಡ್ಜ್ / MCP / ಏಜೆಂಟ್‌ಗಳು  
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### ಜನರೇಟಿವ್ AI ಸರಣಿಗಳು  
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)  
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)  
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---

### ಮೂಲ ಅಧ್ಯಯನ  
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)  
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)  
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)  
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)  
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![ಐಒಟಿ ಶುರೂವಾಗಿರುವವರಿಗೆ](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![ಎಕ್ಸ್ಆರ್ ಅಭಿವೃದ್ಧಿ ಶುರೂವಾಗಿರುವವರಿಗೆ](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### ಕೋಪೈಲಟ್ ಸರಣಿ
[![ಐಎಐ ಜೋಡಿಸಿದ್ದ ಪ್ರೋಗ್ರಾಮಿಂಗ್‌ಗೆ ಕೋಪೈಲಟ್](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![ಸಿ#/.ನೆಟ್‌ಗೆ ಕೋಪೈಲಟ್](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![ಕೋಪೈಲಟ್ ಸಾಹಸ](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## ಸಹಾಯ ಪಡೆಯುವುದು

ನೀವು ಅಡಚಣೆಯಲ್ಲಿ ಇದ್ದರೆ ಅಥವಾ AI ಅಪ್ಲಿಕೇಶನ್‌ಗಳನ್ನು ನಿರ್ಮಿಸುವ ಬಗ್ಗೆ ಯಾವುದೇ ಪ್ರಶ್ನೆಗಳಿದ್ದರೆ, MCP ಬಗ್ಗೆ ಚರ್ಚೆಗಳಲ್ಲಿ ಸಹಭಾಗಿಗಳೆ ಮತ್ತು ಅನುಭವಿಗಳೊಂದಿಗೆ ಸೇರಿ. ಇದು ಪ್ರಶ್ನೆಗಳಿಗೆ ಸ್ವಾಗತ ಹಾಗೂ ಜ್ಞಾನವನ್ನು ಮುಕ್ತವಾಗಿ ಹಂಚಿಕೊಳ್ಳುವ ಸಹಾಯಕ ಸಮುದಾಯವಾಗಿದೆ.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

ನೀವು ಉತ್ಪನ್ನ ಪ್ರತಿಕ್ರಿಯೆ ಅಥವಾ ದೋಷಗಳನ್ನು ಹೊಂದಿದ್ದರೆ ಬಿಲ್ಡಿಂಗ್ ಮಾಡುತ್ತಿರುವ ಸಮಯದಲ್ಲಿ ಭೇಟಿ ನೀಡಿರಿ:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ತ್ಯಾಜ್ಯ ಘೋಷಣೆ**:  
ಈ ದಸ್ತಾವೇಜು AI ಅನುವಾದ ಸೇವೆ [Co-op Translator](https://github.com/Azure/co-op-translator) ಬಳಸಿಕೊಂಡು ಅನುವಾದಿಸಲಾಗಿದ್ದು, ನಿಖರತೆಗಾಗಿ ನಾವು ಪ್ರಯತ್ನಿಸುತ್ತಿದ್ದರೂ ಸಹ ಸ್ವಯಂಚಾಲಿತ ಅನುವಾದದಲ್ಲಿ ತಪ್ಪುಗಳು ಅಥವಾ ಅಸತ್ಯತೆಗಳು ಇರಬಹುದು. ಮೂಲ ದಸ್ತಾವೇಜಿನ ಮೂಲಭಾಷೆ ಶುದ್ಧ ಮತ್ತು ಅಧಿಕೃತ ಮಾಧ್ಯಮ ಎಂದು ಪರಿಗಣಿಸಬೇಕು. ಪ್ರಮುಖ ಮಾಹಿತಿಗಾಗಿ, ವೃತ್ತಿಪರ ಮಾನವ ಅನುವಾದವನ್ನು ಸಲಹೆ ಮಾಡಲಾಗುತ್ತದೆ. ಈ ಅನುವಾದ ಬಳಕೆಯಿಂದ ಉಂಟಾಗುವ ಯಾವುದೇ ಅನರ್ಥಕหมายಗಳು ಅಥವಾ ವ್ಯಾಖ್ಯಾನಗಳಲ್ಲಿ ನಾವು ಜವಾಬ್ದಾರಿಯಾಗಿಲ್ಲ.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->