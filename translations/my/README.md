# Generative AI for Beginners - Java Edition
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/my/beg-genai-series.8b48be9951cc574c.webp)

**အချိန်ဝန်ခံချက်**: စုပေါင်း အလုပ်ရုံဆွေးနွေးပွဲကို တိုက်ရိုက် ပြင်ပဖြစ်စေပြီး ဒေသတွင်း ပြင်ဆင်မှုမလိုအပ်ပါ။ ပတ်ဝန်းကျင်ပြင်ဆင်ခြင်း အချိန် ၂ မိနစ်ခန့် စေပြီး နမူနာများကို ရှာဖွေဖတ်ရှုရန် ၁-၃ နာရီ ကြာမြင့်နိုင်ပါသည်။

> **လျင်မြန်စွာ စတင်ရန်** 

1. ဤ repository ကို သင့် GitHub အကောင့်သို့ Fork လုပ်ပါ
2. **Code** → **Codespaces** tab → **...** → **New with options...** ကို နှိပ်ပါ
3. ပုံမှန်များကို အသုံးပြုပါ – ဒါဟာ ဒီသင်ခန်းစာအတွက် ဖန်တီးထားသော Development container ကို ရွေးချယ်ပေးပါလိမ့်မည်
4. **Create codespace** ကို နှိပ်ပါ
5. ပတ်ဝန်းကျင် ပြင်ဆင်မှုအတွက် ~၂ မိနစ် စောင့်ပါ
6. တိုက်ရိုက် [ပထမ ဥပမာ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) သို့ ခုန်ပါ

> **ဒေသတွင်း မှ Cloning လုပ်ချင်ပါသလား?**
>
> ဤ repository သည် ဘာသာစကား ၅၀ ကျော် အပြန်အလှန်စာတမ်းများပါဝင်ပြီး ဒေါင်းလုဒ်အရွယ်အစားကို တော်တော်များများ တိုးမြှင့်သည်။ ဘာသာပြန်ချက်များမပါဝင်ဘဲ Clone လုပ်ရန် sparse checkout ကို အသုံးပြုပါ:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ဒါက သင်ကောစီကို မြန်ဆန်စွာ ပြီးမြောက်နိုင်စေရန် လိုအပ်သည့် အရာအားလုံးကို ပေးပါသည်။

## ဘာသာစကား များစွာအတွက် ထောက်ပံ့မှု

### GitHub Action မှတဆင့် ထောက်ပံ့သည် (အလိုအလျောက် & အမြဲသစ်လုံလောက်)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](./README.md) | [Chinese (Simplified)](../zh-CN/README.md) | [Chinese (Traditional, Hong Kong)](../zh-HK/README.md) | [Chinese (Traditional, Macau)](../zh-MO/README.md) | [Chinese (Traditional, Taiwan)](../zh-TW/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Kannada](../kn/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Malayalam](../ml/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Nigerian Pidgin](../pcm/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../pt-BR/README.md) | [Portuguese (Portugal)](../pt-PT/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Telugu](../te/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)

> **ဒေသတွင်း မှ Cloning လုပ်ချင်ပါသလား?**

> ဤ repository သည် ဘာသာစကား ၅၀ ကျော် အပြန်အလှန်စာတမ်းများပါဝင်ပြီး ဒေါင်းလုဒ်အရွယ်အစားကို တော်တော်များများ တိုးမြှင့်သည်။ ဘာသာပြန်ချက်များမပါဝင်ဘဲ Clone လုပ်ရန် sparse checkout ကို အသုံးပြုပါ:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ဒါက သင်ကောစီကို မြန်ဆန်စွာ ပြီးမြောက်နိုင်စေရန် လိုအပ်သည့် အရာအားလုံးကို ပေးပါသည်။
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## သင်ခန်းစာ ဖွဲ့စည်းမှု & သင်ယူနိုင်ရာ လမ်းညွှန်

### **ပိုင်း ၁: Generative AI မိတ်ဆက်ခြင်း**
- **အခြေခံအယူအဆများ**: အကြီးစားဘာသာစကားမော်ဒယ်များကို နားလည်ခြင်း၊ tokens, embeddings နှင့် AI လုပ်ဆောင်နိုင်စွမ်းများ
- **Java AI ပတ်ဝန်းကျင်**: Spring AI နှင့် OpenAI SDK များ အကြောင်းအရာ
- **Model Context Protocol**: MCP နှင့် AI ကိုယ်စားလှယ်များ ဆက်သွယ်မှုအတွက် မိတ်ဆက်ခြင်း
- **လက်တွေ့လျောက်ထားမှုများ**: ဒီဇိုင်း ဆွဲရေးစနစ်များပါဝင်သည့် ရှေ့ပြေးအခြေအနေများ (chatbots, အကြောင်းအရာဖန်တီးမှု)
- **[→ ပထမပိုင်း စတင်ရန်](./01-IntroToGenAI/README.md)**

### **ပိုင်း ၂: ဖွံ့ဖြိုးရေး ပတ်ဝန်းကျင် ပြင်ဆင်ခြင်း**
- **Multi-Provider ဖွဲ့စည်းမှု**: GitHub Models, Azure OpenAI, နှင့် OpenAI Java SDK တွဲဖက် အသုံးပြုခြင်း
- **Spring Boot + Spring AI**: လုပ်ငန်းအသုံး AI application ဖွံ့ဖြိုးမှုအတွက် အကောင်းဆုံး အကျင့်
- **GitHub Models**: စမ်းသပ်မှုနှင့် သင်ယူမှုအတွက် အခမဲ့ AI မော်ဒယ်များ (credit card မလိုအပ်ပါ)
- **ဖွံ့ဖြိုးရေးကိရိယာများ**: Docker containers, VS Code, နှင့် GitHub Codespaces တပ်ဆင်ခြင်း
- **[→ ဒုတိယပိုင်း စတင်ရန်](./02-SetupDevEnvironment/README.md)**

### **ပိုင်း ၃: အခြေခံ Generative AI နည်းပညာများ**
- **Prompt Engineering**: AI မော်ဒယ် တုံ့ပြန်မှုများ အကောင်းဆုံးရရှိရန် နည်းလမ်းများ
- **Embeddings & Vector လုပ်ဆောင်ချက်များ**: semantic ရှာဖွေရေး နှင့် similarity တွဲဖက်ခြင်း
- **Retrieval-Augmented Generation (RAG)**: သင့်ကိုယ်ပိုင် ဒေတာစမ်းတင်မှုနှင့် AI ကိုပေါင်းစပ်ခြင်း
- **Function Calling**: စိတ်ကြိုက် ကိရိယာများနှင့် plugin များဖြင့် AI လုပ်ဆောင်နိုင်စွမ်း တိုးချဲ့ခြင်း
- **[→ တတိယပိုင်း စတင်ရန်](./03-CoreGenerativeAITechniques/README.md)**

### **ပိုင်း ၄: လက်တွေ့လျောက်ထားမှုများနှင့် စီမံကိန်းများ**
- **Pet Story Generator** (`petstory/`): GitHub Models ဖြင့် ဖန်တီးမှုအကြောင်းအရာ များ
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK ဖြင့် ဒေသတွင်း AI မော်ဒယ် စမ်းသပ်ခြင်း
- **MCP Calculator Service** (`calculator/`): Spring AI နှင့် အခြေခံ Model Context Protocol ကျင့်သုံးမှု
- **[→ စတင်ရန် ပိုင်း ၄](./04-PracticalSamples/README.md)**

### **ပိုင်း ၅: တာဝန်ယူနိုင်သော AI ဖန်တီးခြင်း**
- **GitHub Models အရေးကြီးမှု**: အတွင်းစိတ် စစ်ဆေးမှု၊ safety လုပ်ဆောင်ချက်များ စမ်းသပ်ခြင်း (hard block နှင့် soft refusal စနစ်များ)
- **တာဝန်ယူနိုင်သော AI ဒေမို**: ခေတ်မီသော AI လုံခြုံမှုစနစ်များ လက်တွေ့ ပြသမှု
- **အကောင်းဆုံး လေ့လာအကြံပြုချက်များ**: သကျဖွံ့ဖြိုးမှုနှင့် ထုတ်လုပ်မှုအတွက် လိုအပ်သော စည်းကမ်းများ
- **[→ စတင်ရန် ပိုင်း ၅](./05-ResponsibleGenAI/README.md)**

## အထပ်ထပ် အရင်းအမြစ်များ

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
 
### အခြေခံ သင်ယူမှု
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Copilot မျိုးဆက်များ
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## အကူအညီရယူခြင်း

AI အက်ပ်များဖန်တီးရာတွင် အခက်အခဲများ ဖြစ်ပေါ်ခဲ့လျှင် သို့မဟုတ် မေးခွန်းများရှိပါက MCP အကြောင်း လေ့လာသူများနှင့် အတွေ့အကြုံရှိသော ဖန်တီးသူများနှင့် ဆွေးနွေးပွဲများတွင် ပါဝင်နိုင်ပါသည်။ ဤနေရာတွင် မေးခွန်းများကို ကြိုဆိုပြီး သိပ္ပံပညာများကို ပြန်လည်မျှဝေသည့် ကူညီမှုများ ပြုလုပ်နေသော ပတ်ဝန်းကျင်တစ်ခု ဖြစ်ပါသည်။

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

ထုတ်ကုန်အကြံပြုချက်များ သို့မဟုတ် တည်ဆောက်ခြင်းအတွင်း ဖြစ်ပွားသော အမှားများရှိပါက အောက်ပါရန်ပုံကြည့်ရန်:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**အသိပေးချက်**  
ဤစာတမ်းကို AI ဘာသာပြန်ခြင်းဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) မှ အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှန်ကန်မှုအတွက် ကြိုးပမ်းပေမယ့် ကိုယ်ပိုင်အလိုအလျောက် ဘာသာပြန်ခြင်းများတွင် လွဲမှားချက်များ သို့မဟုတ် မှားယွင်းချက်များ ပါဝင်နိုင်ခြင်းကို သတိပြုပါရန် တိုက်တွန်းပါသည်။ မူရင်းစာတမ်းကို နိုင်ငံဘာသာဖြင့်သာ အာဏာပိုင်အဖြစ် သတ်မှတ်စဉ်းစားရမည်ဖြစ်သည်။ အရေးကြီးသော သတင်းအချက်အလက်များအတွက် မည်သည့်ဘက်မှ လူ့ဘာသာပြန်ကို အကြံပြုပါသည်။ ဤဘာသာပြန်ချက်အသုံးပြုမှုကြောင့် ဖြစ်ပေါ်မည့် အနှောင့်အယွင်းများ သို့မဟုတ် အလွဲသုံးစားမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။
<!-- CO-OP TRANSLATOR DISCLAIMER END -->