# فنڈری لوکل اسپرنگ بوٹ ٹیوٹوریل

## فہرست مضامین

- [ضروریات](#ضروریات)
- [پروجیکٹ کا جائزہ](#پروجیکٹ-کا-جائزہ)
- [کوڈ کو سمجھنا](#کوڈ-کو-سمجھنا)
  - [1. ایپلیکیشن کنفیگریشن (application.properties)](#1-ایپلیکیشن-کنفیگریشن-applicationproperties)
  - [2. مرکزی ایپلیکیشن کلاس (Application.java)](#2-مرکزی-ایپلیکیشن-کلاس-applicationjava)
  - [3. AI سروس لئیر (FoundryLocalService.java)](#3-ai-سروس-لئیر-foundrylocalservicejava)
  - [4. پروجیکٹ کی انحصاریاں (pom.xml)](#4-پروجیکٹ-کی-انحصاریاں-pomxml)
- [یہ سب کیسے ایک ساتھ کام کرتا ہے](#یہ-سب-کیسے-ایک-ساتھ-کام-کرتا-ہے)
- [فنڈری لوکل سیٹ اپ کرنا](#فنڈری-لوکل-سیٹ-اپ-کرنا)
- [ایپلیکیشن چلانا](#ایپلیکیشن-چلانا)
- [متوقع نتیجہ](#متوقع-نتیجہ)
- [آئندہ کے اقدامات](#آئندہ-کے-اقدامات)
- [مسائل کا حل](#مسائل-کا-حل)


## ضروریات

اس ٹیوٹوریل کو شروع کرنے سے پہلے، یقینی بنائیں کہ آپ کے پاس:

- **جاوا 21 یا اس سے جدید** آپ کے سسٹم پر انسٹال ہے
- **میون 3.6+** پروجیکٹ بنانے کیلئے
- **فنڈری لوکل** انسٹال اور چل رہا ہے

### **فنڈری لوکل انسٹال کریں:**

> **نوٹ:** فنڈری لوکل CLI صرف **Windows** اور **macOS** کیلئے دستیاب ہے۔ لینکس کو [فنڈری لوکل SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust) کے ذریعے سپورٹ کیا جاتا ہے۔

```bash
# ونڈوز
winget install Microsoft.FoundryLocal

# میک او ایس
brew tap microsoft/foundrylocal
brew install foundrylocal
```

انسٹالیشن کی تصدیق کریں:
```bash
foundry --version
```

## پروجیکٹ کا جائزہ

یہ پروجیکٹ چار مرکزی اجزاء پر مشتمل ہے:

1. **Application.java** - مین اسپرنگ بوٹ ایپلیکیشن کا انٹری پوائنٹ
2. **FoundryLocalService.java** - سروس لئیر جو AI مواصلات کو ہینڈل کرتا ہے
3. **application.properties** - فنڈری لوکل کنکشن کیلئے کنفیگریشن
4. **pom.xml** - میون انحصاریاں اور پروجیکٹ کی کنفیگریشن

## کوڈ کو سمجھنا

### 1. ایپلیکیشن کنفیگریشن (application.properties)

**فائل:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**یہ کیا کرتا ہے:**
- **base-url**: بتاتا ہے کہ فنڈری لوکل کہاں چل رہا ہے، جس میں اوپن AI API کے مطابقت کے لیے `/v1` راستہ شامل ہے۔ ڈیفالٹ پورٹ `5273` ہے۔ اگر پورٹ مختلف ہو، تو `foundry service status` سے چیک کریں۔
- **model** (اختیاری): AI ماڈل کا نام بتاتا ہے جو متن بنانے کے لیے استعمال ہوگا۔ **ڈیفالٹ میں، ایپلیکیشن ماڈل کو خودکار طور پر پہچانتی ہے** فنڈری لوکل کے `/v1/models` اینڈپوائنٹ کو سٹارٹ اپ پر کال کرکے، اس لیے آپ کو اسے سیٹ کرنے کی ضرورت نہیں۔ اگر چاہیں تو اوٹو ڈیٹیکشن کو اووررائیڈ کرنے کے لیے واضح طور پر سیٹ کیا جا سکتا ہے۔

**اہم تصور:** اسپرنگ بوٹ خودکار طریقے سے یہ خصوصیات لوڈ کرتا ہے اور انہیں `@Value` اینوٹیشن کے ذریعے آپ کی ایپلیکیشن میں دستیاب بناتا ہے۔

### 2. مرکزی ایپلیکیشن کلاس (Application.java)

**فائل:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // کسی ویب سرور کی ضرورت نہیں
        app.run(args);
    }
```

**یہ کیا کرتا ہے:**
- `@SpringBootApplication` اسپرنگ بوٹ آٹو کنفیگریشن کو فعال کرتا ہے
- `WebApplicationType.NONE` اسپرنگ کو بتاتا ہے کہ یہ ایک کمانڈ لائن ایپ ہے، ویب سرور نہیں
- مین میتھڈ اسپرنگ ایپلیکیشن کو شروع کرتا ہے

**ڈیمو رنر:**
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

**یہ کیا करता ہے:**
- `@Bean` ایک اجزاء (component) بناتا ہے جسے اسپرنگ مینیج کرتا ہے
- `CommandLineRunner` کوڈ کو اسپرنگ بوٹ کے شروع ہونے کے بعد چلتا ہے
- `foundryLocalService` خودکار طور پر اسپرنگ کی طرف سے انجیکٹ ہوتا ہے (dependency injection)
- AI کو ایک ٹیسٹ پیغام بھیجتا ہے اور جواب دکھاتا ہے

### 3. AI سروس لئیر (FoundryLocalService.java)

**فائل:** `src/main/java/com/example/FoundryLocalService.java`

#### کنفیگریشن انجیکشن:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // اگر خالی ہو تو خود کار طریقے سے پتہ لگا لیا گیا
```

**یہ کیا کرتا ہے:**
- `@Service` اسپرنگ کو بتاتا ہے کہ یہ کلاس بزنس لاجک فراہم کرتی ہے
- `@Value` application.properties سے کنفیگریشن کی ویلیوز انجیکٹ کرتا ہے
- ماڈل ڈیفالٹ طور پر خالی ہے، جو سٹارٹ اپ پر فنڈری لوکل سے **آٹو ڈیٹیکشن** کو متحرک کرتا ہے۔ اس کا مطلب ہے ایپ کسی بھی ماڈل کے ساتھ کام کرتی ہے جو فنڈری لوکل میں لوڈ ہو، بغیر دستی کنفیگریشن کے۔

#### کلائنٹ کی ابتدائی تیاری:
```java
@PostConstruct
public void init() {
    // اگر صراحت سے ترتیب نہیں دی گئی ہے تو ماڈل کو Foundry Local سے خود بخود شناخت کریں
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // بیس یو آر ایل میں پہلے سے ہی کنفیگریشن سے /v1 شامل ہے
            .apiKey("not-needed")            // لوکل سرور کو حقیقی API کلید کی ضرورت نہیں ہے
            .build();
}
```

**یہ کیا کرتا ہے:**
- `@PostConstruct` یہ میتھڈ چلتا ہے جب اسپرنگ سروس کو بناتا ہے
- اگر کوئی ماڈل کنفیگر نہیں ہے، تو یہ فنڈری لوکل کے `/v1/models` اینڈپوائنٹ کو کال کر کے پہلا دستیاب ماڈل منتخب کرتا ہے
- ایک OpenAI کلائنٹ بناتا ہے جو آپ کے مقامی فنڈری لوکل انسٹینس کی طرف اشارہ کرتا ہے
- application.properties سے بیس URL پہلے ہی `/v1` کو شامل کرتا ہے تاکہ اوپن AI API سے ہم آہنگی ہو
- API کی کو "not-needed" سیٹ کیا گیا ہے کیونکہ لوکل ڈیولپمنٹ میں کوئی تصدیق کی ضرورت نہیں

#### چیٹ میتھڈ:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // کونسا AI ماڈل استعمال کرنا ہے
                .addUserMessage(message)         // آپ کا سوال/پرومپٹ
                .maxCompletionTokens(150)        // جواب کی لمبائی کی حد مقرر کریں
                .temperature(0.7)                // تخلیقی صلاحیت کو کنٹرول کریں (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // API کے نتیجے سے AI کا جواب نکالیں
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**یہ کیا کرتا ہے:**
- **ChatCompletionCreateParams**: AI درخواست کو ترتیب دیتا ہے
  - `model`: وہ AI ماڈل منتخب کرتا ہے جسے استعمال کرنا ہے (یہ `foundry model list` سے عین مطابق ID ہونی چاہیے)
  - `addUserMessage`: آپ کا پیغام بات چیت میں شامل کرتا ہے
  - `maxCompletionTokens`: جواب کی لمبائی کی حد مقرر کرتا ہے (وسائل بچانے کے لیے)
  - `temperature`: تصادفی پن کنٹرول کرتا ہے (0.0 = یقینی، 1.0 = تخلیقی)
- **API کال**: درخواست فنڈری لوکل کو بھیجتا ہے
- **جواب کی پراسیسنگ**: AI کے جواب کو محفوظ طریقے سے نکالتا ہے
- **خرابی کا ہینڈلنگ**: استثنائی حالات کو مفید پیغامات کے ساتھ لپیٹتا ہے

### 4. پروجیکٹ کی انحصاریاں (pom.xml)

**اہم انحصاریاں:**

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

**یہ کیا کرتی ہیں:**
- **spring-boot-starter**: بنیادی اسپرنگ بوٹ فعالیت فراہم کرتی ہے
- **openai-java**: اوپن AI کی جاوا SDK، API مواصلات کے لیے
- **jackson-databind**: JSON سیریلائزیشن/ڈیسریلائزیشن کو ہینڈل کرتی ہے API کالز کے لیے

## یہ سب کیسے ایک ساتھ کام کرتا ہے

جب آپ ایپلیکیشن چلائیں گے تو مکمل بہاؤ کچھ یوں ہوگا:

1. **سٹارٹ اپ**: اسپرنگ بوٹ شروع ہوتا ہے اور `application.properties` پڑھتا ہے
2. **سروس کی تخلیق**: اسپرنگ `FoundryLocalService` بناتا ہے اور کنفیگریشن ویلیوز انجیکٹ کرتا ہے
3. **ماڈل کی شناخت**: اگر کوئی ماڈل سیٹ نہیں ہے، تو سروس فنڈری لوکل کے `/v1/models` اینڈپوائنٹ کو کال کرتا ہے اور خودکار طور پر پہلا دستیاب ماڈل استعمال کرتا ہے
4. **کلائنٹ کی تیاری**: `@PostConstruct` OpenAI کلائنٹ کو فنڈری لوکل سے کنیکٹ کرنے کے لیے تیار کرتا ہے
5. **ڈیمو کی عمل آوری**: `CommandLineRunner` سٹارٹ اپ کے بعد چلتا ہے
6. **AI کال**: ڈیمو `foundryLocalService.chat()` کو ایک ٹیسٹ پیغام کے ساتھ کال کرتا ہے
7. **API درخواست**: سروس فنڈری لوکل کو اوپن AI کے مطابق درخواست تیار اور بھیجتی ہے
8. **جواب کی پراسیسنگ**: سروس AI کے جواب کو نکالتی ہے اور واپس بھیجتی ہے
9. **ظاہر کرنا**: ایپ جواب کو پرنٹ کرتی ہے اور بند ہوجاتی ہے

## فنڈری لوکل سیٹ اپ کرنا

1. [ضروریات](#ضروریات) حصے میں دی گئی ہدایات کے مطابق **فنڈری لوکل انسٹال کریں**۔

2. اگر پہلے سے سروس نہیں چل رہی، تو اسے شروع کریں:
   ```bash
   foundry service start
   ```

3. سروس کی حالت چیک کریں تاکہ تصدیق ہو کہ چل رہی ہے اور پورٹ نوٹ کریں:
   ```bash
   foundry service status
   ```

4. ماڈل ڈاؤن لوڈ اور چلائیں (پہلی بار ڈاؤن لوڈ ہوتا ہے، بعد میں کیش کیا جاتا ہے):
   ```bash
   foundry model run phi-4-mini
   ```
   یہ ایک انٹرایکٹو چیٹ سیشن کھولتا ہے۔ آپ `Ctrl+C` سے باہر نکل سکتے ہیں۔ ماڈل سروس میں لوڈ شدہ رہتا ہے۔

   > **مشورہ:** `foundry model list` چلائیں تاکہ دستیاب تمام ماڈلز دیکھ سکیں۔ `phi-4-mini` کو کیٹلاگ میں سے کسی بھی عرفی نام سے بدلیں (مثلاً `qwen2.5-0.5b` چھوٹے/تیز ماڈل کے لیے)۔

5. ماڈل کے لوڈ ہونے کی تصدیق کریں:
   ```bash
   foundry service ps
   ```

6. اگر ضروری ہو تو `application.properties` اپ ڈیٹ کریں:
   - ڈیفالٹ `base-url` (`http://localhost:5273/v1`) CLI کے ڈیفالٹ پورٹ سے میل کھاتا ہے۔ اسے صرف تب ہی اپ ڈیٹ کریں جب `foundry service status` مختلف پورٹ دکھائے۔
   - ماڈل کو **سٹارٹ اپ پر خودکار شناخت** کر لیا جاتا ہے — کوئی اضافی کنفیگریشن کی ضرورت نہیں۔

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## ایپلیکیشن چلانا

### مرحلہ 1: یقینی بنائیں کہ فنڈری لوکل میں کوئی ماڈل لوڈ ہے
```bash
foundry service ps
```
اگر کوئی ماڈل لسٹ میں نہیں ہے، تو ایک لوڈ کریں:
```bash
foundry model run phi-4-mini
```

### مرحلہ 2: ایپلیکیشن بنائیں اور چلائیں
ایک الگ ٹرمینل میں:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

یا JAR بنائیں اور چلائیں:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## متوقع نتیجہ

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

## آئندہ کے اقدامات

مزید مثالوں کے لیے دیکھیں [باب 04: عملی نمونے](../README.md)

## مسائل کا حل

### عام مسائل

**"Connection refused" یا "Service unavailable"**
- سروس چیک کریں: `foundry service status`
- اگر ضرورت ہو تو ری اسٹارٹ کریں: `foundry service restart`
- `application.properties` میں پورٹ اور `foundry service status` کی مطابقت چیک کریں
- یقینی بنائیں URL `/v1` پر ختم ہوتا ہے: `http://localhost:5273/v1`

**"No model found" شروع کرنے پر**
- ایپ خودکار طور پر ماڈل کو پہچانتی ہے۔ یقینی بنائیں کم از کم ایک ماڈل لوڈ ہے: `foundry service ps`
- اگر کوئی ماڈل لوڈ نہیں ہے تو: `foundry model run phi-4-mini`
- اگر آپ نے `application.properties` میں ماڈل نام تبدیل کیا ہے تو چیک کریں کہ وہ `foundry model list` سے میل کھاتا ہو

**"400 Bad Request" کی غلطیاں**
- یقینی بنائیں بیس URL میں `/v1` شامل ہے: `http://localhost:5273/v1`
- اپنے کوڈ میں `maxCompletionTokens()` استعمال کریں (پرانی `maxTokens()` نہیں)

**میون کمپائلیشن کی غلطیاں**
- یقینی بنائیں جاوا 21 یا اس سے جدید ہے: `java -version`
- صاف کریں اور دوبارہ کمپائل کریں: `mvn clean compile`
- انٹرنیٹ کنکشن چیک کریں تاکہ انحصاریاں ڈاؤن لوڈ ہو سکیں

**سروس کنکشن کے مسائل**
- اگر آپ کو `Request to local service failed` نظر آتا ہے، تو چلائیں: `foundry service restart`
- لوڈ شدہ ماڈلز دیکھیں: `foundry service ps`
- سروس لاگز دیکھیں: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**عارضی تردید**:  
یہ دستاویز AI ترجمہ سروس [Co-op Translator](https://github.com/Azure/co-op-translator) کا استعمال کرتے ہوئے ترجمہ کی گئی ہے۔ اگرچہ ہم درستگی کے لئے کوشش کرتے ہیں، براہ کرم آگاہ رہیں کہ خودکار ترجمے میں غلطیاں یا عدم صحت ہو سکتی ہے۔ اصل دستاویز اپنی مادری زبان میں معتبر ماخذ سمجھا جانا چاہیے۔ اہم معلومات کے لیے، پیشہ ور انسانی ترجمہ تجویز کیا جاتا ہے۔ اس ترجمے کے استعمال سے پیدا ہونے والی کسی بھی غلط فہمی یا غلط تشریحات کے لیے ہم ذمہ دار نہیں ہیں۔
<!-- CO-OP TRANSLATOR DISCLAIMER END -->