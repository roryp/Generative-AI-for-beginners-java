# Foundry Local Spring Boot -opetusohjelma

## Sisällysluettelo

- [Esivaatimukset](#esivaatimukset)
- [Projektin yleiskatsaus](#projektin-yleiskatsaus)
- [Koodin ymmärtäminen](#koodin-ymmärtäminen)
  - [1. Sovelluksen määritykset (application.properties)](#1-sovelluksen-määritykset-applicationproperties)
  - [2. Pääsovellusluokka (Application.java)](#2-pääsovellusluokka-applicationjava)
  - [3. AI-palvelutaso (FoundryLocalService.java)](#3-ai-palvelutaso-foundrylocalservicejava)
  - [4. Projektin riippuvuudet (pom.xml)](#4-projektin-riippuvuudet-pomxml)
- [Miten kaikki toimii yhdessä](#miten-kaikki-toimii-yhdessä)
- [Foundry Localin käyttöönotto](#foundry-localin-käyttöönotto)
- [Sovelluksen suorittaminen](#sovelluksen-suorittaminen)
- [Odotettu tulos](#odotettu-tulos)
- [Seuraavat askeleet](#seuraavat-askeleet)
- [Vianmääritys](#vianmääritys)


## Esivaatimukset

Ennen tämän opetusohjelman aloittamista varmista, että sinulla on:

- **Java 21 tai uudempi** asennettuna järjestelmääsi
- **Maven 3.6+** projektin rakentamiseen
- **Foundry Local** asennettuna ja käynnissä

### **Asenna Foundry Local:**

> **Huom:** Foundry Local CLI on saatavilla vain **Windowsille** ja **macOS:lle**. Linuxia tuetaan [Foundry Local SDK:iden](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust) kautta.

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Vahvista asennus:
```bash
foundry --version
```

## Projektin yleiskatsaus

Tämä projekti koostuu neljästä pääkomponentista:

1. **Application.java** - pääsisäänkäynti Spring Boot -sovellukseen
2. **FoundryLocalService.java** - palvelutaso, joka hoitaa tekoälyn kommunikoinnin
3. **application.properties** - Foundry Local -yhteyden määritykset
4. **pom.xml** - Maven-riippuvuudet ja projektin määritykset

## Koodin ymmärtäminen

### 1. Sovelluksen määritykset (application.properties)

**Tiedosto:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Tämä tekee:**
- **base-url**: Määrittää, missä Foundry Local on käynnissä, mukaan lukien `/v1`-polku OpenAI-rajapinnan yhteensopivuuden vuoksi. Oletusportti on `5273`. Jos portti on eri, tarkista se komennolla `foundry service status`.
- **model** (valinnainen): Nimeää tekoälymallin tekstin generointiin. **Sovellus tunnistaa mallin oletuksena automaattisesti** kysymällä Foundry Localin `/v1/models`-päätepistettä käynnistyksen yhteydessä, joten sinun ei tarvitse asettaa tätä. Voit silti määrittää mallin nimenuudelleen automaattitunnistuksen ohittamiseksi tarvittaessa.

**Keskeinen käsite:** Spring Boot lataa nämä määritykset automaattisesti ja tekee ne sovelluksellesi saataville `@Value`-annotaation avulla.

### 2. Pääsovellusluokka (Application.java)

**Tiedosto:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Ei tarvita web-palvelinta
        app.run(args);
    }
```

**Tämä tekee:**
- `@SpringBootApplication` mahdollistaa Spring Bootin automaattisen määrityksen
- `WebApplicationType.NONE` kertoo Springille, että tämä on komentorivisovellus, ei web-palvelin
- Päämetodi käynnistää Spring-sovelluksen

**Demo Runner:**
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

**Tämä tekee:**
- `@Bean` luo Springin hallitseman komponentin
- `CommandLineRunner` suorittaa koodin Spring Bootin käynnistyksen jälkeen
- `foundryLocalService` injektoidaan automaattisesti Springin toimesta (riippuvuuden injektointi)
- Lähettää testiviestin tekoälylle ja näyttää vastauksen

### 3. AI-palvelutaso (FoundryLocalService.java)

**Tiedosto:** `src/main/java/com/example/FoundryLocalService.java`

#### Määritysten injektointi:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Automaattisesti tunnistettu, jos tyhjä
```

**Tämä tekee:**
- `@Service` kertoo Springille, että luokka tarjoaa liiketoimintalogiikkaa
- `@Value` injektoi arvot application.properties -tiedostosta
- Malli on oletuksena tyhjä, mikä käynnistää **automaattisen tunnistuksen** Foundry Localista käynnistyksen yhteydessä. Tämä tarkoittaa, että sovellus toimii minkä tahansa Foundry Localiin ladatun mallin kanssa ilman manuaalista määritystä.

#### Asiakasohjelman alustaminen:
```java
@PostConstruct
public void init() {
    // Malli tunnistetaan automaattisesti Foundry Localista, jos sitä ei ole nimenomaisesti määritetty
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Perus-URL sisältää jo /v1 määrityksestä
            .apiKey("not-needed")            // Paikallinen palvelin ei tarvitse oikeaa API-avainta
            .build();
}
```

**Tämä tekee:**
- `@PostConstruct` suorittaa tämän metodin sen jälkeen, kun Spring on luonut palvelun
- Jos mallia ei ole määritetty, se kysyy Foundry Localin `/v1/models`-päätepistettä ja valitsee ensimmäisen ladatun mallin
- Luo OpenAI-asiakkaan, joka yhdistää paikalliseen Foundry Local -instanssiisi
- Sovelluksen määrityksissä oleva perus-URL sisältää jo `/v1` OpenAI-rajapinnan yhteensopivuuden takia
- API-avain on asetettu arvoon "not-needed", koska paikallisessa kehityksessä autentikointia ei tarvita

#### Chat-metodi:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Mitä tekoälymallia käyttää
                .addUserMessage(message)         // Kysymyksesi / kehotteesi
                .maxCompletionTokens(150)        // Vastauksen pituuden rajoitus
                .temperature(0.7)                // Hallitse luovuutta (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Poimi tekoälyn vastaus API-tuloksesta
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Tämä tekee:**
- **ChatCompletionCreateParams**: Määrittää tekoälypyynnön asetukset
  - `model`: Valitsee käytettävän tekoälymallin (täytyy täsmätä tarkkaan ID:hen, joka saadaan `foundry model list` -komennolla)
  - `addUserMessage`: Lisää käyttäjän viestin keskusteluun
  - `maxCompletionTokens`: Rajaa vastauksen maksimipituutta (säästää resursseja)
  - `temperature`: Kontrolloi satunnaisuutta (0.0 = deterministinen, 1.0 = luova)
- **API-kutsu**: Lähettää pyynnön Foundry Localille
- **Vastauksen käsittely**: Erottaa turvallisesti tekoälyn tekstivastauksen
- **Virheiden käsittely**: Käärii poikkeukset selkeiksi virheilmoituksiksi

### 4. Projektin riippuvuudet (pom.xml)

**Keskeiset riippuvuudet:**

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

**Tämä tekee:**
- **spring-boot-starter**: Tarjoaa Spring Bootin ydintoiminnot
- **openai-java**: Virallinen OpenAI:n Java SDK rajapintakommunikointiin
- **jackson-databind**: Käsittelee JSON-sarjoituksen ja -desarjoituksen API-kutsuille

## Miten kaikki toimii yhdessä

Tässä on kokonaisvirtaus, kun suoritat sovelluksen:

1. **Käynnistys**: Spring Boot käynnistyy ja lukee `application.properties` -tiedoston
2. **Palvelun luonti**: Spring luo `FoundryLocalService`-instanssin ja injektoi määritysarvot
3. **Mallin tunnistus**: Jos mallia ei ole määritelty, palvelu kysyy Foundry Localin `/v1/models`-päätepistettä ja valitsee automaattisesti ensimmäisen saatavilla olevan mallin
4. **Asiakkaan alustaminen**: `@PostConstruct` alustaa OpenAI-asiakkaan yhdistääkseen Foundry Localiin
5. **Demon suoritus**: `CommandLineRunner` suoritetaan käynnistyksen jälkeen
6. **Tekoälykutsu**: Demo kutsuu `foundryLocalService.chat()` -metodia testiviestillä
7. **API-pyyntö**: Palvelu rakentaa ja lähettää OpenAI-yhteensopivan pyynnön Foundry Localille
8. **Vastauksen käsittely**: Palvelu erottaa ja palauttaa tekoälyn vastauksen
9. **Näyttö**: Sovellus tulostaa vastauksen ja lopettaa

## Foundry Localin käyttöönotto

1. **Asenna Foundry Local** [Esivaatimukset](#esivaatimukset) -kohdassa annettujen ohjeiden mukaisesti.

2. **Käynnistä palvelu** (jos ei vielä käynnissä):
   ```bash
   foundry service start
   ```

3. **Tarkista palvelun tila** varmistaaksesi, että se on käynnissä ja huomioi portti:
   ```bash
   foundry service status
   ```

4. **Lataa ja käynnistä malli** (lataa ensimmäisellä käynnillä, välimuistissa myöhempiä käyntejä varten):
   ```bash
   foundry model run phi-4-mini
   ```
   Tämä avaa interaktiivisen chat-istunnon. Voit poistua painamalla `Ctrl+C`. Malli pysyy ladattuna palvelussa.

   > **Vinkki:** Suorita `foundry model list` nähdäksesi kaikki saatavilla olevat mallit. Korvaa `phi-4-mini` millä tahansa alias-nimellä katalogista (esim. `qwen2.5-0.5b` pienempää/nopeampaa mallia varten).

5. **Varmista, että malli on ladattu:**
   ```bash
   foundry service ps
   ```

6. **Päivitä `application.properties` tarvittaessa:**
   - Oletus-`base-url` (`http://localhost:5273/v1`) vastaa oletusporttia CLI:ssä. Päivitä vain, jos `foundry service status` näyttää toisen portin.
   - Malli tunnistetaan **automaattisesti** käynnistyksen yhteydessä — määritystä ei tarvita.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Sovelluksen suorittaminen

### Vaihe 1: Varmista, että malli on ladattu Foundry Localissa
```bash
foundry service ps
```
Jos malleja ei ole listattu, lataa yksi:
```bash
foundry model run phi-4-mini
```

### Vaihe 2: Rakenna ja suorita sovellus
Avaa toinen terminaali:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Tai rakenna ja suorita JAR-tiedostona:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Odotettu tulos

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

## Seuraavat askeleet

Lisää esimerkkejä löydät [Luku 04: Käytännön esimerkit](../README.md)

## Vianmääritys

### Yleisiä ongelmia

**"Connection refused" tai "Service unavailable"**
- Tarkista palvelu komennolla: `foundry service status`
- Käynnistä uudelleen tarvittaessa: `foundry service restart`
- Tarkista, että `application.properties`-tiedoston portti vastaa `foundry service status` -tulosta
- Varmista, että URL päättyy `/v1`:llä: `http://localhost:5273/v1`

**"No model found" käynnistyksessä**
- Sovellus tunnistaa mallin automaattisesti. Varmista, että vähintään yksi malli on ladattu komennolla: `foundry service ps`
- Jos malleja ei ole ladattu: `foundry model run phi-4-mini`
- Jos olet määrännyt mallin nimen `application.properties`-tiedostossa, varmista, että se täsmää `foundry model list` -listan kanssa

**"400 Bad Request" -virheet**
- Varmista, että base URL sisältää `/v1`:n: `http://localhost:5273/v1`
- Varmista, että käytät `maxCompletionTokens()`:ia koodissasi (ei vanhentunutta `maxTokens()`-metodia)

**Maven-käännösvirheet**
- Varmista, että Java 21 tai uudempi on asennettuna: `java -version`
- Siivoa ja rakenna uudelleen: `mvn clean compile`
- Tarkista verkkoyhteys riippuvuuksien latausta varten

**Palvelin-yhteysongelmat**
- Jos näet virheen `Request to local service failed`, suorita: `foundry service restart`
- Tarkista ladatut mallit: `foundry service ps`
- Katso palvelun lokit: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Vastuuvapauslauseke**:  
Tämä asiakirja on käännetty käyttämällä tekoälypohjaista käännöspalvelua [Co-op Translator](https://github.com/Azure/co-op-translator). Pyrimme tarkkuuteen, mutta huomioithan, että automaattikäännöksissä saattaa esiintyä virheitä tai epätarkkuuksia. Alkuperäinen asiakirja sen alkuperäiskielellä on katsottava viralliseksi lähteeksi. Tärkeiden tietojen osalta suositellaan ammattimaista ihmiskääntäjää. Emme ota vastuuta tästä käännöksestä johtuvista väärinkäsityksistä tai virheellisistä tulkinnoista.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->