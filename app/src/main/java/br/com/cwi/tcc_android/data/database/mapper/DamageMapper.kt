package br.com.cwi.tcc_android.data.database.mapper

import br.com.cwi.tcc_android.data.database.entity.DamageEntity
import br.com.cwi.tcc_android.domain.entity.Damage

fun DamageEntity.toDomain() = Damage(
    damageDice,
    damageType,
)

fun Damage.toEntity() = DamageEntity(
    damageDice,
    damageType,
)