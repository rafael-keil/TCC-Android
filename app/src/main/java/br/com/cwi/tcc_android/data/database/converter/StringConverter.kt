package br.com.cwi.tcc_android.data.database.converter

import androidx.room.TypeConverter

class StringConverter : BaseConverter() {
    @TypeConverter
    fun fromStringList(value: List<String>) = value.joinToString(OBJECT) { it }

    @TypeConverter
    fun fromString(value: String) = value.split(OBJECT)
}