package br.com.cwi.tcc_android.domain.repository

import br.com.cwi.tcc_android.domain.entity.*

interface DndRepository {
    suspend fun getClasses(): List<Class>
    suspend fun getEquipment(): List<Equipment>
    suspend fun getMonsters(): List<Monster>
    suspend fun getRaces(): List<Race>
    suspend fun getSpells(): List<Spell>
}