<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d45b8e2291ab1357592c904c103cbc81",
  "translation_date": "2025-07-28T11:00:49+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "id"
}
-->
# Aplikasi Praktis & Proyek

## Apa yang Akan Anda Pelajari
Di bagian ini, kita akan mendemonstrasikan tiga aplikasi praktis yang menampilkan pola pengembangan AI generatif dengan Java:
- Membuat **Pet Story Generator** multi-modal yang menggabungkan AI sisi klien dan sisi server
- Mengimplementasikan integrasi model AI lokal dengan demo **Foundry Local Spring Boot**
- Mengembangkan layanan **Model Context Protocol (MCP)** menggunakan contoh Kalkulator

## Daftar Isi

- [Pendahuluan](../../../04-PracticalSamples)
  - [Demo Foundry Local Spring Boot](../../../04-PracticalSamples)
  - [Pet Story Generator](../../../04-PracticalSamples)
  - [Layanan MCP Kalkulator (Demo MCP Ramah Pemula)](../../../04-PracticalSamples)
- [Progres Pembelajaran](../../../04-PracticalSamples)
- [Ringkasan](../../../04-PracticalSamples)
- [Langkah Selanjutnya](../../../04-PracticalSamples)

## Pendahuluan

Bab ini menampilkan **proyek contoh** yang mendemonstrasikan pola pengembangan AI generatif dengan Java. Setiap proyek sepenuhnya fungsional dan menunjukkan teknologi AI tertentu, pola arsitektur, serta praktik terbaik yang dapat Anda adaptasi untuk aplikasi Anda sendiri.

### Demo Foundry Local Spring Boot

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** menunjukkan cara mengintegrasikan model AI lokal menggunakan **OpenAI Java SDK**. Proyek ini menampilkan koneksi ke model **Phi-3.5-mini** yang berjalan di Foundry Local, memungkinkan Anda menjalankan aplikasi AI tanpa bergantung pada layanan cloud.

### Pet Story Generator

**[Pet Story Generator](petstory/README.md)** adalah aplikasi web Spring Boot yang menarik, yang mendemonstrasikan **pemrosesan AI multi-modal** untuk menghasilkan cerita kreatif tentang hewan peliharaan. Proyek ini menggabungkan kemampuan AI sisi klien dan sisi server menggunakan transformer.js untuk interaksi AI berbasis browser dan OpenAI SDK untuk pemrosesan sisi server.

### Layanan MCP Kalkulator (Demo MCP Ramah Pemula)

**[Layanan MCP Kalkulator](calculator/README.md)** adalah demonstrasi sederhana dari **Model Context Protocol (MCP)** menggunakan Spring AI. Proyek ini memberikan pengenalan yang ramah pemula tentang konsep MCP, menunjukkan cara membuat Server MCP dasar yang berinteraksi dengan klien MCP.

## Progres Pembelajaran

Proyek-proyek ini dirancang untuk membangun pemahaman secara bertahap dari konsep yang telah dibahas di bab sebelumnya:

1. **Mulai dari yang Sederhana**: Mulailah dengan Demo Foundry Local Spring Boot untuk memahami integrasi AI dasar dengan model lokal
2. **Tambahkan Interaktivitas**: Lanjutkan ke Pet Story Generator untuk mempelajari AI multi-modal dan interaksi berbasis web
3. **Pelajari Dasar-Dasar MCP**: Coba Layanan MCP Kalkulator untuk memahami dasar-dasar Model Context Protocol

## Ringkasan

**Selamat!** Anda telah berhasil:

- **Menciptakan pengalaman AI multi-modal** yang menggabungkan pemrosesan AI sisi klien dan sisi server
- **Mengimplementasikan integrasi model AI lokal** menggunakan framework dan SDK Java modern
- **Mengembangkan layanan Model Context Protocol** yang mendemonstrasikan pola integrasi alat

## Langkah Selanjutnya

[Chapter 5: Responsible Generative AI](../05-ResponsibleGenAI/README.md)

**Penafian**:  
Dokumen ini telah diterjemahkan menggunakan layanan penerjemahan AI [Co-op Translator](https://github.com/Azure/co-op-translator). Meskipun kami berusaha untuk memberikan hasil yang akurat, harap diperhatikan bahwa terjemahan otomatis mungkin mengandung kesalahan atau ketidakakuratan. Dokumen asli dalam bahasa aslinya harus dianggap sebagai sumber yang otoritatif. Untuk informasi yang bersifat kritis, disarankan menggunakan jasa penerjemahan profesional oleh manusia. Kami tidak bertanggung jawab atas kesalahpahaman atau penafsiran yang timbul dari penggunaan terjemahan ini.