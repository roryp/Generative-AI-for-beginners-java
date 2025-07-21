<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T20:06:21+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "da"
}
-->
# Pet Story App

>**Note**: Dette kapitel inkluderer en [**Tutorial**](./TUTORIAL.md), der guider dig gennem, hvordan du kører de færdige eksempler.

En Spring Boot-webapplikation, der genererer AI-drevne beskrivelser og historier for uploadede billeder af kæledyr ved hjælp af GitHub Models.

## Indholdsfortegnelse

- [Teknologisk Stak](../../../../04-PracticalSamples/petstory)
- [Forudsætninger](../../../../04-PracticalSamples/petstory)
- [Opsætning & Installation](../../../../04-PracticalSamples/petstory)
- [Brug](../../../../04-PracticalSamples/petstory)

## Teknologisk Stak

- **Backend**: Spring Boot 3.5.3, Java 21
- **AI-integration**: OpenAI Java SDK med GitHub Models
- **Sikkerhed**: Spring Security
- **Frontend**: Thymeleaf-skabeloner med Bootstrap-styling
- **Byggeværktøj**: Maven
- **AI-modeller**: GitHub Models

## Forudsætninger

- Java 21 eller nyere
- Maven 3.9+
- GitHub Personal Access Token med `models:read` tilladelse

## Opsætning & Installation

### 1. Gå til petstory-applikationens mappe
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Sæt miljøvariabel
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Byg applikationen
```bash
mvn clean compile
```

### 4. Kør applikationen
```bash
mvn spring-boot:run
```

## Brug

1. **Åbn applikationen**: Gå til `http://localhost:8080`
2. **Upload billede**: Klik på "Vælg fil" og vælg et billede af et kæledyr
3. **Analyser billede**: Klik på "Analyser billede" for at få en AI-beskrivelse
4. **Generer historie**: Klik på "Generer historie" for at skabe historien

**Ansvarsfraskrivelse**:  
Dette dokument er blevet oversat ved hjælp af AI-oversættelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selvom vi bestræber os på nøjagtighed, skal du være opmærksom på, at automatiserede oversættelser kan indeholde fejl eller unøjagtigheder. Det originale dokument på dets oprindelige sprog bør betragtes som den autoritative kilde. For kritisk information anbefales professionel menneskelig oversættelse. Vi påtager os ikke ansvar for eventuelle misforståelser eller fejltolkninger, der opstår som følge af brugen af denne oversættelse.