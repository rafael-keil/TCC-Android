package br.com.cwi.tcc_android.domain.repository

import br.com.cwi.tcc_android.domain.entity.Equipment
import br.com.cwi.tcc_android.domain.entity.Spell

interface DndRepository {
    suspend fun getSpells(): List<Spell>
    suspend fun getSpell(id: String): Spell
    suspend fun getEquipments(): List<Equipment>
    suspend fun getEquipment(id: String): Equipment
}