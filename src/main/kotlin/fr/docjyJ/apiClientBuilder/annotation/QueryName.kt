package fr.docjyJ.apiClientBuilder.annotation


/**
 * The annotation to set a name to a query param.
 *
 * @property name The name of the query.
 */

@Target(AnnotationTarget.FIELD)
@MustBeDocumented
annotation class QueryName(val name: String)
