package br.com.cwi.tcc_android.data.network.entity

import com.squareup.moshi.Json

class ClassResponse(
    @Json(name = "index") val index: String,
    @Json(name = "name") val name: String,
    @Json(name = "hit_die") val hitDie: Int,
    @Json(name = "proficiency_choices") val proficiencyChoices: List<BaseChooseResponse>,
    @Json(name = "proficiencies") val proficiencies: List<BaseListItemResponse>,
    @Json(name = "saving_throws") val savingThrows: List<BaseListItemResponse>,
    @Json(name = "starting_equipment") val startingEquipment: List<StartingEquipmentResponse>,
    @Json(name = "starting_equipment_options") val startingEquipmentOptions: List<BaseChooseResponse>,
    @Json(name = "class_levels") val classLevels: String,
    @Json(name = "multi_classing") val multiClassing: MultiClassingResponse,
    @Json(name = "subclasses") val subclasses: List<BaseListItemResponse>,
    @Json(name = "url") val url: String,
)