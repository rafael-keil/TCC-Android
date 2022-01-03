package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.AbilityScoreResponse
import br.com.cwi.tcc_android.domain.entity.AbilityScore

class AbilityScoreMapper{

    fun toDomain(from: AbilityScoreResponse) = AbilityScore(
        abilityScore = BaseListItemMapper().toDomain(from.abilityScore),
        minimumScore = from.minimumScore,
    )

    fun toDomain(from: List<AbilityScoreResponse>?) = from?.map {
        toDomain(it)
    }
}