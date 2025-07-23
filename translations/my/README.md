<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "79df2d245c12d6b8ad57148fd049f106",
  "translation_date": "2025-07-23T12:41:52+00:00",
  "source_file": "README.md",
  "language_code": "my"
}
-->
# Java Edition အတွက် Generative AI - စတင်လေ့လာသူများအတွက်

[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generative AI for Beginners - Java Edition](../../translated_images/beg-genai-series.61edc4a6b2cc54284fa2d70eda26dc0ca2669e26e49655b842ea799cd6e16d2a.my.png)

> **NOTE: Quick Start**: အကုန်လုံးကို အွန်လိုင်းပေါ်မှာ လုပ်နိုင်ပါတယ် - ဒေသတွင်းမှာ အဆင့်သတ်မှတ်မှု မလိုအပ်ပါ!
1. ဒီ repository ကို သင့် GitHub အကောင့်မှာ Fork လုပ်ပါ
2. **Code** → **Codespaces** tab → **...** → **New with options...** ကို နှိပ်ပါ
3. Default ကို အသုံးပြုပါ – ဒီဟာက ဒီသင်ခန်းစာအတွက် ဖန်တီးထားတဲ့ Development container ကို ရွေးချယ်ပေးပါမယ်
4. **Create codespace** ကို နှိပ်ပါ
5. ~၂ မိနစ်အကြာမှာ ပတ်ဝန်းကျင် အသင့်ဖြစ်ပါမယ်
6. [Creating your GitHub Models Token](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) ကို တိုက်ရိုက်စတင်ပါ

## ဘာသာစကားများ အထောက်အပံ့

### GitHub Action မှတဆင့် အလိုအလျောက် (အမြဲ Update ဖြစ်နေ)

[French](../fr/README.md) | [Spanish](../es/README.md) | [German](../de/README.md) | [Russian](../ru/README.md) | [Arabic](../ar/README.md) | [Persian (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Hindi](../hi/README.md) | [Bengali](../bn/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Portuguese (Brazil)](../br/README.md) | [Italian](../it/README.md) | [Polish](../pl/README.md) | [Turkish](../tr/README.md) | [Greek](../el/README.md) | [Thai](../th/README.md) | [Swedish](../sv/README.md) | [Danish](../da/README.md) | [Norwegian](../no/README.md) | [Finnish](../fi/README.md) | [Dutch](../nl/README.md) | [Hebrew](../he/README.md) | [Vietnamese](../vi/README.md) | [Indonesian](../id/README.md) | [Malay](../ms/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Swahili](../sw/README.md) | [Hungarian](../hu/README.md) | [Czech](../cs/README.md) | [Slovak](../sk/README.md) | [Romanian](../ro/README.md) | [Bulgarian](../bg/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Croatian](../hr/README.md) | [Slovenian](../sl/README.md) | [Ukrainian](../uk/README.md) | [Burmese (Myanmar)](./README.md)

## သင်ခန်းစာဖွဲ့စည်းမှုနှင့် လေ့လာမှုလမ်းကြောင်း

**အချိန်ပေးဆောင်မှု**: ပတ်ဝန်းကျင်ကို အဆင့်သတ်မှတ်ရန် ၂ မိနစ်သာလိုအပ်ပြီး၊ လက်တွေ့လေ့ကျင့်မှုများကို ၁-၃ နာရီအတွင်း လေ့လာနိုင်ပါသည်။

### **အခန်း ၁: Generative AI ကို မိတ်ဆက်ခြင်း**
- **အဓိကအကြောင်းအရာများ**: Large Language Models, tokens, embeddings, နှင့် AI ရှိနိုင်သောစွမ်းရည်များကို နားလည်ခြင်း
- **Java AI Ecosystem**: Spring AI နှင့် OpenAI SDKs အကြောင်းအကျဉ်းချုပ်
- **Model Context Protocol**: MCP နှင့် AI agent ဆက်သွယ်မှုအတွက် အရေးပါမှု
- **လက်တွေ့အသုံးချမှုများ**: Chatbots နှင့် အကြောင်းအရာဖန်တီးခြင်းအပါအဝင် အမှန်တကယ်အခြေအနေများ
- **[→ အခန်း ၁ စတင်ပါ](./01-IntroToGenAI/README.md)**

### **အခန်း ၂: ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင်ကို အဆင့်သတ်မှတ်ခြင်း**
- **Multi-Provider Configuration**: GitHub Models, Azure OpenAI, နှင့် OpenAI Java SDK integrations ကို အဆင့်သတ်မှတ်ခြင်း
- **Spring Boot + Spring AI**: စီးပွားရေး AI အက်ပလီကေးရှင်းဖွံ့ဖြိုးရေးအတွက် အကောင်းဆုံးနည်းလမ်းများ
- **GitHub Models**: Prototyping နှင့် လေ့လာမှုအတွက် အခမဲ့ AI model access (credit card မလိုအပ်ပါ)
- **ဖွံ့ဖြိုးရေး Tools**: Docker containers, VS Code, နှင့် GitHub Codespaces configuration
- **[→ အခန်း ၂ စတင်ပါ](./02-SetupDevEnvironment/README.md)**

### **အခန်း ၃: Generative AI နည်းလမ်းများ၏ အဓိကအချက်များ**
- **Prompt Engineering**: AI model response များအတွက် အကောင်းဆုံးနည်းလမ်းများ
- **Embeddings & Vector Operations**: Semantic search နှင့် similarity matching ကို အကောင်အထည်ဖော်ခြင်း
- **Retrieval-Augmented Generation (RAG)**: AI ကို သင့် data sources များနှင့် ပေါင်းစပ်ခြင်း
- **Function Calling**: Custom tools နှင့် plugins များဖြင့် AI စွမ်းရည်များကို တိုးချဲ့ခြင်း
- **[→ အခန်း ၃ စတင်ပါ](./03-CoreGenerativeAITechniques/README.md)**

### **အခန်း ၄: လက်တွေ့အသုံးချမှုများနှင့် Project များ**
- **Pet Story Generator** (`petstory/`): GitHub Models ဖြင့် ဖန်တီးမှုအကြောင်းအရာဖန်တီးခြင်း
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK ဖြင့် ဒေသတွင်း AI model integration
- **MCP Calculator Service** (`mcp/calculator/`): Spring AI ဖြင့် Model Context Protocol အခြေခံအကောင်အထည်ဖော်မှု
- **[→ အခန်း ၄ စတင်ပါ](./04-PracticalSamples/README.md)**

### **အခန်း ၅: တာဝန်ရှိသော AI ဖွံ့ဖြိုးမှု**
- **GitHub Models Safety**: Built-in content filtering နှင့် safety mechanisms ကို စမ်းသပ်ခြင်း
- **Responsible AI Demo**: AI safety filters အလုပ်လုပ်ပုံကို လက်တွေ့နမူနာဖြင့် ပြသခြင်း
- **အကောင်းဆုံးနည်းလမ်းများ**: Ethical AI ဖွံ့ဖြိုးမှုနှင့် အသုံးချမှုအတွက် အရေးပါသောလမ်းညွှန်ချက်များ
- **[→ အခန်း ၅ စတင်ပါ](./05-ResponsibleGenAI/README.md)**

## အပိုဆောင်းအရင်းအမြစ်များ

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
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေပါသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်မှုများတွင် အမှားများ သို့မဟုတ် မတိကျမှုများ ပါရှိနိုင်သည်ကို သတိပြုပါ။ မူရင်းဘာသာစကားဖြင့် ရေးသားထားသော စာရွက်စာတမ်းကို အာဏာတရားရှိသော ရင်းမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူက ဘာသာပြန်မှု ဝန်ဆောင်မှုကို အသုံးပြုရန် အကြံပြုပါသည်။ ဤဘာသာပြန်မှုကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအလွတ်များ သို့မဟုတ် အနားလွဲမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။