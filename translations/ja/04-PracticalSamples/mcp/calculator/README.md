<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "7bf9a4a832911269a8bd0decb97ff36c",
  "translation_date": "2025-07-21T16:43:51+00:00",
  "source_file": "04-PracticalSamples/mcp/calculator/README.md",
  "language_code": "ja"
}
-->
# 基本計算機MCPサービス

>**Note**: この章には、完成したサンプルを実行する手順を示す[**チュートリアル**](./TUTORIAL.md)が含まれています。

**Model Context Protocol (MCP)** を実際に体験する最初のステップへようこそ！前の章では、生成AIの基礎を学び、開発環境をセットアップしました。ここからは、実践的なものを構築していきます。

この計算機サービスは、MCPを使用してAIモデルが外部ツールと安全にやり取りする方法を示します。AIモデルの計算能力が時に信頼できない場合がある代わりに、正確な計算を行うためにAIが専門的なサービスを呼び出す堅牢なシステムを構築する方法を紹介します。

## 目次

- [学べること](../../../../../04-PracticalSamples/mcp/calculator)
- [前提条件](../../../../../04-PracticalSamples/mcp/calculator)
- [重要な概念](../../../../../04-PracticalSamples/mcp/calculator)
- [クイックスタート](../../../../../04-PracticalSamples/mcp/calculator)
- [利用可能な計算機操作](../../../../../04-PracticalSamples/mcp/calculator)
- [テストクライアント](../../../../../04-PracticalSamples/mcp/calculator)
  - [1. 直接MCPクライアント (SDKClient)](../../../../../04-PracticalSamples/mcp/calculator)
  - [2. AI駆動クライアント (LangChain4jClient)](../../../../../04-PracticalSamples/mcp/calculator)
- [MCPインスペクター (Web UI)](../../../../../04-PracticalSamples/mcp/calculator)
  - [ステップバイステップの手順](../../../../../04-PracticalSamples/mcp/calculator)

## 学べること

この例を通じて、以下を理解できます：
- Spring Bootを使用してMCP互換サービスを作成する方法
- 直接プロトコル通信とAI駆動のやり取りの違い
- AIモデルが外部ツールを使用するタイミングと方法を決定する仕組み
- ツール対応のAIアプリケーションを構築するためのベストプラクティス

MCPの概念を学び、最初のAIツール統合を構築する準備ができた初心者に最適です！

## 前提条件

- Java 21以上
- Maven 3.6以上
- **GitHubトークン**: AI駆動クライアントに必要です。まだ設定していない場合は、[第2章: 開発環境のセットアップ](../../../02-SetupDevEnvironment/README.md)を参照してください。

## 重要な概念

**Model Context Protocol (MCP)** は、AIアプリケーションが外部ツールと安全に接続するための標準化された方法です。これは、AIモデルが計算機のような外部サービスを利用できるようにする「橋渡し」のようなものです。AIモデルが自分で計算を試みる（時に信頼性が低い）代わりに、計算機サービスを呼び出して正確な結果を得ることができます。MCPは、この通信が安全かつ一貫して行われることを保証します。

**Server-Sent Events (SSE)** は、サーバーとクライアント間のリアルタイム通信を可能にします。従来のHTTPリクエストでは、リクエストを送信して応答を待つ必要がありますが、SSEではサーバーがクライアントに継続的に更新を送信できます。これは、応答がストリーミングされたり、処理に時間がかかるAIアプリケーションに最適です。

**AIツールと関数呼び出し** は、AIモデルがユーザーのリクエストに基づいて外部関数（計算機操作など）を自動的に選択して使用できるようにします。例えば、「15 + 27は？」と尋ねると、AIモデルは加算を求めていることを理解し、`add`ツールを適切なパラメータ（15, 27）で自動的に呼び出し、自然言語で結果を返します。AIは、各ツールをいつどのように使用するかを知っているインテリジェントなコーディネーターとして機能します。

## クイックスタート

### 1. 計算機アプリケーションディレクトリに移動
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/mcp/calculator
```

### 2. ビルド＆実行
```bash
mvn clean install -DskipTests
java -jar target/calculator-server-0.0.1-SNAPSHOT.jar
```

### 3. クライアントでテスト
- **SDKClient**: MCPプロトコルを直接操作
- **LangChain4jClient**: AI駆動の自然言語インタラクション（GitHubトークンが必要）

## 利用可能な計算機操作

- `add(a, b)`, `subtract(a, b)`, `multiply(a, b)`, `divide(a, b)`
- `power(base, exponent)`, `squareRoot(number)`, `absolute(number)`
- `modulus(a, b)`, `help()`

## テストクライアント

### 1. 直接MCPクライアント (SDKClient)
MCPプロトコル通信を直接テストします。以下で実行：
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

### 2. AI駆動クライアント (LangChain4jClient)
GitHubモデルを使用した自然言語インタラクションをデモします。GitHubトークンが必要（[前提条件](../../../../../04-PracticalSamples/mcp/calculator)を参照）。

**実行:**
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

## MCPインスペクター (Web UI)

MCPインスペクターは、コードを書かずにMCPサービスをテストできるビジュアルなWebインターフェースを提供します。MCPの仕組みを理解するのに最適です！

### ステップバイステップの手順

1. **計算機サーバーを起動**（まだ起動していない場合）：
   ```bash
   java -jar target/calculator-server-0.0.1-SNAPSHOT.jar
   ```

2. **MCPインスペクターをインストールして実行** 新しいターミナルで：
   ```bash
   npx @modelcontextprotocol/inspector
   ```

3. **Webインターフェースを開く**：
   - "Inspector running at http://localhost:6274" のようなメッセージを探します
   - そのURLをブラウザで開きます

4. **計算機サービスに接続**：
   - Webインターフェースで、トランスポートタイプを「SSE」に設定
   - URLを `http://localhost:8080/sse` に設定
   - 「Connect」ボタンをクリック

5. **利用可能なツールを探索**：
   - 「List Tools」をクリックして、すべての計算機操作を確認
   - `add`, `subtract`, `multiply` などの関数が表示されます

6. **計算機操作をテスト**：
   - ツールを選択（例: "add"）
   - パラメータを入力（例: `a: 15`, `b: 27`）
   - 「Run Tool」をクリック
   - MCPサービスから返された結果を確認！

このビジュアルなアプローチにより、MCP通信の仕組みを理解した上で、自分のクライアントを構築する準備が整います。

![npx inspector](../../../../../translated_images/tool.214c70103694335c4cfdc2d624373dfce4b0162f6aea089ac1da9051fb563b7f.ja.png)

---
**参考:** [MCP Server Boot Starter Docs](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-server-boot-starter-docs.html)

**免責事項**:  
この文書は、AI翻訳サービス [Co-op Translator](https://github.com/Azure/co-op-translator) を使用して翻訳されています。正確性を追求しておりますが、自動翻訳には誤りや不正確な部分が含まれる可能性があることをご承知ください。元の言語で記載された文書が正式な情報源とみなされるべきです。重要な情報については、専門の人間による翻訳を推奨します。この翻訳の使用に起因する誤解や誤認について、当方は一切の責任を負いません。