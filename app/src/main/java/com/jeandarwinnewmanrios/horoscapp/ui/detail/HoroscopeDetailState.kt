package com.jeandarwinnewmanrios.horoscapp.ui.detail

sealed class HoroscopeDetailState {
    data object Loading:HoroscopeDetailState() //cuando no se pasa parametros es un object
    data class Error(val error:String): HoroscopeDetailState()// cuando se pasa parametros es una data class
    data class Success(val prediction:String, val sign: String): HoroscopeDetailState()
}