package fr.docjyJ.apiClientBuilder

import com.google.gson.JsonDeserializer
import java.lang.reflect.Type

/**
 * The class to register a type adapter for Gson.
 *
 * @property type Type of object to adapt.
 * @property jsonDeserializer Class TypeAdapter.
 */
class JsonDeserializeRegisterTypeAdapter(
        val type: Type,
        val jsonDeserializer: JsonDeserializer<*>
)
