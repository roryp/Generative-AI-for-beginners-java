<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T21:19:20+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "hr"
}
-->
# Foundry Lokalna Komandno-linijska Aplikacija

>**Napomena**: Ovo poglavlje uključuje [**Vodič**](./TUTORIAL.md) koji vas vodi kroz pokretanje gotovih primjera.

Jednostavna Spring Boot komandno-linijska aplikacija koja demonstrira kako se povezati s Foundry Lokalnim koristeći OpenAI Java SDK.

## Što ćete naučiti

- Kako integrirati Foundry Lokalni sa Spring Boot aplikacijama koristeći OpenAI Java SDK
- Najbolje prakse za lokalni razvoj i testiranje AI-a

## Sadržaj

- [Što ćete naučiti](../../../../04-PracticalSamples/foundrylocal)
- [Preduvjeti](../../../../04-PracticalSamples/foundrylocal)
  - [Instalacija Foundry Lokalnog](../../../../04-PracticalSamples/foundrylocal)
  - [Verifikacija](../../../../04-PracticalSamples/foundrylocal)
- [Konfiguracija](../../../../04-PracticalSamples/foundrylocal)
- [Brzi početak](../../../../04-PracticalSamples/foundrylocal)
- [Što aplikacija radi](../../../../04-PracticalSamples/foundrylocal)
- [Primjer izlaza](../../../../04-PracticalSamples/foundrylocal)
- [Arhitektura](../../../../04-PracticalSamples/foundrylocal)
- [Istaknuti dijelovi koda](../../../../04-PracticalSamples/foundrylocal)
  - [Integracija OpenAI Java SDK-a](../../../../04-PracticalSamples/foundrylocal)
  - [API za dovršavanje razgovora](../../../../04-PracticalSamples/foundrylocal)
- [Rješavanje problema](../../../../04-PracticalSamples/foundrylocal)

## Preduvjeti

> **⚠️ Napomena**: Ova aplikacija **ne radi u priloženom devcontaineru** jer zahtijeva da Foundry Lokalni bude instaliran i pokrenut na host sustavu.

### Instalacija Foundry Lokalnog

Prije pokretanja ove aplikacije, potrebno je instalirati i pokrenuti Foundry Lokalni. Slijedite ove korake:

1. **Provjerite da vaš sustav ispunjava zahtjeve**:
   - **Operativni sustav**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 ili macOS
   - **Hardver**: 
     - Minimalno: 8GB RAM-a, 3GB slobodnog prostora na disku
     - Preporučeno: 16GB RAM-a, 15GB slobodnog prostora na disku
   - **Mreža**: Internet veza za početno preuzimanje modela (opcionalno za offline korištenje)
   - **Ubrzanje (opcionalno)**: NVIDIA GPU (serija 2,000 ili novija), AMD GPU (serija 6,000 ili novija), Qualcomm Snapdragon X Elite (8GB ili više memorije) ili Apple silicon
   - **Dozvole**: Administratorske privilegije za instalaciju softvera na vašem uređaju

2. **Instalirajte Foundry Lokalni**:
   
   **Za Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **Za macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Alternativno, možete preuzeti instalacijski program s [Foundry Lokalnog GitHub repozitorija](https://github.com/microsoft/Foundry-Local).

3. **Pokrenite svoj prvi model**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Model se preuzima (što može potrajati nekoliko minuta, ovisno o brzini interneta) i zatim pokreće. Foundry Lokalni automatski odabire najbolju varijantu modela za vaš sustav (CUDA za NVIDIA GPU-ove, inače CPU verziju).

4. **Testirajte model** postavljanjem pitanja u istom terminalu:

   ```bash
   Why is the sky blue?
   ```

   Trebali biste vidjeti odgovor od Phi modela koji objašnjava zašto nebo izgleda plavo.

### Verifikacija

Možete provjeriti radi li sve ispravno pomoću ovih naredbi:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Također možete posjetiti `http://localhost:5273` u svom pregledniku kako biste vidjeli web sučelje Foundry Lokalnog.

## Konfiguracija

Aplikacija se može konfigurirati putem `application.properties`:

- `foundry.local.base-url` - Osnovni URL za Foundry Lokalni (zadano: http://localhost:5273)
- `foundry.local.model` - AI model koji se koristi (zadano: Phi-3.5-mini-instruct-cuda-gpu)

> **Napomena**: Naziv modela u konfiguraciji treba odgovarati specifičnoj varijanti koju je Foundry Lokalni preuzeo za vaš sustav. Kada pokrenete `foundry model run phi-3.5-mini`, Foundry Lokalni automatski odabire i preuzima najbolju varijantu (CUDA za NVIDIA GPU-ove, inače CPU verziju). Koristite `foundry model list` za pregled točnog naziva modela dostupnog u vašoj lokalnoj instanci.

## Brzi početak

### 1. Idite u direktorij aplikacije foundry lokalnog
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Pokrenite aplikaciju

```bash
mvn spring-boot:run
```

Ili izgradite i pokrenite JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Ovisnosti

Ova aplikacija koristi OpenAI Java SDK za komunikaciju s Foundry Lokalnim. Ključna ovisnost je:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Aplikacija je unaprijed konfigurirana za povezivanje s Foundry Lokalnim koji radi na zadanoj mrežnoj adresi.

## Što aplikacija radi

Kada pokrenete aplikaciju:

1. **Pokreće se** kao komandno-linijska aplikacija (bez web servera)
2. **Automatski šalje** testnu poruku: "Pozdrav! Možete li mi reći što ste i koji model koristite?"
3. **Prikazuje odgovor** od Foundry Lokalnog u konzoli
4. **Čisto izlazi** nakon demonstracije

## Primjer izlaza

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Arhitektura

- **Application.java** - Glavna Spring Boot aplikacija s CommandLineRunner-om
- **FoundryLocalService.java** - Servis koji koristi OpenAI Java SDK za komunikaciju s Foundry Lokalnim
- Koristi **OpenAI Java SDK** za tip-sigurne API pozive
- Automatska JSON serializacija/deserializacija koju obrađuje SDK
- Čista konfiguracija koristeći Springove `@Value` i `@PostConstruct` anotacije

## Istaknuti dijelovi koda

### Integracija OpenAI Java SDK-a

Aplikacija koristi OpenAI Java SDK za kreiranje klijenta konfiguriranog za Foundry Lokalni:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### API za dovršavanje razgovora

Slanje zahtjeva za dovršavanje razgovora je jednostavno i tip-sigurno:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Rješavanje problema

Ako vidite greške povezivanja:
1. Provjerite radi li Foundry Lokalni na `http://localhost:5273`
2. Provjerite je li Phi-3.5-mini varijanta modela dostupna pomoću `foundry model list`
3. Provjerite odgovara li naziv modela u `application.properties` točnom nazivu modela prikazanom na popisu
4. Provjerite blokira li vatrozid vezu

Uobičajeni problemi:
- **Model nije pronađen**: Pokrenite `foundry model run phi-3.5-mini` za preuzimanje i pokretanje modela
- **Servis ne radi**: Servis Foundry Lokalnog možda je prestao raditi; ponovno ga pokrenite pomoću naredbe za pokretanje modela
- **Pogrešan naziv modela**: Koristite `foundry model list` za pregled dostupnih modela i ažurirajte svoju konfiguraciju prema potrebi

**Odricanje od odgovornosti**:  
Ovaj dokument je preveden pomoću AI usluge za prevođenje [Co-op Translator](https://github.com/Azure/co-op-translator). Iako nastojimo osigurati točnost, imajte na umu da automatski prijevodi mogu sadržavati pogreške ili netočnosti. Izvorni dokument na izvornom jeziku treba smatrati autoritativnim izvorom. Za kritične informacije preporučuje se profesionalni prijevod od strane čovjeka. Ne preuzimamo odgovornost za nesporazume ili pogrešna tumačenja koja mogu proizaći iz korištenja ovog prijevoda.