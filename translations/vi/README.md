# Trí Tuệ Nhân Tạo Tạo Sinh cho Người Mới Bắt Đầu - Phiên Bản Java  
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Trí Tuệ Nhân Tạo Tạo Sinh cho Người Mới Bắt Đầu - Phiên Bản Java](../../translated_images/vi/beg-genai-series.8b48be9951cc574c.webp)

**Thời gian cam kết**: Toàn bộ hội thảo có thể hoàn thành trực tuyến mà không cần thiết lập cục bộ. Việc thiết lập môi trường mất 2 phút, khám phá các mẫu mất từ 1-3 giờ tùy theo độ sâu khám phá.

> **Bắt đầu nhanh** 

1. Fork kho lưu trữ này vào tài khoản GitHub của bạn  
2. Nhấn **Code** → tab **Codespaces** → **...** → **Mới với tùy chọn...**  
3. Sử dụng các thiết lập mặc định – điều này sẽ chọn container Phát Triển được tạo cho khóa học này  
4. Nhấn **Tạo codespace**  
5. Chờ khoảng ~2 phút để môi trường sẵn sàng  
6. Bắt đầu ngay tại [Ví dụ đầu tiên](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **Thích Clone Cục Bộ hơn?**  
>  
> Kho lưu trữ này bao gồm hơn 50 bản dịch ngôn ngữ làm tăng đáng kể kích thước tải xuống. Để clone mà không cần bản dịch, sử dụng sparse checkout:  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> Điều này cung cấp cho bạn mọi thứ cần thiết để hoàn thành khóa học với tốc độ tải xuống nhanh hơn nhiều.


## Hỗ Trợ Đa Ngôn Ngữ

### Hỗ trợ qua GitHub Action (Tự động & Luôn cập nhật)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Tiếng Ả Rập](../ar/README.md) | [Tiếng Bengal](../bn/README.md) | [Tiếng Bulgari](../bg/README.md) | [Tiếng Miến Điện (Myanmar)](../my/README.md) | [Tiếng Trung (Giản Thể)](../zh-CN/README.md) | [Tiếng Trung (Phồn Thể, Hồng Kông)](../zh-HK/README.md) | [Tiếng Trung (Phồn Thể, Macau)](../zh-MO/README.md) | [Tiếng Trung (Phồn Thể, Đài Loan)](../zh-TW/README.md) | [Tiếng Croatia](../hr/README.md) | [Tiếng Séc](../cs/README.md) | [Tiếng Đan Mạch](../da/README.md) | [Tiếng Hà Lan](../nl/README.md) | [Tiếng Estonia](../et/README.md) | [Tiếng Phần Lan](../fi/README.md) | [Tiếng Pháp](../fr/README.md) | [Tiếng Đức](../de/README.md) | [Tiếng Hy Lạp](../el/README.md) | [Tiếng Do Thái](../he/README.md) | [Tiếng Hindi](../hi/README.md) | [Tiếng Hungary](../hu/README.md) | [Tiếng Indonesia](../id/README.md) | [Tiếng Ý](../it/README.md) | [Tiếng Nhật](../ja/README.md) | [Tiếng Kannada](../kn/README.md) | [Tiếng Hàn](../ko/README.md) | [Tiếng Litva](../lt/README.md) | [Tiếng Mã Lai](../ms/README.md) | [Tiếng Malayalam](../ml/README.md) | [Tiếng Marathi](../mr/README.md) | [Tiếng Nepal](../ne/README.md) | [Tiếng Pidgin Nigeria](../pcm/README.md) | [Tiếng Na Uy](../no/README.md) | [Tiếng Ba Tư (Farsi)](../fa/README.md) | [Tiếng Ba Lan](../pl/README.md) | [Tiếng Bồ Đào Nha (Brazil)](../pt-BR/README.md) | [Tiếng Bồ Đào Nha (Bồ Đào Nha)](../pt-PT/README.md) | [Tiếng Punjabi (Gurmukhi)](../pa/README.md) | [Tiếng Rumani](../ro/README.md) | [Tiếng Nga](../ru/README.md) | [Tiếng Serbia (Chữ Cyrillic)](../sr/README.md) | [Tiếng Slovak](../sk/README.md) | [Tiếng Slovenia](../sl/README.md) | [Tiếng Tây Ban Nha](../es/README.md) | [Tiếng Swahili](../sw/README.md) | [Tiếng Thụy Điển](../sv/README.md) | [Tiếng Tagalog (Filipino)](../tl/README.md) | [Tiếng Tamil](../ta/README.md) | [Tiếng Telugu](../te/README.md) | [Tiếng Thái](../th/README.md) | [Tiếng Thổ Nhĩ Kỳ](../tr/README.md) | [Tiếng Ukraina](../uk/README.md) | [Tiếng Urdu](../ur/README.md) | [Tiếng Việt](./README.md)

> **Thích Clone Cục Bộ hơn?**  

> Kho lưu trữ này bao gồm hơn 50 bản dịch ngôn ngữ làm tăng đáng kể kích thước tải xuống. Để clone mà không cần bản dịch, sử dụng sparse checkout:  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> Điều này cung cấp cho bạn mọi thứ cần thiết để hoàn thành khóa học với tốc độ tải xuống nhanh hơn nhiều.  
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Cấu Trúc Khóa Học & Lộ Trình Học

### **Chương 1: Giới thiệu về Trí Tuệ Nhân Tạo Tạo Sinh**  
- **Khái Niệm Cốt Lõi**: Hiểu về Mô hình Ngôn ngữ Lớn, token, embeddings, và khả năng AI  
- **Hệ Sinh Thái AI Java**: Tổng quan về Spring AI và các SDK OpenAI  
- **Giao Thức Ngữ Cảnh Mô Hình**: Giới thiệu MCP và vai trò trong giao tiếp đại lý AI  
- **Ứng Dụng Thực Tiễn**: Các kịch bản thực tiễn bao gồm chatbot và tạo nội dung  
- **[→ Bắt đầu Chương 1](./01-IntroToGenAI/README.md)**

### **Chương 2: Thiết Lập Môi Trường Phát Triển**  
- **Cấu Hình Đa Nhà Cung Cấp**: Thiết lập GitHub Models, Azure OpenAI, và tích hợp OpenAI Java SDK  
- **Spring Boot + Spring AI**: Thực hành tốt nhất để phát triển ứng dụng AI doanh nghiệp  
- **GitHub Models**: Truy cập mô hình AI miễn phí để tạo mẫu và học tập (không cần thẻ tín dụng)  
- **Công Cụ Phát Triển**: Docker container, VS Code, và thiết lập GitHub Codespaces  
- **[→ Bắt đầu Chương 2](./02-SetupDevEnvironment/README.md)**

### **Chương 3: Kỹ Thuật Cốt Lõi của Trí Tuệ Nhân Tạo Tạo Sinh**  
- **Kỹ thuật Prompt Engineering**: Kỹ thuật để có phản hồi tối ưu từ mô hình AI  
- **Embeddings & Các phép toán Vector**: Triển khai tìm kiếm ngữ nghĩa và so khớp tương tự  
- **Retrieval-Augmented Generation (RAG)**: Kết hợp AI với nguồn dữ liệu của riêng bạn  
- **Function Calling**: Mở rộng khả năng AI với công cụ và plugin tùy chỉnh  
- **[→ Bắt đầu Chương 3](./03-CoreGenerativeAITechniques/README.md)**

### **Chương 4: Ứng Dụng Thực Tiễn & Dự Án**  
- **Trình tạo câu chuyện thú cưng** (`petstory/`): Tạo nội dung sáng tạo với GitHub Models  
- **Demo Foundry Local** (`foundrylocal/`): Tích hợp mô hình AI cục bộ với OpenAI Java SDK  
- **Dịch vụ Máy tính MCP** (`calculator/`): Triển khai cơ bản Giao thức Ngữ Cảnh Mô Hình với Spring AI  
- **[→ Bắt đầu Chương 4](./04-PracticalSamples/README.md)**

### **Chương 5: Phát Triển AI Có Trách Nhiệm**  
- **An toàn GitHub Models**: Thử nghiệm lọc nội dung tích hợp và cơ chế an toàn (chặn cứng và từ chối nhẹ)  
- **Demo AI Có Trách Nhiệm**: Ví dụ thực hành cho thấy cách các hệ thống an toàn AI hiện đại hoạt động  
- **Thực hành tốt nhất**: Các hướng dẫn thiết yếu cho phát triển và triển khai AI có đạo đức  
- **[→ Bắt đầu Chương 5](./05-ResponsibleGenAI/README.md)**

## Tài Nguyên Bổ Sung

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain  
[![LangChain4j cho Người Mới Bắt Đầu](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)  
[![LangChain.js cho Người Mới Bắt Đầu](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### Azure / Edge / MCP / Đại lý  
[![AZD cho Người Mới Bắt Đầu](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![Edge AI cho Người Mới Bắt Đầu](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![MCP cho Người Mới Bắt Đầu](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![Đại lý AI cho Người Mới Bắt Đầu](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Chuỗi Trí Tuệ Nhân Tạo Tạo Sinh  
[![Trí Tuệ Nhân Tạo Tạo Sinh cho Người Mới Bắt Đầu](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![Trí Tuệ Nhân Tạo Tạo Sinh (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)  
[![Trí Tuệ Nhân Tạo Tạo Sinh (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)  
[![Trí Tuệ Nhân Tạo Tạo Sinh (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### Học Tập Cơ Bản  
[![Máy Học cho Người Mới Bắt Đầu](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)  
[![Khoa Học Dữ Liệu cho Người Mới Bắt Đầu](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)  
[![AI cho Người Mới Bắt Đầu](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)  
[![An Ninh Mạng cho Người Mới Bắt Đầu](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Dòng Copilot
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## Nhận Trợ Giúp

Nếu bạn gặp khó khăn hoặc có bất kỳ câu hỏi nào về việc xây dựng ứng dụng AI, hãy tham gia cùng những người học khác và các nhà phát triển có kinh nghiệm trong các cuộc thảo luận về MCP. Đây là một cộng đồng hỗ trợ, nơi các câu hỏi được chào đón và kiến thức được chia sẻ một cách tự do.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

Nếu bạn có phản hồi về sản phẩm hoặc gặp lỗi trong quá trình xây dựng, hãy truy cập:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Tuyên bố miễn trừ trách nhiệm**:  
Tài liệu này đã được dịch bằng dịch vụ dịch thuật AI [Co-op Translator](https://github.com/Azure/co-op-translator). Mặc dù chúng tôi cố gắng đảm bảo độ chính xác, xin lưu ý rằng bản dịch tự động có thể chứa lỗi hoặc không chính xác. Tài liệu gốc bằng ngôn ngữ gốc của nó được coi là nguồn thông tin chính xác và có thẩm quyền. Đối với các thông tin quan trọng, khuyến nghị sử dụng dịch vụ dịch thuật chuyên nghiệp do con người thực hiện. Chúng tôi không chịu trách nhiệm đối với bất kỳ sự hiểu lầm hoặc diễn giải sai nào phát sinh từ việc sử dụng bản dịch này.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->