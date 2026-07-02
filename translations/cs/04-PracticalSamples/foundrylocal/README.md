# Foundry Local Spring Boot Tutoriál

## Obsah

- [Požadavky](#požadavky)
- [Přehled projektu](#přehled-projektu)
- [Porozumění kódu](#porozumění-kódu)
  - [1. Konfigurace aplikace (application.properties)](#1-konfigurace-aplikace-applicationproperties)
  - [2. Hlavní třída aplikace (Application.java)](#2-hlavní-třída-aplikace-applicationjava)
  - [3. Vrstva AI služby (FoundryLocalService.java)](#3-vrstva-ai-služby-foundrylocalservicejava)
  - [4. Závislosti projektu (pom.xml)](#4-závislosti-projektu-pomxml)
- [Jak to všechno funguje dohromady](#jak-to-všechno-funguje-dohromady)
- [Nastavení Foundry Local](#nastavení-foundry-local)
- [Spuštění aplikace](#spuštění-aplikace)
- [Očekávaný výstup](#očekávaný-výstup)
- [Další kroky](#další-kroky)
- [Řešení problémů](#řešení-problémů)


## Požadavky

Před zahájením tohoto tutoriálu si ověřte, že máte:

- **Java 21 nebo vyšší** nainstalovanou ve vašem systému
- **Maven 3.6+** pro sestavení projektu
- **Foundry Local** nainstalovaný a spuštěný

### **Instalace Foundry Local:**

> **Poznámka:** Foundry Local CLI je dostupný pouze na **Windows** a **macOS**. Linux je podporován přes [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Ověření instalace:
```bash
foundry --version
```

## Přehled projektu

Tento projekt se skládá ze čtyř hlavních částí:

1. **Application.java** - hlavní vstupní bod Spring Boot aplikace
2. **FoundryLocalService.java** - servisní vrstva zajišťující komunikaci s AI
3. **application.properties** - konfigurace připojení k Foundry Local
4. **pom.xml** - Maven závislosti a konfigurace projektu

## Porozumění kódu

### 1. Konfigurace aplikace (application.properties)

**Soubor:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Co to dělá:**
- **base-url**: Určuje, kde běží Foundry Local, včetně cesty `/v1` pro kompatibilitu s OpenAI API. Výchozí port je `5273`. Pokud je port jiný, zjistěte ho pomocí `foundry service status`.
- **model** (volitelné): Název AI modelu, který se má použít pro generování textu. **Ve výchozím nastavení aplikace model automaticky detekuje** dotazem na endpoint Foundry Local `/v1/models` při spuštění, takže ho nemusíte nastavovat. Přesto lze nastavit explicitně pro přepsání automatické detekce, pokud je třeba.

**Klíčový koncept:** Spring Boot tyto vlastnosti načítá automaticky a zpřístupňuje je vaší aplikaci pomocí anotace `@Value`.

### 2. Hlavní třída aplikace (Application.java)

**Soubor:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Webový server není potřeba
        app.run(args);
    }
```

**Co to dělá:**
- `@SpringBootApplication` povoluje automatickou konfiguraci Spring Boot
- `WebApplicationType.NONE` říká Springu, že jde o příkazovou aplikaci, nikoli webový server
- hlavní metoda spouští Spring aplikaci

**Demo běžec:**
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

**Co to dělá:**
- `@Bean` vytváří komponentu, kterou Spring spravuje
- `CommandLineRunner` spustí kód po startu Spring Boot
- `foundryLocalService` je do metody automaticky injektován Springem (injektáž závislosti)
- pošle testovací zprávu AI a zobrazí odpověď

### 3. Vrstva AI služby (FoundryLocalService.java)

**Soubor:** `src/main/java/com/example/FoundryLocalService.java`

#### Injektáž konfigurace:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Automaticky zjištěno, pokud je prázdné
```

**Co to dělá:**
- `@Service` říká Springu, že tato třída poskytuje byznys logiku
- `@Value` injektuje konfigurační hodnoty z application.properties
- model má výchozí hodnotu prázdnou, což spouští **automatickou detekci** z Foundry Local při startu. To znamená, že aplikace funguje s jakýmkoli modelem načteným ve Foundry Local bez manuální konfigurace.

#### Inicializace klienta:
```java
@PostConstruct
public void init() {
    // Automaticky detekujte model z Foundry Local, pokud není explicitně nakonfigurován
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Základní URL již obsahuje /v1 z konfigurace
            .apiKey("not-needed")            // Lokální server nepotřebuje skutečný API klíč
            .build();
}
```

**Co to dělá:**
- `@PostConstruct` spustí tuto metodu po vytvoření služby Springem
- Pokud není model nastaven, dotáže se endpointu Foundry Local `/v1/models` a vezme první dostupný model
- Vytvoří OpenAI klienta, který míří na vaši lokální instanci Foundry Local
- Base URL z `application.properties` už obsahuje `/v1` pro kompatibilitu s OpenAI API
- API klíč je nastaven na "not-needed", protože lokální vývoj nevyžaduje autentizaci

#### Metoda chat:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Který AI model použít
                .addUserMessage(message)         // Vaše otázka/podnět
                .maxCompletionTokens(150)        // Omezit délku odpovědi
                .temperature(0.7)                // Ovládat kreativitu (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extrahovat odpověď AI z výsledku API
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Co to dělá:**
- **ChatCompletionCreateParams**: Konfiguruje požadavek na AI
  - `model`: Specifikuje, který AI model použít (musí přesně odpovídat ID z `foundry model list`)
  - `addUserMessage`: Přidá vaši zprávu do konverzace
  - `maxCompletionTokens`: Omezuje délku odpovědi (šetří zdroje)
  - `temperature`: Řídí náhodnost (0.0 = deterministické, 1.0 = kreativní)
- **API volání**: Odesílá požadavek do Foundry Local
- **Zpracování odpovědi**: Bezpečně vyjme textovou odpověď AI
- **Zpracování chyb**: Zabalí výjimky s vysvětlujícími chybovými hláškami

### 4. Závislosti projektu (pom.xml)

**Klíčové závislosti:**

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

**Co dělají:**
- **spring-boot-starter**: Poskytuje základní funkcionalitu Spring Boot
- **openai-java**: Oficiální OpenAI Java SDK pro komunikaci s API
- **jackson-databind**: Zpracovává serializaci a deserializaci JSON pro API volání

## Jak to všechno funguje dohromady

Zde je kompletní postup, když spustíte aplikaci:

1. **Start**: Spring Boot se spustí a načte `application.properties`
2. **Vytvoření služby**: Spring vytvoří `FoundryLocalService` a injektuje konfigurační hodnoty
3. **Detekce modelu**: Pokud není model nastaven, služba se dotáže endpointu Foundry Local `/v1/models` a automaticky vybere první dostupný model
4. **Nastavení klienta**: `@PostConstruct` inicializuje OpenAI klienta pro připojení k Foundry Local
5. **Spuštění dema**: `CommandLineRunner` se provede po startu
6. **Volání AI**: Demo zavolá `foundryLocalService.chat()` s testovací zprávou
7. **API požadavek**: Služba sestaví a odešle request kompatibilní s OpenAI do Foundry Local
8. **Zpracování odpovědi**: Služba extrahuje a vrátí odpověď AI
9. **Zobrazení**: Aplikace vypíše odpověď a ukončí se

## Nastavení Foundry Local

1. **Nainstalujte Foundry Local** podle instrukcí v sekci [Požadavky](#požadavky).

2. **Spusťte službu** (pokud už neběží):
   ```bash
   foundry service start
   ```

3. **Zkontrolujte stav služby** pro ověření, že běží, a poznamenejte si port:
   ```bash
   foundry service status
   ```

4. **Stáhněte a spusťte model** (stahuje se při prvním spuštění, pak se cachuje):
   ```bash
   foundry model run phi-4-mini
   ```
   Tím se otevře interaktivní chatovací relace. Ukončíte ji pomocí `Ctrl+C`. Model zůstává načtený ve službě.

   > **Tip:** Spusťte `foundry model list` pro zobrazení všech dostupných modelů. Vyměňte `phi-4-mini` za libovolný alias z katalogu (např. `qwen2.5-0.5b` pro menší/rychlejší model).

5. **Ověřte, že je model načten:**
   ```bash
   foundry service ps
   ```

6. **Aktualizujte `application.properties`, pokud je potřeba:**
   - Výchozí `base-url` (`http://localhost:5273/v1`) odpovídá výchozímu portu CLI. Aktualizujte jen pokud `foundry service status` hlásí jiný port.
   - Model je **automaticky detekován** při startu — není potřeba manuální konfigurace.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Spuštění aplikace

### Krok 1: Zajistěte, že je model načtený ve Foundry Local
```bash
foundry service ps
```
Pokud nejsou žádné modely uvedeny, načtěte jeden:
```bash
foundry model run phi-4-mini
```

### Krok 2: Sestavte a spusťte aplikaci
V samostatném terminálu:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Nebo sestavte a spusťte jako JAR:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Očekávaný výstup

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

## Další kroky

Pro více příkladů viz [Kapitola 04: Praktické ukázky](../README.md)

## Řešení problémů

### Běžné problémy

**„Connection refused“ nebo „Service unavailable“**
- Zkontrolujte službu: `foundry service status`
- Restartujte, pokud je třeba: `foundry service restart`
- Ověřte, že port v `application.properties` odpovídá výstupu `foundry service status`
- Ujistěte se, že URL končí na `/v1`: `http://localhost:5273/v1`

**„No model found“ při startu**
- Aplikace model automaticky detekuje. Ujistěte se, že je načten alespoň jeden model: `foundry service ps`
- Pokud žádné modely nejsou načteny: `foundry model run phi-4-mini`
- Pokud jste přepsali název modelu v `application.properties`, ověřte, že odpovídá `foundry model list`

**Chyby „400 Bad Request“**
- Ověřte, že base URL obsahuje `/v1`: `http://localhost:5273/v1`
- Ujistěte se, že ve svém kódu používáte `maxCompletionTokens()` (ne deprecated `maxTokens()`)

**Chyby kompilace Maven**
- Ověřte verzi Javy 21 nebo vyšší: `java -version`
- Vyčistěte a znovu sestavte: `mvn clean compile`
- Zkontrolujte internetové připojení pro stažení závislostí

**Problémy s připojením ke službě**
- Pokud vidíte `Request to local service failed`, spusťte: `foundry service restart`
- Zkontrolujte načtené modely: `foundry service ps`
- Zobrazte logy služby: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Prohlášení o vyloučení odpovědnosti**:  
Tento dokument byl přeložen pomocí AI překladatelské služby [Co-op Translator](https://github.com/Azure/co-op-translator). Přestože usilujeme o přesnost, mějte prosím na paměti, že automatické překlady mohou obsahovat chyby nebo nepřesnosti. Originální dokument v jeho původním jazyce by měl být považován za autoritativní zdroj. Pro důležité informace se doporučuje profesionální lidský překlad. Nejsme odpovědní za jakékoli nedorozumění nebo nesprávné interpretace vzniklé použitím tohoto překladu.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->