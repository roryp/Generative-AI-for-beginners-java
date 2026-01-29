# ปัญญาประดิษฐ์สร้างสรรค์สำหรับผู้เริ่มต้น - รุ่น Java  
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/th/beg-genai-series.8b48be9951cc574c.webp)

**เวลาที่ใช้**: เวิร์กช็อปทั้งหมดสามารถทำออนไลน์ได้โดยไม่ต้องติดตั้งท้องถิ่น การตั้งค่าสภาพแวดล้อมใช้เวลา 2 นาที และการสำรวจตัวอย่างต้องใช้เวลา 1-3 ชั่วโมงขึ้นอยู่กับความลึกในการสำรวจ

> **เริ่มต้นอย่างรวดเร็ว**

1. สร้าง Fork ของที่เก็บนี้ในบัญชี GitHub ของคุณ  
2. คลิก **Code** → แท็บ **Codespaces** → **...** → **New with options...**  
3. ใช้ค่าเริ่มต้น – ซึ่งจะเลือก Development container ที่สร้างขึ้นสำหรับหลักสูตรนี้  
4. คลิก **Create codespace**  
5. รอประมาณ 2 นาทีเพื่อให้สภาพแวดล้อมพร้อมใช้งาน  
6. ข้ามไปที่ [ตัวอย่างแรก](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **ต้องการโคลนไปที่เครื่องของคุณแทน?**  
>  
> ที่เก็บนี้มีการแปลภาษากว่า 50 ภาษา ซึ่งเพิ่มขนาดการดาวน์โหลดอย่างมาก หากต้องการโคลนโดยไม่รวมแปลภาษานั้น ให้ใช้ sparse checkout:  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> วิธีนี้จะให้ทุกอย่างที่คุณต้องการเพื่อจบหลักสูตรด้วยการดาวน์โหลดที่เร็วขึ้นมาก  

## การรองรับหลายภาษา

### รองรับผ่าน GitHub Action (อัตโนมัติ & อัปเดตตลอดเวลา)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[ภาษาอาหรับ](../ar/README.md) | [ภาษาเบงกาลี](../bn/README.md) | [ภาษาบัลแกเรีย](../bg/README.md) | [ภาษาพม่า (เมียนมาร์)](../my/README.md) | [ภาษาจีน (ตัวย่อ)](../zh-CN/README.md) | [ภาษาจีน (ตัวเต็ม, ฮ่องกง)](../zh-HK/README.md) | [ภาษาจีน (ตัวเต็ม, มาเก๊า)](../zh-MO/README.md) | [ภาษาจีน (ตัวเต็ม, ไต้หวัน)](../zh-TW/README.md) | [ภาษาโครเอเชีย](../hr/README.md) | [ภาษาเช็ก](../cs/README.md) | [ภาษาเดนมาร์ก](../da/README.md) | [ภาษาดัตช์](../nl/README.md) | [ภาษาเอสโตเนีย](../et/README.md) | [ภาษาฟินแลนด์](../fi/README.md) | [ภาษาฝรั่งเศส](../fr/README.md) | [ภาษาเยอรมัน](../de/README.md) | [ภาษากรีก](../el/README.md) | [ภาษาฮีบรู](../he/README.md) | [ภาษาฮินดี](../hi/README.md) | [ภาษาฮังกาเรียน](../hu/README.md) | [ภาษาอินโดนีเซีย](../id/README.md) | [ภาษาอิตาลี](../it/README.md) | [ภาษาญี่ปุ่น](../ja/README.md) | [ภาษากันนาดา](../kn/README.md) | [ภาษาเกาหลี](../ko/README.md) | [ภาษาลิทัวเนีย](../lt/README.md) | [ภาษามาเลย์](../ms/README.md) | [ภาษามาลายาลัม](../ml/README.md) | [ภาษามราฐี](../mr/README.md) | [ภาษาเนปาล](../ne/README.md) | [ภาษาไนจีเรียพิดจิน](../pcm/README.md) | [ภาษานอร์เวย์](../no/README.md) | [ภาษาเปอร์เซีย (ฟาร์ซี)](../fa/README.md) | [ภาษาโพแลนด์](../pl/README.md) | [ภาษาโปรตุเกส (บราซิล)](../pt-BR/README.md) | [ภาษาโปรตุเกส (โปรตุเกส)](../pt-PT/README.md) | [ภาษาปัญจาบี (กูรมุกขิ)](../pa/README.md) | [ภาษาโรมาเนีย](../ro/README.md) | [ภาษารัสเซีย](../ru/README.md) | [ภาษาเซอร์เบียน (อักษรซีริลลิก)](../sr/README.md) | [ภาษา สโลวัก](../sk/README.md) | [ภาษา สโลเวเนีย](../sl/README.md) | [ภาษาสเปน](../es/README.md) | [ภาษาสวาฮิลี](../sw/README.md) | [ภาษาสวีเดน](../sv/README.md) | [ภาษา ตากาล็อก (ฟิลิปปินส์)](../tl/README.md) | [ภาษาทมิฬ](../ta/README.md) | [ภาษาเทลูกู](../te/README.md) | [ภาษาไทย](./README.md) | [ภาษาตุรกี](../tr/README.md) | [ภาษา ยูเครน](../uk/README.md) | [ภาษาอูรดู](../ur/README.md) | [ภาษาเวียดนาม](../vi/README.md)

> **ต้องการโคลนไปที่เครื่องของคุณแทน?**

> ที่เก็บนี้มีการแปลภาษากว่า 50 ภาษา ซึ่งเพิ่มขนาดการดาวน์โหลดอย่างมาก หากต้องการโคลนโดยไม่รวมแปลภาษานั้น ให้ใช้ sparse checkout:  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> วิธีนี้จะให้ทุกอย่างที่คุณต้องการเพื่อจบหลักสูตรด้วยการดาวน์โหลดที่เร็วขึ้นมาก  
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## โครงสร้างหลักสูตร & เส้นทางการเรียนรู้

### **บทที่ 1: แนะนำปัญญาประดิษฐ์สร้างสรรค์**  
- **แนวคิดหลัก**: เข้าใจโมเดลภาษาขนาดใหญ่, โทเค็น, embedding และความสามารถของ AI  
- **ระบบนิเวศ AI ของ Java**: ภาพรวม Spring AI และ OpenAI SDK  
- **โปรโตคอล Model Context**: แนะนำ MCP และบทบาทในการสื่อสารของตัวแทน AI  
- **การประยุกต์ใช้งานจริง**: สถานการณ์จริง เช่น แชทบ็อตและการสร้างเนื้อหา  
- **[→ เริ่มบทที่ 1](./01-IntroToGenAI/README.md)**

### **บทที่ 2: การตั้งค่าสภาพแวดล้อมพัฒนา**  
- **การกำหนดค่าผู้ให้บริการหลายราย**: ตั้งค่า GitHub Models, Azure OpenAI, และ OpenAI Java SDK  
- **Spring Boot + Spring AI**: แนวปฏิบัติที่ดีที่สุดสำหรับการพัฒนา AI ในองค์กร  
- **GitHub Models**: เข้าถึงโมเดล AI ฟรีสำหรับต้นแบบและการเรียนรู้ (ไม่ต้องใช้บัตรเครดิต)  
- **เครื่องมือพัฒนา**: Docker containers, VS Code, และ GitHub Codespaces  
- **[→ เริ่มบทที่ 2](./02-SetupDevEnvironment/README.md)**

### **บทที่ 3: เทคนิคหลักของปัญญาประดิษฐ์สร้างสรรค์**  
- **วิศวกรรมพรอมต์**: เทคนิคสำหรับตอบสนองที่ดีที่สุดจากโมเดล AI  
- **Embeddings & การดำเนินการเวกเตอร์**: นำไปใช้ในการค้นหาเชิงความหมายและการจับคู่ความคล้ายคลึง  
- **การสร้างโดยเสริมการดึงข้อมูล (RAG)**: ผสมผสาน AI กับแหล่งข้อมูลของคุณเอง  
- **การเรียกฟังก์ชัน**: ขยายความสามารถของ AI ด้วยเครื่องมือและปลั๊กอินที่กำหนดเอง  
- **[→ เริ่มบทที่ 3](./03-CoreGenerativeAITechniques/README.md)**

### **บทที่ 4: การประยุกต์ใช้งานและโปรเจกต์**  
- **ผู้สร้างเรื่องราวสัตว์เลี้ยง** (`petstory/`): สร้างเนื้อหาอย่างสร้างสรรค์ด้วย GitHub Models  
- **เดโม Foundry Local** (`foundrylocal/`): การเชื่อมต่อโมเดล AI ท้องถิ่นด้วย OpenAI Java SDK  
- **บริการเครื่องคิดเลข MCP** (`calculator/`): การใช้งาน Model Context Protocol พื้นฐานด้วย Spring AI  
- **[→ เริ่มบทที่ 4](./04-PracticalSamples/README.md)**

### **บทที่ 5: การพัฒนา AI ที่รับผิดชอบ**  
- **ความปลอดภัย GitHub Models**: ทดสอบฟิลเตอร์เนื้อหาและกลไกความปลอดภัยในตัว (บล็อกแน่นและปฏิเสธนุ่มนวล)  
- **เดโม AI ที่รับผิดชอบ**: ตัวอย่างการใช้งานระบบความปลอดภัย AI สมัยใหม่ในทางปฏิบัติ  
- **แนวปฏิบัติที่ดีที่สุด**: แนวทางสำคัญสำหรับการพัฒนาและใช้งาน AI อย่างมีจริยธรรม  
- **[→ เริ่มบทที่ 5](./05-ResponsibleGenAI/README.md)**

## ทรัพยากรเพิ่มเติม

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
 
### การเรียนรู้พื้นฐาน  
[![ML สำหรับผู้เริ่มต้น](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)  
[![Data Science สำหรับผู้เริ่มต้น](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)  
[![AI สำหรับผู้เริ่มต้น](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)  
[![Cybersecurity สำหรับผู้เริ่มต้น](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)  

[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### ชุด Copilot
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## การขอความช่วยเหลือ

หากคุณติดขัดหรือมีคำถามเกี่ยวกับการสร้างแอป AI เข้าร่วมกับผู้เรียนและนักพัฒนาที่มีประสบการณ์ในการสนทนาเกี่ยวกับ MCP นี่คือชุมชนที่ให้การสนับสนุนซึ่งคำถามได้รับการต้อนรับและความรู้มีการแบ่งปันอย่างเสรี

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

หากคุณมีข้อเสนอแนะเกี่ยวกับผลิตภัณฑ์หรือพบข้อผิดพลาดขณะสร้างโปรดไปที่:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ข้อจำกัดความรับผิดชอบ**:  
เอกสารนี้ได้รับการแปลโดยใช้บริการแปลภาษา AI [Co-op Translator](https://github.com/Azure/co-op-translator) แม้ว่าเราจะพยายามให้ความถูกต้อง แต่โปรดทราบว่าการแปลโดยอัตโนมัติอาจมีข้อผิดพลาดหรือความคลาดเคลื่อนได้ เอกสารต้นฉบับในภาษาต้นฉบับถือเป็นแหล่งข้อมูลที่น่าเชื่อถือที่สุด สำหรับข้อมูลที่สำคัญ ขอแนะนำให้ใช้การแปลโดยผู้เชี่ยวชาญมนุษย์ เราไม่รับผิดชอบต่อความเข้าใจผิดหรือการตีความผิดที่เกิดจากการใช้การแปลนี้
<!-- CO-OP TRANSLATOR DISCLAIMER END -->