<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T20:07:26+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "ms"
}
-->
# Aplikasi Pet Story

>**Nota**: Bab ini merangkumi [**Tutorial**](./TUTORIAL.md) yang membimbing anda menjalankan sampel siap.

Sebuah aplikasi web Spring Boot yang menghasilkan deskripsi dan cerita berasaskan AI untuk imej haiwan peliharaan yang dimuat naik menggunakan GitHub Models.

## Kandungan

- [Teknologi Digunakan](../../../../04-PracticalSamples/petstory)
- [Keperluan Awal](../../../../04-PracticalSamples/petstory)
- [Persediaan & Pemasangan](../../../../04-PracticalSamples/petstory)
- [Cara Penggunaan](../../../../04-PracticalSamples/petstory)

## Teknologi Digunakan

- **Backend**: Spring Boot 3.5.3, Java 21
- **Integrasi AI**: OpenAI Java SDK dengan GitHub Models
- **Keselamatan**: Spring Security
- **Frontend**: Template Thymeleaf dengan gaya Bootstrap
- **Alat Binaan**: Maven
- **Model AI**: GitHub Models

## Keperluan Awal

- Java 21 atau lebih tinggi
- Maven 3.9+
- Token Akses Peribadi GitHub dengan skop `models:read`

## Persediaan & Pemasangan

### 1. Pergi ke direktori aplikasi petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Tetapkan Pembolehubah Persekitaran
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Bina Aplikasi
```bash
mvn clean compile
```

### 4. Jalankan Aplikasi
```bash
mvn spring-boot:run
```

## Cara Penggunaan

1. **Akses Aplikasi**: Pergi ke `http://localhost:8080`
2. **Muat Naik Imej**: Klik "Choose File" dan pilih imej haiwan peliharaan
3. **Analisis Imej**: Klik "Analyze Image" untuk mendapatkan deskripsi AI
4. **Hasilkan Cerita**: Klik "Generate Story" untuk mencipta cerita

**Penafian**:  
Dokumen ini telah diterjemahkan menggunakan perkhidmatan terjemahan AI [Co-op Translator](https://github.com/Azure/co-op-translator). Walaupun kami berusaha untuk memastikan ketepatan, sila ambil perhatian bahawa terjemahan automatik mungkin mengandungi kesilapan atau ketidaktepatan. Dokumen asal dalam bahasa asalnya harus dianggap sebagai sumber yang berwibawa. Untuk maklumat yang kritikal, terjemahan manusia profesional adalah disyorkan. Kami tidak bertanggungjawab atas sebarang salah faham atau salah tafsir yang timbul daripada penggunaan terjemahan ini.