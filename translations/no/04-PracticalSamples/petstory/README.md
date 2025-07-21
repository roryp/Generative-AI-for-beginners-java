<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T20:06:30+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "no"
}
-->
# Pet Story App

>**Merk**: Dette kapittelet inkluderer en [**Veiledning**](./TUTORIAL.md) som guider deg gjennom hvordan du kjører de ferdige eksemplene.

En Spring Boot-webapplikasjon som genererer AI-drevne beskrivelser og historier for opplastede bilder av kjæledyr ved hjelp av GitHub-modeller.

## Innholdsfortegnelse

- [Teknologibunke](../../../../04-PracticalSamples/petstory)
- [Forutsetninger](../../../../04-PracticalSamples/petstory)
- [Oppsett og installasjon](../../../../04-PracticalSamples/petstory)
- [Bruk](../../../../04-PracticalSamples/petstory)

## Teknologibunke

- **Backend**: Spring Boot 3.5.3, Java 21
- **AI-integrasjon**: OpenAI Java SDK med GitHub-modeller
- **Sikkerhet**: Spring Security
- **Frontend**: Thymeleaf-maler med Bootstrap-styling
- **Byggeverktøy**: Maven
- **AI-modeller**: GitHub-modeller

## Forutsetninger

- Java 21 eller nyere
- Maven 3.9+
- GitHub Personal Access Token med `models:read`-tillatelse

## Oppsett og installasjon

### 1. Gå til petstory-applikasjonsmappen
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Sett miljøvariabel
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Bygg applikasjonen
```bash
mvn clean compile
```

### 4. Kjør applikasjonen
```bash
mvn spring-boot:run
```

## Bruk

1. **Åpne applikasjonen**: Gå til `http://localhost:8080`
2. **Last opp bilde**: Klikk på "Velg fil" og velg et bilde av et kjæledyr
3. **Analyser bilde**: Klikk på "Analyser bilde" for å få en AI-beskrivelse
4. **Generer historie**: Klikk på "Generer historie" for å lage en historie

**Ansvarsfraskrivelse**:  
Dette dokumentet er oversatt ved hjelp av AI-oversettelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selv om vi streber etter nøyaktighet, vær oppmerksom på at automatiserte oversettelser kan inneholde feil eller unøyaktigheter. Det originale dokumentet på sitt opprinnelige språk bør anses som den autoritative kilden. For kritisk informasjon anbefales profesjonell menneskelig oversettelse. Vi er ikke ansvarlige for eventuelle misforståelser eller feiltolkninger som oppstår ved bruk av denne oversettelsen.