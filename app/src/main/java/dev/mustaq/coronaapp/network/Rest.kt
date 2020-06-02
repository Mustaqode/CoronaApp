package dev.mustaq.coronaapp.network

import com.google.gson.GsonBuilder
import dev.mustaq.coronaapp.constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Mustaq Sameer on 02/06/20
 */
object Rest {

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor())
        .connectTimeout(40, TimeUnit.SECONDS)
        .build()

    private fun loggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory. create(GsonBuilder().create()))
        .client(client)
        .build()

    val service = retrofit.create(CoronaApi::class.java)

}