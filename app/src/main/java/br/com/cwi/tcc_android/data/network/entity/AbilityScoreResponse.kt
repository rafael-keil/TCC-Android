package br.com.cwi.tcc_android.data.network.entity

import com.squareup.moshi.Json

class AbilityScoreResponse(
    @Json(name = "ability_score") val abilityScore: BaseListItemResponse,
    @Json(name = "minimum_score") val minimumScore: Int,
)