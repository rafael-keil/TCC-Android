package br.com.cwi.tcc_android.data.network.entity

import com.squareup.moshi.Json

class CostResponse(
    @Json(name = "quantity") val quantity: Int,
    @Json(name = "unit") val unit: String,
)
