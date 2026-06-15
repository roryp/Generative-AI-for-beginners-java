# Hướng Dẫn Foundry Local Spring Boot

## Mục Lục

- [Yêu cầu trước khi bắt đầu](#yêu-cầu-trước-khi-bắt-đầu)
- [Tổng quan dự án](#tổng-quan-dự-án)
- [Hiểu về mã nguồn](#hiểu-về-mã-nguồn)
  - [1. Cấu hình ứng dụng (application.properties)](#1-cấu-hình-ứng-dụng-applicationproperties)
  - [2. Lớp ứng dụng chính (Application.java)](#2-lớp-ứng-dụng-chính-applicationjava)
  - [3. Lớp dịch vụ AI (FoundryLocalService.java)](#3-lớp-dịch-vụ-ai-foundrylocalservicejava)
  - [4. Phụ thuộc dự án (pom.xml)](#4-phụ-thuộc-dự-án-pomxml)
- [Cách mọi thứ hoạt động cùng nhau](#cách-mọi-thứ-hoạt-động-cùng-nhau)
- [Cài đặt Foundry Local](#cài-đặt-foundry-local-1)
- [Chạy ứng dụng](#chạy-ứng-dụng)
- [Kết quả mong đợi](#kết-quả-mong-đợi)
- [Bước tiếp theo](#bước-tiếp-theo)
- [Khắc phục sự cố](#khắc-phục-sự-cố)


## Yêu cầu trước khi bắt đầu

Trước khi bắt đầu hướng dẫn này, hãy đảm bảo bạn có:

- **Java 21 hoặc cao hơn** đã cài đặt trên hệ thống của bạn
- **Maven 3.6+** để xây dựng dự án
- **Foundry Local** đã được cài đặt và đang chạy

### **Cài đặt Foundry Local:**

> **Lưu ý:** Foundry Local CLI hiện hỗ trợ trên **Windows** và **macOS**. Linux được hỗ trợ thông qua [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Kiểm tra cài đặt:
```bash
foundry --version
```

## Tổng quan dự án

Dự án này bao gồm bốn thành phần chính:

1. **Application.java** - Điểm khởi đầu ứng dụng Spring Boot chính
2. **FoundryLocalService.java** - Lớp dịch vụ xử lý giao tiếp AI
3. **application.properties** - Cấu hình kết nối Foundry Local
4. **pom.xml** - Phụ thuộc Maven và cấu hình dự án

## Hiểu về mã nguồn

### 1. Cấu hình ứng dụng (application.properties)

**Tệp:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Chức năng:**
- **base-url**: Xác định nơi Foundry Local đang chạy, bao gồm cả đường dẫn `/v1` để tương thích API OpenAI. Cổng mặc định là `5273`. Nếu cổng khác, kiểm tra bằng `foundry service status`.
- **model** (tùy chọn): Tên mô hình AI được sử dụng cho việc tạo văn bản. **Theo mặc định, ứng dụng tự động phát hiện mô hình** bằng cách truy vấn endpoint `/v1/models` của Foundry Local khi khởi động, vì vậy bạn không cần thiết lập. Bạn vẫn có thể cấu hình rõ ràng để ghi đè nếu cần.

**Khái niệm chính:** Spring Boot tự động tải các thuộc tính này và cung cấp cho ứng dụng của bạn qua annotation `@Value`.

### 2. Lớp ứng dụng chính (Application.java)

**Tệp:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Không cần máy chủ web
        app.run(args);
    }
```

**Chức năng:**
- `@SpringBootApplication` kích hoạt cấu hình tự động Spring Boot
- `WebApplicationType.NONE` cho biết ứng dụng là dòng lệnh, không phải web server
- Phương thức main khởi chạy ứng dụng Spring

**Trình chạy Demo:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        System.out.println("Calling Foundry Local service...");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
        System.out.println("=========================");
    };
}
```

**Chức năng:**
- `@Bean` tạo một thành phần được quản lý bởi Spring
- `CommandLineRunner` chạy mã sau khi Spring Boot khởi động
- `foundryLocalService` được Spring tự động tiêm (dependency injection)
- Gửi một tin nhắn thử nghiệm tới AI và hiển thị phản hồi

### 3. Lớp dịch vụ AI (FoundryLocalService.java)

**Tệp:** `src/main/java/com/example/FoundryLocalService.java`

#### Tiêm cấu hình:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Tự động phát hiện nếu trống
```

**Chức năng:**
- `@Service` cho biết lớp này cung cấp logic nghiệp vụ
- `@Value` tiêm các giá trị cấu hình từ application.properties
- Model mặc định rỗng, kích hoạt **tự động phát hiện** từ Foundry Local lúc khởi động. Điều này cho phép ứng dụng hoạt động với bất kỳ mô hình nào được tải trong Foundry Local mà không cần cấu hình thủ công.

#### Khởi tạo client:
```java
@PostConstruct
public void init() {
    // Tự động phát hiện mô hình từ Foundry Local nếu không được cấu hình rõ ràng
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // URL cơ sở đã bao gồm /v1 từ cấu hình
            .apiKey("not-needed")            // Máy chủ cục bộ không cần khóa API thực tế
            .build();
}
```

**Chức năng:**
- `@PostConstruct` chạy phương thức này sau khi Spring tạo dịch vụ
- Nếu chưa có mô hình, nó truy vấn endpoint `/v1/models` của Foundry Local và chọn mô hình đầu tiên được tải
- Tạo client OpenAI trỏ tới Foundry Local trên máy của bạn
- Base URL trong `application.properties` đã bao gồm `/v1` để tương thích API OpenAI
- Khóa API được đặt là "not-needed" vì phát triển local không cần xác thực

#### Phương thức chat:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Sử dụng mô hình AI nào
                .addUserMessage(message)         // Câu hỏi/lời nhắc của bạn
                .maxCompletionTokens(150)        // Giới hạn độ dài câu trả lời
                .temperature(0.7)                // Điều khiển sự sáng tạo (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Trích xuất phản hồi của AI từ kết quả API
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
  - `model`: Chỉ định mô hình AI sử dụng (phải đúng ID từ `foundry model list`)
  - `addUserMessage`: Thêm tin nhắn của bạn vào cuộc hội thoại
  - `maxCompletionTokens`: Giới hạn độ dài phản hồi (tiết kiệm tài nguyên)
  - `temperature`: Kiểm soát độ ngẫu nhiên (0.0 = cố định, 1.0 = sáng tạo)
- **Gọi API**: Gửi yêu cầu tới Foundry Local
- **Xử lý phản hồi**: Lấy nội dung phản hồi của AI an toàn
- **Xử lý lỗi**: Bao bọc ngoại lệ với thông báo hữu ích

### 4. Phụ thuộc dự án (pom.xml)

**Phụ thuộc chính:**

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
- **spring-boot-starter**: Cung cấp chức năng cốt lõi Spring Boot
- **openai-java**: SDK Java chính thức của OpenAI để giao tiếp API
- **jackson-databind**: Xử lý tuần tự hóa/deserialization JSON cho các cuộc gọi API

## Cách mọi thứ hoạt động cùng nhau

Đây là quá trình khi bạn chạy ứng dụng:

1. **Khởi động**: Spring Boot khởi động và đọc `application.properties`
2. **Tạo dịch vụ**: Spring tạo `FoundryLocalService` và tiêm các giá trị cấu hình
3. **Phát hiện mô hình**: Nếu không có mô hình cấu hình, dịch vụ truy vấn `/v1/models` của Foundry Local và tự động chọn mô hình đầu tiên có sẵn
4. **Cài đặt client**: `@PostConstruct` khởi tạo client OpenAI kết nối với Foundry Local
5. **Thực thi demo**: `CommandLineRunner` chạy sau khi khởi động
6. **Gọi AI**: Demo gọi `foundryLocalService.chat()` với tin nhắn thử nghiệm
7. **Yêu cầu API**: Dịch vụ xây dựng và gửi yêu cầu tương thích OpenAI tới Foundry Local
8. **Xử lý phản hồi**: Dịch vụ trích xuất và trả về phản hồi của AI
9. **Hiển thị**: Ứng dụng in phản hồi và thoát

## Cài đặt Foundry Local

1. **Cài đặt Foundry Local** theo hướng dẫn trong phần [Yêu cầu trước khi bắt đầu](#yêu-cầu-trước-khi-bắt-đầu).

2. **Khởi động dịch vụ** (nếu chưa chạy):
   ```bash
   foundry service start
   ```

3. **Kiểm tra trạng thái dịch vụ** để xác nhận nó đang chạy và ghi nhớ cổng:
   ```bash
   foundry service status
   ```

4. **Tải xuống và chạy mô hình** (tải lần đầu, sau đó lưu cache để chạy tiếp):
   ```bash
   foundry model run phi-4-mini
   ```
   Điều này mở một phiên chat tương tác. Bạn có thể thoát bằng `Ctrl+C`. Mô hình vẫn được giữ trong dịch vụ.

   > **Mẹo:** Chạy `foundry model list` để xem tất cả mô hình có sẵn. Thay `phi-4-mini` bằng bất kỳ bí danh nào trong danh mục (ví dụ: `qwen2.5-0.5b` cho mô hình nhỏ hơn/nhanh hơn).

5. **Xác nhận mô hình đã được tải:**
   ```bash
   foundry service ps
   ```

6. **Cập nhật `application.properties` nếu cần:**
   - `base-url` mặc định (`http://localhost:5273/v1`) khớp với cổng CLI mặc định. Chỉ cập nhật khi `foundry service status` cho cổng khác.
   - Mô hình **tự động phát hiện** khi khởi động — không cần cấu hình.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Chạy ứng dụng

### Bước 1: Đảm bảo có mô hình được tải trong Foundry Local
```bash
foundry service ps
```
Nếu không có mô hình nào, tải một mô hình:
```bash
foundry model run phi-4-mini
```

### Bước 2: Xây dựng và chạy ứng dụng
Mở một terminal khác:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Hoặc đóng gói và chạy dưới dạng JAR:
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
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## Bước tiếp theo

Để xem thêm ví dụ, tham khảo [Chương 04: Ví dụ thực tiễn](../README.md)

## Khắc phục sự cố

### Vấn đề thường gặp

**"Connection refused" hoặc "Service unavailable"**
- Kiểm tra dịch vụ: `foundry service status`
- Khởi động lại nếu cần: `foundry service restart`
- Đảm bảo cổng trong `application.properties` khớp với kết quả `foundry service status`
- Đảm bảo URL kết thúc bằng `/v1`: `http://localhost:5273/v1`

**"Không tìm thấy mô hình" khi khởi động**
- Ứng dụng tự động phát hiện mô hình. Đảm bảo ít nhất một mô hình được tải: `foundry service ps`
- Nếu không có mô hình nào tải: `foundry model run phi-4-mini`
- Nếu bạn đã ghi đè tên mô hình trong `application.properties`, xác nhận nó khớp với `foundry model list`

**Lỗi "400 Bad Request"**
- Kiểm tra base URL có chứa `/v1`: `http://localhost:5273/v1`
- Đảm bảo bạn sử dụng `maxCompletionTokens()` trong mã (không dùng `maxTokens()` đã lỗi thời)

**Lỗi biên dịch Maven**
- Đảm bảo Java 21 hoặc cao hơn: `java -version`
- Dọn dẹp và biên dịch lại: `mvn clean compile`
- Kiểm tra kết nối internet để tải phụ thuộc

**Vấn đề kết nối dịch vụ**
- Nếu thấy lỗi `Request to local service failed`, chạy: `foundry service restart`
- Kiểm tra mô hình đã tải: `foundry service ps`
- Xem nhật ký dịch vụ: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Tuyên bố miễn trừ trách nhiệm**:  
Tài liệu này đã được dịch bằng dịch vụ dịch thuật AI [Co-op Translator](https://github.com/Azure/co-op-translator). Mặc dù chúng tôi cố gắng đảm bảo độ chính xác, xin lưu ý rằng bản dịch tự động có thể chứa lỗi hoặc sự không chính xác. Tài liệu gốc bằng ngôn ngữ nguyên bản nên được coi là nguồn tin cậy chính thức. Đối với các thông tin quan trọng, nên sử dụng dịch thuật chuyên nghiệp bởi con người. Chúng tôi không chịu trách nhiệm đối với bất kỳ sự hiểu lầm hoặc giải thích sai nào phát sinh từ việc sử dụng bản dịch này.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->