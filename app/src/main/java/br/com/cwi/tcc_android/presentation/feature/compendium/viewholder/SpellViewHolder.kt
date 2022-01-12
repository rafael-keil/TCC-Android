package br.com.cwi.tcc_android.presentation.feature.compendium.viewholder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.databinding.ItemSpellBinding
import br.com.cwi.tcc_android.domain.entity.Spell

class SpellViewHolder(
    itemView: View,
    private val onItemClick: (Spell) -> Unit,
    private val onFavoriteClick: (Spell) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    private val tvName = ItemSpellBinding.bind(itemView).tvName
    private val tvSchool = ItemSpellBinding.bind(itemView).tvSchool
    private val tvLevel = ItemSpellBinding.bind(itemView).tvLevel
    private val ivFavorite = ItemSpellBinding.bind(itemView).ivFavorite

    fun bind(item: Spell) {
        tvName.text = item.name
        tvSchool.text = item.school
        tvLevel.text = itemView.context.getString(R.string.txt_level, item.level)

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

    private fun getFavoriteIcon(spell: Spell) = ContextCompat.getDrawable(
        itemView.context,
        if (spell.isFavorite) R.drawable.ic_favorite_filled
        else R.drawable.ic_favorite
    )
}