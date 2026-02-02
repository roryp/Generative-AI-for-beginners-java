# ஆரம்பத்துக்கான உருவாக்கும் AI - ஜாவா பதிப்பு
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/ta/beg-genai-series.8b48be9951cc574c.webp)

**நேரம் ஒதுக்கீடு**: முழு வேலை숷 ஃப் ஷாப் ஆன்லைனில் உள்ளூர் அமைப்பு இல்லாமல் முடிக்க முடியும். சூழல் அமைப்பு 2 நிமிடங்கள் எடுத்துக்கொள்ளும், மாதிரிகளை ஆராய 1-3 மணி நேரம் தேவைப்படும், ஆராய்ச்சி ஆழத்தைப் பொறுத்து.

> **விரைவு தொடக்கம்** 

1. இந்த அனுப்பகத்தை உங்கள் GitHub கணக்கிற்கு ஃபோர்க் செய்யவும்
2. கிளிக் செய்யவும் **Code** → **Codespaces** தாவல் → **...** → **New with options...**
3. பூரண அணுகல் தேர்வுகளைப் பயன்படுத்தவும் – இது இந்த பாடத்திட்டத்திற்கு உருவாக்கப்பட்ட அபிவிருத்தி கொண்டெய்னரை தேர்ந்தெடுக்கும்
4. கிளிக் செய்யவும் **Create codespace**
5. சூழல் தயார் ஆகியதற்கு சுமார் 2 நிமிடங்கள் காத்திருக்கவும்
6. நேரடியாக [முதல் உதாரணம்](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) நோக்கி செல்

> **உள்ளூரில் கிளோன் செய்ய விரும்புகிறீர்களா?**
>
> இந்த அனுப்பகம் 50+ மொழிபெயர்ப்புகளை உள்ளடக்கியது, இது பதிவிறக்கும் அளவைக் குறிப்பாக அதிகரிக்கிறது. மொழிபெயர்ப்புகள் இல்லாமல் கிளோன் செய்ய sparse checkout பயன்படுத்தவும்:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> இது உங்களுக்கு இந்த பாடத்திட்டத்தை முடிக்க தேவையான அனைத்தையும் மிக வேகமாக பதிவிறக்க உதவும்.


## பல மொழி ஆதரவு

### GitHub செயல்பாட்டின் மூலம் ஆதரவு (ஆட்டோமேட்டிக் மற்றும் எப்போதும் புதுப்பிக்கப்பட்டது)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[அரபு](../ar/README.md) | [பெங்காலி](../bn/README.md) | [பல்கேரியன்](../bg/README.md) | [பார்மீஸ் (மியான்மர்)](../my/README.md) | [சீன (எளிமையானது)](../zh-CN/README.md) | [சீன (பாரம்பரிய, ஹாங்காங்)](../zh-HK/README.md) | [சீன (பாரம்பரிய, மக்காவ்)](../zh-MO/README.md) | [சீன (பாரம்பரிய, தைவான்)](../zh-TW/README.md) | [குரோஷியன்](../hr/README.md) | [செக்](../cs/README.md) | [டேனிஷ்](../da/README.md) | [டச்சு](../nl/README.md) | [எஸ்டோனியன்](../et/README.md) | [பின்னிஷ்](../fi/README.md) | [பிரஞ்சு](../fr/README.md) | [ஜெர்மன்](../de/README.md) | [கிரேக்கம்](../el/README.md) | [ஹீബ്രு](../he/README.md) | [ஹிந்து](../hi/README.md) | [ஹங்கேரியன்](../hu/README.md) | [இந்தோனேஷியன்](../id/README.md) | [இத்தாலியன்](../it/README.md) | [ஜப்பானியன்](../ja/README.md) | [கன்னடம்](../kn/README.md) | [கொரியன்](../ko/README.md) | [லிதுவேனியன்](../lt/README.md) | [மலாய்](../ms/README.md) | [மலையாளம்](../ml/README.md) | [மராத்தி](../mr/README.md) | [நெபாளி](../ne/README.md) | [நைจีரியன் பிஜின்](../pcm/README.md) | [நார்வேஜியன்](../no/README.md) | [பார்சியன் (ஃபார்சி)](../fa/README.md) | [போலிஷ்](../pl/README.md) | [போர்த்துகீசிய (பிரேசில்)](../pt-BR/README.md) | [போர்த்துகீசிய (பொர்ச்சுகல்)](../pt-PT/README.md) | [பஞ்சாபி (குர்ம் முகி)](../pa/README.md) | [ரோமேனியன்](../ro/README.md) | [ரஷ்யன்](../ru/README.md) | [செர்பியன் (சிரிலிக்)](../sr/README.md) | [ஸ்லோவாக்](../sk/README.md) | [ஸ்லோவேனியன்](../sl/README.md) | [ஸ்பானிஷ்](../es/README.md) | [ஸ்வாஹிலி](../sw/README.md) | [ஸ்வீடிஷ்](../sv/README.md) | [தாகாலோக் (பிலிப்பைன்ஸ்)](../tl/README.md) | [தமிழ்](./README.md) | [தெலுங்கு](../te/README.md) | [தை](../th/README.md) | [துருக்கி](../tr/README.md) | [உக்ரைனியன்](../uk/README.md) | [உருது](../ur/README.md) | [வியயட்நாமீஸ்](../vi/README.md)

## பாடத் திட்ட அமைப்பு மற்றும் கற்றல் பாதை

### **அத்தியாயம் 1: உருவாக்கும் AI அறிமுகம்**
- **மூலக் கருத்துக்கள்**: பெரிய மொழி மாதிரிகள், டோக்கன்கள், எம்பெட்டிங்ஸ், மற்றும் AI திறன்களைப் புரிந்துகொள்ளுதல்
- **ஜாவா AI சூழல்**: ஸ்பிரிங் AI மற்றும் OpenAI SDK கள் குறித்த ஓவர் வியூ
- **மாடல் கருத்து நெறிமுறை**: MCP அறிமுகம் மற்றும் AI முகவரிகளுக்கிடையினான தொடர்பின் பங்கு
- **உயர்மையான பயன்பாடுகள்**: உரையாடல் பெயர்ப்புகள் மற்றும் உள்ளடக்கம் உருவாக்கி போன்ற உண்மையான உலக அரைகூறுகள்
- **[→ அத்தியாயம் 1 தொடங்குக](./01-IntroToGenAI/README.md)**

### **அத்தியாயம் 2: அபிவிருத்தி சூழல் அமைப்பு**
- **பல வழங்குநர் அமைப்புகள்**: GitHub மாதிரிகள், Azure OpenAI, மற்றும் OpenAI ஜாவா SDK இணைப்புகள் அமைத்தல்
- **ஸ்பிரிங் பூட் + ஸ்பிரிங் AI**: நிறுவன AI பயன்பாடு அபிவிருத்திக்கான சிறந்த நடைமுறைகள்
- **GitHub மாதிரிகள்**: ப்ரொடோடைபிங் மற்றும் கற்றலுக்கான இலவச AI மாதிரி அணுகல் (கிரெடிட் கார்டு தேவையில்லை)
- **அபிவிருத்தி கருவிகள்**: டாக்கர் கொண்டெய்னர்கள், VS குறியீடு மற்றும் GitHub Codespaces அம்சங்கள்
- **[→ அத்தியாயம் 2 தொடங்குக](./02-SetupDevEnvironment/README.md)**

### **அத்தியாயம் 3: முக்கிய உருவாக்கும் AI நுட்பங்கள்**
- **ப்ரம்ப்ட் பொறியியல்**: சிறந்த AI மாதிரி பதில்களைப் பெறும் தொழில்நுட்பங்கள்
- **எம்பெட்டிங்ஸ் மற்றும் வெக்டர் செயல்பாடுகள்**: பொருள் தேடல் மற்றும் ஒப்புமை பொருத்தத்தை செயல்படுத்தல்
- **தற்போதைய தரவு மூலம் உருவாக்கல் (RAG)**: AI-ஐ உங்கள் சொந்த தரவுத்தளத்துடன் இணைக்கவும்
- **செயற்கை அழைப்பு**: தனிப்பயன் கருவிகள் மற்றும் பிளகின்களுடன் AI திறன்களை விரிவாக்குக
- **[→ அத்தியாயம் 3 தொடங்குக](./03-CoreGenerativeAITechniques/README.md)**

### **அத்தியாயம் 4: பயிற்சி பயன்பாடுகள் மற்றும் திட்டங்கள்**
- **விலங்கு கதை உருவாக்கி** (`petstory/`): GitHub மாதிரிகளுடன் கலைப்பூர்வ உள்ளடக்கம் உருவாக்குதல்
- **Foundry உள்ளூர்த் டெமோ** (`foundrylocal/`): OpenAI ஜாவா SDK ஆக உள்ளூர் AI மாதிரி ஒருங்கிணைப்பு
- **MCP கணக்கீட்டாளர் சேவை** (`calculator/`): ஸ்பிரிங் AI மூலம் அடிப்படைக் மாடல் கருத்து நெறிமுறை அமலாக்கம்
- **[→ அத்தியாயம் 4 தொடங்குக](./04-PracticalSamples/README.md)**

### **அத்தியாயம் 5: பொறுப்பான AI அபிவிருத்தி**
- **GitHub மாதிரிகள் பாதுகாப்பு**: கட்டுமான உள்ளடக்கம் வடிகட்டல் மற்றும் பாதுகாப்பு அமைப்புக்கள் (கடுமையான தடைகள் மற்றும் மென்மையான மறுப்பு) பரிசோதனை செய்தல்
- **பொறுப்பான AI டெமோ**: நவீன AI பாதுகாப்பு அமைப்புகள் பணியில் எப்படி வேலை செய்கின்றன என்றதன் தொழில்நுட்ப உதாரணம்
- **சிறந்த நடைமுறைகள்**: நேர்மையான AI அபிவிருத்தி மற்றும் பிரசரிப்புக்கான முக்கிய வழிகாட்டல்கள்
- **[→ அத்தியாயம் 5 தொடங்குக](./05-ResponsibleGenAI/README.md)**

## கூடுதல் வளங்கள்

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### Azure / Edge / MCP / முகவர்கள்
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### உருவாக்கும் AI தொடர்முறை
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### மையக் கற்றல்
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![ஆரம்பக்காரர்கள் க்கான IoT](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![ஆரம்பக்காரர்கள் க்கான XR வளர்ச்சி](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### கோபிலைட் தொடர்
[![AI ஜோடி நிரலாக்கத்திற்கான கோபிலைட்](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![C#/.NET க்கான கோபிலைட்](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![கோபிலைட் சாகசம்](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## உதவி பெறுதல்

நீங்கள் பாதுக்கிடுப்பில் சிக்கினால் அல்லது AI பயன்பாடுகளை உருவாக்கும் சம்பந்தப்பட்ட ஏதேனும் கேள்விகள் இருந்தால். MCP பற்றிய விவாதங்களில் மற்ற கற்றல் வீரர்கள் மற்றும் அனுபவமுள்ள டெவலப்பர்கள் இணைக்கவும். கேள்விகள் வரவேற்கப்படுகிற சமூகத்தில் இது ஆதரவான குழுவாகும், அறிவு சுதந்திரமாக பகிரப்பட்டு வருகிறது.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

உங்களிடம் தயாரிப்பு கருத்துக்கள் அல்லது பிழைகள் இருந்தால் கட்டுமானத்தின் போது கீழ்க்கண்ட இடத்திற்கு செல்லவும்:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**விமோசனம்**:
இந்த ஆவணம் AI மொழி பெயர்ப்பு சேவை [Co-op Translator](https://github.com/Azure/co-op-translator) மூலம் மொழி பெயர்க்கப்பட்டுள்ளது. நாம் துல்லியத்திற்காக முயலினாலும், தானியங்கி மொழிபெயர்ப்புகளில் பிழைகள் அல்லது தவறுதல்கள் இருக்கலாம் என்று தயவுசெய்து கவனிக்கவும். உள்ளூர் மொழியில் இருக்கும் அசல் ஆவணம் அதிகாரப்பூர்வ ஆதாரமாக பரிந்துரைக்கப்படுகிறது. முக்கியமான தகவல்களுக்கு தொழில்முறை மனித மொழிபெயர்ப்பை பரிந்துரைக்கிறோம். இந்த மொழிபெயர்ப்பின் பயன்பாட்டால் ஏற்படும் ஏதாவது தவறான புரிதல்களுக்கு அல்லது தவறான விளக்கங்களுக்கு நாம் பொறுப்பேற்கமாட்டோம்.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->