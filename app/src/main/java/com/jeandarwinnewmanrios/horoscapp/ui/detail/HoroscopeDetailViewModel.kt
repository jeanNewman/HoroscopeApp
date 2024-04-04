package com.jeandarwinnewmanrios.horoscapp.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeandarwinnewmanrios.horoscapp.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel //explica el HiltViewModel
//HiltViewModel es una anotacion que se encarga de inyectar una dependencia en una clase
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase): ViewModel() { //explica el Inject y el constructor
    //Inject es una anotacion que se encarga de inyectar una dependencia en una clase y constructor es una funcion que se encarga de inicializar una clase
    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading) //explica el MutableStateFlow y el HoroscopeDetailState y el HoroscopeDetailState.Loading
    //MutableStateFlow es una clase que se encarga de manejar el estado de un flujo de datos y HoroscopeDetailState es una clase que se encarga de manejar el estado de un horoscopo y HoroscopeDetailState.Loading es un estado de un horoscopo
    val state: StateFlow<HoroscopeDetailState> = _state //explica el StateFlow y el _state y el state
    //StateFlow es una clase que se encarga de manejar el estado de un flujo de datos y _state es una variable que se encarga de manejar el estado de un horoscopo y state es una variable que se encarga de manejar el estado de un horoscopo

    fun getHoroscope(sign: String) { //explica el getHoroscope
        Log.i("trucutru", "Sign: $sign")
        _state.value = HoroscopeDetailState.Loading //explica el _state y el HoroscopeDetailState.Loading
        viewModelScope.launch {
           //explica el withContext y el Dispatchers.IO y el getPredictionUseCase
            //withContext es una funcion que se encarga de ejecutar una tarea en un hilo secundario y Dispatchers.IO es un hilo secundario y getPredictionUseCase es una funcion que se encarga de obtener un horoscopo

          val result =  withContext(Dispatchers.IO) { getPredictionUseCase(sign) } //hilo secundario
            if(result != null) {
                _state.value = HoroscopeDetailState.Success(result.horoscope, result.sign) // puede recibir un objeto de tipo PredictionModel
            } else {
                _state.value = HoroscopeDetailState.Error("Error al obtener el horoscopo")
            }
        }

    }
}