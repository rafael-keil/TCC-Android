package br.com.cwi.tcc_android.presentation.feature.compendium.equipments.equipmentsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.domain.entity.Equipment
import br.com.cwi.tcc_android.presentation.feature.compendium.viewholder.EquipmentViewHolder

class EquipmentsAdapter(
    private val list: List<Equipment>,
    private val onItemClick: (Equipment) -> Unit,
    private val onFavoriteClick: (Equipment) -> Unit
) : Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflateView(R.layout.item_equipment, parent)
        return EquipmentViewHolder(view, onItemClick, onFavoriteClick)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = list[position]

        (viewHolder as EquipmentViewHolder).bind(item)
    }

    override fun getItemCount() = list.size

    private fun inflateView(layout: Int, parent: ViewGroup) = LayoutInflater.from(parent.context)
        .inflate(layout, parent, false)
}