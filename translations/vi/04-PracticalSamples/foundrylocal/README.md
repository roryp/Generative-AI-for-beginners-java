<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T19:49:42+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "vi"
}
-->
# Ứng Dụng Dòng Lệnh Foundry Local

>**Lưu ý**: Chương này bao gồm một [**Hướng dẫn**](./TUTORIAL.md) giúp bạn chạy các mẫu hoàn chỉnh.

Một ứng dụng dòng lệnh Spring Boot đơn giản minh họa cách kết nối với Foundry Local bằng OpenAI Java SDK.

## Bạn Sẽ Học Được Gì

- Cách tích hợp Foundry Local với các ứng dụng Spring Boot bằng OpenAI Java SDK
- Các phương pháp tốt nhất để phát triển và kiểm tra AI cục bộ

## Mục Lục

- [Bạn Sẽ Học Được Gì](../../../../04-PracticalSamples/foundrylocal)
- [Yêu Cầu Trước](../../../../04-PracticalSamples/foundrylocal)
  - [Cài Đặt Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Xác Minh](../../../../04-PracticalSamples/foundrylocal)
- [Cấu Hình](../../../../04-PracticalSamples/foundrylocal)
- [Bắt Đầu Nhanh](../../../../04-PracticalSamples/foundrylocal)
- [Ứng Dụng Làm Gì](../../../../04-PracticalSamples/foundrylocal)
- [Kết Quả Mẫu](../../../../04-PracticalSamples/foundrylocal)
- [Kiến Trúc](../../../../04-PracticalSamples/foundrylocal)
- [Điểm Nổi Bật Trong Mã](../../../../04-PracticalSamples/foundrylocal)
  - [Tích Hợp OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [API Hoàn Thành Hội Thoại](../../../../04-PracticalSamples/foundrylocal)
- [Khắc Phục Sự Cố](../../../../04-PracticalSamples/foundrylocal)

## Yêu Cầu Trước

> **⚠️ Lưu ý**: Ứng dụng này **không chạy trong devcontainer được cung cấp** vì nó yêu cầu Foundry Local được cài đặt và chạy trên hệ thống máy chủ.

### Cài Đặt Foundry Local

Trước khi chạy ứng dụng này, bạn cần cài đặt và khởi động Foundry Local. Thực hiện các bước sau:

1. **Đảm bảo hệ thống của bạn đáp ứng các yêu cầu**:
   - **Hệ Điều Hành**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, hoặc macOS
   - **Phần Cứng**: 
     - Tối thiểu: 8GB RAM, 3GB dung lượng đĩa trống
     - Khuyến nghị: 16GB RAM, 15GB dung lượng đĩa trống
   - **Mạng**: Kết nối internet để tải xuống mô hình ban đầu (tùy chọn cho sử dụng ngoại tuyến)
   - **Tăng Tốc (tùy chọn)**: GPU NVIDIA (dòng 2,000 hoặc mới hơn), GPU AMD (dòng 6,000 hoặc mới hơn), Qualcomm Snapdragon X Elite (8GB RAM trở lên), hoặc Apple silicon
   - **Quyền**: Quyền quản trị để cài đặt phần mềm trên thiết bị của bạn

2. **Cài đặt Foundry Local**:
   
   **Đối với Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **Đối với macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Ngoài ra, bạn có thể tải xuống trình cài đặt từ [kho lưu trữ GitHub của Foundry Local](https://github.com/microsoft/Foundry-Local).

3. **Khởi động mô hình đầu tiên của bạn**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Mô hình sẽ được tải xuống (có thể mất vài phút, tùy thuộc vào tốc độ internet của bạn) và sau đó chạy. Foundry Local tự động chọn biến thể mô hình tốt nhất cho hệ thống của bạn (CUDA cho GPU NVIDIA, phiên bản CPU nếu không có GPU).

4. **Kiểm tra mô hình** bằng cách đặt câu hỏi trong cùng một terminal:

   ```bash
   Why is the sky blue?
   ```

   Bạn sẽ thấy một phản hồi từ mô hình Phi giải thích tại sao bầu trời có màu xanh.

### Xác Minh

Bạn có thể xác minh mọi thứ hoạt động đúng với các lệnh sau:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Bạn cũng có thể truy cập `http://localhost:5273` trong trình duyệt để xem giao diện web của Foundry Local.

## Cấu Hình

Ứng dụng có thể được cấu hình thông qua `application.properties`:

- `foundry.local.base-url` - URL cơ sở cho Foundry Local (mặc định: http://localhost:5273)
- `foundry.local.model` - Mô hình AI để sử dụng (mặc định: Phi-3.5-mini-instruct-cuda-gpu)

> **Lưu ý**: Tên mô hình trong cấu hình phải khớp với biến thể cụ thể mà Foundry Local đã tải xuống cho hệ thống của bạn. Khi bạn chạy `foundry model run phi-3.5-mini`, Foundry Local tự động chọn và tải xuống biến thể tốt nhất (CUDA cho GPU NVIDIA, phiên bản CPU nếu không có GPU). Sử dụng `foundry model list` để xem tên mô hình chính xác có sẵn trong phiên bản cục bộ của bạn.

## Bắt Đầu Nhanh

### 1. Điều hướng đến thư mục ứng dụng Foundry Local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Chạy Ứng Dụng

```bash
mvn spring-boot:run
```

Hoặc xây dựng và chạy tệp JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Phụ Thuộc

Ứng dụng này sử dụng OpenAI Java SDK để giao tiếp với Foundry Local. Phụ thuộc chính là:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Ứng dụng được cấu hình sẵn để kết nối với Foundry Local chạy trên cổng mặc định.

## Ứng Dụng Làm Gì

Khi bạn chạy ứng dụng:

1. **Khởi động** dưới dạng một ứng dụng dòng lệnh (không có máy chủ web)
2. **Tự động gửi** một tin nhắn kiểm tra: "Hello! Can you tell me what you are and what model you're running?"
3. **Hiển thị phản hồi** từ Foundry Local trong console
4. **Thoát sạch sẽ** sau khi hoàn thành demo

## Kết Quả Mẫu

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Kiến Trúc

- **Application.java** - Ứng dụng Spring Boot chính với CommandLineRunner
- **FoundryLocalService.java** - Dịch vụ sử dụng OpenAI Java SDK để giao tiếp với Foundry Local
- Sử dụng **OpenAI Java SDK** để gọi API an toàn kiểu
- Tự động tuần tự hóa/giải tuần tự hóa JSON được xử lý bởi SDK
- Cấu hình sạch sẽ sử dụng các chú thích `@Value` và `@PostConstruct` của Spring

## Điểm Nổi Bật Trong Mã

### Tích Hợp OpenAI Java SDK

Ứng dụng sử dụng OpenAI Java SDK để tạo một client được cấu hình cho Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### API Hoàn Thành Hội Thoại

Thực hiện các yêu cầu hoàn thành hội thoại đơn giản và an toàn kiểu:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Khắc Phục Sự Cố

Nếu bạn thấy lỗi kết nối:
1. Xác minh Foundry Local đang chạy trên `http://localhost:5273`
2. Kiểm tra rằng một biến thể mô hình Phi-3.5-mini có sẵn với `foundry model list`
3. Đảm bảo tên mô hình trong `application.properties` khớp với tên mô hình chính xác hiển thị trong danh sách
4. Đảm bảo không có tường lửa chặn kết nối

Các vấn đề thường gặp:
- **Không tìm thấy mô hình**: Chạy `foundry model run phi-3.5-mini` để tải xuống và khởi động mô hình
- **Dịch vụ không chạy**: Dịch vụ Foundry Local có thể đã dừng; khởi động lại nó bằng lệnh chạy mô hình
- **Tên mô hình sai**: Sử dụng `foundry model list` để xem các mô hình có sẵn và cập nhật cấu hình của bạn cho phù hợp

**Tuyên bố miễn trừ trách nhiệm**:  
Tài liệu này đã được dịch bằng dịch vụ dịch thuật AI [Co-op Translator](https://github.com/Azure/co-op-translator). Mặc dù chúng tôi cố gắng đảm bảo độ chính xác, xin lưu ý rằng các bản dịch tự động có thể chứa lỗi hoặc không chính xác. Tài liệu gốc bằng ngôn ngữ bản địa nên được coi là nguồn thông tin chính thức. Đối với các thông tin quan trọng, khuyến nghị sử dụng dịch vụ dịch thuật chuyên nghiệp bởi con người. Chúng tôi không chịu trách nhiệm cho bất kỳ sự hiểu lầm hoặc diễn giải sai nào phát sinh từ việc sử dụng bản dịch này.