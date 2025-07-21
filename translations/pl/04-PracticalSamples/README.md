<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "da1b6d87b8a73306b29f9a1bdd681221",
  "translation_date": "2025-07-21T16:32:34+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "pl"
}
-->
# Praktyczne Zastosowania i Projekty

> Uwaga: Każdy przykład zawiera również plik **TUTORIAL.md**, który krok po kroku wyjaśnia, jak uruchomić aplikację.

## Czego się nauczysz
W tej sekcji zaprezentujemy trzy praktyczne aplikacje, które pokazują wzorce rozwoju generatywnej AI z użyciem Java:
- Tworzenie wielomodalnego Generatora Opowieści o Zwierzętach, łączącego AI po stronie klienta i serwera
- Implementacja integracji lokalnego modelu AI w demo Foundry Local Spring Boot
- Rozwój usługi Model Context Protocol (MCP) na przykładzie Kalkulatora

## Spis Treści

- [Wprowadzenie](../../../04-PracticalSamples)
  - [Demo Foundry Local Spring Boot](../../../04-PracticalSamples)
  - [Generator Opowieści o Zwierzętach](../../../04-PracticalSamples)
  - [Usługa MCP Kalkulator (Przyjazne dla początkujących demo MCP)](../../../04-PracticalSamples)
- [Postęp w nauce](../../../04-PracticalSamples)
- [Podsumowanie](../../../04-PracticalSamples)
- [Kolejne kroki](../../../04-PracticalSamples)

## Wprowadzenie

Ten rozdział prezentuje **przykładowe projekty**, które demonstrują wzorce rozwoju generatywnej AI z użyciem Java. Każdy projekt jest w pełni funkcjonalny i pokazuje konkretne technologie AI, wzorce architektoniczne oraz najlepsze praktyki, które możesz dostosować do własnych aplikacji.

### Demo Foundry Local Spring Boot

**[Demo Foundry Local Spring Boot](foundrylocal/README.md)** pokazuje, jak zintegrować lokalne modele AI za pomocą **OpenAI Java SDK**. Demonstruje połączenie z modelem **Phi-3.5-mini** działającym na Foundry Local, umożliwiając uruchamianie aplikacji AI bez konieczności korzystania z usług w chmurze.

### Generator Opowieści o Zwierzętach

**[Generator Opowieści o Zwierzętach](petstory/README.md)** to angażująca aplikacja webowa Spring Boot, która demonstruje **wielomodalne przetwarzanie AI** w celu generowania kreatywnych opowieści o zwierzętach. Łączy możliwości AI po stronie klienta i serwera, wykorzystując transformer.js do interakcji AI w przeglądarce oraz OpenAI SDK do przetwarzania po stronie serwera.

### Usługa MCP Kalkulator (Przyjazne dla początkujących demo MCP)

**[Usługa MCP Kalkulator](mcp/calculator/README.md)** to prosta demonstracja **Model Context Protocol (MCP)** z użyciem Spring AI. Zapewnia przyjazne dla początkujących wprowadzenie do koncepcji MCP, pokazując, jak stworzyć podstawowy serwer MCP, który współdziała z klientami MCP.

## Postęp w nauce

Te projekty zostały zaprojektowane tak, aby budować wiedzę na podstawie koncepcji z poprzednich rozdziałów:

1. **Zacznij od podstaw**: Rozpocznij od demo Foundry Local Spring Boot, aby zrozumieć podstawową integrację AI z lokalnymi modelami
2. **Dodaj interaktywność**: Przejdź do Generatora Opowieści o Zwierzętach, aby poznać wielomodalne AI i interakcje webowe
3. **Poznaj podstawy MCP**: Wypróbuj Usługę MCP Kalkulator, aby zrozumieć fundamenty Model Context Protocol

## Podsumowanie

**Gratulacje!** Udało Ci się:

- **Stworzyć wielomodalne doświadczenia AI**, łącząc przetwarzanie AI po stronie klienta i serwera
- **Zaimplementować integrację lokalnych modeli AI** z użyciem nowoczesnych frameworków i SDK dla Java
- **Rozwinąć usługi Model Context Protocol**, demonstrując wzorce integracji narzędzi

## Kolejne kroki

[Rozdział 5: Odpowiedzialna Generatywna AI](../05-ResponsibleGenAI/README.md)

**Zastrzeżenie**:  
Ten dokument został przetłumaczony za pomocą usługi tłumaczeniowej AI [Co-op Translator](https://github.com/Azure/co-op-translator). Chociaż dokładamy wszelkich starań, aby tłumaczenie było precyzyjne, prosimy pamiętać, że automatyczne tłumaczenia mogą zawierać błędy lub nieścisłości. Oryginalny dokument w jego rodzimym języku powinien być uznawany za wiarygodne źródło. W przypadku informacji krytycznych zaleca się skorzystanie z profesjonalnego tłumaczenia wykonanego przez człowieka. Nie ponosimy odpowiedzialności za jakiekolwiek nieporozumienia lub błędne interpretacje wynikające z korzystania z tego tłumaczenia.