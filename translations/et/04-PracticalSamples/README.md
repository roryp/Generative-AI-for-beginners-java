# Praktilised rakendused ja projektid

[![Praktilised rakendused ja projektid](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Praktilised rakendused ja projektid")

> **Video ülevaade:** [Vaata "Praktilised rakendused ja projektid" YouTube'is](https://www.youtube.com/watch?v=01vJsYei3H0).

## Mida sa õpid
Selles jaotises demonstreerime kolme praktilist rakendust, mis tutvustavad generatiivse tehisintellekti arendusmustreid Javas:
- Loo mitme-modaalne loomajuttude generaator, ühendades kliendi- ja serveripoolsed AI lahendused
- Rakenda lokaalsete AI mudelite integratsioon Foundry Local Spring Boot demoga
- Arenda mudelikonteksti protokolli (MCP) teenus Kalkulaatori näidise abil

## Sisukord

- [Sissejuhatus](#sissejuhatus)
  - [Foundry Local Spring Boot demo](#foundry-local-spring-boot-demo)
  - [Loomajuttude generaator](#loomajuttude-generaator)
  - [MCP kalkulaatori teenus (algajasõbralik MCP demo)](#mcp-kalkulaatori-teenus-algajasõbralik-mcp-demo)
- [Õppimise järjepidevus](#õppimise-järjepidevus)
- [Kokkuvõte](#kokkuvõte)
- [Järgmised sammud](#järgmised-sammud)

## Sissejuhatus

See peatükk tutvustab **näidisprojekte**, mis demonstreerivad generatiivse tehisintellekti arendusmustreid Javas. Iga projekt on täielikult funktsionaalne ning näitab konkreetseid AI tehnoloogiaid, arhitektuurilisi mustreid ja parimaid tavasid, mida saad oma rakendustes kasutada.

### Foundry Local Spring Boot demo

**[Foundry Local Spring Boot demo](foundrylocal/README.md)** demonstreerib, kuidas integreerida lokaalseid AI mudeleid kasutades **OpenAI Java SDK-d**. See näitab ühenduse loomist Foundry Locali peal töötava **Phi-3.5-mini** mudeliga, võimaldades AI-rakenduste käivitamist ilma pilveteenuseid kasutamata.

### Loomajuttude generaator

**[Loomajuttude generaator](petstory/README.md)** on kaasahaarav Spring Boot veebirakendus, mis demonstreerib **mitme-modaalset AI töötlemist** loominguliste loomajuttude genereerimiseks. See ühendab kliendi- ja serveripoolseid AI võimalusi, kasutades transformeri.js brauseripõhisteks AI interaktsioonideks ja OpenAI SDK-d serveripoolseks töötlemiseks.

### MCP kalkulaatori teenus (algajasõbralik MCP demo)

**[MCP kalkulaatori teenus](calculator/README.md)** on lihtne demonstratsioon **mudelikonteksti protokollist (MCP)** kasutades Spring AI-te. See pakub algajasõbralikku sissejuhatust MCP kontseptsioonidesse, näidates, kuidas luua lihtne MCP server, mis suhtleb MCP klientidega.

## Õppimise järjepidevus

Need projektid on loodud eelnevate peatükkide teemade edasiarendamiseks:

1. **Alusta lihtsast:** Alusta Foundry Local Spring Boot demoga, et mõista kohalike mudelite põhjalikku AI integratsiooni
2. **Lisa interaktiivsus:** Liigu edasi Loomajuttude generaatorisse mitme-modaalse AI ja veebipõhiste interaktsioonide jaoks
3. **Õpi MCP põhitõed:** Proovi MCP kalkulaatori teenust, et mõista Mudelikonteksti protokolli aluseid

## Kokkuvõte

Tubli töö! Oled nüüd uurinud päris rakendusi:

- Mitme-modaalsed AI kogemused, mis toimivad nii brauseris kui ka serveris
- Kohalike AI mudelite integratsioon kaasaegsete Java raamistikude ja SDK-dega
- Sinu esimene Mudelikonteksti protokolli teenus, et näha, kuidas tööriistad integreeruvad AI-ga

## Järgmised sammud

[Peatükk 5: Vastutustundlik generatiivne AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Vastutusest loobumine**:
See dokument on tõlgitud AI tõlketeenuse [Co-op Translator](https://github.com/Azure/co-op-translator) abil. Kuigi me püüame tagada täpsust, olge teadlikud, et automaatsed tõlked võivad sisaldada vigu või ebatäpsusi. Originaaldokument selle emakeeles tuleks pidada autoriteetseks allikaks. Kriitilise teabe puhul soovitatakse professionaalset inimtõlget. Me ei vastuta selle tõlke kasutamisest tingitud valesti mõistmiste või tõlgenduste eest.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->