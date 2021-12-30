package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.BaseListItemResponse
import br.com.cwi.tcc_android.data.network.entity.StartingEquipmentResponse
import br.com.cwi.tcc_android.domain.entity.BaseListItem
import br.com.cwi.tcc_android.domain.entity.StartingEquipment
import com.squareup.moshi.Json

class StartingEquipmentMapper : DomainMapper<StartingEquipmentResponse, StartingEquipment> {

    override fun toDomain(from: StartingEquipmentResponse) = StartingEquipment(
        equipment = BaseListItemMapper().toDomain(from.equipment),
        quantity = from.quantity,
    )

    override fun toDomain(from: List<StartingEquipmentResponse>) = from.map {
        toDomain(it)
    }
}