[apiClientBuilder](../../index.md) / [fr.docjyJ.apiClientBuilder](../index.md) / [RequestGetBuilder](./index.md)

# RequestGetBuilder

`abstract class RequestGetBuilder<T : `[`ResponseTemplate`](../-response-template.md)`>` [(source)](https://github.com/docjyj/apiClientBuilder/tree/master/src/main/kotlin/fr/docjyJ/apiClientBuilder/RequestGetBuilder.kt#L25)

The Request class for the method Get.

### Parameters

`T` - the Type of the response.

`endPointUrl` - The url of the request.

`responseClass` - the Type of the response.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | The Request class for the method Get.`RequestGetBuilder(endPointUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, responseClass: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>)` |

### Properties

| Name | Summary |
|---|---|
| [connectionApply](connection-apply.md) | Customize the object ABC that makes the request`var connectionApply: `[`HttpURLConnection`](https://docs.oracle.com/javase/6/docs/api/java/net/HttpURLConnection.html)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [gsonTypeAdapter](gson-type-adapter.md) | Add type adapter for Gson.`var gsonTypeAdapter: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`JsonDeserializeRegisterTypeAdapter`](../-json-deserialize-register-type-adapter/index.md)`>?` |
| [queryTypeAdapter](query-type-adapter.md) | Add type adapter for Query.`var queryTypeAdapter: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`QuerySerializeRegisterTypeAdapter`](../-query-serialize-register-type-adapter/index.md)`>?` |

### Functions

| Name | Summary |
|---|---|
| [execute](execute.md) | Execute the request.`open fun execute(): T` |
| [executeAsString](execute-as-string.md) | Execute the request.`open fun executeAsString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getUrl](get-url.md) | Show the URL.`open fun getUrl(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
