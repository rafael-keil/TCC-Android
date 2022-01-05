package br.com.cwi.tcc_android.presentation.base

import android.content.Context
import android.widget.ArrayAdapter
import br.com.cwi.tcc_android.R

abstract class BaseArrayAdapter(
    val context: Context?
) {
    fun getBasicArrayAdapter(textList: List<String>): ArrayAdapter<String> {
        return ArrayAdapter(
            context!!,
            R.layout.item_detail_basic,
            textList
        )
    }
}