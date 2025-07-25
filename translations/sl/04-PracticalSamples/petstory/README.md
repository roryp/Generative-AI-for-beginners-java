<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T10:15:30+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "sl"
}
-->
# Aplikacija Pet Story

>**Opomba**: To poglavje vključuje [**Vadnico**](./TUTORIAL.md), ki vas vodi skozi primere.

Spletna aplikacija Spring Boot, ki s pomočjo GitHub Modelov generira opise in zgodbe, ki jih poganja umetna inteligenca, za naložene slike hišnih ljubljenčkov.

## Kazalo

- [Tehnološki sklad](../../../../04-PracticalSamples/petstory)
- [Predpogoji](../../../../04-PracticalSamples/petstory)
- [Namestitev in nastavitev](../../../../04-PracticalSamples/petstory)
- [Uporaba](../../../../04-PracticalSamples/petstory)

## Tehnološki sklad

- **Zaledje**: Spring Boot 3.5.3, Java 21
- **Integracija AI**: OpenAI Java SDK z GitHub Modeli
- **Varnost**: Spring Security
- **Sprednji del**: Thymeleaf predloge z Bootstrap oblikovanjem
- **Orodje za gradnjo**: Maven
- **AI modeli**: GitHub Modeli

## Predpogoji

- Java 21 ali novejša
- Maven 3.9+
- GitHub osebni dostopni žeton z dovoljenjem `models:read`

## Namestitev in nastavitev

### 1. Pomaknite se v imenik aplikacije petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Nastavite okoljsko spremenljivko
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Zgradite aplikacijo
```bash
mvn clean compile
```

### 4. Zaženite aplikacijo
```bash
mvn spring-boot:run
```

## Uporaba

1. **Dostop do aplikacije**: Pomaknite se na `http://localhost:8080`
2. **Naložite sliko**: Kliknite "Izberi datoteko" in izberite sliko hišnega ljubljenčka
3. **Analizirajte sliko**: Kliknite "Analiziraj sliko" za pridobitev opisa AI
4. **Ustvarite zgodbo**: Kliknite "Ustvari zgodbo" za generiranje zgodbe

**Omejitev odgovornosti**:  
Ta dokument je bil preveden z uporabo storitve AI za prevajanje [Co-op Translator](https://github.com/Azure/co-op-translator). Čeprav si prizadevamo za natančnost, vas prosimo, da upoštevate, da lahko avtomatizirani prevodi vsebujejo napake ali netočnosti. Izvirni dokument v njegovem maternem jeziku naj se šteje za avtoritativni vir. Za ključne informacije priporočamo profesionalni človeški prevod. Ne prevzemamo odgovornosti za morebitne nesporazume ali napačne razlage, ki bi nastale zaradi uporabe tega prevoda.