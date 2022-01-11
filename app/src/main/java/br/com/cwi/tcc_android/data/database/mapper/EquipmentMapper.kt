package br.com.cwi.tcc_android.data.database.mapper

import br.com.cwi.tcc_android.data.database.entity.EquipmentEntity
import br.com.cwi.tcc_android.domain.entity.Equipment

fun EquipmentEntity.toDomain() = Equipment(
    id,
    name,
    equipmentCategory,
    cost.toDomain(),
    weight,
    desc,
    weaponCategory,
    weaponRange,
    damage?.toDomain(),
    properties,
    armorCategory,
    armorClass?.toDomain(),
    strMinimum,
    stealthDisadvantage,
)

fun Equipment.toEntity() = EquipmentEntity(
    id,
    name,
    equipmentCategory,
    cost.toEntity(),
    weight,
    desc,
    weaponCategory,
    weaponRange,
    damage?.toEntity(),
    properties,
    armorCategory,
    armorClass?.toEntity(),
    strMinimum,
    stealthDisadvantage,
)