# Praktiske Anvendelser & Prosjekter

[![Practical Applications & Projects](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Practical Applications & Projects")

> **Videooversikt:** [Se "Practical Applications & Projects" på YouTube](https://www.youtube.com/watch?v=01vJsYei3H0).

## Hva Du Vil Lære
I denne seksjonen vil vi demonstrere tre praktiske applikasjoner som viser mønstre for generativ AI-utvikling med Java:
- Lag en multimodal Pet Story Generator som kombinerer klient- og server-side AI
- Implementer lokal AI-modellintegrasjon med Foundry Local Spring Boot-demoen
- Utvikle en Model Context Protocol (MCP) tjeneste med Kalkulator-eksempelet

## Innholdsfortegnelse

- [Innledning](#innledning)
  - [Foundry Local Spring Boot Demo](#foundry-local-spring-boot-demo)
  - [Pet Story Generator](#pet-story-generator)
  - [MCP Calculator Service (Nybegynnervennlig MCP-demo)](#mcp-calculator-service-nybegynnervennlig-mcp-demo)
- [Læringsprogresjon](#læringsprogresjon)
- [Sammendrag](#sammendrag)
- [Neste Steg](#neste-steg)

## Innledning

Dette kapitlet viser **eksempelprosjekter** som demonstrerer mønstre for generativ AI-utvikling med Java. Hvert prosjekt er fullt funksjonelt og viser spesifikke AI-teknologier, arkitekturmønstre og beste praksiser som du kan tilpasse til dine egne applikasjoner.

### Foundry Local Spring Boot Demo

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** demonstrerer hvordan man integrerer med lokale AI-modeller ved hjelp av **OpenAI Java SDK**. Den viser tilkobling til **Phi-3.5-mini** modellen som kjører på Foundry Local, noe som lar deg kjøre AI-applikasjoner uten å være avhengig av skyløsninger.

### Pet Story Generator

**[Pet Story Generator](petstory/README.md)** er en engasjerende Spring Boot-nettapplikasjon som demonstrerer **multimodal AI-behandling** for å generere kreative dyrehistorier. Den kombinerer AI-muligheter på klient- og serversiden ved bruk av transformer.js for nettleserbaserte AI-interaksjoner og OpenAI SDK for serverbehandling.

### MCP Calculator Service (Nybegynnervennlig MCP-demo)

**[MCP Calculator Service](calculator/README.md)** er en enkel demonstrasjon av **Model Context Protocol (MCP)** ved bruk av Spring AI. Den gir en nybegynnervennlig introduksjon til MCP-konsepter, og viser hvordan man lager en grunnleggende MCP-server som samhandler med MCP-klienter.

## Læringsprogresjon

Disse prosjektene er utformet for å bygge videre på konsepter fra tidligere kapitler:

1. **Start enkelt**: Begynn med Foundry Local Spring Boot Demo for å forstå grunnleggende AI-integrasjon med lokale modeller
2. **Legg til interaktivitet**: Gå videre til Pet Story Generator for multimodal AI og nettbaserte interaksjoner
3. **Lær MCP-grunnprinsipper**: Prøv MCP Calculator Service for å forstå Model Context Protocols grunnlag

## Sammendrag

Bra jobbet! Du har nå utforsket noen ekte applikasjoner:

- Multimodale AI-opplevelser som fungerer både i nettleseren og på serveren
- Lokal AI-modellintegrasjon ved bruk av moderne Java-rammeverk og SDK-er
- Din første Model Context Protocol-tjeneste for å se hvordan verktøy integreres med AI

## Neste Steg

[Kapittel 5: Ansvarlig Generativ AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Ansvarsfraskrivelse**:  
Dette dokumentet er oversatt ved hjelp av AI-oversettelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selv om vi streber etter nøyaktighet, vær oppmerksom på at automatiske oversettelser kan inneholde feil eller unøyaktigheter. Originaldokumentet på dets opprinnelige språk bør betraktes som den autoritative kilden. For kritisk informasjon anbefales profesjonell menneskelig oversettelse. Vi er ikke ansvarlige for eventuelle misforståelser eller feiltolkninger som oppstår fra bruk av denne oversettelsen.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->