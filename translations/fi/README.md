<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:29:09+00:00",
  "source_file": "README.md",
  "language_code": "fi"
}
-->
# Generatiivinen tekoäly aloittelijoille - Java-versio
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generatiivinen tekoäly aloittelijoille - Java-versio](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.fi.png)

**Aikataulu**: Koko työpaja voidaan suorittaa verkossa ilman paikallista asennusta. Ympäristön asennus kestää 2 minuuttia, ja esimerkkien tutkimiseen kuluu 1–3 tuntia riippuen tutkimisen syvyydestä.

> **Pika-aloitus** 

1. Haarauta tämä arkisto GitHub-tilillesi
2. Klikkaa **Code** → **Codespaces**-välilehti → **...** → **New with options...**
3. Käytä oletusasetuksia – tämä valitsee tämän kurssin kehityskontin
4. Klikkaa **Create codespace**
5. Odota noin 2 minuuttia, että ympäristö on valmis
6. Siirry suoraan [Ensimmäiseen esimerkkiin](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Monikielinen tuki

### Tuettu GitHub Actionin kautta (automaattinen ja aina ajan tasalla)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabia](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgaria](../bg/README.md) | [Burma (Myanmar)](../my/README.md) | [Kiina (yksinkertaistettu)](../zh/README.md) | [Kiina (perinteinen, Hongkong)](../hk/README.md) | [Kiina (perinteinen, Macao)](../mo/README.md) | [Kiina (perinteinen, Taiwan)](../tw/README.md) | [Kroatia](../hr/README.md) | [Tšekki](../cs/README.md) | [Tanska](../da/README.md) | [Hollanti](../nl/README.md) | [Viro](../et/README.md) | [Suomi](./README.md) | [Ranska](../fr/README.md) | [Saksa](../de/README.md) | [Kreikka](../el/README.md) | [Heprea](../he/README.md) | [Hindi](../hi/README.md) | [Unkari](../hu/README.md) | [Indonesia](../id/README.md) | [Italia](../it/README.md) | [Japani](../ja/README.md) | [Korea](../ko/README.md) | [Liettua](../lt/README.md) | [Malaiji](../ms/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Norja](../no/README.md) | [Persia (farsi)](../fa/README.md) | [Puola](../pl/README.md) | [Portugali (Brasilia)](../br/README.md) | [Portugali (Portugali)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romania](../ro/README.md) | [Venäjä](../ru/README.md) | [Serbia (kyrillinen)](../sr/README.md) | [Slovakki](../sk/README.md) | [Sloveeni](../sl/README.md) | [Espanja](../es/README.md) | [Swahili](../sw/README.md) | [Ruotsi](../sv/README.md) | [Tagalog (filippiini)](../tl/README.md) | [Tamili](../ta/README.md) | [Thai](../th/README.md) | [Turkki](../tr/README.md) | [Ukraina](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnam](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Kurssin rakenne ja oppimispolku

### **Luku 1: Johdatus generatiiviseen tekoälyyn**
- **Peruskäsitteet**: Suurten kielimallien, tokenien, upotusten ja tekoälyominaisuuksien ymmärtäminen
- **Java AI -ekosysteemi**: Katsaus Spring AI- ja OpenAI-SDK:ihin
- **Model Context Protocol**: Johdatus MCP:hen ja sen rooliin tekoälyagenttien viestinnässä
- **Käytännön sovellukset**: Reaaliaikaisia esimerkkejä, kuten chatbotit ja sisällöntuotanto
- **[→ Aloita luku 1](./01-IntroToGenAI/README.md)**

### **Luku 2: Kehitysympäristön asennus**
- **Monipalveluntarjoajan konfigurointi**: GitHub-mallien, Azure OpenAI:n ja OpenAI Java SDK:n integrointi
- **Spring Boot + Spring AI**: Parhaat käytännöt yritystason tekoälysovellusten kehittämiseen
- **GitHub-mallit**: Ilmainen tekoälymallien käyttö prototyyppien ja oppimisen tueksi (ei luottokorttia vaadita)
- **Kehitystyökalut**: Docker-kontit, VS Code ja GitHub Codespaces -konfigurointi
- **[→ Aloita luku 2](./02-SetupDevEnvironment/README.md)**

### **Luku 3: Generatiivisen tekoälyn ydintekniikat**
- **Prompt Engineering**: Tekniikoita optimaalisten tekoälymallivastausten saamiseksi
- **Upotukset ja vektorilaskenta**: Semanttisen haun ja samankaltaisuusvertailun toteuttaminen
- **Retrieval-Augmented Generation (RAG)**: Tekoälyn yhdistäminen omiin tietolähteisiin
- **Funktiokutsut**: Tekoälyn laajentaminen mukautetuilla työkaluilla ja lisäosilla
- **[→ Aloita luku 3](./03-CoreGenerativeAITechniques/README.md)**

### **Luku 4: Käytännön sovellukset ja projektit**
- **Lemmikkitarinageneraattori** (`petstory/`): Luovan sisällön tuottaminen GitHub-malleilla
- **Foundry Local Demo** (`foundrylocal/`): Paikallisen tekoälymallin integrointi OpenAI Java SDK:lla
- **MCP-laskinpalvelu** (`calculator/`): Perus Model Context Protocol -toteutus Spring AI:lla
- **[→ Aloita luku 4](./04-PracticalSamples/README.md)**

### **Luku 5: Vastuullinen tekoälykehitys**
- **GitHub-mallien turvallisuus**: Sisäänrakennettujen sisällönsuodatus- ja turvallisuusmekanismien testaaminen (kovat estot ja pehmeät hylkäykset)
- **Vastuullisen tekoälyn demo**: Käytännön esimerkki siitä, miten modernit tekoälyn turvallisuusjärjestelmät toimivat
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

Jos jäät jumiin tai sinulla on kysyttävää tekoälysovellusten rakentamisesta, liity:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Jos sinulla on tuotepalautetta tai virheitä rakentamisen aikana, käy:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Vastuuvapauslauseke**:  
Tämä asiakirja on käännetty käyttämällä tekoälypohjaista käännöspalvelua [Co-op Translator](https://github.com/Azure/co-op-translator). Vaikka pyrimme tarkkuuteen, huomioithan, että automaattiset käännökset voivat sisältää virheitä tai epätarkkuuksia. Alkuperäinen asiakirja sen alkuperäisellä kielellä tulisi pitää ensisijaisena lähteenä. Kriittisen tiedon osalta suositellaan ammattimaista ihmiskäännöstä. Emme ole vastuussa väärinkäsityksistä tai virhetulkinnoista, jotka johtuvat tämän käännöksen käytöstä.