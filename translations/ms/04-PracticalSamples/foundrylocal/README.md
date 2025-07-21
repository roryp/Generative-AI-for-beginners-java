<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T19:50:30+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "ms"
}
-->
# Aplikasi Baris Perintah Tempatan Foundry

>**Nota**: Bab ini termasuk [**Tutorial**](./TUTORIAL.md) yang membimbing anda menjalankan sampel yang telah siap.

Sebuah aplikasi baris perintah Spring Boot yang ringkas yang menunjukkan cara untuk menyambung ke Foundry Local menggunakan OpenAI Java SDK.

## Apa yang Anda Akan Pelajari

- Cara mengintegrasikan Foundry Local dengan aplikasi Spring Boot menggunakan OpenAI Java SDK
- Amalan terbaik untuk pembangunan dan ujian AI secara tempatan

## Kandungan

- [Apa yang Anda Akan Pelajari](../../../../04-PracticalSamples/foundrylocal)
- [Prasyarat](../../../../04-PracticalSamples/foundrylocal)
  - [Memasang Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Pengesahan](../../../../04-PracticalSamples/foundrylocal)
- [Konfigurasi](../../../../04-PracticalSamples/foundrylocal)
- [Permulaan Pantas](../../../../04-PracticalSamples/foundrylocal)
- [Apa yang Aplikasi Ini Lakukan](../../../../04-PracticalSamples/foundrylocal)
- [Contoh Output](../../../../04-PracticalSamples/foundrylocal)
- [Seni Bina](../../../../04-PracticalSamples/foundrylocal)
- [Sorotan Kod](../../../../04-PracticalSamples/foundrylocal)
  - [Integrasi OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [API Penyempurnaan Chat](../../../../04-PracticalSamples/foundrylocal)
- [Penyelesaian Masalah](../../../../04-PracticalSamples/foundrylocal)

## Prasyarat

> **⚠️ Nota**: Aplikasi ini **tidak berjalan dalam devcontainer yang disediakan** kerana ia memerlukan Foundry Local dipasang dan berjalan pada sistem hos.

### Memasang Foundry Local

Sebelum menjalankan aplikasi ini, anda perlu memasang dan memulakan Foundry Local. Ikuti langkah-langkah berikut:

1. **Pastikan sistem anda memenuhi keperluan**:
   - **Sistem Operasi**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, atau macOS
   - **Perkakasan**: 
     - Minimum: 8GB RAM, 3GB ruang cakera kosong
     - Disyorkan: 16GB RAM, 15GB ruang cakera kosong
   - **Rangkaian**: Sambungan internet untuk muat turun model awal (pilihan untuk penggunaan luar talian)
   - **Pecutan (pilihan)**: NVIDIA GPU (siri 2,000 atau lebih baru), AMD GPU (siri 6,000 atau lebih baru), Qualcomm Snapdragon X Elite (8GB atau lebih memori), atau Apple silicon
   - **Kebenaran**: Keistimewaan pentadbiran untuk memasang perisian pada peranti anda

2. **Pasang Foundry Local**:
   
   **Untuk Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **Untuk macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Sebagai alternatif, anda boleh memuat turun pemasang dari [repositori GitHub Foundry Local](https://github.com/microsoft/Foundry-Local).

3. **Mulakan model pertama anda**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Model akan dimuat turun (yang mungkin mengambil masa beberapa minit, bergantung pada kelajuan internet anda) dan kemudian dijalankan. Foundry Local secara automatik memilih varian model terbaik untuk sistem anda (CUDA untuk NVIDIA GPUs, versi CPU jika tidak).

4. **Uji model** dengan bertanya soalan dalam terminal yang sama:

   ```bash
   Why is the sky blue?
   ```

   Anda sepatutnya melihat respons dari model Phi yang menerangkan mengapa langit kelihatan biru.

### Pengesahan

Anda boleh mengesahkan semuanya berfungsi dengan betul menggunakan arahan berikut:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Anda juga boleh melawat `http://localhost:5273` dalam pelayar anda untuk melihat antara muka web Foundry Local.

## Konfigurasi

Aplikasi ini boleh dikonfigurasi melalui `application.properties`:

- `foundry.local.base-url` - URL asas untuk Foundry Local (lalai: http://localhost:5273)
- `foundry.local.model` - Model AI yang digunakan (lalai: Phi-3.5-mini-instruct-cuda-gpu)

> **Nota**: Nama model dalam konfigurasi harus sepadan dengan varian spesifik yang dimuat turun oleh Foundry Local untuk sistem anda. Apabila anda menjalankan `foundry model run phi-3.5-mini`, Foundry Local secara automatik memilih dan memuat turun varian terbaik (CUDA untuk NVIDIA GPUs, versi CPU jika tidak). Gunakan `foundry model list` untuk melihat nama model tepat yang tersedia dalam instans tempatan anda.

## Permulaan Pantas

### 1. Navigasi ke direktori aplikasi Foundry Local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Jalankan Aplikasi

```bash
mvn spring-boot:run
```

Atau bina dan jalankan JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Kebergantungan

Aplikasi ini menggunakan OpenAI Java SDK untuk berkomunikasi dengan Foundry Local. Kebergantungan utama adalah:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Aplikasi ini telah dikonfigurasi untuk menyambung ke Foundry Local yang berjalan pada port lalai.

## Apa yang Aplikasi Ini Lakukan

Apabila anda menjalankan aplikasi:

1. **Dimulakan** sebagai aplikasi baris perintah (tanpa pelayan web)
2. **Secara automatik menghantar** mesej ujian: "Hello! Can you tell me what you are and what model you're running?"
3. **Memaparkan respons** dari Foundry Local dalam konsol
4. **Keluar dengan bersih** selepas demo

## Contoh Output

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Seni Bina

- **Application.java** - Aplikasi utama Spring Boot dengan CommandLineRunner
- **FoundryLocalService.java** - Perkhidmatan yang menggunakan OpenAI Java SDK untuk berkomunikasi dengan Foundry Local
- Menggunakan **OpenAI Java SDK** untuk panggilan API yang selamat jenis
- Penyusunan/penyahsusunan JSON automatik dikendalikan oleh SDK
- Konfigurasi bersih menggunakan anotasi `@Value` dan `@PostConstruct` Spring

## Sorotan Kod

### Integrasi OpenAI Java SDK

Aplikasi ini menggunakan OpenAI Java SDK untuk mencipta klien yang dikonfigurasi untuk Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### API Penyempurnaan Chat

Membuat permintaan penyempurnaan chat adalah mudah dan selamat jenis:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Penyelesaian Masalah

Jika anda melihat ralat sambungan:
1. Sahkan Foundry Local sedang berjalan pada `http://localhost:5273`
2. Periksa bahawa varian model Phi-3.5-mini tersedia dengan `foundry model list`
3. Pastikan nama model dalam `application.properties` sepadan dengan nama model tepat yang ditunjukkan dalam senarai
4. Pastikan tiada firewall yang menyekat sambungan

Masalah biasa:
- **Model tidak dijumpai**: Jalankan `foundry model run phi-3.5-mini` untuk memuat turun dan memulakan model
- **Perkhidmatan tidak berjalan**: Perkhidmatan Foundry Local mungkin telah berhenti; mulakan semula dengan arahan run model
- **Nama model salah**: Gunakan `foundry model list` untuk melihat model yang tersedia dan kemas kini konfigurasi anda sewajarnya

**Penafian**:  
Dokumen ini telah diterjemahkan menggunakan perkhidmatan terjemahan AI [Co-op Translator](https://github.com/Azure/co-op-translator). Walaupun kami berusaha untuk memastikan ketepatan, sila ambil perhatian bahawa terjemahan automatik mungkin mengandungi kesilapan atau ketidaktepatan. Dokumen asal dalam bahasa asalnya harus dianggap sebagai sumber yang berwibawa. Untuk maklumat yang kritikal, terjemahan manusia profesional adalah disyorkan. Kami tidak bertanggungjawab atas sebarang salah faham atau salah tafsir yang timbul daripada penggunaan terjemahan ini.