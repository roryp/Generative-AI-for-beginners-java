<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2ee0f50497c11d1941347ac61fb017a9",
  "translation_date": "2025-07-21T20:33:36+00:00",
  "source_file": "README.md",
  "language_code": "my"
}
-->
# Java အတွက် စတင်သူများအတွက် Generative AI  
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generative AI for Beginners - Java Edition](../../translated_images/beg-genai-series.61edc4a6b2cc54284fa2d70eda26dc0ca2669e26e49655b842ea799cd6e16d2a.my.png)

> **NOTE: အစပြုရန် လွယ်ကူသောနည်းလမ်း**: ဒီသင်တန်းကို အွန်လိုင်းပေါ်မှာပဲ ပြီးမြောက်နိုင်ပါတယ် - ဒေသတွင်းမှာ အဆင့်သတ်မှတ်မှု မလိုအပ်ပါ!  
1. ဒီ repository ကို သင့် GitHub အကောင့်ထဲ Fork လုပ်ပါ  
2. **Code** → **Codespaces** tab → **...** → **New with options...** ကိုနှိပ်ပါ  
3. သင့်အတွက် ပြင်ဆင်ထားသော Development container ကို ရွေးချယ်ရန် Defaults ကို အသုံးပြုပါ  
4. **Create codespace** ကိုနှိပ်ပါ  
5. ပတ်ဝန်းကျင် ပြင်ဆင်မှုအတွက် ~2 မိနစ် စောင့်ပါ  
6. [GitHub Models Token ဖန်တီးခြင်း](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) ကို စတင်ပါ  

## ဘာသာစကားများ အထောက်အပံ့

### GitHub Action မှတဆင့် ထောက်ပံ့ထားသည် (အလိုအလျောက် & အမြဲနောက်ဆုံးပေါ်)

[French](../fr/README.md) | [Spanish](../es/README.md) | [German](../de/README.md) | [Russian](../ru/README.md) | [Arabic](../ar/README.md) | [Persian (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Hindi](../hi/README.md) | [Bengali](../bn/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Portuguese (Brazil)](../br/README.md) | [Italian](../it/README.md) | [Polish](../pl/README.md) | [Turkish](../tr/README.md) | [Greek](../el/README.md) | [Thai](../th/README.md) | [Swedish](../sv/README.md) | [Danish](../da/README.md) | [Norwegian](../no/README.md) | [Finnish](../fi/README.md) | [Dutch](../nl/README.md) | [Hebrew](../he/README.md) | [Vietnamese](../vi/README.md) | [Indonesian](../id/README.md) | [Malay](../ms/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Swahili](../sw/README.md) | [Hungarian](../hu/README.md) | [Czech](../cs/README.md) | [Slovak](../sk/README.md) | [Romanian](../ro/README.md) | [Bulgarian](../bg/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Croatian](../hr/README.md) | [Slovenian](../sl/README.md) | [Ukrainian](../uk/README.md) | [Burmese (Myanmar)](./README.md)

## သင်တန်းဖွဲ့စည်းမှုနှင့် သင်ယူလမ်းကြောင်း

**အချိန်ပေးစရာလိုအပ်မှု**: ပတ်ဝန်းကျင် ပြင်ဆင်မှုအတွက် 2 မိနစ်သာလိုအပ်ပြီး၊ လက်တွေ့လေ့ကျင့်မှုများအတွက် 1-3 နာရီ လိုအပ်မည် (လေ့လာမှုအနက်အနားပေါ်မူတည်သည်)။

### **အခန်း ၁: Generative AI အကြောင်းမိတ်ဆက်**
- **အဓိကအကြောင်းအရာများ**: Large Language Models, tokens, embeddings, နှင့် AI ရဲ့ စွမ်းဆောင်ရည်များကို နားလည်ခြင်း  
- **Java AI Ecosystem**: Spring AI နှင့် OpenAI SDKs အကြောင်း  
- **Model Context Protocol**: MCP နှင့် AI agent ဆက်သွယ်မှုအတွက် အရေးပါမှု  
- **လက်တွေ့အသုံးချမှုများ**: Chatbots နှင့် အကြောင်းအရာဖန်တီးခြင်း  
- **[→ အခန်း ၁ စတင်ရန်](./01-IntroToGenAI/README.md)**

### **အခန်း ၂: ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင် ပြင်ဆင်ခြင်း**
- **Multi-Provider Configuration**: GitHub Models, Azure OpenAI, နှင့် OpenAI Java SDK တွဲဖက်ပြင်ဆင်ခြင်း  
- **Spring Boot + Spring AI**: စီးပွားရေး AI အပလီကေးရှင်း ဖွံ့ဖြိုးရေးအတွက် အကောင်းဆုံးနည်းလမ်းများ  
- **GitHub Models**: အခမဲ့ AI မော်ဒယ်များကို သင်ကြားမှုနှင့် စမ်းသပ်မှုအတွက် အသုံးပြုခြင်း (အကြွေးဝယ်ကတ် မလိုအပ်ပါ)  
- **ဖွံ့ဖြိုးရေးကိရိယာများ**: Docker containers, VS Code, နှင့် GitHub Codespaces ပြင်ဆင်ခြင်း  
- **[→ အခန်း ၂ စတင်ရန်](./02-SetupDevEnvironment/README.md)**

### **အခန်း ၃: Generative AI နည်းလမ်းများ**
- **Prompt Engineering**: AI မော်ဒယ်များမှ အကောင်းဆုံးဖြေရှင်းချက်ရရှိရန် နည်းလမ်းများ  
- **Embeddings & Vector Operations**: Semantic search နှင့် similarity matching ကို အကောင်အထည်ဖော်ခြင်း  
- **Retrieval-Augmented Generation (RAG)**: AI ကို ကိုယ်ပိုင်ဒေတာအရင်းအမြစ်များနှင့် ပေါင်းစပ်အသုံးပြုခြင်း  
- **Function Calling**: Custom tools နှင့် plugins များဖြင့် AI ရဲ့ စွမ်းဆောင်ရည်တိုးမြှင့်ခြင်း  
- **[→ အခန်း ၃ စတင်ရန်](./03-CoreGenerativeAITechniques/README.md)**

### **အခန်း ၄: လက်တွေ့အသုံးချမှုများနှင့် ပရောဂျက်များ**
- **Pet Story Generator** (`petstory/`): GitHub Models ဖြင့် ဖန်တီးမှုဆိုင်ရာ အကြောင်းအရာဖန်တီးခြင်း  
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK ဖြင့် ဒေသတွင်း AI မော်ဒယ် ပေါင်းစပ်ခြင်း  
- **MCP Calculator Service** (`mcp/calculator/`): Spring AI ဖြင့် Model Context Protocol အခြေခံအကောင်အထည်ဖော်မှု  
- **[→ အခန်း ၄ စတင်ရန်](./04-PracticalSamples/README.md)**

### **အခန်း ၅: တာဝန်ရှိသော AI ဖွံ့ဖြိုးမှု**
- **GitHub Models Safety**: Built-in content filtering နှင့် safety mechanisms စမ်းသပ်ခြင်း  
- **Responsible AI Demo**: AI safety filters လက်တွေ့အသုံးပြုနည်းကို ပြသခြင်း  
- **အကောင်းဆုံးနည်းလမ်းများ**: တာဝန်ရှိသော AI ဖွံ့ဖြိုးမှုနှင့် တင်သွင်းမှုအတွက် အရေးပါသော လမ်းညွှန်ချက်များ  
- **[→ အခန်း ၅ စတင်ရန်](./05-ResponsibleGenAI/README.md)**

## အပိုဆောင်း အရင်းအမြစ်များ

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

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်ခြင်းတွင် အမှားများ သို့မဟုတ် မတိကျမှုများ ပါဝင်နိုင်သည်ကို သတိပြုပါ။ မူရင်းစာရွက်စာတမ်းကို ၎င်း၏ မူရင်းဘာသာစကားဖြင့် အာဏာတရားရှိသော အရင်းအမြစ်အဖြစ် ရှုလေ့လာသင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များမှ ပရော်ဖက်ရှင်နယ် ဘာသာပြန်ခြင်းကို အကြံပြုပါသည်။ ဤဘာသာပြန်ကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအမှားများ သို့မဟုတ် အနားလွဲမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။