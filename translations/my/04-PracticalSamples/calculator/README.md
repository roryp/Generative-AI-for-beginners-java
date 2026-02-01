# MCP Calculator Tutorial for Beginners

## အကြောင်းအရာများ

- [သင်လေ့လာနိုင်မည့်အရာများ](../../../../04-PracticalSamples/calculator)
- [လိုအပ်ချက်များ](../../../../04-PracticalSamples/calculator)
- [ပရောဂျက်ဖွဲ့စည်းမှုကိုနားလည်ခြင်း](../../../../04-PracticalSamples/calculator)
- [အဓိကအစိတ်အပိုင်းများရှင်းလင်းချက်](../../../../04-PracticalSamples/calculator)
  - [1. အဓိကအက်ပလီကေးရှင်း](../../../../04-PracticalSamples/calculator)
  - [2. ကိန်းဂဏန်းတွက်ချက်မှုဝန်ဆောင်မှု](../../../../04-PracticalSamples/calculator)
  - [3. တိုက်ရိုက် MCP Client](../../../../04-PracticalSamples/calculator)
  - [4. AI-အခြေခံ Client](../../../../04-PracticalSamples/calculator)
- [ဥပမာများကိုအလုပ်လုပ်စေခြင်း](../../../../04-PracticalSamples/calculator)
- [အားလုံးပေါင်းစည်းပုံ](../../../../04-PracticalSamples/calculator)
- [နောက်ထပ်အဆင့်များ](../../../../04-PracticalSamples/calculator)

## သင်လေ့လာနိုင်မည့်အရာများ

ဒီလမ်းညွှန်မှာ Model Context Protocol (MCP) ကိုအသုံးပြုပြီး ကိန်းဂဏန်းတွက်ချက်မှုဝန်ဆောင်မှုတစ်ခုကို ဘယ်လိုတည်ဆောက်ရမလဲဆိုတာရှင်းပြထားပါတယ်။ သင်နားလည်နိုင်မည့်အရာများမှာ:

- AI အတွက် tool အဖြစ်အသုံးပြုနိုင်သော ဝန်ဆောင်မှုတစ်ခုကို ဘယ်လိုဖန်တီးရမလဲ
- MCP ဝန်ဆောင်မှုများနှင့် တိုက်ရိုက်ဆက်သွယ်မှုကို ဘယ်လိုပြင်ဆင်ရမလဲ
- AI မော်ဒယ်များက ဘယ်လို tool များကိုအလိုအလျောက်ရွေးချယ်နိုင်သလဲ
- တိုက်ရိုက် protocol ခေါ်ဆိုမှုများနှင့် AI-အကူအညီ interactions အကြားကွာခြားချက်

## လိုအပ်ချက်များ

စတင်ရန်မတိုင်မီ သင်မှာရှိရမည့်အရာများ:

- Java 21 သို့မဟုတ် အထက်တန်း version တစ်ခု
- Maven ကို dependency management အတွက်
- GitHub အကောင့်နှင့် personal access token (PAT)
- Java နှင့် Spring Boot အခြေခံနားလည်မှု

## ပရောဂျက်ဖွဲ့စည်းမှုကိုနားလည်ခြင်း

Calculator ပရောဂျက်မှာ အရေးကြီးသော ဖိုင်များအချို့ပါဝင်ပါတယ်:

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

## အဓိကအစိတ်အပိုင်းများရှင်းလင်းချက်

### 1. အဓိကအက်ပလီကေးရှင်း

**ဖိုင်:** `McpServerApplication.java`

ဒီဟာက ကျွန်တော်တို့ရဲ့ calculator ဝန်ဆောင်မှုရဲ့ entry point ဖြစ်ပါတယ်။ ဒါဟာ Spring Boot အက်ပလီကေးရှင်းတစ်ခုဖြစ်ပြီး အထူးအပိုဆောင်းတစ်ခုပါဝင်ပါတယ်:

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

**ဒီဟာဘာလုပ်သလဲ:**
- Spring Boot web server ကို port 8080 မှာစတင်စေတယ်
- `ToolCallbackProvider` ကိုဖန်တီးပြီး calculator method များကို MCP tools အဖြစ်အသုံးပြုနိုင်စေတယ်
- `@Bean` annotation က Spring ကို ဒီဟာကို component အဖြစ်စီမံခန့်ခွဲစေတယ်

### 2. ကိန်းဂဏန်းတွက်ချက်မှုဝန်ဆောင်မှု

**ဖိုင်:** `CalculatorService.java`

ဒီနေရာမှာ calculation တွေကိုလုပ်ဆောင်ပါတယ်။ method တစ်ခုချင်းစီကို `@Tool` နဲ့အမှတ်အသားပြုထားပြီး MCP မှတစ်ဆင့်ခေါ်နိုင်ပါတယ်:

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

1. **`@Tool` Annotation**: ဒီဟာက MCP ကို ဒီ method ကို client များခေါ်နိုင်တယ်လို့ပြောပါတယ်
2. **ရှင်းလင်းသောဖော်ပြချက်များ**: tool တစ်ခုချင်းစီမှာ AI မော်ဒယ်များအတွက် အသုံးပြုမှုကိုနားလည်စေဖို့ဖော်ပြချက်ပါဝင်ပါတယ်
3. **အမြဲတမ်းတူညီသောပြန်လည်ပေးအပ်မှုပုံစံ**: အားလုံးမှာ "5.00 + 3.00 = 8.00" စတဲ့ string format ကိုပြန်ပေးတယ်
4. **အမှားကိုင်တွယ်မှု**: သုညဖြင့်စားခြင်းနှင့် အနုတ်စရိုက်ရင်းအမြစ်တွက်ချက်မှုများအတွက် error message ပြန်ပေးတယ်

**ရရှိနိုင်သောလုပ်ဆောင်ချက်များ:**
- `add(a, b)` - ကိန်းနှစ်ခုကိုပေါင်းစည်း
- `subtract(a, b)` - ဒုတိယကိန်းကိုပထမကိန်းမှနုတ်
- `multiply(a, b)` - ကိန်းနှစ်ခုကိုမြှောက်
- `divide(a, b)` - ပထမကိန်းကိုဒုတိယကိန်းဖြင့်စား (သုညစစ်ဆေးမှုပါဝင်)
- `power(base, exponent)` - base ကို exponent အတိုင်းမြှောက်
- `squareRoot(number)` - ရင်းအမြစ်တွက်ချက် (အနုတ်စရိုက်စစ်ဆေးမှုပါဝင်)
- `modulus(a, b)` - division ရဲ့ remainder ကိုပြန်ပေး
- `absolute(number)` - absolute value ကိုပြန်ပေး
- `help()` - အားလုံးသောလုပ်ဆောင်ချက်များအကြောင်းအချက်အလက်ပြန်ပေး

### 3. တိုက်ရိုက် MCP Client

**ဖိုင်:** `SDKClient.java`

ဒီ client က MCP server နဲ့ AI မပါဘဲတိုက်ရိုက်ဆက်သွယ်ပါတယ်။ calculator function တွေကို manual ခေါ်ပါတယ်:

```java
public class SDKClient {
    
    public static void main(String[] args) {
        McpClientTransport transport = WebFluxSseClientTransport.builder(
            WebClient.builder().baseUrl("http://localhost:8080")
        ).build();
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

**ဒီဟာဘာလုပ်သလဲ:**
1. **Connects** MCP server ကို `http://localhost:8080` မှာ builder pattern ကိုအသုံးပြုပြီးဆက်သွယ်
2. **Lists** ရရှိနိုင်သော tool (calculator function) အားလုံး
3. **Calls** သတ်မှတ်ထားသော parameter များနှင့် function
4. **Prints** ရလဒ်ကိုတိုက်ရိုက်ပြ

**မှတ်ချက်:** Spring AI 1.1.0-SNAPSHOT dependency ကိုအသုံးပြုပြီး `WebFluxSseClientTransport` အတွက် builder pattern ကိုအသုံးပြုထားပါတယ်။ သင်ဟာ stable version အဟောင်းကိုအသုံးပြုနေပါက direct constructor ကိုအသုံးပြုရနိုင်ပါတယ်။

**ဘယ်အခါအသုံးပြုမလဲ:** သင်ဘယ်လိုတွက်ချက်မှုကိုလုပ်ချင်တယ်ဆိုတာသိပြီး programmatically ခေါ်ချင်တဲ့အခါ

### 4. AI-အခြေခံ Client

**ဖိုင်:** `LangChain4jClient.java`

ဒီ client က AI မော်ဒယ် (GPT-4o-mini) ကိုအသုံးပြုပြီး calculator tool များကိုအလိုအလျောက်ရွေးချယ်နိုင်ပါတယ်:

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

**ဒီဟာဘာလုပ်သလဲ:**
1. **Creates** GitHub token ကိုအသုံးပြုပြီး AI မော်ဒယ် connection ဖန်တီး
2. **Connects** AI ကို calculator MCP server နဲ့ဆက်သွယ်
3. **Gives** AI ကို calculator tool အားလုံးရရှိစေ
4. **Allows** သဘာဝဘာသာစကား request တွေကိုပေးစွမ်းစေ ("24.5 နဲ့ 17.3 ရဲ့ပေါင်းကိုတွက်ပါ" စတဲ့)

**AI အလိုအလျောက်:**
- သင်က ကိန်းပေါင်းလိုချင်တယ်ဆိုတာနားလည်တယ်
- `add` tool ကိုရွေးတယ်
- `add(24.5, 17.3)` ကိုခေါ်တယ်
- ရလဒ်ကို သဘာဝအဖြေတစ်ခုအဖြစ်ပြန်ပေးတယ်

## ဥပမာများကိုအလုပ်လုပ်စေခြင်း

### အဆင့် 1: Calculator Server ကိုစတင်ပါ

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
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

Server က `http://localhost:8080` မှာစတင်ပါလိမ့်မယ်။ သင်မြင်ရမည့်အရာ:
```
Started McpServerApplication in X.XXX seconds
```

### အဆင့် 2: Direct Client နဲ့စမ်းသပ်ပါ

**အသစ်သော** terminal တစ်ခုမှာ Server ကို run လုပ်နေဆဲဖြစ်စဉ် Direct MCP client ကို run လုပ်ပါ:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

သင်မြင်ရမည့် output:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### အဆင့် 3: AI Client နဲ့စမ်းသပ်ပါ

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

AI က tool များကိုအလိုအလျောက်အသုံးပြုနေသည်ကိုသင်မြင်ရမည်:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### အဆင့် 4: MCP Server ကိုပိတ်ပါ

စမ်းသပ်ပြီးပါက AI client ကို run လုပ်နေတဲ့ terminal မှာ `Ctrl+C` ကိုနှိပ်ပြီး client ကိုပိတ်နိုင်ပါတယ်။ MCP server က သင်ပိတ်မချင်းအလုပ်လုပ်နေပါလိမ့်မယ်။
Server ကိုပိတ်ရန် run လုပ်နေတဲ့ terminal မှာ `Ctrl+C` ကိုနှိပ်ပါ။

## အားလုံးပေါင်းစည်းပုံ

AI ကို "5 နဲ့ 3 ရဲ့ပေါင်းဘယ်လောက်လဲ?" လို့မေးတဲ့အခါမှာ အပြည့်အစုံ flow ကဒီလိုဖြစ်ပါတယ်:

1. **သင်** AI ကို သဘာဝဘာသာစကားနဲ့မေးတယ်
2. **AI** သင့်ရဲ့ request ကိုခွဲခြမ်းစိတ်ဖြာပြီး addition လိုချင်တယ်ဆိုတာနားလည်တယ်
3. **AI** MCP server ကိုခေါ်တယ်: `add(5.0, 3.0)`
4. **Calculator Service** က `5.0 + 3.0 = 8.0` လုပ်တယ်
5. **Calculator Service** က `"5.00 + 3.00 = 8.00"` ပြန်ပေးတယ်
6. **AI** ရလဒ်ကို natural response အဖြစ် format လုပ်တယ်
7. **သင်** "5 နဲ့ 3 ရဲ့ပေါင်းက 8 ဖြစ်ပါတယ်" ဆိုတဲ့အဖြေကိုရတယ်

## နောက်ထပ်အဆင့်များ

ဥပမာများပိုမိုကြည့်ရန် [Chapter 04: Practical samples](../README.md) ကိုကြည့်ပါ

---

**အကြောင်းကြားချက်**:  
ဤစာရွက်စာတမ်းကို AI ဘာသာပြန်ဝန်ဆောင်မှု [Co-op Translator](https://github.com/Azure/co-op-translator) ကို အသုံးပြု၍ ဘာသာပြန်ထားပါသည်။ ကျွန်ုပ်တို့သည် တိကျမှုအတွက် ကြိုးစားနေသော်လည်း၊ အလိုအလျောက် ဘာသာပြန်မှုများတွင် အမှားများ သို့မဟုတ် မတိကျမှုများ ပါဝင်နိုင်သည်ကို သတိပြုပါ။ မူရင်းဘာသာစကားဖြင့် ရေးသားထားသော စာရွက်စာတမ်းကို အာဏာရှိသော ရင်းမြစ်အဖြစ် သတ်မှတ်သင့်ပါသည်။ အရေးကြီးသော အချက်အလက်များအတွက် လူ့ဘာသာပြန်ပညာရှင်များမှ ပရော်ဖက်ရှင်နယ် ဘာသာပြန်မှုကို အကြံပြုပါသည်။ ဤဘာသာပြန်မှုကို အသုံးပြုခြင်းမှ ဖြစ်ပေါ်လာသော အလွဲသုံးစားမှု သို့မဟုတ် အနားလွဲမှုများအတွက် ကျွန်ုပ်တို့သည် တာဝန်မယူပါ။