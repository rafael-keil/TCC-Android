package br.com.cwi.tcc_android.domain.entity

import com.squareup.moshi.Json

class StartingEquipment(
    @Json(name = "equipment") val equipment: BaseListItem,
    @Json(name = "quantity") val quantity: Int,
) : ChooseOption()
