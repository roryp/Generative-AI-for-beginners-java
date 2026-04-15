# Practical Applications & Projects

[![Practical Applications & Projects](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Practical Applications & Projects")

> **ਵੀਡੀਓ ਦਾ ਸੰਖੇਪ:** [YouTube 'ਤੇ "Practical Applications & Projects" ਵੇਖੋ](https://www.youtube.com/watch?v=01vJsYei3H0).

## What You'll Learn
ਇਸ ਹਿੱਸੇ ਵਿੱਚ ਅਸੀਂ ਤਿੰਨ ਪ੍ਰਯੋਗਕਾਰੀ ਐਪਲੀਕੇਸ਼ਨਾਂ ਦਾ ਡੈਮੋ ਕਰਾਂਗੇ ਜੋ ਜਾਵਾ ਨਾਲ ਜਨਰੇਟਿਵ ਏਆਈ ਵਿਕਾਸ ਦੇ ਪੈਟਰਨਾਂ ਨੂੰ ਦਰਸਾਉਂਦੀਆਂ ਹਨ:
- ਕਲਾਇੰਟ-ਸਾਈਡ ਅਤੇ ਸਰਵਰ-ਸਾਈਡ ਏਆਈ ਨੂੰ ਜੋੜਦਿਆਂ ਇੱਕ ਬਹੁ-ਮੋਡਲ ਪੇਂਟ ਕਹਾਣੀ ਜੈਨਰੇਟਰ ਬਣਾਉਣਾ
- Foundry Local Spring Boot ਡੈਮੋ ਨਾਲ ਸਥਾਨਕ ਏਆਈ ਮਾਡਲ ਇੰਟੀਗ੍ਰੇਸ਼ਨ ਨੂੰ ਲਾਗੂ ਕਰਨਾ
- ਕੈਲਕੂਲੇਟਰ ਉਦਾਹਰਨ ਨਾਲ ਇੱਕ ਮਾਡਲ ਸੰਦਰਭ ਪ੍ਰੋਟੋਕੋਲ (MCP) ਸੇਵਾ ਵਿਕਸਿਤ ਕਰਨੀ

## Table of Contents

- [Introduction](#introduction)
  - [Foundry Local Spring Boot Demo](#foundry-local-spring-boot-demo)
  - [Pet Story Generator](#pet-story-generator)
  - [MCP Calculator Service (Beginner-Friendly MCP Demo)](#mcp-calculator-service-beginner-friendly-mcp-demo)
- [Learning Progression](#learning-progression)
- [Summary](#summary)
- [Next Steps](#next-steps)

## Introduction

ਇਹ ਅਧਿਆਇ **ਜ਼ਨਰੇਟਿਵ ਏਆਈ ਵਿਕਾਸ ਪੈਟਰਨਾਂ** ਨੂੰ ਜਾਵਾ ਨਾਲ ਦਰਸਾਉਂਦੇ ਉਦਾਹਰਣ ਪ੍ਰੋਜੈਕਟ ਦਰਸਾਉਂਦਾ ਹੈ। ਹਰ ਪ੍ਰੋਜੈਕਟ ਪੂਰੀ ਤਰ੍ਹਾਂ ਕਾਰਜਸ਼ੀਲ ਹੈ ਅਤੇ ਵਿਸ਼ੇਸ਼ ਏਆਈ ਤਕਨਾਲੋਜੀਆਂ, ਢਾਂਚਾਕੀ ਪੈਟਰਨ, ਅਤੇ ਬਿਹਤਰ ਅਭਿਆਸਾਂ ਨੂੰ ਦਰਸਾਉਂਦਾ ਹੈ ਜਿਨ੍ਹਾਂ ਨੂੰ ਤੁਸੀਂ ਆਪਣੇ ਐਪਲੀਕੇਸ਼ਨਾਂ ਲਈ ਅਨੁਕੂਲ ਕਰ ਸਕਦੇ ਹੋ।

### Foundry Local Spring Boot Demo

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** ਦਿਖਾਉਂਦਾ ਹੈ ਕਿ ਕਿਵੇਂ **OpenAI Java SDK** ਦੀ ਵਰਤੋਂ ਕਰਦੇ ਹੋਏ ਸਥਾਨਕ ਏਆਈ ਮਾਡਲਾਂ ਨਾਲ ਇੰਟੀਗ੍ਰੇਟ ਕੀਤਾ ਜਾ ਸਕਦਾ ਹੈ। ਇਹ Foundry Local (ਜਿਵੇਂ ਕਿ **Phi-4-mini**) 'ਤੇ ਚੱਲ ਰਹੇ ਮਾਡਲਾਂ ਨਾਲ ਜੁੜਨ ਨੂੰ ਦਰਸਾਉਂਦਾ ਹੈ, ਜਿਸ ਵਿੱਚ ਆਟੋਮੈਟਿਕ ਮਾਡਲ ਡਿਟੈਕਸ਼ਨ ਹੈ, ਜੋ ਕਿ ਤੁਹਾਨੂੰ ਕਲਾਉਡ ਸੇਵਾ ਤੇ ਨਿਰਭਰਤਾ ਬਿਨਾਂ ਏਆਈ ਐਪਲੀਕੇਸ਼ਨ ਚਲਾਉਣ ਦੀ ਆਗਿਆ ਦਿੰਦਾ ਹੈ।

### Pet Story Generator

**[Pet Story Generator](petstory/README.md)** ਇੱਕ ਮਨੋਹਰ Spring Boot ਵੈੱਬ ਐਪਲੀਕੇਸ਼ਨ ਹੈ ਜੋ ਬਹੁ-ਮੋਡਲ ਏਆਈ ਪ੍ਰੋਸੈਸਿੰਗ ਨੂੰ ਦਰਸਾਉਂਦਾ ਹੈ ਤਾਂ ਜੋ ਰਚਨਾਤਮਕ ਪੇਂਟ ਕਹਾਣੀਆਂ ਜਨਰੇਟ ਕੀਤੀਆਂ ਜਾ ਸਕਣ। ਇਹ ਕਲਾਇੰਟ-ਸਾਈਡ ਅਤੇ ਸਰਵਰ-ਸਾਈਡ ਏਆਈ ਯੋਗਤਾਵਾਂ ਨੂੰ transformer.js ਬ੍ਰਾਉਜ਼ਰ-ਅਧਾਰਿਤ ਏਆਈ ਇੰਟਰੈਕਸ਼ਨਾਂ ਅਤੇ ਸਰਵਰ-ਪਾਸੇ ਪ੍ਰੋਸੈਸਿੰਗ ਲਈ OpenAI SDK ਦੀ ਵਰਤੋਂ ਨਾਲ ਜੋੜਦਾ ਹੈ।

### MCP Calculator Service (Beginner-Friendly MCP Demo)

**[MCP Calculator Service](calculator/README.md)** ਇੱਕ ਸਧਾਰਣ ਡੈਮੋ ਹੈ ਜੋ Spring AI ਦੀ ਵਰਤੋਂ ਕਰਦਿਆਂ **Model Context Protocol (MCP)** ਨੂੰ ਦਰਸਾਉਂਦਾ ਹੈ। ਇਹ MCP ਧਾਰਨਾਵਾਂ ਦਾ शुरुआਤੀ ਦਿਸ਼ਾ-ਦਰਸ਼ਨ ਦਿੰਦਾ ਹੈ ਅਤੇ ਦਿਖਾਉਂਦਾ ਹੈ ਕਿ ਕਿਵੇਂ ਇੱਕ ਆਧਾਰਭੂਤ MCP ਸਰਵਰ ਬਣਾਇਆ ਜਾ ਸਕਦਾ ਹੈ ਜੋ MCP ਕਲਾਇੰਟਾਂ ਨਾਲ ਇੰਟਰੇਕਟ ਕਰਦਾ ਹੈ।

## Learning Progression

ਇਹ ਪ੍ਰੋਜੈਕਟ ਪਹਿਲੇ ਅਧਿਆਇਆਂ ਤੋਂ ਸਿੱਖੇ ਗਏ ਤੱਤਾਂ 'ਤੇ ਆਧਾਰਿਤ ਬਣਾਏ ਗਏ ਹਨ:

1. **ਸਧਾਰਨ ਸ਼ੁਰੂਆਤ**: Foundry Local Spring Boot ਡੈਮੋ ਨਾਲ ਮੁੱਢਲੀ ਸਥਾਨਕ ਮਾਡਲ ਇੰਟੀਗ੍ਰੇਸ਼ਨ ਸਮਝੋ
2. **ਇੰਟਰਐਕਟਿਵਟੀ ਸ਼ਾਮਲ ਕਰੋ**: Pet Story Generator ਨਾਲ ਬਹੁ-ਮੋਡਲ ਏਆਈ ਅਤੇ ਵੈੱਬ-ਧਾਰਿਤ ਇੰਟਰੈਕਸ਼ਨਾਂ ਲਈ ਅੱਗੇ ਵਧੋ
3. **MCP ਦੇ ਮੂਲ ਤੱਤ ਸਿੱਖੋ**: MCP Calculator Service ਨਾਲ Model Context Protocol ਦੀ ਆਪਣੇ ਆਪ ਸਮਝ ਬਣਾਓ

## Summary

ਸ਼ਾਬਾਸ਼! ਤੁਸੀਂ ਹੁਣ ਕੁਝ ਅਸਲ ਐਪਲੀਕੇਸ਼ਨਾਂ ਦੀ ਖੋਜ ਕਰ ਲਈ ਹੈ:

- ਬ੍ਰਾਉਜ਼ਰ ਅਤੇ ਸਰਵਰ ਦੋਹਾਂ ਲਈ ਬਹੁ-ਮੋਡਲ ਏਆਈ ਅਨੁਭਵ
- ਆਧੁਨਿਕ ਜਾਵਾ ਫਰੇਮਵਰਕਾਂ ਅਤੇ SDKs ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਸਥਾਨਕ ਏਆਈ ਮਾਡਲ ਇੰਟੀਗ੍ਰੇਸ਼ਨ
- ਤੁਹਾਡੀ ਪਹਿਲੀ Model Context Protocol ਸੇਵਾ ਤਾਂ ਜੋ ਤੁਸੀਂ ਵੇਖ ਸਕੋ ਕਿ ਕਿਵੇਂ ਟੂਲਜ਼ ਏਆਈ ਨਾਲ ਇੰਟੀਗ੍ਰੇਟ ਹੁੰਦੇ ਹਨ

## Next Steps

[Chapter 5: Responsible Generative AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ਅਸਵੀਕਾਰ:**  
ਇਹ ਦਸਤਾਵੇਜ਼ ਇੱਕ AI ਅਨੁਵਾਦ ਸੇਵਾ [Co-op Translator](https://github.com/Azure/co-op-translator) ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਅਨੁਵਾਦਿਤ ਕੀਤਾ ਗਿਆ ਹੈ। ਜਦੋਂ ਕਿ ਅਸੀਂ ਸਹੀਤਾ ਲਈ ਯਤਨਸ਼ੀਲ ਹਾਂ, ਕਿਰਪਾ ਕਰਕੇ ਇਹ ਜਾਣੋ ਕਿ ਸਵੈਚਾਲਿਤ ਅਨੁਵਾਦਾਂ ਵਿੱਚ ਗਲਤੀਆਂ ਜਾਂ ਅਸਤੀਰਤਾਵਾਂ ਹੋ ਸਕਦੀਆਂ ਹਨ। ਇਸ ਦਸਤਾਵੇਜ਼ ਦੀ ਮੂਲ ਭਾਸ਼ਾ ਵਿੱਚ ਮੂਲ ਨਕਲ ਨੂੰ ਪ੍ਰਮੁੱਖ ਸਰੋਤ ਸਮਝਣਾ ਚਾਹੀਦਾ ਹੈ। ਜਰੂਰੀ ਜਾਣਕਾਰੀ ਲਈ, ਪੇਸ਼ੇਵਰ ਮਾਨਵ ਅਨੁਵਾਦ ਦੀ ਸਿਫਾਰਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ। ਇਸ ਅਨੁਵਾਦ ਦੇ ਉਪਯੋਗ ਤੋਂ ਉਤਪੰਨ ਕਿਸੇ ਵੀ ਗਲਤਫਹਿਮੀ ਜਾਂ ਗਲਤ ਵਿਅਖਿਆਵਾਂ ਲਈ ਅਸੀਂ ਜ਼ਿੰਮੇਵਾਰ ਨਹੀਂ ਹਾਂ।
<!-- CO-OP TRANSLATOR DISCLAIMER END -->