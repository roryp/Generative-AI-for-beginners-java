# Praktilised rakendused ja projektid

[![Praktilised rakendused ja projektid](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Praktilised rakendused ja projektid")

> **Video ülevaade:** [Vaata "Praktilised rakendused ja projektid" YouTube'is](https://www.youtube.com/watch?v=01vJsYei3H0).

## Mida õpid
Selles jaotises demonstreerime kolme praktilist rakendust, mis tutvustavad generatiivse AI arenduse mustreid Javas:
- Loo mitme modaaliga lemmikloomalugu generaator, ühendades kliendi- ja serveripoolset AI-d
- Rakenda kohalik AI mudelite integratsioon Foundry Local Spring Boot demo abil
- Arenda mudelikonteksti protokolli (MCP) teenus Calculator näitega

## Sisukord

- [Sissejuhatus](#sissejuhatus)
  - [Foundry Local Spring Boot demo](#foundry-local-spring-boot-demo)
  - [Lemmiklooma loo generaator](#lemmiklooma-loo-generaator)
  - [MCP kalkulaatori teenus (algajasõbralik MCP demo)](#mcp-kalkulaatori-teenus-algajasõbralik-mcp-demo)
- [Õppimise progressioon](#õppimise-progressioon)
- [Kokkuvõte](#kokkuvõte)
- [Järgmised sammud](#järgmised-sammud)

## Sissejuhatus

See peatükk tutvustab **näidisprojekte**, mis demonstreerivad generatiivse AI arendusmustreid Javas. Iga projekt on täielikult funktsionaalne ja näitab konkreetseid AI tehnoloogiaid, arhitektuurimustreid ning parimaid praktikaid, mida saad kohandada omaenda rakenduste jaoks.

### Foundry Local Spring Boot demo

**[Foundry Local Spring Boot demo](foundrylocal/README.md)** demonstreerib, kuidas integreerida kohalikke AI mudeleid kasutades **OpenAI Java SDK-d**. See näitab ühendust Foundry Localil töötavate mudelitega (nt **Phi-4-mini**), automaatse mudelituvastusega, võimaldades sul käivitada AI rakendusi ilma pilveteenustest sõltumata.

### Lemmiklooma loo generaator

**[Lemmiklooma loo generaator](petstory/README.md)** on kaasahaarav Spring Boot veebirakendus, mis demonstreerib **mitme modaaliga AI töötlemist**, et genereerida loomingulisi lemmikloomalugusid. See ühendab kliendi- ja serveripoolseid AI võimeid, kasutades brauseripõhisteks AI interaktsioonideks transformer.js-i ja serveripoolsesse töötlemisse OpenAI SDK-d.

### MCP kalkulaatori teenus (algajasõbralik MCP demo)

**[MCP kalkulaatori teenus](calculator/README.md)** on lihtne demonstratsioon **mudelikonteksti protokollist (MCP)**, kasutades Spring AI-d. See pakub algajasõbralikku sissejuhatust MCP kontseptsioonidesse, näidates, kuidas luua põhiline MCP server, mis suhtleb MCP klientidega.

## Õppimise progressioon

Need projektid on loodud eelnevate peatükkide kontseptsioonidele tuginedes:

1. **Alusta lihtsast**: alusta Foundry Local Spring Boot demost, et mõista kohalike mudelite AI põhitõdesid
2. **Lisa interaktiivsus**: liigu edasi Lemmiklooma loo generaatorile mitme modaaliga AI ja veebipõhiste interaktsioonidega
3. **Õpi MCP põhialuseid**: proovi MCP kalkulaatori teenust, et mõista mudelikonteksti protokolli aluseid

## Kokkuvõte

Tubli töö! Nüüd oled uurinud mõningaid reaalseid rakendusi:

- Mitme modaaliga AI kogemused, mis töötavad nii brauseris kui ka serveris
- Kohalike AI mudelite integratsioon kaasaegsete Java raamistikute ja SDK-dega
- Sinu esimene mudelikonteksti protokolli teenus, et näha, kuidas tööriistad AI-ga ühildavad

## Järgmised sammud

[5. peatükk: Vastutustundlik generatiivne AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Vastuutusest loobumine**:  
See dokument on tõlgitud AI tõlketeenuse [Co-op Translator](https://github.com/Azure/co-op-translator) abil. Kuigi püüame täpsust, palun pange tähele, et automaatsed tõlked võivad sisaldada vigu või ebatäpsusi. Originaaldokument selle emakeeles tuleks pidada autoriteetseks allikaks. Olulise teabe puhul soovitatakse kasutada professionaalset inimtõlget. Me ei vastuta ühegi arusaamatuse või valesti mõistmise eest, mis tuleneb selle tõlke kasutamisest.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->