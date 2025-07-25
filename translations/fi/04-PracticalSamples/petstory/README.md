<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T09:42:47+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "fi"
}
-->
# Lemmikkitarina-sovellus

>**Huom**: Tämä luku sisältää [**Opetusohjelman**](./TUTORIAL.md), joka opastaa sinut esimerkkien läpi.

Spring Boot -verkkosovellus, joka luo tekoälypohjaisia kuvauksia ja tarinoita ladatuista lemmikkikuvista hyödyntäen GitHub-malleja.

## Sisällysluettelo

- [Teknologiapino](../../../../04-PracticalSamples/petstory)
- [Edellytykset](../../../../04-PracticalSamples/petstory)
- [Asennus ja käyttöönotto](../../../../04-PracticalSamples/petstory)
- [Käyttö](../../../../04-PracticalSamples/petstory)

## Teknologiapino

- **Taustajärjestelmä**: Spring Boot 3.5.3, Java 21
- **Tekoälyintegraatio**: OpenAI Java SDK GitHub-malleilla
- **Turvallisuus**: Spring Security
- **Käyttöliittymä**: Thymeleaf-mallit Bootstrap-tyylityksellä
- **Rakennustyökalu**: Maven
- **Tekoälymallit**: GitHub-mallit

## Edellytykset

- Java 21 tai uudempi
- Maven 3.9+
- GitHubin henkilökohtainen käyttöoikeustunnus, jossa on `models:read` -oikeus

## Asennus ja käyttöönotto

### 1. Siirry petstory-sovellushakemistoon
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Aseta ympäristömuuttuja
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Rakenna sovellus
```bash
mvn clean compile
```

### 4. Käynnistä sovellus
```bash
mvn spring-boot:run
```

## Käyttö

1. **Avaa sovellus**: Siirry osoitteeseen `http://localhost:8080`
2. **Lataa kuva**: Klikkaa "Valitse tiedosto" ja valitse lemmikkikuva
3. **Analysoi kuva**: Klikkaa "Analysoi kuva" saadaksesi tekoälykuvauksen
4. **Luo tarina**: Klikkaa "Luo tarina" luodaksesi tarinan

**Vastuuvapauslauseke**:  
Tämä asiakirja on käännetty käyttämällä tekoälypohjaista käännöspalvelua [Co-op Translator](https://github.com/Azure/co-op-translator). Vaikka pyrimme tarkkuuteen, huomioithan, että automaattiset käännökset voivat sisältää virheitä tai epätarkkuuksia. Alkuperäinen asiakirja sen alkuperäisellä kielellä tulisi pitää ensisijaisena lähteenä. Kriittisen tiedon osalta suositellaan ammattimaista ihmiskäännöstä. Emme ole vastuussa väärinkäsityksistä tai virhetulkinnoista, jotka johtuvat tämän käännöksen käytöstä.