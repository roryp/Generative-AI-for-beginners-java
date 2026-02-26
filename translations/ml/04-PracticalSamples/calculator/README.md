# MCP കാൽക്കുലേറ്റർ ട്യൂട്ടോറിയൽ ആരംഭക്കാർക്കായി

## ഉള്ളടക്കസൂചിക

- [നിങ്ങൾ എന്താണ് പഠിക്കുക](../../../../04-PracticalSamples/calculator)
- [ആവശ്യമായ മുൻ‌വശങ്ങൾ](../../../../04-PracticalSamples/calculator)
- [പ്രോജക്റ്റ് ഘടന മനസ്സിലാക്കുക](../../../../04-PracticalSamples/calculator)
- [പ്രധാന ഘടകങ്ങൾ വിശദീകരണം](../../../../04-PracticalSamples/calculator)
  - [1. പ്രധാന ആപ്ലിക്കേഷൻ](../../../../04-PracticalSamples/calculator)
  - [2. കാൽക്കുലേറ്റർ സർവീസ്](../../../../04-PracticalSamples/calculator)
  - [3. ഡയരക്ട് MCP ക്ലയന്റ്](../../../../04-PracticalSamples/calculator)
  - [4. AI-പവർഡ് ക്ലയന്റ്](../../../../04-PracticalSamples/calculator)
- [ഉദാഹരണങ്ങൾ പ്രവർത്തിപ്പിക്കൽ](../../../../04-PracticalSamples/calculator)
- [എല്ലാം ഒരുമിച്ച് എങ്ങനെ പ്രവർത്തിക്കുന്നു](../../../../04-PracticalSamples/calculator)
- [അടുത്ത ഘട്ടങ്ങൾ](../../../../04-PracticalSamples/calculator)

## നിങ്ങൾ എന്താണ് പഠിക്കുക

ഈ ട്യൂട്ടോറിയൽ മോഡൽ കോൺടെക്സ്റ്റ് പ്രോട്ടോക്കോൾ (MCP) ഉപയോഗിച്ച് ഒരു കാൽക്കുലേറ്റർ സർവീസ് എങ്ങനെ നിർമ്മിക്കാമെന്ന് വിശദീകരിക്കുന്നു. നിങ്ങൾക്ക് മനസ്സിലാകും:

- AI ഒരു ഉപകരണമെന്ന നിലയിൽ ഉപയോഗിക്കാവുന്ന ഒരു സർവീസ് എങ്ങനെ സൃഷ്ടിക്കാം
- MCP സർവീസുകളുമായി നേരിട്ട് ആശയവിനിമയം എങ്ങനെ ക്രമീകരിക്കാം
- AI മോഡലുകൾ സ്വയമേവ ഏത് ഉപകരണങ്ങൾ ഉപയോഗിക്കണമെന്ന് എങ്ങനെ തീരുമാനിക്കുന്നു
- നേരിട്ടുള്ള പ്രോട്ടോക്കോൾ കോൾസും AI സഹായത്തോടെ ഉള്ള ഇടപെടലുകളും തമ്മിലുള്ള വ്യത്യാസം

## ആവശ്യമായ മുൻ‌വശങ്ങൾ

തുടങ്ങുന്നതിന് മുമ്പ്, നിങ്ങൾക്ക് താഴെ പറയുന്നവ ഉണ്ടെന്ന് ഉറപ്പാക്കുക:
- Java 21 അല്ലെങ്കിൽ അതിനുമുകളിലുള്ള പതിപ്പ് ഇൻസ്റ്റാൾ ചെയ്തിരിക്കണം
- Maven ഡിപൻഡൻസി മാനേജ്മെന്റിനായി
- വ്യക്തിഗത ആക്സസ് ടോക്കൺ (PAT) ഉള്ള GitHub അക്കൗണ്ട്
- Javaയും Spring Bootയും സംബന്ധിച്ച അടിസ്ഥാന ധാരണ

## പ്രോജക്റ്റ് ഘടന മനസ്സിലാക്കുക

കാൽക്കുലേറ്റർ പ്രോജക്റ്റിൽ ചില പ്രധാന ഫയലുകൾ ഉണ്ട്:

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

## പ്രധാന ഘടകങ്ങൾ വിശദീകരണം

### 1. പ്രധാന ആപ്ലിക്കേഷൻ

**ഫയൽ:** `McpServerApplication.java`

ഇത് നമ്മുടെ കാൽക്കുലേറ്റർ സർവീസിന്റെ എൻട്രി പോയിന്റാണ്. ഇത് ഒരു സ്റ്റാൻഡേർഡ് Spring Boot ആപ്ലിക്കേഷനാണ്, ഒരു പ്രത്യേക കൂട്ടിച്ചേർക്കലോടെ:

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

**ഇത് എന്താണ് ചെയ്യുന്നത്:**
- 8080 പോർട്ടിൽ ഒരു Spring Boot വെബ് സർവർ ആരംഭിക്കുന്നു
- നമ്മുടെ കാൽക്കുലേറ്റർ മെത്തഡുകൾ MCP ഉപകരണങ്ങളായി ലഭ്യമാക്കുന്ന `ToolCallbackProvider` സൃഷ്ടിക്കുന്നു
- `@Bean` അനോട്ടേഷൻ Spring-നെ ഇത് ഒരു ഘടകമായി മാനേജുചെയ്യാൻ അനുവദിക്കുന്നു

### 2. കാൽക്കുലേറ്റർ സർവീസ്

**ഫയൽ:** `CalculatorService.java`

ഇവിടെയാണ് എല്ലാ ഗണിത പ്രവർത്തനങ്ങളും നടക്കുന്നത്. ഓരോ മെത്തഡും `@Tool` ഉപയോഗിച്ച് അടയാളപ്പെടുത്തിയിരിക്കുന്നു, ഇത് MCP വഴി ലഭ്യമാക്കുന്നു:

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
    
    // കൂടുതൽ കാൽക്കുലേറ്റർ പ്രവർത്തനങ്ങൾ...
    
    private String formatResult(double a, String operator, double b, double result) {
        return String.format("%.2f %s %.2f = %.2f", a, operator, b, result);
    }
}
```

**പ്രധാന സവിശേഷതകൾ:**

1. **`@Tool` അനോട്ടേഷൻ**: ഈ മെത്തഡ് ബാഹ്യ ക്ലയന്റുകൾ വിളിക്കാവുന്നതാണ് എന്ന് MCP-നെ അറിയിക്കുന്നു
2. **വിവരവാനമായ വിവരണങ്ങൾ**: ഓരോ ഉപകരണത്തിനും AI മോഡലുകൾക്ക് ഇത് എപ്പോൾ ഉപയോഗിക്കണമെന്ന് മനസ്സിലാക്കാൻ സഹായിക്കുന്ന വിവരണങ്ങൾ ഉണ്ട്
3. **സ്ഥിരമായ റിട്ടേൺ ഫോർമാറ്റ്**: എല്ലാ പ്രവർത്തനങ്ങളും "5.00 + 3.00 = 8.00" പോലുള്ള മനുഷ്യനുവേദ്യമായ സ്ട്രിംഗുകൾ റിട്ടേൺ ചെയ്യുന്നു
4. **പിശക് കൈകാര്യം**: പൂജ്യത്തോടെ വിഭജനം, നെഗറ്റീവ് സ്ക്വയർ റൂട്ട് എന്നിവ പിശക് സന്ദേശങ്ങൾ റിട്ടേൺ ചെയ്യുന്നു

**ലഭ്യമായ പ്രവർത്തനങ്ങൾ:**
- `add(a, b)` - രണ്ട് സംഖ്യകൾ കൂട്ടിച്ചേർക്കുന്നു
- `subtract(a, b)` - രണ്ടാമത്തെ സംഖ്യ ആദ്യത്തേതിൽ നിന്ന് കുറയ്ക്കുന്നു
- `multiply(a, b)` - രണ്ട് സംഖ്യകൾ ഗുണിക്കുന്നു
- `divide(a, b)` - ആദ്യത്തെ സംഖ്യ രണ്ടാമത്തേതിൽ വിഭജിക്കുന്നു (പൂജ്യ പരിശോധനയോടെ)
- `power(base, exponent)` - ബേസ് എക്സ്പോനന്റിലേക്ക് ഉയർത്തുന്നു
- `squareRoot(number)` - സ്ക്വയർ റൂട്ട് കണക്കാക്കുന്നു (നെഗറ്റീവ് പരിശോധനയോടെ)
- `modulus(a, b)` - വിഭജനത്തിന്റെ ശേഷിപ്പം റിട്ടേൺ ചെയ്യുന്നു
- `absolute(number)` - ആബ്സല്യൂട്ട് മൂല്യം റിട്ടേൺ ചെയ്യുന്നു
- `help()` - എല്ലാ പ്രവർത്തനങ്ങളെക്കുറിച്ചുള്ള വിവരങ്ങൾ റിട്ടേൺ ചെയ്യുന്നു

### 3. ഡയരക്ട് MCP ക്ലയന്റ്

**ഫയൽ:** `SDKClient.java`

ഈ ക്ലയന്റ് AI ഉപയോഗിക്കാതെ MCP സർവറുമായി നേരിട്ട് സംസാരിക്കുന്നു. ഇത് കൃത്യമായ കാൽക്കുലേറ്റർ ഫംഗ്ഷനുകൾ കൈമാറുന്നു:

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
        
        // ലഭ്യമായ ഉപകരണങ്ങൾ പട്ടികയിടുക
        ListToolsResult toolsList = client.listTools();
        System.out.println("Available Tools = " + toolsList);
        
        // പ്രത്യേക കാൽക്കുലേറ്റർ ഫംഗ്ഷനുകൾ വിളിക്കുക
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

**ഇത് എന്താണ് ചെയ്യുന്നത്:**
1. **കണക്റ്റ് ചെയ്യുന്നു**: `http://localhost:8080` എന്ന വിലാസത്തിൽ കാൽക്കുലേറ്റർ സർവറുമായി
2. **ലിസ്റ്റ് ചെയ്യുന്നു**: എല്ലാ ലഭ്യമായ ഉപകരണങ്ങൾ (നമ്മുടെ കാൽക്കുലേറ്റർ ഫംഗ്ഷനുകൾ)
3. **വിളിക്കുന്നു**: കൃത്യമായ പാരാമീറ്ററുകളോടെ പ്രത്യേക ഫംഗ്ഷനുകൾ
4. **പ്രിന്റ് ചെയ്യുന്നു**: ഫലങ്ങൾ നേരിട്ട്

**ശ്രദ്ധിക്കുക:** ഈ ഉദാഹരണം Spring AI 1.1.0-SNAPSHOT ഡിപൻഡൻസി ഉപയോഗിക്കുന്നു, ഇത് `WebFluxSseClientTransport`-നായി ഒരു ബിൽഡർ പാറ്റേൺ അവതരിപ്പിച്ചു. നിങ്ങൾ പഴയ സ്ഥിരതയുള്ള പതിപ്പ് ഉപയോഗിക്കുന്നുവെങ്കിൽ, നേരിട്ടുള്ള കൺസ്ട്രക്ടർ ഉപയോഗിക്കേണ്ടി വരാം.

**എപ്പോൾ ഉപയോഗിക്കണം:** നിങ്ങൾക്ക് കൃത്യമായി ഏത് കാൽക്കുലേഷൻ നടത്തണമെന്ന് അറിയാമെങ്കിൽ, പ്രോഗ്രാമാറ്റിക്കായി ഇത് വിളിക്കാം.

### 4. AI-പവർഡ് ക്ലയന്റ്

**ഫയൽ:** `LangChain4jClient.java`

ഈ ക്ലയന്റ് AI മോഡൽ (GPT-4o-mini) ഉപയോഗിക്കുന്നു, ഇത് സ്വയമേവ ഏത് കാൽക്കുലേറ്റർ ഉപകരണങ്ങൾ ഉപയോഗിക്കണമെന്ന് തീരുമാനിക്കുന്നു:

```java
public class LangChain4jClient {
    
    public static void main(String[] args) throws Exception {
        // AI മോഡൽ സജ്ജമാക്കുക (GitHub മോഡലുകൾ ഉപയോഗിച്ച്)
        ChatLanguageModel model = OpenAiOfficialChatModel.builder()
                .isGitHubModels(true)
                .apiKey(System.getenv("GITHUB_TOKEN"))
                .modelName("gpt-4o-mini")
                .build();

        // ഞങ്ങളുടെ കാൽക്കുലേറ്റർ MCP സെർവറുമായി ബന്ധിപ്പിക്കുക
        McpTransport transport = new HttpMcpTransport.Builder()
                .sseUrl("http://localhost:8080/sse")
                .logRequests(true)  // AI എന്താണ് ചെയ്യുന്നത് എന്ന് കാണിക്കുന്നു
                .logResponses(true)
                .build();

        McpClient mcpClient = new DefaultMcpClient.Builder()
                .transport(transport)
                .build();

        // AI-ന് ഞങ്ങളുടെ കാൽക്കുലേറ്റർ ഉപകരണങ്ങളിലേക്ക് ആക്സസ് നൽകുക
        ToolProvider toolProvider = McpToolProvider.builder()
                .mcpClients(List.of(mcpClient))
                .build();

        // ഞങ്ങളുടെ കാൽക്കുലേറ്റർ ഉപയോഗിക്കാൻ കഴിയുന്ന AI ബോട്ട് സൃഷ്ടിക്കുക
        Bot bot = AiServices.builder(Bot.class)
                .chatLanguageModel(model)
                .toolProvider(toolProvider)
                .build();

        // ഇപ്പോൾ നാചുറൽ ലാംഗ്വേജിൽ കണക്കുകൾ ചെയ്യാൻ AI-യോട് ചോദിക്കാം
        String response = bot.chat("Calculate the sum of 24.5 and 17.3 using the calculator service");
        System.out.println(response);

        response = bot.chat("What's the square root of 144?");
        System.out.println(response);
    }
}
```

**ഇത് എന്താണ് ചെയ്യുന്നത്:**
1. **AI മോഡൽ കണക്ഷൻ സൃഷ്ടിക്കുന്നു** നിങ്ങളുടെ GitHub ടോക്കൺ ഉപയോഗിച്ച്
2. **AI-നെ കണക്റ്റ് ചെയ്യുന്നു** നമ്മുടെ കാൽക്കുലേറ്റർ MCP സർവറുമായി
3. **AI-ക്ക്** എല്ലാ കാൽക്കുലേറ്റർ ഉപകരണങ്ങളിലേക്കുള്ള ആക്സസ് നൽകുന്നു
4. **സ്വാഭാവിക ഭാഷാ അഭ്യർത്ഥനകൾ അനുവദിക്കുന്നു** "24.5നും 17.3നും തമ്മിലുള്ള കൂട്ടം കണക്കാക്കുക" പോലുള്ള

**AI സ്വയമേവ:**
- നിങ്ങൾ സംഖ്യകൾ കൂട്ടണമെന്ന് മനസ്സിലാക്കുന്നു
- `add` ഉപകരണം തിരഞ്ഞെടുക്കുന്നു
- `add(24.5, 17.3)` വിളിക്കുന്നു
- ഫലം സ്വാഭാവിക മറുപടിയിൽ റിട്ടേൺ ചെയ്യുന്നു

## ഉദാഹരണങ്ങൾ പ്രവർത്തിപ്പിക്കൽ

### ഘട്ടം 1: കാൽക്കുലേറ്റർ സർവർ ആരംഭിക്കുക

ആദ്യം, നിങ്ങളുടെ GitHub ടോക്കൺ സജ്ജമാക്കുക (AI ക്ലയന്റിനായി ആവശ്യമാണ്):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

സർവർ ആരംഭിക്കുക:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

സർവർ `http://localhost:8080`-ൽ ആരംഭിക്കും. നിങ്ങൾക്ക് കാണാൻ കഴിയും:
```
Started McpServerApplication in X.XXX seconds
```

### ഘട്ടം 2: ഡയരക്ട് ക്ലയന്റുമായി പരീക്ഷിക്കുക

**പുതിയ** ഒരു ടെർമിനലിൽ, സർവർ ഇപ്പോഴും പ്രവർത്തിക്കുന്നുണ്ടെങ്കിൽ, ഡയരക്ട് MCP ക്ലയന്റ് പ്രവർത്തിപ്പിക്കുക:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

നിങ്ങൾക്ക് താഴെപോലുള്ള ഔട്ട്പുട്ട് കാണാം:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### ഘട്ടം 3: AI ക്ലയന്റുമായി പരീക്ഷിക്കുക

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

AI സ്വയമേവ ഉപകരണങ്ങൾ ഉപയോഗിക്കുന്നതും നിങ്ങൾക്ക് കാണാം:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### ഘട്ടം 4: MCP സർവർ അടയ്ക്കുക

പരീക്ഷണം പൂർത്തിയാക്കിയ ശേഷം, AI ക്ലയന്റ് അടയ്ക്കാൻ അതിന്റെ ടെർമിനലിൽ `Ctrl+C` അമർത്തുക. MCP സർവർ നിങ്ങൾ അടയ്ക്കുന്നതുവരെ പ്രവർത്തിച്ചുകൊണ്ടിരിക്കും.
സർവർ അടയ്ക്കാൻ, അത് പ്രവർത്തിക്കുന്ന ടെർമിനലിൽ `Ctrl+C` അമർത്തുക.

## എല്ലാം ഒരുമിച്ച് എങ്ങനെ പ്രവർത്തിക്കുന്നു

നിങ്ങൾ AI-യോട് "5 + 3 എത്ര?" എന്ന് ചോദിക്കുമ്പോൾ, പൂർണ്ണ പ്രവാഹം ഇങ്ങനെയാണ്:

1. **നിങ്ങൾ** സ്വാഭാവിക ഭാഷയിൽ AI-യോട് ചോദിക്കുന്നു
2. **AI** നിങ്ങളുടെ അഭ്യർത്ഥന വിശകലനം ചെയ്യുകയും നിങ്ങൾ കൂട്ടം വേണമെന്ന് മനസ്സിലാക്കുകയും ചെയ്യുന്നു
3. **AI** MCP സർവറിനെ വിളിക്കുന്നു: `add(5.0, 3.0)`
4. **കാൽക്കുലേറ്റർ സർവീസ്** പ്രവർത്തനം നടത്തുന്നു: `5.0 + 3.0 = 8.0`
5. **കാൽക്കുലേറ്റർ സർവീസ്** റിട്ടേൺ ചെയ്യുന്നു: `"5.00 + 3.00 = 8.00"`
6. **AI** ഫലം സ്വീകരിക്കുകയും സ്വാഭാവിക മറുപടി രൂപപ്പെടുത്തുകയും ചെയ്യുന്നു
7. **നിങ്ങൾക്ക്** ലഭിക്കുന്നു: "5നും 3നും തമ്മിലുള്ള കൂട്ടം 8 ആണ്"

## അടുത്ത ഘട്ടങ്ങൾ

കൂടുതൽ ഉദാഹരണങ്ങൾക്കായി, [Chapter 04: Practical samples](../README.md) കാണുക

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**അറിയിപ്പ്**:  
ഈ രേഖ AI വിവർത്തന സേവനം [Co-op Translator](https://github.com/Azure/co-op-translator) ഉപയോഗിച്ച് വിവർത്തനം ചെയ്തതാണ്. ഞങ്ങൾ കൃത്യതയ്ക്കായി ശ്രമിക്കുന്നുവെങ്കിലും, സ്വയം പ്രവർത്തിക്കുന്ന വിവർത്തനങ്ങളിൽ പിഴവുകൾ അല്ലെങ്കിൽ തെറ്റായ വിവരങ്ങൾ ഉണ്ടാകാൻ സാധ്യതയുണ്ട്. അതിന്റെ സ്വാഭാവിക ഭാഷയിലുള്ള മൗലിക രേഖയാണ് പ്രാമാണികമായ ഉറവിടമായി പരിഗണിക്കേണ്ടത്. നിർണായകമായ വിവരങ്ങൾക്ക്, പ്രൊഫഷണൽ മനുഷ്യ വിവർത്തനം ശുപാർശ ചെയ്യുന്നു. ഈ വിവർത്തനം ഉപയോഗിച്ച് ഉണ്ടാകുന്ന തെറ്റിദ്ധാരണകൾ അല്ലെങ്കിൽ തെറ്റായ വ്യാഖ്യാനങ്ങൾക്കായി ഞങ്ങൾ ഉത്തരവാദികളല്ല.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->