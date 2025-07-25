<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d064108b2142d32246ccbd8a42e76b4d",
  "translation_date": "2025-07-25T10:14:38+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "sl"
}
-->
# Lokalna ukazna vrstica Foundry

>**Opomba**: To poglavje vključuje [**Vadnico**](./TUTORIAL.md), ki vas vodi skozi primere.

Preprosta ukazna aplikacija Spring Boot, ki prikazuje, kako se povezati z Foundry Local z uporabo OpenAI Java SDK.

## Kaj se boste naučili

- Kako integrirati Foundry Local z aplikacijami Spring Boot z uporabo OpenAI Java SDK
- Najboljše prakse za lokalni razvoj in testiranje umetne inteligence

## Kazalo

- [Kaj se boste naučili](../../../../04-PracticalSamples/foundrylocal)
- [Predpogoji](../../../../04-PracticalSamples/foundrylocal)
  - [Namestitev Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Preverjanje](../../../../04-PracticalSamples/foundrylocal)
- [Konfiguracija](../../../../04-PracticalSamples/foundrylocal)
- [Hiter začetek](../../../../04-PracticalSamples/foundrylocal)
- [Kaj aplikacija počne](../../../../04-PracticalSamples/foundrylocal)
- [Primer izhoda](../../../../04-PracticalSamples/foundrylocal)
- [Arhitektura](../../../../04-PracticalSamples/foundrylocal)
- [Poudarki kode](../../../../04-PracticalSamples/foundrylocal)
  - [Integracija OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [API za dokončanje pogovorov](../../../../04-PracticalSamples/foundrylocal)
- [Odpravljanje težav](../../../../04-PracticalSamples/foundrylocal)

## Predpogoji

> **⚠️ Opomba**: Ta aplikacija **ne deluje v priloženem devcontainerju**, saj zahteva, da je Foundry Local nameščen in delujoč na gostiteljskem sistemu.

### Namestitev Foundry Local

Pred zagonom te aplikacije morate namestiti in zagnati Foundry Local. Sledite tem korakom:

1. **Prepričajte se, da vaš sistem izpolnjuje zahteve**:
   - **Operacijski sistem**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 ali macOS
   - **Strojna oprema**: 
     - Minimalno: 8 GB RAM, 3 GB prostega prostora na disku
     - Priporočeno: 16 GB RAM, 15 GB prostega prostora na disku
   - **Omrežje**: Internetna povezava za začetni prenos modela (neobvezno za uporabo brez povezave)
   - **Pospeševanje (neobvezno)**: NVIDIA GPU (serija 2000 ali novejša), AMD GPU (serija 6000 ali novejša), Qualcomm Snapdragon X Elite (8 GB ali več pomnilnika) ali Apple silicon
   - **Dovoljenja**: Skrbniške pravice za namestitev programske opreme na vašo napravo

2. **Namestite Foundry Local**:
   
   **Za Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **Za macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Alternativno lahko prenesete namestitveni program iz [Foundry Local GitHub repozitorija](https://github.com/microsoft/Foundry-Local).

3. **Zaženite svoj prvi model**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Model se prenese (kar lahko traja nekaj minut, odvisno od hitrosti vaše internetne povezave) in nato zažene. Foundry Local samodejno izbere najboljšo različico modela za vaš sistem (CUDA za NVIDIA GPU-je, sicer CPU različico).

4. **Preizkusite model** tako, da v istem terminalu zastavite vprašanje:

   ```bash
   Why is the sky blue?
   ```

   Videti bi morali odgovor modela Phi, ki pojasnjuje, zakaj je nebo videti modro.

### Preverjanje

Delovanje lahko preverite z naslednjimi ukazi:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Prav tako lahko obiščete `http://localhost:5273` v svojem brskalniku, da si ogledate spletni vmesnik Foundry Local.

## Konfiguracija

Aplikacijo lahko konfigurirate prek datoteke `application.properties`:

- `foundry.local.base-url` - Osnovni URL za Foundry Local (privzeto: http://localhost:5273)
- `foundry.local.model` - AI model, ki se uporablja (privzeto: Phi-3.5-mini-instruct-cuda-gpu)

> **Opomba**: Ime modela v konfiguraciji mora ustrezati specifični različici, ki jo je Foundry Local prenesel za vaš sistem. Ko zaženete `foundry model run phi-3.5-mini`, Foundry Local samodejno izbere in prenese najboljšo različico (CUDA za NVIDIA GPU-je, sicer CPU različico). Uporabite `foundry model list`, da si ogledate natančno ime modela, ki je na voljo v vaši lokalni instanci.

## Hiter začetek

### 1. Pojdite v imenik aplikacije Foundry Local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Zaženite aplikacijo

```bash
mvn spring-boot:run
```

Ali pa sestavite in zaženite JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Odvisnosti

Ta aplikacija uporablja OpenAI Java SDK za komunikacijo z Foundry Local. Ključna odvisnost je:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Aplikacija je predhodno konfigurirana za povezavo z Foundry Local, ki deluje na privzetem portu.

## Kaj aplikacija počne

Ko zaženete aplikacijo:

1. **Zažene se** kot ukazna aplikacija (brez spletnega strežnika)
2. **Samodejno pošlje** testno sporočilo: "Pozdravljeni! Mi lahko poveste, kaj ste in kateri model uporabljate?"
3. **Prikaže odgovor** Foundry Local v konzoli
4. **Čisto se zapre** po predstavitvi

## Primer izhoda

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Arhitektura

- **Application.java** - Glavna aplikacija Spring Boot z CommandLineRunner
- **FoundryLocalService.java** - Storitev, ki uporablja OpenAI Java SDK za komunikacijo z Foundry Local
- Uporablja **OpenAI Java SDK** za tip-varne API klice
- Samodejna serializacija/deserializacija JSON, ki jo obravnava SDK
- Čista konfiguracija z uporabo Springovih anotacij `@Value` in `@PostConstruct`

## Poudarki kode

### Integracija OpenAI Java SDK

Aplikacija uporablja OpenAI Java SDK za ustvarjanje odjemalca, konfiguriranega za Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### API za dokončanje pogovorov

Pošiljanje zahtev za dokončanje pogovorov je preprosto in tip-varno:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Odpravljanje težav

Če naletite na napake pri povezavi:
1. Preverite, ali Foundry Local deluje na `http://localhost:5273`
2. Preverite, ali je različica modela Phi-3.5-mini na voljo z ukazom `foundry model list`
3. Prepričajte se, da ime modela v `application.properties` ustreza natančnemu imenu modela, prikazanemu na seznamu
4. Preverite, ali požarni zid ne blokira povezave

Pogoste težave:
- **Model ni najden**: Zaženite `foundry model run phi-3.5-mini`, da prenesete in zaženete model
- **Storitev ne deluje**: Storitev Foundry Local se je morda ustavila; ponovno jo zaženite z ukazom za zagon modela
- **Napačno ime modela**: Uporabite `foundry model list`, da si ogledate razpoložljive modele in ustrezno posodobite svojo konfiguracijo

**Omejitev odgovornosti**:  
Ta dokument je bil preveden z uporabo storitve AI za prevajanje [Co-op Translator](https://github.com/Azure/co-op-translator). Čeprav si prizadevamo za natančnost, vas prosimo, da upoštevate, da lahko avtomatizirani prevodi vsebujejo napake ali netočnosti. Izvirni dokument v njegovem maternem jeziku je treba obravnavati kot avtoritativni vir. Za ključne informacije priporočamo profesionalni človeški prevod. Ne prevzemamo odgovornosti za morebitne nesporazume ali napačne razlage, ki izhajajo iz uporabe tega prevoda.