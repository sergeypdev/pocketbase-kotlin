package github.agrevster.pocketbaseKotlin.dsl.query

import github.agrevster.pocketbaseKotlin.models.Record
import io.ktor.http.*
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * This specifies which fields in a [Record] are shown in the request's response
 * See [this example](https://github.com/pocketbase/pocketbase/releases/tag/v0.16.0) for an explanation on how to use [ShowFields]
 * @param [fields] all of the fields you want to be shown in the record's response
 */
public class ShowFields(vararg fields: String) {
    private lateinit var fieldsToShow: String
    init {
        fieldsToShow = fields.joinToString(separator = ",")
        println(fieldsToShow)
    }

    /**s
     * Adds the current [ShowFields] to a request's parameters
     */
    public fun addTo(params: ParametersBuilder) {
        if (fieldsToShow.isNotEmpty()) params.append("fields", this.fieldsToShow)
    }
}