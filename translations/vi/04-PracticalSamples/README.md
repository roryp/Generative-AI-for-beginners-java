# Ứng Dụng Thực Tiễn & Dự Án

[![Ứng Dụng Thực Tiễn & Dự Án](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Ứng Dụng Thực Tiễn & Dự Án")

> **Tổng quan video:** [Xem "Ứng Dụng Thực Tiễn & Dự Án" trên YouTube](https://www.youtube.com/watch?v=01vJsYei3H0).

## Bạn Sẽ Học Gì
Trong phần này, chúng ta sẽ trình diễn ba ứng dụng thực tế thể hiện các mẫu phát triển AI tạo sinh với Java:
- Tạo một Trình Tạo Câu Chuyện Thú Cưng đa phương thức kết hợp AI phía khách và phía máy chủ
- Triển khai tích hợp mô hình AI cục bộ với demo Foundry Local Spring Boot
- Phát triển dịch vụ Giao thức Ngữ cảnh Mô hình (Model Context Protocol - MCP) với ví dụ Máy tính

## Mục Lục

- [Giới thiệu](#giới-thiệu)
  - [Demo Foundry Local Spring Boot](#demo-foundry-local-spring-boot)
  - [Trình Tạo Câu Chuyện Thú Cưng](#trình-tạo-câu-chuyện-thú-cưng)
  - [Dịch vụ MCP Máy tính (Demo MCP thân thiện với người mới)](#dịch-vụ-mcp-máy-tính-demo-mcp-thân-thiện-với-người-mới)
- [Quá trình Học tập](#quá-trình-học-tập)
- [Tóm tắt](#tóm-tắt)
- [Bước Tiếp theo](#bước-tiếp-theo)

## Giới thiệu

Chương này giới thiệu **các dự án mẫu** minh họa các mẫu phát triển AI tạo sinh với Java. Mỗi dự án đều hoạt động đầy đủ và trình bày các công nghệ AI cụ thể, mẫu kiến trúc và các thực hành tốt nhất mà bạn có thể áp dụng cho ứng dụng của riêng mình.

### Demo Foundry Local Spring Boot

**[Demo Foundry Local Spring Boot](foundrylocal/README.md)** trình bày cách tích hợp với các mô hình AI cục bộ sử dụng **OpenAI Java SDK**. Nó trình diễn việc kết nối với mô hình **Phi-3.5-mini** chạy trên Foundry Local, cho phép bạn chạy ứng dụng AI mà không cần phụ thuộc vào dịch vụ đám mây.

### Trình Tạo Câu Chuyện Thú Cưng

**[Trình Tạo Câu Chuyện Thú Cưng](petstory/README.md)** là một ứng dụng web Spring Boot hấp dẫn trình bày **xử lý AI đa phương thức** để tạo ra các câu chuyện thú cưng sáng tạo. Nó kết hợp khả năng AI phía khách và phía máy chủ bằng cách sử dụng transformer.js cho tương tác AI trên trình duyệt và SDK OpenAI cho xử lý phía máy chủ.

### Dịch vụ MCP Máy tính (Demo MCP thân thiện với người mới)

**[Dịch vụ MCP Máy tính](calculator/README.md)** là một ví dụ đơn giản về **Giao thức Ngữ cảnh Mô hình (MCP)** sử dụng Spring AI. Nó cung cấp một giới thiệu thân thiện cho người bắt đầu về các khái niệm MCP, trình bày cách tạo một MCP Server cơ bản tương tác với các client MCP.

## Quá trình Học tập

Các dự án này được thiết kế để xây dựng dựa trên những khái niệm từ các chương trước:

1. **Bắt đầu đơn giản**: Khởi đầu với demo Foundry Local Spring Boot để hiểu tích hợp AI cơ bản với các mô hình cục bộ
2. **Thêm tính tương tác**: Tiến đến Trình Tạo Câu Chuyện Thú Cưng cho AI đa phương thức và tương tác web
3. **Học cơ bản MCP**: Thử dịch vụ MCP Máy tính để hiểu các nguyên lý Giao thức Ngữ cảnh Mô hình

## Tóm tắt

Làm tốt lắm! Bạn đã khám phá một số ứng dụng thực tế:

- Trải nghiệm AI đa phương thức hoạt động cả trên trình duyệt lẫn máy chủ
- Tích hợp mô hình AI cục bộ sử dụng các framework và SDK Java hiện đại
- Dịch vụ Giao thức Ngữ cảnh Mô hình đầu tiên của bạn để thấy cách các công cụ tích hợp với AI

## Bước Tiếp theo

[Chương 5: AI tạo sinh có trách nhiệm](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Tuyên bố từ chối trách nhiệm**:  
Tài liệu này đã được dịch bằng dịch vụ dịch thuật AI [Co-op Translator](https://github.com/Azure/co-op-translator). Mặc dù chúng tôi cố gắng đảm bảo độ chính xác, xin lưu ý rằng các bản dịch tự động có thể chứa lỗi hoặc sai sót. Tài liệu gốc bằng ngôn ngữ gốc của nó nên được xem là nguồn đáng tin cậy nhất. Đối với những thông tin quan trọng, nên sử dụng dịch vụ dịch thuật chuyên nghiệp bởi con người. Chúng tôi không chịu trách nhiệm về bất kỳ hiểu lầm hoặc diễn giải sai nào phát sinh từ việc sử dụng bản dịch này.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->