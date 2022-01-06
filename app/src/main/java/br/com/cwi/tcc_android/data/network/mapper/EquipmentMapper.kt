package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.EquipmentResponse
import br.com.cwi.tcc_android.domain.entity.Equipment

class EquipmentMapper : DomainMapper<EquipmentResponse, Equipment> {

    private val baseListItemMapper = BaseListItemMapper()

    override fun toDomain(from: EquipmentResponse) = Equipment(
        id = from.id,
        name = from.name,
        equipmentCategory = baseListItemMapper.toDomain(from.equipmentCategory),
        cost = CostMapper().toDomain(from.cost),
        weight = from.weight,
        desc = from.desc,
        //weapons
        weaponCategory = from.weaponCategory,
        weaponRange = from.weaponRange,
        damage = from.damage?.let { DamageMapper().toDomain(it) },
        properties = from.properties?.let { baseListItemMapper.toDomain(it) },
        //armor
        armorCategory = from.armorCategory,
        armorClass = from.armorClass?.let { ArmorClassMapper().toDomain(it) },
        strMinimum = from.strMinimum,
        stealthDisadvantage = from.stealthDisadvantage,
    )

    override fun toDomain(from: List<EquipmentResponse>) = from.map {
        toDomain(it)
    }
}