# บทเรียน Foundry Local Spring Boot

## สารบัญ

- [ข้อกำหนดเบื้องต้น](#ข้อกำหนดเบื้องต้น)
- [ภาพรวมโครงการ](#ภาพรวมโครงการ)
- [ทำความเข้าใจกับโค้ด](#ทำความเข้าใจกับโค้ด)
  - [1. การกำหนดค่าของแอปพลิเคชัน (application.properties)](#1-การกำหนดค่าของแอปพลิเคชัน-applicationproperties)
  - [2. คลาสแอปพลิเคชันหลัก (Application.java)](#2-คลาสแอปพลิเคชันหลัก-applicationjava)
  - [3. ชั้นบริการ AI (FoundryLocalService.java)](#3-ชั้นบริการ-ai-foundrylocalservicejava)
  - [4. การพึ่งพาโครงการ (pom.xml)](#4-การพึ่งพาโครงการ-pomxml)
- [ภาพรวมการทำงานทั้งหมด](#ภาพรวมการทำงานทั้งหมด)
- [การตั้งค่า Foundry Local](#การตั้งค่า-foundry-local)
- [การรันแอปพลิเคชัน](#การรันแอปพลิเคชัน)
- [ผลลัพธ์ที่คาดหวัง](#ผลลัพธ์ที่คาดหวัง)
- [ขั้นตอนถัดไป](#ขั้นตอนถัดไป)
- [การแก้ไขปัญหา](#การแก้ไขปัญหา)


## ข้อกำหนดเบื้องต้น

ก่อนเริ่มบทเรียนนี้ โปรดตรวจสอบให้แน่ใจว่าคุณมี:

- ติดตั้ง **Java 21 ขึ้นไป** บนระบบของคุณ
- มี **Maven 3.6+** สำหรับการสร้างโครงการ
- ติดตั้งและรัน **Foundry Local**

### **การติดตั้ง Foundry Local:**

> **หมายเหตุ:** Foundry Local CLI ใช้งานได้เฉพาะบน **Windows** และ **macOS** เท่านั้น สำหรับ Linux รองรับผ่าน [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust)

```bash
# วินโดวส์
winget install Microsoft.FoundryLocal

# แมคโอเอส
brew tap microsoft/foundrylocal
brew install foundrylocal
```

ตรวจสอบการติดตั้ง:
```bash
foundry --version
```

## ภาพรวมโครงการ

โครงการนี้ประกอบด้วยส่วนประกอบหลักสี่ส่วน:

1. **Application.java** - จุดเริ่มต้นของแอป Spring Boot หลัก
2. **FoundryLocalService.java** - ชั้นบริการที่จัดการการสื่อสารกับ AI
3. **application.properties** - การกำหนดค่าสำหรับการเชื่อมต่อ Foundry Local
4. **pom.xml** - การพึ่งพา Maven และการตั้งค่าโปรเจกต์

## ทำความเข้าใจกับโค้ด

### 1. การกำหนดค่าของแอปพลิเคชัน (application.properties)

**ไฟล์:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**สิ่งที่ทำ:**
- **base-url**: ระบุที่อยู่ที่ Foundry Local กำลังรันอยู่ รวมทั้งเส้นทาง `/v1` เพื่อความสอดคล้องกับ OpenAI API พอร์ตเริ่มต้นคือ `5273` หากพอร์ตแตกต่างกัน ให้ตรวจสอบด้วย `foundry service status`
- **model** (ตัวเลือก): ตั้งชื่อโมเดล AI ที่จะใช้สำหรับการสร้างข้อความ **โดยปกติแอปจะตรวจสอบโมเดลเองโดยอัตโนมัติ** ด้วยการเรียก `/v1/models` ของ Foundry Local ตอนเริ่มแอป คุณจึงไม่จำเป็นต้องตั้งค่าเอง แต่ยังสามารถตั้งค่าชื่อโมเดลแบบชัดเจนเพื่อแทนที่การตรวจจับอัตโนมัติได้ถ้าต้องการ

**แนวคิดสำคัญ:** Spring Boot จะโหลดการตั้งค่าเหล่านี้โดยอัตโนมัติและทำให้สามารถเข้าถึงค่าต่าง ๆ ในแอปของคุณผ่าน `@Value` annotation

### 2. คลาสแอปพลิเคชันหลัก (Application.java)

**ไฟล์:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // ไม่ต้องใช้เว็บเซิร์ฟเวอร์
        app.run(args);
    }
```

**สิ่งที่ทำ:**
- `@SpringBootApplication` เปิดใช้งานการตั้งค่าอัตโนมัติของ Spring Boot
- `WebApplicationType.NONE` บอกว่าแอปนี้เป็นแอป command-line ไม่ใช่เว็บเซิร์ฟเวอร์
- เมธอดหลักเริ่มต้น Spring application

**โค้ด Demo Runner:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        System.out.println("Calling Foundry Local service...");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
        System.out.println("=========================");
    };
}
```

**สิ่งที่ทำ:**
- `@Bean` สร้างคอมโพเนนต์ที่ Spring จัดการให้
- `CommandLineRunner` รันโค้ดหลังจาก Spring Boot เริ่มทำงาน
- `foundryLocalService` ถูกฉีดเข้ามาโดย Spring (dependency injection)
- ส่งข้อความทดสอบไปยัง AI และแสดงผลลัพธ์

### 3. ชั้นบริการ AI (FoundryLocalService.java)

**ไฟล์:** `src/main/java/com/example/FoundryLocalService.java`

#### การฉีดการตั้งค่า:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // ตรวจจับโดยอัตโนมัติหากว่างเปล่า
```

**สิ่งที่ทำ:**
- `@Service` แจ้งให้ Spring ว่านี่คือคลาสที่ให้บริการธุรกิจ
- `@Value` ฉีดค่าการตั้งค่าจากไฟล์ application.properties
- โมเดลตั้งค่าเริ่มต้นเป็นค่าว่าง ทำให้เกิดการ **ตรวจจับอัตโนมัติ** จาก Foundry Local ตอนแอปรัน ซึ่งหมายความว่าแอปสามารถทำงานกับโมเดลใดก็ได้ที่โหลดใน Foundry Local โดยไม่ต้องตั้งค่าเอง

#### การเริ่มต้นไคลเอ็นต์:
```java
@PostConstruct
public void init() {
    // ตรวจจับโมเดลโดยอัตโนมัติจาก Foundry Local หากไม่ได้กำหนดค่าอย่างชัดเจน
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // URL พื้นฐานรวม /v1 จากการกำหนดค่าแล้ว
            .apiKey("not-needed")            // เซิร์ฟเวอร์ท้องถิ่นไม่จำเป็นต้องใช้คีย์ API จริง
            .build();
}
```

**สิ่งที่ทำ:**
- `@PostConstruct` รันเมธอดนี้หลังจาก Spring สร้างบริการเสร็จ
- หากยังไม่มีการตั้งค่าโมเดล จะเรียก `/v1/models` ของ Foundry Local และเลือกโมเดลแรกที่โหลดอยู่
- สร้างไคลเอ็นต์ OpenAI ที่ชี้ไปยัง Foundry Local บนเครื่องของคุณ
- base URL จาก `application.properties` มี `/v1` รวมอยู่แล้วสำหรับการใช้งานร่วมกับ OpenAI API
- API คีย์ตั้งเป็น "not-needed" เพราะการพัฒนาท้องถิ่นไม่จำเป็นต้องเข้าสู่ระบบ

#### เมธอด Chat:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // ใช้โมเดล AI ตัวไหน
                .addUserMessage(message)         // คำถาม/ข้อความของคุณ
                .maxCompletionTokens(150)        // จำกัดความยาวคำตอบ
                .temperature(0.7)                // ควบคุมความคิดสร้างสรรค์ (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // ดึงคำตอบของ AI จากผลลัพธ์ของ API
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**สิ่งที่ทำ:**
- **ChatCompletionCreateParams**: ตั้งค่า request ไปยัง AI
  - `model`: ระบุโมเดล AI ที่จะใช้ (ต้องตรงกับ ID จาก `foundry model list`)
  - `addUserMessage`: เพิ่มข้อความของผู้ใช้ในการสนทนา
  - `maxCompletionTokens`: จำกัดความยาวคำตอบ (ช่วยประหยัดทรัพยากร)
  - `temperature`: ควบคุมความสุ่ม (0.0 = ตายตัว, 1.0 = สร้างสรรค์)
- **เรียก API**: ส่ง request ไปที่ Foundry Local
- **จัดการผลตอบกลับ**: ดึงข้อความตอบกลับจาก AI อย่างปลอดภัย
- **จัดการข้อผิดพลาด**: ห่อหุ้มข้อยกเว้นด้วยข้อความแสดงความผิดพลาดที่ช่วยให้เข้าใจ

### 4. การพึ่งพาโครงการ (pom.xml)

**การพึ่งพาที่สำคัญ:**

```xml
<!-- Spring Boot - Application framework -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>${spring-boot.version}</version>
</dependency>

<!-- OpenAI Java SDK - For AI API calls -->
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>

<!-- Jackson - JSON processing -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.0</version>
</dependency>
```

**สิ่งที่ทำ:**
- **spring-boot-starter**: ให้ฟังก์ชันหลักของ Spring Boot
- **openai-java**: SDK อย่างเป็นทางการของ OpenAI สำหรับ Java เพื่อสื่อสารกับ API
- **jackson-databind**: จัดการการแปลง JSON สำหรับการเรียก API

## ภาพรวมการทำงานทั้งหมด

นี่คือขั้นตอนการทำงานเวลาที่คุณรันแอป:

1. **เริ่มต้น**: Spring Boot เริ่มและอ่านค่าใน `application.properties`
2. **สร้างบริการ**: Spring สร้าง `FoundryLocalService` และฉีดค่าการตั้งค่าเข้าไป
3. **ตรวจจับโมเดล**: หากไม่มีการกำหนดโมเดลไว้ บริการจะเรียก `/v1/models` ของ Foundry Local และใช้โมเดลตัวแรกโดยอัตโนมัติ
4. **ตั้งค่าไคลเอ็นต์**: `@PostConstruct` เริ่มต้นไคลเอ็นต์ OpenAI เพื่อเชื่อมต่อกับ Foundry Local
5. **รัน Demo**: `CommandLineRunner` รันหลังจากเริ่มแอป
6. **เรียก AI**: โค้ด demo เรียก `foundryLocalService.chat()` กับข้อความทดสอบ
7. **ส่ง request API**: บริการสร้างและส่งคำขอที่รองรับ OpenAI ไปยัง Foundry Local
8. **ประมวลผลผลลัพธ์**: บริการดึงและส่งคืนข้อความตอบกลับจาก AI
9. **แสดงผล**: แอปพิมพ์คำตอบและออกจากระบบ

## การตั้งค่า Foundry Local

1. **ติดตั้ง Foundry Local** ตามคำแนะนำในส่วน [ข้อกำหนดเบื้องต้น](#ข้อกำหนดเบื้องต้น)

2. **เริ่มบริการ** (หากยังไม่ได้รัน):
   ```bash
   foundry service start
   ```

3. **ตรวจสอบสถานะบริการ** เพื่อยืนยันว่าบริการกำลังทำงานและจดพอร์ต:
   ```bash
   foundry service status
   ```

4. **ดาวน์โหลดและรันโมเดล** (ดาวน์โหลดครั้งแรกที่รัน, แคชสำหรับครั้งถัดไป):
   ```bash
   foundry model run phi-4-mini
   ```
   จะเปิดเซสชันแชทอินเทอร์แอกทีฟ คุณสามารถออกได้ด้วย `Ctrl+C` โมเดลยังคงถูกโหลดอยู่ในบริการ

   > **เคล็ดลับ:** รัน `foundry model list` เพื่อดูโมเดลทั้งหมดที่มี ใช้ชื่อเล่นแทน `phi-4-mini` จากแค็ตตาล็อก (เช่น `qwen2.5-0.5b` สำหรับโมเดลขนาดเล็ก/เร็วกว่า)

5. **ตรวจสอบว่าโมเดลถูกโหลดแล้ว:**
   ```bash
   foundry service ps
   ```

6. **อัปเดต `application.properties` หากจำเป็น:**
   - ค่า `base-url` เริ่มต้น (`http://localhost:5273/v1`) เหมาะกับพอร์ต CLI เริ่มต้น ปรับเฉพาะถ้า `foundry service status` แสดงพอร์ตต่างออกไป
   - โมเดลจะถูก **ตรวจจับโดยอัตโนมัติ** ตอนเริ่มแอป — ไม่ต้องตั้งค่าเอง

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## การรันแอปพลิเคชัน

### ขั้นตอนที่ 1: ตรวจสอบว่าโมเดลถูกโหลดใน Foundry Local
```bash
foundry service ps
```
ถ้าไม่มีโมเดลใดแสดง, ให้โหลดโมเดลหนึ่ง:
```bash
foundry model run phi-4-mini
```

### ขั้นตอนที่ 2: สร้างและรันแอปพลิเคชัน
ในเทอร์มินัลอีกหน้าหนึ่ง:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

หรือสร้างและรันเป็นไฟล์ JAR:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## ผลลัพธ์ที่คาดหวัง

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## ขั้นตอนถัดไป

สำหรับตัวอย่างเพิ่มเติม ดู [บทที่ 04: ตัวอย่างปฎิบัติ](../README.md)

## การแก้ไขปัญหา

### ปัญหาที่พบได้บ่อย

**"Connection refused" หรือ "Service unavailable"**
- ตรวจสอบบริการ: `foundry service status`
- รีสตาร์ทหากจำเป็น: `foundry service restart`
- ตรวจสอบให้แน่ใจว่าพอร์ตใน `application.properties` ตรงกับผลลัพธ์ `foundry service status`
- ตรวจสอบให้ URL ลงท้ายด้วย `/v1`: `http://localhost:5273/v1`

**"ไม่พบโมเดล" ตอนเริ่มแอป**
- แอปจะตรวจจับโมเดลเองโดยอัตโนมัติ ให้แน่ใจว่าอย่างน้อยมีโมเดลหนึ่งโหลด: `foundry service ps`
- หากไม่มีโมเดล โหลดโมเดลด้วย: `foundry model run phi-4-mini`
- ถ้าคุณตั้งชื่อโมเดลใน `application.properties` ให้ตรวจสอบว่าตรงกับชื่อจาก `foundry model list`

**ข้อผิดพลาด "400 Bad Request"**
- ตรวจสอบว่า base URL มี `/v1` รวมอยู่: `http://localhost:5273/v1`
- ตรวจสอบว่าใช้ `maxCompletionTokens()` ในโค้ดแทน `maxTokens()` ที่เลิกใช้งานแล้ว

**ข้อผิดพลาดคอมไพล์ Maven**
- ตรวจสอบ Java 21 ขึ้นไป: `java -version`
- ล้างและคอมไพล์ใหม่: `mvn clean compile`
- ตรวจสอบการเชื่อมต่ออินเทอร์เน็ตเพื่อดาวน์โหลด dependencies

**ปัญหาการเชื่อมต่อบริการ**
- ถ้าเห็นข้อความ `Request to local service failed` ให้รัน: `foundry service restart`
- ตรวจสอบโมเดลที่โหลด: `foundry service ps`
- ดูบันทึกของบริการ: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ข้อจำกัดความรับผิดชอบ**:
เอกสารฉบับนี้ได้รับการแปลโดยใช้บริการแปลภาษาของ AI [Co-op Translator](https://github.com/Azure/co-op-translator) แม้ว่าเราจะพยายามให้มีความถูกต้อง แต่โปรดทราบว่าการแปลโดยอัตโนมัติอาจมีข้อผิดพลาดหรือความไม่ถูกต้อง เอกสารต้นฉบับในภาษาดั้งเดิมควรถือเป็นแหล่งข้อมูลที่เชื่อถือได้ สำหรับข้อมูลที่สำคัญ ขอแนะนำให้ใช้บริการแปลโดยมนุษย์มืออาชีพ เราไม่รับผิดชอบต่อความเข้าใจผิดหรือการตีความผิดใด ๆ ที่เกิดขึ้นจากการใช้การแปลนี้
<!-- CO-OP TRANSLATOR DISCLAIMER END -->