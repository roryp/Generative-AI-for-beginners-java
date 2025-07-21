<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T21:17:45+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "sk"
}
-->
# Foundry Local Command-Line Aplikácia

>**Poznámka**: Táto kapitola obsahuje [**tutoriál**](./TUTORIAL.md), ktorý vás prevedie spustením hotových ukážok.

Jednoduchá command-line aplikácia postavená na Spring Boot, ktorá demonštruje, ako sa pripojiť k Foundry Local pomocou OpenAI Java SDK.

## Čo sa naučíte

- Ako integrovať Foundry Local so Spring Boot aplikáciami pomocou OpenAI Java SDK
- Najlepšie postupy pre lokálny vývoj a testovanie AI

## Obsah

- [Čo sa naučíte](../../../../04-PracticalSamples/foundrylocal)
- [Predpoklady](../../../../04-PracticalSamples/foundrylocal)
  - [Inštalácia Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Overenie](../../../../04-PracticalSamples/foundrylocal)
- [Konfigurácia](../../../../04-PracticalSamples/foundrylocal)
- [Rýchly štart](../../../../04-PracticalSamples/foundrylocal)
- [Čo aplikácia robí](../../../../04-PracticalSamples/foundrylocal)
- [Ukážkový výstup](../../../../04-PracticalSamples/foundrylocal)
- [Architektúra](../../../../04-PracticalSamples/foundrylocal)
- [Kľúčové časti kódu](../../../../04-PracticalSamples/foundrylocal)
  - [Integrácia OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [Chat Completion API](../../../../04-PracticalSamples/foundrylocal)
- [Riešenie problémov](../../../../04-PracticalSamples/foundrylocal)

## Predpoklady

> **⚠️ Poznámka**: Táto aplikácia **nefunguje v dodanom devcontaineri**, pretože vyžaduje, aby Foundry Local bolo nainštalované a spustené na hostiteľskom systéme.

### Inštalácia Foundry Local

Pred spustením tejto aplikácie je potrebné nainštalovať a spustiť Foundry Local. Postupujte podľa týchto krokov:

1. **Uistite sa, že váš systém spĺňa požiadavky**:
   - **Operačný systém**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 alebo macOS
   - **Hardvér**: 
     - Minimálne: 8GB RAM, 3GB voľného miesta na disku
     - Odporúčané: 16GB RAM, 15GB voľného miesta na disku
   - **Sieť**: Internetové pripojenie na počiatočné stiahnutie modelu (voliteľné pre offline použitie)
   - **Akcelerácia (voliteľné)**: NVIDIA GPU (séria 2000 alebo novšia), AMD GPU (séria 6000 alebo novšia), Qualcomm Snapdragon X Elite (8GB alebo viac pamäte) alebo Apple silicon
   - **Oprávnenia**: Administrátorské práva na inštaláciu softvéru na vašom zariadení

2. **Nainštalujte Foundry Local**:
   
   **Pre Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **Pre macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Alternatívne môžete stiahnuť inštalátor z [Foundry Local GitHub repozitára](https://github.com/microsoft/Foundry-Local).

3. **Spustite svoj prvý model**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Model sa stiahne (čo môže trvať niekoľko minút v závislosti od rýchlosti internetu) a následne sa spustí. Foundry Local automaticky vyberie najvhodnejší variant modelu pre váš systém (CUDA pre NVIDIA GPU, inak CPU verzia).

4. **Otestujte model** položením otázky v rovnakom termináli:

   ```bash
   Why is the sky blue?
   ```

   Mali by ste vidieť odpoveď od modelu Phi, ktorá vysvetľuje, prečo je obloha modrá.

### Overenie

Môžete overiť, či všetko funguje správne, pomocou týchto príkazov:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Môžete tiež navštíviť `http://localhost:5273` vo vašom prehliadači a zobraziť webové rozhranie Foundry Local.

## Konfigurácia

Aplikácia sa konfiguruje prostredníctvom `application.properties`:

- `foundry.local.base-url` - Základná URL adresa pre Foundry Local (predvolené: http://localhost:5273)
- `foundry.local.model` - AI model, ktorý sa má použiť (predvolené: Phi-3.5-mini-instruct-cuda-gpu)

> **Poznámka**: Názov modelu v konfigurácii by mal zodpovedať konkrétnemu variantu, ktorý Foundry Local stiahol pre váš systém. Keď spustíte `foundry model run phi-3.5-mini`, Foundry Local automaticky vyberie a stiahne najlepší variant (CUDA pre NVIDIA GPU, inak CPU verzia). Použite `foundry model list` na zobrazenie presného názvu modelu dostupného vo vašej lokálnej inštancii.

## Rýchly štart

### 1. Prejdite do adresára aplikácie Foundry Local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Spustite aplikáciu

```bash
mvn spring-boot:run
```

Alebo zostavte a spustite JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Závislosti

Táto aplikácia používa OpenAI Java SDK na komunikáciu s Foundry Local. Kľúčová závislosť je:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Aplikácia je predkonfigurovaná na pripojenie k Foundry Local bežiacemu na predvolenom porte.

## Čo aplikácia robí

Keď spustíte aplikáciu:

1. **Spustí sa** ako command-line aplikácia (bez webového servera)
2. **Automaticky odošle** testovaciu správu: "Hello! Can you tell me what you are and what model you're running?"
3. **Zobrazí odpoveď** od Foundry Local v konzole
4. **Čisto ukončí** po ukážke

## Ukážkový výstup

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Architektúra

- **Application.java** - Hlavná Spring Boot aplikácia s CommandLineRunner
- **FoundryLocalService.java** - Služba, ktorá používa OpenAI Java SDK na komunikáciu s Foundry Local
- Používa **OpenAI Java SDK** na typovo bezpečné API volania
- Automatická JSON serializácia/deserializácia spracovaná SDK
- Čistá konfigurácia pomocou Spring anotácií `@Value` a `@PostConstruct`

## Kľúčové časti kódu

### Integrácia OpenAI Java SDK

Aplikácia používa OpenAI Java SDK na vytvorenie klienta nakonfigurovaného pre Foundry Local:

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

Vytváranie požiadaviek na dokončenie chatu je jednoduché a typovo bezpečné:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Riešenie problémov

Ak sa zobrazia chyby pripojenia:
1. Overte, že Foundry Local beží na `http://localhost:5273`
2. Skontrolujte, či je dostupný variant modelu Phi-3.5-mini pomocou `foundry model list`
3. Uistite sa, že názov modelu v `application.properties` zodpovedá presnému názvu modelu uvedenému v zozname
4. Skontrolujte, či firewall neblokuje pripojenie

Bežné problémy:
- **Model nebol nájdený**: Spustite `foundry model run phi-3.5-mini` na stiahnutie a spustenie modelu
- **Služba nebeží**: Služba Foundry Local mohla prestať fungovať; reštartujte ju príkazom na spustenie modelu
- **Nesprávny názov modelu**: Použite `foundry model list` na zobrazenie dostupných modelov a aktualizujte svoju konfiguráciu podľa toho

**Upozornenie**:  
Tento dokument bol preložený pomocou služby AI prekladu [Co-op Translator](https://github.com/Azure/co-op-translator). Aj keď sa snažíme o presnosť, prosím, berte na vedomie, že automatizované preklady môžu obsahovať chyby alebo nepresnosti. Pôvodný dokument v jeho rodnom jazyku by mal byť považovaný za autoritatívny zdroj. Pre kritické informácie sa odporúča profesionálny ľudský preklad. Nie sme zodpovední za akékoľvek nedorozumenia alebo nesprávne interpretácie vyplývajúce z použitia tohto prekladu.