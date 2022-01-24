package br.com.cwi.tcc_android.presentation.feature.compendium.spells.spellDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.databinding.FragmentSpellDetailBinding
import br.com.cwi.tcc_android.domain.entity.Spell
import br.com.cwi.tcc_android.presentation.base.BaseFavoriteFragment
import br.com.cwi.tcc_android.presentation.base.ID
import br.com.cwi.tcc_android.presentation.base.IS_FAVORITE
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

private const val TAB = "      "
private const val BREAK_LINE = "\n"
private const val SEPARATOR = ", "

class SpellDetailFragment : BaseFavoriteFragment() {

    private lateinit var binding: FragmentSpellDetailBinding
    private val viewModel: SpellDetailViewModel by sharedViewModel()
    private lateinit var spell: Spell

    private val itemId by lazy {
        arguments?.getString(ID)
    }
    private val itemIsFavorite by lazy {
        arguments?.getBoolean(IS_FAVORITE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpellDetailBinding.inflate(layoutInflater)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.spellDetail.observe(viewLifecycleOwner) { item ->
            spell = item
            spell.isFavorite = itemIsFavorite == true
            setupDetailsInfo()
        }

        itemId?.run {
            viewModel.fetchSpell(this)
        }
    }

    private fun setupDetailsInfo() {
        spell.run {
            favoriteIcon?.icon = getDrawable(
                requireContext(),
                if (isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite
            )

            binding.tvName.text = name
            binding.tvLevelContent.text = level.toString()
            binding.tvSchoolContent.text = school
            binding.tvCastingTimeContent.text = castingTime
            binding.tvRangeContent.text = range
            binding.tvComponentsContent.text = components.joinToString(separator = SEPARATOR)
            binding.tvDurationContent.text = duration
            binding.tvClassesContent.text = classes.joinToString(separator = SEPARATOR)
            binding.tvDesc.text = desc.joinToString(separator = BREAK_LINE + TAB, prefix = TAB)

            higherLevel?.let {
                binding.higherLevel.visibility = View.VISIBLE
                binding.higherLevelContent.visibility = View.VISIBLE
                binding.higherLevelContent.text =
                    it.joinToString(separator = BREAK_LINE + TAB, prefix = TAB)
            }
        }
    }

    override fun onFavoriteClick() {
        spell.isFavorite = !spell.isFavorite
        viewModel.setFavorite(spell)
        setupDetailsInfo()
    }
}