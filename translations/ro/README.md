# AI Generativ pentru Începători - Ediția Java
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![AI Generativ pentru Începători - Ediția Java](../../translated_images/ro/beg-genai-series.8b48be9951cc574c.webp)

**Timp de alocare**: Întregul atelier poate fi realizat online fără configurare locală. Configurarea mediului durează 2 minute, iar explorarea exemplelor necesită 1-3 ore în funcție de adâncimea explorării.

> **Pornire Rapidă** 

1. Fă fork acestui repository în contul tău GitHub
2. Apasă pe **Code** → tab-ul **Codespaces** → **...** → **New with options...**
3. Folosește valorile implicite – aceasta va selecta containerul de Dezvoltare creat pentru acest curs
4. Apasă pe **Create codespace**
5. Așteaptă ~2 minute pentru ca mediul să fie gata
6. Mergi direct la [Primul exemplu](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **Preferi să Clonezi Local?**
>
> Acest repository include peste 50 de traduceri de limbă, ceea ce crește semnificativ dimensiunea descărcării. Pentru a clona fără traduceri, folosește sparse checkout:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> Aceasta îți oferă tot ce ai nevoie pentru a finaliza cursul cu o descărcare mult mai rapidă.


## Suport Multilingv

### Suportat prin GitHub Action (Automatizat & Întotdeauna Actualizat)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabă](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgară](../bg/README.md) | [Birmană (Myanmar)](../my/README.md) | [Chineză (Simplificată)](../zh-CN/README.md) | [Chineză (Tradițională, Hong Kong)](../zh-HK/README.md) | [Chineză (Tradițională, Macao)](../zh-MO/README.md) | [Chineză (Tradițională, Taiwan)](../zh-TW/README.md) | [Croată](../hr/README.md) | [Cehă](../cs/README.md) | [Daneză](../da/README.md) | [Olandeză](../nl/README.md) | [Estonă](../et/README.md) | [Finlandeză](../fi/README.md) | [Franceză](../fr/README.md) | [Germană](../de/README.md) | [Greacă](../el/README.md) | [Ebraică](../he/README.md) | [Hindi](../hi/README.md) | [Maghiară](../hu/README.md) | [Indoneziană](../id/README.md) | [Italiană](../it/README.md) | [Japoneză](../ja/README.md) | [Kannada](../kn/README.md) | [Coreeană](../ko/README.md) | [Lituaniană](../lt/README.md) | [Malaysiană](../ms/README.md) | [Malayalam](../ml/README.md) | [Marathi](../mr/README.md) | [Nepaleză](../ne/README.md) | [Pidgin Nigerian](../pcm/README.md) | [Norvegiană](../no/README.md) | [Persană (Farsi)](../fa/README.md) | [Poloneză](../pl/README.md) | [Portugheză (Brazilia)](../pt-BR/README.md) | [Portugheză (Portugalia)](../pt-PT/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Română](./README.md) | [Rusă](../ru/README.md) | [Sârbă (Chirilic)](../sr/README.md) | [Slovacă](../sk/README.md) | [Slovenă](../sl/README.md) | [Spaniolă](../es/README.md) | [Swahili](../sw/README.md) | [Suedeză](../sv/README.md) | [Tagalog (Filipineză)](../tl/README.md) | [Tamil](../ta/README.md) | [Telugu](../te/README.md) | [Thailandeză](../th/README.md) | [Turcă](../tr/README.md) | [Ucraineană](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnameză](../vi/README.md)

## Structura Cursului & Parcursul de Învățare

### **Capitolul 1: Introducere în AI Generativ**
- **Concepte de bază**: Înțelegerea modelelor mari de limbaj, tokeni, embedding-uri și capabilități AI
- **Ecosistemul AI Java**: Prezentarea generală a Spring AI și SDK-urilor OpenAI
- **Protocolul Contextului Modelului**: Introducere în MCP și rolul său în comunicarea agenților AI
- **Aplicații Practice**: Scenarii reale incluzând chatboți și generare de conținut
- **[→ Începe Capitolul 1](./01-IntroToGenAI/README.md)**

### **Capitolul 2: Configurarea Mediului de Dezvoltare**
- **Configurație Multi-Furnizor**: Configurare GitHub Models, Azure OpenAI și integrări OpenAI Java SDK
- **Spring Boot + Spring AI**: Cele mai bune practici pentru dezvoltarea aplicațiilor enterprise AI
- **GitHub Models**: Acces gratuit la modele AI pentru prototipare și învățare (fără card de credit)
- **Instrumente de dezvoltare**: Containere Docker, VS Code și configurare GitHub Codespaces
- **[→ Începe Capitolul 2](./02-SetupDevEnvironment/README.md)**

### **Capitolul 3: Tehnici de bază ale AI Generativ**
- **Ingineria Prompt-urilor**: Tehnici pentru răspunsuri optime ale modelelor AI
- **Embedding-uri & Operațiuni Vectoriale**: Implementarea căutărilor semantice și potrivirii similarității
- **Generare augmentată prin recuperare (RAG)**: Combinarea AI cu propriile surse de date
- **Apelarea Funcțiilor**: Extinderea capabilităților AI cu unelte și pluginuri personalizate
- **[→ Începe Capitolul 3](./03-CoreGenerativeAITechniques/README.md)**

### **Capitolul 4: Aplicații practice & Proiecte**
- **Generator de povesti pentru animale de companie** (`petstory/`): Generare creativă de conținut folosind GitHub Models
- **Demo local Foundry** (`foundrylocal/`): Integrare locală a modelului AI cu OpenAI Java SDK
- **Serviciul Calculator MCP** (`calculator/`): Implementare de bază a Protocolului Contextului Modelului cu Spring AI
- **[→ Începe Capitolul 4](./04-PracticalSamples/README.md)**

### **Capitolul 5: Dezvoltare AI responsabilă**
- **Siguranța GitHub Models**: Testează mecanismele încorporate de filtrare a conținutului și siguranță (blocaje dure și refuzuri blânde)
- **Demo AI Responsabil**: Exemplu practic care arată cum funcționează sistemele moderne de siguranță AI
- **Cele mai bune practici**: Ghiduri esențiale pentru dezvoltarea și implementarea etică a AI
- **[→ Începe Capitolul 5](./05-ResponsibleGenAI/README.md)**

## Resurse suplimentare

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j pentru Începători](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js pentru Începători](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain pentru Începători](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / Edge / MCP / Agenți
[![AZD pentru Începători](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI pentru Începători](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP pentru Începători](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Agenți AI pentru Începători](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Seria AI Generativ
[![AI Generativ pentru Începători](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Generativ (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![AI Generativ (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![AI Generativ (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### Învățare de bază
[![ML pentru Începători](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science pentru Începători](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI pentru Începători](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Securitate Cibernetică pentru Începători](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Dezvoltare Web pentru Începători](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT pentru Începători](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![Dezvoltare XR pentru Începători](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Seria Copilot
[![Copilot pentru Programare Asistată de AI](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot pentru C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Aventura Copilot](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## Obținerea Ajutorului

Dacă te blochezi sau ai întrebări despre construirea aplicațiilor AI. Alătură-te colegilor învățăcei și dezvoltatorilor experimentați în discuții despre MCP. Este o comunitate de susținere în care întrebările sunt binevenite și cunoștințele sunt împărtășite liber.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

Dacă ai feedback despre produs sau întâmpini erori în timpul dezvoltării vizitează:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Declinare a responsabilității**:
Acest document a fost tradus folosind serviciul de traducere AI [Co-op Translator](https://github.com/Azure/co-op-translator). Deși ne străduim pentru acuratețe, vă rugăm să țineți cont că traducerile automate pot conține erori sau inexactități. Documentul original, în limba sa nativă, trebuie considerat sursa autoritară. Pentru informații critice, se recomandă traducerea profesională realizată de un specialist uman. Nu ne asumăm nicio responsabilitate pentru eventualele neînțelegeri sau interpretări greșite rezultate din utilizarea acestei traduceri.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->