package br.com.cwi.tcc_android.data.database.converter

import androidx.room.TypeConverter
import br.com.cwi.tcc_android.data.database.entity.CostEntity

class CostConverter : BaseConverter() {

    @TypeConverter
    fun fromCost(value: CostEntity?) = value?.let { it.quantity.toString() + PROPRIETY + it.unit }

    @TypeConverter
    fun fromString(value: String?) =
        value?.split(PROPRIETY)?.let {
            CostEntity(
                it[0].toInt(),
                it[1]
            )
        }
}