<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T09:40:15+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "no"
}
-->
# Pet Story App

>**Note**: Dette kapittelet inkluderer en [**Tutorial**](./TUTORIAL.md) som veileder deg gjennom eksemplene.

En Spring Boot-nettapplikasjon som genererer AI-drevne beskrivelser og historier for opplastede bilder av kjæledyr ved hjelp av GitHub Models.

## Innholdsfortegnelse

- [Teknologisk Stack](../../../../04-PracticalSamples/petstory)
- [Forutsetninger](../../../../04-PracticalSamples/petstory)
- [Oppsett og Installering](../../../../04-PracticalSamples/petstory)
- [Bruk](../../../../04-PracticalSamples/petstory)

## Teknologisk Stack

- **Backend**: Spring Boot 3.5.3, Java 21
- **AI-integrasjon**: OpenAI Java SDK med GitHub Models
- **Sikkerhet**: Spring Security
- **Frontend**: Thymeleaf-maler med Bootstrap-styling
- **Byggeverktøy**: Maven
- **AI-modeller**: GitHub Models

## Forutsetninger

- Java 21 eller nyere
- Maven 3.9+
- GitHub Personal Access Token med `models:read`-tillatelse

## Oppsett og Installering

### 1. Gå til petstory-applikasjonskatalogen
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

### 4. Start applikasjonen
```bash
mvn spring-boot:run
```

## Bruk

1. **Åpne applikasjonen**: Gå til `http://localhost:8080`
2. **Last opp bilde**: Klikk "Velg fil" og velg et bilde av et kjæledyr
3. **Analyser bilde**: Klikk "Analyser bilde" for å få AI-beskrivelse
4. **Generer historie**: Klikk "Generer historie" for å lage historien

**Ansvarsfraskrivelse**:  
Dette dokumentet er oversatt ved hjelp av AI-oversettelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selv om vi streber etter nøyaktighet, vær oppmerksom på at automatiserte oversettelser kan inneholde feil eller unøyaktigheter. Det originale dokumentet på sitt opprinnelige språk bør anses som den autoritative kilden. For kritisk informasjon anbefales profesjonell menneskelig oversettelse. Vi er ikke ansvarlige for misforståelser eller feiltolkninger som oppstår ved bruk av denne oversettelsen.