<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "139c227ef39d24287257d1aff6fc6973",
  "translation_date": "2025-07-25T09:20:34+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "pt"
}
-->
# Aplicações Práticas e Projetos

> Nota: Cada exemplo inclui também um **TUTORIAL.md** que o orienta na execução dos exemplos.

## O Que Vai Aprender
Nesta secção, vamos demonstrar três aplicações práticas que ilustram padrões de desenvolvimento de IA generativa com Java:
- Criar um Gerador de Histórias de Animais de Estimação multi-modal, combinando IA no lado do cliente e do servidor
- Implementar a integração de modelos de IA locais com o exemplo Foundry Local Spring Boot
- Desenvolver um serviço de Protocolo de Contexto de Modelo (MCP) com o exemplo da Calculadora

## Índice

- [Introdução](../../../04-PracticalSamples)
  - [Exemplo Foundry Local Spring Boot](../../../04-PracticalSamples)
  - [Gerador de Histórias de Animais de Estimação](../../../04-PracticalSamples)
  - [Serviço MCP Calculadora (Demonstração MCP para Iniciantes)](../../../04-PracticalSamples)
- [Progressão de Aprendizagem](../../../04-PracticalSamples)
- [Resumo](../../../04-PracticalSamples)
- [Próximos Passos](../../../04-PracticalSamples)

## Introdução

Este capítulo apresenta **projetos de exemplo** que demonstram padrões de desenvolvimento de IA generativa com Java. Cada projeto é totalmente funcional e ilustra tecnologias específicas de IA, padrões arquiteturais e boas práticas que pode adaptar às suas próprias aplicações.

### Exemplo Foundry Local Spring Boot

O **[Exemplo Foundry Local Spring Boot](foundrylocal/README.md)** demonstra como integrar modelos de IA locais utilizando o **OpenAI Java SDK**. Mostra como conectar ao modelo **Phi-3.5-mini** em execução no Foundry Local, permitindo-lhe executar aplicações de IA sem depender de serviços na nuvem.

### Gerador de Histórias de Animais de Estimação

O **[Gerador de Histórias de Animais de Estimação](petstory/README.md)** é uma aplicação web Spring Boot envolvente que demonstra o **processamento de IA multi-modal** para gerar histórias criativas de animais de estimação. Combina capacidades de IA no lado do cliente e do servidor, utilizando o transformer.js para interações de IA no navegador e o OpenAI SDK para processamento no lado do servidor.

### Serviço MCP Calculadora (Demonstração MCP para Iniciantes)

O **[Serviço MCP Calculadora](mcp/calculator/README.md)** é uma demonstração simples do **Protocolo de Contexto de Modelo (MCP)** utilizando Spring AI. Fornece uma introdução acessível aos conceitos de MCP, mostrando como criar um servidor MCP básico que interage com clientes MCP.

## Progressão de Aprendizagem

Estes projetos foram concebidos para construir conceitos com base nos capítulos anteriores:

1. **Comece Simples**: Inicie com o Exemplo Foundry Local Spring Boot para compreender a integração básica de IA com modelos locais
2. **Adicione Interatividade**: Progrida para o Gerador de Histórias de Animais de Estimação para explorar IA multi-modal e interações baseadas na web
3. **Aprenda os Fundamentos do MCP**: Experimente o Serviço MCP Calculadora para compreender os conceitos básicos do Protocolo de Contexto de Modelo

## Resumo

**Parabéns!** Conseguiu:

- **Criar experiências de IA multi-modal** combinando processamento de IA no lado do cliente e do servidor
- **Implementar a integração de modelos de IA locais** utilizando frameworks e SDKs modernos de Java
- **Desenvolver serviços de Protocolo de Contexto de Modelo** demonstrando padrões de integração de ferramentas

## Próximos Passos

[Capítulo 5: IA Generativa Responsável](../05-ResponsibleGenAI/README.md)

**Aviso Legal**:  
Este documento foi traduzido utilizando o serviço de tradução por IA [Co-op Translator](https://github.com/Azure/co-op-translator). Embora nos esforcemos pela precisão, esteja ciente de que traduções automáticas podem conter erros ou imprecisões. O documento original na sua língua nativa deve ser considerado a fonte autoritária. Para informações críticas, recomenda-se a tradução profissional realizada por humanos. Não nos responsabilizamos por quaisquer mal-entendidos ou interpretações incorretas decorrentes do uso desta tradução.