<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "fee0290b2606d36ac1eea26d6a0a453a",
  "translation_date": "2025-07-27T08:51:57+00:00",
  "source_file": "05-ResponsibleGenAI/README.md",
  "language_code": "no"
}
-->
# Ansvarlig Generativ AI

## Hva du vil lære

- Forstå etiske hensyn og beste praksis for AI-utvikling
- Implementere innholdsfiltrering og sikkerhetstiltak i applikasjonene dine
- Teste og håndtere AI-sikkerhetsresponser ved hjelp av GitHub Models' innebygde beskyttelser
- Anvende prinsipper for ansvarlig AI for å bygge sikre og etiske AI-systemer

## Innholdsfortegnelse

- [Introduksjon](../../../05-ResponsibleGenAI)
- [GitHub Models innebygd sikkerhet](../../../05-ResponsibleGenAI)
- [Praktisk eksempel: Ansvarlig AI-sikkerhetsdemo](../../../05-ResponsibleGenAI)
  - [Hva demoen viser](../../../05-ResponsibleGenAI)
  - [Oppsettsinstruksjoner](../../../05-ResponsibleGenAI)
  - [Kjøre demoen](../../../05-ResponsibleGenAI)
  - [Forventet output](../../../05-ResponsibleGenAI)
- [Beste praksis for ansvarlig AI-utvikling](../../../05-ResponsibleGenAI)
- [Viktig merknad](../../../05-ResponsibleGenAI)
- [Oppsummering](../../../05-ResponsibleGenAI)
- [Fullføring av kurset](../../../05-ResponsibleGenAI)
- [Neste steg](../../../05-ResponsibleGenAI)

## Introduksjon

Dette siste kapittelet fokuserer på de kritiske aspektene ved å bygge ansvarlige og etiske generative AI-applikasjoner. Du vil lære hvordan du implementerer sikkerhetstiltak, håndterer innholdsfiltrering og anvender beste praksis for ansvarlig AI-utvikling ved hjelp av verktøyene og rammeverkene som er dekket i tidligere kapitler. Å forstå disse prinsippene er avgjørende for å bygge AI-systemer som ikke bare er teknisk imponerende, men også sikre, etiske og pålitelige.

## GitHub Models innebygd sikkerhet

GitHub Models har grunnleggende innholdsfiltrering innebygd. Det er som å ha en vennlig dørvakt på AI-klubben din – ikke den mest sofistikerte, men den gjør jobben for grunnleggende scenarier.

**Hva GitHub Models beskytter mot:**
- **Skadelig innhold**: Blokkerer åpenbart voldelig, seksuelt eller farlig innhold
- **Grunnleggende hatprat**: Filtrerer tydelig diskriminerende språk
- **Enkle forsøk på å omgå sikkerhet**: Motstår grunnleggende forsøk på å bryte sikkerhetsbarrierer

## Praktisk eksempel: Ansvarlig AI-sikkerhetsdemo

Dette kapittelet inkluderer en praktisk demonstrasjon av hvordan GitHub Models implementerer ansvarlige AI-sikkerhetstiltak ved å teste forespørsler som potensielt kan bryte sikkerhetsretningslinjer.

### Hva demoen viser

`ResponsibleGithubModels`-klassen følger denne flyten:
1. Initialiser GitHub Models-klienten med autentisering
2. Test skadelige forespørsler (vold, hatprat, feilinformasjon, ulovlig innhold)
3. Send hver forespørsel til GitHub Models API
4. Håndter responser: enten generert innhold eller blokkeringer fra sikkerhetsfilteret
5. Vis resultater som viser hvilket innhold som ble blokkert vs. tillatt
6. Test trygt innhold for sammenligning

![Ansvarlig AI-sikkerhetsdemo](../../../translated_images/responsible.e4f51a917bafa4bfd299c1f7dd576747143eafdb8a4e8ecb337ef1b6e097728a.no.png)

### Oppsettsinstruksjoner

1. **Sett opp din GitHub Personal Access Token:**
   
   På Windows (Command Prompt):
   ```cmd
   set GITHUB_TOKEN=your_github_token_here
   ```
   
   På Windows (PowerShell):
   ```powershell
   $env:GITHUB_TOKEN="your_github_token_here"
   ```
   
   På Linux/macOS:
   ```bash
   export GITHUB_TOKEN=your_github_token_here
   ```   

### Kjøre demoen

1. **Naviger til eksempelkatalogen:**
   ```bash
   cd 03-CoreGenerativeAITechniques/examples
   ```

2. **Kompiler og kjør demoen:**
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```

### Forventet output

Demoen vil teste ulike typer potensielt skadelige forespørsler og vise:
- **Trygt innhold** som får en normal respons
- **Skadelig innhold** som blir blokkert av sikkerhetsfiltre
- **Eventuelle feil** som oppstår under prosesseringen

Eksempel på output-format:
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

## Beste praksis for ansvarlig AI-utvikling

Når du bygger AI-applikasjoner, følg disse essensielle praksisene:

1. **Håndter alltid potensielle responser fra sikkerhetsfiltre på en god måte**
   - Implementer riktig feilhåndtering for blokkert innhold
   - Gi meningsfull tilbakemelding til brukere når innhold blir filtrert

2. **Implementer egne tilleggskontroller for innhold der det er nødvendig**
   - Legg til sikkerhetssjekker som er spesifikke for ditt domene
   - Lag tilpassede valideringsregler for din brukstilfelle

3. **Utdann brukere om ansvarlig AI-bruk**
   - Gi klare retningslinjer for akseptabel bruk
   - Forklar hvorfor visst innhold kan bli blokkert

4. **Overvåk og loggfør sikkerhetshendelser for forbedring**
   - Spor mønstre for blokkert innhold
   - Forbedre sikkerhetstiltakene kontinuerlig

5. **Respekter plattformens innholdspolicyer**
   - Hold deg oppdatert med plattformens retningslinjer
   - Følg vilkår for bruk og etiske retningslinjer

## Viktig merknad

Dette eksemplet bruker med vilje problematiske forespørsler kun for utdanningsformål. Målet er å demonstrere sikkerhetstiltak, ikke å omgå dem. Bruk alltid AI-verktøy ansvarlig og etisk.

## Oppsummering

**Gratulerer!** Du har med suksess:

- **Implementert AI-sikkerhetstiltak** inkludert innholdsfiltrering og håndtering av sikkerhetsresponser
- **Anvendt prinsipper for ansvarlig AI** for å bygge etiske og pålitelige AI-systemer
- **Testet sikkerhetsmekanismer** ved hjelp av GitHub Models' innebygde beskyttelsesfunksjoner
- **Lært beste praksis** for ansvarlig AI-utvikling og distribusjon

**Ressurser for ansvarlig AI:**
- [Microsoft Trust Center](https://www.microsoft.com/trust-center) - Lær om Microsofts tilnærming til sikkerhet, personvern og samsvar
- [Microsoft Responsible AI](https://www.microsoft.com/ai/responsible-ai) - Utforsk Microsofts prinsipper og praksis for ansvarlig AI-utvikling

Du har fullført Generative AI for Beginners - Java Edition-kurset og er nå rustet til å bygge sikre og effektive AI-applikasjoner!

## Fullføring av kurset

Gratulerer med å ha fullført Generative AI for Beginners-kurset! Du har nå kunnskapen og verktøyene til å bygge ansvarlige og effektive generative AI-applikasjoner med Java.

![Fullføring av kurset](../../../translated_images/image.73c7e2ff4a652e77a3ff439639bf47b8406e3b32ec6ecddc571a31b6f886cf12.no.png)

**Hva du har oppnådd:**
- Satt opp ditt utviklingsmiljø
- Lært kjerneprinsipper for generativ AI
- Bygget praktiske AI-applikasjoner
- Forstått prinsipper for ansvarlig AI

## Neste steg

Fortsett din AI-læringsreise med disse ekstra ressursene:

**Ekstra læringskurs:**
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

**Ansvarsfraskrivelse**:  
Dette dokumentet er oversatt ved hjelp av AI-oversettelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selv om vi streber etter nøyaktighet, vær oppmerksom på at automatiserte oversettelser kan inneholde feil eller unøyaktigheter. Det originale dokumentet på sitt opprinnelige språk bør anses som den autoritative kilden. For kritisk informasjon anbefales profesjonell menneskelig oversettelse. Vi er ikke ansvarlige for misforståelser eller feiltolkninger som oppstår ved bruk av denne oversettelsen.