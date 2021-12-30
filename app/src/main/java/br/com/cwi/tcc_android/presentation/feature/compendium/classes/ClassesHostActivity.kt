package br.com.cwi.tcc_android.presentation.feature.compendium.classes

import android.os.Bundle
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.databinding.ActivityClassesHostBinding
import br.com.cwi.tcc_android.presentation.base.BaseBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView

class ClassesHostActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityClassesHostBinding

    override val currentTab: Int = R.id.compendium_menu

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClassesHostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}