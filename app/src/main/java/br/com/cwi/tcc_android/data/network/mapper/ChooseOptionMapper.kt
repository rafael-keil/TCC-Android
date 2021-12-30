package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.BaseListItemResponse
import br.com.cwi.tcc_android.data.network.entity.ChooseOptionResponse
import br.com.cwi.tcc_android.data.network.entity.StartingEquipmentResponse
import br.com.cwi.tcc_android.domain.entity.BaseListItem

class ChooseOptionMapper {

    fun toDomain(from: ChooseOptionResponse) =
        when (from) {
            is BaseListItemResponse -> {
                BaseListItemMapper().toDomain(from)
            }
            is StartingEquipmentResponse -> {
                StartingEquipmentMapper().toDomain(from)
            }
            else -> BaseListItem("Error", "Error")
        }


    fun toDomain(from: List<ChooseOptionResponse>) = from.map {
        toDomain(it)
    }
}
