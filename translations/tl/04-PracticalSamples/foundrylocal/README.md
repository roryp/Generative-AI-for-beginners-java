<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T19:50:52+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "tl"
}
-->
# Foundry Local Command-Line Application

>**Tandaan**: Kasama sa kabanatang ito ang isang [**Tutorial**](./TUTORIAL.md) na gagabay sa iyo sa pagpapatakbo ng mga natapos na halimbawa.

Isang simpleng Spring Boot command-line application na nagpapakita kung paano kumonekta sa Foundry Local gamit ang OpenAI Java SDK.

## Ano ang Matututuhan Mo

- Paano i-integrate ang Foundry Local sa mga Spring Boot application gamit ang OpenAI Java SDK
- Mga pinakamahusay na kasanayan para sa lokal na AI development at testing

## Talaan ng Nilalaman

- [Ano ang Matututuhan Mo](../../../../04-PracticalSamples/foundrylocal)
- [Mga Kinakailangan](../../../../04-PracticalSamples/foundrylocal)
  - [Pag-install ng Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Pagpapatunay](../../../../04-PracticalSamples/foundrylocal)
- [Konpigurasyon](../../../../04-PracticalSamples/foundrylocal)
- [Mabilisang Simula](../../../../04-PracticalSamples/foundrylocal)
- [Ano ang Ginagawa ng Application](../../../../04-PracticalSamples/foundrylocal)
- [Halimbawang Output](../../../../04-PracticalSamples/foundrylocal)
- [Arkitektura](../../../../04-PracticalSamples/foundrylocal)
- [Mga Highlight ng Code](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI Java SDK Integration](../../../../04-PracticalSamples/foundrylocal)
  - [Chat Completion API](../../../../04-PracticalSamples/foundrylocal)
- [Pag-aayos ng Problema](../../../../04-PracticalSamples/foundrylocal)

## Mga Kinakailangan

> **⚠️ Tandaan**: Ang application na ito ay **hindi tumatakbo sa ibinigay na devcontainer** dahil kinakailangan nitong naka-install at tumatakbo ang Foundry Local sa host system.

### Pag-install ng Foundry Local

Bago patakbuhin ang application na ito, kailangan mong i-install at simulan ang Foundry Local. Sundin ang mga hakbang na ito:

1. **Siguraduhing natutugunan ng iyong system ang mga kinakailangan**:
   - **Operating System**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, o macOS
   - **Hardware**: 
     - Minimum: 8GB RAM, 3GB libreng disk space
     - Rekomendado: 16GB RAM, 15GB libreng disk space
   - **Network**: Koneksyon sa internet para sa paunang pag-download ng modelo (opsyonal para sa offline na paggamit)
   - **Acceleration (opsyonal)**: NVIDIA GPU (2,000 series o mas bago), AMD GPU (6,000 series o mas bago), Qualcomm Snapdragon X Elite (8GB o higit pang memorya), o Apple silicon
   - **Mga Pahintulot**: Mga pribilehiyong pang-administratibo upang mag-install ng software sa iyong device

2. **I-install ang Foundry Local**:
   
   **Para sa Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **Para sa macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Bilang alternatibo, maaari mong i-download ang installer mula sa [Foundry Local GitHub repository](https://github.com/microsoft/Foundry-Local).

3. **Simulan ang iyong unang modelo**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Ang modelo ay ida-download (na maaaring tumagal ng ilang minuto, depende sa bilis ng iyong internet) at pagkatapos ay tatakbo. Awtomatikong pinipili ng Foundry Local ang pinakamahusay na variant ng modelo para sa iyong system (CUDA para sa NVIDIA GPUs, CPU version kung wala).

4. **Subukan ang modelo** sa pamamagitan ng pagtatanong sa parehong terminal:

   ```bash
   Why is the sky blue?
   ```

   Makakakita ka ng sagot mula sa Phi model na nagpapaliwanag kung bakit asul ang langit.

### Pagpapatunay

Maaari mong tiyakin na maayos ang lahat gamit ang mga command na ito:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Maaari mo ring bisitahin ang `http://localhost:5273` sa iyong browser upang makita ang web interface ng Foundry Local.

## Konpigurasyon

Maaaring i-configure ang application sa pamamagitan ng `application.properties`:

- `foundry.local.base-url` - Base URL para sa Foundry Local (default: http://localhost:5273)
- `foundry.local.model` - AI model na gagamitin (default: Phi-3.5-mini-instruct-cuda-gpu)

> **Tandaan**: Ang pangalan ng modelo sa configuration ay dapat tumugma sa partikular na variant na na-download ng Foundry Local para sa iyong system. Kapag pinatakbo mo ang `foundry model run phi-3.5-mini`, awtomatikong pinipili at dina-download ng Foundry Local ang pinakamahusay na variant (CUDA para sa NVIDIA GPUs, CPU version kung wala). Gamitin ang `foundry model list` upang makita ang eksaktong pangalan ng modelo na magagamit sa iyong lokal na instance.

## Mabilisang Simula

### 1. Pumunta sa direktoryo ng Foundry Local application
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Patakbuhin ang Application

```bash
mvn spring-boot:run
```

O i-build at patakbuhin ang JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Mga Dependency

Gumagamit ang application na ito ng OpenAI Java SDK upang makipag-ugnayan sa Foundry Local. Ang pangunahing dependency ay:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Ang application ay naka-pre-configure upang kumonekta sa Foundry Local na tumatakbo sa default na port.

## Ano ang Ginagawa ng Application

Kapag pinatakbo mo ang application:

1. **Nagsisimula** bilang isang command-line application (walang web server)
2. **Awtomatikong nagpapadala** ng test message: "Hello! Can you tell me what you are and what model you're running?"
3. **Ipinapakita ang sagot** mula sa Foundry Local sa console
4. **Maayos na nagtatapos** pagkatapos ng demo

## Halimbawang Output

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Arkitektura

- **Application.java** - Pangunahing Spring Boot application na may CommandLineRunner
- **FoundryLocalService.java** - Serbisyo na gumagamit ng OpenAI Java SDK upang makipag-ugnayan sa Foundry Local
- Gumagamit ng **OpenAI Java SDK** para sa type-safe na API calls
- Awtomatikong JSON serialization/deserialization na hinahawakan ng SDK
- Malinis na configuration gamit ang Spring's `@Value` at `@PostConstruct` annotations

## Mga Highlight ng Code

### OpenAI Java SDK Integration

Gumagamit ang application ng OpenAI Java SDK upang lumikha ng client na naka-configure para sa Foundry Local:

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

Ang paggawa ng chat completion requests ay simple at type-safe:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Pag-aayos ng Problema

Kung makakita ka ng mga error sa koneksyon:
1. Siguraduhing tumatakbo ang Foundry Local sa `http://localhost:5273`
2. Suriin kung may Phi-3.5-mini model variant na magagamit gamit ang `foundry model list`
3. Siguraduhing ang pangalan ng modelo sa `application.properties` ay tumutugma sa eksaktong pangalan ng modelo na ipinapakita sa listahan
4. Siguraduhing walang firewall na humaharang sa koneksyon

Karaniwang mga isyu:
- **Model hindi natagpuan**: Patakbuhin ang `foundry model run phi-3.5-mini` upang i-download at simulan ang modelo
- **Serbisyo hindi tumatakbo**: Maaaring huminto ang Foundry Local service; i-restart ito gamit ang model run command
- **Maling pangalan ng modelo**: Gamitin ang `foundry model list` upang makita ang mga magagamit na modelo at i-update ang iyong configuration nang naaayon

**Paunawa**:  
Ang dokumentong ito ay isinalin gamit ang AI translation service na [Co-op Translator](https://github.com/Azure/co-op-translator). Bagama't sinisikap naming maging tumpak, pakitandaan na ang mga awtomatikong pagsasalin ay maaaring maglaman ng mga pagkakamali o hindi pagkakatugma. Ang orihinal na dokumento sa kanyang katutubong wika ang dapat ituring na opisyal na pinagmulan. Para sa mahalagang impormasyon, inirerekomenda ang propesyonal na pagsasalin ng tao. Hindi kami mananagot sa anumang hindi pagkakaunawaan o maling interpretasyon na dulot ng paggamit ng pagsasaling ito.