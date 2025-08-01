<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "57f14126c1c6add76b3aef3844dfe4e3",
  "translation_date": "2025-07-21T17:34:46+00:00",
  "source_file": "SECURITY.md",
  "language_code": "bn"
}
-->
## নিরাপত্তা

মাইক্রোসফট আমাদের সফটওয়্যার পণ্য এবং পরিষেবাগুলোর নিরাপত্তাকে অত্যন্ত গুরুত্ব সহকারে গ্রহণ করে, যার মধ্যে রয়েছে আমাদের GitHub সংগঠনগুলোর মাধ্যমে পরিচালিত সমস্ত সোর্স কোড রিপোজিটরি, যেমন [Microsoft](https://github.com/Microsoft), [Azure](https://github.com/Azure), [DotNet](https://github.com/dotnet), [AspNet](https://github.com/aspnet) এবং [Xamarin](https://github.com/xamarin)।

আপনি যদি মনে করেন যে আপনি মাইক্রোসফটের মালিকানাধীন কোনো রিপোজিটরিতে একটি নিরাপত্তা দুর্বলতা খুঁজে পেয়েছেন যা [মাইক্রোসফটের নিরাপত্তা দুর্বলতার সংজ্ঞা](https://aka.ms/security.md/definition) পূরণ করে, তাহলে দয়া করে নিচে বর্ণিত পদ্ধতিতে আমাদের কাছে রিপোর্ট করুন।

## নিরাপত্তা সমস্যা রিপোর্ট করা

**দয়া করে পাবলিক GitHub ইস্যুর মাধ্যমে নিরাপত্তা দুর্বলতা রিপোর্ট করবেন না।**

এর পরিবর্তে, মাইক্রোসফট সিকিউরিটি রেসপন্স সেন্টার (MSRC)-এ রিপোর্ট করুন: [https://msrc.microsoft.com/create-report](https://aka.ms/security.md/msrc/create-report)।

যদি আপনি লগ ইন না করে জমা দিতে পছন্দ করেন, তাহলে [secure@microsoft.com](mailto:secure@microsoft.com) ঠিকানায় ইমেইল পাঠান। সম্ভব হলে, আমাদের PGP কী দিয়ে আপনার বার্তা এনক্রিপ্ট করুন; এটি [Microsoft Security Response Center PGP Key page](https://aka.ms/security.md/msrc/pgp) থেকে ডাউনলোড করুন।

আপনি ২৪ ঘণ্টার মধ্যে একটি উত্তর পাবেন। যদি কোনো কারণে আপনি না পান, তাহলে নিশ্চিত করতে ইমেইলের মাধ্যমে অনুসরণ করুন যে আমরা আপনার মূল বার্তাটি পেয়েছি। অতিরিক্ত তথ্য [microsoft.com/msrc](https://www.microsoft.com/msrc) এ পাওয়া যাবে।

দয়া করে নিচে তালিকাভুক্ত তথ্য (যতটা সম্ভব সরবরাহ করতে পারেন) অন্তর্ভুক্ত করুন যাতে আমরা সম্ভাব্য সমস্যার প্রকৃতি এবং পরিসর আরও ভালোভাবে বুঝতে পারি:

  * সমস্যার ধরন (যেমন বাফার ওভারফ্লো, SQL ইনজেকশন, ক্রস-সাইট স্ক্রিপ্টিং ইত্যাদি)
  * সমস্যার সাথে সম্পর্কিত সোর্স ফাইল(গুলি)-এর সম্পূর্ণ পথ
  * প্রভাবিত সোর্স কোডের অবস্থান (ট্যাগ/ব্রাঞ্চ/কমিট বা সরাসরি URL)
  * সমস্যাটি পুনরুত্পাদন করতে প্রয়োজনীয় বিশেষ কনফিগারেশন
  * সমস্যাটি পুনরুত্পাদনের ধাপে ধাপে নির্দেশনা
  * প্রুফ-অফ-কনসেপ্ট বা এক্সপ্লয়েট কোড (যদি সম্ভব হয়)
  * সমস্যার প্রভাব, যার মধ্যে অন্তর্ভুক্ত কিভাবে একজন আক্রমণকারী সমস্যাটি কাজে লাগাতে পারে

এই তথ্য আমাদের রিপোর্টটি দ্রুত ত্রিয়াজ করতে সাহায্য করবে।

যদি আপনি বাগ বাউন্টির জন্য রিপোর্ট করছেন, তাহলে আরও সম্পূর্ণ রিপোর্ট একটি উচ্চতর বাউন্টি পুরস্কারে অবদান রাখতে পারে। আমাদের সক্রিয় প্রোগ্রামগুলোর বিষয়ে আরও বিস্তারিত জানার জন্য দয়া করে [Microsoft Bug Bounty Program](https://aka.ms/security.md/msrc/bounty) পৃষ্ঠাটি দেখুন।

## পছন্দের ভাষা

আমরা সমস্ত যোগাযোগ ইংরেজিতে করতে পছন্দ করি।

## নীতি

মাইক্রোসফট [সমন্বিত দুর্বলতা প্রকাশের](https://aka.ms/security.md/cvd) নীতিমালা অনুসরণ করে।

**অস্বীকৃতি**:  
এই নথিটি AI অনুবাদ পরিষেবা [Co-op Translator](https://github.com/Azure/co-op-translator) ব্যবহার করে অনুবাদ করা হয়েছে। আমরা যথাসাধ্য সঠিকতা নিশ্চিত করার চেষ্টা করি, তবে অনুগ্রহ করে মনে রাখবেন যে স্বয়ংক্রিয় অনুবাদে ত্রুটি বা অসঙ্গতি থাকতে পারে। এর মূল ভাষায় থাকা নথিটিকে প্রামাণিক উৎস হিসেবে বিবেচনা করা উচিত। গুরুত্বপূর্ণ তথ্যের জন্য, পেশাদার মানব অনুবাদ সুপারিশ করা হয়। এই অনুবাদ ব্যবহারের ফলে কোনো ভুল বোঝাবুঝি বা ভুল ব্যাখ্যা হলে আমরা তার জন্য দায়ী থাকব না।