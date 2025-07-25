<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d064108b2142d32246ccbd8a42e76b4d",
  "translation_date": "2025-07-25T09:56:47+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "sw"
}
-->
# Programu ya Mitaa ya Foundry ya Amri-Mstari

>**Note**: Sura hii inajumuisha [**Mafunzo**](./TUTORIAL.md) yanayokuongoza kupitia sampuli.

Programu rahisi ya amri-mstari ya Spring Boot inayodhihirisha jinsi ya kuunganishwa na Foundry Local kwa kutumia OpenAI Java SDK.

## Utakachojifunza

- Jinsi ya kuunganisha Foundry Local na programu za Spring Boot kwa kutumia OpenAI Java SDK
- Mbinu bora za maendeleo na majaribio ya AI ya ndani

## Jedwali la Maudhui

- [Utakachojifunza](../../../../04-PracticalSamples/foundrylocal)
- [Mahitaji ya Awali](../../../../04-PracticalSamples/foundrylocal)
  - [Kusakinisha Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Uthibitishaji](../../../../04-PracticalSamples/foundrylocal)
- [Usanidi](../../../../04-PracticalSamples/foundrylocal)
- [Kuanza Haraka](../../../../04-PracticalSamples/foundrylocal)
- [Kile Programu Inafanya](../../../../04-PracticalSamples/foundrylocal)
- [Matokeo ya Sampuli](../../../../04-PracticalSamples/foundrylocal)
- [Muundo wa Kifaa](../../../../04-PracticalSamples/foundrylocal)
- [Mambo Muhimu ya Msimbo](../../../../04-PracticalSamples/foundrylocal)
  - [Uunganishaji wa OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [API ya Kukamilisha Gumzo](../../../../04-PracticalSamples/foundrylocal)
- [Kutatua Tatizo](../../../../04-PracticalSamples/foundrylocal)

## Mahitaji ya Awali

> **⚠️ Note**: Programu hii **haifanyi kazi katika devcontainer iliyotolewa** kwa sababu inahitaji Foundry Local iwe imewekwa na inafanya kazi kwenye mfumo wa mwenyeji.

### Kusakinisha Foundry Local

Kabla ya kuendesha programu hii, unahitaji kusakinisha na kuanzisha Foundry Local. Fuata hatua hizi:

1. **Hakikisha mfumo wako unakidhi mahitaji**:
   - **Mfumo wa Uendeshaji**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, au macOS
   - **Vifaa**: 
     - Kiwango cha chini: 8GB RAM, 3GB nafasi ya diski iliyo huru
     - Kinachopendekezwa: 16GB RAM, 15GB nafasi ya diski iliyo huru
   - **Mtandao**: Muunganisho wa intaneti kwa upakuaji wa awali wa modeli (hiari kwa matumizi ya nje ya mtandao)
   - **Uharakishaji (hiari)**: NVIDIA GPU (mfululizo wa 2,000 au mpya zaidi), AMD GPU (mfululizo wa 6,000 au mpya zaidi), Qualcomm Snapdragon X Elite (8GB au zaidi ya kumbukumbu), au Apple silicon
   - **Ruhusa**: Ruhusa za kiutawala kusakinisha programu kwenye kifaa chako

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

   Modeli inapakuliwa (ambayo inaweza kuchukua dakika chache, kulingana na kasi ya intaneti yako) na kisha kuanza. Foundry Local huchagua kiotomatiki toleo bora la modeli kwa mfumo wako (CUDA kwa NVIDIA GPUs, toleo la CPU vinginevyo).

4. **Jaribu modeli** kwa kuuliza swali katika terminal hiyo hiyo:

   ```bash
   Why is the sky blue?
   ```

   Unapaswa kuona jibu kutoka kwa modeli ya Phi likielezea kwa nini anga linaonekana la bluu.

### Uthibitishaji

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

> **Note**: Jina la modeli katika usanidi linapaswa kulingana na toleo maalum ambalo Foundry Local imepakua kwa mfumo wako. Unapokimbia `foundry model run phi-3.5-mini`, Foundry Local huchagua na kupakua kiotomatiki toleo bora (CUDA kwa NVIDIA GPUs, toleo la CPU vinginevyo). Tumia `foundry model list` kuona jina halisi la modeli inayopatikana katika mfano wako wa ndani.

## Kuanza Haraka

### 1. Elekea kwenye saraka ya programu ya Foundry Local
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

### Mategemezi

Programu hii inatumia OpenAI Java SDK kuwasiliana na Foundry Local. Tegemezi kuu ni:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Programu imewekwa awali kuunganishwa na Foundry Local inayofanya kazi kwenye bandari chaguo-msingi.

## Kile Programu Inafanya

Unapoendesha programu:

1. **Inaanza** kama programu ya amri-mstari (bila seva ya wavuti)
2. **Inatuma kiotomatiki** ujumbe wa majaribio: "Habari! Je, unaweza kuniambia wewe ni nini na unatumia modeli gani?"
3. **Inaonyesha jibu** kutoka Foundry Local kwenye koni
4. **Inaondoka kwa usafi** baada ya demo

## Matokeo ya Sampuli

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Muundo wa Kifaa

- **Application.java** - Programu kuu ya Spring Boot na CommandLineRunner
- **FoundryLocalService.java** - Huduma inayotumia OpenAI Java SDK kuwasiliana na Foundry Local
- Inatumia **OpenAI Java SDK** kwa miito ya API salama kwa aina
- Usawazishaji wa JSON kiotomatiki unashughulikiwa na SDK
- Usanidi safi kwa kutumia maelezo ya Spring `@Value` na `@PostConstruct`

## Mambo Muhimu ya Msimbo

### Uunganishaji wa OpenAI Java SDK

Programu inatumia OpenAI Java SDK kuunda mteja uliosanidiwa kwa Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### API ya Kukamilisha Gumzo

Kutuma maombi ya kukamilisha gumzo ni rahisi na salama kwa aina:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Kutatua Tatizo

Ikiwa unakutana na makosa ya muunganisho:
1. Thibitisha Foundry Local inafanya kazi kwenye `http://localhost:5273`
2. Angalia kwamba toleo la modeli ya Phi-3.5-mini linapatikana kwa kutumia `foundry model list`
3. Hakikisha jina la modeli katika `application.properties` linalingana na jina halisi la modeli lililoonyeshwa kwenye orodha
4. Hakikisha hakuna firewall inayozuia muunganisho

Masuala ya kawaida:
- **Modeli haipatikani**: Kimbia `foundry model run phi-3.5-mini` kupakua na kuanzisha modeli
- **Huduma haifanyi kazi**: Huduma ya Foundry Local inaweza kuwa imesimama; ianzishe tena kwa amri ya kuendesha modeli
- **Jina la modeli lisilo sahihi**: Tumia `foundry model list` kuona modeli zinazopatikana na sasisha usanidi wako ipasavyo

**Kanusho**:  
Hati hii imetafsiriwa kwa kutumia huduma ya tafsiri ya AI [Co-op Translator](https://github.com/Azure/co-op-translator). Ingawa tunajitahidi kwa usahihi, tafadhali fahamu kuwa tafsiri za kiotomatiki zinaweza kuwa na makosa au kutokuwa sahihi. Hati ya asili katika lugha yake ya awali inapaswa kuzingatiwa kama chanzo cha mamlaka. Kwa taarifa muhimu, inashauriwa kutumia huduma ya tafsiri ya binadamu ya kitaalamu. Hatutawajibika kwa maelewano au tafsiri zisizo sahihi zinazotokana na matumizi ya tafsiri hii.