package com.jeandarwinnewmanrios.horoscapp.ui.horoscope
import androidx.lifecycle.ViewModel
import com.jeandarwinnewmanrios.horoscapp.data.providers.HoroscopeProvider
import com.jeandarwinnewmanrios.horoscapp.domain.model.HoroscopeInfo
import com.jeandarwinnewmanrios.horoscapp.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
@HiltViewModel
class HoroscopeViewModel @Inject constructor(private val horoscopeProvider: HoroscopeProvider): ViewModel(){
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())//que significa _horoscope y horoscope en este caso? //horoscope es una propiedad privada que devuelve el valor de _horoscope y _horoscope es una variable privada que es una lista vacia
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        _horoscope.value = horoscopeProvider.getHoroscopeList()
    }

}