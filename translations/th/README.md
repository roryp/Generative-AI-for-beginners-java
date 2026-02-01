# Generative AI สำหรับผู้เริ่มต้น - ฉบับ Java  
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI สำหรับผู้เริ่มต้น - ฉบับ Java](../../translated_images/th/beg-genai-series.8b48be9951cc574c.webp)

**เวลาที่ต้องใช้**: เวิร์กช็อปทั้งหมดสามารถทำออนไลน์ได้โดยไม่ต้องติดตั้งในเครื่อง ใช้เวลาติดตั้งสภาพแวดล้อม 2 นาที และการสำรวจตัวอย่างใช้เวลาประมาณ 1-3 ชั่วโมง ขึ้นอยู่กับความลึกของการสำรวจ

> **เริ่มต้นอย่างรวดเร็ว**

1. Fork ที่เก็บนี้ไปยังบัญชี GitHub ของคุณ  
2. คลิก **Code** → แท็บ **Codespaces** → **...** → **New with options...**  
3. ใช้ค่าเริ่มต้น – ระบบจะเลือก Development container ที่สร้างสำหรับคอร์สนี้  
4. คลิก **Create codespace**  
5. รอประมาณ ~2 นาทีจนกว่าสภาพแวดล้อมจะพร้อมใช้งาน  
6. ไปที่ [ตัวอย่างแรก](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) ได้เลย  

> **ต้องการ Clone ลงเครื่องแทนไหม?**  
>  
> ที่เก็บนี้มีการแปลภาษา 50+ ภาษา ซึ่งทำให้ขนาดการดาวน์โหลดเพิ่มขึ้นมาก หากต้องการโคลนโดยไม่มีภาษาที่แปล ให้ใช้ sparse checkout:  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> วิธีนี้จะให้ทุกสิ่งที่คุณต้องการเพื่อทำคอร์สให้เสร็จเร็วขึ้นมาก  

## การรองรับหลายภาษา

### รองรับด้วย GitHub Action (อัตโนมัติและอัปเดตอยู่เสมอ)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[ภาษาอาหรับ](../ar/README.md) | [ภาษาเบงกาลี](../bn/README.md) | [ภาษาเบลเกเรียน](../bg/README.md) | [ภาษาพม่า (เมียนมา)](../my/README.md) | [ภาษาจีน (ตัวย่อ)](../zh-CN/README.md) | [ภาษาจีน (ตัวเต็ม ฮ่องกง)](../zh-HK/README.md) | [ภาษาจีน (ตัวเต็ม มาเก๊า)](../zh-MO/README.md) | [ภาษาจีน (ตัวเต็ม ไต้หวัน)](../zh-TW/README.md) | [ภาษาโครเอเชีย](../hr/README.md) | [ภาษาเช็ก](../cs/README.md) | [ภาษาเดนมาร์ก](../da/README.md) | [ภาษาดัตช์](../nl/README.md) | [ภาษาเอสโตเนีย](../et/README.md) | [ภาษาฟินแลนด์](../fi/README.md) | [ภาษาฝรั่งเศส](../fr/README.md) | [ภาษาเยอรมัน](../de/README.md) | [ภาษากรีก](../el/README.md) | [ภาษาฮิบรู](../he/README.md) | [ภาษาฮินดี](../hi/README.md) | [ภาษาฮังการี](../hu/README.md) | [ภาษาอินโดนีเซีย](../id/README.md) | [ภาษาอิตาเลียน](../it/README.md) | [ภาษาญี่ปุ่น](../ja/README.md) | [ภาษากันนาดา](../kn/README.md) | [ภาษาเกาหลี](../ko/README.md) | [ภาษาลิทัวเนีย](../lt/README.md) | [ภาษามาเลย์](../ms/README.md) | [ภาษามาลายาลัม](../ml/README.md) | [ภาษามราฐี](../mr/README.md) | [ภาษาเนปาล](../ne/README.md) | [ภาษาไนจีเรียพิดจิน](../pcm/README.md) | [ภาษานอร์เวย์](../no/README.md) | [ภาษาเปอร์เซีย (ฟาโรซี)](../fa/README.md) | [ภาษาโปแลนด์](../pl/README.md) | [ภาษาปอร์ตุเกส (บราซิล)](../pt-BR/README.md) | [ภาษาปอร์ตุเกส (โปรตุเกส)](../pt-PT/README.md) | [ภาษาปัญจาบี (กูรมุขี)](../pa/README.md) | [ภาษาโรมาเนีย](../ro/README.md) | [ภาษารัสเซีย](../ru/README.md) | [ภาษาเซอร์เบียน (ซีริลลิก)](../sr/README.md) | [ภาษาสโลวัก](../sk/README.md) | [ภาษาสโลเวเนีย](../sl/README.md) | [ภาษาสเปน](../es/README.md) | [ภาษาสวาฮิลี](../sw/README.md) | [ภาษาสวีเดน](../sv/README.md) | [ภาษาาตากาล็อก (ฟิลิปปินส์)](../tl/README.md) | [ภาษาทมิฬ](../ta/README.md) | [ภาษาเทลูกู](../te/README.md) | [ภาษาไทย](./README.md) | [ภาษาตุรกี](../tr/README.md) | [ภาษายูเครน](../uk/README.md) | [ภาษาอูรดู](../ur/README.md) | [ภาษาเวียดนาม](../vi/README.md)

## โครงสร้างคอร์สและเส้นทางการเรียนรู้

### **บทที่ 1: บทนำสู่ Generative AI**  
- **แนวคิดพื้นฐาน**: เข้าใจโมเดลภาษาใหญ่, โทเค็น, embeddings และความสามารถของ AI  
- **ระบบนิเวศ AI ใน Java**: ภาพรวมของ Spring AI และ OpenAI SDK  
- **โปรโตคอลบริบทของโมเดล (MCP)**: แนะนำ MCP และบทบาทในสื่อสารของ AI agent  
- **การประยุกต์ใช้เชิงปฏิบัติ**: กรณีศึกษาจริง เช่น แชทบอทและการสร้างเนื้อหา  
- **[→ เริ่มบทที่ 1](./01-IntroToGenAI/README.md)**

### **บทที่ 2: การติดตั้งสภาพแวดล้อมการพัฒนา**  
- **การตั้งค่าผู้ให้บริการหลายราย**: ตั้งค่า GitHub Models, Azure OpenAI และ OpenAI Java SDK  
- **Spring Boot + Spring AI**: แนวทางปฏิบัติที่ดีที่สุดสำหรับการพัฒนาแอป AI ระดับองค์กร  
- **GitHub Models**: เข้าถึงโมเดล AI ฟรีสำหรับการสร้างต้นแบบและเรียนรู้ (ไม่ต้องใช้บัตรเครดิต)  
- **เครื่องมือพัฒนา**: คอนเทนเนอร์ Docker, VS Code, และการตั้งค่า GitHub Codespaces  
- **[→ เริ่มบทที่ 2](./02-SetupDevEnvironment/README.md)**

### **บทที่ 3: เทคนิคหลักของ Generative AI**  
- **วิศวกรรมพรอมต์**: เทคนิคสำหรับการตอบสนองโมเดล AI ที่เหมาะสมที่สุด  
- **Embeddings & การดำเนินการเวกเตอร์**: ใช้ค้นหาเชิงความหมายและจับคู่ความคล้ายคลึง  
- **Retrieval-Augmented Generation (RAG)**: รวม AI เข้ากับแหล่งข้อมูลของคุณเอง  
- **การเรียกใช้ฟังก์ชัน**: ขยายความสามารถ AI ด้วยเครื่องมือและปลั๊กอินที่กำหนดเอง  
- **[→ เริ่มบทที่ 3](./03-CoreGenerativeAITechniques/README.md)**

### **บทที่ 4: การประยุกต์ใช้งานและโปรเจกต์**  
- **ตัวสร้างเรื่องราวสัตว์เลี้ยง** (`petstory/`): การสร้างเนื้อหาเชิงสร้างสรรค์ด้วย GitHub Models  
- **สาธิต Foundry Local** (`foundrylocal/`): รวมโมเดล AI ในเครื่องกับ OpenAI Java SDK  
- **บริการเครื่องคิดเลข MCP** (`calculator/`): การใช้งาน Model Context Protocol เบื้องต้นด้วย Spring AI  
- **[→ เริ่มบทที่ 4](./04-PracticalSamples/README.md)**

### **บทที่ 5: การพัฒนา AI อย่างมีความรับผิดชอบ**  
- **ความปลอดภัย GitHub Models**: ทดสอบการกรองเนื้อหาและระบบความปลอดภัยในตัว (การบล็อกแบบเข้มงวดและการปฏิเสธแบบนุ่มนวล)  
- **สาธิต AI ที่รับผิดชอบ**: ตัวอย่างลงมือทำแสดงระบบความปลอดภัย AI สมัยใหม่ทำงานอย่างไร  
- **แนวปฏิบัติที่ดีที่สุด**: แนวทางสำคัญสำหรับการพัฒนาและนำ AI ไปใช้อย่างมีจริยธรรม  
- **[→ เริ่มบทที่ 5](./05-ResponsibleGenAI/README.md)**

## แหล่งข้อมูลเพิ่มเติม

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain  
[![LangChain4j สำหรับผู้เริ่มต้น](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)  
[![LangChain.js สำหรับผู้เริ่มต้น](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### Azure / Edge / MCP / Agents  
[![AZD สำหรับผู้เริ่มต้น](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![Edge AI สำหรับผู้เริ่มต้น](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![MCP สำหรับผู้เริ่มต้น](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![AI Agents สำหรับผู้เริ่มต้น](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### ชุด Generative AI  
[![Generative AI สำหรับผู้เริ่มต้น](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)  
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)  
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---

### การเรียนรู้แกนหลัก  
[![ML สำหรับผู้เริ่มต้น](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)  
[![Data Science สำหรับผู้เริ่มต้น](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)  
[![AI สำหรับผู้เริ่มต้น](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)  
[![Cybersecurity สำหรับผู้เริ่มต้น](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)  
[![Web Dev สำหรับผู้เริ่มต้น](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### ชุด Copilot
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## ขอความช่วยเหลือ

หากคุณติดขัดหรือต้องการคำถามใดๆ เกี่ยวกับการสร้างแอป AI เข้าร่วมกับผู้เรียนและนักพัฒนาที่มีประสบการณ์ในการสนทนาเกี่ยวกับ MCP นี่คือชุมชนที่ให้การสนับสนุนซึ่งคำถามเป็นที่ต้อนรับและความรู้ถูกแบ่งปันอย่างอิสระ

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

หากคุณมีข้อเสนอแนะเกี่ยวกับผลิตภัณฑ์หรือพบข้อผิดพลาดขณะสร้าง ให้เข้าไปที่:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ข้อจำกัดความรับผิดชอบ**:
เอกสารฉบับนี้ได้รับการแปลด้วยบริการแปลภาษาอัตโนมัติ [Co-op Translator](https://github.com/Azure/co-op-translator) แม้เราจะพยายามให้ความถูกต้อง โปรดทราบว่าการแปลอัตโนมัติอาจมีข้อผิดพลาดหรือความไม่ถูกต้อง เอกสารต้นฉบับในภาษาต้นทางควรถือเป็นแหล่งข้อมูลที่เชื่อถือได้ สำหรับข้อมูลที่สำคัญ ขอแนะนำให้ใช้บริการแปลโดยผู้เชี่ยวชาญที่เป็นมนุษย์ เราไม่รับผิดชอบต่อความเข้าใจผิดหรือการตีความที่ผิดพลาดอันเกิดจากการใช้การแปลนี้
<!-- CO-OP TRANSLATOR DISCLAIMER END -->