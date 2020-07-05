package fr.docjyJ.apiClientBuilder.connection

import com.google.gson.GsonBuilder
import fr.docjyJ.apiClientBuilder.anotation.QueryParameter
import fr.docjyJ.apiClientBuilder.exception.ApiClientException
import fr.docjyJ.apiClientBuilder.exception.ApiServerException
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

/**
 * Signals that an error was reached during the request to the server.
 */
abstract class RequestGetBuilder<T:ResponseTemplate>(
        private val endPointUrl: String,
        private val responseClass: Class<T>
) {
    @Throws(ApiClientException::class)
    private fun runUrl(): String {
        val parameters = StringBuilder()
        val obj = this
        obj.javaClass.declaredFields.forEach { field ->
            try {
                field.isAccessible = true
                val content = field.get(obj)?:null
                var key = field.name
                field.annotations.forEach { if(it is QueryParameter) key = it.name }
                val value = field.get(obj) ?: null
                if(value != null) {
                    parameters.append(
                            if(parameters.toString()=="")
                                "?"
                            else
                                "&" +
                            key +
                            "=" +
                            URLEncoder.encode(
                                    value.parameterToString(),
                                    StandardCharsets.UTF_8.toString()))
                }
            }
            catch (e: Throwable) {
                throw ApiClientException(ApiClientException.ENCODE_PARAMETER, e)
            }
        }
        return endPointUrl + parameters.toString()
    }

    @Throws(ApiServerException::class, ApiClientException::class)
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
            throw ApiClientException( ApiClientException.CREATE_REQUEST, e )
        }
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw ApiServerException(connection)
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
            throw ApiClientException( ApiClientException.READ_RESPONSE, e )
        }
    }

    @Throws(ApiServerException::class, ApiClientException::class)
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
            throw ApiClientException( ApiClientException.PARSE_OBJECT, e)
        }

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

    /**
     * Execute the request.
     * @return Response of request in ResponseTemplate object.
     * @throws ApiServerException When the server returns an error.
     * @throws ApiClientException When the library makes a mistake.
     */
    @Throws(ApiServerException::class, ApiClientException::class)
    fun execute() = run()

    /**
     * Execute the request.
     * @return Response of request in String object.
     * @throws ApiServerException When the server returns an error.
     * @throws ApiClientException When the library makes a mistake.
     */
    @Throws(ApiServerException::class, ApiClientException::class)
    fun executeAsString() = runAsString()

    /**
     * Show the URL.
     * @return The URL of request in String object.
     * @throws ApiClientException When the library makes a mistake.
     */
    @Throws(ApiClientException::class)
    fun getUrl() = runUrl()
}
