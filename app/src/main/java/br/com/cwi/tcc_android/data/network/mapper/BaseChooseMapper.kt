package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.BaseChooseResponse
import br.com.cwi.tcc_android.domain.entity.BaseChoose

class BaseChooseMapper : DomainMapper<BaseChooseResponse, BaseChoose> {

    override fun toDomain(from: BaseChooseResponse) = BaseChoose(
        choose = from.choose,
        type = from.type,
        from = ChooseOptionMapper().toDomain(from.from),
    )

    override fun toDomain(from: List<BaseChooseResponse>) = from.map {
        toDomain(it)
    }
}