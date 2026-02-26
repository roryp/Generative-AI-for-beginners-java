# ആരംഭക്കാർക്ക് ജനറേറ്റീവ് എഐ - ജാവ എഡിഷൻ
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/ml/beg-genai-series.8b48be9951cc574c.webp)

**സമയം**: എല്ലാ വർക്ക്‌ഷോപ്പും ലോക്കൽ സെറ്റപ്പ് നടത്താതെ ഓൺലൈൻ പൂര്‍ത്തിയാക്കാനാകും. പരിസ്ഥിതി സെറ്റപ്പ് 2 മിനുട്ട് ആണ്, സാമ്പിളുകൾ പരിശോധിക്കാൻ 1-3 മണിക്കൂർ വരെ সময়മെടുക്കാം പരിശോധിക്കുന്ന വീതിക്കനുസരിച്ച്.

> **ത്വരിതപ്രാരംഭം** 

1. ഈ റെപ്പോസിറ്ററി നിങ്ങളുടെ GitHub അക്കൗണ്ടിലേക്ക് ഫോർക്ക് ചെയ്യുക
2. **Code** → **Codespaces** ടാബ് → **...** → **New with options...** ക്ലിക്ക് ചെയ്യുക
3. ഡിഫോൾട്ടുകൾ ഉപയോഗിക്കുക – ഇത് ഈ കോഴ്സിന് നിർമ്മിച്ച ഡെവലപ്പ്മെന്റ് കണ്ടെയ്‌നർ തിരഞ്ഞെടുക്കും
4. **Create codespace** ക്ലിക്ക് ചെയ്യുക
5. പരിസ്ഥിതി ഒരുക്കാൻ ~2 മിനുട്ട് കാത്തിരിക്കുക
6. നേരിട്ട് ചാടുക [ആദ്യ ഉദാഹരണത്തിലേക്ക്](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **ലോകൽ ക്ലോണിംഗ്‌ക്ക് ഇഷ്ടമാണോ?**
>
> ഈ റെപ്പോസിറ്ററിയിൽ 50-ലധികം ഭാഷാപരിവർത്തനങ്ങൾ ഉൾപ്പെടുന്നു, ഇത് ഡൗൺലോഡ് വലുപ്പം വളരെയധികം കൂട്ടുന്നു. ഭാഷാപരിവർത്തനങ്ങളില്ലാതെ ക്ലോൺ ചെയ്യാൻ sparse checkout ഉപയോഗിക്കുക:
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
> ഇത് കോഴ്‌സ് പൂർത്തിയാക്കാൻ ആവശ്യമായ എല്ലാം നല്കുന്നു ഒപ്പം ഡൗൺലോഡ് വേഗത വളരെ വർധിച്ചു.

## ബഹುഭാഷാ പിന്തുണ

### GitHub Action വഴി പിന്തുണ (സ്വയമേവനും എല്ലായ്പ്പോഴും അപ്-ടു-ഡേറ്റ്)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[അറബിക്](../ar/README.md) | [ബംഗാളി](../bn/README.md) | [ബൾഗേറിയൻ](../bg/README.md) | [ബർമീസ് (മ്യാൻമാർ)](../my/README.md) | [ചൈനീസ് (ലളിതీకൃതം)](../zh-CN/README.md) | [ചൈനീസ് (പരമ്പരാഗതം, ഹോങ്കോംഗ്)](../zh-HK/README.md) | [ചൈനീസ് (പരമ്പരാഗതം, മക്കാവു)](../zh-MO/README.md) | [ചൈനീസ് (പരമ്പരാഗതം, തായ്‌വാൻ)](../zh-TW/README.md) | [ക്രോയേഷ്യൻ](../hr/README.md) | [ചെക്ക്](../cs/README.md) | [ഡാനിഷ്](../da/README.md) | [ഡച്ച്](../nl/README.md) | [എസ്തോണിയൻ](../et/README.md) | [ഫിന്നിഷ്](../fi/README.md) | [ഫ്രഞ്ച്](../fr/README.md) | [ജർമ്മൻ](../de/README.md) | [ഗ്രീസ്](../el/README.md) | [ഹീബ്രു](../he/README.md) | [ഹിന്ദി](../hi/README.md) | [ഹങ്കേറിയൻ](../hu/README.md) | [ഇൻഡോനേഷ്യൻ](../id/README.md) | [ഇറ്റാലിയൻ](../it/README.md) | [ജാപ്പനീസ്](../ja/README.md) | [കനഡ](../kn/README.md) | [കൊറിയൻ](../ko/README.md) | [ലിതുവേയനിയൻ](../lt/README.md) | [മലായ്](../ms/README.md) | [മലയാളം](./README.md) | [മറാത്തി](../mr/README.md) | [നെപാളി](../ne/README.md) | [നൈജിേറിയൻ പിഡ്ജിൻ](../pcm/README.md) | [നോർവീജിയൻ](../no/README.md) | [പേർഷ്യൻ (ഫർഷി)](../fa/README.md) | [പോളിഷ്](../pl/README.md) | [പോർചുഗീസ് (ബ്രസീൽ)](../pt-BR/README.md) | [പോർചുഗീസ് (പോർച്ചുഗൽ)](../pt-PT/README.md) | [പഞ്ചാബി (ഗുർമുഖി)](../pa/README.md) | [റോമേയൻ](../ro/README.md) | [റഷ്യൻ](../ru/README.md) | [സെര്‍ബിയൻ (സില്ലബിക്)](../sr/README.md) | [സ്ലൊവാക്](../sk/README.md) | [സ്ലോവേനിയൻ](../sl/README.md) | [സ്പാനിഷ്](../es/README.md) | [സ്വാഹിലി](../sw/README.md) | [സ്വീഡിഷ്](../sv/README.md) | [ടാഗാലോഗ് (ഫിലിപ്പിനോ)](../tl/README.md) | [തമിഴ്](../ta/README.md) | [തെಲುഗു](../te/README.md) | [ഥായ്](../th/README.md) | [ടർക്കിഷ്](../tr/README.md) | [ഉക്രേനിയൻ](../uk/README.md) | [ഉർദു](../ur/README.md) | [വിയറ്റ്നാമീസ്](../vi/README.md)

## കോഴ്‌സ് ഘടിപ്പിക്കൽ & പഠനപഥം

### **അദ്ധ്യായം 1: ജനറേറ്റീവ് എഐ എന്നാൽ എന്ത്?**
- **പ്രധാന ആശയങ്ങൾ**: വലിയ ഭാഷാ മോഡലുകൾ, ടോക്കൺ, എംബെഡ്ഡിങ്ങുകൾ, AI കഴിവുകൾ മനസ്സിലാക്കൽ
- **ജാവ എഐ പാരിസ്ഥിതികം**: സ്പ്രിംഗ് എഐയും ഓപ്പൺഎഐ SDKകൾ ഉം അവലോകനം
- **മോഡൽ കോൺടെക്സ്റ്റ് പ്രോട്ടോക്കോൾ**: MCP പരിചയം, എഐ ഏജന്റ് ആശയവിനിമയത്തിൽ അവന്റെ പങ്ക്
- **പ്രായോഗിക ഉപയോഗങ്ങൾ**: ചാറ്റ്ബോട്ടുകളും ഉള്ളടക്കം സൃഷ്ടിയും ഉൾപ്പെടെ യഥാർത്ഥ ലോക പരിസ്ഥിതികൾ
- **[→ അദ്ധ്യായം 1 ആരംഭിക്കുക](./01-IntroToGenAI/README.md)**

### **അദ്ധ്യായം 2: വികസന പരിസ്ഥിതി സെറ്റപ്**
- **മൾട്ടി-പ്രൊവൈഡർ കോൺഫിഗറേഷൻ**: GitHub മോഡലുകൾ, അസ്യൂർ ഓപ്പൺഎഐ, ഓപ്പൺഎഐ ജാവ SDK ഇന്റഗ്രേഷനുകൾ സജ്ജമാക്കുക
- **സ്പ്രിംഗ് ബൂട്ട് + സ്പ്രിംഗ് എഐ**: എന്റർപ്രൈസ് എഐ ആപ്ലിക്കേഷൻ വികസനത്തിനുള്ള മികച്ച സമീപനങ്ങൾ
- **GitHub മോഡലുകൾ**: പ്രോട്ടോടൈപ്പിംഗിനും പഠനത്തിനും സൗജന്യ AI മോഡൽ പ്രവേശനം (ക്രെഡിറ്റ് കാർഡ് ആവശ്യമില്ല)
- **വികസന ഉപകരണങ്ങൾ**: Docker കണ്ടെയ്‌നറുകൾ, VS കോഡ്, GitHub Codespaces കോൺഫിഗറേഷൻ
- **[→ അദ്ധ്യായം 2 ആരംഭിക്കുക](./02-SetupDevEnvironment/README.md)**

### **അദ്ധ്യായം 3: ജനറേറ്റീവ് എഐ പ്രാഥമിക സാങ്കേതിക വിദ്യകൾ**
- **പ്രോംപ്റ്റ് എഞ്ചിനീയറിംഗ്**: മികച്ച AI മോഡൽ പ്രതികരണങ്ങൾക്ക് സാങ്കേതിക വിദ്യകൾ
- **എംബെഡ്ഡിങ്ങുകളും വെക്ടർ പ്രവർത്തനങ്ങളും**: സിമാന്റിക് സേർച്ചും സാമ്യതാ മേധവും നടപ്പിലാക്കൽ
- **റിട്രീവൽ-ഓഗ്മെന്റഡ് ജനറേഷൻ (RAG)**: AI കോർക്കലുകളും നിങ്ങളുടെ ഡാറ്റ സ്രോതസ്സുകളും സംയോജിപ്പിക്കൽ
- **ഫംഗ്ഷൻ കോളിംഗ്**: കസ്റ്റം ടൂളുകളും പ്ലഗിൻസും ഉപയോഗിച്ച് AI കഴിവുകൾ വിപുലീകരിക്കൽ
- **[→ അദ്ധ്യായം 3 ആരംഭിക്കുക](./03-CoreGenerativeAITechniques/README.md)**

### **അദ്ധ്യായം 4: പ്രായോഗിക ആപ്ലിക്കേഷനുകളും പദ്ധതിരചനകളും**
- **പെറ്റ് സ്റ്റോറി ജനറേറ്റർ** (`petstory/`): GitHub മോഡലുകളുമായി സൃഷ്‌ടിപരമായ ഉള്ളടക്കം സൃഷ്ടി
- **Foundry ലോക്കൽ ഡെമോ** (`foundrylocal/`): OpenAI ജാവ SDKയുമായി ലോക്കൽ എഐ മോഡൽ സംയോജനം
- **MCP കാൽക്കുലേറ്റർ സർവീസ്** (`calculator/`): സ്പ്രിംഗ് എഐ ഉപയോഗിച്ച് അടിസ്ഥാന മോഡൽ കോൺടെക്സ്റ്റ് പ്രോട്ടോക്കോൾ നടപ്പാക്കൽ
- **[→ അദ്ധ്യായം 4 ആരംഭിക്കുക](./04-PracticalSamples/README.md)**

### **അദ്ധ്യായം 5: ഉത്തരവാദിത്വপূর্ণ AI വികസനം**
- **GitHub മോഡലുകൾ സുരക്ഷാ വ്യവസ്ഥകൾ**: ഇൻബിൽറ്റ് ഉള്ളടക്കം ഫിൽട്ടറിംഗ്, സുരക്ഷാ സംവിധാനങ്ങൾ പരീക്ഷണം (ഹാർഡ് ബ്ലോക്കുകളും സോഫ്റ്റ് നിരസനങ്ങളും)
- **ഉത്തരവാദ AI ഡെമോ**: ആധുനിക എഐ സുരക്ഷാ സിസ്റ്റങ്ങൾ പ്രായോഗികമായി എങ്ങനെയാണ് പ്രവർത്തിക്കുന്നത് എന്നതിന്റെ ഹാൻഡ്‌സ്-ഓൺ ഉദാഹരണം
- **മികച്ച രീതികൾ**: ധാർമ്മിക എഐ വികസനത്തെയും വിനിയോഗത്തെയുംക്കുറിച്ചുള്ള നിർബന്ധമായ മാർഗനിർദേശങ്ങൾ
- **[→ അദ്ധ്യായം 5 ആരംഭിക്കുക](./05-ResponsibleGenAI/README.md)**

## അധിക വനംകഴിവുകൾ

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain for Beginners](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / Edge / MCP / ഏജന്റുകൾ
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
 
### കോപിലോട്ട് സീരീസ്
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## സഹായം നേടുന്നത്

എഐ ആപുകൾ നിർമ്മിക്കുമ്പോൾ നിങ്ങൾക്ക് തടസ്സം വന്നാൽ അല്ലെങ്കിൽ എന്തെങ്കിലും സംശയങ്ങൾ ഉണ്ടാകുകയാണെങ്കിൽ MCP-യുമായി ബന്ധിപ്പിച്ചുള്ള അനുഭവസമ്പന്നരായ ഡെവലപ്പർമാരും fellow learners-ഉം ചർച്ചകളിൽ ചേരൂ. ചോദ്യങ്ങൾക്ക് സ്വാഗതം പറയുന്ന, അറിവ് സ്വതന്ത്രമായി പങ്കിടുന്ന ഒരു സഹകരണ സമൂഹമാണ് ഇത്.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

നിന്റെ ഉൽപ്പന്ന പ്രതികരണങ്ങൾ അല്ലെങ്കിൽ നിർമ്മാണത്തിലെ പിശകുകൾ ഉണ്ടെങ്കിൽ സന്ദർശിക്കുക:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**തള്ളിപ്പ്**:  
ഈ പ്രമാണം AI പരിഭാഷ സേവനമായ [Co-op Translator](https://github.com/Azure/co-op-translator) ഉപയോഗിച്ച് പരിഭാഷപ്പെടുത്തിയതാണ്. നാം യഥാർത്ഥതയ്ക്കായി പരിശ്രമിച്ചിരുന്നിട്ടും, ഓട്ടോമേറ്റഡ് പരിഭാഷകളിൽ പിശകുകളോ തെറ്റുകളോ ഉണ്ടാകാമെന്ന് ദയവായി ശ്രദ്ധിക്കുക. പ്രാഥമികമായി ഭാഷയിലുള്ള യഥാർത്ഥ പ്രമാണം ആധികാരികമായ ഉറവിടമായി പരിഗണിക്കപ്പെടണം. നിർണ്ണായകമായ വിവരങ്ങൾക്ക്, പ്രൊഫഷണൽ മനുഷ്യ പരിഭാഷ ഉയർന്ന മാനദണ്ഡമാണ്. ഈ പരിഭാഷ ഉപയോഗിച്ച് ഉണ്ടായേക്കാവുന്ന യാതൊരു തെറ്റുകഴിഞ്ഞോ തെറ്റായ വിവർത്തനങ്ങളുടെയും ഉത്തരവാദിത്വം ഞങ്ങൾ ഏറ്റെടുക്കുന്നില്ല.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->