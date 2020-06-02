package dev.mustaq.coronaapp.utils.coroutine

import dev.mustaq.coronaapp.enums.Status

/**
 * Created by Mustaq Sameer on 02/06/20
 */

data class Resource<out T> (
    val status: Status? = null,
    val message: String? = null,
    val data: T? = null
) {
    companion object {
        fun <T> success(data : T): Resource<T> = Resource(Status.SUCCESS, null, data)
        fun <T> error(data : T?, message: String?) = Resource(Status.ERROR, message, data)
    }
}