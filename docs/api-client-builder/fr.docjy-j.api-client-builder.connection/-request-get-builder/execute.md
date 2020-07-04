[apiClientBuilder](../../index.md) / [fr.docjyJ.apiClientBuilder.connection](../index.md) / [RequestGetBuilder](index.md) / [execute](./execute.md)

# execute

`fun execute(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) [(source)](https://github.com/docjyj/apiClientBuilder/tree/master/src/main/kotlin/fr.docjyJ.apiClientBuilder/connection/RequestGetBuilder.kt#L46)

Execute the request.

### Exceptions

`ServerException` - When the server returns an error.

`ClientException` - When the library makes a mistake.

**Return**
Response of request in String object.

`fun <T : `[`ResponseTemplate`](../-response-template.md)`> execute(classOfT: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>): T` [(source)](https://github.com/docjyj/apiClientBuilder/tree/master/src/main/kotlin/fr.docjyJ.apiClientBuilder/connection/RequestGetBuilder.kt#L94)

Execute the request.

### Parameters

`T` - Type of response

`classOfT` - Class of [T](execute.md#T) object.

### Exceptions

`ServerException` - When the server returns an error.

`ClientException` - When the library makes a mistake.

**Return**
Response of request in [T](execute.md#T) object.

