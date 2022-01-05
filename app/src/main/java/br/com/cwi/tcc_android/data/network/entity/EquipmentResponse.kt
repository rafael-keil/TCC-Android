package br.com.cwi.tcc_android.data.network.entity

import com.squareup.moshi.Json

class EquipmentResponse(
    @Json(name = "name") val name: String,
)