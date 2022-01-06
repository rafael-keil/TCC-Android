package br.com.cwi.tcc_android.data.network.entity

import com.squareup.moshi.Json

class EquipmentResponse(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "equipment_category") val equipmentCategory: BaseListItemResponse,
    @Json(name = "cost") val cost: CostResponse,
    @Json(name = "weight") val weight: Double?,
    @Json(name = "desc") val desc: List<String>?,
    //weapons
    @Json(name = "weapon_category") val weaponCategory: String?,
    @Json(name = "weapon_range") val weaponRange: String?,
    @Json(name = "damage") val damage: DamageResponse?,
    @Json(name = "properties") val properties: List<BaseListItemResponse>?,
    //armor
    @Json(name = "armor_category") val armorCategory: String?,
    @Json(name = "armorClass") val armorClass: ArmorClassResponse?,
    @Json(name = "str_minimum") val strMinimum: Int?,
    @Json(name = "stealth_disadvantage") val stealthDisadvantage: Boolean?,
)