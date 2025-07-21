<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "59454ab4ec36d89840df6fcfe7633cbd",
  "translation_date": "2025-07-21T16:06:32+00:00",
  "source_file": "03-CoreGenerativeAITechniques/TUTORIAL.md",
  "language_code": "pt"
}
-->
# Tutorial de Técnicas Fundamentais de IA Generativa

## Índice

- [Pré-requisitos](../../../03-CoreGenerativeAITechniques)
- [Introdução](../../../03-CoreGenerativeAITechniques)
  - [Passo 1: Definir a Variável de Ambiente](../../../03-CoreGenerativeAITechniques)
  - [Passo 2: Navegar para o Diretório de Exemplos](../../../03-CoreGenerativeAITechniques)
- [Tutorial 1: Compleções e Chat com LLM](../../../03-CoreGenerativeAITechniques)
- [Tutorial 2: Chamadas de Função](../../../03-CoreGenerativeAITechniques)
- [Tutorial 3: RAG (Geração Aumentada por Recuperação)](../../../03-CoreGenerativeAITechniques)
- [Tutorial 4: IA Responsável](../../../03-CoreGenerativeAITechniques)
- [Padrões Comuns nos Exemplos](../../../03-CoreGenerativeAITechniques)
- [Próximos Passos](../../../03-CoreGenerativeAITechniques)
- [Resolução de Problemas](../../../03-CoreGenerativeAITechniques)
  - [Problemas Comuns](../../../03-CoreGenerativeAITechniques)

## Visão Geral

Este tutorial oferece exemplos práticos de técnicas fundamentais de IA generativa utilizando Java e GitHub Models. Vai aprender a interagir com Modelos de Linguagem de Grande Escala (LLMs), implementar chamadas de função, usar geração aumentada por recuperação (RAG) e aplicar práticas de IA responsável.

## Pré-requisitos

Antes de começar, certifique-se de que tem:
- Java 21 ou superior instalado
- Maven para gestão de dependências
- Uma conta GitHub com um token de acesso pessoal (PAT)

## Introdução

### Passo 1: Definir a Variável de Ambiente

Primeiro, precisa definir o seu token do GitHub como uma variável de ambiente. Este token permite-lhe aceder aos GitHub Models gratuitamente.

**Windows (Command Prompt):**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Windows (PowerShell):**
```powershell
$env:GITHUB_TOKEN="your_github_token_here"
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

### Passo 2: Navegar para o Diretório de Exemplos

```bash
cd 03-CoreGenerativeAITechniques/examples/
```

## Tutorial 1: Compleções e Chat com LLM

**Ficheiro:** `src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

### O Que Este Exemplo Ensina

Este exemplo demonstra os mecanismos fundamentais de interação com Modelos de Linguagem de Grande Escala (LLM) através da API OpenAI, incluindo a inicialização do cliente com GitHub Models, padrões de estrutura de mensagens para prompts de sistema e utilizador, gestão do estado da conversa através da acumulação do histórico de mensagens e ajuste de parâmetros para controlar o comprimento das respostas e os níveis de criatividade.

### Conceitos-Chave do Código

#### 1. Configuração do Cliente
```java
// Create the AI client
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(new StaticTokenCredential(pat))
    .buildClient();
```

Isto cria uma ligação aos GitHub Models utilizando o seu token.

#### 2. Compleção Simples
```java
List<ChatRequestMessage> messages = List.of(
    // System message sets AI behavior
    new ChatRequestSystemMessage("You are a helpful Java expert."),
    // User message contains the actual question
    new ChatRequestUserMessage("Explain Java streams briefly.")
);

ChatCompletionsOptions options = new ChatCompletionsOptions(messages)
    .setModel("gpt-4o-mini")
    .setMaxTokens(200)      // Limit response length
    .setTemperature(0.7);   // Control creativity (0.0-1.0)
```

#### 3. Memória da Conversa
```java
// Add AI's response to maintain conversation history
messages.add(new ChatRequestAssistantMessage(aiResponse));
messages.add(new ChatRequestUserMessage("Follow-up question"));
```

A IA só se lembra de mensagens anteriores se as incluir em pedidos subsequentes.

### Executar o Exemplo
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
```

### O Que Acontece Quando o Executa

1. **Compleção Simples**: A IA responde a uma pergunta sobre Java com orientação do prompt do sistema.
2. **Chat de Múltiplas Interações**: A IA mantém o contexto ao longo de várias perguntas.
3. **Chat Interativo**: Pode ter uma conversa real com a IA.

## Tutorial 2: Chamadas de Função

**Ficheiro:** `src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

### O Que Este Exemplo Ensina

Chamadas de função permitem que modelos de IA solicitem a execução de ferramentas externas e APIs através de um protocolo estruturado, onde o modelo analisa pedidos em linguagem natural, determina as chamadas de função necessárias com parâmetros apropriados utilizando definições de JSON Schema e processa os resultados retornados para gerar respostas contextuais, enquanto a execução real das funções permanece sob controlo do programador para garantir segurança e fiabilidade.

### Conceitos-Chave do Código

#### 1. Definição de Função
```java
ChatCompletionsFunctionToolDefinitionFunction weatherFunction = 
    new ChatCompletionsFunctionToolDefinitionFunction("get_weather");
weatherFunction.setDescription("Get current weather information for a city");

// Define parameters using JSON Schema
weatherFunction.setParameters(BinaryData.fromString("""
    {
        "type": "object",
        "properties": {
            "city": {
                "type": "string",
                "description": "The city name"
            }
        },
        "required": ["city"]
    }
    """));
```

Isto informa a IA sobre quais funções estão disponíveis e como usá-las.

#### 2. Fluxo de Execução da Função
```java
// 1. AI requests a function call
if (choice.getFinishReason() == CompletionsFinishReason.TOOL_CALLS) {
    ChatCompletionsFunctionToolCall functionCall = ...;
    
    // 2. You execute the function
    String result = simulateWeatherFunction(functionCall.getFunction().getArguments());
    
    // 3. You give the result back to AI
    messages.add(new ChatRequestToolMessage(result, toolCall.getId()));
    
    // 4. AI provides final response with function result
    ChatCompletions finalResponse = client.getChatCompletions(MODEL, options);
}
```

#### 3. Implementação da Função
```java
private static String simulateWeatherFunction(String arguments) {
    // Parse arguments and call real weather API
    // For demo, we return mock data
    return """
        {
            "city": "Seattle",
            "temperature": "22",
            "condition": "partly cloudy"
        }
        """;
}
```

### Executar o Exemplo
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
```

### O Que Acontece Quando o Executa

1. **Função de Meteorologia**: A IA solicita dados meteorológicos para Seattle, você fornece, e a IA formata uma resposta.
2. **Função de Calculadora**: A IA solicita um cálculo (15% de 240), você calcula, e a IA explica o resultado.

## Tutorial 3: RAG (Geração Aumentada por Recuperação)

**Ficheiro:** `src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

### O Que Este Exemplo Ensina

A Geração Aumentada por Recuperação (RAG) combina recuperação de informações com geração de linguagem, injetando contexto de documentos externos em prompts de IA. Isto permite que os modelos forneçam respostas precisas com base em fontes de conhecimento específicas, em vez de dados de treino potencialmente desatualizados ou imprecisos, mantendo limites claros entre as perguntas do utilizador e as fontes de informação autorizadas através de engenharia estratégica de prompts.

### Conceitos-Chave do Código

#### 1. Carregamento de Documentos
```java
// Load your knowledge source
String doc = Files.readString(Paths.get("document.txt"));
```

#### 2. Injeção de Contexto
```java
List<ChatRequestMessage> messages = List.of(
    new ChatRequestSystemMessage(
        "Use only the CONTEXT to answer. If not in context, say you cannot find it."
    ),
    new ChatRequestUserMessage(
        "CONTEXT:\n\"\"\"\n" + doc + "\n\"\"\"\n\nQUESTION:\n" + question
    )
);
```

As aspas triplas ajudam a IA a distinguir entre contexto e pergunta.

#### 3. Gestão Segura de Respostas
```java
if (response != null && response.getChoices() != null && !response.getChoices().isEmpty()) {
    String answer = response.getChoices().get(0).getMessage().getContent();
    System.out.println("Assistant: " + answer);
} else {
    System.err.println("Error: No response received from the API.");
}
```

Valide sempre as respostas da API para evitar falhas.

### Executar o Exemplo
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
```

### O Que Acontece Quando o Executa

1. O programa carrega `document.txt` (contém informações sobre GitHub Models).
2. Faz uma pergunta sobre o documento.
3. A IA responde apenas com base no conteúdo do documento, não no seu conhecimento geral.

Experimente perguntar: "O que são os GitHub Models?" vs "Como está o tempo?"

## Tutorial 4: IA Responsável

**Ficheiro:** `src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

### O Que Este Exemplo Ensina

O exemplo de IA Responsável destaca a importância de implementar medidas de segurança em aplicações de IA. Demonstra filtros de segurança que detetam categorias de conteúdo prejudicial, incluindo discurso de ódio, assédio, automutilação, conteúdo sexual e violência, mostrando como aplicações de IA em produção devem lidar graciosamente com violações de políticas de conteúdo através de tratamento adequado de exceções, mecanismos de feedback ao utilizador e estratégias de resposta alternativa.

### Conceitos-Chave do Código

#### 1. Estrutura de Testes de Segurança
```java
private void testPromptSafety(String prompt, String category) {
    try {
        // Attempt to get AI response
        ChatCompletions response = client.getChatCompletions(modelId, options);
        System.out.println("Response generated (content appears safe)");
        
    } catch (HttpResponseException e) {
        if (e.getResponse().getStatusCode() == 400) {
            System.out.println("[BLOCKED BY SAFETY FILTER]");
            System.out.println("This is GOOD - safety system working!");
        }
    }
}
```

#### 2. Categorias de Segurança Testadas
- Instruções de violência/autoagressão
- Discurso de ódio
- Violações de privacidade
- Desinformação médica
- Atividades ilegais

### Executar o Exemplo
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
```

### O Que Acontece Quando o Executa

O programa testa vários prompts prejudiciais e mostra como o sistema de segurança da IA:
1. **Bloqueia pedidos perigosos** com erros HTTP 400.
2. **Permite conteúdo seguro** ser gerado normalmente.
3. **Protege os utilizadores** de saídas prejudiciais da IA.

## Padrões Comuns nos Exemplos

### Padrão de Autenticação
Todos os exemplos utilizam este padrão para autenticar com os GitHub Models:

```java
String pat = System.getenv("GITHUB_TOKEN");
TokenCredential credential = new StaticTokenCredential(pat);
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(credential)
    .buildClient();
```

### Padrão de Tratamento de Erros
```java
try {
    // AI operation
} catch (HttpResponseException e) {
    // Handle API errors (rate limits, safety filters)
} catch (Exception e) {
    // Handle general errors (network, parsing)
}
```

### Padrão de Estrutura de Mensagens
```java
List<ChatRequestMessage> messages = List.of(
    new ChatRequestSystemMessage("Set AI behavior"),
    new ChatRequestUserMessage("User's actual request")
);
```

## Próximos Passos

[Capítulo 04: Exemplos Práticos](../04-PracticalSamples/README.md)

## Resolução de Problemas

### Problemas Comuns

**"GITHUB_TOKEN not set"**
- Certifique-se de que definiu a variável de ambiente.
- Verifique se o seu token tem o escopo `models:read`.

**"No response from API"**
- Verifique a sua ligação à internet.
- Confirme se o seu token é válido.
- Verifique se atingiu os limites de taxa.

**Erros de compilação no Maven**
- Certifique-se de que tem Java 21 ou superior.
- Execute `mvn clean compile` para atualizar as dependências.

**Aviso Legal**:  
Este documento foi traduzido utilizando o serviço de tradução por IA [Co-op Translator](https://github.com/Azure/co-op-translator). Embora nos esforcemos pela precisão, esteja ciente de que traduções automáticas podem conter erros ou imprecisões. O documento original na sua língua nativa deve ser considerado a fonte autoritária. Para informações críticas, recomenda-se a tradução profissional realizada por humanos. Não nos responsabilizamos por quaisquer mal-entendidos ou interpretações incorretas decorrentes do uso desta tradução.