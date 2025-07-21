<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0b563ac59362fb83f0f49dcfc442dd97",
  "translation_date": "2025-07-21T19:31:12+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "vi"
}
-->
# Thiết Lập Môi Trường Phát Triển cho Generative AI với Java

> **Bắt Đầu Nhanh**: Lập trình trên đám mây trong 2 phút - Chuyển đến [Thiết Lập GitHub Codespaces](../../../02-SetupDevEnvironment) - không cần cài đặt cục bộ và sử dụng các mô hình của GitHub!

> **Quan tâm đến Azure OpenAI?**, xem [Hướng Dẫn Thiết Lập Azure OpenAI](getting-started-azure-openai.md) với các bước tạo tài nguyên Azure OpenAI mới.

## Bạn Sẽ Học Được Gì

- Thiết lập môi trường phát triển Java cho các ứng dụng AI
- Lựa chọn và cấu hình môi trường phát triển ưa thích của bạn (ưu tiên đám mây với Codespaces, container cục bộ, hoặc thiết lập hoàn toàn cục bộ)
- Kiểm tra thiết lập của bạn bằng cách kết nối với các Mô Hình GitHub

## Mục Lục

- [Bạn Sẽ Học Được Gì](../../../02-SetupDevEnvironment)
- [Giới Thiệu](../../../02-SetupDevEnvironment)
- [Bước 1: Thiết Lập Môi Trường Phát Triển](../../../02-SetupDevEnvironment)
  - [Lựa Chọn A: GitHub Codespaces (Khuyến Nghị)](../../../02-SetupDevEnvironment)
  - [Lựa Chọn B: Container Cục Bộ](../../../02-SetupDevEnvironment)
  - [Lựa Chọn C: Sử Dụng Cài Đặt Cục Bộ Hiện Có](../../../02-SetupDevEnvironment)
- [Bước 2: Tạo GitHub Personal Access Token](../../../02-SetupDevEnvironment)
- [Bước 3: Kiểm Tra Thiết Lập](../../../02-SetupDevEnvironment)
- [Khắc Phục Sự Cố](../../../02-SetupDevEnvironment)
- [Tóm Tắt](../../../02-SetupDevEnvironment)
- [Các Bước Tiếp Theo](../../../02-SetupDevEnvironment)

## Giới Thiệu

Chương này sẽ hướng dẫn bạn thiết lập môi trường phát triển. Chúng ta sẽ sử dụng **GitHub Models** làm ví dụ chính vì nó miễn phí, dễ thiết lập chỉ với tài khoản GitHub, không yêu cầu thẻ tín dụng và cung cấp quyền truy cập vào nhiều mô hình để thử nghiệm.

**Không cần thiết lập cục bộ!** Bạn có thể bắt đầu lập trình ngay lập tức bằng cách sử dụng GitHub Codespaces, cung cấp một môi trường phát triển đầy đủ trong trình duyệt của bạn.

<img src="./images/models.webp" alt="Ảnh chụp màn hình: GitHub Models" width="50%">

Chúng tôi khuyến nghị sử dụng [**GitHub Models**](https://github.com/marketplace?type=models) cho khóa học này vì:
- **Miễn phí** để bắt đầu
- **Dễ dàng** thiết lập chỉ với tài khoản GitHub
- **Không cần thẻ tín dụng**
- **Nhiều mô hình** có sẵn để thử nghiệm

> **Lưu ý**: Các Mô Hình GitHub được sử dụng trong khóa học này có các giới hạn miễn phí sau:
> - 15 yêu cầu mỗi phút (150 mỗi ngày)
> - ~8.000 từ đầu vào, ~4.000 từ đầu ra mỗi yêu cầu
> - 5 yêu cầu đồng thời
> 
> Để sử dụng trong sản xuất, nâng cấp lên Azure AI Foundry Models với tài khoản Azure của bạn. Mã của bạn không cần thay đổi. Xem [tài liệu Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models).

## Bước 1: Thiết Lập Môi Trường Phát Triển

<a name="quick-start-cloud"></a>

Chúng tôi đã tạo một container phát triển được cấu hình sẵn để giảm thiểu thời gian thiết lập và đảm bảo bạn có tất cả các công cụ cần thiết cho khóa học Generative AI với Java này. Chọn cách tiếp cận phát triển ưa thích của bạn:

### Các Lựa Chọn Thiết Lập Môi Trường:

#### Lựa Chọn A: GitHub Codespaces (Khuyến Nghị)

**Bắt đầu lập trình trong 2 phút - không cần thiết lập cục bộ!**

1. Fork repository này vào tài khoản GitHub của bạn  
   > **Lưu ý**: Nếu bạn muốn chỉnh sửa cấu hình cơ bản, vui lòng xem [Cấu Hình Dev Container](../../../.devcontainer/devcontainer.json)
2. Nhấp vào **Code** → tab **Codespaces** → **...** → **New with options...**
3. Sử dụng các thiết lập mặc định – điều này sẽ chọn **Cấu hình Dev container**: **Generative AI Java Development Environment** devcontainer tùy chỉnh được tạo cho khóa học này
4. Nhấp vào **Create codespace**
5. Chờ ~2 phút để môi trường sẵn sàng
6. Tiếp tục đến [Bước 2: Tạo GitHub Token](../../../02-SetupDevEnvironment)

<img src="./images/codespaces.png" alt="Ảnh chụp màn hình: Menu Codespaces" width="50%">

<img src="./images/image.png" alt="Ảnh chụp màn hình: New with options" width="50%">

<img src="./images/codespaces-create.png" alt="Ảnh chụp màn hình: Tùy chọn tạo codespace" width="50%">

> **Lợi Ích của Codespaces**:
> - Không cần cài đặt cục bộ
> - Hoạt động trên bất kỳ thiết bị nào có trình duyệt
> - Được cấu hình sẵn với tất cả công cụ và phụ thuộc
> - Miễn phí 60 giờ mỗi tháng cho tài khoản cá nhân
> - Môi trường nhất quán cho tất cả người học

#### Lựa Chọn B: Container Cục Bộ

**Dành cho các nhà phát triển thích phát triển cục bộ với Docker**

1. Fork và clone repository này vào máy của bạn  
   > **Lưu ý**: Nếu bạn muốn chỉnh sửa cấu hình cơ bản, vui lòng xem [Cấu Hình Dev Container](../../../.devcontainer/devcontainer.json)
2. Cài đặt [Docker Desktop](https://www.docker.com/products/docker-desktop/) và [VS Code](https://code.visualstudio.com/)
3. Cài đặt [Dev Containers extension](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) trong VS Code
4. Mở thư mục repository trong VS Code
5. Khi được nhắc, nhấp vào **Reopen in Container** (hoặc sử dụng `Ctrl+Shift+P` → "Dev Containers: Reopen in Container")
6. Chờ container được xây dựng và khởi động
7. Tiếp tục đến [Bước 2: Tạo GitHub Token](../../../02-SetupDevEnvironment)

<img src="./images/devcontainer.png" alt="Ảnh chụp màn hình: Thiết lập Dev container" width="50%">

<img src="./images/image-3.png" alt="Ảnh chụp màn hình: Hoàn thành xây dựng Dev container" width="50%">

#### Lựa Chọn C: Sử Dụng Cài Đặt Cục Bộ Hiện Có

**Dành cho các nhà phát triển đã có môi trường Java**

Yêu cầu:
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) hoặc IDE ưa thích của bạn

Các bước:
1. Clone repository này vào máy của bạn
2. Mở dự án trong IDE của bạn
3. Tiếp tục đến [Bước 2: Tạo GitHub Token](../../../02-SetupDevEnvironment)

> **Mẹo Chuyên Nghiệp**: Nếu bạn có máy cấu hình thấp nhưng muốn sử dụng VS Code cục bộ, hãy sử dụng GitHub Codespaces! Bạn có thể kết nối VS Code cục bộ của mình với một Codespace trên đám mây để có trải nghiệm tốt nhất của cả hai.

<img src="./images/image-2.png" alt="Ảnh chụp màn hình: Tạo instance devcontainer cục bộ" width="50%">

## Bước 2: Tạo GitHub Personal Access Token

1. Truy cập [GitHub Settings](https://github.com/settings/profile) và chọn **Settings** từ menu hồ sơ của bạn.
2. Trong thanh bên trái, nhấp vào **Developer settings** (thường ở cuối).
3. Dưới **Personal access tokens**, nhấp vào **Fine-grained tokens** (hoặc theo liên kết trực tiếp [này](https://github.com/settings/personal-access-tokens)).
4. Nhấp vào **Generate new token**.
5. Trong "Token name", cung cấp một tên mô tả (ví dụ: `GenAI-Java-Course-Token`).
6. Đặt ngày hết hạn (khuyến nghị: 7 ngày để đảm bảo an toàn).
7. Trong "Resource owner", chọn tài khoản người dùng của bạn.
8. Trong "Repository access", chọn các repository bạn muốn sử dụng với GitHub Models (hoặc "All repositories" nếu cần).
9. Trong "Repository permissions", tìm **Models** và đặt thành **Read and write**.
10. Nhấp vào **Generate token**.
11. **Sao chép và lưu token của bạn ngay bây giờ** – bạn sẽ không thể xem lại nó!

> **Mẹo Bảo Mật**: Sử dụng phạm vi tối thiểu cần thiết và thời gian hết hạn ngắn nhất có thể cho các token truy cập của bạn.

## Bước 3: Kiểm Tra Thiết Lập với Ví Dụ GitHub Models

Khi môi trường phát triển của bạn đã sẵn sàng, hãy kiểm tra tích hợp GitHub Models với ứng dụng ví dụ của chúng tôi trong [`02-SetupDevEnvironment/src/github-models`](../../../02-SetupDevEnvironment/src/github-models).

1. Mở terminal trong môi trường phát triển của bạn.
2. Điều hướng đến ví dụ GitHub Models:
   ```bash
   cd 02-SetupDevEnvironment/src/github-models
   ```
3. Đặt token GitHub của bạn làm biến môi trường:
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. Chạy ứng dụng:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

Bạn sẽ thấy đầu ra tương tự như:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### Hiểu Mã Ví Dụ

Trước tiên, hãy hiểu những gì bạn sắp chạy. Ví dụ sử dụng OpenAI Java SDK để kết nối với GitHub Models:

**Những gì mã này làm:**
- **Kết nối** với GitHub Models bằng token truy cập cá nhân của bạn
- **Gửi** một thông điệp đơn giản "Say Hello World!" đến mô hình AI
- **Nhận** và hiển thị phản hồi của AI
- **Xác nhận** thiết lập của bạn hoạt động chính xác

**Phụ Thuộc Chính** (trong `pom.xml`):
```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

**Mã Chính** (`App.java`):
```java
// Connect to GitHub Models using OpenAI Java SDK
OpenAIClient client = OpenAIOkHttpClient.builder()
    .apiKey(pat)
    .baseUrl("https://models.inference.ai.azure.com")
    .build();

// Create chat completion request
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .model(modelId)
    .addSystemMessage("You are a concise assistant.")
    .addUserMessage("Say Hello World!")
    .build();

// Get AI response
ChatCompletion response = client.chat().completions().create(params);
System.out.println("Response: " + response.choices().get(0).message().content().orElse("No response content"));
```

## Tóm Tắt

**Chúc mừng!** Bạn đã hoàn thành:

- **Tạo GitHub Personal Access Token** với quyền phù hợp để truy cập mô hình AI
- **Thiết lập môi trường phát triển Java** bằng Codespaces, container dev, hoặc cài đặt cục bộ
- **Kết nối với GitHub Models** bằng OpenAI Java SDK để truy cập AI miễn phí
- **Kiểm tra tích hợp** với một ứng dụng ví dụ hoạt động giao tiếp với các mô hình AI

## Các Bước Tiếp Theo

[Chương 3: Kỹ Thuật Generative AI Cốt Lõi](../03-CoreGenerativeAITechniques/README.md)

## Khắc Phục Sự Cố

Gặp vấn đề? Dưới đây là các vấn đề phổ biến và cách giải quyết:

- **Token không hoạt động?** 
  - Đảm bảo bạn đã sao chép toàn bộ token mà không có khoảng trắng thừa
  - Xác minh token được đặt chính xác làm biến môi trường
  - Kiểm tra token của bạn có quyền chính xác (Models: Read and write)

- **Không tìm thấy Maven?** 
  - Nếu sử dụng container dev/Codespaces, Maven sẽ được cài đặt sẵn
  - Đối với thiết lập cục bộ, đảm bảo Java 21+ và Maven 3.9+ đã được cài đặt
  - Thử `mvn --version` để xác minh cài đặt

- **Vấn đề kết nối?** 
  - Kiểm tra kết nối internet của bạn
  - Xác minh GitHub có thể truy cập từ mạng của bạn
  - Đảm bảo bạn không bị tường lửa chặn endpoint GitHub Models

- **Container dev không khởi động?** 
  - Đảm bảo Docker Desktop đang chạy (đối với phát triển cục bộ)
  - Thử xây dựng lại container: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container"

- **Lỗi biên dịch ứng dụng?**
  - Đảm bảo bạn đang ở đúng thư mục: `02-SetupDevEnvironment/src/github-models`
  - Thử làm sạch và xây dựng lại: `mvn clean compile`

> **Cần trợ giúp?**: Vẫn gặp vấn đề? Mở một issue trong repository và chúng tôi sẽ hỗ trợ bạn.

**Tuyên bố miễn trừ trách nhiệm**:  
Tài liệu này đã được dịch bằng dịch vụ dịch thuật AI [Co-op Translator](https://github.com/Azure/co-op-translator). Mặc dù chúng tôi cố gắng đảm bảo độ chính xác, xin lưu ý rằng các bản dịch tự động có thể chứa lỗi hoặc không chính xác. Tài liệu gốc bằng ngôn ngữ bản địa nên được coi là nguồn thông tin chính thức. Đối với các thông tin quan trọng, khuyến nghị sử dụng dịch vụ dịch thuật chuyên nghiệp từ con người. Chúng tôi không chịu trách nhiệm về bất kỳ sự hiểu lầm hoặc diễn giải sai nào phát sinh từ việc sử dụng bản dịch này.