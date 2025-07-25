<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "5bd7a347d6ed1d706443f9129dd29dd9",
  "translation_date": "2025-07-25T09:55:09+00:00",
  "source_file": "04-PracticalSamples/mcp/calculator/README.md",
  "language_code": "tl"
}
-->
# Basic Calculator MCP Service

>**Note**: Ang kabanatang ito ay may kasamang [**Tutorial**](./TUTORIAL.md) na magtuturo sa iyo sa mga halimbawa.

Maligayang pagdating sa iyong unang hands-on na karanasan sa **Model Context Protocol (MCP)**! Sa mga nakaraang kabanata, natutunan mo ang mga pangunahing kaalaman ng generative AI at na-set up ang iyong development environment. Ngayon, oras na para gumawa ng isang praktikal na proyekto.

Ang serbisyong calculator na ito ay nagpapakita kung paano maaaring ligtas na makipag-ugnayan ang mga AI model sa mga panlabas na tool gamit ang MCP. Sa halip na umasa sa minsang hindi maaasahang kakayahan ng AI model sa matematika, ipapakita namin kung paano bumuo ng isang matibay na sistema kung saan maaaring tumawag ang AI sa mga espesyal na serbisyo para sa tumpak na kalkulasyon.

## Nilalaman ng Talakayan

- [Ano ang Matututunan Mo](../../../../../04-PracticalSamples/mcp/calculator)
- [Mga Kinakailangan](../../../../../04-PracticalSamples/mcp/calculator)
- [Mga Pangunahing Konsepto](../../../../../04-PracticalSamples/mcp/calculator)
- [Mabilisang Simula](../../../../../04-PracticalSamples/mcp/calculator)
- [Mga Available na Operasyon ng Calculator](../../../../../04-PracticalSamples/mcp/calculator)
- [Mga Test Client](../../../../../04-PracticalSamples/mcp/calculator)
  - [1. Direktang MCP Client (SDKClient)](../../../../../04-PracticalSamples/mcp/calculator)
  - [2. AI-Powered Client (LangChain4jClient)](../../../../../04-PracticalSamples/mcp/calculator)
- [MCP Inspector (Web UI)](../../../../../04-PracticalSamples/mcp/calculator)
  - [Mga Hakbang na Instruksyon](../../../../../04-PracticalSamples/mcp/calculator)

## Ano ang Matututunan Mo

Sa pamamagitan ng pagdaan sa halimbawang ito, mauunawaan mo:
- Paano gumawa ng mga serbisyong compatible sa MCP gamit ang Spring Boot
- Ang pagkakaiba ng direktang komunikasyon sa protocol at AI-powered na interaksyon
- Paano nagdedesisyon ang mga AI model kung kailan at paano gagamit ng mga panlabas na tool
- Mga pinakamahusay na kasanayan sa paggawa ng mga AI application na may kasamang tool

Perpekto para sa mga baguhan na natututo ng mga konsepto ng MCP at handang gumawa ng kanilang unang AI tool integration!

## Mga Kinakailangan

- Java 21+
- Maven 3.6+
- **GitHub Token**: Kinakailangan para sa AI-powered client. Kung hindi mo pa ito na-set up, tingnan ang [Kabanata 2: Pag-set up ng iyong development environment](../../../02-SetupDevEnvironment/README.md) para sa mga instruksyon.

## Mga Pangunahing Konsepto

**Model Context Protocol (MCP)** ay isang standardized na paraan para sa mga AI application na ligtas na kumonekta sa mga panlabas na tool. Isipin ito bilang isang "tulay" na nagpapahintulot sa mga AI model na gumamit ng mga panlabas na serbisyo tulad ng aming calculator. Sa halip na subukang gawin ng AI model ang matematika mismo (na maaaring hindi maaasahan), maaari nitong tawagan ang aming calculator service para makakuha ng tumpak na resulta. Tinitiyak ng MCP na ang komunikasyong ito ay nangyayari nang ligtas at pare-pareho.

**Server-Sent Events (SSE)** ay nagbibigay-daan sa real-time na komunikasyon sa pagitan ng server at mga client. Hindi tulad ng tradisyunal na HTTP requests kung saan magtatanong ka at maghihintay ng sagot, ang SSE ay nagpapahintulot sa server na patuloy na magpadala ng mga update sa client. Perpekto ito para sa mga AI application kung saan ang mga sagot ay maaaring i-stream o tumagal ng oras upang maproseso.

**AI Tools & Function Calling** ay nagbibigay-daan sa mga AI model na awtomatikong pumili at gumamit ng mga panlabas na function (tulad ng mga operasyon ng calculator) batay sa mga kahilingan ng user. Kapag tinanong mo "Ano ang 15 + 27?", nauunawaan ng AI model na gusto mo ng addition, awtomatikong tinatawag ang `add` tool gamit ang tamang mga parameter (15, 27), at ibinabalik ang resulta sa natural na wika. Ang AI ay kumikilos bilang isang matalinong tagapag-ugnay na alam kung kailan at paano gagamitin ang bawat tool.

## Mabilisang Simula

### 1. Pumunta sa direktoryo ng application ng calculator
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/mcp/calculator
```

### 2. I-build at Patakbuhin
```bash
mvn clean install -DskipTests
java -jar target/calculator-server-0.0.1-SNAPSHOT.jar
```

### 2. Subukan gamit ang mga Client
- **SDKClient**: Direktang interaksyon sa MCP protocol
- **LangChain4jClient**: AI-powered na natural language interaction (kinakailangan ang GitHub token)

## Mga Available na Operasyon ng Calculator

- `add(a, b)`, `subtract(a, b)`, `multiply(a, b)`, `divide(a, b)`
- `power(base, exponent)`, `squareRoot(number)`, `absolute(number)`
- `modulus(a, b)`, `help()`

## Mga Test Client

### 1. Direktang MCP Client (SDKClient)
Sinusubukan ang raw MCP protocol communication. Patakbuhin gamit ang:
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

### 2. AI-Powered Client (LangChain4jClient)
Nagpapakita ng natural language interaction gamit ang GitHub Models. Kinakailangan ang GitHub token (tingnan ang [Mga Kinakailangan](../../../../../04-PracticalSamples/mcp/calculator)).

**Patakbuhin:**
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

## MCP Inspector (Web UI)

Ang MCP Inspector ay nagbibigay ng visual na web interface para subukan ang iyong MCP service nang hindi nagsusulat ng code. Perpekto para sa mga baguhan upang maunawaan kung paano gumagana ang MCP!

### Mga Hakbang na Instruksyon:

1. **Simulan ang calculator server** (kung hindi pa tumatakbo):
   ```bash
   java -jar target/calculator-server-0.0.1-SNAPSHOT.jar
   ```

2. **I-install at patakbuhin ang MCP Inspector** sa bagong terminal:
   ```bash
   npx @modelcontextprotocol/inspector
   ```

3. **Buksan ang web interface**:
   - Hanapin ang mensahe tulad ng "Inspector running at http://localhost:6274"
   - Buksan ang URL na iyon sa iyong web browser

4. **Ikonekta sa iyong calculator service**:
   - Sa web interface, itakda ang transport type sa "SSE"
   - Itakda ang URL sa: `http://localhost:8080/sse`
   - I-click ang "Connect" button

5. **I-explore ang mga available na tool**:
   - I-click ang "List Tools" para makita ang lahat ng operasyon ng calculator
   - Makikita mo ang mga function tulad ng `add`, `subtract`, `multiply`, atbp.

6. **Subukan ang isang operasyon ng calculator**:
   - Piliin ang isang tool (hal., "add")
   - Ipasok ang mga parameter (hal., `a: 15`, `b: 27`)
   - I-click ang "Run Tool"
   - Tingnan ang resulta na ibinalik ng iyong MCP service!

Ang visual na approach na ito ay tumutulong sa iyo na maunawaan kung paano eksaktong gumagana ang komunikasyon ng MCP bago gumawa ng sarili mong mga client.

![npx inspector](../../../../../translated_images/tool.214c70103694335c4cfdc2d624373dfce4b0162f6aea089ac1da9051fb563b7f.tl.png)

---
**Reference:** [MCP Server Boot Starter Docs](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-server-boot-starter-docs.html)

**Paunawa**:  
Ang dokumentong ito ay isinalin gamit ang AI translation service na [Co-op Translator](https://github.com/Azure/co-op-translator). Bagama't sinisikap naming maging tumpak, pakitandaan na ang mga awtomatikong pagsasalin ay maaaring maglaman ng mga pagkakamali o hindi pagkakatugma. Ang orihinal na dokumento sa kanyang katutubong wika ang dapat ituring na opisyal na sanggunian. Para sa mahalagang impormasyon, inirerekomenda ang propesyonal na pagsasalin ng tao. Hindi kami mananagot sa anumang hindi pagkakaunawaan o maling interpretasyon na dulot ng paggamit ng pagsasaling ito.