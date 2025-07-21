<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T19:12:04+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "fi"
}
-->
# Generatiivisen tekoälyn keskeiset tekniikat

>**Huom**: Tämä luku sisältää yksityiskohtaisen [**Opetusohjelman**](./TUTORIAL.md), joka opastaa sinut valmiiden esimerkkien suorittamisessa.

## Mitä opit
Tässä luvussa tarkastelemme neljää keskeistä generatiivisen tekoälyn tekniikkaa käytännön esimerkkien avulla:
- LLM-päätelmät ja keskusteluvirrat
- Funktioiden kutsuminen
- Retrieval-Augmented Generation (RAG)
- Vastuullisen tekoälyn turvallisuustoimenpiteet

## Sisällysluettelo

- [Mitä opit](../../../03-CoreGenerativeAITechniques)
- [Edellytykset](../../../03-CoreGenerativeAITechniques)
- [Aloittaminen](../../../03-CoreGenerativeAITechniques)
- [Esimerkkien yleiskatsaus](../../../03-CoreGenerativeAITechniques)
  - [1. LLM-päätelmät ja keskusteluvirrat](../../../03-CoreGenerativeAITechniques)
  - [2. Funktiot ja lisäosat LLM:ien kanssa](../../../03-CoreGenerativeAITechniques)
  - [3. Retrieval-Augmented Generation (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Vastuullisen tekoälyn turvallisuusnäytös](../../../03-CoreGenerativeAITechniques)
- [Yhteenveto](../../../03-CoreGenerativeAITechniques)
- [Seuraavat askeleet](../../../03-CoreGenerativeAITechniques)

## Edellytykset

- Suoritettu [Luku 2](../../../02-SetupDevEnvironment) -asennus

## Aloittaminen

1. **Siirry esimerkkeihin**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Aseta ympäristö**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Käännä ja suorita esimerkit**:  
```bash
   # Run completions example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
   
   # Run functions example  
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
   
   # Run RAG example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
   
   # Run responsible AI demo
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```  

## Esimerkkien yleiskatsaus

Esimerkit on järjestetty `examples/`-kansioon seuraavalla rakenteella:

```
examples/
├── src/main/java/com/example/genai/techniques/
│   ├── completions/
│   │   └── LLMCompletionsApp.java        # Basic completions 
│   ├── functions/
│   │   └── FunctionsApp.java             # Function calling examples
│   ├── rag/
│   │   └── SimpleReaderDemo.java         # Retrieval-Augmented Generation
│   └── responsibleai/
│       └── ResponsibleGithubModels.java  # Responsible AI safety demonstration
├── document.txt                          # Sample document for RAG example
└── pom.xml                               # Maven configuration
```

### 1. LLM-päätelmät ja keskusteluvirrat
**Tiedosto**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Opi rakentamaan keskustelevaa tekoälyä suoratoistovastausten ja keskusteluhistorian hallinnan avulla.

Tämä esimerkki esittelee:
- Yksinkertaisen tekstin täydentämisen järjestelmäkehotteilla
- Monivaiheiset keskustelut historian hallinnalla
- Interaktiiviset keskustelusessiot
- Parametrien konfigurointi (lämpötila, maksimimerkit)

### 2. Funktiot ja lisäosat LLM:ien kanssa
**Tiedosto**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Laajenna tekoälyn kykyjä antamalla malleille pääsy mukautettuihin funktioihin ja ulkoisiin API:hin.

Tämä esimerkki esittelee:
- Sääfunktion integrointi
- Laskinfunktion toteutus  
- Useita funktiokutsuja yhdessä keskustelussa
- Funktion määrittely JSON-skeemoilla

### 3. Retrieval-Augmented Generation (RAG)
**Tiedosto**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Opi yhdistämään tekoäly omiin dokumentteihisi ja tietolähteisiisi tarkkojen, kontekstuaalisten vastausten saamiseksi.

Tämä esimerkki esittelee:
- Dokumenttipohjaisen kysymys-vastausjärjestelmän Azure OpenAI SDK:lla
- RAG-mallin toteutus GitHub-malleilla

**Käyttö**: Kysy kysymyksiä `document.txt`-sisällöstä ja saa tekoälyn vastauksia vain kyseiseen kontekstiin perustuen.

### 4. Vastuullisen tekoälyn turvallisuusnäytös
**Tiedosto**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Saat esikatsauksen tekoälyn turvallisuustoimenpiteistä testaamalla GitHub-mallien sisällönsuodatusominaisuuksia.

Tämä esimerkki esittelee:
- Sisällön suodatus mahdollisesti haitallisille kehotteille
- Turvallisuusvastauksen käsittely sovelluksissa
- Erilaiset estettyjen sisältöjen kategoriat (väkivalta, vihapuhe, väärä tieto)
- Virheiden asianmukainen käsittely turvallisuusrikkomuksissa

> **Lisätietoja**: Tämä on vain johdanto vastuullisen tekoälyn käsitteisiin. Lisätietoja etiikasta, harhan lieventämisestä, yksityisyyden huomioimisesta ja vastuullisen tekoälyn viitekehyksistä löydät [Luku 5: Vastuullinen generatiivinen tekoäly](../05-ResponsibleGenAI/README.md).

## Yhteenveto

Tässä luvussa tutkittiin LLM-päätelmiä ja keskusteluvirtoja, toteutettiin funktiokutsuja tekoälyn kykyjen laajentamiseksi, luotiin Retrieval-Augmented Generation (RAG) -järjestelmä ja esiteltiin vastuullisen tekoälyn turvallisuustoimenpiteitä.

> **HUOM**: Syvenny aiheeseen tarjotun [**Opetusohjelman**](./TUTORIAL.md) avulla.

## Seuraavat askeleet

[Luku 4: Käytännön sovellukset ja projektit](../04-PracticalSamples/README.md)

**Vastuuvapauslauseke**:  
Tämä asiakirja on käännetty käyttämällä tekoälypohjaista käännöspalvelua [Co-op Translator](https://github.com/Azure/co-op-translator). Vaikka pyrimme tarkkuuteen, huomioithan, että automaattiset käännökset voivat sisältää virheitä tai epätarkkuuksia. Alkuperäinen asiakirja sen alkuperäisellä kielellä tulisi katsoa ensisijaiseksi lähteeksi. Kriittisen tiedon osalta suositellaan ammattimaista ihmiskäännöstä. Emme ole vastuussa väärinkäsityksistä tai virhetulkinnoista, jotka johtuvat tämän käännöksen käytöstä.