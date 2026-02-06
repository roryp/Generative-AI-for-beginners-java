# தொடக்கங்களுக்கு ஜெனரட்டிவ் AI - ஜாவா பதிப்பு
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/ta/beg-genai-series.8b48be9951cc574c.webp)

**கால கடமை**: முழு பட்டறை உள்ளூரில் அமைப்பில்லாமல் ஆன்லைனில் முடிக்க முடியும். சூழல் அமைப்பு 2 நிமிடம் எடுக்கும், மாதிரிகளை ஆராய்வது ஆராய்ச்சி ஆழத்தைப்பொறுத்து 1-3 மணி நேரம் எடுக்கலாம்.

> **துரித தொடக்கம்** 

1. இந்த ரெப்போசிடரியை உங்கள் GitHub கணக்குக்கு fork செய்யவும்
2. கிளிக் செய்யவும் **Code** → **Codespaces** tab → **...** → **New with options...**
3. இயல்புகளைப் பயன்படுத்தவும் – இது இந்த பாடத்துக்கான Development container ஐ தேர்ந்தெடுக்கும்
4. கிளிக் செய்யவும் **Create codespace**
5. சூழல் தயாராக ~2 நிமிடம் காத்திருங்கள்
6. நேரடியாக செல்லவும் [முதற் எடுத்துக்காட்டு](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **உள்ளூரில் Clone செய்ய விரும்புகிறீர்களா?**
>
> இந்த ரெப்போசிடரியில் 50+ மொழி மொழிபெயர்ப்புகள் உள்ளன, அவை பதிவிறக்க அளவை பெரிதாக அதிகரிக்கின்றன. மொழிபெயர்ப்புகள் இல்லாமல் clone செய்ய sparse checkout பயன்படுத்தவும்:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> இது நீங்கள் இந்த பாடத்தை முடிக்க தேவையான அனைத்தையும் விரைவான பதிவிறக்கம் மூலம் அளிக்கிறது.


## பன்மொழி ஆதரவு

### GitHub Action மூலம் ஆதரவு (தானியங்கி & எப்போதும் புதியதாய்)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[அரபிக்](../ar/README.md) | [பெங்காலி](../bn/README.md) | [பல்கேரியன்](../bg/README.md) | [புர்மீஸ் (மியான்மார்)](../my/README.md) | [சீனம் (எளிதாக்கப்பட்டது)](../zh-CN/README.md) | [சீனம் (பாரம்பரிய, ஹாங்காங்)](../zh-HK/README.md) | [சீனம் (பாரம்பரிய, மகாவு)](../zh-MO/README.md) | [சீனம் (பாரம்பரிய, டைவான்)](../zh-TW/README.md) | [குரொயேஷியன்](../hr/README.md) | [செക്ക്](../cs/README.md) | [டேனிஷ்](../da/README.md) | [டச்சு](../nl/README.md) | [எஸ்டோனியன்](../et/README.md) | [பின்னிஷ்](../fi/README.md) | [பிரஞ்சு](../fr/README.md) | [ஜெர்மன்](../de/README.md) | [கிரேக்கம்](../el/README.md) | [ஹிப்ரூ](../he/README.md) | [இந்தி](../hi/README.md) | [ஹங்கேரியன்](../hu/README.md) | [இந்தோனீஷியன்](../id/README.md) | [இத்தாலியன்](../it/README.md) | [ஜப்பானீஸ்](../ja/README.md) | [கன்னடம்](../kn/README.md) | [கொரியன்](../ko/README.md) | [லித்துவேனியன்](../lt/README.md) | [மலாய்](../ms/README.md) | [மலையாளம்](../ml/README.md) | [மரத்தி](../mr/README.md) | [நேபாளி](../ne/README.md) | [நைஜீரியன் பிட்ஜின்](../pcm/README.md) | [நோர்வேஜியன்](../no/README.md) | [பெர்ஷியன் (ஃபார்சி)](../fa/README.md) | [போலிஷ்](../pl/README.md) | [போர்ச்சுகீஸ் (பிரேசில்)](../pt-BR/README.md) | [போர்ச்சுகீஸ் (போர்ச்சுகல்)](../pt-PT/README.md) | [பஞ்சாபி (குருமுகி)](../pa/README.md) | [ரோமானியன்](../ro/README.md) | [ரஷ்யன்](../ru/README.md) | [செர்பியன் (சிரிலிக்)](../sr/README.md) | [ஸ்லோவாக்](../sk/README.md) | [ஸ்லோவேனியன்](../sl/README.md) | [ஸ்பானிஷ்](../es/README.md) | [ஸ்வாஹிலி](../sw/README.md) | [ஸ்வீடிஷ்](../sv/README.md) | [டாகலாக் (பிலிப்பீனோ)](../tl/README.md) | [தமிழ்](./README.md) | [தெலுங்கு](../te/README.md) | [தாய்](../th/README.md) | [துருக்கிய](../tr/README.md) | [உக்ரைனியன்](../uk/README.md) | [உருது](../ur/README.md) | [வியட்நாமீஸ்](../vi/README.md)

## பாட கட்டமைப்பு மற்றும் கற்றல் பாதை

### **அத்தியாயம் 1: ஜெனரட்டிவ் AI அறிமுகம்**
- **முக்கியக் கருத்துக்கள்**: பெரிய மொழி மாடல்களை, டோக்கன்களை, எம்பெட்டிங்களை, மற்றும் AI திறன்களைப் புரிந்துகொள்ளல்
- **ஜாவா AI சூழல்**: Spring AI மற்றும் OpenAI SDK-களின் மேல் கண்ணோட்டம்
- **மாடல் சூழல் நெறிமுறை**: MCP அறிமுகம் மற்றும் AI முகவர் தொடர்பில் அதன் பங்கு
- **வாசிப்புத் திட்டங்கள்**: உரையாடல் பொறிகள் மற்றும் உள்ளடக்கம் உருவாக்குதல் போன்ற உண்மை பரிசுகளுடன்
- **[→ அத்தியாயம் 1 தொடக்கம்](./01-IntroToGenAI/README.md)**

### **அத்தியாயம் 2: மேம்பாட்டு சூழல் அமைப்பு**
- **பல ஆதார அமைப்பு**: GitHub Models, Azure OpenAI, மற்றும் OpenAI Java SDK ஒருங்கிணைப்புகளை அமைக்கவும்
- **Spring Boot + Spring AI**: நிறுவன AI பயன்பாடுகள் உருவாக்க சீரிய நடைமுறைகள்
- **GitHub Models**: சோதனை மற்றும் கற்றலுக்கு இலவச AI மாடல் அணுகல் (கிரெடிட் கார்டு தேவையில்லை)
- **மேம்பாட்டு கருவிகள்**: Docker கன்டெய்னர்கள், VS Code, மற்றும் GitHub Codespaces அமைப்புகள்
- **[→ அத்தியாயம் 2 தொடக்கம்](./02-SetupDevEnvironment/README.md)**

### **அத்தியாயம் 3: முக்கிய ஜெனரட்டிவ் AI நுட்பங்கள்**
- **ப்ராம்ட் இன்ஜினியரிங்**: சிறந்த AI மாடல் பதில்களை பெறும் நுட்பங்கள்
- **எம்பெட்டிங்கள் மற்றும் வெக்டர் செயலிகள்**: பொருள் தேடல் மற்றும் ஒத்திசைவு பொருத்தல் செயலாக்கல்
- **திருப்பி பெறுதல் சார்ந்த உருவாக்கம் (RAG)**: உங்கள் சொந்த தரவு மூலங்களுடன் AI ஐ இணைக்கும்
- **வினா அழைப்பு**: தனிப்பயன் கருவிகள் மற்றும் பிளக்கின்களுடன் AI திறன்களை விரிவாக்கவும்
- **[→ அத்தியாயம் 3 தொடக்கம்](./03-CoreGenerativeAITechniques/README.md)**

### **அத்தியாயம் 4: நடைமுறை பயன்பாடுகள் மற்றும் திட்டங்கள்**
- **பேட் கதை உருவாக்கி** (`petstory/`): GitHub Models கொண்டு படைப்பாற்றல் உள்ளடக்கம் உருவாக்கல்
- **Foundry உள்ளூராட்சி டெமோ** (`foundrylocal/`): OpenAI Java SDK உடன் உள்ளூர் AI மாடல் ஒருங்கிணைப்பு
- **MCP கணக்கீட்டாளர் சேவை** (`calculator/`): Spring AI உடன் அடிப்படை மாடல் சூழல் நெறிமுறை அமலாக்கம்
- **[→ அத்தியாயம் 4 தொடக்கம்](./04-PracticalSamples/README.md)**

### **அத்தியாயம் 5: பொறுப்புடன் AI மேம்பாடு**
- **GitHub Models பாதுகாப்பு**: கட்டமைக்கப்பட்ட உள்ளடக்க வடிகட்டல் மற்றும் பாதுகாப்பு இயந்திரங்களை சோதனை செய்யவும் (கடும் தடைகள் மற்றும் மென்மையான மறுப்பு)
- **பொறுப்பான AI டெமோ**: நவீன AI பாதுகாப்பு முறைகளின் நடைமுறை உணர்ந்து காட்டும் எடுத்துக்காட்டு
- **சிறந்த நடைமுறைகள்**: நீதிமன்ற AI மேம்பாடு மற்றும் பயன்படுத்தல் வழிகாட்டுதல்கள்
- **[→ அத்தியாயம் 5 தொடக்கம்](./05-ResponsibleGenAI/README.md)**

## கூடுதல் வளங்கள்

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
 
### முக்கியக் கற்றல்
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### கோபைலட் தொடர்
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## உதவி பெறுதல்

நீங்கள் சிக்கிக்கொண்டால் அல்லது AI செயலிகளைக் கட்டுவதில் எதாவது கேள்விகள் இருந்தால் MCP பற்றி மற்ற பயில்வோர் மற்றும் அனுபவமுள்ள டெவலப்பர்களுடன் கலந்துரையாடல்களில் சேருங்கள். இது கேள்விகள் வரவேற்கப்படும் மற்றும் அறிவு சுதந்திரமாக பகிரப்படும் ஆதரவான சமூகம் ஆகும்.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

தயாரிப்பின் தொடர்பான பின்னூட்டம் அல்லது பிழைகள் இருந்தால், கட்டுமானத்தில் கீழ்கண்ட தளத்தை பார்வையிடவும்:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**குறிப்புரை**:
இந்த ஆவணம் AI மொழிபெயர்ப்பு சேவை [Co-op Translator](https://github.com/Azure/co-op-translator) மூலம் மொழிபெயர்க்கப்பட்டுள்ளது. நாம் துல்லியத்தை நோக்கினாலும், தானாகும் மொழிபெயர்ப்புகளில் பிழைகள் அல்லது தவறுகள் இருக்கக்கூடும் என்பதை தயவு செய்து கவனிக்கவும். அவ்வப்போது இருந்தாலும், அசல் ஆவணம் அதன் சொந்த மொழியில் அதிகாரப்பூர்வ ஆதாரமாக கருதப்பட வேண்டும். முக்கியமான தகவல்களுக்கு தொழில்முறை மனித மொழிபெயர்ப்பு பரிந்துரைக்கப்படுகிறது. இந்த மொழிபெயர்ப்பைப் பயன்படுத்துவதற்காக ஏற்பட்ட எந்த தவறான புரிதல்கள் அல்லது தவறான விளக்கங்களுக்கும் நாம் பொறுப்பேற்கமாட்டோம்.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->