<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T09:49:13+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "vi"
}
-->
# Ứng dụng Pet Story

>**Lưu ý**: Chương này bao gồm một [**Hướng dẫn**](./TUTORIAL.md) giúp bạn làm quen với các ví dụ.

Một ứng dụng web Spring Boot tạo ra các mô tả và câu chuyện dựa trên AI cho hình ảnh thú cưng được tải lên, sử dụng GitHub Models.

## Mục lục

- [Công nghệ sử dụng](../../../../04-PracticalSamples/petstory)
- [Yêu cầu trước](../../../../04-PracticalSamples/petstory)
- [Cài đặt & Thiết lập](../../../../04-PracticalSamples/petstory)
- [Cách sử dụng](../../../../04-PracticalSamples/petstory)

## Công nghệ sử dụng

- **Backend**: Spring Boot 3.5.3, Java 21
- **Tích hợp AI**: OpenAI Java SDK với GitHub Models
- **Bảo mật**: Spring Security
- **Frontend**: Mẫu Thymeleaf với Bootstrap
- **Công cụ Build**: Maven
- **Mô hình AI**: GitHub Models

## Yêu cầu trước

- Java 21 hoặc cao hơn
- Maven 3.9+
- GitHub Personal Access Token với quyền `models:read`

## Cài đặt & Thiết lập

### 1. Điều hướng đến thư mục ứng dụng petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Thiết lập Biến Môi Trường
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Build ứng dụng
```bash
mvn clean compile
```

### 4. Chạy ứng dụng
```bash
mvn spring-boot:run
```

## Cách sử dụng

1. **Truy cập ứng dụng**: Điều hướng đến `http://localhost:8080`
2. **Tải lên hình ảnh**: Nhấn "Choose File" và chọn một hình ảnh thú cưng
3. **Phân tích hình ảnh**: Nhấn "Analyze Image" để nhận mô tả từ AI
4. **Tạo câu chuyện**: Nhấn "Generate Story" để tạo câu chuyện

**Tuyên bố miễn trừ trách nhiệm**:  
Tài liệu này đã được dịch bằng dịch vụ dịch thuật AI [Co-op Translator](https://github.com/Azure/co-op-translator). Mặc dù chúng tôi cố gắng đảm bảo độ chính xác, xin lưu ý rằng các bản dịch tự động có thể chứa lỗi hoặc không chính xác. Tài liệu gốc bằng ngôn ngữ bản địa nên được coi là nguồn thông tin chính thức. Đối với các thông tin quan trọng, khuyến nghị sử dụng dịch vụ dịch thuật chuyên nghiệp bởi con người. Chúng tôi không chịu trách nhiệm cho bất kỳ sự hiểu lầm hoặc diễn giải sai nào phát sinh từ việc sử dụng bản dịch này.