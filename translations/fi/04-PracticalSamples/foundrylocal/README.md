<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T19:48:32+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "fi"
}
-->
# Foundry Local - Paikallinen komentorivisovellus

>**Huom**: Tämä luku sisältää [**Opetusohjelman**](./TUTORIAL.md), joka opastaa sinut valmiiden esimerkkien suorittamisessa.

Yksinkertainen Spring Boot -komentorivisovellus, joka havainnollistaa, kuinka yhdistää Foundry Local -palveluun OpenAI Java SDK:n avulla.

## Mitä opit

- Kuinka integroida Foundry Local Spring Boot -sovelluksiin OpenAI Java SDK:n avulla
- Parhaat käytännöt paikalliseen tekoälykehitykseen ja -testaukseen

## Sisällysluettelo

- [Mitä opit](../../../../04-PracticalSamples/foundrylocal)
- [Esivaatimukset](../../../../04-PracticalSamples/foundrylocal)
  - [Foundry Localin asentaminen](../../../../04-PracticalSamples/foundrylocal)
  - [Varmistus](../../../../04-PracticalSamples/foundrylocal)
- [Konfigurointi](../../../../04-PracticalSamples/foundrylocal)
- [Pika-aloitus](../../../../04-PracticalSamples/foundrylocal)
- [Mitä sovellus tekee](../../../../04-PracticalSamples/foundrylocal)
- [Esimerkkituloste](../../../../04-PracticalSamples/foundrylocal)
- [Arkkitehtuuri](../../../../04-PracticalSamples/foundrylocal)
- [Koodin kohokohdat](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI Java SDK -integraatio](../../../../04-PracticalSamples/foundrylocal)
  - [Chat Completion API](../../../../04-PracticalSamples/foundrylocal)
- [Vianmääritys](../../../../04-PracticalSamples/foundrylocal)

## Esivaatimukset

> **⚠️ Huom**: Tämä sovellus **ei toimi mukana toimitetussa devcontainerissa**, koska se vaatii Foundry Localin asennettuna ja käynnissä isäntäjärjestelmässä.

### Foundry Localin asentaminen

Ennen kuin suoritat tämän sovelluksen, sinun on asennettava ja käynnistettävä Foundry Local. Noudata näitä ohjeita:

1. **Varmista, että järjestelmäsi täyttää vaatimukset**:
   - **Käyttöjärjestelmä**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 tai macOS
   - **Laitteisto**: 
     - Vähintään: 8GB RAM, 3GB vapaata levytilaa
     - Suositus: 16GB RAM, 15GB vapaata levytilaa
   - **Verkko**: Internet-yhteys mallin alkuperäistä latausta varten (valinnainen offline-käyttöön)
   - **Kiihdytys (valinnainen)**: NVIDIA GPU (2000-sarja tai uudempi), AMD GPU (6000-sarja tai uudempi), Qualcomm Snapdragon X Elite (vähintään 8GB muistia) tai Apple silicon
   - **Oikeudet**: Järjestelmänvalvojan oikeudet ohjelmiston asentamiseen laitteellesi

2. **Asenna Foundry Local**:
   
   **Windowsille:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **macOS:lle:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Vaihtoehtoisesti voit ladata asennusohjelman [Foundry Localin GitHub-repositorysta](https://github.com/microsoft/Foundry-Local).

3. **Käynnistä ensimmäinen malli**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Malli ladataan (tämä voi kestää muutaman minuutin internet-yhteyden nopeudesta riippuen) ja käynnistyy. Foundry Local valitsee automaattisesti järjestelmällesi parhaan mallivaihtoehdon (CUDA NVIDIA GPU:ille, CPU-versio muuten).

4. **Testaa mallia** kysymällä kysymys samassa terminaalissa:

   ```bash
   Why is the sky blue?
   ```

   Näet vastauksen Phi-mallilta, joka selittää, miksi taivas näyttää siniseltä.

### Varmistus

Voit varmistaa, että kaikki toimii oikein näillä komennoilla:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Voit myös avata selaimessasi `http://localhost:5273` nähdäksesi Foundry Localin verkkokäyttöliittymän.

## Konfigurointi

Sovellusta voidaan konfiguroida tiedoston `application.properties` avulla:

- `foundry.local.base-url` - Foundry Localin perus-URL (oletus: http://localhost:5273)
- `foundry.local.model` - Käytettävä AI-malli (oletus: Phi-3.5-mini-instruct-cuda-gpu)

> **Huom**: Konfiguraatiossa käytetyn mallin nimen tulee vastata tarkasti sitä mallivaihtoehtoa, jonka Foundry Local on ladannut järjestelmällesi. Kun suoritat `foundry model run phi-3.5-mini`, Foundry Local valitsee ja lataa automaattisesti parhaan vaihtoehdon (CUDA NVIDIA GPU:ille, CPU-versio muuten). Käytä komentoa `foundry model list` nähdäksesi tarkka mallin nimi, joka on saatavilla paikallisessa instanssissasi.

## Pika-aloitus

### 1. Siirry Foundry Local -sovelluksen hakemistoon
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Suorita sovellus

```bash
mvn spring-boot:run
```

Tai rakenna ja suorita JAR-tiedosto:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Riippuvuudet

Tämä sovellus käyttää OpenAI Java SDK:ta kommunikoidakseen Foundry Localin kanssa. Keskeinen riippuvuus on:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Sovellus on esikonfiguroitu yhdistämään Foundry Localiin, joka toimii oletusportissa.

## Mitä sovellus tekee

Kun suoritat sovelluksen:

1. **Käynnistyy** komentorivisovelluksena (ei verkkopalvelinta)
2. **Lähettää automaattisesti** testiviestin: "Hello! Can you tell me what you are and what model you're running?"
3. **Näyttää vastauksen** Foundry Localilta konsolissa
4. **Sulkeutuu siististi** demon jälkeen

## Esimerkkituloste

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Arkkitehtuuri

- **Application.java** - Pääasiallinen Spring Boot -sovellus, jossa on CommandLineRunner
- **FoundryLocalService.java** - Palvelu, joka käyttää OpenAI Java SDK:ta kommunikoidakseen Foundry Localin kanssa
- Käyttää **OpenAI Java SDK:ta** tyypitettyihin API-kutsuihin
- Automaattinen JSON-serialisointi/deserialisointi SDK:n avulla
- Selkeä konfigurointi Springin `@Value`- ja `@PostConstruct`-annotaatioiden avulla

## Koodin kohokohdat

### OpenAI Java SDK -integraatio

Sovellus käyttää OpenAI Java SDK:ta luodakseen asiakkaan, joka on konfiguroitu Foundry Localille:

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

Chat Completion -pyyntöjen tekeminen on yksinkertaista ja tyypitettyä:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Vianmääritys

Jos kohtaat yhteysvirheitä:
1. Varmista, että Foundry Local on käynnissä osoitteessa `http://localhost:5273`
2. Tarkista, että Phi-3.5-mini-mallivaihtoehto on saatavilla komennolla `foundry model list`
3. Varmista, että `application.properties`-tiedoston mallin nimi vastaa tarkasti listassa näkyvää mallin nimeä
4. Varmista, ettei palomuuri estä yhteyttä

Yleisiä ongelmia:
- **Mallia ei löydy**: Suorita `foundry model run phi-3.5-mini` ladataksesi ja käynnistääksesi mallin
- **Palvelu ei ole käynnissä**: Foundry Local -palvelu on saattanut pysähtyä; käynnistä se uudelleen mallin suorituskomennolla
- **Väärä mallin nimi**: Käytä komentoa `foundry model list` nähdäksesi saatavilla olevat mallit ja päivitä konfiguraatiosi vastaavasti

**Vastuuvapauslauseke**:  
Tämä asiakirja on käännetty käyttämällä tekoälypohjaista käännöspalvelua [Co-op Translator](https://github.com/Azure/co-op-translator). Vaikka pyrimme tarkkuuteen, huomioithan, että automaattiset käännökset voivat sisältää virheitä tai epätarkkuuksia. Alkuperäistä asiakirjaa sen alkuperäisellä kielellä tulisi pitää ensisijaisena lähteenä. Kriittisen tiedon osalta suositellaan ammattimaista ihmiskäännöstä. Emme ole vastuussa väärinkäsityksistä tai virhetulkinnoista, jotka johtuvat tämän käännöksen käytöstä.