package dev.mustaq.coronaapp.handler

import retrofit2.Response

/**
 * Created by Mustaq Sameer on 02/06/20
 */

sealed class ApiResponse<T> {
    companion object {
        fun <T> create(response: Response<T>): ApiResponse<T> {
            return if(response.isSuccessful) {
                val body = response.body()
                // Empty body
                if (body == null || response.code() == 204) {
                    ApiSuccessEmptyResponse()
                } else {
                    ApiSuccessResponse(body)
                }
            } else {
                val msg = response.errorBody()?.string()
                val errorMessage = if(msg.isNullOrEmpty()) {
                    response.message()
                } else {
                    msg
                }
                ApiErrorResponse(errorMessage ?: "Unknown error")
            }
        }
    }
}

class ApiSuccessResponse<T>(val data: T): ApiResponse<T>()
class ApiSuccessEmptyResponse<T>: ApiResponse<T>()
class ApiErrorResponse<T>(val errorMessage: String): ApiResponse<T>()