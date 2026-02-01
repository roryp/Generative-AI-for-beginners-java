# စတင်လေ့လာသူများအတွက် Generative AI - Java ဗားရှင်း
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/my/beg-genai-series.8b48be9951cc574c.webp)

**အချိန်အပ်နှံမှု**: အားလုံးသောအလုပ်ရုံသင်တန်းကို ဒေသခံဆက်တင်မလိုဘဲ အွန်လိုင်းတွင် ပြီးမြောက်နိုင်သည်။ ပတ်ဝန်းကျင်ဆက်တင်ခြင်းမှာ ၂ မိနစ်ခန့်ကြာပြီး နမူနာများကို စူးစမ်းလေ့လာမှု သဘောအရ ၁-၃ နာရီ ကြာတတ်သည်။

> **အမြန်စတင်ရန်** 

1. ဤ repository ကို သင့် GitHub အကောင့်သို့ Fork လုပ်ပါ
2. **Code** → **Codespaces** tab → **...** → **New with options...** ကို နှိပ်ပါ
3. မူရင်း ဖော်ပြချက်များကို အသုံးပြုပြီး – ၎င်းဟာ ဒီသင်တန်းအတွက် ဖန်တီးထားသော Development container ကို ရွေးချယ်ပါလိမ့်မယ်
4. **Create codespace** ကို နှိပ်ပါ
5. ပတ်ဝန်းကျင် ကြိုတင်ပြင်ဆင်မှုအတွက် ~၂ မိနစ် ခန့် စောင့်ပါ
6. ကြိုတင် ဖတ်ရှုရန် [ပထမဥပမာ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) ဆီ သွားပါ

> **ဒေသခံသွင်းယူလိုပါသလား?**
>
> ဤ repository တွင် ဘာသာစကား ၅၀ ကျော် ဘာသာပြန်မှုများ ပါဝင်သည်၊ ၎င်းကြောင့် ဒေါင်းလုပ်ဖိုင်အရွယ်အစား တိုးပါတယ်။ ဘာသာပြန်ချက်များ မပါဘဲ clone လုပ်လိုပါက sparse checkout ကို အသုံးပြုပါ:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ဒီနည်းနဲ့ သင်အတတ်နိုင်သမျှကို များမြန်စွာ ဒေါင်းလုပ်ပြီး သင်တန်းကို ပြီးမြောက်နိုင်မှာ ဖြစ်ပါတယ်။


## ဘာသာစကားအမျိုးမျိုး ပံ့ပိုးမှု

### GitHub Action ဖြင့် ထောက်ပံ့ထားသည် (အလိုအလျောက် & အမြဲတမ်း ပြည့်စုံ)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[အာရဗီ](../ar/README.md) | [ဘင်္ဂါလီ](../bn/README.md) | [ဘူလ်ဂေးရီးယံ](../bg/README.md) | [မြန်မာ (Myanmar)](./README.md) | [တရုတ် (ရိုးရာလွယ်ကူသော)](../zh-CN/README.md) | [တရုတ် (ရိုးရာ၊ ဟောင်ကောင်)](../zh-HK/README.md) | [တရုတ် (ရိုးရာ၊ မာကာဝ်)](../zh-MO/README.md) | [တရုတ် (ရိုးရာ၊ ထိုင်ဝမ်)](../zh-TW/README.md) | [ခရိုအေးရှား](../hr/README.md) | [ချက်](../cs/README.md) | [ဒိန်းမတ်](../da/README.md) | [နယ်သာလန်](../nl/README.md) | [အက်စတိုနီးယား](../et/README.md) | [ဖင်လန်](../fi/README.md) | [ပြင်သစ်](../fr/README.md) | [ဂျာမန်](../de/README.md) | [ဂရိ](../el/README.md) | [ဟီဘရူး](../he/README.md) | [ဟိန္ဒီ](../hi/README.md) | [ဟန်ဂေရီ](../hu/README.md) | [အင်ဒိုနီးရှား](../id/README.md) | [အီတလီ](../it/README.md) | [ဂျပန်](../ja/README.md) | [ကန်နဒါ](../kn/README.md) | [ကိုရီးယား](../ko/README.md) | [လစ်သူအေးနီးယား](../lt/README.md) | [မလေး](../ms/README.md) | [မလေးလာမ်](../ml/README.md) | [မာရသီ](../mr/README.md) | [နီပေါ](../ne/README.md) | [ไนဂျီးရီးယားပစ်ဂျင်](../pcm/README.md) | [နော်ဝေ](../no/README.md) | [ပါရှန် (ဖာစီ)](../fa/README.md) | [ပိုလန်](../pl/README.md) | [ပေါ်တူဂီ (ဘရာဇီးလ်)](../pt-BR/README.md) | [ပေါ်တူဂီ (ပိုတူဂီ)](../pt-PT/README.md) | [ပန်ဂျာဘီ (ဂူရ်မူခီ)](../pa/README.md) | [ရိုမေးနီးယား](../ro/README.md) | [ရုရှား](../ru/README.md) | [ဆားဘီးယား (ဆီးရီးလစ်)](../sr/README.md) | [စလိုဗတ်](../sk/README.md) | [စလိုဗေးနီးယား](../sl/README.md) | [စပိန်](../es/README.md) | [ဆွာဟီလီ](../sw/README.md) | [ဆွီဒင်](../sv/README.md) | [တဂါလိုက် (ဖီလစ်ပိုင်)](../tl/README.md) | [တမီး](../ta/README.md) | [တယ်လူဂူ](../te/README.md) | [ထိုင်း](../th/README.md) | [တူရကီ](../tr/README.md) | [ယူကရိန်း](../uk/README.md) | [ဥရုဒူ](../ur/README.md) | [ဗီယက်နမ်](../vi/README.md)

## သင်တန်းဖွဲ့စည်းမှုနှင့် သင်ယူမှုလမ်းစဉ်

### **အခန်း ၁: Generative AI သို့ မိတ်ဆက်ခြင်း**
- **အဓိက အယူအဆများ**: ကြီးမားသော ဘာသာစကား ပုံစံများ၊ token များ၊ embedding များ၊ နှင့် AI ၏ စွမ်းဆောင်ရည်များကို နားလည်ခြင်း
- **Java AI ပတ်ဝန်းကျင်**: Spring AI နှင့် OpenAI SDK များအကြောင်း အမြင်
- **Model Context Protocol**: MCP နှင့် AI agent ဆက်သွယ်မှုတွင် ၎င်း၏ အခန်းကဏ္ဍ မိတ်ဆက်ခြင်း
- **လက်တွေ့အသုံးချမှုများ**: စကားပြောစက်များနှင့် အကြောင်းအရာ ဖန်တီးခြင်းတို့ ပါဝင်သော နောက်ခံအမှုများ
- **[→ အခန်း ၁ စတင်ရန်](./01-IntroToGenAI/README.md)**

### **အခန်း ၂: ဖွံ့ဖြိုးမှု ပတ်ဝန်းကျင် ဆက်တင်ခြင်း**
- **Provider များစုံ ညှိနှိုင်းခြင်း**: GitHub Models, Azure OpenAI, နှင့် OpenAI Java SDK ပေါင်းစပ်ဆောင်ရွက်ခြင်း
- **Spring Boot + Spring AI**: စက်မှုလုပ်ငန်းအဆင့် AI app ဖွံ့ဖြိုးမှုအကောင်းဆုံး လုပ်ထုံးလုပ်နည်းများ
- **GitHub Models**: AI ပုံစံများအတွက် အခမဲ့ အသုံးပြုခွင့် (credit card မလို)
- **ဖွံ့ဖြိုးရေးကိရိယာများ**: Docker container များ၊ VS Code နှင့် GitHub Codespaces ကို ဆက်တင်ခြင်း
- **[→ အခန်း ၂ စတင်ရန်](./02-SetupDevEnvironment/README.md)**

### **အခန်း ၃: အဓိက Generative AI နည်းစနစ်များ**
- **Prompt Engineering**: AI မော်ဒယ် အကြုံပြန်ချက်အတွက် နည်းလမ်းများ
- **Embedding များနှင့် ဗက်တောက် လုပ်ငန်းများ**: သဘောထားရှာဖွေရေးနှင့် ဆင်တူမှု ကို လုပ်ဆောင်ခြင်း
- **Retrieval-Augmented Generation (RAG)**: ကိုယ်ပိုင် ဒေတာများနှင့် AI ပေါင်းစပ်ခြင်း
- **Function Calling**: AI စွမ်းရည်ကို custom ကိရိယာများနှင့် plugin များဖြင့် တိုးချဲ့ခြင်း
- **[→ အခန်း ၃ စတင်ရန်](./03-CoreGenerativeAITechniques/README.md)**

### **အခန်း ၄: လက်တွေ့အသုံးပြုမှုများ နှင့် စီမံကိန်းများ**
- **Pet Story Generator** (`petstory/`): GitHub Models ဖြင့် စိတ်ကြိုက်အကြောင်းအရာ ဖန်တီးခြင်း
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK ဖြင့် ဒေသခံ AI ပုံစံ ပေါင်းစပ်ခြင်း
- **MCP Calculator Service** (`calculator/`): Spring AI ဖြင့် Model Context Protocol ဖြင့် မူလ ဆောင်ရွက်ချက်
- **[→ အခန်း ၄ စတင်ရန်](./04-PracticalSamples/README.md)**

### **အခန်း ၅: တာဝန်ရှိသော AI ဖွံ့ဖြိုးမှု**
- **GitHub Models လုံခြုံရေး**: အတွင်းတည် content filtering နှင့် လုံခြုံရေးစနစ် စမ်းသပ်ခြင်း (အသုံးမပြုခွင့် ပိတ်ဆို့ခြင်းနှင့် ပျော့ပြောင်းငြင်းချခြင်း)
- **တာဝန်ရှိသော AI ကိုယ်စားပြု ဂျပ်မာ**: ယနေ့ခေတ် AI လုံခြုံရေး စနစ်များ လက်တွေ့ ပြသခြင်း
- **အကောင်းဆုံး လုပ်ထုံးလုပ်နည်းများ**: တရားဝင် AI ဖွံ့ဖြိုးခြင်းနှင့် တပ်ဆင်ခြင်း အတွက် လမ်းညွှန်ချက်များ
- **[→ အခန်း ၅ စတင်ရန်](./05-ResponsibleGenAI/README.md)**

## အပိုဆောင်း ရင်းမြစ်များ

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

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
 
### မူလ သင်ယူမှု
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Copilot စီးရီး
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## ကူညီမှု ရယူခြင်း

AI အက်ပ်များ တည်ဆောက်ရာတွင် တစ်ခါတစ်ရံ မရောက်မနေ ဖြစ်ပွားခဲ့လျှင် သို့မဟုတ် မေးခွန်းများရှိပါက MCP နှင့်ပတ်သက်၍ အတူတကွ သင်ယူသူများနှင့် အတွေ့အကြုံရှိ ဒီဗေလော်ပတ်များက ဖလှယ်ဆွေးနွေးနေသော အဖွဲ့ဝင်များနှင့် ဆွေးနွေးနိုင်ပါသည်။ ၎င်းသည် မေးခွန်းများ ဆွေးနွေးပြီး သတင်းအချက်အလက်များ မရပ်မနား မျှ၀ေမှု အဖွဲ့အစည်းတစ်ခု ဖြစ်ပါသည်။

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

ကုန်ပစ္စည်း ဆိုင်ရာ တုံ့ပြန်ချက်များ သို့မဟုတ် အချက်အလက်များ ဖော်ပြခြင်း တွင် ပြဿနာရှိပါက ဤနေရာတွင် သွားရောက်ကြည့်ရှုနိုင်ပါသည် -

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ဆိုင်းငံ့ချက်**  
ဤစာတမ်းကို AI ဘာသာပြန်မှုဝန်ဆောင်မှုဖြစ်သော [Co-op Translator](https://github.com/Azure/co-op-translator) အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှန်ကန်မှုအတွက် ကြိုးစားသော်လည်း၊ အလိုအလျောက်ဘာသာပြန်မှုများတွင် အမှားများ သို့မဟုတ် မှားယွင်းမှုများ ဖြစ်ပေါ်နိုင်ကြောင်း သတိပေးပါသည်။ မူရင်းစာတမ်းကို မိခင်ဘာသာဖြင့်သာ ထောက်ခံသင့်ပါသည်။ အရေးကြီးသောသတင်းအချက်အလက်များအတွက် များအတွက် ဖြစ်ပါက လူ့ဘာသာပြန်ပညာရှင်မှ ဘာသာပြန်ပေးရန် အကြံပြုပါသည်။ ဤဘာသာပြန်ချက်ကို အသုံးပြုမှုကြောင့် ဖြစ်ပေါ်လာနိုင်သည့် နားမလည်မှုများ သို့မဟုတ် မှားယွင်းဖော်ပြချက်များအတွက် ကျွန်ုပ်တို့တွင် တာဝန်မရှိပါ။
<!-- CO-OP TRANSLATOR DISCLAIMER END -->