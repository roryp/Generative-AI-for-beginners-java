# Basic Calculator MCP Service

>**Note**: This chapter includes a [**Tutorial**](./TUTORIAL.md) that guides you through the samples.

Welcome to your first hands-on experience with the **Model Context Protocol (MCP)**! In the previous chapters, you've learned about generative AI fundamentals and set up your development environment. Now it's time to build something practical.

This calculator service demonstrates how AI models can securely interact with external tools using MCP. Instead of relying on the AI model's sometimes unreliable math capabilities, we'll show how to build a robust system where AI can call specialized services for accurate calculations.

## Table of Contents

- [What You'll Learn](#what-youll-learn)
- [Prerequisites](#prerequisites)
- [Key Concepts](#key-concepts)
- [Quick Start](#quick-start)
- [Available Calculator Operations](#available-calculator-operations)
- [Test Clients](#test-clients)
  - [1. Direct MCP Client (SDKClient)](#1-direct-mcp-client-sdkclient)
  - [2. AI-Powered Client (LangChain4jClient)](#2-ai-powered-client-langchain4jclient)
- [MCP Inspector (Web UI)](#mcp-inspector-web-ui)
  - [Step-by-Step Instructions](#step-by-step-instructions)

## What You'll Learn

By working through this example, you'll understand:
- How to create MCP-compatible services using Spring Boot
- The difference between direct protocol communication and AI-powered interaction
- How AI models decide when and how to use external tools
- Best practices for building tool-enabled AI applications

Perfect for beginners learning MCP concepts and ready to build their first AI tool integration!

## Prerequisites

- Java 21+
- Maven 3.6+
- **GitHub Token**: Required for the AI-powered client. If you haven't set this up yet, see [Chapter 2: Setting up your development environment](../../../02-SetupDevEnvironment/README.md) for instructions.

## Key Concepts

**Model Context Protocol (MCP)** is a standardized way for AI applications to securely connect to external tools. Think of it as a "bridge" that allows AI models to use external services like our calculator. Instead of the AI model trying to do math itself (which can be unreliable), it can call our calculator service to get accurate results. MCP ensures this communication happens safely and consistently.

**Server-Sent Events (SSE)** enables real-time communication between the server and clients. Unlike traditional HTTP requests where you ask and wait for a response, SSE allows the server to continuously send updates to the client. This is perfect for AI applications where responses might be streamed or take time to process.

**AI Tools & Function Calling** allow AI models to automatically choose and use external functions (like calculator operations) based on user requests. When you ask "What's 15 + 27?", the AI model understands you want addition, automatically calls our `add` tool with the right parameters (15, 27), and returns the result in natural language. The AI acts as an intelligent coordinator that knows when and how to use each tool.

## Quick Start

### 1. Navigate to the calculator application directory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/mcp/calculator
```

### 2. Build & Run
```bash
mvn clean install -DskipTests
java -jar target/calculator-server-0.0.1-SNAPSHOT.jar
```

### 2. Test with Clients
- **SDKClient**: Direct MCP protocol interaction
- **LangChain4jClient**: AI-powered natural language interaction (requires GitHub token)

## Available Calculator Operations

- `add(a, b)`, `subtract(a, b)`, `multiply(a, b)`, `divide(a, b)`
- `power(base, exponent)`, `squareRoot(number)`, `absolute(number)`
- `modulus(a, b)`, `help()`

## Test Clients

### 1. Direct MCP Client (SDKClient)
Tests raw MCP protocol communication. Run with:
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

### 2. AI-Powered Client (LangChain4jClient)
Demonstrates natural language interaction with GitHub Models. Requires GitHub token (see [Prerequisites](#prerequisites)).

**Run:**
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

## MCP Inspector (Web UI)

MCP Inspector provides a visual web interface to test your MCP service without writing code. Perfect for beginners to understand how MCP works!

### Step-by-Step Instructions:

1. **Start the calculator server** (if not already running):
   ```bash
   java -jar target/calculator-server-0.0.1-SNAPSHOT.jar
   ```

2. **Install and run MCP Inspector** in a new terminal:
   ```bash
   npx @modelcontextprotocol/inspector
   ```

3. **Open the web interface**:
   - Look for a message like "Inspector running at http://localhost:6274"
   - Open that URL in your web browser

4. **Connect to your calculator service**:
   - In the web interface, set the transport type to "SSE"
   - Set the URL to: `http://localhost:8080/sse`
   - Click the "Connect" button

5. **Explore available tools**:
   - Click "List Tools" to see all calculator operations
   - You'll see functions like `add`, `subtract`, `multiply`, etc.

6. **Test a calculator operation**:
   - Select a tool (e.g., "add")
   - Enter parameters (e.g., `a: 15`, `b: 27`)
   - Click "Run Tool"
   - See the result returned by your MCP service!

This visual approach helps you understand exactly how MCP communication works before building your own clients.

![npx inspector](./images/tool.png)

---
**Reference:** [MCP Server Boot Starter Docs](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-server-boot-starter-docs.html)

