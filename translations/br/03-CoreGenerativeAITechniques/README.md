<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T17:40:55+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "br"
}
-->
# Técnicas Fundamentais de IA Generativa

>**Nota**: Este capítulo inclui um [**Tutorial**](./TUTORIAL.md) detalhado que orienta você na execução dos exemplos finalizados.

## O Que Você Vai Aprender
Neste capítulo, exploramos 4 técnicas fundamentais de IA generativa por meio de exemplos práticos:
- Completações de LLM e fluxos de conversa
- Chamadas de funções
- Geração Aumentada por Recuperação (RAG)
- Medidas de segurança para IA responsável

## Índice

- [O Que Você Vai Aprender](../../../03-CoreGenerativeAITechniques)
- [Pré-requisitos](../../../03-CoreGenerativeAITechniques)
- [Começando](../../../03-CoreGenerativeAITechniques)
- [Visão Geral dos Exemplos](../../../03-CoreGenerativeAITechniques)
  - [1. Completações de LLM e Fluxos de Conversa](../../../03-CoreGenerativeAITechniques)
  - [2. Funções e Plugins com LLMs](../../../03-CoreGenerativeAITechniques)
  - [3. Geração Aumentada por Recuperação (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Demonstração de Segurança em IA Responsável](../../../03-CoreGenerativeAITechniques)
- [Resumo](../../../03-CoreGenerativeAITechniques)
- [Próximos Passos](../../../03-CoreGenerativeAITechniques)

## Pré-requisitos

- Configuração concluída a partir do [Capítulo 2](../../../02-SetupDevEnvironment)

## Começando

1. **Navegue até os exemplos**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Configure o ambiente**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Compile e execute os exemplos**:  
```bash
   # Run completions example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
   
   # Run functions example  
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
   
   # Run RAG example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
   
   # Run responsible AI demo
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```  

## Visão Geral dos Exemplos

Os exemplos estão organizados na pasta `examples/` com a seguinte estrutura:

```
examples/
├── src/main/java/com/example/genai/techniques/
│   ├── completions/
│   │   └── LLMCompletionsApp.java        # Basic completions 
│   ├── functions/
│   │   └── FunctionsApp.java             # Function calling examples
│   ├── rag/
│   │   └── SimpleReaderDemo.java         # Retrieval-Augmented Generation
│   └── responsibleai/
│       └── ResponsibleGithubModels.java  # Responsible AI safety demonstration
├── document.txt                          # Sample document for RAG example
└── pom.xml                               # Maven configuration
```

### 1. Completações de LLM e Fluxos de Conversa
**Arquivo**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Aprenda a construir IA conversacional com respostas em streaming e gerenciamento de histórico de conversas.

Este exemplo demonstra:
- Completação de texto simples com prompts do sistema
- Conversas de múltiplas interações com gerenciamento de histórico
- Sessões de chat interativas
- Configuração de parâmetros (temperatura, número máximo de tokens)

### 2. Funções e Plugins com LLMs
**Arquivo**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Amplie as capacidades da IA fornecendo acesso a funções personalizadas e APIs externas.

Este exemplo demonstra:
- Integração com função de previsão do tempo
- Implementação de função de calculadora  
- Chamadas de múltiplas funções em uma única conversa
- Definição de funções com esquemas JSON

### 3. Geração Aumentada por Recuperação (RAG)
**Arquivo**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Aprenda a combinar IA com seus próprios documentos e fontes de dados para respostas precisas e contextualizadas.

Este exemplo demonstra:
- Respostas baseadas em documentos com o SDK do Azure OpenAI
- Implementação do padrão RAG com Modelos do GitHub

**Uso**: Faça perguntas sobre o conteúdo em `document.txt` e receba respostas da IA baseadas apenas nesse contexto.

### 4. Demonstração de Segurança em IA Responsável
**Arquivo**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Obtenha uma prévia de como funcionam as medidas de segurança em IA testando as capacidades de filtragem de conteúdo dos Modelos do GitHub.

Este exemplo demonstra:
- Filtragem de conteúdo para prompts potencialmente prejudiciais
- Tratamento de respostas de segurança em aplicações
- Diferentes categorias de conteúdo bloqueado (violência, discurso de ódio, desinformação)
- Tratamento adequado de erros para violações de segurança

> **Saiba Mais**: Esta é apenas uma introdução aos conceitos de IA responsável. Para mais informações sobre ética, mitigação de vieses, considerações de privacidade e frameworks de IA responsável, veja [Capítulo 5: IA Generativa Responsável](../05-ResponsibleGenAI/README.md).

## Resumo

Neste capítulo, exploramos completações de LLM e fluxos de conversa, implementamos chamadas de funções para ampliar as capacidades da IA, criamos um sistema de Geração Aumentada por Recuperação (RAG) e demonstramos medidas de segurança em IA responsável.

> **NOTA**: Aprofunde-se com o [**Tutorial**](./TUTORIAL.md) fornecido.

## Próximos Passos

[Capítulo 4: Aplicações Práticas e Projetos](../04-PracticalSamples/README.md)

**Aviso Legal**:  
Este documento foi traduzido utilizando o serviço de tradução por IA [Co-op Translator](https://github.com/Azure/co-op-translator). Embora nos esforcemos para garantir a precisão, esteja ciente de que traduções automatizadas podem conter erros ou imprecisões. O documento original em seu idioma nativo deve ser considerado a fonte autoritativa. Para informações críticas, recomenda-se a tradução profissional realizada por humanos. Não nos responsabilizamos por quaisquer mal-entendidos ou interpretações equivocadas decorrentes do uso desta tradução.