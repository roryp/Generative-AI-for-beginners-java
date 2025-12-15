<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "f787307400de59adc25a1404466a35f3",
  "translation_date": "2025-12-01T09:22:29+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "ml"
}
-->
# Foundry Local Spring Boot ട്യൂട്ടോറിയൽ

## ഉള്ളടക്കം

- [ആവശ്യകതകൾ](../../../../04-PracticalSamples/foundrylocal)
- [പ്രോജക്റ്റ് അവലോകനം](../../../../04-PracticalSamples/foundrylocal)
- [കോഡ് മനസ്സിലാക്കുക](../../../../04-PracticalSamples/foundrylocal)
  - [1. ആപ്ലിക്കേഷൻ കോൺഫിഗറേഷൻ (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. പ്രധാന ആപ്ലിക്കേഷൻ ക്ലാസ് (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI സർവീസ് ലെയർ (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. പ്രോജക്റ്റ് ഡിപെൻഡൻസികൾ (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [എല്ലാം ഒരുമിച്ച് പ്രവർത്തിക്കുന്നത് എങ്ങനെ](../../../../04-PracticalSamples/foundrylocal)
- [Foundry Local സജ്ജമാക്കൽ](../../../../04-PracticalSamples/foundrylocal)
- [ആപ്ലിക്കേഷൻ പ്രവർത്തിപ്പിക്കൽ](../../../../04-PracticalSamples/foundrylocal)
- [പ്രതീക്ഷിക്കുന്ന ഔട്ട്പുട്ട്](../../../../04-PracticalSamples/foundrylocal)
- [അടുത്ത ഘട്ടങ്ങൾ](../../../../04-PracticalSamples/foundrylocal)
- [പ്രശ്നപരിഹാരം](../../../../04-PracticalSamples/foundrylocal)

## ആവശ്യകതകൾ

ഈ ട്യൂട്ടോറിയൽ ആരംഭിക്കുന്നതിന് മുമ്പ്, നിങ്ങൾക്ക് താഴെ പറയുന്നവ ഉണ്ടെന്ന് ഉറപ്പാക്കുക:

- **Java 21 അല്ലെങ്കിൽ അതിനുമുകളിൽ** നിങ്ങളുടെ സിസ്റ്റത്തിൽ ഇൻസ്റ്റാൾ ചെയ്തിരിക്കണം
- **Maven 3.6+** പ്രോജക്റ്റ് ബിൽഡ് ചെയ്യാൻ
- **Foundry Local** ഇൻസ്റ്റാൾ ചെയ്ത് പ്രവർത്തനക്ഷമമാക്കുക

### **Foundry Local ഇൻസ്റ്റാൾ ചെയ്യുക:**

```bash
# വിൻഡോസ്
winget install Microsoft.FoundryLocal

# മാക്‌ഒഎസ് (ഇൻസ്റ്റാൾ ചെയ്ത ശേഷം)
foundry model run phi-3.5-mini
```


## പ്രോജക്റ്റ് അവലോകനം

ഈ പ്രോജക്റ്റ് നാല് പ്രധാന ഘടകങ്ങൾ ഉൾക്കൊള്ളുന്നു:

1. **Application.java** - പ്രധാന Spring Boot ആപ്ലിക്കേഷൻ എൻട്രി പോയിന്റ്
2. **FoundryLocalService.java** - AI കമ്മ്യൂണിക്കേഷൻ കൈകാര്യം ചെയ്യുന്ന സർവീസ് ലെയർ
3. **application.properties** - Foundry Local കണക്ഷനുള്ള കോൺഫിഗറേഷൻ
4. **pom.xml** - Maven ഡിപെൻഡൻസികൾ, പ്രോജക്റ്റ് കോൺഫിഗറേഷൻ

## കോഡ് മനസ്സിലാക്കുക

### 1. ആപ്ലിക്കേഷൻ കോൺഫിഗറേഷൻ (application.properties)

**ഫയൽ:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**ഇത് എന്താണ് ചെയ്യുന്നത്:**
- **base-url**: Foundry Local പ്രവർത്തിക്കുന്ന സ്ഥലം വ്യക്തമാക്കുന്നു, `/v1` പാത OpenAI API അനുയോജ്യതയ്ക്കായി ഉൾക്കൊള്ളുന്നു. **ശ്രദ്ധിക്കുക**: Foundry Local ഡൈനാമിക് ആയി പോർട്ട് അനുവദിക്കുന്നു, അതിനാൽ `foundry service status` ഉപയോഗിച്ച് നിങ്ങളുടെ യഥാർത്ഥ പോർട്ട് പരിശോധിക്കുക.
- **model**: ടെക്സ്റ്റ് ജനറേഷനായി ഉപയോഗിക്കുന്ന AI മോഡലിന്റെ പേര്, പതിപ്പ് നമ്പർ ഉൾപ്പെടെ (ഉദാ, `:1`). `foundry model list` ഉപയോഗിച്ച് ലഭ്യമായ മോഡലുകൾ അവരുടെ കൃത്യമായ IDs കാണുക.

**പ്രധാന ആശയം:** Spring Boot ഈ പ്രോപ്പർട്ടികൾ സ്വയം ലോഡ് ചെയ്യുകയും `@Value` അനോട്ടേഷൻ ഉപയോഗിച്ച് നിങ്ങളുടെ ആപ്ലിക്കേഷനിൽ ലഭ്യമാക്കുകയും ചെയ്യുന്നു.

### 2. പ്രധാന ആപ്ലിക്കേഷൻ ക്ലാസ് (Application.java)

**ഫയൽ:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // വെബ് സെർവർ ആവശ്യമില്ല
        app.run(args);
    }
```


**ഇത് എന്താണ് ചെയ്യുന്നത്:**
- `@SpringBootApplication` Spring Boot ഓട്ടോ-കോൺഫിഗറേഷൻ പ്രാപ്തമാക്കുന്നു
- `WebApplicationType.NONE` Spring ഇത് ഒരു കമാൻഡ്-ലൈൻ ആപ്ലിക്കേഷനാണെന്ന്, വെബ് സെർവർ അല്ലെന്ന് വ്യക്തമാക്കുന്നു
- പ്രധാന മെത്തഡ് Spring ആപ്ലിക്കേഷൻ ആരംഭിക്കുന്നു

**ഡെമോ റണ്ണർ:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        System.out.println("Calling Foundry Local service...");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
        System.out.println("=========================");
    };
}
```


**ഇത് എന്താണ് ചെയ്യുന്നത്:**
- `@Bean` Spring കൈകാര്യം ചെയ്യുന്ന ഒരു ഘടകം സൃഷ്ടിക്കുന്നു
- `CommandLineRunner` Spring Boot ആരംഭിച്ചതിന് ശേഷം കോഡ് പ്രവർത്തിപ്പിക്കുന്നു
- `foundryLocalService` Spring സ്വയം ഇൻജക്റ്റ് ചെയ്യുന്നു (dependency injection)
- AI-യിലേക്ക് ഒരു ടെസ്റ്റ് സന്ദേശം അയയ്ക്കുകയും പ്രതികരണം പ്രദർശിപ്പിക്കുകയും ചെയ്യുന്നു

### 3. AI സർവീസ് ലെയർ (FoundryLocalService.java)

**ഫയൽ:** `src/main/java/com/example/FoundryLocalService.java`

#### കോൺഫിഗറേഷൻ ഇൻജക്ഷൻ:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**ഇത് എന്താണ് ചെയ്യുന്നത്:**
- `@Service` Spring-ന് ഈ ക്ലാസ് ബിസിനസ് ലജിക് നൽകുന്നു എന്ന് വ്യക്തമാക്കുന്നു
- `@Value` application.properties-ൽ നിന്ന് കോൺഫിഗറേഷൻ മൂല്യങ്ങൾ ഇൻജക്റ്റ് ചെയ്യുന്നു
- `:default-value` സിന്റാക്സ് പ്രോപ്പർട്ടികൾ സെറ്റ് ചെയ്യാത്ത പക്ഷം fallback മൂല്യങ്ങൾ നൽകുന്നു

#### ക്ലയന്റ് ഇൻീഷ്യലൈസേഷൻ:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // അടിസ്ഥാന URL ഇതിനകം /v1 കോൺഫിഗറേഷനിൽ ഉൾക്കൊള്ളുന്നു
            .apiKey("not-needed")            // പ്രാദേശിക സെർവറിന് യഥാർത്ഥ API കീ ആവശ്യമില്ല
            .build();
}
```


**ഇത് എന്താണ് ചെയ്യുന്നത്:**
- `@PostConstruct` Spring ഈ സർവീസ് സൃഷ്ടിച്ചതിന് ശേഷം ഈ മെത്തഡ് പ്രവർത്തിപ്പിക്കുന്നു
- നിങ്ങളുടെ ലോക്കൽ Foundry Local ഇൻസ്റ്റൻസിലേക്ക് പോയിന്റ് ചെയ്യുന്ന OpenAI ക്ലയന്റ് സൃഷ്ടിക്കുന്നു
- `application.properties`-ൽ നിന്ന് base URL ഇതിനകം `/v1` ഉൾക്കൊള്ളുന്നു OpenAI API അനുയോജ്യതയ്ക്കായി
- API കീ "not-needed" ആയി സെറ്റ് ചെയ്യുന്നു, കാരണം ലോക്കൽ ഡെവലപ്മെന്റിന് authentication ആവശ്യമില്ല

#### ചാറ്റ് മെത്തഡ്:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // ഏത് AI മോഡൽ ഉപയോഗിക്കണം
                .addUserMessage(message)         // നിങ്ങളുടെ ചോദ്യവും/പ്രോംപ്റ്റും
                .maxCompletionTokens(150)        // പ്രതികരണത്തിന്റെ നീളം പരിമിതപ്പെടുത്തുക
                .temperature(0.7)                // സൃഷ്ടിപരത്വം നിയന്ത്രിക്കുക (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // API ഫലത്തിൽ നിന്ന് AIയുടെ പ്രതികരണം എടുക്കുക
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```


**ഇത് എന്താണ് ചെയ്യുന്നത്:**
- **ChatCompletionCreateParams**: AI അഭ്യർത്ഥന കോൺഫിഗർ ചെയ്യുന്നു
  - `model`: ഉപയോഗിക്കുന്ന AI മോഡൽ വ്യക്തമാക്കുന്നു (Foundry Local-ൽ നിന്ന് കൃത്യമായ ID ഉപയോഗിക്കുക)
  - `addUserMessage`: നിങ്ങളുടെ സന്ദേശം സംഭാഷണത്തിൽ ചേർക്കുന്നു
  - `maxCompletionTokens`: പ്രതികരണത്തിന്റെ ദൈർഘ്യം പരിമിതപ്പെടുത്തുന്നു (സ്രോതസ്സ് സംരക്ഷിക്കുന്നു)
  - `temperature`: randomness നിയന്ത്രിക്കുന്നു (0.0 = നിർണായകമായ, 1.0 = സൃഷ്ടിപരമായ)
- **API Call**: Foundry Local-ലേക്ക് അഭ്യർത്ഥന അയയ്ക്കുന്നു
- **Response Handling**: AI-യുടെ ടെക്സ്റ്റ് പ്രതികരണം സുരക്ഷിതമായി എക്സ്ട്രാക്റ്റ് ചെയ്യുന്നു
- **Error Handling**: സഹായകരമായ എറർ സന്ദേശങ്ങളോടെ എക്സെപ്ഷനുകൾ റാപ്പ് ചെയ്യുന്നു

### 4. പ്രോജക്റ്റ് ഡിപെൻഡൻസികൾ (pom.xml)

**പ്രധാന ഡിപെൻഡൻസികൾ:**

```xml
<!-- Spring Boot - Application framework -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>${spring-boot.version}</version>
</dependency>

<!-- OpenAI Java SDK - For AI API calls -->
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>

<!-- Jackson - JSON processing -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.0</version>
</dependency>
```


**ഇത് എന്താണ് ചെയ്യുന്നത്:**
- **spring-boot-starter**: Spring Boot-ന്റെ കോർ ഫംഗ്ഷനാലിറ്റി നൽകുന്നു
- **openai-java**: API കമ്മ്യൂണിക്കേഷനായി OpenAI Java SDK
- **jackson-databind**: API കോളുകൾക്കായി JSON serialization/deserialization കൈകാര്യം ചെയ്യുന്നു

## എല്ലാം ഒരുമിച്ച് പ്രവർത്തിക്കുന്നത് എങ്ങനെ

ആപ്ലിക്കേഷൻ പ്രവർത്തിപ്പിക്കുമ്പോൾ മുഴുവൻ പ്രവാഹം ഇതാണ്:

1. **സ്റ്റാർട്ടപ്പ്**: Spring Boot ആരംഭിച്ച് `application.properties` വായിക്കുന്നു
2. **സർവീസ് സൃഷ്ടിക്കൽ**: Spring `FoundryLocalService` സൃഷ്ടിച്ച് കോൺഫിഗറേഷൻ മൂല്യങ്ങൾ ഇൻജക്റ്റ് ചെയ്യുന്നു
3. **ക്ലയന്റ് സജ്ജമാക്കൽ**: `@PostConstruct` OpenAI ക്ലയന്റ് Foundry Local-ലേക്ക് കണക്ട് ചെയ്യാൻ ഇൻീഷ്യലൈസ് ചെയ്യുന്നു
4. **ഡെമോ എക്സിക്യൂഷൻ**: `CommandLineRunner` സ്റ്റാർട്ടപ്പിന് ശേഷം പ്രവർത്തിക്കുന്നു
5. **AI കോളുകൾ**: ഡെമോ `foundryLocalService.chat()` ടെസ്റ്റ് സന്ദേശത്തോടെ വിളിക്കുന്നു
6. **API അഭ്യർത്ഥന**: OpenAI- അനുയോജ്യമായ അഭ്യർത്ഥന Foundry Local-ലേക്ക് അയയ്ക്കുന്നു
7. **പ്രതികരണ പ്രോസസ്സിംഗ്**: AI-യുടെ പ്രതികരണം എക്സ്ട്രാക്റ്റ് ചെയ്ത് തിരികെ നൽകുന്നു
8. **പ്രദർശനം**: ആപ്ലിക്കേഷൻ പ്രതികരണം പ്രിന്റ് ചെയ്ത് എക്സിറ്റ് ചെയ്യുന്നു

## Foundry Local സജ്ജമാക്കൽ

Foundry Local സജ്ജമാക്കാൻ, ഈ ഘട്ടങ്ങൾ പിന്തുടരുക:

1. **Foundry Local ഇൻസ്റ്റാൾ ചെയ്യുക** [ആവശ്യകതകൾ](../../../../04-PracticalSamples/foundrylocal) വിഭാഗത്തിലെ നിർദ്ദേശങ്ങൾ ഉപയോഗിച്ച്.

2. **ഡൈനാമിക് ആയി അനുവദിച്ച പോർട്ട് പരിശോധിക്കുക**. Foundry Local ആരംഭിക്കുമ്പോൾ സ്വയം പോർട്ട് അനുവദിക്കുന്നു. നിങ്ങളുടെ പോർട്ട് കണ്ടെത്താൻ:
   ```bash
   foundry service status
   ```
   
   **ഓപ്ഷണൽ**: നിങ്ങൾക്ക് ഒരു പ്രത്യേക പോർട്ട് (ഉദാ, 5273) ഉപയോഗിക്കാൻ ഇഷ്ടമുണ്ടെങ്കിൽ, അത് മാനുവലായി കോൺഫിഗർ ചെയ്യാം:
   ```bash
   foundry service set --port 5273
   ```


3. **നിങ്ങൾ ഉപയോഗിക്കാൻ ആഗ്രഹിക്കുന്ന AI മോഡൽ** ഡൗൺലോഡ് ചെയ്യുക, ഉദാ, `phi-3.5-mini`, താഴെ കാണുന്ന കമാൻഡ് ഉപയോഗിച്ച്:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **application.properties** ഫയൽ നിങ്ങളുടെ Foundry Local സെറ്റിംഗുകൾക്ക് അനുയോജ്യമാക്കുക:
   - `base-url`-ൽ പോർട്ട് അപ്ഡേറ്റ് ചെയ്യുക (ഘട്ടം 2-ൽ നിന്ന്), `/v1` അവസാനം ഉൾക്കൊള്ളുന്നുവെന്ന് ഉറപ്പാക്കുക
   - മോഡൽ നാമം പതിപ്പ് നമ്പർ ഉൾക്കൊള്ളുന്നുവെന്ന് ഉറപ്പാക്കുക (`foundry model list` ഉപയോഗിച്ച് പരിശോധിക്കുക)

   ഉദാഹരണം:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## ആപ്ലിക്കേഷൻ പ്രവർത്തിപ്പിക്കൽ

### ഘട്ടം 1: Foundry Local ആരംഭിക്കുക
```bash
foundry model run phi-3.5-mini
```


### ഘട്ടം 2: ആപ്ലിക്കേഷൻ ബിൽഡ് ചെയ്ത് പ്രവർത്തിപ്പിക്കുക
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```


## പ്രതീക്ഷിക്കുന്ന ഔട്ട്പുട്ട്

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```


## അടുത്ത ഘട്ടങ്ങൾ

കൂടുതൽ ഉദാഹരണങ്ങൾക്കായി, [Chapter 04: Practical samples](../README.md) കാണുക

## പ്രശ്നപരിഹാരം

### സാധാരണ പ്രശ്നങ്ങൾ

**"Connection refused" അല്ലെങ്കിൽ "Service unavailable"**
- Foundry Local പ്രവർത്തനക്ഷമമാണെന്ന് ഉറപ്പാക്കുക: `foundry model list`
- Foundry Local ഉപയോഗിക്കുന്ന യഥാർത്ഥ പോർട്ട് പരിശോധിക്കുക: `foundry service status`
- നിങ്ങളുടെ `application.properties` ശരിയായ പോർട്ടോടെ അപ്ഡേറ്റ് ചെയ്യുക, URL `/v1`-ൽ അവസാനിക്കുന്നുവെന്ന് ഉറപ്പാക്കുക
- അല്ലെങ്കിൽ, ഒരു പ്രത്യേക പോർട്ട് സെറ്റ് ചെയ്യുക: `foundry service set --port 5273`
- Foundry Local വീണ്ടും ആരംഭിക്കാൻ ശ്രമിക്കുക: `foundry model run phi-3.5-mini`

**"Model not found" അല്ലെങ്കിൽ "404 Not Found" എററുകൾ**
- കൃത്യമായ IDs-ഉടെ ലഭ്യമായ മോഡലുകൾ പരിശോധിക്കുക: `foundry model list`
- `application.properties`-ൽ മോഡൽ നാമം കൃത്യമായി അപ്ഡേറ്റ് ചെയ്യുക, പതിപ്പ് നമ്പർ ഉൾക്കൊള്ളുന്നുവെന്ന് ഉറപ്പാക്കുക (ഉദാ, `Phi-3.5-mini-instruct-cuda-gpu:1`)
- `base-url` `/v1`-ൽ അവസാനിക്കുന്നുവെന്ന് ഉറപ്പാക്കുക: `http://localhost:5273/v1`
- ആവശ്യമെങ്കിൽ മോഡൽ ഡൗൺലോഡ് ചെയ്യുക: `foundry model run phi-3.5-mini`

**"400 Bad Request" എററുകൾ**
- base URL `/v1` ഉൾക്കൊള്ളുന്നുവെന്ന് ഉറപ്പാക്കുക: `http://localhost:5273/v1`
- മോഡൽ ID `foundry model list`-ൽ കൃത്യമായി കാണുന്നതുമായി പൊരുത്തപ്പെടുന്നുവെന്ന് ഉറപ്പാക്കുക
- നിങ്ങളുടെ കോഡിൽ `maxCompletionTokens()` ഉപയോഗിക്കുന്നുവെന്ന് ഉറപ്പാക്കുക (deprecated ആയ `maxTokens()` ഉപയോഗിക്കരുത്)

**Maven കംപൈലേഷൻ എററുകൾ**
- Java 21 അല്ലെങ്കിൽ അതിനുമുകളിൽ ഉറപ്പാക്കുക: `java -version`
- ക്ലീൻ ചെയ്ത് വീണ്ടും ബിൽഡ് ചെയ്യുക: `mvn clean compile`
- ഡിപെൻഡൻസി ഡൗൺലോഡുകൾക്കായി ഇന്റർനെറ്റ് കണക്ഷൻ പരിശോധിക്കുക

**ആപ്ലിക്കേഷൻ ആരംഭിക്കുന്നു പക്ഷേ ഔട്ട്പുട്ട് ഇല്ല**
- Foundry Local പ്രതികരിക്കുന്നുണ്ടെന്ന് ഉറപ്പാക്കുക: `http://localhost:5273/v1/models` പരിശോധിക്കുക അല്ലെങ്കിൽ `foundry service status` പ്രവർത്തിപ്പിക്കുക
- പ്രത്യേക എറർ സന്ദേശങ്ങൾക്കായി ആപ്ലിക്കേഷൻ ലോഗുകൾ പരിശോധിക്കുക
- മോഡൽ പൂർണ്ണമായും ലോഡ് ചെയ്ത് പ്രവർത്തനക്ഷമമാണെന്ന് ഉറപ്പാക്കുക

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**അറിയിപ്പ്**:  
ഈ രേഖ AI വിവർത്തന സേവനമായ [Co-op Translator](https://github.com/Azure/co-op-translator) ഉപയോഗിച്ച് വിവർത്തനം ചെയ്തതാണ്. ഞങ്ങൾ കൃത്യതയ്ക്കായി ശ്രമിക്കുന്നുവെങ്കിലും, ഓട്ടോമേറ്റഡ് വിവർത്തനങ്ങളിൽ പിഴവുകൾ അല്ലെങ്കിൽ തെറ്റായ വിവരങ്ങൾ ഉണ്ടാകാൻ സാധ്യതയുണ്ട്. അതിന്റെ സ്വാഭാവിക ഭാഷയിലുള്ള മൂല രേഖയാണ് പ്രാമാണികമായ ഉറവിടമായി പരിഗണിക്കേണ്ടത്. നിർണായകമായ വിവരങ്ങൾക്ക്, പ്രൊഫഷണൽ മനുഷ്യ വിവർത്തനം ശുപാർശ ചെയ്യുന്നു. ഈ വിവർത്തനം ഉപയോഗിച്ച് ഉണ്ടാകുന്ന തെറ്റിദ്ധാരണകൾ അല്ലെങ്കിൽ തെറ്റായ വ്യാഖ്യാനങ്ങൾക്കായി ഞങ്ങൾ ഉത്തരവാദികളല്ല.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->