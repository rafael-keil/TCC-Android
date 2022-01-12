package br.com.cwi.tcc_android.data.database.converter

import androidx.room.TypeConverter
import br.com.cwi.tcc_android.data.database.entity.DamageEntity

class DamageConverter : BaseConverter() {

    @TypeConverter
    fun fromDamage(value: DamageEntity?) = value?.let { it.damageDice + PROPRIETY + it.damageType }

    @TypeConverter
    fun fromString(value: String?) =
        value?.split(PROPRIETY)?.let {
            DamageEntity(
                it[0],
                it[1]
            )
        }
}