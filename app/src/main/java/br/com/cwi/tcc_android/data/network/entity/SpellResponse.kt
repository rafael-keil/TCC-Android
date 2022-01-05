package br.com.cwi.tcc_android.data.network.entity

import com.squareup.moshi.Json

class SpellResponse(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "desc") val desc: List<String>,
    @Json(name = "higher_level") val higherLevel: List<String>?,
    @Json(name = "range") val range: String,
    @Json(name = "components") val components: List<String>,
    @Json(name = "material") val material: String?,
    @Json(name = "ritual") val ritual: Boolean,
    @Json(name = "duration") val duration: String,
    @Json(name = "concentration") val concentration: Boolean,
    @Json(name = "casting_time") val castingTime: String,
    @Json(name = "level") val level: Int,
    @Json(name = "school") val school: BaseListItemResponse,
    @Json(name = "classes") val classes: List<BaseListItemResponse>,
)