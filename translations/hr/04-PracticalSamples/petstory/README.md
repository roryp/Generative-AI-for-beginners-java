<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T10:13:24+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "hr"
}
-->
# Aplikacija Pet Story

>**Note**: Ovo poglavlje uključuje [**Tutorial**](./TUTORIAL.md) koji vas vodi kroz primjere.

Web aplikacija temeljena na Spring Bootu koja generira opise i priče uz pomoć umjetne inteligencije za učitane slike kućnih ljubimaca koristeći GitHub modele.

## Sadržaj

- [Tehnološki Stack](../../../../04-PracticalSamples/petstory)
- [Preduvjeti](../../../../04-PracticalSamples/petstory)
- [Postavljanje i Instalacija](../../../../04-PracticalSamples/petstory)
- [Korištenje](../../../../04-PracticalSamples/petstory)

## Tehnološki Stack

- **Backend**: Spring Boot 3.5.3, Java 21
- **Integracija AI-a**: OpenAI Java SDK s GitHub modelima
- **Sigurnost**: Spring Security
- **Frontend**: Thymeleaf predlošci s Bootstrap stilizacijom
- **Alat za izgradnju**: Maven
- **AI modeli**: GitHub modeli

## Preduvjeti

- Java 21 ili novija verzija
- Maven 3.9+
- GitHub Personal Access Token s `models:read` dozvolom

## Postavljanje i Instalacija

### 1. Idite u direktorij aplikacije petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Postavite varijablu okruženja
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Izgradite aplikaciju
```bash
mvn clean compile
```

### 4. Pokrenite aplikaciju
```bash
mvn spring-boot:run
```

## Korištenje

1. **Pristup aplikaciji**: Idite na `http://localhost:8080`
2. **Učitajte sliku**: Kliknite "Choose File" i odaberite sliku kućnog ljubimca
3. **Analizirajte sliku**: Kliknite "Analyze Image" za dobivanje opisa uz pomoć AI-a
4. **Generirajte priču**: Kliknite "Generate Story" za kreiranje priče

**Odricanje od odgovornosti**:  
Ovaj dokument je preveden pomoću AI usluge za prevođenje [Co-op Translator](https://github.com/Azure/co-op-translator). Iako nastojimo osigurati točnost, imajte na umu da automatski prijevodi mogu sadržavati pogreške ili netočnosti. Izvorni dokument na izvornom jeziku treba smatrati autoritativnim izvorom. Za kritične informacije preporučuje se profesionalni prijevod od strane čovjeka. Ne preuzimamo odgovornost za nesporazume ili pogrešna tumačenja koja mogu proizaći iz korištenja ovog prijevoda.