# শুরুদের জন্য জেনারেটিভ AI - জাভা সংস্করণ
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/bn/beg-genai-series.8b48be9951cc574c.webp)

**সময় ব্যয়**: সম্পূর্ণ কর্মশালা অনলাইনে সম্পন্ন করা যেতে পারে কোন লোকাল সেটআপ ছাড়াই। পরিবেশ সেটআপ করতে ২ মিনিট লাগে, এবং নমুনাগুলি অন্বেষণে ১-৩ ঘণ্টা সময় লাগতে পারে, যেটি অন্বেষণের গভীরতার উপর নির্ভর করে।

> **দ্রুত শুরু**

১. এই রেপোজিটরিটি আপনার গিটহাব অ্যাকাউন্টে ফর্ক করুন  
২. ক্লিক করুন **Code** → **Codespaces** ট্যাব → **...** → **New with options...**  
৩. ডিফল্টগুলি ব্যবহার করুন – এটি এই কোর্সের জন্য তৈরি ডেভেলপমেন্ট কন্টেইনার নির্বাচন করবে  
৪. ক্লিক করুন **Create codespace**  
৫. পরিবেশ প্রস্তুত হতে ~২ মিনিট অপেক্ষা করুন  
৬. সরাসরি চলে যান [প্রথম উদাহরণ](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) এ

> **লোকালি ক্লোন করতে চান?**  
>  
> এই রেপোজিটরিতে ৫০+ ভাষার অনুবাদ রয়েছে যা ডাউনলোড সাইজকে উল্লেখযোগ্যভাবে বৃদ্ধি করে। অনুবাদ ছাড়া ক্লোন করতে_sparse checkout_ ব্যবহার করুন:  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> এটি আপনাকে দ্রুত ডাউনলোডের মাধ্যমে কোর্স সম্পন্ন করার জন্য প্রয়োজনীয় সবকিছু দেবে।

## বহু-ভাষা সমর্থন

### GitHub Action এর মাধ্যমে সমর্থিত (স্বয়ংক্রিয় এবং সর্বদা আপডেট)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[আরবি](../ar/README.md) | [বাংলা](./README.md) | [বুলগেরিয়ান](../bg/README.md) | [বর্মিজ (মায়ানমার)](../my/README.md) | [চীনা (সরলীকৃত)](../zh-CN/README.md) | [চীনা (প্রথাগত, হংকং)](../zh-HK/README.md) | [চীনা (প্রথাগত, ম্যাকাও)](../zh-MO/README.md) | [চীনা (প্রথাগত, তাইওয়ান)](../zh-TW/README.md) | [ক্রোয়াসিয়ান](../hr/README.md) | [চেক](../cs/README.md) | [ডেনিশ](../da/README.md) | [ডাচ](../nl/README.md) | [এস্তোনিয়ান](../et/README.md) | [ফিনিশ](../fi/README.md) | [ফরাসি](../fr/README.md) | [জার্মান](../de/README.md) | [গ্রীক](../el/README.md) | [হিব্রু](../he/README.md) | [হিন্দি](../hi/README.md) | [হাঙ্গেরিয়ান](../hu/README.md) | [ইন্দোনেশিয়ান](../id/README.md) | [ইতালিয়ান](../it/README.md) | [জাপানি](../ja/README.md) | [কন্নড়](../kn/README.md) | [কোরিয়ান](../ko/README.md) | [লিথুয়ানিয়ান](../lt/README.md) | [মালয়](../ms/README.md) | [মালায়ালাম](../ml/README.md) | [মরাঠি](../mr/README.md) | [নেপালি](../ne/README.md) | [নাইজেরিয়ার পিজিন](../pcm/README.md) | [নরওয়েজিয়ান](../no/README.md) | [ফার্সি (পার্থিব)](../fa/README.md) | [পোলিশ](../pl/README.md) | [পর্তুগিজ (ব্রাজিল)](../pt-BR/README.md) | [পর্তুগিজ (পর্তুগাল)](../pt-PT/README.md) | [পাঞ্জাবি (গুরুমুখি)](../pa/README.md) | [রোমানিয়ান](../ro/README.md) | [রাশিয়ান](../ru/README.md) | [সার্বিয়ান (সিরিলিক)](../sr/README.md) | [স্লোভাক](../sk/README.md) | [স্লোভেনিয়ান](../sl/README.md) | [স্প্যানিশ](../es/README.md) | [সোয়াহিলি](../sw/README.md) | [সুইডিশ](../sv/README.md) | [তাগালোগ (ফিলিপিনো)](../tl/README.md) | [তামিল](../ta/README.md) | [তেলুগু](../te/README.md) | [থাই](../th/README.md) | [তুর্কি](../tr/README.md) | [ইউক্রেনীয়](../uk/README.md) | [উর্দু](../ur/README.md) | [ভিয়েতনামী](../vi/README.md)

## কোর্স কাঠামো ও শেখার পথ

### **অধ্যায় ১: জেনারেটিভ AI পরিচিতি**
- **মূল ধারণা**: বৃহৎ ভাষা মডেল, টোকেন, এম্বেডিংস, এবং AI ক্ষমতা বোঝা  
- **জাভা AI ইকোসিস্টেম**: Spring AI এবং OpenAI SDK সম্বন্ধে অবলোকন  
- **মডেল কনটেক্সট প্রোটোকল**: MCP পরিচিতি এবং AI এজেন্ট যোগাযোগে এর ভূমিকা  
- **প্রায়োগিক ব্যবহার**: রিয়াল ওয়ার্ল্ড পরিস্থিতি, যা অন্তর্ভুক্ত চ্যাটবট এবং কনটেন্ট তৈরি  
- **[→ অধ্যায় ১ শুরু করুন](./01-IntroToGenAI/README.md)**

### **অধ্যায় ২: ডেভেলপমেন্ট পরিবেশ সেটআপ**
- **মাল্টি-প্রোভাইডার কনফিগারেশন**: GitHub মডেল, Azure OpenAI, এবং OpenAI Java SDK ইন্টিগ্রেশন সেটআপ  
- **Spring Boot + Spring AI**: এন্টারপ্রাইজ AI অ্যাপ্লিকেশন ডেভেলপমেন্টের সেরা অনুশীলন  
- **GitHub মডেলস**: প্রোটোটাইপিং ও শেখার জন্য বিনামূল্যের AI মডেল অ্যাক্সেস (কোন ক্রেডিট কার্ড প্রয়োজন হয় না)  
- **ডেভেলপমেন্ট টুলস**: ডকার কন্টেইনার, VS কোড, এবং GitHub Codespaces কনফিগারেশন  
- **[→ অধ্যায় ২ শুরু করুন](./02-SetupDevEnvironment/README.md)**

### **অধ্যায় ৩: মূল জেনারেটিভ AI কৌশল**
- **প্রম্পট ইঞ্জিনিয়ারিং**: সর্বোত্তম AI মডেল প্রতিক্রিয়ার কৌশল  
- **এম্বেডিংস ও ভেক্টর অপারেশনস**: সেমান্টিক সার্চ এবং সাদৃশ্য মিল পূর্ণ করা  
- **রিট্রিভাল-অগমেন্টেড জেনারেশন (RAG)**: AI এবং আপনার নিজের ডেটা সোর্স একত্রিত করা  
- **ফাংশন কলিং**: কাস্টম টুল ও প্লাগইন দিয়ে AI ক্ষমতা বাড়ানো  
- **[→ অধ্যায় ৩ শুরু করুন](./03-CoreGenerativeAITechniques/README.md)**

### **অধ্যায় ৪: ব্যবহারিক অ্যাপ্লিকেশন ও প্রকল্প**
- **পেট স্টোরি জেনারেটর** (`petstory/`): GitHub মডেল ব্যবহার করে সৃজনশীল কনটেন্ট তৈরি  
- **Foundry Local ডেমো** (`foundrylocal/`): OpenAI Java SDK সহ লোকাল AI মডেল ইন্টিগ্রেশন  
- **MCP ক্যালকুলেটর সার্ভিস** (`calculator/`): Spring AI দিয়ে বেসিক মডেল কনটেক্সট প্রোটোকল বাস্তবায়ন  
- **[→ অধ্যায় ৪ শুরু করুন](./04-PracticalSamples/README.md)**

### **অধ্যায় ৫: দায়িত্বশীল AI উন্নয়ন**
- **GitHub মডেলস সেফটি**: বিল্ট-ইন কনটেন্ট ফিল্টারিং এবং সেফটি মেকানিজম (হার্ড ব্লক এবং সফট প্রত্যাখ্যান) পরীক্ষা  
- **দায়িত্বশীল AI ডেমো**: আধুনিক AI সেফটি সিস্টেমের ব্যবহারিক প্রদর্শন  
- **সেরা অনুশীলন**: নৈতিক AI উন্নয়ন ও প্রকাশনার জন্য আবশ্যক নির্দেশিকা  
- **[→ অধ্যায় ৫ শুরু করুন](./05-ResponsibleGenAI/README.md)**

## অতিরিক্ত সম্পদ

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### ল্যাংচেইন
[![শেখার জন্য LangChain4j](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![শেখার জন্য LangChain.js](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### Azure / Edge / MCP / এজেন্টস
[![শিখুন AZD](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![শিখুন Edge AI](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![শিখুন MCP](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![শিখুন AI এজেন্টস](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### জেনারেটিভ AI সিরিজ
[![শেখা শুরু করুন জেনারেটিভ AI এর](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### মূল শেখা
[![শিখুন ML](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![শিখুন ডেটা সায়েন্স](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![শিখুন AI](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![শিখুন সাইবারসিকিউরিটি](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![শিখুন ওয়েব ডেভেলপমেন্ট](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![শুরু করার জন্য IoT](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![শুরু করার জন্য XR ডেভেলপমেন্ট](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### কপাইলট সিরিজ
[![AI যুগ্ম প্রোগ্রামিং-এর জন্য কপাইলট](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![C#/.NET-এর জন্য কপাইলট](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![কপাইলট অভিযান](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## সাহায্য পাওয়া

আপনি যদি আটকে যান বা AI অ্যাপ তৈরি সম্পর্কে কোনও প্রশ্ন থাকে, তবে MCP নিয়ে আলোচনায় সহশিক্ষার্থী ও অভিজ্ঞ ডেভেলপারদের সাথে যোগ দিন। এটি একটি সহযোগী কমিউনিটি যেখানে প্রশ্ন করা উল্লাসিত এবং জ্ঞা্ন দয়া করে শেয়ার করা হয়।

[![মাইক্রোসফট ফাউন্ড্রি ডিসকর্ড](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

যদি পণ্য প্রতিক্রিয়া বা নির্মাণের সময় ত্রুটি থাকে তাহলে পরিদর্শন করুন:

[![মাইক্রোসফট ফাউন্ড্রি ডেভেলপার ফোরাম](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**দুঃখিত**:
এই নথিটি AI অনুবাদ সেবা [Co-op Translator](https://github.com/Azure/co-op-translator) ব্যবহার করে অনূদিত হয়েছে। আমরা সঠিকতার জন্য চেষ্টা করি, কিন্তু দয়া করে মনে রাখবেন যে স্বয়ংক্রিয় অনুবাদে ত্রুটি বা ভুল থাকতে পারে। মুল ভাষায় থাকা নথিটিই সর্বাধিকারীক উৎস হিসেবে বিবেচিত হবে। গুরুত্বপূর্ণ তথ্যের জন্য পেশাদার মানুষের অনুবাদ গ্রহণ করাই উত্তম। এই অনুবাদের ব্যবহার থেকে সৃষ্ট কোনো ভুল বোঝাবুঝি বা ভুল ব্যাখ্যার জন্য আমরা দায়ী নই।
<!-- CO-OP TRANSLATOR DISCLAIMER END -->