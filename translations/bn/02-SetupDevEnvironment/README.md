<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c670445516e119888d8aaaa207bbee34",
  "translation_date": "2025-07-27T13:00:27+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "bn"
}
-->
# জেনারেটিভ AI এর জন্য জাভা ডেভেলপমেন্ট এনভায়রনমেন্ট সেটআপ

> **দ্রুত শুরু**: ক্লাউডে কোডিং শুরু করুন মাত্র ২ মিনিটে - [GitHub Codespaces Setup](../../../02-SetupDevEnvironment) এ যান - কোনো লোকাল ইনস্টলেশন প্রয়োজন নেই এবং এটি GitHub মডেল ব্যবহার করে!

> **Azure OpenAI-এ আগ্রহী?**, আমাদের [Azure OpenAI Setup Guide](getting-started-azure-openai.md) দেখুন যেখানে নতুন Azure OpenAI রিসোর্স তৈরি করার ধাপগুলো রয়েছে।

## আপনি যা শিখবেন

- AI অ্যাপ্লিকেশনের জন্য একটি জাভা ডেভেলপমেন্ট এনভায়রনমেন্ট সেটআপ করবেন
- আপনার পছন্দের ডেভেলপমেন্ট এনভায়রনমেন্ট নির্বাচন এবং কনফিগার করবেন (Codespaces সহ ক্লাউড-ফার্স্ট, লোকাল ডেভ কন্টেইনার, বা সম্পূর্ণ লোকাল সেটআপ)
- GitHub মডেলের সাথে সংযোগ স্থাপন করে আপনার সেটআপ পরীক্ষা করবেন

## বিষয়বস্তু সূচি

- [আপনি যা শিখবেন](../../../02-SetupDevEnvironment)
- [ভূমিকা](../../../02-SetupDevEnvironment)
- [ধাপ ১: আপনার ডেভেলপমেন্ট এনভায়রনমেন্ট সেটআপ করুন](../../../02-SetupDevEnvironment)
  - [অপশন A: GitHub Codespaces (প্রস্তাবিত)](../../../02-SetupDevEnvironment)
  - [অপশন B: লোকাল ডেভ কন্টেইনার](../../../02-SetupDevEnvironment)
  - [অপশন C: আপনার বিদ্যমান লোকাল ইনস্টলেশন ব্যবহার করুন](../../../02-SetupDevEnvironment)
- [ধাপ ২: GitHub ব্যক্তিগত অ্যাক্সেস টোকেন তৈরি করুন](../../../02-SetupDevEnvironment)
- [ধাপ ৩: আপনার সেটআপ পরীক্ষা করুন](../../../02-SetupDevEnvironment)
- [সমস্যা সমাধান](../../../02-SetupDevEnvironment)
- [সারাংশ](../../../02-SetupDevEnvironment)
- [পরবর্তী ধাপ](../../../02-SetupDevEnvironment)

## ভূমিকা

এই অধ্যায়টি আপনাকে একটি ডেভেলপমেন্ট এনভায়রনমেন্ট সেটআপ করতে সাহায্য করবে। আমরা **GitHub মডেল** ব্যবহার করব কারণ এটি বিনামূল্যে, শুধুমাত্র একটি GitHub অ্যাকাউন্ট দিয়ে সহজে সেটআপ করা যায়, কোনো ক্রেডিট কার্ড প্রয়োজন হয় না, এবং একাধিক মডেলের সাথে পরীক্ষা করার সুযোগ দেয়।

**লোকাল সেটআপ প্রয়োজন নেই!** আপনি GitHub Codespaces ব্যবহার করে ব্রাউজারে একটি পূর্ণ ডেভেলপমেন্ট এনভায়রনমেন্টে কোডিং শুরু করতে পারেন।

<img src="./images/models.webp" alt="Screenshot: GitHub Models" width="50%">

আমরা এই কোর্সের জন্য [**GitHub মডেল**](https://github.com/marketplace?type=models) ব্যবহার করার সুপারিশ করছি কারণ এটি:
- **বিনামূল্যে** শুরু করার জন্য
- **সহজ** শুধুমাত্র একটি GitHub অ্যাকাউন্ট দিয়ে সেটআপ করা যায়
- **কোনো ক্রেডিট কার্ড** প্রয়োজন নেই
- **একাধিক মডেল** পরীক্ষার জন্য উপলব্ধ

> **নোট**: এই প্রশিক্ষণে ব্যবহৃত GitHub মডেলের বিনামূল্যের সীমাবদ্ধতা:
> - প্রতি মিনিটে ১৫টি অনুরোধ (প্রতিদিন ১৫০টি)
> - ~৮,০০০ শব্দ ইনপুট, ~৪,০০০ শব্দ আউটপুট প্রতি অনুরোধে
> - ৫টি একযোগে অনুরোধ
> 
> প্রোডাকশন ব্যবহারের জন্য, আপনার Azure অ্যাকাউন্ট দিয়ে Azure AI Foundry মডেলে আপগ্রেড করুন। আপনার কোড পরিবর্তন করতে হবে না। [Azure AI Foundry ডকুমেন্টেশন](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models) দেখুন।

## ধাপ ১: আপনার ডেভেলপমেন্ট এনভায়রনমেন্ট সেটআপ করুন

<a name="quick-start-cloud"></a>

আমরা একটি প্রি-কনফিগারড ডেভেলপমেন্ট কন্টেইনার তৈরি করেছি যাতে সেটআপ সময় কমানো যায় এবং এই জেনারেটিভ AI এর জন্য জাভা কোর্সে প্রয়োজনীয় সমস্ত টুল থাকে। আপনার পছন্দের ডেভেলপমেন্ট পদ্ধতি নির্বাচন করুন:

### এনভায়রনমেন্ট সেটআপ অপশন:

#### অপশন A: GitHub Codespaces (প্রস্তাবিত)

**২ মিনিটে কোডিং শুরু করুন - কোনো লোকাল সেটআপ প্রয়োজন নেই!**

1. এই রিপোজিটরি আপনার GitHub অ্যাকাউন্টে ফর্ক করুন
   > **নোট**: যদি আপনি বেসিক কনফিগ সম্পাদনা করতে চান, [Dev Container Configuration](../../../.devcontainer/devcontainer.json) দেখুন
2. **Code** → **Codespaces** ট্যাব → **...** → **New with options...** এ ক্লিক করুন
3. ডিফল্ট সেটিংস ব্যবহার করুন – এটি **Generative AI Java Development Environment** কাস্টম ডেভকন্টেইনার নির্বাচন করবে যা এই কোর্সের জন্য তৈরি করা হয়েছে
4. **Create codespace** এ ক্লিক করুন
5. এনভায়রনমেন্ট প্রস্তুত হতে ~২ মিনিট অপেক্ষা করুন
6. [ধাপ ২: GitHub টোকেন তৈরি করুন](../../../02-SetupDevEnvironment) এ এগিয়ে যান

<img src="./images/codespaces.png" alt="Screenshot: Codespaces submenu" width="50%">

<img src="./images/image.png" alt="Screenshot: New with options" width="50%">

<img src="./images/codespaces-create.png" alt="Screenshot: Create codespace options" width="50%">


> **Codespaces এর সুবিধা**:
> - কোনো লোকাল ইনস্টলেশন প্রয়োজন নেই
> - যে কোনো ব্রাউজার সহ ডিভাইসে কাজ করে
> - সমস্ত টুল এবং ডিপেন্ডেন্সি সহ প্রি-কনফিগারড
> - ব্যক্তিগত অ্যাকাউন্টের জন্য প্রতি মাসে বিনামূল্যে ৬০ ঘণ্টা
> - সকল শিক্ষার্থীর জন্য একটি কনসিস্টেন্ট এনভায়রনমেন্ট

#### অপশন B: লোকাল ডেভ কন্টেইনার

**যারা Docker সহ লোকাল ডেভেলপমেন্ট পছন্দ করেন তাদের জন্য**

1. এই রিপোজিটরি আপনার লোকাল মেশিনে ফর্ক এবং ক্লোন করুন
   > **নোট**: যদি আপনি বেসিক কনফিগ সম্পাদনা করতে চান, [Dev Container Configuration](../../../.devcontainer/devcontainer.json) দেখুন
2. [Docker Desktop](https://www.docker.com/products/docker-desktop/) এবং [VS Code](https://code.visualstudio.com/) ইনস্টল করুন
3. VS Code-এ [Dev Containers extension](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) ইনস্টল করুন
4. রিপোজিটরি ফোল্ডারটি VS Code-এ খুলুন
5. প্রম্পট এলে **Reopen in Container** এ ক্লিক করুন (বা `Ctrl+Shift+P` → "Dev Containers: Reopen in Container" ব্যবহার করুন)
6. কন্টেইনারটি তৈরি এবং শুরু হওয়ার জন্য অপেক্ষা করুন
7. [ধাপ ২: GitHub টোকেন তৈরি করুন](../../../02-SetupDevEnvironment) এ এগিয়ে যান

<img src="./images/devcontainer.png" alt="Screenshot: Dev container setup" width="50%">

<img src="./images/image-3.png" alt="Screenshot: Dev container build complete" width="50%">

#### অপশন C: আপনার বিদ্যমান লোকাল ইনস্টলেশন ব্যবহার করুন

**যারা বিদ্যমান জাভা এনভায়রনমেন্ট ব্যবহার করেন তাদের জন্য**

প্রয়োজনীয়তা:
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) বা আপনার পছন্দের IDE

ধাপ:
1. এই রিপোজিটরি আপনার লোকাল মেশিনে ক্লোন করুন
2. আপনার IDE-তে প্রজেক্টটি খুলুন
3. [ধাপ ২: GitHub টোকেন তৈরি করুন](../../../02-SetupDevEnvironment) এ এগিয়ে যান

> **প্রো টিপ**: যদি আপনার কম স্পেসিফিকেশন মেশিন থাকে কিন্তু লোকাল VS Code চান, GitHub Codespaces ব্যবহার করুন! আপনি আপনার লোকাল VS Code কে ক্লাউড-হোস্টেড Codespace এর সাথে সংযুক্ত করতে পারেন।

<img src="./images/image-2.png" alt="Screenshot: created local devcontainer instance" width="50%">


## ধাপ ২: GitHub ব্যক্তিগত অ্যাক্সেস টোকেন তৈরি করুন

1. [GitHub Settings](https://github.com/settings/profile) এ যান এবং আপনার প্রোফাইল মেনু থেকে **Settings** নির্বাচন করুন।
2. বাম সাইডবারে **Developer settings** এ ক্লিক করুন (সাধারণত নিচে থাকে)।
3. **Personal access tokens** এর অধীনে **Fine-grained tokens** এ ক্লিক করুন (বা এই [লিঙ্ক](https://github.com/settings/personal-access-tokens) অনুসরণ করুন)।
4. **Generate new token** এ ক্লিক করুন।
5. "Token name" এর অধীনে একটি বর্ণনামূলক নাম দিন (যেমন, `GenAI-Java-Course-Token`)।
6. একটি মেয়াদ শেষ হওয়ার তারিখ সেট করুন (নিরাপত্তার জন্য প্রস্তাবিত: ৭ দিন)।
7. "Resource owner" এর অধীনে আপনার ব্যবহারকারী অ্যাকাউন্ট নির্বাচন করুন।
8. "Repository access" এর অধীনে আপনি যে রিপোজিটরি ব্যবহার করতে চান তা নির্বাচন করুন (যদি প্রয়োজন হয় তবে "All repositories")।
9. "Repository permissions" এর অধীনে **Models** খুঁজুন এবং এটি **Read and write** এ সেট করুন।
10. **Generate token** এ ক্লিক করুন।
11. **এখনই আপনার টোকেন কপি এবং সংরক্ষণ করুন** – এটি পরে আর দেখা যাবে না!

> **নিরাপত্তা টিপ**: আপনার অ্যাক্সেস টোকেনের জন্য সর্বনিম্ন প্রয়োজনীয় স্কোপ এবং সবচেয়ে সংক্ষিপ্ত মেয়াদ শেষ হওয়ার সময় ব্যবহার করুন।

## ধাপ ৩: GitHub মডেলের উদাহরণ দিয়ে আপনার সেটআপ পরীক্ষা করুন

আপনার ডেভেলপমেন্ট এনভায়রনমেন্ট প্রস্তুত হলে, আমাদের উদাহরণ অ্যাপ্লিকেশনটি [`02-SetupDevEnvironment/examples/github-models`](../../../02-SetupDevEnvironment/examples/github-models) এ GitHub মডেল ইন্টিগ্রেশন পরীক্ষা করুন।

1. আপনার ডেভেলপমেন্ট এনভায়রনমেন্টে টার্মিনাল খুলুন।
2. GitHub মডেলের উদাহরণে যান:
   ```bash
   cd 02-SetupDevEnvironment/examples/github-models
   ```
3. আপনার GitHub টোকেন একটি এনভায়রনমেন্ট ভেরিয়েবল হিসেবে সেট করুন:
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. অ্যাপ্লিকেশন চালান:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

আপনার আউটপুট এরকম হওয়া উচিত:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### উদাহরণ কোডটি বোঝা

প্রথমে, আমরা যা চালিয়েছি তা বুঝি। `examples/github-models` এর অধীনে উদাহরণটি OpenAI Java SDK ব্যবহার করে GitHub মডেলের সাথে সংযোগ স্থাপন করে:

**এই কোডটি যা করে:**
- **সংযোগ স্থাপন করে** GitHub মডেলের সাথে আপনার ব্যক্তিগত অ্যাক্সেস টোকেন ব্যবহার করে
- AI মডেলে একটি সাধারণ "Say Hello World!" বার্তা **পাঠায়**
- AI এর প্রতিক্রিয়া **গ্রহণ করে** এবং প্রদর্শন করে
- আপনার সেটআপ সঠিকভাবে কাজ করছে কিনা তা **যাচাই করে**

**মূল ডিপেন্ডেন্সি** (`pom.xml` এ):
```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

**প্রধান কোড** (`App.java`):
```java
// Connect to GitHub Models using OpenAI Java SDK
OpenAIClient client = OpenAIOkHttpClient.builder()
    .apiKey(pat)
    .baseUrl("https://models.inference.ai.azure.com")
    .build();

// Create chat completion request
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .model(modelId)
    .addSystemMessage("You are a concise assistant.")
    .addUserMessage("Say Hello World!")
    .build();

// Get AI response
ChatCompletion response = client.chat().completions().create(params);
System.out.println("Response: " + response.choices().get(0).message().content().orElse("No response content"));
```

## সারাংশ

**অভিনন্দন!** আপনি সফলভাবে:

- **GitHub ব্যক্তিগত অ্যাক্সেস টোকেন তৈরি করেছেন** AI মডেল অ্যাক্সেসের জন্য সঠিক অনুমতি সহ
- **আপনার জাভা ডেভেলপমেন্ট এনভায়রনমেন্ট সেটআপ করেছেন** Codespaces, ডেভ কন্টেইনার, বা লোকাল ইনস্টলেশন ব্যবহার করে
- **GitHub মডেলের সাথে সংযোগ স্থাপন করেছেন** OpenAI Java SDK ব্যবহার করে বিনামূল্যে AI ডেভেলপমেন্ট অ্যাক্সেসের জন্য
- **ইন্টিগ্রেশন পরীক্ষা করেছেন** একটি কার্যকর উদাহরণ অ্যাপ্লিকেশন দিয়ে যা AI মডেলের সাথে যোগাযোগ করে

## পরবর্তী ধাপ

[অধ্যায় ৩: মূল জেনারেটিভ AI কৌশল](../03-CoreGenerativeAITechniques/README.md)

## সমস্যার সমাধান

সমস্যা হচ্ছে? এখানে সাধারণ সমস্যাগুলি এবং সমাধান রয়েছে:

- **টোকেন কাজ করছে না?** 
  - নিশ্চিত করুন যে আপনি পুরো টোকেনটি কোনো অতিরিক্ত স্পেস ছাড়াই কপি করেছেন
  - টোকেনটি সঠিকভাবে একটি এনভায়রনমেন্ট ভেরিয়েবল হিসেবে সেট করা হয়েছে কিনা যাচাই করুন
  - আপনার টোকেনের সঠিক অনুমতি আছে কিনা (Models: Read and write) যাচাই করুন

- **Maven পাওয়া যাচ্ছে না?** 
  - যদি আপনি ডেভ কন্টেইনার/Codespaces ব্যবহার করেন, Maven প্রি-ইনস্টল করা উচিত
  - লোকাল সেটআপের জন্য, নিশ্চিত করুন যে Java 21+ এবং Maven 3.9+ ইনস্টল করা আছে
  - ইনস্টলেশন যাচাই করতে `mvn --version` চেষ্টা করুন

- **সংযোগ সমস্যা?** 
  - আপনার ইন্টারনেট সংযোগ যাচাই করুন
  - GitHub আপনার নেটওয়ার্ক থেকে অ্যাক্সেসযোগ্য কিনা যাচাই করুন
  - নিশ্চিত করুন যে আপনি এমন কোনো ফায়ারওয়ালের পিছনে নেই যা GitHub মডেলের এন্ডপয়েন্ট ব্লক করছে

- **ডেভ কন্টেইনার শুরু হচ্ছে না?** 
  - নিশ্চিত করুন যে Docker Desktop চালু আছে (লোকাল ডেভেলপমেন্টের জন্য)
  - কন্টেইনারটি পুনরায় তৈরি করার চেষ্টা করুন: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container"

- **অ্যাপ্লিকেশন কম্পাইলেশন ত্রুটি?**
  - নিশ্চিত করুন যে আপনি সঠিক ডিরেক্টরিতে আছেন: `02-SetupDevEnvironment/examples/github-models`
  - পরিষ্কার এবং পুনরায় তৈরি করার চেষ্টা করুন: `mvn clean compile`

> **সাহায্য দরকার?**: এখনো সমস্যা হচ্ছে? রিপোজিটরিতে একটি ইস্যু খুলুন এবং আমরা আপনাকে সাহায্য করব।

**অস্বীকৃতি**:  
এই নথিটি AI অনুবাদ পরিষেবা [Co-op Translator](https://github.com/Azure/co-op-translator) ব্যবহার করে অনুবাদ করা হয়েছে। আমরা যথাসাধ্য সঠিক অনুবাদের চেষ্টা করি, তবে অনুগ্রহ করে মনে রাখবেন যে স্বয়ংক্রিয় অনুবাদে ত্রুটি বা অসঙ্গতি থাকতে পারে। নথিটির মূল ভাষায় থাকা সংস্করণটিকেই প্রামাণিক উৎস হিসেবে বিবেচনা করা উচিত। গুরুত্বপূর্ণ তথ্যের জন্য, পেশাদার মানব অনুবাদ সুপারিশ করা হয়। এই অনুবাদ ব্যবহারের ফলে সৃষ্ট কোনো ভুল বোঝাবুঝি বা ভুল ব্যাখ্যার জন্য আমরা দায়ী নই।