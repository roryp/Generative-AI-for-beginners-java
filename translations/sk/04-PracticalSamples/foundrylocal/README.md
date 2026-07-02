# Foundry Local Spring Boot Tutoriál

## Obsah

- [Predpoklady](#prerekvizity)
- [Prehľad projektu](#prehľad-projektu)
- [Pochopenie kódu](#pochopenie-kódu)
  - [1. Konfigurácia aplikácie (application.properties)](#1-konfigurácia-aplikácie-applicationproperties)
  - [2. Hlavná trieda aplikácie (Application.java)](#2-hlavná-trieda-aplikácie-applicationjava)
  - [3. Vrstva AI služby (FoundryLocalService.java)](#3-vrstva-ai-služby-foundrylocalservicejava)
  - [4. Závislosti projektu (pom.xml)](#4-závislosti-projektu-pomxml)
- [Ako to všetko spolu funguje](#ako-to-všetko-spolu-funguje)
- [Nastavenie Foundry Local](#nastavenie-foundry-local)
- [Spustenie aplikácie](#spustenie-aplikácie)
- [Očakávaný výstup](#očakávaný-výstup)
- [Ďalšie kroky](#ďalšie-kroky)
- [Riešenie problémov](#riešenie-problémov)


## Prerekvizity

Pred začiatkom tohto tutoriálu sa uistite, že máte:

- **Java 21 alebo novšiu** nainštalovanú vo vašom systéme
- **Maven 3.6+** na zostavenie projektu
- **Foundry Local** nainštalovaný a spustený

### **Inštalácia Foundry Local:**

> **Poznámka:** Foundry Local CLI je dostupný iba pre **Windows** a **macOS**. Linux je podporovaný cez [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Overte inštaláciu:
```bash
foundry --version
```

## Prehľad projektu

Tento projekt pozostáva zo štyroch hlavných komponentov:

1. **Application.java** - Hlavný vstupný bod Spring Boot aplikácie
2. **FoundryLocalService.java** - Vrstva služby, ktorá rieši komunikáciu s AI
3. **application.properties** - Konfigurácia spojenia s Foundry Local
4. **pom.xml** - Maven závislosti a konfigurácia projektu

## Pochopenie kódu

### 1. Konfigurácia aplikácie (application.properties)

**Súbor:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Čo to robí:**
- **base-url**: Špecifikuje, kde Foundry Local beží, vrátane cesty `/v1` pre kompatibilitu s OpenAI API. Predvolený port je `5273`. Ak sa port líši, skontrolujte ho príkazom `foundry service status`.
- **model** (voliteľné): Názov AI modelu použitého na generovanie textu. **Aplikácia štandardne automaticky zistí model** dotazom na `/v1/models` Foundry Local pri štarte, takže ho nemusíte nastavovať. Môžete ho nastaviť explicitne, ak chcete prekonať automatickú detekciu.

**Kľúčový koncept:** Spring Boot automaticky načíta tieto vlastnosti a sprístupní ich aplikácii pomocou anotácie `@Value`.

### 2. Hlavná trieda aplikácie (Application.java)

**Súbor:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Nie je potrebný webový server
        app.run(args);
    }
```

**Čo to robí:**
- `@SpringBootApplication` umožňuje automatickú konfiguráciu Spring Boot
- `WebApplicationType.NONE` hovorí Springu, že ide o príkazový riadok, nie webový server
- Hlavná metóda spúšťa Spring aplikáciu

**Demo spúšťač:**
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

**Čo to robí:**
- `@Bean` vytvára komponentu, ktorú Spring spravuje
- `CommandLineRunner` spustí kód po štarte Spring Boot
- `foundryLocalService` je automaticky injektovaný Springom (injektáž závislostí)
- Posiela testovaciu správu AI a zobrazí odpoveď

### 3. Vrstva AI služby (FoundryLocalService.java)

**Súbor:** `src/main/java/com/example/FoundryLocalService.java`

#### Injektáž konfigurácie:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Automaticky zistené, ak je prázdne
```

**Čo to robí:**
- `@Service` hovorí Springu, že táto trieda poskytuje obchodnú logiku
- `@Value` injektuje hodnoty konfigurácie z application.properties
- Model je predvolene prázdny, čo spúšťa **automatickú detekciu** modelu zo Foundry Local pri štarte. To znamená, že aplikácia funguje s akýmkoľvek modelom nahraným v Foundry Local bez manuálnej konfigurácie.

#### Inicializácia klienta:
```java
@PostConstruct
public void init() {
    // Automaticky zistiť model z Foundry Local, ak nie je explicitne nakonfigurovaný
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Základná URL už obsahuje /v1 z konfigurácie
            .apiKey("not-needed")            // Lokálny server nepotrebuje skutočný API kľúč
            .build();
}
```

**Čo to robí:**
- `@PostConstruct` spustí túto metódu po vytvorení služby Springom
- Ak nie je nastavený model, dotazuje sa na `/v1/models` Foundry Local a zvolí prvý nahraný model
- Vytvorí OpenAI klienta, ktorý smeruje na vašu lokálnu inštanciu Foundry Local
- Base URL z `application.properties` už obsahuje `/v1` pre kompatibilitu s OpenAI API
- API kľúč je nastavený na "not-needed", pretože lokálny vývoj nevyžaduje autentifikáciu

#### Metóda pre chat:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Ktorý AI model použiť
                .addUserMessage(message)         // Vaša otázka/podnet
                .maxCompletionTokens(150)        // Obmedziť dĺžku odpovede
                .temperature(0.7)                // Ovládanie kreativity (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extrahovať odpoveď AI z výsledku API
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
  - `model`: Špecifikuje AI model na použitie (musí presne zodpovedať ID z `foundry model list`)
  - `addUserMessage`: Pridá vašu správu do konverzácie
  - `maxCompletionTokens`: Ohradzuje dĺžku odpovede (šetrí zdroje)
  - `temperature`: Kontroluje náhodnosť (0.0 = deterministické, 1.0 = kreatívne)
- **API volanie**: Posiela požiadavku Foundry Local
- **Spracovanie odpovede**: Bezpečne získa textovú odpoveď AI
- **Riešenie chýb**: Zabalí výnimky s užitočnými chybovými hláseniami

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

**Čo to robia:**
- **spring-boot-starter**: Poskytuje základnú funkcionalitu Spring Boot
- **openai-java**: Oficiálne OpenAI Java SDK pre komunikáciu s API
- **jackson-databind**: Spracováva serializáciu/deserializáciu JSON pre API volania

## Ako to všetko spolu funguje

Tu je kompletný tok, keď spustíte aplikáciu:

1. **Štart**: Spring Boot sa spustí a načíta `application.properties`
2. **Vytvorenie služby**: Spring vytvorí `FoundryLocalService` a injektuje konfiguračné hodnoty
3. **Detekcia modelu**: Ak nie je model nastavený, služba sa dotáže Foundry Local `/v1/models` a automaticky použije prvý dostupný model
4. **Nastavenie klienta**: `@PostConstruct` inicializuje OpenAI klienta na prepojenie s Foundry Local
5. **Spustenie demo**: `CommandLineRunner` sa vykoná po štarte
6. **Volanie AI**: Demo zavolá `foundryLocalService.chat()` s testovacou správou
7. **Žiadosť API**: Služba vytvorí a odošle OpenAI-kompatibilnú požiadavku Foundry Local
8. **Spracovanie odpovede**: Služba extrahuje a vráti odpoveď AI
9. **Zobrazenie**: Aplikácia vytlačí odpoveď a skončí

## Nastavenie Foundry Local

1. **Nainštalujte Foundry Local** podľa inštrukcií v sekcii [Prerekvizity](#prerekvizity).

2. **Spustite službu** (ak ešte neběží):
   ```bash
   foundry service start
   ```

3. **Skontrolujte stav služby** a zapamätajte si port:
   ```bash
   foundry service status
   ```

4. **Stiahnite a spustite model** (pri prvom spustení sa stiahne, na ďalšie spustenia je už v cache):
   ```bash
   foundry model run phi-4-mini
   ```
   Tento príkaz otvorí interaktívnu chatovaciu reláciu. Ukončíte ju stlačením `Ctrl+C`. Model zostáva nahraný v službe.

   > **Tip:** Spustite `foundry model list` pre zobrazenie všetkých dostupných modelov. Nahradte `phi-4-mini` ľubovoľnou aliasom z katalógu (napr. `qwen2.5-0.5b` pre menší/rychlejší model).

5. **Overte, že je model nahraný:**
   ```bash
   foundry service ps
   ```

6. **Aktualizujte `application.properties` ak je potrebné:**
   - Predvolený `base-url` (`http://localhost:5273/v1`) zodpovedá predvolenému portu CLI. Aktualizujte len, ak `foundry service status` ukáže iný port.
   - Model je **automaticky detekovaný** pri štarte — konfigurácia nie je potrebná.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Spustenie aplikácie

### Krok 1: Uistite sa, že je model nahraný v Foundry Local
```bash
foundry service ps
```
Ak nie sú žiadne modely, nahrajte jeden:
```bash
foundry model run phi-4-mini
```

### Krok 2: Skompilujte a spustite aplikáciu
V inom termináli:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Alebo zostavte a spustite ako JAR:
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
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## Ďalšie kroky

Pre viac príkladov pozrite [Kapitolu 04: Praktické príklady](../README.md)

## Riešenie problémov

### Bežné problémy

**„Connection refused“ alebo „Service unavailable“**
- Skontrolujte službu: `foundry service status`
- Reštartujte ak treba: `foundry service restart`
- Skontrolujte, či port v `application.properties` zodpovedá výstupu `foundry service status`
- Uistite sa, že URL končí na `/v1`: `http://localhost:5273/v1`

**„No model found“ pri štarte**
- Aplikácia automaticky detekuje model. Uistite sa, že je aspoň jeden model nahraný: `foundry service ps`
- Ak nie sú nahrané modely: `foundry model run phi-4-mini`
- Ak ste prepisovali názov modelu v `application.properties`, overte jeho zhodu s `foundry model list`

**Chyby „400 Bad Request“**
- Skontrolujte, že base URL obsahuje `/v1`: `http://localhost:5273/v1`
- Používajte `maxCompletionTokens()` v kóde, nie zastaralé `maxTokens()`

**Chyby kompilácie Maven**
- Uistite sa, že používate Java 21 alebo novšiu: `java -version`
- Vyčistite a zostavte projekt: `mvn clean compile`
- Skontrolujte internetové pripojenie pre sťahovanie závislostí

**Problémy s pripojením k službe**
- Ak vidíte `Request to local service failed`, spustite: `foundry service restart`
- Skontrolujte nahrané modely: `foundry service ps`
- Prezrite logy služby: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Zrieknutie sa zodpovednosti**:  
Tento dokument bol preložený pomocou AI prekladateľskej služby [Co-op Translator](https://github.com/Azure/co-op-translator). Hoci sa snažíme o presnosť, berte prosím na vedomie, že automatické preklady môžu obsahovať chyby alebo nepresnosti. Originálny dokument v jeho pôvodnom jazyku sa považuje za autoritatívny zdroj. Pre kritické informácie sa odporúča profesionálny ľudský preklad. Za akékoľvek nedorozumenia alebo nesprávne interpretácie vyplývajúce z použitia tohto prekladu nenesieme zodpovednosť.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->