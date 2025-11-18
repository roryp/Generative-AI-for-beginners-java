<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "ff595bec5b6294cb68860d540eae6302",
  "translation_date": "2025-11-18T16:55:02+00:00",
  "source_file": "README.md",
  "language_code": "fa"
}
-->
# هوش مصنوعی مولد برای مبتدیان - نسخه جاوا
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![هوش مصنوعی مولد برای مبتدیان - نسخه جاوا](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.fa.png)

**مدت زمان مورد نیاز**: کل کارگاه به صورت آنلاین و بدون نیاز به تنظیمات محلی قابل انجام است. تنظیم محیط ۲ دقیقه زمان می‌برد و بررسی نمونه‌ها بسته به عمق کاوش ۱ تا ۳ ساعت زمان نیاز دارد.

> **شروع سریع**

1. این مخزن را به حساب GitHub خود فورک کنید.
2. روی **Code** → تب **Codespaces** → **...** → **New with options...** کلیک کنید.
3. از تنظیمات پیش‌فرض استفاده کنید – این تنظیمات کانتینر توسعه‌ای که برای این دوره ایجاد شده است را انتخاب می‌کند.
4. روی **Create codespace** کلیک کنید.
5. حدود ۲ دقیقه صبر کنید تا محیط آماده شود.
6. مستقیماً به [اولین مثال](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token) بروید.

## پشتیبانی چندزبانه

### پشتیبانی از طریق GitHub Action (خودکار و همیشه به‌روز)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[عربی](../ar/README.md) | [بنگالی](../bn/README.md) | [بلغاری](../bg/README.md) | [برمه‌ای (میانمار)](../my/README.md) | [چینی (ساده‌شده)](../zh/README.md) | [چینی (سنتی، هنگ‌کنگ)](../hk/README.md) | [چینی (سنتی، ماکائو)](../mo/README.md) | [چینی (سنتی، تایوان)](../tw/README.md) | [کرواتی](../hr/README.md) | [چکی](../cs/README.md) | [دانمارکی](../da/README.md) | [هلندی](../nl/README.md) | [استونیایی](../et/README.md) | [فنلاندی](../fi/README.md) | [فرانسوی](../fr/README.md) | [آلمانی](../de/README.md) | [یونانی](../el/README.md) | [عبری](../he/README.md) | [هندی](../hi/README.md) | [مجاری](../hu/README.md) | [اندونزیایی](../id/README.md) | [ایتالیایی](../it/README.md) | [ژاپنی](../ja/README.md) | [کره‌ای](../ko/README.md) | [لیتوانیایی](../lt/README.md) | [مالایی](../ms/README.md) | [مراتی](../mr/README.md) | [نپالی](../ne/README.md) | [پیجین نیجریه‌ای](../pcm/README.md) | [نروژی](../no/README.md) | [فارسی](./README.md) | [لهستانی](../pl/README.md) | [پرتغالی (برزیل)](../br/README.md) | [پرتغالی (پرتغال)](../pt/README.md) | [پنجابی (گورمخی)](../pa/README.md) | [رومانیایی](../ro/README.md) | [روسی](../ru/README.md) | [صربی (سیریلیک)](../sr/README.md) | [اسلواکی](../sk/README.md) | [اسلوونیایی](../sl/README.md) | [اسپانیایی](../es/README.md) | [سواحیلی](../sw/README.md) | [سوئدی](../sv/README.md) | [تاگالوگ (فیلیپینی)](../tl/README.md) | [تامیلی](../ta/README.md) | [تایلندی](../th/README.md) | [ترکی](../tr/README.md) | [اوکراینی](../uk/README.md) | [اردو](../ur/README.md) | [ویتنامی](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## ساختار دوره و مسیر یادگیری

### **فصل ۱: مقدمه‌ای بر هوش مصنوعی مولد**
- **مفاهیم اصلی**: آشنایی با مدل‌های زبانی بزرگ، توکن‌ها، جاسازی‌ها و قابلیت‌های هوش مصنوعی
- **اکوسیستم هوش مصنوعی جاوا**: مرور Spring AI و OpenAI SDKs
- **پروتکل زمینه مدل**: معرفی MCP و نقش آن در ارتباط عوامل هوش مصنوعی
- **کاربردهای عملی**: سناریوهای واقعی شامل چت‌بات‌ها و تولید محتوا
- **[→ شروع فصل ۱](./01-IntroToGenAI/README.md)**

### **فصل ۲: تنظیم محیط توسعه**
- **پیکربندی چند ارائه‌دهنده**: تنظیم مدل‌های GitHub، Azure OpenAI و OpenAI Java SDK
- **Spring Boot + Spring AI**: بهترین روش‌ها برای توسعه برنامه‌های هوش مصنوعی سازمانی
- **مدل‌های GitHub**: دسترسی رایگان به مدل‌های هوش مصنوعی برای نمونه‌سازی و یادگیری (بدون نیاز به کارت اعتباری)
- **ابزارهای توسعه**: پیکربندی کانتینرهای Docker، VS Code و GitHub Codespaces
- **[→ شروع فصل ۲](./02-SetupDevEnvironment/README.md)**

### **فصل ۳: تکنیک‌های اصلی هوش مصنوعی مولد**
- **مهندسی درخواست**: تکنیک‌هایی برای پاسخ‌های بهینه مدل‌های هوش مصنوعی
- **جاسازی‌ها و عملیات برداری**: پیاده‌سازی جستجوی معنایی و تطبیق شباهت
- **تولید بازیابی-تقویت‌شده (RAG)**: ترکیب هوش مصنوعی با منابع داده خود
- **فراخوانی توابع**: گسترش قابلیت‌های هوش مصنوعی با ابزارها و افزونه‌های سفارشی
- **[→ شروع فصل ۳](./03-CoreGenerativeAITechniques/README.md)**

### **فصل ۴: کاربردها و پروژه‌های عملی**
- **تولید داستان حیوانات خانگی** (`petstory/`): تولید محتوای خلاقانه با مدل‌های GitHub
- **دموی محلی Foundry** (`foundrylocal/`): یکپارچه‌سازی مدل‌های هوش مصنوعی محلی با OpenAI Java SDK
- **خدمات محاسبه MCP** (`calculator/`): پیاده‌سازی اولیه پروتکل زمینه مدل با Spring AI
- **[→ شروع فصل ۴](./04-PracticalSamples/README.md)**

### **فصل ۵: توسعه مسئولانه هوش مصنوعی**
- **ایمنی مدل‌های GitHub**: آزمایش فیلترهای محتوای داخلی و مکانیزم‌های ایمنی (مسدودسازی سخت و رد نرم)
- **دموی هوش مصنوعی مسئولانه**: مثال عملی که نشان می‌دهد سیستم‌های ایمنی مدرن هوش مصنوعی چگونه کار می‌کنند
- **بهترین روش‌ها**: دستورالعمل‌های ضروری برای توسعه و استقرار اخلاقی هوش مصنوعی
- **[→ شروع فصل ۵](./05-ResponsibleGenAI/README.md)**

## منابع اضافی

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### Azure / Edge / MCP / عوامل
[![AZD برای مبتدیان](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![هوش مصنوعی Edge برای مبتدیان](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP برای مبتدیان](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![عوامل هوش مصنوعی برای مبتدیان](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### سری هوش مصنوعی مولد
[![هوش مصنوعی مولد برای مبتدیان](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![هوش مصنوعی مولد (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![هوش مصنوعی مولد (جاوا)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![هوش مصنوعی مولد (جاوااسکریپت)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---

### یادگیری اصلی
[![یادگیری ماشین برای مبتدیان](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![علم داده برای مبتدیان](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![هوش مصنوعی برای مبتدیان](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![امنیت سایبری برای مبتدیان](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![توسعه وب برای مبتدیان](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![اینترنت اشیا برای مبتدیان](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![توسعه XR برای مبتدیان](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### سری Copilot
[![Copilot برای برنامه‌نویسی جفتی هوش مصنوعی](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot برای C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)  
[![ماجراجویی Copilot](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)  
<!-- پایان دوره‌های دیگر CO-OP TRANSLATOR -->

## دریافت کمک

اگر در حین ساخت برنامه‌های هوش مصنوعی به مشکل برخوردید یا سوالی داشتید، به جمع دیگر یادگیرندگان و توسعه‌دهندگان با تجربه در بحث‌های مربوط به MCP بپیوندید. این یک جامعه حمایتی است که در آن سوالات پذیرفته می‌شوند و دانش به صورت آزادانه به اشتراک گذاشته می‌شود.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

اگر بازخوردی درباره محصول دارید یا در حین ساخت با خطا مواجه شدید، به اینجا مراجعه کنید:

[![انجمن توسعه‌دهندگان Microsoft Foundry](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**سلب مسئولیت**:  
این سند با استفاده از سرویس ترجمه هوش مصنوعی [Co-op Translator](https://github.com/Azure/co-op-translator) ترجمه شده است. در حالی که ما برای دقت تلاش می‌کنیم، لطفاً توجه داشته باشید که ترجمه‌های خودکار ممکن است شامل خطاها یا نادرستی‌هایی باشد. سند اصلی به زبان اصلی آن باید به عنوان منبع معتبر در نظر گرفته شود. برای اطلاعات حیاتی، ترجمه حرفه‌ای انسانی توصیه می‌شود. ما مسئولیتی در قبال هرگونه سوءتفاهم یا تفسیر نادرست ناشی از استفاده از این ترجمه نداریم.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->