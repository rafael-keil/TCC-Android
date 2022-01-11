package br.com.cwi.tcc_android.data.repository

import br.com.cwi.tcc_android.data.network.DndApi
import br.com.cwi.tcc_android.data.network.mapper.toDomain
import br.com.cwi.tcc_android.domain.entity.Equipment
import br.com.cwi.tcc_android.domain.entity.Spell
import br.com.cwi.tcc_android.domain.repository.DndRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DndRepositoryImpl(
    private val api: DndApi,
) : DndRepository {

    override suspend fun getSpells(): List<Spell> {
        return withContext(Dispatchers.IO) {
            api.getSpells().toDomain()
        }
    }

    override suspend fun getSpell(id: String): Spell {
        return withContext(Dispatchers.IO) {
            api.getSpell(id).toDomain()
        }
    }

    override suspend fun getEquipments(): List<Equipment> {
        return withContext(Dispatchers.IO) {
            api.getEquipments().toDomain()
        }
    }

    override suspend fun getEquipment(id: String): Equipment {
        return withContext(Dispatchers.IO) {
            api.getEquipment(id).toDomain()
        }
    }
}