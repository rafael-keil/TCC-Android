package br.com.cwi.tcc_android.domain.repository

import br.com.cwi.tcc_android.domain.entity.Equipment
import br.com.cwi.tcc_android.domain.entity.Spell

interface DndLocalRepository {
    fun add(spell: Spell)
    fun remove(spell: Spell)
    fun getAllSpells(): List<Spell>

    fun add(equipment: Equipment)
    fun remove(equipment: Equipment)
    fun getAllEquipments(): List<Equipment>
}