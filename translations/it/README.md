<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:25:49+00:00",
  "source_file": "README.md",
  "language_code": "it"
}
-->
# Generative AI per Principianti - Edizione Java
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generative AI per Principianti - Edizione Java](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.it.png)

**Impegno di Tempo**: L'intero workshop può essere completato online senza configurazione locale. L'impostazione dell'ambiente richiede 2 minuti, mentre l'esplorazione degli esempi richiede 1-3 ore a seconda della profondità di esplorazione.

> **Avvio Rapido**

1. Fai un fork di questo repository sul tuo account GitHub
2. Clicca su **Code** → scheda **Codespaces** → **...** → **New with options...**
3. Usa le impostazioni predefinite – questo selezionerà il container di sviluppo creato per questo corso
4. Clicca su **Create codespace**
5. Aspetta circa 2 minuti per la preparazione dell'ambiente
6. Vai direttamente a [Il primo esempio](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Supporto Multilingue

### Supportato tramite GitHub Action (Automatizzato e Sempre Aggiornato)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabo](../ar/README.md) | [Bengalese](../bn/README.md) | [Bulgaro](../bg/README.md) | [Birmano (Myanmar)](../my/README.md) | [Cinese (Semplificato)](../zh/README.md) | [Cinese (Tradizionale, Hong Kong)](../hk/README.md) | [Cinese (Tradizionale, Macao)](../mo/README.md) | [Cinese (Tradizionale, Taiwan)](../tw/README.md) | [Croato](../hr/README.md) | [Ceco](../cs/README.md) | [Danese](../da/README.md) | [Olandese](../nl/README.md) | [Estone](../et/README.md) | [Finlandese](../fi/README.md) | [Francese](../fr/README.md) | [Tedesco](../de/README.md) | [Greco](../el/README.md) | [Ebraico](../he/README.md) | [Hindi](../hi/README.md) | [Ungherese](../hu/README.md) | [Indonesiano](../id/README.md) | [Italiano](./README.md) | [Giapponese](../ja/README.md) | [Coreano](../ko/README.md) | [Lituano](../lt/README.md) | [Malese](../ms/README.md) | [Marathi](../mr/README.md) | [Nepalese](../ne/README.md) | [Norvegese](../no/README.md) | [Persiano (Farsi)](../fa/README.md) | [Polacco](../pl/README.md) | [Portoghese (Brasile)](../br/README.md) | [Portoghese (Portogallo)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Rumeno](../ro/README.md) | [Russo](../ru/README.md) | [Serbo (Cirillico)](../sr/README.md) | [Slovacco](../sk/README.md) | [Sloveno](../sl/README.md) | [Spagnolo](../es/README.md) | [Swahili](../sw/README.md) | [Svedese](../sv/README.md) | [Tagalog (Filippino)](../tl/README.md) | [Tamil](../ta/README.md) | [Thailandese](../th/README.md) | [Turco](../tr/README.md) | [Ucraino](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamita](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Struttura del Corso e Percorso di Apprendimento

### **Capitolo 1: Introduzione al Generative AI**
- **Concetti Fondamentali**: Comprendere i modelli linguistici di grandi dimensioni, i token, gli embeddings e le capacità dell'AI
- **Ecosistema AI in Java**: Panoramica su Spring AI e OpenAI SDKs
- **Protocollo di Contesto del Modello**: Introduzione al MCP e al suo ruolo nella comunicazione degli agenti AI
- **Applicazioni Pratiche**: Scenari reali tra cui chatbot e generazione di contenuti
- **[→ Inizia il Capitolo 1](./01-IntroToGenAI/README.md)**

### **Capitolo 2: Configurazione dell'Ambiente di Sviluppo**
- **Configurazione Multi-Provider**: Configura modelli GitHub, Azure OpenAI e integrazioni OpenAI Java SDK
- **Spring Boot + Spring AI**: Best practice per lo sviluppo di applicazioni AI aziendali
- **Modelli GitHub**: Accesso gratuito ai modelli AI per prototipazione e apprendimento (senza carta di credito)
- **Strumenti di Sviluppo**: Configurazione di container Docker, VS Code e GitHub Codespaces
- **[→ Inizia il Capitolo 2](./02-SetupDevEnvironment/README.md)**

### **Capitolo 3: Tecniche Fondamentali di Generative AI**
- **Prompt Engineering**: Tecniche per risposte ottimali dai modelli AI
- **Embeddings e Operazioni sui Vettori**: Implementa ricerca semantica e corrispondenza di similarità
- **Generazione Augmentata dal Recupero (RAG)**: Combina AI con le tue fonti di dati
- **Chiamata di Funzioni**: Estendi le capacità dell'AI con strumenti e plugin personalizzati
- **[→ Inizia il Capitolo 3](./03-CoreGenerativeAITechniques/README.md)**

### **Capitolo 4: Applicazioni Pratiche e Progetti**
- **Generatore di Storie per Animali Domestici** (`petstory/`): Generazione creativa di contenuti con modelli GitHub
- **Demo Locale Foundry** (`foundrylocal/`): Integrazione locale di modelli AI con OpenAI Java SDK
- **Servizio Calcolatore MCP** (`calculator/`): Implementazione base del Protocollo di Contesto del Modello con Spring AI
- **[→ Inizia il Capitolo 4](./04-PracticalSamples/README.md)**

### **Capitolo 5: Sviluppo Responsabile dell'AI**
- **Sicurezza dei Modelli GitHub**: Testa i filtri di contenuto integrati e i meccanismi di sicurezza (blocchi rigidi e rifiuti morbidi)
- **Demo AI Responsabile**: Esempio pratico che mostra come funzionano i moderni sistemi di sicurezza AI
- **Best Practice**: Linee guida essenziali per uno sviluppo e una distribuzione etica dell'AI
- **[→ Inizia il Capitolo 5](./05-ResponsibleGenAI/README.md)**

## Risorse Aggiuntive

- [Edge AI per Principianti](https://github.com/microsoft/edgeai-for-beginners)
- [MCP per Principianti](https://github.com/microsoft/mcp-for-beginners)
- [Agenti AI per Principianti](https://github.com/microsoft/ai-agents-for-beginners)
- [Generative AI per Principianti con .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generative AI per Principianti con JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generative AI per Principianti](https://github.com/microsoft/generative-ai-for-beginners)
- [ML per Principianti](https://aka.ms/ml-beginners)
- [Data Science per Principianti](https://aka.ms/datascience-beginners)
- [AI per Principianti](https://aka.ms/ai-beginners)
- [Cybersecurity per Principianti](https://github.com/microsoft/Security-101)
- [Sviluppo Web per Principianti](https://aka.ms/webdev-beginners)
- [IoT per Principianti](https://aka.ms/iot-beginners)
- [Sviluppo XR per Principianti](https://github.com/microsoft/xr-development-for-beginners)
- [Mastering GitHub Copilot per Programmazione AI in Coppia](https://aka.ms/GitHubCopilotAI)
- [Mastering GitHub Copilot per Sviluppatori C#/.NET](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Scegli la tua Avventura con Copilot](https://github.com/microsoft/CopilotAdventures)
- [App Chat RAG con Servizi Azure AI](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Ottenere Aiuto

Se hai difficoltà o domande sulla creazione di app AI, unisciti a:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Se hai feedback sui prodotti o errori durante la creazione, visita:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Disclaimer**:  
Questo documento è stato tradotto utilizzando il servizio di traduzione automatica [Co-op Translator](https://github.com/Azure/co-op-translator). Sebbene ci impegniamo per garantire l'accuratezza, si prega di notare che le traduzioni automatiche possono contenere errori o imprecisioni. Il documento originale nella sua lingua nativa dovrebbe essere considerato la fonte autorevole. Per informazioni critiche, si raccomanda una traduzione professionale effettuata da un traduttore umano. Non siamo responsabili per eventuali incomprensioni o interpretazioni errate derivanti dall'uso di questa traduzione.