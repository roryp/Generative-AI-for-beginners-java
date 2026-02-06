# జనరేట్ చేసే AI ప్రారంభం కోసం - జావా ఎడిషన్
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![జనరేట్ చేసే AI ప్రారంభం కోసం - జావా ఎడిషన్](../../translated_images/te/beg-genai-series.8b48be9951cc574c.webp)

**సమయ కట్టుబాటు**: మొత్తం వర్క్‌షాప్‌ను ఆన్‌లైన్‌లో స్థానిక సెటప్ లేకుండా పూర్తి చేయవచ్చు. పరిసరాల సెటప్‌కు 2 నిమిషాలు పడుతుంది, నమూనాలను అన్వేషించడానికి అన్వేషణ స్థాయిని ఆధారపడి 1-3 గంటలు అవసరం.

> **త్వరిత ప్రారంభం**

1. ఈ రిపాజిటరీని మీ GitHub ఖాతాకు Fork చేయండి  
2. **Code** → **Codespaces** ట్యాబ్ → **...** → **New with options...** క్లిక్ చేయండి  
3. డిఫాల్ట్‌లు ఉపయోగించండి – ఇది ఈ కోర్సుకిగాను సృష్టించిన Development కంటైనర్‌ను ఎంచుకుంటుంది  
4. **Create codespace** క్లిక్ చేయండి  
5. పరిసరాలు సిద్ధంగా ఉండేందుకు సుమారు 2 నిమిషాలు వేచి ఉండండి  
6. నేరుగా [మొదటి ఉదాహరణ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) కు వెళ్లండి  

> **స్థానికంగా క్లోన్ చేయాలనుకుంటున్నారా?**  
>  
> ఈ రిపాజిటరీ 50+ భాషా అనువాదాలను కలిగి ఉంది, ఇది డౌన్‌లోడ్ పరిమాణాన్ని గణనీయంగా పెంచుతుంది. అనువాదాల లేకుండా క్లోన్ చేయడానికి, స్పార్స్ చెక్‌అవుట్ ఉపయోగించండి:  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ఇది కోర్సును పూర్తిచేయడానికి మీరు అవసరమైన అన్ని విషయాలను చాలా వేగంగా డౌన్‌లోడ్ చేయడానికి ఇస్తుంది.

## బహుముఖ భాషల మద్దతు

### GitHub యాక్షన్ ద్వారా మద్దతు (ఆటోమేటెడ్ & ఎల్లప్పుడు నవీకరించబడుతుంది)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[అరబిక్](../ar/README.md) | [బెంగాలీ](../bn/README.md) | [బల్గేరియన్](../bg/README.md) | [బర్మీస్ (మయన్మార్)](../my/README.md) | [చైనీస్ (సంప్లిఫైడ్)](../zh-CN/README.md) | [చైనీస్ (పారంపరిక, హాంగ్ కాంగ్)](../zh-HK/README.md) | [చైనీస్ (పారంపరిక, మకావో)](../zh-MO/README.md) | [చైనీస్ (పారంపరిక, తైవాన్)](../zh-TW/README.md) | [క్రొయేషియన్](../hr/README.md) | [చెక్](../cs/README.md) | [డానిష్](../da/README.md) | [డచ్](../nl/README.md) | [ఎస్టోనియన్](../et/README.md) | [ఫిన్నిష్](../fi/README.md) | [ఫ్రెంచ్](../fr/README.md) | [జర్మన్](../de/README.md) | [గ్రీక్](../el/README.md) | [హీబ్రూ](../he/README.md) | [హిందీ](../hi/README.md) | [హంగేరియన్](../hu/README.md) | [ఇండోనేషియన్](../id/README.md) | [ఇటాలియన్](../it/README.md) | [జపనీస్](../ja/README.md) | [కన్నడ](../kn/README.md) | [కొరియన్](../ko/README.md) | [లిథుయానియన్](../lt/README.md) | [మలయ్](../ms/README.md) | [మలయాళం](../ml/README.md) | [మరాఠీ](../mr/README.md) | [నేపాలీ](../ne/README.md) | [నైజిరియన్ పిడ్గిన్](../pcm/README.md) | [నార్వేజియన్](../no/README.md) | [పర్షియన్ (ఫార్సీ)](../fa/README.md) | [పోలిష్](../pl/README.md) | [పోర్చుగీస్ (బ్రాజిల్)](../pt-BR/README.md) | [పోర్చుగీస్ (పార్చుగల్)](../pt-PT/README.md) | [పంజాబీ (గురుముఖీ)](../pa/README.md) | [రోమానియన్](../ro/README.md) | [రష్యన్](../ru/README.md) | [సెర్బియన్ (సిరిలిక్)](../sr/README.md) | [స్లోవాక్](../sk/README.md) | [స్లోవీనియన్](../sl/README.md) | [స్పానిష్](../es/README.md) | [స్వాహిలి](../sw/README.md) | [స్వీడిష్](../sv/README.md) | [తగలొగ్ (ఫిలిపినో)](../tl/README.md) | [తమిళ్](../ta/README.md) | [తెలుగు](./README.md) | [థాయ్](../th/README.md) | [తుర్కిష్](../tr/README.md) | [ఉక్రెయిన్](../uk/README.md) | [ఉర్దూ](../ur/README.md) | [వియత్నామీస్](../vi/README.md)

## కోర్స్ నిర్మాణం & నేర్చుకునే మార్గం

### **అధ్యాయం 1: జనరేటివ్ AI పరిచయం**  
- **ప్రామాణిక భావనలు**: పెద్ద భాషా ఆధారిత నమూనాలు, టోకన్స్, ఎంబెడ్డింగ్స్, మరియు AI సామర్థ్యాలను అర్థం చేసుకోవడం  
- **జావా AI పర్యావరణం**: Spring AI మరియు OpenAI SDKs సారాంశం  
- **మోడల్ కాంటెక్ట్ ప్రొటోకాల్**: MCP పరిచయం మరియు AI ఏజెంట్ సంభాషణలో దాని పాత్ర  
- **ప్రయోజనకర ఉపయోగాలు**: చాట్‌బాట్లు మరియు కంటెంట్ జనరేషన్ సహా వాస్తవ ప్రపంచ పరిస్థితులు  
- **[→ అధ్యాయం 1 ప్రారంభించండి](./01-IntroToGenAI/README.md)**

### **అధ్యాయం 2: డెవలప్‌మెంట్ ఎన్‌విరాన్‌మెంట్ సెటప్**  
- **బహు-ప్రొవైడర్ కాన్ఫిగరేషన్**: GitHub Models, Azure OpenAI, మరియు OpenAI Java SDK అనుసంధానాలు సెటప్ చెయ్యడం  
- **Spring Boot + Spring AI**: ఎంటర్‌ప్రైజ్ AI అప్లికేషన్ అభివృద్ధి ఉత్తమ ఆచారాలు  
- **GitHub Models**: ప్రోటో టైపింగ్ మరియు నేర్చుకునేందుకు ఉచిత AI మోడల్ యాక్సెస్ (క్రెడిట్ కార్డు అవసరం లేదు)  
- **డెవలప్‌మెంట్ టూల్స్**: డాకర్ కంటైనర్లు, VS కోడ్, మరియు GitHub Codespaces కాన్ఫిగరేషన్  
- **[→ అధ్యాయం 2 ప్రారంభించండి](./02-SetupDevEnvironment/README.md)**

### **అధ్యాయం 3: ప్రాథమిక జనరేటివ్ AI సాంకేతికతలు**  
- **ప్రాంప్ట్ ఇంజినీరింగ్**: ఉత్తమ AI మోడల్ ప్రతిస్పందనల కోసం సాంకేతికతలు  
- **ఎంబెడ్డింగ్స్ & వెక్టర్ ఆపరేషన్స్**: సేమాంటిక్ శోధన మరియు సమానత సరిపోల్చడం అమలు చేయడం  
- **రెట్రీవల్-ఆగ్మెంటెడ్ జనరేషన్ (RAG)**: మీ స్వంత డేటా వనరులతో AI ని కలుపుకోవడం  
- **ఫంక్షన్ కాలింగ్**: కస్టమ్ టూల్స్ మరియు ప్లగిన్లతో AI సామర్థ్యాలను పెంచడం  
- **[→ అధ్యాయం 3 ప్రారంభించండి](./03-CoreGenerativeAITechniques/README.md)**

### **అధ్యాయం 4: ప్రాక్టికల్ అప్లికేషన్స్ & ప్రాజెక్టులు**  
- **పెట్ స్టోరీ జనరేటర్** (`petstory/`): GitHub Models తో సృజనాత్మక కంటెంట్ జనరేషన్  
- **ఫౌండ్రీ లోకల్ డెమో** (`foundrylocal/`): OpenAI జావా SDK తో లోకల్ AI మోడల్ సమ్మేళనం  
- **MCP క్యాల్క్యులేటర్ సర్వీస్** (`calculator/`): Spring AI తో ప్రాథమిక మోడల్ కాంటెక్ట్ ప్రోటోకాల్ అమలు  
- **[→ అధ్యాయం 4 ప్రారంభించండి](./04-PracticalSamples/README.md)**

### **అధ్యాయం 5: బాధ్యతాయుత AI అభివృద్ధి**  
- **GitHub Models సురక్షితత**: బిల్ట్-ఇన్ కంటెంట్ ఫిల్టరింగ్ మరియు సేఫ్టీ మెకానిసంల (కఠిన బ్లాక్లు మరియు మృదువైన తిరస్కరణలు) పరీక్షించండి  
- **బాధ్యతాయుత AI డెమో**: ఆధునిక AI సేఫ్టీ సిస్టమ్స్ ఎలా పనిచేస్తాయో హ్యాండ్స్-ఆన్ ఉదాహరణ  
- **ఉత్తమ ఆచారాలు**: నైతిక AI అభివృద్ధి మరియు పంపిణీకి ముఖ్య మార్గదర్శకాలు  
- **[→ అధ్యాయం 5 ప్రారంభించండి](./05-ResponsibleGenAI/README.md)**

## అదనపు వనరులు

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### లాంగ్‌చైన్  
[![ప్రారంభకులకు LangChain4j](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)  
[![ప్రారంభకులకు LangChain.js](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)  
[![ప్రారంభకులకు LangChain](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)  
---

### అజ్యూర్ / ఎడ్జ్ / MCP / ఏజెంట్స్  
[![ప్రారంభకులకు AZD](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![ప్రారంభకులకు ఎడ్జ్ AI](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![ప్రారంభకులకు MCP](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![ప్రారంభకులకు AI ఏజెంట్స్](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)  

---

### జనరేటివ్ AI సిరీస్  
[![ప్రారంభకులకు జనరేటివ్ AI](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![జనరేటివ్ AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)  
[![జనరేటివ్ AI (జావా)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)  
[![జనరేటివ్ AI (జావాస్క్రిప్ట్)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)  

---

### ప్రాథమిక నేర్చుకునే విషయాలు  
[![ప్రారంభకులకు యంత్ర అభ్యాసం](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)  
[![ప్రారంభకులకు డేటా సైన్స్](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)  
[![ప్రారంభకులకు AI](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)  
[![ప్రారంభకులకు సైబర్సెక్యూరిటీ](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### కొడ్పైలట్ సిరీస్
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## సహాయం పొందడం

మీరు అడ్డుగడగడితే లేదా AI యాప్స్ తయారీలో ఏవైనా ప్రశ్నలు ఉంటే. MCP గురించి చర్చల్లో భాగస్వాములైనల్లు మరియు అనుభవజ్ఞులైన అభివృద్ధిదారులు చేరండి. ఇది ప్రశ్నలు స్వాగతమైన మరియు జ్ఞానం ఉచితంగా పంచుకునే ఒక మద్దతు సమూహం.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

మీకు ఉత్పత్తి ప్రతిప్రతిక్రియ లేదా నిర్మాణంలో లోపాలు ఉంటే సందర్శించండి:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**హੇచ్చు వద్దు**:  
ఈ పత్రాన్ని AI అనువాద సేవ [Co-op Translator](https://github.com/Azure/co-op-translator) ఉపయోగించి అనువదించబడింది. మేము ఖచ్చితత్వానికి ప్రయత్నించినప్పటికీ, ఆటోమేటిక్ అనువాదాల్లో పొరపాట్లు లేదా తప్పిదాలు ఉండవచ్చు అని దయచేసి గమనించండి. స్థానిక భాషలో ఉన్న మూల పత్రాన్ని అధికారిక మూలంగా పరిగణించాలి. ముఖ్యమైన సమాచారం కొరకు, పరోఫెషనల్ మానవ అనువాదాన్ని సిఫార్సు చేస్తున్నాము. ఈ అనువాదం వాడకం ద్వారా ఏర్పడిన అపార్థాలు లేదా తప్పుల కోసం మేము బాధ్యత వహించము.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->