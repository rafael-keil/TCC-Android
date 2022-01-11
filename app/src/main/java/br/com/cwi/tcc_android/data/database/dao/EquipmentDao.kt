package br.com.cwi.tcc_android.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.cwi.tcc_android.data.database.entity.EquipmentEntity

@Dao
interface EquipmentDao {

    @Insert
    fun add(spellEntity: EquipmentEntity)

    @Delete
    fun remove(spellEntity: EquipmentEntity)

    @Query("SELECT * FROM EquipmentEntity")
    fun getAll(): List<EquipmentEntity>?
}