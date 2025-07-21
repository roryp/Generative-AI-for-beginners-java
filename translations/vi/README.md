<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2ee0f50497c11d1941347ac61fb017a9",
  "translation_date": "2025-07-21T19:03:54+00:00",
  "source_file": "README.md",
  "language_code": "vi"
}
-->
# AI Tạo Sinh cho Người Mới Bắt Đầu - Phiên Bản Java
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![AI Tạo Sinh cho Người Mới Bắt Đầu - Phiên Bản Java](../../translated_images/beg-genai-series.61edc4a6b2cc54284fa2d70eda26dc0ca2669e26e49655b842ea799cd6e16d2a.vi.png)

> **NOTE: Bắt đầu nhanh**: Toàn bộ khóa học có thể thực hiện trực tuyến - Không cần cài đặt cục bộ!
1. Fork kho lưu trữ này vào tài khoản GitHub của bạn
2. Nhấp vào **Code** → tab **Codespaces** → **...** → **New with options...**
3. Sử dụng các thiết lập mặc định – điều này sẽ chọn container Phát triển được tạo cho khóa học này
4. Nhấp vào **Create codespace**
5. Chờ khoảng ~2 phút để môi trường sẵn sàng
6. Chuyển ngay đến [Tạo GitHub Models Token của bạn](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Hỗ Trợ Đa Ngôn Ngữ

### Được hỗ trợ qua GitHub Action (Tự động & Luôn cập nhật)

[French](../fr/README.md) | [Spanish](../es/README.md) | [German](../de/README.md) | [Russian](../ru/README.md) | [Arabic](../ar/README.md) | [Persian (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Hindi](../hi/README.md) | [Bengali](../bn/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Portuguese (Brazil)](../br/README.md) | [Italian](../it/README.md) | [Polish](../pl/README.md) | [Turkish](../tr/README.md) | [Greek](../el/README.md) | [Thai](../th/README.md) | [Swedish](../sv/README.md) | [Danish](../da/README.md) | [Norwegian](../no/README.md) | [Finnish](../fi/README.md) | [Dutch](../nl/README.md) | [Hebrew](../he/README.md) | [Vietnamese](./README.md) | [Indonesian](../id/README.md) | [Malay](../ms/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Swahili](../sw/README.md) | [Hungarian](../hu/README.md) | [Czech](../cs/README.md) | [Slovak](../sk/README.md) | [Romanian](../ro/README.md) | [Bulgarian](../bg/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Croatian](../hr/README.md) | [Slovenian](../sl/README.md) | [Ukrainian](../uk/README.md) | [Burmese (Myanmar)](../my/README.md)

## Cấu Trúc Khóa Học & Lộ Trình Học Tập

**Thời gian cam kết**: Cài đặt môi trường mất 2 phút, với các bài hướng dẫn thực hành yêu cầu 1-3 giờ mỗi bài tùy thuộc vào mức độ khám phá.

### **Chương 1: Giới thiệu về AI Tạo Sinh**
- **Khái niệm cốt lõi**: Hiểu về Mô hình Ngôn ngữ Lớn, token, embedding và khả năng của AI
- **Hệ sinh thái AI Java**: Tổng quan về Spring AI và OpenAI SDKs
- **Giao thức Ngữ cảnh Mô hình**: Giới thiệu về MCP và vai trò của nó trong giao tiếp của tác nhân AI
- **Ứng dụng thực tiễn**: Các kịch bản thực tế bao gồm chatbot và tạo nội dung
- **[→ Bắt đầu Chương 1](./01-IntroToGenAI/README.md)**

### **Chương 2: Cài đặt Môi trường Phát triển**
- **Cấu hình Đa Nhà cung cấp**: Thiết lập GitHub Models, Azure OpenAI, và tích hợp OpenAI Java SDK
- **Spring Boot + Spring AI**: Các thực hành tốt nhất cho phát triển ứng dụng AI doanh nghiệp
- **GitHub Models**: Truy cập mô hình AI miễn phí để tạo mẫu và học tập (không cần thẻ tín dụng)
- **Công cụ Phát triển**: Cấu hình Docker containers, VS Code, và GitHub Codespaces
- **[→ Bắt đầu Chương 2](./02-SetupDevEnvironment/README.md)**

### **Chương 3: Kỹ thuật AI Tạo Sinh Cốt lõi**
- **Kỹ thuật Prompt**: Các kỹ thuật để có được phản hồi tối ưu từ mô hình AI
- **Embedding & Các phép toán Vector**: Triển khai tìm kiếm ngữ nghĩa và so khớp tương đồng
- **Tạo Sinh Tăng cường Truy xuất (RAG)**: Kết hợp AI với các nguồn dữ liệu của bạn
- **Gọi Hàm**: Mở rộng khả năng AI với các công cụ và plugin tùy chỉnh
- **[→ Bắt đầu Chương 3](./03-CoreGenerativeAITechniques/README.md)**

### **Chương 4: Ứng dụng Thực tiễn & Dự án**
- **Trình tạo Câu chuyện Thú cưng** (`petstory/`): Tạo nội dung sáng tạo với GitHub Models
- **Demo Foundry Cục bộ** (`foundrylocal/`): Tích hợp mô hình AI cục bộ với OpenAI Java SDK
- **Dịch vụ Máy tính MCP** (`mcp/calculator/`): Triển khai cơ bản Giao thức Ngữ cảnh Mô hình với Spring AI
- **[→ Bắt đầu Chương 4](./04-PracticalSamples/README.md)**

### **Chương 5: Phát triển AI Có Trách nhiệm**
- **An toàn của GitHub Models**: Kiểm tra bộ lọc nội dung và cơ chế an toàn tích hợp sẵn
- **Demo AI Có Trách nhiệm**: Ví dụ thực hành cho thấy cách các bộ lọc an toàn AI hoạt động trong thực tế
- **Thực hành tốt nhất**: Các hướng dẫn thiết yếu để phát triển và triển khai AI một cách đạo đức
- **[→ Bắt đầu Chương 5](./05-ResponsibleGenAI/README.md)**

## Tài Nguyên Bổ Sung 

- [AI Agents For Beginners](https://github.com/microsoft/ai-agents-for-beginners)
- [Generative AI for Beginners using .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generative AI for Beginners using JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generative AI for Beginners](https://github.com/microsoft/generative-ai-for-beginners)
- [ML for Beginners](https://aka.ms/ml-beginners)
- [Data Science for Beginners](https://aka.ms/datascience-beginners)
- [AI for Beginners](https://aka.ms/ai-beginners)
- [Cybersecurity for Beginners](https://github.com/microsoft/Security-101)
- [Web Dev for Beginners](https://aka.ms/webdev-beginners)
- [IoT for Beginners](https://aka.ms/iot-beginners)
- [XR Development for Beginners](https://github.com/microsoft/xr-development-for-beginners)
- [Mastering GitHub Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI)
- [Mastering GitHub Copilot for C#/.NET Developers](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Choose Your Own Copilot Adventure](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App with Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)

**Tuyên bố miễn trừ trách nhiệm**:  
Tài liệu này đã được dịch bằng dịch vụ dịch thuật AI [Co-op Translator](https://github.com/Azure/co-op-translator). Mặc dù chúng tôi cố gắng đảm bảo độ chính xác, xin lưu ý rằng các bản dịch tự động có thể chứa lỗi hoặc không chính xác. Tài liệu gốc bằng ngôn ngữ bản địa nên được coi là nguồn thông tin chính thức. Đối với các thông tin quan trọng, khuyến nghị sử dụng dịch vụ dịch thuật chuyên nghiệp bởi con người. Chúng tôi không chịu trách nhiệm về bất kỳ sự hiểu lầm hoặc diễn giải sai nào phát sinh từ việc sử dụng bản dịch này.