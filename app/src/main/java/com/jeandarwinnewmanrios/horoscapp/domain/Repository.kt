package com.jeandarwinnewmanrios.horoscapp.domain

import com.jeandarwinnewmanrios.horoscapp.data.network.PredictionResponse
import com.jeandarwinnewmanrios.horoscapp.domain.model.PredictionModel
import retrofit2.Response

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}