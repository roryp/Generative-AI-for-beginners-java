<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:36:03+00:00",
  "source_file": "README.md",
  "language_code": "my"
}
-->
# Java Edition အတွက် Generative AI - အခြေခံသင်ခန်းစာ
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generative AI for Beginners - Java Edition](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.my.png)

**အချိန်လိုအပ်မှု**: အလုပ်ရုံဆွေးနွေးပွဲကို ဒေသတွင်းတွင် စနစ်တပ်ဆင်မှုမလိုအပ်ဘဲ အွန်လိုင်းတွင် ပြီးစီးနိုင်သည်။ ပတ်ဝန်းကျင်ကို စနစ်တပ်ဆင်ရန် ၂ မိနစ်သာ လိုအပ်ပြီး၊ နမူနာများကို လေ့လာရန် ၁-၃ နာရီ လိုအပ်မည်ဖြစ်သည် (လေ့လာမှုအနက်အနံအပေါ် မူတည်၍)။

> **အမြန်စတင်ရန်**

1. ဤ repository ကို သင့် GitHub အကောင့်သို့ Fork လုပ်ပါ
2. **Code** → **Codespaces** tab → **...** → **New with options...** ကို နှိပ်ပါ
3. Default ကို အသုံးပြုပါ – ဤသင်ခန်းစာအတွက် ဖန်တီးထားသော Development container ကို ရွေးချယ်မည်
4. **Create codespace** ကို နှိပ်ပါ
5. ပတ်ဝန်းကျင်ကို ပြင်ဆင်ရန် ~2 မိနစ် စောင့်ပါ
6. [ပထမ နမူနာ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) သို့ တိုက်ရိုက် သွားပါ

## ဘာသာစကားများ အထောက်အပံ့

### GitHub Action မှတဆင့် အလိုအလျောက် (အမြဲ Update ဖြစ်နေသော)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](./README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../br/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## သင်ခန်းစာဖွဲ့စည်းမှုနှင့် လေ့လာမှုလမ်းကြောင်း

### **အခန်း ၁: Generative AI အကြောင်းအကျဉ်း**
- **အဓိကအကြောင်းအရာများ**: Large Language Models, tokens, embeddings, နှင့် AI စွမ်းရည်များကို နားလည်ခြင်း
- **Java AI Ecosystem**: Spring AI နှင့် OpenAI SDKs အကြောင်းအကျဉ်း
- **Model Context Protocol**: MCP နှင့် AI agent ဆက်သွယ်မှုတွင် အရေးပါမှု
- **အကောင်အထည်ဖော်မှုများ**: Chatbots နှင့် အကြောင်းအရာဖန်တီးခြင်းအပါအဝင် အမှန်တကယ်အသုံးချမှုများ
- **[→ အခန်း ၁ စတင်ရန်](./01-IntroToGenAI/README.md)**

### **အခန်း ၂: ဖွံ့ဖြိုးရေးပတ်ဝန်းကျင် စနစ်တပ်ဆင်ခြင်း**
- **Multi-Provider Configuration**: GitHub Models, Azure OpenAI, နှင့် OpenAI Java SDK အထောက်အပံ့များကို စနစ်တပ်ဆင်ခြင်း
- **Spring Boot + Spring AI**: စီးပွားရေး AI အပလီကေးရှင်း ဖွံ့ဖြိုးရေးအတွက် အကောင်းဆုံးနည်းလမ်းများ
- **GitHub Models**: Prototype နှင့် လေ့လာမှုအတွက် အခမဲ့ AI model access (အကြွေးဝယ်ကတ်မလိုအပ်)
- **ဖွံ့ဖြိုးရေး Tools**: Docker containers, VS Code, နှင့် GitHub Codespaces configuration
- **[→ အခန်း ၂ စတင်ရန်](./02-SetupDevEnvironment/README.md)**

### **အခန်း ၃: Generative AI နည်းလမ်းများ**
- **Prompt Engineering**: AI model အဖြေများအတွက် အကောင်းဆုံးနည်းလမ်းများ
- **Embeddings & Vector Operations**: Semantic search နှင့် similarity matching ကို အကောင်အထည်ဖော်ခြင်း
- **Retrieval-Augmented Generation (RAG)**: AI ကို သင့် data sources နှင့် ပေါင်းစပ်ခြင်း
- **Function Calling**: Custom tools နှင့် plugins ဖြင့် AI စွမ်းရည်များ တိုးမြှင့်ခြင်း
- **[→ အခန်း ၃ စတင်ရန်](./03-CoreGenerativeAITechniques/README.md)**

### **အခန်း ၄: အကောင်အထည်ဖော်မှုများနှင့် Project များ**
- **Pet Story Generator** (`petstory/`): GitHub Models ဖြင့် ဖန်တီးမှုအကြောင်းအရာ ဖန်တီးခြင်း
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK ဖြင့် ဒေသတွင်း AI model integration
- **MCP Calculator Service** (`calculator/`): Spring AI ဖြင့် Model Context Protocol အခြေခံအကောင်အထည်ဖော်မှု
- **[→ အခန်း ၄ စတင်ရန်](./04-PracticalSamples/README.md)**

### **အခန်း ၅: တာဝန်ရှိသော AI ဖွံ့ဖြိုးရေး**
- **GitHub Models Safety**: Built-in content filtering နှင့် safety mechanisms (hard blocks နှင့် soft refusals) ကို စမ်းသပ်ခြင်း
- **Responsible AI Demo**: အခက်အခဲမရှိသော AI safety systems အလုပ်လုပ်ပုံကို လက်တွေ့စမ်းသပ်ခြင်း
- **အကောင်းဆုံးနည်းလမ်းများ**: Ethical AI ဖွံ့ဖြိုးရေးနှင့် အသုံးချမှုအတွက် အရေးပါသော လမ်းညွှန်ချက်များ
- **[→ အခန်း ၅ စတင်ရန်](./05-ResponsibleGenAI/README.md)**

## အပိုဆောင်း အရင်းအမြစ်များ

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

## အကူအညီရယူခြင်း

AI app ဖန်တီးရာတွင် အခက်အခဲရှိပါက သို့မဟုတ် မေးခွန်းများရှိပါက ဤနေရာသို့ ဝင်ရောက်ပါ:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Product feedback သို့မဟုတ် ဖွံ့ဖြိုးရေးအတွင်း Error များရှိပါက ဤနေရာသို့ သွားပါ:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**ဝန်ခံချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှန်ကန်မှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက်ဘာသာပြန်ဆိုမှုများတွင် အမှားများ သို့မဟုတ် မမှန်ကန်မှုများ ပါဝင်နိုင်သည်ကို သတိပြုပါ။ မူလဘာသာစကားဖြင့် ရေးသားထားသော စာရွက်စာတမ်းကို အာဏာတည်သောရင်းမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များကို အသုံးပြုရန် အကြံပြုပါသည်။ ဤဘာသာပြန်ကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော နားလည်မှုမှားများ သို့မဟုတ် အဓိပ္ပါယ်မှားများအတွက် ကျွန်ုပ်တို့ တာဝန်မယူပါ။