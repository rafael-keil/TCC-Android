package br.com.cwi.tcc_android.presentation.feature.compendium.spells.spellsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.domain.entity.Spell
import br.com.cwi.tcc_android.presentation.feature.compendium.viewholder.SpellViewHolder

class SpellsAdapter(
    private val list: List<Spell>,
    private val onItemClick: (Spell) -> Unit,
    private val onFavoriteClick: (Spell) -> Unit
) : Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflateView(R.layout.item_spell, parent)
        return SpellViewHolder(view, onItemClick, onFavoriteClick)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = list[position]

        (viewHolder as SpellViewHolder).bind(item)
    }

    override fun getItemCount() = list.size

    private fun inflateView(layout: Int, parent: ViewGroup) = LayoutInflater.from(parent.context)
        .inflate(layout, parent, false)
}