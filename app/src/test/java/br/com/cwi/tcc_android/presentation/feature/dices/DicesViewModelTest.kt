package br.com.cwi.tcc_android.presentation.feature.dices

import org.junit.Assert
import org.junit.Test

class DicesViewModelTest {

    private lateinit var viewModel: DicesViewModel

    @Test
    fun `when view model rollDice then return random dice int`() {
        val diceSides = 20
        viewModel = DicesViewModel()

        val returned = viewModel.rollDice(diceSides)

        Assert.assertTrue(returned in 1 until diceSides)
    }
}