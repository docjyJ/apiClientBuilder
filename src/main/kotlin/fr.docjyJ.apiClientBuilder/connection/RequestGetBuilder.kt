package fr.docjyJ.apiClientBuilder.connection

import com.google.gson.GsonBuilder
import fr.docjyJ.apiClientBuilder.exception.ClientException
import fr.docjyJ.apiClientBuilder.exception.ServerException
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.UnsupportedEncodingException
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Signals that an error was reached during the request to the server.
 *
 * @property parameters The parameters of the request.
 */
abstract class RequestGetBuilder {
    val parameters = StringBuilder()

    /**
     * Set the URL.
     */
    abstract fun getUrl():String

    /**
     * Edit the HttpURLConnection object.
     */
    abstract fun HttpURLConnection.connectionApply():HttpURLConnection

    /**
     * Edit the Gson object.
     */
    abstract fun GsonBuilder.customGson(): GsonBuilder

    /**
     * Execute the request.
     * @return Response of request in String object.
     * @throws ServerException When the server returns an error.
     * @throws ClientException When the library makes a mistake.
     */
    @Throws(ServerException::class, ClientException::class)
    fun execute():String {
        // Vars
        val responseCode: Int
        val connection: HttpURLConnection

        // Create the request
        try {
            connection = (URL(getUrl()).openConnection() as HttpURLConnection)
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

    /**
     * Execute the request.
     * @param T Type of response
     * @param classOfT Class of [T] object.
     * @return Response of request in [T] object.
     * @throws ServerException When the server returns an error.
     * @throws ClientException When the library makes a mistake.
     */
    @Throws(ServerException::class, ClientException::class)
    fun <T: ResponseTemplate> execute(classOfT: Class<T>):T {
        //Get the response
        val  obj = execute()

        //Transforme
        return try {
            GsonBuilder()
                .customGson()
                .create()
                .fromJson(obj, classOfT)
        }

        // block exception
        catch (e : Throwable){
            throw ClientException( ClientException.PARSE_OBJECT, e)
        }

    }

    /**
     * Append key on the Parameters StringBuilder.
     * @return Response of request in ResponseTemplate object.
     * @throws ServerException When the server returns an error.
     * @throws ClientException When the library makes a mistake.
     */
    @Throws(ClientException::class)
    fun addParameter(key: String, value: String?){
        if(value != null) {
            //Append to query
            try {
                parameters.append("$key=${URLEncoder.encode(value, StandardCharsets.UTF_8.toString())}&")
            }

            // block exception
            catch (e: UnsupportedEncodingException) {
                throw ClientException(ClientException.ENCODE_PARAMETER, e)
            }
        }
    }

}
