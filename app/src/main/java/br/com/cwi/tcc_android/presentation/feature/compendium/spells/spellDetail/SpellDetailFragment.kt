package br.com.cwi.tcc_android.presentation.feature.compendium.spells.spellDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.cwi.tcc_android.databinding.FragmentSpellDetailBinding
import br.com.cwi.tcc_android.domain.entity.Spell
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

private const val TAB = "      "
private const val BREAK_LINE = "\n"
private const val SEPARATOR = ", "

class SpellDetailFragment : Fragment() {

    private lateinit var binding: FragmentSpellDetailBinding

    private val viewModel: SpellDetailViewModel by sharedViewModel()


    private val itemId by lazy {
        arguments?.getString("id")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSpellDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.spellDetail.observe(viewLifecycleOwner) { item ->
            setupDetailsInfo(item)
        }

        itemId?.run {
            viewModel.fetchSpell(this)
        }
    }

    private fun setupDetailsInfo(item: Spell) {
        item.run {
            binding.tvName.text = name
            binding.tvLevelContent.text = level.toString()
            binding.tvSchoolContent.text = school.name
            binding.tvCastingTimeContent.text = castingTime
            binding.tvRangeContent.text = range
            binding.tvComponentsContent.text = components.joinToString(separator = SEPARATOR)
            binding.tvDurationContent.text = duration
            binding.tvClassesContent.text = classes.joinToString(separator = SEPARATOR) { it.name }
            binding.tvDesc.text = desc.joinToString(separator = BREAK_LINE + TAB, prefix = TAB)

            higherLevel?.let {
                binding.higherLevel.visibility = View.VISIBLE
                binding.higherLevelContent.visibility = View.VISIBLE
                binding.higherLevelContent.text =
                    it.joinToString(separator = BREAK_LINE + TAB, prefix = TAB)
            }
        }
    }
}