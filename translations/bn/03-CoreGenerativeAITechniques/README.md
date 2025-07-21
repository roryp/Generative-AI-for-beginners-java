<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T17:39:39+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "bn"
}
-->
# কোর জেনারেটিভ এআই প্রযুক্তি

>**Note**: এই অধ্যায়ে একটি বিস্তারিত [**টিউটোরিয়াল**](./TUTORIAL.md) রয়েছে যা আপনাকে প্রস্তুত নমুনাগুলি চালানোর মাধ্যমে গাইড করবে।

## আপনি কী শিখবেন
এই অধ্যায়ে, আমরা ৪টি কোর জেনারেটিভ এআই প্রযুক্তি ব্যবহারিক উদাহরণের মাধ্যমে দেখব:
- LLM কমপ্লিশন এবং চ্যাট ফ্লো
- ফাংশন কলিং
- রিট্রিভাল-অগমেন্টেড জেনারেশন (RAG)
- দায়িত্বশীল এআই নিরাপত্তা ব্যবস্থা

## সূচিপত্র

- [আপনি কী শিখবেন](../../../03-CoreGenerativeAITechniques)
- [প্রয়োজনীয়তা](../../../03-CoreGenerativeAITechniques)
- [শুরু করা](../../../03-CoreGenerativeAITechniques)
- [উদাহরণসমূহের সংক্ষিপ্ত বিবরণ](../../../03-CoreGenerativeAITechniques)
  - [১. LLM কমপ্লিশন এবং চ্যাট ফ্লো](../../../03-CoreGenerativeAITechniques)
  - [২. LLM এর সাথে ফাংশন এবং প্লাগইন](../../../03-CoreGenerativeAITechniques)
  - [৩. রিট্রিভাল-অগমেন্টেড জেনারেশন (RAG)](../../../03-CoreGenerativeAITechniques)
  - [৪. দায়িত্বশীল এআই নিরাপত্তা প্রদর্শন](../../../03-CoreGenerativeAITechniques)
- [সারসংক্ষেপ](../../../03-CoreGenerativeAITechniques)
- [পরবর্তী ধাপ](../../../03-CoreGenerativeAITechniques)

## প্রয়োজনীয়তা

- [অধ্যায় ২](../../../02-SetupDevEnvironment) থেকে সম্পূর্ণ সেটআপ।

## শুরু করা

1. **উদাহরণগুলিতে যান**: 
```bash
cd 03-CoreGenerativeAITechniques/examples/
```
2. **পরিবেশ সেট করুন**: 
```bash
export GITHUB_TOKEN=your_token_here
```
3. **উদাহরণগুলি কম্পাইল এবং চালান**:
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

## উদাহরণসমূহের সংক্ষিপ্ত বিবরণ

উদাহরণগুলি `examples/` ফোল্ডারে নিম্নলিখিত কাঠামোতে সংগঠিত:

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

### ১. LLM কমপ্লিশন এবং চ্যাট ফ্লো
**ফাইল**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

স্ট্রিমিং রেসপন্স এবং চ্যাট হিস্ট্রি ম্যানেজমেন্টের মাধ্যমে কথোপকথনমূলক এআই তৈরি করতে শিখুন।

এই উদাহরণটি প্রদর্শন করে:
- সিস্টেম প্রম্পট ব্যবহার করে সাধারণ টেক্সট কমপ্লিশন
- মাল্টি-টার্ন কথোপকথন এবং হিস্ট্রি ম্যানেজমেন্ট
- ইন্টারঅ্যাকটিভ চ্যাট সেশন
- প্যারামিটার কনফিগারেশন (টেম্পারেচার, ম্যাক্স টোকেন)

### ২. LLM এর সাথে ফাংশন এবং প্লাগইন
**ফাইল**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

কাস্টম ফাংশন এবং এক্সটার্নাল API-র মাধ্যমে মডেলের সক্ষমতা বৃদ্ধি করুন।

এই উদাহরণটি প্রদর্শন করে:
- আবহাওয়ার ফাংশন ইন্টিগ্রেশন
- ক্যালকুলেটর ফাংশন ইমপ্লিমেন্টেশন  
- এক কথোপকথনে একাধিক ফাংশন কল
- JSON স্কিমার মাধ্যমে ফাংশন ডেফিনিশন

### ৩. রিট্রিভাল-অগমেন্টেড জেনারেশন (RAG)
**ফাইল**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

আপনার নিজস্ব ডকুমেন্ট এবং ডেটা সোর্সের সাথে এআইকে সংযুক্ত করে সঠিক এবং প্রসঙ্গ-সচেতন রেসপন্স তৈরি করতে শিখুন।

এই উদাহরণটি প্রদর্শন করে:
- Azure OpenAI SDK ব্যবহার করে ডকুমেন্ট-ভিত্তিক প্রশ্নোত্তর
- GitHub মডেলের সাথে RAG প্যাটার্ন ইমপ্লিমেন্টেশন

**ব্যবহার**: `document.txt` এর কন্টেন্ট সম্পর্কে প্রশ্ন করুন এবং শুধুমাত্র সেই প্রসঙ্গের উপর ভিত্তি করে এআই রেসপন্স পান।

### ৪. দায়িত্বশীল এআই নিরাপত্তা প্রদর্শন
**ফাইল**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

GitHub মডেলের কন্টেন্ট ফিল্টারিং সক্ষমতা পরীক্ষা করে এআই নিরাপত্তা ব্যবস্থার একটি প্রিভিউ পান।

এই উদাহরণটি প্রদর্শন করে:
- সম্ভাব্য ক্ষতিকর প্রম্পটের জন্য কন্টেন্ট ফিল্টারিং
- অ্যাপ্লিকেশনে নিরাপত্তা রেসপন্স হ্যান্ডলিং
- ব্লকড কন্টেন্টের বিভিন্ন ক্যাটাগরি (হিংসা, ঘৃণাসূচক বক্তব্য, ভুল তথ্য)
- নিরাপত্তা লঙ্ঘনের জন্য সঠিক ত্রুটি হ্যান্ডলিং

> **আরও জানুন**: এটি দায়িত্বশীল এআই ধারণার একটি পরিচিতি মাত্র। নৈতিকতা, পক্ষপাতিত্ব নিরসন, গোপনীয়তা বিবেচনা এবং দায়িত্বশীল এআই ফ্রেমওয়ার্ক সম্পর্কে আরও জানতে দেখুন [অধ্যায় ৫: দায়িত্বশীল জেনারেটিভ এআই](../05-ResponsibleGenAI/README.md)।

## সারসংক্ষেপ

এই অধ্যায়ে, আমরা LLM কমপ্লিশন এবং চ্যাট ফ্লো অন্বেষণ করেছি, এআই সক্ষমতা বৃদ্ধি করতে ফাংশন কলিং ইমপ্লিমেন্ট করেছি, একটি রিট্রিভাল-অগমেন্টেড জেনারেশন (RAG) সিস্টেম তৈরি করেছি এবং দায়িত্বশীল এআই নিরাপত্তা ব্যবস্থা প্রদর্শন করেছি। 

> **NOTE**: প্রদত্ত [**টিউটোরিয়াল**](./TUTORIAL.md) এর মাধ্যমে আরও গভীরে যান।

## পরবর্তী ধাপ

[অধ্যায় ৪: ব্যবহারিক অ্যাপ্লিকেশন এবং প্রকল্প](../04-PracticalSamples/README.md)

**অস্বীকৃতি**:  
এই নথিটি AI অনুবাদ পরিষেবা [Co-op Translator](https://github.com/Azure/co-op-translator) ব্যবহার করে অনুবাদ করা হয়েছে। আমরা যথাসাধ্য সঠিকতা নিশ্চিত করার চেষ্টা করি, তবে অনুগ্রহ করে মনে রাখবেন যে স্বয়ংক্রিয় অনুবাদে ত্রুটি বা অসঙ্গতি থাকতে পারে। মূল ভাষায় থাকা নথিটিকে প্রামাণিক উৎস হিসেবে বিবেচনা করা উচিত। গুরুত্বপূর্ণ তথ্যের জন্য, পেশাদার মানব অনুবাদ সুপারিশ করা হয়। এই অনুবাদ ব্যবহারের ফলে কোনো ভুল বোঝাবুঝি বা ভুল ব্যাখ্যা হলে আমরা দায়বদ্ধ থাকব না।