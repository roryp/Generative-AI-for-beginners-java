<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "5bd7a347d6ed1d706443f9129dd29dd9",
  "translation_date": "2025-07-25T09:21:12+00:00",
  "source_file": "04-PracticalSamples/mcp/calculator/README.md",
  "language_code": "pt"
}
-->
# Serviço MCP de Calculadora Básica

>**Nota**: Este capítulo inclui um [**Tutorial**](./TUTORIAL.md) que o orienta através dos exemplos.

Bem-vindo à sua primeira experiência prática com o **Model Context Protocol (MCP)**! Nos capítulos anteriores, aprendeu os fundamentos da IA generativa e configurou o seu ambiente de desenvolvimento. Agora é hora de construir algo prático.

Este serviço de calculadora demonstra como os modelos de IA podem interagir de forma segura com ferramentas externas usando MCP. Em vez de confiar nas capacidades matemáticas, por vezes pouco fiáveis, do modelo de IA, vamos mostrar como construir um sistema robusto onde a IA pode chamar serviços especializados para cálculos precisos.

## Índice

- [O Que Vai Aprender](../../../../../04-PracticalSamples/mcp/calculator)
- [Pré-requisitos](../../../../../04-PracticalSamples/mcp/calculator)
- [Conceitos-Chave](../../../../../04-PracticalSamples/mcp/calculator)
- [Início Rápido](../../../../../04-PracticalSamples/mcp/calculator)
- [Operações Disponíveis na Calculadora](../../../../../04-PracticalSamples/mcp/calculator)
- [Clientes de Teste](../../../../../04-PracticalSamples/mcp/calculator)
  - [1. Cliente MCP Direto (SDKClient)](../../../../../04-PracticalSamples/mcp/calculator)
  - [2. Cliente com IA (LangChain4jClient)](../../../../../04-PracticalSamples/mcp/calculator)
- [MCP Inspector (Interface Web)](../../../../../04-PracticalSamples/mcp/calculator)
  - [Instruções Passo-a-Passo](../../../../../04-PracticalSamples/mcp/calculator)

## O Que Vai Aprender

Ao trabalhar neste exemplo, irá compreender:
- Como criar serviços compatíveis com MCP usando Spring Boot
- A diferença entre comunicação direta via protocolo e interação mediada por IA
- Como os modelos de IA decidem quando e como usar ferramentas externas
- Melhores práticas para construir aplicações de IA habilitadas com ferramentas

Perfeito para iniciantes que estão a aprender os conceitos de MCP e prontos para construir a sua primeira integração de ferramentas com IA!

## Pré-requisitos

- Java 21+
- Maven 3.6+
- **Token do GitHub**: Necessário para o cliente com IA. Se ainda não configurou, veja [Capítulo 2: Configurar o ambiente de desenvolvimento](../../../02-SetupDevEnvironment/README.md) para instruções.

## Conceitos-Chave

**Model Context Protocol (MCP)** é uma forma padronizada para aplicações de IA se conectarem de forma segura a ferramentas externas. Pense nisso como uma "ponte" que permite aos modelos de IA usar serviços externos, como a nossa calculadora. Em vez de o modelo de IA tentar fazer cálculos por si próprio (o que pode ser pouco fiável), ele pode chamar o nosso serviço de calculadora para obter resultados precisos. MCP garante que esta comunicação ocorre de forma segura e consistente.

**Server-Sent Events (SSE)** permite comunicação em tempo real entre o servidor e os clientes. Ao contrário dos pedidos HTTP tradicionais, onde se faz uma solicitação e espera-se pela resposta, o SSE permite que o servidor envie atualizações contínuas ao cliente. Isto é ideal para aplicações de IA onde as respostas podem ser transmitidas ou demorar algum tempo a processar.

**Ferramentas de IA & Chamadas de Função** permitem que os modelos de IA escolham e utilizem automaticamente funções externas (como operações de calculadora) com base nos pedidos dos utilizadores. Quando pergunta "Quanto é 15 + 27?", o modelo de IA entende que quer uma soma, chama automaticamente a nossa ferramenta `add` com os parâmetros corretos (15, 27) e devolve o resultado em linguagem natural. A IA atua como um coordenador inteligente que sabe quando e como usar cada ferramenta.

## Início Rápido

### 1. Navegue até ao diretório da aplicação de calculadora
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/mcp/calculator
```

### 2. Compile e Execute
```bash
mvn clean install -DskipTests
java -jar target/calculator-server-0.0.1-SNAPSHOT.jar
```

### 3. Teste com Clientes
- **SDKClient**: Interação direta com o protocolo MCP
- **LangChain4jClient**: Interação em linguagem natural com IA (requer token do GitHub)

## Operações Disponíveis na Calculadora

- `add(a, b)`, `subtract(a, b)`, `multiply(a, b)`, `divide(a, b)`
- `power(base, exponent)`, `squareRoot(number)`, `absolute(number)`
- `modulus(a, b)`, `help()`

## Clientes de Teste

### 1. Cliente MCP Direto (SDKClient)
Testa a comunicação bruta do protocolo MCP. Execute com:
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

### 2. Cliente com IA (LangChain4jClient)
Demonstra interação em linguagem natural com modelos do GitHub. Requer token do GitHub (veja [Pré-requisitos](../../../../../04-PracticalSamples/mcp/calculator)).

**Execute:**
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

## MCP Inspector (Interface Web)

O MCP Inspector fornece uma interface web visual para testar o seu serviço MCP sem escrever código. Perfeito para iniciantes entenderem como o MCP funciona!

### Instruções Passo-a-Passo:

1. **Inicie o servidor da calculadora** (se ainda não estiver em execução):
   ```bash
   java -jar target/calculator-server-0.0.1-SNAPSHOT.jar
   ```

2. **Instale e execute o MCP Inspector** num novo terminal:
   ```bash
   npx @modelcontextprotocol/inspector
   ```

3. **Abra a interface web**:
   - Procure uma mensagem como "Inspector running at http://localhost:6274"
   - Abra esse URL no seu navegador

4. **Conecte-se ao serviço de calculadora**:
   - Na interface web, defina o tipo de transporte como "SSE"
   - Defina o URL como: `http://localhost:8080/sse`
   - Clique no botão "Connect"

5. **Explore as ferramentas disponíveis**:
   - Clique em "List Tools" para ver todas as operações da calculadora
   - Verá funções como `add`, `subtract`, `multiply`, etc.

6. **Teste uma operação da calculadora**:
   - Selecione uma ferramenta (por exemplo, "add")
   - Insira os parâmetros (por exemplo, `a: 15`, `b: 27`)
   - Clique em "Run Tool"
   - Veja o resultado devolvido pelo seu serviço MCP!

Esta abordagem visual ajuda a compreender exatamente como funciona a comunicação MCP antes de construir os seus próprios clientes.

![npx inspector](../../../../../translated_images/tool.214c70103694335c4cfdc2d624373dfce4b0162f6aea089ac1da9051fb563b7f.pt.png)

---
**Referência:** [Documentação do MCP Server Boot Starter](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-server-boot-starter-docs.html)

**Aviso Legal**:  
Este documento foi traduzido utilizando o serviço de tradução por IA [Co-op Translator](https://github.com/Azure/co-op-translator). Embora nos esforcemos para garantir a precisão, é importante notar que traduções automáticas podem conter erros ou imprecisões. O documento original na sua língua nativa deve ser considerado a fonte autoritária. Para informações críticas, recomenda-se a tradução profissional realizada por humanos. Não nos responsabilizamos por quaisquer mal-entendidos ou interpretações incorretas decorrentes do uso desta tradução.