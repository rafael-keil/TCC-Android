package br.com.cwi.tcc_android.domain.entity

abstract class BaseCompendiumItem(
    val id: String,
    val name: String,
    var isFavorite: Boolean = false
)
