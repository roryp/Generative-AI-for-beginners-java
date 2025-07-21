<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T20:06:04+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "th"
}
-->
# แอป Pet Story

>**Note**: บทนี้มี [**Tutorial**](./TUTORIAL.md) ที่แนะนำวิธีการใช้งานตัวอย่างที่เสร็จสมบูรณ์

แอปพลิเคชันเว็บ Spring Boot ที่สร้างคำอธิบายและเรื่องราวโดยใช้ AI สำหรับภาพสัตว์เลี้ยงที่อัปโหลด โดยใช้ GitHub Models

## สารบัญ

- [เทคโนโลยีที่ใช้](../../../../04-PracticalSamples/petstory)
- [ข้อกำหนดเบื้องต้น](../../../../04-PracticalSamples/petstory)
- [การตั้งค่าและการติดตั้ง](../../../../04-PracticalSamples/petstory)
- [การใช้งาน](../../../../04-PracticalSamples/petstory)

## เทคโนโลยีที่ใช้

- **Backend**: Spring Boot 3.5.3, Java 21
- **การรวม AI**: OpenAI Java SDK กับ GitHub Models
- **ความปลอดภัย**: Spring Security
- **Frontend**: เทมเพลต Thymeleaf พร้อมการออกแบบด้วย Bootstrap
- **เครื่องมือ Build**: Maven
- **AI Models**: GitHub Models

## ข้อกำหนดเบื้องต้น

- Java 21 หรือสูงกว่า
- Maven 3.9+
- GitHub Personal Access Token ที่มี `models:read` scope

## การตั้งค่าและการติดตั้ง

### 1. ไปที่ไดเรกทอรีแอปพลิเคชัน petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. ตั้งค่าตัวแปร Environment
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. สร้างแอปพลิเคชัน
```bash
mvn clean compile
```

### 4. รันแอปพลิเคชัน
```bash
mvn spring-boot:run
```

## การใช้งาน

1. **เข้าถึงแอปพลิเคชัน**: ไปที่ `http://localhost:8080`
2. **อัปโหลดภาพ**: คลิก "Choose File" และเลือกภาพสัตว์เลี้ยง
3. **วิเคราะห์ภาพ**: คลิก "Analyze Image" เพื่อรับคำอธิบายจาก AI
4. **สร้างเรื่องราว**: คลิก "Generate Story" เพื่อสร้างเรื่องราว

**ข้อจำกัดความรับผิดชอบ**:  
เอกสารนี้ได้รับการแปลโดยใช้บริการแปลภาษา AI [Co-op Translator](https://github.com/Azure/co-op-translator) แม้ว่าเราจะพยายามให้การแปลมีความถูกต้องมากที่สุด แต่โปรดทราบว่าการแปลโดยอัตโนมัติอาจมีข้อผิดพลาดหรือความไม่ถูกต้อง เอกสารต้นฉบับในภาษาดั้งเดิมควรถือเป็นแหล่งข้อมูลที่เชื่อถือได้ สำหรับข้อมูลที่สำคัญ ขอแนะนำให้ใช้บริการแปลภาษามืออาชีพ เราไม่รับผิดชอบต่อความเข้าใจผิดหรือการตีความที่ผิดพลาดซึ่งเกิดจากการใช้การแปลนี้