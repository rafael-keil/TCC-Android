package br.com.cwi.tcc_android.data.repository

import br.com.cwi.tcc_android.data.network.DndApi
import br.com.cwi.tcc_android.data.network.mapper.ClassMapper
import br.com.cwi.tcc_android.domain.entity.*
import br.com.cwi.tcc_android.domain.repository.DndRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DndRepositoryImpl(
    private val api: DndApi,
    private val classMapper: ClassMapper,
) : DndRepository {

    override suspend fun getClasses(): List<Class> {
        return withContext(Dispatchers.IO) {
            classMapper.toDomain(api.getClasses())
        }
    }

    override suspend fun getEquipment(): List<Equipment> {
        TODO("Not yet implemented")
    }

    override suspend fun getMonsters(): List<Monster> {
        TODO("Not yet implemented")
    }

    override suspend fun getRaces(): List<Race> {
        TODO("Not yet implemented")
    }

    override suspend fun getSpells(): List<Spell> {
        TODO("Not yet implemented")
    }
}