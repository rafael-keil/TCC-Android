package br.com.cwi.tcc_android.presentation.feature.compendium.spells.spellsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.databinding.FragmentSpellsBinding
import br.com.cwi.tcc_android.domain.entity.BaseCompendiumItem
import br.com.cwi.tcc_android.domain.entity.Spell
import br.com.cwi.tcc_android.presentation.base.BaseSearchFragment
import br.com.cwi.tcc_android.presentation.base.ID
import br.com.cwi.tcc_android.presentation.base.IS_FAVORITE
import br.com.cwi.tcc_android.presentation.feature.compendium.spells.SpellViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SpellsFragment : BaseSearchFragment() {

    private lateinit var itemList: List<Spell>
    private lateinit var binding: FragmentSpellsBinding
    private val viewModel: SpellViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpellsBinding.inflate(layoutInflater)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.spells.observe(viewLifecycleOwner) { list ->
            itemList = list
            setUpClassesRecyclerView(itemList)
        }
        viewModel.fetchSpells()
    }

    override fun filterList(query: String?) {
        val filteredList = itemList.filter {
            if (query != null) {
                it.name.lowercase().contains(query.lowercase())
            } else true
        }
        setUpClassesRecyclerView(filteredList)
    }

    private fun setUpClassesRecyclerView(filteredList: List<BaseCompendiumItem>) {

        binding.rvSpells.apply {
            if (itemDecorationCount == 0) addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
            adapter = SpellsAdapter(filteredList.map { it as Spell }, onItemClick = {
                navigateToItemDetail(it)
            }, onFavoriteClick = {
                viewModel.setFavorite(it)
            })
        }
    }

    private fun navigateToItemDetail(spell: Spell) {
        findNavController().navigate(
            R.id.spellDetailFragment,
            bundleOf(
                Pair(ID, spell.id),
                Pair(IS_FAVORITE, spell.isFavorite)
            )
        )
    }
}