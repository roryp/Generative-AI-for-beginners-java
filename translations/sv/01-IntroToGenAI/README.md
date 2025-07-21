<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "6d8b4a0d774dc2a1e97c95859a6d6e4b",
  "translation_date": "2025-07-21T20:14:23+00:00",
  "source_file": "01-IntroToGenAI/README.md",
  "language_code": "sv"
}
-->
# Introduktion till Generativ AI - Java Edition

## Vad du kommer att lära dig

- **Grundläggande om generativ AI** inklusive LLM:er, promptdesign, tokens, inbäddningar och vektordatabaser  
- **Jämförelse av Java AI-utvecklingsverktyg** inklusive Azure OpenAI SDK, Spring AI och OpenAI Java SDK  
- **Upptäck Model Context Protocol** och dess roll i AI-agenters kommunikation  

## Innehållsförteckning

- [Introduktion](../../../01-IntroToGenAI)  
- [En snabb repetition av koncept inom generativ AI](../../../01-IntroToGenAI)  
- [Genomgång av promptdesign](../../../01-IntroToGenAI)  
- [Tokens, inbäddningar och agenter](../../../01-IntroToGenAI)  
- [AI-utvecklingsverktyg och bibliotek för Java](../../../01-IntroToGenAI)  
  - [OpenAI Java SDK](../../../01-IntroToGenAI)  
  - [Spring AI](../../../01-IntroToGenAI)  
  - [Azure OpenAI Java SDK](../../../01-IntroToGenAI)  
- [Sammanfattning](../../../01-IntroToGenAI)  
- [Nästa steg](../../../01-IntroToGenAI)  

## Introduktion

Välkommen till det första kapitlet i Generativ AI för nybörjare - Java Edition! Denna grundläggande lektion introducerar dig till kärnkoncepten inom generativ AI och hur du arbetar med dem i Java. Du kommer att lära dig om de viktigaste byggstenarna för AI-applikationer, inklusive Large Language Models (LLM:er), tokens, inbäddningar och AI-agenter. Vi kommer också att utforska de primära Java-verktygen som du kommer att använda under kursens gång.

### En snabb repetition av koncept inom generativ AI

Generativ AI är en typ av artificiell intelligens som skapar nytt innehåll, såsom text, bilder eller kod, baserat på mönster och relationer som den har lärt sig från data. Generativa AI-modeller kan generera mänskliga liknande svar, förstå kontext och ibland till och med skapa innehåll som verkar mänskligt.

När du utvecklar dina Java AI-applikationer kommer du att arbeta med **generativa AI-modeller** för att skapa innehåll. Några av de möjligheter som generativa AI-modeller erbjuder inkluderar:

- **Textgenerering**: Skapa mänsklig-liknande text för chattbotar, innehåll och textkomplettering.  
- **Bildgenerering och analys**: Skapa realistiska bilder, förbättra foton och identifiera objekt.  
- **Kodgenerering**: Skriva kodsnuttar eller skript.  

Det finns specifika typer av modeller som är optimerade för olika uppgifter. Till exempel kan både **Small Language Models (SLM:er)** och **Large Language Models (LLM:er)** hantera textgenerering, där LLM:er vanligtvis presterar bättre för komplexa uppgifter. För bildrelaterade uppgifter använder du specialiserade visionsmodeller eller multimodala modeller.

![Figur: Typer av generativa AI-modeller och användningsområden.](../../../translated_images/llms.225ca2b8a0d344738419defc5ae14bba2fd3388b94f09fd4e8be8ce2a720ae51.sv.png)

Naturligtvis är svaren från dessa modeller inte alltid perfekta. Du har förmodligen hört talas om att modeller "hallucinerar" eller genererar felaktig information på ett övertygande sätt. Men du kan hjälpa modellen att generera bättre svar genom att ge tydliga instruktioner och kontext. Det är här **promptdesign** kommer in.

#### Genomgång av promptdesign

Promptdesign är praktiken att utforma effektiva indata för att styra AI-modeller mot önskade resultat. Det innefattar:

- **Tydlighet**: Göra instruktionerna klara och otvetydiga.  
- **Kontext**: Tillhandahålla nödvändig bakgrundsinformation.  
- **Begränsningar**: Specificera eventuella begränsningar eller format.  

Några bästa praxis för promptdesign inkluderar promptutformning, tydliga instruktioner, uppdelning av uppgifter, one-shot och few-shot learning samt promptjustering. Att testa olika prompts är avgörande för att hitta vad som fungerar bäst för ditt specifika användningsfall.

När du utvecklar applikationer kommer du att arbeta med olika typer av prompts:  
- **Systemprompts**: Sätter grundreglerna och kontexten för modellens beteende.  
- **Användarprompts**: Indatadata från dina applikationsanvändare.  
- **Assistentsvar**: Modellens svar baserat på system- och användarprompts.  

> **Läs mer**: Läs mer om promptdesign i [Prompt Engineering-kapitlet i GenAI för nybörjare-kursen](https://github.com/microsoft/generative-ai-for-beginners/tree/main/04-prompt-engineering-fundamentals)

#### Tokens, inbäddningar och agenter

När du arbetar med generativa AI-modeller kommer du att stöta på termer som **tokens**, **inbäddningar**, **agenter** och **Model Context Protocol (MCP)**. Här är en detaljerad översikt av dessa koncept:

- **Tokens**: Tokens är den minsta enheten av text i en modell. De kan vara ord, tecken eller delord. Tokens används för att representera textdata i ett format som modellen kan förstå. Till exempel kan meningen "The quick brown fox jumped over the lazy dog" tokeniseras som ["The", " quick", " brown", " fox", " jumped", " over", " the", " lazy", " dog"] eller ["The", " qu", "ick", " br", "own", " fox", " jump", "ed", " over", " the", " la", "zy", " dog"] beroende på tokeniseringsstrategin.

![Figur: Exempel på hur generativa AI-modeller bryter ner ord i tokens](../../../01-IntroToGenAI/images/tokens.webp)

Tokenisering är processen att bryta ner text i dessa mindre enheter. Detta är avgörande eftersom modeller arbetar med tokens snarare än rå text. Antalet tokens i en prompt påverkar modellens svarslängd och kvalitet, eftersom modeller har tokenbegränsningar för sitt kontextfönster (t.ex. 128K tokens för GPT-4o:s totala kontext, inklusive både indata och utdata).

  I Java kan du använda bibliotek som OpenAI SDK för att hantera tokenisering automatiskt när du skickar förfrågningar till AI-modeller.

- **Inbäddningar**: Inbäddningar är vektorrepresentationer av tokens som fångar semantisk betydelse. De är numeriska representationer (vanligtvis matriser av flyttal) som gör det möjligt för modeller att förstå relationer mellan ord och generera kontextuellt relevanta svar. Liknande ord har liknande inbäddningar, vilket gör det möjligt för modellen att förstå koncept som synonymer och semantiska relationer.

![Figur: Inbäddningar](../../../translated_images/embedding.398e50802c0037f931c725fd0113747831ea7776434d2b3ba3eb2e7a1a20ab1f.sv.png)

  I Java kan du generera inbäddningar med hjälp av OpenAI SDK eller andra bibliotek som stöder inbäddningsgenerering. Dessa inbäddningar är viktiga för uppgifter som semantisk sökning, där du vill hitta liknande innehåll baserat på betydelse snarare än exakta textmatchningar.

- **Vektordatabaser**: Vektordatabaser är specialiserade lagringssystem optimerade för inbäddningar. De möjliggör effektiv likhetssökning och är avgörande för Retrieval-Augmented Generation (RAG)-mönster där du behöver hitta relevant information från stora dataset baserat på semantisk likhet snarare än exakta matchningar.

![Figur: Vektordatabasarkitektur som visar hur inbäddningar lagras och hämtas för likhetssökning.](../../../translated_images/vector.f12f114934e223dff971b01ca371e85a41a540f3af2ffdd49fb3acec6c6652f2.sv.png)

> **Notera**: I denna kurs kommer vi inte att täcka vektordatabaser, men de är värda att nämna eftersom de ofta används i verkliga applikationer.

- **Agenter & MCP**: AI-komponenter som självständigt interagerar med modeller, verktyg och externa system. Model Context Protocol (MCP) tillhandahåller ett standardiserat sätt för agenter att säkert få tillgång till externa datakällor och verktyg. Läs mer i vår [MCP för nybörjare](https://github.com/microsoft/mcp-for-beginners)-kurs.

I Java AI-applikationer kommer du att använda tokens för textbearbetning, inbäddningar för semantisk sökning och RAG, vektordatabaser för datahämtning och agenter med MCP för att bygga intelligenta, verktygsanvändande system.

![Figur: Hur en prompt blir ett svar—tokens, vektorer, valfri RAG-sökning, LLM-bearbetning och en MCP-agent i ett snabbt flöde.](../../../translated_images/flow.f4ef62c3052d12a88b1d216eb2cd0e2ea3293c806d0defa7921dd1786dcb8516.sv.png)

### AI-utvecklingsverktyg och bibliotek för Java

Java erbjuder utmärkta verktyg för AI-utveckling. Det finns tre huvudsakliga bibliotek som vi kommer att utforska under kursens gång - OpenAI Java SDK, Azure OpenAI SDK och Spring AI.

Här är en snabb referenstabell som visar vilket SDK som används i varje kapitels exempel:

| Kapitel | Exempel | SDK |
|---------|---------|-----|
| 02-SetupDevEnvironment | src/github-models/ | OpenAI Java SDK |
| 02-SetupDevEnvironment | src/basic-chat-azure/ | Spring AI Azure OpenAI |
| 03-CoreGenerativeAITechniques | examples/ | Azure OpenAI SDK |
| 04-PracticalSamples | petstory/ | OpenAI Java SDK |
| 04-PracticalSamples | foundrylocal/ | OpenAI Java SDK |
| 04-PracticalSamples | mcp/calculator/ | Spring AI MCP SDK + LangChain4j |

**SDK-dokumentationslänkar:**  
- [Azure OpenAI Java SDK](https://github.com/Azure/azure-sdk-for-java/tree/azure-ai-openai_1.0.0-beta.16/sdk/openai/azure-ai-openai)  
- [Spring AI](https://docs.spring.io/spring-ai/reference/)  
- [OpenAI Java SDK](https://github.com/openai/openai-java)  
- [LangChain4j](https://docs.langchain4j.dev/)  

#### OpenAI Java SDK

OpenAI SDK är det officiella Java-biblioteket för OpenAI API. Det erbjuder ett enkelt och konsekvent gränssnitt för att interagera med OpenAIs modeller, vilket gör det enkelt att integrera AI-funktioner i Java-applikationer. Kapitel 2:s GitHub Models-exempel, Kapitel 4:s Pet Story-applikation och Foundry Local-exempel demonstrerar OpenAI SDK-metoden.

#### Spring AI

Spring AI är ett omfattande ramverk som tillför AI-funktioner till Spring-applikationer och tillhandahåller ett konsekvent abstraktionslager över olika AI-leverantörer. Det integreras sömlöst med Spring-ekosystemet, vilket gör det till det idealiska valet för företags-Java-applikationer som behöver AI-funktioner.

Spring AIs styrka ligger i dess sömlösa integration med Spring-ekosystemet, vilket gör det enkelt att bygga produktionsklara AI-applikationer med bekanta Spring-mönster som beroendeinjektion, konfigurationshantering och testningsramverk. Du kommer att använda Spring AI i Kapitel 2 och 4 för att bygga applikationer som utnyttjar både OpenAI och Model Context Protocol (MCP) Spring AI-bibliotek.

##### Model Context Protocol (MCP)

[Model Context Protocol (MCP)](https://modelcontextprotocol.io/) är en framväxande standard som gör det möjligt för AI-applikationer att interagera säkert med externa datakällor och verktyg. MCP tillhandahåller ett standardiserat sätt för AI-modeller att få tillgång till kontextuell information och utföra åtgärder i dina applikationer.

I Kapitel 4 kommer du att bygga en enkel MCP-kalkylatorservice som demonstrerar grunderna i Model Context Protocol med Spring AI, och visar hur man skapar grundläggande verktygsintegrationer och tjänstearkitekturer.

#### Azure OpenAI Java SDK

Azure OpenAI-klientbiblioteket för Java är en anpassning av OpenAIs REST API:er som tillhandahåller ett idiomatiskt gränssnitt och integration med resten av Azure SDK-ekosystemet. I Kapitel 3 kommer du att bygga applikationer med Azure OpenAI SDK, inklusive chattapplikationer, funktionsanrop och RAG (Retrieval-Augmented Generation)-mönster.

> Notera: Azure OpenAI SDK ligger efter OpenAI Java SDK när det gäller funktioner, så för framtida projekt bör du överväga att använda OpenAI Java SDK.

## Sammanfattning

**Grattis!** Du har framgångsrikt:  

- **Lärt dig om grunderna i generativ AI** inklusive LLM:er, promptdesign, tokens, inbäddningar och vektordatabaser  
- **Jämfört Java AI-utvecklingsverktyg** inklusive Azure OpenAI SDK, Spring AI och OpenAI Java SDK  
- **Upptäckt Model Context Protocol** och dess roll i AI-agenters kommunikation  

## Nästa steg

[Kapitel 2: Ställa in utvecklingsmiljön](../02-SetupDevEnvironment/README.md)  

**Ansvarsfriskrivning**:  
Detta dokument har översatts med hjälp av AI-översättningstjänsten [Co-op Translator](https://github.com/Azure/co-op-translator). Även om vi strävar efter noggrannhet, bör det noteras att automatiserade översättningar kan innehålla fel eller felaktigheter. Det ursprungliga dokumentet på dess originalspråk bör betraktas som den auktoritativa källan. För kritisk information rekommenderas professionell mänsklig översättning. Vi tar inget ansvar för eventuella missförstånd eller feltolkningar som uppstår vid användning av denna översättning.