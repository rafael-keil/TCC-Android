package br.com.cwi.tcc_android.data.repository

import br.com.cwi.tcc_android.data.database.AppDatabase
import br.com.cwi.tcc_android.data.database.mapper.toDomain
import br.com.cwi.tcc_android.data.database.mapper.toEntity
import br.com.cwi.tcc_android.domain.entity.Equipment
import br.com.cwi.tcc_android.domain.entity.Spell
import br.com.cwi.tcc_android.domain.repository.DndLocalRepository

class DndLocalRepositoryImpl(
    appDatabase: AppDatabase
) : DndLocalRepository {

    private val spellDao = appDatabase.getSpellDao()
    private val equipmentDao = appDatabase.getEquipmentDao()

    override fun add(spell: Spell) {
        spellDao.add(spell.toEntity())
    }

    override fun remove(spell: Spell) {
        spellDao.remove(spell.toEntity())
    }

    override fun getAllSpells(): List<Spell> = spellDao.getAll().toDomain()

    override fun add(equipment: Equipment) {
        equipmentDao.add(equipment.toEntity())
    }

    override fun remove(equipment: Equipment) {
        equipmentDao.remove(equipment.toEntity())
    }

    override fun getAllEquipments(): List<Equipment> = equipmentDao.getAll().toDomain()
}