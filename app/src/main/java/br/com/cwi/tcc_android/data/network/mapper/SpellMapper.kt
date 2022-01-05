package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.SpellResponse
import br.com.cwi.tcc_android.domain.entity.Spell

class SpellMapper : DomainMapper<SpellResponse, Spell> {

    private val baseListItemMapper = BaseListItemMapper()

    override fun toDomain(from: SpellResponse) = Spell(
        id = from.id,
        name = from.name,
        desc = from.desc,
        higherLevel = from.higherLevel,
        range = from.range,
        components = from.components,
        material = from.material,
        ritual = from.ritual,
        duration = from.duration,
        concentration = from.concentration,
        castingTime = from.castingTime,
        level = from.level,
        school = baseListItemMapper.toDomain(from.school),
        classes = baseListItemMapper.toDomain(from.classes)
    )

    override fun toDomain(from: List<SpellResponse>) = from.map {
        toDomain(it)
    }
}