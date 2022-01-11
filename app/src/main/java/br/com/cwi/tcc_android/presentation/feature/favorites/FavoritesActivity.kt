package br.com.cwi.tcc_android.presentation.feature.favorites

import android.os.Bundle
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.databinding.ActivityFavoritesBinding
import br.com.cwi.tcc_android.presentation.base.BaseBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView

class FavoritesActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityFavoritesBinding

    override val currentTab: Int = R.id.characters_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root
}