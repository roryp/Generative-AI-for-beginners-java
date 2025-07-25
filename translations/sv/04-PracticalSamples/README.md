<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "139c227ef39d24287257d1aff6fc6973",
  "translation_date": "2025-07-25T09:35:25+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "sv"
}
-->
# Praktiska Tillämpningar & Projekt

> Obs: Varje exempel inkluderar också en **TUTORIAL.md** som guidar dig genom att köra exemplen.

## Vad Du Kommer Lära Dig
I det här avsnittet demonstrerar vi tre praktiska tillämpningar som visar utvecklingsmönster för generativ AI med Java:
- Skapa en multimodal berättelsegenerator för husdjur som kombinerar AI på klient- och serversidan
- Implementera integration av lokala AI-modeller med Foundry Local Spring Boot-demo
- Utveckla en Model Context Protocol (MCP)-tjänst med kalkylatorexemplet

## Innehållsförteckning

- [Introduktion](../../../04-PracticalSamples)
  - [Foundry Local Spring Boot Demo](../../../04-PracticalSamples)
  - [Berättelsegenerator för Husdjur](../../../04-PracticalSamples)
  - [MCP Kalkylatortjänst (Nybörjarvänlig MCP-demo)](../../../04-PracticalSamples)
- [Lärandeprogression](../../../04-PracticalSamples)
- [Sammanfattning](../../../04-PracticalSamples)
- [Nästa Steg](../../../04-PracticalSamples)

## Introduktion

Det här kapitlet visar **exempelprojekt** som demonstrerar utvecklingsmönster för generativ AI med Java. Varje projekt är fullt fungerande och visar specifika AI-teknologier, arkitekturmönster och bästa praxis som du kan anpassa till dina egna applikationer.

### Foundry Local Spring Boot Demo

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** visar hur man integrerar med lokala AI-modeller med hjälp av **OpenAI Java SDK**. Det demonstrerar anslutning till modellen **Phi-3.5-mini** som körs på Foundry Local, vilket gör det möjligt att köra AI-applikationer utan att förlita sig på molntjänster.

### Berättelsegenerator för Husdjur

**[Berättelsegenerator för Husdjur](petstory/README.md)** är en engagerande Spring Boot-webbapplikation som demonstrerar **multimodal AI-bearbetning** för att skapa kreativa berättelser om husdjur. Den kombinerar AI-funktioner på klient- och serversidan med transformer.js för AI-interaktioner i webbläsaren och OpenAI SDK för serverbearbetning.

### MCP Kalkylatortjänst (Nybörjarvänlig MCP-demo)

**[MCP Kalkylatortjänst](mcp/calculator/README.md)** är en enkel demonstration av **Model Context Protocol (MCP)** med Spring AI. Den ger en nybörjarvänlig introduktion till MCP-koncept och visar hur man skapar en grundläggande MCP-server som interagerar med MCP-klienter.

## Lärandeprogression

Dessa projekt är utformade för att bygga vidare på koncept från tidigare kapitel:

1. **Börja Enkelt**: Börja med Foundry Local Spring Boot Demo för att förstå grundläggande AI-integration med lokala modeller
2. **Lägg till Interaktivitet**: Gå vidare till Berättelsegenerator för Husdjur för multimodal AI och webbaserade interaktioner
3. **Lär Dig MCP-grunderna**: Prova MCP Kalkylatortjänst för att förstå grunderna i Model Context Protocol

## Sammanfattning

**Grattis!** Du har framgångsrikt:

- **Skapat multimodala AI-upplevelser** som kombinerar AI-bearbetning på klient- och serversidan
- **Implementerat integration av lokala AI-modeller** med moderna Java-ramverk och SDK:er
- **Utvecklat Model Context Protocol-tjänster** som demonstrerar integrationsmönster för verktyg

## Nästa Steg

[Kapitel 5: Ansvarsfull Generativ AI](../05-ResponsibleGenAI/README.md)

**Ansvarsfriskrivning**:  
Detta dokument har översatts med hjälp av AI-översättningstjänsten [Co-op Translator](https://github.com/Azure/co-op-translator). Även om vi strävar efter noggrannhet, bör du vara medveten om att automatiska översättningar kan innehålla fel eller felaktigheter. Det ursprungliga dokumentet på dess originalspråk bör betraktas som den auktoritativa källan. För kritisk information rekommenderas professionell mänsklig översättning. Vi ansvarar inte för eventuella missförstånd eller feltolkningar som uppstår vid användning av denna översättning.