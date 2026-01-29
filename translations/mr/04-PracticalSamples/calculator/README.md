# MCP कॅल्क्युलेटर ट्यूटोरियल नवशिक्यांसाठी

## विषय सूची

- [तुम्ही काय शिकाल](../../../../04-PracticalSamples/calculator)
- [पूर्वतयारी](../../../../04-PracticalSamples/calculator)
- [प्रोजेक्टची रचना समजून घेणे](../../../../04-PracticalSamples/calculator)
- [मुख्य घटकांचे स्पष्टीकरण](../../../../04-PracticalSamples/calculator)
  - [1. मुख्य अॅप्लिकेशन](../../../../04-PracticalSamples/calculator)
  - [2. कॅल्क्युलेटर सेवा](../../../../04-PracticalSamples/calculator)
  - [3. डायरेक्ट MCP क्लायंट](../../../../04-PracticalSamples/calculator)
  - [4. AI-सक्षम क्लायंट](../../../../04-PracticalSamples/calculator)
- [उदाहरण चालवणे](../../../../04-PracticalSamples/calculator)
- [सर्व काही एकत्र कसे कार्य करते](../../../../04-PracticalSamples/calculator)
- [पुढील पायऱ्या](../../../../04-PracticalSamples/calculator)

## तुम्ही काय शिकाल

या ट्यूटोरियलमध्ये Model Context Protocol (MCP) वापरून कॅल्क्युलेटर सेवा कशी तयार करायची हे समजावले आहे. तुम्ही शिकाल:

- AI साठी टूल म्हणून सेवा कशी तयार करायची
- MCP सेवांसोबत थेट संवाद कसा सेट करायचा
- AI मॉडेल्स आपोआप कोणती टूल्स वापरायची ते कसे निवडतात
- थेट प्रोटोकॉल कॉल्स आणि AI-सह संवाद यामधील फरक

## पूर्वतयारी

सुरुवात करण्यापूर्वी, तुमच्याकडे खालील गोष्टी असाव्यात:
- Java 21 किंवा त्याहून अधिक आवृत्ती इंस्टॉल केलेली
- Maven डिपेंडन्सी व्यवस्थापनासाठी
- GitHub खाते आणि वैयक्तिक प्रवेश टोकन (PAT)
- Java आणि Spring Boot यांचे मूलभूत ज्ञान

## प्रोजेक्टची रचना समजून घेणे

कॅल्क्युलेटर प्रोजेक्टमध्ये काही महत्त्वाचे फाइल्स आहेत:

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

## मुख्य घटकांचे स्पष्टीकरण

### 1. मुख्य अॅप्लिकेशन

**फाइल:** `McpServerApplication.java`

हे आमच्या कॅल्क्युलेटर सेवेसाठी प्रवेश बिंदू आहे. हे एक मानक Spring Boot अॅप्लिकेशन आहे ज्यामध्ये एक विशेष जोड आहे:

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

**याचा उपयोग:**
- Spring Boot वेब सर्व्हर पोर्ट 8080 वर सुरू करतो
- `ToolCallbackProvider` तयार करतो, ज्यामुळे आमच्या कॅल्क्युलेटर पद्धती MCP टूल्स म्हणून उपलब्ध होतात
- `@Bean` अॅनोटेशन Spring ला हे घटक म्हणून व्यवस्थापित करण्यास सांगते जे इतर भाग वापरू शकतात

### 2. कॅल्क्युलेटर सेवा

**फाइल:** `CalculatorService.java`

इथे सर्व गणितीय क्रिया होतात. प्रत्येक पद्धती `@Tool` ने चिन्हांकित केली जाते ज्यामुळे ती MCP द्वारे उपलब्ध होते:

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

**महत्त्वाचे वैशिष्ट्ये:**

1. **`@Tool` अॅनोटेशन:** MCP ला सांगते की ही पद्धत बाह्य क्लायंट्सद्वारे कॉल केली जाऊ शकते
2. **स्पष्ट वर्णन:** प्रत्येक टूलमध्ये वर्णन असते जे AI मॉडेल्सना कधी वापरायचे ते समजण्यास मदत करते
3. **सुसंगत परतावा स्वरूप:** सर्व ऑपरेशन्स मानवी-वाचनीय स्ट्रिंग्स परत करतात जसे "5.00 + 3.00 = 8.00"
4. **त्रुटी हाताळणी:** शून्याने विभागणी आणि नकारात्मक वर्गमूळ त्रुटी संदेश परत करतात

**उपलब्ध ऑपरेशन्स:**
- `add(a, b)` - दोन संख्यांची बेरीज
- `subtract(a, b)` - दुसऱ्या संख्येने पहिली संख्या वजा करणे
- `multiply(a, b)` - दोन संख्यांचे गुणाकार
- `divide(a, b)` - पहिली संख्या दुसऱ्याने विभागणे (शून्य तपासणीसह)
- `power(base, exponent)` - बेसला एक्सपोनेंटने उचलणे
- `squareRoot(number)` - वर्गमूळ काढणे (नकारात्मक तपासणीसह)
- `modulus(a, b)` - विभागणीचा शिल्लक परत करणे
- `absolute(number)` - संख्येचे परिपूर्ण मूल्य परत करणे
- `help()` - सर्व ऑपरेशन्सबद्दल माहिती परत करणे

### 3. डायरेक्ट MCP क्लायंट

**फाइल:** `SDKClient.java`

हा क्लायंट AI वापरल्याशिवाय MCP सर्व्हरशी थेट संवाद साधतो. तो विशिष्ट कॅल्क्युलेटर फंक्शन्स मॅन्युअली कॉल करतो:

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

**याचा उपयोग:**
1. **कनेक्ट होते** कॅल्क्युलेटर सर्व्हरशी `http://localhost:8080` वर बिल्डर पॅटर्न वापरून
2. **सर्व टूल्सची यादी** तयार करतो (आमचे कॅल्क्युलेटर फंक्शन्स)
3. **विशिष्ट फंक्शन्स कॉल करतो** अचूक पॅरामीटर्ससह
4. **परिणाम थेट प्रिंट करतो**

**टीप:** या उदाहरणात Spring AI 1.1.0-SNAPSHOT डिपेंडन्सी वापरली आहे, ज्यामध्ये `WebFluxSseClientTransport` साठी बिल्डर पॅटर्न जोडले आहे. जर तुम्ही जुनी स्थिर आवृत्ती वापरत असाल, तर तुम्हाला थेट कन्स्ट्रक्टर वापरावा लागेल.

**कधी वापरायचे:** जेव्हा तुम्हाला अचूक गणना करायची आहे आणि ती प्रोग्रामॅटिकली कॉल करायची आहे.

### 4. AI-सक्षम क्लायंट

**फाइल:** `LangChain4jClient.java`

हा क्लायंट AI मॉडेल (GPT-4o-mini) वापरतो, जो आपोआप कोणती कॅल्क्युलेटर टूल्स वापरायची ते ठरवतो:

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

**याचा उपयोग:**
1. **AI मॉडेल कनेक्शन तयार करते** तुमच्या GitHub टोकन वापरून
2. **AI ला कनेक्ट करते** आमच्या कॅल्क्युलेटर MCP सर्व्हरशी
3. **AI ला सर्व कॅल्क्युलेटर टूल्स उपलब्ध करून देते**
4. **नैसर्गिक भाषेतील विनंत्या स्वीकारते** जसे "24.5 आणि 17.3 ची बेरीज करा"

**AI आपोआप:**
- तुमची विनंती समजते की तुम्हाला बेरीज करायची आहे
- `add` टूल निवडते
- `add(24.5, 17.3)` कॉल करते
- नैसर्गिक प्रतिसादात परिणाम परत करते

## उदाहरण चालवणे

### पायरी 1: कॅल्क्युलेटर सर्व्हर सुरू करा

सर्वप्रथम, तुमचे GitHub टोकन सेट करा (AI क्लायंटसाठी आवश्यक):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

सर्व्हर सुरू करा:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

सर्व्हर `http://localhost:8080` वर सुरू होईल. तुम्हाला दिसेल:
```
Started McpServerApplication in X.XXX seconds
```

### पायरी 2: डायरेक्ट क्लायंटसह चाचणी करा

**नवीन** टर्मिनलमध्ये, सर्व्हर चालू असताना, डायरेक्ट MCP क्लायंट चालवा:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

तुम्हाला असे आउटपुट दिसेल:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### पायरी 3: AI क्लायंटसह चाचणी करा

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

तुम्हाला AI टूल्स आपोआप वापरताना दिसेल:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### पायरी 4: MCP सर्व्हर बंद करा

चाचणी पूर्ण झाल्यावर, AI क्लायंट बंद करण्यासाठी त्याच्या टर्मिनलमध्ये `Ctrl+C` दाबा. MCP सर्व्हर तुम्ही थांबवले नाही तोपर्यंत चालू राहील.
सर्व्हर थांबवण्यासाठी, त्याच्या टर्मिनलमध्ये `Ctrl+C` दाबा.

## सर्व काही एकत्र कसे कार्य करते

जेव्हा तुम्ही AI ला विचारता "5 + 3 किती?" तेव्हा संपूर्ण प्रवाह असा असतो:

1. **तुम्ही** AI ला नैसर्गिक भाषेत विचारता
2. **AI** तुमची विनंती विश्लेषित करते आणि समजते की तुम्हाला बेरीज करायची आहे
3. **AI** MCP सर्व्हरला कॉल करते: `add(5.0, 3.0)`
4. **कॅल्क्युलेटर सेवा** गणना करते: `5.0 + 3.0 = 8.0`
5. **कॅल्क्युलेटर सेवा** परत करते: `"5.00 + 3.00 = 8.00"`
6. **AI** परिणाम प्राप्त करते आणि नैसर्गिक प्रतिसाद तयार करते
7. **तुम्हाला** मिळते: "5 आणि 3 ची बेरीज 8 आहे"

## पुढील पायऱ्या

अधिक उदाहरणांसाठी, [Chapter 04: Practical samples](../README.md) पहा.

---

**अस्वीकरण**:  
हा दस्तऐवज AI भाषांतर सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) वापरून भाषांतरित करण्यात आला आहे. आम्ही अचूकतेसाठी प्रयत्नशील असलो तरी कृपया लक्षात ठेवा की स्वयंचलित भाषांतरे त्रुटी किंवा अचूकतेच्या अभावाने युक्त असू शकतात. मूळ भाषेतील दस्तऐवज हा अधिकृत स्रोत मानला जावा. महत्त्वाच्या माहितीसाठी व्यावसायिक मानवी भाषांतराची शिफारस केली जाते. या भाषांतराचा वापर करून निर्माण होणाऱ्या कोणत्याही गैरसमज किंवा चुकीच्या अर्थासाठी आम्ही जबाबदार राहणार नाही.