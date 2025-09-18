<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b6c16b5514d524e415a94f6097ee7d4c",
  "translation_date": "2025-09-18T15:28:26+00:00",
  "source_file": "04-PracticalSamples/calculator/README.md",
  "language_code": "bn"
}
-->
# MCP ক্যালকুলেটর টিউটোরিয়াল নবাগতদের জন্য

## বিষয়সূচি

- [আপনি কী শিখবেন](../../../../04-PracticalSamples/calculator)
- [প্রয়োজনীয়তা](../../../../04-PracticalSamples/calculator)
- [প্রকল্পের কাঠামো বোঝা](../../../../04-PracticalSamples/calculator)
- [মূল উপাদানগুলোর ব্যাখ্যা](../../../../04-PracticalSamples/calculator)
  - [১. প্রধান অ্যাপ্লিকেশন](../../../../04-PracticalSamples/calculator)
  - [২. ক্যালকুলেটর সার্ভিস](../../../../04-PracticalSamples/calculator)
  - [৩. সরাসরি MCP ক্লায়েন্ট](../../../../04-PracticalSamples/calculator)
  - [৪. AI-চালিত ক্লায়েন্ট](../../../../04-PracticalSamples/calculator)
- [উদাহরণগুলো চালানো](../../../../04-PracticalSamples/calculator)
- [সবকিছু কীভাবে একসাথে কাজ করে](../../../../04-PracticalSamples/calculator)
- [পরবর্তী পদক্ষেপ](../../../../04-PracticalSamples/calculator)

## আপনি কী শিখবেন

এই টিউটোরিয়ালে Model Context Protocol (MCP) ব্যবহার করে একটি ক্যালকুলেটর সার্ভিস তৈরি করার পদ্ধতি ব্যাখ্যা করা হয়েছে। আপনি শিখবেন:

- কীভাবে একটি সার্ভিস তৈরি করবেন যা AI একটি টুল হিসেবে ব্যবহার করতে পারে
- MCP সার্ভিসের সাথে সরাসরি যোগাযোগ স্থাপন করার পদ্ধতি
- AI মডেল কীভাবে স্বয়ংক্রিয়ভাবে টুল নির্বাচন করতে পারে
- সরাসরি প্রোটোকল কল এবং AI-সহায়ক ইন্টারঅ্যাকশনের মধ্যে পার্থক্য

## প্রয়োজনীয়তা

শুরু করার আগে নিশ্চিত করুন যে আপনার কাছে রয়েছে:
- Java 21 বা তার বেশি সংস্করণ ইনস্টল করা
- Maven ডিপেনডেন্সি ম্যানেজমেন্টের জন্য
- একটি GitHub অ্যাকাউন্ট এবং ব্যক্তিগত অ্যাক্সেস টোকেন (PAT)
- Java এবং Spring Boot সম্পর্কে মৌলিক ধারণা

## প্রকল্পের কাঠামো বোঝা

ক্যালকুলেটর প্রকল্পে কয়েকটি গুরুত্বপূর্ণ ফাইল রয়েছে:

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

## মূল উপাদানগুলোর ব্যাখ্যা

### ১. প্রধান অ্যাপ্লিকেশন

**ফাইল:** `McpServerApplication.java`

এটি আমাদের ক্যালকুলেটর সার্ভিসের এন্ট্রি পয়েন্ট। এটি একটি স্ট্যান্ডার্ড Spring Boot অ্যাপ্লিকেশন, যেখানে একটি বিশেষ সংযোজন রয়েছে:

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

**এটি কী করে:**
- Spring Boot ওয়েব সার্ভার চালু করে পোর্ট 8080-এ
- একটি `ToolCallbackProvider` তৈরি করে যা আমাদের ক্যালকুলেটর মেথডগুলো MCP টুল হিসেবে উপলব্ধ করে
- `@Bean` অ্যানোটেশন Spring-কে নির্দেশ দেয় এটি একটি কম্পোনেন্ট হিসেবে পরিচালনা করতে যা অন্য অংশগুলো ব্যবহার করতে পারে

### ২. ক্যালকুলেটর সার্ভিস

**ফাইল:** `CalculatorService.java`

এখানেই সমস্ত গণনা সম্পন্ন হয়। প্রতিটি মেথড `@Tool` দিয়ে চিহ্নিত করা হয়েছে যাতে এটি MCP-এর মাধ্যমে উপলব্ধ হয়:

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

**মূল বৈশিষ্ট্য:**

1. **`@Tool` অ্যানোটেশন**: এটি MCP-কে জানায় যে এই মেথডটি বাইরের ক্লায়েন্ট দ্বারা কল করা যেতে পারে
2. **স্পষ্ট বিবরণ**: প্রতিটি টুলের একটি বিবরণ রয়েছে যা AI মডেলকে বুঝতে সাহায্য করে কখন এটি ব্যবহার করতে হবে
3. **সামঞ্জস্যপূর্ণ রিটার্ন ফরম্যাট**: সমস্ত অপারেশন মানব-পাঠযোগ্য স্ট্রিং রিটার্ন করে, যেমন "5.00 + 3.00 = 8.00"
4. **ত্রুটি পরিচালনা**: শূন্য দ্বারা ভাগ এবং নেতিবাচক স্কয়ার রুট ত্রুটি বার্তা রিটার্ন করে

**উপলব্ধ অপারেশন:**
- `add(a, b)` - দুটি সংখ্যা যোগ করে
- `subtract(a, b)` - প্রথম সংখ্যা থেকে দ্বিতীয়টি বিয়োগ করে
- `multiply(a, b)` - দুটি সংখ্যা গুণ করে
- `divide(a, b)` - প্রথম সংখ্যাকে দ্বিতীয় দ্বারা ভাগ করে (শূন্য-পরীক্ষাসহ)
- `power(base, exponent)` - বেসকে এক্সপোনেন্টের শক্তিতে উন্নীত করে
- `squareRoot(number)` - স্কয়ার রুট গণনা করে (নেতিবাচক পরীক্ষাসহ)
- `modulus(a, b)` - ভাগের অবশিষ্টাংশ প্রদান করে
- `absolute(number)` - পরম মান প্রদান করে
- `help()` - সমস্ত অপারেশনের তথ্য প্রদান করে

### ৩. সরাসরি MCP ক্লায়েন্ট

**ফাইল:** `SDKClient.java`

এই ক্লায়েন্টটি AI ব্যবহার না করে MCP সার্ভারের সাথে সরাসরি কথা বলে। এটি নির্দিষ্ট ক্যালকুলেটর ফাংশনগুলো ম্যানুয়ালি কল করে:

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

**এটি কী করে:**
1. **সংযোগ স্থাপন করে** `http://localhost:8080`-এ ক্যালকুলেটর সার্ভারের সাথে বিল্ডার প্যাটার্ন ব্যবহার করে
2. **তালিকা তৈরি করে** সমস্ত উপলব্ধ টুলের (আমাদের ক্যালকুলেটর ফাংশন)
3. **নির্দিষ্ট ফাংশন কল করে** সঠিক প্যারামিটার দিয়ে
4. **ফলাফল সরাসরি প্রিন্ট করে**

**নোট:** এই উদাহরণটি Spring AI 1.1.0-SNAPSHOT ডিপেনডেন্সি ব্যবহার করে, যা `WebFluxSseClientTransport`-এর জন্য একটি বিল্ডার প্যাটার্ন চালু করেছে। আপনি যদি পুরোনো স্থিতিশীল সংস্করণ ব্যবহার করেন, তাহলে সরাসরি কনস্ট্রাক্টর ব্যবহার করতে হতে পারে।

**কখন ব্যবহার করবেন:** যখন আপনি ঠিক কোন গণনা করতে চান তা জানেন এবং প্রোগ্রাম্যাটিকভাবে এটি কল করতে চান।

### ৪. AI-চালিত ক্লায়েন্ট

**ফাইল:** `LangChain4jClient.java`

এই ক্লায়েন্টটি একটি AI মডেল (GPT-4o-mini) ব্যবহার করে, যা স্বয়ংক্রিয়ভাবে সিদ্ধান্ত নিতে পারে কোন ক্যালকুলেটর টুল ব্যবহার করতে হবে:

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

**এটি কী করে:**
1. **একটি AI মডেল সংযোগ তৈরি করে** আপনার GitHub টোকেন ব্যবহার করে
2. **AI-কে আমাদের ক্যালকুলেটর MCP সার্ভারের সাথে সংযুক্ত করে**
3. **AI-কে সমস্ত ক্যালকুলেটর টুলে অ্যাক্সেস দেয়**
4. **স্বাভাবিক ভাষার অনুরোধ গ্রহণ করে**, যেমন "24.5 এবং 17.3 যোগ করুন"

**AI স্বয়ংক্রিয়ভাবে:**
- বুঝতে পারে আপনি সংখ্যা যোগ করতে চান
- `add` টুল নির্বাচন করে
- `add(24.5, 17.3)` কল করে
- একটি স্বাভাবিক প্রতিক্রিয়ায় ফলাফল প্রদান করে

## উদাহরণগুলো চালানো

### ধাপ ১: ক্যালকুলেটর সার্ভার চালু করুন

প্রথমে আপনার GitHub টোকেন সেট করুন (AI ক্লায়েন্টের জন্য প্রয়োজনীয়):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

সার্ভার চালু করুন:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

সার্ভারটি `http://localhost:8080`-এ চালু হবে। আপনি দেখতে পাবেন:
```
Started McpServerApplication in X.XXX seconds
```

### ধাপ ২: সরাসরি ক্লায়েন্ট দিয়ে পরীক্ষা করুন

**নতুন** টার্মিনালে, যেখানে সার্ভার এখনও চালু রয়েছে, সরাসরি MCP ক্লায়েন্ট চালান:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

আপনি এরকম আউটপুট দেখতে পাবেন:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### ধাপ ৩: AI ক্লায়েন্ট দিয়ে পরীক্ষা করুন

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

আপনি দেখতে পাবেন AI স্বয়ংক্রিয়ভাবে টুল ব্যবহার করছে:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### ধাপ ৪: MCP সার্ভার বন্ধ করুন

পরীক্ষা শেষ হলে, AI ক্লায়েন্ট বন্ধ করতে তার টার্মিনালে `Ctrl+C` চাপুন। MCP সার্ভার চালু থাকবে যতক্ষণ না আপনি এটি বন্ধ করেন।
সার্ভার বন্ধ করতে, যেখানে এটি চালু রয়েছে সেই টার্মিনালে `Ctrl+C` চাপুন।

## সবকিছু কীভাবে একসাথে কাজ করে

যখন আপনি AI-কে জিজ্ঞাসা করেন "৫ + ৩ কত?", তখন পুরো প্রক্রিয়া এভাবে ঘটে:

1. **আপনি** AI-কে স্বাভাবিক ভাষায় জিজ্ঞাসা করেন
2. **AI** আপনার অনুরোধ বিশ্লেষণ করে এবং বুঝতে পারে আপনি যোগ করতে চান
3. **AI** MCP সার্ভারকে কল করে: `add(5.0, 3.0)`
4. **ক্যালকুলেটর সার্ভিস** সম্পাদন করে: `5.0 + 3.0 = 8.0`
5. **ক্যালকুলেটর সার্ভিস** রিটার্ন করে: `"5.00 + 3.00 = 8.00"`
6. **AI** ফলাফল গ্রহণ করে এবং একটি স্বাভাবিক প্রতিক্রিয়া তৈরি করে
7. **আপনি** পান: "৫ এবং ৩ এর যোগফল ৮"

## পরবর্তী পদক্ষেপ

আরও উদাহরণের জন্য দেখুন [Chapter 04: Practical samples](../README.md)

---

**অস্বীকৃতি**:  
এই নথিটি AI অনুবাদ পরিষেবা [Co-op Translator](https://github.com/Azure/co-op-translator) ব্যবহার করে অনুবাদ করা হয়েছে। আমরা যথাসম্ভব সঠিক অনুবাদের চেষ্টা করি, তবে অনুগ্রহ করে মনে রাখবেন যে স্বয়ংক্রিয় অনুবাদে ত্রুটি বা অসঙ্গতি থাকতে পারে। মূল ভাষায় থাকা নথিটিকে প্রামাণিক উৎস হিসেবে বিবেচনা করা উচিত। গুরুত্বপূর্ণ তথ্যের জন্য, পেশাদার মানব অনুবাদ সুপারিশ করা হয়। এই অনুবাদ ব্যবহারের ফলে কোনো ভুল বোঝাবুঝি বা ভুল ব্যাখ্যা হলে আমরা তার জন্য দায়ী থাকব না।