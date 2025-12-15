<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0efa90a880213da0aeb35e43ec717e98",
  "translation_date": "2025-12-01T09:00:30+00:00",
  "source_file": "README.md",
  "language_code": "ta"
}
-->
# தொடக்கத்திற்கான ஜெனரேட்டிவ் AI - ஜாவா பதிப்பு
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![தொடக்கத்திற்கான ஜெனரேட்டிவ் AI - ஜாவா பதிப்பு](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.ta.png)

**நேர ஒதுக்கீடு**: இந்த முழு பணிக்கூட்டத்தை உள்ளூர் அமைப்பின்றி ஆன்லைனில் முடிக்கலாம். சூழல் அமைப்புக்கு 2 நிமிடங்கள் ஆகும், மாதிரிகளை ஆராய்வதற்கு ஆர்வத்தின் ஆழத்தைப் பொறுத்து 1-3 மணி நேரம் தேவைப்படும்.

> **விரைவான தொடக்கம்**

1. உங்கள் GitHub கணக்கில் இந்த களஞ்சியத்தை Fork செய்யவும்
2. **Code** → **Codespaces** தாவல் → **...** → **New with options...** என்பதைக் கிளிக் செய்யவும்
3. இயல்புநிலைகளை பயன்படுத்தவும் – இது இந்த பாடத்திட்டத்திற்காக உருவாக்கப்பட்ட Development container ஐத் தேர்ந்தெடுக்கும்
4. **Create codespace** என்பதைக் கிளிக் செய்யவும்
5. சூழல் தயாராக ~2 நிமிடங்கள் காத்திருக்கவும்
6. [முதல் உதாரணத்திற்கு](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) நேரடியாக செல்லவும்

## பல மொழி ஆதரவு

### GitHub Action மூலம் ஆதரிக்கப்படுகிறது (தானியங்கி மற்றும் எப்போதும் புதுப்பிக்கப்பட்டது)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[அரபு](../ar/README.md) | [பெங்காலி](../bn/README.md) | [பல்கேரியன்](../bg/README.md) | [பர்மீஸ் (மியான்மார்)](../my/README.md) | [சீனம் (எளிமைப்படுத்தப்பட்டது)](../zh/README.md) | [சீனம் (பாரம்பரியம், ஹாங்காங்)](../hk/README.md) | [சீனம் (பாரம்பரியம், மக்காவு)](../mo/README.md) | [சீனம் (பாரம்பரியம், தைவான்)](../tw/README.md) | [குரோஷியன்](../hr/README.md) | [செக்](../cs/README.md) | [டேனிஷ்](../da/README.md) | [டச்சு](../nl/README.md) | [எஸ்டோனியன்](../et/README.md) | [பின்னிஷ்](../fi/README.md) | [பிரெஞ்சு](../fr/README.md) | [ஜெர்மன்](../de/README.md) | [கிரேக்கம்](../el/README.md) | [ஹீப்ரு](../he/README.md) | [இந்தி](../hi/README.md) | [ஹங்கேரியன்](../hu/README.md) | [இந்தோனேஷியன்](../id/README.md) | [இத்தாலியன்](../it/README.md) | [ஜப்பானியன்](../ja/README.md) | [கன்னடம்](../kn/README.md) | [கொரியன்](../ko/README.md) | [லிதுவேனியன்](../lt/README.md) | [மலாய்](../ms/README.md) | [மலையாளம்](../ml/README.md) | [மராத்தி](../mr/README.md) | [நேபாளி](../ne/README.md) | [நைஜீரியன் பிஜின்](../pcm/README.md) | [நார்வேஜியன்](../no/README.md) | [பாரசீக (பார்ஸி)](../fa/README.md) | [போலிஷ்](../pl/README.md) | [போர்ச்சுகீஸ் (பிரேசில்)](../br/README.md) | [போர்ச்சுகீஸ் (போர்ச்சுகல்)](../pt/README.md) | [பஞ்சாபி (குர்முகி)](../pa/README.md) | [ரோமானியன்](../ro/README.md) | [ரஷியன்](../ru/README.md) | [செர்பியன் (சிரிலிக்)](../sr/README.md) | [ஸ்லோவாக்](../sk/README.md) | [ஸ்லோவேனியன்](../sl/README.md) | [ஸ்பானிஷ்](../es/README.md) | [சுவாஹிலி](../sw/README.md) | [ஸ்வீடிஷ்](../sv/README.md) | [டாகாலோக் (பிலிப்பைனோ)](../tl/README.md) | [தமிழ்](./README.md) | [தெலுங்கு](../te/README.md) | [தாய்](../th/README.md) | [துருக்கியம்](../tr/README.md) | [உக்ரேனியன்](../uk/README.md) | [உருது](../ur/README.md) | [வியட்நாமீஸ்](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## பாடத்திட்ட அமைப்பு மற்றும் கற்றல் பாதை

### **அத்தியாயம் 1: ஜெனரேட்டிவ் AI அறிமுகம்**
- **முக்கிய கருத்துக்கள்**: பெரிய மொழி மாதிரிகள், டோக்கன்கள், எம்பெட்டிங்ஸ் மற்றும் AI திறன்களைப் புரிந்துகொள்வது
- **ஜாவா AI சூழல்**: Spring AI மற்றும் OpenAI SDKகளின் மேற்பார்வை
- **மாதிரி சூழல் நெறிமுறை**: MCP மற்றும் AI முகவர் தொடர்பில் அதன் பங்கு அறிமுகம்
- **நடைமுறை பயன்பாடுகள்**: சாட்பாட்கள் மற்றும் உள்ளடக்க உருவாக்கம் போன்ற உலகளாவிய சூழல்கள்
- **[→ அத்தியாயம் 1 ஐ தொடங்கவும்](./01-IntroToGenAI/README.md)**

### **அத்தியாயம் 2: மேம்பாட்டு சூழல் அமைப்பு**
- **பல வழங்குநர் கட்டமைப்பு**: GitHub Models, Azure OpenAI மற்றும் OpenAI Java SDK ஒருங்கிணைப்புகளை அமைக்கவும்
- **Spring Boot + Spring AI**: நிறுவன AI பயன்பாடுகளை உருவாக்க சிறந்த நடைமுறைகள்
- **GitHub Models**: கற்றல் மற்றும் மாதிரி உருவாக்கத்திற்கான இலவச AI மாதிரி அணுகல் (கிரெடிட் கார்டு தேவையில்லை)
- **மேம்பாட்டு கருவிகள்**: Docker containers, VS Code மற்றும் GitHub Codespaces அமைப்பு
- **[→ அத்தியாயம் 2 ஐ தொடங்கவும்](./02-SetupDevEnvironment/README.md)**

### **அத்தியாயம் 3: முக்கிய ஜெனரேட்டிவ் AI தொழில்நுட்பங்கள்**
- **ப்ராம்ப்ட் இன்ஜினியரிங்**: AI மாதிரி பதில்களுக்கு சிறந்த தொழில்நுட்பங்கள்
- **எம்பெட்டிங்ஸ் மற்றும் வெக்டர் செயல்பாடுகள்**: அர்த்தமுள்ள தேடல் மற்றும் ஒத்திசைவு பொருத்தம் செயல்படுத்துதல்
- **Retrieval-Augmented Generation (RAG)**: உங்கள் சொந்த தரவூற்றுகளுடன் AI ஐ இணைத்தல்
- **செயல்பாடு அழைப்பு**: தனிப்பயன் கருவிகள் மற்றும் பிளகின்களுடன் AI திறன்களை விரிவாக்குதல்
- **[→ அத்தியாயம் 3 ஐ தொடங்கவும்](./03-CoreGenerativeAITechniques/README.md)**

### **அத்தியாயம் 4: நடைமுறை பயன்பாடுகள் மற்றும் திட்டங்கள்**
- **Pet Story Generator** (`petstory/`): GitHub Models உடன் படைப்பாற்றல் உள்ளடக்க உருவாக்கம்
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK உடன் உள்ளூர் AI மாதிரி ஒருங்கிணைப்பு
- **MCP Calculator Service** (`calculator/`): Spring AI உடன் அடிப்படை மாதிரி சூழல் நெறிமுறை செயல்படுத்தல்
- **[→ அத்தியாயம் 4 ஐ தொடங்கவும்](./04-PracticalSamples/README.md)**

### **அத்தியாயம் 5: பொறுப்பான AI மேம்பாடு**
- **GitHub Models பாதுகாப்பு**: உள்ளடக்க வடிகட்டி மற்றும் பாதுகாப்பு முறைமைகளை சோதிக்கவும் (கடின தடைகள் மற்றும் மென்மையான மறுதலைகள்)
- **பொறுப்பான AI டெமோ**: நவீன AI பாதுகாப்பு முறைமைகள் நடைமுறையில் எப்படி செயல்படுகின்றன என்பதை காட்டும் உதாரணம்
- **சிறந்த நடைமுறைகள்**: நெறிமுறையான AI மேம்பாடு மற்றும் பயன்பாட்டிற்கான முக்கிய வழிகாட்டுதல்கள்
- **[→ அத்தியாயம் 5 ஐ தொடங்கவும்](./05-ResponsibleGenAI/README.md)**

## கூடுதல் வளங்கள்

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### Azure / Edge / MCP / முகவர்கள்
[![தொடக்கத்திற்கான AZD](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![தொடக்கத்திற்கான எட்ஜ் AI](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![தொடக்கத்திற்கான MCP](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![தொடக்கத்திற்கான AI முகவர்கள்](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### ஜெனரேட்டிவ் AI தொடர்
[![தொடக்கத்திற்கான ஜெனரேட்டிவ் AI](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![ஜெனரேட்டிவ் AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![ஜெனரேட்டிவ் AI (ஜாவா)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![ஜெனரேட்டிவ் AI (ஜாவாஸ்கிரிப்ட்)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---

### முக்கிய கற்றல்
[![தொடக்கத்திற்கான ML](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![தொடக்கத்திற்கான தரவியல் அறிவியல்](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![தொடக்கத்திற்கான AI](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![தொடக்கத்திற்கான சைபர் பாதுகாப்பு](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![தொடக்கத்திற்கான வலை மேம்பாடு](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![தொடக்கத்திற்கான IoT](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![தொடக்கத்திற்கான XR மேம்பாடு](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### Copilot தொடர்
[![AI இணை நிரலாக்கத்திற்கான Copilot](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)  
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)  
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## உதவி பெறுதல்

நீங்கள் சிக்கலில் சிக்கினால் அல்லது AI பயன்பாடுகளை உருவாக்குவதில் ஏதேனும் கேள்விகள் இருந்தால், MCP பற்றிய விவாதங்களில் மற்ற பயிற்சியாளர்களும் அனுபவமுள்ள டெவலப்பர்களும் சேருங்கள். இது கேள்விகள் வரவேற்கப்படும் மற்றும் அறிவு இலவசமாக பகிரப்படும் ஒரு ஆதரவு சமூகமாகும்.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

உங்களுக்கு தயாரிப்பு கருத்துக்களோ அல்லது உருவாக்கத்தின் போது பிழைகளோ இருந்தால், கீழே செல்லவும்:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**குறிப்பு**:  
இந்த ஆவணம் AI மொழிபெயர்ப்பு சேவை [Co-op Translator](https://github.com/Azure/co-op-translator) பயன்படுத்தி மொழிபெயர்க்கப்பட்டுள்ளது. நாங்கள் துல்லியத்திற்காக முயற்சிக்கிறோம், ஆனால் தானியங்கி மொழிபெயர்ப்புகளில் பிழைகள் அல்லது தவறுகள் இருக்கக்கூடும் என்பதை கவனத்தில் கொள்ளவும். அதன் தாய்மொழியில் உள்ள மூல ஆவணம் அதிகாரப்பூர்வ ஆதாரமாக கருதப்பட வேண்டும். முக்கியமான தகவல்களுக்கு, தொழில்முறை மனித மொழிபெயர்ப்பு பரிந்துரைக்கப்படுகிறது. இந்த மொழிபெயர்ப்பைப் பயன்படுத்துவதால் ஏற்படும் எந்த தவறான புரிதல்கள் அல்லது தவறான விளக்கங்களுக்கு நாங்கள் பொறுப்பல்ல.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->