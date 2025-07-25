<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T09:12:08+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "bn"
}
-->
# পেট স্টোরি অ্যাপ

>**Note**: এই অধ্যায়ে একটি [**টিউটোরিয়াল**](./TUTORIAL.md) রয়েছে যা আপনাকে নমুনাগুলোর মাধ্যমে গাইড করবে।

একটি স্প্রিং বুট ওয়েব অ্যাপ্লিকেশন যা আপলোড করা পোষা প্রাণীর ছবির জন্য GitHub মডেল ব্যবহার করে AI-চালিত বিবরণ এবং গল্প তৈরি করে।

## সূচিপত্র

- [প্রযুক্তি স্ট্যাক](../../../../04-PracticalSamples/petstory)
- [প্রয়োজনীয়তা](../../../../04-PracticalSamples/petstory)
- [সেটআপ ও ইনস্টলেশন](../../../../04-PracticalSamples/petstory)
- [ব্যবহার](../../../../04-PracticalSamples/petstory)

## প্রযুক্তি স্ট্যাক

- **ব্যাকএন্ড**: Spring Boot 3.5.3, Java 21
- **AI ইন্টিগ্রেশন**: OpenAI Java SDK GitHub মডেলের সাথে
- **নিরাপত্তা**: Spring Security
- **ফ্রন্টএন্ড**: Thymeleaf টেমপ্লেট Bootstrap স্টাইলিং সহ
- **বিল্ড টুল**: Maven
- **AI মডেল**: GitHub মডেল

## প্রয়োজনীয়তা

- Java 21 বা তার বেশি
- Maven 3.9+
- `models:read` স্কোপ সহ GitHub ব্যক্তিগত অ্যাক্সেস টোকেন

## সেটআপ ও ইনস্টলেশন

### ১. পেটস্টোরি অ্যাপ্লিকেশন ডিরেক্টরিতে যান
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### ২. পরিবেশ ভেরিয়েবল সেট করুন
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### ৩. অ্যাপ্লিকেশন তৈরি করুন
```bash
mvn clean compile
```

### ৪. অ্যাপ্লিকেশন চালান
```bash
mvn spring-boot:run
```

## ব্যবহার

1. **অ্যাপ্লিকেশনে প্রবেশ করুন**: `http://localhost:8080` এ যান
2. **ছবি আপলোড করুন**: "Choose File" ক্লিক করুন এবং একটি পোষা প্রাণীর ছবি নির্বাচন করুন
3. **ছবি বিশ্লেষণ করুন**: "Analyze Image" ক্লিক করুন AI বিবরণ পেতে
4. **গল্প তৈরি করুন**: "Generate Story" ক্লিক করুন গল্প তৈরি করতে

**অস্বীকৃতি**:  
এই নথিটি AI অনুবাদ পরিষেবা [Co-op Translator](https://github.com/Azure/co-op-translator) ব্যবহার করে অনুবাদ করা হয়েছে। আমরা যথাসম্ভব সঠিক অনুবাদ প্রদানের চেষ্টা করি, তবে অনুগ্রহ করে মনে রাখবেন যে স্বয়ংক্রিয় অনুবাদে ত্রুটি বা অসঙ্গতি থাকতে পারে। মূল ভাষায় থাকা নথিটিকে প্রামাণিক উৎস হিসেবে বিবেচনা করা উচিত। গুরুত্বপূর্ণ তথ্যের জন্য, পেশাদার মানব অনুবাদ সুপারিশ করা হয়। এই অনুবাদ ব্যবহারের ফলে কোনো ভুল বোঝাবুঝি বা ভুল ব্যাখ্যা হলে আমরা দায়বদ্ধ থাকব না।