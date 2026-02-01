# Obrolan Dasar dengan Azure OpenAI - Contoh End-to-End

Contoh ini menunjukkan cara membuat aplikasi Spring Boot sederhana yang terhubung ke Azure OpenAI dan menguji pengaturan Anda.

## Daftar Isi

- [Prasyarat](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Panduan Cepat](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Opsi Konfigurasi](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Opsi 1: Variabel Lingkungan (file .env) - Direkomendasikan](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Opsi 2: Rahasia GitHub Codespace](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Menjalankan Aplikasi](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Menggunakan Maven](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Menggunakan VS Code](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Output yang Diharapkan](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Referensi Konfigurasi](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Variabel Lingkungan](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Konfigurasi Spring](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Pemecahan Masalah](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Masalah Umum](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Mode Debug](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Langkah Selanjutnya](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Sumber Daya](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Prasyarat

Sebelum menjalankan contoh ini, pastikan Anda memiliki:

- Menyelesaikan [panduan pengaturan Azure OpenAI](../../getting-started-azure-openai.md)  
- Menyebarkan sumber daya Azure OpenAI (melalui portal Azure AI Foundry)  
- Menyebarkan model gpt-4o-mini (atau alternatif lainnya)  
- Kunci API dan URL endpoint dari Azure  

## Panduan Cepat

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Opsi Konfigurasi

### Opsi 1: Variabel Lingkungan (file .env) - Direkomendasikan

**Langkah 1: Buat file konfigurasi Anda**
```bash
cp .env.example .env
```

**Langkah 2: Tambahkan kredensial Azure OpenAI Anda**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Catatan Keamanan**: 
> - Jangan pernah mengunggah file `.env` Anda ke kontrol versi
> - File `.env` sudah ada di `.gitignore`
> - Jaga keamanan kunci API Anda dan rotasi secara berkala

### Opsi 2: Rahasia GitHub Codespace

Untuk GitHub Codespaces, atur rahasia ini di repositori Anda:
- `AZURE_AI_KEY` - Kunci API Azure OpenAI Anda
- `AZURE_AI_ENDPOINT` - URL endpoint Azure OpenAI Anda

Aplikasi secara otomatis mendeteksi dan menggunakan rahasia ini.

### Alternatif: Variabel Lingkungan Langsung

<details>
<summary>Klik untuk melihat perintah spesifik platform</summary>

**Linux/macOS (bash/zsh):**
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Command Prompt):**
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## Menjalankan Aplikasi

### Menggunakan Maven

```bash
mvn spring-boot:run
```

### Menggunakan VS Code

1. Buka proyek di VS Code
2. Tekan `F5` atau gunakan panel "Run and Debug"
3. Pilih konfigurasi "Spring Boot-BasicChatApplication"

> **Catatan**: Konfigurasi VS Code secara otomatis memuat file .env Anda

### Output yang Diharapkan

```
Starting Basic Chat with Azure OpenAI...
Environment variables loaded successfully
Connecting to Azure OpenAI...
Sending prompt: What is AI in a short sentence? Max 100 words.

AI Response:
================
AI, or Artificial Intelligence, is the simulation of human intelligence in machines programmed to think and learn like humans.
================

Success! Azure OpenAI connection is working correctly.
```

## Referensi Konfigurasi

### Variabel Lingkungan

| Variabel | Deskripsi | Wajib | Contoh |
|----------|-------------|----------|---------|
| `AZURE_AI_KEY` | Kunci API Azure OpenAI | Ya | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL endpoint Azure OpenAI | Ya | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Nama penyebaran model | Tidak | `gpt-4o-mini` (default) |

### Konfigurasi Spring

File `application.yml` mengonfigurasi:
- **Kunci API**: `${AZURE_AI_KEY}` - Dari variabel lingkungan
- **Endpoint**: `${AZURE_AI_ENDPOINT}` - Dari variabel lingkungan  
- **Model**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Dari variabel lingkungan dengan fallback
- **Temperature**: `0.7` - Mengontrol kreativitas (0.0 = deterministik, 1.0 = kreatif)
- **Max Tokens**: `500` - Panjang respons maksimum

## Pemecahan Masalah

### Masalah Umum

<details>
<summary><strong>Kesalahan: "Kunci API tidak valid"</strong></summary>

- Periksa bahwa `AZURE_AI_KEY` Anda diatur dengan benar di file `.env` Anda
- Verifikasi kunci API disalin persis dari portal Azure AI Foundry
- Pastikan tidak ada spasi atau tanda kutip tambahan di sekitar kunci
</details>

<details>
<summary><strong>Kesalahan: "Endpoint tidak valid"</strong></summary>

- Pastikan `AZURE_AI_ENDPOINT` Anda menyertakan URL lengkap (misalnya, `https://your-hub-name.openai.azure.com/`)
- Periksa konsistensi tanda garis miring di akhir
- Verifikasi endpoint sesuai dengan wilayah penyebaran Azure Anda
</details>

<details>
<summary><strong>Kesalahan: "Penyebaran tidak ditemukan"</strong></summary>

- Verifikasi nama penyebaran model Anda sesuai dengan yang disebarkan di Azure
- Periksa bahwa model berhasil disebarkan dan aktif
- Coba gunakan nama penyebaran default: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Variabel lingkungan tidak dimuat</strong></summary>

- Pastikan file `.env` Anda ada di direktori root proyek (level yang sama dengan `pom.xml`)
- Coba jalankan `mvn spring-boot:run` di terminal terintegrasi VS Code
- Periksa bahwa ekstensi Java VS Code terinstal dengan benar
- Verifikasi konfigurasi peluncuran memiliki `"envFile": "${workspaceFolder}/.env"`
</details>

### Mode Debug

Untuk mengaktifkan logging terperinci, hapus komentar pada baris ini di `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Langkah Selanjutnya

**Pengaturan Selesai!** Lanjutkan perjalanan belajar Anda:

[Bab 3: Teknik Inti AI Generatif](../../../03-CoreGenerativeAITechniques/README.md)

## Sumber Daya

- [Dokumentasi Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Dokumentasi Layanan Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)
- [Portal Azure AI Foundry](https://ai.azure.com/)
- [Dokumentasi Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Penafian**:  
Dokumen ini telah diterjemahkan menggunakan layanan penerjemahan AI [Co-op Translator](https://github.com/Azure/co-op-translator). Meskipun kami berupaya untuk memberikan hasil yang akurat, harap disadari bahwa terjemahan otomatis mungkin mengandung kesalahan atau ketidakakuratan. Dokumen asli dalam bahasa aslinya harus dianggap sebagai sumber yang berwenang. Untuk informasi yang bersifat kritis, disarankan menggunakan jasa penerjemahan manusia profesional. Kami tidak bertanggung jawab atas kesalahpahaman atau interpretasi yang keliru yang timbul dari penggunaan terjemahan ini.