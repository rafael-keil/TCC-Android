package br.com.cwi.tcc_android.domain.entity

class Equipment(
    val id: String,
    val name: String,
    val equipmentCategory: BaseListItem,
    val cost: Cost,
    val weight: Double?,
    val desc: List<String>?,
    //weapons
    val weaponCategory: String?,
    val weaponRange: String?,
    val damage: Damage?,
    val properties: List<BaseListItem>?,
    //armor
    val armorCategory: String?,
    val armorClass: ArmorClass?,
    val strMinimum: Int?,
    val stealthDisadvantage: Boolean?,
)