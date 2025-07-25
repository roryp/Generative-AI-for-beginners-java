<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d064108b2142d32246ccbd8a42e76b4d",
  "translation_date": "2025-07-25T09:33:39+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "th"
}
-->
# แอปพลิเคชัน Command-Line ของ Foundry Local

>**หมายเหตุ**: บทนี้มี [**บทแนะนำ**](./TUTORIAL.md) ที่จะช่วยแนะนำคุณผ่านตัวอย่างต่างๆ

แอปพลิเคชัน Command-Line แบบง่ายที่พัฒนาด้วย Spring Boot ซึ่งแสดงวิธีการเชื่อมต่อกับ Foundry Local โดยใช้ OpenAI Java SDK

## สิ่งที่คุณจะได้เรียนรู้

- วิธีการผสาน Foundry Local เข้ากับแอปพลิเคชัน Spring Boot โดยใช้ OpenAI Java SDK
- แนวทางปฏิบัติที่ดีที่สุดสำหรับการพัฒนาและทดสอบ AI ในเครื่อง

## สารบัญ

- [สิ่งที่คุณจะได้เรียนรู้](../../../../04-PracticalSamples/foundrylocal)
- [ข้อกำหนดเบื้องต้น](../../../../04-PracticalSamples/foundrylocal)
  - [การติดตั้ง Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [การตรวจสอบ](../../../../04-PracticalSamples/foundrylocal)
- [การตั้งค่า](../../../../04-PracticalSamples/foundrylocal)
- [เริ่มต้นใช้งานอย่างรวดเร็ว](../../../../04-PracticalSamples/foundrylocal)
- [สิ่งที่แอปพลิเคชันทำ](../../../../04-PracticalSamples/foundrylocal)
- [ตัวอย่างผลลัพธ์](../../../../04-PracticalSamples/foundrylocal)
- [สถาปัตยกรรม](../../../../04-PracticalSamples/foundrylocal)
- [จุดเด่นของโค้ด](../../../../04-PracticalSamples/foundrylocal)
  - [การผสาน OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [Chat Completion API](../../../../04-PracticalSamples/foundrylocal)
- [การแก้ไขปัญหา](../../../../04-PracticalSamples/foundrylocal)

## ข้อกำหนดเบื้องต้น

> **⚠️ หมายเหตุ**: แอปพลิเคชันนี้ **ไม่สามารถทำงานใน devcontainer ที่ให้มาได้** เนื่องจากต้องการให้ Foundry Local ติดตั้งและทำงานบนระบบโฮสต์

### การติดตั้ง Foundry Local

ก่อนที่จะรันแอปพลิเคชันนี้ คุณต้องติดตั้งและเริ่มต้น Foundry Local โดยทำตามขั้นตอนดังนี้:

1. **ตรวจสอบว่าระบบของคุณตรงตามข้อกำหนด**:
   - **ระบบปฏิบัติการ**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 หรือ macOS
   - **ฮาร์ดแวร์**: 
     - ขั้นต่ำ: RAM 8GB, พื้นที่ว่างในดิสก์ 3GB
     - แนะนำ: RAM 16GB, พื้นที่ว่างในดิสก์ 15GB
   - **เครือข่าย**: การเชื่อมต่ออินเทอร์เน็ตสำหรับการดาวน์โหลดโมเดลครั้งแรก (ไม่จำเป็นสำหรับการใช้งานแบบออฟไลน์)
   - **การเร่งความเร็ว (ไม่บังคับ)**: NVIDIA GPU (ซีรีส์ 2,000 หรือใหม่กว่า), AMD GPU (ซีรีส์ 6,000 หรือใหม่กว่า), Qualcomm Snapdragon X Elite (RAM 8GB หรือมากกว่า) หรือ Apple silicon
   - **สิทธิ์**: สิทธิ์ผู้ดูแลระบบสำหรับการติดตั้งซอฟต์แวร์บนอุปกรณ์ของคุณ

2. **ติดตั้ง Foundry Local**:
   
   **สำหรับ Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **สำหรับ macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   หรือคุณสามารถดาวน์โหลดตัวติดตั้งได้จาก [Foundry Local GitHub repository](https://github.com/microsoft/Foundry-Local)

3. **เริ่มต้นโมเดลแรกของคุณ**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   โมเดลจะถูกดาวน์โหลด (ซึ่งอาจใช้เวลาสักครู่ ขึ้นอยู่กับความเร็วอินเทอร์เน็ตของคุณ) และเริ่มทำงาน Foundry Local จะเลือกโมเดลที่เหมาะสมที่สุดสำหรับระบบของคุณโดยอัตโนมัติ (CUDA สำหรับ NVIDIA GPUs หรือเวอร์ชัน CPU หากไม่มี)

4. **ทดสอบโมเดล** โดยการถามคำถามในเทอร์มินัลเดียวกัน:

   ```bash
   Why is the sky blue?
   ```

   คุณควรเห็นคำตอบจากโมเดล Phi ที่อธิบายว่าทำไมท้องฟ้าถึงมีสีฟ้า

### การตรวจสอบ

คุณสามารถตรวจสอบว่าทุกอย่างทำงานได้อย่างถูกต้องด้วยคำสั่งเหล่านี้:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

คุณยังสามารถเข้าไปที่ `http://localhost:5273` ในเบราว์เซอร์ของคุณเพื่อดูอินเทอร์เฟซเว็บของ Foundry Local

## การตั้งค่า

แอปพลิเคชันสามารถตั้งค่าได้ผ่านไฟล์ `application.properties`:

- `foundry.local.base-url` - URL พื้นฐานสำหรับ Foundry Local (ค่าเริ่มต้น: http://localhost:5273)
- `foundry.local.model` - โมเดล AI ที่จะใช้ (ค่าเริ่มต้น: Phi-3.5-mini-instruct-cuda-gpu)

> **หมายเหตุ**: ชื่อโมเดลในไฟล์การตั้งค่าควรตรงกับตัวแปรเฉพาะที่ Foundry Local ดาวน์โหลดสำหรับระบบของคุณ เมื่อคุณรันคำสั่ง `foundry model run phi-3.5-mini` Foundry Local จะเลือกและดาวน์โหลดตัวแปรที่ดีที่สุดโดยอัตโนมัติ (CUDA สำหรับ NVIDIA GPUs หรือเวอร์ชัน CPU หากไม่มี) ใช้คำสั่ง `foundry model list` เพื่อดูชื่อโมเดลที่มีในอินสแตนซ์ของคุณ

## เริ่มต้นใช้งานอย่างรวดเร็ว

### 1. ไปที่ไดเรกทอรีแอปพลิเคชัน Foundry Local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. รันแอปพลิเคชัน

```bash
mvn spring-boot:run
```

หรือสร้างและรันไฟล์ JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### การพึ่งพา

แอปพลิเคชันนี้ใช้ OpenAI Java SDK เพื่อสื่อสารกับ Foundry Local โดยการพึ่งพาหลักคือ:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

แอปพลิเคชันถูกตั้งค่าไว้ล่วงหน้าเพื่อเชื่อมต่อกับ Foundry Local ที่รันอยู่บนพอร์ตเริ่มต้น

## สิ่งที่แอปพลิเคชันทำ

เมื่อคุณรันแอปพลิเคชัน:

1. **เริ่มต้น** เป็นแอปพลิเคชัน Command-Line (ไม่มีเว็บเซิร์ฟเวอร์)
2. **ส่งข้อความทดสอบ** โดยอัตโนมัติ: "Hello! Can you tell me what you are and what model you're running?"
3. **แสดงผลลัพธ์** จาก Foundry Local ในคอนโซล
4. **ปิดตัวลงอย่างเรียบร้อย** หลังจากการสาธิต

## ตัวอย่างผลลัพธ์

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## สถาปัตยกรรม

- **Application.java** - แอปพลิเคชันหลักของ Spring Boot พร้อม CommandLineRunner
- **FoundryLocalService.java** - บริการที่ใช้ OpenAI Java SDK เพื่อสื่อสารกับ Foundry Local
- ใช้ **OpenAI Java SDK** สำหรับการเรียก API แบบ type-safe
- การจัดการ JSON serialization/deserialization อัตโนมัติผ่าน SDK
- การตั้งค่าที่สะอาดตาโดยใช้ Spring's `@Value` และ `@PostConstruct`

## จุดเด่นของโค้ด

### การผสาน OpenAI Java SDK

แอปพลิเคชันใช้ OpenAI Java SDK เพื่อสร้างไคลเอนต์ที่ตั้งค่าสำหรับ Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### Chat Completion API

การทำคำขอ Chat Completion นั้นง่ายและปลอดภัย:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## การแก้ไขปัญหา

หากคุณพบข้อผิดพลาดในการเชื่อมต่อ:
1. ตรวจสอบว่า Foundry Local กำลังทำงานอยู่ที่ `http://localhost:5273`
2. ตรวจสอบว่ามีตัวแปรโมเดล Phi-3.5-mini พร้อมใช้งานโดยใช้คำสั่ง `foundry model list`
3. ตรวจสอบให้แน่ใจว่าชื่อโมเดลใน `application.properties` ตรงกับชื่อโมเดลที่แสดงในรายการ
4. ตรวจสอบว่าไม่มีไฟร์วอลล์ที่บล็อกการเชื่อมต่อ

ปัญหาที่พบบ่อย:
- **ไม่พบโมเดล**: รันคำสั่ง `foundry model run phi-3.5-mini` เพื่อดาวน์โหลดและเริ่มต้นโมเดล
- **บริการไม่ทำงาน**: บริการ Foundry Local อาจหยุดทำงาน ให้เริ่มต้นใหม่ด้วยคำสั่ง run โมเดล
- **ชื่อโมเดลผิด**: ใช้คำสั่ง `foundry model list` เพื่อดูโมเดลที่มีและอัปเดตการตั้งค่าของคุณให้ถูกต้อง

**ข้อจำกัดความรับผิดชอบ**:  
เอกสารนี้ได้รับการแปลโดยใช้บริการแปลภาษา AI [Co-op Translator](https://github.com/Azure/co-op-translator) แม้ว่าเราจะพยายามให้การแปลมีความถูกต้องมากที่สุด แต่โปรดทราบว่าการแปลอัตโนมัติอาจมีข้อผิดพลาดหรือความไม่ถูกต้อง เอกสารต้นฉบับในภาษาดั้งเดิมควรถือเป็นแหล่งข้อมูลที่เชื่อถือได้ สำหรับข้อมูลที่สำคัญ ขอแนะนำให้ใช้บริการแปลภาษามนุษย์ที่มีความเชี่ยวชาญ เราจะไม่รับผิดชอบต่อความเข้าใจผิดหรือการตีความที่ผิดพลาดซึ่งเกิดจากการใช้การแปลนี้