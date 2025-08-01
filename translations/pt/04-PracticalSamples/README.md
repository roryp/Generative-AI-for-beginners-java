<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "da1b6d87b8a73306b29f9a1bdd681221",
  "translation_date": "2025-07-21T16:31:42+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "pt"
}
-->
# Aplicações Práticas & Projetos

> Nota: Cada exemplo inclui também um **TUTORIAL.md** que o orienta na execução da aplicação.

## O Que Vai Aprender
Nesta secção, iremos demonstrar três aplicações práticas que destacam padrões de desenvolvimento de IA generativa com Java:
- Criar um Gerador de Histórias de Animais de Estimação multi-modal, combinando IA no lado do cliente e do servidor
- Implementar a integração de modelos de IA locais com o exemplo Foundry Local Spring Boot
- Desenvolver um serviço Model Context Protocol (MCP) com o exemplo da Calculadora

## Índice

- [Introdução](../../../04-PracticalSamples)
  - [Exemplo Foundry Local Spring Boot](../../../04-PracticalSamples)
  - [Gerador de Histórias de Animais de Estimação](../../../04-PracticalSamples)
  - [Serviço MCP Calculadora (Exemplo MCP para Iniciantes)](../../../04-PracticalSamples)
- [Progressão de Aprendizagem](../../../04-PracticalSamples)
- [Resumo](../../../04-PracticalSamples)
- [Próximos Passos](../../../04-PracticalSamples)

## Introdução

Este capítulo apresenta **projetos de exemplo** que demonstram padrões de desenvolvimento de IA generativa com Java. Cada projeto é totalmente funcional e demonstra tecnologias de IA específicas, padrões arquiteturais e boas práticas que pode adaptar às suas próprias aplicações.

### Exemplo Foundry Local Spring Boot

O **[Exemplo Foundry Local Spring Boot](foundrylocal/README.md)** demonstra como integrar modelos de IA locais utilizando o **OpenAI Java SDK**. Mostra a ligação ao modelo **Phi-3.5-mini** em execução no Foundry Local, permitindo-lhe executar aplicações de IA sem depender de serviços na nuvem.

### Gerador de Histórias de Animais de Estimação

O **[Gerador de Histórias de Animais de Estimação](petstory/README.md)** é uma aplicação web Spring Boot envolvente que demonstra o **processamento de IA multi-modal** para gerar histórias criativas de animais de estimação. Combina capacidades de IA no lado do cliente e do servidor, utilizando o transformer.js para interações de IA no navegador e o OpenAI SDK para processamento no servidor.

### Serviço MCP Calculadora (Exemplo MCP para Iniciantes)

O **[Serviço MCP Calculadora](mcp/calculator/README.md)** é uma demonstração simples do **Model Context Protocol (MCP)** utilizando o Spring AI. Fornece uma introdução acessível aos conceitos de MCP, mostrando como criar um servidor MCP básico que interage com clientes MCP.

## Progressão de Aprendizagem

Estes projetos foram concebidos para construir conceitos com base nos capítulos anteriores:

1. **Comece Simples**: Inicie com o Exemplo Foundry Local Spring Boot para compreender a integração básica de IA com modelos locais
2. **Adicione Interatividade**: Progrida para o Gerador de Histórias de Animais de Estimação para explorar IA multi-modal e interações baseadas na web
3. **Aprenda os Fundamentos do MCP**: Experimente o Serviço MCP Calculadora para compreender os fundamentos do Model Context Protocol

## Resumo

**Parabéns!** Conseguiu com sucesso:

- **Criar experiências de IA multi-modal** combinando processamento de IA no lado do cliente e do servidor
- **Implementar a integração de modelos de IA locais** utilizando frameworks e SDKs modernos de Java
- **Desenvolver serviços Model Context Protocol** demonstrando padrões de integração de ferramentas

## Próximos Passos

[Capítulo 5: IA Generativa Responsável](../05-ResponsibleGenAI/README.md)

**Aviso Legal**:  
Este documento foi traduzido utilizando o serviço de tradução automática [Co-op Translator](https://github.com/Azure/co-op-translator). Embora nos esforcemos para garantir a precisão, esteja ciente de que traduções automáticas podem conter erros ou imprecisões. O documento original na sua língua nativa deve ser considerado a fonte oficial. Para informações críticas, recomenda-se a tradução profissional realizada por humanos. Não nos responsabilizamos por quaisquer mal-entendidos ou interpretações incorretas resultantes do uso desta tradução.