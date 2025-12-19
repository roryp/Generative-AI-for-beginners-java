<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b1a467efb7f8e13a19f961a587226f71",
  "translation_date": "2025-12-18T10:34:29+00:00",
  "source_file": "README.md",
  "language_code": "my"
}
-->
# Generative AI for Beginners - Java Edition
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.my.png)

**အချိန်ပေးရန်**: အလုပ်ရုံလုံးဝကို အွန်လိုင်းပေါ်တွင် ပြီးမြောက်နိုင်ပြီး ဒေသတွင်း စနစ်တပ်ဆင်မှု မလိုအပ်ပါ။ ပတ်ဝန်းကျင်တပ်ဆင်ခြင်းမှာ ၂ မိနစ်ကြာပြီး နမူနာများကို စူးစမ်းရန် ၁-၃ နာရီကြာနိုင်သည်၊ စူးစမ်းမှု အနက်အရှည်ပေါ်မူတည်သည်။

> **အမြန်စတင်ရန်**

1. ဤ repository ကို သင့် GitHub အကောင့်သို့ Fork လုပ်ပါ
2. **Code** → **Codespaces** tab → **...** → **New with options...** ကို နှိပ်ပါ
3. ပုံမှန်တန်ဖိုးများကို အသုံးပြုပါ – ဤသည် သင်တန်းအတွက် ဖန်တီးထားသော Development container ကို ရွေးချယ်ပါလိမ့်မည်
4. **Create codespace** ကို နှိပ်ပါ
5. ပတ်ဝန်းကျင် ပြင်ဆင်မှု ပြီးမြောက်ရန် ~၂ မိနစ် စောင့်ပါ
6. တိုက်ရိုက် [ပထမဥပမာ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) သို့ သွားပါ

> **ဒေသတွင်း Clone လုပ်ချင်ပါသလား?**
>
> ဤ repository တွင် ဘာသာစကား ၅၀ ကျော် ဘာသာပြန်ချက်များ ပါဝင်ပြီး ဒေါင်းလုပ်အရွယ်အစားကို အလွန်ကြီးစေသည်။ ဘာသာပြန်ချက် မပါဘဲ clone လုပ်ရန် sparse checkout ကို အသုံးပြုပါ:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ၎င်းသည် သင်တန်းကို အလျင်အမြန်ပြီးမြောက်စေရန် လိုအပ်သည့် အရာအားလုံးကို ပေးပါသည်။

## ဘာသာစကားများစွာ ထောက်ပံ့မှု

### GitHub Action ဖြင့် ထောက်ပံ့သည် (အလိုအလျောက်နှင့် အမြဲတမ်း နောက်ဆုံးပေါ်)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](./README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Kannada](../kn/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Malayalam](../ml/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Nigerian Pidgin](../pcm/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../br/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Telugu](../te/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## သင်တန်းဖွဲ့စည်းမှုနှင့် သင်ယူမှုလမ်းကြောင်း

### **အခန်း ၁: Generative AI အကြောင်းအရာ မိတ်ဆက်ခြင်း**
- **အဓိက အယူအဆများ**: ကြီးမားသော ဘာသာစကား မော်ဒယ်များ၊ token များ၊ embedding များနှင့် AI စွမ်းဆောင်ရည်များကို နားလည်ခြင်း
- **Java AI ပတ်ဝန်းကျင်**: Spring AI နှင့် OpenAI SDK များအကြောင်း အနှစ်ချုပ်
- **Model Context Protocol**: MCP နှင့် AI အေးဂျင့် ဆက်သွယ်မှုတွင် ၎င်း၏ အခန်းကဏ္ဍ မိတ်ဆက်ခြင်း
- **လက်တွေ့ အသုံးချမှုများ**: စကားပြောစက်များနှင့် အကြောင်းအရာ ဖန်တီးခြင်း အပါအဝင် အမှန်တကယ် ဖြစ်ပေါ်နေသော အခြေအနေများ
- **[→ အခန်း ၁ စတင်ရန်](./01-IntroToGenAI/README.md)**

### **အခန်း ၂: ဖွံ့ဖြိုးရေး ပတ်ဝန်းကျင် တပ်ဆင်ခြင်း**
- **အမျိုးမျိုးသော ပံ့ပိုးသူများ စနစ်တကျ တပ်ဆင်ခြင်း**: GitHub Models, Azure OpenAI, နှင့် OpenAI Java SDK ပေါင်းစပ်ခြင်း
- **Spring Boot + Spring AI**: စီးပွားရေး AI အက်ပလီကေးရှင်း ဖွံ့ဖြိုးရေးအတွက် အကောင်းဆုံး လေ့လာမှုများ
- **GitHub Models**: prototype ဖန်တီးခြင်းနှင့် သင်ယူရန် အခမဲ့ AI မော်ဒယ် အသုံးပြုခွင့် (ကဒ်မလိုအပ်)
- **ဖွံ့ဖြိုးရေးကိရိယာများ**: Docker container များ၊ VS Code နှင့် GitHub Codespaces တပ်ဆင်မှု
- **[→ အခန်း ၂ စတင်ရန်](./02-SetupDevEnvironment/README.md)**

### **အခန်း ၃: အဓိက Generative AI နည်းပညာများ**
- **Prompt Engineering**: AI မော်ဒယ် အကောင်းဆုံး တုံ့ပြန်မှု ရရှိစေရန် နည်းလမ်းများ
- **Embedding နှင့် Vector လုပ်ဆောင်ချက်များ**: semantic ရှာဖွေရေးနှင့် ဆင်တူမှု ကိုက်ညီမှု အကောင်အထည်ဖော်ခြင်း
- **Retrieval-Augmented Generation (RAG)**: သင့်ကိုယ်ပိုင် ဒေတာအရင်းအမြစ်များနှင့် AI ပေါင်းစပ်ခြင်း
- **Function Calling**: AI စွမ်းဆောင်ရည်များကို စိတ်ကြိုက် ကိရိယာများနှင့် plugin များဖြင့် တိုးချဲ့ခြင်း
- **[→ အခန်း ၃ စတင်ရန်](./03-CoreGenerativeAITechniques/README.md)**

### **အခန်း ၄: လက်တွေ့ အသုံးချမှုများနှင့် ပရောဂျက်များ**
- **Pet Story Generator** (`petstory/`): GitHub Models ဖြင့် ဖန်တီးမှု အကြောင်းအရာ ဖန်တီးခြင်း
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK ဖြင့် ဒေသတွင်း AI မော်ဒယ် ပေါင်းစပ်ခြင်း
- **MCP Calculator Service** (`calculator/`): Spring AI ဖြင့် အခြေခံ Model Context Protocol အကောင်အထည်ဖော်ခြင်း
- **[→ အခန်း ၄ စတင်ရန်](./04-PracticalSamples/README.md)**

### **အခန်း ၅: တာဝန်ရှိသော AI ဖွံ့ဖြိုးရေး**
- **GitHub Models လုံခြုံရေး**: အတွင်းပိုင်း အကြောင်းအရာ စစ်ထုတ်ခြင်းနှင့် လုံခြုံရေး စနစ်များ (ခိုင်မာသော တားမြစ်မှုများနှင့် နူးညံ့သော ငြင်းဆန်မှုများ) စမ်းသပ်ခြင်း
- **တာဝန်ရှိသော AI ဒေမို**: ခေတ်မီ AI လုံခြုံရေး စနစ်များ လက်တွေ့ အလုပ်လုပ်ပုံ ကို ပြသသော လက်တွေ့ ဥပမာ
- **အကောင်းဆုံး လေ့လာမှုများ**: တာဝန်ရှိသော AI ဖွံ့ဖြိုးရေးနှင့် တပ်ဆင်မှုအတွက် အရေးကြီးသော လမ်းညွှန်ချက်များ
- **[→ အခန်း ၅ စတင်ရန်](./05-ResponsibleGenAI/README.md)**

## အပိုဆောင်း အရင်းအမြစ်များ

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
 
### Core Learning
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

## အကူအညီရယူခြင်း

AI အက်ပ်များ တည်ဆောက်ရာတွင် အခက်အခဲများရှိပါက သို့မဟုတ် မေးခွန်းများရှိပါက MCP အကြောင်း ဆွေးနွေးမှုများတွင် အတူတကွ သင်ယူနေသူများနှင့် အတွေ့အကြုံရှိ ဖန်တီးသူများနှင့် ပူးပေါင်းပါ။ မေးခွန်းများကို ကြိုဆိုပြီး အသိပညာများကို လွတ်လပ်စွာ မျှဝေသော ပံ့ပိုးမှုရှိသော အသိုင်းအဝိုင်းတစ်ခုဖြစ်သည်။

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

ထုတ်ကုန်တုံ့ပြန်ချက်များ သို့မဟုတ် အမှားများရှိပါက တည်ဆောက်ရာတွင် အောက်ပါနေရာသို့ သွားရောက်ကြည့်ရှုနိုင်ပါသည်-

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**အကြောင်းကြားချက်**  
ဤစာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ဖြင့် ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှန်ကန်မှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်ခြင်းတွင် အမှားများ သို့မဟုတ် မှားယွင်းချက်များ ပါဝင်နိုင်ကြောင်း သတိပြုပါရန် မေတ္တာရပ်ခံအပ်ပါသည်။ မူရင်းစာတမ်းကို မိမိဘာသာစကားဖြင့်သာ တရားဝင်အချက်အလက်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်မှ ဘာသာပြန်ခြင်းကို အကြံပြုပါသည်။ ဤဘာသာပြန်ချက်ကို အသုံးပြုရာမှ ဖြစ်ပေါ်လာနိုင်သည့် နားလည်မှုမှားယွင်းမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မရှိပါ။
<!-- CO-OP TRANSLATOR DISCLAIMER END -->