<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T20:06:40+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "fi"
}
-->
# Lemmikkitarina-sovellus

>**Huom**: Tämä luku sisältää [**Opetusohjelman**](./TUTORIAL.md), joka opastaa valmiiden esimerkkien suorittamisessa.

Spring Boot -verkkosovellus, joka luo tekoälypohjaisia kuvauksia ja tarinoita ladatuista lemmikkikuvista GitHub-mallien avulla.

## Sisällysluettelo

- [Teknologiakokonaisuus](../../../../04-PracticalSamples/petstory)
- [Edellytykset](../../../../04-PracticalSamples/petstory)
- [Asennus ja käyttöönotto](../../../../04-PracticalSamples/petstory)
- [Käyttö](../../../../04-PracticalSamples/petstory)

## Teknologiakokonaisuus

- **Taustajärjestelmä**: Spring Boot 3.5.3, Java 21
- **Tekoälyintegraatio**: OpenAI Java SDK GitHub-mallien kanssa
- **Tietoturva**: Spring Security
- **Käyttöliittymä**: Thymeleaf-mallit Bootstrap-tyylillä
- **Rakennustyökalu**: Maven
- **Tekoälymallit**: GitHub-mallit

## Edellytykset

- Java 21 tai uudempi
- Maven 3.9+
- GitHubin henkilökohtainen käyttöoikeustunnus, jossa on `models:read`-oikeus

## Asennus ja käyttöönotto

### 1. Siirry petstory-sovelluksen hakemistoon
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
2. **Lataa kuva**: Klikkaa "Choose File" ja valitse lemmikkikuva
3. **Analysoi kuva**: Klikkaa "Analyze Image" saadaksesi tekoälykuvauksen
4. **Luo tarina**: Klikkaa "Generate Story" luodaksesi tarinan

**Vastuuvapauslauseke**:  
Tämä asiakirja on käännetty käyttämällä tekoälypohjaista käännöspalvelua [Co-op Translator](https://github.com/Azure/co-op-translator). Vaikka pyrimme tarkkuuteen, huomioithan, että automaattiset käännökset voivat sisältää virheitä tai epätarkkuuksia. Alkuperäinen asiakirja sen alkuperäisellä kielellä tulisi katsoa ensisijaiseksi lähteeksi. Kriittisen tiedon osalta suositellaan ammattimaista ihmiskäännöstä. Emme ole vastuussa väärinkäsityksistä tai virhetulkinnoista, jotka johtuvat tämän käännöksen käytöstä.