package com.jeandarwinnewmanrios.horoscapp.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {

    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sign: String): PredictionResponse

}