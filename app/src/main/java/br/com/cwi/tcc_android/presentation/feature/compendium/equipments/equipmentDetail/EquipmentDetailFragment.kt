package br.com.cwi.tcc_android.presentation.feature.compendium.equipments.equipmentDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.cwi.tcc_android.databinding.FragmentEquipmentDetailBinding
import br.com.cwi.tcc_android.domain.entity.Equipment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

private const val TAB = "      "
private const val BREAK_LINE = "\n"
private const val SEPARATOR = ", "

class SpellDetailFragment : Fragment() {

    private lateinit var binding: FragmentEquipmentDetailBinding

    private val viewModel: EquipmentDetailViewModel by sharedViewModel()


    private val itemId by lazy {
        arguments?.getString("id")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEquipmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.equipmentDetail.observe(viewLifecycleOwner) { item ->
            setupDetailsInfo(item)
        }

        itemId?.run {
            viewModel.fetchEquipment(this)
        }
    }

    private fun setupDetailsInfo(item: Equipment) {
        item.run {
            binding.tvName.text = name
        }
    }
}