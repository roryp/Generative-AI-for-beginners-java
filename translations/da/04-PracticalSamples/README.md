# Praktiske Anvendelser & Projekter

[![Practical Applications & Projects](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Practical Applications & Projects")

> **Videooversigt:** [Se "Practical Applications & Projects" på YouTube](https://www.youtube.com/watch?v=01vJsYei3H0).

## Hvad Du Vil Lære
I dette afsnit demonstrerer vi tre praktiske anvendelser, der viser generative AI-udviklingsmønstre med Java:
- Opret en multimodal Pet Story Generator, der kombinerer AI på klient- og serversiden
- Implementer lokal AI-modelintegration med Foundry Local Spring Boot-demonstrationen
- Udvikl en Model Context Protocol (MCP) service med kalkulator-eksemplet

## Indholdsfortegnelse

- [Introduktion](#introduktion)
  - [Foundry Local Spring Boot Demo](#foundry-local-spring-boot-demo)
  - [Pet Story Generator](#pet-story-generator)
  - [MCP Calculator Service (Begyndervenlig MCP-demo)](#mcp-calculator-service-begyndervenlig-mcp-demo)
- [Læringsforløb](#læringsforløb)
- [Opsummering](#opsummering)
- [Næste Skridt](#næste-skridt)

## Introduktion

Dette kapitel viser **eksempler på projekter**, der demonstrerer generative AI-udviklingsmønstre med Java. Hvert projekt er fuldt funktionelt og demonstrerer specifikke AI-teknologier, arkitekturmønstre og bedste praksisser, som du kan tilpasse til dine egne applikationer.

### Foundry Local Spring Boot Demo

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** demonstrerer, hvordan man integrerer med lokale AI-modeller ved hjælp af **OpenAI Java SDK**. Det viser, hvordan man kobler til modeller, der kører på Foundry Local (f.eks. **Phi-4-mini**), med automatisk modelregistrering, hvilket gør det muligt at køre AI-applikationer uden at være afhængig af cloudtjenester.

### Pet Story Generator

**[Pet Story Generator](petstory/README.md)** er en engagerende Spring Boot-webapplikation, der demonstrerer **multimodal AI-behandling** til at generere kreative kæledyrshistorier. Den kombinerer AI-muligheder på klient- og serversiden med transformer.js til browserbaserede AI-interaktioner og OpenAI SDK til serverbehandling.

### MCP Calculator Service (Begyndervenlig MCP-demo)

**[MCP Calculator Service](calculator/README.md)** er en simpel demonstration af **Model Context Protocol (MCP)** ved brug af Spring AI. Den giver en begyndervenlig introduktion til MCP-koncepter og viser, hvordan man opretter en grundlæggende MCP-server, der interagerer med MCP-klienter.

## Læringsforløb

Disse projekter er designet til at bygge videre på koncepter fra tidligere kapitler:

1. **Start simpelt**: Begynd med Foundry Local Spring Boot-demoen for at forstå grundlæggende AI-integration med lokale modeller
2. **Tilføj interaktivitet**: Fortsæt til Pet Story Generator for multimodal AI og webbaserede interaktioner
3. **Lær MCP-grundlæggende**: Prøv MCP Calculator Service for at forstå Model Context Protocols grundlag

## Opsummering

Godt gået! Du har nu udforsket nogle reelle anvendelser:

- Multimodale AI-oplevelser, der fungerer både i browseren og på serveren
- Lokal AI-modelintegration ved hjælp af moderne Java-rammer og SDK’er
- Din første Model Context Protocol-service for at se, hvordan værktøjer integrerer med AI

## Næste Skridt

[Kapitel 5: Ansvarlig Generativ AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Ansvarsfraskrivelse**:  
Dette dokument er oversat ved hjælp af AI-oversættelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selvom vi bestræber os på nøjagtighed, bedes du være opmærksom på, at automatiserede oversættelser kan indeholde fejl eller unøjagtigheder. Det originale dokument på dets oprindelige sprog bør betragtes som den autoritative kilde. For kritisk information anbefales professionel menneskelig oversættelse. Vi påtager os intet ansvar for eventuelle misforståelser eller fejltolkninger, der opstår som følge af brugen af denne oversættelse.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->