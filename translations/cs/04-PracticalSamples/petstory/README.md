<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T21:36:37+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "cs"
}
-->
# Aplikace Pet Story

>**Poznámka**: Tato kapitola obsahuje [**Návod**](./TUTORIAL.md), který vás provede spuštěním hotových ukázek.

Webová aplikace Spring Boot, která generuje popisy a příběhy poháněné umělou inteligencí pro nahrané obrázky mazlíčků pomocí GitHub Models.

## Obsah

- [Technologický Stack](../../../../04-PracticalSamples/petstory)
- [Předpoklady](../../../../04-PracticalSamples/petstory)
- [Nastavení a Instalace](../../../../04-PracticalSamples/petstory)
- [Použití](../../../../04-PracticalSamples/petstory)

## Technologický Stack

- **Backend**: Spring Boot 3.5.3, Java 21
- **Integrace AI**: OpenAI Java SDK s GitHub Models
- **Zabezpečení**: Spring Security
- **Frontend**: Šablony Thymeleaf s Bootstrap stylováním
- **Nástroj pro sestavení**: Maven
- **AI Modely**: GitHub Models

## Předpoklady

- Java 21 nebo vyšší
- Maven 3.9+
- GitHub Personal Access Token s oprávněním `models:read`

## Nastavení a Instalace

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

1. **Přístup k aplikaci**: Otevřete `http://localhost:8080`
2. **Nahrání obrázku**: Klikněte na "Vybrat soubor" a zvolte obrázek mazlíčka
3. **Analýza obrázku**: Klikněte na "Analyzovat obrázek" pro získání AI popisu
4. **Generování příběhu**: Klikněte na "Vytvořit příběh" pro vytvoření příběhu

**Prohlášení:**  
Tento dokument byl přeložen pomocí služby pro automatický překlad [Co-op Translator](https://github.com/Azure/co-op-translator). Ačkoli se snažíme o přesnost, mějte prosím na paměti, že automatické překlady mohou obsahovat chyby nebo nepřesnosti. Původní dokument v jeho původním jazyce by měl být považován za autoritativní zdroj. Pro důležité informace se doporučuje profesionální lidský překlad. Neodpovídáme za žádná nedorozumění nebo nesprávné interpretace vyplývající z použití tohoto překladu.