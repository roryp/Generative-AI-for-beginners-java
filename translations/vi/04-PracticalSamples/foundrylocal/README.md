<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "fe08a184d8a753a0f497673921f77759",
  "translation_date": "2025-11-04T06:52:11+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "vi"
}
-->
# Hướng dẫn Spring Boot Foundry Local

## Mục lục

- [Yêu cầu trước khi bắt đầu](../../../../04-PracticalSamples/foundrylocal)
- [Tổng quan dự án](../../../../04-PracticalSamples/foundrylocal)
- [Hiểu về mã nguồn](../../../../04-PracticalSamples/foundrylocal)
  - [1. Cấu hình ứng dụng (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Lớp ứng dụng chính (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. Lớp dịch vụ AI (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Các phụ thuộc dự án (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Cách hoạt động của toàn bộ hệ thống](../../../../04-PracticalSamples/foundrylocal)
- [Cài đặt Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [Chạy ứng dụng](../../../../04-PracticalSamples/foundrylocal)
- [Kết quả mong đợi](../../../../04-PracticalSamples/foundrylocal)
- [Bước tiếp theo](../../../../04-PracticalSamples/foundrylocal)
- [Xử lý sự cố](../../../../04-PracticalSamples/foundrylocal)

## Yêu cầu trước khi bắt đầu

Trước khi bắt đầu hướng dẫn này, hãy đảm bảo bạn đã:

- Cài đặt **Java 21 hoặc cao hơn** trên hệ thống của bạn
- **Maven 3.6+** để xây dựng dự án
- **Foundry Local** đã được cài đặt và chạy

### **Cài đặt Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## Tổng quan dự án

Dự án này bao gồm bốn thành phần chính:

1. **Application.java** - Điểm khởi đầu chính của ứng dụng Spring Boot
2. **FoundryLocalService.java** - Lớp dịch vụ xử lý giao tiếp AI
3. **application.properties** - Cấu hình kết nối với Foundry Local
4. **pom.xml** - Các phụ thuộc Maven và cấu hình dự án

## Hiểu về mã nguồn

### 1. Cấu hình ứng dụng (application.properties)

**Tệp:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**Chức năng:**
- **base-url**: Xác định nơi Foundry Local đang chạy, bao gồm đường dẫn `/v1` để tương thích với API OpenAI. **Lưu ý**: Foundry Local tự động gán cổng, vì vậy hãy kiểm tra cổng thực tế bằng `foundry service status`
- **model**: Đặt tên mô hình AI để sử dụng cho việc tạo văn bản, bao gồm số phiên bản (ví dụ: `:1`). Sử dụng `foundry model list` để xem các mô hình có sẵn với ID chính xác của chúng

**Khái niệm chính:** Spring Boot tự động tải các thuộc tính này và làm cho chúng có sẵn cho ứng dụng của bạn bằng cách sử dụng chú thích `@Value`.

### 2. Lớp ứng dụng chính (Application.java)

**Tệp:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```

**Chức năng:**
- `@SpringBootApplication` kích hoạt cấu hình tự động của Spring Boot
- `WebApplicationType.NONE` thông báo cho Spring rằng đây là ứng dụng dòng lệnh, không phải máy chủ web
- Phương thức chính khởi động ứng dụng Spring

**Trình chạy demo:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
    };
}
```

**Chức năng:**
- `@Bean` tạo một thành phần được Spring quản lý
- `CommandLineRunner` chạy mã sau khi Spring Boot khởi động
- `foundryLocalService` được Spring tự động tiêm (dependency injection)
- Gửi một tin nhắn thử nghiệm đến AI và hiển thị phản hồi

### 3. Lớp dịch vụ AI (FoundryLocalService.java)

**Tệp:** `src/main/java/com/example/FoundryLocalService.java`

#### Tiêm cấu hình:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```

**Chức năng:**
- `@Service` thông báo cho Spring rằng lớp này cung cấp logic nghiệp vụ
- `@Value` tiêm các giá trị cấu hình từ application.properties
- Cú pháp `:default-value` cung cấp giá trị dự phòng nếu các thuộc tính không được đặt

#### Khởi tạo client:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```

**Chức năng:**
- `@PostConstruct` chạy phương thức này sau khi Spring tạo dịch vụ
- Tạo một client OpenAI trỏ đến phiên bản Foundry Local của bạn
- URL cơ sở từ `application.properties` đã bao gồm `/v1` để tương thích với API OpenAI
- Khóa API được đặt là "not-needed" vì phát triển cục bộ không yêu cầu xác thực

#### Phương thức chat:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Which AI model to use
                .addUserMessage(message)         // Your question/prompt
                .maxCompletionTokens(150)        // Limit response length
                .temperature(0.7)                // Control creativity (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extract the AI's response from the API result
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Chức năng:**
- **ChatCompletionCreateParams**: Cấu hình yêu cầu AI
  - `model`: Xác định mô hình AI để sử dụng (phải khớp với ID chính xác từ `foundry model list`)
  - `addUserMessage`: Thêm tin nhắn của bạn vào cuộc trò chuyện
  - `maxCompletionTokens`: Giới hạn độ dài của phản hồi (tiết kiệm tài nguyên)
  - `temperature`: Kiểm soát độ ngẫu nhiên (0.0 = xác định, 1.0 = sáng tạo)
- **API Call**: Gửi yêu cầu đến Foundry Local
- **Xử lý phản hồi**: Trích xuất phản hồi văn bản của AI một cách an toàn
- **Xử lý lỗi**: Bao bọc các ngoại lệ với thông báo lỗi hữu ích

### 4. Các phụ thuộc dự án (pom.xml)

**Các phụ thuộc chính:**

```xml
<!-- Spring Boot - Application framework -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>${spring-boot.version}</version>
</dependency>

<!-- OpenAI Java SDK - For AI API calls -->
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>

<!-- Jackson - JSON processing -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.0</version>
</dependency>
```

**Chức năng:**
- **spring-boot-starter**: Cung cấp chức năng cốt lõi của Spring Boot
- **openai-java**: SDK Java chính thức của OpenAI để giao tiếp API
- **jackson-databind**: Xử lý tuần tự hóa/giải tuần tự hóa JSON cho các yêu cầu API

## Cách hoạt động của toàn bộ hệ thống

Dưới đây là luồng hoàn chỉnh khi bạn chạy ứng dụng:

1. **Khởi động**: Spring Boot khởi động và đọc `application.properties`
2. **Tạo dịch vụ**: Spring tạo `FoundryLocalService` và tiêm các giá trị cấu hình
3. **Thiết lập client**: `@PostConstruct` khởi tạo client OpenAI để kết nối với Foundry Local
4. **Thực thi demo**: `CommandLineRunner` thực thi sau khi khởi động
5. **Gọi AI**: Demo gọi `foundryLocalService.chat()` với một tin nhắn thử nghiệm
6. **Yêu cầu API**: Dịch vụ xây dựng và gửi yêu cầu tương thích với OpenAI đến Foundry Local
7. **Xử lý phản hồi**: Dịch vụ trích xuất và trả về phản hồi của AI
8. **Hiển thị**: Ứng dụng in phản hồi và thoát

## Cài đặt Foundry Local

Để cài đặt Foundry Local, hãy làm theo các bước sau:

1. **Cài đặt Foundry Local** theo hướng dẫn trong phần [Yêu cầu trước khi bắt đầu](../../../../04-PracticalSamples/foundrylocal).

2. **Kiểm tra cổng được gán động**. Foundry Local tự động gán cổng khi khởi động. Tìm cổng của bạn bằng:
   ```bash
   foundry service status
   ```
   
   **Tùy chọn**: Nếu bạn muốn sử dụng một cổng cụ thể (ví dụ: 5273), bạn có thể cấu hình thủ công:
   ```bash
   foundry service set --port 5273
   ```

3. **Tải xuống mô hình AI** bạn muốn sử dụng, ví dụ, `phi-3.5-mini`, với lệnh sau:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **Cấu hình tệp application.properties** để phù hợp với cài đặt Foundry Local của bạn:
   - Cập nhật cổng trong `base-url` (từ bước 2), đảm bảo nó bao gồm `/v1` ở cuối
   - Cập nhật tên mô hình để bao gồm số phiên bản (kiểm tra với `foundry model list`)
   
   Ví dụ:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```

## Chạy ứng dụng

### Bước 1: Khởi động Foundry Local
```bash
foundry model run phi-3.5-mini
```

### Bước 2: Xây dựng và chạy ứng dụng
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Kết quả mong đợi

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```

## Bước tiếp theo

Để xem thêm ví dụ, hãy tham khảo [Chương 04: Các mẫu thực tế](../README.md)

## Xử lý sự cố

### Các vấn đề thường gặp

**"Connection refused" hoặc "Service unavailable"**
- Đảm bảo Foundry Local đang chạy: `foundry model list`
- Kiểm tra cổng thực tế mà Foundry Local đang sử dụng: `foundry service status`
- Cập nhật `application.properties` của bạn với cổng chính xác, đảm bảo URL kết thúc bằng `/v1`
- Hoặc, đặt một cổng cụ thể nếu muốn: `foundry service set --port 5273`
- Thử khởi động lại Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" hoặc lỗi "404 Not Found"**
- Kiểm tra các mô hình có sẵn với ID chính xác của chúng: `foundry model list`
- Cập nhật tên mô hình trong `application.properties` để khớp chính xác, bao gồm số phiên bản (ví dụ: `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Đảm bảo `base-url` bao gồm `/v1` ở cuối: `http://localhost:5273/v1`
- Tải xuống mô hình nếu cần: `foundry model run phi-3.5-mini`

**Lỗi "400 Bad Request"**
- Xác minh URL cơ sở bao gồm `/v1`: `http://localhost:5273/v1`
- Kiểm tra rằng ID mô hình khớp chính xác với những gì hiển thị trong `foundry model list`
- Đảm bảo bạn đang sử dụng `maxCompletionTokens()` trong mã của mình (không phải `maxTokens()` đã bị ngừng sử dụng)

**Lỗi biên dịch Maven**
- Đảm bảo Java 21 hoặc cao hơn: `java -version`
- Dọn dẹp và xây dựng lại: `mvn clean compile`
- Kiểm tra kết nối internet để tải xuống các phụ thuộc

**Ứng dụng khởi động nhưng không có đầu ra**
- Xác minh Foundry Local đang phản hồi: Mở trình duyệt đến `http://localhost:5273`
- Kiểm tra nhật ký ứng dụng để tìm thông báo lỗi cụ thể
- Đảm bảo mô hình đã được tải đầy đủ và sẵn sàng

---

**Tuyên bố miễn trừ trách nhiệm**:  
Tài liệu này đã được dịch bằng dịch vụ dịch thuật AI [Co-op Translator](https://github.com/Azure/co-op-translator). Mặc dù chúng tôi cố gắng đảm bảo độ chính xác, xin lưu ý rằng các bản dịch tự động có thể chứa lỗi hoặc không chính xác. Tài liệu gốc bằng ngôn ngữ bản địa nên được coi là nguồn thông tin chính thức. Đối với thông tin quan trọng, nên sử dụng dịch vụ dịch thuật chuyên nghiệp bởi con người. Chúng tôi không chịu trách nhiệm cho bất kỳ sự hiểu lầm hoặc diễn giải sai nào phát sinh từ việc sử dụng bản dịch này.