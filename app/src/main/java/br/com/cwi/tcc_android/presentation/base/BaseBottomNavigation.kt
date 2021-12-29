package br.com.cwi.tcc_android.presentation.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.presentation.feature.characters.CharactersActivity
import br.com.cwi.tcc_android.presentation.feature.compendium.CompendiumActivity
import br.com.cwi.tcc_android.presentation.feature.dices.DicesActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

abstract class BaseBottomNavigation : AppCompatActivity() {

    abstract val currentTab: Int

    abstract fun getBottomNavigation(): BottomNavigationView

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }

    override fun onResume() {
        super.onResume()
        setUpBottomNavigationActions()
        selectCurrentTab()
    }

    private fun setUpBottomNavigationActions() {

        getBottomNavigation().setOnItemSelectedListener {
            if (it.itemId != this.currentTab) when (it.itemId) {
                R.id.compendium_menu -> {
                    val intent = Intent(this, CompendiumActivity::class.java)
                    startActivity(intent)
                }

                R.id.characters_menu -> {
                    val intent = Intent(this, CharactersActivity::class.java)
                    startActivity(intent)
                }

                R.id.dices_menu -> {
                    val intent = Intent(this, DicesActivity::class.java)
                    startActivity(intent)
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun selectCurrentTab() {
        getBottomNavigation().selectedItemId = currentTab
    }
}