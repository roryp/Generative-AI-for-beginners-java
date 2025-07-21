<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T20:06:13+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "sv"
}
-->
# Pet Story App

>**Note**: Detta kapitel inkluderar en [**Tutorial**](./TUTORIAL.md) som guidar dig genom att köra de färdiga exemplen.

En Spring Boot-webbapplikation som skapar AI-drivna beskrivningar och berättelser för uppladdade bilder på husdjur med hjälp av GitHub Models.

## Innehållsförteckning

- [Teknologisk Stack](../../../../04-PracticalSamples/petstory)
- [Förutsättningar](../../../../04-PracticalSamples/petstory)
- [Installation & Konfiguration](../../../../04-PracticalSamples/petstory)
- [Användning](../../../../04-PracticalSamples/petstory)

## Teknologisk Stack

- **Backend**: Spring Boot 3.5.3, Java 21
- **AI-integration**: OpenAI Java SDK med GitHub Models
- **Säkerhet**: Spring Security
- **Frontend**: Thymeleaf-mallar med Bootstrap-styling
- **Byggverktyg**: Maven
- **AI-modeller**: GitHub Models

## Förutsättningar

- Java 21 eller högre
- Maven 3.9+
- GitHub Personal Access Token med `models:read`-behörighet

## Installation & Konfiguration

### 1. Gå till katalogen för petstory-applikationen
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Ställ in miljövariabel
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Bygg applikationen
```bash
mvn clean compile
```

### 4. Kör applikationen
```bash
mvn spring-boot:run
```

## Användning

1. **Öppna applikationen**: Gå till `http://localhost:8080`
2. **Ladda upp bild**: Klicka på "Välj fil" och välj en bild på ett husdjur
3. **Analysera bild**: Klicka på "Analysera bild" för att få en AI-beskrivning
4. **Skapa berättelse**: Klicka på "Skapa berättelse" för att generera berättelsen

**Ansvarsfriskrivning**:  
Detta dokument har översatts med hjälp av AI-översättningstjänsten [Co-op Translator](https://github.com/Azure/co-op-translator). Även om vi strävar efter noggrannhet, bör det noteras att automatiserade översättningar kan innehålla fel eller brister. Det ursprungliga dokumentet på dess originalspråk bör betraktas som den auktoritativa källan. För kritisk information rekommenderas professionell mänsklig översättning. Vi ansvarar inte för eventuella missförstånd eller feltolkningar som uppstår vid användning av denna översättning.