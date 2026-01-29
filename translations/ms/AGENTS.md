# AGENTS.md

## Gambaran Projek

Ini adalah repositori pendidikan untuk mempelajari pembangunan Generative AI dengan Java. Ia menyediakan kursus praktikal yang komprehensif meliputi Model Bahasa Besar (LLMs), kejuruteraan prompt, embeddings, RAG (Retrieval-Augmented Generation), dan Protokol Konteks Model (MCP).

**Teknologi Utama:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- Model GitHub, Azure OpenAI, dan SDK OpenAI

**Senibina:**
- Beberapa aplikasi Spring Boot berdiri sendiri yang diatur mengikut bab
- Projek contoh yang menunjukkan pelbagai corak AI
- Sedia untuk GitHub Codespaces dengan kontena pembangunan yang telah dikonfigurasi

## Perintah Persediaan

### Prasyarat
- Java 21 atau lebih tinggi
- Maven 3.x
- Token akses peribadi GitHub (untuk Model GitHub)
- Pilihan: Kredensial Azure OpenAI

### Persediaan Persekitaran

**Pilihan 1: GitHub Codespaces (Disyorkan)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Pilihan 2: Kontena Pembangunan Tempatan**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Pilihan 3: Persediaan Tempatan**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Konfigurasi

**Persediaan Token GitHub:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Persediaan Azure OpenAI (Pilihan):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Aliran Kerja Pembangunan

### Struktur Projek
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

### Menjalankan Aplikasi

**Menjalankan aplikasi Spring Boot:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Membina projek:**
```bash
cd [project-directory]
mvn clean install
```

**Memulakan Pelayan MCP Calculator:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Menjalankan Contoh Klien:**
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

### Muat Semula Panas
Spring Boot DevTools disertakan dalam projek yang menyokong muat semula panas:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Arahan Pengujian

### Menjalankan Ujian

**Jalankan semua ujian dalam projek:**
```bash
cd [project-directory]
mvn test
```

**Jalankan ujian dengan output terperinci:**
```bash
mvn test -X
```

**Jalankan kelas ujian tertentu:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Struktur Ujian
- Fail ujian menggunakan JUnit 5 (Jupiter)
- Kelas ujian terletak di `src/test/java/`
- Contoh klien dalam projek kalkulator berada di `src/test/java/com/microsoft/mcp/sample/client/`

### Pengujian Manual
Banyak contoh adalah aplikasi interaktif yang memerlukan pengujian manual:

1. Mulakan aplikasi dengan `mvn spring-boot:run`
2. Uji endpoint atau berinteraksi dengan CLI
3. Pastikan tingkah laku yang dijangka sepadan dengan dokumentasi dalam README.md setiap projek

### Pengujian dengan Model GitHub
- Had percuma: 15 permintaan/minit, 150/hari
- Maksimum 5 permintaan serentak
- Uji penapisan kandungan dengan contoh AI yang bertanggungjawab

## Garis Panduan Gaya Kod

### Konvensyen Java
- **Versi Java:** Java 21 dengan ciri moden
- **Gaya:** Ikuti konvensyen Java standard
- **Penamaan:** 
  - Kelas: PascalCase
  - Kaedah/pembolehubah: camelCase
  - Konstanta: UPPER_SNAKE_CASE
  - Nama pakej: huruf kecil

### Corak Spring Boot
- Gunakan `@Service` untuk logik perniagaan
- Gunakan `@RestController` untuk endpoint REST
- Konfigurasi melalui `application.yml` atau `application.properties`
- Pembolehubah persekitaran lebih disukai daripada nilai yang ditetapkan
- Gunakan anotasi `@Tool` untuk kaedah yang didedahkan MCP

### Organisasi Fail
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

### Kebergantungan
- Diuruskan melalui Maven `pom.xml`
- Spring AI BOM untuk pengurusan versi
- LangChain4j untuk integrasi AI
- Starter parent Spring Boot untuk kebergantungan Spring

### Komen Kod
- Tambahkan JavaDoc untuk API awam
- Sertakan komen penjelasan untuk interaksi AI yang kompleks
- Dokumentasikan penerangan alat MCP dengan jelas

## Pembinaan dan Penghantaran

### Membina Projek

**Bina tanpa ujian:**
```bash
mvn clean install -DskipTests
```

**Bina dengan semua semakan:**
```bash
mvn clean install
```

**Pakej aplikasi:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Direktori Output
- Kelas yang telah dikompilasi: `target/classes/`
- Kelas ujian: `target/test-classes/`
- Fail JAR: `target/*.jar`
- Artifak Maven: `target/`

### Konfigurasi Khusus Persekitaran

**Pembangunan:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Pengeluaran:**
- Gunakan Model AI Foundry Azure dan bukannya Model GitHub
- Kemas kini base-url ke endpoint Azure OpenAI
- Urus rahsia melalui Azure Key Vault atau pembolehubah persekitaran

### Pertimbangan Penghantaran
- Ini adalah repositori pendidikan dengan aplikasi contoh
- Tidak direka untuk penghantaran pengeluaran seperti sedia ada
- Contoh menunjukkan corak untuk disesuaikan bagi penggunaan pengeluaran
- Lihat README projek individu untuk nota penghantaran khusus

## Nota Tambahan

### Model GitHub vs Azure OpenAI
- **Model GitHub:** Tingkat percuma untuk pembelajaran, tidak memerlukan kad kredit
- **Azure OpenAI:** Sedia untuk pengeluaran, memerlukan langganan Azure
- Kod serasi antara kedua-duanya - hanya tukar endpoint dan kunci API

### Bekerja dengan Pelbagai Projek
Setiap projek contoh adalah berdiri sendiri:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Masalah Biasa

**Ketidakpadanan Versi Java:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Masalah Muat Turun Kebergantungan:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**Token GitHub Tidak Ditemui:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Port Sudah Digunakan:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Sokongan Pelbagai Bahasa
- Dokumentasi tersedia dalam lebih 45 bahasa melalui terjemahan automatik
- Terjemahan dalam direktori `translations/`
- Terjemahan diuruskan oleh aliran kerja GitHub Actions

### Laluan Pembelajaran
1. Mulakan dengan [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Ikuti bab mengikut urutan (01 → 05)
3. Lengkapkan contoh praktikal dalam setiap bab
4. Terokai projek contoh dalam Bab 4
5. Pelajari amalan AI yang bertanggungjawab dalam Bab 5

### Kontena Pembangunan
Konfigurasi `.devcontainer/devcontainer.json` termasuk:
- Persekitaran pembangunan Java 21
- Maven telah dipasang
- Sambungan Java VS Code
- Alat Spring Boot
- Integrasi GitHub Copilot
- Sokongan Docker-in-Docker
- CLI Azure

### Pertimbangan Prestasi
- Tingkat percuma Model GitHub mempunyai had kadar
- Gunakan saiz batch yang sesuai untuk embeddings
- Pertimbangkan caching untuk panggilan API berulang
- Pantau penggunaan token untuk pengoptimuman kos

### Nota Keselamatan
- Jangan sekali-kali komit fail `.env` (sudah dalam `.gitignore`)
- Gunakan pembolehubah persekitaran untuk kunci API
- Token GitHub harus mempunyai skop minimum yang diperlukan
- Ikuti garis panduan AI yang bertanggungjawab dalam Bab 5

---

**Penafian**:  
Dokumen ini telah diterjemahkan menggunakan perkhidmatan terjemahan AI [Co-op Translator](https://github.com/Azure/co-op-translator). Walaupun kami berusaha untuk memastikan ketepatan, sila ambil perhatian bahawa terjemahan automatik mungkin mengandungi kesilapan atau ketidaktepatan. Dokumen asal dalam bahasa asalnya harus dianggap sebagai sumber yang berwibawa. Untuk maklumat yang kritikal, terjemahan manusia profesional adalah disyorkan. Kami tidak bertanggungjawab atas sebarang salah faham atau salah tafsir yang timbul daripada penggunaan terjemahan ini.