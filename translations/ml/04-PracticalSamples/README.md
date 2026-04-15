# Practical Applications & Projects

[![Practical Applications & Projects](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Practical Applications & Projects")

> **Video അവലോകനം:** [YouTube ലെ "Practical Applications & Projects" കാണുക](https://www.youtube.com/watch?v=01vJsYei3H0).

## What You'll Learn
ഈ വിഭാഗത്തിൽ ഞങ്ങൾ ജാവയോടെ ജനറേറ്റീവ് AI വികസന മാതൃകകൾ പ്രദർശിപ്പിക്കുന്ന മൂന്ന് പ്രായോഗിക അപേക്ഷകൾ ഡെമോ ചെയ്യുകയാണ്:
- ക്ലയന്റ്-സൈഡ്, സെർവർ-സൈഡ് AI സംയോജിപ്പിച്ച് ബഹു-മോഡൽ പെറ്റ് സ്റ്റോറി ജനറേറ്റർ സൃഷ്ടിക്കുക
- Foundry Local Spring Boot ഡെമോയുമായുള്ള പ്രാദേശിക AI മോഡൽ സംയോജിപ്പ് നടപ്പിലാക്കുക
- കാൽക്കുലേറ്റർ ഉദാഹരണത്തോടെ ഒരു മോഡൽ കോൺടെക്‌സ് പ്രോട്ടോക്കോൾ (MCP) സേവനം വികസിപ്പിക്കുക

## Table of Contents

- [Introduction](#introduction)
  - [Foundry Local Spring Boot Demo](#foundry-local-spring-boot-demo)
  - [Pet Story Generator](#pet-story-generator)
  - [MCP Calculator Service (Beginner-Friendly MCP Demo)](#mcp-calculator-service-beginner-friendly-mcp-demo)
- [Learning Progression](#learning-progression)
- [Summary](#summary)
- [Next Steps](#next-steps)

## Introduction

ഈ അധ್ಯಾಯം ജാവയോടുള്ള ജനറേറ്റീവ് AI വികസന മാതൃകകൾ പ്രദർശിപ്പിക്കുന്ന **നമൂനാ പ്രോജക്റ്റുകൾ** കാണിക്കുന്നു. ഓരോ പ്രോജക്റ്റും പൂർണ്ണമായും പ്രവർത്തനക്ഷമമാണ്, AI സാങ്കേതികവിദ്യകൾ, സാങ്കേതിക മാതൃകകൾ, മികച്ച പ്രാക്ടീസുകൾ എന്നിവ അവതരിപ്പിക്കുന്നു, നിങ്ങളുടെ സ്വന്തം ആപ്ലിക്കേഷനുകൾക്കായി നിങ്ങൾ ആസ്വദിക്കാവുന്നതാണ്.

### Foundry Local Spring Boot Demo

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** OpenAI Java SDK ഉപയോഗിച്ച് പ്രാദേശിക AI മോഡലുകളുമായി എങ്ങനെ സംയോജിപ്പിക്കാമെന്ന് കാണിക്കുന്നു. Foundry Local-ൽ പ്രവർത്തിക്കുന്ന **Phi-3.5-mini** മോഡലിൽ കണക്ട് ചെയ്യുന്നത് പ്രദർശിപ്പിക്കുന്നു, ഇത് ക്ലൗഡ് സേവനങ്ങളിൽ ആശ്രയിക്കാതെ AI ആപ്ലിക്കേഷനുകൾ പ്രവർത്തിപ്പിക്കാൻ അനുവദിക്കുന്നു.

### Pet Story Generator

**[Pet Story Generator](petstory/README.md)** ഒരു ആകർഷകമായ Spring Boot വെബ് ആപ്ലിക്കേഷൻ ആണ്, ഇത് സൃഷ്ടിപരമായ പെറ്റ് കഥകൾ ഉണ്ടാക്കാൻ **ബഹു-മോഡൽ AI പ്രോസസ്സിങ്** പ്രദർശിപ്പിക്കുന്നു. ഇത് ബ്രൗസർ-അടിസ്ഥാന AI ഇടപെടലുകൾക്കായി transformer.js-ഉം സെർവർ-സൈഡ് പ്രോസസ്സിംഗിനായി OpenAI SDK-ഉം ഉപയോഗിച്ച് ക്ലയന്റ്-സൈഡ്, സെർവർ-സൈഡ് AI കഴിവുകൾ ചേരുന്നു.

### MCP Calculator Service (Beginner-Friendly MCP Demo)

**[MCP Calculator Service](calculator/README.md)** Spring AI ഉപയോഗിച്ച് **Model Context Protocol (MCP)**-നുള്ള ലളിതമായ ഒരു ഡെമോ ആണ്. ഇത് MCP ആശയങ്ങളിലേക്കുള്ള തുടക്കക്കാരുടെ പരിചയപ്പെടുത്തലും കൂടിയാണ്, MCP ക്ലയന്റുകളുമായി സംവദിക്കുന്ന ഒളയ MCP Server സൃഷ്ടിക്കുവാനുള്ള മാർഗ്ഗങ്ങൾ കാണിക്കുന്നു.

## Learning Progression

ഈ പ്രോജക്റ്റുകൾ മുൻ‌നിര അധ്യായങ്ങളിൽ നിന്നുള്ള ആശയങ്ങളെ അടിസ്ഥാനമാക്കി നിർമ്മിച്ചവയാണ്:

1. **സാധാരണമായി ആരംഭിക്കുക**: പ്രാദേശിക മോഡലുകളുമായി അടിസ്ഥാന AI സംയോജിപ്പ് മനസ്സിലാക്കാൻ Foundry Local Spring Boot Demo ആരംഭിക്കുക
2. **ഇടപെടൽ കൂട്ടുക**: ബഹു-മോഡൽ AI, വെബ്-അടിസ്ഥാന ഇടപെടലുകൾക്കായി Pet Story Generator-ലേക്ക് മുന്നോട്ട് പോവുക
3. **MCP അടിസ്ഥാനങ്ങൾ പഠിക്കുക**: Model Context Protocol തത്വങ്ങൾ മനസ്സിലാക്കാൻ MCP Calculator Service ശ്രമിക്കുക

## Summary

നല്ല ജോബ്! നിങ്ങൾ ഇപ്പോൾ ചില യാഥാർത്ഥ ജീവിത അപേക്ഷകൾ പരിശോധിച്ചു:

- ബ്രൗസറും സെർവറും ഇരുവകയും പ്രവർത്തിക്കുന്ന ബഹു-മോഡൽ AI അനുഭവങ്ങൾ
- ആധുനിക ജावा ഫ്രെയിംവർക്കുകളും SDK-കളും ഉപയോഗിച്ച് പ്രാദേശിക AI മോഡൽ സംയോജിപ്പ്
- കൈകൾ ഉപയോഗിച്ച് എങ്ങനെ ടൂളുകൾ AI-യുമായി സംയോജിപ്പിക്കാമെന്ന് കാണിക്കുന്ന നിങ്ങളുടെ ആദ്യ Model Context Protocol സേവനം

## Next Steps

[Chapter 5: Responsible Generative AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**പരിഭവനോട്ടം**:  
ഈ ഡോക്യുമെന്റ് [Co-op Translator](https://github.com/Azure/co-op-translator) എന്ന AI പരിഭാഷാ സേവനം ഉപയോഗിച്ച് പരിഭാഷചെയ്‌തിരിക്കുന്നു. നമുക്ക് പരമാവധി കൃത്യത നേടാൻ ശ്രമിച്ചിട്ടുണ്ടെങ്കിലും, സ്വയം പ്രവർത്തിക്കുന്ന പരിഭാഷകളിൽ പിഴവുകൾ അല്ലെങ്കിൽ അസത്യതകൾ ഉണ്ടാകാം എന്ന് ദയവായി ശ്രദ്ധിക്കുക. അടിയന്തര വിവരങ്ങൾക്ക്, പ്രൊഫഷണൽ മനുഷ്യ പരിഭാഷ ശുപാർശ ചെയ്യുന്നു. ഈ പരിഭാഷ ഉപയോഗത്തിൽ നിന്നുണ്ടാകുന്ന ഏതെങ്കിലും തെറ്റിദ്ധാരണകൾക്കോ വ്യവഹാരക്കുഴപ്പങ്ങൾക്കോ ഞങ്ങൾ ഉത്തരവാദികളല്ല.  
മൂല ദസ്താവേജിന്റെ പ്രാധാന്യമുള്ള ഭാഷ മാത്രമേ ആധികാരിക উৎসമായി കണക്കാക്കേണ്ടതുള്ളൂ.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->