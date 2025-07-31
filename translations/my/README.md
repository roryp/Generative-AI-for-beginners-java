<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "63b6426b88f6f56398ca3f1fbfc30889",
  "translation_date": "2025-07-29T10:24:59+00:00",
  "source_file": "README.md",
  "language_code": "my"
}
-->
# Generative AI အခြေခံသင်ခန်းစာ - Java Edition  
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)  

![Generative AI for Beginners - Java Edition](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.my.png)  

**အချိန်လိုအပ်မှု**: အလုပ်ရုံဆွေးနွေးပွဲကို ဒေသတွင်းတွင် အဆင်ပြေစွာ စနစ်တကျမရှိဘဲ အွန်လိုင်းမှ ပြီးစီးနိုင်သည်။ ပတ်ဝန်းကျင်ကို စနစ်တကျပြင်ဆင်ရန် ၂ မိနစ်သာ လိုအပ်ပြီး၊ နမူနာများကို လေ့လာရန် ၁-၃ နာရီ လိုအပ်နိုင်သည် (လေ့လာမှုအနက်အနံ့ပေါ်မူတည်၍)။  

> **အမြန်စတင်ရန်**  

1. ဤ repository ကို သင့် GitHub အကောင့်သို့ Fork လုပ်ပါ  
2. **Code** → **Codespaces** tab → **...** → **New with options...** ကို နှိပ်ပါ  
3. Default ကို အသုံးပြုပါ – ဤသင်တန်းအတွက် ဖန်တီးထားသော Development container ကို ရွေးချယ်ပါမည်  
4. **Create codespace** ကို နှိပ်ပါ  
5. ပတ်ဝန်းကျင် ပြင်ဆင်ရန် ~2 မိနစ် စောင့်ပါ  
6. [ပထမနမူနာ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) သို့ တိုက်ရိုက် သွားပါ  

## ဘာသာစကားများ ပံ့ပိုးမှု  

### GitHub Action မှတဆင့် ပံ့ပိုးထားသည် (အလိုအလျောက် & အမြဲ Update ဖြစ်နေသည်)  

[French](../fr/README.md) | [Spanish](../es/README.md) | [German](../de/README.md) | [Russian](../ru/README.md) | [Arabic](../ar/README.md) | [Persian (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Hindi](../hi/README.md) | [Bengali](../bn/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Portuguese (Brazil)](../br/README.md) | [Italian](../it/README.md) | [Polish](../pl/README.md) | [Turkish](../tr/README.md) | [Greek](../el/README.md) | [Thai](../th/README.md) | [Swedish](../sv/README.md) | [Danish](../da/README.md) | [Norwegian](../no/README.md) | [Finnish](../fi/README.md) | [Dutch](../nl/README.md) | [Hebrew](../he/README.md) | [Vietnamese](../vi/README.md) | [Indonesian](../id/README.md) | [Malay](../ms/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Swahili](../sw/README.md) | [Hungarian](../hu/README.md) | [Czech](../cs/README.md) | [Slovak](../sk/README.md) | [Romanian](../ro/README.md) | [Bulgarian](../bg/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Croatian](../hr/README.md) | [Slovenian](../sl/README.md) | [Ukrainian](../uk/README.md) | [Burmese (Myanmar)](./README.md)  

## သင်ခန်းစာဖွဲ့စည်းမှုနှင့် သင်ယူလမ်းကြောင်း  

### **အခန်း ၁: Generative AI ကို မိတ်ဆက်ခြင်း**  
- **အဓိကအကြောင်းအရာများ**: Large Language Models, tokens, embeddings, နှင့် AI စွမ်းရည်များကို နားလည်ခြင်း  
- **Java AI Ecosystem**: Spring AI နှင့် OpenAI SDKs အကြောင်း  
- **Model Context Protocol**: MCP နှင့် AI agent ဆက်သွယ်မှုတွင် အရေးပါမှု  
- **အကောင်အထည်ဖော်မှုများ**: Chatbots နှင့် အကြောင်းအရာဖန်တီးခြင်းအပါအဝင် အမှန်တကယ်အသုံးချမှုများ  
- **[→ အခန်း ၁ စတင်ရန်](./01-IntroToGenAI/README.md)**  

### **အခန်း ၂: ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင် ပြင်ဆင်ခြင်း**  
- **Multi-Provider Configuration**: GitHub Models, Azure OpenAI, နှင့် OpenAI Java SDK တွေကို ပေါင်းစပ်ပြင်ဆင်ခြင်း  
- **Spring Boot + Spring AI**: စီးပွားရေးလုပ်ငန်း AI အပလီကေးရှင်း ဖွံ့ဖြိုးရေးအတွက် အကောင်းဆုံးနည်းလမ်းများ  
- **GitHub Models**: အခမဲ့ AI model access (credit card မလိုအပ်ပါ)  
- **ဖွံ့ဖြိုးရေး Tools**: Docker containers, VS Code, နှင့် GitHub Codespaces configuration  
- **[→ အခန်း ၂ စတင်ရန်](./02-SetupDevEnvironment/README.md)**  

### **အခန်း ၃: Generative AI နည်းလမ်းများ**  
- **Prompt Engineering**: AI model response များအတွက် အကောင်းဆုံးနည်းလမ်းများ  
- **Embeddings & Vector Operations**: Semantic search နှင့် similarity matching ကို အကောင်အထည်ဖော်ခြင်း  
- **Retrieval-Augmented Generation (RAG)**: AI ကို ကိုယ်ပိုင် data sources နှင့် ပေါင်းစပ်ခြင်း  
- **Function Calling**: Custom tools နှင့် plugins များဖြင့် AI စွမ်းရည်များ တိုးမြှင့်ခြင်း  
- **[→ အခန်း ၃ စတင်ရန်](./03-CoreGenerativeAITechniques/README.md)**  

### **အခန်း ၄: အကောင်အထည်ဖော်မှုများနှင့် Project များ**  
- **Pet Story Generator** (`petstory/`): GitHub Models ဖြင့် ဖန်တီးမှုအကြောင်းအရာ ဖန်တီးခြင်း  
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK ဖြင့် ဒေသတွင်း AI model ပေါင်းစပ်ခြင်း  
- **MCP Calculator Service** (`calculator/`): Spring AI ဖြင့် Model Context Protocol အခြေခံအကောင်အထည်ဖော်မှု  
- **[→ အခန်း ၄ စတင်ရန်](./04-PracticalSamples/README.md)**  

### **အခန်း ၅: တာဝန်ရှိသော AI ဖွံ့ဖြိုးမှု**  
- **GitHub Models Safety**: Built-in content filtering နှင့် safety mechanisms (hard blocks နှင့် soft refusals) ကို စမ်းသပ်ခြင်း  
- **Responsible AI Demo**: အခက်အခဲများကို လက်တွေ့ကျကျ ပြသထားသော နမူနာ  
- **အကောင်းဆုံးနည်းလမ်းများ**: Ethical AI ဖွံ့ဖြိုးမှုနှင့် အသုံးချမှုအတွက် အရေးပါသော လမ်းညွှန်ချက်များ  
- **[→ အခန်း ၅ စတင်ရန်](./05-ResponsibleGenAI/README.md)**  

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

**ဝက်ဘ်ဆိုက်မှတ်ချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှန်ကန်မှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက်ဘာသာပြန်ဆိုမှုများတွင် အမှားများ သို့မဟုတ် မတိကျမှုများ ပါဝင်နိုင်သည်ကို ကျေးဇူးပြု၍ သတိပြုပါ။ မူရင်းစာရွက်စာတမ်းကို ၎င်း၏ မူလဘာသာစကားဖြင့် အာဏာတည်သောရင်းမြစ်အဖြစ် သတ်မှတ်ပါ။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များမှ အတည်ပြုထားသော ဘာသာပြန်ဆိုမှုကို အသုံးပြုရန် အကြံပြုပါသည်။ ဤဘာသာပြန်ဆိုမှုကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော နားလည်မှုမှားများ သို့မဟုတ် အဓိပ္ပာယ်မှားများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။