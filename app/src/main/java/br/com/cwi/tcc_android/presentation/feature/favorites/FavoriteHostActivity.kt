package br.com.cwi.tcc_android.presentation.feature.favorites

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.databinding.ActivityFavoriteHostBinding
import br.com.cwi.tcc_android.presentation.base.BaseBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val VIEW_CONTENT = 0
private const val VIEW_LOADING = 1
private const val VIEW_ERROR = 2

class FavoriteHostActivity : BaseBottomNavigation() {

    private val viewModel: FavoriteViewModel by viewModel()
    private lateinit var binding: ActivityFavoriteHostBinding
    override val currentTab: Int = R.id.favorites_menu

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(binding.navHostContainer.id) as NavHostFragment)
            .findNavController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteHostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupViewModel()
        setupNavController()
    }

    private fun setupNavController() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            supportActionBar?.title = when (destination.id) {
                R.id.favoritesFragment -> getString(R.string.txt_favorites)
                else -> "Details"
            }
        }
    }

    private fun setupViewModel() {
        viewModel.loading.observe(this) { isLoading ->
            binding.vfFavorites.displayedChild = if (isLoading) VIEW_LOADING else VIEW_CONTENT
        }

        viewModel.error.observe(this) { hasError ->
            binding.vfFavorites.displayedChild = if (hasError) VIEW_ERROR else VIEW_CONTENT
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}