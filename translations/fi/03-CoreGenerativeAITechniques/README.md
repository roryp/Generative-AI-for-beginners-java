<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "59454ab4ec36d89840df6fcfe7633cbd",
  "translation_date": "2025-07-25T11:34:12+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "fi"
}
-->
# Generatiivisen tekoälyn ydintekniikoiden opas

## Sisällysluettelo

- [Esivaatimukset](../../../03-CoreGenerativeAITechniques)
- [Aloittaminen](../../../03-CoreGenerativeAITechniques)
  - [Vaihe 1: Aseta ympäristömuuttuja](../../../03-CoreGenerativeAITechniques)
  - [Vaihe 2: Siirry esimerkkihakemistoon](../../../03-CoreGenerativeAITechniques)
- [Opas 1: LLM-vastaukset ja keskustelu](../../../03-CoreGenerativeAITechniques)
- [Opas 2: Funktioiden kutsuminen](../../../03-CoreGenerativeAITechniques)
- [Opas 3: RAG (hakuun perustuva generointi)](../../../03-CoreGenerativeAITechniques)
- [Opas 4: Vastuullinen tekoäly](../../../03-CoreGenerativeAITechniques)
- [Yleiset mallit esimerkeissä](../../../03-CoreGenerativeAITechniques)
- [Seuraavat askeleet](../../../03-CoreGenerativeAITechniques)
- [Vianmääritys](../../../03-CoreGenerativeAITechniques)
  - [Yleiset ongelmat](../../../03-CoreGenerativeAITechniques)

## Yleiskatsaus

Tämä opas tarjoaa käytännön esimerkkejä generatiivisen tekoälyn ydintekniikoista käyttäen Javaa ja GitHub-malleja. Opit, miten vuorovaikutat suurten kielimallien (LLM) kanssa, toteutat funktiokutsuja, käytät hakuun perustuvaa generointia (RAG) ja sovellat vastuullisen tekoälyn käytäntöjä.

## Esivaatimukset

Ennen aloittamista varmista, että sinulla on:
- Java 21 tai uudempi asennettuna
- Maven riippuvuuksien hallintaan
- GitHub-tili ja henkilökohtainen käyttöoikeustunnus (PAT)

## Aloittaminen

### Vaihe 1: Aseta ympäristömuuttuja

Ensiksi sinun täytyy asettaa GitHub-tunnuksesi ympäristömuuttujaksi. Tämä tunnus mahdollistaa pääsyn GitHub-malleihin ilmaiseksi.

**Windows (Komentokehote):**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Windows (PowerShell):**
```powershell
$env:GITHUB_TOKEN="your_github_token_here"
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

### Vaihe 2: Siirry esimerkkihakemistoon

```bash
cd 03-CoreGenerativeAITechniques/examples/
```

## Opas 1: LLM-vastaukset ja keskustelu

**Tiedosto:** `src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

### Mitä tämä esimerkki opettaa

Tämä esimerkki havainnollistaa suurten kielimallien (LLM) vuorovaikutuksen perusmekaniikkaa OpenAI-rajapinnan kautta. Se sisältää asiakasohjelman alustamisen GitHub-malleilla, viestirakenteet järjestelmä- ja käyttäjäkehotteille, keskustelutilan hallinnan viestihistorian avulla sekä parametrien säätämisen vastausten pituuden ja luovuuden hallitsemiseksi.

### Keskeiset koodikäsitteet

#### 1. Asiakasohjelman alustaminen
```java
// Create the AI client
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(new StaticTokenCredential(pat))
    .buildClient();
```

Tämä luo yhteyden GitHub-malleihin käyttäen tunnustasi.

#### 2. Yksinkertainen vastaus
```java
List<ChatRequestMessage> messages = List.of(
    // System message sets AI behavior
    new ChatRequestSystemMessage("You are a helpful Java expert."),
    // User message contains the actual question
    new ChatRequestUserMessage("Explain Java streams briefly.")
);

ChatCompletionsOptions options = new ChatCompletionsOptions(messages)
    .setModel("gpt-4o-mini")
    .setMaxTokens(200)      // Limit response length
    .setTemperature(0.7);   // Control creativity (0.0-1.0)
```

#### 3. Keskustelumuisti
```java
// Add AI's response to maintain conversation history
messages.add(new ChatRequestAssistantMessage(aiResponse));
messages.add(new ChatRequestUserMessage("Follow-up question"));
```

AI muistaa aiemmat viestit vain, jos sisällytät ne seuraaviin pyyntöihin.

### Suorita esimerkki
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
```

### Mitä tapahtuu, kun suoritat sen

1. **Yksinkertainen vastaus**: AI vastaa Java-kysymykseen järjestelmäkehotteen ohjaamana.
2. **Monivaiheinen keskustelu**: AI säilyttää kontekstin useiden kysymysten välillä.
3. **Interaktiivinen keskustelu**: Voit käydä todellisen keskustelun AI:n kanssa.

## Opas 2: Funktioiden kutsuminen

**Tiedosto:** `src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

### Mitä tämä esimerkki opettaa

Funktioiden kutsuminen mahdollistaa AI-mallien pyytää ulkoisten työkalujen ja rajapintojen suorittamista. Malli analysoi luonnollisen kielen pyynnöt, määrittää tarvittavat funktiokutsut ja niiden parametrit JSON-skeemojen avulla sekä käsittelee palautetut tulokset luodakseen kontekstuaalisia vastauksia. Funktioiden suoritus pysyy kehittäjän hallinnassa turvallisuuden ja luotettavuuden takaamiseksi.

### Keskeiset koodikäsitteet

#### 1. Funktion määrittely
```java
ChatCompletionsFunctionToolDefinitionFunction weatherFunction = 
    new ChatCompletionsFunctionToolDefinitionFunction("get_weather");
weatherFunction.setDescription("Get current weather information for a city");

// Define parameters using JSON Schema
weatherFunction.setParameters(BinaryData.fromString("""
    {
        "type": "object",
        "properties": {
            "city": {
                "type": "string",
                "description": "The city name"
            }
        },
        "required": ["city"]
    }
    """));
```

Tämä kertoo AI:lle, mitkä funktiot ovat käytettävissä ja miten niitä käytetään.

#### 2. Funktion suoritusprosessi
```java
// 1. AI requests a function call
if (choice.getFinishReason() == CompletionsFinishReason.TOOL_CALLS) {
    ChatCompletionsFunctionToolCall functionCall = ...;
    
    // 2. You execute the function
    String result = simulateWeatherFunction(functionCall.getFunction().getArguments());
    
    // 3. You give the result back to AI
    messages.add(new ChatRequestToolMessage(result, toolCall.getId()));
    
    // 4. AI provides final response with function result
    ChatCompletions finalResponse = client.getChatCompletions(MODEL, options);
}
```

#### 3. Funktion toteutus
```java
private static String simulateWeatherFunction(String arguments) {
    // Parse arguments and call real weather API
    // For demo, we return mock data
    return """
        {
            "city": "Seattle",
            "temperature": "22",
            "condition": "partly cloudy"
        }
        """;
}
```

### Suorita esimerkki
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
```

### Mitä tapahtuu, kun suoritat sen

1. **Sääfunktio**: AI pyytää säätietoja Seattlesta, sinä toimitat ne, ja AI muotoilee vastauksen.
2. **Laskinfunktio**: AI pyytää laskemaan (15 % luvusta 240), sinä suoritat laskennan, ja AI selittää tuloksen.

## Opas 3: RAG (hakuun perustuva generointi)

**Tiedosto:** `src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

### Mitä tämä esimerkki opettaa

Hakuun perustuva generointi (RAG) yhdistää tiedon haun ja kielen generoinnin lisäämällä ulkoisten dokumenttien kontekstia AI-kehotteisiin. Tämä mahdollistaa mallien antamaan tarkkoja vastauksia tiettyjen tietolähteiden perusteella sen sijaan, että ne luottaisivat mahdollisesti vanhentuneisiin tai epätarkkoihin koulutustietoihin.

### Keskeiset koodikäsitteet

#### 1. Dokumenttien lataaminen
```java
// Load your knowledge source
String doc = Files.readString(Paths.get("document.txt"));
```

#### 2. Kontekstin lisääminen
```java
List<ChatRequestMessage> messages = List.of(
    new ChatRequestSystemMessage(
        "Use only the CONTEXT to answer. If not in context, say you cannot find it."
    ),
    new ChatRequestUserMessage(
        "CONTEXT:\n\"\"\"\n" + doc + "\n\"\"\"\n\nQUESTION:\n" + question
    )
);
```

Kolmoislainausmerkit auttavat AI:ta erottamaan kontekstin ja kysymyksen.

#### 3. Turvallinen vastausten käsittely
```java
if (response != null && response.getChoices() != null && !response.getChoices().isEmpty()) {
    String answer = response.getChoices().get(0).getMessage().getContent();
    System.out.println("Assistant: " + answer);
} else {
    System.err.println("Error: No response received from the API.");
}
```

Tarkista aina API-vastaukset kaatumisten estämiseksi.

### Suorita esimerkki
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
```

### Mitä tapahtuu, kun suoritat sen

1. Ohjelma lataa `document.txt`-tiedoston (sisältää tietoa GitHub-malleista).
2. Kysyt kysymyksen dokumentista.
3. AI vastaa vain dokumentin sisällön perusteella, ei yleisen tietämyksensä.

Kokeile kysyä: "Mitä ovat GitHub-mallit?" vs. "Millainen sää on?"

## Opas 4: Vastuullinen tekoäly

**Tiedosto:** `src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

### Mitä tämä esimerkki opettaa

Vastuullisen tekoälyn esimerkki korostaa turvallisuustoimenpiteiden tärkeyttä tekoälysovelluksissa. Se esittelee suodattimia, jotka tunnistavat haitallisia sisältöluokkia, kuten vihapuhetta, häirintää, itsensä vahingoittamista, seksuaalista sisältöä ja väkivaltaa. Esimerkki osoittaa, miten tuotantokäytössä olevien tekoälysovellusten tulisi käsitellä sisältöpolitiikan rikkomuksia asianmukaisesti.

### Keskeiset koodikäsitteet

#### 1. Turvallisuustestauskehys
```java
private void testPromptSafety(String prompt, String category) {
    try {
        // Attempt to get AI response
        ChatCompletions response = client.getChatCompletions(modelId, options);
        System.out.println("Response generated (content appears safe)");
        
    } catch (HttpResponseException e) {
        if (e.getResponse().getStatusCode() == 400) {
            System.out.println("[BLOCKED BY SAFETY FILTER]");
            System.out.println("This is GOOD - safety system working!");
        }
    }
}
```

#### 2. Testatut turvallisuuskategoriat
- Väkivalta/vahingoittamisohjeet
- Vihapuhe
- Yksityisyyden loukkaukset
- Lääketieteellinen väärä tieto
- Laittomat toiminnot

### Suorita esimerkki
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
```

### Mitä tapahtuu, kun suoritat sen

Ohjelma testaa erilaisia haitallisia kehotteita ja näyttää, miten AI-turvajärjestelmä:
1. **Estää vaaralliset pyynnöt** HTTP 400 -virheillä.
2. **Sallii turvallisen sisällön** normaalin generoinnin.
3. **Suojaa käyttäjiä** haitallisilta AI-tulosteilta.

## Yleiset mallit esimerkeissä

### Autentikointimalli
Kaikki esimerkit käyttävät tätä mallia autentikoitumiseen GitHub-malleihin:

```java
String pat = System.getenv("GITHUB_TOKEN");
TokenCredential credential = new StaticTokenCredential(pat);
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(credential)
    .buildClient();
```

### Virheenkäsittelymalli
```java
try {
    // AI operation
} catch (HttpResponseException e) {
    // Handle API errors (rate limits, safety filters)
} catch (Exception e) {
    // Handle general errors (network, parsing)
}
```

### Viestirakennemalli
```java
List<ChatRequestMessage> messages = List.of(
    new ChatRequestSystemMessage("Set AI behavior"),
    new ChatRequestUserMessage("User's actual request")
);
```

## Seuraavat askeleet

[Chapter 04: Practical samples](../04-PracticalSamples/README.md)

## Vianmääritys

### Yleiset ongelmat

**"GITHUB_TOKEN ei ole asetettu"**
- Varmista, että olet asettanut ympäristömuuttujan.
- Tarkista, että tunnuksellasi on `models:read`-oikeus.

**"Ei vastausta API:lta"**
- Tarkista internet-yhteytesi.
- Varmista, että tunnuksesi on voimassa.
- Tarkista, oletko saavuttanut käyttörajoitukset.

**Maven-kääntövirheet**
- Varmista, että sinulla on Java 21 tai uudempi.
- Suorita `mvn clean compile` päivittääksesi riippuvuudet.

**Vastuuvapauslauseke**:  
Tämä asiakirja on käännetty käyttämällä tekoälypohjaista käännöspalvelua [Co-op Translator](https://github.com/Azure/co-op-translator). Vaikka pyrimme tarkkuuteen, huomioithan, että automaattiset käännökset voivat sisältää virheitä tai epätarkkuuksia. Alkuperäinen asiakirja sen alkuperäisellä kielellä tulisi pitää ensisijaisena lähteenä. Kriittisen tiedon osalta suositellaan ammattimaista ihmiskäännöstä. Emme ole vastuussa väärinkäsityksistä tai virhetulkinnoista, jotka johtuvat tämän käännöksen käytöstä.