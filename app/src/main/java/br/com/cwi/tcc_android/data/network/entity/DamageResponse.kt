package br.com.cwi.tcc_android.data.network.entity

import com.squareup.moshi.Json

class DamageResponse(
    @Json(name = "damage_dice") val damageDice: String,
    @Json(name = "damage_type") val damageType: BaseListItemResponse,
)
