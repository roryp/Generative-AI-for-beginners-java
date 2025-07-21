<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T18:31:19+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "mr"
}
-->
# पाळीव प्राणी कथा अॅप

>**Note**: या अध्यायात [**Tutorial**](./TUTORIAL.md) समाविष्ट आहे, जो तुम्हाला तयार नमुन्ये चालवण्याचे मार्गदर्शन करतो.

एक Spring Boot वेब अॅप्लिकेशन जे GitHub Models चा वापर करून अपलोड केलेल्या पाळीव प्राण्यांच्या प्रतिमांसाठी AI-आधारित वर्णने आणि कथा तयार करते.

## विषय सूची

- [तंत्रज्ञान संच](../../../../04-PracticalSamples/petstory)
- [पूर्वअट](../../../../04-PracticalSamples/petstory)
- [सेटअप आणि स्थापना](../../../../04-PracticalSamples/petstory)
- [वापर](../../../../04-PracticalSamples/petstory)

## तंत्रज्ञान संच

- **बॅकएंड**: Spring Boot 3.5.3, Java 21
- **AI एकत्रीकरण**: OpenAI Java SDK GitHub Models सह
- **सुरक्षा**: Spring Security
- **फ्रंटएंड**: Thymeleaf टेम्पलेट्स Bootstrap शैलीसह
- **बिल्ड साधन**: Maven
- **AI मॉडेल्स**: GitHub Models

## पूर्वअट

- Java 21 किंवा त्याहून अधिक
- Maven 3.9+
- `models:read` स्कोपसह GitHub वैयक्तिक प्रवेश टोकन

## सेटअप आणि स्थापना

### 1. petstory अॅप्लिकेशन डिरेक्टरीमध्ये जा
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. पर्यावरणीय चल सेट करा
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. अॅप्लिकेशन तयार करा
```bash
mvn clean compile
```

### 4. अॅप्लिकेशन चालवा
```bash
mvn spring-boot:run
```

## वापर

1. **अॅप्लिकेशनमध्ये प्रवेश करा**: `http://localhost:8080` वर जा
2. **प्रतिमा अपलोड करा**: "Choose File" वर क्लिक करा आणि पाळीव प्राण्याची प्रतिमा निवडा
3. **प्रतिमा विश्लेषण करा**: "Analyze Image" वर क्लिक करा आणि AI वर्णन मिळवा
4. **कथा तयार करा**: "Generate Story" वर क्लिक करा आणि कथा तयार करा

**अस्वीकरण**:  
हा दस्तऐवज AI भाषांतर सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) चा वापर करून भाषांतरित करण्यात आला आहे. आम्ही अचूकतेसाठी प्रयत्नशील असलो तरी, कृपया लक्षात घ्या की स्वयंचलित भाषांतरांमध्ये त्रुटी किंवा अचूकतेचा अभाव असू शकतो. मूळ भाषेतील दस्तऐवज हा अधिकृत स्रोत मानला जावा. महत्त्वाच्या माहितीसाठी, व्यावसायिक मानवी भाषांतराची शिफारस केली जाते. या भाषांतराचा वापर करून उद्भवलेल्या कोणत्याही गैरसमज किंवा चुकीच्या अर्थासाठी आम्ही जबाबदार राहणार नाही.