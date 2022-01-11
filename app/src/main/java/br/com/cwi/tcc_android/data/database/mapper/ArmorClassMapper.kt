package br.com.cwi.tcc_android.data.database.mapper

import br.com.cwi.tcc_android.data.database.entity.ArmorClassEntity
import br.com.cwi.tcc_android.domain.entity.ArmorClass

fun ArmorClassEntity.toDomain() = ArmorClass(
    base,
    dexBonus,
)

fun ArmorClass.toEntity() = ArmorClassEntity(
    base,
    dexBonus,
)