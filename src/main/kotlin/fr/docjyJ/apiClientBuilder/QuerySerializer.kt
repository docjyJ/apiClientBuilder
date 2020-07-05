package fr.docjyJ.apiClientBuilder

import java.lang.reflect.Type

/**
 * The TypeAdapter to Query class.
 *
 * @param T Type of object to adapt.
 */
interface QuerySerializer<T> {
    /**
     * The TypeAdapter to Query class.
     *
     * @param src Object to Adapt.
     * @param typeOfSrc Type of object to adapt.
     *
     * @return The String for the URL query.
     */
    fun serialize(src: T, typeOfSrc: Type): String
}
