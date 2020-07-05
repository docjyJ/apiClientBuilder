package fr.docjyJ.apiClientBuilder

import java.lang.reflect.Type


interface QuerySerializer<T> {
    fun serialize(src: T, typeOfSrc: Type): String
}
