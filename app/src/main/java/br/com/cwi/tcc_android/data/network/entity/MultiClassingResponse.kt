package br.com.cwi.tcc_android.data.network.entity

import com.squareup.moshi.Json

class MultiClassingResponse(
    @Json(name = "prerequisites") val prerequisites: List<AbilityScoreResponse>,
    @Json(name = "proficiencies") val proficiencies: List<BaseListItemResponse>,
)