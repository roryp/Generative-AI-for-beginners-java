# Foundry Local Spring Boot Oktatóanyag

## Tartalomjegyzék

- [Előfeltételek](#előfeltételek)
- [Projekt áttekintése](#projekt-áttekintése)
- [A kód megértése](#a-kód-megértése)
  - [1. Alkalmazás konfiguráció (application.properties)](#1-alkalmazás-konfiguráció-applicationproperties)
  - [2. Fő alkalmazás osztály (Application.java)](#2-fő-alkalmazás-osztály-applicationjava)
  - [3. AI szolgáltatási réteg (FoundryLocalService.java)](#3-ai-szolgáltatási-réteg-foundrylocalservicejava)
  - [4. Projekt függőségek (pom.xml)](#4-projekt-függőségek-pomxml)
- [Hogyan működik együtt](#hogyan-működik-együtt)
- [Foundry Local beállítása](#foundry-local-beállítása)
- [Az alkalmazás futtatása](#az-alkalmazás-futtatása)
- [Várt kimenet](#várt-kimenet)
- [Következő lépések](#következő-lépések)
- [Hibaelhárítás](#hibaelhárítás)


## Előfeltételek

A tutorial elkezdése előtt győződj meg róla, hogy a következőkkel rendelkezel:

- **Java 21 vagy újabb** telepítve a rendszereden
- **Maven 3.6+** a projekt buildeléséhez
- **Foundry Local** telepítve és futtatva

### **Foundry Local telepítése:**

> **Megjegyzés:** A Foundry Local CLI csak **Windows** és **macOS** rendszereken érhető el. Linuxot a [Foundry Local SDK-k](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust) támogatják.

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Ellenőrizd a telepítést:
```bash
foundry --version
```

## Projekt áttekintése

A projekt négy fő összetevőből áll:

1. **Application.java** - A fő Spring Boot alkalmazás belépési pontja
2. **FoundryLocalService.java** - Szolgáltatási réteg, amely kezeli az AI kommunikációt
3. **application.properties** - Konfiguráció a Foundry Local kapcsolathoz
4. **pom.xml** - Maven függőségek és projekt konfiguráció

## A kód megértése

### 1. Alkalmazás konfiguráció (application.properties)

**Fájl:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Mit csinál ez:**
- **base-url**: Megadja, hogy hol fut a Foundry Local, beleértve a `/v1` elérési utat az OpenAI API kompatibilitás érdekében. Az alapértelmezett port a `5273`. Ha eltér, ellenőrizd a portot a `foundry service status` parancssal.
- **model** (opcionális): Megnevezi az AI modellt, amit a szöveg generáláshoz használnak. **Alapértelmezetten az alkalmazás automatikusan érzékeli a modellt** a Foundry Local `/v1/models` végpontján keresztül induláskor, így nem kell beállítani. Kiválaszthatod explicit módon is, hogy felülírd az automatikus érzékelést.

**Kulcsfontosságú fogalom:** A Spring Boot automatikusan betölti ezeket a tulajdonságokat és elérhetővé teszi az alkalmazásod számára a `@Value` annotációval.

### 2. Fő alkalmazás osztály (Application.java)

**Fájl:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Nem szükséges webkiszolgáló
        app.run(args);
    }
```

**Mit csinál ez:**
- `@SpringBootApplication` engedélyezi a Spring Boot automatikus konfigurációt
- `WebApplicationType.NONE` jelzi, hogy ez parancssori alkalmazás, nem webszerver
- A main metódus elindítja a Spring alkalmazást

**A Demo Runner:**
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

**Mit csinál ez:**
- `@Bean` egy Spring által kezelt komponens létrehozása
- `CommandLineRunner` kódot futtat a Spring Boot indítása után
- A `foundryLocalService` automatikusan be van injektálva a Spring által (függőség injektálás)
- Küld egy teszt üzenetet az AI-nak és kiírja a választ

### 3. AI szolgáltatási réteg (FoundryLocalService.java)

**Fájl:** `src/main/java/com/example/FoundryLocalService.java`

#### Konfiguráció injektálás:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Automatikusan érzékeli, ha üres
```

**Mit csinál ez:**
- `@Service` jelzi a Springnek, hogy ez az osztály üzleti logikát szolgáltat
- `@Value` injektálja az értékeket az application.properties fájlból
- A modell alapértelmezésben üres, ami **automatikus érzékelést** vált ki a Foundry Localtól induláskor. Ez azt jelenti, hogy az alkalmazás bármilyen, a Foundry Localban betöltött modellel működik manuális konfiguráció nélkül.

#### Kliens inicializálás:
```java
@PostConstruct
public void init() {
    // Automatikusan érzékeli a modellt a Foundry Local-ból, ha nincs kifejezetten konfigurálva
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Az alap URL már tartalmazza a /v1-et a konfigurációból
            .apiKey("not-needed")            // A helyi szerver nem igényel valódi API kulcsot
            .build();
}
```

**Mit csinál ez:**
- `@PostConstruct` futtatja ezt a metódust, miután a Spring létrehozta a szolgáltatást
- Ha nincs konfigurált modell, lekéri a Foundry Local `/v1/models` végpontjáról és az első betöltött modellt választja ki
- Létrehoz egy OpenAI klienst, amely a helyi Foundry Local példányához csatlakozik
- Az application.properties-ben megadott alap URL már tartalmazza a `/v1` útvonalat OpenAI API kompatibilitás miatt
- Az API kulcs értéke "not-needed", mert a helyi fejlesztéshez nem szükséges hitelesítés

#### Chat metódus:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Melyik MI modellt használjuk
                .addUserMessage(message)         // A kérdésed/kérésed
                .maxCompletionTokens(150)        // Válasz hosszának korlátozása
                .temperature(0.7)                // Kreativitás szabályozása (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Az MI válaszának kinyerése az API eredményből
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Mit csinál ez:**
- **ChatCompletionCreateParams**: konfigurálja az AI kérést
  - `model`: megadja, melyik AI modellt használja (meg kell egyeznie a `foundry model list` pontos azonosítójával)
  - `addUserMessage`: hozzáadja az üzeneted a beszélgetéshez
  - `maxCompletionTokens`: korlátozza a válasz hosszát (erőforrás megtakarítás)
  - `temperature`: szabályozza a véletlenszerűséget (0.0 = determinisztikus, 1.0 = kreatív)
- **API hívás**: elküldi a kérést a Foundry Localnak
- **Válasz feldolgozás**: biztonságosan kinyeri az AI szöveges válaszát
- **Hiba kezelés**: kivételeket segítő hibaüzenettel csomagolja

### 4. Projekt függőségek (pom.xml)

**Fő függőségek:**

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

**Mit csinálnak ezek:**
- **spring-boot-starter**: biztosítja a Spring Boot alapfunkcionalitását
- **openai-java**: hivatalos OpenAI Java SDK API kommunikációhoz
- **jackson-databind**: kezeli a JSON sorosítást/deszerializációt az API hívásokhoz

## Hogyan működik együtt

Íme a teljes folyamat az alkalmazás futtatásakor:

1. **Indulás**: A Spring Boot elindul és beolvassa az `application.properties`-t
2. **Szolgáltatás létrehozása**: A Spring létrehozza a `FoundryLocalService`-t és injektálja a konfigurációs értékeket
3. **Modell érzékelés**: Ha nincs modell beállítva, a szolgáltatás lekéri a Foundry Local `/v1/models` végpontját és automatikusan az első elérhető modellt használja
4. **Kliens beállítás**: `@PostConstruct` inicializálja az OpenAI klienst, hogy csatlakozzon a Foundry Localhoz
5. **Demo futtatása**: A `CommandLineRunner` indulás után fut
6. **AI hívás**: A demo meghívja a `foundryLocalService.chat()` metódust egy teszt üzenettel
7. **API kérés**: A szolgáltatás OpenAI-kompatibilis kérést épít és küld a Foundry Localnak
8. **Válasz feldolgozás**: A válasz kinyerése és visszaadása
9. **Megjelenítés**: Az alkalmazás kiírja a választ és kilép

## Foundry Local beállítása

1. **Telepítsd a Foundry Localt** az [Előfeltételek](#előfeltételek) szakasz utasításai szerint.

2. **Indítsd el a szolgáltatást** (ha még nem fut):
   ```bash
   foundry service start
   ```

3. **Ellenőrizd a szolgáltatás állapotát** és jegyezd meg a portot:
   ```bash
   foundry service status
   ```

4. **Tölts le és futtass egy modellt** (első futáskor letöltődik, később gyorsítótárból használódik):
   ```bash
   foundry model run phi-4-mini
   ```
   Ezzel egy interaktív chat munkamenet nyílik meg. Kilépni lehet a `Ctrl+C` billentyűkkel. A modell futva marad a szolgáltatásban.

   > **Tipp:** Futtasd a `foundry model list` parancsot az elérhető modellek listázásához. Cseréld ki a `phi-4-mini` nevet bármely katalógusbeli aliasra (pl. `qwen2.5-0.5b` kisebb/gyorsabb modellhez).

5. **Ellenőrizd, hogy a modell betöltődött:**
   ```bash
   foundry service ps
   ```

6. **Frissítsd az `application.properties` fájlt szükség szerint:**
   - Az alapértelmezett `base-url` (`http://localhost:5273/v1`) megegyezik az alapértelmezett CLI porttal. Csak akkor módosítsd, ha a `foundry service status` más portot jelez.
   - A modellt induláskor **automatikusan érzékeli** az alkalmazás — nem szükséges konfiguráció.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Az alkalmazás futtatása

### 1. lépés: Győződj meg róla, hogy betöltöttél egy modellt a Foundry Localba
```bash
foundry service ps
```
Ha nincs modell, tölts be egyet:
```bash
foundry model run phi-4-mini
```

### 2. lépés: Buildeld és futtasd az alkalmazást
Egy külön terminálban:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Vagy buildeld és futtasd JAR-ként:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Várt kimenet

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

## Következő lépések

További példákért lásd [04. fejezet: Gyakorlati példák](../README.md)

## Hibaelhárítás

### Gyakori problémák

**"Connection refused" vagy "Service unavailable"**
- Ellenőrizd a szolgáltatást: `foundry service status`
- Indítsd újra, ha kell: `foundry service restart`
- Győződj meg róla, hogy az `application.properties`-ben a port megegyezik a `foundry service status` kimenetével
- Ellenőrizd, hogy az URL `/v1` végződésű: `http://localhost:5273/v1`

**"No model found" induláskor**
- Az alkalmazás automatikusan érzékeli a modellt. Győződj meg róla, hogy legalább egy modell betöltve van: `foundry service ps`
- Ha nincs modell telepítve: `foundry model run phi-4-mini`
- Ha az `application.properties`-ben felülírtad a modell nevet, ellenőrizd, hogy az egyezzen a `foundry model list`-tel

**"400 Bad Request" hibák**
- Ellenőrizd, hogy az alap URL tartalmazza a `/v1` végződést: `http://localhost:5273/v1`
- Győződj meg róla, hogy kódodban a `maxCompletionTokens()` metódust használod (nem a deprecated `maxTokens()`-t)

**Maven fordítási hibák**
- Győződj meg róla, hogy Java 21 vagy újabb van telepítve: `java -version`
- Tisztítsd és buildeld újra: `mvn clean compile`
- Ellenőrizd az internetkapcsolatot a függőségek letöltéséhez

**Szolgáltatás csatlakozási problémák**
- Ha a `Request to local service failed` hibát látod, futtasd: `foundry service restart`
- Ellenőrizd a betöltött modelleket: `foundry service ps`
- Nézd meg a szolgáltatás logjait: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Nyilatkozat**:  
Ez a dokumentum az AI fordítási szolgáltatás, a [Co-op Translator](https://github.com/Azure/co-op-translator) használatával készült. Bár a pontosságra törekszünk, kérjük, vegye figyelembe, hogy az automatikus fordítások hibákat vagy pontatlanságokat tartalmazhatnak. Az eredeti dokumentum az anyanyelvén tekintendő tekintélyes forrásnak. Kritikus információk esetén szakmai emberi fordítást javasolunk. Nem vállalunk felelősséget a fordítás használatából eredő félreértésekért vagy félreértelmezésekért.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->