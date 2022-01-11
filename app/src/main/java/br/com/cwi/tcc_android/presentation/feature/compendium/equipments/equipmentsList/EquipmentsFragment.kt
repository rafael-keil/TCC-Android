package br.com.cwi.tcc_android.presentation.feature.compendium.equipments.equipmentsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.databinding.FragmentEquipmentsBinding
import br.com.cwi.tcc_android.domain.entity.BaseCompendiumItem
import br.com.cwi.tcc_android.domain.entity.Equipment
import br.com.cwi.tcc_android.presentation.base.BaseSearchFragment
import br.com.cwi.tcc_android.presentation.base.ID
import br.com.cwi.tcc_android.presentation.base.IS_FAVORITE
import br.com.cwi.tcc_android.presentation.feature.compendium.equipments.EquipmentViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class EquipmentsFragment : BaseSearchFragment() {

    override lateinit var itemList: List<Equipment>
    private lateinit var binding: FragmentEquipmentsBinding
    private val viewModel: EquipmentViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEquipmentsBinding.inflate(layoutInflater)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.equipments.observe(viewLifecycleOwner) { list ->
            itemList = list
            setUpClassesRecyclerView(itemList)
        }
        viewModel.fetchEquipments()
    }

    override fun setUpClassesRecyclerView(filteredList: List<BaseCompendiumItem>) {

        binding.rvEquipments.apply {
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
            adapter = EquipmentsAdapter(filteredList.map { it as Equipment }, onClassClick = {
                navigateToClassDetail(it)
            })
        }
    }

    private fun navigateToClassDetail(equipment: Equipment) {
        findNavController().navigate(
            R.id.equipmentDetailFragment,
            bundleOf(
                Pair(ID, equipment.id),
                Pair(IS_FAVORITE, equipment.isFavorite)
            )
        )
    }
}