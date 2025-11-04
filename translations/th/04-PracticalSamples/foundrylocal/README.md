<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "fe08a184d8a753a0f497673921f77759",
  "translation_date": "2025-11-04T06:48:58+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "th"
}
-->
# คู่มือการใช้งาน Foundry Local Spring Boot

## สารบัญ

- [ข้อกำหนดเบื้องต้น](../../../../04-PracticalSamples/foundrylocal)
- [ภาพรวมของโปรเจกต์](../../../../04-PracticalSamples/foundrylocal)
- [การทำความเข้าใจโค้ด](../../../../04-PracticalSamples/foundrylocal)
  - [1. การตั้งค่าของแอปพลิเคชัน (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. คลาสแอปพลิเคชันหลัก (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. ชั้นบริการ AI (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. การพึ่งพาโปรเจกต์ (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [การทำงานร่วมกันทั้งหมด](../../../../04-PracticalSamples/foundrylocal)
- [การตั้งค่า Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [การรันแอปพลิเคชัน](../../../../04-PracticalSamples/foundrylocal)
- [ผลลัพธ์ที่คาดหวัง](../../../../04-PracticalSamples/foundrylocal)
- [ขั้นตอนถัดไป](../../../../04-PracticalSamples/foundrylocal)
- [การแก้ไขปัญหา](../../../../04-PracticalSamples/foundrylocal)

## ข้อกำหนดเบื้องต้น

ก่อนเริ่มต้นคู่มือนี้ ตรวจสอบให้แน่ใจว่าคุณมี:

- **Java 21 หรือสูงกว่า** ติดตั้งในระบบของคุณ
- **Maven 3.6+** สำหรับการสร้างโปรเจกต์
- **Foundry Local** ติดตั้งและกำลังทำงานอยู่

### **การติดตั้ง Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## ภาพรวมของโปรเจกต์

โปรเจกต์นี้ประกอบด้วย 4 ส่วนหลัก:

1. **Application.java** - จุดเริ่มต้นของแอปพลิเคชัน Spring Boot
2. **FoundryLocalService.java** - ชั้นบริการที่จัดการการสื่อสารกับ AI
3. **application.properties** - การตั้งค่าสำหรับการเชื่อมต่อ Foundry Local
4. **pom.xml** - การพึ่งพา Maven และการตั้งค่าโปรเจกต์

## การทำความเข้าใจโค้ด

### 1. การตั้งค่าของแอปพลิเคชัน (application.properties)

**ไฟล์:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**สิ่งที่ทำ:**
- **base-url**: ระบุที่อยู่ที่ Foundry Local กำลังทำงาน รวมถึงเส้นทาง `/v1` เพื่อความเข้ากันได้กับ OpenAI API **หมายเหตุ**: Foundry Local กำหนดพอร์ตแบบไดนามิก ดังนั้นตรวจสอบพอร์ตจริงของคุณโดยใช้ `foundry service status`
- **model**: ระบุชื่อโมเดล AI ที่จะใช้สำหรับการสร้างข้อความ รวมถึงหมายเลขเวอร์ชัน (เช่น `:1`) ใช้ `foundry model list` เพื่อดูโมเดลที่มีอยู่พร้อม ID ที่แน่นอน

**แนวคิดสำคัญ:** Spring Boot โหลดคุณสมบัติเหล่านี้โดยอัตโนมัติและทำให้พร้อมใช้งานในแอปพลิเคชันของคุณโดยใช้คำสั่ง `@Value`

### 2. คลาสแอปพลิเคชันหลัก (Application.java)

**ไฟล์:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```

**สิ่งที่ทำ:**
- `@SpringBootApplication` เปิดใช้งานการตั้งค่าอัตโนมัติของ Spring Boot
- `WebApplicationType.NONE` บอก Spring ว่านี่คือแอปพลิเคชันแบบบรรทัดคำสั่ง ไม่ใช่เซิร์ฟเวอร์เว็บ
- เมธอดหลักเริ่มต้นแอปพลิเคชัน Spring

**ตัวรันเดโม:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
    };
}
```

**สิ่งที่ทำ:**
- `@Bean` สร้างคอมโพเนนต์ที่ Spring จัดการ
- `CommandLineRunner` รันโค้ดหลังจาก Spring Boot เริ่มต้น
- `foundryLocalService` ถูกฉีดโดยอัตโนมัติด้วย Spring (dependency injection)
- ส่งข้อความทดสอบไปยัง AI และแสดงผลลัพธ์

### 3. ชั้นบริการ AI (FoundryLocalService.java)

**ไฟล์:** `src/main/java/com/example/FoundryLocalService.java`

#### การฉีดค่าการตั้งค่า:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```

**สิ่งที่ทำ:**
- `@Service` บอก Spring ว่าคลาสนี้ให้บริการตรรกะทางธุรกิจ
- `@Value` ฉีดค่าการตั้งค่าจาก application.properties
- ไวยากรณ์ `:default-value` ให้ค่าตกลงหากไม่มีการตั้งค่า

#### การเริ่มต้นไคลเอนต์:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```

**สิ่งที่ทำ:**
- `@PostConstruct` รันเมธอดนี้หลังจาก Spring สร้างบริการ
- สร้างไคลเอนต์ OpenAI ที่ชี้ไปยัง Foundry Local ในเครื่องของคุณ
- URL พื้นฐานจาก `application.properties` รวมถึง `/v1` เพื่อความเข้ากันได้กับ OpenAI API
- คีย์ API ถูกตั้งค่าเป็น "not-needed" เพราะการพัฒนาในเครื่องไม่ต้องการการตรวจสอบสิทธิ์

#### เมธอดแชท:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Which AI model to use
                .addUserMessage(message)         // Your question/prompt
                .maxCompletionTokens(150)        // Limit response length
                .temperature(0.7)                // Control creativity (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extract the AI's response from the API result
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
- **ChatCompletionCreateParams**: กำหนดค่าคำขอ AI
  - `model`: ระบุโมเดล AI ที่จะใช้ (ต้องตรงกับ ID ที่แน่นอนจาก `foundry model list`)
  - `addUserMessage`: เพิ่มข้อความของคุณในบทสนทนา
  - `maxCompletionTokens`: จำกัดความยาวของผลลัพธ์ (ประหยัดทรัพยากร)
  - `temperature`: ควบคุมความสุ่ม (0.0 = กำหนดแน่นอน, 1.0 = สร้างสรรค์)
- **การเรียก API**: ส่งคำขอไปยัง Foundry Local
- **การจัดการผลลัพธ์**: ดึงข้อความตอบกลับของ AI อย่างปลอดภัย
- **การจัดการข้อผิดพลาด**: ห่อข้อยกเว้นด้วยข้อความแนะนำที่เป็นประโยชน์

### 4. การพึ่งพาโปรเจกต์ (pom.xml)

**การพึ่งพาหลัก:**

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
- **spring-boot-starter**: ให้ฟังก์ชันการทำงานหลักของ Spring Boot
- **openai-java**: SDK Java อย่างเป็นทางการของ OpenAI สำหรับการสื่อสาร API
- **jackson-databind**: จัดการการแปลง JSON สำหรับการเรียก API

## การทำงานร่วมกันทั้งหมด

นี่คือกระบวนการทั้งหมดเมื่อคุณรันแอปพลิเคชัน:

1. **เริ่มต้น**: Spring Boot เริ่มต้นและอ่าน `application.properties`
2. **การสร้างบริการ**: Spring สร้าง `FoundryLocalService` และฉีดค่าการตั้งค่า
3. **การตั้งค่าไคลเอนต์**: `@PostConstruct` เริ่มต้นไคลเอนต์ OpenAI เพื่อเชื่อมต่อกับ Foundry Local
4. **การรันเดโม**: `CommandLineRunner` รันหลังจากเริ่มต้น
5. **การเรียก AI**: เดโมเรียก `foundryLocalService.chat()` พร้อมข้อความทดสอบ
6. **คำขอ API**: บริการสร้างและส่งคำขอที่เข้ากันได้กับ OpenAI ไปยัง Foundry Local
7. **การประมวลผลผลลัพธ์**: บริการดึงและส่งคืนผลลัพธ์ของ AI
8. **การแสดงผล**: แอปพลิเคชันพิมพ์ผลลัพธ์และออกจากระบบ

## การตั้งค่า Foundry Local

เพื่อการตั้งค่า Foundry Local ให้ทำตามขั้นตอนเหล่านี้:

1. **ติดตั้ง Foundry Local** โดยใช้คำแนะนำในส่วน [ข้อกำหนดเบื้องต้น](../../../../04-PracticalSamples/foundrylocal)

2. **ตรวจสอบพอร์ตที่กำหนดแบบไดนามิก** Foundry Local กำหนดพอร์ตโดยอัตโนมัติเมื่อเริ่มต้น ค้นหาพอร์ตของคุณด้วย:
   ```bash
   foundry service status
   ```
   
   **ตัวเลือก**: หากคุณต้องการใช้พอร์ตเฉพาะ (เช่น 5273) คุณสามารถตั้งค่าด้วยตนเอง:
   ```bash
   foundry service set --port 5273
   ```

3. **ดาวน์โหลดโมเดล AI** ที่คุณต้องการใช้ เช่น `phi-3.5-mini` ด้วยคำสั่งต่อไปนี้:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **ตั้งค่าไฟล์ application.properties** ให้ตรงกับการตั้งค่า Foundry Local ของคุณ:
   - อัปเดตพอร์ตใน `base-url` (จากขั้นตอนที่ 2) โดยตรวจสอบให้แน่ใจว่ามี `/v1` ที่ท้าย
   - อัปเดตชื่อโมเดลให้รวมหมายเลขเวอร์ชัน (ตรวจสอบด้วย `foundry model list`)
   
   ตัวอย่าง:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```

## การรันแอปพลิเคชัน

### ขั้นตอนที่ 1: เริ่มต้น Foundry Local
```bash
foundry model run phi-3.5-mini
```

### ขั้นตอนที่ 2: สร้างและรันแอปพลิเคชัน
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
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```

## ขั้นตอนถัดไป

สำหรับตัวอย่างเพิ่มเติม ดู [Chapter 04: Practical samples](../README.md)

## การแก้ไขปัญหา

### ปัญหาทั่วไป

**"Connection refused" หรือ "Service unavailable"**
- ตรวจสอบให้แน่ใจว่า Foundry Local กำลังทำงาน: `foundry model list`
- ตรวจสอบพอร์ตจริงที่ Foundry Local กำลังใช้: `foundry service status`
- อัปเดต `application.properties` ของคุณด้วยพอร์ตที่ถูกต้อง โดยตรวจสอบให้แน่ใจว่า URL ลงท้ายด้วย `/v1`
- หรือ ตั้งค่าพอร์ตเฉพาะหากต้องการ: `foundry service set --port 5273`
- ลองรีสตาร์ท Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" หรือ "404 Not Found"**
- ตรวจสอบโมเดลที่มีอยู่พร้อม ID ที่แน่นอน: `foundry model list`
- อัปเดตชื่อโมเดลใน `application.properties` ให้ตรงกับ ID รวมถึงหมายเลขเวอร์ชัน (เช่น `Phi-3.5-mini-instruct-cuda-gpu:1`)
- ตรวจสอบให้แน่ใจว่า `base-url` ลงท้ายด้วย `/v1`: `http://localhost:5273/v1`
- ดาวน์โหลดโมเดลหากจำเป็น: `foundry model run phi-3.5-mini`

**"400 Bad Request"**
- ตรวจสอบว่า URL พื้นฐานลงท้ายด้วย `/v1`: `http://localhost:5273/v1`
- ตรวจสอบว่า ID โมเดลตรงกับที่แสดงใน `foundry model list`
- ตรวจสอบให้แน่ใจว่าคุณใช้ `maxCompletionTokens()` ในโค้ดของคุณ (ไม่ใช่ `maxTokens()` ที่เลิกใช้แล้ว)

**ข้อผิดพลาดการคอมไพล์ Maven**
- ตรวจสอบ Java 21 หรือสูงกว่า: `java -version`
- ล้างและสร้างใหม่: `mvn clean compile`
- ตรวจสอบการเชื่อมต่ออินเทอร์เน็ตสำหรับการดาวน์โหลดการพึ่งพา

**แอปพลิเคชันเริ่มต้นแต่ไม่มีผลลัพธ์**
- ตรวจสอบว่า Foundry Local ตอบสนอง: เปิดเบราว์เซอร์ไปที่ `http://localhost:5273`
- ตรวจสอบบันทึกของแอปพลิเคชันสำหรับข้อความแสดงข้อผิดพลาดเฉพาะ
- ตรวจสอบว่าโมเดลโหลดเสร็จและพร้อมใช้งาน

---

**ข้อจำกัดความรับผิดชอบ**:  
เอกสารนี้ได้รับการแปลโดยใช้บริการแปลภาษา AI [Co-op Translator](https://github.com/Azure/co-op-translator) แม้ว่าเราจะพยายามให้การแปลมีความถูกต้อง แต่โปรดทราบว่าการแปลโดยอัตโนมัติอาจมีข้อผิดพลาดหรือความไม่ถูกต้อง เอกสารต้นฉบับในภาษาดั้งเดิมควรถือเป็นแหล่งข้อมูลที่เชื่อถือได้ สำหรับข้อมูลที่สำคัญ ขอแนะนำให้ใช้บริการแปลภาษามืออาชีพ เราไม่รับผิดชอบต่อความเข้าใจผิดหรือการตีความผิดที่เกิดจากการใช้การแปลนี้