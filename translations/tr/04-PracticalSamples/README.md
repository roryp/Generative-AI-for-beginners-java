# Pratik Uygulamalar ve Projeler

[![Pratik Uygulamalar ve Projeler](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Pratik Uygulamalar ve Projeler")

> **Video genel bakışı:** [YouTube'da "Pratik Uygulamalar ve Projeler"i İzleyin](https://www.youtube.com/watch?v=01vJsYei3H0).

## Öğrenecekleriniz
Bu bölümde Java ile generatif AI geliştirme kalıplarını gösteren üç pratik uygulamayı sunacağız:
- İstemci tarafı ve sunucu tarafı AI'yi birleştiren çok modlu Bir Evcil Hayvan Hikayesi Oluşturucu oluşturma
- Foundry Local Spring Boot demosu ile yerel AI model entegrasyonunu uygulama
- Hesap Makinesi örneği ile Model Context Protocol (MCP) servisi geliştirme

## İçindekiler

- [Giriş](#giriş)
  - [Foundry Local Spring Boot Demosu](#foundry-local-spring-boot-demosu)
  - [Evcil Hayvan Hikayesi Oluşturucu](#evcil-hayvan-hikayesi-oluşturucu)
  - [MCP Hesap Makinesi Servisi (Yeni Başlayanlar için MCP Demosu)](#mcp-hesap-makinesi-servisi-yeni-başlayanlar-için-mcp-demosu)
- [Öğrenme Süreci](#öğrenme-süreci)
- [Özet](#özet)
- [Sonraki Adımlar](#sonraki-adımlar)

## Giriş

Bu bölüm, Java ile generatif AI geliştirme kalıplarını gösteren **örnek projeleri** sergilemektedir. Her proje tamamen işlevseldir ve kendi uygulamalarınızda uyarlayabileceğiniz belirli AI teknolojilerini, mimari kalıpları ve en iyi uygulamaları gösterir.

### Foundry Local Spring Boot Demosu

**[Foundry Local Spring Boot Demosu](foundrylocal/README.md)**, **OpenAI Java SDK'sı** kullanarak yerel AI modelleri ile entegrasyonu nasıl yapacağınızı gösterir. Foundry Local üzerinde çalışan **Phi-3.5-mini** modeline bağlanmayı göstererek, bulut hizmetlerine bağımlı olmadan AI uygulamaları çalıştırmanızı sağlar.

### Evcil Hayvan Hikayesi Oluşturucu

**[Evcil Hayvan Hikayesi Oluşturucu](petstory/README.md)**, yaratıcı evcil hayvan hikayeleri oluşturmak için **çok modlu AI işleme**yi gösteren sürükleyici bir Spring Boot web uygulamasıdır. Tarayıcı tabanlı AI etkileşimleri için transformer.js ve sunucu tarafı işleme için OpenAI SDK'sını birleştirir.

### MCP Hesap Makinesi Servisi (Yeni Başlayanlar için MCP Demosu)

**[MCP Hesap Makinesi Servisi](calculator/README.md)**, Spring AI kullanarak **Model Context Protocol (MCP)**nin basit bir demosudur. MCP kavramlarına yeni başlayanlar için temel bilgiler sunar ve MCP istemcileri ile etkileşime giren basit bir MCP Sunucusunun nasıl oluşturulacağını gösterir.

## Öğrenme Süreci

Bu projeler önceki bölümlerdeki kavramlara dayanmaktadır:

1. **Basit Başlayın**: Yerel modellerle temel AI entegrasyonunu anlamak için Foundry Local Spring Boot Demosu ile başlayın
2. **Etkileşimi Ekleyin**: Çok modlu AI ve web tabanlı etkileşimler için Evcil Hayvan Hikayesi Oluşturucu'ya geçin
3. **MCP Temellerini Öğrenin**: Model Context Protocol temelini anlamak için MCP Hesap Makinesi Servisi'ni deneyin

## Özet

Tebrikler! Artık bazı gerçek uygulamaları incelediniz:

- Hem tarayıcıda hem de sunucuda çalışan çok modlu AI deneyimleri
- Modern Java çerçeveleri ve SDK'larla yerel AI model entegrasyonu
- Araçların AI ile nasıl entegre olduğunu görmek için ilk Model Context Protocol servisinizi

## Sonraki Adımlar

[5. Bölüm: Sorumlu Generatif AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Feragatname**:  
Bu belge, [Co-op Translator](https://github.com/Azure/co-op-translator) adlı Yapay Zeka çeviri hizmeti kullanılarak çevrilmiştir. Doğruluk için çaba gösterilmekle birlikte, otomatik çevirilerin hatalar veya yanlışlıklar içerebileceğini lütfen unutmayın. Orijinal belge, kendi dilindeki haliyle yetkili kaynak olarak kabul edilmelidir. Kritik bilgiler için profesyonel insan çevirisi önerilmektedir. Bu çevirinin kullanımı sonucu ortaya çıkabilecek herhangi bir yanlış anlama veya yorumlama nedeniyle sorumluluk kabul edilmemektedir.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->