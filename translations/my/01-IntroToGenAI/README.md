<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "006866db93a268a8769bb55f2e324291",
  "translation_date": "2025-07-28T11:18:40+00:00",
  "source_file": "01-IntroToGenAI/README.md",
  "language_code": "my"
}
-->
# Generative AI - Java Edition အကြောင်းအကျဉ်း

## သင်လေ့လာမည့်အရာများ

- **Generative AI အခြေခံအကြောင်းအရာများ** - LLMs, prompt engineering, tokens, embeddings, နှင့် vector databases အပါအဝင်
- **Java AI ဖွံ့ဖြိုးရေး tools များနှင့် နှိုင်းယှဉ်ခြင်း** - Azure OpenAI SDK, Spring AI, နှင့် OpenAI Java SDK
- **Model Context Protocol** နှင့် AI agent များအကြား ဆက်သွယ်မှုတွင် အရေးပါမှု

## အကြောင်းအရာများ

- [Introduction](../../../01-IntroToGenAI)
- [Generative AI အကြောင်းအရာများကို အမြန်ပြန်လည်သုံးသပ်ခြင်း](../../../01-IntroToGenAI)
- [Prompt engineering အကြောင်းအရာများကို ပြန်လည်သုံးသပ်ခြင်း](../../../01-IntroToGenAI)
- [Tokens, embeddings, နှင့် agents](../../../01-IntroToGenAI)
- [Java အတွက် AI ဖွံ့ဖြိုးရေး Tools နှင့် Libraries](../../../01-IntroToGenAI)
  - [OpenAI Java SDK](../../../01-IntroToGenAI)
  - [Spring AI](../../../01-IntroToGenAI)
  - [Azure OpenAI Java SDK](../../../01-IntroToGenAI)
- [Summary](../../../01-IntroToGenAI)
- [Next Steps](../../../01-IntroToGenAI)

## Introduction

Generative AI for Beginners - Java Edition ရဲ့ ပထမဆုံးအခန်းကို ကြိုဆိုပါတယ်! ဒီအခြေခံသင်ခန်းစာမှာ Generative AI ရဲ့ အဓိကအကြောင်းအရာများနှင့် Java ကို အသုံးပြု၍ အလုပ်လုပ်ပုံကို မိတ်ဆက်ပေးမှာဖြစ်ပါတယ်။ Large Language Models (LLMs), tokens, embeddings, နှင့် AI agents အပါအဝင် AI application များရဲ့ အရေးပါသော အခြေခံအဆောက်အအုံများကို သင်လေ့လာရမှာဖြစ်ပါတယ်။ ဒီသင်တန်းတစ်ခုလုံးအတွင်း သင်အသုံးပြုမည့် Java tooling များကိုလည်း လေ့လာရမှာဖြစ်ပါတယ်။

### Generative AI အကြောင်းအရာများကို အမြန်ပြန်လည်သုံးသပ်ခြင်း

Generative AI ဆိုတာ ဒေတာထဲက pattern နှင့် ဆက်နွယ်မှုများကို လေ့လာပြီး အသစ်သော အကြောင်းအရာများ (စာသား, ပုံရိပ်, သို့မဟုတ် code) ဖန်တီးပေးနိုင်တဲ့ AI အမျိုးအစားတစ်ခုဖြစ်ပါတယ်။ Generative AI မော်ဒယ်များက လူသားလိုပုံစံရှိတဲ့ အကြောင်းအရာများကို ဖန်တီးပေးနိုင်ပြီး context ကို နားလည်နိုင်သလို၊ တစ်ခါတစ်ရံ လူသားလိုပုံစံရှိတဲ့ အကြောင်းအရာများကို ဖန်တီးပေးနိုင်ပါတယ်။

Java AI application များကို ဖွံ့ဖြိုးတိုးတက်စဉ်မှာ **Generative AI မော်ဒယ်များ** ကို အသုံးပြု၍ အကြောင်းအရာများ ဖန်တီးရမှာဖြစ်ပါတယ်။ Generative AI မော်ဒယ်များရဲ့ အစွမ်းအလှမ်းများမှာ:

- **စာသားဖန်တီးခြင်း**: Chatbot, အကြောင်းအရာဖန်တီးခြင်း, နှင့် စာသားဖြည့်စွက်ခြင်းအတွက် လူသားလိုပုံစံရှိတဲ့ စာသားများ ဖန်တီးခြင်း။
- **ပုံရိပ်ဖန်တီးခြင်းနှင့် ခွဲခြားခြင်း**: အမှန်တကယ်ရှိတဲ့ ပုံရိပ်များ ဖန်တီးခြင်း, ဓာတ်ပုံများ တိုးတက်အောင်လုပ်ခြင်း, နှင့် အရာဝတ္ထုများကို ရှာဖွေခြင်း။
- **Code ဖန်တီးခြင်း**: Code snippets သို့မဟုတ် scripts များရေးသားခြင်း။

မော်ဒယ်များမှာ တစ်ခုချင်းစီအတွက် အထူးပြုထားတဲ့ အမျိုးအစားများရှိပါတယ်။ ဥပမာအားဖြင့် **Small Language Models (SLMs)** နှင့် **Large Language Models (LLMs)** နှစ်မျိုးစလုံး စာသားဖန်တီးခြင်းကို လုပ်ဆောင်နိုင်ပြီး LLMs က ပိုမိုရှုပ်ထွေးတဲ့ အလုပ်များအတွက် ပိုမိုကောင်းမွန်တဲ့ စွမ်းဆောင်ရည်ပေးနိုင်ပါတယ်။ ပုံရိပ်နှင့်ဆိုင်သော အလုပ်များအတွက် vision models သို့မဟုတ် multi-modal models ကို အသုံးပြုရပါမယ်။

![Figure: Generative AI model types and use cases.](../../../translated_images/llms.225ca2b8a0d344738419defc5ae14bba2fd3388b94f09fd4e8be8ce2a720ae51.my.png)

မော်ဒယ်များရဲ့ အဖြေများဟာ အချို့အခါမှာ အပြည့်အဝမှန်ကန်မဖြစ်နိုင်ပါဘူး။ မော်ဒယ်များ "hallucinating" လို့ခေါ်တဲ့ အမှားအချက်အလက်များကို အာဏာရှိတဲ့ပုံစံနဲ့ ဖန်တီးပေးနိုင်တယ်ဆိုတာ သင်ကြားဖူးနေရမယ်။ ဒါပေမယ့် **prompt engineering** ကို အသုံးပြုခြင်းအားဖြင့် မော်ဒယ်ကို ပိုမိုကောင်းမွန်တဲ့ အဖြေများ ဖန်တီးပေးစေဖို့ လမ်းညွှန်နိုင်ပါတယ်။

#### Prompt engineering review

Prompt engineering ဆိုတာ AI မော်ဒယ်များကို သင်လိုချင်တဲ့ output များရဖို့ အထောက်အကူပြုတဲ့ input များကို ဒီဇိုင်းဆွဲခြင်းဖြစ်ပါတယ်။ Prompt engineering တွင်:

- **ရှင်းလင်းမှု**: လမ်းညွှန်ချက်များကို ရှင်းလင်းပြီး မရှုပ်ထွေးအောင်လုပ်ခြင်း။
- **Context**: လိုအပ်သော နောက်ခံအချက်အလက်များပေးခြင်း။
- **Constraints**: အကန့်အသတ်များ သို့မဟုတ် format များကို သတ်မှတ်ခြင်း။

Prompt engineering ရဲ့ အကောင်းဆုံးအလေ့အကျင့်များမှာ prompt design, ရှင်းလင်းတဲ့ လမ်းညွှန်ချက်များ, အလုပ်ကို အပိုင်းအခြားခွဲခြင်း, one-shot နှင့် few-shot learning, နှင့် prompt tuning ပါဝင်ပါတယ်။ သင့် use case အတွက် အကောင်းဆုံးအလုပ်လုပ်တဲ့ prompt ကို ရှာဖွေဖို့ prompt များကို စမ်းသပ်ဖို့ လိုအပ်ပါတယ်။

Application များဖွံ့ဖြိုးတိုးတက်စဉ်မှာ သင် encounter ဖြစ်ရမည့် prompt အမျိုးအစားများမှာ:

- **System prompts**: မော်ဒယ်ရဲ့ အခြေခံစည်းမျဉ်းများနှင့် context ကို သတ်မှတ်ခြင်း
- **User prompts**: သင့် application user များထံမှ input data
- **Assistant prompts**: System နှင့် user prompts အပေါ်အခြေခံပြီး မော်ဒယ်ရဲ့ အဖြေများ

> **Learn more**: Prompt engineering အကြောင်းကို [Prompt Engineering chapter of GenAI for Beginners course](https://github.com/microsoft/generative-ai-for-beginners/tree/main/04-prompt-engineering-fundamentals) မှာ ပိုမိုလေ့လာပါ။

#### Tokens, embeddings, နှင့် agents

Generative AI မော်ဒယ်များနှင့် အလုပ်လုပ်စဉ် **tokens**, **embeddings**, **agents**, နှင့် **Model Context Protocol (MCP)** စသည်တို့ကို တွေ့ရပါမယ်။ ဒီအကြောင်းအရာများကို အကျဉ်းချုပ်ဖော်ပြပါ:

- **Tokens**: Tokens ဆိုတာ စာသားရဲ့ အငယ်ဆုံး unit ဖြစ်ပါတယ်။ စကားလုံးများ, အက္ခရာများ, သို့မဟုတ် subwords ဖြစ်နိုင်ပါတယ်။ Tokens တွေကို မော်ဒယ်နားလည်နိုင်တဲ့ format အဖြစ် စီစဉ်ပေးပါတယ်။ ဥပမာအားဖြင့် "The quick brown fox jumped over the lazy dog" ဆိုတဲ့ စာကြောင်းကို ["The", " quick", " brown", " fox", " jumped", " over", " the", " lazy", " dog"] သို့မဟုတ် ["The", " qu", "ick", " br", "own", " fox", " jump", "ed", " over", " the", " la", "zy", " dog"] အဖြစ် tokenize လုပ်နိုင်ပါတယ်။

![Figure: Generative AI tokens example of breaking words into tokens](../../../01-IntroToGenAI/images/tokens.webp)

Tokenization ဆိုတာ စာသားကို ဒီအငယ် unit များအဖြစ် ခွဲခြားခြင်းဖြစ်ပါတယ်။ မော်ဒယ်များဟာ raw text အစား tokens တွေပေါ်မှာ အလုပ်လုပ်ပါတယ်။ Prompt ထဲမှာ token အရေအတွက်က မော်ဒယ်ရဲ့ အဖြေ အရှည်နှင့် အရည်အသွေးကို သက်ရောက်စေပါတယ်။ GPT-4o ရဲ့ context window (input နှင့် output အပါအဝင်) အတွက် token အကန့်အသတ် (ဥပမာ 128K tokens) ရှိပါတယ်။

Java မှာ OpenAI SDK ကဲ့သို့သော libraries ကို အသုံးပြု၍ tokenization ကို အလိုအလျောက် handle လုပ်နိုင်ပါတယ်။

- **Embeddings**: Embeddings ဆိုတာ tokens ရဲ့ semantic အဓိပ္ပာယ်ကို ဖော်ပြတဲ့ vector representation ဖြစ်ပါတယ်။ ဒါဟာ floating-point number array များဖြစ်ပြီး စကားလုံးများအကြား ဆက်နွယ်မှုများကို နားလည်စေပါတယ်။ Synonyms နှင့် semantic relationships ကဲ့သို့သော အကြောင်းအရာများကို နားလည်စေပါတယ်။

![Figure: Embeddings](../../../translated_images/embedding.398e50802c0037f931c725fd0113747831ea7776434d2b3ba3eb2e7a1a20ab1f.my.png)

Java မှာ OpenAI SDK သို့မဟုတ် embedding generation ကို ပံ့ပိုးတဲ့ အခြား libraries များကို အသုံးပြု၍ embeddings ဖန်တီးနိုင်ပါတယ်။ Semantic search ကဲ့သို့သော အလုပ်များအတွက် အဓိကအရေးပါပါတယ်။

- **Vector databases**: Vector databases ဆိုတာ embeddings အတွက် အထူးပြုထားတဲ့ storage systems ဖြစ်ပါတယ်။ Semantic similarity အပေါ်အခြေခံပြီး အချက်အလက်များကို ရှာဖွေဖို့ အရေးပါပါတယ်။

![Figure: Vector database architecture showing how embeddings are stored and retrieved for similarity search.](../../../translated_images/vector.f12f114934e223dff971b01ca371e85a41a540f3af2ffdd49fb3acec6c6652f2.my.png)

> **Note**: ဒီသင်တန်းမှာ Vector databases ကို မဖော်ပြပေမယ့် အရေးပါတဲ့ အကြောင်းအရာဖြစ်တဲ့အတွက် ဖော်ပြထားပါတယ်။

- **Agents & MCP**: AI မော်ဒယ်များ, tools, နှင့် အပြင်ပန်းစနစ်များနှင့် အလိုအလျောက် ဆက်သွယ်နိုင်တဲ့ components များ။ Model Context Protocol (MCP) က agents များကို အပြင်ပန်း data sources နှင့် tools များကို လုံခြုံစွာ access လုပ်နိုင်စေတဲ့ standard ဖြစ်ပါတယ်။ [MCP for Beginners](https://github.com/microsoft/mcp-for-beginners) သင်တန်းမှာ ပိုမိုလေ့လာနိုင်ပါတယ်။

Java AI application များတွင် tokens ကို text processing အတွက်, embeddings ကို semantic search နှင့် RAG အတွက်, vector databases ကို data retrieval အတွက်, နှင့် MCP ပါဝင်တဲ့ agents ကို intelligent systems ဖန်တီးရန် အသုံးပြုရပါမယ်။

![Figure: how a prompt becomes a reply—tokens, vectors, optional RAG lookup, LLM thinking, and an MCP agent all in one quick flow..](../../../translated_images/flow.f4ef62c3052d12a88b1d216eb2cd0e2ea3293c806d0defa7921dd1786dcb8516.my.png)

### Java အတွက် AI ဖွံ့ဖြိုးရေး Tools နှင့် Libraries

Java မှာ AI ဖွံ့ဖြိုးတိုးတက်မှုအတွက် အလွန်ကောင်းမွန်တဲ့ tooling ရှိပါတယ်။ ဒီသင်တန်းတစ်ခုလုံးအတွင်း OpenAI Java SDK, Azure OpenAI SDK, နှင့် Spring AI libraries သုံးခုကို လေ့လာရမှာဖြစ်ပါတယ်။

ဒီသင်တန်းရဲ့ အခန်းတစ်ခုချင်းစီမှာ အသုံးပြုမည့် SDK ကို ဖော်ပြထားတဲ့ reference table:

| Chapter | Sample | SDK |
|---------|--------|-----|
| 02-SetupDevEnvironment | github-models | OpenAI Java SDK |
| 02-SetupDevEnvironment | basic-chat-azure | Spring AI Azure OpenAI |
| 03-CoreGenerativeAITechniques | examples | Azure OpenAI SDK |
| 04-PracticalSamples | petstory | OpenAI Java SDK |
| 04-PracticalSamples | foundrylocal | OpenAI Java SDK |
| 04-PracticalSamples | calculator | Spring AI MCP SDK + LangChain4j |

**SDK Documentation Links:**
- [Azure OpenAI Java SDK](https://github.com/Azure/azure-sdk-for-java/tree/azure-ai-openai_1.0.0-beta.16/sdk/openai/azure-ai-openai)
- [Spring AI](https://docs.spring.io/spring-ai/reference/)
- [OpenAI Java SDK](https://github.com/openai/openai-java)
- [LangChain4j](https://docs.langchain4j.dev/)

#### OpenAI Java SDK

OpenAI SDK ဆိုတာ OpenAI API အတွက် Java library ဖြစ်ပြီး OpenAI ရဲ့ မော်ဒယ်များနှင့် အလုပ်လုပ်ဖို့ ရိုးရှင်းပြီး တိကျတဲ့ interface ပေးပါတယ်။ Java application များတွင် AI စွမ်းရည်များ ထည့်သွင်းဖို့ အလွန်လွယ်ကူစေပါတယ်။ Chapter 2 ရဲ့ GitHub Models ဥပမာ, Chapter 4 ရဲ့ Pet Story application နှင့် Foundry Local ဥပမာမှာ OpenAI SDK ကို အသုံးပြုထားပါတယ်။

#### Spring AI

Spring AI ဆိုတာ Spring application များအတွက် AI စွမ်းရည်များကို ပေးစွမ်းတဲ့ framework ဖြစ်ပြီး အမျိုးမျိုးသော AI providers များအတွက် consistent abstraction layer ပေးပါတယ်။ Spring ecosystem နှင့် အလွယ်တကူ ပေါင်းစည်းနိုင်ပြီး Enterprise Java application များအတွက် အထူးသင့်လျော်ပါတယ်။

Spring AI ရဲ့ အားသာချက်က Spring ecosystem နှင့် seamless integration ဖြစ်ပြီး dependency injection, configuration management, နှင့် testing frameworks ကဲ့သို့သော Spring patterns များကို အသုံးပြု၍ production-ready AI application များ ဖန်တီးနိုင်စေပါတယ်။ Chapter 2 နှင့် 4 မှာ Spring AI ကို အသုံးပြု၍ OpenAI နှင့် Model Context Protocol (MCP) Spring AI libraries ကို leverage လုပ်ထားပါတယ်။

##### Model Context Protocol (MCP)

[Model Context Protocol (MCP)](https://modelcontextprotocol.io/) ဆိုတာ AI application များကို အပြင်ပန်း data sources နှင့် tools များနှင့် securely ဆက်သွယ်နိုင်စေတဲ့ emerging standard ဖြစ်ပါတယ်။ MCP က AI မော်ဒယ်များကို contextual အချက်အလက်များ access လုပ်နိုင်စေပြီး သင့် application တွင် လုပ်ဆောင်မှုများကို အကောင်အထည်ဖော်နိုင်စေပါတယ်။

Chapter 4 မှာ Spring AI ကို အသုံးပြု၍ Model Context Protocol ရဲ့ အခြေခံ tool integration နှင့် service architecture များကို ဖော်ပြထားတဲ့ MCP calculator service ကို ဖန်တီးရမှာဖြစ်ပါတယ်။

#### Azure OpenAI Java SDK

Azure OpenAI client library for Java ဆိုတာ OpenAI ရဲ့ REST APIs ကို Azure SDK ecosystem နှင့် ပေါင်းစည်းထားတဲ့ idiomatic interface ဖြစ်ပါတယ်။ Chapter 3 မှာ Azure OpenAI SDK ကို အသုံးပြု၍ chat application, function calling, နှင့် RAG (Retrieval-Augmented Generation) patterns များကို ဖန်တီးရမှာဖြစ်ပါတယ်။

> Note: Azure OpenAI SDK ဟာ OpenAI Java SDK ထက် features အနည်းငယ်နောက်ကျနေပါတယ်။ အနာဂတ် project များအတွက် OpenAI Java SDK ကို အသုံးပြုဖို့ စဉ်းစားပါ။

## Summary

**ဂုဏ်ယူပါတယ်!** သင်အောင်မြင်စွာ:

- **Generative AI အခြေခံအကြောင်းအရာများကို လေ့လာခဲ့ပါပြီ** - LLMs, prompt engineering, tokens, embeddings, နှင့် vector databases အပါအဝင်
- **Java AI ဖွံ့ဖြိုးရေး tools များကို နှိုင်းယှဉ်ခဲ့ပါပြီ** - Azure OpenAI SDK, Spring AI, နှင့် OpenAI Java SDK
- **Model Context Protocol** နှင့် AI agent များအကြား ဆက်သွယ်မှုတွင် အရေးပါမှုကို ရှာဖွေခဲ့ပါပြီ

## Next Steps

[Chapter 2: Setting Up the Development Environment](../02-SetupDevEnvironment/README.md)

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေပါသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်မှုများတွင် အမှားများ သို့မဟုတ် မတိကျမှုများ ပါရှိနိုင်သည်ကို သတိပြုပါ။ မူရင်းစာရွက်စာတမ်းကို ၎င်း၏ မူရင်းဘာသာစကားဖြင့် အာဏာတရားရှိသော အရင်းအမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များမှ ပရော်ဖက်ရှင်နယ် ဘာသာပြန်မှုကို အကြံပြုပါသည်။ ဤဘာသာပြန်မှုကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအမှားများ သို့မဟုတ် အနားလွဲမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။