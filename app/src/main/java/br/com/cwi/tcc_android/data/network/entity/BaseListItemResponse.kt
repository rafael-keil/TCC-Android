package br.com.cwi.tcc_android.data.network.entity

import com.squareup.moshi.Json

class BaseListItemResponse(
    @Json(name = "index") val index: String,
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String,
) : ChooseOptionResponse()
