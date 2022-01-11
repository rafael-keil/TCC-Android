package br.com.cwi.tcc_android.data.database.converter

import androidx.room.TypeConverter
import br.com.cwi.tcc_android.data.database.entity.CostEntity

class CostConverter : BaseConverter() {

    @TypeConverter
    fun fromCost(value: CostEntity) = value.quantity.toString() + PROPRIETY + value.unit

    @TypeConverter
    fun fromString(value: String) =
        CostEntity(
            value.split(PROPRIETY)[0].toInt(),
            value.split(PROPRIETY)[1]
        )
}