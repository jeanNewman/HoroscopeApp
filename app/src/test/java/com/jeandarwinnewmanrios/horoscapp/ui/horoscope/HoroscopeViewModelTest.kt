package com.jeandarwinnewmanrios.horoscapp.ui.horoscope

import com.jeandarwinnewmanrios.horoscapp.data.providers.HoroscopeProvider
import com.jeandarwinnewmanrios.horoscapp.motherobject.HoroscopeMotherObject.horoscopeInfoList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class HoroscopeViewModelTest{
    @MockK
    lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var horoscopeViewModel: HoroscopeViewModel
    @Before
    fun setUp(){
        MockKAnnotations.init(this, relaxUnitFun = true)
    }
    @Test
    fun `when viewmodel is created then horoscopes are loaded`(){
        every { horoscopeProvider.getHoroscopeList() } returns horoscopeInfoList
        // Given
        horoscopeViewModel = HoroscopeViewModel(horoscopeProvider)
        // When
        val horoscope = horoscopeViewModel.horoscope.value

        // Then
        assertTrue(horoscope.isNotEmpty())
    }
}


