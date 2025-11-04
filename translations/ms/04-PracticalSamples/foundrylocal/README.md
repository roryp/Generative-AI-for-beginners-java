<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "f787307400de59adc25a1404466a35f3",
  "translation_date": "2025-11-04T07:30:31+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "ms"
}
-->
# Tutorial Spring Boot Tempatan Foundry

## Kandungan

- [Prasyarat](../../../../04-PracticalSamples/foundrylocal)
- [Gambaran Projek](../../../../04-PracticalSamples/foundrylocal)
- [Memahami Kod](../../../../04-PracticalSamples/foundrylocal)
  - [1. Konfigurasi Aplikasi (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Kelas Aplikasi Utama (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. Lapisan Perkhidmatan AI (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Kebergantungan Projek (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Bagaimana Semua Berfungsi Bersama](../../../../04-PracticalSamples/foundrylocal)
- [Menyiapkan Foundry Tempatan](../../../../04-PracticalSamples/foundrylocal)
- [Menjalankan Aplikasi](../../../../04-PracticalSamples/foundrylocal)
- [Output Dijangka](../../../../04-PracticalSamples/foundrylocal)
- [Langkah Seterusnya](../../../../04-PracticalSamples/foundrylocal)
- [Penyelesaian Masalah](../../../../04-PracticalSamples/foundrylocal)

## Prasyarat

Sebelum memulakan tutorial ini, pastikan anda mempunyai:

- **Java 21 atau lebih tinggi** dipasang pada sistem anda
- **Maven 3.6+** untuk membina projek
- **Foundry Tempatan** dipasang dan berjalan

### **Pasang Foundry Tempatan:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```


## Gambaran Projek

Projek ini terdiri daripada empat komponen utama:

1. **Application.java** - Titik masuk utama aplikasi Spring Boot
2. **FoundryLocalService.java** - Lapisan perkhidmatan yang mengendalikan komunikasi AI
3. **application.properties** - Konfigurasi untuk sambungan Foundry Tempatan
4. **pom.xml** - Kebergantungan Maven dan konfigurasi projek

## Memahami Kod

### 1. Konfigurasi Aplikasi (application.properties)

**Fail:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**Apa yang dilakukan:**
- **base-url**: Menentukan lokasi Foundry Tempatan berjalan, termasuk laluan `/v1` untuk keserasian API OpenAI. **Nota**: Foundry Tempatan menetapkan port secara dinamik, jadi periksa port sebenar anda menggunakan `foundry service status`
- **model**: Menamakan model AI yang akan digunakan untuk penjanaan teks, termasuk nombor versi (contohnya, `:1`). Gunakan `foundry model list` untuk melihat model yang tersedia dengan ID tepat mereka

**Konsep utama:** Spring Boot secara automatik memuatkan sifat-sifat ini dan menjadikannya tersedia untuk aplikasi anda menggunakan anotasi `@Value`.

### 2. Kelas Aplikasi Utama (Application.java)

**Fail:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```


**Apa yang dilakukan:**
- `@SpringBootApplication` mengaktifkan konfigurasi automatik Spring Boot
- `WebApplicationType.NONE` memberitahu Spring bahawa ini adalah aplikasi baris perintah, bukan pelayan web
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


**Apa yang dilakukan:**
- `@Bean` mencipta komponen yang diuruskan oleh Spring
- `CommandLineRunner` menjalankan kod selepas Spring Boot dimulakan
- `foundryLocalService` disuntik secara automatik oleh Spring (suntikan kebergantungan)
- Menghantar mesej ujian kepada AI dan memaparkan respons

### 3. Lapisan Perkhidmatan AI (FoundryLocalService.java)

**Fail:** `src/main/java/com/example/FoundryLocalService.java`

#### Suntikan Konfigurasi:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**Apa yang dilakukan:**
- `@Service` memberitahu Spring bahawa kelas ini menyediakan logik perniagaan
- `@Value` menyuntik nilai konfigurasi daripada application.properties
- Sintaks `:default-value` menyediakan nilai sandaran jika sifat-sifat tidak ditetapkan

#### Inisialisasi Klien:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```


**Apa yang dilakukan:**
- `@PostConstruct` menjalankan kaedah ini selepas Spring mencipta perkhidmatan
- Mencipta klien OpenAI yang menunjuk kepada instance Foundry Tempatan anda
- URL asas daripada `application.properties` sudah termasuk `/v1` untuk keserasian API OpenAI
- Kunci API ditetapkan kepada "not-needed" kerana pembangunan tempatan tidak memerlukan pengesahan

#### Kaedah Chat:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Which AI model to use
                .addUserMessage(message)         // Your question/prompt
                .maxCompletionTokens(150)        // Limit response length
                .temperature(0.7)                // Control creativity (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extract the AI's response from the API result
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```


**Apa yang dilakukan:**
- **ChatCompletionCreateParams**: Mengkonfigurasi permintaan AI
  - `model`: Menentukan model AI yang akan digunakan (mesti sepadan dengan ID tepat daripada `foundry model list`)
  - `addUserMessage`: Menambah mesej anda kepada perbualan
  - `maxCompletionTokens`: Mengehadkan panjang respons (menjimatkan sumber)
  - `temperature`: Mengawal kebarangkalian (0.0 = deterministik, 1.0 = kreatif)
- **Panggilan API**: Menghantar permintaan kepada Foundry Tempatan
- **Pengendalian Respons**: Mengekstrak respons teks AI dengan selamat
- **Pengendalian Ralat**: Membungkus pengecualian dengan mesej ralat yang berguna

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


**Apa yang dilakukan:**
- **spring-boot-starter**: Menyediakan fungsi utama Spring Boot
- **openai-java**: SDK Java rasmi OpenAI untuk komunikasi API
- **jackson-databind**: Mengendalikan serialisasi/deserialisasi JSON untuk panggilan API

## Bagaimana Semua Berfungsi Bersama

Berikut adalah aliran lengkap apabila anda menjalankan aplikasi:

1. **Permulaan**: Spring Boot bermula dan membaca `application.properties`
2. **Penciptaan Perkhidmatan**: Spring mencipta `FoundryLocalService` dan menyuntik nilai konfigurasi
3. **Persediaan Klien**: `@PostConstruct` menginisialisasi klien OpenAI untuk menyambung ke Foundry Tempatan
4. **Pelaksanaan Demo**: `CommandLineRunner` dilaksanakan selepas permulaan
5. **Panggilan AI**: Demo memanggil `foundryLocalService.chat()` dengan mesej ujian
6. **Permintaan API**: Perkhidmatan membina dan menghantar permintaan yang serasi dengan OpenAI kepada Foundry Tempatan
7. **Pemprosesan Respons**: Perkhidmatan mengekstrak dan mengembalikan respons AI
8. **Paparan**: Aplikasi mencetak respons dan keluar

## Menyiapkan Foundry Tempatan

Untuk menyiapkan Foundry Tempatan, ikuti langkah-langkah berikut:

1. **Pasang Foundry Tempatan** menggunakan arahan dalam bahagian [Prasyarat](../../../../04-PracticalSamples/foundrylocal).

2. **Periksa port yang ditetapkan secara dinamik**. Foundry Tempatan secara automatik menetapkan port apabila ia bermula. Cari port anda dengan:
   ```bash
   foundry service status
   ```
   
   **Pilihan**: Jika anda lebih suka menggunakan port tertentu (contohnya, 5273), anda boleh mengkonfigurasinya secara manual:
   ```bash
   foundry service set --port 5273
   ```


3. **Muat turun model AI** yang anda ingin gunakan, contohnya, `phi-3.5-mini`, dengan arahan berikut:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **Konfigurasikan fail application.properties** untuk sepadan dengan tetapan Foundry Tempatan anda:
   - Kemas kini port dalam `base-url` (daripada langkah 2), pastikan ia termasuk `/v1` di hujungnya
   - Kemas kini nama model untuk termasuk nombor versi (periksa dengan `foundry model list`)
   
   Contoh:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## Menjalankan Aplikasi

### Langkah 1: Mulakan Foundry Tempatan
```bash
foundry model run phi-3.5-mini
```


### Langkah 2: Bina dan Jalankan Aplikasi
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
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```


## Langkah Seterusnya

Untuk lebih banyak contoh, lihat [Bab 04: Contoh Praktikal](../README.md)

## Penyelesaian Masalah

### Masalah Biasa

**"Connection refused" atau "Service unavailable"**
- Pastikan Foundry Tempatan sedang berjalan: `foundry model list`
- Periksa port sebenar yang digunakan oleh Foundry Tempatan: `foundry service status`
- Kemas kini `application.properties` anda dengan port yang betul, pastikan URL berakhir dengan `/v1`
- Sebagai alternatif, tetapkan port tertentu jika diinginkan: `foundry service set --port 5273`
- Cuba mulakan semula Foundry Tempatan: `foundry model run phi-3.5-mini`

**"Model not found" atau "404 Not Found" errors**
- Periksa model yang tersedia dengan ID tepat mereka: `foundry model list`
- Kemas kini nama model dalam `application.properties` untuk sepadan dengan tepat, termasuk nombor versi (contohnya, `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Pastikan `base-url` termasuk `/v1` di hujungnya: `http://localhost:5273/v1`
- Muat turun model jika diperlukan: `foundry model run phi-3.5-mini`

**"400 Bad Request" errors**
- Sahkan URL asas termasuk `/v1`: `http://localhost:5273/v1`
- Periksa bahawa ID model sepadan dengan tepat apa yang ditunjukkan dalam `foundry model list`
- Pastikan anda menggunakan `maxCompletionTokens()` dalam kod anda (bukan `maxTokens()` yang sudah tidak digunakan)

**Kesalahan kompilasi Maven**
- Pastikan Java 21 atau lebih tinggi: `java -version`
- Bersihkan dan bina semula: `mvn clean compile`
- Periksa sambungan internet untuk muat turun kebergantungan

**Aplikasi bermula tetapi tiada output**
- Sahkan Foundry Tempatan memberikan respons: Periksa `http://localhost:5273/v1/models` atau jalankan `foundry service status`
- Periksa log aplikasi untuk mesej ralat tertentu
- Pastikan model dimuatkan sepenuhnya dan sedia

---

**Penafian**:  
Dokumen ini telah diterjemahkan menggunakan perkhidmatan terjemahan AI [Co-op Translator](https://github.com/Azure/co-op-translator). Walaupun kami berusaha untuk ketepatan, sila ambil perhatian bahawa terjemahan automatik mungkin mengandungi kesilapan atau ketidaktepatan. Dokumen asal dalam bahasa asalnya harus dianggap sebagai sumber yang berwibawa. Untuk maklumat yang kritikal, terjemahan manusia profesional adalah disyorkan. Kami tidak bertanggungjawab atas sebarang salah faham atau salah tafsir yang timbul daripada penggunaan terjemahan ini.