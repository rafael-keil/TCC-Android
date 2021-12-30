package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.AbilityScoreResponse
import br.com.cwi.tcc_android.domain.entity.AbilityScore

class AbilityScoreMapper : DomainMapper<AbilityScoreResponse, AbilityScore> {

    override fun toDomain(from: AbilityScoreResponse) = AbilityScore(
        abilityScore = BaseListItemMapper().toDomain(from.abilityScore),
        minimumScore = from.minimumScore,
    )

    override fun toDomain(from: List<AbilityScoreResponse>) = from.map {
        toDomain(it)
    }
}