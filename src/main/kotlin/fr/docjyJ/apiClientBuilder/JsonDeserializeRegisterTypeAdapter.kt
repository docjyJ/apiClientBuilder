package fr.docjyJ.apiClientBuilder

import com.google.gson.JsonDeserializer
import java.lang.reflect.Type

class JsonDeserializeRegisterTypeAdapter(
        val type: Type,
        val jsonDeserializer: JsonDeserializer<Any>
)
