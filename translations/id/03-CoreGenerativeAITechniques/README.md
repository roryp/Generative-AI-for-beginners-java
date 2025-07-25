<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T09:49:48+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "id"
}
-->
# Teknik Inti AI Generatif

>**Note**: Bab ini mencakup [**Tutorial**](./TUTORIAL.md) yang memberikan panduan langkah demi langkah melalui contoh-contoh.

## Apa yang Akan Anda Pelajari
Di bab ini, kita akan mempelajari 4 teknik inti AI generatif melalui contoh praktis:
- Penyelesaian LLM dan alur percakapan
- Pemanggilan fungsi
- Retrieval-Augmented Generation (RAG)
- Langkah-langkah keamanan AI yang bertanggung jawab

## Daftar Isi

- [Apa yang Akan Anda Pelajari](../../../03-CoreGenerativeAITechniques)
- [Prasyarat](../../../03-CoreGenerativeAITechniques)
- [Memulai](../../../03-CoreGenerativeAITechniques)
- [Ikhtisar Contoh](../../../03-CoreGenerativeAITechniques)
  - [1. Penyelesaian LLM dan Alur Percakapan](../../../03-CoreGenerativeAITechniques)
  - [2. Fungsi & Plugin dengan LLM](../../../03-CoreGenerativeAITechniques)
  - [3. Retrieval-Augmented Generation (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Demonstrasi Keamanan AI yang Bertanggung Jawab](../../../03-CoreGenerativeAITechniques)
- [Ringkasan](../../../03-CoreGenerativeAITechniques)
- [Langkah Selanjutnya](../../../03-CoreGenerativeAITechniques)

## Prasyarat

- Selesaikan pengaturan dari [Bab 2](../../../02-SetupDevEnvironment)

## Memulai

1. **Arahkan ke folder contoh**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```
2. **Atur lingkungan**:  
```bash
export GITHUB_TOKEN=your_token_here
```
3. **Kompilasi dan jalankan contoh**:  
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

## Ikhtisar Contoh

Contoh-contoh ini diatur dalam folder `examples/` dengan struktur berikut:

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

### 1. Penyelesaian LLM dan Alur Percakapan
**File**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Pelajari cara membangun AI percakapan dengan respons streaming dan pengelolaan riwayat percakapan.

Contoh ini mencakup:
- Penyelesaian teks sederhana dengan prompt sistem
- Percakapan multi-putaran dengan pengelolaan riwayat
- Sesi obrolan interaktif
- Konfigurasi parameter (temperature, max tokens)

### 2. Fungsi & Plugin dengan LLM
**File**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Perluas kemampuan AI dengan memberikan akses ke fungsi khusus dan API eksternal.

Contoh ini mencakup:
- Integrasi fungsi cuaca
- Implementasi fungsi kalkulator  
- Pemanggilan beberapa fungsi dalam satu percakapan
- Definisi fungsi dengan skema JSON

### 3. Retrieval-Augmented Generation (RAG)
**File**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Pelajari cara menggabungkan AI dengan dokumen dan sumber data Anda sendiri untuk respons yang akurat dan kontekstual.

Contoh ini mencakup:
- Menjawab pertanyaan berbasis dokumen dengan Azure OpenAI SDK
- Implementasi pola RAG dengan Model GitHub

**Penggunaan**: Ajukan pertanyaan tentang konten di `document.txt` dan dapatkan respons AI yang hanya berdasarkan konteks tersebut.

### 4. Demonstrasi Keamanan AI yang Bertanggung Jawab
**File**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Dapatkan gambaran tentang bagaimana langkah-langkah keamanan AI bekerja dengan menguji kemampuan penyaringan konten Model GitHub.

Contoh ini mencakup:
- Penyaringan konten untuk prompt yang berpotensi berbahaya
- Penanganan respons keamanan dalam aplikasi
- Kategori konten yang diblokir (kekerasan, ujaran kebencian, misinformasi)
- Penanganan kesalahan yang tepat untuk pelanggaran keamanan

> **Pelajari Lebih Lanjut**: Ini hanyalah pengenalan konsep AI yang bertanggung jawab. Untuk informasi lebih lanjut tentang etika, mitigasi bias, pertimbangan privasi, dan kerangka kerja AI yang bertanggung jawab, lihat [Bab 5: AI Generatif yang Bertanggung Jawab](../05-ResponsibleGenAI/README.md).

## Ringkasan

Di bab ini, kita telah mempelajari penyelesaian LLM dan alur percakapan, mengimplementasikan pemanggilan fungsi untuk meningkatkan kemampuan AI, membuat sistem Retrieval-Augmented Generation (RAG), dan mendemonstrasikan langkah-langkah keamanan AI yang bertanggung jawab.

> **NOTE**: Pelajari lebih dalam dengan [**Tutorial**](./TUTORIAL.md) yang disediakan.

## Langkah Selanjutnya

[Bab 4: Aplikasi & Proyek Praktis](../04-PracticalSamples/README.md)

**Penafian**:  
Dokumen ini telah diterjemahkan menggunakan layanan penerjemahan AI [Co-op Translator](https://github.com/Azure/co-op-translator). Meskipun kami berupaya untuk memberikan hasil yang akurat, harap disadari bahwa terjemahan otomatis mungkin mengandung kesalahan atau ketidakakuratan. Dokumen asli dalam bahasa aslinya harus dianggap sebagai sumber yang berwenang. Untuk informasi yang bersifat kritis, disarankan menggunakan jasa penerjemah manusia profesional. Kami tidak bertanggung jawab atas kesalahpahaman atau interpretasi yang keliru yang timbul dari penggunaan terjemahan ini.