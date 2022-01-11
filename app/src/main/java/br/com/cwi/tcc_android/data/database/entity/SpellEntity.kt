package br.com.cwi.tcc_android.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class SpellEntity(
    @PrimaryKey val id: String,
    val name: String,
    val desc: List<String>,
    val higherLevel: List<String>?,
    val range: String,
    val components: List<String>,
    val material: String?,
    val duration: String,
    val castingTime: String,
    val level: Int,
    val school: String,
    val classes: List<String>,
)
