package br.com.cwi.tcc_android.data.network.entity

import com.squareup.moshi.Json

class EquipmentOptionResponse(
    @Json(name = "choose") val choose: Int,
    @Json(name = "type") val type: String,
    @Json(name = "from") val from: EquipmentCategoryResponse,
) : ChooseOptionResponse()
