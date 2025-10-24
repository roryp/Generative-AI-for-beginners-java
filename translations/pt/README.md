<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d83a4cd2f465a83b72b5a5284d3a72fd",
  "translation_date": "2025-10-24T09:04:11+00:00",
  "source_file": "README.md",
  "language_code": "pt"
}
-->
# IA Generativa para Iniciantes - Edição Java
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![IA Generativa para Iniciantes - Edição Java](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.pt.png)

**Tempo Necessário**: Todo o workshop pode ser concluído online sem necessidade de configuração local. A configuração do ambiente leva 2 minutos, e explorar os exemplos requer de 1 a 3 horas, dependendo da profundidade de exploração.

> **Início Rápido**

1. Faça um fork deste repositório na sua conta do GitHub
2. Clique em **Code** → aba **Codespaces** → **...** → **New with options...**
3. Use as configurações padrão – isso selecionará o container de desenvolvimento criado para este curso
4. Clique em **Create codespace**
5. Aguarde cerca de 2 minutos para o ambiente estar pronto
6. Vá direto para [O primeiro exemplo](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Suporte Multilíngue

### Suportado via GitHub Action (Automatizado e Sempre Atualizado)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Árabe](../ar/README.md) | [Bengali](../bn/README.md) | [Búlgaro](../bg/README.md) | [Birmanês (Myanmar)](../my/README.md) | [Chinês (Simplificado)](../zh/README.md) | [Chinês (Tradicional, Hong Kong)](../hk/README.md) | [Chinês (Tradicional, Macau)](../mo/README.md) | [Chinês (Tradicional, Taiwan)](../tw/README.md) | [Croata](../hr/README.md) | [Checo](../cs/README.md) | [Dinamarquês](../da/README.md) | [Holandês](../nl/README.md) | [Estoniano](../et/README.md) | [Finlandês](../fi/README.md) | [Francês](../fr/README.md) | [Alemão](../de/README.md) | [Grego](../el/README.md) | [Hebraico](../he/README.md) | [Hindi](../hi/README.md) | [Húngaro](../hu/README.md) | [Indonésio](../id/README.md) | [Italiano](../it/README.md) | [Japonês](../ja/README.md) | [Coreano](../ko/README.md) | [Lituano](../lt/README.md) | [Malaio](../ms/README.md) | [Marathi](../mr/README.md) | [Nepalês](../ne/README.md) | [Norueguês](../no/README.md) | [Persa (Farsi)](../fa/README.md) | [Polaco](../pl/README.md) | [Português (Brasil)](../br/README.md) | [Português (Portugal)](./README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romeno](../ro/README.md) | [Russo](../ru/README.md) | [Sérvio (Cirílico)](../sr/README.md) | [Eslovaco](../sk/README.md) | [Esloveno](../sl/README.md) | [Espanhol](../es/README.md) | [Suaíli](../sw/README.md) | [Sueco](../sv/README.md) | [Tagalo (Filipino)](../tl/README.md) | [Tâmil](../ta/README.md) | [Tailandês](../th/README.md) | [Turco](../tr/README.md) | [Ucraniano](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamita](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Estrutura do Curso e Caminho de Aprendizagem

### **Capítulo 1: Introdução à IA Generativa**
- **Conceitos Fundamentais**: Compreender Modelos de Linguagem de Grande Escala, tokens, embeddings e capacidades de IA
- **Ecossistema de IA em Java**: Visão geral do Spring AI e SDKs OpenAI
- **Protocolo de Contexto de Modelo**: Introdução ao MCP e seu papel na comunicação de agentes de IA
- **Aplicações Práticas**: Cenários reais, incluindo chatbots e geração de conteúdo
- **[→ Começar Capítulo 1](./01-IntroToGenAI/README.md)**

### **Capítulo 2: Configuração do Ambiente de Desenvolvimento**
- **Configuração Multi-Provedor**: Configurar Modelos GitHub, Azure OpenAI e integrações do SDK OpenAI Java
- **Spring Boot + Spring AI**: Melhores práticas para desenvolvimento de aplicações empresariais de IA
- **Modelos GitHub**: Acesso gratuito a modelos de IA para prototipagem e aprendizado (sem necessidade de cartão de crédito)
- **Ferramentas de Desenvolvimento**: Configuração de containers Docker, VS Code e GitHub Codespaces
- **[→ Começar Capítulo 2](./02-SetupDevEnvironment/README.md)**

### **Capítulo 3: Técnicas Fundamentais de IA Generativa**
- **Engenharia de Prompts**: Técnicas para respostas ideais de modelos de IA
- **Embeddings e Operações com Vetores**: Implementar busca semântica e correspondência de similaridade
- **Geração com Recuperação (RAG)**: Combinar IA com suas próprias fontes de dados
- **Chamadas de Função**: Expandir capacidades de IA com ferramentas e plugins personalizados
- **[→ Começar Capítulo 3](./03-CoreGenerativeAITechniques/README.md)**

### **Capítulo 4: Aplicações Práticas e Projetos**
- **Gerador de Histórias de Animais de Estimação** (`petstory/`): Geração criativa de conteúdo com Modelos GitHub
- **Demo Local Foundry** (`foundrylocal/`): Integração de modelos de IA locais com SDK OpenAI Java
- **Serviço de Calculadora MCP** (`calculator/`): Implementação básica do Protocolo de Contexto de Modelo com Spring AI
- **[→ Começar Capítulo 4](./04-PracticalSamples/README.md)**

### **Capítulo 5: Desenvolvimento de IA Responsável**
- **Segurança dos Modelos GitHub**: Testar filtragem de conteúdo integrada e mecanismos de segurança (bloqueios rígidos e recusas suaves)
- **Demo de IA Responsável**: Exemplo prático mostrando como sistemas modernos de segurança de IA funcionam na prática
- **Melhores Práticas**: Diretrizes essenciais para desenvolvimento e implantação ética de IA
- **[→ Começar Capítulo 5](./05-ResponsibleGenAI/README.md)**

## Recursos Adicionais

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### Azure / Edge / MCP / Agentes
[![AZD para Iniciantes](https://img.shields.io/badge/AZD%20para%20Iniciantes-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![IA de Borda para Iniciantes](https://img.shields.io/badge/IA%20de%20Borda%20para%20Iniciantes-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP para Iniciantes](https://img.shields.io/badge/MCP%20para%20Iniciantes-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Agentes de IA para Iniciantes](https://img.shields.io/badge/Agentes%20de%20IA%20para%20Iniciantes-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### Série de IA Generativa
[![IA Generativa para Iniciantes](https://img.shields.io/badge/IA%20Generativa%20para%20Iniciantes-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![IA Generativa (.NET)](https://img.shields.io/badge/IA%20Generativa%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![IA Generativa (Java)](https://img.shields.io/badge/IA%20Generativa%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![IA Generativa (JavaScript)](https://img.shields.io/badge/IA%20Generativa%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---

### Aprendizado Fundamental
[![ML para Iniciantes](https://img.shields.io/badge/ML%20para%20Iniciantes-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Ciência de Dados para Iniciantes](https://img.shields.io/badge/Ciência%20de%20Dados%20para%20Iniciantes-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![IA para Iniciantes](https://img.shields.io/badge/IA%20para%20Iniciantes-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cibersegurança para Iniciantes](https://img.shields.io/badge/Cibersegurança%20para%20Iniciantes-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Desenvolvimento Web para Iniciantes](https://img.shields.io/badge/Desenvolvimento%20Web%20para%20Iniciantes-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT para Iniciantes](https://img.shields.io/badge/IoT%20para%20Iniciantes-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![Desenvolvimento XR para Iniciantes](https://img.shields.io/badge/Desenvolvimento%20XR%20para%20Iniciantes-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### Série Copilot
[![Copilot para Programação em Parceria com IA](https://img.shields.io/badge/Copilot%20para%20Programação%20em%20Parceria%20com%20IA-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot para C#/.NET](https://img.shields.io/badge/Copilot%20para%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)  
[![Aventura Copilot](https://img.shields.io/badge/Aventura%20Copilot-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)  
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## Obter Ajuda

Se ficar bloqueado ou tiver dúvidas sobre como criar aplicações de IA, junte-se a:

[![Discord Azure AI Foundry](https://img.shields.io/badge/Discord-Comunidade_Azure_AI_Foundry_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Se tiver feedback sobre o produto ou encontrar erros durante o desenvolvimento, visite:

[![Fórum de Desenvolvedores Azure AI Foundry](https://img.shields.io/badge/GitHub-Fórum_de_Desenvolvedores_Azure_AI_Foundry-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Aviso**:  
Este documento foi traduzido utilizando o serviço de tradução por IA [Co-op Translator](https://github.com/Azure/co-op-translator). Embora nos esforcemos pela precisão, esteja ciente de que traduções automáticas podem conter erros ou imprecisões. O documento original na sua língua nativa deve ser considerado a fonte autoritária. Para informações críticas, recomenda-se uma tradução profissional realizada por humanos. Não nos responsabilizamos por quaisquer mal-entendidos ou interpretações incorretas decorrentes do uso desta tradução.