package br.com.cwi.tcc_android.data.database.mapper

import br.com.cwi.tcc_android.data.database.entity.CostEntity
import br.com.cwi.tcc_android.domain.entity.Cost

fun CostEntity.toDomain() = Cost(
    quantity,
    unit,
)

fun Cost.toEntity() = CostEntity(
    quantity,
    unit,
)