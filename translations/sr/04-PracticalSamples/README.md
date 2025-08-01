<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "da1b6d87b8a73306b29f9a1bdd681221",
  "translation_date": "2025-07-21T21:14:55+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "sr"
}
-->
# Практичне Примене и Пројекти

> Напомена: Сваки пример укључује и **TUTORIAL.md** који вас води кроз покретање апликације.

## Шта ћете научити
У овом делу представљамо три практичне апликације које приказују шаблоне развоја генеративне вештачке интелигенције са Јавом:
- Креирање генератора прича о кућним љубимцима који комбинује AI на клијентској и серверској страни
- Имплементација интеграције локалног AI модела са Foundry Local Spring Boot демо апликацијом
- Развој сервиса за Model Context Protocol (MCP) кроз пример калкулатора

## Садржај

- [Увод](../../../04-PracticalSamples)
  - [Foundry Local Spring Boot Демо](../../../04-PracticalSamples)
  - [Генератор прича о кућним љубимцима](../../../04-PracticalSamples)
  - [MCP Калкулатор Сервис (Демо за почетнике)](../../../04-PracticalSamples)
- [Прогресија учења](../../../04-PracticalSamples)
- [Резиме](../../../04-PracticalSamples)
- [Следећи кораци](../../../04-PracticalSamples)

## Увод

Ово поглавље представља **пример пројеката** који демонстрирају шаблоне развоја генеративне вештачке интелигенције са Јавом. Сваки пројекат је у потпуности функционалан и приказује специфичне AI технологије, архитектонске шаблоне и најбоље праксе које можете прилагодити својим апликацијама.

### Foundry Local Spring Boot Демо

**[Foundry Local Spring Boot Демо](foundrylocal/README.md)** показује како интегрисати локалне AI моделе користећи **OpenAI Java SDK**. Приказује повезивање са моделом **Phi-3.5-mini** који ради на Foundry Local, омогућавајући вам да покрећете AI апликације без ослањања на cloud услуге.

### Генератор прича о кућним љубимцима

**[Генератор прича о кућним љубимцима](petstory/README.md)** је интерактивна Spring Boot веб апликација која демонстрира **мултимодалну AI обраду** за креирање креативних прича о кућним љубимцима. Комбинује AI могућности на клијентској и серверској страни користећи transformer.js за интеракције у прегледачу и OpenAI SDK за обраду на серверу.

### MCP Калкулатор Сервис (Демо за почетнике)

**[MCP Калкулатор Сервис](mcp/calculator/README.md)** је једноставан пример **Model Context Protocol (MCP)** коришћењем Spring AI. Пружа увод у MCP концепте, показујући како креирати основни MCP сервер који комуницира са MCP клијентима.

## Прогресија учења

Ови пројекти су дизајнирани да се надовезују на концепте из претходних поглавља:

1. **Почните једноставно**: Започните са Foundry Local Spring Boot демо апликацијом да бисте разумели основну интеграцију AI модела на локалу
2. **Додајте интерактивност**: Пређите на Генератор прича о кућним љубимцима за мултимодалну AI обраду и интеракције преко веба
3. **Научите основе MCP-а**: Испробајте MCP Калкулатор Сервис да бисте разумели основе Model Context Protocol-а

## Резиме

**Честитамо!** Успешно сте:

- **Креирали мултимодалне AI искуства** комбинујући обраду на клијентској и серверској страни
- **Имплементирали интеграцију локалних AI модела** користећи савремене Java оквире и SDK-ове
- **Развили сервисе за Model Context Protocol** који демонстрирају шаблоне интеграције алата

## Следећи кораци

[Поглавље 5: Одговорна генеративна вештачка интелигенција](../05-ResponsibleGenAI/README.md)

**Одрицање од одговорности**:  
Овај документ је преведен коришћењем услуге за превођење помоћу вештачке интелигенције [Co-op Translator](https://github.com/Azure/co-op-translator). Иако се трудимо да обезбедимо тачност, молимо вас да имате у виду да аутоматски преводи могу садржати грешке или нетачности. Оригинални документ на његовом изворном језику треба сматрати меродавним извором. За критичне информације, препоручује се професионални превод од стране људи. Не преузимамо одговорност за било каква погрешна тумачења или неспоразуме који могу настати услед коришћења овог превода.