<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:25:24+00:00",
  "source_file": "README.md",
  "language_code": "br"
}
-->
# IA Generativa para Iniciantes - Edição Java
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![IA Generativa para Iniciantes - Edição Java](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.br.png)

**Compromisso de Tempo**: Todo o workshop pode ser concluído online sem necessidade de configuração local. A configuração do ambiente leva 2 minutos, e a exploração dos exemplos requer de 1 a 3 horas, dependendo da profundidade da exploração.

> **Início Rápido**

1. Faça um fork deste repositório na sua conta do GitHub
2. Clique em **Code** → aba **Codespaces** → **...** → **New with options...**
3. Use as configurações padrão – isso selecionará o container de desenvolvimento criado para este curso
4. Clique em **Create codespace**
5. Aguarde ~2 minutos para o ambiente estar pronto
6. Vá direto para [O primeiro exemplo](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Suporte Multilíngue

### Suportado via GitHub Action (Automatizado e Sempre Atualizado)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Árabe](../ar/README.md) | [Bengali](../bn/README.md) | [Búlgaro](../bg/README.md) | [Birmanês (Myanmar)](../my/README.md) | [Chinês (Simplificado)](../zh/README.md) | [Chinês (Tradicional, Hong Kong)](../hk/README.md) | [Chinês (Tradicional, Macau)](../mo/README.md) | [Chinês (Tradicional, Taiwan)](../tw/README.md) | [Croata](../hr/README.md) | [Tcheco](../cs/README.md) | [Dinamarquês](../da/README.md) | [Holandês](../nl/README.md) | [Estoniano](../et/README.md) | [Finlandês](../fi/README.md) | [Francês](../fr/README.md) | [Alemão](../de/README.md) | [Grego](../el/README.md) | [Hebraico](../he/README.md) | [Hindi](../hi/README.md) | [Húngaro](../hu/README.md) | [Indonésio](../id/README.md) | [Italiano](../it/README.md) | [Japonês](../ja/README.md) | [Coreano](../ko/README.md) | [Lituano](../lt/README.md) | [Malaio](../ms/README.md) | [Marathi](../mr/README.md) | [Nepalês](../ne/README.md) | [Norueguês](../no/README.md) | [Persa (Farsi)](../fa/README.md) | [Polonês](../pl/README.md) | [Português (Brasil)](./README.md) | [Português (Portugal)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romeno](../ro/README.md) | [Russo](../ru/README.md) | [Sérvio (Cirílico)](../sr/README.md) | [Eslovaco](../sk/README.md) | [Esloveno](../sl/README.md) | [Espanhol](../es/README.md) | [Suaíli](../sw/README.md) | [Sueco](../sv/README.md) | [Tagalo (Filipino)](../tl/README.md) | [Tâmil](../ta/README.md) | [Tailandês](../th/README.md) | [Turco](../tr/README.md) | [Ucraniano](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamita](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Estrutura do Curso e Caminho de Aprendizado

### **Capítulo 1: Introdução à IA Generativa**
- **Conceitos Fundamentais**: Compreendendo Modelos de Linguagem Grandes, tokens, embeddings e capacidades de IA
- **Ecossistema de IA em Java**: Visão geral do Spring AI e SDKs OpenAI
- **Protocolo de Contexto de Modelo**: Introdução ao MCP e seu papel na comunicação de agentes de IA
- **Aplicações Práticas**: Cenários reais, incluindo chatbots e geração de conteúdo
- **[→ Começar o Capítulo 1](./01-IntroToGenAI/README.md)**

### **Capítulo 2: Configuração do Ambiente de Desenvolvimento**
- **Configuração Multi-Provedor**: Configure integrações com GitHub Models, Azure OpenAI e OpenAI Java SDK
- **Spring Boot + Spring AI**: Melhores práticas para desenvolvimento de aplicações empresariais de IA
- **GitHub Models**: Acesso gratuito a modelos de IA para prototipagem e aprendizado (sem necessidade de cartão de crédito)
- **Ferramentas de Desenvolvimento**: Configuração de containers Docker, VS Code e GitHub Codespaces
- **[→ Começar o Capítulo 2](./02-SetupDevEnvironment/README.md)**

### **Capítulo 3: Técnicas Fundamentais de IA Generativa**
- **Engenharia de Prompt**: Técnicas para respostas ideais de modelos de IA
- **Embeddings e Operações com Vetores**: Implementação de busca semântica e correspondência de similaridade
- **Geração Aumentada por Recuperação (RAG)**: Combine IA com suas próprias fontes de dados
- **Chamadas de Função**: Amplie as capacidades da IA com ferramentas e plugins personalizados
- **[→ Começar o Capítulo 3](./03-CoreGenerativeAITechniques/README.md)**

### **Capítulo 4: Aplicações Práticas e Projetos**
- **Gerador de Histórias de Animais de Estimação** (`petstory/`): Geração criativa de conteúdo com GitHub Models
- **Demo Local Foundry** (`foundrylocal/`): Integração de modelos de IA locais com OpenAI Java SDK
- **Serviço de Calculadora MCP** (`calculator/`): Implementação básica do Protocolo de Contexto de Modelo com Spring AI
- **[→ Começar o Capítulo 4](./04-PracticalSamples/README.md)**

### **Capítulo 5: Desenvolvimento Responsável de IA**
- **Segurança dos GitHub Models**: Teste de filtragem de conteúdo integrada e mecanismos de segurança (bloqueios rígidos e recusas suaves)
- **Demo de IA Responsável**: Exemplo prático mostrando como sistemas modernos de segurança de IA funcionam na prática
- **Melhores Práticas**: Diretrizes essenciais para desenvolvimento e implantação ética de IA
- **[→ Começar o Capítulo 5](./05-ResponsibleGenAI/README.md)**

## Recursos Adicionais

- [Edge AI para Iniciantes](https://github.com/microsoft/edgeai-for-beginners)
- [MCP Para Iniciantes](https://github.com/microsoft/mcp-for-beginners)
- [Agentes de IA Para Iniciantes](https://github.com/microsoft/ai-agents-for-beginners)
- [IA Generativa para Iniciantes usando .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [IA Generativa para Iniciantes usando JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [IA Generativa para Iniciantes](https://github.com/microsoft/generative-ai-for-beginners)
- [ML para Iniciantes](https://aka.ms/ml-beginners)
- [Ciência de Dados para Iniciantes](https://aka.ms/datascience-beginners)
- [IA para Iniciantes](https://aka.ms/ai-beginners)
- [Cibersegurança para Iniciantes](https://github.com/microsoft/Security-101)
- [Desenvolvimento Web para Iniciantes](https://aka.ms/webdev-beginners)
- [IoT para Iniciantes](https://aka.ms/iot-beginners)
- [Desenvolvimento XR para Iniciantes](https://github.com/microsoft/xr-development-for-beginners)
- [Dominando o GitHub Copilot para Programação em Parceria com IA](https://aka.ms/GitHubCopilotAI)
- [Dominando o GitHub Copilot para Desenvolvedores C#/.NET](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Escolha Sua Própria Aventura com Copilot](https://github.com/microsoft/CopilotAdventures)
- [App de Chat RAG com Serviços de IA do Azure](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Obtendo Ajuda

Se você tiver dúvidas ou precisar de ajuda para construir aplicativos de IA, junte-se a:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Se você tiver feedback sobre produtos ou encontrar erros durante o desenvolvimento, visite:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Aviso Legal**:  
Este documento foi traduzido usando o serviço de tradução por IA [Co-op Translator](https://github.com/Azure/co-op-translator). Embora nos esforcemos para garantir a precisão, esteja ciente de que traduções automáticas podem conter erros ou imprecisões. O documento original em seu idioma nativo deve ser considerado a fonte oficial. Para informações críticas, recomenda-se a tradução profissional humana. Não nos responsabilizamos por quaisquer mal-entendidos ou interpretações incorretas decorrentes do uso desta tradução.