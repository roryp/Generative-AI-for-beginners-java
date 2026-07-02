# Tutorial Local Foundry Spring Boot

## Índice

- [Pré-requisitos](#pré-requisitos)
- [Visão Geral do Projeto](#visão-geral-do-projeto)
- [Entendendo o Código](#entendendo-o-código)
  - [1. Configuração da Aplicação (application.properties)](#1-configuração-da-aplicação-applicationproperties)
  - [2. Classe Principal da Aplicação (Application.java)](#2-classe-principal-da-aplicação-applicationjava)
  - [3. Camada de Serviço de IA (FoundryLocalService.java)](#3-camada-de-serviço-de-ia-foundrylocalservicejava)
  - [4. Dependências do Projeto (pom.xml)](#4-dependências-do-projeto-pomxml)
- [Como Tudo Funciona Junto](#como-tudo-funciona-junto)
- [Configurando o Foundry Local](#configurando-o-foundry-local)
- [Executando a Aplicação](#executando-a-aplicação)
- [Saída Esperada](#saída-esperada)
- [Próximos Passos](#próximos-passos)
- [Resolução de Problemas](#resolução-de-problemas)


## Pré-requisitos

Antes de iniciar este tutorial, certifique-se de que você tem:

- **Java 21 ou superior** instalado no seu sistema
- **Maven 3.6+** para construir o projeto
- **Foundry Local** instalado e em execução

### **Instalar Foundry Local:**

> **Nota:** O CLI do Foundry Local está disponível apenas para **Windows** e **macOS**. Linux é suportado via os [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Verifique a instalação:
```bash
foundry --version
```

## Visão Geral do Projeto

Este projeto consiste em quatro componentes principais:

1. **Application.java** - Ponto de entrada principal da aplicação Spring Boot
2. **FoundryLocalService.java** - Camada de serviço que gerencia a comunicação com a IA
3. **application.properties** - Configuração para conexão com Foundry Local
4. **pom.xml** - Dependências do Maven e configuração do projeto

## Entendendo o Código

### 1. Configuração da Aplicação (application.properties)

**Arquivo:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**O que isso faz:**
- **base-url**: Especifica onde o Foundry Local está rodando, incluindo o caminho `/v1` para compatibilidade com a API OpenAI. A porta padrão é `5273`. Se a porta for diferente, verifique com `foundry service status`.
- **model** (opcional): Nomeia o modelo de IA a ser usado para geração de texto. **Por padrão, a aplicação detecta automaticamente o modelo** consultando o endpoint `/v1/models` do Foundry Local na inicialização, então não é necessário configurar isso. Você ainda pode definir explicitamente para substituir a detecção automática, se desejar.

**Conceito chave:** O Spring Boot carrega automaticamente essas propriedades e as disponibiliza para sua aplicação usando a anotação `@Value`.

### 2. Classe Principal da Aplicação (Application.java)

**Arquivo:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Nenhum servidor web necessário
        app.run(args);
    }
```

**O que isso faz:**
- `@SpringBootApplication` ativa a auto-configuração do Spring Boot
- `WebApplicationType.NONE` informa ao Spring que esta é uma aplicação linha de comando, não um servidor web
- O método main inicia a aplicação Spring

**O Demo Runner:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        System.out.println("Calling Foundry Local service...");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
        System.out.println("=========================");
    };
}
```

**O que isso faz:**
- `@Bean` cria um componente gerenciado pelo Spring
- `CommandLineRunner` executa código após o Spring Boot iniciar
- `foundryLocalService` é injetado automaticamente pelo Spring (injeção de dependência)
- Envia uma mensagem de teste para a IA e exibe a resposta

### 3. Camada de Serviço de IA (FoundryLocalService.java)

**Arquivo:** `src/main/java/com/example/FoundryLocalService.java`

#### Injeção de Configuração:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Auto-detectado se vazio
```

**O que isso faz:**
- `@Service` informa ao Spring que esta classe fornece lógica de negócio
- `@Value` injeta valores de configuração do application.properties
- O modelo tem valor padrão vazio, o que dispara a **detecção automática** a partir do Foundry Local na inicialização. Isso significa que o app funciona com qualquer modelo carregado no Foundry Local sem configuração manual.

#### Inicialização do Cliente:
```java
@PostConstruct
public void init() {
    // Detectar automaticamente o modelo a partir do Foundry Local se não estiver configurado explicitamente
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // A URL base já inclui /v1 da configuração
            .apiKey("not-needed")            // O servidor local não precisa de uma chave de API real
            .build();
}
```

**O que isso faz:**
- `@PostConstruct` executa este método após o Spring criar o serviço
- Se nenhum modelo estiver configurado, consulta o endpoint `/v1/models` do Foundry Local e escolhe o primeiro modelo carregado
- Cria um cliente OpenAI que aponta para a instância local do Foundry Local
- A base URL de `application.properties` já inclui `/v1` para compatibilidade com a API OpenAI
- A chave API é definida como "not-needed" pois o desenvolvimento local não requer autenticação

#### Método de Chat:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Qual modelo de IA usar
                .addUserMessage(message)         // Sua pergunta/pedido
                .maxCompletionTokens(150)        // Limitar o comprimento da resposta
                .temperature(0.7)                // Controlar a criatividade (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extrair a resposta da IA do resultado da API
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**O que isso faz:**
- **ChatCompletionCreateParams**: Configura a requisição para a IA
  - `model`: Especifica qual modelo de IA usar (deve corresponder ao ID exato do `foundry model list`)
  - `addUserMessage`: Adiciona sua mensagem à conversa
  - `maxCompletionTokens`: Limita o tamanho da resposta (economiza recursos)
  - `temperature`: Controla aleatoriedade (0.0 = determinístico, 1.0 = criativo)
- **Chamada API**: Envia a requisição para o Foundry Local
- **Manipulação de Resposta**: Extrai a resposta de texto da IA com segurança
- **Tratamento de Erros**: Envolve exceções com mensagens de erro úteis

### 4. Dependências do Projeto (pom.xml)

**Dependências Principais:**

```xml
<!-- Spring Boot - Application framework -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>${spring-boot.version}</version>
</dependency>

<!-- OpenAI Java SDK - For AI API calls -->
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>

<!-- Jackson - JSON processing -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.0</version>
</dependency>
```

**O que fazem:**
- **spring-boot-starter**: Fornece funcionalidades básicas do Spring Boot
- **openai-java**: SDK oficial da OpenAI para Java para comunicação com a API
- **jackson-databind**: Gerencia serialização/deserialização JSON para chamadas da API

## Como Tudo Funciona Junto

Aqui está o fluxo completo quando você executa a aplicação:

1. **Inicialização**: Spring Boot inicia e lê `application.properties`
2. **Criação do Serviço**: Spring cria `FoundryLocalService` e injeta os valores de configuração
3. **Detecção de Modelo**: Se nenhum modelo estiver configurado, o serviço consulta o endpoint `/v1/models` do Foundry Local e usa automaticamente o primeiro modelo disponível
4. **Configuração do Cliente**: `@PostConstruct` inicializa o cliente OpenAI para conectar ao Foundry Local
5. **Execução do Demo**: `CommandLineRunner` executa após a inicialização
6. **Chamada de IA**: O demo chama `foundryLocalService.chat()` com uma mensagem de teste
7. **Requisição API**: O serviço monta e envia a requisição compatível com OpenAI ao Foundry Local
8. **Processamento da Resposta**: O serviço extrai e retorna a resposta da IA
9. **Exibição**: A aplicação imprime a resposta e encerra

## Configurando o Foundry Local

1. **Instale o Foundry Local** usando as instruções na seção [Pré-requisitos](#pré-requisitos).

2. **Inicie o serviço** (se ainda não estiver em execução):
   ```bash
   foundry service start
   ```

3. **Verifique o status do serviço** para confirmar que está rodando e anote a porta:
   ```bash
   foundry service status
   ```

4. **Faça o download e execute um modelo** (o download ocorre na primeira execução, cache nas seguintes):
   ```bash
   foundry model run phi-4-mini
   ```
   Isso abre uma sessão de chat interativa. Você pode sair com `Ctrl+C`. O modelo permanece carregado no serviço.

   > **Dica:** Execute `foundry model list` para ver todos os modelos disponíveis. Substitua `phi-4-mini` por qualquer alias do catálogo (exemplo: `qwen2.5-0.5b` para um modelo menor/mais rápido).

5. **Verifique se o modelo está carregado:**
   ```bash
   foundry service ps
   ```

6. **Atualize `application.properties`** se necessário:
   - O `base-url` padrão (`http://localhost:5273/v1`) corresponde à porta padrão do CLI. Atualize somente se `foundry service status` mostrar uma porta diferente.
   - O modelo é **detectado automaticamente** na inicialização — não é necessário configurar.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Executando a Aplicação

### Passo 1: Certifique-se de que um modelo está carregado no Foundry Local
```bash
foundry service ps
```
Se não houver modelos listados, carregue um:
```bash
foundry model run phi-4-mini
```

### Passo 2: Construir e Executar a Aplicação
Em um terminal separado:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Ou construa e execute como um JAR:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Saída Esperada

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## Próximos Passos

Para mais exemplos, consulte [Capítulo 04: Exemplos práticos](../README.md)

## Resolução de Problemas

### Problemas Comuns

**"Connection refused" ou "Service unavailable"**
- Verifique o serviço: `foundry service status`
- Reinicie se necessário: `foundry service restart`
- Verifique se a porta em `application.properties` corresponde à mostrada em `foundry service status`
- Confirme que a URL termina com `/v1`: `http://localhost:5273/v1`

**"No model found" na inicialização**
- A aplicação detecta o modelo automaticamente. Garanta que pelo menos um modelo esteja carregado: `foundry service ps`
- Se nenhum modelo estiver carregado: `foundry model run phi-4-mini`
- Se você configurou o nome do modelo em `application.properties`, verifique se corresponde ao listado em `foundry model list`

**Erros "400 Bad Request"**
- Verifique se a base URL inclui `/v1`: `http://localhost:5273/v1`
- Assegure que está usando `maxCompletionTokens()` no seu código (não o obsoleto `maxTokens()`)

**Erros de compilação Maven**
- Certifique-se de usar Java 21 ou superior: `java -version`
- Limpe e reconstrua: `mvn clean compile`
- Verifique a conexão com a internet para download das dependências

**Problemas de conexão com o serviço**
- Se aparecer `Request to local service failed`, execute: `foundry service restart`
- Verifique os modelos carregados: `foundry service ps`
- Visualize logs do serviço: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Aviso Legal**:  
Este documento foi traduzido usando o serviço de tradução por IA [Co-op Translator](https://github.com/Azure/co-op-translator). Embora nos esforcemos para garantir a precisão, tenha em mente que traduções automatizadas podem conter erros ou imprecisões. O documento original em seu idioma nativo deve ser considerado a fonte autorizada. Para informações críticas, recomenda-se tradução profissional por humanos. Não nos responsabilizamos por quaisquer mal-entendidos ou interpretações equivocadas decorrentes do uso desta tradução.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->