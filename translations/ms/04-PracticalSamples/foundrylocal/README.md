# Foundry Local Spring Boot Tutorial

## Table of Contents

- [Prasyarat](#prasyarat)
- [Gambaran Projek](#gambaran-projek)
- [Memahami Kod](#memahami-kod)
  - [1. Konfigurasi Aplikasi (application.properties)](#1-konfigurasi-aplikasi-applicationproperties)
  - [2. Kelas Aplikasi Utama (Application.java)](#2-kelas-aplikasi-utama-applicationjava)
  - [3. Lapisan Perkhidmatan AI (FoundryLocalService.java)](#3-lapisan-perkhidmatan-ai-foundrylocalservicejava)
  - [4. Kebergantungan Projek (pom.xml)](#4-kebergantungan-projek-pomxml)
- [Bagaimana Ia Bekerjasama](#bagaimana-ia-bekerjasama)
- [Menyediakan Foundry Local](#menyediakan-foundry-local)
- [Menjalankan Aplikasi](#menjalankan-aplikasi)
- [Output Dijangka](#output-dijangka)
- [Langkah Seterusnya](#langkah-seterusnya)
- [Penyelesaian Masalah](#penyelesaian-masalah)


## Prasyarat

Sebelum memulakan tutorial ini, pastikan anda mempunyai:

- **Java 21 atau lebih tinggi** dipasang pada sistem anda
- **Maven 3.6+** untuk membina projek
- **Foundry Local** dipasang dan sedang berjalan

### **Pasang Foundry Local:**

> **Nota:** Foundry Local CLI tersedia hanya pada **Windows** dan **macOS**. Linux disokong melalui [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Sahkan pemasangan:
```bash
foundry --version
```

## Gambaran Projek

Projek ini terdiri daripada empat komponen utama:

1. **Application.java** - Titik masuk utama aplikasi Spring Boot
2. **FoundryLocalService.java** - Lapisan perkhidmatan yang mengendalikan komunikasi AI
3. **application.properties** - Konfigurasi untuk sambungan Foundry Local
4. **pom.xml** - Kebergantungan Maven dan konfigurasi projek

## Memahami Kod

### 1. Konfigurasi Aplikasi (application.properties)

**Fail:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Apa yang dilakukan ini:**
- **base-url**: Menentukan di mana Foundry Local sedang berjalan, termasuk laluan `/v1` untuk keserasian API OpenAI. Port lalai ialah `5273`. Jika port berbeza, semak dengan `foundry service status`.
- **model** (pilihan): Menamakan model AI yang digunakan untuk penjanaan teks. **Secara lalai, aplikasi mengesan model secara automatik** dengan bertanya ke titik akhir `/v1/models` Foundry Local semasa permulaan, jadi anda tidak perlu menetapkannya. Anda masih boleh menetapkannya secara eksplisit untuk menggantikan pengesanan automatik jika perlu.

**Konsep utama:** Spring Boot secara automatik memuatkan sifat ini dan menjadikan ia tersedia kepada aplikasi anda menggunakan anotasi `@Value`.

### 2. Kelas Aplikasi Utama (Application.java)

**Fail:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Tidak perlu pelayan web
        app.run(args);
    }
```

**Apa yang dilakukan ini:**
- `@SpringBootApplication` mengaktifkan konfigurasi automatik Spring Boot
- `WebApplicationType.NONE` memberitahu Spring ini adalah aplikasi baris perintah, bukan pelayan web
- Kaedah utama memulakan aplikasi Spring

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

**Apa yang dilakukan ini:**
- `@Bean` mencipta komponen yang diurus oleh Spring
- `CommandLineRunner` menjalankan kod selepas Spring Boot bermula
- `foundryLocalService` disuntik secara automatik oleh Spring (penyuntikan kebergantungan)
- Menghantar mesej ujian ke AI dan memaparkan balasan

### 3. Lapisan Perkhidmatan AI (FoundryLocalService.java)

**Fail:** `src/main/java/com/example/FoundryLocalService.java`

#### Suntikan Konfigurasi:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Dikesan secara automatik jika kosong
```

**Apa yang dilakukan ini:**
- `@Service` memberitahu Spring bahawa kelas ini menyediakan logik perniagaan
- `@Value` menyuntik nilai konfigurasi dari application.properties
- Model lalai kosong, yang mencetuskan **pengesanan automatik** dari Foundry Local semasa permulaan. Ini bermakna aplikasi berfungsi dengan mana-mana model yang dimuat dalam Foundry Local tanpa konfigurasi manual.

#### Inisialisasi Klien:
```java
@PostConstruct
public void init() {
    // Mengesan model secara automatik dari Foundry Lokal jika tidak dikonfigurasi secara eksplisit
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // URL Asas sudah termasuk /v1 dari konfigurasi
            .apiKey("not-needed")            // Pelayan tempatan tidak memerlukan kunci API sebenar
            .build();
}
```

**Apa yang dilakukan ini:**
- `@PostConstruct` menjalankan kaedah ini selepas Spring mencipta perkhidmatan
- Jika tiada model dikonfigurasikan, ia bertanya ke titik akhir `/v1/models` Foundry Local dan memilih model pertama yang dimuat
- Mencipta klien OpenAI yang menunjuk ke instans Foundry Local tempatan anda
- URL asas dari `application.properties` sudah termasuk `/v1` untuk keserasian API OpenAI
- Kunci API diset "not-needed" kerana pembangunan tempatan tidak memerlukan pengesahan

#### Kaedah Chat:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Model AI mana yang hendak digunakan
                .addUserMessage(message)         // Soalan/pesan anda
                .maxCompletionTokens(150)        // Hadkan panjang jawapan
                .temperature(0.7)                // Kawal kreativiti (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Ekstrak jawapan AI daripada keputusan API
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Apa yang dilakukan ini:**
- **ChatCompletionCreateParams**: Mengkonfigurasikan permintaan AI
  - `model`: Menentukan model AI yang hendak digunakan (mesti sepadan dengan ID tepat dari `foundry model list`)
  - `addUserMessage`: Menambah mesej anda ke perbualan
  - `maxCompletionTokens`: Mengehadkan panjang balasan (menjimatkan sumber)
  - `temperature`: Mengawal rawak (0.0 = deterministik, 1.0 = kreatif)
- **Panggilan API**: Menghantar permintaan ke Foundry Local
- **Pengendalian Balasan**: Mengekstrak balasan teks AI dengan selamat
- **Pengendalian Ralat**: Membalut pengecualian dengan mesej ralat yang berguna

### 4. Kebergantungan Projek (pom.xml)

**Kebergantungan Utama:**

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

**Apa yang dilakukan ini:**
- **spring-boot-starter**: Menyediakan fungsi teras Spring Boot
- **openai-java**: SDK rasmi Java OpenAI untuk komunikasi API
- **jackson-databind**: Mengendalikan penyerlahan/penyahserlahan JSON untuk panggilan API

## Bagaimana Ia Bekerjasama

Berikut aliran lengkap apabila anda menjalankan aplikasi:

1. **Permulaan**: Spring Boot bermula dan membaca `application.properties`
2. **Penciptaan Perkhidmatan**: Spring mencipta `FoundryLocalService` dan menyuntik nilai konfigurasi
3. **Pengesanan Model**: Jika tiada model dikonfigurasikan, perkhidmatan bertanya ke titik akhir `/v1/models` Foundry Local dan menggunakan model pertama yang tersedia secara automatik
4. **Persediaan Klien**: `@PostConstruct` menginisialisasi klien OpenAI untuk sambung ke Foundry Local
5. **Pelaksanaan Demo**: `CommandLineRunner` dilaksanakan selepas permulaan
6. **Panggilan AI**: Demo memanggil `foundryLocalService.chat()` dengan mesej ujian
7. **Permintaan API**: Perkhidmatan membina dan menghantar permintaan OpenAI-compatible ke Foundry Local
8. **Pemprosesan Balasan**: Perkhidmatan mengekstrak dan mengembalikan balasan AI
9. **Paparan**: Aplikasi mencetak balasan dan keluar

## Menyediakan Foundry Local

1. **Pasang Foundry Local** menggunakan arahan dalam bahagian [Prasyarat](#prasyarat).

2. **Mulakan perkhidmatan** (jika belum berjalan):
   ```bash
   foundry service start
   ```

3. **Semak status perkhidmatan** untuk mengesahkan ia berjalan dan ambil perhatian port:
   ```bash
   foundry service status
   ```

4. **Muat turun dan jalankan model** (muat turun pada kali pertama dijalankan, disimpan untuk kali berikutnya):
   ```bash
   foundry model run phi-4-mini
   ```
   Ini membuka sesi chat interaktif. Anda boleh keluar dengan `Ctrl+C`. Model kekal dimuat dalam perkhidmatan.

   > **Tip:** Jalankan `foundry model list` untuk melihat semua model yang tersedia. Gantikan `phi-4-mini` dengan mana-mana alias dari katalog (contohnya, `qwen2.5-0.5b` untuk model lebih kecil/pantas).

5. **Sahkan model dimuat:**
   ```bash
   foundry service ps
   ```

6. **Kemas kini `application.properties`** jika perlu:
   - `base-url` lalai (`http://localhost:5273/v1`) sepadan dengan port CLI lalai. Kemas kini hanya jika `foundry service status` menunjukkan port berbeza.
   - Model **dikesan secara automatik** semasa permulaan — tiada konfigurasi diperlukan.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Menjalankan Aplikasi

### Langkah 1: Pastikan model dimuat dalam Foundry Local
```bash
foundry service ps
```
Jika tiada model disenaraikan, muatkan satu:
```bash
foundry model run phi-4-mini
```

### Langkah 2: Bina dan Jalankan Aplikasi
Di terminal berasingan:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Atau bina dan jalankan sebagai JAR:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Output Dijangka

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

## Langkah Seterusnya

Untuk contoh lebih lanjut, lihat [Bab 04: Contoh praktikal](../README.md)

## Penyelesaian Masalah

### Isu Lazim

**"Connection refused" atau "Service unavailable"**
- Semak perkhidmatan: `foundry service status`
- Mulakan semula jika perlu: `foundry service restart`
- Sahkan port dalam `application.properties` sepadan dengan output `foundry service status`
- Pastikan URL berakhir dengan `/v1`: `http://localhost:5273/v1`

**"No model found" semasa permulaan**
- Aplikasi mengesan model secara automatik. Pastikan sekurang-kurangnya satu model dimuat: `foundry service ps`
- Jika tiada model dimuat: `foundry model run phi-4-mini`
- Jika anda menggantikan nama model dalam `application.properties`, pastikan sepadan dengan `foundry model list`

**Ralat "400 Bad Request"**
- Sahkan URL asas termasuk `/v1`: `http://localhost:5273/v1`
- Pastikan anda menggunakan `maxCompletionTokens()` dalam kod anda (bukan `maxTokens()` yang sudah lapuk)

**Ralat kompilasi Maven**
- Pastikan Java 21 atau lebih tinggi: `java -version`
- Bersihkan dan bina semula: `mvn clean compile`
- Semak sambungan internet untuk memuat turun kebergantungan

**Masalah sambungan perkhidmatan**
- Jika anda melihat `Request to local service failed`, jalankan: `foundry service restart`
- Semak model yang dimuat: `foundry service ps`
- Lihat log perkhidmatan: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Penafian**:  
Dokumen ini telah diterjemahkan menggunakan perkhidmatan terjemahan AI [Co-op Translator](https://github.com/Azure/co-op-translator). Walaupun kami berusaha untuk ketepatan, sila ambil perhatian bahawa terjemahan automatik mungkin mengandungi kesilapan atau ketidaktepatan. Dokumen asal dalam bahasa asalnya harus dianggap sebagai sumber yang sahih. Untuk maklumat penting, terjemahan profesional oleh manusia adalah disyorkan. Kami tidak bertanggungjawab atas sebarang salah faham atau salah tafsir yang timbul daripada penggunaan terjemahan ini.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->