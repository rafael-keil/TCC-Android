package br.com.cwi.tcc_android.presentation.feature.favorites.favoritesList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.domain.entity.BaseCompendiumItem
import br.com.cwi.tcc_android.domain.entity.Equipment
import br.com.cwi.tcc_android.domain.entity.Spell
import br.com.cwi.tcc_android.presentation.feature.compendium.viewholder.EquipmentViewHolder
import br.com.cwi.tcc_android.presentation.feature.compendium.viewholder.SpellViewHolder

private const val SPELL = 0
private const val EQUIPMENT = 1

class FavoritesAdapter(
    private val list: List<BaseCompendiumItem>,
    private val onItemClick: (BaseCompendiumItem) -> Unit,
    private val onFavoriteClick: (BaseCompendiumItem) -> Unit
) : Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == SPELL) {
            val view = inflateView(R.layout.item_spell, parent)
            SpellViewHolder(view, onItemClick, onFavoriteClick)
        } else {
            val view = inflateView(R.layout.item_equipment, parent)
            EquipmentViewHolder(view, onItemClick, onFavoriteClick)
        }
    }

    override fun getItemViewType(position: Int): Int =
        if (list[position] is Spell) SPELL else EQUIPMENT

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = list[position]

        if (item is Spell) {
            (viewHolder as SpellViewHolder).bind(item)
        } else {
            (viewHolder as EquipmentViewHolder).bind(item as Equipment)
        }
    }

    override fun getItemCount() = list.size

    private fun inflateView(layout: Int, parent: ViewGroup) = LayoutInflater.from(parent.context)
        .inflate(layout, parent, false)
}