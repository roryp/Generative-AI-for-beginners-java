<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:38:04+00:00",
  "source_file": "README.md",
  "language_code": "ta"
}
-->
# தொடக்க நிலை Generative AI - ஜாவா பதிப்பு
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![தொடக்க நிலை Generative AI - ஜாவா பதிப்பு](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.ta.png)

**நேர ஒதுக்கீடு**: முழு பணிக்கூடத்தை உள்ளூர் அமைப்பின்றி ஆன்லைனில் முடிக்கலாம். சூழல் அமைப்புக்கு 2 நிமிடங்கள் தேவைப்படும், மாதிரிகளை ஆராய்வதற்கு 1-3 மணி நேரம் தேவைப்படும் (ஆராய்ச்சி ஆழத்தைப் பொறுத்து).

> **விரைவான தொடக்கம்**

1. இந்த repository-ஐ உங்கள் GitHub கணக்கிற்கு Fork செய்யவும்
2. **Code** → **Codespaces** tab → **...** → **New with options...** என்பதைக் கிளிக் செய்யவும்
3. இயல்புநிலை அமைப்புகளை பயன்படுத்தவும் – இது இந்த பாடத்திற்கான Development container-ஐ தேர்ந்தெடுக்கும்
4. **Create codespace** என்பதைக் கிளிக் செய்யவும்
5. சூழல் தயாராக ~2 நிமிடங்கள் காத்திருக்கவும்
6. [முதல் உதாரணத்திற்கு](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) நேரடியாக செல்லவும்

## பல மொழி ஆதரவு

### GitHub Action மூலம் ஆதரவு (தானியங்கி மற்றும் எப்போதும் புதுப்பிக்கப்பட்டது)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](../my/README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../br/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](./README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## பாடத்திட்ட அமைப்பு மற்றும் கற்றல் பாதை

### **அத்தியாயம் 1: Generative AI அறிமுகம்**
- **முக்கிய கருத்துக்கள்**: பெரிய மொழி மாதிரிகள், டோக்கன்கள், எம்பெடிங்குகள் மற்றும் AI திறன்களைப் புரிந்துகொள்வது
- **ஜாவா AI சூழல்**: Spring AI மற்றும் OpenAI SDKs பற்றிய மேலோட்டம்
- **மாதிரி சூழல் நெறிமுறை**: MCP மற்றும் AI ஏஜென்ட் தொடர்பில் அதன் பங்கு
- **நடைமுறை பயன்பாடுகள்**: chatbot மற்றும் உள்ளடக்க உருவாக்கம் போன்ற உண்மையான உலக நிகழ்வுகள்
- **[→ அத்தியாயம் 1 தொடங்கவும்](./01-IntroToGenAI/README.md)**

### **அத்தியாயம் 2: மேம்பாட்டு சூழல் அமைப்பு**
- **பல வழங்குநர் கட்டமைப்பு**: GitHub Models, Azure OpenAI மற்றும் OpenAI Java SDK ஒருங்கிணைப்புகளை அமைக்கவும்
- **Spring Boot + Spring AI**: நிறுவன AI பயன்பாடுகளை உருவாக்க சிறந்த நடைமுறைகள்
- **GitHub Models**: prototype மற்றும் கற்றலுக்கான இலவச AI மாதிரி அணுகல் (கடன் அட்டை தேவையில்லை)
- **மேம்பாட்டு கருவிகள்**: Docker containers, VS Code மற்றும் GitHub Codespaces அமைப்பு
- **[→ அத்தியாயம் 2 தொடங்கவும்](./02-SetupDevEnvironment/README.md)**

### **அத்தியாயம் 3: முக்கிய Generative AI தொழில்நுட்பங்கள்**
- **Prompt Engineering**: AI மாதிரி பதில்களுக்கு சிறந்த தொழில்நுட்பங்கள்
- **Embeddings & Vector Operations**: semantic தேடல் மற்றும் ஒத்திசைவு பொருத்தம் செயல்படுத்தவும்
- **Retrieval-Augmented Generation (RAG)**: உங்கள் சொந்த தரவூட்டங்களுடன் AI-ஐ இணைக்கவும்
- **Function Calling**: தனிப்பயன் கருவிகள் மற்றும் plugins மூலம் AI திறன்களை விரிவாக்கவும்
- **[→ அத்தியாயம் 3 தொடங்கவும்](./03-CoreGenerativeAITechniques/README.md)**

### **அத்தியாயம் 4: நடைமுறை பயன்பாடுகள் மற்றும் திட்டங்கள்**
- **Pet Story Generator** (`petstory/`): GitHub Models மூலம் படைப்பாற்றல் உள்ளடக்க உருவாக்கம்
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK உடன் உள்ளூர் AI மாதிரி ஒருங்கிணைப்பு
- **MCP Calculator Service** (`calculator/`): Spring AI உடன் அடிப்படை Model Context Protocol செயல்பாடு
- **[→ அத்தியாயம் 4 தொடங்கவும்](./04-PracticalSamples/README.md)**

### **அத்தியாயம் 5: பொறுப்பான AI மேம்பாடு**
- **GitHub Models Safety**: உள்ளடக்க வடிகட்டல் மற்றும் பாதுகாப்பு முறைமைகளை சோதிக்கவும் (கடின தடைகள் மற்றும் மென்மையான மறுதலைகள்)
- **Responsible AI Demo**: நவீன AI பாதுகாப்பு முறைமைகள் நடைமுறையில் எப்படி செயல்படுகின்றன என்பதை காட்டும் உதாரணம்
- **சிறந்த நடைமுறைகள்**: நெறிமுறை AI மேம்பாடு மற்றும் பயன்பாட்டிற்கான முக்கிய வழிகாட்டுதல்கள்
- **[→ அத்தியாயம் 5 தொடங்கவும்](./05-ResponsibleGenAI/README.md)**

## கூடுதல் வளங்கள்

- [Edge AI for Beginners](https://github.com/microsoft/edgeai-for-beginners)
- [MCP For Beginners](https://github.com/microsoft/mcp-for-beginners)
- [AI Agents For Beginners](https://github.com/microsoft/ai-agents-for-beginners)
- [Generative AI for Beginners using .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generative AI for Beginners using JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generative AI for Beginners](https://github.com/microsoft/generative-ai-for-beginners)
- [ML for Beginners](https://aka.ms/ml-beginners)
- [Data Science for Beginners](https://aka.ms/datascience-beginners)
- [AI for Beginners](https://aka.ms/ai-beginners)
- [Cybersecurity for Beginners](https://github.com/microsoft/Security-101)
- [Web Dev for Beginners](https://aka.ms/webdev-beginners)
- [IoT for Beginners](https://aka.ms/iot-beginners)
- [XR Development for Beginners](https://github.com/microsoft/xr-development-for-beginners)
- [Mastering GitHub Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI)
- [Mastering GitHub Copilot for C#/.NET Developers](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Choose Your Own Copilot Adventure](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App with Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## உதவி பெறுதல்

AI பயன்பாடுகளை உருவாக்குவதில் சிக்கல் அல்லது கேள்விகள் இருந்தால், இணைந்திடவும்:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

தயாரிப்பு கருத்துகள் அல்லது கட்டமைப்பில் பிழைகள் இருந்தால், பார்வையிடவும்:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**குறிப்பு**:  
இந்த ஆவணம் [Co-op Translator](https://github.com/Azure/co-op-translator) என்ற AI மொழிபெயர்ப்பு சேவையைப் பயன்படுத்தி மொழிபெயர்க்கப்பட்டுள்ளது. நாங்கள் துல்லியத்திற்காக முயற்சிக்கின்றோம், ஆனால் தானியங்கி மொழிபெயர்ப்புகளில் பிழைகள் அல்லது தவறான தகவல்கள் இருக்கக்கூடும் என்பதை கவனத்தில் கொள்ளவும். அதன் தாய்மொழியில் உள்ள மூல ஆவணம் அதிகாரப்பூர்வ ஆதாரமாக கருதப்பட வேண்டும். முக்கியமான தகவல்களுக்கு, தொழில்முறை மனித மொழிபெயர்ப்பு பரிந்துரைக்கப்படுகிறது. இந்த மொழிபெயர்ப்பைப் பயன்படுத்துவதால் ஏற்படும் எந்த தவறான புரிதல்கள் அல்லது தவறான விளக்கங்களுக்கு நாங்கள் பொறுப்பல்ல.