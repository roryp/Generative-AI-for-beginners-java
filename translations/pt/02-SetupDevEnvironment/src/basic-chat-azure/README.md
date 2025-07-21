<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2289320a74aeca1eb844cd7d3a7a9e12",
  "translation_date": "2025-07-21T16:27:47+00:00",
  "source_file": "02-SetupDevEnvironment/src/basic-chat-azure/README.md",
  "language_code": "pt"
}
-->
# Chat Básico com Azure OpenAI - Exemplo Completo

Este exemplo demonstra como criar uma aplicação simples em Spring Boot que se conecta ao Azure OpenAI e testa a sua configuração.

## Índice

- [Pré-requisitos](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Início Rápido](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Opções de Configuração](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Opção 1: Variáveis de Ambiente (ficheiro .env) - Recomendado](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Opção 2: Segredos do GitHub Codespace](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Executar a Aplicação](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Usando Maven](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Usando VS Code](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Saída Esperada](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Referência de Configuração](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Variáveis de Ambiente](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Configuração do Spring](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Resolução de Problemas](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Problemas Comuns](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Modo de Depuração](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Próximos Passos](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Recursos](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)

## Pré-requisitos

Antes de executar este exemplo, certifique-se de que tem:

- Concluído o [guia de configuração do Azure OpenAI](../../getting-started-azure-openai.md)  
- Recurso Azure OpenAI implementado (via portal Azure AI Foundry)  
- Modelo gpt-4o-mini implementado (ou alternativa)  
- Chave API e URL do endpoint do Azure  

## Início Rápido

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/src/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Opções de Configuração

### Opção 1: Variáveis de Ambiente (ficheiro .env) - Recomendado

**Passo 1: Crie o seu ficheiro de configuração**
```bash
cp .env.example .env
```

**Passo 2: Adicione as suas credenciais do Azure OpenAI**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Nota de Segurança**: 
> - Nunca comprometa o seu ficheiro `.env` no controlo de versões
> - O ficheiro `.env` já está incluído no `.gitignore`
> - Mantenha as suas chaves API seguras e rode-as regularmente

### Opção 2: Segredos do GitHub Codespace

Para GitHub Codespaces, defina estes segredos no seu repositório:
- `AZURE_AI_KEY` - A sua chave API do Azure OpenAI
- `AZURE_AI_ENDPOINT` - O URL do endpoint do Azure OpenAI

A aplicação deteta e utiliza automaticamente estes segredos.

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

## Executar a Aplicação

### Usando Maven

```bash
mvn spring-boot:run
```

### Usando VS Code

1. Abra o projeto no VS Code  
2. Pressione `F5` ou utilize o painel "Run and Debug"  
3. Selecione a configuração "Spring Boot-BasicChatApplication"  

> **Nota**: A configuração do VS Code carrega automaticamente o seu ficheiro .env

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

| Variável | Descrição | Obrigatório | Exemplo |
|----------|-------------|----------|---------|
| `AZURE_AI_KEY` | Chave API do Azure OpenAI | Sim | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL do endpoint do Azure OpenAI | Sim | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Nome da implementação do modelo | Não | `gpt-4o-mini` (padrão) |

### Configuração do Spring

O ficheiro `application.yml` configura:
- **Chave API**: `${AZURE_AI_KEY}` - A partir da variável de ambiente  
- **Endpoint**: `${AZURE_AI_ENDPOINT}` - A partir da variável de ambiente  
- **Modelo**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - A partir da variável de ambiente com valor padrão  
- **Temperatura**: `0.7` - Controla a criatividade (0.0 = determinístico, 1.0 = criativo)  
- **Máximo de Tokens**: `500` - Comprimento máximo da resposta  

## Resolução de Problemas

### Problemas Comuns

<details>
<summary><strong>Erro: "A chave API não é válida"</strong></summary>

- Verifique se o `AZURE_AI_KEY` está corretamente definido no seu ficheiro `.env`  
- Confirme que a chave API foi copiada exatamente do portal Azure AI Foundry  
- Certifique-se de que não há espaços ou aspas extras em torno da chave  
</details>

<details>
<summary><strong>Erro: "O endpoint não é válido"</strong></summary>

- Certifique-se de que o `AZURE_AI_ENDPOINT` inclui o URL completo (ex.: `https://your-hub-name.openai.azure.com/`)  
- Verifique a consistência da barra final  
- Confirme que o endpoint corresponde à região de implementação do Azure  
</details>

<details>
<summary><strong>Erro: "A implementação não foi encontrada"</strong></summary>

- Verifique se o nome da implementação do modelo corresponde exatamente ao que está implementado no Azure  
- Confirme que o modelo foi implementado com sucesso e está ativo  
- Experimente usar o nome de implementação padrão: `gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code: Variáveis de ambiente não estão a carregar</strong></summary>

- Certifique-se de que o ficheiro `.env` está no diretório raiz do projeto (mesmo nível que `pom.xml`)  
- Experimente executar `mvn spring-boot:run` no terminal integrado do VS Code  
- Verifique se a extensão Java do VS Code está devidamente instalada  
- Confirme que a configuração de lançamento tem `"envFile": "${workspaceFolder}/.env"`  
</details>

### Modo de Depuração

Para ativar o registo detalhado, descomente estas linhas no `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Próximos Passos

**Configuração Concluída!** Continue a sua jornada de aprendizagem:

[Capítulo 3: Técnicas Centrais de IA Generativa](../../../03-CoreGenerativeAITechniques/README.md)

## Recursos

- [Documentação Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [Documentação do Serviço Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)  
- [Portal Azure AI Foundry](https://ai.azure.com/)  
- [Documentação do Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**Aviso Legal**:  
Este documento foi traduzido utilizando o serviço de tradução por IA [Co-op Translator](https://github.com/Azure/co-op-translator). Embora nos esforcemos pela precisão, esteja ciente de que traduções automáticas podem conter erros ou imprecisões. O documento original na sua língua nativa deve ser considerado a fonte autoritária. Para informações críticas, recomenda-se a tradução profissional realizada por humanos. Não nos responsabilizamos por quaisquer mal-entendidos ou interpretações incorretas decorrentes do uso desta tradução.