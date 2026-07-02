# Praktiska tillämpningar och projekt

[![Praktiska tillämpningar och projekt](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Praktiska tillämpningar och projekt")

> **Videogenomgång:** [Se "Praktiska tillämpningar och projekt" på YouTube](https://www.youtube.com/watch?v=01vJsYei3H0).

## Vad du kommer att lära dig
I detta avsnitt demonstrerar vi tre praktiska applikationer som visar generativa AI-utvecklingsmönster med Java:
- Skapa en multimodal djurhistoriegenerator som kombinerar AI på klientsidan och serversidan
- Implementera lokal AI-modellintegration med Foundry Local Spring Boot-demo
- Utveckla en Model Context Protocol (MCP)-tjänst med kalkylatorexemplet

## Innehållsförteckning

- [Introduktion](#introduktion)
  - [Foundry Local Spring Boot-demo](#foundry-local-spring-boot-demo)
  - [Djurhistoriegenerator](#djurhistoriegenerator)
  - [MCP-kalkylatortjänst (nybörjarvänlig MCP-demo)](#mcp-kalkylatortjänst-nybörjarvänlig-mcp-demo)
- [Lärande progression](#lärande-progression)
- [Sammanfattning](#sammanfattning)
- [Nästa steg](#nästa-steg)

## Introduktion

Detta kapitel visar **exempelprojekt** som demonstrerar generativa AI-utvecklingsmönster med Java. Varje projekt är fullt fungerande och visar specifika AI-teknologier, arkitekturprinciper och bästa metoder som du kan anpassa för dina egna applikationer.

### Foundry Local Spring Boot-demo

**[Foundry Local Spring Boot-demo](foundrylocal/README.md)** visar hur man integrerar med lokala AI-modeller med hjälp av **OpenAI Java SDK**. Den demonstrerar anslutning till modeller som körs på Foundry Local (t.ex. **Phi-4-mini**) med automatisk modellupptäckt, vilket gör att du kan köra AI-applikationer utan att vara beroende av molntjänster.

### Djurhistoriegenerator

**[Djurhistoriegeneratorn](petstory/README.md)** är en engagerande Spring Boot-webbapplikation som visar **multimodal AI-behandling** för att skapa kreativa djurhistorier. Den kombinerar AI-möjligheter på klient- och serversidan med transformer.js för AI-interaktion i webbläsaren och OpenAI SDK för serverbaserad behandling.

### MCP-kalkylatortjänst (nybörjarvänlig MCP-demo)

**[MCP-kalkylatortjänsten](calculator/README.md)** är en enkel demonstration av **Model Context Protocol (MCP)** med Spring AI. Den ger en nybörjarvänlig introduktion till MCP-koncepten och visar hur man skapar en grundläggande MCP-server som interagerar med MCP-klienter.

## Lärande progression

Dessa projekt är utformade för att bygga vidare på koncept från tidigare kapitel:

1. **Börja enkelt**: Starta med Foundry Local Spring Boot-demo för att förstå grundläggande AI-integration med lokala modeller
2. **Lägg till interaktivitet**: Gå vidare till Djurhistoriegeneratorn för multimodal AI och webbinteraktioner
3. **Lär dig MCP-grunderna**: Testa MCP-kalkylatortjänsten för att förstå grunderna i Model Context Protocol

## Sammanfattning

Bra jobbat! Du har nu utforskat några riktiga applikationer:

- Multimodala AI-upplevelser som fungerar både i webbläsaren och på servern
- Lokal AI-modellintegration med moderna Java-ramverk och SDK:er
- Din första Model Context Protocol-tjänst för att se hur verktyg integreras med AI

## Nästa steg

[Kapitel 5: Ansvarsfull generativ AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Ansvarsfriskrivning**:  
Detta dokument har översatts med hjälp av AI-översättningstjänsten [Co-op Translator](https://github.com/Azure/co-op-translator). Även om vi strävar efter noggrannhet, var medveten om att automatiska översättningar kan innehålla fel eller inkonsekvenser. Det ursprungliga dokumentet på dess modersmål bör betraktas som den auktoritativa källan. För kritisk information rekommenderas professionell mänsklig översättning. Vi ansvarar inte för några missförstånd eller feltolkningar som uppstår från användningen av denna översättning.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->