package com.amrhishammahmoud.rahhal.models

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface CountriesApi {
    @GET("v3.1/all")
    suspend fun getDataFromApiRetrofitServiceForCountriesSummary(
        @Query("fields") fields: String
    ): Response<List<CountriesDataDetails>>
}

object APIForCountries {
    private const val BASE_URL = "https://restcountries.com/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().add(
                    KotlinJsonAdapterFactory()
                ).build()))
        .build()

    val apiServiceCountries: CountriesApi =
        retrofit.create(CountriesApi::class.java)
}