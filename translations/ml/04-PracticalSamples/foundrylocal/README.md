# ഫൗണ്ട്രി ലോക്കിൾ സ്പ്രിംഗ് ബൂട്ട് ട്യൂട്ടോറിയൽ

## ഉള്ളടക്കങ്ങൾ

- [മുൻകൂട്ടി വേണമുള്ളവ](#മുൻകൂട്ടി-വേണമുള്ളവ)
- [പ്രോജക്ട് അവലോകനം](#പ്രോജക്ട്-അവലോകനം)
- [കോഡ് മനസിലാക്കൽ](#കോഡ്-മനസിലാക്കൽ)
  - [1. അപ്ലിക്കേഷൻ കോൺഫിഗറേഷൻ (application.properties)](#1-അപ്ലിക്കേഷൻ-കോൺഫിഗറേഷൻ-applicationproperties)
  - [2. പ്രധാന അപ്ലിക്കേഷൻ ക്ലാസ് (Application.java)](#2-പ്രധാന-അപ്ലിക്കേഷൻ-ക്ലാസ്-applicationjava)
  - [3. എഐ സർവീസ് ലെയർ (FoundryLocalService.java)](#3-എഐ-സർവീസ്-ലെയർ-foundrylocalservicejava)
  - [4. പ്രോജക്ട് ആശ്രിതവിവരങ്ങൾ (pom.xml)](#4-പ്രോജക്ട്-ആശ്രിതവിവരങ്ങൾ-pomxml)
- [എങ്ങനെ എല്ലാം ചേർന്ന് പ്രവർത്തിക്കുന്നു](#എങ്ങനെ-എല്ലാം-ചേർന്ന്-പ്രവർത്തിക്കുന്നു)
- [ഫൗണ്ട്രി ലോക്കൽ സജ്ജീകരിക്കൽ](#ഫൗണ്ട്രി-ലോക്കൽ-സജ്ജീകരിക്കൽ)
- [അപ്ലിക്കേഷൻ പ്രവർത്തിപ്പിക്കൽ](#അപ്ലിക്കേഷൻ-പ്രവർത്തിപ്പിക്കൽ)
- [കാത്തിരിക്കുന്ന ഔട്ട്പുട്ട്](#പ്രതീക്ഷിച്ച-ഔട്ട്പുട്ട്)
- [അടുത്ത ഘട്ടങ്ങൾ](#അടുത്ത-ഘട്ടങ്ങൾ)
- [സമ്മസ്യ പരിഹാരങ്ങൾ](#സമസ്യ-പരിഹാരങ്ങൾ)


## മുൻകൂട്ടി വേണമുള്ളവ

ഈ ട്യൂട്ടോറിയൽ ആരംഭിക്കുന്നതിന് മുൻപ്, നിങ്ങൾക്കുണ്ടാകണം:

- **ജാവ 21 അല്ലെങ്കിൽ അതിലോ അതിൽ മുകളിൽ** നിങ്ങളുടെ സിസ്റ്റം ഇൻസ്റ്റാൾ ചെയ്തിരിക്കണം
- **മേവൻ 3.6+** പ്രോജക്റ്റ് നിർമ്മിക്കാൻ
- **ഫൗണ്ട്രി ലോക്കൽ** ഇൻസ്റ്റാൾ ചെയ്തും പ്രവർത്തിക്കുന്നതായും

### **ഫൗണ്ട്രി ലോക്കൽ ഇൻസ്റ്റാൾ ചെയ്യുക:**

> **നോട്ട്:** ഫൗണ്ട്രി ലോക്കൽ CLI സോഫ്റ്റ്‌വെയർ **Windows**-ഉം **macOS**-ഉം മാത്രമേ ലഭ്യമാകൂ. ലിനക്സ് അനുബന്ധം [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust) വഴിയിലാണ്.

```bash
# വിൻഡോസ്
winget install Microsoft.FoundryLocal

# മാക്‌ഓఎస్
brew tap microsoft/foundrylocal
brew install foundrylocal
```

ഇൻസ്റ്റാളേഷൻ സ്ഥിരീകരിക്കുക:
```bash
foundry --version
```

## പ്രോജക്ട് അവലോകനം

ഈ പ്രോജക്ടിൽ നാല് പ്രധാന ഘടകങ്ങളുണ്ട്:

1. **Application.java** - പ്രധാന സ്പ്രിംഗ് ബൂട്ട് അപ്ലിക്കേഷൻ എൻട്രി പോയിന്റ്
2. **FoundryLocalService.java** - എഐ കമ്മ്യൂണിക്കേഷൻ കൈകാര്യം ചെയ്യുന്ന സർവീസ് ലെയർ
3. **application.properties** - ഫൗണ്ട്രി ലോക്കൽ കണക്ഷൻ കോൺഫിഗറേഷൻ
4. **pom.xml** - മേവൻ ആശ്രിതങ്ങളും പ്രോജക്ട് കോൺഫിഗറേഷനുകളും

## കോഡ് മനസിലാക്കൽ

### 1. അപ്ലിക്കേഷൻ കോൺഫിഗറേഷൻ (application.properties)

**ഫയൽ:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**ഇതിന്റെ പ്രവർത്തനം:**
- **base-url**: ഫൗണ്ട്രി ലോക്കൽ എവിടെയാണ് പ്രവർത്തിക്കുന്നത് എന്ന് വ്യക്തമാക്കുന്നു, OpenAI API യുമായി പൊരുത്തപ്പെടാൻ `/v1` പാത്തും ഉൾപ്പെടുന്നു. ഡിഫോൾട്ട് പോർട്ട് `5273` ആണ്. പോർട്ട് വ്യത്യസ്ഥമെങ്കിൽ, അത് `foundry service status` ഉപയോഗിച്ച് പരിശോധിക്കുക.
- **model** (ഐച്ഛികം): ടെക്സ്റ്റ് ജനറേഷനായി ഉപയോഗിക്കുന്ന എഐ മോഡലിന്റെ പേര്. **സ്വാഭാവികമായി, അപ്ലിക്കേഷൻ Foundry Local `/v1/models` എൻഡ്‌പോയിന്റിൽ സ്റ്റാർട്ടപ്പിൽ ക്വറി ചെയ്ത് മോഡൽ സ്വയം കണ്ടെത്തുന്നു**, അതിനാൽ ഈ സെറ്റിങ്ങ് നിർബന്ധമല്ല. നിങ്ങൾക്ക് ഇത് വ്യക്തമായി സജ്ജീകരിക്കാം സ്വയം തിരിച്ചറിയൽ മറികടക്കുന്നതിനായി.

**പ്രധാന ആശയം:** സ്പ്രിംഗ് ബൂട്ട് ഈ പ്രോപർട്ടീസുകൾ സ്വയം ലോഡ് ചെയ്ത് `@Value` അനോട്ടേഷൻ ഉപയോഗിച്ച് അപ്ലിക്കേഷനിൽ ലഭ്യമാക്കുന്നു.

### 2. പ്രധാന അപ്ലിക്കേഷൻ ക്ലാസ് (Application.java)

**ഫയൽ:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // വെബ് സർവർ ആവശ്യമില്ല
        app.run(args);
    }
```

**ഇതിന്റെ പ്രവർത്തനം:**
- `@SpringBootApplication` സ്പ്രിംഗ് ബൂട്ട് ഓട്ടോ-കോൺഫിഗറേഷൻ പ്രാക്ടീസ് ചെയ്യുന്നു
- `WebApplicationType.NONE` ഉപയോഗിച്ച് ഇത് വെബ് സെർവർ അല്ലാതെ കമാൻഡ്-ലൈൻ ആപ്പ് ആണെന്ന് വ്യക്തമാക്കുന്നു
- പ്രധാന പ്രതീതി സ്പ്രിംഗ് അപ്ലിക്കേഷൻ തുടങ്ങുന്നു

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

**ഇതിന്റെ പ്രവർത്തനം:**
- `@Bean` സ്പ്രിംഗ് മാനേജുചെയ്യുന്ന ഘടകം സൃഷ്‌ടിക്കുന്നു
- `CommandLineRunner` സ്പ്രിംഗ് ബൂട്ട് ആരംഭിച്ചതിന് ശേഷം കോഡ് Executes ചെയ്യുന്നു
- `foundryLocalService` സ്വയം സ്പ്രിങിൽ നിന്നു ഇഞ്ചെക്ട് ചെയ്യപ്പെട്ടിരിക്കുന്നു (ഡিপെൻഡൻസി ഇഞ്ചെക്ഷൻ)
- എഐ-യിലേക്ക് ടെസ്റ്റ് മെസേജ് അയച്ച് മറുപടി കാണിക്കുന്നു

### 3. എഐ സർവീസ് ലെയർ (FoundryLocalService.java)

**ഫയൽ:** `src/main/java/com/example/FoundryLocalService.java`

#### കോൺഫിഗറേഷൻ ഇഞ്ചെക്ഷൻ:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // ശൂന്യമായാൽ സ്വയം കണ്ടെത്തും
```

**ഇതിന്റെ പ്രവർത്തനം:**
- `@Service` സ്പ്രിംഗ്-ൽ ഈ ക്ലാസ് ബിസിനസ് ലൊജിക് നൽകുന്നുവെന്ന് സൂചിപ്പിക്കുന്നു
- `@Value` application.properties ഫയലിൽ നിന്നും കോൺഫിഗറേഷൻ മൂല്യങ്ങൾ ഉൾപ്പെടുത്തുന്നു
- മോഡൽ ഡിഫോൾട്ട് ആയി ശൂന്യമാകുന്നു, ക്കോണ്ടോ ഫൗണ്ട്രി ലോക്കലിൽ നിന്നുള്ള **സ്വയം തിരിച്ചറിയൽ** സ്റ്റാർട്ടപ്പിൽ പ്രവർത്തിപ്പിക്കുന്നു. അതായത് ഫൗണ്ട്രി ലോക്കലിലെ ഏത് മോഡലും മ্যানുവൽ കോൺഫിഗറേഷൻ കൂടാതെ പ്രവർത്തിക്കും.

#### ക്ലയന്റ് ഇൻഷിയലൈസേഷൻ:
```java
@PostConstruct
public void init() {
    // വ്യക്തമാക്കി കൺഫിഗർ ചെയ്തിട്ടില്ലെങ്കിൽ ഫൗണ്ടറി ലോക്കലിൽ നിന്നായി മോഡൽ സ്വയം കണ്ടെത്തുക
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // ബേസ് URL ഇതിനകം /v1 കൺഫിഗറേഷനിൽ ഉൾപ്പെടുത്തിയിട്ടുണ്ട്
            .apiKey("not-needed")            // ലോക്കൽ സർവർക്ക് വാസ്തവ API കീ ആവശ്യമായില്ല
            .build();
}
```

**ഇതിന്റെ പ്രവർത്തനം:**
- `@PostConstruct` സ്പ്രിംഗ് സർവീസ് സൃഷ്ടിച്ചതിനു ശേഷം ഈ മെത്തഡ് ഓടുന്നു
- മോഡൽ സജ്ജീകരിച്ചിട്ടില്ലെങ്കിൽ, ഫൗണ്ട്രി ലോക്കലിന്റെ `/v1/models` എൻഡ്‌പോയിന്റിൽ ക്വറി ചെയ്ത് ആദ്യ ലോഡ് ചെയ്ത മോഡൽ തിരഞ്ഞെടുക്കുന്നു
- നിങ്ങളുടെ ലോക്കൽ ഫൗണ്ട്രി ലോക്കൽ ഇൻസ്റ്റൻസിലേക്ക് പോയിന്റ് ചെയ്യുന്ന OpenAI ക്ലയന്റ് സൃഷ്ടിക്കുന്നു
- `application.properties` നിൽക്കുന്ന ബേസ് URL ഇതിനകം OpenAI API പൊരുത്തം നൽകാൻ `/v1` ഉൾക്കൊള്ളുന്നു
- API കീ "not-needed" ആയി സജ്ജീകരിച്ചിരിക്കുന്നു, കാരണം ലോക്കൽ ഡെവലപ്മെന്റ് ഓથൻറ്റിക്കേഷനില്ലാതെ പ്രവർത്തിക്കും

#### ചാറ്റ് മെത്തഡ്:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // ഏത് AI മോഡൽ ഉപയോഗിക്കാം
                .addUserMessage(message)         // നിങ്ങളുടെ ചോദ്യം/പ്രോംപ്റ്റ്
                .maxCompletionTokens(150)        // പ്രതികരണ ദൈർഘ്യം നിയന്ത്രിക്കുക
                .temperature(0.7)                // സൃഷ്ടിപ്രവണത നിയന്ത്രിക്കുക (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // API ഫലത്തിൽ നിന്ന് AIയുടെ പ്രതികരണം എഴുതി എടുക്കുക
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**ഇതിന്റെ പ്രവർത്തനം:**
- **ChatCompletionCreateParams**: എഐ അഭ്യർത്ഥനയ്ക്ക് ക്രമീകരണം നൽകുന്നു
  - `model`: ഉപയോഗിക്കാൻ ആവശ്യമുള്ള AI മോഡൽ നാമം (തിരിച്ചറിയൽ `foundry model list`-ലെ കൃത്യ ഐഡി ക്രമത്തിൽ)
  - `addUserMessage`: സംഭാഷണത്തിൽ നിങ്ങളുടെ സന്ദേശം ചേർക്കുന്നു
  - `maxCompletionTokens`: മറുപടി ദൈർഘ്യം നിയന്ത്രിക്കുന്നു (സാമഗ്രി സംരക്ഷിക്കുക)
  - `temperature`: ചാനൽ സാഹചര്യങ്ങളിലെ റാൻഡം കോണ്ട്രോൾ (0.0 = നിർണ്ണായക, 1.0 = സൃഷ്ടിപരമായ)
- **API കോൾ**: അഭ്യർത്ഥനം ഫൗണ്ട്രി ലോക്കലിലേക്ക് അയയ്ക്കുന്നു
- **റിസ്പോൺസ് ഹാൻഡ്ലിംഗ്**: എഐയുടെ ടെക്സ്റ്റ് മറുപടി സുരക്ഷിതമായി എറക്ട് ചെയ്യുന്നു
- **പിശക് കൈകാര്യം ചെയ്യൽ**: സഹായകരമായ പിശക് സന്ദേശങ്ങളുമായി എക്സെപ്ഷനുകൾ പാക്ക് ചെയ്യുന്നു

### 4. പ്രോജക്ട് ആശ്രിതവിവരങ്ങൾ (pom.xml)

**പ്രധാന ആശ്രിതങ്ങൾ:**

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

**ഇവ നൽകുന്നത്:**
- **spring-boot-starter**: സ്പ്രിംഗ് ബൂട്ട് ഫംഗ്ഷണാലിറ്റികൾ സജ്ജമാക്കുന്നു
- **openai-java**: ഔദ്യോഗിക OpenAI ജാവ SDK API കമ്മ്യൂണിക്കേഷനു
- **jackson-databind**: API കോൾ JSON ശ്രേണീകരണ/ഡിസ്‌എറിയലൈസേഷൻ കൈകാര്യം ചെയ്യുന്നു

## എങ്ങനെ എല്ലാം ചേർന്ന് പ്രവർത്തിക്കുന്നു

അപ്ലിക്കേഷൻ പ്രവർത്തിപ്പിക്കുമ്പോൾ താഴെപ്പറയുന്ന ഘട്ടങ്ങൾ ഉണ്ടാകും:

1. **സ്റ്റാർട്ടപ്പ്**: സ്പ്രിംഗ് ബൂട്ട് ആരംഭിച്ച് `application.properties` വായിക്കുന്നു
2. **സർവീസ് സൃഷ്ടി**: സ്പ്രിംഗ് `FoundryLocalService` സൃഷ്ടിച്ച് കോൺഫിഗ്രേഷൻ മൂല്യങ്ങൾ ഇഞ്ചെക്ട് ചെയ്യുന്നു
3. **മോഡൽ തിരിച്ചറിവ്**: മോഡൽ സജ്ജീകരിച്ചിട്ടില്ലെങ്കിൽ, സർവീസ് ഫൗണ്ട്രി ലോക്കലിന്റെ `/v1/models` എൻഡ്‌പോയിന്റ് ക്വറി ചെയ്ത് ആദ്യ ലഭ്യമായ മോഡൽ സ്വകാര്യമവിധം ഉപയോഗിക്കുന്നു
4. **ക്ലയന്റ് സജ്ജീകരണം**: `@PostConstruct` OpenAI ക്ലയന്റ് ആരംഭിക്കുന്നു ഫൗണ്ട്രി ലോക്കലിലേക്ക് കണക്റ്റ് ചെയ്യാൻ
5. **ഡെമോ എക്സിക്യൂഷൻ**: സ്റ്റാർട്ടപ്പ് കഴിഞ്ഞ് `CommandLineRunner` പ്രവർത്തിക്കുന്നു
6. **എഐ കോൾ**: ഡെമോ ടെസ്റ്റ് സന്ദേശം കൊണ്ട് `foundryLocalService.chat()` വിളിക്കുന്നു
7. **API അഭ്യർത്ഥന**: സർവീസ് OpenAI പൊരുത്തമുള്ള അഭ്യർത്ഥനം ഫൗണ്ട്രി ലോക്കലിലേക്ക് അയയ്ക്കുന്നു
8. **മറുപടി പ്രോസസ്സിംഗ്**: സർവീസ് എഐയുടെ മറുപടി എറക്ട് ചെയ്യുന്നു
9. **പ്രദർശനം**: അപ്ലിക്കേഷൻ മറുപടി പ്രിന്റ് ചെയ്ത് പുറത്താകുന്നു

## ഫൗണ്ട്രി ലോക്കൽ സജ്ജീകരിക്കൽ

1. [Prerequisites](#മുൻകൂട്ടി-വേണമുള്ളവ) വിഭാഗത്തിൽ നൽകിയ നിർദ്ദേശങ്ങൾ അനുസരിച്ചു **ഫൗണ്ട്രി ലോക്കൽ ഇൻസ്റ്റാൾ** ചെയ്യുക.

2. **സർവീസ് ആരംഭിക്കുക** (ഇത് പ്രവർത്തിക്കുന്നില്ലെങ്കിൽ):
   ```bash
   foundry service start
   ```

3. **സർവീസ് നില പരിശോധിക്കുക** പ്രവർത്തനക്ഷമമാണെന്ന് ഉറപ്പുവരുത്താനും പോർട്ട് നോക്കാനും:
   ```bash
   foundry service status
   ```

4. **ഒരു മോഡൽ ഡൗൺലോഡ് ചെയ്ത് പ്രവർത്തിപ്പിക്കുക** (മുതിർന്നതിൽ ഡൗൺലോഡ്, പിന്നീട് കാഷെ വച്ച് പ്രവർത്തനം):
   ```bash
   foundry model run phi-4-mini
   ```
   ഇത് ഇന്ററാക്ടീവ് ചാറ്റ് സെഷൻ തുറക്കും. `Ctrl+C` ഉപയോഗിച്ച് പുറത്തുവരാം. മോഡൽ സർവീസിൽ ലോഡായിപ്പോഴും തുടരും.

   > **ടിപ്പി:** എല്ലാ ലഭ്യമായ മോഡലുകളും കാണാൻ `foundry model list` പ്രവർത്തിപ്പിക്കുക. `phi-4-mini`-ന്റെ പകരം കോറ്റലോഗിലെ ഏതെങ്കിലും അല്യോസ് ഉപയോഗിക്കാം (ഉദാ: ചെറിയ/വേഗത്തിലുള്ള മോഡലിനായി `qwen2.5-0.5b`).

5. **മോഡൽ ലോഡായി എന്ന് സ്ഥിരീകരിക്കുക:**
   ```bash
   foundry service ps
   ```

6. **`application.properties` അപ്ഡേറ്റ് ചെയ്യുക** ആവശ്യമെങ്കിൽ:
   - ഡിഫോൾട്ട് `base-url` (`http://localhost:5273/v1`) ഡിഫോൾട്ട് CLI പോർട്ടുമായി പൊരുത്തപ്പെടുന്നു. മാറ്റം ആവശ്യമെങ്കിൽ മാത്രമേ `foundry service status`-ൽ കാണുന്ന പോർട്ട് അനുസരിച്ചു മാറ്റണം.
   - മോഡൽ സ്റ്റാർട്ടപ്പിൽ **സ്വയം തിരിച്ചറിവ്** യായി പ്രവർത്തിക്കുന്നു — കൈമാറൽ ആവശ്യമില്ല.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## അപ്ലിക്കേഷൻ പ്രവർത്തിപ്പിക്കൽ

### ഘട്ടം 1: ഫൗണ്ട്രി ലോക്കലിൽ ഒരു മോഡൽ ലോഡായിട്ടുണ്ടെന്ന് ഉറപ്പാക്കുക
```bash
foundry service ps
```

മോഡലുകൾ ഇല്ലെങ്കിൽ, ഒന്ന് ലോഡ് ചെയ്യുക:
```bash
foundry model run phi-4-mini
```

### ഘട്ടം 2: അപ്ലിക്കേഷൻ സമ്പാദിച്ച് പ്രവർത്തിപ്പിക്കുക
മറ്റ്ൊരു ടെർമിനലിൽ:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

അല്ലെങ്കിൽ ജാർ ആയി ബിൽഡ് ചെയ്ത് പ്രവർത്തിപ്പിക്കാം:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## പ്രതീക്ഷിച്ച ഔട്ട്പുട്ട്

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## അടുത്ത ഘട്ടങ്ങൾ

കൂടുതൽ ഉദാഹരണങ്ങൾക്കായി, [അധ്യായം 04: പ്രായോഗിക നമൂനകൾ](../README.md) കാണുക

## സമസ്യ പരിഹാരങ്ങൾ

### സാധാരണ പ്രശ്നങ്ങൾ

**"കണക്ഷൻ നിരസിച്ചു" അല്ലെങ്കിൽ "സർവീസ് ലഭ്യമല്ല"**
- സർവീസ് പരിശോധിക്കുക: `foundry service status`
- ആവശ്യമെങ്കിൽ വീണ്ടും ആരംഭിക്കുക: `foundry service restart`
- `application.properties`ൽ പോർട്ട് `foundry service status`-ഉം പൊരുത്തപ്പെടുന്നതായെന്ന് ഉറപ്പാക്കുക
- URL `/v1`-ന്=end ആയിരിക്കണം: `http://localhost:5273/v1`

**"സ്റ്റാർട്ടപ്പിൽ മോഡൽ കണ്ടില്ല"**
- അപ്ലിക്കേഷൻ മോഡൽ സ്വയം തിരിച്ചറിയുന്നു. കുറഞ്ഞത് ഒരു മോഡൽ ലോഡായിട്ടുണ്ട് എന്ന് ഉറപ്പാക്കുക: `foundry service ps`
- മോഡലുകൾ ലോഡായില്ലെങ്കിൽ: `foundry model run phi-4-mini`
- നിങ്ങൾ `application.properties`-ൽ മോഡൽ നാമം മാറ്റി കഴിഞ്ഞെങ്കിൽ, അത് `foundry model list`-ഉം പൊരുത്തപ്പെടുന്നുവെന്ന് പരിശോധിക്കുക

**"400 ബാഡ് റിക്വസ്റ്റ്" പിശക്**
- ബേസ് URL-ൽ `/v1` ഉണ്ടെന്ന് ഉറപ്പാക്കുക: `http://localhost:5273/v1`
- കോഡിൽ `maxCompletionTokens()` ഉപയോഗിക്കുന്നുണ്ടെന്ന് ഉറപ്പാക്കുക (നിരസ്തീകരിച്ച `maxTokens()` അല്ല)

**മേവൻ കമ്പൈലേഷൻ പിശക്**
- ജാവ 21 അല്ലെങ്കിൽ അതിലോ മുകളിൽ ആണെന്ന് നോക്കുക: `java -version`
- ക്ലീൻ ചെയ്ത് റിബിൽഡ് ചെയ്യുക: `mvn clean compile`
- ആശ്രിതങ്ങൾ ഡൗൺലോഡ് ചെയ്യാൻ ഇന്റർനെറ്റ് കണക്ഷൻ പരിശോധിക്കുക

**സർവീസ് കണക്ഷൻ പ്രശ്നങ്ങൾ**
- "`Request to local service failed`" എന്നിവ കാണുമ്പോൾ: `foundry service restart` ഓടിക്കുക
- ലോഡായ മോഡലുകൾ പരിശോധിക്കുക: `foundry service ps`
- സർവീസ് ലോഗുകൾ കാണുക: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**അസ്വീകരണം**:  
ഈ രേഖ [Co-op Translator](https://github.com/Azure/co-op-translator) എന്ന എ ഐ തർജ്ജമാ സേവനം ഉപയോഗിച്ച് തർജ്മ ചെയ്തത് ആണ്. നാം കൃത്യതയിലേക്ക് ശ്രമിച്ചുവെങ്കിലും, യന്ത്രം ചെയ്ത തർജ്മയിൽ പിഴവുകൾ അല്ലെങ്കിൽ തെറ്റുകൾ ഉണ്ടാകാനുള്ള സാധ്യത ഉണ്ട്. ഇതിന്റെ സ്വദേശ ഭാഷയിലെ യഥാർത്ഥ രേഖ ആണ് ഔദ്യോഗിക ഉറവിടം എന്നു കരുതേണ്ടത്. നിർണ്ണായക വിവരങ്ങൾക്ക് പ്രൊഫഷണൽ മനുഷ്യൻ തർജ്ജമ ചെയ്യുന്നത് ശിപാർശ ചെയ്യുന്നു. ഈ തർജ്മ ഉപയോഗിക്കുന്നതിൽനിന്നു സംഭവിക്കുന്ന ഏതെങ്കിലും തെറ്റുതിരുത്തലുകൾക്കും തെറ്റിദ്ധാരണകൾക്കും നാം ഉത്തരവാദികളല്ല.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->