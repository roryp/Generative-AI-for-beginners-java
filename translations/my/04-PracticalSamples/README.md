<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "139c227ef39d24287257d1aff6fc6973",
  "translation_date": "2025-07-25T10:16:33+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "my"
}
-->
# လက်တွေ့အသုံးချမှုများနှင့် ပရောဂျက်များ

> Note: နမူနာတစ်ခုစီတွင် **TUTORIAL.md** ပါဝင်ပြီး နမူနာများကို အဆင့်ဆင့် လုပ်ဆောင်ရန် လမ်းညွှန်ချက်များပါရှိသည်။

## သင်လေ့လာနိုင်မည့်အရာများ
ဤအပိုင်းတွင် Java ဖြင့် Generative AI ဖွံ့ဖြိုးတိုးတက်မှု ပုံစံများကို ပြသသည့် လက်တွေ့အသုံးချမှုများကို သုံးသပ်မည်ဖြစ်သည်။
- Client-side နှင့် Server-side AI ပေါင်းစပ်ထားသော Multi-modal Pet Story Generator တစ်ခု ဖန်တီးခြင်း
- Foundry Local Spring Boot demo ဖြင့် ဒေသခံ AI မော်ဒယ်များကို ပေါင်းစပ်အသုံးပြုခြင်း
- Calculator နမူနာဖြင့် Model Context Protocol (MCP) ဝန်ဆောင်မှု တစ်ခု ဖွံ့ဖြိုးတိုးတက်ခြင်း

## အကြောင်းအရာများ

- [မိတ်ဆက်](../../../04-PracticalSamples)
  - [Foundry Local Spring Boot Demo](../../../04-PracticalSamples)
  - [Pet Story Generator](../../../04-PracticalSamples)
  - [MCP Calculator Service (Beginner-Friendly MCP Demo)](../../../04-PracticalSamples)
- [လေ့လာမှု အဆင့်ဆင့်](../../../04-PracticalSamples)
- [အကျဉ်းချုပ်](../../../04-PracticalSamples)
- [နောက်ထပ်အဆင့်များ](../../../04-PracticalSamples)

## မိတ်ဆက်

ဤအခန်းတွင် **နမူနာပရောဂျက်များ** ကို ပြသထားပြီး Java ဖြင့် Generative AI ဖွံ့ဖြိုးတိုးတက်မှု ပုံစံများကို သက်သေပြထားသည်။ နမူနာတစ်ခုစီသည် အပြည့်အဝ လုပ်ဆောင်နိုင်ပြီး သင့်ပရောဂျက်များအတွက် အသုံးပြုနိုင်သော AI နည်းပညာများ၊ ဖွဲ့စည်းပုံပုံစံများနှင့် အကောင်းဆုံး လုပ်ဆောင်မှုများကို ပြသထားသည်။

### Foundry Local Spring Boot Demo

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** သည် **OpenAI Java SDK** ကို အသုံးပြု၍ ဒေသခံ AI မော်ဒယ်များနှင့် ပေါင်းစပ်အသုံးပြုနည်းကို ပြသထားသည်။ ဤနမူနာသည် Foundry Local တွင် လည်ပတ်နေသော **Phi-3.5-mini** မော်ဒယ်နှင့် ချိတ်ဆက်ခြင်းကို ပြသပြီး Cloud Services မရှိဘဲ AI အက်ပလီကေးရှင်းများကို လည်ပတ်နိုင်စေသည်။

### Pet Story Generator

**[Pet Story Generator](petstory/README.md)** သည် **multi-modal AI processing** ကို အသုံးပြု၍ ဖန်တီးမှုအရသာရှိသော တိရစ္ဆာန်ပုံပြင်များ ဖန်တီးနိုင်သည့် Spring Boot web application တစ်ခုဖြစ်သည်။ ဤနမူနာသည် transformer.js ကို အသုံးပြု၍ browser-based AI အပြန်အလှန်လုပ်ဆောင်မှုများနှင့် OpenAI SDK ကို အသုံးပြု၍ server-side AI လုပ်ဆောင်မှုများကို ပေါင်းစပ်ထားသည်။

### MCP Calculator Service (Beginner-Friendly MCP Demo)

**[MCP Calculator Service](mcp/calculator/README.md)** သည် Spring AI ကို အသုံးပြု၍ **Model Context Protocol (MCP)** ကို ပြသထားသည့် နမူနာတစ်ခုဖြစ်သည်။ ဤနမူနာသည် MCP အခြေခံအကြောင်းအရာများကို ရှင်းလင်းပြသပြီး MCP Server တစ်ခုကို ဖန်တီးကာ MCP Clients နှင့် အပြန်အလှန်လုပ်ဆောင်မှုများကို ပြသထားသည်။

## လေ့လာမှု အဆင့်ဆင့်

ဤပရောဂျက်များသည် ယခင်အခန်းများမှ အကြောင်းအရာများကို ဆက်လက်တိုးတက်စေရန် ရည်ရွယ်ထားသည်။

1. **ရိုးရှင်းစွာ စတင်ပါ**: Foundry Local Spring Boot Demo ကို စတင်၍ ဒေသခံမော်ဒယ်များနှင့် AI ပေါင်းစပ်အသုံးပြုနည်းကို နားလည်ပါ
2. **အပြန်အလှန်လုပ်ဆောင်မှုများ ထည့်သွင်းပါ**: Pet Story Generator ကို ဆက်လက်လေ့လာပြီး multi-modal AI နှင့် web-based လုပ်ဆောင်မှုများကို နားလည်ပါ
3. **MCP အခြေခံများကို လေ့လာပါ**: MCP Calculator Service ကို စမ်းသပ်ပြီး Model Context Protocol အခြေခံအကြောင်းအရာများကို နားလည်ပါ

## အကျဉ်းချုပ်

**ဂုဏ်ယူပါတယ်!** သင်အောင်မြင်စွာ:

- **Client-side နှင့် Server-side AI ပေါင်းစပ်ထားသော multi-modal AI အတွေ့အကြုံများ ဖန်တီးနိုင်ခဲ့သည်**
- **ဒေသခံ AI မော်ဒယ်များကို Java frameworks နှင့် SDKs အသုံးပြု၍ ပေါင်းစပ်အသုံးပြုနိုင်ခဲ့သည်**
- **Model Context Protocol ဝန်ဆောင်မှုများ ဖွံ့ဖြိုးတိုးတက်နိုင်ခဲ့သည်** 

## နောက်ထပ်အဆင့်များ

[Chapter 5: Responsible Generative AI](../05-ResponsibleGenAI/README.md)

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်မှုများတွင် အမှားများ သို့မဟုတ် မမှန်ကန်မှုများ ပါရှိနိုင်သည်ကို သတိပြုပါ။ မူရင်းစာရွက်စာတမ်းကို ၎င်း၏ မူရင်းဘာသာစကားဖြင့် အာဏာတရ အရင်းအမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များမှ ပရော်ဖက်ရှင်နယ် ဘာသာပြန်မှုကို အကြံပြုပါသည်။ ဤဘာသာပြန်မှုကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအမှားများ သို့မဟုတ် အနားလွဲမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။