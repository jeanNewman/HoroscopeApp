package com.jeandarwinnewmanrios.horoscapp.motherobject

import com.jeandarwinnewmanrios.horoscapp.data.network.PredictionResponse
import com.jeandarwinnewmanrios.horoscapp.domain.model.HoroscopeInfo


object HoroscopeMotherObject {
    val anyResponse = PredictionResponse(
        date = "2022-10-10",
        horoscope = "You will have a great day",
        sign = "Aries"
    )

    val horoscopeInfoList =  listOf(
        HoroscopeInfo.Aries,
        HoroscopeInfo.Taurus,
        HoroscopeInfo.Gemini,
        HoroscopeInfo.Cancer,
        HoroscopeInfo.Leo,
        HoroscopeInfo.Virgo,
        HoroscopeInfo.Libra,
        HoroscopeInfo.Scorpio,
        HoroscopeInfo.Sagittarius,
        HoroscopeInfo.Capricorn,
        HoroscopeInfo.Aquarius,
        HoroscopeInfo.Pisces
    )
}