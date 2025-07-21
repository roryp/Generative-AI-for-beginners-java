<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T18:16:23+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "tr"
}
-->
# Foundry Yerel Komut Satırı Uygulaması

>**Not**: Bu bölüm, tamamlanmış örnekleri çalıştırma konusunda size rehberlik eden bir [**Eğitim**](./TUTORIAL.md) içerir.

OpenAI Java SDK kullanarak Foundry Yerel'e bağlanmayı gösteren basit bir Spring Boot komut satırı uygulaması.

## Öğrenecekleriniz

- OpenAI Java SDK kullanarak Foundry Yerel'i Spring Boot uygulamalarıyla nasıl entegre edeceğinizi
- Yerel yapay zeka geliştirme ve test için en iyi uygulamalar

## İçindekiler

- [Öğrenecekleriniz](../../../../04-PracticalSamples/foundrylocal)
- [Ön Koşullar](../../../../04-PracticalSamples/foundrylocal)
  - [Foundry Yerel'in Kurulumu](../../../../04-PracticalSamples/foundrylocal)
  - [Doğrulama](../../../../04-PracticalSamples/foundrylocal)
- [Yapılandırma](../../../../04-PracticalSamples/foundrylocal)
- [Hızlı Başlangıç](../../../../04-PracticalSamples/foundrylocal)
- [Uygulamanın Yaptıkları](../../../../04-PracticalSamples/foundrylocal)
- [Örnek Çıktı](../../../../04-PracticalSamples/foundrylocal)
- [Mimari](../../../../04-PracticalSamples/foundrylocal)
- [Kod Öne Çıkanlar](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI Java SDK Entegrasyonu](../../../../04-PracticalSamples/foundrylocal)
  - [Chat Completion API](../../../../04-PracticalSamples/foundrylocal)
- [Sorun Giderme](../../../../04-PracticalSamples/foundrylocal)

## Ön Koşullar

> **⚠️ Not**: Bu uygulama **sağlanan devcontainer içinde çalışmaz** çünkü Foundry Yerel'in ana sistemde kurulu ve çalışıyor olması gerekir.

### Foundry Yerel'in Kurulumu

Bu uygulamayı çalıştırmadan önce Foundry Yerel'i kurmanız ve başlatmanız gerekir. Aşağıdaki adımları izleyin:

1. **Sisteminizin gereksinimleri karşıladığından emin olun**:
   - **İşletim Sistemi**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 veya macOS
   - **Donanım**: 
     - Minimum: 8GB RAM, 3GB boş disk alanı
     - Önerilen: 16GB RAM, 15GB boş disk alanı
   - **Ağ**: İlk model indirme için internet bağlantısı (çevrimdışı kullanım için isteğe bağlı)
   - **Hızlandırma (isteğe bağlı)**: NVIDIA GPU (2,000 serisi veya daha yeni), AMD GPU (6,000 serisi veya daha yeni), Qualcomm Snapdragon X Elite (8GB veya daha fazla bellek), veya Apple silicon
   - **İzinler**: Cihazınıza yazılım yüklemek için yönetici yetkileri

2. **Foundry Yerel'i Kurun**:
   
   **Windows için:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **macOS için:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Alternatif olarak, [Foundry Yerel GitHub deposundan](https://github.com/microsoft/Foundry-Local) yükleyiciyi indirebilirsiniz.

3. **İlk modelinizi başlatın**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Model indirilir (internet hızınıza bağlı olarak birkaç dakika sürebilir) ve ardından çalışır. Foundry Yerel, sisteminiz için en iyi model varyantını otomatik olarak seçer (NVIDIA GPU'lar için CUDA, aksi takdirde CPU sürümü).

4. **Modeli test edin**: Aynı terminalde bir soru sorarak:

   ```bash
   Why is the sky blue?
   ```

   Gökyüzünün neden mavi göründüğünü açıklayan Phi modelinden bir yanıt görmelisiniz.

### Doğrulama

Her şeyin düzgün çalıştığını şu komutlarla doğrulayabilirsiniz:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Ayrıca `http://localhost:5273` adresini tarayıcınızda ziyaret ederek Foundry Yerel web arayüzünü görebilirsiniz.

## Yapılandırma

Uygulama `application.properties` dosyası üzerinden yapılandırılabilir:

- `foundry.local.base-url` - Foundry Yerel için temel URL (varsayılan: http://localhost:5273)
- `foundry.local.model` - Kullanılacak yapay zeka modeli (varsayılan: Phi-3.5-mini-instruct-cuda-gpu)

> **Not**: Yapılandırmadaki model adı, Foundry Yerel'in sisteminiz için indirdiği belirli varyantla eşleşmelidir. `foundry model run phi-3.5-mini` komutunu çalıştırdığınızda, Foundry Yerel en iyi varyantı otomatik olarak seçer ve indirir (NVIDIA GPU'lar için CUDA, aksi takdirde CPU sürümü). Yerel örneğinizde mevcut olan tam model adını görmek için `foundry model list` komutunu kullanın.

## Hızlı Başlangıç

### 1. Foundry Yerel uygulama dizinine gidin
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Uygulamayı Çalıştırın

```bash
mvn spring-boot:run
```

Ya da JAR dosyasını oluşturup çalıştırın:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Bağımlılıklar

Bu uygulama, Foundry Yerel ile iletişim kurmak için OpenAI Java SDK kullanır. Ana bağımlılık:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Uygulama, varsayılan portta çalışan Foundry Yerel'e bağlanacak şekilde önceden yapılandırılmıştır.

## Uygulamanın Yaptıkları

Uygulamayı çalıştırdığınızda:

1. **Başlatılır**: Komut satırı uygulaması olarak (web sunucusu yok)
2. **Otomatik olarak bir test mesajı gönderir**: "Merhaba! Bana ne olduğunu ve hangi modeli çalıştırdığını söyleyebilir misin?"
3. **Foundry Yerel'den gelen yanıtı** konsolda gösterir
4. **Temiz bir şekilde çıkar**: Demo tamamlandıktan sonra

## Örnek Çıktı

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Mimari

- **Application.java** - CommandLineRunner ile ana Spring Boot uygulaması
- **FoundryLocalService.java** - Foundry Yerel ile iletişim kurmak için OpenAI Java SDK kullanan servis
- **OpenAI Java SDK** kullanılarak tip güvenli API çağrıları
- SDK tarafından otomatik JSON serileştirme/deserileştirme
- Spring'in `@Value` ve `@PostConstruct` anotasyonları kullanılarak temiz yapılandırma

## Kod Öne Çıkanlar

### OpenAI Java SDK Entegrasyonu

Uygulama, Foundry Yerel için yapılandırılmış bir istemci oluşturmak üzere OpenAI Java SDK kullanır:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### Chat Completion API

Chat completion istekleri yapmak basit ve tip güvenlidir:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Sorun Giderme

Bağlantı hataları görürseniz:
1. Foundry Yerel'in `http://localhost:5273` adresinde çalıştığını doğrulayın
2. `foundry model list` komutuyla Phi-3.5-mini model varyantının mevcut olduğunu kontrol edin
3. `application.properties` dosyasındaki model adının listede gösterilen tam model adıyla eşleştiğinden emin olun
4. Hiçbir güvenlik duvarının bağlantıyı engellemediğinden emin olun

Yaygın sorunlar:
- **Model bulunamadı**: `foundry model run phi-3.5-mini` komutunu çalıştırarak modeli indirin ve başlatın
- **Hizmet çalışmıyor**: Foundry Yerel hizmeti durmuş olabilir; model çalıştırma komutuyla yeniden başlatın
- **Yanlış model adı**: Mevcut modelleri görmek için `foundry model list` komutunu kullanın ve yapılandırmanızı buna göre güncelleyin

**Feragatname**:  
Bu belge, AI çeviri hizmeti [Co-op Translator](https://github.com/Azure/co-op-translator) kullanılarak çevrilmiştir. Doğruluk için çaba göstersek de, otomatik çevirilerin hata veya yanlışlık içerebileceğini lütfen unutmayın. Belgenin orijinal dili, yetkili kaynak olarak kabul edilmelidir. Kritik bilgiler için profesyonel insan çevirisi önerilir. Bu çevirinin kullanımından kaynaklanan yanlış anlamalar veya yanlış yorumlamalar için sorumluluk kabul etmiyoruz.