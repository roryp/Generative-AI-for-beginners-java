# មេរៀនគណនេយ្យ MCP សម្រាប់អ្នកចាប់ផ្ដើម

## បញ្ជីមាតិកា

- [អ្វីដែលអ្នកនឹងរៀន](#អ្វីដែលអ្នកនឹងរៀន)
- [លក្ខខណ្ឌមុនពេលចាប់ផ្ដើម](#លក្ខខណ្ឌមុនពេលចាប់ផ្ដើម)
- [យល់ដឹងអំពីរចនាសម្ព័ន្ធគម្រោង](#យល់ដឹងអំពីរចនាសម្ព័ន្ធគម្រោង)
- [បញ្ជាក់ពីសមាសភាគស្នូល](#បញ្ជាក់ពីសមាសភាគស្នូល)
  - [១. អ្នកប្រើប្រាស់ដើម](#១-អនុគ្រឿងនៃកម្មវិធីដើម)
  - [២. សេវាកម្មគណនេយ្យ](#២-សេវាកម្មគណនេយ្យ)
  - [៣. អតិថិជន MCP ត្រូវបានភ្ជាប់ផ្ទាល់](#៣-អតិថិជន-mcp-ដែលភ្ជាប់ផ្ទាល់)
  - [៤. អតិថិជនដែលមានឥន្ទ្រវិស័យ](#៤-អតិថិជនដែលមានឥន្ទ្រវិស័យ)
- [រត់ឧទាហរណ៍](#រត់ឧទាហរណ៍)
- [របៀបដែលវាដំណើរការជាមួយគ្នា](#របៀបដែលវាដំណើរការជាមួយគ្នា)
- [ជំហានបន្ទាប់](#ជំហានបន្ទាប់)

## អ្វីដែលអ្នកនឹងរៀន

មេរៀននេះពន្យល់ពីរបៀបបង្កើតសេវាកម្មគណនេយ្យដោយប្រើ Model Context Protocol (MCP)។ អ្នកនឹងយល់ពីៈ

- របៀបបង្កើតសេវាកម្មដែលអាយអេសអាចប្រើជាឧបករណ៍
- របៀបដំណើរការភ្ជាប់ផ្ទាល់ជាមួយសេវាកម្ម MCP
- របៀបដែលម៉ុឌែលអាយអេសអាចជ្រើសរើសឧបករណ៍ដែលត្រូវប្រើដោយស្វ័យប្រវត្តិ
- ផ្សំភាពរវាងការហៅពាក់ព័ន្ធផ្ទាល់និងអន្តរកម្មជាមួយអាយអេសជួយ

## លក្ខខណ្ឌមុនពេលចាប់ផ្ដើម

មុនពេលចាប់ផ្ដើម សូមប្រាកដថាអ្នកមាន៖
- Java 21 ឬច្រើនជាងនេះបានដំឡើង
- Maven សម្រាប់គ្រប់គ្រងពាក់ព័ន្ធ
- គណនី GitHub ដែលមានតួណែនំចូលប្រើផ្ទាល់ខ្លួន (PAT)
- ការយល់ដឹងមូលដ្ឋានអំពី Java និង Spring Boot

## យល់ដឹងអំពីរចនាសម្ព័ន្ធគម្រោង

គម្រោងគណនេយ្យមានឯកសារសំខាន់ៗជាច្រើន៖

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

## បញ្ជាក់ពីសមាសភាគស្នូល

### ១. អ្នកប្រើប្រាស់ដើម

**ឯកសារ:** `McpServerApplication.java`

នេះជាចំណុចចេញដំណើរការរបស់សេវាកម្មគណនេយ្យយើង។ វាជាកម្មវិធី Spring Boot ឧទាហរណ៍មួយដែលមានការបន្ថែមពិសេស៖

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

**អ្វីដែលវាធ្វើ៖**
- ចាប់ផ្ដើមម៉ាស៊ីនបម្រើវេប Spring Boot នៅព្រិល 8080
- បង្កើត `ToolCallbackProvider` ដែលធ្វើឲ្យវិធីសាស្រ្តគណនេយ្យរបស់យើងអាចប្រើជាឧបករណ៍ MCP
- ស្លាក `@Bean` ជួយឲ្យ Spring គ្រប់គ្រងនេះជាគ្រឿងផ្សំដែលផ្នែកផ្សេងអាចប្រើបាន

### ២. សេវាកម្មគណនេយ្យ

**ឯកសារ:** `CalculatorService.java`

នេះជាកន្លែងមានការគណនាគ្រប់យ៉ាង។ វិធីសាស្រ្តនីមួយៗបានសម្គាល់ជាមួយ `@Tool` ដើម្បីធ្វើឲ្យវាអាចប្រើបានតាមរយៈ MCP៖

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
    
    // ប្រតិបត្តិការគណនាប្រមាណបន្ថែម...
    
    private String formatResult(double a, String operator, double b, double result) {
        return String.format("%.2f %s %.2f = %.2f", a, operator, b, result);
    }
}
```

**លក្ខណៈសំខាន់ៗ៖**

1. **ស្លាក `@Tool`**៖ ជូនដំណឹងដល់ MCP ថាវិធីសាស្រ្តនេះអាចត្រូវបានហៅដោយអតិថិជនខាងក្រៅ
2. **ការពិពណ៌នាច្បាស់លាស់**៖ រាល់ឧបករណ៍មានការពិពណ៌នាដែលជួយម៉ូឌែលអាយអេសយល់នៅពេលដែលត្រូវប្រើវា
3. **ទ្រង់ទ្រាយត្រឡប់ដែលមានសមាមាត្រ**៖ ប្រតិបត្តិការទាំងអស់ត្រឡប់អក្សរដែលអាចអានបាន ដូចជា "5.00 + 3.00 = 8.00"
4. **ដោះស្រាយកំហុស**៖ ការចែកដោយសូន្យនិងការដកស្មើគ្រីតទទេ សង្វាក់មានសារកំហុសត្រឡប់វិញ

**ប្រតិបត្តិការអាចប្រើបាន ៖**
- `add(a, b)` - បន្ថែមលេខពីរជាមួយគ្នា
- `subtract(a, b)` - ដកលេខទីពីរចេញពីលេខទីមួយ
- `multiply(a, b)` - គុណលេខពីរជាមួយគ្នា
- `divide(a, b)` - ចែកលេខទីមួយដោយលេខទីពីរ (ពិនិត្យសូន្យ)
- `power(base, exponent)` - ដំណើរការជាមូល ដល់ថ្នាក់(exponent)
- `squareRoot(number)` - គណនារ៉ាដិកែលជាគូរ (ពិនិត្យឲ្យមិនអាចដកសមាមាត្រកាត់អវិជ្ជមានចេញ)
- `modulus(a, b)` - ត្រឡប់សំណល់នៃការចែក
- `absolute(number)` - ត្រឡប់តម្លៃអប្បបរមា
- `help()` - ត្រឡប់ព័ត៌មានអំពីប្រតិបត្តិការទាំងអស់

### ៣. អតិថិជន MCP ត្រូវបានភ្ជាប់ផ្ទាល់

**ឯកសារ:** `SDKClient.java`

អតិថិជននេះសន្ទនាโดยផ្ទាល់ទៅម៉ាស៊ីនបម្រើ MCP ដោយមិនប្រើអាយអេស។ វាហៅមុខងារគណនេយ្យជាក់លាក់ដោយម្ដង៖

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
        
        // បញ្ជីឧបករណ៍ដែលមាន
        ListToolsResult toolsList = client.listTools();
        System.out.println("Available Tools = " + toolsList);
        
        // ហៅមុខងារគណនេយ្យជាក់លាក់
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

**អ្វីដែលវាធ្វើ៖**
១. **ភ្ជាប់** ទៅម៉ាស៊ីនបម្រើគណនេយ្យនៅ `http://localhost:8080` ដោយប្រើបែបបទ builder
២. **បញ្ជី** នៃឧបករណ៍ទាំងអស់ (មុខងារគណនេយ្យយើង)
៣. **ហៅ** មុខងារជាក់លាក់នឹងវាលប៉ារ៉ាម៉ែត្រ
៤. **បង្ហាញ** លទ្ធផលដោយផ្ទាល់

**ចំណាំ៖** ឧទាហរណ៍នេះប្រើពាក់ព័ន្ធ Spring AI 1.1.0-SNAPSHOT ដែលបានណែនាំបែបបទ builder សម្រាប់ `WebFluxSseClientTransport`។ ប្រសិនបើអ្នកប្រើជំនាន់ចាស់ជាងនេះ អ្នកអាចត្រូវប្រើ constructor ត្រូវតែផ្ទាល់។

**ពេលណាដែលត្រូវប្រើ៖** ប្រសិនអ្នកដឹងច្បាស់ពីគណនាការណាមួយនិងចង់ហៅវាដោយកម្មវិធី។

### ៤. អតិថិជនដែលមានឥន្ទ្រវិស័យ

**ឯកសារ:** `LangChain4jClient.java`

អតិថិជននេះប្រើម៉ូឌែលអាយអេស (GPT-4o-mini) ដែលអាចសម្រេចចិត្តដោយស្វ័យប្រវត្តិថាតើត្រូវប្រើឧបករណ៍គណនេយ្យណា៖

```java
public class LangChain4jClient {
    
    public static void main(String[] args) throws Exception {
        // កំណត់ម៉ូដែល AI (ប្រើម៉ូដែល GitHub)
        ChatLanguageModel model = OpenAiOfficialChatModel.builder()
                .isGitHubModels(true)
                .apiKey(System.getenv("GITHUB_TOKEN"))
                .modelName("gpt-4o-mini")
                .build();

        // ភ្ជាប់ទៅម៉ាស៊ីនមេគណនាគ្រូ MCP របស់យើង
        McpTransport transport = new HttpMcpTransport.Builder()
                .sseUrl("http://localhost:8080/sse")
                .logRequests(true)  // បង្ហាញអ្វីដែល AI កំពុងធ្វើ
                .logResponses(true)
                .build();

        McpClient mcpClient = new DefaultMcpClient.Builder()
                .transport(transport)
                .build();

        // ផ្តល់ការចូលប្រើឧបករណ៍គណនាគ្រូរបស់យើងឲ្យ AI
        ToolProvider toolProvider = McpToolProvider.builder()
                .mcpClients(List.of(mcpClient))
                .build();

        // បង្កើតរ៉ូបូត AI ដែលអាចប្រើគណនាគ្រូរបស់យើង
        Bot bot = AiServices.builder(Bot.class)
                .chatLanguageModel(model)
                .toolProvider(toolProvider)
                .build();

        // ឥឡូវនេះយើងអាចស្នើឲ្យ AI ធ្វើការគណនាចំពោះភាសាធម្មជាតិបានហើយ
        String response = bot.chat("Calculate the sum of 24.5 and 17.3 using the calculator service");
        System.out.println(response);

        response = bot.chat("What's the square root of 144?");
        System.out.println(response);
    }
}
```

**អ្វីដែលវាធ្វើ៖**
១. **បង្កើត** ការតភ្ជាប់ម៉ូឌែលអាយអេសដោយប្រើតួណែនាំ GitHub របស់អ្នក
២. **ភ្ជាប់** អាយអេសទៅម៉ាស៊ីនបម្រើ MCP គណនេយ្យរបស់យើង
៣. **ផ្តល់** ការចូលប្រើឧបករណ៍គណនេយ្យទាំងអស់
៤. **អនុញ្ញាត** ពាក្យសុំជាភាសាធម្មជាតិដូចជា "គណនាប្រាក់សរុបនៃ 24.5 និង 17.3"

**អាយអេសដោយស្វ័យប្រវត្តិ៖**
- យល់ថាអ្នកចង់បន្ថែមលេខ
- ជ្រើសរើសឧបករណ៍ `add`
- ហៅ `add(24.5, 17.3)`
- ត្រឡប់លទ្ធផលជាការឆ្លើយតបធម្មជាតិ

## រត់ឧទាហរណ៍

### ជំហាន 1: ចាប់ផ្ដើមម៉ាស៊ីនបម្រើគណនេយ្យ

ដំបូង សូមកំណត់តួណែនាំ GitHub របស់អ្នក (ដែលត្រូវចាំបាច់សម្រាប់អតិថិជន AI)៖

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

ចាប់ផ្ដើមម៉ាស៊ីនបម្រើ៖
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

ម៉ាស៊ីនបម្រើនឹងចាប់ផ្ដើមនៅ `http://localhost:8080`។ អ្នកនឹងឃើញ៖
```
Started McpServerApplication in X.XXX seconds
```

### ជំហាន 2: សាកល្បងជាមួយអតិថិជនផ្ទាល់

នៅក្នុងបញ្ជារបញ្ជា **ថ្មី** ខណៈម៉ាស៊ីនបម្រើកំពុងដំណើរការ ហៅអតិថិជន MCP ផ្ទាល់៖
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

អ្នកនឹងឃើញលទ្ធផលដូចជា៖
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### ជំហាន 3: សាកល្បងជាមួយអតិថិជន AI

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

អ្នកនឹងឃើញ AI ប្រើឧបករណ៍ដោយស្វ័យប្រវត្តិ៖
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### ជំហាន 4: បិទម៉ាស៊ីនបម្រើ MCP

ពេលអ្នកធ្វើតេស្តរួច អ្នកអាចបិទអតិថិជន AI ដោយចុច `Ctrl+C` នៅបញ្ជារ។ ម៉ាស៊ីនបម្រើ MCP នឹងបន្តដំណើរការរហូតដល់អ្នកបិទវា។
ដើម្បីបិទម៉ាស៊ីនបម្រើ ចុច `Ctrl+C` នៅក្នុងបញ្ជារ ដែលវាកំពុងដំណើរការ។

## របៀបដែលវាដំណើរការជាមួយគ្នា

នេះជាប្រតិទិនលំអិតពេលអ្នកសួរអាយអេស "5 + 3 ជាអ្វី?":

១. **អ្នក** សួរអាយអេសជាភាសាធម្មជាតិ
២. **អាយអេស** វិភាគសំណើរបស់អ្នក ហើយយល់ថាអ្នកចង់បន្ថែម
៣. **អាយអេស** ហៅម៉ាស៊ីនបម្រើ MCP: `add(5.0, 3.0)`
៤. **សេវាកម្មគណនេយ្យ** ធ្វើបច្ចេកទេស: `5.0 + 3.0 = 8.0`
៥. **សេវាកម្មគណនេយ្យ** ត្រឡប់: `"5.00 + 3.00 = 8.00"`
៦. **អាយអេស** ទទួលលទ្ធផល ហើយរៀបចំការឆ្លើយតបធម្មជាតិ
៧. **អ្នក** ទទួលបាន៖ "ផលបូកនៃ 5 និង 3 គឺ 8"

## ជំហានបន្ទាប់

សម្រាប់ឧទាហរណ៍បន្ថែម សូមមើល [ជំពូក 04: ឧទាហរណ៍ជាក់ស្តែង](../README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ការព្រមាន**៖  
ឯកសារនេះបានបកប្រែដោយប្រើសេវាកម្មបកប្រែ AI [Co-op Translator](https://github.com/Azure/co-op-translator)។ ខណៈពេលដែលយើងខិតខំរកភាពត្រឹមត្រូវ សូមយល់ថាការបកប្រែដោយស្វ័យប្រវត្តិអាចមានចរាចរលំបាក ឬច្រឡំខុសបាន។ ឯកសារដើមក្នុងភាសាទ្រព្យសម្បត្តិគួរត្រូវបានគេរក្សាទុកជាផ្លូវការត្រឹមត្រូវ។ សម្រាប់ព័ត៌មានសំខាន់ៗ គ្រឹះការបកប្រែដោយមនុស្សជំនាញត្រូវបានផ្តល់អនុសាសន៍។ យើងមិនទទួលខុសត្រូវចំពោះការយល់ខុស ឬការបកប្រែខុសរបស់ការបកប្រែនេះទេ។
<!-- CO-OP TRANSLATOR DISCLAIMER END -->