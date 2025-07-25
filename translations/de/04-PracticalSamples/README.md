<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "139c227ef39d24287257d1aff6fc6973",
  "translation_date": "2025-07-25T08:44:30+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "de"
}
-->
# Praktische Anwendungen & Projekte

> Hinweis: Jedes Beispiel enthält auch eine **TUTORIAL.md**, die Sie durch das Ausführen der Beispiele führt.

## Was Sie lernen werden
In diesem Abschnitt zeigen wir drei praktische Anwendungen, die Entwicklungsmuster für generative KI mit Java demonstrieren:
- Erstellen Sie einen Multi-Modal Pet Story Generator, der clientseitige und serverseitige KI kombiniert
- Implementieren Sie die Integration lokaler KI-Modelle mit der Foundry Local Spring Boot Demo
- Entwickeln Sie einen Model Context Protocol (MCP) Service mit dem Calculator-Beispiel

## Inhaltsverzeichnis

- [Einleitung](../../../04-PracticalSamples)
  - [Foundry Local Spring Boot Demo](../../../04-PracticalSamples)
  - [Pet Story Generator](../../../04-PracticalSamples)
  - [MCP Calculator Service (Einsteigerfreundliche MCP-Demo)](../../../04-PracticalSamples)
- [Lernfortschritt](../../../04-PracticalSamples)
- [Zusammenfassung](../../../04-PracticalSamples)
- [Nächste Schritte](../../../04-PracticalSamples)

## Einleitung

Dieses Kapitel präsentiert **Beispielprojekte**, die Entwicklungsmuster für generative KI mit Java demonstrieren. Jedes Projekt ist vollständig funktionsfähig und zeigt spezifische KI-Technologien, Architekturansätze und Best Practices, die Sie für Ihre eigenen Anwendungen anpassen können.

### Foundry Local Spring Boot Demo

Die **[Foundry Local Spring Boot Demo](foundrylocal/README.md)** zeigt, wie man lokale KI-Modelle mit dem **OpenAI Java SDK** integriert. Sie demonstriert die Verbindung mit dem **Phi-3.5-mini**-Modell, das auf Foundry Local läuft, und ermöglicht es Ihnen, KI-Anwendungen ohne Abhängigkeit von Cloud-Diensten auszuführen.

### Pet Story Generator

Der **[Pet Story Generator](petstory/README.md)** ist eine unterhaltsame Spring Boot-Webanwendung, die **multi-modale KI-Verarbeitung** demonstriert, um kreative Haustiergeschichten zu generieren. Sie kombiniert clientseitige und serverseitige KI-Funktionen mit transformer.js für KI-Interaktionen im Browser und dem OpenAI SDK für die serverseitige Verarbeitung.

### MCP Calculator Service (Einsteigerfreundliche MCP-Demo)

Der **[MCP Calculator Service](mcp/calculator/README.md)** ist eine einfache Demonstration des **Model Context Protocol (MCP)** mit Spring AI. Er bietet eine einsteigerfreundliche Einführung in MCP-Konzepte und zeigt, wie man einen grundlegenden MCP-Server erstellt, der mit MCP-Clients interagiert.

## Lernfortschritt

Diese Projekte bauen auf Konzepten aus den vorherigen Kapiteln auf:

1. **Einfach anfangen**: Beginnen Sie mit der Foundry Local Spring Boot Demo, um die grundlegende KI-Integration mit lokalen Modellen zu verstehen
2. **Interaktivität hinzufügen**: Gehen Sie zum Pet Story Generator über, um multi-modale KI und webbasierte Interaktionen zu erkunden
3. **MCP-Grundlagen lernen**: Probieren Sie den MCP Calculator Service aus, um die Grundlagen des Model Context Protocols zu verstehen

## Zusammenfassung

**Herzlichen Glückwunsch!** Sie haben erfolgreich:

- **Multi-modale KI-Erfahrungen erstellt**, die clientseitige und serverseitige KI-Verarbeitung kombinieren
- **Die Integration lokaler KI-Modelle implementiert** mit modernen Java-Frameworks und SDKs
- **Model Context Protocol Services entwickelt**, die Integrationsmuster für Werkzeuge demonstrieren

## Nächste Schritte

[Kapitel 5: Verantwortungsvolle generative KI](../05-ResponsibleGenAI/README.md)

**Haftungsausschluss**:  
Dieses Dokument wurde mithilfe des KI-Übersetzungsdienstes [Co-op Translator](https://github.com/Azure/co-op-translator) übersetzt. Obwohl wir uns um Genauigkeit bemühen, weisen wir darauf hin, dass automatisierte Übersetzungen Fehler oder Ungenauigkeiten enthalten können. Das Originaldokument in seiner ursprünglichen Sprache sollte als maßgebliche Quelle betrachtet werden. Für kritische Informationen wird eine professionelle menschliche Übersetzung empfohlen. Wir übernehmen keine Haftung für Missverständnisse oder Fehlinterpretationen, die aus der Nutzung dieser Übersetzung entstehen.