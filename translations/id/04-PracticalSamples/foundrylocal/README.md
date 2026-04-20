# Panduan Foundry Local Spring Boot

## Daftar Isi

- [Prasyarat](#prasyarat)
- [Gambaran Proyek](#gambaran-proyek)
- [Memahami Kode](#memahami-kode)
  - [1. Konfigurasi Aplikasi (application.properties)](#1-konfigurasi-aplikasi-applicationproperties)
  - [2. Kelas Aplikasi Utama (Application.java)](#2-kelas-aplikasi-utama-applicationjava)
  - [3. Lapisan Layanan AI (FoundryLocalService.java)](#3-lapisan-layanan-ai-foundrylocalservicejava)
  - [4. Dependensi Proyek (pom.xml)](#4-dependensi-proyek-pomxml)
- [Cara Kerjanya Bersama](#cara-kerjanya-bersama)
- [Mengatur Foundry Local](#mengatur-foundry-local)
- [Menjalankan Aplikasi](#menjalankan-aplikasi)
- [Output yang Diharapkan](#output-yang-diharapkan)
- [Langkah Berikutnya](#langkah-berikutnya)
- [Pemecahan Masalah](#pemecahan-masalah)


## Prasyarat

Sebelum memulai panduan ini, pastikan Anda memiliki:

- **Java 21 atau lebih tinggi** terpasang di sistem Anda
- **Maven 3.6+** untuk membangun proyek
- **Foundry Local** terpasang dan berjalan

### **Pasang Foundry Local:**

> **Catatan:** Foundry Local CLI tersedia hanya di **Windows** dan **macOS**. Linux didukung melalui [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Verifikasi pemasangan:
```bash
foundry --version
```

## Gambaran Proyek

Proyek ini terdiri dari empat komponen utama:

1. **Application.java** - Titik masuk utama aplikasi Spring Boot
2. **FoundryLocalService.java** - Lapisan layanan yang menangani komunikasi AI
3. **application.properties** - Konfigurasi untuk koneksi Foundry Local
4. **pom.xml** - Dependensi Maven dan konfigurasi proyek

## Memahami Kode

### 1. Konfigurasi Aplikasi (application.properties)

**Berkas:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Fungsi ini:**
- **base-url**: Menentukan lokasi Foundry Local berjalan, termasuk jalur `/v1` untuk kompatibilitas API OpenAI. Port default adalah `5273`. Jika porta berbeda, cek dengan `foundry service status`.
- **model** (opsional): Menamai model AI yang digunakan untuk generasi teks. **Secara default, aplikasi mendeteksi model secara otomatis** dengan memanggil endpoint Foundry Local `/v1/models` saat startup, jadi Anda tidak perlu mengaturnya. Anda tetap dapat mengaturnya secara eksplisit untuk menimpa auto-detect jika perlu.

**Konsep penting:** Spring Boot secara otomatis memuat properti ini dan membuatnya tersedia untuk aplikasi Anda menggunakan anotasi `@Value`.

### 2. Kelas Aplikasi Utama (Application.java)

**Berkas:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Tidak perlu server web
        app.run(args);
    }
```

**Fungsi ini:**
- `@SpringBootApplication` mengaktifkan konfigurasi otomatis Spring Boot
- `WebApplicationType.NONE` memberi tahu Spring ini adalah aplikasi baris perintah, bukan server web
- Metode utama memulai aplikasi Spring

**Demo Runner:**
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

**Fungsi ini:**
- `@Bean` membuat komponen yang dikelola Spring
- `CommandLineRunner` menjalankan kode setelah Spring Boot dimulai
- `foundryLocalService` secara otomatis disuntikkan oleh Spring (dependency injection)
- Mengirim pesan uji ke AI dan menampilkan responsnya

### 3. Lapisan Layanan AI (FoundryLocalService.java)

**Berkas:** `src/main/java/com/example/FoundryLocalService.java`

#### Injeksi Konfigurasi:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Terdeksi otomatis jika kosong
```

**Fungsi ini:**
- `@Service` memberi tahu Spring bahwa kelas ini menyediakan logika bisnis
- `@Value` menyuntikkan nilai konfigurasi dari application.properties
- Model defaultnya kosong, yang memicu **auto-detection** dari Foundry Local saat startup. Artinya aplikasi bekerja dengan model apapun yang dimuat di Foundry Local tanpa konfigurasi manual.

#### Inisialisasi Klien:
```java
@PostConstruct
public void init() {
    // Deteksi model secara otomatis dari Foundry Lokal jika tidak dikonfigurasi secara eksplisit
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // URL dasar sudah termasuk /v1 dari konfigurasi
            .apiKey("not-needed")            // Server lokal tidak memerlukan kunci API nyata
            .build();
}
```

**Fungsi ini:**
- `@PostConstruct` menjalankan metode ini setelah Spring membuat layanan
- Jika tidak ada model yang dikonfigurasi, ia memanggil endpoint `/v1/models` Foundry Local dan memilih model pertama yang tersedia
- Membuat klien OpenAI yang mengarah ke instance Foundry Local Anda
- Base URL dari `application.properties` sudah termasuk `/v1` untuk kompatibilitas API OpenAI
- Kunci API disetel ke "not-needed" karena pengembangan lokal tidak memerlukan autentikasi

#### Metode Chat:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Model AI mana yang akan digunakan
                .addUserMessage(message)         // Pertanyaan/perintah Anda
                .maxCompletionTokens(150)        // Batasi panjang respons
                .temperature(0.7)                // Kontrol kreativitas (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Ekstrak respons AI dari hasil API
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Fungsi ini:**
- **ChatCompletionCreateParams**: Mengonfigurasi permintaan AI
  - `model`: Menentukan model AI mana yang digunakan (harus cocok dengan ID tepat dari `foundry model list`)
  - `addUserMessage`: Menambahkan pesan Anda ke obrolan
  - `maxCompletionTokens`: Membatasi panjang respons (menghemat sumber daya)
  - `temperature`: Mengontrol kekacauan/randomness (0.0 = deterministik, 1.0 = kreatif)
- **Pemanggilan API**: Mengirim permintaan ke Foundry Local
- **Penanganan Respons**: Mengekstrak teks respons AI dengan aman
- **Penanganan Kesalahan**: Membungkus pengecualian dengan pesan kesalahan yang membantu

### 4. Dependensi Proyek (pom.xml)

**Dependensi Utama:**

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

**Fungsi ini:**
- **spring-boot-starter**: Menyediakan fungsi inti Spring Boot
- **openai-java**: SDK resmi OpenAI Java untuk komunikasi API
- **jackson-databind**: Menangani serialisasi/deserialisasi JSON untuk pemanggilan API

## Cara Kerjanya Bersama

Berikut alur lengkap ketika Anda menjalankan aplikasi:

1. **Startup**: Spring Boot mulai dan membaca `application.properties`
2. **Pembuatan Layanan**: Spring membuat `FoundryLocalService` dan menyuntikkan nilai konfigurasi
3. **Deteksi Model**: Jika tidak ada model yang dikonfigurasi, layanan memanggil endpoint `/v1/models` Foundry Local dan menggunakan model pertama yang tersedia secara otomatis
4. **Pengaturan Klien**: `@PostConstruct` menginisialisasi klien OpenAI untuk terhubung ke Foundry Local
5. **Eksekusi Demo**: `CommandLineRunner` berjalan setelah startup
6. **Panggilan AI**: Demo memanggil `foundryLocalService.chat()` dengan pesan uji
7. **Permintaan API**: Layanan membangun dan mengirim permintaan kompatibel OpenAI ke Foundry Local
8. **Pemrosesan Respons**: Layanan mengekstrak dan mengembalikan respons AI
9. **Tampilan**: Aplikasi mencetak respons dan keluar

## Mengatur Foundry Local

1. **Pasang Foundry Local** menggunakan instruksi pada bagian [Prasyarat](#prasyarat).

2. **Mulai layanan** (jika belum berjalan):
   ```bash
   foundry service start
   ```

3. **Periksa status layanan** untuk memastikan berjalan dan catat portnya:
   ```bash
   foundry service status
   ```

4. **Unduh dan jalankan model** (mengunduh pada kali pertama, disimpan cache untuk penggunaan berikutnya):
   ```bash
   foundry model run phi-4-mini
   ```
   Ini membuka sesi obrolan interaktif. Anda dapat keluar dengan `Ctrl+C`. Model tetap dimuat di layanan.

   > **Tips:** Jalankan `foundry model list` untuk melihat semua model yang tersedia. Ganti `phi-4-mini` dengan alias apapun dari katalog (misal, `qwen2.5-0.5b` untuk model lebih kecil/cepat).

5. **Verifikasi model telah dimuat:**
   ```bash
   foundry service ps
   ```

6. **Perbarui `application.properties`** jika perlu:
   - `base-url` default (`http://localhost:5273/v1`) sesuai dengan port CLI standar. Update hanya jika `foundry service status` menunjukkan port berbeda.
   - Model **dideteksi otomatis** saat startup — tidak perlu konfigurasi.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Menjalankan Aplikasi

### Langkah 1: Pastikan model telah dimuat di Foundry Local
```bash
foundry service ps
```
Jika tidak ada model yang terdaftar, muat salah satu:
```bash
foundry model run phi-4-mini
```

### Langkah 2: Bangun dan Jalankan Aplikasi
Di terminal lain:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Atau bangun dan jalankan sebagai JAR:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Output yang Diharapkan

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

## Langkah Berikutnya

Untuk contoh lebih lanjut, lihat [Bab 04: Contoh praktis](../README.md)

## Pemecahan Masalah

### Masalah Umum

**"Connection refused" atau "Service unavailable"**
- Periksa layanan: `foundry service status`
- Mulai ulang jika perlu: `foundry service restart`
- Pastikan port di `application.properties` sesuai dengan output `foundry service status`
- Pastikan URL berakhiran `/v1`: `http://localhost:5273/v1`

**"No model found" saat startup**
- Aplikasi otomatis mendeteksi model. Pastikan setidaknya satu model terpasang: `foundry service ps`
- Jika tidak ada model yang terpasang: `foundry model run phi-4-mini`
- Jika Anda mengubah nama model di `application.properties`, pastikan cocok dengan `foundry model list`

**Error "400 Bad Request"**
- Pastikan base URL menyertakan `/v1`: `http://localhost:5273/v1`
- Pastikan Anda menggunakan `maxCompletionTokens()` dalam kode (bukan `maxTokens()` yang usang)

**Error kompilasi Maven**
- Pastikan Java 21 atau lebih tinggi: `java -version`
- Bersihkan dan bangun ulang: `mvn clean compile`
- Cek koneksi internet untuk mengunduh dependensi

**Masalah koneksi layanan**
- Jika muncul `Request to local service failed`, jalankan: `foundry service restart`
- Periksa model terpasang: `foundry service ps`
- Lihat log layanan: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Penafian**:  
Dokumen ini telah diterjemahkan menggunakan layanan terjemahan AI [Co-op Translator](https://github.com/Azure/co-op-translator). Meskipun kami berusaha untuk memberikan terjemahan yang akurat, harap diingat bahwa terjemahan otomatis dapat mengandung kesalahan atau ketidakakuratan. Dokumen asli dalam bahasa aslinya harus dianggap sebagai sumber yang sahih. Untuk informasi penting, disarankan menggunakan terjemahan profesional oleh manusia. Kami tidak bertanggung jawab atas kesalahpahaman atau kesalahan interpretasi yang timbul dari penggunaan terjemahan ini.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->