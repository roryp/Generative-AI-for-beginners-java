# មេរៀន Foundry Local Spring Boot

## តារាងបញ្ជីមាតិកា

- [លក្ខណ្ឌទាមទារ](#លក្ខណ្ឌទាមទារ)
- [ទិដ្ឋភាពគម្រោង](#ទិដ្ឋភាពគម្រោង)
- [ការយល់ដឹងអំពីកូដ](#ការយល់ដឹងអំពីកូដ)
  - [1. ការកំណត់កម្មវិធី (application.properties)](#1-ការកំណត់កម្មវិធី-applicationproperties)
  - [2. ថ្នាក់កម្មវិធីសំខាន់ (Application.java)](#2-ថ្នាក់កម្មវិធីសំខាន់-applicationjava)
  - [3. សេវាកម្ម AI (FoundryLocalService.java)](#3-សេវាកម្ម-ai-foundrylocalservicejava)
  - [4. ហេតុផលគម្រោង (pom.xml)](#4-ហេតុផលគម្រោង-pomxml)
- [វិធីដែលវាដំណើរការជាមួយគ្នា](#វិធីដែលវាដំណើរការជាមួយគ្នា)
- [ការតំឡើង Foundry Local](#ការតំឡើង-foundry-local)
- [ការរត់កម្មវិធី](#ការរត់កម្មវិធី)
- [លទ្ធផលដែលបានរំពឹត](#លទ្ធផលដែលបានរំពឹត)
- [ជំហានបន្ទាប់](#ជំហានបន្ទាប់)
- [ការដោះស្រាយបញ្ហា](#ការដោះស្រាយបញ្ហា)


## លក្ខណ្ឌទាមទារ

មុនពេលចាប់ផ្តើមមេរៀននេះ បូមប្រាកដថាអ្នកមានៈ

- **Java 21 ឬខ្ពស់ជាងនេះ** តំឡើងនៅលើប្រព័ន្ធរបស់អ្នក
- **Maven 3.6+** សម្រាប់កសាងគម្រោង
- **Foundry Local** តំឡើងហើយកំពុងដំណើរការ

### **តំឡើង Foundry Local:**

```bash
# វីនដូដ
winget install Microsoft.FoundryLocal

# macOS (បន្ទាប់ពីបានដំឡើង)
foundry model run phi-3.5-mini
```

## ទិដ្ឋភាពគម្រោង

គម្រោងនេះមានធាតុសំខាន់បួន៖

1. **Application.java** - ច្រកចូលកម្មវិធី Spring Boot សំខាន់
2. **FoundryLocalService.java** - ស្រទាប់សេវាកម្មដែលគ្រប់គ្រងការទំនាក់ទំនង AI
3. **application.properties** - ការកំណត់សម្រាប់ការតភ្ជាប់ Foundry Local
4. **pom.xml** - ហេតុផល Maven និងការកំណត់គម្រោង

## ការយល់ដឹងអំពីកូដ

### 1. ការកំណត់កម្មវិធី (application.properties)

**ឯកសារ:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**អ្វីដែលវាត្រូវធ្វើ:**
- **base-url**: បញ្ជាក់កន្លែងដែល Foundry Local កំពុងដំណើរការ រួមមានផ្លូវ `/v1` សម្រាប់ភាពសមរម្យ OpenAI API។ **កំណត់សំគាល់**: Foundry Local ផ្ដល់ច្រកថ្មីដោយស្វ័យប្រវត្តិ ដូច្នេះសូមពិនិត្យច្រកពិតប្រាកដរបស់អ្នកដោយប្រើ `foundry service status`
- **model**: ឈ្មោះម៉ូដែល AI ដែលប្រើសម្រាប់បង្កើតអក្សរ រួមមានលេខកំណែ (ឧ. `:1`)។ ប្រើ `foundry model list` ដើម្បីមើលម៉ូដែលដែលមានជាមួយ ID ត្រឹមត្រូវ

**គំនិតសំខាន់:** Spring Boot ផ្ទុកសំណុំនេះដោយស្វ័យប្រវត្តិ ហើយធ្វើអោយវាអាចប្រើបានក្នុងកម្មវិធីរបស់អ្នកដោយប្រើអង្គភាព `@Value`។

### 2. ថ្នាក់កម្មវិធីសំខាន់ (Application.java)

**ឯកសារ:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // គ្មានការ​តម្រូវ​អ្នក​បម្រើ​បណ្ដាញ​បណ្តាញ​នោះទេ
        app.run(args);
    }
```

**អ្វីដែលវាត្រូវធ្វើ:**
- `@SpringBootApplication` បើកដំណើរការ Spring Boot អូតូ-ការកំណត់
- `WebApplicationType.NONE` សំដៅថា វាជាកម្មវិធីបញ្ជារចម្លើយ មិនមែនជា server វ៉ែប
- មុខងារសំខាន់ចាប់ផ្តើម Spring application

**កម្មវិធី Demo Runner:**
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

**អ្វីដែលវាត្រូវធ្វើ:**
- `@Bean` បង្កើតធាតុមួយដែល Spring គ្រប់គ្រង
- `CommandLineRunner` ប្រតិបត្តិកូដបន្ទាប់ពី Spring Boot ចាប់ផ្តើម
- `foundryLocalService` ត្រូវបានចាក់បញ្ចូលដោយ Spring ផ្ទាល់ (dependency injection)
- ផ្ញើសារពិនិត្យទៅ AI ហើយបង្ហាញការឆ្លើយតប

### 3. សេវាកម្ម AI (FoundryLocalService.java)

**ឯកសារ:** `src/main/java/com/example/FoundryLocalService.java`

#### ការចាក់បញ្ចូលការកំណត់:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```

**អ្វីដែលវាត្រូវធ្វើ:**
- `@Service` បង្ហាញថា ថ្នាក់នេះផ្ដល់តុល្យភាពអាជីវកម្ម
- `@Value` ចាក់ចូលតម្លៃកំណត់ពី application.properties
- វិធីសាស្រ្ត `:default-value` ផ្ដល់តម្លៃជំនួស ប្រសិនបើ properties មិនត្រូវបានកំណត់

#### ការចាប់ផ្តើម Client:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // URL មូលដ្ឋានមានរួចស្រាប់ /v1 ពីការកំណត់រចនាសម្ព័ន្ធ
            .apiKey("not-needed")            // ម៉ាស៊ីនមេក្នុងស្រុកមិនត្រូវការកូនសោ API ពិតប្រាកដ
            .build();
}
```

**អ្វីដែលវាត្រូវធ្វើ:**
- `@PostConstruct` បង្ហាញថាវិធីសាស្រ្តនេះបញ្ចប់បន្ទាប់ពី Spring បង្កើតសេវាកម្ម
- បង្កើត OpenAI client ដែលបញ្ជូនទៅ Foundry Local របស់អ្នក
- URL មូលដ្ឋានពី `application.properties` មាន `/v1` រួចហើយ សម្រាប់ភាពសមរម្យ OpenAI API
- កូនសោ API ត្រូវបានកំណត់ជា "not-needed" ព្រោះការអភិវឌ្ឍន៏ក្នុងតំបន់មិនត្រូវការការផ្ទៀងផ្ទាត់

#### វិធីសាស្រ្ត Chat:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // តើគំរូ AI ណាមួយដែលត្រូវប្រើ
                .addUserMessage(message)         // សំណួរ/ការជំរុញរបស់អ្នក
                .maxCompletionTokens(150)        // កំណត់ប្រវែងចម្លើយ
                .temperature(0.7)                // គ្រប់គ្រងភាពច្នៃប្រឌិត (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // ដកចម្លើយ AI ពីលទ្ធផល API
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**អ្វីដែលវាត្រូវធ្វើ:**
- **ChatCompletionCreateParams**: កំណត់សំណើ AI
  - `model`: បញ្ជាក់ម៉ូដែល AI ដែលត្រូវប្រើ (ត្រូវតែត្រូវនឹង ID ពិតប្រាកដពី `foundry model list`)
  - `addUserMessage`: បន្ថែមសាររបស់អ្នកក្នុងការសន្ទនា
  - `maxCompletionTokens`: កំណត់ប្រវែងចម្លើយអតិបរមា (ជួយសន្សំធនធាន)
  - `temperature`: គ្រប់គ្រងភាពចៃដន្យ (0.0 = ត្រឹមត្រូវដាច់ខាត, 1.0 = មានភាពច្នៃប្រឌិត)
- **API Call**: ផ្ញើសំណើទៅ Foundry Local
- **ការដោះស្រាយចម្លើយ**: កាប់យកអត្ថបទចម្លើយពី AI ដោយសុវត្ថិភាព
- **ដោះស្រាយកំហុស**: ការចាប់ខ្សែភាពយន្តជាមួយសារ​កំហុសដែលមានប្រយោជន៍

### 4. ហេតុផលគម្រោង (pom.xml)

**ហេតុផលសំខាន់ៗ:**

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

**អ្វីដែលវាត្រូវធ្វើ:**
- **spring-boot-starter**: ផ្ដល់មុខងារ Spring Boot មូលដ្ឋាន
- **openai-java**: គ្រឹះស្ថាន OpenAI Java SDK សម្រាប់ការទំនាក់ទំនង API
- **jackson-databind**: គ្រប់គ្រងការបំលែង JSON សម្រាប់ការហៅ API

## វិធីដែលវាដំណើរការជាមួយគ្នា

នេះជាដំណើរការសរុបពេលអ្នករត់កម្មវិធី៖

1. **ចាប់ផ្តើម**: Spring Boot ចាប់ផ្តើម និងអាន `application.properties`
2. **បង្កើតសេវាកម្ម**: Spring បង្កើត `FoundryLocalService` ហើយចាក់បញ្ចូលតម្លៃកំណត់
3. **តំឡើង Client**: `@PostConstruct` ចាប់ផ្តើម OpenAI client ដើម្បីភ្ជាប់ទៅ Foundry Local
4. **ប្រតិបត្តិការបង្ហាញ**: `CommandLineRunner` បើកប្រាស្រ័យបន្ទាប់ពីចាប់ផ្តើម
5. **ហៅ AI**: Demo ហៅ `foundryLocalService.chat()` ជាមួយសារពិនិត្យមួយ
6. **សំណើ API**: សេវាកម្ម បង្កើត និងផ្ញើសំណើ OpenAI-compatible ទៅ Foundry Local
7. **ដំណើរការចម្លើយ**: សេវាកម្មទាញនិងបង្វិលចម្លើយ AI
8. **បង្ហាញ**: កម្មវិធីបោះពុម្ពចម្លើយ ហើយចេញពីកម្មវិធី

## ការតំឡើង Foundry Local

ដើម្បីតំឡើង Foundry Local សូមអនុវត្តជំហានទាំងនេះ៖

1. **តំឡើង Foundry Local** ដោយប្រើការណែនាំក្នុងផ្នែក [Prerequisites](#លក្ខណ្ឌទាមទារ)។

2. **ពិនិត្យច្រកដែលមានការ​ផ្ដល់ដោយចៃដន្យ**។ Foundry Local ផ្ដល់ច្រកដោយស្វ័យប្រវត្តិពេលវាចាប់ផ្តើម។ រកច្រករបស់អ្នកដោយ៖
   ```bash
   foundry service status
   ```
   
   **ជម្រើសបន្ថែម**: ប្រសិនបើអ្នកចង់ប្រើច្រកជាក់លាក់ (ឧ. 5273) អ្នកអាចកំណត់ដៃ៖
   ```bash
   foundry service set --port 5273
   ```

3. **ទាញយកម៉ូដែល AI** ដែលអ្នកចង់ប្រើ ឧ. `phi-3.5-mini` ជាមួយពាក្យបញ្ជាខាងក្រោម៖
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **កំណត់ឯកសារ application.properties** ឲ្យសមរម្យនឹងការកំណត់ Foundry Local របស់អ្នក៖
   - បន្ទាន់សម័យច្រកក្នុង `base-url` (ពីជំហាន 2) ហើយធានាថាផ្លូវមាន `/v1` នៅចុង
   - បន្ទាន់សម័យឈ្មោះម៉ូដែល ដើម្បីរួមបញ្ចូលលេខកំណែ (ពិនិត្យជាមួយ `foundry model list`)
   
   និទាឃរូបៈ
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```

## ការរត់កម្មវិធី

### ជំហាន 1: ចាប់ផ្តើម Foundry Local
```bash
foundry model run phi-3.5-mini
```

### ជំហាន 2: កសាង និងរត់កម្មវិធី
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## លទ្ធផលដែលបានរំពឹត

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

## ជំហានបន្ទាប់

សម្រាប់ឧទាហរណ៍បន្ថែម សូមមើល [ជំពូក 04: ឧទាហរណ៍អនុវត្ត](../README.md)

## ការដោះស្រាយបញ្ហា

### បញ្ហាទូទៅ

**"Connection refused" ឬ "Service unavailable"**
- សូមប្រាកដថា Foundry Local កំពុងដំណើរការ៖ `foundry model list`
- ពិនិត្យច្រកពិតប្រាកដដែល Foundry Local កំពុងប្រើ៖ `foundry service status`
- បន្ទាន់សម័យ `application.properties` ជាមួយច្រកត្រឹមត្រូវ ហើយធានាថា URL បញ្ចប់ដោយ `/v1`
- ជំនួស, កំណត់ច្រកជាក់លាក់ប្រសិនបើចង់៖ `foundry service set --port 5273`
- ព្យាយាមចាប់ផ្តើមឡើងវិញ Foundry Local៖ `foundry model run phi-3.5-mini`

**"Model not found" ឬ កំហុស "404 Not Found"**
- ពិនិត្យម៉ូដែលដែលមានជាមួយ ID ត្រឹមត្រូវ៖ `foundry model list`
- បន្ទាន់សម័យឈ្មោះម៉ូដែលក្នុង `application.properties` ដូចគ្នា រួមបញ្ចូលលេខកំណែ (ឧ. `Phi-3.5-mini-instruct-cuda-gpu:1`)
- ធានាថា `base-url` រួមមាន `/v1` នៅចុង៖ `http://localhost:5273/v1`
- ទាញយកម៉ូដែល ប្រសិនបើចាំបាច់៖ `foundry model run phi-3.5-mini`

**កំហុស "400 Bad Request"**
- ពិនិត្យថា base URL មាន `/v1`: `http://localhost:5273/v1`
- ពិនិត្យម៉ូដែល ID ត្រូវនឹង ID ត្រូវគ្នានៅក្នុង `foundry model list`
- សូមប្រាកដថាអ្នកប្រើ `maxCompletionTokens()` ក្នុងកូដ (មិនមែន `maxTokens()` ដែលមិនប្រើឡើយ)

**កំហុសកំណត់អត្ថប្រយោជន៍ Maven**
- ប្រាកដថា Java 21 ឬខ្ពស់ជាងនេះ៖ `java -version`
- សម្អាត និងសាងសង់ឡើងវិញ៖ `mvn clean compile`
- ពិនិត្យការតភ្ជាប់អ៊ីនធឺណិតសម្រាប់ទាញយកអាសយដ្ឋាន

**កម្មវិធីចាប់ផ្តើមតែមិនមានលទ្ធផលចេញវិញ**
- ពិនិត្យថា Foundry Local កំពុងឆ្លើយតប៖ ពិនិត្យ `http://localhost:5273/v1/models` ឬរត់ `foundry service status`
- ពិនិត្យកំណត់ហេតុកម្មវិធី (logs) សម្រាប់សារកំហុសជាក់លាក់
- ធានាពិនិត្យម៉ូដែលបានចំនួនពេញលេញហើយរួចរាល់

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ការបដិសេធ**:  
ឯកសារនេះត្រូវបានបកប្រែដោយប្រើសេវាកម្មបកប្រែ AI [Co-op Translator](https://github.com/Azure/co-op-translator)។ ទោះយើងខិតខំប្រឹងប្រែងសម្រាប់ភាពត្រឹមត្រូវ ក៏សូមយល់ព្រមថាការបកប្រែដោយស្វ័យប្រវត្តិអាចមានកំហុស ឬភាពមិនត្រឹមត្រូវ។ ឯកសារដើមក្នុងភាសាទ្រង់ទ្រាយដើមគួរត្រូវបានភាគរយដល់ការជឿជាក់។ សម្រាប់ព័ត៌មានសំខាន់ៗ ការបកប្រែដោយមនុស្សជំនាញត្រូវបានផ្តល់អនុសាសន៍។ យើងមិនទទួលខុសត្រូវចំពោះការយល់ច្រឡំ ឬការពន្យល់ថា ខុសពីការប្រើប្រាស់ការបកប្រែនេះឡើយ។
<!-- CO-OP TRANSLATOR DISCLAIMER END -->