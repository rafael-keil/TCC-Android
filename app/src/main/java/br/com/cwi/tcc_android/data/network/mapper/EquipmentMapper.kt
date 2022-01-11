package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.EquipmentResponse
import br.com.cwi.tcc_android.domain.entity.Equipment

fun EquipmentResponse.toDomain() = Equipment(
    id,
    name,
    equipmentCategory.toDomain(),
    cost.toDomain(),
    weight,
    desc,
    weaponCategory,
    weaponRange,
    damage?.toDomain(),
    properties?.toDomain(),
    armorCategory,
    armorClass?.toDomain(),
    strMinimum,
    stealthDisadvantage,
)

fun List<EquipmentResponse>.toDomain() = this.map {
    it.toDomain()
}