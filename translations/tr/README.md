<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:26:39+00:00",
  "source_file": "README.md",
  "language_code": "tr"
}
-->
# Başlangıç Seviyesi Üretken Yapay Zeka - Java Sürümü
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Başlangıç Seviyesi Üretken Yapay Zeka - Java Sürümü](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.tr.png)

**Zaman Taahhüdü**: Tüm atölye çalışması yerel kurulum gerektirmeden çevrimiçi olarak tamamlanabilir. Ortam kurulumu 2 dakika sürer, örnekleri keşfetmek ise keşif derinliğine bağlı olarak 1-3 saat alabilir.

> **Hızlı Başlangıç**

1. Bu depoyu GitHub hesabınıza çatallayın
2. **Code** → **Codespaces** sekmesi → **...** → **New with options...** seçeneğine tıklayın
3. Varsayılan ayarları kullanın – bu, bu kurs için oluşturulan Geliştirme konteynerini seçecektir
4. **Create codespace** butonuna tıklayın
5. Ortamın hazır olması için yaklaşık 2 dakika bekleyin
6. Doğrudan [İlk örneğe geçin](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Çok Dilli Destek

### GitHub Action ile Desteklenir (Otomatik ve Her Zaman Güncel)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](../my/README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../br/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Thai](../th/README.md) | [Turkish](./README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Kurs Yapısı ve Öğrenme Yolu

### **Bölüm 1: Üretken Yapay Zekaya Giriş**
- **Temel Kavramlar**: Büyük Dil Modellerini, tokenları, gömüleri ve yapay zeka yeteneklerini anlama
- **Java Yapay Zeka Ekosistemi**: Spring AI ve OpenAI SDK'larının genel bakışı
- **Model Context Protocol**: MCP'nin ve yapay zeka ajan iletişimindeki rolünün tanıtımı
- **Pratik Uygulamalar**: Sohbet botları ve içerik üretimi gibi gerçek dünya senaryoları
- **[→ Bölüm 1'e Başla](./01-IntroToGenAI/README.md)**

### **Bölüm 2: Geliştirme Ortamı Kurulumu**
- **Çoklu Sağlayıcı Konfigürasyonu**: GitHub Modelleri, Azure OpenAI ve OpenAI Java SDK entegrasyonlarını ayarlama
- **Spring Boot + Spring AI**: Kurumsal yapay zeka uygulama geliştirme için en iyi uygulamalar
- **GitHub Modelleri**: Prototipleme ve öğrenme için ücretsiz yapay zeka modeli erişimi (kredi kartı gerekmez)
- **Geliştirme Araçları**: Docker konteynerleri, VS Code ve GitHub Codespaces konfigürasyonu
- **[→ Bölüm 2'ye Başla](./02-SetupDevEnvironment/README.md)**

### **Bölüm 3: Temel Üretken Yapay Zeka Teknikleri**
- **Prompt Mühendisliği**: Yapay zeka modeli yanıtlarını optimize etme teknikleri
- **Gömüler ve Vektör İşlemleri**: Anlamsal arama ve benzerlik eşleştirme uygulama
- **Retrieval-Augmented Generation (RAG)**: Yapay zekayı kendi veri kaynaklarınızla birleştirme
- **Fonksiyon Çağrısı**: Yapay zeka yeteneklerini özel araçlar ve eklentilerle genişletme
- **[→ Bölüm 3'e Başla](./03-CoreGenerativeAITechniques/README.md)**

### **Bölüm 4: Pratik Uygulamalar ve Projeler**
- **Evcil Hayvan Hikaye Üretici** (`petstory/`): GitHub Modelleri ile yaratıcı içerik üretimi
- **Foundry Yerel Demo** (`foundrylocal/`): OpenAI Java SDK ile yerel yapay zeka modeli entegrasyonu
- **MCP Hesap Makinesi Servisi** (`calculator/`): Spring AI ile temel Model Context Protocol uygulaması
- **[→ Bölüm 4'e Başla](./04-PracticalSamples/README.md)**

### **Bölüm 5: Sorumlu Yapay Zeka Geliştirme**
- **GitHub Modelleri Güvenliği**: Dahili içerik filtreleme ve güvenlik mekanizmalarını test etme (sert bloklar ve yumuşak reddetmeler)
- **Sorumlu Yapay Zeka Demo**: Modern yapay zeka güvenlik sistemlerinin pratikte nasıl çalıştığını gösteren uygulamalı örnek
- **En İyi Uygulamalar**: Etik yapay zeka geliştirme ve dağıtımı için temel yönergeler
- **[→ Bölüm 5'e Başla](./05-ResponsibleGenAI/README.md)**

## Ek Kaynaklar

- [Başlangıç Seviyesi Edge AI](https://github.com/microsoft/edgeai-for-beginners)
- [Başlangıç Seviyesi MCP](https://github.com/microsoft/mcp-for-beginners)
- [Başlangıç Seviyesi Yapay Zeka Ajanları](https://github.com/microsoft/ai-agents-for-beginners)
- [Başlangıç Seviyesi Üretken Yapay Zeka (.NET ile)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Başlangıç Seviyesi Üretken Yapay Zeka (JavaScript ile)](https://github.com/microsoft/generative-ai-with-javascript)
- [Başlangıç Seviyesi Üretken Yapay Zeka](https://github.com/microsoft/generative-ai-for-beginners)
- [Başlangıç Seviyesi Makine Öğrenimi](https://aka.ms/ml-beginners)
- [Başlangıç Seviyesi Veri Bilimi](https://aka.ms/datascience-beginners)
- [Başlangıç Seviyesi Yapay Zeka](https://aka.ms/ai-beginners)
- [Başlangıç Seviyesi Siber Güvenlik](https://github.com/microsoft/Security-101)
- [Başlangıç Seviyesi Web Geliştirme](https://aka.ms/webdev-beginners)
- [Başlangıç Seviyesi IoT](https://aka.ms/iot-beginners)
- [Başlangıç Seviyesi XR Geliştirme](https://github.com/microsoft/xr-development-for-beginners)
- [GitHub Copilot ile Yapay Zeka Eşli Programlama](https://aka.ms/GitHubCopilotAI)
- [GitHub Copilot ile C#/.NET Geliştiricileri için Ustalık](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Kendi Copilot Maceranızı Seçin](https://github.com/microsoft/CopilotAdventures)
- [Azure AI Hizmetleri ile RAG Sohbet Uygulaması](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Yardım Alma

Eğer takılırsanız veya yapay zeka uygulamaları oluşturma hakkında sorularınız olursa, şu topluluğa katılın:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Eğer ürünle ilgili geri bildirimde bulunmak veya hata yaşarsanız şu adresi ziyaret edin:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Feragatname**:  
Bu belge, AI çeviri hizmeti [Co-op Translator](https://github.com/Azure/co-op-translator) kullanılarak çevrilmiştir. Doğruluk için çaba göstersek de, otomatik çevirilerin hata veya yanlışlıklar içerebileceğini lütfen unutmayın. Belgenin orijinal dili, yetkili kaynak olarak kabul edilmelidir. Kritik bilgiler için profesyonel insan çevirisi önerilir. Bu çevirinin kullanımından kaynaklanan yanlış anlamalar veya yanlış yorumlamalardan sorumlu değiliz.