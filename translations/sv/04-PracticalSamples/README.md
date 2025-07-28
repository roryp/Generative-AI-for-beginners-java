<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d45b8e2291ab1357592c904c103cbc81",
  "translation_date": "2025-07-28T10:51:33+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "sv"
}
-->
# Praktiska Tillämpningar & Projekt

## Vad Du Kommer Lära Dig
I det här avsnittet demonstrerar vi tre praktiska tillämpningar som visar utvecklingsmönster för generativ AI med Java:
- Skapa en multimodal berättelsegenerator för husdjur som kombinerar AI på klient- och serversidan
- Implementera lokal AI-modellintegration med Foundry Local Spring Boot-demo
- Utveckla en Model Context Protocol (MCP)-tjänst med kalkylatorexemplet

## Innehållsförteckning

- [Introduktion](../../../04-PracticalSamples)
  - [Foundry Local Spring Boot-demo](../../../04-PracticalSamples)
  - [Berättelsegenerator för husdjur](../../../04-PracticalSamples)
  - [MCP Kalkylatortjänst (Nybörjarvänlig MCP-demo)](../../../04-PracticalSamples)
- [Lärandeutveckling](../../../04-PracticalSamples)
- [Sammanfattning](../../../04-PracticalSamples)
- [Nästa Steg](../../../04-PracticalSamples)

## Introduktion

Det här kapitlet visar **exempelprojekt** som demonstrerar utvecklingsmönster för generativ AI med Java. Varje projekt är fullt fungerande och visar specifika AI-teknologier, arkitekturmönster och bästa praxis som du kan anpassa till dina egna applikationer.

### Foundry Local Spring Boot-demo

**[Foundry Local Spring Boot-demo](foundrylocal/README.md)** demonstrerar hur man integrerar med lokala AI-modeller med hjälp av **OpenAI Java SDK**. Den visar hur man ansluter till **Phi-3.5-mini**-modellen som körs på Foundry Local, vilket gör det möjligt att köra AI-applikationer utan att förlita sig på molntjänster.

### Berättelsegenerator för husdjur

**[Berättelsegenerator för husdjur](petstory/README.md)** är en engagerande Spring Boot-webbapplikation som demonstrerar **multimodal AI-bearbetning** för att skapa kreativa berättelser om husdjur. Den kombinerar AI-funktioner på klient- och serversidan med transformer.js för AI-interaktioner i webbläsaren och OpenAI SDK för bearbetning på serversidan.

### MCP Kalkylatortjänst (Nybörjarvänlig MCP-demo)

**[MCP Kalkylatortjänst](calculator/README.md)** är en enkel demonstration av **Model Context Protocol (MCP)** med Spring AI. Den ger en nybörjarvänlig introduktion till MCP-koncept och visar hur man skapar en grundläggande MCP-server som interagerar med MCP-klienter.

## Lärandeutveckling

Dessa projekt är utformade för att bygga vidare på koncept från tidigare kapitel:

1. **Börja Enkelt**: Börja med Foundry Local Spring Boot-demo för att förstå grundläggande AI-integration med lokala modeller
2. **Lägg till Interaktivitet**: Gå vidare till Berättelsegenerator för husdjur för multimodal AI och webbaserade interaktioner
3. **Lär Dig MCP-grunderna**: Testa MCP Kalkylatortjänst för att förstå grunderna i Model Context Protocol

## Sammanfattning

**Grattis!** Du har framgångsrikt:

- **Skapat multimodala AI-upplevelser** som kombinerar AI-bearbetning på klient- och serversidan
- **Implementerat lokal AI-modellintegration** med moderna Java-ramverk och SDK:er
- **Utvecklat Model Context Protocol-tjänster** som demonstrerar integrationsmönster för verktyg

## Nästa Steg

[Kapitel 5: Ansvarsfull Generativ AI](../05-ResponsibleGenAI/README.md)

**Ansvarsfriskrivning**:  
Detta dokument har översatts med hjälp av AI-översättningstjänsten [Co-op Translator](https://github.com/Azure/co-op-translator). Även om vi strävar efter noggrannhet, bör det noteras att automatiserade översättningar kan innehålla fel eller felaktigheter. Det ursprungliga dokumentet på dess originalspråk bör betraktas som den auktoritativa källan. För kritisk information rekommenderas professionell mänsklig översättning. Vi ansvarar inte för eventuella missförstånd eller feltolkningar som uppstår vid användning av denna översättning.