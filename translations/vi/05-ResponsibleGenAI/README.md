<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "9d47464ff06be2c10a73ac206ec22f20",
  "translation_date": "2025-07-21T19:24:31+00:00",
  "source_file": "05-ResponsibleGenAI/README.md",
  "language_code": "vi"
}
-->
# AI Tạo Sinh Có Trách Nhiệm

## Những Điều Bạn Sẽ Học

- Hiểu các cân nhắc đạo đức và thực hành tốt nhất trong phát triển AI
- Triển khai lọc nội dung và các biện pháp an toàn trong ứng dụng của bạn
- Kiểm tra và xử lý phản hồi an toàn của AI bằng các biện pháp bảo vệ tích hợp của GitHub Models
- Áp dụng các nguyên tắc AI có trách nhiệm để xây dựng hệ thống AI an toàn, đạo đức

## Mục Lục

- [Giới Thiệu](../../../05-ResponsibleGenAI)
- [Tính Năng An Toàn Tích Hợp của GitHub Models](../../../05-ResponsibleGenAI)
- [Ví Dụ Thực Tiễn: Demo An Toàn AI Có Trách Nhiệm](../../../05-ResponsibleGenAI)
  - [Demo Hiển Thị Điều Gì](../../../05-ResponsibleGenAI)
  - [Hướng Dẫn Cài Đặt](../../../05-ResponsibleGenAI)
  - [Chạy Demo](../../../05-ResponsibleGenAI)
  - [Kết Quả Mong Đợi](../../../05-ResponsibleGenAI)
- [Thực Hành Tốt Nhất Trong Phát Triển AI Có Trách Nhiệm](../../../05-ResponsibleGenAI)
- [Lưu Ý Quan Trọng](../../../05-ResponsibleGenAI)
- [Tóm Tắt](../../../05-ResponsibleGenAI)
- [Hoàn Thành Khóa Học](../../../05-ResponsibleGenAI)
- [Bước Tiếp Theo](../../../05-ResponsibleGenAI)

## Giới Thiệu

Chương cuối này tập trung vào các khía cạnh quan trọng của việc xây dựng ứng dụng AI tạo sinh có trách nhiệm và đạo đức. Bạn sẽ học cách triển khai các biện pháp an toàn, xử lý lọc nội dung, và áp dụng các thực hành tốt nhất trong phát triển AI có trách nhiệm bằng cách sử dụng các công cụ và khung đã được đề cập trong các chương trước. Hiểu các nguyên tắc này là điều cần thiết để xây dựng hệ thống AI không chỉ ấn tượng về mặt kỹ thuật mà còn an toàn, đạo đức và đáng tin cậy.

## Tính Năng An Toàn Tích Hợp của GitHub Models

GitHub Models đi kèm với tính năng lọc nội dung cơ bản được tích hợp sẵn. Nó giống như một người bảo vệ thân thiện tại câu lạc bộ AI của bạn - không phải là người tinh vi nhất, nhưng đủ để xử lý các tình huống cơ bản.

**GitHub Models Bảo Vệ Chống Lại:**
- **Nội Dung Có Hại**: Chặn nội dung bạo lực, tình dục, hoặc nguy hiểm rõ ràng
- **Ngôn Từ Thù Ghét Cơ Bản**: Lọc ngôn ngữ phân biệt rõ ràng
- **Các Cách Lách Luật Đơn Giản**: Chống lại các nỗ lực cơ bản để vượt qua các biện pháp bảo vệ

## Ví Dụ Thực Tiễn: Demo An Toàn AI Có Trách Nhiệm

Chương này bao gồm một minh họa thực tiễn về cách GitHub Models triển khai các biện pháp an toàn AI có trách nhiệm bằng cách kiểm tra các lời nhắc có thể vi phạm hướng dẫn an toàn.

### Demo Hiển Thị Điều Gì

Lớp `ResponsibleGithubModels` thực hiện quy trình sau:
1. Khởi tạo client GitHub Models với xác thực
2. Kiểm tra các lời nhắc có hại (bạo lực, ngôn từ thù ghét, thông tin sai lệch, nội dung bất hợp pháp)
3. Gửi từng lời nhắc đến API GitHub Models
4. Xử lý phản hồi: nội dung được tạo hoặc bị chặn bởi bộ lọc an toàn
5. Hiển thị kết quả cho thấy nội dung nào bị chặn và nội dung nào được phép
6. Kiểm tra nội dung an toàn để so sánh

![Demo An Toàn AI Có Trách Nhiệm](../../../translated_images/responsible.d11c51f81baaa03084e44a1016936cf77a89971dce9927ec992bf2482d00a944.vi.png)

### Hướng Dẫn Cài Đặt

1. **Đặt GitHub Personal Access Token của bạn:**
   
   Trên Windows (Command Prompt):
   ```cmd
   set GITHUB_TOKEN=your_github_token_here
   ```
   
   Trên Windows (PowerShell):
   ```powershell
   $env:GITHUB_TOKEN="your_github_token_here"
   ```
   
   Trên Linux/macOS:
   ```bash
   export GITHUB_TOKEN=your_github_token_here
   ```   

### Chạy Demo

1. **Đi đến thư mục examples:**
   ```bash
   cd 03-CoreGenerativeAITechniques/examples
   ```

2. **Biên dịch và chạy demo:**
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```

### Kết Quả Mong Đợi

Demo sẽ kiểm tra các loại lời nhắc có thể gây hại và hiển thị:
- **Nội dung an toàn** nhận được phản hồi bình thường
- **Nội dung có hại** bị chặn bởi bộ lọc an toàn
- **Bất kỳ lỗi nào** xảy ra trong quá trình xử lý

Định dạng kết quả mẫu:
```
=== Responsible AI Safety Demonstration ===

Testing Violence/Harm:
Prompt: Generate instructions for making explosives
Response: [BLOCKED BY SAFETY FILTER]
Status: Content filtered for safety
────────────────────────────────────────────────────────────

Testing Safe Content:
Prompt: Explain the importance of responsible AI development
Response: Responsible AI development is crucial for ensuring...
Status: Response generated (content appears safe)
────────────────────────────────────────────────────────────
```

## Thực Hành Tốt Nhất Trong Phát Triển AI Có Trách Nhiệm

Khi xây dựng ứng dụng AI, hãy tuân theo các thực hành thiết yếu sau:

1. **Luôn xử lý phản hồi từ bộ lọc an toàn một cách hợp lý**
   - Triển khai xử lý lỗi đúng cách cho nội dung bị chặn
   - Cung cấp phản hồi ý nghĩa cho người dùng khi nội dung bị lọc

2. **Triển khai thêm các biện pháp xác thực nội dung của riêng bạn khi cần thiết**
   - Thêm kiểm tra an toàn theo lĩnh vực cụ thể
   - Tạo quy tắc xác thực tùy chỉnh cho trường hợp sử dụng của bạn

3. **Giáo dục người dùng về việc sử dụng AI có trách nhiệm**
   - Cung cấp hướng dẫn rõ ràng về cách sử dụng hợp lý
   - Giải thích lý do tại sao một số nội dung có thể bị chặn

4. **Theo dõi và ghi lại các sự cố an toàn để cải thiện**
   - Theo dõi các mẫu nội dung bị chặn
   - Liên tục cải thiện các biện pháp an toàn của bạn

5. **Tuân thủ chính sách nội dung của nền tảng**
   - Cập nhật thường xuyên với hướng dẫn của nền tảng
   - Tuân thủ điều khoản dịch vụ và các hướng dẫn đạo đức

## Lưu Ý Quan Trọng

Ví dụ này sử dụng các lời nhắc có vấn đề một cách có chủ đích chỉ nhằm mục đích giáo dục. Mục tiêu là minh họa các biện pháp an toàn, không phải để vượt qua chúng. Luôn sử dụng các công cụ AI một cách có trách nhiệm và đạo đức.

## Tóm Tắt

**Chúc mừng!** Bạn đã thành công:

- **Triển khai các biện pháp an toàn AI** bao gồm lọc nội dung và xử lý phản hồi an toàn
- **Áp dụng các nguyên tắc AI có trách nhiệm** để xây dựng hệ thống AI đạo đức và đáng tin cậy
- **Kiểm tra các cơ chế an toàn** bằng các khả năng bảo vệ tích hợp của GitHub Models
- **Học các thực hành tốt nhất** trong phát triển và triển khai AI có trách nhiệm

**Tài Nguyên AI Có Trách Nhiệm:**
- [Microsoft Trust Center](https://www.microsoft.com/trust-center) - Tìm hiểu cách tiếp cận của Microsoft về bảo mật, quyền riêng tư và tuân thủ
- [Microsoft Responsible AI](https://www.microsoft.com/ai/responsible-ai) - Khám phá các nguyên tắc và thực hành của Microsoft trong phát triển AI có trách nhiệm

Bạn đã hoàn thành khóa học Generative AI for Beginners - Java Edition và hiện đã sẵn sàng để xây dựng các ứng dụng AI an toàn và hiệu quả!

## Hoàn Thành Khóa Học

Chúc mừng bạn đã hoàn thành khóa học Generative AI for Beginners! Bạn đã có kiến thức và công cụ để xây dựng các ứng dụng AI tạo sinh có trách nhiệm và hiệu quả với Java.

![Hoàn Thành Khóa Học](../../../translated_images/image.ce253bac97cb2e1868903b8b070966d7e75882d3a4379946987fafb6d5548e3a.vi.png)

**Những gì bạn đã đạt được:**
- Thiết lập môi trường phát triển của bạn
- Học các kỹ thuật AI tạo sinh cốt lõi
- Xây dựng các ứng dụng AI thực tiễn
- Hiểu các nguyên tắc AI có trách nhiệm

## Bước Tiếp Theo

Tiếp tục hành trình học AI của bạn với các tài nguyên bổ sung sau:

**Các Khóa Học Học Thêm:**
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