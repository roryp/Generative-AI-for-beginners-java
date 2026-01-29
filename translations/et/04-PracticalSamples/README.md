# Praktilised Rakendused ja Projektid

## Mida Sa Õpid
Selles osas tutvustame kolme praktilist rakendust, mis näitavad generatiivse tehisintellekti arendamise mustreid Java abil:
- Loo mitmeliigiline Lemmikloolugude Generaator, mis ühendab kliendipoolse ja serveripoolse tehisintellekti
- Rakenda kohalikku tehisintellekti mudeli integreerimist Foundry Local Spring Boot demo abil
- Arenda Model Context Protocol (MCP) teenust Kalkulaatori näite põhjal

## Sisukord

- [Sissejuhatus](../../../04-PracticalSamples)
  - [Foundry Local Spring Boot Demo](../../../04-PracticalSamples)
  - [Lemmikloolugude Generaator](../../../04-PracticalSamples)
  - [MCP Kalkulaatori Teenus (Algajasõbralik MCP Demo)](../../../04-PracticalSamples)
- [Õppimise Progressioon](../../../04-PracticalSamples)
- [Kokkuvõte](../../../04-PracticalSamples)
- [Järgmised Sammud](../../../04-PracticalSamples)

## Sissejuhatus

See peatükk tutvustab **näidisprojekte**, mis demonstreerivad generatiivse tehisintellekti arendamise mustreid Java abil. Iga projekt on täielikult funktsionaalne ja näitab konkreetseid tehisintellekti tehnoloogiaid, arhitektuurilisi mustreid ja parimaid tavasid, mida saad oma rakendustes kohandada.

### Foundry Local Spring Boot Demo

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** näitab, kuidas integreerida kohalikke tehisintellekti mudeleid, kasutades **OpenAI Java SDK-d**. See demonstreerib ühendust **Phi-3.5-mini** mudeliga, mis töötab Foundry Localis, võimaldades sul käivitada tehisintellekti rakendusi ilma pilveteenusteta.

### Lemmikloolugude Generaator

**[Lemmikloolugude Generaator](petstory/README.md)** on kaasahaarav Spring Boot veebirakendus, mis demonstreerib **mitmeliigilist tehisintellekti töötlemist**, et luua loomingulisi lemmikloolugusid. See ühendab kliendipoolse ja serveripoolse tehisintellekti võimekuse, kasutades transformer.js-i brauseripõhisteks tehisintellekti interaktsioonideks ja OpenAI SDK-d serveripoolseks töötlemiseks.

### MCP Kalkulaatori Teenus (Algajasõbralik MCP Demo)

**[MCP Kalkulaatori Teenus](calculator/README.md)** on lihtne Model Context Protocol (MCP) demonstratsioon, mis kasutab Spring AI-d. See pakub algajasõbralikku sissejuhatust MCP kontseptsioonidesse, näidates, kuidas luua põhiline MCP Server, mis suhtleb MCP klientidega.

## Õppimise Progressioon

Need projektid on loodud tuginedes eelnevate peatükkide kontseptsioonidele:

1. **Alusta Lihtsast**: Alusta Foundry Local Spring Boot Demoga, et mõista kohalike mudelite põhilist tehisintellekti integreerimist
2. **Lisa Interaktiivsus**: Liigu edasi Lemmikloolugude Generaatorini, et kogeda mitmeliigilist tehisintellekti ja veebipõhiseid interaktsioone
3. **Õpi MCP Põhitõdesid**: Proovi MCP Kalkulaatori Teenust, et mõista Model Context Protocoli aluseid

## Kokkuvõte

Tubli töö! Oled nüüd tutvunud mõne reaalse rakendusega:

- Mitmeliigilised tehisintellekti kogemused, mis töötavad nii brauseris kui ka serveris
- Kohaliku tehisintellekti mudeli integreerimine kaasaegsete Java raamistikute ja SDK-de abil
- Sinu esimene Model Context Protocol teenus, et näha, kuidas tööriistad tehisintellektiga integreeruvad

## Järgmised Sammud

[5. peatükk: Vastutustundlik Generatiivne Tehisintellekt](../05-ResponsibleGenAI/README.md)

---

**Lahtiütlus**:  
See dokument on tõlgitud AI tõlketeenuse [Co-op Translator](https://github.com/Azure/co-op-translator) abil. Kuigi püüame tagada täpsust, palume arvestada, et automaatsed tõlked võivad sisaldada vigu või ebatäpsusi. Algne dokument selle algses keeles tuleks pidada autoriteetseks allikaks. Olulise teabe puhul soovitame kasutada professionaalset inimtõlget. Me ei vastuta selle tõlke kasutamisest tulenevate arusaamatuste või valesti tõlgenduste eest.