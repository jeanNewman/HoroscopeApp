package com.jeandarwinnewmanrios.horoscapp.data.network

import com.jeandarwinnewmanrios.horoscapp.motherobject.HoroscopeMotherObject.anyResponse
import io.kotest.matchers.shouldBe
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class PredictionResponseTest {
    @Test
    fun `test toDomain() should return PredictionModel with the same values as the PredictionResponse`() {
        // Given
        val predictionResponse = anyResponse

        // When
        val predictionModel = predictionResponse.toDomain()

        // Then
        predictionResponse.horoscope shouldBe predictionModel.horoscope
        predictionResponse.sign shouldBe predictionModel.sign
    }
}

