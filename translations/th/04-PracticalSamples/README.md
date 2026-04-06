# การใช้งานจริง & โครงการ

[![การใช้งานจริง & โครงการ](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "การใช้งานจริง & โครงการ")

> **ภาพรวมวิดีโอ:** [รับชม "การใช้งานจริง & โครงการ" บน YouTube](https://www.youtube.com/watch?v=01vJsYei3H0)

## สิ่งที่คุณจะได้เรียนรู้
ในส่วนนี้เราจะแสดงตัวอย่างสามแอปพลิเคชันใช้งานจริงที่แสดงรูปแบบการพัฒนา AI สร้างสรรค์ด้วย Java:
- สร้างเครื่องสร้างเรื่องราวสัตว์เลี้ยงหลายโหมดที่ผสมผสาน AI ฝั่งลูกค้าและฝั่งเซิร์ฟเวอร์
- นำเสนอการรวมโมเดล AI ท้องถิ่นด้วย Foundry Local Spring Boot demo
- พัฒนาบริการ Model Context Protocol (MCP) ด้วยตัวอย่างเครื่องคิดเลข

## สารบัญ

- [บทนำ](#บทนำ)
  - [Foundry Local Spring Boot Demo](#foundry-local-spring-boot-demo)
  - [Pet Story Generator](#pet-story-generator)
  - [MCP Calculator Service (Beginner-Friendly MCP Demo)](#mcp-calculator-service-beginner-friendly-mcp-demo)
- [ความก้าวหน้าการเรียนรู้](#ความก้าวหน้าการเรียนรู้)
- [บทสรุป](#บทสรุป)
- [ก้าวต่อไป](#ก้าวต่อไป)

## บทนำ

บทนี้แสดง **ตัวอย่างโครงการ** ที่แสดงรูปแบบการพัฒนา AI สร้างสรรค์ด้วย Java แต่ละโครงการใช้งานได้จริงและแสดงเทคโนโลยี AI สถาปัตยกรรม และแนวปฏิบัติที่ดีที่สุดที่คุณสามารถนำไปปรับใช้กับแอปพลิเคชันของคุณเอง

### Foundry Local Spring Boot Demo

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** แสดงวิธีการรวมกับโมเดล AI ท้องถิ่นโดยใช้ **OpenAI Java SDK** โดยแสดงการเชื่อมต่อกับโมเดล **Phi-3.5-mini** ที่รันบน Foundry Local ซึ่งช่วยให้คุณรันแอป AI โดยไม่ต้องพึ่งพาบริการคลาวด์

### Pet Story Generator

**[Pet Story Generator](petstory/README.md)** เป็นเว็บแอปพลิเคชัน Spring Boot ที่น่าสนใจ ซึ่งแสดงการประมวลผล AI แบบหลายโหมดเพื่อสร้างเรื่องราวสัตว์เลี้ยงอย่างสร้างสรรค์ โดยผสมผสานความสามารถ AI ฝั่งลูกค้าและฝั่งเซิร์ฟเวอร์โดยใช้ transformer.js สำหรับการโต้ตอบ AI บนเบราว์เซอร์ และ OpenAI SDK สำหรับการประมวลผลฝั่งเซิร์ฟเวอร์

### MCP Calculator Service (Beginner-Friendly MCP Demo)

**[MCP Calculator Service](calculator/README.md)** เป็นตัวอย่างง่ายๆ ของ **Model Context Protocol (MCP)** โดยใช้ Spring AI ซึ่งให้การแนะนำ MCP สำหรับผู้เริ่มต้น โดยแสดงวิธีสร้าง MCP Server พื้นฐานที่โต้ตอบกับ MCP client

## ความก้าวหน้าการเรียนรู้

โครงการเหล่านี้ถูกออกแบบมาเพื่อสร้างความเข้าใจจากบทเรียนก่อนหน้า:

1. **เริ่มต้นอย่างง่าย**: เริ่มจาก Foundry Local Spring Boot Demo เพื่อเข้าใจการรวม AI กับโมเดลท้องถิ่นขั้นพื้นฐาน
2. **เพิ่มการโต้ตอบ**: ก้าวไปที่ Pet Story Generator สำหรับ AI หลายโหมดและการโต้ตอบบนเว็บ
3. **เรียนรู้พื้นฐาน MCP**: ลอง MCP Calculator Service เพื่อเข้าใจแนวคิด Model Context Protocol อย่างลึกซึ้ง

## บทสรุป

ทำได้ดี! ตอนนี้คุณได้สำรวจแอปพลิเคชันจริงบางตัวแล้ว:

- ประสบการณ์ AI หลายโหมดที่ทำงานทั้งในเบราว์เซอร์และบนเซิร์ฟเวอร์
- การรวมโมเดล AI ท้องถิ่นด้วยกรอบงานและ SDK Java สมัยใหม่
- บริการ Model Context Protocol ตัวแรกของคุณเพื่อดูวิธีการที่เครื่องมือรวมกับ AI

## ก้าวต่อไป

[บทที่ 5: Responsible Generative AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ข้อจำกัดความรับผิดชอบ**:  
เอกสารฉบับนี้ได้ถูกแปลโดยใช้บริการแปลด้วย AI [Co-op Translator](https://github.com/Azure/co-op-translator) แม้เราจะมุ่งเน้นความถูกต้อง แต่โปรดทราบว่าการแปลอัตโนมัติอาจมีข้อผิดพลาดหรือความไม่ถูกต้อง เอกสารต้นฉบับในภาษาดั้งเดิมควรถือเป็นแหล่งข้อมูลที่ถูกต้องที่สุด สำหรับข้อมูลสำคัญ แนะนำให้ใช้การแปลโดยผู้เชี่ยวชาญมนุษย์ เราไม่รับผิดชอบต่อความเข้าใจผิดหรือการตีความผิดใด ๆ ที่เกิดจากการใช้การแปลนี้
<!-- CO-OP TRANSLATOR DISCLAIMER END -->