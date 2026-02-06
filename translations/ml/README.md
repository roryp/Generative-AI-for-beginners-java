# ആരംഭക്കാർക്ക് ജെനറേറ്റീവ് AI - ജാവാ പതിപ്പ്
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/ml/beg-genai-series.8b48be9951cc574c.webp)

**സമയം**: ഞടൻ സെറ്റ് അപ് വേണ്ടാതെ മുഴുവൻ വേർക്ക്ഷോപ്പ് ഓൺലൈനിൽ പൂർത്തിയാക്കാം. പരിസ്ഥിതി ക്രമീകരണം 2 മിനിറ്റ് മാത്രമേ എടുക്കുകയുള്ളൂ, സാമ്പിളുകൾ പരിശോധിക്കാൻ 1-3 മണിക്കൂര്‍ വരെ ആയിരിക്കും, പരിശോധിക്കൽ ആഴത്തിനനുസരിച്ച്.

> **വേഗത്തിലും തുടങ്ങാം** 

1. ഈ റിപ്പോസിറ്ററി നിങ്ങളുടെ GitHub അക്കൗണ്ടിലേക്ക് Fork ചെയ്യുക
2. ക്ലിക്ക് ചെയ്യുക **Code** → **Codespaces** tab → **...** → **New with options...**
3. ഡിഫോൾട്ട് മാറ്റങ്ങളുള്ളവ ഉപയോഗിക്കുക – ഈ കോഴ്സിനായി സൃഷ്ടിച്ച Development container ഇത് തിരഞ്ഞെടുക്കും
4. ക്ലിക്ക് ചെയ്യുക **Create codespace**
5. പരിസ്ഥിതി സജ്ജമാകാൻ ഏകദേശം 2 മിനിറ്റ് കാത്തിരിക്കണം
6. നേരിട്ട് ചാടുക [The first example](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **സ്ഥലീയമായി ക്ലോൺ ചെയ്യുവാൻ ആഗ്രഹിക്കുന്നു?**
>
> ഈ റിപ്പോസിറ്ററിയിൽ 50+ ഭാഷകളിലുളള തർജ്ജമകൾ ഉൾക്കൊള്ളുന്നതിനാൽ ഡൗൺലോഡ് വലുതാണ്. തർജ്ജമകൾ ഇല്ലാതെ ക്ലോൺ ചെയ്യുവാൻ sparse checkout ഉപയോഗിക്കുക:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ഇതിലൂടെ നിങ്ങൾക്ക് കോഴ്സ് പൂർത്തിയാക്കാൻ ആവശ്യമുള്ള എല്ലാ വസ്തുക്കളും ഏർപ്പെടും, കൂടാതെ വളരെ വേഗത്തിൽ ഡൗൺലോഡ് ചെയ്യും.


## ബഹുഭാഷാ പിന്തുണ

### GitHub ആക്ഷൻ മുഖേന പിന്തുണയ്ക്കുന്നു (സ്വയം പ്രവർത്തിക്കുന്നതും എല്ലായ്പ്പോഴും പുതുക്കപ്പെട്ടതും)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[അറബിക്](../ar/README.md) | [ബംഗാളി](../bn/README.md) | [ബൾഗേറിയൻ](../bg/README.md) | [ബർമീസ് (മയനുമാർ)](../my/README.md) | [ചൈനീസ് (സിംപ്ലിഫിട്)](../zh-CN/README.md) | [ചൈനീസ് (പരമ്പരാഗതം, ഹോങ്കോങ്)](../zh-HK/README.md) | [ചൈനീസ് (പരമ്പരാഗതം, മകാവ്)](../zh-MO/README.md) | [ചൈനീസ് (പരമ്പരാഗതം, തായ്‌വാൻ)](../zh-TW/README.md) | [ക്രൊയേഷ്യൻ](../hr/README.md) | [ചെക്ക്](../cs/README.md) | [ഡാനിഷ്](../da/README.md) | [ഡച്ച്](../nl/README.md) | [എസ്റ്റോണിയൻ](../et/README.md) | [ഫിന്നിഷ്](../fi/README.md) | [ഫ്രഞ്ച്](../fr/README.md) | [ജർമ്മൻ](../de/README.md) | [ഗ്രീസ്](../el/README.md) | [ഹീബ്രു](../he/README.md) | [ഹിന്ദി](../hi/README.md) | [ഹംഗറിയൻ](../hu/README.md) | [ഇന്തോനേഷ്യൻ](../id/README.md) | [ഇറ്റാലിയൻ](../it/README.md) | [ജാപ്പനീസ്](../ja/README.md) | [കനഡ](../kn/README.md) | [കൊറിയൻ](../ko/README.md) | [ലിതുവേനിയൻ](../lt/README.md) | [മലേ](../ms/README.md) | [മലയാളം](./README.md) | [മരાઠി](../mr/README.md) | [നെപാളി](../ne/README.md) | [നൈജീരിയൻ പിഡ്ഗിൻ](../pcm/README.md) | [നോർവീജിയൻ](../no/README.md) | [പേർഷ്യൻ (ഫാർസി)](../fa/README.md) | [പോളീഷ്](../pl/README.md) | [പോർച്ചുഗീസ് (ബ്രസീൽ)](../pt-BR/README.md) | [പോർച്ചുഗീസ് (പോർച്ചുഗൽ)](../pt-PT/README.md) | [പഞ്ചാബി (ഗുരുമുഖി)](../pa/README.md) | [റൊമാനിയൻ](../ro/README.md) | [റഷ്യൻ](../ru/README.md) | [സെർബിയൻ (സിറിലിക്)](../sr/README.md) | [സ്ലോവാക്](../sk/README.md) | [സ്ലോവേനിയൻ](../sl/README.md) | [സ്പാനിഷ്](../es/README.md) | [സ്വാഹിലി](../sw/README.md) | [സ്വീഡിഷ്](../sv/README.md) | [ടാഗാലോഗ് (ഫിലിപ്പിനോ)](../tl/README.md) | [തമിൽ](../ta/README.md) | [തെലുഗു](../te/README.md) | [തായ്](../th/README.md) | [ടർക്കിഷ്](../tr/README.md) | [ഉക്രെയ്നിയൻ](../uk/README.md) | [ഉർദു](../ur/README.md) | [വിയറ്റ്നാമീസ്](../vi/README.md)

## കോഴ്‌സ് ഘടനയും പഠന വഴിയും

### **അദ്ധ്യായം 1: ജെനറേറ്റീവ് AI-യിലേക്ക് പരിചയം**
- **പ്രധാന ആലംബങ്ങൾ**: വലിയ ഭാഷാ മോഡലുകൾ, ടോക്കനുകൾ, എംബെഡിങ്ങുകൾ, AI കഴിവുകൾ എന്നിവയെക്കുറിച്ചുള്ള ബോധ്യം
- **ജാവ AI പരിസ്ഥിതി**: Spring AI, OpenAI SDK-കളുടെ അവലോകനം
- **മോഡൽ കോൺടെക്സ് പ്രോട്ടോക്കോൾ**: MCP രൂപവും AI ഏജന്റ് സംവാദത്തിൽ അതിന്റെ പങ്കും 
- **പ്രായോഗിക ഉപയോഗങ്ങൾ**: ചാറ്റ്‌ബോട്ടുകളും ഉള്ളടക്കം സൃഷ്ടാക്കലും ഉൾപ്പെടുന്ന യാഥാർത്ഥ്യ സാഹചര്യങ്ങൾ
- **[→ അദ്ധ്യായം 1 ആരംഭിക്കുക](./01-IntroToGenAI/README.md)**

### **അദ്ധ്യായം 2: ഡെവലപ്പ്മെന്റ് പരിസ്ഥിതി ക്രമീകരണം**
- **ബഹുവകുപ്പുകാരൻ ക്രമീകരണം**: GitHub മോഡലുകൾ, Azure OpenAI, OpenAI ജാവ SDK-കളുടെ സംയോജനം
- **Spring Boot + Spring AI**: എന്റർപ്രൈസ് AI ആപ്ലിക്കേഷൻ ഡെവലപ്പ്മെന്റിനുള്ള മികച്ച രീതികൾ
- **GitHub മോഡലുകൾ**: ഫ്രീ AI മോഡൽ ആക്‌സസ്, പ്രോട്ടോട്ടൈപ്പ് നിർമ്മാണത്തിനും പഠനത്തിനും (ക്രെഡിറ്റ് കാർഡ് ആവശ്യമില്ല)
- **ഡെവലപ്പ്മെന്റ് ടൂൾസ്**: ഡോക്കർ കണ്ടെയ്‌നറുകൾ, VS Code, GitHub കോഡ്സ്പേസിന്റെ ക്രമീകരണം
- **[→ അദ്ധ്യായം 2 ആരംഭിക്കുക](./02-SetupDevEnvironment/README.md)**

### **അദ്ധ്യായം 3: കോർ ജെനറേറ്റീവ് AI സാങ്കേതിക വിദ്യകൾ**
- **പ്രോംപ്റ്റ് എഞ്ചിനീയറിംഗ്**: മികച്ച AI മോഡൽ പ്രതികരണങ്ങൾ ലഭിക്കാൻ സാങ്കേതിക വിദ്യകൾ
- **എംബെഡിങ്ങുകൾ & വെക്ടർ ഓപറേഷനുകൾ**: സെമാന்டിക് സെർച്ചും സമാനത മാച്ചിംഗും നടപ്പിലാക്കുക
- **റീട്രീവൽ-ഓഗ്മെന്റഡ് ജനറേഷൻ (RAG)**: നിങ്ങളുടെ സ്വന്തം ഡೇಟാ സ്രോതസുകളുമായി AI യുടെ കൂട്ടായ പ്രവർത്തനം
- **ഫങ്‌ഷൻ കോൾ ചെയ്യൽ**: കസ്റ്റം ടൂളുകളും പ്ലഗിനുകളും ഉപയോഗിച്ച് AI കഴിവുകൾ വികസിപ്പിക്കുക
- **[→ അദ്ധ്യായം 3 ആരംഭിക്കുക](./03-CoreGenerativeAITechniques/README.md)**

### **അദ്ധ്യായം 4: പ്രായോഗിക ഉപയോഗങ്ങളും പ്രോജക്‌ടുകളും**
- **പെറ്റ് സ്റ്റോറി ജനറേറ്റർ** (`petstory/`): GitHub മോഡലുകൾ ഉപയോഗിച്ച് സൃഷ്ടിപരമായ ഉള്ളടക്ക നിർമ്മാണം
- **ഫൗണ്ടറി ലോക്കൽ ഡെമോ** (`foundrylocal/`): OpenAI ജാവ SDK ഉപയോഗിച്ച് ലോക്കൽ AI മോഡലിന്റെ സംയോജനം
- **MCP കാൽക്കുലേറ്റർ സർവീസ്** (`calculator/`): Spring AI ഉപയോഗിച്ച് അടിസ്ഥാന മോഡൽ കോൺടെക്സ് പ്രോട്ടോക്കോൾ നടപ്പാക്കൽ
- **[→ അദ്ധ്യായം 4 ആരംഭിക്കുക](./04-PracticalSamples/README.md)**

### **അദ്ധ്യായം 5: ഉത്തരവാദിത്വമുള്ള AI വികസനം**
- **GitHub മോഡലുകളുടെ സുരക്ഷ**: നിർമ്മിച്ചിരിക്കുന്ന ഉള്ളടക്കം ഫിൽട്ടറിംഗ്, സുരക്ഷാ സംവിധാനങ്ങൾ (ഹാർഡ് ബ്ലോക്കുകളും സോഫ്‌റ്റ് നിരസലുകളും) പരീക്ഷിക്കുക
- **ഉത്തരവാദിത്വ AI ഡെമോ**: ആധുനിക AI സുരക്ഷാ സംവിധാനങ്ങൾ എങ്ങനെ പ്രായോഗികമായി പ്രവർത്തിക്കുന്നുവെന്ന് കൈകളോടെ കാണിക്കുന്ന ഉദാഹരണം
- **മികച്ച രീതികൾ**: നീതിമാൻ AI വികസനത്തിനും വിനിയോഗത്തിനും ആവശ്യമായ നിർദ്ദേശങ്ങൾ
- **[→ അദ്ധ്യായം 5 ആരംഭിക്കുക](./05-ResponsibleGenAI/README.md)**

## അധിക മാർഗ്ഗങ്ങൾ

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain for Beginners](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / Edge / MCP / Agents
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Generative AI Series
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
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### കോപൈലറ്റ് സീരീസ്
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## സഹായം നേടുക

AI ആപ്പുകൾ നിർമ്മിക്കുന്നതിൽ നിങ്ങൾ കുടുങ്ങുകയോ എന്തെങ്കിലും ചോദിക്കുന്നുണ്ടോ? MCPയെക്കുറിച്ച് fellow learners ഉം പരിചയസമ്പന്നരായ ഡെവലപ്പർമാരുമായി ചർച്ചകളിൽ പങ്കെടുക്കൂ. ചോദ്യങ്ങൾക്ക് സ്വീകരണമുള്ള, അറിവ് സ്വതന്ത്രമായി പങ്കു വെക്കുന്ന ഒരു സഹകരണ സമൂഹമാണ് ഇത്.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

നിർമിക്കുമ്പോൾ ഉൽപ്പന്ന ഫീഡ്ബാക്ക് അല്ലെങ്കിൽ പിശകുകൾ ഉണ്ടെങ്കിൽ സന്ദർശിക്കുക:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**അസ്വീകാരം**:  
ഈ രേഖ AI പരിഭാഷാ സേവനം [Co-op Translator](https://github.com/Azure/co-op-translator) ഉപയോഗിച്ച് പരിഭാഷപ്പെടുത്തിയതാണ്. ഞങ്ങൾ കൃത്യമായ പരിഭാഷ നൽകാൻ ശ്രമിച്ചതെങ്കിലും, ഓട്ടോമാറ്റഡ് പരിഭാഷയിൽ തെറും അഴുക്ക് പിഴവുകൾ ഉണ്ടായിരിക്കാം എന്നതു ശ്രദ്ധിക്കുക. പരമാധികൃത ഉറവിടമായി അടുത്തനടപ്പിൽ ഉള്ള യഥാർത്ഥ ഭാഷയിലെ രേഖ പരിഗണിക്കുക. പ്രധാനപ്പെട്ട വിവരങ്ങൾക്ക് പ്രൊഫഷണൽ മാനുഷിക പരിഭാഷ നിർദ്ദേശിക്കപ്പെടുന്നു. ഈ പരിഭാഷയുടെ ഉപയോഗത്തിൽ ഉണ്ടായ ഏത് തെറ്റിദ്ധാരണകൾക്കും നാം ഉത്തരവാദികളല്ല.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->