package fr.docjyJ.apiClientBuilder

import java.lang.reflect.Type

/**
 * The class to register a type adapter for Query.
 *
 * @property type Type of object to adapt.
 * @property querySerializer Class TypeAdapter.
 */
class QuerySerializeRegisterTypeAdapter(
        val type: Type,
        val querySerializer: QuerySerializer<*>
)
