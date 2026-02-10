# Generative AI for Beginners - Java Edition
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/my/beg-genai-series.8b48be9951cc574c.webp)

**အချိန်အပ်နှံမှု**: စက်တို local setup မလိုဘဲ အွန်လိုင်းပေါ်မှာ အလုပ်ရုံလုံးဝပြီးစီးနိုင်သည်။ ပတ်ဝန်းကျင်အား ၂ မိနစ်စာ တပ်ဆင်ရန် ကြာပြီး နမူနာများကို စူးစမ်းရန် လေ့လာမှု အနက်အလယ် ပြုလုပ်မူပေါ် မူတည်၍ ၁-၃ နာရီကာလလိုအပ်သည်။

> **အမြန်စတင်ခြင်း**

1. ဒီ repository ကို သင့် GitHub မှာ Fork လုပ်ပါ
2. **Code** → **Codespaces** အတန်း → **...** → **New with options...** ကိုနှိပ်ပါ
3. Default များကို အသုံးပြုပါ – ၎င်းသည် ဒီသင်တန်းအတွက် ဖန်တီးထားသော Development container ကို ရွေးချယ်မည်
4. **Create codespace** ကို နှိပ်ပါ
5. ပတ်ဝန်းကျင် ပြင်ဆင်ပြီး မိနစ် ၂ ခန့် စောင့်ဆိုင်းပါ
6. တိုက်ရိုက် [ပထမဥပမာ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) သို့ သွားပါ

> **ဒေသတွင် Clone လုပ်ချင်သောသူများ?**
>
> ဒီ repository တွင် ဘာသာစကား ၅၀ ကျော်၏ ဘာသာပြန်ထားမှုရှိပြီး ဒါကြောင့် ဖိုင်ဒေါင်းလုပ်အရွယ်အစား ကြီးမားသည်။ ဘာသာပြန်ခြင်းမပါဘဲ clone လုပ်ရန် sparse checkout ကို အသုံးပြုနိုင်သည်။
>
> **Linux / macOS (Bash)**
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
>
> **Windows (PowerShell)**
> ```powershell
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone "/*" "!translations" "!translated_images"
> ```
>  သင်သည် သင်ကြားမှု ပြီးမြောက်စေရန် လိုအပ်သမျှ အရာအားလုံးကို လျင်မြန်စွာ ဒေါင်းလုပ်ဆွဲနိုင်မည်ဖြစ်သည်။


## ဘာသာစကားစုံ ပံ့ပိုးမှု

### GitHub Action မှတဆင့် ထောက်ပံ့သည် (အလိုအလျောက်နှင့် အမြဲတမ်းနောက်ဆုံးထိန်းသိမ်းထားသည်)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](./README.md) | [Chinese (Simplified)](../zh-CN/README.md) | [Chinese (Traditional, Hong Kong)](../zh-HK/README.md) | [Chinese (Traditional, Macau)](../zh-MO/README.md) | [Chinese (Traditional, Taiwan)](../zh-TW/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Kannada](../kn/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Malayalam](../ml/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Nigerian Pidgin](../pcm/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../pt-BR/README.md) | [Portuguese (Portugal)](../pt-PT/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Telugu](../te/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)

## သင်တန်းဖွဲ့စည်းမှုနှင့် သင်ယူမှုလမ်းကြောင်း

### **အခန်း ၁: Generative AI ကို မိတ်ဆက်ခြင်း**
- **အခြေခံအတွေးအခေါ်များ**: ကြီးမားသောဘာသာစကားမော်ဒယ်များ၊ token များ၊ embedding များနှင့် AI စွမ်းဆောင်ရည်များကို နားလည်ခြင်း
- **Java AI ကမာပဒ်**: Spring AI နှင့် OpenAI SDK များ အကြောင်းအနှစ်ချုပ်
- **Model Context Protocol**: MCP ကိုမိတ်ဆက်ခြင်းနှင့် AI တာဝန်ထမ်းအေးဂျင့် ဆက်သွယ်မှုရှိရာနေရာ
- **လက်တွေ့လျှပ်စစ်သုံးဆာဇ်များ**: စကားပြောဂျဉ်၊ အကြောင်းအရာဖန်တီးမှု အပါအဝင် လက်တွေ့အသုံးချမှုများ
- **[→ အခန်း ၁ စတင်ရန်](./01-IntroToGenAI/README.md)**

### **အခန်း ၂: ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင် တပ်ဆင်ခြင်း**
- **အများပြည်သူ ပံ့ပိုးမှုများ**: GitHub Models, Azure OpenAI နှင့် OpenAI Java SDK နှင့် ပေါင်းစပ်တပ်ဆင်ခြင်း
- **Spring Boot + Spring AI**: စီးပွားရေးအဆောက်အဦ AI အက်ပလီကေးရှင်း ဖန်တီးမှု အကောင်းဆုံးလေ့လာမှုစနစ်များ
- **GitHub Models**: prototype ဖန်တီးခြင်းနှင့် သင်ယူခြင်းအတွက် အခမဲ့ AI မော်ဒယ် အသုံးပြုခြင်း (ခရက်ဒစ်ကတ် မလိုအပ်ပါ)
- **ဖွံ့ဖြိုးရေးကိရိယာများ**: Docker ကွန်တိန်နာများ၊ VS Code နှင့် GitHub Codespaces ကို တပ်ဆင်ခြင်း
- **[→ အခန်း ၂ စတင်ရန်](./02-SetupDevEnvironment/README.md)**

### **အခန်း ၃: Generative AI အခြေခံနည်းပညာများ**
- **Prompt Engineering**: AI မော်ဒယ် ဖြေကြားချက် အကောင်းဆုံး စနစ်များ
- **Embedding များနှင့် Vector လုပ်ဆောင်ချက်များ**: အဓိပ္ပါယ်ရှာဖွေရေးနှင့် ညီလျော်မှုကို တိုးတက်စွာ ဆောင်ရွက်ခြင်း
- **Retrieval-Augmented Generation (RAG)**: ကိုယ်ပိုင်ဒေတာရင်းမြစ်များနှင့် AI ကို ပေါင်းစပ်ခြင်း
- **Function Calling**: AI ၏စွမ်းစေ့မှုများကို ကိုယ်ပိုင်ကိရိယာများနှင့် ပလပ်ဂင်များဖြင့် တိုးချဲ့ခြင်း
- **[→ အခန်း ၃ စတင်ရန်](./03-CoreGenerativeAITechniques/README.md)**

### **အခန်း ၄: လက်တွေ့အသုံးချမှုများနှင့် ပရောဂျက်များ**
- **Pet Story Generator** (`petstory/`): GitHub Models ဖြင့် ဖန်တီးချက် အကြောင်းအရာ ဖန်တီးခြင်း
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK ဖြင့် ဒေသတွင်း AI မော်ဒယ် ပေါင်းစပ်ခြင်း
- **MCP Calculator Service** (`calculator/`): Spring AI ဖြင့် အခြေခံ Model Context Protocol အကောင်အထည်ဖော်ခြင်း
- **[→ အခန်း ၄ စတင်ရန်](./04-PracticalSamples/README.md)**

### **အခန်း ၅: တာဝန်ယူသော AI ဖွံ့ဖြိုးတိုးတက်မှု**
- **GitHub Models လုံခြုံရေး**: ထည့်သွင်းထားသော အကြောင်းအရာ စစ်ထုတ်ခြင်းနှင့် လုံခြုံရေးစနစ်များ စမ်းသပ်ရန် (ခက်ခဲသော ကန့်သတ်ချက်များနှင့် ကြီးကြပ်မှုများ)
- **တာဝန်ယူသော AI များ Demo**: လက်တွေ့မှာ AI လုံခြုံရေးစနစ် များ ယေဘုယျအဖြစ် ဖော်ပြခြင်း
- **အကောင်းဆုံးလေ့လာမှုများ**: ကျင့်ဝတ်မဲ၊ တာဝန်ယူမှုဖြင့် AI ဖြန့်ချိခြင်းနှင့် ဖွံ့ဖြိုးမှုအတွက် လမ်းညွှန်ချက်များ
- **[→ အခန်း ၅ စတင်ရန်](./05-ResponsibleGenAI/README.md)**

## နောက်ထပ် အရင်းအမြစ်များ

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
 
### Core Learning
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Copilot Series
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## ဝ◌ိ◌ဉာ်ရည်ကူညီမှုရယူခြင်း

AI အက်ပ်များ တည်ဆောက်ရာတွင် ဆင်းရဲနေပါက သို့မဟုတ် မေးခွန်းများရှိပါက MCP အကြောင်း လူအများနှင့် အတွေ့အကြုံရှိ ဖန်တီးသူများနှင့် ပြောဆိုဆွေးနွေးပါ။ အဲဒီမှာ မေးခွန်းဖြစ်ပေါ်နိုင်ပြီး အတတ်ပညာစာသင်များ အခမဲ့မျှဝေကြသည့် ကူညီထောက်ပံ့မှုရှိသော အသိုင်းအဝိုင်းတစ်ခု ဖြစ်ပါသည်။

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

ထုတ်ကုန်တုံ့ပြန်ချက်များ သို့မဟုတ် အမှားများ ရှိပါက တည်ဆောက်နေစဉ်တွင် အောက်ပါတွင် ဝင်ရောက်ကြည့်ရှုနိုင်ပါသည်-

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ဆိုင်းငံ့ချက်**  
ဤစာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှုဖြစ်သော [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် မှန်ကန်မှုအတွက် ကြိုးစားပေမယ့် အလိုအလျောက် ဘာသာပြန်မှုများအတွက် အမှားများ သို့မဟုတ် မှားယွင်းချက်များ ပါဝင်နိုင်ကြောင်း သတိပေးလိုသည်။ မူလစာတမ်းကို မိမိဘာသာစကားရှိ ပြည့်စုံသည့် အရင်းအမြစ်အဖြစ် ယူဆသင့်ပါသည်။ အရေးပါတဲ့ အချက်အလက်များအတွက် လူသား ကျွမ်းကျင်အရည်အချင်းရှိ ဘာသာပြန်သူမှ ဘာသာပြန်မှုကို အကြံပြုပါသည်။ ဤဘာသာပြန်ချက်ကို အသုံးပြုရာမှ ဖြစ်ပေါ်နိုင်သည့် နားလည်မှုမှားယွင်းခြင်း သို့မဟုတ် အဓိပ္ပါယ်မှားယွင်းခြင်းအတွက် ကျွန်ုပ်တို့ တာဝန်မရှိပါ။
<!-- CO-OP TRANSLATOR DISCLAIMER END -->