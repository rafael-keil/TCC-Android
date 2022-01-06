package br.com.cwi.tcc_android.presentation.feature.compendium.equipments.equipmentsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.databinding.FragmentEquipmentsBinding
import br.com.cwi.tcc_android.domain.entity.Equipment
import br.com.cwi.tcc_android.presentation.feature.compendium.equipments.EquipmentViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class EquipmentsFragment : Fragment() {

    private lateinit var binding: FragmentEquipmentsBinding

    private val viewModel: EquipmentViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEquipmentsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.equipments.observe(viewLifecycleOwner) { list ->
            setUpClassesRecyclerView(list)
        }
        viewModel.fetchEquipments()
    }

    private fun setUpClassesRecyclerView(list: List<Equipment>) {
        binding.rvEquipments.apply {
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
            adapter = EquipmentsAdapter(list, onClassClick = {
                navigateToClassDetail(it.id)
            })
        }
    }

    private fun navigateToClassDetail(id: String) {
        findNavController().navigate(
            R.id.equipmentDetailFragment,
            bundleOf(
                Pair("id", id)
            )
        )
    }
}