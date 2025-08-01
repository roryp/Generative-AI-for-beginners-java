<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "79df2d245c12d6b8ad57148fd049f106",
  "translation_date": "2025-07-23T12:23:23+00:00",
  "source_file": "README.md",
  "language_code": "fi"
}
-->
# Generatiivinen AI aloittelijoille - Java-versio
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generatiivinen AI aloittelijoille - Java-versio](../../translated_images/beg-genai-series.61edc4a6b2cc54284fa2d70eda26dc0ca2669e26e49655b842ea799cd6e16d2a.fi.png)

> **NOTE: Pika-aloitus**: Koko kurssi voidaan suorittaa verkossa – ei vaadi paikallista asennusta!
1. Haarauta tämä arkisto GitHub-tilillesi
2. Klikkaa **Code** → **Codespaces**-välilehti → **...** → **New with options...**
3. Käytä oletusasetuksia – tämä valitsee kurssille luodun kehityskontin
4. Klikkaa **Create codespace**
5. Odota noin 2 minuuttia, että ympäristö on valmis
6. Siirry suoraan kohtaan [GitHub Models -tokenin luominen](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Monikielinen tuki

### Tuettu GitHub Actionin kautta (automaattinen ja aina ajan tasalla)

[French](../fr/README.md) | [Spanish](../es/README.md) | [German](../de/README.md) | [Russian](../ru/README.md) | [Arabic](../ar/README.md) | [Persian (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Hindi](../hi/README.md) | [Bengali](../bn/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Portuguese (Brazil)](../br/README.md) | [Italian](../it/README.md) | [Polish](../pl/README.md) | [Turkish](../tr/README.md) | [Greek](../el/README.md) | [Thai](../th/README.md) | [Swedish](../sv/README.md) | [Danish](../da/README.md) | [Norwegian](../no/README.md) | [Finnish](./README.md) | [Dutch](../nl/README.md) | [Hebrew](../he/README.md) | [Vietnamese](../vi/README.md) | [Indonesian](../id/README.md) | [Malay](../ms/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Swahili](../sw/README.md) | [Hungarian](../hu/README.md) | [Czech](../cs/README.md) | [Slovak](../sk/README.md) | [Romanian](../ro/README.md) | [Bulgarian](../bg/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Croatian](../hr/README.md) | [Slovenian](../sl/README.md) | [Ukrainian](../uk/README.md) | [Burmese (Myanmar)](../my/README.md)

## Kurssin rakenne ja oppimispolku

**Aikavaatimukset**: Ympäristön asennus kestää 2 minuuttia, ja käytännön harjoitukset vaativat 1–3 tuntia riippuen syventymisen tasosta.

### **Luku 1: Johdatus generatiiviseen AI:hin**
- **Keskeiset käsitteet**: Suurten kielimallien, tokenien, upotusten ja AI:n kyvykkyyksien ymmärtäminen
- **Java AI -ekosysteemi**: Katsaus Spring AI:hin ja OpenAI SDK:ihin
- **Model Context Protocol**: Johdatus MCP:hen ja sen rooliin AI-agenttien viestinnässä
- **Käytännön sovellukset**: Todelliset esimerkit, kuten chatbotit ja sisällön luominen
- **[→ Aloita luku 1](./01-IntroToGenAI/README.md)**

### **Luku 2: Kehitysympäristön asennus**
- **Monen palveluntarjoajan konfigurointi**: GitHub Models-, Azure OpenAI- ja OpenAI Java SDK -integraatioiden asennus
- **Spring Boot + Spring AI**: Parhaat käytännöt yritystason AI-sovellusten kehittämiseen
- **GitHub Models**: Ilmainen AI-mallien käyttö prototyyppien ja oppimisen tueksi (ei luottokorttia vaadita)
- **Kehitystyökalut**: Docker-kontit, VS Code ja GitHub Codespaces -konfigurointi
- **[→ Aloita luku 2](./02-SetupDevEnvironment/README.md)**

### **Luku 3: Generatiivisen AI:n ydintekniikat**
- **Prompt Engineering**: Tekniikat optimaalisten AI-mallivastausten saamiseksi
- **Upotukset ja vektorilaskenta**: Semanttisen haun ja samankaltaisuuden tunnistamisen toteutus
- **Retrieval-Augmented Generation (RAG)**: AI:n yhdistäminen omiin tietolähteisiin
- **Funktioiden kutsuminen**: AI:n kyvykkyyksien laajentaminen mukautetuilla työkaluilla ja laajennuksilla
- **[→ Aloita luku 3](./03-CoreGenerativeAITechniques/README.md)**

### **Luku 4: Käytännön sovellukset ja projektit**
- **Lemmikkitarinageneraattori** (`petstory/`): Luova sisällön tuottaminen GitHub Models -mallien avulla
- **Foundry Local Demo** (`foundrylocal/`): Paikallinen AI-mallien integrointi OpenAI Java SDK:lla
- **MCP-laskinpalvelu** (`mcp/calculator/`): Perustason Model Context Protocol -toteutus Spring AI:lla
- **[→ Aloita luku 4](./04-PracticalSamples/README.md)**

### **Luku 5: Vastuullinen AI-kehitys**
- **GitHub Models -turvallisuus**: Sisäänrakennettujen sisällönsuodatus- ja turvallisuusmekanismien testaaminen
- **Vastuullinen AI-demo**: Käytännön esimerkki AI-turvasuodattimien toiminnasta
- **Parhaat käytännöt**: Keskeiset ohjeet eettiseen AI-kehitykseen ja käyttöönottoon
- **[→ Aloita luku 5](./05-ResponsibleGenAI/README.md)**

## Lisäresurssit 

- [AI Agents For Beginners](https://github.com/microsoft/ai-agents-for-beginners)
- [Generative AI for Beginners using .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generative AI for Beginners using JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generative AI for Beginners](https://github.com/microsoft/generative-ai-for-beginners)
- [ML for Beginners](https://aka.ms/ml-beginners)
- [Data Science for Beginners](https://aka.ms/datascience-beginners)
- [AI for Beginners](https://aka.ms/ai-beginners)
- [Cybersecurity for Beginners](https://github.com/microsoft/Security-101)
- [Web Dev for Beginners](https://aka.ms/webdev-beginners)
- [IoT for Beginners](https://aka.ms/iot-beginners)
- [XR Development for Beginners](https://github.com/microsoft/xr-development-for-beginners)
- [Mastering GitHub Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI)
- [Mastering GitHub Copilot for C#/.NET Developers](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Choose Your Own Copilot Adventure](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App with Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)

**Vastuuvapauslauseke**:  
Tämä asiakirja on käännetty käyttämällä tekoälypohjaista käännöspalvelua [Co-op Translator](https://github.com/Azure/co-op-translator). Vaikka pyrimme tarkkuuteen, huomioithan, että automaattiset käännökset voivat sisältää virheitä tai epätarkkuuksia. Alkuperäinen asiakirja sen alkuperäisellä kielellä tulisi pitää ensisijaisena lähteenä. Kriittisen tiedon osalta suositellaan ammattimaista ihmiskäännöstä. Emme ole vastuussa väärinkäsityksistä tai virhetulkinnoista, jotka johtuvat tämän käännöksen käytöstä.