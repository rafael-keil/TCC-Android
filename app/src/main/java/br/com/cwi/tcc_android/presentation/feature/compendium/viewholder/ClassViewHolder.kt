package br.com.cwi.tcc_android.presentation.feature.compendium.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.databinding.ItemClassBinding
import br.com.cwi.tcc_android.domain.entity.Class

class ClassViewHolder(
    itemView: View,
) : RecyclerView.ViewHolder(itemView) {
    private val tvName = ItemClassBinding.bind(itemView).tvName
    private val tvDice = ItemClassBinding.bind(itemView).tvDice
    private val tvSubclasses = ItemClassBinding.bind(itemView).tvSubclasses

    fun bind(item: Class) {
        tvName.text = item.name
        tvDice.text = R.string.txt_hp_dice.toString() + item.hitDie.toString()
        tvSubclasses.text =
            R.string.txt_subclasses.toString() + item.subClasses.map { item -> item.name }
                .joinToString { ", " }
    }
}