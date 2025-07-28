<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "82ea3c5a1b9d4bf4f1e2d906649e874e",
  "translation_date": "2025-07-28T11:40:47+00:00",
  "source_file": "04-PracticalSamples/calculator/README.md",
  "language_code": "my"
}
-->
# MCP Calculator Tutorial for Beginners

## အကြောင်းအရာများ

- [သင်လေ့လာနိုင်မည့်အရာများ](../../../../04-PracticalSamples/calculator)
- [လိုအပ်ချက်များ](../../../../04-PracticalSamples/calculator)
- [ပရောဂျက်ဖွဲ့စည်းမှုကိုနားလည်ခြင်း](../../../../04-PracticalSamples/calculator)
- [အဓိကအစိတ်အပိုင်းများရှင်းပြချက်](../../../../04-PracticalSamples/calculator)
  - [၁။ အဓိကအက်ပ်ပလီကေးရှင်း](../../../../04-PracticalSamples/calculator)
  - [၂။ ကိန်းဂဏန်းဆိုင်ရာဝန်ဆောင်မှု](../../../../04-PracticalSamples/calculator)
  - [၃။ တိုက်ရိုက် MCP Client](../../../../04-PracticalSamples/calculator)
  - [၄။ AI အားဖြင့်အင်အားဖြည့်ထားသော Client](../../../../04-PracticalSamples/calculator)
- [ဥပမာများကိုအလုပ်လုပ်စေခြင်း](../../../../04-PracticalSamples/calculator)
- [အားလုံးပေါင်းစည်းပြီးအလုပ်လုပ်ပုံ](../../../../04-PracticalSamples/calculator)
- [နောက်တစ်ဆင့်များ](../../../../04-PracticalSamples/calculator)

## သင်လေ့လာနိုင်မည့်အရာများ

ဒီသင်ခန်းစာမှာ Model Context Protocol (MCP) ကိုအသုံးပြုပြီး ကိန်းဂဏန်းဆိုင်ရာဝန်ဆောင်မှုတစ်ခုကို ဘယ်လိုတည်ဆောက်ရမလဲဆိုတာရှင်းပြထားပါတယ်။ သင်နားလည်နိုင်မယ့်အရာများမှာ:

- AI သုံးပြီး tools အနေနဲ့ အသုံးပြုနိုင်မယ့် ဝန်ဆောင်မှုတစ်ခုကို ဘယ်လိုဖန်တီးရမလဲ
- MCP ဝန်ဆောင်မှုများနှင့် တိုက်ရိုက်ဆက်သွယ်ပုံ
- AI မော်ဒယ်များက ဘယ်လို tools ကိုအလိုအလျောက်ရွေးချယ်နိုင်သလဲ
- တိုက်ရိုက် protocol ခေါ်ဆိုမှုများနှင့် AI အကူအညီဖြင့်လုပ်ဆောင်မှုများအကြားကွာခြားချက်

## လိုအပ်ချက်များ

စတင်မတိုင်မီ သင်မှာအောက်ပါအရာများရှိရမည်:

- Java 21 သို့မဟုတ် အထက်ရှိထားရမည်
- Maven ကို dependency များစီမံခန့်ခွဲရန်
- GitHub အကောင့်နှင့် personal access token (PAT)
- Java နှင့် Spring Boot အခြေခံအကြောင်းအရာများကို နားလည်ထားရမည်

## ပရောဂျက်ဖွဲ့စည်းမှုကိုနားလည်ခြင်း

ကိန်းဂဏန်းဆိုင်ရာပရောဂျက်တွင် အရေးကြီးသောဖိုင်များအချို့ပါဝင်သည်:

```
calculator/
├── src/main/java/com/microsoft/mcp/sample/server/
│   ├── McpServerApplication.java          # Main Spring Boot app
│   └── service/CalculatorService.java     # Calculator operations
└── src/test/java/com/microsoft/mcp/sample/client/
    ├── SDKClient.java                     # Direct MCP communication
    ├── LangChain4jClient.java            # AI-powered client
    └── Bot.java                          # Simple chat interface
```

## အဓိကအစိတ်အပိုင်းများရှင်းပြချက်

### ၁။ အဓိကအက်ပ်ပလီကေးရှင်း

**ဖိုင်:** `McpServerApplication.java`

ဒီဖိုင်က ကျွန်တော်တို့ရဲ့ ကိန်းဂဏန်းဝန်ဆောင်မှုရဲ့ အဓိကစတင်မှုအချက်ဖြစ်ပါတယ်။ ဒါဟာ Spring Boot အက်ပ်ပလီကေးရှင်းတစ်ခုဖြစ်ပြီး အထူးအပိုဆောင်းတစ်ခုပါဝင်ပါတယ်:

```java
@SpringBootApplication
public class McpServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpServerApplication.class, args);
    }
    
    @Bean
    public ToolCallbackProvider calculatorTools(CalculatorService calculator) {
        return MethodToolCallbackProvider.builder().toolObjects(calculator).build();
    }
}
```

**ဒါကဘာလုပ်သလဲဆိုရင်:**
- Spring Boot web server ကို port 8080 မှာစတင်ပေးတယ်
- `ToolCallbackProvider` တစ်ခုဖန်တီးပြီး ကိန်းဂဏန်းဆိုင်ရာနည်းလမ်းများကို MCP tools အနေနဲ့ အသုံးပြုနိုင်အောင်လုပ်ပေးတယ်
- `@Bean` annotation က Spring ကို ဒီ component ကို အခြားအစိတ်အပိုင်းများအသုံးပြုနိုင်အောင် စီမံခန့်ခွဲပေးတယ်

### ၂။ ကိန်းဂဏန်းဆိုင်ရာဝန်ဆောင်မှု

**ဖိုင်:** `CalculatorService.java`

ဒီနေရာမှာ ကိန်းဂဏန်းဆိုင်ရာ လုပ်ဆောင်မှုအားလုံးကို ပြုလုပ်ပါတယ်။ နည်းလမ်းတစ်ခုစီမှာ `@Tool` annotation ပါဝင်ပြီး MCP မှတစ်ဆင့်ခေါ်နိုင်အောင်လုပ်ထားပါတယ်:

```java
@Service
public class CalculatorService {

    @Tool(description = "Add two numbers together")
    public String add(double a, double b) {
        double result = a + b;
        return formatResult(a, "+", b, result);
    }

    @Tool(description = "Subtract the second number from the first number")
    public String subtract(double a, double b) {
        double result = a - b;
        return formatResult(a, "-", b, result);
    }
    
    // More calculator operations...
    
    private String formatResult(double a, String operator, double b, double result) {
        return String.format("%.2f %s %.2f = %.2f", a, operator, b, result);
    }
}
```

**အဓိကအချက်များ:**

1. **`@Tool` Annotation**: ဒီနည်းလမ်းကို ပြင်ပ client များခေါ်နိုင်အောင် MCP ကိုပြောပြတယ်
2. **ရှင်းလင်းသောဖော်ပြချက်များ**: tool တစ်ခုစီမှာ AI မော်ဒယ်များအတွက် အသုံးဝင်မှုကို နားလည်စေဖို့ ဖော်ပြချက်ပါဝင်တယ်
3. **အမြဲတန်းတူညီသော ပြန်လည်ပေးပို့မှုဖော်မတ်**: လုပ်ဆောင်မှုအားလုံးက "5.00 + 3.00 = 8.00" လိုမျိုး လူနားလည်နိုင်တဲ့ string များကို ပြန်ပေးတယ်
4. **အမှားကိုင်တွယ်မှု**: သုညဖြင့်စားခြင်းနှင့် အနုတ်စရိုက်အမြစ်ခေါင်းများကို error message ပြန်ပေးတယ်

**ရရှိနိုင်သောလုပ်ဆောင်မှုများ:**
- `add(a, b)` - နံပါတ်နှစ်ခုကိုပေါင်းသည်
- `subtract(a, b)` - ပထမနံပါတ်မှ ဒုတိယနံပါတ်ကိုနှုတ်သည်
- `multiply(a, b)` - နံပါတ်နှစ်ခုကိုမြှောက်သည်
- `divide(a, b)` - ပထမနံပါတ်ကို ဒုတိယနံပါတ်ဖြင့်စားသည် (သုညစစ်ဆေးမှုပါဝင်သည်)
- `power(base, exponent)` - base ကို exponent အားဖြင့်မြှောက်သည်
- `squareRoot(number)` - အမြစ်ခေါင်းတွက်ချက်သည် (အနုတ်စစ်ဆေးမှုပါဝင်သည်)
- `modulus(a, b)` - စားခြင်းမှကျန်ရှိသောအပိုင်းကိုပြန်ပေးသည်
- `absolute(number)` - အပြည့်အဝတန်ဖိုးကိုပြန်ပေးသည်
- `help()` - လုပ်ဆောင်မှုအားလုံးအကြောင်းအရာကိုပြန်ပေးသည်

### ၃။ တိုက်ရိုက် MCP Client

**ဖိုင်:** `SDKClient.java`

ဒီ client က AI မသုံးဘဲ MCP server နဲ့တိုက်ရိုက်ပြောဆိုပါတယ်။ သတ်မှတ်ထားတဲ့ ကိန်းဂဏန်းလုပ်ဆောင်မှုများကို လက်နက်ကိုင်ခေါ်ဆိုပါတယ်:

```java
public class SDKClient {
    
    public static void main(String[] args) {
        var transport = new WebFluxSseClientTransport(
            WebClient.builder().baseUrl("http://localhost:8080")
        );
        new SDKClient(transport).run();
    }
    
    public void run() {
        var client = McpClient.sync(this.transport).build();
        client.initialize();
        
        // List available tools
        ListToolsResult toolsList = client.listTools();
        System.out.println("Available Tools = " + toolsList);
        
        // Call specific calculator functions
        CallToolResult resultAdd = client.callTool(
            new CallToolRequest("add", Map.of("a", 5.0, "b", 3.0))
        );
        System.out.println("Add Result = " + resultAdd);
        
        CallToolResult resultSqrt = client.callTool(
            new CallToolRequest("squareRoot", Map.of("number", 16.0))
        );
        System.out.println("Square Root Result = " + resultSqrt);
        
        client.closeGracefully();
    }
}
```

**ဒါကဘာလုပ်သလဲဆိုရင်:**
1. **ဆက်သွယ်သည်**: `http://localhost:8080` မှာရှိတဲ့ ကိန်းဂဏန်း server နဲ့ဆက်သွယ်တယ်
2. **စာရင်းပြုစုသည်**: ရရှိနိုင်တဲ့ tools (ကိန်းဂဏန်းလုပ်ဆောင်မှုများ) အားလုံးကိုစာရင်းပြုစုတယ်
3. **ခေါ်ဆိုသည်**: သတ်မှတ်ထားတဲ့ parameters နဲ့အတူ လုပ်ဆောင်မှုများကိုခေါ်ဆိုတယ်
4. **ရလဒ်များကိုပုံနှိပ်သည်**: ရလဒ်များကိုတိုက်ရိုက်ပြသတယ်

**ဘယ်အချိန်မှာသုံးမလဲ:** သင်ဘယ်လုပ်ဆောင်မှုကိုလုပ်ချင်တယ်ဆိုတာသိပြီး programmatically ခေါ်ဆိုချင်တဲ့အချိန်

### ၄။ AI အားဖြင့်အင်အားဖြည့်ထားသော Client

**ဖိုင်:** `LangChain4jClient.java`

ဒီ client က AI မော်ဒယ် (GPT-4o-mini) ကိုအသုံးပြုပြီး ကိန်းဂဏန်း tools များကိုအလိုအလျောက်ရွေးချယ်နိုင်ပါတယ်:

```java
public class LangChain4jClient {
    
    public static void main(String[] args) throws Exception {
        // Set up the AI model (using GitHub Models)
        ChatLanguageModel model = OpenAiOfficialChatModel.builder()
                .isGitHubModels(true)
                .apiKey(System.getenv("GITHUB_TOKEN"))
                .modelName("gpt-4o-mini")
                .build();

        // Connect to our calculator MCP server
        McpTransport transport = new HttpMcpTransport.Builder()
                .sseUrl("http://localhost:8080/sse")
                .logRequests(true)  // Shows what the AI is doing
                .logResponses(true)
                .build();

        McpClient mcpClient = new DefaultMcpClient.Builder()
                .transport(transport)
                .build();

        // Give the AI access to our calculator tools
        ToolProvider toolProvider = McpToolProvider.builder()
                .mcpClients(List.of(mcpClient))
                .build();

        // Create an AI bot that can use our calculator
        Bot bot = AiServices.builder(Bot.class)
                .chatLanguageModel(model)
                .toolProvider(toolProvider)
                .build();

        // Now we can ask the AI to do calculations in natural language
        String response = bot.chat("Calculate the sum of 24.5 and 17.3 using the calculator service");
        System.out.println(response);

        response = bot.chat("What's the square root of 144?");
        System.out.println(response);
    }
}
```

**ဒါကဘာလုပ်သလဲဆိုရင်:**
1. **AI မော်ဒယ်ဆက်သွယ်မှု** ကို GitHub token အသုံးပြုပြီးဖန်တီးတယ်
2. **AI ကို MCP server နဲ့ဆက်သွယ်ပေးတယ်**
3. **AI ကို ကိန်းဂဏန်း tools အားလုံးကိုအသုံးပြုခွင့်ပေးတယ်**
4. **သဘာဝဘာသာစကားတောင်းဆိုမှုများကို ခွင့်ပြုတယ်** (ဥပမာ - "24.5 နဲ့ 17.3 ကိုပေါင်းပေးပါ")

**AI အလိုအလျောက်:**
- သင်ပေါင်းချင်တယ်ဆိုတာနားလည်တယ်
- `add` tool ကိုရွေးတယ်
- `add(24.5, 17.3)` ကိုခေါ်တယ်
- ရလဒ်ကို သဘာဝဘာသာစကားဖြင့်ပြန်ပေးတယ်

## ဥပမာများကိုအလုပ်လုပ်စေခြင်း

### အဆင့် ၁: ကိန်းဂဏန်း Server ကိုစတင်ပါ

ပထမဦးစွာ GitHub token ကိုသတ်မှတ်ပါ (AI client အတွက်လိုအပ်သည်):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

Server ကိုစတင်ပါ:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

Server က `http://localhost:8080` မှာစတင်ပါလိမ့်မယ်။ သင်ကြည့်ရမည့်အရာ:
```
Started McpServerApplication in X.XXX seconds
```

### အဆင့် ၂: တိုက်ရိုက် Client နဲ့စမ်းသပ်ပါ

Server ကိုအလုပ်လုပ်နေစဉ် **အသစ်သော** terminal တစ်ခုမှာ တိုက်ရိုက် MCP client ကို run ပါ:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

သင်ကြည့်ရမည့် output:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### အဆင့် ၃: AI Client နဲ့စမ်းသပ်ပါ

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

AI က tools များကိုအလိုအလျောက်အသုံးပြုနေသည်ကိုသင်ကြည့်ရမည်:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### အဆင့် ၄: MCP Server ကိုပိတ်ပါ

စမ်းသပ်မှုပြီးဆုံးပါက AI client ကို `Ctrl+C` နှိပ်ပြီးပိတ်နိုင်ပါတယ်။ MCP server က သင်ပိတ်မချင်းအလုပ်လုပ်နေပါလိမ့်မယ်။
Server ကိုပိတ်ရန်၊ server ရှိ terminal မှာ `Ctrl+C` ကိုနှိပ်ပါ။

## အားလုံးပေါင်းစည်းပြီးအလုပ်လုပ်ပုံ

သင် AI ကို "5 နဲ့ 3 ကိုပေါင်းရင်ဘယ်လောက်လဲ?" လို့မေးတဲ့အခါ အလုပ်လုပ်ပုံက:

1. **သင်** AI ကို သဘာဝဘာသာစကားနဲ့မေးတယ်
2. **AI** သင့်တောင်းဆိုမှုကိုခွဲခြမ်းစိတ်ဖြာပြီး ပေါင်းချင်တယ်ဆိုတာနားလည်တယ်
3. **AI** MCP server ကိုခေါ်တယ်: `add(5.0, 3.0)`
4. **ကိန်းဂဏန်းဝန်ဆောင်မှု** က `5.0 + 3.0 = 8.0` ကိုတွက်ချက်တယ်
5. **ကိန်းဂဏန်းဝန်ဆောင်မှု** က `"5.00 + 3.00 = 8.00"` ကိုပြန်ပေးတယ်
6. **AI** ရလဒ်ကိုလက်ခံပြီး သဘာဝဘာသာစကားဖြင့်ပြန်တယ်
7. **သင်** "5 နဲ့ 3 ကိုပေါင်းရင် 8 ဖြစ်တယ်" ဆိုတဲ့အဖြေကိုရတယ်

## နောက်တစ်ဆင့်များ

နောက်ထပ်ဥပမာများအတွက် [Chapter 04: Practical samples](../README.md) ကိုကြည့်ပါ

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်မှုများတွင် အမှားများ သို့မဟုတ် မမှန်ကန်မှုများ ပါရှိနိုင်သည်ကို သတိပြုပါ။ မူရင်းဘာသာစကားဖြင့် ရေးသားထားသော စာရွက်စာတမ်းကို အာဏာတရ အရင်းအမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များမှ ပရော်ဖက်ရှင်နယ် ဘာသာပြန်မှုကို အကြံပြုပါသည်။ ဤဘာသာပြန်မှုကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအလွဲအချော်များ သို့မဟုတ် အနားလွဲမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။