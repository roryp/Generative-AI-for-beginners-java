# Praktinės taikymo sritys ir projektai

[![Praktinės taikymo sritys ir projektai](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Praktinės taikymo sritys ir projektai")

> **Vaizdo apžvalga:** [Žiūrėkite „Praktinės taikymo sritys ir projektai“ YouTube](https://www.youtube.com/watch?v=01vJsYei3H0).

## Ko išmoksite
Šiame skyriuje pademonstruosime tris praktines programas, kurios atskleidžia generatyviosios AI kūrimo modelius su Java:
- Sukurti daugiamačio augintinio istorijos generatorių, derinant kliento pusės ir serverio pusės AI
- Įdiegti vietinę AI modelio integraciją su Foundry Local Spring Boot demonstracija
- Sukurti Modelio konteksto protokolo (MCP) paslaugą su skaičiuotuvo pavyzdžiu

## Turinys

- [Įvadas](#įvadas)
  - [Foundry Local Spring Boot demonstracija](#foundry-local-spring-boot-demonstracija)
  - [Augintinio istorijos generatorius](#augintinio-istorijos-generatorius)
  - [MCP skaičiuotuvo paslauga (pradedančiajam skirta MCP demonstracija)](#mcp-skaičiuotuvo-paslauga-pradedančiajam-skirta-mcp-demonstracija)
- [Mokymosi pažanga](#mokymosi-pažanga)
- [Santrauka](#santrauka)
- [Kiti žingsniai](#kiti-žingsniai)

## Įvadas

Šis skyrius pristato **pavyzdinius projektus**, kurie demonstruoja generatyviosios AI kūrimo modelius su Java. Kiekvienas projektas yra pilnai veikiantis ir demonstruoja specifines AI technologijas, architektūrinius modelius bei gerąsias praktikas, kurias galite pritaikyti savo programose.

### Foundry Local Spring Boot demonstracija

**[Foundry Local Spring Boot demonstracija](foundrylocal/README.md)** parodo, kaip integruotis su vietiniais AI modeliais naudojant **OpenAI Java SDK**. Ji demonstruoja prisijungimą prie Foundry Local modelių (pvz., **Phi-4-mini**), su automatiniu modelio aptikimu, leidžianti vykdyti AI programas nenaudojant debesų paslaugų.

### Augintinio istorijos generatorius

**[Augintinio istorijos generatorius](petstory/README.md)** yra patraukli Spring Boot interneto programa, demonstruojanti **daugiamačio AI apdorojimą** kūrybingoms augintinių istorijoms generuoti. Ji sujungia kliento pusės ir serverio pusės AI galimybes naudojant transformer.js naršyklės pagrindu AI sąveikoms bei OpenAI SDK serverio pusės apdorojimui.

### MCP skaičiuotuvo paslauga (pradedančiajam skirta MCP demonstracija)

**[MCP skaičiuotuvo paslauga](calculator/README.md)** yra paprasta Modelio konteksto protokolo (MCP) demonstracija naudojant Spring AI. Ji suteikia pradedančiajam draugišką įvadą į MCP koncepcijas, rodydama, kaip sukurti pagrindinį MCP serverį, kuris sąveikauja su MCP klientais.

## Mokymosi pažanga

Šie projektai sukurti siekiant plėtoti ankstesnių skyrių temas:

1. **Pradėkite paprastai**: Pradėkite nuo Foundry Local Spring Boot demonstracijos, kad suprastumėte pagrindinę AI integraciją su vietiniais modeliais
2. **Pridėkite interaktyvumo**: Pereikite prie Augintinio istorijos generatoriaus, kad pažintumėte daugiamačio AI ir žiniatinklio sąveikas
3. **Išmokite MCP pagrindus**: Išbandykite MCP skaičiuotuvo paslaugą, kad suprastumėte Modelio konteksto protokolo pagrindus

## Santrauka

Puikus darbas! Dabar jau ištyrėte keletą tikrų programų:

- Daugiamačiai AI sprendimai, veikiantys tiek naršyklėje, tiek serveryje
- Vietinė AI modelio integracija naudojant modernias Java sistemas ir SDK
- Jūsų pirmoji Modelio konteksto protokolo paslauga, leidžianti suprasti, kaip įrankiai integruojasi su AI

## Kiti žingsniai

[5 skyrius: Atsakingas generatyvioji AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Atsakomybės apribojimas**:  
Šis dokumentas buvo išverstas naudojant dirbtinio intelekto vertimo paslaugą [Co-op Translator](https://github.com/Azure/co-op-translator). Nors stengiamės užtikrinti tikslumą, prašome atkreipti dėmesį, kad automatiniai vertimai gali turėti klaidų ar netikslumų. Originalus dokumentas jo gimtąja kalba turėtų būti laikomas autoritetingu šaltiniu. Svarbiai informacijai rekomenduojama pasitelkti profesionalų žmogaus vertimą. Mes neatsakome už jokius nesusipratimus ar neteisingą supratimą, kylančius dėl šio vertimo naudojimo.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->