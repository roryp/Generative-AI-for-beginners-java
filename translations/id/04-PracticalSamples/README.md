<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "139c227ef39d24287257d1aff6fc6973",
  "translation_date": "2025-07-25T09:50:05+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "id"
}
-->
# Aplikasi Praktis & Proyek

> Catatan: Setiap contoh juga menyertakan **TUTORIAL.md** yang membimbing Anda menjalankan sampel.

## Apa yang Akan Anda Pelajari
Di bagian ini, kami akan mendemonstrasikan tiga aplikasi praktis yang menampilkan pola pengembangan AI generatif dengan Java:
- Membuat Generator Cerita Hewan Peliharaan multi-modal yang menggabungkan AI sisi klien dan sisi server
- Mengimplementasikan integrasi model AI lokal dengan demo Foundry Local Spring Boot
- Mengembangkan layanan Model Context Protocol (MCP) dengan contoh Kalkulator

## Daftar Isi

- [Pendahuluan](../../../04-PracticalSamples)
  - [Demo Foundry Local Spring Boot](../../../04-PracticalSamples)
  - [Generator Cerita Hewan Peliharaan](../../../04-PracticalSamples)
  - [Layanan MCP Kalkulator (Demo MCP Ramah Pemula)](../../../04-PracticalSamples)
- [Progres Pembelajaran](../../../04-PracticalSamples)
- [Ringkasan](../../../04-PracticalSamples)
- [Langkah Selanjutnya](../../../04-PracticalSamples)

## Pendahuluan

Bab ini menampilkan **proyek sampel** yang mendemonstrasikan pola pengembangan AI generatif dengan Java. Setiap proyek sepenuhnya fungsional dan menunjukkan teknologi AI tertentu, pola arsitektur, serta praktik terbaik yang dapat Anda adaptasi untuk aplikasi Anda sendiri.

### Demo Foundry Local Spring Boot

**[Demo Foundry Local Spring Boot](foundrylocal/README.md)** menunjukkan cara mengintegrasikan model AI lokal menggunakan **OpenAI Java SDK**. Proyek ini menampilkan koneksi ke model **Phi-3.5-mini** yang berjalan di Foundry Local, memungkinkan Anda menjalankan aplikasi AI tanpa bergantung pada layanan cloud.

### Generator Cerita Hewan Peliharaan

**[Generator Cerita Hewan Peliharaan](petstory/README.md)** adalah aplikasi web Spring Boot yang menarik, yang mendemonstrasikan **pemrosesan AI multi-modal** untuk menghasilkan cerita kreatif tentang hewan peliharaan. Proyek ini menggabungkan kemampuan AI sisi klien dan sisi server menggunakan transformer.js untuk interaksi AI berbasis browser dan OpenAI SDK untuk pemrosesan sisi server.

### Layanan MCP Kalkulator (Demo MCP Ramah Pemula)

**[Layanan MCP Kalkulator](mcp/calculator/README.md)** adalah demonstrasi sederhana dari **Model Context Protocol (MCP)** menggunakan Spring AI. Proyek ini memberikan pengenalan yang ramah pemula terhadap konsep MCP, menunjukkan cara membuat Server MCP dasar yang berinteraksi dengan klien MCP.

## Progres Pembelajaran

Proyek-proyek ini dirancang untuk membangun konsep dari bab-bab sebelumnya:

1. **Mulai dari yang Sederhana**: Mulailah dengan Demo Foundry Local Spring Boot untuk memahami integrasi AI dasar dengan model lokal
2. **Tambahkan Interaktivitas**: Lanjutkan ke Generator Cerita Hewan Peliharaan untuk AI multi-modal dan interaksi berbasis web
3. **Pelajari Dasar-Dasar MCP**: Coba Layanan MCP Kalkulator untuk memahami dasar-dasar Model Context Protocol

## Ringkasan

**Selamat!** Anda telah berhasil:

- **Menciptakan pengalaman AI multi-modal** yang menggabungkan pemrosesan AI sisi klien dan sisi server
- **Mengimplementasikan integrasi model AI lokal** menggunakan kerangka kerja dan SDK Java modern
- **Mengembangkan layanan Model Context Protocol** yang mendemonstrasikan pola integrasi alat

## Langkah Selanjutnya

[Chapter 5: Responsible Generative AI](../05-ResponsibleGenAI/README.md)

**Penafian**:  
Dokumen ini telah diterjemahkan menggunakan layanan penerjemahan AI [Co-op Translator](https://github.com/Azure/co-op-translator). Meskipun kami berusaha untuk memberikan hasil yang akurat, harap diperhatikan bahwa terjemahan otomatis mungkin mengandung kesalahan atau ketidakakuratan. Dokumen asli dalam bahasa aslinya harus dianggap sebagai sumber yang otoritatif. Untuk informasi yang bersifat kritis, disarankan menggunakan jasa penerjemahan profesional oleh manusia. Kami tidak bertanggung jawab atas kesalahpahaman atau penafsiran yang timbul dari penggunaan terjemahan ini.