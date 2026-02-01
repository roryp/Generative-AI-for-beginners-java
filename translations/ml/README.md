# തുടക്കക്കാർക്കായുള്ള ജനറേറ്റീവ് എഐ - ജാവ എഡിഷൻ
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/ml/beg-genai-series.8b48be9951cc574c.webp)

**സമയം സമർപ്പണം**: ലോക്കൽ സെറ്റപ്പ് ഇല്ലാതെ മുഴുവൻ വർക്‌ഷോപ്പ് ഓൺലൈനിൽ കഴിയാവുന്നതാണ്. എൻവയോൺമെന്റ് സെറ്റപ്പ് നേടാൻ 2 മിനിട്ടും സാമ്പിളുകൾ പരിശോധിക്കാൻ 1-3 മണിക്കൂറുമാണ് ആഴ കുറിച്ചറിയുന്നതിന് ആവശ്യമായ സമയം.

> **വേഗം ആരംഭിക്കുക** 

1. ഈ റെപ്പോസിറ്ററി നിങ്ങളുടെ GitHub അക്കൗണ്ടിലേക്ക് ഫോർക്ക് ചെയ്യുക
2. **Code** → **Codespaces** ടാബ് → **...** → **New with options...** ക്ലിക്ക് ചെയ്യുക
3. ഡിഫോൾട്ടുകൾ ഉപയോഗിക്കുക – ഇതിലൂടെ ഈ കോഴ്സിന് രൂപകല്പന ചെയ്ത ഡെവലപ്പ്മെന്റ് കൺടെയ്‌നർ തിരഞ്ഞെടുക്കും
4. **Create codespace** ക്ലിക്ക് ചെയ്യുക
5. എൻവയോൺമെന്റ് സജ്ജമാകാൻ ഏകദേശം 2 മിനിറ്റ് കാത്തിരിക്കുക
6. നേരിട്ട് ചാടുക [ആദ്യ ഉദാഹരണത്തിലേക്ക്](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **ലോക്കലായി ക്ലോൺ ചെയ്യാൻ താത്പര്യമുണ്ടോ?**
>
> ഈ റെപ്പോസിറ്ററിയിൽ 50 ലധികം ഭാഷാ പരിഭാഷകൾ ഉൾക്കൊള്ളുന്നു, ഇത് ഡൗൺലോഡ് വലുപ്പം വൻമാക്കുന്നു. പരിഭാഷകൾ ഇല്ലാതെ ക്ലോൺ ചെയ്യാൻ sparse checkout ഉപയോഗിക്കുക:  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ഇതിലൂടെ കോഴ്സ് പൂർത്തിയാക്കാൻ ആവശ്യമായ എല്ലാ സാമഗ്രികളും വളരെ വേഗത്തിൽ ലഭിക്കും.


## ബഹുഭാഷാ പിന്തുണ

### GitHub ആക്ഷൻ മുഖേന പിന്തുണ (സ്വയംപ്രവർത്തകരായും ചെറുതായി അപ്‌ഡേറ്റായും)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[അറബി](../ar/README.md) | [ബംഗാളി](../bn/README.md) | [ബൾഗേറിയൻ](../bg/README.md) | [ബർമീസ് (മയാൻമാർ)](../my/README.md) | [ചൈനീസ് (സിംപ്ലിഫൈഡ്)](../zh-CN/README.md) | [ചൈനീസ് (രെഗുലർ, ഹോങ്കോങ്ക്)](../zh-HK/README.md) | [ചൈനീസ് (രെഗുലർ, മാക്കാവു)](../zh-MO/README.md) | [ചൈനീസ് (രെഗുലർ, തായ്‌വാൻ)](../zh-TW/README.md) | [ക്രൊയേഷ്യൻ](../hr/README.md) | [ചെക്ക്](../cs/README.md) | [ഡാനിഷ്](../da/README.md) | [ഡച്ച്](../nl/README.md) | [എസ്റ്റോണിയൻ](../et/README.md) | [ഫിന്നിഷ്](../fi/README.md) | [ഫ്രഞ്ച്](../fr/README.md) | [ജർമ്മൻ](../de/README.md) | [ഗ്രീക്ക്](../el/README.md) | [ഹീബ്രു](../he/README.md) | [ഹിന്ദി](../hi/README.md) | [ഹംഗേറിയൻ](../hu/README.md) | [ഇന്തോനേഷ്യൻ](../id/README.md) | [ഇറ്റാലിയൻ](../it/README.md) | [ജാപ്പനീസ്](../ja/README.md) | [കന്നഡ](../kn/README.md) | [കൊറിയൻ](../ko/README.md) | [ലിത്വേനിയൻ](../lt/README.md) | [മലയ്‌](../ms/README.md) | [മലയാളം](./README.md) | [മറാത്തി](../mr/README.md) | [നേപ്പാൾ](../ne/README.md) | [നൈജീരിയൻ പിബ്ജിൻ](../pcm/README.md) | [നോർവീജിയൻ](../no/README.md) | [പെർഷ്യൻ (ഫാർസി)](../fa/README.md) | [പോളിഷ്](../pl/README.md) | [പോർച്ചുഗീസ് (ബ്രസീൽ)](../pt-BR/README.md) | [പോർച്ചുഗീസ് (പോർച്ചുഗൽ)](../pt-PT/README.md) | [പാൻജാബി (ഗുരുമുഖി)](../pa/README.md) | [റൊമാനിയൻ](../ro/README.md) | [റഷ്യൻ](../ru/README.md) | [സെർബിയൻ (സിറിലിക്ഗ്രാഫി)](../sr/README.md) | [സ്ലൊവാക്](../sk/README.md) | [സ്ലോവേനിയൻ](../sl/README.md) | [സ്പാനിഷ്](../es/README.md) | [സ്വാഹിലി](../sw/README.md) | [സ്വീഡിഷ്](../sv/README.md) | [തഗാലോഗ് (ഫിലിപ്പീനോ)](../tl/README.md) | [തമിഴ്](../ta/README.md) | [തെലുങ്ക്](../te/README.md) | [തായ്](../th/README.md) | [തുർക്കി](../tr/README.md) | [ഉക്രേനിയൻ](../uk/README.md) | [ഉർදු](../ur/README.md) | [വിയറ്റ്നാമീസ്](../vi/README.md)

> **ലോക്കലായി ക്ലോൺ ചെയ്യാൻ താത്പര്യമുണ്ടോ?**

> ഈ റെപ്പോസിറ്ററിയിൽ 50 ലധികം ഭാഷാ പരിഭാഷകൾ ഉൾക്കൊള്ളുന്നു, ഇത് ഡൗൺലോഡ് വലുപ്പം വൻമാക്കുന്നു. പരിഭാഷകൾ ഇല്ലാതെ ക്ലോൺ ചെയ്യാൻ sparse checkout ഉപയോഗിക്കുക:  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ഇതിലൂടെ കോഴ്സ് പൂർത്തിയാക്കാൻ ആവശ്യമായ എല്ലാ സാമഗ്രികളും വളരെ വേഗത്തിൽ ലഭിക്കും.
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## കോഴ്‌സ് ഘടനയും പഠന മാർഗ്ഗവും

### **അധ്യായം 1: ജനറേറ്റീവ് എഐക്ക് പ്രവേശനം**
- **പ്രധാന ആശയങ്ങൾ**: വലിയ ഭാഷാ മോഡലുകൾ, ടോക്കൺസ്, എംബെഡിംഗ്സ്, എഐ ശേഷികൾ മനസ്സിലാക്കൽ
- **ജാവ എഐ വ്യവസ്ഥ**: സ്പ്രിംഗ് എഐയും ഓപ്പൺഎഐ SDKകളും അവലോകനം
- **മോഡൽ കോൺടെക്സ്റ്റ് പ്രോട്ടോക്കോൾ**: MCP പരിചയം, എഐ ഏജൻസിന്റെ ആശയവിനിമയത്തിലെ പങ്ക്
- **പ്രായോഗിക പ്രയോഗങ്ങൾ**: ചാറ്റ്ബോറ്റുകളും ഉള്ളടക്ക സൃഷ്ടികളും ഉൾപ്പെടുന്ന യഥാർത്ഥ സാന്ദർഭങ്ങൾ
- **[→ അധ്യായം 1 ആരംഭിക്കുക](./01-IntroToGenAI/README.md)**

### **അധ്യായം 2: വികസന പരിസരസജ്ജീകരണം**
- **ബഹുമൂല്യദായക കൺഫിഗറേഷൻ**: GitHub മോഡലുകൾ, ആസ്യൂർ ഓപ്പൺഎഐ, ഓപ്പൺഎഐ ജാവ SDK സംയോജനം
- **സ്പ്രിംഗ് ബൂട്ട് + സ്പ്രിംഗ് എഐ**: എൻറപ്രൈസ് എഐ ആപ്ലിക്കേഷൻ വികസനത്തിന് മികച്ച രീതികൾ
- **GitHub മോഡലുകൾ**: പ്രോട്ടോട്ടൈപ്പിംഗിനും പഠനത്തിനും സൗജന്യ എഐ മോഡലുകൾ (ക്രെഡിറ്റ് കാർഡ് വേണ്ട)
- **വികസന ഉപകരണങ്ങൾ**: ഡോക്കർ കൺടെയ്‌നറുകൾ, VS കോഡ്, GitHub കോഡ്സ്പേസുകൾ സജ്ജീകരണം
- **[→ അധ്യായം 2 ആരംഭിക്കുക](./02-SetupDevEnvironment/README.md)**

### **അധ്യായം 3: കോർ ജനറേറ്റീവ് എഐ സാങ്കേതിക വിദ്യകൾ**
- **പ്രോംപ്‌റ്റ് എഞ്ചിനിയറിങ്**: എഐ മോഡലുകളുടെ മികച്ച പ്രതികരണങ്ങളും നടപടികളും
- **എംബെഡിംഗ്സ് & വെക്ടർ ഓപ്പറേഷനുകൾ**: സെമാന്റിക് തേടൽ, സാമ്യം കണ്ടെത്തൽ നടപ്പിലാക്കൽ
- **റിട്രീവൽ-ഓഗ്മെന്റഡ് ജനറേഷൻ (RAG)**: നിങ്ങളുടെ താൻറിയുമായി എഐ സംയോജനം
- **ഫംഗ്ഷൻ കോല്ലിംഗ്**: കസ്റ്റം ഉപകരണങ്ങളോടും പ്ലഗിൻസോടും എഐ ശേഷി വർദ്ധിപ്പിക്കൽ
- **[→ അധ്യായം 3 ആരംഭിക്കുക](./03-CoreGenerativeAITechniques/README.md)**

### **അധ്യായം 4: പ്രായോഗിക പ്രയോഗങ്ങളും പ്രോജക്റ്റുകളും**
- **പെറ്റ് സ്റ്റോറി ജനറേറ്റർ** (`petstory/`): GitHub മോഡലുകൾ ഉപയോഗിച്ചുള്ള സൃഷ്ടിപരമായ ഉള്ളടക്ക സൃഷ്ടി
- **ഫൗണ്ട്രി ലോക്കൽ ഡെമോ** (`foundrylocal/`): ഓപ്പൺഎഐ ജാവ SDK ഉപയോഗിച്ച് ലോക്കൽ എഐ മോഡൽ സംയോജനം
- **MCP കാൽക്കുലേറ്റർ സേവനം** (`calculator/`): സ്പ്രിംഗ് എഐ ഉപയോഗിച്ച് അടിസ്ഥാന മോഡൽ കോൺടെക്സ്റ്റ് പ്രോട്ടോക്കോൾ നടപ്പാക്കൽ
- **[→ അധ്യായം 4 ആരംഭിക്കുക](./04-PracticalSamples/README.md)**

### **അധ്യായം 5: ഉത്തരവാദിത്വമുള്ള എഐ വികസനം**
- **GitHub മോഡലുകളുടെ സുരക്ഷ**: ഇൻ-ബിൽറ്റ് ഉള്ളടക്ക ഫിൽട്ടറിംഗ്, സുരക്ഷാ സംവിധാനം (കഠിന നിരോധനങ്ങൾ, മൃദുവായ നിരസനങ്ങൾ) പരീക്ഷിച്ചു കാണുക
- **ഉത്തരവാദിത്വമുള്ള എഐ ഡെമോ**: ആധുനിക എഐ സുരക്ഷാ സംവിധാനങ്ങൾ എങ്ങനെ പ്രവർത്തിക്കുന്നു എന്നതിന്റെ പ്രായോഗിക ഉദാഹരണം
- **മികച്ച രീതികൾ**: എഥിക്കൽ എഐ വികസനത്തിനും വിന്യാസത്തിനും ആവശ്യമായ നിർദ്ദേശങ്ങൾ
- **[→ അധ്യായം 5 ആരംഭിക്കുക](./05-ResponsibleGenAI/README.md)**

## അധിക ഉപാധികൾ

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### ലാംഗ്‌ചെയിൻ
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### ആസ്യൂർ / എഡ്ജ് / MCP / ഏജൻറുകൾ
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
 
### പ്രാഥമിക പഠനം
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)

[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### കോപൈലറ്റ് പരമ്പര
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## സഹായം നേടൽ

എന്റെ AI ആപ്ലിക്കേഷനുകൾ നിർമ്മിക്കുന്നതിന് പാടുപെടുകയാണെങ്കിൽ അല്ലെങ്കിൽ എന്തെങ്കിലും ചോദ്യങ്ങളുണ്ടെങ്കിൽ. MCP-യെക്കുറിച്ച് fellow learners and experienced developers-ഉടൻ ചർച്ചകളിൽ പങ്കെടുക്കുക. ചോദ്യങ്ങൾക്ക് സ്വാഗതം നൽകുന്ന കൂടാതെ അറിവ് സ്വതന്ത്രമായി പങ്കിടുന്ന ഒരു സഹായകമായ സമൂഹമാണ് അത്.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

നിങ്ങൾക്ക് ഉൽപ്പന്ന നടപടിക്രമങ്ങളിൽ ഫീഡ്‌ബാക്ക് അല്ലെങ്കിൽ പിഴവുകൾ ഉണ്ടെങ്കിൽ സന്ദർശിക്കുക:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**അസ്പഷ്ടതാ കുറിപ്പ്**:
ഈ ലേഖനം AI വിവർത്തന സേവനം [Co-op Translator](https://github.com/Azure/co-op-translator) ഉപയോഗിച്ച് വിവർത്തനം ചെയ്തതാണ്. നാം കൃത്യതിക്കറ്റ് ശ്രമിച്ചെങ്കിലും, യന്ത്ര വിവർത്തനങ്ങളിൽ പിശകുകളോ അസംബന്ധതകളോ ഉണ്ടാകാനുള്ള സാധ്യതയുണ്ട് എന്ന 점 ദയവായി ശ്രദ്ധിക്കുക. പ്രമാണത്തിന്റെ യഥാർത്ഥ ഭാഷയിലെ പതിപ്പ് സാക്ഷ്യസ്ഥതയുള്ള ഉറവിടമായി പരിഗണിക്കണം. നിർണായകമായ വിവരങ്ങൾക്ക്, പ്രൊഫഷണൽ മനുഷ്യ വിവർത്തനം നിർദ്ദേശിക്കുന്നു. ഈ വിവർത്തനം ഉപയോഗിച്ചതിനെത്തുടർന്ന് ഉണ്ടാകാവുന്ന തെറ്റിദ്ധാരണകൾക്കോ തെറ്റായ വ്യാഖ്യാനങ്ങൾക്കോ ഞങ്ങൾ ഉത്തരവാദിത്വം ഉണ്ടാക്കുന്നില്ല.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->