package br.com.cwi.tcc_android.data.database.converter

import androidx.room.TypeConverter
import br.com.cwi.tcc_android.data.database.entity.ArmorClassEntity

class ArmorClassConverter : BaseConverter() {

    @TypeConverter
    fun fromCost(value: ArmorClassEntity?) =
        value?.base.toString() + PROPRIETY + value?.dexBonus.toString()

    @TypeConverter
    fun fromString(value: String?) =
        value?.split(PROPRIETY)?.let {
            ArmorClassEntity(
                it[0].toInt(),
                it[0].toBoolean()
            )
        }
}