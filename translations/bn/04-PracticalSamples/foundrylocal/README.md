# Foundry লোকাল স্প্রিং বুট টিউটোরিয়াল

## Table of Contents

- [প্রয়োজনীয়তা](#প্রয়োজনীয়তা)
- [প্রকল্প পর্যালোচনা](#প্রকল্প-পর্যালোচনা)
- [কোড বুঝা](#কোড-বুঝা)
  - [১. অ্যাপ্লিকেশন কনফিগারেশন (application.properties)](#১-অ্যাপ্লিকেশন-কনফিগারেশন-applicationproperties)
  - [২. মেইন অ্যাপ্লিকেশন ক্লাস (Application.java)](#২-মেইন-অ্যাপ্লিকেশন-ক্লাস-applicationjava)
  - [৩. AI সার্ভিস লেয়ার (FoundryLocalService.java)](#৩-ai-সার্ভিস-লেয়ার-foundrylocalservicejava)
  - [৪. প্রকল্প নির্ভরতাগুলি (pom.xml)](#৪-প্রকল্প-নির্ভরতাগুলি-pomxml)
- [সবকিছু কিভাবে একসাথে কাজ করে](#সবকিছু-কিভাবে-একসাথে-কাজ-করে)
- [Foundry লোকাল সেট আপ করা](#foundry-লোকাল-সেট-আপ-করা)
- [অ্যাপ্লিকেশন চালানো](#অ্যাপ্লিকেশন-চালানো)
- [প্রত্যাশিত আউটপুট](#প্রত্যাশিত-আউটপুট)
- [পরবর্তী ধাপগুলি](#পরবর্তী-ধাপগুলি)
- [সমস্যা সমাধান](#সমস্যা-সমাধান)


## প্রয়োজনীয়তা

এই টিউটোরিয়াল শুরু করার আগে, নিশ্চিত করুন আপনার কাছে:

- **Java 21 বা তার উপরে** আপনার সিস্টেমে ইনস্টল রয়েছে
- প্রকল্প বিল্ড করার জন্য **Maven 3.6+**
- **Foundry লোকাল** ইনস্টল এবং চলছে

### **Foundry লোকাল ইনস্টল করুন:**

> **নোট:** Foundry Local CLI শুধুমাত্র **Windows** এবং **macOS** তে উপলব্ধ। লিনাক্স সাপোর্ট করা হয় [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust) এর মাধ্যমে।

```bash
# উইন্ডোজ
winget install Microsoft.FoundryLocal

# ম্যাকওএস
brew tap microsoft/foundrylocal
brew install foundrylocal
```

ইনস্টলেশন যাচাই করুন:
```bash
foundry --version
```

## প্রকল্প পর্যালোচনা

এই প্রকল্পটি চারটি প্রধান উপাদানে গঠিত:

১. **Application.java** - প্রধান স্প্রিং বুট অ্যাপ্লিকেশন এন্ট্রি পয়েন্ট  
২. **FoundryLocalService.java** - সার্ভিস লেয়ার যা AI যোগাযোগ পরিচালনা করে  
৩. **application.properties** - Foundry Local সংযোগের কনফিগারেশন  
৪. **pom.xml** - Maven নির্ভরতাগুলি এবং প্রকল্প কনফিগারেশন  

## কোড বুঝা

### ১. অ্যাপ্লিকেশন কনফিগারেশন (application.properties)

**ফাইল:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**এটি কী করে:**
- **base-url**: Foundry Local কোথায় চলছে তা নির্ধারণ করে, OpenAI API সামঞ্জস্যতার জন্য `/v1` পথসহ। ডিফল্ট পোর্ট হলো `5273`। পোর্ট ভিন্ন হলে `foundry service status` দিয়ে পরীক্ষা করুন।  
- **model** (ঐচ্ছিক): টেক্সট জেনারেশনের জন্য যে AI মডেলটি ব্যবহার হবে তার নাম। **ডিফল্ট অনুযায়ী, অ্যাপ্লিকেশন স্টার্টআপে Foundry Local এর `/v1/models` এন্ডপয়েন্ট থেকে মডেলটি অটো-ডিটেক্ট করে**, তাই আপনাকে এটি সেট করতে হবে না। তবে দরকার হলে স্পষ্টভাবে সেট করতে পারেন অটো-ডিটেকশনের পরিবর্তে।  

**মূল ধারণা:** Spring Boot স্বয়ংক্রিয়ভাবে এই প্রোপার্টিগুলি লোড করে এবং `@Value` অ্যানোটেশন ব্যবহার করে আপনার অ্যাপ্লিকেশনে উপলব্ধ করে।

### ২. মেইন অ্যাপ্লিকেশন ক্লাস (Application.java)

**ফাইল:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // কোনও ওয়েব সার্ভার প্রয়োজন নেই
        app.run(args);
    }
```

**এটি কী করে:**
- `@SpringBootApplication` Spring Boot র auto-configuration সক্ষম করে  
- `WebApplicationType.NONE` Spring-কে জানায় এটি একটি কমান্ড-লাইন অ্যাপ্লিকেশন, ওয়েব সার্ভার নয়  
- মেইন মেথড Spring অ্যাপ্লিকেশন চালু করে  

**ডেমো রানার:**
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

**এটি কী করে:**
- `@Bean` Spring এর পরিচালিত একটি কম্পোনেন্ট তৈরি করে  
- `CommandLineRunner` Spring Boot চালু হওয়ার পর কোড চালায়  
- `foundryLocalService` স্বয়ংক্রিয়ভাবে Spring দ্বারা ইনজেক্ট করা হয় (ডিপেন্ডেন্সি ইনজেকশন)  
- AI-কে একটি টেস্ট মেসেজ পাঠায় এবং রেসপন্স প্রদর্শন করে  

### ৩. AI সার্ভিস লেয়ার (FoundryLocalService.java)

**ফাইল:** `src/main/java/com/example/FoundryLocalService.java`

#### কনফিগারেশন ইনজেকশন:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // যদি খালি থাকে তবে স্বয়ংক্রিয়ভাবে সনাক্ত করা হয়েছে
```

**এটি কী করে:**
- `@Service` Spring-কে জানায় এই ক্লাস ব্যবসায়িক লজিক প্রদান করে  
- `@Value` application.properties থেকে কনফিগারেশন মান ইনজেক্ট করে  
- মডেল ডিফল্ট ফাঁকা থাকে, যা স্টার্টআপে Foundry Local থেকে **অটো-ডিটেকশন** ট্রিগার করে। অর্থাৎ, অ্যাপ যেকোনো মডেল যা Foundry Local এ লোড আছে তা দিয়ে কাজ করবে, ম্যানুয়াল কনফিগারেশন ছাড়া।  

#### ক্লায়েন্ট ইনিশিয়ালাইজেশন:
```java
@PostConstruct
public void init() {
    // স্পষ্টভাবে কনফিগার না করলে Foundry Local থেকে মডেল স্বয়ংক্রিয়ভাবে সনাক্ত করুন
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // বেস URL ইতিমধ্যেই কনফিগারেশন থেকে /v1 অন্তর্ভুক্ত করে
            .apiKey("not-needed")            // লোকাল সার্ভারের জন্য প্রকৃত API কী প্রয়োজন নেই
            .build();
}
```

**এটি কী করে:**
- `@PostConstruct` এই মেথডটি Spring সার্ভিস তৈরি করার পর চালায়  
- যদি কোন মডেল কনফিগার না থাকে, তাহলে Foundry Local এর `/v1/models` এন্ডপয়েন্টে কোয়েরি করে প্রথম পাওয়া মডেলটি পছন্দ করে  
- আপনার লোকাল Foundry Local ইনস্ট্যান্সের জন্য একটি OpenAI ক্লায়েন্ট তৈরি করে  
- application.properties থেকে বেজ URL এ ইতিমধ্যে `/v1` রয়েছে যা OpenAI API সামঞ্জস্যের জন্য  
- API key "not-needed" সেট করা হয়েছে কারণ লোকাল ডেভেলপমেন্টে প্রমাণীকরণ প্রয়োজন হয় না  

#### চ্যাট মেথড:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // কোন AI মডেল ব্যবহার করবেন
                .addUserMessage(message)         // আপনার প্রশ্ন/প্রম্পট
                .maxCompletionTokens(150)        // উত্তর দৈর্ঘ্য সীমাবদ্ধ করুন
                .temperature(0.7)                // সৃজনশীলতা নিয়ন্ত্রণ করুন (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // API ফলাফল থেকে AI এর উত্তর বের করুন
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**এটি কী করে:**
- **ChatCompletionCreateParams**: AI অনুরোধের কনফিগারেশন  
  - `model`: কোন AI মডেল ব্যবহার হবে সেটা নির্ধারণ করে (এর ID অবশ্যই `foundry model list` থেকে সঠিক হতে হবে)  
  - `addUserMessage`: আপনার মেসেজকে কথোপকথনে যুক্ত করে  
  - `maxCompletionTokens`: রেসপন্সের সর্বোচ্চ দৈর্ঘ্য সীমাবদ্ধ করে (রিসোর্স সংরক্ষণ করে)  
  - `temperature`: র‍্যান্ডমনেস নিয়ন্ত্রণ করে (0.0 = নির্ধারিত, 1.0 = সৃজনশীল)  
- **API কল**: Foundry Local-এ অনুরোধ পাঠায়  
- **রেসপন্স প্রসেসিং**: নিরাপদে AI-র টেক্সট রেসপন্স বের করে  
- **এরর হ্যান্ডলিং**: সহায়ক এরর মেসেজ সহ এক্সসেপশন গুলো র‍্যাপ করে  

### ৪. প্রকল্প নির্ভরতাগুলি (pom.xml)

**মূল নির্ভরতা:**

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

**এগুলো কি করে:**
- **spring-boot-starter**: Spring Boot এর মূল কার্যকারিতা প্রদান করে  
- **openai-java**: API যোগাযোগের জন্য অফিসিয়াল OpenAI Java SDK  
- **jackson-databind**: API কলের জন্য JSON সিরিয়ালাইজেশন/ডেসিরিয়ালাইজেশন হ্যান্ডেল করে  

## সবকিছু কিভাবে একসাথে কাজ করে

অ্যাপ্লিকেশন চালানোর সম্পূর্ণ প্রবাহ:

১. **স্টার্টআপ:** Spring Boot শুরু হয় এবং `application.properties` পড়ে  
২. **সার্ভিস তৈরি:** Spring `FoundryLocalService` তৈরি করে এবং কনফিগারেশন মান ইনজেক্ট করে  
৩. **মডেল ডিটেকশন:** যদি কোন মডেল কনফিগার না থাকে, সার্ভিস Foundry Local এর `/v1/models` এন্ডপয়েন্টে কোয়েরি করে প্রথম পাওয়া মডেল অটোব্যবহার করে  
৪. **ক্লায়েন্ট সেটআপ:** `@PostConstruct` OpenAI ক্লায়েন্ট ইনিশিয়ালাইজ করে Foundry Local-এ সংযোগের জন্য  
৫. **ডেমো এক্সিকিউশন:** স্টার্টআপের পর `CommandLineRunner` চালানো হয়  
৬. **AI কল:** ডেমো `foundryLocalService.chat()` টেস্ট মেসেজ দিয়ে কল করে  
৭. **API অনুরোধ:** সার্ভিস OpenAI সামঞ্জস্যপূর্ণ অনুরোধ তৈরি ও Foundry Local-এ পাঠায়  
৮. **রেসপন্স প্রসেসিং:** সার্ভিস AI-র রেসপন্স বের করে ফেরত দেয়  
৯. **প্রদর্শন:** অ্যাপ্লিকেশন রেসপন্স প্রিন্ট করে এবং সরিয়ে আসে  

## Foundry লোকাল সেট আপ করা

১. [প্রয়োজনীয়তা](#প্রয়োজনীয়তা) অংশের নির্দেশনা অনুযায়ী Foundry লোকাল ইনস্টল করুন।

২. সেবা চালু করুন (যদি না চলছে):
   ```bash
   foundry service start
   ```

৩. সেবার অবস্থান পরীক্ষা করুন এবং পোর্ট নোট করুন:
   ```bash
   foundry service status
   ```

৪. একটি মডেল ডাউনলোড ও চালান (প্রথমবার ডাউনলোড হয়, পরবর্তীতে ক্যাশে থাকে):
   ```bash
   foundry model run phi-4-mini
   ```
   এটি একটি ইন্টার‍্যাক্টিভ চ্যাট সেশন খুলবে। আপনি `Ctrl+C` দিয়ে বের হয়ে যেতে পারেন। মডেল সেবাতে লোড থাকে।

   > **টিপ:** `foundry model list` চালিয়ে সমস্ত উপলব্ধ মডেল দেখতে পারেন। `phi-4-mini` এর পরিবর্তে ক্যাটালগ থেকে যেকোনো এলিয়াস ব্যবহার করুন (যেমনঃ ছোট বা দ্রুত মডেলের জন্য `qwen2.5-0.5b`)।

৫. মডেল লোড হয়েছে কি না যাচাই করুন:
   ```bash
   foundry service ps
   ```

৬. প্রয়োজনে `application.properties` আপডেট করুন:  
   - ডিফল্ট `base-url` (`http://localhost:5273/v1`) ডিফল্ট CLI পোর্টের সাথে মেলে। শুধু পোর্ট আলাদা থাকলে `foundry service status` দেখে আপডেট করুন।  
   - মডেল স্টার্টআপে **অটো-ডিটেক্ট** হয় — কনফিগারেশন দরকার নেই।  

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## অ্যাপ্লিকেশন চালানো

### ধাপ ১: নিশ্চিত করুন Foundry লোকালে একটি মডেল লোড আছে
```bash
foundry service ps
```

মডেল না থাকলে লোড করুন:
```bash
foundry model run phi-4-mini
```

### ধাপ ২: অ্যাপ্লিকেশন বিল্ড ও রান করুন
অন্য টার্মিনালে:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

অথবা JAR হিসেবে বিল্ড ও রান করুন:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## প্রত্যাশিত আউটপুট

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

## পরবর্তী ধাপগুলি

অধিক উদাহরণের জন্য দেখুন [Chapter 04: Practical samples](../README.md)

## সমস্যা সমাধান

### সাধারণ সমস্যা

**"Connection refused" বা "Service unavailable"**  
- সেবা পরীক্ষা করুন: `foundry service status`  
- প্রয়োজনে রিস্টার্ট করুন: `foundry service restart`  
- `application.properties` এ পোর্ট এবং `foundry service status` এর আউটপুট মিলিয়ে দেখুন  
- URL অবশ্যই `/v1` দিয়ে শেষ হতে হবে: `http://localhost:5273/v1`  

**"No model found" স্টার্টআপে**  
- অ্যাপ্লিকেশন মডেল অটো-ডিটেক্ট করে। কমপক্ষে একটি মডেল লোড আছে কিনা দেখুন: `foundry service ps`  
- মডেল না থাকলে চালান: `foundry model run phi-4-mini`  
- যদি `application.properties`-এ মডেলের নাম ওভাররাইড করে থাকেন, নিশ্চিত করুন সেটা `foundry model list`-এর সঠিক মডেলের সাথে মেলে।  

**"400 Bad Request" এরর**  
- দেখা দিন বেজ URL `/v1` অন্তর্ভুক্ত করছে: `http://localhost:5273/v1`  
- কোডে `maxCompletionTokens()` ব্যবহার করুন, ডিপ্রিকেটেড `maxTokens()` নয়।  

**Maven কম্পাইলেশন এরর**  
- Java 21 বা তার উপরের ভার্সন আছে কিনা নিশ্চিত করুন: `java -version`  
- ক্লিন ও রি-বিল্ড করুন: `mvn clean compile`  
- নির্ভরতাগুলির ডাউনলোডের জন্য ইন্টারনেট সংযোগ নিশ্চিত করুন।  

**সার্ভিস সংযোগ সমস্যা**  
- যদি `Request to local service failed` দেখেন, চালান: `foundry service restart`  
- লোড করা মডেল চেক করুন: `foundry service ps`  
- সার্ভিস লগ দেখুন: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**দফনবানী**:  
এই নথিটি AI অনুবাদ পরিষেবা [Co-op Translator](https://github.com/Azure/co-op-translator) ব্যবহার করে অনূদিত হয়েছে। যদিও আমরা সঠিকতার জন্য যথাসাধ্য চেষ্টা করি, অনুগ্রহ করে লক্ষ্য করুন যে স্বয়ংক্রিয় অনুবাদে ত্রুটি বা অসামঞ্জস্য থাকতে পারে। মূল নথিটি তার স্থানীয় ভাষায় কর্তৃত্বপূর্ণ উৎস হিসাবে বিবেচিত হওয়া উচিত। গুরুত্বপূর্ণ তথ্যের জন্য পেশাদার মানব অনুবাদ পরামর্শ দেওয়া হয়। এই অনুবাদের ব্যবহার থেকে উদ্ভূত কোনো ভুল বোঝাবুঝি বা ভুল ব্যাখ্যার জন্য আমরা দায়ী নই।
<!-- CO-OP TRANSLATOR DISCLAIMER END -->