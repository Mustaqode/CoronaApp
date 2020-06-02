package dev.mustaq.coronaapp.network

import dev.mustaq.coronaapp.models.CoronaStatsModel
import dev.mustaq.coronaapp.utils.coroutine.Resource

/**
 * Created by Mustaq Sameer on 02/06/20
 */
class RestService(
    private val service: CoronaApi
) {

    suspend fun getCoronaStats(): Resource<CoronaStatsModel> {
        val response = service.getCoronaSummary()
        return if (response.isSuccessful && response.body() != null)
            Resource.success(response.body()!!)
        else Resource.error(null, response.message())
    }

}