package com.jeandarwinnewmanrios.horoscapp.domain.usecase

import com.jeandarwinnewmanrios.horoscapp.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor( private val repository: Repository){
    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)//invoke es una funcion que permite llamar a la clase como si fuera una funcion y repository es una variable que se encarga de manejar el repositorio y getPrediction es una funcion que se encarga de obtener un horoscopo

}