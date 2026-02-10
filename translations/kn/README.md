# ಸೃಜನಶೀಲ AI ಪ್ರಾರಂಭಿಕರು - ಜಾವಾ ಎಡಿಷನ್
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![ಸೃಜನಶೀಲ AI ಪ್ರಾರಂಭಿಕರು - ಜಾವಾ ಎಡಿಷನ್](../../translated_images/kn/beg-genai-series.8b48be9951cc574c.webp)

**ಸಮಯ ಬದ್ಧತೆ**: ಸಂಪೂರ್ಣ ಕಾರ್ಯಾಗಾರವನ್ನು ಆನ್‌ಲೈನ್‌ನಲ್ಲಿ ಸ್ಥಳೀಯ ಸೆಟ್ ಅಪ್ ಇಲ್ಲದೆ ಪೂರ್ಣಗೊಳ್ಳಬಹುದು. ಪರಿಸರ ಸೆಟ್ ಅಪ್ ಮಾಡಲು 2 ನಿಮಿಷಗಳು ಬೇಕಾಗುತ್ತದೆ, ಮತ್ತು ನಿಸರ್ಗವನ್ನು ಅನ್ವೇಷಿಸುವುದಕ್ಕೆ 1-3 ಗಂಟೆಗಳ ಅವಧಿ ಅನ್ವೇಷಣೆಯ ಆಳತೆಯ ಮೇಲೆ منحصرವಾಗಿದೆ.

> **ತ್ವರಿತ ಪ್ರಾರಂಭ**

1. ಈ ರಿಪೊಸಿಟರಿಯನ್ನು ನಿಮ್ಮ GitHub ಖಾತೆಗೆ ಫೋರ್ಕ್ ಮಾಡಿ
2. **Code** → **Codespaces** ಟ್ಯಾಬ್ → **...** → **New with options...** ಕ್ಲಿಕ್ ಮಾಡಿ
3. ಡೀಫಾಲ್ಟ್ ಆಯ್ಕೆಗಳು ಬಳಸಿ – ಇದು ಈ ಕೋರ್ಸಿಗಾಗಿ ನಿರ್ಮಿತ ಡೆವಲಪ್‌ಮೆಂಟ್ ಕಂಟೈನರ್ ಅನ್ನು ಆರಿಸುತ್ತದೆ
4. **Create codespace** ಕ್ಲಿಕ್ ಮಾಡಿ
5. ಪರಿಸರವು ಸಿದ್ಧವಾಗಲು ~2 ನಿಮಿಷಗಳ ಕಾಲ ಕಾಯಿರಿ
6. ನೇರವಾಗಿ [ಮೊದಲ ಉದಾಹರಣೆಗೆ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) ಹಾಗಿ ಹೋಗಿ

> **ಸ್ಥಳೀಯವಾಗಿ ಕ್ಲೋನ್ ಮಾಡಬೇಕೆಂದು ಇಚ್ಛಿಸುವಿರಾ?**
>
> ಈ ರಿಪೊಸಿಟರಿಯಲ್ಲಿ 50+-ಭಾಷಾಂತರಗಳಿವೆ, ಇದು ಡownload ಗಾತ್ರವನ್ನು ಬಹಳ ಹೆಚ್ಚಿಸುತ್ತದೆ. ಭಾಷಾಂತರಗಳಿಲ್ಲದೆ ಕ್ಲೋನ್ ಮಾಡಲು ಪತ್ತೆ ಪರೀಕ್ಷೆ (sparse checkout) ಬಳಸಿ:
>
> **Linux / macOS (Bash)**
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
>
> **Windows (PowerShell)**
> ```powershell
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone "/*" "!translations" "!translated_images"
> ```
> ಇದು ನಿಮಗೆ ಕೋರ್ಸ್ ಪೂರ್ಣಗೊಳಿಸಲು ಬೇಕಾದ ಎಲ್ಲವನ್ನು ತುಂಬಾ ವೇಗವಾಗಿ ಡೌನ್ಲೋಡ್ ಮಾಡಲು ಸಹಾಯ ಮಾಡುತ್ತದೆ.

## ಬಹುಭಾಷಾ ಬೆಂಬಲ

### GitHub ಕ್ರಿಯಾ ಮೂಲಕ ಬೆಂಬಲಿತ (ಸ್ವಯಂಚಾಲಿತ & ಸದಾ ಹಾಲಿ)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[ಅರೇಬಿಕ್](../ar/README.md) | [ಬೆಂಗಾಳಿ](../bn/README.md) | [ಬಲ್ಗೇರಿಯನ್](../bg/README.md) | [ಬರ್ಮೀಸ್ (ಮಯಾನ್ಮಾರ್)](../my/README.md) | [ಚೈನೀಸ್ (ಸರಳೀಕೃತ)](../zh-CN/README.md) | [ಚೈನೀಸ್ (ಪರಂಪರাগত, ಹಾಂಗ್ ಕಾಂಗ್)](../zh-HK/README.md) | [ಚೈನ್ (ಪರಂಪರাগত, ಮಕಾವು)](../zh-MO/README.md) | [ಚೈನೀಸ್ (ಪರಂಪರागत, ತೈವಾನ್)](../zh-TW/README.md) | [ಕ್ರೊಯೇಷಿಯನ್](../hr/README.md) | [ಚ್zech](../cs/README.md) | [ಡೆನ್ಮಾರ್ಕ್](../da/README.md) | [ಡಚ್](../nl/README.md) | [ಎಸ್ಟೋನಿಯನ್](../et/README.md) | [ಫಿನ್ನಿಷ್](../fi/README.md) | [ಫ್ರೆಂಚ್](../fr/README.md) | [ಜರ್ಮನ್](../de/README.md) | [ಗ್ರೀಕ್](../el/README.md) | [ಹೆಬ್ರೂ](../he/README.md) | [ಹಿಂದಿ](../hi/README.md) | [ಹಂಗೇರಿಯನ್](../hu/README.md) | [ಇಂಡೋನೇಶಿಯನ್](../id/README.md) | [ಇಟಾಲಿಯನ್](../it/README.md) | [ಜಪಾನೀಸ್](../ja/README.md) | [ಕರ್ನಾಡ](./README.md) | [ಕೋರಿಯನ್](../ko/README.md) | [ಲಿಥುವೇನಿಯಾದ](../lt/README.md) | [ಮಲಯ್](../ms/README.md) | [ಮಲಯಾಳಂ](../ml/README.md) | [ಮರಾಠಿ](../mr/README.md) | [ನೇಪಾಳಿ](../ne/README.md) | [ನೈಜೀರಿಯನ್ ಪಿಡ್ಜಿನ್](../pcm/README.md) | [ನಾರ್ವೇಜಿಯನ್](../no/README.md) | [ಪರ್ಸಿಯನ್ (ಫಾರ್ಸಿ)](../fa/README.md) | [ಪೋಲಿಶ್](../pl/README.md) | [ಪೋರ್ಚುಗೀಸ್ (ಬ್ರೆಜಿಲ್)](../pt-BR/README.md) | [ಪೋರ್ಚುಗೀಸ್ (ಪೋರ್ಟುಗಲ್)](../pt-PT/README.md) | [ಪುಂಜಾಬಿ (ಗುರ್ಮುಖಿ)](../pa/README.md) | [ರೊಮೇನಿಯನ್](../ro/README.md) | [ರಷ್ಯನ್](../ru/README.md) | [ಸೆರ್ಬಿಯನ್ (ಸಿರಿಲಿಕ್)](../sr/README.md) | [ಸ್ಲೋವಾಕಿಯನ್](../sk/README.md) | [ಸ್ಲೋವೇನಿಯನ್](../sl/README.md) | [ಸ್ಪಾನಿಷ್](../es/README.md) | [ಸ್ವಾಹಿಲಿ](../sw/README.md) | [ಸ್ವೀಡಿಷ್](../sv/README.md) | [ಟಗಲಾಗ್ (ಫಿಲಿಪಿನೋ)](../tl/README.md) | [ತಮಿಳು](../ta/README.md) | [ತೆಲುಗು](../te/README.md) | [ಥಾಯ್](../th/README.md) | [ತುರ್ಕಿಷ್](../tr/README.md) | [ಉಕ್ರೇನಿಯನ್](../uk/README.md) | [ಉರ್ದು](../ur/README.md) | [ವಿಯೆಟ್ನಾಮೀಸ್](../vi/README.md)

## ಕೋರ್ಸ್ ರಚನೆ ಮತ್ತು ಕಲಿಕೆ ಮಾರ್ಗ

### **ಅಧ್ಯಾಯ 1: ಸೃಜನಶೀಲ AI ಪರಿಚಯ**
- **ಕೋರ್ ತಾತ್ವಿಕಗಳು**: ಲಾರ್ಜ್ ಲ್ಯಾಂಗ್ವೇಜ್ ಮಾಡೆಲ್ಸ್, ಟೋಕನ್‌ಗಳು, ಎಮ್ಬೆಡಿಂಗ್‌ಗಳು, ಮತ್ತು AI ಸಾಮರ್ಥ್ಯಗಳ ಅರ್ಥೈಸಿಕೆ
- **ಜಾವಾ AI ಪರಿಸರ**: ಸ್ಪ್ರಿಂಗ್ AI ಮತ್ತು OpenAI SDK ಗಳು ಬಗ್ಗೆ ಅವಲೋಕನ
- **ಮಾಡೆಲ್ ಕಾಂಟೆಕ್ಸ್ಟ್ ಪ್ರೋಟೋಕಾಲ್**: MCP ಪರಿಚಯ ಮತ್ತು AI ಏಜೆಂಟ್ ಸಂವಹನದಲ್ಲಿ ಅದರ ಪಾತ್ರ
- **ಪ್ರಾಯೋಗಿಕ ಅನ್ವಯಿಕೆಗಳು**: ಚಾಟ್‌ಬಾಟ್‌ಗಳು ಮತ್ತು ವಿಷಯ ಸೃಷ್ಟಿ ಸೇರಿದಂತೆ ನೈಜ-ಜಗತ್ತಿನ ದೃಶ್ಯಗಳು
- **[→ ಅಧ್ಯಾಯ 1 ಪ್ರಾರಂಭಿಸಿ](./01-IntroToGenAI/README.md)**

### **ಅಧ್ಯಾಯ 2: ಅಭಿವೃದ್ಧಿ ಪರಿಸರ ಸೆಟ್ ಅಪ್**
- **ಬಹು-ಪ್ರೊವೈಡರ್ ಸಂರಚನೆ**: GitHub Models, Azure OpenAI, ಮತ್ತು OpenAI Java SDK ಗಳ ಸಂಯೋಜನೆ
- **ಸ್ಪ್ರಿಂಗ್ ಬೂಟ್ + ಸ್ಪ್ರಿಂಗ್ AI**: ಎಂಟರ್‌ಪ್ರೈಸ್ AI ಅಪ್ಲಿಕೇಶನ್‌ಗಳ ಉತ್ತಮ ಅಭ್ಯಾಸಗಳು
- **GitHub Models**: ಪ್ರೋಟೋಟೈಪಿಂಗ್ ಮತ್ತು ಕಲಿಕೆಗೆ ಉಚಿತ AI ಮಾಡೆಲ್ ಪ್ರವೇಶ (ಕ್ರೆಡಿಟ್ ಕಾರ್ಡ್ ಅಗತ್ಯವಿಲ್ಲ)
- **ಅಭಿವೃದ್ಧಿ ಉಪಕರಣಗಳು**: ಡಾಕರ್ ಕಂಟೈನರ್‌ಗಳು, VS ಕೋಡ್, ಮತ್ತು GitHub ಕೋಡ್ಸ್‌ಪೇಸ್ ಸಂರಚನೆ
- **[→ ಅಧ್ಯಾಯ 2 ಪ್ರಾರಂಭಿಸಿ](./02-SetupDevEnvironment/README.md)**

### **ಅಧ್ಯಾಯ 3: ಕೋರ್ ಸೃಜನಶೀಲ AI ತಂತ್ರಗಳು**
- **ಪ್ರಾಂಪ್ಟ್ ಎಂಜಿನಿಯರಿಂಗ್**: ಉತ್ತಮ AI ಮಾಡೆಲ್ ಪ್ರತಿಕ್ರಿಯೆಗಾಗಿ ತಂತ್ರಗಳು
- **ಎಂಬೆಡಿಂಗ್‌ಗಳು ಮತ್ತು ವೆಕ್ಟರ್ ಕಾರ್ಯಗಳು**: ಸ್ಯಾಂಟ್ಯಾನ್ಸ್ ಹುಡುಕಾಟ ಮತ್ತು ಅನುರೂಪತೆ ಹೊಂದಾಣಿಕೆ ಅನುಷ್ಠಾನ
- **ರಿಟ್ರೀವೆಲ್-ಆಗ್ಮೆಂಟೆಡ್ ಜನರೇಶನ್ (RAG)**: ನಿಮ್ಮ ಸ್ವಂತ ಡೇಟಾ ಮೂಲಗಳೊಂದಿಗೆ AI ಸಂಯೋಜನೆ
- **ಫಂಕ್ಷನ್ ಕಾಲಿಂಗ್**: ಕಸ್ಟಮ್ ಉಪಕರಣಗಳು ಮತ್ತು ಪ್ಲಗಿನ್ಗಳ ಮೂಲಕ AI ಸಾಮರ್ಥ್ಯ ವಿಸ್ತರಣೆ
- **[→ ಅಧ್ಯಾಯ 3 ಪ್ರಾರಂಭಿಸಿ](./03-CoreGenerativeAITechniques/README.md)**

### **ಅಧ್ಯಾಯ 4: ಪ್ರಾಯೋಗಿಕ ಅನ್ವಯಿಕೆಗಳು ಮತ್ತು ಯೋಜನೆಗಳು**
- **ಪೆಟ್ ಸ್ಟೋರಿ ಜನರೇಟರ್** (`petstory/`): GitHub Models ಬಳಸಿ ಸೃಜನಶೀಲ ವಿಷಯ ರಚನೆ
- **Foundry Local ಡೆಮೊ** (`foundrylocal/`): OpenAI ಜಾವಾ SDK ಮೂಲಕ ಸ್ಥಳೀಯ AI ಮಾಡೆಲ್ ಸಂಯೋಜನೆ
- **MCP ಕ್ಯಾಲ್ಕुलेಟರ್ ಸೇವೆ** (`calculator/`): ಸ್ಪ್ರಿಂಗ್ AI ಬಳಸಿ ಮೂಲ Model Context Protocol ಅನುಷ್ಠಾನ
- **[→ ಅಧ್ಯಾಯ 4 ಪ್ರಾರಂಭಿಸಿ](./04-PracticalSamples/README.md)**

### **ಅಧ್ಯಾಯ 5: ಜವಾಬ್ದಾರಿಯಾಗಿ AI ಅಭಿವೃದ್ಧಿ**
- **GitHub Models ಸುರಕ್ಷತೆ**: ನಿರ್ಮಿತ ವಿಷಯ ಶೋಧನೆ ಮತ್ತು ಸುರಕ್ಷತಾ ವ್ಯವಸ್ಥೆಗಳ (ಕಠಿಣ ತಡೆಗಳು ಮತ್ತು ಸೌಮ್ಯ ನಿರಾಕರಣೆ) ಪರೀಕ್ಷೆ
- **ಜವಾಬ್ದಾರಿಯಾದ AI ಡೆಮೋ**: ಆಧುನಿಕ AI ಸುರಕ್ಷತಾ ವ್ಯವಸ್ಥೆಗಳು ಹೇಗೆ ಕಾರ್ಯನಿರ್ವಹಿಸುತ್ತವೆ ಎಂಬುದನ್ನು ತೋರಿಸುವ ಕೈಗೆಟಕುವ ಉದಾಹರಣೆ
- **ಅತ್ಯುತ್ತಮ ಅಭ್ಯಾಸಗಳು**: ನೈತಿಕ AI ಅಭಿವೃದ್ಧಿ ಮತ್ತು ನಿಯೋಜನೆಗಾಗಿ ಅಗತ್ಯ ಮಾರ್ಗದರ್ಶನಗಳು
- **[→ ಅಧ್ಯಾಯ 5 ಪ್ರಾರಂಭಿಸಿ](./05-ResponsibleGenAI/README.md)**

## ಹೆಚ್ಚುವರಿ ಸಂಪನ್ಮೂಲಗಳು

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### ಲ್ಯಾಂಗ್‌ಚೈನ್
[![LangChain4j ಪ್ರಾರಂಭಿಕರುಗಾಗಿ](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js ಪ್ರಾರಂಭಿಕರುಗಾಗಿ](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain ಪ್ರಾರಂಭಿಕರುಗಾಗಿ](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / ಎಡ್ಜ್ / MCP / ಏಜೆಂಟ್ಸ್
[![AZD ಪ್ರಾರಂಭಿಕರುಗಾಗಿ](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![ಎಡ್ಜ್ AI ಪ್ರಾರಂಭಿಕರುಗಾಗಿ](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP ಪ್ರಾರಂಭಿಕರುಗಾಗಿ](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI ಏಜೆಂಟ್ಸ್ ಪ್ರಾರಂಭಿಕರುಗಾಗಿ](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### ಸೃಜನಶೀಲ AI ಸರಣಿ
[![ಸೃಜನಶೀಲ AI ಪ್ರಾರಂಭಿಕರು](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![ಸೃಜನಶೀಲ AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![ಸೃಜನಶೀಲ AI (ಜಾವಾ)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![ಸೃಜನಶೀಲ AI (ಜಾವಾಸ್ಕ್ರಿಪ್ಟ್)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---

### ಮೂಲ ಕಲಿಕೆ
[![ಪ್ರಾರಂಭಿಕರುಗಾಗಿ ಎಂಎಲ್](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![ಪ್ರಾರಂಭಿಕರುಗಾಗಿ ಡೇಟಾ ಸೈನ್ಸ್](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![ಪ್ರಾರಂಭಿಕರುಗಾಗಿ AI](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![ಪ್ರಾರಂಭಿಕರುಗಾಗಿ ಸೈಬರ್ ಸೆಕ್ಯೂರಿಟಿ](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![ಬೇಗ್ನರ್ಸ್‌ಗಾಗಿ ವೆಬ್ ಡೆವ್](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![ಬೇಗ್ನರ್ಸ್‌ಗಾಗಿ ಐಒಟಿ](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![ಬೇಗ್ನರ್ಸ್‌ಗಾಗಿ.XR ಅಭಿವೃದ್ಧಿ](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### ಕೊಪಿಲಟ್ ಸರಣಿ
[![AI ಜೋಡಿ ಪ್ರೋಗ್ರಾಮಿಂಗ್‌ಗಾಗಿ ಕೊಪಿಲಟ್](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![C#/.NET ಗಾಗಿ ಕೊಪಿಲಟ್](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![ಕೊಪಿಲಟ್ ಸಾಹಸ](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## ಸಹಾಯ ಪಡೆಯುವುದು

ನೀವು ಅಡಗಿಬಿಟ್ಟಿದ್ದೀರಾ ಅಥವಾ AI ಅಪ್ಲಿಕೇಶನ್ಗಳು ರಚಿಸುವ ಬಗ್ಗೆ ಯಾವುದೇ ಪ್ರಶ್ನೆಗಳಿದ್ದರೆ, MCP ಬಗ್ಗೆ ಚರ್ಚೆಗಳಲ್ಲಿ ಸಹಪಾಠಿಗಳು ಮತ್ತು ಅನುಭವಿ ಡೆವಲಪರ್‌ಗಳೊಂದಿಗೆ ಸೇರಿ. ಇದು ಪ್ರಶ್ನೆಗಳಿಗೆ ಸ್ವಾಗತ ನೀಡುವ ಮತ್ತು ಜ್ಞಾನವನ್ನು ಮುಕ್ತವಾಗಿ ಹಂಚಿಕೊಳ್ಳುವ ಬೆಂಬಲಕಾರಿ ಸಮುದಾಯವಾಗಿದೆ.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

ನೀವು ಉತ್ಪನ್ನ ಅಭಿಪ್ರಾಯ ಅಥವಾ ಬಿಲ್ಡಿಂಗ್ ಸಮಯದಲ್ಲಿ ಎರ್ರ್ ಗಳಿದ್ದರೆ ಭೇಟಿ ನೀಡಿ:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ನಿರೀಕ್ಷಣೆ**:  
ಈ ದಸ್ತಾವೇಜು AI ಅನುವಾದ ಸೇವೆ [Co-op Translator](https://github.com/Azure/co-op-translator) ಬಳಸಿ ಅನುವದಿಸಲಾಗಿದೆ. ನಾವು ಸರಿಯಾದ ಅನುವಾದಕ್ಕಾಗಿ ಪ್ರಯತ್ನಿಸುತ್ತಿದ್ದರೂ, ಸ್ವಯಂಚಾಲಿತ ಅನುವಾದಗಳಲ್ಲಿ ದೋಷಗಳು ಅಥವಾ ಅಸತ್ಯತೆಗಳು ಇರಬಹುದು ಎಂಬುದನ್ನು ದಯವಿಟ್ಟು ಗಮನಿಸಿ. ಮೂಲ ಭಾಷೆಯಲ್ಲಿನ ಮೂಲ ದಸ್ತಾವೇಜನ್ನು ಅಧಿಕೃತ ಮೂಲ ಎಂದು ಪರಿಗಣಿಸಬೇಕು. ಅತ್ಯಂತ ಮಹತ್ವದ ಮಾಹಿತಿಗೆ ವೃತ್ತಿಪರ ಮಾನವ ಅನುವಾದದ ಸಲಹೆ ನೀಡಲಾಗುತ್ತದೆ. ಈ ಅನುವಾದದ ಬಳಕೆಯಿಂದ ಉಂಟಾಗಬಹುದಾದ ಯಾವುದೇ ಬೆಮ್ಮತ್ತಿಕೆಗಳು ಅಥವಾ ತಪ್ಪು ಅರ್ಥಗಳಿಗಾಗಿ ನಾವು ಜವಾಬ್ದಾರರಲ್ಲ.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->