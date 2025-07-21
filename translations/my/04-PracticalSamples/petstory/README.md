<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T21:37:46+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "my"
}
-->
# အိမ်မွေးတိရစ္ဆာန်ပုံပြင် အက်ပ်

>**Note**: ဒီအခန်းမှာ [**လက်တွေ့လေ့ကျင့်မှု**](./TUTORIAL.md) ပါဝင်ပြီး အပြီးသတ်နမူနာများကို အလုပ်လုပ်အောင် လမ်းညွှန်ပေးထားပါတယ်။

GitHub Models ကို အသုံးပြုပြီး တင်ထားသော အိမ်မွေးတိရစ္ဆာန်ပုံများအတွက် AI အားဖြင့် ဖော်ပြချက်များနှင့် ပုံပြင်များ ဖန်တီးပေးသည့် Spring Boot ဝက်ဘ်အက်ပ်လီကေးရှင်းတစ်ခုဖြစ်သည်။

## အကြောင်းအရာများ

- [နည်းပညာစနစ်](../../../../04-PracticalSamples/petstory)
- [လိုအပ်ချက်များ](../../../../04-PracticalSamples/petstory)
- [တပ်ဆင်ခြင်းနှင့် စတင်အသုံးပြုခြင်း](../../../../04-PracticalSamples/petstory)
- [အသုံးပြုနည်း](../../../../04-PracticalSamples/petstory)

## နည်းပညာစနစ်

- **Backend**: Spring Boot 3.5.3, Java 21
- **AI ပေါင်းစည်းမှု**: OpenAI Java SDK နှင့် GitHub Models
- **လုံခြုံရေး**: Spring Security
- **Frontend**: Thymeleaf templates နှင့် Bootstrap အလှဆင်မှု
- **Build Tool**: Maven
- **AI Models**: GitHub Models

## လိုအပ်ချက်များ

- Java 21 သို့မဟုတ် အထက်
- Maven 3.9+
- `models:read` scope ပါဝင်သော GitHub Personal Access Token

## တပ်ဆင်ခြင်းနှင့် စတင်အသုံးပြုခြင်း

### 1. petstory အက်ပ်လီကေးရှင်း ဒိုင်ရက်ထရီသို့ သွားပါ
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. ပတ်ဝန်းကျင် အပြောင်းအလဲ Variable ကို သတ်မှတ်ပါ
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. အက်ပ်လီကေးရှင်းကို Build လုပ်ပါ
```bash
mvn clean compile
```

### 4. အက်ပ်လီကေးရှင်းကို Run လုပ်ပါ
```bash
mvn spring-boot:run
```

## အသုံးပြုနည်း

1. **အက်ပ်ကို ဝင်ရောက်ကြည့်ရှုပါ**: `http://localhost:8080` သို့ သွားပါ
2. **ပုံတင်ပါ**: "Choose File" ကို နှိပ်ပြီး အိမ်မွေးတိရစ္ဆာန်ပုံတစ်ပုံကို ရွေးပါ
3. **ပုံကို ခွဲခြမ်းစိတ်ဖြာပါ**: "Analyze Image" ကို နှိပ်ပြီး AI ဖော်ပြချက်ကို ရယူပါ
4. **ပုံပြင်ဖန်တီးပါ**: "Generate Story" ကို နှိပ်ပြီး ပုံပြင်ကို ဖန်တီးပါ

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်ခြင်းတွင် အမှားများ သို့မဟုတ် မတိကျမှုများ ပါရှိနိုင်သည်ကို သတိပြုပါ။ မူရင်းဘာသာစကားဖြင့် ရေးသားထားသော စာရွက်စာတမ်းကို အာဏာရှိသော ရင်းမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များမှ ပရော်ဖက်ရှင်နယ် ဘာသာပြန်ခြင်းကို အကြံပြုပါသည်။ ဤဘာသာပြန်ကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအလွဲအချော်များ သို့မဟုတ် အနားလွဲမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။