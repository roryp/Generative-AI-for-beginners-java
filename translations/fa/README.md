# هوش مصنوعی مولد برای مبتدیان - نسخه جاوا
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![هوش مصنوعی مولد برای مبتدیان - نسخه جاوا](../../translated_images/fa/beg-genai-series.8b48be9951cc574c.webp)

**زمان مورد نیاز**: کل کارگاه به صورت آنلاین و بدون نیاز به راه‌اندازی محلی قابل انجام است. راه‌اندازی محیط ۲ دقیقه طول می‌کشد و کاوش نمونه‌ها بسته به عمق کاوش بین ۱ تا ۳ ساعت زمان می‌برد.

> **شروع سریع**

1. این مخزن را در حساب گیت‌هاب خود فورک کنید
2. روی **Code** کلیک کنید → زبانه **Codespaces** → **...** → **New with options...**
3. تنظیمات پیش‌فرض را استفاده کنید – این کار کانتینر توسعه ایجاد شده برای این دوره را انتخاب می‌کند
4. روی **Create codespace** کلیک کنید
5. حدود ۲ دقیقه صبر کنید تا محیط آماده شود
6. مستقیماً به [اولین مثال](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) بروید

> **ترجیح می‌دهید محلی کلون کنید؟**
>
> این مخزن شامل بیش از ۵۰ ترجمه زبانی است که به طور قابل توجهی حجم دانلود را افزایش می‌دهد. برای کلون بدون ترجمه‌ها، از sparse checkout استفاده کنید:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> این همه چیز مورد نیاز برای اتمام دوره را با دانلود بسیار سریع‌تر به شما می‌دهد.

## پشتیبانی چندزبانه

### پشتیبانی شده از طریق GitHub Action (خودکار و همیشه به‌روز)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[عربی](../ar/README.md) | [بنگالی](../bn/README.md) | [بلغاری](../bg/README.md) | [برمه‌ای (میانمار)](../my/README.md) | [چینی (ساده‌شده)](../zh-CN/README.md) | [چینی (سنتی، هنگ‌کنگ)](../zh-HK/README.md) | [چینی (سنتی، ماکائو)](../zh-MO/README.md) | [چینی (سنتی، تایوان)](../zh-TW/README.md) | [کرواتی](../hr/README.md) | [چکی](../cs/README.md) | [دانمارکی](../da/README.md) | [هلندی](../nl/README.md) | [استونیایی](../et/README.md) | [فنلاندی](../fi/README.md) | [فرانسوی](../fr/README.md) | [آلمانی](../de/README.md) | [یونانی](../el/README.md) | [عبری](../he/README.md) | [هندی](../hi/README.md) | [مجارستانی](../hu/README.md) | [اندونزیایی](../id/README.md) | [ایتالیایی](../it/README.md) | [ژاپنی](../ja/README.md) | [کانادا](../kn/README.md) | [کره‌ای](../ko/README.md) | [لیتوانیایی](../lt/README.md) | [مالایی](../ms/README.md) | [مالایالام](../ml/README.md) | [مراتی](../mr/README.md) | [نپالی](../ne/README.md) | [پیدجن نیجریه‌ای](../pcm/README.md) | [نروژی](../no/README.md) | [فارسی](./README.md) | [لهستانی](../pl/README.md) | [پرتغالی (برزیل)](../pt-BR/README.md) | [پرتغالی (پرتغال)](../pt-PT/README.md) | [پنجابی (گرموخی)](../pa/README.md) | [رومانیایی](../ro/README.md) | [روسی](../ru/README.md) | [صربی (سیریلیک)](../sr/README.md) | [اسلواکی](../sk/README.md) | [اسلوونیایی](../sl/README.md) | [اسپانیایی](../es/README.md) | [سواحیلی](../sw/README.md) | [سوئدی](../sv/README.md) | [تاگالوگ (فیلیپینی)](../tl/README.md) | [تامیل](../ta/README.md) | [تلوگو](../te/README.md) | [تایلندی](../th/README.md) | [ترکی](../tr/README.md) | [اوکراینی](../uk/README.md) | [اردو](../ur/README.md) | [ویتنامی](../vi/README.md)

## ساختار دوره و مسیر یادگیری

### **فصل ۱: مقدمه‌ای بر هوش مصنوعی مولد**
- **مفاهیم اصلی**: درک مدل‌های زبان بزرگ، توکن‌ها، تعبیه‌ها و قابلیت‌های هوش مصنوعی
- **اکوسیستم هوش مصنوعی جاوا**: مرور Spring AI و OpenAI SDKها
- **پروتکل زمینه مدل**: معرفی MCP و نقش آن در ارتباطات عامل‌های هوش مصنوعی
- **کاربردهای عملی**: سناریوهای واقعی شامل چت‌بات‌ها و تولید محتوا
- **[→ شروع فصل ۱](./01-IntroToGenAI/README.md)**

### **فصل ۲: راه‌اندازی محیط توسعه**
- **پیکربندی چند ارائه‌دهنده**: راه‌اندازی GitHub Models، Azure OpenAI و ادغام SDK جاوا OpenAI
- **Spring Boot + Spring AI**: بهترین روش‌ها برای توسعه برنامه‌های هوش مصنوعی سازمانی
- **GitHub Models**: دسترسی رایگان به مدل‌های هوش مصنوعی برای نمونه‌سازی و یادگیری (نیاز به کارت اعتباری ندارد)
- **ابزارهای توسعه**: کانتینرهای داکر، VS Code و پیکربندی GitHub Codespaces
- **[→ شروع فصل ۲](./02-SetupDevEnvironment/README.md)**

### **فصل ۳: تکنیک‌های اصلی هوش مصنوعی مولد**
- **مهندسی پرسش**: تکنیک‌های پاسخ‌دهی بهینه مدل هوش مصنوعی
- **تعبیه‌ها و عملیات برداری**: پیاده‌سازی جستجوی معنایی و تطبیق شباهت
- **تولید تقویت‌شده بازیابی (RAG)**: ترکیب هوش مصنوعی با منابع داده‌ی خودتان
- **فراخوانی تابع**: گسترش قابلیت‌های هوش مصنوعی با ابزارها و افزونه‌های سفارشی
- **[→ شروع فصل ۳](./03-CoreGenerativeAITechniques/README.md)**

### **فصل ۴: کاربردها و پروژه‌های عملی**
- **تولید کننده داستان حیوانات خانگی** (`petstory/`): تولید خلاقانه محتوا با GitHub Models
- **دموی محلی Foundry** (`foundrylocal/`): ادغام مدل هوش مصنوعی محلی با SDK جاوا OpenAI
- **سرویس ماشین حساب MCP** (`calculator/`): پیاده‌سازی پایه پروتکل زمینه مدل با Spring AI
- **[→ شروع فصل ۴](./04-PracticalSamples/README.md)**

### **فصل ۵: توسعه مسئولانه هوش مصنوعی**
- **ایمنی GitHub Models**: آزمایش فیلترینگ محتوا و مکانیزم‌های امنیتی داخلی (مسدودسازی سخت و ردهای نرم)
- **دموی هوش مصنوعی مسئولانه**: نمونه عملی نمایش نحوه عملکرد سیستم‌های ایمنی مدرن هوش مصنوعی
- **بهترین شیوه‌ها**: راهنماهای ضروری برای توسعه و استقرار اخلاقی هوش مصنوعی
- **[→ شروع فصل ۵](./05-ResponsibleGenAI/README.md)**

## منابع بیشتر

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j برای مبتدیان](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js برای مبتدیان](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain برای مبتدیان](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / Edge / MCP / عامل‌ها
[![AZD برای مبتدیان](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI برای مبتدیان](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP برای مبتدیان](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![عامل‌های هوش مصنوعی برای مبتدیان](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### سری هوش مصنوعی مولد
[![هوش مصنوعی مولد برای مبتدیان](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![هوش مصنوعی مولد (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![هوش مصنوعی مولد (جاوا)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![هوش مصنوعی مولد (جاوااسکریپت)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### یادگیری پایه
[![یادگیری ماشین برای مبتدیان](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![علوم داده برای مبتدیان](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![هوش مصنوعی برای مبتدیان](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![امنیت سایبری برای مبتدیان](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### سری کوپایلوت
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## دریافت کمک

اگر گیر کردید یا سوالی درباره ساخت برنامه‌های هوش مصنوعی داشتید، به بحث‌ها با دیگر یادگیرندگان و توسعه‌دهندگان باتجربه درباره MCP بپیوندید. این یک جامعه حمایتی است که در آن سوالات خوش‌آمد گفته می‌شود و دانش به‌طور آزادانه به اشتراک گذاشته می‌شود.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

اگر بازخورد محصول یا خطاهایی در حین ساخت دارید به اینجا مراجعه کنید:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**سلب مسئولیت**:
این سند با استفاده از سرویس ترجمه هوش مصنوعی [Co-op Translator](https://github.com/Azure/co-op-translator) ترجمه شده است. در حالی که ما برای دقت تلاش می‌کنیم، لطفاً توجه داشته باشید که ترجمه‌های خودکار ممکن است حاوی خطاها یا نادرستی‌هایی باشند. سند اصلی به زبان مادری آن باید به عنوان منبع معتبر در نظر گرفته شود. برای اطلاعات حیاتی، ترجمه حرفه‌ای انسانی توصیه می‌شود. ما در قبال هرگونه سوء تفاهم یا تفسیر نادرست ناشی از استفاده از این ترجمه مسئولیتی نداریم.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->