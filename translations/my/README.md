# စတင်သွားမည့်သူများအတွက် Generative AI - Java ဗားရှင်း  
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/my/beg-genai-series.8b48be9951cc574c.webp)

**အချိန်ပေးစရာ**: ဒီဝေါ့ခ်ရှော့လုံးဝ အွန်လိုင်းပေါ်မှတစ်ဆင့်ပြီးမြောက်နိုင်ပြီး တစ်ကိုယ်တော်ကွန်ပြူတာဆက်တင်လိုအပ်မှုမရှိပါ။ ပတ်ဝန်းကျင်ပြင်ဆင်ခြင်းအတွက် ၂ မိနစ်ကြာသည့်အထိလိုအပ်ပြီး နမူနာတွေကို သုတေသနလုပ်ရန် အမြင့်ဆုံး ၁-၃ နာရီလိုအပ်နိုင်သည့် အလုပ်အချိန်ပမာဏသည် စူးစမ်းရမည့် အနက်အလိုက် မတူကွဲပြားနိုင်သည်။

> **လျင်မြန်စတင်ခြင်း**

1. ဒီrepository ကို သင့် GitHub အကောင့်သို့ fork လုပ်ပါ
2. **Code** → **Codespaces** tab → **...** → **New with options...** ကိုနှိပ်ပါ
3. ယခင်ပြသထားသည့် Development container ကို ရွေးချယ်ခဲ့သည်ဖြစ်ပါသည်
4. **Create codespace** ကိုနှိပ်ပါ
5. ပတ်ဝန်းကျင် ပြင်ဆင်ခြင်းအတွက် ~၂ မိနစ် စောင့်ဆိုင်းပါ
6. တိုက်ရိုက် [ပထမဥပမာ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) သို့ လိုက်ပါ

> **ကိုယ်ပိုင်စက်တွင် Clone လုပ်ချင်ပါသလား?**
>
> ဒီ repository ထဲမှာ ၅၀+ ဘာသာစကားဘာသာပြန်ချက်တွေ ပါဝင်ပြီး ဒေါင်းလုပ်အရွယ်အစားကို အလွန်မြှင့်တင်ထားသည်။ ဘာသာပြန်ချက်မပါဘဲ clone လုပ်ချင်ရင် sparse checkout ကို သုံးပါ:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> ဒါသည် သင့်အား သင်ခန်းစာကို အမြန်ဆုံးပြီးမြောက်နိုင်စေမည့်အရာအားလုံးကို ပေးပါလိမ့်မယ်။

## ဘာသာစကား မျိုးစုံ ထောက်ခံမှု

### GitHub အက်ရှင်မှ ထောက်ခံခြင်း (အလိုအလျောက်နှင့် အမြဲတမ်း အသစ်နောက်ဆုံးတင်ထားခြင်း)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](./README.md) | [Chinese (Simplified)](../zh-CN/README.md) | [Chinese (Traditional, Hong Kong)](../zh-HK/README.md) | [Chinese (Traditional, Macau)](../zh-MO/README.md) | [Chinese (Traditional, Taiwan)](../zh-TW/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Kannada](../kn/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Malayalam](../ml/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Nigerian Pidgin](../pcm/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../pt-BR/README.md) | [Portuguese (Portugal)](../pt-PT/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Telugu](../te/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)

## သင်ခန်းစာ ဖွဲ့စည်းပုံနှင့် သင်ယူခြင်း လမ်းညွှန်

### **အခန်း ၁: Generative AI ကို နားလည်ခြင်း**
- **အဓိက အယူအဆများ**: မော်ဒယ်ကြီးများ (Large Language Models), token များ, embedding များနှင့် AI ၏စွမ်းဆောင်ရည်များနားလည်ခြင်း
- **Java AI ပတ်ဝန်းကျင်**: Spring AI နှင့် OpenAI SDK များ၏အကျဉ်းချုပ်
- **Model Context Protocol**: MCP ကိုမိတ်ဆက်ခြင်းနှင့် AI agent ဆက်သွယ်ရေးအတွက် အခန်းကဏ္ဍ
- **လက်တွေ့အသုံးချမှုများ**: စကားပြောသူများနှင့် အကြောင်းအရာ ဖန်တီးပုံများပါဝင်သော အမှန်တကယ် အခြေအနေများ
- **[→ အခန်း ၁ စတင်ရန်](./01-IntroToGenAI/README.md)**

### **အခန်း ၂: ဖွံ့ဖြိုးမှု ပတ်ဝန်းကျင် တပ်ဆင်ခြင်း**
- **ပေးသွင်းသူ များစွာအတွက် ကွန်ဖီဂလာရှင်း**: GitHub Models, Azure OpenAI နှင့် OpenAI Java SDK ပေါင်းစပ်ခြင်းတပ်ဆင်ခြင်း
- **Spring Boot + Spring AI**: စီးပွားရေး AI တိုးတက်မှု အတွက် အကောင်းဆုံး ဆောင်ရွက်နည်းများ
- **GitHub Models**: Prototype နှင့် သင်ယူရန် အခမဲ့ AI မော်ဒယ် ဝန်ဆောင်မှု (ကရက်ဒစ်ကတ်မလိုပါ)
- **ဖွံ့ဖြိုးရေး ကိရိယာများ**: Docker container များ, VS Code နှင့် GitHub Codespaces အပြင်အဆင်များ
- **[→ အခန်း ၂ စတင်ရန်](./02-SetupDevEnvironment/README.md)**

### **အခန်း ၃: အဓိက Generative AI နည်းပညာများ**
- **Prompt Engineering**: AI မော်ဒယ်တုံ့ပြန်မှုအတွက် အကောင်းဆုံးနည်းလမ်းများ
- **Embeddings နှင့် Vector Operation များ**: စာအဓိပ္ပာယ် ရှာဖွေရေးနှင့်ဆင်တူမှု တိုက်ဆိုင်မှုများကို တီထွင်ဆောင်ရွက်ခြင်း
- **Retrieval-Augmented Generation (RAG)**: ကိုယ်ပိုင်ဒေတာအရင်းအမြစ်များနှင့် AI ပေါင်းစပ်ခြင်း
- **Function Calling**: AI စွမ်းဆောင်ရည်ကို စိတ်ကြိုက်ကိရိယာများ၊ plugin များဖြင့် တိုးချဲ့ခြင်း
- **[→ အခန်း ၃ စတင်ရန်](./03-CoreGenerativeAITechniques/README.md)**

### **အခန်း ၄: လက်တွေ့အသုံးချမှုနှင့် ပရောဂျက်များ**
- **ခွေးမောင်ဇာတ်လမ်း ထုတ်လုပ်သူ** (`petstory/`): GitHub Models ဖြင့် ဖန်တီးမှု အကြောင်းအရာ ထုတ်လုပ်ခြင်း
- **Foundry Local ဒီမို** (`foundrylocal/`): OpenAI Java SDK နှင့်အတူ ဒေသခံ AI မော်ဒယ် ပေါင်းစပ်ခြင်း
- **MCP ကိန်းဂဏန်း ဝန်ဆောင်မှု** (`calculator/`): Spring AI ဖြင့် Model Context Protocol အခြေခံ ရေးဆွဲမှု
- **[→ အခန်း ၄ စတင်ရန်](./04-PracticalSamples/README.md)**

### **အခန်း ၅: တာဝန်ရှိသော AI ဖွံ့ဖြိုးမှု**
- **GitHub Models လုံခြုံရေး**: အတွင်းက ထည့်သွင်းထားသော အကြောင်းအရာ စစ်ထုတ်ခြင်းနှင့် လုံခြုံရေးမက်ကန်းနစ်များ အား စမ်းသပ်ခြင်း (မှန်ကန်မှုတားဆီးခြင်းနှင့် သဘောတူမညီမှု)
- **တာဝန်ရှိသော AI ဒီမို**: လက်တွေ့နမူနာဖြင့် ခေတ်စစ် AI လုံခြုံရေး စနစ် များ အလုပ်လုပ်ပုံ ဖော်ပြချက်
- **အကောင်းဆုံး ဆောင်ရွက်နည်းများ**: ရိုးသားမှုရှိသော AI ဖန်တီးခြင်းနှင့် တပ်ဆင်ခြင်း ကျင့်ဝတ်အသုံးပြုရန် လမ်းညွှန်ချက်များ
- **[→ အခန်း ၅ စတင်ရန်](./05-ResponsibleGenAI/README.md)**

## အပိုအရင်းအမြစ်များ

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain  
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)  
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)  
[![LangChain for Beginners](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)  
---

### Azure / Edge / MCP / Agents  
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)  

---

### Generative AI Series  
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)  
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)  
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)  

---

### အဓိက သင်ယူမှု  
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)  
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)  
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)  
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Copilot ကြိုးပမ်းမှုများ
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## အကူအညီရယူခြင်း

AI အပလီကေးရှင်းများ ဖန်တီးရာတွင် ရင်ဆိုင်ရသော အခက်အခဲများရှိပါက သို့မဟုတ် မေးခွန်းများရှိပါက MCP နှင့် ပတ်သက်သော ဆွေးနွေးပွဲများတွင် အတူတကွလေ့လာသူများနှင့် အတွေ့အကြုံရှိ ဖွံ့ဖြိုးသူများနှင့် ပူးပေါင်းပါဝင်နိုင်ပါသည်။ ၎င်းသည် မေးခွန်းများကို လက်ခံပြီး အသိပညာများကို အခမဲ့မျှဝေသော ကြိုဆိုဖြစ်သော အသိုင်းအဝိုင်းဖြစ်သည်။

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

ထုတ်ကုန်တုံ့ပြန်ချက်များ သို့မဟုတ် ဘောင်ဆော့ဒ်ဆယ်ရန် အမှားများရှိပါက အောက်ပါနေရာသို့ သွားရောက် စစ်ဆေးပါ။

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**အစီရင်ခံချက်**:
ဤစာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ဖြင့် ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားသည်ဖြစ်သော်လည်း၊ အလိုအလျောက် ဘာသာပြန်ချက်များတွင် အမှားများ သို့မဟုတ် မမှန်ကန်မှုများ ရှိနိုင်ကြောင်း သိရှိထားပေးပါရန် မေတ္တာရပ်ခံအပ်ပါသည်။ မူရင်းစာတမ်းကို မိခင်ဘာသာဖြင့်သာ ယုံကြည်စိတ်ချရသော အကြောင်းအရာအဖြစ် သိထားသင့်ပါသည်။ အရေးပါတဲ့ သတင်းအချက်အလက်များအတွက် မိမိတွင် လုပ်ငန်းကျွမ်းကျင်သော လူ့ဘာသာပြန် ဝန်ဆောင်မှုကို အကြံပြုပါသည်။ ဤဘာသာပြန်ချက်ကို အသုံးပြုခြင်းမှ ဖတ်ရှုသူ မထင်မှတ်ထားသော အနားယူမှုများ သို့မဟုတ် မွန်းမှုများ ဖြစ်ပေါ်ပါက၊ ကျွန်ုပ်တို့ မည်သည့် တာဝန်မရှိပါ။
<!-- CO-OP TRANSLATOR DISCLAIMER END -->