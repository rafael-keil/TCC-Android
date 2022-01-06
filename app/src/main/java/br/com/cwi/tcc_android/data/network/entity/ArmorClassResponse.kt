package br.com.cwi.tcc_android.data.network.entity

import com.squareup.moshi.Json

class ArmorClassResponse(
    @Json(name = "base") val base: Int,
    @Json(name = "dex_bonus") val dexBonus: Boolean,
)
