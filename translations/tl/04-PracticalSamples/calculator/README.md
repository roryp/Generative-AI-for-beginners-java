# MCP Calculator Tutorial para sa mga Baguhan

## Nilalaman

- [Ano ang Matututunan Mo](../../../../04-PracticalSamples/calculator)
- [Mga Kinakailangan](../../../../04-PracticalSamples/calculator)
- [Pag-unawa sa Estruktura ng Proyekto](../../../../04-PracticalSamples/calculator)
- [Paliwanag sa Mga Pangunahing Komponent](../../../../04-PracticalSamples/calculator)
  - [1. Pangunahing Aplikasyon](../../../../04-PracticalSamples/calculator)
  - [2. Calculator Service](../../../../04-PracticalSamples/calculator)
  - [3. Direktang MCP Client](../../../../04-PracticalSamples/calculator)
  - [4. AI-Powered Client](../../../../04-PracticalSamples/calculator)
- [Pagpapatakbo ng Mga Halimbawa](../../../../04-PracticalSamples/calculator)
- [Paano Nagtutulungan ang Lahat](../../../../04-PracticalSamples/calculator)
- [Mga Susunod na Hakbang](../../../../04-PracticalSamples/calculator)

## Ano ang Matututunan Mo

Ipinaliwanag sa tutorial na ito kung paano bumuo ng calculator service gamit ang Model Context Protocol (MCP). Malalaman mo:

- Paano gumawa ng serbisyo na magagamit ng AI bilang tool
- Paano mag-set up ng direktang komunikasyon sa MCP services
- Paano awtomatikong pumili ang AI models kung aling tools ang gagamitin
- Ang pagkakaiba ng direktang protocol calls at AI-assisted interactions

## Mga Kinakailangan

Bago magsimula, siguraduhing mayroon ka ng mga sumusunod:
- Nakainstall na Java 21 o mas mataas
- Maven para sa pamamahala ng dependencies
- Isang GitHub account na may personal access token (PAT)
- Pangunahing kaalaman sa Java at Spring Boot

## Pag-unawa sa Estruktura ng Proyekto

Ang calculator project ay may ilang mahahalagang file:

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

## Paliwanag sa Mga Pangunahing Komponent

### 1. Pangunahing Aplikasyon

**File:** `McpServerApplication.java`

Ito ang entry point ng ating calculator service. Isa itong standard na Spring Boot application na may espesyal na karagdagan:

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

**Ano ang ginagawa nito:**
- Pinapatakbo ang Spring Boot web server sa port 8080
- Gumagawa ng `ToolCallbackProvider` na ginagawang available ang ating calculator methods bilang MCP tools
- Ang `@Bean` annotation ay nagsasabi sa Spring na pamahalaan ito bilang isang component na magagamit ng ibang bahagi

### 2. Calculator Service

**File:** `CalculatorService.java`

Dito nagaganap ang lahat ng kalkulasyon. Ang bawat method ay may markang `@Tool` upang magamit ito sa pamamagitan ng MCP:

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

**Mga Pangunahing Tampok:**

1. **`@Tool` Annotation**: Nagsasabi sa MCP na ang method na ito ay maaaring tawagin ng external clients
2. **Malinaw na Deskripsyon**: Ang bawat tool ay may deskripsyon na tumutulong sa AI models na maunawaan kung kailan ito gagamitin
3. **Pare-parehong Format ng Resulta**: Lahat ng operasyon ay nagbabalik ng human-readable strings tulad ng "5.00 + 3.00 = 8.00"
4. **Error Handling**: Ang division by zero at negative square roots ay nagbabalik ng error messages

**Mga Available na Operasyon:**
- `add(a, b)` - Nagdadagdag ng dalawang numero
- `subtract(a, b)` - Binabawas ang pangalawa mula sa una
- `multiply(a, b)` - Pinaparami ang dalawang numero
- `divide(a, b)` - Hinahati ang una sa pangalawa (may zero-check)
- `power(base, exponent)` - Itinataas ang base sa power ng exponent
- `squareRoot(number)` - Kinukwenta ang square root (may negative check)
- `modulus(a, b)` - Nagbabalik ng remainder ng division
- `absolute(number)` - Nagbabalik ng absolute value
- `help()` - Nagbabalik ng impormasyon tungkol sa lahat ng operasyon

### 3. Direktang MCP Client

**File:** `SDKClient.java`

Ang client na ito ay direktang nakikipag-usap sa MCP server nang hindi gumagamit ng AI. Manu-manong tinatawag nito ang mga partikular na calculator functions:

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

**Ano ang ginagawa nito:**
1. **Kumokonekta** sa calculator server sa `http://localhost:8080` gamit ang builder pattern
2. **Naglalista** ng lahat ng available na tools (ang ating calculator functions)
3. **Tumatawag** ng partikular na functions gamit ang eksaktong parameters
4. **Nagpi-print** ng mga resulta nang direkta

**Tandaan:** Ang halimbawang ito ay gumagamit ng Spring AI 1.1.0-SNAPSHOT dependency, na nagpakilala ng builder pattern para sa `WebFluxSseClientTransport`. Kung gumagamit ka ng mas lumang stable na bersyon, maaaring kailanganin mong gamitin ang direktang constructor.

**Kailan ito gagamitin:** Kapag alam mo na ang eksaktong kalkulasyon na nais mong gawin at nais mo itong tawagin programmatically.

### 4. AI-Powered Client

**File:** `LangChain4jClient.java`

Ang client na ito ay gumagamit ng AI model (GPT-4o-mini) na awtomatikong nakakapagdesisyon kung aling calculator tools ang gagamitin:

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

**Ano ang ginagawa nito:**
1. **Gumagawa** ng koneksyon sa AI model gamit ang iyong GitHub token
2. **Kumokonekta** ang AI sa ating calculator MCP server
3. **Binibigyan** ang AI ng access sa lahat ng ating calculator tools
4. **Pinapayagan** ang natural language requests tulad ng "Ikwenta ang kabuuan ng 24.5 at 17.3"

**Awtomatikong ginagawa ng AI:**
- Nauunawaan na gusto mong magdagdag ng mga numero
- Pinipili ang `add` tool
- Tumatawag ng `add(24.5, 17.3)`
- Nagbabalik ng resulta sa natural na sagot

## Pagpapatakbo ng Mga Halimbawa

### Hakbang 1: Patakbuhin ang Calculator Server

Una, itakda ang iyong GitHub token (kailangan para sa AI client):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

Patakbuhin ang server:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

Magsisimula ang server sa `http://localhost:8080`. Makikita mo:
```
Started McpServerApplication in X.XXX seconds
```

### Hakbang 2: Subukan gamit ang Direktang Client

Sa isang **BAGONG** terminal habang tumatakbo pa ang Server, patakbuhin ang direktang MCP client:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

Makikita mo ang output tulad ng:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### Hakbang 3: Subukan gamit ang AI Client

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

Makikita mo ang AI na awtomatikong gumagamit ng tools:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### Hakbang 4: Isara ang MCP Server

Kapag tapos ka na sa pagsubok, maaari mong ihinto ang AI client sa pamamagitan ng pagpindot sa `Ctrl+C` sa terminal nito. Ang MCP server ay patuloy na tatakbo hanggang sa ihinto mo ito.
Upang ihinto ang server, pindutin ang `Ctrl+C` sa terminal kung saan ito tumatakbo.

## Paano Nagtutulungan ang Lahat

Narito ang kumpletong daloy kapag tinanong mo ang AI ng "Ano ang 5 + 3?":

1. **Ikaw** ay nagtatanong sa AI gamit ang natural na wika
2. **AI** ay sinusuri ang iyong tanong at nauunawaan na gusto mo ng addition
3. **AI** ay tumatawag sa MCP server: `add(5.0, 3.0)`
4. **Calculator Service** ay gumagawa ng: `5.0 + 3.0 = 8.0`
5. **Calculator Service** ay nagbabalik ng: `"5.00 + 3.00 = 8.00"`
6. **AI** ay tumatanggap ng resulta at inaayos ito sa natural na sagot
7. **Ikaw** ay nakakatanggap ng: "Ang kabuuan ng 5 at 3 ay 8"

## Mga Susunod na Hakbang

Para sa higit pang mga halimbawa, tingnan ang [Chapter 04: Practical samples](../README.md)

---

**Paunawa**:  
Ang dokumentong ito ay isinalin gamit ang AI translation service na [Co-op Translator](https://github.com/Azure/co-op-translator). Bagama't sinisikap naming maging tumpak, tandaan na ang mga awtomatikong pagsasalin ay maaaring maglaman ng mga pagkakamali o hindi pagkakatugma. Ang orihinal na dokumento sa kanyang katutubong wika ang dapat ituring na opisyal na sanggunian. Para sa mahalagang impormasyon, inirerekomenda ang propesyonal na pagsasalin ng tao. Hindi kami mananagot sa anumang hindi pagkakaunawaan o maling interpretasyon na dulot ng paggamit ng pagsasaling ito.