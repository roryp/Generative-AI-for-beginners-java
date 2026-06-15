# Foundry Local Spring Boot Eğitimi

## İçindekiler

- [Önkoşullar](#önkoşullar)
- [Proje Genel Bakış](#proje-genel-bakış)
- [Kodu Anlamak](#kodu-anlamak)
  - [1. Uygulama Yapılandırması (application.properties)](#1-uygulama-yapılandırması-applicationproperties)
  - [2. Ana Uygulama Sınıfı (Application.java)](#2-ana-uygulama-sınıfı-applicationjava)
  - [3. AI Servis Katmanı (FoundryLocalService.java)](#3-ai-servis-katmanı-foundrylocalservicejava)
  - [4. Proje Bağımlılıkları (pom.xml)](#4-proje-bağımlılıkları-pomxml)
- [Hepsi Birlikte Nasıl Çalışır](#hepsi-birlikte-nasıl-çalışır)
- [Foundry Local Kurulumu](#foundry-local-kurulumu-1)
- [Uygulamayı Çalıştırma](#uygulamayı-çalıştırma)
- [Beklenen Çıktı](#beklenen-çıktı)
- [Sonraki Adımlar](#sonraki-adımlar)
- [Sorun Giderme](#sorun-giderme)


## Önkoşullar

Bu eğitimi başlatmadan önce, şunların kurulu olduğundan emin olun:

- Sisteminizde **Java 21 veya üzeri**
- Projeyi derlemek için **Maven 3.6+**
- **Foundry Local** kurulu ve çalışır durumda

### **Foundry Local Kurulumu:**

> **Not:** Foundry Local CLI sadece **Windows** ve **macOS** için mevcuttur. Linux, [Foundry Local SDK’ları](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust) aracılığıyla desteklenir.

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Kurulumu doğrulayın:
```bash
foundry --version
```

## Proje Genel Bakış

Bu proje dört ana bileşenden oluşur:

1. **Application.java** - Ana Spring Boot uygulaması giriş noktası
2. **FoundryLocalService.java** - AI iletişimini yöneten servis katmanı
3. **application.properties** - Foundry Local bağlantısı için yapılandırma
4. **pom.xml** - Maven bağımlılıkları ve proje yapılandırması

## Kodu Anlamak

### 1. Uygulama Yapılandırması (application.properties)

**Dosya:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Yaptıkları:**
- **base-url**: Foundry Local'ın nerede çalıştığını belirtir, OpenAI API uyumluluğu için `/v1` yolunu içerir. Varsayılan port `5273`'tür. Port farklıysa, `foundry service status` komutuyla kontrol edin.
- **model** (isteğe bağlı): Metin üretimi için kullanılacak AI modelinin adını belirtir. **Varsayılan olarak, uygulama başlangıçta Foundry Local `/v1/models` endpoint'ini sorgulayarak modeli otomatik algılar**, bu yüzden bunu ayarlamanıza gerek yoktur. Gerekirse, bu ayarı açıkça belirterek otomatik algılamanın üzerine yazabilirsiniz.

**Önemli kavram:** Spring Boot bu özellikleri otomatik olarak yükler ve `@Value` anotasyonu ile uygulamanıza sağlar.

### 2. Ana Uygulama Sınıfı (Application.java)

**Dosya:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Web sunucusuna gerek yok
        app.run(args);
    }
```

**Yaptıkları:**
- `@SpringBootApplication` Spring Boot otomatik yapılandırmayı etkinleştirir
- `WebApplicationType.NONE` Spring’e bunun bir web sunucusu değil, komut satırı uygulaması olduğunu söyler
- main metodu Spring uygulamasını başlatır

**Demo Çalıştırıcı:**
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

**Yaptıkları:**
- `@Bean` Spring tarafından yönetilen bir bileşen oluşturur
- `CommandLineRunner` Spring Boot başlatıldıktan sonra kod çalıştırır
- `foundryLocalService` Spring tarafından otomatik enjekte edilir (bağımlılık enjeksiyonu)
- AI’ye test mesajı gönderir ve yanıtı gösterir

### 3. AI Servis Katmanı (FoundryLocalService.java)

**Dosya:** `src/main/java/com/example/FoundryLocalService.java`

#### Yapılandırma Enjeksiyonu:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Boşsa otomatik olarak algılandı
```

**Yaptıkları:**
- `@Service` Spring’e bu sınıfın iş mantığı sağladığını bildirir
- `@Value` application.properties’den yapılandırma değerlerini enjekte eder
- Model boşsa, bu **başlangıçta Foundry Local’dan otomatik algılamayı** tetikler. Bu sayede uygulama Foundry Local’da yüklü herhangi bir modelle manuel yapılandırma gerektirmeden çalışır.

#### İstemci Başlatma:
```java
@PostConstruct
public void init() {
    // Açıkça yapılandırılmamışsa Foundry Local'den modeli otomatik algıla
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Temel URL yapılandırmadan dolayı zaten /v1 içeriyor
            .apiKey("not-needed")            // Yerel sunucunun gerçek API anahtarına ihtiyacı yok
            .build();
}
```

**Yaptıkları:**
- `@PostConstruct` metod, servis oluşturulduktan sonra çalıştırılır
- Eğer model yapılandırılmamışsa, Foundry Local’ın `/v1/models` endpoint’ini sorgular ve ilk yüklü modeli seçer
- Foundry Local örneğinize bağlanan bir OpenAI istemcisi oluşturur
- application.properties’deki temel URL zaten OpenAI API için uyumlu olan `/v1` yolunu içerir
- API anahtarı "not-needed" olarak ayarlanır çünkü yerel geliştirmede kimlik doğrulama gerekmez

#### Chat Metodu:
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

**Yaptıkları:**
- **ChatCompletionCreateParams**: AI isteğini yapılandırır
  - `model`: Hangi AI modelinin kullanılacağını belirtir (tam `foundry model list` ID’si ile eşleşmeli)
  - `addUserMessage`: Sohbete sizin mesajınızı ekler
  - `maxCompletionTokens`: Yanıtın uzunluğunu sınırlar (kaynak tasarrufu sağlar)
  - `temperature`: Rastgeleliği kontrol eder (0.0 = deterministik, 1.0 = yaratıcı)
- **API Çağrısı**: İsteği Foundry Local’a gönderir
- **Yanıt İşleme**: AI’nin metin yanıtını güvenli şekilde çıkarır
- **Hata Yönetimi**: İstisnaları açıklayıcı hata mesajlarıyla sarar

### 4. Proje Bağımlılıkları (pom.xml)

**Ana Bağımlılıklar:**

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

**Ne işe yararlar:**
- **spring-boot-starter**: Temel Spring Boot fonksiyonelliği sağlar
- **openai-java**: OpenAI Java SDK resmi API iletişimi için
- **jackson-databind**: API çağrıları için JSON serileştirme/deseriler

## Hepsi Birlikte Nasıl Çalışır

Uygulamayı çalıştırdığınızda tam akış şöyle olur:

1. **Başlangıç**: Spring Boot başlar ve `application.properties` dosyasını okur
2. **Servis Oluşumu**: Spring `FoundryLocalService` oluşturur ve yapılandırma değerlerini enjekte eder
3. **Model Algılama**: Model ayarlı değilse, servis Foundry Local’ın `/v1/models` endpoint’ini sorgular ve otomatik olarak ilk modeli kullanır
4. **İstemci Kurulumu**: `@PostConstruct` OpenAI istemcisini Foundry Local’a bağlanacak şekilde başlatır
5. **Demo Çalıştırma**: `CommandLineRunner` başlatma sonrası çalışır
6. **AI Çağrısı**: Demo, `foundryLocalService.chat()` metodunu test mesajıyla çağırır
7. **API İsteği**: Servis OpenAI uyumlu isteği Foundry Local’a gönderir
8. **Yanıt İşleme**: Servis AI yanıtını çıkartır ve döndürür
9. **Gösterim**: Uygulama yanıtı yazdırır ve çıkar

## Foundry Local Kurulumu

1. [Önkoşullar](#önkoşullar) bölümündeki talimatlarla **Foundry Local**’ı kurun.

2. **Servisi başlatın** (eğer zaten çalışmıyorsa):
   ```bash
   foundry service start
   ```

3. Servisin çalıştığını doğrulamak için **durumunu kontrol edin** ve portu not alın:
   ```bash
   foundry service status
   ```

4. **Bir model indirin ve çalıştırın** (ilk çalıştırmada indirilir, sonraki çalıştırmalarda önbellekten kullanılır):
   ```bash
   foundry model run phi-4-mini
   ```
   Bu, etkileşimli bir sohbet oturumu açar. `Ctrl+C` ile çıkabilirsiniz. Model servis içinde yüklü kalır.

   > **İpucu:** Tüm mevcut modelleri görmek için `foundry model list` çalıştırın. `phi-4-mini` yerine katalogdaki herhangi bir takma adı kullanabilirsiniz (örn. daha küçük/daha hızlı bir model için `qwen2.5-0.5b`).

5. Modelin yüklendiğini doğrulayın:
   ```bash
   foundry service ps
   ```

6. Gerekirse `application.properties` dosyasını güncelleyin:
   - Varsayılan `base-url` (`http://localhost:5273/v1`), varsayılan CLI portuyla aynıdır. Sadece `foundry service status` farklı bir port gösterirse değiştirin.
   - Model **başlangıçta otomatik algılanır** — yapılandırmaya gerek yoktur.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Uygulamayı Çalıştırma

### Adım 1: Foundry Local’da bir model yüklendiğinden emin olun
```bash
foundry service ps
```
Yüklenmiş model yoksa, bir model yükleyin:
```bash
foundry model run phi-4-mini
```

### Adım 2: Uygulamayı Derleyin ve Çalıştırın
Başka bir terminalde:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Ya da JAR dosyası olarak derleyip çalıştırın:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Beklenen Çıktı

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## Sonraki Adımlar

Daha fazla örnek için [Bölüm 04: Pratik örnekler](../README.md) sayfasına bakın.

## Sorun Giderme

### Yaygın Sorunlar

**"Connection refused" veya "Service unavailable"**
- Servisi kontrol edin: `foundry service status`
- Gerekirse yeniden başlatın: `foundry service restart`
- `application.properties` içindeki portun `foundry service status` çıktısıyla eşleştiğinden emin olun
- URL'nin `/v1` ile bittiğini doğrulayın: `http://localhost:5273/v1`

**Başlangıçta "No model found" hatası**
- Uygulama modeli otomatik algılar. En az bir model yüklü olduğundan emin olun: `foundry service ps`
- Model yoksa yükleyin: `foundry model run phi-4-mini`
- Eğer `application.properties` içinde model adını değiştirdiyseniz, `foundry model list` ile eşleştiğini kontrol edin

**"400 Bad Request" hataları**
- Base URL'nin `/v1` ile bittiğinden emin olun: `http://localhost:5273/v1`
- Kodunuzda `maxCompletionTokens()` kullanın (eski `maxTokens()` kullanılmamalıdır)

**Maven derleme hataları**
- Java 21 veya üzeri kullanıldığından emin olun: `java -version`
- Temizleyip yeniden derleyin: `mvn clean compile`
- Bağımlılık indirmek için internet bağlantınızı kontrol edin

**Servis bağlantı sorunları**
- `Request to local service failed` hatası alırsanız: `foundry service restart` yapın
- Yüklü modelleri kontrol edin: `foundry service ps`
- Servis günlüklerini görüntüleyin: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Feragatname**:  
Bu belge, [Co-op Translator](https://github.com/Azure/co-op-translator) adlı Yapay Zeka çeviri hizmeti kullanılarak çevrilmiştir. Doğruluk için çaba gösterilse de, otomatik çevirilerin hatalar veya yanlışlıklar içerebileceğini lütfen unutmayın. Orijinal belge, kendi ana dilinde yetkili kaynak olarak kabul edilmelidir. Kritik bilgiler için profesyonel insan çevirisi önerilir. Bu çevirinin kullanımı sonucu oluşabilecek yanlış anlamalar veya yanlış yorumlamalar için sorumluluk kabul etmiyoruz.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->