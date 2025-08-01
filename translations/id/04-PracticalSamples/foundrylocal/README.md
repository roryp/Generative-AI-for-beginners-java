<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T19:50:08+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "id"
}
-->
# Aplikasi Command-Line Lokal Foundry

>**Catatan**: Bab ini mencakup [**Tutorial**](./TUTORIAL.md) yang membimbing Anda menjalankan sampel yang telah selesai.

Aplikasi command-line Spring Boot sederhana yang menunjukkan cara menghubungkan ke Foundry Local menggunakan OpenAI Java SDK.

## Apa yang Akan Anda Pelajari

- Cara mengintegrasikan Foundry Local dengan aplikasi Spring Boot menggunakan OpenAI Java SDK
- Praktik terbaik untuk pengembangan dan pengujian AI lokal

## Daftar Isi

- [Apa yang Akan Anda Pelajari](../../../../04-PracticalSamples/foundrylocal)
- [Prasyarat](../../../../04-PracticalSamples/foundrylocal)
  - [Menginstal Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Verifikasi](../../../../04-PracticalSamples/foundrylocal)
- [Konfigurasi](../../../../04-PracticalSamples/foundrylocal)
- [Memulai Cepat](../../../../04-PracticalSamples/foundrylocal)
- [Apa yang Dilakukan Aplikasi](../../../../04-PracticalSamples/foundrylocal)
- [Output Contoh](../../../../04-PracticalSamples/foundrylocal)
- [Arsitektur](../../../../04-PracticalSamples/foundrylocal)
- [Sorotan Kode](../../../../04-PracticalSamples/foundrylocal)
  - [Integrasi OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [API Penyelesaian Chat](../../../../04-PracticalSamples/foundrylocal)
- [Pemecahan Masalah](../../../../04-PracticalSamples/foundrylocal)

## Prasyarat

> **⚠️ Catatan**: Aplikasi ini **tidak berjalan di devcontainer yang disediakan** karena memerlukan Foundry Local untuk diinstal dan dijalankan di sistem host.

### Menginstal Foundry Local

Sebelum menjalankan aplikasi ini, Anda perlu menginstal dan memulai Foundry Local. Ikuti langkah-langkah berikut:

1. **Pastikan sistem Anda memenuhi persyaratan**:
   - **Sistem Operasi**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, atau macOS
   - **Perangkat Keras**: 
     - Minimum: RAM 8GB, ruang disk kosong 3GB
     - Direkomendasikan: RAM 16GB, ruang disk kosong 15GB
   - **Jaringan**: Koneksi internet untuk mengunduh model awal (opsional untuk penggunaan offline)
   - **Akselerasi (opsional)**: GPU NVIDIA (seri 2.000 atau lebih baru), GPU AMD (seri 6.000 atau lebih baru), Qualcomm Snapdragon X Elite (memori 8GB atau lebih), atau Apple silicon
   - **Izin**: Hak administratif untuk menginstal perangkat lunak di perangkat Anda

2. **Instal Foundry Local**:
   
   **Untuk Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **Untuk macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Sebagai alternatif, Anda dapat mengunduh penginstal dari [repositori GitHub Foundry Local](https://github.com/microsoft/Foundry-Local).

3. **Mulai model pertama Anda**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Model akan diunduh (yang dapat memakan waktu beberapa menit, tergantung pada kecepatan internet Anda) dan kemudian dijalankan. Foundry Local secara otomatis memilih varian model terbaik untuk sistem Anda (CUDA untuk GPU NVIDIA, versi CPU jika tidak ada).

4. **Uji model** dengan mengajukan pertanyaan di terminal yang sama:

   ```bash
   Why is the sky blue?
   ```

   Anda akan melihat respons dari model Phi yang menjelaskan mengapa langit tampak biru.

### Verifikasi

Anda dapat memverifikasi semuanya berfungsi dengan baik menggunakan perintah berikut:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Anda juga dapat mengunjungi `http://localhost:5273` di browser Anda untuk melihat antarmuka web Foundry Local.

## Konfigurasi

Aplikasi dapat dikonfigurasi melalui `application.properties`:

- `foundry.local.base-url` - URL dasar untuk Foundry Local (default: http://localhost:5273)
- `foundry.local.model` - Model AI yang digunakan (default: Phi-3.5-mini-instruct-cuda-gpu)

> **Catatan**: Nama model dalam konfigurasi harus sesuai dengan varian spesifik yang diunduh Foundry Local untuk sistem Anda. Saat Anda menjalankan `foundry model run phi-3.5-mini`, Foundry Local secara otomatis memilih dan mengunduh varian terbaik (CUDA untuk GPU NVIDIA, versi CPU jika tidak ada). Gunakan `foundry model list` untuk melihat nama model yang tersedia di instance lokal Anda.

## Memulai Cepat

### 1. Navigasikan ke direktori aplikasi Foundry Local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Jalankan Aplikasi

```bash
mvn spring-boot:run
```

Atau bangun dan jalankan JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Dependensi

Aplikasi ini menggunakan OpenAI Java SDK untuk berkomunikasi dengan Foundry Local. Dependensi utama adalah:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Aplikasi telah dikonfigurasi sebelumnya untuk terhubung ke Foundry Local yang berjalan di port default.

## Apa yang Dilakukan Aplikasi

Saat Anda menjalankan aplikasi:

1. **Memulai** sebagai aplikasi command-line (tanpa server web)
2. **Secara otomatis mengirimkan** pesan uji: "Halo! Bisakah Anda memberi tahu saya apa Anda dan model apa yang Anda jalankan?"
3. **Menampilkan respons** dari Foundry Local di konsol
4. **Keluar dengan bersih** setelah demo selesai

## Output Contoh

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Arsitektur

- **Application.java** - Aplikasi utama Spring Boot dengan CommandLineRunner
- **FoundryLocalService.java** - Layanan yang menggunakan OpenAI Java SDK untuk berkomunikasi dengan Foundry Local
- Menggunakan **OpenAI Java SDK** untuk panggilan API yang aman tipe
- Serialisasi/deserialisasi JSON otomatis ditangani oleh SDK
- Konfigurasi bersih menggunakan anotasi `@Value` dan `@PostConstruct` dari Spring

## Sorotan Kode

### Integrasi OpenAI Java SDK

Aplikasi menggunakan OpenAI Java SDK untuk membuat klien yang dikonfigurasi untuk Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### API Penyelesaian Chat

Melakukan permintaan penyelesaian chat sangat sederhana dan aman tipe:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Pemecahan Masalah

Jika Anda melihat kesalahan koneksi:
1. Verifikasi Foundry Local berjalan di `http://localhost:5273`
2. Periksa bahwa varian model Phi-3.5-mini tersedia dengan `foundry model list`
3. Pastikan nama model dalam `application.properties` sesuai dengan nama model yang ditampilkan dalam daftar
4. Pastikan tidak ada firewall yang memblokir koneksi

Masalah umum:
- **Model tidak ditemukan**: Jalankan `foundry model run phi-3.5-mini` untuk mengunduh dan memulai model
- **Layanan tidak berjalan**: Layanan Foundry Local mungkin telah berhenti; mulai ulang dengan perintah menjalankan model
- **Nama model salah**: Gunakan `foundry model list` untuk melihat model yang tersedia dan perbarui konfigurasi Anda sesuai.

**Penafian**:  
Dokumen ini telah diterjemahkan menggunakan layanan penerjemahan AI [Co-op Translator](https://github.com/Azure/co-op-translator). Meskipun kami berusaha untuk memberikan hasil yang akurat, harap diingat bahwa terjemahan otomatis mungkin mengandung kesalahan atau ketidakakuratan. Dokumen asli dalam bahasa aslinya harus dianggap sebagai sumber yang otoritatif. Untuk informasi yang bersifat kritis, disarankan menggunakan jasa penerjemahan profesional oleh manusia. Kami tidak bertanggung jawab atas kesalahpahaman atau penafsiran yang keliru yang timbul dari penggunaan terjemahan ini.