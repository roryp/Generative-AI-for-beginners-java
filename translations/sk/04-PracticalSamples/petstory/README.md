<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T21:36:46+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "sk"
}
-->
# Aplikácia Pet Story

>**Note**: Táto kapitola obsahuje [**Návod**](./TUTORIAL.md), ktorý vás prevedie spustením hotových ukážok.

Webová aplikácia Spring Boot, ktorá generuje AI popisy a príbehy pre nahrané obrázky domácich miláčikov pomocou GitHub Models.

## Obsah

- [Technologický Stack](../../../../04-PracticalSamples/petstory)
- [Predpoklady](../../../../04-PracticalSamples/petstory)
- [Nastavenie a Inštalácia](../../../../04-PracticalSamples/petstory)
- [Použitie](../../../../04-PracticalSamples/petstory)

## Technologický Stack

- **Backend**: Spring Boot 3.5.3, Java 21
- **AI Integrácia**: OpenAI Java SDK s GitHub Models
- **Bezpečnosť**: Spring Security
- **Frontend**: Thymeleaf šablóny so štýlom Bootstrap
- **Nástroj na Build**: Maven
- **AI Modely**: GitHub Models

## Predpoklady

- Java 21 alebo vyššia
- Maven 3.9+
- GitHub Personal Access Token s oprávnením `models:read`

## Nastavenie a Inštalácia

### 1. Prejdite do adresára aplikácie petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Nastavte Environmentálnu Premennú
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Zostavte Aplikáciu
```bash
mvn clean compile
```

### 4. Spustite Aplikáciu
```bash
mvn spring-boot:run
```

## Použitie

1. **Prístup k Aplikácii**: Otvorte `http://localhost:8080`
2. **Nahrajte Obrázok**: Kliknite na "Choose File" a vyberte obrázok domáceho miláčika
3. **Analyzujte Obrázok**: Kliknite na "Analyze Image" pre získanie AI popisu
4. **Vytvorte Príbeh**: Kliknite na "Generate Story" pre vytvorenie príbehu

**Upozornenie**:  
Tento dokument bol preložený pomocou služby AI prekladu [Co-op Translator](https://github.com/Azure/co-op-translator). Aj keď sa snažíme o presnosť, prosím, berte na vedomie, že automatizované preklady môžu obsahovať chyby alebo nepresnosti. Pôvodný dokument v jeho rodnom jazyku by mal byť považovaný za autoritatívny zdroj. Pre kritické informácie sa odporúča profesionálny ľudský preklad. Nie sme zodpovední za akékoľvek nedorozumenia alebo nesprávne interpretácie vyplývajúce z použitia tohto prekladu.