<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T10:02:19+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "cs"
}
-->
# Aplikace Pet Story

>**Note**: Tato kapitola obsahuje [**Návod**](./TUTORIAL.md), který vás provede ukázkami.

Webová aplikace Spring Boot, která generuje popisy a příběhy poháněné AI pro nahrané obrázky domácích mazlíčků pomocí GitHub Models.

## Obsah

- [Technologický stack](../../../../04-PracticalSamples/petstory)
- [Předpoklady](../../../../04-PracticalSamples/petstory)
- [Nastavení a instalace](../../../../04-PracticalSamples/petstory)
- [Použití](../../../../04-PracticalSamples/petstory)

## Technologický stack

- **Backend**: Spring Boot 3.5.3, Java 21
- **Integrace AI**: OpenAI Java SDK s GitHub Models
- **Zabezpečení**: Spring Security
- **Frontend**: Šablony Thymeleaf s Bootstrap stylováním
- **Nástroj pro sestavení**: Maven
- **AI modely**: GitHub Models

## Předpoklady

- Java 21 nebo vyšší
- Maven 3.9+
- GitHub Personal Access Token s oprávněním `models:read`

## Nastavení a instalace

### 1. Přejděte do adresáře aplikace petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Nastavte proměnnou prostředí
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Sestavte aplikaci
```bash
mvn clean compile
```

### 4. Spusťte aplikaci
```bash
mvn spring-boot:run
```

## Použití

1. **Přístup k aplikaci**: Přejděte na `http://localhost:8080`
2. **Nahrání obrázku**: Klikněte na "Vybrat soubor" a vyberte obrázek domácího mazlíčka
3. **Analýza obrázku**: Klikněte na "Analyzovat obrázek" pro získání popisu od AI
4. **Generování příběhu**: Klikněte na "Generovat příběh" pro vytvoření příběhu

**Prohlášení:**  
Tento dokument byl přeložen pomocí služby pro automatický překlad [Co-op Translator](https://github.com/Azure/co-op-translator). Ačkoli se snažíme o přesnost, mějte prosím na paměti, že automatické překlady mohou obsahovat chyby nebo nepřesnosti. Původní dokument v jeho původním jazyce by měl být považován za autoritativní zdroj. Pro důležité informace se doporučuje profesionální lidský překlad. Neodpovídáme za žádná nedorozumění nebo nesprávné interpretace vyplývající z použití tohoto překladu.