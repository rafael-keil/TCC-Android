package br.com.cwi.tcc_android.domain.entity

class Equipment(
    id: String,
    name: String,
    val equipmentCategory: String,
    val cost: Cost,
    val weight: Double?,
    val desc: List<String>?,
    //weapons
    val weaponCategory: String?,
    val weaponRange: String?,
    val damage: Damage?,
    val properties: List<String>?,
    //armor
    val armorCategory: String?,
    val armorClass: ArmorClass?,
    val strMinimum: Int?,
    val stealthDisadvantage: Boolean?,
) : BaseCompendiumItem(
    id = id,
    name = name
)