package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.CostResponse
import br.com.cwi.tcc_android.domain.entity.Cost

fun CostResponse.toDomain() = Cost(
    quantity,
    unit,
)