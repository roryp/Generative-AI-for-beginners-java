<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "7bf9a4a832911269a8bd0decb97ff36c",
  "translation_date": "2025-07-21T21:30:02+00:00",
  "source_file": "04-PracticalSamples/mcp/calculator/README.md",
  "language_code": "my"
}
-->
# အခြေခံ ကိန်းဂဏန်းတွက်ချက်မှု MCP ဝန်ဆောင်မှု

>**Note**: ဒီအခန်းမှာ [**Tutorial**](./TUTORIAL.md) ပါဝင်ပြီး အဆင့်မြင့်နမူနာများကို အကောင်အထည်ဖော်ရန် လမ်းညွှန်ပေးထားပါတယ်။

**Model Context Protocol (MCP)** ကို လက်တွေ့ကျကျ အသုံးပြုနိုင်ဖို့ ကြိုဆိုပါတယ်! အရင်အခန်းတွေမှာ Generative AI အခြေခံအကြောင်းအရာတွေကို လေ့လာပြီး Development Environment ကို ပြင်ဆင်ပြီးသားဖြစ်ပါတယ်။ အခုတော့ လက်တွေ့အသုံးချနိုင်တဲ့ အရာတစ်ခုကို တည်ဆောက်ဖို့ အချိန်ရောက်ပါပြီ။

ဒီကိန်းဂဏန်းတွက်ချက်မှုဝန်ဆောင်မှုက AI မော်ဒယ်တွေ MCP ကို အသုံးပြုပြီး အပြင်ပန်းကိရိယာတွေနဲ့ လုံခြုံစွာ ဆက်သွယ်နိုင်ပုံကို ပြသထားပါတယ်။ AI မော်ဒယ်ရဲ့ တစ်ခါတစ်လေ မမှန်ကန်တဲ့ သင်္ချာတွက်ချက်မှုစွမ်းရည်ကို မူတည်မထားဘဲ၊ AI က အတိအကျတွက်ချက်နိုင်တဲ့ ဝန်ဆောင်မှုတွေကို ခေါ်ယူနိုင်တဲ့ စနစ်တစ်ခုကို တည်ဆောက်ပုံကို ပြသပေးမှာဖြစ်ပါတယ်။

## အကြောင်းအရာများ

- [သင်လေ့လာနိုင်မည့်အရာများ](../../../../../04-PracticalSamples/mcp/calculator)
- [လိုအပ်ချက်များ](../../../../../04-PracticalSamples/mcp/calculator)
- [အဓိကအကြောင်းအရာများ](../../../../../04-PracticalSamples/mcp/calculator)
- [အမြန်စတင်ခြင်း](../../../../../04-PracticalSamples/mcp/calculator)
- [ရရှိနိုင်သော ကိန်းဂဏန်းတွက်ချက်မှုများ](../../../../../04-PracticalSamples/mcp/calculator)
- [စမ်းသပ်ရန် Client များ](../../../../../04-PracticalSamples/mcp/calculator)
  - [1. Direct MCP Client (SDKClient)](../../../../../04-PracticalSamples/mcp/calculator)
  - [2. AI-Powered Client (LangChain4jClient)](../../../../../04-PracticalSamples/mcp/calculator)
- [MCP Inspector (Web UI)](../../../../../04-PracticalSamples/mcp/calculator)
  - [အဆင့်ဆင့် လမ်းညွှန်ချက်များ](../../../../../04-PracticalSamples/mcp/calculator)

## သင်လေ့လာနိုင်မည့်အရာများ

ဒီနမူနာကို လေ့လာပြီးနောက်မှာ သင်နားလည်နိုင်မည့်အရာများ:
- Spring Boot ကို အသုံးပြုပြီး MCP-Compatible ဝန်ဆောင်မှုများကို ဘယ်လိုဖန်တီးရမလဲ
- Direct Protocol ဆက်သွယ်မှုနဲ့ AI-Powered ဆက်သွယ်မှုကြားက ကွာခြားချက်
- AI မော်ဒယ်တွေ ဘယ်အချိန်မှာ ဘယ်လို အပြင်ပန်းကိရိယာတွေကို အသုံးပြုရမလဲဆိုတာ ဆုံးဖြတ်ပုံ
- Tool-Enabled AI Applications တည်ဆောက်ရာမှာ အကောင်းဆုံး လုပ်ဆောင်မှုများ

MCP အကြောင်းအရာများကို စတင်လေ့လာနေတဲ့ Beginner များအတွက် အထူးသင့်လျော်ပြီး AI Tool Integration ကို စတင်တည်ဆောက်ဖို့ အသင့်ဖြစ်စေပါမယ်!

## လိုအပ်ချက်များ

- Java 21+
- Maven 3.6+
- **GitHub Token**: AI-Powered Client အတွက် လိုအပ်ပါတယ်။ သင်ဤအရာကို မပြင်ဆင်ရသေးပါက [Chapter 2: Development Environment ကို ပြင်ဆင်ခြင်း](../../../02-SetupDevEnvironment/README.md) ကို ကြည့်ပါ။

## အဓိကအကြောင်းအရာများ

**Model Context Protocol (MCP)** က AI Applications တွေကို အပြင်ပန်းကိရိယာတွေနဲ့ လုံခြုံစွာ ဆက်သွယ်နိုင်စေတဲ့ စံသတ်မှတ်တစ်ခုဖြစ်ပါတယ်။ AI မော်ဒယ်တွေက သင်္ချာတွက်ချက်မှုကို ကိုယ်တိုင်လုပ်ဆောင်ဖို့ (တစ်ခါတစ်လေ မမှန်ကန်နိုင်ပါတယ်) မလိုအပ်ဘဲ၊ ကျွန်တော်တို့ရဲ့ Calculator Service ကို ခေါ်ယူပြီး အတိအကျရလဒ်တွေကို ရယူနိုင်ပါတယ်။ MCP က ဒီဆက်သွယ်မှုကို လုံခြုံစွာနဲ့ စနစ်တကျ ဖြစ်စေပါတယ်။

**Server-Sent Events (SSE)** က Server နဲ့ Client တွေကြား Real-Time ဆက်သွယ်မှုကို အကောင်းဆုံးဖြစ်စေပါတယ်။ Traditional HTTP Request တွေမှာ တစ်ခါတစ်ရံ အဖြေကို စောင့်ရတတ်ပေမယ့် SSE က Server ကနေ Client ကို အဆက်မပြတ် Update တွေ ပေးနိုင်စေပါတယ်။ AI Applications တွေမှာ Response တွေကို Streaming လုပ်တာမျိုး သို့မဟုတ် အချိန်ယူပြီး Process လုပ်တာမျိုးတွေအတွက် အထူးသင့်လျော်ပါတယ်။

**AI Tools & Function Calling** က AI မော်ဒယ်တွေကို အပြင်ပန်း Function တွေကို အလိုအလျောက် ရွေးချယ်ပြီး အသုံးပြုနိုင်စေပါတယ်။ "15 + 27 ဘယ်လောက်လဲ?" လို့ မေးတဲ့အခါ AI မော်ဒယ်က Addition လုပ်ဖို့လိုတယ်ဆိုတာ နားလည်ပြီး `add` tool ကို Parameter (15, 27) တွေဖြင့် ခေါ်ယူပြီး Natural Language ဖြင့် အဖြေကို ပြန်ပေးနိုင်ပါတယ်။ AI က Intelligent Coordinator အနေနဲ့ Tool တစ်ခုချင်းစီကို ဘယ်အချိန်မှာ ဘယ်လို အသုံးပြုရမလဲဆိုတာ သိထားပါတယ်။

## အမြန်စတင်ခြင်း

### 1. Calculator Application Directory ကို သွားပါ
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/mcp/calculator
```

### 2. Build & Run
```bash
mvn clean install -DskipTests
java -jar target/calculator-server-0.0.1-SNAPSHOT.jar
```

### 2. Client များဖြင့် စမ်းသပ်ပါ
- **SDKClient**: Direct MCP Protocol Interaction
- **LangChain4jClient**: AI-Powered Natural Language Interaction (GitHub Token လိုအပ်ပါတယ်)

## ရရှိနိုင်သော ကိန်းဂဏန်းတွက်ချက်မှုများ

- `add(a, b)`, `subtract(a, b)`, `multiply(a, b)`, `divide(a, b)`
- `power(base, exponent)`, `squareRoot(number)`, `absolute(number)`
- `modulus(a, b)`, `help()`

## စမ်းသပ်ရန် Client များ

### 1. Direct MCP Client (SDKClient)
Raw MCP Protocol ဆက်သွယ်မှုကို စမ်းသပ်ပါ။ Run:
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

### 2. AI-Powered Client (LangChain4jClient)
GitHub Models နဲ့ Natural Language Interaction ကို ပြသထားပါတယ်။ GitHub Token လိုအပ်ပါတယ် ([Prerequisites](../../../../../04-PracticalSamples/mcp/calculator) ကို ကြည့်ပါ)။

**Run:**
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

## MCP Inspector (Web UI)

MCP Inspector က Code မရေးဘဲ MCP Service ကို စမ်းသပ်နိုင်တဲ့ Visual Web Interface တစ်ခုဖြစ်ပါတယ်။ MCP ဘယ်လိုအလုပ်လုပ်တယ်ဆိုတာ နားလည်ဖို့ Beginner များအတွက် အထူးသင့်လျော်ပါတယ်။

### အဆင့်ဆင့် လမ်းညွှန်ချက်များ:

1. **Calculator Server ကို စတင်ပါ** (မစတင်ရသေးပါက):
   ```bash
   java -jar target/calculator-server-0.0.1-SNAPSHOT.jar
   ```

2. **MCP Inspector ကို Terminal အသစ်မှာ Install နဲ့ Run လုပ်ပါ**:
   ```bash
   npx @modelcontextprotocol/inspector
   ```

3. **Web Interface ကို ဖွင့်ပါ**:
   - "Inspector running at http://localhost:6274" ဆိုတဲ့ Message ကို ရှာပါ
   - အဲဒီ URL ကို Web Browser မှာ ဖွင့်ပါ

4. **Calculator Service ကို Connect လုပ်ပါ**:
   - Web Interface မှာ Transport Type ကို "SSE" အဖြစ် သတ်မှတ်ပါ
   - URL ကို `http://localhost:8080/sse` အဖြစ် သတ်မှတ်ပါ
   - "Connect" Button ကို Click လုပ်ပါ

5. **ရရှိနိုင်သော Tools တွေကို Explore လုပ်ပါ**:
   - "List Tools" ကို Click လုပ်ပြီး Calculator Operations တွေကို ကြည့်ပါ
   - `add`, `subtract`, `multiply` စတဲ့ Function တွေကို တွေ့ပါလိမ့်မယ်

6. **Calculator Operation တစ်ခုကို စမ်းသပ်ပါ**:
   - Tool တစ်ခု (ဥပမာ - "add") ကို ရွေးပါ
   - Parameters (ဥပမာ - `a: 15`, `b: 27`) ကို ထည့်ပါ
   - "Run Tool" ကို Click လုပ်ပါ
   - MCP Service က ပြန်ပေးတဲ့ Result ကို ကြည့်ပါ!

ဒီ Visual Approach က MCP Communication ဘယ်လိုအလုပ်လုပ်တယ်ဆိုတာ သင်နားလည်စေပြီး ကိုယ်ပိုင် Client တွေကို တည်ဆောက်ဖို့ အဆင့်မြှင့်စေပါတယ်။

![npx inspector](../../../../../translated_images/tool.214c70103694335c4cfdc2d624373dfce4b0162f6aea089ac1da9051fb563b7f.my.png)

---
**Reference:** [MCP Server Boot Starter Docs](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-server-boot-starter-docs.html)

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်ခြင်းတွင် အမှားများ သို့မဟုတ် မတိကျမှုများ ပါဝင်နိုင်သည်ကို သတိပြုပါ။ မူရင်းဘာသာစကားဖြင့် ရေးသားထားသော စာရွက်စာတမ်းကို အာဏာတရ အရင်းအမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူက ဘာသာပြန်ခြင်းကို အကြံပြုပါသည်။ ဤဘာသာပြန်ကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအလွဲအချော်များ သို့မဟုတ် အနားယူမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။