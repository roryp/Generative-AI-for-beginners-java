<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "ff595bec5b6294cb68860d540eae6302",
  "translation_date": "2025-11-18T16:51:37+00:00",
  "source_file": "README.md",
  "language_code": "de"
}
-->
# Generative KI für Anfänger - Java Edition
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative KI für Anfänger - Java Edition](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.de.png)

**Zeitaufwand**: Der gesamte Workshop kann online ohne lokale Einrichtung abgeschlossen werden. Die Einrichtung der Umgebung dauert 2 Minuten, das Erkunden der Beispiele erfordert je nach Tiefe 1-3 Stunden.

> **Schnellstart**

1. Forken Sie dieses Repository in Ihrem GitHub-Konto
2. Klicken Sie auf **Code** → **Codespaces**-Tab → **...** → **New with options...**
3. Verwenden Sie die Standardeinstellungen – dies wählt den für diesen Kurs erstellten Entwicklungscontainer aus
4. Klicken Sie auf **Create codespace**
5. Warten Sie ~2 Minuten, bis die Umgebung bereit ist
6. Springen Sie direkt zu [Das erste Beispiel](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Mehrsprachige Unterstützung

### Unterstützt durch GitHub Action (Automatisiert & Immer aktuell)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabisch](../ar/README.md) | [Bengalisch](../bn/README.md) | [Bulgarisch](../bg/README.md) | [Birmanisch (Myanmar)](../my/README.md) | [Chinesisch (Vereinfacht)](../zh/README.md) | [Chinesisch (Traditionell, Hongkong)](../hk/README.md) | [Chinesisch (Traditionell, Macau)](../mo/README.md) | [Chinesisch (Traditionell, Taiwan)](../tw/README.md) | [Kroatisch](../hr/README.md) | [Tschechisch](../cs/README.md) | [Dänisch](../da/README.md) | [Niederländisch](../nl/README.md) | [Estnisch](../et/README.md) | [Finnisch](../fi/README.md) | [Französisch](../fr/README.md) | [Deutsch](./README.md) | [Griechisch](../el/README.md) | [Hebräisch](../he/README.md) | [Hindi](../hi/README.md) | [Ungarisch](../hu/README.md) | [Indonesisch](../id/README.md) | [Italienisch](../it/README.md) | [Japanisch](../ja/README.md) | [Koreanisch](../ko/README.md) | [Litauisch](../lt/README.md) | [Malaiisch](../ms/README.md) | [Marathi](../mr/README.md) | [Nepalesisch](../ne/README.md) | [Nigerianisches Pidgin](../pcm/README.md) | [Norwegisch](../no/README.md) | [Persisch (Farsi)](../fa/README.md) | [Polnisch](../pl/README.md) | [Portugiesisch (Brasilien)](../br/README.md) | [Portugiesisch (Portugal)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Rumänisch](../ro/README.md) | [Russisch](../ru/README.md) | [Serbisch (Kyrillisch)](../sr/README.md) | [Slowakisch](../sk/README.md) | [Slowenisch](../sl/README.md) | [Spanisch](../es/README.md) | [Swahili](../sw/README.md) | [Schwedisch](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamilisch](../ta/README.md) | [Thailändisch](../th/README.md) | [Türkisch](../tr/README.md) | [Ukrainisch](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamesisch](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Kursstruktur & Lernpfad

### **Kapitel 1: Einführung in Generative KI**
- **Kernkonzepte**: Verständnis von großen Sprachmodellen, Tokens, Embeddings und KI-Fähigkeiten
- **Java KI-Ökosystem**: Überblick über Spring AI und OpenAI SDKs
- **Model Context Protocol**: Einführung in MCP und seine Rolle in der Kommunikation von KI-Agenten
- **Praktische Anwendungen**: Szenarien aus der realen Welt, einschließlich Chatbots und Inhaltserstellung
- **[→ Kapitel 1 starten](./01-IntroToGenAI/README.md)**

### **Kapitel 2: Einrichtung der Entwicklungsumgebung**
- **Multi-Provider-Konfiguration**: Einrichtung von GitHub Models, Azure OpenAI und OpenAI Java SDK-Integrationen
- **Spring Boot + Spring AI**: Best Practices für die Entwicklung von Unternehmens-KI-Anwendungen
- **GitHub Models**: Kostenloser Zugriff auf KI-Modelle für Prototyping und Lernen (keine Kreditkarte erforderlich)
- **Entwicklungstools**: Docker-Container, VS Code und GitHub Codespaces-Konfiguration
- **[→ Kapitel 2 starten](./02-SetupDevEnvironment/README.md)**

### **Kapitel 3: Kerntechniken der Generativen KI**
- **Prompt Engineering**: Techniken für optimale Antworten von KI-Modellen
- **Embeddings & Vektoroperationen**: Implementierung von semantischer Suche und Ähnlichkeitsabgleich
- **Retrieval-Augmented Generation (RAG)**: Kombination von KI mit eigenen Datenquellen
- **Funktionsaufrufe**: Erweiterung der KI-Fähigkeiten mit benutzerdefinierten Tools und Plugins
- **[→ Kapitel 3 starten](./03-CoreGenerativeAITechniques/README.md)**

### **Kapitel 4: Praktische Anwendungen & Projekte**
- **Pet Story Generator** (`petstory/`): Kreative Inhaltserstellung mit GitHub Models
- **Foundry Local Demo** (`foundrylocal/`): Lokale KI-Modellintegration mit OpenAI Java SDK
- **MCP Calculator Service** (`calculator/`): Grundlegende Model Context Protocol-Implementierung mit Spring AI
- **[→ Kapitel 4 starten](./04-PracticalSamples/README.md)**

### **Kapitel 5: Verantwortungsvolle KI-Entwicklung**
- **GitHub Models Sicherheit**: Testen von integrierten Inhaltsfiltern und Sicherheitsmechanismen (harte Sperren und weiche Ablehnungen)
- **Verantwortungsvolle KI-Demo**: Praktisches Beispiel, das zeigt, wie moderne KI-Sicherheitssysteme in der Praxis funktionieren
- **Best Practices**: Wesentliche Richtlinien für ethische KI-Entwicklung und -Bereitstellung
- **[→ Kapitel 5 starten](./05-ResponsibleGenAI/README.md)**

## Zusätzliche Ressourcen

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### Azure / Edge / MCP / Agenten
[![AZD für Anfänger](https://img.shields.io/badge/AZD%20für%20Anfänger-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge KI für Anfänger](https://img.shields.io/badge/Edge%20KI%20für%20Anfänger-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP für Anfänger](https://img.shields.io/badge/MCP%20für%20Anfänger-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![KI-Agenten für Anfänger](https://img.shields.io/badge/KI-Agenten%20für%20Anfänger-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### Generative KI-Serie
[![Generative KI für Anfänger](https://img.shields.io/badge/Generative%20KI%20für%20Anfänger-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative KI (.NET)](https://img.shields.io/badge/Generative%20KI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative KI (Java)](https://img.shields.io/badge/Generative%20KI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative KI (JavaScript)](https://img.shields.io/badge/Generative%20KI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---

### Kernlernen
[![ML für Anfänger](https://img.shields.io/badge/ML%20für%20Anfänger-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Datenwissenschaft für Anfänger](https://img.shields.io/badge/Datenwissenschaft%20für%20Anfänger-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![KI für Anfänger](https://img.shields.io/badge/KI%20für%20Anfänger-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersicherheit für Anfänger](https://img.shields.io/badge/Cybersicherheit%20für%20Anfänger-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Webentwicklung für Anfänger](https://img.shields.io/badge/Webentwicklung%20für%20Anfänger-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT für Anfänger](https://img.shields.io/badge/IoT%20für%20Anfänger-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR-Entwicklung für Anfänger](https://img.shields.io/badge/XR-Entwicklung%20für%20Anfänger-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### Copilot-Serie
[![Copilot für KI-gestütztes Pair Programming](https://img.shields.io/badge/Copilot%20für%20KI-gestütztes%20Pair%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot für C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)  
[![Copilot Abenteuer](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)  
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## Hilfe erhalten

Falls Sie nicht weiterkommen oder Fragen zum Erstellen von KI-Anwendungen haben, treten Sie der Community bei. Tauschen Sie sich mit anderen Lernenden und erfahrenen Entwicklern über MCP aus. Es ist eine unterstützende Gemeinschaft, in der Fragen willkommen sind und Wissen frei geteilt wird.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

Falls Sie Produktfeedback geben möchten oder auf Fehler beim Erstellen stoßen, besuchen Sie:

[![Microsoft Foundry Entwicklerforum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Haftungsausschluss**:  
Dieses Dokument wurde mit dem KI-Übersetzungsdienst [Co-op Translator](https://github.com/Azure/co-op-translator) übersetzt. Obwohl wir uns um Genauigkeit bemühen, beachten Sie bitte, dass automatisierte Übersetzungen Fehler oder Ungenauigkeiten enthalten können. Das Originaldokument in seiner ursprünglichen Sprache sollte als maßgebliche Quelle betrachtet werden. Für kritische Informationen wird eine professionelle menschliche Übersetzung empfohlen. Wir übernehmen keine Haftung für Missverständnisse oder Fehlinterpretationen, die sich aus der Nutzung dieser Übersetzung ergeben.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->