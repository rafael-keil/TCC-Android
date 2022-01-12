package br.com.cwi.tcc_android.presentation.feature.compendium.viewholder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.databinding.ItemEquipmentBinding
import br.com.cwi.tcc_android.domain.entity.Equipment

class EquipmentViewHolder(
    itemView: View,
    private val onItemClick: (Equipment) -> Unit,
    private val onFavoriteClick: (Equipment) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    private val tvName = ItemEquipmentBinding.bind(itemView).tvName
    private val tvCategory = ItemEquipmentBinding.bind(itemView).tvCategory
    private val ivFavorite = ItemEquipmentBinding.bind(itemView).ivFavorite


    fun bind(item: Equipment) {
        tvName.text = item.name
        tvCategory.text = item.equipmentCategory

        with(ivFavorite) {
            setImageDrawable(getFavoriteIcon(item))
            setOnClickListener {
                item.isFavorite = !item.isFavorite
                setImageDrawable(getFavoriteIcon(item))
                onFavoriteClick(item)
            }
        }

        itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    private fun getFavoriteIcon(equipment: Equipment) = ContextCompat.getDrawable(
        itemView.context,
        if (equipment.isFavorite) R.drawable.ic_favorite_filled
        else R.drawable.ic_favorite
    )
}