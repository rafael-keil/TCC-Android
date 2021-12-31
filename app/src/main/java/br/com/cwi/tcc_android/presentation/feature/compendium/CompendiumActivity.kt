package br.com.cwi.tcc_android.presentation.feature.compendium

import android.content.Intent
import android.os.Bundle
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.databinding.ActivityCompendiumBinding
import br.com.cwi.tcc_android.presentation.base.BaseBottomNavigation
import br.com.cwi.tcc_android.presentation.feature.compendium.`class`.ClassesHostActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class CompendiumActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityCompendiumBinding

    override val currentTab: Int = R.id.compendium_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompendiumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpCompendiumActions()
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

    private fun setUpCompendiumActions() {
        binding.btClasses.setOnClickListener {
            val intent = Intent(this, ClassesHostActivity::class.java)
            startActivity(intent)
        }
    }
}