<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "79df2d245c12d6b8ad57148fd049f106",
  "translation_date": "2025-07-23T12:16:41+00:00",
  "source_file": "README.md",
  "language_code": "tr"
}
-->
# Java Sürümü için Başlangıç Seviyesi Üretken AI
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Java Sürümü için Başlangıç Seviyesi Üretken AI](../../translated_images/beg-genai-series.61edc4a6b2cc54284fa2d70eda26dc0ca2669e26e49655b842ea799cd6e16d2a.tr.png)

> **NOTE: Hızlı Başlangıç**: Tüm kurs çevrimiçi olarak tamamlanabilir - Yerel kurulum gerekmez!
1. Bu depoyu GitHub hesabınıza çatallayın
2. **Code** → **Codespaces** sekmesi → **...** → **New with options...** seçeneğine tıklayın
3. Varsayılan ayarları kullanın – bu, bu kurs için oluşturulan Geliştirme konteynerini seçecektir
4. **Create codespace** seçeneğine tıklayın
5. Ortamın hazır olması için yaklaşık 2 dakika bekleyin
6. Doğrudan [GitHub Modelleri Tokeninizi Oluşturma](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) bölümüne geçin

## Çoklu Dil Desteği

### GitHub Action ile Desteklenir (Otomatik ve Her Zaman Güncel)

[Fransızca](../fr/README.md) | [İspanyolca](../es/README.md) | [Almanca](../de/README.md) | [Rusça](../ru/README.md) | [Arapça](../ar/README.md) | [Farsça](../fa/README.md) | [Urduca](../ur/README.md) | [Çince (Basitleştirilmiş)](../zh/README.md) | [Çince (Geleneksel, Macau)](../mo/README.md) | [Çince (Geleneksel, Hong Kong)](../hk/README.md) | [Çince (Geleneksel, Tayvan)](../tw/README.md) | [Japonca](../ja/README.md) | [Korece](../ko/README.md) | [Hintçe](../hi/README.md) | [Bengalce](../bn/README.md) | [Marathi](../mr/README.md) | [Nepalce](../ne/README.md) | [Pencapça (Gurmukhi)](../pa/README.md) | [Portekizce (Portekiz)](../pt/README.md) | [Portekizce (Brezilya)](../br/README.md) | [İtalyanca](../it/README.md) | [Lehçe](../pl/README.md) | [Türkçe](./README.md) | [Yunanca](../el/README.md) | [Tayca](../th/README.md) | [İsveççe](../sv/README.md) | [Danca](../da/README.md) | [Norveççe](../no/README.md) | [Fince](../fi/README.md) | [Felemenkçe](../nl/README.md) | [İbranice](../he/README.md) | [Vietnamca](../vi/README.md) | [Endonezce](../id/README.md) | [Malayca](../ms/README.md) | [Tagalog (Filipince)](../tl/README.md) | [Swahili](../sw/README.md) | [Macarca](../hu/README.md) | [Çekçe](../cs/README.md) | [Slovakça](../sk/README.md) | [Romence](../ro/README.md) | [Bulgarca](../bg/README.md) | [Sırpça (Kiril)](../sr/README.md) | [Hırvatça](../hr/README.md) | [Slovence](../sl/README.md) | [Ukraynaca](../uk/README.md) | [Burmaca (Myanmar)](../my/README.md)

## Kurs Yapısı ve Öğrenme Yolu

**Zaman Taahhüdü**: Ortam kurulumu 2 dakika sürer, uygulamalı eğitimler ise keşif derinliğine bağlı olarak 1-3 saat gerektirir.

### **Bölüm 1: Üretken AI'ye Giriş**
- **Temel Kavramlar**: Büyük Dil Modellerini, tokenları, gömüleri ve AI yeteneklerini anlama
- **Java AI Ekosistemi**: Spring AI ve OpenAI SDK'larının genel bakışı
- **Model Context Protocol**: MCP'ye ve AI ajan iletişimindeki rolüne giriş
- **Pratik Uygulamalar**: Sohbet botları ve içerik üretimi gibi gerçek dünya senaryoları
- **[→ Bölüm 1'e Başla](./01-IntroToGenAI/README.md)**

### **Bölüm 2: Geliştirme Ortamı Kurulumu**
- **Çoklu Sağlayıcı Yapılandırması**: GitHub Modelleri, Azure OpenAI ve OpenAI Java SDK entegrasyonlarını kurma
- **Spring Boot + Spring AI**: Kurumsal AI uygulama geliştirme için en iyi uygulamalar
- **GitHub Modelleri**: Prototipleme ve öğrenme için ücretsiz AI model erişimi (kredi kartı gerekmez)
- **Geliştirme Araçları**: Docker konteynerleri, VS Code ve GitHub Codespaces yapılandırması
- **[→ Bölüm 2'ye Başla](./02-SetupDevEnvironment/README.md)**

### **Bölüm 3: Temel Üretken AI Teknikleri**
- **Prompt Mühendisliği**: AI modelinden en iyi yanıtları almak için teknikler
- **Gömüler ve Vektör İşlemleri**: Anlamsal arama ve benzerlik eşleştirme uygulama
- **Retrieval-Augmented Generation (RAG)**: AI'yi kendi veri kaynaklarınızla birleştirme
- **Fonksiyon Çağrısı**: AI yeteneklerini özel araçlar ve eklentilerle genişletme
- **[→ Bölüm 3'e Başla](./03-CoreGenerativeAITechniques/README.md)**

### **Bölüm 4: Pratik Uygulamalar ve Projeler**
- **Evcil Hayvan Hikaye Üreticisi** (`petstory/`): GitHub Modelleri ile yaratıcı içerik üretimi
- **Foundry Yerel Demo** (`foundrylocal/`): OpenAI Java SDK ile yerel AI model entegrasyonu
- **MCP Hesap Makinesi Servisi** (`mcp/calculator/`): Spring AI ile temel Model Context Protocol uygulaması
- **[→ Bölüm 4'e Başla](./04-PracticalSamples/README.md)**

### **Bölüm 5: Sorumlu AI Geliştirme**
- **GitHub Modelleri Güvenliği**: Dahili içerik filtreleme ve güvenlik mekanizmalarını test etme
- **Sorumlu AI Demo**: AI güvenlik filtrelerinin pratikte nasıl çalıştığını gösteren uygulamalı örnek
- **En İyi Uygulamalar**: Etik AI geliştirme ve dağıtımı için temel yönergeler
- **[→ Bölüm 5'e Başla](./05-ResponsibleGenAI/README.md)**

## Ek Kaynaklar 

- [Başlangıç Seviyesi için AI Ajanları](https://github.com/microsoft/ai-agents-for-beginners)
- [Başlangıç Seviyesi Üretken AI (.NET ile)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Başlangıç Seviyesi Üretken AI (JavaScript ile)](https://github.com/microsoft/generative-ai-with-javascript)
- [Başlangıç Seviyesi Üretken AI](https://github.com/microsoft/generative-ai-for-beginners)
- [Başlangıç Seviyesi için ML](https://aka.ms/ml-beginners)
- [Başlangıç Seviyesi için Veri Bilimi](https://aka.ms/datascience-beginners)
- [Başlangıç Seviyesi için AI](https://aka.ms/ai-beginners)
- [Başlangıç Seviyesi için Siber Güvenlik](https://github.com/microsoft/Security-101)
- [Başlangıç Seviyesi için Web Geliştirme](https://aka.ms/webdev-beginners)
- [Başlangıç Seviyesi için IoT](https://aka.ms/iot-beginners)
- [Başlangıç Seviyesi için XR Geliştirme](https://github.com/microsoft/xr-development-for-beginners)
- [AI Eşli Programlama için GitHub Copilot'u Master Etme](https://aka.ms/GitHubCopilotAI)
- [C#/.NET Geliştiricileri için GitHub Copilot'u Master Etme](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Kendi Copilot Maceranızı Seçin](https://github.com/microsoft/CopilotAdventures)
- [Azure AI Hizmetleri ile RAG Sohbet Uygulaması](https://github.com/Azure-Samples/azure-search-openai-demo-java)

**Feragatname**:  
Bu belge, AI çeviri hizmeti [Co-op Translator](https://github.com/Azure/co-op-translator) kullanılarak çevrilmiştir. Doğruluk için çaba göstersek de, otomatik çevirilerin hata veya yanlışlık içerebileceğini lütfen unutmayın. Belgenin orijinal dilindeki hali, yetkili kaynak olarak kabul edilmelidir. Kritik bilgiler için profesyonel insan çevirisi önerilir. Bu çevirinin kullanımından kaynaklanan yanlış anlamalar veya yanlış yorumlamalar için sorumluluk kabul etmiyoruz.