# Käytännön sovellukset ja projektit

[![Käytännön sovellukset ja projektit](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Käytännön sovellukset ja projektit")

> **Videokatsaus:** [Katso "Käytännön sovellukset ja projektit" YouTubesta](https://www.youtube.com/watch?v=01vJsYei3H0).

## Mitä opit
Tässä osiossa demonstroimme kolmea käytännön sovellusta, jotka esittelevät generatiivisen tekoälyn kehitysmalleja Javalla:
- Luoda monimodaalinen lemmikkitarinageneraattori yhdistämällä asiakas- ja palvelinpuolen tekoälyt
- Toteuttaa paikallinen tekoälymallin integraatio Foundry Local Spring Boot -demolla
- Kehittää Model Context Protocol (MCP) -palvelu Calculator-esimerkin avulla

## Sisällysluettelo

- [Johdanto](#johdanto)
  - [Foundry Local Spring Boot Demo](#foundry-local-spring-boot-demo)
  - [Lemmikkitarinageneraattori](#lemmikkitarinageneraattori)
  - [MCP Calculator Service (aloittelijaystävällinen MCP-demo)](#mcp-calculator-service-aloittelijaystävällinen-mcp-demo)
- [Oppimisen eteneminen](#oppimisen-eteneminen)
- [Yhteenveto](#yhteenveto)
- [Seuraavat askeleet](#seuraavat-askeleet)

## Johdanto

Tässä luvussa esitellään **esimerkkiprojekteja**, jotka demonstroivat generatiivisen tekoälyn kehitysmalleja Javalla. Jokainen projekti on täysin toimiva ja esittelee tiettyjä tekoälyteknologioita, arkkitehtuurimalleja ja parhaita käytäntöjä, joita voit mukauttaa omiin sovelluksiisi.

### Foundry Local Spring Boot Demo

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** näyttää, miten integroida paikallisiin tekoälymalleihin käyttämällä **OpenAI Java SDK:ta**. Se havainnollistaa yhteyden muodostamista **Phi-3.5-mini** -malliin, joka toimii Foundry Localissa, mahdollistaen tekoälysovellusten ajamisen ilman pilvipalveluihin tukeutumista.

### Lemmikkitarinageneraattori

**[Lemmikkitarinageneraattori](petstory/README.md)** on mukaansatempaava Spring Boot -verkkosovellus, joka demonstroi **monimodaalista tekoälyn käsittelyä** luodakseen luovia lemmikkitarinoita. Se yhdistää asiakas- ja palvelinpuolen tekoälyominaisuuksia käyttäen transformer.js-kirjastoa selaimessa tapahtuvaan tekoälyvuorovaikutukseen ja OpenAI SDK:ta palvelinpuolen prosessointiin.

### MCP Calculator Service (aloittelijaystävällinen MCP-demo)

**[MCP Calculator Service](calculator/README.md)** on yksinkertainen demonstraatio **Model Context Protocolista (MCP)** käyttäen Spring AI -kirjastoa. Se tarjoaa aloittelijaystävällisen johdannon MCP-konsepteihin näyttäen, miten luodaan perus MCP-palvelin, joka kommunikoi MCP-asiakkaiden kanssa.

## Oppimisen eteneminen

Nämä projektit on suunniteltu rakentumaan aiempien lukujen käsitteiden päälle:

1. **Aloita yksinkertaisesti**: Aloita Foundry Local Spring Boot Demolla ymmärtääksesi paikallisten mallien perusteet tekoälyintegraatiossa
2. **Lisää interaktiivisuutta**: Etene Lemmikkitarinageneraattoriin monimodaalisen tekoälyn ja web-pohjaisten vuorovaikutusten pariin
3. **Opiskele MCP:n perusteet**: Kokeile MCP Calculator Serviceä ymmärtääksesi Model Context Protocolin perusasiat

## Yhteenveto

Hienoa työtä! Olet nyt tutustunut todellisiin sovelluksiin:

- Monimodaaliset tekoälykokemukset, jotka toimivat sekä selaimessa että palvelimella
- Paikallisen tekoälymallin integrointi moderneilla Java-kehyksillä ja SDK:illa
- Ensimmäinen Model Context Protocol -palvelusi nähdäksesi, miten työkalut integroituvat tekoälyyn

## Seuraavat askeleet

[Luku 5: Vastuullinen generatiivinen tekoäly](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Vastuuvapauslauseke**:  
Tämä asiakirja on käännetty tekoälypohjaisella käännöspalvelulla [Co-op Translator](https://github.com/Azure/co-op-translator). Pyrimme tarkkuuteen, mutta ole hyvä ja huomioi, että automaattiset käännökset voivat sisältää virheitä tai epätarkkuuksia. Alkuperäinen asiakirja sen alkuperäisellä kielellä on virallinen lähde. Tärkeissä asioissa suositellaan ammattilaisen tekemää ihmiskäännöstä. Emme ole vastuussa tämän käännöksen käytöstä johtuvista väärinymmärryksistä tai virhetulkintojen seurauksista.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->