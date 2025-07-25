<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T10:16:11+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "my"
}
-->
# Core Generative AI Techniques

>**Note**: ဒီအခန်းမှာ [**Tutorial**](./TUTORIAL.md) ပါဝင်ပြီး နမူနာများကို လမ်းညွှန်ပေးထားပါတယ်။

## သင်လေ့လာနိုင်မည့်အရာများ
ဒီအခန်းမှာ လက်တွေ့နမူနာများကို အသုံးပြုပြီး အခြေခံ Generative AI နည်းလမ်း ၄ မျိုးကို လေ့လာပါမည်။
- LLM completions နှင့် chat flows
- Function calling
- Retrieval-Augmented Generation (RAG)
- တာဝန်ရှိသော AI လုံခြုံရေးအတိုင်းအတာများ

## အကြောင်းအရာများ

- [သင်လေ့လာနိုင်မည့်အရာများ](../../../03-CoreGenerativeAITechniques)
- [လိုအပ်ချက်များ](../../../03-CoreGenerativeAITechniques)
- [စတင်ခြင်း](../../../03-CoreGenerativeAITechniques)
- [နမူနာများအကြောင်း](../../../03-CoreGenerativeAITechniques)
  - [1. LLM Completions နှင့် Chat Flows](../../../03-CoreGenerativeAITechniques)
  - [2. Functions & Plugins with LLMs](../../../03-CoreGenerativeAITechniques)
  - [3. Retrieval-Augmented Generation (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. တာဝန်ရှိသော AI လုံခြုံရေးအတိုင်းအတာများ](../../../03-CoreGenerativeAITechniques)
- [အကျဉ်းချုပ်](../../../03-CoreGenerativeAITechniques)
- [နောက်တစ်ဆင့်](../../../03-CoreGenerativeAITechniques)

## လိုအပ်ချက်များ

- [Chapter 2](../../../02-SetupDevEnvironment) မှ setup ပြီးစီးထားသည်။

## စတင်ခြင်း

1. **နမူနာများကို ရှာဖွေပါ**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **ပတ်ဝန်းကျင်ကို သတ်မှတ်ပါ**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **နမူနာများကို compile နှင့် run လုပ်ပါ**:  
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

## နမူနာများအကြောင်း

နမူနာများကို `examples/` folder အတွင်း အောက်ပါဖွဲ့စည်းမှုဖြင့် စီစဉ်ထားသည်။

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
**File**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`  

Streaming responses နှင့် chat history ကို စီမံခန့်ခွဲခြင်းဖြင့် conversational AI တည်ဆောက်ရန် လေ့လာပါ။

ဒီနမူနာမှာ ပြသထားသည်မှာ -  
- System prompts ဖြင့် ရိုးရှင်းသော text completion  
- History management ဖြင့် multi-turn conversations  
- Interactive chat sessions  
- Parameter configuration (temperature, max tokens)  

### 2. Functions & Plugins with LLMs  
**File**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`  

AI စွမ်းရည်များကို custom functions နှင့် external APIs ဖြင့် တိုးချဲ့ပါ။

ဒီနမူနာမှာ ပြသထားသည်မှာ -  
- မိုးလေဝသ function ကို ပေါင်းစပ်ခြင်း  
- Calculator function ကို အကောင်အထည်ဖော်ခြင်း  
- တစ်ခန်းစကားပြောအတွင်း function calls များစွာကို အသုံးပြုခြင်း  
- JSON schemas ဖြင့် function ကို သတ်မှတ်ခြင်း  

### 3. Retrieval-Augmented Generation (RAG)  
**File**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`  

AI ကို သင့်ကိုယ်ပိုင်စာရွက်များနှင့် data sources များနှင့် ပေါင်းစပ်ပြီး context-aware အဖြေများရရှိရန် လေ့လာပါ။

ဒီနမူနာမှာ ပြသထားသည်မှာ -  
- Azure OpenAI SDK ဖြင့် စာရွက်အခြေခံမေးခွန်းအဖြေ  
- GitHub Models ဖြင့် RAG pattern ကို အကောင်အထည်ဖော်ခြင်း  

**အသုံးပြုမှု**: `document.txt` အတွင်းပါဝင်သော အကြောင်းအရာအပေါ် အခြေခံပြီး မေးခွန်းများမေးပါ၊ AI အဖြေများကို အဲဒီ context အပေါ်သာ အခြေခံ၍ ရရှိပါမည်။

### 4. တာဝန်ရှိသော AI လုံခြုံရေးအတိုင်းအတာများ  
**File**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`  

GitHub Models ၏ content filtering စွမ်းရည်များကို စမ်းသပ်ခြင်းဖြင့် AI လုံခြုံရေးအတိုင်းအတာများကို ကြိုတင်ကြည့်ရှုပါ။

ဒီနမူနာမှာ ပြသထားသည်မှာ -  
- အန္တရာယ်ရှိနိုင်သော prompts များအတွက် content filtering  
- လုံခြုံရေးအဖြေများကို application တွင် စီမံခန့်ခွဲခြင်း  
- Blocked content အမျိုးအစားများ (အကြမ်းဖက်မှု, မုန်းတီးစကား, အချက်အလက်မှား)  
- လုံခြုံရေးချိုးဖောက်မှုများအတွက် error handling  

> **Learn More**: ဒီအခန်းမှာ တာဝန်ရှိသော AI အယူအဆများကို မိတ်ဆက်ပေးထားသည်။ Ethics, bias mitigation, privacy considerations, နှင့် responsible AI frameworks အကြောင်းပိုမိုသိရှိရန် [Chapter 5: Responsible Generative AI](../05-ResponsibleGenAI/README.md) ကို ကြည့်ပါ။

## အကျဉ်းချုပ်

ဒီအခန်းမှာ LLM completions နှင့် chat flows ကို လေ့လာခဲ့ပြီး၊ AI စွမ်းရည်များကို function calling ဖြင့် တိုးချဲ့ခဲ့ပြီး၊ Retrieval-Augmented Generation (RAG) system တည်ဆောက်ခဲ့ပြီး၊ တာဝန်ရှိသော AI လုံခြုံရေးအတိုင်းအတာများကို ပြသခဲ့သည်။

> **NOTE**: ပေးထားသော [**Tutorial**](./TUTORIAL.md) ကို အသုံးပြု၍ ပိုမိုနက်ရှိုင်းစွာ လေ့လာပါ။

## နောက်တစ်ဆင့်

[Chapter 4: Practical Applications & Projects](../04-PracticalSamples/README.md)

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေပါသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်မှုများတွင် အမှားများ သို့မဟုတ် မတိကျမှုများ ပါဝင်နိုင်သည်ကို သတိပြုပါ။ မူရင်းစာရွက်စာတမ်းကို ၎င်း၏ မူရင်းဘာသာစကားဖြင့် အာဏာတရားရှိသော အရင်းအမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များမှ ပရော်ဖက်ရှင်နယ် ဘာသာပြန်မှုကို အကြံပြုပါသည်။ ဤဘာသာပြန်မှုကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအမှားများ သို့မဟုတ် အနားလွဲမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။