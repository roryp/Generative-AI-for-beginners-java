<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T09:57:46+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "sw"
}
-->
# Pet Story App

>**Note**: Sura hii inajumuisha [**Mafunzo**](./TUTORIAL.md) yanayokuongoza kupitia mifano.

Programu ya wavuti ya Spring Boot inayotengeneza maelezo na hadithi zinazoendeshwa na AI kwa picha za wanyama waliopakiwa kwa kutumia GitHub Models.

## Jedwali la Maudhui

- [Teknolojia Inayotumika](../../../../04-PracticalSamples/petstory)
- [Mahitaji ya Awali](../../../../04-PracticalSamples/petstory)
- [Usanidi na Ufungaji](../../../../04-PracticalSamples/petstory)
- [Matumizi](../../../../04-PracticalSamples/petstory)

## Teknolojia Inayotumika

- **Backend**: Spring Boot 3.5.3, Java 21
- **Ujumuishaji wa AI**: OpenAI Java SDK na GitHub Models
- **Usalama**: Spring Security
- **Frontend**: Violezo vya Thymeleaf na mitindo ya Bootstrap
- **Zana ya Ujenzi**: Maven
- **Mifano ya AI**: GitHub Models

## Mahitaji ya Awali

- Java 21 au zaidi
- Maven 3.9+
- Token ya Kibinafsi ya GitHub yenye ruhusa ya `models:read`

## Usanidi na Ufungaji

### 1. Nenda kwenye saraka ya programu ya petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Weka Kigezo cha Mazingira
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Jenga Programu
```bash
mvn clean compile
```

### 4. Endesha Programu
```bash
mvn spring-boot:run
```

## Matumizi

1. **Fikia Programu**: Nenda kwenye `http://localhost:8080`
2. **Pakia Picha**: Bonyeza "Choose File" na uchague picha ya mnyama
3. **Changanua Picha**: Bonyeza "Analyze Image" ili kupata maelezo ya AI
4. **Tengeneza Hadithi**: Bonyeza "Generate Story" ili kuunda hadithi

**Kanusho**:  
Hati hii imetafsiriwa kwa kutumia huduma ya tafsiri ya AI [Co-op Translator](https://github.com/Azure/co-op-translator). Ingawa tunajitahidi kwa usahihi, tafadhali fahamu kuwa tafsiri za kiotomatiki zinaweza kuwa na makosa au kutokuwa sahihi. Hati asili katika lugha yake ya awali inapaswa kuzingatiwa kama chanzo cha mamlaka. Kwa taarifa muhimu, inashauriwa kutumia tafsiri ya kitaalamu ya binadamu. Hatutawajibika kwa kutoelewana au tafsiri zisizo sahihi zinazotokana na matumizi ya tafsiri hii.