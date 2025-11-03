<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "713d81fd7d28a865068df047e26c8f12",
  "translation_date": "2025-11-03T20:18:46+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "lt"
}
-->
# Foundry Local Spring Boot Pamoka

## Turinys

- [Būtinos sąlygos](../../../../04-PracticalSamples/foundrylocal)
- [Projekto apžvalga](../../../../04-PracticalSamples/foundrylocal)
- [Kodo supratimas](../../../../04-PracticalSamples/foundrylocal)
  - [1. Programos konfigūracija (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Pagrindinė programos klasė (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI paslaugų sluoksnis (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Projekto priklausomybės (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Kaip viskas veikia kartu](../../../../04-PracticalSamples/foundrylocal)
- [Foundry Local nustatymas](../../../../04-PracticalSamples/foundrylocal)
- [Programos paleidimas](../../../../04-PracticalSamples/foundrylocal)
- [Tikėtinas rezultatas](../../../../04-PracticalSamples/foundrylocal)
- [Kiti žingsniai](../../../../04-PracticalSamples/foundrylocal)
- [Trikčių šalinimas](../../../../04-PracticalSamples/foundrylocal)

## Būtinos sąlygos

Prieš pradedant šią pamoką, įsitikinkite, kad turite:

- **Java 21 ar naujesnę versiją** įdiegtą jūsų sistemoje
- **Maven 3.6+** projektui kurti
- **Foundry Local** įdiegtą ir veikiančią

### **Foundry Local įdiegimas:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## Projekto apžvalga

Šis projektas susideda iš keturių pagrindinių komponentų:

1. **Application.java** - Pagrindinis Spring Boot programos įėjimo taškas
2. **FoundryLocalService.java** - Paslaugų sluoksnis, atsakingas už AI komunikaciją
3. **application.properties** - Konfigūracija Foundry Local ryšiui
4. **pom.xml** - Maven priklausomybės ir projekto konfigūracija

## Kodo supratimas

### 1. Programos konfigūracija (application.properties)

**Failas:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**Ką tai daro:**
- **base-url**: Nurodo, kur veikia Foundry Local, įskaitant `/v1` kelią OpenAI API suderinamumui. **Pastaba**: Foundry Local dinamiškai priskiria prievadą, todėl patikrinkite savo faktinį prievadą naudodami `foundry service status`
- **model**: Nurodo AI modelį, naudojamą teksto generavimui, įskaitant versijos numerį (pvz., `:1`). Naudokite `foundry model list`, kad pamatytumėte galimus modelius su jų tiksliais ID

**Pagrindinė sąvoka:** Spring Boot automatiškai įkelia šias savybes ir padaro jas prieinamas jūsų programai naudojant `@Value` anotaciją.

### 2. Pagrindinė programos klasė (Application.java)

**Failas:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```

**Ką tai daro:**
- `@SpringBootApplication` įgalina Spring Boot automatinę konfigūraciją
- `WebApplicationType.NONE` nurodo Spring, kad tai komandų eilutės programa, o ne interneto serveris
- Pagrindinis metodas paleidžia Spring programą

**Demo vykdytojas:**
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

**Ką tai daro:**
- `@Bean` sukuria komponentą, kurį valdo Spring
- `CommandLineRunner` vykdo kodą po Spring Boot paleidimo
- `foundryLocalService` automatiškai įterpiamas Spring (priklausomybių įterpimas)
- Siunčia testinę žinutę AI ir rodo atsakymą

### 3. AI paslaugų sluoksnis (FoundryLocalService.java)

**Failas:** `src/main/java/com/example/FoundryLocalService.java`

#### Konfigūracijos įterpimas:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```

**Ką tai daro:**
- `@Service` nurodo Spring, kad ši klasė teikia verslo logiką
- `@Value` įterpia konfigūracijos reikšmes iš application.properties
- Sintaksė `:default-value` suteikia atsargines reikšmes, jei savybės nėra nustatytos

#### Kliento inicializavimas:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```

**Ką tai daro:**
- `@PostConstruct` paleidžia šį metodą po to, kai Spring sukuria paslaugą
- Sukuria OpenAI klientą, kuris nukreipia į jūsų vietinį Foundry Local egzempliorių
- Bazinis URL iš `application.properties` jau apima `/v1` OpenAI API suderinamumui
- API raktas nustatytas kaip "nereikalingas", nes vietinis vystymas nereikalauja autentifikacijos

#### Pokalbio metodas:
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

**Ką tai daro:**
- **ChatCompletionCreateParams**: Konfigūruoja AI užklausą
  - `model`: Nurodo, kurį AI modelį naudoti (turi atitikti tikslų ID iš `foundry model list`)
  - `addUserMessage`: Prideda jūsų žinutę į pokalbį
  - `maxTokens`: Ribojama, kiek ilgas gali būti atsakymas (taupo resursus)
  - `temperature`: Valdo atsitiktinumą (0.0 = deterministinis, 1.0 = kūrybiškas)
- **API užklausa**: Siunčia užklausą Foundry Local
- **Atsakymo apdorojimas**: Saugiai ištraukia AI teksto atsakymą
- **Klaidų tvarkymas**: Apgaubia išimtis su naudingomis klaidų žinutėmis

### 4. Projekto priklausomybės (pom.xml)

**Pagrindinės priklausomybės:**

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

**Ką jos daro:**
- **spring-boot-starter**: Suteikia pagrindinę Spring Boot funkcionalumą
- **openai-java**: Oficialus OpenAI Java SDK API komunikacijai
- **jackson-databind**: Tvarko JSON serializaciją/deserializaciją API užklausoms

## Kaip viskas veikia kartu

Štai visas procesas, kai paleidžiate programą:

1. **Paleidimas**: Spring Boot paleidžia ir skaito `application.properties`
2. **Paslaugos sukūrimas**: Spring sukuria `FoundryLocalService` ir įterpia konfigūracijos reikšmes
3. **Kliento nustatymas**: `@PostConstruct` inicializuoja OpenAI klientą, kad prisijungtų prie Foundry Local
4. **Demo vykdymas**: `CommandLineRunner` vykdomas po paleidimo
5. **AI užklausa**: Demo kviečia `foundryLocalService.chat()` su testine žinute
6. **API užklausa**: Paslauga sukuria ir siunčia OpenAI suderinamą užklausą Foundry Local
7. **Atsakymo apdorojimas**: Paslauga ištraukia ir grąžina AI atsakymą
8. **Rodymas**: Programa spausdina atsakymą ir baigia darbą

## Foundry Local nustatymas

Norėdami nustatyti Foundry Local, atlikite šiuos veiksmus:

1. **Įdiekite Foundry Local** naudodami instrukcijas iš [Būtinos sąlygos](../../../../04-PracticalSamples/foundrylocal) skyriaus.

2. **Patikrinkite dinamiškai priskirtą prievadą**. Foundry Local automatiškai priskiria prievadą, kai jis paleidžiamas. Suraskite savo prievadą naudodami:
   ```bash
   foundry service status
   ```
   
   **Pasirinktinai**: Jei norite naudoti konkretų prievadą (pvz., 5273), galite jį konfigūruoti rankiniu būdu:
   ```bash
   foundry service set --port 5273
   ```

3. **Atsisiųskite AI modelį**, kurį norite naudoti, pvz., `phi-3.5-mini`, naudodami šią komandą:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **Konfigūruokite application.properties** failą, kad atitiktų jūsų Foundry Local nustatymus:
   - Atnaujinkite prievadą `base-url` (iš 2 žingsnio), užtikrindami, kad jis baigtųsi `/v1`
   - Atnaujinkite modelio pavadinimą, įskaitant versijos numerį (patikrinkite su `foundry model list`)
   
   Pavyzdys:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```

## Programos paleidimas

### 1 žingsnis: Paleiskite Foundry Local
```bash
foundry model run phi-3.5-mini
```

### 2 žingsnis: Sukurkite ir paleiskite programą
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Tikėtinas rezultatas

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

## Kiti žingsniai

Daugiau pavyzdžių rasite [4 skyriuje: Praktiniai pavyzdžiai](../README.md)

## Trikčių šalinimas

### Dažnos problemos

**"Connection refused" arba "Service unavailable"**
- Įsitikinkite, kad Foundry Local veikia: `foundry model list`
- Patikrinkite faktinį prievadą, kurį naudoja Foundry Local: `foundry service status`
- Atnaujinkite savo `application.properties` su teisingu prievadu, užtikrindami, kad URL baigtųsi `/v1`
- Pasirinktinai nustatykite konkretų prievadą, jei norite: `foundry service set --port 5273`
- Bandykite iš naujo paleisti Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" arba "404 Not Found" klaidos**
- Patikrinkite galimus modelius su jų tiksliais ID: `foundry model list`
- Atnaujinkite modelio pavadinimą `application.properties`, kad tiksliai atitiktų, įskaitant versijos numerį (pvz., `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Užtikrinkite, kad `base-url` baigtųsi `/v1`: `http://localhost:5273/v1`
- Atsisiųskite modelį, jei reikia: `foundry model run phi-3.5-mini`

**"400 Bad Request" klaidos**
- Patikrinkite, ar bazinis URL apima `/v1`: `http://localhost:5273/v1`
- Patikrinkite, ar modelio ID tiksliai atitinka tai, kas rodoma `foundry model list`
- Užtikrinkite, kad naudojate `maxTokens()` vietoj `maxCompletionTokens()` savo kode

**Maven kompiliavimo klaidos**
- Įsitikinkite, kad naudojate Java 21 ar naujesnę versiją: `java -version`
- Išvalykite ir perkompiliuokite: `mvn clean compile`
- Patikrinkite interneto ryšį priklausomybių atsisiuntimui

**Programa paleidžiama, bet nėra išvesties**
- Patikrinkite, ar Foundry Local atsako: Atidarykite naršyklę adresu `http://localhost:5273`
- Patikrinkite programos žurnalus dėl specifinių klaidų pranešimų
- Įsitikinkite, kad modelis yra visiškai įkeltas ir paruoštas

---

**Atsakomybės apribojimas**:  
Šis dokumentas buvo išverstas naudojant AI vertimo paslaugą [Co-op Translator](https://github.com/Azure/co-op-translator). Nors stengiamės užtikrinti tikslumą, prašome atkreipti dėmesį, kad automatiniai vertimai gali turėti klaidų ar netikslumų. Originalus dokumentas jo gimtąja kalba turėtų būti laikomas autoritetingu šaltiniu. Kritinei informacijai rekomenduojama profesionali žmogaus vertimo paslauga. Mes neprisiimame atsakomybės už nesusipratimus ar neteisingus interpretavimus, atsiradusius dėl šio vertimo naudojimo.