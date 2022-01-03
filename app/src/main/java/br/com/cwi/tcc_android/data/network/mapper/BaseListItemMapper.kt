package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.BaseListItemResponse
import br.com.cwi.tcc_android.domain.entity.BaseListItem

class BaseListItemMapper : DomainMapper<BaseListItemResponse, BaseListItem> {

    override fun toDomain(from: BaseListItemResponse) = BaseListItem(
        id = from.index,
        name = from.name,
    )

    override fun toDomain(from: List<BaseListItemResponse>) = from.map {
        toDomain(it)
    }
}