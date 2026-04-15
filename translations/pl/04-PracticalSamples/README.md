# Praktyczne zastosowania i projekty

[![Praktyczne zastosowania i projekty](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Praktyczne zastosowania i projekty")

> **Przegląd wideo:** [Obejrzyj "Praktyczne zastosowania i projekty" na YouTube](https://www.youtube.com/watch?v=01vJsYei3H0).

## Czego się nauczysz
W tej sekcji zaprezentujemy trzy praktyczne zastosowania, które pokazują wzorce tworzenia generatywnej AI w Javie:
- Utworzenie wielomodalnego generatora opowieści o zwierzętach łączącego AI po stronie klienta i serwera
- Implementacja lokalnej integracji modelu AI z demonstracją Foundry Local Spring Boot
- Opracowanie usługi Model Context Protocol (MCP) na przykładzie kalkulatora

## Spis treści

- [Wprowadzenie](#wprowadzenie)
  - [Demonstracja Foundry Local Spring Boot](#demonstracja-foundry-local-spring-boot)
  - [Generator opowieści o zwierzętach](#generator-opowieści-o-zwierzętach)
  - [Usługa MCP Calculator (przyjazna dla początkujących demonstracja MCP)](#usługa-mcp-calculator-przyjazna-dla-początkujących-demonstracja-mcp)
- [Postęp w nauce](#postęp-w-nauce)
- [Podsumowanie](#podsumowanie)
- [Kolejne kroki](#kolejne-kroki)

## Wprowadzenie

Ten rozdział prezentuje **przykładowe projekty**, które demonstrują wzorce tworzenia generatywnej AI w Javie. Każdy projekt jest w pełni funkcjonalny i pokazuje konkretne technologie AI, wzorce architektoniczne oraz najlepsze praktyki, które możesz zastosować we własnych aplikacjach.

### Demonstracja Foundry Local Spring Boot

**[Demonstracja Foundry Local Spring Boot](foundrylocal/README.md)** pokazuje, jak integrować się z lokalnymi modelami AI za pomocą **OpenAI Java SDK**. Demonstruje łączenie z modelem **Phi-3.5-mini** działającym na Foundry Local, co pozwala uruchamiać aplikacje AI bez konieczności korzystania z usług chmurowych.

### Generator opowieści o zwierzętach

**[Generator opowieści o zwierzętach](petstory/README.md)** to angażująca aplikacja webowa Spring Boot, która demonstruje **wielomodalne przetwarzanie AI** do generowania kreatywnych historii o zwierzętach. Łączy możliwości AI po stronie klienta i serwera, wykorzystując transformer.js do interakcji AI w przeglądarce oraz OpenAI SDK do przetwarzania po stronie serwera.

### Usługa MCP Calculator (przyjazna dla początkujących demonstracja MCP)

**[Usługa MCP Calculator](calculator/README.md)** to prosta demonstracja **Model Context Protocol (MCP)** z użyciem Spring AI. Stanowi wprowadzenie dla początkujących do koncepcji MCP, pokazując jak utworzyć podstawowy serwer MCP, który komunikuje się z klientami MCP.

## Postęp w nauce

Projekty te zostały zaprojektowane tak, aby rozwijać koncepcje z poprzednich rozdziałów:

1. **Zacznij od podstaw**: Rozpocznij od demonstracji Foundry Local Spring Boot, aby zrozumieć podstawową integrację AI z lokalnymi modelami
2. **Dodaj interaktywność**: Przejdź do Generatora opowieści o zwierzętach, aby poznać wielomodalną AI i interakcje webowe
3. **Poznaj podstawy MCP**: Wypróbuj usługę MCP Calculator, aby zrozumieć fundamenty Model Context Protocol

## Podsumowanie

Dobra robota! Teraz zapoznałeś się z prawdziwymi zastosowaniami:

- Wielomodalne doświadczenia AI działające zarówno w przeglądarce, jak i na serwerze
- Integracja lokalnych modeli AI z użyciem nowoczesnych frameworków Java i SDK
- Twoja pierwsza usługa Model Context Protocol, by zobaczyć, jak narzędzia współpracują z AI

## Kolejne kroki

[Rozdział 5: Odpowiedzialna generatywna AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Zastrzeżenie**:  
Ten dokument został przetłumaczony przy użyciu usług tłumaczenia AI [Co-op Translator](https://github.com/Azure/co-op-translator). Chociaż dążymy do dokładności, prosimy mieć na uwadze, że automatyczne tłumaczenia mogą zawierać błędy lub nieścisłości. Oryginalny dokument w jego rodzimym języku powinien być uznawany za źródło autorytatywne. W przypadku krytycznych informacji zaleca się skorzystanie z profesjonalnego tłumaczenia wykonanego przez człowieka. Nie ponosimy odpowiedzialności za wszelkie nieporozumienia lub błędne interpretacje wynikające z korzystania z tego tłumaczenia.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->