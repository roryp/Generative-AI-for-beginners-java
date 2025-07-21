<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T20:06:49+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "nl"
}
-->
# Huisdierverhalen App

>**Opmerking**: Dit hoofdstuk bevat een [**Tutorial**](./TUTORIAL.md) die je begeleidt bij het uitvoeren van de voltooide voorbeelden.

Een Spring Boot-webapplicatie die AI-gestuurde beschrijvingen en verhalen genereert voor geüploade afbeeldingen van huisdieren met behulp van GitHub Models.

## Inhoudsopgave

- [Technologiestack](../../../../04-PracticalSamples/petstory)
- [Vereisten](../../../../04-PracticalSamples/petstory)
- [Installatie & Configuratie](../../../../04-PracticalSamples/petstory)
- [Gebruik](../../../../04-PracticalSamples/petstory)

## Technologiestack

- **Backend**: Spring Boot 3.5.3, Java 21
- **AI-integratie**: OpenAI Java SDK met GitHub Models
- **Beveiliging**: Spring Security
- **Frontend**: Thymeleaf-sjablonen met Bootstrap-styling
- **Build Tool**: Maven
- **AI-modellen**: GitHub Models

## Vereisten

- Java 21 of hoger
- Maven 3.9+
- GitHub Personal Access Token met `models:read` scope

## Installatie & Configuratie

### 1. Navigeer naar de petstory-applicatiemap
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Stel een omgevingsvariabele in
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Bouw de applicatie
```bash
mvn clean compile
```

### 4. Start de applicatie
```bash
mvn spring-boot:run
```

## Gebruik

1. **Toegang tot de applicatie**: Ga naar `http://localhost:8080`
2. **Afbeelding uploaden**: Klik op "Bestand kiezen" en selecteer een afbeelding van een huisdier
3. **Afbeelding analyseren**: Klik op "Afbeelding analyseren" om een AI-beschrijving te krijgen
4. **Verhaal genereren**: Klik op "Verhaal genereren" om het verhaal te maken

**Disclaimer**:  
Dit document is vertaald met behulp van de AI-vertalingsservice [Co-op Translator](https://github.com/Azure/co-op-translator). Hoewel we streven naar nauwkeurigheid, dient u zich ervan bewust te zijn dat geautomatiseerde vertalingen fouten of onnauwkeurigheden kunnen bevatten. Het originele document in de oorspronkelijke taal moet worden beschouwd als de gezaghebbende bron. Voor cruciale informatie wordt professionele menselijke vertaling aanbevolen. Wij zijn niet aansprakelijk voor eventuele misverstanden of verkeerde interpretaties die voortvloeien uit het gebruik van deze vertaling.