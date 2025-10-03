<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:34:35+00:00",
  "source_file": "AGENTS.md",
  "language_code": "br"
}
-->
# AGENTS.md

## Visão Geral do Projeto

Este é um repositório educacional para aprender desenvolvimento de IA Generativa com Java. Ele oferece um curso prático abrangente que cobre Modelos de Linguagem Grande (LLMs), engenharia de prompts, embeddings, RAG (Geração com Recuperação de Dados) e o Protocolo de Contexto de Modelo (MCP).

**Principais Tecnologias:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- Modelos do GitHub, Azure OpenAI e SDKs OpenAI

**Arquitetura:**
- Múltiplas aplicações Spring Boot independentes organizadas por capítulos
- Projetos de exemplo demonstrando diferentes padrões de IA
- Pronto para GitHub Codespaces com contêineres de desenvolvimento pré-configurados

## Comandos de Configuração

### Pré-requisitos
- Java 21 ou superior
- Maven 3.x
- Token de acesso pessoal do GitHub (para Modelos do GitHub)
- Opcional: credenciais do Azure OpenAI

### Configuração do Ambiente

**Opção 1: GitHub Codespaces (Recomendado)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Opção 2: Contêiner de Desenvolvimento Local**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Opção 3: Configuração Local**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Configuração

**Configuração do Token do GitHub:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Configuração do Azure OpenAI (Opcional):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Fluxo de Trabalho de Desenvolvimento

### Estrutura do Projeto
```
/
├── 01-IntroToGenAI/              # Chapter 1: Introduction
├── 02-SetupDevEnvironment/       # Chapter 2: Environment setup
│   └── examples/                 # Working examples
├── 03-CoreGenerativeAITechniques/ # Chapter 3: Core techniques
├── 04-PracticalSamples/          # Chapter 4: Sample projects
│   ├── calculator/               # MCP service example
│   ├── foundrylocal/            # Local model integration
│   └── petstory/                # Multi-modal app
├── 05-ResponsibleGenAI/         # Chapter 5: Responsible AI
└── translations/                # Multi-language support
```

### Executando Aplicações

**Executando uma aplicação Spring Boot:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Compilando um projeto:**
```bash
cd [project-directory]
mvn clean install
```

**Iniciando o Servidor MCP Calculator:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Executando Exemplos de Cliente:**
```bash
# After starting the server in another terminal
cd 04-PracticalSamples/calculator

# Direct MCP client
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"

# AI-powered client (requires GITHUB_TOKEN)
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"

# Interactive bot
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.Bot"
```

### Atualização Automática
Spring Boot DevTools está incluído nos projetos que suportam atualização automática:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Instruções de Teste

### Executando Testes

**Executar todos os testes em um projeto:**
```bash
cd [project-directory]
mvn test
```

**Executar testes com saída detalhada:**
```bash
mvn test -X
```

**Executar uma classe de teste específica:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Estrutura de Testes
- Arquivos de teste utilizam JUnit 5 (Jupiter)
- Classes de teste estão localizadas em `src/test/java/`
- Exemplos de cliente no projeto de calculadora estão em `src/test/java/com/microsoft/mcp/sample/client/`

### Testes Manuais
Muitos exemplos são aplicações interativas que requerem testes manuais:

1. Inicie a aplicação com `mvn spring-boot:run`
2. Teste os endpoints ou interaja com o CLI
3. Verifique se o comportamento esperado corresponde à documentação no README.md de cada projeto

### Testando com Modelos do GitHub
- Limites da camada gratuita: 15 solicitações/minuto, 150/dia
- Máximo de 5 solicitações simultâneas
- Teste filtragem de conteúdo com exemplos de IA responsável

## Diretrizes de Estilo de Código

### Convenções Java
- **Versão Java:** Java 21 com recursos modernos
- **Estilo:** Siga as convenções padrão do Java
- **Nomenclatura:** 
  - Classes: PascalCase
  - Métodos/variáveis: camelCase
  - Constantes: UPPER_SNAKE_CASE
  - Nomes de pacotes: minúsculas

### Padrões Spring Boot
- Use `@Service` para lógica de negócios
- Use `@RestController` para endpoints REST
- Configuração via `application.yml` ou `application.properties`
- Variáveis de ambiente preferidas em vez de valores fixos
- Use a anotação `@Tool` para métodos expostos pelo MCP

### Organização de Arquivos
```
src/
├── main/
│   ├── java/
│   │   └── com/microsoft/[component]/
│   │       ├── [Component]Application.java
│   │       ├── config/
│   │       ├── controller/
│   │       ├── service/
│   │       └── exception/
│   └── resources/
│       ├── application.yml
│       └── static/
└── test/
    └── java/
        └── com/microsoft/[component]/
```

### Dependências
- Gerenciadas via Maven `pom.xml`
- Spring AI BOM para gerenciamento de versões
- LangChain4j para integrações de IA
- Starter parent do Spring Boot para dependências do Spring

### Comentários de Código
- Adicione JavaDoc para APIs públicas
- Inclua comentários explicativos para interações complexas de IA
- Documente claramente as descrições das ferramentas do MCP

## Construção e Implantação

### Construindo Projetos

**Construir sem testes:**
```bash
mvn clean install -DskipTests
```

**Construir com todas as verificações:**
```bash
mvn clean install
```

**Empacotar aplicação:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Diretórios de Saída
- Classes compiladas: `target/classes/`
- Classes de teste: `target/test-classes/`
- Arquivos JAR: `target/*.jar`
- Artefatos Maven: `target/`

### Configuração Específica do Ambiente

**Desenvolvimento:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Produção:**
- Use Modelos do Azure AI Foundry em vez de Modelos do GitHub
- Atualize a base-url para o endpoint do Azure OpenAI
- Gerencie segredos via Azure Key Vault ou variáveis de ambiente

### Considerações de Implantação
- Este é um repositório educacional com aplicações de exemplo
- Não foi projetado para implantação em produção como está
- Os exemplos demonstram padrões para adaptação ao uso em produção
- Consulte os READMEs de projetos individuais para notas específicas de implantação

## Notas Adicionais

### Modelos do GitHub vs Azure OpenAI
- **Modelos do GitHub:** Camada gratuita para aprendizado, sem necessidade de cartão de crédito
- **Azure OpenAI:** Pronto para produção, requer assinatura do Azure
- O código é compatível entre ambos - basta alterar o endpoint e a chave da API

### Trabalhando com Múltiplos Projetos
Cada projeto de exemplo é independente:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Problemas Comuns

**Incompatibilidade de Versão do Java:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Problemas de Download de Dependências:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**Token do GitHub Não Encontrado:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Porta Já em Uso:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Suporte a Múltiplos Idiomas
- Documentação disponível em mais de 45 idiomas via tradução automatizada
- Traduções no diretório `translations/`
- Tradução gerenciada pelo fluxo de trabalho do GitHub Actions

### Caminho de Aprendizado
1. Comece com [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Siga os capítulos na ordem (01 → 05)
3. Complete os exemplos práticos em cada capítulo
4. Explore projetos de exemplo no Capítulo 4
5. Aprenda práticas de IA responsável no Capítulo 5

### Contêiner de Desenvolvimento
O arquivo `.devcontainer/devcontainer.json` configura:
- Ambiente de desenvolvimento Java 21
- Maven pré-instalado
- Extensões Java para VS Code
- Ferramentas Spring Boot
- Integração com GitHub Copilot
- Suporte a Docker-in-Docker
- CLI do Azure

### Considerações de Desempenho
- A camada gratuita dos Modelos do GitHub possui limites de taxa
- Use tamanhos de lote apropriados para embeddings
- Considere o uso de cache para chamadas repetidas de API
- Monitore o uso de tokens para otimização de custos

### Notas de Segurança
- Nunca faça commit de arquivos `.env` (já estão no `.gitignore`)
- Use variáveis de ambiente para chaves de API
- Tokens do GitHub devem ter escopos mínimos necessários
- Siga as diretrizes de IA responsável no Capítulo 5

---

**Aviso Legal**:  
Este documento foi traduzido utilizando o serviço de tradução por IA [Co-op Translator](https://github.com/Azure/co-op-translator). Embora nos esforcemos para garantir a precisão, esteja ciente de que traduções automatizadas podem conter erros ou imprecisões. O documento original em seu idioma nativo deve ser considerado a fonte oficial. Para informações críticas, recomenda-se a tradução profissional realizada por humanos. Não nos responsabilizamos por quaisquer mal-entendidos ou interpretações equivocadas decorrentes do uso desta tradução.