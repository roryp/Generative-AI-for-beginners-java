<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T16:35:24+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "pt"
}
-->
# Aplicação Local de Linha de Comando Foundry

>**Nota**: Este capítulo inclui um [**Tutorial**](./TUTORIAL.md) que orienta sobre como executar os exemplos concluídos.

Uma aplicação simples em Spring Boot de linha de comando que demonstra como conectar ao Foundry Local utilizando o OpenAI Java SDK.

## O Que Vai Aprender

- Como integrar o Foundry Local com aplicações Spring Boot utilizando o OpenAI Java SDK
- Melhores práticas para desenvolvimento e testes de IA local

## Índice

- [O Que Vai Aprender](../../../../04-PracticalSamples/foundrylocal)
- [Pré-requisitos](../../../../04-PracticalSamples/foundrylocal)
  - [Instalar o Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Verificação](../../../../04-PracticalSamples/foundrylocal)
- [Configuração](../../../../04-PracticalSamples/foundrylocal)
- [Início Rápido](../../../../04-PracticalSamples/foundrylocal)
- [O Que a Aplicação Faz](../../../../04-PracticalSamples/foundrylocal)
- [Exemplo de Saída](../../../../04-PracticalSamples/foundrylocal)
- [Arquitetura](../../../../04-PracticalSamples/foundrylocal)
- [Destaques do Código](../../../../04-PracticalSamples/foundrylocal)
  - [Integração com OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [API de Conclusão de Chat](../../../../04-PracticalSamples/foundrylocal)
- [Resolução de Problemas](../../../../04-PracticalSamples/foundrylocal)

## Pré-requisitos

> **⚠️ Nota**: Esta aplicação **não funciona no devcontainer fornecido** porque requer que o Foundry Local esteja instalado e em execução no sistema anfitrião.

### Instalar o Foundry Local

Antes de executar esta aplicação, é necessário instalar e iniciar o Foundry Local. Siga estes passos:

1. **Certifique-se de que o seu sistema atende aos requisitos**:
   - **Sistema Operativo**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 ou macOS
   - **Hardware**: 
     - Mínimo: 8GB de RAM, 3GB de espaço livre em disco
     - Recomendado: 16GB de RAM, 15GB de espaço livre em disco
   - **Rede**: Conexão à internet para o download inicial do modelo (opcional para uso offline)
   - **Aceleração (opcional)**: GPU NVIDIA (série 2.000 ou mais recente), GPU AMD (série 6.000 ou mais recente), Qualcomm Snapdragon X Elite (8GB ou mais de memória) ou Apple silicon
   - **Permissões**: Privilégios administrativos para instalar software no dispositivo

2. **Instale o Foundry Local**:
   
   **Para Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **Para macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Alternativamente, pode descarregar o instalador do [repositório GitHub do Foundry Local](https://github.com/microsoft/Foundry-Local).

3. **Inicie o seu primeiro modelo**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   O modelo será descarregado (o que pode levar alguns minutos, dependendo da velocidade da internet) e, em seguida, será executado. O Foundry Local seleciona automaticamente a melhor variante do modelo para o seu sistema (CUDA para GPUs NVIDIA, versão para CPU caso contrário).

4. **Teste o modelo** fazendo uma pergunta no mesmo terminal:

   ```bash
   Why is the sky blue?
   ```

   Deve ver uma resposta do modelo Phi explicando por que o céu parece azul.

### Verificação

Pode verificar se tudo está a funcionar corretamente com estes comandos:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Também pode visitar `http://localhost:5273` no seu navegador para ver a interface web do Foundry Local.

## Configuração

A aplicação pode ser configurada através de `application.properties`:

- `foundry.local.base-url` - URL base para o Foundry Local (padrão: http://localhost:5273)
- `foundry.local.model` - Modelo de IA a utilizar (padrão: Phi-3.5-mini-instruct-cuda-gpu)

> **Nota**: O nome do modelo na configuração deve corresponder à variante específica que o Foundry Local descarregou para o seu sistema. Quando executa `foundry model run phi-3.5-mini`, o Foundry Local seleciona e descarrega automaticamente a melhor variante (CUDA para GPUs NVIDIA, versão para CPU caso contrário). Utilize `foundry model list` para ver o nome exato do modelo disponível na sua instância local.

## Início Rápido

### 1. Navegue até ao diretório da aplicação Foundry Local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Execute a Aplicação

```bash
mvn spring-boot:run
```

Ou construa e execute o JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Dependências

Esta aplicação utiliza o OpenAI Java SDK para comunicar com o Foundry Local. A dependência principal é:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

A aplicação está pré-configurada para se conectar ao Foundry Local em execução na porta padrão.

## O Que a Aplicação Faz

Quando executa a aplicação:

1. **Inicia** como uma aplicação de linha de comando (sem servidor web)
2. **Envia automaticamente** uma mensagem de teste: "Olá! Pode dizer-me o que é e qual o modelo que está a executar?"
3. **Exibe a resposta** do Foundry Local no console
4. **Termina de forma limpa** após o demo

## Exemplo de Saída

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Arquitetura

- **Application.java** - Aplicação principal em Spring Boot com CommandLineRunner
- **FoundryLocalService.java** - Serviço que utiliza o OpenAI Java SDK para comunicar com o Foundry Local
- Utiliza **OpenAI Java SDK** para chamadas de API com segurança de tipos
- Serialização/deserialização automática de JSON gerida pelo SDK
- Configuração limpa utilizando as anotações `@Value` e `@PostConstruct` do Spring

## Destaques do Código

### Integração com OpenAI Java SDK

A aplicação utiliza o OpenAI Java SDK para criar um cliente configurado para o Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### API de Conclusão de Chat

Fazer pedidos de conclusão de chat é simples e seguro em termos de tipos:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Resolução de Problemas

Se encontrar erros de conexão:
1. Verifique se o Foundry Local está em execução em `http://localhost:5273`
2. Confirme que uma variante do modelo Phi-3.5-mini está disponível com `foundry model list`
3. Certifique-se de que o nome do modelo em `application.properties` corresponde exatamente ao nome do modelo mostrado na lista
4. Certifique-se de que nenhum firewall está a bloquear a conexão

Problemas comuns:
- **Modelo não encontrado**: Execute `foundry model run phi-3.5-mini` para descarregar e iniciar o modelo
- **Serviço não está em execução**: O serviço Foundry Local pode ter parado; reinicie-o com o comando de execução do modelo
- **Nome do modelo incorreto**: Utilize `foundry model list` para ver os modelos disponíveis e atualize a sua configuração conforme necessário

**Aviso Legal**:  
Este documento foi traduzido utilizando o serviço de tradução por IA [Co-op Translator](https://github.com/Azure/co-op-translator). Embora nos esforcemos para garantir a precisão, é importante notar que traduções automáticas podem conter erros ou imprecisões. O documento original na sua língua nativa deve ser considerado a fonte autoritária. Para informações críticas, recomenda-se a tradução profissional realizada por humanos. Não nos responsabilizamos por quaisquer mal-entendidos ou interpretações incorretas decorrentes do uso desta tradução.