<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "eaa2dc75d2cf5083d071e3c84aa4b955",
  "translation_date": "2025-12-19T10:53:01+00:00",
  "source_file": "README.md",
  "language_code": "te"
}
-->
# ప్రారంభికుల కోసం జనరేటివ్ AI - జావా ఎడిషన్
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![ప్రారంభికుల కోసం జనరేటివ్ AI - జావా ఎడిషన్](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.te.png)

**సమయ కట్టుబాటు**: మొత్తం వర్క్‌షాప్‌ను స్థానిక సెటప్ లేకుండా ఆన్‌లైన్‌లో పూర్తి చేయవచ్చు. వాతావరణ సెటప్‌కు 2 నిమిషాలు పడుతుంది, నమూనాలను అన్వేషించడానికి అన్వేషణ లోతు ఆధారంగా 1-3 గంటలు అవసరం.

> **త్వరిత ప్రారంభం**

1. ఈ రిపోజిటరీని మీ GitHub ఖాతాకు Fork చేయండి
2. **Code** → **Codespaces** ట్యాబ్ → **...** → **New with options...** క్లిక్ చేయండి
3. డిఫాల్ట్స్ ఉపయోగించండి – ఇది ఈ కోర్సు కోసం సృష్టించిన Development కంటైనర్‌ను ఎంచుకుంటుంది
4. **Create codespace** క్లిక్ చేయండి
5. వాతావరణం సిద్ధంగా ఉండేందుకు సుమారు 2 నిమిషాలు వేచి ఉండండి
6. నేరుగా [మొదటి ఉదాహరణ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) కు వెళ్లండి

> **స్థానికంగా క్లోన్ చేయాలనుకుంటున్నారా?**
>
> ఈ రిపోజిటరీ 50+ భాషా అనువాదాలను కలిగి ఉంది, ఇది డౌన్లోడ్ పరిమాణాన్ని గణనీయంగా పెంచుతుంది. అనువాదాలు లేకుండా క్లోన్ చేయడానికి sparse checkout ఉపయోగించండి:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ఇది కోర్సును పూర్తి చేయడానికి అవసరమైన అన్ని విషయాలను చాలా వేగంగా డౌన్లోడ్ చేయడానికి సహాయపడుతుంది.


## బహుభాషా మద్దతు

### GitHub Action ద్వారా మద్దతు (ఆటోమేటెడ్ & ఎప్పుడూ తాజా)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[అరబిక్](../ar/README.md) | [బెంగాలీ](../bn/README.md) | [బల్గేరియన్](../bg/README.md) | [బర్మీస్ (మయన్మార్)](../my/README.md) | [చైనీస్ (సింప్లిఫైడ్)](../zh/README.md) | [చైనీస్ (ట్రాడిషనల్, హాంకాంగ్)](../hk/README.md) | [చైనీస్ (ట్రాడిషనల్, మకావు)](../mo/README.md) | [చైనీస్ (ట్రాడిషనల్, తైవాన్)](../tw/README.md) | [క్రొయేషియన్](../hr/README.md) | [చెక్](../cs/README.md) | [డానిష్](../da/README.md) | [డచ్](../nl/README.md) | [ఎస్టోనియన్](../et/README.md) | [ఫిన్నిష్](../fi/README.md) | [ఫ్రెంచ్](../fr/README.md) | [జర్మన్](../de/README.md) | [గ్రీకు](../el/README.md) | [హీబ్రూ](../he/README.md) | [హిందీ](../hi/README.md) | [హంగేరియన్](../hu/README.md) | [ఇండోనేషియన్](../id/README.md) | [ఇటాలియన్](../it/README.md) | [జపనీస్](../ja/README.md) | [కన్నడ](../kn/README.md) | [కొరియన్](../ko/README.md) | [లిథువేనియన్](../lt/README.md) | [మలయ్](../ms/README.md) | [మలయాళం](../ml/README.md) | [మరాఠీ](../mr/README.md) | [నేపాలి](../ne/README.md) | [నైజీరియన్ పిడ్గిన్](../pcm/README.md) | [నార్వేజియన్](../no/README.md) | [పర్షియన్ (ఫార్సీ)](../fa/README.md) | [పోలిష్](../pl/README.md) | [పోర్చుగీస్ (బ్రెజిల్)](../br/README.md) | [పోర్చుగీస్ (పోర్చుగల్)](../pt/README.md) | [పంజాబీ (గుర్ముఖీ)](../pa/README.md) | [రోమానియన్](../ro/README.md) | [రష్యన్](../ru/README.md) | [సెర్బియన్ (సిరిలిక్)](../sr/README.md) | [స్లోవాక్](../sk/README.md) | [స్లోవేనియన్](../sl/README.md) | [స్పానిష్](../es/README.md) | [స్వాహిలి](../sw/README.md) | [స్వీడిష్](../sv/README.md) | [టాగాలాగ్ (ఫిలిపినో)](../tl/README.md) | [తమిళ్](../ta/README.md) | [తెలుగు](./README.md) | [థాయ్](../th/README.md) | [టర్కిష్](../tr/README.md) | [ఉక్రెయిన్](../uk/README.md) | [ఉర్దూ](../ur/README.md) | [వియత్నామీస్](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## కోర్సు నిర్మాణం & నేర్చుకునే మార్గం

### **అధ్యాయం 1: జనరేటివ్ AI పరిచయం**
- **మూల భావనలు**: పెద్ద భాషా నమూనాలు, టోకెన్లు, ఎంబెడ్డింగ్స్, మరియు AI సామర్థ్యాలు అర్థం చేసుకోవడం
- **జావా AI ఎకోసిస్టమ్**: Spring AI మరియు OpenAI SDKs అవలోకనం
- **మోడల్ కాంటెక్స్ట్ ప్రోటోకాల్**: MCP పరిచయం మరియు AI ఏజెంట్ కమ్యూనికేషన్‌లో దాని పాత్ర
- **ప్రాయోగిక అనువర్తనాలు**: చాట్‌బాట్లు మరియు కంటెంట్ జనరేషన్ వంటి వాస్తవ ప్రపంచ సన్నివేశాలు
- **[→ అధ్యాయం 1 ప్రారంభించండి](./01-IntroToGenAI/README.md)**

### **అధ్యాయం 2: అభివృద్ధి వాతావరణం సెటప్**
- **బహు-ప్రొవైడర్ కాన్ఫిగరేషన్**: GitHub Models, Azure OpenAI, మరియు OpenAI Java SDK ఇంటిగ్రేషన్లు సెటప్ చేయడం
- **Spring Boot + Spring AI**: ఎంటర్ప్రైజ్ AI అప్లికేషన్ అభివృద్ధి కోసం ఉత్తమ పద్ధతులు
- **GitHub Models**: ప్రోటోటైపింగ్ మరియు నేర్చుకోవడానికి ఉచిత AI మోడల్ యాక్సెస్ (క్రెడిట్ కార్డు అవసరం లేదు)
- **అభివృద్ధి సాధనాలు**: Docker కంటైనర్లు, VS Code, మరియు GitHub Codespaces కాన్ఫిగరేషన్
- **[→ అధ్యాయం 2 ప్రారంభించండి](./02-SetupDevEnvironment/README.md)**

### **అధ్యాయం 3: కోర్ జనరేటివ్ AI సాంకేతికతలు**
- **ప్రాంప్ట్ ఇంజనీరింగ్**: ఉత్తమ AI మోడల్ ప్రతిస్పందనల కోసం సాంకేతికతలు
- **ఎంబెడ్డింగ్స్ & వెక్టర్ ఆపరేషన్లు**: సేమాంటిక్ సెర్చ్ మరియు సారూప్యత మ్యాచ్ చేయడం అమలు చేయడం
- **రిట్రీవల్-ఆగ్మెంటెడ్ జనరేషన్ (RAG)**: మీ స్వంత డేటా మూలాలతో AI కలపడం
- **ఫంక్షన్ కాలింగ్**: కస్టమ్ టూల్స్ మరియు ప్లగిన్లతో AI సామర్థ్యాలను విస్తరించడం
- **[→ అధ్యాయం 3 ప్రారంభించండి](./03-CoreGenerativeAITechniques/README.md)**

### **అధ్యాయం 4: ప్రాయోగిక అనువర్తనాలు & ప్రాజెక్టులు**
- **పెట్ స్టోరీ జనరేటర్** (`petstory/`): GitHub Models తో సృజనాత్మక కంటెంట్ జనరేషన్
- **ఫౌండ్రీ లోకల్ డెమో** (`foundrylocal/`): OpenAI Java SDK తో లోకల్ AI మోడల్ ఇంటిగ్రేషన్
- **MCP క్యాల్క్యులేటర్ సర్వీస్** (`calculator/`): Spring AI తో ప్రాథమిక మోడల్ కాంటెక్స్ట్ ప్రోటోకాల్ అమలు
- **[→ అధ్యాయం 4 ప్రారంభించండి](./04-PracticalSamples/README.md)**

### **అధ్యాయం 5: బాధ్యతాయుత AI అభివృద్ధి**
- **GitHub Models సేఫ్టీ**: బిల్ట్-ఇన్ కంటెంట్ ఫిల్టరింగ్ మరియు సేఫ్టీ మెకానిజంలను పరీక్షించడం (హార్డ్ బ్లాక్స్ మరియు సాఫ్ట్ రిఫ్యూజల్స్)
- **బాధ్యతాయుత AI డెమో**: ఆధునిక AI సేఫ్టీ సిస్టమ్స్ ఎలా పనిచేస్తాయో చూపించే హ్యాండ్స్-ఆన్ ఉదాహరణ
- **ఉత్తమ పద్ధతులు**: నైతిక AI అభివృద్ధి మరియు అమలుకు అవసరమైన మార్గదర్శకాలు
- **[→ అధ్యాయం 5 ప్రారంభించండి](./05-ResponsibleGenAI/README.md)**

## అదనపు వనరులు

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### లాంగ్‌చైన్
[![ప్రారంభికుల కోసం LangChain4j](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![ప్రారంభికుల కోసం LangChain.js](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### Azure / ఎడ్జ్ / MCP / ఏజెంట్లు
[![ప్రారంభికుల కోసం AZD](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![ప్రారంభికుల కోసం ఎడ్జ్ AI](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![ప్రారంభికుల కోసం MCP](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![ప్రారంభికుల కోసం AI ఏజెంట్లు](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### జనరేటివ్ AI సిరీస్
[![ప్రారంభికుల కోసం జనరేటివ్ AI](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![జనరేటివ్ AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![జనరేటివ్ AI (జావా)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![జనరేటివ్ AI (జావాస్క్రిప్ట్)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### కోర్ లెర్నింగ్
[![ప్రారంభికుల కోసం ML](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![ప్రారంభికుల కోసం డేటా సైన్స్](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![ప్రారంభికుల కోసం AI](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![ప్రారంభికుల కోసం సైబర్‌సెక్యూరిటీ](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![ప్రారంభికుల కోసం వెబ్ డెవలప్‌మెంట్](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### కోపైలట్ సిరీస్
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## సహాయం పొందడం

మీరు అడ్డుకుపోయినట్లయితే లేదా AI యాప్స్ నిర్మాణం గురించి ఏవైనా ప్రశ్నలు ఉంటే. MCP గురించి చర్చల్లో ఇతర అభ్యాసకులు మరియు అనుభవజ్ఞులైన డెవలపర్లతో చేరండి. ఇది ప్రశ్నలు స్వాగతించబడే మరియు జ్ఞానం స్వేచ్ఛగా పంచుకునే మద్దతు సమాజం.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

మీకు ఉత్పత్తి అభిప్రాయం లేదా నిర్మాణ సమయంలో లోపాలు ఉంటే సందర్శించండి:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**అస్పష్టత**:  
ఈ పత్రాన్ని AI అనువాద సేవ [Co-op Translator](https://github.com/Azure/co-op-translator) ఉపయోగించి అనువదించబడింది. మేము ఖచ్చితత్వానికి ప్రయత్నించినప్పటికీ, ఆటోమేటెడ్ అనువాదాల్లో పొరపాట్లు లేదా తప్పిదాలు ఉండవచ్చు. అసలు పత్రం దాని స్వదేశీ భాషలోనే అధికారిక మూలంగా పరిగణించాలి. ముఖ్యమైన సమాచారానికి, ప్రొఫెషనల్ మానవ అనువాదం సిఫార్సు చేయబడుతుంది. ఈ అనువాదం వాడకంలో ఏర్పడిన ఏవైనా అపార్థాలు లేదా తప్పుదారుల కోసం మేము బాధ్యత వహించము.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->