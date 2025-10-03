<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "4d04ae8088f6a3c3fcbab18cbdfe4002",
  "translation_date": "2025-10-03T08:15:50+00:00",
  "source_file": "README.md",
  "language_code": "vi"
}
-->
# AI Tạo Sinh cho Người Mới Bắt Đầu - Phiên Bản Java
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![AI Tạo Sinh cho Người Mới Bắt Đầu - Phiên Bản Java](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.vi.png)

**Thời gian cam kết**: Toàn bộ hội thảo có thể hoàn thành trực tuyến mà không cần cài đặt cục bộ. Việc thiết lập môi trường mất 2 phút, với thời gian khám phá các mẫu từ 1-3 giờ tùy thuộc vào mức độ khám phá.

> **Bắt đầu nhanh**

1. Fork kho lưu trữ này vào tài khoản GitHub của bạn
2. Nhấp vào **Code** → tab **Codespaces** → **...** → **New with options...**
3. Sử dụng các tùy chọn mặc định – điều này sẽ chọn container phát triển được tạo cho khóa học này
4. Nhấp vào **Create codespace**
5. Chờ khoảng ~2 phút để môi trường sẵn sàng
6. Bắt đầu ngay với [Ví dụ đầu tiên](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Hỗ trợ đa ngôn ngữ

### Được hỗ trợ qua GitHub Action (Tự động & Luôn cập nhật)

[Tiếng Pháp](../fr/README.md) | [Tiếng Tây Ban Nha](../es/README.md) | [Tiếng Đức](../de/README.md) | [Tiếng Nga](../ru/README.md) | [Tiếng Ả Rập](../ar/README.md) | [Tiếng Ba Tư (Farsi)](../fa/README.md) | [Tiếng Urdu](../ur/README.md) | [Tiếng Trung (Giản thể)](../zh/README.md) | [Tiếng Trung (Phồn thể, Macau)](../mo/README.md) | [Tiếng Trung (Phồn thể, Hong Kong)](../hk/README.md) | [Tiếng Trung (Phồn thể, Đài Loan)](../tw/README.md) | [Tiếng Nhật](../ja/README.md) | [Tiếng Hàn](../ko/README.md) | [Tiếng Hindi](../hi/README.md) | [Tiếng Bengal](../bn/README.md) | [Tiếng Marathi](../mr/README.md) | [Tiếng Nepal](../ne/README.md) | [Tiếng Punjab (Gurmukhi)](../pa/README.md) | [Tiếng Bồ Đào Nha (Bồ Đào Nha)](../pt/README.md) | [Tiếng Bồ Đào Nha (Brazil)](../br/README.md) | [Tiếng Ý](../it/README.md) | [Tiếng Ba Lan](../pl/README.md) | [Tiếng Thổ Nhĩ Kỳ](../tr/README.md) | [Tiếng Hy Lạp](../el/README.md) | [Tiếng Thái](../th/README.md) | [Tiếng Thụy Điển](../sv/README.md) | [Tiếng Đan Mạch](../da/README.md) | [Tiếng Na Uy](../no/README.md) | [Tiếng Phần Lan](../fi/README.md) | [Tiếng Hà Lan](../nl/README.md) | [Tiếng Hebrew](../he/README.md) | [Tiếng Việt](./README.md) | [Tiếng Indonesia](../id/README.md) | [Tiếng Mã Lai](../ms/README.md) | [Tiếng Tagalog (Philippines)](../tl/README.md) | [Tiếng Swahili](../sw/README.md) | [Tiếng Hungary](../hu/README.md) | [Tiếng Séc](../cs/README.md) | [Tiếng Slovak](../sk/README.md) | [Tiếng Romania](../ro/README.md) | [Tiếng Bulgaria](../bg/README.md) | [Tiếng Serbia (Chữ Kirin)](../sr/README.md) | [Tiếng Croatia](../hr/README.md) | [Tiếng Slovenia](../sl/README.md) | [Tiếng Ukraina](../uk/README.md) | [Tiếng Miến Điện (Myanmar)](../my/README.md)

## Cấu trúc khóa học & Lộ trình học tập

### **Chương 1: Giới thiệu về AI Tạo Sinh**
- **Khái niệm cốt lõi**: Hiểu về Mô hình Ngôn ngữ Lớn, token, embeddings, và khả năng AI
- **Hệ sinh thái AI Java**: Tổng quan về Spring AI và OpenAI SDKs
- **Giao thức ngữ cảnh mô hình**: Giới thiệu về MCP và vai trò của nó trong giao tiếp của tác nhân AI
- **Ứng dụng thực tế**: Các tình huống thực tế bao gồm chatbot và tạo nội dung
- **[→ Bắt đầu Chương 1](./01-IntroToGenAI/README.md)**

### **Chương 2: Thiết lập môi trường phát triển**
- **Cấu hình đa nhà cung cấp**: Thiết lập tích hợp GitHub Models, Azure OpenAI, và OpenAI Java SDK
- **Spring Boot + Spring AI**: Các thực hành tốt nhất cho phát triển ứng dụng AI doanh nghiệp
- **GitHub Models**: Truy cập mô hình AI miễn phí để tạo mẫu và học tập (không cần thẻ tín dụng)
- **Công cụ phát triển**: Cấu hình Docker containers, VS Code, và GitHub Codespaces
- **[→ Bắt đầu Chương 2](./02-SetupDevEnvironment/README.md)**

### **Chương 3: Kỹ thuật AI Tạo Sinh cốt lõi**
- **Kỹ thuật tạo prompt**: Các kỹ thuật để có phản hồi tối ưu từ mô hình AI
- **Embeddings & Vector Operations**: Triển khai tìm kiếm ngữ nghĩa và so khớp tương tự
- **Tạo sinh tăng cường truy xuất (RAG)**: Kết hợp AI với các nguồn dữ liệu của bạn
- **Gọi hàm**: Mở rộng khả năng AI với các công cụ và plugin tùy chỉnh
- **[→ Bắt đầu Chương 3](./03-CoreGenerativeAITechniques/README.md)**

### **Chương 4: Ứng dụng thực tế & Dự án**
- **Trình tạo câu chuyện thú cưng** (`petstory/`): Tạo nội dung sáng tạo với GitHub Models
- **Demo Foundry Local** (`foundrylocal/`): Tích hợp mô hình AI cục bộ với OpenAI Java SDK
- **Dịch vụ tính toán MCP** (`calculator/`): Triển khai cơ bản Giao thức ngữ cảnh mô hình với Spring AI
- **[→ Bắt đầu Chương 4](./04-PracticalSamples/README.md)**

### **Chương 5: Phát triển AI có trách nhiệm**
- **An toàn của GitHub Models**: Kiểm tra bộ lọc nội dung tích hợp và cơ chế an toàn (chặn cứng và từ chối mềm)
- **Demo AI có trách nhiệm**: Ví dụ thực hành cho thấy cách các hệ thống an toàn AI hiện đại hoạt động
- **Thực hành tốt nhất**: Các hướng dẫn thiết yếu cho phát triển và triển khai AI có đạo đức
- **[→ Bắt đầu Chương 5](./05-ResponsibleGenAI/README.md)**

## Tài nguyên bổ sung

- [AI Biên cho Người Mới Bắt Đầu](https://github.com/microsoft/edgeai-for-beginners)
- [MCP cho Người Mới Bắt Đầu](https://github.com/microsoft/mcp-for-beginners)
- [Tác nhân AI cho Người Mới Bắt Đầu](https://github.com/microsoft/ai-agents-for-beginners)
- [AI Tạo Sinh cho Người Mới Bắt Đầu sử dụng .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [AI Tạo Sinh cho Người Mới Bắt Đầu sử dụng JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [AI Tạo Sinh cho Người Mới Bắt Đầu](https://github.com/microsoft/generative-ai-for-beginners)
- [ML cho Người Mới Bắt Đầu](https://aka.ms/ml-beginners)
- [Khoa học Dữ liệu cho Người Mới Bắt Đầu](https://aka.ms/datascience-beginners)
- [AI cho Người Mới Bắt Đầu](https://aka.ms/ai-beginners)
- [An ninh mạng cho Người Mới Bắt Đầu](https://github.com/microsoft/Security-101)
- [Phát triển Web cho Người Mới Bắt Đầu](https://aka.ms/webdev-beginners)
- [IoT cho Người Mới Bắt Đầu](https://aka.ms/iot-beginners)
- [Phát triển XR cho Người Mới Bắt Đầu](https://github.com/microsoft/xr-development-for-beginners)
- [Làm chủ GitHub Copilot cho Lập trình Đôi AI](https://aka.ms/GitHubCopilotAI)
- [Làm chủ GitHub Copilot cho Nhà phát triển C#/.NET](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Chọn Cuộc Phiêu Lưu Copilot của Bạn](https://github.com/microsoft/CopilotAdventures)
- [Ứng dụng Chat RAG với Dịch vụ AI Azure](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Nhận hỗ trợ

Nếu bạn gặp khó khăn hoặc có bất kỳ câu hỏi nào về việc xây dựng ứng dụng AI, hãy tham gia:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Nếu bạn có phản hồi sản phẩm hoặc gặp lỗi trong quá trình xây dựng, hãy truy cập:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Tuyên bố miễn trừ trách nhiệm**:  
Tài liệu này đã được dịch bằng dịch vụ dịch thuật AI [Co-op Translator](https://github.com/Azure/co-op-translator). Mặc dù chúng tôi cố gắng đảm bảo độ chính xác, xin lưu ý rằng các bản dịch tự động có thể chứa lỗi hoặc không chính xác. Tài liệu gốc bằng ngôn ngữ bản địa nên được coi là nguồn thông tin chính thức. Đối với các thông tin quan trọng, khuyến nghị sử dụng dịch vụ dịch thuật chuyên nghiệp bởi con người. Chúng tôi không chịu trách nhiệm cho bất kỳ sự hiểu lầm hoặc diễn giải sai nào phát sinh từ việc sử dụng bản dịch này.