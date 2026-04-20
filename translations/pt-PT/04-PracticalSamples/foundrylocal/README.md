# Foundry Local Spring Boot Tutorial

## Índice

- [Pré-requisitos](#pré-requisitos)
- [Visão Geral do Projeto](#visão-geral-do-projeto)
- [Compreender o Código](#compreender-o-código)
  - [1. Configuração da Aplicação (application.properties)](#1-configuração-da-aplicação-applicationproperties)
  - [2. Classe Principal da Aplicação (Application.java)](#2-classe-principal-da-aplicação-applicationjava)
  - [3. Camada de Serviço AI (FoundryLocalService.java)](#3-camada-de-serviço-ai-foundrylocalservicejava)
  - [4. Dependências do Projeto (pom.xml)](#4-dependências-do-projeto-pomxml)
- [Como Tudo Funciona em Conjunto](#como-tudo-funciona-em-conjunto)
- [Configurar o Foundry Local](#configurar-o-foundry-local)
- [Executar a Aplicação](#executar-a-aplicação)
- [Saída Esperada](#saída-esperada)
- [Próximos Passos](#próximos-passos)
- [Resolução de Problemas](#resolução-de-problemas)


## Pré-requisitos

Antes de começar este tutorial, certifique-se que tem:

- **Java 21 ou superior** instalado no seu sistema
- **Maven 3.6+** para construir o projeto
- **Foundry Local** instalado e a correr

### **Instalar o Foundry Local:**

> **Nota:** O Foundry Local CLI está disponível apenas para **Windows** e **macOS**. O Linux é suportado via os [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

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

1. **Application.java** - O ponto de entrada principal da aplicação Spring Boot
2. **FoundryLocalService.java** - Camada de serviço que gere a comunicação com a AI
3. **application.properties** - Configuração para a conexão com Foundry Local
4. **pom.xml** - Dependências do Maven e configuração do projeto

## Compreender o Código

### 1. Configuração da Aplicação (application.properties)

**Ficheiro:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**O que isto faz:**
- **base-url**: Especifica onde o Foundry Local está a correr, incluindo o caminho `/v1` para compatibilidade com a API OpenAI. A porta padrão é `5273`. Se a porta for diferente, confirme com `foundry service status`.
- **model** (opcional): Nome do modelo AI a usar para geração de texto. **Por omissão, a aplicação detecta automaticamente o modelo** ao consultar o endpoint `/v1/models` do Foundry Local na inicialização, portanto não é necessário configurar. Pode definir explicitamente para substituir a deteção automática se desejar.

**Conceito chave:** O Spring Boot carrega automaticamente estas propriedades e torna-as disponíveis para a aplicação através da anotação `@Value`.

### 2. Classe Principal da Aplicação (Application.java)

**Ficheiro:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Não é necessário servidor web
        app.run(args);
    }
```

**O que isto faz:**
- `@SpringBootApplication` ativa a configuração automática do Spring Boot
- `WebApplicationType.NONE` informa o Spring que esta é uma app de linha de comandos, não um servidor web
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

**O que isto faz:**
- `@Bean` cria um componente gerido pelo Spring
- `CommandLineRunner` executa código após o arranque do Spring Boot
- `foundryLocalService` é automaticamente injetado pelo Spring (injeção de dependência)
- Envia uma mensagem de teste para a AI e mostra a resposta

### 3. Camada de Serviço AI (FoundryLocalService.java)

**Ficheiro:** `src/main/java/com/example/FoundryLocalService.java`

#### Injeção de Configuração:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Auto-detectado se vazio
```

**O que isto faz:**
- `@Service` indica ao Spring que esta classe fornece lógica de negócio
- `@Value` injeta valores da configuração do `application.properties`
- O modelo tem por padrão valor vazio, o que ativa a **deteção automática** no Foundry Local na inicialização. Isto permite que a app funcione com qualquer modelo carregado no Foundry Local sem configuração manual.

#### Inicialização do Cliente:
```java
@PostConstruct
public void init() {
    // Detetar automaticamente o modelo do Foundry Local se não estiver configurado explicitamente
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // A URL base já inclui /v1 da configuração
            .apiKey("not-needed")            // O servidor local não precisa de uma chave API real
            .build();
}
```

**O que isto faz:**
- `@PostConstruct` executa este método após a criação do serviço pelo Spring
- Se nenhum modelo estiver configurado, consulta o endpoint `/v1/models` do Foundry Local e seleciona o primeiro modelo carregado
- Cria um cliente OpenAI que aponta para a sua instância local do Foundry Local
- A base URL de `application.properties` já inclui `/v1` para compatibilidade com a API OpenAI
- A chave API é definida como "not-needed" (não necessária) porque no desenvolvimento local a autenticação não é requerida

#### Método Chat:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Qual modelo de IA usar
                .addUserMessage(message)         // A tua pergunta/pedido
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

**O que isto faz:**
- **ChatCompletionCreateParams**: Configura o pedido à AI
  - `model`: Especifica qual modelo AI usar (deve corresponder ao ID exato do comando `foundry model list`)
  - `addUserMessage`: Adiciona a sua mensagem à conversa
  - `maxCompletionTokens`: Limita o tamanho da resposta (para poupar recursos)
  - `temperature`: Controla a aleatoriedade (0.0 = determinístico, 1.0 = criativo)
- **Chamada API**: Envia o pedido ao Foundry Local
- **Tratamento de Resposta**: Extrai a resposta textual da AI de forma segura
- **Tratamento de Erros**: Envolve exceções com mensagens amigáveis

### 4. Dependências do Projeto (pom.xml)

**Dependências chave:**

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

**O que estas fazem:**
- **spring-boot-starter**: Fornece funcionalidade base do Spring Boot
- **openai-java**: SDK oficial Java OpenAI para comunicação de API
- **jackson-databind**: Gere a serialização/deserialização JSON para chamadas API

## Como Tudo Funciona em Conjunto

Aqui está o fluxo completo quando executa a aplicação:

1. **Arranque**: Spring Boot inicia e lê o `application.properties`
2. **Criação do Serviço**: Spring cria `FoundryLocalService` e injeta as configurações
3. **Deteção do Modelo**: Se não estiver configurado um modelo, o serviço consulta o endpoint `/v1/models` do Foundry Local e usa automaticamente o primeiro modelo disponível
4. **Configuração do Cliente**: O `@PostConstruct` inicializa o cliente OpenAI para ligar ao Foundry Local
5. **Execução do Demo**: O `CommandLineRunner` executa após o arranque
6. **Chamada AI**: O demo chama `foundryLocalService.chat()` com uma mensagem de teste
7. **Pedido API**: O serviço constrói e envia um pedido compatível OpenAI para o Foundry Local
8. **Processamento da Resposta**: O serviço extrai e retorna a resposta da AI
9. **Exibição**: A aplicação imprime a resposta e termina

## Configurar o Foundry Local

1. **Instale o Foundry Local** usando as instruções na secção [Pré-requisitos](#pré-requisitos).

2. **Inicie o serviço** (se ainda não estiver a correr):
   ```bash
   foundry service start
   ```

3. **Verifique o estado do serviço** para confirmar que está a funcionar e anote a porta:
   ```bash
   foundry service status
   ```

4. **Descarregue e execute um modelo** (descarrega na primeira vez, fica em cache para execuções seguintes):
   ```bash
   foundry model run phi-4-mini
   ```
   Isto abre uma sessão de chat interativa. Pode sair com `Ctrl+C`. O modelo mantém-se carregado no serviço.

   > **Dica:** Execute `foundry model list` para ver todos os modelos disponíveis. Substitua `phi-4-mini` por qualquer alias do catálogo (ex., `qwen2.5-0.5b` para um modelo menor/mais rápido).

5. **Verifique se o modelo está carregado:**
   ```bash
   foundry service ps
   ```

6. **Atualize `application.properties`** se necessário:
   - O `base-url` padrão (`http://localhost:5273/v1`) corresponde à porta padrão do CLI. Atualize apenas se o `foundry service status` mostrar uma porta diferente.
   - O modelo é **auto-detectado** na inicialização — não necessita configuração.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Executar a Aplicação

### Passo 1: Certifique-se que um modelo está carregado no Foundry Local
```bash
foundry service ps
```
Se não existirem modelos listados, carregue um:
```bash
foundry model run phi-4-mini
```

### Passo 2: Construir e Executar a Aplicação
Numa janela de terminal separada:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Ou construir e executar como um JAR:
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
- Confirme que a porta no `application.properties` coincide com a mostrada por `foundry service status`
- Assegure que a URL termina em `/v1`: `http://localhost:5273/v1`

**"No model found" na inicialização**
- A aplicação faz deteção automática do modelo. Assegure que pelo menos um modelo está carregado: `foundry service ps`
- Se não existirem modelos carregados: `foundry model run phi-4-mini`
- Se sobrepôs o nome do modelo no `application.properties`, confirme que corresponde ao `foundry model list`

**Erros "400 Bad Request"**
- Verifique que a base URL inclui `/v1`: `http://localhost:5273/v1`
- Certifique-se que usa `maxCompletionTokens()` no código (não o obsoleto `maxTokens()`)

**Erros de compilação Maven**
- Confirme que tem Java 21 ou superior: `java -version`
- Limpe e reconstrua: `mvn clean compile`
- Verifique a ligação à internet para descarregamento das dependências

**Problemas de ligação ao serviço**
- Se vir `Request to local service failed`, execute: `foundry service restart`
- Veja os modelos carregados: `foundry service ps`
- Consulte os logs do serviço: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Aviso Legal**:
Este documento foi traduzido utilizando o serviço de tradução automática [Co-op Translator](https://github.com/Azure/co-op-translator). Embora nos esforcemos para garantir a precisão, tenha em atenção que traduções automáticas podem conter erros ou imprecisões. O documento original na sua língua nativa deve ser considerado a fonte autorizada. Para informações críticas, é recomendada a tradução profissional humana. Não nos responsabilizamos por quaisquer mal-entendidos ou interpretações erradas resultantes do uso desta tradução.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->