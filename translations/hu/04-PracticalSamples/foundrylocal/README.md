<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d064108b2142d32246ccbd8a42e76b4d",
  "translation_date": "2025-07-25T09:59:09+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "hu"
}
-->
# Foundry Helyi Parancssori Alkalmazás

>**Megjegyzés**: Ez a fejezet tartalmaz egy [**Útmutatót**](./TUTORIAL.md), amely végigvezet a mintákon.

Egy egyszerű Spring Boot parancssori alkalmazás, amely bemutatja, hogyan lehet csatlakozni a Foundry Localhoz az OpenAI Java SDK használatával.

## Amit Megtanulsz

- Hogyan integrálhatod a Foundry Local-t Spring Boot alkalmazásokkal az OpenAI Java SDK segítségével
- Legjobb gyakorlatok helyi AI fejlesztéshez és teszteléshez

## Tartalomjegyzék

- [Amit Megtanulsz](../../../../04-PracticalSamples/foundrylocal)
- [Előfeltételek](../../../../04-PracticalSamples/foundrylocal)
  - [Foundry Local telepítése](../../../../04-PracticalSamples/foundrylocal)
  - [Ellenőrzés](../../../../04-PracticalSamples/foundrylocal)
- [Konfiguráció](../../../../04-PracticalSamples/foundrylocal)
- [Gyors Kezdés](../../../../04-PracticalSamples/foundrylocal)
- [Mit Csinál az Alkalmazás](../../../../04-PracticalSamples/foundrylocal)
- [Minta Kimenet](../../../../04-PracticalSamples/foundrylocal)
- [Architektúra](../../../../04-PracticalSamples/foundrylocal)
- [Kódrészletek](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI Java SDK Integráció](../../../../04-PracticalSamples/foundrylocal)
  - [Chat Completion API](../../../../04-PracticalSamples/foundrylocal)
- [Hibaelhárítás](../../../../04-PracticalSamples/foundrylocal)

## Előfeltételek

> **⚠️ Megjegyzés**: Ez az alkalmazás **nem fut a mellékelt devcontainerben**, mivel szükséges, hogy a Foundry Local telepítve és futtatva legyen a gazdagépen.

### Foundry Local telepítése

Az alkalmazás futtatása előtt telepítened és el kell indítanod a Foundry Local-t. Kövesd az alábbi lépéseket:

1. **Győződj meg arról, hogy a rendszered megfelel a követelményeknek**:
   - **Operációs Rendszer**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 vagy macOS
   - **Hardver**: 
     - Minimum: 8GB RAM, 3GB szabad lemezterület
     - Ajánlott: 16GB RAM, 15GB szabad lemezterület
   - **Hálózat**: Internetkapcsolat a kezdeti modell letöltéséhez (offline használathoz opcionális)
   - **Gyorsítás (opcionális)**: NVIDIA GPU (2000-es sorozat vagy újabb), AMD GPU (6000-es sorozat vagy újabb), Qualcomm Snapdragon X Elite (8GB vagy több memória), vagy Apple silicon
   - **Jogosultságok**: Adminisztrátori jogosultságok a szoftver telepítéséhez az eszközön

2. **Telepítsd a Foundry Local-t**:
   
   **Windows esetén:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **macOS esetén:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Alternatívaként letöltheted a telepítőt a [Foundry Local GitHub repository](https://github.com/microsoft/Foundry-Local) oldaláról.

3. **Indítsd el az első modellt**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   A modell letöltése (ami néhány percet vehet igénybe az internetsebességtől függően) után elindul. A Foundry Local automatikusan kiválasztja a rendszeredhez legjobban illeszkedő modellváltozatot (CUDA NVIDIA GPU-khoz, CPU verzió egyéb esetekben).

4. **Teszteld a modellt** úgy, hogy kérdést teszel fel ugyanabban a terminálban:

   ```bash
   Why is the sky blue?
   ```

   A Phi modell válaszát kell látnod, amely elmagyarázza, miért kék az ég.

### Ellenőrzés

Ellenőrizheted, hogy minden megfelelően működik-e az alábbi parancsokkal:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Ezenkívül meglátogathatod a `http://localhost:5273` címet a böngésződben, hogy megtekintsd a Foundry Local webes felületét.

## Konfiguráció

Az alkalmazás az `application.properties` fájlon keresztül konfigurálható:

- `foundry.local.base-url` - A Foundry Local alap URL-je (alapértelmezett: http://localhost:5273)
- `foundry.local.model` - Használandó AI modell (alapértelmezett: Phi-3.5-mini-instruct-cuda-gpu)

> **Megjegyzés**: A konfigurációban megadott modellnévnek meg kell egyeznie azzal a konkrét változattal, amelyet a Foundry Local letöltött a rendszeredhez. Amikor futtatod a `foundry model run phi-3.5-mini` parancsot, a Foundry Local automatikusan kiválasztja és letölti a legjobb változatot (CUDA NVIDIA GPU-khoz, CPU verzió egyéb esetekben). Használd a `foundry model list` parancsot, hogy lásd a pontos modellnevet, amely elérhető a helyi példányban.

## Gyors Kezdés

### 1. Navigálj a Foundry Local alkalmazás könyvtárába
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Futtasd az Alkalmazást

```bash
mvn spring-boot:run
```

Vagy építsd és futtasd a JAR-t:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Függőségek

Ez az alkalmazás az OpenAI Java SDK-t használja a Foundry Local-lal való kommunikációhoz. A kulcsfontosságú függőség:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Az alkalmazás előre konfigurálva van, hogy csatlakozzon a Foundry Local-hoz az alapértelmezett porton.

## Mit Csinál az Alkalmazás

Amikor futtatod az alkalmazást:

1. **Elindul** parancssori alkalmazásként (webszerver nélkül)
2. **Automatikusan küld** egy tesztüzenetet: "Hello! Meg tudnád mondani, hogy mi vagy és milyen modellt futtatsz?"
3. **Megjeleníti a választ** a Foundry Local-tól a konzolon
4. **Tisztán kilép** a bemutató után

## Minta Kimenet

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Architektúra

- **Application.java** - Fő Spring Boot alkalmazás CommandLineRunner-rel
- **FoundryLocalService.java** - Szolgáltatás, amely az OpenAI Java SDK-t használja a Foundry Local-lal való kommunikációhoz
- **OpenAI Java SDK** használata típusbiztos API hívásokhoz
- Automatikus JSON szerializáció/deszerializáció az SDK által
- Tiszta konfiguráció a Spring `@Value` és `@PostConstruct` annotációival

## Kódrészletek

### OpenAI Java SDK Integráció

Az alkalmazás az OpenAI Java SDK-t használja egy kliens létrehozásához, amely a Foundry Local-hoz van konfigurálva:

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

Chat completion kérések küldése egyszerű és típusbiztos:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Hibaelhárítás

Ha csatlakozási hibákat tapasztalsz:
1. Ellenőrizd, hogy a Foundry Local fut-e a `http://localhost:5273` címen
2. Ellenőrizd, hogy elérhető-e egy Phi-3.5-mini modellváltozat a `foundry model list` paranccsal
3. Győződj meg arról, hogy az `application.properties` fájlban megadott modellnév pontosan megegyezik a listában szereplő modellnévvel
4. Ellenőrizd, hogy nincs-e tűzfal, amely blokkolja a kapcsolatot

Gyakori problémák:
- **Modell nem található**: Futtasd a `foundry model run phi-3.5-mini` parancsot a modell letöltéséhez és elindításához
- **Szolgáltatás nem fut**: Lehet, hogy a Foundry Local szolgáltatás leállt; indítsd újra a modell futtatási parancsával
- **Helytelen modellnév**: Használd a `foundry model list` parancsot az elérhető modellek megtekintéséhez, és frissítsd a konfigurációt ennek megfelelően

**Felelősség kizárása**:  
Ez a dokumentum az AI fordítási szolgáltatás [Co-op Translator](https://github.com/Azure/co-op-translator) segítségével lett lefordítva. Bár törekszünk a pontosságra, kérjük, vegye figyelembe, hogy az automatikus fordítások hibákat vagy pontatlanságokat tartalmazhatnak. Az eredeti dokumentum az eredeti nyelvén tekintendő hiteles forrásnak. Kritikus információk esetén javasolt professzionális emberi fordítást igénybe venni. Nem vállalunk felelősséget semmilyen félreértésért vagy téves értelmezésért, amely a fordítás használatából eredhet.