# Praktyczne zastosowania i projekty

[![Praktyczne zastosowania i projekty](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Praktyczne zastosowania i projekty")

> **Przegląd wideo:** [Obejrzyj "Practical Applications & Projects" na YouTube](https://www.youtube.com/watch?v=01vJsYei3H0).

## Czego się nauczysz
W tej sekcji zaprezentujemy trzy praktyczne zastosowania, które pokazują wzorce tworzenia generatywnej AI z użyciem Javy:
- Tworzenie wielomodalnego generatora opowieści o zwierzętach łączącego AI po stronie klienta i serwera
- Implementacja integracji lokalnego modelu AI przy użyciu demo Foundry Local Spring Boot
- Tworzenie usługi Model Context Protocol (MCP) na przykładzie kalkulatora

## Spis treści

- [Wprowadzenie](#wprowadzenie)
  - [Foundry Local Spring Boot Demo](#foundry-local-spring-boot-demo)
  - [Pet Story Generator](#pet-story-generator)
  - [MCP Calculator Service (Przyjazne dla początkujących demo MCP)](#mcp-calculator-service-przyjazne-dla-początkujących-demo-mcp)
- [Postęp w nauce](#postęp-w-nauce)
- [Podsumowanie](#podsumowanie)
- [Kolejne kroki](#kolejne-kroki)

## Wprowadzenie

Ten rozdział prezentuje **przykładowe projekty**, które demonstrują wzorce tworzenia generatywnej AI z Java. Każdy projekt jest w pełni funkcjonalny i pokazuje konkretne technologie AI, wzorce architektoniczne oraz najlepsze praktyki, które możesz zaadaptować do własnych aplikacji.

### Foundry Local Spring Boot Demo

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** pokazuje, jak integrować się z lokalnymi modelami AI za pomocą **OpenAI Java SDK**. Prezentuje połączenie z modelami uruchomionymi na Foundry Local (np. **Phi-4-mini**) z automatycznym wykrywaniem modelu, co pozwala na uruchamianie aplikacji AI bez konieczności korzystania z chmury.

### Pet Story Generator

**[Pet Story Generator](petstory/README.md)** to angażująca aplikacja webowa oparta na Spring Boot, która pokazuje **wielomodalne przetwarzanie AI** w celu generowania kreatywnych opowieści o zwierzętach. Łączy możliwości AI po stronie klienta i serwera, wykorzystując transformer.js do interakcji AI w przeglądarce oraz OpenAI SDK do przetwarzania po stronie serwera.

### MCP Calculator Service (Przyjazne dla początkujących demo MCP)

**[MCP Calculator Service](calculator/README.md)** jest prostą demonstracją **Model Context Protocol (MCP)** wykorzystującą Spring AI. Zapewnia przyjazne wprowadzenie do koncepcji MCP, pokazując jak stworzyć podstawowy serwer MCP, który współpracuje z klientami MCP.

## Postęp w nauce

Te projekty zostały zaprojektowane tak, aby poszerzać wiedzę zdobytą w poprzednich rozdziałach:

1. **Zacznij od prostego**: Rozpocznij od Foundry Local Spring Boot Demo, aby zrozumieć podstawową integrację AI z modelami lokalnymi
2. **Dodaj interaktywność**: Przejdź do Pet Story Generator, aby poznać wielomodalne AI i interakcje webowe
3. **Poznaj podstawy MCP**: Wypróbuj MCP Calculator Service, aby poznać zasady Model Context Protocol

## Podsumowanie

Dobra robota! Teraz poznaliście kilka rzeczywistych zastosowań:

- Wielomodalne doświadczenia AI działające zarówno w przeglądarce, jak i na serwerze
- Integrację lokalnych modeli AI z użyciem nowoczesnych frameworków Java i SDK
- Pierwszą usługę Model Context Protocol, aby zobaczyć, jak narzędzia integrują się z AI

## Kolejne kroki

[Rozdział 5: Odpowiedzialna generatywna AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Zastrzeżenie**:
Niniejszy dokument został przetłumaczony za pomocą usługi tłumaczenia AI [Co-op Translator](https://github.com/Azure/co-op-translator). Chociaż dążymy do dokładności, prosimy pamiętać, że automatyczne tłumaczenia mogą zawierać błędy lub nieścisłości. Oryginalny dokument w języku źródłowym powinien być traktowany jako autorytatywne źródło. W przypadku istotnych informacji zaleca się skorzystanie z profesjonalnego tłumaczenia wykonanego przez człowieka. Nie ponosimy odpowiedzialności za jakiekolwiek nieporozumienia lub błędne interpretacje wynikające z korzystania z tego tłumaczenia.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->