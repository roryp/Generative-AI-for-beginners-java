<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T21:36:28+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "hu"
}
-->
# Pet Story App

>**Megjegyzés**: Ez a fejezet tartalmaz egy [**Útmutatót**](./TUTORIAL.md), amely végigvezet a kész minták futtatásán.

Egy Spring Boot webalkalmazás, amely AI-alapú leírásokat és történeteket generál a feltöltött háziállat képekhez a GitHub Modellek segítségével.

## Tartalomjegyzék

- [Technológiai Halmaz](../../../../04-PracticalSamples/petstory)
- [Előfeltételek](../../../../04-PracticalSamples/petstory)
- [Beállítás és Telepítés](../../../../04-PracticalSamples/petstory)
- [Használat](../../../../04-PracticalSamples/petstory)

## Technológiai Halmaz

- **Backend**: Spring Boot 3.5.3, Java 21
- **AI Integráció**: OpenAI Java SDK GitHub Modellekkel
- **Biztonság**: Spring Security
- **Frontend**: Thymeleaf sablonok Bootstrap stílussal
- **Build Eszköz**: Maven
- **AI Modellek**: GitHub Modellek

## Előfeltételek

- Java 21 vagy újabb
- Maven 3.9+
- GitHub Személyes Hozzáférési Token `models:read` jogosultsággal

## Beállítás és Telepítés

### 1. Lépjen a petstory alkalmazás könyvtárába
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Állítsa be a környezeti változót
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Építse fel az alkalmazást
```bash
mvn clean compile
```

### 4. Futtassa az alkalmazást
```bash
mvn spring-boot:run
```

## Használat

1. **Az alkalmazás elérése**: Nyissa meg a `http://localhost:8080` címet
2. **Kép feltöltése**: Kattintson a "Choose File" gombra, és válasszon ki egy háziállat képet
3. **Kép elemzése**: Kattintson az "Analyze Image" gombra az AI leírás megtekintéséhez
4. **Történet generálása**: Kattintson a "Generate Story" gombra a történet létrehozásához

**Felelősség kizárása**:  
Ez a dokumentum az AI fordítási szolgáltatás [Co-op Translator](https://github.com/Azure/co-op-translator) segítségével lett lefordítva. Bár igyekszünk pontosságra törekedni, kérjük, vegye figyelembe, hogy az automatikus fordítások hibákat vagy pontatlanságokat tartalmazhatnak. Az eredeti dokumentum az eredeti nyelvén tekintendő hiteles forrásnak. Fontos információk esetén javasolt professzionális emberi fordítást igénybe venni. Nem vállalunk felelősséget semmilyen félreértésért vagy téves értelmezésért, amely a fordítás használatából eredhet.