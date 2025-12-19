<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "eaa2dc75d2cf5083d071e3c84aa4b955",
  "translation_date": "2025-12-19T10:54:36+00:00",
  "source_file": "README.md",
  "language_code": "ml"
}
-->
# ആരംഭക്കാർക്കുള്ള ജനറേറ്റീവ് എഐ - ജാവ എഡിഷൻ
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.ml.png)

**സമയം**: മുഴുവൻ വർക്ക്‌ഷോപ്പും ലോക്കൽ സെറ്റപ്പ് ഇല്ലാതെ ഓൺലൈനിൽ പൂർത്തിയാക്കാം. പരിസ്ഥിതി സെറ്റപ്പ് 2 മിനിറ്റ് എടുക്കും, സാമ്പിളുകൾ പരിശോധിക്കാൻ 1-3 മണിക്കൂർ എടുക്കാം, പരിശോധിക്കുന്ന ആഴം അനുസരിച്ച്.

> **വേഗത്തിലുള്ള ആരംഭം**

1. ഈ റിപോസിറ്ററി നിങ്ങളുടെ GitHub അക്കൗണ്ടിലേക്ക് ഫോർക്ക് ചെയ്യുക
2. **Code** → **Codespaces** ടാബ് → **...** → **New with options...** ക്ലിക്ക് ചെയ്യുക
3. ഡിഫോൾട്ടുകൾ ഉപയോഗിക്കുക – ഇത് ഈ കോഴ്സിനായി സൃഷ്ടിച്ച ഡെവലപ്പ്മെന്റ് കണ്ടെയ്‌നർ തിരഞ്ഞെടുക്കും
4. **Create codespace** ക്ലിക്ക് ചെയ്യുക
5. പരിസ്ഥിതി തയ്യാറാകാൻ ഏകദേശം 2 മിനിറ്റ് കാത്തിരിക്കുക
6. നേരിട്ട് [ആദ്യ ഉദാഹരണത്തിലേക്ക്](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) പോവുക

> **ലോക്കലായി ക്ലോൺ ചെയ്യാൻ ആഗ്രഹിക്കുന്നുവോ?**
>
> ഈ റിപോസിറ്ററിയിൽ 50+ ഭാഷാ പരിഭാഷകൾ ഉൾക്കൊള്ളുന്നു, ഇത് ഡൗൺലോഡ് വലുപ്പം വളരെ വർദ്ധിപ്പിക്കുന്നു. പരിഭാഷകൾ ഇല്ലാതെ ക്ലോൺ ചെയ്യാൻ sparse checkout ഉപയോഗിക്കുക:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ഇത് കോഴ്സ് പൂർത്തിയാക്കാൻ ആവശ്യമായ എല്ലാ കാര്യങ്ങളും വളരെ വേഗത്തിൽ ഡൗൺലോഡ് ചെയ്യാൻ സഹായിക്കും.


## ബഹുഭാഷാ പിന്തുണ

### GitHub Action വഴി പിന്തുണ (സ്വയം പ്രവർത്തിക്കുന്നതും എല്ലായ്പ്പോഴും അപ്‌ടുഡേറ്റും)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[അറബിക്](../ar/README.md) | [ബംഗാളി](../bn/README.md) | [ബൾഗേറിയൻ](../bg/README.md) | [ബർമീസ് (മ്യാൻമാർ)](../my/README.md) | [ചൈനീസ് (സിംപ്ലിഫൈഡ്)](../zh/README.md) | [ചൈനീസ് (ട്രഡിഷണൽ, ഹോങ്കോങ്)](../hk/README.md) | [ചൈനീസ് (ട്രഡിഷണൽ, മക്കാവു)](../mo/README.md) | [ചൈനീസ് (ട്രഡിഷണൽ, തായ്‌വാൻ)](../tw/README.md) | [ക്രൊയേഷ്യൻ](../hr/README.md) | [ചെക്ക്](../cs/README.md) | [ഡാനിഷ്](../da/README.md) | [ഡച്ച്](../nl/README.md) | [എസ്റ്റോണിയൻ](../et/README.md) | [ഫിന്നിഷ്](../fi/README.md) | [ഫ്രഞ്ച്](../fr/README.md) | [ജർമ്മൻ](../de/README.md) | [ഗ്രീക്ക്](../el/README.md) | [ഹീബ്രു](../he/README.md) | [ഹിന്ദി](../hi/README.md) | [ഹംഗേറിയൻ](../hu/README.md) | [ഇന്തോനേഷ്യൻ](../id/README.md) | [ഇറ്റാലിയൻ](../it/README.md) | [ജാപ്പനീസ്](../ja/README.md) | [കന്നഡ](../kn/README.md) | [കൊറിയൻ](../ko/README.md) | [ലിത്വാനിയൻ](../lt/README.md) | [മലായ്](../ms/README.md) | [മലയാളം](./README.md) | [മറാത്തി](../mr/README.md) | [നെപ്പാളി](../ne/README.md) | [നൈജീരിയൻ പിഡ്ജിൻ](../pcm/README.md) | [നോർവീജിയൻ](../no/README.md) | [പേർഷ്യൻ (ഫാർസി)](../fa/README.md) | [പോളിഷ്](../pl/README.md) | [പോർച്ചുഗീസ് (ബ്രസീൽ)](../br/README.md) | [പോർച്ചുഗീസ് (പോർച്ചുഗൽ)](../pt/README.md) | [പഞ്ചാബി (ഗുരുമുഖി)](../pa/README.md) | [റോമാനിയൻ](../ro/README.md) | [റഷ്യൻ](../ru/README.md) | [സെർബിയൻ (സിറിലിക്)](../sr/README.md) | [സ്ലോവാക്](../sk/README.md) | [സ്ലോവേനിയൻ](../sl/README.md) | [സ്പാനിഷ്](../es/README.md) | [സ്വാഹിലി](../sw/README.md) | [സ്വീഡിഷ്](../sv/README.md) | [ടാഗാലോഗ് (ഫിലിപ്പിനോ)](../tl/README.md) | [തമിഴ്](../ta/README.md) | [തെലുങ്ക്](../te/README.md) | [തായ്](../th/README.md) | [ടർക്കിഷ്](../tr/README.md) | [ഉക്രേനിയൻ](../uk/README.md) | [ഉർദു](../ur/README.md) | [വിയറ്റ്നാമീസ്](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## കോഴ്സ് ഘടനയും പഠന പാതയും

### **അധ്യായം 1: ജനറേറ്റീവ് എഐയുടെ പരിചയം**
- **പ്രധാന ആശയങ്ങൾ**: വലിയ ഭാഷാ മോഡലുകൾ, ടോക്കണുകൾ, എംബെഡിംഗുകൾ, എഐ കഴിവുകൾ മനസ്സിലാക്കൽ
- **ജാവ എഐ പരിസ്ഥിതി**: സ്പ്രിംഗ് എഐയും ഓപ്പൺഎഐ SDKകളും അവലോകനം
- **മോഡൽ കോൺടെക്സ്റ്റ് പ്രോട്ടോക്കോൾ**: MCP പരിചയം, എഐ ഏജന്റ് ആശയവിനിമയത്തിലെ പങ്ക്
- **പ്രായോഗിക ഉപയോഗങ്ങൾ**: ചാറ്റ്ബോട്ടുകളും ഉള്ളടക്ക സൃഷ്ടിയും ഉൾപ്പെടുന്ന യാഥാർത്ഥ്യ സാഹചര്യങ്ങൾ
- **[→ അധ്യായം 1 ആരംഭിക്കുക](./01-IntroToGenAI/README.md)**

### **അധ്യായം 2: ഡെവലപ്പ്മെന്റ് പരിസ്ഥിതി സെറ്റപ്പ്**
- **ബഹു-പ്രൊവൈഡർ കോൺഫിഗറേഷൻ**: GitHub മോഡലുകൾ, Azure OpenAI, OpenAI ജാവ SDK ഇന്റഗ്രേഷനുകൾ സജ്ജമാക്കൽ
- **സ്പ്രിംഗ് ബൂട്ട് + സ്പ്രിംഗ് എഐ**: എന്റർപ്രൈസ് എഐ ആപ്ലിക്കേഷൻ വികസനത്തിന് മികച്ച രീതികൾ
- **GitHub മോഡലുകൾ**: പ്രോട്ടോടൈപ്പിംഗിനും പഠനത്തിനും സൗജന്യ എഐ മോഡൽ ആക്‌സസ് (ക്രെഡിറ്റ് കാർഡ് ആവശ്യമില്ല)
- **ഡെവലപ്പ്മെന്റ് ടൂളുകൾ**: ഡോക്കർ കണ്ടെയ്‌നറുകൾ, VS കോഡ്, GitHub കോഡ്സ്പേസുകൾ കോൺഫിഗറേഷൻ
- **[→ അധ്യായം 2 ആരംഭിക്കുക](./02-SetupDevEnvironment/README.md)**

### **അധ്യായം 3: കോർ ജനറേറ്റീവ് എഐ സാങ്കേതിക വിദ്യകൾ**
- **പ്രോംപ്റ്റ് എഞ്ചിനീയറിംഗ്**: മികച്ച എഐ മോഡൽ പ്രതികരണങ്ങൾക്കുള്ള സാങ്കേതിക വിദ്യകൾ
- **എംബെഡിംഗുകളും വെക്ടർ ഓപ്പറേഷനുകളും**: സെമാന്റിക് സെർച്ച്, സമാനതാ മാച്ചിംഗ് നടപ്പിലാക്കൽ
- **റിട്രീവൽ-ഓഗ്മെന്റഡ് ജനറേഷൻ (RAG)**: നിങ്ങളുടെ സ്വന്തം ഡാറ്റാ സ്രോതസുകളുമായി എഐ സംയോജനം
- **ഫംഗ്ഷൻ കോളിംഗ്**: കസ്റ്റം ടൂളുകളും പ്ലഗിനുകളും ഉപയോഗിച്ച് എഐ കഴിവുകൾ വിപുലീകരിക്കൽ
- **[→ അധ്യായം 3 ആരംഭിക്കുക](./03-CoreGenerativeAITechniques/README.md)**

### **അധ്യായം 4: പ്രായോഗിക ഉപയോഗങ്ങളും പ്രോജക്ടുകളും**
- **പെറ്റ് സ്റ്റോറി ജനറേറ്റർ** (`petstory/`): GitHub മോഡലുകളുമായി സൃഷ്ടിപരമായ ഉള്ളടക്ക സൃഷ്ടി
- **ഫൗണ്ടറി ലോക്കൽ ഡെമോ** (`foundrylocal/`): OpenAI ജാവ SDK ഉപയോഗിച്ച് ലോക്കൽ എഐ മോഡൽ സംയോജനം
- **MCP കാൽക്കുലേറ്റർ സർവീസ്** (`calculator/`): സ്പ്രിംഗ് എഐ ഉപയോഗിച്ച് അടിസ്ഥാന മോഡൽ കോൺടെക്സ്റ്റ് പ്രോട്ടോക്കോൾ നടപ്പാക്കൽ
- **[→ അധ്യായം 4 ആരംഭിക്കുക](./04-PracticalSamples/README.md)**

### **അധ്യായം 5: ഉത്തരവാദിത്വമുള്ള എഐ വികസനം**
- **GitHub മോഡലുകളുടെ സുരക്ഷ**: ഇൻബിൽറ്റ് ഉള്ളടക്ക ഫിൽട്ടറിംഗ്, സുരക്ഷാ സംവിധാനങ്ങൾ (ഹാർഡ് ബ്ലോക്കുകളും സോഫ്റ്റ് നിരസനങ്ങളും) പരീക്ഷണം
- **ഉത്തരവാദിത്വമുള്ള എഐ ഡെമോ**: ആധുനിക എഐ സുരക്ഷാ സംവിധാനങ്ങൾ പ്രായോഗികമായി കാണിക്കുന്ന ഹാൻഡ്‌സ്-ഓൺ ഉദാഹരണം
- **മികച്ച രീതികൾ**: നൈതിക എഐ വികസനത്തിനും വിനിയോഗത്തിനും ആവശ്യമായ മാർഗ്ഗനിർദ്ദേശങ്ങൾ
- **[→ അധ്യായം 5 ആരംഭിക്കുക](./05-ResponsibleGenAI/README.md)**

## അധിക വിഭവങ്ങൾ

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### ലാംഗ്‌ചെയിൻ
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### അസ്യൂർ / എഡ്ജ് / MCP / ഏജന്റുകൾ
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### ജനറേറ്റീവ് എഐ സീരീസ്
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### കോർ പഠനം
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![ആരംഭക്കാർക്കുള്ള IoT](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![ആരംഭക്കാർക്കുള്ള XR ഡെവലപ്പ്മെന്റ്](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### കോപൈലറ്റ് സീരീസ്
[![AI കൂട്ടായ പ്രോഗ്രാമിംഗിനുള്ള കോപൈലറ്റ്](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![C#/.NET-ക്കുള്ള കോപൈലറ്റ്](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![കോപൈലറ്റ് അഡ്വഞ്ചർ](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## സഹായം നേടുക

AI ആപ്പുകൾ നിർമ്മിക്കുന്നതിൽ നിങ്ങൾക്ക് തടസ്സം നേരിടുകയാണെങ്കിൽ അല്ലെങ്കിൽ എന്തെങ്കിലും ചോദ്യങ്ങളുണ്ടെങ്കിൽ, MCP-യെക്കുറിച്ചുള്ള ചർച്ചകളിൽ അനുഭവസമ്പന്നരായ ഡെവലപ്പർമാരും പഠനാർത്ഥികളും ചേർന്ന് സംസാരിക്കാം. ചോദ്യങ്ങൾ സ്വാഗതം ചെയ്യപ്പെടുന്ന, അറിവ് സ്വതന്ത്രമായി പങ്കുവെക്കുന്ന ഒരു പിന്തുണയുള്ള സമൂഹമാണ് ഇത്.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

നിങ്ങൾക്ക് ഉൽപ്പന്ന പ്രതികരണമോ നിർമ്മാണത്തിൽ പിഴവുകളോ ഉണ്ടെങ്കിൽ സന്ദർശിക്കുക:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**അസൂയാ**:  
ഈ രേഖ AI വിവർത്തന സേവനം [Co-op Translator](https://github.com/Azure/co-op-translator) ഉപയോഗിച്ച് വിവർത്തനം ചെയ്തതാണ്. നാം കൃത്യതയ്ക്ക് ശ്രമിച്ചെങ്കിലും, സ്വയം പ്രവർത്തിക്കുന്ന വിവർത്തനങ്ങളിൽ പിശകുകൾ അല്ലെങ്കിൽ തെറ്റുകൾ ഉണ്ടാകാമെന്ന് ദയവായി ശ്രദ്ധിക്കുക. അതിന്റെ മാതൃഭാഷയിലുള്ള യഥാർത്ഥ രേഖയാണ് പ്രാമാണികമായ ഉറവിടം എന്ന് പരിഗണിക്കേണ്ടതാണ്. നിർണായകമായ വിവരങ്ങൾക്ക്, പ്രൊഫഷണൽ മനുഷ്യ വിവർത്തനം ശുപാർശ ചെയ്യപ്പെടുന്നു. ഈ വിവർത്തനത്തിന്റെ ഉപയോഗത്തിൽ നിന്നുണ്ടാകുന്ന ഏതെങ്കിലും തെറ്റിദ്ധാരണകൾക്കോ തെറ്റായ വ്യാഖ്യാനങ്ങൾക്കോ ഞങ്ങൾ ഉത്തരവാദികളല്ല.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->