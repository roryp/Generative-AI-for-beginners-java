<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:35:15+00:00",
  "source_file": "README.md",
  "language_code": "hr"
}
-->
# Generativna umjetna inteligencija za početnike - Java izdanje
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generativna umjetna inteligencija za početnike - Java izdanje](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.hr.png)

**Vrijeme potrebno**: Cijeli radionica može se završiti online bez lokalne instalacije. Postavljanje okruženja traje 2 minute, dok istraživanje primjera zahtijeva 1-3 sata, ovisno o dubini istraživanja.

> **Brzi početak**

1. Forkajte ovaj repozitorij na svoj GitHub račun
2. Kliknite **Code** → kartica **Codespaces** → **...** → **New with options...**
3. Koristite zadane postavke – ovo će odabrati razvojni kontejner kreiran za ovaj tečaj
4. Kliknite **Create codespace**
5. Pričekajte ~2 minute da okruženje bude spremno
6. Odmah krenite na [Prvi primjer](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Podrška za više jezika

### Podržano putem GitHub Action (Automatizirano i uvijek ažurirano)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arapski](../ar/README.md) | [Bengalski](../bn/README.md) | [Bugarski](../bg/README.md) | [Burmanski (Mjanmar)](../my/README.md) | [Kineski (pojednostavljeni)](../zh/README.md) | [Kineski (tradicionalni, Hong Kong)](../hk/README.md) | [Kineski (tradicionalni, Macau)](../mo/README.md) | [Kineski (tradicionalni, Tajvan)](../tw/README.md) | [Hrvatski](./README.md) | [Češki](../cs/README.md) | [Danski](../da/README.md) | [Nizozemski](../nl/README.md) | [Estonski](../et/README.md) | [Finski](../fi/README.md) | [Francuski](../fr/README.md) | [Njemački](../de/README.md) | [Grčki](../el/README.md) | [Hebrejski](../he/README.md) | [Hindski](../hi/README.md) | [Mađarski](../hu/README.md) | [Indonezijski](../id/README.md) | [Talijanski](../it/README.md) | [Japanski](../ja/README.md) | [Korejski](../ko/README.md) | [Litvanski](../lt/README.md) | [Malajski](../ms/README.md) | [Marathi](../mr/README.md) | [Nepalski](../ne/README.md) | [Norveški](../no/README.md) | [Perzijski (Farsi)](../fa/README.md) | [Poljski](../pl/README.md) | [Portugalski (Brazil)](../br/README.md) | [Portugalski (Portugal)](../pt/README.md) | [Pandžapski (Gurmukhi)](../pa/README.md) | [Rumunjski](../ro/README.md) | [Ruski](../ru/README.md) | [Srpski (ćirilica)](../sr/README.md) | [Slovački](../sk/README.md) | [Slovenski](../sl/README.md) | [Španjolski](../es/README.md) | [Svahili](../sw/README.md) | [Švedski](../sv/README.md) | [Tagalog (Filipinski)](../tl/README.md) | [Tamilski](../ta/README.md) | [Tajlandski](../th/README.md) | [Turski](../tr/README.md) | [Ukrajinski](../uk/README.md) | [Urdu](../ur/README.md) | [Vijetnamski](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Struktura tečaja i put učenja

### **Poglavlje 1: Uvod u generativnu umjetnu inteligenciju**
- **Osnovni pojmovi**: Razumijevanje velikih jezičnih modela, tokena, ugrađivanja i AI sposobnosti
- **Java AI ekosustav**: Pregled Spring AI i OpenAI SDK-ova
- **Protokol konteksta modela**: Uvod u MCP i njegovu ulogu u komunikaciji AI agenata
- **Praktične primjene**: Primjeri iz stvarnog svijeta, uključujući chatbotove i generiranje sadržaja
- **[→ Započni Poglavlje 1](./01-IntroToGenAI/README.md)**

### **Poglavlje 2: Postavljanje razvojnog okruženja**
- **Konfiguracija za više pružatelja usluga**: Postavljanje GitHub modela, Azure OpenAI i OpenAI Java SDK integracija
- **Spring Boot + Spring AI**: Najbolje prakse za razvoj AI aplikacija u poduzećima
- **GitHub modeli**: Besplatan pristup AI modelima za prototipiranje i učenje (nije potrebna kreditna kartica)
- **Razvojni alati**: Konfiguracija Docker kontejnera, VS Code-a i GitHub Codespaces-a
- **[→ Započni Poglavlje 2](./02-SetupDevEnvironment/README.md)**

### **Poglavlje 3: Osnovne tehnike generativne umjetne inteligencije**
- **Inženjering upita**: Tehnike za optimalne odgovore AI modela
- **Ugrađivanja i vektorske operacije**: Implementacija semantičkog pretraživanja i podudaranja sličnosti
- **Generacija uz pomoć pretraživanja (RAG)**: Kombiniranje AI-a s vlastitim izvorima podataka
- **Pozivanje funkcija**: Proširenje AI sposobnosti prilagođenim alatima i dodacima
- **[→ Započni Poglavlje 3](./03-CoreGenerativeAITechniques/README.md)**

### **Poglavlje 4: Praktične primjene i projekti**
- **Generator priča o kućnim ljubimcima** (`petstory/`): Kreativno generiranje sadržaja s GitHub modelima
- **Foundry lokalna demonstracija** (`foundrylocal/`): Integracija lokalnih AI modela s OpenAI Java SDK-om
- **MCP kalkulator usluga** (`calculator/`): Osnovna implementacija protokola konteksta modela sa Spring AI
- **[→ Započni Poglavlje 4](./04-PracticalSamples/README.md)**

### **Poglavlje 5: Razvoj odgovorne umjetne inteligencije**
- **Sigurnost GitHub modela**: Testiranje ugrađenih mehanizama za filtriranje sadržaja i sigurnosnih sustava (čvrste blokade i mekana odbijanja)
- **Demonstracija odgovorne AI**: Praktični primjer koji pokazuje kako moderni AI sigurnosni sustavi funkcioniraju
- **Najbolje prakse**: Ključne smjernice za etički razvoj i implementaciju AI-a
- **[→ Započni Poglavlje 5](./05-ResponsibleGenAI/README.md)**

## Dodatni resursi

- [Edge AI za početnike](https://github.com/microsoft/edgeai-for-beginners)
- [MCP za početnike](https://github.com/microsoft/mcp-for-beginners)
- [AI agenti za početnike](https://github.com/microsoft/ai-agents-for-beginners)
- [Generativna umjetna inteligencija za početnike koristeći .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generativna umjetna inteligencija za početnike koristeći JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generativna umjetna inteligencija za početnike](https://github.com/microsoft/generative-ai-for-beginners)
- [Strojno učenje za početnike](https://aka.ms/ml-beginners)
- [Data Science za početnike](https://aka.ms/datascience-beginners)
- [AI za početnike](https://aka.ms/ai-beginners)
- [Kibernetička sigurnost za početnike](https://github.com/microsoft/Security-101)
- [Web razvoj za početnike](https://aka.ms/webdev-beginners)
- [IoT za početnike](https://aka.ms/iot-beginners)
- [XR razvoj za početnike](https://github.com/microsoft/xr-development-for-beginners)
- [Ovladavanje GitHub Copilotom za AI programiranje u paru](https://aka.ms/GitHubCopilotAI)
- [Ovladavanje GitHub Copilotom za C#/.NET programere](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Izaberi svoju Copilot avanturu](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat aplikacija s Azure AI uslugama](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Dobivanje pomoći

Ako zapnete ili imate pitanja o izradi AI aplikacija, pridružite se:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Ako imate povratne informacije o proizvodu ili greške tijekom izrade, posjetite:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Izjava o odricanju odgovornosti**:  
Ovaj dokument je preveden pomoću AI usluge za prevođenje [Co-op Translator](https://github.com/Azure/co-op-translator). Iako nastojimo osigurati točnost, imajte na umu da automatski prijevodi mogu sadržavati pogreške ili netočnosti. Izvorni dokument na izvornom jeziku treba smatrati autoritativnim izvorom. Za ključne informacije preporučuje se profesionalni prijevod od strane ljudskog prevoditelja. Ne preuzimamo odgovornost za nesporazume ili pogrešna tumačenja koja mogu proizaći iz korištenja ovog prijevoda.