package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.EquipmentResponse
import br.com.cwi.tcc_android.domain.entity.Equipment

class EquipmentMapper : DomainMapper<EquipmentResponse, Equipment> {

    override fun toDomain(from: EquipmentResponse) = Equipment(
        name = from.name,
    )

    override fun toDomain(from: List<EquipmentResponse>) = from.map {
        toDomain(it)
    }
}