package br.com.cwi.tcc_android.presentation.feature.dices

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DicesViewModel : ViewModel() {

    fun rollDice(diceSides: Int) = Random.nextInt(1, diceSides + 1)
}