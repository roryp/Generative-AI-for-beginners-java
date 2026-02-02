# ప్రారంభదారుల కోసం జనరేటివ్ AI - జావా ఎడిషన్
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/te/beg-genai-series.8b48be9951cc574c.webp)

**సమయ సమర్పణ**: మొత్తం వర్క్‌షాప్‌ను స్థానిక సెట్టప్ లేకుండానే ఆన్‌లైన్‌లో పూర్తి చేయవచ్చు. పరిసరాల సెట్టప్‌కు 2 నిమిషాలు పట్టుకుంటుంది, శాంపిళ్ళను అన్వేషించడానికి అనుభవ తీవ్రత పై ఆధారపడి 1-3 గంటలు అవసరం.

> **త్వరిత ప్రారంభం**

1. ఈ రిపోజిటరీని మీ GitHub ఖాతాకు ఫోర్క్ చేయండి
2. **Code** → **Codespaces** ట్యాబ్ పై క్లిక్ చేయండి → **...** → **New with options...** ఎంచుకోండి
3. డిఫాల్ట్స్‌ని ఉపయోగించండి – ఇది ఈ కోర్సు కోసం సృష్టించబడిన Development కంటెయినర్‌ని ఎంపిక చేసే అవకాశం కల్పిస్తుంది
4. **Create codespace** క్లిక్ చేయండి
5. పరిసరాలు సిద్ధంగా కావడానికి సుమారు 2 నిమిషాలు వేచి ఉండండి
6. నేరుగా [మొదటి ఉదాహరణకు](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) వెళ్లండి

> **స్థానికంగా క్లోన్ చేయాలనుకుంటున్నారా?**
>
> ఈ రిపోజిటరీలో 50+ భాషా అనువాదాలు ఉన్నాయి, ఇవి డౌన్లోడ్ పరిమాణాన్ని గణనీయంగా పెంచుతాయి. అనువాదాల లేకుండా క్లోన్ చేయడానికి, sparse checkout ఉపయోగించండి:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ఇది కోర్సు పూర్తి చేసేందుకు అవసరమైన అన్ని వాటిని త్వరితగతిన డౌన్లోడ్ చేయడానికి సహాయపడుతుంది.


## బహుభాషా మద్దతు

### GitHub చర్య ద్వారా మద్దతు ( ఆటోమేటెడ్ & ఎల్లప్పుడూ నవీకరించబడుతుంది)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[అరబిక్](../ar/README.md) | [బెంగోలీ](../bn/README.md) | [బల్గేరియన్](../bg/README.md) | [బర్మీస్ (మయన్మార్)](../my/README.md) | [చైనీస్ (సింప్లిఫైడ్)](../zh-CN/README.md) | [చైనీస్ (సాంప్రదాయ, హాంకాంగ్)](../zh-HK/README.md) | [చైనీస్ (సాంప్రదాయ, మకావ్)](../zh-MO/README.md) | [చైనీస్ (సాంప్రదాయ, తైవాన్)](../zh-TW/README.md) | [క్రోయేషియన్](../hr/README.md) | [చెక్](../cs/README.md) | [డానిష్](../da/README.md) | [డచ్](../nl/README.md) | [ఎస్టోనియన్](../et/README.md) | [ఫిన్నిష్](../fi/README.md) | [ఫ్రెంచ్](../fr/README.md) | [జర్మన్](../de/README.md) | [గ్రీకు](../el/README.md) | [హేబ్రూ](../he/README.md) | [హిందీ](../hi/README.md) | [హంగేరియన్](../hu/README.md) | [ఇండొనేషియన్](../id/README.md) | [ఇటాలియన్](../it/README.md) | [జపనీస్](../ja/README.md) | [కన్నడ](../kn/README.md) | [కొరియన్](../ko/README.md) | [లిథువేనియన్](../lt/README.md) | [మలాయి](../ms/README.md) | [మలయాళం](../ml/README.md) | [మరాఠి](../mr/README.md) | [నేపాలీ](../ne/README.md) | [నైజీరియన్ పిడ్జిన్](../pcm/README.md) | [నార్వీజియన్](../no/README.md) | [ఫార్సీ (పర్షియన్)](../fa/README.md) | [పోలిష్](../pl/README.md) | [పోర్చుగీస్ (బ్రెజిల్)](../pt-BR/README.md) | [పోర్చుగీస్ (పోర్చుగల్)](../pt-PT/README.md) | [పంజాబీ (గుర్ముఖీ)](../pa/README.md) | [రోమేనియన్](../ro/README.md) | [రష్యన్](../ru/README.md) | [సెర్బియన్ (సిరిలిక్)](../sr/README.md) | [స్లోవాక్](../sk/README.md) | [స్లోవేనియన్](../sl/README.md) | [స్పానిష్](../es/README.md) | [స్వాహిలీ](../sw/README.md) | [స్వీడిష్](../sv/README.md) | [టాగాలోగ్ (ఫిలిపినో)](../tl/README.md) | [తమిళ్](../ta/README.md) | [తెలుగు](./README.md) | [ಥೈ](../th/README.md) | [తుర్కిష్](../tr/README.md) | [ఉక్రెయినియన్](../uk/README.md) | [ఉర్దూ](../ur/README.md) | [వియత్నామీస్](../vi/README.md)

## కోర్సు నిర్మాణం & పాఠ్య రేఖ

### **అధ్యాయం 1: జనరేటివ్ AIకి పరిచయం**
- **ప్రధాన భావనలు**: లార్జ్ లాంగ్వేజ్ మోడల్స్, టోకెన్స్, ఎంబెడ్డింగ్స్ మరియు AI సామర్థ్యాల గురించి అవగాహన
- **జావా AI పర్యావరణం**: Spring AI మరియు OpenAI SDKల నిర్వచనం
- **మోడల్ కాంటెక్స్ట్ ప్రోటోకాల్**: MCPతో పరిచయం మరియు AI ఏజెంట్ కమ్యూనికేషన్‌లో దాని పాత్ర
- **ప్రాయోగిక అనువర్తనాలు**: చాట్‌బాట్స్ మరియు కంటెంట్ జనరేషన్ సహా వాస్తవ ప్రపంచ సన్నివేశాలు
- **[→ అధ్యాయం 1 ప్రారంభించండి](./01-IntroToGenAI/README.md)**

### **అధ్యాయం 2: అభివృద్ధి పరిసరాల సెట్టప్**
- **బహు-ప్రొవైడర్ కాన్ఫిగరేషన్**: GitHub Models, Azure OpenAI, మరియు OpenAI జావా SDK ఇంటిగ్రేషన్లు సెట్టప్ చేయండి
- **Spring Boot + Spring AI**: సంస్థా AI అప్లికేషన్ అభివృద్ధికి బెస్ట్ ప్రాక్టీసులు
- **GitHub Models**: ప్రోటోటైపింగ్ మరియు అభ్యాసం కొరకు ఉచిత AI మోడల్ యాక్సెస్ (క్రెడిట్ కార్డు అవసరం లేదు)
- **అభివృద్ధి సాధనాలు**: డాకర్ కంటెయినర్లు, VS కోడ్, మరియు GitHub Codespaces కాన్ఫిగరేషన్
- **[→ అధ్యాయం 2 ప్రారంభించండి](./02-SetupDevEnvironment/README.md)**

### **అధ్యాయం 3: ప్రధాన జనరేటివ్ AI సాంకేతికతలు**
- **ప్రాంప్ట్ ఇంజనీరింగ్**: AI మోడల్ ఉత్తమ స్పందనల కోసం సాంకేతిక పద్ధతులు
- **ఎంబెడ్డింగ్స్ & వెక్టర్ ఆపరేషన్స్**: సేమాంటిక్ సెర్చ్ మరియు సమానత్వ సరిచూడటం అమలు చేయడం
- **రిట్రీవల్-ఆగ్మెంటెడ్ జనరేషన్ (RAG)**: మీ స్వంత డేటా మూలాలతో AIని కలపడం
- **ఫంక్షన్ కాలింగ్**: అనుకూల సాధనాలు మరియు ప్లగిన్‌లతో AI సామర్థ్యాలను పెంచడం
- **[→ అధ్యాయం 3 ప్రారంభించండి](./03-CoreGenerativeAITechniques/README.md)**

### **అధ్యాయం 4: ప్రాయోగిక అనువర్తనాలు & ప్రాజెక్టులు**
- **పెట్ స్టోరీ జనరేటర్** (`petstory/`): GitHub Models ఉపయోగించి సృజనాత్మక కంటెంట్ జనరేషన్
- **Foundry Local డెమో** (`foundrylocal/`): OpenAI జావా SDKతో స్థానిక AI మోడల్ ఇంటిగ్రేషన్
- **MCP క్యాల్క్యులేటర్ సర్వీస్** (`calculator/`): Spring AIతో బేసిక్ మోడల్ కాంటెక్స్ట్ ప్రోటోకాల్ అమలు
- **[→ అధ్యాయం 4 ప్రారంభించండి](./04-PracticalSamples/README.md)**

### **అధ్యాయం 5: బాధ్యతాయుతమైన AI అభివృద్ధి**
- **GitHub Models సేఫ్టీ**: బిల్ట్-ఇన్ కంటెంట్ ఫిల్టరింగ్ మరియు సేఫ్టీ యంత్రాంగాలను పరీక్షించండి (హార్డ్ బ్లాక్స్ మరియు సాఫ్ట్ రిఫ్యూస్‌లు)
- **బాధ్యతాయుత AI డెమో**: ఆధునిక AI సేఫ్టీ వ్యవస్థలు ఎలా పని చేస్తున్నాయో ప్రాక్టికల్ ఉదాహరణ
- **బెస్ట్ ప్రాక్టీసులు**: నైతిక AI అభివృద్ధి మరియు డిప్లాయ్‌మెంట్ కోసం అవసరమైన మార్గదర్శకాలు
- **[→ అధ్యాయం 5 ప్రారంభించండి](./05-ResponsibleGenAI/README.md)**

## అదనపు వనరులు

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### లాంగ్‌చైన్
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### అజ్యూర్ / ఎడ్జ్ / MCP / ఏజెంట్లు
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### జనరేటివ్ AI సీరీస్
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### ప్రాథమిక అభ్యాసం
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### కోపైలట్ సిరీస్
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## సహాయం పొందడం

మీరు అడ్డుకట్ట పడినట్లయితే లేదా AI యాప్స్ తయారుచేసే విషయంలో ఏవైనా ప్రశ్నలు ఉంటే, MCP గురించి చర్చలలో సహచర అభ్యాసకులు మరియు అనుభవజ్ఞులైన డెవలపర్లు చేరండి. ఇది ప్రశ్నలకు స్వాగతం చెప్పే, జ్ఞానం స్వేచ్ఛగా పంచుకునే అనుకూలమైన సమాజం.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

ఉత్పత్తి అభిప్రాయం లేదా దోషాలు ఉంటే నిర్మాణ సమయంలో సందర్శించండి:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**విజ్ఞప్తి**:  
ఈ డాక్యుమెంటును AI అనువాద సేవ [Co-op Translator](https://github.com/Azure/co-op-translator) ఉపయోగించి అనువదించాము. మన ప్రయత్నం సరిగా ఉండటమే అయినప్పటికీ, స్వయంచాలక అనువాదాలలో తప్పులు లేదా లోపాలు ఉండవచ్చని దయచేసి గమనించండి. ఈ డాక్యుమెంటు యొక్క మౌలిక భాషలో ఉన్న అసలు పత్రమే అధికారిక మూలంగా పరిగణించాలి. ముఖ్యమైన సమాచారానికి, ప్రొఫెషనల్ మానవ అనువాదం చేయించుకోవడం ఉత్తమం. ఈ అనువాదాన్ని ఉపయోగించడంవలన కలిగిన ఏవైనా తప్పుదోషాలు లేదా అపార్థాలకు మేము బాధ్యులు కావము.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->