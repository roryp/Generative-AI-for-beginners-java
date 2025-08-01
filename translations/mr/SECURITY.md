<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "57f14126c1c6add76b3aef3844dfe4e3",
  "translation_date": "2025-07-21T17:35:01+00:00",
  "source_file": "SECURITY.md",
  "language_code": "mr"
}
-->
## सुरक्षा

मायक्रोसॉफ्ट आपल्या सॉफ्टवेअर उत्पादने आणि सेवांच्या सुरक्षेला गंभीरपणे घेतो, ज्यामध्ये आमच्या GitHub संस्थांद्वारे व्यवस्थापित केलेल्या सर्व स्रोत कोड रिपॉझिटरीजचा समावेश होतो, ज्यामध्ये [Microsoft](https://github.com/Microsoft), [Azure](https://github.com/Azure), [DotNet](https://github.com/dotnet), [AspNet](https://github.com/aspnet) आणि [Xamarin](https://github.com/xamarin) यांचा समावेश आहे.

जर तुम्हाला मायक्रोसॉफ्टच्या मालकीच्या कोणत्याही रिपॉझिटरीमध्ये [मायक्रोसॉफ्टच्या सुरक्षा असुरक्षिततेच्या परिभाषा](https://aka.ms/security.md/definition) पूर्ण करणारी सुरक्षा असुरक्षितता आढळली असेल, तर कृपया खाली दिलेल्या पद्धतीनुसार आम्हाला कळवा.

## सुरक्षा समस्या कळवणे

**कृपया सार्वजनिक GitHub समस्यांद्वारे सुरक्षा असुरक्षितता कळवू नका.**

त्याऐवजी, कृपया Microsoft Security Response Center (MSRC) ला [https://msrc.microsoft.com/create-report](https://aka.ms/security.md/msrc/create-report) येथे कळवा.

जर तुम्हाला लॉग इन न करता सबमिट करणे पसंत असेल, तर [secure@microsoft.com](mailto:secure@microsoft.com) वर ईमेल पाठवा. शक्य असल्यास, आमच्या PGP कीसह तुमचा संदेश एन्क्रिप्ट करा; कृपया [Microsoft Security Response Center PGP Key page](https://aka.ms/security.md/msrc/pgp) वरून ती डाउनलोड करा.

तुम्हाला 24 तासांच्या आत उत्तर मिळेल. काही कारणास्तव तुम्हाला उत्तर मिळाले नाही, तर कृपया ईमेलद्वारे फॉलो अप करा जेणेकरून आम्हाला तुमचा मूळ संदेश मिळाला आहे याची खात्री होईल. अतिरिक्त माहिती [microsoft.com/msrc](https://www.microsoft.com/msrc) येथे मिळू शकते.

कृपया खालील माहिती (जास्तीत जास्त तुम्ही देऊ शकता) समाविष्ट करा जेणेकरून आम्हाला संभाव्य समस्येचे स्वरूप आणि व्याप्ती अधिक चांगल्या प्रकारे समजून घेता येईल:

  * समस्येचा प्रकार (उदा. बफर ओव्हरफ्लो, SQL इंजेक्शन, क्रॉस-साइट स्क्रिप्टिंग, इ.)
  * समस्येच्या प्रकटीकरणाशी संबंधित स्रोत फाइल(स)चे पूर्ण पथ
  * प्रभावित स्रोत कोडचे स्थान (टॅग/ब्रँच/कमिट किंवा थेट URL)
  * समस्या पुनरुत्पादित करण्यासाठी आवश्यक असलेली कोणतीही विशेष कॉन्फिगरेशन
  * समस्या पुनरुत्पादित करण्यासाठी चरण-दर-चरण सूचना
  * पुरावा-संकल्पना किंवा शोषण कोड (शक्य असल्यास)
  * समस्येचा प्रभाव, ज्यामध्ये हल्लेखोर समस्या कशी शोषण करू शकतो याचा समावेश आहे

ही माहिती आम्हाला तुमचा अहवाल अधिक वेगाने वर्गीकृत करण्यात मदत करेल.

जर तुम्ही बग बाऊंटी साठी अहवाल देत असाल, तर अधिक पूर्ण अहवाल उच्च बाऊंटी पुरस्कारात योगदान देऊ शकतो. कृपया आमच्या सक्रिय कार्यक्रमांबद्दल अधिक तपशीलांसाठी [Microsoft Bug Bounty Program](https://aka.ms/security.md/msrc/bounty) पृष्ठाला भेट द्या.

## प्राधान्य भाषा

आम्हाला सर्व संवाद इंग्रजीमध्ये असणे प्राधान्य आहे.

## धोरण

मायक्रोसॉफ्ट [Coordinated Vulnerability Disclosure](https://aka.ms/security.md/cvd) च्या तत्त्वांचे पालन करते.

**अस्वीकरण**:  
हा दस्तऐवज AI भाषांतर सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) चा वापर करून भाषांतरित करण्यात आला आहे. आम्ही अचूकतेसाठी प्रयत्नशील असलो तरी कृपया लक्षात ठेवा की स्वयंचलित भाषांतरे त्रुटी किंवा अचूकतेच्या अभावाने युक्त असू शकतात. मूळ भाषेतील दस्तऐवज हा अधिकृत स्रोत मानला जावा. महत्त्वाच्या माहितीसाठी, व्यावसायिक मानवी भाषांतराची शिफारस केली जाते. या भाषांतराचा वापर करून उद्भवलेल्या कोणत्याही गैरसमज किंवा चुकीच्या अर्थासाठी आम्ही जबाबदार नाही.