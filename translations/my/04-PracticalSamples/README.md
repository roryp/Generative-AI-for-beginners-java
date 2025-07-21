<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "da1b6d87b8a73306b29f9a1bdd681221",
  "translation_date": "2025-07-21T21:15:37+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "my"
}
-->
# လက်တွေ့အသုံးချမှုများနှင့် ပရောဂျက်များ

> Note: ဤဥပမာတစ်ခုစီတွင် **TUTORIAL.md** ပါဝင်ပြီး အက်ပလီကေးရှင်းကို အဆင့်ဆင့် လုပ်ဆောင်ရန် လမ်းညွှန်ထားသည်။

## သင်လေ့လာနိုင်မည့်အရာများ
ဤအပိုင်းတွင် Java ဖြင့် Generative AI ဖွံ့ဖြိုးတိုးတက်မှု ပုံစံများကို ပြသသည့် လက်တွေ့အသုံးချမှုများကို သုံးသပ်မည်ဖြစ်သည်။
- Client-side နှင့် Server-side AI ပေါင်းစပ်ထားသော Multi-modal Pet Story Generator တစ်ခု ဖန်တီးခြင်း
- Foundry Local Spring Boot demo ဖြင့် ဒေသခံ AI မော်ဒယ်များ ပေါင်းစည်းခြင်း
- Calculator ဥပမာဖြင့် Model Context Protocol (MCP) ဝန်ဆောင်မှု တီထွင်ခြင်း

## အကြောင်းအရာများ

- [မိတ်ဆက်](../../../04-PracticalSamples)
  - [Foundry Local Spring Boot Demo](../../../04-PracticalSamples)
  - [Pet Story Generator](../../../04-PracticalSamples)
  - [MCP Calculator Service (Beginner-Friendly MCP Demo)](../../../04-PracticalSamples)
- [လေ့လာမှု အဆင့်ဆင့်](../../../04-PracticalSamples)
- [အကျဉ်းချုပ်](../../../04-PracticalSamples)
- [နောက်ထပ်အဆင့်များ](../../../04-PracticalSamples)

## မိတ်ဆက်

ဤအခန်းတွင် **နမူနာပရောဂျက်များ** ကို ပြသထားပြီး Java ဖြင့် Generative AI ဖွံ့ဖြိုးတိုးတက်မှု ပုံစံများကို သက်သေပြထားသည်။ ပရောဂျက်တစ်ခုစီသည် အပြည့်အဝ လုပ်ဆောင်နိုင်ပြီး သင့်အက်ပလီကေးရှင်းများအတွက် အသုံးချနိုင်သော AI နည်းပညာများ၊ ဖွဲ့စည်းပုံပုံစံများနှင့် အကောင်းဆုံး လုပ်ဆောင်မှုများကို ပြသထားသည်။

### Foundry Local Spring Boot Demo

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** သည် **OpenAI Java SDK** ကို အသုံးပြု၍ ဒေသခံ AI မော်ဒယ်များနှင့် ပေါင်းစည်းပုံကို ပြသထားသည်။ ဤပရောဂျက်သည် Foundry Local တွင် လည်ပတ်နေသော **Phi-3.5-mini** မော်ဒယ်နှင့် ချိတ်ဆက်ခြင်းကို ပြသထားပြီး Cloud Services မလိုအပ်ဘဲ AI အက်ပလီကေးရှင်းများကို လည်ပတ်နိုင်စေသည်။

### Pet Story Generator

**[Pet Story Generator](petstory/README.md)** သည် **multi-modal AI processing** ကို အသုံးပြု၍ ဖန်တီးမှုအရမ်းကောင်းသော တိရစ္ဆာန်ပုံပြင်များ ဖန်တီးနိုင်သည့် Spring Boot web application ဖြစ်သည်။ ဤပရောဂျက်သည် transformer.js ကို အသုံးပြု၍ browser-based AI အပြန်အလှန်လုပ်ဆောင်မှုများနှင့် OpenAI SDK ကို အသုံးပြု၍ server-side လုပ်ဆောင်မှုများကို ပေါင်းစပ်ထားသည်။

### MCP Calculator Service (Beginner-Friendly MCP Demo)

**[MCP Calculator Service](mcp/calculator/README.md)** သည် Spring AI ကို အသုံးပြု၍ **Model Context Protocol (MCP)** ကို ပြသထားသည့် ရိုးရှင်းသော နမူနာဖြစ်သည်။ ဤပရောဂျက်သည် MCP အခြေခံအယူအဆများကို ရှင်းလင်းစွာ ဖော်ပြထားပြီး MCP Server တစ်ခုကို ဖန်တီးကာ MCP Clients နှင့် အပြန်အလှန်လုပ်ဆောင်မှုများကို ပြသထားသည်။

## လေ့လာမှု အဆင့်ဆင့်

ဤပရောဂျက်များကို အခြေခံအယူအဆများအပေါ် အဆင့်ဆင့် တိုးတက်စေရန် ဒီဇိုင်းဆွဲထားသည်။

1. **ရိုးရှင်းစွာ စတင်ပါ**: Foundry Local Spring Boot Demo ကို စတင်၍ ဒေသခံမော်ဒယ်များနှင့် AI ပေါင်းစည်းပုံကို နားလည်ပါ
2. **အပြန်အလှန်လုပ်ဆောင်မှုများ ထည့်သွင်းပါ**: Multi-modal AI နှင့် web-based လုပ်ဆောင်မှုများအတွက် Pet Story Generator ကို ဆက်လက် လေ့လာပါ
3. **MCP အခြေခံများကို လေ့လာပါ**: Model Context Protocol အခြေခံအယူအဆများကို နားလည်ရန် MCP Calculator Service ကို စမ်းသုံးပါ

## အကျဉ်းချုပ်

**ဂုဏ်ယူပါတယ်!** သင်အောင်မြင်စွာ:

- **Client-side နှင့် Server-side AI ပေါင်းစပ်ထားသော multi-modal AI အတွေ့အကြုံများ ဖန်တီးနိုင်ခဲ့သည်**
- **ခေတ်မီ Java frameworks နှင့် SDK များကို အသုံးပြု၍ ဒေသခံ AI မော်ဒယ်များ ပေါင်းစည်းနိုင်ခဲ့သည်**
- **Tool integration ပုံစံများကို ပြသထားသည့် Model Context Protocol ဝန်ဆောင်မှုများ ဖွံ့ဖြိုးတိုးတက်နိုင်ခဲ့သည်**

## နောက်ထပ်အဆင့်များ

[Chapter 5: Responsible Generative AI](../05-ResponsibleGenAI/README.md)

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်ခြင်းတွင် အမှားများ သို့မဟုတ် မမှန်ကန်မှုများ ပါဝင်နိုင်သည်ကို သတိပြုပါ။ မူရင်းစာရွက်စာတမ်းကို ၎င်း၏ မူလဘာသာစကားဖြင့် အာဏာတရ အရင်းအမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များမှ ပရော်ဖက်ရှင်နယ် ဘာသာပြန်ခြင်းကို အကြံပြုပါသည်။ ဤဘာသာပြန်ကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲသုံးစားမှုများ သို့မဟုတ် အနားလွဲမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။