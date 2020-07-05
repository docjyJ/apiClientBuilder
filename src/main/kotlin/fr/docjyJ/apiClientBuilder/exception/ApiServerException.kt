@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package fr.docjyJ.apiClientBuilder.exception

import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import java.net.HttpURLConnection
import java.net.URL

/**
 * Signals that an error was reached during the request to the server.
 *
 * @property url URL used for the request.
 * @property responseCode code of the request.
 * @property responseMessage message of the request.
 */
class ApiServerException internal constructor(connection: HttpURLConnection) : Exception(Error(connection).toJson())
{
    val url: URL? = connection.url

    val responseMessage: String? = connection.responseMessage

    val responseCode = connection.responseCode



    private class Error(connection: HttpURLConnection){
        @SerializedName("url")
        val url = connection.url ?: "no url"
        @SerializedName("message")
        val responseMessage = connection.responseMessage ?: "no response message"
        @SerializedName("code")
        val responseCode = connection.responseCode

        fun toJson() = GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create().toJson(this)!!
    }
}
