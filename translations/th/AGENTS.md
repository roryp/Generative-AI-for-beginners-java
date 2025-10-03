<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:36:46+00:00",
  "source_file": "AGENTS.md",
  "language_code": "th"
}
-->
# AGENTS.md

## ภาพรวมของโปรเจกต์

นี่คือคลังข้อมูลเพื่อการศึกษาเกี่ยวกับการพัฒนา Generative AI ด้วย Java โดยมีคอร์สแบบลงมือทำที่ครอบคลุม Large Language Models (LLMs), การออกแบบคำสั่ง (prompt engineering), embeddings, RAG (Retrieval-Augmented Generation) และ Model Context Protocol (MCP)

**เทคโนโลยีหลัก:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI และ OpenAI SDKs

**สถาปัตยกรรม:**
- แอปพลิเคชัน Spring Boot แบบแยกส่วนที่จัดเรียงตามบท
- โปรเจกต์ตัวอย่างที่แสดงรูปแบบ AI ต่างๆ
- พร้อมใช้งานกับ GitHub Codespaces โดยมี dev containers ที่ตั้งค่าไว้ล่วงหน้า

## คำสั่งการตั้งค่า

### ข้อกำหนดเบื้องต้น
- Java 21 หรือสูงกว่า
- Maven 3.x
- GitHub personal access token (สำหรับ GitHub Models)
- ตัวเลือกเพิ่มเติม: ข้อมูลรับรอง Azure OpenAI

### การตั้งค่าสภาพแวดล้อม

**ตัวเลือกที่ 1: GitHub Codespaces (แนะนำ)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**ตัวเลือกที่ 2: Local Dev Container**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**ตัวเลือกที่ 3: Local Setup**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### การตั้งค่าคอนฟิก

**การตั้งค่า GitHub Token:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**การตั้งค่า Azure OpenAI (ตัวเลือกเพิ่มเติม):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## เวิร์กโฟลว์การพัฒนา

### โครงสร้างโปรเจกต์
```
/
├── 01-IntroToGenAI/              # Chapter 1: Introduction
├── 02-SetupDevEnvironment/       # Chapter 2: Environment setup
│   └── examples/                 # Working examples
├── 03-CoreGenerativeAITechniques/ # Chapter 3: Core techniques
├── 04-PracticalSamples/          # Chapter 4: Sample projects
│   ├── calculator/               # MCP service example
│   ├── foundrylocal/            # Local model integration
│   └── petstory/                # Multi-modal app
├── 05-ResponsibleGenAI/         # Chapter 5: Responsible AI
└── translations/                # Multi-language support
```

### การรันแอปพลิเคชัน

**การรันแอปพลิเคชัน Spring Boot:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**การสร้างโปรเจกต์:**
```bash
cd [project-directory]
mvn clean install
```

**การเริ่มต้น MCP Calculator Server:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**การรันตัวอย่าง Client:**
```bash
# After starting the server in another terminal
cd 04-PracticalSamples/calculator

# Direct MCP client
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"

# AI-powered client (requires GITHUB_TOKEN)
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"

# Interactive bot
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.Bot"
```

### Hot Reload
Spring Boot DevTools รวมอยู่ในโปรเจกต์ที่รองรับการโหลดใหม่:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## คำแนะนำการทดสอบ

### การรันการทดสอบ

**รันการทดสอบทั้งหมดในโปรเจกต์:**
```bash
cd [project-directory]
mvn test
```

**รันการทดสอบพร้อมผลลัพธ์แบบละเอียด:**
```bash
mvn test -X
```

**รันคลาสการทดสอบเฉพาะ:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### โครงสร้างการทดสอบ
- ไฟล์การทดสอบใช้ JUnit 5 (Jupiter)
- คลาสการทดสอบอยู่ใน `src/test/java/`
- ตัวอย่าง Client ในโปรเจกต์ calculator อยู่ใน `src/test/java/com/microsoft/mcp/sample/client/`

### การทดสอบแบบ Manual
ตัวอย่างหลายตัวเป็นแอปพลิเคชันแบบโต้ตอบที่ต้องการการทดสอบแบบ Manual:

1. เริ่มต้นแอปพลิเคชันด้วย `mvn spring-boot:run`
2. ทดสอบ endpoints หรือโต้ตอบกับ CLI
3. ตรวจสอบว่าพฤติกรรมที่คาดหวังตรงกับเอกสารใน README.md ของแต่ละโปรเจกต์

### การทดสอบกับ GitHub Models
- ข้อจำกัดของ Free tier: 15 คำขอต่อ/นาที, 150 ต่อวัน
- สูงสุด 5 คำขอพร้อมกัน
- ทดสอบการกรองเนื้อหาด้วยตัวอย่าง AI ที่รับผิดชอบ

## แนวทางการเขียนโค้ด

### ข้อกำหนด Java
- **เวอร์ชัน Java:** Java 21 พร้อมฟีเจอร์สมัยใหม่
- **รูปแบบ:** ปฏิบัติตามข้อกำหนดมาตรฐานของ Java
- **การตั้งชื่อ:** 
  - คลาส: PascalCase
  - เมธอด/ตัวแปร: camelCase
  - ค่าคงที่: UPPER_SNAKE_CASE
  - ชื่อแพ็กเกจ: ตัวพิมพ์เล็กทั้งหมด

### รูปแบบ Spring Boot
- ใช้ `@Service` สำหรับตรรกะทางธุรกิจ
- ใช้ `@RestController` สำหรับ REST endpoints
- การตั้งค่าผ่าน `application.yml` หรือ `application.properties`
- ตัวแปรสภาพแวดล้อมควรใช้แทนค่าที่กำหนดไว้ในโค้ด
- ใช้ `@Tool` annotation สำหรับเมธอดที่เปิดเผยผ่าน MCP

### การจัดระเบียบไฟล์
```
src/
├── main/
│   ├── java/
│   │   └── com/microsoft/[component]/
│   │       ├── [Component]Application.java
│   │       ├── config/
│   │       ├── controller/
│   │       ├── service/
│   │       └── exception/
│   └── resources/
│       ├── application.yml
│       └── static/
└── test/
    └── java/
        └── com/microsoft/[component]/
```

### การจัดการ Dependencies
- จัดการผ่าน Maven `pom.xml`
- Spring AI BOM สำหรับการจัดการเวอร์ชัน
- LangChain4j สำหรับการผสานรวม AI
- Spring Boot starter parent สำหรับ dependencies ของ Spring

### คอมเมนต์ในโค้ด
- เพิ่ม JavaDoc สำหรับ public APIs
- รวมคอมเมนต์อธิบายสำหรับการโต้ตอบ AI ที่ซับซ้อน
- เอกสารคำอธิบายเครื่องมือ MCP อย่างชัดเจน

## การสร้างและการปรับใช้

### การสร้างโปรเจกต์

**สร้างโดยไม่รันการทดสอบ:**
```bash
mvn clean install -DskipTests
```

**สร้างพร้อมการตรวจสอบทั้งหมด:**
```bash
mvn clean install
```

**แพ็กเกจแอปพลิเคชัน:**
```bash
mvn package
# Creates JAR in target/ directory
```

### ไดเรกทอรีผลลัพธ์
- คลาสที่คอมไพล์แล้ว: `target/classes/`
- คลาสการทดสอบ: `target/test-classes/`
- ไฟล์ JAR: `target/*.jar`
- อาร์ติแฟกต์ Maven: `target/`

### การตั้งค่าคอนฟิกเฉพาะสภาพแวดล้อม

**Development:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Production:**
- ใช้ Azure AI Foundry Models แทน GitHub Models
- อัปเดต base-url เป็น endpoint ของ Azure OpenAI
- จัดการ secrets ผ่าน Azure Key Vault หรือ environment variables

### ข้อควรพิจารณาในการปรับใช้
- นี่คือคลังข้อมูลเพื่อการศึกษาพร้อมแอปพลิเคชันตัวอย่าง
- ไม่ได้ออกแบบมาเพื่อการปรับใช้ใน production โดยตรง
- ตัวอย่างแสดงรูปแบบที่สามารถปรับใช้ใน production
- ดู README ของโปรเจกต์แต่ละตัวสำหรับหมายเหตุการปรับใช้เฉพาะ

## หมายเหตุเพิ่มเติม

### GitHub Models vs Azure OpenAI
- **GitHub Models:** Free tier สำหรับการเรียนรู้ ไม่ต้องใช้บัตรเครดิต
- **Azure OpenAI:** พร้อมใช้งานใน production ต้องการการสมัครสมาชิก Azure
- โค้ดสามารถใช้งานร่วมกันได้ระหว่างทั้งสอง - เพียงเปลี่ยน endpoint และ API key

### การทำงานกับโปรเจกต์หลายตัว
แต่ละโปรเจกต์ตัวอย่างเป็นแบบ standalone:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### ปัญหาทั่วไป

**Java Version ไม่ตรงกัน:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**ปัญหาการดาวน์โหลด Dependency:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub Token ไม่พบ:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**พอร์ตถูกใช้งานแล้ว:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### การรองรับหลายภาษา
- เอกสารมีให้บริการในกว่า 45 ภาษา ผ่านการแปลอัตโนมัติ
- การแปลอยู่ในไดเรกทอรี `translations/`
- การแปลจัดการโดย GitHub Actions workflow

### เส้นทางการเรียนรู้
1. เริ่มต้นที่ [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. ทำตามบทต่างๆ ตามลำดับ (01 → 05)
3. ทำตัวอย่างแบบลงมือทำในแต่ละบทให้เสร็จสมบูรณ์
4. สำรวจโปรเจกต์ตัวอย่างในบทที่ 4
5. เรียนรู้แนวปฏิบัติ AI ที่รับผิดชอบในบทที่ 5

### Development Container
ไฟล์ `.devcontainer/devcontainer.json` ตั้งค่า:
- สภาพแวดล้อมการพัฒนา Java 21
- ติดตั้ง Maven ล่วงหน้า
- ส่วนขยาย Java สำหรับ VS Code
- เครื่องมือ Spring Boot
- การผสานรวม GitHub Copilot
- รองรับ Docker-in-Docker
- Azure CLI

### ข้อควรพิจารณาด้านประสิทธิภาพ
- Free tier ของ GitHub Models มีข้อจำกัดด้านอัตรา
- ใช้ขนาด batch ที่เหมาะสมสำหรับ embeddings
- พิจารณาการแคชสำหรับการเรียก API ซ้ำ
- ตรวจสอบการใช้งาน token เพื่อเพิ่มประสิทธิภาพต้นทุน

### หมายเหตุด้านความปลอดภัย
- ห้าม commit ไฟล์ `.env` (อยู่ใน `.gitignore` แล้ว)
- ใช้ environment variables สำหรับ API keys
- GitHub tokens ควรมี scope ที่จำเป็นน้อยที่สุด
- ปฏิบัติตามแนวทาง AI ที่รับผิดชอบในบทที่ 5

---

**ข้อจำกัดความรับผิดชอบ**:  
เอกสารนี้ได้รับการแปลโดยใช้บริการแปลภาษา AI [Co-op Translator](https://github.com/Azure/co-op-translator) แม้ว่าเราจะพยายามให้การแปลมีความถูกต้อง แต่โปรดทราบว่าการแปลอัตโนมัติอาจมีข้อผิดพลาดหรือความไม่ถูกต้อง เอกสารต้นฉบับในภาษาดั้งเดิมควรถือเป็นแหล่งข้อมูลที่เชื่อถือได้ สำหรับข้อมูลที่สำคัญ ขอแนะนำให้ใช้บริการแปลภาษามนุษย์ที่มีความเชี่ยวชาญ เราไม่รับผิดชอบต่อความเข้าใจผิดหรือการตีความผิดที่เกิดจากการใช้การแปลนี้