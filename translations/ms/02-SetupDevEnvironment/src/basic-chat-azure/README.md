<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2289320a74aeca1eb844cd7d3a7a9e12",
  "translation_date": "2025-07-21T19:42:15+00:00",
  "source_file": "02-SetupDevEnvironment/src/basic-chat-azure/README.md",
  "language_code": "ms"
}
-->
# Contoh Asas Chat dengan Azure OpenAI - End-to-End

Contoh ini menunjukkan cara untuk mencipta aplikasi Spring Boot yang mudah, yang berhubung dengan Azure OpenAI dan menguji tetapan anda.

## Kandungan

- [Keperluan Awal](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Permulaan Pantas](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Pilihan Konfigurasi](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Pilihan 1: Pembolehubah Persekitaran (fail .env) - Disyorkan](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Pilihan 2: Rahsia GitHub Codespace](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Menjalankan Aplikasi](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Menggunakan Maven](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Menggunakan VS Code](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Output Dijangka](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Rujukan Konfigurasi](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Pembolehubah Persekitaran](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Konfigurasi Spring](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Penyelesaian Masalah](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Isu Biasa](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Mod Debug](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Langkah Seterusnya](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Sumber](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)

## Keperluan Awal

Sebelum menjalankan contoh ini, pastikan anda telah:

- Menyelesaikan [panduan tetapan Azure OpenAI](../../getting-started-azure-openai.md)  
- Melakukan penyebaran sumber Azure OpenAI (melalui portal Azure AI Foundry)  
- Melakukan penyebaran model gpt-4o-mini (atau alternatif)  
- Mendapatkan kunci API dan URL endpoint dari Azure  

## Permulaan Pantas

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/src/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Pilihan Konfigurasi

### Pilihan 1: Pembolehubah Persekitaran (fail .env) - Disyorkan

**Langkah 1: Cipta fail konfigurasi anda**
```bash
cp .env.example .env
```

**Langkah 2: Tambahkan kelayakan Azure OpenAI anda**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Nota Keselamatan**: 
> - Jangan sekali-kali komit fail `.env` anda ke kawalan versi
> - Fail `.env` sudah disenaraikan dalam `.gitignore`
> - Pastikan kunci API anda selamat dan putarkan secara berkala

### Pilihan 2: Rahsia GitHub Codespace

Untuk GitHub Codespaces, tetapkan rahsia ini dalam repositori anda:
- `AZURE_AI_KEY` - Kunci API Azure OpenAI anda
- `AZURE_AI_ENDPOINT` - URL endpoint Azure OpenAI anda

Aplikasi akan secara automatik mengesan dan menggunakan rahsia ini.

### Alternatif: Pembolehubah Persekitaran Langsung

<details>
<summary>Klik untuk melihat arahan khusus platform</summary>

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

1. Buka projek dalam VS Code
2. Tekan `F5` atau gunakan panel "Run and Debug"
3. Pilih konfigurasi "Spring Boot-BasicChatApplication"

> **Nota**: Konfigurasi VS Code secara automatik memuatkan fail .env anda

### Output Dijangka

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

## Rujukan Konfigurasi

### Pembolehubah Persekitaran

| Pembolehubah | Penerangan | Diperlukan | Contoh |
|--------------|------------|------------|--------|
| `AZURE_AI_KEY` | Kunci API Azure OpenAI | Ya | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL endpoint Azure OpenAI | Ya | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Nama penyebaran model | Tidak | `gpt-4o-mini` (lalai) |

### Konfigurasi Spring

Fail `application.yml` mengkonfigurasi:
- **Kunci API**: `${AZURE_AI_KEY}` - Dari pembolehubah persekitaran
- **Endpoint**: `${AZURE_AI_ENDPOINT}` - Dari pembolehubah persekitaran  
- **Model**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Dari pembolehubah persekitaran dengan lalai
- **Temperature**: `0.7` - Mengawal kreativiti (0.0 = deterministik, 1.0 = kreatif)
- **Max Tokens**: `500` - Panjang respons maksimum

## Penyelesaian Masalah

### Isu Biasa

<details>
<summary><strong>Ralat: "The API key is not valid"</strong></summary>

- Periksa bahawa `AZURE_AI_KEY` anda telah ditetapkan dengan betul dalam fail `.env` anda
- Pastikan kunci API disalin tepat seperti yang terdapat di portal Azure AI Foundry
- Pastikan tiada ruang tambahan atau tanda petik di sekitar kunci
</details>

<details>
<summary><strong>Ralat: "The endpoint is not valid"</strong></summary>

- Pastikan `AZURE_AI_ENDPOINT` anda termasuk URL penuh (contoh: `https://your-hub-name.openai.azure.com/`)
- Periksa konsistensi garis miring di akhir URL
- Pastikan endpoint sepadan dengan wilayah penyebaran Azure anda
</details>

<details>
<summary><strong>Ralat: "The deployment was not found"</strong></summary>

- Pastikan nama penyebaran model anda sepadan tepat dengan yang disebarkan di Azure
- Periksa bahawa model berjaya disebarkan dan aktif
- Cuba gunakan nama penyebaran lalai: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Pembolehubah persekitaran tidak dimuatkan</strong></summary>

- Pastikan fail `.env` anda berada di direktori akar projek (tahap yang sama dengan `pom.xml`)
- Cuba jalankan `mvn spring-boot:run` dalam terminal bersepadu VS Code
- Periksa bahawa sambungan Java VS Code dipasang dengan betul
- Pastikan konfigurasi pelancaran mempunyai `"envFile": "${workspaceFolder}/.env"`
</details>

### Mod Debug

Untuk mengaktifkan log terperinci, nyahkomen baris ini dalam `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Langkah Seterusnya

**Tetapan Selesai!** Teruskan perjalanan pembelajaran anda:

[Bab 3: Teknik Teras AI Generatif](../../../03-CoreGenerativeAITechniques/README.md)

## Sumber

- [Dokumentasi Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Dokumentasi Perkhidmatan Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)
- [Portal Azure AI Foundry](https://ai.azure.com/)
- [Dokumentasi Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Penafian**:  
Dokumen ini telah diterjemahkan menggunakan perkhidmatan terjemahan AI [Co-op Translator](https://github.com/Azure/co-op-translator). Walaupun kami berusaha untuk memastikan ketepatan, sila ambil perhatian bahawa terjemahan automatik mungkin mengandungi kesilapan atau ketidaktepatan. Dokumen asal dalam bahasa asalnya harus dianggap sebagai sumber yang berwibawa. Untuk maklumat yang kritikal, terjemahan manusia profesional adalah disyorkan. Kami tidak bertanggungjawab atas sebarang salah faham atau salah tafsir yang timbul daripada penggunaan terjemahan ini.