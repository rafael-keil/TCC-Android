package br.com.cwi.tcc_android.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.cwi.tcc_android.data.database.converter.ArmorClassConverter
import br.com.cwi.tcc_android.data.database.converter.CostConverter
import br.com.cwi.tcc_android.data.database.converter.DamageConverter
import br.com.cwi.tcc_android.data.database.converter.StringConverter
import br.com.cwi.tcc_android.data.database.dao.EquipmentDao
import br.com.cwi.tcc_android.data.database.dao.SpellDao
import br.com.cwi.tcc_android.data.database.entity.EquipmentEntity
import br.com.cwi.tcc_android.data.database.entity.SpellEntity

@Database(entities = [SpellEntity::class, EquipmentEntity::class], version = 1)
@TypeConverters(
    StringConverter::class,
    CostConverter::class,
    DamageConverter::class,
    ArmorClassConverter::class,
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getSpellDao(): SpellDao
    abstract fun getEquipmentDao(): EquipmentDao

    companion object {
        private const val DATABASE_NAME = "dnd-db"
        fun create(application: Application): AppDatabase {
            return Room.databaseBuilder(
                application,
                AppDatabase::class.java,
                DATABASE_NAME
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}