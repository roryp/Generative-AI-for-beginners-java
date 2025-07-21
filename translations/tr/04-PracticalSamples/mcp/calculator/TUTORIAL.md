<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "8c6c7e9008b114540677f7a65aa9ddad",
  "translation_date": "2025-07-21T18:30:03+00:00",
  "source_file": "04-PracticalSamples/mcp/calculator/TUTORIAL.md",
  "language_code": "tr"
}
-->
# MCP Hesap Makinesi Eğitimi Başlangıç Seviyesi

## İçindekiler

- [Neler Öğreneceksiniz](../../../../../04-PracticalSamples/mcp/calculator)
- [Ön Gereksinimler](../../../../../04-PracticalSamples/mcp/calculator)
- [Proje Yapısını Anlamak](../../../../../04-PracticalSamples/mcp/calculator)
- [Temel Bileşenlerin Açıklaması](../../../../../04-PracticalSamples/mcp/calculator)
  - [1. Ana Uygulama](../../../../../04-PracticalSamples/mcp/calculator)
  - [2. Hesap Makinesi Servisi](../../../../../04-PracticalSamples/mcp/calculator)
  - [3. Doğrudan MCP İstemcisi](../../../../../04-PracticalSamples/mcp/calculator)
  - [4. Yapay Zeka Destekli İstemci](../../../../../04-PracticalSamples/mcp/calculator)
- [Örneklerin Çalıştırılması](../../../../../04-PracticalSamples/mcp/calculator)
- [Tüm Bileşenlerin Birlikte Çalışması](../../../../../04-PracticalSamples/mcp/calculator)
- [Sonraki Adımlar](../../../../../04-PracticalSamples/mcp/calculator)

## Neler Öğreneceksiniz

Bu eğitim, Model Context Protocol (MCP) kullanarak bir hesap makinesi servisi oluşturmayı açıklar. Şunları öğreneceksiniz:

- Yapay zekanın bir araç olarak kullanabileceği bir servis nasıl oluşturulur
- MCP servisleriyle doğrudan iletişim nasıl kurulur
- Yapay zeka modellerinin hangi araçları kullanacağını otomatik olarak nasıl seçtiği
- Doğrudan protokol çağrıları ile yapay zeka destekli etkileşimler arasındaki fark

## Ön Gereksinimler

Başlamadan önce aşağıdakilere sahip olduğunuzdan emin olun:
- Java 21 veya daha üstü yüklü
- Bağımlılık yönetimi için Maven
- Kişisel erişim jetonuna (PAT) sahip bir GitHub hesabı
- Java ve Spring Boot hakkında temel bilgi

## Proje Yapısını Anlamak

Hesap makinesi projesi birkaç önemli dosyadan oluşur:

```
calculator/
├── src/main/java/com/microsoft/mcp/sample/server/
│   ├── McpServerApplication.java          # Main Spring Boot app
│   └── service/CalculatorService.java     # Calculator operations
└── src/test/java/com/microsoft/mcp/sample/client/
    ├── SDKClient.java                     # Direct MCP communication
    ├── LangChain4jClient.java            # AI-powered client
    └── Bot.java                          # Simple chat interface
```

## Temel Bileşenlerin Açıklaması

### 1. Ana Uygulama

**Dosya:** `McpServerApplication.java`

Bu, hesap makinesi servisimizin giriş noktasıdır. Standart bir Spring Boot uygulamasıdır ve şu özel eklemeye sahiptir:

```java
@SpringBootApplication
public class McpServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpServerApplication.class, args);
    }
    
    @Bean
    public ToolCallbackProvider calculatorTools(CalculatorService calculator) {
        return MethodToolCallbackProvider.builder().toolObjects(calculator).build();
    }
}
```

**Bu ne yapar:**
- 8080 portunda bir Spring Boot web sunucusu başlatır
- Hesap makinesi yöntemlerimizi MCP araçları olarak kullanılabilir hale getiren bir `ToolCallbackProvider` oluşturur
- `@Bean` anotasyonu, Spring'in bunu diğer bileşenlerin kullanabileceği bir bileşen olarak yönetmesini sağlar

### 2. Hesap Makinesi Servisi

**Dosya:** `CalculatorService.java`

Tüm matematik işlemleri burada gerçekleşir. Her yöntem, MCP tarafından erişilebilir olması için `@Tool` ile işaretlenmiştir:

```java
@Service
public class CalculatorService {

    @Tool(description = "Add two numbers together")
    public String add(double a, double b) {
        double result = a + b;
        return formatResult(a, "+", b, result);
    }

    @Tool(description = "Subtract the second number from the first number")
    public String subtract(double a, double b) {
        double result = a - b;
        return formatResult(a, "-", b, result);
    }
    
    // More calculator operations...
    
    private String formatResult(double a, String operator, double b, double result) {
        return String.format("%.2f %s %.2f = %.2f", a, operator, b, result);
    }
}
```

**Ana özellikler:**

1. **`@Tool` Anotasyonu**: MCP'ye bu yöntemin harici istemciler tarafından çağrılabileceğini söyler
2. **Açık Açıklamalar**: Her araç, yapay zeka modellerinin ne zaman kullanacağını anlamasına yardımcı olan bir açıklamaya sahiptir
3. **Tutarlı Dönüş Formatı**: Tüm işlemler "5.00 + 3.00 = 8.00" gibi insan tarafından okunabilir metinler döner
4. **Hata Yönetimi**: Sıfıra bölme ve negatif karekökler hata mesajları döner

**Mevcut İşlemler:**
- `add(a, b)` - İki sayıyı toplar
- `subtract(a, b)` - İkinciyi birinciden çıkarır
- `multiply(a, b)` - İki sayıyı çarpar
- `divide(a, b)` - Birinciyi ikinciye böler (sıfır kontrolü ile)
- `power(base, exponent)` - Tabanı üsse yükseltir
- `squareRoot(number)` - Karekök hesaplar (negatif kontrolü ile)
- `modulus(a, b)` - Bölümün kalanını döner
- `absolute(number)` - Mutlak değeri döner
- `help()` - Tüm işlemler hakkında bilgi döner

### 3. Doğrudan MCP İstemcisi

**Dosya:** `SDKClient.java`

Bu istemci, yapay zeka kullanmadan MCP sunucusuyla doğrudan iletişim kurar. Belirli hesap makinesi işlevlerini manuel olarak çağırır:

```java
public class SDKClient {
    
    public static void main(String[] args) {
        var transport = new WebFluxSseClientTransport(
            WebClient.builder().baseUrl("http://localhost:8080")
        );
        new SDKClient(transport).run();
    }
    
    public void run() {
        var client = McpClient.sync(this.transport).build();
        client.initialize();
        
        // List available tools
        ListToolsResult toolsList = client.listTools();
        System.out.println("Available Tools = " + toolsList);
        
        // Call specific calculator functions
        CallToolResult resultAdd = client.callTool(
            new CallToolRequest("add", Map.of("a", 5.0, "b", 3.0))
        );
        System.out.println("Add Result = " + resultAdd);
        
        CallToolResult resultSqrt = client.callTool(
            new CallToolRequest("squareRoot", Map.of("number", 16.0))
        );
        System.out.println("Square Root Result = " + resultSqrt);
        
        client.closeGracefully();
    }
}
```

**Bu ne yapar:**
1. **Bağlanır**: `http://localhost:8080` adresindeki hesap makinesi sunucusuna
2. **Listeleme yapar**: Tüm mevcut araçları (hesap makinesi işlevlerimizi) listeler
3. **Çağırır**: Belirli işlevleri tam parametrelerle
4. **Sonuçları yazdırır**

**Ne zaman kullanılır:** Hangi hesaplamayı yapmak istediğinizi tam olarak bildiğinizde ve bunu programlı olarak çağırmak istediğinizde.

### 4. Yapay Zeka Destekli İstemci

**Dosya:** `LangChain4jClient.java`

Bu istemci, hangi hesap makinesi araçlarını kullanacağını otomatik olarak belirleyebilen bir yapay zeka modeli (GPT-4o-mini) kullanır:

```java
public class LangChain4jClient {
    
    public static void main(String[] args) throws Exception {
        // Set up the AI model (using GitHub Models)
        ChatLanguageModel model = OpenAiOfficialChatModel.builder()
                .isGitHubModels(true)
                .apiKey(System.getenv("GITHUB_TOKEN"))
                .modelName("gpt-4o-mini")
                .build();

        // Connect to our calculator MCP server
        McpTransport transport = new HttpMcpTransport.Builder()
                .sseUrl("http://localhost:8080/sse")
                .logRequests(true)  // Shows what the AI is doing
                .logResponses(true)
                .build();

        McpClient mcpClient = new DefaultMcpClient.Builder()
                .transport(transport)
                .build();

        // Give the AI access to our calculator tools
        ToolProvider toolProvider = McpToolProvider.builder()
                .mcpClients(List.of(mcpClient))
                .build();

        // Create an AI bot that can use our calculator
        Bot bot = AiServices.builder(Bot.class)
                .chatLanguageModel(model)
                .toolProvider(toolProvider)
                .build();

        // Now we can ask the AI to do calculations in natural language
        String response = bot.chat("Calculate the sum of 24.5 and 17.3 using the calculator service");
        System.out.println(response);

        response = bot.chat("What's the square root of 144?");
        System.out.println(response);
    }
}
```

**Bu ne yapar:**
1. **Bir yapay zeka modeli bağlantısı oluşturur**: GitHub jetonunuzu kullanarak
2. **Yapay zekayı** hesap makinesi MCP sunucumuza bağlar
3. **Yapay zekaya** tüm hesap makinesi araçlarımıza erişim sağlar
4. **Doğal dilde** talepleri işler, örneğin "24.5 ve 17.3'ün toplamını hesapla"

**Yapay zeka otomatik olarak:**
- Sayıları toplamak istediğinizi anlar
- `add` aracını seçer
- `add(24.5, 17.3)` çağrısını yapar
- Sonucu doğal bir yanıtla döner

## Örneklerin Çalıştırılması

### Adım 1: Hesap Makinesi Sunucusunu Başlatın

Öncelikle GitHub jetonunuzu ayarlayın (yapay zeka istemcisi için gereklidir):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

Sunucuyu başlatın:
```bash
cd 04-PracticalSamples/mcp/calculator
mvn spring-boot:run
```

Sunucu `http://localhost:8080` adresinde başlayacaktır. Şunu görmelisiniz:
```
Started McpServerApplication in X.XXX seconds
```

### Adım 2: Doğrudan İstemci ile Test

Yeni bir terminalde:
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"
```

Şuna benzer bir çıktı göreceksiniz:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### Adım 3: Yapay Zeka İstemcisi ile Test

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"
```

Yapay zekanın araçları otomatik olarak kullandığını göreceksiniz:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

## Tüm Bileşenlerin Birlikte Çalışması

"5 + 3 nedir?" diye sorduğunuzda tüm akış şu şekilde işler:

1. **Siz**, yapay zekaya doğal dilde bir soru sorarsınız
2. **Yapay zeka**, isteğinizi analiz eder ve toplama yapmak istediğinizi anlar
3. **Yapay zeka**, MCP sunucusuna şu çağrıyı yapar: `add(5.0, 3.0)`
4. **Hesap Makinesi Servisi**, şu işlemi yapar: `5.0 + 3.0 = 8.0`
5. **Hesap Makinesi Servisi**, şu sonucu döner: `"5.00 + 3.00 = 8.00"`
6. **Yapay zeka**, sonucu alır ve doğal bir yanıt olarak biçimlendirir
7. **Siz**, şu yanıtı alırsınız: "5 ve 3'ün toplamı 8'dir"

## Sonraki Adımlar

Daha fazla örnek için [Bölüm 04: Pratik örnekler](../../README.md) bölümüne bakın.

**Feragatname**:  
Bu belge, AI çeviri hizmeti [Co-op Translator](https://github.com/Azure/co-op-translator) kullanılarak çevrilmiştir. Doğruluk için çaba göstersek de, otomatik çevirilerin hata veya yanlışlık içerebileceğini lütfen unutmayın. Belgenin orijinal dili, yetkili kaynak olarak kabul edilmelidir. Kritik bilgiler için profesyonel insan çevirisi önerilir. Bu çevirinin kullanımından kaynaklanan yanlış anlamalar veya yanlış yorumlamalar için sorumluluk kabul etmiyoruz.