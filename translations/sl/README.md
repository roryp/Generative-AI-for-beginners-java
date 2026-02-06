# Generativna umetna inteligenca za začetnike - Java izdaja
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generativna umetna inteligenca za začetnike - Java izdaja](../../translated_images/sl/beg-genai-series.8b48be9951cc574c.webp)

**Časovna zaveza**: Celoten delavnico je mogoče zaključiti na spletu brez lokalne namestitve. Nastavitev okolja traja 2 minuti, raziskovanje primerov pa 1-3 ure, odvisno od globine raziskovanja.

> **Hitri začetek** 

1. Razvezi ta repozitorij v svoj GitHub račun
2. Klikni **Code** → **Codespaces** zavihek → **...** → **New with options...**
3. Uporabi privzete nastavitve – izbralo bo razvojni kontejner, ustvarjen za ta tečaj
4. Klikni **Create codespace**
5. Počakaj približno 2 minuti, da bo okolje pripravljeno
6. Pojdi neposredno na [Prvi primer](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **Raje klonirati lokalno?**
>
> Ta repozitorij vključuje več kot 50 jezikovnih prevodov, kar znatno povečuje velikost prenosa. Če želiš klonirati brez prevodov, uporabi sparse checkout:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> Tako prejmeš vse, kar potrebuješ za dokončanje tečaja, s precej hitrejšim prenosom.


## Podpora za več jezikov

### Podprto preko GitHub Action (avtomatizirano in vedno posodobljeno)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabski](../ar/README.md) | [Bengalski](../bn/README.md) | [Bolgarščina](../bg/README.md) | [Burmanski (Mjanmar)](../my/README.md) | [Kitajski (poenostavljeno)](../zh-CN/README.md) | [Kitajski (tradicionalno, Hong Kong)](../zh-HK/README.md) | [Kitajski (tradicionalno, Makao)](../zh-MO/README.md) | [Kitajski (tradicionalno, Tajvan)](../zh-TW/README.md) | [Hrvaščina](../hr/README.md) | [Češčina](../cs/README.md) | [Danščina](../da/README.md) | [Nizozemščina](../nl/README.md) | [Estonščina](../et/README.md) | [Finščina](../fi/README.md) | [Francoščina](../fr/README.md) | [Nemščina](../de/README.md) | [Grščina](../el/README.md) | [Hebrejščina](../he/README.md) | [Hindijščina](../hi/README.md) | [Madžarščina](../hu/README.md) | [Indonezijščina](../id/README.md) | [Italijanščina](../it/README.md) | [Japonščina](../ja/README.md) | [Kannada](../kn/README.md) | [Korejščina](../ko/README.md) | [Litovščina](../lt/README.md) | [Malajščina](../ms/README.md) | [Malajalščina](../ml/README.md) | [Maratščina](../mr/README.md) | [Nepalščina](../ne/README.md) | [Nigerijski pidžin](../pcm/README.md) | [Norveščina](../no/README.md) | [Perzijski (Farsi)](../fa/README.md) | [Poljščina](../pl/README.md) | [Portugalski (Brazilija)](../pt-BR/README.md) | [Portugalski (Portugal)](../pt-PT/README.md) | [Pandžabski (Gurmukhi)](../pa/README.md) | [Romunščina](../ro/README.md) | [Ruščina](../ru/README.md) | [Srbščina (cirilica)](../sr/README.md) | [Slovaščina](../sk/README.md) | [Slovenščina](./README.md) | [Španščina](../es/README.md) | [Svahili](../sw/README.md) | [Švedščina](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamilščina](../ta/README.md) | [Telugu](../te/README.md) | [Tajščina](../th/README.md) | [Turščina](../tr/README.md) | [Ukrajinščina](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamski](../vi/README.md)

## Struktura tečaja in učna pot

### **Poglavje 1: Uvod v generativno umetno inteligenco**
- **Osnovni pojmi**: Razumevanje velikih jezikovnih modelov, tokenov, vtisov in zmogljivosti AI
- **Java AI ekosistem**: Pregled Spring AI in OpenAI SDK-jev
- **Protokol konteksta modela**: Uvod v MCP in njegova vloga pri komunikaciji AI agentov
- **Praktične uporabe**: Resnični primeri, vključno s klepetalniki in ustvarjanjem vsebine
- **[→ Začni poglavje 1](./01-IntroToGenAI/README.md)**

### **Poglavje 2: Nastavitev razvojnega okolja**
- **Konfiguracija več ponudnikov**: Nastavitev integracij GitHub modelov, Azure OpenAI in OpenAI Java SDK
- **Spring Boot + Spring AI**: Najboljše prakse za razvoj podjetniških AI aplikacij
- **GitHub modeli**: Brezplačen dostop do AI modelov za prototipiranje in učenje (brez kreditne kartice)
- **Razvojna orodja**: Docker kontejnerji, VS Code in GitHub Codespaces konfiguracija
- **[→ Začni poglavje 2](./02-SetupDevEnvironment/README.md)**

### **Poglavje 3: Osnovne tehnike generativne AI**
- **Inženiring pozivov**: Tehnike za optimalne odzive AI modelov
- **Vtisi in vektorske operacije**: Izvedi semantično iskanje in primerjanje podobnosti
- **Generiranje z obogatenim pridobivanjem (RAG)**: Združi AI z lastnimi podatkovnimi viri
- **Klicanje funkcij**: Razširi zmogljivosti AI s prilagojenimi orodji in vtičniki
- **[→ Začni poglavje 3](./03-CoreGenerativeAITechniques/README.md)**

### **Poglavje 4: Praktične aplikacije in projekti**
- **Generator zgodb o hišnih ljubljenčkih** (`petstory/`): Ustvarjalno generiranje vsebine z GitHub modeli
- **Foundry lokalna predstavitev** (`foundrylocal/`): Lokalna integracija AI modela z OpenAI Java SDK
- **MCP kalkulator storitev** (`calculator/`): Osnovna implementacija protokola konteksta modela s Spring AI
- **[→ Začni poglavje 4](./04-PracticalSamples/README.md)**

### **Poglavje 5: Odgovoren razvoj umetne inteligence**
- **Varnost GitHub modelov**: Testiraj vgrajeno filtriranje vsebine in varnostne mehanizme (trdi bloki in mehki zavrnitve)
- **Demo odgovorne AI**: Praktičen primer, ki prikazuje, kako sodobni varnostni sistemi AI delujejo v praksi
- **Najboljše prakse**: Ključna priporočila za etičen razvoj in uvajanje AI
- **[→ Začni poglavje 5](./05-ResponsibleGenAI/README.md)**

## Dodatni viri

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j za začetnike](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js za začetnike](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain za začetnike](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / Edge / MCP / Agent
[![AZD za začetnike](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI za začetnike](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP za začetnike](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI agenti za začetnike](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Serija generativne AI
[![Generativna AI za začetnike](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generativna AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generativna AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generativna AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### Osnovno učenje
[![Strojno učenje za začetnike](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Podatkovna znanost za začetnike](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![Umetna inteligenca za začetnike](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Kibernetska varnost za začetnike](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Spletni razvoj za začetnike](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT za začetnike](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR razvoj za začetnike](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Serija Copilot
[![Copilot za AI sodelovalno programiranje](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot za C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot dogodivščina](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## Pridobivanje pomoči

Če se zataknete ali imate kakršnakoli vprašanja o ustvarjanju AI aplikacij. Pridružite se drugim učencem in izkušenim razvijalcem v razpravah o MCP. To je podpirajoča skupnost, kjer so vprašanja dobrodošla in se znanje prostovoljno deli.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

Če imate povratne informacije o izdelku ali napake med razvijanjem, obiščite:

[![Microsoft Foundry razvojni forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Omejitev odgovornosti**:
Ta dokument je bil preveden z uporabo storitve za prevajanje z umetno inteligenco [Co-op Translator](https://github.com/Azure/co-op-translator). Čeprav si prizadevamo za natančnost, vas prosimo, da upoštevate, da lahko avtomatski prevodi vsebujejo napake ali netočnosti. Izvirni dokument v njegovi izvorni jezikovni različici velja za avtoritativni vir. Za kritične informacije priporočamo strokovni človeški prevod. Nismo odgovorni za morebitna nesporazumevanja ali napačne interpretacije, ki izhajajo iz uporabe tega prevoda.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->