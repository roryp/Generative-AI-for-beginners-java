<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "4d04ae8088f6a3c3fcbab18cbdfe4002",
  "translation_date": "2025-10-03T08:10:44+00:00",
  "source_file": "README.md",
  "language_code": "pl"
}
-->
# Generatywna AI dla Początkujących - Edycja Java
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generatywna AI dla Początkujących - Edycja Java](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.pl.png)

**Czas trwania**: Cały warsztat można ukończyć online bez lokalnej konfiguracji. Przygotowanie środowiska zajmuje 2 minuty, a eksploracja przykładów wymaga od 1 do 3 godzin, w zależności od głębokości eksploracji.

> **Szybki Start** 

1. Sforkuj to repozytorium na swoje konto GitHub
2. Kliknij **Code** → zakładka **Codespaces** → **...** → **New with options...**
3. Użyj domyślnych ustawień – zostanie wybrany kontener deweloperski stworzony dla tego kursu
4. Kliknij **Create codespace**
5. Poczekaj ~2 minuty, aż środowisko będzie gotowe
6. Przejdź od razu do [Pierwszego przykładu](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Obsługa wielu języków

### Obsługiwane przez GitHub Action (Automatyczne i zawsze aktualne)

[Francuski](../fr/README.md) | [Hiszpański](../es/README.md) | [Niemiecki](../de/README.md) | [Rosyjski](../ru/README.md) | [Arabski](../ar/README.md) | [Perski (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Chiński (uproszczony)](../zh/README.md) | [Chiński (tradycyjny, Makau)](../mo/README.md) | [Chiński (tradycyjny, Hongkong)](../hk/README.md) | [Chiński (tradycyjny, Tajwan)](../tw/README.md) | [Japoński](../ja/README.md) | [Koreański](../ko/README.md) | [Hindi](../hi/README.md) | [Bengalski](../bn/README.md) | [Marathi](../mr/README.md) | [Nepalski](../ne/README.md) | [Pendżabski (Gurmukhi)](../pa/README.md) | [Portugalski (Portugalia)](../pt/README.md) | [Portugalski (Brazylia)](../br/README.md) | [Włoski](../it/README.md) | [Polski](./README.md) | [Turecki](../tr/README.md) | [Grecki](../el/README.md) | [Tajski](../th/README.md) | [Szwedzki](../sv/README.md) | [Duński](../da/README.md) | [Norweski](../no/README.md) | [Fiński](../fi/README.md) | [Holenderski](../nl/README.md) | [Hebrajski](../he/README.md) | [Wietnamski](../vi/README.md) | [Indonezyjski](../id/README.md) | [Malajski](../ms/README.md) | [Tagalog (Filipiński)](../tl/README.md) | [Suahili](../sw/README.md) | [Węgierski](../hu/README.md) | [Czeski](../cs/README.md) | [Słowacki](../sk/README.md) | [Rumuński](../ro/README.md) | [Bułgarski](../bg/README.md) | [Serbski (cyrylica)](../sr/README.md) | [Chorwacki](../hr/README.md) | [Słoweński](../sl/README.md) | [Ukraiński](../uk/README.md) | [Birmański (Myanmar)](../my/README.md)

## Struktura kursu i ścieżka nauki

### **Rozdział 1: Wprowadzenie do Generatywnej AI**
- **Podstawowe pojęcia**: Zrozumienie dużych modeli językowych, tokenów, osadzeń i możliwości AI
- **Ekosystem AI w Javie**: Przegląd Spring AI i OpenAI SDK
- **Protokół kontekstu modelu**: Wprowadzenie do MCP i jego roli w komunikacji agentów AI
- **Praktyczne zastosowania**: Scenariusze z życia wzięte, w tym chatboty i generowanie treści
- **[→ Rozpocznij Rozdział 1](./01-IntroToGenAI/README.md)**

### **Rozdział 2: Konfiguracja środowiska deweloperskiego**
- **Konfiguracja wielu dostawców**: Integracja modeli GitHub, Azure OpenAI i OpenAI Java SDK
- **Spring Boot + Spring AI**: Najlepsze praktyki w tworzeniu aplikacji AI dla przedsiębiorstw
- **Modele GitHub**: Darmowy dostęp do modeli AI do prototypowania i nauki (bez potrzeby karty kredytowej)
- **Narzędzia deweloperskie**: Konfiguracja kontenerów Docker, VS Code i GitHub Codespaces
- **[→ Rozpocznij Rozdział 2](./02-SetupDevEnvironment/README.md)**

### **Rozdział 3: Podstawowe techniki generatywnej AI**
- **Inżynieria promptów**: Techniki optymalizacji odpowiedzi modeli AI
- **Osadzenia i operacje na wektorach**: Implementacja wyszukiwania semantycznego i dopasowywania podobieństw
- **Generacja wspomagana wyszukiwaniem (RAG)**: Łączenie AI z własnymi źródłami danych
- **Wywoływanie funkcji**: Rozszerzanie możliwości AI za pomocą niestandardowych narzędzi i wtyczek
- **[→ Rozpocznij Rozdział 3](./03-CoreGenerativeAITechniques/README.md)**

### **Rozdział 4: Praktyczne zastosowania i projekty**
- **Generator historii o zwierzętach** (`petstory/`): Tworzenie kreatywnych treści z wykorzystaniem modeli GitHub
- **Lokalna demonstracja Foundry** (`foundrylocal/`): Integracja lokalnych modeli AI z OpenAI Java SDK
- **Usługa kalkulatora MCP** (`calculator/`): Podstawowa implementacja protokołu kontekstu modelu z Spring AI
- **[→ Rozpocznij Rozdział 4](./04-PracticalSamples/README.md)**

### **Rozdział 5: Odpowiedzialny rozwój AI**
- **Bezpieczeństwo modeli GitHub**: Testowanie wbudowanego filtrowania treści i mechanizmów bezpieczeństwa (blokady twarde i miękkie odmowy)
- **Demonstracja odpowiedzialnej AI**: Praktyczny przykład pokazujący działanie nowoczesnych systemów bezpieczeństwa AI
- **Najlepsze praktyki**: Kluczowe wytyczne dotyczące etycznego rozwoju i wdrażania AI
- **[→ Rozpocznij Rozdział 5](./05-ResponsibleGenAI/README.md)**

## Dodatkowe zasoby 

- [Edge AI dla Początkujących](https://github.com/microsoft/edgeai-for-beginners)
- [MCP dla Początkujących](https://github.com/microsoft/mcp-for-beginners)
- [Agenci AI dla Początkujących](https://github.com/microsoft/ai-agents-for-beginners)
- [Generatywna AI dla Początkujących z użyciem .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generatywna AI dla Początkujących z użyciem JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generatywna AI dla Początkujących](https://github.com/microsoft/generative-ai-for-beginners)
- [ML dla Początkujących](https://aka.ms/ml-beginners)
- [Data Science dla Początkujących](https://aka.ms/datascience-beginners)
- [AI dla Początkujących](https://aka.ms/ai-beginners)
- [Cyberbezpieczeństwo dla Początkujących](https://github.com/microsoft/Security-101)
- [Web Dev dla Początkujących](https://aka.ms/webdev-beginners)
- [IoT dla Początkujących](https://aka.ms/iot-beginners)
- [XR Development dla Początkujących](https://github.com/microsoft/xr-development-for-beginners)
- [Opanowanie GitHub Copilot dla programowania w parach z AI](https://aka.ms/GitHubCopilotAI)
- [Opanowanie GitHub Copilot dla programistów C#/.NET](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Wybierz swoją własną przygodę z Copilotem](https://github.com/microsoft/CopilotAdventures)
- [Aplikacja czatu RAG z usługami Azure AI](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Uzyskiwanie pomocy

Jeśli utkniesz lub masz pytania dotyczące budowania aplikacji AI, dołącz:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Jeśli masz uwagi dotyczące produktu lub napotkałeś błędy podczas budowy, odwiedź:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Zastrzeżenie**:  
Ten dokument został przetłumaczony za pomocą usługi tłumaczenia AI [Co-op Translator](https://github.com/Azure/co-op-translator). Chociaż dokładamy wszelkich starań, aby tłumaczenie było precyzyjne, prosimy pamiętać, że automatyczne tłumaczenia mogą zawierać błędy lub nieścisłości. Oryginalny dokument w jego rodzimym języku powinien być uznawany za źródło autorytatywne. W przypadku informacji krytycznych zaleca się skorzystanie z profesjonalnego tłumaczenia przez człowieka. Nie ponosimy odpowiedzialności za jakiekolwiek nieporozumienia lub błędne interpretacje wynikające z użycia tego tłumaczenia.