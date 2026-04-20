# Foundry Local Spring Boot Tutorial

## Table of Contents

- [Mga Kinakailangan](#mga-kinakailangan)
- [Pangkalahatang-ideya ng Proyekto](#pangkalahatang-ideya-ng-proyekto)
- [Pag-unawa sa Code](#pag-unawa-sa-code)
  - [1. Konfigurasyon ng Aplikasyon (application.properties)](#1-konfigurasyon-ng-aplikasyon-applicationproperties)
  - [2. Pangunahing Klase ng Aplikasyon (Application.java)](#2-pangunahing-klase-ng-aplikasyon-applicationjava)
  - [3. AI Service Layer (FoundryLocalService.java)](#3-ai-service-layer-foundrylocalservicejava)
  - [4. Mga Dependency ng Proyekto (pom.xml)](#4-mga-dependency-ng-proyekto-pomxml)
- [Paano Nagtutulungan Lahat ng Ito](#paano-nagtutulungan-lahat-ng-ito)
- [Pag-setup ng Foundry Local](#pag-setup-ng-foundry-local)
- [Pagpapatakbo ng Aplikasyon](#pagpapatakbo-ng-aplikasyon)
- [Inaasahang Output](#inaasahang-output)
- [Mga Susunod na Hakbang](#mga-susunod-na-hakbang)
- [Pag-troubleshoot](#pag-troubleshoot)


## Mga Kinakailangan

Bago simulan ang tutorial na ito, siguraduhing mayroon ka ng:

- **Java 21 o mas mataas** na naka-install sa iyong sistema
- **Maven 3.6+** para sa pagbuo ng proyekto
- **Foundry Local** na naka-install at tumatakbo

### **I-install ang Foundry Local:**

> **Tandaan:** Ang Foundry Local CLI ay available lamang sa **Windows** at **macOS**. Sinusuportahan ang Linux sa pamamagitan ng [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Suriin ang pag-install:
```bash
foundry --version
```

## Pangkalahatang-ideya ng Proyekto

Ang proyektong ito ay binubuo ng apat na pangunahing bahagi:

1. **Application.java** - Pangunahing entry point ng Spring Boot na aplikasyon
2. **FoundryLocalService.java** - Service layer na humahawak ng komunikasyon sa AI
3. **application.properties** - Konfigurasyon para sa koneksyon ng Foundry Local
4. **pom.xml** - Mga dependency ng Maven at konfigurasyon ng proyekto

## Pag-unawa sa Code

### 1. Konfigurasyon ng Aplikasyon (application.properties)

**File:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Ano ang ginagawa nito:**
- **base-url**: Tinukoy kung saan tumatakbo ang Foundry Local, kabilang ang path na `/v1` para sa pagiging tugma sa OpenAI API. Ang default na port ay `5273`. Kung iba ang port, suriin gamit ang `foundry service status`.
- **model** (opsyonal): Pangalan ng AI model na gagamitin para sa pagbuo ng teksto. **Sa default, awtomatikong nadedetect ng aplikasyon ang model** sa pamamagitan ng pag-query sa Foundry Local `/v1/models` endpoint sa pagsisimula, kaya hindi mo kailangan itong itakda. Maaari mo pa ring itakda ito nang tahasan para malampasan ang awtomatikong pagtuklas kung kinakailangan.

**Pangunahing konsepto:** Ang Spring Boot ay awtomatikong naglo-load ng mga property na ito at ginagawang available sa iyong aplikasyon gamit ang annotation na `@Value`.

### 2. Pangunahing Klase ng Aplikasyon (Application.java)

**File:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Hindi kailangan ng web server
        app.run(args);
    }
```

**Ano ang ginagawa nito:**
- `@SpringBootApplication` pinapagana ang auto-configuration ng Spring Boot
- `WebApplicationType.NONE` nagsasabing command-line app ito, hindi web server
- Nagsisimula ang pangunahing method ng Spring application

**Ang Demo Runner:**
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

**Ano ang ginagawa nito:**
- Ang `@Bean` ay lumilikha ng component na pinamamahalaan ng Spring
- `CommandLineRunner` ay nagpapatakbo ng code pagkatapos magsimula ang Spring Boot
- Ang `foundryLocalService` ay awtomatikong ini-inject ng Spring (dependency injection)
- Nagpapadala ng test message sa AI at ipinapakita ang sagot

### 3. AI Service Layer (FoundryLocalService.java)

**File:** `src/main/java/com/example/FoundryLocalService.java`

#### Pag-inject ng Konfigurasyon:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Awtomatikong natukoy kung walang laman
```

**Ano ang ginagawa nito:**
- `@Service` nagsasabi sa Spring na ang klase na ito ay nagbibigay ng business logic
- `@Value` nag-iinject ng mga halaga ng konfigurasyon mula sa application.properties
- Ang model ay default na walang laman, na nagpapatakbo ng **auto-detection** mula sa Foundry Local sa pagsisimula. Ibig sabihin nito, gumagana ang app sa anumang model na naka-load sa Foundry Local nang walang manwal na konfigurasyon.

#### Pagsisimula ng Client:
```java
@PostConstruct
public void init() {
    // Awtomatikong tuklasin ang modelo mula sa Foundry Local kung hindi tahasang naka-configure
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Kasama na sa Base URL ang /v1 mula sa configuration
            .apiKey("not-needed")            // Hindi kailangan ng totoong API key ang lokal na server
            .build();
}
```

**Ano ang ginagawa nito:**
- `@PostConstruct` nagpapatakbo ng method na ito pagkatapos malikha ng Spring ang service
- Kung walang naka-configure na model, kino-query nito ang Foundry Local `/v1/models` endpoint at pinipili ang unang na-load na model
- Lumilikha ng OpenAI client na naka-point sa iyong lokal na Foundry Local instance
- Ang base URL mula sa `application.properties` ay kasama na ang `/v1` para sa pagiging tugma sa OpenAI API
- Ang API key ay naka-set sa "not-needed" dahil hindi kailangan ng authentication sa lokal na development

#### Chat Method:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Aling modelo ng AI ang gagamitin
                .addUserMessage(message)         // Iyong tanong/prompt
                .maxCompletionTokens(150)        // Limitahan ang haba ng sagot
                .temperature(0.7)                // Kontrolin ang pagkamalikhain (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Kunin ang sagot ng AI mula sa resulta ng API
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Ano ang ginagawa nito:**
- **ChatCompletionCreateParams**: Nagko-configure ng AI request
  - `model`: Tinukoy kung aling AI model ang gagamitin (dapat tumugma sa eksaktong ID mula sa `foundry model list`)
  - `addUserMessage`: Idinadagdag ang iyong mensahe sa pag-uusap
  - `maxCompletionTokens`: Nililimitahan ang haba ng sagot (para makatipid sa resources)
  - `temperature`: Kinokontrol ang randomness (0.0 = deterministic, 1.0 = malikhain)
- **API Call**: Pinapadala ang request sa Foundry Local
- **Paghawak ng Tugon**: Kinukuha nang ligtas ang teksto ng sagot ng AI
- **Paghawak ng Error**: Binabalot ang mga exception gamit ang mga kapaki-pakinabang na mensahe ng error

### 4. Mga Dependency ng Proyekto (pom.xml)

**Pangunahing Dependencies:**

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

**Ano ang ginagawa nito:**
- **spring-boot-starter**: Nagbibigay ng core na functionality ng Spring Boot
- **openai-java**: Opisyal na OpenAI Java SDK para sa komunikasyon sa API
- **jackson-databind**: Humahawak ng JSON serialization/deserialization para sa mga tawag sa API

## Paano Nagtutulungan Lahat ng Ito

Narito ang buong daloy kapag pinatakbo mo ang aplikasyon:

1. **Pagsisimula**: Nagsisimula ang Spring Boot at binabasa ang `application.properties`
2. **Paglikha ng Serbisyo**: Gumagawa ang Spring ng `FoundryLocalService` at ini-inject ang mga halaga ng konfigurasyon
3. **Pagtukoy ng Model**: Kung walang naka-configure na model, kino-query ng service ang Foundry Local `/v1/models` endpoint at awtomatikong ginagamit ang unang available na model
4. **Pagsisimula ng Client**: Ang `@PostConstruct` ay nag-iinitialize ng OpenAI client para kumonekta sa Foundry Local
5. **Pagpapatupad ng Demo**: Ang `CommandLineRunner` ay nagpapatakbo pagkatapos ng startup
6. **Pagtawag sa AI**: Tumatawag ang demo ng `foundryLocalService.chat()` na may test message
7. **Request sa API**: Nagbuo ang service at nagpapadala ng OpenAI-compatible nga request sa Foundry Local
8. **Pagproseso ng Tugon**: Kinukuha ng service at ibinabalik ang tugon ng AI
9. **Pagpakita**: Ipinapakita ng aplikasyon ang tugon at lumalabas

## Pag-setup ng Foundry Local

1. **I-install ang Foundry Local** gamit ang mga tagubilin sa seksyong [Mga Kinakailangan](#mga-kinakailangan).

2. **Simulan ang serbisyo** (kung hindi pa tumatakbo):
   ```bash
   foundry service start
   ```

3. **Suriin ang status ng serbisyo** para matiyak na ito ay tumatakbo at alamin ang port:
   ```bash
   foundry service status
   ```

4. **I-download at patakbuhin ang model** (dinadownload sa unang takbo, naka-cache para sa sunod na mga takbo):
   ```bash
   foundry model run phi-4-mini
   ```
   Magbubukas ito ng interactive na chat session. Maaari kang lumabas gamit ang `Ctrl+C`. Mananatiling naka-load ang model sa serbisyo.

   > **Tip:** Patakbuhin ang `foundry model list` para makita ang lahat ng available na model. Palitan ang `phi-4-mini` ng anumang alias mula sa catalog (hal., `qwen2.5-0.5b` para sa mas maliit/mabilis na model).

5. **Suriin na naka-load ang model:**
   ```bash
   foundry service ps
   ```

6. **I-update ang `application.properties`** kung kinakailangan:
   - Ang default na `base-url` (`http://localhost:5273/v1`) ay tumutugma sa default na CLI port. I-update lang kung nagpapakita ang `foundry service status` ng ibang port.
   - Ang model ay **awtomatikong nadedetect** sa pagsisimula — hindi kailangan ng konfigurasyon.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Pagpapatakbo ng Aplikasyon

### Hakbang 1: Siguraduhing naka-load ang isang model sa Foundry Local
```bash
foundry service ps
```
Kung walang listadong mga model, mag-load ng isa:
```bash
foundry model run phi-4-mini
```

### Hakbang 2: I-build at Patakbuhin ang Aplikasyon
Sa isang hiwalay na terminal:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

O i-build at patakbuhin bilang JAR:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Inaasahang Output

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

## Mga Susunod na Hakbang

Para sa karagdagang mga halimbawa, tingnan ang [Chapter 04: Practical samples](../README.md)

## Pag-troubleshoot

### Mga Karaniwang Isyu

**"Connection refused" o "Service unavailable"**
- Suriin ang serbisyo: `foundry service status`
- I-restart kung kinakailangan: `foundry service restart`
- Tiyakin na tumutugma ang port sa `application.properties` ng ipinalabas ng `foundry service status`
- Siguraduhing nagtatapos sa `/v1` ang URL: `http://localhost:5273/v1`

**"No model found" sa pagsisimula**
- Awtomatikong nadedetect ng aplikasyon ang model. Siguraduhing mayroong kahit isang model na naka-load: `foundry service ps`
- Kung walang mga model na naka-load: `foundry model run phi-4-mini`
- Kung pinalitan mo ang pangalan ng model sa `application.properties`, siguraduhing tumutugma ito sa `foundry model list`

**Mga error na "400 Bad Request"**
- Tiyaking kasama ang `/v1` sa base URL: `http://localhost:5273/v1`
- Siguraduhing ginagamit mo ang `maxCompletionTokens()` sa code mo (hindi na ginagamit ang deprecated na `maxTokens()`)

**Mga error sa compilation ng Maven**
- Siguraduhing Java 21 o mas mataas ang gamit: `java -version`
- Linisin at i-rebuild: `mvn clean compile`
- Suriin ang koneksyon sa internet para sa pag-download ng mga dependency

**Problema sa koneksyon ng serbisyo**
- Kung nakikita mo ang `Request to local service failed`, patakbuhin: `foundry service restart`
- Tignan ang mga loaded na model: `foundry service ps`
- Tingnan ang mga log ng serbisyo: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Pagtanggi**:
Ang dokumentong ito ay isinalin gamit ang serbisyong AI translation na [Co-op Translator](https://github.com/Azure/co-op-translator). Bagamat nagsusumikap kami para sa katumpakan, mangyaring tandaan na ang mga awtomatikong pagsasalin ay maaaring maglaman ng mga pagkakamali o kamalian. Ang orihinal na dokumento sa kanyang katutubong wika ang dapat ituring na pangunahing sanggunian. Para sa mahahalagang impormasyon, inirerekomenda ang propesyonal na pagsasalin ng tao. Hindi kami mananagot sa anumang hindi pagkakaunawaan o maling interpretasyon na nagmumula sa paggamit ng pagsasaling ito.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->