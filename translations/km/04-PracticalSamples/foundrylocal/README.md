# មេរៀន Foundry Local Spring Boot

## បញ្ជីមេរៀន

- [លក្ខខណ្ឌជាមុន](#លក្ខខណ្ឌជាមុន)
- [ទិដ្ឋភាពគម្រោង](#ទិដ្ឋភាពគម្រោង)
- [យល់ដឹងអំពីកូដ](#យល់ដឹងអំពីកូដ)
  - [1. ការកំណត់កម្មវិធី (application.properties)](#1-ការកំណត់កម្មវិធី-applicationproperties)
  - [2. ថ្នាក់កម្មវិធីសំខាន់ (Application.java)](#2-ថ្នាក់កម្មវិធីសំខាន់-applicationjava)
  - [3. ស្រទាប់សេវាកម្ម AI (FoundryLocalService.java)](#3-ស្រទាប់សេវាកម្ម-ai-foundrylocalservicejava)
  - [4. ខួប Dependencies គម្រោង (pom.xml)](#4-ខួប-dependencies-គម្រោង-pomxml)
- [របៀបដែលវាផ្គុំគ្នា](#របៀបដែលវាផ្គុំគ្នា)
- [ការដំឡើង Foundry Local](#ការដំឡើង-foundry-local)
- [ការប្រើកម្មវិធី](#ការប្រើកម្មវិធី)
- [លទ្ធផលដែលរំពឹងទុក](#លទ្ធផលដែលរំពឹងទុក)
- [ជំហានបន្ទាប់](#ជំហានបន្ទាប់)
- [ដោះស្រាយបញ្ហា](#ដោះស្រាយបញ្ហា)


## លក្ខខណ្ឌជាមុន

មុននឹងចាប់ផ្តើមមេរៀននេះ សូមប្រាកដថាអ្នកមាន៖

- **Java 21 ឬខ្ពស់ជាងនេះ** ដំឡើងលើប្រព័ន្ធរបស់អ្នក
- **Maven 3.6+** សម្រាប់កំណត់សំណុំគម្រោង
- **Foundry Local** ត្រូវបានដំឡើងហើយកំពុងដំណើរការ

### **ដំឡើង Foundry Local:**

> **ចំណាំ:** Foundry Local CLI មានសម្រាប់ **Windows** និង **macOS** តែប៉ុណ្ណោះ។ Linux ត្រូវបានគាំទ្របានតាមរយៈ [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust)។

```bash
# វីនដូូ
winget install Microsoft.FoundryLocal

# ម៉ាក់អូស
brew tap microsoft/foundrylocal
brew install foundrylocal
```
  
ផ្ទៀងផ្ទាត់ការដំឡើង៖  
```bash
foundry --version
```
  
## ទិដ្ឋភាពគម្រោង

គម្រោងនេះមានបួនផ្នែកសំខាន់៖

1. **Application.java** - ចំណុចចូលកម្មវិធី Spring Boot សំខាន់
2. **FoundryLocalService.java** - ស្រទាប់សេវាកម្មដែលគ្រប់គ្រងការប្រាស្រ័យទាក់ទង AI
3. **application.properties** - ការកំណត់សម្រាប់ការភ្ជាប់ Foundry Local
4. **pom.xml** - ខួប dependencies និងការកំណត់គម្រោង

## យល់ដឹងអំពីកូដ

### 1. ការកំណត់កម្មវិធី (application.properties)

**ឯកសារ៖** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```
  
**អ្វីដែលវាធ្វើ៖**  
- **base-url**: បញ្ជាក់ទីតាំងជំរុញផលិតកម្ម Foundry Local កំពុងដំណើរការ រួមមានផ្លូវ `/v1` សម្រាប់ភាពឆបគ្នាជាមួយ OpenAI API។ ផត់ផតលំនាំដើមគឺ `5273`។ ប្រសិនបើផត់ផតខុសគ្នា សូមពិនិត្យវាជាមួយ `foundry service status`។  
- **model** (ជាជម្រើស): ឈ្មោះម៉ូដែល AI ដែលត្រូវប្រើសម្រាប់បង្កើតអត្ថបទ។ **លំនាំដើមកម្មវិធីនឹងស្វ័យប្រមាណម៉ូដែល** តាមការសួរព័ត៌មាន `/v1/models` របស់ Foundry Local នៅពេលចាប់ផ្តើម ដូច្នេះអ្នកមិនចាំបាច់កំណត់វាទេ។ អ្នកអាចកំណត់វាដោយច្បាស់ចង់លុបចោលការស្វ័យប្រមាណបើចាំបាច់។

**មូលដ្ឋានគោលន័យ៖** Spring Boot នឹងបញ្ចូលទិន្នន័យទាំងនេះដោយស្វ័យប្រវត្តិ និងធ្វើអោយវាអាចប្រើបានក្នុងកម្មវិធីរបស់អ្នកតាមរយៈអ្នូត `@Value`។

### 2. ថ្នាក់កម្មវិធីសំខាន់ (Application.java)

**ឯកសារ៖** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // មិនចាំបាច់មានម៉ាស៊ីនបម្រើវេបសាយ
        app.run(args);
    }
```
  
**អ្វីដែលវាធ្វើ៖**  
- `@SpringBootApplication` អនុញ្ញាតផ្ទាល់ការកំណត់ Spring Boot  
- `WebApplicationType.NONE` ជូនដំណឹងថាអាជីវកម្មនេះជាកម្មវិធីបញ្ជាលើ Command-Line មិនមែនជា Web server  
- មធ្យោបាយចម្បងចាប់ផ្តើមកម្មវិធី Spring

**កម្មវិធីដំណើរការសាកល្បង៖**  
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
  
**អ្វីដែលវាធ្វើ៖**  
- `@Bean` បង្កើតផ្នែកទ្រទ្រង់ដែល Spring គ្រប់គ្រង  
- `CommandLineRunner` រត់កូដបន្ទាប់ពី Spring Boot ចាប់ផ្តើម  
- `foundryLocalService` ត្រូវបានបញ្ជូលដោយ Spring (dependency injection)  
- ផ្ញើសារ​សាកល្បងទៅ AI ហើយបង្ហាញការឆ្លើយតប

### 3. ស្រទាប់សេវាកម្ម AI (FoundryLocalService.java)

**ឯកសារ៖** `src/main/java/com/example/FoundryLocalService.java`

#### ការចាក់បញ្ចូលការកំណត់៖  
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // ស្វ័យប្រមានបើទទេ
```
  
**អ្វីដែលវាធ្វើ៖**  
- `@Service` អោយដឹងថាថ្នាក់នេះផ្តល់យុទ្ធសាស្ត្រអាជីវកម្ម  
- `@Value` ចាក់បញ្ចូលតម្លៃកំណត់ពី application.properties  
- ម៉ូដែលដើមគឺទទេ ដែលបណ្តាលឲ្យមានការស្វ័យប្រមាណពី Foundry Local នៅពេលចាប់ផ្តើម។ នេះមានន័យថាកម្មវិធីដំណើរការជាមួយម៉ូដែលណាមួយដែលបានដាក់នៅក្នុង Foundry Local ដោយមិនចាំបាច់កំណត់ដោយដៃ។

#### ការចាប់ផ្តើម Client៖  
```java
@PostConstruct
public void init() {
    // ស្វ័យប្រវត្តិនិយាយកំណត់ម៉ូដែលពី Foundry Local ប្រសិនបើមិនបានកំណត់ជាក់លាក់
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // URL មូលដ្ឋានមានរួចហើយ /v1 ពីការកំណត់
            .apiKey("not-needed")            // ម៉ាស៊ីនមូលដ្ឋានមិនត្រូវការកូន API ពិតប្រាកដ
            .build();
}
```
  
**អ្វីដែលវាធ្វើ៖**  
- `@PostConstruct` រត់មធ្យោបាយនេះបន្ទាប់ពី Spring បង្កើតសេវាកម្ម  
- ប្រសិនបើមិនមានម៉ូដែលកំណត់ វាស្នើសុំ `/v1/models` របស់ Foundry Local ហើយជ្រើសរើសម៉ូដែលដំបូងដែលបានទាញយក  
- បង្កើត client OpenAI ដែលបង្ហាញទៅម៉ាស៊ីន Foundry Local របស់អ្នក  
- base URL ពី `application.properties` មាន `/v1` សម្រាប់ភាពឆបគ្នា OpenAI API  
- គ្រាប់លេខ API បានកំណត់ជា "not-needed" ព្រោះការអភិវឌ្ឍតំបន់មូលដ្ឋានមិនត្រូវការសម្ងាត់

#### វិធីសាស្រ្ត Chat៖  
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // ម៉ូដែល AI ដែលត្រូវប្រើ
                .addUserMessage(message)         // សំណួរ/ការជំនួយរបស់អ្នក
                .maxCompletionTokens(150)        // កំណត់ប្រវែងចម្លើយ
                .temperature(0.7)                // គ្រប់គ្រងភាពច្នៃប្រឌិត (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // ដកចេញចម្លើយ AI ពីលទ្ធផល API
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```
  
**អ្វីដែលវាធ្វើ៖**  
- **ChatCompletionCreateParams**៖ កំណត់សំណើ AI  
  - `model`: បញ្ជាក់ម៉ូដែល AI ដែលត្រូវប្រើ (ត្រូវតែត្រូវនឹង ID ត្រឹមត្រូវពី `foundry model list`)  
  - `addUserMessage`: បន្ថែមសាររបស់អ្នកទៅក្នុងសន្ទនារ  
  - `maxCompletionTokens`: កំណត់កំរិតប្រវែងការឆ្លើយតប (សន្សំធនធាន)  
  - `temperature`: គ្រប់គ្រងការរញ្ជួយ (0.0 = លំអៀង, 1.0 = បង្កើតច្នៃប្រឌិត)  
- **API Call**៖ ផ្ញើសំណើទៅ Foundry Local  
- **ការដោះស្រាយចម្លើយ**៖ ដកអត្ថបទចម្លើយ AI ដោយមានសុវត្ថិភាព  
- **ការដោះស្រាយកម្រិតបញ្ហា**៖ រុំកម្រងករណី exception ជាមួយសារ error ដែលមានប្រយោជន៍

### 4. ខួប Dependencies គម្រោង (pom.xml)

**ខួបសំខាន់៖**

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
  
**អ្វីដែលវាធ្វើ៖**  
- **spring-boot-starter**៖ ផ្តល់មុខងារមូលដ្ឋាន Spring Boot  
- **openai-java**៖ គម្រោង Java SDK ផ្លូវការសម្រាប់ OpenAI API  
- **jackson-databind**៖ ដំណើរការសម្រួល JSON សម្រាប់កម្មវិធី API

## របៀបដែលវាផ្គុំគ្នា

នេះជាជួរប្រតិបត្តិពេញលេញពេលអ្នករត់កម្មវិធី៖

1. **ចាប់ផ្តើម**: Spring Boot ចាប់ផ្តើម ហើយអាន `application.properties`  
2. **ការបង្កើតសេវាកម្ម**: Spring បង្កើត `FoundryLocalService` ហើយចាក់បញ្ចូលតម្លៃកំណត់  
3. **ការស្វ័យប្រមាណម៉ូដែល**: ប្រសិនបើមិនមានម៉ូដែល ការសេវាស្នើសុំ `/v1/models` របស់ Foundry Local ហើយប្រើម៉ូដែលដំបូងនៅស្រាប់  
4. **ការកំណត់ client**: `@PostConstruct` ចាប់ផ្តើម client OpenAI ဆាកដល់ Foundry Local  
5. **ការប្រើប្រាស់សាកល្បង**: `CommandLineRunner` ធ្វើការប្រតិបត្តិបន្ទាប់ពីចាប់ផ្តើម  
6. **សារហៅ AI**: ដំណើរការនៅ `foundryLocalService.chat()` ជាមួយសារសាកល្បង  
7. **សំណើ API**: សេវាកម្មកសាង និងផ្ញើសំណើ OpenAI-compatible ទៅ Foundry Local  
8. **ដោះស្រាយចម្លើយ**: សេវាកម្មដក ចម្លើយ AI ហើយត្រឡប់វិញ  
9. **បង្ហាញលទ្ធផល**: កម្មវិធីបោះពុម្ពចម្លើយ ហើយចេញពីកម្មវិធី

## ការដំឡើង Foundry Local

1. **ដំឡើង Foundry Local** ដោយអនុវត្តតាមសេចក្តីណែនាំនៅក្នុងផ្នែក [លក្ខខណ្ឌជាមុន](#លក្ខខណ្ឌជាមុន)។

2. **ចាប់ផ្តើមសេវាកម្ម** (ប្រសិនបើមិនបានដំណើរការ):  
   ```bash
   foundry service start
   ```
  
3. **ពិនិត្យស្ថានភាពសេវាកម្ម** ដើម្បីបញ្ជាក់ថាវាកំពុងដំណើរការ និងចំណាំប័រផត់ផត:  
   ```bash
   foundry service status
   ```
  
4. **ទាញយក និងរត់ម៉ូដែល** (ទាញយកលើកដំបូង ហើយផ្ទុកក្នុង cache សម្រាប់ដំណើរការជាបន្ទាប់):  
   ```bash
   foundry model run phi-4-mini
   ```
   នេះបើកកិច្ចប្រជុំជជែកអន្តរកម្ម អ្នកអាចចេញដោយចុច `Ctrl+C`។ ម៉ូដែលនៅតែត្រូវបានផ្ទុកក្នុងសេវាកម្ម។

   > **គន្លឹះ:** រត់ `foundry model list` ដើម្បីមើលម៉ូដែលទាំងអស់ដែលមាន។ ជំនួស `phi-4-mini` ជាមួយបុព្វហេតុណាមួយក្នុងបញ្ជី (ឧ. `qwen2.5-0.5b` សម្រាប់ម៉ូដែលតូច/រហ័សជាង)។

5. **ផ្ទៀងផ្ទាត់ម៉ូដែលត្រូវបានដាក់:**  
   ```bash
   foundry service ps
   ```
  
6. **អាប់ដេត `application.properties` ប្រសិនបើចាំបាច់៖**  
   - base-url លំនាំដើម (`http://localhost:5273/v1`) ត្រូវនឹងច្រក CLI លំនាំដើម។ បើផត់ផតផ្សេង សូមធ្វើបច្ចុប្បន្នភាពតែប៉ុណ្ណោះ។  
   - ម៉ូដែលត្រូវបាន **ស្វ័យប្រមាណ** នៅពេលចាប់ផ្តើម — មិនចាំបាច់កំណត់។

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```
  
## ការប្រើកម្មវិធី

### ជំហាន 1: ប្រាកដថាម៉ូដែលបានផ្ទុកក្នុង Foundry Local  
```bash
foundry service ps
```
  
ប្រសិនបើគ្មានម៉ូដែលបង្ហាញ ចំណុះមួយ:  
```bash
foundry model run phi-4-mini
```
  
### ជំហាន 2: បង្កើត និងរត់កម្មវិធី  
នៅក្នុង Terminal ផ្សេងទៀត:  
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```
  
ឬបង្កើត និងដំណើរការជា JAR:  
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```
  
## លទ្ធផលដែលរំពឹងទុក

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
  
## ជំហានបន្ទាប់

សម្រាប់ឧទាហរណ៍បន្ថែម មើល [ជំពូក 04: ឧទាហរណ៍អនុវត្ត](../README.md)

## ដោះស្រាយបញ្ហា

### គន្លឹះរួម

**"Connection refused" ឬ "Service unavailable"**  
- ពិនិត្យសេវាកម្ម៖ `foundry service status`  
- ចាប់ផ្តើមឡើងវិញប្រសិនបើចាំបាច់៖ `foundry service restart`  
- ផ្ទៀងផ្ទាត់ថាច្រកក្នុង `application.properties` ត្រូវនឹងការបញ្ចេញ `foundry service status`  
- ធ្វើប្រាកដថា URL មាន `/v1` ចុងក្រោយ៖ `http://localhost:5273/v1`

**"No model found" នៅពេលចាប់ផ្តើម**  
- កម្មវិធីស្វ័យប្រមាណម៉ូដែល។ សូមធ្វើឲ្យមានម៉ូដែលមួយយ៉ាងតិចតួចបានផ្ទុក: `foundry service ps`  
- ប្រសិនបើគ្មានម៉ូដែលបានផ្ទុក៖ `foundry model run phi-4-mini`  
- ប្រសិនបើអ្នកបានផ្លាស់ប្ដូរឈ្មោះម៉ូដែលក្នុង `application.properties` សូមផ្ទៀងផ្ទាត់ឲ្យតម្រឹមនឹង `foundry model list`

**កំហុស "400 Bad Request"**  
- ផ្ទៀងផ្ទាត់ base URL មាន `/v1`៖ `http://localhost:5273/v1`  
- ត្រូវប្រាកដអ្នកប្រើ `maxCompletionTokens()` ក្នុងកូដ (ញឹកញាប់ធីត `maxTokens()` គឺហ៊ានលុបចោល)

**កំហុសបំលែង Maven**  
- ធ្វើឲ្យប្រាកដ Java 21 ឬខ្ពស់ទៀត៖ `java -version`  
- សម្អាត និងសង់ឡើងវិញ៖ `mvn clean compile`  
- ពិនិត្យការតភ្ជាប់អ៊ីនធើណិតសម្រាប់ទាញ dependencies

**បញ្ហាការភ្ជាប់សេវាកម្ម**  
- ប្រសិនបើអ្នកឃើញ `Request to local service failed` សូមរត់៖ `foundry service restart`  
- ពិនិត្យម៉ូដែលផ្ទុក៖ `foundry service ps`  
- មើលកំណត់ហេតុសេវាកម្ម៖ `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**បញ្ជាក់**៖  
ឯកសារនេះត្រូវបានបកប្រែដោយប្រើសេវាបកប្រែ AI [Co-op Translator](https://github.com/Azure/co-op-translator)។ ខណៈពេលយើងខិតខំបំពេញភាពត្រឹមត្រូវ សូមជ្រាបថាការបកប្រែដោយស្វ័យប្រវត្តិក្នុងនេះអាចមានកំហុស ឬភាពមិនត្រឹមត្រូវខ្លះ។ ឯកសារដើមជាភាសារដែលមានដើមគួរត្រូវបានគេចាត់ទុកជាធនធានមានសុពាល់។ សម្រាប់ព័ត៌មានសំខាន់ៗ សូមផ្ដល់ការបកប្រែដោយមនុស្សអ្នកជំនាញ។ យើងមិនទទួលខុសត្រូវចំពោះការយល់ច្រឡំឬការបកស្រាយខុសពីការប្រើប្រាស់ការបកប្រែនេះទេ។
<!-- CO-OP TRANSLATOR DISCLAIMER END -->