package br.com.cwi.tcc_android.presentation.feature.compendium.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.tcc_android.databinding.ItemSpellBinding
import br.com.cwi.tcc_android.domain.entity.Spell

class SpellViewHolder(
    itemView: View,
    private val onClassClick: (Spell) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    private val tvName = ItemSpellBinding.bind(itemView).tvName
    private val tvSchool = ItemSpellBinding.bind(itemView).tvSchool
    private val tvLevel = ItemSpellBinding.bind(itemView).tvLevel

    fun bind(item: Spell) {
        tvName.text = item.name
        tvSchool.text = item.school
        tvLevel.text = item.level.toString()

        itemView.setOnClickListener {
            onClassClick(item)
        }
    }
}