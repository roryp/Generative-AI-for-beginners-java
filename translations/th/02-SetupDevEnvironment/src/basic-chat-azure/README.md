<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2289320a74aeca1eb844cd7d3a7a9e12",
  "translation_date": "2025-07-21T19:38:33+00:00",
  "source_file": "02-SetupDevEnvironment/src/basic-chat-azure/README.md",
  "language_code": "th"
}
-->
# ตัวอย่างการแชทพื้นฐานกับ Azure OpenAI - ตั้งแต่ต้นจนจบ

ตัวอย่างนี้แสดงวิธีสร้างแอปพลิเคชัน Spring Boot แบบง่ายที่เชื่อมต่อกับ Azure OpenAI และทดสอบการตั้งค่าของคุณ

## สารบัญ

- [ข้อกำหนดเบื้องต้น](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [เริ่มต้นอย่างรวดเร็ว](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [ตัวเลือกการกำหนดค่า](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [ตัวเลือกที่ 1: ตัวแปรสภาพแวดล้อม (.env file) - แนะนำ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [ตัวเลือกที่ 2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [การรันแอปพลิเคชัน](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [ใช้ Maven](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [ใช้ VS Code](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [ผลลัพธ์ที่คาดหวัง](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [การอ้างอิงการกำหนดค่า](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [ตัวแปรสภาพแวดล้อม](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [การกำหนดค่า Spring](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [การแก้ไขปัญหา](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [ปัญหาทั่วไป](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [โหมดดีบัก](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [ขั้นตอนถัดไป](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [แหล่งข้อมูล](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)

## ข้อกำหนดเบื้องต้น

ก่อนที่จะรันตัวอย่างนี้ ตรวจสอบให้แน่ใจว่าคุณมี:

- ทำตาม [คู่มือการตั้งค่า Azure OpenAI](../../getting-started-azure-openai.md) เสร็จสมบูรณ์  
- ได้ปรับใช้ทรัพยากร Azure OpenAI (ผ่านพอร์ทัล Azure AI Foundry)  
- ได้ปรับใช้โมเดล gpt-4o-mini (หรือโมเดลอื่น)  
- มี API key และ endpoint URL จาก Azure  

## เริ่มต้นอย่างรวดเร็ว

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/src/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## ตัวเลือกการกำหนดค่า

### ตัวเลือกที่ 1: ตัวแปรสภาพแวดล้อม (.env file) - แนะนำ

**ขั้นตอนที่ 1: สร้างไฟล์การกำหนดค่าของคุณ**  
```bash
cp .env.example .env
```

**ขั้นตอนที่ 2: เพิ่มข้อมูลรับรอง Azure OpenAI ของคุณ**  
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **หมายเหตุด้านความปลอดภัย**: 
> - ห้าม commit ไฟล์ `.env` ของคุณลงในระบบควบคุมเวอร์ชัน
> - ไฟล์ `.env` ได้ถูกเพิ่มใน `.gitignore` แล้ว
> - เก็บ API key ของคุณให้ปลอดภัยและหมุนเวียนเป็นประจำ

### ตัวเลือกที่ 2: GitHub Codespace Secrets

สำหรับ GitHub Codespaces ให้ตั้งค่า secrets เหล่านี้ใน repository ของคุณ:
- `AZURE_AI_KEY` - Azure OpenAI API key ของคุณ
- `AZURE_AI_ENDPOINT` - Azure OpenAI endpoint URL ของคุณ

แอปพลิเคชันจะตรวจจับและใช้ secrets เหล่านี้โดยอัตโนมัติ

### ทางเลือก: ตัวแปรสภาพแวดล้อมโดยตรง

<details>
<summary>คลิกเพื่อดูคำสั่งเฉพาะแพลตฟอร์ม</summary>

**Linux/macOS (bash/zsh):**  
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Command Prompt):**  
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**  
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## การรันแอปพลิเคชัน

### ใช้ Maven

```bash
mvn spring-boot:run
```

### ใช้ VS Code

1. เปิดโปรเจกต์ใน VS Code  
2. กด `F5` หรือใช้แผง "Run and Debug"  
3. เลือกการกำหนดค่า "Spring Boot-BasicChatApplication"  

> **หมายเหตุ**: การกำหนดค่าใน VS Code จะโหลดไฟล์ .env ของคุณโดยอัตโนมัติ

### ผลลัพธ์ที่คาดหวัง

```
Starting Basic Chat with Azure OpenAI...
Environment variables loaded successfully
Connecting to Azure OpenAI...
Sending prompt: What is AI in a short sentence? Max 100 words.

AI Response:
================
AI, or Artificial Intelligence, is the simulation of human intelligence in machines programmed to think and learn like humans.
================

Success! Azure OpenAI connection is working correctly.
```

## การอ้างอิงการกำหนดค่า

### ตัวแปรสภาพแวดล้อม

| ตัวแปร | คำอธิบาย | จำเป็น | ตัวอย่าง |
|--------|-----------|--------|----------|
| `AZURE_AI_KEY` | Azure OpenAI API key | ใช่ | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI endpoint URL | ใช่ | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | ชื่อการปรับใช้โมเดล | ไม่ | `gpt-4o-mini` (ค่าเริ่มต้น) |

### การกำหนดค่า Spring

ไฟล์ `application.yml` กำหนดค่า:
- **API Key**: `${AZURE_AI_KEY}` - จากตัวแปรสภาพแวดล้อม  
- **Endpoint**: `${AZURE_AI_ENDPOINT}` - จากตัวแปรสภาพแวดล้อม  
- **Model**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - จากตัวแปรสภาพแวดล้อมพร้อมค่าเริ่มต้น  
- **Temperature**: `0.7` - ควบคุมความคิดสร้างสรรค์ (0.0 = กำหนดแน่นอน, 1.0 = สร้างสรรค์)  
- **Max Tokens**: `500` - ความยาวการตอบสนองสูงสุด  

## การแก้ไขปัญหา

### ปัญหาทั่วไป

<details>
<summary><strong>ข้อผิดพลาด: "The API key is not valid"</strong></summary>

- ตรวจสอบว่า `AZURE_AI_KEY` ของคุณตั้งค่าอย่างถูกต้องในไฟล์ `.env`  
- ยืนยันว่า API key คัดลอกมาจากพอร์ทัล Azure AI Foundry อย่างถูกต้อง  
- ตรวจสอบว่าไม่มีช่องว่างหรือเครื่องหมายคำพูดเกินรอบๆ key  
</details>

<details>
<summary><strong>ข้อผิดพลาด: "The endpoint is not valid"</strong></summary>

- ตรวจสอบว่า `AZURE_AI_ENDPOINT` ของคุณมี URL เต็มรูปแบบ (เช่น `https://your-hub-name.openai.azure.com/`)  
- ตรวจสอบความสม่ำเสมอของเครื่องหมายทับท้าย  
- ยืนยันว่า endpoint ตรงกับภูมิภาคการปรับใช้ Azure ของคุณ  
</details>

<details>
<summary><strong>ข้อผิดพลาด: "The deployment was not found"</strong></summary>

- ยืนยันว่าชื่อการปรับใช้โมเดลของคุณตรงกับที่ปรับใช้ใน Azure อย่างถูกต้อง  
- ตรวจสอบว่าโมเดลถูกปรับใช้และใช้งานได้  
- ลองใช้ชื่อการปรับใช้ค่าเริ่มต้น: `gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code: ตัวแปรสภาพแวดล้อมไม่โหลด</strong></summary>

- ตรวจสอบว่าไฟล์ `.env` ของคุณอยู่ในไดเรกทอรีรากของโปรเจกต์ (ระดับเดียวกับ `pom.xml`)  
- ลองรัน `mvn spring-boot:run` ใน terminal แบบรวมของ VS Code  
- ตรวจสอบว่า VS Code Java extension ติดตั้งอย่างถูกต้อง  
- ยืนยันว่าการกำหนดค่า launch มี `"envFile": "${workspaceFolder}/.env"`  
</details>

### โหมดดีบัก

เพื่อเปิดใช้งานการบันทึกข้อมูลอย่างละเอียด ให้ยกเลิกการคอมเมนต์บรรทัดเหล่านี้ใน `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## ขั้นตอนถัดไป

**การตั้งค่าเสร็จสมบูรณ์!** ดำเนินการเรียนรู้ของคุณต่อไป:

[บทที่ 3: เทคนิคหลักของ Generative AI](../../../03-CoreGenerativeAITechniques/README.md)

## แหล่งข้อมูล

- [เอกสาร Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [เอกสารบริการ Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)  
- [พอร์ทัล Azure AI Foundry](https://ai.azure.com/)  
- [เอกสาร Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**ข้อจำกัดความรับผิดชอบ**:  
เอกสารนี้ได้รับการแปลโดยใช้บริการแปลภาษา AI [Co-op Translator](https://github.com/Azure/co-op-translator) แม้ว่าเราจะพยายามอย่างเต็มที่เพื่อให้การแปลมีความถูกต้อง แต่โปรดทราบว่าการแปลอัตโนมัติอาจมีข้อผิดพลาดหรือความไม่แม่นยำ เอกสารต้นฉบับในภาษาต้นทางควรถูกพิจารณาเป็นแหล่งข้อมูลที่เชื่อถือได้ สำหรับข้อมูลที่มีความสำคัญ แนะนำให้ใช้บริการแปลภาษามนุษย์ที่เป็นมืออาชีพ เราจะไม่รับผิดชอบต่อความเข้าใจผิดหรือการตีความที่ผิดพลาดซึ่งเกิดจากการใช้การแปลนี้