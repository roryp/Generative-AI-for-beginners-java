<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "139c227ef39d24287257d1aff6fc6973",
  "translation_date": "2025-07-25T09:41:17+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "fi"
}
-->
# Käytännön sovellukset ja projektit

> Huomio: Jokainen esimerkki sisältää myös **TUTORIAL.md**-tiedoston, joka opastaa näytteiden suorittamisessa.

## Mitä opit
Tässä osiossa esittelemme kolme käytännön sovellusta, jotka havainnollistavat generatiivisen tekoälyn kehitysmalleja Java-kielellä:
- Luo monimodaalinen lemmikkitarinageneraattori, joka yhdistää asiakas- ja palvelinpuolen tekoälyn
- Toteuta paikallisen tekoälymallin integrointi Foundry Local Spring Boot -demolla
- Kehitä Model Context Protocol (MCP) -palvelu laskin-esimerkin avulla

## Sisällysluettelo

- [Johdanto](../../../04-PracticalSamples)
  - [Foundry Local Spring Boot -demo](../../../04-PracticalSamples)
  - [Lemmikkitarinageneraattori](../../../04-PracticalSamples)
  - [MCP-laskinpalvelu (aloittelijaystävällinen MCP-demo)](../../../04-PracticalSamples)
- [Oppimisen eteneminen](../../../04-PracticalSamples)
- [Yhteenveto](../../../04-PracticalSamples)
- [Seuraavat askeleet](../../../04-PracticalSamples)

## Johdanto

Tämä luku esittelee **esimerkkiprojekteja**, jotka havainnollistavat generatiivisen tekoälyn kehitysmalleja Java-kielellä. Jokainen projekti on täysin toimiva ja esittelee tiettyjä tekoälyteknologioita, arkkitehtuurimalleja ja parhaita käytäntöjä, joita voit soveltaa omiin sovelluksiisi.

### Foundry Local Spring Boot -demo

**[Foundry Local Spring Boot -demo](foundrylocal/README.md)** havainnollistaa, kuinka paikallisia tekoälymalleja integroidaan **OpenAI Java SDK**:n avulla. Se esittelee yhteyden **Phi-3.5-mini**-malliin, joka toimii Foundry Localissa, mahdollistaen tekoälysovellusten käytön ilman pilvipalveluita.

### Lemmikkitarinageneraattori

**[Lemmikkitarinageneraattori](petstory/README.md)** on viihdyttävä Spring Boot -verkkosovellus, joka havainnollistaa **monimodaalista tekoälyn käsittelyä** luovien lemmikkitarinoiden tuottamiseksi. Se yhdistää asiakas- ja palvelinpuolen tekoälyominaisuudet käyttämällä transformer.js-kirjastoa selaimen tekoälytoimintoihin ja OpenAI SDK:ta palvelinpuolen käsittelyyn.

### MCP-laskinpalvelu (aloittelijaystävällinen MCP-demo)

**[MCP-laskinpalvelu](mcp/calculator/README.md)** on yksinkertainen demonstraatio **Model Context Protocol (MCP)**:sta Spring AI:n avulla. Se tarjoaa aloittelijaystävällisen johdannon MCP-konsepteihin, näyttäen kuinka luodaan perus MCP-palvelin, joka kommunikoi MCP-asiakkaiden kanssa.

## Oppimisen eteneminen

Nämä projektit on suunniteltu rakentumaan aiempien lukujen käsitteiden päälle:

1. **Aloita yksinkertaisesti**: Aloita Foundry Local Spring Boot -demosta ymmärtääksesi paikallisten mallien perusintegraation
2. **Lisää vuorovaikutteisuutta**: Siirry Lemmikkitarinageneraattoriin monimodaalisen tekoälyn ja verkkopohjaisten vuorovaikutusten pariin
3. **Opettele MCP:n perusteet**: Kokeile MCP-laskinpalvelua ymmärtääksesi Model Context Protocolin peruskäsitteet

## Yhteenveto

**Onnittelut!** Olet onnistuneesti:

- **Luonut monimodaalisia tekoälykokemuksia**, jotka yhdistävät asiakas- ja palvelinpuolen tekoälyn käsittelyn
- **Toteuttanut paikallisen tekoälymallin integroinnin** nykyaikaisia Java-kehyksiä ja SDK:ita hyödyntäen
- **Kehittänyt Model Context Protocol -palveluita**, jotka havainnollistavat työkalujen integrointimalleja

## Seuraavat askeleet

[5. luku: Vastuullinen generatiivinen tekoäly](../05-ResponsibleGenAI/README.md)

**Vastuuvapauslauseke**:  
Tämä asiakirja on käännetty käyttämällä tekoälypohjaista käännöspalvelua [Co-op Translator](https://github.com/Azure/co-op-translator). Vaikka pyrimme tarkkuuteen, huomioithan, että automaattiset käännökset voivat sisältää virheitä tai epätarkkuuksia. Alkuperäinen asiakirja sen alkuperäisellä kielellä tulisi pitää ensisijaisena lähteenä. Kriittisen tiedon osalta suositellaan ammattimaista ihmiskäännöstä. Emme ole vastuussa väärinkäsityksistä tai virhetulkinnoista, jotka johtuvat tämän käännöksen käytöstä.