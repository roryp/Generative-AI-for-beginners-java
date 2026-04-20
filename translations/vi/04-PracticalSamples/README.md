# Ứng Dụng Thực Tế & Dự Án

[![Ứng Dụng Thực Tế & Dự Án](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Ứng Dụng Thực Tế & Dự Án")

> **Tổng quan video:** [Xem "Ứng Dụng Thực Tế & Dự Án" trên YouTube](https://www.youtube.com/watch?v=01vJsYei3H0).

## Những gì bạn sẽ học
Trong phần này, chúng ta sẽ trình diễn ba ứng dụng thực tế minh họa mô hình phát triển AI sinh tạo với Java:
- Tạo trình tạo câu chuyện thú cưng đa phương thức kết hợp AI phía khách và phía máy chủ
- Triển khai tích hợp mô hình AI cục bộ với demo Foundry Local Spring Boot
- Phát triển dịch vụ Giao thức Ngữ cảnh Mô hình (MCP) với ví dụ Máy tính

## Mục lục

- [Giới thiệu](#giới-thiệu)
  - [Demo Foundry Local Spring Boot](#demo-foundry-local-spring-boot)
  - [Trình tạo câu chuyện thú cưng](#trình-tạo-câu-chuyện-thú-cưng)
  - [Dịch vụ Máy tính MCP (Demo MCP thân thiện cho người mới)](#dịch-vụ-máy-tính-mcp-demo-mcp-thân-thiện-cho-người-mới)
- [Tiến trình học tập](#tiến-trình-học-tập)
- [Tóm tắt](#tóm-tắt)
- [Bước tiếp theo](#bước-tiếp-theo)

## Giới thiệu

Chương này trình bày **các dự án mẫu** minh họa mô hình phát triển AI sinh tạo với Java. Mỗi dự án đầy đủ chức năng và trình diễn các công nghệ AI cụ thể, mẫu kiến trúc và thực tiễn tốt nhất mà bạn có thể áp dụng cho ứng dụng của mình.

### Demo Foundry Local Spring Boot

**[Demo Foundry Local Spring Boot](foundrylocal/README.md)** trình diễn cách tích hợp với các mô hình AI cục bộ sử dụng **OpenAI Java SDK**. Nó thể hiện kết nối với các mô hình chạy trên Foundry Local (ví dụ: **Phi-4-mini**), với tính năng phát hiện mô hình tự động, cho phép bạn chạy ứng dụng AI mà không cần phụ thuộc dịch vụ đám mây.

### Trình tạo câu chuyện thú cưng

**[Trình tạo câu chuyện thú cưng](petstory/README.md)** là ứng dụng web Spring Boot hấp dẫn thể hiện **xử lý AI đa phương thức** để tạo các câu chuyện thú cưng sáng tạo. Nó kết hợp khả năng AI phía khách và phía máy chủ sử dụng transformer.js cho tương tác AI bên trình duyệt và OpenAI SDK cho xử lý phía máy chủ.

### Dịch vụ Máy tính MCP (Demo MCP thân thiện cho người mới)

**[Dịch vụ Máy tính MCP](calculator/README.md)** là minh họa đơn giản của **Giao thức Ngữ cảnh Mô hình (MCP)** dùng Spring AI. Nó cung cấp lời giới thiệu dễ tiếp cận về các khái niệm MCP, cho thấy cách tạo máy chủ MCP cơ bản tương tác với các khách hàng MCP.

## Tiến trình học tập

Các dự án này được thiết kế để phát triển dựa trên các khái niệm của các chương trước:

1. **Bắt đầu đơn giản**: Khởi đầu với Demo Foundry Local Spring Boot để hiểu tích hợp AI cơ bản với mô hình cục bộ
2. **Thêm tương tác**: Tiến tới Trình tạo câu chuyện thú cưng cho AI đa phương thức và tương tác trên web
3. **Học cơ bản MCP**: Thử Dịch vụ Máy tính MCP để hiểu nền tảng Giao thức Ngữ cảnh Mô hình

## Tóm tắt

Làm tốt lắm! Giờ bạn đã khám phá một số ứng dụng thực tế:

- Trải nghiệm AI đa phương thức hoạt động cả trình duyệt và máy chủ
- Tích hợp mô hình AI cục bộ dùng các framework và SDK Java hiện đại
- Dịch vụ Giao thức Ngữ cảnh Mô hình đầu tiên để thấy cách công cụ tích hợp với AI

## Bước tiếp theo

[Chương 5: AI Sinh Tạo Trách Nhiệm](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Tuyên bố miễn trừ trách nhiệm**:  
Tài liệu này đã được dịch bằng dịch vụ dịch thuật AI [Co-op Translator](https://github.com/Azure/co-op-translator). Mặc dù chúng tôi cố gắng đảm bảo độ chính xác, xin lưu ý rằng các bản dịch tự động có thể chứa lỗi hoặc không chính xác. Tài liệu gốc bằng ngôn ngữ bản địa nên được coi là nguồn chính thức. Đối với thông tin quan trọng, nên sử dụng dịch vụ dịch thuật chuyên nghiệp do con người thực hiện. Chúng tôi không chịu trách nhiệm về bất kỳ sự hiểu lầm hoặc giải thích sai nào phát sinh từ việc sử dụng bản dịch này.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->