# AGENTS.md

## Proje Genel Bakış

Bu, Java ile Generative AI geliştirmeyi öğrenmek için bir eğitim deposudur. Büyük Dil Modelleri (LLMs), prompt mühendisliği, gömme (embeddings), RAG (Retrieval-Augmented Generation) ve Model Context Protocol (MCP) gibi konuları kapsayan kapsamlı bir uygulamalı kurs sunar.

**Anahtar Teknolojiler:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Modelleri, Azure OpenAI ve OpenAI SDK'ları

**Mimari:**
- Bölümlere göre düzenlenmiş bağımsız Spring Boot uygulamaları
- Farklı AI desenlerini gösteren örnek projeler
- Önceden yapılandırılmış geliştirme konteynerleri ile GitHub Codespaces uyumlu

## Kurulum Komutları

### Ön Koşullar
- Java 21 veya üstü
- Maven 3.x
- GitHub kişisel erişim tokeni (GitHub Modelleri için)
- Opsiyonel: Azure OpenAI kimlik bilgileri

### Ortam Kurulumu

**Seçenek 1: GitHub Codespaces (Önerilen)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Seçenek 2: Yerel Geliştirme Konteyneri**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Seçenek 3: Yerel Kurulum**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Yapılandırma

**GitHub Token Kurulumu:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI Kurulumu (Opsiyonel):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Geliştirme İş Akışı

### Proje Yapısı
```
/
├── 01-IntroToGenAI/              # Chapter 1: Introduction
├── 02-SetupDevEnvironment/       # Chapter 2: Environment setup
│   └── examples/                 # Working examples
├── 03-CoreGenerativeAITechniques/ # Chapter 3: Core techniques
├── 04-PracticalSamples/          # Chapter 4: Sample projects
│   ├── calculator/               # MCP service example
│   ├── foundrylocal/            # Local model integration
│   └── petstory/                # Multi-modal app
├── 05-ResponsibleGenAI/         # Chapter 5: Responsible AI
└── translations/                # Multi-language support
```

### Uygulamaları Çalıştırma

**Bir Spring Boot uygulamasını çalıştırma:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Bir projeyi derleme:**
```bash
cd [project-directory]
mvn clean install
```

**MCP Hesaplayıcı Sunucusunu Başlatma:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**İstemci Örneklerini Çalıştırma:**
```bash
# After starting the server in another terminal
cd 04-PracticalSamples/calculator

# Direct MCP client
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"

# AI-powered client (requires GITHUB_TOKEN)
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"

# Interactive bot
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.Bot"
```

### Sıcak Yeniden Yükleme
Spring Boot DevTools, sıcak yeniden yüklemeyi destekleyen projelere dahil edilmiştir:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Test Talimatları

### Testleri Çalıştırma

**Bir projedeki tüm testleri çalıştırma:**
```bash
cd [project-directory]
mvn test
```

**Ayrıntılı çıktı ile testleri çalıştırma:**
```bash
mvn test -X
```

**Belirli bir test sınıfını çalıştırma:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Test Yapısı
- Test dosyaları JUnit 5 (Jupiter) kullanır
- Test sınıfları `src/test/java/` dizininde bulunur
- Hesaplayıcı projesindeki istemci örnekleri `src/test/java/com/microsoft/mcp/sample/client/` dizinindedir

### Manuel Test
Birçok örnek, manuel test gerektiren etkileşimli uygulamalardır:

1. Uygulamayı `mvn spring-boot:run` ile başlatın
2. Uç noktaları test edin veya CLI ile etkileşimde bulunun
3. Beklenen davranışın her projenin README.md dosyasındaki belgelerle eşleştiğini doğrulayın

### GitHub Modelleri ile Test
- Ücretsiz katman sınırları: 15 istek/dakika, 150/gün
- Maksimum 5 eşzamanlı istek
- Sorumlu AI örnekleriyle içerik filtrelemeyi test edin

## Kod Stili Yönergeleri

### Java Konvansiyonları
- **Java Versiyonu:** Modern özelliklerle Java 21
- **Stil:** Standart Java konvansiyonlarını takip edin
- **Adlandırma:** 
  - Sınıflar: PascalCase
  - Metotlar/değişkenler: camelCase
  - Sabitler: UPPER_SNAKE_CASE
  - Paket adları: küçük harf

### Spring Boot Desenleri
- İş mantığı için `@Service` kullanın
- REST uç noktaları için `@RestController` kullanın
- Yapılandırma `application.yml` veya `application.properties` üzerinden yapılır
- Sabit değerler yerine ortam değişkenlerini tercih edin
- MCP tarafından açığa çıkarılan metotlar için `@Tool` anotasyonunu kullanın

### Dosya Organizasyonu
```
src/
├── main/
│   ├── java/
│   │   └── com/microsoft/[component]/
│   │       ├── [Component]Application.java
│   │       ├── config/
│   │       ├── controller/
│   │       ├── service/
│   │       └── exception/
│   └── resources/
│       ├── application.yml
│       └── static/
└── test/
    └── java/
        └── com/microsoft/[component]/
```

### Bağımlılıklar
- Maven `pom.xml` ile yönetilir
- Spring AI BOM sürüm yönetimi için kullanılır
- AI entegrasyonları için LangChain4j
- Spring bağımlılıkları için Spring Boot starter parent

### Kod Yorumları
- Genel API'ler için JavaDoc ekleyin
- Karmaşık AI etkileşimleri için açıklayıcı yorumlar ekleyin
- MCP araç açıklamalarını net bir şekilde belgeleyin

## Derleme ve Dağıtım

### Projeleri Derleme

**Testler olmadan derleme:**
```bash
mvn clean install -DskipTests
```

**Tüm kontrollerle derleme:**
```bash
mvn clean install
```

**Uygulamayı paketleme:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Çıktı Dizinleri
- Derlenmiş sınıflar: `target/classes/`
- Test sınıfları: `target/test-classes/`
- JAR dosyaları: `target/*.jar`
- Maven artefaktları: `target/`

### Ortama Özgü Yapılandırma

**Geliştirme:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Üretim:**
- GitHub Modelleri yerine Azure AI Foundry Modelleri kullanın
- Temel URL'yi Azure OpenAI uç noktasına güncelleyin
- Azure Key Vault veya ortam değişkenleri ile gizlilikleri yönetin

### Dağıtım Düşünceleri
- Bu, örnek uygulamalar içeren bir eğitim deposudur
- Olduğu gibi üretim dağıtımı için tasarlanmamıştır
- Örnekler, üretim kullanımı için uyarlanacak desenleri gösterir
- Bireysel proje README'lerinde spesifik dağıtım notlarına bakın

## Ek Notlar

### GitHub Modelleri vs Azure OpenAI
- **GitHub Modelleri:** Öğrenme için ücretsiz katman, kredi kartı gerektirmez
- **Azure OpenAI:** Üretime hazır, Azure aboneliği gerektirir
- Kod her ikisiyle uyumludur - sadece uç noktayı ve API anahtarını değiştirin

### Birden Fazla Proje ile Çalışma
Her örnek proje bağımsızdır:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Yaygın Sorunlar

**Java Versiyon Uyumsuzluğu:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Bağımlılık İndirme Sorunları:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub Token Bulunamadı:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Port Zaten Kullanımda:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Çok Dilli Destek
- Belgeler, otomatik çeviri ile 45+ dilde mevcuttur
- Çeviriler `translations/` dizininde bulunur
- Çeviri, GitHub Actions iş akışı tarafından yönetilir

### Öğrenme Yolu
1. [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md) ile başlayın
2. Bölümleri sırayla takip edin (01 → 05)
3. Her bölümdeki uygulamalı örnekleri tamamlayın
4. Bölüm 4'teki örnek projeleri keşfedin
5. Bölüm 5'te sorumlu AI uygulamalarını öğrenin

### Geliştirme Konteyneri
`.devcontainer/devcontainer.json` şunları yapılandırır:
- Java 21 geliştirme ortamı
- Önceden yüklenmiş Maven
- VS Code Java uzantıları
- Spring Boot araçları
- GitHub Copilot entegrasyonu
- Docker içinde Docker desteği
- Azure CLI

### Performans Düşünceleri
- GitHub Modelleri ücretsiz katmanında hız sınırları vardır
- Gömme işlemleri için uygun toplu boyutları kullanın
- Tekrarlanan API çağrıları için önbelleği düşünün
- Maliyet optimizasyonu için token kullanımını izleyin

### Güvenlik Notları
- `.env` dosyalarını asla commit etmeyin (zaten `.gitignore` içinde)
- API anahtarları için ortam değişkenlerini kullanın
- GitHub tokenleri minimum gerekli kapsamlarla sınırlı olmalıdır
- Bölüm 5'teki sorumlu AI yönergelerini takip edin

---

**Feragatname**:  
Bu belge, AI çeviri hizmeti [Co-op Translator](https://github.com/Azure/co-op-translator) kullanılarak çevrilmiştir. Doğruluk için çaba göstersek de, otomatik çevirilerin hata veya yanlışlık içerebileceğini lütfen unutmayın. Belgenin orijinal dili, yetkili kaynak olarak kabul edilmelidir. Kritik bilgiler için profesyonel insan çevirisi önerilir. Bu çevirinin kullanımından kaynaklanan yanlış anlamalar veya yanlış yorumlamalar için sorumluluk kabul edilmez.