package dev.mustaq.coronaapp.repository

import dev.mustaq.coronaapp.network.RestService

/**
 * Created by Mustaq Sameer on 02/06/20
 */

class CoronaRepository(
    private val service : RestService
) {

    suspend fun getCoronaStats() = service.getCoronaStats()
}