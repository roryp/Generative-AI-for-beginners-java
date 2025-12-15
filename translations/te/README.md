<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0efa90a880213da0aeb35e43ec717e98",
  "translation_date": "2025-12-01T09:09:50+00:00",
  "source_file": "README.md",
  "language_code": "te"
}
-->
# ప్రారంభ స్థాయి జనరేటివ్ AI - జావా ఎడిషన్
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![ప్రారంభ స్థాయి జనరేటివ్ AI - జావా ఎడిషన్](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.te.png)

**సమయ కట్టుబాటు**: మొత్తం వర్క్‌షాప్‌ను స్థానిక సెటప్ అవసరం లేకుండా ఆన్‌లైన్‌లో పూర్తి చేయవచ్చు. పరిసరాల సెటప్‌కు 2 నిమిషాలు పడుతుంది, నమూనాలను అన్వేషించడానికి 1-3 గంటల సమయం అవసరం, అన్వేషణ లోతును బట్టి.

> **త్వరిత ప్రారంభం**

1. ఈ రిపోజిటరీని మీ GitHub ఖాతాకు ఫోర్క్ చేయండి
2. **Code** → **Codespaces** ట్యాబ్ → **...** → **New with options...** క్లిక్ చేయండి
3. డిఫాల్ట్‌లను ఉపయోగించండి – ఇది ఈ కోర్సు కోసం సృష్టించిన డెవలప్‌మెంట్ కంటైనర్‌ను ఎంచుకుంటుంది
4. **Create codespace** క్లిక్ చేయండి
5. పరిసరాలు సిద్ధం కావడానికి ~2 నిమిషాలు వేచి ఉండండి
6. [మొదటి ఉదాహరణ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)కు నేరుగా వెళ్లండి

## బహుభాషా మద్దతు

### GitHub Action ద్వారా మద్దతు (స్వయంచాలకంగా & ఎల్లప్పుడూ నవీకరించబడుతుంది)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[అరబిక్](../ar/README.md) | [బెంగాలీ](../bn/README.md) | [బల్గేరియన్](../bg/README.md) | [బర్మీస్ (మయన్మార్)](../my/README.md) | [చైనీస్ (సింప్లిఫైడ్)](../zh/README.md) | [చైనీస్ (ట్రెడిషనల్, హాంకాంగ్)](../hk/README.md) | [చైనీస్ (ట్రెడిషనల్, మకావ్)](../mo/README.md) | [చైనీస్ (ట్రెడిషనల్, తైవాన్)](../tw/README.md) | [క్రోయేషియన్](../hr/README.md) | [చెక్](../cs/README.md) | [డానిష్](../da/README.md) | [డచ్](../nl/README.md) | [ఎస్టోనియన్](../et/README.md) | [ఫిన్నిష్](../fi/README.md) | [ఫ్రెంచ్](../fr/README.md) | [జర్మన్](../de/README.md) | [గ్రీక్](../el/README.md) | [హీబ్రూ](../he/README.md) | [హిందీ](../hi/README.md) | [హంగేరియన్](../hu/README.md) | [ఇండోనేషియన్](../id/README.md) | [ఇటాలియన్](../it/README.md) | [జపనీస్](../ja/README.md) | [కన్నడ](../kn/README.md) | [కొరియన్](../ko/README.md) | [లిథువేనియన్](../lt/README.md) | [మలయ్](../ms/README.md) | [మలయాళం](../ml/README.md) | [మరాఠీ](../mr/README.md) | [నేపాలి](../ne/README.md) | [నైజీరియన్ పిడ్జిన్](../pcm/README.md) | [నార్వేజియన్](../no/README.md) | [పర్షియన్ (ఫార్సీ)](../fa/README.md) | [పోలిష్](../pl/README.md) | [పోర్చుగీస్ (బ్రెజిల్)](../br/README.md) | [పోర్చుగీస్ (పోర్చుగల్)](../pt/README.md) | [పంజాబీ (గుర్ముఖి)](../pa/README.md) | [రోమేనియన్](../ro/README.md) | [రష్యన్](../ru/README.md) | [సెర్బియన్ (సిరిలిక్)](../sr/README.md) | [స్లోవాక్](../sk/README.md) | [స్లోవేనియన్](../sl/README.md) | [స్పానిష్](../es/README.md) | [స్వాహిలి](../sw/README.md) | [స్వీడిష్](../sv/README.md) | [టగాలోగ్ (ఫిలిపినో)](../tl/README.md) | [తమిళం](../ta/README.md) | [తెలుగు](./README.md) | [థాయ్](../th/README.md) | [టర్కిష్](../tr/README.md) | [ఉక్రేనియన్](../uk/README.md) | [ఉర్దూ](../ur/README.md) | [వియత్నామీస్](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## కోర్సు నిర్మాణం & అభ్యాస మార్గం

### **చాప్టర్ 1: జనరేటివ్ AIకి పరిచయం**
- **మూల భావనలు**: లార్జ్ లాంగ్వేజ్ మోడల్స్, టోకెన్లు, ఎంబెడ్డింగ్స్, మరియు AI సామర్థ్యాల అవగాహన
- **జావా AI ఎకోసిస్టమ్**: స్ప్రింగ్ AI మరియు OpenAI SDKల అవలోకనం
- **మోడల్ కాంటెక్స్ట్ ప్రోటోకాల్**: MCP మరియు AI ఏజెంట్ కమ్యూనికేషన్‌లో దాని పాత్రకు పరిచయం
- **ప్రాక్టికల్ అప్లికేషన్లు**: చాట్‌బాట్లు మరియు కంటెంట్ జనరేషన్ వంటి వాస్తవ ప్రపంచ దృశ్యాలు
- **[→ చాప్టర్ 1 ప్రారంభించండి](./01-IntroToGenAI/README.md)**

### **చాప్టర్ 2: డెవలప్‌మెంట్ పరిసరాల సెటప్**
- **మల్టీ-ప్రొవైడర్ కాన్ఫిగరేషన్**: GitHub మోడల్స్, Azure OpenAI, మరియు OpenAI జావా SDK ఇంటిగ్రేషన్ల సెటప్
- **స్ప్రింగ్ బూట్ + స్ప్రింగ్ AI**: ఎంటర్‌ప్రైజ్ AI అప్లికేషన్ డెవలప్‌మెంట్‌కు ఉత్తమ పద్ధతులు
- **GitHub మోడల్స్**: ప్రోటోటైపింగ్ మరియు అభ్యాసానికి ఉచిత AI మోడల్ యాక్సెస్ (క్రెడిట్ కార్డ్ అవసరం లేదు)
- **డెవలప్‌మెంట్ టూల్స్**: డాకర్ కంటైనర్లు, VS కోడ్, మరియు GitHub కోడ్‌స్పేస్‌ల కాన్ఫిగరేషన్
- **[→ చాప్టర్ 2 ప్రారంభించండి](./02-SetupDevEnvironment/README.md)**

### **చాప్టర్ 3: ప్రధాన జనరేటివ్ AI సాంకేతికతలు**
- **ప్రాంప్ట్ ఇంజినీరింగ్**: AI మోడల్ నుండి ఉత్తమ ప్రతిస్పందనల కోసం సాంకేతికతలు
- **ఎంబెడ్డింగ్స్ & వెక్టర్ ఆపరేషన్లు**: సెమాంటిక్ సెర్చ్ మరియు సిమిలారిటీ మ్యాచింగ్ అమలు చేయండి
- **రిట్రీవల్-ఆగ్మెంటెడ్ జనరేషన్ (RAG)**: మీ స్వంత డేటా సోర్స్‌లతో AIని కలపండి
- **ఫంక్షన్ కాలింగ్**: కస్టమ్ టూల్స్ మరియు ప్లగిన్లతో AI సామర్థ్యాలను విస్తరించండి
- **[→ చాప్టర్ 3 ప్రారంభించండి](./03-CoreGenerativeAITechniques/README.md)**

### **చాప్టర్ 4: ప్రాక్టికల్ అప్లికేషన్లు & ప్రాజెక్టులు**
- **పెట్ స్టోరీ జనరేటర్** (`petstory/`): GitHub మోడల్స్‌తో క్రియేటివ్ కంటెంట్ జనరేషన్
- **ఫౌండ్రీ లోకల్ డెమో** (`foundrylocal/`): OpenAI జావా SDKతో లోకల్ AI మోడల్ ఇంటిగ్రేషన్
- **MCP కాలిక్యులేటర్ సర్వీస్** (`calculator/`): స్ప్రింగ్ AIతో ప్రాథమిక మోడల్ కాంటెక్స్ట్ ప్రోటోకాల్ అమలు
- **[→ చాప్టర్ 4 ప్రారంభించండి](./04-PracticalSamples/README.md)**

### **చాప్టర్ 5: బాధ్యతాయుత AI అభివృద్ధి**
- **GitHub మోడల్స్ సేఫ్టీ**: బిల్ట్-ఇన్ కంటెంట్ ఫిల్టరింగ్ మరియు సేఫ్టీ మెకానిజంలను పరీక్షించండి (హార్డ్ బ్లాక్స్ మరియు సాఫ్ట్ రిఫ్యూజల్స్)
- **బాధ్యతాయుత AI డెమో**: ఆధునిక AI సేఫ్టీ సిస్టమ్‌లు ప్రాక్టికల్‌గా ఎలా పనిచేస్తాయో చూపించే హ్యాండ్స్-ఆన్ ఉదాహరణ
- **ఉత్తమ పద్ధతులు**: నైతిక AI అభివృద్ధి మరియు అమలుకు అవసరమైన మార్గదర్శకాలు
- **[→ చాప్టర్ 5 ప్రారంభించండి](./05-ResponsibleGenAI/README.md)**

## అదనపు వనరులు

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### Azure / Edge / MCP / ఏజెంట్లు
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### జనరేటివ్ AI సిరీస్
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### కోర్ లెర్నింగ్
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

మీరు ఎక్కడైనా ఆగిపోయినా లేదా AI యాప్‌లను నిర్మించడం గురించి ఏవైనా ప్రశ్నలు ఉంటే, ఇతర అభ్యాసకులు మరియు అనుభవజ్ఞులైన డెవలపర్లతో MCP గురించి చర్చించండి. ఇది ప్రశ్నలు స్వాగతించబడే మరియు జ్ఞానం స్వేచ్ఛగా పంచబడే సహాయక సముదాయం.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

మీకు ఉత్పత్తి ఫీడ్‌బ్యాక్ లేదా నిర్మాణంలో లోపాలు ఉంటే, సందర్శించండి:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**అస్వీకరణ**:  
ఈ పత్రం AI అనువాద సేవ [Co-op Translator](https://github.com/Azure/co-op-translator) ఉపయోగించి అనువదించబడింది. మేము ఖచ్చితత్వానికి ప్రయత్నిస్తున్నప్పటికీ, ఆటోమేటెడ్ అనువాదాలు తప్పులు లేదా అసమగ్రతలను కలిగి ఉండవచ్చు. దాని స్వదేశ భాషలో ఉన్న అసలు పత్రాన్ని అధికారం కలిగిన మూలంగా పరిగణించాలి. కీలకమైన సమాచారం కోసం, ప్రొఫెషనల్ మానవ అనువాదాన్ని సిఫారసు చేస్తాము. ఈ అనువాదాన్ని ఉపయోగించడం వల్ల కలిగే ఏవైనా అపార్థాలు లేదా తప్పుదారులు కోసం మేము బాధ్యత వహించము.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->