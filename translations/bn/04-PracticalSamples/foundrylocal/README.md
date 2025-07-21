<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T18:13:38+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "bn"
}
-->
# ফাউন্ড্রি লোকাল কমান্ড-লাইন অ্যাপ্লিকেশন

>**নোট**: এই অধ্যায়ে একটি [**টিউটোরিয়াল**](./TUTORIAL.md) অন্তর্ভুক্ত রয়েছে যা আপনাকে সমাপ্ত নমুনাগুলি চালানোর মাধ্যমে গাইড করবে।

একটি সহজ স্প্রিং বুট কমান্ড-লাইন অ্যাপ্লিকেশন যা OpenAI Java SDK ব্যবহার করে ফাউন্ড্রি লোকালের সাথে সংযোগ স্থাপনের পদ্ধতি প্রদর্শন করে।

## আপনি কী শিখবেন

- OpenAI Java SDK ব্যবহার করে কীভাবে ফাউন্ড্রি লোকালকে স্প্রিং বুট অ্যাপ্লিকেশনের সাথে সংযুক্ত করবেন
- স্থানীয় AI ডেভেলপমেন্ট এবং টেস্টিংয়ের সেরা পদ্ধতিগুলি

## বিষয়সূচি

- [আপনি কী শিখবেন](../../../../04-PracticalSamples/foundrylocal)
- [প্রয়োজনীয়তা](../../../../04-PracticalSamples/foundrylocal)
  - [ফাউন্ড্রি লোকাল ইনস্টল করা](../../../../04-PracticalSamples/foundrylocal)
  - [যাচাই](../../../../04-PracticalSamples/foundrylocal)
- [কনফিগারেশন](../../../../04-PracticalSamples/foundrylocal)
- [দ্রুত শুরু](../../../../04-PracticalSamples/foundrylocal)
- [অ্যাপ্লিকেশনটি কী করে](../../../../04-PracticalSamples/foundrylocal)
- [নমুনা আউটপুট](../../../../04-PracticalSamples/foundrylocal)
- [আর্কিটেকচার](../../../../04-PracticalSamples/foundrylocal)
- [কোডের হাইলাইটস](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI Java SDK ইন্টিগ্রেশন](../../../../04-PracticalSamples/foundrylocal)
  - [চ্যাট কমপ্লিশন API](../../../../04-PracticalSamples/foundrylocal)
- [সমস্যা সমাধান](../../../../04-PracticalSamples/foundrylocal)

## প্রয়োজনীয়তা

> **⚠️ নোট**: এই অ্যাপ্লিকেশনটি **সরবরাহকৃত ডেভকন্টেইনারে চালানো যায় না** কারণ এটি ফাউন্ড্রি লোকাল ইনস্টল এবং হোস্ট সিস্টেমে চালানোর প্রয়োজন।

### ফাউন্ড্রি লোকাল ইনস্টল করা

এই অ্যাপ্লিকেশনটি চালানোর আগে, আপনাকে ফাউন্ড্রি লোকাল ইনস্টল এবং শুরু করতে হবে। নিম্নলিখিত ধাপগুলি অনুসরণ করুন:

1. **আপনার সিস্টেমের প্রয়োজনীয়তা নিশ্চিত করুন**:
   - **অপারেটিং সিস্টেম**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, অথবা macOS
   - **হার্ডওয়্যার**: 
     - ন্যূনতম: 8GB RAM, 3GB ফ্রি ডিস্ক স্পেস
     - সুপারিশকৃত: 16GB RAM, 15GB ফ্রি ডিস্ক স্পেস
   - **নেটওয়ার্ক**: প্রাথমিক মডেল ডাউনলোডের জন্য ইন্টারনেট সংযোগ (অফলাইন ব্যবহারের জন্য ঐচ্ছিক)
   - **অ্যাক্সিলারেশন (ঐচ্ছিক)**: NVIDIA GPU (2,000 সিরিজ বা নতুন), AMD GPU (6,000 সিরিজ বা নতুন), Qualcomm Snapdragon X Elite (8GB বা তার বেশি মেমরি), অথবা Apple silicon
   - **অনুমতি**: আপনার ডিভাইসে সফটওয়্যার ইনস্টল করার জন্য প্রশাসনিক অনুমতি

2. **ফাউন্ড্রি লোকাল ইনস্টল করুন**:
   
   **Windows এর জন্য:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **macOS এর জন্য:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   বিকল্পভাবে, আপনি [Foundry Local GitHub repository](https://github.com/microsoft/Foundry-Local) থেকে ইনস্টলার ডাউনলোড করতে পারেন।

3. **আপনার প্রথম মডেল শুরু করুন**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   মডেলটি ডাউনলোড হবে (যা আপনার ইন্টারনেট গতির উপর নির্ভর করে কয়েক মিনিট সময় নিতে পারে) এবং তারপর চালু হবে। ফাউন্ড্রি লোকাল স্বয়ংক্রিয়ভাবে আপনার সিস্টেমের জন্য সেরা মডেল ভ্যারিয়েন্ট নির্বাচন করে (NVIDIA GPU এর জন্য CUDA, অন্যথায় CPU সংস্করণ)।

4. **মডেলটি পরীক্ষা করুন** একই টার্মিনালে একটি প্রশ্ন জিজ্ঞাসা করে:

   ```bash
   Why is the sky blue?
   ```

   আপনি একটি উত্তর দেখতে পাবেন যেখানে Phi মডেল ব্যাখ্যা করবে কেন আকাশ নীল দেখায়।

### যাচাই

নিম্নলিখিত কমান্ডগুলি ব্যবহার করে আপনি যাচাই করতে পারেন যে সবকিছু সঠিকভাবে কাজ করছে:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

আপনি `http://localhost:5273` এ আপনার ব্রাউজারে গিয়ে ফাউন্ড্রি লোকালের ওয়েব ইন্টারফেসও দেখতে পারেন।

## কনফিগারেশন

অ্যাপ্লিকেশনটি `application.properties` এর মাধ্যমে কনফিগার করা যায়:

- `foundry.local.base-url` - ফাউন্ড্রি লোকালের বেস URL (ডিফল্ট: http://localhost:5273)
- `foundry.local.model` - ব্যবহৃত AI মডেল (ডিফল্ট: Phi-3.5-mini-instruct-cuda-gpu)

> **নোট**: কনফিগারেশনে মডেলের নামটি ফাউন্ড্রি লোকাল আপনার সিস্টেমের জন্য ডাউনলোড করা নির্দিষ্ট ভ্যারিয়েন্টের সাথে মিলে যেতে হবে। যখন আপনি `foundry model run phi-3.5-mini` চালান, ফাউন্ড্রি লোকাল স্বয়ংক্রিয়ভাবে সেরা ভ্যারিয়েন্ট নির্বাচন এবং ডাউনলোড করে (NVIDIA GPU এর জন্য CUDA, অন্যথায় CPU সংস্করণ)। আপনার স্থানীয় ইনস্ট্যান্সে উপলব্ধ সঠিক মডেলের নাম দেখতে `foundry model list` ব্যবহার করুন।

## দ্রুত শুরু

### 1. ফাউন্ড্রি লোকাল অ্যাপ্লিকেশন ডিরেক্টরিতে যান
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. অ্যাপ্লিকেশন চালান

```bash
mvn spring-boot:run
```

অথবা JAR তৈরি করে চালান:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### নির্ভরশীলতা

এই অ্যাপ্লিকেশনটি ফাউন্ড্রি লোকালের সাথে যোগাযোগ করতে OpenAI Java SDK ব্যবহার করে। মূল নির্ভরশীলতা:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

অ্যাপ্লিকেশনটি ডিফল্ট পোর্টে চলমান ফাউন্ড্রি লোকালের সাথে সংযোগ করার জন্য প্রি-কনফিগার করা।

## অ্যাপ্লিকেশনটি কী করে

যখন আপনি অ্যাপ্লিকেশনটি চালান:

1. **কমান্ড-লাইন অ্যাপ্লিকেশন** হিসেবে শুরু হয় (কোনো ওয়েব সার্ভার নয়)
2. **স্বয়ংক্রিয়ভাবে একটি টেস্ট মেসেজ পাঠায়**: "হ্যালো! আপনি কী এবং আপনি কোন মডেল চালাচ্ছেন তা কি বলতে পারেন?"
3. **ফাউন্ড্রি লোকাল থেকে প্রাপ্ত উত্তরটি প্রদর্শন করে** কনসোলে
4. **ডেমো শেষ হওয়ার পর পরিষ্কারভাবে বন্ধ হয়**

## নমুনা আউটপুট

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## আর্কিটেকচার

- **Application.java** - প্রধান স্প্রিং বুট অ্যাপ্লিকেশন CommandLineRunner সহ
- **FoundryLocalService.java** - OpenAI Java SDK ব্যবহার করে ফাউন্ড্রি লোকালের সাথে যোগাযোগ করার জন্য সার্ভিস
- **OpenAI Java SDK** ব্যবহার করে টাইপ-সেফ API কল
- SDK দ্বারা স্বয়ংক্রিয় JSON সিরিয়ালাইজেশন/ডিসিরিয়ালাইজেশন পরিচালিত
- Spring এর `@Value` এবং `@PostConstruct` অ্যানোটেশন ব্যবহার করে পরিষ্কার কনফিগারেশন

## কোডের হাইলাইটস

### OpenAI Java SDK ইন্টিগ্রেশন

অ্যাপ্লিকেশনটি OpenAI Java SDK ব্যবহার করে ফাউন্ড্রি লোকালের জন্য একটি ক্লায়েন্ট তৈরি করে:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### চ্যাট কমপ্লিশন API

চ্যাট কমপ্লিশন অনুরোধ করা সহজ এবং টাইপ-সেফ:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## সমস্যার সমাধান

যদি আপনি সংযোগ ত্রুটি দেখেন:
1. নিশ্চিত করুন ফাউন্ড্রি লোকাল `http://localhost:5273` এ চালু রয়েছে
2. `foundry model list` ব্যবহার করে নিশ্চিত করুন যে একটি Phi-3.5-mini মডেল ভ্যারিয়েন্ট উপলব্ধ
3. `application.properties` এ মডেলের নামটি তালিকায় প্রদর্শিত সঠিক মডেলের নামের সাথে মেলে কিনা তা পরীক্ষা করুন
4. নিশ্চিত করুন কোনো ফায়ারওয়াল সংযোগটি ব্লক করছে না

সাধারণ সমস্যা:
- **মডেল পাওয়া যায়নি**: `foundry model run phi-3.5-mini` চালিয়ে মডেলটি ডাউনলোড এবং চালু করুন
- **সার্ভিস চালু নেই**: ফাউন্ড্রি লোকাল সার্ভিসটি বন্ধ হয়ে থাকতে পারে; মডেল রান কমান্ড দিয়ে এটি পুনরায় চালু করুন
- **ভুল মডেলের নাম**: উপলব্ধ মডেল দেখতে `foundry model list` ব্যবহার করুন এবং আপনার কনফিগারেশন অনুযায়ী আপডেট করুন

**অস্বীকৃতি**:  
এই নথিটি AI অনুবাদ পরিষেবা [Co-op Translator](https://github.com/Azure/co-op-translator) ব্যবহার করে অনুবাদ করা হয়েছে। আমরা যথাসাধ্য সঠিকতার জন্য চেষ্টা করি, তবে অনুগ্রহ করে মনে রাখবেন যে স্বয়ংক্রিয় অনুবাদে ত্রুটি বা অসঙ্গতি থাকতে পারে। মূল ভাষায় থাকা নথিটিকে প্রামাণিক উৎস হিসেবে বিবেচনা করা উচিত। গুরুত্বপূর্ণ তথ্যের জন্য, পেশাদার মানব অনুবাদ সুপারিশ করা হয়। এই অনুবাদ ব্যবহারের ফলে কোনো ভুল বোঝাবুঝি বা ভুল ব্যাখ্যা হলে আমরা তার জন্য দায়ী থাকব না।