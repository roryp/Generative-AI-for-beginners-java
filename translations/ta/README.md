# முன்மொழியப்பட்ட செயற்கை நுண்ணறிவு ஆரம்பக்காரர்களுக்கு - ஜாவா பதிப்பு
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/ta/beg-genai-series.8b48be9951cc574c.webp)

**நேர அக்கறை**: அனைத்து பணிமனையும் ஆன்லைனில் உள்ளடக்கப்பட்டுள்ளது மற்றும் உள்ளூர் அமைப்பு தேவையில்லை. சுற்றளவு அமைப்பு 2 நிமிடங்கள் ஆகும், எடுத்துக்காட்டு ஆய்வுகள் 1-3 மணி நேரம், ஆய்வு ஆழச் சார்பின்படி.

> **விரைவான தொடக்கம்**

1. இந்த சேமிப்பிடத்தை உங்கள் GitHub கணக்கிற்கு Fork செய்யவும்
2. கிளிக் செய்க **Code** → **Codespaces** தாப் → **...** → **புதிதாக விருப்பங்களில்...**
3. இயல்புகளைப் பயன்படுத்தவும் – இது இந்த பாடத்திட்டம் உருவாக்கியுள்ள வளர்ச்சி కంటెయిన్ தேர்வு செய்யும்
4. கிளிக் செய்க **Create codespace**
5. சூழல் தயாராக ~2 நிமிடங்கள் காத்திருக்கவும்
6. நேரடியாக குதிக்கவும் [முதல் எடுத்துக்காட்டு](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **உள்நோக்கி கிளோன் செய்ய விரும்புவீர்களா?**
>
> இந்த சேமிப்பிடம் 50+ மொழி மொழிபெயர்ப்புகளை கொண்டுள்ளது, இது பதிவிறக்க அளவை குறிப்பிடத்தக்கமாக அதிகரிக்கிறது. மொழிபெயர்ப்புகள் இல்லாமல் கிளோன் செய்ய sparse checkout பயன்படுத்து:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> இதன்மூலம் பாடத்திட்டத்தை முடிக்க தேவையான அனைத்தும் மிக வேகமாக பதிவிறக்கம் செய்ய முடியும்.


## பல மொழி ஆதரவு

### GitHub செயல்முறை மூலம் ஆதரிக்கப்பட்டது (தானாகவும் எப்போதும் புதுப்பிக்கப்படும்)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[அரபு](../ar/README.md) | [பெங்காலி](../bn/README.md) | [பல்கேரியன்](../bg/README.md) | [பர்மீஸ் (மியன்மார்)](../my/README.md) | [சீனா (சாதாரண)](../zh-CN/README.md) | [சீனா (பாரம்பரிய, ஹாங்காங்)](../zh-HK/README.md) | [சீனா (பாரம்பரிய, மாகாவ்)](../zh-MO/README.md) | [சீனா (பாரம்பரிய, தைவான்)](../zh-TW/README.md) | [கிரோஷியன்](../hr/README.md) | [செக்](../cs/README.md) | [டேனிஷ்](../da/README.md) | [டச்சு](../nl/README.md) | [எஸ்டோனியன்](../et/README.md) | [பின்னிஷ்](../fi/README.md) | [பிரஞ்சு](../fr/README.md) | [ஜெர்மன்](../de/README.md) | [கிரேக்கம்](../el/README.md) | [ஹீப்ரூ](../he/README.md) | [இந்தி](../hi/README.md) | [ஹங்கேரியன்](../hu/README.md) | [இந்தோனேஷியன்](../id/README.md) | [இத்தாலியன்](../it/README.md) | [ஜப்பானியன்](../ja/README.md) | [கன்னடம்](../kn/README.md) | [கொரியன்](../ko/README.md) | [லிதுவேனியன்](../lt/README.md) | [மலாய்](../ms/README.md) | [மலையாளம்](../ml/README.md) | [மராத்தி](../mr/README.md) | [நெபாளி](../ne/README.md) | [நைஜீரியன் பிட்ஜின்](../pcm/README.md) | [நோர்வேஜியன்](../no/README.md) | [பெர்ஷியன் (ஃபார்ஸி)](../fa/README.md) | [போலிஷ்](../pl/README.md) | [போர்ச்சுகீஸ் (பிரேசில்)](../pt-BR/README.md) | [போர்ச்சுகீஸ் (போர்ச்சுகல்)](../pt-PT/README.md) | [பஞ்சாபி (குர்முகி)](../pa/README.md) | [ரோமேனியன்](../ro/README.md) | [ரஷ்யன்](../ru/README.md) | [செர்பியன் (சிரிலிக்)](../sr/README.md) | [ஸ்லோவாக்](../sk/README.md) | [ஸ்லோவேனியன்](../sl/README.md) | [ஸ்பானிஷ்](../es/README.md) | [ஸ்வாஹிலி](../sw/README.md) | [ஸ்வீடிஷ்](../sv/README.md) | [தகாலோக் (பிலிப்பைன்ஸ்)](../tl/README.md) | [தமிழ்](./README.md) | [தேளுகு](../te/README.md) | [தாய்](../th/README.md) | [துருக்கி](../tr/README.md) | [உக்ரைனியன்](../uk/README.md) | [உருது](../ur/README.md) | [வியட்நாமீஸ்](../vi/README.md)

> **உள்நோக்கி கிளோன் செய்ய விரும்புவீர்களா?**

> இந்த சேமிப்பிடம் 50+ மொழி மொழிபெயர்ப்புகளை கொண்டுள்ளது, இது பதிவிறக்க அளவை குறிப்பிடத்தக்கமாக அதிகரிக்கிறது. மொழிபெயர்ப்புகள் இல்லாமல் கிளோன் செய்ய sparse checkout பயன்படுத்து:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> இதன்மூலம் பாடத்திட்டத்தை முடிக்க தேவையான அனைத்தும் மிக வேகமாக பதிவிறக்கம் செய்ய முடியும்.
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## பாடத்திட்ட அமைப்பு மற்றும் கற்றல் பாதை

### **அத்தியாயம் 1: உருவாக்கும் செயற்கை நுண்ணறிவுக்கான அறிமுகம்**
- **முதன்மை கருத்துக்கள்**: பெரிய குறிப்புபடங்கள், டோக்கன்கள், எம்பெட்டிங்குகள் மற்றும் செயற்கை நுண்ணறிவு திறன்கள் புரிதல்
- **ஜாவா AI சூழல்**: Spring AI மற்றும் OpenAI SDK-களின் நிலையான கண்ணோட்டம்
- **மாதிரி சூழல் ஒட்டுமொத்தக் கொள்கை**: MCP அறிமுகமும் AI முகவரிகள் தொடர்பின் பங்கு
- **பயன்முறை பயன்பாடுகள்**: சந்தைபோட்டிகள் மற்றும் உள்ளடக்க உருவாக்கம் உட்பட உண்மையான உலக நிகழ்வுகள்
- **[→ அத்தியாயம் 1 தொடங்கு](./01-IntroToGenAI/README.md)**

### **அத்தியாயம் 2: வளர்ச்சி சூழல் அமைப்பு**
- **பல வழங்குநர் ஒருங்கிணைப்பு**: GitHub மாதிரிகள், Azure OpenAI மற்றும் OpenAI ஜாவா SDK இணைப்பு அமைக்க
- **Spring Boot + Spring AI**: நிறுவன AI பயன்பாட்டு உருவாக்கதிற்கான சிறந்த நடைமுறைகள்
- **GitHub மாதிரிகள்**: மாதிரிப்பதிவு மற்றும் கற்றலுக்கான இலவச AI மாதிரி அணுகல் (கடன் அட்டை தேவையில்லை)
- **வளர்ச்சி கருவிகள்**: Docker கன்டெய்னர்கள், VS Code மற்றும் GitHub Codespaces அமைப்புகள்
- **[→ அத்தியாயம் 2 தொடங்கு](./02-SetupDevEnvironment/README.md)**

### **அத்தியாயம் 3: முக்கிய உருவாக்கும் AI தொழில்நுட்பங்கள்**
- **பிராம்ட் பொறியியல்**: சிறந்த AI மாதிரி பதில்கள் பெறும் தொழில்நுட்பங்கள்
- **எம்பெட்டிங்குகள் மற்றும் வெக்டர் செயல்பாடுகள்**: அர்த்தமுள்ள தேடல் மற்றும் ஒத்திசைவை நடைமுறைப்படுத்துதல்
- **பின்வாங்கல் ஆதரவு உருவாக்கம் (RAG)**: உங்கள் சொந்த தரவு மூலங்கள் உடன் AI இணைத்தல்
- **செயல்பாடு அழைப்பு**: தனிப்பயன் கருவிகள் மற்றும் இணைப்பிகளுடன் AI திறன்களை விரிவாக்குதல்
- **[→ அத்தியாயம் 3 தொடங்கு](./03-CoreGenerativeAITechniques/README.md)**

### **அத்தியாயம் 4: பயன்முறை பயன்பாடுகள் மற்றும் திட்டங்கள்**
- **Pet Story Generator** (`petstory/`): GitHub மாதிரிகளுடன் சிருஷ்டிப்புலமான உள்ளடக்க உருவாக்குதல்
- **Foundry Local Demo** (`foundrylocal/`): OpenAI ஜாவா SDK உடன் உள்ளூர் AI மாதிரி ஒருங்கிணைப்பு
- **MCP கணக்கீட்டாளர் சேவை** (`calculator/`): Spring AI உடன் அடிப்படையிலான மாதிரி சூழல் ஒட்டுமொத்தக் கொள்கை நடைமுறைப்படுத்தல்
- **[→ அத்தியாயம் 4 தொடங்கு](./04-PracticalSamples/README.md)**

### **அத்தியாயம் 5: பொறுப்பூா்வ AI உருவாக்கல்**
- **GitHub மாதிரிகள் பாதுகாப்பு**: உள்ளீடு வடிகட்டி மற்றும் பாதுகாப்பு நெறிமுறைகள் (கடுமையான தடைகள் மற்றும் மென்மையான மறுப்பு) சோதனை செய்ய
- **பொறுப்பூா்வ AI டெமோ**: நவீன AI பாதுகாப்புக் கண்காணிப்பு அமைப்புகளின் செயல்பாடுகளை நேரடி உதாரணமாக காட்டுதல்
- **சிறந்த நடைமுறைகள்**: நீதி மற்றும் பொறுப்புடன் AI உருவாக்கல் மற்றும் வெளியீட்டு வழிகாட்டு குறிப்புகள்
- **[→ அத்தியாயம் 5 தொடங்கு](./05-ResponsibleGenAI/README.md)**

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

### உருவாக்கும் AI தொடர்
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---

### மூலக் கற்றல்
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)

[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### கோபைலட் தொடர்ச்சி
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## உதவி பெறுதல்

நீங்கள் சிக்கிக்கொண்டிருந்தால் அல்லது AI செயலிகள் உருவாக்குவதற்கான எந்தவொரு கேள்வியும் இருந்தால். MCP பற்றி கூடுதல் பயிலாளர்கள் மற்றும் அனுபவமுள்ள முன்னேற்றுபவர்களுடன் விவாதங்களில் இணைந்து கொள்ளுங்கள். இது கேள்விகள் கேட்கப்பட்டு அறிவு சுதந்திரமாக பகிரப்படும் ஒரு ஆதரவான சமூகமாகும்.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

உங்கள் கருத்துக்கள் அல்லது பிழைகள் இருந்தால் கட்டுமானத்தின் போது பார்வையிடவும்:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ஜரிமாணம்**:
இந்தக் கூற்றுப்பत्रம் AI மொழிபெயர்ப்பு சேவை [Co-op Translator](https://github.com/Azure/co-op-translator) மூலம் மொழி மாற்றப்பட்டுள்ளது. நாங்கள் துல்லியத்தை உறுதிப்படுத்த முயலினாலும், தானாக செய்யப்பட்ட மொழிபெயர்ப்புகளில் பிழைகள் அல்லது தவறான தகவல்கள் இருக்கக்கூடும் என்பதைக் கருத்தில் கொள்ளுங்கள். அசல் ஆவணம் அதன் சொந்த மொழியில் ஆக்கப்பூர்வமான ஆதாரமாகக் கருதப்பட வேண்டும். முக்கியமான தகவல்களுக்கு, மனுஷ்யன் தொழில்முறை மொழிபெயர்ப்பு பரிந்துரைக்கப்படுகிறது. இம்மொழிபெயர்ப்பினால் ஏற்படும் எந்த தவறான புரிதல்கள் அல்லது தவறான விளக்கங்களுக்கு நாங்கள் பொறுப்பார் அல்ல.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->