# Chat cơ bản với Azure OpenAI - Ví dụ từ đầu đến cuối

Ví dụ này minh họa cách tạo một ứng dụng Spring Boot đơn giản kết nối với Azure OpenAI và kiểm tra thiết lập của bạn.

## Mục lục

- [Yêu cầu trước](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Bắt đầu nhanh](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Tùy chọn cấu hình](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Tùy chọn 1: Biến môi trường (tệp .env) - Khuyến nghị](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Tùy chọn 2: Secrets của GitHub Codespace](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Chạy ứng dụng](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Sử dụng Maven](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Sử dụng VS Code](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Kết quả mong đợi](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Tham khảo cấu hình](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Biến môi trường](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Cấu hình Spring](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Khắc phục sự cố](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Các vấn đề thường gặp](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Chế độ gỡ lỗi](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Bước tiếp theo](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Tài nguyên](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Yêu cầu trước

Trước khi chạy ví dụ này, hãy đảm bảo bạn đã:

- Hoàn thành [hướng dẫn thiết lập Azure OpenAI](../../getting-started-azure-openai.md)  
- Triển khai tài nguyên Azure OpenAI (qua cổng Azure AI Foundry)  
- Triển khai mô hình gpt-4o-mini (hoặc mô hình thay thế)  
- Có khóa API và URL endpoint từ Azure  

## Bắt đầu nhanh

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Tùy chọn cấu hình

### Tùy chọn 1: Biến môi trường (tệp .env) - Khuyến nghị

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

> **Lưu ý về bảo mật**: 
> - Không bao giờ commit tệp `.env` vào hệ thống kiểm soát phiên bản
> - Tệp `.env` đã được thêm vào `.gitignore`
> - Giữ khóa API của bạn an toàn và xoay vòng chúng thường xuyên

### Tùy chọn 2: Secrets của GitHub Codespace

Đối với GitHub Codespaces, hãy đặt các secrets này trong kho lưu trữ của bạn:
- `AZURE_AI_KEY` - Khóa API Azure OpenAI của bạn
- `AZURE_AI_ENDPOINT` - URL endpoint Azure OpenAI của bạn

Ứng dụng sẽ tự động phát hiện và sử dụng các secrets này.

### Tùy chọn thay thế: Biến môi trường trực tiếp

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

## Chạy ứng dụng

### Sử dụng Maven

```bash
mvn spring-boot:run
```

### Sử dụng VS Code

1. Mở dự án trong VS Code
2. Nhấn `F5` hoặc sử dụng bảng "Run and Debug"
3. Chọn cấu hình "Spring Boot-BasicChatApplication"

> **Lưu ý**: Cấu hình VS Code tự động tải tệp .env của bạn

### Kết quả mong đợi

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

## Tham khảo cấu hình

### Biến môi trường

| Biến | Mô tả | Bắt buộc | Ví dụ |
|------|-------|----------|-------|
| `AZURE_AI_KEY` | Khóa API Azure OpenAI | Có | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL endpoint Azure OpenAI | Có | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Tên triển khai mô hình | Không | `gpt-4o-mini` (mặc định) |

### Cấu hình Spring

Tệp `application.yml` cấu hình:
- **Khóa API**: `${AZURE_AI_KEY}` - Từ biến môi trường
- **Endpoint**: `${AZURE_AI_ENDPOINT}` - Từ biến môi trường  
- **Mô hình**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Từ biến môi trường với giá trị mặc định
- **Temperature**: `0.7` - Điều chỉnh mức độ sáng tạo (0.0 = xác định, 1.0 = sáng tạo)
- **Max Tokens**: `500` - Độ dài tối đa của phản hồi

## Khắc phục sự cố

### Các vấn đề thường gặp

<details>
<summary><strong>Lỗi: "The API key is not valid"</strong></summary>

- Kiểm tra rằng `AZURE_AI_KEY` của bạn được đặt chính xác trong tệp `.env`
- Xác minh khóa API được sao chép chính xác từ cổng Azure AI Foundry
- Đảm bảo không có khoảng trắng hoặc dấu ngoặc xung quanh khóa
</details>

<details>
<summary><strong>Lỗi: "The endpoint is not valid"</strong></summary>

- Đảm bảo `AZURE_AI_ENDPOINT` của bạn bao gồm URL đầy đủ (ví dụ: `https://your-hub-name.openai.azure.com/`)
- Kiểm tra tính nhất quán của dấu gạch chéo ở cuối
- Xác minh endpoint khớp với vùng triển khai Azure của bạn
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
- Kiểm tra rằng tiện ích mở rộng Java của VS Code đã được cài đặt đúng cách
- Xác minh cấu hình khởi chạy có `"envFile": "${workspaceFolder}/.env"`
</details>

### Chế độ gỡ lỗi

Để bật ghi nhật ký chi tiết, bỏ chú thích các dòng này trong `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Bước tiếp theo

**Thiết lập hoàn tất!** Tiếp tục hành trình học tập của bạn:

[Chương 3: Kỹ thuật AI tạo nội dung cốt lõi](../../../03-CoreGenerativeAITechniques/README.md)

## Tài nguyên

- [Tài liệu Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Tài liệu dịch vụ Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)
- [Cổng Azure AI Foundry](https://ai.azure.com/)
- [Tài liệu Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Tuyên bố miễn trừ trách nhiệm**:  
Tài liệu này đã được dịch bằng dịch vụ dịch thuật AI [Co-op Translator](https://github.com/Azure/co-op-translator). Mặc dù chúng tôi cố gắng đảm bảo độ chính xác, xin lưu ý rằng các bản dịch tự động có thể chứa lỗi hoặc không chính xác. Tài liệu gốc bằng ngôn ngữ bản địa nên được coi là nguồn thông tin chính thức. Đối với các thông tin quan trọng, khuyến nghị sử dụng dịch vụ dịch thuật chuyên nghiệp bởi con người. Chúng tôi không chịu trách nhiệm về bất kỳ sự hiểu lầm hoặc diễn giải sai nào phát sinh từ việc sử dụng bản dịch này.