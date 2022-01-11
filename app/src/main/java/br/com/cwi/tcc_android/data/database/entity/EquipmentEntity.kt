package br.com.cwi.tcc_android.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class EquipmentEntity(
    @PrimaryKey val id: String,
    val name: String,
    val equipmentCategory: String,
    val cost: CostEntity,
    val weight: Double?,
    val desc: List<String>?,
    val weaponCategory: String?,
    val weaponRange: String?,
    val damage: DamageEntity?,
    val properties: List<String>?,
    val armorCategory: String?,
    val armorClass: ArmorClassEntity?,
    val strMinimum: Int?,
    val stealthDisadvantage: Boolean?,
)