package br.com.cwi.tcc_android.data.network.entity

import com.squareup.moshi.Json

class EquipmentCategoryResponse(
    @Json(name = "equipment_category") val equipmentCategory: BaseChooseResponse,
)