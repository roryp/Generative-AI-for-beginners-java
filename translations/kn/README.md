# ಪ್ರಾರಂಭಿಕರಿಗಾಗಿ ಜನರೇಟಿವ್ ಎಐ - ಜಾವಾ ಆವೃತ್ತಿ
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![ಪ್ರಾರಂಭಿಕರಿಗಾಗಿ ಜನರೇಟಿವ್ ಎಐ - ಜಾವಾ ಆವೃತ್ತಿ](../../translated_images/kn/beg-genai-series.8b48be9951cc574c.webp)

**ಸಮಯ ಬದ್ಧತೆ**: ಸಂಪೂರ್ಣ ಕಾರ್ಯಾಗಾರವನ್ನು ಆನ್‌ಲೈನ್‌ನಲ್ಲಿ ಯಾವುದೇ ಸ್ಥಳೀಯ ಸೆಟ್‌ಅಪ್ ಅಗತ್ಯವಿಲ್ಲದೆ ಪೂರ್ಣಗೊಳಿಸಬಹುದು. ಪರಿಸರ ಸೆಟ್‌ಅಪ್ 2 ನಿಮಿಷಗಳನ್ನು ತೆಗೆದುಕೊಳ್ಳುತ್ತದೆ, ಮತ್ತು ಮಾದರಿಗಳನ್ನು ಅನ್ವೇಷಿಸಲು 1-3 ಘಂಟೆಗಳಷ್ಟು ಸಮಯ ಬೇಕಾಗಬಹುದು, ಅನ್ವೇಷಣೆಯ ಆಳದ ಮೇಲಷ್ಟಾಗಿ ಅವಲಂಬಿಸುತ್ತದೆ.

> **ವೇಗದ ಪ್ರಾರಂಭ** 

1. ಈ ಸಂಗ್ರಹಾಲಯವನ್ನು ನಿಮ್ಮ GitHub ಖಾತೆಗೆ ಫೋರ್ಕ್ ಮಾಡಿ
2. ಕ್ಲಿಕ್ ಮಾಡಿ **Code** → **Codespaces** ಟ್ಯಾಬ್ → **...** → **New with options...**
3. ಪೂರ್ವನಿಯೋಜಿತಗಳನ್ನು ಬಳಸಿಕೊಳ್ಳಿ – ಇದು ಈ 코ರ್ಸಿಗಾಗಿ ರಚಿಸಲಾಗಿರುವ ಡೆವಲಪ್‌ಮೆಂಟ್ ಕಂಟೈನರ್ ಅನ್ನು ಆಯ್ಕೆಮಾಡುತ್ತದೆ
4. ಕ್ಲಿಕ್ ಮಾಡಿ **Create codespace**
5. ಪರಿಸರ ಸಿದ್ಧವಾಗಲು ~2 ನಿಮಿಷಗಳ ಕಾಲ ಕಾಯಿರಿ
6. ನೇರವಾಗಿ [ಮೊದಲ ಉದಾಹರಣೆಗೆ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) ಜಂಪ್ ಮಾಡಿ

> **ಸ್ಥಳೀಯವಾಗಿ ಕ್ಲೋನ್ ಮಾಡಲು ಇಚ್ಚಿಸುವಿರಾ?**
>
> ಈ ಸಂಗ್ರಹಾಲಯದಲ್ಲಿ 50+ ಭಾಷಾ ಅನುವಾದಗಳು ಸೇರಿವೆ, ಇದು ಡೌನ್ಲೋಡ್ ಗಾತ್ರವನ್ನು ಬಹಳ ಹೆಚ್ಚಿಸುತ್ತದೆ. ಅನುವಾದಗಳಿಲ್ಲದೆ ಕ್ಲೋನ್ ಮಾಡಲು, ಸ್ಪಾರ್ಸ್ ಔಟ್‌ಚೆಕ್ ಬಳಸಿ:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ಇದು ನೀವು ಕೋರ್ಸ್ ಪೂರ್ಣಗೊಳಿಸಲು ಅಗತ್ಯವಿರುವ ಎಲ್ಲವನ್ನೂ ಬಹಳ ವೇಗವಾಗಿ ಡೌನ್ಲೋಡ್ ಮಾಡಿಕೊಳ್ಳಲು ಸಹಾಯ ಮಾಡುತ್ತದೆ.


## ಬಹುಭಾಷಾ ಬೆಂಬಲ

### GitHub ಆಕ್ರಮಣದ ಮೂಲಕ ಬೆಂಬಲಿಸಲಾಗುತ್ತದೆ (ಸ್ವಯಂಕ್ರಿಯ ಮತ್ತು ಯಾವಾಗಲೂ ನವೀಕರಣ)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[ಅರೇಬಿಕ್](../ar/README.md) | [ಬಿಎಸ್‌ಗುಲಿ](../bn/README.md) | [ಬಲ್ಗೇರಿಯನ್](../bg/README.md) | [ಬರ್ಮೀಸ್ (ಮಯನ್ಮಾರ್)](../my/README.md) | [ಚಿತ್ತಗೊಳ್ಳಿರಿ (ಸರಳೀಕೃತ)](../zh-CN/README.md) | [ಚಿತ್ತಗೊಳ್ಳಿರಿ (ಪಾರಂಪರಿಕ, ಹಾಂಗ್ ಕಾಂಗ್)](../zh-HK/README.md) | [ಚಿತ್ತಗೊಳ್ಳಿರಿ (ಪಾರಂಪರಿಕ, ಮಾಕಾವು)](../zh-MO/README.md) | [ಚಿತ್ತಗೊಳ್ಳಿರಿ (ಪಾರಂಪರಿಕ, ತೈವಾನ್)](../zh-TW/README.md) | [ಕ್ರೋಯಾಷಿಯನ್](../hr/README.md) | [ಚೆಕ್](../cs/README.md) | [ಡೆನಿಷ್](../da/README.md) | [ಡಚ್](../nl/README.md) | [ಎಸ್ಟೋನಿಯನ್](../et/README.md) | [ಫಿನ್ನೀಷ್](../fi/README.md) | [ಫ್ರೆಂಚ್](../fr/README.md) | [ಜೆರ್ಮನ್](../de/README.md) | [ಗ್ರೀಕ್](../el/README.md) | [ಹೆಬ್ರೂ](../he/README.md) | [ಹಿಂಡಿ](../hi/README.md) | [ಹಂಗೇರಿಯನ್](../hu/README.md) | [ಇಂಡೋನೇಷಿಯನ್](../id/README.md) | [ಇಟಾಲಿಯನ್](../it/README.md) | [ಜಪಾನೀಸ್](../ja/README.md) | [ಕನ್ನಡ](./README.md) | [ಕೊರಿಯನ್](../ko/README.md) | [ಲಿಥುವೇನಿಯನ್](../lt/README.md) | [ಮಲಯ್](../ms/README.md) | [ಮಲಯಾಳಮ್](../ml/README.md) | [ಮರಾಠಿ](../mr/README.md) | [ನೇಪಾಳಿ](../ne/README.md) | [ನೈಜೀರಿಯನ್ ಪಿಡ್ಜಿನ್](../pcm/README.md) | [ನಾರ್ವೀಜಿಯನ್](../no/README.md) | [ಪರ್ಶಿಯನ್ (ಫಾರ್ಸಿ)](../fa/README.md) | [ಪೋಲಿಷ್](../pl/README.md) | [ಪೋರ್ಚುಗೀಸ್ (ಬ್ರೆಜಿಲ್)](../pt-BR/README.md) | [ಪೋರ್ಚುಗೀಸ್ (ಪೋರ್ಚುಗಾಲ್)](../pt-PT/README.md) | [ಪಂಜಾಬಿ (ಗುರುತ್ಸುಖಿ)](../pa/README.md) | [ರೋಮೇನಿಯನ್](../ro/README.md) | [ರಷ್ಯನ್](../ru/README.md) | [ಸರ್ಬಿಯನ್ (ಸಿರಿಲಿಕ್)](../sr/README.md) | [ಸ್ಲೋವಾಕ್](../sk/README.md) | [ಸ್ಲೋವೇನಿಯನ್](../sl/README.md) | [ಸ್ಪ್ಯಾನಿಷ್](../es/README.md) | [ಸ್ವಾಹಿಲಿ](../sw/README.md) | [ಸ್ವೀಡಿಷ್](../sv/README.md) | [ಟಗಲಗ್ (ಫಿಲಿಪಿನೊ)](../tl/README.md) | [ತಮಿಳು](../ta/README.md) | [ತೆಲುಗು](../te/README.md) | [ಥಾಯಿ](../th/README.md) | [ಟರ್ಕಿಷ್](../tr/README.md) | [ಯುಕ್ರೆನಿಯನ್](../uk/README.md) | [ಉರ್ದು](../ur/README.md) | [ವಿಯೇಟ್ನಾಮೀಸ್](../vi/README.md)

## ಕೋರ್ಸ್ ರಚನೆ ಮತ್ತು ಕಲಿಕಾ ಮಾರ್ಗ

### **ಅಧ್ಯಾಯ 1: ಜನರೇಟಿವ್ ಎಐಗೆ ಪರಿಚಯ**
- **ಮೂಲಭೂತ ಕಲ್ಪನೆಗಳು**: ದೊಡ್ಡ ಭಾಷಾ ಮಾದರಿಗಳನ್ನು ಗ್ರಹಿಸುವುದು, ಟೋಕನ್ಸ್, ಎಂಭೆಡಿಂಗ್ಸ್ ಮತ್ತು ಎಐ ಸಾಮರ್ಥ್ಯಗಳು
- **ಜಾವಾ ಎಐ ಪರಿಸರ**: ಸ್ಪ್ರಿಂಗ್ ಎಐ ಮತ್ತು ಓಪನ್‌ಎಐ SDK ಗಳ ಅವಲೋಕನ
- **ಮಾಡೆಲ್ ಸಂಧರ್ಭ ಪ್ರೋಟೋಕಾಲ್‌**: MCP ಗೆ ಪರಿಚಯ ಮತ್ತು ಎಐ ಏಜೆಂಟ್ ಸಂವಹನದಲ್ಲಿ ಅದರ ಪಾತ್ರ
- **ಪ್ರಾಯೋಗಿಕ ಅನ್ವಯಿಕೆಗಳು**: ಚಾಟ್‌ಬಾಟ್‌ಗಳು ಮತ್ತು ವಿಷಯ ರಚನೆ ಸೇರಿದಂತೆ ನೈಜ ಜಗತ್ತಿನ ಸಂದರ್ಭಗಳು
- **[→ ಅಧ್ಯಾಯ 1 ಪ್ರಾರಂಭಿಸಿ](./01-IntroToGenAI/README.md)**

### **ಅಧ್ಯಾಯ 2: ಅಭಿವೃದ್ಧಿ ಪರಿಸರ ಸೆಟಪ್**
- **ಬಹು-ಪ್ರೊವೈಡರ್ ಸಂರಚನೆ**: GitHub ಮಾದರಿಗಳು, ಅ್ಯಾಸುರ್ ಓಪನ್‌ಎಐ, ಮತ್ತು ಓಪನ್‌ಎಐ ಜಾವಾ SDK ಇಂಟಿಗ್ರೇಶನ್‌ಗಳನ್ನು ಸೆಟ್‌ಅಪ್ ಮಾಡಿ
- **ಸ್ಪ್ರಿಂಗ್ ಬೂಟ್ + ಸ್ಪ್ರಿಂಗ್ ಎಐ**: ಎಂಟರ್ಪ್ರೈಸ್ ಎಐ ಅಪ್ಲಿಕೇಶನ್ ಡೆವಲಪ್‌ಮೆಂಟ್‌ಗೆ ಉತ್ತಮ ಅಭ್ಯಾಸಗಳು
- **GitHub ಮಾದರಿಗಳು**: ಪ್ರೋಟೋಟೈಪಿಂಗ್ ಮತ್ತು ಅಧ್ಯಯನಕ್ಕೆ ಉಚಿತ ಎಐ ಮಾದರಿ ಪ್ರವೇಶ (ಕ್ರೆಡಿಟ್ ಕಾರ್ಡ್ ಅಗತ್ಯವಿಲ್ಲ)
- **ಡೆವಲಪ್ಮೆಂಟ್ ಉಪಕರಣಗಳು**: ಡಾಕರ್ ಕಂಟೈನರ್‌ಗಳು, VS ಕೋಡ್, ಮತ್ತು GitHub Codespaces ಸಂರಚನೆ
- **[→ ಅಧ್ಯಾಯ 2 ಪ್ರಾರಂಭಿಸಿ](./02-SetupDevEnvironment/README.md)**

### **ಅಧ್ಯಾಯ 3: ಕಯ್ಯಡಿ ಜನರೇಟಿವ್ ಎಐ ತಂತ್ರಗಳು**
- **ಪ್ರಾಂಪ್ಟ್ ಎಂಜಿನಿಯರಿಂಗ್**: ಉತ್ತಮ ಎಐ ಮಾದರಿ ಪ್ರತಿಕ್ರಿಯೆಗಳನ್ನು 위한 ತಂತ್ರಗಳು
- **ಎಂಭೆಡಿಂಗ್ಸ್ ಮತ್ತು ವೆಕ್ಟರ್ ಕಾರ್ಯಾಚರಣೆಗಳು**: ಸೆಮ್ಯಾಂಟಿಕ್ ಹುಡುಕಾಟ ಮತ್ತು ಸಮಾನತೆ ಹೊಂದಾಣಿಕೆ ಜಾರುಮಾಡಿ
- **ರಿಟ್ರಿವಲ್-ಆಗ್ಮೆಂಟೆಡ್ ಜನರೇಶನ್ (RAG)**: ನಿಮ್ಮ ಸ್ವಂತ ಡೇಟಾ ಮೂಲಗಳೊಂದಿಗೆ ಎಐ ಸಂಯೋಜಿಸಿ
- **ಫಂಕ್ಷನ್ ಕಾಲಿಂಗ್**: ಕಸ್ಟಮ್ ಸಾಧನಗಳು ಮತ್ತು ಪ್ಲಗಿನ್‌ಗಳೊಂದಿಗೆ ಎಐ ಸಾಮರ್ಥ್ಯಗಳನ್ನು ವಿಸ್ತರಿಸಿ
- **[→ ಅಧ್ಯಾಯ 3 ಪ್ರಾರಂಭಿಸಿ](./03-CoreGenerativeAITechniques/README.md)**

### **ಅಧ್ಯಾಯ 4: ಪ್ರಾಯೋಗಿಕ ಅನ್ವಯಿಕೆಗಳು ಮತ್ತು ಪ್ರಾಜೆಕ್ಟ್‌ಗಳು**
- **ಪೆಟ್ ಸ್ಟೋರಿ ಜೆನರೇಟರ್** (`petstory/`): GitHub ಮಾದರಿಗಳೊಂದಿಗೆ ಸೃಜನಾತ್ಮಕ ವಿಷಯ ರಚನೆ
- **ಫೌಂಡ್ರಿ ಸ್ಥಳೀಯ ಡೆಮೋ** (`foundrylocal/`): ಓಪನ್‌ಎಐ ಜಾವಾ SDK ಜೊತೆ ಸ್ಥಳೀಯ ಎಐ ಮಾದರಿ ಒಕ್ಕೂಡಣೆ
- **MCP ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಸರ್ವಿಸ್** (`calculator/`): ಸ್ಪ್ರಿಂಗ್ ಎಐ ಬಳಸಿ ಮೂಲಮಾಡೆಲ್ ಸಂಧರ್ಭ ಪ್ರೋಟೋಕಾಲ್ ಜಾರಿಗೆ
- **[→ ಅಧ್ಯಾಯ 4 ಪ್ರಾರಂಭಿಸಿ](./04-PracticalSamples/README.md)**

### **ಅಧ್ಯಾಯ 5: ಜವಾಬ್ದಾರಿಯುತ ಎಐ ಅಭಿವೃದ್ಧಿ**
- **GitHub ಮಾದರಿಗಳ ಸುರಕ್ಷತೆ**: ಒಳಗಿರುವ ವಿಷಯ ಫಿಲ್ಟರಿಂಗ್ ಮತ್ತು ಸುರಕ್ಷತಾ ಯಂತ್ರಮಾನವನ ಪರೀಕ್ಷಿಸಿ (ಕಠಿಣ ತಡೆಗಳು ಮತ್ತು ಮೃದು ನಿರಾಕರಣೆಗಳು)
- **ಜವಾಬ್ದಾರಿಯುತ ಎಐ ಡೆಮೋ**: ಯುಕ್ತವಾದ ಎಐ ಸುರಕ್ಷತಾ ವ್ಯವಸ್ಥೆಗಳ ಕಾರ್ಯಾಚರಣೆಯ ಕೈಗಾರಿಕೆ ಉದಾಹರಣೆ
- **ಅತ್ಯುತ್ತಮ ಅಭ್ಯಾಸಗಳು**: ನೈತಿಕ ಎಐ ಅಭಿವೃದ್ಧಿ ಮತ್ತು ನಿಯೋಜನೆಗೆ ಅಗತ್ಯ ಮಾರ್ಗದರ್ಶನಗಳು
- **[→ ಅಧ್ಯಾಯ 5 ಪ್ರಾರಂಭಿಸಿ](./05-ResponsibleGenAI/README.md)**

## ಹೆಚ್ಚುವರಿ ಸಂಪನ್ಮೂಲಗಳು

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### ಲಾಂಗ್‌ಚೈನ್
[![ಪ್ರಾರಂಭಿಕರಿಗಾಗಿ LangChain4j](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![ಪ್ರಾರಂಭಿಕರಗಾಗಿ LangChain.js](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![ಪ್ರಾರಂಭಿಕರಿಗಾಗಿ LangChain](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### ಅಾಸ್ಯೂರ್ / ಎಡ್ಜ್ / MCP / ಏಜೆಂಟ್ಸ್
[![ಪ್ರಾರಂಭಿಕರಿಗಾಗಿ AZD](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![ಪ್ರಾರಂಭಿಕರಿಗಾಗಿ ಎಡ್ಜ್ ಎಐ](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![ಪ್ರಾರಂಭಿಕರಿಗಾಗಿ MCP](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![ಪ್ರಾರಂಭಿಕರಿಗಾಗಿ AI ಏಜೆಂಟ್ಸ್](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### ಜನರೇಟಿವ್ ಎಐ ಸರಣಿ
[![ಜನರೇಟಿವ್ ಎಐ ಪ್ರಾರಂಭಿಕರಿಗಾಗಿ](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![ಜನರೇಟಿವ್ ಎಐ (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![ಜನರೇಟಿವ್ ಎಐ (ಜಾವಾ)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![ಜನರೇಟಿವ್ ಎಐ (ಜಾವಾಸ್ಕ್ರಿಪ್ಟ್)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### ನ್ಯೂನಪದ ಕಲಿಕೆ
[![ಪ್ರಾರಂಭಿಕರಿಗಾಗಿ ML](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![ಪ್ರಾರಂಭಿಕರಿಗಾಗಿ ಡೇಟಾ ಸೈನ್ಸ್](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![ಪ್ರಾರಂಭಿಕರಿಗಾಗಿ ಎಐ](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![ಪ್ರಾರಂಭಿಕರಿಗಾಗಿ ಸೈಬರ್‌ಸುರಕ್ಷತೆ](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![ಮುಗಿಯುವಿಕೆಗಾಗಿ ವೆಬ್ ಡೆವ್](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![ಮುಗಿಯುವಿಕೆಗಾಗಿ IoT](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![ಮುಗಿಯುವಿಕೆಗಾಗಿ XR ಅಭಿವೃದ್ಧಿ](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### ಕೋಪೈಲಟ್ ಸರಣಿ
[![AI ಜೋಡಿ ಪ್ರೋಗ್ರಾಮಿಂಗ್‌ಗಾಗಿ ಕೋಪೈಲಟ್](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![C#/.NET ಗಾಗಿ ಕೋಪೈಲಟ್](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![ಕೋಪೈಲಟ್ ಸಾಹಸ](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## ಸಹಾಯ ಪಡೆಯುವುದು

ನೀವು ಅಂಟಿಕೊಂಡಿದ್ದರೆ ಅಥವಾ AI ಅನ್ವಯಿಕೆಗಳನ್ನು ನಿರ್ಮಿಸಲು ಯಾವುದೇ ಪ್ರಶ್ನೆಗಳಿದ್ದರೆ. MCP ಬಗ್ಗೆ ಚರ್ಚೆಗಳಲ್ಲಿ ಇತರ ಕಲಿಯುವವರು ಮತ್ತು ಅನುಭವಜ್ಞರೊಂದಿಗೆ ಸೇರಿ. ಇದು ಪ್ರಶ್ನೆಗಳನ್ನು ಸ್ವಾಗತಿಸುವ ಮತ್ತು ಜ್ಞಾನವನ್ನು ಮುಕ್ತವಾಗಿ ಹಂಚಿಕೊಳ್ಳುವ ಅನುರೂಪ ಸಮುದಾಯವಾಗಿದೆ.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

ನೀವು ಉತ್ಪನ್ನ ಪ್ರತಿಕ್ರಿಯೆ ಅಥವಾ ನಿರ್ಮಾಣದ ಸಮಯದಲ್ಲಿ ದೋಷಗಳನ್ನು ಹೊಂದಿದ್ದರೆ, ದಯವಿಟ್ಟು ಭೇಟಿ ನೀಡಿ:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ವಿಮರ್ಶೆ**:  
ಈ ದಸ್ತಾವೇಜು AI ಭಾಷಾಂತರ ಸೇವೆ [Co-op Translator](https://github.com/Azure/co-op-translator) ಬಳಸಿ ಭಾಷಾಂತರಿಸಲಾಗಿದೆ. ನಾವು ಶುದ್ದತೆಯನ್ನು ಸಾಧಿಸಲು ಪ್ರಯತ್ನಿಸುತ್ತೇವೆ, ಆದರೆ ಸ್ವಯಂಚಾಲಿತ ಭಾಷಾಂತರಗಳಲ್ಲಿ ದೋಷಗಳು ಅಥವಾ ಅನಿಖ್ಯತತೆಗಳಿರಬಹುದು ಎಂದು कृಪೆಯಾಗಿ ಗುರುತಿಸಿಕೊಳ್ಳಿ. ಮೂಲ ದಸ್ತಾವೇಜಿನ ಸ್ವಭಾವಿಕ ಭಾಷೆಯು ಅಧೀನವಾಗಿ ಪರಿಗಣಿಸಬೇಕಾದ ಮೂಲವಾಗಿದೆ. ಮಹತ್ವದ ಮಾಹಿತಿಗಾಗಿ ವೃತ್ತಿಪರ ಮಾನವ ಭಾಷಾಂತರವನ್ನು ಶಿಫಾರಸು ಮಾಡಲಾಗುತ್ತದೆ. ಈ ಭಾಷಾಂತರ ಬಳಕೆಯಿಂದಾಗಿ ಸಂಭವಿಸಬಹುದಾದ ಯಾವುದೇ ತಪ್ಪುಗಳಿದೆಯಾದ ಅರ್ಥಮಾಡಿಕೊಳ್ಳುವಿಕೆ ಅಥವಾ ದೋಷ ವಿವರಣೆಗಳಿಗೆ ನಮಗೆ ಹೊಣೆಗಾರಿಕೆ ಇಲ್ಲ.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->