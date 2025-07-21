<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "8c6c7e9008b114540677f7a65aa9ddad",
  "translation_date": "2025-07-21T21:35:05+00:00",
  "source_file": "04-PracticalSamples/mcp/calculator/TUTORIAL.md",
  "language_code": "my"
}
-->
# MCP Calculator Tutorial for Beginners

## အကြောင်းအရာများ

- [သင်လေ့လာမည့်အရာများ](../../../../../04-PracticalSamples/mcp/calculator)
- [လိုအပ်ချက်များ](../../../../../04-PracticalSamples/mcp/calculator)
- [ပရောဂျက်ဖွဲ့စည်းမှုကိုနားလည်ခြင်း](../../../../../04-PracticalSamples/mcp/calculator)
- [အဓိကအစိတ်အပိုင်းများရှင်းပြချက်](../../../../../04-PracticalSamples/mcp/calculator)
  - [1. အဓိကအပလီကေးရှင်း](../../../../../04-PracticalSamples/mcp/calculator)
  - [2. ကိန်းဂဏန်းတွက်ချက်မှုဝန်ဆောင်မှု](../../../../../04-PracticalSamples/mcp/calculator)
  - [3. တိုက်ရိုက် MCP Client](../../../../../04-PracticalSamples/mcp/calculator)
  - [4. AI အခြေခံ Client](../../../../../04-PracticalSamples/mcp/calculator)
- [ဥပမာများကိုအလုပ်လုပ်စေခြင်း](../../../../../04-PracticalSamples/mcp/calculator)
- [အားလုံးပေါင်းစည်းပြီးအလုပ်လုပ်ပုံ](../../../../../04-PracticalSamples/mcp/calculator)
- [နောက်တစ်ဆင့်များ](../../../../../04-PracticalSamples/mcp/calculator)

## သင်လေ့လာမည့်အရာများ

ဒီသင်ခန်းစာမှာ Model Context Protocol (MCP) ကိုအသုံးပြုပြီး ကိန်းဂဏန်းတွက်ချက်မှုဝန်ဆောင်မှုတစ်ခုကို ဘယ်လိုတည်ဆောက်ရမယ်ဆိုတာရှင်းပြထားပါတယ်။ သင်နားလည်နိုင်မယ့်အရာများမှာ:

- AI သုံးပြီး ကိန်းဂဏန်းတွက်ချက်မှုဝန်ဆောင်မှုတစ်ခုကို ဘယ်လိုဖန်တီးရမလဲ
- MCP ဝန်ဆောင်မှုများနှင့် တိုက်ရိုက်ဆက်သွယ်ပုံ
- AI မော်ဒယ်များက ဘယ်လို tools များကို အလိုအလျောက်ရွေးချယ်နိုင်သလဲ
- တိုက်ရိုက် protocol ခေါ်ဆိုမှုများနဲ့ AI အကူအညီ interactions အကြားကွာခြားချက်

## လိုအပ်ချက်များ

စတင်မီ သင်မှာအောက်ပါအရာများရှိရမည်:

- Java 21 သို့မဟုတ် အထက် version တင်ထားခြင်း
- Maven ကို dependency management အတွက်အသုံးပြုခြင်း
- GitHub အကောင့်နှင့် personal access token (PAT)
- Java နဲ့ Spring Boot အခြေခံနားလည်မှု

## ပရောဂျက်ဖွဲ့စည်းမှုကိုနားလည်ခြင်း

ဒီကိန်းဂဏန်းတွက်ချက်မှုပရောဂျက်မှာ အရေးကြီးတဲ့ဖိုင်အချို့ပါဝင်ပါတယ်:

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

### 1. အဓိကအပလီကေးရှင်း

**ဖိုင်:** `McpServerApplication.java`

ဒီဟာက ကျွန်တော်တို့ရဲ့ ကိန်းဂဏန်းတွက်ချက်မှုဝန်ဆောင်မှုရဲ့ အဓိကစတင်မှုနေရာဖြစ်ပါတယ်။ ဒါဟာ ပုံမှန် Spring Boot အပလီကေးရှင်းတစ်ခုဖြစ်ပြီး အထူးအပိုဆောင်းတစ်ခုပါဝင်ပါတယ်:

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

**ဒါဘာလုပ်သလဲ:**
- Spring Boot web server ကို port 8080 မှာစတင်ပေးတယ်
- `ToolCallbackProvider` တစ်ခုဖန်တီးပြီး ကျွန်တော်တို့ရဲ့ ကိန်းဂဏန်းတွက်ချက်မှုနည်းလမ်းတွေကို MCP tools အဖြစ်အသုံးပြုနိုင်အောင်လုပ်ပေးတယ်
- `@Bean` annotation က Spring ကို ဒီဟာကို အခြားအစိတ်အပိုင်းတွေသုံးနိုင်တဲ့ component အဖြစ်စီမံခန့်ခွဲပေးဖို့ပြောပါတယ်

### 2. ကိန်းဂဏန်းတွက်ချက်မှုဝန်ဆောင်မှု

**ဖိုင်:** `CalculatorService.java`

ဒီနေရာမှာပဲ ကိန်းဂဏန်းတွက်ချက်မှုတွေကိုလုပ်ဆောင်ပါတယ်။ နည်းလမ်းတစ်ခုချင်းစီကို `@Tool` နဲ့အမှတ်အသားပြုထားပြီး MCP မှတစ်ဆင့်ခေါ်နိုင်အောင်လုပ်ထားပါတယ်:

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

**အဓိကအင်္ဂါရပ်များ:**

1. **`@Tool` Annotation**: ဒီဟာက MCP ကို ဒီနည်းလမ်းကို ပြင်ပ client တွေခေါ်နိုင်တယ်လို့ပြောပါတယ်
2. **ရှင်းလင်းတဲ့ဖော်ပြချက်များ**: Tool တစ်ခုချင်းစီမှာ AI မော်ဒယ်တွေ ဘယ်အချိန်မှာသုံးရမယ်ဆိုတာနားလည်နိုင်အောင်ဖော်ပြချက်ပါဝင်တယ်
3. **အမြဲတန်းတူညီတဲ့ပြန်လည်ပေးပို့မှုဖော်မတ်**: အားလုံးက "5.00 + 3.00 = 8.00" လို လူနားလည်နိုင်တဲ့ string အဖြစ်ပြန်ပေးတယ်
4. **အမှားကိုင်တွယ်မှု**: သုညဖြင့်စားခြင်းနဲ့ အနုတ်စရိုက်အမြစ်တုတ်တွက်ချက်မှုတွေမှာ error message ပြန်ပေးတယ်

**ရရှိနိုင်တဲ့လုပ်ဆောင်ချက်များ:**
- `add(a, b)` - ကိန်းနှစ်ခုကိုပေါင်း
- `subtract(a, b)` - ဒုတိယကိန်းကို ပထမကိန်းကနုတ်
- `multiply(a, b)` - ကိန်းနှစ်ခုကိုမြှောက်
- `divide(a, b)` - ပထမကိန်းကို ဒုတိယကိန်းနဲ့စား (သုညစစ်ဆေးမှုပါဝင်)
- `power(base, exponent)` - base ကို exponent အတိုင်းမြှောက်
- `squareRoot(number)` - အမြစ်တုတ်တွက်ချက် (အနုတ်စရိုက်စစ်ဆေးမှုပါဝင်)
- `modulus(a, b)` - စားခြင်းအကြွင်း
- `absolute(number)` - အပြည့်တန်ဖိုး
- `help()` - လုပ်ဆောင်ချက်အားလုံးအကြောင်းအရာပြန်ပေး

### 3. တိုက်ရိုက် MCP Client

**ဖိုင်:** `SDKClient.java`

ဒီ client က AI မသုံးဘဲ MCP server နဲ့တိုက်ရိုက်ပြောဆိုပါတယ်။ အတိအကျသော ကိန်းဂဏန်းတွက်ချက်မှုနည်းလမ်းတွေကိုခေါ်ပါတယ်:

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

**ဒါဘာလုပ်သလဲ:**
1. **ဆက်သွယ်**: `http://localhost:8080` မှာရှိတဲ့ ကိန်းဂဏန်းတွက်ချက်မှု server နဲ့ဆက်သွယ်တယ်
2. **စာရင်းပြုစု**: ရရှိနိုင်တဲ့ tools (ကျွန်တော်တို့ရဲ့ ကိန်းဂဏန်းတွက်ချက်မှုနည်းလမ်းတွေ) အားလုံးကိုစာရင်းပြုစုတယ်
3. **ခေါ်ဆို**: အတိအကျသော parameters နဲ့ နည်းလမ်းတွေကိုခေါ်တယ်
4. **ရလဒ်များကိုပုံနှိပ်**: ရလဒ်တွေကိုတိုက်ရိုက်ပြတယ်

**ဘယ်အချိန်မှာသုံးမလဲ:** သင်ဘယ်လိုတွက်ချက်မှုလုပ်ချင်တယ်ဆိုတာအတိအကျသိပြီး programmatically ခေါ်ချင်တဲ့အချိန်

### 4. AI အခြေခံ Client

**ဖိုင်:** `LangChain4jClient.java`

ဒီ client က AI မော်ဒယ် (GPT-4o-mini) ကိုအသုံးပြုပြီး ကိန်းဂဏန်းတွက်ချက်မှု tools တွေကို အလိုအလျောက်ရွေးချယ်နိုင်ပါတယ်:

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

**ဒါဘာလုပ်သလဲ:**
1. **AI မော်ဒယ်ဆက်သွယ်မှု**: GitHub token ကိုအသုံးပြုပြီး AI မော်ဒယ်နဲ့ဆက်သွယ်တယ်
2. **MCP server နဲ့ဆက်သွယ်**: AI ကို ကျွန်တော်တို့ရဲ့ ကိန်းဂဏန်းတွက်ချက်မှု MCP server နဲ့ချိတ်ဆက်ပေးတယ်
3. **AI ကို tools တွေသုံးခွင့်ပေး**: ကျွန်တော်တို့ရဲ့ tools အားလုံးကို AI သုံးခွင့်ပေးတယ်
4. **သဘာဝဘာသာစကားတုံ့ပြန်မှု**: "24.5 နဲ့ 17.3 ကိုပေါင်းပေးပါ" လို request တွေကို AI နားလည်တယ်

**AI အလိုအလျောက်:**
- သင်ပေါင်းချင်တယ်ဆိုတာနားလည်တယ်
- `add` tool ကိုရွေးတယ်
- `add(24.5, 17.3)` ကိုခေါ်တယ်
- ရလဒ်ကို သဘာဝဘာသာစကားနဲ့ပြန်ပေးတယ်

## ဥပမာများကိုအလုပ်လုပ်စေခြင်း

### အဆင့် 1: ကိန်းဂဏန်းတွက်ချက်မှု Server ကိုစတင်ပါ

အရင်ဆုံး GitHub token ကိုသတ်မှတ်ပါ (AI client အတွက်လိုအပ်ပါတယ်):

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
cd 04-PracticalSamples/mcp/calculator
mvn spring-boot:run
```

Server က `http://localhost:8080` မှာစတင်ပါလိမ့်မယ်။ သင်ကြည့်ရမယ့်အရာက:
```
Started McpServerApplication in X.XXX seconds
```

### အဆင့် 2: Direct Client နဲ့စမ်းသပ်ပါ

Terminal အသစ်တစ်ခုမှာ:
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"
```

သင်ကြည့်ရမယ့် output က:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### အဆင့် 3: AI Client နဲ့စမ်းသပ်ပါ

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"
```

AI က tools တွေကိုအလိုအလျောက်သုံးတာကိုသင်မြင်ရပါလိမ့်မယ်:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

## အားလုံးပေါင်းစည်းပြီးအလုပ်လုပ်ပုံ

"5 နဲ့ 3 ကိုပေါင်းရင်ဘယ်လောက်လဲ?" လို့ AI ကိုမေးတဲ့အခါမှာ အလုပ်လုပ်ပုံက:

1. **သင်** သဘာဝဘာသာစကားနဲ့ AI ကိုမေးတယ်
2. **AI** သင့်မေးခွန်းကိုခွဲခြမ်းစိတ်ဖြာပြီး သင်ပေါင်းချင်တယ်ဆိုတာနားလည်တယ်
3. **AI** MCP server ကိုခေါ်တယ်: `add(5.0, 3.0)`
4. **ကိန်းဂဏန်းတွက်ချက်မှုဝန်ဆောင်မှု**: `5.0 + 3.0 = 8.0` ကိုလုပ်ဆောင်တယ်
5. **ကိန်းဂဏန်းတွက်ချက်မှုဝန်ဆောင်မှု**: `"5.00 + 3.00 = 8.00"` ကိုပြန်ပေးတယ်
6. **AI** ရလဒ်ကိုလက်ခံပြီး သဘာဝဘာသာစကားနဲ့ပြန်တယ်
7. **သင်** "5 နဲ့ 3 ကိုပေါင်းရင် 8 ဖြစ်တယ်" ဆိုတဲ့အဖြေကိုရတယ်

## နောက်တစ်ဆင့်များ

နောက်ထပ်ဥပမာများအတွက် [Chapter 04: Practical samples](../../README.md) ကိုကြည့်ပါ

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်မှုများတွင် အမှားများ သို့မဟုတ် မတိကျမှုများ ပါရှိနိုင်သည်ကို သတိပြုပါ။ မူရင်းဘာသာစကားဖြင့် ရေးသားထားသော စာရွက်စာတမ်းကို အာဏာရှိသော ရင်းမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များမှ ပရော်ဖက်ရှင်နယ် ဘာသာပြန်မှုကို အကြံပြုပါသည်။ ဤဘာသာပြန်မှုကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲအလွတ်များ သို့မဟုတ် အနားလွဲမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။