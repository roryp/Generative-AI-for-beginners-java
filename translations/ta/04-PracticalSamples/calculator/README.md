# MCP கணக்கீடு டுடோரியல் தொடக்கநிலை பயிற்சி

## உள்ளடக்க அட்டவணை

- [நீங்கள் கற்றுக்கொள்ளப்போகிறீர்கள்](../../../../04-PracticalSamples/calculator)
- [முன்னேற்பாடுகள்](../../../../04-PracticalSamples/calculator)
- [திட்ட அமைப்பை புரிந்துகொள்வது](../../../../04-PracticalSamples/calculator)
- [முக்கிய கூறுகள் விளக்கம்](../../../../04-PracticalSamples/calculator)
  - [1. முக்கிய பயன்பாடு](../../../../04-PracticalSamples/calculator)
  - [2. கணக்கீட்டு சேவை](../../../../04-PracticalSamples/calculator)
  - [3. நேரடி MCP கிளையன்ட்](../../../../04-PracticalSamples/calculator)
  - [4. AI இயக்கப்படும் கிளையன்ட்](../../../../04-PracticalSamples/calculator)
- [எடுத்துக்காட்டுகளை இயக்குவது](../../../../04-PracticalSamples/calculator)
- [அனைத்தும் எப்படி ஒருங்கிணைக்கப்படுகிறது](../../../../04-PracticalSamples/calculator)
- [அடுத்த படிகள்](../../../../04-PracticalSamples/calculator)

## நீங்கள் கற்றுக்கொள்ளப்போகிறீர்கள்

இந்த டுடோரியல் Model Context Protocol (MCP) பயன்படுத்தி கணக்கீட்டு சேவையை உருவாக்குவது எப்படி என்பதை விளக்குகிறது. நீங்கள் புரிந்துகொள்வீர்கள்:

- AI ஒரு கருவியாக பயன்படுத்தக்கூடிய சேவையை உருவாக்குவது எப்படி
- MCP சேவைகளுடன் நேரடி தொடர்பை அமைப்பது எப்படி
- AI மாடல்கள் எந்த கருவிகளை பயன்படுத்த வேண்டும் என்பதை தானாக தேர்வு செய்வது எப்படி
- நேரடி புரோட்டோகால் அழைப்புகள் மற்றும் AI உதவியுடன் செயல்பாடுகளின் வித்தியாசம்

## முன்னேற்பாடுகள்

தொடங்குவதற்கு முன், உங்களிடம் இருக்க வேண்டும்:
- Java 21 அல்லது அதற்கு மேல் நிறுவப்பட்டிருக்க வேண்டும்
- Maven dependency மேலாண்மைக்காக
- GitHub கணக்கு மற்றும் தனிப்பட்ட அணுகல் டோக்கன் (PAT)
- Java மற்றும் Spring Boot அடிப்படை அறிவு

## திட்ட அமைப்பை புரிந்துகொள்வது

கணக்கீட்டு திட்டத்தில் சில முக்கிய கோப்புகள் உள்ளன:

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

## முக்கிய கூறுகள் விளக்கம்

### 1. முக்கிய பயன்பாடு

**கோப்பு:** `McpServerApplication.java`

இது எங்கள் கணக்கீட்டு சேவையின் நுழைவு புள்ளியாகும். இது ஒரு ஸ்டாண்டர்ட் Spring Boot பயன்பாடு, ஆனால் ஒரு சிறப்பு சேர்க்கையுடன்:

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

**இது என்ன செய்கிறது:**
- 8080 போர்டில் Spring Boot வலை சேவையகத்தை தொடங்குகிறது
- எங்கள் கணக்கீட்டு முறைகளை MCP கருவிகளாக கிடைக்கச் செய்ய `ToolCallbackProvider` உருவாக்குகிறது
- `@Bean` annotation Spring-க்கு இதை மற்ற பகுதிகள் பயன்படுத்தக்கூடிய கூறாக நிர்வகிக்கச் செய்கிறது

### 2. கணக்கீட்டு சேவை

**கோப்பு:** `CalculatorService.java`

இது அனைத்து கணக்கீடுகளும் நடைபெறும் இடம். ஒவ்வொரு முறையும் `@Tool` மூலம் MCP மூலம் கிடைக்கச் செய்யப்படுகிறது:

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

**முக்கிய அம்சங்கள்:**

1. **`@Tool` Annotation**: இது MCP-க்கு இந்த முறை வெளிப்புற கிளையன்ட்களால் அழைக்கப்படக்கூடியது என்பதை தெரிவிக்கிறது
2. **தெளிவான விளக்கங்கள்**: ஒவ்வொரு கருவிக்கும் AI மாடல்கள் எப்போது பயன்படுத்த வேண்டும் என்பதை புரிந்துகொள்ள உதவும் விளக்கம் உள்ளது
3. **நிலையான திரும்பும் வடிவம்**: அனைத்து செயல்பாடுகளும் "5.00 + 3.00 = 8.00" போன்ற மனிதர்களுக்கு புரிந்துகொள்ளக்கூடிய சரம் வடிவில் திரும்புகின்றன
4. **பிழை கையாளுதல்**: பூஜ்யமாக பிரித்தல் மற்றும் எதிர்மறை சதுர வேர் பிழை செய்திகளை திரும்பச் செய்கிறது

**கிடைக்கக்கூடிய செயல்பாடுகள்:**
- `add(a, b)` - இரண்டு எண்களை கூட்டுகிறது
- `subtract(a, b)` - இரண்டாவது எண்ணை முதல் எண்ணிலிருந்து கழிக்கிறது
- `multiply(a, b)` - இரண்டு எண்களை பெருக்குகிறது
- `divide(a, b)` - முதல் எண்ணை இரண்டாவது எண்ணால் பிரிக்கிறது (பூஜ்யம் சரிபார்ப்பு உடன்)
- `power(base, exponent)` - அடிப்படை எண்ணை எக்ஸ்போனென்ட் அளவுக்கு உயர்த்துகிறது
- `squareRoot(number)` - சதுர வேர் கணக்கிடுகிறது (எதிர்மறை சரிபார்ப்பு உடன்)
- `modulus(a, b)` - பிரித்தலின் மீதமுள்ள மதிப்பை திரும்பச் செய்கிறது
- `absolute(number)` - முழுமையான மதிப்பை திரும்பச் செய்கிறது
- `help()` - அனைத்து செயல்பாடுகள் பற்றிய தகவலை திரும்பச் செய்கிறது

### 3. நேரடி MCP கிளையன்ட்

**கோப்பு:** `SDKClient.java`

இந்த கிளையன்ட் AI பயன்படுத்தாமல் MCP சேவையகத்துடன் நேரடியாக பேசுகிறது. இது குறிப்பிட்ட கணக்கீட்டு செயல்பாடுகளை கையேடு முறையில் அழைக்கிறது:

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

**இது என்ன செய்கிறது:**
1. **சேவையகத்துடன் இணைக்கிறது** `http://localhost:8080` ஐ builder pattern மூலம்
2. **அனைத்து கருவிகளை பட்டியலிடுகிறது** (எங்கள் கணக்கீட்டு செயல்பாடுகள்)
3. **குறிப்பிட்ட செயல்பாடுகளை** துல்லியமான அளவுருக்களுடன் அழைக்கிறது
4. **முடிவுகளை நேரடியாக அச்சிடுகிறது**

**குறிப்பு:** இந்த எடுத்துக்காட்டில் Spring AI 1.1.0-SNAPSHOT dependency பயன்படுத்தப்படுகிறது, இது `WebFluxSseClientTransport` க்கான builder pattern ஐ அறிமுகப்படுத்தியது. நீங்கள் பழைய நிலையான பதிப்பைப் பயன்படுத்தினால், நேரடி constructor ஐ பயன்படுத்த வேண்டியிருக்கும்.

**எப்போது பயன்படுத்த வேண்டும்:** நீங்கள் எந்த கணக்கீட்டை செய்ய வேண்டும் என்பதை துல்லியமாக அறிந்திருக்கும்போது, அதை நிரலாக்க முறையில் அழைக்க விரும்பினால்.

### 4. AI இயக்கப்படும் கிளையன்ட்

**கோப்பு:** `LangChain4jClient.java`

இந்த கிளையன்ட் AI மாடல் (GPT-4o-mini) ஐ பயன்படுத்துகிறது, இது எந்த கணக்கீட்டு கருவிகளை தானாக தேர்வு செய்ய முடியும்:

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

**இது என்ன செய்கிறது:**
1. **AI மாடல் இணைப்பை உருவாக்குகிறது** உங்கள் GitHub டோக்கன் பயன்படுத்தி
2. **AI ஐ எங்கள் MCP சேவையகத்துடன் இணைக்கிறது**
3. **AI க்கு எங்கள் கணக்கீட்டு கருவிகளுக்கு அணுகலை வழங்குகிறது**
4. **இயற்கை மொழி கோரிக்கைகளை அனுமதிக்கிறது** "24.5 மற்றும் 17.3 இன் கூட்டத்தை கணக்கிடுங்கள்" போன்றவை

**AI தானாக:**
- நீங்கள் எண்களை கூட்ட வேண்டும் என்பதை புரிந்துகொள்கிறது
- `add` கருவியை தேர்வு செய்கிறது
- `add(24.5, 17.3)` ஐ அழைக்கிறது
- இயற்கை பதிலில் முடிவை திரும்பச் செய்கிறது

## எடுத்துக்காட்டுகளை இயக்குவது

### படி 1: கணக்கீட்டு சேவையகத்தை தொடங்குங்கள்

முதலில், உங்கள் GitHub டோக்கனை அமைக்கவும் (AI கிளையன்டுக்கு தேவை):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

சேவையகத்தை தொடங்குங்கள்:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

சேவையகம் `http://localhost:8080` இல் தொடங்கும். நீங்கள் காண வேண்டும்:
```
Started McpServerApplication in X.XXX seconds
```

### படி 2: நேரடி கிளையன்டுடன் சோதிக்கவும்

**புதிய** டெர்மினலில், சேவையகம் இன்னும் இயங்கிக்கொண்டிருக்க, நேரடி MCP கிளையன்டை இயக்கவும்:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

நீங்கள் இதுபோன்ற வெளியீட்டை காண்பீர்கள்:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### படி 3: AI கிளையன்டுடன் சோதிக்கவும்

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

AI கருவிகளை தானாக பயன்படுத்துவதை நீங்கள் காண்பீர்கள்:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### படி 4: MCP சேவையகத்தை மூடுங்கள்

சோதனை முடிந்ததும், அதன் டெர்மினலில் `Ctrl+C` அழுத்தி AI கிளையன்டை நிறுத்தலாம். MCP சேவையகம் நீங்கள் அதை நிறுத்தும் வரை இயங்கிக்கொண்டிருக்கும்.
சேவையகத்தை நிறுத்த, அது இயங்கும் டெர்மினலில் `Ctrl+C` அழுத்தவும்.

## அனைத்தும் எப்படி ஒருங்கிணைக்கப்படுகிறது

நீங்கள் AI-யிடம் "5 + 3 என்ன?" என்று கேட்கும்போது முழு செயல்பாடு இதுதான்:

1. **நீங்கள்** இயற்கை மொழியில் AI-யிடம் கேட்கிறீர்கள்
2. **AI** உங்கள் கோரிக்கையை பகுப்பாய்வு செய்து நீங்கள் கூட்டம் செய்ய வேண்டும் என்பதை புரிந்துகொள்கிறது
3. **AI** MCP சேவையகத்தை அழைக்கிறது: `add(5.0, 3.0)`
4. **கணக்கீட்டு சேவை** செயல்படுத்துகிறது: `5.0 + 3.0 = 8.0`
5. **கணக்கீட்டு சேவை** திரும்பச் செய்கிறது: `"5.00 + 3.00 = 8.00"`
6. **AI** முடிவை பெறுகிறது மற்றும் இயற்கை பதிலாக வடிவமைக்கிறது
7. **நீங்கள்** பெறுகிறீர்கள்: "5 மற்றும் 3 இன் கூட்டம் 8"

## அடுத்த படிகள்

மேலும் எடுத்துக்காட்டுகளுக்கு, [அத்தியாயம் 04: நடைமுறை மாதிரிகள்](../README.md) ஐ பார்க்கவும்

---

**குறிப்பு**:  
இந்த ஆவணம் [Co-op Translator](https://github.com/Azure/co-op-translator) என்ற AI மொழிபெயர்ப்பு சேவையை பயன்படுத்தி மொழிபெயர்க்கப்பட்டுள்ளது. நாங்கள் துல்லியத்திற்காக முயற்சிக்கின்றோம், ஆனால் தானியங்கி மொழிபெயர்ப்புகளில் பிழைகள் அல்லது தவறான தகவல்கள் இருக்கக்கூடும் என்பதை கவனத்தில் கொள்ளவும். அதன் தாய்மொழியில் உள்ள மூல ஆவணம் அதிகாரப்பூர்வ ஆதாரமாக கருதப்பட வேண்டும். முக்கியமான தகவல்களுக்கு, தொழில்முறை மனித மொழிபெயர்ப்பு பரிந்துரைக்கப்படுகிறது. இந்த மொழிபெயர்ப்பைப் பயன்படுத்துவதால் ஏற்படும் எந்த தவறான புரிதல்கள் அல்லது தவறான விளக்கங்களுக்கு நாங்கள் பொறுப்பல்ல.