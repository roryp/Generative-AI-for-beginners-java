<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T09:51:13+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "id"
}
-->
# Aplikasi Pet Story

>**Note**: Bab ini mencakup [**Tutorial**](./TUTORIAL.md) yang memandu Anda melalui contoh-contoh.

Sebuah aplikasi web Spring Boot yang menghasilkan deskripsi dan cerita berbasis AI untuk gambar hewan peliharaan yang diunggah menggunakan GitHub Models.

## Daftar Isi

- [Teknologi yang Digunakan](../../../../04-PracticalSamples/petstory)
- [Prasyarat](../../../../04-PracticalSamples/petstory)
- [Pengaturan & Instalasi](../../../../04-PracticalSamples/petstory)
- [Penggunaan](../../../../04-PracticalSamples/petstory)

## Teknologi yang Digunakan

- **Backend**: Spring Boot 3.5.3, Java 21
- **Integrasi AI**: OpenAI Java SDK dengan GitHub Models
- **Keamanan**: Spring Security
- **Frontend**: Template Thymeleaf dengan gaya Bootstrap
- **Alat Build**: Maven
- **Model AI**: GitHub Models

## Prasyarat

- Java 21 atau lebih tinggi
- Maven 3.9+
- GitHub Personal Access Token dengan cakupan `models:read`

## Pengaturan & Instalasi

### 1. Masuk ke direktori aplikasi petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Atur Variabel Lingkungan
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Bangun Aplikasi
```bash
mvn clean compile
```

### 4. Jalankan Aplikasi
```bash
mvn spring-boot:run
```

## Penggunaan

1. **Akses Aplikasi**: Buka `http://localhost:8080`
2. **Unggah Gambar**: Klik "Choose File" dan pilih gambar hewan peliharaan
3. **Analisis Gambar**: Klik "Analyze Image" untuk mendapatkan deskripsi AI
4. **Buat Cerita**: Klik "Generate Story" untuk membuat cerita

**Penafian**:  
Dokumen ini telah diterjemahkan menggunakan layanan penerjemahan AI [Co-op Translator](https://github.com/Azure/co-op-translator). Meskipun kami berusaha untuk memberikan hasil yang akurat, harap diingat bahwa terjemahan otomatis mungkin mengandung kesalahan atau ketidakakuratan. Dokumen asli dalam bahasa aslinya harus dianggap sebagai sumber yang otoritatif. Untuk informasi yang bersifat kritis, disarankan menggunakan jasa penerjemahan manusia profesional. Kami tidak bertanggung jawab atas kesalahpahaman atau penafsiran yang keliru yang timbul dari penggunaan terjemahan ini.