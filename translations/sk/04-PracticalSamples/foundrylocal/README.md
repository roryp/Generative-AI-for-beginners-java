<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "713d81fd7d28a865068df047e26c8f12",
  "translation_date": "2025-11-03T20:14:34+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "sk"
}
-->
# Foundry Local Spring Boot Tutoriál

## Obsah

- [Predpoklady](../../../../04-PracticalSamples/foundrylocal)
- [Prehľad projektu](../../../../04-PracticalSamples/foundrylocal)
- [Porozumenie kódu](../../../../04-PracticalSamples/foundrylocal)
  - [1. Konfigurácia aplikácie (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Hlavná trieda aplikácie (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. Vrstva AI služby (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Závislosti projektu (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Ako to všetko spolu funguje](../../../../04-PracticalSamples/foundrylocal)
- [Nastavenie Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [Spustenie aplikácie](../../../../04-PracticalSamples/foundrylocal)
- [Očakávaný výstup](../../../../04-PracticalSamples/foundrylocal)
- [Ďalšie kroky](../../../../04-PracticalSamples/foundrylocal)
- [Riešenie problémov](../../../../04-PracticalSamples/foundrylocal)

## Predpoklady

Pred začatím tohto tutoriálu sa uistite, že máte:

- **Java 21 alebo vyššiu** nainštalovanú na vašom systéme
- **Maven 3.6+** na zostavenie projektu
- **Foundry Local** nainštalovaný a spustený

### **Inštalácia Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```


## Prehľad projektu

Tento projekt pozostáva zo štyroch hlavných komponentov:

1. **Application.java** - Hlavný vstupný bod aplikácie Spring Boot
2. **FoundryLocalService.java** - Vrstva služby, ktorá spracováva komunikáciu s AI
3. **application.properties** - Konfigurácia pre pripojenie k Foundry Local
4. **pom.xml** - Závislosti Maven a konfigurácia projektu

## Porozumenie kódu

### 1. Konfigurácia aplikácie (application.properties)

**Súbor:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**Čo to robí:**
- **base-url**: Určuje, kde je Foundry Local spustený, vrátane cesty `/v1` pre kompatibilitu s OpenAI API. **Poznámka**: Foundry Local dynamicky priraďuje port, takže si skontrolujte aktuálny port pomocou `foundry service status`
- **model**: Názov AI modelu na generovanie textu, vrátane čísla verzie (napr. `:1`). Použite `foundry model list` na zobrazenie dostupných modelov s ich presnými ID

**Kľúčový koncept:** Spring Boot automaticky načíta tieto vlastnosti a sprístupní ich vašej aplikácii pomocou anotácie `@Value`.

### 2. Hlavná trieda aplikácie (Application.java)

**Súbor:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```

**Čo to robí:**
- `@SpringBootApplication` umožňuje automatickú konfiguráciu Spring Boot
- `WebApplicationType.NONE` hovorí Springu, že ide o aplikáciu príkazového riadku, nie webový server
- Hlavná metóda spúšťa aplikáciu Spring

**Demo Runner:**
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

**Čo to robí:**
- `@Bean` vytvára komponent, ktorý spravuje Spring
- `CommandLineRunner` spúšťa kód po štarte Spring Boot
- `foundryLocalService` je automaticky injektovaný Springom (dependency injection)
- Posiela testovaciu správu AI a zobrazuje odpoveď

### 3. Vrstva AI služby (FoundryLocalService.java)

**Súbor:** `src/main/java/com/example/FoundryLocalService.java`

#### Injekcia konfigurácie:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```

**Čo to robí:**
- `@Service` hovorí Springu, že táto trieda poskytuje obchodnú logiku
- `@Value` injektuje hodnoty konfigurácie z application.properties
- Syntax `:default-value` poskytuje predvolené hodnoty, ak vlastnosti nie sú nastavené

#### Inicializácia klienta:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```

**Čo to robí:**
- `@PostConstruct` spúšťa túto metódu po vytvorení služby Springom
- Vytvára klienta OpenAI, ktorý smeruje na vašu lokálnu inštanciu Foundry Local
- Základná URL z `application.properties` už obsahuje `/v1` pre kompatibilitu s OpenAI API
- API kľúč je nastavený na "not-needed", pretože lokálny vývoj nevyžaduje autentifikáciu

#### Metóda Chat:
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

**Čo to robí:**
- **ChatCompletionCreateParams**: Konfiguruje požiadavku na AI
  - `model`: Určuje, ktorý AI model sa má použiť (musí presne zodpovedať ID z `foundry model list`)
  - `addUserMessage`: Pridáva vašu správu do konverzácie
  - `maxTokens`: Obmedzuje dĺžku odpovede (šetrenie zdrojov)
  - `temperature`: Riadi náhodnosť (0.0 = deterministické, 1.0 = kreatívne)
- **API Call**: Posiela požiadavku na Foundry Local
- **Spracovanie odpovede**: Bezpečne extrahuje textovú odpoveď AI
- **Spracovanie chýb**: Obaluje výnimky s užitočnými chybovými správami

### 4. Závislosti projektu (pom.xml)

**Kľúčové závislosti:**

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

**Čo robia:**
- **spring-boot-starter**: Poskytuje základnú funkcionalitu Spring Boot
- **openai-java**: Oficiálne OpenAI Java SDK pre komunikáciu s API
- **jackson-databind**: Spracováva JSON serializáciu/deserializáciu pre API volania

## Ako to všetko spolu funguje

Tu je kompletný tok, keď spustíte aplikáciu:

1. **Štart**: Spring Boot sa spustí a načíta `application.properties`
2. **Vytvorenie služby**: Spring vytvorí `FoundryLocalService` a injektuje hodnoty konfigurácie
3. **Nastavenie klienta**: `@PostConstruct` inicializuje klienta OpenAI na pripojenie k Foundry Local
4. **Spustenie dema**: `CommandLineRunner` sa vykoná po štarte
5. **Volanie AI**: Demo volá `foundryLocalService.chat()` s testovacou správou
6. **Požiadavka API**: Služba zostaví a pošle požiadavku kompatibilnú s OpenAI na Foundry Local
7. **Spracovanie odpovede**: Služba extrahuje a vráti odpoveď AI
8. **Zobrazenie**: Aplikácia vytlačí odpoveď a ukončí sa

## Nastavenie Foundry Local

Na nastavenie Foundry Local postupujte podľa týchto krokov:

1. **Nainštalujte Foundry Local** podľa pokynov v sekcii [Predpoklady](../../../../04-PracticalSamples/foundrylocal).

2. **Skontrolujte dynamicky priradený port**. Foundry Local automaticky priraďuje port pri štarte. Nájdite svoj port pomocou:
   ```bash
   foundry service status
   ```
   
   **Voliteľné**: Ak preferujete používať konkrétny port (napr. 5273), môžete ho manuálne nastaviť:
   ```bash
   foundry service set --port 5273
   ```

3. **Stiahnite AI model**, ktorý chcete použiť, napríklad `phi-3.5-mini`, pomocou nasledujúceho príkazu:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **Konfigurujte súbor application.properties** tak, aby zodpovedal nastaveniam Foundry Local:
   - Aktualizujte port v `base-url` (z kroku 2), uistite sa, že obsahuje `/v1` na konci
   - Aktualizujte názov modelu tak, aby obsahoval číslo verzie (skontrolujte pomocou `foundry model list`)
   
   Príklad:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## Spustenie aplikácie

### Krok 1: Spustite Foundry Local
```bash
foundry model run phi-3.5-mini
```

### Krok 2: Zostavte a spustite aplikáciu
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```


## Očakávaný výstup

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


## Ďalšie kroky

Pre viac príkladov si pozrite [Kapitolu 04: Praktické ukážky](../README.md)

## Riešenie problémov

### Bežné problémy

**"Connection refused" alebo "Service unavailable"**
- Uistite sa, že Foundry Local je spustený: `foundry model list`
- Skontrolujte aktuálny port, ktorý Foundry Local používa: `foundry service status`
- Aktualizujte váš `application.properties` so správnym portom, uistite sa, že URL končí `/v1`
- Alternatívne nastavte konkrétny port, ak je to potrebné: `foundry service set --port 5273`
- Skúste reštartovať Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" alebo "404 Not Found" chyby**
- Skontrolujte dostupné modely s ich presnými ID: `foundry model list`
- Aktualizujte názov modelu v `application.properties`, aby presne zodpovedal, vrátane čísla verzie (napr. `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Uistite sa, že `base-url` obsahuje `/v1` na konci: `http://localhost:5273/v1`
- Stiahnite model, ak je to potrebné: `foundry model run phi-3.5-mini`

**"400 Bad Request" chyby**
- Overte, že základná URL obsahuje `/v1`: `http://localhost:5273/v1`
- Skontrolujte, či ID modelu presne zodpovedá tomu, čo je uvedené v `foundry model list`
- Uistite sa, že používate `maxTokens()` namiesto `maxCompletionTokens()` vo vašom kóde

**Chyby kompilácie Maven**
- Uistite sa, že máte Java 21 alebo vyššiu: `java -version`
- Vyčistite a znovu zostavte: `mvn clean compile`
- Skontrolujte internetové pripojenie pre stiahnutie závislostí

**Aplikácia sa spustí, ale bez výstupu**
- Overte, že Foundry Local odpovedá: Otvorte prehliadač na `http://localhost:5273`
- Skontrolujte logy aplikácie pre konkrétne chybové správy
- Uistite sa, že model je plne načítaný a pripravený

---

**Zrieknutie sa zodpovednosti**:  
Tento dokument bol preložený pomocou služby AI prekladu [Co-op Translator](https://github.com/Azure/co-op-translator). Aj keď sa snažíme o presnosť, prosím, berte na vedomie, že automatizované preklady môžu obsahovať chyby alebo nepresnosti. Pôvodný dokument v jeho rodnom jazyku by mal byť považovaný za autoritatívny zdroj. Pre kritické informácie sa odporúča profesionálny ľudský preklad. Nenesieme zodpovednosť za akékoľvek nedorozumenia alebo nesprávne interpretácie vyplývajúce z použitia tohto prekladu.