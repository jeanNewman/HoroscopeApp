package com.jeandarwinnewmanrios.horoscapp.ui.providers

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class RandomCardProviderTest {

    @Test
    fun `test getRandomCard() should return a random card`() {
        // Given
        val randomCardProvider = RandomCardProvider()

        // When
        val randomCard = randomCardProvider.getLucky()

        // Then
        assertNotNull(randomCard)
    }
}
