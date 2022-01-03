package br.com.cwi.tcc_android.presentation.feature.compendium.`class`

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import br.com.cwi.tcc_android.R
import br.com.cwi.tcc_android.domain.entity.Class
import br.com.cwi.tcc_android.presentation.feature.compendium.viewholder.ClassViewHolder

class ClassAdapter(
    private val list: List<Class>,
    private val onClassClick: (Class) -> Unit
) : Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflateView(R.layout.item_class, parent)
        return ClassViewHolder(view, onClassClick)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = list[position]

        (viewHolder as ClassViewHolder).bind(item)
    }

    override fun getItemCount() = list.size

    private fun inflateView(layout: Int, parent: ViewGroup) = LayoutInflater.from(parent.context)
        .inflate(layout, parent, false)
}