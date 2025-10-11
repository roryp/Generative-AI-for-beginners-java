<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:33:50+00:00",
  "source_file": "README.md",
  "language_code": "ro"
}
-->
# Inteligență Artificială Generativă pentru Începători - Ediția Java
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Inteligență Artificială Generativă pentru Începători - Ediția Java](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.ro.png)

**Durata estimată**: Atelierul poate fi finalizat online fără configurare locală. Configurarea mediului durează 2 minute, iar explorarea exemplelor necesită între 1-3 ore, în funcție de profunzimea explorării.

> **Start Rapid**

1. Clonează acest depozit în contul tău GitHub
2. Click pe **Code** → fila **Codespaces** → **...** → **New with options...**
3. Folosește setările implicite – acestea vor selecta containerul de dezvoltare creat pentru acest curs
4. Click pe **Create codespace**
5. Așteaptă ~2 minute pentru ca mediul să fie gata
6. Treci direct la [Primul exemplu](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Suport Multi-Limbă

### Suportat prin GitHub Action (Automat & Mereu Actualizat)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabă](../ar/README.md) | [Bengaleză](../bn/README.md) | [Bulgară](../bg/README.md) | [Birmaneză (Myanmar)](../my/README.md) | [Chineză (Simplificată)](../zh/README.md) | [Chineză (Tradițională, Hong Kong)](../hk/README.md) | [Chineză (Tradițională, Macau)](../mo/README.md) | [Chineză (Tradițională, Taiwan)](../tw/README.md) | [Croată](../hr/README.md) | [Cehă](../cs/README.md) | [Daneză](../da/README.md) | [Olandeză](../nl/README.md) | [Estonă](../et/README.md) | [Finlandeză](../fi/README.md) | [Franceză](../fr/README.md) | [Germană](../de/README.md) | [Greacă](../el/README.md) | [Ebraică](../he/README.md) | [Hindi](../hi/README.md) | [Maghiară](../hu/README.md) | [Indoneziană](../id/README.md) | [Italiană](../it/README.md) | [Japoneză](../ja/README.md) | [Coreeană](../ko/README.md) | [Lituaniană](../lt/README.md) | [Malayeză](../ms/README.md) | [Marathi](../mr/README.md) | [Nepaleză](../ne/README.md) | [Norvegiană](../no/README.md) | [Persană (Farsi)](../fa/README.md) | [Poloneză](../pl/README.md) | [Portugheză (Brazilia)](../br/README.md) | [Portugheză (Portugalia)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Română](./README.md) | [Rusă](../ru/README.md) | [Sârbă (Chirilică)](../sr/README.md) | [Slovacă](../sk/README.md) | [Slovenă](../sl/README.md) | [Spaniolă](../es/README.md) | [Swahili](../sw/README.md) | [Suedeză](../sv/README.md) | [Tagalog (Filipineză)](../tl/README.md) | [Tamil](../ta/README.md) | [Thailandeză](../th/README.md) | [Turcă](../tr/README.md) | [Ucraineană](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnameză](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Structura Cursului & Parcursul de Învățare

### **Capitolul 1: Introducere în Inteligența Artificială Generativă**
- **Concepte de bază**: Înțelegerea modelelor lingvistice mari, token-urilor, embedding-urilor și capacităților AI
- **Ecosistemul AI în Java**: Prezentare generală a Spring AI și SDK-urilor OpenAI
- **Protocolul Contextului Modelului**: Introducere în MCP și rolul său în comunicarea agenților AI
- **Aplicații practice**: Scenarii reale, inclusiv chatbots și generarea de conținut
- **[→ Începe Capitolul 1](./01-IntroToGenAI/README.md)**

### **Capitolul 2: Configurarea Mediului de Dezvoltare**
- **Configurare Multi-Furnizor**: Integrarea modelelor GitHub, Azure OpenAI și SDK-ului OpenAI Java
- **Spring Boot + Spring AI**: Cele mai bune practici pentru dezvoltarea aplicațiilor AI în mediul enterprise
- **Modele GitHub**: Acces gratuit la modele AI pentru prototipare și învățare (fără card de credit necesar)
- **Instrumente de Dezvoltare**: Configurarea containerelor Docker, VS Code și GitHub Codespaces
- **[→ Începe Capitolul 2](./02-SetupDevEnvironment/README.md)**

### **Capitolul 3: Tehnici de Bază în Inteligența Artificială Generativă**
- **Ingineria Prompturilor**: Tehnici pentru răspunsuri optime ale modelelor AI
- **Embedding-uri & Operațiuni Vectoriale**: Implementarea căutării semantice și potrivirii similitudinii
- **Generare Augmentată prin Recuperare (RAG)**: Combinarea AI cu sursele proprii de date
- **Apelarea Funcțiilor**: Extinderea capacităților AI cu instrumente și plugin-uri personalizate
- **[→ Începe Capitolul 3](./03-CoreGenerativeAITechniques/README.md)**

### **Capitolul 4: Aplicații Practice & Proiecte**
- **Generator de Povești pentru Animale de Companie** (`petstory/`): Generarea creativă de conținut cu Modele GitHub
- **Demo Local Foundry** (`foundrylocal/`): Integrarea modelelor AI locale cu SDK-ul OpenAI Java
- **Serviciu Calculator MCP** (`calculator/`): Implementare de bază a Protocolului Contextului Modelului cu Spring AI
- **[→ Începe Capitolul 4](./04-PracticalSamples/README.md)**

### **Capitolul 5: Dezvoltarea Responsabilă a AI**
- **Siguranța Modelelor GitHub**: Testarea mecanismelor de filtrare a conținutului și siguranță (blocări dure și refuzuri blânde)
- **Demo AI Responsabil**: Exemplu practic care arată cum funcționează sistemele moderne de siguranță AI
- **Cele mai bune practici**: Ghiduri esențiale pentru dezvoltarea și implementarea etică a AI
- **[→ Începe Capitolul 5](./05-ResponsibleGenAI/README.md)**

## Resurse Suplimentare

- [Edge AI pentru Începători](https://github.com/microsoft/edgeai-for-beginners)
- [MCP pentru Începători](https://github.com/microsoft/mcp-for-beginners)
- [Agenți AI pentru Începători](https://github.com/microsoft/ai-agents-for-beginners)
- [Inteligență Artificială Generativă pentru Începători folosind .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Inteligență Artificială Generativă pentru Începători folosind JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Inteligență Artificială Generativă pentru Începători](https://github.com/microsoft/generative-ai-for-beginners)
- [ML pentru Începători](https://aka.ms/ml-beginners)
- [Știința Datelor pentru Începători](https://aka.ms/datascience-beginners)
- [AI pentru Începători](https://aka.ms/ai-beginners)
- [Securitate Cibernetică pentru Începători](https://github.com/microsoft/Security-101)
- [Dezvoltare Web pentru Începători](https://aka.ms/webdev-beginners)
- [IoT pentru Începători](https://aka.ms/iot-beginners)
- [Dezvoltare XR pentru Începători](https://github.com/microsoft/xr-development-for-beginners)
- [Stăpânirea GitHub Copilot pentru Programare în Echipe AI](https://aka.ms/GitHubCopilotAI)
- [Stăpânirea GitHub Copilot pentru Dezvoltatori C#/.NET](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Alege-ți Propria Aventură Copilot](https://github.com/microsoft/CopilotAdventures)
- [Aplicație Chat RAG cu Servicii Azure AI](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Obținerea Ajutorului

Dacă întâmpini dificultăți sau ai întrebări despre construirea aplicațiilor AI, alătură-te:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Dacă ai feedback despre produs sau erori în timpul dezvoltării, vizitează:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Declinare de responsabilitate**:  
Acest document a fost tradus folosind serviciul de traducere AI [Co-op Translator](https://github.com/Azure/co-op-translator). Deși ne străduim să asigurăm acuratețea, vă rugăm să fiți conștienți că traducerile automate pot conține erori sau inexactități. Documentul original în limba sa natală ar trebui considerat sursa autoritară. Pentru informații critice, se recomandă traducerea profesională realizată de un specialist uman. Nu ne asumăm responsabilitatea pentru eventualele neînțelegeri sau interpretări greșite care pot apărea din utilizarea acestei traduceri.