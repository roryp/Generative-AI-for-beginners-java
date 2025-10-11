<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:31:40+00:00",
  "source_file": "README.md",
  "language_code": "tl"
}
-->
# Generative AI para sa mga Baguhan - Java Edition
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generative AI para sa mga Baguhan - Java Edition](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.tl.png)

**Oras na Kailangan**: Ang buong workshop ay maaaring kumpletuhin online nang walang lokal na setup. Ang pag-set up ng environment ay tumatagal ng 2 minuto, habang ang pag-explore ng mga sample ay nangangailangan ng 1-3 oras depende sa lalim ng pag-aaral.

> **Mabilisang Simula**

1. I-fork ang repository na ito sa iyong GitHub account
2. I-click ang **Code** → **Codespaces** tab → **...** → **New with options...**
3. Gamitin ang default settings – ito ang pipili ng Development container na ginawa para sa kursong ito
4. I-click ang **Create codespace**
5. Maghintay ng ~2 minuto para maging handa ang environment
6. Tumungo agad sa [Unang Halimbawa](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Suporta sa Multi-Language

### Sinusuportahan sa pamamagitan ng GitHub Action (Automated at Laging Napapanahon)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](../my/README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../br/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](./README.md) | [Tamil](../ta/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Estruktura ng Kurso at Landas ng Pag-aaral

### **Kabanata 1: Panimula sa Generative AI**
- **Mga Pangunahing Konsepto**: Pag-unawa sa Large Language Models, tokens, embeddings, at kakayahan ng AI
- **Java AI Ecosystem**: Pangkalahatang-ideya ng Spring AI at OpenAI SDKs
- **Model Context Protocol**: Panimula sa MCP at ang papel nito sa komunikasyon ng AI agent
- **Praktikal na Aplikasyon**: Mga totoong halimbawa tulad ng chatbots at content generation
- **[→ Simulan ang Kabanata 1](./01-IntroToGenAI/README.md)**

### **Kabanata 2: Pag-set up ng Development Environment**
- **Multi-Provider Configuration**: I-set up ang GitHub Models, Azure OpenAI, at OpenAI Java SDK integrations
- **Spring Boot + Spring AI**: Mga pinakamahusay na kasanayan para sa enterprise AI application development
- **GitHub Models**: Libreng access sa AI models para sa prototyping at pag-aaral (walang kinakailangang credit card)
- **Mga Kasangkapan sa Pag-develop**: Docker containers, VS Code, at GitHub Codespaces configuration
- **[→ Simulan ang Kabanata 2](./02-SetupDevEnvironment/README.md)**

### **Kabanata 3: Mga Pangunahing Teknik sa Generative AI**
- **Prompt Engineering**: Mga teknik para sa optimal na AI model responses
- **Embeddings at Vector Operations**: Pagpapatupad ng semantic search at similarity matching
- **Retrieval-Augmented Generation (RAG)**: Pagsasama ng AI sa sarili mong data sources
- **Function Calling**: Palawakin ang kakayahan ng AI gamit ang custom tools at plugins
- **[→ Simulan ang Kabanata 3](./03-CoreGenerativeAITechniques/README.md)**

### **Kabanata 4: Praktikal na Aplikasyon at Mga Proyekto**
- **Pet Story Generator** (`petstory/`): Paglikha ng malikhaing content gamit ang GitHub Models
- **Foundry Local Demo** (`foundrylocal/`): Lokal na integrasyon ng AI model gamit ang OpenAI Java SDK
- **MCP Calculator Service** (`calculator/`): Pangunahing implementasyon ng Model Context Protocol gamit ang Spring AI
- **[→ Simulan ang Kabanata 4](./04-PracticalSamples/README.md)**

### **Kabanata 5: Responsable na Pag-develop ng AI**
- **GitHub Models Safety**: Subukan ang built-in na content filtering at safety mechanisms (hard blocks at soft refusals)
- **Responsible AI Demo**: Hands-on na halimbawa kung paano gumagana ang modernong AI safety systems
- **Mga Pinakamahusay na Kasanayan**: Mahahalagang gabay para sa etikal na pag-develop at pag-deploy ng AI
- **[→ Simulan ang Kabanata 5](./05-ResponsibleGenAI/README.md)**

## Karagdagang Mga Mapagkukunan

- [Edge AI para sa mga Baguhan](https://github.com/microsoft/edgeai-for-beginners)
- [MCP Para sa mga Baguhan](https://github.com/microsoft/mcp-for-beginners)
- [AI Agents Para sa mga Baguhan](https://github.com/microsoft/ai-agents-for-beginners)
- [Generative AI para sa mga Baguhan gamit ang .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generative AI para sa mga Baguhan gamit ang JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generative AI para sa mga Baguhan](https://github.com/microsoft/generative-ai-for-beginners)
- [ML para sa mga Baguhan](https://aka.ms/ml-beginners)
- [Data Science para sa mga Baguhan](https://aka.ms/datascience-beginners)
- [AI para sa mga Baguhan](https://aka.ms/ai-beginners)
- [Cybersecurity para sa mga Baguhan](https://github.com/microsoft/Security-101)
- [Web Dev para sa mga Baguhan](https://aka.ms/webdev-beginners)
- [IoT para sa mga Baguhan](https://aka.ms/iot-beginners)
- [XR Development para sa mga Baguhan](https://github.com/microsoft/xr-development-for-beginners)
- [Mastering GitHub Copilot para sa AI Paired Programming](https://aka.ms/GitHubCopilotAI)
- [Mastering GitHub Copilot para sa C#/.NET Developers](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Pumili ng Sariling Copilot Adventure](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App gamit ang Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Pagkuha ng Tulong

Kung ikaw ay nahihirapan o may mga tanong tungkol sa paggawa ng AI apps, sumali sa:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Kung mayroon kang feedback sa produkto o mga error habang gumagawa, bisitahin:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Paunawa**:  
Ang dokumentong ito ay isinalin gamit ang AI translation service na [Co-op Translator](https://github.com/Azure/co-op-translator). Bagama't sinisikap naming maging tumpak, mangyaring tandaan na ang mga awtomatikong pagsasalin ay maaaring maglaman ng mga pagkakamali o hindi pagkakatugma. Ang orihinal na dokumento sa kanyang katutubong wika ang dapat ituring na opisyal na pinagmulan. Para sa mahalagang impormasyon, inirerekomenda ang propesyonal na pagsasalin ng tao. Hindi kami mananagot sa anumang hindi pagkakaunawaan o maling interpretasyon na dulot ng paggamit ng pagsasaling ito.