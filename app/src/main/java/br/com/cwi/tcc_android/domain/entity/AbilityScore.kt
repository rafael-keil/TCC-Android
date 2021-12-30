package br.com.cwi.tcc_android.domain.entity

import com.squareup.moshi.Json

class AbilityScore(
    @Json(name = "ability_score") val abilityScore: BaseListItem,
    @Json(name = "minimum_score") val minimumScore: Int,
)