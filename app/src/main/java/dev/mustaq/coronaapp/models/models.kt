package dev.mustaq.coronaapp.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Mustaq Sameer on 02/06/20
 */

data class CoronaStatsModel(
    @SerializedName("Global")
    val global: GlobalModel
)

data class GlobalModel(
    @SerializedName("TotalConfirmed")
    val totalConfirmed: Int,
    @SerializedName("TotalDeaths")
    val totalDeaths: Int,
    @SerializedName("TotalDeaths")
    val totalRecovered: Int
)