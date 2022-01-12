package br.com.cwi.tcc_android.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.cwi.tcc_android.data.database.entity.SpellEntity

@Dao
interface SpellDao {

    @Insert
    fun add(spellEntity: SpellEntity)

    @Delete
    fun remove(spellEntity: SpellEntity)

    @Query("SELECT * FROM SpellEntity")
    fun getAll(): List<SpellEntity>
}