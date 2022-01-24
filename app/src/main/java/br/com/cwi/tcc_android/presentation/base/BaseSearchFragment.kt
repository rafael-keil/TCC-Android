package br.com.cwi.tcc_android.presentation.base

import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import br.com.cwi.tcc_android.R

const val ID = "ID"
const val IS_FAVORITE = "IS_FAVORITE"

abstract class BaseSearchFragment : Fragment() {

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_search, menu)

        val searchView = menu.findItem(R.id.menu_search).actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(query: String?): Boolean {
                filterList(query)
                return true
            }

            override fun onQueryTextSubmit(query: String?) = onQueryTextChange(query)
        })
    }

    abstract fun filterList(query: String?)
}