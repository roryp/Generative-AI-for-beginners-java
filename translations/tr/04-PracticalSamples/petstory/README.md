<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T09:29:55+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "tr"
}
-->
# Pet Story Uygulaması

>**Not**: Bu bölüm, örnekler üzerinden sizi yönlendiren bir [**Eğitim**](./TUTORIAL.md) içerir.

GitHub Modelleri kullanarak yüklenen evcil hayvan resimleri için yapay zeka destekli açıklamalar ve hikayeler oluşturan bir Spring Boot web uygulaması.

## İçindekiler

- [Teknoloji Yığını](../../../../04-PracticalSamples/petstory)
- [Ön Koşullar](../../../../04-PracticalSamples/petstory)
- [Kurulum ve Yükleme](../../../../04-PracticalSamples/petstory)
- [Kullanım](../../../../04-PracticalSamples/petstory)

## Teknoloji Yığını

- **Backend**: Spring Boot 3.5.3, Java 21
- **Yapay Zeka Entegrasyonu**: OpenAI Java SDK ile GitHub Modelleri
- **Güvenlik**: Spring Security
- **Frontend**: Thymeleaf şablonları ve Bootstrap tasarımı
- **Yapı Aracı**: Maven
- **Yapay Zeka Modelleri**: GitHub Modelleri

## Ön Koşullar

- Java 21 veya üstü
- Maven 3.9+
- `models:read` yetkisine sahip GitHub Kişisel Erişim Token'ı

## Kurulum ve Yükleme

### 1. Petstory uygulama dizinine gidin
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Ortam Değişkenini Ayarlayın
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
2. **Resim Yükleyin**: "Choose File" butonuna tıklayın ve bir evcil hayvan resmi seçin
3. **Resmi Analiz Edin**: Yapay zeka açıklaması almak için "Analyze Image" butonuna tıklayın
4. **Hikaye Oluşturun**: Hikaye oluşturmak için "Generate Story" butonuna tıklayın

**Feragatname**:  
Bu belge, AI çeviri hizmeti [Co-op Translator](https://github.com/Azure/co-op-translator) kullanılarak çevrilmiştir. Doğruluk için çaba göstersek de, otomatik çevirilerin hata veya yanlışlık içerebileceğini lütfen unutmayın. Belgenin orijinal dilindeki hali, yetkili kaynak olarak kabul edilmelidir. Kritik bilgiler için profesyonel insan çevirisi önerilir. Bu çevirinin kullanımından kaynaklanan yanlış anlamalar veya yanlış yorumlamalar için sorumluluk kabul etmiyoruz.