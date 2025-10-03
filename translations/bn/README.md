<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "4d04ae8088f6a3c3fcbab18cbdfe4002",
  "translation_date": "2025-10-03T08:07:09+00:00",
  "source_file": "README.md",
  "language_code": "bn"
}
-->
# জেনারেটিভ এআই শুরু করার জন্য - জাভা সংস্করণ
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![জেনারেটিভ এআই শুরু করার জন্য - জাভা সংস্করণ](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.bn.png)

**সময় প্রয়োজন**: পুরো কর্মশালা অনলাইনে সম্পন্ন করা যায়, স্থানীয় সেটআপের প্রয়োজন নেই। পরিবেশ সেটআপ করতে ২ মিনিট সময় লাগে, এবং নমুনাগুলি অন্বেষণ করতে ১-৩ ঘণ্টা সময় লাগতে পারে, অন্বেষণের গভীরতার উপর নির্ভর করে।

> **দ্রুত শুরু করুন**

1. এই রিপোজিটরিটি আপনার GitHub অ্যাকাউন্টে ফর্ক করুন
2. **Code** → **Codespaces** ট্যাব → **...** → **New with options...** ক্লিক করুন
3. ডিফল্ট সেটিংস ব্যবহার করুন – এটি এই কোর্সের জন্য তৈরি ডেভেলপমেন্ট কন্টেইনার নির্বাচন করবে
4. **Create codespace** ক্লিক করুন
5. পরিবেশ প্রস্তুত হতে ~২ মিনিট অপেক্ষা করুন
6. সরাসরি [প্রথম উদাহরণে](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) যান

## বহু-ভাষার সমর্থন

### GitHub Action এর মাধ্যমে সমর্থিত (স্বয়ংক্রিয় এবং সর্বদা আপডেটেড)

[ফরাসি](../fr/README.md) | [স্প্যানিশ](../es/README.md) | [জার্মান](../de/README.md) | [রাশিয়ান](../ru/README.md) | [আরবি](../ar/README.md) | [ফার্সি (পার্সিয়ান)](../fa/README.md) | [উর্দু](../ur/README.md) | [চীনা (সরলীকৃত)](../zh/README.md) | [চীনা (প্রথাগত, ম্যাকাও)](../mo/README.md) | [চীনা (প্রথাগত, হংকং)](../hk/README.md) | [চীনা (প্রথাগত, তাইওয়ান)](../tw/README.md) | [জাপানি](../ja/README.md) | [কোরিয়ান](../ko/README.md) | [হিন্দি](../hi/README.md) | [বাংলা](./README.md) | [মারাঠি](../mr/README.md) | [নেপালি](../ne/README.md) | [পাঞ্জাবি (গুরমুখী)](../pa/README.md) | [পর্তুগিজ (পর্তুগাল)](../pt/README.md) | [পর্তুগিজ (ব্রাজিল)](../br/README.md) | [ইতালিয়ান](../it/README.md) | [পোলিশ](../pl/README.md) | [তুর্কি](../tr/README.md) | [গ্রিক](../el/README.md) | [থাই](../th/README.md) | [সুইডিশ](../sv/README.md) | [ড্যানিশ](../da/README.md) | [নরওয়েজিয়ান](../no/README.md) | [ফিনিশ](../fi/README.md) | [ডাচ](../nl/README.md) | [হিব্রু](../he/README.md) | [ভিয়েতনামি](../vi/README.md) | [ইন্দোনেশিয়ান](../id/README.md) | [মালয়](../ms/README.md) | [টাগালগ (ফিলিপিনো)](../tl/README.md) | [সোয়াহিলি](../sw/README.md) | [হাঙ্গেরিয়ান](../hu/README.md) | [চেক](../cs/README.md) | [স্লোভাক](../sk/README.md) | [রোমানিয়ান](../ro/README.md) | [বুলগেরিয়ান](../bg/README.md) | [সার্বিয়ান (সিরিলিক)](../sr/README.md) | [ক্রোয়েশিয়ান](../hr/README.md) | [স্লোভেনিয়ান](../sl/README.md) | [ইউক্রেনিয়ান](../uk/README.md) | [বর্মি (মায়ানমার)](../my/README.md)

## কোর্সের কাঠামো এবং শেখার পথ

### **অধ্যায় ১: জেনারেটিভ এআই এর পরিচিতি**
- **মূল ধারণা**: বড় ভাষার মডেল, টোকেন, এমবেডিং এবং এআই সক্ষমতা বোঝা
- **জাভা এআই ইকোসিস্টেম**: Spring AI এবং OpenAI SDKs এর সংক্ষিপ্ত বিবরণ
- **মডেল কনটেক্সট প্রোটোকল**: MCP এবং এআই এজেন্ট যোগাযোগে এর ভূমিকা
- **বাস্তব প্রয়োগ**: চ্যাটবট এবং কন্টেন্ট জেনারেশনের মতো বাস্তব জীবনের উদাহরণ
- **[→ অধ্যায় ১ শুরু করুন](./01-IntroToGenAI/README.md)**

### **অধ্যায় ২: ডেভেলপমেন্ট পরিবেশ সেটআপ**
- **মাল্টি-প্রোভাইডার কনফিগারেশন**: GitHub Models, Azure OpenAI এবং OpenAI Java SDK ইন্টিগ্রেশন সেটআপ করুন
- **Spring Boot + Spring AI**: এন্টারপ্রাইজ এআই অ্যাপ্লিকেশন ডেভেলপমেন্টের সেরা পদ্ধতি
- **GitHub Models**: প্রোটোটাইপিং এবং শেখার জন্য বিনামূল্যে এআই মডেল অ্যাক্সেস (ক্রেডিট কার্ড প্রয়োজন নেই)
- **ডেভেলপমেন্ট টুলস**: Docker কন্টেইনার, VS Code এবং GitHub Codespaces কনফিগারেশন
- **[→ অধ্যায় ২ শুরু করুন](./02-SetupDevEnvironment/README.md)**

### **অধ্যায় ৩: মূল জেনারেটিভ এআই কৌশল**
- **প্রম্পট ইঞ্জিনিয়ারিং**: এআই মডেলের সেরা প্রতিক্রিয়া পাওয়ার কৌশল
- **এমবেডিং এবং ভেক্টর অপারেশন**: সেমান্টিক সার্চ এবং সাদৃশ্য মিলানোর বাস্তবায়ন
- **Retrieval-Augmented Generation (RAG)**: আপনার নিজস্ব ডেটা সোর্সের সাথে এআই সংযুক্ত করুন
- **ফাংশন কলিং**: কাস্টম টুল এবং প্লাগইন দিয়ে এআই সক্ষমতা বাড়ান
- **[→ অধ্যায় ৩ শুরু করুন](./03-CoreGenerativeAITechniques/README.md)**

### **অধ্যায় ৪: বাস্তব প্রয়োগ এবং প্রকল্প**
- **পোষা প্রাণীর গল্প জেনারেটর** (`petstory/`): GitHub Models দিয়ে সৃজনশীল কন্টেন্ট জেনারেশন
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK দিয়ে স্থানীয় এআই মডেল ইন্টিগ্রেশন
- **MCP ক্যালকুলেটর সার্ভিস** (`calculator/`): Spring AI দিয়ে মডেল কনটেক্সট প্রোটোকলের মৌলিক বাস্তবায়ন
- **[→ অধ্যায় ৪ শুরু করুন](./04-PracticalSamples/README.md)**

### **অধ্যায় ৫: দায়িত্বশীল এআই ডেভেলপমেন্ট**
- **GitHub Models নিরাপত্তা**: অন্তর্নির্মিত কন্টেন্ট ফিল্টারিং এবং নিরাপত্তা ব্যবস্থা পরীক্ষা করুন (হার্ড ব্লক এবং সফট রিফিউজাল)
- **দায়িত্বশীল এআই ডেমো**: আধুনিক এআই নিরাপত্তা ব্যবস্থা কীভাবে কাজ করে তার হাতে-কলমে উদাহরণ
- **সেরা পদ্ধতি**: নৈতিক এআই ডেভেলপমেন্ট এবং ডেপ্লয়মেন্টের জন্য প্রয়োজনীয় নির্দেশিকা
- **[→ অধ্যায় ৫ শুরু করুন](./05-ResponsibleGenAI/README.md)**

## অতিরিক্ত সম্পদ

- [Edge AI for Beginners](https://github.com/microsoft/edgeai-for-beginners)
- [MCP For Beginners](https://github.com/microsoft/mcp-for-beginners)
- [AI Agents For Beginners](https://github.com/microsoft/ai-agents-for-beginners)
- [Generative AI for Beginners using .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generative AI for Beginners using JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generative AI for Beginners](https://github.com/microsoft/generative-ai-for-beginners)
- [ML for Beginners](https://aka.ms/ml-beginners)
- [Data Science for Beginners](https://aka.ms/datascience-beginners)
- [AI for Beginners](https://aka.ms/ai-beginners)
- [Cybersecurity for Beginners](https://github.com/microsoft/Security-101)
- [Web Dev for Beginners](https://aka.ms/webdev-beginners)
- [IoT for Beginners](https://aka.ms/iot-beginners)
- [XR Development for Beginners](https://github.com/microsoft/xr-development-for-beginners)
- [Mastering GitHub Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI)
- [Mastering GitHub Copilot for C#/.NET Developers](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Choose Your Own Copilot Adventure](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App with Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## সাহায্য পাওয়া

যদি আপনি আটকে যান বা এআই অ্যাপ তৈরি করার বিষয়ে কোনো প্রশ্ন থাকে, যোগ দিন:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

যদি আপনার পণ্য সম্পর্কিত মতামত থাকে বা তৈরি করার সময় কোনো ত্রুটি হয়, দেখুন:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**অস্বীকৃতি**:  
এই নথিটি AI অনুবাদ পরিষেবা [Co-op Translator](https://github.com/Azure/co-op-translator) ব্যবহার করে অনুবাদ করা হয়েছে। আমরা যথাসাধ্য সঠিকতার জন্য চেষ্টা করি, তবে অনুগ্রহ করে মনে রাখবেন যে স্বয়ংক্রিয় অনুবাদে ত্রুটি বা অসঙ্গতি থাকতে পারে। মূল ভাষায় থাকা নথিটিকে প্রামাণিক উৎস হিসেবে বিবেচনা করা উচিত। গুরুত্বপূর্ণ তথ্যের জন্য, পেশাদার মানব অনুবাদ সুপারিশ করা হয়। এই অনুবাদ ব্যবহারের ফলে কোনো ভুল বোঝাবুঝি বা ভুল ব্যাখ্যা হলে আমরা দায়বদ্ধ থাকব না।