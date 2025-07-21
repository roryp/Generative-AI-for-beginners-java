<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T16:52:47+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "hi"
}
-->
# पेट स्टोरी ऐप

>**Note**: इस अध्याय में एक [**ट्यूटोरियल**](./TUTORIAL.md) शामिल है जो आपको तैयार नमूनों को चलाने के लिए मार्गदर्शन करता है।

एक स्प्रिंग बूट वेब एप्लिकेशन जो अपलोड की गई पालतू जानवरों की तस्वीरों के लिए GitHub Models का उपयोग करके AI-संचालित विवरण और कहानियां बनाता है।

## सामग्री तालिका

- [तकनीकी स्टैक](../../../../04-PracticalSamples/petstory)
- [पूर्व आवश्यकताएँ](../../../../04-PracticalSamples/petstory)
- [सेटअप और इंस्टॉलेशन](../../../../04-PracticalSamples/petstory)
- [उपयोग](../../../../04-PracticalSamples/petstory)

## तकनीकी स्टैक

- **बैकएंड**: स्प्रिंग बूट 3.5.3, जावा 21
- **AI इंटीग्रेशन**: OpenAI Java SDK के साथ GitHub Models
- **सुरक्षा**: स्प्रिंग सिक्योरिटी
- **फ्रंटएंड**: Thymeleaf टेम्पलेट्स के साथ Bootstrap स्टाइलिंग
- **बिल्ड टूल**: Maven
- **AI मॉडल्स**: GitHub Models

## पूर्व आवश्यकताएँ

- जावा 21 या उससे अधिक
- Maven 3.9+
- `models:read` स्कोप के साथ GitHub पर्सनल एक्सेस टोकन

## सेटअप और इंस्टॉलेशन

### 1. पेटस्टोरी एप्लिकेशन डायरेक्टरी पर जाएं
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. एनवायरनमेंट वेरिएबल सेट करें
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. एप्लिकेशन को बिल्ड करें
```bash
mvn clean compile
```

### 4. एप्लिकेशन को चलाएं
```bash
mvn spring-boot:run
```

## उपयोग

1. **एप्लिकेशन एक्सेस करें**: `http://localhost:8080` पर जाएं
2. **इमेज अपलोड करें**: "Choose File" पर क्लिक करें और एक पालतू जानवर की तस्वीर चुनें
3. **इमेज का विश्लेषण करें**: "Analyze Image" पर क्लिक करें ताकि AI विवरण प्राप्त हो सके
4. **कहानी बनाएं**: "Generate Story" पर क्लिक करें ताकि कहानी बनाई जा सके

**अस्वीकरण**:  
यह दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) का उपयोग करके अनुवादित किया गया है। जबकि हम सटीकता सुनिश्चित करने का प्रयास करते हैं, कृपया ध्यान दें कि स्वचालित अनुवाद में त्रुटियां या अशुद्धियां हो सकती हैं। मूल भाषा में उपलब्ध मूल दस्तावेज़ को प्रामाणिक स्रोत माना जाना चाहिए। महत्वपूर्ण जानकारी के लिए, पेशेवर मानव अनुवाद की सिफारिश की जाती है। इस अनुवाद के उपयोग से उत्पन्न किसी भी गलतफहमी या गलत व्याख्या के लिए हम उत्तरदायी नहीं हैं।