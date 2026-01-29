# শিক্ষানবিসদের জন্য জেনারেটিভ এআই - জাভা সংস্করণ
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/bn/beg-genai-series.8b48be9951cc574c.webp)

**সময়সাপেক্ষতা**: পুরো কর্মশালাটি অনলাইনে সম্পন্ন করা যেতে পারে কোনো লোকাল সেটআপ ছাড়াই। পরিবেশ সেটআপে ২ মিনিট লাগে, আর নমুনাগুলো খুঁজে দেখার জন্য অন্বেষণের গভীরতার ওপর নির্ভর করে ১-৩ ঘণ্টা লাগে।

> **দ্রুত শুরু**

১. এই রিপোজিটরিটি আপনার GitHub অ্যাকাউন্টে ফর্ক করুন  
২. **Code** → **Codespaces** ট্যাব → **...** → **New with options...** ক্লিক করুন  
৩. ডিফল্ট ব্যবহার করুন – এতে এই কোর্সের জন্য তৈরি ডেভেলপমেন্ট কন্টেইনার নির্বাচিত হবে  
৪. **Create codespace** ক্লিক করুন  
৫. পরিবেশ প্রস্তুত হতে ~২ মিনিট অপেক্ষা করুন  
৬. সরাসরি [প্রথম উদাহরণের দিকে যান](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **লোকালি ক্লোন করতে চান?**  
>  
> এই রিপোজিটরিতে ৫০+ ভাষার অনুবাদ অন্তর্ভুক্ত, যা ডাউনলোড সাইজ উল্লেখযোগ্যভাবে বৃদ্ধি করে। অনুবাদ ছাড়া ক্লোন করতে, sparse checkout ব্যবহার করুন:  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> এতে কোর্স সম্পন্ন করার জন্য প্রয়োজনীয় সবকিছু দ্রুত ডাউনলোড হবে।

## বহু-ভাষা সমর্থন

### GitHub Action এর মাধ্যমে সমর্থিত (স্বয়ংক্রিয় এবং সর্বদা সর্বশেষ)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](./README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](../my/README.md) | [Chinese (Simplified)](../zh-CN/README.md) | [Chinese (Traditional, Hong Kong)](../zh-HK/README.md) | [Chinese (Traditional, Macau)](../zh-MO/README.md) | [Chinese (Traditional, Taiwan)](../zh-TW/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Kannada](../kn/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Malayalam](../ml/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Nigerian Pidgin](../pcm/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../pt-BR/README.md) | [Portuguese (Portugal)](../pt-PT/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](../sl/README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Telugu](../te/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)

> **লোকালি ক্লোন করতে চান?**  
>  
> এই রিপোজিটরিতে ৫০+ ভাষার অনুবাদ অন্তর্ভুক্ত, যা ডাউনলোড সাইজ উল্লেখযোগ্যভাবে বৃদ্ধি করে। অনুবাদ ছাড়া ক্লোন করতে, sparse checkout ব্যবহার করুন:  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> এতে কোর্স সম্পন্ন করার জন্য প্রয়োজনীয় সবকিছু দ্রুত ডাউনলোড হবে।  
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## কোর্সের কাঠামো ও শেখার পথ

### **অধ্যায় ১: জেনারেটিভ এআই এর পরিচিতি**
- **মূল ধারণা**: বড় ভাষা মডেলসমূহ, টোকেন, এম্বেডিংস, এবং এআই সক্ষমতার বোধগম্যতা  
- **জাভা এআই ইকোসিস্টেম**: Spring AI এবং OpenAI SDK এর ওভারভিউ  
- **মডেল কনটেক্সট প্রটোকল**: MCP এর পরিচিতি এবং এর ভূমিকা এআই এজেন্ট যোগাযোগে  
- **প্র্যাকটিক্যাল অ্যাপ্লিকেশনস**: বাস্তব জীবনের পরিস্থিতি যেমন চ্যাটবট এবং কন্টেন্ট জেনারেশন  
- **[→ অধ্যায় ১ শুরু করুন](./01-IntroToGenAI/README.md)**

### **অধ্যায় ২: ডেভেলপমেন্ট পরিবেশ সেটআপ**
- **একাধিক প্রদানকারী কনফিগারেশন**: GitHub Models, Azure OpenAI, এবং OpenAI Java SDK ইন্টিগ্রেশন সেটআপ  
- **Spring Boot + Spring AI**: এন্টারপ্রাইজ এআই অ্যাপ্লিকেশন উন্নয়নের সেরা অনুশীলন  
- **GitHub Models**: প্রোটোটাইপিং ও শেখার জন্য ফ্রি এআই মডেল অ্যাক্সেস (ক্রেডিট কার্ডের প্রয়োজন নেই)  
- **ডেভেলপমেন্ট টুলস**: Docker কন্টেইনার, VS Code, এবং GitHub Codespaces কনফিগারেশন  
- **[→ অধ্যায় ২ শুরু করুন](./02-SetupDevEnvironment/README.md)**

### **অধ্যায় ৩: মূল জেনারেটিভ এআই টেকনিকস**
- **প্রম্পট ইঞ্জিনিয়ারিং**: অপ্টিমাল এআই মডেল প্রতিক্রিয়া জন্য টেকনিকস  
- **এম্বেডিংস এবং ভেক্টর অপারেশনস**: সেমান্টিক সার্চ এবং সাদৃশ্য মিলায়ন প্রয়োগ  
- **রিট্রিভাল-অগমেন্টেড জেনারেশন (RAG)**: আপনার নিজের ডেটা উৎসের সাথে এআই একত্রিত করা  
- **ফাংশন কলিং**: কাস্টম টুলস এবং প্লাগইন দিয়ে এআই সক্ষমতা বৃদ্ধি  
- **[→ অধ্যায় ৩ শুরু করুন](./03-CoreGenerativeAITechniques/README.md)**

### **অধ্যায় ৪: বাস্তব প্রয়োগ ও প্রকল্প**
- **পেট স্টোরি জেনারেটর** (`petstory/`): GitHub Models ব্যবহার করে সৃজনশীল কন্টেন্ট উৎপাদন  
- **Foundry Local Demo** (`foundrylocal/`): OpenAI Java SDK দিয়ে লোকাল এআই মডেল ইন্টিগ্রেশন  
- **MCP Calculator Service** (`calculator/`): Spring AI ব্যবহার করে মডেল কনটেক্সট প্রটোকল বাস্তবায়ন  
- **[→ অধ্যায় ৪ শুরু করুন](./04-PracticalSamples/README.md)**

### **অধ্যায় ৫: দায়িত্বশীল এআই উন্নয়ন**
- **GitHub Models Safety**: বিল্ট-ইন কন্টেন্ট ফিল্টারিং ও সেফটি মেকানিজম (হার্ড ব্লক এবং সফট প্রত্যাখ্যান) পরীক্ষা  
- **দায়িত্বশীল এআই ডেমো**: আধুনিক এআই সেফটি সিস্টেম কিভাবে কাজ করে তা হাতে-কলমে উদাহরণ  
- **সেরা অনুশীলন**: নৈতিক এআই উন্নয়ন ও প্রয়োগের জন্য অত্যাবশ্যক নির্দেশিকা  
- **[→ অধ্যায় ৫ শুরু করুন](./05-ResponsibleGenAI/README.md)**

## অতিরিক্ত সম্পদ

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j for Beginners](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js for Beginners](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### Azure / Edge / MCP / Agents
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Generative AI Series
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### মূল শেখার বিষয়
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)

[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### কপাইলট সিরিজ
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## সাহায্যের জন্য

যদি আপনি আটকে যান বা AI অ্যাপ তৈরি সম্পর্কে কোনো প্রশ্ন থাকে। MCP সম্পর্কে সহপাঠী এবং অভিজ্ঞ ডেভেলপারদের সাথে আলোচনায় যোগ দিন। এটি একটি সহায়ক কমিউনিটি যেখানে প্রশ্ন স্বাগত এবং জ্ঞান বিনামূল্যে ভাগ করা হয়।

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

যদি আপনার পণ্যের মতামত বা নির্মাণকালে ত্রুটি থাকে তাহলে এই ঠিকানায় যান:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**দায়িত্ব পরিহার**:
এই ডকুমেন্টটি AI অনুবাদ সেবা [Co-op Translator](https://github.com/Azure/co-op-translator) ব্যবহার করে অনুবাদ করা হয়েছে। আমরা যথাসাধ্য সঠিকতার চেষ্টা করি, তবে স্বয়ংক্রিয় অনুবাদে ত্রুটি বা অসঙ্গতি থাকতে পারে। মূল ডকুমেন্টের স্বতন্ত্র ভাষাটি সর্বোচ্চ কর্তৃপক্ষ হিসেবে বিবেচনা করা উচিত। গুরুত্বপূর্ণ তথ্যের জন্য পেশাদার মানব অনুবাদ সুপারিশ করা হয়। এই অনুবাদের ব্যবহারে কোন ভুলবোঝাবুঝি বা ভুল ব্যাখ্যার জন্য আমরা দায়িত্ববোধ করি না।
<!-- CO-OP TRANSLATOR DISCLAIMER END -->