# ആരംഭക്കാർക്കുള്ള ജനറേറ്റീവ് AI - ജാവ എഡിഷൻ
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/ml/beg-genai-series.8b48be9951cc574c.webp)

**സമയം:** മുഴുവൻ വർക്ക്‌ഷോപ്പ് ആവശ്യമായ ഉപകരണങ്ങൾ ഇൻസ്റ്റാൾ ചെയ്യാതെ ഓൺലൈനിൽ പൂർത്തിയാക്കാം. പരിസ്ഥിതി ക്രമീകരണം 2 മിനുറ്റ് സമയം ആകുകയും സാമ്പിൾസ് പരിരീക്ഷിക്കുന്നത് 1-3 മണിക്കൂർ (പരിരീക്ഷണലവം അനുസരിച്ച്) എടുക്കുകയും ചെയ്യും.

> **ത്വരിതദിശ**
  
1. ഈ റിപ്പൊസിറ്ററി നിങ്ങളുടെ GitHub അക്കൗണ്ടിൽ Fork ചെയ്യുക  
2. **Code** → **Codespaces** ടാബ് → **...** → **New with options...** ക്ലിക്ക് ചെയ്യുക  
3. ഡിഫോൾട്ടുകളെ ഉപയോഗിക്കുക – ഹോസ്റ്റ് കോഴ്സിനായി ക്രിയേറ്റ് ചെയ്ത ഡവലപ്പ്മെന്റ് കണ്ടെയ്‌നർ തെരഞ്ഞെടുക്കും  
4. **Create codespace** ക്ലിക്ക് ചെയ്യുക  
5. പരിസ്ഥിതി റെഡിയായി വരാൻ ഏകദേശം 2 മിനുറ്റ് കാത്തിരിക്കുക  
6. നേരിട്ട് [ആദ്യം ഉദാഹരണത്തിലേക്ക് പോകുക](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)  

> **പ്രാദേശികമായി ക്ലോൺ ചെയ്യാൻ ആഗ്രഹമുണ്ടോ?**  
>  
> ഈ റിപ്പൊസിറ്ററിയിൽ 50-ക്ടത്തിൽ അധികം ഭാഷാ തർജ്ജമകൾ ഉൾക്കൊള്ളുന്നു, അതുകൊണ്ട് ഡൗൺലോഡ് വലുതാണ്. തർജ്ജമകൾ ഇല്ലാതെ ക്ലോൺ ചെയ്യാൻ sparse checkout ഉപയോഗിക്കുക:  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ഇതു കോഴ്‌സു പൂർത്തിയാക്കാൻ വേണ്ടതെല്ലാം വേഗത്തിലായുള്ള ഡൗൺലോഡുമായാണ് നൽകുന്നത്.

## മൾട്ടി-ഭാഷാ പിന്തുണ

### GitHub Action വഴി പിന്തുണയും (സ്വയം പ്രവർത്തനവും എല്ലായ്പ്പോഴും അപ്‌ഡേറ്റും)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](../my/README.md) | [Chinese (Simplified)](../zh-CN/README.md) | [Chinese (Traditional, Hong Kong)](../zh-HK/README.md) | [Chinese (Traditional, Macau)](../zh-MO/README.md) | [Chinese (Traditional, Taiwan)](../zh-TW/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Kannada](../kn/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Malayalam](./README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Nigerian Pidgin](../pcm/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../pt-BR/README.md) | [Portuguese (Portugal)](../pt-PT/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Telugu](../te/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)

## കോഴ്‌സ് ഘടനയും പഠനപഥവും

### **അദ്ധ്യായം 1: ജനറേറ്റീവ് AI-ലേക്കുള്ള പരിചയം**
- **മൂലഭൂത ആശയങ്ങൾ**: വലിയ ഭാഷാ മോഡലുകൾ, ടോക്കണുകൾ, ഇംബെഡിംഗ്സുകൾ, AI സാദ്ധ്യതകൾ മനസിലാക്കുക  
- **ജാവ AI ഇക്കോസിസ്റ്റം**: Spring AI, OpenAI SDK-കളുടെ അവലോകനം  
- **മോഡൽ സാന്ദർഭ പ്രോട്ടോക്കോൾ**: MCP പരിചയം, AI ഏജന്റുകളുടെ സംഭാഷണത്തിലെ പങ്ക്  
- **പ്രായോഗിക വിനിയോഗങ്ങൾ**: ചാറ്റ്‌ബോട്ടുകൾ, കോൺറെന്റ് ജനറേഷൻ लगायत യഥാർത്ഥ ലോക അനുഭവങ്ങൾ  
- **[→ അദ്ധ്യായം 1 ആരംഭിക്കുക](./01-IntroToGenAI/README.md)**

### **അദ്ധ്യായം 2: ഡവലപ്പ്മെന്റ് പരിസ്ഥിതി ക്രമീകരണം**
- **മൾട്ടി-പ്രൊവൈഡർ കോൺഫിഗറേഷൻ**: GitHub മോഡലുകൾ, Azure OpenAI, OpenAI ജാവ SDK-കളുടെ ഇന്റഗ്രേഷൻ  
- **Spring Boot + Spring AI**: എന്റർപ്രൈസ് AI ആപ്ലിക്കേഷൻ വികസനത്തിന് മികച്ച രീതികൾ  
- **GitHub മോഡലുകൾ**: പ്രോട്ടോട്ടൈപ്പിനും പഠനത്തിനും സൗജന്യ AI മോഡൽ ആക്‌സസ് (ക്രെഡിറ്റ് കാർഡ് ആവശ്യമില്ല)  
- **ഡവലപ്പ്മെന്റ് ടൂളുകൾ**: Docker കണ്ടെയ്‌നറുകൾ, VS കോഡ്, GitHub Codespaces കോൺഫിഗറേഷൻ  
- **[→ അദ്ധ്യായം 2 ആരംഭിക്കുക](./02-SetupDevEnvironment/README.md)**

### **അദ്ധ്യായം 3: പ്രധാന ജനറേറ്റീവ് AI തന്ത്രങ്ങൾ**
- **പ്രോംപ്റ്റ് എഞ്ചിനീയറിംഗ്**: മികച്ച AI മോഡൽ പ്രതികരണങ്ങൾക്കുള്ള സാങ്കേതിക വിദ്യകൾ  
- **ഇംബെഡിംഗ്സും വെക്റ്റർ ഓപ്പറേഷന്സും**: സെമാന്റിക് സെർച്ച്, സമാനത പരിശോധന നടപ്പാക്കുക  
- **Retrieval-Augmented Generation (RAG)**: നിങ്ങളുടെ ഡാറ്റ ഉറവിടങ്ങളുമായി AI സംയോജിപ്പിക്കൽ  
- **ഫിക്ഷൻ കോളിങ്ങ്**: കസ്റ്റം ടൂളുകളുടെയും പ്ലഗിനുകളുടെയും സഹായത്തോടെ AI കഴിവുകൾ വിപുലീകരിക്കുക  
- **[→ അദ്ധ്യായം 3 ആരംഭിക്കുക](./03-CoreGenerativeAITechniques/README.md)**

### **അദ്ധ്യായം 4: പ്രായോഗിക ഉപയോഗങ്ങൾ & പ്രോജెక్టുകൾ**
- **Pet Story Generator** (`petstory/`): GitHub മോഡലുകളിൽ അടിസ്ഥാനമാക്കിയുള്ള സൃഷ്ടിപരമായ ഉള്ളടക്കം  
- **Foundry Local Demo** (`foundrylocal/`): OpenAI ജാവ SDK ഉപയോഗിച്ച് പ്രാദേശിക AI മോഡൽ സംയോജനം  
- **MCP Calculator Service** (`calculator/`): Spring AI ഉപയോഗിച്ചുള്ള അടിസ്ഥാന Model Context Protocol നടപ്പാക്കൽ  
- **[→ അദ്ധ്യായം 4 ആരംഭിക്കുക](./04-PracticalSamples/README.md)**

### **അദ്ധ്യായം 5: ഉത്തരവാദിത്വമുള്ള AI വികസനം**
- **GitHub മോഡലുകളുടെ സുരക്ഷ**: ഇൻബിൽറ്റ് ഉള്ളടക്കം ഫ്രിൽറ്ററിംഗ്, സുരക്ഷാ സംവിധാനം പരീക്ഷണം (ഹാർഡ് ബ്ലോക്കുകളും സോഫ്റ്റ് നിരാകരണങ്ങളും)  
- **ഉത്തരവാദിത്വ AI ഡെമോ**: ആധുനിക AI സുരക്ഷാ സംവിധാനങ്ങൾ യഥാർത്ഥ പ്രവർത്തനത്തിൽ കാണിക്കുന്ന ഹാൻഡ്‌സ്-ഓൺ ഉദാഹരണം  
- **മികച്ച പ്രാക്റ്റിസുകൾ**: നൈതിക AI വികസനത്തിനും വിനിയോഗത്തിനും അസാധാരണ മാർഗ്ഗനിർദ്ദേശങ്ങൾ  
- **[→ അദ്ധ്യായം 5 ആരംഭിക്കുക](./05-ResponsibleGenAI/README.md)**

## അധിക വിഭവങ്ങൾ

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
[![ആരംഭകർക്കുള്ള IoT](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![ആരംഭകർക്കുള്ള XR ഡെവലപ്മെന്റ്](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### കോപ്പൈലറ്റ് പരമ്പര
[![AI കൂട്ടാളിപ്പയോഗത്തിന് കോപ്പൈലറ്റ്](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![C#/.NET용 കോപ്പൈലറ്റ്](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![കോപ്പൈലറ്റ് ആഡ്‌വഞ്ചർ](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## സഹായം നേടുക

AI ആപ്പുകൾ നിർമ്മിക്കുന്നതിൽ നിങ്ങൾക്ക് തടസംപെട്ടാൽ അല്ലെങ്കിൽ എന്തെങ്കിലും ചോദ്യം ഉണ്ടെങ്കിൽ, MCP സംബന്ധിച്ച ചർച്ചകളിൽ അനുഭവസമ്പന്നരായ ഡെവലപ്പർമാർക്കും മറ്റ് പഠിക്കുന്നവർക്കുമായി ചേരുക. ചോദ്യങ്ങൾക്ക് സ്വാഗതം പറയുന്ന, അറിവ് സ്വതന്ത്രമായി പങ്കിടുന്ന പിന്തുണയുള്ള സമൂഹമാണ് ഇത്.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

ഉൽപ്പന്ന ഫീഡ്ബാക്ക് നൽകാനോ നിർമ്മാണത്തിൽ പിഴവുകൾ വന്നാൽ സന്ദർശിക്കുക:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ജാഗ്രതാ അറിയിപ്പ്**:  
ഈ ദസ്താവേഖരം AI വിവർത്തന സേവനം [Co-op Translator](https://github.com/Azure/co-op-translator) ഉപയോഗിച്ച് വിവർത്തനം ചെയ്തതാണ്. ഞങ്ങൾ ശരിയായ വിവർത്തനത്തിന് ശ്രമിക്കുന്നുവെങ്കിലും, ഓട്ടോമാറ്റിക്ക് വിവർത്തനങ്ങളിൽ തട്ടിപ്പുകൾ അല്ലെങ്കിൽ തെറ്റുകൾ ഉണ്ടായേക്കാമെന്ന് ദയവായി ശ്രദ്ധിക്കുക. സ്വദേശഭാഷയിലെ അസൽ ദസ്താവേഖരം അതിന്റെ പ്രാമാണിക സ്രോതസ്സായി കണക്കാക്കേണ്ടതാണ്. നിർണായകമായ വിവരങ്ങൾക്കായി, പ്രൊഫഷണൽ മനുഷ്യ വിവർത്തനം ശുപാർശ ചെയ്യുന്നു. ഈ വിവർത്തനം ഉപയോഗിക്കുന്നതിൽ നിന്ന് ഉണ്ടായ任何误解或误释我们概不负责。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->