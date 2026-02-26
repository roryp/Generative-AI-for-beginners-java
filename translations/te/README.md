# ప్రారంభ విద్యార్థుల కోసం జనరేటివ్ AI - జావా ఎడిషన్
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/te/beg-genai-series.8b48be9951cc574c.webp)

**సమయం కేటాయింపు**: మొత్తం వర్క్‌షాప్‌ను స్థానిక సెటప్ లేకుండా ఆన్‌లైన్‌లో పూర్తిచేసుకోవచ్చు. వాతావరణం సెటప్‌కు 2 నిమిషాలు మాత్రమే పట్టగా, సాంపిల్స్‌ను పరిశీలించడానికి 1-3 గంటలు కావచ్చు, ఇది పరిశీలన లోతులపై ఆధారపడి ఉంటుంది.

> **త్వరిత ప్రారంభం**

1. ఈ రిపాజిటరీని మీ గిట్‌హబ్ ఖాతాకు ఫోర్క్ చేసుకోండి
2. **Code** → **Codespaces** ట్యాబ్ → **...** → **New with options...** క్లిక్ చేయండి
3. డిఫాల్ట్‌లను వాడండి – ఇది ఈ కోర్సు కోసం సృష్టించబడిన డెవలప్‌మెంట్ కంటైనర్‌ని ఎంచుకుంటుంది
4. **Create codespace** క్లిక్ చేయండి
5. వాతావరణం సిద్ధం కావడానికి సుమారు 2 నిమిషాలు వేచి ఉండండి
6. నేరుగా [మొదటి ఉదాహరణకు](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) చేరండి

> **స్థానికంగా క్లోన్ చేయాలనుకుంటున్నారా?**
>
> ఈ రిపాజిటరీ 50+ భాషా అనువాదాలను కలిగి ఉంది, ఇది డౌన్‌లోడ్ పరిమాణాన్ని గణనీయంగా పెంచుతుంది. అనువాదాలు లేకుండా క్లోన్ చేసుకోవడానికి, స్పార్స్ చెక్అవుట్‌ను ఉపయోగించండి:
>
> **లినక్స్ / మాక్‌ఓఎస్ (బాష్)**
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
>
> **విండోస్ (పవర్‌షెల్)**
> ```powershell
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone "/*" "!translations" "!translated_images"
> ```
> ఇది కోర్సు పూర్తి చేసుకోవడానికి అవసరమైన అన్ని ఫైళ్లను వేగంగా డౌన్‌లోడ్ చేయడానికి సహాయపడుతుంది.

## బహుభాషా మద్దతు

### GitHub యాక్షన్ ద్వారా మద్దతు (ఆటోమేటెడ్ మరియు ఎప్పుడూ తాజా)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[అరబిక్](../ar/README.md) | [బెంగాలీ](../bn/README.md) | [బల్గేరియన్](../bg/README.md) | [బర్మీస్ (మయన్మార్)](../my/README.md) | [చైనీస్ (సింప్లిఫైడ్)](../zh-CN/README.md) | [చైనీస్ (పారంపరికం, హాంకాంగ్)](../zh-HK/README.md) | [చైనీస్ (పారంపరికం, మకావు)](../zh-MO/README.md) | [చైనీస్ (పారంపరికం, తైవాన్)](../zh-TW/README.md) | [క్రొయేషియన్](../hr/README.md) | [చెక్](../cs/README.md) | [డానిష్](../da/README.md) | [డచ్](../nl/README.md) | [ఎస్టోనియన్](../et/README.md) | [ఫినిష్](../fi/README.md) | [ఫ్రెంచ్](../fr/README.md) | [జర్మన్](../de/README.md) | [గ్రీకు](../el/README.md) | [హేవ్రూ](../he/README.md) | [హింది](../hi/README.md) | [హంగేరియన్](../hu/README.md) | [ఇండోనేషియన్](../id/README.md) | [ఇటాలియన్](../it/README.md) | [జాపనీస్](../ja/README.md) | [కన్నడ](../kn/README.md) | [కొరియన్](../ko/README.md) | [లిథుయానియన్](../lt/README.md) | [మలయ్](../ms/README.md) | [మలయాళం](../ml/README.md) | [మరాఠీ](../mr/README.md) | [నేపాలి](../ne/README.md) | [నైజీరియన్ పిడ్గిన్](../pcm/README.md) | [నోర్వీశియన్](../no/README.md) | [పర్షియన్ (ఫార్సీ)](../fa/README.md) | [పోలిష్](../pl/README.md) | [పోర్చుగీస్ (బ్రెజిల్)](../pt-BR/README.md) | [పోర్చుగీస్ (పోర్చుగల్)](../pt-PT/README.md) | [పంజాబీ (గుర్ముఖి)](../pa/README.md) | [రోమేనియన్](../ro/README.md) | [రష్యన్](../ru/README.md) | [సెర్బియన్ (సిరిలిక్)](../sr/README.md) | [స్లోవాక్](../sk/README.md) | [స్లోవేనియన్](../sl/README.md) | [స్పానిష్](../es/README.md) | [స్వాహిలి](../sw/README.md) | [స్వీడిష్](../sv/README.md) | [టాగలోగ్ (ఫిలిపినో)](../tl/README.md) | [తమిళ్](../ta/README.md) | [తెలుగు](./README.md) | [థాయి](../th/README.md) | [టర్కిష్](../tr/README.md) | [యుక్రెయినియన్](../uk/README.md) | [ఉర్దూ](../ur/README.md) | [వియత్నామీస్](../vi/README.md)

## కోర్స్ నిర్మాణం & నేర్చుకునే మార్గం

### **అధ్యాయం 1: జనరేటివ్ AI పరిచయం**
- **మూల భావనలు**: పెద్ద భాషా నమూనాలు, టోకెన్లు, ఎంబెడ్డింగ్లు, AI సామర్థ్యాలు అర్థం చేసుకోవడం
- **జావా AI ఎకోసిస్టమ్**: స్ప్రింగ్ AI మరియు OpenAI SDKల సమీక్ష
- **మోడల్ కన్టెక్స్ట్ ప్రోటోకాల్**: MCP పరిచయం మరియు AI ఏజెంట్ సంభాషణలో పాత్ర
- **ప్రాయోగిక అనువర్తనాలు**: చాట్‌బాట్‌లు మరియు కంటెంట్ ఉత్పత్తి వంటి వాస్తవప్రపంచ సన్నివేశాలు
- **[→ అధ్యాయం 1 ప్రారంభించండి](./01-IntroToGenAI/README.md)**

### **అధ్యాయం 2: అభివృద్ధి వాతావరణం సెటప్**
- **బహు-ప్రొవైడర్ కాన్ఫిగరేషన్**: గిట్‌హబ్ మోడల్స్, Azure OpenAI, మరియు OpenAI జావా SDK అసమీకరణలు ఏర్పాటు
- **స్ప్రింగ్ బూట్ + స్ప్రింగ్ AI**: ఎంటర్ప్రైజ్ AI అప్లికేషన్ అభివృద్ధికి ఉత్తమ పద్ధతులు
- **గిట్‌హబ్ మోడల్స్**: ప్రోటోటైపింగ్ మరియు అభ్యాసం కోసం ఉచిత AI మోడల్ యాక్సెస్ (క్రెడిట్ కార్డు అవసరం లేదు)
- **అభివృద్ధి సాధనాలు**: డోకర్ కంటైనర్లు, VS కోడ్, మరియు గిట్‌హబ్ కోడ్స్‌పేసెస్ కాన్ఫిగరేషన్
- **[→ అధ్యాయం 2 ప్రారంభించండి](./02-SetupDevEnvironment/README.md)**

### **అధ్యాయం 3: ప్రాథమిక జనరేటివ్ AI సాంకేతికతలు**
- **ప్రాంప్ట్ ఇంజనీరింగ్**: ఉత్తమ AI మోడల్ ప్రతిస్పందనల సాంకేతికతలు
- **ఎంబెడ్దింగ్లు & వెక్టర్ ఆపరేషన్స్**: సેમాంటిక్ శోధన మరియు సాదృశ్యం సరిపోయే విధానం అమలు
- **రిట్రీవాల్-ఆగ్మెంటెడ్ జనరేషన్ (RAG)**: మీ డేటా మూలాలతో AI ను కలపడం
- **ఫంక్షన్ కాలింగ్**: అనుకూల సాధనాలు మరియు ప్లగిన్‌లతో AI సామర్థ్యాలను విస్తరించడం
- **[→ అధ్యాయం 3 ప్రారంభించండి](./03-CoreGenerativeAITechniques/README.md)**

### **అధ్యాయం 4: ప్రాక్టికల్ అప్లికేషన్స్ & ప్రాజెక్టులు**
- **పెట్ స్టోరి జనరేటర్** (`petstory/`): గిట్‌హబ్ మోడల్స్‌తో సృజనాత్మక కంటెంట్ ఉత్పత్తి
- **Foundry లోకల్ డెమో** (`foundrylocal/`): OpenAI జావా SDKతో లోకల్ AI మోడల్ సమీకరణ
- **MCP క్యాలిక్యులేటర్ సర్వీస్** (`calculator/`): స్ప్రింగ్ AI ద్వారా ప్రాథమిక మోడల్ కన్టెక్స్ట్ ప్రోటోకాల్ అమలుచేయడం
- **[→ అధ్యాయం 4 ప్రారంభించండి](./04-PracticalSamples/README.md)**

### **అధ్యాయం 5: బాధ్యతాయుతమైన AI అభివృద్ధి**
- **గిట్‌హబ్ మోడల్స్ భద్రత**: లోపలటి కంటెంట్ ఫిల్టరింగ్ మరియు సేఫ్టీ మెకానిజమ్స్ (కఠిన నిరోధాలు మరియు సాఫ్ట్ వివక్షలు) పరీక్షించడం
- **బాధ్యతాయుత AI డెమో**: ఆధునిక AI సేఫ్టీ వ్యవస్థలు ఎలా పనిచేస్తాయో ప్రాక్టికల్ ఉదాహరణ
- **ఉత్తమ పద్ధతులు**: నైతిక AI అభివృద్ధి మరియు అమలుకు అవసరమైన మార్గదర్శకాలు
- **[→ అధ్యాయం 5 ప్రారంభించండి](./05-ResponsibleGenAI/README.md)**

## అదనపు వనరులు

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### లాంగ్ చైన్
[![ప్రారంభ విద్యార్థుల కోసం LangChain4j](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![ప్రారంభ విద్యార్థుల కోసం LangChain.js](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![ప్రారంభ విద్యార్థుల కోసం LangChain](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / ఎడ్‌జ్ / MCP / ఏజెంట్లు
[![ప్రారంభ విద్యార్థుల కోసం AZD](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![ప్రారంభ విద్యార్థుల కోసం ఎడ్‌జ్ AI](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![ప్రారంభ విద్యార్థుల కోసం MCP](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![ప్రారంభ విద్యార్థుల కోసం AI ఏజెంట్లు](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### జనరేటివ్ AI సిరీస్
[![ప్రారంభ విద్యార్థుల కోసం జనరేటివ్ AI](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![జనరేటివ్ AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![జనరేటివ్ AI (జావా)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![జనరేటివ్ AI (జావాస్క్రిప్ట్)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### కోర్ లెర్నింగ్
[![ప్రారంభ విద్యార్థుల కోసం ML](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![ప్రారంభ విద్యార్థుల కోసం డేటా సైన్స్](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![ప్రారంభ విద్యార్థుల కోసం AI](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![ప్రారంభ విద్యార్థుల కోసం సైబర్‌సెక్యూరిటీ](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![బిగినర్స్ కోసం వెబ్ డెవ్](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![బిగినర్స్ కోసం ఐఓటీ](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![బిగినర్స్ కోసం XR డెవలప్‌మెంట్](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### కోపైలట్ సిరీస్
[![ఎఐ జతచేసిన ప్రోగ్రామింగ్ కోసం కోపైలట్](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![C#/.NET కోసం కోపైలట్](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![కోపైలట్ అడ్వెంచర్](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## సహాయం పొందడం

మీరు చిక్కుకున్నట్లయితే లేదా ఎఐ యాప్స్ నిర్మించడంపై ఏవైనా ప్రశ్నలు ఉంటే. MCP గురించి చర్చలలో ఇతర విద్యార్థులు మరియు అనుభవజ్ఞులు పాల్గొనండి. ఇది ప్రశ్నలు పంపిణీ చేసుకునేందుకు మరియు జ్ఞానం స్వేచ్ఛగా పంచుకునేందుకు సాయపడే సమూహం.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

మీరు ఉత్పత్తి ప్రతిస్పందన లేదా తప్పిదాలు ఎదుర్కొంటే నిర్మాణ సమయంలో సందర్శించండి:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**విచ్ఛిన్న నోటీస్**:
ఈ పత్రం AI అనువాద సేవ [కో-ఓప్ ట్రాన్స్లేటర్](https://github.com/Azure/co-op-translator) ఉపయోగించి అనువదించబడింది. మేము సరైనతకు ప్రయత్నిస్తుండగా, ఆటోమేటెడ్ అనువాదాల్లో పొరపాట్లు లేదా తప్పులుంటే ఉండవచ్చు. మూలభాషలో ఉన్న అసలు పత్రాన్ని అధికారిక మూలంగా పరిగణించాలి. ముఖ్యమైన సమాచారం కోసం, నైపుణ్యంతో కూడిన మనిషి అనువాదాన్ని సూచించబడుతుంది. ఈ అనువాదం వలన వచ్చిన ఎటువంటి తప్పుదొర్లికలు లేదా తప్పుదీక్షలకు మేము బాధ్యత వహించము.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->