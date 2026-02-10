# নবশিক্ষীদের জন্য জেনারেটিভ AI - জাভা সংস্করণ  
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/bn/beg-genai-series.8b48be9951cc574c.webp)

**সময়ের ব্যয়**: সম্পূর্ণ কর্মশালা অনলাইনে স্থানীয় সেটআপ ছাড়াই সম্পন্ন করা যেতে পারে। পরিবেশ সেটআপে ২ মিনিট লাগে, নমুনাগুলো অন্বেষণ করতে ১-৩ ঘন্টা সময় লাগতে পারে নির্ভর করে অনুসন্ধানের গভীরতার উপর।

> **দ্রুত শুরু করুন**

1. এই রিপোজিটরিটি আপনার গিটহাব অ্যাকাউন্টে fork করুন  
2. ক্লিক করুন **Code** → **Codespaces** ট্যাব → **...** → **New with options...**  
3. ডিফল্ট ব্যবহার করুন – এটি কোর্সটির জন্য তৈরি ডেভেলপমেন্ট কন্টেইনার বেছে নেবে  
4. ক্লিক করুন **Create codespace**  
5. প্রায় ২ মিনিট অপেক্ষা করুন পরিবেশ প্রস্তুত হওয়ার জন্য  
6. সরাসরি যান [প্রথম উদাহরণে](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **লোকালি ক্লোন করতে ইচ্ছুক?**  
>  
> এই রিপোজিটরিতে ৫০+ ভাষার অনুবাদ রয়েছে যা ডাউনলোড সাইজ অনেক বাড়িয়ে দেয়। অনুবাদ ছাড়া ক্লোন করতে sparse checkout ব্যবহার করুন:  
>  
> **লিনাক্স / ম্যাকওএস (Bash)**  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
>  
> **উইন্ডোজ (PowerShell)**  
> ```powershell
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone "/*" "!translations" "!translated_images"
> ```
> এতে আপনি কোর্স সম্পন্ন করার জন্য প্রয়োজনীয় সবকিছু পাবেন, অনেক দ্রুত ডাউনলোড সহ।  


## বহুভাষিক সমর্থন

### গিটহাব অ্যাকশনের মাধ্যমে সমর্থিত (স্বয়ংক্রিয় এবং সর্বদা আপ-টু-ডেট)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](./README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](../my/README.md) | [Chinese (Simplified)](../zh-CN/README.md) | [Chinese (Traditional, Hong Kong)](../zh-HK/README.md) | [Chinese (Traditional, Macau)](../zh-MO/README.md) | [Chinese (Traditional, Taiwan)](../zh-TW/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Kannada](../kn/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Malayalam](../ml/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Nigerian Pidgin](../pcm/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../pt-BR/README.md) | [Portuguese (Portugal)](../pt-PT/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Telugu](../te/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)

## কোর্স কাঠামো ও শিক্ষণ পথ

### **অধ্যায় ১: জেনারেটিভ AI এর পরিচিতি**
- **মূল ধারণাসমূহ**: বড় ভাষার মডেল, টোকেন, এম্বেডিং এবং AI দক্ষতা বোঝা  
- **জাভা AI ইকোসিস্টেম**: Spring AI এবং OpenAI SDKs এর ওভারভিউ  
- **মডেল কনটেক্সট প্রটোকল**: MCP এবং AI এজেন্ট যোগাযোগে এর ভূমিকা পরিচিতি  
- **বাস্তবজীবনের ব্যবহার**: চ্যাটবট এবং বিষয়বস্তু সৃষ্টিসহ বাস্তব উদাহরণ  
- **[→ অধ্যায় ১ শুরু করুন](./01-IntroToGenAI/README.md)**

### **অধ্যায় ২: উন্নয়ন পরিবেশ সেটআপ**  
- **মাল্টি-প্রোভাইডার কনফিগারেশন**: GitHub মডেল, Azure OpenAI, এবং OpenAI Java SDK ইন্টিগ্রেশন  
- **Spring Boot + Spring AI**: এন্টারপ্রাইজ AI অ্যাপ্লিকেশন উন্নয়নের সেরা প্র্যাকটিস  
- **GitHub মডেল**: প্রোটোটাইপিং ও শেখার জন্য ফ্রি AI মডেল অ্যাক্সেস (ক্রেডিট কার্ডের দরকার নেই)  
- **উন্নয়ন সরঞ্জাম**: Docker কন্টেইনারস, VS Code, এবং GitHub Codespaces কনফিগারেশন  
- **[→ অধ্যায় ২ শুরু করুন](./02-SetupDevEnvironment/README.md)**

### **অধ্যায় ৩: মূল জেনারেটিভ AI টেকনিকসমূহ**  
- **প্রম্পট ইঞ্জিনিয়ারিং**: AI মডেলের সর্বোত্তম প্রতিক্রিয়া পাওয়ার কলাকৌশল  
- **এম্বেডিং ও ভেক্টর অপারেশন**: সেমান্টিক সার্চ ও সাদৃশ্য মেলানো প্রয়োগ  
- **রিট্রিভাল-অগমেন্টেড জেনারেশন (RAG)**: আপনার নিজস্ব ডেটা সোর্সের সাথে AI একত্রিত করা  
- **ফাংশন কলিং**: কাস্টম টুল ও প্লাগইন দিয়ে AI ক্ষমতা বাড়ানো  
- **[→ অধ্যায় ৩ শুরু করুন](./03-CoreGenerativeAITechniques/README.md)**

### **অধ্যায় ৪: ব্যবহারিক অ্যাপ্লিকেশন ও প্রকল্পসমূহ**  
- **পেট স্টোরি জেনারেটর** (`petstory/`): GitHub মডেলের সাথে সৃজনশীল বিষয়বস্তু তৈরি  
- **Foundry Local ডেমো** (`foundrylocal/`): OpenAI Java SDK এর সাথে লোকাল AI মডেল ইন্টিগ্রেশন  
- **MCP ক্যালকুলেটর সার্ভিস** (`calculator/`): Spring AI দিয়ে মৌলিক Model Context Protocol বাস্তবায়ন  
- **[→ অধ্যায় ৪ শুরু করুন](./04-PracticalSamples/README.md)**

### **অধ্যায় ৫: দায়িত্বশীল AI উন্নয়ন**  
- **GitHub মডেল নিরাপত্তা**: অন্তর্নিহিত বিষয়বস্তু ফিল্টারিং এবং নিরাপত্তা ব্যবস্থা পরীক্ষা (হার্ড ব্লক এবং সফট প্রত্যাখ্যান)  
- **দায়িত্বশীল AI ডেমো**: আধুনিক AI নিরাপত্তা সিস্টেমের হাতে-কলমে উদাহরণ  
- **সেরা অনুশীলনসমূহ**: নৈতিক AI উন্নয়ন ও মোতায়েনের জন্য গুরুত্বপূর্ণ নির্দেশিকা  
- **[→ অধ্যায় ৫ শুরু করুন](./05-ResponsibleGenAI/README.md)**

## অতিরিক্ত সম্পদসমূহ

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### ল্যাংচেইন  
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)  
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)  
[![LangChain for Beginners](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)  
---

### Azure / Edge / MCP / Agents  
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)  

---  
 
### জেনারেটিভ AI সিরিজ  
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)  
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)  
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)  

---  
 
### মূল শিক্ষাগত কোর্স  
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)  
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)  
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)  
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![শুরু করার জন্য ওয়েব ডেভেলপমেন্ট](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![শুরু করার জন্য আইওটি](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![শুরু করার জন্য এক্সআর ডেভেলপমেন্ট](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### কোপাইলোট সিরিজ
[![কোপাইলোট ফর এআই পেয়ার্ড প্রোগ্রামিং](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![কোপাইলোট ফর সি#/.নেট](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![কোপাইলোট অ্যাডভেঞ্চার](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## সাহায্য নেওয়া

যদি আপনি আটকে যান বা AI অ্যাপ তৈরি করার বিষয়ে কোনও প্রশ্ন থাকে। MCP নিয়ে আলোচনায় অংশ নিতে অন্যান্য শিক্ষার্থী এবং অভিজ্ঞ ডেভেলপারদের সঙ্গে যোগ দিন। এটি একটি সহায়ক কমিউনিটি যেখানে প্রশ্ন歓迎 এবং জ্ঞান সহজে ভাগ করা হয়।

[![মাইক্রোসফট ফাউন্ড্রি ডিসকর্ড](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

আপনার যদি পণ্য মতামত বা নির্মাণের সময় ত্রুটি থাকে তবে দেখতে ভিজিট করুন:

[![মাইক্রোসফট ফাউন্ড্রি ডেভেলপার ফোরাম](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**বিক্ষিপ্ত দ্রষ্টব্য**:  
এই দলিলটি AI অনুবাদ সেবা [Co-op Translator](https://github.com/Azure/co-op-translator) ব্যবহার করে অনুবাদ করা হয়েছে। আমরা যথাসাধ্য সঠিকতা করার চেষ্টা করি, তবে স্বয়ংক্রিয় অনুবাদে ভুল বা অস্পষ্টতা থাকতে পারে। মূল ভাষায় থাকা মূল দলিলটিকেই বিশ্বাসযোগ্য উৎস হিসেবে বিবেচনা করা উচিত। গুরুত্বপূর্ণ তথ্যের জন্য পেশাদার মানুষের অনুবাদ গ্রহণ করাই শ্রেয়। এই অনুবাদের ব্যবহারে কোনো ভুলবোঝাবুঝি বা ভুল ব্যাখ্যার জন্য আমরা দায়ী নই।
<!-- CO-OP TRANSLATOR DISCLAIMER END -->