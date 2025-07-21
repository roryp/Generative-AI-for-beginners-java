<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T19:10:49+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "th"
}
-->
# เทคนิคหลักของ Generative AI

>**หมายเหตุ**: บทนี้มี [**บทแนะนำ**](./TUTORIAL.md) ที่อธิบายขั้นตอนการใช้งานตัวอย่างที่เสร็จสมบูรณ์อย่างละเอียด

## สิ่งที่คุณจะได้เรียนรู้
ในบทนี้ เราจะศึกษาวิธีการหลัก 4 อย่างของ Generative AI ผ่านตัวอย่างที่ใช้งานได้จริง:
- การเติมข้อความและการสนทนา (LLM completions and chat flows)
- การเรียกใช้งานฟังก์ชัน
- การสร้างเนื้อหาโดยใช้การดึงข้อมูลเสริม (Retrieval-Augmented Generation หรือ RAG)
- มาตรการความปลอดภัยของ AI ที่รับผิดชอบ

## สารบัญ

- [สิ่งที่คุณจะได้เรียนรู้](../../../03-CoreGenerativeAITechniques)
- [ข้อกำหนดเบื้องต้น](../../../03-CoreGenerativeAITechniques)
- [เริ่มต้นใช้งาน](../../../03-CoreGenerativeAITechniques)
- [ภาพรวมของตัวอย่าง](../../../03-CoreGenerativeAITechniques)
  - [1. การเติมข้อความและการสนทนา (LLM Completions and Chat Flows)](../../../03-CoreGenerativeAITechniques)
  - [2. ฟังก์ชันและปลั๊กอินกับ LLMs](../../../03-CoreGenerativeAITechniques)
  - [3. การสร้างเนื้อหาโดยใช้การดึงข้อมูลเสริม (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. การสาธิตความปลอดภัยของ AI ที่รับผิดชอบ](../../../03-CoreGenerativeAITechniques)
- [สรุป](../../../03-CoreGenerativeAITechniques)
- [ขั้นตอนถัดไป](../../../03-CoreGenerativeAITechniques)

## ข้อกำหนดเบื้องต้น

- การตั้งค่าที่เสร็จสมบูรณ์จาก [บทที่ 2](../../../02-SetupDevEnvironment)

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

ตัวอย่างทั้งหมดถูกจัดเก็บในโฟลเดอร์ `examples/` โดยมีโครงสร้างดังนี้:

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

### 1. การเติมข้อความและการสนทนา (LLM Completions and Chat Flows)
**ไฟล์**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

เรียนรู้การสร้าง AI สำหรับการสนทนาด้วยการตอบกลับแบบสตรีมและการจัดการประวัติการสนทนา

ตัวอย่างนี้แสดงให้เห็น:
- การเติมข้อความง่ายๆ ด้วยคำสั่งระบบ
- การสนทนาแบบหลายรอบพร้อมการจัดการประวัติ
- เซสชันการสนทนาแบบโต้ตอบ
- การตั้งค่าพารามิเตอร์ (temperature, max tokens)

### 2. ฟังก์ชันและปลั๊กอินกับ LLMs
**ไฟล์**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

ขยายความสามารถของ AI โดยให้โมเดลเข้าถึงฟังก์ชันที่กำหนดเองและ API ภายนอก

ตัวอย่างนี้แสดงให้เห็น:
- การผสานรวมฟังก์ชันพยากรณ์อากาศ
- การใช้งานฟังก์ชันเครื่องคิดเลข  
- การเรียกใช้งานฟังก์ชันหลายตัวในบทสนทนาเดียว
- การกำหนดฟังก์ชันด้วย JSON schemas

### 3. การสร้างเนื้อหาโดยใช้การดึงข้อมูลเสริม (RAG)
**ไฟล์**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

เรียนรู้วิธีผสมผสาน AI กับเอกสารและแหล่งข้อมูลของคุณเองเพื่อให้ได้คำตอบที่แม่นยำและมีบริบท

ตัวอย่างนี้แสดงให้เห็น:
- การตอบคำถามตามเอกสารด้วย Azure OpenAI SDK
- การใช้งานรูปแบบ RAG กับ GitHub Models

**การใช้งาน**: ถามคำถามเกี่ยวกับเนื้อหาใน `document.txt` และรับคำตอบจาก AI ที่อ้างอิงเฉพาะบริบทนั้น

### 4. การสาธิตความปลอดภัยของ AI ที่รับผิดชอบ
**ไฟล์**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

ดูตัวอย่างมาตรการความปลอดภัยของ AI โดยการทดสอบความสามารถในการกรองเนื้อหาของ GitHub Models

ตัวอย่างนี้แสดงให้เห็น:
- การกรองเนื้อหาสำหรับคำสั่งที่อาจเป็นอันตราย
- การจัดการการตอบสนองด้านความปลอดภัยในแอปพลิเคชัน
- หมวดหมู่ต่างๆ ของเนื้อหาที่ถูกบล็อก (ความรุนแรง, คำพูดแสดงความเกลียดชัง, ข้อมูลที่ผิด)
- การจัดการข้อผิดพลาดอย่างเหมาะสมสำหรับการละเมิดความปลอดภัย

> **เรียนรู้เพิ่มเติม**: นี่เป็นเพียงการแนะนำแนวคิดเกี่ยวกับ AI ที่รับผิดชอบ สำหรับข้อมูลเพิ่มเติมเกี่ยวกับจริยธรรม การลดอคติ การพิจารณาด้านความเป็นส่วนตัว และกรอบการทำงานของ AI ที่รับผิดชอบ ดู [บทที่ 5: Generative AI ที่รับผิดชอบ](../05-ResponsibleGenAI/README.md)

## สรุป

ในบทนี้ เราได้สำรวจการเติมข้อความและการสนทนา (LLM completions and chat flows) การเรียกใช้งานฟังก์ชันเพื่อเพิ่มความสามารถของ AI การสร้างระบบ Retrieval-Augmented Generation (RAG) และการสาธิตมาตรการความปลอดภัยของ AI ที่รับผิดชอบ

> **หมายเหตุ**: ศึกษาเพิ่มเติมได้จาก [**บทแนะนำ**](./TUTORIAL.md)

## ขั้นตอนถัดไป

[บทที่ 4: การประยุกต์ใช้งานและโปรเจกต์จริง](../04-PracticalSamples/README.md)

**ข้อจำกัดความรับผิดชอบ**:  
เอกสารนี้ได้รับการแปลโดยใช้บริการแปลภาษา AI [Co-op Translator](https://github.com/Azure/co-op-translator) แม้ว่าเราจะพยายามให้การแปลมีความถูกต้องมากที่สุด แต่โปรดทราบว่าการแปลโดยอัตโนมัติอาจมีข้อผิดพลาดหรือความไม่ถูกต้อง เอกสารต้นฉบับในภาษาดั้งเดิมควรถือเป็นแหล่งข้อมูลที่เชื่อถือได้ สำหรับข้อมูลที่สำคัญ ขอแนะนำให้ใช้บริการแปลภาษามืออาชีพ เราไม่รับผิดชอบต่อความเข้าใจผิดหรือการตีความผิดที่เกิดจากการใช้การแปลนี้