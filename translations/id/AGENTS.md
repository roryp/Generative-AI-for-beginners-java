# AGENTS.md

## Gambaran Proyek

Ini adalah repositori edukasi untuk mempelajari pengembangan Generative AI dengan Java. Proyek ini menyediakan kursus praktis yang komprehensif mencakup Large Language Models (LLMs), rekayasa prompt, embeddings, RAG (Retrieval-Augmented Generation), dan Model Context Protocol (MCP).

**Teknologi Utama:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- Model GitHub, Azure OpenAI, dan SDK OpenAI

**Arsitektur:**
- Beberapa aplikasi Spring Boot mandiri yang diorganisasi berdasarkan bab
- Proyek contoh yang menunjukkan berbagai pola AI
- Siap digunakan di GitHub Codespaces dengan kontainer pengembangan yang telah dikonfigurasi sebelumnya

## Perintah Pengaturan

### Prasyarat
- Java 21 atau lebih tinggi
- Maven 3.x
- Token akses pribadi GitHub (untuk Model GitHub)
- Opsional: Kredensial Azure OpenAI

### Pengaturan Lingkungan

**Opsi 1: GitHub Codespaces (Direkomendasikan)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Opsi 2: Kontainer Pengembangan Lokal**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Opsi 3: Pengaturan Lokal**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Konfigurasi

**Pengaturan Token GitHub:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Pengaturan Azure OpenAI (Opsional):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Alur Kerja Pengembangan

### Struktur Proyek
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

**Membangun proyek:**
```bash
cd [project-directory]
mvn clean install
```

**Memulai Server MCP Calculator:**
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

### Hot Reload
Spring Boot DevTools disertakan dalam proyek yang mendukung hot reload:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Instruksi Pengujian

### Menjalankan Pengujian

**Menjalankan semua pengujian dalam proyek:**
```bash
cd [project-directory]
mvn test
```

**Menjalankan pengujian dengan output yang lebih rinci:**
```bash
mvn test -X
```

**Menjalankan kelas pengujian tertentu:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Struktur Pengujian
- File pengujian menggunakan JUnit 5 (Jupiter)
- Kelas pengujian terletak di `src/test/java/`
- Contoh klien dalam proyek kalkulator berada di `src/test/java/com/microsoft/mcp/sample/client/`

### Pengujian Manual
Banyak contoh adalah aplikasi interaktif yang memerlukan pengujian manual:

1. Jalankan aplikasi dengan `mvn spring-boot:run`
2. Uji endpoint atau berinteraksi dengan CLI
3. Verifikasi bahwa perilaku yang diharapkan sesuai dengan dokumentasi di README.md setiap proyek

### Pengujian dengan Model GitHub
- Batasan tier gratis: 15 permintaan/menit, 150/hari
- Maksimum 5 permintaan bersamaan
- Uji penyaringan konten dengan contoh AI yang bertanggung jawab

## Panduan Gaya Kode

### Konvensi Java
- **Versi Java:** Java 21 dengan fitur modern
- **Gaya:** Ikuti konvensi Java standar
- **Penamaan:** 
  - Kelas: PascalCase
  - Metode/variabel: camelCase
  - Konstanta: UPPER_SNAKE_CASE
  - Nama paket: huruf kecil

### Pola Spring Boot
- Gunakan `@Service` untuk logika bisnis
- Gunakan `@RestController` untuk endpoint REST
- Konfigurasi melalui `application.yml` atau `application.properties`
- Variabel lingkungan lebih disukai daripada nilai yang dikodekan langsung
- Gunakan anotasi `@Tool` untuk metode yang diekspos MCP

### Organisasi File
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

### Dependensi
- Dikelola melalui Maven `pom.xml`
- Spring AI BOM untuk manajemen versi
- LangChain4j untuk integrasi AI
- Spring Boot starter parent untuk dependensi Spring

### Komentar Kode
- Tambahkan JavaDoc untuk API publik
- Sertakan komentar penjelasan untuk interaksi AI yang kompleks
- Dokumentasikan deskripsi alat MCP dengan jelas

## Pembangunan dan Penerapan

### Membangun Proyek

**Membangun tanpa pengujian:**
```bash
mvn clean install -DskipTests
```

**Membangun dengan semua pemeriksaan:**
```bash
mvn clean install
```

**Mengemas aplikasi:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Direktori Output
- Kelas yang dikompilasi: `target/classes/`
- Kelas pengujian: `target/test-classes/`
- File JAR: `target/*.jar`
- Artefak Maven: `target/`

### Konfigurasi Spesifik Lingkungan

**Pengembangan:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Produksi:**
- Gunakan Model Azure AI Foundry daripada Model GitHub
- Perbarui base-url ke endpoint Azure OpenAI
- Kelola rahasia melalui Azure Key Vault atau variabel lingkungan

### Pertimbangan Penerapan
- Ini adalah repositori edukasi dengan aplikasi contoh
- Tidak dirancang untuk penerapan produksi sebagaimana adanya
- Contoh menunjukkan pola yang dapat disesuaikan untuk penggunaan produksi
- Lihat README proyek individu untuk catatan penerapan spesifik

## Catatan Tambahan

### Model GitHub vs Azure OpenAI
- **Model GitHub:** Tier gratis untuk pembelajaran, tidak memerlukan kartu kredit
- **Azure OpenAI:** Siap produksi, memerlukan langganan Azure
- Kode kompatibel di antara keduanya - cukup ubah endpoint dan kunci API

### Bekerja dengan Banyak Proyek
Setiap proyek contoh bersifat mandiri:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Masalah Umum

**Ketidaksesuaian Versi Java:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Masalah Unduhan Dependensi:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**Token GitHub Tidak Ditemukan:**
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

### Dukungan Multi-Bahasa
- Dokumentasi tersedia dalam lebih dari 45 bahasa melalui terjemahan otomatis
- Terjemahan berada di direktori `translations/`
- Terjemahan dikelola oleh alur kerja GitHub Actions

### Jalur Pembelajaran
1. Mulai dengan [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Ikuti bab secara berurutan (01 → 05)
3. Selesaikan contoh praktis di setiap bab
4. Jelajahi proyek contoh di Bab 4
5. Pelajari praktik AI yang bertanggung jawab di Bab 5

### Kontainer Pengembangan
Konfigurasi `.devcontainer/devcontainer.json` mencakup:
- Lingkungan pengembangan Java 21
- Maven yang telah diinstal sebelumnya
- Ekstensi Java untuk VS Code
- Alat Spring Boot
- Integrasi GitHub Copilot
- Dukungan Docker-in-Docker
- Azure CLI

### Pertimbangan Performa
- Tier gratis Model GitHub memiliki batasan tingkat
- Gunakan ukuran batch yang sesuai untuk embeddings
- Pertimbangkan caching untuk panggilan API berulang
- Pantau penggunaan token untuk optimasi biaya

### Catatan Keamanan
- Jangan pernah mengkomit file `.env` (sudah ada di `.gitignore`)
- Gunakan variabel lingkungan untuk kunci API
- Token GitHub harus memiliki cakupan minimal yang diperlukan
- Ikuti panduan AI yang bertanggung jawab di Bab 5

---

**Penafian**:  
Dokumen ini telah diterjemahkan menggunakan layanan penerjemahan AI [Co-op Translator](https://github.com/Azure/co-op-translator). Meskipun kami berupaya untuk memberikan hasil yang akurat, harap diketahui bahwa terjemahan otomatis mungkin mengandung kesalahan atau ketidakakuratan. Dokumen asli dalam bahasa aslinya harus dianggap sebagai sumber yang otoritatif. Untuk informasi yang bersifat kritis, disarankan menggunakan jasa penerjemahan manusia profesional. Kami tidak bertanggung jawab atas kesalahpahaman atau penafsiran yang keliru yang timbul dari penggunaan terjemahan ini.