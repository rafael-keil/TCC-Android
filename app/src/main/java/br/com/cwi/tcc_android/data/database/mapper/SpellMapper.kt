package br.com.cwi.tcc_android.data.database.mapper

import br.com.cwi.tcc_android.data.database.entity.SpellEntity
import br.com.cwi.tcc_android.domain.entity.Spell

fun SpellEntity.toDomain() = Spell(
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
    school,
    classes,
)

fun Spell.toEntity() = SpellEntity(
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
    school,
    classes,
)