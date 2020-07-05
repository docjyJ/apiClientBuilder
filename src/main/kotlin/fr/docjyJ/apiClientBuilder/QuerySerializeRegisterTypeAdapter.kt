package fr.docjyJ.apiClientBuilder

import java.lang.reflect.Type

class QuerySerializeRegisterTypeAdapter(
        val type: Type,
        val querySerializer: QuerySerializer<Any>
)
