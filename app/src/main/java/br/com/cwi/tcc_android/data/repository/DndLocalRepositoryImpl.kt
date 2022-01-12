package br.com.cwi.tcc_android.data.repository

import br.com.cwi.tcc_android.data.database.AppDatabase
import br.com.cwi.tcc_android.data.database.entity.EquipmentEntity
import br.com.cwi.tcc_android.data.database.entity.SpellEntity
import br.com.cwi.tcc_android.domain.repository.DndLocalRepository

class DndLocalRepositoryImpl(
    appDatabase: AppDatabase
) : DndLocalRepository {

    private val spellDao = appDatabase.getSpellDao()
    private val equipmentDao = appDatabase.getEquipmentDao()

    override fun add(spellEntity: SpellEntity) {
        spellDao.add(spellEntity)
    }

    override fun remove(spellEntity: SpellEntity) {
        spellDao.remove(spellEntity)
    }

    override fun getAllSpells(): List<SpellEntity> = spellDao.getAll()

    override fun add(equipmentEntity: EquipmentEntity) {
        equipmentDao.add(equipmentEntity)
    }

    override fun remove(equipmentEntity: EquipmentEntity) {
        equipmentDao.remove(equipmentEntity)
    }

    override fun getAllEquipments(): List<EquipmentEntity> = equipmentDao.getAll()
}