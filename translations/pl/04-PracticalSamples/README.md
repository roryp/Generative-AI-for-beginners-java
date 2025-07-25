<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "139c227ef39d24287257d1aff6fc6973",
  "translation_date": "2025-07-25T09:26:26+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "pl"
}
-->
# Praktyczne Zastosowania i Projekty

> Uwaga: Każdy przykład zawiera również plik **TUTORIAL.md**, który krok po kroku wyjaśnia, jak uruchomić próbki.

## Czego się nauczysz
W tej sekcji zaprezentujemy trzy praktyczne zastosowania, które pokazują wzorce rozwoju generatywnej sztucznej inteligencji z użyciem Javy:
- Tworzenie wielomodalnego Generatora Opowieści o Zwierzakach, łączącego AI po stronie klienta i serwera
- Wdrożenie integracji z lokalnym modelem AI za pomocą demonstracji Foundry Local Spring Boot
- Opracowanie usługi Model Context Protocol (MCP) na przykładzie Kalkulatora

## Spis Treści

- [Wprowadzenie](../../../04-PracticalSamples)
  - [Foundry Local Spring Boot Demo](../../../04-PracticalSamples)
  - [Generator Opowieści o Zwierzakach](../../../04-PracticalSamples)
  - [Usługa MCP Kalkulator (Przyjazna dla Początkujących Demonstracja MCP)](../../../04-PracticalSamples)
- [Postęp w Nauce](../../../04-PracticalSamples)
- [Podsumowanie](../../../04-PracticalSamples)
- [Kolejne Kroki](../../../04-PracticalSamples)

## Wprowadzenie

Ten rozdział prezentuje **przykładowe projekty**, które demonstrują wzorce rozwoju generatywnej sztucznej inteligencji z użyciem Javy. Każdy projekt jest w pełni funkcjonalny i ilustruje konkretne technologie AI, wzorce architektoniczne oraz najlepsze praktyki, które możesz zaadaptować do własnych aplikacji.

### Foundry Local Spring Boot Demo

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** pokazuje, jak zintegrować się z lokalnymi modelami AI za pomocą **OpenAI Java SDK**. Demonstruje połączenie z modelem **Phi-3.5-mini** działającym na Foundry Local, co pozwala na uruchamianie aplikacji AI bez konieczności korzystania z usług w chmurze.

### Generator Opowieści o Zwierzakach

**[Generator Opowieści o Zwierzakach](petstory/README.md)** to angażująca aplikacja webowa Spring Boot, która demonstruje **wielomodalne przetwarzanie AI** do tworzenia kreatywnych opowieści o zwierzakach. Łączy możliwości AI po stronie klienta i serwera, wykorzystując transformer.js do interakcji AI w przeglądarce oraz OpenAI SDK do przetwarzania po stronie serwera.

### Usługa MCP Kalkulator (Przyjazna dla Początkujących Demonstracja MCP)

**[Usługa MCP Kalkulator](mcp/calculator/README.md)** to prosta demonstracja **Model Context Protocol (MCP)** z użyciem Spring AI. Zapewnia przyjazne dla początkujących wprowadzenie do koncepcji MCP, pokazując, jak stworzyć podstawowy serwer MCP, który współpracuje z klientami MCP.

## Postęp w Nauce

Te projekty zostały zaprojektowane tak, aby budować wiedzę krok po kroku:

1. **Zacznij od podstaw**: Rozpocznij od Foundry Local Spring Boot Demo, aby zrozumieć podstawową integrację AI z lokalnymi modelami
2. **Dodaj interaktywność**: Przejdź do Generatora Opowieści o Zwierzakach, aby poznać wielomodalne AI i interakcje webowe
3. **Poznaj podstawy MCP**: Wypróbuj Usługę MCP Kalkulator, aby zrozumieć fundamenty Model Context Protocol

## Podsumowanie

**Gratulacje!** Udało Ci się:

- **Stworzyć wielomodalne doświadczenia AI**, łącząc przetwarzanie AI po stronie klienta i serwera
- **Wdrożyć integrację z lokalnym modelem AI** z wykorzystaniem nowoczesnych frameworków i SDK dla Javy
- **Opracować usługi Model Context Protocol**, demonstrując wzorce integracji narzędzi

## Kolejne Kroki

[Rozdział 5: Odpowiedzialna Generatywna Sztuczna Inteligencja](../05-ResponsibleGenAI/README.md)

**Zastrzeżenie**:  
Ten dokument został przetłumaczony za pomocą usługi tłumaczenia AI [Co-op Translator](https://github.com/Azure/co-op-translator). Chociaż dokładamy wszelkich starań, aby tłumaczenie było precyzyjne, prosimy pamiętać, że automatyczne tłumaczenia mogą zawierać błędy lub nieścisłości. Oryginalny dokument w jego rodzimym języku powinien być uznawany za autorytatywne źródło. W przypadku informacji o kluczowym znaczeniu zaleca się skorzystanie z profesjonalnego tłumaczenia przez człowieka. Nie ponosimy odpowiedzialności za jakiekolwiek nieporozumienia lub błędne interpretacje wynikające z użycia tego tłumaczenia.