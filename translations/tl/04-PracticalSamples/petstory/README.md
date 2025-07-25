<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T09:55:33+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "tl"
}
-->
# Pet Story App

>**Note**: Ang kabanatang ito ay may kasamang [**Tutorial**](./TUTORIAL.md) na magtuturo sa iyo gamit ang mga halimbawa.

Isang Spring Boot web application na gumagawa ng mga AI-powered na deskripsyon at kwento para sa mga in-upload na larawan ng alagang hayop gamit ang GitHub Models.

## Nilalaman

- [Teknolohiyang Ginamit](../../../../04-PracticalSamples/petstory)
- [Mga Kinakailangan](../../../../04-PracticalSamples/petstory)
- [Setup at Pag-install](../../../../04-PracticalSamples/petstory)
- [Paggamit](../../../../04-PracticalSamples/petstory)

## Teknolohiyang Ginamit

- **Backend**: Spring Boot 3.5.3, Java 21
- **AI Integration**: OpenAI Java SDK gamit ang GitHub Models
- **Seguridad**: Spring Security
- **Frontend**: Thymeleaf templates na may Bootstrap styling
- **Build Tool**: Maven
- **AI Models**: GitHub Models

## Mga Kinakailangan

- Java 21 o mas mataas
- Maven 3.9+
- GitHub Personal Access Token na may `models:read` scope

## Setup at Pag-install

### 1. Pumunta sa direktoryo ng petstory application
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Itakda ang Environment Variable
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. I-build ang Application
```bash
mvn clean compile
```

### 4. Patakbuhin ang Application
```bash
mvn spring-boot:run
```

## Paggamit

1. **I-access ang Application**: Pumunta sa `http://localhost:8080`
2. **Mag-upload ng Larawan**: I-click ang "Choose File" at pumili ng larawan ng alagang hayop
3. **I-analyze ang Larawan**: I-click ang "Analyze Image" para makuha ang AI na deskripsyon
4. **Gumawa ng Kwento**: I-click ang "Generate Story" para gumawa ng kwento

**Paunawa**:  
Ang dokumentong ito ay isinalin gamit ang AI translation service na [Co-op Translator](https://github.com/Azure/co-op-translator). Bagama't sinisikap naming maging tumpak, pakitandaan na ang mga awtomatikong pagsasalin ay maaaring maglaman ng mga pagkakamali o hindi pagkakatugma. Ang orihinal na dokumento sa kanyang katutubong wika ang dapat ituring na opisyal na pinagmulan. Para sa mahalagang impormasyon, inirerekomenda ang propesyonal na pagsasalin ng tao. Hindi kami mananagot sa anumang hindi pagkakaunawaan o maling interpretasyon na dulot ng paggamit ng pagsasaling ito.