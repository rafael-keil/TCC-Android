package br.com.cwi.tcc_android.data.network.entity

import com.squareup.moshi.Json

class StartingEquipmentResponse(
    @Json(name = "equipment") val equipment: BaseListItemResponse,
    @Json(name = "quantity") val quantity: Int,
) : ChooseOptionResponse()
