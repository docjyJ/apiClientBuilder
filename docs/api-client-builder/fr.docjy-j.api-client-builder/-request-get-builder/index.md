[apiClientBuilder](../../index.md) / [fr.docjyJ.apiClientBuilder](../index.md) / [RequestGetBuilder](./index.md)

# RequestGetBuilder

`abstract class RequestGetBuilder<T : `[`ResponseTemplate`](../-response-template.md)`>` [(source)](https://github.com/docjyj/apiClientBuilder/tree/master/src/main/kotlin/fr/docjyJ/apiClientBuilder/RequestGetBuilder.kt#L18)

Signals that an error was reached during the request to the server.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Signals that an error was reached during the request to the server.`RequestGetBuilder(endPointUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, responseClass: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>)` |

### Properties

| Name | Summary |
|---|---|
| [gsonTypeAdapter](gson-type-adapter.md) | `var gsonTypeAdapter: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`JsonDeserializeRegisterTypeAdapter`](../-json-deserialize-register-type-adapter/index.md)`>?` |
| [queryTypeAdapter](query-type-adapter.md) | `var queryTypeAdapter: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`QuerySerializeRegisterTypeAdapter`](../-query-serialize-register-type-adapter/index.md)`>?` |

### Functions

| Name | Summary |
|---|---|
| [connectionApply](connection-apply.md) | Edit the HttpURLConnection object.`open fun `[`HttpURLConnection`](https://docs.oracle.com/javase/6/docs/api/java/net/HttpURLConnection.html)`.connectionApply(): `[`HttpURLConnection`](https://docs.oracle.com/javase/6/docs/api/java/net/HttpURLConnection.html) |
| [execute](execute.md) | Execute the request.`open fun execute(): T` |
| [executeAsString](execute-as-string.md) | Execute the request.`open fun executeAsString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getUrl](get-url.md) | Show the URL.`open fun getUrl(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [parameterToString](parameter-to-string.md) | Build parametres with no String class.`abstract fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.parameterToString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
