# Käytännön sovellukset ja projektit

[![Käytännön sovellukset ja projektit](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Käytännön sovellukset ja projektit")

> **Videoesittely:** [Katso "Käytännön sovellukset ja projektit" YouTubessa](https://www.youtube.com/watch?v=01vJsYei3H0).

## Mitä opit
Tässä osiossa demonstroimme kolmea käytännön sovellusta, jotka esittelevät generatiivisen tekoälyn kehitysmalleja Javalla:
- Luo monimodaalinen lemmikkitarinakone, joka yhdistää asiakaspuolen ja palvelinpuolen tekoälyn
- Toteuta paikallinen tekoälymallin integrointi Foundry Local Spring Boot -demolla
- Kehitä Model Context Protocol (MCP) -palvelu laskimesimerkkiin pohjautuen

## Sisällysluettelo

- [Johdanto](#johdanto)
  - [Foundry Local Spring Boot Demo](#foundry-local-spring-boot-demo)
  - [Lemmikkitarinakone](#lemmikkitarinakone)
  - [MCP-laskinpalvelu (aloittelijaystävällinen MCP-demo)](#mcp-laskinpalvelu-aloittelijaystävällinen-mcp-demo)
- [Oppimisen eteneminen](#oppimisen-eteneminen)
- [Yhteenveto](#yhteenveto)
- [Seuraavat askeleet](#seuraavat-askeleet)

## Johdanto

Tässä luvussa esitellään **esimerkkiprojekteja**, jotka demonstroivat generatiivisen tekoälyn kehitysmalleja Javalla. Jokainen projekti on täysin toimiva ja esittelee tiettyjä tekoälyteknologioita, arkkitehtonisia malleja ja parhaita käytäntöjä, joita voit soveltaa omissa sovelluksissasi.

### Foundry Local Spring Boot Demo

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** näyttää, kuinka integroida paikallisiin tekoälymalleihin käyttäen **OpenAI Java SDK:ta**. Se esittelee yhteyden muodostamisen Foodry Localissa (esim. **Phi-4-mini**) ajaviin malleihin automaattisella mallintunnistuksella, mahdollistaen tekoälysovellusten ajamisen ilman pilvipalveluita.

### Lemmikkitarinakone

**[Lemmikkitarinakone](petstory/README.md)** on hauska Spring Boot -verkkosovellus, joka demonstroi **monimodaalista tekoälyn käsittelyä** luodakseen luovia lemmikkitarinoita. Se yhdistää asiakas- ja palvelinpuolen tekoälykyvyt käyttämällä transformer.js-kirjastoa selaimessa tapahtuvan tekoälyinteraktion toteuttamiseen ja OpenAI SDK:ta palvelinpuolella tapahtuvaan prosessointiin.

### MCP-laskinpalvelu (aloittelijaystävällinen MCP-demo)

**[MCP-laskinpalvelu](calculator/README.md)** on yksinkertainen esimerkki **Model Context Protocolin (MCP)** käytöstä Spring AI:n avulla. Se tarjoaa aloittelijaystävällisen johdatuksen MCP-konsepteihin näyttäen, kuinka luodaan perus MCP-palvelin, joka kommunikoi MCP-asiakkaiden kanssa.

## Oppimisen eteneminen

Nämä projektit on suunniteltu rakentamaan aiempien lukujen konsepteille:

1. **Aloita yksinkertaisesti**: Aloita Foundry Local Spring Boot Demolla ymmärtääksesi paikallisen tekoälymallin perusintegroinnin
2. **Lisää vuorovaikutteisuutta**: Kehity Lemmikkitarinakoneeseen monimodaalista tekoälyä ja web-pohjaisia vuorovaikutuksia varten
3. **Opiskele MCP:n perusteet**: Kokeile MCP-laskinpalvelua oppiaksesi Model Context Protocolin pohjat

## Yhteenveto

Hienoa työtä! Olet nyt tutustunut todellisiin sovelluksiin:

- Monimodaaliset tekoälykokemukset, jotka toimivat sekä selaimessa että palvelimella
- Paikallisen tekoälymallin integrointi nykyaikaisilla Java-kehyksillä ja SDK:illa
- Ensimmäinen Model Context Protocol -palvelusi, jonka avulla tiedät, miten välineet integroituvat tekoälyyn

## Seuraavat askeleet

[Luku 5: Vastuullinen generatiivinen tekoäly](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Vastuuvapauslauseke**:  
Tämä asiakirja on käännetty käyttämällä tekoälypohjaista käännöspalvelua [Co-op Translator](https://github.com/Azure/co-op-translator). Vaikka pyrimme tarkkuuteen, otathan huomioon, että automaattiset käännökset saattavat sisältää virheitä tai epätarkkuuksia. Alkuperäistä asiakirjaa sen alkuperäiskielellä tulisi pitää virallisena lähteenä. Tärkeissä asioissa suositellaan ammattimaista ihmiskäännöstä. Emme ole vastuussa mahdollisista väärinymmärryksistä tai tulkinnoista, jotka johtuvat tämän käännöksen käytöstä.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->