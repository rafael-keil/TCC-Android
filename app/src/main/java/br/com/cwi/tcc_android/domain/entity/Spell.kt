package br.com.cwi.tcc_android.domain.entity

class Spell(
    id: String,
    name: String,
    val desc: List<String>,
    val higherLevel: List<String>?,
    val range: String,
    val components: List<String>,
    val material: String?,
    val duration: String,
    val castingTime: String,
    val level: Int,
    val school: BaseListItem,
    val classes: List<BaseListItem>,
) : BaseCompendiumItem(
    id = id,
    name = name
)