<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T09:33:03+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "th"
}
-->
# เทคนิคหลักของ Generative AI

>**หมายเหตุ**: บทนี้มี [**บทแนะนำ**](./TUTORIAL.md) ที่อธิบายตัวอย่างอย่างละเอียด

## สิ่งที่คุณจะได้เรียนรู้
ในบทนี้ เราจะศึกษาวิธีการหลัก 4 อย่างของ Generative AI ผ่านตัวอย่างที่ใช้งานได้จริง:
- การเติมข้อความและการสนทนาโดยใช้ LLM
- การเรียกใช้งานฟังก์ชัน
- การสร้างข้อมูลด้วย Retrieval-Augmented Generation (RAG)
- มาตรการความปลอดภัยของ AI ที่รับผิดชอบ

## สารบัญ

- [สิ่งที่คุณจะได้เรียนรู้](../../../03-CoreGenerativeAITechniques)
- [ข้อกำหนดเบื้องต้น](../../../03-CoreGenerativeAITechniques)
- [เริ่มต้นใช้งาน](../../../03-CoreGenerativeAITechniques)
- [ภาพรวมของตัวอย่าง](../../../03-CoreGenerativeAITechniques)
  - [1. การเติมข้อความและการสนทนาโดยใช้ LLM](../../../03-CoreGenerativeAITechniques)
  - [2. ฟังก์ชันและปลั๊กอินกับ LLMs](../../../03-CoreGenerativeAITechniques)
  - [3. การสร้างข้อมูลด้วย Retrieval-Augmented Generation (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. การสาธิตมาตรการความปลอดภัยของ AI](../../../03-CoreGenerativeAITechniques)
- [สรุป](../../../03-CoreGenerativeAITechniques)
- [ขั้นตอนถัดไป](../../../03-CoreGenerativeAITechniques)

## ข้อกำหนดเบื้องต้น

- ดำเนินการตั้งค่าจาก [บทที่ 2](../../../02-SetupDevEnvironment) เสร็จสมบูรณ์

## เริ่มต้นใช้งาน

1. **ไปที่โฟลเดอร์ตัวอย่าง**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **ตั้งค่าสภาพแวดล้อม**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **คอมไพล์และรันตัวอย่าง**:  
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

## ภาพรวมของตัวอย่าง

ตัวอย่างถูกจัดเก็บในโฟลเดอร์ `examples/` โดยมีโครงสร้างดังนี้:

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

### 1. การเติมข้อความและการสนทนาโดยใช้ LLM
**ไฟล์**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

เรียนรู้การสร้าง AI สำหรับการสนทนา โดยมีการตอบกลับแบบสตรีมและการจัดการประวัติการสนทนา

ตัวอย่างนี้แสดงให้เห็น:
- การเติมข้อความแบบง่ายด้วย system prompts
- การสนทนาแบบหลายรอบพร้อมการจัดการประวัติ
- เซสชันการสนทนาแบบโต้ตอบ
- การตั้งค่าพารามิเตอร์ (temperature, max tokens)

### 2. ฟังก์ชันและปลั๊กอินกับ LLMs
**ไฟล์**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

ขยายความสามารถของ AI โดยให้โมเดลเข้าถึงฟังก์ชันที่กำหนดเองและ API ภายนอก

ตัวอย่างนี้แสดงให้เห็น:
- การรวมฟังก์ชันพยากรณ์อากาศ
- การใช้งานฟังก์ชันเครื่องคิดเลข  
- การเรียกใช้งานฟังก์ชันหลายตัวในบทสนทนาเดียว
- การกำหนดฟังก์ชันด้วย JSON schemas

### 3. การสร้างข้อมูลด้วย Retrieval-Augmented Generation (RAG)
**ไฟล์**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

เรียนรู้วิธีผสมผสาน AI กับเอกสารและแหล่งข้อมูลของคุณเอง เพื่อให้ได้คำตอบที่แม่นยำและมีบริบท

ตัวอย่างนี้แสดงให้เห็น:
- การตอบคำถามจากเอกสารโดยใช้ Azure OpenAI SDK
- การใช้งานรูปแบบ RAG กับ GitHub Models

**การใช้งาน**: ถามคำถามเกี่ยวกับเนื้อหาใน `document.txt` และรับคำตอบจาก AI โดยอ้างอิงเฉพาะบริบทนั้น

### 4. การสาธิตมาตรการความปลอดภัยของ AI
**ไฟล์**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

ดูตัวอย่างมาตรการความปลอดภัยของ AI โดยการทดสอบความสามารถในการกรองเนื้อหาของ GitHub Models

ตัวอย่างนี้แสดงให้เห็น:
- การกรองเนื้อหาสำหรับคำสั่งที่อาจเป็นอันตราย
- การจัดการการตอบสนองด้านความปลอดภัยในแอปพลิเคชัน
- หมวดหมู่ต่าง ๆ ของเนื้อหาที่ถูกบล็อก (ความรุนแรง, คำพูดแสดงความเกลียดชัง, ข้อมูลผิด)
- การจัดการข้อผิดพลาดอย่างเหมาะสมสำหรับการละเมิดความปลอดภัย

> **เรียนรู้เพิ่มเติม**: นี่เป็นเพียงการแนะนำแนวคิด AI ที่รับผิดชอบ สำหรับข้อมูลเพิ่มเติมเกี่ยวกับจริยธรรม การลดอคติ การพิจารณาด้านความเป็นส่วนตัว และกรอบงาน AI ที่รับผิดชอบ ดู [บทที่ 5: Generative AI ที่รับผิดชอบ](../05-ResponsibleGenAI/README.md)

## สรุป

ในบทนี้ เราได้สำรวจการเติมข้อความและการสนทนาโดยใช้ LLM การเรียกใช้งานฟังก์ชันเพื่อเพิ่มความสามารถของ AI การสร้างข้อมูลด้วย Retrieval-Augmented Generation (RAG) และการสาธิตมาตรการความปลอดภัยของ AI ที่รับผิดชอบ

> **หมายเหตุ**: ศึกษาเพิ่มเติมผ่าน [**บทแนะนำ**](./TUTORIAL.md)

## ขั้นตอนถัดไป

[บทที่ 4: การใช้งานจริงและโปรเจกต์](../04-PracticalSamples/README.md)

**ข้อจำกัดความรับผิดชอบ**:  
เอกสารนี้ได้รับการแปลโดยใช้บริการแปลภาษา AI [Co-op Translator](https://github.com/Azure/co-op-translator) แม้ว่าเราจะพยายามให้การแปลมีความถูกต้องมากที่สุด แต่โปรดทราบว่าการแปลโดยอัตโนมัติอาจมีข้อผิดพลาดหรือความไม่ถูกต้อง เอกสารต้นฉบับในภาษาดั้งเดิมควรถือเป็นแหล่งข้อมูลที่เชื่อถือได้ สำหรับข้อมูลที่สำคัญ ขอแนะนำให้ใช้บริการแปลภาษามนุษย์มืออาชีพ เราไม่รับผิดชอบต่อความเข้าใจผิดหรือการตีความผิดที่เกิดจากการใช้การแปลนี้