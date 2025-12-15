<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0efa90a880213da0aeb35e43ec717e98",
  "translation_date": "2025-12-01T08:57:19+00:00",
  "source_file": "README.md",
  "language_code": "my"
}
-->
# စတင်သူများအတွက် Generative AI - Java အထူးထုတ်  
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![စတင်သူများအတွက် Generative AI - Java အထူးထုတ်](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.my.png)

**အချိန်လိုအပ်ချက်**: အလုပ်ရုံဆွေးနွေးပွဲတစ်ခုလုံးကို ဒေသတွင်းတွင် စက်တပ်ဆင်မှုမလိုဘဲ အွန်လိုင်းတွင် ပြီးစီးနိုင်ပါသည်။ ပတ်ဝန်းကျင်တပ်ဆင်ရန် ၂ မိနစ်သာလိုအပ်ပြီး၊ နမူနာများကို စူးစမ်းရန် ၁-၃ နာရီကြာနိုင်သည် (စူးစမ်းမှုအနက်အနားပေါ်မူတည်၍)။

> **အမြန်စတင်ရန်**

1. ဤ repository ကို သင့် GitHub အကောင့်သို့ Fork လုပ်ပါ  
2. **Code** → **Codespaces** tab → **...** → **New with options...** ကိုနှိပ်ပါ  
3. Default ကို အသုံးပြုပါ – ဤသင်တန်းအတွက် ဖန်တီးထားသော Development container ကို ရွေးချယ်ပါမည်  
4. **Create codespace** ကိုနှိပ်ပါ  
5. ပတ်ဝန်းကျင်အဆင်သင့်ဖြစ်ရန် ~၂ မိနစ်စောင့်ပါ  
6. [ပထမနမူနာ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) သို့ တိုက်ရိုက်သွားပါ  

## ဘာသာစကားများအထောက်အပံ့

### GitHub Action မှတဆင့် ထောက်ပံ့ထားသည် (အလိုအလျောက် & အမြဲနောက်ဆုံးပေါ်)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](./README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Kannada](../kn/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Malayalam](../ml/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Nigerian Pidgin](../pcm/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../br/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Telugu](../te/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## သင်တန်းဖွဲ့စည်းမှုနှင့် သင်ယူလမ်းကြောင်း

### **အခန်း ၁: Generative AI အကြောင်းမိတ်ဆက်**
- **အဓိကအကြောင်းအရာများ**: Large Language Models, tokens, embeddings, နှင့် AI စွမ်းရည်များကို နားလည်ခြင်း  
- **Java AI Ecosystem**: Spring AI နှင့် OpenAI SDKs ၏ အကျဉ်းချုပ်  
- **Model Context Protocol**: MCP နှင့် AI agent ဆက်သွယ်မှုတွင် ၎င်း၏ အခန်းကဏ္ဍ  
- **လက်တွေ့အသုံးချမှုများ**: Chatbots နှင့် အကြောင်းအရာဖန်တီးခြင်းအပါအဝင် အမှန်တကယ်အခြေအနေများ  
- **[→ အခန်း ၁ စတင်ရန်](./01-IntroToGenAI/README.md)**  

### **အခန်း ၂: ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်တပ်ဆင်ခြင်း**
- **Multi-Provider Configuration**: GitHub Models, Azure OpenAI, နှင့် OpenAI Java SDK အစီအစဉ်များကို တပ်ဆင်ခြင်း  
- **Spring Boot + Spring AI**: စီးပွားရေးလုပ်ငန်း AI အပလီကေးရှင်းဖွံ့ဖြိုးတိုးတက်မှုအတွက် အကောင်းဆုံးအလေ့အကျင့်များ  
- **GitHub Models**: Prototyping နှင့် သင်ယူမှုအတွက် အခမဲ့ AI မော်ဒယ်များ (အကြွေးဝယ်ကတ်မလိုအပ်ပါ)  
- **ဖွံ့ဖြိုးရေးကိရိယာများ**: Docker containers, VS Code, နှင့် GitHub Codespaces ကို တပ်ဆင်ခြင်း  
- **[→ အခန်း ၂ စတင်ရန်](./02-SetupDevEnvironment/README.md)**  

### **အခန်း ၃: Generative AI နည်းလမ်းများ၏ အဓိကအချက်များ**
- **Prompt Engineering**: AI မော်ဒယ်၏ အကောင်းဆုံးတုံ့ပြန်မှုများအတွက် နည်းလမ်းများ  
- **Embeddings & Vector Operations**: Semantic search နှင့် similarity matching ကို အကောင်အထည်ဖော်ခြင်း  
- **Retrieval-Augmented Generation (RAG)**: AI ကို သင့်ကိုယ်ပိုင်ဒေတာရင်းမြစ်များနှင့် ပေါင်းစပ်ခြင်း  
- **Function Calling**: စိတ်ကြိုက်ကိရိယာများနှင့် plugins များဖြင့် AI စွမ်းရည်များတိုးချဲ့ခြင်း  
- **[→ အခန်း ၃ စတင်ရန်](./03-CoreGenerativeAITechniques/README.md)**  

### **အခန်း ၄: လက်တွေ့အသုံးချမှုများနှင့် ပရောဂျက်များ**
- **Pet Story Generator** (`petstory/`): GitHub Models ဖြင့် ဖန်တီးမှုအကြောင်းအရာဖန်တီးခြင်း  
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK ဖြင့် ဒေသတွင်း AI မော်ဒယ်ပေါင်းစပ်ခြင်း  
- **MCP Calculator Service** (`calculator/`): Spring AI ဖြင့် အခြေခံ Model Context Protocol အကောင်အထည်ဖော်ခြင်း  
- **[→ အခန်း ၄ စတင်ရန်](./04-PracticalSamples/README.md)**  

### **အခန်း ၅: တာဝန်ရှိသော AI ဖွံ့ဖြိုးတိုးတက်မှု**
- **GitHub Models Safety**: Built-in content filtering နှင့် safety mechanisms (hard blocks နှင့် soft refusals) ကို စမ်းသပ်ခြင်း  
- **Responsible AI Demo**: ခေတ်သစ် AI safety systems များ လက်တွေ့အသုံးပြုမှုကို ပြသခြင်း  
- **အကောင်းဆုံးအလေ့အကျင့်များ**: တာဝန်ရှိသော AI ဖွံ့ဖြိုးတိုးတက်မှုနှင့် တင်သွင်းမှုအတွက် အရေးကြီးသော လမ်းညွှန်ချက်များ  
- **[→ အခန်း ၅ စတင်ရန်](./05-ResponsibleGenAI/README.md)**  

## ထပ်မံသော အရင်းအမြစ်များ

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
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

### အဓိကသင်ယူမှု  
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

## အကူအညီရယူခြင်း

AI အက်ပ်များတည်ဆောက်ရာတွင် အခက်အခဲရှိပါက သို့မဟုတ် မေးခွန်းများရှိပါက MCP အကြောင်း ဆွေးနွေးနေသော သင်ကြားသူများနှင့် အတွေ့အကြုံရှိ Developer များနှင့် ပူးပေါင်းပါ။ မေးခွန်းများကို ကြိုဆိုပြီး အသိပညာများကို လွတ်လပ်စွာမျှဝေသော အထောက်အပံ့ပေးသော အသိုင်းအဝိုင်းတစ်ခုဖြစ်သည်။

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

ထုတ်ကုန်အကြံပြုချက်များ သို့မဟုတ် တည်ဆောက်နေစဉ် အမှားများရှိပါက အောက်ပါနေရာသို့ သွားပါ:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေသော်လည်း အလိုအလျောက် ဘာသာပြန်မှုများတွင် အမှားများ သို့မဟုတ် မမှန်ကန်မှုများ ပါဝင်နိုင်သည်ကို သတိပြုပါ။ မူရင်းဘာသာစကားဖြင့် ရေးသားထားသော စာရွက်စာတမ်းကို အာဏာတရားရှိသော အရင်းအမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များကို အသုံးပြုရန် အကြံပြုပါသည်။ ဤဘာသာပြန်မှုကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအလွတ်များ သို့မဟုတ် အနားလွဲမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။
<!-- CO-OP TRANSLATOR DISCLAIMER END -->