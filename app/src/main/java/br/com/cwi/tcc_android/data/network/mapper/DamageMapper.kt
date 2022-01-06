package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.DamageResponse
import br.com.cwi.tcc_android.domain.entity.Damage

class DamageMapper : DomainMapper<DamageResponse, Damage> {

    override fun toDomain(from: DamageResponse) = Damage(
        damageDice = from.damageDice,
        damageType = BaseListItemMapper().toDomain(from.damageType)
    )

    override fun toDomain(from: List<DamageResponse>) = from.map {
        toDomain(it)
    }
}