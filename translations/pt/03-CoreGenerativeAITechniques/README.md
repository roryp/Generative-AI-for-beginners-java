<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T09:20:20+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "pt"
}
-->
# Técnicas Fundamentais de IA Generativa

>**Note**: Este capítulo inclui um [**Tutorial**](./TUTORIAL.md) detalhado que o orienta através dos exemplos.

## O Que Vai Aprender
Neste capítulo, exploramos 4 técnicas fundamentais de IA generativa através de exemplos práticos:
- Completações de LLM e fluxos de conversação
- Chamadas de funções
- Geração com Recuperação de Dados (RAG)
- Medidas de segurança para IA responsável

## Índice

- [O Que Vai Aprender](../../../03-CoreGenerativeAITechniques)
- [Pré-requisitos](../../../03-CoreGenerativeAITechniques)
- [Introdução](../../../03-CoreGenerativeAITechniques)
- [Visão Geral dos Exemplos](../../../03-CoreGenerativeAITechniques)
  - [1. Completações de LLM e Fluxos de Conversação](../../../03-CoreGenerativeAITechniques)
  - [2. Funções e Plugins com LLMs](../../../03-CoreGenerativeAITechniques)
  - [3. Geração com Recuperação de Dados (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Demonstração de Segurança em IA Responsável](../../../03-CoreGenerativeAITechniques)
- [Resumo](../../../03-CoreGenerativeAITechniques)
- [Próximos Passos](../../../03-CoreGenerativeAITechniques)

## Pré-requisitos

- Configuração concluída do [Capítulo 2](../../../02-SetupDevEnvironment)

## Introdução

1. **Navegar até os exemplos**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Definir o ambiente**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Compilar e executar os exemplos**:  
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

### 1. Completações de LLM e Fluxos de Conversação
**Ficheiro**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Aprenda a construir IA conversacional com respostas em streaming e gestão de histórico de conversas.

Este exemplo demonstra:
- Completação de texto simples com prompts de sistema
- Conversas de múltiplas interações com gestão de histórico
- Sessões de chat interativas
- Configuração de parâmetros (temperatura, número máximo de tokens)

### 2. Funções e Plugins com LLMs
**Ficheiro**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Expanda as capacidades da IA dando aos modelos acesso a funções personalizadas e APIs externas.

Este exemplo demonstra:
- Integração de uma função de previsão do tempo
- Implementação de uma função de calculadora  
- Chamadas múltiplas de funções numa única conversa
- Definição de funções com esquemas JSON

### 3. Geração com Recuperação de Dados (RAG)
**Ficheiro**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Aprenda a combinar IA com os seus próprios documentos e fontes de dados para respostas precisas e contextuais.

Este exemplo demonstra:
- Respostas a perguntas baseadas em documentos com o Azure OpenAI SDK
- Implementação do padrão RAG com Modelos do GitHub

**Utilização**: Faça perguntas sobre o conteúdo em `document.txt` e obtenha respostas da IA baseadas apenas nesse contexto.

### 4. Demonstração de Segurança em IA Responsável
**Ficheiro**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Obtenha uma prévia de como funcionam as medidas de segurança em IA ao testar as capacidades de filtragem de conteúdo dos Modelos do GitHub.

Este exemplo demonstra:
- Filtragem de conteúdo para prompts potencialmente prejudiciais
- Gestão de respostas de segurança em aplicações
- Diferentes categorias de conteúdo bloqueado (violência, discurso de ódio, desinformação)
- Tratamento adequado de erros para violações de segurança

> **Saiba Mais**: Esta é apenas uma introdução aos conceitos de IA responsável. Para mais informações sobre ética, mitigação de preconceitos, considerações de privacidade e frameworks de IA responsável, veja [Capítulo 5: IA Generativa Responsável](../05-ResponsibleGenAI/README.md).

## Resumo

Neste capítulo, explorámos completações de LLM e fluxos de conversação, implementámos chamadas de funções para melhorar as capacidades da IA, criámos um sistema de Geração com Recuperação de Dados (RAG) e demonstrámos medidas de segurança em IA responsável.

> **NOTE**: Explore mais com o [**Tutorial**](./TUTORIAL.md)

## Próximos Passos

[Capítulo 4: Aplicações Práticas e Projetos](../04-PracticalSamples/README.md)

**Aviso Legal**:  
Este documento foi traduzido utilizando o serviço de tradução por IA [Co-op Translator](https://github.com/Azure/co-op-translator). Embora nos esforcemos pela precisão, esteja ciente de que traduções automáticas podem conter erros ou imprecisões. O documento original na sua língua nativa deve ser considerado a fonte autoritária. Para informações críticas, recomenda-se a tradução profissional realizada por humanos. Não nos responsabilizamos por quaisquer mal-entendidos ou interpretações incorretas decorrentes do uso desta tradução.