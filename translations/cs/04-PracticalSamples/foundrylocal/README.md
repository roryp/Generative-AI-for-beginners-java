<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d064108b2142d32246ccbd8a42e76b4d",
  "translation_date": "2025-07-25T10:01:31+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "cs"
}
-->
# Lokální příkazová aplikace Foundry

>**Poznámka**: Tato kapitola obsahuje [**Návod**](./TUTORIAL.md), který vás provede ukázkami.

Jednoduchá příkazová aplikace Spring Boot, která demonstruje, jak se připojit k Foundry Local pomocí OpenAI Java SDK.

## Co se naučíte

- Jak integrovat Foundry Local do aplikací Spring Boot pomocí OpenAI Java SDK
- Nejlepší postupy pro lokální vývoj a testování AI

## Obsah

- [Co se naučíte](../../../../04-PracticalSamples/foundrylocal)
- [Předpoklady](../../../../04-PracticalSamples/foundrylocal)
  - [Instalace Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Ověření](../../../../04-PracticalSamples/foundrylocal)
- [Konfigurace](../../../../04-PracticalSamples/foundrylocal)
- [Rychlý start](../../../../04-PracticalSamples/foundrylocal)
- [Co aplikace dělá](../../../../04-PracticalSamples/foundrylocal)
- [Ukázkový výstup](../../../../04-PracticalSamples/foundrylocal)
- [Architektura](../../../../04-PracticalSamples/foundrylocal)
- [Důležité části kódu](../../../../04-PracticalSamples/foundrylocal)
  - [Integrace OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [API pro dokončování chatů](../../../../04-PracticalSamples/foundrylocal)
- [Řešení problémů](../../../../04-PracticalSamples/foundrylocal)

## Předpoklady

> **⚠️ Poznámka**: Tato aplikace **neběží v dodaném devcontaineru**, protože vyžaduje, aby byl Foundry Local nainstalován a spuštěn na hostitelském systému.

### Instalace Foundry Local

Před spuštěním této aplikace je nutné nainstalovat a spustit Foundry Local. Postupujte podle těchto kroků:

1. **Ujistěte se, že váš systém splňuje požadavky**:
   - **Operační systém**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 nebo macOS
   - **Hardware**: 
     - Minimálně: 8 GB RAM, 3 GB volného místa na disku
     - Doporučeno: 16 GB RAM, 15 GB volného místa na disku
   - **Síť**: Internetové připojení pro počáteční stažení modelu (volitelné pro offline použití)
   - **Akcelerace (volitelné)**: NVIDIA GPU (řada 2000 nebo novější), AMD GPU (řada 6000 nebo novější), Qualcomm Snapdragon X Elite (8 GB nebo více paměti) nebo Apple silicon
   - **Oprávnění**: Administrátorská práva pro instalaci softwaru na vašem zařízení

2. **Nainstalujte Foundry Local**:
   
   **Pro Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **Pro macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Alternativně můžete stáhnout instalační program z [Foundry Local GitHub repozitáře](https://github.com/microsoft/Foundry-Local).

3. **Spusťte svůj první model**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Model se stáhne (což může trvat několik minut v závislosti na rychlosti vašeho internetu) a poté se spustí. Foundry Local automaticky vybere nejlepší variantu modelu pro váš systém (CUDA pro NVIDIA GPU, verze pro CPU jinak).

4. **Otestujte model** položením otázky ve stejném terminálu:

   ```bash
   Why is the sky blue?
   ```

   Měli byste vidět odpověď od modelu Phi, která vysvětluje, proč je obloha modrá.

### Ověření

Můžete ověřit, že vše funguje správně pomocí těchto příkazů:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Můžete také navštívit `http://localhost:5273` ve svém prohlížeči a zobrazit webové rozhraní Foundry Local.

## Konfigurace

Aplikaci lze konfigurovat prostřednictvím `application.properties`:

- `foundry.local.base-url` - Základní URL pro Foundry Local (výchozí: http://localhost:5273)
- `foundry.local.model` - AI model, který se má použít (výchozí: Phi-3.5-mini-instruct-cuda-gpu)

> **Poznámka**: Název modelu v konfiguraci by měl odpovídat konkrétní variantě, kterou Foundry Local stáhl pro váš systém. Když spustíte `foundry model run phi-3.5-mini`, Foundry Local automaticky vybere a stáhne nejlepší variantu (CUDA pro NVIDIA GPU, verze pro CPU jinak). Použijte `foundry model list`, abyste viděli přesný název modelu dostupného ve vaší lokální instanci.

## Rychlý start

### 1. Přejděte do adresáře aplikace Foundry Local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Spusťte aplikaci

```bash
mvn spring-boot:run
```

Nebo sestavte a spusťte JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Závislosti

Tato aplikace používá OpenAI Java SDK pro komunikaci s Foundry Local. Klíčová závislost je:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Aplikace je předem nakonfigurována pro připojení k Foundry Local běžícímu na výchozím portu.

## Co aplikace dělá

Když aplikaci spustíte:

1. **Spustí se** jako příkazová aplikace (bez webového serveru)
2. **Automaticky odešle** testovací zprávu: "Ahoj! Můžeš mi říct, co jsi a jaký model používáš?"
3. **Zobrazí odpověď** od Foundry Local v konzoli
4. **Čistě ukončí** po ukázce

## Ukázkový výstup

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Architektura

- **Application.java** - Hlavní aplikace Spring Boot s CommandLineRunner
- **FoundryLocalService.java** - Služba, která používá OpenAI Java SDK pro komunikaci s Foundry Local
- Používá **OpenAI Java SDK** pro typově bezpečné API volání
- Automatická serializace/deserializace JSON zajištěná SDK
- Čistá konfigurace pomocí Spring anotací `@Value` a `@PostConstruct`

## Důležité části kódu

### Integrace OpenAI Java SDK

Aplikace používá OpenAI Java SDK k vytvoření klienta nakonfigurovaného pro Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### API pro dokončování chatů

Vytváření požadavků na dokončování chatů je jednoduché a typově bezpečné:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Řešení problémů

Pokud se objeví chyby připojení:
1. Ověřte, že Foundry Local běží na `http://localhost:5273`
2. Zkontrolujte, zda je dostupná varianta modelu Phi-3.5-mini pomocí `foundry model list`
3. Ujistěte se, že název modelu v `application.properties` odpovídá přesnému názvu modelu uvedenému v seznamu
4. Ujistěte se, že žádný firewall neblokuje připojení

Běžné problémy:
- **Model nebyl nalezen**: Spusťte `foundry model run phi-3.5-mini`, abyste stáhli a spustili model
- **Služba neběží**: Služba Foundry Local mohla být zastavena; restartujte ji pomocí příkazu pro spuštění modelu
- **Špatný název modelu**: Použijte `foundry model list`, abyste viděli dostupné modely a aktualizovali svou konfiguraci.

**Upozornění**:  
Tento dokument byl přeložen pomocí služby pro automatický překlad [Co-op Translator](https://github.com/Azure/co-op-translator). I když se snažíme o přesnost, mějte prosím na paměti, že automatické překlady mohou obsahovat chyby nebo nepřesnosti. Původní dokument v jeho původním jazyce by měl být považován za závazný zdroj. Pro důležité informace se doporučuje profesionální lidský překlad. Neodpovídáme za jakékoli nedorozumění nebo nesprávné interpretace vyplývající z použití tohoto překladu.