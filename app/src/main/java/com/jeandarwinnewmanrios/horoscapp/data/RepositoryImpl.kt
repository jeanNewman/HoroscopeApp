package com.jeandarwinnewmanrios.horoscapp.data

import android.util.Log
import com.jeandarwinnewmanrios.horoscapp.data.network.HoroscopeApiService
import com.jeandarwinnewmanrios.horoscapp.data.network.PredictionResponse
import com.jeandarwinnewmanrios.horoscapp.domain.Repository
import com.jeandarwinnewmanrios.horoscapp.domain.model.PredictionModel
import retrofit2.Response

import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService): Repository {
    override suspend fun getPrediction(sign: String): PredictionModel?{
        Log.i("trucutru", "Sign: $sign")
       kotlin.runCatching { apiService.getHoroscope(sign) } //runCatching es una funcion de kotlin que permite manejar excepciones en un bloque de codigo
           .onSuccess {
               Log.i("trucutru","entra aqui: ${it.toDomain()}")
              return it.toDomain()
           } //onSuccess es una funcion que se ejecuta cuando el bloque de codigo es exitoso
           .onFailure{ Log.i("trucutru"," ha ocurrido un error ${it.message}" )} //isFailure es una funcion que se ejecuta cuando el bloque de codigo falla
        return null
    }
}