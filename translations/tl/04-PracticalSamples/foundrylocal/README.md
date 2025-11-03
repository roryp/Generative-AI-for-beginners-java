<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "713d81fd7d28a865068df047e26c8f12",
  "translation_date": "2025-11-03T20:12:33+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "tl"
}
-->
# Foundry Local Spring Boot Tutorial

## Nilalaman ng Talakayan

- [Mga Kinakailangan](../../../../04-PracticalSamples/foundrylocal)
- [Pangkalahatang-ideya ng Proyekto](../../../../04-PracticalSamples/foundrylocal)
- [Pag-unawa sa Code](../../../../04-PracticalSamples/foundrylocal)
  - [1. Konpigurasyon ng Aplikasyon (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Pangunahing Klase ng Aplikasyon (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI Service Layer (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Mga Dependency ng Proyekto (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Paano Nagtutulungan ang Lahat](../../../../04-PracticalSamples/foundrylocal)
- [Pag-set Up ng Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [Pagpapatakbo ng Aplikasyon](../../../../04-PracticalSamples/foundrylocal)
- [Inaasahang Output](../../../../04-PracticalSamples/foundrylocal)
- [Susunod na Hakbang](../../../../04-PracticalSamples/foundrylocal)
- [Pag-aayos ng Problema](../../../../04-PracticalSamples/foundrylocal)

## Mga Kinakailangan

Bago simulan ang tutorial na ito, tiyakin na mayroon ka ng:

- **Java 21 o mas mataas** na naka-install sa iyong sistema
- **Maven 3.6+** para sa pagbuo ng proyekto
- **Foundry Local** na naka-install at tumatakbo

### **I-install ang Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## Pangkalahatang-ideya ng Proyekto

Ang proyektong ito ay binubuo ng apat na pangunahing bahagi:

1. **Application.java** - Ang pangunahing entry point ng Spring Boot application
2. **FoundryLocalService.java** - Service layer na humahawak sa komunikasyon ng AI
3. **application.properties** - Konpigurasyon para sa koneksyon sa Foundry Local
4. **pom.xml** - Mga dependency ng Maven at konpigurasyon ng proyekto

## Pag-unawa sa Code

### 1. Konpigurasyon ng Aplikasyon (application.properties)

**File:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**Ano ang ginagawa nito:**
- **base-url**: Tinutukoy kung saan tumatakbo ang Foundry Local, kabilang ang `/v1` path para sa OpenAI API compatibility. **Tandaan**: Ang Foundry Local ay awtomatikong nag-aassign ng port, kaya suriin ang aktwal na port gamit ang `foundry service status`
- **model**: Pinapangalanan ang AI model na gagamitin para sa text generation, kabilang ang version number (hal. `:1`). Gamitin ang `foundry model list` para makita ang mga available na model na may eksaktong ID

**Pangunahing konsepto:** Ang Spring Boot ay awtomatikong naglo-load ng mga properties na ito at ginagawang available sa iyong application gamit ang `@Value` annotation.

### 2. Pangunahing Klase ng Aplikasyon (Application.java)

**File:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```

**Ano ang ginagawa nito:**
- `@SpringBootApplication` ay nagbibigay-daan sa auto-configuration ng Spring Boot
- `WebApplicationType.NONE` ay nagsasabi sa Spring na ito ay isang command-line app, hindi isang web server
- Ang pangunahing method ay nagsisimula sa Spring application

**Ang Demo Runner:**
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

**Ano ang ginagawa nito:**
- `@Bean` ay lumilikha ng component na pinamamahalaan ng Spring
- `CommandLineRunner` ay nagpapatakbo ng code pagkatapos magsimula ang Spring Boot
- Ang `foundryLocalService` ay awtomatikong ini-inject ng Spring (dependency injection)
- Nagpapadala ng test message sa AI at ipinapakita ang response

### 3. AI Service Layer (FoundryLocalService.java)

**File:** `src/main/java/com/example/FoundryLocalService.java`

#### Configuration Injection:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```

**Ano ang ginagawa nito:**
- `@Service` ay nagsasabi sa Spring na ang klase na ito ay nagbibigay ng business logic
- `@Value` ay nag-iinject ng mga configuration value mula sa application.properties
- Ang syntax na `:default-value` ay nagbibigay ng fallback values kung hindi naka-set ang mga properties

#### Client Initialization:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```

**Ano ang ginagawa nito:**
- `@PostConstruct` ay nagpapatakbo ng method na ito pagkatapos likhain ng Spring ang service
- Lumilikha ng OpenAI client na konektado sa iyong lokal na Foundry Local instance
- Ang base URL mula sa `application.properties` ay kasama na ang `/v1` para sa OpenAI API compatibility
- Ang API key ay naka-set sa "not-needed" dahil ang lokal na development ay hindi nangangailangan ng authentication

#### Chat Method:
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

**Ano ang ginagawa nito:**
- **ChatCompletionCreateParams**: Kinokontrol ang AI request
  - `model`: Tinutukoy kung aling AI model ang gagamitin (dapat tumugma sa eksaktong ID mula sa `foundry model list`)
  - `addUserMessage`: Nagdadagdag ng iyong mensahe sa conversation
  - `maxTokens`: Nililimitahan kung gaano kahaba ang response (nakakatipid ng resources)
  - `temperature`: Kinokontrol ang randomness (0.0 = deterministic, 1.0 = creative)
- **API Call**: Nagpapadala ng request sa Foundry Local
- **Response Handling**: Kinukuha ang text response ng AI nang ligtas
- **Error Handling**: Binabalot ang mga exception na may kapaki-pakinabang na error messages

### 4. Mga Dependency ng Proyekto (pom.xml)

**Mga Pangunahing Dependency:**

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
- **spring-boot-starter**: Nagbibigay ng pangunahing functionality ng Spring Boot
- **openai-java**: Opisyal na OpenAI Java SDK para sa API communication
- **jackson-databind**: Humahawak sa JSON serialization/deserialization para sa API calls

## Paano Nagtutulungan ang Lahat

Narito ang kumpletong daloy kapag pinatakbo mo ang application:

1. **Startup**: Sinisimulan ng Spring Boot at binabasa ang `application.properties`
2. **Service Creation**: Lumilikha ang Spring ng `FoundryLocalService` at ini-inject ang mga configuration values
3. **Client Setup**: Ang `@PostConstruct` ay nag-iinitialize ng OpenAI client para kumonekta sa Foundry Local
4. **Demo Execution**: Ang `CommandLineRunner` ay nagpapatakbo pagkatapos ng startup
5. **AI Call**: Ang demo ay tumatawag sa `foundryLocalService.chat()` gamit ang test message
6. **API Request**: Ang service ay bumubuo at nagpapadala ng OpenAI-compatible request sa Foundry Local
7. **Response Processing**: Ang service ay kumukuha at nagbabalik ng response ng AI
8. **Display**: Ipinapakita ng application ang response at nag-eexit

## Pag-set Up ng Foundry Local

Para i-set up ang Foundry Local, sundin ang mga hakbang na ito:

1. **I-install ang Foundry Local** gamit ang mga instruksyon sa seksyong [Mga Kinakailangan](../../../../04-PracticalSamples/foundrylocal).

2. **Suriin ang dynamic na port**. Ang Foundry Local ay awtomatikong nag-aassign ng port kapag ito ay nagsimula. Hanapin ang iyong port gamit:
   ```bash
   foundry service status
   ```
   
   **Opsyonal**: Kung mas gusto mong gumamit ng partikular na port (hal. 5273), maaari mo itong i-configure nang manu-mano:
   ```bash
   foundry service set --port 5273
   ```

3. **I-download ang AI model** na nais mong gamitin, halimbawa, `phi-3.5-mini`, gamit ang sumusunod na command:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **I-configure ang application.properties** file upang tumugma sa iyong Foundry Local settings:
   - I-update ang port sa `base-url` (mula sa hakbang 2), siguraduhing kasama ang `/v1` sa dulo
   - I-update ang pangalan ng model upang isama ang version number (suriin gamit ang `foundry model list`)
   
   Halimbawa:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```

## Pagpapatakbo ng Aplikasyon

### Hakbang 1: Simulan ang Foundry Local
```bash
foundry model run phi-3.5-mini
```

### Hakbang 2: I-build at Patakbuhin ang Aplikasyon
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
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```

## Susunod na Hakbang

Para sa higit pang mga halimbawa, tingnan ang [Kabanata 04: Praktikal na mga halimbawa](../README.md)

## Pag-aayos ng Problema

### Karaniwang Mga Isyu

**"Connection refused" o "Service unavailable"**
- Tiyakin na tumatakbo ang Foundry Local: `foundry model list`
- Suriin ang aktwal na port na ginagamit ng Foundry Local: `foundry service status`
- I-update ang iyong `application.properties` gamit ang tamang port, siguraduhing ang URL ay nagtatapos sa `/v1`
- Bilang alternatibo, mag-set ng partikular na port kung nais: `foundry service set --port 5273`
- Subukang i-restart ang Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" o "404 Not Found" errors**
- Suriin ang mga available na model na may eksaktong ID: `foundry model list`
- I-update ang pangalan ng model sa `application.properties` upang eksaktong tumugma, kabilang ang version number (hal. `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Siguraduhing ang `base-url` ay nagtatapos sa `/v1`: `http://localhost:5273/v1`
- I-download ang model kung kinakailangan: `foundry model run phi-3.5-mini`

**"400 Bad Request" errors**
- Tiyakin na ang base URL ay nagtatapos sa `/v1`: `http://localhost:5273/v1`
- Suriin na ang model ID ay eksaktong tumutugma sa ipinapakita sa `foundry model list`
- Siguraduhing ginagamit ang `maxTokens()` sa halip na `maxCompletionTokens()` sa iyong code

**Mga error sa Maven compilation**
- Siguraduhing Java 21 o mas mataas: `java -version`
- Linisin at i-rebuild: `mvn clean compile`
- Suriin ang koneksyon sa internet para sa pag-download ng mga dependency

**Nagsimula ang application ngunit walang output**
- Tiyakin na tumutugon ang Foundry Local: Buksan ang browser sa `http://localhost:5273`
- Suriin ang application logs para sa partikular na error messages
- Siguraduhing ang model ay ganap na na-load at handa na

---

**Paunawa**:  
Ang dokumentong ito ay isinalin gamit ang AI translation service na [Co-op Translator](https://github.com/Azure/co-op-translator). Bagama't sinisikap naming maging tumpak, mangyaring tandaan na ang mga awtomatikong pagsasalin ay maaaring maglaman ng mga pagkakamali o hindi pagkakatugma. Ang orihinal na dokumento sa kanyang katutubong wika ang dapat ituring na awtoritatibong pinagmulan. Para sa mahalagang impormasyon, inirerekomenda ang propesyonal na pagsasalin ng tao. Hindi kami mananagot sa anumang hindi pagkakaunawaan o maling interpretasyon na dulot ng paggamit ng pagsasaling ito.