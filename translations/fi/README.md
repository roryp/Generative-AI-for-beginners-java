<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "4d04ae8088f6a3c3fcbab18cbdfe4002",
  "translation_date": "2025-10-03T08:14:24+00:00",
  "source_file": "README.md",
  "language_code": "fi"
}
-->
# Generatiivinen tekoäly aloittelijoille - Java-versio
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generatiivinen tekoäly aloittelijoille - Java-versio](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.fi.png)

**Aikavaatimukset**: Koko työpaja voidaan suorittaa verkossa ilman paikallista asennusta. Ympäristön asennus vie 2 minuuttia, ja esimerkkien tutkiminen kestää 1–3 tuntia riippuen tutkimuksen syvyydestä.

> **Pikakäynnistys**

1. Haaroita tämä arkisto GitHub-tilillesi
2. Klikkaa **Code** → **Codespaces**-välilehti → **...** → **New with options...**
3. Käytä oletusasetuksia – tämä valitsee kurssille luodun kehityskontin
4. Klikkaa **Create codespace**
5. Odota noin 2 minuuttia, että ympäristö on valmis
6. Siirry suoraan [Ensimmäiseen esimerkkiin](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Monikielinen tuki

### Tuettu GitHub Actionin kautta (automaattinen ja aina ajan tasalla)

[French](../fr/README.md) | [Spanish](../es/README.md) | [German](../de/README.md) | [Russian](../ru/README.md) | [Arabic](../ar/README.md) | [Persian (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Hindi](../hi/README.md) | [Bengali](../bn/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Portuguese (Brazil)](../br/README.md) | [Italian](../it/README.md) | [Polish](../pl/README.md) | [Turkish](../tr/README.md) | [Greek](../el/README.md) | [Thai](../th/README.md) | [Swedish](../sv/README.md) | [Danish](../da/README.md) | [Norwegian](../no/README.md) | [Finnish](./README.md) | [Dutch](../nl/README.md) | [Hebrew](../he/README.md) | [Vietnamese](../vi/README.md) | [Indonesian](../id/README.md) | [Malay](../ms/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Swahili](../sw/README.md) | [Hungarian](../hu/README.md) | [Czech](../cs/README.md) | [Slovak](../sk/README.md) | [Romanian](../ro/README.md) | [Bulgarian](../bg/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Croatian](../hr/README.md) | [Slovenian](../sl/README.md) | [Ukrainian](../uk/README.md) | [Burmese (Myanmar)](../my/README.md)

## Kurssin rakenne ja oppimispolku

### **Luku 1: Johdatus generatiiviseen tekoälyyn**
- **Keskeiset käsitteet**: Suurten kielimallien, tokenien, upotusten ja tekoälyn kykyjen ymmärtäminen
- **Java AI -ekosysteemi**: Katsaus Spring AI- ja OpenAI SDK:ihin
- **Model Context Protocol**: Johdatus MCP:hen ja sen rooliin tekoälyagenttien viestinnässä
- **Käytännön sovellukset**: Todelliset esimerkit, kuten chatbotit ja sisällön luominen
- **[→ Aloita luku 1](./01-IntroToGenAI/README.md)**

### **Luku 2: Kehitysympäristön asennus**
- **Monipalveluntarjoajan konfigurointi**: GitHub Models-, Azure OpenAI- ja OpenAI Java SDK -integraatioiden asennus
- **Spring Boot + Spring AI**: Parhaat käytännöt yritystason tekoälysovellusten kehittämiseen
- **GitHub Models**: Ilmainen tekoälymallien käyttö prototyyppien ja oppimisen tueksi (ei luottokorttia vaadita)
- **Kehitystyökalut**: Docker-kontit, VS Code ja GitHub Codespaces -konfigurointi
- **[→ Aloita luku 2](./02-SetupDevEnvironment/README.md)**

### **Luku 3: Generatiivisen tekoälyn ydintekniikat**
- **Prompt Engineering**: Tekniikat optimaalisten tekoälymallivastausten saamiseksi
- **Upotukset ja vektoritoiminnot**: Semanttisen haun ja samankaltaisuuden vertailun toteuttaminen
- **Retrieval-Augmented Generation (RAG)**: Tekoälyn yhdistäminen omiin tietolähteisiin
- **Toimintojen kutsuminen**: Tekoälyn laajentaminen mukautetuilla työkaluilla ja laajennuksilla
- **[→ Aloita luku 3](./03-CoreGenerativeAITechniques/README.md)**

### **Luku 4: Käytännön sovellukset ja projektit**
- **Lemmikkitarinageneraattori** (`petstory/`): Luova sisällön luominen GitHub Models -malleilla
- **Foundry Local Demo** (`foundrylocal/`): Paikallisen tekoälymallin integrointi OpenAI Java SDK:lla
- **MCP-laskinpalvelu** (`calculator/`): Perus Model Context Protocol -toteutus Spring AI:lla
- **[→ Aloita luku 4](./04-PracticalSamples/README.md)**

### **Luku 5: Vastuullinen tekoälyn kehitys**
- **GitHub Models -turvallisuus**: Sisäänrakennetun sisällön suodatuksen ja turvallisuusmekanismien testaaminen (kovat estot ja pehmeät kieltäytymiset)
- **Vastuullinen tekoälydemo**: Käytännön esimerkki siitä, miten modernit tekoälyn turvallisuusjärjestelmät toimivat
- **Parhaat käytännöt**: Keskeiset ohjeet eettiseen tekoälyn kehittämiseen ja käyttöönottoon
- **[→ Aloita luku 5](./05-ResponsibleGenAI/README.md)**

## Lisäresurssit

- [Edge AI for Beginners](https://github.com/microsoft/edgeai-for-beginners)
- [MCP For Beginners](https://github.com/microsoft/mcp-for-beginners)
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

## Apua saatavilla

Jos jäät jumiin tai sinulla on kysymyksiä tekoälysovellusten rakentamisesta, liity:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Jos sinulla on tuotepalautetta tai virheitä rakentamisen aikana, vieraile:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Vastuuvapauslauseke**:  
Tämä asiakirja on käännetty käyttämällä tekoälypohjaista käännöspalvelua [Co-op Translator](https://github.com/Azure/co-op-translator). Vaikka pyrimme tarkkuuteen, huomioithan, että automaattiset käännökset voivat sisältää virheitä tai epätarkkuuksia. Alkuperäistä asiakirjaa sen alkuperäisellä kielellä tulisi pitää ensisijaisena lähteenä. Kriittisen tiedon osalta suositellaan ammattimaista ihmiskäännöstä. Emme ole vastuussa väärinkäsityksistä tai virhetulkinnoista, jotka johtuvat tämän käännöksen käytöstä.