<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b6c16b5514d524e415a94f6097ee7d4c",
  "translation_date": "2025-09-18T15:29:21+00:00",
  "source_file": "04-PracticalSamples/calculator/README.md",
  "language_code": "ne"
}
-->
# MCP क्यालकुलेटर ट्युटोरियल शुरुवातकर्ताहरूका लागि

## सामग्री तालिका

- [तपाईंले के सिक्नुहुनेछ](../../../../04-PracticalSamples/calculator)
- [पूर्वआवश्यकताहरू](../../../../04-PracticalSamples/calculator)
- [प्रोजेक्ट संरचना बुझ्दै](../../../../04-PracticalSamples/calculator)
- [मुख्य कम्पोनेन्टहरूको व्याख्या](../../../../04-PracticalSamples/calculator)
  - [१. मुख्य एप्लिकेशन](../../../../04-PracticalSamples/calculator)
  - [२. क्यालकुलेटर सेवा](../../../../04-PracticalSamples/calculator)
  - [३. प्रत्यक्ष MCP क्लाइन्ट](../../../../04-PracticalSamples/calculator)
  - [४. एआई-संचालित क्लाइन्ट](../../../../04-PracticalSamples/calculator)
- [उदाहरणहरू चलाउँदै](../../../../04-PracticalSamples/calculator)
- [सबै कुरा कसरी सँगै काम गर्छ](../../../../04-PracticalSamples/calculator)
- [अर्को चरणहरू](../../../../04-PracticalSamples/calculator)

## तपाईंले के सिक्नुहुनेछ

यो ट्युटोरियलले मोडेल कन्टेक्स्ट प्रोटोकल (MCP) प्रयोग गरेर क्यालकुलेटर सेवा कसरी निर्माण गर्ने भनेर व्याख्या गर्दछ। तपाईंले बुझ्नुहुनेछ:

- एआईले उपकरणको रूपमा प्रयोग गर्न सक्ने सेवा कसरी बनाउने
- MCP सेवाहरूसँग प्रत्यक्ष सञ्चार कसरी सेटअप गर्ने
- एआई मोडेलहरूले कुन उपकरण प्रयोग गर्ने भनेर स्वतः कसरी छनोट गर्न सक्छ
- प्रत्यक्ष प्रोटोकल कलहरू र एआई-सहायता अन्तर्क्रियाहरू बीचको भिन्नता

## पूर्वआवश्यकताहरू

सुरु गर्नु अघि, सुनिश्चित गर्नुहोस् कि तपाईंले:
- Java 21 वा उच्च संस्करण स्थापना गर्नुभएको छ
- Maven निर्भरता व्यवस्थापनको लागि
- व्यक्तिगत पहुँच टोकन (PAT) सहित GitHub खाता
- Java र Spring Boot को आधारभूत ज्ञान

## प्रोजेक्ट संरचना बुझ्दै

क्यालकुलेटर प्रोजेक्टमा केही महत्त्वपूर्ण फाइलहरू छन्:

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

## मुख्य कम्पोनेन्टहरूको व्याख्या

### १. मुख्य एप्लिकेशन

**फाइल:** `McpServerApplication.java`

यो हाम्रो क्यालकुलेटर सेवाको प्रवेश बिन्दु हो। यो एक मानक Spring Boot एप्लिकेशन हो जसमा एउटा विशेष थप छ:

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

**यसले के गर्छ:**
- पोर्ट 8080 मा Spring Boot वेब सर्भर सुरु गर्छ
- `ToolCallbackProvider` सिर्जना गर्छ जसले हाम्रो क्यालकुलेटर विधिहरू MCP उपकरणको रूपमा उपलब्ध गराउँछ
- `@Bean` एनोटेसनले Spring लाई यसलाई अन्य भागहरूले प्रयोग गर्न सक्ने कम्पोनेन्टको रूपमा व्यवस्थापन गर्न भन्छ

### २. क्यालकुलेटर सेवा

**फाइल:** `CalculatorService.java`

यहीँ सबै गणितीय कार्यहरू हुन्छन्। प्रत्येक विधि `@Tool` द्वारा चिन्हित गरिएको छ ताकि यो MCP मार्फत उपलब्ध होस्:

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

**मुख्य विशेषताहरू:**

1. **`@Tool` एनोटेसन**: यसले MCP लाई बताउँछ कि यो विधि बाह्य क्लाइन्टहरूले कल गर्न सक्छ
2. **स्पष्ट विवरणहरू**: प्रत्येक उपकरणसँग विवरण हुन्छ जसले एआई मोडेलहरूलाई यो कहिले प्रयोग गर्ने भनेर बुझ्न मद्दत गर्छ
3. **सुसंगत प्रतिफल ढाँचा**: सबै अपरेसनहरूले "5.00 + 3.00 = 8.00" जस्ता मानव-पढ्न योग्य स्ट्रिङहरू फर्काउँछन्
4. **त्रुटि ह्यान्डलिङ**: शून्यद्वारा भाग र नकारात्मक वर्गमूल त्रुटि सन्देशहरू फर्काउँछन्

**उपलब्ध अपरेसनहरू:**
- `add(a, b)` - दुई संख्याहरू जोड्छ
- `subtract(a, b)` - दोस्रोलाई पहिलोबाट घटाउँछ
- `multiply(a, b)` - दुई संख्याहरू गुणा गर्छ
- `divide(a, b)` - पहिलोलाई दोस्रोद्वारा भाग गर्छ (शून्य-जाँच सहित)
- `power(base, exponent)` - आधारलाई घातांकमा उठाउँछ
- `squareRoot(number)` - वर्गमूल गणना गर्छ (नकारात्मक जाँच सहित)
- `modulus(a, b)` - भागको बाँकी भाग फर्काउँछ
- `absolute(number)` - पूर्ण मान फर्काउँछ
- `help()` - सबै अपरेसनहरूको जानकारी फर्काउँछ

### ३. प्रत्यक्ष MCP क्लाइन्ट

**फाइल:** `SDKClient.java`

यो क्लाइन्टले एआई प्रयोग नगरी MCP सर्भरसँग प्रत्यक्ष कुरा गर्छ। यसले विशिष्ट क्यालकुलेटर कार्यहरू म्यानुअली कल गर्छ:

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

**यसले के गर्छ:**
1. **कनेक्ट गर्छ** क्यालकुलेटर सर्भरमा `http://localhost:8080` प्रयोग गरेर बिल्डर ढाँचा
2. **सूचीबद्ध गर्छ** सबै उपलब्ध उपकरणहरू (हाम्रो क्यालकुलेटर कार्यहरू)
3. **कल गर्छ** विशिष्ट कार्यहरू ठ्याक्कै प्यारामिटरहरूसँग
4. **प्रतिफलहरू** प्रत्यक्ष प्रिन्ट गर्छ

**नोट:** यो उदाहरणले Spring AI 1.1.0-SNAPSHOT निर्भरता प्रयोग गर्छ, जसले `WebFluxSseClientTransport` को लागि बिल्डर ढाँचा प्रस्तुत गर्यो। यदि तपाईं पुरानो स्थिर संस्करण प्रयोग गर्दै हुनुहुन्छ भने, तपाईंले प्रत्यक्ष कन्स्ट्रक्टर प्रयोग गर्न आवश्यक हुन सक्छ।

**कहिले प्रयोग गर्ने:** जब तपाईंलाई ठ्याक्कै कुन गणना गर्न चाहनुहुन्छ थाहा छ र यसलाई प्रोग्राममार्फत कल गर्न चाहनुहुन्छ।

### ४. एआई-संचालित क्लाइन्ट

**फाइल:** `LangChain4jClient.java`

यो क्लाइन्टले एआई मोडेल (GPT-4o-mini) प्रयोग गर्छ जसले स्वतः निर्णय गर्न सक्छ कि कुन क्यालकुलेटर उपकरण प्रयोग गर्ने:

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

**यसले के गर्छ:**
1. **एआई मोडेल कनेक्शन सिर्जना गर्छ** तपाईंको GitHub टोकन प्रयोग गरेर
2. **हाम्रो क्यालकुलेटर MCP सर्भरसँग कनेक्ट गर्छ**
3. **एआईलाई सबै क्यालकुलेटर उपकरणहरूमा पहुँच दिन्छ**
4. **प्राकृतिक भाषा अनुरोधहरू अनुमति दिन्छ** जस्तै "24.5 र 17.3 को योग गणना गर्नुहोस्"

**एआईले स्वतः:**
- बुझ्छ कि तपाईं संख्याहरू जोड्न चाहनुहुन्छ
- `add` उपकरण चयन गर्छ
- `add(24.5, 17.3)` कल गर्छ
- प्राकृतिक प्रतिफलमा परिणाम फर्काउँछ

## उदाहरणहरू चलाउँदै

### चरण १: क्यालकुलेटर सर्भर सुरु गर्नुहोस्

पहिले, तपाईंको GitHub टोकन सेट गर्नुहोस् (एआई क्लाइन्टको लागि आवश्यक):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

सर्भर सुरु गर्नुहोस्:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

सर्भर `http://localhost:8080` मा सुरु हुनेछ। तपाईंले देख्नुहुनेछ:
```
Started McpServerApplication in X.XXX seconds
```

### चरण २: प्रत्यक्ष क्लाइन्टसँग परीक्षण गर्नुहोस्

**नयाँ** टर्मिनलमा सर्भर अझै चलिरहेको अवस्थामा, प्रत्यक्ष MCP क्लाइन्ट चलाउनुहोस्:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

तपाईंले यस्तो आउटपुट देख्नुहुनेछ:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### चरण ३: एआई क्लाइन्टसँग परीक्षण गर्नुहोस्

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

तपाईंले एआईले उपकरणहरू स्वतः प्रयोग गरेको देख्नुहुनेछ:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### चरण ४: MCP सर्भर बन्द गर्नुहोस्

परीक्षण सकिएपछि, एआई क्लाइन्ट बन्द गर्न यसको टर्मिनलमा `Ctrl+C` थिच्न सक्नुहुन्छ। MCP सर्भर तपाईंले बन्द नगरेसम्म चलिरहन्छ।
सर्भर बन्द गर्न, यो चलिरहेको टर्मिनलमा `Ctrl+C` थिच्नुहोस्।

## सबै कुरा कसरी सँगै काम गर्छ

जब तपाईं एआईलाई "५ + ३ के हो?" सोध्नुहुन्छ, यहाँ पूरा प्रक्रिया छ:

1. **तपाईं** एआईलाई प्राकृतिक भाषामा सोध्नुहुन्छ
2. **एआई** तपाईंको अनुरोध विश्लेषण गर्छ र बुझ्छ कि तपाईंलाई जोड्न चाहिएको छ
3. **एआई** MCP सर्भरलाई कल गर्छ: `add(5.0, 3.0)`
4. **क्यालकुलेटर सेवा** प्रदर्शन गर्छ: `5.0 + 3.0 = 8.0`
5. **क्यालकुलेटर सेवा** फर्काउँछ: `"5.00 + 3.00 = 8.00"`
6. **एआई** परिणाम प्राप्त गर्छ र प्राकृतिक प्रतिफलमा ढाँचा बनाउँछ
7. **तपाईं** प्राप्त गर्नुहुन्छ: "५ र ३ को योग ८ हो"

## अर्को चरणहरू

थप उदाहरणहरूको लागि, [अध्याय ०४: व्यावहारिक नमूनाहरू](../README.md) हेर्नुहोस्।

---

**अस्वीकरण**:  
यो दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) प्रयोग गरेर अनुवाद गरिएको छ। हामी शुद्धताको लागि प्रयास गर्छौं, तर कृपया ध्यान दिनुहोस् कि स्वचालित अनुवादमा त्रुटिहरू वा अशुद्धताहरू हुन सक्छ। यसको मूल भाषा मा रहेको मूल दस्तावेज़लाई आधिकारिक स्रोत मानिनुपर्छ। महत्वपूर्ण जानकारीको लागि, व्यावसायिक मानव अनुवाद सिफारिस गरिन्छ। यस अनुवादको प्रयोगबाट उत्पन्न हुने कुनै पनि गलतफहमी वा गलत व्याख्याको लागि हामी जिम्मेवार हुने छैनौं।