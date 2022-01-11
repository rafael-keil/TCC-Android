package br.com.cwi.tcc_android.data.network.mapper

import br.com.cwi.tcc_android.data.network.entity.BaseListItemResponse

fun BaseListItemResponse.toDomain() = name

fun List<BaseListItemResponse>.toDomain() = this.map {
    it.toDomain()
}