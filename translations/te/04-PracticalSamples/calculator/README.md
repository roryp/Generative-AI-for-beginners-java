<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b6c16b5514d524e415a94f6097ee7d4c",
  "translation_date": "2025-12-01T09:17:11+00:00",
  "source_file": "04-PracticalSamples/calculator/README.md",
  "language_code": "te"
}
-->
# MCP కాలిక్యులేటర్ ట్యుటోరియల్ ప్రారంభికుల కోసం

## విషయ సూచిక

- [మీరు నేర్చుకునేది](../../../../04-PracticalSamples/calculator)
- [ముందస్తు అవసరాలు](../../../../04-PracticalSamples/calculator)
- [ప్రాజెక్ట్ నిర్మాణాన్ని అర్థం చేసుకోవడం](../../../../04-PracticalSamples/calculator)
- [ముఖ్యమైన భాగాల వివరణ](../../../../04-PracticalSamples/calculator)
  - [1. ప్రధాన అప్లికేషన్](../../../../04-PracticalSamples/calculator)
  - [2. కాలిక్యులేటర్ సర్వీస్](../../../../04-PracticalSamples/calculator)
  - [3. డైరెక్ట్ MCP క్లయింట్](../../../../04-PracticalSamples/calculator)
  - [4. AI ఆధారిత క్లయింట్](../../../../04-PracticalSamples/calculator)
- [ఉదాహరణలను నడపడం](../../../../04-PracticalSamples/calculator)
- [అన్నీ కలిసి ఎలా పనిచేస్తాయి](../../../../04-PracticalSamples/calculator)
- [తదుపరి దశలు](../../../../04-PracticalSamples/calculator)

## మీరు నేర్చుకునేది

ఈ ట్యుటోరియల్ Model Context Protocol (MCP) ఉపయోగించి కాలిక్యులేటర్ సర్వీస్‌ను ఎలా నిర్మించాలో వివరిస్తుంది. మీరు అర్థం చేసుకుంటారు:

- AI ఒక సాధనంగా ఉపయోగించుకోగల సర్వీస్‌ను ఎలా సృష్టించాలి
- MCP సర్వీసులతో నేరుగా కమ్యూనికేషన్ ఎలా ఏర్పాటు చేయాలి
- AI మోడల్స్ ఏ సాధనాలను ఉపయోగించాలో స్వయంచాలకంగా ఎలా నిర్ణయిస్తాయి
- నేరుగా ప్రోటోకాల్ కాల్స్ మరియు AI సహాయంతో జరిగే ఇంటరాక్షన్స్ మధ్య తేడా

## ముందస్తు అవసరాలు

ప్రారంభించడానికి, మీ వద్ద ఉండాలి:
- Java 21 లేదా అంతకంటే ఎక్కువ వెర్షన్
- Maven డిపెండెన్సీ మేనేజ్‌మెంట్ కోసం
- వ్యక్తిగత యాక్సెస్ టోకెన్ (PAT) ఉన్న GitHub ఖాతా
- Java మరియు Spring Boot యొక్క ప్రాథమిక అవగాహన

## ప్రాజెక్ట్ నిర్మాణాన్ని అర్థం చేసుకోవడం

కాలిక్యులేటర్ ప్రాజెక్ట్‌లో కొన్ని ముఖ్యమైన ఫైళ్లు ఉన్నాయి:

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

## ముఖ్యమైన భాగాల వివరణ

### 1. ప్రధాన అప్లికేషన్

**ఫైల్:** `McpServerApplication.java`

ఇది మన కాలిక్యులేటర్ సర్వీస్ యొక్క ఎంట్రీ పాయింట్. ఇది ఒక ప్రామాణిక Spring Boot అప్లికేషన్, కానీ ఒక ప్రత్యేకమైన అదనపు అంశంతో:

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

**ఇది ఏమి చేస్తుంది:**
- 8080 పోర్ట్‌లో Spring Boot వెబ్ సర్వర్‌ను ప్రారంభిస్తుంది
- `ToolCallbackProvider` సృష్టిస్తుంది, ఇది మన కాలిక్యులేటర్ పద్ధతులను MCP సాధనాలుగా అందుబాటులో ఉంచుతుంది
- `@Bean` అనోటేషన్ Spring ఈ భాగాన్ని ఇతర భాగాలు ఉపయోగించగలిగేలా నిర్వహించమని చెబుతుంది

### 2. కాలిక్యులేటర్ సర్వీస్

**ఫైల్:** `CalculatorService.java`

ఇక్కడే అన్ని గణిత చర్యలు జరుగుతాయి. ప్రతి పద్ధతిని `@Tool` తో గుర్తించి MCP ద్వారా అందుబాటులో ఉంచుతారు:

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
    
    // మరిన్ని కాలిక్యులేటర్ ఆపరేషన్లు...
    
    private String formatResult(double a, String operator, double b, double result) {
        return String.format("%.2f %s %.2f = %.2f", a, operator, b, result);
    }
}
```

**ప్రధాన లక్షణాలు:**

1. **`@Tool` అనోటేషన్**: ఇది MCPకి ఈ పద్ధతిని బాహ్య క్లయింట్లు కాల్ చేయగలవని చెబుతుంది
2. **స్పష్టమైన వివరణలు**: ప్రతి సాధనానికి వివరణ ఉంటుంది, ఇది AI మోడల్స్ ఎప్పుడు ఉపయోగించాలో అర్థం చేసుకోవడానికి సహాయపడుతుంది
3. **సమానమైన రిటర్న్ ఫార్మాట్**: అన్ని ఆపరేషన్లు "5.00 + 3.00 = 8.00" వంటి పాఠ్యాన్ని తిరిగి ఇస్తాయి
4. **లోపాల నిర్వహణ**: సున్నాతో భాగించడంలో మరియు ప్రతికూల స్క్వేర్ రూట్లలో లోప సందేశాలు తిరిగి ఇస్తాయి

**అందుబాటులో ఉన్న ఆపరేషన్లు:**
- `add(a, b)` - రెండు సంఖ్యలను కలుపుతుంది
- `subtract(a, b)` - రెండవ సంఖ్యను మొదటిదానితో తీసివేస్తుంది
- `multiply(a, b)` - రెండు సంఖ్యలను గుణిస్తుంది
- `divide(a, b)` - మొదటిదానిని రెండవదానితో భాగిస్తుంది (సున్నా తనిఖీతో)
- `power(base, exponent)` - బేస్‌ను ఎక్స్‌పోనెంట్ శక్తికి పెంచుతుంది
- `squareRoot(number)` - స్క్వేర్ రూట్ లెక్కిస్తుంది (ప్రతికూల తనిఖీతో)
- `modulus(a, b)` - భాగించడంలో మిగిలిన భాగాన్ని ఇస్తుంది
- `absolute(number)` - పరిపూర్ణ విలువను ఇస్తుంది
- `help()` - అన్ని ఆపరేషన్ల గురించి సమాచారం ఇస్తుంది

### 3. డైరెక్ట్ MCP క్లయింట్

**ఫైల్:** `SDKClient.java`

ఈ క్లయింట్ AI ఉపయోగించకుండా MCP సర్వర్‌తో నేరుగా మాట్లాడుతుంది. ఇది ప్రత్యేకమైన కాలిక్యులేటర్ ఫంక్షన్లను మాన్యువల్‌గా కాల్ చేస్తుంది:

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
        
        // అందుబాటులో ఉన్న సాధనాలను జాబితా చేయండి
        ListToolsResult toolsList = client.listTools();
        System.out.println("Available Tools = " + toolsList);
        
        // నిర్దిష్ట కాలిక్యులేటర్ ఫంక్షన్లను కాల్ చేయండి
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

**ఇది ఏమి చేస్తుంది:**
1. **కనెక్ట్ అవుతుంది**: `http://localhost:8080` వద్ద కాలిక్యులేటర్ సర్వర్‌కు బిల్డర్ ప్యాటర్న్ ఉపయోగించి
2. **సాధనాలను జాబితా చేస్తుంది**: అందుబాటులో ఉన్న అన్ని కాలిక్యులేటర్ ఫంక్షన్లు
3. **ప్రత్యేకమైన ఫంక్షన్లను కాల్ చేస్తుంది**: ఖచ్చితమైన పారామీటర్లతో
4. **ఫలితాలను నేరుగా ప్రింట్ చేస్తుంది**

**గమనిక:** ఈ ఉదాహరణ Spring AI 1.1.0-SNAPSHOT డిపెండెన్సీని ఉపయోగిస్తుంది, ఇది `WebFluxSseClientTransport` కోసం బిల్డర్ ప్యాటర్న్‌ను పరిచయం చేసింది. మీరు పాత స్థిరమైన వెర్షన్‌ను ఉపయోగిస్తే, మీరు నేరుగా కన్‌స్ట్రక్టర్‌ను ఉపయోగించవలసి రావచ్చు.

**ఎప్పుడు ఉపయోగించాలి:** మీరు ఏ గణన చేయాలో ఖచ్చితంగా తెలుసుకుని, ప్రోగ్రామేటిక్‌గా దానిని కాల్ చేయాలనుకుంటే.

### 4. AI ఆధారిత క్లయింట్

**ఫైల్:** `LangChain4jClient.java`

ఈ క్లయింట్ AI మోడల్ (GPT-4o-mini) ను ఉపయోగిస్తుంది, ఇది స్వయంచాలకంగా ఏ కాలిక్యులేటర్ సాధనాలను ఉపయోగించాలో నిర్ణయించగలదు:

```java
public class LangChain4jClient {
    
    public static void main(String[] args) throws Exception {
        // AI మోడల్‌ను సెటప్ చేయండి (GitHub మోడల్స్ ఉపయోగించి)
        ChatLanguageModel model = OpenAiOfficialChatModel.builder()
                .isGitHubModels(true)
                .apiKey(System.getenv("GITHUB_TOKEN"))
                .modelName("gpt-4o-mini")
                .build();

        // మా క్యాలిక్యులేటర్ MCP సర్వర్‌కు కనెక్ట్ అవ్వండి
        McpTransport transport = new HttpMcpTransport.Builder()
                .sseUrl("http://localhost:8080/sse")
                .logRequests(true)  // AI ఏమి చేస్తున్నదో చూపిస్తుంది
                .logResponses(true)
                .build();

        McpClient mcpClient = new DefaultMcpClient.Builder()
                .transport(transport)
                .build();

        // AI కి మా క్యాలిక్యులేటర్ టూల్స్ యాక్సెస్ ఇవ్వండి
        ToolProvider toolProvider = McpToolProvider.builder()
                .mcpClients(List.of(mcpClient))
                .build();

        // మా క్యాలిక్యులేటర్ ఉపయోగించగల AI బాట్‌ను సృష్టించండి
        Bot bot = AiServices.builder(Bot.class)
                .chatLanguageModel(model)
                .toolProvider(toolProvider)
                .build();

        // ఇప్పుడు AI ను సహజ భాషలో లెక్కలు చేయమని అడగవచ్చు
        String response = bot.chat("Calculate the sum of 24.5 and 17.3 using the calculator service");
        System.out.println(response);

        response = bot.chat("What's the square root of 144?");
        System.out.println(response);
    }
}
```

**ఇది ఏమి చేస్తుంది:**
1. **AI మోడల్ కనెక్షన్** GitHub టోకెన్ ఉపయోగించి సృష్టిస్తుంది
2. **మన కాలిక్యులేటర్ MCP సర్వర్‌కు కనెక్ట్ అవుతుంది**
3. **AIకి అన్ని కాలిక్యులేటర్ సాధనాలను అందిస్తుంది**
4. **సహజ భాష అభ్యర్థనలను అనుమతిస్తుంది**: "24.5 మరియు 17.3 యొక్క మొత్తం లెక్కించు"

**AI స్వయంచాలకంగా:**
- మీరు సంఖ్యలను కలపాలని అర్థం చేసుకుంటుంది
- `add` సాధనాన్ని ఎంచుకుంటుంది
- `add(24.5, 17.3)` ను కాల్ చేస్తుంది
- ఫలితాన్ని సహజమైన ప్రతిస్పందనలో ఇస్తుంది

## ఉదాహరణలను నడపడం

### దశ 1: కాలిక్యులేటర్ సర్వర్‌ను ప్రారంభించండి

మొదట, మీ GitHub టోకెన్ సెట్ చేయండి (AI క్లయింట్ కోసం అవసరం):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

సర్వర్‌ను ప్రారంభించండి:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

సర్వర్ `http://localhost:8080` లో ప్రారంభమవుతుంది. మీరు చూడవలసినది:
```
Started McpServerApplication in X.XXX seconds
```

### దశ 2: డైరెక్ట్ క్లయింట్‌తో పరీక్షించండి

**కొత్త** టెర్మినల్‌లో, సర్వర్ ఇంకా నడుస్తున్నప్పుడు, డైరెక్ట్ MCP క్లయింట్‌ను నడపండి:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

మీరు ఈ విధంగా అవుట్‌పుట్‌ను చూస్తారు:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### దశ 3: AI క్లయింట్‌తో పరీక్షించండి

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

AI సాధనాలను స్వయంచాలకంగా ఉపయోగిస్తున్నట్లు మీరు చూస్తారు:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### దశ 4: MCP సర్వర్‌ను మూసివేయండి

పరీక్ష పూర్తయిన తర్వాత, AI క్లయింట్‌ను దాని టెర్మినల్‌లో `Ctrl+C` నొక్కి ఆపవచ్చు. MCP సర్వర్ మీరు ఆపే వరకు నడుస్తూనే ఉంటుంది.
సర్వర్‌ను ఆపడానికి, అది నడుస్తున్న టెర్మినల్‌లో `Ctrl+C` నొక్కండి.

## అన్నీ కలిసి ఎలా పనిచేస్తాయి

మీరు AIని "5 + 3 ఎంత?" అని అడిగినప్పుడు మొత్తం ప్రాసెస్ ఇలా ఉంటుంది:

1. **మీరు** సహజ భాషలో AIని అడుగుతారు
2. **AI** మీ అభ్యర్థనను విశ్లేషించి మీరు కలపాలని అర్థం చేసుకుంటుంది
3. **AI** MCP సర్వర్‌ను కాల్ చేస్తుంది: `add(5.0, 3.0)`
4. **కాలిక్యులేటర్ సర్వీస్** లెక్కిస్తుంది: `5.0 + 3.0 = 8.0`
5. **కాలిక్యులేటర్ సర్వీస్** తిరిగి ఇస్తుంది: `"5.00 + 3.00 = 8.00"`
6. **AI** ఫలితాన్ని స్వీకరించి సహజమైన ప్రతిస్పందనగా ఫార్మాట్ చేస్తుంది
7. **మీకు** అందుతుంది: "5 మరియు 3 యొక్క మొత్తం 8"

## తదుపరి దశలు

మరిన్ని ఉదాహరణల కోసం, [Chapter 04: Practical samples](../README.md) చూడండి

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**అస్వీకరణ**:  
ఈ పత్రం AI అనువాద సేవ [Co-op Translator](https://github.com/Azure/co-op-translator) ఉపయోగించి అనువదించబడింది. మేము ఖచ్చితత్వానికి ప్రయత్నిస్తున్నప్పటికీ, ఆటోమేటెడ్ అనువాదాలు తప్పులు లేదా అసమగ్రతలను కలిగి ఉండవచ్చు. దాని స్వదేశ భాషలో ఉన్న అసలు పత్రాన్ని అధికారం కలిగిన మూలంగా పరిగణించాలి. కీలకమైన సమాచారం కోసం, ప్రొఫెషనల్ మానవ అనువాదాన్ని సిఫారసు చేస్తాము. ఈ అనువాదాన్ని ఉపయోగించడం వల్ల కలిగే ఏవైనా అపార్థాలు లేదా తప్పుదారులు కోసం మేము బాధ్యత వహించము.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->