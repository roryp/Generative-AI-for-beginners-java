<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T09:51:58+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "ms"
}
-->
# Teknik Teras AI Generatif

>**Nota**: Bab ini merangkumi [**Tutorial**](./TUTORIAL.md) yang memberikan panduan terperinci melalui contoh-contoh.

## Apa Yang Akan Anda Pelajari
Dalam bab ini, kita akan melihat 4 teknik teras AI generatif melalui contoh praktikal:
- Penyempurnaan LLM dan aliran perbualan
- Pemanggilan fungsi
- Penjanaan Augmentasi Pengambilan (RAG)
- Langkah keselamatan AI yang bertanggungjawab

## Kandungan

- [Apa Yang Akan Anda Pelajari](../../../03-CoreGenerativeAITechniques)
- [Prasyarat](../../../03-CoreGenerativeAITechniques)
- [Memulakan](../../../03-CoreGenerativeAITechniques)
- [Gambaran Keseluruhan Contoh](../../../03-CoreGenerativeAITechniques)
  - [1. Penyempurnaan LLM dan Aliran Perbualan](../../../03-CoreGenerativeAITechniques)
  - [2. Fungsi & Plugin dengan LLM](../../../03-CoreGenerativeAITechniques)
  - [3. Penjanaan Augmentasi Pengambilan (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Demonstrasi Keselamatan AI yang Bertanggungjawab](../../../03-CoreGenerativeAITechniques)
- [Ringkasan](../../../03-CoreGenerativeAITechniques)
- [Langkah Seterusnya](../../../03-CoreGenerativeAITechniques)

## Prasyarat

- Selesai persediaan dari [Bab 2](../../../02-SetupDevEnvironment)

## Memulakan

1. **Navigasi ke contoh**: 
```bash
cd 03-CoreGenerativeAITechniques/examples/
```
2. **Tetapkan persekitaran**: 
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

## Gambaran Keseluruhan Contoh

Contoh-contoh ini disusun dalam folder `examples/` dengan struktur berikut:

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

### 1. Penyempurnaan LLM dan Aliran Perbualan
**Fail**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Belajar membina AI perbualan dengan respons penstriman dan pengurusan sejarah perbualan.

Contoh ini menunjukkan:
- Penyempurnaan teks mudah dengan arahan sistem
- Perbualan berbilang pusingan dengan pengurusan sejarah
- Sesi perbualan interaktif
- Konfigurasi parameter (temperature, max tokens)

### 2. Fungsi & Plugin dengan LLM
**Fail**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Memperluaskan keupayaan AI dengan memberikan model akses kepada fungsi tersuai dan API luaran.

Contoh ini menunjukkan:
- Integrasi fungsi cuaca
- Pelaksanaan fungsi kalkulator  
- Pemanggilan pelbagai fungsi dalam satu perbualan
- Definisi fungsi dengan skema JSON

### 3. Penjanaan Augmentasi Pengambilan (RAG)
**Fail**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Belajar bagaimana menggabungkan AI dengan dokumen dan sumber data anda sendiri untuk respons yang tepat dan berasaskan konteks.

Contoh ini menunjukkan:
- Menjawab soalan berdasarkan dokumen dengan Azure OpenAI SDK
- Pelaksanaan corak RAG dengan Model GitHub

**Penggunaan**: Ajukan soalan tentang kandungan dalam `document.txt` dan dapatkan respons AI berdasarkan konteks tersebut sahaja.

### 4. Demonstrasi Keselamatan AI yang Bertanggungjawab
**Fail**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Dapatkan pratonton bagaimana langkah keselamatan AI berfungsi dengan menguji keupayaan penapisan kandungan Model GitHub.

Contoh ini menunjukkan:
- Penapisan kandungan untuk arahan yang berpotensi berbahaya
- Pengendalian respons keselamatan dalam aplikasi
- Kategori kandungan yang disekat (keganasan, ucapan kebencian, maklumat salah)
- Pengendalian ralat yang betul untuk pelanggaran keselamatan

> **Ketahui Lebih Lanjut**: Ini hanya pengenalan kepada konsep AI yang bertanggungjawab. Untuk maklumat lanjut tentang etika, mitigasi bias, pertimbangan privasi, dan rangka kerja AI yang bertanggungjawab, lihat [Bab 5: AI Generatif yang Bertanggungjawab](../05-ResponsibleGenAI/README.md).

## Ringkasan

Dalam bab ini, kita telah meneroka penyempurnaan LLM dan aliran perbualan, melaksanakan pemanggilan fungsi untuk meningkatkan keupayaan AI, mencipta sistem Penjanaan Augmentasi Pengambilan (RAG), dan menunjukkan langkah keselamatan AI yang bertanggungjawab. 

> **NOTA**: Selami lebih mendalam dengan [**Tutorial**](./TUTORIAL.md) yang disediakan.

## Langkah Seterusnya

[Bab 4: Aplikasi & Projek Praktikal](../04-PracticalSamples/README.md)

**Penafian**:  
Dokumen ini telah diterjemahkan menggunakan perkhidmatan terjemahan AI [Co-op Translator](https://github.com/Azure/co-op-translator). Walaupun kami berusaha untuk memastikan ketepatan, sila ambil perhatian bahawa terjemahan automatik mungkin mengandungi kesilapan atau ketidaktepatan. Dokumen asal dalam bahasa asalnya harus dianggap sebagai sumber yang berwibawa. Untuk maklumat penting, terjemahan manusia profesional adalah disyorkan. Kami tidak bertanggungjawab atas sebarang salah faham atau salah tafsir yang timbul daripada penggunaan terjemahan ini.