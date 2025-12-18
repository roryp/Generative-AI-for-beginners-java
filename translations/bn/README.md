<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b1a467efb7f8e13a19f961a587226f71",
  "translation_date": "2025-12-18T09:46:28+00:00",
  "source_file": "README.md",
  "language_code": "bn"
}
-->
# নবীনদের জন্য জেনারেটিভ AI - জাভা সংস্করণ
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![নবীনদের জন্য জেনারেটিভ AI - জাভা সংস্করণ](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.bn.png)

**সময় ব্যয়**: পুরো কর্মশালাটি অনলাইনে সম্পন্ন করা যায় স্থানীয় সেটআপ ছাড়াই। পরিবেশ সেটআপ করতে ২ মিনিট লাগে, নমুনাগুলি অন্বেষণ করতে ১-৩ ঘণ্টা সময় লাগতে পারে অন্বেষণের গভীরতার উপর নির্ভর করে।

> **দ্রুত শুরু**

১. এই রিপোজিটরিটি আপনার GitHub অ্যাকাউন্টে ফর্ক করুন  
২. ক্লিক করুন **Code** → **Codespaces** ট্যাব → **...** → **New with options...**  
৩. ডিফল্ট ব্যবহার করুন – এটি এই কোর্সের জন্য তৈরি ডেভেলপমেন্ট কন্টেইনার নির্বাচন করবে  
৪. ক্লিক করুন **Create codespace**  
৫. পরিবেশ প্রস্তুত হতে প্রায় ২ মিনিট অপেক্ষা করুন  
৬. সরাসরি যান [প্রথম উদাহরণে](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **স্থানীয়ভাবে ক্লোন করতে চান?**  
>  
> এই রিপোজিটরিতে ৫০+ ভাষার অনুবাদ রয়েছে যা ডাউনলোড সাইজ অনেক বাড়িয়ে দেয়। অনুবাদ ছাড়া ক্লোন করতে sparse checkout ব্যবহার করুন:  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> এটি আপনাকে কোর্স সম্পন্ন করার জন্য প্রয়োজনীয় সবকিছু দ্রুত ডাউনলোডের মাধ্যমে দেবে।

## বহু-ভাষা সমর্থন

### GitHub Action এর মাধ্যমে সমর্থিত (স্বয়ংক্রিয় ও সর্বদা আপ-টু-ডেট)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[আরবি](../ar/README.md) | [বাংলা](./README.md) | [বুলগেরিয়ান](../bg/README.md) | [বর্মিজ (মায়ানমার)](../my/README.md) | [চীনা (সরলীকৃত)](../zh/README.md) | [চীনা (প্রথাগত, হংকং)](../hk/README.md) | [চীনা (প্রথাগত, ম্যাকাও)](../mo/README.md) | [চীনা (প্রথাগত, তাইওয়ান)](../tw/README.md) | [ক্রোয়েশিয়ান](../hr/README.md) | [চেক](../cs/README.md) | [ড্যানিশ](../da/README.md) | [ডাচ](../nl/README.md) | [এস্তোনিয়ান](../et/README.md) | [ফিনিশ](../fi/README.md) | [ফরাসি](../fr/README.md) | [জার্মান](../de/README.md) | [গ্রিক](../el/README.md) | [হিব্রু](../he/README.md) | [হিন্দি](../hi/README.md) | [হাঙ্গেরিয়ান](../hu/README.md) | [ইন্দোনেশিয়ান](../id/README.md) | [ইতালিয়ান](../it/README.md) | [জাপানি](../ja/README.md) | [কন্নড়](../kn/README.md) | [কোরিয়ান](../ko/README.md) | [লিথুয়ানিয়ান](../lt/README.md) | [মালয়](../ms/README.md) | [মালায়ালাম](../ml/README.md) | [মারাঠি](../mr/README.md) | [নেপালি](../ne/README.md) | [নাইজেরিয়ান পিজিন](../pcm/README.md) | [নরওয়েজিয়ান](../no/README.md) | [ফার্সি (পারসিয়ান)](../fa/README.md) | [পোলিশ](../pl/README.md) | [পর্তুগিজ (ব্রাজিল)](../br/README.md) | [পর্তুগিজ (পর্তুগাল)](../pt/README.md) | [পাঞ্জাবি (গুরমুখী)](../pa/README.md) | [রোমানিয়ান](../ro/README.md) | [রাশিয়ান](../ru/README.md) | [সার্বিয়ান (সিরিলিক)](../sr/README.md) | [স্লোভাক](../sk/README.md) | [স্লোভেনিয়ান](../sl/README.md) | [স্প্যানিশ](../es/README.md) | [সোয়াহিলি](../sw/README.md) | [সুইডিশ](../sv/README.md) | [টাগালগ (ফিলিপিনো)](../tl/README.md) | [তামিল](../ta/README.md) | [তেলুগু](../te/README.md) | [থাই](../th/README.md) | [তুর্কি](../tr/README.md) | [ইউক্রেনিয়ান](../uk/README.md) | [উর্দু](../ur/README.md) | [ভিয়েতনামীজ](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## কোর্সের কাঠামো ও শেখার পথ

### **অধ্যায় ১: জেনারেটিভ AI পরিচিতি**
- **মূল ধারণা**: বড় ভাষা মডেল, টোকেন, এমবেডিংস, এবং AI ক্ষমতা বোঝা  
- **জাভা AI ইকোসিস্টেম**: Spring AI এবং OpenAI SDK এর ওভারভিউ  
- **মডেল কনটেক্সট প্রোটোকল**: MCP পরিচিতি এবং AI এজেন্ট যোগাযোগে এর ভূমিকা  
- **প্রায়োগিক ব্যবহার**: চ্যাটবট এবং কনটেন্ট জেনারেশনের বাস্তব উদাহরণ  
- **[→ অধ্যায় ১ শুরু করুন](./01-IntroToGenAI/README.md)**

### **অধ্যায় ২: ডেভেলপমেন্ট পরিবেশ সেটআপ**
- **মাল্টি-প্রোভাইডার কনফিগারেশন**: GitHub Models, Azure OpenAI, এবং OpenAI Java SDK ইন্টিগ্রেশন সেটআপ  
- **Spring Boot + Spring AI**: এন্টারপ্রাইজ AI অ্যাপ্লিকেশন ডেভেলপমেন্টের সেরা অনুশীলন  
- **GitHub Models**: প্রোটোটাইপিং ও শেখার জন্য ফ্রি AI মডেল অ্যাক্সেস (ক্রেডিট কার্ডের প্রয়োজন নেই)  
- **ডেভেলপমেন্ট টুলস**: ডকার কন্টেইনার, VS কোড, এবং GitHub Codespaces কনফিগারেশন  
- **[→ অধ্যায় ২ শুরু করুন](./02-SetupDevEnvironment/README.md)**

### **অধ্যায় ৩: মূল জেনারেটিভ AI কৌশল**
- **প্রম্পট ইঞ্জিনিয়ারিং**: AI মডেলের সর্বোত্তম প্রতিক্রিয়া পাওয়ার কৌশল  
- **এম্বেডিংস ও ভেক্টর অপারেশন**: সেমান্টিক সার্চ এবং সাদৃশ্য মিলানো বাস্তবায়ন  
- **রিট্রিভাল-অগমেন্টেড জেনারেশন (RAG)**: AI কে আপনার নিজস্ব ডেটা সোর্সের সাথে সংযুক্ত করা  
- **ফাংশন কলিং**: কাস্টম টুলস ও প্লাগইন দিয়ে AI ক্ষমতা বাড়ানো  
- **[→ অধ্যায় ৩ শুরু করুন](./03-CoreGenerativeAITechniques/README.md)**

### **অধ্যায় ৪: ব্যবহারিক অ্যাপ্লিকেশন ও প্রকল্প**
- **পেট স্টোরি জেনারেটর** (`petstory/`): GitHub Models দিয়ে সৃজনশীল কনটেন্ট জেনারেশন  
- **Foundry Local ডেমো** (`foundrylocal/`): OpenAI Java SDK দিয়ে স্থানীয় AI মডেল ইন্টিগ্রেশন  
- **MCP ক্যালকুলেটর সার্ভিস** (`calculator/`): Spring AI দিয়ে মৌলিক Model Context Protocol বাস্তবায়ন  
- **[→ অধ্যায় ৪ শুরু করুন](./04-PracticalSamples/README.md)**

### **অধ্যায় ৫: দায়িত্বশীল AI ডেভেলপমেন্ট**
- **GitHub Models নিরাপত্তা**: বিল্ট-ইন কনটেন্ট ফিল্টারিং ও নিরাপত্তা ব্যবস্থা পরীক্ষা (হার্ড ব্লক ও সফট রিফিউজাল)  
- **দায়িত্বশীল AI ডেমো**: আধুনিক AI নিরাপত্তা সিস্টেম কিভাবে কাজ করে তার হাতে-কলমে উদাহরণ  
- **সেরা অনুশীলন**: নৈতিক AI ডেভেলপমেন্ট ও ডিপ্লয়মেন্টের জন্য অপরিহার্য নির্দেশিকা  
- **[→ অধ্যায় ৫ শুরু করুন](./05-ResponsibleGenAI/README.md)**

## অতিরিক্ত সম্পদ

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![নবীনদের জন্য LangChain4j](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![নবীনদের জন্য LangChain.js](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### Azure / Edge / MCP / Agents
[![নবীনদের জন্য AZD](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![নবীনদের জন্য Edge AI](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![নবীনদের জন্য MCP](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![নবীনদের জন্য AI Agents](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### জেনারেটিভ AI সিরিজ
[![নবীনদের জন্য জেনারেটিভ AI](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![জেনারেটিভ AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![জেনারেটিভ AI (জাভা)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![জেনারেটিভ AI (জাভাস্ক্রিপ্ট)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### মূল শেখা
[![নবীনদের জন্য ML](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![নবীনদের জন্য ডেটা সায়েন্স](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![নবীনদের জন্য AI](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![নবীনদের জন্য সাইবারসিকিউরিটি](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![নবীনদের জন্য ওয়েব ডেভেলপমেন্ট](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![শুরু করার জন্য IoT](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![শুরু করার জন্য XR ডেভেলপমেন্ট](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### কপাইলট সিরিজ
[![AI যুগল প্রোগ্রামিংয়ের জন্য কপাইলট](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![C#/.NET এর জন্য কপাইলট](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![কপাইলট অ্যাডভেঞ্চার](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## সাহায্য নেওয়া

যদি আপনি আটকে যান বা AI অ্যাপ তৈরি সম্পর্কে কোনো প্রশ্ন থাকে। MCP নিয়ে আলোচনা করতে সহপাঠী শিক্ষার্থী এবং অভিজ্ঞ ডেভেলপারদের সাথে যোগ দিন। এটি একটি সহায়ক সম্প্রদায় যেখানে প্রশ্ন স্বাগত এবং জ্ঞান মুক্তভাবে ভাগ করা হয়।

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

যদি আপনার পণ্য প্রতিক্রিয়া বা ত্রুটি থাকে, তাহলে নির্মাণের সময় এখানে যান:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**অস্বীকৃতি**:  
এই নথিটি AI অনুবাদ সেবা [Co-op Translator](https://github.com/Azure/co-op-translator) ব্যবহার করে অনূদিত হয়েছে। আমরা যথাসাধ্য সঠিকতার চেষ্টা করি, তবে স্বয়ংক্রিয় অনুবাদে ত্রুটি বা অসঙ্গতি থাকতে পারে। মূল নথিটি তার নিজস্ব ভাষায়ই কর্তৃত্বপূর্ণ উৎস হিসেবে বিবেচিত হওয়া উচিত। গুরুত্বপূর্ণ তথ্যের জন্য পেশাদার মানব অনুবাদ গ্রহণ করার পরামর্শ দেওয়া হয়। এই অনুবাদের ব্যবহারে সৃষ্ট কোনো ভুল বোঝাবুঝি বা ভুল ব্যাখ্যার জন্য আমরা দায়ী নই।
<!-- CO-OP TRANSLATOR DISCLAIMER END -->