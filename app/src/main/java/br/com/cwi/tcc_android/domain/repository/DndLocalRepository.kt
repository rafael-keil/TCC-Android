package br.com.cwi.tcc_android.domain.repository

import br.com.cwi.tcc_android.data.database.entity.EquipmentEntity
import br.com.cwi.tcc_android.data.database.entity.SpellEntity

interface DndLocalRepository {
    fun add(spellEntity: SpellEntity)
    fun remove(spellEntity: SpellEntity)
    fun getAllSpells(): List<SpellEntity>

    fun add(equipmentEntity: EquipmentEntity)
    fun remove(equipmentEntity: EquipmentEntity)
    fun getAllEquipments(): List<EquipmentEntity>
}