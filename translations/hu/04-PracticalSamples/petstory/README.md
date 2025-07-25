<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T10:00:14+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "hu"
}
-->
# Pet Story App

>**Megjegyzés**: Ez a fejezet tartalmaz egy [**Útmutatót**](./TUTORIAL.md), amely végigvezet a mintákon.

Egy Spring Boot webalkalmazás, amely AI által generált leírásokat és történeteket készít feltöltött háziállat képek alapján, GitHub Modellek segítségével.

## Tartalomjegyzék

- [Technológiai Halmaz](../../../../04-PracticalSamples/petstory)
- [Előfeltételek](../../../../04-PracticalSamples/petstory)
- [Beállítás és Telepítés](../../../../04-PracticalSamples/petstory)
- [Használat](../../../../04-PracticalSamples/petstory)

## Technológiai Halmaz

- **Backend**: Spring Boot 3.5.3, Java 21
- **AI Integráció**: OpenAI Java SDK GitHub Modellekkel
- **Biztonság**: Spring Security
- **Frontend**: Thymeleaf sablonok Bootstrap stílusokkal
- **Build Eszköz**: Maven
- **AI Modellek**: GitHub Modellek

## Előfeltételek

- Java 21 vagy újabb
- Maven 3.9+
- GitHub Személyes Hozzáférési Token `models:read` jogosultsággal

## Beállítás és Telepítés

### 1. Lépj be a petstory alkalmazás könyvtárába
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Állítsd be a környezeti változót
```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Építsd fel az alkalmazást
```bash
mvn clean compile
```

### 4. Indítsd el az alkalmazást
```bash
mvn spring-boot:run
```

## Használat

1. **Az alkalmazás elérése**: Nyisd meg a `http://localhost:8080` címet
2. **Kép feltöltése**: Kattints a "Choose File" gombra, és válassz egy háziállat képet
3. **Kép elemzése**: Kattints az "Analyze Image" gombra, hogy AI leírást kapj
4. **Történet generálása**: Kattints a "Generate Story" gombra, hogy létrehozd a történetet

**Felelősség kizárása**:  
Ez a dokumentum az AI fordítási szolgáltatás [Co-op Translator](https://github.com/Azure/co-op-translator) segítségével lett lefordítva. Bár törekszünk a pontosságra, kérjük, vegye figyelembe, hogy az automatikus fordítások hibákat vagy pontatlanságokat tartalmazhatnak. Az eredeti dokumentum az eredeti nyelvén tekintendő hiteles forrásnak. Kritikus információk esetén javasolt professzionális emberi fordítást igénybe venni. Nem vállalunk felelősséget semmilyen félreértésért vagy téves értelmezésért, amely a fordítás használatából eredhet.