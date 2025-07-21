<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T18:32:10+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "tr"
}
-->
# Evcil Hayvan Hikaye Uygulaması

>**Not**: Bu bölüm, bitmiş örnekleri çalıştırmanız için size rehberlik eden bir [**Eğitim**](./TUTORIAL.md) içermektedir.

Yüklenen evcil hayvan resimleri için GitHub Modelleri kullanarak yapay zeka destekli açıklamalar ve hikayeler üreten bir Spring Boot web uygulaması.

## İçindekiler

- [Teknoloji Yığını](../../../../04-PracticalSamples/petstory)
- [Ön Koşullar](../../../../04-PracticalSamples/petstory)
- [Kurulum ve Yükleme](../../../../04-PracticalSamples/petstory)
- [Kullanım](../../../../04-PracticalSamples/petstory)

## Teknoloji Yığını

- **Backend**: Spring Boot 3.5.3, Java 21
- **Yapay Zeka Entegrasyonu**: OpenAI Java SDK ile GitHub Modelleri
- **Güvenlik**: Spring Security
- **Frontend**: Bootstrap tasarımıyla Thymeleaf şablonları
- **Yapı Aracı**: Maven
- **Yapay Zeka Modelleri**: GitHub Modelleri

## Ön Koşullar

- Java 21 veya üstü
- Maven 3.9+
- `models:read` yetkisine sahip bir GitHub Kişisel Erişim Jetonu

## Kurulum ve Yükleme

### 1. Petstory uygulama dizinine gidin
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Ortam Değişkeni Ayarlayın
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Uygulamayı Derleyin
```bash
mvn clean compile
```

### 4. Uygulamayı Çalıştırın
```bash
mvn spring-boot:run
```

## Kullanım

1. **Uygulamaya Erişin**: `http://localhost:8080` adresine gidin
2. **Resim Yükleyin**: "Dosya Seç"e tıklayın ve bir evcil hayvan resmi seçin
3. **Resmi Analiz Edin**: Yapay zeka açıklaması almak için "Resmi Analiz Et"e tıklayın
4. **Hikaye Oluşturun**: Hikaye oluşturmak için "Hikaye Oluştur" butonuna tıklayın

**Feragatname**:  
Bu belge, AI çeviri hizmeti [Co-op Translator](https://github.com/Azure/co-op-translator) kullanılarak çevrilmiştir. Doğruluk için çaba göstersek de, otomatik çevirilerin hata veya yanlışlık içerebileceğini lütfen unutmayın. Belgenin orijinal dili, yetkili kaynak olarak kabul edilmelidir. Kritik bilgiler için profesyonel insan çevirisi önerilir. Bu çevirinin kullanımından kaynaklanan yanlış anlamalar veya yanlış yorumlamalar için sorumluluk kabul etmiyoruz.