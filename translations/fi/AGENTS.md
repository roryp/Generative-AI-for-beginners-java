# AGENTS.md

## Projektin yleiskuvaus

Tämä on opetusarkisto, joka on tarkoitettu Generatiivisen tekoälyn kehittämisen oppimiseen Java-kielellä. Se tarjoaa kattavan käytännön kurssin, joka käsittelee suuria kielimalleja (LLM), kehotetekniikkaa, upotuksia, RAG:ia (Retrieval-Augmented Generation) ja Model Context Protocol (MCP) -protokollaa.

**Keskeiset teknologiat:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI ja OpenAI SDK:t

**Arkkitehtuuri:**
- Useita itsenäisiä Spring Boot -sovelluksia, jotka on järjestetty lukujen mukaan
- Esimerkkiprojekteja, jotka havainnollistavat erilaisia tekoälymalleja
- Valmiiksi konfiguroitu GitHub Codespaces -kehitysympäristö

## Asennuskomennot

### Esivaatimukset
- Java 21 tai uudempi
- Maven 3.x
- GitHubin henkilökohtainen käyttöoikeustunnus (GitHub Models -käyttöön)
- Valinnainen: Azure OpenAI -tunnukset

### Ympäristön asennus

**Vaihtoehto 1: GitHub Codespaces (suositeltu)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Vaihtoehto 2: Paikallinen kehityskontti**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Vaihtoehto 3: Paikallinen asennus**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Konfigurointi

**GitHub-tunnuksen asennus:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI -asennus (valinnainen):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Kehitystyön kulku

### Projektin rakenne
```
/
├── 01-IntroToGenAI/              # Chapter 1: Introduction
├── 02-SetupDevEnvironment/       # Chapter 2: Environment setup
│   └── examples/                 # Working examples
├── 03-CoreGenerativeAITechniques/ # Chapter 3: Core techniques
├── 04-PracticalSamples/          # Chapter 4: Sample projects
│   ├── calculator/               # MCP service example
│   ├── foundrylocal/            # Local model integration
│   └── petstory/                # Multi-modal app
├── 05-ResponsibleGenAI/         # Chapter 5: Responsible AI
└── translations/                # Multi-language support
```

### Sovellusten suorittaminen

**Spring Boot -sovelluksen suorittaminen:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Projektin rakentaminen:**
```bash
cd [project-directory]
mvn clean install
```

**MCP-laskinpalvelimen käynnistäminen:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Asiakasesimerkkien suorittaminen:**
```bash
# After starting the server in another terminal
cd 04-PracticalSamples/calculator

# Direct MCP client
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"

# AI-powered client (requires GITHUB_TOKEN)
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"

# Interactive bot
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.Bot"
```

### Kuuman latauksen tuki
Spring Boot DevTools sisältyy projekteihin, jotka tukevat kuuman latauksen ominaisuutta:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Testausohjeet

### Testien suorittaminen

**Suorita kaikki testit projektissa:**
```bash
cd [project-directory]
mvn test
```

**Suorita testit yksityiskohtaisella tulostuksella:**
```bash
mvn test -X
```

**Suorita tietty testiluokka:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Testirakenne
- Testitiedostot käyttävät JUnit 5 (Jupiter) -kirjastoa
- Testiluokat sijaitsevat `src/test/java/`-hakemistossa
- Laskinprojektin asiakasesimerkit ovat `src/test/java/com/microsoft/mcp/sample/client/`-hakemistossa

### Manuaalinen testaus
Monet esimerkit ovat interaktiivisia sovelluksia, jotka vaativat manuaalista testausta:

1. Käynnistä sovellus komennolla `mvn spring-boot:run`
2. Testaa päätepisteitä tai käytä komentoriviliittymää
3. Varmista, että odotettu toiminta vastaa dokumentaatiota kunkin projektin README.md-tiedostossa

### Testaus GitHub Models -mallien kanssa
- Ilmaisen tason rajoitukset: 15 pyyntöä/minuutti, 150/päivä
- Enintään 5 samanaikaista pyyntöä
- Testaa sisällön suodatusta vastuullisen tekoälyn esimerkeillä

## Koodityyliohjeet

### Java-konventiot
- **Java-versio:** Java 21 moderneilla ominaisuuksilla
- **Tyyli:** Noudata standardeja Java-konventioita
- **Nimeäminen:** 
  - Luokat: PascalCase
  - Metodit/muuttujat: camelCase
  - Vakiot: UPPER_SNAKE_CASE
  - Pakettien nimet: pienaakkoset

### Spring Boot -mallit
- Käytä `@Service` liiketoimintalogiikkaan
- Käytä `@RestController` REST-päätepisteisiin
- Konfigurointi `application.yml` tai `application.properties` -tiedostojen kautta
- Ympäristömuuttujat suositeltavia kovakoodattujen arvojen sijaan
- Käytä `@Tool`-annotaatiota MCP:n tarjoamiin metodeihin

### Tiedostojen organisointi
```
src/
├── main/
│   ├── java/
│   │   └── com/microsoft/[component]/
│   │       ├── [Component]Application.java
│   │       ├── config/
│   │       ├── controller/
│   │       ├── service/
│   │       └── exception/
│   └── resources/
│       ├── application.yml
│       └── static/
└── test/
    └── java/
        └── com/microsoft/[component]/
```

### Riippuvuudet
- Hallitaan Mavenin `pom.xml`-tiedoston kautta
- Spring AI BOM versiohallintaan
- LangChain4j tekoälyintegraatioihin
- Spring Boot starter -emoluokka Spring-riippuvuuksille

### Koodikommentit
- Lisää JavaDoc julkisiin rajapintoihin
- Sisällytä selittäviä kommentteja monimutkaisiin tekoälytoimintoihin
- Dokumentoi MCP-työkalujen kuvaukset selkeästi

## Rakentaminen ja käyttöönotto

### Projektien rakentaminen

**Rakenna ilman testejä:**
```bash
mvn clean install -DskipTests
```

**Rakenna kaikki tarkistukset mukaan lukien:**
```bash
mvn clean install
```

**Paketoi sovellus:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Tulostushakemistot
- Käännetyt luokat: `target/classes/`
- Testiluokat: `target/test-classes/`
- JAR-tiedostot: `target/*.jar`
- Mavenin artefaktit: `target/`

### Ympäristökohtainen konfigurointi

**Kehitys:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Tuotanto:**
- Käytä Azure AI Foundry Models -malleja GitHub Models -mallien sijaan
- Päivitä base-url Azure OpenAI -päätepisteeseen
- Hallitse salaisuuksia Azure Key Vaultin tai ympäristömuuttujien kautta

### Käyttöönoton huomioita
- Tämä on opetusarkisto, joka sisältää esimerkkisovelluksia
- Ei suunniteltu tuotantokäyttöön sellaisenaan
- Esimerkit havainnollistavat malleja, joita voi mukauttaa tuotantokäyttöön
- Katso yksittäisten projektien README-tiedostot erityisiä käyttöönotto-ohjeita varten

## Lisähuomioita

### GitHub Models vs Azure OpenAI
- **GitHub Models:** Ilmainen oppimiskäyttöön, ei vaadi luottokorttia
- **Azure OpenAI:** Tuotantokäyttöön valmis, vaatii Azure-tilauksen
- Koodi on yhteensopiva molempien kanssa - vaihda vain päätepiste ja API-avain

### Työskentely useiden projektien kanssa
Jokainen esimerkkiprojekti on itsenäinen:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Yleiset ongelmat

**Java-version yhteensopimattomuus:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Riippuvuuksien latausongelmat:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub-tunnusta ei löydy:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Portti jo käytössä:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Monikielinen tuki
- Dokumentaatio saatavilla yli 45 kielellä automaattisen käännöksen avulla
- Käännökset `translations/`-hakemistossa
- Käännösten hallinta GitHub Actions -työnkulun kautta

### Oppimispolku
1. Aloita [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Seuraa lukuja järjestyksessä (01 → 05)
3. Suorita käytännön esimerkit jokaisessa luvussa
4. Tutki esimerkkiprojekteja luvussa 4
5. Opettele vastuullisen tekoälyn käytäntöjä luvussa 5

### Kehityskontti
`.devcontainer/devcontainer.json` konfiguroi:
- Java 21 -kehitysympäristön
- Maven valmiiksi asennettuna
- VS Code Java -laajennukset
- Spring Boot -työkalut
- GitHub Copilot -integraatio
- Docker-in-Docker-tuki
- Azure CLI

### Suorituskykyhuomiot
- GitHub Models -ilmaisen tason rajoitukset
- Käytä sopivia eräkokoja upotuksille
- Harkitse välimuistia toistuville API-kutsuille
- Seuraa tokenien käyttöä kustannusten optimointia varten

### Turvallisuusohjeet
- Älä koskaan tallenna `.env`-tiedostoja (jo lisätty `.gitignore`-tiedostoon)
- Käytä ympäristömuuttujia API-avaimille
- GitHub-tunnuksilla tulisi olla vain tarvittavat käyttöoikeudet
- Noudata vastuullisen tekoälyn ohjeita luvussa 5

---

**Vastuuvapauslauseke**:  
Tämä asiakirja on käännetty käyttämällä AI-käännöspalvelua [Co-op Translator](https://github.com/Azure/co-op-translator). Vaikka pyrimme tarkkuuteen, huomioithan, että automaattiset käännökset voivat sisältää virheitä tai epätarkkuuksia. Alkuperäistä asiakirjaa sen alkuperäisellä kielellä tulisi pitää ensisijaisena lähteenä. Kriittisen tiedon osalta suositellaan ammattimaista ihmiskäännöstä. Emme ole vastuussa väärinkäsityksistä tai virhetulkinnoista, jotka johtuvat tämän käännöksen käytöstä.