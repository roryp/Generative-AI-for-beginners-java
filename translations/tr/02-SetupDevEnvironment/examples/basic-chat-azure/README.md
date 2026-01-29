# Azure OpenAI ile Temel Sohbet - Uçtan Uca Örnek

Bu örnek, Azure OpenAI'ye bağlanan ve kurulumunuzu test eden basit bir Spring Boot uygulamasının nasıl oluşturulacağını gösterir.

## İçindekiler

- [Ön Koşullar](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Hızlı Başlangıç](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Yapılandırma Seçenekleri](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Seçenek 1: Ortam Değişkenleri (.env dosyası) - Önerilen](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Seçenek 2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Uygulamayı Çalıştırma](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Maven Kullanarak](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [VS Code Kullanarak](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Beklenen Çıktı](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Yapılandırma Referansı](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Ortam Değişkenleri](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring Yapılandırması](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Sorun Giderme](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Yaygın Sorunlar](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Hata Ayıklama Modu](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Sonraki Adımlar](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Kaynaklar](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Ön Koşullar

Bu örneği çalıştırmadan önce şunları tamamladığınızdan emin olun:

- [Azure OpenAI kurulum kılavuzunu](../../getting-started-azure-openai.md) tamamladınız  
- Azure OpenAI kaynağını dağıttınız (Azure AI Foundry portalı üzerinden)  
- gpt-4o-mini modelini (veya alternatifini) dağıttınız  
- Azure'dan API anahtarı ve uç nokta URL'sini aldınız  

## Hızlı Başlangıç

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Yapılandırma Seçenekleri

### Seçenek 1: Ortam Değişkenleri (.env dosyası) - Önerilen

**Adım 1: Yapılandırma dosyanızı oluşturun**  
```bash
cp .env.example .env
```

**Adım 2: Azure OpenAI kimlik bilgilerinizi ekleyin**  
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Güvenlik Notu**:  
> - `.env` dosyanızı asla sürüm kontrolüne göndermeyin  
> - `.env` dosyası zaten `.gitignore` içinde yer alıyor  
> - API anahtarlarınızı güvende tutun ve düzenli olarak yenileyin  

### Seçenek 2: GitHub Codespace Secrets

GitHub Codespaces için, bu sırları depoda ayarlayın:  
- `AZURE_AI_KEY` - Azure OpenAI API anahtarınız  
- `AZURE_AI_ENDPOINT` - Azure OpenAI uç nokta URL'niz  

Uygulama bu sırları otomatik olarak algılar ve kullanır.

### Alternatif: Doğrudan Ortam Değişkenleri

<details>
<summary>Platforma özel komutları görmek için tıklayın</summary>

**Linux/macOS (bash/zsh):**  
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Komut İstemi):**  
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**  
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## Uygulamayı Çalıştırma

### Maven Kullanarak

```bash
mvn spring-boot:run
```

### VS Code Kullanarak

1. Projeyi VS Code'da açın  
2. `F5` tuşuna basın veya "Çalıştır ve Hata Ayıkla" panelini kullanın  
3. "Spring Boot-BasicChatApplication" yapılandırmasını seçin  

> **Not**: VS Code yapılandırması `.env` dosyanızı otomatik olarak yükler  

### Beklenen Çıktı

```
Starting Basic Chat with Azure OpenAI...
Environment variables loaded successfully
Connecting to Azure OpenAI...
Sending prompt: What is AI in a short sentence? Max 100 words.

AI Response:
================
AI, or Artificial Intelligence, is the simulation of human intelligence in machines programmed to think and learn like humans.
================

Success! Azure OpenAI connection is working correctly.
```

## Yapılandırma Referansı

### Ortam Değişkenleri

| Değişken | Açıklama | Gerekli | Örnek |
|----------|----------|---------|-------|
| `AZURE_AI_KEY` | Azure OpenAI API anahtarı | Evet | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI uç nokta URL'si | Evet | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Model dağıtım adı | Hayır | `gpt-4o-mini` (varsayılan) |

### Spring Yapılandırması

`application.yml` dosyası şunları yapılandırır:  
- **API Anahtarı**: `${AZURE_AI_KEY}` - Ortam değişkeninden  
- **Uç Nokta**: `${AZURE_AI_ENDPOINT}` - Ortam değişkeninden  
- **Model**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Ortam değişkeninden, varsayılan değerle  
- **Temperature**: `0.7` - Yaratıcılığı kontrol eder (0.0 = deterministik, 1.0 = yaratıcı)  
- **Max Tokens**: `500` - Maksimum yanıt uzunluğu  

## Sorun Giderme

### Yaygın Sorunlar

<details>
<summary><strong>Hata: "API anahtarı geçerli değil"</strong></summary>

- `AZURE_AI_KEY` değerinizin `.env` dosyasında doğru ayarlandığından emin olun  
- API anahtarının Azure AI Foundry portalından tam olarak kopyalandığını doğrulayın  
- Anahtarın etrafında fazladan boşluk veya tırnak işareti olmadığından emin olun  
</details>

<details>
<summary><strong>Hata: "Uç nokta geçerli değil"</strong></summary>

- `AZURE_AI_ENDPOINT` değerinizin tam URL'yi içerdiğinden emin olun (ör. `https://your-hub-name.openai.azure.com/`)  
- Sondaki eğik çizgi tutarlılığını kontrol edin  
- Uç noktanın Azure dağıtım bölgenizle eşleştiğini doğrulayın  
</details>

<details>
<summary><strong>Hata: "Dağıtım bulunamadı"</strong></summary>

- Model dağıtım adınızın Azure'da dağıtılan adla tam olarak eşleştiğini doğrulayın  
- Modelin başarıyla dağıtıldığından ve aktif olduğundan emin olun  
- Varsayılan dağıtım adını deneyin: `gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code: Ortam değişkenleri yüklenmiyor</strong></summary>

- `.env` dosyanızın proje kök dizininde olduğundan emin olun (`pom.xml` ile aynı seviyede)  
- VS Code'un entegre terminalinde `mvn spring-boot:run` komutunu çalıştırmayı deneyin  
- VS Code Java uzantısının düzgün yüklendiğini kontrol edin  
- Başlatma yapılandırmasının `"envFile": "${workspaceFolder}/.env"` içerdiğini doğrulayın  
</details>

### Hata Ayıklama Modu

Detaylı günlük kaydını etkinleştirmek için `application.yml` dosyasındaki şu satırları yorumdan çıkarın:  

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Sonraki Adımlar

**Kurulum Tamamlandı!** Öğrenme yolculuğunuza devam edin:  

[3. Bölüm: Temel Üretken Yapay Zeka Teknikleri](../../../03-CoreGenerativeAITechniques/README.md)

## Kaynaklar

- [Spring AI Azure OpenAI Dokümantasyonu](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [Azure OpenAI Servis Dokümantasyonu](https://learn.microsoft.com/azure/ai-services/openai/)  
- [Azure AI Foundry Portalı](https://ai.azure.com/)  
- [Azure AI Foundry Dokümantasyonu](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**Feragatname**:  
Bu belge, AI çeviri hizmeti [Co-op Translator](https://github.com/Azure/co-op-translator) kullanılarak çevrilmiştir. Doğruluk için çaba göstersek de, otomatik çevirilerin hata veya yanlışlık içerebileceğini lütfen unutmayın. Belgenin orijinal dili, yetkili kaynak olarak kabul edilmelidir. Kritik bilgiler için profesyonel insan çevirisi önerilir. Bu çevirinin kullanımından kaynaklanan yanlış anlamalar veya yanlış yorumlamalar için sorumluluk kabul etmiyoruz.