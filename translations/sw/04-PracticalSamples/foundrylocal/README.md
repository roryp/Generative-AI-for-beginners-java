<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T21:16:33+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "sw"
}
-->
# Programu ya Mstari wa Amri ya Foundry Local

>**Kumbuka**: Sura hii inajumuisha [**Mafunzo**](./TUTORIAL.md) yanayokuongoza jinsi ya kuendesha sampuli zilizokamilika.

Programu rahisi ya mstari wa amri ya Spring Boot inayodhihirisha jinsi ya kuunganishwa na Foundry Local kwa kutumia OpenAI Java SDK.

## Utakachojifunza

- Jinsi ya kuunganisha Foundry Local na programu za Spring Boot kwa kutumia OpenAI Java SDK
- Mbinu bora za maendeleo na majaribio ya AI ya ndani

## Jedwali la Yaliyomo

- [Utakachojifunza](../../../../04-PracticalSamples/foundrylocal)
- [Mahitaji ya Awali](../../../../04-PracticalSamples/foundrylocal)
  - [Kusakinisha Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Uhakiki](../../../../04-PracticalSamples/foundrylocal)
- [Usanidi](../../../../04-PracticalSamples/foundrylocal)
- [Kuanza Haraka](../../../../04-PracticalSamples/foundrylocal)
- [Kile Programu Inafanya](../../../../04-PracticalSamples/foundrylocal)
- [Matokeo ya Sampuli](../../../../04-PracticalSamples/foundrylocal)
- [Muundo](../../../../04-PracticalSamples/foundrylocal)
- [Mambo Muhimu ya Msimbo](../../../../04-PracticalSamples/foundrylocal)
  - [Uunganishaji wa OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [Chat Completion API](../../../../04-PracticalSamples/foundrylocal)
- [Utatuzi wa Shida](../../../../04-PracticalSamples/foundrylocal)

## Mahitaji ya Awali

> **⚠️ Kumbuka**: Programu hii **haiwezi kuendeshwa kwenye devcontainer iliyotolewa** kwa sababu inahitaji Foundry Local iwe imesakinishwa na inafanya kazi kwenye mfumo wa mwenyeji.

### Kusakinisha Foundry Local

Kabla ya kuendesha programu hii, unahitaji kusakinisha na kuanzisha Foundry Local. Fuata hatua hizi:

1. **Hakikisha mfumo wako unakidhi mahitaji**:
   - **Mfumo wa Uendeshaji**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, au macOS
   - **Vifaa**: 
     - Kiwango cha chini: 8GB RAM, 3GB nafasi ya diski iliyo huru
     - Kinachopendekezwa: 16GB RAM, 15GB nafasi ya diski iliyo huru
   - **Mtandao**: Muunganisho wa intaneti kwa upakuaji wa awali wa modeli (hiari kwa matumizi ya nje ya mtandao)
   - **Uharakishaji (hiari)**: NVIDIA GPU (mfululizo wa 2,000 au mpya zaidi), AMD GPU (mfululizo wa 6,000 au mpya zaidi), Qualcomm Snapdragon X Elite (8GB au zaidi ya kumbukumbu), au Apple silicon
   - **Ruhusa**: Haki za kiutawala kusakinisha programu kwenye kifaa chako

2. **Sakinisha Foundry Local**:
   
   **Kwa Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **Kwa macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Vinginevyo, unaweza kupakua kisakinishi kutoka [Foundry Local GitHub repository](https://github.com/microsoft/Foundry-Local).

3. **Anzisha modeli yako ya kwanza**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Modeli itapakuliwa (hii inaweza kuchukua dakika chache, kulingana na kasi ya intaneti yako) na kisha kuendeshwa. Foundry Local huchagua kiotomatiki toleo bora la modeli kwa mfumo wako (CUDA kwa NVIDIA GPUs, toleo la CPU vinginevyo).

4. **Jaribu modeli** kwa kuuliza swali kwenye terminal hiyo hiyo:

   ```bash
   Why is the sky blue?
   ```

   Unapaswa kuona jibu kutoka kwa modeli ya Phi likielezea kwa nini anga linaonekana la bluu.

### Uhakiki

Unaweza kuthibitisha kila kitu kinafanya kazi vizuri kwa amri hizi:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Pia unaweza kutembelea `http://localhost:5273` kwenye kivinjari chako ili kuona kiolesura cha wavuti cha Foundry Local.

## Usanidi

Programu inaweza kusanidiwa kupitia `application.properties`:

- `foundry.local.base-url` - URL ya msingi kwa Foundry Local (chaguo-msingi: http://localhost:5273)
- `foundry.local.model` - Modeli ya AI ya kutumia (chaguo-msingi: Phi-3.5-mini-instruct-cuda-gpu)

> **Kumbuka**: Jina la modeli kwenye usanidi linapaswa kulingana na toleo maalum ambalo Foundry Local ilipakua kwa mfumo wako. Unapoendesha `foundry model run phi-3.5-mini`, Foundry Local huchagua na kupakua kiotomatiki toleo bora (CUDA kwa NVIDIA GPUs, toleo la CPU vinginevyo). Tumia `foundry model list` kuona jina halisi la modeli inayopatikana kwenye mfano wako wa ndani.

## Kuanza Haraka

### 1. Nenda kwenye saraka ya programu ya Foundry Local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Endesha Programu

```bash
mvn spring-boot:run
```

Au jenga na endesha JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Mategemeo

Programu hii hutumia OpenAI Java SDK kuwasiliana na Foundry Local. Tegemeo kuu ni:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Programu imewekwa awali kuunganishwa na Foundry Local inayoendesha kwenye bandari chaguo-msingi.

## Kile Programu Inafanya

Unapoendesha programu:

1. **Huanzisha** kama programu ya mstari wa amri (bila seva ya wavuti)
2. **Hutuma kiotomatiki** ujumbe wa majaribio: "Hello! Can you tell me what you are and what model you're running?"
3. **Huonyesha jibu** kutoka Foundry Local kwenye terminal
4. **Hujifunga vizuri** baada ya demo

## Matokeo ya Sampuli

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Muundo

- **Application.java** - Programu kuu ya Spring Boot yenye CommandLineRunner
- **FoundryLocalService.java** - Huduma inayotumia OpenAI Java SDK kuwasiliana na Foundry Local
- Hutumia **OpenAI Java SDK** kwa miito ya API yenye usalama wa aina
- Ubadilishaji wa JSON kiotomatiki unashughulikiwa na SDK
- Usanidi safi kwa kutumia maelezo ya Spring `@Value` na `@PostConstruct`

## Mambo Muhimu ya Msimbo

### Uunganishaji wa OpenAI Java SDK

Programu hutumia OpenAI Java SDK kuunda mteja uliosanidiwa kwa Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### Chat Completion API

Kutuma maombi ya kukamilisha mazungumzo ni rahisi na salama kwa aina:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Utatuzi wa Shida

Ikiwa utaona makosa ya muunganisho:
1. Hakikisha Foundry Local inaendesha kwenye `http://localhost:5273`
2. Angalia kama toleo la modeli ya Phi-3.5-mini linapatikana kwa kutumia `foundry model list`
3. Hakikisha jina la modeli kwenye `application.properties` linakubaliana na jina halisi la modeli lililoonyeshwa kwenye orodha
4. Hakikisha hakuna kizuizi cha firewall kinachozuia muunganisho

Masuala ya kawaida:
- **Modeli haijapatikana**: Endesha `foundry model run phi-3.5-mini` kupakua na kuanzisha modeli
- **Huduma haifanyi kazi**: Huduma ya Foundry Local inaweza kuwa imesimama; ianzishe tena kwa amri ya kuendesha modeli
- **Jina la modeli si sahihi**: Tumia `foundry model list` kuona modeli zinazopatikana na sasisha usanidi wako ipasavyo

**Kanusho**:  
Hati hii imetafsiriwa kwa kutumia huduma ya kutafsiri ya AI [Co-op Translator](https://github.com/Azure/co-op-translator). Ingawa tunajitahidi kuhakikisha usahihi, tafadhali fahamu kuwa tafsiri za kiotomatiki zinaweza kuwa na makosa au kutokuwa sahihi. Hati ya asili katika lugha yake ya awali inapaswa kuzingatiwa kama chanzo cha mamlaka. Kwa taarifa muhimu, tafsiri ya kitaalamu ya binadamu inapendekezwa. Hatutawajibika kwa kutoelewana au tafsiri zisizo sahihi zinazotokana na matumizi ya tafsiri hii.