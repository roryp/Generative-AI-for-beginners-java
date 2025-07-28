<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "82ea3c5a1b9d4bf4f1e2d906649e874e",
  "translation_date": "2025-07-28T11:34:54+00:00",
  "source_file": "04-PracticalSamples/calculator/README.md",
  "language_code": "vi"
}
-->
# Hướng dẫn sử dụng MCP Calculator dành cho người mới bắt đầu

## Mục lục

- [Những gì bạn sẽ học](../../../../04-PracticalSamples/calculator)
- [Yêu cầu trước khi bắt đầu](../../../../04-PracticalSamples/calculator)
- [Hiểu cấu trúc dự án](../../../../04-PracticalSamples/calculator)
- [Giải thích các thành phần cốt lõi](../../../../04-PracticalSamples/calculator)
  - [1. Ứng dụng chính](../../../../04-PracticalSamples/calculator)
  - [2. Dịch vụ máy tính](../../../../04-PracticalSamples/calculator)
  - [3. Client MCP trực tiếp](../../../../04-PracticalSamples/calculator)
  - [4. Client sử dụng AI](../../../../04-PracticalSamples/calculator)
- [Chạy các ví dụ](../../../../04-PracticalSamples/calculator)
- [Cách các thành phần hoạt động cùng nhau](../../../../04-PracticalSamples/calculator)
- [Bước tiếp theo](../../../../04-PracticalSamples/calculator)

## Những gì bạn sẽ học

Hướng dẫn này giải thích cách xây dựng một dịch vụ máy tính sử dụng Model Context Protocol (MCP). Bạn sẽ hiểu:

- Cách tạo một dịch vụ mà AI có thể sử dụng như một công cụ
- Cách thiết lập giao tiếp trực tiếp với các dịch vụ MCP
- Cách các mô hình AI tự động chọn công cụ để sử dụng
- Sự khác biệt giữa các cuộc gọi giao thức trực tiếp và tương tác hỗ trợ bởi AI

## Yêu cầu trước khi bắt đầu

Trước khi bắt đầu, hãy đảm bảo bạn đã có:
- Java 21 hoặc phiên bản cao hơn
- Maven để quản lý phụ thuộc
- Tài khoản GitHub với mã thông báo truy cập cá nhân (PAT)
- Kiến thức cơ bản về Java và Spring Boot

## Hiểu cấu trúc dự án

Dự án máy tính có một số tệp quan trọng:

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

## Giải thích các thành phần cốt lõi

### 1. Ứng dụng chính

**Tệp:** `McpServerApplication.java`

Đây là điểm khởi đầu của dịch vụ máy tính. Đây là một ứng dụng Spring Boot tiêu chuẩn với một bổ sung đặc biệt:

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

**Chức năng:**
- Khởi động máy chủ web Spring Boot trên cổng 8080
- Tạo một `ToolCallbackProvider` để làm cho các phương pháp máy tính của chúng ta có thể sử dụng như các công cụ MCP
- Annotation `@Bean` cho phép Spring quản lý thành phần này để các phần khác có thể sử dụng

### 2. Dịch vụ máy tính

**Tệp:** `CalculatorService.java`

Đây là nơi thực hiện các phép toán. Mỗi phương pháp được đánh dấu bằng `@Tool` để có thể sử dụng thông qua MCP:

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

**Các đặc điểm chính:**

1. **Annotation `@Tool`**: Cho MCP biết rằng phương pháp này có thể được gọi bởi các client bên ngoài
2. **Mô tả rõ ràng**: Mỗi công cụ có một mô tả giúp các mô hình AI hiểu khi nào nên sử dụng
3. **Định dạng kết quả nhất quán**: Tất cả các phép toán trả về chuỗi dễ đọc như "5.00 + 3.00 = 8.00"
4. **Xử lý lỗi**: Chia cho 0 và căn bậc hai số âm trả về thông báo lỗi

**Các phép toán có sẵn:**
- `add(a, b)` - Cộng hai số
- `subtract(a, b)` - Trừ số thứ hai khỏi số thứ nhất
- `multiply(a, b)` - Nhân hai số
- `divide(a, b)` - Chia số thứ nhất cho số thứ hai (kiểm tra chia cho 0)
- `power(base, exponent)` - Lũy thừa của cơ số với số mũ
- `squareRoot(number)` - Tính căn bậc hai (kiểm tra số âm)
- `modulus(a, b)` - Trả về phần dư của phép chia
- `absolute(number)` - Trả về giá trị tuyệt đối
- `help()` - Trả về thông tin về tất cả các phép toán

### 3. Client MCP trực tiếp

**Tệp:** `SDKClient.java`

Client này giao tiếp trực tiếp với máy chủ MCP mà không sử dụng AI. Nó gọi các chức năng máy tính cụ thể một cách thủ công:

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

**Chức năng:**
1. **Kết nối** với máy chủ máy tính tại `http://localhost:8080`
2. **Liệt kê** tất cả các công cụ có sẵn (các chức năng máy tính của chúng ta)
3. **Gọi** các chức năng cụ thể với tham số chính xác
4. **In** kết quả trực tiếp

**Khi nào sử dụng:** Khi bạn biết chính xác phép toán cần thực hiện và muốn gọi nó bằng lập trình.

### 4. Client sử dụng AI

**Tệp:** `LangChain4jClient.java`

Client này sử dụng một mô hình AI (GPT-4o-mini) có thể tự động quyết định công cụ máy tính nào cần sử dụng:

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

**Chức năng:**
1. **Tạo** kết nối với mô hình AI sử dụng mã thông báo GitHub của bạn
2. **Kết nối** AI với máy chủ MCP của máy tính
3. **Cung cấp** cho AI quyền truy cập vào tất cả các công cụ máy tính
4. **Cho phép** yêu cầu ngôn ngữ tự nhiên như "Tính tổng của 24.5 và 17.3"

**AI tự động:**
- Hiểu rằng bạn muốn cộng các số
- Chọn công cụ `add`
- Gọi `add(24.5, 17.3)`
- Trả về kết quả trong một phản hồi tự nhiên

## Chạy các ví dụ

### Bước 1: Khởi động máy chủ máy tính

Đầu tiên, thiết lập mã thông báo GitHub của bạn (cần thiết cho client AI):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

Khởi động máy chủ:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

Máy chủ sẽ khởi động tại `http://localhost:8080`. Bạn sẽ thấy:
```
Started McpServerApplication in X.XXX seconds
```

### Bước 2: Kiểm tra với Client trực tiếp

Trong một **terminal MỚI** với máy chủ vẫn đang chạy, chạy client MCP trực tiếp:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

Bạn sẽ thấy đầu ra như:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### Bước 3: Kiểm tra với Client AI

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

Bạn sẽ thấy AI tự động sử dụng các công cụ:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### Bước 4: Đóng máy chủ MCP

Khi bạn hoàn thành việc kiểm tra, bạn có thể dừng client AI bằng cách nhấn `Ctrl+C` trong terminal của nó. Máy chủ MCP sẽ tiếp tục chạy cho đến khi bạn dừng nó.  
Để dừng máy chủ, nhấn `Ctrl+C` trong terminal nơi nó đang chạy.

## Cách các thành phần hoạt động cùng nhau

Dưới đây là luồng hoàn chỉnh khi bạn hỏi AI "5 + 3 bằng bao nhiêu?":

1. **Bạn** hỏi AI bằng ngôn ngữ tự nhiên
2. **AI** phân tích yêu cầu của bạn và nhận ra bạn muốn cộng
3. **AI** gọi máy chủ MCP: `add(5.0, 3.0)`
4. **Dịch vụ máy tính** thực hiện: `5.0 + 3.0 = 8.0`
5. **Dịch vụ máy tính** trả về: `"5.00 + 3.00 = 8.00"`
6. **AI** nhận kết quả và định dạng phản hồi tự nhiên
7. **Bạn** nhận được: "Tổng của 5 và 3 là 8"

## Bước tiếp theo

Để xem thêm các ví dụ, hãy xem [Chương 04: Các mẫu thực tế](../README.md)

**Tuyên bố miễn trừ trách nhiệm**:  
Tài liệu này đã được dịch bằng dịch vụ dịch thuật AI [Co-op Translator](https://github.com/Azure/co-op-translator). Mặc dù chúng tôi cố gắng đảm bảo độ chính xác, xin lưu ý rằng các bản dịch tự động có thể chứa lỗi hoặc không chính xác. Tài liệu gốc bằng ngôn ngữ bản địa nên được coi là nguồn thông tin chính thức. Đối với các thông tin quan trọng, khuyến nghị sử dụng dịch vụ dịch thuật chuyên nghiệp từ con người. Chúng tôi không chịu trách nhiệm cho bất kỳ sự hiểu lầm hoặc diễn giải sai nào phát sinh từ việc sử dụng bản dịch này.