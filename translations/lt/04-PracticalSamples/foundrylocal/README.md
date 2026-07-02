# Foundry Local Spring Boot Mokymasis

## Turinys

- [Reikalavimai prieš pradedant](#reikalavimai-prieš-pradedant)
- [Projekto apžvalga](#projekto-apžvalga)
- [Kodo supratimas](#kodo-supratimas)
  - [1. Programos konfigūracija (application.properties)](#1-programos-konfigūracija-applicationproperties)
  - [2. Pagrindinė programos klasė (Application.java)](#2-pagrindinė-programos-klasė-applicationjava)
  - [3. AI paslaugų sluoksnis (FoundryLocalService.java)](#3-ai-paslaugų-sluoksnis-foundrylocalservicejava)
  - [4. Projekto priklausomybės (pom.xml)](#4-projekto-priklausomybės-pomxml)
- [Kaip visa tai veikia kartu](#kaip-visa-tai-veikia-kartu)
- [Foundry Local nustatymas](#foundry-local-nustatymas)
- [Programos paleidimas](#programos-paleidimas)
- [Tikėtinas rezultatas](#tikėtinas-rezultatas)
- [Kiti veiksmai](#kiti-veiksmai)
- [Trikčių šalinimas](#trikčių-šalinimas)


## Reikalavimai prieš pradedant

Prieš pradėdami šį mokymą, įsitikinkite, kad turite:

- **Java 21 arba naujesnę** versiją savo sistemoje
- **Maven 3.6+** projektų kūrimui
- Įdiegtą ir veikiančią **Foundry Local**

### **Įdiekite Foundry Local:**

> **Pastaba:** Foundry Local CLI galima naudoti tik **Windows** ir **macOS** sistemose. Linux palaikomas naudojant [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Patikrinkite įdiegimą:
```bash
foundry --version
```

## Projekto apžvalga

Šis projektas susideda iš keturių pagrindinių komponentų:

1. **Application.java** - pagrindinis Spring Boot programos įėjimo taškas
2. **FoundryLocalService.java** - paslaugų sluoksnis, kuris tvarko AI komunikaciją
3. **application.properties** - Foundry Local ryšio konfigūracija
4. **pom.xml** - Maven priklausomybės ir projekto konfigūracija

## Kodo supratimas

### 1. Programos konfigūracija (application.properties)

**Failas:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Ką tai daro:**
- **base-url**: Nurodo, kur veikia Foundry Local, įskaitant `/v1` kelią dėl OpenAI API suderinamumo. Numatytoji prievado reikšmė yra `5273`. Jei prievadas kitoks, patikrinkite jį su `foundry service status`.
- **model** (pasirinktinai): Nurodo AI modelį, naudojamą teksto generavimui. **Pagal numatytuosius nustatymus programa automatiškai aptinka modelį** užklausdama Foundry Local `/v1/models` pabaigos tašką paleidimo metu, todėl nereikia to nustatyti. Vis tiek galite jį nurodyti rankiniu būdu, jei norite pakeisti automatinį aptikimą.

**Pagrindinė sąvoka:** Spring Boot automatiškai įkelia šiuos parametrus ir pateikia juos programai per `@Value` anotaciją.

### 2. Pagrindinė programos klasė (Application.java)

**Failas:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Nereikia jokio interneto serverio
        app.run(args);
    }
```

**Ką tai daro:**
- `@SpringBootApplication` įjungia Spring Boot automatinį konfigūravimą
- `WebApplicationType.NONE` nurodo Spring, kad tai komandų eilutės programa, o ne interneto serveris
- Pagrindinė funkcija paleidžia Spring programą

**Demo vykdytojas:**
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

**Ką tai daro:**
- `@Bean` sukuria komponentą, kuriuo valdo Spring
- `CommandLineRunner` vykdo kodą po Spring Boot paleidimo
- `foundryLocalService` automatiškai įjungiama Spring (priklausomybės injekcija)
- Siunčia bandymo žinutę AI ir rodo atsakymą

### 3. AI paslaugų sluoksnis (FoundryLocalService.java)

**Failas:** `src/main/java/com/example/FoundryLocalService.java`

#### Konfigūracijos įvedimas:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Automatiškai aptikta, jei tuščia
```

**Ką tai daro:**
- `@Service` nurodo Spring, kad ši klasė teikia verslo logiką
- `@Value` įveda konfigūracijos reikšmes iš application.properties
- Modelis pagal numatytuosius nustatymus yra tuščias, todėl paleidimo metu vykdomas **automatinis Foundry Local modelio aptikimas**. Tai reiškia, kad programa veikia su bet kuriuo Foundry Local įkeltu modeliu be rankinės konfigūracijos.

#### Kliento inicijavimas:
```java
@PostConstruct
public void init() {
    // Automatiškai aptikti modelį iš Foundry Local, jei jis nėra aiškiai sukonfigūruotas
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Pagrindinis URL jau apima /v1 iš konfigūracijos
            .apiKey("not-needed")            // Vietiniam serveriui nereikia tikro API rakto
            .build();
}
```

**Ką tai daro:**
- `@PostConstruct` vykdo šį metodą po Spring paslaugos sukūrimo
- Jei nėra sukonfigūruoto modelio, užklausia Foundry Local `/v1/models` pabaigos taško ir pasirenka pirmą pasiekiamą modelį
- Sukuria OpenAI klientą, kuris jungiasi prie jūsų vietinės Foundry Local instancijos
- Bazinis URL iš `application.properties` jau apima `/v1` dėl OpenAI API suderinamumo
- API raktas nustatytas kaip "not-needed", nes vietiniame kūrime autentifikacija nereikalinga

#### Pokalbio metodas:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Kurį DI modelį naudoti
                .addUserMessage(message)         // Jūsų klausimas/prašymas
                .maxCompletionTokens(150)        // Apriboti atsakymo ilgį
                .temperature(0.7)                // Kontroliuoti kūrybingumą (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Išgauti DI atsakymą iš API rezultato
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
  - `model`: Nurodo, kurį AI modelį naudoti (turi tiksliai atitikti ID, gaunamą iš `foundry model list`)
  - `addUserMessage`: Prideda jūsų žinutę prie pokalbio
  - `maxCompletionTokens`: Nustato maksimalų atsakymo ilgio apribojimą (taupo resursus)
  - `temperature`: Valdo atsitiktinumą (0.0 = deterministinis, 1.0 = kūrybiškas)
- **API užklausa**: Siunčia užklausą Foundry Local
- **Atsakymo tvarkymas**: Saugo teksto atsakymą iš AI
- **Klaidų tvarkymas**: Apgaubia išimtis naudingomis klaidų žinutėmis

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
- **spring-boot-starter**: Pateikia pagrindinę Spring Boot funkcionalumą
- **openai-java**: Oficialus OpenAI Java SDK API sąveikai
- **jackson-databind**: Tvarko JSON serializavimą/atserializavimą API užklausoms

## Kaip visa tai veikia kartu

Štai pilnas procesas paleidus programą:

1. **Paleidimas**: Spring Boot paleidžiamas ir skaito `application.properties`
2. **Paslaugos sukūrimas**: Spring sukuria `FoundryLocalService` ir įveda konfigūracijos reikšmes
3. **Modelio aptikimas**: Jei modelis nesukonfigūruotas, paslauga užklausia Foundry Local `/v1/models` ir automatiškai naudoja pirmą modelį
4. **Kliento paruošimas**: `@PostConstruct` inicijuoja OpenAI klientą, kad jungtųsi prie Foundry Local
5. **Demo vykdymas**: `CommandLineRunner` paleidžiamas po starto
6. **AI užklausa**: Demo skambina `foundryLocalService.chat()` su testine žinute
7. **API užklausa**: Paslauga sukuria ir siunčia OpenAI suderinamą užklausą Foundry Local
8. **Atsakymo apdorojimas**: Paslauga gauna ir pateikia AI atsakymą
9. **Ekrane**: Programa išveda atsakymą ir baigia darbą

## Foundry Local nustatymas

1. **Įdiekite Foundry Local** naudodamiesi instrukcijomis skyriuje [Reikalavimai prieš pradedant](#reikalavimai-prieš-pradedant).

2. **Paleiskite paslaugą** (jei dar neveikia):
   ```bash
   foundry service start
   ```

3. **Patikrinkite paslaugos būseną**, kad įsitikintumėte, jog ji veikia, ir užfiksuokite prievadą:
   ```bash
   foundry service status
   ```

4. **Atsisiųskite ir paleiskite modelį** (pirmą kartą atsisiunčiama, vėliau talpinama):
   ```bash
   foundry model run phi-4-mini
   ```
   Tai atveria interaktyvią pokalbių sesiją. Išeiti galite paspaudę `Ctrl+C`. Modelis lieka pakrautas paslaugoje.

   > **Patarimas:** Vykdykite `foundry model list`, kad matytumėte visus galimus modelius. Pakeiskite `phi-4-mini` į bet kurį katalogo alias’ą (pvz., `qwen2.5-0.5b` – mažesniam/greitesniam modeliui).

5. **Patikrinkite, ar modelis įkeltas:**
   ```bash
   foundry service ps
   ```

6. **Atnaujinkite `application.properties`, jei reikia:**
   - Numatytoji `base-url` (`http://localhost:5273/v1`) sutampa su numatytuoju CLI prievadu. Atnaujinkite tik jei `foundry service status` rodo kitą prievadą.
   - Modelis **automatiškai aptinkamas** paleidžiant – konfigūracijos nurodyti nereikia.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Programos paleidimas

### 1 veiksmas: Įsitikinkite, kad Foundry Local yra pakrautas modelis
```bash
foundry service ps
```
Jei modelių nėra, įkelkite vieną:
```bash
foundry model run phi-4-mini
```

### 2 veiksmas: Sukurkite ir paleiskite programą
Atidarykite naują terminalą:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Arba sukompiliuokite ir paleiskite kaip JAR:
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
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## Kiti veiksmai

Daugiau pavyzdžių rasite skyriuje [04 skyrius: Praktiniai pavyzdžiai](../README.md)

## Trikčių šalinimas

### Dažnos problemos

**„Connection refused“ arba „Service unavailable“**
- Patikrinkite paslaugą: `foundry service status`
- Jei reikia, paleiskite iš naujo: `foundry service restart`
- Patikrinkite, ar prievadas `application.properties` atitinka `foundry service status`
- Įsitikinkite, kad URL baigiasi `/v1`: `http://localhost:5273/v1`

**„No model found“ paleidžiant**
- Programa automatiškai aptinka modelį. Įsitikinkite, kad bent vienas modelis įkeltas: `foundry service ps`
- Jei modelių nėra: `foundry model run phi-4-mini`
- Jei rankiniu būdu keitėte modelį `application.properties`, patikrinkite, kad jis atitinka `foundry model list`

**„400 Bad Request“ klaidos**
- Patikrinkite, ar bazinis URL apima `/v1`: `http://localhost:5273/v1`
- Įsitikinkite, kad naudojate `maxCompletionTokens()` savo kode (nepasenusią `maxTokens()` versiją)

**Maven kompiliacijos klaidos**
- Patikrinkite, ar Java versija 21 ar naujesnė: `java -version`
- Išvalykite ir sukompiliuokite: `mvn clean compile`
- Patikrinkite interneto ryšį priklausomybėms atsisiųsti

**Paslaugos ryšio problemos**
- Jei matote `Request to local service failed`, paleiskite: `foundry service restart`
- Patikrinkite įkeltus modelius: `foundry service ps`
- Peržiūrėkite paslaugos žurnalus: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Atsakomybės apribojimas**:
Šis dokumentas buvo išverstas naudojant dirbtinio intelekto vertimo paslaugą [Co-op Translator](https://github.com/Azure/co-op-translator). Nors stengiamės užtikrinti tikslumą, prašome atkreipti dėmesį, kad automatiniai vertimai gali turėti klaidų ar netikslumų. Pradinė dokumento versija gimtąja kalba turi būti laikoma autoritetingu šaltiniu. Kritinei informacijai rekomenduojamas profesionalus žmogaus vertimas. Mes neatsakome už bet kokius nesusipratimus ar neteisingus interpretavimus, kylantį dėl šio vertimo naudojimo.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->