package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.CostResponse
import br.com.cwi.tcc_android.domain.entity.Cost

class CostMapper : DomainMapper<CostResponse, Cost> {

    override fun toDomain(from: CostResponse) = Cost(
        quantity = from.quantity,
        unit = from.unit
    )

    override fun toDomain(from: List<CostResponse>) = from.map {
        toDomain(it)
    }
}