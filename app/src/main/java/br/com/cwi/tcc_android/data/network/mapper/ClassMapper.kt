package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.ClassResponse
import br.com.cwi.tcc_android.domain.entity.Class

class ClassMapper : DomainMapper<ClassResponse, Class> {

    private val baseListItemMapper = BaseListItemMapper()
    private val baseChooseMapper = BaseChooseMapper()


    override fun toDomain(from: ClassResponse) = Class(
        id = from.index,
        name = from.name,
        dice = from.hitDie,
        proficiencyChoices = baseChooseMapper.toDomain(from.proficiencyChoices),
        proficiencies = baseListItemMapper.toDomain(from.proficiencies),
        savingThrows = baseListItemMapper.toDomain(from.savingThrows),
        startingEquipment = StartingEquipmentMapper().toDomain(from.startingEquipment),
        startingEquipmentOptions = baseChooseMapper.toDomain(from.startingEquipmentOptions),
        subClasses = baseListItemMapper.toDomain(from.subclasses),
    )

    override fun toDomain(from: List<ClassResponse>) = from.map {
        toDomain(it)
    }
}