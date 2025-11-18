<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "ff595bec5b6294cb68860d540eae6302",
  "translation_date": "2025-11-18T17:45:49+00:00",
  "source_file": "README.md",
  "language_code": "my"
}
-->
# စိတ်ကူးဖန်တီးမှု AI အတွက် မူလအဆင့် - Java အထူး

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.my.png)

**အချိန်လိုအပ်မှု**: အလုပ်ရုံဆွေးနွေးပွဲကို အွန်လိုင်းတွင် ပြီးစီးနိုင်ပြီး ဒေသတွင်းတွင် အဆင့်သတ်မှတ်မှုမလိုအပ်ပါ။ ပတ်ဝန်းကျင်ကို စတင်ပြင်ဆင်ရန် ၂ မိနစ်သာလိုအပ်ပြီး နမူနာများကို လေ့လာရန် အနည်းဆုံး ၁-၃ နာရီလိုအပ်မည်ဖြစ်သည်။

> **အမြန်စတင်ရန်**

1. GitHub အကောင့်တွင် ဤ repository ကို Fork လုပ်ပါ
2. **Code** → **Codespaces** tab → **...** → **New with options...** ကိုနှိပ်ပါ
3. Default ကို အသုံးပြုပါ – ဤသင်တန်းအတွက် ဖန်တီးထားသော Development container ကို ရွေးချယ်မည်
4. **Create codespace** ကိုနှိပ်ပါ
5. ပတ်ဝန်းကျင်ကို ပြင်ဆင်ရန် ~2 မိနစ်စောင့်ပါ
6. [ပထမနမူနာ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) သို့ တိုက်ရိုက်သွားပါ

## ဘာသာစကားများပံ့ပိုးမှု

### GitHub Action မှတဆင့် ပံ့ပိုးထားသည် (အလိုအလျောက် & အမြဲနောက်ဆုံး)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](./README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Nigerian Pidgin](../pcm/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../br/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## သင်တန်းဖွဲ့စည်းမှုနှင့် သင်ယူလမ်းကြောင်း

### **အခန်း ၁: စိတ်ကူးဖန်တီးမှု AI ကို မိတ်ဆက်ခြင်း**
- **အဓိကအကြောင်းအရာများ**: Large Language Models, tokens, embeddings, နှင့် AI စွမ်းရည်များကို နားလည်ခြင်း
- **Java AI Ecosystem**: Spring AI နှင့် OpenAI SDKs အကြောင်းအကျဉ်းချုပ်
- **Model Context Protocol**: MCP နှင့် AI agent ဆက်သွယ်မှုတွင် ၎င်း၏ အခန်းကဏ္ဍကို မိတ်ဆက်ခြင်း
- **အကောင်အထည်ဖော်မှုများ**: Chatbots နှင့် အကြောင်းအရာဖန်တီးခြင်းအပါအဝင် အမှန်တကယ်အခြေအနေများ
- **[→ အခန်း ၁ စတင်ရန်](./01-IntroToGenAI/README.md)**

### **အခန်း ၂: ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်ကို ပြင်ဆင်ခြင်း**
- **Multi-Provider Configuration**: GitHub Models, Azure OpenAI, နှင့် OpenAI Java SDK ပေါင်းစပ်မှုကို ပြင်ဆင်ခြင်း
- **Spring Boot + Spring AI**: စီးပွားရေး AI အပလီကေးရှင်းဖွံ့ဖြိုးမှုအတွက် အကောင်းဆုံးအလေ့အကျင့်များ
- **GitHub Models**: Prototyping နှင့် သင်ယူမှုအတွက် အခမဲ့ AI model ဝင်ရောက်ခွင့် (အကြွေးဝယ်ကဒ်မလိုအပ်ပါ)
- **ဖွံ့ဖြိုးရေး Tools**: Docker containers, VS Code, နှင့် GitHub Codespaces ကို ပြင်ဆင်ခြင်း
- **[→ အခန်း ၂ စတင်ရန်](./02-SetupDevEnvironment/README.md)**

### **အခန်း ၃: စိတ်ကူးဖန်တီးမှု AI နည်းလမ်းများ**
- **Prompt Engineering**: AI model အဖြေများအတွက် အကောင်းဆုံးနည်းလမ်းများ
- **Embeddings & Vector Operations**: Semantic search နှင့် similarity matching ကို အကောင်အထည်ဖော်ခြင်း
- **Retrieval-Augmented Generation (RAG)**: AI ကို ကိုယ်ပိုင်ဒေတာရင်းမြစ်များနှင့် ပေါင်းစပ်ခြင်း
- **Function Calling**: Custom tools နှင့် plugins များဖြင့် AI စွမ်းရည်များကို တိုးချဲ့ခြင်း
- **[→ အခန်း ၃ စတင်ရန်](./03-CoreGenerativeAITechniques/README.md)**

### **အခန်း ၄: အကောင်အထည်ဖော်မှုများနှင့် Project များ**
- **Pet Story Generator** (`petstory/`): GitHub Models ဖြင့် ဖန်တီးမှုအကြောင်းအရာဖန်တီးခြင်း
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK ဖြင့် ဒေသတွင်း AI model ပေါင်းစပ်ခြင်း
- **MCP Calculator Service** (`calculator/`): Spring AI ဖြင့် အခြေခံ Model Context Protocol အကောင်အထည်ဖော်ခြင်း
- **[→ အခန်း ၄ စတင်ရန်](./04-PracticalSamples/README.md)**

### **အခန်း ၅: တာဝန်ရှိသော AI ဖွံ့ဖြိုးမှု**
- **GitHub Models Safety**: Built-in content filtering နှင့် safety mechanisms (hard blocks နှင့် soft refusals) ကို စမ်းသပ်ခြင်း
- **Responsible AI Demo**: ခေတ်မီ AI safety systems များကို လက်တွေ့အသုံးပြုမှုအနေဖြင့် ပြသခြင်း
- **အကောင်းဆုံးအလေ့အကျင့်များ**: တရားဝင် AI ဖွံ့ဖြိုးမှုနှင့် အသုံးပြုမှုအတွက် အရေးကြီးသော လမ်းညွှန်ချက်များ
- **[→ အခန်း ၅ စတင်ရန်](./05-ResponsibleGenAI/README.md)**

## ထပ်ဆောင်းအရင်းအမြစ်များ

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

## အကူအညီရယူခြင်း

AI အက်ပ်များတည်ဆောက်ရာတွင် အခက်အခဲရှိပါက သို့မဟုတ် မေးခွန်းများရှိပါက MCP အကြောင်းအရာကို ဆွေးနွေးနေသော ကျွမ်းကျင်သော developer များနှင့် သင်ယူသူများအဖွဲ့အစည်းတွင် ပါဝင်ပါ။ မေးခွန်းများကို ကြိုဆိုပြီး အသိပညာများကို လွတ်လပ်စွာမျှဝေသော အဖွဲ့အစည်းတစ်ခုဖြစ်ပါသည်။

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

ထုတ်ကုန်အကြံပြုချက်များ သို့မဟုတ် တည်ဆောက်ရာတွင် အမှားများရှိပါက အောက်ပါနေရာသို့ သွားပါ:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ဝန်ခံချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှန်ကန်မှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက်ဘာသာပြန်ခြင်းတွင် အမှားများ သို့မဟုတ် မမှန်ကန်မှုများ ပါဝင်နိုင်သည်ကို သတိပြုပါ။ မူလဘာသာစကားဖြင့် ရေးသားထားသော စာရွက်စာတမ်းကို အာဏာတည်သော ရင်းမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များကို အသုံးပြုရန် အကြံပြုပါသည်။ ဤဘာသာပြန်ကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော နားလည်မှုမှားများ သို့မဟုတ် အဓိပ္ပာယ်မှားများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။
<!-- CO-OP TRANSLATOR DISCLAIMER END -->