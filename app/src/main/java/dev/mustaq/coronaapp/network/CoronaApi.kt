package dev.mustaq.coronaapp.network

import dev.mustaq.coronaapp.models.CoronaStatsModel
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Mustaq Sameer on 02/06/20
 */
interface CoronaApi {

    @GET("summary")
    suspend fun getCoronaSummary() : Response<CoronaStatsModel>
}