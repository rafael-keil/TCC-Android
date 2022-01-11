package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.ArmorClassResponse
import br.com.cwi.tcc_android.domain.entity.ArmorClass

fun ArmorClassResponse.toDomain() = ArmorClass(
    base,
    dexBonus,
)