# AGENTS.md

## Tổng quan dự án

Đây là một kho lưu trữ giáo dục để học phát triển AI tạo sinh với Java. Nó cung cấp một khóa học thực hành toàn diện bao gồm các Mô hình Ngôn ngữ Lớn (LLMs), kỹ thuật tạo prompt, embeddings, RAG (Retrieval-Augmented Generation), và Giao thức Ngữ cảnh Mô hình (MCP).

**Công nghệ chính:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI, và OpenAI SDKs

**Kiến trúc:**
- Nhiều ứng dụng Spring Boot độc lập được tổ chức theo từng chương
- Các dự án mẫu minh họa các mẫu AI khác nhau
- Sẵn sàng cho GitHub Codespaces với các container phát triển được cấu hình trước

## Lệnh thiết lập

### Yêu cầu trước
- Java 21 hoặc cao hơn
- Maven 3.x
- Token truy cập cá nhân GitHub (cho GitHub Models)
- Tùy chọn: Thông tin đăng nhập Azure OpenAI

### Thiết lập môi trường

**Tùy chọn 1: GitHub Codespaces (Khuyến nghị)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Tùy chọn 2: Container phát triển cục bộ**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Tùy chọn 3: Thiết lập cục bộ**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Cấu hình

**Thiết lập Token GitHub:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Thiết lập Azure OpenAI (Tùy chọn):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Quy trình phát triển

### Cấu trúc dự án
```
/
├── 01-IntroToGenAI/              # Chapter 1: Introduction
├── 02-SetupDevEnvironment/       # Chapter 2: Environment setup
│   └── examples/                 # Working examples
├── 03-CoreGenerativeAITechniques/ # Chapter 3: Core techniques
├── 04-PracticalSamples/          # Chapter 4: Sample projects
│   ├── calculator/               # MCP service example
│   ├── foundrylocal/            # Local model integration
│   └── petstory/                # Multi-modal app
├── 05-ResponsibleGenAI/         # Chapter 5: Responsible AI
└── translations/                # Multi-language support
```

### Chạy ứng dụng

**Chạy một ứng dụng Spring Boot:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Xây dựng một dự án:**
```bash
cd [project-directory]
mvn clean install
```

**Khởi động MCP Calculator Server:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Chạy các ví dụ Client:**
```bash
# After starting the server in another terminal
cd 04-PracticalSamples/calculator

# Direct MCP client
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"

# AI-powered client (requires GITHUB_TOKEN)
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"

# Interactive bot
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.Bot"
```

### Tải lại nóng
Spring Boot DevTools được bao gồm trong các dự án hỗ trợ tải lại nóng:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Hướng dẫn kiểm thử

### Chạy kiểm thử

**Chạy tất cả kiểm thử trong một dự án:**
```bash
cd [project-directory]
mvn test
```

**Chạy kiểm thử với đầu ra chi tiết:**
```bash
mvn test -X
```

**Chạy một lớp kiểm thử cụ thể:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Cấu trúc kiểm thử
- Các tệp kiểm thử sử dụng JUnit 5 (Jupiter)
- Các lớp kiểm thử nằm trong `src/test/java/`
- Các ví dụ Client trong dự án máy tính nằm trong `src/test/java/com/microsoft/mcp/sample/client/`

### Kiểm thử thủ công
Nhiều ví dụ là các ứng dụng tương tác yêu cầu kiểm thử thủ công:

1. Khởi động ứng dụng với `mvn spring-boot:run`
2. Kiểm thử các điểm cuối hoặc tương tác với CLI
3. Xác minh hành vi mong đợi khớp với tài liệu trong README.md của từng dự án

### Kiểm thử với GitHub Models
- Giới hạn miễn phí: 15 yêu cầu/phút, 150/ngày
- Tối đa 5 yêu cầu đồng thời
- Kiểm thử lọc nội dung với các ví dụ AI có trách nhiệm

## Nguyên tắc phong cách mã

### Quy ước Java
- **Phiên bản Java:** Java 21 với các tính năng hiện đại
- **Phong cách:** Tuân theo quy ước Java tiêu chuẩn
- **Đặt tên:** 
  - Lớp: PascalCase
  - Phương thức/biến: camelCase
  - Hằng số: UPPER_SNAKE_CASE
  - Tên gói: chữ thường

### Mẫu Spring Boot
- Sử dụng `@Service` cho logic nghiệp vụ
- Sử dụng `@RestController` cho các điểm cuối REST
- Cấu hình qua `application.yml` hoặc `application.properties`
- Ưu tiên biến môi trường hơn giá trị cố định
- Sử dụng chú thích `@Tool` cho các phương thức được MCP công khai

### Tổ chức tệp
```
src/
├── main/
│   ├── java/
│   │   └── com/microsoft/[component]/
│   │       ├── [Component]Application.java
│   │       ├── config/
│   │       ├── controller/
│   │       ├── service/
│   │       └── exception/
│   └── resources/
│       ├── application.yml
│       └── static/
└── test/
    └── java/
        └── com/microsoft/[component]/
```

### Phụ thuộc
- Quản lý qua Maven `pom.xml`
- Spring AI BOM để quản lý phiên bản
- LangChain4j cho tích hợp AI
- Spring Boot starter parent cho các phụ thuộc Spring

### Bình luận mã
- Thêm JavaDoc cho các API công khai
- Bao gồm các bình luận giải thích cho các tương tác AI phức tạp
- Tài liệu mô tả công cụ MCP rõ ràng

## Xây dựng và triển khai

### Xây dựng dự án

**Xây dựng không kiểm thử:**
```bash
mvn clean install -DskipTests
```

**Xây dựng với tất cả kiểm tra:**
```bash
mvn clean install
```

**Đóng gói ứng dụng:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Thư mục đầu ra
- Các lớp đã biên dịch: `target/classes/`
- Các lớp kiểm thử: `target/test-classes/`
- Tệp JAR: `target/*.jar`
- Tạo tác Maven: `target/`

### Cấu hình theo môi trường

**Phát triển:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Sản xuất:**
- Sử dụng Azure AI Foundry Models thay vì GitHub Models
- Cập nhật base-url thành điểm cuối Azure OpenAI
- Quản lý bí mật qua Azure Key Vault hoặc biến môi trường

### Cân nhắc triển khai
- Đây là kho lưu trữ giáo dục với các ứng dụng mẫu
- Không được thiết kế để triển khai sản xuất như hiện tại
- Các mẫu minh họa các mẫu để điều chỉnh cho sản xuất
- Xem README của từng dự án để biết ghi chú triển khai cụ thể

## Ghi chú bổ sung

### GitHub Models vs Azure OpenAI
- **GitHub Models:** Miễn phí để học, không cần thẻ tín dụng
- **Azure OpenAI:** Sẵn sàng cho sản xuất, yêu cầu đăng ký Azure
- Mã tương thích giữa cả hai - chỉ cần thay đổi điểm cuối và khóa API

### Làm việc với nhiều dự án
Mỗi dự án mẫu là độc lập:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Vấn đề thường gặp

**Không khớp phiên bản Java:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Vấn đề tải xuống phụ thuộc:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**Không tìm thấy Token GitHub:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Cổng đã được sử dụng:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Hỗ trợ đa ngôn ngữ
- Tài liệu có sẵn bằng hơn 45 ngôn ngữ qua dịch tự động
- Các bản dịch nằm trong thư mục `translations/`
- Dịch được quản lý bởi quy trình công việc GitHub Actions

### Lộ trình học tập
1. Bắt đầu với [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Theo thứ tự các chương (01 → 05)
3. Hoàn thành các ví dụ thực hành trong mỗi chương
4. Khám phá các dự án mẫu trong Chương 4
5. Học các thực hành AI có trách nhiệm trong Chương 5

### Container phát triển
Tệp `.devcontainer/devcontainer.json` cấu hình:
- Môi trường phát triển Java 21
- Maven được cài đặt sẵn
- Tiện ích mở rộng Java cho VS Code
- Công cụ Spring Boot
- Tích hợp GitHub Copilot
- Hỗ trợ Docker-in-Docker
- Azure CLI

### Cân nhắc hiệu suất
- GitHub Models miễn phí có giới hạn tốc độ
- Sử dụng kích thước lô phù hợp cho embeddings
- Cân nhắc bộ nhớ đệm cho các cuộc gọi API lặp lại
- Theo dõi sử dụng token để tối ưu hóa chi phí

### Ghi chú bảo mật
- Không bao giờ commit tệp `.env` (đã có trong `.gitignore`)
- Sử dụng biến môi trường cho khóa API
- Token GitHub nên có phạm vi tối thiểu cần thiết
- Tuân theo hướng dẫn AI có trách nhiệm trong Chương 5

---

**Tuyên bố miễn trừ trách nhiệm**:  
Tài liệu này đã được dịch bằng dịch vụ dịch thuật AI [Co-op Translator](https://github.com/Azure/co-op-translator). Mặc dù chúng tôi cố gắng đảm bảo độ chính xác, xin lưu ý rằng các bản dịch tự động có thể chứa lỗi hoặc không chính xác. Tài liệu gốc bằng ngôn ngữ bản địa nên được coi là nguồn thông tin chính thức. Đối với các thông tin quan trọng, khuyến nghị sử dụng dịch vụ dịch thuật chuyên nghiệp bởi con người. Chúng tôi không chịu trách nhiệm cho bất kỳ sự hiểu lầm hoặc diễn giải sai nào phát sinh từ việc sử dụng bản dịch này.