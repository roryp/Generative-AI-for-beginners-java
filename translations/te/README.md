# ప్రారంభికుల కోసం జనరేటివ్ AI - జావా సంచిక
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![ప్రారంభికుల కోసం జనరేటివ్ AI - జావా సంచిక](../../translated_images/te/beg-genai-series.8b48be9951cc574c.webp)

**సమయ వాయిదా**: మొత్తం వర్క్‌షాప్ స్థానిక సెటప్ లేకుండా ఆన్‌లైన్‌లో పూర్తి చేయవచ్చు. పరిసరాన్ని సెట్ చేయడానికి 2 నిమిషాలు పట్టేవి, నమూనాలను అన్వేషించడానికి 1-3 గంటలు అవసరం అన్వేషణ లోతు ఆధారంగా ఉంటుంది.

> **త్వరిత ప్రారంభం**

1. ఈ రిపోజిటరీని మీ GitHub ఖాతాకు ఫోర్క్ చేయండి
2. **Code** → **Codespaces** టాబ్ → **...** → **New with options...** క్లిక్ చేయండి
3. డిఫాల్ట్లను ఉపయోగించండి – ఇది ఈ కోర్స్ కోసం రూపొందించిన డెవలప్‌మెంట్ కంటైనర్‌ను ఎంచుకుంటుంది
4. **Create codespace** క్లిక్ చేయండి
5. పరిసరము తయారవ్వడానికి సుమారు ~2 నిమిషాలు వేచి ఉండండి
6. నేరుగా [మొదటి ఉదాహరణకు](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) వెళ్లండి

> **స్థానికంగా క్లోన్ చేయాలని ఇష్టం ఉందా?**
>
> ఈ రిపోజిటరీ 50+ భాషా అనువాదాలను కలిగి ఉంది, ఇది డౌన్లోడ్ పరిమాణాన్ని గణనీయంగా పెంచుతుంది. అనువాదాలు లేకుండా క్లోన్ చేయడానికి, స్పార్స్ చెకౌట్ ఉపయోగించండి:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ఇది కోర్స్ పూర్తి చేయడానికి మీకు కావలసిన ప్రతిదీ చాలా వేగంగా డౌన్లోడ్ అవుతుంది.


## బహుభాషా మద్దతు

### GitHub యాక్షన్ ద్వారా మద్దతు (ఆటోమేటెడ్ & ఎప్పటి నుండీ తాజా)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[అరబిక్](../ar/README.md) | [బెంగాలీ](../bn/README.md) | [బల్గేరియన్](../bg/README.md) | [బర్మీస్ (మయన్మార్)](../my/README.md) | [చైనీస్ (సంప్లిష్డ్)](../zh-CN/README.md) | [చైనీస్ (పారంపర్య, హాంకాంగ్)](../zh-HK/README.md) | [చైనీస్ (పారంపర్య, మకావు)](../zh-MO/README.md) | [చైనీస్ (పారంపర్య, తైవాన్)](../zh-TW/README.md) | [క్రొయేషియన్](../hr/README.md) | [చెక్](../cs/README.md) | [డానిష్](../da/README.md) | [డచ్](../nl/README.md) | [ఎస్టోనియన్](../et/README.md) | [ఫిన్నిష్](../fi/README.md) | [ఫ్రెంచ్](../fr/README.md) | [జర్మన్](../de/README.md) | [గ్రీకు](../el/README.md) | [హిబ్రూ](../he/README.md) | [హిందీ](../hi/README.md) | [హంగేరియన్](../hu/README.md) | [ఇండోనేషియన్](../id/README.md) | [ఇటాలియన్](../it/README.md) | [జపనీస్](../ja/README.md) | [కన్నడ](../kn/README.md) | [కోరియన్](../ko/README.md) | [లిథువేనియన్](../lt/README.md) | [మలయ్](../ms/README.md) | [మలయాళం](../ml/README.md) | [మరాఠీ](../mr/README.md) | [నేపాలీ](../ne/README.md) | [నైజీరియన్ పిడ్జిన్](../pcm/README.md) | [నార్వేజియన్](../no/README.md) | [ఫార్సీ (పర్షియన్)](../fa/README.md) | [పోలిష్](../pl/README.md) | [పొర్చుగీస్ (బ్రెజిల్)](../pt-BR/README.md) | [పొర్చుగీస్ (పొర్చుగల్)](../pt-PT/README.md) | [పంజాబీ (గురుముఖి)](../pa/README.md) | [రోమానియన్](../ro/README.md) | [రష్యన్](../ru/README.md) | [సెర్బియన్ (సిరిలిక్)](../sr/README.md) | [స్లోవక్](../sk/README.md) | [స్లోవేనియన్](../sl/README.md) | [స్పానిష్](../es/README.md) | [స్వాహిలి](../sw/README.md) | [స్వీడిష్](../sv/README.md) | [టాగలోగ్ (ఫిలిపినో)](../tl/README.md) | [తమిళ్](../ta/README.md) | [తెలుగు](./README.md) | [థాయ్](../th/README.md) | [టర్కిష్](../tr/README.md) | [ఉక్రెయిన్](../uk/README.md) | [ఉర్దూ](../ur/README.md) | [వియత్నామీస్](../vi/README.md)

> **స్థానికంగా క్లోన్ చేయాలని ఇష్టం ఉందా?**

> ఈ రిపోజిటరీ 50+ భాషా అనువాదాలను కలిగి ఉంది, ఇది డౌన్లోడ్ పరిమాణాన్ని గణనీయంగా పెంచుతుంది. అనువాదాలు లేకుండా క్లోన్ చేయడానికి, స్పార్స్ చెకౌట్ ఉపయోగించండి:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ఇది కోర్స్ పూర్తి చేయడానికి మీకు కావలసిన ప్రతిదీ చాలా వేగంగా డౌన్లోడ్ అవుతుంది.
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## కోర్స్ నిర్మాణం & నేర్చుకునే మార్గం

### **అధ్యాయం 1: జనరేటివ్ AI పరిచయం**
- **ముఖ్యాంశాలు**: పెద్ద భాషా నమూనాలు, టోకెన్లు, ఎంబెడింగ్స్, మరియు AI శక్తుల అవగాహన
- **జావా AI పరిసరము**: Spring AI మరియు OpenAI SDKల అవలోకనం
- **మోడల్ కాంటెక్స్ట్ ప్రోటోకాల్**: MCP పరిచయం మరియు AI ఏజెంట్ కమ్యూనికేషన్‌లో పాత్ర
- **ప్రయోజనాత్మక అనువర్తనాలు**: చాట్‌బాట్లు మరియు కంటెంట్ ఉత్పత్తి వంటి వాస్తవ ప్రపంచ దృశ్యాలు
- **[→ అధ్యాయం 1 ప్రారంభించండి](./01-IntroToGenAI/README.md)**

### **అధ్యాయం 2: డెవలప్‌మెంట్ పరిసర సెటప్**
- **బహుళ-ప్రొవైడర్ కాన్ఫిగరేషన్**: GitHub Models, Azure OpenAI, మరియు OpenAI Java SDK ఇంటిగ్రేషన్ల సెటప్
- **Spring Boot + Spring AI**: ఎంటర్ప్రైజ్ AI అప్లికేషన్ అభివృద్ధికి మంచిది
- **GitHub Models**: ప్రోటోటైపింగ్ మరియు విద్య కోసం ఉచిత AI మోడల్ యాక్సెస్ (క్రెడిట్ కార్డు అవసరం లేదు)
- **డెవలప్‌మెంట్ టూల్స్**: Docker కంటైనర్లు, VS కోడ్, మరియు GitHub Codespaces కాన్ఫిగరేషన్
- **[→ అధ్యాయం 2 ప్రారంభించండి](./02-SetupDevEnvironment/README.md)**

### **అధ్యాయం 3: కోర్ జనరేటివ్ AI సాంకేతికతలు**
- **ప్రాంప్ట్ ఇంజనీరింగ్**: ఉత్తమ AI మోడల్ ప్రతిస్పందనల కోసం సాంకేతికతలు
- **ఎంబెడింగ్స్ & వెక్టర్ ఆపరేషన్స్**: సేమాంటిక్ సెర్చ్ మరియు సమాన్యపు మ్యాచ్ విధానాలు అమలు
- **రిట్రీవల్-ఆగ్మెంటెడ్ జనరేషన్ (RAG)**: మీ స్వంత డేటా వనరులతో AI కలపండి
- **ఫంక్షన్ కాలింగ్**: కస్టమ్ టూల్స్ మరియు ప్లగిన్లతో AI శక్తులను విస్తరించండి
- **[→ అధ్యాయం 3 ప్రారంభించండి](./03-CoreGenerativeAITechniques/README.md)**

### **అధ్యాయం 4: ప్రాక్టికల్ అనువర్తనాలు & ప్రాజెక్టులు**
- **పెట్ స్టోరీ జనరేటర్** (`petstory/`): GitHub Models తో సృజనాత్మక కంటెంట్ ఉత్పత్తి
- **Foundry స్థానిక డెమో** (`foundrylocal/`): OpenAI Java SDK ద్వారా స్థానిక AI మోడల్ ఇంటిగ్రేషన్
- **MCP క్యాలిక్యులేటర్ సర్వీస్** (`calculator/`): Spring AI తో ప్రాథమిక మోడల్ కాంటెక్స్ట్ ప్రోటోకాల్ అమలు
- **[→ అధ్యాయం 4 ప్రారంభించండి](./04-PracticalSamples/README.md)**

### **అధ్యాయం 5: బాధ్యతాయుత AI అభివృద్ధి**
- **GitHub Models భద్రత**: అంతర్లీన కంటెంట్ ఫిల్టరింగ్ మరియు భద్రతా విధానాల పరీక్ష (హార్డ్ బ్లాకులు మరియు సోఫ్ట్ తిరస్కరణలు)
- **బాధ్యతాయుత AI డెమో**: ఆధునిక AI భద్రతా వ్యవస్థలు ఎలా పని చేస్తున్నాయో తెలిసే చేతులలో ఉదాహరణ
- **మంచి ఆచారాలు**: నైతిక AI అభివృద్ధి మరియు పంపిణీకి అవసరమైన మార్గదర్శకాలు
- **[→ అధ్యాయం 5 ప్రారంభించండి](./05-ResponsibleGenAI/README.md)**

## అదనపు వనరులు

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### లాంగ్ చైన్
[![ప్రారంభికుల కోసం LangChain4j](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![ప్రారంభికుల కోసం LangChain.js](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### Azure / Edge / MCP / ఏజెంట్లు
[![ప్రారంభికుల కోసం AZD](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![ప్రారంభికుల కోసం Edge AI](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
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

[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### కొపైలట్ సిరీస్
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## సహాయం పొందడం

మీరు అడ్డంకిలో పడితే లేదా AI యాప్‌లు నిర్మించడంపై ఏవైనా ప్రశ్నలు ఉంటే. MCP గురించి చర్చల్లో సహశిక్షణార్థులు మరియు అనుభవజ్ఞులైన డెవలపర్లతో చేరండి. ఇది ప్రశ్నలు స్వీకరించే, విజ్ఞానాన్ని స్వేచ్ఛగా పంచుకునే ఒక మద్దతుగల సంఘం.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

మీకు ఉత్పత్తి స్పందనలు లేదా నిర్మాణంలో లోపాలు ఉంటే సందర్శించండి:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**వివరణా సూచన**:  
ఈ పత్రాన్ని AI అనువాద సేవ [Co-op Translator](https://github.com/Azure/co-op-translator) ఉపయోగించి అనువదింపబడింది. మేము ఖచ్చితత్వానికి శ్రద్ధ తీసుకుంటున్నా, ఆటోమేటెడ్ అనువాదాలలో పొరపాట్లు లేదా అసత్యతలు ఉండవచ్చు. అసలు పత్రం దాని మాతృభాషలో ఉన్నది అధికారిక వనరు అని పరిగణించాలి. అత్యవసర సమాచారానికి, వృత్తిపరమైన మానవ అనువాదం సూచించబడుతుంది. ఈ అనువాదం వల్ల నెలకొన్న ఏవైనా అవగాహనా లోపాలు లేదా తప్పుడు అర్థాలు కోసం మేము బాధ్యత వహించము.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->