<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:19:35+00:00",
  "source_file": "README.md",
  "language_code": "fa"
}
-->
# هوش مصنوعی مولد برای مبتدیان - نسخه جاوا
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![هوش مصنوعی مولد برای مبتدیان - نسخه جاوا](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.fa.png)

**مدت زمان مورد نیاز**: کل کارگاه را می‌توان به صورت آنلاین و بدون نیاز به تنظیمات محلی تکمیل کرد. تنظیم محیط تنها ۲ دقیقه زمان می‌برد و بررسی نمونه‌ها بسته به عمق بررسی، ۱ تا ۳ ساعت زمان نیاز دارد.

> **شروع سریع**

1. این مخزن را به حساب GitHub خود فورک کنید
2. روی **Code** → تب **Codespaces** → **...** → **New with options...** کلیک کنید
3. تنظیمات پیش‌فرض را انتخاب کنید – این گزینه کانتینر توسعه ایجاد شده برای این دوره را انتخاب می‌کند
4. روی **Create codespace** کلیک کنید
5. حدود ۲ دقیقه منتظر بمانید تا محیط آماده شود
6. مستقیماً به [اولین مثال](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) بروید

## پشتیبانی چندزبانه

### پشتیبانی از طریق GitHub Action (خودکار و همیشه به‌روز)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[عربی](../ar/README.md) | [بنگالی](../bn/README.md) | [بلغاری](../bg/README.md) | [برمه‌ای (میانمار)](../my/README.md) | [چینی (ساده‌شده)](../zh/README.md) | [چینی (سنتی، هنگ‌کنگ)](../hk/README.md) | [چینی (سنتی، ماکائو)](../mo/README.md) | [چینی (سنتی، تایوان)](../tw/README.md) | [کرواتی](../hr/README.md) | [چکی](../cs/README.md) | [دانمارکی](../da/README.md) | [هلندی](../nl/README.md) | [استونیایی](../et/README.md) | [فنلاندی](../fi/README.md) | [فرانسوی](../fr/README.md) | [آلمانی](../de/README.md) | [یونانی](../el/README.md) | [عبری](../he/README.md) | [هندی](../hi/README.md) | [مجاری](../hu/README.md) | [اندونزیایی](../id/README.md) | [ایتالیایی](../it/README.md) | [ژاپنی](../ja/README.md) | [کره‌ای](../ko/README.md) | [لیتوانیایی](../lt/README.md) | [مالایی](../ms/README.md) | [مراتی](../mr/README.md) | [نپالی](../ne/README.md) | [نروژی](../no/README.md) | [فارسی](./README.md) | [لهستانی](../pl/README.md) | [پرتغالی (برزیل)](../br/README.md) | [پرتغالی (پرتغال)](../pt/README.md) | [پنجابی (گرمکی)](../pa/README.md) | [رومانیایی](../ro/README.md) | [روسی](../ru/README.md) | [صربی (سیریلیک)](../sr/README.md) | [اسلواکی](../sk/README.md) | [اسلوونیایی](../sl/README.md) | [اسپانیایی](../es/README.md) | [سواحیلی](../sw/README.md) | [سوئدی](../sv/README.md) | [تاگالوگ (فیلیپینی)](../tl/README.md) | [تامیلی](../ta/README.md) | [تایلندی](../th/README.md) | [ترکی](../tr/README.md) | [اوکراینی](../uk/README.md) | [اردو](../ur/README.md) | [ویتنامی](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## ساختار دوره و مسیر یادگیری

### **فصل ۱: مقدمه‌ای بر هوش مصنوعی مولد**
- **مفاهیم اصلی**: آشنایی با مدل‌های زبان بزرگ، توکن‌ها، تعبیه‌ها و قابلیت‌های هوش مصنوعی
- **اکوسیستم هوش مصنوعی جاوا**: مرور Spring AI و OpenAI SDKs
- **پروتکل زمینه مدل**: معرفی MCP و نقش آن در ارتباط عوامل هوش مصنوعی
- **کاربردهای عملی**: سناریوهای واقعی شامل چت‌بات‌ها و تولید محتوا
- **[→ شروع فصل ۱](./01-IntroToGenAI/README.md)**

### **فصل ۲: تنظیم محیط توسعه**
- **پیکربندی چند ارائه‌دهنده**: تنظیم ادغام‌های GitHub Models، Azure OpenAI و OpenAI Java SDK
- **Spring Boot + Spring AI**: بهترین روش‌ها برای توسعه برنامه‌های هوش مصنوعی سازمانی
- **مدل‌های GitHub**: دسترسی رایگان به مدل‌های هوش مصنوعی برای نمونه‌سازی و یادگیری (بدون نیاز به کارت اعتباری)
- **ابزارهای توسعه**: کانتینرهای Docker، VS Code و پیکربندی GitHub Codespaces
- **[→ شروع فصل ۲](./02-SetupDevEnvironment/README.md)**

### **فصل ۳: تکنیک‌های اصلی هوش مصنوعی مولد**
- **مهندسی درخواست**: تکنیک‌هایی برای پاسخ‌های بهینه مدل‌های هوش مصنوعی
- **تعبیه‌ها و عملیات برداری**: پیاده‌سازی جستجوی معنایی و تطبیق شباهت
- **تولید تقویت‌شده با بازیابی (RAG)**: ترکیب هوش مصنوعی با منابع داده خود
- **فراخوانی توابع**: گسترش قابلیت‌های هوش مصنوعی با ابزارها و افزونه‌های سفارشی
- **[→ شروع فصل ۳](./03-CoreGenerativeAITechniques/README.md)**

### **فصل ۴: کاربردهای عملی و پروژه‌ها**
- **تولید داستان حیوانات خانگی** (`petstory/`): تولید محتوای خلاقانه با مدل‌های GitHub
- **دموی محلی Foundry** (`foundrylocal/`): ادغام مدل‌های هوش مصنوعی محلی با OpenAI Java SDK
- **سرویس ماشین‌حساب MCP** (`calculator/`): پیاده‌سازی اولیه پروتکل زمینه مدل با Spring AI
- **[→ شروع فصل ۴](./04-PracticalSamples/README.md)**

### **فصل ۵: توسعه مسئولانه هوش مصنوعی**
- **ایمنی مدل‌های GitHub**: آزمایش فیلتر محتوای داخلی و مکانیزم‌های ایمنی (مسدودسازی سخت و رد نرم)
- **دموی هوش مصنوعی مسئولانه**: مثال عملی نشان‌دهنده نحوه عملکرد سیستم‌های ایمنی مدرن هوش مصنوعی
- **بهترین روش‌ها**: دستورالعمل‌های ضروری برای توسعه و استقرار اخلاقی هوش مصنوعی
- **[→ شروع فصل ۵](./05-ResponsibleGenAI/README.md)**

## منابع اضافی

- [هوش مصنوعی لبه برای مبتدیان](https://github.com/microsoft/edgeai-for-beginners)
- [MCP برای مبتدیان](https://github.com/microsoft/mcp-for-beginners)
- [عوامل هوش مصنوعی برای مبتدیان](https://github.com/microsoft/ai-agents-for-beginners)
- [هوش مصنوعی مولد برای مبتدیان با استفاده از .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [هوش مصنوعی مولد برای مبتدیان با استفاده از JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [هوش مصنوعی مولد برای مبتدیان](https://github.com/microsoft/generative-ai-for-beginners)
- [یادگیری ماشین برای مبتدیان](https://aka.ms/ml-beginners)
- [علم داده برای مبتدیان](https://aka.ms/datascience-beginners)
- [هوش مصنوعی برای مبتدیان](https://aka.ms/ai-beginners)
- [امنیت سایبری برای مبتدیان](https://github.com/microsoft/Security-101)
- [توسعه وب برای مبتدیان](https://aka.ms/webdev-beginners)
- [اینترنت اشیا برای مبتدیان](https://aka.ms/iot-beginners)
- [توسعه XR برای مبتدیان](https://github.com/microsoft/xr-development-for-beginners)
- [تسلط بر GitHub Copilot برای برنامه‌نویسی جفتی هوش مصنوعی](https://aka.ms/GitHubCopilotAI)
- [تسلط بر GitHub Copilot برای توسعه‌دهندگان C#/.NET](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [ماجراجویی Copilot خود را انتخاب کنید](https://github.com/microsoft/CopilotAdventures)
- [برنامه چت RAG با خدمات هوش مصنوعی Azure](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## دریافت کمک

اگر در ساخت برنامه‌های هوش مصنوعی گیر کردید یا سوالی دارید، به اینجا بپیوندید:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

اگر بازخورد محصول دارید یا در هنگام ساخت خطاهایی مشاهده کردید، به اینجا مراجعه کنید:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**سلب مسئولیت**:  
این سند با استفاده از سرویس ترجمه هوش مصنوعی [Co-op Translator](https://github.com/Azure/co-op-translator) ترجمه شده است. در حالی که ما تلاش می‌کنیم دقت را حفظ کنیم، لطفاً توجه داشته باشید که ترجمه‌های خودکار ممکن است شامل خطاها یا نادرستی‌ها باشند. سند اصلی به زبان اصلی آن باید به عنوان منبع معتبر در نظر گرفته شود. برای اطلاعات حساس، توصیه می‌شود از ترجمه حرفه‌ای انسانی استفاده کنید. ما مسئولیتی در قبال سوء تفاهم‌ها یا تفسیرهای نادرست ناشی از استفاده از این ترجمه نداریم.