<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "713d81fd7d28a865068df047e26c8f12",
  "translation_date": "2025-11-03T20:06:57+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "tr"
}
-->
# Foundry Local Spring Boot Eğitimi

## İçindekiler

- [Ön Koşullar](../../../../04-PracticalSamples/foundrylocal)
- [Proje Genel Bakış](../../../../04-PracticalSamples/foundrylocal)
- [Kodun Anlaşılması](../../../../04-PracticalSamples/foundrylocal)
  - [1. Uygulama Konfigürasyonu (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Ana Uygulama Sınıfı (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI Servis Katmanı (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Proje Bağımlılıkları (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Her Şeyin Birlikte Çalışması](../../../../04-PracticalSamples/foundrylocal)
- [Foundry Local Kurulumu](../../../../04-PracticalSamples/foundrylocal)
- [Uygulamayı Çalıştırma](../../../../04-PracticalSamples/foundrylocal)
- [Beklenen Çıktı](../../../../04-PracticalSamples/foundrylocal)
- [Sonraki Adımlar](../../../../04-PracticalSamples/foundrylocal)
- [Sorun Giderme](../../../../04-PracticalSamples/foundrylocal)

## Ön Koşullar

Bu eğitime başlamadan önce aşağıdakilere sahip olduğunuzdan emin olun:

- Sisteminizde **Java 21 veya üstü** yüklü
- Projeyi derlemek için **Maven 3.6+**
- **Foundry Local** yüklü ve çalışır durumda

### **Foundry Local Kurulumu:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## Proje Genel Bakış

Bu proje dört ana bileşenden oluşur:

1. **Application.java** - Ana Spring Boot uygulama giriş noktası
2. **FoundryLocalService.java** - AI iletişimini yöneten servis katmanı
3. **application.properties** - Foundry Local bağlantı konfigürasyonu
4. **pom.xml** - Maven bağımlılıkları ve proje konfigürasyonu

## Kodun Anlaşılması

### 1. Uygulama Konfigürasyonu (application.properties)

**Dosya:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**Ne yapar:**
- **base-url**: Foundry Local'ın çalıştığı yeri belirtir, `/v1` yolu OpenAI API uyumluluğu için dahildir. **Not**: Foundry Local dinamik olarak bir port atar, bu yüzden `foundry service status` komutuyla gerçek portunuzu kontrol edin.
- **model**: Metin üretimi için kullanılacak AI modelinin adını ve sürüm numarasını belirtir (örneğin, `:1`). Kullanılabilir modelleri ve tam kimliklerini görmek için `foundry model list` komutunu kullanın.

**Anahtar kavram:** Spring Boot bu özellikleri otomatik olarak yükler ve `@Value` anotasyonu kullanılarak uygulamanıza erişilebilir hale getirir.

### 2. Ana Uygulama Sınıfı (Application.java)

**Dosya:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```

**Ne yapar:**
- `@SpringBootApplication` Spring Boot otomatik yapılandırmasını etkinleştirir.
- `WebApplicationType.NONE` Spring'e bunun bir komut satırı uygulaması olduğunu, bir web sunucusu olmadığını söyler.
- Ana metot Spring uygulamasını başlatır.

**Demo Çalıştırıcı:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
    };
}
```

**Ne yapar:**
- `@Bean` Spring'in yönettiği bir bileşen oluşturur.
- `CommandLineRunner` Spring Boot başlatıldıktan sonra kodu çalıştırır.
- `foundryLocalService` Spring tarafından otomatik olarak enjekte edilir (bağımlılık enjeksiyonu).
- AI'ya bir test mesajı gönderir ve yanıtı görüntüler.

### 3. AI Servis Katmanı (FoundryLocalService.java)

**Dosya:** `src/main/java/com/example/FoundryLocalService.java`

#### Konfigürasyon Enjeksiyonu:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```

**Ne yapar:**
- `@Service` Spring'e bu sınıfın iş mantığı sağladığını söyler.
- `@Value` application.properties dosyasından konfigürasyon değerlerini enjekte eder.
- `:default-value` sözdizimi, özellikler ayarlanmadığında yedek değerler sağlar.

#### İstemci Başlatma:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```

**Ne yapar:**
- `@PostConstruct` bu metodu Spring servisi oluşturduktan sonra çalıştırır.
- Yerel Foundry Local instance'ına işaret eden bir OpenAI istemcisi oluşturur.
- `application.properties` dosyasındaki base URL zaten OpenAI API uyumluluğu için `/v1` içerir.
- API anahtarı "not-needed" olarak ayarlanır çünkü yerel geliştirme kimlik doğrulama gerektirmez.

#### Sohbet Metodu:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Which AI model to use
                .addUserMessage(message)         // Your question/prompt
                .maxTokens(150)                  // Limit response length
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

**Ne yapar:**
- **ChatCompletionCreateParams**: AI isteğini yapılandırır
  - `model`: Kullanılacak AI modelini belirtir (tam kimlik `foundry model list` ile eşleşmelidir)
  - `addUserMessage`: Mesajınızı konuşmaya ekler
  - `maxTokens`: Yanıtın uzunluğunu sınırlar (kaynakları korur)
  - `temperature`: Rastgeleliği kontrol eder (0.0 = deterministik, 1.0 = yaratıcı)
- **API Çağrısı**: İsteği Foundry Local'a gönderir.
- **Yanıt İşleme**: AI'nın metin yanıtını güvenli bir şekilde çıkarır.
- **Hata İşleme**: Hataları yardımcı hata mesajlarıyla sarar.

### 4. Proje Bağımlılıkları (pom.xml)

**Anahtar Bağımlılıklar:**

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

**Ne yapar:**
- **spring-boot-starter**: Temel Spring Boot işlevselliğini sağlar.
- **openai-java**: OpenAI Java SDK'sı ile API iletişimi sağlar.
- **jackson-databind**: API çağrıları için JSON serileştirme/deserileştirme işlemlerini yönetir.

## Her Şeyin Birlikte Çalışması

Uygulamayı çalıştırdığınızda işleyiş şu şekildedir:

1. **Başlangıç**: Spring Boot başlar ve `application.properties` dosyasını okur.
2. **Servis Oluşturma**: Spring `FoundryLocalService` oluşturur ve konfigürasyon değerlerini enjekte eder.
3. **İstemci Ayarı**: `@PostConstruct` OpenAI istemcisini Foundry Local'a bağlanacak şekilde başlatır.
4. **Demo Çalıştırma**: `CommandLineRunner` başlangıçtan sonra çalışır.
5. **AI Çağrısı**: Demo, `foundryLocalService.chat()` ile bir test mesajı gönderir.
6. **API İsteği**: Servis, OpenAI uyumlu isteği Foundry Local'a gönderir.
7. **Yanıt İşleme**: Servis yanıtı çıkarır ve döndürür.
8. **Görüntüleme**: Uygulama yanıtı yazdırır ve çıkar.

## Foundry Local Kurulumu

Foundry Local'ı kurmak için şu adımları izleyin:

1. **Foundry Local'ı yükleyin** [Ön Koşullar](../../../../04-PracticalSamples/foundrylocal) bölümündeki talimatları izleyerek.

2. **Dinamik olarak atanan portu kontrol edin**. Foundry Local başlatıldığında otomatik olarak bir port atar. Portunuzu şu komutla bulun:
   ```bash
   foundry service status
   ```
   
   **Opsiyonel**: Belirli bir port kullanmayı tercih ederseniz (örneğin, 5273), bunu manuel olarak yapılandırabilirsiniz:
   ```bash
   foundry service set --port 5273
   ```

3. **Kullanmak istediğiniz AI modelini indirin**, örneğin `phi-3.5-mini`, şu komutla:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **application.properties** dosyasını Foundry Local ayarlarınıza uygun şekilde yapılandırın:
   - `base-url` içindeki portu güncelleyin (adım 2'den), `/v1` sonunda olduğundan emin olun.
   - Model adını sürüm numarasını içerecek şekilde güncelleyin (`foundry model list` ile kontrol edin).

   Örnek:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```

## Uygulamayı Çalıştırma

### Adım 1: Foundry Local'ı Başlatın
```bash
foundry model run phi-3.5-mini
```

### Adım 2: Uygulamayı Derleyin ve Çalıştırın
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
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```

## Sonraki Adımlar

Daha fazla örnek için [Bölüm 04: Pratik örnekler](../README.md) bölümüne bakın.

## Sorun Giderme

### Yaygın Sorunlar

**"Bağlantı reddedildi" veya "Servis kullanılamıyor"**
- Foundry Local'ın çalıştığından emin olun: `foundry model list`
- Foundry Local'ın kullandığı gerçek portu kontrol edin: `foundry service status`
- `application.properties` dosyanızı doğru portla güncelleyin, URL'nin `/v1` ile bittiğinden emin olun.
- Alternatif olarak, belirli bir port ayarlayın: `foundry service set --port 5273`
- Foundry Local'ı yeniden başlatmayı deneyin: `foundry model run phi-3.5-mini`

**"Model bulunamadı" veya "404 Not Found" hataları**
- Kullanılabilir modelleri ve tam kimliklerini kontrol edin: `foundry model list`
- `application.properties` dosyasındaki model adını tam olarak eşleşecek şekilde güncelleyin, sürüm numarasını dahil ederek (örneğin, `Phi-3.5-mini-instruct-cuda-gpu:1`).
- `base-url`'ün `/v1` ile bittiğinden emin olun: `http://localhost:5273/v1`
- Gerekirse modeli indirin: `foundry model run phi-3.5-mini`

**"400 Bad Request" hataları**
- Base URL'nin `/v1` içerdiğinden emin olun: `http://localhost:5273/v1`
- Model kimliğinin `foundry model list` ile tam olarak eşleştiğini kontrol edin.
- Kodunuzda `maxTokens()` yerine `maxCompletionTokens()` kullandığınızdan emin olun.

**Maven derleme hataları**
- Java 21 veya üstü olduğundan emin olun: `java -version`
- Temizleyin ve yeniden derleyin: `mvn clean compile`
- Bağımlılık indirmeleri için internet bağlantınızı kontrol edin.

**Uygulama başlıyor ama çıktı yok**
- Foundry Local'ın yanıt verdiğinden emin olun: Tarayıcıda `http://localhost:5273` adresini açın.
- Uygulama günlüklerini belirli hata mesajları için kontrol edin.
- Modelin tamamen yüklendiğinden ve hazır olduğundan emin olun.

---

**Feragatname**:  
Bu belge, AI çeviri hizmeti [Co-op Translator](https://github.com/Azure/co-op-translator) kullanılarak çevrilmiştir. Doğruluk için çaba göstersek de, otomatik çevirilerin hata veya yanlışlıklar içerebileceğini lütfen unutmayın. Belgenin orijinal dili, yetkili kaynak olarak kabul edilmelidir. Kritik bilgiler için profesyonel insan çevirisi önerilir. Bu çevirinin kullanımından kaynaklanan yanlış anlamalar veya yanlış yorumlamalar için sorumluluk kabul etmiyoruz.