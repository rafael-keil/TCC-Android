package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.DamageResponse
import br.com.cwi.tcc_android.domain.entity.Damage

fun DamageResponse.toDomain() = Damage(
    damageDice,
    damageType.toDomain(),
)