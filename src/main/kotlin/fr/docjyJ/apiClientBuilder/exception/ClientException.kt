package fr.docjyJ.apiClientBuilder.exception

/**
 * Indicates that an error was reached during a library action.
 */
class ClientException internal constructor(message: String, cause: Throwable) : Exception(message, cause){
    companion object{
        internal const val ENDPOINT_URL_NULL = "endpoint url cant be null"
        internal const val ENDPOINT_URL_STRING = "endpoint url must be a String"
        internal const val TO_MANY_ENDPOINT_URL = "To many endpoint url"
        internal const val ENCODE_DATE = "Unable to encode the date parameter."
        internal const val ENCODE_PARAMETER = "Unable to encode the parameter."
        internal const val PARSE_OBJECT = "Unable to parse the response."
        internal const val READ_RESPONSE = "Unable to read the response."
        internal const val CREATE_REQUEST = "Unable to create the request."
    }
}
