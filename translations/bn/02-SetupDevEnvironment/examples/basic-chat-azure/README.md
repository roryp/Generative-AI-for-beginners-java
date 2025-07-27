<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "efd82efe50711d7e257eb943151d682c",
  "translation_date": "2025-07-27T13:37:49+00:00",
  "source_file": "02-SetupDevEnvironment/examples/basic-chat-azure/README.md",
  "language_code": "bn"
}
-->
# Azure OpenAI-এর সাথে বেসিক চ্যাট - সম্পূর্ণ উদাহরণ

এই উদাহরণটি দেখায় কীভাবে একটি সাধারণ Spring Boot অ্যাপ্লিকেশন তৈরি করা যায় যা Azure OpenAI-এর সাথে সংযুক্ত হয় এবং আপনার সেটআপ পরীক্ষা করে।

## বিষয়সূচি

- [প্রয়োজনীয়তা](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [দ্রুত শুরু](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [কনফিগারেশন অপশন](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [অপশন ১: পরিবেশ ভেরিয়েবল (.env ফাইল) - সুপারিশকৃত](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [অপশন ২: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [অ্যাপ্লিকেশন চালানো](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Maven ব্যবহার করে](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [VS Code ব্যবহার করে](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [প্রত্যাশিত আউটপুট](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [কনফিগারেশন রেফারেন্স](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [পরিবেশ ভেরিয়েবল](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring কনফিগারেশন](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [সমস্যা সমাধান](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [সাধারণ সমস্যা](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ডিবাগ মোড](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [পরবর্তী পদক্ষেপ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [সম্পদ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## প্রয়োজনীয়তা

এই উদাহরণটি চালানোর আগে নিশ্চিত করুন যে আপনার কাছে রয়েছে:

- [Azure OpenAI সেটআপ গাইড](../../getting-started-azure-openai.md) সম্পন্ন হয়েছে  
- Azure AI Foundry পোর্টালের মাধ্যমে Azure OpenAI রিসোর্স ডিপ্লয় করা হয়েছে  
- gpt-4o-mini মডেল (বা বিকল্প) ডিপ্লয় করা হয়েছে  
- Azure থেকে API কী এবং এন্ডপয়েন্ট URL  

## দ্রুত শুরু

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## কনফিগারেশন অপশন

### অপশন ১: পরিবেশ ভেরিয়েবল (.env ফাইল) - সুপারিশকৃত

**ধাপ ১: আপনার কনফিগারেশন ফাইল তৈরি করুন**
```bash
cp .env.example .env
```

**ধাপ ২: আপনার Azure OpenAI ক্রেডেনশিয়াল যোগ করুন**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **নিরাপত্তা নোট**: 
> - কখনোই আপনার `.env` ফাইল ভার্সন কন্ট্রোলে কমিট করবেন না
> - `.env` ফাইলটি ইতিমধ্যেই `.gitignore`-এ রয়েছে
> - আপনার API কী নিরাপদ রাখুন এবং নিয়মিত রোটেট করুন

### অপশন ২: GitHub Codespace Secrets

GitHub Codespaces-এর জন্য, আপনার রিপোজিটরিতে এই সিক্রেটগুলো সেট করুন:
- `AZURE_AI_KEY` - আপনার Azure OpenAI API কী
- `AZURE_AI_ENDPOINT` - আপনার Azure OpenAI এন্ডপয়েন্ট URL

অ্যাপ্লিকেশনটি স্বয়ংক্রিয়ভাবে এই সিক্রেটগুলো সনাক্ত করে এবং ব্যবহার করে।

### বিকল্প: সরাসরি পরিবেশ ভেরিয়েবল

<details>
<summary>প্ল্যাটফর্ম-নির্দিষ্ট কমান্ড দেখতে ক্লিক করুন</summary>

**Linux/macOS (bash/zsh):**
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Command Prompt):**
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## অ্যাপ্লিকেশন চালানো

### Maven ব্যবহার করে

```bash
mvn spring-boot:run
```

### VS Code ব্যবহার করে

1. প্রকল্পটি VS Code-এ খুলুন
2. `F5` চাপুন অথবা "Run and Debug" প্যানেল ব্যবহার করুন
3. "Spring Boot-BasicChatApplication" কনফিগারেশন নির্বাচন করুন

> **নোট**: VS Code কনফিগারেশন স্বয়ংক্রিয়ভাবে আপনার .env ফাইল লোড করে

### প্রত্যাশিত আউটপুট

```
Starting Basic Chat with Azure OpenAI...
Environment variables loaded successfully
Connecting to Azure OpenAI...
Sending prompt: What is AI in a short sentence? Max 100 words.

AI Response:
================
AI, or Artificial Intelligence, is the simulation of human intelligence in machines programmed to think and learn like humans.
================

Success! Azure OpenAI connection is working correctly.
```

## কনফিগারেশন রেফারেন্স

### পরিবেশ ভেরিয়েবল

| ভেরিয়েবল | বিবরণ | প্রয়োজনীয় | উদাহরণ |
|-----------|---------|-------------|---------|
| `AZURE_AI_KEY` | Azure OpenAI API কী | হ্যাঁ | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI এন্ডপয়েন্ট URL | হ্যাঁ | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | মডেল ডিপ্লয়মেন্ট নাম | না | `gpt-4o-mini` (ডিফল্ট) |

### Spring কনফিগারেশন

`application.yml` ফাইলটি কনফিগার করে:
- **API কী**: `${AZURE_AI_KEY}` - পরিবেশ ভেরিয়েবল থেকে
- **এন্ডপয়েন্ট**: `${AZURE_AI_ENDPOINT}` - পরিবেশ ভেরিয়েবল থেকে  
- **মডেল**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - পরিবেশ ভেরিয়েবল থেকে ফallback সহ
- **তাপমাত্রা**: `0.7` - সৃজনশীলতা নিয়ন্ত্রণ করে (0.0 = নির্ধারিত, 1.0 = সৃজনশীল)
- **সর্বাধিক টোকেন**: `500` - সর্বাধিক প্রতিক্রিয়া দৈর্ঘ্য

## সমস্যা সমাধান

### সাধারণ সমস্যা

<details>
<summary><strong>ত্রুটি: "API কী বৈধ নয়"</strong></summary>

- নিশ্চিত করুন যে আপনার `AZURE_AI_KEY` সঠিকভাবে `.env` ফাইলে সেট করা হয়েছে
- API কীটি Azure AI Foundry পোর্টাল থেকে সঠিকভাবে কপি করা হয়েছে কিনা যাচাই করুন
- কীটির চারপাশে অতিরিক্ত স্পেস বা কোটেশন চিহ্ন নেই তা নিশ্চিত করুন
</details>

<details>
<summary><strong>ত্রুটি: "এন্ডপয়েন্ট বৈধ নয়"</strong></summary>

- নিশ্চিত করুন যে আপনার `AZURE_AI_ENDPOINT` সম্পূর্ণ URL অন্তর্ভুক্ত করে (যেমন, `https://your-hub-name.openai.azure.com/`)
- ট্রেইলিং স্ল্যাশের সামঞ্জস্য যাচাই করুন
- এন্ডপয়েন্টটি আপনার Azure ডিপ্লয়মেন্ট অঞ্চলের সাথে মিলে কিনা যাচাই করুন
</details>

<details>
<summary><strong>ত্রুটি: "ডিপ্লয়মেন্ট পাওয়া যায়নি"</strong></summary>

- নিশ্চিত করুন যে আপনার মডেল ডিপ্লয়মেন্ট নামটি Azure-এ ডিপ্লয় করা নামের সাথে সঠিকভাবে মিলে
- মডেলটি সফলভাবে ডিপ্লয় এবং সক্রিয় কিনা যাচাই করুন
- ডিফল্ট ডিপ্লয়মেন্ট নাম ব্যবহার করার চেষ্টা করুন: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: পরিবেশ ভেরিয়েবল লোড হচ্ছে না</strong></summary>

- নিশ্চিত করুন যে আপনার `.env` ফাইলটি প্রকল্পের রুট ডিরেক্টরিতে রয়েছে (যে স্তরে `pom.xml` রয়েছে)
- VS Code-এর ইন্টিগ্রেটেড টার্মিনালে `mvn spring-boot:run` চালানোর চেষ্টা করুন
- নিশ্চিত করুন যে VS Code Java এক্সটেনশন সঠিকভাবে ইনস্টল করা হয়েছে
- লঞ্চ কনফিগারেশনে `"envFile": "${workspaceFolder}/.env"` রয়েছে কিনা যাচাই করুন
</details>

### ডিবাগ মোড

বিস্তারিত লগিং সক্ষম করতে, `application.yml`-এ এই লাইনগুলো আনকমেন্ট করুন:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## পরবর্তী পদক্ষেপ

**সেটআপ সম্পন্ন!** আপনার শেখার যাত্রা চালিয়ে যান:

[অধ্যায় ৩: কোর জেনারেটিভ AI টেকনিক](../../../03-CoreGenerativeAITechniques/README.md)

## সম্পদ

- [Spring AI Azure OpenAI ডকুমেন্টেশন](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI সার্ভিস ডকুমেন্টেশন](https://learn.microsoft.com/azure/ai-services/openai/)
- [Azure AI Foundry পোর্টাল](https://ai.azure.com/)
- [Azure AI Foundry ডকুমেন্টেশন](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**অস্বীকৃতি**:  
এই নথিটি AI অনুবাদ পরিষেবা [Co-op Translator](https://github.com/Azure/co-op-translator) ব্যবহার করে অনুবাদ করা হয়েছে। আমরা যথাসম্ভব সঠিক অনুবাদ প্রদানের চেষ্টা করি, তবে অনুগ্রহ করে মনে রাখবেন যে স্বয়ংক্রিয় অনুবাদে ত্রুটি বা অসঙ্গতি থাকতে পারে। মূল ভাষায় থাকা নথিটিকে প্রামাণিক উৎস হিসেবে বিবেচনা করা উচিত। গুরুত্বপূর্ণ তথ্যের জন্য, পেশাদার মানব অনুবাদ সুপারিশ করা হয়। এই অনুবাদ ব্যবহারের ফলে কোনো ভুল বোঝাবুঝি বা ভুল ব্যাখ্যা হলে আমরা তার জন্য দায়ী থাকব না।