package br.com.cwi.tcc_android.presentation.feature.characters

import android.os.Bundle
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.databinding.ActivityCharactersBinding
import br.com.cwi.tcc_android.presentation.base.BaseBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView

class CharactersActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityCharactersBinding

    override val currentTab: Int = R.id.characters_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharactersBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root
}