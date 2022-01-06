package br.com.cwi.tcc_android.presentation.feature.compendium.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.tcc_android.databinding.ItemEquipmentBinding
import br.com.cwi.tcc_android.domain.entity.Equipment

class EquipmentViewHolder(
    itemView: View,
    private val onClassClick: (Equipment) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    private val tvName = ItemEquipmentBinding.bind(itemView).tvName
    private val tvCategory = ItemEquipmentBinding.bind(itemView).tvCategory

    fun bind(item: Equipment) {
        tvName.text = item.name
        tvCategory.text = item.equipmentCategory.name

        itemView.setOnClickListener {
            onClassClick(item)
        }
    }
}