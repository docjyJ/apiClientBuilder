[apiClientBuilder](../../index.md) / [fr.docjyJ.apiClientBuilder.connection](../index.md) / [RequestGetBuilder](./index.md)

# RequestGetBuilder

`abstract class RequestGetBuilder` [(source)](https://github.com/docjyj/apiClientBuilder/tree/master/src/main/kotlin/fr.docjyJ.apiClientBuilder/connection/RequestGetBuilder.kt#L21)

Signals that an error was reached during the request to the server.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Signals that an error was reached during the request to the server.`RequestGetBuilder()` |

### Properties

| Name | Summary |
|---|---|
| [parameters](parameters.md) | The parameters of the request.`val parameters: `[`StringBuilder`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-string-builder/index.html) |

### Functions

| Name | Summary |
|---|---|
| [addParameter](add-parameter.md) | Append key on the Parameters StringBuilder.`fun addParameter(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [connectionApply](connection-apply.md) | Edit the HttpURLConnection object.`abstract fun `[`HttpURLConnection`](https://docs.oracle.com/javase/6/docs/api/java/net/HttpURLConnection.html)`.connectionApply(): `[`HttpURLConnection`](https://docs.oracle.com/javase/6/docs/api/java/net/HttpURLConnection.html) |
| [customGson](custom-gson.md) | Edit the Gson object.`abstract fun GsonBuilder.customGson(): GsonBuilder` |
| [execute](execute.md) | Execute the request.`fun execute(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>`fun <T : `[`ResponseTemplate`](../-response-template.md)`> execute(classOfT: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>): T` |
| [getUrl](get-url.md) | Set the URL.`abstract fun getUrl(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
