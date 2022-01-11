package br.com.cwi.tcc_android.presentation.base

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import br.com.cwi.tcc_android.R

abstract class BaseFavoriteFragment : Fragment() {

    var favoriteIcon: MenuItem? = null

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_favorite, menu)
        favoriteIcon = menu.getItem(0)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_favorite_icon) {
            onFavoriteClick()
        }
        return super.onOptionsItemSelected(item)
    }

    abstract fun onFavoriteClick()
}