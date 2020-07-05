package fr.docjyJ.apiClientBuilder.connection

import com.google.gson.GsonBuilder
import fr.docjyJ.apiClientBuilder.anotation.EndpointURL
import fr.docjyJ.apiClientBuilder.anotation.QueryParameter
import fr.docjyJ.apiClientBuilder.exception.ClientException
import fr.docjyJ.apiClientBuilder.exception.ServerException
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.UnsupportedEncodingException
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

/**
 * Signals that an error was reached during the request to the server.
 */
abstract class RequestGetBuilder<T:ResponseTemplate>(private val responseClass: Class<T>)  {


    private fun runUrl(): String {
        val parameters = StringBuilder()
        var endPointUrl:String? = null
        val obj = this
        obj.javaClass.declaredFields.forEach { field ->
            field.isAccessible = true
            val content = field.get(obj)?:null
            field.apply { println("$name-$type-${content?.javaClass}") }
            field.annotations.forEach {
                when (it) {
                    is QueryParameter ->{
                        val value = field.get(obj) ?: null
                        val key = it.name
                        if(value != null) {
                            try { parameters.append("${if(parameters.toString()=="")"?" else "&"}$key=${URLEncoder.encode(value.parameterToString(), StandardCharsets.UTF_8.toString())}") }
                            catch (e: UnsupportedEncodingException) { throw Exception(ClientException.ENCODE_PARAMETER, e) }
                        }
                    }
                    is EndpointURL ->when {
                        endPointUrl != null -> throw Exception(ClientException.TO_MANY_ENDPOINT_URL)
                        //content != null -> throw Exception(ClientException.ENDPOINT_URL_NULL)
                        //content is String -> throw Exception(ClientException.ENDPOINT_URL_STRING)
                        else -> endPointUrl = content!! as String
                    }

                }
            }
        }
        return endPointUrl + parameters.toString()
    }

    /**
     * Edit the HttpURLConnection object.
     */
    abstract fun HttpURLConnection.connectionApply():HttpURLConnection

    /**
     * Edit the Gson object.
     */
    abstract fun GsonBuilder.customGson(): GsonBuilder

    /**
     * Build parametres with no String class.
     */
    abstract fun Any.parameterToString(): String

    @Throws(ServerException::class, ClientException::class)
    private fun runAsString():String {
        // Vars
        val responseCode: Int
        val connection: HttpURLConnection

        // Create the request
        try {
            connection = (URL(runUrl()).openConnection() as HttpURLConnection)
                .apply {
                    connectionApply()
                    setRequestProperty("accept", "application/json")
                    requestMethod = "GET"
                    responseCode = this.responseCode
                }
        }

        // block exception
        catch (e: Throwable){
            throw ClientException( ClientException.CREATE_REQUEST, e )
        }
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw ServerException(connection)
        }

        // Read the response and return
        return try {
            StringBuffer().apply {
                BufferedReader(InputStreamReader(connection.inputStream)).readLines().forEach {
                    append(it)
                }
            }.toString()
        }

        // block exception
        catch (e: Throwable){
            throw ClientException( ClientException.READ_RESPONSE, e )
        }
    }

    @Throws(ServerException::class, ClientException::class)
    private fun run():T {
        //Get the response
        val  obj = runAsString()

        //Transforme
        return try {
            GsonBuilder()
                .customGson()
                .create()
                .fromJson(obj, responseClass)
        }

        // block exception
        catch (e : Throwable){
            throw ClientException( ClientException.PARSE_OBJECT, e)
        }

    }

    /**
     * Execute the request.
     * @return Response of request in ResponseTemplate object.
     * @throws ServerException When the server returns an error.
     * @throws ClientException When the library makes a mistake.
     */
    @Throws(ServerException::class, ClientException::class)
    fun execute() = run()

    /**
     * Execute the request.
     * @return Response of request in String object.
     * @throws ServerException When the server returns an error.
     * @throws ClientException When the library makes a mistake.
     */
    @Throws(ServerException::class, ClientException::class)
    fun executeAsString() = runAsString()

    /**
     * Show the URL.
     * @return The URL of request in String object.
     * @throws ClientException When the library makes a mistake.
     */
    @Throws(ClientException::class)
    fun getUrl() = runUrl()
}
