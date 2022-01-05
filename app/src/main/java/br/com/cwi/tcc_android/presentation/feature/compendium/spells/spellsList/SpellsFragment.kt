package br.com.cwi.tcc_android.presentation.feature.compendium.spells.spellsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.databinding.FragmentSpellsBinding
import br.com.cwi.tcc_android.domain.entity.Spell
import br.com.cwi.tcc_android.presentation.feature.compendium.spells.SpellViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SpellsFragment : Fragment() {

    private lateinit var binding: FragmentSpellsBinding

    private val viewModel: SpellViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpellsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.classes.observe(viewLifecycleOwner) { list ->
            setUpClassesRecyclerView(list)
        }
        viewModel.fetchSpells()
    }

    private fun setUpClassesRecyclerView(list: List<Spell>) {
        binding.rvClasses.apply {
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
            adapter = SpellsAdapter(list, onClassClick = {
                navigateToClassDetail(it.id)
            })
        }
    }

    private fun navigateToClassDetail(id: String) {
        findNavController().navigate(
            R.id.spellDetailFragment,
            bundleOf(
                Pair("id", id)
            )
        )
    }
}