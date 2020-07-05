[apiClientBuilder](../../index.md) / [fr.docjyJ.apiClientBuilder.connection](../index.md) / [RequestGetBuilder](./index.md)

# RequestGetBuilder

`abstract class RequestGetBuilder<T : `[`ResponseTemplate`](../-response-template.md)`>` [(source)](https://github.com/docjyj/apiClientBuilder/tree/master/src/main/kotlin/fr/docjyJ/apiClientBuilder/connection/RequestGetBuilder.kt#L19)

Signals that an error was reached during the request to the server.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Signals that an error was reached during the request to the server.`RequestGetBuilder(responseClass: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>)` |

### Functions

| Name | Summary |
|---|---|
| [connectionApply](connection-apply.md) | Edit the HttpURLConnection object.`abstract fun `[`HttpURLConnection`](https://docs.oracle.com/javase/6/docs/api/java/net/HttpURLConnection.html)`.connectionApply(): `[`HttpURLConnection`](https://docs.oracle.com/javase/6/docs/api/java/net/HttpURLConnection.html) |
| [customGson](custom-gson.md) | Edit the Gson object.`abstract fun GsonBuilder.customGson(): GsonBuilder` |
| [execute](execute.md) | Execute the request.`fun execute(): T` |
| [executeAsString](execute-as-string.md) | Execute the request.`fun executeAsString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getUrl](get-url.md) | Show the URL.`fun getUrl(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [parameterToString](parameter-to-string.md) | Build parametres with no String class.`abstract fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.parameterToString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
