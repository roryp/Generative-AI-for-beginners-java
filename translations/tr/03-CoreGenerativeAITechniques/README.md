<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T17:41:30+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "tr"
}
-->
# Temel Üretken Yapay Zeka Teknikleri

>**Not**: Bu bölüm, tamamlanmış örnekleri çalıştırmanıza rehberlik eden ayrıntılı bir [**Eğitim**](./TUTORIAL.md) içermektedir.

## Öğrenecekleriniz
Bu bölümde, 4 temel üretken yapay zeka tekniğini pratik örneklerle inceleyeceğiz:
- LLM tamamlama ve sohbet akışları
- Fonksiyon çağırma
- Geri Getirme Destekli Üretim (RAG)
- Sorumlu yapay zeka güvenlik önlemleri

## İçindekiler

- [Öğrenecekleriniz](../../../03-CoreGenerativeAITechniques)
- [Ön Koşullar](../../../03-CoreGenerativeAITechniques)
- [Başlarken](../../../03-CoreGenerativeAITechniques)
- [Örneklerin Genel Görünümü](../../../03-CoreGenerativeAITechniques)
  - [1. LLM Tamamlama ve Sohbet Akışları](../../../03-CoreGenerativeAITechniques)
  - [2. LLM'lerle Fonksiyonlar ve Eklentiler](../../../03-CoreGenerativeAITechniques)
  - [3. Geri Getirme Destekli Üretim (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Sorumlu Yapay Zeka Güvenliği Gösterimi](../../../03-CoreGenerativeAITechniques)
- [Özet](../../../03-CoreGenerativeAITechniques)
- [Sonraki Adımlar](../../../03-CoreGenerativeAITechniques)

## Ön Koşullar

- [Bölüm 2](../../../02-SetupDevEnvironment) içindeki kurulumun tamamlanmış olması

## Başlarken

1. **Örnekler klasörüne gidin**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Ortamı ayarlayın**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Örnekleri derleyin ve çalıştırın**:  
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

## Örneklerin Genel Görünümü

Örnekler, `examples/` klasöründe aşağıdaki yapıya göre düzenlenmiştir:

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

### 1. LLM Tamamlama ve Sohbet Akışları
**Dosya**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Akış yanıtları ve sohbet geçmişi yönetimi ile konuşma tabanlı yapay zeka oluşturmayı öğrenin.

Bu örnek şunları gösterir:
- Sistem istemleriyle basit metin tamamlama
- Geçmiş yönetimi ile çoklu dönüşlü sohbetler
- Etkileşimli sohbet oturumları
- Parametre yapılandırması (sıcaklık, maksimum token sayısı)

### 2. LLM'lerle Fonksiyonlar ve Eklentiler
**Dosya**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Modellere özel fonksiyonlar ve harici API'ler sağlanarak yapay zekanın yeteneklerini genişletin.

Bu örnek şunları gösterir:
- Hava durumu fonksiyonu entegrasyonu
- Hesap makinesi fonksiyonu uygulaması  
- Bir konuşmada birden fazla fonksiyon çağrısı
- JSON şemalarıyla fonksiyon tanımı

### 3. Geri Getirme Destekli Üretim (RAG)
**Dosya**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Yapay zekayı kendi belgeleriniz ve veri kaynaklarınızla birleştirerek doğru ve bağlama duyarlı yanıtlar almayı öğrenin.

Bu örnek şunları gösterir:
- Azure OpenAI SDK ile belge tabanlı soru-cevap
- GitHub Modelleri ile RAG deseni uygulaması

**Kullanım**: `document.txt` içeriği hakkında sorular sorun ve yalnızca o bağlama dayalı yapay zeka yanıtları alın.

### 4. Sorumlu Yapay Zeka Güvenliği Gösterimi
**Dosya**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

GitHub Modellerinin içerik filtreleme yeteneklerini test ederek yapay zeka güvenlik önlemlerine bir önizleme yapın.

Bu örnek şunları gösterir:
- Potansiyel olarak zararlı istemler için içerik filtreleme
- Uygulamalarda güvenlik yanıtlarının ele alınması
- Engellenen içerik kategorileri (şiddet, nefret söylemi, yanlış bilgi)
- Güvenlik ihlalleri için doğru hata yönetimi

> **Daha Fazla Bilgi Edinin**: Bu, sorumlu yapay zeka kavramlarına bir giriş niteliğindedir. Etik, önyargı azaltma, gizlilik hususları ve sorumlu yapay zeka çerçeveleri hakkında daha fazla bilgi için [Bölüm 5: Sorumlu Üretken Yapay Zeka](../05-ResponsibleGenAI/README.md) bölümüne bakın.

## Özet

Bu bölümde, LLM tamamlama ve sohbet akışlarını inceledik, yapay zekanın yeteneklerini artırmak için fonksiyon çağırmayı uyguladık, bir Geri Getirme Destekli Üretim (RAG) sistemi oluşturduk ve sorumlu yapay zeka güvenlik önlemlerini gösterdik.

> **NOT**: Sağlanan [**Eğitim**](./TUTORIAL.md) ile daha derine inin.

## Sonraki Adımlar

[Bölüm 4: Pratik Uygulamalar ve Projeler](../04-PracticalSamples/README.md)

**Feragatname**:  
Bu belge, AI çeviri hizmeti [Co-op Translator](https://github.com/Azure/co-op-translator) kullanılarak çevrilmiştir. Doğruluk için çaba göstersek de, otomatik çevirilerin hata veya yanlışlık içerebileceğini lütfen unutmayın. Belgenin orijinal dili, yetkili kaynak olarak kabul edilmelidir. Kritik bilgiler için profesyonel insan çevirisi önerilir. Bu çevirinin kullanımından kaynaklanan yanlış anlamalar veya yanlış yorumlamalar için sorumluluk kabul etmiyoruz.