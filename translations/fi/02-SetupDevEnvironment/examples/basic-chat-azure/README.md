# Peruskeskustelu Azure OpenAI:n kanssa - Esimerkki alusta loppuun

Tämä esimerkki näyttää, kuinka luoda yksinkertainen Spring Boot -sovellus, joka yhdistyy Azure OpenAI:hin ja testaa kokoonpanosi.

## Sisällysluettelo

- [Esivaatimukset](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Pika-aloitus](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Konfigurointivaihtoehdot](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Vaihtoehto 1: Ympäristömuuttujat (.env-tiedosto) - Suositeltu](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Vaihtoehto 2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Sovelluksen suorittaminen](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Mavenin käyttäminen](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [VS Coden käyttäminen](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Odotettu tulos](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Konfigurointiviite](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Ympäristömuuttujat](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring-konfiguraatio](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Vianmääritys](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Yleiset ongelmat](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Debug-tila](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Seuraavat vaiheet](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Resurssit](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Esivaatimukset

Ennen tämän esimerkin suorittamista varmista, että sinulla on:

- Suoritettu [Azure OpenAI -asennusopas](../../getting-started-azure-openai.md)  
- Azure OpenAI -resurssi käyttöönotettuna (Azure AI Foundry -portaalin kautta)  
- gpt-4o-mini-malli (tai vaihtoehtoinen) käyttöönotettuna  
- API-avain ja päätepisteen URL Azuresta  

## Pika-aloitus

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Konfigurointivaihtoehdot

### Vaihtoehto 1: Ympäristömuuttujat (.env-tiedosto) - Suositeltu

**Vaihe 1: Luo konfiguraatiotiedosto**
```bash
cp .env.example .env
```

**Vaihe 2: Lisää Azure OpenAI -tunnistetietosi**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Turvallisuusvinkki**: 
> - Älä koskaan lisää `.env`-tiedostoa versionhallintaan
> - `.env`-tiedosto on jo lisätty `.gitignore`-tiedostoon
> - Pidä API-avaimesi turvassa ja vaihda ne säännöllisesti

### Vaihtoehto 2: GitHub Codespace Secrets

GitHub Codespaces -ympäristössä aseta seuraavat salaisuudet repositoriossasi:
- `AZURE_AI_KEY` - Azure OpenAI API -avain
- `AZURE_AI_ENDPOINT` - Azure OpenAI -päätepisteen URL

Sovellus tunnistaa ja käyttää näitä salaisuuksia automaattisesti.

### Vaihtoehto: Suorat ympäristömuuttujat

<details>
<summary>Napsauta nähdäksesi alustakohtaiset komennot</summary>

**Linux/macOS (bash/zsh):**
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Komentokehote):**
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## Sovelluksen suorittaminen

### Mavenin käyttäminen

```bash
mvn spring-boot:run
```

### VS Coden käyttäminen

1. Avaa projekti VS Codessa
2. Paina `F5` tai käytä "Run and Debug" -paneelia
3. Valitse "Spring Boot-BasicChatApplication" -konfiguraatio

> **Huomio**: VS Code -konfiguraatio lataa automaattisesti `.env`-tiedoston

### Odotettu tulos

```
Starting Basic Chat with Azure OpenAI...
Environment variables loaded successfully
Connecting to Azure OpenAI...
Sending prompt: What is AI in a short sentence? Max 100 words.

AI Response:
================
AI, or Artificial Intelligence, is the simulation of human intelligence in machines programmed to think and learn like humans.
================

Success! Azure OpenAI connection is working correctly.
```

## Konfigurointiviite

### Ympäristömuuttujat

| Muuttuja | Kuvaus | Pakollinen | Esimerkki |
|----------|-------------|----------|---------|
| `AZURE_AI_KEY` | Azure OpenAI API -avain | Kyllä | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI -päätepisteen URL | Kyllä | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Mallin käyttöönoton nimi | Ei | `gpt-4o-mini` (oletus) |

### Spring-konfiguraatio

`application.yml`-tiedosto määrittää:
- **API-avain**: `${AZURE_AI_KEY}` - Ympäristömuuttujasta
- **Päätepiste**: `${AZURE_AI_ENDPOINT}` - Ympäristömuuttujasta  
- **Malli**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Ympäristömuuttujasta oletusarvolla
- **Temperature**: `0.7` - Luovuuden hallinta (0.0 = deterministinen, 1.0 = luova)
- **Max Tokens**: `500` - Vasteen maksimipituus

## Vianmääritys

### Yleiset ongelmat

<details>
<summary><strong>Virhe: "API-avain ei ole kelvollinen"</strong></summary>

- Tarkista, että `AZURE_AI_KEY` on oikein asetettu `.env`-tiedostoon
- Varmista, että API-avain on kopioitu täsmälleen Azure AI Foundry -portaalista
- Varmista, ettei avaimen ympärillä ole ylimääräisiä välilyöntejä tai lainausmerkkejä
</details>

<details>
<summary><strong>Virhe: "Päätepiste ei ole kelvollinen"</strong></summary>

- Varmista, että `AZURE_AI_ENDPOINT` sisältää koko URL-osoitteen (esim. `https://your-hub-name.openai.azure.com/`)
- Tarkista, ettei URL-osoitteessa ole ylimääräistä kauttaviivaa
- Varmista, että päätepiste vastaa Azure-käyttöönottoalueesi
</details>

<details>
<summary><strong>Virhe: "Käyttöönottoa ei löytynyt"</strong></summary>

- Varmista, että mallin käyttöönoton nimi vastaa täsmälleen Azureen käyttöönotettua nimeä
- Tarkista, että malli on onnistuneesti käyttöönotettu ja aktiivinen
- Kokeile oletuskäyttöönoton nimeä: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Ympäristömuuttujia ei ladata</strong></summary>

- Varmista, että `.env`-tiedosto on projektin juurihakemistossa (samalla tasolla kuin `pom.xml`)
- Kokeile suorittaa `mvn spring-boot:run` VS Coden integroidussa terminaalissa
- Tarkista, että VS Code Java -laajennus on asennettu oikein
- Varmista, että käynnistyskonfiguraatiossa on `"envFile": "${workspaceFolder}/.env"`
</details>

### Debug-tila

Ota yksityiskohtainen lokitus käyttöön poistamalla kommentit näistä riveistä `application.yml`-tiedostossa:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Seuraavat vaiheet

**Asennus valmis!** Jatka oppimismatkaasi:

[3. luku: Generatiivisen tekoälyn ydintekniikat](../../../03-CoreGenerativeAITechniques/README.md)

## Resurssit

- [Spring AI Azure OpenAI -dokumentaatio](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI -palvelun dokumentaatio](https://learn.microsoft.com/azure/ai-services/openai/)
- [Azure AI Foundry -portaali](https://ai.azure.com/)
- [Azure AI Foundry -dokumentaatio](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Vastuuvapauslauseke**:  
Tämä asiakirja on käännetty käyttämällä tekoälypohjaista käännöspalvelua [Co-op Translator](https://github.com/Azure/co-op-translator). Vaikka pyrimme tarkkuuteen, huomioithan, että automaattiset käännökset voivat sisältää virheitä tai epätarkkuuksia. Alkuperäistä asiakirjaa sen alkuperäisellä kielellä tulisi pitää ensisijaisena lähteenä. Kriittisen tiedon osalta suositellaan ammattimaista ihmiskäännöstä. Emme ole vastuussa mahdollisista väärinkäsityksistä tai virhetulkinnoista, jotka johtuvat tämän käännöksen käytöstä.