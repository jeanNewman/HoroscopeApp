package com.jeandarwinnewmanrios.horoscapp.data.providers

import com.jeandarwinnewmanrios.horoscapp.domain.model.HoroscopeInfo
import com.jeandarwinnewmanrios.horoscapp.domain.model.HoroscopeInfo.*
import javax.inject.Inject

class HoroscopeProvider @Inject constructor(){
    fun getHoroscopeList(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}