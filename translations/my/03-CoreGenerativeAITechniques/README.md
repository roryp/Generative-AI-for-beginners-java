<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T20:42:34+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "my"
}
-->
# အဓိက Generative AI နည်းလမ်းများ

>**Note**: ဒီအခန်းမှာ [**Tutorial**](./TUTORIAL.md) တစ်ခုပါဝင်ပြီး နမူနာများကို အပြီးသတ်ပြုလုပ်ရန် လမ်းညွှန်ပေးထားပါတယ်။

## သင်လေ့လာနိုင်မည့်အရာများ
ဒီအခန်းမှာ ကျွန်ုပ်တို့ ၄ မျိုးသော အဓိက Generative AI နည်းလမ်းများကို လက်တွေ့နမူနာများဖြင့် လေ့လာပါမည်။
- LLM completions နှင့် chat flows
- Function calling
- Retrieval-Augmented Generation (RAG)
- တာဝန်ရှိသော AI လုံခြုံရေးအတိုင်းအတာများ

## အကြောင်းအရာများ

- [သင်လေ့လာနိုင်မည့်အရာများ](../../../03-CoreGenerativeAITechniques)
- [လိုအပ်ချက်များ](../../../03-CoreGenerativeAITechniques)
- [စတင်ရန်](../../../03-CoreGenerativeAITechniques)
- [နမူနာများအကျဉ်းချုပ်](../../../03-CoreGenerativeAITechniques)
  - [1. LLM Completions နှင့် Chat Flows](../../../03-CoreGenerativeAITechniques)
  - [2. Functions & Plugins with LLMs](../../../03-CoreGenerativeAITechniques)
  - [3. Retrieval-Augmented Generation (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. တာဝန်ရှိသော AI လုံခြုံရေး ပြသမှု](../../../03-CoreGenerativeAITechniques)
- [အကျဉ်းချုပ်](../../../03-CoreGenerativeAITechniques)
- [နောက်တစ်ဆင့်](../../../03-CoreGenerativeAITechniques)

## လိုအပ်ချက်များ

- [Chapter 2](../../../02-SetupDevEnvironment) မှ အခြေခံအဆင့်များ ပြီးစီးထားရမည်။

## စတင်ရန်

1. **နမူနာများသို့ သွားပါ**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **ပတ်ဝန်းကျင်ကို သတ်မှတ်ပါ**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **နမူနာများကို Compile နှင့် Run လုပ်ပါ**:  
```bash
   # Run completions example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
   
   # Run functions example  
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
   
   # Run RAG example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
   
   # Run responsible AI demo
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```  

## နမူနာများအကျဉ်းချုပ်

နမူနာများကို `examples/` ဖိုလ်ဒါအတွင်း အောက်ပါဖွဲ့စည်းမှုဖြင့် စီစဉ်ထားသည်။

```
examples/
├── src/main/java/com/example/genai/techniques/
│   ├── completions/
│   │   └── LLMCompletionsApp.java        # Basic completions 
│   ├── functions/
│   │   └── FunctionsApp.java             # Function calling examples
│   ├── rag/
│   │   └── SimpleReaderDemo.java         # Retrieval-Augmented Generation
│   └── responsibleai/
│       └── ResponsibleGithubModels.java  # Responsible AI safety demonstration
├── document.txt                          # Sample document for RAG example
└── pom.xml                               # Maven configuration
```

### 1. LLM Completions နှင့် Chat Flows
**ဖိုင်**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Streaming responses နှင့် chat history ကို စီမံခန့်ခွဲပြီး စကားပြော AI တည်ဆောက်ရန် လေ့လာပါ။

ဒီနမူနာမှာ ပြသထားသည်မှာ:
- System prompts ဖြင့် ရိုးရှင်းသော text completion
- သမိုင်းစီမံခန့်ခွဲမှုဖြင့် Multi-turn စကားပြောများ
- အပြန်အလှန် chat session များ
- Parameter configuration (temperature, max tokens)

### 2. Functions & Plugins with LLMs
**ဖိုင်**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

AI ၏ စွမ်းဆောင်ရည်များကို Custom functions နှင့် အပြင်ပ APIs များဖြင့် တိုးချဲ့ပါ။

ဒီနမူနာမှာ ပြသထားသည်မှာ:
- မိုးလေဝသ function ပေါင်းစည်းမှု
- Calculator function အကောင်အထည်ဖော်မှု  
- တစ်ခန်းစကားပြောအတွင်း Function များစွာ ခေါ်ယူမှု
- JSON schemas ဖြင့် Function သတ်မှတ်မှု

### 3. Retrieval-Augmented Generation (RAG)
**ဖိုင်**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

AI ကို သင့်ကိုယ်ပိုင်စာရွက်စာတမ်းများနှင့် ဒေတာရင်းမြစ်များနှင့် ပေါင်းစပ်ပြီး တိကျသော၊ အကြောင်းအရာနှင့် သက်ဆိုင်သော အဖြေများရယူရန် လေ့လာပါ။

ဒီနမူနာမှာ ပြသထားသည်မှာ:
- Azure OpenAI SDK ဖြင့် စာရွက်စာတမ်းအခြေခံမေးခွန်းအဖြေ
- GitHub Models ဖြင့် RAG ပုံစံအကောင်အထည်ဖော်မှု

**အသုံးပြုမှု**: `document.txt` အတွင်းပါဝင်သော အကြောင်းအရာများအပေါ် မေးခွန်းများမေးပြီး အဆိုပါအကြောင်းအရာအပေါ်သာ အခြေခံသော AI အဖြေများရယူပါ။

### 4. တာဝန်ရှိသော AI လုံခြုံရေး ပြသမှု
**ဖိုင်**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

GitHub Models ၏ အကြောင်းအရာစစ်ထုတ်နိုင်စွမ်းများကို စမ်းသပ်ခြင်းဖြင့် AI လုံခြုံရေးအတိုင်းအတာများကို ကြိုတင်ကြည့်ရှုပါ။

ဒီနမူနာမှာ ပြသထားသည်မှာ:
- အန္တရာယ်ရှိနိုင်သော prompts များအတွက် အကြောင်းအရာစစ်ထုတ်မှု
- လျှောက်လွှာများအတွင်း လုံခြုံရေးတုံ့ပြန်မှုကို ကိုင်တွယ်မှု
- ပိတ်ပင်ထားသော အကြောင်းအရာအမျိုးအစားများ (အကြမ်းဖက်မှု၊ မုန်းတီးစကား၊ မှားယွင်းသောသတင်း)
- လုံခြုံရေးချိုးဖောက်မှုများအတွက် မှန်ကန်သော အမှားကိုင်တွယ်မှု

> **Learn More**: ဒီဟာက တာဝန်ရှိသော AI အယူအဆများအတွက် အကျဉ်းချုပ်သာဖြစ်သည်။ အကျင့်သိက္ခာ၊ အလွဲသက်သာရေး၊ ကိုယ်ရေးအချက်အလက်စောင့်ရှောက်မှုနှင့် တာဝန်ရှိသော AI ဖွဲ့စည်းမှုများအကြောင်း အသေးစိတ်ကို [Chapter 5: Responsible Generative AI](../05-ResponsibleGenAI/README.md) တွင် ကြည့်ရှုပါ။

## အကျဉ်းချုပ်

ဒီအခန်းမှာ ကျွန်ုပ်တို့ LLM completions နှင့် chat flows ကို လေ့လာခဲ့ပြီး၊ AI ၏ စွမ်းဆောင်ရည်များကို တိုးချဲ့ရန် function calling ကို အကောင်အထည်ဖော်ခဲ့ပြီး၊ Retrieval-Augmented Generation (RAG) စနစ်တစ်ခုကို ဖန်တီးခဲ့ပြီး၊ တာဝန်ရှိသော AI လုံခြုံရေးအတိုင်းအတာများကို ပြသခဲ့ပါသည်။

> **NOTE**: ပေးထားသော [**Tutorial**](./TUTORIAL.md) ဖြင့် နက်ရှိုင်းစွာ လေ့လာပါ။

## နောက်တစ်ဆင့်

[Chapter 4: လက်တွေ့အသုံးချမှုများနှင့် ပရောဂျက်များ](../04-PracticalSamples/README.md)

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်ခြင်းတွင် အမှားများ သို့မဟုတ် မတိကျမှုများ ပါရှိနိုင်သည်ကို သတိပြုပါ။ မူရင်းစာရွက်စာတမ်းကို ၎င်း၏ မူရင်းဘာသာစကားဖြင့် အာဏာတရားရှိသော အရင်းအမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များမှ ပရော်ဖက်ရှင်နယ် ဘာသာပြန်ခြင်းကို အကြံပြုပါသည်။ ဤဘာသာပြန်ကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအလွတ်များ သို့မဟုတ် အနားလွဲမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။