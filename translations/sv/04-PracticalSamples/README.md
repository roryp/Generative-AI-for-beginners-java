# Praktiska tillämpningar & projekt

[![Practical Applications & Projects](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Practical Applications & Projects")

> **Videogenomgång:** [Titta på "Practical Applications & Projects" på YouTube](https://www.youtube.com/watch?v=01vJsYei3H0).

## Vad du kommer att lära dig
I detta avsnitt demonstrerar vi tre praktiska tillämpningar som visar generativa AI-utvecklingsmönster med Java:
- Skapa en multimodal berättelsegenerator för husdjur som kombinerar AI på klient- och serversidan
- Implementera lokal AI-modellintegration med Foundry Local Spring Boot-demot
- Utveckla en Model Context Protocol (MCP)-tjänst med Calculator-exemplet

## Innehållsförteckning

- [Introduktion](#introduktion)
  - [Foundry Local Spring Boot-demo](#foundry-local-spring-boot-demo)
  - [Berättelsegenerator för husdjur](#berättelsegenerator-för-husdjur)
  - [MCP Calculator Service (nybörjarvänligt MCP-demo)](#mcp-calculator-service-nybörjarvänligt-mcp-demo)
- [Lärande progression](#lärande-progression)
- [Sammanfattning](#sammanfattning)
- [Nästa steg](#nästa-steg)

## Introduktion

Detta kapitel visar **exempelprojekt** som demonstrerar generativa AI-utvecklingsmönster med Java. Varje projekt är fullt fungerande och visar specifika AI-teknologier, arkitekturmönster och bästa praxis som du kan anpassa för dina egna applikationer.

### Foundry Local Spring Boot-demo

**[Foundry Local Spring Boot-demo](foundrylocal/README.md)** visar hur du integrerar med lokala AI-modeller med hjälp av **OpenAI Java SDK**. Den visar hur man ansluter till modellen **Phi-3.5-mini** som körs på Foundry Local, vilket möjliggör att köra AI-applikationer utan att förlita sig på molntjänster.

### Berättelsegenerator för husdjur

**[Berättelsegenerator för husdjur](petstory/README.md)** är en engagerande Spring Boot webbapplikation som demonstrerar **multimodal AI-behandling** för att skapa kreativa historier om husdjur. Den kombinerar AI-kapaciteter på klient- och serversidan med transformer.js för AI-interaktioner i webbläsaren och OpenAI SDK för serverbehandling.

### MCP Calculator Service (nybörjarvänligt MCP-demo)

**[MCP Calculator Service](calculator/README.md)** är en enkel demonstration av **Model Context Protocol (MCP)** med Spring AI. Den ger en nybörjarvänlig introduktion till MCP-koncept och visar hur man skapar en grundläggande MCP-server som interagerar med MCP-klienter.

## Lärande progression

Dessa projekt är utformade för att bygga vidare på koncept från tidigare kapitel:

1. **Börja enkelt**: Börja med Foundry Local Spring Boot-demot för att förstå grundläggande AI-integration med lokala modeller
2. **Lägg till interaktivitet**: Fortsätt till Pet Story Generator för multimodal AI och webbaserade interaktioner
3. **Lär dig MCP-grunder**: Testa MCP Calculator Service för att förstå grunderna i Model Context Protocol

## Sammanfattning

Bra jobbat! Du har nu utforskat några verkliga tillämpningar:

- Multimodala AI-upplevelser som fungerar både i webbläsaren och på servern
- Lokal AI-modellintegration med moderna Java-ramverk och SDK:er
- Din första Model Context Protocol-tjänst för att se hur verktyg integreras med AI

## Nästa steg

[Kapitel 5: Ansvarsfull generativ AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Ansvarsfriskrivning**:
Detta dokument har översatts med hjälp av AI-översättningstjänsten [Co-op Translator](https://github.com/Azure/co-op-translator). Även om vi strävar efter noggrannhet, vänligen observera att automatiska översättningar kan innehålla fel eller felaktigheter. Det ursprungliga dokumentet på dess modersmål bör betraktas som den auktoritativa källan. För kritisk information rekommenderas professionell mänsklig översättning. Vi ansvarar inte för några missförstånd eller feltolkningar som uppstår från användningen av denna översättning.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->