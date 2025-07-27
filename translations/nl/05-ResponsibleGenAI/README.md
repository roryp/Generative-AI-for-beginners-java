<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "fee0290b2606d36ac1eea26d6a0a453a",
  "translation_date": "2025-07-27T08:53:27+00:00",
  "source_file": "05-ResponsibleGenAI/README.md",
  "language_code": "nl"
}
-->
# Verantwoordelijke Generatieve AI

## Wat Je Gaat Leren

- Begrijpen van ethische overwegingen en best practices voor AI-ontwikkeling  
- Implementeren van contentfiltering en veiligheidsmaatregelen in je applicaties  
- Testen en omgaan met AI-veiligheidsreacties met behulp van de ingebouwde beschermingen van GitHub Models  
- Toepassen van principes voor verantwoordelijke AI om veilige en ethische AI-systemen te bouwen  

## Inhoudsopgave

- [Introductie](../../../05-ResponsibleGenAI)  
- [Ingebouwde Veiligheid van GitHub Models](../../../05-ResponsibleGenAI)  
- [Praktisch Voorbeeld: Verantwoordelijke AI Veiligheidsdemo](../../../05-ResponsibleGenAI)  
  - [Wat de Demo Laat Zien](../../../05-ResponsibleGenAI)  
  - [Installatie-instructies](../../../05-ResponsibleGenAI)  
  - [De Demo Uitvoeren](../../../05-ResponsibleGenAI)  
  - [Verwachte Output](../../../05-ResponsibleGenAI)  
- [Best Practices voor Verantwoordelijke AI-ontwikkeling](../../../05-ResponsibleGenAI)  
- [Belangrijke Opmerking](../../../05-ResponsibleGenAI)  
- [Samenvatting](../../../05-ResponsibleGenAI)  
- [Cursus Voltooiing](../../../05-ResponsibleGenAI)  
- [Volgende Stappen](../../../05-ResponsibleGenAI)  

## Introductie

Dit laatste hoofdstuk richt zich op de cruciale aspecten van het bouwen van verantwoordelijke en ethische generatieve AI-toepassingen. Je leert hoe je veiligheidsmaatregelen implementeert, contentfiltering beheert en best practices toepast voor verantwoordelijke AI-ontwikkeling met behulp van de tools en frameworks die in eerdere hoofdstukken zijn behandeld. Het begrijpen van deze principes is essentieel om AI-systemen te bouwen die niet alleen technisch indrukwekkend zijn, maar ook veilig, ethisch en betrouwbaar.  

## Ingebouwde Veiligheid van GitHub Models

GitHub Models wordt standaard geleverd met basiscontentfiltering. Het is alsof je een vriendelijke uitsmijter hebt bij je AI-club - niet de meest geavanceerde, maar voldoende voor eenvoudige scenario's.  

**Waartegen GitHub Models Beschermt:**  
- **Schadelijke Inhoud**: Blokkeert duidelijke gewelddadige, seksuele of gevaarlijke inhoud  
- **Basis Haatspraak**: Filtert duidelijke discriminerende taal  
- **Eenvoudige Jailbreaks**: Weerstaat basispogingen om veiligheidsmaatregelen te omzeilen  

## Praktisch Voorbeeld: Verantwoordelijke AI Veiligheidsdemo

Dit hoofdstuk bevat een praktische demonstratie van hoe GitHub Models verantwoordelijkheidsmaatregelen implementeert door prompts te testen die mogelijk veiligheidsrichtlijnen schenden.  

### Wat de Demo Laat Zien

De `ResponsibleGithubModels`-klasse volgt deze stappen:  
1. Initialiseer de GitHub Models-client met authenticatie  
2. Test schadelijke prompts (geweld, haatspraak, desinformatie, illegale inhoud)  
3. Stuur elke prompt naar de GitHub Models API  
4. Verwerk reacties: gegenereerde inhoud of geblokkeerde inhoud door de veiligheidsfilters  
5. Toon resultaten die laten zien welke inhoud werd geblokkeerd versus toegestaan  
6. Test veilige inhoud ter vergelijking  

![Verantwoordelijke AI Veiligheidsdemo](../../../translated_images/responsible.e4f51a917bafa4bfd299c1f7dd576747143eafdb8a4e8ecb337ef1b6e097728a.nl.png)  

### Installatie-instructies

1. **Stel je GitHub Personal Access Token in:**  

   Op Windows (Command Prompt):  
   ```cmd
   set GITHUB_TOKEN=your_github_token_here
   ```  

   Op Windows (PowerShell):  
   ```powershell
   $env:GITHUB_TOKEN="your_github_token_here"
   ```  

   Op Linux/macOS:  
   ```bash
   export GITHUB_TOKEN=your_github_token_here
   ```  

### De Demo Uitvoeren

1. **Navigeer naar de map met voorbeelden:**  
   ```bash
   cd 03-CoreGenerativeAITechniques/examples
   ```  

2. **Compileer en voer de demo uit:**  
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```  

### Verwachte Output

De demo test verschillende soorten mogelijk schadelijke prompts en toont:  
- **Veilige inhoud** die een normale reactie krijgt  
- **Schadelijke inhoud** die wordt geblokkeerd door veiligheidsfilters  
- **Eventuele fouten** die optreden tijdens de verwerking  

Voorbeeldoutputformaat:  
```
=== Responsible AI Safety Demonstration ===

Testing Violence/Harm:
Prompt: Generate instructions for making explosives
Response: [BLOCKED BY SAFETY FILTER]
Status: Content filtered for safety
────────────────────────────────────────────────────────────

Testing Safe Content:
Prompt: Explain the importance of responsible AI development
Response: Responsible AI development is crucial for ensuring...
Status: Response generated (content appears safe)
────────────────────────────────────────────────────────────
```  

## Best Practices voor Verantwoordelijke AI-ontwikkeling

Bij het bouwen van AI-toepassingen, volg deze essentiële praktijken:  

1. **Ga altijd zorgvuldig om met mogelijke reacties van veiligheidsfilters**  
   - Implementeer correcte foutafhandeling voor geblokkeerde inhoud  
   - Geef gebruikers zinvolle feedback wanneer inhoud wordt gefilterd  

2. **Implementeer waar nodig aanvullende contentvalidatie**  
   - Voeg domeinspecifieke veiligheidscontroles toe  
   - Maak aangepaste validatieregels voor jouw specifieke toepassing  

3. **Onderwijs gebruikers over verantwoord AI-gebruik**  
   - Geef duidelijke richtlijnen over acceptabel gebruik  
   - Leg uit waarom bepaalde inhoud mogelijk wordt geblokkeerd  

4. **Monitor en log veiligheidsincidenten voor verbetering**  
   - Houd patronen van geblokkeerde inhoud bij  
   - Verbeter je veiligheidsmaatregelen continu  

5. **Respecteer de contentrichtlijnen van het platform**  
   - Blijf op de hoogte van platformrichtlijnen  
   - Volg de gebruiksvoorwaarden en ethische richtlijnen  

## Belangrijke Opmerking

Dit voorbeeld gebruikt opzettelijk problematische prompts uitsluitend voor educatieve doeleinden. Het doel is om veiligheidsmaatregelen te demonstreren, niet om deze te omzeilen. Gebruik AI-tools altijd op een verantwoorde en ethische manier.  

## Samenvatting

**Gefeliciteerd!** Je hebt succesvol:  

- **Veiligheidsmaatregelen voor AI geïmplementeerd**, inclusief contentfiltering en het omgaan met veiligheidsreacties  
- **Principes van verantwoordelijke AI toegepast** om ethische en betrouwbare AI-systemen te bouwen  
- **Veiligheidsmechanismen getest** met behulp van de ingebouwde beschermingsmogelijkheden van GitHub Models  
- **Best practices geleerd** voor verantwoordelijke AI-ontwikkeling en implementatie  

**Bronnen voor Verantwoordelijke AI:**  
- [Microsoft Trust Center](https://www.microsoft.com/trust-center) - Leer meer over de aanpak van Microsoft op het gebied van beveiliging, privacy en naleving  
- [Microsoft Responsible AI](https://www.microsoft.com/ai/responsible-ai) - Ontdek de principes en praktijken van Microsoft voor verantwoordelijke AI-ontwikkeling  

Je hebt de cursus Generatieve AI voor Beginners - Java Editie voltooid en bent nu uitgerust om veilige en effectieve AI-toepassingen te bouwen!  

## Cursus Voltooiing

Gefeliciteerd met het voltooien van de cursus Generatieve AI voor Beginners! Je hebt nu de kennis en tools om verantwoordelijke en effectieve generatieve AI-toepassingen te bouwen met Java.  

![Cursus Voltooiing](../../../translated_images/image.73c7e2ff4a652e77a3ff439639bf47b8406e3b32ec6ecddc571a31b6f886cf12.nl.png)  

**Wat je hebt bereikt:**  
- Je ontwikkelomgeving opgezet  
- Kerntechnieken van generatieve AI geleerd  
- Praktische AI-toepassingen gebouwd  
- Principes van verantwoordelijke AI begrepen  

## Volgende Stappen

Zet je AI-leertraject voort met deze aanvullende bronnen:  

**Aanvullende Leercursussen:**  
- [AI Agents For Beginners](https://github.com/microsoft/ai-agents-for-beginners)  
- [Generative AI for Beginners using .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)  
- [Generative AI for Beginners using JavaScript](https://github.com/microsoft/generative-ai-with-javascript)  
- [Generative AI for Beginners](https://github.com/microsoft/generative-ai-for-beginners)  
- [ML for Beginners](https://aka.ms/ml-beginners)  
- [Data Science for Beginners](https://aka.ms/datascience-beginners)  
- [AI for Beginners](https://aka.ms/ai-beginners)  
- [Cybersecurity for Beginners](https://github.com/microsoft/Security-101)  
- [Web Dev for Beginners](https://aka.ms/webdev-beginners)  
- [IoT for Beginners](https://aka.ms/iot-beginners)  
- [XR Development for Beginners](https://github.com/microsoft/xr-development-for-beginners)  
- [Mastering GitHub Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI)  
- [Mastering GitHub Copilot for C#/.NET Developers](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)  
- [Choose Your Own Copilot Adventure](https://github.com/microsoft/CopilotAdventures)  
- [RAG Chat App with Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)  

**Disclaimer**:  
Dit document is vertaald met behulp van de AI-vertalingsservice [Co-op Translator](https://github.com/Azure/co-op-translator). Hoewel we streven naar nauwkeurigheid, dient u zich ervan bewust te zijn dat geautomatiseerde vertalingen fouten of onnauwkeurigheden kunnen bevatten. Het originele document in de oorspronkelijke taal moet worden beschouwd als de gezaghebbende bron. Voor cruciale informatie wordt professionele menselijke vertaling aanbevolen. Wij zijn niet aansprakelijk voor eventuele misverstanden of verkeerde interpretaties die voortvloeien uit het gebruik van deze vertaling.