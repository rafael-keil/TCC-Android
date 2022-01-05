package br.com.cwi.tcc_android.domain.entity

class Spell(
    val id: String,
    val name: String,
    val desc: List<String>,
    val higherLevel: List<String>?,
    val range: String,
    val components: List<String>,
    val material: String?,
    val ritual: Boolean,
    val duration: String,
    val concentration: Boolean,
    val castingTime: String,
    val level: Int,
    val school: BaseListItem,
    val classes: List<BaseListItem>,
)