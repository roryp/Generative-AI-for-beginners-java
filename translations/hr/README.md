<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "79df2d245c12d6b8ad57148fd049f106",
  "translation_date": "2025-07-23T12:39:40+00:00",
  "source_file": "README.md",
  "language_code": "hr"
}
-->
# Generativna umjetna inteligencija za početnike - Java izdanje
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generativna umjetna inteligencija za početnike - Java izdanje](../../translated_images/beg-genai-series.61edc4a6b2cc54284fa2d70eda26dc0ca2669e26e49655b842ea799cd6e16d2a.hr.png)

> **NOTE: Brzi početak**: Cijeli tečaj možete završiti online - nije potrebna lokalna instalacija!
1. Forkajte ovaj repozitorij na svoj GitHub račun
2. Kliknite **Code** → kartica **Codespaces** → **...** → **New with options...**
3. Koristite zadane postavke – ovo će odabrati razvojni kontejner kreiran za ovaj tečaj
4. Kliknite **Create codespace**
5. Pričekajte ~2 minute dok okruženje ne bude spremno
6. Odmah prijeđite na [Kreiranje vašeg GitHub Models Tokena](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Podrška za više jezika

### Podržano putem GitHub Action (Automatizirano i uvijek ažurirano)

[Francuski](../fr/README.md) | [Španjolski](../es/README.md) | [Njemački](../de/README.md) | [Ruski](../ru/README.md) | [Arapski](../ar/README.md) | [Perzijski (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Kineski (pojednostavljeni)](../zh/README.md) | [Kineski (tradicionalni, Makao)](../mo/README.md) | [Kineski (tradicionalni, Hong Kong)](../hk/README.md) | [Kineski (tradicionalni, Tajvan)](../tw/README.md) | [Japanski](../ja/README.md) | [Korejski](../ko/README.md) | [Hindski](../hi/README.md) | [Bengalski](../bn/README.md) | [Marathi](../mr/README.md) | [Nepalski](../ne/README.md) | [Pandžapski (Gurmukhi)](../pa/README.md) | [Portugalski (Portugal)](../pt/README.md) | [Portugalski (Brazil)](../br/README.md) | [Talijanski](../it/README.md) | [Poljski](../pl/README.md) | [Turski](../tr/README.md) | [Grčki](../el/README.md) | [Tajlandski](../th/README.md) | [Švedski](../sv/README.md) | [Danski](../da/README.md) | [Norveški](../no/README.md) | [Finski](../fi/README.md) | [Nizozemski](../nl/README.md) | [Hebrejski](../he/README.md) | [Vijetnamski](../vi/README.md) | [Indonezijski](../id/README.md) | [Malajski](../ms/README.md) | [Tagalog (Filipinski)](../tl/README.md) | [Svahili](../sw/README.md) | [Mađarski](../hu/README.md) | [Češki](../cs/README.md) | [Slovački](../sk/README.md) | [Rumunjski](../ro/README.md) | [Bugarski](../bg/README.md) | [Srpski (ćirilica)](../sr/README.md) | [Hrvatski](./README.md) | [Slovenski](../sl/README.md) | [Ukrajinski](../uk/README.md) | [Burmanski (Mjanmar)](../my/README.md)

## Struktura tečaja i put učenja

**Vrijeme potrebno**: Postavljanje okruženja traje 2 minute, dok praktični vodiči zahtijevaju 1-3 sata svaki, ovisno o dubini istraživanja.

### **Poglavlje 1: Uvod u generativnu umjetnu inteligenciju**
- **Osnovni koncepti**: Razumijevanje velikih jezičnih modela, tokena, ugradnji i AI mogućnosti
- **Java AI ekosustav**: Pregled Spring AI i OpenAI SDK-ova
- **Protokol konteksta modela**: Uvod u MCP i njegovu ulogu u komunikaciji AI agenata
- **Praktične primjene**: Primjeri iz stvarnog svijeta, uključujući chatbotove i generiranje sadržaja
- **[→ Započnite poglavlje 1](./01-IntroToGenAI/README.md)**

### **Poglavlje 2: Postavljanje razvojnog okruženja**
- **Konfiguracija za više pružatelja usluga**: Postavljanje GitHub Models, Azure OpenAI i OpenAI Java SDK integracija
- **Spring Boot + Spring AI**: Najbolje prakse za razvoj AI aplikacija u poduzećima
- **GitHub Models**: Besplatan pristup AI modelima za prototipiranje i učenje (nije potrebna kreditna kartica)
- **Razvojni alati**: Konfiguracija Docker kontejnera, VS Code-a i GitHub Codespaces-a
- **[→ Započnite poglavlje 2](./02-SetupDevEnvironment/README.md)**

### **Poglavlje 3: Osnovne tehnike generativne umjetne inteligencije**
- **Inženjering upita**: Tehnike za optimalne odgovore AI modela
- **Ugradnje i vektorske operacije**: Implementacija semantičkog pretraživanja i podudaranja sličnosti
- **Generacija uz podršku pretraživanja (RAG)**: Kombiniranje AI-a s vlastitim izvorima podataka
- **Pozivanje funkcija**: Proširenje AI mogućnosti prilagođenim alatima i dodacima
- **[→ Započnite poglavlje 3](./03-CoreGenerativeAITechniques/README.md)**

### **Poglavlje 4: Praktične primjene i projekti**
- **Generator priča o kućnim ljubimcima** (`petstory/`): Generiranje kreativnog sadržaja s GitHub Models
- **Foundry lokalna demonstracija** (`foundrylocal/`): Integracija lokalnih AI modela s OpenAI Java SDK-om
- **MCP kalkulator usluga** (`mcp/calculator/`): Osnovna implementacija Protokola konteksta modela sa Spring AI
- **[→ Započnite poglavlje 4](./04-PracticalSamples/README.md)**

### **Poglavlje 5: Odgovorni razvoj umjetne inteligencije**
- **Sigurnost GitHub Modelsa**: Testiranje ugrađenih mehanizama za filtriranje sadržaja i sigurnost
- **Demonstracija odgovorne umjetne inteligencije**: Praktičan primjer koji pokazuje kako sigurnosni filtri AI-a funkcioniraju u praksi
- **Najbolje prakse**: Ključne smjernice za etički razvoj i implementaciju umjetne inteligencije
- **[→ Započnite poglavlje 5](./05-ResponsibleGenAI/README.md)**

## Dodatni resursi

- [AI agenti za početnike](https://github.com/microsoft/ai-agents-for-beginners)
- [Generativna umjetna inteligencija za početnike koristeći .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generativna umjetna inteligencija za početnike koristeći JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generativna umjetna inteligencija za početnike](https://github.com/microsoft/generative-ai-for-beginners)
- [Strojno učenje za početnike](https://aka.ms/ml-beginners)
- [Znanost o podacima za početnike](https://aka.ms/datascience-beginners)
- [Umjetna inteligencija za početnike](https://aka.ms/ai-beginners)
- [Kibernetička sigurnost za početnike](https://github.com/microsoft/Security-101)
- [Web razvoj za početnike](https://aka.ms/webdev-beginners)
- [IoT za početnike](https://aka.ms/iot-beginners)
- [XR razvoj za početnike](https://github.com/microsoft/xr-development-for-beginners)
- [Ovladavanje GitHub Copilotom za AI programiranje u paru](https://aka.ms/GitHubCopilotAI)
- [Ovladavanje GitHub Copilotom za C#/.NET programere](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Odaberite svoju vlastitu Copilot avanturu](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat aplikacija s Azure AI uslugama](https://github.com/Azure-Samples/azure-search-openai-demo-java)

**Odricanje od odgovornosti**:  
Ovaj dokument je preveden pomoću AI usluge za prevođenje [Co-op Translator](https://github.com/Azure/co-op-translator). Iako nastojimo osigurati točnost, imajte na umu da automatski prijevodi mogu sadržavati pogreške ili netočnosti. Izvorni dokument na izvornom jeziku treba smatrati autoritativnim izvorom. Za kritične informacije preporučuje se profesionalni prijevod od strane stručnjaka. Ne preuzimamo odgovornost za nesporazume ili pogrešna tumačenja koja mogu proizaći iz korištenja ovog prijevoda.