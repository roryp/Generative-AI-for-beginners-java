<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2289320a74aeca1eb844cd7d3a7a9e12",
  "translation_date": "2025-07-21T19:41:20+00:00",
  "source_file": "02-SetupDevEnvironment/src/basic-chat-azure/README.md",
  "language_code": "vi"
}
-->
# Chat Cơ Bản với Azure OpenAI - Ví Dụ Hoàn Chỉnh

Ví dụ này minh họa cách tạo một ứng dụng Spring Boot đơn giản kết nối với Azure OpenAI và kiểm tra thiết lập của bạn.

## Mục Lục

- [Yêu Cầu Trước](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Bắt Đầu Nhanh](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Tùy Chọn Cấu Hình](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Tùy Chọn 1: Biến Môi Trường (tệp .env) - Khuyến nghị](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Tùy Chọn 2: Secrets của GitHub Codespace](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Chạy Ứng Dụng](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Sử Dụng Maven](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Sử Dụng VS Code](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Kết Quả Mong Đợi](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Tham Chiếu Cấu Hình](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Biến Môi Trường](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Cấu Hình Spring](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Khắc Phục Sự Cố](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Các Vấn Đề Thường Gặp](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Chế Độ Gỡ Lỗi](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Các Bước Tiếp Theo](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Tài Nguyên](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)

## Yêu Cầu Trước

Trước khi chạy ví dụ này, hãy đảm bảo bạn đã:

- Hoàn thành [hướng dẫn thiết lập Azure OpenAI](../../getting-started-azure-openai.md)  
- Triển khai tài nguyên Azure OpenAI (qua cổng Azure AI Foundry)  
- Triển khai mô hình gpt-4o-mini (hoặc mô hình thay thế)  
- Có khóa API và URL endpoint từ Azure  

## Bắt Đầu Nhanh

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/src/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Tùy Chọn Cấu Hình

### Tùy Chọn 1: Biến Môi Trường (tệp .env) - Khuyến nghị

**Bước 1: Tạo tệp cấu hình của bạn**  
```bash
cp .env.example .env
```

**Bước 2: Thêm thông tin xác thực Azure OpenAI của bạn**  
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Lưu Ý Bảo Mật**:  
> - Không bao giờ commit tệp `.env` vào hệ thống kiểm soát phiên bản  
> - Tệp `.env` đã được thêm vào `.gitignore`  
> - Giữ an toàn cho khóa API của bạn và thay đổi chúng thường xuyên  

### Tùy Chọn 2: Secrets của GitHub Codespace

Đối với GitHub Codespaces, thiết lập các secrets này trong kho lưu trữ của bạn:  
- `AZURE_AI_KEY` - Khóa API Azure OpenAI của bạn  
- `AZURE_AI_ENDPOINT` - URL endpoint Azure OpenAI của bạn  

Ứng dụng sẽ tự động phát hiện và sử dụng các secrets này.

### Tùy Chọn Khác: Biến Môi Trường Trực Tiếp

<details>
<summary>Nhấp để xem các lệnh theo nền tảng</summary>

**Linux/macOS (bash/zsh):**  
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Command Prompt):**  
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**  
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## Chạy Ứng Dụng

### Sử Dụng Maven

```bash
mvn spring-boot:run
```

### Sử Dụng VS Code

1. Mở dự án trong VS Code  
2. Nhấn `F5` hoặc sử dụng bảng "Run and Debug"  
3. Chọn cấu hình "Spring Boot-BasicChatApplication"  

> **Lưu Ý**: Cấu hình VS Code tự động tải tệp .env của bạn  

### Kết Quả Mong Đợi

```
Starting Basic Chat with Azure OpenAI...
Environment variables loaded successfully
Connecting to Azure OpenAI...
Sending prompt: What is AI in a short sentence? Max 100 words.

AI Response:
================
AI, or Artificial Intelligence, is the simulation of human intelligence in machines programmed to think and learn like humans.
================

Success! Azure OpenAI connection is working correctly.
```

## Tham Chiếu Cấu Hình

### Biến Môi Trường

| Biến | Mô Tả | Bắt Buộc | Ví Dụ |
|------|-------|----------|-------|
| `AZURE_AI_KEY` | Khóa API Azure OpenAI | Có | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL endpoint Azure OpenAI | Có | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Tên triển khai mô hình | Không | `gpt-4o-mini` (mặc định) |

### Cấu Hình Spring

Tệp `application.yml` cấu hình:  
- **API Key**: `${AZURE_AI_KEY}` - Từ biến môi trường  
- **Endpoint**: `${AZURE_AI_ENDPOINT}` - Từ biến môi trường  
- **Model**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Từ biến môi trường với giá trị mặc định  
- **Temperature**: `0.7` - Điều chỉnh mức độ sáng tạo (0.0 = xác định, 1.0 = sáng tạo)  
- **Max Tokens**: `500` - Độ dài phản hồi tối đa  

## Khắc Phục Sự Cố

### Các Vấn Đề Thường Gặp

<details>
<summary><strong>Lỗi: "The API key is not valid"</strong></summary>

- Kiểm tra rằng `AZURE_AI_KEY` của bạn được thiết lập chính xác trong tệp `.env`  
- Xác minh khóa API được sao chép chính xác từ cổng Azure AI Foundry  
- Đảm bảo không có khoảng trắng hoặc dấu ngoặc thừa xung quanh khóa  
</details>

<details>
<summary><strong>Lỗi: "The endpoint is not valid"</strong></summary>

- Đảm bảo `AZURE_AI_ENDPOINT` của bạn bao gồm URL đầy đủ (ví dụ: `https://your-hub-name.openai.azure.com/`)  
- Kiểm tra tính nhất quán của dấu gạch chéo ở cuối URL  
- Xác minh endpoint khớp với khu vực triển khai Azure của bạn  
</details>

<details>
<summary><strong>Lỗi: "The deployment was not found"</strong></summary>

- Xác minh tên triển khai mô hình của bạn khớp chính xác với tên đã triển khai trong Azure  
- Kiểm tra rằng mô hình đã được triển khai thành công và đang hoạt động  
- Thử sử dụng tên triển khai mặc định: `gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code: Biến môi trường không tải</strong></summary>

- Đảm bảo tệp `.env` của bạn nằm trong thư mục gốc của dự án (cùng cấp với `pom.xml`)  
- Thử chạy `mvn spring-boot:run` trong terminal tích hợp của VS Code  
- Kiểm tra rằng tiện ích mở rộng Java của VS Code đã được cài đặt đúng  
- Xác minh cấu hình khởi chạy có `"envFile": "${workspaceFolder}/.env"`  
</details>

### Chế Độ Gỡ Lỗi

Để bật ghi nhật ký chi tiết, bỏ chú thích các dòng này trong `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Các Bước Tiếp Theo

**Thiết Lập Hoàn Tất!** Tiếp tục hành trình học tập của bạn:

[Chương 3: Kỹ Thuật AI Tạo Sinh Cốt Lõi](../../../03-CoreGenerativeAITechniques/README.md)

## Tài Nguyên

- [Tài Liệu Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [Tài Liệu Dịch Vụ Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)  
- [Cổng Azure AI Foundry](https://ai.azure.com/)  
- [Tài Liệu Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**Tuyên bố miễn trừ trách nhiệm**:  
Tài liệu này đã được dịch bằng dịch vụ dịch thuật AI [Co-op Translator](https://github.com/Azure/co-op-translator). Mặc dù chúng tôi cố gắng đảm bảo độ chính xác, xin lưu ý rằng các bản dịch tự động có thể chứa lỗi hoặc không chính xác. Tài liệu gốc bằng ngôn ngữ bản địa nên được coi là nguồn thông tin chính thức. Đối với các thông tin quan trọng, khuyến nghị sử dụng dịch vụ dịch thuật chuyên nghiệp bởi con người. Chúng tôi không chịu trách nhiệm cho bất kỳ sự hiểu lầm hoặc diễn giải sai nào phát sinh từ việc sử dụng bản dịch này.