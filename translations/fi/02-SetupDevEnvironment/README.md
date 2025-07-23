<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "40abf4889418bff189039ac30ff44281",
  "translation_date": "2025-07-23T12:23:47+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "fi"
}
-->
# Kehitysympäristön asennus Generatiiviselle AI:lle Javaa varten

> **Pikakäynnistys**: Koodaa pilvessä 2 minuutissa - Siirry kohtaan [GitHub Codespaces -asennus](../../../02-SetupDevEnvironment) - ei vaadi paikallista asennusta ja käyttää GitHub-malleja!

> **Kiinnostunut Azure OpenAI:sta?** Katso [Azure OpenAI -asennusoppaamme](getting-started-azure-openai.md), jossa on ohjeet uuden Azure OpenAI -resurssin luomiseen.

## Mitä opit

- Java-kehitysympäristön asennus AI-sovelluksia varten
- Valitse ja konfiguroi haluamasi kehitysympäristö (pilvipainotteinen Codespaces, paikallinen kehityskontti tai täysin paikallinen asennus)
- Testaa asennuksesi yhdistämällä GitHub-malleihin

## Sisällysluettelo

- [Mitä opit](../../../02-SetupDevEnvironment)
- [Johdanto](../../../02-SetupDevEnvironment)
- [Vaihe 1: Kehitysympäristön asennus](../../../02-SetupDevEnvironment)
  - [Vaihtoehto A: GitHub Codespaces (suositeltu)](../../../02-SetupDevEnvironment)
  - [Vaihtoehto B: Paikallinen kehityskontti](../../../02-SetupDevEnvironment)
  - [Vaihtoehto C: Käytä olemassa olevaa paikallista asennusta](../../../02-SetupDevEnvironment)
- [Vaihe 2: Luo GitHub-henkilökohtainen käyttöoikeustunnus](../../../02-SetupDevEnvironment)
- [Vaihe 3: Testaa asennuksesi](../../../02-SetupDevEnvironment)
- [Vianmääritys](../../../02-SetupDevEnvironment)
- [Yhteenveto](../../../02-SetupDevEnvironment)
- [Seuraavat askeleet](../../../02-SetupDevEnvironment)

## Johdanto

Tämä luku opastaa sinut kehitysympäristön asennuksessa. Käytämme **GitHub-malleja** ensisijaisena esimerkkinä, koska se on ilmainen, helppo asentaa pelkällä GitHub-tilillä, ei vaadi luottokorttia ja tarjoaa pääsyn useisiin malleihin kokeilua varten.

**Ei vaadi paikallista asennusta!** Voit aloittaa koodaamisen välittömästi käyttämällä GitHub Codespacesia, joka tarjoaa täyden kehitysympäristön suoraan selaimessasi.

<img src="./images/models.webp" alt="Näyttökuva: GitHub-mallit" width="50%">

Suosittelemme käyttämään [**GitHub-malleja**](https://github.com/marketplace?type=models) tässä kurssissa, koska ne ovat:
- **Ilmaisia** aloittaa
- **Helppoja** asentaa pelkällä GitHub-tilillä
- **Ei luottokorttia** vaadita
- **Useita malleja** kokeilua varten

> **Huomio**: Tässä koulutuksessa käytetyillä GitHub-malleilla on seuraavat ilmaiset rajoitukset:
> - 15 pyyntöä minuutissa (150 päivässä)
> - ~8 000 sanaa sisään, ~4 000 sanaa ulos per pyyntö
> - 5 samanaikaista pyyntöä
> 
> Tuotantokäyttöön päivitä Azure AI Foundry -malleihin Azure-tililläsi. Koodiasi ei tarvitse muuttaa. Katso [Azure AI Foundry -dokumentaatio](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models).

## Vaihe 1: Kehitysympäristön asennus

<a name="quick-start-cloud"></a>

Olemme luoneet esikonfiguroidun kehityskontin, joka minimoi asennusajan ja varmistaa, että sinulla on kaikki tarvittavat työkalut tätä Generatiivinen AI Java -kurssia varten. Valitse haluamasi kehitystapa:

### Ympäristön asennusvaihtoehdot:

#### Vaihtoehto A: GitHub Codespaces (suositeltu)

**Aloita koodaaminen 2 minuutissa - ei vaadi paikallista asennusta!**

1. Haarauta tämä arkisto GitHub-tilillesi
   > **Huomio**: Jos haluat muokata peruskonfiguraatiota, tutustu [Dev Container Configuration](../../../.devcontainer/devcontainer.json)
2. Klikkaa **Code** → **Codespaces**-välilehti → **...** → **New with options...**
3. Käytä oletusasetuksia – tämä valitsee **Dev container configuration**: **Generative AI Java Development Environment** -kontin, joka on luotu tätä kurssia varten
4. Klikkaa **Create codespace**
5. Odota ~2 minuuttia, että ympäristö on valmis
6. Siirry kohtaan [Vaihe 2: Luo GitHub-tunnus](../../../02-SetupDevEnvironment)

<img src="./images/codespaces.png" alt="Näyttökuva: Codespaces-alavalikko" width="50%">

<img src="./images/image.png" alt="Näyttökuva: New with options" width="50%">

<img src="./images/codespaces-create.png" alt="Näyttökuva: Create codespace options" width="50%">


> **Codespacesin edut**:
> - Ei vaadi paikallista asennusta
> - Toimii millä tahansa laitteella, jossa on selain
> - Esikonfiguroitu kaikilla työkaluilla ja riippuvuuksilla
> - Ilmainen 60 tuntia kuukaudessa henkilökohtaisille tileille
> - Johdonmukainen ympäristö kaikille oppijoille

#### Vaihtoehto B: Paikallinen kehityskontti

**Kehittäjille, jotka suosivat paikallista kehitystä Dockerilla**

1. Haarauta ja kloonaa tämä arkisto paikalliselle koneellesi
   > **Huomio**: Jos haluat muokata peruskonfiguraatiota, tutustu [Dev Container Configuration](../../../.devcontainer/devcontainer.json)
2. Asenna [Docker Desktop](https://www.docker.com/products/docker-desktop/) ja [VS Code](https://code.visualstudio.com/)
3. Asenna [Dev Containers -laajennus](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) VS Codeen
4. Avaa arkiston kansio VS Codessa
5. Kun sinua kehotetaan, klikkaa **Reopen in Container** (tai käytä `Ctrl+Shift+P` → "Dev Containers: Reopen in Container")
6. Odota, että kontti rakentuu ja käynnistyy
7. Siirry kohtaan [Vaihe 2: Luo GitHub-tunnus](../../../02-SetupDevEnvironment)

<img src="./images/devcontainer.png" alt="Näyttökuva: Dev container -asennus" width="50%">

<img src="./images/image-3.png" alt="Näyttökuva: Dev container -rakennus valmis" width="50%">

#### Vaihtoehto C: Käytä olemassa olevaa paikallista asennusta

**Kehittäjille, joilla on olemassa olevat Java-ympäristöt**

Edellytykset:
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) tai haluamasi IDE

Vaiheet:
1. Kloonaa tämä arkisto paikalliselle koneellesi
2. Avaa projekti IDE:ssäsi
3. Siirry kohtaan [Vaihe 2: Luo GitHub-tunnus](../../../02-SetupDevEnvironment)

> **Vinkki**: Jos sinulla on vähätehoinen kone mutta haluat käyttää VS Codea paikallisesti, käytä GitHub Codespacesia! Voit yhdistää paikallisen VS Coden pilvessä isännöityyn Codespaceen ja saada molempien maailmojen parhaat puolet.

<img src="./images/image-2.png" alt="Näyttökuva: luotu paikallinen kehityskontti" width="50%">


## Vaihe 2: Luo GitHub-henkilökohtainen käyttöoikeustunnus

1. Siirry [GitHub-asetuksiin](https://github.com/settings/profile) ja valitse **Settings** profiilivalikosta.
2. Vasemmassa sivupalkissa klikkaa **Developer settings** (yleensä alhaalla).
3. Valitse **Personal access tokens** ja klikkaa **Fine-grained tokens** (tai käytä tätä suoraa [linkkiä](https://github.com/settings/personal-access-tokens)).
4. Klikkaa **Generate new token**.
5. Anna "Token name" -kenttään kuvaava nimi (esim. `GenAI-Java-Course-Token`).
6. Aseta vanhenemispäivä (suositus: 7 päivää turvallisuuskäytäntöjen mukaisesti).
7. Valitse "Resource owner" -kohdassa käyttäjätilisi.
8. Valitse "Repository access" -kohdassa ne arkistot, joita haluat käyttää GitHub-mallien kanssa (tai "All repositories", jos tarpeen).
9. Valitse "Repository permissions" -kohdassa **Models** ja aseta se **Read and write**.
10. Klikkaa **Generate token**.
11. **Kopioi ja tallenna tunnuksesi nyt** – et näe sitä enää uudelleen!

> **Turvallisuusvinkki**: Käytä vähimmäisvaadittua laajuutta ja lyhintä käytännöllistä vanhenemisaikaa käyttöoikeustunnuksille.

## Vaihe 3: Testaa asennuksesi GitHub-mallien esimerkillä

Kun kehitysympäristösi on valmis, testataan GitHub-mallien integrointi esimerkkisovelluksellamme [`02-SetupDevEnvironment/src/github-models`](../../../02-SetupDevEnvironment/src/github-models).

1. Avaa terminaali kehitysympäristössäsi.
2. Siirry GitHub-mallien esimerkkiin:
   ```bash
   cd 02-SetupDevEnvironment/src/github-models
   ```
3. Aseta GitHub-tunnuksesi ympäristömuuttujaksi:
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. Suorita sovellus:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

Näet tulosteen, joka näyttää tältä:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### Esimerkkikoodin ymmärtäminen

Ensiksi, ymmärretään mitä juuri suoritettiin. Esimerkki `src/github-models`-kansiossa käyttää OpenAI Java SDK:ta yhdistääkseen GitHub-malleihin:

**Mitä tämä koodi tekee:**
- **Yhdistää** GitHub-malleihin henkilökohtaisen käyttöoikeustunnuksesi avulla
- **Lähettää** yksinkertaisen "Say Hello World!" -viestin AI-mallille
- **Vastaanottaa** ja näyttää AI:n vastauksen
- **Vahvistaa**, että asennuksesi toimii oikein

**Keskeinen riippuvuus** (tiedostossa `pom.xml`):
```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

**Pääkoodi** (`App.java`):
```java
// Connect to GitHub Models using OpenAI Java SDK
OpenAIClient client = OpenAIOkHttpClient.builder()
    .apiKey(pat)
    .baseUrl("https://models.inference.ai.azure.com")
    .build();

// Create chat completion request
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .model(modelId)
    .addSystemMessage("You are a concise assistant.")
    .addUserMessage("Say Hello World!")
    .build();

// Get AI response
ChatCompletion response = client.chat().completions().create(params);
System.out.println("Response: " + response.choices().get(0).message().content().orElse("No response content"));
```

## Yhteenveto

**Onnittelut!** Olet onnistuneesti:

- **Luonut GitHub-henkilökohtaisen käyttöoikeustunnuksen**, jolla on oikeat käyttöoikeudet AI-mallien käyttöön
- **Asentanut Java-kehitysympäristön** käyttämällä Codespacesia, kehityskontteja tai paikallista asennusta
- **Yhdistänyt GitHub-malleihin** OpenAI Java SDK:n avulla ilmaista AI-kehitystä varten
- **Testannut integraation** toimivalla esimerkkisovelluksella, joka kommunikoi AI-mallien kanssa

## Seuraavat askeleet

[Luku 3: Generatiivisen AI:n keskeiset tekniikat](../03-CoreGenerativeAITechniques/README.md)

## Vianmääritys

Ongelmia? Tässä yleisiä ongelmia ja ratkaisuja:

- **Tunnus ei toimi?** 
  - Varmista, että kopioit koko tunnuksen ilman ylimääräisiä välilyöntejä
  - Tarkista, että tunnus on asetettu oikein ympäristömuuttujaksi
  - Varmista, että tunnuksellasi on oikeat käyttöoikeudet (Models: Read and write)

- **Mavenia ei löydy?** 
  - Jos käytät kehityskontteja/Codespacesia, Maven pitäisi olla esiasennettuna
  - Paikallisessa asennuksessa varmista, että Java 21+ ja Maven 3.9+ on asennettu
  - Kokeile `mvn --version` varmistaaksesi asennuksen

- **Yhteysongelmia?** 
  - Tarkista internet-yhteytesi
  - Varmista, että GitHub on saavutettavissa verkostasi
  - Varmista, ettei palomuuri estä GitHub-mallien päätepistettä

- **Kehityskontti ei käynnisty?** 
  - Varmista, että Docker Desktop on käynnissä (paikallista kehitystä varten)
  - Kokeile rakentaa kontti uudelleen: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container"

- **Sovelluksen kääntämisvirheet?**
  - Varmista, että olet oikeassa hakemistossa: `02-SetupDevEnvironment/src/github-models`
  - Kokeile puhdistaa ja rakentaa uudelleen: `mvn clean compile`

> **Tarvitsetko apua?**: Onko edelleen ongelmia? Avaa ongelma arkistossa, niin autamme sinua.

**Vastuuvapauslauseke**:  
Tämä asiakirja on käännetty käyttämällä tekoälypohjaista käännöspalvelua [Co-op Translator](https://github.com/Azure/co-op-translator). Vaikka pyrimme tarkkuuteen, huomioithan, että automaattiset käännökset voivat sisältää virheitä tai epätarkkuuksia. Alkuperäinen asiakirja sen alkuperäisellä kielellä tulisi pitää ensisijaisena lähteenä. Kriittisen tiedon osalta suositellaan ammattimaista ihmiskäännöstä. Emme ole vastuussa väärinkäsityksistä tai virhetulkinnoista, jotka johtuvat tämän käännöksen käytöstä.