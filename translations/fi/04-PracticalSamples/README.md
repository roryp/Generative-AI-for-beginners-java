<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "14c0a61ecc1cd2012a9c129236dfdf71",
  "translation_date": "2025-07-29T09:33:04+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "fi"
}
-->
# Käytännön sovellukset ja projektit

## Mitä opit
Tässä osiossa esittelemme kolme käytännön sovellusta, jotka havainnollistavat generatiivisen tekoälyn kehitysmalleja Javalla:
- Luodaan monimodaalinen lemmikkitarinageneraattori, joka yhdistää asiakas- ja palvelinpuolen tekoälyn
- Toteutetaan paikallisen tekoälymallin integrointi Foundry Local Spring Boot -demon avulla
- Kehitetään Model Context Protocol (MCP) -palvelu laskin-esimerkin avulla

## Sisällysluettelo

- [Johdanto](../../../04-PracticalSamples)
  - [Foundry Local Spring Boot Demo](../../../04-PracticalSamples)
  - [Lemmikkitarinageneraattori](../../../04-PracticalSamples)
  - [MCP-laskinpalvelu (aloittelijaystävällinen MCP-demo)](../../../04-PracticalSamples)
- [Oppimispolku](../../../04-PracticalSamples)
- [Yhteenveto](../../../04-PracticalSamples)
- [Seuraavat askeleet](../../../04-PracticalSamples)

## Johdanto

Tämä luku esittelee **esimerkkiprojekteja**, jotka havainnollistavat generatiivisen tekoälyn kehitysmalleja Javalla. Jokainen projekti on täysin toimiva ja esittelee tiettyjä tekoälyteknologioita, arkkitehtuurimalleja ja parhaita käytäntöjä, joita voit hyödyntää omissa sovelluksissasi.

### Foundry Local Spring Boot Demo

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** havainnollistaa, kuinka paikallisia tekoälymalleja voidaan integroida käyttämällä **OpenAI Java SDK:ta**. Demo esittelee yhteyden **Phi-3.5-mini**-malliin, joka toimii Foundry Local -ympäristössä, mahdollistaen tekoälysovellusten ajamisen ilman pilvipalveluita.

### Lemmikkitarinageneraattori

**[Lemmikkitarinageneraattori](petstory/README.md)** on viihdyttävä Spring Boot -verkkosovellus, joka esittelee **monimodaalista tekoälyn käsittelyä** luovien lemmikkitarinoiden tuottamiseksi. Se yhdistää asiakas- ja palvelinpuolen tekoälyominaisuudet hyödyntäen transformer.js-kirjastoa selaimessa tapahtuvaan tekoälyvuorovaikutukseen ja OpenAI SDK:ta palvelinpuolen käsittelyyn.

### MCP-laskinpalvelu (aloittelijaystävällinen MCP-demo)

**[MCP-laskinpalvelu](calculator/README.md)** on yksinkertainen esimerkki **Model Context Protocol (MCP)** -konseptista Spring AI:n avulla. Se tarjoaa aloittelijaystävällisen johdatuksen MCP:n perusideoihin ja näyttää, kuinka luoda yksinkertainen MCP-palvelin, joka kommunikoi MCP-asiakkaiden kanssa.

## Oppimispolku

Nämä projektit on suunniteltu rakentumaan aiempien lukujen konseptien päälle:

1. **Aloita yksinkertaisesta**: Aloita Foundry Local Spring Boot -demosta ymmärtääksesi paikallisten tekoälymallien perusintegraation
2. **Lisää vuorovaikutteisuutta**: Siirry lemmikkitarinageneraattoriin oppiaksesi monimodaalista tekoälyä ja verkkopohjaisia vuorovaikutuksia
3. **Opettele MCP:n perusteet**: Kokeile MCP-laskinpalvelua ymmärtääksesi Model Context Protocol -konseptin perusperiaatteet

## Yhteenveto

Hienoa työtä! Olet nyt tutustunut muutamiin todellisiin sovelluksiin:

- Monimodaalisiin tekoälykokemuksiin, jotka toimivat sekä selaimessa että palvelimella
- Paikallisten tekoälymallien integrointiin modernien Java-kehysten ja SDK:iden avulla
- Ensimmäiseen Model Context Protocol -palveluusi, joka näyttää, kuinka työkalut integroituvat tekoälyyn

## Seuraavat askeleet

[5. luku: Vastuullinen generatiivinen tekoäly](../05-ResponsibleGenAI/README.md)

**Vastuuvapauslauseke**:  
Tämä asiakirja on käännetty käyttämällä tekoälypohjaista käännöspalvelua [Co-op Translator](https://github.com/Azure/co-op-translator). Pyrimme tarkkuuteen, mutta huomioithan, että automaattiset käännökset voivat sisältää virheitä tai epätarkkuuksia. Alkuperäistä asiakirjaa sen alkuperäisellä kielellä tulee pitää ensisijaisena lähteenä. Kriittisen tiedon osalta suositellaan ammattimaista ihmiskääntämistä. Emme ole vastuussa tämän käännöksen käytöstä aiheutuvista väärinkäsityksistä tai virhetulkinnoista.