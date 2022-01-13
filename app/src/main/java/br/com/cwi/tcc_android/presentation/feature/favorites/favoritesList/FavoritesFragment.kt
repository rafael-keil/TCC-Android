package br.com.cwi.tcc_android.presentation.feature.favorites.favoritesList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.databinding.FragmentFavoritesBinding
import br.com.cwi.tcc_android.domain.entity.BaseCompendiumItem
import br.com.cwi.tcc_android.domain.entity.Spell
import br.com.cwi.tcc_android.presentation.base.BaseSearchFragment
import br.com.cwi.tcc_android.presentation.base.ID
import br.com.cwi.tcc_android.presentation.base.IS_FAVORITE
import br.com.cwi.tcc_android.presentation.feature.favorites.FavoriteViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FavoritesFragment : BaseSearchFragment() {

    override lateinit var itemList: List<BaseCompendiumItem>
    private lateinit var binding: FragmentFavoritesBinding
    private val viewModel: FavoriteViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesBinding.inflate(layoutInflater)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.favorites.observe(viewLifecycleOwner) { list ->
            itemList = list
            setUpClassesRecyclerView(itemList)
        }
        viewModel.fetchFavorites()
    }

    override fun setUpClassesRecyclerView(filteredList: List<BaseCompendiumItem>) {

        binding.rvFavorites.apply {
            if (itemDecorationCount == 0) addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
            adapter = FavoritesAdapter(filteredList, onItemClick = {
                navigateToItemDetail(it)
            }, onFavoriteClick = {
                viewModel.setFavorite(it)
            })
        }
    }

    private fun navigateToItemDetail(item: BaseCompendiumItem) {
        findNavController().navigate(
            if (item is Spell) R.id.spellDetailFragment else R.id.equipmentDetailFragment,
            bundleOf(
                Pair(ID, item.id),
                Pair(IS_FAVORITE, item.isFavorite)
            )
        )
    }
}