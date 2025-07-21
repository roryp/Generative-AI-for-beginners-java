<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "e00bbea0f95c611aa3bec676d23e8b43",
  "translation_date": "2025-07-21T21:06:25+00:00",
  "source_file": "02-SetupDevEnvironment/getting-started-azure-openai.md",
  "language_code": "sl"
}
-->
# Nastavitev razvojnega okolja za Azure OpenAI

> **Hitri začetek**: Ta vodič je namenjen nastavitvi Azure OpenAI. Za takojšen začetek z brezplačnimi modeli uporabite [GitHub Models with Codespaces](./README.md#quick-start-cloud).

Ta vodič vam bo pomagal nastaviti modele Azure AI Foundry za vaše Java AI aplikacije v tem tečaju.

## Kazalo

- [Pregled hitre nastavitve](../../../02-SetupDevEnvironment)
- [Korak 1: Ustvarite vire Azure AI Foundry](../../../02-SetupDevEnvironment)
  - [Ustvarite vozlišče in projekt](../../../02-SetupDevEnvironment)
  - [Namestite model GPT-4o-mini](../../../02-SetupDevEnvironment)
- [Korak 2: Ustvarite svoj Codespace](../../../02-SetupDevEnvironment)
- [Korak 3: Konfigurirajte svoje okolje](../../../02-SetupDevEnvironment)
- [Korak 4: Preizkusite svojo nastavitev](../../../02-SetupDevEnvironment)
- [Kaj sledi?](../../../02-SetupDevEnvironment)
- [Viri](../../../02-SetupDevEnvironment)
- [Dodatni viri](../../../02-SetupDevEnvironment)

## Pregled hitre nastavitve

1. Ustvarite vire Azure AI Foundry (vozlišče, projekt, model)
2. Ustvarite Codespace z razvojnim okoljem za Java
3. Konfigurirajte datoteko .env z Azure OpenAI poverilnicami
4. Preizkusite svojo nastavitev z vzorčnim projektom

## Korak 1: Ustvarite vire Azure AI Foundry

### Ustvarite vozlišče in projekt

1. Obiščite [Azure AI Foundry Portal](https://ai.azure.com/) in se prijavite
2. Kliknite **+ Create** → **New hub** (ali pojdite na **Management** → **All hubs** → **+ New hub**)
3. Konfigurirajte svoje vozlišče:
   - **Ime vozlišča**: npr. "MyAIHub"
   - **Naročnina**: Izberite svojo Azure naročnino
   - **Skupina virov**: Ustvarite novo ali izberite obstoječo
   - **Lokacija**: Izberite najbližjo lokacijo
   - **Račun za shranjevanje**: Uporabite privzeto ali konfigurirajte po meri
   - **Key vault**: Uporabite privzeto ali konfigurirajte po meri
   - Kliknite **Next** → **Review + create** → **Create**
4. Ko je vozlišče ustvarjeno, kliknite **+ New project** (ali **Create project** iz pregleda vozlišča)
   - **Ime projekta**: npr. "GenAIJava"
   - Kliknite **Create**

### Namestite model GPT-4o-mini

1. V svojem projektu pojdite na **Model catalog** in poiščite **gpt-4o-mini**
   - *Alternativa: Pojdite na **Deployments** → **+ Create deployment***
2. Kliknite **Deploy** na kartici modela gpt-4o-mini
3. Konfigurirajte namestitev:
   - **Ime namestitve**: "gpt-4o-mini"
   - **Različica modela**: Uporabite najnovejšo
   - **Vrsta namestitve**: Standard
4. Kliknite **Deploy**
5. Ko je model nameščen, pojdite na zavihek **Deployments** in kopirajte te vrednosti:
   - **Ime namestitve** (npr. "gpt-4o-mini")
   - **Ciljni URI** (npr. `https://your-hub-name.openai.azure.com/`) 
      > **Pomembno**: Kopirajte samo osnovni URL (npr. `https://myhub.openai.azure.com/`) in ne celotne poti do končne točke.
   - **Ključ** (iz razdelka Keys and Endpoint)

> **Še vedno imate težave?** Obiščite uradno [Azure AI Foundry Dokumentacijo](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

## Korak 2: Ustvarite svoj Codespace

1. Forkajte to repozitorij v svoj GitHub račun
   > **Opomba**: Če želite urediti osnovno konfiguracijo, si oglejte [Dev Container Configuration](../../../.devcontainer/devcontainer.json)
2. V svojem fork-anem repozitoriju kliknite **Code** → zavihek **Codespaces**
3. Kliknite **...** → **New with options...**
![ustvarjanje codespace z možnostmi](../../../translated_images/codespaces.9945ded8ceb431a58e8bee7f212e8c62b55733b7e302fd58194fadc95472fa3c.sl.png)
4. Izberite **Dev container configuration**: 
   - **Generative AI Java Development Environment**
5. Kliknite **Create codespace**

## Korak 3: Konfigurirajte svoje okolje

Ko je vaš Codespace pripravljen, nastavite svoje Azure OpenAI poverilnice:

1. **Pojdite do vzorčnega projekta iz korenskega repozitorija:**
   ```bash
   cd 02-SetupDevEnvironment/src/basic-chat-azure
   ```

2. **Ustvarite svojo datoteko .env:**
   ```bash
   cp .env.example .env
   ```

3. **Uredite datoteko .env z vašimi Azure OpenAI poverilnicami:**
   ```bash
   # Your Azure OpenAI API key (from Azure AI Foundry portal)
   AZURE_AI_KEY=your-actual-api-key-here
   
   # Your Azure OpenAI endpoint URL (e.g., https://myhub.openai.azure.com/)
   AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
   ```

   > **Varnostna opomba**: 
   > - Nikoli ne vključujte svoje datoteke `.env` v verzijsko kontrolo
   > - Datoteka `.env` je že vključena v `.gitignore`
   > - Svoje API ključe hranite varno in jih redno rotirajte

## Korak 4: Preizkusite svojo nastavitev

Zaženite vzorčno aplikacijo, da preizkusite povezavo z Azure OpenAI:

```bash
mvn clean spring-boot:run
```

Videti bi morali odgovor modela GPT-4o-mini!

> **Uporabniki VS Code**: Lahko pritisnete tudi `F5` v VS Code za zagon aplikacije. Konfiguracija zagona je že nastavljena za samodejno nalaganje vaše datoteke `.env`.

> **Celoten primer**: Oglejte si [End-to-End Azure OpenAI Example](./src/basic-chat-azure/README.md) za podrobna navodila in odpravljanje težav.

## Kaj sledi?

**Nastavitev je zaključena!** Zdaj imate:
- Azure OpenAI z nameščenim gpt-4o-mini
- Lokalno konfiguracijo datoteke .env
- Pripravljeno razvojno okolje za Java

**Nadaljujte na** [Poglavje 3: Osnovne tehnike generativne umetne inteligence](../03-CoreGenerativeAITechniques/README.md) in začnite graditi AI aplikacije!

## Viri

- [Azure AI Foundry Dokumentacija](https://learn.microsoft.com/azure/ai-services/)
- [Spring AI Azure OpenAI Dokumentacija](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI Java SDK](https://learn.microsoft.com/java/api/overview/azure/ai-openai-readme)

## Dodatni viri

- [Prenesite VS Code](https://code.visualstudio.com/Download)
- [Pridobite Docker Desktop](https://www.docker.com/products/docker-desktop)
- [Dev Container Configuration](../../../.devcontainer/devcontainer.json)

**Omejitev odgovornosti**:  
Ta dokument je bil preveden z uporabo storitve AI za prevajanje [Co-op Translator](https://github.com/Azure/co-op-translator). Čeprav si prizadevamo za natančnost, vas prosimo, da upoštevate, da lahko avtomatizirani prevodi vsebujejo napake ali netočnosti. Izvirni dokument v njegovem maternem jeziku je treba obravnavati kot avtoritativni vir. Za ključne informacije priporočamo profesionalni človeški prevod. Ne prevzemamo odgovornosti za morebitna nesporazumevanja ali napačne razlage, ki bi nastale zaradi uporabe tega prevoda.