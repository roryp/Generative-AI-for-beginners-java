<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T19:12:59+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "vi"
}
-->
# Các Kỹ Thuật Cốt Lõi của AI Tạo Sinh

>**Note**: Chương này bao gồm một [**Hướng dẫn chi tiết**](./TUTORIAL.md) giúp bạn thực hành các mẫu đã hoàn thiện.

## Những Gì Bạn Sẽ Học
Trong chương này, chúng ta sẽ tìm hiểu 4 kỹ thuật cốt lõi của AI tạo sinh thông qua các ví dụ thực tế:
- Hoàn thành LLM và luồng hội thoại
- Gọi hàm
- Tạo sinh tăng cường truy xuất (RAG)
- Các biện pháp an toàn AI có trách nhiệm

## Mục Lục

- [Những Gì Bạn Sẽ Học](../../../03-CoreGenerativeAITechniques)
- [Yêu Cầu Trước](../../../03-CoreGenerativeAITechniques)
- [Bắt Đầu](../../../03-CoreGenerativeAITechniques)
- [Tổng Quan Về Các Ví Dụ](../../../03-CoreGenerativeAITechniques)
  - [1. Hoàn Thành LLM và Luồng Hội Thoại](../../../03-CoreGenerativeAITechniques)
  - [2. Hàm & Plugin với LLMs](../../../03-CoreGenerativeAITechniques)
  - [3. Tạo Sinh Tăng Cường Truy Xuất (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Trình Diễn An Toàn AI Có Trách Nhiệm](../../../03-CoreGenerativeAITechniques)
- [Tóm Tắt](../../../03-CoreGenerativeAITechniques)
- [Bước Tiếp Theo](../../../03-CoreGenerativeAITechniques)

## Yêu Cầu Trước

- Hoàn thành thiết lập từ [Chương 2](../../../02-SetupDevEnvironment)

## Bắt Đầu

1. **Đi đến thư mục ví dụ**: 
```bash
cd 03-CoreGenerativeAITechniques/examples/
```
2. **Thiết lập môi trường**: 
```bash
export GITHUB_TOKEN=your_token_here
```
3. **Biên dịch và chạy các ví dụ**:
```bash
   # Run completions example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
   
   # Run functions example  
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
   
   # Run RAG example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
   
   # Run responsible AI demo
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```

## Tổng Quan Về Các Ví Dụ

Các ví dụ được tổ chức trong thư mục `examples/` với cấu trúc sau:

```
examples/
├── src/main/java/com/example/genai/techniques/
│   ├── completions/
│   │   └── LLMCompletionsApp.java        # Basic completions 
│   ├── functions/
│   │   └── FunctionsApp.java             # Function calling examples
│   ├── rag/
│   │   └── SimpleReaderDemo.java         # Retrieval-Augmented Generation
│   └── responsibleai/
│       └── ResponsibleGithubModels.java  # Responsible AI safety demonstration
├── document.txt                          # Sample document for RAG example
└── pom.xml                               # Maven configuration
```

### 1. Hoàn Thành LLM và Luồng Hội Thoại
**Tệp**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Học cách xây dựng AI hội thoại với phản hồi theo luồng và quản lý lịch sử hội thoại.

Ví dụ này minh họa:
- Hoàn thành văn bản đơn giản với các lời nhắc hệ thống
- Hội thoại nhiều lượt với quản lý lịch sử
- Phiên trò chuyện tương tác
- Cấu hình tham số (nhiệt độ, số lượng token tối đa)

### 2. Hàm & Plugin với LLMs
**Tệp**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Mở rộng khả năng AI bằng cách cung cấp cho mô hình quyền truy cập vào các hàm tùy chỉnh và API bên ngoài.

Ví dụ này minh họa:
- Tích hợp hàm thời tiết
- Triển khai hàm máy tính  
- Gọi nhiều hàm trong một cuộc hội thoại
- Định nghĩa hàm với các JSON schema

### 3. Tạo Sinh Tăng Cường Truy Xuất (RAG)
**Tệp**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Học cách kết hợp AI với tài liệu và nguồn dữ liệu của bạn để có phản hồi chính xác, dựa trên ngữ cảnh.

Ví dụ này minh họa:
- Trả lời câu hỏi dựa trên tài liệu với Azure OpenAI SDK
- Triển khai mẫu RAG với GitHub Models

**Cách sử dụng**: Đặt câu hỏi về nội dung trong `document.txt` và nhận phản hồi từ AI chỉ dựa trên ngữ cảnh đó.

### 4. Trình Diễn An Toàn AI Có Trách Nhiệm
**Tệp**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Xem trước cách các biện pháp an toàn AI hoạt động bằng cách kiểm tra khả năng lọc nội dung của GitHub Models.

Ví dụ này minh họa:
- Lọc nội dung cho các lời nhắc có khả năng gây hại
- Xử lý phản hồi an toàn trong ứng dụng
- Các loại nội dung bị chặn khác nhau (bạo lực, ngôn từ thù ghét, thông tin sai lệch)
- Xử lý lỗi đúng cách cho các vi phạm an toàn

> **Tìm Hiểu Thêm**: Đây chỉ là phần giới thiệu về các khái niệm AI có trách nhiệm. Để biết thêm thông tin về đạo đức, giảm thiểu thiên vị, cân nhắc quyền riêng tư, và các khung AI có trách nhiệm, xem [Chương 5: AI Tạo Sinh Có Trách Nhiệm](../05-ResponsibleGenAI/README.md).

## Tóm Tắt

Trong chương này, chúng ta đã khám phá hoàn thành LLM và luồng hội thoại, triển khai gọi hàm để mở rộng khả năng AI, tạo hệ thống Tạo Sinh Tăng Cường Truy Xuất (RAG), và trình diễn các biện pháp an toàn AI có trách nhiệm. 

> **NOTE**: Tìm hiểu sâu hơn với [**Hướng dẫn chi tiết**](./TUTORIAL.md)

## Bước Tiếp Theo

[Chương 4: Ứng Dụng Thực Tế & Dự Án](../04-PracticalSamples/README.md)

**Tuyên bố miễn trừ trách nhiệm**:  
Tài liệu này đã được dịch bằng dịch vụ dịch thuật AI [Co-op Translator](https://github.com/Azure/co-op-translator). Mặc dù chúng tôi cố gắng đảm bảo độ chính xác, xin lưu ý rằng các bản dịch tự động có thể chứa lỗi hoặc không chính xác. Tài liệu gốc bằng ngôn ngữ bản địa nên được coi là nguồn thông tin chính thức. Đối với các thông tin quan trọng, khuyến nghị sử dụng dịch vụ dịch thuật chuyên nghiệp từ con người. Chúng tôi không chịu trách nhiệm cho bất kỳ sự hiểu lầm hoặc diễn giải sai nào phát sinh từ việc sử dụng bản dịch này.