package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.ArmorClassResponse
import br.com.cwi.tcc_android.domain.entity.ArmorClass

class ArmorClassMapper : DomainMapper<ArmorClassResponse, ArmorClass> {

    override fun toDomain(from: ArmorClassResponse) = ArmorClass(
        base = from.base,
        dexBonus = from.dexBonus
    )

    override fun toDomain(from: List<ArmorClassResponse>) = from.map {
        toDomain(it)
    }
}