<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "df269f529a172a0197ef28460bf1da9f",
  "translation_date": "2025-07-25T11:40:07+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "vi"
}
-->
# Ứng dụng thực tiễn & Dự án

## Những điều bạn sẽ học
Trong phần này, chúng ta sẽ trình bày ba ứng dụng thực tiễn minh họa các mẫu phát triển AI sinh với Java:
- Tạo một Trình tạo Câu chuyện Thú cưng đa phương thức kết hợp AI phía khách hàng và phía máy chủ
- Triển khai tích hợp mô hình AI cục bộ với bản demo Foundry Local Spring Boot
- Phát triển dịch vụ Giao thức Ngữ cảnh Mô hình (MCP) với ví dụ Máy tính

## Mục lục

- [Giới thiệu](../../../04-PracticalSamples)
  - [Demo Foundry Local Spring Boot](../../../04-PracticalSamples)
  - [Trình tạo Câu chuyện Thú cưng](../../../04-PracticalSamples)
  - [Dịch vụ MCP Máy tính (Demo MCP thân thiện với người mới bắt đầu)](../../../04-PracticalSamples)
- [Tiến trình học tập](../../../04-PracticalSamples)
- [Tóm tắt](../../../04-PracticalSamples)
- [Bước tiếp theo](../../../04-PracticalSamples)

## Giới thiệu

Chương này trình bày các **dự án mẫu** minh họa các mẫu phát triển AI sinh với Java. Mỗi dự án đều hoạt động đầy đủ và thể hiện các công nghệ AI cụ thể, các mẫu kiến trúc, và các thực tiễn tốt nhất mà bạn có thể áp dụng cho các ứng dụng của riêng mình.

### Demo Foundry Local Spring Boot

**[Demo Foundry Local Spring Boot](foundrylocal/README.md)** minh họa cách tích hợp với các mô hình AI cục bộ bằng **OpenAI Java SDK**. Nó trình bày cách kết nối với mô hình **Phi-3.5-mini** chạy trên Foundry Local, cho phép bạn chạy các ứng dụng AI mà không cần dựa vào dịch vụ đám mây.

### Trình tạo Câu chuyện Thú cưng

**[Trình tạo Câu chuyện Thú cưng](petstory/README.md)** là một ứng dụng web Spring Boot hấp dẫn, minh họa **xử lý AI đa phương thức** để tạo ra các câu chuyện thú cưng sáng tạo. Nó kết hợp khả năng AI phía khách hàng và phía máy chủ bằng cách sử dụng transformer.js cho các tương tác AI trên trình duyệt và OpenAI SDK cho xử lý phía máy chủ.

### Dịch vụ MCP Máy tính (Demo MCP thân thiện với người mới bắt đầu)

**[Dịch vụ MCP Máy tính](mcp/calculator/README.md)** là một minh họa đơn giản về **Giao thức Ngữ cảnh Mô hình (MCP)** sử dụng Spring AI. Nó cung cấp một giới thiệu thân thiện với người mới bắt đầu về các khái niệm MCP, cho thấy cách tạo một MCP Server cơ bản tương tác với các MCP Client.

## Tiến trình học tập

Các dự án này được thiết kế để xây dựng dựa trên các khái niệm từ các chương trước:

1. **Bắt đầu đơn giản**: Bắt đầu với Demo Foundry Local Spring Boot để hiểu tích hợp AI cơ bản với các mô hình cục bộ
2. **Thêm tính tương tác**: Tiến tới Trình tạo Câu chuyện Thú cưng để xử lý AI đa phương thức và tương tác trên web
3. **Học các khái niệm MCP cơ bản**: Thử Dịch vụ MCP Máy tính để hiểu các nguyên tắc cơ bản của Giao thức Ngữ cảnh Mô hình

## Tóm tắt

**Chúc mừng bạn!** Bạn đã thành công:

- **Tạo trải nghiệm AI đa phương thức** kết hợp xử lý AI phía khách hàng và phía máy chủ
- **Triển khai tích hợp mô hình AI cục bộ** bằng cách sử dụng các framework và SDK Java hiện đại
- **Phát triển các dịch vụ Giao thức Ngữ cảnh Mô hình** minh họa các mẫu tích hợp công cụ

## Bước tiếp theo

[Chương 5: AI Sinh có trách nhiệm](../05-ResponsibleGenAI/README.md)

**Tuyên bố miễn trừ trách nhiệm**:  
Tài liệu này đã được dịch bằng dịch vụ dịch thuật AI [Co-op Translator](https://github.com/Azure/co-op-translator). Mặc dù chúng tôi cố gắng đảm bảo độ chính xác, xin lưu ý rằng các bản dịch tự động có thể chứa lỗi hoặc không chính xác. Tài liệu gốc bằng ngôn ngữ bản địa nên được coi là nguồn thông tin chính thức. Đối với các thông tin quan trọng, khuyến nghị sử dụng dịch vụ dịch thuật chuyên nghiệp bởi con người. Chúng tôi không chịu trách nhiệm cho bất kỳ sự hiểu lầm hoặc diễn giải sai nào phát sinh từ việc sử dụng bản dịch này.