package br.com.cwi.tcc_android.data.network.entity

import com.squareup.moshi.Json

class BaseListItemResponse(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
)
