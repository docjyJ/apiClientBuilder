package fr.docjyJ.apiClientBuilder.connection

import fr.docjyJ.apiClientBuilder.exception.ClientException
import fr.docjyJ.apiClientBuilder.exception.ServerException

/**
 * Interface of the class builder to do a request.
 */

interface RequestTemplate{
    /**
     * Execute the request.
     * @return Response of request in ResponseTemplate object.
     * @throws ServerException When the server returns an error.
     * @throws ClientException When the library makes a mistake.
     */
    @Throws(ServerException::class, ClientException::class)
    fun execute(): ResponseTemplate

    /**
     * Execute the request.
     * @return Response of request in String object.
     * @throws ServerException When the server returns an error.
     * @throws ClientException When the library makes a mistake.
     */
    @Throws(ServerException::class, ClientException::class)
    fun executeAsString():String

    /**
     * Show the URL.
     * @return The URL of request in String object.
     * @throws ClientException When the library makes a mistake.
     */
    @Throws(ClientException::class)
    fun getUrl():String
}
