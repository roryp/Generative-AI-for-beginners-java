# Chat Básico com Azure OpenAI - Exemplo Completo

Este exemplo demonstra como criar uma aplicação simples em Spring Boot que se conecta ao Azure OpenAI e testa sua configuração.

## Índice

- [Pré-requisitos](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Início Rápido](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Opções de Configuração](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Opção 1: Variáveis de Ambiente (arquivo .env) - Recomendado](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Opção 2: Segredos do GitHub Codespace](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Executando a Aplicação](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Usando Maven](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Usando VS Code](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Saída Esperada](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Referência de Configuração](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Variáveis de Ambiente](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Configuração do Spring](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Solução de Problemas](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Problemas Comuns](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Modo de Depuração](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Próximos Passos](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Recursos](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Pré-requisitos

Antes de executar este exemplo, certifique-se de que você tenha:

- Concluído o [guia de configuração do Azure OpenAI](../../getting-started-azure-openai.md)  
- Implantado o recurso Azure OpenAI (via portal Azure AI Foundry)  
- Implantado o modelo gpt-4o-mini (ou alternativa)  
- Chave de API e URL do endpoint do Azure  

## Início Rápido

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Opções de Configuração

### Opção 1: Variáveis de Ambiente (arquivo .env) - Recomendado

**Passo 1: Crie seu arquivo de configuração**
```bash
cp .env.example .env
```

**Passo 2: Adicione suas credenciais do Azure OpenAI**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Nota de Segurança**: 
> - Nunca envie seu arquivo `.env` para controle de versão
> - O arquivo `.env` já está listado no `.gitignore`
> - Mantenha suas chaves de API seguras e as rotacione regularmente

### Opção 2: Segredos do GitHub Codespace

Para GitHub Codespaces, configure os seguintes segredos no seu repositório:
- `AZURE_AI_KEY` - Sua chave de API do Azure OpenAI
- `AZURE_AI_ENDPOINT` - URL do endpoint do Azure OpenAI

A aplicação detecta e utiliza esses segredos automaticamente.

### Alternativa: Variáveis de Ambiente Diretas

<details>
<summary>Clique para ver os comandos específicos da plataforma</summary>

**Linux/macOS (bash/zsh):**
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Prompt de Comando):**
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## Executando a Aplicação

### Usando Maven

```bash
mvn spring-boot:run
```

### Usando VS Code

1. Abra o projeto no VS Code
2. Pressione `F5` ou use o painel "Run and Debug"
3. Selecione a configuração "Spring Boot-BasicChatApplication"

> **Nota**: A configuração do VS Code carrega automaticamente seu arquivo .env

### Saída Esperada

```
Starting Basic Chat with Azure OpenAI...
Environment variables loaded successfully
Connecting to Azure OpenAI...
Sending prompt: What is AI in a short sentence? Max 100 words.

AI Response:
================
AI, or Artificial Intelligence, is the simulation of human intelligence in machines programmed to think and learn like humans.
================

Success! Azure OpenAI connection is working correctly.
```

## Referência de Configuração

### Variáveis de Ambiente

| Variável | Descrição | Obrigatória | Exemplo |
|----------|-------------|----------|---------|
| `AZURE_AI_KEY` | Chave de API do Azure OpenAI | Sim | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL do endpoint do Azure OpenAI | Sim | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Nome da implantação do modelo | Não | `gpt-4o-mini` (padrão) |

### Configuração do Spring

O arquivo `application.yml` configura:
- **Chave de API**: `${AZURE_AI_KEY}` - Obtida da variável de ambiente
- **Endpoint**: `${AZURE_AI_ENDPOINT}` - Obtido da variável de ambiente  
- **Modelo**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Obtido da variável de ambiente com valor padrão
- **Temperatura**: `0.7` - Controla a criatividade (0.0 = determinístico, 1.0 = criativo)
- **Máximo de Tokens**: `500` - Comprimento máximo da resposta

## Solução de Problemas

### Problemas Comuns

<details>
<summary><strong>Erro: "A chave de API não é válida"</strong></summary>

- Verifique se sua `AZURE_AI_KEY` está configurada corretamente no arquivo `.env`
- Confirme que a chave de API foi copiada exatamente do portal Azure AI Foundry
- Certifique-se de que não há espaços ou aspas extras ao redor da chave
</details>

<details>
<summary><strong>Erro: "O endpoint não é válido"</strong></summary>

- Certifique-se de que sua `AZURE_AI_ENDPOINT` inclui a URL completa (ex.: `https://your-hub-name.openai.azure.com/`)
- Verifique a consistência da barra final
- Confirme que o endpoint corresponde à região de implantação do Azure
</details>

<details>
<summary><strong>Erro: "A implantação não foi encontrada"</strong></summary>

- Verifique se o nome da implantação do modelo corresponde exatamente ao que foi implantado no Azure
- Confirme que o modelo foi implantado com sucesso e está ativo
- Tente usar o nome padrão da implantação: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Variáveis de ambiente não carregando</strong></summary>

- Certifique-se de que seu arquivo `.env` está no diretório raiz do projeto (mesmo nível que `pom.xml`)
- Tente executar `mvn spring-boot:run` no terminal integrado do VS Code
- Verifique se a extensão Java do VS Code está instalada corretamente
- Confirme que a configuração de inicialização contém `"envFile": "${workspaceFolder}/.env"`
</details>

### Modo de Depuração

Para habilitar o registro detalhado, descomente estas linhas no arquivo `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Próximos Passos

**Configuração Concluída!** Continue sua jornada de aprendizado:

[Capítulo 3: Técnicas Fundamentais de IA Generativa](../../../03-CoreGenerativeAITechniques/README.md)

## Recursos

- [Documentação Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Documentação do Serviço Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)
- [Portal Azure AI Foundry](https://ai.azure.com/)
- [Documentação Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Aviso Legal**:  
Este documento foi traduzido utilizando o serviço de tradução por IA [Co-op Translator](https://github.com/Azure/co-op-translator). Embora nos esforcemos para garantir a precisão, esteja ciente de que traduções automatizadas podem conter erros ou imprecisões. O documento original em seu idioma nativo deve ser considerado a fonte autoritativa. Para informações críticas, recomenda-se a tradução profissional realizada por humanos. Não nos responsabilizamos por quaisquer mal-entendidos ou interpretações equivocadas decorrentes do uso desta tradução.