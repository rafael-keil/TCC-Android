package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.MultiClassingResponse
import br.com.cwi.tcc_android.domain.entity.MultiClassing

class MultiClassingMapper : DomainMapper<MultiClassingResponse, MultiClassing> {

    override fun toDomain(from: MultiClassingResponse) = MultiClassing(
        prerequisites = AbilityScoreMapper().toDomain(from.prerequisites),
        proficiencies = BaseListItemMapper().toDomain(from.proficiencies),
    )

    override fun toDomain(from: List<MultiClassingResponse>) = from.map {
        toDomain(it)
    }
}