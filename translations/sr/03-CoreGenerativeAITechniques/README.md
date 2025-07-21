<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T20:41:34+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "sr"
}
-->
# Основне технике генеративне вештачке интелигенције

>**Напомена**: Ово поглавље укључује детаљан [**Туторијал**](./TUTORIAL.md) који вас води кроз покретање готових примера.

## Шта ћете научити
У овом поглављу ћемо кроз практичне примере обрадити 4 основне технике генеративне вештачке интелигенције:
- Завршетке LLM-а и токове разговора
- Позивање функција
- Генерацију уз помоћ претраживања (RAG)
- Мере безбедности за одговорну вештачку интелигенцију

## Садржај

- [Шта ћете научити](../../../03-CoreGenerativeAITechniques)
- [Предуслови](../../../03-CoreGenerativeAITechniques)
- [Почетак](../../../03-CoreGenerativeAITechniques)
- [Преглед примера](../../../03-CoreGenerativeAITechniques)
  - [1. Завршетци LLM-а и токови разговора](../../../03-CoreGenerativeAITechniques)
  - [2. Функције и додаци са LLM-овима](../../../03-CoreGenerativeAITechniques)
  - [3. Генерација уз помоћ претраживања (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Демонстрација безбедности одговорне вештачке интелигенције](../../../03-CoreGenerativeAITechniques)
- [Резиме](../../../03-CoreGenerativeAITechniques)
- [Следећи кораци](../../../03-CoreGenerativeAITechniques)

## Предуслови

- Завршена подешавања из [Поглавља 2](../../../02-SetupDevEnvironment)

## Почетак

1. **Прелазак на примере**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Подешавање окружења**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Компилација и покретање примера**:  
```bash
   # Run completions example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
   
   # Run functions example  
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
   
   # Run RAG example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
   
   # Run responsible AI demo
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```  

## Преглед примера

Примери су организовани у фасцикли `examples/` са следећом структуром:

```
examples/
├── src/main/java/com/example/genai/techniques/
│   ├── completions/
│   │   └── LLMCompletionsApp.java        # Basic completions 
│   ├── functions/
│   │   └── FunctionsApp.java             # Function calling examples
│   ├── rag/
│   │   └── SimpleReaderDemo.java         # Retrieval-Augmented Generation
│   └── responsibleai/
│       └── ResponsibleGithubModels.java  # Responsible AI safety demonstration
├── document.txt                          # Sample document for RAG example
└── pom.xml                               # Maven configuration
```

### 1. Завршетци LLM-а и токови разговора
**Фајл**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Научите како да изградите конверзациону вештачку интелигенцију са стриминг одговорима и управљањем историјом разговора.

Овај пример демонстрира:
- Једноставне текстуалне завршетке са системским упутствима
- Вишеструке разговоре са управљањем историјом
- Интерактивне сесије разговора
- Конфигурацију параметара (температура, максималан број токена)

### 2. Функције и додаци са LLM-овима
**Фајл**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Проширите могућности вештачке интелигенције омогућавањем моделима приступа прилагођеним функцијама и спољним API-јевима.

Овај пример демонстрира:
- Интеграцију функције за временску прогнозу
- Имплементацију калкулаторске функције  
- Вишеструке позиве функција у једном разговору
- Дефинисање функција помоћу JSON шема

### 3. Генерација уз помоћ претраживања (RAG)
**Фајл**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Научите како да комбинујете вештачку интелигенцију са сопственим документима и изворима података за прецизне, контекстуално свесне одговоре.

Овај пример демонстрира:
- Одговарање на питања засновано на документима уз Azure OpenAI SDK
- Имплементацију RAG обрасца са GitHub моделима

**Коришћење**: Поставите питања о садржају у `document.txt` и добијте одговоре вештачке интелигенције засноване искључиво на том контексту.

### 4. Демонстрација безбедности одговорне вештачке интелигенције
**Фајл**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Погледајте како функционишу мере безбедности вештачке интелигенције тестирањем могућности филтрирања садржаја GitHub модела.

Овај пример демонстрира:
- Филтрирање садржаја за потенцијално штетне упите
- Руковање одговорима у апликацијама у складу са безбедносним мерама
- Различите категорије блокираног садржаја (насиље, говор мржње, дезинформације)
- Правилно руковање грешкама у случају кршења безбедносних мера

> **Сазнајте више**: Ово је само увод у концепте одговорне вештачке интелигенције. За више информација о етици, ублажавању пристрасности, приватности и оквирима за одговорну вештачку интелигенцију, погледајте [Поглавље 5: Одговорна генеративна вештачка интелигенција](../05-ResponsibleGenAI/README.md).

## Резиме

У овом поглављу смо истражили завршетке LLM-а и токове разговора, имплементирали позивање функција за проширење могућности вештачке интелигенције, креирали систем за генерацију уз помоћ претраживања (RAG) и демонстрирали мере безбедности одговорне вештачке интелигенције.

> **НАПОМЕНА**: Детаљније истражите уз помоћ [**Туторијала**](./TUTORIAL.md)

## Следећи кораци

[Поглавље 4: Практичне апликације и пројекти](../04-PracticalSamples/README.md)

**Одрицање од одговорности**:  
Овај документ је преведен коришћењем услуге за превођење помоћу вештачке интелигенције [Co-op Translator](https://github.com/Azure/co-op-translator). Иако настојимо да обезбедимо тачност, молимо вас да имате у виду да аутоматски преводи могу садржати грешке или нетачности. Оригинални документ на његовом изворном језику треба сматрати меродавним извором. За критичне информације препоручује се професионални превод од стране људи. Не преузимамо одговорност за било каква погрешна тумачења или неспоразуме који могу настати услед коришћења овог превода.