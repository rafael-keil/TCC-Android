package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.SpellResponse
import br.com.cwi.tcc_android.domain.entity.Spell

fun SpellResponse.toDomain() = Spell(
    id,
    name,
    desc,
    higherLevel,
    range,
    components,
    material,
    duration,
    castingTime,
    level,
    school.toDomain(),
    classes.toDomain(),
)

fun List<SpellResponse>.toDomain() = this.map {
    it.toDomain()
}