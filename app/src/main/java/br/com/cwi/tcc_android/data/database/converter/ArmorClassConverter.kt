package br.com.cwi.tcc_android.data.database.converter

import androidx.room.TypeConverter
import br.com.cwi.tcc_android.data.database.entity.ArmorClassEntity

class ArmorClassConverter : BaseConverter() {

    @TypeConverter
    fun fromCost(value: ArmorClassEntity) =
        value.base.toString() + PROPRIETY + value.dexBonus.toString()

    @TypeConverter
    fun fromString(value: String) =
        ArmorClassEntity(
            value.split(PROPRIETY)[0].toInt(),
            value.split(PROPRIETY)[1].toBoolean()
        )
}